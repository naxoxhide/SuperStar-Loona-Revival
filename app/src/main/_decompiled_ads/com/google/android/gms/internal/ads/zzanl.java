package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzanl implements zzanb {
    final /* synthetic */ Context zza;
    private File zzb = null;

    zzanl(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzanb
    public final File zza() {
        if (this.zzb == null) {
            this.zzb = new File(this.zza.getCacheDir(), "volley");
        }
        return this.zzb;
    }
}
