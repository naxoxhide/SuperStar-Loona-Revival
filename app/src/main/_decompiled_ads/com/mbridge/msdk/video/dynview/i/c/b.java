package com.mbridge.msdk.video.dynview.i.c;

import android.os.CountDownTimer;

/* JADX INFO: compiled from: MBCountDownTimer.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private long a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f2499b;
    private com.mbridge.msdk.video.dynview.i.c.a c;
    private a d;

    public final b a(long j) {
        if (j < 0) {
            j = 1000;
        }
        this.f2499b = j;
        return this;
    }

    public final b a(com.mbridge.msdk.video.dynview.i.c.a aVar) {
        this.c = aVar;
        return this;
    }

    public final b b(long j) {
        this.a = j;
        return this;
    }

    private void c() {
        a aVar = this.d;
        if (aVar != null) {
            aVar.cancel();
            this.d = null;
        }
        if (this.f2499b <= 0) {
            this.f2499b = this.a + 1000;
        }
        a aVar2 = new a(this.a, this.f2499b);
        this.d = aVar2;
        aVar2.a(this.c);
    }

    public final void a() {
        if (this.d == null) {
            c();
        }
        this.d.start();
    }

    public final void a(long j, com.mbridge.msdk.video.dynview.i.c.a aVar) {
        this.a = j;
        this.c = aVar;
        c();
        a aVar2 = this.d;
        if (aVar2 != null) {
            aVar2.start();
        }
    }

    public final void b() {
        a aVar = this.d;
        if (aVar != null) {
            aVar.cancel();
            this.d = null;
        }
    }

    /* JADX INFO: compiled from: MBCountDownTimer.java */
    private static class a extends CountDownTimer {
        private com.mbridge.msdk.video.dynview.i.c.a a;

        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j) {
            com.mbridge.msdk.video.dynview.i.c.a aVar = this.a;
            if (aVar != null) {
                aVar.a(j);
            }
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            com.mbridge.msdk.video.dynview.i.c.a aVar = this.a;
            if (aVar != null) {
                aVar.a();
            }
        }

        final void a(com.mbridge.msdk.video.dynview.i.c.a aVar) {
            this.a = aVar;
        }
    }
}
