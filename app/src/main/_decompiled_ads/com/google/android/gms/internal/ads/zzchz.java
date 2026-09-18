package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzchz {
    private final zzcaz zza;
    private final Context zzb;
    private final WeakReference zzc;

    /* synthetic */ zzchz(zzchx zzchxVar, zzchy zzchyVar) {
        this.zza = zzchxVar.zza;
        this.zzb = zzchxVar.zzb;
        this.zzc = zzchxVar.zzc;
    }

    final Context zza() {
        return this.zzb;
    }

    public final zzaro zzb() {
        return new zzaro(new com.google.android.gms.ads.internal.zzi(this.zzb, this.zza));
    }

    final zzbev zzc() {
        return new zzbev(this.zzb);
    }

    final zzcaz zzd() {
        return this.zza;
    }

    final String zze() {
        return com.google.android.gms.ads.internal.zzt.zzp().zzc(this.zzb, this.zza.zza);
    }

    final WeakReference zzf() {
        return this.zzc;
    }
}
