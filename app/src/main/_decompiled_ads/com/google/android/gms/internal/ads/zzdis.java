package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdis extends zzbfk {
    private final zzdjj zza;
    private IObjectWrapper zzb;

    public zzdis(zzdjj zzdjjVar) {
        this.zza = zzdjjVar;
    }

    private static float zzb(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        if (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final float zze() throws RemoteException {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgi)).booleanValue()) {
            return 0.0f;
        }
        if (this.zza.zzb() != 0.0f) {
            return this.zza.zzb();
        }
        if (this.zza.zzj() != null) {
            try {
                return this.zza.zzj().zze();
            } catch (RemoteException e) {
                zzcat.zzh("Remote exception getting video controller aspect ratio.", e);
                return 0.0f;
            }
        }
        IObjectWrapper iObjectWrapper = this.zzb;
        if (iObjectWrapper != null) {
            return zzb(iObjectWrapper);
        }
        zzbfo zzbfoVarZzm = this.zza.zzm();
        if (zzbfoVarZzm == null) {
            return 0.0f;
        }
        float fZzd = (zzbfoVarZzm.zzd() == -1 || zzbfoVarZzm.zzc() == -1) ? 0.0f : zzbfoVarZzm.zzd() / zzbfoVarZzm.zzc();
        return fZzd == 0.0f ? zzb(zzbfoVarZzm.zzf()) : fZzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final float zzf() throws RemoteException {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgj)).booleanValue() && this.zza.zzj() != null) {
            return this.zza.zzj().zzf();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final float zzg() throws RemoteException {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgj)).booleanValue() && this.zza.zzj() != null) {
            return this.zza.zzj().zzg();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final com.google.android.gms.ads.internal.client.zzdq zzh() throws RemoteException {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgj)).booleanValue()) {
            return this.zza.zzj();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final IObjectWrapper zzi() throws RemoteException {
        IObjectWrapper iObjectWrapper = this.zzb;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzbfo zzbfoVarZzm = this.zza.zzm();
        if (zzbfoVarZzm == null) {
            return null;
        }
        return zzbfoVarZzm.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.zzb = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final boolean zzk() throws RemoteException {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgj)).booleanValue()) {
            return this.zza.zzaf();
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final boolean zzl() throws RemoteException {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgj)).booleanValue() && this.zza.zzj() != null;
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final void zzm(zzbgw zzbgwVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgj)).booleanValue() && (this.zza.zzj() instanceof zzcgx)) {
            ((zzcgx) this.zza.zzj()).zzv(zzbgwVar);
        }
    }
}
