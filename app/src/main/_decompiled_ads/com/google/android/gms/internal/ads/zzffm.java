package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzffm implements zzffk {
    private final String zza;

    public zzffm(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzffk
    public final boolean equals(Object obj) {
        if (obj instanceof zzffm) {
            return this.zza.equals(((zzffm) obj).zza);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzffk
    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza;
    }
}
