package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1553bg<ModelType, StateType> {
    public static byte[] A06;
    public static String[] A07 = {"K3IBH5IY5D9A1s0otTNJJ1EDvo1qLs", "HR7iyfZ1MOS5huP42RSdRpCkeBunQMOf", "", "bEqFTGguyIKgMYqaAFudqvCpFKGvMgpm", "3wGEEC73gwsSkVWXWqLxZk", "wIAJ3aMEmj6qTKsV0aDgjtipvoJzkW0C", "SCvpsyQDnQo4JnEbtI83SB", "GSqpB1BwT3x"};
    public static final C1553bg A08;
    public boolean A00;
    public final C1553bg A01;
    public final ModelType A02;
    public final StateType A03;
    public final String A04;
    public final List<InterfaceC1556bj<ModelType, StateType>> A05;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 113);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A06 = new byte[]{81, 89, 92, 96, 101};
    }

    static {
        A02();
        A08 = new C1553bg(null, null, A01(0, 5, 123), Collections.emptyList(), A08);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.bg != com.instagram.common.viewpoint.core.ViewpointData<ModelType, StateType> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.bh != com.instagram.common.viewpoint.core.ViewpointData$Builder<ModelType, StateType> */
    /* JADX WARN: Illegal instructions before constructor call */
    public C1553bg(C1554bh<ModelType, StateType> c1554bh) {
        List listEmptyList;
        Object obj = c1554bh.A02;
        Object obj2 = c1554bh.A03;
        String str = c1554bh.A04;
        if (c1554bh.A01 == null) {
            listEmptyList = Collections.emptyList();
        } else {
            listEmptyList = c1554bh.A01;
        }
        this(obj, obj2, str, listEmptyList, c1554bh.A00);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.bg != com.instagram.common.viewpoint.core.ViewpointData<ModelType, StateType> */
    public C1553bg(ModelType model, StateType state, String str, List<InterfaceC1556bj<ModelType, StateType>> list, C1553bg c1553bg) {
        this.A02 = model;
        this.A03 = state;
        this.A04 = str;
        this.A01 = c1553bg;
        this.A00 = false;
        this.A05 = list;
    }

    public static <ModelType, StateType> C1554bh<ModelType, StateType> A00(ModelType model, StateType state, String str) {
        return new C1554bh<>(model, state, str);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.bg != com.instagram.common.viewpoint.core.ViewpointData<ModelType, StateType> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.bj != com.instagram.common.viewpoint.core.ViewpointAction<ModelType, StateType> */
    public final void A03(InterfaceC1542bV interfaceC1542bV) {
        Iterator<InterfaceC1556bj<ModelType, StateType>> it = this.A05.iterator();
        while (it.hasNext()) {
            it.next().A5X(this, interfaceC1542bV);
        }
        EnumC1543bW enumC1543bWA8A = interfaceC1542bV.A8A(this);
        String[] strArr = A07;
        if (strArr[1].charAt(23) == strArr[3].charAt(23)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[7] = "xMDdEaQw2xH";
        strArr2[2] = "";
        if (enumC1543bWA8A == EnumC1543bW.A02) {
            this.A00 = true;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.bg != com.instagram.common.viewpoint.core.ViewpointData<ModelType, StateType> */
    public final boolean A04() {
        return this.A00;
    }
}
