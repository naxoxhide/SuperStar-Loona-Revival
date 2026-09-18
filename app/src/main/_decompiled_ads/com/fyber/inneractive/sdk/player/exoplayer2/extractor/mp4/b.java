package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final int a = u.a("vide");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f1094b = u.a("soun");
    public static final int c = u.a("text");
    public static final int d = u.a("sbtl");
    public static final int e = u.a("subt");
    public static final int f = u.a("clcp");
    public static final int g = u.a("cenc");
    public static final int h = u.a("meta");

    public interface a {
        int a();

        int b();

        boolean c();
    }

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b$b, reason: collision with other inner class name */
    public static final class C0291b {
        public final i[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.fyber.inneractive.sdk.player.exoplayer2.i f1095b;
        public int c;
        public int d = 0;

        public C0291b(int i) {
            this.a = new i[i];
        }
    }

    public static final class c implements a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1096b;
        public final com.fyber.inneractive.sdk.player.exoplayer2.util.k c;

        public c(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b bVar) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar = bVar.P0;
            this.c = kVar;
            kVar.e(12);
            this.a = kVar.o();
            this.f1096b = kVar.o();
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b.a
        public int a() {
            return this.f1096b;
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b.a
        public int b() {
            int i = this.a;
            return i == 0 ? this.c.o() : i;
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b.a
        public boolean c() {
            return this.a != 0;
        }
    }

    public static final class d implements a {
        public final com.fyber.inneractive.sdk.player.exoplayer2.util.k a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1097b;
        public final int c;
        public int d;
        public int e;

        public d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b bVar) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar = bVar.P0;
            this.a = kVar;
            kVar.e(12);
            this.c = kVar.o() & 255;
            this.f1097b = kVar.o();
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b.a
        public int a() {
            return this.f1097b;
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b.a
        public int b() {
            int i = this.c;
            if (i == 8) {
                return this.a.l();
            }
            if (i == 16) {
                return this.a.q();
            }
            int i2 = this.d;
            this.d = i2 + 1;
            if (i2 % 2 != 0) {
                return this.e & 15;
            }
            int iL = this.a.l();
            this.e = iL;
            return (iL & 240) >> 4;
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b.a
        public boolean c() {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:298:0x055f  */
    /* JADX WARN: Code duplicated, block: B:300:0x0592  */
    /* JADX WARN: Code duplicated, block: B:301:0x059c  */
    /* JADX WARN: Code duplicated, block: B:305:0x05ad  */
    /* JADX WARN: Code duplicated, block: B:307:0x05b8  */
    /* JADX WARN: Code duplicated, block: B:312:0x05c3  */
    /* JADX WARN: Code duplicated, block: B:313:0x05c5  */
    /* JADX WARN: Code duplicated, block: B:316:0x05d1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:317:0x05d3  */
    /* JADX WARN: Code duplicated, block: B:318:0x05d5  */
    /* JADX WARN: Code duplicated, block: B:321:0x05ea  */
    /* JADX WARN: Code duplicated, block: B:323:0x05f1  */
    /* JADX WARN: Code duplicated, block: B:325:0x05f5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:326:0x05f7  */
    /* JADX WARN: Code duplicated, block: B:327:0x05f9  */
    /* JADX WARN: Code duplicated, block: B:330:0x0612 A[PHI: r23 r26 r33 r35 r36
      0x0612: PHI (r23v8 boolean) = (r23v2 boolean), (r23v4 boolean), (r23v6 boolean), (r23v9 boolean) binds: [B:367:0x06a7, B:363:0x068d, B:346:0x0639, B:329:0x060e] A[DONT_GENERATE, DONT_INLINE]
      0x0612: PHI (r26v10 java.lang.String) = (r26v1 java.lang.String), (r26v1 java.lang.String), (r26v5 java.lang.String), (r26v11 java.lang.String) binds: [B:367:0x06a7, B:363:0x068d, B:346:0x0639, B:329:0x060e] A[DONT_GENERATE, DONT_INLINE]
      0x0612: PHI (r33v5 java.util.List<byte[]>) = 
      (r33v1 java.util.List<byte[]>)
      (r33v1 java.util.List<byte[]>)
      (r33v3 java.util.List<byte[]>)
      (r33v6 java.util.List<byte[]>)
     binds: [B:367:0x06a7, B:363:0x068d, B:346:0x0639, B:329:0x060e] A[DONT_GENERATE, DONT_INLINE]
      0x0612: PHI (r35v4 float) = (r35v1 float), (r35v1 float), (r35v1 float), (r35v5 float) binds: [B:367:0x06a7, B:363:0x068d, B:346:0x0639, B:329:0x060e] A[DONT_GENERATE, DONT_INLINE]
      0x0612: PHI (r36v5 byte[]) = (r36v1 byte[]), (r36v3 byte[]), (r36v1 byte[]), (r36v1 byte[]) binds: [B:367:0x06a7, B:363:0x068d, B:346:0x0639, B:329:0x060e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:331:0x0615  */
    /* JADX WARN: Code duplicated, block: B:333:0x0619 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:334:0x061b  */
    /* JADX WARN: Code duplicated, block: B:335:0x061d  */
    /* JADX WARN: Code duplicated, block: B:338:0x0625  */
    /* JADX WARN: Code duplicated, block: B:339:0x0628  */
    /* JADX WARN: Code duplicated, block: B:340:0x062b  */
    /* JADX WARN: Code duplicated, block: B:342:0x062f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:343:0x0631  */
    /* JADX WARN: Code duplicated, block: B:344:0x0633  */
    /* JADX WARN: Code duplicated, block: B:347:0x063c  */
    /* JADX WARN: Code duplicated, block: B:349:0x0640 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:350:0x0642  */
    /* JADX WARN: Code duplicated, block: B:351:0x0644  */
    /* JADX WARN: Code duplicated, block: B:353:0x0659  */
    /* JADX WARN: Code duplicated, block: B:355:0x065d  */
    /* JADX WARN: Code duplicated, block: B:356:0x0672  */
    /* JADX WARN: Code duplicated, block: B:358:0x0676  */
    /* JADX WARN: Code duplicated, block: B:361:0x067c  */
    /* JADX WARN: Code duplicated, block: B:364:0x0698 A[LOOP:5: B:359:0x0678->B:364:0x0698, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:366:0x06a3  */
    /* JADX WARN: Code duplicated, block: B:368:0x06a9  */
    /* JADX WARN: Code duplicated, block: B:370:0x06b3  */
    /* JADX WARN: Code duplicated, block: B:372:0x06b9  */
    /* JADX WARN: Code duplicated, block: B:374:0x06bc  */
    /* JADX WARN: Code duplicated, block: B:376:0x06bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:378:0x06c2  */
    /* JADX WARN: Code duplicated, block: B:379:0x06c5  */
    /* JADX WARN: Code duplicated, block: B:380:0x06c8  */
    /* JADX WARN: Code duplicated, block: B:381:0x06cb  */
    /* JADX WARN: Code duplicated, block: B:386:0x06db  */
    /* JADX WARN: Code duplicated, block: B:409:0x078c  */
    /* JADX WARN: Code duplicated, block: B:412:0x0795  */
    /* JADX WARN: Code duplicated, block: B:413:0x0797  */
    /* JADX WARN: Code duplicated, block: B:421:0x06f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:435:0x06cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:439:0x06cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:440:0x069d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:441:0x068d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x00c5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:61:0x00d0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00d2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:66:0x00db  */
    /* JADX WARN: Code duplicated, block: B:69:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:74:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:78:0x0108  */
    /* JADX WARN: Code duplicated, block: B:81:0x0134  */
    /* JADX WARN: Code duplicated, block: B:82:0x0136  */
    /* JADX WARN: Code duplicated, block: B:85:0x0141  */
    /* JADX WARN: Code duplicated, block: B:86:0x0143  */
    /* JADX WARN: Code duplicated, block: B:89:0x019e  */
    /* JADX WARN: Code duplicated, block: B:91:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:92:0x01a8  */
    public static h a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0290a c0290a, com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b bVar, long j, com.fyber.inneractive.sdk.player.exoplayer2.drm.a aVar, boolean z) throws l {
        int i;
        boolean z2;
        long jM;
        int iC;
        int i2;
        long j2;
        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar;
        int i3;
        long jM2;
        int iB;
        int i4;
        int i5;
        Pair pairCreate;
        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar2;
        int iC2;
        C0291b c0291b;
        int i6;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0290a c0290aC;
        h hVar;
        Pair pairCreate2;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b bVarD;
        int i7;
        int iC3;
        boolean z3;
        int iC4;
        int i8;
        Object obj;
        long j3;
        int i9;
        int iQ;
        int iQ2;
        int i10;
        int i11;
        int i12;
        float fO;
        int i13;
        boolean z4;
        String str;
        List<byte[]> listSingletonList;
        byte[] bArrCopyOfRange;
        int i14;
        int iC5;
        boolean z5;
        int iC6;
        boolean z6;
        int iL;
        int iL2;
        int i15;
        int iC7;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        List<byte[]> list;
        boolean z11;
        com.fyber.inneractive.sdk.player.exoplayer2.video.a aVarB;
        int iQ3;
        int iRound;
        int iO;
        String str2;
        int i16;
        String str3;
        String str4;
        String str5;
        long j4;
        List listSingletonList2;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0290a c0290aC2 = c0290a.c(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.F);
        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar3 = c0290aC2.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.T).P0;
        kVar3.e(16);
        int iC8 = kVar3.c();
        if (iC8 == f1094b) {
            i = 1;
        } else if (iC8 == a) {
            i = 2;
        } else if (iC8 == c || iC8 == d || iC8 == e || iC8 == f) {
            i = 3;
        } else {
            i = iC8 == h ? 4 : -1;
        }
        if (i == -1) {
            return null;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar4 = c0290a.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.P).P0;
        kVar4.e(8);
        int iB2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(kVar4.c());
        kVar4.f(iB2 == 0 ? 8 : 16);
        int iC9 = kVar4.c();
        kVar4.f(4);
        int i17 = kVar4.f1236b;
        int i18 = iB2 == 0 ? 4 : 8;
        int i19 = 0;
        while (true) {
            if (i19 >= i18) {
                z2 = true;
                break;
            }
            if (kVar4.a[i17 + i19] != -1) {
                z2 = false;
                break;
            }
            i19++;
        }
        if (!z2) {
            jM = iB2 == 0 ? kVar4.m() : kVar4.p();
            if (jM == 0) {
            }
            kVar4.f(16);
            iC = kVar4.c();
            int iC10 = kVar4.c();
            kVar4.f(4);
            int iC11 = kVar4.c();
            int iC12 = kVar4.c();
            if (iC != 0 && iC10 == 65536 && iC11 == -65536 && iC12 == 0) {
                i2 = 90;
            } else if (iC != 0 && iC10 == -65536 && iC11 == 65536 && iC12 == 0) {
                i2 = 270;
            } else if (iC != -65536 && iC10 == 0 && iC11 == 0 && iC12 == -65536) {
                i2 = 180;
            } else {
                i2 = 0;
            }
            if (j == -9223372036854775807L) {
                j2 = jM;
            } else {
                j2 = j;
            }
            kVar = bVar.P0;
            kVar.e(8);
            if (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(kVar.c()) == 0) {
                i3 = 8;
            } else {
                i3 = 16;
            }
            kVar.f(i3);
            jM2 = kVar.m();
            long jA = j2 != -9223372036854775807L ? u.a(j2, 1000000L, jM2) : -9223372036854775807L;
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0290a c0290aC3 = c0290aC2.c(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.G).c(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.H);
            com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar5 = c0290aC2.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.S).P0;
            kVar5.e(8);
            iB = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(kVar5.c());
            if (iB == 0) {
                i4 = 8;
            } else {
                i4 = 16;
            }
            kVar5.f(i4);
            long jM3 = kVar5.m();
            if (iB == 0) {
                i5 = 4;
            } else {
                i5 = 8;
            }
            kVar5.f(i5);
            int iQ4 = kVar5.q();
            pairCreate = Pair.create(Long.valueOf(jM3), "" + ((char) (((iQ4 >> 10) & 31) + 96)) + ((char) (((iQ4 >> 5) & 31) + 96)) + ((char) ((iQ4 & 31) + 96)));
            kVar2 = c0290aC3.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.U).P0;
            String str6 = (String) pairCreate.second;
            kVar2.e(12);
            iC2 = kVar2.c();
            c0291b = new C0291b(iC2);
            i6 = 0;
            while (i6 < iC2) {
                i7 = kVar2.f1236b;
                iC3 = kVar2.c();
                if (iC3 > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                String str7 = "childAtomSize should be positive";
                com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(z3, "childAtomSize should be positive");
                iC4 = kVar2.c();
                int i20 = iC2;
                if (iC4 != com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.c || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.d || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.a0 || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.l0 || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.e || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.f || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.g || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.K0 || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.L0) {
                    pairCreate = pairCreate;
                    i8 = i2;
                    obj = "childAtomSize should be positive";
                    j3 = jM2;
                    i = i;
                    i9 = i6;
                    kVar2.e(i7 + 8 + 8);
                    kVar2.f(16);
                    iQ = kVar2.q();
                    iQ2 = kVar2.q();
                    kVar2.f(50);
                    i10 = kVar2.f1236b;
                    i11 = iC3;
                    if (iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.a0) {
                        i12 = i9;
                        iC4 = a(kVar2, i7, i11, c0291b, i12);
                        kVar2.e(i10);
                    } else {
                        i12 = i9;
                    }
                    fO = 1.0f;
                    i13 = -1;
                    z4 = false;
                    str = null;
                    listSingletonList = null;
                    bArrCopyOfRange = null;
                    while (i10 - i7 < i11) {
                        kVar2.e(i10);
                        i14 = kVar2.f1236b;
                        iC5 = kVar2.c();
                        if (iC5 != 0 && kVar2.f1236b - i7 == i11) {
                            break;
                        }
                        Object obj2 = obj;
                        if (iC5 > 0) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(z5, obj2);
                        iC6 = kVar2.c();
                        if (iC6 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.I) {
                            if (str == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z11);
                            kVar2.e(i14 + 8);
                            aVarB = com.fyber.inneractive.sdk.player.exoplayer2.video.a.b(kVar2);
                            list = aVarB.a;
                            c0291b.c = aVarB.f1251b;
                            if (!z4) {
                                fO = aVarB.e;
                            }
                            str = "video/avc";
                        } else {
                            if (iC6 != com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.J) {
                                if (iC6 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.M0) {
                                    if (str == null) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z9);
                                    if (iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.K0) {
                                        str = "video/x-vnd.on2.vp8";
                                    } else {
                                        str = "video/x-vnd.on2.vp9";
                                    }
                                } else if (iC6 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.h) {
                                    if (str == null) {
                                        z8 = true;
                                    } else {
                                        z8 = false;
                                    }
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z8);
                                    str = "video/3gpp";
                                } else if (iC6 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.K) {
                                    if (str == null) {
                                        z7 = true;
                                    } else {
                                        z7 = false;
                                    }
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z7);
                                    Pair<String, byte[]> pairA = a(kVar2, i14);
                                    str = (String) pairA.first;
                                    listSingletonList = Collections.singletonList(pairA.second);
                                } else if (iC6 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.j0) {
                                    kVar2.e(i14 + 8);
                                    fO = kVar2.o() / kVar2.o();
                                    z6 = true;
                                } else if (iC6 != com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.I0) {
                                    z6 = z4;
                                    if (iC6 != com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.H0) {
                                        break;
                                        break;
                                    }
                                    iL = kVar2.l();
                                    kVar2.f(3);
                                    if (iL == 0) {
                                        iL2 = kVar2.l();
                                        if (iL2 == 0) {
                                            i13 = 0;
                                        } else if (iL2 == 1) {
                                            i13 = 1;
                                        } else if (iL2 == 2) {
                                            i13 = 2;
                                        } else if (iL2 == 3) {
                                            i13 = 3;
                                        }
                                    }
                                } else {
                                    i15 = i14 + 8;
                                    while (true) {
                                        if (i15 - i14 >= iC5) {
                                            z6 = z4;
                                            bArrCopyOfRange = null;
                                            break;
                                        }
                                        kVar2.e(i15);
                                        iC7 = kVar2.c();
                                        z6 = z4;
                                        if (kVar2.c() == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.J0) {
                                            bArrCopyOfRange = Arrays.copyOfRange(kVar2.a, i15, iC7 + i15);
                                            break;
                                        }
                                        i15 += iC7;
                                        z4 = z6;
                                    }
                                }
                                z6 = z4;
                                break;
                                break;
                            }
                            if (str == null) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z10);
                            kVar2.e(i14 + 8);
                            com.fyber.inneractive.sdk.player.exoplayer2.video.c cVarA = com.fyber.inneractive.sdk.player.exoplayer2.video.c.a(kVar2);
                            list = cVarA.a;
                            c0291b.c = cVarA.f1253b;
                            str = "video/hevc";
                            i10 += iC5;
                            obj = obj2;
                            z4 = z6;
                        }
                        z6 = z4;
                        listSingletonList = list;
                        break;
                        i10 += iC5;
                        obj = obj2;
                        z4 = z6;
                    }
                    if (str != null) {
                        c0291b.f1095b = com.fyber.inneractive.sdk.player.exoplayer2.i.a(Integer.toString(iC9), str, (String) null, -1, -1, iQ, iQ2, -1.0f, listSingletonList, i8, fO, bArrCopyOfRange, i13, (com.fyber.inneractive.sdk.player.exoplayer2.video.b) null, aVar);
                    }
                } else {
                    if (iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.j || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b0 || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.o || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.q || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.s || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.v || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.t || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.u || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.y0 || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.z0 || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.m || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.n || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.k || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.O0) {
                        j3 = jM2;
                        kVar2.e(i7 + 8 + 8);
                        if (z) {
                            iQ3 = kVar2.q();
                            kVar2.f(6);
                        } else {
                            kVar2.f(8);
                            iQ3 = 0;
                        }
                        if (iQ3 == 0 || iQ3 == 1) {
                            int iQ5 = kVar2.q();
                            kVar2.f(6);
                            byte[] bArr = kVar2.a;
                            int i21 = kVar2.f1236b;
                            int i22 = i21 + 1;
                            kVar2.f1236b = i22;
                            int i23 = (bArr[i21] & 255) << 8;
                            int i24 = i22 + 1;
                            kVar2.f1236b = i24;
                            iRound = (bArr[i22] & 255) | i23;
                            kVar2.f1236b = i24 + 2;
                            if (iQ3 == 1) {
                                kVar2.f(16);
                            }
                            iO = iQ5;
                        } else if (iQ3 == 2) {
                            kVar2.f(16);
                            iRound = (int) Math.round(Double.longBitsToDouble(kVar2.i()));
                            iO = kVar2.o();
                            kVar2.f(20);
                        }
                        int i25 = kVar2.f1236b;
                        if (iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b0) {
                            iC4 = a(kVar2, i7, iC3, c0291b, i6);
                            kVar2.e(i25);
                        }
                        if (iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.o) {
                            str2 = "audio/ac3";
                        } else if (iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.q) {
                            str2 = "audio/eac3";
                        } else if (iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.s) {
                            str2 = "audio/vnd.dts";
                        } else if (iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.t || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.u) {
                            str2 = "audio/vnd.dts.hd";
                        } else if (iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.v) {
                            str2 = "audio/vnd.dts.hd;profile=lbr";
                        } else if (iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.y0) {
                            str2 = "audio/3gpp";
                        } else if (iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.z0) {
                            str2 = "audio/amr-wb";
                        } else if (iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.m || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.n) {
                            str2 = "audio/raw";
                        } else if (iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.k) {
                            str2 = "audio/mpeg";
                        } else {
                            str2 = iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.O0 ? "audio/alac" : null;
                        }
                        int iIntValue = iRound;
                        int i26 = i25;
                        int iIntValue2 = iO;
                        byte[] bArr2 = null;
                        while (i26 - i7 < iC3) {
                            kVar2.e(i26);
                            int iC13 = kVar2.c();
                            int i27 = i2;
                            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(iC13 > 0, str7);
                            int iC14 = kVar2.c();
                            int i28 = iC3;
                            int i29 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.K;
                            int i30 = i6;
                            if (iC14 == i29 || (z && iC14 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.l)) {
                                boolean z12 = false;
                                if (iC14 != i29) {
                                    i16 = kVar2.f1236b;
                                    while (true) {
                                        if (i16 - i26 >= iC13) {
                                            str3 = str7;
                                            i16 = -1;
                                            break;
                                        }
                                        kVar2.e(i16);
                                        int iC15 = kVar2.c();
                                        if (iC15 > 0) {
                                            z12 = true;
                                        }
                                        com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(z12, str7);
                                        str3 = str7;
                                        if (kVar2.c() == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.K) {
                                            break;
                                        }
                                        i16 += iC15;
                                        str7 = str3;
                                        z12 = false;
                                    }
                                } else {
                                    str3 = str7;
                                    i16 = i26;
                                }
                                if (i16 != -1) {
                                    Pair<String, byte[]> pairA2 = a(kVar2, i16);
                                    String str8 = (String) pairA2.first;
                                    byte[] bArr3 = (byte[]) pairA2.second;
                                    if ("audio/mp4a-latm".equals(str8)) {
                                        Pair<Integer, Integer> pairA3 = com.fyber.inneractive.sdk.player.exoplayer2.util.c.a(bArr3);
                                        iIntValue = ((Integer) pairA3.first).intValue();
                                        iIntValue2 = ((Integer) pairA3.second).intValue();
                                    }
                                    bArr2 = bArr3;
                                    str2 = str8;
                                }
                            } else if (iC14 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.p) {
                                kVar2.e(i26 + 8);
                                String string = Integer.toString(iC9);
                                int i31 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.f1038b[(kVar2.l() & 192) >> 6];
                                int iL3 = kVar2.l();
                                int i32 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.d[(iL3 & 56) >> 3];
                                if ((iL3 & 4) != 0) {
                                    i32++;
                                }
                                c0291b.f1095b = com.fyber.inneractive.sdk.player.exoplayer2.i.a(string, "audio/ac3", (String) null, -1, -1, i32, i31, -1, (List<byte[]>) null, aVar, 0, str6);
                                str3 = str7;
                            } else {
                                if (iC14 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.r) {
                                    kVar2.e(i26 + 8);
                                    String string2 = Integer.toString(iC9);
                                    kVar2.f(2);
                                    int i33 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.f1038b[(kVar2.l() & 192) >> 6];
                                    int iL4 = kVar2.l();
                                    int i34 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.d[(iL4 & 14) >> 1];
                                    if ((iL4 & 1) != 0) {
                                        i34++;
                                    }
                                    c0291b.f1095b = com.fyber.inneractive.sdk.player.exoplayer2.i.a(string2, "audio/eac3", (String) null, -1, -1, i34, i33, -1, (List<byte[]>) null, aVar, 0, str6);
                                } else if (iC14 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.w) {
                                    c0291b.f1095b = com.fyber.inneractive.sdk.player.exoplayer2.i.a(Integer.toString(iC9), str2, (String) null, -1, -1, iIntValue2, iIntValue, -1, (List<byte[]>) null, aVar, 0, str6);
                                } else if (iC14 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.O0) {
                                    byte[] bArr4 = new byte[iC13];
                                    kVar2.e(i26);
                                    System.arraycopy(kVar2.a, kVar2.f1236b, bArr4, 0, iC13);
                                    kVar2.f1236b += iC13;
                                    bArr2 = bArr4;
                                }
                                str3 = str7;
                            }
                            i26 += iC13;
                            str7 = str3;
                            i2 = i27;
                            iC3 = i28;
                            i6 = i30;
                        }
                        i8 = i2;
                        int i35 = iC3;
                        int i36 = i6;
                        if (c0291b.f1095b == null && str2 != null) {
                            c0291b.f1095b = com.fyber.inneractive.sdk.player.exoplayer2.i.a(Integer.toString(iC9), str2, (String) null, -1, -1, iIntValue2, iIntValue, "audio/raw".equals(str2) ? 2 : -1, (List<byte[]>) (bArr2 == null ? null : Collections.singletonList(bArr2)), aVar, 0, str6);
                        }
                        i11 = i35;
                        i12 = i36;
                    } else {
                        int i37 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.k0;
                        if (iC4 == i37 || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.u0 || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.v0 || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.w0 || iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.x0) {
                            j3 = jM2;
                            kVar2.e(i7 + 8 + 8);
                            if (iC4 == i37) {
                                j4 = Long.MAX_VALUE;
                                listSingletonList2 = null;
                                str5 = "application/ttml+xml";
                            } else if (iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.u0) {
                                int i38 = (iC3 - 8) - 8;
                                byte[] bArr5 = new byte[i38];
                                System.arraycopy(kVar2.a, kVar2.f1236b, bArr5, 0, i38);
                                kVar2.f1236b += i38;
                                listSingletonList2 = Collections.singletonList(bArr5);
                                j4 = Long.MAX_VALUE;
                                str5 = "application/x-quicktime-tx3g";
                            } else {
                                if (iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.v0) {
                                    str4 = "application/x-mp4-vtt";
                                } else if (iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.w0) {
                                    str5 = "application/ttml+xml";
                                    j4 = 0;
                                    listSingletonList2 = null;
                                } else {
                                    if (iC4 != com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.x0) {
                                        throw new IllegalStateException();
                                    }
                                    c0291b.d = 1;
                                    str4 = "application/x-mp4-cea-608";
                                }
                                j4 = Long.MAX_VALUE;
                                listSingletonList2 = null;
                                str5 = str4;
                            }
                            c0291b.f1095b = com.fyber.inneractive.sdk.player.exoplayer2.i.a(Integer.toString(iC9), str5, null, -1, 0, str6, -1, aVar, j4, listSingletonList2);
                        } else if (iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.N0) {
                            j3 = jM2;
                            c0291b.f1095b = com.fyber.inneractive.sdk.player.exoplayer2.i.a(Integer.toString(iC9), "application/x-camera-motion", null, -1, aVar);
                        } else {
                            j3 = jM2;
                        }
                    }
                    pairCreate = pairCreate;
                    i8 = i2;
                    i11 = iC3;
                    i = i;
                    i12 = i6;
                }
                kVar2.e(i7 + i11);
                i6 = i12 + 1;
                iC2 = i20;
                jM2 = j3;
                i = i;
                pairCreate = pairCreate;
                i2 = i8;
            }
            Pair pair = pairCreate;
            long j5 = jM2;
            int i39 = i;
            c0290aC = c0290a.c(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.Q);
            if (c0290aC != null || (bVarD = c0290aC.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.R)) == null) {
                hVar = null;
                pairCreate2 = Pair.create(null, null);
            } else {
                com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar6 = bVarD.P0;
                kVar6.e(8);
                int iB3 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(kVar6.c());
                int iO2 = kVar6.o();
                long[] jArr = new long[iO2];
                long[] jArr2 = new long[iO2];
                for (int i40 = 0; i40 < iO2; i40++) {
                    jArr[i40] = iB3 == 1 ? kVar6.p() : kVar6.m();
                    jArr2[i40] = iB3 == 1 ? kVar6.i() : kVar6.c();
                    byte[] bArr6 = kVar6.a;
                    int i41 = kVar6.f1236b;
                    int i42 = i41 + 1;
                    kVar6.f1236b = i42;
                    int i43 = (bArr6[i41] & 255) << 8;
                    kVar6.f1236b = i42 + 1;
                    if (((short) ((bArr6[i42] & 255) | i43)) != 1) {
                        throw new IllegalArgumentException("Unsupported media rate.");
                    }
                    kVar6.f(2);
                }
                pairCreate2 = Pair.create(jArr, jArr2);
                hVar = null;
            }
            return c0291b.f1095b == null ? hVar : new h(iC9, i39, ((Long) pair.first).longValue(), j5, jA, c0291b.f1095b, c0291b.d, c0291b.a, c0291b.c, (long[]) pairCreate2.first, (long[]) pairCreate2.second);
        }
        kVar4.f(i18);
        jM = -9223372036854775807L;
        kVar4.f(16);
        iC = kVar4.c();
        int iC16 = kVar4.c();
        kVar4.f(4);
        int iC17 = kVar4.c();
        int iC18 = kVar4.c();
        if (iC != 0) {
            if (iC != 0) {
                if (iC != -65536) {
                    i2 = 0;
                } else {
                    i2 = 0;
                }
            } else if (iC != -65536) {
                i2 = 0;
            } else {
                i2 = 0;
            }
        } else if (iC != 0) {
            if (iC != -65536) {
                i2 = 0;
            } else {
                i2 = 0;
            }
        } else if (iC != -65536) {
            i2 = 0;
        } else {
            i2 = 0;
        }
        if (j == -9223372036854775807L) {
            j2 = jM;
        } else {
            j2 = j;
        }
        kVar = bVar.P0;
        kVar.e(8);
        if (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(kVar.c()) == 0) {
            i3 = 8;
        } else {
            i3 = 16;
        }
        kVar.f(i3);
        jM2 = kVar.m();
        if (j2 != -9223372036854775807L) {
        }
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0290a c0290aC4 = c0290aC2.c(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.G).c(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.H);
        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar7 = c0290aC2.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.S).P0;
        kVar7.e(8);
        iB = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(kVar7.c());
        if (iB == 0) {
            i4 = 8;
        } else {
            i4 = 16;
        }
        kVar7.f(i4);
        long jM4 = kVar7.m();
        if (iB == 0) {
            i5 = 4;
        } else {
            i5 = 8;
        }
        kVar7.f(i5);
        int iQ6 = kVar7.q();
        pairCreate = Pair.create(Long.valueOf(jM4), "" + ((char) (((iQ6 >> 10) & 31) + 96)) + ((char) (((iQ6 >> 5) & 31) + 96)) + ((char) ((iQ6 & 31) + 96)));
        kVar2 = c0290aC4.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.U).P0;
        String str9 = (String) pairCreate.second;
        kVar2.e(12);
        iC2 = kVar2.c();
        c0291b = new C0291b(iC2);
        i6 = 0;
        while (i6 < iC2) {
            i7 = kVar2.f1236b;
            iC3 = kVar2.c();
            if (iC3 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            String str10 = "childAtomSize should be positive";
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(z3, "childAtomSize should be positive");
            iC4 = kVar2.c();
            int i210 = iC2;
            if (iC4 != com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.c) {
                pairCreate = pairCreate;
                i8 = i2;
                obj = "childAtomSize should be positive";
                j3 = jM2;
                i = i;
                i9 = i6;
                kVar2.e(i7 + 8 + 8);
                kVar2.f(16);
                iQ = kVar2.q();
                iQ2 = kVar2.q();
                kVar2.f(50);
                i10 = kVar2.f1236b;
                i11 = iC3;
                if (iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.a0) {
                    i12 = i9;
                    iC4 = a(kVar2, i7, i11, c0291b, i12);
                    kVar2.e(i10);
                } else {
                    i12 = i9;
                }
                fO = 1.0f;
                i13 = -1;
                z4 = false;
                str = null;
                listSingletonList = null;
                bArrCopyOfRange = null;
                while (i10 - i7 < i11) {
                    kVar2.e(i10);
                    i14 = kVar2.f1236b;
                    iC5 = kVar2.c();
                    if (iC5 != 0) {
                    }
                    Object obj3 = obj;
                    if (iC5 > 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(z5, obj3);
                    iC6 = kVar2.c();
                    if (iC6 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.I) {
                        if (str == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z11);
                        kVar2.e(i14 + 8);
                        aVarB = com.fyber.inneractive.sdk.player.exoplayer2.video.a.b(kVar2);
                        list = aVarB.a;
                        c0291b.c = aVarB.f1251b;
                        if (!z4) {
                            fO = aVarB.e;
                        }
                        str = "video/avc";
                    } else {
                        if (iC6 != com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.J) {
                            if (iC6 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.M0) {
                                if (str == null) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z9);
                                if (iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.K0) {
                                    str = "video/x-vnd.on2.vp8";
                                } else {
                                    str = "video/x-vnd.on2.vp9";
                                }
                            } else if (iC6 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.h) {
                                if (str == null) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z8);
                                str = "video/3gpp";
                            } else if (iC6 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.K) {
                                if (str == null) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z7);
                                Pair<String, byte[]> pairA4 = a(kVar2, i14);
                                str = (String) pairA4.first;
                                listSingletonList = Collections.singletonList(pairA4.second);
                            } else if (iC6 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.j0) {
                                kVar2.e(i14 + 8);
                                fO = kVar2.o() / kVar2.o();
                                z6 = true;
                            } else if (iC6 != com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.I0) {
                                z6 = z4;
                                if (iC6 != com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.H0) {
                                    break;
                                    break;
                                }
                                iL = kVar2.l();
                                kVar2.f(3);
                                if (iL == 0) {
                                    iL2 = kVar2.l();
                                    if (iL2 == 0) {
                                        i13 = 0;
                                    } else if (iL2 == 1) {
                                        i13 = 1;
                                    } else if (iL2 == 2) {
                                        i13 = 2;
                                    } else if (iL2 == 3) {
                                        i13 = 3;
                                    }
                                }
                            } else {
                                i15 = i14 + 8;
                                while (true) {
                                    if (i15 - i14 >= iC5) {
                                        z6 = z4;
                                        bArrCopyOfRange = null;
                                        break;
                                        break;
                                    }
                                    kVar2.e(i15);
                                    iC7 = kVar2.c();
                                    z6 = z4;
                                    if (kVar2.c() == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.J0) {
                                        bArrCopyOfRange = Arrays.copyOfRange(kVar2.a, i15, iC7 + i15);
                                        break;
                                        break;
                                    }
                                    i15 += iC7;
                                    z4 = z6;
                                }
                            }
                            z6 = z4;
                            break;
                            break;
                        }
                        if (str == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z10);
                        kVar2.e(i14 + 8);
                        com.fyber.inneractive.sdk.player.exoplayer2.video.c cVarA2 = com.fyber.inneractive.sdk.player.exoplayer2.video.c.a(kVar2);
                        list = cVarA2.a;
                        c0291b.c = cVarA2.f1253b;
                        str = "video/hevc";
                        i10 += iC5;
                        obj = obj3;
                        z4 = z6;
                    }
                    z6 = z4;
                    listSingletonList = list;
                    break;
                    i10 += iC5;
                    obj = obj3;
                    z4 = z6;
                }
                if (str != null) {
                    c0291b.f1095b = com.fyber.inneractive.sdk.player.exoplayer2.i.a(Integer.toString(iC9), str, (String) null, -1, -1, iQ, iQ2, -1.0f, listSingletonList, i8, fO, bArrCopyOfRange, i13, (com.fyber.inneractive.sdk.player.exoplayer2.video.b) null, aVar);
                }
            } else {
                pairCreate = pairCreate;
                i8 = i2;
                obj = "childAtomSize should be positive";
                j3 = jM2;
                i = i;
                i9 = i6;
                kVar2.e(i7 + 8 + 8);
                kVar2.f(16);
                iQ = kVar2.q();
                iQ2 = kVar2.q();
                kVar2.f(50);
                i10 = kVar2.f1236b;
                i11 = iC3;
                if (iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.a0) {
                    i12 = i9;
                    iC4 = a(kVar2, i7, i11, c0291b, i12);
                    kVar2.e(i10);
                } else {
                    i12 = i9;
                }
                fO = 1.0f;
                i13 = -1;
                z4 = false;
                str = null;
                listSingletonList = null;
                bArrCopyOfRange = null;
                while (i10 - i7 < i11) {
                    kVar2.e(i10);
                    i14 = kVar2.f1236b;
                    iC5 = kVar2.c();
                    if (iC5 != 0) {
                    }
                    Object obj4 = obj;
                    if (iC5 > 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(z5, obj4);
                    iC6 = kVar2.c();
                    if (iC6 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.I) {
                        if (str == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z11);
                        kVar2.e(i14 + 8);
                        aVarB = com.fyber.inneractive.sdk.player.exoplayer2.video.a.b(kVar2);
                        list = aVarB.a;
                        c0291b.c = aVarB.f1251b;
                        if (!z4) {
                            fO = aVarB.e;
                        }
                        str = "video/avc";
                    } else {
                        if (iC6 != com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.J) {
                            if (iC6 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.M0) {
                                if (str == null) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z9);
                                if (iC4 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.K0) {
                                    str = "video/x-vnd.on2.vp8";
                                } else {
                                    str = "video/x-vnd.on2.vp9";
                                }
                            } else if (iC6 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.h) {
                                if (str == null) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z8);
                                str = "video/3gpp";
                            } else if (iC6 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.K) {
                                if (str == null) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z7);
                                Pair<String, byte[]> pairA5 = a(kVar2, i14);
                                str = (String) pairA5.first;
                                listSingletonList = Collections.singletonList(pairA5.second);
                            } else if (iC6 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.j0) {
                                kVar2.e(i14 + 8);
                                fO = kVar2.o() / kVar2.o();
                                z6 = true;
                            } else if (iC6 != com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.I0) {
                                z6 = z4;
                                if (iC6 != com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.H0) {
                                    break;
                                    break;
                                }
                                iL = kVar2.l();
                                kVar2.f(3);
                                if (iL == 0) {
                                    iL2 = kVar2.l();
                                    if (iL2 == 0) {
                                        i13 = 0;
                                    } else if (iL2 == 1) {
                                        i13 = 1;
                                    } else if (iL2 == 2) {
                                        i13 = 2;
                                    } else if (iL2 == 3) {
                                        i13 = 3;
                                    }
                                }
                            } else {
                                i15 = i14 + 8;
                                while (true) {
                                    if (i15 - i14 >= iC5) {
                                        z6 = z4;
                                        bArrCopyOfRange = null;
                                        break;
                                        break;
                                    }
                                    kVar2.e(i15);
                                    iC7 = kVar2.c();
                                    z6 = z4;
                                    if (kVar2.c() == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.J0) {
                                        bArrCopyOfRange = Arrays.copyOfRange(kVar2.a, i15, iC7 + i15);
                                        break;
                                        break;
                                    }
                                    i15 += iC7;
                                    z4 = z6;
                                }
                            }
                            z6 = z4;
                            break;
                            break;
                        }
                        if (str == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z10);
                        kVar2.e(i14 + 8);
                        com.fyber.inneractive.sdk.player.exoplayer2.video.c cVarA3 = com.fyber.inneractive.sdk.player.exoplayer2.video.c.a(kVar2);
                        list = cVarA3.a;
                        c0291b.c = cVarA3.f1253b;
                        str = "video/hevc";
                        i10 += iC5;
                        obj = obj4;
                        z4 = z6;
                    }
                    z6 = z4;
                    listSingletonList = list;
                    break;
                    i10 += iC5;
                    obj = obj4;
                    z4 = z6;
                }
                if (str != null) {
                    c0291b.f1095b = com.fyber.inneractive.sdk.player.exoplayer2.i.a(Integer.toString(iC9), str, (String) null, -1, -1, iQ, iQ2, -1.0f, listSingletonList, i8, fO, bArrCopyOfRange, i13, (com.fyber.inneractive.sdk.player.exoplayer2.video.b) null, aVar);
                }
            }
            kVar2.e(i7 + i11);
            i6 = i12 + 1;
            iC2 = i210;
            jM2 = j3;
            i = i;
            pairCreate = pairCreate;
            i2 = i8;
        }
        Pair pair2 = pairCreate;
        long j6 = jM2;
        int i310 = i;
        c0290aC = c0290a.c(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.Q);
        if (c0290aC != null) {
            hVar = null;
            pairCreate2 = Pair.create(null, null);
        } else {
            hVar = null;
            pairCreate2 = Pair.create(null, null);
        }
        if (c0291b.f1095b == null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, int i, int i2, C0291b c0291b, int i3) {
        int i4 = kVar.f1236b;
        while (true) {
            if (i4 - i >= i2) {
                return 0;
            }
            kVar.e(i4);
            int iC = kVar.c();
            int i5 = 1;
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(iC > 0, "childAtomSize should be positive");
            if (kVar.c() == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.W) {
                int i6 = i4 + 8;
                Pair pairCreate = null;
                int i7 = 0;
                Integer numValueOf = null;
                i iVar = null;
                while (i6 - i4 < iC) {
                    kVar.e(i6);
                    int iC2 = kVar.c();
                    int iC3 = kVar.c();
                    if (iC3 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.c0) {
                        numValueOf = Integer.valueOf(kVar.c());
                    } else if (iC3 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.X) {
                        kVar.f(4);
                        i7 = kVar.c() == g ? i5 : 0;
                    } else if (iC3 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.Y) {
                        int i8 = i6 + 8;
                        while (true) {
                            if (i8 - i6 >= iC2) {
                                iVar = null;
                                break;
                            }
                            kVar.e(i8);
                            int iC4 = kVar.c();
                            if (kVar.c() == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.Z) {
                                kVar.f(6);
                                boolean z = kVar.l() == i5 ? i5 : 0;
                                int iL = kVar.l();
                                byte[] bArr = new byte[16];
                                System.arraycopy(kVar.a, kVar.f1236b, bArr, 0, 16);
                                kVar.f1236b += 16;
                                iVar = new i(z, iL, bArr);
                                break;
                            }
                            i8 += iC4;
                            i5 = 1;
                        }
                    }
                    i6 += iC2;
                    i5 = 1;
                }
                if (i7 != 0) {
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(numValueOf != null, "frma atom is mandatory");
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(iVar != null, "schi->tenc atom is mandatory");
                    pairCreate = Pair.create(numValueOf, iVar);
                }
                if (pairCreate != null) {
                    c0291b.a[i3] = (i) pairCreate.second;
                    return ((Integer) pairCreate.first).intValue();
                }
            }
            i4 += iC;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0077  */
    public static Pair<String, byte[]> a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, int i) {
        kVar.e(i + 8 + 4);
        kVar.f(1);
        a(kVar);
        kVar.f(2);
        int iL = kVar.l();
        if ((iL & 128) != 0) {
            kVar.f(2);
        }
        if ((iL & 64) != 0) {
            kVar.f(kVar.q());
        }
        if ((iL & 32) != 0) {
            kVar.f(2);
        }
        kVar.f(1);
        a(kVar);
        int iL2 = kVar.l();
        String str = null;
        if (iL2 == 32) {
            str = "video/mp4v-es";
        } else if (iL2 == 33) {
            str = "video/avc";
        } else if (iL2 == 35) {
            str = "video/hevc";
        } else if (iL2 == 64) {
            str = "audio/mp4a-latm";
        } else {
            if (iL2 == 107) {
                return Pair.create("audio/mpeg", null);
            }
            if (iL2 == 165) {
                str = "audio/ac3";
            } else if (iL2 != 166) {
                switch (iL2) {
                    case 102:
                    case 103:
                    case 104:
                        str = "audio/mp4a-latm";
                        break;
                    default:
                        switch (iL2) {
                            case 169:
                            case 172:
                                return Pair.create("audio/vnd.dts", null);
                            case 170:
                            case 171:
                                return Pair.create("audio/vnd.dts.hd", null);
                        }
                }
            } else {
                str = "audio/eac3";
            }
        }
        kVar.f(12);
        kVar.f(1);
        int iA = a(kVar);
        byte[] bArr = new byte[iA];
        System.arraycopy(kVar.a, kVar.f1236b, bArr, 0, iA);
        kVar.f1236b += iA;
        return Pair.create(str, bArr);
    }

    public static int a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar) {
        int iL = kVar.l();
        int i = iL & WorkQueueKt.MASK;
        while ((iL & 128) == 128) {
            iL = kVar.l();
            i = (i << 7) | (iL & WorkQueueKt.MASK);
        }
        return i;
    }
}
