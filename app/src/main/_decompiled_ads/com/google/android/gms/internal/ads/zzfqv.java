package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfqv extends zzfrm {
    final /* synthetic */ zzfqp zza;
    final /* synthetic */ zzfrd zzb;
    final /* synthetic */ TaskCompletionSource zzc;
    final /* synthetic */ zzfqy zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfqv(zzfqy zzfqyVar, TaskCompletionSource taskCompletionSource, zzfqp zzfqpVar, zzfrd zzfrdVar, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zzd = zzfqyVar;
        this.zza = zzfqpVar;
        this.zzb = zzfrdVar;
        this.zzc = taskCompletionSource2;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.gms.internal.ads.zzfri] */
    @Override // com.google.android.gms.internal.ads.zzfrm
    protected final void zza() {
        try {
            ?? Zze = this.zzd.zza.zze();
            zzfqp zzfqpVar = this.zza;
            String str = this.zzd.zzd;
            Bundle bundle = new Bundle();
            bundle.putString("sessionToken", zzfqpVar.zzb());
            bundle.putString("callerPackage", str);
            bundle.putString("appId", zzfqpVar.zza());
            Zze.zze(bundle, new zzfqx(this.zzd, this.zzb));
        } catch (RemoteException e) {
            zzfqy.zzb.zzb(e, "dismiss overlay display from: %s", this.zzd.zzd);
            this.zzc.trySetException(new RuntimeException(e));
        }
    }
}
