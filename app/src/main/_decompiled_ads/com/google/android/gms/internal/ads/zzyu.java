package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import android.util.Pair;
import android.view.Surface;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzyu implements zzaah, zzdj {
    private final Context zza;
    private final zzaaf zzb;
    private final zzdk zzc;
    private final zzet zzd = new zzet(16);
    private final zzfh zze = new zzfh(10);
    private final zzfh zzf = new zzfh(10);
    private final Handler zzg;
    private final ArrayList zzh;
    private final zzae zzi;
    private zzaae zzj;
    private Executor zzk;
    private zzzj zzl;
    private zzam zzm;
    private Pair zzn;
    private final zzdm zzo;
    private final zzdm zzp;
    private boolean zzq;

    public zzyu(Context context, zzdi zzdiVar, zzaaf zzaafVar, zzam zzamVar) throws zzdh {
        zzs zzsVarZzd;
        int i;
        int i2;
        this.zza = context;
        this.zzb = zzaafVar;
        zzfk.zzG(context);
        this.zzo = zzdm.zza;
        this.zzp = zzdm.zza;
        zzae zzaeVarZza = null;
        final Handler handlerZzv = zzfk.zzv(null);
        this.zzg = handlerZzv;
        zzs zzsVar = zzamVar.zzy;
        if (zzsVar == null || ((i2 = zzsVar.zzf) != 7 && i2 != 6)) {
            zzsVar = zzs.zza;
        }
        zzs zzsVar2 = zzsVar;
        if (zzsVar2.zzf == 7) {
            zzr zzrVarZzc = zzsVar2.zzc();
            zzrVarZzc.zzc(6);
            zzsVarZzd = zzrVarZzc.zzd();
        } else {
            zzsVarZzd = zzsVar2;
        }
        this.zzc = zzdiVar.zza(context, zzv.zzb, zzsVar2, zzsVarZzd, false, new Executor() { // from class: com.google.android.gms.internal.ads.zzys
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handlerZzv.post(runnable);
            }
        }, this);
        Pair pair = this.zzn;
        if (pair != null) {
            throw null;
        }
        this.zzh = new ArrayList();
        if (zzfk.zza < 21 && (i = zzamVar.zzu) != 0) {
            zzaeVarZza = zzyt.zza(i);
        }
        this.zzi = zzaeVarZza;
    }

    private final void zzh() {
        if (this.zzm == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        zzae zzaeVar = this.zzi;
        if (zzaeVar != null) {
            arrayList.add(zzaeVar);
        }
        arrayList.addAll(this.zzh);
        if (this.zzm != null) {
            throw null;
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzaah
    public final void zza(int i, zzam zzamVar) {
        this.zzm = zzamVar;
        zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzaah
    public final void zzb(zzaae zzaaeVar, Executor executor) {
        if (zzfk.zzE(this.zzj, zzaaeVar)) {
            zzdx.zzf(zzfk.zzE(this.zzk, executor));
        } else {
            this.zzj = zzaaeVar;
            this.zzk = executor;
        }
    }

    public final void zzc(Surface surface, zzfc zzfcVar) {
        Pair pair = this.zzn;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((zzfc) this.zzn.second).equals(zzfcVar)) {
            return;
        }
        Pair pair2 = this.zzn;
        boolean z = true;
        if (pair2 != null && !((Surface) pair2.first).equals(surface)) {
            z = false;
        }
        this.zzq = z;
        this.zzn = Pair.create(surface, zzfcVar);
        throw null;
    }

    public final void zzd(List list) {
        this.zzh.clear();
        this.zzh.addAll(list);
        zzh();
    }

    public final void zze(zzzj zzzjVar) {
        this.zzl = zzzjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaah
    public final boolean zzf() {
        return zzfk.zzG(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzaah
    public final boolean zzg() {
        return this.zzq;
    }
}
