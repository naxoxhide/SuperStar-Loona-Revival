package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbro implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbrq zza;

    zzbro(zzbrq zzbrqVar) {
        this.zza = zzbrqVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        zzbrq zzbrqVar = this.zza;
        Intent intentZzb = zzbrqVar.zzb();
        com.google.android.gms.ads.internal.zzt.zzp();
        com.google.android.gms.ads.internal.util.zzt.zzS(zzbrqVar.zzb, intentZzb);
    }
}
