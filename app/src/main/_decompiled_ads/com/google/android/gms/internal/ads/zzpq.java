package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzpq {
    private Boolean zza;

    public zzpq() {
    }

    public zzpq(Context context) {
    }

    public final zzoq zza(zzam zzamVar, zzk zzkVar) {
        Objects.requireNonNull(zzamVar);
        Objects.requireNonNull(zzkVar);
        if (zzfk.zza < 29 || zzamVar.zzA == -1) {
            return zzoq.zza;
        }
        Boolean bool = this.zza;
        if (bool != null) {
            bool.booleanValue();
        } else {
            Boolean bool2 = false;
            this.zza = bool2;
            bool2.booleanValue();
        }
        String str = zzamVar.zzm;
        Objects.requireNonNull(str);
        int iZza = zzcb.zza(str, zzamVar.zzj);
        if (iZza == 0 || zzfk.zza < zzfk.zzf(iZza)) {
            return zzoq.zza;
        }
        int iZzg = zzfk.zzg(zzamVar.zzz);
        if (iZzg == 0) {
            return zzoq.zza;
        }
        try {
            AudioFormat audioFormatZzu = zzfk.zzu(zzamVar.zzA, iZzg, iZza);
            return zzfk.zza >= 31 ? zzpp.zza(audioFormatZzu, zzkVar.zza().zza, false) : zzpo.zza(audioFormatZzu, zzkVar.zza().zza, false);
        } catch (IllegalArgumentException unused) {
            return zzoq.zza;
        }
    }
}
