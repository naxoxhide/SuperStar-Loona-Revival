package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.util.Log;
import android.util.SparseArray;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0938Fp {
    public static byte[] A07;
    public static String[] A08 = {"qcU5l5rVDanZ0IBZnB67EILhI18GgdFe", "32XpuNghlFeF4zyqPL948gmCUNCGk", "bftD5DkqR73p2Uf2yBhEF5T9UOvyv9s", "0", "qryxRa4yOsFNWhLtu25s3YxhDLRy", "", "tLr9RBWs5E21", "UeFN6nMF8sjHvHxScJIKm37Ehl9oCVg2"};
    public static final byte[] A09;
    public static final byte[] A0A;
    public static final byte[] A0B;
    public Bitmap A00;
    public final Canvas A01;
    public final Paint A02;
    public final Paint A03;
    public final C0930Fh A04;
    public final C0931Fi A05;
    public final C0937Fo A06;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 19 out of bounds for length 19
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static C0930Fh A04(C0979Hg c0979Hg, int i) {
        int[] iArr;
        int iA04;
        int iA05;
        int iA06;
        int iA07;
        int i2 = 8;
        int iA08 = c0979Hg.A04(8);
        c0979Hg.A08(8);
        int i3 = i - 2;
        int[] iArrA0F = A0F();
        int[] iArrA0G = A0G();
        int[] iArrA0H = A0H();
        while (i3 > 0) {
            int iA09 = c0979Hg.A04(i2);
            int iA010 = c0979Hg.A04(i2);
            int i4 = i3 - 2;
            if ((iA010 & 128) != 0) {
                iArr = iArrA0F;
            } else {
                iArr = (iA010 & 64) != 0 ? iArrA0G : iArrA0H;
            }
            if ((iA010 & 1) != 0) {
                iA04 = c0979Hg.A04(i2);
                iA05 = c0979Hg.A04(i2);
                iA06 = c0979Hg.A04(i2);
                iA07 = c0979Hg.A04(i2);
                i3 = i4 - 4;
            } else {
                iA04 = c0979Hg.A04(6) << 2;
                iA05 = c0979Hg.A04(4) << 4;
                iA06 = c0979Hg.A04(4) << 4;
                iA07 = c0979Hg.A04(2) << 6;
                i3 = i4 - 2;
            }
            if (iA04 == 0) {
                iA05 = 0;
                iA06 = 0;
                iA07 = 255;
            }
            iArr[iA09] = A00((byte) (255 - (iA07 & 255)), C0996Hx.A06((int) (((double) iA04) + (((double) (iA05 - 128)) * 1.402d)), 0, 255), C0996Hx.A06((int) ((((double) iA04) - (((double) (iA06 - 128)) * 0.34414d)) - (((double) (iA05 - 128)) * 0.71414d)), 0, 255), C0996Hx.A06((int) (((double) iA04) + (((double) (iA06 - 128)) * 1.772d)), 0, 255));
            i2 = 8;
        }
        return new C0930Fh(iA08, iArrA0F, iArrA0G, iArrA0H);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 8
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static C0931Fi A05(C0979Hg c0979Hg) {
        int iA04;
        int iA05;
        int iA06;
        int iA07;
        c0979Hg.A08(4);
        boolean zA0F = c0979Hg.A0F();
        c0979Hg.A08(3);
        int iA08 = c0979Hg.A04(16);
        int iA09 = c0979Hg.A04(16);
        if (zA0F) {
            iA04 = c0979Hg.A04(16);
            iA07 = c0979Hg.A04(16);
            iA05 = c0979Hg.A04(16);
            iA06 = c0979Hg.A04(16);
        } else {
            iA04 = 0;
            iA05 = 0;
            iA06 = iA09;
            iA07 = iA08;
        }
        return new C0931Fi(iA08, iA09, iA04, iA07, iA05, iA06);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 27 out of bounds for length 27
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static C0935Fm A08(C0979Hg c0979Hg, int i) {
        int i2 = 8;
        int iA04 = c0979Hg.A04(8);
        c0979Hg.A08(4);
        boolean zA0F = c0979Hg.A0F();
        c0979Hg.A08(3);
        int iA05 = c0979Hg.A04(16);
        int iA06 = c0979Hg.A04(16);
        int iA07 = c0979Hg.A04(3);
        int iA08 = c0979Hg.A04(3);
        c0979Hg.A08(2);
        int iA09 = c0979Hg.A04(8);
        int iA010 = c0979Hg.A04(8);
        int iA011 = c0979Hg.A04(4);
        int iA012 = c0979Hg.A04(2);
        c0979Hg.A08(2);
        int i3 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i3 > 0) {
            int iA013 = c0979Hg.A04(16);
            int iA014 = c0979Hg.A04(2);
            int iA015 = c0979Hg.A04(2);
            int iA016 = c0979Hg.A04(12);
            c0979Hg.A08(4);
            int iA017 = c0979Hg.A04(12);
            i3 -= 6;
            int iA018 = 0;
            int iA019 = 0;
            if (iA014 == 1 || iA014 == 2) {
                iA018 = c0979Hg.A04(i2);
                iA019 = c0979Hg.A04(i2);
                i3 -= 2;
            }
            sparseArray.put(iA013, new C0936Fn(iA014, iA015, iA016, iA017, iA018, iA019));
            i2 = 8;
        }
        return new C0935Fm(iA04, zA0F, iA05, iA06, iA07, iA08, iA09, iA010, iA011, iA012, sparseArray);
    }

    public static String A09(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A07 = new byte[]{18, 55, 34, 55, 118, 48, 63, 51, 58, 50, 118, 58, 51, 56, 49, 34, 62, 118, 51, 46, 53, 51, 51, 50, 37, 118, 58, 63, 59, 63, 34, 106, 88, 76, 126, 79, 92, 93, 75, 92};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 28 out of bounds for length 28
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final List<FV> A0I(byte[] bArr, int i) {
        C0979Hg c0979Hg = new C0979Hg(bArr, i);
        while (c0979Hg.A01() >= 48 && c0979Hg.A04(8) == 15) {
            A0C(c0979Hg, this.A06);
        }
        if (this.A06.A01 == null) {
            return Collections.emptyList();
        }
        C0931Fi c0931Fi = this.A06.A00 != null ? this.A06.A00 : this.A05;
        if (this.A00 == null || c0931Fi.A05 + 1 != this.A00.getWidth() || c0931Fi.A00 + 1 != this.A00.getHeight()) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(c0931Fi.A05 + 1, c0931Fi.A00 + 1, Bitmap.Config.ARGB_8888);
            this.A00 = bitmapCreateBitmap;
            this.A01.setBitmap(bitmapCreateBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<C0934Fl> sparseArray = this.A06.A01.A03;
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            C0934Fl c0934FlValueAt = sparseArray.valueAt(i2);
            C0935Fm c0935Fm = this.A06.A08.get(sparseArray.keyAt(i2));
            int i3 = c0934FlValueAt.A00 + c0931Fi.A02;
            int i4 = c0934FlValueAt.A01 + c0931Fi.A04;
            this.A01.clipRect(i3, i4, Math.min(c0935Fm.A08 + i3, c0931Fi.A01), Math.min(c0935Fm.A02 + i4, c0931Fi.A03), Region.Op.REPLACE);
            C0930Fh c0930Fh = this.A06.A06.get(c0935Fm.A00);
            if (c0930Fh == null && (c0930Fh = this.A06.A04.get(c0935Fm.A00)) == null) {
                c0930Fh = this.A04;
            }
            SparseArray<C0936Fn> sparseArray2 = c0935Fm.A09;
            for (int i5 = 0; i5 < sparseArray2.size(); i5++) {
                int iKeyAt = sparseArray2.keyAt(i5);
                C0936Fn c0936FnValueAt = sparseArray2.valueAt(i5);
                C0932Fj c0932Fj = this.A06.A07.get(iKeyAt);
                String[] strArr = A08;
                if (strArr[0].charAt(24) == strArr[7].charAt(24)) {
                    throw new RuntimeException();
                }
                A08[1] = "0wDldquZfVkccfOmGfzJ1HL0d6oT0";
                if (c0932Fj == null) {
                    c0932Fj = this.A06.A05.get(iKeyAt);
                }
                if (c0932Fj != null) {
                    A0B(c0932Fj, c0930Fh, c0935Fm.A01, i3 + c0936FnValueAt.A02, i4 + c0936FnValueAt.A05, c0932Fj.A01 ? null : this.A02, this.A01);
                }
            }
            if (c0935Fm.A0A) {
                this.A03.setColor(c0935Fm.A01 == 3 ? c0930Fh.A03[c0935Fm.A07] : c0935Fm.A01 == 2 ? c0930Fh.A02[c0935Fm.A06] : c0930Fh.A01[c0935Fm.A05]);
                this.A01.drawRect(i3, i4, c0935Fm.A08 + i3, c0935Fm.A02 + i4, this.A03);
            }
            arrayList.add(new FV(Bitmap.createBitmap(this.A00, i3, i4, c0935Fm.A08, c0935Fm.A02), i3 / c0931Fi.A05, 0, i4 / c0931Fi.A00, 0, c0935Fm.A08 / c0931Fi.A05, c0935Fm.A02 / c0931Fi.A00));
            this.A01.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        return arrayList;
    }

    static {
        A0A();
        A09 = new byte[]{0, 7, 8, 15};
        A0A = new byte[]{0, 119, -120, -1};
        A0B = new byte[]{0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    }

    public C0938Fp(int i, int i2) {
        Paint paint = new Paint();
        this.A02 = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.A03 = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.A01 = new Canvas();
        this.A05 = new C0931Fi(719, 575, 0, 719, 0, 575);
        this.A04 = new C0930Fh(0, A0F(), A0G(), A0H());
        this.A06 = new C0937Fo(i, i2);
    }

    public static int A00(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    public static int A01(C0979Hg c0979Hg, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        int i3 = i;
        boolean z = false;
        do {
            int iA04 = 0;
            int iA05 = c0979Hg.A04(2);
            if (iA05 != 0) {
                iA04 = 1;
                if (A08[1].length() != 29) {
                    throw new RuntimeException();
                }
                A08[6] = "cKDkKJCaTP5Z";
            } else if (c0979Hg.A0F()) {
                iA04 = c0979Hg.A04(3) + 3;
                iA05 = c0979Hg.A04(2);
                if (A08[1].length() == 29) {
                    A08[1] = "Xe5wyvwrL1rxQiCfD8ENREY9AaRUH";
                }
            } else if (c0979Hg.A0F()) {
                iA04 = 1;
                iA05 = 0;
            } else {
                switch (c0979Hg.A04(2)) {
                    case 0:
                        z = true;
                        iA05 = 0;
                        break;
                    case 1:
                        iA04 = 2;
                        iA05 = 0;
                        break;
                    case 2:
                        iA04 = c0979Hg.A04(4) + 12;
                        iA05 = c0979Hg.A04(2);
                        break;
                    case 3:
                        iA04 = c0979Hg.A04(8) + 29;
                        if (A08[1].length() != 29) {
                            throw new RuntimeException();
                        }
                        A08[5] = "eZC8v48u";
                        iA05 = c0979Hg.A04(2);
                        break;
                    default:
                        iA05 = 0;
                        break;
                }
            }
            if (iA04 != 0 && paint != null) {
                if (bArr != null) {
                    iA05 = bArr[iA05];
                }
                paint.setColor(iArr[iA05]);
                canvas.drawRect(i3, i2, i3 + iA04, i2 + 1, paint);
            }
            i3 += iA04;
        } while (!z);
        return i3;
    }

    public static int A02(C0979Hg c0979Hg, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        int i3 = i;
        boolean z = false;
        do {
            int peek = 0;
            int iA04 = c0979Hg.A04(4);
            if (iA04 != 0) {
                peek = 1;
            } else if (!c0979Hg.A0F()) {
                int iA05 = c0979Hg.A04(3);
                if (iA05 != 0) {
                    peek = iA05 + 2;
                    iA04 = 0;
                } else {
                    z = true;
                    iA04 = 0;
                }
            } else if (!c0979Hg.A0F()) {
                peek = c0979Hg.A04(2) + 4;
                iA04 = c0979Hg.A04(4);
            } else {
                switch (c0979Hg.A04(2)) {
                    case 0:
                        peek = 1;
                        if (A08[1].length() == 29) {
                            String[] strArr = A08;
                            strArr[3] = DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B;
                            strArr[4] = "RKCQrML1KI9i2rbeBXbE06C32ORX";
                            iA04 = 0;
                        } else {
                            iA04 = 0;
                        }
                        break;
                    case 1:
                        peek = 2;
                        iA04 = 0;
                        break;
                    case 2:
                        peek = c0979Hg.A04(4) + 9;
                        iA04 = c0979Hg.A04(4);
                        break;
                    case 3:
                        peek = c0979Hg.A04(8) + 25;
                        String[] strArr2 = A08;
                        if (strArr2[3].length() == strArr2[4].length()) {
                            throw new RuntimeException();
                        }
                        A08[6] = "tDVEwF5JbpPt";
                        iA04 = c0979Hg.A04(4);
                        break;
                        break;
                    default:
                        iA04 = 0;
                        break;
                }
            }
            if (peek != 0 && paint != null) {
                if (bArr != null) {
                    iA04 = bArr[iA04];
                }
                paint.setColor(iArr[iA04]);
                float f = i3;
                float f2 = i2;
                if (A08[6].length() != 12) {
                    throw new RuntimeException();
                }
                A08[1] = "PxagUxU0Gd3Wd2jZQY5J7se2mW8fT";
                canvas.drawRect(f, f2, i3 + peek, i2 + 1, paint);
            }
            i3 += peek;
        } while (!z);
        return i3;
    }

    public static int A03(C0979Hg c0979Hg, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        int clutIndex;
        int i3 = i;
        boolean z = false;
        do {
            int iA04 = c0979Hg.A04(8);
            if (iA04 != 0) {
                clutIndex = 1;
            } else if (!c0979Hg.A0F()) {
                clutIndex = c0979Hg.A04(7);
                if (A08[6].length() != 12) {
                    throw new RuntimeException();
                }
                A08[1] = "SuejjuLnG0h9t9VMaryqiTg33Oi2Z";
                if (clutIndex != 0) {
                    iA04 = 0;
                } else {
                    z = true;
                    clutIndex = 0;
                    iA04 = 0;
                }
            } else {
                clutIndex = c0979Hg.A04(7);
                iA04 = c0979Hg.A04(8);
            }
            if (clutIndex != 0 && paint != null) {
                if (bArr != null) {
                    iA04 = bArr[iA04];
                }
                paint.setColor(iArr[iA04]);
                canvas.drawRect(i3, i2, i3 + clutIndex, i2 + 1, paint);
            }
            i3 += clutIndex;
        } while (!z);
        return i3;
    }

    public static C0932Fj A06(C0979Hg c0979Hg) {
        int iA04 = c0979Hg.A04(16);
        c0979Hg.A08(4);
        int objectId = c0979Hg.A04(2);
        boolean zA0F = c0979Hg.A0F();
        c0979Hg.A08(1);
        byte[] bArr = null;
        byte[] bArr2 = null;
        if (objectId == 1) {
            int numberOfCodes = c0979Hg.A04(8);
            c0979Hg.A08(numberOfCodes * 16);
        } else if (objectId == 0) {
            int objectCodingMethod = c0979Hg.A04(16);
            int objectId2 = c0979Hg.A04(16);
            if (objectCodingMethod > 0) {
                bArr = new byte[objectCodingMethod];
                c0979Hg.A0E(bArr, 0, objectCodingMethod);
            }
            if (objectId2 > 0) {
                bArr2 = new byte[objectId2];
                c0979Hg.A0E(bArr2, 0, objectId2);
            } else {
                bArr2 = bArr;
            }
        }
        return new C0932Fj(iA04, zA0F, bArr, bArr2);
    }

    public static C0933Fk A07(C0979Hg c0979Hg, int i) {
        int iA04 = c0979Hg.A04(8);
        int iA05 = c0979Hg.A04(4);
        int iA06 = c0979Hg.A04(2);
        c0979Hg.A08(2);
        int i2 = i - 2;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int remainingLength = c0979Hg.A04(8);
            c0979Hg.A08(8);
            int version = c0979Hg.A04(16);
            int timeoutSecs = c0979Hg.A04(16);
            i2 -= 6;
            sparseArray.put(remainingLength, new C0934Fl(version, timeoutSecs));
        }
        return new C0933Fk(iA04, iA05, iA06, sparseArray);
    }

    public static void A0B(C0932Fj c0932Fj, C0930Fh c0930Fh, int i, int i2, int i3, Paint paint, Canvas canvas) {
        int[] iArr;
        if (i == 3) {
            iArr = c0930Fh.A03;
        } else {
            if (A08[2].length() == 20) {
                throw new RuntimeException();
            }
            A08[1] = "74G7JuTvJBV0INH1XI3DUfK6d2EWZ";
            if (i == 2) {
                iArr = c0930Fh.A02;
            } else {
                iArr = c0930Fh.A01;
            }
        }
        A0D(c0932Fj.A03, iArr, i, i2, i3, paint, canvas);
        A0D(c0932Fj.A02, iArr, i, i2, i3 + 1, paint, canvas);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x006e  */
    /* JADX WARN: Code duplicated, block: B:19:0x008c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x008e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0094  */
    public static void A0C(C0979Hg c0979Hg, C0937Fo c0937Fo) {
        int dataFieldLength;
        int segmentType;
        int iA04 = c0979Hg.A04(8);
        int iA05 = c0979Hg.A04(16);
        int pageId = c0979Hg.A04(16);
        int dataFieldLimit = c0979Hg.A02() + pageId;
        int dataFieldLength2 = pageId * 8;
        int segmentType2 = c0979Hg.A01();
        if (dataFieldLength2 > segmentType2) {
            Log.w(A09(31, 9, 63), A09(0, 31, 71));
            int segmentType3 = c0979Hg.A01();
            c0979Hg.A08(segmentType3);
            return;
        }
        switch (iA04) {
            case 16:
                int segmentType4 = c0937Fo.A03;
                if (iA05 == segmentType4) {
                    C0933Fk pageComposition = c0937Fo.A01;
                    C0933Fk current = A07(c0979Hg, pageId);
                    int dataFieldLength3 = A08[2].length();
                    if (dataFieldLength3 != 20) {
                        String[] strArr = A08;
                        strArr[0] = "SOWWurFjCTsQ5JKY9OnGZdezCI3KtXYI";
                        strArr[7] = "V4dNvY88haURe4qy074bHXOdfnJc7iQY";
                        int segmentType5 = current.A00;
                        if (segmentType5 != 0) {
                            c0937Fo.A01 = current;
                            c0937Fo.A08.clear();
                            c0937Fo.A06.clear();
                            c0937Fo.A07.clear();
                        } else if (pageComposition != null) {
                            dataFieldLength = pageComposition.A02;
                            segmentType = current.A02;
                            if (dataFieldLength != segmentType) {
                                c0937Fo.A01 = current;
                            }
                        }
                    } else {
                        A08[5] = "eHaCLq5ayPLh";
                        int segmentType6 = current.A00;
                        if (segmentType6 != 0) {
                            c0937Fo.A01 = current;
                            c0937Fo.A08.clear();
                            c0937Fo.A06.clear();
                            c0937Fo.A07.clear();
                        } else if (pageComposition != null) {
                            dataFieldLength = pageComposition.A02;
                            segmentType = current.A02;
                            if (dataFieldLength != segmentType) {
                                c0937Fo.A01 = current;
                            }
                        }
                    }
                }
                break;
            case 17:
                C0933Fk c0933Fk = c0937Fo.A01;
                int segmentType7 = c0937Fo.A03;
                if (iA05 == segmentType7 && c0933Fk != null) {
                    C0935Fm regionComposition = A08(c0979Hg, pageId);
                    int segmentType8 = c0933Fk.A00;
                    if (segmentType8 == 0) {
                        SparseArray<C0935Fm> sparseArray = c0937Fo.A08;
                        int segmentType9 = regionComposition.A03;
                        regionComposition.A00(sparseArray.get(segmentType9));
                    }
                    SparseArray<C0935Fm> sparseArray2 = c0937Fo.A08;
                    String[] strArr2 = A08;
                    String str = strArr2[3];
                    String str2 = strArr2[4];
                    int dataFieldLength4 = str.length();
                    int segmentType10 = str2.length();
                    if (dataFieldLength4 == segmentType10) {
                        throw new RuntimeException();
                    }
                    A08[6] = "mahKYWCII7kQ";
                    int segmentType11 = regionComposition.A03;
                    sparseArray2.put(segmentType11, regionComposition);
                }
                break;
            case 18:
                int segmentType12 = c0937Fo.A03;
                if (iA05 == segmentType12) {
                    C0930Fh c0930FhA04 = A04(c0979Hg, pageId);
                    SparseArray<C0930Fh> sparseArray3 = c0937Fo.A06;
                    int segmentType13 = c0930FhA04.A00;
                    sparseArray3.put(segmentType13, c0930FhA04);
                } else {
                    int segmentType14 = c0937Fo.A02;
                    if (iA05 == segmentType14) {
                        C0930Fh c0930FhA05 = A04(c0979Hg, pageId);
                        SparseArray<C0930Fh> sparseArray4 = c0937Fo.A04;
                        int segmentType15 = c0930FhA05.A00;
                        sparseArray4.put(segmentType15, c0930FhA05);
                    }
                }
                break;
            case 19:
                int segmentType16 = c0937Fo.A03;
                if (iA05 == segmentType16) {
                    C0932Fj c0932FjA06 = A06(c0979Hg);
                    SparseArray<C0932Fj> sparseArray5 = c0937Fo.A07;
                    int segmentType17 = c0932FjA06.A00;
                    sparseArray5.put(segmentType17, c0932FjA06);
                } else {
                    int segmentType18 = c0937Fo.A02;
                    if (iA05 == segmentType18) {
                        C0932Fj c0932FjA07 = A06(c0979Hg);
                        SparseArray<C0932Fj> sparseArray6 = c0937Fo.A05;
                        int segmentType19 = c0932FjA07.A00;
                        sparseArray6.put(segmentType19, c0932FjA07);
                    }
                }
                break;
            case 20:
                int segmentType20 = c0937Fo.A03;
                if (iA05 == segmentType20) {
                    c0937Fo.A00 = A05(c0979Hg);
                }
                break;
        }
        int segmentType21 = c0979Hg.A02();
        c0979Hg.A09(dataFieldLimit - segmentType21);
    }

    public static void A0D(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        byte[] clutMapTable4To8;
        byte[] clutMapTable4To9;
        int line = i3;
        C0979Hg c0979Hg = new C0979Hg(bArr);
        byte[] clutMapTable2To8 = null;
        byte[] clutMapTable2To4 = null;
        int column = i2;
        while (c0979Hg.A01() != 0) {
            switch (c0979Hg.A04(8)) {
                case 16:
                    if (i == 3) {
                        clutMapTable4To9 = clutMapTable2To4 == null ? A0A : clutMapTable2To4;
                    } else if (i == 2) {
                        clutMapTable4To9 = clutMapTable2To8 == null ? A09 : clutMapTable2To8;
                    } else {
                        clutMapTable4To9 = null;
                        if (A08[5].length() == 5) {
                            throw new RuntimeException();
                        }
                        String[] strArr = A08;
                        strArr[0] = "aCQdDxqS2bkmSWw219FL9FrVQLNlGxjh";
                        strArr[7] = "CXVqOrR1KNECyNPiemwICdwFVxmD3XsB";
                    }
                    if (A08[5].length() == 5) {
                        throw new RuntimeException();
                    }
                    A08[1] = "sxwfPuAvCy0meNXm9qprXKFgJpDmZ";
                    column = A01(c0979Hg, iArr, clutMapTable4To9, column, line, paint, canvas);
                    c0979Hg.A05();
                    break;
                    break;
                case 17:
                    if (i == 3) {
                        clutMapTable4To8 = 0 == 0 ? A0B : null;
                    } else {
                        clutMapTable4To8 = null;
                    }
                    column = A02(c0979Hg, iArr, clutMapTable4To8, column, line, paint, canvas);
                    c0979Hg.A05();
                    break;
                case 18:
                    column = A03(c0979Hg, iArr, null, column, line, paint, canvas);
                    break;
                case 32:
                    clutMapTable2To8 = A0E(4, 4, c0979Hg);
                    break;
                case 33:
                    clutMapTable2To4 = A0E(4, 8, c0979Hg);
                    break;
                case 34:
                    clutMapTable2To4 = A0E(16, 8, c0979Hg);
                    break;
                case 240:
                    line += 2;
                    column = i2;
                    break;
            }
        }
    }

    public static byte[] A0E(int i, int i2, C0979Hg c0979Hg) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) c0979Hg.A04(i2);
        }
        return bArr;
    }

    public static int[] A0F() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    public static int[] A0G() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < iArr.length; i++) {
            if (i < 8) {
                int i2 = i & 1;
                if (A08[1].length() != 29) {
                    throw new RuntimeException();
                }
                A08[6] = "OBOqbcJ5TVgi";
                int i3 = i2 != 0 ? 255 : 0;
                iArr[i] = A00(255, i3, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                int i4 = i & 1;
                int i5 = WorkQueueKt.MASK;
                int i6 = i4 != 0 ? WorkQueueKt.MASK : 0;
                int i7 = (i & 2) != 0 ? WorkQueueKt.MASK : 0;
                if ((i & 4) == 0) {
                    i5 = 0;
                }
                iArr[i] = A00(255, i6, i7, i5);
            }
        }
        return iArr;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0071  */
    /* JADX WARN: Code duplicated, block: B:53:0x00c3  */
    public static int[] A0H() {
        int i;
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (A08[5].length() != 5) {
                A08[5] = "yMmopDV0PROTT6iUygdI9MoWuRB";
                if (i2 < 8) {
                    int i3 = (i2 & 1) != 0 ? 255 : 0;
                    iArr[i2] = A00(63, i3, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) == 0 ? 0 : 255);
                } else {
                    switch (i2 & 136) {
                        case 0:
                            int i4 = (i2 & 1) != 0 ? 85 : 0;
                            int i5 = i2 & 16;
                            if (A08[6].length() != 12) {
                                A08[6] = "5kFBsD3TZCPr";
                                if (i5 != 0) {
                                    i = 170;
                                } else {
                                    i = 0;
                                }
                            } else {
                                A08[5] = "e5fZNa";
                                if (i5 != 0) {
                                    i = 170;
                                } else {
                                    i = 0;
                                }
                            }
                            int i6 = i4 + i;
                            int i7 = ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0);
                            int i8 = ((i2 & 4) == 0 ? 0 : 85) + ((i2 & 64) == 0 ? 0 : 170);
                            String[] strArr = A08;
                            if (strArr[0].charAt(24) == strArr[7].charAt(24)) {
                                throw new RuntimeException();
                            }
                            String[] strArr2 = A08;
                            strArr2[3] = "N";
                            strArr2[4] = "KgCT6FPPbQR5Gt38AZY6Kgkq0L3q";
                            iArr[i2] = A00(255, i6, i7, i8);
                            continue;
                            break;
                        case 8:
                            int i9 = (i2 & 1) != 0 ? 85 : 0;
                            iArr[i2] = A00(WorkQueueKt.MASK, i9 + ((i2 & 16) != 0 ? 170 : 0), ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0), ((i2 & 4) == 0 ? 0 : 85) + ((i2 & 64) == 0 ? 0 : 170));
                            continue;
                        case 128:
                            int i10 = (i2 & 1) != 0 ? 43 : 0;
                            int iA00 = A00(255, i10 + WorkQueueKt.MASK + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + WorkQueueKt.MASK + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + WorkQueueKt.MASK + ((i2 & 64) == 0 ? 0 : 85));
                            String[] strArr3 = A08;
                            if (strArr3[3].length() == strArr3[4].length()) {
                                throw new RuntimeException();
                            }
                            String[] strArr4 = A08;
                            strArr4[0] = "aybqBWwtY0DT9MvKUrSszXiCsWNuAoGt";
                            strArr4[7] = "n5OaccyWXsmPzT0g59BcvtkeBPKtga8v";
                            iArr[i2] = iA00;
                            continue;
                            break;
                        case 136:
                            int i11 = ((i2 & 1) != 0 ? 43 : 0) + ((i2 & 16) != 0 ? 85 : 0);
                            int i12 = ((i2 & 2) != 0 ? 43 : 0) + ((i2 & 32) != 0 ? 85 : 0);
                            if (A08[2].length() != 20) {
                                A08[5] = "gSUXJnsqi";
                                int i13 = (i2 & 4) == 0 ? 0 : 43;
                                int i14 = i2 & 64;
                                if (A08[2].length() != 20) {
                                    String[] strArr5 = A08;
                                    strArr5[0] = "whmrMiK0u12tANJBqhusYeSDK3rkmMFj";
                                    strArr5[7] = "x13RVeSrZB6JEJa4BQjiEaMCBMX5qcSw";
                                    iArr[i2] = A00(255, i11, i12, i13 + (i14 == 0 ? 0 : 85));
                                }
                            }
                            break;
                        default:
                            continue;
                    }
                }
            }
            throw new RuntimeException();
        }
        return iArr;
    }

    public final void A0J() {
        this.A06.A00();
    }
}
