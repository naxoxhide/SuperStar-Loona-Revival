package com.applovin.exoplayer2.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.applovin.exoplayer2.l.ah;
import com.applovin.exoplayer2.l.ai;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class w {
    public static final b aaV = c(false, -9223372036854775807L);
    public static final b aaW = c(true, -9223372036854775807L);
    public static final b aaX;
    public static final b aaY;
    private final ExecutorService aaZ;
    private c<? extends d> aba;
    private IOException abb;

    public interface a<T extends d> {
        b a(T t, long j, long j2, IOException iOException, int i);

        void a(T t, long j, long j2);

        void a(T t, long j, long j2, boolean z);
    }

    public interface d {
        void lq();

        void lr() throws IOException;
    }

    public interface e {
        void ld();
    }

    public static final class g extends IOException {
        public g(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    static {
        long j = -9223372036854775807L;
        aaX = new b(2, j);
        aaY = new b(3, j);
    }

    public static final class b {
        private final long abc;
        private final int bs;

        private b(int i, long j) {
            this.bs = i;
            this.abc = j;
        }

        public boolean oC() {
            int i = this.bs;
            return i == 0 || i == 1;
        }
    }

    public w(String str) {
        this.aaZ = ai.bi("ExoPlayer:Loader:" + str);
    }

    public static b c(boolean z, long j) {
        return new b(z ? 1 : 0, j);
    }

    public boolean oz() {
        return this.abb != null;
    }

    public void oA() {
        this.abb = null;
    }

    public <T extends d> long a(T t, a<T> aVar, int i) {
        Looper looper = (Looper) com.applovin.exoplayer2.l.a.N(Looper.myLooper());
        this.abb = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new c(looper, t, aVar, i, jElapsedRealtime).bn(0L);
        return jElapsedRealtime;
    }

    public boolean kO() {
        return this.aba != null;
    }

    public void oB() {
        ((c) com.applovin.exoplayer2.l.a.N(this.aba)).ar(false);
    }

    public void a(e eVar) {
        c<? extends d> cVar = this.aba;
        if (cVar != null) {
            cVar.ar(true);
        }
        if (eVar != null) {
            this.aaZ.execute(new f(eVar));
        }
        this.aaZ.shutdown();
    }

    public void dK(int i) throws IOException {
        IOException iOException = this.abb;
        if (iOException != null) {
            throw iOException;
        }
        c<? extends d> cVar = this.aba;
        if (cVar != null) {
            if (i == Integer.MIN_VALUE) {
                i = cVar.abd;
            }
            cVar.dK(i);
        }
    }

    private final class c<T extends d> extends Handler implements Runnable {
        public final int abd;
        private final T abe;
        private a<T> abf;
        private IOException abg;
        private Thread abh;
        private boolean abi;
        private volatile boolean cw;
        private final long sC;
        private int sE;

        public c(Looper looper, T t, a<T> aVar, int i, long j) {
            super(looper);
            this.abe = t;
            this.abf = aVar;
            this.abd = i;
            this.sC = j;
        }

        public void dK(int i) throws IOException {
            IOException iOException = this.abg;
            if (iOException != null && this.sE > i) {
                throw iOException;
            }
        }

        public void bn(long j) {
            com.applovin.exoplayer2.l.a.checkState(w.this.aba == null);
            w.this.aba = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                oD();
            }
        }

        public void ar(boolean z) {
            this.cw = z;
            this.abg = null;
            if (hasMessages(0)) {
                this.abi = true;
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    this.abi = true;
                    this.abe.lq();
                    Thread thread = this.abh;
                    if (thread != null) {
                        thread.interrupt();
                    }
                }
            }
            if (z) {
                finish();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                ((a) com.applovin.exoplayer2.l.a.checkNotNull(this.abf)).a(this.abe, jElapsedRealtime, jElapsedRealtime - this.sC, true);
                this.abf = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            try {
                synchronized (this) {
                    z = !this.abi;
                    this.abh = Thread.currentThread();
                }
                if (z) {
                    ah.bg("load:" + this.abe.getClass().getSimpleName());
                    try {
                        this.abe.lr();
                        ah.pV();
                    } catch (Throwable th) {
                        ah.pV();
                        throw th;
                    }
                }
                synchronized (this) {
                    this.abh = null;
                    Thread.interrupted();
                }
                if (this.cw) {
                    return;
                }
                sendEmptyMessage(1);
            } catch (IOException e) {
                if (this.cw) {
                    return;
                }
                obtainMessage(2, e).sendToTarget();
            } catch (Exception e2) {
                if (this.cw) {
                    return;
                }
                com.applovin.exoplayer2.l.q.c("LoadTask", "Unexpected exception loading stream", e2);
                obtainMessage(2, new g(e2)).sendToTarget();
            } catch (OutOfMemoryError e3) {
                if (this.cw) {
                    return;
                }
                com.applovin.exoplayer2.l.q.c("LoadTask", "OutOfMemory error loading stream", e3);
                obtainMessage(2, new g(e3)).sendToTarget();
            } catch (Error e4) {
                if (!this.cw) {
                    com.applovin.exoplayer2.l.q.c("LoadTask", "Unexpected error loading stream", e4);
                    obtainMessage(3, e4).sendToTarget();
                }
                throw e4;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long jOE;
            if (this.cw) {
                return;
            }
            if (message.what == 0) {
                oD();
                return;
            }
            if (message.what == 3) {
                throw ((Error) message.obj);
            }
            finish();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.sC;
            a aVar = (a) com.applovin.exoplayer2.l.a.checkNotNull(this.abf);
            if (this.abi) {
                aVar.a(this.abe, jElapsedRealtime, j, false);
                return;
            }
            int i = message.what;
            if (i == 1) {
                try {
                    aVar.a(this.abe, jElapsedRealtime, j);
                    return;
                } catch (RuntimeException e) {
                    com.applovin.exoplayer2.l.q.c("LoadTask", "Unexpected exception handling load completed", e);
                    w.this.abb = new g(e);
                    return;
                }
            }
            if (i != 2) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.abg = iOException;
            int i2 = this.sE + 1;
            this.sE = i2;
            b bVarA = aVar.a(this.abe, jElapsedRealtime, j, iOException, i2);
            if (bVarA.bs != 3) {
                if (bVarA.bs != 2) {
                    if (bVarA.bs == 1) {
                        this.sE = 1;
                    }
                    if (bVarA.abc != -9223372036854775807L) {
                        jOE = bVarA.abc;
                    } else {
                        jOE = oE();
                    }
                    bn(jOE);
                    return;
                }
                return;
            }
            w.this.abb = this.abg;
        }

        private void oD() {
            this.abg = null;
            w.this.aaZ.execute((Runnable) com.applovin.exoplayer2.l.a.checkNotNull(w.this.aba));
        }

        private void finish() {
            w.this.aba = null;
        }

        private long oE() {
            return Math.min((this.sE - 1) * 1000, 5000);
        }
    }

    private static final class f implements Runnable {
        private final e abk;

        public f(e eVar) {
            this.abk = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.abk.ld();
        }
    }
}
