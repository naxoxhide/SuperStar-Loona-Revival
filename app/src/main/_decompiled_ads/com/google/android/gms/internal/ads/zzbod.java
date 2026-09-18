package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbod implements zzbjx {
    final /* synthetic */ zzboe zza;
    private final zzbng zzb;
    private final zzcbl zzc;

    public zzbod(zzboe zzboeVar, zzbng zzbngVar, zzcbl zzcblVar) {
        this.zza = zzboeVar;
        this.zzb = zzbngVar;
        this.zzc = zzcblVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjx
    public final void zza(String str) {
        zzbng zzbngVar;
        try {
            if (str == null) {
                this.zzc.zzd(new zzbnp());
            } else {
                this.zzc.zzd(new zzbnp(str));
            }
            zzbngVar = this.zzb;
        } catch (IllegalStateException unused) {
            zzbngVar = this.zzb;
        } catch (Throwable th) {
            this.zzb.zzb();
            throw th;
        }
        zzbngVar.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbjx
    public final void zzb(JSONObject jSONObject) {
        zzbng zzbngVar;
        try {
            try {
                this.zzc.zzc(this.zza.zza.zza(jSONObject));
                zzbngVar = this.zzb;
            } catch (IllegalStateException unused) {
                zzbngVar = this.zzb;
            } catch (JSONException e) {
                this.zzc.zzd(e);
                zzbngVar = this.zzb;
            }
            zzbngVar.zzb();
        } catch (Throwable th) {
            this.zzb.zzb();
            throw th;
        }
    }
}
