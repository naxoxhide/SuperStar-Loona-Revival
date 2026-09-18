package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdne {
    private final zzfdn zza;
    private final Executor zzb;
    private final zzdpt zzc;
    private final zzdoo zzd;
    private final Context zze;
    private final zzdso zzf;
    private final zzfib zzg;
    private final zzfjx zzh;
    private final zzedo zzi;

    public zzdne(zzfdn zzfdnVar, Executor executor, zzdpt zzdptVar, Context context, zzdso zzdsoVar, zzfib zzfibVar, zzfjx zzfjxVar, zzedo zzedoVar, zzdoo zzdooVar) {
        this.zza = zzfdnVar;
        this.zzb = executor;
        this.zzc = zzdptVar;
        this.zze = context;
        this.zzf = zzdsoVar;
        this.zzg = zzfibVar;
        this.zzh = zzfjxVar;
        this.zzi = zzedoVar;
        this.zzd = zzdooVar;
    }

    private final void zzh(zzcgb zzcgbVar) {
        zzi(zzcgbVar);
        zzcgbVar.zzad("/video", zzbji.zzl);
        zzcgbVar.zzad("/videoMeta", zzbji.zzm);
        zzcgbVar.zzad("/precache", new zzceo());
        zzcgbVar.zzad("/delayPageLoaded", zzbji.zzp);
        zzcgbVar.zzad("/instrument", zzbji.zzn);
        zzcgbVar.zzad("/log", zzbji.zzg);
        zzcgbVar.zzad("/click", new zzbih(null, 0 == true ? 1 : 0));
        if (this.zza.zzb != null) {
            zzcgbVar.zzN().zzD(true);
            zzcgbVar.zzad("/open", new zzbju(null, null, null, null, null, null));
        } else {
            zzcgbVar.zzN().zzD(false);
        }
        if (com.google.android.gms.ads.internal.zzt.zzn().zzu(zzcgbVar.getContext())) {
            zzcgbVar.zzad("/logScionEvent", new zzbjo(zzcgbVar.getContext()));
        }
    }

    private static final void zzi(zzcgb zzcgbVar) {
        zzcgbVar.zzad("/videoClicked", zzbji.zzh);
        zzcgbVar.zzN().zzF(true);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdC)).booleanValue()) {
            zzcgbVar.zzad("/getNativeAdViewSignals", zzbji.zzs);
        }
        zzcgbVar.zzad("/getNativeClickMeta", zzbji.zzt);
    }

    public final ListenableFuture zza(final JSONObject jSONObject) {
        return zzfzt.zzn(zzfzt.zzn(zzfzt.zzh(null), new zzfza() { // from class: com.google.android.gms.internal.ads.zzdmv
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zze(obj);
            }
        }, this.zzb), new zzfza() { // from class: com.google.android.gms.internal.ads.zzdmu
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzc(jSONObject, (zzcgb) obj);
            }
        }, this.zzb);
    }

    public final ListenableFuture zzb(final String str, final String str2, final zzfcr zzfcrVar, final zzfcv zzfcvVar, final com.google.android.gms.ads.internal.client.zzq zzqVar) {
        return zzfzt.zzn(zzfzt.zzh(null), new zzfza() { // from class: com.google.android.gms.internal.ads.zzdmt
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzd(zzqVar, zzfcrVar, zzfcvVar, str, str2, obj);
            }
        }, this.zzb);
    }

    final /* synthetic */ ListenableFuture zzc(JSONObject jSONObject, final zzcgb zzcgbVar) throws Exception {
        final zzcbk zzcbkVarZza = zzcbk.zza(zzcgbVar);
        if (this.zza.zzb != null) {
            zzcgbVar.zzag(zzchq.zzd());
        } else {
            zzcgbVar.zzag(zzchq.zze());
        }
        zzcgbVar.zzN().zzA(new zzchm() { // from class: com.google.android.gms.internal.ads.zzdmw
            @Override // com.google.android.gms.internal.ads.zzchm
            public final void zza(boolean z, int i, String str, String str2) {
                this.zza.zzf(zzcgbVar, zzcbkVarZza, z, i, str, str2);
            }
        });
        zzcgbVar.zzl("google.afma.nativeAds.renderVideo", jSONObject);
        return zzcbkVarZza;
    }

    final /* synthetic */ ListenableFuture zzd(com.google.android.gms.ads.internal.client.zzq zzqVar, zzfcr zzfcrVar, zzfcv zzfcvVar, String str, String str2, Object obj) throws Exception {
        final zzcgb zzcgbVarZza = this.zzc.zza(zzqVar, zzfcrVar, zzfcvVar);
        final zzcbk zzcbkVarZza = zzcbk.zza(zzcgbVarZza);
        if (this.zza.zzb != null) {
            zzh(zzcgbVarZza);
            zzcgbVarZza.zzag(zzchq.zzd());
        } else {
            zzdol zzdolVarZzb = this.zzd.zzb();
            zzcgbVarZza.zzN().zzM(zzdolVarZzb, zzdolVarZzb, zzdolVarZzb, zzdolVarZzb, zzdolVarZzb, false, null, new com.google.android.gms.ads.internal.zzb(this.zze, null, null), null, null, this.zzi, this.zzh, this.zzf, this.zzg, null, zzdolVarZzb, null, null, null);
            zzi(zzcgbVarZza);
        }
        zzcgbVarZza.zzN().zzA(new zzchm() { // from class: com.google.android.gms.internal.ads.zzdmx
            @Override // com.google.android.gms.internal.ads.zzchm
            public final void zza(boolean z, int i, String str3, String str4) {
                this.zza.zzg(zzcgbVarZza, zzcbkVarZza, z, i, str3, str4);
            }
        });
        zzcgbVarZza.zzab(str, str2, null);
        return zzcbkVarZza;
    }

    final /* synthetic */ ListenableFuture zze(Object obj) throws Exception {
        zzcgb zzcgbVarZza = this.zzc.zza(com.google.android.gms.ads.internal.client.zzq.zzc(), null, null);
        final zzcbk zzcbkVarZza = zzcbk.zza(zzcgbVarZza);
        zzh(zzcgbVarZza);
        zzcgbVarZza.zzN().zzG(new zzchn() { // from class: com.google.android.gms.internal.ads.zzdmy
            @Override // com.google.android.gms.internal.ads.zzchn
            public final void zza() {
                zzcbkVarZza.zzb();
            }
        });
        zzcgbVarZza.loadUrl((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdB));
        return zzcbkVarZza;
    }

    final /* synthetic */ void zzf(zzcgb zzcgbVar, zzcbk zzcbkVar, boolean z, int i, String str, String str2) {
        if (this.zza.zza != null && zzcgbVar.zzq() != null) {
            zzcgbVar.zzq().zzs(this.zza.zza);
        }
        zzcbkVar.zzb();
    }

    final /* synthetic */ void zzg(zzcgb zzcgbVar, zzcbk zzcbkVar, boolean z, int i, String str, String str2) {
        if (z) {
            if (this.zza.zza != null && zzcgbVar.zzq() != null) {
                zzcgbVar.zzq().zzs(this.zza.zza);
            }
            zzcbkVar.zzb();
            return;
        }
        zzcbkVar.zzd(new zzeir(1, "Html video Web View failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }
}
