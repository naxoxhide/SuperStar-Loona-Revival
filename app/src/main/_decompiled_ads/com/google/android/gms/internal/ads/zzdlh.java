package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdlh implements zzfzp {
    final /* synthetic */ zzdli zza;

    zzdlh(zzdli zzdliVar) {
        this.zza = zzdliVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.zzt.zzo().zzu(th, "omid native display exp");
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final void zzb(List list) {
        try {
            zzcgb zzcgbVar = (zzcgb) list.get(0);
            if (zzcgbVar != null) {
                this.zza.zzb(zzcgbVar);
            }
        } catch (ClassCastException | IndexOutOfBoundsException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "omid native display exp");
        }
    }
}
