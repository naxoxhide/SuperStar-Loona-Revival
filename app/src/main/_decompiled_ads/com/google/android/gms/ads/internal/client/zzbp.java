package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzaun;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzbfc;
import com.google.android.gms.internal.ads.zzbgl;
import com.google.android.gms.internal.ads.zzbgm;
import com.google.android.gms.internal.ads.zzbgo;
import com.google.android.gms.internal.ads.zzbgp;
import com.google.android.gms.internal.ads.zzbgr;
import com.google.android.gms.internal.ads.zzbgs;
import com.google.android.gms.internal.ads.zzbgu;
import com.google.android.gms.internal.ads.zzbgv;
import com.google.android.gms.internal.ads.zzbgy;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbhb;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbls;
import com.google.android.gms.internal.ads.zzbma;
import com.google.android.gms.internal.ads.zzbmb;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzbp extends zzaun implements zzbq {
    public zzbp() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzaun
    protected final boolean zzbJ(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbh zzbfVar = null;
        zzcf zzcfVar = null;
        switch (i) {
            case 1:
                zzbn zzbnVarZze = zze();
                parcel2.writeNoException();
                zzauo.zzf(parcel2, zzbnVarZze);
                return true;
            case 2:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzbfVar = iInterfaceQueryLocalInterface instanceof zzbh ? (zzbh) iInterfaceQueryLocalInterface : new zzbf(strongBinder);
                }
                zzauo.zzc(parcel);
                zzl(zzbfVar);
                parcel2.writeNoException();
                return true;
            case 3:
                zzbgm zzbgmVarZzb = zzbgl.zzb(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                zzf(zzbgmVarZzb);
                parcel2.writeNoException();
                return true;
            case 4:
                zzbgp zzbgpVarZzb = zzbgo.zzb(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                zzg(zzbgpVarZzb);
                parcel2.writeNoException();
                return true;
            case 5:
                String string = parcel.readString();
                zzbgv zzbgvVarZzb = zzbgu.zzb(parcel.readStrongBinder());
                zzbgs zzbgsVarZzb = zzbgr.zzb(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                zzh(string, zzbgvVarZzb, zzbgsVarZzb);
                parcel2.writeNoException();
                return true;
            case 6:
                zzbfc zzbfcVar = (zzbfc) zzauo.zza(parcel, zzbfc.CREATOR);
                zzauo.zzc(parcel);
                zzo(zzbfcVar);
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzcfVar = iInterfaceQueryLocalInterface2 instanceof zzcf ? (zzcf) iInterfaceQueryLocalInterface2 : new zzcf(strongBinder2);
                }
                zzauo.zzc(parcel);
                zzq(zzcfVar);
                parcel2.writeNoException();
                return true;
            case 8:
                zzbgz zzbgzVarZzb = zzbgy.zzb(parcel.readStrongBinder());
                zzq zzqVar = (zzq) zzauo.zza(parcel, zzq.CREATOR);
                zzauo.zzc(parcel);
                zzj(zzbgzVarZzb, zzqVar);
                parcel2.writeNoException();
                return true;
            case 9:
                PublisherAdViewOptions publisherAdViewOptions = (PublisherAdViewOptions) zzauo.zza(parcel, PublisherAdViewOptions.CREATOR);
                zzauo.zzc(parcel);
                zzp(publisherAdViewOptions);
                parcel2.writeNoException();
                return true;
            case 10:
                zzbhc zzbhcVarZzb = zzbhb.zzb(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                zzk(zzbhcVarZzb);
                parcel2.writeNoException();
                return true;
            case 11:
            case 12:
            default:
                return false;
            case 13:
                zzbls zzblsVar = (zzbls) zzauo.zza(parcel, zzbls.CREATOR);
                zzauo.zzc(parcel);
                zzn(zzblsVar);
                parcel2.writeNoException();
                return true;
            case 14:
                zzbmb zzbmbVarZzb = zzbma.zzb(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                zzi(zzbmbVarZzb);
                parcel2.writeNoException();
                return true;
            case 15:
                AdManagerAdViewOptions adManagerAdViewOptions = (AdManagerAdViewOptions) zzauo.zza(parcel, AdManagerAdViewOptions.CREATOR);
                zzauo.zzc(parcel);
                zzm(adManagerAdViewOptions);
                parcel2.writeNoException();
                return true;
        }
    }
}
