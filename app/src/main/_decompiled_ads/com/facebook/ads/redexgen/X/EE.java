package com.facebook.ads.redexgen.X;

import android.graphics.PointF;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EE extends AbstractC1428Yw {
    public static String[] A02 = {"C44Ajl3kvJruV1G0pt7gVRuztfjSJyFq", "J5x5lFquh7whloqA7FngbvBzLsCb", "NWBvU5bW0Pue", "3", "BTAVkHunqM91yRRN2KcoYuZCergWfboL", "2NY5ANPTvwBPWrnTgdotgLNYCmp8", "bg7eF9CjngMlwdFplTojabi", "lLeEucKPPYu6Z0yxrpg2o1MG4v3W39r2"};
    public C4M A00;
    public C4M A01;

    private int A00(AbstractC06724c abstractC06724c, View view, C4M c4m) {
        int containerCenter;
        int iA0F = c4m.A0F(view) + (c4m.A0D(view) / 2);
        if (abstractC06724c.A1X()) {
            int iA0A = c4m.A0A();
            int childCenter = c4m.A0B();
            containerCenter = iA0A + (childCenter / 2);
        } else {
            int childCenter2 = c4m.A06();
            containerCenter = childCenter2 / 2;
        }
        return iA0F - containerCenter;
    }

    private View A01(AbstractC06724c abstractC06724c, C4M c4m) {
        int childCenter;
        int iA0W = abstractC06724c.A0W();
        if (iA0W == 0) {
            return null;
        }
        View view = null;
        if (abstractC06724c.A1X()) {
            int iA0A = c4m.A0A();
            int iA0B = c4m.A0B();
            if (A02[3].length() != 1) {
                throw new RuntimeException();
            }
            A02[4] = "QSrTWOl4jyYASaYHeqwJw7nAVlZS9nVf";
            int childCount = iA0B / 2;
            childCenter = iA0A + childCount;
        } else {
            int childCount2 = c4m.A06();
            childCenter = childCount2 / 2;
        }
        int i = Integer.MAX_VALUE;
        for (int absClosest = 0; absClosest < iA0W; absClosest++) {
            View viewA0t = abstractC06724c.A0t(absClosest);
            int iA0F = c4m.A0F(viewA0t);
            int childCount3 = c4m.A0D(viewA0t);
            int childCount4 = Math.abs((iA0F + (childCount3 / 2)) - childCenter);
            if (childCount4 < i) {
                i = childCount4;
                view = viewA0t;
            }
        }
        return view;
    }

    private View A02(AbstractC06724c abstractC06724c, C4M c4m) {
        int iA0W = abstractC06724c.A0W();
        if (iA0W == 0) {
            return null;
        }
        View closestChild = null;
        int childStart = Integer.MAX_VALUE;
        for (int i = 0; i < iA0W; i++) {
            View viewA0t = abstractC06724c.A0t(i);
            int childCount = c4m.A0F(viewA0t);
            if (childCount < childStart) {
                childStart = childCount;
                if (A02[3].length() != 1) {
                    throw new RuntimeException();
                }
                A02[3] = "0";
                closestChild = viewA0t;
            }
        }
        return closestChild;
    }

    private C4M A03(AbstractC06724c abstractC06724c) {
        C4M c4m = this.A00;
        if (c4m == null || c4m.A02 != abstractC06724c) {
            this.A00 = C4M.A00(abstractC06724c);
        }
        return this.A00;
    }

    private C4M A04(AbstractC06724c abstractC06724c) {
        C4M c4m = this.A01;
        if (c4m == null || c4m.A02 != abstractC06724c) {
            this.A01 = C4M.A01(abstractC06724c);
        }
        return this.A01;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x007a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0087  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.ads.redexgen.X.AbstractC1428Yw
    public final int A0C(AbstractC06724c abstractC06724c, int i, int i2) {
        int centerPosition;
        boolean reverseLayout;
        int iA0Z = abstractC06724c.A0Z();
        if (iA0Z == 0) {
            return -1;
        }
        View viewA02 = null;
        if (abstractC06724c.A25()) {
            viewA02 = A02(abstractC06724c, A04(abstractC06724c));
        } else if (abstractC06724c.A24()) {
            C4M c4mA03 = A03(abstractC06724c);
            if (A02[3].length() != 1) {
                throw new RuntimeException();
            }
            A02[4] = "gb7KateBwDTMhlVKT6fWGE4qrSBelOuo";
            viewA02 = A02(abstractC06724c, c4mA03);
        }
        if (viewA02 == null || (centerPosition = abstractC06724c.A0p(viewA02)) == -1) {
            return -1;
        }
        if (abstractC06724c.A24()) {
            reverseLayout = i > 0;
        } else {
            reverseLayout = i2 > 0;
        }
        boolean z = false;
        if (abstractC06724c instanceof InterfaceC06834o) {
            int itemCount = iA0Z - 1;
            PointF pointFA4L = ((InterfaceC06834o) abstractC06724c).A4L(itemCount);
            if (A02[3].length() != 1) {
                String[] strArr = A02;
                strArr[6] = "yuw4mNpzW34AqVSRehlxNeo";
                strArr[2] = "wkUUhZpWZ02e";
                if (pointFA4L != null) {
                    z = pointFA4L.x >= 0.0f || pointFA4L.y < 0.0f;
                }
            } else {
                A02[0] = "mSLQWLSJnMsLfeZB8hd0gvJZQvTgwPgU";
                if (pointFA4L != null) {
                    z = pointFA4L.x >= 0.0f || pointFA4L.y < 0.0f;
                }
            }
        }
        if (z) {
            return reverseLayout ? centerPosition - 1 : centerPosition;
        }
        return reverseLayout ? centerPosition + 1 : centerPosition;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1428Yw
    public final View A0D(AbstractC06724c abstractC06724c) {
        if (abstractC06724c.A25()) {
            return A01(abstractC06724c, A04(abstractC06724c));
        }
        if (abstractC06724c.A24()) {
            return A01(abstractC06724c, A03(abstractC06724c));
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1428Yw
    public final ZB A0E(AbstractC06724c abstractC06724c) {
        if (!(abstractC06724c instanceof InterfaceC06834o)) {
            return null;
        }
        return new EF(this, super.A00.getContext());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1428Yw
    public final int[] A0H(AbstractC06724c abstractC06724c, View view) {
        int[] iArr = new int[2];
        if (abstractC06724c.A24()) {
            iArr[0] = A00(abstractC06724c, view, A03(abstractC06724c));
        } else {
            iArr[0] = 0;
        }
        boolean zA25 = abstractC06724c.A25();
        String[] strArr = A02;
        if (strArr[1].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        A02[0] = "E62MX6H1I4NpqQbgkpQnwXfK7jhgOp7C";
        if (zA25) {
            iArr[1] = A00(abstractC06724c, view, A04(abstractC06724c));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }
}
