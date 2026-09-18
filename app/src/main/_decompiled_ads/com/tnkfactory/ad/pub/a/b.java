package com.tnkfactory.ad.pub.a;

import com.tnkfactory.ad.AdItem;
import com.tnkfactory.ad.BannerAdView;
import com.tnkfactory.ad.FeedAdView;
import com.tnkfactory.ad.InterstitialAdItem;
import com.tnkfactory.ad.NativeAdItem;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    public AdItem a;

    public static class a extends b {
        public a(AdItem adItem) {
            super(adItem);
        }

        @Override // com.tnkfactory.ad.pub.a.b
        public final r a(String str) {
            return new m(this.a, str);
        }
    }

    /* JADX INFO: renamed from: com.tnkfactory.ad.pub.a.b$b, reason: collision with other inner class name */
    public static class C0528b extends b {
        public C0528b(AdItem adItem) {
            super(adItem);
        }

        @Override // com.tnkfactory.ad.pub.a.b
        public final r a(String str) {
            return null;
        }
    }

    public static class c extends b {
        public c(AdItem adItem) {
            super(adItem);
        }

        @Override // com.tnkfactory.ad.pub.a.b
        public final r a(String str) {
            return new e0(this.a, str);
        }
    }

    public static class d extends b {
        public d(AdItem adItem) {
            super(adItem);
        }

        @Override // com.tnkfactory.ad.pub.a.b
        public final r a(String str) {
            return new h0(this.a, str);
        }
    }

    public static class e extends b {
        public e(AdItem adItem) {
            super(adItem);
        }

        @Override // com.tnkfactory.ad.pub.a.b
        public final r a(String str) {
            return new n0(this.a, str);
        }
    }

    public b(AdItem adItem) {
        this.a = adItem;
    }

    public static b a(AdItem adItem) {
        if (adItem instanceof InterstitialAdItem) {
            return new d(adItem);
        }
        if (adItem instanceof NativeAdItem) {
            return new e(adItem);
        }
        if (adItem instanceof BannerAdView) {
            return new a(adItem);
        }
        return adItem instanceof FeedAdView ? new c(adItem) : new C0528b(adItem);
    }

    public abstract r a(String str);
}
