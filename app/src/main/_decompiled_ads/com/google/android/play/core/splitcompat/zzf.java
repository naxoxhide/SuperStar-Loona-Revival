package com.google.android.play.core.splitcompat;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.play:core@@1.10.3 */
/* JADX INFO: loaded from: classes3.dex */
final class zzf implements zzk {
    final /* synthetic */ zzg zza;

    zzf(zzg zzgVar) {
        this.zza = zzgVar;
    }

    @Override // com.google.android.play.core.splitcompat.zzk
    public final void zza(zzl zzlVar, File file, boolean z) throws IOException {
        this.zza.zzb.add(file);
        if (z) {
            return;
        }
        this.zza.zzc.set(false);
    }
}
