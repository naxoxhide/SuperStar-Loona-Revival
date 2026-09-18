package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcjg extends zzeuu {
    private final zzhbp zzA;
    private final zzhbp zzB;
    private final zzeww zza;
    private final zzcjs zzb;
    private final zzcjg zzc = this;
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
    private final zzhbp zzo;
    private final zzhbp zzp;
    private final zzhbp zzq;
    private final zzhbp zzr;
    private final zzhbp zzs;
    private final zzhbp zzt;
    private final zzhbp zzu;
    private final zzhbp zzv;
    private final zzhbp zzw;
    private final zzhbp zzx;
    private final zzhbp zzy;
    private final zzhbp zzz;

    /* synthetic */ zzcjg(zzcjs zzcjsVar, zzeww zzewwVar, zzcjf zzcjfVar) {
        this.zzb = zzcjsVar;
        this.zza = zzewwVar;
        this.zzd = zzhbb.zzc(new zzfjf(zzcjsVar.zzG));
        zzewy zzewyVar = new zzewy(zzewwVar);
        this.zze = zzewyVar;
        zzewz zzewzVar = new zzewz(zzewwVar);
        this.zzf = zzewzVar;
        zzexb zzexbVar = new zzexb(zzewwVar);
        this.zzg = zzexbVar;
        this.zzh = new zzeut(zzcnd.zza, zzcjsVar.zzg, zzcjsVar.zzm, zzfgm.zza(), zzewyVar, zzewzVar, zzexbVar);
        zzewx zzewxVar = new zzewx(zzewwVar);
        this.zzi = zzewxVar;
        this.zzj = new zzevp(zzcir.zza, zzcjsVar.zzg, zzewxVar, zzfgm.zza());
        this.zzk = new zzewa(zzcnd.zza, zzewyVar, zzcjsVar.zzg, zzcjsVar.zzah, zzcjsVar.zzm, zzfgm.zza(), zzewxVar);
        this.zzl = new zzewe(zzcmx.zza, zzfgm.zza(), zzcjsVar.zzg);
        this.zzm = new zzewl(zzcmz.zza, zzfgm.zza(), zzewxVar);
        this.zzn = new zzewv(zzcnb.zza, zzcjsVar.zzm, zzcjsVar.zzg);
        this.zzo = new zzexq(zzfgm.zza());
        zzexa zzexaVar = new zzexa(zzewwVar);
        this.zzp = zzexaVar;
        this.zzq = new zzexm(zzcjsVar.zzah, zzexaVar, zzexbVar, zzcnf.zza, zzfgm.zza(), zzewxVar, zzcjsVar.zzm);
        this.zzr = new zzevu(zzewxVar, zzcmv.zza, zzcjsVar.zzah, zzcjsVar.zzm, zzfgm.zza());
        zzexc zzexcVar = new zzexc(zzewwVar);
        this.zzs = zzexcVar;
        zzhbp zzhbpVarZzc = zzhbb.zzc(zzdrn.zza());
        this.zzt = zzhbpVarZzc;
        zzhbp zzhbpVarZzc2 = zzhbb.zzc(zzdrl.zza());
        this.zzu = zzhbpVarZzc2;
        zzhbp zzhbpVarZzc3 = zzhbb.zzc(zzdrp.zza());
        this.zzv = zzhbpVarZzc3;
        zzhbp zzhbpVarZzc4 = zzhbb.zzc(zzdrr.zza());
        this.zzw = zzhbpVarZzc4;
        zzhbf zzhbfVarZzc = zzhbg.zzc(4);
        zzhbfVarZzc.zzb(zzfhl.GMS_SIGNALS, zzhbpVarZzc);
        zzhbfVarZzc.zzb(zzfhl.BUILD_URL, zzhbpVarZzc2);
        zzhbfVarZzc.zzb(zzfhl.HTTP, zzhbpVarZzc3);
        zzhbfVarZzc.zzb(zzfhl.PRE_PROCESS, zzhbpVarZzc4);
        zzhbg zzhbgVarZzc = zzhbfVarZzc.zzc();
        this.zzx = zzhbgVarZzc;
        zzhbp zzhbpVarZzc5 = zzhbb.zzc(new zzdrs(zzexcVar, zzcjsVar.zzg, zzfgm.zza(), zzhbgVarZzc));
        this.zzy = zzhbpVarZzc5;
        zzhbm zzhbmVarZza = zzhbn.zza(0, 1);
        zzhbmVarZza.zza(zzhbpVarZzc5);
        zzhbn zzhbnVarZzc = zzhbmVarZza.zzc();
        this.zzz = zzhbnVarZzc;
        zzfhu zzfhuVar = new zzfhu(zzhbnVarZzc);
        this.zzA = zzfhuVar;
        this.zzB = zzhbb.zzc(new zzfht(zzfgm.zza(), zzcjsVar.zzm, zzfhuVar));
    }

    private final zzeux zze() {
        zzbzt zzbztVar = new zzbzt();
        zzgad zzgadVar = zzcbg.zza;
        zzhbk.zzb(zzgadVar);
        zzeww zzewwVar = this.zza;
        return new zzeux(zzbztVar, zzgadVar, zzewwVar.zzd(), zzewwVar.zzb(), zzewwVar.zza());
    }

    private final zzewn zzf() {
        zzbbt zzbbtVar = new zzbbt();
        zzgad zzgadVar = zzcbg.zza;
        zzhbk.zzb(zzgadVar);
        List listZzf = this.zza.zzf();
        zzhbk.zzb(listZzf);
        return new zzewn(zzbbtVar, zzgadVar, listZzf);
    }

    @Override // com.google.android.gms.internal.ads.zzeuu
    public final zzetz zza() {
        Context contextZza = this.zzb.zza.zza();
        zzhbk.zzb(contextZza);
        zzbzq zzbzqVar = new zzbzq();
        zzbzr zzbzrVar = new zzbzr();
        Object objZzb = this.zzb.zzaK.zzb();
        zzhbp zzhbpVar = this.zzr;
        zzhbp zzhbpVar2 = this.zzq;
        zzhbp zzhbpVar3 = this.zzo;
        zzhbp zzhbpVar4 = this.zzn;
        zzhbp zzhbpVar5 = this.zzm;
        zzhbp zzhbpVar6 = this.zzl;
        zzhbp zzhbpVar7 = this.zzk;
        zzhbp zzhbpVar8 = this.zzj;
        zzhbp zzhbpVar9 = this.zzh;
        zzeux zzeuxVarZze = zze();
        zzewn zzewnVarZzf = zzf();
        zzhaw zzhawVarZza = zzhbb.zza(zzhbpVar9);
        zzhaw zzhawVarZza2 = zzhbb.zza(zzhbpVar8);
        zzhaw zzhawVarZza3 = zzhbb.zza(zzhbpVar7);
        zzhaw zzhawVarZza4 = zzhbb.zza(zzhbpVar6);
        zzhaw zzhawVarZza5 = zzhbb.zza(zzhbpVar5);
        zzhaw zzhawVarZza6 = zzhbb.zza(zzhbpVar4);
        zzhaw zzhawVarZza7 = zzhbb.zza(zzhbpVar3);
        zzhaw zzhawVarZza8 = zzhbb.zza(zzhbpVar2);
        zzhaw zzhawVarZza9 = zzhbb.zza(zzhbpVar);
        zzgad zzgadVar = zzcbg.zza;
        zzhbk.zzb(zzgadVar);
        return zzexh.zza(contextZza, zzbzqVar, zzbzrVar, objZzb, zzeuxVarZze, zzewnVarZzf, zzhawVarZza, zzhawVarZza2, zzhawVarZza3, zzhawVarZza4, zzhawVarZza5, zzhawVarZza6, zzhawVarZza7, zzhawVarZza8, zzhawVarZza9, zzgadVar, (zzfje) this.zzd.zzb(), (zzdso) this.zzb.zzZ.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzeuu
    public final zzetz zzb() {
        Context contextZza = this.zzb.zza.zza();
        zzhbk.zzb(contextZza);
        zzgad zzgadVar = zzcbg.zza;
        zzhbk.zzb(zzgadVar);
        zzbzq zzbzqVar = new zzbzq();
        zzgad zzgadVar2 = zzcbg.zza;
        zzhbk.zzb(zzgadVar2);
        String strZzc = this.zza.zzc();
        zzhbk.zzb(strZzc);
        zzetw zzetwVarZza = zzexf.zza(new zzewj(zzbzqVar, zzgadVar2, strZzc), zzery.zza(), (ScheduledExecutorService) this.zzb.zzm.zzb(), -1);
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
        zzeww zzewwVar = this.zza;
        zzetw zzetwVarZza2 = zzexg.zza(zzeut.zza(zzbztVar, contextZza3, scheduledExecutorService2, zzgadVar3, zzewwVar.zza(), zzewz.zzc(zzewwVar), zzexb.zzc(zzewwVar)), (ScheduledExecutorService) this.zzb.zzm.zzb());
        zzgad zzgadVar4 = zzcbg.zza;
        zzhbk.zzb(zzgadVar4);
        zzetw zzetwVarZzc = zzexf.zzc(new zzexo(zzgadVar4), (ScheduledExecutorService) this.zzb.zzm.zzb());
        zzexd zzexdVar = zzexd.zza;
        Context contextZza4 = this.zzb.zza.zza();
        zzhbk.zzb(contextZza4);
        String strZzc2 = this.zza.zzc();
        zzhbk.zzb(strZzc2);
        zzgad zzgadVar5 = zzcbg.zza;
        zzhbk.zzb(zzgadVar5);
        zzevn zzevnVar = new zzevn(null, contextZza4, strZzc2, zzgadVar5);
        zzaxk zzaxkVar = new zzaxk();
        zzgad zzgadVar6 = zzcbg.zza;
        zzhbk.zzb(zzgadVar6);
        Context contextZza5 = this.zzb.zza.zza();
        zzhbk.zzb(contextZza5);
        zzbzt zzbztVar2 = new zzbzt();
        zzeww zzewwVar2 = this.zza;
        zzcjs zzcjsVar = this.zzb;
        int iZza = zzewwVar2.zza();
        Context contextZza6 = zzcjsVar.zza.zza();
        zzhbk.zzb(contextZza6);
        zzcac zzcacVar = (zzcac) this.zzb.zzah.zzb();
        ScheduledExecutorService scheduledExecutorService3 = (ScheduledExecutorService) this.zzb.zzm.zzb();
        zzgad zzgadVar7 = zzcbg.zza;
        zzhbk.zzb(zzgadVar7);
        String strZzc3 = this.zza.zzc();
        zzhbk.zzb(strZzc3);
        String strZzc4 = this.zza.zzc();
        zzhbk.zzb(strZzc4);
        zzawy zzawyVar = new zzawy();
        zzcac zzcacVar2 = (zzcac) this.zzb.zzah.zzb();
        ScheduledExecutorService scheduledExecutorService4 = (ScheduledExecutorService) this.zzb.zzm.zzb();
        zzgad zzgadVar8 = zzcbg.zza;
        zzhbk.zzb(zzgadVar8);
        return new zzetz(contextZza, zzgadVar, zzfvx.zzp(zzetwVarZza, zzetwVarZzb, zzetwVarZza2, zzetwVarZzc, zzexdVar, zzevnVar, new zzewc(zzaxkVar, zzgadVar6, contextZza5), zzf(), zze(), new zzevy(zzbztVar2, iZza, contextZza6, zzcacVar, scheduledExecutorService3, zzgadVar7, strZzc3), (zzetw) this.zzb.zzaK.zzb(), zzevu.zza(strZzc4, zzawyVar, zzcacVar2, scheduledExecutorService4, zzgadVar8)), (zzfje) this.zzd.zzb(), (zzdso) this.zzb.zzZ.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzeuu
    public final zzfhr zzc() {
        return (zzfhr) this.zzB.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzeuu
    public final zzfje zzd() {
        return (zzfje) this.zzd.zzb();
    }
}
