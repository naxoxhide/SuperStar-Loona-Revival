package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbsc extends NativeAd.Image {
    private final zzbfo zza;
    private final Drawable zzb;
    private final Uri zzc;
    private final double zzd;

    public zzbsc(zzbfo zzbfoVar) {
        Drawable drawable;
        double dZzb;
        this.zza = zzbfoVar;
        Uri uriZze = null;
        try {
            IObjectWrapper iObjectWrapperZzf = zzbfoVar.zzf();
            drawable = iObjectWrapperZzf != null ? (Drawable) ObjectWrapper.unwrap(iObjectWrapperZzf) : null;
        } catch (RemoteException e) {
            zzcat.zzh("", e);
        }
        this.zzb = drawable;
        try {
            uriZze = this.zza.zze();
        } catch (RemoteException e2) {
            zzcat.zzh("", e2);
        }
        this.zzc = uriZze;
        try {
            dZzb = this.zza.zzb();
        } catch (RemoteException e3) {
            zzcat.zzh("", e3);
            dZzb = 1.0d;
        }
        this.zzd = dZzb;
        try {
            this.zza.zzd();
        } catch (RemoteException e4) {
            zzcat.zzh("", e4);
        }
        try {
            this.zza.zzc();
        } catch (RemoteException e5) {
            zzcat.zzh("", e5);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final Drawable getDrawable() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final double getScale() {
        return this.zzd;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final Uri getUri() {
        return this.zzc;
    }
}
