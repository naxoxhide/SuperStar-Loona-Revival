package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.f, m {
    public static final int p = u.a("qt  ");
    public int e;
    public int f;
    public long g;
    public int h;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.k i;
    public int j;
    public int k;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.h l;
    public a[] m;
    public long n;
    public boolean o;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k c = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(16);
    public final Stack<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0290a> d = new Stack<>();
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k a = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(com.fyber.inneractive.sdk.player.exoplayer2.util.i.a);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k f1103b = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(4);

    public static final class a {
        public final h a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k f1104b;
        public final n c;
        public int d;

        public a(h hVar, k kVar, n nVar) {
            this.a = hVar;
            this.f1104b = kVar;
            this.c = nVar;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.m
    public boolean a() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar) throws InterruptedException, IOException {
        return g.a(gVar, false);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.m
    public long c() {
        return this.n;
    }

    public final void d() {
        this.e = 0;
        this.h = 0;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.h hVar) {
        this.l = hVar;
    }

    /* JADX WARN: Code duplicated, block: B:127:0x01f0 A[Catch: all -> 0x022c, TRY_LEAVE, TryCatch #0 {all -> 0x022c, blocks: (B:32:0x00a6, B:34:0x00aa, B:36:0x00b0, B:38:0x00b5, B:41:0x00bd, B:42:0x00c4, B:43:0x00cc, B:45:0x00d0, B:46:0x00d8, B:48:0x00dc, B:49:0x00e4, B:51:0x00e8, B:52:0x00f0, B:54:0x00f4, B:55:0x00fc, B:57:0x0100, B:59:0x0109, B:61:0x010d, B:62:0x0115, B:64:0x0119, B:65:0x0121, B:67:0x0125, B:68:0x012c, B:70:0x0130, B:71:0x0137, B:73:0x013b, B:74:0x0142, B:76:0x0146, B:77:0x014d, B:79:0x0151, B:80:0x0158, B:82:0x015c, B:83:0x0163, B:85:0x0167, B:86:0x016e, B:88:0x0172, B:89:0x0179, B:91:0x017d, B:127:0x01f0, B:92:0x0182, B:94:0x018a, B:96:0x0191, B:98:0x0195, B:101:0x019b, B:103:0x019f, B:106:0x01a5, B:108:0x01a9, B:109:0x01b0, B:111:0x01b4, B:112:0x01bb, B:114:0x01bf, B:115:0x01c6, B:117:0x01ca, B:118:0x01d1, B:120:0x01d5, B:121:0x01dc, B:123:0x01e0, B:124:0x01e5, B:126:0x01e9, B:129:0x020f, B:130:0x0217), top: B:430:0x00a6 }] */
    /* JADX WARN: Code duplicated, block: B:207:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:209:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:211:0x0404  */
    /* JADX WARN: Code duplicated, block: B:213:0x040a  */
    /* JADX WARN: Code duplicated, block: B:214:0x0411 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:215:0x0413  */
    /* JADX WARN: Code duplicated, block: B:216:0x0418  */
    /* JADX WARN: Code duplicated, block: B:218:0x041e  */
    /* JADX WARN: Code duplicated, block: B:220:0x042a  */
    /* JADX WARN: Code duplicated, block: B:221:0x0433  */
    /* JADX WARN: Code duplicated, block: B:226:0x044f A[ADDED_TO_REGION, LOOP:7: B:226:0x044f->B:228:0x0453, LOOP_START, PHI: r23 r25 r33
      0x044f: PHI (r23v9 int) = (r23v7 int), (r23v11 int) binds: [B:225:0x044d, B:228:0x0453] A[DONT_GENERATE, DONT_INLINE]
      0x044f: PHI (r25v11 int) = (r25v5 int), (r25v12 int) binds: [B:225:0x044d, B:228:0x0453] A[DONT_GENERATE, DONT_INLINE]
      0x044f: PHI (r33v10 int) = (r33v6 int), (r33v11 int) binds: [B:225:0x044d, B:228:0x0453] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:232:0x0470  */
    /* JADX WARN: Code duplicated, block: B:235:0x047d  */
    /* JADX WARN: Code duplicated, block: B:236:0x047f  */
    /* JADX WARN: Code duplicated, block: B:239:0x0484  */
    /* JADX WARN: Code duplicated, block: B:241:0x048b  */
    /* JADX WARN: Code duplicated, block: B:243:0x0497  */
    /* JADX WARN: Code duplicated, block: B:248:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:252:0x04e0  */
    /* JADX WARN: Code duplicated, block: B:253:0x04e2  */
    /* JADX WARN: Code duplicated, block: B:256:0x04e8  */
    /* JADX WARN: Code duplicated, block: B:258:0x04ee  */
    /* JADX WARN: Code duplicated, block: B:259:0x04f0  */
    /* JADX WARN: Code duplicated, block: B:268:0x0508  */
    /* JADX WARN: Code duplicated, block: B:271:0x055e  */
    /* JADX WARN: Code duplicated, block: B:274:0x0574  */
    /* JADX WARN: Code duplicated, block: B:275:0x0577 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:276:0x0579  */
    /* JADX WARN: Code duplicated, block: B:277:0x057e  */
    /* JADX WARN: Code duplicated, block: B:279:0x0584  */
    /* JADX WARN: Code duplicated, block: B:281:0x0590  */
    /* JADX WARN: Code duplicated, block: B:282:0x0597  */
    /* JADX WARN: Code duplicated, block: B:283:0x059a  */
    /* JADX WARN: Code duplicated, block: B:286:0x059e A[LOOP:14: B:272:0x0570->B:286:0x059e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:289:0x05af A[LOOP:15: B:288:0x05ad->B:289:0x05af, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:292:0x05c7  */
    /* JADX WARN: Code duplicated, block: B:294:0x05d3 A[LOOP:17: B:293:0x05d1->B:294:0x05d3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:325:0x06af  */
    /* JADX WARN: Code duplicated, block: B:327:0x06b7  */
    /* JADX WARN: Code duplicated, block: B:329:0x06bf  */
    /* JADX WARN: Code duplicated, block: B:332:0x06c4 A[LOOP:9: B:330:0x06c1->B:332:0x06c4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:337:0x06f7  */
    /* JADX WARN: Code duplicated, block: B:338:0x06f9  */
    /* JADX WARN: Code duplicated, block: B:342:0x0705  */
    /* JADX WARN: Code duplicated, block: B:344:0x0710  */
    /* JADX WARN: Code duplicated, block: B:346:0x072f  */
    /* JADX WARN: Code duplicated, block: B:347:0x0731  */
    /* JADX WARN: Code duplicated, block: B:349:0x0736  */
    /* JADX WARN: Code duplicated, block: B:353:0x0744  */
    /* JADX WARN: Code duplicated, block: B:354:0x0746  */
    /* JADX WARN: Code duplicated, block: B:357:0x074a  */
    /* JADX WARN: Code duplicated, block: B:358:0x074d  */
    /* JADX WARN: Code duplicated, block: B:360:0x0750  */
    /* JADX WARN: Code duplicated, block: B:361:0x0753  */
    /* JADX WARN: Code duplicated, block: B:363:0x0757  */
    /* JADX WARN: Code duplicated, block: B:365:0x075b  */
    /* JADX WARN: Code duplicated, block: B:366:0x075e  */
    /* JADX WARN: Code duplicated, block: B:370:0x076c  */
    /* JADX WARN: Code duplicated, block: B:372:0x077b  */
    /* JADX WARN: Code duplicated, block: B:374:0x079b  */
    /* JADX WARN: Code duplicated, block: B:375:0x07b1  */
    /* JADX WARN: Code duplicated, block: B:378:0x07bf  */
    /* JADX WARN: Code duplicated, block: B:380:0x07e6  */
    /* JADX WARN: Code duplicated, block: B:382:0x07ec  */
    /* JADX WARN: Code duplicated, block: B:383:0x07ef  */
    /* JADX WARN: Code duplicated, block: B:387:0x07ff  */
    /* JADX WARN: Code duplicated, block: B:392:0x0823 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:395:0x082b  */
    /* JADX WARN: Code duplicated, block: B:396:0x082d  */
    /* JADX WARN: Code duplicated, block: B:399:0x0834  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:402:0x084a  */
    /* JADX WARN: Code duplicated, block: B:436:0x0842 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:466:0x073d A[EDGE_INSN: B:466:0x073d->B:351:0x073d BREAK  A[LOOP:10: B:340:0x06fe->B:350:0x0737], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:469:0x0819 A[EDGE_INSN: B:469:0x0819->B:389:0x0819 BREAK  A[LOOP:11: B:368:0x0767->B:388:0x0807], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:479:0x05a3 A[EDGE_INSN: B:479:0x05a3->B:287:0x05a3 BREAK  A[LOOP:14: B:272:0x0570->B:286:0x059e], SYNTHETIC] */
    public final void c(long j) throws l {
        com.fyber.inneractive.sdk.player.exoplayer2.metadata.a aVar;
        h hVarA;
        b.a dVar;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0290a c0290a;
        int i;
        long j2;
        long j3;
        com.fyber.inneractive.sdk.player.exoplayer2.metadata.a aVar2;
        int iO;
        int iO2;
        int iO3;
        int i2;
        boolean z;
        int i3;
        h hVar;
        int i4;
        long[] jArr;
        int[] iArr;
        int i5;
        long jM;
        int iO4;
        int iO5;
        boolean z2;
        int iB;
        long j4;
        int i6;
        int i7;
        int iA;
        long[] jArr2;
        int[] iArr2;
        long[] jArr3;
        int[] iArr3;
        int i8;
        int iMax;
        int i9;
        int i10;
        int i11;
        long j5;
        long j6;
        int i12;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar;
        k kVar;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar2;
        long[] jArr4;
        boolean z3;
        int i13;
        int i14;
        int i15;
        boolean z4;
        long[] jArr5;
        int[] iArr4;
        int[] iArr5;
        boolean z5;
        boolean z6;
        long[] jArr6;
        int[] iArr6;
        int[] iArr7;
        long[] jArr7;
        long j7;
        int i16;
        int i17;
        int i18;
        long[] jArr8;
        long[] jArr9;
        int[] iArr8;
        int i19;
        boolean z7;
        boolean z8;
        long[] jArr10;
        long j8;
        long j9;
        int[] iArr9;
        int[] iArr10;
        int[] iArr11;
        int[] iArr12;
        int[] iArr13;
        int iA2;
        int iA3;
        int i20;
        int i21;
        int i22;
        long j10;
        int iA4;
        boolean z9;
        char c;
        int i23;
        k kVar2;
        long[] jArr11;
        int[] iArr14;
        long[] jArr12;
        int[] iArr15;
        int i24;
        int i25;
        int i26;
        int i27;
        int iO6;
        long j11;
        long j12;
        int i28;
        int iO7;
        int iO8;
        int i29;
        int i30;
        int i31;
        int i32;
        int iC;
        int i33;
        boolean z10;
        int i34;
        boolean z11;
        int iO9;
        int i35;
        int i36;
        int i37;
        int i38;
        int iO10;
        int i39;
        long jM2;
        int i40;
        boolean z12;
        int i41;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar3;
        long jMax;
        int i42;
        com.fyber.inneractive.sdk.player.exoplayer2.metadata.a.b bVarB;
        com.fyber.inneractive.sdk.player.exoplayer2.metadata.a.b bVarA;
        com.fyber.inneractive.sdk.player.exoplayer2.metadata.a.b jVar4;
        String str;
        f fVar = this;
        while (!fVar.d.isEmpty() && fVar.d.peek().P0 == j) {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0290a c0290aPop = fVar.d.pop();
            if (c0290aPop.a == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C) {
                ArrayList arrayList = new ArrayList();
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar5 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.j();
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b bVarD = c0290aPop.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.A0);
                int i43 = 12;
                int i44 = 0;
                if (bVarD != null) {
                    boolean z13 = fVar.o;
                    int i45 = b.a;
                    if (!z13) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar3 = bVarD.P0;
                        kVar3.e(8);
                        while (true) {
                            if (kVar3.a() >= 8) {
                                int i46 = kVar3.f1236b;
                                int iC2 = kVar3.c();
                                if (kVar3.c() == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.B0) {
                                    kVar3.e(i46);
                                    int i47 = i46 + iC2;
                                    kVar3.f(i43);
                                    while (true) {
                                        int i48 = kVar3.f1236b;
                                        if (i48 < i47) {
                                            int iC3 = kVar3.c();
                                            if (kVar3.c() == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0) {
                                                kVar3.e(i48);
                                                int i49 = i48 + iC3;
                                                kVar3.f(8);
                                                ArrayList arrayList2 = new ArrayList();
                                                while (true) {
                                                    int i50 = kVar3.f1236b;
                                                    if (i50 >= i49) {
                                                        break;
                                                    }
                                                    int i51 = e.a;
                                                    int iC4 = i50 + kVar3.c();
                                                    int iC5 = kVar3.c();
                                                    int i52 = (iC5 >> 24) & 255;
                                                    if (i52 == 169 || i52 == 65533) {
                                                        int i53 = 16777215 & iC5;
                                                        if (i53 == e.c) {
                                                            bVarB = e.a(iC5, kVar3);
                                                        } else if (i53 == e.a || i53 == e.f1102b) {
                                                            bVarB = e.b(iC5, "TIT2", kVar3);
                                                        } else if (i53 == e.h || i53 == e.i) {
                                                            bVarB = e.b(iC5, "TCOM", kVar3);
                                                        } else if (i53 == e.d) {
                                                            bVarB = e.b(iC5, "TDRC", kVar3);
                                                        } else if (i53 == e.e) {
                                                            bVarB = e.b(iC5, "TPE1", kVar3);
                                                        } else if (i53 == e.f) {
                                                            bVarB = e.b(iC5, "TSSE", kVar3);
                                                        } else if (i53 == e.g) {
                                                            bVarB = e.b(iC5, "TALB", kVar3);
                                                        } else if (i53 == e.j) {
                                                            bVarB = e.b(iC5, "USLT", kVar3);
                                                        } else if (i53 == e.k) {
                                                            bVarB = e.b(iC5, "TCON", kVar3);
                                                        } else if (i53 == e.n) {
                                                            bVarB = e.b(iC5, "TIT1", kVar3);
                                                        } else {
                                                            Log.d("MetadataUtil", "Skipped unknown metadata entry: " + com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.a(iC5));
                                                            kVar3.e(iC4);
                                                            bVarA = null;
                                                        }
                                                        jVar4 = bVarB;
                                                        bVarA = jVar4;
                                                        kVar3.e(iC4);
                                                    } else {
                                                        try {
                                                            if (iC5 == e.m) {
                                                                int iB2 = e.b(kVar3);
                                                                if (iB2 > 0) {
                                                                    String[] strArr = e.D;
                                                                    if (iB2 <= strArr.length) {
                                                                        str = strArr[iB2 - 1];
                                                                    } else {
                                                                        str = null;
                                                                    }
                                                                } else {
                                                                    str = null;
                                                                }
                                                                if (str != null) {
                                                                    jVar4 = new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j("TCON", null, str);
                                                                    bVarA = jVar4;
                                                                } else {
                                                                    Log.w("MetadataUtil", "Failed to parse standard genre code");
                                                                    bVarA = null;
                                                                }
                                                                kVar3.e(iC4);
                                                            } else {
                                                                if (iC5 == e.o) {
                                                                    bVarB = e.a(iC5, "TPOS", kVar3);
                                                                } else if (iC5 == e.p) {
                                                                    bVarB = e.a(iC5, "TRCK", kVar3);
                                                                } else if (iC5 == e.q) {
                                                                    bVarB = e.a(iC5, "TBPM", kVar3, true, false);
                                                                } else if (iC5 == e.r) {
                                                                    bVarB = e.a(iC5, "TCMP", kVar3, true, true);
                                                                } else if (iC5 == e.l) {
                                                                    bVarA = e.a(kVar3);
                                                                    kVar3.e(iC4);
                                                                } else if (iC5 == e.s) {
                                                                    bVarB = e.b(iC5, "TPE2", kVar3);
                                                                } else if (iC5 == e.t) {
                                                                    bVarB = e.b(iC5, "TSOT", kVar3);
                                                                } else if (iC5 == e.u) {
                                                                    bVarB = e.b(iC5, "TSO2", kVar3);
                                                                } else if (iC5 == e.v) {
                                                                    bVarB = e.b(iC5, "TSOA", kVar3);
                                                                } else if (iC5 == e.w) {
                                                                    bVarB = e.b(iC5, "TSOP", kVar3);
                                                                } else if (iC5 == e.x) {
                                                                    bVarB = e.b(iC5, "TSOC", kVar3);
                                                                } else if (iC5 == e.y) {
                                                                    bVarB = e.a(iC5, "ITUNESADVISORY", kVar3, false, false);
                                                                } else if (iC5 == e.z) {
                                                                    bVarB = e.a(iC5, "ITUNESGAPLESS", kVar3, false, true);
                                                                } else if (iC5 == e.A) {
                                                                    bVarB = e.b(iC5, "TVSHOWSORT", kVar3);
                                                                } else if (iC5 == e.B) {
                                                                    bVarB = e.b(iC5, "TVSHOW", kVar3);
                                                                } else if (iC5 == e.C) {
                                                                    bVarB = e.a(kVar3, iC4);
                                                                } else {
                                                                    Log.d("MetadataUtil", "Skipped unknown metadata entry: " + com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.a(iC5));
                                                                    kVar3.e(iC4);
                                                                    bVarA = null;
                                                                }
                                                                jVar4 = bVarB;
                                                                bVarA = jVar4;
                                                                kVar3.e(iC4);
                                                            }
                                                        } catch (Throwable th) {
                                                            kVar3.e(iC4);
                                                            throw th;
                                                        }
                                                    }
                                                    if (bVarA != null) {
                                                        arrayList2.add(bVarA);
                                                    }
                                                }
                                                if (!arrayList2.isEmpty()) {
                                                    aVar = new com.fyber.inneractive.sdk.player.exoplayer2.metadata.a(arrayList2);
                                                    break;
                                                }
                                                break;
                                            }
                                            kVar3.f(iC3 - 8);
                                        }
                                    }
                                } else {
                                    kVar3.f(iC2 - 8);
                                    i43 = 12;
                                }
                            }
                            aVar = null;
                            break;
                        }
                    }
                    aVar = null;
                    break;
                    if (aVar != null) {
                        jVar5.a(aVar);
                    }
                } else {
                    aVar = null;
                }
                int i54 = 0;
                long j13 = -9223372036854775807L;
                long j14 = Long.MAX_VALUE;
                while (i54 < c0290aPop.R0.size()) {
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0290a c0290a2 = c0290aPop.R0.get(i54);
                    if (c0290a2.a == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.E && (hVarA = b.a(c0290a2, c0290aPop.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.D), -9223372036854775807L, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null, fVar.o)) != null) {
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0290a c0290aC = c0290a2.c(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.F).c(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.G).c(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.H);
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b bVarD2 = c0290aC.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.q0);
                        if (bVarD2 != null) {
                            dVar = new b.c(bVarD2);
                        } else {
                            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b bVarD3 = c0290aC.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.r0);
                            if (bVarD3 == null) {
                                throw new l("Track has no sample table size information");
                            }
                            dVar = new b.d(bVarD3);
                        }
                        int iA5 = dVar.a();
                        if (iA5 == 0) {
                            c0290a = c0290aPop;
                            kVar = new k(new long[i44], new int[i44], 0, new long[i44], new int[i44]);
                            aVar2 = aVar;
                            j3 = j13;
                            arrayList = arrayList;
                            j2 = j14;
                            jVar = jVar5;
                            i2 = i54;
                            hVar = hVarA;
                        } else {
                            c0290a = c0290aPop;
                            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b bVarD4 = c0290aC.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.s0);
                            if (bVarD4 == null) {
                                bVarD4 = c0290aC.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.t0);
                                i = 1;
                            } else {
                                i = i44;
                            }
                            com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar4 = bVarD4.P0;
                            com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar5 = c0290aC.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.p0).P0;
                            j2 = j14;
                            com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar6 = c0290aC.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.m0).P0;
                            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b bVarD5 = c0290aC.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.n0);
                            com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar7 = bVarD5 != null ? bVarD5.P0 : null;
                            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b bVarD6 = c0290aC.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.o0);
                            com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar8 = bVarD6 != null ? bVarD6.P0 : null;
                            kVar4.e(12);
                            j3 = j13;
                            int iO11 = kVar4.o();
                            kVar5.e(12);
                            int iO12 = kVar5.o();
                            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(kVar5.c() == 1, "first_chunk must be 1");
                            kVar6.e(12);
                            int iO13 = kVar6.o() - 1;
                            int iO14 = kVar6.o();
                            aVar2 = aVar;
                            int iO15 = kVar6.o();
                            if (kVar8 != null) {
                                kVar8.e(12);
                                iO = kVar8.o();
                            } else {
                                iO = 0;
                            }
                            if (kVar7 != null) {
                                kVar7.e(12);
                                iO3 = kVar7.o();
                                if (iO3 > 0) {
                                    iO2 = kVar7.o() - 1;
                                } else {
                                    iO2 = -1;
                                    kVar7 = null;
                                }
                            } else {
                                iO2 = -1;
                                iO3 = 0;
                            }
                            if (dVar.c()) {
                                i2 = i54;
                                if ("audio/raw".equals(hVarA.f.f) && iO13 == 0 && iO == 0 && iO3 == 0) {
                                    z = true;
                                }
                                if (z) {
                                    b.a aVar3 = dVar;
                                    i3 = i;
                                    hVar = hVarA;
                                    i4 = iA5;
                                    jArr = new long[iO11];
                                    iArr = new int[iO11];
                                    i5 = -1;
                                    jM = 0;
                                    iO4 = 0;
                                    iO5 = 0;
                                    while (true) {
                                        i5++;
                                        if (i5 == iO11) {
                                            z2 = false;
                                        } else {
                                            if (i3 != 0) {
                                                jM = kVar4.p();
                                            } else {
                                                jM = kVar4.m();
                                            }
                                            if (i5 == iO4) {
                                                iO5 = kVar5.o();
                                                kVar5.f(4);
                                                iO12--;
                                                if (iO12 > 0) {
                                                    iO4 = kVar5.o() - 1;
                                                } else {
                                                    iO4 = -1;
                                                }
                                            }
                                            z2 = true;
                                        }
                                        if (z2) {
                                            break;
                                        }
                                        jArr[i5] = jM;
                                        iArr[i5] = iO5;
                                    }
                                    iB = aVar3.b();
                                    j4 = iO15;
                                    i6 = 8192 / iB;
                                    iA = 0;
                                    for (i7 = 0; i7 < iO11; i7++) {
                                        iA += u.a(iArr[i7], i6);
                                    }
                                    jArr2 = new long[iA];
                                    iArr2 = new int[iA];
                                    jArr3 = new long[iA];
                                    iArr3 = new int[iA];
                                    i8 = 0;
                                    iMax = 0;
                                    i9 = 0;
                                    i10 = 0;
                                    while (i8 < iO11) {
                                        int i55 = iArr[i8];
                                        j6 = jArr[i8];
                                        long[] jArr13 = jArr;
                                        i12 = i55;
                                        while (i12 > 0) {
                                            int iMin = Math.min(i6, i12);
                                            jArr2[i10] = j6;
                                            iArr2[i10] = iB * iMin;
                                            iMax = Math.max(iMax, iArr2[i10]);
                                            jArr3[i10] = ((long) i9) * j4;
                                            iArr3[i10] = 1;
                                            j6 += (long) iArr2[i10];
                                            i9 += iMin;
                                            i12 -= iMin;
                                            i10++;
                                            iO11 = iO11;
                                            iB = iB;
                                            i6 = i6;
                                        }
                                        i8++;
                                        jArr = jArr13;
                                        iB = iB;
                                    }
                                    i11 = iMax;
                                    j5 = 0;
                                } else {
                                    jArr11 = new long[iA5];
                                    iArr14 = new int[iA5];
                                    jArr12 = new long[iA5];
                                    iArr15 = new int[iA5];
                                    i24 = iO15;
                                    i25 = iO14;
                                    i26 = iO;
                                    i27 = -1;
                                    iO6 = iO2;
                                    j5 = 0;
                                    j11 = 0;
                                    j12 = 0;
                                    int i56 = iO13;
                                    i28 = 0;
                                    iO7 = 0;
                                    iO8 = 0;
                                    i29 = 0;
                                    i30 = 0;
                                    i31 = iO3;
                                    i32 = 0;
                                    iC = 0;
                                    while (i28 < iA5) {
                                        int i57 = i29;
                                        int i58 = iA5;
                                        iO9 = i57;
                                        while (i30 == 0) {
                                            int i59 = i31;
                                            i39 = i27 + 1;
                                            if (i39 == iO11) {
                                                i30 = iO8;
                                                i40 = iO12;
                                                z12 = false;
                                            } else {
                                                if (i != 0) {
                                                    jM2 = kVar4.p();
                                                } else {
                                                    jM2 = kVar4.m();
                                                }
                                                if (i39 == iO9) {
                                                    iO8 = kVar5.o();
                                                    kVar5.f(4);
                                                    iO12--;
                                                    if (iO12 > 0) {
                                                        iO9 = kVar5.o() - 1;
                                                    } else {
                                                        iO9 = -1;
                                                    }
                                                }
                                                i30 = iO8;
                                                j12 = jM2;
                                                i40 = iO12;
                                                z12 = true;
                                            }
                                            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z12);
                                            i27 = i39;
                                            iO12 = i40;
                                            j11 = j12;
                                            i31 = i59;
                                            iO8 = i30;
                                        }
                                        i35 = i31;
                                        if (kVar8 != null) {
                                            while (iO7 == 0 && i26 > 0) {
                                                iO7 = kVar8.o();
                                                iC = kVar8.c();
                                                i26--;
                                            }
                                            iO7--;
                                        }
                                        int i60 = iC;
                                        jArr11[i28] = j11;
                                        iArr14[i28] = dVar.b();
                                        long[] jArr14 = jArr11;
                                        if (iArr14[i28] > i32) {
                                            i32 = iArr14[i28];
                                        }
                                        b.a aVar4 = dVar;
                                        int i61 = i;
                                        jArr12[i28] = j5 + ((long) i60);
                                        if (kVar7 == null) {
                                            i36 = 1;
                                        } else {
                                            i36 = 0;
                                        }
                                        iArr15[i28] = i36;
                                        if (i28 == iO6) {
                                            iArr15[i28] = 1;
                                            i37 = i35 - 1;
                                            if (i37 > 0) {
                                                iO6 = kVar7.o() - 1;
                                            }
                                            i38 = iO6;
                                        } else {
                                            i37 = i35;
                                            i38 = iO6;
                                        }
                                        j5 += (long) i24;
                                        i25--;
                                        if (i25 == 0 || i56 <= 0) {
                                            iO10 = i24;
                                        } else {
                                            int iO16 = kVar6.o();
                                            iO10 = kVar6.o();
                                            i56--;
                                            i25 = iO16;
                                        }
                                        int i62 = iO10;
                                        j11 += (long) iArr14[i28];
                                        i30--;
                                        i28++;
                                        iArr15 = iArr15;
                                        iO6 = i38;
                                        i24 = i62;
                                        dVar = aVar4;
                                        jArr11 = jArr14;
                                        iC = i60;
                                        i31 = i37;
                                        i = i61;
                                        i29 = iO9;
                                        iA5 = i58;
                                    }
                                    int[] iArr16 = iArr15;
                                    long[] jArr15 = jArr11;
                                    i33 = i31;
                                    i4 = iA5;
                                    if (iO7 == 0) {
                                        z10 = true;
                                    } else {
                                        z10 = false;
                                    }
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(z10);
                                    while (i26 > 0) {
                                        if (kVar8.o() == 0) {
                                            z11 = true;
                                        } else {
                                            z11 = false;
                                        }
                                        com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(z11);
                                        kVar8.c();
                                        i26--;
                                    }
                                    if (i33 == 0 || i25 != 0) {
                                        i34 = i30;
                                    } else {
                                        i34 = i30;
                                        if (i34 == 0 && i56 == 0) {
                                            hVar = hVarA;
                                        }
                                        jArr3 = jArr12;
                                        jArr2 = jArr15;
                                        iArr2 = iArr14;
                                        iArr3 = iArr16;
                                        i11 = i32;
                                    }
                                    hVar = hVarA;
                                    Log.w("AtomParsers", "Inconsistent stbl box for track " + hVar.a + ": remainingSynchronizationSamples " + i33 + ", remainingSamplesAtTimestampDelta " + i25 + ", remainingSamplesInChunk " + i34 + ", remainingTimestampDeltaChanges " + i56);
                                    jArr3 = jArr12;
                                    jArr2 = jArr15;
                                    iArr2 = iArr14;
                                    iArr3 = iArr16;
                                    i11 = i32;
                                }
                                if (hVar.i != null || jVar5.a()) {
                                    jVar = jVar5;
                                    u.a(jArr3, 1000000L, hVar.c);
                                    kVar = new k(jArr2, iArr2, i11, jArr3, iArr3);
                                } else {
                                    long[] jArr16 = hVar.i;
                                    if (jArr16.length == 1 && hVar.f1105b == 1 && jArr3.length >= 2) {
                                        long j15 = hVar.j[0];
                                        long jA = u.a(jArr16[0], hVar.c, hVar.d) + j15;
                                        if (jArr3[0] > j15 || j15 >= jArr3[1] || jArr3[jArr3.length - 1] >= jA || jA > j5) {
                                            jVar2 = jVar5;
                                            jArr4 = hVar.i;
                                            if (jArr4.length == 1) {
                                                c = 0;
                                                if (jArr4[0] == 0) {
                                                    i23 = 0;
                                                    while (i23 < jArr3.length) {
                                                        jArr3[i23] = u.a(jArr3[i23] - hVar.j[c], 1000000L, hVar.c);
                                                        i23++;
                                                        c = 0;
                                                    }
                                                    kVar2 = new k(jArr2, iArr2, i11, jArr3, iArr3);
                                                    kVar = kVar2;
                                                    jVar = jVar2;
                                                }
                                            }
                                            if (hVar.f1105b == 1) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            i13 = 0;
                                            i14 = 0;
                                            i15 = 0;
                                            z4 = false;
                                            while (true) {
                                                jArr5 = hVar.i;
                                                if (i13 >= jArr5.length) {
                                                    break;
                                                    break;
                                                }
                                                int[] iArr17 = iArr3;
                                                int[] iArr18 = iArr2;
                                                j10 = hVar.j[i13];
                                                if (j10 != -1) {
                                                    long jA2 = u.a(jArr5[i13], hVar.c, hVar.d);
                                                    iA4 = u.a(jArr3, j10, true, true);
                                                    int iA6 = u.a(jArr3, j10 + jA2, z3, false);
                                                    i14 += iA6 - iA4;
                                                    if (i15 != iA4) {
                                                        z9 = true;
                                                    } else {
                                                        z9 = false;
                                                    }
                                                    z4 = z9 | z4;
                                                    i15 = iA6;
                                                }
                                                i13++;
                                                iArr3 = iArr17;
                                                iArr2 = iArr18;
                                            }
                                            iArr4 = iArr3;
                                            iArr5 = iArr2;
                                            if (i14 != i4) {
                                                z5 = true;
                                            } else {
                                                z5 = false;
                                            }
                                            z6 = z5 | z4;
                                            if (z6) {
                                                jArr6 = new long[i14];
                                            } else {
                                                jArr6 = jArr2;
                                            }
                                            if (z6) {
                                                iArr6 = new int[i14];
                                            } else {
                                                iArr6 = iArr5;
                                            }
                                            if (z6) {
                                                i11 = 0;
                                            }
                                            if (z6) {
                                                iArr7 = new int[i14];
                                            } else {
                                                iArr7 = iArr4;
                                            }
                                            jArr7 = new long[i14];
                                            j7 = 0;
                                            i16 = i11;
                                            i17 = 0;
                                            i18 = 0;
                                            while (true) {
                                                jArr8 = hVar.i;
                                                if (i17 >= jArr8.length) {
                                                    break;
                                                    break;
                                                }
                                                jArr10 = jArr7;
                                                com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar6 = jVar2;
                                                j8 = hVar.j[i17];
                                                j9 = jArr8[i17];
                                                if (j8 != -1) {
                                                    iArr12 = iArr4;
                                                    iArr13 = iArr7;
                                                    long jA3 = u.a(j9, hVar.c, hVar.d) + j8;
                                                    iA2 = u.a(jArr3, j8, true, true);
                                                    iA3 = u.a(jArr3, jA3, z3, false);
                                                    if (z6) {
                                                        int i63 = iA3 - iA2;
                                                        System.arraycopy(jArr2, iA2, jArr6, i18, i63);
                                                        iArr10 = iArr5;
                                                        System.arraycopy(iArr10, iA2, iArr6, i18, i63);
                                                        iArr11 = iArr12;
                                                        iArr9 = iArr13;
                                                        System.arraycopy(iArr11, iA2, iArr9, i18, i63);
                                                    } else {
                                                        iArr10 = iArr5;
                                                        iArr9 = iArr13;
                                                        iArr11 = iArr12;
                                                    }
                                                    i20 = i16;
                                                    while (iA2 < iA3) {
                                                        int i64 = iA3;
                                                        i21 = i20;
                                                        long j16 = j8;
                                                        jArr10[i18] = u.a(j7, 1000000L, hVar.d) + u.a(jArr3[iA2] - j8, 1000000L, hVar.c);
                                                        if (z6) {
                                                            i22 = i21;
                                                            if (iArr6[i18] > i22) {
                                                                i20 = iArr10[iA2];
                                                            }
                                                            i18++;
                                                            iA2++;
                                                            j8 = j16;
                                                            iA3 = i64;
                                                        } else {
                                                            i22 = i21;
                                                        }
                                                        i20 = i22;
                                                        i18++;
                                                        iA2++;
                                                        j8 = j16;
                                                        iA3 = i64;
                                                    }
                                                    i16 = i20;
                                                } else {
                                                    iArr9 = iArr7;
                                                    iArr10 = iArr5;
                                                    z3 = z3;
                                                    iArr11 = iArr4;
                                                }
                                                j7 += j9;
                                                i17++;
                                                iArr4 = iArr11;
                                                iArr7 = iArr9;
                                                z3 = z3;
                                                jArr7 = jArr10;
                                                jVar2 = jVar6;
                                                iArr5 = iArr10;
                                            }
                                            jArr9 = jArr7;
                                            jVar = jVar2;
                                            iArr8 = iArr7;
                                            z7 = false;
                                            for (int i65 : iArr8) {
                                                if ((i65 & 1) != 0) {
                                                    z8 = true;
                                                } else {
                                                    z8 = false;
                                                }
                                                z7 |= z8;
                                            }
                                            if (!z7) {
                                                throw new l("The edited sample sequence does not contain a sync sample.");
                                            }
                                            kVar = new k(jArr6, iArr6, i16, jArr9, iArr8);
                                        } else {
                                            long jA4 = u.a(j15 - jArr3[0], hVar.f.s, hVar.c);
                                            long jA5 = u.a(j5 - jA, hVar.f.s, hVar.c);
                                            if (!(jA4 == 0 && jA5 == 0) && jA4 <= 2147483647L && jA5 <= 2147483647L) {
                                                jVar2 = jVar5;
                                                jVar2.a = (int) jA4;
                                                jVar2.f1081b = (int) jA5;
                                                u.a(jArr3, 1000000L, hVar.c);
                                                kVar2 = new k(jArr2, iArr2, i11, jArr3, iArr3);
                                            } else {
                                                jVar2 = jVar5;
                                                jArr4 = hVar.i;
                                                if (jArr4.length == 1) {
                                                    c = 0;
                                                    if (jArr4[0] == 0) {
                                                        i23 = 0;
                                                        while (i23 < jArr3.length) {
                                                            jArr3[i23] = u.a(jArr3[i23] - hVar.j[c], 1000000L, hVar.c);
                                                            i23++;
                                                            c = 0;
                                                        }
                                                        kVar2 = new k(jArr2, iArr2, i11, jArr3, iArr3);
                                                    }
                                                }
                                                if (hVar.f1105b == 1) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                i13 = 0;
                                                i14 = 0;
                                                i15 = 0;
                                                z4 = false;
                                                while (true) {
                                                    jArr5 = hVar.i;
                                                    if (i13 >= jArr5.length) {
                                                        break;
                                                        break;
                                                    }
                                                    int[] iArr19 = iArr3;
                                                    int[] iArr110 = iArr2;
                                                    j10 = hVar.j[i13];
                                                    if (j10 != -1) {
                                                        long jA6 = u.a(jArr5[i13], hVar.c, hVar.d);
                                                        iA4 = u.a(jArr3, j10, true, true);
                                                        int iA7 = u.a(jArr3, j10 + jA6, z3, false);
                                                        i14 += iA7 - iA4;
                                                        if (i15 != iA4) {
                                                            z9 = true;
                                                        } else {
                                                            z9 = false;
                                                        }
                                                        z4 = z9 | z4;
                                                        i15 = iA7;
                                                    }
                                                    i13++;
                                                    iArr3 = iArr19;
                                                    iArr2 = iArr110;
                                                }
                                                iArr4 = iArr3;
                                                iArr5 = iArr2;
                                                if (i14 != i4) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                                z6 = z5 | z4;
                                                if (z6) {
                                                    jArr6 = new long[i14];
                                                } else {
                                                    jArr6 = jArr2;
                                                }
                                                if (z6) {
                                                    iArr6 = new int[i14];
                                                } else {
                                                    iArr6 = iArr5;
                                                }
                                                if (z6) {
                                                    i11 = 0;
                                                }
                                                if (z6) {
                                                    iArr7 = new int[i14];
                                                } else {
                                                    iArr7 = iArr4;
                                                }
                                                jArr7 = new long[i14];
                                                j7 = 0;
                                                i16 = i11;
                                                i17 = 0;
                                                i18 = 0;
                                                while (true) {
                                                    jArr8 = hVar.i;
                                                    if (i17 >= jArr8.length) {
                                                        break;
                                                        break;
                                                    }
                                                    jArr10 = jArr7;
                                                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar7 = jVar2;
                                                    j8 = hVar.j[i17];
                                                    j9 = jArr8[i17];
                                                    if (j8 != -1) {
                                                        iArr12 = iArr4;
                                                        iArr13 = iArr7;
                                                        long jA7 = u.a(j9, hVar.c, hVar.d) + j8;
                                                        iA2 = u.a(jArr3, j8, true, true);
                                                        iA3 = u.a(jArr3, jA7, z3, false);
                                                        if (z6) {
                                                            int i66 = iA3 - iA2;
                                                            System.arraycopy(jArr2, iA2, jArr6, i18, i66);
                                                            iArr10 = iArr5;
                                                            System.arraycopy(iArr10, iA2, iArr6, i18, i66);
                                                            iArr11 = iArr12;
                                                            iArr9 = iArr13;
                                                            System.arraycopy(iArr11, iA2, iArr9, i18, i66);
                                                        } else {
                                                            iArr10 = iArr5;
                                                            iArr9 = iArr13;
                                                            iArr11 = iArr12;
                                                        }
                                                        i20 = i16;
                                                        while (iA2 < iA3) {
                                                            int i67 = iA3;
                                                            i21 = i20;
                                                            long j17 = j8;
                                                            jArr10[i18] = u.a(j7, 1000000L, hVar.d) + u.a(jArr3[iA2] - j8, 1000000L, hVar.c);
                                                            if (z6) {
                                                                i22 = i21;
                                                                if (iArr6[i18] > i22) {
                                                                    i20 = iArr10[iA2];
                                                                }
                                                                i18++;
                                                                iA2++;
                                                                j8 = j17;
                                                                iA3 = i67;
                                                            } else {
                                                                i22 = i21;
                                                            }
                                                            i20 = i22;
                                                            i18++;
                                                            iA2++;
                                                            j8 = j17;
                                                            iA3 = i67;
                                                        }
                                                        i16 = i20;
                                                    } else {
                                                        iArr9 = iArr7;
                                                        iArr10 = iArr5;
                                                        z3 = z3;
                                                        iArr11 = iArr4;
                                                    }
                                                    j7 += j9;
                                                    i17++;
                                                    iArr4 = iArr11;
                                                    iArr7 = iArr9;
                                                    z3 = z3;
                                                    jArr7 = jArr10;
                                                    jVar2 = jVar7;
                                                    iArr5 = iArr10;
                                                }
                                                jArr9 = jArr7;
                                                jVar = jVar2;
                                                iArr8 = iArr7;
                                                z7 = false;
                                                while (i19 < iArr8.length) {
                                                    if ((i65 & 1) != 0) {
                                                        z8 = true;
                                                    } else {
                                                        z8 = false;
                                                    }
                                                    z7 |= z8;
                                                }
                                                if (!z7) {
                                                    throw new l("The edited sample sequence does not contain a sync sample.");
                                                }
                                                kVar = new k(jArr6, iArr6, i16, jArr9, iArr8);
                                            }
                                            kVar = kVar2;
                                            jVar = jVar2;
                                        }
                                    } else {
                                        jVar2 = jVar5;
                                        jArr4 = hVar.i;
                                        if (jArr4.length == 1) {
                                            c = 0;
                                            if (jArr4[0] == 0) {
                                                i23 = 0;
                                                while (i23 < jArr3.length) {
                                                    jArr3[i23] = u.a(jArr3[i23] - hVar.j[c], 1000000L, hVar.c);
                                                    i23++;
                                                    c = 0;
                                                }
                                                kVar2 = new k(jArr2, iArr2, i11, jArr3, iArr3);
                                                kVar = kVar2;
                                                jVar = jVar2;
                                            }
                                        }
                                        if (hVar.f1105b == 1) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        i13 = 0;
                                        i14 = 0;
                                        i15 = 0;
                                        z4 = false;
                                        while (true) {
                                            jArr5 = hVar.i;
                                            if (i13 >= jArr5.length) {
                                                break;
                                            }
                                            int[] iArr111 = iArr3;
                                            int[] iArr112 = iArr2;
                                            j10 = hVar.j[i13];
                                            if (j10 != -1) {
                                                long jA8 = u.a(jArr5[i13], hVar.c, hVar.d);
                                                iA4 = u.a(jArr3, j10, true, true);
                                                int iA8 = u.a(jArr3, j10 + jA8, z3, false);
                                                i14 += iA8 - iA4;
                                                if (i15 != iA4) {
                                                    z9 = true;
                                                } else {
                                                    z9 = false;
                                                }
                                                z4 = z9 | z4;
                                                i15 = iA8;
                                            }
                                            i13++;
                                            iArr3 = iArr111;
                                            iArr2 = iArr112;
                                        }
                                        iArr4 = iArr3;
                                        iArr5 = iArr2;
                                        if (i14 != i4) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                        z6 = z5 | z4;
                                        if (z6) {
                                            jArr6 = new long[i14];
                                        } else {
                                            jArr6 = jArr2;
                                        }
                                        if (z6) {
                                            iArr6 = new int[i14];
                                        } else {
                                            iArr6 = iArr5;
                                        }
                                        if (z6) {
                                            i11 = 0;
                                        }
                                        if (z6) {
                                            iArr7 = new int[i14];
                                        } else {
                                            iArr7 = iArr4;
                                        }
                                        jArr7 = new long[i14];
                                        j7 = 0;
                                        i16 = i11;
                                        i17 = 0;
                                        i18 = 0;
                                        while (true) {
                                            jArr8 = hVar.i;
                                            if (i17 >= jArr8.length) {
                                                break;
                                            }
                                            jArr10 = jArr7;
                                            com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar8 = jVar2;
                                            j8 = hVar.j[i17];
                                            j9 = jArr8[i17];
                                            if (j8 != -1) {
                                                iArr12 = iArr4;
                                                iArr13 = iArr7;
                                                long jA9 = u.a(j9, hVar.c, hVar.d) + j8;
                                                iA2 = u.a(jArr3, j8, true, true);
                                                iA3 = u.a(jArr3, jA9, z3, false);
                                                if (z6) {
                                                    int i68 = iA3 - iA2;
                                                    System.arraycopy(jArr2, iA2, jArr6, i18, i68);
                                                    iArr10 = iArr5;
                                                    System.arraycopy(iArr10, iA2, iArr6, i18, i68);
                                                    iArr11 = iArr12;
                                                    iArr9 = iArr13;
                                                    System.arraycopy(iArr11, iA2, iArr9, i18, i68);
                                                } else {
                                                    iArr10 = iArr5;
                                                    iArr9 = iArr13;
                                                    iArr11 = iArr12;
                                                }
                                                i20 = i16;
                                                while (iA2 < iA3) {
                                                    int i69 = iA3;
                                                    i21 = i20;
                                                    long j18 = j8;
                                                    jArr10[i18] = u.a(j7, 1000000L, hVar.d) + u.a(jArr3[iA2] - j8, 1000000L, hVar.c);
                                                    if (z6) {
                                                        i22 = i21;
                                                        if (iArr6[i18] > i22) {
                                                            i20 = iArr10[iA2];
                                                        }
                                                        i18++;
                                                        iA2++;
                                                        j8 = j18;
                                                        iA3 = i69;
                                                    } else {
                                                        i22 = i21;
                                                    }
                                                    i20 = i22;
                                                    i18++;
                                                    iA2++;
                                                    j8 = j18;
                                                    iA3 = i69;
                                                }
                                                i16 = i20;
                                            } else {
                                                iArr9 = iArr7;
                                                iArr10 = iArr5;
                                                z3 = z3;
                                                iArr11 = iArr4;
                                            }
                                            j7 += j9;
                                            i17++;
                                            iArr4 = iArr11;
                                            iArr7 = iArr9;
                                            z3 = z3;
                                            jArr7 = jArr10;
                                            jVar2 = jVar8;
                                            iArr5 = iArr10;
                                        }
                                        jArr9 = jArr7;
                                        jVar = jVar2;
                                        iArr8 = iArr7;
                                        z7 = false;
                                        while (i19 < iArr8.length && !z7) {
                                            if ((i65 & 1) != 0) {
                                                z8 = true;
                                            } else {
                                                z8 = false;
                                            }
                                            z7 |= z8;
                                        }
                                        if (!z7) {
                                            throw new l("The edited sample sequence does not contain a sync sample.");
                                        }
                                        kVar = new k(jArr6, iArr6, i16, jArr9, iArr8);
                                    }
                                }
                            } else {
                                i2 = i54;
                            }
                            z = false;
                            if (z) {
                                jArr11 = new long[iA5];
                                iArr14 = new int[iA5];
                                jArr12 = new long[iA5];
                                iArr15 = new int[iA5];
                                i24 = iO15;
                                i25 = iO14;
                                i26 = iO;
                                i27 = -1;
                                iO6 = iO2;
                                j5 = 0;
                                j11 = 0;
                                j12 = 0;
                                int i510 = iO13;
                                i28 = 0;
                                iO7 = 0;
                                iO8 = 0;
                                i29 = 0;
                                i30 = 0;
                                i31 = iO3;
                                i32 = 0;
                                iC = 0;
                                while (i28 < iA5) {
                                    int i511 = i29;
                                    int i512 = iA5;
                                    iO9 = i511;
                                    while (i30 == 0) {
                                        int i513 = i31;
                                        i39 = i27 + 1;
                                        if (i39 == iO11) {
                                            i30 = iO8;
                                            i40 = iO12;
                                            z12 = false;
                                        } else {
                                            if (i != 0) {
                                                jM2 = kVar4.p();
                                            } else {
                                                jM2 = kVar4.m();
                                            }
                                            if (i39 == iO9) {
                                                iO8 = kVar5.o();
                                                kVar5.f(4);
                                                iO12--;
                                                if (iO12 > 0) {
                                                    iO9 = kVar5.o() - 1;
                                                } else {
                                                    iO9 = -1;
                                                }
                                            }
                                            i30 = iO8;
                                            j12 = jM2;
                                            i40 = iO12;
                                            z12 = true;
                                        }
                                        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z12);
                                        i27 = i39;
                                        iO12 = i40;
                                        j11 = j12;
                                        i31 = i513;
                                        iO8 = i30;
                                    }
                                    i35 = i31;
                                    if (kVar8 != null) {
                                        while (iO7 == 0) {
                                            iO7 = kVar8.o();
                                            iC = kVar8.c();
                                            i26--;
                                        }
                                        iO7--;
                                    }
                                    int i610 = iC;
                                    jArr11[i28] = j11;
                                    iArr14[i28] = dVar.b();
                                    long[] jArr17 = jArr11;
                                    if (iArr14[i28] > i32) {
                                        i32 = iArr14[i28];
                                    }
                                    b.a aVar5 = dVar;
                                    int i611 = i;
                                    jArr12[i28] = j5 + ((long) i610);
                                    if (kVar7 == null) {
                                        i36 = 1;
                                    } else {
                                        i36 = 0;
                                    }
                                    iArr15[i28] = i36;
                                    if (i28 == iO6) {
                                        iArr15[i28] = 1;
                                        i37 = i35 - 1;
                                        if (i37 > 0) {
                                            iO6 = kVar7.o() - 1;
                                        }
                                        i38 = iO6;
                                    } else {
                                        i37 = i35;
                                        i38 = iO6;
                                    }
                                    j5 += (long) i24;
                                    i25--;
                                    if (i25 == 0) {
                                        iO10 = i24;
                                    } else {
                                        iO10 = i24;
                                    }
                                    int i612 = iO10;
                                    j11 += (long) iArr14[i28];
                                    i30--;
                                    i28++;
                                    iArr15 = iArr15;
                                    iO6 = i38;
                                    i24 = i612;
                                    dVar = aVar5;
                                    jArr11 = jArr17;
                                    iC = i610;
                                    i31 = i37;
                                    i = i611;
                                    i29 = iO9;
                                    iA5 = i512;
                                }
                                int[] iArr113 = iArr15;
                                long[] jArr18 = jArr11;
                                i33 = i31;
                                i4 = iA5;
                                if (iO7 == 0) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(z10);
                                while (i26 > 0) {
                                    if (kVar8.o() == 0) {
                                        z11 = true;
                                    } else {
                                        z11 = false;
                                    }
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(z11);
                                    kVar8.c();
                                    i26--;
                                }
                                if (i33 == 0) {
                                    i34 = i30;
                                    hVar = hVarA;
                                    Log.w("AtomParsers", "Inconsistent stbl box for track " + hVar.a + ": remainingSynchronizationSamples " + i33 + ", remainingSamplesAtTimestampDelta " + i25 + ", remainingSamplesInChunk " + i34 + ", remainingTimestampDeltaChanges " + i510);
                                } else {
                                    i34 = i30;
                                    hVar = hVarA;
                                    Log.w("AtomParsers", "Inconsistent stbl box for track " + hVar.a + ": remainingSynchronizationSamples " + i33 + ", remainingSamplesAtTimestampDelta " + i25 + ", remainingSamplesInChunk " + i34 + ", remainingTimestampDeltaChanges " + i510);
                                }
                                jArr3 = jArr12;
                                jArr2 = jArr18;
                                iArr2 = iArr14;
                                iArr3 = iArr113;
                                i11 = i32;
                            } else {
                                b.a aVar6 = dVar;
                                i3 = i;
                                hVar = hVarA;
                                i4 = iA5;
                                jArr = new long[iO11];
                                iArr = new int[iO11];
                                i5 = -1;
                                jM = 0;
                                iO4 = 0;
                                iO5 = 0;
                                while (true) {
                                    i5++;
                                    if (i5 == iO11) {
                                        z2 = false;
                                    } else {
                                        if (i3 != 0) {
                                            jM = kVar4.p();
                                        } else {
                                            jM = kVar4.m();
                                        }
                                        if (i5 == iO4) {
                                            iO5 = kVar5.o();
                                            kVar5.f(4);
                                            iO12--;
                                            if (iO12 > 0) {
                                                iO4 = kVar5.o() - 1;
                                            } else {
                                                iO4 = -1;
                                            }
                                        }
                                        z2 = true;
                                    }
                                    if (z2) {
                                        break;
                                        break;
                                    } else {
                                        jArr[i5] = jM;
                                        iArr[i5] = iO5;
                                    }
                                }
                                iB = aVar6.b();
                                j4 = iO15;
                                i6 = 8192 / iB;
                                iA = 0;
                                while (i7 < iO11) {
                                    iA += u.a(iArr[i7], i6);
                                }
                                jArr2 = new long[iA];
                                iArr2 = new int[iA];
                                jArr3 = new long[iA];
                                iArr3 = new int[iA];
                                i8 = 0;
                                iMax = 0;
                                i9 = 0;
                                i10 = 0;
                                while (i8 < iO11) {
                                    int i514 = iArr[i8];
                                    j6 = jArr[i8];
                                    long[] jArr19 = jArr;
                                    i12 = i514;
                                    while (i12 > 0) {
                                        int iMin2 = Math.min(i6, i12);
                                        jArr2[i10] = j6;
                                        iArr2[i10] = iB * iMin2;
                                        iMax = Math.max(iMax, iArr2[i10]);
                                        jArr3[i10] = ((long) i9) * j4;
                                        iArr3[i10] = 1;
                                        j6 += (long) iArr2[i10];
                                        i9 += iMin2;
                                        i12 -= iMin2;
                                        i10++;
                                        iO11 = iO11;
                                        iB = iB;
                                        i6 = i6;
                                    }
                                    i8++;
                                    jArr = jArr19;
                                    iB = iB;
                                }
                                i11 = iMax;
                                j5 = 0;
                            }
                            if (hVar.i != null) {
                                jVar = jVar5;
                                u.a(jArr3, 1000000L, hVar.c);
                                kVar = new k(jArr2, iArr2, i11, jArr3, iArr3);
                            } else {
                                jVar = jVar5;
                                u.a(jArr3, 1000000L, hVar.c);
                                kVar = new k(jArr2, iArr2, i11, jArr3, iArr3);
                            }
                        }
                        if (kVar.a != 0) {
                            int i70 = i2;
                            n nVarA = this.l.a(i70, hVar.f1105b);
                            a aVar7 = new a(hVar, kVar, nVarA);
                            int i71 = kVar.d + 30;
                            com.fyber.inneractive.sdk.player.exoplayer2.i iVar = hVar.f;
                            String str2 = iVar.a;
                            String str3 = iVar.e;
                            String str4 = iVar.f;
                            String str5 = iVar.c;
                            int i72 = iVar.f1156b;
                            int i73 = iVar.j;
                            int i74 = iVar.k;
                            float f = iVar.l;
                            i41 = i70;
                            int i75 = iVar.m;
                            k kVar9 = kVar;
                            float f2 = iVar.n;
                            byte[] bArr = iVar.p;
                            int i76 = iVar.o;
                            com.fyber.inneractive.sdk.player.exoplayer2.video.b bVar = iVar.q;
                            int i77 = iVar.r;
                            int i78 = iVar.s;
                            int i79 = iVar.t;
                            int i80 = iVar.u;
                            int i81 = iVar.v;
                            int i82 = iVar.x;
                            String str6 = iVar.y;
                            int i83 = iVar.z;
                            long j19 = iVar.w;
                            com.fyber.inneractive.sdk.player.exoplayer2.i iVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.i(str2, str3, str4, str5, i72, i71, i73, i74, f, i75, f2, bArr, i76, bVar, i77, i78, i79, i80, i81, i82, str6, i83, j19, iVar.h, iVar.i, iVar.d);
                            if (hVar.f1105b == 1) {
                                if (jVar.a()) {
                                    jVar3 = jVar;
                                    iVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.i(str2, str3, str4, str5, i72, i71, i73, i74, f, i75, f2, bArr, i76, bVar, i77, i78, i79, jVar3.a, jVar3.f1081b, i82, str6, i83, j19, iVar2.h, iVar2.i, iVar2.d);
                                } else {
                                    jVar3 = jVar;
                                }
                                if (aVar2 != null) {
                                    iVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.i(iVar2.a, iVar2.e, iVar2.f, iVar2.c, iVar2.f1156b, iVar2.g, iVar2.j, iVar2.k, iVar2.l, iVar2.m, iVar2.n, iVar2.p, iVar2.o, iVar2.q, iVar2.r, iVar2.s, iVar2.t, iVar2.u, iVar2.v, iVar2.x, iVar2.y, iVar2.z, iVar2.w, iVar2.h, iVar2.i, aVar2);
                                }
                            } else {
                                jVar3 = jVar;
                            }
                            nVarA.a(iVar2);
                            jMax = Math.max(j3, hVar.e);
                            arrayList = arrayList;
                            arrayList.add(aVar7);
                            i42 = 0;
                            j14 = kVar9.f1108b[0];
                            if (j14 >= j2) {
                                j14 = j2;
                            }
                        }
                        i54 = i41 + 1;
                        jVar5 = jVar3;
                        i44 = i42;
                        c0290aPop = c0290a;
                        j13 = jMax;
                        aVar = aVar2;
                        fVar = this;
                    } else {
                        c0290a = c0290aPop;
                        aVar2 = aVar;
                        j3 = j13;
                        arrayList = arrayList;
                        j2 = j14;
                        jVar = jVar5;
                        i2 = i54;
                    }
                    arrayList = arrayList;
                    jVar3 = jVar;
                    j14 = j2;
                    jMax = j3;
                    i41 = i2;
                    i42 = 0;
                    i54 = i41 + 1;
                    jVar5 = jVar3;
                    i44 = i42;
                    c0290aPop = c0290a;
                    j13 = jMax;
                    aVar = aVar2;
                    fVar = this;
                }
                fVar.n = j13;
                fVar.m = (a[]) arrayList.toArray(new a[arrayList.size()]);
                fVar.l.c();
                fVar.l.a(fVar);
                fVar.d.clear();
                fVar.e = 2;
            } else if (!fVar.d.isEmpty()) {
                fVar.d.peek().R0.add(c0290aPop);
            }
        }
        if (fVar.e != 2) {
            d();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void a(long j, long j2) {
        this.d.clear();
        this.h = 0;
        this.j = 0;
        this.k = 0;
        if (j == 0) {
            d();
            return;
        }
        a[] aVarArr = this.m;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                k kVar = aVar.f1104b;
                int iA = kVar.a(j2);
                if (iA == -1) {
                    iA = kVar.b(j2);
                }
                aVar.d = iA;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:102:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:104:0x0220  */
    /* JADX WARN: Code duplicated, block: B:105:0x0224  */
    /* JADX WARN: Code duplicated, block: B:107:0x022a  */
    /* JADX WARN: Code duplicated, block: B:141:0x026d  */
    /* JADX WARN: Code duplicated, block: B:143:0x0270  */
    /* JADX WARN: Code duplicated, block: B:145:0x0274  */
    /* JADX WARN: Code duplicated, block: B:146:0x0276  */
    /* JADX WARN: Code duplicated, block: B:149:0x0283  */
    /* JADX WARN: Code duplicated, block: B:150:0x0285  */
    /* JADX WARN: Code duplicated, block: B:152:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:158:0x0190 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:163:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x018d  */
    /* JADX WARN: Code duplicated, block: B:85:0x01c7  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l lVar) throws InterruptedException, IOException {
        a[] aVarArr;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        int i2;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        long j;
        while (true) {
            int i3 = this.e;
            if (i3 == 0) {
                if (this.h == 0) {
                    if (((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.c.a, 0, 8, true)) {
                        this.h = 8;
                        this.c.e(0);
                        this.g = this.c.m();
                        this.f = this.c.c();
                        if (this.g == 1) {
                            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.c.a, 8, 8, false);
                            this.h += 8;
                            this.g = this.c.p();
                        }
                        i2 = this.f;
                        if (i2 != com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C || i2 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.E || i2 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.F || i2 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.G || i2 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.H || i2 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.Q) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            j = (((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).c + this.g) - ((long) this.h);
                            this.d.add(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0290a(this.f, j));
                            if (this.g == this.h) {
                                c(j);
                            } else {
                                d();
                            }
                            z6 = true;
                        } else {
                            if (i2 != com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.S || i2 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.D || i2 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.T || i2 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.U || i2 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.m0 || i2 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.n0 || i2 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.o0 || i2 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.R || i2 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.p0 || i2 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.q0 || i2 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.r0 || i2 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.s0 || i2 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.t0 || i2 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.P || i2 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.f1093b || i2 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.A0) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (z5) {
                                if (this.h == 8) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z7);
                                if (this.g <= 2147483647L) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z8);
                                com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.k((int) this.g);
                                this.i = kVar;
                                System.arraycopy(this.c.a, 0, kVar.a, 0, 8);
                                z6 = true;
                                this.e = 1;
                            } else {
                                z6 = true;
                                this.i = null;
                                this.e = 1;
                            }
                        }
                        z9 = z6;
                    } else {
                        z9 = false;
                    }
                } else {
                    if (this.g == 1) {
                        ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.c.a, 8, 8, false);
                        this.h += 8;
                        this.g = this.c.p();
                    }
                    i2 = this.f;
                    if (i2 != com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (z4) {
                        j = (((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).c + this.g) - ((long) this.h);
                        this.d.add(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0290a(this.f, j));
                        if (this.g == this.h) {
                            c(j);
                        } else {
                            d();
                        }
                        z6 = true;
                    } else {
                        if (i2 != com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.S) {
                            z5 = true;
                        } else {
                            z5 = true;
                        }
                        if (z5) {
                            if (this.h == 8) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z7);
                            if (this.g <= 2147483647L) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z8);
                            com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.util.k((int) this.g);
                            this.i = kVar2;
                            System.arraycopy(this.c.a, 0, kVar2.a, 0, 8);
                            z6 = true;
                            this.e = 1;
                        } else {
                            z6 = true;
                            this.i = null;
                            this.e = 1;
                        }
                    }
                    z9 = z6;
                }
                if (!z9) {
                    return -1;
                }
            } else {
                if (i3 != 1) {
                    if (i3 != 2) {
                        throw new IllegalStateException();
                    }
                    long j2 = Long.MAX_VALUE;
                    int i4 = -1;
                    int i5 = 0;
                    while (true) {
                        aVarArr = this.m;
                        if (i5 >= aVarArr.length) {
                            break;
                        }
                        a aVar = aVarArr[i5];
                        int i6 = aVar.d;
                        k kVar3 = aVar.f1104b;
                        if (i6 != kVar3.a) {
                            long j3 = kVar3.f1108b[i6];
                            if (j3 < j2) {
                                i4 = i5;
                                j2 = j3;
                            }
                        }
                        i5++;
                    }
                    if (i4 == -1) {
                        return -1;
                    }
                    a aVar2 = aVarArr[i4];
                    n nVar = aVar2.c;
                    int i7 = aVar2.d;
                    k kVar4 = aVar2.f1104b;
                    long j4 = kVar4.f1108b[i7];
                    int i8 = kVar4.c[i7];
                    if (aVar2.a.g == 1) {
                        j4 += 8;
                        i8 -= 8;
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
                    int i9 = i8;
                    long j5 = (j4 - bVar.c) + ((long) this.j);
                    if (j5 >= 0 && j5 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                        bVar.c((int) j5);
                        int i10 = aVar2.a.k;
                        if (i10 == 0) {
                            while (true) {
                                int i11 = this.j;
                                i = i9;
                                if (i11 >= i) {
                                    break;
                                }
                                int iA = nVar.a(gVar, i - i11, false);
                                this.j += iA;
                                this.k -= iA;
                                i9 = i;
                            }
                        } else {
                            byte[] bArr = this.f1103b.a;
                            boolean z10 = false;
                            bArr[0] = 0;
                            bArr[1] = 0;
                            bArr[2] = 0;
                            int i12 = 4 - i10;
                            i = i9;
                            while (this.j < i) {
                                int i13 = this.k;
                                if (i13 == 0) {
                                    bVar.b(this.f1103b.a, i12, i10, z10);
                                    this.f1103b.e(z10 ? 1 : 0);
                                    this.k = this.f1103b.o();
                                    this.a.e(z10 ? 1 : 0);
                                    nVar.a(this.a, 4);
                                    this.j += 4;
                                    i += i12;
                                } else {
                                    int iA2 = nVar.a(gVar, i13, z10);
                                    this.j += iA2;
                                    this.k -= iA2;
                                    z10 = false;
                                }
                            }
                        }
                        k kVar5 = aVar2.f1104b;
                        nVar.a(kVar5.e[i7], kVar5.f[i7], i, 0, null);
                        aVar2.d++;
                        this.j = 0;
                        this.k = 0;
                        return 0;
                    }
                    lVar.a = j4;
                    return 1;
                }
                long j6 = this.g;
                int i14 = this.h;
                long j7 = j6 - ((long) i14);
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar2 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
                long j8 = bVar2.c + j7;
                com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar6 = this.i;
                if (kVar6 != null) {
                    bVar2.b(kVar6.a, i14, (int) j7, false);
                    if (this.f == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.f1093b) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar7 = this.i;
                        kVar7.e(8);
                        if (kVar7.c() != p) {
                            kVar7.f(4);
                            while (true) {
                                if (kVar7.a() <= 0) {
                                    z3 = false;
                                    break;
                                }
                                if (kVar7.c() == p) {
                                    z3 = true;
                                    break;
                                }
                            }
                        } else {
                            z3 = true;
                            break;
                        }
                        this.o = z3;
                    } else if (!this.d.isEmpty()) {
                        this.d.peek().Q0.add(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(this.f, this.i));
                    }
                } else {
                    if (j7 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                        bVar2.c((int) j7);
                    } else {
                        lVar.a = j8;
                        z = true;
                    }
                    c(j8);
                    if (z || this.e == 2) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        return 1;
                    }
                }
                z = false;
                c(j8);
                if (z) {
                    z2 = false;
                } else {
                    z2 = false;
                }
                if (z2) {
                    return 1;
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.m
    public long a(long j) {
        long j2 = Long.MAX_VALUE;
        for (a aVar : this.m) {
            k kVar = aVar.f1104b;
            int iA = kVar.a(j);
            if (iA == -1) {
                iA = kVar.b(j);
            }
            long j3 = kVar.f1108b[iA];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }
}
