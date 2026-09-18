package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcky implements zzdtx {
    private final zzcjs zza;
    private Context zzb;
    private zzbkh zzc;

    /* synthetic */ zzcky(zzcjs zzcjsVar, zzckx zzckxVar) {
        this.zza = zzcjsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtx
    public final /* synthetic */ zzdtx zza(zzbkh zzbkhVar) {
        Objects.requireNonNull(zzbkhVar);
        this.zzc = zzbkhVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdtx
    public final /* synthetic */ zzdtx zzb(Context context) {
        Objects.requireNonNull(context);
        this.zzb = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdtx
    public final zzdty zzc() {
        zzhbk.zzc(this.zzb, Context.class);
        zzhbk.zzc(this.zzc, zzbkh.class);
        return new zzcla(this.zza, this.zzb, this.zzc, null);
    }
}
