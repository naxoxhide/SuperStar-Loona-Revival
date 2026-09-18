package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzfwm extends AbstractMap {

    @CheckForNull
    private transient Set zza;

    @CheckForNull
    private transient Set zzb;

    @CheckForNull
    private transient Collection zzc;

    zzfwm() {
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.zza;
        if (set != null) {
            return set;
        }
        Set setZzb = zzb();
        this.zza = setZzb;
        return setZzb;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.zzb;
        if (set != null) {
            return set;
        }
        Set setZze = zze();
        this.zzb = setZze;
        return setZze;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.zzc;
        if (collection != null) {
            return collection;
        }
        zzfwl zzfwlVar = new zzfwl(this);
        this.zzc = zzfwlVar;
        return zzfwlVar;
    }

    abstract Set zzb();

    Set zze() {
        return new zzfwk(this);
    }
}
