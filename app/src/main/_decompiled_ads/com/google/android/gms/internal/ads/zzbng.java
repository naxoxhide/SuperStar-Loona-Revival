package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbng extends zzcbs {
    private final Object zza = new Object();
    private final zzbnl zzb;
    private boolean zzc;

    public zzbng(zzbnl zzbnlVar) {
        this.zzb = zzbnlVar;
    }

    public final void zzb() {
        synchronized (this.zza) {
            if (this.zzc) {
                return;
            }
            this.zzc = true;
            zzi(new zzbnd(this), new zzcbo());
            zzi(new zzbne(this), new zzbnf(this));
        }
    }
}
