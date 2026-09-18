package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzs extends zzai {
    final boolean zza;
    final boolean zzb;
    final /* synthetic */ zzt zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzs(zzt zztVar, boolean z, boolean z2) {
        super("log");
        this.zzc = zztVar;
        this.zza = z;
        this.zzb = z2;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x006f  */
    /* JADX WARN: Code duplicated, block: B:22:0x0083  */
    /* JADX WARN: Code duplicated, block: B:25:0x0092 A[LOOP:0: B:23:0x0088->B:25:0x0092, LOOP_END] */
    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzap zza(zzg zzgVar, List list) {
        int i;
        String strZzi;
        ArrayList arrayList;
        zzh.zzi("log", 1, list);
        if (list.size() == 1) {
            this.zzc.zza.zza(3, zzgVar.zzb((zzap) list.get(0)).zzi(), Collections.emptyList(), this.zza, this.zzb);
            return zzf;
        }
        int iZzb = zzh.zzb(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
        int i2 = 3;
        if (iZzb != 2) {
            if (iZzb == 3) {
                i = 1;
            } else if (iZzb == 5) {
                i = 5;
            } else if (iZzb == 6) {
                i = 2;
            }
            strZzi = zzgVar.zzb((zzap) list.get(1)).zzi();
            if (list.size() == 2) {
                this.zzc.zza.zza(i, strZzi, Collections.emptyList(), this.zza, this.zzb);
                return zzf;
            }
            arrayList = new ArrayList();
            for (int i3 = 2; i3 < Math.min(list.size(), 5); i3++) {
                arrayList.add(zzgVar.zzb((zzap) list.get(i3)).zzi());
            }
            this.zzc.zza.zza(i, strZzi, arrayList, this.zza, this.zzb);
            return zzf;
        }
        i2 = 4;
        i = i2;
        strZzi = zzgVar.zzb((zzap) list.get(1)).zzi();
        if (list.size() == 2) {
            this.zzc.zza.zza(i, strZzi, Collections.emptyList(), this.zza, this.zzb);
            return zzf;
        }
        arrayList = new ArrayList();
        while (i3 < Math.min(list.size(), 5)) {
            arrayList.add(zzgVar.zzb((zzap) list.get(i3)).zzi());
        }
        this.zzc.zza.zza(i, strZzi, arrayList, this.zza, this.zzb);
        return zzf;
    }
}
