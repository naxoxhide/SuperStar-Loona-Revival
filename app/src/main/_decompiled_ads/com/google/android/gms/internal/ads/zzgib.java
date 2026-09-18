package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgib {
    public static final zzgmd zza = new zzgia(null);

    public static zzgmj zza(zzgcd zzgcdVar) {
        zzgbj zzgbjVar;
        zzgmf zzgmfVar = new zzgmf();
        zzgmfVar.zzb(zzgcdVar.zzb());
        Iterator it = zzgcdVar.zzd().iterator();
        while (it.hasNext()) {
            for (zzgbz zzgbzVar : (List) it.next()) {
                int iZzh = zzgbzVar.zzh() - 2;
                if (iZzh == 1) {
                    zzgbjVar = zzgbj.zza;
                } else if (iZzh == 2) {
                    zzgbjVar = zzgbj.zzb;
                } else {
                    if (iZzh != 3) {
                        throw new IllegalStateException("Unknown key status");
                    }
                    zzgbjVar = zzgbj.zzc;
                }
                int iZza = zzgbzVar.zza();
                String strZzf = zzgbzVar.zzf();
                if (strZzf.startsWith("type.googleapis.com/google.crypto.")) {
                    strZzf = strZzf.substring(34);
                }
                zzgmfVar.zza(zzgbjVar, iZza, strZzf, zzgbzVar.zzc().name());
            }
        }
        if (zzgcdVar.zza() != null) {
            zzgmfVar.zzc(zzgcdVar.zza().zza());
        }
        try {
            return zzgmfVar.zzd();
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
