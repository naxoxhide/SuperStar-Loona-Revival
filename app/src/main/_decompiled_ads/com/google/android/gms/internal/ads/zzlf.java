package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlf implements zzug, zzqy {
    final /* synthetic */ zzlj zza;
    private final zzlh zzb;

    public zzlf(zzlj zzljVar, zzlh zzlhVar) {
        this.zza = zzljVar;
        this.zzb = zzlhVar;
    }

    private final Pair zzf(int i, zztw zztwVar) {
        zztw zztwVarZza;
        zztw zztwVar2 = null;
        if (zztwVar != null) {
            zzlh zzlhVar = this.zzb;
            int i2 = 0;
            while (true) {
                if (i2 >= zzlhVar.zzc.size()) {
                    zztwVarZza = null;
                    break;
                }
                if (((zztw) zzlhVar.zzc.get(i2)).zzd == zztwVar.zzd) {
                    zztwVarZza = zztwVar.zza(Pair.create(zzlhVar.zzb, zztwVar.zza));
                    break;
                }
                i2++;
            }
            if (zztwVarZza == null) {
                return null;
            }
            zztwVar2 = zztwVarZza;
        }
        return Pair.create(Integer.valueOf(this.zzb.zzd), zztwVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzac(int i, zztw zztwVar, final zzts zztsVar) {
        final Pair pairZzf = zzf(0, zztwVar);
        if (pairZzf != null) {
            this.zza.zzi.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzld
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzac(((Integer) pair.first).intValue(), (zztw) pair.second, zztsVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzad(int i, zztw zztwVar, final zztn zztnVar, final zzts zztsVar) {
        final Pair pairZzf = zzf(0, zztwVar);
        if (pairZzf != null) {
            this.zza.zzi.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlb
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzad(((Integer) pair.first).intValue(), (zztw) pair.second, zztnVar, zztsVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzae(int i, zztw zztwVar, final zztn zztnVar, final zzts zztsVar) {
        final Pair pairZzf = zzf(0, zztwVar);
        if (pairZzf != null) {
            this.zza.zzi.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzle
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzae(((Integer) pair.first).intValue(), (zztw) pair.second, zztnVar, zztsVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzaf(int i, zztw zztwVar, final zztn zztnVar, final zzts zztsVar, final IOException iOException, final boolean z) {
        final Pair pairZzf = zzf(0, zztwVar);
        if (pairZzf != null) {
            this.zza.zzi.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzla
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzaf(((Integer) pair.first).intValue(), (zztw) pair.second, zztnVar, zztsVar, iOException, z);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzag(int i, zztw zztwVar, final zztn zztnVar, final zzts zztsVar) {
        final Pair pairZzf = zzf(0, zztwVar);
        if (pairZzf != null) {
            this.zza.zzi.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlc
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzag(((Integer) pair.first).intValue(), (zztw) pair.second, zztnVar, zztsVar);
                }
            });
        }
    }
}
