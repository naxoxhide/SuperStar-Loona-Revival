package com.tapjoy.internal;

import com.tapjoy.TJCacheListener;

/* JADX INFO: loaded from: classes4.dex */
public final class r8 implements TJCacheListener {
    public final /* synthetic */ TJCacheListener a;

    public r8(m8 m8Var) {
        this.a = m8Var;
    }

    @Override // com.tapjoy.TJCacheListener
    public final void onCachingComplete(int i) {
        this.a.onCachingComplete(i);
    }
}
