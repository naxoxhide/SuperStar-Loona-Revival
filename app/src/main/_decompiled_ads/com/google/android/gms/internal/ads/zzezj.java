package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzezj implements zzfai {
    private zzcws zza;
    private final Executor zzb = zzgaj.zzb();

    public final zzcws zza() {
        return this.zza;
    }

    public final ListenableFuture zzb(zzfaj zzfajVar, zzfah zzfahVar, zzcws zzcwsVar) {
        zzcwr zzcwrVarZza = zzfahVar.zza(zzfajVar.zzb);
        zzcwrVarZza.zzb(new zzfam(true));
        zzcws zzcwsVar2 = (zzcws) zzcwrVarZza.zzh();
        this.zza = zzcwsVar2;
        final zzcue zzcueVarZzb = zzcwsVar2.zzb();
        final zzffj zzffjVar = new zzffj();
        return zzfzt.zzm(zzfzt.zzn(zzfzk.zzu(zzcueVarZzb.zzj()), new zzfza() { // from class: com.google.android.gms.internal.ads.zzezh
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                zzfde zzfdeVar = (zzfde) obj;
                zzffjVar.zzb = zzfdeVar;
                Iterator it = zzfdeVar.zzb.zza.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Iterator it2 = ((zzfcr) it.next()).zza.iterator();
                    while (it2.hasNext()) {
                        if (!((String) it2.next()).contains("FirstPartyRenderer")) {
                            return zzfzt.zzh(null);
                        }
                        z = true;
                    }
                }
                if (z) {
                    return zzcueVarZzb.zzi(zzfzt.zzh(zzfdeVar));
                }
                return zzfzt.zzh(null);
            }
        }, this.zzb), new zzfsk() { // from class: com.google.android.gms.internal.ads.zzezi
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                zzffj zzffjVar2 = zzffjVar;
                zzffjVar2.zzc = (zzcsx) obj;
                return zzffjVar2;
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzfai
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfaj zzfajVar, zzfah zzfahVar, Object obj) {
        return zzb(zzfajVar, zzfahVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfai
    public final /* synthetic */ Object zzd() {
        return this.zza;
    }
}
