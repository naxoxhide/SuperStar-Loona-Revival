package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzbme {
    public static void zza(zzbmf zzbmfVar, String str, Map map) {
        try {
            zzbmfVar.zze(str, com.google.android.gms.ads.internal.client.zzay.zzb().zzi(map));
        } catch (JSONException unused) {
            zzcat.zzj("Could not convert parameters to JSON.");
        }
    }

    public static void zzb(zzbmf zzbmfVar, String str, JSONObject jSONObject) {
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(string);
        sb.append(");");
        zzcat.zze("Dispatching AFMA event: ".concat(sb.toString()));
        zzbmfVar.zza(sb.toString());
    }

    public static void zzc(zzbmf zzbmfVar, String str, String str2) {
        zzbmfVar.zza(str + "(" + str2 + ");");
    }

    public static void zzd(zzbmf zzbmfVar, String str, JSONObject jSONObject) {
        zzbmfVar.zzb(str, jSONObject.toString());
    }
}
