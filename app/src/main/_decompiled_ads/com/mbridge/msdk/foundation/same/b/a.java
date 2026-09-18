package com.mbridge.msdk.foundation.same.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Directory.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2103b;
    private a c;
    private List<a> d;

    public final c a() {
        return this.a;
    }

    public final void a(c cVar) {
        this.a = cVar;
    }

    public final String b() {
        return this.f2103b;
    }

    public final void a(String str) {
        this.f2103b = str;
    }

    public final a c() {
        return this.c;
    }

    public final List<a> d() {
        return this.d;
    }

    private void a(a aVar) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        aVar.c = this;
        this.d.add(aVar);
    }

    public final void a(c cVar, String str) {
        a aVar = new a();
        aVar.a = cVar;
        aVar.f2103b = str;
        a(aVar);
    }

    public final void a(List<a> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }
}
