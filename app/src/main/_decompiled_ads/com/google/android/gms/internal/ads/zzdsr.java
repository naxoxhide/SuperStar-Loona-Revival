package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdsr implements zzfhs {
    private final zzdsj zzb;
    private final Clock zzc;
    private final Map zza = new HashMap();
    private final Map zzd = new HashMap();

    public zzdsr(zzdsj zzdsjVar, Set set, Clock clock) {
        this.zzb = zzdsjVar;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzdsq zzdsqVar = (zzdsq) it.next();
            this.zzd.put(zzdsqVar.zzc, zzdsqVar);
        }
        this.zzc = clock;
    }

    private final void zze(zzfhl zzfhlVar, boolean z) {
        zzfhl zzfhlVar2 = ((zzdsq) this.zzd.get(zzfhlVar)).zzb;
        if (this.zza.containsKey(zzfhlVar2)) {
            String str = true != z ? "f." : "s.";
            long jElapsedRealtime = this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzfhlVar2)).longValue();
            this.zzb.zza().put("label.".concat(((zzdsq) this.zzd.get(zzfhlVar)).zza), str.concat(String.valueOf(Long.toString(jElapsedRealtime))));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfhs
    public final void zzbG(zzfhl zzfhlVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzfhs
    public final void zzbH(zzfhl zzfhlVar, String str, Throwable th) {
        if (this.zza.containsKey(zzfhlVar)) {
            long jElapsedRealtime = this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzfhlVar)).longValue();
            zzdsj zzdsjVar = this.zzb;
            String strValueOf = String.valueOf(str);
            zzdsjVar.zza().put("task.".concat(strValueOf), "f.".concat(String.valueOf(Long.toString(jElapsedRealtime))));
        }
        if (this.zzd.containsKey(zzfhlVar)) {
            zze(zzfhlVar, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfhs
    public final void zzbI(zzfhl zzfhlVar, String str) {
        this.zza.put(zzfhlVar, Long.valueOf(this.zzc.elapsedRealtime()));
    }

    @Override // com.google.android.gms.internal.ads.zzfhs
    public final void zzd(zzfhl zzfhlVar, String str) {
        if (this.zza.containsKey(zzfhlVar)) {
            long jElapsedRealtime = this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzfhlVar)).longValue();
            zzdsj zzdsjVar = this.zzb;
            String strValueOf = String.valueOf(str);
            zzdsjVar.zza().put("task.".concat(strValueOf), "s.".concat(String.valueOf(Long.toString(jElapsedRealtime))));
        }
        if (this.zzd.containsKey(zzfhlVar)) {
            zze(zzfhlVar, true);
        }
    }
}
