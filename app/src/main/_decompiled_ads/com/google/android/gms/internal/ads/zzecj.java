package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzecj implements zzcyz, zzcxo {
    private static final Object zza = new Object();
    private static int zzb;
    private final com.google.android.gms.ads.internal.util.zzg zzc;
    private final zzect zzd;

    public zzecj(zzect zzectVar, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zzd = zzectVar;
        this.zzc = zzgVar;
    }

    private final void zzb(boolean z) {
        int i;
        int iIntValue;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgf)).booleanValue() && !this.zzc.zzQ()) {
            Object obj = zza;
            synchronized (obj) {
                i = zzb;
                iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgg)).intValue();
            }
            if (i >= iIntValue) {
                return;
            }
            this.zzd.zzd(z);
            synchronized (obj) {
                zzb++;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxo
    public final void zzbF(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzb(false);
    }

    @Override // com.google.android.gms.internal.ads.zzcyz
    public final void zzr() {
        zzb(true);
    }
}
