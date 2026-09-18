package com.igaworks.adpopcorn.plugin.unity;

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
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;
import com.unity3d.player.UnityPlayer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class AdPopcornUnityPlugin {
    public static final String TAG = "IgawAdPopcornUnityPlugin";
    private static IAPUnityVideoEventListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static IAPUnityRewardInfoCallbackListener f1638b;
    private static IAPUnityPopupAdEventListener c;

    class a implements Runnable {

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.plugin.unity.AdPopcornUnityPlugin$a$a, reason: collision with other inner class name */
        class C0435a implements IAPShowVideoAdEventListener {
            C0435a(a aVar) {
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPShowVideoAdEventListener
            public void OnShowVideoAdFailure(APVideoError aPVideoError) {
                com.igaworks.adpopcorn.cores.common.h.a(UnityPlayer.currentActivity, AdPopcornUnityPlugin.TAG, "OnShowVideoAdFailure", 3);
                if (AdPopcornUnityPlugin.a != null) {
                    AdPopcornUnityPlugin.a.OnShowVideoAdFailure(aPVideoError.getErrorCode(), aPVideoError.getErrorMessage());
                }
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPShowVideoAdEventListener
            public void OnShowVideoAdSuccess() {
                com.igaworks.adpopcorn.cores.common.h.a(UnityPlayer.currentActivity, AdPopcornUnityPlugin.TAG, "OnShowVideoAdSuccess", 3);
                if (AdPopcornUnityPlugin.a != null) {
                    AdPopcornUnityPlugin.a.OnShowVideoAdSuccess();
                }
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPShowVideoAdEventListener
            public void OnVideoAdClose() {
                com.igaworks.adpopcorn.cores.common.h.a(UnityPlayer.currentActivity, AdPopcornUnityPlugin.TAG, "OnVideoAdClose", 3);
                if (AdPopcornUnityPlugin.a != null) {
                    AdPopcornUnityPlugin.a.OnVideoAdClose();
                }
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.showVideoAd(UnityPlayer.currentActivity, new C0435a(this));
        }
    }

    class b implements Runnable {
        final /* synthetic */ IAPUnityOfferwallEventListener a;

        class a implements IAdPOPcornEventListener {
            a() {
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAdPOPcornEventListener
            public void OnAgreePrivacy() {
                com.igaworks.adpopcorn.cores.common.h.a(UnityPlayer.currentActivity, AdPopcornUnityPlugin.TAG, "OnAgreePrivacy", 3);
                IAPUnityOfferwallEventListener iAPUnityOfferwallEventListener = b.this.a;
                if (iAPUnityOfferwallEventListener != null) {
                    iAPUnityOfferwallEventListener.OnAgreePrivacy();
                }
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAdPOPcornEventListener
            public void OnClosedOfferWallPage() {
                com.igaworks.adpopcorn.cores.common.h.a(UnityPlayer.currentActivity, AdPopcornUnityPlugin.TAG, "OnClosedOfferWallPage", 3);
                IAPUnityOfferwallEventListener iAPUnityOfferwallEventListener = b.this.a;
                if (iAPUnityOfferwallEventListener != null) {
                    iAPUnityOfferwallEventListener.OnClosedOfferWallPage();
                }
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAdPOPcornEventListener
            public void OnDisagreePrivacy() {
                com.igaworks.adpopcorn.cores.common.h.a(UnityPlayer.currentActivity, AdPopcornUnityPlugin.TAG, "OnDisagreePrivacy", 3);
                IAPUnityOfferwallEventListener iAPUnityOfferwallEventListener = b.this.a;
                if (iAPUnityOfferwallEventListener != null) {
                    iAPUnityOfferwallEventListener.OnDisagreePrivacy();
                }
            }
        }

        b(IAPUnityOfferwallEventListener iAPUnityOfferwallEventListener) {
            this.a = iAPUnityOfferwallEventListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.setEventListener(UnityPlayer.currentActivity, new a());
        }
    }

    class c implements Runnable {
        final /* synthetic */ IAPUnityClientRewardCallbackListener a;

        class a implements IAPClientRewardCallbackListener {
            a() {
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPClientRewardCallbackListener
            public void onDidGiveRewardItemResult(boolean z, String str, int i, String str2) {
                com.igaworks.adpopcorn.cores.common.h.a(UnityPlayer.currentActivity, AdPopcornUnityPlugin.TAG, "onDidGiveRewardItemResult", 3);
                IAPUnityClientRewardCallbackListener iAPUnityClientRewardCallbackListener = c.this.a;
                if (iAPUnityClientRewardCallbackListener != null) {
                    iAPUnityClientRewardCallbackListener.onDidGiveRewardItemResult(z, str, i, str2);
                }
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPClientRewardCallbackListener
            public void onGetRewardInfo(boolean z, String str, APClientRewardItem[] aPClientRewardItemArr) {
                if (!z) {
                    com.igaworks.adpopcorn.cores.common.h.a(UnityPlayer.currentActivity, AdPopcornUnityPlugin.TAG, "Fail to get the Igaworks Reward Info.", 3);
                    return;
                }
                if (aPClientRewardItemArr.length == 0) {
                    com.igaworks.adpopcorn.cores.common.h.a(UnityPlayer.currentActivity, AdPopcornUnityPlugin.TAG, "There is no Reward Info for user.", 3);
                } else {
                    com.igaworks.adpopcorn.cores.common.h.a(UnityPlayer.currentActivity, AdPopcornUnityPlugin.TAG, "Detected Igaworks Reward Info.", 3);
                    for (APClientRewardItem aPClientRewardItem : aPClientRewardItemArr) {
                        IAPUnityClientRewardCallbackListener iAPUnityClientRewardCallbackListener = c.this.a;
                        if (iAPUnityClientRewardCallbackListener != null) {
                            iAPUnityClientRewardCallbackListener.onGetRewardInfo(z, str, aPClientRewardItem.getCampaignKey(), aPClientRewardItem.getCampaignTitle(), aPClientRewardItem.getRewardQuantity(), aPClientRewardItem.getCV(), aPClientRewardItem.getRTID());
                        }
                    }
                }
            }
        }

        c(IAPUnityClientRewardCallbackListener iAPUnityClientRewardCallbackListener) {
            this.a = iAPUnityClientRewardCallbackListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.igaworks.adpopcorn.cores.common.h.a(UnityPlayer.currentActivity, AdPopcornUnityPlugin.TAG, "setIgaworksRewardListener", 3);
            AdpopcornExtension.setFromPluginAPI(UnityPlayer.currentActivity, true);
            AdpopcornExtension.setClientRewardCallbackListener(UnityPlayer.currentActivity, new a());
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.igaworks.adpopcorn.cores.common.h.a(UnityPlayer.currentActivity, AdPopcornUnityPlugin.TAG, "getClientPendingRewardItems", 3);
            AdpopcornExtension.getClientPendingRewardItems(UnityPlayer.currentActivity);
        }
    }

    class e implements Runnable {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f1639b;

        e(String str, String str2) {
            this.a = str;
            this.f1639b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdpopcornExtension.didGiveRewardItemWithRewardKey(UnityPlayer.currentActivity, this.a, this.f1639b);
        }
    }

    class f implements Runnable {

        class a implements IAPRewardInfoCallbackListener {
            a(f fVar) {
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPRewardInfoCallbackListener
            public void OnEarnableTotalRewardInfo(boolean z, int i, String str) {
                if (AdPopcornUnityPlugin.f1638b != null) {
                    com.igaworks.adpopcorn.cores.common.h.a(UnityPlayer.currentActivity, AdPopcornUnityPlugin.TAG, "OnEarnableTotalRewardInfo", 3);
                    AdPopcornUnityPlugin.f1638b.OnEarnableTotalRewardInfo(z, i, str);
                }
            }
        }

        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdpopcornExtension.getEarnableTotalRewardInfo(UnityPlayer.currentActivity, new a(this));
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.checkRequiredPermission(UnityPlayer.currentActivity);
        }
    }

    class h implements Runnable {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String[] f1640b;
        final /* synthetic */ int[] c;

        h(int i, String[] strArr, int[] iArr) {
            this.a = i;
            this.f1640b = strArr;
            this.c = iArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.onRequestPermissionsResult(UnityPlayer.currentActivity, this.a, this.f1640b, this.c);
        }
    }

    class i implements Runnable {

        class a implements IAPPopupAdEventListener {
            a(i iVar) {
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPPopupAdEventListener
            public void OnLoadPopupAdFailure(APPopupAdError aPPopupAdError) {
                if (AdPopcornUnityPlugin.c != null) {
                    AdPopcornUnityPlugin.c.OnLoadPopupAdFailure(aPPopupAdError.getErrorCode(), aPPopupAdError.getErrorMessage());
                }
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPPopupAdEventListener
            public void OnLoadPopupAdSuccess() {
                if (AdPopcornUnityPlugin.c != null) {
                    AdPopcornUnityPlugin.c.OnLoadPopupAdSuccess();
                }
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPPopupAdEventListener
            public void OnPopupAdClose() {
                if (AdPopcornUnityPlugin.c != null) {
                    AdPopcornUnityPlugin.c.OnPopupAdClose();
                }
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPPopupAdEventListener
            public void OnShowPopupAdFailure(APPopupAdError aPPopupAdError) {
                if (AdPopcornUnityPlugin.c != null) {
                    AdPopcornUnityPlugin.c.OnShowPopupAdFailure(aPPopupAdError.getErrorCode(), aPPopupAdError.getErrorMessage());
                }
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPPopupAdEventListener
            public void OnShowPopupAdSuccess() {
                if (AdPopcornUnityPlugin.c != null) {
                    AdPopcornUnityPlugin.c.OnShowPopupAdSuccess();
                }
            }
        }

        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.loadPopupAd(UnityPlayer.currentActivity, new a(this));
        }
    }

    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.showPopupAd(UnityPlayer.currentActivity);
        }
    }

    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.openOfferWall(UnityPlayer.currentActivity);
        }
    }

    class l implements Runnable {
        l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.openFeedOfferWall(UnityPlayer.currentActivity);
        }
    }

    class m implements Runnable {
        m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ApStyleManager.setTabCustomOfferwallStyle(null);
            Adpopcorn.openOfferWall(UnityPlayer.currentActivity);
        }
    }

    class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdpopcornExtension.openLegacyOfferWall(UnityPlayer.currentActivity);
        }
    }

    class o implements Runnable {
        o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdpopcornExtension.openLegacyFeedOfferWall(UnityPlayer.currentActivity);
        }
    }

    class p implements Runnable {
        final /* synthetic */ String a;

        p(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.setUserId(UnityPlayer.currentActivity, this.a);
        }
    }

    class q implements Runnable {
        final /* synthetic */ boolean a;

        q(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.setSensorLandscapeEnable(UnityPlayer.currentActivity, this.a);
        }
    }

    class r implements Runnable {
        final /* synthetic */ int a;

        r(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdpopcornExtension.setExceptionPermissionList(UnityPlayer.currentActivity, this.a);
        }
    }

    class s implements Runnable {

        class a implements IAPLoadVideoAdEventListener {
            a(s sVar) {
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPLoadVideoAdEventListener
            public void OnLoadVideoAdFailure(APVideoError aPVideoError) {
                com.igaworks.adpopcorn.cores.common.h.a(UnityPlayer.currentActivity, AdPopcornUnityPlugin.TAG, "OnLoadVideoAdFailure", 3);
                if (AdPopcornUnityPlugin.a != null) {
                    AdPopcornUnityPlugin.a.OnLoadVideoAdFailure(aPVideoError.getErrorCode(), aPVideoError.getErrorMessage());
                }
            }

            @Override // com.igaworks.adpopcorn.interfaces.IAPLoadVideoAdEventListener
            public void OnLoadVideoAdSuccess() {
                com.igaworks.adpopcorn.cores.common.h.a(UnityPlayer.currentActivity, AdPopcornUnityPlugin.TAG, "OnLoadVideoAdSuccess", 3);
                if (AdPopcornUnityPlugin.a != null) {
                    AdPopcornUnityPlugin.a.OnLoadVideoAdSuccess();
                }
            }
        }

        s() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Adpopcorn.loadVideoAd(UnityPlayer.currentActivity, new a(this));
        }
    }

    public static void checkRequiredPermission() {
        UnityPlayer.currentActivity.runOnUiThread(new g());
    }

    public static void clearCustomOfferwallStyle() {
        com.igaworks.adpopcorn.style.a.b().a();
    }

    public static void didGiveRewardItem(String str, String str2) {
        UnityPlayer.currentActivity.runOnUiThread(new e(str, str2));
    }

    public static void getClientPendingRewardItems() {
        UnityPlayer.currentActivity.runOnUiThread(new d());
    }

    public static void getEarnableTotalRewardInfo() {
        UnityPlayer.currentActivity.runOnUiThread(new f());
    }

    public static void loadPopupAd() {
        UnityPlayer.currentActivity.runOnUiThread(new i());
    }

    public static void loadVideoAd() {
        UnityPlayer.currentActivity.runOnUiThread(new s());
    }

    public static void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        UnityPlayer.currentActivity.runOnUiThread(new h(i2, strArr, iArr));
    }

    public static void openFeedOfferWall() {
        UnityPlayer.currentActivity.runOnUiThread(new l());
    }

    public static void openLegacyFeedOfferWall() {
        UnityPlayer.currentActivity.runOnUiThread(new o());
    }

    public static void openLegacyOfferWall() {
        UnityPlayer.currentActivity.runOnUiThread(new n());
    }

    public static void openOfferwall() {
        UnityPlayer.currentActivity.runOnUiThread(new k());
    }

    public static void openTabOfferWall() {
        UnityPlayer.currentActivity.runOnUiThread(new m());
    }

    public static void setAdpopcornOfferwallEventListener(IAPUnityOfferwallEventListener iAPUnityOfferwallEventListener) {
        UnityPlayer.currentActivity.runOnUiThread(new b(iAPUnityOfferwallEventListener));
    }

    public static void setAdpopcornTotalRewardInfoEventListener(IAPUnityRewardInfoCallbackListener iAPUnityRewardInfoCallbackListener) {
        f1638b = iAPUnityRewardInfoCallbackListener;
    }

    public static void setAdpopcornUnityPopupAdEventListener(IAPUnityPopupAdEventListener iAPUnityPopupAdEventListener) {
        c = iAPUnityPopupAdEventListener;
    }

    public static void setAdpopcornVideoEventListener(IAPUnityVideoEventListener iAPUnityVideoEventListener) {
        a = iAPUnityVideoEventListener;
    }

    public static void setClientRewardCallbackListener(IAPUnityClientRewardCallbackListener iAPUnityClientRewardCallbackListener) {
        UnityPlayer.currentActivity.runOnUiThread(new c(iAPUnityClientRewardCallbackListener));
    }

    public static void setCustomBooleanOfferwallStyle(String str, boolean z) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(str, Boolean.valueOf(z));
        com.igaworks.adpopcorn.style.a.b().a(map);
    }

    public static void setCustomIntOfferwallStyle(String str, int i2) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(str, Integer.valueOf(i2));
        com.igaworks.adpopcorn.style.a.b().a(map);
    }

    public static void setCustomSizeOfferwallStyle(String str, int i2, int i3) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(str, new APSize(i2, i3));
        com.igaworks.adpopcorn.style.a.b().a(map);
    }

    public static void setCustomStringOfferwallStyle(String str, String str2) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(str, str2);
        com.igaworks.adpopcorn.style.a.b().a(map);
    }

    public static void setExceptionPermissionList(int i2) {
        UnityPlayer.currentActivity.runOnUiThread(new r(i2));
    }

    public static void setSensorLandscapeEnable(boolean z) {
        UnityPlayer.currentActivity.runOnUiThread(new q(z));
    }

    public static void setUserId(String str) {
        UnityPlayer.currentActivity.runOnUiThread(new p(str));
    }

    public static void showPopupAd() {
        UnityPlayer.currentActivity.runOnUiThread(new j());
    }

    public static void showVideoAd() {
        UnityPlayer.currentActivity.runOnUiThread(new a());
    }
}
