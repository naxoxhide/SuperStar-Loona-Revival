package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzakx implements zzakw {
    private final zzabp zza;
    private final zzacs zzb;
    private final zzakz zzc;
    private final zzam zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzakx(zzabp zzabpVar, zzacs zzacsVar, zzakz zzakzVar, String str, int i) throws zzcc {
        this.zza = zzabpVar;
        this.zzb = zzacsVar;
        this.zzc = zzakzVar;
        int i2 = zzakzVar.zzb * zzakzVar.zze;
        int i3 = zzakzVar.zzd;
        int i4 = i2 / 8;
        if (i3 != i4) {
            throw zzcc.zza("Expected block size: " + i4 + "; got: " + i3, null);
        }
        int i5 = zzakzVar.zzc * i4;
        int i6 = i5 * 8;
        int iMax = Math.max(i4, i5 / 10);
        this.zze = iMax;
        zzak zzakVar = new zzak();
        zzakVar.zzU(str);
        zzakVar.zzx(i6);
        zzakVar.zzQ(i6);
        zzakVar.zzN(iMax);
        zzakVar.zzy(zzakzVar.zzb);
        zzakVar.zzV(zzakzVar.zzc);
        zzakVar.zzP(i);
        this.zzd = zzakVar.zzac();
    }

    @Override // com.google.android.gms.internal.ads.zzakw
    public final void zza(int i, long j) {
        this.zza.zzO(new zzalc(this.zzc, 1, i, j));
        this.zzb.zzl(this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzakw
    public final void zzb(long j) {
        this.zzf = j;
        this.zzg = 0;
        this.zzh = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzakw
    public final boolean zzc(zzabn zzabnVar, long j) throws IOException {
        int i;
        int i2;
        long j2 = j;
        while (j2 > 0 && (i = this.zzg) < (i2 = this.zze)) {
            int iZza = zzacq.zza(this.zzb, zzabnVar, (int) Math.min(i2 - i, j2), true);
            if (iZza == -1) {
                j2 = 0;
            } else {
                this.zzg += iZza;
                j2 -= (long) iZza;
            }
        }
        zzakz zzakzVar = this.zzc;
        int i3 = this.zzg;
        int i4 = zzakzVar.zzd;
        int i5 = i3 / i4;
        if (i5 > 0) {
            long jZzr = this.zzf + zzfk.zzr(this.zzh, 1000000L, zzakzVar.zzc);
            int i6 = i5 * i4;
            int i7 = this.zzg - i6;
            this.zzb.zzt(jZzr, 1, i6, i7, null);
            this.zzh += (long) i5;
            this.zzg = i7;
        }
        return j2 <= 0;
    }
}
