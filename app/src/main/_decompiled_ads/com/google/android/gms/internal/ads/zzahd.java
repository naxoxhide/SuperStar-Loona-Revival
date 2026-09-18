package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzahd implements zzahb {
    private final int zza;
    private final int zzb;
    private final zzfb zzc;

    public zzahd(zzagx zzagxVar, zzam zzamVar) {
        zzfb zzfbVar = zzagxVar.zza;
        this.zzc = zzfbVar;
        zzfbVar.zzG(12);
        int iZzo = zzfbVar.zzo();
        if ("audio/raw".equals(zzamVar.zzm)) {
            int iZzl = zzfk.zzl(zzamVar.zzB, zzamVar.zzz);
            if (iZzo == 0 || iZzo % iZzl != 0) {
                zzer.zzf("AtomParsers", "Audio sample size mismatch. stsd sample size: " + iZzl + ", stsz sample size: " + iZzo);
                iZzo = iZzl;
            }
        }
        this.zza = iZzo == 0 ? -1 : iZzo;
        this.zzb = zzfbVar.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final int zzc() {
        int i = this.zza;
        return i == -1 ? this.zzc.zzo() : i;
    }
}
