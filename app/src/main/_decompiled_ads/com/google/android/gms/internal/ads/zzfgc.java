package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfgc {
    private final zzffv zza;
    private final ListenableFuture zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    public zzfgc(final zzffa zzffaVar, final zzffu zzffuVar, final zzffv zzffvVar) {
        this.zza = zzffvVar;
        this.zzb = zzfzt.zzf(zzfzt.zzn(zzffuVar.zza(zzffvVar), new zzfza() { // from class: com.google.android.gms.internal.ads.zzfga
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzb(zzffuVar, zzffaVar, zzffvVar, (zzffj) obj);
            }
        }, zzffvVar.zzb()), Exception.class, new zzfza() { // from class: com.google.android.gms.internal.ads.zzfgb
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzc(zzffuVar, (Exception) obj);
            }
        }, zzffvVar.zzb());
    }

    public final synchronized ListenableFuture zza(zzffv zzffvVar) {
        if (!this.zzd && !this.zzc) {
            if (this.zza.zza() != null && zzffvVar.zza() != null && this.zza.zza().equals(zzffvVar.zza())) {
                this.zzc = true;
                return this.zzb;
            }
            return null;
        }
        return null;
    }

    final /* synthetic */ ListenableFuture zzb(zzffu zzffuVar, zzffa zzffaVar, zzffv zzffvVar, zzffj zzffjVar) throws Exception {
        synchronized (this) {
            this.zzd = true;
            zzffuVar.zzb(zzffjVar);
            if (this.zzc) {
                return zzfzt.zzh(new zzfft(zzffjVar, zzffvVar));
            }
            zzffaVar.zzd(zzffvVar.zza(), zzffjVar);
            return zzfzt.zzh(null);
        }
    }

    final /* synthetic */ ListenableFuture zzc(zzffu zzffuVar, Exception exc) throws Exception {
        synchronized (this) {
            this.zzd = true;
            throw exc;
        }
    }

    public final synchronized void zzd(zzfzp zzfzpVar) {
        zzfzt.zzr(zzfzt.zzn(this.zzb, new zzfza() { // from class: com.google.android.gms.internal.ads.zzffz
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return zzfzt.zzi();
            }
        }, this.zza.zzb()), zzfzpVar, this.zza.zzb());
    }
}
