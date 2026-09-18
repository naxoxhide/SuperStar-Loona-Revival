package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.common.PlayCoreVersion;
import com.google.android.play.core.internal.zzac;
import com.google.android.play.core.internal.zzah;

/* JADX INFO: compiled from: com.google.android.play:core@@1.10.3 */
/* JADX INFO: loaded from: classes3.dex */
final class zzf extends zzah {
    final /* synthetic */ com.google.android.play.core.tasks.zzi zza;
    final /* synthetic */ zzi zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzf(zzi zziVar, com.google.android.play.core.tasks.zzi zziVar2, com.google.android.play.core.tasks.zzi zziVar3) {
        super(zziVar2);
        this.zzb = zziVar;
        this.zza = zziVar3;
    }

    @Override // com.google.android.play.core.internal.zzah
    protected final void zza() {
        try {
            zzac zzacVar = (zzac) this.zzb.zza.zze();
            String str = this.zzb.zzc;
            Bundle bundleZza = PlayCoreVersion.zza("review");
            zzi zziVar = this.zzb;
            zzacVar.zzc(str, bundleZza, new zzh(zziVar, this.zza, zziVar.zzc));
        } catch (RemoteException e) {
            zzi.zzb.zzc(e, "error requesting in-app review for %s", this.zzb.zzc);
            this.zza.zzd(new RuntimeException(e));
        }
    }
}
