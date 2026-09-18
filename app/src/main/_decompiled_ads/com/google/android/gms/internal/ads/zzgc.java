package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgc implements zzgi {
    private final boolean zza;
    private final ArrayList zzb = new ArrayList(1);
    private int zzc;
    private zzgn zzd;

    protected zzgc(boolean z) {
        this.zza = z;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public /* synthetic */ Map zze() {
        return Collections.emptyMap();
    }

    protected final void zzg(int i) {
        zzgn zzgnVar = this.zzd;
        int i2 = zzfk.zza;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            ((zzhk) this.zzb.get(i3)).zza(this, zzgnVar, this.zza, i);
        }
    }

    protected final void zzh() {
        zzgn zzgnVar = this.zzd;
        int i = zzfk.zza;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            ((zzhk) this.zzb.get(i2)).zzb(this, zzgnVar, this.zza);
        }
        this.zzd = null;
    }

    protected final void zzi(zzgn zzgnVar) {
        for (int i = 0; i < this.zzc; i++) {
            ((zzhk) this.zzb.get(i)).zzc(this, zzgnVar, this.zza);
        }
    }

    protected final void zzj(zzgn zzgnVar) {
        this.zzd = zzgnVar;
        for (int i = 0; i < this.zzc; i++) {
            ((zzhk) this.zzb.get(i)).zzd(this, zzgnVar, this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final void zzf(zzhk zzhkVar) {
        Objects.requireNonNull(zzhkVar);
        if (this.zzb.contains(zzhkVar)) {
            return;
        }
        this.zzb.add(zzhkVar);
        this.zzc++;
    }
}
