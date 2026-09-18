package com.tapjoy.internal;

import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class n0 extends Observable {
    public final ArrayList a = new ArrayList();

    public final m0 a() {
        m0 m0Var = new m0();
        this.a.add(m0Var);
        return m0Var;
    }

    @Override // java.util.Observable
    public final void setChanged() {
        super.setChanged();
        notifyObservers();
    }

    public final boolean a(String str) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            Map map = ((m0) it.next()).a;
            Object obj = map != null ? map.get(str) : null;
            if (obj != null) {
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue();
                }
                if (!(obj instanceof String)) {
                    continue;
                } else {
                    if ("true".equals(obj)) {
                        return true;
                    }
                    if (TJAdUnitConstants.String.FALSE.equals(obj)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
