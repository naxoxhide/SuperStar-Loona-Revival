package com.google.android.gms.internal.ads;

import android.os.IBinder;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfrs extends zzfrm {
    final /* synthetic */ IBinder zza;
    final /* synthetic */ zzfrv zzb;

    zzfrs(zzfrv zzfrvVar, IBinder iBinder) {
        this.zzb = zzfrvVar;
        this.zza = iBinder;
    }

    @Override // com.google.android.gms.internal.ads.zzfrm
    public final void zza() {
        this.zzb.zza.zzn = zzfrh.zzb(this.zza);
        zzfrw.zzq(this.zzb.zza);
        this.zzb.zza.zzh = false;
        Iterator it = this.zzb.zza.zze.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.zzb.zza.zze.clear();
    }
}
