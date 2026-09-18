package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdkv {
    private final zzdpt zza;
    private final zzdoi zzb;
    private final zzcqb zzc;
    private final zzdjr zzd;

    public zzdkv(zzdpt zzdptVar, zzdoi zzdoiVar, zzcqb zzcqbVar, zzdjr zzdjrVar) {
        this.zza = zzdptVar;
        this.zzb = zzdoiVar;
        this.zzc = zzcqbVar;
        this.zzd = zzdjrVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View zza() throws zzcgm {
        zzcgb zzcgbVarZza = this.zza.zza(com.google.android.gms.ads.internal.client.zzq.zzc(), null, null);
        View view = (View) zzcgbVarZza;
        view.setVisibility(8);
        zzcgbVarZza.zzad("/sendMessageToSdk", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdkq
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, Map map) {
                this.zza.zzb((zzcgb) obj, map);
            }
        });
        zzcgbVarZza.zzad("/adMuted", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdkr
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, Map map) {
                this.zza.zzc((zzcgb) obj, map);
            }
        });
        this.zzb.zzj(new WeakReference(zzcgbVarZza), "/loadHtml", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdks
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, final Map map) {
                zzcgb zzcgbVar = (zzcgb) obj;
                zzcho zzchoVarZzN = zzcgbVar.zzN();
                final zzdkv zzdkvVar = this.zza;
                zzchoVarZzN.zzA(new zzchm() { // from class: com.google.android.gms.internal.ads.zzdkp
                    @Override // com.google.android.gms.internal.ads.zzchm
                    public final void zza(boolean z, int i, String str, String str2) {
                        zzdkvVar.zzd(map, z, i, str, str2);
                    }
                });
                String str = (String) map.get("overlayHtml");
                String str2 = (String) map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    zzcgbVar.loadData(str, "text/html", "UTF-8");
                } else {
                    zzcgbVar.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
                }
            }
        });
        this.zzb.zzj(new WeakReference(zzcgbVarZza), "/showOverlay", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdkt
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, Map map) {
                this.zza.zze((zzcgb) obj, map);
            }
        });
        this.zzb.zzj(new WeakReference(zzcgbVarZza), "/hideOverlay", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdku
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, Map map) {
                this.zza.zzf((zzcgb) obj, map);
            }
        });
        return view;
    }

    final /* synthetic */ void zzb(zzcgb zzcgbVar, Map map) {
        this.zzb.zzg("sendMessageToNativeJs", map);
    }

    final /* synthetic */ void zzc(zzcgb zzcgbVar, Map map) {
        this.zzd.zzg();
    }

    final /* synthetic */ void zzd(Map map, boolean z, int i, String str, String str2) {
        HashMap map2 = new HashMap();
        map2.put("messageType", "htmlLoaded");
        map2.put("id", (String) map.get("id"));
        this.zzb.zzg("sendMessageToNativeJs", map2);
    }

    final /* synthetic */ void zze(zzcgb zzcgbVar, Map map) {
        zzcat.zzi("Showing native ads overlay.");
        zzcgbVar.zzF().setVisibility(0);
        this.zzc.zze(true);
    }

    final /* synthetic */ void zzf(zzcgb zzcgbVar, Map map) {
        zzcat.zzi("Hiding native ads overlay.");
        zzcgbVar.zzF().setVisibility(8);
        this.zzc.zze(false);
    }
}
