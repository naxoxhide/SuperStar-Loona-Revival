package com.applovin.exoplayer2.f;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.applovin.exoplayer2.l.ah;
import com.applovin.exoplayer2.l.ai;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class m implements g {
    private final Surface GB;
    private final MediaCodec Gw;
    private ByteBuffer[] IX;
    private ByteBuffer[] IY;

    @Override // com.applovin.exoplayer2.f.g
    public boolean jC() {
        return false;
    }

    public static class b implements g.b {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.applovin.exoplayer2.f.m$1] */
        /* JADX WARN: Type inference failed for: r0v1, types: [android.view.Surface] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        @Override // com.applovin.exoplayer2.f.g.b
        public g b(g.a aVar) throws Throwable {
            MediaCodec mediaCodecC;
            Surface surfaceB;
            ?? r0 = 0;
            r0 = 0;
            r0 = 0;
            try {
                mediaCodecC = c(aVar);
                try {
                    ah.bg("configureCodec");
                    mediaCodecC.configure(aVar.Hl, aVar.Hm, aVar.Hn, aVar.jF);
                    ah.pV();
                    if (!aVar.Ho) {
                        surfaceB = null;
                    } else if (ai.acV >= 18) {
                        surfaceB = a.b(mediaCodecC);
                    } else {
                        throw new IllegalStateException("Encoding from a surface is only supported on API 18 and up.");
                    }
                    try {
                        ah.bg("startCodec");
                        mediaCodecC.start();
                        ah.pV();
                        return new m(mediaCodecC, surfaceB);
                    } catch (IOException | RuntimeException e) {
                        r0 = surfaceB;
                        e = e;
                        if (r0 != 0) {
                            r0.release();
                        }
                        if (mediaCodecC != null) {
                            mediaCodecC.release();
                        }
                        throw e;
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (RuntimeException e3) {
                    e = e3;
                }
            } catch (IOException | RuntimeException e4) {
                e = e4;
                mediaCodecC = null;
            }
        }

        protected MediaCodec c(g.a aVar) throws IOException {
            com.applovin.exoplayer2.l.a.checkNotNull(aVar.Hk);
            String str = aVar.Hk.name;
            ah.bg("createCodec:" + str);
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            ah.pV();
            return mediaCodecCreateByCodecName;
        }
    }

    private m(MediaCodec mediaCodec, Surface surface) {
        this.Gw = mediaCodec;
        this.GB = surface;
        if (ai.acV < 21) {
            this.IX = mediaCodec.getInputBuffers();
            this.IY = mediaCodec.getOutputBuffers();
        }
    }

    @Override // com.applovin.exoplayer2.f.g
    public int jD() {
        return this.Gw.dequeueInputBuffer(0L);
    }

    @Override // com.applovin.exoplayer2.f.g
    public int a(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.Gw.dequeueOutputBuffer(bufferInfo, 0L);
            if (iDequeueOutputBuffer == -3 && ai.acV < 21) {
                this.IY = this.Gw.getOutputBuffers();
            }
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // com.applovin.exoplayer2.f.g
    public MediaFormat jE() {
        return this.Gw.getOutputFormat();
    }

    @Override // com.applovin.exoplayer2.f.g
    public ByteBuffer cH(int i) {
        if (ai.acV >= 21) {
            return this.Gw.getInputBuffer(i);
        }
        return ((ByteBuffer[]) ai.R(this.IX))[i];
    }

    @Override // com.applovin.exoplayer2.f.g
    public ByteBuffer cI(int i) {
        if (ai.acV >= 21) {
            return this.Gw.getOutputBuffer(i);
        }
        return ((ByteBuffer[]) ai.R(this.IY))[i];
    }

    @Override // com.applovin.exoplayer2.f.g
    public void a(int i, int i2, int i3, long j, int i4) {
        this.Gw.queueInputBuffer(i, i2, i3, j, i4);
    }

    @Override // com.applovin.exoplayer2.f.g
    public void a(int i, int i2, com.applovin.exoplayer2.c.c cVar, long j, int i3) {
        this.Gw.queueSecureInputBuffer(i, i2, cVar.hb(), j, i3);
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
    public void dI() {
        this.Gw.flush();
    }

    @Override // com.applovin.exoplayer2.f.g
    public void release() {
        this.IX = null;
        this.IY = null;
        Surface surface = this.GB;
        if (surface != null) {
            surface.release();
        }
        this.Gw.release();
    }

    @Override // com.applovin.exoplayer2.f.g
    public void a(final g.c cVar, Handler handler) {
        this.Gw.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: com.applovin.exoplayer2.f.-$$Lambda$m$2Bbdhs5TT8JsBqNyiDKWiy821TU
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
        this.Gw.setOutputSurface(surface);
    }

    @Override // com.applovin.exoplayer2.f.g
    public void u(Bundle bundle) {
        this.Gw.setParameters(bundle);
    }

    @Override // com.applovin.exoplayer2.f.g
    public void cJ(int i) {
        this.Gw.setVideoScalingMode(i);
    }

    private static final class a {
        public static Surface b(MediaCodec mediaCodec) {
            return mediaCodec.createInputSurface();
        }
    }
}
