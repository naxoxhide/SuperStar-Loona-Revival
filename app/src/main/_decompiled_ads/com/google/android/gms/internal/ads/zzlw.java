package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class zzlw {
    private final zziv zza;

    @Deprecated
    public zzlw(Context context, zzcfl zzcflVar) {
        this.zza = new zziv(context, zzcflVar);
    }

    @Deprecated
    public final zzlw zza(final zzko zzkoVar) {
        zziv zzivVar = this.zza;
        zzdx.zzf(!zzivVar.zzq);
        Objects.requireNonNull(zzkoVar);
        zzivVar.zzf = new zzftm() { // from class: com.google.android.gms.internal.ads.zzin
            @Override // com.google.android.gms.internal.ads.zzftm
            public final Object zza() {
                return zzkoVar;
            }
        };
        return this;
    }

    @Deprecated
    public final zzlw zzb(final zzxq zzxqVar) {
        zziv zzivVar = this.zza;
        zzdx.zzf(!zzivVar.zzq);
        Objects.requireNonNull(zzxqVar);
        zzivVar.zze = new zzftm() { // from class: com.google.android.gms.internal.ads.zziu
            @Override // com.google.android.gms.internal.ads.zzftm
            public final Object zza() {
                return zzxqVar;
            }
        };
        return this;
    }

    @Deprecated
    public final zzlx zzc() {
        zziv zzivVar = this.zza;
        zzdx.zzf(!zzivVar.zzq);
        zzivVar.zzq = true;
        return new zzlx(zzivVar);
    }
}
