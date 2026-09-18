package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgjk {
    private final Class zza;
    private final zzgrx zzb;

    /* synthetic */ zzgjk(Class cls, zzgrx zzgrxVar, zzgjj zzgjjVar) {
        this.zza = cls;
        this.zzb = zzgrxVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgjk)) {
            return false;
        }
        zzgjk zzgjkVar = (zzgjk) obj;
        return zzgjkVar.zza.equals(this.zza) && zzgjkVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        zzgrx zzgrxVar = this.zzb;
        return this.zza.getSimpleName() + ", object identifier: " + String.valueOf(zzgrxVar);
    }
}
