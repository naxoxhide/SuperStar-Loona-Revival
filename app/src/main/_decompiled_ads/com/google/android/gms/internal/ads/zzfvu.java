package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfvu {
    Object[] zza;
    int zzb;
    zzfvt zzc;

    public zzfvu() {
        this(4);
    }

    private final void zzd(int i) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            this.zza = Arrays.copyOf(objArr, zzfvm.zze(length, i2));
        }
    }

    public final zzfvu zza(Object obj, Object obj2) {
        zzd(this.zzb + 1);
        zzfup.zzb(obj, obj2);
        Object[] objArr = this.zza;
        int i = this.zzb;
        int i2 = i + i;
        objArr[i2] = obj;
        objArr[i2 + 1] = obj2;
        this.zzb = i + 1;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzfvu zzb(Iterable iterable) {
        if (iterable instanceof Collection) {
            zzd(this.zzb + iterable.size());
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zza(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public final zzfvv zzc() {
        zzfvt zzfvtVar = this.zzc;
        if (zzfvtVar != null) {
            throw zzfvtVar.zza();
        }
        zzfxh zzfxhVarZzj = zzfxh.zzj(this.zzb, this.zza, this);
        zzfvt zzfvtVar2 = this.zzc;
        if (zzfvtVar2 == null) {
            return zzfxhVarZzj;
        }
        throw zzfvtVar2.zza();
    }

    zzfvu(int i) {
        this.zza = new Object[i + i];
        this.zzb = 0;
    }
}
