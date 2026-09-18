package com.applovin.exoplayer2.b;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public abstract class l implements f {
    private boolean kU;
    private ByteBuffer kS = jO;
    private ByteBuffer kT = jO;
    private f.a kQ = f.a.jP;
    private f.a kR = f.a.jP;
    protected f.a kO = f.a.jP;
    protected f.a kP = f.a.jP;

    protected void ad() {
    }

    protected void ef() {
    }

    protected void eg() {
    }

    @Override // com.applovin.exoplayer2.b.f
    public final f.a a(f.a aVar) throws f.b {
        this.kQ = aVar;
        this.kR = b(aVar);
        return isActive() ? this.kR : f.a.jP;
    }

    @Override // com.applovin.exoplayer2.b.f
    public boolean isActive() {
        return this.kR != f.a.jP;
    }

    @Override // com.applovin.exoplayer2.b.f
    public final void dG() {
        this.kU = true;
        ef();
    }

    @Override // com.applovin.exoplayer2.b.f
    public ByteBuffer dH() {
        ByteBuffer byteBuffer = this.kT;
        this.kT = jO;
        return byteBuffer;
    }

    @Override // com.applovin.exoplayer2.b.f
    public boolean cR() {
        return this.kU && this.kT == jO;
    }

    @Override // com.applovin.exoplayer2.b.f
    public final void dI() {
        this.kT = jO;
        this.kU = false;
        this.kO = this.kQ;
        this.kP = this.kR;
        eg();
    }

    @Override // com.applovin.exoplayer2.b.f
    public final void Y() {
        dI();
        this.kS = jO;
        this.kQ = f.a.jP;
        this.kR = f.a.jP;
        this.kO = f.a.jP;
        this.kP = f.a.jP;
        ad();
    }

    protected final ByteBuffer az(int i) {
        if (this.kS.capacity() < i) {
            this.kS = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.kS.clear();
        }
        ByteBuffer byteBuffer = this.kS;
        this.kT = byteBuffer;
        return byteBuffer;
    }

    protected final boolean ee() {
        return this.kT.hasRemaining();
    }

    protected f.a b(f.a aVar) throws f.b {
        return f.a.jP;
    }
}
