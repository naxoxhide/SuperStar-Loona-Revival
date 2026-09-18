package com.mbridge.msdk.advanced.a;

import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedWebview;
import com.mbridge.msdk.c.d;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.videocommon.download.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ResManager.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static f a = f.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f1886b = "ResManager";
    private static int c = 1;

    public static CampaignEx a(MBNativeAdvancedView mBNativeAdvancedView, String str, String str2, String str3, int i, boolean z, boolean z2) {
        com.mbridge.msdk.c.c cVarB = d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
        if (cVarB == null) {
            cVarB = d.a().b();
        }
        long jW = cVarB.W() * 1000;
        long jQ = cVarB.Q() * 1000;
        if (a == null) {
            a = f.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
        }
        a.b(jQ, str2);
        if (a == null) {
            a = f.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
        }
        List<CampaignEx> listB = a.b(str2, 0, 0, c);
        if (listB == null || listB.size() <= 0) {
            return null;
        }
        CampaignEx campaignEx = listB.get(0);
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - jW;
        if (!z) {
            if ((campaignEx.getPlct() > 0 && (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() >= jCurrentTimeMillis) || (campaignEx.getPlct() <= 0 && campaignEx.getTimestamp() >= j)) {
                if (!a(mBNativeAdvancedView, campaignEx, str, str2, i, z2)) {
                    return null;
                }
                aa.d(f1886b, "cache campain is picked:" + campaignEx.getAppName());
                return a(campaignEx);
            }
            if (campaignEx.isSpareOffer(jW, jQ) || mBNativeAdvancedView == null) {
                return null;
            }
            mBNativeAdvancedView.setVisibility(8);
            return null;
        }
        if ((campaignEx.getPlct() > 0 && (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() >= jCurrentTimeMillis) || (campaignEx.getPlct() <= 0 && campaignEx.getTimestamp() >= j)) {
            if (!a(mBNativeAdvancedView, campaignEx, str, str2, i, z2)) {
                return null;
            }
            aa.d(f1886b, "cache campain is picked:" + campaignEx.getAppName());
            return a(campaignEx);
        }
        if (a(mBNativeAdvancedView, campaignEx, str, str2, i, z2) && campaignEx.isSpareOffer(jW, jQ)) {
            return a(campaignEx);
        }
        if (campaignEx.isSpareOffer(jW, jQ) || mBNativeAdvancedView == null) {
            return null;
        }
        mBNativeAdvancedView.setVisibility(8);
        return null;
    }

    private static CampaignEx a(CampaignEx campaignEx) {
        if (!TextUtils.isEmpty(campaignEx.getAdZip()) || (!TextUtils.isEmpty(campaignEx.getAdHtml()) && campaignEx.getAdHtml().contains("<MBTPLMARK>"))) {
            campaignEx.setHasMBTplMark(true);
            campaignEx.setIsMraid(false);
        } else {
            campaignEx.setHasMBTplMark(false);
            campaignEx.setIsMraid(true);
        }
        return campaignEx;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0071  */
    /* JADX WARN: Code duplicated, block: B:26:0x0090  */
    /* JADX WARN: Code duplicated, block: B:27:0x0094  */
    /* JADX WARN: Code duplicated, block: B:29:0x009f  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:40:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:? A[RETURN, SYNTHETIC] */
    private static boolean a(MBNativeAdvancedView mBNativeAdvancedView, CampaignEx campaignEx, String str, String str2, int i, boolean z) {
        boolean zA;
        boolean z2;
        String strB;
        String strB2;
        if (campaignEx == null) {
            return false;
        }
        mBNativeAdvancedView.clearResState();
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            zA = com.mbridge.msdk.videocommon.download.c.getInstance().a(298, str2, campaignEx.isBidCampaign());
            if (zA) {
            }
            z2 = zA;
            if (!TextUtils.isEmpty(campaignEx.getendcard_url()) && !mBNativeAdvancedView.isEndCardReady() && !TextUtils.isEmpty(g.a().b(campaignEx.getendcard_url()))) {
                mBNativeAdvancedView.setEndCardReady(true);
            }
            if (!TextUtils.isEmpty(campaignEx.getAdZip()) && !mBNativeAdvancedView.isH5Ready()) {
                strB2 = g.a().b(campaignEx.getAdZip());
                if (TextUtils.isEmpty(strB2)) {
                    z2 = false;
                } else if (com.mbridge.msdk.advanced.common.b.a(str + str2 + campaignEx.getRequestId())) {
                    mBNativeAdvancedView.setH5Ready(true);
                } else {
                    a(mBNativeAdvancedView, strB2, campaignEx, str, str2, i);
                    if (!z) {
                        z2 = false;
                    }
                }
            }
            if (TextUtils.isEmpty(campaignEx.getAdZip()) && !TextUtils.isEmpty(campaignEx.getAdHtml()) && !mBNativeAdvancedView.isH5Ready()) {
                strB = b(campaignEx.getAdHtml());
                if (!TextUtils.isEmpty(strB)) {
                    return false;
                }
                if (com.mbridge.msdk.advanced.common.b.a(str + str2 + campaignEx.getRequestId())) {
                    mBNativeAdvancedView.setH5Ready(true);
                    if (campaignEx.isMraid()) {
                        mBNativeAdvancedView.setVideoReady(true);
                    }
                    return true;
                }
                a(mBNativeAdvancedView, strB, campaignEx, str, str2, i);
                if (!z) {
                    return false;
                }
            }
            return z2;
        }
        zA = true;
        mBNativeAdvancedView.setVideoReady(true);
        z2 = zA;
        if (!TextUtils.isEmpty(campaignEx.getendcard_url())) {
            mBNativeAdvancedView.setEndCardReady(true);
        }
        if (!TextUtils.isEmpty(campaignEx.getAdZip())) {
            strB2 = g.a().b(campaignEx.getAdZip());
            if (TextUtils.isEmpty(strB2)) {
                z2 = false;
            } else if (com.mbridge.msdk.advanced.common.b.a(str + str2 + campaignEx.getRequestId())) {
                mBNativeAdvancedView.setH5Ready(true);
            } else {
                a(mBNativeAdvancedView, strB2, campaignEx, str, str2, i);
                if (!z) {
                    z2 = false;
                }
            }
        }
        if (TextUtils.isEmpty(campaignEx.getAdZip())) {
            strB = b(campaignEx.getAdHtml());
            if (!TextUtils.isEmpty(strB)) {
                return false;
            }
            if (com.mbridge.msdk.advanced.common.b.a(str + str2 + campaignEx.getRequestId())) {
                mBNativeAdvancedView.setH5Ready(true);
                if (campaignEx.isMraid()) {
                    mBNativeAdvancedView.setVideoReady(true);
                }
                return true;
            }
            a(mBNativeAdvancedView, strB, campaignEx, str, str2, i);
            if (!z) {
                return false;
            }
        }
        return z2;
    }

    private static void a(final MBNativeAdvancedView mBNativeAdvancedView, final String str, final CampaignEx campaignEx, final String str2, final String str3, int i) {
        if (mBNativeAdvancedView == null || mBNativeAdvancedView.getAdvancedNativeWebview() == null) {
            return;
        }
        com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.advanced.common.c.a().c(campaignEx.getId()).d(campaignEx.getRequestId()).g(campaignEx.getRequestIdNotice()).b(str3).a(campaignEx.isBidCampaign()), str3);
        com.mbridge.msdk.advanced.js.b bVar = new com.mbridge.msdk.advanced.js.b(mBNativeAdvancedView.getContext(), str2, str3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        bVar.a(arrayList);
        bVar.a(i);
        mBNativeAdvancedView.setAdvancedNativeSignalCommunicationImpl(bVar);
        final MBNativeAdvancedWebview advancedNativeWebview = mBNativeAdvancedView.getAdvancedNativeWebview();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        advancedNativeWebview.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.advanced.a.c.1
            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, int i2) {
                super.a(webView, i2);
                if (i2 == 1) {
                    com.mbridge.msdk.advanced.common.b.a(str2 + str3 + campaignEx.getRequestId(), true);
                    mBNativeAdvancedView.setH5Ready(true);
                    com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx, str3, "", jCurrentTimeMillis, 1);
                } else {
                    mBNativeAdvancedView.setH5Ready(false);
                    com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx, str3, "readyState 2", jCurrentTimeMillis, 3);
                }
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, int i2, String str4, String str5) {
                super.a(webView, i2, str4, str5);
                mBNativeAdvancedView.setH5Ready(false);
                com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx, str3, "error code:" + i2 + str4, jCurrentTimeMillis, 3);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.a(webView, sslErrorHandler, sslError);
                mBNativeAdvancedView.setH5Ready(false);
                com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx, str3, "error url:" + sslError.getUrl(), jCurrentTimeMillis, 3);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, String str4) {
                super.a(webView, str4);
                if (!campaignEx.isHasMBTplMark()) {
                    com.mbridge.msdk.advanced.common.b.a(str2 + str3 + campaignEx.getRequestId(), true);
                    mBNativeAdvancedView.setH5Ready(true);
                    com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx, str3, "", jCurrentTimeMillis, 1);
                }
                com.mbridge.msdk.advanced.js.a.a(webView);
            }
        });
        if (!advancedNativeWebview.isDestoryed()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.mbridge.msdk.advanced.a.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    advancedNativeWebview.loadUrl(str);
                }
            });
        } else {
            mBNativeAdvancedView.setH5Ready(false);
            com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx, str3, "webview had destory", jCurrentTimeMillis, 3);
        }
    }

    private static String b(String str) {
        try {
            File file = new File(str);
            return file.exists() ? "file:///" + file.getAbsolutePath() : "";
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Exception e) {
                e.getMessage();
                return "";
            }
        }
    }

    public static boolean a(MBNativeAdvancedView mBNativeAdvancedView, CampaignEx campaignEx, String str, String str2) {
        boolean z = false;
        if (mBNativeAdvancedView == null) {
            aa.d(f1886b, "mbAdvancedNativeView  is null");
            return false;
        }
        boolean zA = true;
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            zA = mBNativeAdvancedView.isVideoReady();
            aa.d(f1886b, "isReady isVideoReady:" + zA);
        }
        if (zA && !TextUtils.isEmpty(campaignEx.getAdZip())) {
            zA = com.mbridge.msdk.advanced.common.b.a(str + str2 + campaignEx.getRequestId());
            aa.d(f1886b, "isReady getAdZip:" + zA);
        }
        if (zA && TextUtils.isEmpty(campaignEx.getAdZip()) && !TextUtils.isEmpty(campaignEx.getAdHtml())) {
            zA = com.mbridge.msdk.advanced.common.b.a(str + str2 + campaignEx.getRequestId());
            aa.d(f1886b, "isReady getAdHtml:" + zA);
        }
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
            aa.d(f1886b, "isReady getAdHtml  getAdZip all are empty");
        } else {
            z = zA;
        }
        if (!z || TextUtils.isEmpty(campaignEx.getendcard_url())) {
            return z;
        }
        boolean zIsEndCardReady = mBNativeAdvancedView.isEndCardReady();
        aa.d(f1886b, "isReady isEndCardReady:" + zIsEndCardReady);
        return zIsEndCardReady;
    }

    public static void a(CampaignEx campaignEx, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        if (a == null) {
            a = f.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
        }
        a.b(arrayList, str);
    }

    public static void a(String str) {
        if (a == null) {
            a = f.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
        }
        a.a(str, 0, c);
    }
}
