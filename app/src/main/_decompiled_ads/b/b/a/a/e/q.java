package b.b.a.a.e;

import android.text.TextUtils;

/* JADX INFO: compiled from: Js2JavaCall.java */
/* JADX INFO: loaded from: classes.dex */
public class q {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f136b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    /* JADX INFO: compiled from: Js2JavaCall.java */
    public static final class b {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f137b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;

        private b() {
        }

        public b a(String str) {
            this.e = str;
            return this;
        }

        public b b(String str) {
            this.g = str;
            return this;
        }

        public b c(String str) {
            this.c = str;
            return this;
        }

        public b d(String str) {
            this.f = str;
            return this;
        }

        public b e(String str) {
            this.d = str;
            return this;
        }

        public b f(String str) {
            this.f137b = str;
            return this;
        }

        public b g(String str) {
            this.a = str;
            return this;
        }

        public q a() {
            return new q(this);
        }
    }

    public static b a() {
        return new b();
    }

    public String toString() {
        return "methodName: " + this.d + ", params: " + this.e + ", callbackId: " + this.f + ", type: " + this.c + ", version: " + this.f136b + ", ";
    }

    private q(String str, int i) {
        this.f136b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = str;
        this.g = null;
        this.a = i;
        this.h = null;
    }

    public static q a(String str, int i) {
        return new q(str, i);
    }

    public static boolean a(q qVar) {
        return qVar == null || qVar.a != 1 || TextUtils.isEmpty(qVar.d) || TextUtils.isEmpty(qVar.e);
    }

    private q(b bVar) {
        this.f136b = bVar.a;
        this.c = bVar.f137b;
        this.d = bVar.c;
        this.e = bVar.d;
        this.f = bVar.e;
        this.g = bVar.f;
        this.a = 1;
        this.h = bVar.g;
    }
}
