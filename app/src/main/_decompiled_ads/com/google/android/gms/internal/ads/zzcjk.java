package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcjk extends zzevj {
    private final zzewp zza;
    private final zzcjs zzb;
    private final zzcjk zzc = this;
    private final zzhbp zzd;
    private final zzhbp zze;
    private final zzhbp zzf;
    private final zzhbp zzg;
    private final zzhbp zzh;
    private final zzhbp zzi;
    private final zzhbp zzj;
    private final zzhbp zzk;
    private final zzhbp zzl;
    private final zzhbp zzm;
    private final zzhbp zzn;

    /* synthetic */ zzcjk(zzcjs zzcjsVar, zzewp zzewpVar, zzcjj zzcjjVar) {
        this.zzb = zzcjsVar;
        this.zza = zzewpVar;
        zzewr zzewrVar = new zzewr(zzewpVar);
        this.zzd = zzewrVar;
        zzhbp zzhbpVarZzc = zzhbb.zzc(zzdrn.zza());
        this.zze = zzhbpVarZzc;
        zzhbp zzhbpVarZzc2 = zzhbb.zzc(zzdrl.zza());
        this.zzf = zzhbpVarZzc2;
        zzhbp zzhbpVarZzc3 = zzhbb.zzc(zzdrp.zza());
        this.zzg = zzhbpVarZzc3;
        zzhbp zzhbpVarZzc4 = zzhbb.zzc(zzdrr.zza());
        this.zzh = zzhbpVarZzc4;
        zzhbf zzhbfVarZzc = zzhbg.zzc(4);
        zzhbfVarZzc.zzb(zzfhl.GMS_SIGNALS, zzhbpVarZzc);
        zzhbfVarZzc.zzb(zzfhl.BUILD_URL, zzhbpVarZzc2);
        zzhbfVarZzc.zzb(zzfhl.HTTP, zzhbpVarZzc3);
        zzhbfVarZzc.zzb(zzfhl.PRE_PROCESS, zzhbpVarZzc4);
        zzhbg zzhbgVarZzc = zzhbfVarZzc.zzc();
        this.zzi = zzhbgVarZzc;
        zzhbp zzhbpVarZzc5 = zzhbb.zzc(new zzdrs(zzewrVar, zzcjsVar.zzg, zzfgm.zza(), zzhbgVarZzc));
        this.zzj = zzhbpVarZzc5;
        zzhbm zzhbmVarZza = zzhbn.zza(0, 1);
        zzhbmVarZza.zza(zzhbpVarZzc5);
        zzhbn zzhbnVarZzc = zzhbmVarZza.zzc();
        this.zzk = zzhbnVarZzc;
        zzfhu zzfhuVar = new zzfhu(zzhbnVarZzc);
        this.zzl = zzfhuVar;
        this.zzm = zzhbb.zzc(new zzfht(zzfgm.zza(), zzcjsVar.zzm, zzfhuVar));
        this.zzn = zzhbb.zzc(new zzfjf(zzcjsVar.zzG));
    }

    @Override // com.google.android.gms.internal.ads.zzevj
    public final zzetz zza() {
        Context contextZza = this.zzb.zza.zza();
        zzhbk.zzb(contextZza);
        zzbzq zzbzqVar = new zzbzq();
        zzgad zzgadVar = zzcbg.zza;
        zzhbk.zzb(zzgadVar);
        zzewj zzewjVar = new zzewj(zzbzqVar, zzgadVar, zzewq.zza(this.zza));
        zzgad zzgadVar2 = zzcbg.zza;
        zzhbk.zzb(zzgadVar2);
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzb.zzm.zzb();
        zzfje zzfjeVar = (zzfje) this.zzn.zzb();
        zzdso zzdsoVar = (zzdso) this.zzb.zzZ.zzb();
        HashSet hashSet = new HashSet();
        hashSet.add(new zzese(zzewjVar, 0L, scheduledExecutorService));
        return new zzetz(contextZza, zzgadVar2, hashSet, zzfjeVar, zzdsoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzevj
    public final zzfhr zzb() {
        return (zzfhr) this.zzm.zzb();
    }
}
