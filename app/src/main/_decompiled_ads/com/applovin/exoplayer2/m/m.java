package com.applovin.exoplayer2.m;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;

/* JADX INFO: loaded from: classes.dex */
public final class m {
    private boolean GL;
    private Surface Hm;
    private float TU;
    private final com.applovin.exoplayer2.m.e aeN = new com.applovin.exoplayer2.m.e();
    private final b aeO;
    private final e aeP;
    private float aeQ;
    private float aeR;
    private float aeS;
    private int aeT;
    private long aeU;
    private long aeV;
    private long aeW;
    private long aeX;
    private long aeY;
    private long aeZ;
    private long afa;

    /* JADX INFO: Access modifiers changed from: private */
    interface b {

        public interface a {
            void onDefaultDisplayChanged(Display display);
        }

        void a(a aVar);

        void qB();
    }

    public m(Context context) {
        b bVarR = r(context);
        this.aeO = bVarR;
        this.aeP = bVarR != null ? e.qD() : null;
        this.aeU = -9223372036854775807L;
        this.aeV = -9223372036854775807L;
        this.aeQ = -1.0f;
        this.TU = 1.0f;
        this.aeT = 0;
    }

    public void fS(int i) {
        if (this.aeT == i) {
            return;
        }
        this.aeT = i;
        at(true);
    }

    public void qw() {
        if (this.aeO != null) {
            ((e) com.applovin.exoplayer2.l.a.checkNotNull(this.aeP)).qE();
            this.aeO.a(new b.a() { // from class: com.applovin.exoplayer2.m.-$$Lambda$m$QhC57bGLT9vxIcLkifJaXFdmK4I
                @Override // com.applovin.exoplayer2.m.m.b.a
                public final void onDefaultDisplayChanged(Display display) {
                    this.f$0.a(display);
                }
            });
        }
    }

    public void aa() {
        this.GL = true;
        qy();
        at(false);
    }

    public void c(Surface surface) {
        if (surface instanceof com.applovin.exoplayer2.m.d) {
            surface = null;
        }
        if (this.Hm == surface) {
            return;
        }
        qA();
        this.Hm = surface;
        at(true);
    }

    public void qx() {
        qy();
    }

    public void v(float f) {
        this.TU = f;
        qy();
        at(false);
    }

    public void y(float f) {
        this.aeQ = f;
        this.aeN.Y();
        qz();
    }

    public void bw(long j) {
        long j2 = this.aeX;
        if (j2 != -1) {
            this.aeZ = j2;
            this.afa = this.aeY;
        }
        this.aeW++;
        this.aeN.bw(j * 1000);
        qz();
    }

    public void ab() {
        this.GL = false;
        qA();
    }

    public void ac() {
        b bVar = this.aeO;
        if (bVar != null) {
            bVar.qB();
            ((e) com.applovin.exoplayer2.l.a.checkNotNull(this.aeP)).qF();
        }
    }

    public long bD(long j) {
        long j2;
        if (this.aeZ == -1 || !this.aeN.qd()) {
            j2 = j;
        } else {
            long jQg = this.afa + ((long) ((this.aeN.qg() * (this.aeW - this.aeZ)) / this.TU));
            if (D(j, jQg)) {
                j2 = jQg;
            } else {
                qy();
                j2 = j;
            }
        }
        this.aeX = this.aeW;
        this.aeY = j2;
        e eVar = this.aeP;
        if (eVar == null || this.aeU == -9223372036854775807L) {
            return j2;
        }
        long j3 = eVar.afe;
        return j3 == -9223372036854775807L ? j2 : f(j2, j3, this.aeU) - this.aeV;
    }

    private void qy() {
        this.aeW = 0L;
        this.aeZ = -1L;
        this.aeX = -1L;
    }

