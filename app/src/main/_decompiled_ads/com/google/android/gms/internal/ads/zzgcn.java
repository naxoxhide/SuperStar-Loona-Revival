package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgcn implements zzgax {
    private final zzgcd zza;
    private final zzgmd zzb;
    private final zzgmd zzc;

    /* synthetic */ zzgcn(zzgcd zzgcdVar, zzgcm zzgcmVar) {
        zzgmd zzgmdVarZza;
        this.zza = zzgcdVar;
        if (zzgcdVar.zzf()) {
            zzgme zzgmeVarZzb = zzgie.zza().zzb();
            zzgmj zzgmjVarZza = zzgib.zza(zzgcdVar);
            this.zzb = zzgmeVarZzb.zza(zzgmjVarZza, "aead", "encrypt");
            zzgmdVarZza = zzgmeVarZzb.zza(zzgmjVarZza, "aead", "decrypt");
        } else {
            zzgmdVarZza = zzgib.zza;
            this.zzb = zzgmdVarZza;
        }
        this.zzc = zzgmdVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length > 5) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, length);
            for (zzgbz zzgbzVar : this.zza.zze(bArrCopyOf)) {
                try {
                    byte[] bArrZza = ((zzgax) zzgbzVar.zze()).zza(bArrCopyOfRange, bArr2);
                    zzgbzVar.zza();
                    int length2 = bArrCopyOfRange.length;
                    return bArrZza;
                } catch (GeneralSecurityException unused) {
                }
            }
        }
        for (zzgbz zzgbzVar2 : this.zza.zze(zzgbc.zza)) {
            try {
                byte[] bArrZza2 = ((zzgax) zzgbzVar2.zze()).zza(bArr, bArr2);
                zzgbzVar2.zza();
                int length3 = bArr.length;
                return bArrZza2;
            } catch (GeneralSecurityException unused2) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
