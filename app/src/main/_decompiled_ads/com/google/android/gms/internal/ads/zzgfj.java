package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgfj extends zzgck {
    private final zzgfo zza;
    private final zzgry zzb;
    private final zzgrx zzc;

    @Nullable
    private final Integer zzd;

    private zzgfj(zzgfo zzgfoVar, zzgry zzgryVar, zzgrx zzgrxVar, @Nullable Integer num) {
        this.zza = zzgfoVar;
        this.zzb = zzgryVar;
        this.zzc = zzgrxVar;
        this.zzd = num;
    }

    public static zzgfj zza(zzgfn zzgfnVar, zzgry zzgryVar, @Nullable Integer num) throws GeneralSecurityException {
        zzgrx zzgrxVarZzb;
        zzgfn zzgfnVar2 = zzgfn.zzc;
        if (zzgfnVar != zzgfnVar2 && num == null) {
            throw new GeneralSecurityException("For given Variant " + zzgfnVar.toString() + " the value of idRequirement must be non-null");
        }
        if (zzgfnVar == zzgfnVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzgryVar.zza() != 32) {
            throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zzgryVar.zza());
        }
        zzgfo zzgfoVarZzb = zzgfo.zzb(zzgfnVar);
        if (zzgfoVarZzb.zza() == zzgfnVar2) {
            zzgrxVarZzb = zzgrx.zzb(new byte[0]);
        } else if (zzgfoVarZzb.zza() == zzgfn.zzb) {
            zzgrxVarZzb = zzgrx.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
        } else {
            if (zzgfoVarZzb.zza() != zzgfn.zza) {
                throw new IllegalStateException("Unknown Variant: ".concat(zzgfoVarZzb.zza().toString()));
            }
            zzgrxVarZzb = zzgrx.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        }
        return new zzgfj(zzgfoVarZzb, zzgryVar, zzgrxVarZzb, num);
    }
}
