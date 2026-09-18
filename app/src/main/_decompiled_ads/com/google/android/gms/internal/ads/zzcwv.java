package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcwv {
    private final Context zza;
    private final zzfdn zzb;
    private final Bundle zzc;
    private final zzfdf zzd;
    private final zzcwn zze;
    private final zzeez zzf;

    /* synthetic */ zzcwv(zzcwt zzcwtVar, zzcwu zzcwuVar) {
        this.zza = zzcwtVar.zza;
        this.zzb = zzcwtVar.zzb;
        this.zzc = zzcwtVar.zzc;
        this.zzd = zzcwtVar.zzd;
        this.zze = zzcwtVar.zze;
        this.zzf = zzcwtVar.zzf;
    }

    final Context zza(Context context) {
        return this.zza;
    }

    final Bundle zzb() {
        return this.zzc;
    }

    final zzcwn zzc() {
        return this.zze;
    }

    final zzcwt zzd() {
        zzcwt zzcwtVar = new zzcwt();
        zzcwtVar.zze(this.zza);
        zzcwtVar.zzi(this.zzb);
        zzcwtVar.zzf(this.zzc);
        zzcwtVar.zzg(this.zze);
        zzcwtVar.zzd(this.zzf);
        return zzcwtVar;
    }

    final zzeez zze(String str) {
        zzeez zzeezVar = this.zzf;
        return zzeezVar != null ? zzeezVar : new zzeez(str);
    }

    final zzfdf zzf() {
        return this.zzd;
    }

    final zzfdn zzg() {
        return this.zzb;
    }
}
