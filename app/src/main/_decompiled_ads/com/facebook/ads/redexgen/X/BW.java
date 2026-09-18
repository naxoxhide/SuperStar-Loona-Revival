package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class BW implements InterfaceC1337Vg, InterfaceC1338Vh {
    public static String[] A06 = {"ZtwyXb21lqsDJdKT2ajh9JxAXgW69QuB", "FrcJuXyaSLrnc8pAXv2TAxnFyZgF4qHK", "0iGJizGlWH9", "qhteMkWWDojgH5n0mIn7zojGTGtfRfRL", "S4vRLIoihFPQ", "xoDrhUfozcoi1lbYtymgci4hovtTAG3t", "yhmtadr4WKeMx7Xbvtz69UkymvwaYHjB", "iiLQKF6aVsd0mv8Gzt0Boeru5TAZQ446"};
    public long A00;
    public long A01;
    public long A02;
    public InterfaceC1338Vh A03;
    public C1343Vm[] A04 = new C1343Vm[0];
    public final InterfaceC1337Vg A05;

    public BW(InterfaceC1337Vg interfaceC1337Vg, boolean z, long j, long j2) {
        this.A05 = interfaceC1337Vg;
        this.A02 = z ? j : -9223372036854775807L;
        this.A01 = j;
        this.A00 = j2;
    }

    private C08089v A00(long j, C08089v c08089v) {
        long toleranceBeforeUs = C0996Hx.A0E(c08089v.A01, 0L, j - this.A01);
        long j2 = c08089v.A00;
        long j3 = this.A00;
        long jA0E = C0996Hx.A0E(j2, 0L, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j);
        if (toleranceBeforeUs == c08089v.A01 && jA0E == c08089v.A00) {
            return c08089v;
        }
        return new C08089v(toleranceBeforeUs, jA0E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0917Eu
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final void AAx(InterfaceC1337Vg interfaceC1337Vg) {
        this.A03.AAx(this);
    }

    public static boolean A02(long j, GO[] goArr) {
        if (j != 0) {
            for (GO go : goArr) {
                if (go != null && !C0973Ha.A09(go.A7m().A0O)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean A03() {
        return this.A02 != -9223372036854775807L;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1337Vg
    public final boolean A4Q(long j) {
        return this.A05.A4Q(j);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1337Vg
    public final void A55(long j, boolean z) {
        this.A05.A55(j, z);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1337Vg
    public final long A5s(long j, C08089v c08089v) {
        long j2 = this.A01;
        if (j == j2) {
            return j2;
        }
        return this.A05.A5s(j, A00(j, c08089v));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1337Vg
    public final long A68() {
        long jA68 = this.A05.A68();
        if (jA68 != Long.MIN_VALUE) {
            long j = this.A00;
            if (j != Long.MIN_VALUE) {
                if (A06[2].length() == 17) {
                    throw new RuntimeException();
                }
                A06[5] = "DtDan6JMsc2D9dL8KrRs9GVt0cLu7T4O";
                if (jA68 >= j) {
                }
            }
            return jA68;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1337Vg
    public final long A7M() {
        long jA7M = this.A05.A7M();
        if (jA7M != Long.MIN_VALUE) {
            long j = this.A00;
            if (j == Long.MIN_VALUE || jA7M < j) {
                return jA7M;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1337Vg
    public final TrackGroupArray A82() {
        return this.A05.A82();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1337Vg
    public final void AA3() throws IOException {
        this.A05.AA3();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1338Vh
    public final void ACW(InterfaceC1337Vg interfaceC1337Vg) {
        this.A03.ACW(this);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1337Vg
    public final void ADu(InterfaceC1338Vh interfaceC1338Vh, long j) {
        this.A03 = interfaceC1338Vh;
        this.A05.ADu(this, j);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1337Vg
    public final long AED() {
        if (A03()) {
            long childDiscontinuityUs = this.A02;
            if (A06[4].length() != 12) {
                throw new RuntimeException();
            }
            A06[6] = "LhyfL76jA11YYofpKqTom8Rw5oMGbfG9";
            this.A02 = -9223372036854775807L;
            long initialDiscontinuityUs = AED();
            return initialDiscontinuityUs != -9223372036854775807L ? initialDiscontinuityUs : childDiscontinuityUs;
        }
        long jAED = this.A05.AED();
        if (jAED == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z = true;
        HI.A04(jAED >= this.A01);
        long discontinuityUs = this.A00;
        if (discontinuityUs != Long.MIN_VALUE && jAED > discontinuityUs) {
            z = false;
        }
        HI.A04(z);
        return jAED;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1337Vg
    public final void AEK(long j) {
        this.A05.AEK(j);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0050  */
    @Override // com.facebook.ads.redexgen.X.InterfaceC1337Vg
    public final long AF0(long j) {
        this.A02 = -9223372036854775807L;
        boolean z = false;
        for (C1343Vm c1343Vm : this.A04) {
            if (c1343Vm != null) {
                c1343Vm.A00();
            }
        }
        long jAF0 = this.A05.AF0(j);
        if (jAF0 == j) {
            z = true;
        } else if (jAF0 >= this.A01) {
            long j2 = this.A00;
            if (j2 == Long.MIN_VALUE) {
                z = true;
            } else {
                if (A06[0].charAt(28) != '9') {
                    throw new RuntimeException();
                }
                A06[2] = "Q";
                if (jAF0 <= j2) {
                    z = true;
                }
            }
        }
        HI.A04(z);
        return jAF0;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0059  */
    /* JADX WARN: Code duplicated, block: B:38:0x008e  */
    @Override // com.facebook.ads.redexgen.X.InterfaceC1337Vg
    public final long AF1(GO[] goArr, boolean[] zArr, InterfaceC0916Et[] interfaceC0916EtArr, boolean[] zArr2, long j) {
        long j2;
        boolean z;
        this.A04 = new C1343Vm[interfaceC0916EtArr.length];
        InterfaceC0916Et[] interfaceC0916EtArr2 = new InterfaceC0916Et[interfaceC0916EtArr.length];
        int i = 0;
        while (true) {
            InterfaceC0916Et interfaceC0916Et = null;
            if (i >= interfaceC0916EtArr.length) {
                break;
            }
            C1343Vm[] c1343VmArr = this.A04;
            C1343Vm c1343Vm = (C1343Vm) interfaceC0916EtArr[i];
            c1343VmArr[i] = c1343Vm;
            if (c1343Vm != null) {
                interfaceC0916Et = c1343Vm.A01;
            }
            interfaceC0916EtArr2[i] = interfaceC0916Et;
            i++;
        }
        long jAF1 = this.A05.AF1(goArr, zArr, interfaceC0916EtArr2, zArr2, j);
        if (A03()) {
            long j3 = this.A01;
            if (j == j3 && A02(j3, goArr)) {
                j2 = jAF1;
            } else {
                j2 = -9223372036854775807L;
            }
        } else {
            j2 = -9223372036854775807L;
        }
        this.A02 = j2;
        if (jAF1 != j) {
            if (jAF1 >= this.A01) {
                long enablePositionUs = this.A00;
                z = enablePositionUs == Long.MIN_VALUE || jAF1 <= enablePositionUs;
            }
        }
        HI.A04(z);
        for (int i2 = 0; i2 < interfaceC0916EtArr.length; i2++) {
            if (interfaceC0916EtArr2[i2] == null) {
                InterfaceC0916Et[] childStreams = this.A04;
                childStreams[i2] = null;
            } else if (interfaceC0916EtArr[i2] == null || this.A04[i2].A01 != interfaceC0916EtArr2[i2]) {
                this.A04[i2] = new C1343Vm(this, interfaceC0916EtArr2[i2]);
            }
            InterfaceC0916Et[] childStreams2 = this.A04;
            interfaceC0916EtArr[i2] = childStreams2[i2];
        }
        return jAF1;
    }
}
