package com.tapjoy.internal;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class wa extends AbstractMap {
    public final HashMap a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t4 f2829b = new t4();

    public final void a() {
        while (true) {
            s4 s4VarA = this.f2829b.a();
            if (s4VarA == null) {
                return;
            } else {
                this.a.remove(s4VarA.a);
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.a.clear();
        while (this.f2829b.a() != null) {
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        a();
        return this.a.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        a();
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            if (obj.equals(((s4) it.next()).get())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        a();
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        a();
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        a();
        s4 s4Var = (s4) this.a.get(obj);
        if (s4Var != null) {
            return s4Var.get();
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        a();
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        a();
        return this.a.keySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        a();
        HashMap map = this.a;
        t4 t4Var = this.f2829b;
        t4Var.getClass();
        s4 s4Var = (s4) map.put(obj, new s4(obj, obj2, t4Var));
        if (s4Var != null) {
            return s4Var.get();
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        a();
        s4 s4Var = (s4) this.a.remove(obj);
        if (s4Var != null) {
            return s4Var.get();
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        a();
        return this.a.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        a();
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        a();
        throw new UnsupportedOperationException();
    }
}
