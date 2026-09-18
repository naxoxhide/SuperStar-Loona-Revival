package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfku {
    private static final zzfku zza = new zzfku();
    private final ArrayList zzb = new ArrayList();
    private final ArrayList zzc = new ArrayList();

    private zzfku() {
    }

    public static zzfku zza() {
        return zza;
    }

    public final Collection zzb() {
        return Collections.unmodifiableCollection(this.zzc);
    }

    public final Collection zzc() {
        return Collections.unmodifiableCollection(this.zzb);
    }

    public final void zzd(zzfkg zzfkgVar) {
        this.zzb.add(zzfkgVar);
    }

    public final void zze(zzfkg zzfkgVar) {
        ArrayList arrayList = this.zzb;
        boolean zZzg = zzg();
        arrayList.remove(zzfkgVar);
        this.zzc.remove(zzfkgVar);
        if (!zZzg || zzg()) {
            return;
        }
        zzflb.zzb().zzg();
    }

    public final void zzf(zzfkg zzfkgVar) {
        ArrayList arrayList = this.zzc;
        boolean zZzg = zzg();
        arrayList.add(zzfkgVar);
        if (zZzg) {
            return;
        }
        zzflb.zzb().zzf();
    }

    public final boolean zzg() {
        return this.zzc.size() > 0;
    }
}
