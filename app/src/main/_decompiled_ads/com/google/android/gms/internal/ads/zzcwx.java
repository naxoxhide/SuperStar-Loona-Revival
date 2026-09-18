package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcwx implements zzhbc {
    private final zzcwv zza;
    private final zzhbp zzb;

    public zzcwx(zzcwv zzcwvVar, zzhbp zzhbpVar) {
        this.zza = zzcwvVar;
        this.zzb = zzhbpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context contextZza = this.zza.zza(((zzcic) this.zzb).zza());
        zzhbk.zzb(contextZza);
        return contextZza;
    }
}
