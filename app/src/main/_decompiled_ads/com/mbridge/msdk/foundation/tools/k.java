package com.mbridge.msdk.foundation.tools;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: DynamicViewResourceManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k {
    static final List<String> a;

    /* JADX INFO: compiled from: DynamicViewResourceManager.java */
    public interface a {
        void a(String str, DownloadError downloadError);

        void a(String str, String str2, String str3, boolean z);
    }

    static {
        ArrayList arrayList = new ArrayList(4);
        a = arrayList;
        if (arrayList != null) {
            arrayList.add("mbridge_splash_native_template_v_v1.xml");
            arrayList.add("mbridge_splash_native_template_h_v1.xml");
        }
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String path = new URL(str).getPath();
            String strSubstring = path.substring(path.lastIndexOf(47) + 1);
            if (TextUtils.isEmpty(strSubstring)) {
                return "";
            }
            String strReplace = strSubstring.replace(".zip", "");
            List<String> list = a;
            return (list == null || list.contains(strReplace)) ? "" : strReplace;
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0073  */
    /* JADX WARN: Code duplicated, block: B:53:0x016b A[Catch: Exception -> 0x0176, TRY_LEAVE, TryCatch #3 {Exception -> 0x0176, blocks: (B:51:0x0166, B:53:0x016b), top: B:66:0x0166 }] */
    /* JADX WARN: Code duplicated, block: B:80:? A[RETURN, SYNTHETIC] */
    public static void a(int i, String str, final String str2, final a aVar, CampaignEx campaignEx) {
        String strB;
        String path;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            strB = b(i, str, str2);
        } catch (Exception unused) {
            strB = "";
        }
        final String str3 = com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_XML) + File.separator;
        File file = null;
        try {
            if (!TextUtils.isEmpty(strB)) {
                file = new File(str3, strB);
            }
        } catch (Exception unused2) {
        }
        if (file == null || !file.exists()) {
            file = new File(str3 + File.separator + strB.replace(".xml", ""), strB);
        }
        if (file != null) {
            try {
                if (file.exists()) {
                    path = file.getPath();
                } else {
                    path = "";
                }
            } catch (Exception unused3) {
            }
        } else {
            path = "";
        }
        HashMap map = new HashMap();
        try {
            try {
                try {
                    if (i == 0) {
                        map.put("type", "1");
                    } else if (i == 1) {
                        map.put("type", "2");
                    } else {
                        if (i == 2) {
                            map.put("type", "3");
                        }
                        if (!TextUtils.isEmpty(path) || TextUtils.isEmpty(strB)) {
                            String path2 = new URL(str2).getPath();
                            final String strSubstring = path2.substring(path2.lastIndexOf(47) + 1);
                            final String strReplace = strSubstring.replace(".zip", "");
                            aa.a("test_zip_download ", "start download path： " + str3 + strSubstring);
                            MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str2, strSubstring, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER)).withReadTimeout(30000L).withConnectTimeout(20000L).withDownloadPriority(DownloadPriority.MEDIUM).withHttpRetryCounter(1).withDirectoryPathInternal(str3).withDownloadStateListener(new OnDownloadStateListener() { // from class: com.mbridge.msdk.foundation.tools.k.1
                                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                                public final void onDownloadStart(DownloadMessage downloadMessage) {
                                }

                                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                                public final void onDownloadComplete(DownloadMessage downloadMessage) {
                                    try {
                                        String str4 = str3 + File.separator + strSubstring;
                                        String str5 = str3;
                                        MBResourceManager.getInstance().unZip(str4, str5);
                                        a aVar2 = aVar;
                                        if (aVar2 != null) {
                                            try {
                                                aVar2.a(str2, str5, strReplace, false);
                                            } catch (Exception e) {
                                                aa.d("DynamicViewResourceManager", e.getMessage());
                                            }
                                        }
                                    } catch (Exception unused4) {
                                    }
                                }

                                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                                public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
                                    a aVar2 = aVar;
                                    if (aVar2 != null) {
                                        try {
                                            aVar2.a(str2, downloadError);
                                        } catch (Exception e) {
                                            aa.d("DynamicViewResourceManager", e.getMessage());
                                        }
                                    }
                                }
                            }).build().start();
                            map.put("cache", "2");
                            if (campaignEx != null) {
                                com.mbridge.msdk.foundation.same.report.m.a().a("2000153", campaignEx.getCurrentLRid(), map);
                                return;
                            }
                            return;
                        }
                        if (aVar != null) {
                            try {
                                aVar.a(str2, path, strB, true);
                            } catch (Exception e) {
                                aa.d("DynamicViewResourceManager", e.getMessage());
                            }
                            try {
                                map.put("cache", "1");
                                if (campaignEx != null) {
                                    if (i == 0) {
                                        com.mbridge.msdk.foundation.same.report.m.a().b("2000153", campaignEx.getCurrentLRid(), map);
                                    } else {
                                        com.mbridge.msdk.foundation.same.report.m.a().a("2000153", campaignEx.getCurrentLRid(), map);
                                    }
                                }
                                return;
                            } catch (Exception unused4) {
                                return;
                            }
                        }
                        return;
                    }
                    String path3 = new URL(str2).getPath();
                    final String strSubstring2 = path3.substring(path3.lastIndexOf(47) + 1);
                    final String strReplace2 = strSubstring2.replace(".zip", "");
                    aa.a("test_zip_download ", "start download path： " + str3 + strSubstring2);
                    MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str2, strSubstring2, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER)).withReadTimeout(30000L).withConnectTimeout(20000L).withDownloadPriority(DownloadPriority.MEDIUM).withHttpRetryCounter(1).withDirectoryPathInternal(str3).withDownloadStateListener(new OnDownloadStateListener() { // from class: com.mbridge.msdk.foundation.tools.k.1
                        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                        public final void onDownloadStart(DownloadMessage downloadMessage) {
                        }

                        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                        public final void onDownloadComplete(DownloadMessage downloadMessage) {
                            try {
                                String str4 = str3 + File.separator + strSubstring2;
                                String str5 = str3;
                                MBResourceManager.getInstance().unZip(str4, str5);
                                a aVar2 = aVar;
                                if (aVar2 != null) {
                                    try {
                                        aVar2.a(str2, str5, strReplace2, false);
                                    } catch (Exception e2) {
                                        aa.d("DynamicViewResourceManager", e2.getMessage());
                                    }
                                }
                            } catch (Exception unused5) {
                            }
                        }

                        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                        public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
                            a aVar2 = aVar;
                            if (aVar2 != null) {
                                try {
                                    aVar2.a(str2, downloadError);
                                } catch (Exception e2) {
                                    aa.d("DynamicViewResourceManager", e2.getMessage());
                                }
                            }
                        }
                    }).build().start();
                } catch (Exception e2) {
                    aa.d("DynamicViewResourceManager", e2.getMessage());
                }
                map.put("cache", "2");
                if (campaignEx != null) {
                    com.mbridge.msdk.foundation.same.report.m.a().a("2000153", campaignEx.getCurrentLRid(), map);
                    return;
                }
                return;
            } catch (Exception unused5) {
                return;
            }
        } catch (Exception unused6) {
        }
        if (TextUtils.isEmpty(path)) {
        }
    }

    public static String a(int i, String str, String str2) {
        String strB;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            strB = b(i, str, str2);
        } catch (Exception unused) {
            strB = "";
        }
        File file = null;
        String str3 = com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_XML) + File.separator;
        try {
            if (!TextUtils.isEmpty(strB)) {
                file = new File(str3, strB);
            }
        } catch (Exception unused2) {
        }
        if (file == null || !file.exists()) {
            file = new File(str3 + File.separator + strB.replace(".xml", ""), strB);
        }
        return file != null ? file.getPath() : "";
    }

    private static String b(int i, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            String path = new URL(str2).getPath();
            String strSubstring = path.substring(path.lastIndexOf(47) + 1);
            return !TextUtils.isEmpty(strSubstring) ? strSubstring.replace(".zip", "") : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(String str) {
        String strB;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String queryParameter = Uri.parse(str).getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_NATMP);
            if (!TextUtils.isEmpty(queryParameter) && !queryParameter.equals("1")) {
                return "";
            }
        } catch (Throwable unused) {
        }
        try {
            strB = b(str);
        } catch (Exception unused2) {
            strB = "";
        }
        if (TextUtils.isEmpty(strB)) {
            return "";
        }
        try {
            final String str2 = com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_XML) + File.separator;
            File file = new File(str2, strB);
            if (file.isFile() && file.exists()) {
                return file.getPath();
            }
            String path = new URL(str).getPath();
            final String strSubstring = path.substring(path.lastIndexOf(47) + 1);
            MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str, strSubstring, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER)).withReadTimeout(30000L).withConnectTimeout(20000L).withDownloadPriority(DownloadPriority.MEDIUM).withHttpRetryCounter(1).withDirectoryPathInternal(str2).withDownloadStateListener(new OnDownloadStateListener() { // from class: com.mbridge.msdk.foundation.tools.k.2
                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public final void onDownloadStart(DownloadMessage downloadMessage) {
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public final void onDownloadComplete(DownloadMessage downloadMessage) {
                    try {
                        MBResourceManager.getInstance().unZip(str2 + File.separator + strSubstring, str2);
                    } catch (Exception unused3) {
                    }
                }
            }).build().start();
            return "";
        } catch (Exception unused3) {
        }
    }
}
