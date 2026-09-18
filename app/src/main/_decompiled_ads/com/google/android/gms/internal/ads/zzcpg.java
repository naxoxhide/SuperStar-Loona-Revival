package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcpg implements zzcxl, zzcyz, zzcyf, com.google.android.gms.ads.internal.client.zza, zzcyb {
    private final Context zza;
    private final Executor zzb;
    private final Executor zzc;
    private final ScheduledExecutorService zzd;
    private final zzfde zze;
    private final zzfcr zzf;
    private final zzfjt zzg;
    private final zzfdx zzh;
    private final zzaro zzi;
    private final zzbdk zzj;
    private final zzfje zzk;
    private final WeakReference zzl;
    private final WeakReference zzm;
    private final zzcwn zzn;
    private boolean zzo;
    private final AtomicBoolean zzp = new AtomicBoolean();
    private final zzbdm zzq;

    zzcpg(Context context, Executor executor, Executor executor2, ScheduledExecutorService scheduledExecutorService, zzfde zzfdeVar, zzfcr zzfcrVar, zzfjt zzfjtVar, zzfdx zzfdxVar, View view, zzcgb zzcgbVar, zzaro zzaroVar, zzbdk zzbdkVar, zzbdm zzbdmVar, zzfje zzfjeVar, zzcwn zzcwnVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = executor2;
        this.zzd = scheduledExecutorService;
        this.zze = zzfdeVar;
        this.zzf = zzfcrVar;
        this.zzg = zzfjtVar;
        this.zzh = zzfdxVar;
        this.zzi = zzaroVar;
        this.zzl = new WeakReference(view);
        this.zzm = new WeakReference(zzcgbVar);
        this.zzj = zzbdkVar;
        this.zzq = zzbdmVar;
        this.zzk = zzfjeVar;
        this.zzn = zzcwnVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs() {
        String strZzh;
        int i;
        List list;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkE)).booleanValue() && ((list = this.zzf.zzd) == null || list.isEmpty())) {
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdm)).booleanValue()) {
            strZzh = this.zzi.zzc().zzh(this.zza, (View) this.zzl.get(), null);
        } else {
            strZzh = null;
        }
        if ((((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzan)).booleanValue() && this.zze.zzb.zzb.zzg) || !((Boolean) zzbea.zzh.zze()).booleanValue()) {
            zzfdx zzfdxVar = this.zzh;
            zzfjt zzfjtVar = this.zzg;
            zzfde zzfdeVar = this.zze;
            zzfcr zzfcrVar = this.zzf;
            zzfdxVar.zza(zzfjtVar.zzd(zzfdeVar, zzfcrVar, false, strZzh, null, zzfcrVar.zzd));
            return;
        }
        if (((Boolean) zzbea.zzg.zze()).booleanValue() && ((i = this.zzf.zzb) == 1 || i == 2 || i == 5)) {
        }
        zzfzt.zzr((zzfzk) zzfzt.zzo(zzfzk.zzu(zzfzt.zzh(null)), ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaU)).longValue(), TimeUnit.MILLISECONDS, this.zzd), new zzcpf(this, strZzh), this.zzb);
    }

    private final void zzt(final int i, final int i2) {
        View view;
        if (i <= 0 || !((view = (View) this.zzl.get()) == null || view.getHeight() == 0 || view.getWidth() == 0)) {
            zzs();
        } else {
            this.zzd.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcpd
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzo(i, i2);
                }
            }, i2, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        if (!(((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzan)).booleanValue() && this.zze.zzb.zzb.zzg) && ((Boolean) zzbea.zzd.zze()).booleanValue()) {
            zzfzt.zzr(zzfzt.zze(zzfzk.zzu(this.zzj.zza()), Throwable.class, new zzfsk() { // from class: com.google.android.gms.internal.ads.zzcpa
                @Override // com.google.android.gms.internal.ads.zzfsk
                public final Object apply(Object obj) {
                    return "failure_click_attok";
                }
            }, zzcbg.zzf), new zzcpe(this), this.zzb);
            return;
        }
        zzfdx zzfdxVar = this.zzh;
        zzfjt zzfjtVar = this.zzg;
        zzfde zzfdeVar = this.zze;
        zzfcr zzfcrVar = this.zzf;
        zzfdxVar.zzc(zzfjtVar.zzc(zzfdeVar, zzfcrVar, zzfcrVar.zzc), true == com.google.android.gms.ads.internal.zzt.zzo().zzx(this.zza) ? 2 : 1);
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zza() {
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzbw(zzbvw zzbvwVar, String str, String str2) {
        zzfjt zzfjtVar = this.zzg;
        zzfcr zzfcrVar = this.zzf;
        this.zzh.zza(zzfjtVar.zze(zzfcrVar, zzfcrVar.zzj, zzbvwVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzc() {
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zze() {
        zzfjt zzfjtVar = this.zzg;
        zzfde zzfdeVar = this.zze;
        zzfcr zzfcrVar = this.zzf;
        this.zzh.zza(zzfjtVar.zzc(zzfdeVar, zzfcrVar, zzfcrVar.zzk));
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzf() {
        zzfjt zzfjtVar = this.zzg;
        zzfde zzfdeVar = this.zze;
        zzfcr zzfcrVar = this.zzf;
        this.zzh.zza(zzfjtVar.zzc(zzfdeVar, zzfcrVar, zzfcrVar.zzi));
    }

    final /* synthetic */ void zzm() {
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcpc
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzs();
            }
        });
    }

    final /* synthetic */ void zzn(int i, int i2) {
        zzt(i - 1, i2);
    }

    final /* synthetic */ void zzo(final int i, final int i2) {
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcpb
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzn(i, i2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcyb
    public final void zzp(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbt)).booleanValue()) {
            this.zzh.zza(this.zzg.zzc(this.zze, this.zzf, zzfjt.zzf(2, zzeVar.zza, this.zzf.zzq)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyf
    public final void zzq() {
        if (this.zzp.compareAndSet(false, true)) {
            int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdv)).intValue();
            if (iIntValue > 0) {
                zzt(iIntValue, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdw)).intValue());
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdu)).booleanValue()) {
                this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcoz
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzm();
                    }
                });
            } else {
                zzs();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyz
    public final synchronized void zzr() {
        zzcwn zzcwnVar;
        if (this.zzo) {
            ArrayList arrayList = new ArrayList(this.zzf.zzd);
            arrayList.addAll(this.zzf.zzg);
            this.zzh.zza(this.zzg.zzd(this.zze, this.zzf, true, null, null, arrayList));
        } else {
            zzfdx zzfdxVar = this.zzh;
            zzfjt zzfjtVar = this.zzg;
            zzfde zzfdeVar = this.zze;
            zzfcr zzfcrVar = this.zzf;
            zzfdxVar.zza(zzfjtVar.zzc(zzfdeVar, zzfcrVar, zzfcrVar.zzo));
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdr)).booleanValue() && (zzcwnVar = this.zzn) != null) {
                List listZzh = zzfjt.zzh(zzfjt.zzg(zzcwnVar.zzb().zzo, zzcwnVar.zza().zzg()), this.zzn.zza().zza());
                zzfdx zzfdxVar2 = this.zzh;
                zzfjt zzfjtVar2 = this.zzg;
                zzcwn zzcwnVar2 = this.zzn;
                zzfdxVar2.zza(zzfjtVar2.zzc(zzcwnVar2.zzc(), zzcwnVar2.zzb(), listZzh));
            }
            zzfdx zzfdxVar3 = this.zzh;
            zzfjt zzfjtVar3 = this.zzg;
            zzfde zzfdeVar2 = this.zze;
            zzfcr zzfcrVar2 = this.zzf;
            zzfdxVar3.zza(zzfjtVar3.zzc(zzfdeVar2, zzfcrVar2, zzfcrVar2.zzg));
        }
        this.zzo = true;
    }
}
