package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcko {
    private zzchz zza;
    private zzcmb zzb;
    private zzfhv zzc;
    private zzcmn zzd;
    private zzfep zze;

    private zzcko() {
    }

    /* synthetic */ zzcko(zzckn zzcknVar) {
    }

    public final zzchw zza() {
        zzhbk.zzc(this.zza, zzchz.class);
        zzhbk.zzc(this.zzb, zzcmb.class);
        if (this.zzc == null) {
            this.zzc = new zzfhv();
        }
        if (this.zzd == null) {
            this.zzd = new zzcmn();
        }
        if (this.zze == null) {
            this.zze = new zzfep();
        }
        return new zzcjs(this.zza, this.zzb, this.zzc, this.zzd, this.zze, null);
    }

    public final zzcko zzb(zzchz zzchzVar) {
        this.zza = zzchzVar;
        return this;
    }

    public final zzcko zzc(zzcmb zzcmbVar) {
        this.zzb = zzcmbVar;
        return this;
    }
}
