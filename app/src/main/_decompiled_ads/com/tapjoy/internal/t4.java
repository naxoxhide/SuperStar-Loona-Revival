package com.tapjoy.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes4.dex */
public final class t4 extends ReferenceQueue {
    public final s4 a() {
        return (s4) super.poll();
    }

    @Override // java.lang.ref.ReferenceQueue
    public final Reference poll() {
        return (s4) super.poll();
    }
}
