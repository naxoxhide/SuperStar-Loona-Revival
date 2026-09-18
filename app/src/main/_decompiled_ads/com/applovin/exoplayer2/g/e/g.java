package com.applovin.exoplayer2.g.e;

import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.x;
import com.applovin.exoplayer2.l.y;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class g extends com.applovin.exoplayer2.g.g {
    public static final a JP = new a() { // from class: com.applovin.exoplayer2.g.e.-$$Lambda$g$DhFidmymxhutekX0I6owiN1b8_I
        @Override // com.applovin.exoplayer2.g.e.g.a
        public final boolean evaluate(int i, int i2, int i3, int i4, int i5) {
            return g.c(i, i2, i3, i4, i5);
        }
    };
    private final a JQ;

    public interface a {
        boolean evaluate(int i, int i2, int i3, int i4, int i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean c(int i, int i2, int i3, int i4, int i5) {
        return false;
    }

    private static String ds(int i) {
        if (i == 1) {
            return "UTF-16";
        }
        if (i != 2) {
            return i != 3 ? "ISO-8859-1" : "UTF-8";
        }
        return "UTF-16BE";
    }

    private static int dt(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    public g() {
        this(null);
    }

    public g(a aVar) {
        this.JQ = aVar;
    }

    @Override // com.applovin.exoplayer2.g.g
    protected com.applovin.exoplayer2.g.a a(com.applovin.exoplayer2.g.d dVar, ByteBuffer byteBuffer) {
        return f(byteBuffer.array(), byteBuffer.limit());
    }

    public com.applovin.exoplayer2.g.a f(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        y yVar = new y(bArr, i);
        b bVarX = X(yVar);
        if (bVarX == null) {
            return null;
        }
        int iIl = yVar.il();
        int i2 = bVarX.JR == 2 ? 6 : 10;
        int iZ = bVarX.JT;
        if (bVarX.JS) {
            iZ = z(yVar, bVarX.JT);
        }
        yVar.fA(iIl + iZ);
        boolean z = false;
        if (!a(yVar, bVarX.JR, i2, false)) {
            if (bVarX.JR != 4 || !a(yVar, 4, i2, true)) {
                q.h("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + bVarX.JR);
                return null;
            }
            z = true;
        }
        while (yVar.pj() >= i2) {
            h hVarA = a(bVarX.JR, yVar, z, i2, this.JQ);
            if (hVarA != null) {
                arrayList.add(hVarA);
            }
        }
        return new com.applovin.exoplayer2.g.a(arrayList);
    }

    private static b X(y yVar) {
        if (yVar.pj() < 10) {
            q.h("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int iPt = yVar.pt();
        boolean z = false;
        if (iPt != 4801587) {
            q.h("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x" + String.format("%06X", Integer.valueOf(iPt)));
            return null;
        }
        int iPo = yVar.po();
        yVar.fz(1);
        int iPo2 = yVar.po();
        int iPC = yVar.pC();
        if (iPo == 2) {
            if ((iPo2 & 64) != 0) {
                q.h("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (iPo == 3) {
            if ((iPo2 & 64) != 0) {
                int iPx = yVar.px();
                yVar.fz(iPx);
                iPC -= iPx + 4;
            }
        } else {
            if (iPo != 4) {
                q.h("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + iPo);
                return null;
            }
            if ((iPo2 & 64) != 0) {
                int iPC2 = yVar.pC();
                yVar.fz(iPC2 - 4);
                iPC -= iPC2;
            }
            if ((iPo2 & 16) != 0) {
                iPC -= 10;
            }
        }
        if (iPo < 4 && (iPo2 & 128) != 0) {
            z = true;
        }
        return new b(iPo, z, iPC);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0079 A[PHI: r3
      0x0079: PHI (r3v16 int) = (r3v5 int), (r3v19 int) binds: [B:40:0x0086, B:31:0x0076] A[DONT_GENERATE, DONT_INLINE]] */
    private static boolean a(y yVar, int i, int i2, boolean z) {
        int iPt;
        long jPt;
        int iPp;
        int i3;
        int iIl = yVar.il();
        while (true) {
            try {
                boolean z2 = true;
                if (yVar.pj() < i2) {
                    yVar.fx(iIl);
                    return true;
                }
                if (i >= 3) {
                    iPt = yVar.px();
                    jPt = yVar.pv();
                    iPp = yVar.pp();
                } else {
                    iPt = yVar.pt();
                    jPt = yVar.pt();
                    iPp = 0;
                }
                if (iPt == 0 && jPt == 0 && iPp == 0) {
                    yVar.fx(iIl);
                    return true;
                }
                if (i == 4 && !z) {
                    if ((8421504 & jPt) != 0) {
                        yVar.fx(iIl);
                        return false;
                    }
                    jPt = (((jPt >> 24) & 255) << 21) | (jPt & 255) | (((jPt >> 8) & 255) << 7) | (((jPt >> 16) & 255) << 14);
                }
                if (i == 4) {
                    i3 = (iPp & 64) != 0 ? 1 : 0;
                    if ((iPp & 1) == 0) {
                        z2 = false;
                    }
                } else if (i == 3) {
                    i3 = (iPp & 32) != 0 ? 1 : 0;
                    if ((iPp & 128) == 0) {
                        z2 = false;
                    }
                } else {
                    i3 = 0;
                    z2 = false;
                }
                if (z2) {
                    i3 += 4;
                }
                if (jPt < i3) {
                    yVar.fx(iIl);
                    return false;
                }
                if (yVar.pj() >= jPt) {
                    yVar.fz((int) jPt);
                } else {
                    yVar.fx(iIl);
                    return false;
                }
            } catch (Throwable th) {
                yVar.fx(iIl);
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:133:0x0198  */
    /* JADX WARN: Code duplicated, block: B:140:0x01a9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:141:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:146:0x01c3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:147:0x01c5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:151:0x01db A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:152:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:157:0x01ea A[Catch: all -> 0x012e, UnsupportedEncodingException -> 0x021c, Merged into TryCatch #1 {all -> 0x012e, UnsupportedEncodingException -> 0x021c, blocks: (B:91:0x011c, B:159:0x01f4, B:162:0x021c, B:93:0x0124, B:102:0x013d, B:104:0x0145, B:112:0x015f, B:121:0x0177, B:132:0x0192, B:139:0x01a4, B:145:0x01b3, B:150:0x01cb, B:156:0x01e5, B:157:0x01ea), top: B:169:0x0112 }] */
    private static h a(int i, y yVar, boolean z, int i2, a aVar) {
        int iPt;
        int i3;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        h hVarD;
        int iPo = yVar.po();
        int iPo2 = yVar.po();
        int iPo3 = yVar.po();
        int iPo4 = i >= 3 ? yVar.po() : 0;
        if (i == 4) {
            iPt = yVar.pD();
            if (!z) {
                iPt = (((iPt >> 24) & 255) << 21) | (iPt & 255) | (((iPt >> 8) & 255) << 7) | (((iPt >> 16) & 255) << 14);
            }
        } else if (i == 3) {
            iPt = yVar.pD();
        } else {
            iPt = yVar.pt();
        }
        int iZ = iPt;
        int iPp = i >= 3 ? yVar.pp() : 0;
        if (iPo == 0 && iPo2 == 0 && iPo3 == 0 && iPo4 == 0 && iZ == 0 && iPp == 0) {
            yVar.fx(yVar.pk());
            return null;
        }
        int iIl = yVar.il() + iZ;
        if (iIl > yVar.pk()) {
            q.h("Id3Decoder", "Frame size exceeds remaining tag data");
            yVar.fx(yVar.pk());
            return null;
        }
        if (aVar != null) {
            i3 = iIl;
            if (!aVar.evaluate(i, iPo, iPo2, iPo3, iPo4)) {
                yVar.fx(i3);
                return null;
            }
        } else {
            i3 = iIl;
        }
        if (i == 3) {
            int i4 = iPp;
            z3 = (i4 & 128) != 0;
            z4 = (i4 & 64) != 0;
            z2 = (i4 & 32) != 0;
            z6 = z3;
            z5 = false;
        } else {
            int i5 = iPp;
            if (i == 4) {
                boolean z7 = (i5 & 64) != 0;
                boolean z8 = (i5 & 8) != 0;
                boolean z9 = (i5 & 4) != 0;
                z5 = (i5 & 2) != 0;
                boolean z10 = (i5 & 1) != 0;
                z2 = z7;
                z3 = z10;
                z6 = z8;
                z4 = z9;
            } else {
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
                z6 = false;
            }
        }
        if (z6 || z4) {
            q.h(r4, "Skipping unsupported compressed or encrypted frame");
            yVar.fx(i3);
            return null;
        }
        if (z2) {
            iZ--;
            yVar.fz(1);
        }
        if (z3) {
            iZ -= 4;
            yVar.fz(4);
        }
        if (z5) {
            iZ = z(yVar, iZ);
        }
        try {
            if (iPo == 84 && iPo2 == 88 && iPo3 == 88 && (i == 2 || iPo4 == 88)) {
                hVarD = t(yVar, iZ);
            } else if (iPo == 84) {
                hVarD = b(yVar, iZ, b(i, iPo, iPo2, iPo3, iPo4));
            } else if (iPo == 87 && iPo2 == 88 && iPo3 == 88 && (i == 2 || iPo4 == 88)) {
                hVarD = u(yVar, iZ);
            } else if (iPo == 87) {
                hVarD = c(yVar, iZ, b(i, iPo, iPo2, iPo3, iPo4));
            } else if (iPo == 80 && iPo2 == 82 && iPo3 == 73 && iPo4 == 86) {
                hVarD = v(yVar, iZ);
            } else if (iPo == 71 && iPo2 == 69 && iPo3 == 79 && (iPo4 == 66 || i == 2)) {
                hVarD = w(yVar, iZ);
            } else if (i == 2) {
                if (iPo == 80 && iPo2 == 73 && iPo3 == 67) {
                    hVarD = g(yVar, iZ, i);
                } else if (iPo != 67 && iPo2 == 79 && iPo3 == 77 && (iPo4 == 77 || i == 2)) {
                    hVarD = x(yVar, iZ);
                } else if (iPo != 67 && iPo2 == 72 && iPo3 == 65 && iPo4 == 80) {
                    hVarD = a(yVar, iZ, i, z, i2, aVar);
                } else if (iPo != 67 && iPo2 == 84 && iPo3 == 79 && iPo4 == 67) {
                    hVarD = b(yVar, iZ, i, z, i2, aVar);
                } else if (iPo != 77 && iPo2 == 76 && iPo3 == 76 && iPo4 == 84) {
                    hVarD = y(yVar, iZ);
                } else {
                    hVarD = d(yVar, iZ, b(i, iPo, iPo2, iPo3, iPo4));
                }
            } else if (iPo == 65 && iPo2 == 80 && iPo3 == 73 && iPo4 == 67) {
                hVarD = g(yVar, iZ, i);
            } else if (iPo != 67) {
                if (iPo != 67) {
                    if (iPo != 67) {
                        if (iPo != 77) {
                            hVarD = d(yVar, iZ, b(i, iPo, iPo2, iPo3, iPo4));
                        } else {
                            hVarD = d(yVar, iZ, b(i, iPo, iPo2, iPo3, iPo4));
                        }
                    } else if (iPo != 77) {
                        hVarD = d(yVar, iZ, b(i, iPo, iPo2, iPo3, iPo4));
                    } else {
                        hVarD = d(yVar, iZ, b(i, iPo, iPo2, iPo3, iPo4));
                    }
                } else if (iPo != 67) {
                    if (iPo != 77) {
                        hVarD = d(yVar, iZ, b(i, iPo, iPo2, iPo3, iPo4));
                    } else {
                        hVarD = d(yVar, iZ, b(i, iPo, iPo2, iPo3, iPo4));
                    }
                } else if (iPo != 77) {
                    hVarD = d(yVar, iZ, b(i, iPo, iPo2, iPo3, iPo4));
                } else {
                    hVarD = d(yVar, iZ, b(i, iPo, iPo2, iPo3, iPo4));
                }
            } else if (iPo != 67) {
                if (iPo != 67) {
                    if (iPo != 77) {
                        hVarD = d(yVar, iZ, b(i, iPo, iPo2, iPo3, iPo4));
                    } else {
                        hVarD = d(yVar, iZ, b(i, iPo, iPo2, iPo3, iPo4));
                    }
                } else if (iPo != 77) {
                    hVarD = d(yVar, iZ, b(i, iPo, iPo2, iPo3, iPo4));
                } else {
                    hVarD = d(yVar, iZ, b(i, iPo, iPo2, iPo3, iPo4));
                }
            } else if (iPo != 67) {
                if (iPo != 77) {
                    hVarD = d(yVar, iZ, b(i, iPo, iPo2, iPo3, iPo4));
                } else {
                    hVarD = d(yVar, iZ, b(i, iPo, iPo2, iPo3, iPo4));
                }
            } else if (iPo != 77) {
                hVarD = d(yVar, iZ, b(i, iPo, iPo2, iPo3, iPo4));
            } else {
                hVarD = d(yVar, iZ, b(i, iPo, iPo2, iPo3, iPo4));
            }
            if (hVarD == null) {
                q.h("Id3Decoder", "Failed to decode frame: id=" + b(i, iPo, iPo2, iPo3, iPo4) + ", frameSize=" + iZ);
            }
            yVar.fx(i3);
            return hVarD;
        } catch (UnsupportedEncodingException unused) {
            q.h(r4, "Unsupported character encoding");
            return null;
        } finally {
            yVar.fx(i3);
        }
    }

    private static l t(y yVar, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int iPo = yVar.po();
        String strDs = ds(iPo);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        yVar.r(bArr, 0, i2);
        int iJ = j(bArr, 0, iPo);
        String str = new String(bArr, 0, iJ, strDs);
        int iDt = iJ + dt(iPo);
        return new l("TXXX", str, a(bArr, iDt, j(bArr, iDt, iPo), strDs));
    }

    private static l b(y yVar, int i, String str) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int iPo = yVar.po();
        String strDs = ds(iPo);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        yVar.r(bArr, 0, i2);
        return new l(str, null, new String(bArr, 0, j(bArr, 0, iPo), strDs));
    }

    private static m u(y yVar, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int iPo = yVar.po();
        String strDs = ds(iPo);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        yVar.r(bArr, 0, i2);
        int iJ = j(bArr, 0, iPo);
        String str = new String(bArr, 0, iJ, strDs);
        int iDt = iJ + dt(iPo);
        return new m("WXXX", str, a(bArr, iDt, g(bArr, iDt), "ISO-8859-1"));
    }

    private static m c(y yVar, int i, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        yVar.r(bArr, 0, i);
        return new m(str, null, new String(bArr, 0, g(bArr, 0), "ISO-8859-1"));
    }

    private static k v(y yVar, int i) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        yVar.r(bArr, 0, i);
        int iG = g(bArr, 0);
        return new k(new String(bArr, 0, iG, "ISO-8859-1"), k(bArr, iG + 1, i));
    }

    private static f w(y yVar, int i) throws UnsupportedEncodingException {
        int iPo = yVar.po();
        String strDs = ds(iPo);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        yVar.r(bArr, 0, i2);
        int iG = g(bArr, 0);
        String str = new String(bArr, 0, iG, "ISO-8859-1");
        int i3 = iG + 1;
        int iJ = j(bArr, i3, iPo);
        String strA = a(bArr, i3, iJ, strDs);
        int iDt = iJ + dt(iPo);
        int iJ2 = j(bArr, iDt, iPo);
        return new f(str, strA, a(bArr, iDt, iJ2, strDs), k(bArr, iJ2 + dt(iPo), i2));
    }

    private static com.applovin.exoplayer2.g.e.a g(y yVar, int i, int i2) throws UnsupportedEncodingException {
        int iG;
        String str;
        int iPo = yVar.po();
        String strDs = ds(iPo);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        yVar.r(bArr, 0, i3);
        if (i2 == 2) {
            str = "image/" + Ascii.toLowerCase(new String(bArr, 0, 3, "ISO-8859-1"));
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            iG = 2;
        } else {
            iG = g(bArr, 0);
            String lowerCase = Ascii.toLowerCase(new String(bArr, 0, iG, "ISO-8859-1"));
            str = lowerCase.indexOf(47) == -1 ? "image/" + lowerCase : lowerCase;
        }
        int i4 = bArr[iG + 1] & 255;
        int i5 = iG + 2;
        int iJ = j(bArr, i5, iPo);
        return new com.applovin.exoplayer2.g.e.a(str, new String(bArr, i5, iJ - i5, strDs), i4, k(bArr, iJ + dt(iPo), i3));
    }

    private static e x(y yVar, int i) throws UnsupportedEncodingException {
        if (i < 4) {
            return null;
        }
        int iPo = yVar.po();
        String strDs = ds(iPo);
        byte[] bArr = new byte[3];
        yVar.r(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        yVar.r(bArr2, 0, i2);
        int iJ = j(bArr2, 0, iPo);
        String str2 = new String(bArr2, 0, iJ, strDs);
        int iDt = iJ + dt(iPo);
        return new e(str, str2, a(bArr2, iDt, j(bArr2, iDt, iPo), strDs));
    }

    private static c a(y yVar, int i, int i2, boolean z, int i3, a aVar) throws UnsupportedEncodingException {
        int iIl = yVar.il();
        int iG = g(yVar.hO(), iIl);
        String str = new String(yVar.hO(), iIl, iG - iIl, "ISO-8859-1");
        yVar.fx(iG + 1);
        int iPx = yVar.px();
        int iPx2 = yVar.px();
        long jPv = yVar.pv();
        long j = jPv == 4294967295L ? -1L : jPv;
        long jPv2 = yVar.pv();
        long j2 = jPv2 == 4294967295L ? -1L : jPv2;
        ArrayList arrayList = new ArrayList();
        int i4 = iIl + i;
        while (yVar.il() < i4) {
            h hVarA = a(i2, yVar, z, i3, aVar);
            if (hVarA != null) {
                arrayList.add(hVarA);
            }
        }
        return new c(str, iPx, iPx2, j, j2, (h[]) arrayList.toArray(new h[0]));
    }

    private static d b(y yVar, int i, int i2, boolean z, int i3, a aVar) throws UnsupportedEncodingException {
        int iIl = yVar.il();
        int iG = g(yVar.hO(), iIl);
        String str = new String(yVar.hO(), iIl, iG - iIl, "ISO-8859-1");
        yVar.fx(iG + 1);
        int iPo = yVar.po();
        boolean z2 = (iPo & 2) != 0;
        boolean z3 = (iPo & 1) != 0;
        int iPo2 = yVar.po();
        String[] strArr = new String[iPo2];
        for (int i4 = 0; i4 < iPo2; i4++) {
            int iIl2 = yVar.il();
            int iG2 = g(yVar.hO(), iIl2);
            strArr[i4] = new String(yVar.hO(), iIl2, iG2 - iIl2, "ISO-8859-1");
            yVar.fx(iG2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i5 = iIl + i;
        while (yVar.il() < i5) {
            h hVarA = a(i2, yVar, z, i3, aVar);
            if (hVarA != null) {
                arrayList.add(hVarA);
            }
        }
        return new d(str, z2, z3, strArr, (h[]) arrayList.toArray(new h[0]));
    }

    private static j y(y yVar, int i) {
        int iPp = yVar.pp();
        int iPt = yVar.pt();
        int iPt2 = yVar.pt();
        int iPo = yVar.po();
        int iPo2 = yVar.po();
        x xVar = new x();
        xVar.ar(yVar);
        int i2 = ((i - 10) * 8) / (iPo + iPo2);
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int iBQ = xVar.bQ(iPo);
            int iBQ2 = xVar.bQ(iPo2);
            iArr[i3] = iBQ;
            iArr2[i3] = iBQ2;
        }
        return new j(iPp, iPt, iPt2, iArr, iArr2);
    }

    private static com.applovin.exoplayer2.g.e.b d(y yVar, int i, String str) {
        byte[] bArr = new byte[i];
        yVar.r(bArr, 0, i);
        return new com.applovin.exoplayer2.g.e.b(str, bArr);
    }

    private static int z(y yVar, int i) {
        byte[] bArrHO = yVar.hO();
        int iIl = yVar.il();
        int i2 = iIl;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= iIl + i) {
                return i;
            }
            if ((bArrHO[i2] & 255) == 255 && bArrHO[i3] == 0) {
                System.arraycopy(bArrHO, i2 + 2, bArrHO, i3, (i - (i2 - iIl)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    private static String b(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private static int j(byte[] bArr, int i, int i2) {
        int iG = g(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return iG;
        }
        while (iG < bArr.length - 1) {
            if ((iG - i) % 2 == 0 && bArr[iG + 1] == 0) {
                return iG;
            }
            iG = g(bArr, iG + 1);
        }
        return bArr.length;
    }

    private static int g(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    private static byte[] k(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return ai.ada;
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }

    private static String a(byte[] bArr, int i, int i2, String str) throws UnsupportedEncodingException {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, str);
    }

    private static final class b {
        private final int JR;
        private final boolean JS;
        private final int JT;

        public b(int i, boolean z, int i2) {
            this.JR = i;
            this.JS = z;
            this.JT = i2;
        }
    }
}
