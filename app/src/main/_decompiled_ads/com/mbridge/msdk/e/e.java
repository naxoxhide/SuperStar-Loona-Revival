package com.mbridge.msdk.e;

import java.io.Serializable;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: Event.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e implements Serializable {
    private String a;
    private JSONObject d;
    private h i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2039b = 0;
    private int c = 0;
    private long g = 0;
    private long h = 604800000;
    private boolean j = false;
    private boolean k = false;
    private long f = System.currentTimeMillis();
    private String e = UUID.randomUUID().toString();

    public e(String str) {
        this.a = str;
    }

    public final String a() {
        return this.a;
    }

    public final int b() {
        return this.f2039b;
    }

    public final void a(int i) {
        this.f2039b = i;
    }

    public final int c() {
        return this.c;
    }

    public final void b(int i) {
        this.c = i;
    }

    public final JSONObject d() {
        return this.d;
    }

    public final void a(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public final String e() {
        return this.e;
    }

    final void a(String str) {
        this.e = str;
    }

    public final long f() {
        return this.f;
    }

    public final void a(long j) {
        this.f = j;
    }

    public final long g() {
        return this.g;
    }

    public final void b(long j) {
        this.g = j;
    }

    final void c(long j) {
        this.h = j;
    }

    public final long h() {
        return this.h;
    }

    public final h i() {
        return this.i;
    }

    public final void a(h hVar) {
        this.i = hVar;
    }

    public final boolean j() {
        return this.j;
    }

    public final void a(boolean z) {
        this.k = z;
    }

    public final boolean k() {
        return this.k;
    }
}
