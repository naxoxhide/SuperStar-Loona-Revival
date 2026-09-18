package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcsk implements zzcyz, zzcyf {
    private final Context zza;
    private final zzcgb zzb;
    private final zzfcr zzc;
    private final zzcaz zzd;
    private zzfkc zze;
    private boolean zzf;

    public zzcsk(Context context, zzcgb zzcgbVar, zzfcr zzfcrVar, zzcaz zzcazVar) {
        this.zza = context;
        this.zzb = zzcgbVar;
        this.zzc = zzfcrVar;
        this.zzd = zzcazVar;
    }

    private final synchronized void zza() {
        zzeep zzeepVar;
        zzeeo zzeeoVar;
        if (this.zzc.zzV) {
            if (this.zzb == null) {
                return;
            }
            if (com.google.android.gms.ads.internal.zzt.zzA().zzj(this.zza)) {
                zzcaz zzcazVar = this.zzd;
                String str = zzcazVar.zzb + "." + zzcazVar.zzc;
                zzfdq zzfdqVar = this.zzc.zzX;
                String strZza = zzfdqVar.zza();
                if (zzfdqVar.zzb() == 1) {
                    zzeeoVar = zzeeo.VIDEO;
                    zzeepVar = zzeep.DEFINED_BY_JAVASCRIPT;
                } else {
                    zzfcr zzfcrVar = this.zzc;
                    zzeeo zzeeoVar2 = zzeeo.HTML_DISPLAY;
                    zzeepVar = zzfcrVar.zzf == 1 ? zzeep.ONE_PIXEL : zzeep.BEGIN_TO_RENDER;
                    zzeeoVar = zzeeoVar2;
                }
                zzfkc zzfkcVarZza = com.google.android.gms.ads.internal.zzt.zzA().zza(str, this.zzb.zzG(), "", "javascript", strZza, zzeepVar, zzeeoVar, this.zzc.zzan);
                this.zze = zzfkcVarZza;
                Object obj = this.zzb;
                if (zzfkcVarZza != null) {
                    com.google.android.gms.ads.internal.zzt.zzA().zzh(this.zze, (View) obj);
                    this.zzb.zzap(this.zze);
                    com.google.android.gms.ads.internal.zzt.zzA().zzi(this.zze);
                    this.zzf = true;
                    this.zzb.zzd("onSdkLoaded", new ArrayMap());
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyf
    public final synchronized void zzq() {
        zzcgb zzcgbVar;
        if (!this.zzf) {
            zza();
        }
        if (!this.zzc.zzV || this.zze == null || (zzcgbVar = this.zzb) == null) {
            return;
        }
        zzcgbVar.zzd("onSdkImpression", new ArrayMap());
    }

    @Override // com.google.android.gms.internal.ads.zzcyz
    public final synchronized void zzr() {
        if (this.zzf) {
            return;
        }
        zza();
    }
}
