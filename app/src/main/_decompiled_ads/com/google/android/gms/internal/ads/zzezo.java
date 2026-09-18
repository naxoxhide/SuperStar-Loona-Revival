package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzezo implements zzfai {
    private final zzfai zza;
    private final zzfai zzb;
    private final zzffw zzc;
    private final String zzd;
    private zzcws zze;
    private final Executor zzf;

    public zzezo(zzfai zzfaiVar, zzfai zzfaiVar2, zzffw zzffwVar, String str, Executor executor) {
        this.zza = zzfaiVar;
        this.zzb = zzfaiVar2;
        this.zzc = zzffwVar;
        this.zzd = str;
        this.zzf = executor;
    }

    private final ListenableFuture zzg(zzffj zzffjVar, zzfaj zzfajVar) {
        zzcws zzcwsVar = zzffjVar.zza;
        this.zze = zzcwsVar;
        if (zzffjVar.zzc != null) {
            if (zzcwsVar.zzf() != null) {
                zzffjVar.zzc.zzo().zzl(zzffjVar.zza.zzf());
            }
            return zzfzt.zzh(zzffjVar.zzc);
        }
        zzcwsVar.zzb().zzl(zzffjVar.zzb);
        return ((zzezy) this.zza).zzb(zzfajVar, null, zzffjVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfai
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzcws zzd() {
        return this.zze;
    }

    final /* synthetic */ ListenableFuture zzb(zzfaj zzfajVar, zzezn zzeznVar, zzfah zzfahVar, zzcws zzcwsVar, zzezt zzeztVar) throws Exception {
        if (zzeztVar != null) {
            zzezn zzeznVar2 = new zzezn(zzeznVar.zza, zzeznVar.zzb, zzeznVar.zzc, zzeznVar.zzd, zzeznVar.zze, zzeznVar.zzf, zzeztVar.zza);
            if (zzeztVar.zzc != null) {
                this.zze = null;
                this.zzc.zze(zzeznVar2);
                return zzg(zzeztVar.zzc, zzfajVar);
            }
            ListenableFuture listenableFutureZza = this.zzc.zza(zzeznVar2);
            if (listenableFutureZza != null) {
                this.zze = null;
                return zzfzt.zzn(listenableFutureZza, new zzfza() { // from class: com.google.android.gms.internal.ads.zzezk
                    @Override // com.google.android.gms.internal.ads.zzfza
                    public final ListenableFuture zza(Object obj) {
                        return this.zza.zze((zzfft) obj);
                    }
                }, this.zzf);
            }
            this.zzc.zze(zzeznVar2);
            zzfajVar = new zzfaj(zzfajVar.zzb, zzeztVar.zzb);
        }
        ListenableFuture listenableFutureZzb = ((zzezy) this.zza).zzb(zzfajVar, zzfahVar, zzcwsVar);
        this.zze = zzcwsVar;
        return listenableFutureZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfai
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfaj zzfajVar, zzfah zzfahVar, Object obj) {
        return zzf(zzfajVar, zzfahVar, null);
    }

    final /* synthetic */ ListenableFuture zze(zzfft zzfftVar) throws Exception {
        zzffv zzffvVar;
        if (zzfftVar == null || zzfftVar.zza == null || (zzffvVar = zzfftVar.zzb) == null) {
            throw new zzdwm(1, "Empty prefetch");
        }
        zzayk zzaykVarZza = zzayq.zza();
        zzayi zzayiVarZza = zzayj.zza();
        zzayiVarZza.zzd(2);
        zzayiVarZza.zzb(zzayn.zzd());
        zzaykVarZza.zza(zzayiVarZza);
        zzfftVar.zza.zza.zzb().zzc().zzm((zzayq) zzaykVarZza.zzal());
        return zzg(zzfftVar.zza, ((zzezn) zzffvVar).zzb);
    }

    public final synchronized ListenableFuture zzf(final zzfaj zzfajVar, final zzfah zzfahVar, zzcws zzcwsVar) {
        zzcwr zzcwrVarZza = zzfahVar.zza(zzfajVar.zzb);
        zzcwrVarZza.zza(new zzezp(this.zzd));
        final zzcws zzcwsVar2 = (zzcws) zzcwrVarZza.zzh();
        zzcwsVar2.zzg();
        zzcwsVar2.zzg();
        com.google.android.gms.ads.internal.client.zzl zzlVar = zzcwsVar2.zzg().zzd;
        if (zzlVar.zzs == null && zzlVar.zzx == null) {
            zzfdn zzfdnVarZzg = zzcwsVar2.zzg();
            final zzezn zzeznVar = new zzezn(zzfahVar, zzfajVar, zzfdnVarZzg.zzd, zzfdnVarZzg.zzf, this.zzf, zzfdnVarZzg.zzj, null);
            return zzfzt.zzn(zzfzk.zzu(((zzezu) this.zzb).zzb(zzfajVar, zzfahVar, zzcwsVar2)), new zzfza() { // from class: com.google.android.gms.internal.ads.zzezl
                @Override // com.google.android.gms.internal.ads.zzfza
                public final ListenableFuture zza(Object obj) {
                    return this.zza.zzb(zzfajVar, zzeznVar, zzfahVar, zzcwsVar2, (zzezt) obj);
                }
            }, this.zzf);
        }
        this.zze = zzcwsVar2;
        return ((zzezy) this.zza).zzb(zzfajVar, zzfahVar, zzcwsVar2);
    }
}
