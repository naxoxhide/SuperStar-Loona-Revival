package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzclm implements zzfck {
    private final zzcjs zza;
    private Context zzb;
    private String zzc;

    /* synthetic */ zzclm(zzcjs zzcjsVar, zzcll zzcllVar) {
        this.zza = zzcjsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final /* synthetic */ zzfck zza(String str) {
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final /* synthetic */ zzfck zzb(Context context) {
        Objects.requireNonNull(context);
        this.zzb = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final zzfcl zzc() {
        zzhbk.zzc(this.zzb, Context.class);
        return new zzclo(this.zza, this.zzb, this.zzc, null);
    }
}
