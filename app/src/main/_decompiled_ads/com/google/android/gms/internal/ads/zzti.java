package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzti {
    private final zzabt zza;
    private final Map zzb = new HashMap();
    private final Set zzc = new HashSet();
    private final Map zzd = new HashMap();
    private zzgh zze;

    public zzti(zzabt zzabtVar) {
        this.zza = zzabtVar;
    }

    public final void zza(zzgh zzghVar) {
        if (zzghVar != this.zze) {
            this.zze = zzghVar;
            this.zzb.clear();
            this.zzd.clear();
        }
    }
}
