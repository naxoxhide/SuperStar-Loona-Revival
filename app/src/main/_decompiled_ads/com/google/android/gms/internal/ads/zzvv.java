package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzvv extends zztk {
    private final zzbp zzd;

    public zzvv(zzcv zzcvVar, zzbp zzbpVar) {
        super(zzcvVar);
        this.zzd = zzbpVar;
    }

    @Override // com.google.android.gms.internal.ads.zztk, com.google.android.gms.internal.ads.zzcv
    public final zzcu zze(int i, zzcu zzcuVar, long j) {
        this.zzc.zze(i, zzcuVar, j);
        zzbp zzbpVar = this.zzd;
        zzcuVar.zze = zzbpVar;
        zzbi zzbiVar = zzbpVar.zzd;
        zzcuVar.zzd = null;
        return zzcuVar;
    }
}
