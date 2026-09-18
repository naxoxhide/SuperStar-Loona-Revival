package com.applovin.impl.sdk.network;

import android.os.Process;
import android.os.SystemClock;
import androidx.core.util.Consumer;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private final PriorityBlockingQueue<b> aHN = new PriorityBlockingQueue<>();
    private final n sdk;

    public e(n nVar) {
        this.sdk = nVar;
    }

    public void start() {
        for (int i = 0; i < ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aKx)).intValue(); i++) {
            new a(this.aHN, i, this.sdk).start();
        }
    }

    public void a(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("No request specified");
        }
        this.aHN.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class a extends Thread {
        private final BlockingQueue<b> aHO;
        private final n sdk;

        private a(BlockingQueue<b> blockingQueue, int i, n nVar) {
            super("AppLovinSdk:network");
            if (blockingQueue == null) {
                throw new IllegalArgumentException("No request queue specified");
            }
            if (nVar == null) {
                throw new IllegalArgumentException("No sdk specified");
            }
            this.aHO = blockingQueue;
            this.sdk = nVar;
            setPriority(((Integer) nVar.a(com.applovin.impl.sdk.c.b.aQF)).intValue());
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    If();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        private void If() throws InterruptedException {
            b(this.aHO.take());
        }

        private void b(final b bVar) {
            HttpURLConnection httpURLConnectionC;
            InputStream inputStream;
            long jElapsedRealtime;
            InputStream errorStream;
            byte[] bArrA;
            byte[] bArrA2;
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            byte[] bArr = null;
            int responseCode = 0;
            try {
                httpURLConnectionC = c(bVar);
                try {
                    if (bVar.aHR != null && bVar.aHR.length > 0) {
                        httpURLConnectionC.setDoOutput(true);
                        httpURLConnectionC.setFixedLengthStreamingMode(bVar.aHR.length);
                        OutputStream outputStream = httpURLConnectionC.getOutputStream();
                        outputStream.write(bVar.aHR);
                        outputStream.close();
                    }
                    jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    responseCode = httpURLConnectionC.getResponseCode();
                    long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                    if (responseCode > 0) {
                        inputStream = httpURLConnectionC.getInputStream();
                        try {
                            bArrA2 = com.applovin.impl.sdk.utils.i.a(inputStream, this.sdk);
                        } catch (Throwable th) {
                            th = th;
                            try {
                                jElapsedRealtime = SystemClock.elapsedRealtime();
                                this.sdk.BL();
                                if (x.Fk()) {
                                    this.sdk.BL().b("NetworkCommunicationThread", "Failed to make HTTP request", th);
                                }
                                if (httpURLConnectionC != null) {
                                    try {
                                        errorStream = httpURLConnectionC.getErrorStream();
                                        try {
                                            bArrA = com.applovin.impl.sdk.utils.i.a(errorStream, this.sdk);
                                        } catch (Throwable unused) {
                                            bArrA = null;
                                            u.a((Closeable) inputStream, this.sdk);
                                            u.a((Closeable) errorStream, this.sdk);
                                            u.a(httpURLConnectionC, this.sdk);
                                            final c cVarIn = c.Im().gG(responseCode).L(bArr).M(bArrA).bR(jElapsedRealtime - jElapsedRealtime2).o(th).In();
                                            bVar.aHT.execute(new Runnable() { // from class: com.applovin.impl.sdk.network.-$$Lambda$e$a$K3iuIIFIUShSMKRn_Gay2wmTqk4
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    e.a.a(bVar, cVarIn);
                                                }
                                            });
                                        }
                                    } catch (Throwable unused2) {
                                        errorStream = null;
                                    }
                                } else {
                                    errorStream = null;
                                    bArrA = null;
                                }
                                u.a((Closeable) inputStream, this.sdk);
                                u.a((Closeable) errorStream, this.sdk);
                                u.a(httpURLConnectionC, this.sdk);
                            } catch (Throwable th2) {
                                u.a((Closeable) inputStream, this.sdk);
                                u.a((Closeable) null, this.sdk);
                                u.a(httpURLConnectionC, this.sdk);
                                throw th2;
                            }
                        }
                    } else {
                        inputStream = null;
                        bArrA2 = null;
                    }
                    u.a((Closeable) inputStream, this.sdk);
                    u.a((Closeable) null, this.sdk);
                    u.a(httpURLConnectionC, this.sdk);
                    bArrA = null;
                    bArr = bArrA2;
                    jElapsedRealtime = jElapsedRealtime3;
                    th = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                httpURLConnectionC = null;
                inputStream = null;
            }
            final c cVarIn2 = c.Im().gG(responseCode).L(bArr).M(bArrA).bR(jElapsedRealtime - jElapsedRealtime2).o(th).In();
            bVar.aHT.execute(new Runnable() { // from class: com.applovin.impl.sdk.network.-$$Lambda$e$a$K3iuIIFIUShSMKRn_Gay2wmTqk4
                @Override // java.lang.Runnable
                public final void run() {
                    e.a.a(bVar, cVarIn2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(b bVar, c cVar) {
            bVar.aHS.accept(cVar);
        }

        private HttpURLConnection c(b bVar) throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(bVar.aHn).openConnection();
            httpURLConnection.setRequestMethod(bVar.aHo);
            httpURLConnection.setConnectTimeout(bVar.aHE);
            httpURLConnection.setReadTimeout(bVar.aHE);
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setDoInput(true);
            if (!bVar.aHQ.isEmpty()) {
                for (Map.Entry entry : bVar.aHQ.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            return httpURLConnection;
        }
    }

    public static class b implements Comparable<b> {
        private static final AtomicInteger aHP = new AtomicInteger();
        private final int aHE;
        private final Map<String, String> aHQ;
        private final byte[] aHR;
        private final Consumer<c> aHS;
        private final Executor aHT;
        private final int aHU;
        private final String aHn;
        private final String aHo;

        private b(a aVar) {
            this.aHn = aVar.aHn;
            this.aHo = aVar.aHo;
            this.aHQ = aVar.aHQ != null ? aVar.aHQ : Collections.emptyMap();
            this.aHR = aVar.aHR;
            this.aHE = aVar.aHE;
            this.aHS = aVar.aHS;
            this.aHT = aVar.aHT;
            this.aHU = aHP.incrementAndGet();
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            return this.aHU - bVar.aHU;
        }

        public static class a {
            private int aHE;
            private Map<String, String> aHQ = new HashMap();
            private byte[] aHR;
            private Consumer<c> aHS;
            private Executor aHT;
            private String aHn;
            private String aHo;

            public a dd(String str) {
                this.aHn = str;
                return this;
            }

            public a de(String str) {
                this.aHo = str;
                return this;
            }

            public a m(Map<String, String> map) {
                if (map == null) {
                    map = new HashMap<>();
                }
                this.aHQ = map;
                return this;
            }

            public a I(String str, String str2) {
                this.aHQ.put(str, str2);
                return this;
            }

            public a K(byte[] bArr) {
                this.aHR = bArr;
                return this;
            }

            public a gF(int i) {
                this.aHE = i;
                return this;
            }

            public a a(Consumer<c> consumer) {
                this.aHS = consumer;
                return this;
            }

            public a a(Executor executor) {
                this.aHT = executor;
                return this;
            }

            public b Ig() {
                return new b(this);
            }
        }
    }

    public static class c {
        private final byte[] aHV;
        private final byte[] aHW;
        private final long aHX;
        private final Throwable aHY;
        private final int aaC;

        private c(a aVar) {
            this.aaC = aVar.aaC;
            this.aHV = aVar.aHV;
            this.aHW = aVar.aHW;
            this.aHX = aVar.aHX;
            this.aHY = aVar.aHY;
        }

        public int Ih() throws Throwable {
            Throwable th = this.aHY;
            if (th != null) {
                throw th;
            }
            return this.aaC;
        }

        public int Ii() {
            return this.aaC;
        }

        public byte[] Ij() throws Throwable {
            Throwable th = this.aHY;
            if (th != null) {
                throw th;
            }
            return this.aHV;
        }

        public byte[] Ik() {
            return this.aHW;
        }

        public long Il() {
            return this.aHX;
        }

        public static a Im() {
            return new a();
        }

        public static class a {
            private byte[] aHV;
            private byte[] aHW;
            private long aHX;
            private Throwable aHY;
            private int aaC;

            public a gG(int i) {
                this.aaC = i;
                return this;
            }

            public a L(byte[] bArr) {
                this.aHV = bArr;
                return this;
            }

            public a M(byte[] bArr) {
                this.aHW = bArr;
                return this;
            }

            public a o(Throwable th) {
                this.aHY = th;
                return this;
            }

            public a bR(long j) {
                this.aHX = j;
                return this;
            }

            public c In() {
                return new c(this);
            }
        }
    }
}
