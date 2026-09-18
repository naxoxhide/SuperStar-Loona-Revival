package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzggi extends zzgck {
    private final zzggn zza;
    private final zzgry zzb;
    private final zzgrx zzc;

    @Nullable
    private final Integer zzd;

    private zzggi(zzggn zzggnVar, zzgry zzgryVar, zzgrx zzgrxVar, @Nullable Integer num) {
        this.zza = zzggnVar;
        this.zzb = zzgryVar;
        this.zzc = zzgrxVar;
        this.zzd = num;
    }

    public static zzggi zza(zzggm zzggmVar, zzgry zzgryVar, @Nullable Integer num) throws GeneralSecurityException {
        zzgrx zzgrxVarZzb;
        zzggm zzggmVar2 = zzggm.zzc;
        if (zzggmVar != zzggmVar2 && num == null) {
            throw new GeneralSecurityException("For given Variant " + zzggmVar.toString() + " the value of idRequirement must be non-null");
        }
        if (zzggmVar == zzggmVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzgryVar.zza() != 32) {
            throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zzgryVar.zza());
        }
        zzggn zzggnVarZzb = zzggn.zzb(zzggmVar);
        if (zzggnVarZzb.zza() == zzggmVar2) {
            zzgrxVarZzb = zzgrx.zzb(new byte[0]);
        } else if (zzggnVarZzb.zza() == zzggm.zzb) {
            zzgrxVarZzb = zzgrx.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
        } else {
            if (zzggnVarZzb.zza() != zzggm.zza) {
                throw new IllegalStateException("Unknown Variant: ".concat(zzggnVarZzb.zza().toString()));
            }
            zzgrxVarZzb = zzgrx.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        }
        return new zzggi(zzggnVarZzb, zzgryVar, zzgrxVarZzb, num);
    }
}
