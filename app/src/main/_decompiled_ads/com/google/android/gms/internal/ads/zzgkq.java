package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgkq {

    @Nullable
    private zzgld zza = null;

    @Nullable
    private zzgry zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzgkq() {
    }

    /* synthetic */ zzgkq(zzgkp zzgkpVar) {
    }

    public final zzgkq zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgkq zzb(zzgry zzgryVar) {
        this.zzb = zzgryVar;
        return this;
    }

    public final zzgkq zzc(zzgld zzgldVar) {
        this.zza = zzgldVar;
        return this;
    }

    public final zzgks zzd() throws GeneralSecurityException {
        zzgry zzgryVar;
        zzgrx zzgrxVarZzb;
        zzgld zzgldVar = this.zza;
        if (zzgldVar == null || (zzgryVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgldVar.zzb() != zzgryVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzgldVar.zzg() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zzg() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzf() == zzglb.zzd) {
            zzgrxVarZzb = zzgrx.zzb(new byte[0]);
        } else if (this.zza.zzf() == zzglb.zzc || this.zza.zzf() == zzglb.zzb) {
            zzgrxVarZzb = zzgrx.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
        } else {
            if (this.zza.zzf() != zzglb.zza) {
                throw new IllegalStateException("Unknown HmacParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzf()))));
            }
            zzgrxVarZzb = zzgrx.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
        }
        return new zzgks(this.zza, this.zzb, zzgrxVarZzb, this.zzc, null);
    }
}
