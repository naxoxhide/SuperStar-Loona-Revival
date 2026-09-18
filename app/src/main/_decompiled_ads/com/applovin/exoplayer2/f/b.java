package com.applovin.exoplayer2.f;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.l.ai;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
class b {
    private static final ArrayDeque<a> GF = new ArrayDeque<>();
    private static final Object GG = new Object();
    private final HandlerThread GH;
    private final AtomicReference<RuntimeException> GI;
    private final com.applovin.exoplayer2.l.g GJ;
    private final boolean GK;
    private boolean GL;
    private final MediaCodec Gw;
    private Handler jS;

    public b(MediaCodec mediaCodec, HandlerThread handlerThread, boolean z) {
        this(mediaCodec, handlerThread, z, new com.applovin.exoplayer2.l.g());
    }

    b(MediaCodec mediaCodec, HandlerThread handlerThread, boolean z, com.applovin.exoplayer2.l.g gVar) {
        this.Gw = mediaCodec;
        this.GH = handlerThread;
        this.GJ = gVar;
        this.GI = new AtomicReference<>();
        this.GK = z || jL();
    }

    public void start() {
        if (this.GL) {
            return;
        }
        this.GH.start();
        this.jS = new Handler(this.GH.getLooper()) { // from class: com.applovin.exoplayer2.f.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                b.this.a(message);
            }
        };
        this.GL = true;
    }

    public void a(int i, int i2, int i3, long j, int i4) {
        hk();
        a aVarJK = jK();
        aVarJK.c(i, i2, i3, j, i4);
        ((Handler) ai.R(this.jS)).obtainMessage(0, aVarJK).sendToTarget();
    }

    public void a(int i, int i2, com.applovin.exoplayer2.c.c cVar, long j, int i3) {
        hk();
        a aVarJK = jK();
        aVarJK.c(i, i2, 0, j, i3);
        a(cVar, aVarJK.GN);
        ((Handler) ai.R(this.jS)).obtainMessage(1, aVarJK).sendToTarget();
    }

    public void dI() {
        if (this.GL) {
            try {
                jI();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    public void jG() {
        if (this.GL) {
            dI();
            this.GH.quit();
        }
        this.GL = false;
    }

    public void jH() throws InterruptedException {
        jJ();
    }

    private void hk() {
        RuntimeException andSet = this.GI.getAndSet(null);
        if (andSet != null) {
            throw andSet;
        }
    }

    private void jI() throws InterruptedException {
        ((Handler) ai.R(this.jS)).removeCallbacksAndMessages(null);
        jJ();
        hk();
    }

    private void jJ() throws InterruptedException {
        this.GJ.oO();
        ((Handler) ai.R(this.jS)).obtainMessage(2).sendToTarget();
        this.GJ.oP();
    }

    void b(RuntimeException runtimeException) {
        this.GI.set(runtimeException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        a aVar;
        int i = message.what;
        if (i == 0) {
            aVar = (a) message.obj;
            b(aVar.Y, aVar.oU, aVar.oW, aVar.GO, aVar.jF);
        } else if (i != 1) {
            if (i == 2) {
                this.GJ.oN();
            } else {
                b(new IllegalStateException(String.valueOf(message.what)));
            }
            aVar = null;
        } else {
            aVar = (a) message.obj;
            a(aVar.Y, aVar.oU, aVar.GN, aVar.GO, aVar.jF);
        }
        if (aVar != null) {
            a(aVar);
        }
    }

    private void b(int i, int i2, int i3, long j, int i4) {
        try {
            this.Gw.queueInputBuffer(i, i2, i3, j, i4);
        } catch (RuntimeException e) {
            b(e);
        }
    }

    private void a(int i, int i2, MediaCodec.CryptoInfo cryptoInfo, long j, int i3) {
        try {
            if (this.GK) {
                synchronized (GG) {
                    this.Gw.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
                }
                return;
            }
            this.Gw.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
        } catch (RuntimeException e) {
            b(e);
        }
    }

    private static a jK() {
        ArrayDeque<a> arrayDeque = GF;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                return new a();
            }
            return arrayDeque.removeFirst();
        }
    }

    private static void a(a aVar) {
        ArrayDeque<a> arrayDeque = GF;
        synchronized (arrayDeque) {
            arrayDeque.add(aVar);
        }
    }

    private static class a {
        public final MediaCodec.CryptoInfo GN = new MediaCodec.CryptoInfo();
        public long GO;
        public int Y;
        public int jF;
        public int oU;
        public int oW;

        a() {
        }

        public void c(int i, int i2, int i3, long j, int i4) {
            this.Y = i;
            this.oU = i2;
            this.oW = i3;
            this.GO = j;
            this.jF = i4;
        }
    }

    private static boolean jL() {
        String lowerCase = Ascii.toLowerCase(ai.acX);
        return lowerCase.contains("samsung") || lowerCase.contains("motorola");
    }

    private static void a(com.applovin.exoplayer2.c.c cVar, MediaCodec.CryptoInfo cryptoInfo) {
        cryptoInfo.numSubSamples = cVar.rp;
        cryptoInfo.numBytesOfClearData = a(cVar.rn, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = a(cVar.ro, cryptoInfo.numBytesOfEncryptedData);
        cryptoInfo.key = (byte[]) com.applovin.exoplayer2.l.a.checkNotNull(c(cVar.rl, cryptoInfo.key));
        cryptoInfo.iv = (byte[]) com.applovin.exoplayer2.l.a.checkNotNull(c(cVar.rk, cryptoInfo.iv));
        cryptoInfo.mode = cVar.rm;
        if (ai.acV >= 24) {
            cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(cVar.rq, cVar.rr));
        }
    }

    private static int[] a(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    private static byte[] c(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
