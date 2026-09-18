package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbol implements zzbjx {
    final /* synthetic */ zzbom zza;
    private final zzcbl zzb;

    public zzbol(zzbom zzbomVar, zzcbl zzcblVar) {
        this.zza = zzbomVar;
        this.zzb = zzcblVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjx
    public final void zza(String str) {
        try {
            if (str == null) {
                this.zzb.zzd(new zzbnp());
            } else {
                this.zzb.zzd(new zzbnp(str));
            }
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjx
    public final void zzb(JSONObject jSONObject) {
        try {
            this.zzb.zzc(jSONObject);
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzb.zzd(e);
        }
    }
}
