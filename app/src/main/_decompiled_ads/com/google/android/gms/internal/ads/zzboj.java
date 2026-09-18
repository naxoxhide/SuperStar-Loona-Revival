package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzboj {
    private final zzbnm zza;
    private ListenableFuture zzb;

    zzboj(zzbnm zzbnmVar) {
        this.zza = zzbnmVar;
    }

    private final void zzd() {
        if (this.zzb == null) {
            final zzcbl zzcblVar = new zzcbl();
            this.zzb = zzcblVar;
            this.zza.zzb(null).zzi(new zzcbp() { // from class: com.google.android.gms.internal.ads.zzbog
                @Override // com.google.android.gms.internal.ads.zzcbp
                public final void zza(Object obj) {
                    zzcblVar.zzc((zzbnn) obj);
                }
            }, new zzcbn() { // from class: com.google.android.gms.internal.ads.zzboh
                @Override // com.google.android.gms.internal.ads.zzcbn
                public final void zza() {
                    zzcblVar.zzd(new zzbnp("Cannot get Javascript Engine"));
                }
            });
        }
    }

    public final zzbom zza(String str, zzbnt zzbntVar, zzbns zzbnsVar) {
        zzd();
        return new zzbom(this.zzb, "google.afma.activeView.handleUpdate", zzbntVar, zzbnsVar);
    }

    public final void zzb(final String str, final zzbjj zzbjjVar) {
        zzd();
        this.zzb = zzfzt.zzn(this.zzb, new zzfza() { // from class: com.google.android.gms.internal.ads.zzboi
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                zzbnn zzbnnVar = (zzbnn) obj;
                zzbnnVar.zzq(str, zzbjjVar);
                return zzfzt.zzh(zzbnnVar);
            }
        }, zzcbg.zzf);
    }

    public final void zzc(final String str, final zzbjj zzbjjVar) {
        this.zzb = zzfzt.zzm(this.zzb, new zzfsk() { // from class: com.google.android.gms.internal.ads.zzbof
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                zzbnn zzbnnVar = (zzbnn) obj;
                zzbnnVar.zzr(str, zzbjjVar);
                return zzbnnVar;
            }
        }, zzcbg.zzf);
    }
}
