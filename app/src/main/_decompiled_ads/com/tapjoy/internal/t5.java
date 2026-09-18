package com.tapjoy.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class t5 extends IllegalArgumentException {
    public t5(int i, Class cls) {
        super("Unknown enum tag " + i + " for " + cls.getCanonicalName());
    }
}
