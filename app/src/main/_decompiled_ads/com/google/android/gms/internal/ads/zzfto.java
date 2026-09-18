package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfto implements zzftm {
    private static final zzftm zza = new zzftm() { // from class: com.google.android.gms.internal.ads.zzftn
        @Override // com.google.android.gms.internal.ads.zzftm
        public final Object zza() {
            throw new IllegalStateException();
        }
    };
    private volatile zzftm zzb;

    @CheckForNull
    private Object zzc;

    zzfto(zzftm zzftmVar) {
        this.zzb = zzftmVar;
    }

    public final String toString() {
        Object obj = this.zzb;
        if (obj == zza) {
            obj = "<supplier that returned " + String.valueOf(this.zzc) + ">";
        }
        return "Suppliers.memoize(" + String.valueOf(obj) + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzftm
    public final Object zza() {
        zzftm zzftmVar = this.zzb;
        zzftm zzftmVar2 = zza;
        if (zzftmVar != zzftmVar2) {
            synchronized (this) {
                if (this.zzb != zzftmVar2) {
                    Object objZza = this.zzb.zza();
                    this.zzc = objZza;
                    this.zzb = zzftmVar2;
                    return objZza;
                }
            }
        }
        return this.zzc;
    }
}
