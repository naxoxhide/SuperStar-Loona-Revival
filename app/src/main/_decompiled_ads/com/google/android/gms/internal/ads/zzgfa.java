package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgfa {

    @Nullable
    private Integer zza;
    private zzgfb zzb;

    private zzgfa() {
        this.zza = null;
        throw null;
    }

    /* synthetic */ zzgfa(zzgez zzgezVar) {
        this.zza = null;
        this.zzb = zzgfb.zzc;
    }

    public final zzgfa zzb(zzgfb zzgfbVar) {
        this.zzb = zzgfbVar;
        return this;
    }

    public final zzgfd zzc() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        }
        if (this.zzb != null) {
            return new zzgfd(num.intValue(), this.zzb, null);
        }
        throw new GeneralSecurityException("Variant is not set");
    }

    public final zzgfa zza(int i) throws GeneralSecurityException {
        if (i != 16 && i != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", Integer.valueOf(i)));
        }
        this.zza = Integer.valueOf(i);
        return this;
    }
}
