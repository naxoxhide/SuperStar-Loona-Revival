package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzglk implements zzgce {
    private static final zzglk zza = new zzglk();
    private static final zzgiu zzb = zzgiu.zzb(new zzgis() { // from class: com.google.android.gms.internal.ads.zzglh
        @Override // com.google.android.gms.internal.ads.zzgis
        public final Object zza(zzgbe zzgbeVar) {
            return zzglz.zzb((zzghx) zzgbeVar);
        }
    }, zzghx.class, zzgbv.class);

    zzglk() {
    }

    public static void zzd() throws GeneralSecurityException {
        zzgcg.zzg(zza);
        zzgif.zza().zze(zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzgce
    public final Class zza() {
        return zzgbv.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgce
    public final Class zzb() {
        return zzgbv.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgce
    public final /* bridge */ /* synthetic */ Object zzc(zzgcd zzgcdVar) throws GeneralSecurityException {
        Iterator it = zzgcdVar.zzd().iterator();
        while (it.hasNext()) {
            for (zzgbz zzgbzVar : (List) it.next()) {
                if (zzgbzVar.zzb() instanceof zzglf) {
                    zzglf zzglfVar = (zzglf) zzgbzVar.zzb();
                    zzgrx zzgrxVarZzb = zzgrx.zzb(zzgbzVar.zzg());
                    if (!zzgrxVarZzb.equals(zzglfVar.zzc())) {
                        throw new GeneralSecurityException("Mac Key with parameters " + String.valueOf(zzglfVar.zzb()) + " has wrong output prefix (" + zzglfVar.zzc().toString() + ") instead of (" + zzgrxVarZzb.toString() + ")");
                    }
                }
            }
        }
        return new zzglj(zzgcdVar, null);
    }
}
