package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdg {
    private final zzfvs zzd;
    public static final zzdg zza = new zzdg(zzfvs.zzl());
    private static final String zzc = Integer.toString(0, 36);
    public static final zzn zzb = new zzn() { // from class: com.google.android.gms.internal.ads.zzdd
    };

    public zzdg(List list) {
        this.zzd = zzfvs.zzj(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zzd.equals(((zzdg) obj).zzd);
    }

    public final int hashCode() {
        return this.zzd.hashCode();
    }

    public final zzfvs zza() {
        return this.zzd;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean zzb(int i) {
        for (int i2 = 0; i2 < this.zzd.size(); i2++) {
            zzdf zzdfVar = (zzdf) this.zzd.get(i2);
            if (zzdfVar.zzc() && zzdfVar.zza() == i) {
                return true;
            }
        }
        return false;
    }
}
