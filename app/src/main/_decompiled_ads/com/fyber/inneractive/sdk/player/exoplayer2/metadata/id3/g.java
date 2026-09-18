package com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3;

import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f1168b = u.a("ID3");
    public final a a;

    public interface a {
    }

    public static final class b {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f1169b;
        public final int c;

        public b(int i, boolean z, int i2) {
            this.a = i;
            this.f1169b = z;
            this.c = i2;
        }
    }

    public g() {
        this(null);
    }

    public static int a(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    public static d b(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, int i, int i2, boolean z, int i3, a aVar) throws UnsupportedEncodingException {
        int i4 = kVar.f1236b;
        int iB = b(kVar.a, i4);
        String str = new String(kVar.a, i4, iB - i4, "ISO-8859-1");
        kVar.e(iB + 1);
        int iL = kVar.l();
        boolean z2 = (iL & 2) != 0;
        boolean z3 = (iL & 1) != 0;
        int iL2 = kVar.l();
        String[] strArr = new String[iL2];
        for (int i5 = 0; i5 < iL2; i5++) {
            int i6 = kVar.f1236b;
            int iB2 = b(kVar.a, i6);
            strArr[i5] = new String(kVar.a, i6, iB2 - i6, "ISO-8859-1");
            kVar.e(iB2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i7 = i4 + i;
        while (kVar.f1236b < i7) {
            h hVarA = a(i2, kVar, z, i3, aVar);
            if (hVarA != null) {
                arrayList.add(hVarA);
            }
        }
        h[] hVarArr = new h[arrayList.size()];
        arrayList.toArray(hVarArr);
        return new d(str, z2, z3, strArr, hVarArr);
    }

    public static String b(int i) {
        if (i == 1) {
            return "UTF-16";
        }
        if (i != 2) {
            return i != 3 ? "ISO-8859-1" : "UTF-8";
        }
        return "UTF-16BE";
    }

    public static k c(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, int i, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        System.arraycopy(kVar.a, kVar.f1236b, bArr, 0, i);
        kVar.f1236b += i;
        return new k(str, null, new String(bArr, 0, b(bArr, 0), "ISO-8859-1"));
    }

    public static j d(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int iL = kVar.l();
        String strB = b(iL);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(kVar.a, kVar.f1236b, bArr, 0, i2);
        kVar.f1236b += i2;
        int iA = a(bArr, 0, iL);
        String str = new String(bArr, 0, iA, strB);
        int iA2 = iA + a(iL);
        return new j("TXXX", str, iA2 < i2 ? new String(bArr, iA2, a(bArr, iA2, iL) - iA2, strB) : "");
    }

    public static k e(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int iL = kVar.l();
        String strB = b(iL);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(kVar.a, kVar.f1236b, bArr, 0, i2);
        kVar.f1236b += i2;
        int iA = a(bArr, 0, iL);
        String str = new String(bArr, 0, iA, strB);
        int iA2 = iA + a(iL);
        return new k("WXXX", str, iA2 < i2 ? new String(bArr, iA2, b(bArr, iA2) - iA2, "ISO-8859-1") : "");
    }

    public static int f(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, int i) {
        byte[] bArr = kVar.a;
        int i2 = kVar.f1236b;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= i) {
                return i;
            }
            if ((bArr[i2] & 255) == 255 && bArr[i3] == 0) {
                System.arraycopy(bArr, i2 + 2, bArr, i3, (i - i2) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009e  */
    /* JADX WARN: Code duplicated, block: B:46:0x00bf A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:52:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:55:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:64:0x0108  */
    /* JADX WARN: Code duplicated, block: B:69:0x0112 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x0102 A[SYNTHETIC] */
    public com.fyber.inneractive.sdk.player.exoplayer2.metadata.a a(byte[] bArr, int i) {
        boolean z;
        b bVar;
        int i2;
        int iF;
        h hVarA;
        ArrayList arrayList = new ArrayList();
        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(bArr, i);
        boolean z2 = false;
        if (kVar.a() < 10) {
            Log.w("Id3Decoder", "Data too short to be an ID3 tag");
        } else {
            int iN = kVar.n();
            if (iN == f1168b) {
                int iL = kVar.l();
                kVar.f(1);
                int iL2 = kVar.l();
                int iK = kVar.k();
                if (iL == 2) {
                    if ((iL2 & 64) != 0) {
                        Log.w("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                    } else {
                        if (iL < 4 || (iL2 & 128) == 0) {
                            z = false;
                        } else {
                            z = true;
                        }
                        bVar = new b(iL, z, iK);
                    }
                } else {
                    if (iL == 3) {
                        if ((iL2 & 64) != 0) {
                            int iC = kVar.c();
                            kVar.f(iC);
                            iK -= iC + 4;
                        }
                    } else if (iL == 4) {
                        if ((iL2 & 64) != 0) {
                            int iK2 = kVar.k();
                            kVar.f(iK2 - 4);
                            iK -= iK2;
                        }
                        if ((iL2 & 16) != 0) {
                            iK -= 10;
                        }
                    } else {
                        Log.w("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + iL);
                    }
                    if (iL < 4) {
                        z = false;
                    } else {
                        z = false;
                    }
                    bVar = new b(iL, z, iK);
                }
                if (bVar == null) {
                    return null;
                }
                int i3 = kVar.f1236b;
                i2 = bVar.a == 2 ? 6 : 10;
                iF = bVar.c;
                if (bVar.f1169b) {
                    iF = f(kVar, iF);
                }
                kVar.d(i3 + iF);
                if (!a(kVar, bVar.a, i2, false)) {
                    if (bVar.a == 4 || !a(kVar, 4, i2, true)) {
                        Log.w("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + bVar.a);
                        return null;
                    }
                    z2 = true;
                }
                while (kVar.a() >= i2) {
                    hVarA = a(bVar.a, kVar, z2, i2, this.a);
                    if (hVarA != null) {
                        arrayList.add(hVarA);
                    }
                }
                return new com.fyber.inneractive.sdk.player.exoplayer2.metadata.a(arrayList);
            }
            Log.w("Id3Decoder", "Unexpected first three bytes of ID3 tag header: " + iN);
        }
        bVar = null;
        if (bVar == null) {
            return null;
        }
        int i4 = kVar.f1236b;
        if (bVar.a == 2) {
        }
        iF = bVar.c;
        if (bVar.f1169b) {
            iF = f(kVar, iF);
        }
        kVar.d(i4 + iF);
        if (!a(kVar, bVar.a, i2, false)) {
            if (bVar.a == 4) {
            }
            Log.w("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + bVar.a);
            return null;
        }
        while (kVar.a() >= i2) {
            hVarA = a(bVar.a, kVar, z2, i2, this.a);
            if (hVarA != null) {
                arrayList.add(hVarA);
            }
        }
        return new com.fyber.inneractive.sdk.player.exoplayer2.metadata.a(arrayList);
    }

    public g(a aVar) {
        this.a = aVar;
    }

    public static i c(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, int i) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        System.arraycopy(kVar.a, kVar.f1236b, bArr, 0, i);
        kVar.f1236b += i;
        int iB = b(bArr, 0);
        String str = new String(bArr, 0, iB, "ISO-8859-1");
        int i2 = iB + 1;
        return new i(str, i2 < i ? Arrays.copyOfRange(bArr, i2, i) : new byte[0]);
    }

    public static j b(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, int i, String str) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int iL = kVar.l();
        String strB = b(iL);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(kVar.a, kVar.f1236b, bArr, 0, i2);
        kVar.f1236b += i2;
        return new j(str, null, new String(bArr, 0, a(bArr, 0, iL), strB));
    }

    public static f b(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, int i) throws UnsupportedEncodingException {
        int iL = kVar.l();
        String strB = b(iL);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(kVar.a, kVar.f1236b, bArr, 0, i2);
        kVar.f1236b += i2;
        int iB = b(bArr, 0);
        String str = new String(bArr, 0, iB, "ISO-8859-1");
        int i3 = iB + 1;
        int iA = a(bArr, i3, iL);
        String str2 = new String(bArr, i3, iA - i3, strB);
        int iA2 = iA + a(iL);
        int iA3 = a(bArr, iA2, iL);
        return new f(str, str2, new String(bArr, iA2, iA3 - iA2, strB), Arrays.copyOfRange(bArr, iA3 + a(iL), i2));
    }

    public static int b(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    public static c a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, int i, int i2, boolean z, int i3, a aVar) throws UnsupportedEncodingException {
        int i4 = kVar.f1236b;
        int iB = b(kVar.a, i4);
        String str = new String(kVar.a, i4, iB - i4, "ISO-8859-1");
        kVar.e(iB + 1);
        int iC = kVar.c();
        int iC2 = kVar.c();
        long jM = kVar.m();
        long j = jM == 4294967295L ? -1L : jM;
        long jM2 = kVar.m();
        long j2 = jM2 == 4294967295L ? -1L : jM2;
        ArrayList arrayList = new ArrayList();
        int i5 = i4 + i;
        while (kVar.f1236b < i5) {
            h hVarA = a(i2, kVar, z, i3, aVar);
            if (hVarA != null) {
                arrayList.add(hVarA);
            }
        }
        h[] hVarArr = new h[arrayList.size()];
        arrayList.toArray(hVarArr);
        return new c(str, iC, iC2, j, j2, hVarArr);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0085 A[PHI: r3
      0x0085: PHI (r3v16 int) = (r3v5 int), (r3v19 int) binds: [B:39:0x0082, B:31:0x0074] A[DONT_GENERATE, DONT_INLINE]] */
    public static boolean a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, int i, int i2, boolean z) {
        int iN;
        long jN;
        int iQ;
        int i3;
        int i4 = kVar.f1236b;
        while (true) {
            try {
                boolean z2 = true;
                if (kVar.a() < i2) {
                    kVar.e(i4);
                    return true;
                }
                if (i >= 3) {
                    iN = kVar.c();
                    jN = kVar.m();
                    iQ = kVar.q();
                } else {
                    iN = kVar.n();
                    jN = kVar.n();
                    iQ = 0;
                }
                if (iN == 0 && jN == 0 && iQ == 0) {
                    kVar.e(i4);
                    return true;
                }
                if (i == 4 && !z) {
                    if ((8421504 & jN) != 0) {
                        kVar.e(i4);
                        return false;
                    }
                    jN = (((jN >> 24) & 255) << 21) | (jN & 255) | (((jN >> 8) & 255) << 7) | (((jN >> 16) & 255) << 14);
                }
                if (i == 4) {
                    i3 = (iQ & 64) != 0 ? 1 : 0;
                    if ((iQ & 1) == 0) {
                        z2 = false;
                    }
                } else if (i == 3) {
                    i3 = (iQ & 32) != 0 ? 1 : 0;
                    if ((iQ & 128) == 0) {
                        z2 = false;
                    }
                } else {
                    i3 = 0;
                    z2 = false;
                }
                if (z2) {
                    i3 += 4;
                }
                if (jN < i3) {
                    kVar.e(i4);
                    return false;
                }
                if (kVar.a() < jN) {
                    kVar.e(i4);
                    return false;
                }
                kVar.f((int) jN);
            } catch (Throwable th) {
                kVar.e(i4);
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:137:0x0191  */
    /* JADX WARN: Code duplicated, block: B:143:0x01a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:144:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:149:0x01ba A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:150:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:155:0x01d4 A[Catch: all -> 0x012c, UnsupportedEncodingException -> 0x0206, Merged into TryCatch #1 {all -> 0x012c, UnsupportedEncodingException -> 0x0206, blocks: (B:95:0x011a, B:157:0x01de, B:160:0x0206, B:97:0x0122, B:106:0x013b, B:108:0x0143, B:116:0x015d, B:125:0x0173, B:136:0x018c, B:142:0x019b, B:148:0x01aa, B:154:0x01c4, B:155:0x01d4), top: B:167:0x0110 }] */
    public static h a(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, boolean z, int i2, a aVar) {
        int iN;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        h hVarA;
        int iL = kVar.l();
        int iL2 = kVar.l();
        int iL3 = kVar.l();
        int iL4 = i >= 3 ? kVar.l() : 0;
        if (i == 4) {
            iN = kVar.o();
            if (!z) {
                iN = (((iN >> 24) & 255) << 21) | (iN & 255) | (((iN >> 8) & 255) << 7) | (((iN >> 16) & 255) << 14);
            }
        } else if (i == 3) {
            iN = kVar.o();
        } else {
            iN = kVar.n();
        }
        int iQ = i >= 3 ? kVar.q() : 0;
        if (iL == 0 && iL2 == 0 && iL3 == 0 && iL4 == 0 && iN == 0 && iQ == 0) {
            kVar.e(kVar.c);
            return null;
        }
        int i3 = kVar.f1236b + iN;
        if (i3 > kVar.c) {
            Log.w("Id3Decoder", "Frame size exceeds remaining tag data");
            kVar.e(kVar.c);
            return null;
        }
        if (aVar != null) {
            if (!(iL == 67 && iL2 == 79 && iL3 == 77 && (iL4 == 77 || i == 2))) {
                kVar.e(i3);
                return null;
            }
        }
        if (i == 3) {
            z3 = (iQ & 128) != 0;
            z5 = (iQ & 64) != 0;
            z6 = false;
            z2 = (iQ & 32) != 0;
            z4 = z3;
        } else if (i == 4) {
            z2 = (iQ & 64) != 0;
            z4 = (iQ & 8) != 0;
            z5 = (iQ & 4) != 0;
            z6 = (iQ & 2) != 0;
            z3 = (iQ & 1) != 0;
        } else {
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
        }
        if (!z4 && !z5) {
            if (z2) {
                iN--;
                kVar.f(1);
            }
            if (z3) {
                iN -= 4;
                kVar.f(4);
            }
            if (z6) {
                iN = f(kVar, iN);
            }
            int i4 = iN;
            try {
                if (iL == 84 && iL2 == 88 && iL3 == 88 && (i == 2 || iL4 == 88)) {
                    hVarA = d(kVar, i4);
                } else if (iL == 84) {
                    hVarA = b(kVar, i4, a(i, iL, iL2, iL3, iL4));
                } else if (iL == 87 && iL2 == 88 && iL3 == 88 && (i == 2 || iL4 == 88)) {
                    hVarA = e(kVar, i4);
                } else if (iL == 87) {
                    hVarA = c(kVar, i4, a(i, iL, iL2, iL3, iL4));
                } else if (iL == 80 && iL2 == 82 && iL3 == 73 && iL4 == 86) {
                    hVarA = c(kVar, i4);
                } else if (iL == 71 && iL2 == 69 && iL3 == 79 && (iL4 == 66 || i == 2)) {
                    hVarA = b(kVar, i4);
                } else if (i == 2) {
                    if (iL == 80 && iL2 == 73 && iL3 == 67) {
                        hVarA = a(kVar, i4, i);
                    } else if (iL != 67 && iL2 == 79 && iL3 == 77 && (iL4 == 77 || i == 2)) {
                        hVarA = a(kVar, i4);
                    } else if (iL != 67 && iL2 == 72 && iL3 == 65 && iL4 == 80) {
                        hVarA = a(kVar, i4, i, z, i2, aVar);
                    } else if (iL != 67 && iL2 == 84 && iL3 == 79 && iL4 == 67) {
                        hVarA = b(kVar, i4, i, z, i2, aVar);
                    } else {
                        hVarA = a(kVar, i4, a(i, iL, iL2, iL3, iL4));
                    }
                } else if (iL == 65 && iL2 == 80 && iL3 == 73 && iL4 == 67) {
                    hVarA = a(kVar, i4, i);
                } else if (iL != 67) {
                    if (iL != 67) {
                        if (iL != 67) {
                            hVarA = a(kVar, i4, a(i, iL, iL2, iL3, iL4));
                        } else {
                            hVarA = a(kVar, i4, a(i, iL, iL2, iL3, iL4));
                        }
                    } else if (iL != 67) {
                        hVarA = a(kVar, i4, a(i, iL, iL2, iL3, iL4));
                    } else {
                        hVarA = a(kVar, i4, a(i, iL, iL2, iL3, iL4));
                    }
                } else if (iL != 67) {
                    if (iL != 67) {
                        hVarA = a(kVar, i4, a(i, iL, iL2, iL3, iL4));
                    } else {
                        hVarA = a(kVar, i4, a(i, iL, iL2, iL3, iL4));
                    }
                } else if (iL != 67) {
                    hVarA = a(kVar, i4, a(i, iL, iL2, iL3, iL4));
                } else {
                    hVarA = a(kVar, i4, a(i, iL, iL2, iL3, iL4));
                }
                if (hVarA == null) {
                    Log.w("Id3Decoder", "Failed to decode frame: id=" + a(i, iL, iL2, iL3, iL4) + ", frameSize=" + i4);
                }
                kVar.e(i3);
                return hVarA;
            } catch (UnsupportedEncodingException unused) {
                Log.w("Id3Decoder", "Unsupported character encoding");
                return null;
            } finally {
                kVar.e(i3);
            }
        }
        Log.w("Id3Decoder", "Skipping unsupported compressed or encrypted frame");
        kVar.e(i3);
        return null;
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.a a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, int i, int i2) throws UnsupportedEncodingException {
        int iB;
        String str;
        int iL = kVar.l();
        String strB = b(iL);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        System.arraycopy(kVar.a, kVar.f1236b, bArr, 0, i3);
        kVar.f1236b += i3;
        if (i2 == 2) {
            str = "image/" + new String(bArr, 0, 3, "ISO-8859-1").toLowerCase(Locale.US);
            if (str.equals("image/jpg")) {
                str = "image/jpeg";
            }
            iB = 2;
        } else {
            iB = b(bArr, 0);
            String lowerCase = new String(bArr, 0, iB, "ISO-8859-1").toLowerCase(Locale.US);
            str = lowerCase.indexOf(47) == -1 ? "image/" + lowerCase : lowerCase;
        }
        int i4 = bArr[iB + 1] & 255;
        int i5 = iB + 2;
        int iA = a(bArr, i5, iL);
        return new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.a(str, new String(bArr, i5, iA - i5, strB), i4, Arrays.copyOfRange(bArr, iA + a(iL), i3));
    }

    public static e a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, int i) throws UnsupportedEncodingException {
        if (i < 4) {
            return null;
        }
        int iL = kVar.l();
        String strB = b(iL);
        byte[] bArr = new byte[3];
        System.arraycopy(kVar.a, kVar.f1236b, bArr, 0, 3);
        kVar.f1236b += 3;
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(kVar.a, kVar.f1236b, bArr2, 0, i2);
        kVar.f1236b += i2;
        int iA = a(bArr2, 0, iL);
        String str2 = new String(bArr2, 0, iA, strB);
        int iA2 = iA + a(iL);
        return new e(str, str2, iA2 < i2 ? new String(bArr2, iA2, a(bArr2, iA2, iL) - iA2, strB) : "");
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.b a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, int i, String str) {
        byte[] bArr = new byte[i];
        System.arraycopy(kVar.a, kVar.f1236b, bArr, 0, i);
        kVar.f1236b += i;
        return new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.b(str, bArr);
    }

    public static String a(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static int a(byte[] bArr, int i, int i2) {
        int iB = b(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return iB;
        }
        while (iB < bArr.length - 1) {
            if (iB % 2 == 0 && bArr[iB + 1] == 0) {
                return iB;
            }
            iB = b(bArr, iB + 1);
        }
        return bArr.length;
    }
}
