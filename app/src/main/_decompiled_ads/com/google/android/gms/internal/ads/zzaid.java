package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaid extends zzain {
    private zzabz zza;
    private zzaic zzb;

    zzaid() {
    }

    private static boolean zzd(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.google.android.gms.internal.ads.zzain
    protected final long zza(zzfb zzfbVar) {
        if (!zzd(zzfbVar.zzI())) {
            return -1L;
        }
        int i = (zzfbVar.zzI()[2] & 255) >> 4;
        if (i == 6) {
            zzfbVar.zzH(4);
            zzfbVar.zzv();
        } else if (i == 7) {
            i = 7;
            zzfbVar.zzH(4);
            zzfbVar.zzv();
        }
        int iZza = zzabv.zza(zzfbVar, i);
        zzfbVar.zzG(0);
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzain
    protected final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzb = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzain
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean zzc(zzfb zzfbVar, long j, zzaik zzaikVar) {
        byte[] bArrZzI = zzfbVar.zzI();
        zzabz zzabzVar = this.zza;
        if (zzabzVar == null) {
            zzabz zzabzVar2 = new zzabz(bArrZzI, 17);
            this.zza = zzabzVar2;
            zzaikVar.zza = zzabzVar2.zzc(Arrays.copyOfRange(bArrZzI, 9, zzfbVar.zzd()), null);
            return true;
        }
        if ((bArrZzI[0] & 127) == 3) {
            zzaby zzabyVarZzb = zzabw.zzb(zzfbVar);
            zzabz zzabzVarZzf = zzabzVar.zzf(zzabyVarZzb);
            this.zza = zzabzVarZzf;
            this.zzb = new zzaic(zzabzVarZzf, zzabyVarZzb);
            return true;
        }
        if (!zzd(bArrZzI)) {
            return true;
        }
        zzaic zzaicVar = this.zzb;
        if (zzaicVar != null) {
            zzaicVar.zza(j);
            zzaikVar.zzb = this.zzb;
        }
        Objects.requireNonNull(zzaikVar.zza);
        return false;
    }
}
