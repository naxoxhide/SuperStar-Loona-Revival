package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzftb extends zzfss {
    private final Object zza;

    zzftb(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzftb) {
            return this.zza.equals(((zzftb) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.zza.toString() + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzfss
    public final zzfss zza(zzfsk zzfskVar) {
        Object objApply = zzfskVar.apply(this.zza);
        zzfsw.zzc(objApply, "the Function passed to Optional.transform() must not return null.");
        return new zzftb(objApply);
    }

    @Override // com.google.android.gms.internal.ads.zzfss
    public final Object zzb(Object obj) {
        return this.zza;
    }
}
