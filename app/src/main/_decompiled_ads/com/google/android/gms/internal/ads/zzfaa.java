package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfaa implements zzfsk {
    final /* synthetic */ zzfae zza;

    zzfaa(zzfae zzfaeVar) {
        this.zza = zzfaeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfsk
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzcat.zzh("", (zzdyo) obj);
        com.google.android.gms.ads.internal.util.zze.zza("Failed to get a cache key, reverting to legacy flow.");
        zzfae zzfaeVar = this.zza;
        zzfaeVar.zzd = new zzfad(null, zzfaeVar.zze(), null);
        return this.zza.zzd;
    }
}
