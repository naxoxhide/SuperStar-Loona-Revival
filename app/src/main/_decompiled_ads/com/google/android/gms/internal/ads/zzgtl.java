package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgtl {
    static final zzgtl zza = new zzgtl(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzgtl zzd;
    private final Map zze;

    zzgtl() {
        this.zze = new HashMap();
    }

    public static zzgtl zza() {
        return zza;
    }

    public final zzgtx zzc(zzgvj zzgvjVar, int i) {
        return (zzgtx) this.zze.get(new zzgtk(zzgvjVar, i));
    }

    zzgtl(boolean z) {
        this.zze = Collections.emptyMap();
    }

    public static zzgtl zzb() {
        zzgtl zzgtlVar = zzd;
        if (zzgtlVar != null) {
            return zzgtlVar;
        }
        synchronized (zzgtl.class) {
            zzgtl zzgtlVar2 = zzd;
            if (zzgtlVar2 != null) {
                return zzgtlVar2;
            }
            zzgtl zzgtlVarZzb = zzgtt.zzb(zzgtl.class);
            zzd = zzgtlVarZzb;
            return zzgtlVarZzb;
        }
    }
}
