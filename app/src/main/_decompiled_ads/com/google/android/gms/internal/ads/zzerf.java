package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzerf implements zzetw {
    private final zzgad zza;
    private final zzdvm zzb;

    zzerf(zzgad zzgadVar, zzdvm zzdvmVar) {
        this.zza = zzgadVar;
        this.zzb = zzdvmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 23;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzere
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    final /* synthetic */ zzerg zzc() throws Exception {
        zzdvm zzdvmVar = this.zzb;
        String strZzc = zzdvmVar.zzc();
        boolean zZzq = zzdvmVar.zzq();
        boolean zZzl = com.google.android.gms.ads.internal.zzt.zzs().zzl();
        zzdvm zzdvmVar2 = this.zzb;
        return new zzerg(strZzc, zZzq, zZzl, zzdvmVar2.zzo(), zzdvmVar2.zzr());
    }
}
