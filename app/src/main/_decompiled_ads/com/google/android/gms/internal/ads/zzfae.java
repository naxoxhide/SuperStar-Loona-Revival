package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfae {
    private final zzffa zza;
    private final zzcws zzb;
    private final Executor zzc;
    private zzfad zzd;

    public zzfae(zzffa zzffaVar, zzcws zzcwsVar, Executor executor) {
        this.zza = zzffaVar;
        this.zzb = zzcwsVar;
        this.zzc = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public final zzffk zze() {
        zzfdn zzfdnVarZzg = this.zzb.zzg();
        return this.zza.zzc(zzfdnVarZzg.zzd, zzfdnVarZzg.zzf, zzfdnVarZzg.zzj);
    }

    public final ListenableFuture zzc() {
        ListenableFuture listenableFutureZze;
        zzfad zzfadVar = this.zzd;
        if (zzfadVar != null) {
            return zzfzt.zzh(zzfadVar);
        }
        if (((Boolean) zzbei.zza.zze()).booleanValue()) {
            listenableFutureZze = zzfzt.zze(zzfzt.zzm(zzfzk.zzu(this.zzb.zzb().zze(this.zza.zza())), new zzfab(this), this.zzc), zzdyo.class, new zzfaa(this), this.zzc);
        } else {
            zzfad zzfadVar2 = new zzfad(null, zze(), null);
            this.zzd = zzfadVar2;
            listenableFutureZze = zzfzt.zzh(zzfadVar2);
        }
        return zzfzt.zzm(listenableFutureZze, new zzfsk() { // from class: com.google.android.gms.internal.ads.zzezz
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                return (zzfad) obj;
            }
        }, this.zzc);
    }
}
