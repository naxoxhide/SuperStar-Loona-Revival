package com.mbridge.msdk.videocommon.download;

import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.iab.omid.library.mmadbridge.ScriptInjector;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.foundation.tools.y;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: ResourceManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k {
    private static String a = "ResourceManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2669b;

    /* JADX INFO: compiled from: ResourceManager.java */
    private static class a {
        public static k a = new k(null);
    }

    /* synthetic */ k(AnonymousClass1 anonymousClass1) {
        this();
    }

    private k() {
        this.f2669b = com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_RES);
    }

    public static k a() {
        return a.a;
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.videocommon.download.k$1, reason: invalid class name */
    /* JADX INFO: compiled from: ResourceManager.java */
    final class AnonymousClass1 extends com.mbridge.msdk.foundation.same.e.a {
        final /* synthetic */ k a;

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void b() {
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void a() {
            y.c(this.a.f2669b);
        }
    }

    public final synchronized String a(String str, byte[] bArr) {
        String message;
        String strA = "unknow exception ";
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    String str2 = this.f2669b + RemoteSettings.FORWARD_SLASH_STRING + SameMD5.getMD5(al.a(str)) + ".zip";
                    File file = new File(str2);
                    if (y.a(bArr, file)) {
                        Uri uri = Uri.parse(str);
                        List<String> queryParameters = uri.getQueryParameters("nc");
                        if (queryParameters == null || queryParameters.size() == 0) {
                            List<String> queryParameters2 = uri.getQueryParameters("md5filename");
                            if (queryParameters2 != null && queryParameters2.size() > 0) {
                                String str3 = queryParameters2.get(0);
                                if (!TextUtils.isEmpty(str3) && str3.equals(x.a(file))) {
                                    strA = a(str, str2, file);
                                }
                            }
                        } else {
                            strA = a(str, str2, file);
                        }
                    }
                    if (!TextUtils.isEmpty(strA)) {
                        y.b(file);
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
                message = e.getMessage();
            }
        }
        message = strA;
        return message;
    }

    private String a(String str, String str2, File file) throws Throwable {
        String strA = y.a(str2, this.f2669b + RemoteSettings.FORWARD_SLASH_STRING + SameMD5.getMD5(al.a(str)));
        return TextUtils.isEmpty(strA) ? y.b(file) : strA;
    }

    public final String a(String str) throws Throwable {
        String strSubstring;
        try {
            String str2 = this.f2669b + RemoteSettings.FORWARD_SLASH_STRING + SameMD5.getMD5(al.a(str));
            List<String> queryParameters = Uri.parse(str).getQueryParameters("foldername");
            if (queryParameters == null || queryParameters.size() <= 0) {
                return null;
            }
            String str3 = queryParameters.get(0);
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            String str4 = str2 + RemoteSettings.FORWARD_SLASH_STRING + str3 + RemoteSettings.FORWARD_SLASH_STRING + str3 + ".html";
            if (!y.a(str4)) {
                return null;
            }
            try {
                com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
                if (cVarB != null && !TextUtils.isEmpty(cVarB.aw())) {
                    File file = new File(str4);
                    y.a(com.mbridge.msdk.a.b.c(ScriptInjector.injectScriptContentIntoHtml(MBridgeConstans.OMID_JS_SERVICE_CONTENT, y.a(file))).getBytes(), file);
                }
                strSubstring = str.substring(str.indexOf("?") + 1);
            } catch (Exception unused) {
                strSubstring = "";
            }
            return "file://" + str4 + (TextUtils.isEmpty(strSubstring) ? "" : "?" + strSubstring);
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }
}
