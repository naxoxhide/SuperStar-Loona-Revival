package com.fyber.inneractive.sdk.player.controller;

import android.media.AudioManager;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.c0;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.k0;

/* JADX INFO: loaded from: classes2.dex */
public class e extends n<w> {
    public boolean C;
    public boolean D;
    public boolean E;

    public e(com.fyber.inneractive.sdk.player.c cVar, com.fyber.inneractive.sdk.player.ui.l lVar, b0 b0Var, com.fyber.inneractive.sdk.config.global.s sVar, boolean z, boolean z2, Skip skip, boolean z3, String str, boolean z4) {
        super(cVar, lVar, b0Var, sVar, z2, skip, str, z4);
        this.C = false;
        this.D = false;
        this.C = z;
        this.E = z3;
    }

    public static boolean d(int i) {
        return i > -1 && i <= 8;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.n
    public void A() {
        super.A();
        this.d.b(false);
        if (this.C) {
            this.d.i();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.n
    public boolean B() {
        return !this.C;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.n
    public void D() {
        g gVar;
        super.D();
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar == null || (gVar = cVar.f1002b) == null || !gVar.e.equals(com.fyber.inneractive.sdk.player.enums.b.Completed) || !this.C) {
            return;
        }
        this.d.i();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.n, com.fyber.inneractive.sdk.player.ui.i
    public void a(boolean z) {
        com.fyber.inneractive.sdk.player.c cVar;
        g gVar;
        if (z && (cVar = this.a) != null && (gVar = cVar.f1002b) != null && !gVar.e.equals(com.fyber.inneractive.sdk.player.enums.b.Completed) && !this.d.f()) {
            h(false);
        }
        super.a(z);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.n, com.fyber.inneractive.sdk.player.ui.i
    public void b() {
        if (this.h) {
            v();
        } else {
            k();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.n, com.fyber.inneractive.sdk.player.controller.b
    public void d(boolean z) {
        g gVar;
        com.fyber.inneractive.sdk.player.enums.b bVar;
        super.d(z);
        if (this.C) {
            this.d.i();
            this.d.d(false);
            this.f = 0;
        }
        C();
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        this.d.b((cVar == null || (gVar = cVar.f1002b) == null || ((bVar = gVar.e) != com.fyber.inneractive.sdk.player.enums.b.Preparing && bVar != com.fyber.inneractive.sdk.player.enums.b.Prepared)) ? false : true);
        this.d.c(false);
        com.fyber.inneractive.sdk.player.ui.l lVar = this.d;
        com.fyber.inneractive.sdk.player.ui.c cVar2 = new com.fyber.inneractive.sdk.player.ui.c();
        cVar2.f1265b = false;
        lVar.d(new com.fyber.inneractive.sdk.player.ui.b(cVar2));
    }

    /* JADX WARN: Code duplicated, block: B:33:0x006f  */
    @Override // com.fyber.inneractive.sdk.player.controller.n
    public boolean k() {
        int ringerMode;
        int streamVolume;
        super.k();
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar != null && cVar.f1002b != null && !this.D) {
            try {
                AudioManager audioManager = (AudioManager) this.d.getContext().getSystemService("audio");
                ringerMode = audioManager.getRingerMode();
                try {
                    streamVolume = audioManager.getStreamVolume(2);
                } catch (Throwable unused) {
                    streamVolume = 0;
                }
            } catch (Throwable unused2) {
                ringerMode = 0;
            }
            if (!this.C && ((a0) this.f1023b).f.d.booleanValue()) {
                g(false);
            } else {
                if (this.E && ((a0) this.f1023b).f.j != UnitDisplayType.REWARDED) {
                    g(false);
                } else if (streamVolume > 0 && ringerMode == 2) {
                    IAlog.a("%s setting default volume. unmuting player", IAlog.a(this));
                    i(false);
                }
            }
            E();
            this.D = true;
        }
        h(false);
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.n
    public int o() {
        return IAConfigManager.M.u.f886b.a("VideoFullscreenBufferingTimeout", 12, 1) * 1000;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.n
    public int s() {
        int i;
        c0 c0Var;
        com.fyber.inneractive.sdk.config.global.features.b bVarP = p();
        int iD = bVarP != null ? bVarP.d() : -1;
        com.fyber.inneractive.sdk.config.i iVar = IAConfigManager.M.u.f886b;
        b0 b0Var = this.f1023b;
        Skip skip = this.A;
        boolean zIsCurrentUserAChild = InneractiveAdManager.isCurrentUserAChild();
        com.fyber.inneractive.sdk.config.g gVarA = iVar.a("vast_configuration");
        gVarA.getClass();
        try {
            i = gVarA.a.containsKey("skip_d") ? Integer.parseInt(gVarA.a.get("skip_d")) : -1;
        } catch (Exception unused) {
        }
        int iMax = Math.max(i, -1);
        if (skip == null && b0Var != null && (c0Var = ((a0) b0Var).f) != null) {
            skip = c0Var.h;
        }
        if (zIsCurrentUserAChild) {
            if (d(iD)) {
                return iD;
            }
            if (!d(iMax)) {
                if (d(skip.value().intValue())) {
                    return skip.value().intValue();
                }
                return 5;
            }
        } else if (iMax <= -1 || iMax > 5) {
            if (skip == Skip.DEFAULT) {
                return 99999;
            }
            return skip.value().intValue();
        }
        return iMax;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.n
    public void u() {
        this.u = true;
        IAlog.a("%s onBufferingTimeout reached. Skipping to end card", IAlog.a(this));
        c(false);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.n
    public void w() {
        ListenerT listenert = this.g;
        if (listenert != 0) {
            listenert.k();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.n
    public void y() {
        this.d.d(true);
        C();
        n();
        k();
        h(true);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.n
    public void a(k0 k0Var) {
        com.fyber.inneractive.sdk.config.global.features.r.b bVar;
        TapAction tapAction = ((a0) this.f1023b).f.i;
        if (tapAction == TapAction.CTR) {
            a(false, VideoClickOrigin.VIDEO, k0Var);
            return;
        }
        if (tapAction != TapAction.FULLSCREEN && tapAction != TapAction.DO_NOTHING) {
            IAlog.a("% sonVideoClicked called, but we recieved an unknown tap action %s", IAlog.a(this), tapAction);
            return;
        }
        com.fyber.inneractive.sdk.config.global.features.r rVar = (com.fyber.inneractive.sdk.config.global.features.r) this.c.a(com.fyber.inneractive.sdk.config.global.features.r.class);
        rVar.getClass();
        String strA = rVar.a("click_action", com.fyber.inneractive.sdk.config.global.features.r.e.mKey);
        com.fyber.inneractive.sdk.config.global.features.r.b[] bVarArrValues = com.fyber.inneractive.sdk.config.global.features.r.b.values();
        int length = bVarArrValues.length;
        int i = 0;
        while (true) {
            if (i < length) {
                bVar = bVarArrValues[i];
                if (strA.equalsIgnoreCase(bVar.mKey)) {
                    break;
                } else {
                    i++;
                }
            } else {
                bVar = com.fyber.inneractive.sdk.config.global.features.r.b.NONE;
                break;
            }
        }
        if (!bVar.equals(com.fyber.inneractive.sdk.config.global.features.r.b.OPEN)) {
            if (!(this.w != com.fyber.inneractive.sdk.ignite.k.NONE && IAConfigManager.M.E.d())) {
                return;
            }
        }
        a(false, VideoClickOrigin.VIDEO, k0Var);
    }
}
