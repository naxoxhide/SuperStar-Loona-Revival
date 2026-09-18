package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.play:core@@1.10.3 */
/* JADX INFO: loaded from: classes3.dex */
final class zzad extends com.google.android.play.core.internal.zzah {
    final /* synthetic */ List zza;
    final /* synthetic */ com.google.android.play.core.tasks.zzi zzb;
    final /* synthetic */ zzaw zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzad(zzaw zzawVar, com.google.android.play.core.tasks.zzi zziVar, List list, com.google.android.play.core.tasks.zzi zziVar2) {
        super(zziVar);
        this.zzc = zzawVar;
        this.zza = list;
        this.zzb = zziVar2;
    }

    @Override // com.google.android.play.core.internal.zzah
    protected final void zza() {
        try {
            ((com.google.android.play.core.internal.zzu) this.zzc.zzf.zze()).zzc(this.zzc.zzc, zzaw.zzv(this.zza), zzaw.zzA(), new zzam(this.zzc, this.zzb));
        } catch (RemoteException e) {
            zzaw.zza.zzc(e, "cancelDownloads(%s)", this.zza);
        }
    }
}
