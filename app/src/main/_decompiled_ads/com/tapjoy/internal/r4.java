package com.tapjoy.internal;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes4.dex */
public final class r4 extends AbstractList implements RandomAccess, Serializable {
    public final List a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f2807b;

    public r4(List list) {
        this.a = list;
        this.f2807b = list;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        if (this.f2807b == this.a) {
            this.f2807b = new ArrayList(this.a);
        }
        this.f2807b.add(i, obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.f2807b.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        if (this.f2807b == this.a) {
            this.f2807b = new ArrayList(this.a);
        }
        return this.f2807b.remove(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        if (this.f2807b == this.a) {
            this.f2807b = new ArrayList(this.a);
        }
        return this.f2807b.set(i, obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2807b.size();
    }
}
