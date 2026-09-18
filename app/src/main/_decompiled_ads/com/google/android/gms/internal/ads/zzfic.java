package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfic implements zzhbc {
    private final zzhbp zza;
    private final zzhbp zzb;
    private final zzhbp zzc;

    public zzfic(zzhbp zzhbpVar, zzhbp zzhbpVar2, zzhbp zzhbpVar3) {
        this.zza = zzhbpVar;
        this.zzb = zzhbpVar2;
        this.zzc = zzhbpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzhaw zzhawVarZza = zzhbb.zza(this.zza);
        zzhaw zzhawVarZza2 = zzhbb.zza(this.zzb);
        Object zzfieVar = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzis)).booleanValue() ? new zzfie((zzfib) zzhawVarZza.zzb(), (ScheduledExecutorService) this.zzc.zzb()) : (zzfib) zzhawVarZza2.zzb();
        zzhbk.zzb(zzfieVar);
        return zzfieVar;
    }
}
