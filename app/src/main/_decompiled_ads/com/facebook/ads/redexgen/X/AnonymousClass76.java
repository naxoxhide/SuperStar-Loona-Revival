package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.76, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass76 extends C1190Po {
    public int A00;
    public boolean A01;
    public final AbstractC07628a<AnonymousClass75> A02;
    public final AbstractC07628a<AnonymousClass72> A03;
    public final AbstractC07628a<MJ> A04;
    public final AbstractC07628a<AnonymousClass71> A05;
    public final AbstractC07628a<M8> A06;
    public final AbstractC07628a<LT> A07;
    public final AbstractC07628a<LO> A08;
    public final AbstractC07628a<KJ> A09;
    public final AbstractC07628a<KG> A0A;
    public final RX A0B;
    public final MA A0C;
    public final KK A0D;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 20 out of bounds for length 20
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public AnonymousClass76(YA ya, InterfaceC1004If interfaceC1004If, RX rx, List<C2D> list, String str) {
        super(ya, interfaceC1004If, rx, list, str, !rx.A0h(), new C1189Pn(ya, rx));
        KK kk = new KK() { // from class: com.facebook.ads.redexgen.X.79
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.AbstractC07628a
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C1059Kl c1059Kl) {
                this.A00.A0Z();
            }
        };
        this.A0D = kk;
        RU ru = new RU(this);
        this.A07 = ru;
        RQ rq = new RQ(this);
        this.A03 = rq;
        C1206Qe c1206Qe = new C1206Qe(this);
        this.A04 = c1206Qe;
        Q0 q0 = new Q0(this);
        this.A05 = q0;
        C1201Pz c1201Pz = new C1201Pz(this);
        this.A02 = c1201Pz;
        C1199Px c1199Px = new C1199Px(this);
        this.A06 = c1199Px;
        C1194Ps c1194Ps = new C1194Ps(this);
        this.A09 = c1194Ps;
        C1193Pr c1193Pr = new C1193Pr(this);
        this.A0A = c1193Pr;
        RW rw = new RW(this);
        this.A08 = rw;
        MA ma = new MA() { // from class: com.facebook.ads.redexgen.X.7A
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.AbstractC07628a
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(MD md) {
                AnonymousClass76 anonymousClass76 = this.A00;
                anonymousClass76.A00 = anonymousClass76.A0B.getDuration();
            }
        };
        this.A0C = ma;
        this.A01 = false;
        this.A0B = rx;
        rx.getEventBus().A03(kk, q0, ru, c1206Qe, rq, c1201Pz, c1199Px, c1194Ps, c1193Pr, ma, rw);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 23 out of bounds for length 22
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public AnonymousClass76(YA ya, InterfaceC1004If interfaceC1004If, RX rx, List<C2D> list, String str, Bundle bundle, Map<String, String> map) {
        super(ya, interfaceC1004If, rx, list, str, !rx.A0h(), bundle, map, new C1189Pn(ya, rx));
        KK kk = new KK() { // from class: com.facebook.ads.redexgen.X.79
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.AbstractC07628a
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C1059Kl c1059Kl) {
                this.A00.A0Z();
            }
        };
        this.A0D = kk;
        RU ru = new RU(this);
        this.A07 = ru;
        RQ rq = new RQ(this);
        this.A03 = rq;
        C1206Qe c1206Qe = new C1206Qe(this);
        this.A04 = c1206Qe;
        Q0 q0 = new Q0(this);
        this.A05 = q0;
        C1201Pz c1201Pz = new C1201Pz(this);
        this.A02 = c1201Pz;
        C1199Px c1199Px = new C1199Px(this);
        this.A06 = c1199Px;
        C1194Ps c1194Ps = new C1194Ps(this);
        this.A09 = c1194Ps;
        C1193Pr c1193Pr = new C1193Pr(this);
        this.A0A = c1193Pr;
        RW rw = new RW(this);
        this.A08 = rw;
        this.A0C = new MA() { // from class: com.facebook.ads.redexgen.X.7A
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.AbstractC07628a
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(MD md) {
                AnonymousClass76 anonymousClass76 = this.A00;
                anonymousClass76.A00 = anonymousClass76.A0B.getDuration();
            }
        };
        this.A01 = false;
        this.A0B = rx;
        rx.getEventBus().A03(kk, q0, ru, c1206Qe, rq, c1201Pz, c1199Px, c1194Ps, c1193Pr, rw);
    }

    public AnonymousClass76(YA ya, InterfaceC1004If interfaceC1004If, RX rx, String str) {
        this(ya, interfaceC1004If, rx, new ArrayList(), str);
    }

    public AnonymousClass76(YA ya, InterfaceC1004If interfaceC1004If, RX rx, String str, Bundle bundle) {
        this(ya, interfaceC1004If, rx, new ArrayList(), str, bundle, null);
    }

    public AnonymousClass76(YA ya, InterfaceC1004If interfaceC1004If, RX rx, String str, Map<String, String> extraParams) {
        this(ya, interfaceC1004If, rx, new ArrayList(), str, null, extraParams);
    }

    public final void A0g() {
        RV rv = new RV(this);
        if (this.A0B.A0l()) {
            LP.A00(rv);
        } else {
            this.A0B.getStateHandler().post(rv);
        }
    }
}
