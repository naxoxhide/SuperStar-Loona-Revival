package com.fyber.inneractive.sdk.config.global.features;

import com.facebook.appevents.integrity.IntegrityManager;

/* JADX INFO: loaded from: classes2.dex */
public class a extends g {
    public static final EnumC0259a e = EnumC0259a.NONE;

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.config.global.features.a$a, reason: collision with other inner class name */
    public enum EnumC0259a {
        NONE(IntegrityManager.INTEGRITY_TYPE_NONE),
        OPEN("open");

        public String mKey;

        EnumC0259a(String str) {
            this.mKey = str;
        }
    }

    public a() {
        super("ad_identifier");
    }

    @Override // com.fyber.inneractive.sdk.config.global.features.g
    public g b() {
        a aVar = new a();
        a(aVar);
        return aVar;
    }
}
