package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.global.features.r;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.flow.d0;
import com.fyber.inneractive.sdk.flow.f0;
import com.fyber.inneractive.sdk.flow.g0;

/* JADX INFO: loaded from: classes2.dex */
public class c extends n {
    public boolean d;

    public c(com.fyber.inneractive.sdk.player.h hVar) {
        super(hVar);
        this.d = false;
    }

    public com.fyber.inneractive.sdk.player.ui.h a(Context context, s sVar) {
        f0 f0Var;
        r rVar;
        if (this.f1318b == null) {
            boolean zA = false;
            if (sVar != null && (rVar = (r) sVar.a(r.class)) != null) {
                this.d = rVar.a("use_video_design", false);
            }
            com.fyber.inneractive.sdk.flow.e eVar = null;
            com.fyber.inneractive.sdk.player.e eVar2 = this.c;
            if (eVar2 != null && (f0Var = eVar2.e) != null) {
                eVar = new com.fyber.inneractive.sdk.flow.e(f0Var.a, f0Var.f927b, sVar);
                com.fyber.inneractive.sdk.player.e eVar3 = this.c;
                T t = eVar3.e.f927b;
                zA = eVar3.a(sVar, t != 0 ? ((com.fyber.inneractive.sdk.response.g) t).F : com.fyber.inneractive.sdk.ignite.k.NONE);
            }
            boolean z = zA;
            com.fyber.inneractive.sdk.flow.e eVar4 = eVar;
            if (this.d) {
                this.f1318b = new com.fyber.inneractive.sdk.player.ui.j(context, eVar4, new com.fyber.inneractive.sdk.player.ui.e(), sVar, z, b());
            } else {
                this.f1318b = new com.fyber.inneractive.sdk.player.ui.k(context, eVar4, new com.fyber.inneractive.sdk.player.ui.e(), sVar, z, b());
            }
        }
        return this.f1318b;
    }

    @Override // com.fyber.inneractive.sdk.renderers.n
    public boolean c() {
        this.c.getClass();
        return false;
    }

    @Override // com.fyber.inneractive.sdk.renderers.n
    public com.fyber.inneractive.sdk.player.controller.b a(InneractiveAdSpot inneractiveAdSpot, f0 f0Var) {
        if (this.a == null) {
            Object selectedUnitController = inneractiveAdSpot.getSelectedUnitController();
            boolean zIsOverlayOutside = selectedUnitController instanceof g0 ? ((g0) selectedUnitController).isOverlayOutside() : false;
            Skip skipA = inneractiveAdSpot instanceof d0 ? ((d0) inneractiveAdSpot).a() : null;
            if (this.d) {
                this.a = new com.fyber.inneractive.sdk.player.controller.e(this.c, (com.fyber.inneractive.sdk.player.ui.j) this.f1318b, inneractiveAdSpot.getAdContent().d, f0Var.c, false, zIsOverlayOutside, skipA, f0Var.h(), b(), a());
            } else {
                this.a = new com.fyber.inneractive.sdk.player.controller.e(this.c, (com.fyber.inneractive.sdk.player.ui.k) this.f1318b, inneractiveAdSpot.getAdContent().d, f0Var.c, false, zIsOverlayOutside, skipA, f0Var.h(), b(), a());
            }
        }
        return this.a;
    }

    @Override // com.fyber.inneractive.sdk.renderers.n
    public void a(com.fyber.inneractive.sdk.player.c.InterfaceC0276c interfaceC0276c) {
        com.fyber.inneractive.sdk.player.e eVar = this.c;
        eVar.getClass();
        interfaceC0276c.a(eVar);
    }
}
