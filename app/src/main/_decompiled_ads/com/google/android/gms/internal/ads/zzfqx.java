package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfqx extends zzfrj {
    final /* synthetic */ zzfqy zza;
    private final zzfrd zzb;

    zzfqx(zzfqy zzfqyVar, zzfrd zzfrdVar) {
        this.zza = zzfqyVar;
        this.zzb = zzfrdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfrk
    public final void zzb(Bundle bundle) {
        int i = bundle.getInt("statusCode", 8150);
        String string = bundle.getString("sessionToken");
        zzfrb zzfrbVarZzc = zzfrc.zzc();
        zzfrbVarZzc.zzb(i);
        if (string != null) {
            zzfrbVarZzc.zza(string);
        }
        this.zzb.zza(zzfrbVarZzc.zzc());
        if (i == 8157) {
            this.zza.zzc();
        }
    }
}
