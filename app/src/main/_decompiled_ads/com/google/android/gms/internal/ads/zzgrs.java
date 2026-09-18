package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgrs implements zzgmk {
    private final ThreadLocal zza;
    private final String zzb;
    private final Key zzc;
    private final int zzd;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    public zzgrs(String str, Key key) throws GeneralSecurityException {
        byte b2;
        int i;
        zzgrr zzgrrVar = new zzgrr(this);
        this.zza = zzgrrVar;
        if (!zzghf.zza(2)) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.zzb = str;
        this.zzc = key;
        if (key.getEncoded().length < 16) {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        switch (str) {
            case "HMACSHA1":
                b2 = 0;
                break;
            case "HMACSHA224":
                b2 = 1;
                break;
            case "HMACSHA256":
                b2 = 2;
                break;
            case "HMACSHA384":
                b2 = 3;
                break;
            case "HMACSHA512":
                b2 = 4;
                break;
            default:
                b2 = -1;
                break;
        }
        if (b2 != 0) {
            if (b2 == 1) {
                i = 28;
            } else if (b2 == 2) {
                i = 32;
            } else if (b2 == 3) {
                i = 48;
            } else {
                if (b2 != 4) {
                    throw new NoSuchAlgorithmException("unknown Hmac algorithm: ".concat(str));
                }
                i = 64;
            }
            this.zzd = i;
        } else {
            this.zzd = 20;
        }
        zzgrrVar.get();
    }

    @Override // com.google.android.gms.internal.ads.zzgmk
    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        if (i > this.zzd) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        ((Mac) this.zza.get()).update(bArr);
        return Arrays.copyOf(((Mac) this.zza.get()).doFinal(), i);
    }
}
