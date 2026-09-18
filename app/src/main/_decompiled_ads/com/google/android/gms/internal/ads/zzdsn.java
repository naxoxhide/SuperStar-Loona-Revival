package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdsn {
    final /* synthetic */ zzdso zza;
    private final Map zzb = new ConcurrentHashMap();

    zzdsn(zzdso zzdsoVar) {
        this.zza = zzdsoVar;
    }

    static /* bridge */ /* synthetic */ zzdsn zza(zzdsn zzdsnVar) {
        zzdsnVar.zzb.putAll(zzdsnVar.zza.zzc);
        return zzdsnVar;
    }

    public final zzdsn zzb(String str, String str2) {
        this.zzb.put(str, str2);
        return this;
    }

    public final zzdsn zzc(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.zzb.put(str, str2);
        }
        return this;
    }

    public final zzdsn zzd(zzfcr zzfcrVar) {
        this.zzb.put("aai", zzfcrVar.zzy);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgW)).booleanValue()) {
            zzc("rid", zzfcrVar.zzap);
        }
        return this;
    }

    public final zzdsn zze(zzfcv zzfcvVar) {
        this.zzb.put("gqi", zzfcvVar.zzb);
        return this;
    }

    public final String zzf() {
        return this.zza.zza.zzb(this.zzb);
    }

    public final void zzg() {
        this.zza.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdsl
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzi();
            }
        });
    }

    public final void zzh() {
        this.zza.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdsm
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzj();
            }
        });
    }

    final /* synthetic */ void zzi() {
        this.zza.zza.zzf(this.zzb);
    }

    final /* synthetic */ void zzj() {
        this.zza.zza.zze(this.zzb);
    }
}
