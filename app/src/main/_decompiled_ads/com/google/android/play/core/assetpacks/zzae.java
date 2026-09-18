package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.play:core@@1.10.3 */
/* JADX INFO: loaded from: classes3.dex */
final class zzae extends com.google.android.play.core.internal.zzah {
    final /* synthetic */ Map zza;
    final /* synthetic */ com.google.android.play.core.tasks.zzi zzb;
    final /* synthetic */ zzaw zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzae(zzaw zzawVar, com.google.android.play.core.tasks.zzi zziVar, Map map, com.google.android.play.core.tasks.zzi zziVar2) {
        super(zziVar);
        this.zzc = zzawVar;
        this.zza = map;
        this.zzb = zziVar2;
    }

    @Override // com.google.android.play.core.internal.zzah
    protected final void zza() {
        try {
            ((com.google.android.play.core.internal.zzu) this.zzc.zzf.zze()).zze(this.zzc.zzc, zzaw.zzn(this.zza), new zzao(this.zzc, this.zzb));
        } catch (RemoteException e) {
            zzaw.zza.zzc(e, "syncPacks", new Object[0]);
            this.zzb.zzd(new RuntimeException(e));
        }
    }
}
