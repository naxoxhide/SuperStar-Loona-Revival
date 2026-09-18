package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzexk implements zzetw {
    private final zzcac zza;
    private final boolean zzb;
    private final boolean zzc;
    private final ScheduledExecutorService zzd;
    private final zzgad zze;
    private final String zzf;
    private final zzbzr zzg;

    zzexk(zzcac zzcacVar, boolean z, boolean z2, zzbzr zzbzrVar, zzgad zzgadVar, String str, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzcacVar;
        this.zzb = z;
        this.zzc = z2;
        this.zzg = zzbzrVar;
        this.zze = zzgadVar;
        this.zzf = str;
        this.zzd = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 50;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhe)).booleanValue() && this.zzc) {
            return zzfzt.zzh(null);
        }
        if (!this.zzb) {
            return zzfzt.zzh(null);
        }
        return zzfzt.zze(zzfzt.zzo(zzfzt.zzm(zzfzt.zzh(null), new zzfsk() { // from class: com.google.android.gms.internal.ads.zzexi
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                String str = (String) obj;
                if (str == null) {
                    return null;
                }
                return new zzexl(str);
            }
        }, this.zze), ((Long) zzbep.zzc.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzd), Exception.class, new zzfsk() { // from class: com.google.android.gms.internal.ads.zzexj
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                this.zza.zzc((Exception) obj);
                return null;
            }
        }, this.zze);
    }

    final /* synthetic */ zzexl zzc(Exception exc) {
        this.zza.zzu(exc, "TrustlessTokenSignal");
        return null;
    }
}
