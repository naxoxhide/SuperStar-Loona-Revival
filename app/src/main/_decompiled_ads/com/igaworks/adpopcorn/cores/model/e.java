package com.igaworks.adpopcorn.cores.model;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private int c;
    private List<g> e;
    private boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1620b = 0;
    private String d = "";

    public List<g> a() {
        return this.e;
    }

    public void a(int i) {
        this.f1620b = i;
    }

    public void a(long j) {
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(List<g> list) {
        this.e = list;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public int b() {
        return this.f1620b;
    }

    public void b(int i) {
        this.c = i;
    }

    public String c() {
        return this.d;
    }

    public int d() {
        return this.c;
    }

    public boolean e() {
        return this.a;
    }
}
