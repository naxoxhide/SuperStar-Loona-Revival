package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.out.Campaign;

/* JADX INFO: compiled from: VideoDao.java */
/* JADX INFO: loaded from: classes4.dex */
public final class p extends a<Campaign> {
    private static p a;

    private p(g gVar) {
        super(gVar);
    }

    public static synchronized p a(g gVar) {
        if (a == null) {
            a = new p(gVar);
        }
        return a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    public final synchronized com.mbridge.msdk.foundation.entity.m a(String str) {
        com.mbridge.msdk.foundation.entity.m mVar;
        Exception e;
        Cursor cursorRawQuery;
        ?? r1 = 0;
        mVar = null;
        com.mbridge.msdk.foundation.entity.m mVar2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                cursorRawQuery = getReadableDatabase().rawQuery("SELECT * FROM video WHERE video_url = '" + str + "'", null);
                if (cursorRawQuery != null) {
                    try {
                        if (cursorRawQuery.getCount() > 0) {
                            mVar = new com.mbridge.msdk.foundation.entity.m();
                            while (cursorRawQuery.moveToNext()) {
                                try {
                                    mVar.a(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("video_url")));
                                    mVar.b(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("video_state")));
                                    mVar.b(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("pregeress_size")));
                                    mVar.a(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("total_size")));
                                    mVar.b(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("video_path")));
                                    mVar.a(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("video_download_start")) * 1000);
                                } catch (Exception e2) {
                                    e = e2;
                                    aa.d("VideoDao", e.getLocalizedMessage());
                                    if (cursorRawQuery != null) {
                                        try {
                                            cursorRawQuery.close();
                                        } catch (Exception unused) {
                                        }
                                    }
                                    mVar2 = mVar;
                                }
                            }
                            mVar2 = mVar;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        mVar = null;
                    }
                }
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Exception unused2) {
                    }
                }
            } catch (Exception e4) {
                mVar = null;
                e = e4;
                cursorRawQuery = null;
            } catch (Throwable th) {
                th = th;
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
            return mVar2;
        } catch (Throwable th2) {
            th = th2;
            r1 = str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00a5 A[EXC_TOP_SPLITTER, PHI: r0
      0x00a5: PHI (r0v3 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v4 android.database.Cursor) binds: [B:24:0x00b0, B:17:0x00a3] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public final synchronized com.mbridge.msdk.foundation.entity.m a(String str, String str2) {
        try {
            Cursor cursorRawQuery = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m();
            try {
                cursorRawQuery = getReadableDatabase().rawQuery("SELECT * FROM video" + (" WHERE video_url = '" + str + "'"), null);
                if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                    while (cursorRawQuery.moveToNext()) {
                        mVar.a(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("video_url")));
                        mVar.b(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("video_state")));
                        mVar.b(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("pregeress_size")));
                        mVar.a(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("total_size")));
                        mVar.b(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("video_path")));
                        mVar.a(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("video_download_start")) * 1000);
                    }
                }
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
            return mVar;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void b(String str) {
        try {
            String str2 = "video_url = '" + str + "'";
            if (getWritableDatabase() == null) {
            } else {
                getWritableDatabase().delete("video", str2, null);
            }
        } catch (Exception unused) {
        }
    }

    public final synchronized void a(String str, long j) {
        if (j == 0) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("video_download_start", Long.valueOf(j / 1000));
            if (b(str, "")) {
                getWritableDatabase().update("video", contentValues, "video_url = '" + str + "'", null);
            }
        } catch (Exception unused) {
        }
    }

    public final synchronized long a(CampaignEx campaignEx, long j, String str, int i) {
        if (campaignEx == null) {
            return 0L;
        }
        try {
            if (getWritableDatabase() == null) {
                return -1L;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("unitid", campaignEx.getCampaignUnitId());
            contentValues.put("id", campaignEx.getId());
            contentValues.put(CampaignEx.JSON_KEY_PACKAGE_NAME, campaignEx.getPackageName());
            contentValues.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, campaignEx.getAppName());
            contentValues.put("app_desc", campaignEx.getAppDesc());
            contentValues.put(CampaignEx.JSON_KEY_APP_SIZE, campaignEx.getSize());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
            contentValues.put(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, campaignEx.getImageUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
            contentValues.put(CampaignEx.JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
            contentValues.put(DownloadModel.DOWNLOAD_URL, campaignEx.getClickURL());
            contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
            contentValues.put(CampaignEx.JSON_KEY_ST_TS, Long.valueOf(campaignEx.getTimestamp()));
            contentValues.put("template", Integer.valueOf(campaignEx.getTemplate()));
            contentValues.put(CampaignEx.JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
            contentValues.put(CampaignEx.JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
            contentValues.put(CampaignEx.JSON_KEY_LINK_TYPE, Integer.valueOf(campaignEx.getLinkType()));
            contentValues.put("star", Double.valueOf(campaignEx.getRating()));
            contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval()));
            contentValues.put("level", Integer.valueOf(campaignEx.getCacheLevel()));
            contentValues.put("adSource", Integer.valueOf(campaignEx.getType()));
            contentValues.put("ad_call", campaignEx.getAdCall());
            contentValues.put("fc_a", Integer.valueOf(campaignEx.getFca()));
            contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
            contentValues.put("video_url", campaignEx.getVideoUrlEncode());
            contentValues.put("total_size", Long.valueOf(j));
            contentValues.put("video_state", Integer.valueOf(i));
            contentValues.put("video_download_start", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("ad_bid_token", campaignEx.getBidToken());
            if (!TextUtils.isEmpty(str)) {
                contentValues.put("video_path", str);
            }
            if (b(campaignEx.getVideoUrlEncode(), campaignEx.getId())) {
                return 0L;
            }
            return getWritableDatabase().insert("video", null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    private synchronized boolean b(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            str3 = "SELECT id FROM video WHERE video_url = '" + str + "'";
        } else {
            str3 = "SELECT id FROM video WHERE video_url = '" + str + "' AND id = " + str2;
        }
        Cursor cursorRawQuery = getReadableDatabase().rawQuery(str3, null);
        if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
            try {
                cursorRawQuery.close();
            } catch (Exception unused) {
            }
            return true;
        }
        if (cursorRawQuery != null) {
            try {
                cursorRawQuery.close();
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    public final synchronized long a(String str, long j, int i) {
        int iUpdate = -1;
        try {
            if (getWritableDatabase() == null) {
                return -1;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("pregeress_size", Long.valueOf(j));
            contentValues.put("video_state", Integer.valueOf(i));
            if (b(str, "")) {
                String str2 = "video_url = '" + str + "'";
                synchronized (new Object()) {
                    iUpdate = getWritableDatabase().update("video", contentValues, str2, null);
                }
            }
        } catch (Exception unused) {
        }
        return iUpdate;
    }

    public final synchronized long b(String str, long j) {
        int iUpdate = -1;
        try {
            if (getWritableDatabase() == null) {
                return -1;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("total_size", Long.valueOf(j));
            if (b(str, "")) {
                String str2 = "video_url = '" + str + "'";
                synchronized (new Object()) {
                    iUpdate = getWritableDatabase().update("video", contentValues, str2, null);
                }
            }
        } catch (Exception unused) {
        }
        return iUpdate;
    }
}
