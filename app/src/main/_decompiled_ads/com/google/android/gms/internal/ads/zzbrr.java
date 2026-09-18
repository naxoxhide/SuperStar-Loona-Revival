package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbrr implements View.OnClickListener {
    final /* synthetic */ zzbrs zza;

    zzbrr(zzbrs zzbrsVar) {
        this.zza = zzbrsVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zza.zza(true);
    }
}
