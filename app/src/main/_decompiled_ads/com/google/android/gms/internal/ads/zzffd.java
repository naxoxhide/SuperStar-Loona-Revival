package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzffd {
    private final zzffc zza = new zzffc();
    private int zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;

    zzffd() {
    }

    public final zzffc zza() {
        zzffc zzffcVar = this.zza;
        zzffc zzffcVarClone = zzffcVar.clone();
        zzffcVar.zza = false;
        zzffcVar.zzb = false;
        return zzffcVarClone;
    }

    public final String zzb() {
        return "\n\tPool does not exist: " + this.zzd + "\n\tNew pools created: " + this.zzb + "\n\tPools removed: " + this.zzc + "\n\tEntries added: " + this.zzf + "\n\tNo entries retrieved: " + this.zze + "\n";
    }

    public final void zzc() {
        this.zzf++;
    }

    public final void zzd() {
        this.zzb++;
        this.zza.zza = true;
    }

    public final void zze() {
        this.zze++;
    }

    public final void zzf() {
        this.zzd++;
    }

    public final void zzg() {
        this.zzc++;
        this.zza.zzb = true;
    }
}
