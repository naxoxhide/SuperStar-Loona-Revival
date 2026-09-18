package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdmr {
    private final Executor zza;
    private final zzdmm zzb;

    public zzdmr(Executor executor, zzdmm zzdmmVar) {
        this.zza = executor;
        this.zzb = zzdmmVar;
    }

    public final ListenableFuture zza(JSONObject jSONObject, String str) {
        ListenableFuture listenableFutureZzh;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("custom_assets");
        if (jSONArrayOptJSONArray == null) {
            return zzfzt.zzh(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArrayOptJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject == null) {
                listenableFutureZzh = zzfzt.zzh(null);
            } else {
                final String strOptString = jSONObjectOptJSONObject.optString("name");
                if (strOptString == null) {
                    listenableFutureZzh = zzfzt.zzh(null);
                } else {
                    String strOptString2 = jSONObjectOptJSONObject.optString("type");
                    listenableFutureZzh = "string".equals(strOptString2) ? zzfzt.zzh(new zzdmq(strOptString, jSONObjectOptJSONObject.optString("string_value"))) : "image".equals(strOptString2) ? zzfzt.zzm(this.zzb.zze(jSONObjectOptJSONObject, "image_value"), new zzfsk() { // from class: com.google.android.gms.internal.ads.zzdmo
                        @Override // com.google.android.gms.internal.ads.zzfsk
                        public final Object apply(Object obj) {
                            return new zzdmq(strOptString, (zzbfa) obj);
                        }
                    }, this.zza) : zzfzt.zzh(null);
                }
            }
            arrayList.add(listenableFutureZzh);
        }
        return zzfzt.zzm(zzfzt.zzd(arrayList), new zzfsk() { // from class: com.google.android.gms.internal.ads.zzdmp
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                ArrayList arrayList2 = new ArrayList();
                for (zzdmq zzdmqVar : (List) obj) {
                    if (zzdmqVar != null) {
                        arrayList2.add(zzdmqVar);
                    }
                }
                return arrayList2;
            }
        }, this.zza);
    }
}
