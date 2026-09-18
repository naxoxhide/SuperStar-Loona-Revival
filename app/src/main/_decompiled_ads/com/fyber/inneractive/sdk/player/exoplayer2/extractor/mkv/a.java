package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv;

import android.util.Log;
import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import com.google.firebase.FirebaseError;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements b {
    public final byte[] a = new byte[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Stack<C0289a> f1083b = new Stack<>();
    public final f c = new f();
    public c d;
    public int e;
    public int f;
    public long g;

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.a$a, reason: collision with other inner class name */
    public static final class C0289a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f1084b;

        public C0289a(int i, long j) {
            this.a = i;
            this.f1084b = j;
        }
    }

    public void a(c cVar) {
        this.d = cVar;
    }

    public final long b(g gVar, int i) throws InterruptedException, IOException {
        ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.a, 0, i, false);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.a[i2] & 255));
        }
        return j;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:260:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:366:0x064a  */
    /* JADX WARN: Code duplicated, block: B:368:0x0652  */
    /* JADX WARN: Code duplicated, block: B:369:0x0675  */
    /* JADX WARN: Code duplicated, block: B:370:0x067a  */
    /* JADX WARN: Code duplicated, block: B:382:0x06bb  */
    /* JADX WARN: Code duplicated, block: B:383:0x06bd  */
    /* JADX WARN: Code duplicated, block: B:386:0x06c5  */
    /* JADX WARN: Code duplicated, block: B:387:0x06ea  */
    /* JADX WARN: Code duplicated, block: B:389:0x06f0  */
    /* JADX WARN: Code duplicated, block: B:391:0x06f4  */
    /* JADX WARN: Code duplicated, block: B:393:0x06f9  */
    /* JADX WARN: Code duplicated, block: B:396:0x0701  */
    /* JADX WARN: Code duplicated, block: B:398:0x0706  */
    /* JADX WARN: Code duplicated, block: B:401:0x070d  */
    /* JADX WARN: Code duplicated, block: B:404:0x071d  */
    /* JADX WARN: Code duplicated, block: B:407:0x0723  */
    /* JADX WARN: Code duplicated, block: B:409:0x0729  */
    /* JADX WARN: Code duplicated, block: B:429:0x07d6  */
    /* JADX WARN: Code duplicated, block: B:431:0x07e5  */
    /* JADX WARN: Code duplicated, block: B:433:0x0811  */
    /* JADX WARN: Code duplicated, block: B:435:0x0819  */
    /* JADX WARN: Code duplicated, block: B:437:0x0833  */
    /* JADX WARN: Code duplicated, block: B:439:0x083b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v31, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v76 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v34, types: [com.fyber.inneractive.sdk.player.exoplayer2.extractor.b] */
    /* JADX WARN: Type inference failed for: r4v86, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v88, types: [int] */
    /* JADX WARN: Type inference failed for: r4v89 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v12, types: [com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.f] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v103 */
    /* JADX WARN: Type inference failed for: r6v104, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v112 */
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
    public boolean a(g gVar) throws InterruptedException, IOException {
        boolean z;
        boolean z2;
        int i;
        d.c cVar;
        int i2;
        List<byte[]> listSingletonList;
        String str;
        boolean z3;
        int iA;
        int i3;
        List<byte[]> listSingletonList2;
        int i4;
        List list;
        int i5;
        List<byte[]> listSingletonList3;
        String str2;
        String str3;
        int iA2;
        int i6;
        int i7;
        int i8;
        i iVarA;
        int i9;
        int i10;
        int i11;
        float f;
        com.fyber.inneractive.sdk.player.exoplayer2.video.b bVar;
        byte[] bArr;
        int i12;
        int i13;
        int i14;
        m aVar;
        com.fyber.inneractive.sdk.player.exoplayer2.util.f fVar;
        int i15;
        com.fyber.inneractive.sdk.player.exoplayer2.util.f fVar2;
        ?? r4 = 0;
        int i16 = 1;
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.d != null);
        while (true) {
            if (!this.f1083b.isEmpty() && ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).c >= this.f1083b.peek().f1084b) {
                c cVar2 = this.d;
                int i17 = this.f1083b.pop().a;
                d dVar = d.this;
                dVar.getClass();
                if (i17 != 160) {
                    if (i17 != 174) {
                        if (i17 == 19899) {
                            int i18 = dVar.v;
                            if (i18 != -1) {
                                long j = dVar.w;
                                if (j != -1) {
                                    if (i18 == 475249515) {
                                        dVar.y = j;
                                    }
                                }
                            }
                            throw new l("Mandatory element SeekID or SeekPosition not found");
                        }
                        if (i17 == 25152) {
                            d.c cVar3 = dVar.t;
                            if (cVar3.e) {
                                byte[] bArr2 = cVar3.g;
                                if (bArr2 == null) {
                                    throw new l("Encrypted Track found but ContentEncKeyID was not found");
                                }
                                com.fyber.inneractive.sdk.player.exoplayer2.drm.a.b[] bVarArr = new com.fyber.inneractive.sdk.player.exoplayer2.drm.a.b[i16];
                                bVarArr[r4 == true ? 1 : 0] = new com.fyber.inneractive.sdk.player.exoplayer2.drm.a.b(com.fyber.inneractive.sdk.player.exoplayer2.b.f1048b, "video/webm", bArr2, r4);
                                cVar3.i = new com.fyber.inneractive.sdk.player.exoplayer2.drm.a(i16, bVarArr);
                            }
                        } else if (i17 == 28032) {
                            d.c cVar4 = dVar.t;
                            if (cVar4.e && cVar4.f != null) {
                                throw new l("Combining encryption and compression is not supported");
                            }
                        } else if (i17 == 357149030) {
                            if (dVar.q == -9223372036854775807L) {
                                dVar.q = 1000000L;
                            }
                            long j2 = dVar.r;
                            if (j2 != -9223372036854775807L) {
                                dVar.s = dVar.a(j2);
                            }
                        } else if (i17 == 374648427) {
                            if (dVar.c.size() == 0) {
                                throw new l("No valid tracks were found");
                            }
                            dVar.Y.c();
                        } else if (i17 == 475249515 && !dVar.u) {
                            h hVar = dVar.Y;
                            if (dVar.p == -1 || dVar.s == -9223372036854775807L || (fVar = dVar.B) == null || (i15 = fVar.a) == 0 || (fVar2 = dVar.C) == null || fVar2.a != i15) {
                                dVar.B = null;
                                dVar.C = null;
                                aVar = new m.a(dVar.s);
                            } else {
                                int[] iArr = new int[i15];
                                long[] jArr = new long[i15];
                                long[] jArr2 = new long[i15];
                                long[] jArr3 = new long[i15];
                                for (int i19 = r4 == true ? 1 : 0; i19 < i15; i19++) {
                                    jArr3[i19] = dVar.B.a(i19);
                                    jArr[i19] = dVar.p + dVar.C.a(i19);
                                }
                                while (true) {
                                    int i20 = i15 - 1;
                                    if (r4 < i20) {
                                        int i21 = r4 + 1;
                                        iArr[r4] = (int) (jArr[i21] - jArr[r4]);
                                        jArr2[r4] = jArr3[i21] - jArr3[r4];
                                        r4 = i21;
                                    } else {
                                        iArr[i20] = (int) ((dVar.p + dVar.o) - jArr[i20]);
                                        jArr2[i20] = dVar.s - jArr3[i20];
                                        dVar.B = null;
                                        dVar.C = null;
                                        aVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.a(iArr, jArr, jArr2, jArr3);
                                    }
                                }
                            }
                            hVar.a(aVar);
                            dVar.u = i16;
                        }
                        return i16;
                    }
                    String str4 = dVar.t.a;
                    if ((("V_VP8".equals(str4) || "V_VP9".equals(str4) || "V_MPEG2".equals(str4) || "V_MPEG4/ISO/SP".equals(str4) || "V_MPEG4/ISO/ASP".equals(str4) || "V_MPEG4/ISO/AP".equals(str4) || "V_MPEG4/ISO/AVC".equals(str4) || "V_MPEGH/ISO/HEVC".equals(str4) || "V_MS/VFW/FOURCC".equals(str4) || "V_THEORA".equals(str4) || "A_OPUS".equals(str4) || "A_VORBIS".equals(str4) || "A_AAC".equals(str4) || "A_MPEG/L2".equals(str4) || "A_MPEG/L3".equals(str4) || "A_AC3".equals(str4) || "A_EAC3".equals(str4) || "A_TRUEHD".equals(str4) || "A_DTS".equals(str4) || "A_DTS/EXPRESS".equals(str4) || "A_DTS/LOSSLESS".equals(str4) || "A_FLAC".equals(str4) || "A_MS/ACM".equals(str4) || "A_PCM/INT/LIT".equals(str4) || "S_TEXT/UTF8".equals(str4) || "S_VOBSUB".equals(str4) || "S_HDMV/PGS".equals(str4) || "S_DVBSUB".equals(str4)) ? i16 : r4 == true ? 1 : 0) != 0) {
                        d.c cVar5 = dVar.t;
                        h hVar2 = dVar.Y;
                        int i22 = cVar5.f1086b;
                        String str5 = cVar5.a;
                        str5.getClass();
                        switch (str5) {
                            case "V_MPEG4/ISO/AP":
                                i2 = r4 == true ? 1 : 0;
                                break;
                            case "V_MPEG4/ISO/SP":
                                i2 = i16;
                                break;
                            case "A_MS/ACM":
                                i2 = 2;
                                break;
                            case "A_TRUEHD":
                                i2 = 3;
                                break;
                            case "A_VORBIS":
                                i2 = 4;
                                break;
                            case "A_MPEG/L2":
                                i2 = 5;
                                break;
                            case "A_MPEG/L3":
                                i2 = 6;
                                break;
                            case "V_MS/VFW/FOURCC":
                                i2 = 7;
                                break;
                            case "S_DVBSUB":
                                i2 = 8;
                                break;
                            case "V_MPEG4/ISO/ASP":
                                i2 = 9;
                                break;
                            case "V_MPEG4/ISO/AVC":
                                i2 = 10;
                                break;
                            case "S_VOBSUB":
                                i2 = 11;
                                break;
                            case "A_DTS/LOSSLESS":
                                i2 = 12;
                                break;
                            case "A_AAC":
                                i2 = 13;
                                break;
                            case "A_AC3":
                                i2 = 14;
                                break;
                            case "A_DTS":
                                i2 = 15;
                                break;
                            case "V_VP8":
                                i2 = 16;
                                break;
                            case "V_VP9":
                                i2 = 17;
                                break;
                            case "S_HDMV/PGS":
                                i2 = 18;
                                break;
                            case "V_THEORA":
                                i2 = 19;
                                break;
                            case "A_DTS/EXPRESS":
                                i2 = 20;
                                break;
                            case "A_PCM/INT/LIT":
                                i2 = 21;
                                break;
                            case "V_MPEGH/ISO/HEVC":
                                i2 = 22;
                                break;
                            case "S_TEXT/UTF8":
                                i2 = 23;
                                break;
                            case "V_MPEG2":
                                i2 = 24;
                                break;
                            case "A_EAC3":
                                i2 = 25;
                                break;
                            case "A_FLAC":
                                i2 = 26;
                                break;
                            case "A_OPUS":
                                i2 = 27;
                                break;
                            default:
                                i2 = -1;
                                break;
                        }
                        String str6 = "audio/x-unknown";
                        switch (i2) {
                            case 0:
                            case 1:
                            case 9:
                                byte[] bArr3 = cVar5.h;
                                listSingletonList = bArr3 == null ? null : Collections.singletonList(bArr3);
                                str = "video/mp4v-es";
                                iA2 = -1;
                                i6 = iA2;
                                list = listSingletonList;
                                i4 = -1;
                                int i23 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i23 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10 || (i12 = cVar5.m) == i10) {
                                        f = -1.0f;
                                    } else {
                                        f = (cVar5.k * i11) / (cVar5.j * i12);
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f || cVar5.x == -1.0f || cVar5.y == -1.0f || cVar5.z == -1.0f || cVar5.A == -1.0f || cVar5.B == -1.0f || cVar5.C == -1.0f || cVar5.D == -1.0f || cVar5.E == -1.0f || cVar5.F == -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = new byte[25];
                                            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                                            byteBufferWrap.put((byte) 0);
                                            byteBufferWrap.putShort((short) ((cVar5.w * 50000.0f) + 0.5f));
                                            byteBufferWrap.putShort((short) ((cVar5.x * 50000.0f) + 0.5f));
                                            byteBufferWrap.putShort((short) ((cVar5.y * 50000.0f) + 0.5f));
                                            byteBufferWrap.putShort((short) ((cVar5.z * 50000.0f) + 0.5f));
                                            byteBufferWrap.putShort((short) ((cVar5.A * 50000.0f) + 0.5f));
                                            byteBufferWrap.putShort((short) ((cVar5.B * 50000.0f) + 0.5f));
                                            byteBufferWrap.putShort((short) ((cVar5.C * 50000.0f) + 0.5f));
                                            byteBufferWrap.putShort((short) ((cVar5.D * 50000.0f) + 0.5f));
                                            byteBufferWrap.putShort((short) (cVar5.E + 0.5f));
                                            byteBufferWrap.putShort((short) (cVar5.F + 0.5f));
                                            byteBufferWrap.putShort((short) cVar5.u);
                                            byteBufferWrap.putShort((short) cVar5.v);
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str) && !"application/pgs".equals(str) && !"application/dvbsubs".equals(str)) {
                                            throw new l("Unexpected MIME type.");
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA;
                                nVarA.a(iVarA);
                                SparseArray<d.c> sparseArray = dVar.c;
                                d.c cVar6 = dVar.t;
                                sparseArray.put(cVar6.f1086b, cVar6);
                                cVar = null;
                                break;
                            case 2:
                                k kVar = new k(cVar5.h);
                                try {
                                    int iH = kVar.h();
                                    if (iH != 1) {
                                        if (iH == 65534) {
                                            kVar.e(24);
                                            long jI = kVar.i();
                                            UUID uuid = d.b0;
                                            if (jI != uuid.getMostSignificantBits() || kVar.i() != uuid.getLeastSignificantBits()) {
                                            }
                                            if (z3) {
                                                iA = u.a(cVar5.H);
                                                if (iA == 0) {
                                                    Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + cVar5.H + ". Setting mimeType to audio/x-unknown");
                                                } else {
                                                    str6 = "audio/raw";
                                                    i3 = iA;
                                                    listSingletonList2 = null;
                                                }
                                                listSingletonList = listSingletonList2;
                                                iA2 = i3;
                                                str = str6;
                                                i6 = iA2;
                                                list = listSingletonList;
                                                i4 = -1;
                                                int i24 = (cVar5.M ? 1 : 0) | 0;
                                                if (cVar5.L) {
                                                    i7 = 2;
                                                } else {
                                                    i7 = 0;
                                                }
                                                i8 = i24 | i7;
                                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                                    i9 = 1;
                                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                                    if (cVar5.n == 0) {
                                                        i13 = cVar5.l;
                                                        i10 = -1;
                                                        if (i13 == -1) {
                                                            i13 = cVar5.j;
                                                        }
                                                        cVar5.l = i13;
                                                        i14 = cVar5.m;
                                                        if (i14 == -1) {
                                                            i14 = cVar5.k;
                                                        }
                                                        cVar5.m = i14;
                                                    } else {
                                                        i10 = -1;
                                                    }
                                                    i11 = cVar5.l;
                                                    if (i11 != i10) {
                                                        f = -1.0f;
                                                    } else {
                                                        f = -1.0f;
                                                    }
                                                    if (cVar5.q) {
                                                        if (cVar5.w != -1.0f) {
                                                            bArr = null;
                                                        } else {
                                                            bArr = null;
                                                        }
                                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                                    } else {
                                                        bVar = null;
                                                    }
                                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                                    i9 = 2;
                                                } else {
                                                    if ("application/x-subrip".equals(str)) {
                                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                                    } else {
                                                        if ("application/vobsub".equals(str)) {
                                                        }
                                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                                    }
                                                    i9 = 3;
                                                }
                                                n nVarA2 = hVar2.a(cVar5.f1086b, i9);
                                                cVar5.O = nVarA2;
                                                nVarA2.a(iVarA);
                                                SparseArray<d.c> sparseArray2 = dVar.c;
                                                d.c cVar7 = dVar.t;
                                                sparseArray2.put(cVar7.f1086b, cVar7);
                                                cVar = null;
                                            } else {
                                                Log.w("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                                            }
                                            listSingletonList2 = null;
                                            i3 = -1;
                                            listSingletonList = listSingletonList2;
                                            iA2 = i3;
                                            str = str6;
                                            i6 = iA2;
                                            list = listSingletonList;
                                            i4 = -1;
                                            int i25 = (cVar5.M ? 1 : 0) | 0;
                                            if (cVar5.L) {
                                                i7 = 2;
                                            } else {
                                                i7 = 0;
                                            }
                                            i8 = i25 | i7;
                                            if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                                iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                                i9 = 1;
                                            } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                                if (cVar5.n == 0) {
                                                    i13 = cVar5.l;
                                                    i10 = -1;
                                                    if (i13 == -1) {
                                                        i13 = cVar5.j;
                                                    }
                                                    cVar5.l = i13;
                                                    i14 = cVar5.m;
                                                    if (i14 == -1) {
                                                        i14 = cVar5.k;
                                                    }
                                                    cVar5.m = i14;
                                                } else {
                                                    i10 = -1;
                                                }
                                                i11 = cVar5.l;
                                                if (i11 != i10) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (cVar5.q) {
                                                    if (cVar5.w != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                                } else {
                                                    bVar = null;
                                                }
                                                iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                                i9 = 2;
                                            } else {
                                                if ("application/x-subrip".equals(str)) {
                                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                                } else {
                                                    if ("application/vobsub".equals(str)) {
                                                    }
                                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                                }
                                                i9 = 3;
                                            }
                                            n nVarA3 = hVar2.a(cVar5.f1086b, i9);
                                            cVar5.O = nVarA3;
                                            nVarA3.a(iVarA);
                                            SparseArray<d.c> sparseArray3 = dVar.c;
                                            d.c cVar8 = dVar.t;
                                            sparseArray3.put(cVar8.f1086b, cVar8);
                                            cVar = null;
                                        }
                                        z3 = false;
                                        if (z3) {
                                            iA = u.a(cVar5.H);
                                            if (iA == 0) {
                                                Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + cVar5.H + ". Setting mimeType to audio/x-unknown");
                                            } else {
                                                str6 = "audio/raw";
                                                i3 = iA;
                                                listSingletonList2 = null;
                                            }
                                            listSingletonList = listSingletonList2;
                                            iA2 = i3;
                                            str = str6;
                                            i6 = iA2;
                                            list = listSingletonList;
                                            i4 = -1;
                                            int i26 = (cVar5.M ? 1 : 0) | 0;
                                            if (cVar5.L) {
                                                i7 = 2;
                                            } else {
                                                i7 = 0;
                                            }
                                            i8 = i26 | i7;
                                            if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                                iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                                i9 = 1;
                                            } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                                if (cVar5.n == 0) {
                                                    i13 = cVar5.l;
                                                    i10 = -1;
                                                    if (i13 == -1) {
                                                        i13 = cVar5.j;
                                                    }
                                                    cVar5.l = i13;
                                                    i14 = cVar5.m;
                                                    if (i14 == -1) {
                                                        i14 = cVar5.k;
                                                    }
                                                    cVar5.m = i14;
                                                } else {
                                                    i10 = -1;
                                                }
                                                i11 = cVar5.l;
                                                if (i11 != i10) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (cVar5.q) {
                                                    if (cVar5.w != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                                } else {
                                                    bVar = null;
                                                }
                                                iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                                i9 = 2;
                                            } else {
                                                if ("application/x-subrip".equals(str)) {
                                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                                } else {
                                                    if ("application/vobsub".equals(str)) {
                                                    }
                                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                                }
                                                i9 = 3;
                                            }
                                            n nVarA4 = hVar2.a(cVar5.f1086b, i9);
                                            cVar5.O = nVarA4;
                                            nVarA4.a(iVarA);
                                            SparseArray<d.c> sparseArray4 = dVar.c;
                                            d.c cVar9 = dVar.t;
                                            sparseArray4.put(cVar9.f1086b, cVar9);
                                            cVar = null;
                                        } else {
                                            Log.w("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                                        }
                                        listSingletonList2 = null;
                                        i3 = -1;
                                        listSingletonList = listSingletonList2;
                                        iA2 = i3;
                                        str = str6;
                                        i6 = iA2;
                                        list = listSingletonList;
                                        i4 = -1;
                                        int i27 = (cVar5.M ? 1 : 0) | 0;
                                        if (cVar5.L) {
                                            i7 = 2;
                                        } else {
                                            i7 = 0;
                                        }
                                        i8 = i27 | i7;
                                        if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                            iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                            i9 = 1;
                                        } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                            if (cVar5.n == 0) {
                                                i13 = cVar5.l;
                                                i10 = -1;
                                                if (i13 == -1) {
                                                    i13 = cVar5.j;
                                                }
                                                cVar5.l = i13;
                                                i14 = cVar5.m;
                                                if (i14 == -1) {
                                                    i14 = cVar5.k;
                                                }
                                                cVar5.m = i14;
                                            } else {
                                                i10 = -1;
                                            }
                                            i11 = cVar5.l;
                                            if (i11 != i10) {
                                                f = -1.0f;
                                            } else {
                                                f = -1.0f;
                                            }
                                            if (cVar5.q) {
                                                if (cVar5.w != -1.0f) {
                                                    bArr = null;
                                                } else {
                                                    bArr = null;
                                                }
                                                bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                            } else {
                                                bVar = null;
                                            }
                                            iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                            i9 = 2;
                                        } else {
                                            if ("application/x-subrip".equals(str)) {
                                                iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                            } else {
                                                if ("application/vobsub".equals(str)) {
                                                }
                                                iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                            }
                                            i9 = 3;
                                        }
                                        n nVarA5 = hVar2.a(cVar5.f1086b, i9);
                                        cVar5.O = nVarA5;
                                        nVarA5.a(iVarA);
                                        SparseArray<d.c> sparseArray5 = dVar.c;
                                        d.c cVar10 = dVar.t;
                                        sparseArray5.put(cVar10.f1086b, cVar10);
                                        cVar = null;
                                        break;
                                    }
                                    z3 = true;
                                    if (z3) {
                                        iA = u.a(cVar5.H);
                                        if (iA == 0) {
                                            Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + cVar5.H + ". Setting mimeType to audio/x-unknown");
                                        } else {
                                            str6 = "audio/raw";
                                            i3 = iA;
                                            listSingletonList2 = null;
                                        }
                                        listSingletonList = listSingletonList2;
                                        iA2 = i3;
                                        str = str6;
                                        i6 = iA2;
                                        list = listSingletonList;
                                        i4 = -1;
                                        int i28 = (cVar5.M ? 1 : 0) | 0;
                                        if (cVar5.L) {
                                            i7 = 2;
                                        } else {
                                            i7 = 0;
                                        }
                                        i8 = i28 | i7;
                                        if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                            iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                            i9 = 1;
                                        } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                            if (cVar5.n == 0) {
                                                i13 = cVar5.l;
                                                i10 = -1;
                                                if (i13 == -1) {
                                                    i13 = cVar5.j;
                                                }
                                                cVar5.l = i13;
                                                i14 = cVar5.m;
                                                if (i14 == -1) {
                                                    i14 = cVar5.k;
                                                }
                                                cVar5.m = i14;
                                            } else {
                                                i10 = -1;
                                            }
                                            i11 = cVar5.l;
                                            if (i11 != i10) {
                                                f = -1.0f;
                                            } else {
                                                f = -1.0f;
                                            }
                                            if (cVar5.q) {
                                                if (cVar5.w != -1.0f) {
                                                    bArr = null;
                                                } else {
                                                    bArr = null;
                                                }
                                                bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                            } else {
                                                bVar = null;
                                            }
                                            iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                            i9 = 2;
                                        } else {
                                            if ("application/x-subrip".equals(str)) {
                                                iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                            } else {
                                                if ("application/vobsub".equals(str)) {
                                                }
                                                iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                            }
                                            i9 = 3;
                                        }
                                        n nVarA6 = hVar2.a(cVar5.f1086b, i9);
                                        cVar5.O = nVarA6;
                                        nVarA6.a(iVarA);
                                        SparseArray<d.c> sparseArray6 = dVar.c;
                                        d.c cVar11 = dVar.t;
                                        sparseArray6.put(cVar11.f1086b, cVar11);
                                        cVar = null;
                                    } else {
                                        Log.w("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                                    }
                                    listSingletonList2 = null;
                                    i3 = -1;
                                    listSingletonList = listSingletonList2;
                                    iA2 = i3;
                                    str = str6;
                                    i6 = iA2;
                                    list = listSingletonList;
                                    i4 = -1;
                                    int i29 = (cVar5.M ? 1 : 0) | 0;
                                    if (cVar5.L) {
                                        i7 = 2;
                                    } else {
                                        i7 = 0;
                                    }
                                    i8 = i29 | i7;
                                    if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                        i9 = 1;
                                    } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                        if (cVar5.n == 0) {
                                            i13 = cVar5.l;
                                            i10 = -1;
                                            if (i13 == -1) {
                                                i13 = cVar5.j;
                                            }
                                            cVar5.l = i13;
                                            i14 = cVar5.m;
                                            if (i14 == -1) {
                                                i14 = cVar5.k;
                                            }
                                            cVar5.m = i14;
                                        } else {
                                            i10 = -1;
                                        }
                                        i11 = cVar5.l;
                                        if (i11 != i10) {
                                            f = -1.0f;
                                        } else {
                                            f = -1.0f;
                                        }
                                        if (cVar5.q) {
                                            if (cVar5.w != -1.0f) {
                                                bArr = null;
                                            } else {
                                                bArr = null;
                                            }
                                            bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                        } else {
                                            bVar = null;
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                        i9 = 2;
                                    } else {
                                        if ("application/x-subrip".equals(str)) {
                                            iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                        } else {
                                            if ("application/vobsub".equals(str)) {
                                            }
                                            iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                        }
                                        i9 = 3;
                                    }
                                    n nVarA7 = hVar2.a(cVar5.f1086b, i9);
                                    cVar5.O = nVarA7;
                                    nVarA7.a(iVarA);
                                    SparseArray<d.c> sparseArray7 = dVar.c;
                                    d.c cVar12 = dVar.t;
                                    sparseArray7.put(cVar12.f1086b, cVar12);
                                    cVar = null;
                                } catch (ArrayIndexOutOfBoundsException unused) {
                                    throw new l("Error parsing MS/ACM codec private");
                                }
                                break;
                            case 3:
                                str6 = "audio/true-hd";
                                listSingletonList2 = null;
                                i3 = -1;
                                listSingletonList = listSingletonList2;
                                iA2 = i3;
                                str = str6;
                                i6 = iA2;
                                list = listSingletonList;
                                i4 = -1;
                                int i210 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i210 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA8 = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA8;
                                nVarA8.a(iVarA);
                                SparseArray<d.c> sparseArray8 = dVar.c;
                                d.c cVar13 = dVar.t;
                                sparseArray8.put(cVar13.f1086b, cVar13);
                                cVar = null;
                                break;
                            case 4:
                                byte[] bArr4 = cVar5.h;
                                try {
                                    if (bArr4[0] != 2) {
                                        throw new l("Error parsing vorbis codec private");
                                    }
                                    int i30 = 0;
                                    int i31 = 1;
                                    while (bArr4[i31] == -1) {
                                        i30 += 255;
                                        i31++;
                                    }
                                    int i32 = i31 + 1;
                                    int i33 = i30 + bArr4[i31];
                                    int i34 = 0;
                                    while (bArr4[i32] == -1) {
                                        i34 += 255;
                                        i32++;
                                    }
                                    int i35 = i32 + 1;
                                    int i36 = i34 + bArr4[i32];
                                    if (bArr4[i35] != 1) {
                                        throw new l("Error parsing vorbis codec private");
                                    }
                                    byte[] bArr5 = new byte[i33];
                                    System.arraycopy(bArr4, i35, bArr5, 0, i33);
                                    int i37 = i35 + i33;
                                    if (bArr4[i37] != 3) {
                                        throw new l("Error parsing vorbis codec private");
                                    }
                                    int i38 = i37 + i36;
                                    if (bArr4[i38] != 5) {
                                        throw new l("Error parsing vorbis codec private");
                                    }
                                    byte[] bArr6 = new byte[bArr4.length - i38];
                                    System.arraycopy(bArr4, i38, bArr6, 0, bArr4.length - i38);
                                    ArrayList arrayList = new ArrayList(2);
                                    arrayList.add(bArr5);
                                    arrayList.add(bArr6);
                                    str = "audio/vorbis";
                                    i4 = 8192;
                                    list = arrayList;
                                    i6 = -1;
                                    int i211 = (cVar5.M ? 1 : 0) | 0;
                                    if (cVar5.L) {
                                        i7 = 2;
                                    } else {
                                        i7 = 0;
                                    }
                                    i8 = i211 | i7;
                                    if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                        i9 = 1;
                                    } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                        if (cVar5.n == 0) {
                                            i13 = cVar5.l;
                                            i10 = -1;
                                            if (i13 == -1) {
                                                i13 = cVar5.j;
                                            }
                                            cVar5.l = i13;
                                            i14 = cVar5.m;
                                            if (i14 == -1) {
                                                i14 = cVar5.k;
                                            }
                                            cVar5.m = i14;
                                        } else {
                                            i10 = -1;
                                        }
                                        i11 = cVar5.l;
                                        if (i11 != i10) {
                                            f = -1.0f;
                                        } else {
                                            f = -1.0f;
                                        }
                                        if (cVar5.q) {
                                            if (cVar5.w != -1.0f) {
                                                bArr = null;
                                            } else {
                                                bArr = null;
                                            }
                                            bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                        } else {
                                            bVar = null;
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                        i9 = 2;
                                    } else {
                                        if ("application/x-subrip".equals(str)) {
                                            iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                        } else {
                                            if ("application/vobsub".equals(str)) {
                                            }
                                            iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                        }
                                        i9 = 3;
                                    }
                                    n nVarA9 = hVar2.a(cVar5.f1086b, i9);
                                    cVar5.O = nVarA9;
                                    nVarA9.a(iVarA);
                                    SparseArray<d.c> sparseArray9 = dVar.c;
                                    d.c cVar14 = dVar.t;
                                    sparseArray9.put(cVar14.f1086b, cVar14);
                                    cVar = null;
                                } catch (ArrayIndexOutOfBoundsException unused2) {
                                    throw new l("Error parsing vorbis codec private");
                                }
                                break;
                            case 5:
                                i5 = 4096;
                                str = "audio/mpeg-L2";
                                i4 = i5;
                                list = null;
                                i6 = -1;
                                int i212 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i212 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA10 = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA10;
                                nVarA10.a(iVarA);
                                SparseArray<d.c> sparseArray10 = dVar.c;
                                d.c cVar15 = dVar.t;
                                sparseArray10.put(cVar15.f1086b, cVar15);
                                cVar = null;
                                break;
                            case 6:
                                i5 = 4096;
                                str = "audio/mpeg";
                                i4 = i5;
                                list = null;
                                i6 = -1;
                                int i213 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i213 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA11 = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA11;
                                nVarA11.a(iVarA);
                                SparseArray<d.c> sparseArray11 = dVar.c;
                                d.c cVar16 = dVar.t;
                                sparseArray11.put(cVar16.f1086b, cVar16);
                                cVar = null;
                                break;
                            case 7:
                                byte[] bArr7 = cVar5.h;
                                try {
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.a((boolean) (16 <= bArr7.length ? i16 : r4 == true ? 1 : 0));
                                    if ((((((long) bArr7[17]) & 255) << 8) | (((long) bArr7[16]) & 255) | ((((long) bArr7[18]) & 255) << 16) | ((((long) bArr7[19]) & 255) << 24)) != 826496599) {
                                        listSingletonList2 = null;
                                    } else {
                                        int i39 = 40;
                                        while (true) {
                                            if (i39 >= bArr7.length - 4) {
                                                throw new l("Failed to find FourCC VC1 initialization data");
                                            }
                                            if (bArr7[i39] == 0 && bArr7[i39 + 1] == 0 && bArr7[i39 + 2] == 1 && bArr7[i39 + 3] == 15) {
                                                listSingletonList2 = Collections.singletonList(Arrays.copyOfRange(bArr7, i39, bArr7.length));
                                            } else {
                                                i39++;
                                            }
                                        }
                                    }
                                    if (listSingletonList2 != null) {
                                        str6 = "video/wvc1";
                                    } else {
                                        Log.w("MatroskaExtractor", "Unsupported FourCC. Setting mimeType to video/x-unknown");
                                        str6 = "video/x-unknown";
                                    }
                                    i3 = -1;
                                    listSingletonList = listSingletonList2;
                                    iA2 = i3;
                                    str = str6;
                                    i6 = iA2;
                                    list = listSingletonList;
                                    i4 = -1;
                                    int i214 = (cVar5.M ? 1 : 0) | 0;
                                    if (cVar5.L) {
                                        i7 = 2;
                                    } else {
                                        i7 = 0;
                                    }
                                    i8 = i214 | i7;
                                    if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                        i9 = 1;
                                    } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                        if (cVar5.n == 0) {
                                            i13 = cVar5.l;
                                            i10 = -1;
                                            if (i13 == -1) {
                                                i13 = cVar5.j;
                                            }
                                            cVar5.l = i13;
                                            i14 = cVar5.m;
                                            if (i14 == -1) {
                                                i14 = cVar5.k;
                                            }
                                            cVar5.m = i14;
                                        } else {
                                            i10 = -1;
                                        }
                                        i11 = cVar5.l;
                                        if (i11 != i10) {
                                            f = -1.0f;
                                        } else {
                                            f = -1.0f;
                                        }
                                        if (cVar5.q) {
                                            if (cVar5.w != -1.0f) {
                                                bArr = null;
                                            } else {
                                                bArr = null;
                                            }
                                            bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                        } else {
                                            bVar = null;
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                        i9 = 2;
                                    } else {
                                        if ("application/x-subrip".equals(str)) {
                                            iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                        } else {
                                            if ("application/vobsub".equals(str)) {
                                            }
                                            iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                        }
                                        i9 = 3;
                                    }
                                    n nVarA12 = hVar2.a(cVar5.f1086b, i9);
                                    cVar5.O = nVarA12;
                                    nVarA12.a(iVarA);
                                    SparseArray<d.c> sparseArray12 = dVar.c;
                                    d.c cVar17 = dVar.t;
                                    sparseArray12.put(cVar17.f1086b, cVar17);
                                    cVar = null;
                                } catch (ArrayIndexOutOfBoundsException unused3) {
                                    throw new l("Error parsing FourCC VC1 codec private");
                                }
                                break;
                            case 8:
                                byte[] bArr8 = new byte[4];
                                byte[] bArr9 = cVar5.h;
                                bArr8[r4 == true ? 1 : 0] = bArr9[r4 == true ? 1 : 0];
                                bArr8[i16] = bArr9[i16];
                                bArr8[2] = bArr9[2];
                                bArr8[3] = bArr9[3];
                                listSingletonList3 = Collections.singletonList(bArr8);
                                str2 = "application/dvbsubs";
                                str = str2;
                                listSingletonList = listSingletonList3;
                                iA2 = -1;
                                i6 = iA2;
                                list = listSingletonList;
                                i4 = -1;
                                int i215 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i215 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA13 = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA13;
                                nVarA13.a(iVarA);
                                SparseArray<d.c> sparseArray13 = dVar.c;
                                d.c cVar18 = dVar.t;
                                sparseArray13.put(cVar18.f1086b, cVar18);
                                cVar = null;
                                break;
                            case 10:
                                com.fyber.inneractive.sdk.player.exoplayer2.video.a aVarB = com.fyber.inneractive.sdk.player.exoplayer2.video.a.b(new k(cVar5.h));
                                listSingletonList = aVarB.a;
                                cVar5.P = aVarB.f1251b;
                                str3 = "video/avc";
                                str = str3;
                                iA2 = -1;
                                i6 = iA2;
                                list = listSingletonList;
                                i4 = -1;
                                int i216 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i216 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA14 = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA14;
                                nVarA14.a(iVarA);
                                SparseArray<d.c> sparseArray14 = dVar.c;
                                d.c cVar19 = dVar.t;
                                sparseArray14.put(cVar19.f1086b, cVar19);
                                cVar = null;
                                break;
                            case 11:
                                listSingletonList3 = Collections.singletonList(cVar5.h);
                                str2 = "application/vobsub";
                                str = str2;
                                listSingletonList = listSingletonList3;
                                iA2 = -1;
                                i6 = iA2;
                                list = listSingletonList;
                                i4 = -1;
                                int i217 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i217 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA15 = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA15;
                                nVarA15.a(iVarA);
                                SparseArray<d.c> sparseArray15 = dVar.c;
                                d.c cVar110 = dVar.t;
                                sparseArray15.put(cVar110.f1086b, cVar110);
                                cVar = null;
                                break;
                            case 12:
                                str6 = "audio/vnd.dts.hd";
                                listSingletonList2 = null;
                                i3 = -1;
                                listSingletonList = listSingletonList2;
                                iA2 = i3;
                                str = str6;
                                i6 = iA2;
                                list = listSingletonList;
                                i4 = -1;
                                int i218 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i218 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA16 = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA16;
                                nVarA16.a(iVarA);
                                SparseArray<d.c> sparseArray16 = dVar.c;
                                d.c cVar111 = dVar.t;
                                sparseArray16.put(cVar111.f1086b, cVar111);
                                cVar = null;
                                break;
                            case 13:
                                listSingletonList3 = Collections.singletonList(cVar5.h);
                                str2 = "audio/mp4a-latm";
                                str = str2;
                                listSingletonList = listSingletonList3;
                                iA2 = -1;
                                i6 = iA2;
                                list = listSingletonList;
                                i4 = -1;
                                int i219 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i219 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA17 = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA17;
                                nVarA17.a(iVarA);
                                SparseArray<d.c> sparseArray17 = dVar.c;
                                d.c cVar112 = dVar.t;
                                sparseArray17.put(cVar112.f1086b, cVar112);
                                cVar = null;
                                break;
                            case 14:
                                str6 = "audio/ac3";
                                listSingletonList2 = null;
                                i3 = -1;
                                listSingletonList = listSingletonList2;
                                iA2 = i3;
                                str = str6;
                                i6 = iA2;
                                list = listSingletonList;
                                i4 = -1;
                                int i2110 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i2110 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA18 = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA18;
                                nVarA18.a(iVarA);
                                SparseArray<d.c> sparseArray18 = dVar.c;
                                d.c cVar113 = dVar.t;
                                sparseArray18.put(cVar113.f1086b, cVar113);
                                cVar = null;
                                break;
                            case 15:
                            case 20:
                                str6 = "audio/vnd.dts";
                                listSingletonList2 = null;
                                i3 = -1;
                                listSingletonList = listSingletonList2;
                                iA2 = i3;
                                str = str6;
                                i6 = iA2;
                                list = listSingletonList;
                                i4 = -1;
                                int i2111 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i2111 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA19 = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA19;
                                nVarA19.a(iVarA);
                                SparseArray<d.c> sparseArray19 = dVar.c;
                                d.c cVar114 = dVar.t;
                                sparseArray19.put(cVar114.f1086b, cVar114);
                                cVar = null;
                                break;
                            case 16:
                                str6 = "video/x-vnd.on2.vp8";
                                listSingletonList2 = null;
                                i3 = -1;
                                listSingletonList = listSingletonList2;
                                iA2 = i3;
                                str = str6;
                                i6 = iA2;
                                list = listSingletonList;
                                i4 = -1;
                                int i2112 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i2112 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA110 = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA110;
                                nVarA110.a(iVarA);
                                SparseArray<d.c> sparseArray110 = dVar.c;
                                d.c cVar115 = dVar.t;
                                sparseArray110.put(cVar115.f1086b, cVar115);
                                cVar = null;
                                break;
                            case 17:
                                str6 = "video/x-vnd.on2.vp9";
                                listSingletonList2 = null;
                                i3 = -1;
                                listSingletonList = listSingletonList2;
                                iA2 = i3;
                                str = str6;
                                i6 = iA2;
                                list = listSingletonList;
                                i4 = -1;
                                int i2113 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i2113 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA111 = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA111;
                                nVarA111.a(iVarA);
                                SparseArray<d.c> sparseArray111 = dVar.c;
                                d.c cVar116 = dVar.t;
                                sparseArray111.put(cVar116.f1086b, cVar116);
                                cVar = null;
                                break;
                            case 18:
                                str6 = "application/pgs";
                                listSingletonList2 = null;
                                i3 = -1;
                                listSingletonList = listSingletonList2;
                                iA2 = i3;
                                str = str6;
                                i6 = iA2;
                                list = listSingletonList;
                                i4 = -1;
                                int i2114 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i2114 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA112 = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA112;
                                nVarA112.a(iVarA);
                                SparseArray<d.c> sparseArray112 = dVar.c;
                                d.c cVar117 = dVar.t;
                                sparseArray112.put(cVar117.f1086b, cVar117);
                                cVar = null;
                                break;
                            case 19:
                                str6 = "video/x-unknown";
                                listSingletonList2 = null;
                                i3 = -1;
                                listSingletonList = listSingletonList2;
                                iA2 = i3;
                                str = str6;
                                i6 = iA2;
                                list = listSingletonList;
                                i4 = -1;
                                int i2115 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i2115 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA113 = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA113;
                                nVarA113.a(iVarA);
                                SparseArray<d.c> sparseArray113 = dVar.c;
                                d.c cVar118 = dVar.t;
                                sparseArray113.put(cVar118.f1086b, cVar118);
                                cVar = null;
                                break;
                            case 21:
                                iA2 = u.a(cVar5.H);
                                if (iA2 == 0) {
                                    Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + cVar5.H + ". Setting mimeType to audio/x-unknown");
                                    listSingletonList2 = null;
                                    i3 = -1;
                                    listSingletonList = listSingletonList2;
                                    iA2 = i3;
                                    str = str6;
                                } else {
                                    str = "audio/raw";
                                    listSingletonList = null;
                                }
                                i6 = iA2;
                                list = listSingletonList;
                                i4 = -1;
                                int i2116 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i2116 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA114 = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA114;
                                nVarA114.a(iVarA);
                                SparseArray<d.c> sparseArray114 = dVar.c;
                                d.c cVar119 = dVar.t;
                                sparseArray114.put(cVar119.f1086b, cVar119);
                                cVar = null;
                                break;
                            case 22:
                                com.fyber.inneractive.sdk.player.exoplayer2.video.c cVarA = com.fyber.inneractive.sdk.player.exoplayer2.video.c.a(new k(cVar5.h));
                                listSingletonList = cVarA.a;
                                cVar5.P = cVarA.f1253b;
                                str3 = "video/hevc";
                                str = str3;
                                iA2 = -1;
                                i6 = iA2;
                                list = listSingletonList;
                                i4 = -1;
                                int i2117 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i2117 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA115 = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA115;
                                nVarA115.a(iVarA);
                                SparseArray<d.c> sparseArray115 = dVar.c;
                                d.c cVar1110 = dVar.t;
                                sparseArray115.put(cVar1110.f1086b, cVar1110);
                                cVar = null;
                                break;
                            case 23:
                                str6 = "application/x-subrip";
                                listSingletonList2 = null;
                                i3 = -1;
                                listSingletonList = listSingletonList2;
                                iA2 = i3;
                                str = str6;
                                i6 = iA2;
                                list = listSingletonList;
                                i4 = -1;
                                int i2118 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i2118 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA116 = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA116;
                                nVarA116.a(iVarA);
                                SparseArray<d.c> sparseArray116 = dVar.c;
                                d.c cVar1111 = dVar.t;
                                sparseArray116.put(cVar1111.f1086b, cVar1111);
                                cVar = null;
                                break;
                            case 24:
                                str6 = "video/mpeg2";
                                listSingletonList2 = null;
                                i3 = -1;
                                listSingletonList = listSingletonList2;
                                iA2 = i3;
                                str = str6;
                                i6 = iA2;
                                list = listSingletonList;
                                i4 = -1;
                                int i2119 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i2119 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA117 = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA117;
                                nVarA117.a(iVarA);
                                SparseArray<d.c> sparseArray117 = dVar.c;
                                d.c cVar1112 = dVar.t;
                                sparseArray117.put(cVar1112.f1086b, cVar1112);
                                cVar = null;
                                break;
                            case 25:
                                str6 = "audio/eac3";
                                listSingletonList2 = null;
                                i3 = -1;
                                listSingletonList = listSingletonList2;
                                iA2 = i3;
                                str = str6;
                                i6 = iA2;
                                list = listSingletonList;
                                i4 = -1;
                                int i21110 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i21110 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA118 = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA118;
                                nVarA118.a(iVarA);
                                SparseArray<d.c> sparseArray118 = dVar.c;
                                d.c cVar1113 = dVar.t;
                                sparseArray118.put(cVar1113.f1086b, cVar1113);
                                cVar = null;
                                break;
                            case 26:
                                listSingletonList3 = Collections.singletonList(cVar5.h);
                                str2 = "audio/flac";
                                str = str2;
                                listSingletonList = listSingletonList3;
                                iA2 = -1;
                                i6 = iA2;
                                list = listSingletonList;
                                i4 = -1;
                                int i21111 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i21111 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA119 = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA119;
                                nVarA119.a(iVarA);
                                SparseArray<d.c> sparseArray119 = dVar.c;
                                d.c cVar1114 = dVar.t;
                                sparseArray119.put(cVar1114.f1086b, cVar1114);
                                cVar = null;
                                break;
                            case 27:
                                ArrayList arrayList2 = new ArrayList(3);
                                arrayList2.add(cVar5.h);
                                arrayList2.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(cVar5.J).array());
                                arrayList2.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(cVar5.K).array());
                                str = "audio/opus";
                                i4 = 5760;
                                list = arrayList2;
                                i6 = -1;
                                int i21112 = (cVar5.M ? 1 : 0) | 0;
                                if (cVar5.L) {
                                    i7 = 2;
                                } else {
                                    i7 = 0;
                                }
                                i8 = i21112 | i7;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.G, cVar5.I, i6, (List<byte[]>) list, cVar5.i, i8, cVar5.N);
                                    i9 = 1;
                                } else if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                                    if (cVar5.n == 0) {
                                        i13 = cVar5.l;
                                        i10 = -1;
                                        if (i13 == -1) {
                                            i13 = cVar5.j;
                                        }
                                        cVar5.l = i13;
                                        i14 = cVar5.m;
                                        if (i14 == -1) {
                                            i14 = cVar5.k;
                                        }
                                        cVar5.m = i14;
                                    } else {
                                        i10 = -1;
                                    }
                                    i11 = cVar5.l;
                                    if (i11 != i10) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (cVar5.q) {
                                        if (cVar5.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        bVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(cVar5.r, cVar5.t, cVar5.s, bArr);
                                    } else {
                                        bVar = null;
                                    }
                                    iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i4, cVar5.j, cVar5.k, -1.0f, (List<byte[]>) list, -1, f, cVar5.o, cVar5.p, bVar, cVar5.i);
                                    i9 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, i8, cVar5.N, cVar5.i);
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        iVarA = i.a(Integer.toString(i22), str, (String) null, -1, (List<byte[]>) list, cVar5.N, cVar5.i);
                                    }
                                    i9 = 3;
                                }
                                n nVarA1110 = hVar2.a(cVar5.f1086b, i9);
                                cVar5.O = nVarA1110;
                                nVarA1110.a(iVarA);
                                SparseArray<d.c> sparseArray1110 = dVar.c;
                                d.c cVar1115 = dVar.t;
                                sparseArray1110.put(cVar1115.f1086b, cVar1115);
                                cVar = null;
                                break;
                            default:
                                throw new l("Unrecognized codec identifier.");
                        }
                    } else {
                        cVar = null;
                    }
                    dVar.t = cVar;
                } else if (dVar.E == 2) {
                    if (!dVar.X) {
                        dVar.M |= 1;
                    }
                    dVar.a(dVar.c.get(dVar.K), dVar.F);
                    dVar.E = 0;
                }
                return true;
            }
            boolean z4 = r4 == true ? 1 : 0;
            ?? r5 = i16;
            if (this.e == 0) {
                long jA = this.c.a(gVar, r5, z4, 4);
                if (jA == -2) {
                    ?? r6 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
                    r6.e = z4 ? 1 : 0;
                    ?? r3 = z4;
                    while (true) {
                        r6.a(this.a, r3, 4, r3);
                        int iA3 = f.a(this.a[r3]);
                        if (iA3 != -1 && iA3 <= 4) {
                            int iA4 = (int) f.a(this.a, iA3, r3);
                            if (((d.b) this.d).a(iA4)) {
                                r6.c(iA3);
                                jA = iA4;
                            }
                        }
                        r6.c(1);
                        r3 = 0;
                    }
                }
                z2 = true;
                if (jA == -1) {
                    return false;
                }
                z = false;
                this.f = (int) jA;
                this.e = 1;
            } else {
                z = z4 ? 1 : 0;
                z2 = r5 == true ? 1 : 0;
            }
            if (this.e == z2) {
                this.g = this.c.a(gVar, z, z2, 8);
                this.e = 2;
            }
            c cVar20 = this.d;
            int i40 = this.f;
            d.this.getClass();
            switch (i40) {
                case 131:
                case 136:
                case 155:
                case 159:
                case 176:
                case 179:
                case 186:
                case 215:
                case 231:
                case 241:
                case 251:
                case 16980:
                case 17029:
                case 17143:
                case 18401:
                case 18408:
                case 20529:
                case 20530:
                case 21420:
                case 21432:
                case 21680:
                case 21682:
                case 21690:
                case 21930:
                case 21945:
                case 21946:
                case 21947:
                case 21948:
                case 21949:
                case 22186:
                case 22203:
                case 25188:
                case 2352003:
                case 2807729:
                    i = 2;
                    break;
                case 134:
                case FirebaseError.ERROR_WEAK_PASSWORD /* 17026 */:
                case 2274716:
                    i = 3;
                    break;
                case 160:
                case 174:
                case 183:
                case 187:
                case 224:
                case 225:
                case 18407:
                case 19899:
                case 20532:
                case 20533:
                case 21936:
                case 21968:
                case 25152:
                case 28032:
                case 30320:
                case 290298740:
                case 357149030:
                case 374648427:
                case 408125543:
                case 440786851:
                case 475249515:
                case 524531317:
                    i = 1;
                    break;
                case 161:
                case 163:
                case 16981:
                case 18402:
                case 21419:
                case 25506:
                case 30322:
                    i = 4;
                    break;
                case 181:
                case 17545:
                case 21969:
                case 21970:
                case 21971:
                case 21972:
                case 21973:
                case 21974:
                case 21975:
                case 21976:
                case 21977:
                case 21978:
                    i = 5;
                    break;
                default:
                    i = 0;
                    break;
            }
            if (i != 0) {
                if (i == 1) {
                    long j3 = ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).c;
                    this.f1083b.add(new C0289a(this.f, this.g + j3));
                    ((d.b) this.d).a(this.f, j3, this.g);
                    this.e = 0;
                    return true;
                }
                if (i == 2) {
                    long j4 = this.g;
                    if (j4 > 8) {
                        throw new l("Invalid integer size: " + this.g);
                    }
                    ((d.b) this.d).a(this.f, b(gVar, (int) j4));
                    this.e = 0;
                    return true;
                }
                if (i == 3) {
                    long j5 = this.g;
                    if (j5 > 2147483647L) {
                        throw new l("String element size: " + this.g);
                    }
                    ((d.b) this.d).a(this.f, c(gVar, (int) j5));
                    this.e = 0;
                    return true;
                }
                if (i == 4) {
                    ((d.b) this.d).a(this.f, (int) this.g, gVar);
                    this.e = 0;
                    return true;
                }
                if (i != 5) {
                    throw new l("Invalid element type " + i);
                }
                long j6 = this.g;
                if (j6 != 4 && j6 != 8) {
                    throw new l("Invalid float size: " + this.g);
                }
                ((d.b) this.d).a(this.f, a(gVar, (int) j6));
                this.e = 0;
                return true;
            }
            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).c((int) this.g);
            this.e = 0;
            i16 = 1;
            r4 = 0;
        }
    }

    public final String c(g gVar, int i) throws InterruptedException, IOException {
        if (i == 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(bArr, 0, i, false);
        return new String(bArr);
    }

    public final double a(g gVar, int i) throws InterruptedException, IOException {
        long jB = b(gVar, i);
        if (i == 4) {
            return Float.intBitsToFloat((int) jB);
        }
        return Double.longBitsToDouble(jB);
    }
}
