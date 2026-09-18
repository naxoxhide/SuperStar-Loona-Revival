package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaij extends zzain {
    private static final byte[] zza = {79, 112, 117, 115, 72, 101, 97, 100};
    private static final byte[] zzb = {79, 112, 117, 115, 84, 97, 103, 115};
    private boolean zzc;

    zzaij() {
    }

    public static boolean zzd(zzfb zzfbVar) {
        return zzk(zzfbVar, zza);
    }

    private static boolean zzk(zzfb zzfbVar, byte[] bArr) {
        if (zzfbVar.zza() < 8) {
            return false;
        }
        int iZzc = zzfbVar.zzc();
        byte[] bArr2 = new byte[8];
        zzfbVar.zzC(bArr2, 0, 8);
        zzfbVar.zzG(iZzc);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzain
    protected final long zza(zzfb zzfbVar) {
        return zzg(zzaci.zzd(zzfbVar.zzI()));
    }

    @Override // com.google.android.gms.internal.ads.zzain
    protected final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zzc = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzain
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean zzc(zzfb zzfbVar, long j, zzaik zzaikVar) throws zzcc {
        if (zzk(zzfbVar, zza)) {
            byte[] bArrCopyOf = Arrays.copyOf(zzfbVar.zzI(), zzfbVar.zzd());
            int i = bArrCopyOf[9] & 255;
            List listZze = zzaci.zze(bArrCopyOf);
            if (zzaikVar.zza != null) {
                return true;
            }
            zzak zzakVar = new zzak();
            zzakVar.zzU("audio/opus");
            zzakVar.zzy(i);
            zzakVar.zzV(48000);
            zzakVar.zzK(listZze);
            zzaikVar.zza = zzakVar.zzac();
            return true;
        }
        if (!zzk(zzfbVar, zzb)) {
            zzdx.zzb(zzaikVar.zza);
            return false;
        }
        zzdx.zzb(zzaikVar.zza);
        if (this.zzc) {
            return true;
        }
        this.zzc = true;
        zzfbVar.zzH(8);
        zzby zzbyVarZzb = zzacy.zzb(zzfvs.zzk(zzacy.zzc(zzfbVar, false, false).zzb));
        if (zzbyVarZzb == null) {
            return true;
        }
        zzak zzakVarZzb = zzaikVar.zza.zzb();
        zzakVarZzb.zzO(zzbyVarZzb.zzd(zzaikVar.zza.zzk));
        zzaikVar.zza = zzakVarZzb.zzac();
        return true;
    }
}
