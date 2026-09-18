package com.fyber.inneractive.sdk.config;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Iterable<a0> {
    public List<a0> a = new LinkedList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f901b = true;

    public a0 c(int i) {
        return this.a.get(i);
    }

    @Override // java.lang.Iterable
    public Iterator<a0> iterator() {
        return this.a.iterator();
    }
}
