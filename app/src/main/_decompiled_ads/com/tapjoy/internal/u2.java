package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class u2 extends ImageView implements Runnable {
    public m2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f2818b;
    public final Handler c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Thread g;
    public long h;
    public final q2 i;
    public final r2 j;

    public u2(Context context) {
        super(context);
        this.c = new Handler(Looper.getMainLooper());
        this.h = -1L;
        this.i = new q2(this);
        this.j = new r2(this);
    }

    public final void a() {
        if ((this.d || this.e) && this.a != null && this.g == null) {
            Thread thread = new Thread(this);
            this.g = thread;
            thread.start();
        }
    }

    public final void b() {
        this.d = false;
        Thread thread = this.g;
        if (thread != null) {
            thread.interrupt();
            this.g = null;
        }
    }

    public long getFramesDisplayDuration() {
        return this.h;
    }

    public int getGifHeight() {
        return this.a.p.g;
    }

    public int getGifWidth() {
        return this.a.p.f;
    }

    public s2 getOnAnimationStop() {
        return null;
    }

    public t2 getOnFrameAvailable() {
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d = false;
        this.e = false;
        this.f = true;
        b();
        this.c.post(this.j);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0029  */
    @Override // java.lang.Runnable
    public final void run() {
        long jNanoTime;
        int i;
        do {
            if (!this.d && !this.e) {
                break;
            }
            m2 m2Var = this.a;
            o2 o2Var = m2Var.p;
            int i2 = o2Var.c;
            int i3 = -1;
            boolean z = true;
            if (i2 > 0) {
                int i4 = m2Var.n;
                if (i4 == i2 - 1) {
                    m2Var.o++;
                }
                int i5 = o2Var.l;
                if (i5 == -1 || m2Var.o <= i5) {
                    m2Var.n = (i4 + 1) % i2;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            try {
                long jNanoTime2 = System.nanoTime();
                this.f2818b = this.a.a();
                jNanoTime = (System.nanoTime() - jNanoTime2) / 1000000;
                try {
                    this.c.post(this.i);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused) {
                }
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused2) {
                jNanoTime = 0;
            }
            this.e = false;
            if (!this.d || !z) {
                this.d = false;
                break;
            }
            try {
                m2 m2Var2 = this.a;
                o2 o2Var2 = m2Var2.p;
                int i6 = o2Var2.c;
                if (i6 <= 0 || (i = m2Var2.n) < 0) {
                    i3 = 0;
                } else if (i >= 0 && i < i6) {
                    i3 = ((n2) o2Var2.e.get(i)).i;
                }
                int i7 = (int) (((long) i3) - jNanoTime);
                if (i7 > 0) {
                    long j = this.h;
                    if (j <= 0) {
                        j = i7;
                    }
                    Thread.sleep(j);
                }
            } catch (InterruptedException unused3) {
            }
        } while (this.d);
        if (this.f) {
            this.c.post(this.j);
        }
        this.g = null;
    }

    public void setBytes(byte[] bArr) {
        boolean z;
        m2 m2Var = new m2(new b7());
        this.a = m2Var;
        try {
            synchronized (m2Var) {
                if (m2Var.h == null) {
                    m2Var.h = new p2();
                }
                p2 p2Var = m2Var.h;
                z = false;
                if (bArr != null) {
                    p2Var.getClass();
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                    p2Var.f2794b = null;
                    Arrays.fill(p2Var.a, (byte) 0);
                    p2Var.c = new o2();
                    p2Var.d = 0;
                    ByteBuffer byteBufferAsReadOnlyBuffer = byteBufferWrap.asReadOnlyBuffer();
                    p2Var.f2794b = byteBufferAsReadOnlyBuffer;
                    byteBufferAsReadOnlyBuffer.position(0);
                    p2Var.f2794b.order(ByteOrder.LITTLE_ENDIAN);
                } else {
                    p2Var.f2794b = null;
                    p2Var.c.f2789b = 2;
                }
                o2 o2VarB = p2Var.b();
                m2Var.p = o2VarB;
                if (bArr != null) {
                    m2Var.a(o2VarB, bArr);
                }
            }
            boolean z2 = this.d;
            if (z2) {
                a();
                return;
            }
            m2 m2Var2 = this.a;
            if (m2Var2.n == 0) {
                return;
            }
            if (-1 < m2Var2.p.c) {
                m2Var2.n = -1;
                z = true;
            }
            if (!z || z2) {
                return;
            }
            this.e = true;
            a();
        } catch (Exception unused) {
            this.a = null;
        }
    }

    public void setFramesDisplayDuration(long j) {
        this.h = j;
    }

    public void setOnAnimationStop(s2 s2Var) {
    }

    public void setOnFrameAvailable(t2 t2Var) {
    }
}
