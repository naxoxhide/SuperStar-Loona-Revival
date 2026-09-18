package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1201Pz extends AbstractC07628a<AnonymousClass75> {
    public final /* synthetic */ AnonymousClass76 A00;

    public C1201Pz(AnonymousClass76 anonymousClass76) {
        this.A00 = anonymousClass76;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC07628a
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(AnonymousClass75 anonymousClass75) {
        int iA00 = anonymousClass75.A00();
        int duration = anonymousClass75.A01();
        int currentPosition = this.A00.A00;
        if (currentPosition > 0 && iA00 == duration) {
            int currentPosition2 = this.A00.A00;
            if (duration > currentPosition2) {
                return;
            }
        }
        int currentPosition3 = iA00 + 500;
        if (duration < currentPosition3) {
            if (duration == 0) {
                AnonymousClass76 anonymousClass76 = this.A00;
                int currentPosition4 = anonymousClass76.A00;
                anonymousClass76.A0d(currentPosition4);
                return;
            }
            this.A00.A0d(duration);
            return;
        }
        this.A00.A0d(iA00);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC07628a
    public final Class<AnonymousClass75> A01() {
        return AnonymousClass75.class;
    }
}
