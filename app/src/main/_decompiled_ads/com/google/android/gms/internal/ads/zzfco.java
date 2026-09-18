package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfco extends zzbvy {
    private final zzfce zza;
    private final zzfbu zzb;
    private final zzfdf zzc;
    private zzdox zzd;
    private boolean zze = false;

    public zzfco(zzfce zzfceVar, zzfbu zzfbuVar, zzfdf zzfdfVar) {
        this.zza = zzfceVar;
        this.zzb = zzfbuVar;
        this.zzc = zzfdfVar;
    }

    private final synchronized boolean zzy() {
        zzdox zzdoxVar;
        zzdoxVar = this.zzd;
        return (zzdoxVar == null || zzdoxVar.zze()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final Bundle zzb() {
        Preconditions.checkMainThread("getAdMetadata can only be called from the UI thread.");
        zzdox zzdoxVar = this.zzd;
        return zzdoxVar != null ? zzdoxVar.zza() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final synchronized com.google.android.gms.ads.internal.client.zzdn zzc() throws RemoteException {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgJ)).booleanValue()) {
            return null;
        }
        zzdox zzdoxVar = this.zzd;
        if (zzdoxVar == null) {
            return null;
        }
        return zzdoxVar.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final synchronized String zzd() throws RemoteException {
        zzdox zzdoxVar = this.zzd;
        if (zzdoxVar == null || zzdoxVar.zzl() == null) {
            return null;
        }
        return zzdoxVar.zzl().zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final void zze() throws RemoteException {
        zzf(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final synchronized void zzf(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        Context context = null;
        this.zzb.zzg(null);
        if (this.zzd != null) {
            if (iObjectWrapper != null) {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzd.zzm().zza(context);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031 A[Catch: all -> 0x0063, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0019, B:12:0x0022, B:13:0x002b, B:15:0x0031, B:19:0x0045), top: B:25:0x0001, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0043 A[DONT_GENERATE] */
    /* JADX WARN: Instruction removed from duplicated block: B:17:0x0043, please report this as an issue */
    @Override // com.google.android.gms.internal.ads.zzbvz
    public final synchronized void zzg(zzbwd zzbwdVar) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        String str = zzbwdVar.zzb;
        String str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzfm);
        if (str2 == null || str == null) {
            if (zzy()) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzfo)).booleanValue()) {
                    return;
                }
            }
            zzfbw zzfbwVar = new zzfbw(null);
            this.zzd = null;
            this.zza.zzj(1);
            this.zza.zzb(zzbwdVar.zza, zzbwdVar.zzb, zzfbwVar, new zzfcm(this));
            return;
        }
        try {
            if (Pattern.matches(str2, str)) {
                return;
            }
        } catch (RuntimeException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "NonagonUtil.isPatternMatched");
        }
        if (zzy()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzfo)).booleanValue()) {
                return;
            }
        }
        zzfbw zzfbwVar2 = new zzfbw(null);
        this.zzd = null;
        this.zza.zzj(1);
        this.zza.zzb(zzbwdVar.zza, zzbwdVar.zzb, zzfbwVar2, new zzfcm(this));
        return;
        throw th;
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final void zzh() {
        zzi(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final synchronized void zzi(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzd != null) {
            this.zzd.zzm().zzb(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final void zzj() {
        zzk(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final synchronized void zzk(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzd != null) {
            this.zzd.zzm().zzc(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final void zzl(com.google.android.gms.ads.internal.client.zzby zzbyVar) {
        Preconditions.checkMainThread("setAdMetadataListener can only be called from the UI thread.");
        if (zzbyVar == null) {
            this.zzb.zzg(null);
        } else {
            this.zzb.zzg(new zzfcn(this, zzbyVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final synchronized void zzm(String str) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setCustomData");
        this.zzc.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final synchronized void zzn(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zze = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final void zzo(zzbwc zzbwcVar) throws RemoteException {
        Preconditions.checkMainThread("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzb.zzm(zzbwcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final synchronized void zzp(String str) throws RemoteException {
        Preconditions.checkMainThread("setUserId must be called on the main UI thread.");
        this.zzc.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final synchronized void zzq() throws RemoteException {
        zzr(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final synchronized void zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Preconditions.checkMainThread("showAd must be called on the main UI thread.");
        if (this.zzd != null) {
            Activity activity = null;
            if (iObjectWrapper != null) {
                Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
                if (objUnwrap instanceof Activity) {
                    activity = (Activity) objUnwrap;
                }
            }
            this.zzd.zzh(this.zze, activity);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final boolean zzs() throws RemoteException {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final boolean zzt() {
        zzdox zzdoxVar = this.zzd;
        return zzdoxVar != null && zzdoxVar.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final void zzu(zzbvx zzbvxVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzb.zzn(zzbvxVar);
    }
}
