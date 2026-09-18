package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzffh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzffh> CREATOR = new zzffi();

    @Nullable
    public final Context zza;
    public final zzffe zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final String zzf;
    public final int zzg;
    private final zzffe[] zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int[] zzl;
    private final int[] zzm;

    public zzffh(int i, int i2, int i3, int i4, String str, int i5, int i6) {
        zzffe[] zzffeVarArrValues = zzffe.values();
        this.zzh = zzffeVarArrValues;
        int[] iArrZza = zzfff.zza();
        this.zzl = iArrZza;
        int[] iArrZza2 = zzffg.zza();
        this.zzm = iArrZza2;
        this.zza = null;
        this.zzi = i;
        this.zzb = zzffeVarArrValues[i];
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = str;
        this.zzj = i5;
        this.zzg = iArrZza[i5];
        this.zzk = i6;
        int i7 = iArrZza2[i6];
    }

    @Nullable
    public static zzffh zza(zzffe zzffeVar, Context context) {
        if (zzffeVar == zzffe.Rewarded) {
            return new zzffh(context, zzffeVar, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgp)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgv)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgx)).intValue(), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgz), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgr), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgt));
        }
        if (zzffeVar == zzffe.Interstitial) {
            return new zzffh(context, zzffeVar, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgq)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgw)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgy)).intValue(), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgA), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgs), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgu));
        }
        if (zzffeVar != zzffe.AppOpen) {
            return null;
        }
        return new zzffh(context, zzffeVar, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgD)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgF)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgG)).intValue(), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgB), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgC), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgE));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zzi;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeInt(parcel, 2, this.zzc);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 4, this.zze);
        SafeParcelWriter.writeString(parcel, 5, this.zzf, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzj);
        SafeParcelWriter.writeInt(parcel, 7, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    private zzffh(@Nullable Context context, zzffe zzffeVar, int i, int i2, int i3, String str, String str2, String str3) {
        this.zzh = zzffe.values();
        this.zzl = zzfff.zza();
        this.zzm = zzffg.zza();
        this.zza = context;
        this.zzi = zzffeVar.ordinal();
        this.zzb = zzffeVar;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = str;
        int i4 = 2;
        if ("oldest".equals(str2)) {
            i4 = 1;
        } else if (!"lru".equals(str2) && "lfu".equals(str2)) {
            i4 = 3;
        }
        this.zzg = i4;
        this.zzj = i4 - 1;
        "onAdClosed".equals(str3);
        this.zzk = 0;
    }
}
