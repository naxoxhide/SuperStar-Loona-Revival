package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzezu implements zzfai {
    private final zzffa zza;
    private final Executor zzb;
    private final zzfzp zzc = new zzezs(this);

    public zzezu(zzffa zzffaVar, Executor executor) {
        this.zza = zzffaVar;
        this.zzb = executor;
    }

    final /* synthetic */ ListenableFuture zza(zzcws zzcwsVar, zzfad zzfadVar) throws Exception {
        zzffa zzffaVar = this.zza;
        zzffk zzffkVar = zzfadVar.zzb;
        zzbvg zzbvgVar = zzfadVar.zza;
        zzffj zzffjVarZzb = zzffaVar.zzb(zzffkVar);
        if (zzffjVarZzb != null && zzbvgVar != null) {
            zzfzt.zzr(zzcwsVar.zzb().zzh(zzbvgVar), this.zzc, this.zzb);
        }
        return zzfzt.zzh(new zzezt(zzffkVar, zzbvgVar, zzffjVarZzb));
    }

    public final ListenableFuture zzb(zzfaj zzfajVar, zzfah zzfahVar, final zzcws zzcwsVar) {
        return zzfzt.zze(zzfzt.zzn(zzfzk.zzu(new zzfae(this.zza, zzcwsVar, this.zzb).zzc()), new zzfza() { // from class: com.google.android.gms.internal.ads.zzezq
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zza(zzcwsVar, (zzfad) obj);
            }
        }, this.zzb), Exception.class, new zzezr(this), this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzfai
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfaj zzfajVar, zzfah zzfahVar, Object obj) {
        return zzb(zzfajVar, zzfahVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfai
    public final /* bridge */ /* synthetic */ Object zzd() {
        return null;
    }
}
