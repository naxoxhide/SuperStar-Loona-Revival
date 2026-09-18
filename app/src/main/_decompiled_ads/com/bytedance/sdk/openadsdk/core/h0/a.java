package com.bytedance.sdk.openadsdk.core.h0;

import android.content.Context;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.n.b;
import com.bytedance.sdk.openadsdk.n.c;

/* JADX INFO: compiled from: TncHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f597b = Integer.parseInt("1371");

    public static void a() {
        Context contextA;
        if (!o.d().H() || a || (contextA = o.a()) == null) {
            return;
        }
        try {
            m.d("TncHelper", "initTTAdNet: support TNC");
            c.b().d().a(contextA, true, new b(contextA));
            c.b().d().a(contextA, com.bytedance.sdk.openadsdk.m.b.b());
            a = true;
        } catch (Exception e) {
            m.b("TncHelper", "initTTAdNet: ", e.getMessage());
        }
    }

    public static void b() {
        Context contextA;
        if (a && o.d().H() && (contextA = o.a()) != null) {
            b.b.a.a.j.e.a.a(contextA, f597b);
        }
    }
}
