package com.google.android.gms.internal.ads;

import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfyx extends zzfyu {
    private zzfyx() {
        super(null);
    }

    /* synthetic */ zzfyx(zzfyw zzfywVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.ads.zzfyu
    final int zza(zzfyy zzfyyVar) {
        int i;
        synchronized (zzfyyVar) {
            i = zzfyyVar.remaining - 1;
            zzfyyVar.remaining = i;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzfyu
    final void zzb(zzfyy zzfyyVar, @CheckForNull Set set, Set set2) {
        synchronized (zzfyyVar) {
            if (zzfyyVar.seenExceptions == null) {
                zzfyyVar.seenExceptions = set2;
            }
        }
    }
}
