package com.igaworks.adpopcorn.plugin.cocos2dx;

import android.app.Activity;
import com.igaworks.adpopcorn.Adpopcorn;
import com.igaworks.adpopcorn.AdpopcornExtension;
import com.igaworks.adpopcorn.cores.common.APPopupAdError;
import com.igaworks.adpopcorn.cores.common.APVideoError;
import com.igaworks.adpopcorn.cores.model.APClientRewardItem;
import com.igaworks.adpopcorn.interfaces.IAPClientRewardCallbackListener;
import com.igaworks.adpopcorn.interfaces.IAPLoadVideoAdEventListener;
import com.igaworks.adpopcorn.interfaces.IAPPopupAdEventListener;
import com.igaworks.adpopcorn.interfaces.IAPRewardInfoCallbackListener;
import com.igaworks.adpopcorn.interfaces.IAPShowVideoAdEventListener;
import com.igaworks.adpopcorn.interfaces.IAdPOPcornEventListener;

/* JADX INFO: loaded from: classes2.dex */
public class AdpopcornCocos2dxPlugin {
    public static final String TAG = "IgawAdpopcornCocos2dxPlugin";
    private static Activity a;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.igaworks.adpopcorn.cores.common.h.a(AdpopcornCocos2dxPlugin.a, AdpopcornCocos2dxPlugin.TAG, "getClientPendingRewardItems", 3);
            AdpopcornExtension.getClientPendingRewardItems(AdpopcornCocos2dxPlugin.a);
        }
    }

    class b implements Runnable {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f1636b;

        b(String str, String str2) {
            this.a = str;
            this.f1636b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdpopcornExtension.didGiveRewardItemWithRewardKey(AdpopcornCocos2dxPlugin.a, this.a, this.f1636b);
        }
    }

    class c implements Runnable {

        class a implements IAPRewardInfoCallbackListener {
            a(c cVar) {
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPRewardInfoCallbackListener
            public void OnEarnableTotalRewardInfo(boolean z, int i, String str) {
                com.igaworks.adpopcorn.cores.common.h.a(AdpopcornCocos2dxPlugin.a, AdpopcornCocos2dxPlugin.TAG, "OnEarnableTotalRewardInfo", 3);
                AdpopcornCocos2dxPlugin.OnEarnableTotalRewardInfo(z, i, str);
            }
        }

        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdpopcornExtension.getEarnableTotalRewardInfo(AdpopcornCocos2dxPlugin.a, new a(this));
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.checkRequiredPermission(AdpopcornCocos2dxPlugin.a);
        }
    }

    class e implements Runnable {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String[] f1637b;
        final /* synthetic */ int[] c;

        e(int i, String[] strArr, int[] iArr) {
            this.a = i;
            this.f1637b = strArr;
            this.c = iArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.onRequestPermissionsResult(AdpopcornCocos2dxPlugin.a, this.a, this.f1637b, this.c);
        }
    }

    class f implements Runnable {

        class a implements IAPPopupAdEventListener {
            a(f fVar) {
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPPopupAdEventListener
            public void OnLoadPopupAdFailure(APPopupAdError aPPopupAdError) {
                com.igaworks.adpopcorn.cores.common.h.a(AdpopcornCocos2dxPlugin.a, AdpopcornCocos2dxPlugin.TAG, "OnLoadPopupAdFailure", 3);
                AdpopcornCocos2dxPlugin.OnLoadPopupAdFailure(aPPopupAdError.getErrorCode(), aPPopupAdError.getErrorMessage());
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPPopupAdEventListener
            public void OnLoadPopupAdSuccess() {
                com.igaworks.adpopcorn.cores.common.h.a(AdpopcornCocos2dxPlugin.a, AdpopcornCocos2dxPlugin.TAG, "OnLoadPopupAdSuccess", 3);
                AdpopcornCocos2dxPlugin.OnLoadPopupAdSuccess();
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPPopupAdEventListener
            public void OnPopupAdClose() {
                com.igaworks.adpopcorn.cores.common.h.a(AdpopcornCocos2dxPlugin.a, AdpopcornCocos2dxPlugin.TAG, "OnPopupAdClose", 3);
                AdpopcornCocos2dxPlugin.OnPopupAdClose();
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPPopupAdEventListener
            public void OnShowPopupAdFailure(APPopupAdError aPPopupAdError) {
                com.igaworks.adpopcorn.cores.common.h.a(AdpopcornCocos2dxPlugin.a, AdpopcornCocos2dxPlugin.TAG, "OnShowPopupAdFailure", 3);
                AdpopcornCocos2dxPlugin.OnShowPopupAdFailure(aPPopupAdError.getErrorCode(), aPPopupAdError.getErrorMessage());
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPPopupAdEventListener
            public void OnShowPopupAdSuccess() {
                com.igaworks.adpopcorn.cores.common.h.a(AdpopcornCocos2dxPlugin.a, AdpopcornCocos2dxPlugin.TAG, "OnShowPopupAdSuccess", 3);
                AdpopcornCocos2dxPlugin.OnShowPopupAdSuccess();
            }
        }

        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.loadPopupAd(AdpopcornCocos2dxPlugin.a, new a(this));
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.showPopupAd(AdpopcornCocos2dxPlugin.a);
        }
    }

    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.openOfferWall(AdpopcornCocos2dxPlugin.a);
        }
    }

    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.openFeedOfferWall(AdpopcornCocos2dxPlugin.a);
        }
    }

    class j implements Runnable {
        final /* synthetic */ String a;

        j(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.setUserId(AdpopcornCocos2dxPlugin.a, this.a);
        }
    }

    class k implements Runnable {
        final /* synthetic */ boolean a;

        k(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.setSensorLandscapeEnable(AdpopcornCocos2dxPlugin.a, this.a);
        }
    }

    class l implements Runnable {
        final /* synthetic */ int a;

        l(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdpopcornExtension.setExceptionPermissionList(AdpopcornCocos2dxPlugin.a, this.a);
        }
    }

    class m implements Runnable {

        class a implements IAPLoadVideoAdEventListener {
            a(m mVar) {
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPLoadVideoAdEventListener
            public void OnLoadVideoAdFailure(APVideoError aPVideoError) {
                com.igaworks.adpopcorn.cores.common.h.a(AdpopcornCocos2dxPlugin.a, AdpopcornCocos2dxPlugin.TAG, "OnLoadVideoAdFailure", 3);
                AdpopcornCocos2dxPlugin.OnLoadVideoAdFailure(aPVideoError.getErrorCode(), aPVideoError.getErrorMessage());
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPLoadVideoAdEventListener
            public void OnLoadVideoAdSuccess() {
                com.igaworks.adpopcorn.cores.common.h.a(AdpopcornCocos2dxPlugin.a, AdpopcornCocos2dxPlugin.TAG, "OnLoadVideoAdSuccess", 3);
                AdpopcornCocos2dxPlugin.OnLoadVideoAdSuccess();
            }
        }

        m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.loadVideoAd(AdpopcornCocos2dxPlugin.a, new a(this));
        }
    }

    class n implements Runnable {

        class a implements IAPShowVideoAdEventListener {
            a(n nVar) {
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPShowVideoAdEventListener
            public void OnShowVideoAdFailure(APVideoError aPVideoError) {
                com.igaworks.adpopcorn.cores.common.h.a(AdpopcornCocos2dxPlugin.a, AdpopcornCocos2dxPlugin.TAG, "OnShowVideoAdFailure", 3);
                AdpopcornCocos2dxPlugin.OnShowVideoAdFailure(aPVideoError.getErrorCode(), aPVideoError.getErrorMessage());
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPShowVideoAdEventListener
            public void OnShowVideoAdSuccess() {
                com.igaworks.adpopcorn.cores.common.h.a(AdpopcornCocos2dxPlugin.a, AdpopcornCocos2dxPlugin.TAG, "OnShowVideoAdSuccess", 3);
                AdpopcornCocos2dxPlugin.OnShowVideoAdSuccess();
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPShowVideoAdEventListener
            public void OnVideoAdClose() {
                com.igaworks.adpopcorn.cores.common.h.a(AdpopcornCocos2dxPlugin.a, AdpopcornCocos2dxPlugin.TAG, "OnVideoAdClose", 3);
                AdpopcornCocos2dxPlugin.OnVideoAdClose();
            }
        }

        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.showVideoAd(AdpopcornCocos2dxPlugin.a, new a(this));
        }
    }

    class o implements Runnable {

        class a implements IAdPOPcornEventListener {
            a(o oVar) {
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAdPOPcornEventListener
            public void OnAgreePrivacy() {
                com.igaworks.adpopcorn.cores.common.h.a(AdpopcornCocos2dxPlugin.a, AdpopcornCocos2dxPlugin.TAG, "OnAgreePrivacy", 3);
                AdpopcornCocos2dxPlugin.OnAgreePrivacy();
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAdPOPcornEventListener
            public void OnClosedOfferWallPage() {
                com.igaworks.adpopcorn.cores.common.h.a(AdpopcornCocos2dxPlugin.a, AdpopcornCocos2dxPlugin.TAG, "OnClosedOfferWallPage", 3);
                AdpopcornCocos2dxPlugin.OnClosedOfferWallPage();
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAdPOPcornEventListener
            public void OnDisagreePrivacy() {
                com.igaworks.adpopcorn.cores.common.h.a(AdpopcornCocos2dxPlugin.a, AdpopcornCocos2dxPlugin.TAG, "OnDisagreePrivacy", 3);
                AdpopcornCocos2dxPlugin.OnDisagreePrivacy();
            }
        }

        o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.setEventListener(AdpopcornCocos2dxPlugin.a, new a(this));
        }
    }

    class p implements Runnable {

        class a implements IAPClientRewardCallbackListener {
            a(p pVar) {
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPClientRewardCallbackListener
            public void onDidGiveRewardItemResult(boolean z, String str, int i, String str2) {
                com.igaworks.adpopcorn.cores.common.h.a(AdpopcornCocos2dxPlugin.a, AdpopcornCocos2dxPlugin.TAG, "onDidGiveRewardItemResult", 3);
                AdpopcornCocos2dxPlugin.onDidGiveRewardItemResult(z, str, i, str2);
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPClientRewardCallbackListener
            public void onGetRewardInfo(boolean z, String str, APClientRewardItem[] aPClientRewardItemArr) {
                Activity activity;
                String str2;
                if (!z) {
                    activity = AdpopcornCocos2dxPlugin.a;
                    str2 = "Fail to get the Igaworks Reward Info.";
                } else {
                    if (aPClientRewardItemArr.length != 0) {
                        com.igaworks.adpopcorn.cores.common.h.a(AdpopcornCocos2dxPlugin.a, AdpopcornCocos2dxPlugin.TAG, "Detected Igaworks Reward Info.", 3);
                        for (APClientRewardItem aPClientRewardItem : aPClientRewardItemArr) {
                            AdpopcornCocos2dxPlugin.onGetRewardInfo(z, str, aPClientRewardItem.getCampaignKey(), aPClientRewardItem.getCampaignTitle(), aPClientRewardItem.getRewardQuantity(), aPClientRewardItem.getCV(), aPClientRewardItem.getRTID());
                        }
                        return;
                    }
                    activity = AdpopcornCocos2dxPlugin.a;
                    str2 = "There is no Reward Info for user.";
                }
                com.igaworks.adpopcorn.cores.common.h.a(activity, AdpopcornCocos2dxPlugin.TAG, str2, 3);
            }
        }

        p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.igaworks.adpopcorn.cores.common.h.a(AdpopcornCocos2dxPlugin.a, AdpopcornCocos2dxPlugin.TAG, "setIgaworksRewardListener", 3);
            AdpopcornExtension.setFromPluginAPI(AdpopcornCocos2dxPlugin.a, true);
            AdpopcornExtension.setClientRewardCallbackListener(AdpopcornCocos2dxPlugin.a, new a(this));
        }
    }

    public static native void OnAgreePrivacy();

    public static native void OnClosedOfferWallPage();

    public static native void OnDisagreePrivacy();

    public static native void OnEarnableTotalRewardInfo(boolean z, int i2, String str);

    public static native void OnLoadPopupAdFailure(int i2, String str);

    public static native void OnLoadPopupAdSuccess();

    public static native void OnLoadVideoAdFailure(int i2, String str);

    public static native void OnLoadVideoAdSuccess();

    public static native void OnPopupAdClose();

    public static native void OnShowPopupAdFailure(int i2, String str);

    public static native void OnShowPopupAdSuccess();

    public static native void OnShowVideoAdFailure(int i2, String str);

    public static native void OnShowVideoAdSuccess();

    public static native void OnVideoAdClose();

    public static void checkRequiredPermission() {
        a.runOnUiThread(new d());
    }

    public static void didGiveRewardItem(String str, String str2) {
        a.runOnUiThread(new b(str, str2));
    }

    public static void getClientPendingRewardItems() {
        a.runOnUiThread(new a());
    }

    public static void getEarnableTotalRewardInfo() {
        a.runOnUiThread(new c());
    }

    public static void initPlugin(Activity activity) {
        a = activity;
        AdpopcornExtension.setFromPluginAPI(activity, true);
    }

    public static void loadPopupAd() {
        a.runOnUiThread(new f());
    }

    public static void loadVideoAd() {
        a.runOnUiThread(new m());
    }

    public static native void onDidGiveRewardItemResult(boolean z, String str, int i2, String str2);

    public static native void onGetRewardInfo(boolean z, String str, String str2, String str3, long j2, String str4, String str5);

    public static void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        a.runOnUiThread(new e(i2, strArr, iArr));
    }

    public static void openFeedOfferWall() {
        setAdpopcornOfferwallEventListener();
        a.runOnUiThread(new i());
    }

    public static void openOfferwall() {
        setAdpopcornOfferwallEventListener();
        a.runOnUiThread(new h());
    }

    public static void setAdpopcornOfferwallEventListener() {
        a.runOnUiThread(new o());
    }

    public static void setClientRewardCallbackListener() {
        a.runOnUiThread(new p());
    }

    public static void setExceptionPermissionList(int i2) {
        a.runOnUiThread(new l(i2));
    }

    public static void setSensorLandscapeEnable(boolean z) {
        a.runOnUiThread(new k(z));
    }

    public static void setUserId(String str) {
        a.runOnUiThread(new j(str));
    }

    public static void showPopupAd() {
        a.runOnUiThread(new g());
    }

    public static void showVideoAd() {
        a.runOnUiThread(new n());
    }
}
