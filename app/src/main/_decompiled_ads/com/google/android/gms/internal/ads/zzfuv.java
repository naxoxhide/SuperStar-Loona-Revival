package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfuv extends AbstractSet {
    final /* synthetic */ zzfvb zza;

    zzfuv(zzfvb zzfvbVar) {
        this.zza = zzfvbVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        Map mapZzj = this.zza.zzj();
        if (mapZzj != null) {
            return mapZzj.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int iZzq = this.zza.zzq(entry.getKey());
            if (iZzq != -1) {
                Object[] objArr = this.zza.zzc;
                objArr.getClass();
                if (zzfsr.zza(objArr[iZzq], entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzfvb zzfvbVar = this.zza;
        Map mapZzj = zzfvbVar.zzj();
        return mapZzj != null ? mapZzj.entrySet().iterator() : new zzfut(zzfvbVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object obj) {
        Map mapZzj = this.zza.zzj();
        if (mapZzj != null) {
            return mapZzj.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        zzfvb zzfvbVar = this.zza;
        if (zzfvbVar.zzo()) {
            return false;
        }
        int iZzp = zzfvbVar.zzp();
        Object key = entry.getKey();
        Object value = entry.getValue();
        zzfvb zzfvbVar2 = this.zza;
        Object objZzh = zzfvb.zzh(zzfvbVar2);
        int[] iArr = zzfvbVar2.zza;
        iArr.getClass();
        zzfvb zzfvbVar3 = this.zza;
        Object[] objArr = zzfvbVar3.zzb;
        objArr.getClass();
        Object[] objArr2 = zzfvbVar3.zzc;
        objArr2.getClass();
        int iZzb = zzfvc.zzb(key, value, iZzp, objZzh, iArr, objArr, objArr2);
        if (iZzb == -1) {
            return false;
        }
        this.zza.zzn(iZzb, iZzp);
        this.zza.zzg--;
        this.zza.zzl();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }
}
