package com.facebook.ads.redexgen.X;

import android.content.Context;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class VG implements InterfaceC0950Gb {
    public final Context A00;
    public final InterfaceC0950Gb A01;
    public final InterfaceC0971Gy<? super InterfaceC0951Gc> A02;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Gy != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.thirdparty.upstream.DataSource> */
    public VG(Context context, InterfaceC0971Gy<? super InterfaceC0951Gc> interfaceC0971Gy, InterfaceC0950Gb interfaceC0950Gb) {
        this.A00 = context.getApplicationContext();
        this.A02 = interfaceC0971Gy;
        this.A01 = interfaceC0950Gb;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Gy != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.thirdparty.upstream.DataSource> */
    public VG(Context context, String str, InterfaceC0971Gy<? super InterfaceC0951Gc> interfaceC0971Gy) {
        this(context, interfaceC0971Gy, new C2P(str, interfaceC0971Gy));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0950Gb
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final VH A4U() {
        return new VH(this.A00, this.A02, this.A01.A4U());
    }
}
