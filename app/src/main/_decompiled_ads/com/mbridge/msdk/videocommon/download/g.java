package com.mbridge.msdk.videocommon.download;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.al;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: H5DownLoadManager.java */
/* JADX INFO: loaded from: classes4.dex */
public class g {
    private static g c;
    private CopyOnWriteArrayList<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentMap<String, com.mbridge.msdk.videocommon.download.b> f2665b;
    private k d;
    private h e;
    private boolean f;
    private final String g = CampaignEx.JSON_KEY_LOCAL_REQUEST_ID;
    private final String h = "down_type";

    /* JADX INFO: compiled from: H5DownLoadManager.java */
    public interface a {
        void a(String str, String str2);

        void a(String str, boolean z);
    }

    /* JADX INFO: compiled from: H5DownLoadManager.java */
    public interface b extends a {
    }

    /* JADX INFO: compiled from: H5DownLoadManager.java */
    public interface c {
        void a();

        void a(String str);

        void a(String str, byte[] bArr, String str2);
    }

    /* JADX INFO: compiled from: H5DownLoadManager.java */
    public interface d extends a {
    }

    private g() {
        this.f = false;
        try {
            this.d = k.a();
            this.e = h.a.a;
            this.a = new CopyOnWriteArrayList<>();
            this.f2665b = new ConcurrentHashMap();
            com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
            if (cVarB != null) {
                this.f = cVarB.i(1);
            }
        } catch (Throwable th) {
            aa.b("H5DownLoadManager", th.getMessage(), th);
        }
    }

    public static synchronized g a() {
        if (c == null) {
            c = new g();
        }
        return c;
    }

    public final String a(String str) {
        k kVar = this.d;
        if (kVar != null) {
            return kVar.a(str);
        }
        return null;
    }

