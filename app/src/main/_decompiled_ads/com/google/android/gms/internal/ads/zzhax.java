package com.google.android.gms.internal.ads;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzhax {
    final LinkedHashMap zza;

    zzhax(int i) {
        this.zza = zzhaz.zzb(i);
    }

    final zzhax zza(Object obj, zzhbp zzhbpVar) {
        zzhbk.zza(obj, SDKConstants.PARAM_KEY);
        zzhbk.zza(zzhbpVar, "provider");
        this.zza.put(obj, zzhbpVar);
        return this;
    }
}
