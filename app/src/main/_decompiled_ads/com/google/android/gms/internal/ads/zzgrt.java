package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgrt implements zzgbv {
    private static final byte[] zza = {0};
    private final zzgmk zzb;
    private final int zzc;
    private final byte[] zzd;
    private final byte[] zze;

    private zzgrt(zzgjv zzgjvVar) throws GeneralSecurityException {
        this.zzb = new zzgrq(zzgjvVar.zzd().zzc(zzgbd.zza()));
        this.zzc = zzgjvVar.zza().zza();
        this.zzd = zzgjvVar.zzc().zzc();
        if (zzgjvVar.zza().zzd().equals(zzgkd.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public static zzgbv zzb(zzgjv zzgjvVar) throws GeneralSecurityException {
        return new zzgrt(zzgjvVar);
    }

    public static zzgbv zzc(zzgks zzgksVar) throws GeneralSecurityException {
        return new zzgrt(zzgksVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgbv
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zze;
        if (!MessageDigest.isEqual(bArr3.length > 0 ? zzgqv.zzb(this.zzd, this.zzb.zza(zzgqv.zzb(bArr2, bArr3), this.zzc)) : zzgqv.zzb(this.zzd, this.zzb.zza(bArr2, this.zzc)), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    private zzgrt(zzgks zzgksVar) throws GeneralSecurityException {
        String strValueOf = String.valueOf(String.valueOf(zzgksVar.zzd().zze()));
        this.zzb = new zzgrs("HMAC".concat(strValueOf), new SecretKeySpec(zzgksVar.zze().zzc(zzgbd.zza()), "HMAC"));
        this.zzc = zzgksVar.zzd().zza();
        this.zzd = zzgksVar.zzc().zzc();
        if (zzgksVar.zzd().zzf().equals(zzglb.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public zzgrt(zzgmk zzgmkVar, int i) throws GeneralSecurityException {
        this.zzb = zzgmkVar;
        this.zzc = i;
        this.zzd = new byte[0];
        this.zze = new byte[0];
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        zzgmkVar.zza(new byte[0], i);
    }
}
