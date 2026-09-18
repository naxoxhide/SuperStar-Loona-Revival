package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ba, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1547ba {
    public InterfaceC1550bd A00;
    public InterfaceC1548bb A01;
    public C1535bO A02;
    public final InterfaceC1557bk A04;
    public final InterfaceC1549bc A05;
    public final LinkedHashMap<Integer, Runnable> A06 = new LinkedHashMap<>();
    public final InterfaceC1548bb A03 = new C0946Fx(this);

    public C1547ba(InterfaceC1557bk interfaceC1557bk, InterfaceC1549bc interfaceC1549bc) {
        this.A04 = interfaceC1557bk;
        this.A05 = interfaceC1549bc;
    }

    public static C1547ba A01() {
        return new C1547ba(new G1(), null);
    }

    private void A03(AbstractC1551be abstractC1551be, InterfaceC1555bi interfaceC1555bi, InterfaceC0945Fw interfaceC0945Fw) {
        C1535bO c1535bOA00 = C1535bO.A00(abstractC1551be, interfaceC1555bi, interfaceC0945Fw);
        this.A02 = c1535bOA00;
        InterfaceC1550bd interfaceC1550bd = this.A00;
        if (interfaceC1550bd != null) {
            c1535bOA00.A03(interfaceC1550bd);
        }
        this.A02.A04(this.A03);
    }

    public final void A04(View view) {
        C1535bO c1535bO = this.A02;
        if (c1535bO != null && view != null) {
            c1535bO.A01(view);
        }
    }

    public final void A05(View view, C1553bg c1553bg) {
        C1535bO c1535bO = this.A02;
        if (c1535bO != null && view != null && c1553bg != null) {
            c1535bO.A02(view, c1553bg);
        }
    }

    public final void A06(AbstractC1551be abstractC1551be, View view) {
        if (abstractC1551be != null && view != null) {
            C0947Fy c0947Fy = new C0947Fy(view, this.A04);
            final InterfaceC1549bc interfaceC1549bc = this.A05;
            A03(abstractC1551be, c0947Fy, new InterfaceC0945Fw(interfaceC1549bc) { // from class: com.facebook.ads.redexgen.X.3f
                public static byte[] A09;
                public static String[] A0A = {"okBgSYhQGmV0QyU32992deBLR6XrdaZQ", "E", "ZDdZ5rthnspWTI3gzSJHBR7aYCyAxUsq", "EsXM2pc2I6J3hYC1V9OQRTCtALa8wmqB", "DKA0ex9266tXplnV6PUb8C0vdYHWYjG4", "tBgdKBpc94v7LWesC8aTGIaQqZdJYwjy", "iZindrm9v6DBRttH7DMzAa7", "d9237vu9oQoOcpvZwewcjFUDz74P7MIA"};
                public static final String A0B;
                public long A00;
                public InterfaceC1550bd A01;
                public final InterfaceC1549bc A02;
                public final Map<String, C1539bS> A06 = new HashMap();
                public final C1540bT A04 = new C1540bT();
                public final C1540bT A03 = new C1540bT();
                public final List<Rect> A05 = new ArrayList(1);
                public final boolean A08 = false;
                public final boolean A07 = false;

                public static String A02(int i, int i2, int i3) {
                    byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i, i + i2);
                    for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                        bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 91);
                    }
                    return new String(bArrCopyOfRange);
                }

                public static void A03() {
                    A09 = new byte[]{41, 21, 20, 14, 93, 11, 20, 24, 10, 13, 18, 20, 19, 9, 93, 21, 28, 14, 93, 19, 18, 9, 93, 31, 24, 24, 19, 93, 16, 24, 28, 14, 8, 15, 24, 25, 93, 18, 15, 93, 20, 14, 93, 28, 93, 26, 15, 18, 8, 13, 93, 10, 21, 20, 30, 21, 93, 10, 20, 17, 17, 93, 19, 24, 11, 24, 15, 93, 15, 24, 9, 8, 15, 19, 93, 28, 93, 16, 24, 28, 14, 8, 15, 24, 16, 24, 19, 9, 93, 14, 20, 19, 30, 24, 93, 20, 9, 90, 14, 93, 16, 28, 25, 24, 93, 8, 13, 93, 18, 27, 93, 14, 8, 31, 11, 20, 24, 10, 14, 93, 9, 21, 28, 9, 93, 30, 18, 8, 17, 25, 93, 31, 24, 93, 18, 27, 27, 14, 30, 15, 24, 24, 19, 118, 125, 111, 75, 123, 121, 118, 63, 36, Base64.padSymbol, Base64.padSymbol, 113, 39, 56, 52, 38, 113, 33, 35, 62, 33, 52, 35, 37, 40, 113, 55, 62, 35, 113, 35, 52, 60, 62, 39, 52, 53, 113, 56, 37, 52, 60, 113, 125, 97, 104, 122, 92, 107, 126, 97, 124, 122};
                }

                static {
                    A03();
                    A0B = C06503f.class.getSimpleName();
                }

                {
                    this.A02 = interfaceC1549bc;
                }

                public static Rect A00(C1539bS c1539bS) {
                    if (c1539bS != null && c1539bS.A02.top != Integer.MIN_VALUE && c1539bS.A02.left != Integer.MIN_VALUE) {
                        Rect rect = c1539bS.A02;
                        String[] strArr = A0A;
                        if (strArr[1].length() == strArr[6].length()) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A0A;
                        strArr2[1] = "p";
                        strArr2[6] = "Kr6mbDoiLKwWSgNyXDF2oJW";
                        if (rect.right != Integer.MIN_VALUE && c1539bS.A02.bottom != Integer.MIN_VALUE) {
                            return c1539bS.A02;
                        }
                    }
                    throw new IllegalStateException(A02(0, 143, 38));
                }

                private C1539bS A01(C1553bg c1553bg, Rect rect, Rect rect2) {
                    C1539bS c1539bSA03 = this.A06.get(c1553bg.A04);
                    if (this.A04.A06(c1553bg)) {
                        if (c1539bSA03 != null) {
                            c1539bSA03.A01 = EnumC1543bW.A04;
                        } else {
                            c1539bSA03 = C1539bS.A03(this.A00);
                            this.A06.put(c1553bg.A04, c1539bSA03);
                        }
                    }
                    c1539bSA03.A02.set(rect2);
                    c1539bSA03.A03.add(new Rect(rect));
                    return c1539bSA03;
                }

                private void A04(C1540bT c1540bT) {
                    for (C1553bg c1553bg : c1540bT.A01()) {
                        C1539bS c1539bS = this.A06.get(c1553bg.A04);
                        if (c1539bS == null) {
                            if (this.A02 != null) {
                                String str = A02(150, 36, 10) + c1553bg.A04;
                                throw new NullPointerException(A02(186, 10, 85));
                            }
                        } else {
                            c1539bS.A01 = EnumC1543bW.A03;
                            c1539bS.A03.clear();
                            c1553bg.A03(this);
                            if (this.A08) {
                                Map<String, C1539bS> map = this.A06;
                                String[] strArr = A0A;
                                if (strArr[0].charAt(8) == strArr[2].charAt(8)) {
                                    throw new RuntimeException();
                                }
                                String[] strArr2 = A0A;
                                strArr2[0] = "dCpYPRypiVOHB4OlkAqBqk8EySqTLE1k";
                                strArr2[2] = "r3sjB169HJX8vOmMpko73ANLsggTEmi2";
                                map.remove(c1539bS);
                            } else {
                                continue;
                            }
                        }
                    }
                }

                private void A05(C1540bT c1540bT) {
                    Iterator it = c1540bT.A00().iterator();
                    while (it.hasNext()) {
                        ((C1553bg) it.next()).A03(this);
                    }
                }

                @Override // com.facebook.ads.redexgen.X.InterfaceC0945Fw
                public final void A3R(C1553bg c1553bg, Rect rect, Rect rect2) {
                    A01(c1553bg, rect, rect2);
                    C1553bg c1553bg2 = c1553bg.A01;
                    C1553bg parentViewpointData = C1553bg.A08;
                    if (c1553bg2 == parentViewpointData) {
                        return;
                    }
                    boolean zA06 = this.A03.A06(c1553bg2);
                    C1539bS parentViewProperties = this.A06.get(c1553bg2.A04);
                    if (zA06) {
                        if (parentViewProperties == null) {
                            parentViewProperties = C1539bS.A03(this.A00);
                            parentViewProperties.A02.set(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
                            this.A06.put(c1553bg2.A04, parentViewProperties);
                        } else {
                            parentViewProperties.A03.clear();
                            if (!this.A07 || c1553bg2.A04()) {
                                parentViewProperties.A01 = EnumC1543bW.A04;
                            }
                        }
                    }
                    parentViewProperties.A03.add(new Rect(rect));
                }

                @Override // com.facebook.ads.redexgen.X.InterfaceC0945Fw
                public final void A3x(long j, List<Rect> viewportRects) {
                    this.A00 = j;
                    this.A05.clear();
                    Iterator<Rect> it = viewportRects.iterator();
                    while (it.hasNext()) {
                        this.A05.add(new Rect(it.next()));
                    }
                    Iterator it2 = this.A04.A01().iterator();
                    while (it2.hasNext()) {
                        this.A06.remove(((C1553bg) it2.next()).A04);
                    }
                    Iterator it3 = this.A03.A01().iterator();
                    while (it3.hasNext()) {
                        this.A06.remove(((C1553bg) it3.next()).A04);
                    }
                    Iterator<C1539bS> it4 = this.A06.values().iterator();
                    while (it4.hasNext()) {
                        it4.next().A03.clear();
                    }
                    this.A04.A04();
                    this.A03.A04();
                }

                @Override // com.facebook.ads.redexgen.X.InterfaceC0945Fw
                public final void A5U() {
                    A05(this.A04);
                    A04(this.A04);
                    A05(this.A03);
                    A04(this.A03);
                    if (this.A01 != null) {
                        new C1538bR(toString(), this, this.A05, this.A04.A00(), this.A03.A00());
                        throw new NullPointerException(A02(143, 7, 67));
                    }
                }

                @Override // com.facebook.ads.redexgen.X.InterfaceC1542bV
                public final void A71(C1553bg c1553bg, Rect rect) {
                    rect.setEmpty();
                    Iterator it = this.A06.get(c1553bg.A04).A03.iterator();
                    while (it.hasNext()) {
                        rect.union((Rect) it.next());
                    }
                }

                @Override // com.facebook.ads.redexgen.X.InterfaceC1542bV
                public final EnumC1543bW A8A(C1553bg c1553bg) {
                    return this.A06.get(c1553bg.A04).A01;
                }

                @Override // com.facebook.ads.redexgen.X.InterfaceC1542bV
                public final void A8C(Rect rect) {
                    rect.setEmpty();
                    Iterator<Rect> it = this.A05.iterator();
                    while (it.hasNext()) {
                        rect.union(it.next());
                    }
                }

                @Override // com.facebook.ads.redexgen.X.InterfaceC1542bV
                public final float A8D(C1553bg c1553bg) {
                    C1539bS c1539bS = this.A06.get(c1553bg.A04);
                    if (c1539bS != null) {
                        Rect rectA00 = A00(c1539bS);
                        int iHeight = rectA00.height() * rectA00.width();
                        int totalVisibleArea = 0;
                        for (Rect rect : c1539bS.A03) {
                            totalVisibleArea += rect.height() * rect.width();
                        }
                        return totalVisibleArea / iHeight;
                    }
                    return 0.0f;
                }

                @Override // com.facebook.ads.redexgen.X.InterfaceC0945Fw
                public final void AFW(InterfaceC1550bd interfaceC1550bd) {
                    this.A01 = interfaceC1550bd;
                }
            });
        }
    }
}
