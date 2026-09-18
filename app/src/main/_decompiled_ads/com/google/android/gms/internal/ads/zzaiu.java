package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaiu implements zzaje {
    private final zzfa zza;
    private final zzfb zzb;
    private final String zzc;
    private String zzd;
    private zzacs zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private long zzi;
    private zzam zzj;
    private int zzk;
    private long zzl;

    public zzaiu() {
        this(null);
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zza(zzfb zzfbVar) {
        zzdx.zzb(this.zze);
        while (zzfbVar.zza() > 0) {
            int i = this.zzf;
            if (i == 0) {
                while (zzfbVar.zza() > 0) {
                    if (this.zzh) {
                        int iZzl = zzfbVar.zzl();
                        if (iZzl == 119) {
                            this.zzh = false;
                            this.zzf = 1;
                            zzfb zzfbVar2 = this.zzb;
                            zzfbVar2.zzI()[0] = 11;
                            zzfbVar2.zzI()[1] = 119;
                            this.zzg = 2;
                            break;
                        }
                        this.zzh = iZzl == 11;
                    } else {
                        this.zzh = zzfbVar.zzl() == 11;
                    }
                }
            } else if (i != 1) {
                int iMin = Math.min(zzfbVar.zza(), this.zzk - this.zzg);
                this.zze.zzr(zzfbVar, iMin);
                int i2 = this.zzg + iMin;
                this.zzg = i2;
                int i3 = this.zzk;
                if (i2 == i3) {
                    long j = this.zzl;
                    if (j != -9223372036854775807L) {
                        this.zze.zzt(j, 1, i3, 0, null);
                        this.zzl += this.zzi;
                    }
                    this.zzf = 0;
                }
            } else {
                byte[] bArrZzI = this.zzb.zzI();
                int iMin2 = Math.min(zzfbVar.zza(), 128 - this.zzg);
                zzfbVar.zzC(bArrZzI, this.zzg, iMin2);
                int i4 = this.zzg + iMin2;
                this.zzg = i4;
                if (i4 == 128) {
                    this.zza.zzj(0);
                    zzaam zzaamVarZze = zzaan.zze(this.zza);
                    zzam zzamVar = this.zzj;
                    if (zzamVar == null || zzaamVarZze.zzc != zzamVar.zzz || zzaamVarZze.zzb != zzamVar.zzA || !zzfk.zzE(zzaamVarZze.zza, zzamVar.zzm)) {
                        zzak zzakVar = new zzak();
                        zzakVar.zzJ(this.zzd);
                        zzakVar.zzU(zzaamVarZze.zza);
                        zzakVar.zzy(zzaamVarZze.zzc);
                        zzakVar.zzV(zzaamVarZze.zzb);
                        zzakVar.zzM(this.zzc);
                        zzakVar.zzQ(zzaamVarZze.zzf);
                        if ("audio/ac3".equals(zzaamVarZze.zza)) {
                            zzakVar.zzx(zzaamVarZze.zzf);
                        }
                        zzam zzamVarZzac = zzakVar.zzac();
                        this.zzj = zzamVarZzac;
                        this.zze.zzl(zzamVarZzac);
                    }
                    this.zzk = zzaamVarZze.zzd;
                    this.zzi = (((long) zzaamVarZze.zze) * 1000000) / ((long) this.zzj.zzA);
                    this.zzb.zzG(0);
                    this.zze.zzr(this.zzb, 128);
                    this.zzf = 2;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzb(zzabp zzabpVar, zzakq zzakqVar) {
        zzakqVar.zzc();
        this.zzd = zzakqVar.zzb();
        this.zze = zzabpVar.zzw(zzakqVar.zza(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzd(long j, int i) {
        if (j != -9223372036854775807L) {
            this.zzl = j;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zze() {
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = false;
        this.zzl = -9223372036854775807L;
    }

    public zzaiu(String str) {
        zzfa zzfaVar = new zzfa(new byte[128], 128);
        this.zza = zzfaVar;
        this.zzb = new zzfb(zzfaVar.zza);
        this.zzf = 0;
        this.zzl = -9223372036854775807L;
        this.zzc = str;
    }
}
