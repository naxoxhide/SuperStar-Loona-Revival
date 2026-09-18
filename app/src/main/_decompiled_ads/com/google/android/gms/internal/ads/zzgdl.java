package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgdl {

    @Nullable
    private zzgdv zza = null;

    @Nullable
    private zzgry zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzgdl() {
    }

    /* synthetic */ zzgdl(zzgdk zzgdkVar) {
    }

    public final zzgdl zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgdl zzb(zzgry zzgryVar) {
        this.zzb = zzgryVar;
        return this;
    }

    public final zzgdl zzc(zzgdv zzgdvVar) {
        this.zza = zzgdvVar;
        return this;
    }

    public final zzgdn zzd() throws GeneralSecurityException {
        zzgry zzgryVar;
        zzgrx zzgrxVarZzb;
        zzgdv zzgdvVar = this.zza;
        if (zzgdvVar == null || (zzgryVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgdvVar.zzb() != zzgryVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzgdvVar.zzd() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zzd() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzc() == zzgdt.zzc) {
            zzgrxVarZzb = zzgrx.zzb(new byte[0]);
        } else if (this.zza.zzc() == zzgdt.zzb) {
            zzgrxVarZzb = zzgrx.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
        } else {
            if (this.zza.zzc() != zzgdt.zza) {
                throw new IllegalStateException("Unknown AesEaxParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzc()))));
            }
            zzgrxVarZzb = zzgrx.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
        }
        return new zzgdn(this.zza, this.zzb, zzgrxVarZzb, this.zzc, null);
    }
}
