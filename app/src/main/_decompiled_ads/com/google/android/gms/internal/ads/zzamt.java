package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzamt implements zzamf {
    private final Map zza = new HashMap();
    private final zzals zzb;
    private final BlockingQueue zzc;
    private final zzalx zzd;

    zzamt(zzals zzalsVar, BlockingQueue blockingQueue, zzalx zzalxVar) {
        this.zzd = zzalxVar;
        this.zzb = zzalsVar;
        this.zzc = blockingQueue;
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final synchronized void zza(zzamg zzamgVar) {
        Map map = this.zza;
        String strZzj = zzamgVar.zzj();
        List list = (List) map.remove(strZzj);
        if (list == null || list.isEmpty()) {
            return;
        }
        if (zzams.zzb) {
            zzams.zzd("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), strZzj);
        }
        zzamg zzamgVar2 = (zzamg) list.remove(0);
        this.zza.put(strZzj, list);
        zzamgVar2.zzu(this);
        try {
            this.zzc.put(zzamgVar2);
        } catch (InterruptedException e) {
            zzams.zzb("Couldn't add request to queue. %s", e.toString());
            Thread.currentThread().interrupt();
            this.zzb.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzb(zzamg zzamgVar, zzamm zzammVar) {
        List list;
        zzalp zzalpVar = zzammVar.zzb;
        if (zzalpVar == null || zzalpVar.zza(System.currentTimeMillis())) {
            zza(zzamgVar);
            return;
        }
        String strZzj = zzamgVar.zzj();
        synchronized (this) {
            list = (List) this.zza.remove(strZzj);
        }
        if (list != null) {
            if (zzams.zzb) {
                zzams.zzd("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), strZzj);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.zzd.zzb((zzamg) it.next(), zzammVar, null);
            }
        }
    }

    final synchronized boolean zzc(zzamg zzamgVar) {
        Map map = this.zza;
        String strZzj = zzamgVar.zzj();
        if (!map.containsKey(strZzj)) {
            this.zza.put(strZzj, null);
            zzamgVar.zzu(this);
            if (zzams.zzb) {
                zzams.zza("new request, sending to network %s", strZzj);
            }
            return false;
        }
        List arrayList = (List) this.zza.get(strZzj);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        zzamgVar.zzm("waiting-for-response");
        arrayList.add(zzamgVar);
        this.zza.put(strZzj, arrayList);
        if (zzams.zzb) {
            zzams.zza("Request for cacheKey=%s is in flight, putting on hold.", strZzj);
        }
        return true;
    }
}
