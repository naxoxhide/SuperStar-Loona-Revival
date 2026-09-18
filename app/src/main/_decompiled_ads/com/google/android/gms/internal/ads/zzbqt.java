package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbqt extends zzaum implements zzbqv {
    zzbqt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final com.google.android.gms.ads.internal.client.zzdq zze() throws RemoteException {
        Parcel parcelZzbg = zzbg(5, zza());
        com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = com.google.android.gms.ads.internal.client.zzdp.zzb(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return zzdqVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final zzbrj zzf() throws RemoteException {
        Parcel parcelZzbg = zzbg(2, zza());
        zzbrj zzbrjVar = (zzbrj) zzauo.zza(parcelZzbg, zzbrj.CREATOR);
        parcelZzbg.recycle();
        return zzbrjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final zzbrj zzg() throws RemoteException {
        Parcel parcelZzbg = zzbg(3, zza());
        zzbrj zzbrjVar = (zzbrj) zzauo.zza(parcelZzbg, zzbrj.CREATOR);
        parcelZzbg.recycle();
        return zzbrjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, com.google.android.gms.ads.internal.client.zzq zzqVar, zzbqy zzbqyVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        zzauo.zzd(parcelZza, bundle);
        zzauo.zzd(parcelZza, bundle2);
        zzauo.zzd(parcelZza, zzqVar);
        zzauo.zzf(parcelZza, zzbqyVar);
        zzbh(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final void zzi(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqg zzbqgVar, zzbpd zzbpdVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzauo.zzd(parcelZza, zzlVar);
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzf(parcelZza, zzbqgVar);
        zzauo.zzf(parcelZza, zzbpdVar);
        zzbh(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final void zzj(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqj zzbqjVar, zzbpd zzbpdVar, com.google.android.gms.ads.internal.client.zzq zzqVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzauo.zzd(parcelZza, zzlVar);
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzf(parcelZza, zzbqjVar);
        zzauo.zzf(parcelZza, zzbpdVar);
        zzauo.zzd(parcelZza, zzqVar);
        zzbh(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final void zzk(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqj zzbqjVar, zzbpd zzbpdVar, com.google.android.gms.ads.internal.client.zzq zzqVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzauo.zzd(parcelZza, zzlVar);
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzf(parcelZza, zzbqjVar);
        zzauo.zzf(parcelZza, zzbpdVar);
        zzauo.zzd(parcelZza, zzqVar);
        zzbh(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final void zzl(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqm zzbqmVar, zzbpd zzbpdVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzauo.zzd(parcelZza, zzlVar);
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzf(parcelZza, zzbqmVar);
        zzauo.zzf(parcelZza, zzbpdVar);
        zzbh(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final void zzm(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqp zzbqpVar, zzbpd zzbpdVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzauo.zzd(parcelZza, zzlVar);
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzf(parcelZza, zzbqpVar);
        zzauo.zzf(parcelZza, zzbpdVar);
        zzbh(18, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final void zzn(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqp zzbqpVar, zzbpd zzbpdVar, zzbfc zzbfcVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzauo.zzd(parcelZza, zzlVar);
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzf(parcelZza, zzbqpVar);
        zzauo.zzf(parcelZza, zzbpdVar);
        zzauo.zzd(parcelZza, zzbfcVar);
        zzbh(22, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final void zzo(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqs zzbqsVar, zzbpd zzbpdVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzauo.zzd(parcelZza, zzlVar);
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzf(parcelZza, zzbqsVar);
        zzauo.zzf(parcelZza, zzbpdVar);
        zzbh(20, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final void zzp(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqs zzbqsVar, zzbpd zzbpdVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzauo.zzd(parcelZza, zzlVar);
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzf(parcelZza, zzbqsVar);
        zzauo.zzf(parcelZza, zzbpdVar);
        zzbh(16, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final void zzq(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzbh(19, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzbg = zzbg(24, parcelZza);
        boolean zZzg = zzauo.zzg(parcelZzbg);
        parcelZzbg.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzbg = zzbg(15, parcelZza);
        boolean zZzg = zzauo.zzg(parcelZzbg);
        parcelZzbg.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzbg = zzbg(17, parcelZza);
        boolean zZzg = zzauo.zzg(parcelZzbg);
        parcelZzbg.recycle();
        return zZzg;
    }
}
