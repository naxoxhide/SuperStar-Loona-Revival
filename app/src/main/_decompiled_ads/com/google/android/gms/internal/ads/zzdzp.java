package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdzp {
    private final zzgad zza;
    private final zzdzk zzb;
    private final zzfhr zzc;

    zzdzp(zzgad zzgadVar, zzdzk zzdzkVar, zzfhr zzfhrVar) {
        this.zza = zzgadVar;
        this.zzb = zzdzkVar;
        this.zzc = zzfhrVar;
    }

    public final ListenableFuture zza(final zzbvg zzbvgVar) {
        zzfhi zzfhiVarZzb = this.zzc.zzb(zzfhl.GMS_SIGNALS, zzfzt.zzm(zzfzt.zzh(null), new zzfsk() { // from class: com.google.android.gms.internal.ads.zzdzm
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                zzbvg zzbvgVar2 = zzbvgVar;
                return new zzbuk(zzbvgVar2.zzc, zzbvgVar2.zzd, zzbvgVar2.zzf, zzftl.zzc(zzbvgVar2.zza.getString("ms")), -1, zzbvgVar2.zzh, zzbvgVar2.zze, zzbvgVar2.zzk, zzbvgVar2.zzl);
            }
        }, this.zza));
        final zzdzk zzdzkVar = this.zzb;
        return zzfzt.zzm(zzfhiVarZzb.zzf(new zzfza() { // from class: com.google.android.gms.internal.ads.zzdzn
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return zzdzkVar.zzb((zzbuk) obj);
            }
        }).zza(), new zzfsk() { // from class: com.google.android.gms.internal.ads.zzdzo
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                Bundle bundle = zzbvgVar.zza;
                if (bundle == null) {
                    return jSONObject;
                }
                try {
                    JSONObject jSONObjectZzh = com.google.android.gms.ads.internal.client.zzay.zzb().zzh(bundle);
                    try {
                        com.google.android.gms.ads.internal.client.zzay.zzb().zzk(jSONObject, jSONObjectZzh);
                        return jSONObject;
                    } catch (JSONException unused) {
                        return jSONObjectZzh;
                    }
                } catch (JSONException unused2) {
                    return jSONObject;
                }
            }
        }, this.zza);
    }
}
