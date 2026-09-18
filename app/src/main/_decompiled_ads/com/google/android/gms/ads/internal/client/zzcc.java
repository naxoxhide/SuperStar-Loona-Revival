package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaum;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzbfr;
import com.google.android.gms.internal.ads.zzbfs;
import com.google.android.gms.internal.ads.zzbfx;
import com.google.android.gms.internal.ads.zzbfy;
import com.google.android.gms.internal.ads.zzbkh;
import com.google.android.gms.internal.ads.zzbkj;
import com.google.android.gms.internal.ads.zzbkk;
import com.google.android.gms.internal.ads.zzbox;
import com.google.android.gms.internal.ads.zzbsn;
import com.google.android.gms.internal.ads.zzbso;
import com.google.android.gms.internal.ads.zzbsu;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzbvz;
import com.google.android.gms.internal.ads.zzbwo;
import com.google.android.gms.internal.ads.zzbwp;
import com.google.android.gms.internal.ads.zzbzj;
import com.google.android.gms.internal.ads.zzbzk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcc extends zzaum implements zzce {
    zzcc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbq zzb(IObjectWrapper iObjectWrapper, String str, zzbox zzboxVar, int i) throws RemoteException {
        zzbq zzboVar;
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        zzauo.zzf(parcelZza, zzboxVar);
        parcelZza.writeInt(233702000);
        Parcel parcelZzbg = zzbg(3, parcelZza);
        IBinder strongBinder = parcelZzbg.readStrongBinder();
        if (strongBinder == null) {
            zzboVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            zzboVar = iInterfaceQueryLocalInterface instanceof zzbq ? (zzbq) iInterfaceQueryLocalInterface : new zzbo(strongBinder);
        }
        parcelZzbg.recycle();
        return zzboVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zzc(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, zzbox zzboxVar, int i) throws RemoteException {
        zzbu zzbsVar;
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzd(parcelZza, zzqVar);
        parcelZza.writeString(str);
        zzauo.zzf(parcelZza, zzboxVar);
        parcelZza.writeInt(233702000);
        Parcel parcelZzbg = zzbg(13, parcelZza);
        IBinder strongBinder = parcelZzbg.readStrongBinder();
        if (strongBinder == null) {
            zzbsVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbsVar = iInterfaceQueryLocalInterface instanceof zzbu ? (zzbu) iInterfaceQueryLocalInterface : new zzbs(strongBinder);
        }
        parcelZzbg.recycle();
        return zzbsVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zzd(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, zzbox zzboxVar, int i) throws RemoteException {
        zzbu zzbsVar;
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzd(parcelZza, zzqVar);
        parcelZza.writeString(str);
        zzauo.zzf(parcelZza, zzboxVar);
        parcelZza.writeInt(233702000);
        Parcel parcelZzbg = zzbg(1, parcelZza);
        IBinder strongBinder = parcelZzbg.readStrongBinder();
        if (strongBinder == null) {
            zzbsVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbsVar = iInterfaceQueryLocalInterface instanceof zzbu ? (zzbu) iInterfaceQueryLocalInterface : new zzbs(strongBinder);
        }
        parcelZzbg.recycle();
        return zzbsVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zze(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, zzbox zzboxVar, int i) throws RemoteException {
        zzbu zzbsVar;
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzd(parcelZza, zzqVar);
        parcelZza.writeString(str);
        zzauo.zzf(parcelZza, zzboxVar);
        parcelZza.writeInt(233702000);
        Parcel parcelZzbg = zzbg(2, parcelZza);
        IBinder strongBinder = parcelZzbg.readStrongBinder();
        if (strongBinder == null) {
            zzbsVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbsVar = iInterfaceQueryLocalInterface instanceof zzbu ? (zzbu) iInterfaceQueryLocalInterface : new zzbs(strongBinder);
        }
        parcelZzbg.recycle();
        return zzbsVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zzf(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, int i) throws RemoteException {
        zzbu zzbsVar;
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzd(parcelZza, zzqVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(233702000);
        Parcel parcelZzbg = zzbg(10, parcelZza);
        IBinder strongBinder = parcelZzbg.readStrongBinder();
        if (strongBinder == null) {
            zzbsVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbsVar = iInterfaceQueryLocalInterface instanceof zzbu ? (zzbu) iInterfaceQueryLocalInterface : new zzbs(strongBinder);
        }
        parcelZzbg.recycle();
        return zzbsVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzco zzg(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzco zzcmVar;
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        parcelZza.writeInt(233702000);
        Parcel parcelZzbg = zzbg(9, parcelZza);
        IBinder strongBinder = parcelZzbg.readStrongBinder();
        if (strongBinder == null) {
            zzcmVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            zzcmVar = iInterfaceQueryLocalInterface instanceof zzco ? (zzco) iInterfaceQueryLocalInterface : new zzcm(strongBinder);
        }
        parcelZzbg.recycle();
        return zzcmVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzdj zzh(IObjectWrapper iObjectWrapper, zzbox zzboxVar, int i) throws RemoteException {
        zzdj zzdhVar;
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzf(parcelZza, zzboxVar);
        parcelZza.writeInt(233702000);
        Parcel parcelZzbg = zzbg(17, parcelZza);
        IBinder strongBinder = parcelZzbg.readStrongBinder();
        if (strongBinder == null) {
            zzdhVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOutOfContextTester");
            zzdhVar = iInterfaceQueryLocalInterface instanceof zzdj ? (zzdj) iInterfaceQueryLocalInterface : new zzdh(strongBinder);
        }
        parcelZzbg.recycle();
        return zzdhVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbfs zzi(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzf(parcelZza, iObjectWrapper2);
        Parcel parcelZzbg = zzbg(5, parcelZza);
        zzbfs zzbfsVarZzbE = zzbfr.zzbE(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return zzbfsVarZzbE;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbfy zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzf(parcelZza, iObjectWrapper2);
        zzauo.zzf(parcelZza, iObjectWrapper3);
        Parcel parcelZzbg = zzbg(11, parcelZza);
        zzbfy zzbfyVarZze = zzbfx.zze(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return zzbfyVarZze;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbkk zzk(IObjectWrapper iObjectWrapper, zzbox zzboxVar, int i, zzbkh zzbkhVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzf(parcelZza, zzboxVar);
        parcelZza.writeInt(233702000);
        zzauo.zzf(parcelZza, zzbkhVar);
        Parcel parcelZzbg = zzbg(16, parcelZza);
        zzbkk zzbkkVarZzb = zzbkj.zzb(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return zzbkkVarZzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbso zzl(IObjectWrapper iObjectWrapper, zzbox zzboxVar, int i) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzf(parcelZza, zzboxVar);
        parcelZza.writeInt(233702000);
        Parcel parcelZzbg = zzbg(15, parcelZza);
        zzbso zzbsoVarZzb = zzbsn.zzb(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return zzbsoVarZzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbsv zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzbg = zzbg(8, parcelZza);
        zzbsv zzbsvVarZzI = zzbsu.zzI(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return zzbsvVarZzI;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbvz zzn(IObjectWrapper iObjectWrapper, zzbox zzboxVar, int i) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbwp zzo(IObjectWrapper iObjectWrapper, String str, zzbox zzboxVar, int i) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        zzauo.zzf(parcelZza, zzboxVar);
        parcelZza.writeInt(233702000);
        Parcel parcelZzbg = zzbg(12, parcelZza);
        zzbwp zzbwpVarZzq = zzbwo.zzq(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return zzbwpVarZzq;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbzk zzp(IObjectWrapper iObjectWrapper, zzbox zzboxVar, int i) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzf(parcelZza, zzboxVar);
        parcelZza.writeInt(233702000);
        Parcel parcelZzbg = zzbg(14, parcelZza);
        zzbzk zzbzkVarZzb = zzbzj.zzb(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return zzbzkVarZzb;
    }
}
