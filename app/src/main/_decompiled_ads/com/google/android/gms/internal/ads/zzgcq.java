package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgcq {

    @Nullable
    private zzgdb zza = null;

    @Nullable
    private zzgry zzb = null;

    @Nullable
    private zzgry zzc = null;

    @Nullable
    private Integer zzd = null;

    private zzgcq() {
    }

    /* synthetic */ zzgcq(zzgcp zzgcpVar) {
    }

    public final zzgcq zza(zzgry zzgryVar) {
        this.zzb = zzgryVar;
        return this;
    }

    public final zzgcq zzb(zzgry zzgryVar) {
        this.zzc = zzgryVar;
        return this;
    }

    public final zzgcq zzc(@Nullable Integer num) {
        this.zzd = num;
        return this;
    }

    public final zzgcq zzd(zzgdb zzgdbVar) {
        this.zza = zzgdbVar;
        return this;
    }

    public final zzgcs zze() throws GeneralSecurityException {
        zzgrx zzgrxVarZzb;
        zzgdb zzgdbVar = this.zza;
        if (zzgdbVar == null) {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
        zzgry zzgryVar = this.zzb;
        if (zzgryVar == null || this.zzc == null) {
            throw new GeneralSecurityException("Cannot build without key material");
        }
        if (zzgdbVar.zza() != zzgryVar.zza()) {
            throw new GeneralSecurityException("AES key size mismatch");
        }
        if (zzgdbVar.zzb() != this.zzc.zza()) {
            throw new GeneralSecurityException("HMAC key size mismatch");
        }
        if (this.zza.zzg() && this.zzd == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zzg() && this.zzd != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzf() == zzgcz.zzc) {
            zzgrxVarZzb = zzgrx.zzb(new byte[0]);
        } else if (this.zza.zzf() == zzgcz.zzb) {
            zzgrxVarZzb = zzgrx.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzd.intValue()).array());
        } else {
            if (this.zza.zzf() != zzgcz.zza) {
                throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzf()))));
            }
            zzgrxVarZzb = zzgrx.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzd.intValue()).array());
        }
        return new zzgcs(this.zza, this.zzb, this.zzc, zzgrxVarZzb, this.zzd, null);
    }
}
