package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfvz extends zzftt {
    final /* synthetic */ Iterator zza;
    final /* synthetic */ zzfsx zzb;

    zzfvz(Iterator it, zzfsx zzfsxVar) {
        this.zza = it;
        this.zzb = zzfsxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzftt
    @CheckForNull
    protected final Object zza() {
        while (this.zza.hasNext()) {
            Iterator it = this.zza;
            zzfsx zzfsxVar = this.zzb;
            Object next = it.next();
            if (zzfsxVar.zza(next)) {
                return next;
            }
        }
        zzb();
        return null;
    }
}
