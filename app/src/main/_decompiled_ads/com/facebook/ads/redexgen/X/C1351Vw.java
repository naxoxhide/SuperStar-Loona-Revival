package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.emsg.EventMessage;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1351Vw implements DE {
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 23 out of bounds for length 22
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // com.facebook.ads.redexgen.X.DE
    public final Metadata A4x(D1 d1) {
        ByteBuffer byteBuffer = d1.A01;
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        C0980Hh c0980Hh = new C0980Hh(bArrArray, iLimit);
        String strA0Q = c0980Hh.A0Q();
        String strA0Q2 = c0980Hh.A0Q();
        long jA0M = c0980Hh.A0M();
        return new Metadata(new EventMessage(strA0Q, strA0Q2, C0996Hx.A0F(c0980Hh.A0M(), 1000L, jA0M), c0980Hh.A0M(), Arrays.copyOfRange(bArrArray, c0980Hh.A06(), iLimit), C0996Hx.A0F(c0980Hh.A0M(), 1000000L, jA0M)));
    }
}
