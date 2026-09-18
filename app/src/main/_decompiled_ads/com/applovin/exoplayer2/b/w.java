package com.applovin.exoplayer2.b;

import android.support.v4.media.session.PlaybackStateCompat;
import com.applovin.exoplayer2.l.ai;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class w implements f {
    private ByteBuffer kS;
    private ByteBuffer kT;
    private boolean kU;
    private int nm;
    private boolean nn;
    private v no;
    private ShortBuffer np;
    private long nq;
    private long nr;
    private float gD = 1.0f;
    private float gE = 1.0f;
    private f.a kQ = f.a.jP;
    private f.a kR = f.a.jP;
    private f.a kO = f.a.jP;
    private f.a kP = f.a.jP;

    public w() {
        ByteBuffer byteBuffer = jO;
        this.kS = byteBuffer;
        this.np = byteBuffer.asShortBuffer();
        this.kT = jO;
        this.nm = -1;
    }

    public void l(float f) {
        if (this.gD != f) {
            this.gD = f;
            this.nn = true;
        }
    }

    public void m(float f) {
        if (this.gE != f) {
            this.gE = f;
            this.nn = true;
        }
    }

    public long U(long j) {
        if (this.nr >= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            long jEN = this.nq - ((long) ((v) com.applovin.exoplayer2.l.a.checkNotNull(this.no)).eN());
            if (this.kP.dM == this.kO.dM) {
                return ai.e(j, jEN, this.nr);
            }
            return ai.e(j, jEN * ((long) this.kP.dM), this.nr * ((long) this.kO.dM));
        }
        return (long) (((double) this.gD) * j);
    }

    @Override // com.applovin.exoplayer2.b.f
    public f.a a(f.a aVar) throws f.b {
        if (aVar.jQ != 2) {
            throw new f.b(aVar);
        }
        int i = this.nm;
        if (i == -1) {
            i = aVar.dM;
        }
        this.kQ = aVar;
        f.a aVar2 = new f.a(i, aVar.dL, 2);
        this.kR = aVar2;
        this.nn = true;
        return aVar2;
    }

    @Override // com.applovin.exoplayer2.b.f
    public boolean isActive() {
        return this.kR.dM != -1 && (Math.abs(this.gD - 1.0f) >= 1.0E-4f || Math.abs(this.gE - 1.0f) >= 1.0E-4f || this.kR.dM != this.kQ.dM);
    }

    @Override // com.applovin.exoplayer2.b.f
    public void d(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            v vVar = (v) com.applovin.exoplayer2.l.a.checkNotNull(this.no);
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.nq += (long) iRemaining;
            vVar.a(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    @Override // com.applovin.exoplayer2.b.f
    public void dG() {
        v vVar = this.no;
        if (vVar != null) {
            vVar.dG();
        }
        this.kU = true;
    }

    @Override // com.applovin.exoplayer2.b.f
    public ByteBuffer dH() {
        int iEO;
        v vVar = this.no;
        if (vVar != null && (iEO = vVar.eO()) > 0) {
            if (this.kS.capacity() < iEO) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iEO).order(ByteOrder.nativeOrder());
                this.kS = byteBufferOrder;
                this.np = byteBufferOrder.asShortBuffer();
            } else {
                this.kS.clear();
                this.np.clear();
            }
            vVar.b(this.np);
            this.nr += (long) iEO;
            this.kS.limit(iEO);
            this.kT = this.kS;
        }
        ByteBuffer byteBuffer = this.kT;
        this.kT = jO;
        return byteBuffer;
    }

    @Override // com.applovin.exoplayer2.b.f
    public boolean cR() {
        v vVar;
        return this.kU && ((vVar = this.no) == null || vVar.eO() == 0);
    }

    @Override // com.applovin.exoplayer2.b.f
    public void dI() {
        if (isActive()) {
            this.kO = this.kQ;
            this.kP = this.kR;
            if (this.nn) {
                this.no = new v(this.kO.dM, this.kO.dL, this.gD, this.gE, this.kP.dM);
            } else {
                v vVar = this.no;
                if (vVar != null) {
                    vVar.dI();
                }
            }
        }
        this.kT = jO;
        this.nq = 0L;
        this.nr = 0L;
        this.kU = false;
    }

    @Override // com.applovin.exoplayer2.b.f
    public void Y() {
        this.gD = 1.0f;
        this.gE = 1.0f;
        this.kQ = f.a.jP;
        this.kR = f.a.jP;
        this.kO = f.a.jP;
        this.kP = f.a.jP;
        ByteBuffer byteBuffer = jO;
        this.kS = byteBuffer;
        this.np = byteBuffer.asShortBuffer();
        this.kT = jO;
        this.nm = -1;
        this.nn = false;
        this.no = null;
        this.nq = 0L;
        this.nr = 0L;
        this.kU = false;
    }
}
