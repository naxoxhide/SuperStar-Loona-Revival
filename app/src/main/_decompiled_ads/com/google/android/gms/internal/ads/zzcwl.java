package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcwl implements zzcyz, zzcyg {
    private final Context zza;
    private final zzfcr zzb;
    private final zzbta zzc;

    public zzcwl(Context context, zzfcr zzfcrVar, zzbta zzbtaVar) {
        this.zza = context;
        this.zzb = zzfcrVar;
        this.zzc = zzbtaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcyg
    public final void zzbn(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzcyg
    public final void zzbp(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzcyg
    public final void zzbq(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzcyz
    public final void zzr() {
        zzbtb zzbtbVar = this.zzb.zzaf;
        if (zzbtbVar == null || !zzbtbVar.zza) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.zzb.zzaf.zzb.isEmpty()) {
            return;
        }
        arrayList.add(this.zzb.zzaf.zzb);
    }
}
