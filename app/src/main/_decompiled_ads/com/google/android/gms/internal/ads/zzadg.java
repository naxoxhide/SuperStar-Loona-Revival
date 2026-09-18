package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzadg implements zzadb {
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzadg(int i, int i2, int i3, int i4) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    public static zzadg zzb(zzfb zzfbVar) {
        int iZzh = zzfbVar.zzh();
        zzfbVar.zzH(8);
        int iZzh2 = zzfbVar.zzh();
        int iZzh3 = zzfbVar.zzh();
        zzfbVar.zzH(4);
        int iZzh4 = zzfbVar.zzh();
        zzfbVar.zzH(12);
        return new zzadg(iZzh, iZzh2, iZzh3, iZzh4);
    }

    @Override // com.google.android.gms.internal.ads.zzadb
    public final int zza() {
        return 1751742049;
    }
}
