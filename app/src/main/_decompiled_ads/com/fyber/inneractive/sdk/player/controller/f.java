package com.fyber.inneractive.sdk.player.controller;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes2.dex */
public class f implements TextureView.SurfaceTextureListener {
    public final /* synthetic */ g a;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = f.this.a;
            g.InterfaceC0279g interfaceC0279g = gVar.d;
            if (interfaceC0279g != null) {
                TextureView textureView = gVar.j;
                m mVar = (m) interfaceC0279g;
                mVar.a.d.post(new l(mVar));
            }
        }
    }

    public f(g gVar) {
        this.a = gVar;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        g gVar = this.a;
        gVar.getClass();
        IAlog.a("%sonSurfaceTextureAvailable", IAlog.a(gVar));
        g gVar2 = this.a;
        boolean z = !surfaceTexture.equals(gVar2.k);
        gVar2.k = surfaceTexture;
        if (gVar2.l == null || z) {
            gVar2.l = new Surface(gVar2.k);
        }
        gVar2.a(gVar2.l);
        g gVar3 = this.a;
        g.InterfaceC0279g interfaceC0279g = gVar3.d;
        if (interfaceC0279g != null) {
            TextureView textureView = gVar3.j;
            n nVar = ((m) interfaceC0279g).a;
            nVar.getClass();
            IAlog.a("%sonSurfaceTextureAvailable", IAlog.a(nVar));
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        g gVar = this.a;
        gVar.getClass();
        IAlog.a("%s onSurfaceTextureDestroyed", IAlog.a(gVar));
        this.a.k();
        this.a.a((Surface) null);
        this.a.o = true;
        g gVar2 = this.a;
        com.fyber.inneractive.sdk.player.enums.b bVar = gVar2.e;
        if (bVar == com.fyber.inneractive.sdk.player.enums.b.Completed || bVar == com.fyber.inneractive.sdk.player.enums.b.Error || bVar == com.fyber.inneractive.sdk.player.enums.b.Idle) {
            gVar2.getClass();
            IAlog.a("%sReleasing surface texture", IAlog.a(gVar2));
            this.a.k = null;
            return true;
        }
        gVar2.getClass();
        IAlog.a("%s caching surface texture", IAlog.a(gVar2));
        g gVar3 = this.a;
        gVar3.k = surfaceTexture;
        gVar3.i.post(new a());
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Surface surface;
        com.fyber.inneractive.sdk.player.c cVar;
        g gVar;
        g.InterfaceC0279g interfaceC0279g = this.a.d;
        if (interfaceC0279g != null && (cVar = ((m) interfaceC0279g).a.a) != null && (gVar = cVar.f1002b) != null) {
            gVar.i.post(new i(gVar));
        }
        g gVar2 = this.a;
        if (!gVar2.o || (surface = gVar2.l) == null) {
            return;
        }
        gVar2.a(surface);
        this.a.o = false;
    }
}
