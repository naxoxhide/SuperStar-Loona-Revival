package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.play.core.internal.zzah;

/* JADX INFO: compiled from: com.google.android.play:core@@1.10.3 */
/* JADX INFO: loaded from: classes3.dex */
final class zzl extends zzah {
    final /* synthetic */ String zza;
    final /* synthetic */ com.google.android.play.core.tasks.zzi zzb;
    final /* synthetic */ zzq zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzl(zzq zzqVar, com.google.android.play.core.tasks.zzi zziVar, String str, com.google.android.play.core.tasks.zzi zziVar2) {
        super(zziVar);
        this.zzc = zzqVar;
        this.zza = str;
        this.zzb = zziVar2;
    }

    @Override // com.google.android.play.core.internal.zzah
    protected final void zza() {
        try {
            com.google.android.play.core.internal.zzp zzpVar = (com.google.android.play.core.internal.zzp) this.zzc.zza.zze();
            zzq zzqVar = this.zzc;
            zzpVar.zzd(zzqVar.zzd, zzq.zzb(zzqVar, this.zza), new zzp(this.zzc, this.zzb, this.zza));
        } catch (RemoteException e) {
            zzq.zzb.zzc(e, "requestUpdateInfo(%s)", this.zza);
            this.zzb.zzd(new RuntimeException(e));
        }
    }
}
