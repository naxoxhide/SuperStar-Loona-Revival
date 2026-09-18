package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4c, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC06724c {
    public static byte[] A0I;
    public static String[] A0J = {"NGwI4w5wjKKwr8vIXUEBgcadgt82Mvhc", "UEWVJJvMFTFlt7hH7ERCIJOXwkHPD", "VrTEPZjwbsMyuvHOm", "2WwBzOWctlsBfaK16SO", "SN9IkStz5", "kDHla2kaeJhueA2usdy0jZceB2KGO", "Oz8ehwpCKAgd43CqPtwSSE9zN5", "pRsAYaXPUkY6EiG3qKZOmbtQ8"};
    public int A00;
    public AnonymousClass40 A01;
    public AbstractC06844p A02;
    public ED A03;
    public C06944z A04;
    public C06944z A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public boolean A0E;
    public boolean A0F;
    public final InterfaceC06924x A0G;
    public final InterfaceC06924x A0H;

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0I, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 75);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        byte[] bArr = {-2, 33, 33, 34, 33, -35, 19, 38, 34, 52, -35, 37, 30, 48, -35, 15, 34, 32, 54, 32, 41, 34, 47, 19, 38, 34, 52, -35, 30, 48, -35, 45, 30, 47, 34, 43, 49, -35, 31, 50, 49, -35, 51, 38, 34, 52, -35, 38, 48, -35, 43, 44, 49, -35, 30, -35, 47, 34, 30, 41, -35, 32, 37, 38, 41, 33, -21, -35, 18, 43, 35, 38, 41, 49, 34, 47, 34, 33, -35, 38, 43, 33, 34, 53, -9, -35, -5, 8, 8, 9, 14, -70, 7, 9, 16, -1, -70, -5, -70, -3, 2, 3, 6, -2, -70, 0, 12, 9, 7, -70, 8, 9, 8, -57, -1, 18, 3, 13, 14, 3, 8, 1, -70, 3, 8, -2, -1, 18, -44, -80, -61, -63, -41, -63, -54, -61, -48, -76, -57, -61, -43, 9, 31, 37, -48, 29, 37, 35, 36, -48, 31, 38, 21, 34, 34, 25, 20, 21, -48, 31, 30, -4, 17, 41, 31, 37, 36, -13, 24, 25, 28, 20, 34, 21, 30, -40, 2, 21, 19, 41, 19, 28, 21, 34, -48, 34, 21, 19, 41, 19, 28, 21, 34, -36, -48, 3, 36, 17, 36, 21, -48, 35, 36, 17, 36, 21, -39, -48, -78, -56, -50, 121, -58, -50, -52, -51, 121, -56, -49, -66, -53, -53, -62, -67, -66, 121, -52, -58, -56, -56, -51, -63, -84, -68, -53, -56, -59, -59, -83, -56, -87, -56, -52, -62, -51, -62, -56, -57, 121, -51, -56, 121, -52, -50, -55, -55, -56, -53, -51, 121, -52, -58, -56, -56, -51, -63, 121, -52, -68, -53, -56, -59, -59, -62, -57, -64};
        String[] strArr = A0J;
        if (strArr[2].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        A0J[6] = "kyP20liVKsmkdJ";
        A0I = bArr;
    }

    public abstract C06734d A1s();

    static {
        A08();
    }

    public AbstractC06724c() {
        Z4 z4 = new Z4(this);
        this.A0G = z4;
        Z3 z3 = new Z3(this);
        this.A0H = z3;
        this.A04 = new C06944z(z4);
        this.A05 = new C06944z(z3);
        this.A09 = false;
        this.A07 = false;
        this.A06 = false;
        this.A0F = true;
        this.A0E = true;
    }

    public static int A00(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                int mode2 = Math.max(i2, i3);
                return Math.min(size, mode2);
            case 1073741824:
                return size;
            default:
                int mode3 = Math.max(i2, i3);
                return mode3;
        }
    }

    public static int A01(int i, int i2, int i3, int i4, boolean z) {
        int iMax = Math.max(0, i - i3);
        int i5 = 0;
        int resultMode = 0;
        if (z) {
            if (i4 >= 0) {
                i5 = i4;
                String[] strArr = A0J;
                String str = strArr[5];
                String str2 = strArr[1];
                int resultSize = str.length();
                int size = str2.length();
                if (resultSize != size) {
                    throw new RuntimeException();
                }
                A0J[6] = "ru0BYCJI67FO4KgBABZqajada";
                resultMode = 1073741824;
            } else if (i4 == -1) {
                switch (i2) {
                    case Integer.MIN_VALUE:
                    case 1073741824:
                        i5 = iMax;
                        resultMode = i2;
                        break;
                    case 0:
                        i5 = 0;
                        int resultSize2 = A0J[3].length();
                        if (resultSize2 == 28) {
                            resultMode = 0;
                        } else {
                            A0J[7] = "Nw";
                            resultMode = 0;
                        }
                        break;
                }
            } else if (i4 == -2) {
                i5 = 0;
                resultMode = 0;
            }
        } else if (i4 >= 0) {
            i5 = i4;
            resultMode = 1073741824;
        } else if (i4 == -1) {
            i5 = iMax;
            resultMode = i2;
        } else if (i4 == -2) {
            i5 = iMax;
            resultMode = (i2 == Integer.MIN_VALUE || i2 == 1073741824) ? Integer.MIN_VALUE : 0;
        }
        int size2 = View.MeasureSpec.makeMeasureSpec(i5, resultMode);
        return size2;
    }

    private final int A02(View view) {
        return ((C06734d) view.getLayoutParams()).A03.bottom;
    }

    private final int A03(View view) {
        return ((C06734d) view.getLayoutParams()).A03.left;
    }

    private final int A04(View view) {
        return ((C06734d) view.getLayoutParams()).A03.right;
    }

    private final int A05(View view) {
        return ((C06734d) view.getLayoutParams()).A03.top;
    }

    private final int A06(C06794k c06794k, C06864r c06864r) {
        return 0;
    }

    private final void A09(int i) {
        A0C(i, A0t(i));
    }

    private final void A0A(int i) {
        View child = A0t(i);
        if (child != null) {
            this.A01.A0D(i);
        }
    }

    private final void A0B(int i, int i2) {
        View view = A0t(i);
        if (view != null) {
            A09(i);
            A0E(view, i2);
            return;
        }
        throw new IllegalArgumentException(A07(85, 44, 79) + i + this.A03.toString());
    }

    private void A0C(int i, View view) {
        this.A01.A0C(i);
    }

    private final void A0D(View view) {
        this.A01.A0F(view);
    }

    private final void A0E(View view, int i) {
        A0F(view, i, (C06734d) view.getLayoutParams());
    }

    private final void A0F(View view, int i, C06734d c06734d) {
        AbstractC06894u abstractC06894uA0F = ED.A0F(view);
        if (abstractC06894uA0F.A0c()) {
            this.A03.A0t.A09(abstractC06894uA0F);
        } else {
            AnonymousClass52 anonymousClass52 = this.A03.A0t;
            String[] strArr = A0J;
            if (strArr[5].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            A0J[0] = "mtQ3Ck4zhf6OC1ISSa3eadAcnNcPftbe";
            anonymousClass52.A0A(abstractC06894uA0F);
        }
        this.A01.A0H(view, i, c06734d, abstractC06894uA0F.A0c());
    }

    private void A0G(View view, int i, boolean z) {
        AbstractC06894u abstractC06894uA0F = ED.A0F(view);
        if (z || abstractC06894uA0F.A0c()) {
            this.A03.A0t.A09(abstractC06894uA0F);
        } else {
            this.A03.A0t.A0A(abstractC06894uA0F);
        }
        C06734d c06734d = (C06734d) view.getLayoutParams();
        if (abstractC06894uA0F.A0i() || abstractC06894uA0F.A0d()) {
            if (abstractC06894uA0F.A0d()) {
                abstractC06894uA0F.A0S();
            } else {
                abstractC06894uA0F.A0O();
            }
            this.A01.A0H(view, i, view.getLayoutParams(), false);
        } else {
            ViewParent parent = view.getParent();
            ED ed = this.A03;
            String[] strArr = A0J;
            if (strArr[5].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            A0J[7] = "5ABI9jSeQ";
            if (parent == ed) {
                int iA07 = this.A01.A07(view);
                if (i == -1) {
                    i = this.A01.A05();
                }
                if (iA07 != -1) {
                    if (iA07 != i) {
                        this.A03.A06.A0B(iA07, i);
                    }
                } else {
                    throw new IllegalStateException(A07(0, 85, 114) + this.A03.indexOfChild(view) + this.A03.A1I());
                }
            } else {
                this.A01.A0I(view, i, false);
                c06734d.A01 = true;
                AbstractC06844p abstractC06844p = this.A02;
                if (abstractC06844p != null && abstractC06844p.A0F()) {
                    this.A02.A0C(view);
                }
            }
        }
        if (c06734d.A02) {
            abstractC06894uA0F.A0H.invalidate();
            c06734d.A02 = false;
        }
    }

    private final void A0H(View view, Rect rect) {
        ED.A0o(view, rect);
    }

    private void A0J(C06794k c06794k, int i, View view) {
        AbstractC06894u abstractC06894uA0F = ED.A0F(view);
        if (abstractC06894uA0F.A0h()) {
            return;
        }
        if (abstractC06894uA0F.A0b() && !abstractC06894uA0F.A0c() && !this.A03.A04.A0A()) {
            A0A(i);
            c06794k.A0b(abstractC06894uA0F);
        } else {
            A09(i);
            c06794k.A0W(view);
            this.A03.A0t.A0C(abstractC06894uA0F);
        }
    }

    private final void A0K(C06794k c06794k, C06864r c06864r, AccessibilityEvent accessibilityEvent) {
        ED ed = this.A03;
        if (ed == null || accessibilityEvent == null) {
            return;
        }
        boolean z = true;
        if (A0J[6].length() == 1) {
            throw new RuntimeException();
        }
        String[] strArr = A0J;
        strArr[2] = "A1LbQwkKC8kdEmdjm";
        strArr[4] = "mpAFCzQjd";
        if (!ed.canScrollVertically(1) && !this.A03.canScrollVertically(-1) && !this.A03.canScrollHorizontally(-1) && !this.A03.canScrollHorizontally(1)) {
            z = false;
        }
        accessibilityEvent.setScrollable(z);
        if (A0J[7].length() != 8) {
            A0J[0] = "LKoEdNrfwYhRE769hHSL4lsoF7TmWWKx";
            if (this.A03.A04 == null) {
                return;
            }
        } else if (this.A03.A04 == null) {
            return;
        }
        accessibilityEvent.setItemCount(this.A03.A04.A0D());
    }

    private final void A0L(C06794k c06794k, C06864r c06864r, C06513g c06513g) {
        if (this.A03.canScrollVertically(-1) || this.A03.canScrollHorizontally(-1)) {
            c06513g.A0N(8192);
            c06513g.A0R(true);
        }
        if (this.A03.canScrollVertically(1) || this.A03.canScrollHorizontally(1)) {
            c06513g.A0N(4096);
            String[] strArr = A0J;
            if (strArr[5].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0J;
            strArr2[2] = "WKK7ZU1nOyoZ4isR3";
            strArr2[4] = "S1xUaVTVF";
            c06513g.A0R(true);
        }
        C06483d collectionInfo = C06483d.A00(A0r(c06794k, c06864r), A0q(c06794k, c06864r), A0P(c06794k, c06864r), A06(c06794k, c06864r));
        c06513g.A0P(collectionInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0M(AbstractC06844p abstractC06844p) {
        if (this.A02 == abstractC06844p) {
            this.A02 = null;
        }
    }

    private final boolean A0N() {
        AbstractC06844p abstractC06844p = this.A02;
        return abstractC06844p != null && abstractC06844p.A0F();
    }

    public static boolean A0O(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (i3 > 0 && i != i3) {
            return false;
        }
        switch (mode) {
            case Integer.MIN_VALUE:
                return size >= i;
            case 0:
                return true;
            case 1073741824:
                return size == i;
            default:
                return false;
        }
    }

    private final boolean A0P(C06794k c06794k, C06864r c06864r) {
        return false;
    }

    private final boolean A0Q(C06794k c06794k, C06864r c06864r, int i, Bundle bundle) {
        ED ed = this.A03;
        if (ed == null) {
            return false;
        }
        int iA0X = 0;
        int iA0h = 0;
        switch (i) {
            case 4096:
                if (ed.canScrollVertically(1)) {
                    iA0X = (A0X() - A0g()) - A0d();
                }
                if (this.A03.canScrollHorizontally(1)) {
                    iA0h = (A0h() - A0e()) - A0f();
                }
                break;
            case 8192:
                if (ed.canScrollVertically(-1)) {
                    iA0X = -((A0X() - A0g()) - A0d());
                }
                if (this.A03.canScrollHorizontally(-1)) {
                    iA0h = -((A0h() - A0e()) - A0f());
                }
                break;
        }
        if (iA0X == 0 && iA0h == 0) {
            return false;
        }
        ED ed2 = this.A03;
        if (A0J[7].length() == 8) {
            throw new RuntimeException();
        }
        A0J[7] = "6TTpYbQ6a4";
        ed2.scrollBy(iA0h, iA0X);
        return true;
    }

    private final boolean A0R(C06794k c06794k, C06864r c06864r, View view, int i, Bundle bundle) {
        return false;
    }

    private boolean A0S(ED ed, int i, int i2) {
        View focusedChild = ed.getFocusedChild();
        if (focusedChild == null) {
            return false;
        }
        int parentBottom = A0e();
        int parentRight = A0g();
        int parentTop = A0h();
        int parentTop2 = parentTop - A0f();
        int parentLeft = A0X();
        int parentLeft2 = parentLeft - A0d();
        Rect rect = this.A03.A0p;
        A0H(focusedChild, rect);
        if (rect.left - i >= parentTop2 || rect.right - i <= parentBottom || rect.top - i2 >= parentLeft2 || rect.bottom - i2 <= parentRight) {
            return false;
        }
        if (A0J[3].length() == 28) {
            throw new RuntimeException();
        }
        A0J[0] = "D1nd79aIos3YYe4Hq7EzCaafqnQh2NEe";
        return true;
    }

    @Deprecated
    private final boolean A0T(ED ed, View view, View view2) {
        return A0N() || ed.A1v();
    }

    private int[] A0U(View view, Rect rect) {
        int[] iArr = new int[2];
        int offScreenRight = A0e();
        int offScreenTop = A0g();
        int dy = A0h() - A0f();
        int offScreenLeft = A0X() - A0d();
        int childBottom = (view.getLeft() + rect.left) - view.getScrollX();
        int childRight = (view.getTop() + rect.top) - view.getScrollY();
        int childTop = rect.width() + childBottom;
        int parentLeft = rect.height();
        int childLeft = Math.min(0, childBottom - offScreenRight);
        int parentBottom = Math.min(0, childRight - offScreenTop);
        int parentTop = Math.max(0, childTop - dy);
        int parentLeft2 = Math.max(0, (parentLeft + childRight) - offScreenLeft);
        if (A0a() == 1) {
            if (parentTop == 0) {
                parentTop = Math.max(childLeft, childTop - dy);
            }
        } else {
            parentTop = childLeft != 0 ? childLeft : Math.min(childBottom - offScreenRight, parentTop);
        }
        if (parentBottom == 0) {
            parentBottom = Math.min(childRight - offScreenTop, parentLeft2);
        }
        iArr[0] = parentTop;
        iArr[1] = parentBottom;
        if (A0J[0].charAt(31) == 'p') {
            throw new RuntimeException();
        }
        A0J[0] = "97vXAXgJ0WxvI5IvBZpOR2Ky1DZNuVnu";
        return iArr;
    }

    public final int A0V() {
        return -1;
    }

    public final int A0W() {
        AnonymousClass40 anonymousClass40 = this.A01;
        if (anonymousClass40 != null) {
            return anonymousClass40.A05();
        }
        return 0;
    }

    public final int A0X() {
        return this.A0A;
    }

    public final int A0Y() {
        return this.A0B;
    }

    public final int A0Z() {
        ED ed = this.A03;
        C4Q a = ed != null ? ed.getAdapter() : null;
        if (a != null) {
            return a.A0D();
        }
        return 0;
    }

    public final int A0a() {
        return C3H.A01(this.A03);
    }

    public final int A0b() {
        return C3H.A02(this.A03);
    }

    public final int A0c() {
        return C3H.A03(this.A03);
    }

    public final int A0d() {
        ED ed = this.A03;
        if (ed != null) {
            return ed.getPaddingBottom();
        }
        return 0;
    }

    public final int A0e() {
        ED ed = this.A03;
        if (ed != null) {
            return ed.getPaddingLeft();
        }
        return 0;
    }

    public final int A0f() {
        ED ed = this.A03;
        if (ed != null) {
            return ed.getPaddingRight();
        }
        return 0;
    }

    public final int A0g() {
        ED ed = this.A03;
        if (ed != null) {
            return ed.getPaddingTop();
        }
        return 0;
    }

    public final int A0h() {
        return this.A0C;
    }

    public final int A0i() {
        return this.A0D;
    }

    public final int A0j(View view) {
        return view.getBottom() + A02(view);
    }

    public final int A0k(View view) {
        return view.getLeft() - A03(view);
    }

    public final int A0l(View view) {
        Rect rect = ((C06734d) view.getLayoutParams()).A03;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public final int A0m(View view) {
        Rect rect = ((C06734d) view.getLayoutParams()).A03;
        return view.getMeasuredWidth() + rect.left + rect.right;
    }

    public final int A0n(View view) {
        return view.getRight() + A04(view);
    }

    public final int A0o(View view) {
        return view.getTop() - A05(view);
    }

    public final int A0p(View view) {
        return ((C06734d) view.getLayoutParams()).A00();
    }

    public int A0q(C06794k c06794k, C06864r c06864r) {
        ED ed = this.A03;
        if (ed == null || ed.A04 == null || !A24()) {
            return 1;
        }
        return this.A03.A04.A0D();
    }

    public int A0r(C06794k c06794k, C06864r c06864r) {
        ED ed = this.A03;
        if (ed == null || ed.A04 == null || !A25()) {
            return 1;
        }
        return this.A03.A04.A0D();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005b A[RETURN] */
    public final View A0s() {
        ED ed = this.A03;
        if (ed == null) {
            return null;
        }
        View focusedChild = ed.getFocusedChild();
        String[] strArr = A0J;
        if (strArr[5].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        A0J[3] = "iiKud1wfkCloFGZ1U";
        if (focusedChild != null) {
            AnonymousClass40 anonymousClass40 = this.A01;
            String[] strArr2 = A0J;
            if (strArr2[5].length() != strArr2[1].length()) {
                A0J[0] = "7ET4ZuKdeEmot2qkcvXky1gJdqYIXUUX";
                if (!anonymousClass40.A0K(focusedChild)) {
                    return focusedChild;
                }
            } else {
                A0J[7] = "xPYIlKgRfeB9qWlMIQGlIgoODb";
                if (!anonymousClass40.A0K(focusedChild)) {
                    return focusedChild;
                }
            }
        }
        return null;
    }

    public final View A0t(int i) {
        AnonymousClass40 anonymousClass40 = this.A01;
        if (anonymousClass40 != null) {
            return anonymousClass40.A09(i);
        }
        return null;
    }

    public final View A0u(View view, int i) {
        return null;
    }

    public C06734d A0v(Context context, AttributeSet attributeSet) {
        return new C06734d(context, attributeSet);
    }

    public C06734d A0w(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C06734d) {
            return new C06734d((C06734d) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C06734d((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C06734d(layoutParams);
    }

    public final void A0x() {
        AbstractC06844p abstractC06844p = this.A02;
        if (abstractC06844p != null) {
            abstractC06844p.A09();
        }
    }

    public final void A0y() {
        ED ed = this.A03;
        if (ed != null) {
            ed.requestLayout();
        }
    }

    public final void A0z(int i) {
        ED ed = this.A03;
        if (ed != null) {
            ed.A1U(i);
        }
    }

    public final void A10(int i) {
        ED ed = this.A03;
        if (ed != null) {
            ed.A1V(i);
        }
    }

    public final void A11(int i, int i2) {
        this.A0C = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        this.A0D = mode;
        if (mode == 0 && !ED.A1B) {
            this.A0C = 0;
        }
        this.A0A = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.A0B = mode2;
        if (mode2 == 0 && !ED.A1B) {
            this.A0A = 0;
        }
    }

    public final void A12(int i, int i2) {
        int iA0W = A0W();
        if (iA0W == 0) {
            this.A03.A1b(i, i2);
            return;
        }
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (int i5 = 0; i5 < iA0W; i5++) {
            View viewA0t = A0t(i5);
            Rect rect = this.A03.A0p;
            A0H(viewA0t, rect);
            int count = rect.left;
            if (count < i3) {
                i3 = rect.left;
            }
            int count2 = rect.right;
            if (count2 > maxY) {
                maxY = rect.right;
            }
            int count3 = rect.top;
            if (count3 < i4) {
                i4 = rect.top;
            }
            int count4 = rect.bottom;
            if (count4 > maxX) {
                maxX = rect.bottom;
            }
        }
        this.A03.A0p.set(i3, i4, maxY, maxX);
        String[] strArr = A0J;
        String str = strArr[2];
        String str2 = strArr[4];
        int minX = str.length();
        int count5 = str2.length();
        if (minX == count5) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0J;
        strArr2[2] = "hT857kPIBtMq0qM94";
        strArr2[4] = "qfhhOTku3";
        A15(this.A03.A0p, i, i2);
    }

    public final void A13(int i, int i2) {
        this.A03.setMeasuredDimension(i, i2);
    }

    public final void A14(int i, C06794k c06794k) {
        View view = A0t(i);
        A0A(i);
        c06794k.A0X(view);
    }

    public void A15(Rect rect, int i, int i2) {
        int usedHeight = rect.width() + A0e() + A0f();
        int iHeight = rect.height();
        int usedWidth = A0g();
        int i3 = iHeight + usedWidth;
        int usedWidth2 = A0d();
        int width = i3 + usedWidth2;
        int usedWidth3 = A0c();
        int usedHeight2 = A00(i, usedHeight, usedWidth3);
        int usedWidth4 = A0b();
        A13(usedHeight2, A00(i2, width, usedWidth4));
    }

    public final void A16(View view) {
        A18(view, -1);
    }

    public final void A17(View view) {
        A19(view, -1);
    }

    public final void A18(View view, int i) {
        A0G(view, i, true);
    }

    public final void A19(View view, int i) {
        A0G(view, i, false);
    }

    public final void A1A(View view, int i, int i2) {
        C06734d c06734d = (C06734d) view.getLayoutParams();
        Rect rectA1D = this.A03.A1D(view);
        int i3 = i + rectA1D.left + rectA1D.right;
        int i4 = i2 + rectA1D.top + rectA1D.bottom;
        int iA01 = A01(A0h(), A0i(), A0e() + A0f() + c06734d.leftMargin + c06734d.rightMargin + i3, c06734d.width, A24());
        int iA0X = A0X();
        int iA0Y = A0Y();
        int widthSpec = A0g();
        int iA02 = A01(iA0X, iA0Y, widthSpec + A0d() + c06734d.topMargin + c06734d.bottomMargin + i4, c06734d.height, A25());
        if (A1a(view, iA01, iA02, c06734d)) {
            view.measure(iA01, iA02);
        }
    }

    public final void A1B(View view, int i, int i2, int i3, int i4) {
        C06734d c06734d = (C06734d) view.getLayoutParams();
        Rect rect = c06734d.A03;
        view.layout(rect.left + i + c06734d.leftMargin, rect.top + i2 + c06734d.topMargin, (i3 - rect.right) - c06734d.rightMargin, (i4 - rect.bottom) - c06734d.bottomMargin);
    }

    public final void A1C(View view, C06513g c06513g) {
        AbstractC06894u abstractC06894uA0F = ED.A0F(view);
        if (abstractC06894uA0F != null && !abstractC06894uA0F.A0c() && !this.A01.A0K(abstractC06894uA0F.A0H)) {
            A1K(this.A03.A0r, this.A03.A0s, view, c06513g);
        }
    }

    public final void A1D(View view, C06794k c06794k) {
        A0D(view);
        c06794k.A0X(view);
    }

    public final void A1E(View view, boolean z, Rect rect) {
        Matrix matrix;
        if (z) {
            Rect rect2 = ((C06734d) view.getLayoutParams()).A03;
            rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        } else {
            rect.set(0, 0, view.getWidth(), view.getHeight());
        }
        if (this.A03 != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.A03.A0q;
            rectF.set(rect);
            matrix.mapRect(rectF);
            int iFloor = (int) Math.floor(rectF.left);
            int iFloor2 = (int) Math.floor(rectF.top);
            float f = rectF.right;
            String[] strArr = A0J;
            if (strArr[5].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            A0J[7] = "WbBFuKAltYM";
            rect.set(iFloor, iFloor2, (int) Math.ceil(f), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public final void A1F(C06513g c06513g) {
        A0L(this.A03.A0r, this.A03.A0s, c06513g);
    }

    public final void A1G(C06794k c06794k) {
        int iA0E = c06794k.A0E();
        for (int i = iA0E - 1; i >= 0; i--) {
            View viewA0F = c06794k.A0F(i);
            AbstractC06894u abstractC06894uA0F = ED.A0F(viewA0F);
            if (!abstractC06894uA0F.A0h()) {
                abstractC06894uA0F.A0Z(false);
                if (abstractC06894uA0F.A0e()) {
                    this.A03.removeDetachedView(viewA0F, false);
                }
                if (this.A03.A05 != null) {
                    this.A03.A05.A0K(abstractC06894uA0F);
                }
                abstractC06894uA0F.A0Z(true);
                c06794k.A0V(viewA0F);
            }
        }
        c06794k.A0L();
        if (iA0E > 0) {
            this.A03.invalidate();
        }
    }

    public final void A1H(C06794k c06794k) {
        int childCount = A0W();
        for (int i = childCount - 1; i >= 0; i--) {
            A0J(c06794k, i, A0t(i));
        }
    }

    public final void A1I(C06794k c06794k) {
        for (int iA0W = A0W() - 1; iA0W >= 0; iA0W--) {
            if (!ED.A0F(A0t(iA0W)).A0h()) {
                A14(iA0W, c06794k);
            }
        }
    }

    public void A1J(C06794k c06794k, C06864r c06864r, int i, int i2) {
        this.A03.A1b(i, i2);
    }

    public void A1K(C06794k c06794k, C06864r c06864r, View view, C06513g c06513g) {
        int iA0p = A25() ? A0p(view) : 0;
        int iA0p2 = A24() ? A0p(view) : 0;
        String[] strArr = A0J;
        if (strArr[5].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        A0J[3] = "h476R5jl";
        C06493e itemInfo = C06493e.A00(iA0p, 1, iA0p2, 1, false, false);
        c06513g.A0Q(itemInfo);
    }

    public final void A1L(AbstractC06844p abstractC06844p) {
        AbstractC06844p abstractC06844p2 = this.A02;
        if (abstractC06844p2 != null && abstractC06844p != abstractC06844p2 && abstractC06844p2.A0F()) {
            this.A02.A09();
        }
        this.A02 = abstractC06844p;
        abstractC06844p.A0D(this.A03, this);
    }

    public void A1M(ED ed) {
    }

    public final void A1N(ED ed) {
        this.A07 = true;
    }

    public final void A1O(ED ed) {
        A11(View.MeasureSpec.makeMeasureSpec(ed.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(ed.getHeight(), 1073741824));
    }

    public final void A1P(ED ed) {
        if (ed == null) {
            this.A03 = null;
            this.A01 = null;
            this.A0C = 0;
            this.A0A = 0;
        } else {
            this.A03 = ed;
            this.A01 = ed.A01;
            this.A0C = ed.getWidth();
            this.A0A = ed.getHeight();
        }
        this.A0D = 1073741824;
        this.A0B = 1073741824;
    }

    public void A1Q(ED ed, int i, int i2) {
    }

    public void A1R(ED ed, int i, int i2) {
    }

    public void A1S(ED ed, int i, int i2, int i3) {
    }

    public void A1T(ED ed, int i, int i2, Object obj) {
    }

    public final void A1U(ED ed, C06794k c06794k) {
        this.A07 = false;
        A20(ed, c06794k);
    }

    public final void A1V(boolean z) {
        this.A06 = z;
    }

    public final boolean A1W() {
        int iA0W = A0W();
        for (int i = 0; i < iA0W; i++) {
            ViewGroup.LayoutParams layoutParams = A0t(i).getLayoutParams();
            int childCount = layoutParams.width;
            if (childCount < 0) {
                int childCount2 = layoutParams.height;
                if (childCount2 < 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean A1X() {
        ED ed = this.A03;
        return ed != null && ed.A0B;
    }

    public final boolean A1Y() {
        return this.A0E;
    }

    public final boolean A1Z(int i, Bundle bundle) {
        return A0Q(this.A03.A0r, this.A03.A0s, i, bundle);
    }

    public final boolean A1a(View view, int i, int i2, C06734d c06734d) {
        return (!view.isLayoutRequested() && this.A0F && A0O(view.getWidth(), i, c06734d.width) && A0O(view.getHeight(), i2, c06734d.height)) ? false : true;
    }

    public final boolean A1b(View view, int i, Bundle bundle) {
        return A0R(this.A03.A0r, this.A03.A0s, view, i, bundle);
    }

    public boolean A1c(C06734d c06734d) {
        return c06734d != null;
    }

    public final boolean A1d(ED ed, View view, Rect rect, boolean z) {
        return A1e(ed, view, rect, z, false);
    }

    public final boolean A1e(ED ed, View view, Rect rect, boolean z, boolean z2) {
        int[] scrollAmount = A0U(view, rect);
        int i = scrollAmount[0];
        int i2 = scrollAmount[1];
        if ((z2 && !A0S(ed, i, i2)) || (i == 0 && i2 == 0)) {
            return false;
        }
        if (z) {
            ed.scrollBy(i, i2);
        } else {
            ed.A1f(i, i2);
        }
        return true;
    }

    public final boolean A1f(ED ed, C06864r c06864r, View view, View view2) {
        return A0T(ed, view, view2);
    }

    public final boolean A1g(ED ed, ArrayList<View> views, int i, int i2) {
        return false;
    }

    public int A1h(int i, C06794k c06794k, C06864r c06864r) {
        return 0;
    }

    public int A1i(int i, C06794k c06794k, C06864r c06864r) {
        return 0;
    }

    public int A1j(C06864r c06864r) {
        return 0;
    }

    public int A1k(C06864r c06864r) {
        return 0;
    }

    public int A1l(C06864r c06864r) {
        return 0;
    }

    public int A1m(C06864r c06864r) {
        return 0;
    }

    public int A1n(C06864r c06864r) {
        return 0;
    }

    public int A1o(C06864r c06864r) {
        return 0;
    }

    public Parcelable A1p() {
        return null;
    }

    public View A1q(int i) {
        int iA0W = A0W();
        for (int i2 = 0; i2 < iA0W; i2++) {
            View child = A0t(i2);
            AbstractC06894u abstractC06894uA0F = ED.A0F(child);
            if (abstractC06894uA0F != null) {
                int childCount = abstractC06894uA0F.A0I();
                if (childCount == i && !abstractC06894uA0F.A0h() && (this.A03.A0s.A07() || !abstractC06894uA0F.A0c())) {
                    return child;
                }
            }
        }
        return null;
    }

    public View A1r(View view, int i, C06794k c06794k, C06864r c06864r) {
        return null;
    }

    public void A1t(int i) {
    }

    public void A1u(int i, int i2, C06864r c06864r, InterfaceC06704a interfaceC06704a) {
    }

    public void A1v(int i, InterfaceC06704a interfaceC06704a) {
    }

    public void A1w(Parcelable parcelable) {
    }

    public void A1x(AccessibilityEvent accessibilityEvent) {
        A0K(this.A03.A0r, this.A03.A0s, accessibilityEvent);
    }

    public void A1y(C06794k c06794k, C06864r c06864r) {
        Log.e(A07(129, 12, 19), A07(141, 67, 101));
    }

    public void A1z(C06864r c06864r) {
    }

    public void A20(ED ed, C06794k c06794k) {
    }

    public void A21(ED ed, C06864r c06864r, int i) {
        Log.e(A07(129, 12, 19), A07(208, 68, 14));
    }

    public void A22(String str) {
        ED ed = this.A03;
        if (ed != null) {
            ed.A1q(str);
        }
    }

    public boolean A23() {
        return false;
    }

    public boolean A24() {
        return false;
    }

    public boolean A25() {
        return false;
    }

    public boolean A26() {
        return false;
    }
}
