package com.applovin.exoplayer2.i.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes.dex */
final class b {
    private static final byte[] Qm = {0, 7, 8, 15};
    private static final byte[] Qn = {0, 119, -120, -1};
    private static final byte[] Qo = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private Bitmap NZ;
    private final Paint Qp;
    private final Paint Qq;
    private final Canvas Qr;
    private final C0102b Qs;
    private final a Qt;
    private final h Qu;

    private static int c(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    public b(int i, int i2) {
        Paint paint = new Paint();
        this.Qp = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.Qq = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.Qr = new Canvas();
        this.Qs = new C0102b(719, 575, 0, 719, 0, 575);
        this.Qt = new a(0, mB(), mC(), mD());
        this.Qu = new h(i, i2);
    }

    public void Y() {
        this.Qu.Y();
    }

    public List<com.applovin.exoplayer2.i.a> h(byte[] bArr, int i) {
        C0102b c0102b;
        int i2;
        x xVar = new x(bArr, i);
        while (xVar.pf() >= 48 && xVar.bQ(8) == 15) {
            a(xVar, this.Qu);
        }
        d dVar = this.Qu.Rc;
        if (dVar == null) {
            return Collections.emptyList();
        }
        if (this.Qu.Rb != null) {
            c0102b = this.Qu.Rb;
        } else {
            c0102b = this.Qs;
        }
        if (this.NZ == null || c0102b.dE + 1 != this.NZ.getWidth() || c0102b.height + 1 != this.NZ.getHeight()) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(c0102b.dE + 1, c0102b.height + 1, Bitmap.Config.ARGB_8888);
            this.NZ = bitmapCreateBitmap;
            this.Qr.setBitmap(bitmapCreateBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray = dVar.QG;
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            this.Qr.save();
            e eVarValueAt = sparseArray.valueAt(i3);
            f fVar = this.Qu.QG.get(sparseArray.keyAt(i3));
            int i4 = eVarValueAt.QH + c0102b.Qy;
            int i5 = eVarValueAt.QI + c0102b.QA;
            this.Qr.clipRect(i4, i5, Math.min(fVar.dE + i4, c0102b.Qz), Math.min(fVar.height + i5, c0102b.QB));
            a aVar = this.Qu.QX.get(fVar.QL);
            if (aVar == null && (aVar = this.Qu.QZ.get(fVar.QL)) == null) {
                aVar = this.Qt;
            }
            int i6 = 0;
            for (SparseArray<g> sparseArray2 = fVar.QP; i6 < sparseArray2.size(); sparseArray2 = sparseArray2) {
                int iKeyAt = sparseArray2.keyAt(i6);
                g gVarValueAt = sparseArray2.valueAt(i6);
                c cVar = this.Qu.QY.get(iKeyAt);
                c cVar2 = cVar == null ? this.Qu.Ra.get(iKeyAt) : cVar;
                if (cVar2 != null) {
                    a(cVar2, aVar, fVar.Ju, gVarValueAt.QR + i4, i5 + gVarValueAt.QS, cVar2.QC ? null : this.Qp, this.Qr);
                }
                i6++;
            }
            if (fVar.QJ) {
                if (fVar.Ju == 3) {
                    i2 = aVar.Qx[fVar.QM];
                } else if (fVar.Ju == 2) {
                    i2 = aVar.Qw[fVar.QN];
                } else {
                    i2 = aVar.Qv[fVar.QO];
                }
                this.Qq.setColor(i2);
                this.Qr.drawRect(i4, i5, fVar.dE + i4, fVar.height + i5, this.Qq);
            }
            arrayList.add(new com.applovin.exoplayer2.i.a.C0098a().a(Bitmap.createBitmap(this.NZ, i4, i5, fVar.dE, fVar.height)).o(i4 / c0102b.dE).eg(0).b(i5 / c0102b.height, 0).ef(0).p(fVar.dE / c0102b.dE).q(fVar.height / c0102b.height).lU());
            this.Qr.drawColor(0, PorterDuff.Mode.CLEAR);
            this.Qr.restore();
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static void a(x xVar, h hVar) {
        f fVar;
        int iBQ = xVar.bQ(8);
        int iBQ2 = xVar.bQ(16);
        int iBQ3 = xVar.bQ(16);
        int iPg = xVar.pg() + iBQ3;
        if (iBQ3 * 8 > xVar.pf()) {
            q.h("DvbParser", "Data field length exceeds limit");
            xVar.bR(xVar.pf());
            return;
        }
        switch (iBQ) {
            case 16:
                if (iBQ2 == hVar.QV) {
                    d dVar = hVar.Rc;
                    d dVarC = c(xVar, iBQ3);
                    if (dVarC.Z != 0) {
                        hVar.Rc = dVarC;
                        hVar.QG.clear();
                        hVar.QX.clear();
                        hVar.QY.clear();
                    } else if (dVar != null && dVar.mH != dVarC.mH) {
                        hVar.Rc = dVarC;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.Rc;
                if (iBQ2 == hVar.QV && dVar2 != null) {
                    f fVarD = d(xVar, iBQ3);
                    if (dVar2.Z == 0 && (fVar = hVar.QG.get(fVarD.zD)) != null) {
                        fVarD.a(fVar);
                    }
                    hVar.QG.put(fVarD.zD, fVarD);
                }
                break;
            case 18:
                if (iBQ2 == hVar.QV) {
                    a aVarE = e(xVar, iBQ3);
                    hVar.QX.put(aVarE.zD, aVarE);
                } else if (iBQ2 == hVar.QW) {
                    a aVarE2 = e(xVar, iBQ3);
                    hVar.QZ.put(aVarE2.zD, aVarE2);
                }
                break;
            case 19:
                if (iBQ2 == hVar.QV) {
                    c cVarM = m(xVar);
                    hVar.QY.put(cVarM.zD, cVarM);
                } else if (iBQ2 == hVar.QW) {
                    c cVarM2 = m(xVar);
                    hVar.Ra.put(cVarM2.zD, cVarM2);
                }
                break;
            case 20:
                if (iBQ2 == hVar.QV) {
                    hVar.Rb = l(xVar);
                }
                break;
        }
        xVar.fz(iPg - xVar.pg());
    }

    private static C0102b l(x xVar) {
        int i;
        int i2;
        int i3;
        int iBQ;
        xVar.bR(4);
        boolean zIk = xVar.ik();
        xVar.bR(3);
        int iBQ2 = xVar.bQ(16);
        int iBQ3 = xVar.bQ(16);
        if (zIk) {
            int iBQ4 = xVar.bQ(16);
            int iBQ5 = xVar.bQ(16);
            int iBQ6 = xVar.bQ(16);
            iBQ = xVar.bQ(16);
            i3 = iBQ5;
            i2 = iBQ6;
            i = iBQ4;
        } else {
            i = 0;
            i2 = 0;
            i3 = iBQ2;
            iBQ = iBQ3;
        }
        return new C0102b(iBQ2, iBQ3, i, i3, i2, iBQ);
    }

    private static d c(x xVar, int i) {
        int iBQ = xVar.bQ(8);
        int iBQ2 = xVar.bQ(4);
        int iBQ3 = xVar.bQ(2);
        xVar.bR(2);
        int i2 = i - 2;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int iBQ4 = xVar.bQ(8);
            xVar.bR(8);
            i2 -= 6;
            sparseArray.put(iBQ4, new e(xVar.bQ(16), xVar.bQ(16)));
        }
        return new d(iBQ, iBQ2, iBQ3, sparseArray);
    }

    private static f d(x xVar, int i) {
        int iBQ;
        int iBQ2;
        int iBQ3 = xVar.bQ(8);
        xVar.bR(4);
        boolean zIk = xVar.ik();
        xVar.bR(3);
        int i2 = 16;
        int iBQ4 = xVar.bQ(16);
        int iBQ5 = xVar.bQ(16);
        int iBQ6 = xVar.bQ(3);
        int iBQ7 = xVar.bQ(3);
        int i3 = 2;
        xVar.bR(2);
        int iBQ8 = xVar.bQ(8);
        int iBQ9 = xVar.bQ(8);
        int iBQ10 = xVar.bQ(4);
        int iBQ11 = xVar.bQ(2);
        xVar.bR(2);
        int i4 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i4 > 0) {
            int iBQ12 = xVar.bQ(i2);
            int iBQ13 = xVar.bQ(i3);
            int iBQ14 = xVar.bQ(i3);
            int iBQ15 = xVar.bQ(12);
            int i5 = iBQ11;
            xVar.bR(4);
            int iBQ16 = xVar.bQ(12);
            i4 -= 6;
            if (iBQ13 == 1 || iBQ13 == 2) {
                i4 -= 2;
                iBQ = xVar.bQ(8);
                iBQ2 = xVar.bQ(8);
            } else {
                iBQ = 0;
                iBQ2 = 0;
            }
            sparseArray.put(iBQ12, new g(iBQ13, iBQ14, iBQ15, iBQ16, iBQ, iBQ2));
            iBQ11 = i5;
            i3 = 2;
            i2 = 16;
        }
        return new f(iBQ3, zIk, iBQ4, iBQ5, iBQ6, iBQ7, iBQ8, iBQ9, iBQ10, iBQ11, sparseArray);
    }

    private static a e(x xVar, int i) {
        int[] iArr;
        int iBQ;
        int i2;
        int iBQ2;
        int iBQ3;
        int iBQ4;
        int i3 = 8;
        int iBQ5 = xVar.bQ(8);
        xVar.bR(8);
        int i4 = 2;
        int i5 = i - 2;
        int[] iArrMB = mB();
        int[] iArrMC = mC();
        int[] iArrMD = mD();
        while (i5 > 0) {
            int iBQ6 = xVar.bQ(i3);
            int iBQ7 = xVar.bQ(i3);
            int i6 = i5 - 2;
            if ((iBQ7 & 128) != 0) {
                iArr = iArrMB;
            } else {
                iArr = (iBQ7 & 64) != 0 ? iArrMC : iArrMD;
            }
            if ((iBQ7 & 1) != 0) {
                iBQ3 = xVar.bQ(i3);
                iBQ4 = xVar.bQ(i3);
                iBQ = xVar.bQ(i3);
                iBQ2 = xVar.bQ(i3);
                i2 = i6 - 4;
            } else {
                int iBQ8 = xVar.bQ(6) << i4;
                int iBQ9 = xVar.bQ(4) << 4;
                iBQ = xVar.bQ(4) << 4;
                i2 = i6 - 2;
                iBQ2 = xVar.bQ(i4) << 6;
                iBQ3 = iBQ8;
                iBQ4 = iBQ9;
            }
            if (iBQ3 == 0) {
                iBQ2 = 255;
                iBQ4 = 0;
                iBQ = 0;
            }
            double d2 = iBQ3;
            double d3 = iBQ4 - 128;
            double d4 = iBQ - 128;
            iArr[iBQ6] = c((byte) (255 - (iBQ2 & 255)), ai.k((int) (d2 + (1.402d * d3)), 0, 255), ai.k((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, 255), ai.k((int) (d2 + (d4 * 1.772d)), 0, 255));
            i5 = i2;
            iBQ5 = iBQ5;
            i3 = 8;
            i4 = 2;
        }
        return new a(iBQ5, iArrMB, iArrMC, iArrMD);
    }

    private static c m(x xVar) {
        int iBQ = xVar.bQ(16);
        xVar.bR(4);
        int iBQ2 = xVar.bQ(2);
        boolean zIk = xVar.ik();
        xVar.bR(1);
        byte[] bArr = ai.ada;
        byte[] bArr2 = ai.ada;
        if (iBQ2 == 1) {
            xVar.bR(xVar.bQ(8) * 16);
        } else if (iBQ2 == 0) {
            int iBQ3 = xVar.bQ(16);
            int iBQ4 = xVar.bQ(16);
            if (iBQ3 > 0) {
                bArr = new byte[iBQ3];
                xVar.r(bArr, 0, iBQ3);
            }
            if (iBQ4 > 0) {
                bArr2 = new byte[iBQ4];
                xVar.r(bArr2, 0, iBQ4);
            } else {
                bArr2 = bArr;
            }
        }
        return new c(iBQ, zIk, bArr, bArr2);
    }

    private static int[] mB() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int[] mC() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            if (i < 8) {
                iArr[i] = c(255, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                int i2 = i & 1;
                int i3 = WorkQueueKt.MASK;
                int i4 = i2 != 0 ? 127 : 0;
                int i5 = (i & 2) != 0 ? 127 : 0;
                if ((i & 4) == 0) {
                    i3 = 0;
                }
                iArr[i] = c(255, i4, i5, i3);
            }
        }
        return iArr;
    }

    private static int[] mD() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < 256; i++) {
            if (i < 8) {
                iArr[i] = c(63, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) == 0 ? 0 : 255);
            } else {
                int i2 = i & 136;
                if (i2 == 0) {
                    iArr[i] = c(255, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 8) {
                    iArr[i] = c(WorkQueueKt.MASK, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 128) {
                    iArr[i] = c(255, ((i & 1) != 0 ? 43 : 0) + WorkQueueKt.MASK + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + WorkQueueKt.MASK + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + WorkQueueKt.MASK + ((i & 64) == 0 ? 0 : 85));
                } else if (i2 == 136) {
                    iArr[i] = c(255, ((i & 1) != 0 ? 43 : 0) + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + ((i & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    private static void a(c cVar, a aVar, int i, int i2, int i3, Paint paint, Canvas canvas) {
        int[] iArr;
        if (i == 3) {
            iArr = aVar.Qx;
        } else if (i == 2) {
            iArr = aVar.Qw;
        } else {
            iArr = aVar.Qv;
        }
        int[] iArr2 = iArr;
        a(cVar.QD, iArr2, i, i2, i3, paint, canvas);
        a(cVar.QE, iArr2, i, i2, i3 + 1, paint, canvas);
    }

    private static void a(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        x xVar = new x(bArr);
        int iA = i2;
        int i4 = i3;
        byte[] bArrA = null;
        byte[] bArrA2 = null;
        byte[] bArrA3 = null;
        while (xVar.pf() != 0) {
            int iBQ = xVar.bQ(8);
            if (iBQ != 240) {
                switch (iBQ) {
                    case 16:
                        if (i == 3) {
                            bArr3 = bArrA == null ? Qn : bArrA;
                        } else {
                            if (i == 2) {
                                bArr3 = bArrA3 == null ? Qm : bArrA3;
                            } else {
                                bArr2 = null;
                            }
                            iA = a(xVar, iArr, bArr2, iA, i4, paint, canvas);
                            xVar.pi();
                        }
                        bArr2 = bArr3;
                        iA = a(xVar, iArr, bArr2, iA, i4, paint, canvas);
                        xVar.pi();
                        break;
                    case 17:
                        if (i == 3) {
                            bArr4 = bArrA2 == null ? Qo : bArrA2;
                        } else {
                            bArr4 = null;
                        }
                        iA = b(xVar, iArr, bArr4, iA, i4, paint, canvas);
                        xVar.pi();
                        break;
                    case 18:
                        iA = c(xVar, iArr, null, iA, i4, paint, canvas);
                        break;
                    default:
                        switch (iBQ) {
                            case 32:
                                bArrA3 = a(4, 4, xVar);
                                break;
                            case 33:
                                bArrA = a(4, 8, xVar);
                                break;
                            case 34:
                                bArrA2 = a(16, 8, xVar);
                                break;
                        }
                        break;
                }
            } else {
                i4 += 2;
                iA = i2;
            }
        }
    }

    private static int a(x xVar, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        int i3;
        int iBQ;
        int iBQ2;
        int i4 = i;
        boolean z = false;
        while (true) {
            int iBQ3 = xVar.bQ(2);
            if (iBQ3 != 0) {
                z = z;
                i3 = 1;
            } else {
                if (xVar.ik()) {
                    iBQ = xVar.bQ(3) + 3;
                    iBQ2 = xVar.bQ(2);
                } else {
                    if (xVar.ik()) {
                        i3 = 1;
                    } else {
                        int iBQ4 = xVar.bQ(2);
                        if (iBQ4 == 0) {
                            z = true;
                        } else if (iBQ4 == 1) {
                            i3 = 2;
                        } else if (iBQ4 == 2) {
                            iBQ = xVar.bQ(4) + 12;
                            iBQ2 = xVar.bQ(2);
                        } else if (iBQ4 != 3) {
                            z = z;
                        } else {
                            iBQ = xVar.bQ(8) + 29;
                            iBQ2 = xVar.bQ(2);
                        }
                        iBQ3 = 0;
                        i3 = 0;
                    }
                    iBQ3 = 0;
                }
                z = z;
                i3 = iBQ;
                iBQ3 = iBQ2;
            }
            if (i3 != 0 && paint != null) {
                if (bArr != null) {
                    iBQ3 = bArr[iBQ3];
                }
                paint.setColor(iArr[iBQ3]);
                canvas.drawRect(i4, i2, i4 + i3, i2 + 1, paint);
            }
            i4 += i3;
            if (z) {
                return i4;
            }
            z = z;
        }
    }

    private static int b(x xVar, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        int i3;
        int iBQ;
        int i4 = i;
        boolean z = false;
        while (true) {
            int iBQ2 = xVar.bQ(4);
            int i5 = 2;
            if (iBQ2 != 0) {
                z = z;
                i3 = 1;
            } else if (!xVar.ik()) {
                int iBQ3 = xVar.bQ(3);
                if (iBQ3 != 0) {
                    i5 = iBQ3 + 2;
                    i3 = i5;
                    iBQ2 = 0;
                } else {
                    z = true;
                    iBQ2 = 0;
                    i3 = 0;
                }
            } else {
                if (!xVar.ik()) {
                    iBQ = xVar.bQ(2) + 4;
                    iBQ2 = xVar.bQ(4);
                } else {
                    int iBQ4 = xVar.bQ(2);
                    if (iBQ4 != 0) {
                        if (iBQ4 != 1) {
                            if (iBQ4 == 2) {
                                iBQ = xVar.bQ(4) + 9;
                                iBQ2 = xVar.bQ(4);
                            } else if (iBQ4 != 3) {
                                z = z;
                                iBQ2 = 0;
                                i3 = 0;
                            } else {
                                iBQ = xVar.bQ(8) + 25;
                                iBQ2 = xVar.bQ(4);
                            }
                        }
                        i3 = i5;
                    } else {
                        i3 = 1;
                    }
                    iBQ2 = 0;
                }
                z = z;
                i3 = iBQ;
            }
            if (i3 != 0 && paint != null) {
                if (bArr != null) {
                    iBQ2 = bArr[iBQ2];
                }
                paint.setColor(iArr[iBQ2]);
                canvas.drawRect(i4, i2, i4 + i3, i2 + 1, paint);
            }
            i4 += i3;
            if (z) {
                return i4;
            }
            z = z;
        }
    }

    private static int c(x xVar, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        boolean z;
        int iBQ;
        int i3 = i;
        boolean z2 = false;
        while (true) {
            int iBQ2 = xVar.bQ(8);
            if (iBQ2 != 0) {
                z = z2;
                iBQ = 1;
            } else if (!xVar.ik()) {
                int iBQ3 = xVar.bQ(7);
                if (iBQ3 != 0) {
                    z = z2;
                    iBQ = iBQ3;
                    iBQ2 = 0;
                } else {
                    z = true;
                    iBQ2 = 0;
                    iBQ = 0;
                }
            } else {
                z = z2;
                iBQ = xVar.bQ(7);
                iBQ2 = xVar.bQ(8);
            }
            if (iBQ != 0 && paint != null) {
                if (bArr != null) {
                    iBQ2 = bArr[iBQ2];
                }
                paint.setColor(iArr[iBQ2]);
                canvas.drawRect(i3, i2, i3 + iBQ, i2 + 1, paint);
            }
            i3 += iBQ;
            if (z) {
                return i3;
            }
            z2 = z;
        }
    }

    private static byte[] a(int i, int i2, x xVar) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) xVar.bQ(i2);
        }
        return bArr;
    }

    private static final class h {
        public final int QV;
        public final int QW;
        public C0102b Rb;
        public d Rc;
        public final SparseArray<f> QG = new SparseArray<>();
        public final SparseArray<a> QX = new SparseArray<>();
        public final SparseArray<c> QY = new SparseArray<>();
        public final SparseArray<a> QZ = new SparseArray<>();
        public final SparseArray<c> Ra = new SparseArray<>();

        public h(int i, int i2) {
            this.QV = i;
            this.QW = i2;
        }

        public void Y() {
            this.QG.clear();
            this.QX.clear();
            this.QY.clear();
            this.QZ.clear();
            this.Ra.clear();
            this.Rb = null;
            this.Rc = null;
        }
    }

    /* JADX INFO: renamed from: com.applovin.exoplayer2.i.b.b$b, reason: collision with other inner class name */
    private static final class C0102b {
        public final int QA;
        public final int QB;
        public final int Qy;
        public final int Qz;
        public final int dE;
        public final int height;

        public C0102b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.dE = i;
            this.height = i2;
            this.Qy = i3;
            this.Qz = i4;
            this.QA = i5;
            this.QB = i6;
        }
    }

    private static final class d {
        public final int QF;
        public final SparseArray<e> QG;
        public final int Z;
        public final int mH;

        public d(int i, int i2, int i3, SparseArray<e> sparseArray) {
            this.QF = i;
            this.mH = i2;
            this.Z = i3;
            this.QG = sparseArray;
        }
    }

    private static final class e {
        public final int QH;
        public final int QI;

        public e(int i, int i2) {
            this.QH = i;
            this.QI = i2;
        }
    }

    private static final class f {
        public final int Ju;
        public final boolean QJ;
        public final int QK;
        public final int QL;
        public final int QM;
        public final int QN;
        public final int QO;
        public final SparseArray<g> QP;
        public final int dE;
        public final int height;
        public final int zD;

        public f(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<g> sparseArray) {
            this.zD = i;
            this.QJ = z;
            this.dE = i2;
            this.height = i3;
            this.QK = i4;
            this.Ju = i5;
            this.QL = i6;
            this.QM = i7;
            this.QN = i8;
            this.QO = i9;
            this.QP = sparseArray;
        }

        public void a(f fVar) {
            SparseArray<g> sparseArray = fVar.QP;
            for (int i = 0; i < sparseArray.size(); i++) {
                this.QP.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
            }
        }
    }

    private static final class g {
        public final int QQ;
        public final int QR;
        public final int QS;
        public final int QT;
        public final int QU;
        public final int bs;

        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.bs = i;
            this.QQ = i2;
            this.QR = i3;
            this.QS = i4;
            this.QT = i5;
            this.QU = i6;
        }
    }

    private static final class a {
        public final int[] Qv;
        public final int[] Qw;
        public final int[] Qx;
        public final int zD;

        public a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.zD = i;
            this.Qv = iArr;
            this.Qw = iArr2;
            this.Qx = iArr3;
        }
    }

    private static final class c {
        public final boolean QC;
        public final byte[] QD;
        public final byte[] QE;
        public final int zD;

        public c(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.zD = i;
            this.QC = z;
            this.QD = bArr;
            this.QE = bArr2;
        }
    }
}
