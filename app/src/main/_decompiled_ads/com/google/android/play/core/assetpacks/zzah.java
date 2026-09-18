package com.google.android.play.core.assetpacks;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.play:core@@1.10.3 */
/* JADX INFO: loaded from: classes3.dex */
final class zzah extends com.google.android.play.core.internal.zzah {
    final /* synthetic */ int zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ com.google.android.play.core.tasks.zzi zzc;
    final /* synthetic */ int zzd;
    final /* synthetic */ zzaw zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzah(zzaw zzawVar, com.google.android.play.core.tasks.zzi zziVar, int i, String str, com.google.android.play.core.tasks.zzi zziVar2, int i2) {
        super(zziVar);
        this.zze = zzawVar;
        this.zza = i;
        this.zzb = str;
        this.zzc = zziVar2;
        this.zzd = i2;
    }

    @Override // com.google.android.play.core.internal.zzah
    protected final void zza() {
        try {
            ((com.google.android.play.core.internal.zzu) this.zze.zzf.zze()).zzh(this.zze.zzc, zzaw.zzz(this.zza, this.zzb), zzaw.zzA(), new zzar(this.zze, this.zzc, this.zza, this.zzb, this.zzd));
        } catch (RemoteException e) {
            zzaw.zza.zzc(e, "notifyModuleCompleted", new Object[0]);
        }
    }
}
