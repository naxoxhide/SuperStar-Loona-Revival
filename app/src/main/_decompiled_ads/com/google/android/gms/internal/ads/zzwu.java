package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzwu extends zzdb {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;
    private final SparseArray zzg;
    private final SparseBooleanArray zzh;

    @Deprecated
    public zzwu() {
        this.zzg = new SparseArray();
        this.zzh = new SparseBooleanArray();
        zzv();
    }

    private final void zzv() {
        this.zza = true;
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzf = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdb
    public final /* synthetic */ zzdb zze(int i, int i2, boolean z) {
        super.zze(i, i2, true);
        return this;
    }

    public final zzwu zzo(int i, boolean z) {
        if (this.zzh.get(i) == z) {
            return this;
        }
        if (z) {
            this.zzh.put(i, true);
        } else {
            this.zzh.delete(i);
        }
        return this;
    }

    public zzwu(Context context) {
        super.zzd(context);
        Point pointZzt = zzfk.zzt(context);
        zze(pointZzt.x, pointZzt.y, true);
        this.zzg = new SparseArray();
        this.zzh = new SparseBooleanArray();
        zzv();
    }

    /* synthetic */ zzwu(zzww zzwwVar, zzwt zzwtVar) {
        super(zzwwVar);
        this.zza = zzwwVar.zzH;
        this.zzb = zzwwVar.zzJ;
        this.zzc = zzwwVar.zzL;
        this.zzd = zzwwVar.zzQ;
        this.zze = zzwwVar.zzR;
        this.zzf = zzwwVar.zzT;
        SparseArray sparseArray = zzwwVar.zzam;
        SparseArray sparseArray2 = new SparseArray();
        for (int i = 0; i < sparseArray.size(); i++) {
            sparseArray2.put(sparseArray.keyAt(i), new HashMap((Map) sparseArray.valueAt(i)));
        }
        this.zzg = sparseArray2;
        this.zzh = zzwwVar.zzan.clone();
    }
}
