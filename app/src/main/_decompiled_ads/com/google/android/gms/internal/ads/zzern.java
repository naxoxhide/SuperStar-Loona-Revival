package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzern implements zzetv {
    public final zzfcq zza;

    public zzern(zzfcq zzfcqVar) {
        this.zza = zzfcqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetv
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        zzfcq zzfcqVar = this.zza;
        Bundle bundle = (Bundle) obj;
        if (zzfcqVar != null) {
            bundle.putBoolean("render_in_browser", zzfcqVar.zzd());
            bundle.putBoolean("disable_ml", this.zza.zzc());
        }
    }
}
