package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbjw implements zzbjx {
    final /* synthetic */ zzcbl zza;

    zzbjw(zzbjy zzbjyVar, zzcbl zzcblVar) {
        this.zza = zzcblVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjx
    public final void zza(String str) {
        this.zza.zzd(new zzbnp(str));
    }

    @Override // com.google.android.gms.internal.ads.zzbjx
    public final void zzb(JSONObject jSONObject) {
        this.zza.zzc(jSONObject);
    }
}
