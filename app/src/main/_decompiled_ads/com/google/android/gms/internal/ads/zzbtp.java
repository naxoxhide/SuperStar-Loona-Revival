package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbtp extends zzbtj {
    final /* synthetic */ List zza;

    zzbtp(zzbts zzbtsVar, List list) {
        this.zza = list;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zze(String str) {
        zzcat.zzg("Error recording impression urls: ".concat(String.valueOf(str)));
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zzf(List list) {
        zzcat.zzi("Recorded impression urls: ".concat(this.zza.toString()));
    }
}
