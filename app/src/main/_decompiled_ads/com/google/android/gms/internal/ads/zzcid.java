package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcid implements zzhbc {
    private final zzchz zza;

    public zzcid(zzchz zzchzVar) {
        this.zza = zzchzVar;
    }

    public final WeakReference zza() {
        WeakReference weakReferenceZzf = this.zza.zzf();
        zzhbk.zzb(weakReferenceZzf);
        return weakReferenceZzf;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* synthetic */ Object zzb() {
        WeakReference weakReferenceZzf = this.zza.zzf();
        zzhbk.zzb(weakReferenceZzf);
        return weakReferenceZzf;
    }
}
