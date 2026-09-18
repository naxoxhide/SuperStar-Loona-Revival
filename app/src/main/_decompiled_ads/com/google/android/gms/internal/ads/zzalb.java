package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzalb {
    public static Pair zza(zzabn zzabnVar) throws IOException {
        zzabnVar.zzj();
        zzala zzalaVarZzd = zzd(1684108385, zzabnVar, new zzfb(8));
        ((zzabc) zzabnVar).zzo(8, false);
        return Pair.create(Long.valueOf(zzabnVar.zzf()), Long.valueOf(zzalaVarZzd.zzb));
    }

    public static zzakz zzb(zzabn zzabnVar) throws IOException {
        byte[] bArr;
        zzfb zzfbVar = new zzfb(16);
        zzala zzalaVarZzd = zzd(1718449184, zzabnVar, zzfbVar);
        zzdx.zzf(zzalaVarZzd.zzb >= 16);
        zzabc zzabcVar = (zzabc) zzabnVar;
        zzabcVar.zzm(zzfbVar.zzI(), 0, 16, false);
        zzfbVar.zzG(0);
        int iZzj = zzfbVar.zzj();
        int iZzj2 = zzfbVar.zzj();
        int iZzi = zzfbVar.zzi();
        int iZzi2 = zzfbVar.zzi();
        int iZzj3 = zzfbVar.zzj();
        int iZzj4 = zzfbVar.zzj();
        int i = ((int) zzalaVarZzd.zzb) - 16;
        if (i > 0) {
            byte[] bArr2 = new byte[i];
            zzabcVar.zzm(bArr2, 0, i, false);
            bArr = bArr2;
        } else {
            bArr = zzfk.zzf;
        }
        zzabcVar.zzo((int) (zzabnVar.zze() - zzabnVar.zzf()), false);
        return new zzakz(iZzj, iZzj2, iZzi, iZzi2, iZzj3, iZzj4, bArr);
    }

    public static boolean zzc(zzabn zzabnVar) throws IOException {
        zzfb zzfbVar = new zzfb(8);
        int i = zzala.zza(zzabnVar, zzfbVar).zza;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        ((zzabc) zzabnVar).zzm(zzfbVar.zzI(), 0, 4, false);
        zzfbVar.zzG(0);
        int iZzf = zzfbVar.zzf();
        if (iZzf == 1463899717) {
            return true;
        }
        zzer.zzc("WavHeaderReader", "Unsupported form type: " + iZzf);
        return false;
    }

    private static zzala zzd(int i, zzabn zzabnVar, zzfb zzfbVar) throws IOException {
        zzala zzalaVarZza = zzala.zza(zzabnVar, zzfbVar);
        while (true) {
            int i2 = zzalaVarZza.zza;
            if (i2 == i) {
                return zzalaVarZza;
            }
            zzer.zzf("WavHeaderReader", "Ignoring unknown WAV chunk: " + i2);
            long j = zzalaVarZza.zzb + 8;
            if (j > 2147483647L) {
                throw zzcc.zzc("Chunk is too large (~2GB+) to skip; id: " + zzalaVarZza.zza);
            }
            ((zzabc) zzabnVar).zzo((int) j, false);
            zzalaVarZza = zzala.zza(zzabnVar, zzfbVar);
        }
    }
}
