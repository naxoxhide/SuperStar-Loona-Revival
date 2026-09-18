package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.i;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.f {
    public static final byte[] Z = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    public static final byte[] a0 = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    public static final UUID b0 = new UUID(72057594037932032L, -9223371306706625679L);
    public com.fyber.inneractive.sdk.player.exoplayer2.util.f B;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.f C;
    public boolean D;
    public int E;
    public long F;
    public long G;
    public int H;
    public int I;
    public int[] J;
    public int K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public byte S;
    public int T;
    public int U;
    public int V;
    public boolean W;
    public boolean X;
    public h Y;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f1085b;
    public final SparseArray<c> c;
    public final boolean d;
    public final k e;
    public final k f;
    public final k g;
    public final k h;
    public final k i;
    public final k j;
    public final k k;
    public final k l;
    public final k m;
    public ByteBuffer n;
    public long o;
    public c t;
    public boolean u;
    public int v;
    public long w;
    public boolean x;
    public long p = -1;
    public long q = -9223372036854775807L;
    public long r = -9223372036854775807L;
    public long s = -9223372036854775807L;
    public long y = -1;
    public long z = -1;
    public long A = -9223372036854775807L;

    public class a implements i {
    }

    public final class b implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.c {
        public b() {
        }

        public boolean a(int i) {
            d.this.getClass();
            return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
        }

        public /* synthetic */ b(d dVar, a aVar) {
            this();
        }

        public void a(int i, long j, long j2) throws l {
            d dVar = d.this;
            dVar.getClass();
            if (i == 160) {
                dVar.X = false;
                return;
            }
            if (i == 174) {
                dVar.t = new c();
                return;
            }
            if (i == 187) {
                dVar.D = false;
                return;
            }
            if (i == 19899) {
                dVar.v = -1;
                dVar.w = -1L;
                return;
            }
            if (i == 20533) {
                dVar.t.e = true;
                return;
            }
            if (i == 21968) {
                dVar.t.q = true;
                return;
            }
            if (i == 408125543) {
                long j3 = dVar.p;
                if (j3 != -1 && j3 != j) {
                    throw new l("Multiple Segment elements not supported");
                }
                dVar.p = j;
                dVar.o = j2;
                return;
            }
            if (i == 475249515) {
                dVar.B = new com.fyber.inneractive.sdk.player.exoplayer2.util.f(32);
                dVar.C = new com.fyber.inneractive.sdk.player.exoplayer2.util.f(32);
            } else if (i == 524531317 && !dVar.u) {
                if (dVar.d && dVar.y != -1) {
                    dVar.x = true;
                } else {
                    dVar.Y.a(new m.a(dVar.s));
                    dVar.u = true;
                }
            }
        }

        public void a(int i, long j) throws l {
            d dVar = d.this;
            dVar.getClass();
            if (i == 20529) {
                if (j != 0) {
                    throw new l("ContentEncodingOrder " + j + " not supported");
                }
                return;
            }
            if (i == 20530) {
                if (j != 1) {
                    throw new l("ContentEncodingScope " + j + " not supported");
                }
                return;
            }
            switch (i) {
                case 131:
                    dVar.t.c = (int) j;
                    return;
                case 136:
                    dVar.t.L = j == 1;
                    return;
                case 155:
                    dVar.G = dVar.a(j);
                    return;
                case 159:
                    dVar.t.G = (int) j;
                    return;
                case 176:
                    dVar.t.j = (int) j;
                    return;
                case 179:
                    dVar.B.a(dVar.a(j));
                    return;
                case 186:
                    dVar.t.k = (int) j;
                    return;
                case 215:
                    dVar.t.f1086b = (int) j;
                    return;
                case 231:
                    dVar.A = dVar.a(j);
                    return;
                case 241:
                    if (dVar.D) {
                        return;
                    }
                    dVar.C.a(j);
                    dVar.D = true;
                    return;
                case 251:
                    dVar.X = true;
                    return;
                case 16980:
                    if (j != 3) {
                        throw new l("ContentCompAlgo " + j + " not supported");
                    }
                    return;
                case 17029:
                    if (j < 1 || j > 2) {
                        throw new l("DocTypeReadVersion " + j + " not supported");
                    }
                    return;
                case 17143:
                    if (j != 1) {
                        throw new l("EBMLReadVersion " + j + " not supported");
                    }
                    return;
                case 18401:
                    if (j != 5) {
                        throw new l("ContentEncAlgo " + j + " not supported");
                    }
                    return;
                case 18408:
                    if (j != 1) {
                        throw new l("AESSettingsCipherMode " + j + " not supported");
                    }
                    return;
                case 21420:
                    dVar.w = j + dVar.p;
                    return;
                case 21432:
                    int i2 = (int) j;
                    if (i2 == 0) {
                        dVar.t.p = 0;
                        return;
                    }
                    if (i2 == 1) {
                        dVar.t.p = 2;
                        return;
                    } else if (i2 == 3) {
                        dVar.t.p = 1;
                        return;
                    } else {
                        if (i2 != 15) {
                            return;
                        }
                        dVar.t.p = 3;
                        return;
                    }
                case 21680:
                    dVar.t.l = (int) j;
                    return;
                case 21682:
                    dVar.t.n = (int) j;
                    return;
                case 21690:
                    dVar.t.m = (int) j;
                    return;
                case 21930:
                    dVar.t.M = j == 1;
                    return;
                case 22186:
                    dVar.t.J = j;
                    return;
                case 22203:
                    dVar.t.K = j;
                    return;
                case 25188:
                    dVar.t.H = (int) j;
                    return;
                case 2352003:
                    dVar.t.d = (int) j;
                    return;
                case 2807729:
                    dVar.q = j;
                    return;
                default:
                    switch (i) {
                        case 21945:
                            int i3 = (int) j;
                            if (i3 == 1) {
                                dVar.t.t = 2;
                                return;
                            } else {
                                if (i3 != 2) {
                                    return;
                                }
                                dVar.t.t = 1;
                                return;
                            }
                        case 21946:
                            int i4 = (int) j;
                            if (i4 != 1) {
                                if (i4 == 16) {
                                    dVar.t.s = 6;
                                    return;
                                } else if (i4 == 18) {
                                    dVar.t.s = 7;
                                    return;
                                } else if (i4 != 6 && i4 != 7) {
                                    return;
                                }
                            }
                            dVar.t.s = 3;
                            return;
                        case 21947:
                            c cVar = dVar.t;
                            cVar.q = true;
                            int i5 = (int) j;
                            if (i5 == 1) {
                                cVar.r = 1;
                                return;
                            }
                            if (i5 == 9) {
                                cVar.r = 6;
                                return;
                            } else {
                                if (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) {
                                    cVar.r = 2;
                                    return;
                                }
                                return;
                            }
                        case 21948:
                            dVar.t.u = (int) j;
                            return;
                        case 21949:
                            dVar.t.v = (int) j;
                            return;
                        default:
                            return;
                    }
            }
        }

        public void a(int i, double d) throws l {
            d dVar = d.this;
            dVar.getClass();
            if (i == 181) {
                dVar.t.I = (int) d;
                return;
            }
            if (i != 17545) {
                switch (i) {
                    case 21969:
                        dVar.t.w = (float) d;
                        break;
                    case 21970:
                        dVar.t.x = (float) d;
                        break;
                    case 21971:
                        dVar.t.y = (float) d;
                        break;
                    case 21972:
                        dVar.t.z = (float) d;
                        break;
                    case 21973:
                        dVar.t.A = (float) d;
                        break;
                    case 21974:
                        dVar.t.B = (float) d;
                        break;
                    case 21975:
                        dVar.t.C = (float) d;
                        break;
                    case 21976:
                        dVar.t.D = (float) d;
                        break;
                    case 21977:
                        dVar.t.E = (float) d;
                        break;
                    case 21978:
                        dVar.t.F = (float) d;
                        break;
                }
                return;
            }
            dVar.r = (long) d;
        }

        public void a(int i, String str) throws l {
            d dVar = d.this;
            dVar.getClass();
            if (i == 134) {
                dVar.t.a = str;
                return;
            }
            if (i != 17026) {
                if (i != 2274716) {
                    return;
                }
                dVar.t.N = str;
            } else if (!"webm".equals(str) && !"matroska".equals(str)) {
                throw new l("DocType " + str + " not supported");
            }
        }

        public void a(int i, int i2, g gVar) throws InterruptedException, IOException {
            int i3;
            int i4;
            int i5;
            int[] iArr;
            d dVar = d.this;
            dVar.getClass();
            int i6 = 0;
            if (i != 161 && i != 163) {
                if (i == 16981) {
                    c cVar = dVar.t;
                    byte[] bArr = new byte[i2];
                    cVar.f = bArr;
                    ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(bArr, 0, i2, false);
                    return;
                }
                if (i == 18402) {
                    c cVar2 = dVar.t;
                    byte[] bArr2 = new byte[i2];
                    cVar2.g = bArr2;
                    ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(bArr2, 0, i2, false);
                    return;
                }
                if (i == 21419) {
                    Arrays.fill(dVar.i.a, (byte) 0);
                    ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(dVar.i.a, 4 - i2, i2, false);
                    dVar.i.e(0);
                    dVar.v = (int) dVar.i.m();
                    return;
                }
                if (i == 25506) {
                    c cVar3 = dVar.t;
                    byte[] bArr3 = new byte[i2];
                    cVar3.h = bArr3;
                    ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(bArr3, 0, i2, false);
                    return;
                }
                if (i != 30322) {
                    throw new l("Unexpected id: " + i);
                }
                c cVar4 = dVar.t;
                byte[] bArr4 = new byte[i2];
                cVar4.o = bArr4;
                ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(bArr4, 0, i2, false);
                return;
            }
            int i7 = 8;
            int i8 = 1;
            if (dVar.E == 0) {
                dVar.K = (int) dVar.f1085b.a(gVar, false, true, 8);
                dVar.L = dVar.f1085b.c;
                dVar.G = -9223372036854775807L;
                dVar.E = 1;
                dVar.g.r();
            }
            c cVar5 = dVar.c.get(dVar.K);
            if (cVar5 == null) {
                ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).c(i2 - dVar.L);
                dVar.E = 0;
                return;
            }
            if (dVar.E == 1) {
                dVar.a(gVar, 3);
                int i9 = (dVar.g.a[2] & 6) >> 1;
                if (i9 == 0) {
                    dVar.I = 1;
                    int[] iArrA = d.a(dVar.J, 1);
                    dVar.J = iArrA;
                    iArrA[0] = (i2 - dVar.L) - 3;
                } else if (i == 163) {
                    int i10 = 4;
                    dVar.a(gVar, 4);
                    int i11 = (dVar.g.a[3] & 255) + 1;
                    dVar.I = i11;
                    int[] iArrA2 = d.a(dVar.J, i11);
                    dVar.J = iArrA2;
                    if (i9 != 2) {
                        if (i9 != 1) {
                            if (i9 != 3) {
                                throw new l("Unexpected lacing value: " + i9);
                            }
                            int i12 = 0;
                            int i13 = 0;
                            while (true) {
                                int i14 = dVar.I - i8;
                                if (i12 < i14) {
                                    dVar.J[i12] = i6;
                                    i10++;
                                    dVar.a(gVar, i10);
                                    int i15 = i10 - 1;
                                    if (dVar.g.a[i15] == 0) {
                                        throw new l("No valid varint length mask found");
                                    }
                                    long j = 0;
                                    int i16 = i6;
                                    while (i16 < i7) {
                                        int i17 = i8 << (7 - i16);
                                        if ((dVar.g.a[i15] & i17) != 0) {
                                            i10 += i16;
                                            dVar.a(gVar, i10);
                                            j = dVar.g.a[i15] & 255 & (~i17);
                                            for (int i18 = i15 + 1; i18 < i10; i18++) {
                                                j = (j << 8) | ((long) (dVar.g.a[i18] & 255));
                                            }
                                            if (i12 <= 0) {
                                                break;
                                            }
                                            j -= (1 << ((i16 * 7) + 6)) - 1;
                                            break;
                                        }
                                        i16++;
                                        i7 = 8;
                                        i8 = 1;
                                    }
                                    long j2 = j;
                                    if (j2 >= -2147483648L && j2 <= 2147483647L) {
                                        int i19 = (int) j2;
                                        int[] iArr2 = dVar.J;
                                        if (i12 != 0) {
                                            i19 += iArr2[i12 - 1];
                                        }
                                        iArr2[i12] = i19;
                                        i13 += iArr2[i12];
                                        i12++;
                                        i6 = 0;
                                        i7 = 8;
                                        i8 = 1;
                                    } else {
                                        throw new l("EBML lacing sample size out of range.");
                                    }
                                } else {
                                    dVar.J[i14] = ((i2 - dVar.L) - i10) - i13;
                                    break;
                                }
                            }
                        } else {
                            int i20 = 0;
                            int i21 = 0;
                            while (true) {
                                i4 = dVar.I - 1;
                                if (i20 >= i4) {
                                    break;
                                }
                                dVar.J[i20] = 0;
                                do {
                                    i10++;
                                    dVar.a(gVar, i10);
                                    i5 = dVar.g.a[i10 - 1] & 255;
                                    iArr = dVar.J;
                                    iArr[i20] = iArr[i20] + i5;
                                } while (i5 == 255);
                                i21 += iArr[i20];
                                i20++;
                            }
                            dVar.J[i4] = ((i2 - dVar.L) - i10) - i21;
                        }
                    } else {
                        int i22 = (i2 - dVar.L) - 4;
                        int i23 = dVar.I;
                        Arrays.fill(iArrA2, 0, i23, i22 / i23);
                    }
                } else {
                    throw new l("Lacing only supported in SimpleBlocks.");
                }
                byte[] bArr5 = dVar.g.a;
                dVar.F = dVar.A + dVar.a((bArr5[1] & 255) | (bArr5[0] << 8));
                byte[] bArr6 = dVar.g.a;
                dVar.M = ((cVar5.c == 2 || (i == 163 && (bArr6[2] & 128) == 128)) ? 1 : 0) | ((bArr6[2] & 8) == 8 ? Integer.MIN_VALUE : 0);
                dVar.E = 2;
                dVar.H = 0;
                i3 = 163;
            } else {
                i3 = 163;
            }
            if (i != i3) {
                dVar.a(gVar, cVar5, dVar.J[0]);
                return;
            }
            while (true) {
                int i24 = dVar.H;
                if (i24 < dVar.I) {
                    dVar.a(gVar, cVar5, dVar.J[i24]);
                    dVar.a(cVar5, dVar.F + ((long) ((dVar.H * cVar5.d) / 1000)));
                    dVar.H++;
                } else {
                    dVar.E = 0;
                    return;
                }
            }
        }
    }

    public static final class c {
        public boolean L;
        public n O;
        public int P;
        public String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1086b;
        public int c;
        public int d;
        public boolean e;
        public byte[] f;
        public byte[] g;
        public byte[] h;
        public com.fyber.inneractive.sdk.player.exoplayer2.drm.a i;
        public int j = -1;
        public int k = -1;
        public int l = -1;
        public int m = -1;
        public int n = 0;
        public byte[] o = null;
        public int p = -1;
        public boolean q = false;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = 1000;
        public int v = 200;
        public float w = -1.0f;
        public float x = -1.0f;
        public float y = -1.0f;
        public float z = -1.0f;
        public float A = -1.0f;
        public float B = -1.0f;
        public float C = -1.0f;
        public float D = -1.0f;
        public float E = -1.0f;
        public float F = -1.0f;
        public int G = 1;
        public int H = -1;
        public int I = 8000;
        public long J = 0;
        public long K = 0;
        public boolean M = true;
        public String N = "eng";
    }

    public d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.b bVar, int i) {
        this.a = bVar;
        ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.a) bVar).a(new b(this, null));
        this.d = (i & 1) == 0;
        this.f1085b = new f();
        this.c = new SparseArray<>();
        this.g = new k(4);
        this.h = new k(ByteBuffer.allocate(4).putInt(-1).array());
        this.i = new k(4);
        this.e = new k(com.fyber.inneractive.sdk.player.exoplayer2.util.i.a);
        this.f = new k(4);
        this.j = new k();
        this.k = new k();
        this.l = new k(8);
        this.m = new k();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public boolean a(g gVar) throws InterruptedException, IOException {
        e eVar = new e();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
        long j = bVar.f1057b;
        long j2 = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        if (j != -1 && j <= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            j2 = j;
        }
        int i = (int) j2;
        bVar.a(eVar.a.a, 0, 4, false);
        eVar.f1087b = 4;
        for (long jM = eVar.a.m(); jM != 440786851; jM = ((jM << 8) & (-256)) | ((long) (eVar.a.a[0] & 255))) {
            int i2 = eVar.f1087b + 1;
            eVar.f1087b = i2;
            if (i2 == i) {
                return false;
            }
            bVar.a(eVar.a.a, 0, 1, false);
        }
        long jA = eVar.a(gVar);
        long j3 = eVar.f1087b;
        if (jA == Long.MIN_VALUE) {
            return false;
        }
        if (j != -1 && j3 + jA >= j) {
            return false;
        }
        while (true) {
            long j4 = eVar.f1087b;
            long j5 = j3 + jA;
            if (j4 >= j5) {
                return j4 == j5;
            }
            if (eVar.a(gVar) == Long.MIN_VALUE) {
                return false;
            }
            long jA2 = eVar.a(gVar);
            if (jA2 < 0 || jA2 > 2147483647L) {
                return false;
            }
            if (jA2 != 0) {
                bVar.a((int) jA2, false);
                eVar.f1087b = (int) (((long) eVar.f1087b) + jA2);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void a(h hVar) {
        this.Y = hVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void a(long j, long j2) {
        this.A = -9223372036854775807L;
        this.E = 0;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.a aVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.a) this.a;
        aVar.e = 0;
        aVar.f1083b.clear();
        f fVar = aVar.c;
        fVar.f1088b = 0;
        fVar.c = 0;
        f fVar2 = this.f1085b;
        fVar2.f1088b = 0;
        fVar2.c = 0;
        a();
    }

    /* JADX WARN: Code duplicated, block: B:27:0x003c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0005 A[SYNTHETIC] */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public int a(g gVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l lVar) throws InterruptedException, IOException {
        boolean z;
        this.W = false;
        boolean zA = true;
        while (zA && !this.W) {
            zA = ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.a) this.a).a(gVar);
            if (zA) {
                long j = ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).c;
                if (this.x) {
                    this.z = j;
                    lVar.a = this.y;
                    this.x = false;
                } else {
                    if (this.u) {
                        long j2 = this.z;
                        if (j2 != -1) {
                            lVar.a = j2;
                            this.z = -1L;
                        }
                        if (z) {
                            return 1;
                        }
                    }
                    z = false;
                    if (z) {
                        return 1;
                    }
                }
                z = true;
                if (z) {
                    return 1;
                }
            }
        }
        return zA ? 0 : -1;
    }

    public final void a(c cVar, long j) {
        byte[] bytes;
        if ("S_TEXT/UTF8".equals(cVar.a)) {
            byte[] bArr = this.k.a;
            long j2 = this.G;
            if (j2 == -9223372036854775807L) {
                bytes = a0;
            } else {
                int i = (int) (j2 / 3600000000L);
                long j3 = j2 - (((long) i) * 3600000000L);
                int i2 = (int) (j3 / 60000000);
                long j4 = j3 - ((long) (60000000 * i2));
                int i3 = (int) (j4 / 1000000);
                String str = String.format(Locale.US, "%02d:%02d:%02d,%03d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - ((long) (DurationKt.NANOS_IN_MILLIS * i3))) / 1000)));
                int i4 = u.a;
                bytes = str.getBytes(Charset.defaultCharset());
            }
            System.arraycopy(bytes, 0, bArr, 19, 12);
            n nVar = cVar.O;
            k kVar = this.k;
            nVar.a(kVar, kVar.c);
            this.V += this.k.c;
        }
        cVar.O.a(j, this.M, this.V, 0, cVar.g);
        this.W = true;
        a();
    }

    public final void a() {
        this.N = 0;
        this.V = 0;
        this.U = 0;
        this.O = false;
        this.P = false;
        this.R = false;
        this.T = 0;
        this.S = (byte) 0;
        this.Q = false;
        this.j.r();
    }

    public final void a(g gVar, int i) throws InterruptedException, IOException {
        k kVar = this.g;
        if (kVar.c >= i) {
            return;
        }
        if (kVar.b() < i) {
            k kVar2 = this.g;
            byte[] bArr = kVar2.a;
            kVar2.a(Arrays.copyOf(bArr, Math.max(bArr.length * 2, i)), this.g.c);
        }
        k kVar3 = this.g;
        byte[] bArr2 = kVar3.a;
        int i2 = kVar3.c;
        ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(bArr2, i2, i - i2, false);
        this.g.d(i);
    }

    public final void a(g gVar, c cVar, int i) throws InterruptedException, IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(cVar.a)) {
            byte[] bArr = Z;
            int length = bArr.length + i;
            if (this.k.b() < length) {
                this.k.a = Arrays.copyOf(bArr, length + i);
            }
            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.k.a, bArr.length, i, false);
            this.k.e(0);
            this.k.d(length);
            return;
        }
        n nVar = cVar.O;
        if (!this.O) {
            if (cVar.e) {
                this.M &= -1073741825;
                if (!this.P) {
                    ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.g.a, 0, 1, false);
                    this.N++;
                    byte[] bArr2 = this.g.a;
                    if ((bArr2[0] & 128) != 128) {
                        this.S = bArr2[0];
                        this.P = true;
                    } else {
                        throw new l("Extension bit is set in signal byte");
                    }
                }
                byte b2 = this.S;
                if ((b2 & 1) == 1) {
                    boolean z = (b2 & 2) == 2;
                    this.M |= 1073741824;
                    if (!this.Q) {
                        ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.l.a, 0, 8, false);
                        this.N += 8;
                        this.Q = true;
                        k kVar = this.g;
                        kVar.a[0] = (byte) ((z ? 128 : 0) | 8);
                        kVar.e(0);
                        nVar.a(this.g, 1);
                        this.V++;
                        this.l.e(0);
                        nVar.a(this.l, 8);
                        this.V += 8;
                    }
                    if (z) {
                        if (!this.R) {
                            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.g.a, 0, 1, false);
                            this.N++;
                            this.g.e(0);
                            this.T = this.g.l();
                            this.R = true;
                        }
                        int i3 = this.T * 4;
                        this.g.c(i3);
                        ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.g.a, 0, i3, false);
                        this.N += i3;
                        short s = (short) ((this.T / 2) + 1);
                        int i4 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.n;
                        if (byteBuffer == null || byteBuffer.capacity() < i4) {
                            this.n = ByteBuffer.allocate(i4);
                        }
                        this.n.position(0);
                        this.n.putShort(s);
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            i2 = this.T;
                            if (i5 >= i2) {
                                break;
                            }
                            int iO = this.g.o();
                            if (i5 % 2 == 0) {
                                this.n.putShort((short) (iO - i6));
                            } else {
                                this.n.putInt(iO - i6);
                            }
                            i5++;
                            i6 = iO;
                        }
                        int i7 = (i - this.N) - i6;
                        if (i2 % 2 == 1) {
                            this.n.putInt(i7);
                        } else {
                            this.n.putShort((short) i7);
                            this.n.putInt(0);
                        }
                        this.m.a(this.n.array(), i4);
                        nVar.a(this.m, i4);
                        this.V += i4;
                    }
                }
            } else {
                byte[] bArr3 = cVar.f;
                if (bArr3 != null) {
                    k kVar2 = this.j;
                    int length2 = bArr3.length;
                    kVar2.a = bArr3;
                    kVar2.c = length2;
                    kVar2.f1236b = 0;
                }
            }
            this.O = true;
        }
        int i8 = i + this.j.c;
        if (!"V_MPEG4/ISO/AVC".equals(cVar.a) && !"V_MPEGH/ISO/HEVC".equals(cVar.a)) {
            while (true) {
                int i9 = this.N;
                if (i9 >= i8) {
                    break;
                } else {
                    a(gVar, nVar, i8 - i9);
                }
            }
        } else {
            byte[] bArr4 = this.f.a;
            bArr4[0] = 0;
            bArr4[1] = 0;
            bArr4[2] = 0;
            int i10 = cVar.P;
            int i11 = 4 - i10;
            while (this.N < i8) {
                int i12 = this.U;
                if (i12 == 0) {
                    int iMin = Math.min(i10, this.j.a());
                    ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(bArr4, i11 + iMin, i10 - iMin, false);
                    if (iMin > 0) {
                        k kVar3 = this.j;
                        System.arraycopy(kVar3.a, kVar3.f1236b, bArr4, i11, iMin);
                        kVar3.f1236b += iMin;
                    }
                    this.N += i10;
                    this.f.e(0);
                    this.U = this.f.o();
                    this.e.e(0);
                    nVar.a(this.e, 4);
                    this.V += 4;
                } else {
                    this.U = i12 - a(gVar, nVar, i12);
                }
            }
        }
        if ("A_VORBIS".equals(cVar.a)) {
            this.h.e(0);
            nVar.a(this.h, 4);
            this.V += 4;
        }
    }

    public final int a(g gVar, n nVar, int i) throws InterruptedException, IOException {
        int iA;
        int iA2 = this.j.a();
        if (iA2 > 0) {
            iA = Math.min(i, iA2);
            nVar.a(this.j, iA);
        } else {
            iA = nVar.a(gVar, i, false);
        }
        this.N += iA;
        this.V += iA;
        return iA;
    }

    public final long a(long j) throws l {
        long j2 = this.q;
        if (j2 != -9223372036854775807L) {
            return u.a(j, j2, 1000L);
        }
        throw new l("Can't scale timecode prior to timecodeScale being set.");
    }

    public static int[] a(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return iArr.length >= i ? iArr : new int[Math.max(iArr.length * 2, i)];
    }
}
