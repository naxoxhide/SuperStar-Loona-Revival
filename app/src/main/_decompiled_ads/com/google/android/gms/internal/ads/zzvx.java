package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzvx {
    public final int zzc;
    private final zzfvs zze;
    private int zzf;
    public static final zzvx zza = new zzvx(new zzcx[0]);
    private static final String zzd = Integer.toString(0, 36);
    public static final zzn zzb = new zzn() { // from class: com.google.android.gms.internal.ads.zzvw
    };

    /* JADX WARN: Multi-variable type inference failed */
    public zzvx(zzcx... zzcxVarArr) {
        this.zze = zzfvs.zzk(zzcxVarArr);
        this.zzc = zzcxVarArr.length;
        int i = 0;
        while (i < this.zze.size()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.zze.size(); i3++) {
                if (((zzcx) this.zze.get(i)).equals(this.zze.get(i3))) {
                    zzer.zzd("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i = i2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzvx zzvxVar = (zzvx) obj;
            if (this.zzc == zzvxVar.zzc && this.zze.equals(zzvxVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzf;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.zze.hashCode();
        this.zzf = iHashCode;
        return iHashCode;
    }

    public final int zza(zzcx zzcxVar) {
        int iIndexOf = this.zze.indexOf(zzcxVar);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzcx zzb(int i) {
        return (zzcx) this.zze.get(i);
    }
}
