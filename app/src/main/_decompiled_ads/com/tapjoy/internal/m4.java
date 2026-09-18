package com.tapjoy.internal;

import android.graphics.Bitmap;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class m4 implements h0 {
    public final LinkedHashMap a = new LinkedHashMap(0, 0.75f, true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2783b = 10;

    @Override // com.tapjoy.internal.h0
    public final Object a(URL url) {
        x xVar = (x) this.a.get(url);
        if (xVar != null) {
            return xVar.f2830b;
        }
        return null;
    }

    @Override // com.tapjoy.internal.h0
    public final void a(URL url, Bitmap bitmap) {
        x xVar = (x) this.a.get(url);
        if (xVar == null) {
            xVar = new x(url);
            this.a.put(url, xVar);
            int size = this.a.size() - this.f2783b;
            if (size > 0) {
                Iterator it = this.a.entrySet().iterator();
                while (size > 0 && it.hasNext()) {
                    size--;
                    it.next();
                    it.remove();
                }
            }
        }
        xVar.f2830b = bitmap;
        int size2 = this.a.size() - this.f2783b;
        if (size2 > 0) {
            Iterator it2 = this.a.entrySet().iterator();
            while (size2 > 0 && it2.hasNext()) {
                size2--;
                it2.next();
                it2.remove();
            }
        }
    }
}
