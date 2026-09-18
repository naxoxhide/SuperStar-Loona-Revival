package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzabw {
    public static zzaby zzb(zzfb zzfbVar) {
        zzfbVar.zzH(1);
        int iZzn = zzfbVar.zzn();
        long jZzc = zzfbVar.zzc();
        long j = iZzn;
        int i = iZzn / 18;
        long[] jArrCopyOf = new long[i];
        long[] jArrCopyOf2 = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            long jZzs = zzfbVar.zzs();
            if (jZzs == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
                break;
            }
            jArrCopyOf[i2] = jZzs;
            jArrCopyOf2[i2] = zzfbVar.zzs();
            zzfbVar.zzH(2);
        }
        zzfbVar.zzH((int) ((jZzc + j) - ((long) zzfbVar.zzc())));
        return new zzaby(jArrCopyOf, jArrCopyOf2);
    }

    public static zzby zza(zzabn zzabnVar, boolean z) throws Throwable {
        zzby zzbyVarZza = new zzace().zza(zzabnVar, z ? null : zzafg.zza);
        if (zzbyVarZza == null || zzbyVarZza.zza() == 0) {
            return null;
        }
        return zzbyVarZza;
    }
}
