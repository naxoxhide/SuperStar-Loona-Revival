package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzol {
    public static final zzol zza;
    private final zzok zzb;

    static {
        zza = zzfk.zza < 31 ? new zzol() : new zzol(zzok.zza);
    }

    public zzol() {
        zzdx.zzf(zzfk.zza < 31);
        this.zzb = null;
    }

    private zzol(zzok zzokVar) {
        this.zzb = zzokVar;
    }

    public final LogSessionId zza() {
        zzok zzokVar = this.zzb;
        Objects.requireNonNull(zzokVar);
        return zzokVar.zzb;
    }

    public zzol(LogSessionId logSessionId) {
        this.zzb = new zzok(logSessionId);
    }
}
