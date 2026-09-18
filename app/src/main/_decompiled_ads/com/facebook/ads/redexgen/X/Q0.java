package com.facebook.ads.redexgen.X;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class Q0 extends AbstractC07628a<AnonymousClass71> {
    public final /* synthetic */ AnonymousClass76 A00;

    public Q0(AnonymousClass76 anonymousClass76) {
        this.A00 = anonymousClass76;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC07628a
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(AnonymousClass71 anonymousClass71) {
        int iA00 = anonymousClass71.A00();
        int currentPositionMS = this.A00.A00;
        if (currentPositionMS > 0) {
            int currentPositionMS2 = this.A00.A0B.getDuration();
            if (iA00 == currentPositionMS2) {
                int duration = this.A00.A0B.getDuration();
                int currentPositionMS3 = this.A00.A00;
                if (duration > currentPositionMS3) {
                    return;
                }
            }
        }
        this.A00.A0e(iA00);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC07628a
    public final Class<AnonymousClass71> A01() {
        return AnonymousClass71.class;
    }
}
