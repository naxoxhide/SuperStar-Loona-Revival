package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeqi implements zzhbc {
    private final zzhbp zza;
    private final zzhbp zzb;

    public zzeqi(zzhbp zzhbpVar, zzhbp zzhbpVar2) {
        this.zza = zzhbpVar;
        this.zzb = zzhbpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfvx zzfvxVarZzm;
        zzepy zzepyVarZza = zzeqa.zza();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzb.zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdR)).booleanValue()) {
            zzfvxVarZzm = zzfvx.zzn(new zzese(zzepyVarZza, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdS)).intValue(), scheduledExecutorService));
        } else {
            zzfvxVarZzm = zzfvx.zzm();
        }
        zzhbk.zzb(zzfvxVarZzm);
        return zzfvxVarZzm;
    }
}
