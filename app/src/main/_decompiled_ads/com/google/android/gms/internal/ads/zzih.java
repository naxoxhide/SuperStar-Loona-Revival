package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzih implements zzko {
    private final zzxz zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final long zzf;
    private final long zzg;
    private int zzh;
    private boolean zzi;

    public zzih() {
        zzxz zzxzVar = new zzxz(true, 65536);
        zzj(2500, 0, "bufferForPlaybackMs", "0");
        zzj(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        zzj(50000, 2500, "minBufferMs", "bufferForPlaybackMs");
        zzj(50000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        zzj(50000, 50000, "maxBufferMs", "minBufferMs");
        zzj(0, 0, "backBufferDurationMs", "0");
        this.zzb = zzxzVar;
        this.zzc = zzfk.zzq(50000L);
        this.zzd = zzfk.zzq(50000L);
        this.zze = zzfk.zzq(2500L);
        this.zzf = zzfk.zzq(5000L);
        this.zzh = 13107200;
        this.zzg = zzfk.zzq(0L);
    }

    private static void zzj(int i, int i2, String str, String str2) {
        zzdx.zze(i >= i2, str + " cannot be less than " + str2);
    }

    private final void zzk(boolean z) {
        this.zzh = 13107200;
        this.zzi = false;
        if (z) {
            this.zzb.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzko
    public final long zza() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzko
    public final void zzb() {
        zzk(false);
    }

    @Override // com.google.android.gms.internal.ads.zzko
    public final void zzc() {
        zzk(true);
    }

    @Override // com.google.android.gms.internal.ads.zzko
    public final void zzd() {
        zzk(true);
    }

    @Override // com.google.android.gms.internal.ads.zzko
    public final void zze(zzcv zzcvVar, zztw zztwVar, zzlr[] zzlrVarArr, zzvx zzvxVar, zzxk[] zzxkVarArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int length = zzlrVarArr.length;
            if (i >= 2) {
                int iMax = Math.max(13107200, i2);
                this.zzh = iMax;
                this.zzb.zzf(iMax);
                return;
            } else {
                if (zzxkVarArr[i] != null) {
                    i2 += zzlrVarArr[i].zzb() != 1 ? 131072000 : 13107200;
                }
                i++;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzko
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzko
    public final boolean zzg(long j, long j2, float f) {
        int iZza = this.zzb.zza();
        int i = this.zzh;
        long jMin = this.zzc;
        if (f > 1.0f) {
            jMin = Math.min(zzfk.zzo(jMin, f), this.zzd);
        }
        if (j2 < Math.max(jMin, 500000L)) {
            boolean z = iZza < i;
            this.zzi = z;
            if (!z && j2 < 500000) {
                zzer.zzf("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j2 >= this.zzd || iZza >= i) {
            this.zzi = false;
        }
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzko
    public final boolean zzh(zzcv zzcvVar, zztw zztwVar, long j, float f, boolean z, long j2) {
        long jZzp = zzfk.zzp(j, f);
        long jMin = z ? this.zzf : this.zze;
        if (j2 != -9223372036854775807L) {
            jMin = Math.min(j2 / 2, jMin);
        }
        return jMin <= 0 || jZzp >= jMin || this.zzb.zza() >= this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzko
    public final zzxz zzi() {
        return this.zzb;
    }
}
