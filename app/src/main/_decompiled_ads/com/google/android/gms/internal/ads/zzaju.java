package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaju implements zzakd {
    private zzam zza;
    private zzfi zzb;
    private zzacs zzc;

    public zzaju(String str) {
        zzak zzakVar = new zzak();
        zzakVar.zzU(str);
        this.zza = zzakVar.zzac();
    }

    @Override // com.google.android.gms.internal.ads.zzakd
    public final void zza(zzfb zzfbVar) {
        zzdx.zzb(this.zzb);
        int i = zzfk.zza;
        long jZzd = this.zzb.zzd();
        long jZze = this.zzb.zze();
        if (jZzd == -9223372036854775807L || jZze == -9223372036854775807L) {
            return;
        }
        zzam zzamVar = this.zza;
        if (jZze != zzamVar.zzq) {
            zzak zzakVarZzb = zzamVar.zzb();
            zzakVarZzb.zzY(jZze);
            zzam zzamVarZzac = zzakVarZzb.zzac();
            this.zza = zzamVarZzac;
            this.zzc.zzl(zzamVarZzac);
        }
        int iZza = zzfbVar.zza();
        this.zzc.zzr(zzfbVar, iZza);
        this.zzc.zzt(jZzd, 1, iZza, 0, null);
    }

    @Override // com.google.android.gms.internal.ads.zzakd
    public final void zzb(zzfi zzfiVar, zzabp zzabpVar, zzakq zzakqVar) {
        this.zzb = zzfiVar;
        zzakqVar.zzc();
        zzacs zzacsVarZzw = zzabpVar.zzw(zzakqVar.zza(), 5);
        this.zzc = zzacsVarZzw;
        zzacsVarZzw.zzl(this.zza);
    }
}
