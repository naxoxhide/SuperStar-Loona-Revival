package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzakg implements zzaax {
    private final zzfi zza;
    private final zzfb zzb = new zzfb();
    private final int zzc;

    public zzakg(int i, zzfi zzfiVar, int i2) {
        this.zzc = i;
        this.zza = zzfiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final zzaaw zza(zzabn zzabnVar, long j) throws IOException {
        int iZza;
        int iZza2;
        long jZzf = zzabnVar.zzf();
        int iMin = (int) Math.min(112800L, zzabnVar.zzd() - jZzf);
        this.zzb.zzD(iMin);
        ((zzabc) zzabnVar).zzm(this.zzb.zzI(), 0, iMin, false);
        zzfb zzfbVar = this.zzb;
        int iZzd = zzfbVar.zzd();
        long j2 = -1;
        long j3 = -9223372036854775807L;
        long j4 = -1;
        while (zzfbVar.zza() >= 188 && (iZza2 = (iZza = zzaks.zza(zzfbVar.zzI(), zzfbVar.zzc(), iZzd)) + 188) <= iZzd) {
            long jZzb = zzaks.zzb(zzfbVar, iZza, this.zzc);
            if (jZzb != -9223372036854775807L) {
                long jZzb2 = this.zza.zzb(jZzb);
                if (jZzb2 <= j) {
                    j4 = iZza;
                    if (100000 + jZzb2 <= j) {
                        j3 = jZzb2;
                    }
                } else if (j3 == -9223372036854775807L) {
                    return zzaaw.zzd(jZzb2, jZzf);
                }
                return zzaaw.zze(jZzf + j4);
            }
            zzfbVar.zzG(iZza2);
            j2 = iZza2;
        }
        return j3 != -9223372036854775807L ? zzaaw.zzf(j3, jZzf + j2) : zzaaw.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final void zzb() {
        byte[] bArr = zzfk.zzf;
        int length = bArr.length;
        this.zzb.zzE(bArr, 0);
    }
}
