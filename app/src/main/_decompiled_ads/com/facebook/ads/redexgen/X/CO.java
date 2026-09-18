package com.facebook.ads.redexgen.X;

import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CO {
    public static String[] A0J = {"Hx", "VutN6lGbTtI", "", "qYQ0MvWUv8Y", "S03PbS7CBB7Qa9LNqne809kWTfsCcOYT", "wkl2QKty73uWRgng3ylrY2sBCsabW7qE", "iu4lxNjBwDGgTbBIaWVT9T7j7cQi6zNN", "a5Fde8I7YqGVonU3ugZgHcMmcsmCDOtB"};
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public long A05;
    public long A06;
    public C7 A07;
    public CN A08;
    public C0980Hh A09;
    public boolean A0A;
    public boolean A0B;
    public int[] A0C;
    public int[] A0D;
    public int[] A0E;
    public long[] A0F;
    public long[] A0G;
    public boolean[] A0H;
    public boolean[] A0I;

    public final long A00(int i) {
        return this.A0F[i] + ((long) this.A0C[i]);
    }

    public final void A01() {
        this.A02 = 0;
        this.A06 = 0L;
        this.A0A = false;
        this.A0B = false;
        this.A08 = null;
    }

    public final void A02(int i) {
        C0980Hh c0980Hh = this.A09;
        if (c0980Hh == null || c0980Hh.A07() < i) {
            this.A09 = new C0980Hh(i);
        }
        this.A01 = i;
        this.A0A = true;
        this.A0B = true;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x004d  */
    public final void A03(int i, int i2) {
        int[] iArr;
        int i3;
        this.A02 = i;
        this.A00 = i2;
        int[] iArr2 = this.A0E;
        if (iArr2 == null || iArr2.length < i) {
            long[] jArr = new long[i];
            if (A0J[2].length() == 0) {
                String[] strArr = A0J;
                strArr[4] = "ZgUWYZPBUUH4f5IflhoFXt9Z2beMZ7L4";
                strArr[5] = "VeOPEMocQkhcG8xqDUtsqj4H6GWeaBG3";
                this.A0G = jArr;
                this.A0E = new int[i];
                iArr = this.A0D;
                if (iArr != null || iArr.length < i2) {
                    i3 = (i2 * 125) / 100;
                    this.A0D = new int[i3];
                    if (A0J[0].length() == 2) {
                        A0J[1] = "QhoZMJVE40X";
                        this.A0C = new int[i3];
                        this.A0F = new long[i3];
                        this.A0I = new boolean[i3];
                        this.A0H = new boolean[i3];
                        return;
                    }
                } else {
                    return;
                }
            }
        } else {
            iArr = this.A0D;
            if (iArr != null) {
            }
            i3 = (i2 * 125) / 100;
            this.A0D = new int[i3];
            if (A0J[0].length() == 2) {
                A0J[1] = "QhoZMJVE40X";
                this.A0C = new int[i3];
                this.A0F = new long[i3];
                this.A0I = new boolean[i3];
                this.A0H = new boolean[i3];
                return;
            }
        }
        throw new RuntimeException();
    }

    public final void A04(InterfaceC0839Bb interfaceC0839Bb) throws InterruptedException, IOException {
        interfaceC0839Bb.readFully(this.A09.A00, 0, this.A01);
        this.A09.A0Y(0);
        this.A0B = false;
    }

    public final void A05(C0980Hh c0980Hh) {
        c0980Hh.A0c(this.A09.A00, 0, this.A01);
        this.A09.A0Y(0);
        this.A0B = false;
    }
}
