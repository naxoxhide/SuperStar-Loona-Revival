package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgko implements zzgce {
    private static final zzgko zza = new zzgko();

    private zzgko() {
    }

    static void zzd() throws GeneralSecurityException {
        zzgcg.zzg(zza);
    }

    @Override // com.google.android.gms.internal.ads.zzgce
    public final Class zza() {
        return zzgkl.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgce
    public final Class zzb() {
        return zzgkl.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgce
    public final /* bridge */ /* synthetic */ Object zzc(zzgcd zzgcdVar) throws GeneralSecurityException {
        if (zzgcdVar.zza() == null) {
            throw new GeneralSecurityException("no primary in primitive set");
        }
        Iterator it = zzgcdVar.zzd().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            while (it2.hasNext()) {
            }
        }
        return new zzgkn(zzgcdVar, null);
    }
}
