package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaun;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzbfs;
import com.google.android.gms.internal.ads.zzbfy;
import com.google.android.gms.internal.ads.zzbkg;
import com.google.android.gms.internal.ads.zzbkh;
import com.google.android.gms.internal.ads.zzbkk;
import com.google.android.gms.internal.ads.zzbow;
import com.google.android.gms.internal.ads.zzbox;
import com.google.android.gms.internal.ads.zzbso;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzbvz;
import com.google.android.gms.internal.ads.zzbwp;
import com.google.android.gms.internal.ads.zzbzk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzcd extends zzaun implements zzce {
    public zzcd() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzaun
    protected final boolean zzbJ(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzq zzqVar = (zzq) zzauo.zza(parcel, zzq.CREATOR);
                String string = parcel.readString();
                zzbox zzboxVarZzf = zzbow.zzf(parcel.readStrongBinder());
                int i3 = parcel.readInt();
                zzauo.zzc(parcel);
                zzbu zzbuVarZzd = zzd(iObjectWrapperAsInterface, zzqVar, string, zzboxVarZzf, i3);
                parcel2.writeNoException();
                zzauo.zzf(parcel2, zzbuVarZzd);
                return true;
            case 2:
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzq zzqVar2 = (zzq) zzauo.zza(parcel, zzq.CREATOR);
                String string2 = parcel.readString();
                zzbox zzboxVarZzf2 = zzbow.zzf(parcel.readStrongBinder());
                int i4 = parcel.readInt();
                zzauo.zzc(parcel);
                zzbu zzbuVarZze = zze(iObjectWrapperAsInterface2, zzqVar2, string2, zzboxVarZzf2, i4);
                parcel2.writeNoException();
                zzauo.zzf(parcel2, zzbuVarZze);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String string3 = parcel.readString();
                zzbox zzboxVarZzf3 = zzbow.zzf(parcel.readStrongBinder());
                int i5 = parcel.readInt();
                zzauo.zzc(parcel);
                zzbq zzbqVarZzb = zzb(iObjectWrapperAsInterface3, string3, zzboxVarZzf3, i5);
                parcel2.writeNoException();
                zzauo.zzf(parcel2, zzbqVarZzb);
                return true;
            case 4:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                parcel2.writeNoException();
                zzauo.zzf(parcel2, null);
                return true;
            case 5:
                IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                zzbfs zzbfsVarZzi = zzi(iObjectWrapperAsInterface4, iObjectWrapperAsInterface5);
                parcel2.writeNoException();
                zzauo.zzf(parcel2, zzbfsVarZzi);
                return true;
            case 6:
                IObjectWrapper iObjectWrapperAsInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbox zzboxVarZzf4 = zzbow.zzf(parcel.readStrongBinder());
                int i6 = parcel.readInt();
                zzauo.zzc(parcel);
                zzbvz zzbvzVarZzn = zzn(iObjectWrapperAsInterface6, zzboxVarZzf4, i6);
                parcel2.writeNoException();
                zzauo.zzf(parcel2, zzbvzVarZzn);
                return true;
            case 7:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                parcel2.writeNoException();
                zzauo.zzf(parcel2, null);
                return true;
            case 8:
                IObjectWrapper iObjectWrapperAsInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                zzbsv zzbsvVarZzm = zzm(iObjectWrapperAsInterface7);
                parcel2.writeNoException();
                zzauo.zzf(parcel2, zzbsvVarZzm);
                return true;
            case 9:
                IObjectWrapper iObjectWrapperAsInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                int i7 = parcel.readInt();
                zzauo.zzc(parcel);
                zzco zzcoVarZzg = zzg(iObjectWrapperAsInterface8, i7);
                parcel2.writeNoException();
                zzauo.zzf(parcel2, zzcoVarZzg);
                return true;
            case 10:
                IObjectWrapper iObjectWrapperAsInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzq zzqVar3 = (zzq) zzauo.zza(parcel, zzq.CREATOR);
                String string4 = parcel.readString();
                int i8 = parcel.readInt();
                zzauo.zzc(parcel);
                zzbu zzbuVarZzf = zzf(iObjectWrapperAsInterface9, zzqVar3, string4, i8);
                parcel2.writeNoException();
                zzauo.zzf(parcel2, zzbuVarZzf);
                return true;
            case 11:
                IObjectWrapper iObjectWrapperAsInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                zzbfy zzbfyVarZzj = zzj(iObjectWrapperAsInterface10, iObjectWrapperAsInterface11, iObjectWrapperAsInterface12);
                parcel2.writeNoException();
                zzauo.zzf(parcel2, zzbfyVarZzj);
                return true;
            case 12:
                IObjectWrapper iObjectWrapperAsInterface13 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String string5 = parcel.readString();
                zzbox zzboxVarZzf5 = zzbow.zzf(parcel.readStrongBinder());
                int i9 = parcel.readInt();
                zzauo.zzc(parcel);
                zzbwp zzbwpVarZzo = zzo(iObjectWrapperAsInterface13, string5, zzboxVarZzf5, i9);
                parcel2.writeNoException();
                zzauo.zzf(parcel2, zzbwpVarZzo);
                return true;
            case 13:
                IObjectWrapper iObjectWrapperAsInterface14 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzq zzqVar4 = (zzq) zzauo.zza(parcel, zzq.CREATOR);
                String string6 = parcel.readString();
                zzbox zzboxVarZzf6 = zzbow.zzf(parcel.readStrongBinder());
                int i10 = parcel.readInt();
                zzauo.zzc(parcel);
                zzbu zzbuVarZzc = zzc(iObjectWrapperAsInterface14, zzqVar4, string6, zzboxVarZzf6, i10);
                parcel2.writeNoException();
                zzauo.zzf(parcel2, zzbuVarZzc);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperAsInterface15 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbox zzboxVarZzf7 = zzbow.zzf(parcel.readStrongBinder());
                int i11 = parcel.readInt();
                zzauo.zzc(parcel);
                zzbzk zzbzkVarZzp = zzp(iObjectWrapperAsInterface15, zzboxVarZzf7, i11);
                parcel2.writeNoException();
                zzauo.zzf(parcel2, zzbzkVarZzp);
                return true;
            case 15:
                IObjectWrapper iObjectWrapperAsInterface16 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbox zzboxVarZzf8 = zzbow.zzf(parcel.readStrongBinder());
                int i12 = parcel.readInt();
                zzauo.zzc(parcel);
                zzbso zzbsoVarZzl = zzl(iObjectWrapperAsInterface16, zzboxVarZzf8, i12);
                parcel2.writeNoException();
                zzauo.zzf(parcel2, zzbsoVarZzl);
                return true;
            case 16:
                IObjectWrapper iObjectWrapperAsInterface17 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbox zzboxVarZzf9 = zzbow.zzf(parcel.readStrongBinder());
                int i13 = parcel.readInt();
                zzbkh zzbkhVarZzc = zzbkg.zzc(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                zzbkk zzbkkVarZzk = zzk(iObjectWrapperAsInterface17, zzboxVarZzf9, i13, zzbkhVarZzc);
                parcel2.writeNoException();
                zzauo.zzf(parcel2, zzbkkVarZzk);
                return true;
            case 17:
                IObjectWrapper iObjectWrapperAsInterface18 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbox zzboxVarZzf10 = zzbow.zzf(parcel.readStrongBinder());
                int i14 = parcel.readInt();
                zzauo.zzc(parcel);
                zzdj zzdjVarZzh = zzh(iObjectWrapperAsInterface18, zzboxVarZzf10, i14);
                parcel2.writeNoException();
                zzauo.zzf(parcel2, zzdjVarZzh);
                return true;
            default:
                return false;
        }
    }
}
