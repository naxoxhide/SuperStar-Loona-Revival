package com.applovin.exoplayer2.f;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.applovin.exoplayer2.common.base.Supplier;
import com.applovin.exoplayer2.l.ah;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class a implements g {
    private boolean GA;
    private Surface GB;
    private final MediaCodec Gw;
    private final c Gx;
    private final b Gy;
    private final boolean Gz;
    private int Z;

    @Override // com.applovin.exoplayer2.f.g
    public boolean jC() {
        return false;
    }

    /* JADX INFO: renamed from: com.applovin.exoplayer2.f.a$a, reason: collision with other inner class name */
    public static final class C0094a implements g.b {
        private final Supplier<HandlerThread> GC;
        private final Supplier<HandlerThread> GD;
        private final boolean GE;
        private final boolean Gz;

        public C0094a(final int i, boolean z, boolean z2) {
            this(new Supplier() { // from class: com.applovin.exoplayer2.f.-$$Lambda$a$a$VgEq90HMhbH5BMSLB3zIG95htn4
                @Override // com.applovin.exoplayer2.common.base.Supplier
                public final Object get() {
                    return a.C0094a.cP(i);
                }
            }, new Supplier() { // from class: com.applovin.exoplayer2.f.-$$Lambda$a$a$_Ip67L3pPbr3t_Wd9WIaHejVgSg
                @Override // com.applovin.exoplayer2.common.base.Supplier
                public final Object get() {
                    return a.C0094a.cO(i);
                }
            }, z, z2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ HandlerThread cP(int i) {
            return new HandlerThread(a.cK(i));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ HandlerThread cO(int i) {
            return new HandlerThread(a.cL(i));
        }

        C0094a(Supplier<HandlerThread> supplier, Supplier<HandlerThread> supplier2, boolean z, boolean z2) {
            this.GC = supplier;
            this.GD = supplier2;
            this.GE = z;
            this.Gz = z2;
        }

        @Override // com.applovin.exoplayer2.f.g.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b(g.a aVar) throws Exception {
            MediaCodec mediaCodecCreateByCodecName;
            String str = aVar.Hk.name;
            a aVar2 = null;
            try {
                ah.bg("createCodec:" + str);
                mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
                try {
                    a aVar3 = new a(mediaCodecCreateByCodecName, this.GC.get(), this.GD.get(), this.GE, this.Gz);
                    try {
                        ah.pV();
                        aVar3.a(aVar.Hl, aVar.Hm, aVar.Hn, aVar.jF, aVar.Ho);
                        return aVar3;
                    } catch (Exception e) {
                        e = e;
                        aVar2 = aVar3;
                        if (aVar2 != null) {
                            aVar2.release();
                        } else if (mediaCodecCreateByCodecName != null) {
                            mediaCodecCreateByCodecName.release();
                        }
                        throw e;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                mediaCodecCreateByCodecName = null;
            }
        }
    }

    private a(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z, boolean z2) {
        this.Gw = mediaCodec;
        this.Gx = new c(handlerThread);
        this.Gy = new b(mediaCodec, handlerThread2, z);
        this.Gz = z2;
        this.Z = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i, boolean z) {
        this.Gx.a(this.Gw);
        ah.bg("configureCodec");
        this.Gw.configure(mediaFormat, surface, mediaCrypto, i);
        ah.pV();
        if (z) {
            this.GB = this.Gw.createInputSurface();
        }
        this.Gy.start();
        ah.bg("startCodec");
        this.Gw.start();
        ah.pV();
        this.Z = 1;
    }

    @Override // com.applovin.exoplayer2.f.g
    public void a(int i, int i2, int i3, long j, int i4) {
        this.Gy.a(i, i2, i3, j, i4);
    }

    @Override // com.applovin.exoplayer2.f.g
    public void a(int i, int i2, com.applovin.exoplayer2.c.c cVar, long j, int i3) {
        this.Gy.a(i, i2, cVar, j, i3);
    }

    @Override // com.applovin.exoplayer2.f.g
    public void l(int i, boolean z) {
        this.Gw.releaseOutputBuffer(i, z);
    }

    @Override // com.applovin.exoplayer2.f.g
    public void i(int i, long j) {
        this.Gw.releaseOutputBuffer(i, j);
    }

    @Override // com.applovin.exoplayer2.f.g
    public int jD() {
        return this.Gx.jD();
    }

    @Override // com.applovin.exoplayer2.f.g
    public int a(MediaCodec.BufferInfo bufferInfo) {
        return this.Gx.a(bufferInfo);
    }

    @Override // com.applovin.exoplayer2.f.g
    public MediaFormat jE() {
        return this.Gx.jE();
    }

    @Override // com.applovin.exoplayer2.f.g
    public ByteBuffer cH(int i) {
        return this.Gw.getInputBuffer(i);
    }

    @Override // com.applovin.exoplayer2.f.g
    public ByteBuffer cI(int i) {
        return this.Gw.getOutputBuffer(i);
    }

    @Override // com.applovin.exoplayer2.f.g
    public void dI() {
        this.Gy.dI();
        this.Gw.flush();
        c cVar = this.Gx;
        final MediaCodec mediaCodec = this.Gw;
        Objects.requireNonNull(mediaCodec);
        cVar.a(new Runnable() { // from class: com.applovin.exoplayer2.f.-$$Lambda$a$eDpY_fTfY9aVkUSlR57RZPPXgr0
            @Override // java.lang.Runnable
            public final void run() {
                mediaCodec.start();
            }
        });
    }

    @Override // com.applovin.exoplayer2.f.g
    public void release() {
        try {
            if (this.Z == 1) {
                this.Gy.jG();
                this.Gx.jG();
            }
            this.Z = 2;
        } finally {
            Surface surface = this.GB;
            if (surface != null) {
                surface.release();
            }
            if (!this.GA) {
                this.Gw.release();
                this.GA = true;
            }
        }
    }

    @Override // com.applovin.exoplayer2.f.g
    public void a(final g.c cVar, Handler handler) {
        jF();
        this.Gw.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: com.applovin.exoplayer2.f.-$$Lambda$a$rU0OUu9vUa9KRXYDsIwlT6qd6_w
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
                this.f$0.a(cVar, mediaCodec, j, j2);
            }
        }, handler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(g.c cVar, MediaCodec mediaCodec, long j, long j2) {
        cVar.a(this, j, j2);
    }

    @Override // com.applovin.exoplayer2.f.g
    public void b(Surface surface) {
        jF();
        this.Gw.setOutputSurface(surface);
    }

    @Override // com.applovin.exoplayer2.f.g
    public void u(Bundle bundle) {
        jF();
        this.Gw.setParameters(bundle);
    }

    @Override // com.applovin.exoplayer2.f.g
    public void cJ(int i) {
        jF();
        this.Gw.setVideoScalingMode(i);
    }

    private void jF() {
        if (this.Gz) {
            try {
                this.Gy.jH();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String cK(int i) {
        return c(i, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String cL(int i) {
        return c(i, "ExoPlayer:MediaCodecQueueingThread:");
    }

    private static String c(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(").append(i).append(")");
        }
        return sb.toString();
    }
}
