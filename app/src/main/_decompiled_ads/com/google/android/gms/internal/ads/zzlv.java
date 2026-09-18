package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzlv {
    public static final zzlv zza;
    public static final zzlv zzb;
    public static final zzlv zzc;
    public static final zzlv zzd;
    public static final zzlv zze;
    public final long zzf;
    public final long zzg;

    static {
        zzlv zzlvVar = new zzlv(0L, 0L);
        zza = zzlvVar;
        zzb = new zzlv(Long.MAX_VALUE, Long.MAX_VALUE);
        zzc = new zzlv(Long.MAX_VALUE, 0L);
        zzd = new zzlv(0L, Long.MAX_VALUE);
        zze = zzlvVar;
    }

    public zzlv(long j, long j2) {
        zzdx.zzd(j >= 0);
        zzdx.zzd(j2 >= 0);
        this.zzf = j;
        this.zzg = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzlv zzlvVar = (zzlv) obj;
            if (this.zzf == zzlvVar.zzf && this.zzg == zzlvVar.zzg) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.zzf) * 31) + ((int) this.zzg);
    }
}