    private static boolean D(long j, long j2) {
        return Math.abs(j - j2) <= 20000000;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005f  */
    private void qz() {
        if (ai.acV < 30 || this.Hm == null) {
            return;
        }
        float fQh = this.aeN.qd() ? this.aeN.qh() : this.aeQ;
        float f = this.aeR;
        if (fQh == f) {
            return;
        }
        boolean z = true;
        if (fQh != -1.0f && f != -1.0f) {
            if (Math.abs(fQh - this.aeR) < (this.aeN.qd() && (this.aeN.qf() > 5000000000L ? 1 : (this.aeN.qf() == 5000000000L ? 0 : -1)) >= 0 ? 0.02f : 1.0f)) {
                z = false;
            }
        } else if (fQh == -1.0f && this.aeN.qe() < 30) {
            z = false;
        }
        if (z) {
            this.aeR = fQh;
            at(false);
        }
    }

    private void at(boolean z) {
        Surface surface;
        if (ai.acV < 30 || (surface = this.Hm) == null || this.aeT == Integer.MIN_VALUE) {
            return;
        }
        float f = 0.0f;
        if (this.GL) {
            float f2 = this.aeR;
            if (f2 != -1.0f) {
                f = this.TU * f2;
            }
        }
        if (z || this.aeS != f) {
            this.aeS = f;
            a.a(surface, f);
        }
    }

    private void qA() {
        Surface surface;
        if (ai.acV < 30 || (surface = this.Hm) == null || this.aeT == Integer.MIN_VALUE || this.aeS == 0.0f) {
            return;
        }
        this.aeS = 0.0f;
        a.a(surface, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            this.aeU = refreshRate;
            this.aeV = (refreshRate * 80) / 100;
        } else {
            q.h("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            this.aeU = -9223372036854775807L;
            this.aeV = -9223372036854775807L;
        }
    }

    private static long f(long j, long j2, long j3) {
        long j4;
        long j5 = j2 + (((j - j2) / j3) * j3);
        if (j <= j5) {
            j4 = j5 - j3;
        } else {
            j5 = j3 + j5;
            j4 = j5;
        }
        return j5 - j < j - j4 ? j5 : j4;
    }

    private static b r(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        b bVarS = ai.acV >= 17 ? d.s(applicationContext) : null;
        return bVarS == null ? c.s(applicationContext) : bVarS;
    }

    private static final class a {
        public static void a(Surface surface, float f) {
            try {
                surface.setFrameRate(f, f == 0.0f ? 0 : 1);
            } catch (IllegalStateException e) {
                q.c("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e);
            }
        }
    }

    private static final class c implements b {
        private final WindowManager afb;

        @Override // com.applovin.exoplayer2.m.m.b
        public void qB() {
        }

        public static b s(Context context) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                return new c(windowManager);
            }
            return null;
        }

        private c(WindowManager windowManager) {
            this.afb = windowManager;
        }

        @Override // com.applovin.exoplayer2.m.m.b
        public void a(b.a aVar) {
            aVar.onDefaultDisplayChanged(this.afb.getDefaultDisplay());
        }
    }

    private static final class d implements DisplayManager.DisplayListener, b {
        private final DisplayManager afc;
        private b.a afd;

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }

        public static b s(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager != null) {
                return new d(displayManager);
            }
            return null;
        }

        private d(DisplayManager displayManager) {
            this.afc = displayManager;
        }

        @Override // com.applovin.exoplayer2.m.m.b
        public void a(b.a aVar) {
            this.afd = aVar;
            this.afc.registerDisplayListener(this, ai.pX());
            aVar.onDefaultDisplayChanged(qC());
        }

        @Override // com.applovin.exoplayer2.m.m.b
        public void qB() {
            this.afc.unregisterDisplayListener(this);
            this.afd = null;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            b.a aVar = this.afd;
            if (aVar == null || i != 0) {
                return;
            }
            aVar.onDefaultDisplayChanged(qC());
        }

        private Display qC() {
            return this.afc.getDisplay(0);
        }
    }

    private static final class e implements Handler.Callback, Choreographer.FrameCallback {
        private static final e aff = new e();
        public volatile long afe = -9223372036854775807L;
        private final HandlerThread afg;
        private Choreographer afh;
        private int afi;
        private final Handler jS;

        public static e qD() {
            return aff;
        }

        private e() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.afg = handlerThread;
            handlerThread.start();
            Handler handlerB = ai.b(handlerThread.getLooper(), this);
            this.jS = handlerB;
            handlerB.sendEmptyMessage(0);
        }

        public void qE() {
            this.jS.sendEmptyMessage(1);
        }

        public void qF() {
            this.jS.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.afe = j;
            ((Choreographer) com.applovin.exoplayer2.l.a.checkNotNull(this.afh)).postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                qG();
                return true;
            }
            if (i == 1) {
                qH();
                return true;
            }
            if (i != 2) {
                return false;
            }
            qI();
            return true;
        }

        private void qG() {
            this.afh = Choreographer.getInstance();
        }

        private void qH() {
            int i = this.afi + 1;
            this.afi = i;
            if (i == 1) {
                ((Choreographer) com.applovin.exoplayer2.l.a.checkNotNull(this.afh)).postFrameCallback(this);
            }
        }

        private void qI() {
            int i = this.afi - 1;
            this.afi = i;
            if (i == 0) {
                ((Choreographer) com.applovin.exoplayer2.l.a.checkNotNull(this.afh)).removeFrameCallback(this);
                this.afe = -9223372036854775807L;
            }
        }
    }
}
