package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import com.bytedance.sdk.openadsdk.core.f0.q;
import org.json.JSONObject;

/* JADX INFO: compiled from: ExpressInitHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: compiled from: ExpressInitHelper.java */
    static class a implements b.b.a.a.d.e.a.b {
        a() {
        }

        @Override // b.b.a.a.d.e.a.b
        public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
            return com.bytedance.sdk.openadsdk.m.f.a.a(com.bytedance.sdk.openadsdk.core.o.a(), str, contentValues, str2, strArr);
        }

        @Override // b.b.a.a.d.e.a.b
        public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            return new com.bytedance.sdk.openadsdk.multipro.aidl.c(com.bytedance.sdk.openadsdk.m.f.a.a(com.bytedance.sdk.openadsdk.core.o.a(), str, strArr, str2, strArr2, str3, str4, str5));
        }

        @Override // b.b.a.a.d.e.a.b
        public int a(String str, String str2, String[] strArr) {
            return com.bytedance.sdk.openadsdk.m.f.a.a(com.bytedance.sdk.openadsdk.core.o.a(), str, str2, strArr);
        }

        @Override // b.b.a.a.d.e.a.b
        public void a(String str, ContentValues contentValues) {
            com.bytedance.sdk.openadsdk.m.f.a.a(com.bytedance.sdk.openadsdk.core.o.a(), str, contentValues);
        }
    }

    /* JADX INFO: compiled from: ExpressInitHelper.java */
    static class b implements b.b.a.a.d.e.a.c {
        b() {
        }

        @Override // b.b.a.a.d.e.a.c
        public b.b.a.a.d.e.c.a a() {
            return com.bytedance.sdk.openadsdk.core.o.c().a();
        }

        @Override // b.b.a.a.d.e.a.c
        public int b() {
            return com.bytedance.sdk.openadsdk.core.o.d().b();
        }

        @Override // b.b.a.a.d.e.a.c
        public int c() {
            if (com.bytedance.sdk.openadsdk.core.o.d() == null) {
                return 0;
            }
            return com.bytedance.sdk.openadsdk.core.o.d().c();
        }

        @Override // b.b.a.a.d.e.a.c
        public b.b.a.a.j.d.b d() {
            return com.bytedance.sdk.openadsdk.n.c.b().d().b();
        }

        @Override // b.b.a.a.d.e.a.c
        public Context e() {
            return com.bytedance.sdk.openadsdk.core.o.a();
        }

        @Override // b.b.a.a.d.e.a.c
        public int f() {
            return 1;
        }

        @Override // b.b.a.a.d.e.a.c
        public b.b.a.a.j.d.a g() {
            return com.bytedance.sdk.openadsdk.n.c.b().d().a();
        }

        @Override // b.b.a.a.d.e.a.c
        public String getAppId() {
            return com.bytedance.sdk.openadsdk.core.h.a().d();
        }

        @Override // b.b.a.a.d.e.a.c
        public int h() {
            return 0;
        }

        @Override // b.b.a.a.d.e.a.c
        public void i() {
        }

        @Override // b.b.a.a.d.e.a.c
        public Handler j() {
            return com.bytedance.sdk.openadsdk.core.l.c();
        }
    }

    /* JADX INFO: compiled from: ExpressInitHelper.java */
    static class d implements com.bytedance.sdk.component.widget.a.b {
        d() {
        }

        @Override // com.bytedance.sdk.component.widget.a.b
        public void a(com.bytedance.sdk.component.widget.b.a aVar, String str, String str2, JSONObject jSONObject, long j) {
            q qVarL1 = q.l1();
            qVarL1.G(aVar.b());
            qVarL1.r(aVar.a());
            qVarL1.f(aVar.c());
            com.bytedance.sdk.openadsdk.d.c.a(qVarL1, str, str2, jSONObject, j);
        }
    }

    public static void a() {
        b.b.a.a.d.e.a.a.d().a(new a());
        b.b.a.a.d.e.a.a.d().a(new b());
        b.b.a.a.d.e.a.a.d().a(new c());
        com.bytedance.sdk.component.widget.a.a.a().a(new d());
    }

    /* JADX INFO: compiled from: ExpressInitHelper.java */
    static class c implements b.b.a.a.d.e.a.d {
        c() {
        }

        @Override // b.b.a.a.d.e.a.d
        public void a(int i) {
            com.bytedance.sdk.openadsdk.l.b.a().c(com.bytedance.sdk.openadsdk.l.c.b.o().b(i).b(com.bytedance.sdk.openadsdk.core.g.a(i)));
        }

        @Override // b.b.a.a.d.e.a.d
        public void a(int i, String str) {
            com.bytedance.sdk.openadsdk.l.b.a().d(com.bytedance.sdk.openadsdk.l.c.b.o().b(i).b(str));
        }
    }
}
