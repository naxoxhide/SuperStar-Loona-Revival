package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.widget.RelativeLayout;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5G, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C5G {
    public static byte[] A04;
    public final Intent A00;
    public final C5J A01;
    public final YA A02;
    public final InterfaceC1004If A03;

    static {
        A0T();
    }

    public static String A0S(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0T() {
        A04 = new byte[]{51, 54, 13, 54, 51, 38, 51, 13, 48, 39, 60, 54, 62, 55, 31, 20, 29, 21, 18, 25, 24, Base64.padSymbol, 24, 56, 29, 8, 29, 62, 9, 18, 24, 16, 25, 85, 90, 79, 82, 77, 94, 122, 95, 127, 90, 79, 90, 121, 78, 85, 95, 87, 94, 65, 86, 68, 82, 65, 87, 86, 87, 101, 90, 87, 86, 92, 114, 87, 119, 82, 71, 82, 113, 70, 93, 87, 95, 86, 16, 15, 2, 3, 9, 57, 18, 15, 11, 3, 57, 22, 9, 10, 10, 15, 8, 1, 57, 15, 8, 18, 3, 20, 16, 7, 10};
    }

    public C5G(C5J c5j, Intent intent, InterfaceC1004If interfaceC1004If, YA ya) {
        this.A01 = c5j;
        this.A00 = intent;
        this.A03 = interfaceC1004If;
        this.A02 = ya;
    }

    public /* synthetic */ C5G(C5J c5j, Intent intent, InterfaceC1004If interfaceC1004If, YA ya, C5F c5f) {
        this(c5j, intent, interfaceC1004If, ya);
    }

    private F0 A00() {
        return (F0) this.A00.getSerializableExtra(A0S(0, 14, 29));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InterfaceC1092Lu A02() {
        C5F c5f = null;
        if (IP.A2H(this.A02)) {
            return new C7I(this.A02, this.A03, new C6Q(this.A02), new C1425Yt(this.A01, c5f), A00());
        }
        return new C7H(this.A02, this.A03, new C6Q(this.A02), new C1425Yt(this.A01, c5f), A00());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C1290Tl A0G() {
        C5J c5j = this.A01;
        return new C1290Tl(c5j, this.A02, this.A03, new C1425Yt(c5j, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TU A0H() {
        return new TU(this.A02, this.A03, new C1425Yt(this.A01, null), A00(), null, new TR());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TU A0I() {
        C0921Ey c0921Ey = (C0921Ey) this.A00.getSerializableExtra(A0S(51, 25, 124));
        return new TU(this.A02, this.A03, new EB(this.A01, null), c0921Ey, c0921Ey.A0S(), new TQ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TS A0J(RelativeLayout relativeLayout) {
        TS ts = new TS(this.A02, new C1424Ys(this), this.A03, new C1425Yt(this.A01, null));
        ts.A05(relativeLayout);
        ts.A04(this.A00.getIntExtra(A0S(76, 27, 41), 200));
        LV.A0M(relativeLayout, -16777216);
        return ts;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnonymousClass96 A0K() {
        return new AnonymousClass96(this.A02, this.A03, new C1425Yt(this.A01, null), A00(), new TR(), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnonymousClass96 A0L() {
        return new AnonymousClass96(this.A02, this.A03, new C1425Yt(this.A01, null), (C0921Ey) this.A00.getSerializableExtra(A0S(51, 25, 124)), new TQ(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C1254Sa A0M() {
        C1157Oh c1157OhA02;
        AbstractC1484aS abstractC1484aS = (AbstractC1484aS) this.A00.getSerializableExtra(A0S(33, 18, 116));
        C5F c5f = null;
        if (abstractC1484aS == null || (c1157OhA02 = C1158Oi.A02(abstractC1484aS.A0R())) == null) {
            return null;
        }
        return new C1254Sa(this.A02, new C1425Yt(this.A01, c5f), c1157OhA02, abstractC1484aS.A11());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SD A0N(EnumC1039Jq enumC1039Jq) {
        MM tq;
        InterfaceC1091Lt eb;
        C1482aQ c1482aQ = (C1482aQ) this.A00.getSerializableExtra(A0S(14, 19, 51));
        C5F c5f = null;
        if (enumC1039Jq == EnumC1039Jq.A03) {
            tq = new TR();
            eb = new C1425Yt(this.A01, c5f);
        } else {
            tq = new TQ();
            eb = new EB(this.A01, c5f);
        }
        return new SD(this.A02, tq, this.A03, c1482aQ, new C6Q(this.A02), eb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C8B A0O() {
        return new C8B(this.A02, new TR(), this.A03, A00(), new C6Q(this.A02), new C1425Yt(this.A01, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C7K A0P() {
        return new C7K(this.A02, new TR(), this.A03, A00(), new C6Q(this.A02), new C1425Yt(this.A01, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C7K A0Q() {
        return new C7K(this.A02, new TQ(), this.A03, (C0921Ey) this.A00.getSerializableExtra(A0S(51, 25, 124)), new C6Q(this.A02), new EB(this.A01, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C7H A0R() {
        return new C7H(this.A02, this.A03, new C6Q(this.A02), new C1425Yt(this.A01, null), (C0921Ey) this.A00.getSerializableExtra(A0S(51, 25, 124)));
    }
}
