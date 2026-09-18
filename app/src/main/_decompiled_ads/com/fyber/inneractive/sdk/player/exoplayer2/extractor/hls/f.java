package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u;
import com.fyber.inneractive.sdk.player.exoplayer2.util.r;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.d {
    public static final AtomicInteger G = new AtomicInteger();
    public int A;
    public int B;
    public boolean C;
    public j D;
    public volatile boolean E;
    public volatile boolean F;
    public final int j;
    public final int k;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a l;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.g m;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.j n;
    public final boolean o;
    public final boolean p;
    public final r q;
    public final String r;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.f s;
    public final boolean t;
    public final boolean u;
    public final List<com.fyber.inneractive.sdk.player.exoplayer2.i> v;
    public final boolean w;
    public final com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g x;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k y;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.f z;

    public f(com.fyber.inneractive.sdk.player.exoplayer2.upstream.g gVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar2, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a c0287a, List<com.fyber.inneractive.sdk.player.exoplayer2.i> list, int i, Object obj, long j, long j2, int i2, int i3, boolean z, r rVar, f fVar, byte[] bArr, byte[] bArr2) {
        super(a(gVar, bArr, bArr2), jVar, c0287a.f1074b, i, obj, j, j2, i2);
        this.k = i3;
        this.n = jVar2;
        this.l = c0287a;
        this.v = list;
        this.p = z;
        this.q = rVar;
        this.o = this.h instanceof a;
        String lastPathSegment = jVar.a.getLastPathSegment();
        this.r = lastPathSegment;
        boolean z2 = lastPathSegment.endsWith(DefaultHlsExtractorFactory.AAC_FILE_EXTENSION) || lastPathSegment.endsWith(DefaultHlsExtractorFactory.AC3_FILE_EXTENSION) || lastPathSegment.endsWith(DefaultHlsExtractorFactory.EC3_FILE_EXTENSION) || lastPathSegment.endsWith(DefaultHlsExtractorFactory.MP3_FILE_EXTENSION);
        this.w = z2;
        if (fVar != null) {
            this.x = fVar.x;
            this.y = fVar.y;
            this.s = fVar.z;
            boolean z3 = fVar.l != c0287a;
            this.t = z3;
            this.u = fVar.k != i3 || z3;
        } else {
            this.x = z2 ? new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g() : null;
            this.y = z2 ? new com.fyber.inneractive.sdk.player.exoplayer2.util.k(10) : null;
            this.s = null;
            this.t = false;
            this.u = true;
        }
        this.m = gVar;
        this.j = G.getAndIncrement();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.c
    public boolean a() {
        return this.E;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.c
    public void b() {
        this.E = true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a
    public long c() {
        return this.B;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x016d A[Catch: all -> 0x0173, TRY_LEAVE, TryCatch #0 {, blocks: (B:100:0x0167, B:102:0x016d), top: B:146:0x0167 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x0176  */
    /* JADX WARN: Code duplicated, block: B:111:0x0183  */
    /* JADX WARN: Code duplicated, block: B:115:0x018c  */
    /* JADX WARN: Code duplicated, block: B:116:0x018e  */
    /* JADX WARN: Code duplicated, block: B:125:0x01ab A[Catch: all -> 0x01f4, TryCatch #1 {all -> 0x01f4, blocks: (B:123:0x0199, B:125:0x01ab, B:127:0x01b3, B:129:0x01bc, B:128:0x01ba, B:131:0x01c4, B:140:0x01e2, B:138:0x01d7, B:139:0x01e1, B:133:0x01cb, B:135:0x01cf), top: B:148:0x0199, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x01b3 A[Catch: all -> 0x01f4, TryCatch #1 {all -> 0x01f4, blocks: (B:123:0x0199, B:125:0x01ab, B:127:0x01b3, B:129:0x01bc, B:128:0x01ba, B:131:0x01c4, B:140:0x01e2, B:138:0x01d7, B:139:0x01e1, B:133:0x01cb, B:135:0x01cf), top: B:148:0x0199, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x01ba A[Catch: all -> 0x01f4, TryCatch #1 {all -> 0x01f4, blocks: (B:123:0x0199, B:125:0x01ab, B:127:0x01b3, B:129:0x01bc, B:128:0x01ba, B:131:0x01c4, B:140:0x01e2, B:138:0x01d7, B:139:0x01e1, B:133:0x01cb, B:135:0x01cf), top: B:148:0x0199, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x01c4 A[Catch: all -> 0x01f4, TRY_LEAVE, TryCatch #1 {all -> 0x01f4, blocks: (B:123:0x0199, B:125:0x01ab, B:127:0x01b3, B:129:0x01bc, B:128:0x01ba, B:131:0x01c4, B:140:0x01e2, B:138:0x01d7, B:139:0x01e1, B:133:0x01cb, B:135:0x01cf), top: B:148:0x0199, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x01cf A[Catch: all -> 0x01d6, TRY_LEAVE, TryCatch #3 {all -> 0x01d6, blocks: (B:133:0x01cb, B:135:0x01cf), top: B:151:0x01cb, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x0167 A[EXC_TOP_SPLITTER, LOOP:3: B:146:0x0167->B:168:?, LOOP_START, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:149:0x0186 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:151:0x01cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x01e2 A[EDGE_INSN: B:170:0x01e2->B:140:0x01e2 BREAK  A[LOOP:4: B:132:0x01c9->B:172:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:98:0x0164  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.c
    public void load() throws InterruptedException, IOException {
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVarA;
        boolean z;
        r rVar;
        long j;
        boolean z2;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar;
        long jA;
        long jB;
        r rVar2;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.f lVar;
        boolean z3;
        String strA;
        String strA2;
        int iA = 0;
        if (this.z == null && !this.w) {
            if ("text/vtt".equals(this.l.f1074b.f) || this.r.endsWith(DefaultHlsExtractorFactory.WEBVTT_FILE_EXTENSION) || this.r.endsWith(DefaultHlsExtractorFactory.VTT_FILE_EXTENSION)) {
                lVar = new l(this.c.y, this.q);
            } else {
                if (this.u) {
                    if (!this.r.endsWith(".mp4")) {
                        String str = this.r;
                        if (!str.startsWith(DefaultHlsExtractorFactory.M4_FILE_EXTENSION_PREFIX, str.length() - 4)) {
                            int i = 16;
                            List<com.fyber.inneractive.sdk.player.exoplayer2.i> listEmptyList = this.v;
                            if (listEmptyList != null) {
                                i = 48;
                            } else {
                                listEmptyList = Collections.emptyList();
                            }
                            String str2 = this.c.c;
                            if (!TextUtils.isEmpty(str2)) {
                                if (str2 != null) {
                                    String[] strArrSplit = str2.split(",");
                                    int length = strArrSplit.length;
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 < length) {
                                            strA = com.fyber.inneractive.sdk.player.exoplayer2.util.h.a(strArrSplit[i2]);
                                            if (strA != null && com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(strA)) {
                                                break;
                                            } else {
                                                i2++;
                                            }
                                        } else {
                                            strA = null;
                                            break;
                                        }
                                    }
                                } else {
                                    strA = null;
                                    break;
                                }
                                if (!"audio/mp4a-latm".equals(strA)) {
                                    i |= 2;
                                }
                                if (str2 != null) {
                                    String[] strArrSplit2 = str2.split(",");
                                    int length2 = strArrSplit2.length;
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 < length2) {
                                            strA2 = com.fyber.inneractive.sdk.player.exoplayer2.util.h.a(strArrSplit2[i3]);
                                            if (strA2 != null && com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(strA2)) {
                                                break;
                                            } else {
                                                i3++;
                                            }
                                        } else {
                                            strA2 = null;
                                            break;
                                        }
                                    }
                                } else {
                                    strA2 = null;
                                    break;
                                }
                                if (!"video/avc".equals(strA2)) {
                                    i |= 4;
                                }
                            }
                            u uVar = new u(2, this.q, new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.e(i, listEmptyList));
                            z3 = true;
                            lVar = uVar;
                        }
                    }
                    lVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.d(0, this.q, null);
                } else {
                    lVar = this.s;
                    z3 = false;
                }
                if (z3) {
                    lVar.a(this.D);
                }
                this.z = lVar;
            }
            z3 = true;
            if (z3) {
                lVar.a(this.D);
            }
            this.z = lVar;
        }
        if (this.s != this.z && !this.C && (jVar = this.n) != null) {
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVarA2 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a(jVar, this.A);
            try {
                com.fyber.inneractive.sdk.player.exoplayer2.upstream.g gVar = this.m;
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.b(gVar, jVarA2.c, gVar.a(jVarA2));
                int iA2 = 0;
                while (iA2 == 0) {
                    try {
                        if (this.E) {
                            break;
                        } else {
                            iA2 = this.z.a(bVar2, (com.fyber.inneractive.sdk.player.exoplayer2.extractor.l) null);
                        }
                    } catch (Throwable th) {
                        this.A = (int) (bVar2.c - this.n.c);
                        throw th;
                    }
                }
                this.A = (int) (bVar2.c - this.n.c);
                com.fyber.inneractive.sdk.player.exoplayer2.util.u.a(this.h);
                this.C = true;
            } catch (Throwable th2) {
                com.fyber.inneractive.sdk.player.exoplayer2.util.u.a(this.h);
                throw th2;
            }
        }
        if (this.E) {
            return;
        }
        try {
            if (this.o) {
                jVarA = this.a;
                if (this.B != 0) {
                    z = true;
                }
                if (this.p) {
                    rVar = this.q;
                    if (rVar.a == Long.MAX_VALUE) {
                        j = this.f;
                        synchronized (rVar) {
                            if (rVar.c == -9223372036854775807L) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z2);
                            rVar.a = j;
                        }
                    }
                } else {
                    rVar2 = this.q;
                    synchronized (rVar2) {
                        while (rVar2.c == -9223372036854775807L) {
                            rVar2.wait();
                        }
                    }
                }
                com.fyber.inneractive.sdk.player.exoplayer2.upstream.g gVar2 = this.h;
                bVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.b(gVar2, jVarA.c, gVar2.a(jVarA));
                if (this.z == null) {
                    jA = a(bVar);
                    if (jA != -9223372036854775807L) {
                        jB = this.q.b(jA);
                    } else {
                        jB = this.f;
                    }
                    this.z = a(jB);
                }
                if (z) {
                    bVar.c(this.B);
                }
                while (iA == 0) {
                    try {
                        if (!this.E) {
                            break;
                        } else {
                            iA = this.z.a(bVar, (com.fyber.inneractive.sdk.player.exoplayer2.extractor.l) null);
                        }
                    } catch (Throwable th3) {
                        this.B = (int) (bVar.c - this.a.c);
                        throw th3;
                    }
                }
                this.B = (int) (bVar.c - this.a.c);
                com.fyber.inneractive.sdk.player.exoplayer2.util.u.a(this.h);
                this.F = true;
                return;
            }
            jVarA = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a(this.a, this.B);
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.g gVar3 = this.h;
            bVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.b(gVar3, jVarA.c, gVar3.a(jVarA));
            if (this.z == null) {
                jA = a(bVar);
                if (jA != -9223372036854775807L) {
                    jB = this.q.b(jA);
                } else {
                    jB = this.f;
                }
                this.z = a(jB);
            }
            if (z) {
                bVar.c(this.B);
            }
            while (iA == 0) {
                if (!this.E) {
                    break;
                    break;
                }
                iA = this.z.a(bVar, (com.fyber.inneractive.sdk.player.exoplayer2.extractor.l) null);
            }
            this.B = (int) (bVar.c - this.a.c);
            com.fyber.inneractive.sdk.player.exoplayer2.util.u.a(this.h);
            this.F = true;
            return;
        } catch (Throwable th4) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.u.a(this.h);
            throw th4;
        }
        z = false;
        if (this.p) {
            rVar2 = this.q;
            synchronized (rVar2) {
                while (rVar2.c == -9223372036854775807L) {
                    rVar2.wait();
                }
            }
        } else {
            rVar = this.q;
            if (rVar.a == Long.MAX_VALUE) {
                j = this.f;
                synchronized (rVar) {
                    if (rVar.c == -9223372036854775807L) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z2);
                    rVar.a = j;
                }
            }
        }
    }

    public final long a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar) throws InterruptedException, IOException {
        com.fyber.inneractive.sdk.player.exoplayer2.metadata.a aVarA;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
        bVar.e = 0;
        if (!bVar.a(this.y.a, 0, 10, true)) {
            return -9223372036854775807L;
        }
        this.y.c(10);
        if (this.y.n() != com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g.f1168b) {
            return -9223372036854775807L;
        }
        this.y.f(3);
        int iK = this.y.k();
        int i = iK + 10;
        if (i > this.y.b()) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar = this.y;
            byte[] bArr = kVar.a;
            kVar.c(i);
            System.arraycopy(bArr, 0, this.y.a, 0, 10);
        }
        if (!bVar.a(this.y.a, 10, iK, true) || (aVarA = this.x.a(this.y.a, iK)) == null) {
            return -9223372036854775807L;
        }
        int length = aVarA.a.length;
        for (int i2 = 0; i2 < length; i2++) {
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.a.b bVar2 = aVarA.a[i2];
            if (bVar2 instanceof com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.i) {
                com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.i iVar = (com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.i) bVar2;
                if ("com.apple.streaming.transportStreamTimestamp".equals(iVar.f1170b)) {
                    System.arraycopy(iVar.c, 0, this.y.a, 0, 8);
                    this.y.c(8);
                    return this.y.i();
                }
            }
        }
        return -9223372036854775807L;
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.upstream.g a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.g gVar, byte[] bArr, byte[] bArr2) {
        return (bArr == null || bArr2 == null) ? gVar : new a(gVar, bArr, bArr2);
    }

    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.f a(long j) {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.f aVar;
        if (this.r.endsWith(DefaultHlsExtractorFactory.AAC_FILE_EXTENSION)) {
            aVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.c(j);
        } else if (!this.r.endsWith(DefaultHlsExtractorFactory.AC3_FILE_EXTENSION) && !this.r.endsWith(DefaultHlsExtractorFactory.EC3_FILE_EXTENSION)) {
            if (this.r.endsWith(DefaultHlsExtractorFactory.MP3_FILE_EXTENSION)) {
                aVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.b(0, j);
            } else {
                throw new IllegalArgumentException("Unkown extension for audio file: " + this.r);
            }
        } else {
            aVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.a(j);
        }
        aVar.a(this.D);
        return aVar;
    }
}
