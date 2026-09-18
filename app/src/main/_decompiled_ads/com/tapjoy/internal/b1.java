package com.tapjoy.internal;

import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes4.dex */
public final class b1 extends ThreadLocal {
    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
    }
}
