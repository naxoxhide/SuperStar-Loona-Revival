package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzful extends zzfuo implements Serializable {
    private final transient Map zza;
    private transient int zzb;

    protected zzful(Map map) {
        zzfsw.zze(map.isEmpty());
        this.zza = map;
    }

    static /* bridge */ /* synthetic */ void zzo(zzful zzfulVar, Object obj) {
        Object objRemove;
        try {
            objRemove = zzfulVar.zza.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            objRemove = null;
        }
        Collection collection = (Collection) objRemove;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            zzfulVar.zzb -= size;
        }
    }

    abstract Collection zza();

    Collection zzb(Collection collection) {
        throw null;
    }

    Collection zzc(Object obj, Collection collection) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzfwo
    public final int zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfuo
    final Collection zzf() {
        return new zzfun(this);
    }

    @Override // com.google.android.gms.internal.ads.zzfuo
    final Iterator zzg() {
        return new zzftv(this);
    }

    final List zzh(Object obj, List list, @CheckForNull zzfui zzfuiVar) {
        return list instanceof RandomAccess ? new zzfue(this, obj, list, zzfuiVar) : new zzfuk(this, obj, list, zzfuiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfuo
    Map zzj() {
        throw null;
    }

    final Map zzk() {
        Map map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzfuc(this, (NavigableMap) map);
        }
        return map instanceof SortedMap ? new zzfuf(this, (SortedMap) map) : new zzfty(this, map);
    }

    @Override // com.google.android.gms.internal.ads.zzfuo
    Set zzl() {
        throw null;
    }

    final Set zzm() {
        Map map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzfud(this, (NavigableMap) map);
        }
        return map instanceof SortedMap ? new zzfug(this, (SortedMap) map) : new zzfub(this, map);
    }

    @Override // com.google.android.gms.internal.ads.zzfwo
    public final void zzp() {
        Iterator it = this.zza.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        this.zza.clear();
        this.zzb = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfuo, com.google.android.gms.internal.ads.zzfwo
    public final boolean zzq(Object obj, Object obj2) {
        Collection collection = (Collection) this.zza.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.zzb++;
            return true;
        }
        Collection collectionZza = zza();
        if (!collectionZza.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.zzb++;
        this.zza.put(obj, collectionZza);
        return true;
    }
}
