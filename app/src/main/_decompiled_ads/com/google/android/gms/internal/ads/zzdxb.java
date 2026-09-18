package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdxb implements zzhbc {
    private final zzhbp zza;

    public zzdxb(zzhbp zzhbpVar) {
        this.zza = zzhbpVar;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0051  */
    /* JADX WARN: Code duplicated, block: B:18:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x0036  */
    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        String strValueOf;
        zzfdn zzfdnVarZza = ((zzcxc) this.zza).zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhj)).booleanValue()) {
            String str = zzfdnVarZza.zzd.zzx;
            if (!TextUtils.isEmpty(str)) {
                try {
                    strValueOf = new JSONObject(str).getString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID);
                    if (TextUtils.isEmpty(strValueOf)) {
                        if (zzfdnVarZza.zzd.zzs != null) {
                            try {
                                strValueOf = new JSONObject(zzfdnVarZza.zzd.zzs.zza).getString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID);
                                if (TextUtils.isEmpty(strValueOf)) {
                                    strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzay.zze().nextInt() & Integer.MAX_VALUE);
                                }
                            } catch (JSONException unused) {
                            }
                        } else {
                            strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzay.zze().nextInt() & Integer.MAX_VALUE);
                        }
                    }
                } catch (JSONException unused2) {
                }
            } else if (zzfdnVarZza.zzd.zzs != null) {
                strValueOf = new JSONObject(zzfdnVarZza.zzd.zzs.zza).getString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID);
                if (TextUtils.isEmpty(strValueOf)) {
                    strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzay.zze().nextInt() & Integer.MAX_VALUE);
                }
            } else {
                strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzay.zze().nextInt() & Integer.MAX_VALUE);
            }
        } else {
            strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzay.zze().nextInt() & Integer.MAX_VALUE);
        }
        zzhbk.zzb(strValueOf);
        return strValueOf;
    }
}
