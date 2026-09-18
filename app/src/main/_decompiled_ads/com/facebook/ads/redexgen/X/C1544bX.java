package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bX, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1544bX {
    public static String[] A0C = {"YcCIPLCDTe1wGTKdO7xqYhpFwQzvmXtt", "FfIdHaSVTal814YVh5tJNVr21T0wsSAo", "HLDls6wic6LzndIKtUvgWnGJ4QMP07cO", "ccYpD8PuArRKO9YkPTuVfhIh5pDN1br2", "LFFD576NBTVByEN649EglQB81U0zBBuc", "sO5gz1O188I9hNkbLLxzl8j4JWiDgVKK", "Hord6YvHX1lmSPmhXyMRW660HCYjcXOm", "5HbQDpK1pfSpB47EOovGOWVGJlrw1BSl"};
    public InterfaceC1548bb A00;
    public boolean A01;
    public final Rect A02;
    public final Rect A03;
    public final Handler A04;
    public final InterfaceC1243Rp A05;
    public final InterfaceC1555bi A06;
    public final C1546bZ A07;
    public final InterfaceC0945Fw A08;
    public final Runnable A09;
    public final List<Rect> A0A;
    public final List<View> A0B;

    public C1544bX(InterfaceC1555bi interfaceC1555bi, InterfaceC1243Rp interfaceC1243Rp, InterfaceC0945Fw interfaceC0945Fw, C1546bZ c1546bZ, Handler handler) {
        this(interfaceC1555bi, interfaceC1243Rp, interfaceC0945Fw, c1546bZ, handler, 100);
    }

    public C1544bX(InterfaceC1555bi interfaceC1555bi, InterfaceC1243Rp interfaceC1243Rp, InterfaceC0945Fw interfaceC0945Fw, C1546bZ c1546bZ, Handler handler, int i) {
        this.A03 = new Rect();
        this.A02 = new Rect();
        this.A0B = new ArrayList();
        this.A0A = new ArrayList();
        this.A01 = false;
        this.A06 = interfaceC1555bi;
        this.A05 = interfaceC1243Rp;
        this.A08 = interfaceC0945Fw;
        this.A07 = c1546bZ;
        this.A04 = handler;
        this.A09 = new RunnableC1545bY(this, i);
    }

    private void A03(long j) {
        if (this.A0B.isEmpty()) {
            this.A06.A8E(this.A0A);
            this.A08.A3x(j, this.A0A);
            this.A08.A5U();
            return;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04(long j) {
        this.A06.A8E(this.A0A);
        this.A08.A3x(j, this.A0A);
        if (this.A0B.isEmpty()) {
            this.A07.A03(this.A0B);
            for (View view : this.A0B) {
                C1553bg c1553bgA00 = this.A07.A00(view);
                Iterator<Rect> it = this.A0A.iterator();
                while (it.hasNext()) {
                    if (C1537bQ.A00(view, this.A03, this.A02, it.next()) && c1553bgA00 != C1553bg.A08) {
                        InterfaceC0945Fw interfaceC0945Fw = this.A08;
                        Rect containerRect = this.A03;
                        Rect rect = this.A02;
                        if (A0C[0].charAt(21) != 'h') {
                            throw new RuntimeException();
                        }
                        A0C[6] = "BhrT0c14O8Thrmtg3HRzOfRcpCyh5HNl";
                        interfaceC0945Fw.A3R(c1553bgA00, containerRect, rect);
                    }
                }
            }
            this.A08.A5U();
            InterfaceC1548bb interfaceC1548bb = this.A00;
            if (interfaceC1548bb != null) {
                interfaceC1548bb.ACr();
            }
            this.A0B.clear();
            String[] strArr = A0C;
            if (strArr[1].charAt(9) != strArr[3].charAt(9)) {
                String[] strArr2 = A0C;
                strArr2[1] = "lmQ3TWUKEycrXTOUs6diKoA3HcDn9Pdd";
                strArr2[3] = "T2sieqBmgvCwHjMtYcExspPM2F3LyLlD";
                return;
            }
            throw new RuntimeException();
        }
        throw new IllegalStateException();
    }

    public final void A07() {
        InterfaceC1548bb interfaceC1548bb = this.A00;
        if (interfaceC1548bb != null) {
            interfaceC1548bb.ACr();
        }
        if (this.A01) {
            this.A04.removeCallbacks(this.A09);
            A03(this.A05.AAE());
        }
        this.A01 = false;
        if (A0C[0].charAt(21) != 'h') {
            throw new RuntimeException();
        }
        A0C[0] = "Da2exFZBguRvp8OTbNDxEhbqIKaEOHIs";
    }

    public final void A08() {
        if (!this.A01) {
            this.A01 = true;
            this.A04.post(this.A09);
        }
    }

    public final void A09(InterfaceC1550bd interfaceC1550bd) {
        this.A08.AFW(interfaceC1550bd);
    }

    public final void A0A(InterfaceC1548bb interfaceC1548bb) {
        this.A00 = interfaceC1548bb;
    }
}
