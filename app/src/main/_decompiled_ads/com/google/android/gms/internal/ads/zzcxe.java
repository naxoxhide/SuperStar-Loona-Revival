package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcxe extends com.google.android.gms.ads.internal.client.zzdm {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final List zze;
    private final long zzf;
    private final String zzg;
    private final zzeez zzh;
    private final Bundle zzi;

    public zzcxe(zzfcr zzfcrVar, String str, zzeez zzeezVar, zzfcv zzfcvVar, String str2) {
        String string = null;
        this.zzb = zzfcrVar == null ? null : zzfcrVar.zzad;
        this.zzc = str2;
        this.zzd = zzfcvVar == null ? null : zzfcvVar.zzb;
        if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                string = zzfcrVar.zzx.getString("class_name");
            } catch (JSONException unused) {
            }
        }
        this.zza = string != null ? string : str;
        this.zze = zzeezVar.zzc();
        this.zzh = zzeezVar;
        this.zzf = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() / 1000;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgM)).booleanValue() || zzfcvVar == null) {
            this.zzi = new Bundle();
        } else {
            this.zzi = zzfcvVar.zzj;
        }
        this.zzg = (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziW)).booleanValue() || zzfcvVar == null || TextUtils.isEmpty(zzfcvVar.zzh)) ? "" : zzfcvVar.zzh;
    }

    public final long zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzg;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final Bundle zze() {
        return this.zzi;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final com.google.android.gms.ads.internal.client.zzu zzf() {
        zzeez zzeezVar = this.zzh;
        if (zzeezVar != null) {
            return zzeezVar.zza();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final String zzg() {
        return this.zza;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final String zzh() {
        return this.zzc;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final String zzi() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final List zzj() {
        return this.zze;
    }

    public final String zzk() {
        return this.zzd;
    }
}
