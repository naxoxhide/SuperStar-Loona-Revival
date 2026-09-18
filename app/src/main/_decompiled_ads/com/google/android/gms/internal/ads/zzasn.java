package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzasn implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzasp zzb;

    zzasn(zzasp zzaspVar, int i, boolean z) {
        this.zzb = zzaspVar;
        this.zza = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzapj zzapjVarZza;
        int i = this.zza;
        zzasp zzaspVar = this.zzb;
        if (i > 0) {
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException unused) {
            }
        }
        try {
            PackageInfo packageInfo = zzaspVar.zza.getPackageManager().getPackageInfo(zzaspVar.zza.getPackageName(), 0);
            Context context = zzaspVar.zza;
            zzapjVarZza = zzfmy.zza(context, context.getPackageName(), Integer.toString(packageInfo.versionCode));
        } catch (Throwable unused2) {
            zzapjVarZza = null;
        }
        this.zzb.zzm = zzapjVarZza;
        if (this.zza < 4) {
            if (zzapjVarZza != null && zzapjVarZza.zzaj() && !zzapjVarZza.zzh().equals("0000000000000000000000000000000000000000000000000000000000000000") && zzapjVarZza.zzak() && zzapjVarZza.zzf().zze() && zzapjVarZza.zzf().zza() != -2) {
                return;
            }
            this.zzb.zzo(this.zza + 1, true);
        }
    }
}
