package com.google.android.gms.internal.measurement;

import androidx.core.internal.view.SupportMenu;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkm {
    private final Object zza;
    private final int zzb;

    zzkm(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzkm)) {
            return false;
        }
        zzkm zzkmVar = (zzkm) obj;
        return this.zza == zzkmVar.zza && this.zzb == zzkmVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * SupportMenu.USER_MASK) + this.zzb;
    }
}
