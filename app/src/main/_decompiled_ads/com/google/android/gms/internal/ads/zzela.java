package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzela {
    private final zzdgx zza;

    public zzela(zzdgx zzdgxVar) {
        this.zza = zzdgxVar;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfde zzfdeVar, zzfcr zzfcrVar, View view, zzekw zzekwVar) {
        zzeky zzekyVar = new zzeky(this, new zzdhf() { // from class: com.google.android.gms.internal.ads.zzekx
            @Override // com.google.android.gms.internal.ads.zzdhf
            public final void zza(boolean z, Context context, zzcxy zzcxyVar) {
            }
        });
        zzdfx zzdfxVarZze = this.zza.zze(new zzctm(zzfdeVar, zzfcrVar, null), zzekyVar);
        zzekwVar.zzd(new zzekz(this, zzdfxVarZze));
        return zzdfxVarZze.zzg();
    }
}
