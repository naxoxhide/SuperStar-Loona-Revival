package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbq;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzcd;
import com.google.android.gms.ads.internal.client.zzco;
import com.google.android.gms.ads.internal.client.zzdj;
import com.google.android.gms.ads.internal.client.zzew;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzae;
import com.google.android.gms.ads.internal.overlay.zzaf;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzbfs;
import com.google.android.gms.internal.ads.zzbfy;
import com.google.android.gms.internal.ads.zzbkh;
import com.google.android.gms.internal.ads.zzbkk;
import com.google.android.gms.internal.ads.zzbox;
import com.google.android.gms.internal.ads.zzbso;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzbvz;
import com.google.android.gms.internal.ads.zzbwp;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzcaz;
import com.google.android.gms.internal.ads.zzchw;
import com.google.android.gms.internal.ads.zzdkd;
import com.google.android.gms.internal.ads.zzdkf;
import com.google.android.gms.internal.ads.zzdtx;
import com.google.android.gms.internal.ads.zzeln;
import com.google.android.gms.internal.ads.zzexr;
import com.google.android.gms.internal.ads.zzezf;
import com.google.android.gms.internal.ads.zzfaw;
import com.google.android.gms.internal.ads.zzfck;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes2.dex */
public class ClientApi extends zzcd {
    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbq zzb(IObjectWrapper iObjectWrapper, String str, zzbox zzboxVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzeln(zzchw.zzb(context, zzboxVar, i), context, str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zzc(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, String str, zzbox zzboxVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzexr zzexrVarZzs = zzchw.zzb(context, zzboxVar, i).zzs();
        zzexrVarZzs.zza(str);
        zzexrVarZzs.zzb(context);
        return i >= ((Integer) zzba.zzc().zzb(zzbci.zzfe)).intValue() ? zzexrVarZzs.zzc().zza() : new zzew();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zzd(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, String str, zzbox zzboxVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzezf zzezfVarZzt = zzchw.zzb(context, zzboxVar, i).zzt();
        zzezfVarZzt.zzc(context);
        zzezfVarZzt.zza(zzqVar);
        zzezfVarZzt.zzb(str);
        return zzezfVarZzt.zzd().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zze(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, String str, zzbox zzboxVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfaw zzfawVarZzu = zzchw.zzb(context, zzboxVar, i).zzu();
        zzfawVarZzu.zzc(context);
        zzfawVarZzu.zza(zzqVar);
        zzfawVarZzu.zzb(str);
        return zzfawVarZzu.zzd().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zzf(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, String str, int i) {
        return new zzs((Context) ObjectWrapper.unwrap(iObjectWrapper), zzqVar, str, new zzcaz(233702000, i, true, false));
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzco zzg(IObjectWrapper iObjectWrapper, int i) {
        return zzchw.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), null, i).zzc();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzdj zzh(IObjectWrapper iObjectWrapper, zzbox zzboxVar, int i) {
        return zzchw.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzboxVar, i).zzl();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbfs zzi(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzdkf((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), 233702000);
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbfy zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzdkd((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbkk zzk(IObjectWrapper iObjectWrapper, zzbox zzboxVar, int i, zzbkh zzbkhVar) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdtx zzdtxVarZzj = zzchw.zzb(context, zzboxVar, i).zzj();
        zzdtxVarZzj.zzb(context);
        zzdtxVarZzj.zza(zzbkhVar);
        return zzdtxVarZzj.zzc().zzd();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbso zzl(IObjectWrapper iObjectWrapper, zzbox zzboxVar, int i) {
        return zzchw.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzboxVar, i).zzm();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbsv zzm(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel adOverlayInfoParcelZza = AdOverlayInfoParcel.zza(activity.getIntent());
        if (adOverlayInfoParcelZza == null) {
            return new com.google.android.gms.ads.internal.overlay.zzt(activity);
        }
        int i = adOverlayInfoParcelZza.zzk;
        if (i == 1) {
            return new com.google.android.gms.ads.internal.overlay.zzs(activity);
        }
        if (i == 2) {
            return new zzae(activity);
        }
        if (i == 3) {
            return new zzaf(activity);
        }
        if (i != 4) {
            return i != 5 ? new com.google.android.gms.ads.internal.overlay.zzt(activity) : new zzac(activity);
        }
        return new zzy(activity, adOverlayInfoParcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbvz zzn(IObjectWrapper iObjectWrapper, zzbox zzboxVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfck zzfckVarZzv = zzchw.zzb(context, zzboxVar, i).zzv();
        zzfckVarZzv.zzb(context);
        return zzfckVarZzv.zzc().zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbwp zzo(IObjectWrapper iObjectWrapper, String str, zzbox zzboxVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfck zzfckVarZzv = zzchw.zzb(context, zzboxVar, i).zzv();
        zzfckVarZzv.zzb(context);
        zzfckVarZzv.zza(str);
        return zzfckVarZzv.zzc().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbzk zzp(IObjectWrapper iObjectWrapper, zzbox zzboxVar, int i) {
        return zzchw.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzboxVar, i).zzp();
    }
}
