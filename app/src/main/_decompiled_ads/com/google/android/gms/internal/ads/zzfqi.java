package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfqi extends zzfrb {
    private int zza;
    private String zzb;
    private byte zzc;

    zzfqi() {
    }

    @Override // com.google.android.gms.internal.ads.zzfrb
    public final zzfrb zza(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfrb
    public final zzfrb zzb(int i) {
        this.zza = i;
        this.zzc = (byte) 1;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfrb
    public final zzfrc zzc() {
        if (this.zzc == 1) {
            return new zzfqk(this.zza, this.zzb, null);
        }
        throw new IllegalStateException("Missing required properties: statusCode");
    }
}
