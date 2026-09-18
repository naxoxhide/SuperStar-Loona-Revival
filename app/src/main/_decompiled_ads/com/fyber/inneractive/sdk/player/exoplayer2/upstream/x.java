package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public final class x {
    public final ExecutorService a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b<? extends c> f1223b;
    public IOException c;

    public interface a<T extends c> {
        int a(T t, long j, long j2, IOException iOException);

        void a(T t, long j, long j2);

        void a(T t, long j, long j2, boolean z);
    }

    public interface c {
        boolean a();

        void b();

        void load() throws InterruptedException, IOException;
    }

    public static final class d extends IOException {
        public d(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public x(String str) {
        this.a = com.fyber.inneractive.sdk.player.exoplayer2.util.u.b(str);
    }

    public <T extends c> long a(T t, a<T> aVar, int i) {
        Looper looperMyLooper = Looper.myLooper();
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(looperMyLooper != null);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new b(looperMyLooper, t, aVar, i, jElapsedRealtime).a(0L);
        return jElapsedRealtime;
    }

    public boolean b() {
        return this.f1223b != null;
    }

    public void c() throws IOException {
        IOException iOException = this.c;
        if (iOException != null) {
            throw iOException;
        }
        b<? extends c> bVar = this.f1223b;
        if (bVar != null) {
            int i = bVar.c;
            IOException iOException2 = bVar.e;
            if (iOException2 != null && bVar.f > i) {
                throw iOException2;
            }
        }
    }

    public void d() {
        b<? extends c> bVar = this.f1223b;
        if (bVar != null) {
            bVar.a(true);
        }
        this.a.shutdown();
    }

    public void a() {
        this.f1223b.a(false);
    }

    public final class b<T extends c> extends Handler implements Runnable {
        public final T a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a<T> f1224b;
        public final int c;
        public final long d;
        public IOException e;
        public int f;
        public volatile Thread g;
        public volatile boolean h;

        public b(Looper looper, T t, a<T> aVar, int i, long j) {
            super(looper);
            this.a = t;
            this.f1224b = aVar;
            this.c = i;
            this.d = j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(long j) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(x.this.f1223b == null);
            x xVar = x.this;
            xVar.f1223b = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                this.e = null;
                xVar.a.execute(this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.h) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                this.e = null;
                x xVar = x.this;
                xVar.a.execute(xVar.f1223b);
                return;
            }
            if (i == 4) {
                throw ((Error) message.obj);
            }
            x.this.f1223b = null;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.d;
            if (this.a.a()) {
                this.f1224b.a((c) this.a, jElapsedRealtime, j, false);
                return;
            }
            int i2 = message.what;
            if (i2 == 1) {
                this.f1224b.a((c) this.a, jElapsedRealtime, j, false);
                return;
            }
            if (i2 == 2) {
                this.f1224b.a(this.a, jElapsedRealtime, j);
                return;
            }
            if (i2 != 3) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.e = iOException;
            int iA = this.f1224b.a(this.a, jElapsedRealtime, j, iOException);
            if (iA == 3) {
                x.this.c = this.e;
            } else if (iA != 2) {
                int i3 = iA == 1 ? 1 : this.f + 1;
                this.f = i3;
                a(Math.min((i3 - 1) * 1000, 5000));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.g = Thread.currentThread();
                if (!this.a.a()) {
                    com.fyber.inneractive.sdk.player.exoplayer2.util.s.a("load:" + this.a.getClass().getSimpleName());
                    try {
                        this.a.load();
                        com.fyber.inneractive.sdk.player.exoplayer2.util.s.a();
                    } catch (Throwable th) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.s.a();
                        throw th;
                    }
                }
                if (this.h) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (IOException e) {
                if (this.h) {
                    return;
                }
                obtainMessage(3, e).sendToTarget();
            } catch (Error e2) {
                Log.e("LoadTask", "Unexpected error loading stream", e2);
                if (!this.h) {
                    obtainMessage(4, e2).sendToTarget();
                }
                throw e2;
            } catch (InterruptedException unused) {
                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.a.a());
                if (this.h) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (Exception e3) {
                Log.e("LoadTask", "Unexpected exception loading stream", e3);
                if (this.h) {
                    return;
                }
                obtainMessage(3, new d(e3)).sendToTarget();
            } catch (OutOfMemoryError e4) {
                Log.e("LoadTask", "OutOfMemory error loading stream", e4);
                if (this.h) {
                    return;
                }
                obtainMessage(3, new d(e4)).sendToTarget();
            }
        }

        public void a(boolean z) {
            this.h = z;
            this.e = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.a.b();
                if (this.g != null) {
                    this.g.interrupt();
                }
            }
            if (z) {
                x.this.f1223b = null;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.f1224b.a((c) this.a, jElapsedRealtime, jElapsedRealtime - this.d, true);
            }
        }
    }
}
