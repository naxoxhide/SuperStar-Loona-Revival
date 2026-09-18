package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgvx {
    private final ArrayDeque zza = new ArrayDeque();

    private zzgvx() {
    }

    static /* bridge */ /* synthetic */ zzgsr zza(zzgvx zzgvxVar, zzgsr zzgsrVar, zzgsr zzgsrVar2) {
        zzgvxVar.zzb(zzgsrVar);
        zzgvxVar.zzb(zzgsrVar2);
        zzgsr zzgwbVar = (zzgsr) zzgvxVar.zza.pop();
        while (!zzgvxVar.zza.isEmpty()) {
            zzgwbVar = new zzgwb((zzgsr) zzgvxVar.zza.pop(), zzgwbVar);
        }
        return zzgwbVar;
    }

    private final void zzb(zzgsr zzgsrVar) {
        zzgwa zzgwaVar;
        if (!zzgsrVar.zzh()) {
            if (!(zzgsrVar instanceof zzgwb)) {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(String.valueOf(zzgsrVar.getClass()))));
            }
            zzgwb zzgwbVar = (zzgwb) zzgsrVar;
            zzb(zzgwbVar.zzd);
            zzb(zzgwbVar.zze);
            return;
        }
        int iZzc = zzc(zzgsrVar.zzd());
        ArrayDeque arrayDeque = this.zza;
        int iZzc2 = zzgwb.zzc(iZzc + 1);
        if (arrayDeque.isEmpty() || ((zzgsr) this.zza.peek()).zzd() >= iZzc2) {
            this.zza.push(zzgsrVar);
            return;
        }
        int iZzc3 = zzgwb.zzc(iZzc);
        zzgsr zzgwbVar2 = (zzgsr) this.zza.pop();
        while (true) {
            zzgwaVar = null;
            if (this.zza.isEmpty() || ((zzgsr) this.zza.peek()).zzd() >= iZzc3) {
                break;
            } else {
                zzgwbVar2 = new zzgwb((zzgsr) this.zza.pop(), zzgwbVar2);
            }
        }
        zzgwb zzgwbVar3 = new zzgwb(zzgwbVar2, zzgsrVar);
        while (!this.zza.isEmpty()) {
            int iZzc4 = zzc(zzgwbVar3.zzd()) + 1;
            ArrayDeque arrayDeque2 = this.zza;
            if (((zzgsr) arrayDeque2.peek()).zzd() >= zzgwb.zzc(iZzc4)) {
                break;
            } else {
                zzgwbVar3 = new zzgwb((zzgsr) this.zza.pop(), zzgwbVar3);
            }
        }
        this.zza.push(zzgwbVar3);
    }

    private static final int zzc(int i) {
        int iBinarySearch = Arrays.binarySearch(zzgwb.zza, i);
        return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
    }

    /* synthetic */ zzgvx(zzgvw zzgvwVar) {
    }
}
