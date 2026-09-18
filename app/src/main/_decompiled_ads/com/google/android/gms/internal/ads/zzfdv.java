package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfdv implements zzfzp {
    final /* synthetic */ zzcgb zza;
    final /* synthetic */ zzcou zzb;
    final /* synthetic */ zzfjx zzc;
    final /* synthetic */ zzedo zzd;

    zzfdv(zzcgb zzcgbVar, zzcou zzcouVar, zzfjx zzfjxVar, zzedo zzedoVar) {
        this.zza = zzcgbVar;
        this.zzb = zzcouVar;
        this.zzc = zzfjxVar;
        this.zzd = zzedoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zza(Throwable th) {
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0072  */
    @Override // com.google.android.gms.internal.ads.zzfzp
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        if (!this.zza.zzD().zzak) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzju)).booleanValue()) {
                this.zzb.zzi(str, this.zzc, com.google.android.gms.ads.internal.client.zzay.zze());
                return;
            } else {
                this.zzc.zzc(str, null);
                return;
            }
        }
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
        String str2 = this.zza.zzP().zzb;
        int i = 1;
        if (com.google.android.gms.ads.internal.zzt.zzo().zzx(this.zza.getContext())) {
            i = 2;
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgk)).booleanValue() && this.zza.zzD().zzU) {
                i = 2;
            }
        }
        this.zzd.zzd(new zzedq(jCurrentTimeMillis, str2, str, i));
    }
}
