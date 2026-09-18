package com.tnkfactory.ad;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class AdManager {
    private HashMap<String, InterstitialAdItem> interstitialAdItemHashMap = new HashMap<>();
    private HashMap<String, AdListener> adListenerHashMap = new HashMap<>();

    public class a implements Runnable {
        public final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdListener f2855b;
        public final /* synthetic */ Context c;

        /* JADX INFO: renamed from: com.tnkfactory.ad.AdManager$a$a, reason: collision with other inner class name */
        public class C0527a extends AdListener {
            public final /* synthetic */ AdListener a;

            public C0527a(AdListener adListener) {
                this.a = adListener;
            }

            @Override // com.tnkfactory.ad.AdListener
            public final void onClick(AdItem adItem) {
                AdListener adListener = this.a;
                if (adListener != null) {
                    adListener.onClick(adItem);
                }
            }

            @Override // com.tnkfactory.ad.AdListener
            public final void onClose(AdItem adItem, int i) {
                AdListener adListener = this.a;
                if (adListener != null) {
                    adListener.onClose(adItem, i);
                }
            }

            @Override // com.tnkfactory.ad.AdListener
            public final void onError(AdItem adItem, AdError adError) {
                AdListener adListener = this.a;
                if (adListener != null) {
                    adListener.onError(adItem, adError);
                }
            }

            @Override // com.tnkfactory.ad.AdListener
            public final void onLoad(AdItem adItem) {
                AdListener adListener = this.a;
                if (adListener != null) {
                    adListener.onLoad(adItem);
                }
                adItem.show(a.this.c);
            }

            @Override // com.tnkfactory.ad.AdListener
            public final void onShow(AdItem adItem) {
                AdListener adListener = this.a;
                if (adListener != null) {
                    adListener.onShow(adItem);
                }
            }

            @Override // com.tnkfactory.ad.AdListener
            public final void onVideoCompletion(AdItem adItem, int i) {
                AdListener adListener = this.a;
                if (adListener != null) {
                    adListener.onVideoCompletion(adItem, i);
                }
            }
        }

        public a(String str, AdListener adListener, Context context) {
            this.a = str;
            this.f2855b = adListener;
            this.c = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            InterstitialAdItem interstitialAdItem = (InterstitialAdItem) AdManager.this.interstitialAdItemHashMap.get(this.a);
            if (interstitialAdItem == null) {
                return;
            }
            AdListener adListener = this.f2855b;
            if (adListener != null) {
                interstitialAdItem.setListener(adListener);
                AdManager.this.adListenerHashMap.put(this.a, this.f2855b);
            }
            if (interstitialAdItem.isLoaded()) {
                interstitialAdItem.show(this.c);
            } else {
                interstitialAdItem.setListener(new C0527a((AdListener) AdManager.this.adListenerHashMap.get(this.a)));
            }
        }
    }

    public static class b {
        public static final AdManager a = new AdManager();
    }

    public static AdManager getInstance() {
        return b.a;
    }

    public InterstitialAdItem getInterstitialAdItem(String str) {
        return this.interstitialAdItemHashMap.get(str);
    }

    public void loadInterstitialAd(Context context, String str) {
        loadInterstitialAd(context, str, null);
    }

    public void loadInterstitialAd(Context context, String str, AdListener adListener) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        InterstitialAdItem interstitialAdItem = new InterstitialAdItem(context, str);
        if (adListener != null) {
            interstitialAdItem.setListener(adListener);
            this.adListenerHashMap.put(str, adListener);
        }
        interstitialAdItem.load();
        this.interstitialAdItemHashMap.put(str, interstitialAdItem);
    }

    public void showInterstitialAd(Context context, String str) {
        showInterstitialAd(context, str, null);
    }

    public void showInterstitialAd(Context context, String str, AdListener adListener) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new a(str, adListener, context));
    }
}
