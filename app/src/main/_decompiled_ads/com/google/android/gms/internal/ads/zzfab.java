package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfab implements zzfsk {
    final /* synthetic */ zzfae zza;

    zzfab(zzfae zzfaeVar) {
        this.zza = zzfaeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfsk
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzbvg zzbvgVar = (zzbvg) obj;
        this.zza.zzd = new zzfad(zzbvgVar, new zzffm(zzbvgVar.zzj), null);
        return this.zza.zzd;
    }
}
