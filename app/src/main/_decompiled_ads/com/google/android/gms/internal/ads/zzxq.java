package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzxq {
    private zzxp zza;
    private zzxy zzb;

    public zzls zzc() {
        throw null;
    }

    public void zzi() {
        this.zza = null;
        this.zzb = null;
    }

    public void zzj(zzk zzkVar) {
        throw null;
    }

    public boolean zzm() {
        throw null;
    }

    public abstract zzxr zzo(zzlt[] zzltVarArr, zzvx zzvxVar, zztw zztwVar, zzcv zzcvVar) throws zzil;

    public abstract void zzp(Object obj);

    protected final zzxy zzq() {
        zzxy zzxyVar = this.zzb;
        zzdx.zzb(zzxyVar);
        return zzxyVar;
    }

    public final void zzr(zzxp zzxpVar, zzxy zzxyVar) {
        this.zza = zzxpVar;
        this.zzb = zzxyVar;
    }

    protected final void zzs() {
        zzxp zzxpVar = this.zza;
        if (zzxpVar != null) {
            zzxpVar.zzj();
        }
    }
}
