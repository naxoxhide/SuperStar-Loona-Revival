package com.applovin.exoplayer2.m;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.applovin.exoplayer2.as;
import com.applovin.exoplayer2.l.ah;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.t;
import com.applovin.exoplayer2.l.u;
import com.applovin.exoplayer2.p;
import com.applovin.exoplayer2.v;
import com.applovin.exoplayer2.w;
import com.google.android.gms.common.Scopes;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h extends com.applovin.exoplayer2.f.j {
    private static final int[] adL = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean adM;
    private static boolean adN;
    private final Context E;
    private Surface Hm;
    private final m adO;
    private final n.a adP;
    private final long adQ;
    private final int adR;
    private final boolean adS;
    private a adT;
    private boolean adU;
    private boolean adV;
    private d adW;
    private boolean adX;
    private int adY;
    private boolean adZ;
    private boolean aea;
    private boolean aeb;
    private long aec;
    private long aed;
    private long aee;
    private int aef;
    private int aeg;
    private int aeh;
    private long aei;
    private long aej;
    private int aek;
    private int ael;
    private int aem;
    private float aen;
    private o aeo;
    private int aep;
    b aeq;
    private l aer;
    private boolean hi;
    private long rE;
    private int rF;

    private static boolean bA(long j) {
        return j < -30000;
    }

    private static boolean bB(long j) {
        return j < -500000;
    }

    @Override // com.applovin.exoplayer2.ar, com.applovin.exoplayer2.as
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    public h(Context context, com.applovin.exoplayer2.f.k kVar, long j, boolean z, Handler handler, n nVar, int i) {
        this(context, com.applovin.exoplayer2.f.g.b.Hp, kVar, j, z, handler, nVar, i);
    }

    public h(Context context, com.applovin.exoplayer2.f.g.b bVar, com.applovin.exoplayer2.f.k kVar, long j, boolean z, Handler handler, n nVar, int i) {
        super(2, bVar, kVar, z, 30.0f);
        this.adQ = j;
        this.adR = i;
        Context applicationContext = context.getApplicationContext();
        this.E = applicationContext;
        this.adO = new m(applicationContext);
        this.adP = new n.a(handler, nVar);
        this.adS = qt();
        this.aed = -9223372036854775807L;
        this.aek = -1;
        this.ael = -1;
        this.aen = -1.0f;
        this.adY = 1;
        this.aep = 0;
        qo();
    }

    @Override // com.applovin.exoplayer2.f.j
    protected int a(com.applovin.exoplayer2.f.k kVar, v vVar) throws com.applovin.exoplayer2.f.l.b {
        int i = 0;
        if (!u.aX(vVar.dz)) {
            return as.ae(0);
        }
        boolean z = vVar.dC != null;
        List<com.applovin.exoplayer2.f.i> listA = a(kVar, vVar, z, false);
        if (z && listA.isEmpty()) {
            listA = a(kVar, vVar, false, false);
        }
        if (listA.isEmpty()) {
            return as.ae(1);
        }
        if (!q(vVar)) {
            return as.ae(2);
        }
        com.applovin.exoplayer2.f.i iVar = listA.get(0);
        boolean zL = iVar.l(vVar);
        int i2 = iVar.n(vVar) ? 16 : 8;
        if (zL) {
            List<com.applovin.exoplayer2.f.i> listA2 = a(kVar, vVar, z, true);
            if (!listA2.isEmpty()) {
                com.applovin.exoplayer2.f.i iVar2 = listA2.get(0);
                if (iVar2.l(vVar) && iVar2.n(vVar)) {
                    i = 32;
                }
            }
        }
        return as.a(zL ? 4 : 3, i2, i);
    }

    @Override // com.applovin.exoplayer2.f.j
    protected List<com.applovin.exoplayer2.f.i> a(com.applovin.exoplayer2.f.k kVar, v vVar, boolean z) throws com.applovin.exoplayer2.f.l.b {
        return a(kVar, vVar, z, this.hi);
    }

    private static List<com.applovin.exoplayer2.f.i> a(com.applovin.exoplayer2.f.k kVar, v vVar, boolean z, boolean z2) throws com.applovin.exoplayer2.f.l.b {
        Pair<Integer, Integer> pairR;
        String str = vVar.dz;
        if (str == null) {
            return Collections.emptyList();
        }
        List<com.applovin.exoplayer2.f.i> listA = com.applovin.exoplayer2.f.l.a(kVar.getDecoderInfos(str, z, z2), vVar);
        if ("video/dolby-vision".equals(str) && (pairR = com.applovin.exoplayer2.f.l.r(vVar)) != null) {
            int iIntValue = ((Integer) pairR.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                listA.addAll(kVar.getDecoderInfos("video/hevc", z, z2));
            } else if (iIntValue == 512) {
                listA.addAll(kVar.getDecoderInfos("video/avc", z, z2));
            }
        }
        return Collections.unmodifiableList(listA);
    }

    @Override // com.applovin.exoplayer2.f.j, com.applovin.exoplayer2.e
    protected void a(boolean z, boolean z2) throws p {
        super.a(z, z2);
        boolean z3 = ag().hi;
        com.applovin.exoplayer2.l.a.checkState((z3 && this.aep == 0) ? false : true);
        if (this.hi != z3) {
            this.hi = z3;
            kd();
        }
        this.adP.e(this.IL);
        this.adO.qw();
        this.aea = z2;
        this.aeb = false;
    }

    @Override // com.applovin.exoplayer2.f.j, com.applovin.exoplayer2.e
    protected void a(long j, boolean z) throws p {
        super.a(j, z);
        ql();
        this.adO.qx();
        this.aei = -9223372036854775807L;
        this.aec = -9223372036854775807L;
        this.aeg = 0;
        if (z) {
            qk();
        } else {
            this.aed = -9223372036854775807L;
        }
    }

    @Override // com.applovin.exoplayer2.f.j, com.applovin.exoplayer2.ar
    public boolean isReady() {
        d dVar;
        if (super.isReady() && (this.adZ || (((dVar = this.adW) != null && this.Hm == dVar) || jZ() == null || this.hi))) {
            this.aed = -9223372036854775807L;
            return true;
        }
        if (this.aed == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.aed) {
            return true;
        }
        this.aed = -9223372036854775807L;
        return false;
    }

    @Override // com.applovin.exoplayer2.f.j, com.applovin.exoplayer2.e
    protected void aa() {
        super.aa();
        this.aef = 0;
        this.aee = SystemClock.elapsedRealtime();
        this.aej = SystemClock.elapsedRealtime() * 1000;
        this.rE = 0L;
        this.rF = 0;
        this.adO.aa();
    }

    @Override // com.applovin.exoplayer2.f.j, com.applovin.exoplayer2.e
    protected void ab() {
        this.aed = -9223372036854775807L;
        qr();
        qs();
        this.adO.ab();
        super.ab();
    }

    @Override // com.applovin.exoplayer2.f.j, com.applovin.exoplayer2.e
    protected void ac() {
        qo();
        ql();
        this.adX = false;
        this.adO.ac();
        this.aeq = null;
        try {
            super.ac();
        } finally {
            this.adP.f(this.IL);
        }
    }

    @Override // com.applovin.exoplayer2.f.j, com.applovin.exoplayer2.e
    protected void ad() {
        d dVar;
        try {
            super.ad();
            dVar = this.adW;
            if (dVar != null) {
                if (this.Hm == dVar) {
                    this.Hm = null;
                }
            }
        } finally {
            if (this.adW != null) {
                Surface surface = this.Hm;
                dVar = this.adW;
                if (surface == dVar) {
                    this.Hm = null;
                }
                dVar.release();
                this.adW = null;
            }
        }
    }

    @Override // com.applovin.exoplayer2.e, com.applovin.exoplayer2.ao.b
    public void a(int i, Object obj) throws p {
        if (i == 1) {
            S(obj);
            return;
        }
        if (i == 7) {
            this.aer = (l) obj;
            return;
        }
        if (i == 10) {
            int iIntValue = ((Integer) obj).intValue();
            if (this.aep != iIntValue) {
                this.aep = iIntValue;
                if (this.hi) {
                    kd();
                    return;
                }
                return;
            }
            return;
        }
        if (i != 4) {
            if (i == 5) {
                this.adO.fS(((Integer) obj).intValue());
                return;
            } else {
                super.a(i, obj);
                return;
            }
        }
        this.adY = ((Integer) obj).intValue();
        com.applovin.exoplayer2.f.g gVarJZ = jZ();
        if (gVarJZ != null) {
            gVarJZ.cJ(this.adY);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.applovin.exoplayer2.m.m] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.applovin.exoplayer2.m.h] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.view.Surface] */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.applovin.exoplayer2.m.d] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void S(Object obj) throws p {
        ?? C;
        Surface surface;
        if (obj instanceof Surface) {
            surface = (Surface) obj;
        } else {
            C = 0;
        }
        if (C == 0) {
            d dVar = this.adW;
            if (dVar != null) {
                C = surface;
                C = dVar;
            } else {
                com.applovin.exoplayer2.f.i iVarKb = kb();
                if (iVarKb != null && e(iVarKb)) {
                    C = surface;
                    C = d.c(this.E, iVarKb.Hu);
                    this.adW = C;
                }
            }
        }
        C = surface;
        C = surface;
        C = surface;
        if (this.Hm != C) {
            this.Hm = C;
            this.adO.c(C);
            this.adX = false;
            int iP = P();
            com.applovin.exoplayer2.f.g gVarJZ = jZ();
            if (gVarJZ != null) {
                if (ai.acV >= 23 && C != 0 && !this.adU) {
                    a(gVarJZ, C);
                } else {
                    kd();
                    jX();
                }
            }
            if (C != 0 && C != this.adW) {
                qq();
                ql();
                if (iP == 2) {
                    qk();
                    return;
                }
                return;
            }
            qo();
            ql();
            return;
        }
        if (C == 0 || C == this.adW) {
            return;
        }
        qq();
        qn();
    }

    @Override // com.applovin.exoplayer2.f.j
    protected boolean a(com.applovin.exoplayer2.f.i iVar) {
        return this.Hm != null || e(iVar);
    }

    @Override // com.applovin.exoplayer2.f.j
    protected boolean jY() {
        return this.hi && ai.acV < 23;
    }

    @Override // com.applovin.exoplayer2.f.j
    protected com.applovin.exoplayer2.f.g.a a(com.applovin.exoplayer2.f.i iVar, v vVar, MediaCrypto mediaCrypto, float f) {
        d dVar = this.adW;
        if (dVar != null && dVar.Hu != iVar.Hu) {
            this.adW.release();
            this.adW = null;
        }
        String str = iVar.Hr;
        a aVarB = b(iVar, vVar, af());
        this.adT = aVarB;
        MediaFormat mediaFormatA = a(vVar, str, aVarB, f, this.adS, this.hi ? this.aep : 0);
        if (this.Hm == null) {
            if (!e(iVar)) {
                throw new IllegalStateException();
            }
            if (this.adW == null) {
                this.adW = d.c(this.E, iVar.Hu);
            }
            this.Hm = this.adW;
        }
        return com.applovin.exoplayer2.f.g.a.a(iVar, mediaFormatA, vVar, this.Hm, mediaCrypto);
    }

    @Override // com.applovin.exoplayer2.f.j
    protected com.applovin.exoplayer2.c.h a(com.applovin.exoplayer2.f.i iVar, v vVar, v vVar2) {
        com.applovin.exoplayer2.c.h hVarA = iVar.a(vVar, vVar2);
        int i = hVarA.rR;
        if (vVar2.dE > this.adT.dE || vVar2.height > this.adT.height) {
            i |= 256;
        }
        if (c(iVar, vVar2) > this.adT.aes) {
            i |= 64;
        }
        int i2 = i;
        return new com.applovin.exoplayer2.c.h(iVar.name, vVar, vVar2, i2 != 0 ? 0 : hVarA.pZ, i2);
    }

    @Override // com.applovin.exoplayer2.f.j
    protected void kh() {
        super.kh();
        this.aeh = 0;
    }

    @Override // com.applovin.exoplayer2.f.j, com.applovin.exoplayer2.ar
    public void a(float f, float f2) throws p {
        super.a(f, f2);
        this.adO.v(f);
    }

    @Override // com.applovin.exoplayer2.f.j
    protected float a(float f, v vVar, v[] vVarArr) {
        float fMax = -1.0f;
        for (v vVar2 : vVarArr) {
            float f2 = vVar2.dF;
            if (f2 != -1.0f) {
                fMax = Math.max(fMax, f2);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f;
    }

    @Override // com.applovin.exoplayer2.f.j
    protected void e(String str, long j, long j2) {
        this.adP.c(str, j, j2);
        this.adU = bo(str);
        this.adV = ((com.applovin.exoplayer2.f.i) com.applovin.exoplayer2.l.a.checkNotNull(kb())).jW();
        if (ai.acV < 23 || !this.hi) {
            return;
        }
        this.aeq = new b((com.applovin.exoplayer2.f.g) com.applovin.exoplayer2.l.a.checkNotNull(jZ()));
    }

    @Override // com.applovin.exoplayer2.f.j
    protected void v(String str) {
        this.adP.t(str);
    }

    @Override // com.applovin.exoplayer2.f.j
    protected void i(Exception exc) {
        q.c("MediaCodecVideoRenderer", "Video codec error", exc);
        this.adP.k(exc);
    }

    @Override // com.applovin.exoplayer2.f.j
    protected com.applovin.exoplayer2.c.h a(w wVar) throws p {
        com.applovin.exoplayer2.c.h hVarA = super.a(wVar);
        this.adP.c(wVar.dU, hVarA);
        return hVarA;
    }

    @Override // com.applovin.exoplayer2.f.j
    protected void a(com.applovin.exoplayer2.c.g gVar) throws p {
        if (!this.hi) {
            this.aeh++;
        }
        if (ai.acV >= 23 || !this.hi) {
            return;
        }
        by(gVar.rJ);
    }

    @Override // com.applovin.exoplayer2.f.j
    protected void a(v vVar, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        com.applovin.exoplayer2.f.g gVarJZ = jZ();
        if (gVarJZ != null) {
            gVarJZ.cJ(this.adY);
        }
        if (this.hi) {
            this.aek = vVar.dE;
            this.ael = vVar.height;
        } else {
            com.applovin.exoplayer2.l.a.checkNotNull(mediaFormat);
            boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            if (z) {
                integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
            } else {
                integer = mediaFormat.getInteger("width");
            }
            this.aek = integer;
            if (z) {
                integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
            } else {
                integer2 = mediaFormat.getInteger("height");
            }
            this.ael = integer2;
        }
        this.aen = vVar.dH;
        if (ai.acV >= 21) {
            if (vVar.dG == 90 || vVar.dG == 270) {
                int i = this.aek;
                this.aek = this.ael;
                this.ael = i;
                this.aen = 1.0f / this.aen;
            }
        } else {
            this.aem = vVar.dG;
        }
        this.adO.y(vVar.dF);
    }

    @Override // com.applovin.exoplayer2.f.j
    protected void f(com.applovin.exoplayer2.c.g gVar) throws p {
        if (this.adV) {
            ByteBuffer byteBuffer = (ByteBuffer) com.applovin.exoplayer2.l.a.checkNotNull(gVar.rK);
            if (byteBuffer.remaining() >= 7) {
                byte b2 = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b3 = byteBuffer.get();
                byte b4 = byteBuffer.get();
                byteBuffer.position(0);
                if (b2 == -75 && s == 60 && s2 == 1 && b3 == 4 && b4 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    a(jZ(), bArr);
                }
            }
        }
    }

    @Override // com.applovin.exoplayer2.f.j
    protected boolean a(long j, long j2, com.applovin.exoplayer2.f.g gVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, v vVar) throws p {
        com.applovin.exoplayer2.l.a.checkNotNull(gVar);
        if (this.aec == -9223372036854775807L) {
            this.aec = j;
        }
        if (j3 != this.aei) {
            this.adO.bw(j3);
            this.aei = j3;
        }
        long jKu = ku();
        long j4 = j3 - jKu;
        if (z && !z2) {
            a(gVar, i, j4);
            return true;
        }
        double dKn = kn();
        boolean z3 = P() == 2;
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long j5 = (long) ((j3 - j) / dKn);
        if (z3) {
            j5 -= jElapsedRealtime - j2;
        }
        if (this.Hm == this.adW) {
            if (!bA(j5)) {
                return false;
            }
            a(gVar, i, j4);
            bz(j5);
            return true;
        }
        if (this.aed == -9223372036854775807L && j >= jKu && ((this.aeb ? !this.adZ : !(!z3 && !this.aea)) || (z3 && C(j5, jElapsedRealtime - this.aej)))) {
            long jNanoTime = System.nanoTime();
            a(j4, jNanoTime, vVar);
            if (ai.acV >= 21) {
                a(gVar, i, j4, jNanoTime);
            } else {
                c(gVar, i, j4);
            }
            bz(j5);
            return true;
        }
        if (z3 && j != this.aec) {
            long jNanoTime2 = System.nanoTime();
            long jBD = this.adO.bD((j5 * 1000) + jNanoTime2);
            long j6 = (jBD - jNanoTime2) / 1000;
            boolean z4 = this.aed != -9223372036854775807L;
            if (b(j6, j2, z2) && h(j, z4)) {
                return false;
            }
            if (a(j6, j2, z2)) {
                if (z4) {
                    a(gVar, i, j4);
                } else {
                    b(gVar, i, j4);
                }
                bz(j6);
                return true;
            }
            if (ai.acV >= 21) {
                if (j6 < 50000) {
                    a(j4, jBD, vVar);
                    a(gVar, i, j4, jBD);
                    bz(j6);
                    return true;
                }
            } else if (j6 < 30000) {
                if (j6 > 11000) {
                    try {
                        Thread.sleep((j6 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return false;
                    }
                }
                a(j4, jBD, vVar);
                c(gVar, i, j4);
                bz(j6);
                return true;
            }
        }
        return false;
    }

    private void a(long j, long j2, v vVar) {
        l lVar = this.aer;
        if (lVar != null) {
            lVar.a(j, j2, vVar, ka());
        }
    }

    protected void by(long j) throws p {
        aL(j);
        qp();
        this.IL.rz++;
        qm();
        aN(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qj() {
        kt();
    }

    @Override // com.applovin.exoplayer2.f.j
    protected void aN(long j) {
        super.aN(j);
        if (this.hi) {
            return;
        }
        this.aeh--;
    }

    @Override // com.applovin.exoplayer2.f.j
    protected void eB() {
        super.eB();
        ql();
    }

    protected boolean a(long j, long j2, boolean z) {
        return bA(j) && !z;
    }

    protected boolean b(long j, long j2, boolean z) {
        return bB(j) && !z;
    }

    protected boolean C(long j, long j2) {
        return bA(j) && j2 > 100000;
    }

    protected void a(com.applovin.exoplayer2.f.g gVar, int i, long j) {
        ah.bg("skipVideoBuffer");
        gVar.l(i, false);
        ah.pV();
        this.IL.rA++;
    }

    protected void b(com.applovin.exoplayer2.f.g gVar, int i, long j) {
        ah.bg("dropVideoBuffer");
        gVar.l(i, false);
        ah.pV();
        fR(1);
    }

    protected boolean h(long j, boolean z) throws p {
        int iE = e(j);
        if (iE == 0) {
            return false;
        }
        this.IL.rD++;
        int i = this.aeh + iE;
        if (z) {
            this.IL.rA += i;
        } else {
            fR(i);
        }
        ke();
        return true;
    }

    protected void fR(int i) {
        this.IL.rB += i;
        this.aef += i;
        this.aeg += i;
        this.IL.rC = Math.max(this.aeg, this.IL.rC);
        int i2 = this.adR;
        if (i2 <= 0 || this.aef < i2) {
            return;
        }
        qr();
    }

    protected void bz(long j) {
        this.IL.af(j);
        this.rE += j;
        this.rF++;
    }

    protected void c(com.applovin.exoplayer2.f.g gVar, int i, long j) {
        qp();
        ah.bg("releaseOutputBuffer");
        gVar.l(i, true);
        ah.pV();
        this.aej = SystemClock.elapsedRealtime() * 1000;
        this.IL.rz++;
        this.aeg = 0;
        qm();
    }

    protected void a(com.applovin.exoplayer2.f.g gVar, int i, long j, long j2) {
        qp();
        ah.bg("releaseOutputBuffer");
        gVar.i(i, j2);
        ah.pV();
        this.aej = SystemClock.elapsedRealtime() * 1000;
        this.IL.rz++;
        this.aeg = 0;
        qm();
    }

    private boolean e(com.applovin.exoplayer2.f.i iVar) {
        return ai.acV >= 23 && !this.hi && !bo(iVar.name) && (!iVar.Hu || d.p(this.E));
    }

    private void qk() {
        this.aed = this.adQ > 0 ? SystemClock.elapsedRealtime() + this.adQ : -9223372036854775807L;
    }

    private void ql() {
        com.applovin.exoplayer2.f.g gVarJZ;
        this.adZ = false;
        if (ai.acV < 23 || !this.hi || (gVarJZ = jZ()) == null) {
            return;
        }
        this.aeq = new b(gVarJZ);
    }

    void qm() {
        this.aeb = true;
        if (this.adZ) {
            return;
        }
        this.adZ = true;
        this.adP.T(this.Hm);
        this.adX = true;
    }

    private void qn() {
        if (this.adX) {
            this.adP.T(this.Hm);
        }
    }

    private void qo() {
        this.aeo = null;
    }

    private void qp() {
        if (this.aek == -1 && this.ael == -1) {
            return;
        }
        o oVar = this.aeo;
        if (oVar != null && oVar.dE == this.aek && this.aeo.height == this.ael && this.aeo.afl == this.aem && this.aeo.dH == this.aen) {
            return;
        }
        o oVar2 = new o(this.aek, this.ael, this.aem, this.aen);
        this.aeo = oVar2;
        this.adP.b(oVar2);
    }

    private void qq() {
        o oVar = this.aeo;
        if (oVar != null) {
            this.adP.b(oVar);
        }
    }

    private void qr() {
        if (this.aef > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.adP.l(this.aef, jElapsedRealtime - this.aee);
            this.aef = 0;
            this.aee = jElapsedRealtime;
        }
    }

    private void qs() {
        int i = this.rF;
        if (i != 0) {
            this.adP.f(this.rE, i);
            this.rE = 0L;
            this.rF = 0;
        }
    }

    private static void a(com.applovin.exoplayer2.f.g gVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        gVar.u(bundle);
    }

    protected void a(com.applovin.exoplayer2.f.g gVar, Surface surface) {
        gVar.b(surface);
    }

    private static void a(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    protected MediaFormat a(v vVar, String str, a aVar, float f, boolean z, int i) {
        Pair<Integer, Integer> pairR;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", vVar.dE);
        mediaFormat.setInteger("height", vVar.height);
        t.a(mediaFormat, vVar.dB);
        t.a(mediaFormat, "frame-rate", vVar.dF);
        t.a(mediaFormat, "rotation-degrees", vVar.dG);
        t.a(mediaFormat, vVar.dK);
        if ("video/dolby-vision".equals(vVar.dz) && (pairR = com.applovin.exoplayer2.f.l.r(vVar)) != null) {
            t.a(mediaFormat, Scopes.PROFILE, ((Integer) pairR.first).intValue());
        }
        mediaFormat.setInteger("max-width", aVar.dE);
        mediaFormat.setInteger("max-height", aVar.height);
        t.a(mediaFormat, "max-input-size", aVar.aes);
        if (ai.acV >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            a(mediaFormat, i);
        }
        return mediaFormat;
    }

    protected a b(com.applovin.exoplayer2.f.i iVar, v vVar, v[] vVarArr) {
        int iA;
        int iMax = vVar.dE;
        int iMax2 = vVar.height;
        int iC = c(iVar, vVar);
        if (vVarArr.length == 1) {
            if (iC != -1 && (iA = a(iVar, vVar)) != -1) {
                iC = Math.min((int) (iC * 1.5f), iA);
            }
            return new a(iMax, iMax2, iC);
        }
        int length = vVarArr.length;
        boolean z = false;
        for (int i = 0; i < length; i++) {
            v vVarBT = vVarArr[i];
            if (vVar.dK != null && vVarBT.dK == null) {
                vVarBT = vVarBT.bR().a(vVar.dK).bT();
            }
            if (iVar.a(vVar, vVarBT).pZ != 0) {
                z |= vVarBT.dE == -1 || vVarBT.height == -1;
                iMax = Math.max(iMax, vVarBT.dE);
                iMax2 = Math.max(iMax2, vVarBT.height);
                iC = Math.max(iC, c(iVar, vVarBT));
            }
        }
        if (z) {
            q.h("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
            Point pointB = b(iVar, vVar);
            if (pointB != null) {
                iMax = Math.max(iMax, pointB.x);
                iMax2 = Math.max(iMax2, pointB.y);
                iC = Math.max(iC, a(iVar, vVar.bR().J(iMax).K(iMax2).bT()));
                q.h("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
            }
        }
        return new a(iMax, iMax2, iC);
    }

    @Override // com.applovin.exoplayer2.f.j
    protected com.applovin.exoplayer2.f.h a(Throwable th, com.applovin.exoplayer2.f.i iVar) {
        return new g(th, iVar, this.Hm);
    }

    private static Point b(com.applovin.exoplayer2.f.i iVar, v vVar) {
        boolean z = vVar.height > vVar.dE;
        int i = z ? vVar.height : vVar.dE;
        int i2 = z ? vVar.dE : vVar.height;
        float f = i2 / i;
        for (int i3 : adL) {
            int i4 = (int) (i3 * f);
            if (i3 <= i || i4 <= i2) {
                break;
            }
            if (ai.acV >= 21) {
                int i5 = z ? i4 : i3;
                if (!z) {
                    i3 = i4;
                }
                Point pointD = iVar.D(i5, i3);
                if (iVar.a(pointD.x, pointD.y, vVar.dF)) {
                    return pointD;
                }
            } else {
                try {
                    int iN = ai.N(i3, 16) * 16;
                    int iN2 = ai.N(i4, 16) * 16;
                    if (iN * iN2 <= com.applovin.exoplayer2.f.l.kz()) {
                        int i6 = z ? iN2 : iN;
                        if (!z) {
                            iN = iN2;
                        }
                        return new Point(i6, iN);
                    }
                } catch (com.applovin.exoplayer2.f.l.b unused) {
                }
            }
        }
        return null;
    }

    protected static int c(com.applovin.exoplayer2.f.i iVar, v vVar) {
        if (vVar.dA != -1) {
            int size = vVar.dB.size();
            int length = 0;
            for (int i = 0; i < size; i++) {
                length += vVar.dB.get(i).length;
            }
            return vVar.dA + length;
        }
        return a(iVar, vVar);
    }

    private static int a(com.applovin.exoplayer2.f.i iVar, v vVar) {
        int iN;
        int iIntValue;
        int i = vVar.dE;
        int i2 = vVar.height;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        String str = vVar.dz;
        if ("video/dolby-vision".equals(str)) {
            Pair<Integer, Integer> pairR = com.applovin.exoplayer2.f.l.r(vVar);
            str = (pairR == null || !((iIntValue = ((Integer) pairR.first).intValue()) == 512 || iIntValue == 1 || iIntValue == 2)) ? "video/hevc" : "video/avc";
        }
        str.hashCode();
        int i3 = 4;
        switch (str) {
            case "video/3gpp":
            case "video/mp4v-es":
            case "video/x-vnd.on2.vp8":
                iN = i * i2;
                i3 = 2;
                return (iN * 3) / (i3 * 2);
            case "video/hevc":
            case "video/x-vnd.on2.vp9":
                iN = i * i2;
                return (iN * 3) / (i3 * 2);
            case "video/avc":
                if ("BRAVIA 4K 2015".equals(ai.acY) || ("Amazon".equals(ai.acX) && ("KFSOWI".equals(ai.acY) || ("AFTS".equals(ai.acY) && iVar.Hu)))) {
                    return -1;
                }
                iN = ai.N(i, 16) * ai.N(i2, 16) * 16 * 16;
                i3 = 2;
                return (iN * 3) / (i3 * 2);
            default:
                return -1;
        }
    }

    private static boolean qt() {
        return "NVIDIA".equals(ai.acX);
    }

    protected boolean bo(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (h.class) {
            if (!adM) {
                adN = qu();
                adM = true;
            }
        }
        return adN;
    }

    protected static final class a {
        public final int aes;
        public final int dE;
        public final int height;

        public a(int i, int i2, int i3) {
            this.dE = i;
            this.height = i2;
            this.aes = i3;
        }
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1091)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:31)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:21)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    private static boolean qu() {
        /*
            Method dump skipped, instruction units count: 3048
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.m.h.qu():boolean");
    }

    private final class b implements Handler.Callback, com.applovin.exoplayer2.f.g.c {
        private final Handler jS;

        public b(com.applovin.exoplayer2.f.g gVar) {
            Handler handlerA = ai.a(this);
            this.jS = handlerA;
            gVar.a(this, handlerA);
        }

        @Override // com.applovin.exoplayer2.f.g.c
        public void a(com.applovin.exoplayer2.f.g gVar, long j, long j2) {
            if (ai.acV < 30) {
                this.jS.sendMessageAtFrontOfQueue(Message.obtain(this.jS, 0, (int) (j >> 32), (int) j));
            } else {
                bC(j);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            bC(ai.O(message.arg1, message.arg2));
            return true;
        }

        private void bC(long j) {
            if (this != h.this.aeq) {
                return;
            }
            if (j == Long.MAX_VALUE) {
                h.this.qj();
                return;
            }
            try {
                h.this.by(j);
            } catch (p e) {
                h.this.b(e);
            }
        }
    }
}
