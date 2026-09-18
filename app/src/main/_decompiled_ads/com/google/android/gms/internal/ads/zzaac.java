package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaac {
    private final Handler zza;
    private final zzaad zzb;

    public zzaac(Handler handler, zzaad zzaadVar) {
        this.zza = zzaadVar == null ? null : handler;
        this.zzb = zzaadVar;
    }

    public final void zza(final String str, final long j, final long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzs
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzg(str, j, j2);
                }
            });
        }
    }

    public final void zzb(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaab
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzh(str);
                }
            });
        }
    }

    public final void zzc(final zzid zzidVar) {
        zzidVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaaa
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzi(zzidVar);
                }
            });
        }
    }

    public final void zzd(final int i, final long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzu
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzj(i, j);
                }
            });
        }
    }

    public final void zze(final zzid zzidVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzy
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzk(zzidVar);
                }
            });
        }
    }

    public final void zzf(final zzam zzamVar, final zzie zzieVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzz
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzl(zzamVar, zzieVar);
                }
            });
        }
    }

    final /* synthetic */ void zzg(String str, long j, long j2) {
        int i = zzfk.zza;
        this.zzb.zzo(str, j, j2);
    }

    final /* synthetic */ void zzh(String str) {
        int i = zzfk.zza;
        this.zzb.zzp(str);
    }

    final /* synthetic */ void zzi(zzid zzidVar) {
        zzidVar.zza();
        int i = zzfk.zza;
        this.zzb.zzq(zzidVar);
    }

    final /* synthetic */ void zzj(int i, long j) {
        int i2 = zzfk.zza;
        this.zzb.zzk(i, j);
    }

    final /* synthetic */ void zzk(zzid zzidVar) {
        int i = zzfk.zza;
        this.zzb.zzr(zzidVar);
    }

    final /* synthetic */ void zzl(zzam zzamVar, zzie zzieVar) {
        int i = zzfk.zza;
        this.zzb.zzt(zzamVar, zzieVar);
    }

    final /* synthetic */ void zzm(Object obj, long j) {
        int i = zzfk.zza;
        this.zzb.zzl(obj, j);
    }

    final /* synthetic */ void zzn(long j, int i) {
        int i2 = zzfk.zza;
        this.zzb.zzs(j, i);
    }

    final /* synthetic */ void zzo(Exception exc) {
        int i = zzfk.zza;
        this.zzb.zzn(exc);
    }

    final /* synthetic */ void zzp(zzdm zzdmVar) {
        int i = zzfk.zza;
        this.zzb.zzu(zzdmVar);
    }

    public final void zzq(final Object obj) {
        Handler handler = this.zza;
        if (handler != null) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzv
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzm(obj, jElapsedRealtime);
                }
            });
        }
    }

    public final void zzr(final long j, final int i) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzw
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzn(j, i);
                }
            });
        }
    }

    public final void zzs(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzx
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzo(exc);
                }
            });
        }
    }

    public final void zzt(final zzdm zzdmVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzt
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzp(zzdmVar);
                }
            });
        }
    }
}
