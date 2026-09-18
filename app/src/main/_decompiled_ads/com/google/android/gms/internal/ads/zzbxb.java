package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbxb {
    public static final zzbwp zza(Context context, String str, zzbox zzboxVar) {
        try {
            IBinder iBinderZze = ((zzbwt) zzcax.zzb(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", new zzcav() { // from class: com.google.android.gms.internal.ads.zzbxa
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.internal.ads.zzcav
                public final Object zza(Object obj) {
                    if (obj == 0) {
                        return null;
                    }
                    IInterface iInterfaceQueryLocalInterface = obj.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
                    return iInterfaceQueryLocalInterface instanceof zzbwt ? (zzbwt) iInterfaceQueryLocalInterface : new zzbwt(obj);
                }
            })).zze(ObjectWrapper.wrap(context), str, zzboxVar, 233702000);
            if (iBinderZze == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZze.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            return iInterfaceQueryLocalInterface instanceof zzbwp ? (zzbwp) iInterfaceQueryLocalInterface : new zzbwn(iBinderZze);
        } catch (RemoteException | zzcaw e) {
            zzcat.zzl("#007 Could not call remote method.", e);
            return null;
        }
    }
}
