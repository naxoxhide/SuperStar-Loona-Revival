package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgbu {
    private static final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public static zzgbt zza(String str) throws GeneralSecurityException {
        for (zzgbt zzgbtVar : zza) {
            if (zzgbtVar.zza()) {
                return zzgbtVar;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: ".concat(String.valueOf(str)));
    }
}
