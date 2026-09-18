package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzajc implements zzaje {
    private final String zzb;
    private String zzc;
    private zzacs zzd;
    private int zzf;
    private int zzg;
    private long zzh;
    private zzam zzi;
    private int zzj;
    private final zzfb zza = new zzfb(new byte[18]);
    private int zze = 0;
    private long zzk = -9223372036854775807L;

    public zzajc(String str) {
        this.zzb = str;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:33:0x00f2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x00f4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:36:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:37:0x0105  */
    /* JADX WARN: Code duplicated, block: B:39:0x010f  */
    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zza(zzfb zzfbVar) {
        int i;
        int i2;
        byte b2;
        boolean z;
        int i3;
        int i4;
        byte b3;
        int i5;
        byte b4;
        int i6;
        zzdx.zzb(this.zzd);
        while (zzfbVar.zza() > 0) {
            int i7 = this.zze;
            if (i7 == 0) {
                while (zzfbVar.zza() > 0) {
                    int i8 = this.zzg << 8;
                    this.zzg = i8;
                    int iZzl = i8 | zzfbVar.zzl();
                    this.zzg = iZzl;
                    int i9 = zzabj.zza;
                    if (iZzl == 2147385345 || iZzl == -25230976 || iZzl == 536864768 || iZzl == -14745368) {
                        byte[] bArrZzI = this.zza.zzI();
                        int i10 = this.zzg;
                        bArrZzI[0] = (byte) ((i10 >> 24) & 255);
                        bArrZzI[1] = (byte) ((i10 >> 16) & 255);
                        bArrZzI[2] = (byte) ((i10 >> 8) & 255);
                        bArrZzI[3] = (byte) (i10 & 255);
                        this.zzf = 4;
                        this.zzg = 0;
                        this.zze = 1;
                        break;
                    }
                }
            } else if (i7 != 1) {
                int iMin = Math.min(zzfbVar.zza(), this.zzj - this.zzf);
                this.zzd.zzr(zzfbVar, iMin);
                int i11 = this.zzf + iMin;
                this.zzf = i11;
                int i12 = this.zzj;
                if (i11 == i12) {
                    long j = this.zzk;
                    if (j != -9223372036854775807L) {
                        this.zzd.zzt(j, 1, i12, 0, null);
                        this.zzk += this.zzh;
                    }
                    this.zze = 0;
                }
            } else {
                byte[] bArrZzI2 = this.zza.zzI();
                int iMin2 = Math.min(zzfbVar.zza(), 18 - this.zzf);
                zzfbVar.zzC(bArrZzI2, this.zzf, iMin2);
                int i13 = this.zzf + iMin2;
                this.zzf = i13;
                if (i13 == 18) {
                    byte[] bArrZzI3 = this.zza.zzI();
                    if (this.zzi == null) {
                        zzam zzamVarZza = zzabj.zza(bArrZzI3, this.zzc, this.zzb, null);
                        this.zzi = zzamVarZza;
                        this.zzd.zzl(zzamVarZza);
                    }
                    int i14 = zzabj.zza;
                    byte b5 = bArrZzI3[0];
                    if (b5 != -2) {
                        if (b5 == -1) {
                            i6 = ((bArrZzI3[7] & 3) << 12) | ((bArrZzI3[6] & 255) << 4) | ((bArrZzI3[9] & 60) >> 2);
                        } else if (b5 != 31) {
                            i = (bArrZzI3[5] & 3) << 12;
                            i2 = (bArrZzI3[6] & 255) << 4;
                            b2 = bArrZzI3[7];
                        } else {
                            i6 = ((bArrZzI3[8] & 60) >> 2) | ((3 & bArrZzI3[6]) << 12) | ((bArrZzI3[7] & 255) << 4);
                        }
                        i3 = i6 + 1;
                        z = true;
                        if (z) {
                            i3 = (i3 * 16) / 14;
                        }
                        this.zzj = i3;
                        if (b5 != -2) {
                            if (b5 != -1) {
                                i4 = (bArrZzI3[4] & 7) << 4;
                                b4 = bArrZzI3[7];
                            } else if (b5 != 31) {
                                i4 = (bArrZzI3[4] & 1) << 6;
                                b3 = bArrZzI3[5];
                            } else {
                                i4 = (bArrZzI3[5] & 7) << 4;
                                b4 = bArrZzI3[6];
                            }
                            i5 = b4 & 60;
                            this.zzh = (int) ((((long) ((((i5 >> 2) | i4) + 1) * 32)) * 1000000) / ((long) this.zzi.zzA));
                            this.zza.zzG(0);
                            this.zzd.zzr(this.zza, 18);
                            this.zze = 2;
                        } else {
                            i4 = (bArrZzI3[5] & 1) << 6;
                            b3 = bArrZzI3[4];
                        }
                        i5 = b3 & 252;
                        this.zzh = (int) ((((long) ((((i5 >> 2) | i4) + 1) * 32)) * 1000000) / ((long) this.zzi.zzA));
                        this.zza.zzG(0);
                        this.zzd.zzr(this.zza, 18);
                        this.zze = 2;
                    } else {
                        i = (bArrZzI3[4] & 3) << 12;
                        i2 = (bArrZzI3[7] & 255) << 4;
                        b2 = bArrZzI3[6];
                    }
                    i3 = (i | i2 | ((b2 & 240) >> 4)) + 1;
                    z = false;
                    if (z) {
                        i3 = (i3 * 16) / 14;
                    }
                    this.zzj = i3;
                    if (b5 != -2) {
                        if (b5 != -1) {
                            i4 = (bArrZzI3[4] & 7) << 4;
                            b4 = bArrZzI3[7];
                        } else if (b5 != 31) {
                            i4 = (bArrZzI3[4] & 1) << 6;
                            b3 = bArrZzI3[5];
                        } else {
                            i4 = (bArrZzI3[5] & 7) << 4;
                            b4 = bArrZzI3[6];
                        }
                        i5 = b4 & 60;
                        this.zzh = (int) ((((long) ((((i5 >> 2) | i4) + 1) * 32)) * 1000000) / ((long) this.zzi.zzA));
                        this.zza.zzG(0);
                        this.zzd.zzr(this.zza, 18);
                        this.zze = 2;
                    } else {
                        i4 = (bArrZzI3[5] & 1) << 6;
                        b3 = bArrZzI3[4];
                    }
                    i5 = b3 & 252;
                    this.zzh = (int) ((((long) ((((i5 >> 2) | i4) + 1) * 32)) * 1000000) / ((long) this.zzi.zzA));
                    this.zza.zzG(0);
                    this.zzd.zzr(this.zza, 18);
                    this.zze = 2;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzb(zzabp zzabpVar, zzakq zzakqVar) {
        zzakqVar.zzc();
        this.zzc = zzakqVar.zzb();
        this.zzd = zzabpVar.zzw(zzakqVar.zza(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzd(long j, int i) {
        if (j != -9223372036854775807L) {
            this.zzk = j;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zze() {
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzk = -9223372036854775807L;
    }
}
