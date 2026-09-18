package com.fyber.inneractive.sdk.config.global.features;

import com.facebook.appevents.integrity.IntegrityManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;

/* JADX INFO: loaded from: classes2.dex */
public class r extends g {
    public static final b e = b.NONE;
    public static final c f = c.NONE;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[UnitDisplayType.values().length];
            a = iArr;
            try {
                iArr[UnitDisplayType.REWARDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[UnitDisplayType.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum b {
        NONE(IntegrityManager.INTEGRITY_TYPE_NONE),
        OPEN("open");

        public String mKey;

        b(String str) {
            this.mKey = str;
        }
    }

    public enum c {
        NONE(IntegrityManager.INTEGRITY_TYPE_NONE),
        ZOOM_IN("endcard_zoom_in");

        public String mKey;

        c(String str) {
            this.mKey = str;
        }
    }

    public enum d {
        LEGACY("legacy"),
        EXTRACTOR("extractor"),
        NONE(IntegrityManager.INTEGRITY_TYPE_NONE);

        public String key;

        d(String str) {
            this.key = str;
        }
    }

    public r() {
        super("video_player");
    }

    public int a(UnitDisplayType unitDisplayType) {
        if (unitDisplayType == UnitDisplayType.INTERSTITIAL) {
            Integer numB = b("prebuffer_interstitial");
            if (numB != null) {
                return numB.intValue();
            }
            return 3;
        }
        Integer numB2 = b("prebuffer_rewarded");
        if (numB2 != null) {
            return numB2.intValue();
        }
        return 3;
    }

    @Override // com.fyber.inneractive.sdk.config.global.features.g
    public g b() {
        r rVar = new r();
        a(rVar);
        return rVar;
    }

    public boolean d() {
        return a("cta_text_all_caps", false);
    }

    public int e() {
        Integer numB = b("dl_retries");
        if (numB != null) {
            return numB.intValue();
        }
        return 10;
    }

    public int f() {
        Integer numB = b("dl_retry_delay");
        if (numB != null) {
            return numB.intValue();
        }
        return 500;
    }

    public int g() {
        Integer numB = b("max_tries");
        if (numB != null) {
            return numB.intValue();
        }
        return 0;
    }

    public int h() {
        Integer numB = b("second_checkpoint");
        if (numB != null) {
            return numB.intValue();
        }
        return 25;
    }
}
