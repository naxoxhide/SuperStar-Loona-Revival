package com.google.android.gms.internal.ads;

import java.io.EOFException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzace {
    private final zzfb zza = new zzfb(10);

    public final zzby zza(zzabn zzabnVar, zzafe zzafeVar) throws Throwable {
        zzby zzbyVarZza = null;
        int i = 0;
        while (true) {
            try {
                ((zzabc) zzabnVar).zzm(this.zza.zzI(), 0, 10, false);
                this.zza.zzG(0);
                if (this.zza.zzn() != 4801587) {
                    break;
                }
                this.zza.zzH(3);
                int iZzk = this.zza.zzk();
                int i2 = iZzk + 10;
                if (zzbyVarZza == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.zza.zzI(), 0, bArr, 0, 10);
                    ((zzabc) zzabnVar).zzm(bArr, 10, iZzk, false);
                    zzbyVarZza = zzafg.zza(bArr, i2, zzafeVar, new zzaeh());
                } else {
                    ((zzabc) zzabnVar).zzl(iZzk, false);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        zzabnVar.zzj();
        ((zzabc) zzabnVar).zzl(i, false);
        return zzbyVarZza;
    }
}
