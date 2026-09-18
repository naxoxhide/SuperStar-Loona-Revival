package com.google.android.gms.internal.ads;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfss implements Serializable {
    zzfss() {
    }

    public static zzfss zzc() {
        return zzfsa.zza;
    }

    public static zzfss zzd(@CheckForNull Object obj) {
        return obj == null ? zzfsa.zza : new zzftb(obj);
    }

    public abstract zzfss zza(zzfsk zzfskVar);

    public abstract Object zzb(Object obj);
}
