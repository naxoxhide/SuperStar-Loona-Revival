package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfkd {
    private final zzfkl zza;
    private final zzfkl zzb;
    private final zzfkh zzc;
    private final zzfkk zzd;

    private zzfkd(zzfkh zzfkhVar, zzfkk zzfkkVar, zzfkl zzfklVar, zzfkl zzfklVar2, boolean z) {
        this.zzc = zzfkhVar;
        this.zzd = zzfkkVar;
        this.zza = zzfklVar;
        if (zzfklVar2 == null) {
            this.zzb = zzfkl.NONE;
        } else {
            this.zzb = zzfklVar2;
        }
    }

    public static zzfkd zza(zzfkh zzfkhVar, zzfkk zzfkkVar, zzfkl zzfklVar, zzfkl zzfklVar2, boolean z) {
        zzfls.zzb(zzfkkVar, "ImpressionType is null");
        zzfls.zzb(zzfklVar, "Impression owner is null");
        if (zzfklVar == zzfkl.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        }
        if (zzfkhVar == zzfkh.DEFINED_BY_JAVASCRIPT && zzfklVar == zzfkl.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
        if (zzfkkVar == zzfkk.DEFINED_BY_JAVASCRIPT && zzfklVar == zzfkl.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
        return new zzfkd(zzfkhVar, zzfkkVar, zzfklVar, zzfklVar2, true);
    }

    public final JSONObject zzb() {
        JSONObject jSONObject = new JSONObject();
        zzfln.zze(jSONObject, "impressionOwner", this.zza);
        zzfln.zze(jSONObject, "mediaEventsOwner", this.zzb);
        zzfln.zze(jSONObject, "creativeType", this.zzc);
        zzfln.zze(jSONObject, "impressionType", this.zzd);
        zzfln.zze(jSONObject, "isolateVerificationScripts", true);
        return jSONObject;
    }
}
