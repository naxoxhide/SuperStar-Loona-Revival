package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdhg implements zzcyz, com.google.android.gms.ads.internal.overlay.zzo, zzcyf {
    zzfkc zza;
    private final Context zzb;
    private final zzcgb zzc;
    private final zzfcr zzd;
    private final zzcaz zze;
    private final zzayf zzf;

    public zzdhg(Context context, zzcgb zzcgbVar, zzfcr zzfcrVar, zzcaz zzcazVar, zzayf zzayfVar) {
        this.zzb = context;
        this.zzc = zzcgbVar;
        this.zzd = zzfcrVar;
        this.zze = zzcazVar;
        this.zzf = zzayfVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzbL() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzbo() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzbu() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzbv() {
        if (this.zza == null || this.zzc == null) {
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzeX)).booleanValue()) {
            return;
        }
        this.zzc.zzd("onSdkImpression", new ArrayMap());
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzbx() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzby(int i) {
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzcyf
    public final void zzq() {
        if (this.zza == null || this.zzc == null) {
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzeX)).booleanValue()) {
            this.zzc.zzd("onSdkImpression", new ArrayMap());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyz
    public final void zzr() {
        zzeep zzeepVar;
        zzeeo zzeeoVar;
        zzayf zzayfVar = this.zzf;
        if ((zzayfVar == zzayf.REWARD_BASED_VIDEO_AD || zzayfVar == zzayf.INTERSTITIAL || zzayfVar == zzayf.APP_OPEN) && this.zzd.zzV && this.zzc != null) {
            if (com.google.android.gms.ads.internal.zzt.zzA().zzj(this.zzb)) {
                zzcaz zzcazVar = this.zze;
                String str = zzcazVar.zzb + "." + zzcazVar.zzc;
                zzfdq zzfdqVar = this.zzd.zzX;
                String strZza = zzfdqVar.zza();
                if (zzfdqVar.zzb() == 1) {
                    zzeeoVar = zzeeo.VIDEO;
                    zzeepVar = zzeep.DEFINED_BY_JAVASCRIPT;
                } else {
                    zzeepVar = this.zzd.zzaa == 2 ? zzeep.UNSPECIFIED : zzeep.BEGIN_TO_RENDER;
                    zzeeoVar = zzeeo.HTML_DISPLAY;
                }
                zzfkc zzfkcVarZza = com.google.android.gms.ads.internal.zzt.zzA().zza(str, this.zzc.zzG(), "", "javascript", strZza, zzeepVar, zzeeoVar, this.zzd.zzan);
                this.zza = zzfkcVarZza;
                if (zzfkcVarZza != null) {
                    com.google.android.gms.ads.internal.zzt.zzA().zzh(this.zza, (View) this.zzc);
                    this.zzc.zzap(this.zza);
                    com.google.android.gms.ads.internal.zzt.zzA().zzi(this.zza);
                    this.zzc.zzd("onSdkLoaded", new ArrayMap());
                }
            }
        }
    }
}
