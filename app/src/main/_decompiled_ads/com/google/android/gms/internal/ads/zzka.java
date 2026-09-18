package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzka implements zzky {
    private final Object zza;
    private final zzty zzb;
    private zzcv zzc;

    public zzka(Object obj, zztr zztrVar) {
        this.zza = obj;
        this.zzb = zztrVar;
        this.zzc = zztrVar.zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzky
    public final zzcv zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzky
    public final Object zzb() {
        return this.zza;
    }

    public final void zzc(zzcv zzcvVar) {
        this.zzc = zzcvVar;
    }
}
