package com.applovin.exoplayer2.f;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import com.applovin.exoplayer2.l.ai;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
final class c extends MediaCodec.Callback {
    private final HandlerThread GP;
    private MediaFormat GV;
    private MediaFormat GW;
    private MediaCodec.CodecException GX;
    private long GY;
    private boolean GZ;
    private IllegalStateException Ha;
    private Handler jS;
    private final Object rT = new Object();
    private final f GQ = new f();
    private final f GR = new f();
    private final ArrayDeque<MediaCodec.BufferInfo> GT = new ArrayDeque<>();
    private final ArrayDeque<MediaFormat> GU = new ArrayDeque<>();

    c(HandlerThread handlerThread) {
        this.GP = handlerThread;
    }

    public void a(MediaCodec mediaCodec) {
        com.applovin.exoplayer2.l.a.checkState(this.jS == null);
        this.GP.start();
        Handler handler = new Handler(this.GP.getLooper());
        mediaCodec.setCallback(this, handler);
        this.jS = handler;
    }

    public void jG() {
        synchronized (this.rT) {
            this.GZ = true;
            this.GP.quit();
            jM();
        }
    }

    public int jD() {
        synchronized (this.rT) {
            int iJT = -1;
            if (jN()) {
                return -1;
            }
            hk();
            if (!this.GQ.isEmpty()) {
                iJT = this.GQ.jT();
            }
            return iJT;
        }
    }

    public int a(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.rT) {
            if (jN()) {
                return -1;
            }
            hk();
            if (this.GR.isEmpty()) {
                return -1;
            }
            int iJT = this.GR.jT();
            if (iJT >= 0) {
                com.applovin.exoplayer2.l.a.N(this.GV);
                MediaCodec.BufferInfo bufferInfoRemove = this.GT.remove();
                bufferInfo.set(bufferInfoRemove.offset, bufferInfoRemove.size, bufferInfoRemove.presentationTimeUs, bufferInfoRemove.flags);
            } else if (iJT == -2) {
                this.GV = this.GU.remove();
            }
            return iJT;
        }
    }

    public MediaFormat jE() {
        MediaFormat mediaFormat;
        synchronized (this.rT) {
            mediaFormat = this.GV;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    public void a(final Runnable runnable) {
        synchronized (this.rT) {
            this.GY++;
            ((Handler) ai.R(this.jS)).post(new Runnable() { // from class: com.applovin.exoplayer2.f.-$$Lambda$c$oore02LfapAs4ccm67HZsDI_GMY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.d(runnable);
                }
            });
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        synchronized (this.rT) {
            this.GQ.cR(i);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.rT) {
            MediaFormat mediaFormat = this.GW;
            if (mediaFormat != null) {
                a(mediaFormat);
                this.GW = null;
            }
            this.GR.cR(i);
            this.GT.add(bufferInfo);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.rT) {
            this.GX = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.rT) {
            a(mediaFormat);
            this.GW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void d(Runnable runnable) {
        synchronized (this.rT) {
            c(runnable);
        }
    }

    private void c(Runnable runnable) {
        if (this.GZ) {
            return;
        }
        long j = this.GY - 1;
        this.GY = j;
        if (j > 0) {
            return;
        }
        if (j < 0) {
            a(new IllegalStateException());
            return;
        }
        jM();
        try {
            runnable.run();
        } catch (IllegalStateException e) {
            a(e);
        } catch (Exception e2) {
            a(new IllegalStateException(e2));
        }
    }

    private void jM() {
        if (!this.GU.isEmpty()) {
            this.GW = this.GU.getLast();
        }
        this.GQ.clear();
        this.GR.clear();
        this.GT.clear();
        this.GU.clear();
        this.GX = null;
    }

    private boolean jN() {
        return this.GY > 0 || this.GZ;
    }

    private void a(MediaFormat mediaFormat) {
        this.GR.cR(-2);
        this.GU.add(mediaFormat);
    }

    private void hk() {
        jO();
        jP();
    }

    private void jO() {
        IllegalStateException illegalStateException = this.Ha;
        if (illegalStateException == null) {
            return;
        }
        this.Ha = null;
        throw illegalStateException;
    }

    private void jP() {
        MediaCodec.CodecException codecException = this.GX;
        if (codecException == null) {
            return;
        }
        this.GX = null;
        throw codecException;
    }

    private void a(IllegalStateException illegalStateException) {
        synchronized (this.rT) {
            this.Ha = illegalStateException;
        }
    }
}
