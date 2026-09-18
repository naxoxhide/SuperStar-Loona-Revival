package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdnq extends zzbgh {
    private final Context zza;
    private final zzdjj zzb;
    private zzdkj zzc;
    private zzdje zzd;

    public zzdnq(Context context, zzdjj zzdjjVar, zzdkj zzdkjVar, zzdje zzdjeVar) {
        this.zza = context;
        this.zzb = zzdjjVar;
        this.zzc = zzdkjVar;
        this.zzd = zzdjeVar;
    }

    private final zzbfb zzd(String str) {
        return new zzdnp(this, "_videoMediaView");
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final com.google.android.gms.ads.internal.client.zzdq zze() {
        return this.zzb.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final zzbfl zzf() throws RemoteException {
        try {
            return this.zzd.zzc().zza();
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "InternalNativeCustomTemplateAdShim.getMediaContent");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final zzbfo zzg(String str) {
        return (zzbfo) this.zzb.zzh().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final IObjectWrapper zzh() {
        return ObjectWrapper.wrap(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final String zzi() {
        return this.zzb.zzA();
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final String zzj(String str) {
        return (String) this.zzb.zzi().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final List zzk() {
        try {
            SimpleArrayMap simpleArrayMapZzh = this.zzb.zzh();
            SimpleArrayMap simpleArrayMapZzi = this.zzb.zzi();
            String[] strArr = new String[simpleArrayMapZzh.size() + simpleArrayMapZzi.size()];
            int i = 0;
            for (int i2 = 0; i2 < simpleArrayMapZzh.size(); i2++) {
                strArr[i] = (String) simpleArrayMapZzh.keyAt(i2);
                i++;
            }
            for (int i3 = 0; i3 < simpleArrayMapZzi.size(); i3++) {
                strArr[i] = (String) simpleArrayMapZzi.keyAt(i3);
                i++;
            }
            return Arrays.asList(strArr);
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "InternalNativeCustomTemplateAdShim.getAvailableAssetNames");
            return new ArrayList();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final void zzl() {
        zzdje zzdjeVar = this.zzd;
        if (zzdjeVar != null) {
            zzdjeVar.zzb();
        }
        this.zzd = null;
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final void zzm() {
        try {
            String strZzC = this.zzb.zzC();
            if (strZzC != "Google" && (strZzC == null || !strZzC.equals("Google"))) {
                if (TextUtils.isEmpty(strZzC)) {
                    zzcat.zzj("Not starting OMID session. OM partner name has not been configured.");
                    return;
                }
                zzdje zzdjeVar = this.zzd;
                if (zzdjeVar != null) {
                    zzdjeVar.zzf(strZzC, false);
                    return;
                }
                return;
            }
            zzcat.zzj("Illegal argument specified for omid partner name.");
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "InternalNativeCustomTemplateAdShim.initializeDisplayOpenMeasurement");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final void zzn(String str) {
        zzdje zzdjeVar = this.zzd;
        if (zzdjeVar != null) {
            zzdjeVar.zzD(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final void zzo() {
        zzdje zzdjeVar = this.zzd;
        if (zzdjeVar != null) {
            zzdjeVar.zzG();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final void zzp(IObjectWrapper iObjectWrapper) {
        zzdje zzdjeVar;
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(objUnwrap instanceof View) || this.zzb.zzu() == null || (zzdjeVar = this.zzd) == null) {
            return;
        }
        zzdjeVar.zzH((View) objUnwrap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final boolean zzq() {
        zzdje zzdjeVar = this.zzd;
        return (zzdjeVar == null || zzdjeVar.zzU()) && this.zzb.zzr() != null && this.zzb.zzs() == null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final boolean zzr(IObjectWrapper iObjectWrapper) {
        zzdkj zzdkjVar;
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(objUnwrap instanceof ViewGroup) || (zzdkjVar = this.zzc) == null || !zzdkjVar.zzf((ViewGroup) objUnwrap)) {
            return false;
        }
        this.zzb.zzq().zzao(zzd("_videoMediaView"));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final boolean zzs(IObjectWrapper iObjectWrapper) {
        zzdkj zzdkjVar;
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(objUnwrap instanceof ViewGroup) || (zzdkjVar = this.zzc) == null || !zzdkjVar.zzg((ViewGroup) objUnwrap)) {
            return false;
        }
        this.zzb.zzs().zzao(zzd("_videoMediaView"));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final boolean zzt() {
        zzfkc zzfkcVarZzu = this.zzb.zzu();
        if (zzfkcVarZzu == null) {
            zzcat.zzj("Trying to start OMID session before creation.");
            return false;
        }
        com.google.android.gms.ads.internal.zzt.zzA().zzi(zzfkcVarZzu);
        if (this.zzb.zzr() == null) {
            return true;
        }
        this.zzb.zzr().zzd("onSdkLoaded", new ArrayMap());
        return true;
    }
}
