package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.core.view.PointerIconCompat;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzww extends zzdc {
    public static final zzww zzE;

    @Deprecated
    public static final zzww zzF;
    public static final zzn zzG;
    private static final String zzU;
    private static final String zzV;
    private static final String zzW;
    private static final String zzX;
    private static final String zzY;
    private static final String zzZ;
    private static final String zzaa;
    private static final String zzab;
    private static final String zzac;
    private static final String zzad;
    private static final String zzae;
    private static final String zzaf;
    private static final String zzag;
    private static final String zzah;
    private static final String zzai;
    private static final String zzaj;
    private static final String zzak;
    private static final String zzal;
    public final boolean zzH;
    public final boolean zzI;
    public final boolean zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final boolean zzQ;
    public final boolean zzR;
    public final boolean zzS;
    public final boolean zzT;
    private final SparseArray zzam;
    private final SparseBooleanArray zzan;

    static {
        zzww zzwwVar = new zzww(new zzwu());
        zzE = zzwwVar;
        zzF = zzwwVar;
        zzU = Integer.toString(1000, 36);
        zzV = Integer.toString(1001, 36);
        zzW = Integer.toString(1002, 36);
        zzX = Integer.toString(PointerIconCompat.TYPE_HELP, 36);
        zzY = Integer.toString(PointerIconCompat.TYPE_WAIT, 36);
        zzZ = Integer.toString(1005, 36);
        zzaa = Integer.toString(PointerIconCompat.TYPE_CELL, 36);
        zzab = Integer.toString(PointerIconCompat.TYPE_CROSSHAIR, 36);
        zzac = Integer.toString(PointerIconCompat.TYPE_TEXT, 36);
        zzad = Integer.toString(PointerIconCompat.TYPE_VERTICAL_TEXT, 36);
        zzae = Integer.toString(PointerIconCompat.TYPE_ALIAS, 36);
        zzaf = Integer.toString(PointerIconCompat.TYPE_COPY, 36);
        zzag = Integer.toString(PointerIconCompat.TYPE_NO_DROP, 36);
        zzah = Integer.toString(PointerIconCompat.TYPE_ALL_SCROLL, 36);
        zzai = Integer.toString(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, 36);
        zzaj = Integer.toString(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, 36);
        zzak = Integer.toString(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, 36);
        zzal = Integer.toString(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 36);
        zzG = new zzn() { // from class: com.google.android.gms.internal.ads.zzws
        };
    }

    private zzww(zzwu zzwuVar) {
        super(zzwuVar);
        this.zzH = zzwuVar.zza;
        this.zzI = false;
        this.zzJ = zzwuVar.zzb;
        this.zzK = false;
        this.zzL = zzwuVar.zzc;
        this.zzM = false;
        this.zzN = false;
        this.zzO = false;
        this.zzP = false;
        this.zzQ = zzwuVar.zzd;
        this.zzR = zzwuVar.zze;
        this.zzS = false;
        this.zzT = zzwuVar.zzf;
        this.zzam = zzwuVar.zzg;
        this.zzan = zzwuVar.zzh;
    }

    public static zzww zzd(Context context) {
        return new zzww(new zzwu(context));
    }

    @Override // com.google.android.gms.internal.ads.zzdc
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzww zzwwVar = (zzww) obj;
            if (super.equals(zzwwVar) && this.zzH == zzwwVar.zzH && this.zzJ == zzwwVar.zzJ && this.zzL == zzwwVar.zzL && this.zzQ == zzwwVar.zzQ && this.zzR == zzwwVar.zzR && this.zzT == zzwwVar.zzT) {
                SparseBooleanArray sparseBooleanArray = this.zzan;
                SparseBooleanArray sparseBooleanArray2 = zzwwVar.zzan;
                int size = sparseBooleanArray.size();
                if (sparseBooleanArray2.size() == size) {
                    for (int i = 0; i < size; i++) {
                        if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) >= 0) {
                        }
                    }
                    SparseArray sparseArray = this.zzam;
                    SparseArray sparseArray2 = zzwwVar.zzam;
                    int size2 = sparseArray.size();
                    if (sparseArray2.size() == size2) {
                        for (int i2 = 0; i2 < size2; i2++) {
                            int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                            if (iIndexOfKey >= 0) {
                                Map map = (Map) sparseArray.valueAt(i2);
                                Map map2 = (Map) sparseArray2.valueAt(iIndexOfKey);
                                if (map2.size() == map.size()) {
                                    for (Map.Entry entry : map.entrySet()) {
                                        zzvx zzvxVar = (zzvx) entry.getKey();
                                        if (!map2.containsKey(zzvxVar) || !zzfk.zzE(entry.getValue(), map2.get(zzvxVar))) {
                                        }
                                    }
                                }
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdc
    public final int hashCode() {
        return (((((((((((((super.hashCode() + 31) * 31) + (this.zzH ? 1 : 0)) * 961) + (this.zzJ ? 1 : 0)) * 961) + (this.zzL ? 1 : 0)) * 28629151) + (this.zzQ ? 1 : 0)) * 31) + (this.zzR ? 1 : 0)) * 961) + (this.zzT ? 1 : 0)) * 31;
    }

    public final zzwu zzc() {
        return new zzwu(this, null);
    }

    @Deprecated
    public final zzwy zze(int i, zzvx zzvxVar) {
        Map map = (Map) this.zzam.get(i);
        if (map != null) {
            return (zzwy) map.get(zzvxVar);
        }
        return null;
    }

    public final boolean zzf(int i) {
        return this.zzan.get(i);
    }

    @Deprecated
    public final boolean zzg(int i, zzvx zzvxVar) {
        Map map = (Map) this.zzam.get(i);
        return map != null && map.containsKey(zzvxVar);
    }
}
