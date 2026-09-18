package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgjm {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzgjm(Class cls, Class cls2, zzgjl zzgjlVar) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgjm)) {
            return false;
        }
        zzgjm zzgjmVar = (zzgjm) obj;
        return zzgjmVar.zza.equals(this.zza) && zzgjmVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        Class cls = this.zzb;
        return this.zza.getSimpleName() + " with serialization type: " + cls.getSimpleName();
    }
}
