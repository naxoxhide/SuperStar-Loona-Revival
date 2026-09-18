package com.facebook.ads.redexgen.X;

import android.net.Uri;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1341Vk implements InterfaceC0963Gq {
    public static String[] A0C = {"G7jWD6ulf4YNSZyKFTHtDKYEexnehBFD", "eAcypqsPfTTSG9tYkNPVa4Ur1OSgM6nM", "x", "tNQG44GENbPBCr6MlCIr3t4n4NF0MmxZ", "OwErIGDXAeY1H11Nt9UmuNZTMubue4sT", InneractiveMediationDefs.GENDER_FEMALE, "eBkibdjxFKT4WmP6H51EPZ9055c0bCkp", "0Ce9TygyYiJS1KV85oyrWWiGz76nCu"};
    public long A00;
    public long A02;
    public C0955Gg A03;
    public final Uri A05;
    public final ES A07;
    public final InterfaceC0951Gc A08;
    public final HO A09;
    public volatile boolean A0A;
    public final /* synthetic */ BT A0B;
    public final C0843Bh A06 = new C0843Bh();
    public boolean A04 = true;
    public long A01 = -1;

    public C1341Vk(BT bt, Uri uri, InterfaceC0951Gc interfaceC0951Gc, ES es, HO ho) {
        this.A0B = bt;
        this.A05 = (Uri) HI.A01(uri);
        this.A08 = (InterfaceC0951Gc) HI.A01(interfaceC0951Gc);
        this.A07 = (ES) HI.A01(es);
        this.A09 = ho;
    }

    public final void A04(long j, long j2) {
        this.A06.A00 = j;
        this.A02 = j2;
        this.A04 = true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0963Gq
    public final void A47() {
        this.A0A = true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0963Gq
    public final void A9B() throws InterruptedException, IOException {
        int result = 0;
        while (result == 0 && !this.A0A) {
            InterfaceC0839Bb interfaceC0839Bb = null;
            try {
                long jA7a = this.A06.A00;
                C0955Gg c0955Gg = new C0955Gg(this.A05, jA7a, -1L, this.A0B.A0b);
                this.A03 = c0955Gg;
                long jADb = this.A08.ADb(c0955Gg);
                this.A01 = jADb;
                if (jADb != -1) {
                    this.A01 = jADb + jA7a;
                }
                X4 x4 = new X4(this.A08, jA7a, this.A01);
                InterfaceC0838Ba extractor = this.A07.A02(x4, this.A08.A85());
                if (this.A04) {
                    extractor.AEw(jA7a, this.A02);
                    this.A04 = false;
                }
                while (result == 0 && !this.A0A) {
                    this.A09.A00();
                    result = extractor.AE9(x4, this.A06);
                    if (x4.A7a() > this.A0B.A0P + jA7a) {
                        jA7a = x4.A7a();
                        this.A09.A01();
                        this.A0B.A0R.post(this.A0B.A0a);
                    }
                }
                if (result == 1) {
                    result = 0;
                } else {
                    C0843Bh c0843Bh = this.A06;
                    if (A0C[7].length() == 32) {
                        throw new RuntimeException();
                    }
                    A0C[7] = "RP5F3MQdpmYGlMxTR22UmyqYUd";
                    c0843Bh.A00 = x4.A7a();
                    this.A00 = this.A06.A00 - this.A03.A01;
                }
                C0996Hx.A0W(this.A08);
            } catch (Throwable th) {
                String[] strArr = A0C;
                if (strArr[3].charAt(18) != strArr[0].charAt(18)) {
                    String[] strArr2 = A0C;
                    strArr2[1] = "eRCRzQ7PqS4RXHh1qWIeZ2INrCYp7IVM";
                    strArr2[6] = "eZFPNfTqDUJk6uZFjeWmQVerr07XVEhG";
                    if (result != 1 && 0 != 0) {
                        this.A06.A00 = interfaceC0839Bb.A7a();
                        this.A00 = this.A06.A00 - this.A03.A01;
                    }
                    C0996Hx.A0W(this.A08);
                    throw th;
                }
            }
        }
    }
}
