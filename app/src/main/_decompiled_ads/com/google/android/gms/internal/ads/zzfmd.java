package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfmd extends zzfme {
    protected final HashSet zza;
    protected final JSONObject zzb;
    protected final long zzc;

    public zzfmd(zzflw zzflwVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzflwVar);
        this.zza = new HashSet(hashSet);
        this.zzb = jSONObject;
        this.zzc = j;
    }
}
