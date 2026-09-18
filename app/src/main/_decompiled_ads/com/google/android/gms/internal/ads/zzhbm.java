package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhbm {
    private final List zza;
    private final List zzb;

    /* synthetic */ zzhbm(int i, int i2, zzhbl zzhblVar) {
        this.zza = zzhaz.zzc(i);
        this.zzb = zzhaz.zzc(i2);
    }

    public final zzhbm zza(zzhbp zzhbpVar) {
        this.zzb.add(zzhbpVar);
        return this;
    }

    public final zzhbm zzb(zzhbp zzhbpVar) {
        this.zza.add(zzhbpVar);
        return this;
    }

    public final zzhbn zzc() {
        return new zzhbn(this.zza, this.zzb, null);
    }
}
