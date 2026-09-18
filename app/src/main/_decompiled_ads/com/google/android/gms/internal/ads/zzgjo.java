package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgjo {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    /* synthetic */ zzgjo(zzgji zzgjiVar, zzgjn zzgjnVar) {
        this.zza = new HashMap(zzgjiVar.zza);
        this.zzb = new HashMap(zzgjiVar.zzb);
        this.zzc = new HashMap(zzgjiVar.zzc);
        this.zzd = new HashMap(zzgjiVar.zzd);
    }

    public final zzgbe zza(zzgjh zzgjhVar, @Nullable zzgch zzgchVar) throws GeneralSecurityException {
        zzgjk zzgjkVar = new zzgjk(zzgjhVar.getClass(), zzgjhVar.zzd(), null);
        if (this.zzb.containsKey(zzgjkVar)) {
            return ((zzghp) this.zzb.get(zzgjkVar)).zza(zzgjhVar, zzgchVar);
        }
        throw new GeneralSecurityException("No Key Parser for requested key type " + zzgjkVar.toString() + " available");
    }

    public final zzgjh zzb(zzgbw zzgbwVar, Class cls) throws GeneralSecurityException {
        zzgjm zzgjmVar = new zzgjm(zzgbwVar.getClass(), cls, null);
        if (this.zzc.containsKey(zzgjmVar)) {
            return ((zzgiq) this.zzc.get(zzgjmVar)).zza(zzgbwVar);
        }
        throw new GeneralSecurityException("No Key Format serializer for " + zzgjmVar.toString() + " available");
    }

    public final boolean zzg(zzgjh zzgjhVar) {
        return this.zzb.containsKey(new zzgjk(zzgjhVar.getClass(), zzgjhVar.zzd(), null));
    }
}
