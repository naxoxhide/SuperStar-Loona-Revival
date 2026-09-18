package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgmj {
    private final zzgmc zza;
    private final List zzb;

    @Nullable
    private final Integer zzc;

    /* synthetic */ zzgmj(zzgmc zzgmcVar, List list, Integer num, zzgmi zzgmiVar) {
        this.zza = zzgmcVar;
        this.zzb = list;
        this.zzc = num;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgmj)) {
            return false;
        }
        zzgmj zzgmjVar = (zzgmj) obj;
        if (this.zza.equals(zzgmjVar.zza) && this.zzb.equals(zzgmjVar.zzb)) {
            Integer num = this.zzc;
            Integer num2 = zzgmjVar.zzc;
            if (num == num2) {
                return true;
            }
            if (num != null && num.equals(num2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", this.zza, this.zzb, this.zzc);
    }
}
