package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzadz extends zzady {
    private final zzfb zzb;
    private final zzfb zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    public zzadz(zzacs zzacsVar) {
        super(zzacsVar);
        this.zzb = new zzfb(zzfy.zza);
        this.zzc = new zzfb(4);
    }

    @Override // com.google.android.gms.internal.ads.zzady
    protected final boolean zza(zzfb zzfbVar) throws zzadx {
        int iZzl = zzfbVar.zzl();
        int i = iZzl >> 4;
        int i2 = iZzl & 15;
        if (i2 == 7) {
            this.zzg = i;
            return i != 5;
        }
        throw new zzadx("Video format not supported: " + i2);
    }

    @Override // com.google.android.gms.internal.ads.zzady
    protected final boolean zzb(zzfb zzfbVar, long j) throws zzcc {
        int iZzl = zzfbVar.zzl();
        long jZzg = zzfbVar.zzg();
        if (iZzl == 0) {
            if (!this.zze) {
                zzfb zzfbVar2 = new zzfb(new byte[zzfbVar.zza()]);
                zzfbVar.zzC(zzfbVar2.zzI(), 0, zzfbVar.zza());
                zzaar zzaarVarZza = zzaar.zza(zzfbVar2);
                this.zzd = zzaarVarZza.zzb;
                zzak zzakVar = new zzak();
                zzakVar.zzU("video/avc");
                zzakVar.zzz(zzaarVarZza.zzi);
                zzakVar.zzab(zzaarVarZza.zzc);
                zzakVar.zzH(zzaarVarZza.zzd);
                zzakVar.zzR(zzaarVarZza.zzh);
                zzakVar.zzK(zzaarVarZza.zza);
                this.zza.zzl(zzakVar.zzac());
                this.zze = true;
                return false;
            }
        } else if (iZzl == 1 && this.zze) {
            int i = this.zzg == 1 ? 1 : 0;
            if (!this.zzf && i == 0) {
                return false;
            }
            byte[] bArrZzI = this.zzc.zzI();
            bArrZzI[0] = 0;
            bArrZzI[1] = 0;
            bArrZzI[2] = 0;
            int i2 = 4 - this.zzd;
            int i3 = 0;
            while (zzfbVar.zza() > 0) {
                zzfbVar.zzC(this.zzc.zzI(), i2, this.zzd);
                this.zzc.zzG(0);
                zzfb zzfbVar3 = this.zzc;
                zzfb zzfbVar4 = this.zzb;
                int iZzo = zzfbVar3.zzo();
                zzfbVar4.zzG(0);
                this.zza.zzr(this.zzb, 4);
                this.zza.zzr(zzfbVar, iZzo);
                i3 = i3 + 4 + iZzo;
            }
            this.zza.zzt(j + (jZzg * 1000), i, i3, 0, null);
            this.zzf = true;
            return true;
        }
        return false;
    }
}
