package com.tapjoy.internal;

import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class g5 {
    public final v1 a;

    public g5(v1 v1Var) {
        this.a = v1Var;
        Collections.synchronizedMap(new HashMap());
        new HashMap();
    }

    public final void a() {
        synchronized (this) {
        }
    }
}
