package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzawh implements Comparator {
    public zzawh(zzawi zzawiVar) {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzavw zzavwVar = (zzavw) obj;
        zzavw zzavwVar2 = (zzavw) obj2;
        if (zzavwVar.zzd() >= zzavwVar2.zzd()) {
            if (zzavwVar.zzd() > zzavwVar2.zzd()) {
                return 1;
            }
            if (zzavwVar.zzb() >= zzavwVar2.zzb()) {
                if (zzavwVar.zzb() > zzavwVar2.zzb()) {
                    return 1;
                }
                float fZza = (zzavwVar.zza() - zzavwVar.zzd()) * (zzavwVar.zzc() - zzavwVar.zzb());
                float fZza2 = (zzavwVar2.zza() - zzavwVar2.zzd()) * (zzavwVar2.zzc() - zzavwVar2.zzb());
                if (fZza <= fZza2) {
                    return fZza < fZza2 ? 1 : 0;
                }
            }
        }
        return -1;
    }
}
