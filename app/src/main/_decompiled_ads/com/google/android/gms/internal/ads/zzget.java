package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzget {

    @Nullable
    private zzgfd zza = null;

    @Nullable
    private zzgry zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzget() {
    }

    /* synthetic */ zzget(zzges zzgesVar) {
    }

    public final zzget zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzget zzb(zzgry zzgryVar) {
        this.zzb = zzgryVar;
        return this;
    }

    public final zzget zzc(zzgfd zzgfdVar) {
        this.zza = zzgfdVar;
        return this;
    }

    public final zzgev zzd() throws GeneralSecurityException {
        zzgry zzgryVar;
        zzgrx zzgrxVarZzb;
        zzgfd zzgfdVar = this.zza;
        if (zzgfdVar == null || (zzgryVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgfdVar.zza() != zzgryVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzgfdVar.zzc() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zzc() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzb() == zzgfb.zzc) {
            zzgrxVarZzb = zzgrx.zzb(new byte[0]);
        } else if (this.zza.zzb() == zzgfb.zzb) {
            zzgrxVarZzb = zzgrx.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
        } else {
            if (this.zza.zzb() != zzgfb.zza) {
                throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzb()))));
            }
            zzgrxVarZzb = zzgrx.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
        }
        return new zzgev(this.zza, this.zzb, zzgrxVarZzb, this.zzc, null);
    }
}
