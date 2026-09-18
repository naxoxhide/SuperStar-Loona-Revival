package com.fyber.inneractive.sdk.renderers;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.flow.f0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n {
    public com.fyber.inneractive.sdk.player.controller.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.fyber.inneractive.sdk.player.ui.h f1318b;
    public com.fyber.inneractive.sdk.player.e c;

    public n(com.fyber.inneractive.sdk.player.h hVar) {
        this.c = (com.fyber.inneractive.sdk.player.e) hVar.c();
    }

    public abstract com.fyber.inneractive.sdk.player.controller.b a(InneractiveAdSpot inneractiveAdSpot, f0 f0Var);

    public abstract void a(com.fyber.inneractive.sdk.player.c.InterfaceC0276c interfaceC0276c);

    public boolean a() {
        String str;
        f0 f0Var;
        com.fyber.inneractive.sdk.player.e eVar = this.c;
        com.fyber.inneractive.sdk.response.g gVar = (eVar == null || (f0Var = eVar.e) == null) ? null : (com.fyber.inneractive.sdk.response.g) f0Var.f927b;
        return !((gVar == null || (str = gVar.C) == null || !TextUtils.equals(str, "1")) ? false : true);
    }

    public String b() {
        f0 f0Var;
        com.fyber.inneractive.sdk.player.e eVar = this.c;
        com.fyber.inneractive.sdk.response.g gVar = (eVar == null || (f0Var = eVar.e) == null) ? null : (com.fyber.inneractive.sdk.response.g) f0Var.f927b;
        if (gVar != null) {
            return gVar.D;
        }
        return null;
    }

    public abstract boolean c();
}
