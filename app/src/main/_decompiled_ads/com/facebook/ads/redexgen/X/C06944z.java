package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4z, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C06944z {
    public C06914w A00 = new C06914w();
    public final InterfaceC06924x A01;

    public C06944z(InterfaceC06924x interfaceC06924x) {
        this.A01 = interfaceC06924x;
    }

    public final View A00(int i, int i2, int i3, int i4) {
        int iA7T = this.A01.A7T();
        int next = this.A01.A7S();
        int childEnd = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewA6H = this.A01.A6H(i);
            int iA6K = this.A01.A6K(viewA6H);
            int i5 = this.A01.A6J(viewA6H);
            this.A00.A03(iA7T, next, iA6K, i5);
            if (i3 != 0) {
                this.A00.A01();
                this.A00.A02(i3);
                if (this.A00.A04()) {
                    return viewA6H;
                }
            }
            if (i4 != 0) {
                this.A00.A01();
                this.A00.A02(i4);
                if (this.A00.A04()) {
                    view = viewA6H;
                }
            }
            i += childEnd;
        }
        return view;
    }
}
