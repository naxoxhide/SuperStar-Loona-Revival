package com.facebook.ads.redexgen.X;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class V6 implements InterfaceC0968Gv {
    public HandlerC0962Gp<? extends InterfaceC0963Gq> A00;
    public IOException A01;
    public final ExecutorService A02;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 14 out of bounds for length 14
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final <T extends InterfaceC0963Gq> long A04(T t, InterfaceC0961Go<T> interfaceC0961Go, int i) {
        Looper looperMyLooper = Looper.myLooper();
        HI.A04(looperMyLooper != null);
        this.A01 = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new HandlerC0962Gp(this, looperMyLooper, t, interfaceC0961Go, i, jElapsedRealtime).A06(0L);
        return jElapsedRealtime;
    }

    public V6(String str) {
        this.A02 = C0996Hx.A0T(str);
    }

    public final void A05() {
        this.A00.A07(false);
    }

    public final void A06(int i) throws IOException {
        IOException iOException = this.A01;
        if (iOException == null) {
            HandlerC0962Gp<? extends InterfaceC0963Gq> handlerC0962Gp = this.A00;
            if (handlerC0962Gp != null) {
                if (i == Integer.MIN_VALUE) {
                    i = handlerC0962Gp.A03;
                }
                handlerC0962Gp.A05(i);
                return;
            }
            return;
        }
        throw iOException;
    }

    public final void A07(InterfaceC0964Gr interfaceC0964Gr) {
        HandlerC0962Gp<? extends InterfaceC0963Gq> handlerC0962Gp = this.A00;
        if (handlerC0962Gp != null) {
            handlerC0962Gp.A07(true);
        }
        if (interfaceC0964Gr != null) {
            this.A02.execute(new RunnableC0965Gs(interfaceC0964Gr));
        }
        this.A02.shutdown();
    }

    public final boolean A08() {
        return this.A00 != null;
    }
}
