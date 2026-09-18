package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzboa {
    static final com.google.android.gms.ads.internal.util.zzbd zza = new zzbny();
    static final com.google.android.gms.ads.internal.util.zzbd zzb = new zzbnz();
    private final zzbnm zzc;

    public zzboa(Context context, zzcaz zzcazVar, String str, @Nullable zzfjh zzfjhVar) {
        this.zzc = new zzbnm(context, zzcazVar, str, zza, zzb, zzfjhVar);
    }

    public final zzbnq zza(String str, zzbnt zzbntVar, zzbns zzbnsVar) {
        return new zzboe(this.zzc, str, zzbntVar, zzbnsVar);
    }

    public final zzboj zzb() {
        return new zzboj(this.zzc);
    }
}
