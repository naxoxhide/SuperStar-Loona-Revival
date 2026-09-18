package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfqu extends zzfrm {
    final /* synthetic */ zzfra zza;
    final /* synthetic */ zzfrd zzb;
    final /* synthetic */ TaskCompletionSource zzc;
    final /* synthetic */ zzfqy zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfqu(zzfqy zzfqyVar, TaskCompletionSource taskCompletionSource, zzfra zzfraVar, zzfrd zzfrdVar, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zzd = zzfqyVar;
        this.zza = zzfraVar;
        this.zzb = zzfrdVar;
        this.zzc = taskCompletionSource2;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [android.os.IInterface, com.google.android.gms.internal.ads.zzfri] */
    @Override // com.google.android.gms.internal.ads.zzfrm
    protected final void zza() {
        try {
            ?? Zze = this.zzd.zza.zze();
            zzfqy zzfqyVar = this.zzd;
            String str = zzfqyVar.zzd;
            zzfra zzfraVar = this.zza;
            String str2 = zzfqyVar.zzd;
            Bundle bundle = new Bundle();
            bundle.putBinder("windowToken", zzfraVar.zze());
            bundle.putString("adFieldEnifd", zzfraVar.zzf());
            bundle.putInt("layoutGravity", zzfraVar.zzc());
            bundle.putFloat("layoutVerticalMargin", zzfraVar.zza());
            bundle.putInt("displayMode", 0);
            bundle.putInt("windowWidthPx", zzfraVar.zzd());
            bundle.putString("deeplinkUrl", null);
            bundle.putBoolean("stableSessionToken", false);
            bundle.putString("callerPackage", str2);
            if (zzfraVar.zzg() != null) {
                bundle.putString("appId", zzfraVar.zzg());
            }
            Zze.zzf(str, bundle, new zzfqx(this.zzd, this.zzb));
        } catch (RemoteException e) {
            zzfqy.zzb.zzb(e, "show overlay display from: %s", this.zzd.zzd);
            this.zzc.trySetException(new RuntimeException(e));
        }
    }
}
