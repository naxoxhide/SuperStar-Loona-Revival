package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgrq implements zzgmk {
    private final SecretKey zza;
    private final byte[] zzb;
    private final byte[] zzc;

    public zzgrq(byte[] bArr) throws GeneralSecurityException {
        zzgrv.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zza = secretKeySpec;
        Cipher cipherZzb = zzb();
        cipherZzb.init(1, secretKeySpec);
        byte[] bArrZza = zzglr.zza(cipherZzb.doFinal(new byte[16]));
        this.zzb = bArrZza;
        this.zzc = zzglr.zza(bArrZza);
    }

    private static Cipher zzb() throws GeneralSecurityException {
        if (zzghf.zza(1)) {
            return (Cipher) zzgrf.zza.zza("AES/ECB/NoPadding");
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    @Override // com.google.android.gms.internal.ads.zzgmk
    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        byte[] bArrZzc;
        if (i > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        SecretKey secretKey = this.zza;
        Cipher cipherZzb = zzb();
        cipherZzb.init(1, secretKey);
        int length = bArr.length;
        int iMax = Math.max(1, (int) Math.ceil(((double) length) / 16.0d));
        int i2 = iMax - 1;
        int i3 = i2 * 16;
        if (iMax * 16 == length) {
            bArrZzc = zzgqv.zzd(bArr, i3, this.zzb, 0, 16);
        } else {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i3, length);
            int length2 = bArrCopyOfRange.length;
            if (length2 >= 16) {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArrCopyOfRange, 16);
            bArrCopyOf[length2] = -128;
            bArrZzc = zzgqv.zzc(bArrCopyOf, this.zzc);
        }
        byte[] bArrDoFinal = new byte[16];
        for (int i4 = 0; i4 < i2; i4++) {
            bArrDoFinal = cipherZzb.doFinal(zzgqv.zzd(bArrDoFinal, 0, bArr, i4 * 16, 16));
        }
        return Arrays.copyOf(cipherZzb.doFinal(zzgqv.zzc(bArrZzc, bArrDoFinal)), i);
    }
}
