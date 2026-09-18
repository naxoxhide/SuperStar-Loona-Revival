package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.animation.AlphaAnimation;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.settings.AdInternalSettings;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4V, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C4V extends AbstractC1297Ts<C1203Qb> implements C7P {
    public static String[] A02 = {"iVby5wy6H7l4dzY0Hld0xs9tuHtnGk", "Nr0U5YnFPaRVMsCPPiWFbDdqiRS3TX59", "NmHEOi9mcJk9OQjZmIqLk3AYwOx5ICK3", "j6OxXppfxNxejmkkIb10P2S2ED13bfax", "YxA", "okdCTGqDBxOQkU", "XAA3rxsPdfTGxXL8JCFSxOB2RupP9g", "Mu"};
    public YA A00;
    public boolean A01;

    public C4V(C1203Qb c1203Qb, YA ya) {
        super(c1203Qb);
        this.A00 = ya;
        this.A01 = false;
    }

    private void A00(int i) {
        if (!this.A01) {
            this.A00.A0E().A3G(i);
        }
        String[] strArr = A02;
        if (strArr[0].length() != strArr[6].length()) {
            throw new RuntimeException();
        }
        A02[1] = "k6Oe58jhR2JQ133LIP7LsY5lW6eco9l5";
        this.A01 = true;
    }

    @Override // com.facebook.ads.redexgen.X.K8
    public final void A06() {
        C1203Qb c1203QbA07 = A07();
        int iIntValue = 0;
        if (c1203QbA07 == null) {
            A00(0);
            return;
        }
        View view = c1203QbA07.A0C;
        AbstractC1202Qa abstractC1202Qa = (AbstractC1202Qa) c1203QbA07.A0E.get();
        int i = 1;
        boolean z = view == null;
        if (!z && abstractC1202Qa != null) {
            C1204Qc c1204QcA0E = C1203Qb.A0E(view, c1203QbA07.A0A, this.A00);
            if (c1204QcA0E.A04()) {
                C1203Qb.A05(c1203QbA07);
            } else {
                c1203QbA07.A00 = 0;
            }
            boolean z2 = c1203QbA07.A00 > c1203QbA07.A09;
            boolean wasViewable = c1203QbA07.A05 != null && c1203QbA07.A05.A04();
            if (z2 || !c1204QcA0E.A04()) {
                c1203QbA07.A05 = c1204QcA0E;
            }
            String strValueOf = String.valueOf(c1204QcA0E.A01());
            synchronized (c1203QbA07) {
                if (c1203QbA07.A06.containsKey(strValueOf)) {
                    iIntValue = ((Integer) c1203QbA07.A06.get(strValueOf)).intValue();
                }
                c1203QbA07.A06.put(strValueOf, Integer.valueOf(iIntValue + 1));
            }
            if (z2 && !wasViewable) {
                this.A01 = true;
                c1203QbA07.A03 = System.currentTimeMillis();
                if (c1203QbA07.A07) {
                    this.A00.A0E().A3H();
                }
                abstractC1202Qa.A03();
                if (BuildConfigApi.isDebug() && AdInternalSettings.isVisibleAnimation()) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation.setDuration(500L);
                    view.startAnimation(alphaAnimation);
                }
                if (!c1203QbA07.A0F) {
                    return;
                }
            } else if (!z2 && wasViewable) {
                this.A01 = true;
                if (c1203QbA07.A07) {
                    this.A00.A0E().A2n(c1204QcA0E.A02());
                }
                abstractC1202Qa.A00();
            } else {
                abstractC1202Qa.A02();
                if (!this.A01 && c1203QbA07.A07) {
                    this.A00.A0E().A3F(c1204QcA0E.A02());
                }
                this.A01 = true;
            }
            if (!c1203QbA07.A08 && c1203QbA07.A04 != null) {
                c1203QbA07.A0B.postDelayed(c1203QbA07.A04, c1203QbA07.A02);
                return;
            }
            return;
        }
        if (c1203QbA07.A07) {
            if (!z) {
                i = 2;
            }
            A00(i);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C7P
    public final YA A5p() {
        return this.A00;
    }
}
