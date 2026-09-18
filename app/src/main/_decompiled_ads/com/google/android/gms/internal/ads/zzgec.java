package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgec {

    @Nullable
    private zzgem zza = null;

    @Nullable
    private zzgry zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzgec() {
    }

    /* synthetic */ zzgec(zzgeb zzgebVar) {
    }

    public final zzgec zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgec zzb(zzgry zzgryVar) {
        this.zzb = zzgryVar;
        return this;
    }

    public final zzgec zzc(zzgem zzgemVar) {
        this.zza = zzgemVar;
        return this;
    }

    public final zzgee zzd() throws GeneralSecurityException {
        zzgry zzgryVar;
        zzgrx zzgrxVarZzb;
        zzgem zzgemVar = this.zza;
        if (zzgemVar == null || (zzgryVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgemVar.zza() != zzgryVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzgemVar.zzc() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zzc() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzb() == zzgek.zzc) {
            zzgrxVarZzb = zzgrx.zzb(new byte[0]);
        } else if (this.zza.zzb() == zzgek.zzb) {
            zzgrxVarZzb = zzgrx.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
        } else {
            if (this.zza.zzb() != zzgek.zza) {
                throw new IllegalStateException("Unknown AesGcmParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzb()))));
            }
            zzgrxVarZzb = zzgrx.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
        }
        return new zzgee(this.zza, this.zzb, zzgrxVarZzb, this.zzc, null);
    }
}
