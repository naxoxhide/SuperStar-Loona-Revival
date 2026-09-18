package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdfh {
    private final List zza;
    private final zzfjx zzb;
    private boolean zzc;

    public zzdfh(zzfcr zzfcrVar, zzfjx zzfjxVar) {
        this.zza = zzfcrVar.zzr;
        this.zzb = zzfjxVar;
    }

    public final void zza() {
        if (this.zzc) {
            return;
        }
        this.zzb.zzd(this.zza);
        this.zzc = true;
    }
}
