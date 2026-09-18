package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfqw extends zzfrm {
    final /* synthetic */ zzfrf zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzfrd zzc;
    final /* synthetic */ TaskCompletionSource zzd;
    final /* synthetic */ zzfqy zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfqw(zzfqy zzfqyVar, TaskCompletionSource taskCompletionSource, zzfrf zzfrfVar, int i, zzfrd zzfrdVar, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zze = zzfqyVar;
        this.zza = zzfrfVar;
        this.zzb = i;
        this.zzc = zzfrdVar;
        this.zzd = taskCompletionSource2;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.gms.internal.ads.zzfri] */
    @Override // com.google.android.gms.internal.ads.zzfrm
    protected final void zza() {
        try {
            ?? Zze = this.zze.zza.zze();
            zzfrf zzfrfVar = this.zza;
            String str = this.zze.zzd;
            int i = this.zzb;
            Bundle bundle = new Bundle();
            bundle.putString("sessionToken", zzfrfVar.zzb());
            bundle.putInt("displayMode", i);
            bundle.putString("callerPackage", str);
            bundle.putString("appId", zzfrfVar.zza());
            Zze.zzg(bundle, new zzfqx(this.zze, this.zzc));
        } catch (RemoteException e) {
            zzfqy.zzb.zzb(e, "switchDisplayMode overlay display to %d from: %s", Integer.valueOf(this.zzb), this.zze.zzd);
            this.zzd.trySetException(new RuntimeException(e));
        }
    }
}
