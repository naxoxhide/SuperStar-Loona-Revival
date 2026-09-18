package com.applovin.exoplayer2.f;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import com.applovin.exoplayer2.d.n;
import com.applovin.exoplayer2.l.af;
import com.applovin.exoplayer2.l.ah;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.p;
import com.applovin.exoplayer2.v;
import com.applovin.exoplayer2.w;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class j extends com.applovin.exoplayer2.e {
    private static final byte[] Hz = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    private final g.b HA;
    private final float HB;
    private final com.applovin.exoplayer2.c.g HC;
    private final com.applovin.exoplayer2.c.g HD;
    private final com.applovin.exoplayer2.c.g HE;
    private final d HF;
    private final af<v> HG;
    private final ArrayList<Long> HH;
    private final MediaCodec.BufferInfo HI;
    private final long[] HJ;
    private final long[] HK;
    private final long[] HL;
    private v HM;
    private com.applovin.exoplayer2.d.f HN;
    private com.applovin.exoplayer2.d.f HO;
    private MediaCrypto HP;
    private boolean HQ;
    private long HR;
    private float HS;
    private float HU;
    private g HV;
    private v HW;
    private MediaFormat HX;
    private boolean HY;
    private float HZ;
    private i Hk;
    private boolean IA;
    private boolean IB;
    private boolean IC;
    private long ID;
    private long IE;
    private boolean IF;
    private boolean IG;
    private boolean IH;
    private boolean II;
    private boolean IJ;
    private p IK;
    protected com.applovin.exoplayer2.c.e IL;
    private long IM;
    private long IN;
    private int IO;
    private ArrayDeque<i> Ia;
    private a Ib;
    private int Ic;
    private boolean Id;
    private boolean Ie;
    private boolean If;
    private boolean Ig;
    private boolean Ih;
    private boolean Ii;
    private boolean Ij;
    private boolean Ik;
    private boolean Il;
    private boolean Im;
    private e In;
    private long Io;
    private int Ip;
    private int Iq;
    private boolean Ir;
    private boolean Is;
    private boolean It;
    private boolean Iu;
    private boolean Iv;
    private boolean Iw;
    private int Ix;
    private int Iy;
    private int Iz;
    private final boolean bf;
    private final k bg;
    private boolean bi;
    private boolean bj;
    private ByteBuffer kT;
    private v lS;

    @Override // com.applovin.exoplayer2.e, com.applovin.exoplayer2.as
    public final int Z() {
        return 8;
    }

    protected float a(float f, v vVar, v[] vVarArr) {
        return -1.0f;
    }

    protected abstract int a(k kVar, v vVar) throws l.b;

    protected abstract g.a a(i iVar, v vVar, MediaCrypto mediaCrypto, float f);

    protected abstract List<i> a(k kVar, v vVar, boolean z) throws l.b;

    protected void a(com.applovin.exoplayer2.c.g gVar) throws p {
    }

    protected void a(v vVar, MediaFormat mediaFormat) throws p {
    }

    protected abstract boolean a(long j, long j2, g gVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, v vVar) throws p;

    protected boolean a(i iVar) {
        return true;
    }

    @Override // com.applovin.exoplayer2.e
    protected void aa() {
    }

    @Override // com.applovin.exoplayer2.e
    protected void ab() {
    }

    protected void e(String str, long j, long j2) {
    }

    protected void eB() {
    }

    protected void eC() throws p {
    }

    protected void f(com.applovin.exoplayer2.c.g gVar) throws p {
    }

    protected boolean f(v vVar) {
        return false;
    }

    protected void i(Exception exc) {
    }

    protected boolean jY() {
        return false;
    }

    protected void v(String str) {
    }

    public static class a extends Exception {
        public final i Hk;
        public final String Hq;
        public final boolean IP;
        public final a IQ;
        public final String eg;

        public a(v vVar, Throwable th, boolean z, int i) {
            this("Decoder init failed: [" + i + "], " + vVar, th, vVar.dz, z, null, cV(i), null);
        }

        public a(v vVar, Throwable th, boolean z, i iVar) {
            this("Decoder init failed: " + iVar.name + ", " + vVar, th, vVar.dz, z, iVar, ai.acV >= 21 ? g(th) : null, null);
        }

        private a(String str, Throwable th, String str2, boolean z, i iVar, String str3, a aVar) {
            super(str, th);
            this.eg = str2;
            this.IP = z;
            this.Hk = iVar;
            this.Hq = str3;
            this.IQ = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a a(a aVar) {
            return new a(getMessage(), getCause(), this.eg, this.IP, this.Hk, this.Hq, aVar);
        }

        private static String g(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        private static String cV(int i) {
            return "com.applovin.exoplayer2.mediacodec.MediaCodecRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }
    }

    public j(int i, g.b bVar, k kVar, boolean z, float f) {
        super(i);
        this.HA = bVar;
        this.bg = (k) com.applovin.exoplayer2.l.a.checkNotNull(kVar);
        this.bf = z;
        this.HB = f;
        this.HC = com.applovin.exoplayer2.c.g.hf();
        this.HD = new com.applovin.exoplayer2.c.g(0);
        this.HE = new com.applovin.exoplayer2.c.g(2);
        d dVar = new d();
        this.HF = dVar;
        this.HG = new af<>();
        this.HH = new ArrayList<>();
        this.HI = new MediaCodec.BufferInfo();
        this.HS = 1.0f;
        this.HU = 1.0f;
        this.HR = -9223372036854775807L;
        this.HJ = new long[10];
        this.HK = new long[10];
        this.HL = new long[10];
        this.IM = -9223372036854775807L;
        this.IN = -9223372036854775807L;
        dVar.by(0);
        dVar.rH.order(ByteOrder.nativeOrder());
        this.HZ = -1.0f;
        this.Ic = 0;
        this.Ix = 0;
        this.Ip = -1;
        this.Iq = -1;
        this.Io = -9223372036854775807L;
        this.ID = -9223372036854775807L;
        this.IE = -9223372036854775807L;
        this.Iy = 0;
        this.Iz = 0;
    }

    public void M(boolean z) {
        this.IJ = z;
    }

    public void N(boolean z) {
        this.bi = z;
    }

    public void O(boolean z) {
        this.bj = z;
    }

    @Override // com.applovin.exoplayer2.as
    public final int b(v vVar) throws p {
        try {
            return a(this.bg, vVar);
        } catch (l.b e) {
            throw a(e, vVar, 4002);
        }
    }

    protected final void jX() throws p {
        v vVar;
        if (this.HV != null || this.It || (vVar = this.lS) == null) {
            return;
        }
        if (this.HO == null && f(vVar)) {
            o(this.lS);
            return;
        }
        d(this.HO);
        String str = this.lS.dz;
        com.applovin.exoplayer2.d.f fVar = this.HN;
        if (fVar != null) {
            if (this.HP == null) {
                n nVarE = e(fVar);
                if (nVarE == null) {
                    if (this.HN.ht() == null) {
                        return;
                    }
                } else {
                    try {
                        this.HP = new MediaCrypto(nVarE.ey, nVarE.su);
                        this.HQ = !nVarE.tp && this.HP.requiresSecureDecoderComponent(str);
                    } catch (MediaCryptoException e) {
                        throw a(e, this.lS, 6006);
                    }
                }
            }
            if (n.to) {
                int iP = this.HN.P();
                if (iP == 1) {
                    com.applovin.exoplayer2.d.f.a aVar = (com.applovin.exoplayer2.d.f.a) com.applovin.exoplayer2.l.a.checkNotNull(this.HN.ht());
                    throw a(aVar, this.lS, aVar.errorCode);
                }
                if (iP != 4) {
                    return;
                }
            }
        }
        try {
            a(this.HP, this.HQ);
        } catch (a e2) {
            throw a(e2, this.lS, 4001);
        }
    }

    protected final void b(p pVar) {
        this.IK = pVar;
    }

    protected final void aL(long j) throws p {
        boolean z;
        v vVarBp = this.HG.bp(j);
        if (vVarBp == null && this.HY) {
            vVarBp = this.HG.pollFirst();
        }
        if (vVarBp != null) {
            this.HM = vVarBp;
            z = true;
        } else {
            z = false;
        }
        if (z || (this.HY && this.HM != null)) {
            a(this.HM, this.HX);
            this.HY = false;
        }
    }

    protected final g jZ() {
        return this.HV;
    }

    protected final MediaFormat ka() {
        return this.HX;
    }

    protected final i kb() {
        return this.Hk;
    }

    @Override // com.applovin.exoplayer2.e
    protected void a(boolean z, boolean z2) throws p {
        this.IL = new com.applovin.exoplayer2.c.e();
    }

    @Override // com.applovin.exoplayer2.e
    protected void a(v[] vVarArr, long j, long j2) throws p {
        if (this.IN == -9223372036854775807L) {
            com.applovin.exoplayer2.l.a.checkState(this.IM == -9223372036854775807L);
            this.IM = j;
            this.IN = j2;
            return;
        }
        int i = this.IO;
        if (i == this.HK.length) {
            q.h("MediaCodecRenderer", "Too many stream changes, so dropping offset: " + this.HK[this.IO - 1]);
        } else {
            this.IO = i + 1;
        }
        long[] jArr = this.HJ;
        int i2 = this.IO;
        jArr[i2 - 1] = j;
        this.HK[i2 - 1] = j2;
        this.HL[i2 - 1] = this.ID;
    }

    @Override // com.applovin.exoplayer2.e
    protected void a(long j, boolean z) throws p {
        this.IF = false;
        this.IG = false;
        this.II = false;
        if (this.It) {
            this.HF.clear();
            this.HE.clear();
            this.Iu = false;
        } else {
            ke();
        }
        if (this.HG.size() > 0) {
            this.IH = true;
        }
        this.HG.clear();
        int i = this.IO;
        if (i != 0) {
            this.IN = this.HK[i - 1];
            this.IM = this.HJ[i - 1];
            this.IO = 0;
        }
    }

    @Override // com.applovin.exoplayer2.ar
    public void a(float f, float f2) throws p {
        this.HS = f;
        this.HU = f2;
        p(this.HW);
    }

    @Override // com.applovin.exoplayer2.e
    protected void ac() {
        this.lS = null;
        this.IM = -9223372036854775807L;
        this.IN = -9223372036854775807L;
        this.IO = 0;
        kf();
    }

    @Override // com.applovin.exoplayer2.e
    protected void ad() {
        try {
            kc();
            kd();
        } finally {
            c((com.applovin.exoplayer2.d.f) null);
        }
    }

    private void kc() {
        this.Iv = false;
        this.HF.clear();
        this.HE.clear();
        this.Iu = false;
        this.It = false;
    }

    protected void kd() {
        try {
            g gVar = this.HV;
            if (gVar != null) {
                gVar.release();
                this.IL.rw++;
                v(this.Hk.name);
            }
            this.HV = null;
            try {
                MediaCrypto mediaCrypto = this.HP;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
                this.HP = null;
                d((com.applovin.exoplayer2.d.f) null);
                ki();
            }
        } catch (Throwable th) {
            this.HV = null;
            try {
                MediaCrypto mediaCrypto2 = this.HP;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
                this.HP = null;
                d((com.applovin.exoplayer2.d.f) null);
                ki();
            }
        }
    }

    @Override // com.applovin.exoplayer2.ar
    public void g(long j, long j2) throws p {
        boolean z = false;
        if (this.II) {
            this.II = false;
            ks();
        }
        p pVar = this.IK;
        if (pVar != null) {
            this.IK = null;
            throw pVar;
        }
        try {
            if (this.IG) {
                eC();
                return;
            }
            if (this.lS != null || cU(2)) {
                jX();
                if (this.It) {
                    ah.bg("bypassRender");
                    while (u(j, j2)) {
                    }
                    ah.pV();
                } else if (this.HV != null) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    ah.bg("drainAndFeed");
                    while (t(j, j2) && aM(jElapsedRealtime)) {
                    }
                    while (km() && aM(jElapsedRealtime)) {
                    }
                    ah.pV();
                } else {
                    this.IL.ry += e(j);
                    cU(1);
                }
                this.IL.he();
            }
        } catch (IllegalStateException e) {
            if (b(e)) {
                i(e);
                if (ai.acV >= 21 && d(e)) {
                    z = true;
                }
                if (z) {
                    kd();
                }
                throw a(a(e, kb()), this.lS, z, 4003);
            }
            throw e;
        }
    }

    protected final boolean ke() throws p {
        boolean zKf = kf();
        if (zKf) {
            jX();
        }
        return zKf;
    }

    protected boolean kf() {
        if (this.HV == null) {
            return false;
        }
        if (this.Iz == 3 || this.Ie || ((this.If && !this.IC) || (this.Ig && this.IB))) {
            kd();
            return true;
        }
        kg();
        return false;
    }

    private void kg() {
        try {
            this.HV.dI();
        } finally {
            kh();
        }
    }

    protected void kh() {
        kk();
        kl();
        this.Io = -9223372036854775807L;
        this.IB = false;
        this.IA = false;
        this.Ik = false;
        this.Il = false;
        this.Ir = false;
        this.Is = false;
        this.HH.clear();
        this.ID = -9223372036854775807L;
        this.IE = -9223372036854775807L;
        e eVar = this.In;
        if (eVar != null) {
            eVar.Y();
        }
        this.Iy = 0;
        this.Iz = 0;
        this.Ix = this.Iw ? 1 : 0;
    }

    protected void ki() {
        kh();
        this.IK = null;
        this.In = null;
        this.Ia = null;
        this.Hk = null;
        this.HW = null;
        this.HX = null;
        this.HY = false;
        this.IC = false;
        this.HZ = -1.0f;
        this.Ic = 0;
        this.Id = false;
        this.Ie = false;
        this.If = false;
        this.Ig = false;
        this.Ih = false;
        this.Ii = false;
        this.Ij = false;
        this.Im = false;
        this.Iw = false;
        this.Ix = 0;
        this.HQ = false;
    }

    protected h a(Throwable th, i iVar) {
        return new h(th, iVar);
    }

    private boolean cU(int i) throws p {
        w wVarAe = ae();
        this.HC.clear();
        int iA = a(wVarAe, this.HC, i | 4);
        if (iA == -5) {
            a(wVarAe);
            return true;
        }
        if (iA != -4 || !this.HC.gY()) {
            return false;
        }
        this.IF = true;
        ks();
        return false;
    }

    private void a(MediaCrypto mediaCrypto, boolean z) throws a {
        if (this.Ia == null) {
            try {
                List<i> listP = P(z);
                ArrayDeque<i> arrayDeque = new ArrayDeque<>();
                this.Ia = arrayDeque;
                if (this.bf) {
                    arrayDeque.addAll(listP);
                } else if (!listP.isEmpty()) {
                    this.Ia.add(listP.get(0));
                }
                this.Ib = null;
            } catch (l.b e) {
                throw new a(this.lS, e, z, -49998);
            }
        }
        if (this.Ia.isEmpty()) {
            throw new a(this.lS, (Throwable) null, z, -49999);
        }
        while (this.HV == null) {
            i iVarPeekFirst = this.Ia.peekFirst();
            if (!a(iVarPeekFirst)) {
                return;
            }
            try {
                a(iVarPeekFirst, mediaCrypto);
            } catch (Exception e2) {
                q.b("MediaCodecRenderer", "Failed to initialize decoder: " + iVarPeekFirst, e2);
                this.Ia.removeFirst();
                a aVar = new a(this.lS, e2, z, iVarPeekFirst);
                i(aVar);
                if (this.Ib != null) {
                    this.Ib = this.Ib.a(aVar);
                } else {
                    this.Ib = aVar;
                }
                if (this.Ia.isEmpty()) {
                    throw this.Ib;
                }
            }
        }
        this.Ia = null;
    }

    private List<i> P(boolean z) throws l.b {
        List<i> listA = a(this.bg, this.lS, z);
        if (listA.isEmpty() && z) {
            listA = a(this.bg, this.lS, false);
            if (!listA.isEmpty()) {
                q.h("MediaCodecRenderer", "Drm session requires secure decoder for " + this.lS.dz + ", but no secure decoder available. Trying to proceed with " + listA + ".");
            }
        }
        return listA;
    }

    private void o(v vVar) {
        kc();
        String str = vVar.dz;
        if (!"audio/mp4a-latm".equals(str) && !"audio/mpeg".equals(str) && !"audio/opus".equals(str)) {
            this.HF.cQ(1);
        } else {
            this.HF.cQ(32);
        }
        this.It = true;
    }

    private void a(i iVar, MediaCrypto mediaCrypto) throws Exception {
        g gVarB;
        String str = iVar.name;
        float fA = ai.acV < 23 ? -1.0f : a(this.HU, this.lS, af());
        float f = fA > this.HB ? fA : -1.0f;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        ah.bg("createCodec:" + str);
        g.a aVarA = a(iVar, this.lS, mediaCrypto, f);
        if (this.IJ && ai.acV >= 23) {
            gVarB = new com.applovin.exoplayer2.f.a.C0094a(M(), this.bi, this.bj).b(aVarA);
        } else {
            gVarB = this.HA.b(aVarA);
        }
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        this.HV = gVarB;
        this.Hk = iVar;
        this.HZ = f;
        this.HW = this.lS;
        this.Ic = R(str);
        this.Id = a(str, this.HW);
        this.Ie = Q(str);
        this.If = S(str);
        this.Ig = T(str);
        this.Ih = V(str);
        this.Ii = U(str);
        this.Ij = b(str, this.HW);
        this.Im = b(iVar) || jY();
        if (gVarB.jC()) {
            this.Iw = true;
            this.Ix = 1;
            this.Ik = this.Ic != 0;
        }
        if ("c2.android.mp3.decoder".equals(iVar.name)) {
            this.In = new e();
        }
        if (P() == 2) {
            this.Io = SystemClock.elapsedRealtime() + 1000;
        }
        this.IL.rv++;
        e(str, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
    }

    private boolean aM(long j) {
        return this.HR == -9223372036854775807L || SystemClock.elapsedRealtime() - j < this.HR;
    }

    private boolean kj() {
        return this.Iq >= 0;
    }

    private void kk() {
        this.Ip = -1;
        this.HD.rH = null;
    }

    private void kl() {
        this.Iq = -1;
        this.kT = null;
    }

    private void c(com.applovin.exoplayer2.d.f fVar) {
        com.applovin.exoplayer2.d.f.a(this.HO, fVar);
        this.HO = fVar;
    }

    private void d(com.applovin.exoplayer2.d.f fVar) {
        com.applovin.exoplayer2.d.f.a(this.HN, fVar);
        this.HN = fVar;
    }

    private boolean km() throws p {
        g gVar = this.HV;
        if (gVar == null || this.Iy == 2 || this.IF) {
            return false;
        }
        if (this.Ip < 0) {
            int iJD = gVar.jD();
            this.Ip = iJD;
            if (iJD < 0) {
                return false;
            }
            this.HD.rH = this.HV.cH(iJD);
            this.HD.clear();
        }
        if (this.Iy == 1) {
            if (!this.Im) {
                this.IB = true;
                this.HV.a(this.Ip, 0, 0, 0L, 4);
                kk();
            }
            this.Iy = 2;
            return false;
        }
        if (this.Ik) {
            this.Ik = false;
            ByteBuffer byteBuffer = this.HD.rH;
            byte[] bArr = Hz;
            byteBuffer.put(bArr);
            this.HV.a(this.Ip, 0, bArr.length, 0L, 0);
            kk();
            this.IA = true;
            return true;
        }
        if (this.Ix == 1) {
            for (int i = 0; i < this.HW.dB.size(); i++) {
                this.HD.rH.put(this.HW.dB.get(i));
            }
            this.Ix = 2;
        }
        int iPosition = this.HD.rH.position();
        w wVarAe = ae();
        try {
            int iA = a(wVarAe, this.HD, 0);
            if (R()) {
                this.IE = this.ID;
            }
            if (iA == -3) {
                return false;
            }
            if (iA == -5) {
                if (this.Ix == 2) {
                    this.HD.clear();
                    this.Ix = 1;
                }
                a(wVarAe);
                return true;
            }
            if (this.HD.gY()) {
                if (this.Ix == 2) {
                    this.HD.clear();
                    this.Ix = 1;
                }
                this.IF = true;
                if (!this.IA) {
                    ks();
                    return false;
                }
                try {
                    if (!this.Im) {
                        this.IB = true;
                        this.HV.a(this.Ip, 0, 0, 0L, 4);
                        kk();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e) {
                    throw a(e, this.lS, com.applovin.exoplayer2.h.r(e.getErrorCode()));
                }
            }
            if (!this.IA && !this.HD.gZ()) {
                this.HD.clear();
                if (this.Ix == 2) {
                    this.Ix = 1;
                }
                return true;
            }
            boolean zHg = this.HD.hg();
            if (zHg) {
                this.HD.rG.bw(iPosition);
            }
            if (this.Id && !zHg) {
                com.applovin.exoplayer2.l.v.m(this.HD.rH);
                if (this.HD.rH.position() == 0) {
                    return true;
                }
                this.Id = false;
            }
            long jA = this.HD.rJ;
            e eVar = this.In;
            if (eVar != null) {
                jA = eVar.a(this.lS, this.HD);
                this.ID = Math.max(this.ID, this.In.k(this.lS));
            }
            long j = jA;
            if (this.HD.gX()) {
                this.HH.add(Long.valueOf(j));
            }
            if (this.IH) {
                this.HG.a(j, this.lS);
                this.IH = false;
            }
            this.ID = Math.max(this.ID, j);
            this.HD.hh();
            if (this.HD.ha()) {
                f(this.HD);
            }
            a(this.HD);
            try {
                if (zHg) {
                    this.HV.a(this.Ip, 0, this.HD.rG, j, 0);
                } else {
                    this.HV.a(this.Ip, 0, this.HD.rH.limit(), j, 0);
                }
                kk();
                this.IA = true;
                this.Ix = 0;
                this.IL.rx++;
                return true;
            } catch (MediaCodec.CryptoException e2) {
                throw a(e2, this.lS, com.applovin.exoplayer2.h.r(e2.getErrorCode()));
            }
        } catch (com.applovin.exoplayer2.c.g.a e3) {
            i(e3);
            cU(0);
            kg();
            return true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ce  */
    protected com.applovin.exoplayer2.c.h a(w wVar) throws p {
        int i;
        boolean z = true;
        this.IH = true;
        v vVar = (v) com.applovin.exoplayer2.l.a.checkNotNull(wVar.dU);
        if (vVar.dz == null) {
            throw a(new IllegalArgumentException(), vVar, 4005);
        }
        c(wVar.dT);
        this.lS = vVar;
        if (this.It) {
            this.Iv = true;
            return null;
        }
        g gVar = this.HV;
        if (gVar == null) {
            this.Ia = null;
            jX();
            return null;
        }
        i iVar = this.Hk;
        v vVar2 = this.HW;
        if (a(iVar, vVar, this.HN, this.HO)) {
            kq();
            return new com.applovin.exoplayer2.c.h(iVar.name, vVar2, vVar, 0, 128);
        }
        boolean z2 = this.HO != this.HN;
        com.applovin.exoplayer2.l.a.checkState(!z2 || ai.acV >= 23);
        com.applovin.exoplayer2.c.h hVarA = a(iVar, vVar2, vVar);
        int i2 = hVarA.pZ;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        if (p(vVar)) {
                            this.HW = vVar;
                            if (z2 && !kp()) {
                                i = 2;
                            }
                        } else {
                            i = 16;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (p(vVar)) {
                    this.Iw = true;
                    this.Ix = 1;
                    int i3 = this.Ic;
                    if (i3 != 2 && (i3 != 1 || vVar.dE != vVar2.dE || vVar.height != vVar2.height)) {
                        z = false;
                    }
                    this.Ik = z;
                    this.HW = vVar;
                    if (z2 && !kp()) {
                        i = 2;
                    }
                } else {
                    i = 16;
                }
            } else if (p(vVar)) {
                this.HW = vVar;
                if (!z2 ? !ko() : !kp()) {
                    i = 2;
                }
            } else {
                i = 16;
            }
            return (hVarA.pZ != 0 || (this.HV == gVar && this.Iz != 3)) ? hVarA : new com.applovin.exoplayer2.c.h(iVar.name, vVar2, vVar, 0, i);
        }
        kq();
        i = 0;
        if (hVarA.pZ != 0) {
        }
    }

    protected void aN(long j) {
        while (true) {
            int i = this.IO;
            if (i == 0 || j < this.HL[0]) {
                return;
            }
            long[] jArr = this.HJ;
            this.IM = jArr[0];
            this.IN = this.HK[0];
            int i2 = i - 1;
            this.IO = i2;
            System.arraycopy(jArr, 1, jArr, 0, i2);
            long[] jArr2 = this.HK;
            System.arraycopy(jArr2, 1, jArr2, 0, this.IO);
            long[] jArr3 = this.HL;
            System.arraycopy(jArr3, 1, jArr3, 0, this.IO);
            eB();
        }
    }

    protected com.applovin.exoplayer2.c.h a(i iVar, v vVar, v vVar2) {
        return new com.applovin.exoplayer2.c.h(iVar.name, vVar, vVar2, 0, 1);
    }

    @Override // com.applovin.exoplayer2.ar
    public boolean cR() {
        return this.IG;
    }

    @Override // com.applovin.exoplayer2.ar
    public boolean isReady() {
        return this.lS != null && (ai() || kj() || (this.Io != -9223372036854775807L && SystemClock.elapsedRealtime() < this.Io));
    }

    protected float kn() {
        return this.HS;
    }

    private boolean p(v vVar) throws p {
        if (ai.acV >= 23 && this.HV != null && this.Iz != 3 && P() != 0) {
            float fA = a(this.HU, vVar, af());
            float f = this.HZ;
            if (f == fA) {
                return true;
            }
            if (fA == -1.0f) {
                kq();
                return false;
            }
            if (f == -1.0f && fA <= this.HB) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", fA);
            this.HV.u(bundle);
            this.HZ = fA;
        }
        return true;
    }

    private boolean ko() {
        if (this.IA) {
            this.Iy = 1;
            if (this.Ie || this.Ig) {
                this.Iz = 3;
                return false;
            }
            this.Iz = 1;
        }
        return true;
    }

    private boolean kp() throws p {
        if (this.IA) {
            this.Iy = 1;
            if (this.Ie || this.Ig) {
                this.Iz = 3;
                return false;
            }
            this.Iz = 2;
        } else {
            kw();
        }
        return true;
    }

    private void kq() throws p {
        if (this.IA) {
            this.Iy = 1;
            this.Iz = 3;
        } else {
            kv();
        }
    }

    private boolean t(long j, long j2) throws p {
        boolean z;
        boolean zA;
        int iA;
        if (!kj()) {
            if (this.Ih && this.IB) {
                try {
                    iA = this.HV.a(this.HI);
                } catch (IllegalStateException unused) {
                    ks();
                    if (this.IG) {
                        kd();
                    }
                    return false;
                }
            } else {
                iA = this.HV.a(this.HI);
            }
            if (iA < 0) {
                if (iA == -2) {
                    kr();
                    return true;
                }
                if (this.Im && (this.IF || this.Iy == 2)) {
                    ks();
                }
                return false;
            }
            if (this.Il) {
                this.Il = false;
                this.HV.l(iA, false);
                return true;
            }
            if (this.HI.size == 0 && (this.HI.flags & 4) != 0) {
                ks();
                return false;
            }
            this.Iq = iA;
            ByteBuffer byteBufferCI = this.HV.cI(iA);
            this.kT = byteBufferCI;
            if (byteBufferCI != null) {
                byteBufferCI.position(this.HI.offset);
                this.kT.limit(this.HI.offset + this.HI.size);
            }
            if (this.Ii && this.HI.presentationTimeUs == 0 && (this.HI.flags & 4) != 0) {
                long j3 = this.ID;
                if (j3 != -9223372036854775807L) {
                    this.HI.presentationTimeUs = j3;
                }
            }
            this.Ir = aO(this.HI.presentationTimeUs);
            this.Is = this.IE == this.HI.presentationTimeUs;
            aL(this.HI.presentationTimeUs);
        }
        if (this.Ih && this.IB) {
            try {
                z = false;
                try {
                    zA = a(j, j2, this.HV, this.kT, this.Iq, this.HI.flags, 1, this.HI.presentationTimeUs, this.Ir, this.Is, this.HM);
                } catch (IllegalStateException unused2) {
                    ks();
                    if (this.IG) {
                        kd();
                    }
                    return z;
                }
            } catch (IllegalStateException unused3) {
                z = false;
            }
        } else {
            z = false;
            zA = a(j, j2, this.HV, this.kT, this.Iq, this.HI.flags, 1, this.HI.presentationTimeUs, this.Ir, this.Is, this.HM);
        }
        if (zA) {
            aN(this.HI.presentationTimeUs);
            boolean z2 = (this.HI.flags & 4) != 0 ? true : z;
            kl();
            if (!z2) {
                return true;
            }
            ks();
        }
        return z;
    }

    private void kr() {
        this.IC = true;
        MediaFormat mediaFormatJE = this.HV.jE();
        if (this.Ic != 0 && mediaFormatJE.getInteger("width") == 32 && mediaFormatJE.getInteger("height") == 32) {
            this.Il = true;
            return;
        }
        if (this.Ij) {
            mediaFormatJE.setInteger("channel-count", 1);
        }
        this.HX = mediaFormatJE;
        this.HY = true;
    }

    private void ks() throws p {
        int i = this.Iz;
        if (i == 1) {
            kg();
            return;
        }
        if (i == 2) {
            kg();
            kw();
        } else if (i == 3) {
            kv();
        } else {
            this.IG = true;
            eC();
        }
    }

    protected final void kt() {
        this.II = true;
    }

    protected final long ku() {
        return this.IN;
    }

    protected static boolean q(v vVar) {
        return vVar.dR == 0 || vVar.dR == 2;
    }

    private boolean a(i iVar, v vVar, com.applovin.exoplayer2.d.f fVar, com.applovin.exoplayer2.d.f fVar2) throws p {
        n nVarE;
        if (fVar == fVar2) {
            return false;
        }
        if (fVar2 == null || fVar == null || ai.acV < 23 || com.applovin.exoplayer2.h.an.equals(fVar.hu()) || com.applovin.exoplayer2.h.an.equals(fVar2.hu()) || (nVarE = e(fVar2)) == null) {
            return true;
        }
        return !iVar.Hu && (nVarE.tp ? false : fVar2.A(vVar.dz));
    }

    private void kv() throws p {
        kd();
        jX();
    }

    private boolean aO(long j) {
        int size = this.HH.size();
        for (int i = 0; i < size; i++) {
            if (this.HH.get(i).longValue() == j) {
                this.HH.remove(i);
                return true;
            }
        }
        return false;
    }

    private void kw() throws p {
        try {
            this.HP.setMediaDrmSession(e(this.HO).su);
            d(this.HO);
            this.Iy = 0;
            this.Iz = 0;
        } catch (MediaCryptoException e) {
            throw a(e, this.lS, 6006);
        }
    }

    private n e(com.applovin.exoplayer2.d.f fVar) throws p {
        com.applovin.exoplayer2.c.b bVarHv = fVar.hv();
        if (bVarHv != null && !(bVarHv instanceof n)) {
            throw a(new IllegalArgumentException("Expecting FrameworkCryptoConfig but found: " + bVarHv), this.lS, 6001);
        }
        return (n) bVarHv;
    }

    private boolean u(long j, long j2) throws p {
        boolean z;
        com.applovin.exoplayer2.l.a.checkState(!this.IG);
        if (!this.HF.jS()) {
            z = false;
        } else {
            if (!a(j, j2, null, this.HF.rH, this.Iq, 0, this.HF.iI(), this.HF.jQ(), this.HF.gX(), this.HF.gY(), this.HM)) {
                return false;
            }
            aN(this.HF.jR());
            this.HF.clear();
            z = false;
        }
        if (this.IF) {
            this.IG = true;
            return z;
        }
        if (this.Iu) {
            com.applovin.exoplayer2.l.a.checkState(this.HF.d(this.HE));
            this.Iu = z;
        }
        if (this.Iv) {
            if (this.HF.jS()) {
                return true;
            }
            kc();
            this.Iv = z;
            jX();
            if (!this.It) {
                return z;
            }
        }
        kx();
        if (this.HF.jS()) {
            this.HF.hh();
        }
        if (this.HF.jS() || this.IF || this.Iv) {
            return true;
        }
        return z;
    }

    private void kx() throws p {
        com.applovin.exoplayer2.l.a.checkState(!this.IF);
        w wVarAe = ae();
        this.HE.clear();
        do {
            this.HE.clear();
            int iA = a(wVarAe, this.HE, 0);
            if (iA == -5) {
                a(wVarAe);
                return;
            }
            if (iA != -4) {
                if (iA != -3) {
                    throw new IllegalStateException();
                }
                return;
            } else {
                if (this.HE.gY()) {
                    this.IF = true;
                    return;
                }
                if (this.IH) {
                    v vVar = (v) com.applovin.exoplayer2.l.a.checkNotNull(this.lS);
                    this.HM = vVar;
                    a(vVar, (MediaFormat) null);
                    this.IH = false;
                }
                this.HE.hh();
            }
        } while (this.HF.d(this.HE));
        this.Iu = true;
    }

    private static boolean b(IllegalStateException illegalStateException) {
        if (ai.acV >= 21 && c(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    private static boolean c(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    private static boolean d(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) illegalStateException).isRecoverable();
        }
        return false;
    }

    private static boolean Q(String str) {
        return ai.acV < 18 || (ai.acV == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (ai.acV == 19 && ai.acY.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private int R(String str) {
        if (ai.acV <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (ai.acY.startsWith("SM-T585") || ai.acY.startsWith("SM-A510") || ai.acY.startsWith("SM-A520") || ai.acY.startsWith("SM-J700"))) {
            return 2;
        }
        if (ai.acV >= 24) {
            return 0;
        }
        if ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) {
            return ("flounder".equals(ai.acW) || "flounder_lte".equals(ai.acW) || "grouper".equals(ai.acW) || "tilapia".equals(ai.acW)) ? 1 : 0;
        }
        return 0;
    }

    private static boolean a(String str, v vVar) {
        return ai.acV < 21 && vVar.dB.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean S(String str) {
        return ai.acV == 29 && "c2.android.aac.decoder".equals(str);
    }

    private static boolean b(i iVar) {
        String str = iVar.name;
        return (ai.acV <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (ai.acV <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ((ai.acV <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str))) || ("Amazon".equals(ai.acX) && "AFTS".equals(ai.acY) && iVar.Hu));
    }

    private static boolean T(String str) {
        return (ai.acV <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (ai.acV <= 19 && (("hb2000".equals(ai.acW) || "stvm8".equals(ai.acW)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))));
    }

    private static boolean U(String str) {
        return ai.acV < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(ai.acX) && (ai.acW.startsWith("baffin") || ai.acW.startsWith("grand") || ai.acW.startsWith("fortuna") || ai.acW.startsWith("gprimelte") || ai.acW.startsWith("j2y18lte") || ai.acW.startsWith("ms01"));
    }

    private static boolean V(String str) {
        return ai.acV == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean b(String str, v vVar) {
        return ai.acV <= 18 && vVar.dL == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }
}
