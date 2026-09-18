package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgjt {

    @Nullable
    private zzgkf zza = null;

    @Nullable
    private zzgry zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzgjt() {
    }

    /* synthetic */ zzgjt(zzgjs zzgjsVar) {
    }

    public final zzgjt zza(zzgry zzgryVar) throws GeneralSecurityException {
        this.zzb = zzgryVar;
        return this;
    }

    public final zzgjt zzb(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgjt zzc(zzgkf zzgkfVar) {
        this.zza = zzgkfVar;
        return this;
    }

    public final zzgjv zzd() throws GeneralSecurityException {
        zzgry zzgryVar;
        zzgrx zzgrxVarZzb;
        zzgkf zzgkfVar = this.zza;
        if (zzgkfVar == null || (zzgryVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgkfVar.zzb() != zzgryVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzgkfVar.zze() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zze() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzd() == zzgkd.zzd) {
            zzgrxVarZzb = zzgrx.zzb(new byte[0]);
        } else if (this.zza.zzd() == zzgkd.zzc || this.zza.zzd() == zzgkd.zzb) {
            zzgrxVarZzb = zzgrx.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
        } else {
            if (this.zza.zzd() != zzgkd.zza) {
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzd()))));
            }
            zzgrxVarZzb = zzgrx.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
        }
        return new zzgjv(this.zza, this.zzb, zzgrxVarZzb, this.zzc, null);
    }
}
