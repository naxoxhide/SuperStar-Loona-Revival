package com.google.android.play.core.assetpacks;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.play:core@@1.10.3 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaj extends com.google.android.play.core.internal.zzah {
    final /* synthetic */ int zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ int zzd;
    final /* synthetic */ com.google.android.play.core.tasks.zzi zze;
    final /* synthetic */ zzaw zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzaj(zzaw zzawVar, com.google.android.play.core.tasks.zzi zziVar, int i, String str, String str2, int i2, com.google.android.play.core.tasks.zzi zziVar2) {
        super(zziVar);
        this.zzf = zzawVar;
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = i2;
        this.zze = zziVar2;
    }

    @Override // com.google.android.play.core.internal.zzah
    protected final void zza() {
        try {
            ((com.google.android.play.core.internal.zzu) this.zzf.zzf.zze()).zzd(this.zzf.zzc, zzaw.zzk(this.zza, this.zzb, this.zzc, this.zzd), zzaw.zzA(), new zzan(this.zzf, this.zze));
        } catch (RemoteException e) {
            zzaw.zza.zzb("getChunkFileDescriptor(%s, %s, %d, session=%d)", this.zzb, this.zzc, Integer.valueOf(this.zzd), Integer.valueOf(this.zza));
            this.zze.zzd(new RuntimeException(e));
        }
    }
}
