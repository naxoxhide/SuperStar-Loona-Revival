package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfvq extends zzfts {
    private final zzfvs zza;

    zzfvq(zzfvs zzfvsVar, int i) {
        super(zzfvsVar.size(), i);
        this.zza = zzfvsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfts
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
