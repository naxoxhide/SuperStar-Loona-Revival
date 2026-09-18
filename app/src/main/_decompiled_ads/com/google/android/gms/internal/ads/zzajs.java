package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzajs implements zzaje {
    private final zzfb zza;
    private final zzacg zzb;
    private final String zzc;
    private zzacs zzd;
    private String zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private boolean zzi;
    private long zzj;
    private int zzk;
    private long zzl;

    public zzajs() {
        this(null);
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zza(zzfb zzfbVar) {
        zzdx.zzb(this.zzd);
        while (zzfbVar.zza() > 0) {
            int i = this.zzf;
            if (i == 0) {
                byte[] bArrZzI = zzfbVar.zzI();
                int iZzc = zzfbVar.zzc();
                int iZzd = zzfbVar.zzd();
                while (true) {
                    if (iZzc >= iZzd) {
                        zzfbVar.zzG(iZzd);
                        break;
                    }
                    int i2 = iZzc + 1;
                    byte b2 = bArrZzI[iZzc];
                    boolean z = (b2 & 255) == 255;
                    boolean z2 = this.zzi && (b2 & 224) == 224;
                    this.zzi = z;
                    if (z2) {
                        zzfbVar.zzG(i2);
                        this.zzi = false;
                        this.zza.zzI()[1] = bArrZzI[iZzc];
                        this.zzg = 2;
                        this.zzf = 1;
                        break;
                    }
                    iZzc = i2;
                }
            } else if (i != 1) {
                int iMin = Math.min(zzfbVar.zza(), this.zzk - this.zzg);
                this.zzd.zzr(zzfbVar, iMin);
                int i3 = this.zzg + iMin;
                this.zzg = i3;
                int i4 = this.zzk;
                if (i3 >= i4) {
                    long j = this.zzl;
                    if (j != -9223372036854775807L) {
                        this.zzd.zzt(j, 1, i4, 0, null);
                        this.zzl += this.zzj;
                    }
                    this.zzg = 0;
                    this.zzf = 0;
                }
            } else {
                int iMin2 = Math.min(zzfbVar.zza(), 4 - this.zzg);
                zzfbVar.zzC(this.zza.zzI(), this.zzg, iMin2);
                int i5 = this.zzg + iMin2;
                this.zzg = i5;
                if (i5 >= 4) {
                    this.zza.zzG(0);
                    if (this.zzb.zza(this.zza.zzf())) {
                        zzacg zzacgVar = this.zzb;
                        this.zzk = zzacgVar.zzc;
                        if (!this.zzh) {
                            this.zzj = (((long) zzacgVar.zzg) * 1000000) / ((long) zzacgVar.zzd);
                            zzak zzakVar = new zzak();
                            zzakVar.zzJ(this.zze);
                            zzakVar.zzU(this.zzb.zzb);
                            zzakVar.zzN(4096);
                            zzakVar.zzy(this.zzb.zze);
                            zzakVar.zzV(this.zzb.zzd);
                            zzakVar.zzM(this.zzc);
                            this.zzd.zzl(zzakVar.zzac());
                            this.zzh = true;
                        }
                        this.zza.zzG(0);
                        this.zzd.zzr(this.zza, 4);
                        this.zzf = 2;
                    } else {
                        this.zzg = 0;
                        this.zzf = 1;
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzb(zzabp zzabpVar, zzakq zzakqVar) {
        zzakqVar.zzc();
        this.zze = zzakqVar.zzb();
        this.zzd = zzabpVar.zzw(zzakqVar.zza(), 1);
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
        this.zzi = false;
        this.zzl = -9223372036854775807L;
    }

    public zzajs(String str) {
        this.zzf = 0;
        zzfb zzfbVar = new zzfb(4);
        this.zza = zzfbVar;
        zzfbVar.zzI()[0] = -1;
        this.zzb = new zzacg();
        this.zzl = -9223372036854775807L;
        this.zzc = str;
    }
}
