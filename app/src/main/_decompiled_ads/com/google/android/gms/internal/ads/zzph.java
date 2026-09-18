package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzph extends Exception {
    public final int zza;
    public final boolean zzb;
    public final zzam zzc;

    public zzph(int i, zzam zzamVar, boolean z) {
        super("AudioTrack write failed: " + i);
        this.zzb = z;
        this.zza = i;
        this.zzc = zzamVar;
    }
}
