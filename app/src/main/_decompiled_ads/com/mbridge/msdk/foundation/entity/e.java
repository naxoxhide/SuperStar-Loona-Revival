package com.mbridge.msdk.foundation.entity;

import java.util.Map;

/* JADX INFO: compiled from: DescExceptionData.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2089b;
    private String c;
    private int d;
    private int e = -1;
    private String f;
    private Map<String, String> g;

    public final int a() {
        return this.e;
    }

    public final void a(int i) {
        this.e = i;
    }

    public final String b() {
        return this.f;
    }

    public final void a(String str) {
        this.f = str;
    }

    public e(int i, String str, Map<String, String> map) {
        this.f2089b = 0;
        this.f2089b = i;
        this.c = str;
        this.g = map;
        g();
    }

    public e(int i, String str, boolean z) {
        this.f2089b = 0;
        if (z) {
            if (i == 200) {
                this.f2089b = 4;
            } else if (i == 201) {
                this.f2089b = 7;
            } else if (i == 203) {
                this.f2089b = 6;
            } else if (i == 205) {
                this.f2089b = 5;
            }
        }
        this.c = str;
        g();
    }

    private void g() {
        try {
            switch (this.f2089b) {
                case 0:
                    this.a = "v3 params invalid";
                    break;
                case 1:
                    this.a = "v3 request error";
                    break;
                case 2:
                    this.a = "v3 time out";
                    break;
                case 3:
                    this.a = "v3 response error";
                    break;
                case 4:
                    this.a = "video download error";
                    break;
                case 5:
                    this.a = "big template download error";
                    break;
                case 6:
                    this.a = "template download error";
                    break;
                case 7:
                    this.a = "endcard template download error";
                    break;
                case 8:
                    this.a = "big template render error";
                    break;
                case 9:
                    this.a = "template render error";
                    break;
                case 10:
                    this.a = " load time out error";
                    break;
                case 11:
                    this.a = " no fill";
                    break;
                case 15:
                    this.a = " isready false error";
                    break;
                case 16:
                    this.a = "current unit is loading";
                    break;
                case 17:
                    this.a = "adn no offer fill";
                    break;
                case 18:
                    this.a = "app already install";
                    break;
                case 19:
                    this.a = "ad over cap ";
                    break;
                case 20:
                    this.a = "load exception";
                    break;
                case 21:
                    this.a = "candidate failed";
                    break;
            }
        } catch (Exception unused) {
            this.a = " unknown error";
        }
    }

    public e(int i, String str) {
        this.f2089b = 0;
        this.f2089b = i;
        this.c = str;
        g();
    }

    public final int c() {
        return this.f2089b;
    }

    public final void b(int i) {
        this.f2089b = i;
    }

    public final String d() {
        return this.c;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final int e() {
        return this.d;
    }

    public final void c(int i) {
        this.d = i;
    }

    public final Map<String, String> f() {
        return this.g;
    }
}
