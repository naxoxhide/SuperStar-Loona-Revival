package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbip implements zzbjj {
    zzbip() {
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObjectZzb;
        zzcgb zzcgbVar = (zzcgb) obj;
        zzbfb zzbfbVarZzK = zzcgbVar.zzK();
        if (zzbfbVarZzK == null || (jSONObjectZzb = zzbfbVarZzK.zzb()) == null) {
            zzcgbVar.zze("nativeClickMetaReady", new JSONObject());
        } else {
            zzcgbVar.zze("nativeClickMetaReady", jSONObjectZzb);
        }
    }
}
