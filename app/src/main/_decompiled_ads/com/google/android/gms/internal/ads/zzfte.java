package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfte extends zzfth {
    final /* synthetic */ zzftf zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfte(zzftf zzftfVar, zzftj zzftjVar, CharSequence charSequence) {
        super(zzftjVar, charSequence);
        this.zza = zzftfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfth
    public final int zzc(int i) {
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzfth
    public final int zzd(int i) {
        int i2 = i + 4000;
        if (i2 < this.zzb.length()) {
            return i2;
        }
        return -1;
    }
}
