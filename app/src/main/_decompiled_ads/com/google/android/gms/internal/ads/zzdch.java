package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdch implements zzdag {
    private int zza = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbf)).intValue();

    @Override // com.google.android.gms.internal.ads.zzdag
    public final void zzbr(zzbvg zzbvgVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdag
    public final synchronized void zzbs(zzfde zzfdeVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbg)).booleanValue()) {
            try {
                this.zza = zzfdeVar.zzb.zzb.zzc;
            } catch (NullPointerException unused) {
            }
        }
    }

    public final synchronized int zzc() {
        return this.zza;
    }
}
