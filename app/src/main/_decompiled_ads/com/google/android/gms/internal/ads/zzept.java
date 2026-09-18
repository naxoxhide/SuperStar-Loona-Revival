package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzept implements zzetw {
    private final zzezp zza;

    zzept(zzezp zzezpVar) {
        this.zza = zzezpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 15;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        zzezp zzezpVar = this.zza;
        zzetv zzetvVar = null;
        if (zzezpVar != null && zzezpVar.zza() != null && !zzezpVar.zza().isEmpty()) {
            zzetvVar = new zzetv() { // from class: com.google.android.gms.internal.ads.zzeps
                @Override // com.google.android.gms.internal.ads.zzetv
                public final void zzj(Object obj) {
                    this.zza.zzc((Bundle) obj);
                }
            };
        }
        return zzfzt.zzh(zzetvVar);
    }

    final /* synthetic */ void zzc(Bundle bundle) {
        bundle.putString("key_schema", this.zza.zza());
    }
}
