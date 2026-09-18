package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdqg {
    private final Map zza = new HashMap();

    zzdqg() {
    }

    @Nullable
    public final synchronized zzdqf zza(String str) {
        return (zzdqf) this.zza.get(str);
    }

    @Nullable
    public final zzdqf zzb(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzdqf zzdqfVarZza = zza((String) it.next());
            if (zzdqfVarZza != null) {
                return zzdqfVarZza;
            }
        }
        return null;
    }

    public final String zzc(String str) {
        zzbrj zzbrjVar;
        zzdqf zzdqfVarZza = zza(str);
        return (zzdqfVarZza == null || (zzbrjVar = zzdqfVarZza.zzb) == null) ? "" : zzbrjVar.toString();
    }

    final synchronized void zzd(String str, @Nullable zzfej zzfejVar) {
        zzbrj zzbrjVarZze;
        if (this.zza.containsKey(str)) {
            return;
        }
        zzbrj zzbrjVarZzf = null;
        if (zzfejVar == null) {
            zzbrjVarZze = null;
        } else {
            try {
                zzbrjVarZze = zzfejVar.zze();
            } catch (zzfds unused) {
                zzbrjVarZze = null;
            }
        }
        if (zzfejVar != null) {
            try {
                zzbrjVarZzf = zzfejVar.zzf();
            } catch (zzfds unused2) {
            }
        }
        boolean z = false;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjc)).booleanValue()) {
            z = true;
        } else if (zzfejVar != null) {
            try {
                zzfejVar.zzC();
                z = true;
            } catch (zzfds unused3) {
            }
        }
        this.zza.put(str, new zzdqf(str, zzbrjVarZze, zzbrjVarZzf, z));
    }

    final synchronized void zze(String str, zzbqv zzbqvVar) {
        if (this.zza.containsKey(str)) {
            return;
        }
        try {
            this.zza.put(str, new zzdqf(str, zzbqvVar.zzf(), zzbqvVar.zzg(), true));
        } catch (Throwable unused) {
        }
    }
}
