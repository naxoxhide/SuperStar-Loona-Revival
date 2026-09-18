package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaef implements zzabp {
    private final long zzb;
    private final zzabp zzc;

    public zzaef(long j, zzabp zzabpVar) {
        this.zzb = j;
        this.zzc = zzabpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabp
    public final void zzD() {
        this.zzc.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzabp
    public final void zzO(zzacm zzacmVar) {
        this.zzc.zzO(new zzaee(this, zzacmVar, zzacmVar));
    }

    @Override // com.google.android.gms.internal.ads.zzabp
    public final zzacs zzw(int i, int i2) {
        return this.zzc.zzw(i, i2);
    }
}
