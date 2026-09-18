package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfsp {
    private final String zza;
    private final zzfsn zzb;
    private zzfsn zzc;

    /* synthetic */ zzfsp(String str, zzfso zzfsoVar) {
        zzfsn zzfsnVar = new zzfsn(null);
        this.zzb = zzfsnVar;
        this.zzc = zzfsnVar;
        Objects.requireNonNull(str);
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzfsn zzfsnVar = this.zzb.zzb;
        String str = "";
        while (zzfsnVar != null) {
            Object obj = zzfsnVar.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String strDeepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
            }
            zzfsnVar = zzfsnVar.zzb;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzfsp zza(@CheckForNull Object obj) {
        zzfsn zzfsnVar = new zzfsn(null);
        this.zzc.zzb = zzfsnVar;
        this.zzc = zzfsnVar;
        zzfsnVar.zza = obj;
        return this;
    }
}
