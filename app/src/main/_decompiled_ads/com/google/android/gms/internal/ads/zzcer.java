package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcer extends zzcen {
    public zzcer(zzcdc zzcdcVar) {
        super(zzcdcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcen
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzcen
    public final boolean zzt(String str) {
        String strZze = zzcam.zze(str);
        zzcdc zzcdcVar = (zzcdc) this.zzc.get();
        if (zzcdcVar != null && strZze != null) {
            zzcdcVar.zzt(strZze, this);
        }
        zzcat.zzj("VideoStreamNoopCache is doing nothing.");
        zzg(str, strZze, "noop", "Noop cache is a noop.");
        return false;
    }
}
