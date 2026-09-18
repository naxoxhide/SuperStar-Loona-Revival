package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzack {
    public final zzacn zza;
    public final zzacn zzb;

    public zzack(zzacn zzacnVar, zzacn zzacnVar2) {
        this.zza = zzacnVar;
        this.zzb = zzacnVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzack zzackVar = (zzack) obj;
            if (this.zza.equals(zzackVar.zza) && this.zzb.equals(zzackVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        zzacn zzacnVar = this.zza;
        zzacn zzacnVar2 = this.zzb;
        return "[" + zzacnVar.toString() + (zzacnVar.equals(zzacnVar2) ? "" : ", ".concat(this.zzb.toString())) + "]";
    }
}
