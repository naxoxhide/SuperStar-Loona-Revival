package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzguv extends zzgux {
    private zzguv() {
        super(null);
    }

    /* synthetic */ zzguv(zzguu zzguuVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.ads.zzgux
    final List zza(Object obj, long j) {
        zzgui zzguiVar = (zzgui) zzgxd.zzh(obj, j);
        if (zzguiVar.zzc()) {
            return zzguiVar;
        }
        int size = zzguiVar.size();
        zzgui zzguiVarZzd = zzguiVar.zzd(size == 0 ? 10 : size + size);
        zzgxd.zzv(obj, j, zzguiVarZzd);
        return zzguiVarZzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgux
    final void zzb(Object obj, long j) {
        ((zzgui) zzgxd.zzh(obj, j)).zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzgux
    final void zzc(Object obj, Object obj2, long j) {
        zzgui zzguiVarZzd = (zzgui) zzgxd.zzh(obj, j);
        zzgui zzguiVar = (zzgui) zzgxd.zzh(obj2, j);
        int size = zzguiVarZzd.size();
        int size2 = zzguiVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzguiVarZzd.zzc()) {
                zzguiVarZzd = zzguiVarZzd.zzd(size2 + size);
            }
            zzguiVarZzd.addAll(zzguiVar);
        }
        if (size > 0) {
            zzguiVar = zzguiVarZzd;
        }
        zzgxd.zzv(obj, j, zzguiVar);
    }
}
