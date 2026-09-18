package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzggk extends zzghu {
    final /* synthetic */ zzggl zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzggk(zzggl zzgglVar, Class cls) {
        super(cls);
        this.zza = zzgglVar;
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* bridge */ /* synthetic */ zzgvj zza(zzgvj zzgvjVar) throws GeneralSecurityException {
        zzgqk zzgqkVarZzc = zzgql.zzc();
        zzgqkVarZzc.zzb(0);
        byte[] bArrZzb = zzgjf.zzb(32);
        zzgqkVarZzc.zza(zzgsr.zzv(bArrZzb, 0, bArrZzb.length));
        return (zzgql) zzgqkVarZzc.zzal();
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* synthetic */ zzgvj zzb(zzgsr zzgsrVar) throws zzgul {
        return zzgqo.zzd(zzgsrVar, zzgtl.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final Map zzc() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("XCHACHA20_POLY1305", zzggn.zzb(zzggm.zza));
        map.put("XCHACHA20_POLY1305_RAW", zzggn.zzb(zzggm.zzc));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* bridge */ /* synthetic */ void zzd(zzgvj zzgvjVar) throws GeneralSecurityException {
    }
}
