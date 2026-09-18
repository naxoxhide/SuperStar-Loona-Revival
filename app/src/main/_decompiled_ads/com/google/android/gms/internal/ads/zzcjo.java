package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcjo extends zzevl {
    private final zzeuz zza;
    private final zzcjs zzb;
    private final zzcjo zzc = this;
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

    /* synthetic */ zzcjo(zzcjs zzcjsVar, zzeuz zzeuzVar, zzcjn zzcjnVar) {
        this.zzb = zzcjsVar;
        this.zza = zzeuzVar;
        this.zzd = zzhbb.zzc(new zzfjf(zzcjsVar.zzG));
        zzevh zzevhVar = new zzevh(zzeuzVar);
        this.zze = zzevhVar;
        zzhbp zzhbpVarZzc = zzhbb.zzc(zzdrn.zza());
        this.zzf = zzhbpVarZzc;
        zzhbp zzhbpVarZzc2 = zzhbb.zzc(zzdrl.zza());
        this.zzg = zzhbpVarZzc2;
        zzhbp zzhbpVarZzc3 = zzhbb.zzc(zzdrp.zza());
        this.zzh = zzhbpVarZzc3;
        zzhbp zzhbpVarZzc4 = zzhbb.zzc(zzdrr.zza());
        this.zzi = zzhbpVarZzc4;
        zzhbf zzhbfVarZzc = zzhbg.zzc(4);
        zzhbfVarZzc.zzb(zzfhl.GMS_SIGNALS, zzhbpVarZzc);
        zzhbfVarZzc.zzb(zzfhl.BUILD_URL, zzhbpVarZzc2);
        zzhbfVarZzc.zzb(zzfhl.HTTP, zzhbpVarZzc3);
        zzhbfVarZzc.zzb(zzfhl.PRE_PROCESS, zzhbpVarZzc4);
        zzhbg zzhbgVarZzc = zzhbfVarZzc.zzc();
        this.zzj = zzhbgVarZzc;
        zzhbp zzhbpVarZzc5 = zzhbb.zzc(new zzdrs(zzevhVar, zzcjsVar.zzg, zzfgm.zza(), zzhbgVarZzc));
        this.zzk = zzhbpVarZzc5;
        zzhbm zzhbmVarZza = zzhbn.zza(0, 1);
        zzhbmVarZza.zza(zzhbpVarZzc5);
        zzhbn zzhbnVarZzc = zzhbmVarZza.zzc();
        this.zzl = zzhbnVarZzc;
        zzfhu zzfhuVar = new zzfhu(zzhbnVarZzc);
        this.zzm = zzfhuVar;
        this.zzn = zzhbb.zzc(new zzfht(zzfgm.zza(), zzcjsVar.zzm, zzfhuVar));
    }

    @Override // com.google.android.gms.internal.ads.zzevl
    public final zzetz zza() {
        Context contextZza = this.zzb.zza.zza();
        zzhbk.zzb(contextZza);
        zzgad zzgadVar = zzcbg.zza;
        zzhbk.zzb(zzgadVar);
        zzbzq zzbzqVar = new zzbzq();
        zzgad zzgadVar2 = zzcbg.zza;
        zzhbk.zzb(zzgadVar2);
        zzetw zzetwVarZza = zzexf.zza(new zzewj(zzbzqVar, zzgadVar2, zzeva.zza(this.zza)), zzery.zza(), (ScheduledExecutorService) this.zzb.zzm.zzb(), 0);
        zzbsz zzbszVar = new zzbsz();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzb.zzm.zzb();
        Context contextZza2 = this.zzb.zza.zza();
        zzhbk.zzb(contextZza2);
        zzetw zzetwVarZzb = zzexf.zzb(new zzewt(zzbszVar, scheduledExecutorService, contextZza2), (ScheduledExecutorService) this.zzb.zzm.zzb());
        zzbzt zzbztVar = new zzbzt();
        Context contextZza3 = this.zzb.zza.zza();
        zzhbk.zzb(contextZza3);
        ScheduledExecutorService scheduledExecutorService2 = (ScheduledExecutorService) this.zzb.zzm.zzb();
        zzgad zzgadVar3 = zzcbg.zza;
        zzhbk.zzb(zzgadVar3);
        zzeuz zzeuzVar = this.zza;
        zzetw zzetwVarZza2 = zzexg.zza(zzeut.zza(zzbztVar, contextZza3, scheduledExecutorService2, zzgadVar3, zzevb.zza(zzeuzVar), zzevd.zza(zzeuzVar), zzeve.zza(zzeuzVar)), (ScheduledExecutorService) this.zzb.zzm.zzb());
        zzgad zzgadVar4 = zzcbg.zza;
        zzhbk.zzb(zzgadVar4);
        zzetw zzetwVarZzc = zzexf.zzc(new zzexo(zzgadVar4), (ScheduledExecutorService) this.zzb.zzm.zzb());
        zzexd zzexdVar = zzexd.zza;
        Context contextZza4 = this.zzb.zza.zza();
        zzhbk.zzb(contextZza4);
        String strZza = zzeva.zza(this.zza);
        zzgad zzgadVar5 = zzcbg.zza;
        zzhbk.zzb(zzgadVar5);
        zzevn zzevnVar = new zzevn(null, contextZza4, strZza, zzgadVar5);
        zzaxk zzaxkVar = new zzaxk();
        zzgad zzgadVar6 = zzcbg.zza;
        zzhbk.zzb(zzgadVar6);
        Context contextZza5 = this.zzb.zza.zza();
        zzhbk.zzb(contextZza5);
        zzbbt zzbbtVar = new zzbbt();
        zzgad zzgadVar7 = zzcbg.zza;
        zzhbk.zzb(zzgadVar7);
        zzbzt zzbztVar2 = new zzbzt();
        zzgad zzgadVar8 = zzcbg.zza;
        zzhbk.zzb(zzgadVar8);
        zzeuz zzeuzVar2 = this.zza;
        zzbzt zzbztVar3 = new zzbzt();
        zzeuz zzeuzVar3 = this.zza;
        zzcjs zzcjsVar = this.zzb;
        int iZza = zzevb.zza(zzeuzVar3);
        Context contextZza6 = zzcjsVar.zza.zza();
        zzhbk.zzb(contextZza6);
        zzcac zzcacVar = (zzcac) this.zzb.zzah.zzb();
        ScheduledExecutorService scheduledExecutorService3 = (ScheduledExecutorService) this.zzb.zzm.zzb();
        zzgad zzgadVar9 = zzcbg.zza;
        zzhbk.zzb(zzgadVar9);
        String strZza2 = zzeva.zza(this.zza);
        zzawy zzawyVar = new zzawy();
        zzcac zzcacVar2 = (zzcac) this.zzb.zzah.zzb();
        ScheduledExecutorService scheduledExecutorService4 = (ScheduledExecutorService) this.zzb.zzm.zzb();
        zzgad zzgadVar10 = zzcbg.zza;
        zzhbk.zzb(zzgadVar10);
        return new zzetz(contextZza, zzgadVar, zzfvx.zzp(zzetwVarZza, zzetwVarZzb, zzetwVarZza2, zzetwVarZzc, zzexdVar, zzevnVar, new zzewc(zzaxkVar, zzgadVar6, contextZza5), new zzewn(zzbbtVar, zzgadVar7, zzevc.zza(this.zza)), new zzeux(zzbztVar2, zzgadVar8, zzevf.zza(zzeuzVar2), zzevg.zza(zzeuzVar2), zzevb.zza(zzeuzVar2)), new zzevy(zzbztVar3, iZza, contextZza6, zzcacVar, scheduledExecutorService3, zzgadVar9, zzeva.zza(this.zza)), (zzetw) this.zzb.zzaK.zzb(), zzevu.zza(strZza2, zzawyVar, zzcacVar2, scheduledExecutorService4, zzgadVar10)), (zzfje) this.zzd.zzb(), (zzdso) this.zzb.zzZ.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzevl
    public final zzfhr zzb() {
        return (zzfhr) this.zzn.zzb();
    }
}
