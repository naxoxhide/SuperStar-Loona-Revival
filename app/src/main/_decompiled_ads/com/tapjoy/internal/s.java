package com.tapjoy.internal;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: classes4.dex */
public final class s extends q implements Observer {
    public static final /* synthetic */ int f = 0;
    public boolean d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f2809b = new HashMap();
    public final ma c = new ma();
    public final r e = new r();

    static {
        q.a = new s();
    }

    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        j3 j3Var = k3.a;
    }
}
