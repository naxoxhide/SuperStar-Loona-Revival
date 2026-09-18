package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzglj implements zzgbv {
    private final zzgcd zza;
    private final zzgmd zzb;
    private final zzgmd zzc;

    /* synthetic */ zzglj(zzgcd zzgcdVar, zzgli zzgliVar) {
        zzgmd zzgmdVarZza;
        this.zza = zzgcdVar;
        if (zzgcdVar.zzf()) {
            zzgme zzgmeVarZzb = zzgie.zza().zzb();
            zzgmj zzgmjVarZza = zzgib.zza(zzgcdVar);
            this.zzb = zzgmeVarZzb.zza(zzgmjVarZza, "mac", "compute");
            zzgmdVarZza = zzgmeVarZzb.zza(zzgmjVarZza, "mac", "verify");
        } else {
            zzgmdVarZza = zzgib.zza;
            this.zzb = zzgmdVarZza;
        }
        this.zzc = zzgmdVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgbv
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length <= 5) {
            throw new GeneralSecurityException("tag too short");
        }
        for (zzgbz zzgbzVar : this.zza.zze(Arrays.copyOf(bArr, 5))) {
            try {
                ((zzgbv) zzgbzVar.zzd()).zza(bArr, bArr2);
                zzgbzVar.zza();
                return;
            } catch (GeneralSecurityException unused) {
            }
        }
        for (zzgbz zzgbzVar2 : this.zza.zze(zzgbc.zza)) {
            try {
                ((zzgbv) zzgbzVar2.zzd()).zza(bArr, bArr2);
                zzgbzVar2.zza();
                return;
            } catch (GeneralSecurityException unused2) {
            }
        }
        throw new GeneralSecurityException("invalid MAC");
    }
}
