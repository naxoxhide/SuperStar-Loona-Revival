package com.google.android.gms.internal.ads;

import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzpb {
    private final Handler zza;
    private final zzpc zzb;

    public zzpb(Handler handler, zzpc zzpcVar) {
        this.zza = zzpcVar == null ? null : handler;
        this.zzb = zzpcVar;
    }

    public final void zza(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzot
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzh(exc);
                }
            });
        }
    }

    public final void zzb(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzou
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzi(exc);
                }
            });
        }
    }

    public final void zzc(final String str, final long j, final long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzox
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzj(str, j, j2);
                }
            });
        }
    }

    public final void zzd(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzoy
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzk(str);
                }
            });
        }
    }

    public final void zze(final zzid zzidVar) {
        zzidVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzoz
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzl(zzidVar);
                }
            });
        }
    }

    public final void zzf(final zzid zzidVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzor
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzm(zzidVar);
                }
            });
        }
    }

    public final void zzg(final zzam zzamVar, final zzie zzieVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzov
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzn(zzamVar, zzieVar);
                }
            });
        }
    }

    final /* synthetic */ void zzh(Exception exc) {
        int i = zzfk.zza;
        this.zzb.zzb(exc);
    }

    final /* synthetic */ void zzi(Exception exc) {
        int i = zzfk.zza;
        this.zzb.zzi(exc);
    }

    final /* synthetic */ void zzj(String str, long j, long j2) {
        int i = zzfk.zza;
        this.zzb.zzc(str, j, j2);
    }

    final /* synthetic */ void zzk(String str) {
        int i = zzfk.zza;
        this.zzb.zzd(str);
    }

    final /* synthetic */ void zzl(zzid zzidVar) {
        zzidVar.zza();
        int i = zzfk.zza;
        this.zzb.zze(zzidVar);
    }

    final /* synthetic */ void zzm(zzid zzidVar) {
        int i = zzfk.zza;
        this.zzb.zzf(zzidVar);
    }

    final /* synthetic */ void zzn(zzam zzamVar, zzie zzieVar) {
        int i = zzfk.zza;
        this.zzb.zzg(zzamVar, zzieVar);
    }

    final /* synthetic */ void zzo(long j) {
        int i = zzfk.zza;
        this.zzb.zzh(j);
    }

    final /* synthetic */ void zzp(boolean z) {
        int i = zzfk.zza;
        this.zzb.zzm(z);
    }

    final /* synthetic */ void zzq(int i, long j, long j2) {
        int i2 = zzfk.zza;
        this.zzb.zzj(i, j, j2);
    }

    public final void zzr(final long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpa
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzo(j);
                }
            });
        }
    }

    public final void zzs(final boolean z) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzow
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzp(z);
                }
            });
        }
    }

    public final void zzt(final int i, final long j, final long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzos
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzq(i, j, j2);
                }
            });
        }
    }
}
