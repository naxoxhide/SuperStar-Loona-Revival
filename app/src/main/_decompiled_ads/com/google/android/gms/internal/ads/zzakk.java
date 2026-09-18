package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzakk implements zzakd {
    final /* synthetic */ zzakm zza;
    private final zzfa zzb = new zzfa(new byte[4], 4);

    public zzakk(zzakm zzakmVar) {
        this.zza = zzakmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzakd
    public final void zza(zzfb zzfbVar) {
        if (zzfbVar.zzl() == 0 && (zzfbVar.zzl() & 128) != 0) {
            zzfbVar.zzH(6);
            int iZza = zzfbVar.zza() / 4;
            for (int i = 0; i < iZza; i++) {
                zzfbVar.zzB(this.zzb, 4);
                zzfa zzfaVar = this.zzb;
                int iZzd = zzfaVar.zzd(16);
                zzfaVar.zzl(3);
                if (iZzd == 0) {
                    this.zzb.zzl(13);
                } else {
                    int iZzd2 = this.zzb.zzd(13);
                    if (this.zza.zzf.get(iZzd2) == null) {
                        zzakm zzakmVar = this.zza;
                        zzakmVar.zzf.put(iZzd2, new zzake(new zzakl(zzakmVar, iZzd2)));
                        this.zza.zzl++;
                    }
                }
            }
            this.zza.zzf.remove(0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzakd
    public final void zzb(zzfi zzfiVar, zzabp zzabpVar, zzakq zzakqVar) {
    }
}
