package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzglz implements zzgbv {
    private static final byte[] zza = {0};
    private final zzgbv zzb;
    private final zzgqf zzc;
    private final byte[] zzd;

    private zzglz(zzgbv zzgbvVar, zzgqf zzgqfVar, byte[] bArr) {
        this.zzb = zzgbvVar;
        this.zzc = zzgqfVar;
        this.zzd = bArr;
    }

    public static zzgbv zzb(zzghx zzghxVar) throws GeneralSecurityException {
        byte[] bArrArray;
        zzgjc zzgjcVarZza = zzghxVar.zza(zzgbd.zza());
        zzgow zzgowVarZza = zzgoz.zza();
        zzgowVarZza.zzb(zzgjcVarZza.zzg());
        zzgowVarZza.zzc(zzgjcVarZza.zze());
        zzgowVarZza.zza(zzgjcVarZza.zzb());
        zzgbv zzgbvVar = (zzgbv) zzgcg.zzc((zzgoz) zzgowVarZza.zzal(), zzgbv.class);
        zzgqf zzgqfVarZzc = zzgjcVarZza.zzc();
        zzgqf zzgqfVar = zzgqf.UNKNOWN_PREFIX;
        int iOrdinal = zzgqfVarZzc.ordinal();
        if (iOrdinal == 1) {
            bArrArray = ByteBuffer.allocate(5).put((byte) 1).putInt(zzghxVar.zzb().intValue()).array();
        } else if (iOrdinal == 2) {
            bArrArray = ByteBuffer.allocate(5).put((byte) 0).putInt(zzghxVar.zzb().intValue()).array();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            bArrArray = ByteBuffer.allocate(5).put((byte) 0).putInt(zzghxVar.zzb().intValue()).array();
        } else {
            bArrArray = new byte[0];
        }
        return new zzglz(zzgbvVar, zzgqfVarZzc, bArrArray);
    }

    @Override // com.google.android.gms.internal.ads.zzgbv
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length < 10) {
            throw new GeneralSecurityException("tag too short");
        }
        if (this.zzc.equals(zzgqf.LEGACY)) {
            bArr2 = zzgqv.zzb(bArr2, zza);
        }
        byte[] bArr3 = new byte[0];
        if (!this.zzc.equals(zzgqf.RAW)) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
            bArr = Arrays.copyOfRange(bArr, 5, length);
            bArr3 = bArrCopyOf;
        }
        if (!Arrays.equals(this.zzd, bArr3)) {
            throw new GeneralSecurityException("wrong prefix");
        }
        this.zzb.zza(bArr, bArr2);
    }
}
