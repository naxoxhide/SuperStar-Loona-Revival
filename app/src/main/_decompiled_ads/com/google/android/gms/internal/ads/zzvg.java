package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzvg implements zzxt {
    public long zza;
    public long zzb;
    public zzxs zzc;
    public zzvg zzd;

    public zzvg(long j, int i) {
        zze(j, 65536);
    }

    public final int zza(long j) {
        long j2 = j - this.zza;
        int i = this.zzc.zzb;
        return (int) j2;
    }

    public final zzvg zzb() {
        this.zzc = null;
        zzvg zzvgVar = this.zzd;
        this.zzd = null;
        return zzvgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxt
    public final zzxs zzc() {
        zzxs zzxsVar = this.zzc;
        Objects.requireNonNull(zzxsVar);
        return zzxsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxt
    public final zzxt zzd() {
        zzvg zzvgVar = this.zzd;
        if (zzvgVar == null || zzvgVar.zzc == null) {
            return null;
        }
        return zzvgVar;
    }

    public final void zze(long j, int i) {
        zzdx.zzf(this.zzc == null);
        this.zza = j;
        this.zzb = j + PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
    }
}
