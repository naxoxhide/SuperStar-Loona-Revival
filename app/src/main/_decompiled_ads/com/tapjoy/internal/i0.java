package com.tapjoy.internal;

import android.graphics.Bitmap;
import java.net.URL;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class i0 implements m7 {
    public final m4 a;

    public i0(m4 m4Var) {
        this.a = m4Var;
    }

    @Override // com.tapjoy.internal.h0
    public final Object a(URL url) {
        x xVar;
        Object obj;
        synchronized (this.a) {
            xVar = (x) this.a.a.get(url);
        }
        if (xVar == null) {
            return null;
        }
        synchronized (xVar) {
            obj = xVar.f2830b;
        }
        return obj;
    }

    @Override // com.tapjoy.internal.h0
    public final void a(URL url, Bitmap bitmap) {
        x xVar;
        synchronized (this.a) {
            m4 m4Var = this.a;
            xVar = (x) m4Var.a.get(url);
            if (xVar == null) {
                xVar = new x(url);
                m4Var.a.put(url, xVar);
                int size = m4Var.a.size() - m4Var.f2783b;
                if (size > 0) {
                    Iterator it = m4Var.a.entrySet().iterator();
                    while (size > 0 && it.hasNext()) {
                        size--;
                        it.next();
                        it.remove();
                    }
                }
            }
        }
        synchronized (xVar) {
            xVar.f2830b = bitmap;
        }
    }
}
