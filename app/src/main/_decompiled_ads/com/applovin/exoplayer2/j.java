package com.applovin.exoplayer2;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class j implements i {
    private final long ap = -9223372036854775807L;
    private final long ao = -9223372036854775807L;
    private final boolean aq = false;

    @Override // com.applovin.exoplayer2.i
    public boolean a(an anVar) {
        anVar.aD();
        return true;
    }

    @Override // com.applovin.exoplayer2.i
    public boolean a(an anVar, boolean z) {
        anVar.k(z);
        return true;
    }

    @Override // com.applovin.exoplayer2.i
    public boolean a(an anVar, int i, long j) {
        anVar.a(i, j);
        return true;
    }

    @Override // com.applovin.exoplayer2.i
    public boolean b(an anVar) {
        anVar.B();
        return true;
    }

    @Override // com.applovin.exoplayer2.i
    public boolean c(an anVar) {
        anVar.E();
        return true;
    }

    @Override // com.applovin.exoplayer2.i
    public boolean d(an anVar) {
        if (!this.aq) {
            anVar.x();
            return true;
        }
        if (!aj() || !anVar.J()) {
            return true;
        }
        a(anVar, -this.ao);
        return true;
    }

    @Override // com.applovin.exoplayer2.i
    public boolean e(an anVar) {
        if (!this.aq) {
            anVar.y();
            return true;
        }
        if (!ak() || !anVar.J()) {
            return true;
        }
        a(anVar, this.ap);
        return true;
    }

    @Override // com.applovin.exoplayer2.i
    public boolean a(an anVar, int i) {
        anVar.u(i);
        return true;
    }

    @Override // com.applovin.exoplayer2.i
    public boolean b(an anVar, boolean z) {
        anVar.l(z);
        return true;
    }

    @Override // com.applovin.exoplayer2.i
    public boolean aj() {
        return !this.aq || this.ao > 0;
    }

    @Override // com.applovin.exoplayer2.i
    public boolean ak() {
        return !this.aq || this.ap > 0;
    }

    private static void a(an anVar, long j) {
        long jAN = anVar.aN() + j;
        long jAM = anVar.aM();
        if (jAM != -9223372036854775807L) {
            jAN = Math.min(jAN, jAM);
        }
        anVar.b(Math.max(jAN, 0L));
    }
}
