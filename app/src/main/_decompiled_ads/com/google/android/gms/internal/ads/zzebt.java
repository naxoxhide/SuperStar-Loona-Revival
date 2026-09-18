package com.google.android.gms.internal.ads;

import com.unity3d.services.ads.gmascar.utils.ScarConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzebt implements zzdei {
    private final String zzc;
    private final zzfib zzd;
    private boolean zza = false;
    private boolean zzb = false;
    private final com.google.android.gms.ads.internal.util.zzg zze = com.google.android.gms.ads.internal.zzt.zzo().zzh();

    public zzebt(String str, zzfib zzfibVar) {
        this.zzc = str;
        this.zzd = zzfibVar;
    }

    private final zzfia zzg(String str) {
        String str2 = this.zze.zzQ() ? "" : this.zzc;
        zzfia zzfiaVarZzb = zzfia.zzb(str);
        zzfiaVarZzb.zza("tms", Long.toString(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime(), 10));
        zzfiaVarZzb.zza(ScarConstants.TOKEN_ID_KEY, str2);
        return zzfiaVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdei
    public final void zza(String str) {
        zzfia zzfiaVarZzg = zzg("aaia");
        zzfiaVarZzg.zza("aair", "MalformedJson");
        this.zzd.zzb(zzfiaVarZzg);
    }

    @Override // com.google.android.gms.internal.ads.zzdei
    public final void zzb(String str, String str2) {
        zzfia zzfiaVarZzg = zzg("adapter_init_finished");
        zzfiaVarZzg.zza("ancn", str);
        zzfiaVarZzg.zza("rqe", str2);
        this.zzd.zzb(zzfiaVarZzg);
    }

    @Override // com.google.android.gms.internal.ads.zzdei
    public final void zzc(String str) {
        zzfia zzfiaVarZzg = zzg("adapter_init_started");
        zzfiaVarZzg.zza("ancn", str);
        this.zzd.zzb(zzfiaVarZzg);
    }

    @Override // com.google.android.gms.internal.ads.zzdei
    public final void zzd(String str) {
        zzfia zzfiaVarZzg = zzg("adapter_init_finished");
        zzfiaVarZzg.zza("ancn", str);
        this.zzd.zzb(zzfiaVarZzg);
    }

    @Override // com.google.android.gms.internal.ads.zzdei
    public final synchronized void zze() {
        if (this.zzb) {
            return;
        }
        this.zzd.zzb(zzg("init_finished"));
        this.zzb = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdei
    public final synchronized void zzf() {
        if (this.zza) {
            return;
        }
        this.zzd.zzb(zzg("init_started"));
        this.zza = true;
    }
}
