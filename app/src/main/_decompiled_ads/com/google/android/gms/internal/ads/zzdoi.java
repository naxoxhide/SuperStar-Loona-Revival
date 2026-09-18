package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdoi {
    private final com.google.android.gms.ads.internal.zza zzb;
    private final zzcgn zzc;
    private final Context zzd;
    private final zzdso zze;
    private final zzfib zzf;
    private final Executor zzg;
    private final zzaro zzh;
    private final zzcaz zzi;
    private final zzedo zzk;
    private final zzfjx zzl;
    private final zzedz zzm;
    private ListenableFuture zzn;
    private final zzdnv zza = new zzdnv();
    private final zzbjy zzj = new zzbjy();

    zzdoi(zzdof zzdofVar) {
        this.zzd = zzdofVar.zzc;
        this.zzg = zzdofVar.zzg;
        this.zzh = zzdofVar.zzh;
        this.zzi = zzdofVar.zzi;
        this.zzb = zzdofVar.zza;
        this.zzc = zzdofVar.zzb;
        this.zzk = zzdofVar.zzf;
        this.zzl = zzdofVar.zzj;
        this.zze = zzdofVar.zzd;
        this.zzf = zzdofVar.zze;
        this.zzm = zzdofVar.zzk;
    }

    final /* synthetic */ zzcgb zza(zzcgb zzcgbVar) {
        zzcgbVar.zzad("/result", this.zzj);
        zzcho zzchoVarZzN = zzcgbVar.zzN();
        com.google.android.gms.ads.internal.zzb zzbVar = new com.google.android.gms.ads.internal.zzb(this.zzd, null, null);
        zzedo zzedoVar = this.zzk;
        zzfjx zzfjxVar = this.zzl;
        zzdso zzdsoVar = this.zze;
        zzfib zzfibVar = this.zzf;
        zzdnv zzdnvVar = this.zza;
        zzchoVarZzN.zzM(null, zzdnvVar, zzdnvVar, zzdnvVar, zzdnvVar, false, null, zzbVar, null, null, zzedoVar, zzfjxVar, zzdsoVar, zzfibVar, null, null, null, null, null);
        return zzcgbVar;
    }

    final /* synthetic */ ListenableFuture zzc(String str, JSONObject jSONObject, zzcgb zzcgbVar) throws Exception {
        return this.zzj.zzb(zzcgbVar, str, jSONObject);
    }

    public final synchronized ListenableFuture zzd(final String str, final JSONObject jSONObject) {
        ListenableFuture listenableFuture = this.zzn;
        if (listenableFuture == null) {
            return zzfzt.zzh(null);
        }
        return zzfzt.zzn(listenableFuture, new zzfza() { // from class: com.google.android.gms.internal.ads.zzdnw
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzc(str, jSONObject, (zzcgb) obj);
            }
        }, this.zzg);
    }

    public final synchronized void zze(zzfcr zzfcrVar, zzfcv zzfcvVar) {
        ListenableFuture listenableFuture = this.zzn;
        if (listenableFuture == null) {
            return;
        }
        zzfzt.zzr(listenableFuture, new zzdoc(this, zzfcrVar, zzfcvVar), this.zzg);
    }

    public final synchronized void zzf() {
        ListenableFuture listenableFuture = this.zzn;
        if (listenableFuture == null) {
            return;
        }
        zzfzt.zzr(listenableFuture, new zzdny(this), this.zzg);
        this.zzn = null;
    }

    public final synchronized void zzg(String str, Map map) {
        ListenableFuture listenableFuture = this.zzn;
        if (listenableFuture == null) {
            return;
        }
        zzfzt.zzr(listenableFuture, new zzdob(this, "sendMessageToNativeJs", map), this.zzg);
    }

    public final synchronized void zzh() {
        final String str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdA);
        final Context context = this.zzd;
        final zzaro zzaroVar = this.zzh;
        final zzcaz zzcazVar = this.zzi;
        final com.google.android.gms.ads.internal.zza zzaVar = this.zzb;
        final zzedz zzedzVar = this.zzm;
        ListenableFuture listenableFutureZzm = zzfzt.zzm(zzfzt.zzk(new zzfyz() { // from class: com.google.android.gms.internal.ads.zzcgl
            @Override // com.google.android.gms.internal.ads.zzfyz
            public final ListenableFuture zza() throws zzcgm {
                com.google.android.gms.ads.internal.zzt.zzz();
                Context context2 = context;
                zzchq zzchqVarZza = zzchq.zza();
                zzaro zzaroVar2 = zzaroVar;
                com.google.android.gms.ads.internal.zza zzaVar2 = zzaVar;
                zzcgb zzcgbVarZza = zzcgn.zza(context2, zzchqVarZza, "", false, false, zzaroVar2, null, zzcazVar, null, null, zzaVar2, zzaxv.zza(), null, null, zzedzVar);
                final zzcbk zzcbkVarZza = zzcbk.zza(zzcgbVarZza);
                zzcgbVarZza.zzN().zzA(new zzchm() { // from class: com.google.android.gms.internal.ads.zzcgj
                    @Override // com.google.android.gms.internal.ads.zzchm
                    public final void zza(boolean z, int i, String str2, String str3) {
                        zzcbkVarZza.zzb();
                    }
                });
                zzcgbVarZza.loadUrl(str);
                return zzcbkVarZza;
            }
        }, zzcbg.zze), new zzfsk() { // from class: com.google.android.gms.internal.ads.zzdnx
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                zzcgb zzcgbVar = (zzcgb) obj;
                this.zza.zza(zzcgbVar);
                return zzcgbVar;
            }
        }, this.zzg);
        this.zzn = listenableFutureZzm;
        zzcbj.zza(listenableFutureZzm, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzi(String str, zzbjj zzbjjVar) {
        ListenableFuture listenableFuture = this.zzn;
        if (listenableFuture == null) {
            return;
        }
        zzfzt.zzr(listenableFuture, new zzdnz(this, str, zzbjjVar), this.zzg);
    }

    public final void zzj(WeakReference weakReference, String str, zzbjj zzbjjVar) {
        zzi(str, new zzdoh(this, weakReference, str, zzbjjVar, null));
    }

    public final synchronized void zzk(String str, zzbjj zzbjjVar) {
        ListenableFuture listenableFuture = this.zzn;
        if (listenableFuture == null) {
            return;
        }
        zzfzt.zzr(listenableFuture, new zzdoa(this, str, zzbjjVar), this.zzg);
    }
}
