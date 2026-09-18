package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdnd {
    private final Executor zza;
    private final zzcqb zzb;
    private final zzdex zzc;

    zzdnd(Executor executor, zzcqb zzcqbVar, zzdex zzdexVar) {
        this.zza = executor;
        this.zzc = zzdexVar;
        this.zzb = zzcqbVar;
    }

    public final void zza(final zzcgb zzcgbVar) {
        if (zzcgbVar == null) {
            return;
        }
        this.zzc.zza(zzcgbVar.zzF());
        this.zzc.zzo(new zzauw() { // from class: com.google.android.gms.internal.ads.zzdmz
            @Override // com.google.android.gms.internal.ads.zzauw
            public final void zzbt(zzauv zzauvVar) {
                zzcho zzchoVarZzN = zzcgbVar.zzN();
                Rect rect = zzauvVar.zzd;
                zzchoVarZzN.zzp(rect.left, rect.top, false);
            }
        }, this.zza);
        this.zzc.zzo(new zzauw() { // from class: com.google.android.gms.internal.ads.zzdna
            @Override // com.google.android.gms.internal.ads.zzauw
            public final void zzbt(zzauv zzauvVar) {
                HashMap map = new HashMap();
                map.put("isVisible", true != zzauvVar.zzj ? "0" : "1");
                zzcgbVar.zzd("onAdVisibilityChanged", map);
            }
        }, this.zza);
        this.zzc.zzo(this.zzb, this.zza);
        this.zzb.zzf(zzcgbVar);
        zzcgbVar.zzad("/trackActiveViewUnit", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdnb
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, Map map) {
                this.zza.zzb((zzcgb) obj, map);
            }
        });
        zzcgbVar.zzad("/untrackActiveViewUnit", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdnc
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, Map map) {
                this.zza.zzc((zzcgb) obj, map);
            }
        });
    }

    final /* synthetic */ void zzb(zzcgb zzcgbVar, Map map) {
        this.zzb.zzb();
    }

    final /* synthetic */ void zzc(zzcgb zzcgbVar, Map map) {
        this.zzb.zza();
    }
}
