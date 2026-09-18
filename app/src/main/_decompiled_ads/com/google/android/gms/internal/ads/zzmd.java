package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzmd {
    private final zzah zza;
    private final SparseArray zzb;

    public zzmd(zzah zzahVar, SparseArray sparseArray) {
        this.zza = zzahVar;
        SparseArray sparseArray2 = new SparseArray(zzahVar.zzb());
        for (int i = 0; i < zzahVar.zzb(); i++) {
            int iZza = zzahVar.zza(i);
            zzmc zzmcVar = (zzmc) sparseArray.get(iZza);
            Objects.requireNonNull(zzmcVar);
            sparseArray2.append(iZza, zzmcVar);
        }
        this.zzb = sparseArray2;
    }

    public final int zza(int i) {
        return this.zza.zza(i);
    }

    public final int zzb() {
        return this.zza.zzb();
    }

    public final zzmc zzc(int i) {
        zzmc zzmcVar = (zzmc) this.zzb.get(i);
        Objects.requireNonNull(zzmcVar);
        return zzmcVar;
    }

    public final boolean zzd(int i) {
        return this.zza.zzc(i);
    }
}
