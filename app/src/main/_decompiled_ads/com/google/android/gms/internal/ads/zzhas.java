package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhas implements Iterator {
    int zza = 0;
    final /* synthetic */ zzhat zzb;

    zzhas(zzhat zzhatVar) {
        this.zzb = zzhatVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb.zza.size() || this.zzb.zzb.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.zza >= this.zzb.zza.size()) {
            zzhat zzhatVar = this.zzb;
            zzhatVar.zza.add(zzhatVar.zzb.next());
            return next();
        }
        zzhat zzhatVar2 = this.zzb;
        int i = this.zza;
        this.zza = i + 1;
        return zzhatVar2.zza.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
