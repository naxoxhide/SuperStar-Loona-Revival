package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgvz implements Iterator {
    private final ArrayDeque zza;
    private zzgsm zzb;

    /* synthetic */ zzgvz(zzgsr zzgsrVar, zzgvy zzgvyVar) {
        if (!(zzgsrVar instanceof zzgwb)) {
            this.zza = null;
            this.zzb = (zzgsm) zzgsrVar;
            return;
        }
        zzgwb zzgwbVar = (zzgwb) zzgsrVar;
        ArrayDeque arrayDeque = new ArrayDeque(zzgwbVar.zzf());
        this.zza = arrayDeque;
        arrayDeque.push(zzgwbVar);
        this.zzb = zzb(zzgwbVar.zzd);
    }

    private final zzgsm zzb(zzgsr zzgsrVar) {
        while (zzgsrVar instanceof zzgwb) {
            zzgwb zzgwbVar = (zzgwb) zzgsrVar;
            this.zza.push(zzgwbVar);
            zzgsrVar = zzgwbVar.zzd;
        }
        return (zzgsm) zzgsrVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzgsm next() {
        zzgsm zzgsmVarZzb;
        zzgsm zzgsmVar = this.zzb;
        if (zzgsmVar == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque arrayDeque = this.zza;
            zzgsmVarZzb = null;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                break;
            }
            zzgsmVarZzb = zzb(((zzgwb) this.zza.pop()).zze);
        } while (zzgsmVarZzb.zzd() == 0);
        this.zzb = zzgsmVarZzb;
        return zzgsmVar;
    }
}
