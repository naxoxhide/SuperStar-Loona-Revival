package com.mbridge.msdk.foundation.same.net;

import android.content.Context;

/* JADX INFO: compiled from: VolleyManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final class n {
    private static n d;
    private j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f2157b;
    private com.mbridge.msdk.foundation.same.net.d.b c;

    private n() {
    }

    public static void a(Context context) {
        if (d == null) {
            n nVar = new n();
            d = nVar;
            nVar.a = new j(context.getApplicationContext());
            d.c = new com.mbridge.msdk.foundation.same.net.d.b(b(), 3);
        }
    }

    public static void b(i iVar) {
        b().a(iVar);
    }

    private static j b() {
        n nVar = d;
        if (nVar != null) {
            j jVar = nVar.a;
            if (jVar != null) {
                return jVar;
            }
            nVar.a = new j(com.mbridge.msdk.foundation.controller.b.d().g());
            return d.a;
        }
        n nVar2 = new n();
        d = nVar2;
        if (nVar2.a == null) {
            nVar2.a = new j(com.mbridge.msdk.foundation.controller.b.d().g());
        }
        return d.a;
    }

    public static com.mbridge.msdk.foundation.same.net.d.b a() {
        n nVar = d;
        if (nVar != null) {
            com.mbridge.msdk.foundation.same.net.d.b bVar = nVar.c;
            if (bVar != null) {
                return bVar;
            }
            nVar.c = new com.mbridge.msdk.foundation.same.net.d.b(b(), 3);
            return d.c;
        }
        n nVar2 = new n();
        d = nVar2;
        if (nVar2.c == null) {
            nVar2.c = new com.mbridge.msdk.foundation.same.net.d.b(b(), 3);
        }
        return d.c;
    }

    public static void a(i iVar) {
        n nVar = d;
        if (nVar != null) {
            if (nVar.f2157b == null) {
                nVar.f2157b = new j(com.mbridge.msdk.foundation.controller.b.d().g(), null);
            }
        } else {
            n nVar2 = new n();
            d = nVar2;
            if (nVar2.f2157b == null) {
                nVar2.f2157b = new j(com.mbridge.msdk.foundation.controller.b.d().g(), null);
            }
        }
        d.f2157b.a(iVar);
    }
}
