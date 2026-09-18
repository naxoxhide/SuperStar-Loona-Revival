package com.bytedance.sdk.openadsdk.b.m;

import android.os.CountDownTimer;
import com.bytedance.sdk.openadsdk.core.f0.q;
import java.util.Map;

/* JADX INFO: compiled from: FakeVideoController.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements b.a.a.a.a.a.a.g.c {
    private final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f460b = false;
    private boolean c;

    /* JADX INFO: compiled from: FakeVideoController.java */
    private static class a implements b.a.a.a.a.a.a.a {
        private final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f461b;
        private int c = 0;
        private CountDownTimer d;
        private b.a.a.a.a.a.a.g.c.a e;
        private long f;

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.b.m.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FakeVideoController.java */
        class CountDownTimerC0182a extends CountDownTimer {
            final /* synthetic */ long a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f462b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            CountDownTimerC0182a(long j, long j2, long j3, long j4) {
                super(j, j2);
                this.a = j3;
                this.f462b = j4;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.c = 4;
                if (a.this.e != null) {
                    a.this.e.b(a.this.a(), 100);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                long j2 = (this.a - j) + a.this.f461b;
                a.this.f = j2;
                if (a.this.e != null) {
                    a.this.e.a(j2, this.f462b);
                }
            }
        }

        public a(long j) {
            this.a = j;
        }

        @Override // b.a.a.a.a.a.a.a
        public int b() {
            return 0;
        }

        @Override // b.a.a.a.a.a.a.a
        public int c() {
            return 0;
        }

        @Override // b.a.a.a.a.a.a.a
        public boolean d() {
            return false;
        }

        @Override // b.a.a.a.a.a.a.a
        public boolean e() {
            return false;
        }

        @Override // b.a.a.a.a.a.a.a
        public boolean f() {
            return false;
        }

        @Override // b.a.a.a.a.a.a.a
        public boolean g() {
            return this.c == 0;
        }

        @Override // b.a.a.a.a.a.a.a
        public boolean h() {
            return this.c == 1;
        }

        @Override // b.a.a.a.a.a.a.a
        public boolean i() {
            return this.c == 2;
        }

        public long j() {
            return this.a;
        }

        public void k() {
            this.c = 2;
            this.f461b = this.f;
            CountDownTimer countDownTimer = this.d;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.d = null;
            }
        }

        public void l() {
            if (this.c == 1) {
                return;
            }
            this.c = 1;
            long j = j();
            long j2 = j - this.f461b;
            CountDownTimerC0182a countDownTimerC0182a = new CountDownTimerC0182a(j2, 200L, j2, j);
            this.d = countDownTimerC0182a;
            countDownTimerC0182a.start();
        }

        public void m() {
            this.c = 0;
            CountDownTimer countDownTimer = this.d;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.d = null;
            }
            if (this.e != null) {
                this.e = null;
            }
        }

        public long a() {
            return this.f;
        }

        public void a(long j) {
            this.f461b = j;
        }

        public void a(b.a.a.a.a.a.a.g.c.a aVar) {
            this.e = aVar;
        }
    }

    public c(q qVar) {
        b.a.a.a.a.a.a.f.b bVarN0 = qVar.N0();
        long j = 10;
        long jS = bVarN0 != null ? (long) bVarN0.s() : 10L;
        if (jS <= 0) {
            bVarN0.a(10L);
        } else {
            j = jS;
        }
        this.a = new a(j * 1000);
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void a(long j) {
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void a(b.a.a.a.a.a.a.g.c.b bVar) {
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void a(b.a.a.a.a.a.a.g.c.d dVar) {
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void a(Map<String, Object> map) {
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void a(boolean z, int i) {
        e();
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void b(long j) {
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void b(b.a.a.a.a.a.a.f.c cVar) {
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void b(boolean z) {
    }

    @Override // b.a.a.a.a.a.a.g.c
    public boolean b() {
        return false;
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void c() {
        e();
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void c(boolean z) {
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void d() {
        this.a.k();
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void d(boolean z) {
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void e() {
        this.a.m();
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void f() {
        this.a.l();
    }

    @Override // b.a.a.a.a.a.a.g.c
    public b.a.a.a.a.a.a.g.b g() {
        return null;
    }

    @Override // b.a.a.a.a.a.a.g.c
    public b.a.a.a.a.a.a.a h() {
        return this.a;
    }

    @Override // b.a.a.a.a.a.a.g.c
    public boolean i() {
        return this.f460b;
    }

    @Override // b.a.a.a.a.a.a.g.c
    public boolean isUseTextureView() {
        return false;
    }

    @Override // b.a.a.a.a.a.a.g.c
    public int j() {
        return 0;
    }

    @Override // b.a.a.a.a.a.a.g.c
    public long k() {
        return o();
    }

    @Override // b.a.a.a.a.a.a.g.c
    public long l() {
        return 0L;
    }

    @Override // b.a.a.a.a.a.a.g.c
    public int m() {
        return b.a.a.a.a.a.b.f.a.a(this.a.f, this.a.a);
    }

    @Override // b.a.a.a.a.a.a.g.c
    public boolean n() {
        return this.c;
    }

    @Override // b.a.a.a.a.a.a.g.c
    public long o() {
        return this.a.a();
    }

    @Override // b.a.a.a.a.a.a.g.c
    public boolean p() {
        return false;
    }

    @Override // b.a.a.a.a.a.a.g.c
    public boolean a(b.a.a.a.a.a.a.f.c cVar) {
        this.f460b = cVar.v();
        if (cVar.d() > 0) {
            this.a.a(cVar.d());
        }
        this.a.l();
        return true;
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void c(long j) {
        this.a.a(j);
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void e(boolean z) {
        this.f460b = z;
    }

    @Override // b.a.a.a.a.a.a.g.c
    public long a() {
        return this.a.j();
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void a(boolean z) {
        this.c = z;
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void a(b.a.a.a.a.a.a.g.c.a aVar) {
        this.a.a(aVar);
    }
}
