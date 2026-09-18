package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgfl extends zzghu {
    final /* synthetic */ zzgfm zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgfl(zzgfm zzgfmVar, Class cls) {
        super(cls);
        this.zza = zzgfmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* bridge */ /* synthetic */ zzgvj zza(zzgvj zzgvjVar) throws GeneralSecurityException {
        zzgof zzgofVarZzc = zzgog.zzc();
        zzgofVarZzc.zzb(0);
        byte[] bArrZzb = zzgjf.zzb(32);
        zzgofVarZzc.zza(zzgsr.zzv(bArrZzb, 0, bArrZzb.length));
        return (zzgog) zzgofVarZzc.zzal();
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* synthetic */ zzgvj zzb(zzgsr zzgsrVar) throws zzgul {
        return zzgoj.zzd(zzgsrVar, zzgtl.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final Map zzc() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("CHACHA20_POLY1305", zzgfo.zzb(zzgfn.zza));
        map.put("CHACHA20_POLY1305_RAW", zzgfo.zzb(zzgfn.zzc));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* bridge */ /* synthetic */ void zzd(zzgvj zzgvjVar) throws GeneralSecurityException {
    }
}
