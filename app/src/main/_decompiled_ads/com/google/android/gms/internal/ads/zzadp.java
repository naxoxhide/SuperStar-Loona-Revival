package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzadp implements zzaax {
    private final zzabz zza;
    private final int zzb;
    private final zzabu zzc = new zzabu();

    /* synthetic */ zzadp(zzabz zzabzVar, int i, zzado zzadoVar) {
        this.zza = zzabzVar;
        this.zzb = i;
    }

    private final long zzc(zzabn zzabnVar) throws IOException {
        while (zzabnVar.zze() < zzabnVar.zzd() - 6) {
            zzabz zzabzVar = this.zza;
            int i = this.zzb;
            zzabu zzabuVar = this.zzc;
            long jZze = zzabnVar.zze();
            byte[] bArr = new byte[2];
            zzabc zzabcVar = (zzabc) zzabnVar;
            zzabcVar.zzm(bArr, 0, 2, false);
            if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
                zzabnVar.zzj();
                zzabcVar.zzl((int) (jZze - zzabnVar.zzf()), false);
            } else {
                zzfb zzfbVar = new zzfb(16);
                System.arraycopy(bArr, 0, zzfbVar.zzI(), 0, 2);
                zzfbVar.zzF(zzabq.zza(zzabnVar, zzfbVar.zzI(), 2, 14));
                zzabnVar.zzj();
                zzabcVar.zzl((int) (jZze - zzabnVar.zzf()), false);
                if (zzabv.zzc(zzfbVar, zzabzVar, i, zzabuVar)) {
                    break;
                }
            }
            zzabcVar.zzl(1, false);
        }
        if (zzabnVar.zze() < zzabnVar.zzd() - 6) {
            return this.zzc.zza;
        }
        ((zzabc) zzabnVar).zzl((int) (zzabnVar.zzd() - zzabnVar.zze()), false);
        return this.zza.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final zzaaw zza(zzabn zzabnVar, long j) throws IOException {
        int i = this.zza.zzc;
        long jZzf = zzabnVar.zzf();
        long jZzc = zzc(zzabnVar);
        long jZze = zzabnVar.zze();
        ((zzabc) zzabnVar).zzl(Math.max(6, i), false);
        long jZzc2 = zzc(zzabnVar);
        long jZze2 = zzabnVar.zze();
        if (jZzc > j || jZzc2 <= j) {
            return jZzc2 <= j ? zzaaw.zzf(jZzc2, jZze2) : zzaaw.zzd(jZzc, jZzf);
        }
        return zzaaw.zze(jZze);
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final /* synthetic */ void zzb() {
    }
}
