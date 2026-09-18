package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdju {
    public static final zzdju zza = new zzdju(new zzdjs());
    private final zzbgp zzb;
    private final zzbgm zzc;
    private final zzbhc zzd;
    private final zzbgz zze;
    private final zzbmb zzf;
    private final SimpleArrayMap zzg;
    private final SimpleArrayMap zzh;

    private zzdju(zzdjs zzdjsVar) {
        this.zzb = zzdjsVar.zza;
        this.zzc = zzdjsVar.zzb;
        this.zzd = zzdjsVar.zzc;
        this.zzg = new SimpleArrayMap(zzdjsVar.zzf);
        this.zzh = new SimpleArrayMap(zzdjsVar.zzg);
        this.zze = zzdjsVar.zzd;
        this.zzf = zzdjsVar.zze;
    }

    public final zzbgm zza() {
        return this.zzc;
    }

    public final zzbgp zzb() {
        return this.zzb;
    }

    public final zzbgs zzc(String str) {
        return (zzbgs) this.zzh.get(str);
    }

    public final zzbgv zzd(String str) {
        return (zzbgv) this.zzg.get(str);
    }

    public final zzbgz zze() {
        return this.zze;
    }

    public final zzbhc zzf() {
        return this.zzd;
    }

    public final zzbmb zzg() {
        return this.zzf;
    }

    public final ArrayList zzh() {
        ArrayList arrayList = new ArrayList(this.zzg.size());
        for (int i = 0; i < this.zzg.size(); i++) {
            arrayList.add((String) this.zzg.keyAt(i));
        }
        return arrayList;
    }

    public final ArrayList zzi() {
        ArrayList arrayList = new ArrayList();
        if (this.zzd != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzb != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzc != null) {
            arrayList.add(Integer.toString(2));
        }
        if (!this.zzg.isEmpty()) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzf != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }
}
