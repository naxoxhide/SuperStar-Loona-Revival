package com.mbridge.msdk.foundation.download.core;

import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResponse;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.download.utils.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.aa;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadTask implements IDownloadTask {
    private IDatabaseHelper _databaseHelper;
    private volatile DownloadMessage _downloadMessage;
    private DownloaderReporter.Builder _downloaderReporter;
    private volatile DownloadRequest _request;
    private volatile DownloadModel _downloadModel = null;
    private volatile boolean _needUpdateDownloadModel = true;
    private final Object _object = new Object();
    private String localRid = "";
    private String downType = "";
    private final String METRICS_D_LOAD_TYPE = "type";

    private DownloadTask(DownloadRequest downloadRequest, DownloadMessage downloadMessage, IDatabaseHelper iDatabaseHelper) {
        this._request = downloadRequest;
        this._downloadMessage = downloadMessage;
        this._databaseHelper = iDatabaseHelper;
    }

    static IDownloadTask create(DownloadRequest downloadRequest, DownloadMessage downloadMessage, IDatabaseHelper iDatabaseHelper) {
        return new DownloadTask(downloadRequest, downloadMessage, iDatabaseHelper);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00df A[Catch: Exception -> 0x00f6, TryCatch #4 {Exception -> 0x00f6, blocks: (B:33:0x00ce, B:34:0x00d5, B:36:0x00df, B:37:0x00eb), top: B:68:0x00ce }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00eb A[Catch: Exception -> 0x00f6, TRY_LEAVE, TryCatch #4 {Exception -> 0x00f6, blocks: (B:33:0x00ce, B:34:0x00d5, B:36:0x00df, B:37:0x00eb), top: B:68:0x00ce }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0178 A[Catch: Exception -> 0x018f, TryCatch #0 {Exception -> 0x018f, blocks: (B:41:0x0167, B:42:0x016e, B:44:0x0178, B:45:0x0184), top: B:61:0x0167 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0184 A[Catch: Exception -> 0x018f, TRY_LEAVE, TryCatch #0 {Exception -> 0x018f, blocks: (B:41:0x0167, B:42:0x016e, B:44:0x0178, B:45:0x0184), top: B:61:0x0167 }] */
    @Override // com.mbridge.msdk.foundation.download.core.IDownloadTask
    public DownloadResponse run() {
        DownloaderReporter.Builder builder = new DownloaderReporter.Builder(DownloadCommon.DOWNLOAD_REPORT_KEY);
        this._downloaderReporter = builder;
        builder.add(DownloadCommon.DOWNLOAD_REPORT_RETRY_COUNT, String.valueOf(this._request.getRetryedCount()));
        String downloadId = this._request.getDownloadId();
        if (this._request.getStatus() == DownloadStatus.CANCELLED) {
            DownloadResponse downloadResponse = new DownloadResponse();
            downloadResponse.setCancelled(true);
            return downloadResponse;
        }
        if (this._downloadMessage.getDownloadRate() == 0) {
            DownloadResponse downloadResponse2 = new DownloadResponse();
            downloadResponse2.setSuccessful(true);
            return downloadResponse2;
        }
        String cacheDirectoryPath = this._request.getCacheDirectoryPath();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this._databaseHelper.find(downloadId, cacheDirectoryPath, new IDatabaseHelper.IDatabaseListener() { // from class: com.mbridge.msdk.foundation.download.core.DownloadTask.1
            @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper.IDatabaseListener
            public void onDatabase(DownloadModel downloadModel) {
                synchronized (DownloadTask.this._object) {
                    if (DownloadTask.this._needUpdateDownloadModel) {
                        DownloadTask.this._downloadModel = downloadModel;
                    }
                }
                countDownLatch.countDown();
            }
        });
        try {
            try {
                countDownLatch.await(10L, TimeUnit.SECONDS);
                synchronized (this._object) {
                    this._needUpdateDownloadModel = false;
                }
            } catch (Throwable th) {
                synchronized (this._object) {
                    this._needUpdateDownloadModel = false;
                    throw th;
                }
            }
        } catch (InterruptedException e) {
            GlobalComponent.getInstance().getLogger().log(IDownloadTask.TAG, "" + e.getMessage());
            countDownLatch.countDown();
            this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_QUERY_TIMEOUT, Boolean.TRUE.toString());
            synchronized (this._object) {
                this._needUpdateDownloadModel = false;
            }
        }
        DownloadResponse downloadResponseRun = FindFileFromCache.create(this._request, this._downloadModel, this._databaseHelper, downloadId, this._downloadMessage, this._downloaderReporter).run();
        Map<String, String> mapCreateDownLoadMetricsParams = createDownLoadMetricsParams();
        if (!Objects.isNotNull(downloadResponseRun) || !downloadResponseRun.isSuccessful()) {
            if (mapCreateDownLoadMetricsParams != null) {
                try {
                    mapCreateDownLoadMetricsParams.put("cache", "2");
                    if (this.downType.equals("1")) {
                        m.a().b("2000153", this.localRid, mapCreateDownLoadMetricsParams);
                    } else {
                        m.a().a("2000153", this.localRid, mapCreateDownLoadMetricsParams);
                    }
                } catch (Exception unused) {
                }
            } else if (this.downType.equals("1")) {
                m.a().b("2000153", this.localRid, mapCreateDownLoadMetricsParams);
            } else {
                m.a().a("2000153", this.localRid, mapCreateDownLoadMetricsParams);
            }
            this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_RETURN_FROM_CACHE, Boolean.FALSE.toString());
            return OkHTTPFileDownloadTask.create(this._request, this._downloadModel, this._databaseHelper, this._downloadMessage, this._downloaderReporter).run();
        }
        if (mapCreateDownLoadMetricsParams != null) {
            try {
                mapCreateDownLoadMetricsParams.put("cache", "1");
                if (this.downType.equals("1")) {
                    m.a().b("2000153", this.localRid, mapCreateDownLoadMetricsParams);
                } else {
                    m.a().a("2000153", this.localRid, mapCreateDownLoadMetricsParams);
                }
            } catch (Exception unused2) {
            }
        } else if (this.downType.equals("1")) {
            m.a().b("2000153", this.localRid, mapCreateDownLoadMetricsParams);
        } else {
            m.a().a("2000153", this.localRid, mapCreateDownLoadMetricsParams);
        }
        sendProgress(this._request, this._downloadMessage);
        this._downloadModel = DownloadModel.create(this._downloadModel.getDownloadId(), this._downloadModel.getDownloadUrl(), this._downloadModel.getResourceUrl(), this._downloadModel.getEtag(), this._downloadModel.getSaveDirectorPath(), this._downloadModel.getSaveFileName(), this._request.getTotalBytes(), this._downloadModel.getDownloadedBytes(), this._downloadModel.getDownloadRate(), this._downloadModel.getUsageCounter() + 1, this._downloadModel.getDownloadResourceType());
        this._databaseHelper.update(this._downloadModel, cacheDirectoryPath);
        this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_RETURN_FROM_CACHE, Boolean.TRUE.toString());
        this._downloaderReporter.build().report();
        return downloadResponseRun;
    }

    private void sendProgress(DownloadRequest downloadRequest, DownloadMessage downloadMessage) {
        if (downloadRequest.getStatus() != DownloadStatus.CANCELLED) {
            long downloadedBytes = this._request.getDownloadedBytes();
            long totalBytes = this._request.getTotalBytes();
            downloadRequest.handlerProcessEvent(downloadMessage, new DownloadProgress(downloadedBytes, totalBytes, Utils.getDownloadRate(totalBytes, downloadedBytes)));
        }
    }

    private Map<String, String> createDownLoadMetricsParams() {
        HashMap map = new HashMap();
        try {
            this.localRid = this._request.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, "");
            String str = this._request.get("down_type", "");
            this.downType = str;
            map.put("type", str);
        } catch (Exception e) {
            aa.d(IDownloadTask.TAG, e.getMessage());
        }
        return map;
    }
}
