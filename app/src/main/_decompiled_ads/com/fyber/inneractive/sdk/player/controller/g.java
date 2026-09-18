package com.fyber.inneractive.sdk.player.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g implements com.fyber.inneractive.sdk.player.mediaplayer.a.k {
    public final Context a;
    public InterfaceC0279g d;
    public d f;
    public boolean g;
    public final Handler i;
    public TextureView j;
    public SurfaceTexture k;
    public Surface l;
    public TextureView.SurfaceTextureListener m;
    public boolean o;
    public com.fyber.inneractive.sdk.player.enums.b e = com.fyber.inneractive.sdk.player.enums.b.Idle;
    public boolean n = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<f> f1018b = new CopyOnWriteArrayList();
    public final List<e> c = new CopyOnWriteArrayList();
    public com.fyber.inneractive.sdk.player.d h = new com.fyber.inneractive.sdk.player.d(this);

    public class a implements Runnable {
        public final /* synthetic */ Exception a;

        public a(Exception exc) {
            this.a = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            if (gVar.g) {
                return;
            }
            try {
                Iterator<f> it = gVar.f1018b.iterator();
                while (it.hasNext()) {
                    it.next().a(this.a);
                }
            } catch (Exception e) {
                if (IAlog.a <= 3) {
                    g gVar2 = g.this;
                    gVar2.getClass();
                    IAlog.a("%sonPlayerError callback threw an exception!", e, IAlog.a(gVar2));
                }
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Iterator<e> it = g.this.c.iterator();
                while (it.hasNext()) {
                    it.next().a(this.a);
                }
            } catch (Exception e) {
                if (IAlog.a <= 3) {
                    g gVar = g.this;
                    gVar.getClass();
                    IAlog.a("%sonPlayerProgress callback threw an exception!", e, IAlog.a(gVar));
                }
            }
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ com.fyber.inneractive.sdk.player.enums.b a;

        public c(com.fyber.inneractive.sdk.player.enums.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextureView textureView;
            g gVar;
            TextureView textureView2;
            TextureView textureView3;
            try {
                try {
                    Iterator<f> it = g.this.f1018b.iterator();
                    while (it.hasNext()) {
                        it.next().a(this.a);
                    }
                    com.fyber.inneractive.sdk.player.enums.b bVar = this.a;
                    if (bVar == com.fyber.inneractive.sdk.player.enums.b.Idle || bVar == com.fyber.inneractive.sdk.player.enums.b.Error || bVar == com.fyber.inneractive.sdk.player.enums.b.Completed) {
                        g gVar2 = g.this;
                        if (gVar2.k != null && (textureView3 = gVar2.j) != null && textureView3.getParent() != null) {
                            ((ViewGroup) g.this.j.getParent()).removeView(g.this.j);
                        }
                        gVar = g.this;
                        gVar.j = null;
                        gVar.k = null;
                    }
                } catch (Exception e) {
                    if (IAlog.a <= 3) {
                        g gVar3 = g.this;
                        gVar3.getClass();
                        IAlog.a("%sonPlayerStateChanged callback threw an exception!", e, IAlog.a(gVar3));
                    }
                    com.fyber.inneractive.sdk.player.enums.b bVar2 = this.a;
                    if (bVar2 != com.fyber.inneractive.sdk.player.enums.b.Idle && bVar2 != com.fyber.inneractive.sdk.player.enums.b.Error && bVar2 != com.fyber.inneractive.sdk.player.enums.b.Completed) {
                        return;
                    }
                    g gVar4 = g.this;
                    if (gVar4.k != null && (textureView2 = gVar4.j) != null && textureView2.getParent() != null) {
                        ((ViewGroup) g.this.j.getParent()).removeView(g.this.j);
                    }
                    gVar = g.this;
                    gVar.j = null;
                }
            } catch (Throwable th) {
                com.fyber.inneractive.sdk.player.enums.b bVar3 = this.a;
                if (bVar3 == com.fyber.inneractive.sdk.player.enums.b.Idle || bVar3 == com.fyber.inneractive.sdk.player.enums.b.Error || bVar3 == com.fyber.inneractive.sdk.player.enums.b.Completed) {
                    g gVar5 = g.this;
                    if (gVar5.k != null && (textureView = gVar5.j) != null && textureView.getParent() != null) {
                        ((ViewGroup) g.this.j.getParent()).removeView(g.this.j);
                    }
                    g gVar6 = g.this;
                    gVar6.j = null;
                    gVar6.k = null;
                }
                throw th;
            }
        }
    }

    public interface d {
    }

    public interface e {
        void a(int i);
    }

    public interface f {
        void a(com.fyber.inneractive.sdk.player.enums.b bVar);

        void a(Exception exc);

        void e(boolean z);

        void g();
    }

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.controller.g$g, reason: collision with other inner class name */
    public interface InterfaceC0279g {
    }

    public g(Context context) {
        this.a = context.getApplicationContext();
        this.i = new Handler(context.getMainLooper());
        a(true);
    }

    public abstract void a(int i, boolean z);

    public abstract void a(Surface surface);

    public abstract void a(String str, int i);

    public abstract void a(boolean z);

    public abstract boolean a();

    public abstract void b(boolean z);

    public abstract int c();

    public final void c(boolean z) {
        com.fyber.inneractive.sdk.measurement.d dVar;
        d dVar2 = this.f;
        if (dVar2 == null || (dVar = com.fyber.inneractive.sdk.player.c.this.h) == null) {
            return;
        }
        if (z) {
            if (dVar.c != null) {
                IAlog.a("%s mute", "OMVideo");
                try {
                    dVar.c.volumeChange(0.0f);
                    return;
                } catch (Throwable th) {
                    dVar.a(th);
                    return;
                }
            }
            return;
        }
        if (dVar.c != null) {
            IAlog.a("%s unMute", "OMVideo");
            try {
                dVar.c.volumeChange(1.0f);
            } catch (Throwable th2) {
                dVar.a(th2);
            }
        }
    }

    public abstract int d();

    public abstract void d(boolean z);

    public abstract Bitmap e();

    public abstract String f();

    public abstract int g();

    public abstract int h();

    public abstract boolean i();

    public boolean j() {
        return this.e == com.fyber.inneractive.sdk.player.enums.b.Playing;
    }

    public abstract void k();

    public abstract void l();

    public void m() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        com.fyber.inneractive.sdk.player.d dVar = this.h;
        if (dVar == null || (scheduledThreadPoolExecutor = dVar.f1029b) == null) {
            return;
        }
        scheduledThreadPoolExecutor.shutdownNow();
        dVar.f1029b = null;
    }

    public void a(Exception exc) {
        a(com.fyber.inneractive.sdk.player.enums.b.Error);
        IAlog.a("%sonPlayerError called with: %s for onPlayerError", IAlog.a(this), exc);
        this.i.post(new a(exc));
        m();
    }

    public void b() {
        IAlog.a("%sdestroy started", IAlog.a(this));
        m();
        this.h = null;
        this.i.removeCallbacksAndMessages(null);
        this.f1018b.clear();
        this.f = null;
        this.g = true;
        IAlog.a("%sdestroy finished", IAlog.a(this));
    }

    public void a(int i) {
        this.i.post(new b(i));
    }

    public void a(com.fyber.inneractive.sdk.player.enums.b bVar) {
        if (bVar == this.e) {
            return;
        }
        this.e = bVar;
        if (bVar == com.fyber.inneractive.sdk.player.enums.b.Playing) {
            com.fyber.inneractive.sdk.player.d dVar = this.h;
            if (dVar != null && dVar.f1029b == null) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
                dVar.f1029b = scheduledThreadPoolExecutor;
                scheduledThreadPoolExecutor.scheduleAtFixedRate(dVar.c, 100, 1000, TimeUnit.MILLISECONDS);
            }
        } else if (bVar == com.fyber.inneractive.sdk.player.enums.b.Paused || bVar == com.fyber.inneractive.sdk.player.enums.b.Idle || bVar == com.fyber.inneractive.sdk.player.enums.b.Completed) {
            m();
        }
        this.i.post(new c(bVar));
    }
}
