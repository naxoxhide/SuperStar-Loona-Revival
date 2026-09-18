package com.iab.omid.library.bytedance2.adsession;

import com.facebook.appevents.integrity.IntegrityManager;

/* JADX INFO: loaded from: classes3.dex */
public enum Owner {
    NATIVE("native"),
    JAVASCRIPT("javascript"),
    NONE(IntegrityManager.INTEGRITY_TYPE_NONE);

    private final String owner;

    Owner(String str) {
        this.owner = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.owner;
    }
}
