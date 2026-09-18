package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class V3 implements InterfaceC0951Gc {
    public static String[] A04 = {"X6WlBdbGeBIUy9RcgyD1kPyvMH5gl65h", "mWixtdhRvEEOtO49Z6LrUITCnd", "19dVuEeyHaOsnSLi", "Fh0FDziHvuuc46M8RjDn", "TMNOdV", "BntQd7XboiQ5Pp5LCDj1cbVKSXS32D1x", "NrlP0Z8V9f9J6rKzzcCufZh8yiDjfbRh", "BOidXQkRBMfwkg7VYmAkrOpgeHcKVKv0"};
    public long A00;
    public boolean A01;
    public final InterfaceC0949Ga A02;
    public final InterfaceC0951Gc A03;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final long ADb(C0955Gg c0955Gg) throws IOException {
        long jADb = this.A03.ADb(c0955Gg);
        this.A00 = jADb;
        if (jADb == 0) {
            return 0L;
        }
        if (c0955Gg.A02 == -1 && this.A00 != -1) {
            c0955Gg = new C0955Gg(c0955Gg.A04, c0955Gg.A01, c0955Gg.A03, this.A00, c0955Gg.A05, c0955Gg.A00);
        }
        this.A01 = true;
        this.A02.ADd(c0955Gg);
        return this.A00;
    }

    public V3(InterfaceC0951Gc interfaceC0951Gc, InterfaceC0949Ga interfaceC0949Ga) {
        this.A03 = (InterfaceC0951Gc) HI.A01(interfaceC0951Gc);
        this.A02 = (InterfaceC0949Ga) HI.A01(interfaceC0949Ga);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final Uri A85() {
        return this.A03.A85();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final void close() throws IOException {
        try {
            this.A03.close();
            if (this.A01) {
                this.A01 = false;
                this.A02.close();
            }
        } catch (Throwable th) {
            boolean z = this.A01;
            if (A04[5].charAt(29) != 'a') {
                A04[1] = "CXpRjqYaQVmivrsYVOmY1oz";
                if (z) {
                    this.A01 = false;
                    InterfaceC0949Ga interfaceC0949Ga = this.A02;
                    if (A04[1].length() != 2) {
                        A04[5] = "FmRI3fMemMJaQGBcEYhbAky7hUfnuUR1";
                        interfaceC0949Ga.close();
                    }
                }
                throw th;
            }
            throw new RuntimeException();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.A00 == 0) {
            return -1;
        }
        int i3 = this.A03.read(bArr, i, i2);
        if (i3 > 0) {
            this.A02.write(bArr, i, i3);
            long j = this.A00;
            if (j != -1) {
                this.A00 = j - ((long) i3);
            }
        }
        return i3;
    }
}
