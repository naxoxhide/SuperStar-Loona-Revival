package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcwp {
    private final zzfhr zza;
    private final zzcaz zzb;
    private final ApplicationInfo zzc;
    private final String zzd;
    private final List zze;
    private final PackageInfo zzf;
    private final zzhaw zzg;
    private final String zzh;
    private final zzetz zzi;
    private final com.google.android.gms.ads.internal.util.zzg zzj;
    private final zzfdn zzk;
    private final zzdcu zzl;

    public zzcwp(zzfhr zzfhrVar, zzcaz zzcazVar, ApplicationInfo applicationInfo, String str, List list, PackageInfo packageInfo, zzhaw zzhawVar, com.google.android.gms.ads.internal.util.zzg zzgVar, String str2, zzetz zzetzVar, zzfdn zzfdnVar, zzdcu zzdcuVar) {
        this.zza = zzfhrVar;
        this.zzb = zzcazVar;
        this.zzc = applicationInfo;
        this.zzd = str;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = zzhawVar;
        this.zzh = str2;
        this.zzi = zzetzVar;
        this.zzj = zzgVar;
        this.zzk = zzfdnVar;
        this.zzl = zzdcuVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ zzbvg zza(ListenableFuture listenableFuture) throws Exception {
        Bundle bundle = (Bundle) listenableFuture.get();
        String str = (String) ((ListenableFuture) this.zzg.zzb()).get();
        boolean z = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhe)).booleanValue() && this.zzj.zzQ();
        String str2 = this.zzh;
        PackageInfo packageInfo = this.zzf;
        List list = this.zze;
        return new zzbvg(bundle, this.zzb, this.zzc, this.zzd, list, packageInfo, str, str2, null, null, z, this.zzk.zzb());
    }

    public final ListenableFuture zzb() {
        this.zzl.zza();
        return zzfhb.zzc(this.zzi.zza(new Bundle()), zzfhl.SIGNALS, this.zza).zza();
    }

    public final ListenableFuture zzc() {
        final ListenableFuture listenableFutureZzb = zzb();
        return this.zza.zza(zzfhl.REQUEST_PARCEL, listenableFutureZzb, (ListenableFuture) this.zzg.zzb()).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzcwo
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zza(listenableFutureZzb);
            }
        }).zza();
    }
}
