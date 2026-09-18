package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzehz {
    private final zzgal zzc;
    private Object zzf;
    private final String zzh;
    private final int zzi;
    private final zzeio zzj;
    private zzfcr zzk;
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final List zzd = new ArrayList();
    private final Set zze = new HashSet();
    private int zzg = Integer.MAX_VALUE;

    zzehz(zzfde zzfdeVar, zzeio zzeioVar, zzgal zzgalVar) {
        this.zzi = zzfdeVar.zzb.zzb.zzp;
        this.zzj = zzeioVar;
        this.zzc = zzgalVar;
        this.zzh = zzeiu.zzc(zzfdeVar);
        List list = zzfdeVar.zzb.zza;
        for (int i = 0; i < list.size(); i++) {
            this.zza.put((zzfcr) list.get(i), Integer.valueOf(i));
        }
        this.zzb.addAll(list);
    }

    private final synchronized void zzf() {
        this.zzj.zzi(this.zzk);
        Object obj = this.zzf;
        if (obj != null) {
            this.zzc.zzc(obj);
        } else {
            this.zzc.zzd(new zzeir(3, this.zzh));
        }
    }

    private final synchronized boolean zzg(boolean z) {
        for (zzfcr zzfcrVar : this.zzb) {
            Integer num = (Integer) this.zza.get(zzfcrVar);
            Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE);
            if (z || !this.zze.contains(zzfcrVar.zzau)) {
                if (numValueOf.intValue() < this.zzg) {
                    return true;
                }
                if (numValueOf.intValue() > this.zzg) {
                    break;
                }
            }
        }
        return false;
    }

    private final synchronized boolean zzh() {
        boolean z;
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) this.zza.get((zzfcr) it.next());
            if (Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE).intValue() < this.zzg) {
                z = true;
            }
        }
        z = false;
        return z;
    }

    private final synchronized boolean zzi() {
        return zzg(true) || zzh();
    }

    @Nullable
    final synchronized zzfcr zza() {
        for (int i = 0; i < this.zzb.size(); i++) {
            zzfcr zzfcrVar = (zzfcr) this.zzb.get(i);
            String str = zzfcrVar.zzau;
            if (!this.zze.contains(str)) {
                if (!TextUtils.isEmpty(str)) {
                    this.zze.add(str);
                }
                this.zzd.add(zzfcrVar);
                return (zzfcr) this.zzb.remove(i);
            }
        }
        return null;
    }

    final synchronized void zzb(Throwable th, zzfcr zzfcrVar) {
        this.zzd.remove(zzfcrVar);
        this.zze.remove(zzfcrVar.zzau);
        if (zzd() || zzi()) {
            return;
        }
        zzf();
    }

    final synchronized void zzc(Object obj, zzfcr zzfcrVar) {
        this.zzd.remove(zzfcrVar);
        if (zzd()) {
            return;
        }
        Integer num = (Integer) this.zza.get(zzfcrVar);
        Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE);
        if (numValueOf.intValue() > this.zzg) {
            this.zzj.zzm(zzfcrVar);
            return;
        }
        if (this.zzf != null) {
            this.zzj.zzm(this.zzk);
        }
        this.zzg = numValueOf.intValue();
        this.zzf = obj;
        this.zzk = zzfcrVar;
        if (zzi()) {
            return;
        }
        zzf();
    }

    final synchronized boolean zzd() {
        return this.zzc.isDone();
    }

    final synchronized boolean zze() {
        if (!zzd()) {
            List list = this.zzd;
            if (list.size() < this.zzi && zzg(false)) {
                return true;
            }
        }
        return false;
    }
}
