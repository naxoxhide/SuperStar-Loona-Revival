package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaxr {
    private zzaxg zza;
    private boolean zzb;
    private final Context zzc;
    private final Object zzd = new Object();

    zzaxr(Context context) {
        this.zzc = context;
    }

    final Future zzc(zzaxh zzaxhVar) {
        zzaxl zzaxlVar = new zzaxl(this);
        zzaxp zzaxpVar = new zzaxp(this, zzaxhVar, zzaxlVar);
        zzaxq zzaxqVar = new zzaxq(this, zzaxlVar);
        synchronized (this.zzd) {
            zzaxg zzaxgVar = new zzaxg(this.zzc, com.google.android.gms.ads.internal.zzt.zzt().zzb(), zzaxpVar, zzaxqVar);
            this.zza = zzaxgVar;
            zzaxgVar.checkAvailabilityAndConnect();
        }
        return zzaxlVar;
    }

    static /* bridge */ /* synthetic */ void zze(zzaxr zzaxrVar) {
        synchronized (zzaxrVar.zzd) {
            zzaxg zzaxgVar = zzaxrVar.zza;
            if (zzaxgVar == null) {
                return;
            }
            zzaxgVar.disconnect();
            zzaxrVar.zza = null;
            Binder.flushPendingCommands();
        }
    }
}