    private void a(Map<String, String> map, String str, final d dVar) {
        String str2;
        String str3;
        String str4 = "";
        if (this.f) {
            if (TextUtils.isEmpty(str)) {
                if (dVar != null) {
                    dVar.a(str, "zip url is null");
                    return;
                }
                return;
            }
            try {
                new URL(str);
                if (map != null) {
                    str2 = map.containsKey(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID) ? map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID) : "";
                    str3 = map.containsKey("down_type") ? map.get("down_type") : "";
                } else {
                    str2 = "";
                    str3 = str2;
                }
                String strB = com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_RES);
                String md5 = SameMD5.getMD5(al.a(str));
                String str5 = strB + RemoteSettings.FORWARD_SLASH_STRING;
                final String str6 = strB + RemoteSettings.FORWARD_SLASH_STRING + md5;
                MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str, md5 + ".zip", 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_ZIP)).withReadTimeout(30000L).withConnectTimeout(20000L).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(str5).with(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, str2).with("down_type", str3).withDownloadStateListener(new OnDownloadStateListener() { // from class: com.mbridge.msdk.videocommon.download.g.1
                    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                    public final void onDownloadStart(DownloadMessage downloadMessage) {
                    }

                    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                    public final void onDownloadComplete(DownloadMessage downloadMessage) {
                        try {
                            if (TextUtils.isEmpty(k.a().a(downloadMessage.getDownloadUrl()))) {
                                MBResourceManager.getInstance().unZip(downloadMessage.getSaveFilePath(), str6);
                            }
                            d dVar2 = dVar;
                            if (dVar2 != null) {
                                dVar2.a(downloadMessage.getDownloadUrl(), false);
                            }
                        } catch (IOException e) {
                            d dVar3 = dVar;
                            if (dVar3 != null) {
                                dVar3.a(downloadMessage.getDownloadUrl(), e.getMessage());
                            }
                        }
                    }

                    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                    public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
                        if (!TextUtils.isEmpty(k.a().a(downloadMessage.getDownloadUrl()))) {
                            d dVar2 = dVar;
                            if (dVar2 != null) {
                                dVar2.a(downloadMessage.getDownloadUrl(), false);
                                return;
                            }
                            return;
                        }
                        d dVar3 = dVar;
                        if (dVar3 != null) {
                            dVar3.a(downloadMessage.getDownloadUrl(), downloadError.getException().getMessage());
                        }
                    }
                }).build().start();
                return;
            } catch (Exception unused) {
                if (dVar != null) {
                    dVar.a(str, "zip url is unlawful");
                    return;
                }
                return;
            }
        }
        HashMap map2 = new HashMap();
        if (map != null) {
            try {
                if (map.size() > 0) {
                    String str7 = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                    try {
                        map2.put("type", map.get("down_type"));
                    } catch (Exception unused2) {
                    }
                    str4 = str7;
                }
            } catch (Exception unused3) {
            }
        }
        try {
            try {
                if (TextUtils.isEmpty(this.d.a(str))) {
                    map2.put("cache", "2");
                    if (this.f2665b.containsKey(str)) {
                        com.mbridge.msdk.videocommon.download.b bVar = this.f2665b.get(str);
                        if (bVar != null) {
                            bVar.a(dVar);
                        }
                        if (!TextUtils.isEmpty(str4)) {
                            com.mbridge.msdk.foundation.same.report.m.a().a("2000153", str4, map2);
                        }
                    } else {
                        com.mbridge.msdk.videocommon.download.b bVar2 = new com.mbridge.msdk.videocommon.download.b(this.f2665b, this.d, dVar, str);
                        this.f2665b.put(str, bVar2);
                        e.a(str, bVar2, true);
                    }
                }
                map2.put("cache", "1");
                if (dVar != null) {
                    dVar.a(str, true);
                }
                if (!TextUtils.isEmpty(str4)) {
                    com.mbridge.msdk.foundation.same.report.m.a().a("2000153", str4, map2);
                }
            } catch (Exception unused4) {
            }
        } catch (Exception e) {
            if (dVar != null) {
                dVar.a(str, "downloadzip failed");
            }
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final void a(final String str, final a aVar) {
        if (this.f) {
            if (TextUtils.isEmpty(str)) {
                if (aVar != null) {
                    aVar.a("zip url is null", str);
                    return;
                }
                return;
            }
            try {
                new URL(str);
                MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str, SameMD5.getMD5(al.a(str)) + ".html", 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_HTML)).withReadTimeout(30000L).withConnectTimeout(20000L).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML) + RemoteSettings.FORWARD_SLASH_STRING).withDownloadStateListener(new OnDownloadStateListener() { // from class: com.mbridge.msdk.videocommon.download.g.3
                    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                    public final void onDownloadStart(DownloadMessage downloadMessage) {
                    }

                    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                    public final void onDownloadComplete(DownloadMessage downloadMessage) {
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a(str, false);
                        }
                    }

                    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                    public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a(str, downloadError.getException().getMessage());
                        }
                    }
                }).build().start();
                return;
            } catch (Exception unused) {
                if (aVar != null) {
                    aVar.a("zip url is unlawful", str);
                    return;
                }
                return;
            }
        }
        try {
            aa.d("H5DownLoadManager", "download url:" + str);
            if (this.a.contains(str)) {
                return;
            }
            this.a.add(str);
            f.a.a.a(new com.mbridge.msdk.foundation.same.e.a() { // from class: com.mbridge.msdk.videocommon.download.g.2
                @Override // com.mbridge.msdk.foundation.same.e.a
                public final void b() {
                }

                @Override // com.mbridge.msdk.foundation.same.e.a
                public final void a() {
                    if (!TextUtils.isEmpty(g.this.e.b(str))) {
                        g.this.a.remove(str);
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a(str, true);
                            return;
                        }
                        return;
                    }
                    e.a(str, new c() { // from class: com.mbridge.msdk.videocommon.download.g.2.1
                        @Override // com.mbridge.msdk.videocommon.download.g.c
                        public final void a() {
                        }

                        @Override // com.mbridge.msdk.videocommon.download.g.c
                        public final void a(String str2, byte[] bArr, String str3) {
                            try {
                                g.this.a.remove(str3);
                                if (bArr == null || bArr.length <= 0) {
                                    return;
                                }
                                if (g.this.e.a(str3, bArr)) {
                                    if (aVar != null) {
                                        aVar.a(str3, false);
                                    }
                                } else if (aVar != null) {
                                    aVar.a(str3, "save file failed");
                                }
                            } catch (Exception e) {
                                if (MBridgeConstans.DEBUG) {
                                    e.printStackTrace();
                                }
                                if (aVar != null) {
                                    aVar.a(str3, e.getMessage());
                                }
                            }
                        }

                        @Override // com.mbridge.msdk.videocommon.download.g.c
                        public final void a(String str2) {
                            try {
                                g.this.a.remove(str);
                                if (aVar != null) {
                                    aVar.a(str, str2);
                                }
                            } catch (Exception e) {
                                if (MBridgeConstans.DEBUG) {
                                    e.printStackTrace();
                                }
                                if (aVar != null) {
                                    aVar.a(str, str2);
                                }
                            }
                        }
                    }, true);
                }
            });
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    public final void b(String str, a aVar) {
        a(new HashMap(), str, aVar);
    }

    public final void a(Map<String, String> map, String str, a aVar) {
        try {
            if (Patterns.WEB_URL.matcher(str).matches() || URLUtil.isValidUrl(str)) {
                String path = Uri.parse(str).getPath();
                if (!TextUtils.isEmpty(path)) {
                    if (path.toLowerCase().endsWith(".zip")) {
                        a(map, str, (d) aVar);
                        return;
                    } else {
                        a(str, aVar);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (aVar != null) {
            aVar.a(str, "The URL does not contain a path ");
        }
    }

    public final String b(String str) {
        try {
            if (Patterns.WEB_URL.matcher(str).matches() || URLUtil.isValidUrl(str)) {
                Uri uri = Uri.parse(str);
                String path = uri.getPath();
                if (TextUtils.isEmpty(path) || !TextUtils.isEmpty(uri.getQueryParameter("urlDebug"))) {
                    return str;
                }
                if (path.toLowerCase().endsWith(".zip")) {
                    return a(str);
                }
                h hVar = this.e;
                return hVar != null ? hVar.a(str) : str;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
