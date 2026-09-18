package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfvv implements Map, Serializable {

    @CheckForNull
    private transient zzfvx zza;

    @CheckForNull
    private transient zzfvx zzb;

    @CheckForNull
    private transient zzfvn zzc;

    zzfvv() {
    }

    public static zzfvv zzc(Map map) {
        Set setEntrySet = map.entrySet();
        zzfvu zzfvuVar = new zzfvu(setEntrySet instanceof Collection ? setEntrySet.size() : 4);
        zzfvuVar.zzb(setEntrySet);
        return zzfvuVar.zzc();
    }

    public static zzfvv zzd() {
        return zzfxh.zza;
    }

    public static zzfvv zze(Object obj, Object obj2) {
        zzfup.zzb("dialog_not_shown_reason", obj2);
        return zzfxh.zzj(1, new Object[]{"dialog_not_shown_reason", obj2}, null);
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(@CheckForNull Object obj) {
        return zzfwn.zzb(this, obj);
    }

    @Override // java.util.Map
    @CheckForNull
    public abstract Object get(@CheckForNull Object obj);

    @Override // java.util.Map
    @CheckForNull
    public final Object getOrDefault(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return zzfxo.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        zzfup.zza(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    abstract zzfvn zza();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzfvn values() {
        zzfvn zzfvnVar = this.zzc;
        if (zzfvnVar != null) {
            return zzfvnVar;
        }
        zzfvn zzfvnVarZza = zza();
        this.zzc = zzfvnVarZza;
        return zzfvnVarZza;
    }

    abstract zzfvx zzf();

    abstract zzfvx zzg();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final zzfvx entrySet() {
        zzfvx zzfvxVar = this.zza;
        if (zzfvxVar != null) {
            return zzfvxVar;
        }
        zzfvx zzfvxVarZzf = zzf();
        this.zza = zzfvxVarZzf;
        return zzfvxVarZzf;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final zzfvx keySet() {
        zzfvx zzfvxVar = this.zzb;
        if (zzfvxVar != null) {
            return zzfvxVar;
        }
        zzfvx zzfvxVarZzg = zzg();
        this.zzb = zzfvxVarZzg;
        return zzfvxVarZzg;
    }
}
