package com.facebook.ads.redexgen.X;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.ApicFrame;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.BinaryFrame;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.ChapterFrame;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.ChapterTocFrame;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.CommentFrame;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.GeobFrame;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.Id3Frame;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.PrivFrame;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.TextInformationFrame;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.UrlLinkFrame;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.common.primitives.SignedBytes;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1349Vu implements DE {
    public static byte[] A01;
    public static String[] A02 = {"mDpfQ0Mg1qMGU0sRUyB4w0yHI9AflFxL", "HrWFAZbBmLlJHBGWXoy88PVYdiXTIEfW", "ZQEIpFlmPj9dChjEJf3cuXBCToBvQGIn", "RQPpjxLwn1F2LqLyPS6YhTLdMSPVP9VK", "XPMzSAYF2Koz19PEH34p5", "swwfqTWHhic8XQtgs9vSQ", "6JbQXNgGm6Rlu9UTMBxnLLi5Rd7F6qFb", "jePmV9Iz"};
    public static final int A03;
    public static final DQ A04;
    public final DQ A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 20 out of bounds for length 20
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static ChapterFrame A06(C0980Hh c0980Hh, int i, int i2, boolean z, int i3, DQ dq) throws UnsupportedEncodingException {
        int iA06 = c0980Hh.A06();
        int iA02 = A02(c0980Hh.A00, iA06);
        String str = new String(c0980Hh.A00, iA06, iA02 - iA06, A0I(169, 10, 32));
        c0980Hh.A0Y(iA02 + 1);
        int iA08 = c0980Hh.A08();
        int iA09 = c0980Hh.A08();
        long jA0M = c0980Hh.A0M();
        if (jA0M == 4294967295L) {
            jA0M = -1;
        }
        long jA0M2 = c0980Hh.A0M();
        if (jA0M2 == 4294967295L) {
            jA0M2 = -1;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = iA06 + i;
        while (c0980Hh.A06() < i4) {
            Id3Frame id3FrameA0B = A0B(i2, c0980Hh, z, i3, dq);
            if (id3FrameA0B != null) {
                arrayList.add(id3FrameA0B);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, iA08, iA09, jA0M, jA0M2, id3FrameArr);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 11 out of bounds for length 11
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static GeobFrame A09(C0980Hh c0980Hh, int i) throws UnsupportedEncodingException {
        int iA0E = c0980Hh.A0E();
        String strA0H = A0H(iA0E);
        byte[] bArr = new byte[i - 1];
        c0980Hh.A0c(bArr, 0, i - 1);
        int iA02 = A02(bArr, 0);
        String str = new String(bArr, 0, iA02, A0I(169, 10, 32));
        int i2 = iA02 + 1;
        int iA03 = A03(bArr, i2, iA0E);
        String strA0K = A0K(bArr, i2, iA03, strA0H);
        int iA00 = A00(iA0E) + iA03;
        int iA04 = A03(bArr, iA00, iA0E);
        return new GeobFrame(str, strA0K, A0K(bArr, iA00, iA04, strA0H), A0N(bArr, A00(iA0E) + iA04, bArr.length));
    }

    public static String A0I(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 2);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0L() {
        A01 = new byte[]{78, 8, 78, 8, 78, 8, 44, 106, 44, 106, 44, 106, 44, 106, 89, 85, 19, 7, 20, 24, 16, 38, 28, 15, 16, 72, 91, 126, 107, 126, 63, 107, 112, 112, 63, 108, 119, 112, 109, 107, 63, 107, 112, 63, 125, 122, 63, 126, 113, 63, 86, 91, 44, 63, 107, 126, 120, 22, 49, 57, 60, 53, 52, 112, 36, 63, 112, 52, 53, 51, 63, 52, 53, 112, 54, 34, 49, Base64.padSymbol, 53, 106, 112, 57, 52, 109, 119, 80, 88, 93, 84, 85, 17, 69, 94, 17, 71, 80, 93, 88, 85, 80, 69, 84, 17, 120, 117, 2, 17, 69, 80, 86, 17, 70, 88, 69, 89, 17, 92, 80, 91, 94, 67, 103, 84, 67, 66, 88, 94, 95, 12, 4, 48, 35, 47, 39, 98, 49, 43, 56, 39, 98, 39, 58, 33, 39, 39, 38, 49, 98, 48, 39, 47, 35, 43, 44, 43, 44, 37, 98, 54, 35, 37, 98, 38, 35, 54, 35, 71, 74, Base64.padSymbol, 107, 113, 109, 15, 26, 26, 23, 27, 15, 19, 88, 117, 34, 85, 116, 114, 126, 117, 116, 99, 97, 89, 91, 66, 66, 87, 86, 18, 123, 118, 1, 18, 70, 83, 85, 18, 69, 91, 70, 90, 18, 95, 83, 88, 93, SignedBytes.MAX_POWER_OF_TWO, 100, 87, SignedBytes.MAX_POWER_OF_TWO, 65, 91, 93, 92, 15, 0, 18, 83, 92, 86, 18, 71, 92, 86, 87, 84, 91, 92, 87, 86, 18, 81, 93, 95, 66, SignedBytes.MAX_POWER_OF_TWO, 87, 65, 65, 91, 93, 92, 18, 65, 81, 90, 87, 95, 87, 116, 76, 78, 87, 87, 66, 67, 7, 110, 99, 20, 7, 83, 70, SignedBytes.MAX_POWER_OF_TWO, 7, 80, 78, 83, 79, 7, 82, 73, 84, 82, 87, 87, 72, 85, 83, 66, 67, 7, 74, 70, 77, 72, 85, 113, 66, 85, 84, 78, 72, 73, 26, 28, 36, 38, 63, 63, 38, 33, 40, 111, 58, 33, 60, 58, 63, 63, 32, Base64.padSymbol, 59, 42, 43, 111, 44, 32, 34, 63, Base64.padSymbol, 42, 60, 60, 42, 43, 111, 32, Base64.padSymbol, 111, 42, 33, 44, Base64.padSymbol, 54, 63, 59, 42, 43, 111, 41, Base64.padSymbol, 46, 34, 42, 62, 50, 50, 50, 31, 30, 12, 103, 123, 124, 62, 63, 45, 70, 90, 93, 41, 46, 54, 55, 37, 78, 91, 68, 127, 116, 105, 97, 116, 114, 101, 116, 117, 49, 119, 120, 99, 98, 101, 49, 101, 121, 99, 116, 116, 49, 115, 104, 101, 116, 98, 49, 126, 119, 49, 88, 85, 34, 49, 101, 112, 118, 49, 121, 116, 112, 117, 116, 99, 43, 49, 19, 40, 53, 51, 54, 54, 41, 52, 50, 35, 34, 102, 37, 46, 39, 52, 39, 37, 50, 35, 52, 102, 35, 40, 37, 41, 34, 47, 40, 33, 97, 110, 110, 110, 70, 66, 78, 72, 74, 0, 21, 17, 29, 27, 25, 83, 22, 12, 25, 27, 81, 85, 89, 95, 93, 23, 82, 72, 95};
    }

    static {
        A0L();
        A04 = new C1350Vv();
        A03 = C0996Hx.A08(A0I(166, 3, 12));
    }

    public C1349Vu() {
        this(null);
    }

    public C1349Vu(DQ dq) {
        this.A00 = dq;
    }

    public static int A00(int i) {
        if (i == 0 || i == 3) {
            return 1;
        }
        return 2;
    }

    public static int A01(C0980Hh c0980Hh, int i) {
        byte[] bArr = c0980Hh.A00;
        for (int iA06 = c0980Hh.A06(); iA06 + 1 < i; iA06++) {
            int i2 = bArr[iA06];
            if ((i2 & 255) == 255 && bArr[iA06 + 1] == 0) {
                int i3 = iA06 + 2;
                int i4 = iA06 + 1;
                int i5 = (i - iA06) - 2;
                String[] strArr = A02;
                String str = strArr[0];
                String str2 = strArr[6];
                int i6 = str.charAt(4);
                if (i6 == str2.charAt(4)) {
                    throw new RuntimeException();
                }
                A02[1] = "GmDFLtMXmPbGQOJzrAUGcq8JFdShu0kr";
                System.arraycopy(bArr, i3, bArr, i4, i5);
                i--;
            }
        }
        return i;
    }

    public static int A02(byte[] bArr, int i) {
        while (i < i) {
            int i2 = bArr[i];
            if (i2 == 0) {
                return i;
            }
            i++;
        }
        int i3 = bArr.length;
        return i3;
    }

    public static int A03(byte[] bArr, int i, int i2) {
        int iA02 = A02(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return iA02;
        }
        while (iA02 < terminationPos - 1) {
            int terminationPos = iA02 % 2;
            if (terminationPos == 0) {
                int terminationPos2 = iA02 + 1;
                if (bArr[terminationPos2] == 0) {
                    return iA02;
                }
            }
            int terminationPos3 = iA02 + 1;
            iA02 = A02(bArr, terminationPos3);
        }
        int terminationPos4 = bArr.length;
        return terminationPos4;
    }

    public static ApicFrame A04(C0980Hh c0980Hh, int i, int i2) throws UnsupportedEncodingException {
        int iA02;
        String strA0M;
        int descriptionStartIndex = c0980Hh.A0E();
        String strA0H = A0H(descriptionStartIndex);
        int encoding = i - 1;
        byte[] bArr = new byte[encoding];
        int encoding2 = i - 1;
        c0980Hh.A0c(bArr, 0, encoding2);
        String strA0I = A0I(FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, 6, 45);
        String strA0I2 = A0I(169, 10, 32);
        if (i2 == 2) {
            iA02 = 2;
            strA0M = strA0I + C0996Hx.A0M(new String(bArr, 0, 3, strA0I2));
            if (A0I(474, 9, 58).equals(strA0M)) {
                strA0M = A0I(464, 10, 126);
            }
        } else {
            iA02 = A02(bArr, 0);
            strA0M = C0996Hx.A0M(new String(bArr, 0, iA02, strA0I2));
            if (strA0M.indexOf(47) == -1) {
                strA0M = strA0I + strA0M;
            }
        }
        int encoding3 = iA02 + 1;
        int i3 = bArr[encoding3] & 255;
        int i4 = iA02 + 2;
        int mimeTypeEndIndex = A03(bArr, i4, descriptionStartIndex);
        int encoding4 = mimeTypeEndIndex - i4;
        String str = new String(bArr, i4, encoding4, strA0H);
        int iA00 = A00(descriptionStartIndex) + mimeTypeEndIndex;
        int encoding5 = bArr.length;
        return new ApicFrame(strA0M, str, i3, A0N(bArr, iA00, encoding5));
    }

    public static BinaryFrame A05(C0980Hh c0980Hh, int i, String str) {
        byte[] bArr = new byte[i];
        c0980Hh.A0c(bArr, 0, i);
        return new BinaryFrame(str, bArr);
    }

    public static ChapterTocFrame A07(C0980Hh c0980Hh, int i, int i2, boolean z, int framePosition, DQ dq) throws UnsupportedEncodingException {
        int iA06 = c0980Hh.A06();
        int iA02 = A02(c0980Hh.A00, iA06);
        String strA0I = A0I(169, 10, 32);
        String str = new String(c0980Hh.A00, iA06, iA02 - iA06, strA0I);
        c0980Hh.A0Y(iA02 + 1);
        int framePosition2 = c0980Hh.A0E();
        boolean z2 = (framePosition2 & 2) != 0;
        boolean z3 = (framePosition2 & 1) != 0;
        int iA0E = c0980Hh.A0E();
        String[] strArr = new String[iA0E];
        for (int i3 = 0; i3 < iA0E; i3++) {
            int startIndex = c0980Hh.A06();
            int i4 = A02(c0980Hh.A00, startIndex);
            int framePosition3 = i4 - startIndex;
            strArr[i3] = new String(c0980Hh.A00, startIndex, framePosition3, strA0I);
            c0980Hh.A0Y(i4 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i5 = iA06 + i;
        while (c0980Hh.A06() < i5) {
            String[] strArr2 = A02;
            String str2 = strArr2[4];
            String str3 = strArr2[5];
            int framePosition4 = str2.length();
            if (framePosition4 != str3.length()) {
                throw new RuntimeException();
            }
            String[] strArr3 = A02;
            strArr3[4] = "YQsr0udxa6AlS4ZOrNFlw";
            strArr3[5] = "dBU8ocTiI6WLc8wZTOIXb";
            Id3Frame id3FrameA0B = A0B(i2, c0980Hh, z, framePosition, dq);
            if (id3FrameA0B != null) {
                arrayList.add(id3FrameA0B);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
    }

    public static CommentFrame A08(C0980Hh c0980Hh, int i) throws UnsupportedEncodingException {
        if (i < 4) {
            return null;
        }
        int textStartIndex = c0980Hh.A0E();
        String strA0H = A0H(textStartIndex);
        byte[] bArr = new byte[3];
        c0980Hh.A0c(bArr, 0, 3);
        String description = new String(bArr, 0, 3);
        int encoding = i - 4;
        byte[] data = new byte[encoding];
        int encoding2 = i - 4;
        c0980Hh.A0c(data, 0, encoding2);
        int encoding3 = A03(data, 0, textStartIndex);
        String language = new String(data, 0, encoding3, strA0H);
        int iA00 = A00(textStartIndex) + encoding3;
        int encoding4 = A03(data, iA00, textStartIndex);
        String charset = A0K(data, iA00, encoding4, strA0H);
        return new CommentFrame(description, language, charset);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0093  */
    public static DR A0A(C0980Hh c0980Hh) {
        int iA04 = c0980Hh.A04();
        String strA0I = A0I(179, 10, 19);
        if (iA04 < 10) {
            Log.w(strA0I, A0I(26, 31, 29));
            return null;
        }
        int iA0G = c0980Hh.A0G();
        int id = A03;
        if (iA0G != id) {
            Log.w(strA0I, A0I(376, 48, 19) + iA0G);
            return null;
        }
        int iA0E = c0980Hh.A0E();
        boolean z = true;
        c0980Hh.A0Z(1);
        int framesSize = c0980Hh.A0E();
        int iA0D = c0980Hh.A0D();
        if (iA0E == 2) {
            int id2 = framesSize & 64;
            int id3 = id2 != 0 ? 1 : 0;
            if (id3 != 0) {
                Log.w(strA0I, A0I(189, 68, 48));
                return null;
            }
        } else if (iA0E == 3) {
            int id4 = framesSize & 64;
            int id5 = id4 != 0 ? 1 : 0;
            if (id5 != 0) {
                int id6 = c0980Hh.A08();
                c0980Hh.A0Z(id6);
                iA0D -= id6 + 4;
            }
        } else if (iA0E == 4) {
            int id7 = framesSize & 64;
            int id8 = id7 != 0 ? 1 : 0;
            if (id8 != 0) {
                int majorVersion = c0980Hh.A0D();
                int id9 = majorVersion - 4;
                c0980Hh.A0Z(id9);
                iA0D -= majorVersion;
            }
            int id10 = framesSize & 16;
            int id11 = id10 != 0 ? 1 : 0;
            if (id11 != 0) {
                iA0D -= 10;
            }
        } else {
            Log.w(strA0I, A0I(InputDeviceCompat.SOURCE_KEYBOARD, 46, 37) + iA0E);
            return null;
        }
        if (iA0E < 4) {
            int id12 = framesSize & 128;
            if (id12 == 0) {
                z = false;
            }
        } else {
            z = false;
        }
        return new DR(iA0E, z, iA0D);
    }

    /* JADX WARN: Code duplicated, block: B:119:0x01bc A[Catch: UnsupportedEncodingException -> 0x02c3, all -> 0x02d4, Merged into TryCatch #1 {all -> 0x02d4, UnsupportedEncodingException -> 0x02c3, blocks: (B:95:0x015a, B:166:0x0266, B:173:0x02c3, B:98:0x0164, B:105:0x017a, B:107:0x0182, B:119:0x01bc, B:128:0x01d4, B:142:0x0214, B:149:0x0225, B:157:0x0238, B:163:0x024f, B:164:0x025c), top: B:183:0x0150 }, TRY_ENTER] */
    /* JADX WARN: Code duplicated, block: B:120:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:122:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:129:0x01da  */
    /* JADX WARN: Code duplicated, block: B:131:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:133:0x0203 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:137:0x020a  */
    /* JADX WARN: Code duplicated, block: B:144:0x021b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:150:0x022a  */
    /* JADX WARN: Code duplicated, block: B:152:0x022e  */
    /* JADX WARN: Code duplicated, block: B:158:0x0245 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:159:0x0247  */
    /* JADX WARN: Code duplicated, block: B:164:0x025c A[Catch: UnsupportedEncodingException -> 0x02c3, all -> 0x02d4, Merged into TryCatch #1 {all -> 0x02d4, UnsupportedEncodingException -> 0x02c3, blocks: (B:95:0x015a, B:166:0x0266, B:173:0x02c3, B:98:0x0164, B:105:0x017a, B:107:0x0182, B:119:0x01bc, B:128:0x01d4, B:142:0x0214, B:149:0x0225, B:157:0x0238, B:163:0x024f, B:164:0x025c), top: B:183:0x0150 }] */
    public static Id3Frame A0B(int flags, C0980Hh c0980Hh, boolean z, int i, DQ dq) {
        int iA0E;
        int flags2;
        int frameSize;
        String str;
        int frameId3;
        Id3Frame id3FrameA05;
        int frameId1 = c0980Hh.A0E();
        int frameId0 = c0980Hh.A0E();
        int iA0E2 = c0980Hh.A0E();
        if (flags >= 3) {
            iA0E = c0980Hh.A0E();
        } else {
            iA0E = 0;
        }
        if (flags == 4) {
            int iA0H = c0980Hh.A0H();
            if (!z) {
                int frameSize2 = iA0H >> 8;
                int i2 = (iA0H & 255) | ((frameSize2 & 255) << 7);
                int frameSize3 = iA0H >> 16;
                int i3 = i2 | ((frameSize3 & 255) << 14);
                int frameSize4 = iA0H >> 24;
                flags2 = i3 | ((frameSize4 & 255) << 21);
            } else {
                flags2 = iA0H;
            }
        } else if (flags == 3) {
            flags2 = c0980Hh.A0H();
        } else {
            flags2 = c0980Hh.A0G();
        }
        if (flags >= 3) {
            frameSize = c0980Hh.A0I();
        } else {
            frameSize = 0;
        }
        if (frameId1 == 0 && frameId0 == 0 && iA0E2 == 0 && iA0E == 0 && flags2 == 0 && frameSize == 0) {
            c0980Hh.A0Y(c0980Hh.A07());
            return null;
        }
        int nextFramePosition = c0980Hh.A06() + flags2;
        int frameId4 = c0980Hh.A07();
        String strA0I = A0I(179, 10, 19);
        if (nextFramePosition > frameId4) {
            Log.w(strA0I, A0I(129, 37, 64));
            c0980Hh.A0Y(c0980Hh.A07());
            return null;
        }
        if (dq != null && !dq.A5V(flags, frameId1, frameId0, iA0E2, iA0E)) {
            c0980Hh.A0Y(nextFramePosition);
            return null;
        }
        int i4 = 0;
        int frameSize5 = 0;
        int nextFramePosition2 = 0;
        int frameId5 = 0;
        boolean z2 = false;
        if (flags == 3) {
            frameId5 = (frameSize & 128) != 0 ? 1 : 0;
            frameSize5 = (frameSize & 64) != 0 ? 1 : 0;
            z2 = (frameSize & 32) != 0;
            i4 = frameId5;
        } else {
            if (flags == 4) {
                z2 = (frameSize & 64) != 0;
                int nextFramePosition3 = frameSize & 8;
                if (A02[7].length() != 9) {
                    A02[1] = "HxLFBObUGoObUPku8sA9h7LrWEHKW34t";
                    i4 = nextFramePosition3 != 0 ? 1 : 0;
                    frameSize5 = (frameSize & 4) != 0 ? 1 : 0;
                    nextFramePosition2 = (frameSize & 2) != 0 ? 1 : 0;
                    frameId5 = (frameSize & 1) != 0 ? 1 : 0;
                    if (A02[7].length() == 9) {
                        throw new RuntimeException();
                    }
                    A02[1] = "76YFuh7tw8gcxzUEh5emTmdExIUmXPMQ";
                }
            }
            throw new RuntimeException();
        }
        if (i4 != 0 || frameSize5 != 0) {
            Log.w(strA0I, A0I(303, 50, 77));
            c0980Hh.A0Y(nextFramePosition);
            return null;
        }
        if (z2) {
            flags2--;
            c0980Hh.A0Z(1);
        }
        if (frameId5 != 0) {
            flags2 -= 4;
            c0980Hh.A0Z(4);
        }
        if (nextFramePosition2 != 0) {
            flags2 = A01(c0980Hh, flags2);
        }
        try {
            if (frameId1 == 84 && frameId0 == 88 && iA0E2 == 88 && (flags == 2 || iA0E == 88)) {
                id3FrameA05 = A0D(c0980Hh, flags2);
            } else if (frameId1 == 84) {
                String id = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                id3FrameA05 = A0E(c0980Hh, flags2, id);
            } else if (frameId1 == 87 && frameId0 == 88 && iA0E2 == 88 && (flags == 2 || iA0E == 88)) {
                id3FrameA05 = A0F(c0980Hh, flags2);
            } else if (frameId1 == 87) {
                String id2 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                id3FrameA05 = A0G(c0980Hh, flags2, id2);
            } else if (frameId1 == 80 && frameId0 == 82 && iA0E2 == 73) {
                String[] strArr = A02;
                if (strArr[3].charAt(18) != strArr[2].charAt(18)) {
                    A02[7] = "TpWBQOHSHz";
                    if (iA0E == 86) {
                        id3FrameA05 = A0C(c0980Hh, flags2);
                    } else {
                        if (frameId1 == 71) {
                            String[] strArr2 = A02;
                            String str2 = strArr2[3];
                            str = strArr2[2];
                            frameId3 = str2.charAt(18);
                            if (frameId3 != str.charAt(18)) {
                                A02[1] = "1pyFPk3tXqgthrOgLBh9Cc6ujVWwqIgx";
                                if (flags == 2) {
                                    if (frameId1 == 67) {
                                        if (frameId1 != 67) {
                                            if (frameId1 != 67) {
                                                String id3 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                                id3FrameA05 = A05(c0980Hh, flags2, id3);
                                            } else {
                                                String id4 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                                id3FrameA05 = A05(c0980Hh, flags2, id4);
                                            }
                                        } else if (frameId1 != 67) {
                                            String id5 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                            id3FrameA05 = A05(c0980Hh, flags2, id5);
                                        } else {
                                            String id6 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                            id3FrameA05 = A05(c0980Hh, flags2, id6);
                                        }
                                    } else if (frameId1 != 67) {
                                        if (frameId1 != 67) {
                                            String id7 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                            id3FrameA05 = A05(c0980Hh, flags2, id7);
                                        } else {
                                            String id8 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                            id3FrameA05 = A05(c0980Hh, flags2, id8);
                                        }
                                    } else if (frameId1 != 67) {
                                        String id9 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                        id3FrameA05 = A05(c0980Hh, flags2, id9);
                                    } else {
                                        String id10 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                        id3FrameA05 = A05(c0980Hh, flags2, id10);
                                    }
                                } else if (frameId1 == 67) {
                                    if (frameId1 != 67) {
                                        if (frameId1 != 67) {
                                            String id11 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                            id3FrameA05 = A05(c0980Hh, flags2, id11);
                                        } else {
                                            String id12 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                            id3FrameA05 = A05(c0980Hh, flags2, id12);
                                        }
                                    } else if (frameId1 != 67) {
                                        String id13 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                        id3FrameA05 = A05(c0980Hh, flags2, id13);
                                    } else {
                                        String id14 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                        id3FrameA05 = A05(c0980Hh, flags2, id14);
                                    }
                                } else if (frameId1 != 67) {
                                    if (frameId1 != 67) {
                                        String id15 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                        id3FrameA05 = A05(c0980Hh, flags2, id15);
                                    } else {
                                        String id16 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                        id3FrameA05 = A05(c0980Hh, flags2, id16);
                                    }
                                } else if (frameId1 != 67) {
                                    String id17 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                    id3FrameA05 = A05(c0980Hh, flags2, id17);
                                } else {
                                    String id18 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                    id3FrameA05 = A05(c0980Hh, flags2, id18);
                                }
                            }
                            throw new RuntimeException();
                        }
                        String[] strArr3 = A02;
                        String str3 = strArr3[3];
                        str = strArr3[2];
                        frameId3 = str3.charAt(18);
                        if (frameId3 != str.charAt(18)) {
                            A02[1] = "1pyFPk3tXqgthrOgLBh9Cc6ujVWwqIgx";
                            if (flags == 2) {
                                if (frameId1 == 67) {
                                    if (frameId1 != 67) {
                                        if (frameId1 != 67) {
                                            String id19 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                            id3FrameA05 = A05(c0980Hh, flags2, id19);
                                        } else {
                                            String id110 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                            id3FrameA05 = A05(c0980Hh, flags2, id110);
                                        }
                                    } else if (frameId1 != 67) {
                                        String id111 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                        id3FrameA05 = A05(c0980Hh, flags2, id111);
                                    } else {
                                        String id112 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                        id3FrameA05 = A05(c0980Hh, flags2, id112);
                                    }
                                } else if (frameId1 != 67) {
                                    if (frameId1 != 67) {
                                        String id113 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                        id3FrameA05 = A05(c0980Hh, flags2, id113);
                                    } else {
                                        String id114 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                        id3FrameA05 = A05(c0980Hh, flags2, id114);
                                    }
                                } else if (frameId1 != 67) {
                                    String id115 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                    id3FrameA05 = A05(c0980Hh, flags2, id115);
                                } else {
                                    String id116 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                    id3FrameA05 = A05(c0980Hh, flags2, id116);
                                }
                            } else if (frameId1 == 67) {
                                if (frameId1 != 67) {
                                    if (frameId1 != 67) {
                                        String id117 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                        id3FrameA05 = A05(c0980Hh, flags2, id117);
                                    } else {
                                        String id118 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                        id3FrameA05 = A05(c0980Hh, flags2, id118);
                                    }
                                } else if (frameId1 != 67) {
                                    String id119 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                    id3FrameA05 = A05(c0980Hh, flags2, id119);
                                } else {
                                    String id1110 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                    id3FrameA05 = A05(c0980Hh, flags2, id1110);
                                }
                            } else if (frameId1 != 67) {
                                if (frameId1 != 67) {
                                    String id1111 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                    id3FrameA05 = A05(c0980Hh, flags2, id1111);
                                } else {
                                    String id1112 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                    id3FrameA05 = A05(c0980Hh, flags2, id1112);
                                }
                            } else if (frameId1 != 67) {
                                String id1113 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                id3FrameA05 = A05(c0980Hh, flags2, id1113);
                            } else {
                                String id1114 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                id3FrameA05 = A05(c0980Hh, flags2, id1114);
                            }
                        }
                        throw new RuntimeException();
                    }
                } else if (iA0E == 86) {
                    id3FrameA05 = A0C(c0980Hh, flags2);
                } else {
                    if (frameId1 == 71) {
                        String[] strArr4 = A02;
                        String str4 = strArr4[3];
                        str = strArr4[2];
                        frameId3 = str4.charAt(18);
                        if (frameId3 != str.charAt(18)) {
                            A02[1] = "1pyFPk3tXqgthrOgLBh9Cc6ujVWwqIgx";
                            if (flags == 2) {
                                if (frameId1 == 67) {
                                    if (frameId1 != 67) {
                                        if (frameId1 != 67) {
                                            String id1115 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                            id3FrameA05 = A05(c0980Hh, flags2, id1115);
                                        } else {
                                            String id1116 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                            id3FrameA05 = A05(c0980Hh, flags2, id1116);
                                        }
                                    } else if (frameId1 != 67) {
                                        String id1117 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                        id3FrameA05 = A05(c0980Hh, flags2, id1117);
                                    } else {
                                        String id1118 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                        id3FrameA05 = A05(c0980Hh, flags2, id1118);
                                    }
                                } else if (frameId1 != 67) {
                                    if (frameId1 != 67) {
                                        String id1119 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                        id3FrameA05 = A05(c0980Hh, flags2, id1119);
                                    } else {
                                        String id11110 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                        id3FrameA05 = A05(c0980Hh, flags2, id11110);
                                    }
                                } else if (frameId1 != 67) {
                                    String id11111 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                    id3FrameA05 = A05(c0980Hh, flags2, id11111);
                                } else {
                                    String id11112 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                    id3FrameA05 = A05(c0980Hh, flags2, id11112);
                                }
                            } else if (frameId1 == 67) {
                                if (frameId1 != 67) {
                                    if (frameId1 != 67) {
                                        String id11113 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                        id3FrameA05 = A05(c0980Hh, flags2, id11113);
                                    } else {
                                        String id11114 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                        id3FrameA05 = A05(c0980Hh, flags2, id11114);
                                    }
                                } else if (frameId1 != 67) {
                                    String id11115 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                    id3FrameA05 = A05(c0980Hh, flags2, id11115);
                                } else {
                                    String id11116 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                    id3FrameA05 = A05(c0980Hh, flags2, id11116);
                                }
                            } else if (frameId1 != 67) {
                                if (frameId1 != 67) {
                                    String id11117 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                    id3FrameA05 = A05(c0980Hh, flags2, id11117);
                                } else {
                                    String id11118 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                    id3FrameA05 = A05(c0980Hh, flags2, id11118);
                                }
                            } else if (frameId1 != 67) {
                                String id11119 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                id3FrameA05 = A05(c0980Hh, flags2, id11119);
                            } else {
                                String id111110 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                id3FrameA05 = A05(c0980Hh, flags2, id111110);
                            }
                        }
                        throw new RuntimeException();
                    }
                    String[] strArr5 = A02;
                    String str5 = strArr5[3];
                    str = strArr5[2];
                    frameId3 = str5.charAt(18);
                    if (frameId3 != str.charAt(18)) {
                        A02[1] = "1pyFPk3tXqgthrOgLBh9Cc6ujVWwqIgx";
                        if (flags == 2) {
                            if (frameId1 == 67) {
                                if (frameId1 != 67) {
                                    if (frameId1 != 67) {
                                        String id111111 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                        id3FrameA05 = A05(c0980Hh, flags2, id111111);
                                    } else {
                                        String id111112 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                        id3FrameA05 = A05(c0980Hh, flags2, id111112);
                                    }
                                } else if (frameId1 != 67) {
                                    String id111113 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                    id3FrameA05 = A05(c0980Hh, flags2, id111113);
                                } else {
                                    String id111114 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                    id3FrameA05 = A05(c0980Hh, flags2, id111114);
                                }
                            } else if (frameId1 != 67) {
                                if (frameId1 != 67) {
                                    String id111115 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                    id3FrameA05 = A05(c0980Hh, flags2, id111115);
                                } else {
                                    String id111116 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                    id3FrameA05 = A05(c0980Hh, flags2, id111116);
                                }
                            } else if (frameId1 != 67) {
                                String id111117 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                id3FrameA05 = A05(c0980Hh, flags2, id111117);
                            } else {
                                String id111118 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                id3FrameA05 = A05(c0980Hh, flags2, id111118);
                            }
                        } else if (frameId1 == 67) {
                            if (frameId1 != 67) {
                                if (frameId1 != 67) {
                                    String id111119 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                    id3FrameA05 = A05(c0980Hh, flags2, id111119);
                                } else {
                                    String id1111110 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                    id3FrameA05 = A05(c0980Hh, flags2, id1111110);
                                }
                            } else if (frameId1 != 67) {
                                String id1111111 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                id3FrameA05 = A05(c0980Hh, flags2, id1111111);
                            } else {
                                String id1111112 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                id3FrameA05 = A05(c0980Hh, flags2, id1111112);
                            }
                        } else if (frameId1 != 67) {
                            if (frameId1 != 67) {
                                String id1111113 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                id3FrameA05 = A05(c0980Hh, flags2, id1111113);
                            } else {
                                String id1111114 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                id3FrameA05 = A05(c0980Hh, flags2, id1111114);
                            }
                        } else if (frameId1 != 67) {
                            String id1111115 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                            id3FrameA05 = A05(c0980Hh, flags2, id1111115);
                        } else {
                            String id1111116 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                            id3FrameA05 = A05(c0980Hh, flags2, id1111116);
                        }
                    }
                    throw new RuntimeException();
                }
            } else {
                if (frameId1 == 71 || frameId0 != 69 || iA0E2 != 79 || (iA0E != 66 && flags != 2)) {
                    String[] strArr6 = A02;
                    String str6 = strArr6[3];
                    str = strArr6[2];
                    frameId3 = str6.charAt(18);
                    if (frameId3 != str.charAt(18)) {
                        A02[1] = "1pyFPk3tXqgthrOgLBh9Cc6ujVWwqIgx";
                        if (flags == 2 ? !(frameId1 != 65 || frameId0 != 80 || iA0E2 != 73 || iA0E != 67) : !(frameId1 != 80 || frameId0 != 73 || iA0E2 != 67)) {
                            id3FrameA05 = A04(c0980Hh, flags2, flags);
                        } else if (frameId1 == 67 || frameId0 != 79 || iA0E2 != 77 || (iA0E != 77 && flags != 2)) {
                            if (frameId1 != 67 && frameId0 == 72 && iA0E2 == 65 && iA0E == 80) {
                                id3FrameA05 = A06(c0980Hh, flags2, flags, z, i, dq);
                            } else if (frameId1 != 67 && frameId0 == 84 && iA0E2 == 79 && iA0E == 67) {
                                id3FrameA05 = A07(c0980Hh, flags2, flags, z, i, dq);
                            } else {
                                String id1111117 = A0J(flags, frameId1, frameId0, iA0E2, iA0E);
                                id3FrameA05 = A05(c0980Hh, flags2, id1111117);
                            }
                        } else {
                            id3FrameA05 = A08(c0980Hh, flags2);
                        }
                    }
                    throw new RuntimeException();
                }
                id3FrameA05 = A09(c0980Hh, flags2);
            }
            if (id3FrameA05 == null) {
                Log.w(strA0I, A0I(57, 27, 82) + A0J(flags, frameId1, frameId0, iA0E2, iA0E) + A0I(14, 12, 119) + flags2);
            }
            c0980Hh.A0Y(nextFramePosition);
            String[] strArr7 = A02;
            if (strArr7[0].charAt(4) == strArr7[6].charAt(4)) {
                throw new RuntimeException();
            }
            String[] strArr8 = A02;
            strArr8[0] = "Dtpy20dKfpjr6GTNw3SVg8ra0l6IUEaG";
            strArr8[6] = "adhGTkdPtMJ1tGydAzIftpfQfU5S2oNR";
            return id3FrameA05;
        } catch (UnsupportedEncodingException unused) {
            Log.w(strA0I, A0I(424, 30, 68));
            return null;
        } finally {
            c0980Hh.A0Y(nextFramePosition);
        }
    }

    public static PrivFrame A0C(C0980Hh c0980Hh, int i) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        c0980Hh.A0c(bArr, 0, i);
        int iA02 = A02(bArr, 0);
        return new PrivFrame(new String(bArr, 0, iA02, A0I(169, 10, 32)), A0N(bArr, iA02 + 1, bArr.length));
    }

    public static TextInformationFrame A0D(C0980Hh c0980Hh, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int valueStartIndex = c0980Hh.A0E();
        String strA0H = A0H(valueStartIndex);
        int encoding = i - 1;
        byte[] data = new byte[encoding];
        int encoding2 = i - 1;
        c0980Hh.A0c(data, 0, encoding2);
        int encoding3 = A03(data, 0, valueStartIndex);
        String description = new String(data, 0, encoding3, strA0H);
        int iA00 = A00(valueStartIndex) + encoding3;
        int encoding4 = A03(data, iA00, valueStartIndex);
        String strA0K = A0K(data, iA00, encoding4, strA0H);
        String charset = A0I(353, 4, 104);
        return new TextInformationFrame(charset, description, strA0K);
    }

    public static TextInformationFrame A0E(C0980Hh c0980Hh, int i, String str) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int iA0E = c0980Hh.A0E();
        String strA0H = A0H(iA0E);
        int encoding = i - 1;
        byte[] data = new byte[encoding];
        int encoding2 = i - 1;
        c0980Hh.A0c(data, 0, encoding2);
        int encoding3 = A03(data, 0, iA0E);
        return new TextInformationFrame(str, null, new String(data, 0, encoding3, strA0H));
    }

    public static UrlLinkFrame A0F(C0980Hh c0980Hh, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int descriptionEndIndex = c0980Hh.A0E();
        String strA0H = A0H(descriptionEndIndex);
        int encoding = i - 1;
        byte[] bArr = new byte[encoding];
        int encoding2 = i - 1;
        c0980Hh.A0c(bArr, 0, encoding2);
        int encoding3 = A03(bArr, 0, descriptionEndIndex);
        String str = new String(bArr, 0, encoding3, strA0H);
        int iA00 = A00(descriptionEndIndex) + encoding3;
        String strA0K = A0K(bArr, iA00, A02(bArr, iA00), A0I(169, 10, 32));
        String charset = A0I(454, 4, 52);
        return new UrlLinkFrame(charset, str, strA0K);
    }

    public static UrlLinkFrame A0G(C0980Hh c0980Hh, int i, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        c0980Hh.A0c(bArr, 0, i);
        return new UrlLinkFrame(str, null, new String(bArr, 0, A02(bArr, 0), A0I(169, 10, 32)));
    }

    public static String A0H(int i) {
        String strA0I = A0I(169, 10, 32);
        switch (i) {
            case 0:
                return strA0I;
            case 1:
                return A0I(357, 6, 72);
            case 2:
                return A0I(363, 8, 105);
            case 3:
                String strA0I2 = A0I(371, 5, 97);
                String[] strArr = A02;
                if (strArr[0].charAt(4) == strArr[6].charAt(4)) {
                    throw new RuntimeException();
                }
                A02[7] = "WB3CnC";
                return strA0I2;
            default:
                return strA0I;
        }
    }

    public static String A0J(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, A0I(0, 6, 105), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, A0I(6, 8, 11), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static String A0K(byte[] bArr, int i, int i2, String str) throws UnsupportedEncodingException {
        if (i2 > i && i2 <= bArr.length) {
            return new String(bArr, i, i2 - i, str);
        }
        String[] strArr = A02;
        if (strArr[4].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[0] = "r4Qi0WBzOYfLLA4UC9s9DAK76ksjAQPp";
        strArr2[6] = "c5jPrSHyFK7RFs6Pjjym9ojkSMFCl1O5";
        return A0I(0, 0, 121);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00b1  */
    public static boolean A0M(C0980Hh c0980Hh, int i, int i2, boolean z) throws Throwable {
        int iA08;
        long jA0M;
        int iA0I;
        int iA06 = c0980Hh.A06();
        while (true) {
            try {
                if (c0980Hh.A04() >= i2) {
                    if (i >= 3) {
                        try {
                            iA08 = c0980Hh.A08();
                            jA0M = c0980Hh.A0M();
                            iA0I = c0980Hh.A0I();
                        } catch (Throwable th) {
                            th = th;
                            c0980Hh.A0Y(iA06);
                            throw th;
                        }
                    } else {
                        iA08 = c0980Hh.A0G();
                        jA0M = c0980Hh.A0G();
                        iA0I = 0;
                    }
                    if (iA08 == 0 && jA0M == 0 && iA0I == 0) {
                        c0980Hh.A0Y(iA06);
                        return true;
                    }
                    if (i == 4 && !z) {
                        if ((8421504 & jA0M) != 0) {
                            c0980Hh.A0Y(iA06);
                            return false;
                        }
                        long j = (jA0M & 255) | (((jA0M >> 8) & 255) << 7);
                        String[] strArr = A02;
                        if (strArr[4].length() != strArr[5].length()) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A02;
                        strArr2[0] = "WW8harr0n1WVcE671SufvW5i3HFI8G3E";
                        strArr2[6] = "cs8JhXohJ41Zu2keAfctBKv0IiLyHEBA";
                        jA0M = (((jA0M >> 24) & 255) << 21) | j | (((jA0M >> 16) & 255) << 14);
                    }
                    boolean z2 = false;
                    int flags = 0;
                    if (i == 4) {
                        z2 = (iA0I & 64) != 0;
                        flags = (iA0I & 1) == 0 ? 0 : 1;
                    } else if (i == 3) {
                        int minimumFrameSize = iA0I & 32;
                        z2 = minimumFrameSize != 0;
                        int minimumFrameSize2 = iA0I & 128;
                        flags = minimumFrameSize2 == 0 ? 0 : 1;
                    }
                    int i3 = 0;
                    String[] strArr3 = A02;
                    if (strArr3[4].length() != strArr3[5].length()) {
                        if (z2) {
                            i3 = 0 + 1;
                        }
                    } else {
                        String[] strArr4 = A02;
                        strArr4[3] = "otGI0hsmNkIa4sbMlKQFq5zev1M8Vgvr";
                        strArr4[2] = "hsxwZKJ37TLGlj6U8xTCexdOCMrqimac";
                        if (z2) {
                            i3 = 0 + 1;
                        }
                    }
                    if (flags != 0) {
                        i3 += 4;
                    }
                    if (jA0M < i3) {
                        c0980Hh.A0Y(iA06);
                        return false;
                    }
                    int minimumFrameSize3 = c0980Hh.A04();
                    if (minimumFrameSize3 >= jA0M) {
                        int minimumFrameSize4 = (int) jA0M;
                        c0980Hh.A0Z(minimumFrameSize4);
                    } else {
                        c0980Hh.A0Y(iA06);
                        return false;
                    }
                } else {
                    c0980Hh.A0Y(iA06);
                    return true;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static byte[] A0N(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return new byte[0];
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }

    public final Metadata A0O(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        C0980Hh c0980Hh = new C0980Hh(bArr, i);
        DR drA0A = A0A(c0980Hh);
        if (drA0A == null) {
            return null;
        }
        int startPosition = c0980Hh.A06();
        int frameHeaderSize = drA0A.A01 == 2 ? 6 : 10;
        int iA01 = drA0A.A00;
        if (drA0A.A02) {
            iA01 = A01(c0980Hh, drA0A.A00);
        }
        c0980Hh.A0X(startPosition + iA01);
        boolean z = false;
        if (!A0M(c0980Hh, drA0A.A01, frameHeaderSize, false)) {
            if (drA0A.A01 != 4 || !A0M(c0980Hh, 4, frameHeaderSize, true)) {
                Log.w(A0I(179, 10, 19), A0I(84, 45, 51) + drA0A.A01);
                return null;
            }
            z = true;
        }
        while (c0980Hh.A04() >= frameHeaderSize) {
            Id3Frame id3FrameA0B = A0B(drA0A.A01, c0980Hh, z, frameHeaderSize, this.A00);
            if (id3FrameA0B != null) {
                arrayList.add(id3FrameA0B);
            }
        }
        return new Metadata(arrayList);
    }

    @Override // com.facebook.ads.redexgen.X.DE
    public final Metadata A4x(D1 d1) {
        ByteBuffer buffer = d1.A01;
        return A0O(buffer.array(), buffer.limit());
    }
}
