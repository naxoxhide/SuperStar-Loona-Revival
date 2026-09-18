package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaja implements zzaje {
    private static final byte[] zza = {73, 68, 51};
    private final boolean zzb;
    private final zzfa zzc = new zzfa(new byte[7], 7);
    private final zzfb zzd = new zzfb(Arrays.copyOf(zza, 10));
    private final String zze;
    private String zzf;
    private zzacs zzg;
    private zzacs zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private boolean zzl;
    private boolean zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;
    private long zzr;
    private int zzs;
    private long zzt;
    private zzacs zzu;
    private long zzv;

    public zzaja(boolean z, String str) {
        zzh();
        this.zzn = -1;
        this.zzo = -1;
        this.zzr = -9223372036854775807L;
        this.zzt = -9223372036854775807L;
        this.zzb = z;
        this.zze = str;
    }

    public static boolean zzf(int i) {
        return (i & 65526) == 65520;
    }

    private final void zzg() {
        this.zzm = false;
        zzh();
    }

    private final void zzh() {
        this.zzi = 0;
        this.zzj = 0;
        this.zzk = 256;
    }

    private final void zzi() {
        this.zzi = 3;
        this.zzj = 0;
    }

    private final void zzj(zzacs zzacsVar, long j, int i, int i2) {
        this.zzi = 4;
        this.zzj = i;
        this.zzu = zzacsVar;
        this.zzv = j;
        this.zzs = i2;
    }

    private final boolean zzk(zzfb zzfbVar, byte[] bArr, int i) {
        int iMin = Math.min(zzfbVar.zza(), i - this.zzj);
        zzfbVar.zzC(bArr, this.zzj, iMin);
        int i2 = this.zzj + iMin;
        this.zzj = i2;
        return i2 == i;
    }

    private static final boolean zzl(byte b2, byte b3) {
        return zzf((b3 & 255) | MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }

    private static final boolean zzm(zzfb zzfbVar, byte[] bArr, int i) {
        if (zzfbVar.zza() < i) {
            return false;
        }
        zzfbVar.zzC(bArr, 0, i);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0279  */
    /* JADX WARN: Code duplicated, block: B:107:0x027d  */
    /* JADX WARN: Code duplicated, block: B:109:0x0281  */
    /* JADX WARN: Code duplicated, block: B:111:0x0285  */
    /* JADX WARN: Code duplicated, block: B:140:0x0296 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:143:0x0250 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:144:0x0250 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:0x0250 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:163:0x02b2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:164:0x02ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x02a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x0293 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x0289 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0208  */
    /* JADX WARN: Code duplicated, block: B:73:0x0217  */
    /* JADX WARN: Code duplicated, block: B:75:0x0222  */
    /* JADX WARN: Code duplicated, block: B:77:0x0226  */
    /* JADX WARN: Code duplicated, block: B:79:0x022a  */
    /* JADX WARN: Code duplicated, block: B:84:0x0238  */
    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zza(zzfb zzfbVar) throws zzcc {
        int i;
        int i2;
        int i3;
        int i4;
        int iZzd;
        byte[] bArrZzI;
        int iZzd2;
        int i5;
        byte b2;
        int i6;
        int i7;
        int i8;
        byte b3;
        Objects.requireNonNull(this.zzg);
        int i9 = zzfk.zza;
        while (zzfbVar.zza() > 0) {
            int i10 = this.zzi;
            int i11 = 13;
            int i12 = 2;
            if (i10 == 0) {
                byte[] bArrZzI2 = zzfbVar.zzI();
                int iZzc = zzfbVar.zzc();
                int iZzd3 = zzfbVar.zzd();
                while (true) {
                    if (iZzc < iZzd3) {
                        int i13 = iZzc + 1;
                        int i14 = bArrZzI2[iZzc] & 255;
                        if (this.zzk == 512 && zzl((byte) -1, (byte) i14)) {
                            if (!this.zzm) {
                                int i15 = i13 - 2;
                                zzfbVar.zzG(i15 + 1);
                                if (zzm(zzfbVar, this.zzc.zza, 1)) {
                                    this.zzc.zzj(4);
                                    int iZzd4 = this.zzc.zzd(1);
                                    int i16 = this.zzn;
                                    if (i16 == -1 || iZzd4 == i16) {
                                        if (this.zzo == -1) {
                                            if (zzm(zzfbVar, this.zzc.zza, 4)) {
                                                this.zzc.zzj(14);
                                                iZzd = this.zzc.zzd(i11);
                                                if (iZzd >= 7) {
                                                    bArrZzI = zzfbVar.zzI();
                                                    iZzd2 = zzfbVar.zzd();
                                                    i5 = i15 + iZzd;
                                                    if (i5 >= iZzd2) {
                                                        b2 = bArrZzI[i5];
                                                        if (b2 == -1) {
                                                            i8 = i5 + 1;
                                                            if (i8 != iZzd2) {
                                                                b3 = bArrZzI[i8];
                                                                if (zzl((byte) -1, b3) || ((b3 & 8) >> 3) != iZzd4) {
                                                                }
                                                            }
                                                        } else if (b2 == 73 || ((i6 = i5 + 1) != iZzd2 && (bArrZzI[i6] != 68 || ((i7 = i5 + 2) != iZzd2 && bArrZzI[i7] != 51)))) {
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (zzm(zzfbVar, this.zzc.zza, 1)) {
                                            this.zzc.zzj(i12);
                                            if (this.zzc.zzd(4) == this.zzo) {
                                                zzfbVar.zzG(i15 + 2);
                                                if (zzm(zzfbVar, this.zzc.zza, 4)) {
                                                    this.zzc.zzj(14);
                                                    iZzd = this.zzc.zzd(i11);
                                                    if (iZzd >= 7) {
                                                        bArrZzI = zzfbVar.zzI();
                                                        iZzd2 = zzfbVar.zzd();
                                                        i5 = i15 + iZzd;
                                                        if (i5 >= iZzd2) {
                                                            b2 = bArrZzI[i5];
                                                            if (b2 == -1) {
                                                                i8 = i5 + 1;
                                                                if (i8 != iZzd2) {
                                                                    b3 = bArrZzI[i8];
                                                                    if (zzl((byte) -1, b3)) {
                                                                    }
                                                                }
                                                            } else if (b2 == 73) {
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                i = this.zzk;
                                i2 = i | i14;
                                if (i2 != 329) {
                                    i3 = 2;
                                    i4 = 768;
                                } else if (i2 != 511) {
                                    i3 = 2;
                                    i4 = 512;
                                } else if (i2 != 836) {
                                    i3 = 2;
                                    i4 = 1024;
                                } else if (i2 != 1075) {
                                    this.zzi = 2;
                                    this.zzj = 3;
                                    this.zzs = 0;
                                    this.zzd.zzG(0);
                                    zzfbVar.zzG(i13);
                                } else if (i != 256) {
                                    this.zzk = 256;
                                    iZzc = i13 - 1;
                                    i11 = 13;
                                    i12 = 2;
                                } else {
                                    i3 = 2;
                                    i12 = i3;
                                    iZzc = i13;
                                    i11 = 13;
                                }
                                this.zzk = i4;
                                i12 = i3;
                                iZzc = i13;
                                i11 = 13;
                            }
                            this.zzp = (i14 & 8) >> 3;
                            this.zzl = 1 == ((i14 & 1) ^ 1);
                            if (this.zzm) {
                                zzi();
                            } else {
                                this.zzi = 1;
                                this.zzj = 0;
                            }
                            zzfbVar.zzG(i13);
                        } else {
                            i = this.zzk;
                            i2 = i | i14;
                            if (i2 != 329) {
                                i3 = 2;
                                i4 = 768;
                            } else if (i2 != 511) {
                                i3 = 2;
                                i4 = 512;
                            } else if (i2 != 836) {
                                i3 = 2;
                                i4 = 1024;
                            } else if (i2 != 1075) {
                                this.zzi = 2;
                                this.zzj = 3;
                                this.zzs = 0;
                                this.zzd.zzG(0);
                                zzfbVar.zzG(i13);
                            } else if (i != 256) {
                                this.zzk = 256;
                                iZzc = i13 - 1;
                                i11 = 13;
                                i12 = 2;
                            } else {
                                i3 = 2;
                                i12 = i3;
                                iZzc = i13;
                                i11 = 13;
                            }
                            this.zzk = i4;
                            i12 = i3;
                            iZzc = i13;
                            i11 = 13;
                        }
                    } else {
                        zzfbVar.zzG(iZzc);
                    }
                }
            } else if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        int iMin = Math.min(zzfbVar.zza(), this.zzs - this.zzj);
                        this.zzu.zzr(zzfbVar, iMin);
                        int i17 = this.zzj + iMin;
                        this.zzj = i17;
                        int i18 = this.zzs;
                        if (i17 == i18) {
                            long j = this.zzt;
                            if (j != -9223372036854775807L) {
                                this.zzu.zzt(j, 1, i18, 0, null);
                                this.zzt += this.zzv;
                            }
                            zzh();
                        }
                    } else {
                        if (zzk(zzfbVar, this.zzc.zza, true != this.zzl ? 5 : 7)) {
                            this.zzc.zzj(0);
                            if (this.zzq) {
                                this.zzc.zzl(10);
                            } else {
                                int iZzd5 = this.zzc.zzd(2) + 1;
                                if (iZzd5 != 2) {
                                    zzer.zzf("AdtsReader", "Detected audio object type: " + iZzd5 + ", but assuming AAC LC.");
                                }
                                this.zzc.zzl(5);
                                int iZzd6 = this.zzc.zzd(3);
                                int i19 = this.zzo;
                                int i20 = zzaak.zza;
                                byte[] bArr = {(byte) (((i19 >> 1) & 7) | 16), (byte) (((iZzd6 << 3) & 120) | ((i19 << 7) & 128))};
                                zzaaj zzaajVarZza = zzaak.zza(bArr);
                                zzak zzakVar = new zzak();
                                zzakVar.zzJ(this.zzf);
                                zzakVar.zzU("audio/mp4a-latm");
                                zzakVar.zzz(zzaajVarZza.zzc);
                                zzakVar.zzy(zzaajVarZza.zzb);
                                zzakVar.zzV(zzaajVarZza.zza);
                                zzakVar.zzK(Collections.singletonList(bArr));
                                zzakVar.zzM(this.zze);
                                zzam zzamVarZzac = zzakVar.zzac();
                                this.zzr = 1024000000 / ((long) zzamVarZzac.zzA);
                                this.zzg.zzl(zzamVarZzac);
                                this.zzq = true;
                            }
                            this.zzc.zzl(4);
                            int iZzd7 = this.zzc.zzd(13) - 7;
                            if (this.zzl) {
                                iZzd7 -= 2;
                            }
                            zzj(this.zzg, this.zzr, 0, iZzd7);
                        }
                    }
                } else if (zzk(zzfbVar, this.zzd.zzI(), 10)) {
                    this.zzh.zzr(this.zzd, 10);
                    this.zzd.zzG(6);
                    zzj(this.zzh, 0L, 10, 10 + this.zzd.zzk());
                }
            } else if (zzfbVar.zza() != 0) {
                zzfa zzfaVar = this.zzc;
                zzfaVar.zza[0] = zzfbVar.zzI()[zzfbVar.zzc()];
                zzfaVar.zzj(2);
                int iZzd8 = this.zzc.zzd(4);
                int i21 = this.zzo;
                if (i21 == -1 || iZzd8 == i21) {
                    if (!this.zzm) {
                        this.zzm = true;
                        this.zzn = this.zzp;
                        this.zzo = iZzd8;
                    }
                    zzi();
                } else {
                    zzg();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzb(zzabp zzabpVar, zzakq zzakqVar) {
        zzakqVar.zzc();
        this.zzf = zzakqVar.zzb();
        zzacs zzacsVarZzw = zzabpVar.zzw(zzakqVar.zza(), 1);
        this.zzg = zzacsVarZzw;
        this.zzu = zzacsVarZzw;
        if (!this.zzb) {
            this.zzh = new zzabl();
            return;
        }
        zzakqVar.zzc();
        zzacs zzacsVarZzw2 = zzabpVar.zzw(zzakqVar.zza(), 5);
        this.zzh = zzacsVarZzw2;
        zzak zzakVar = new zzak();
        zzakVar.zzJ(zzakqVar.zzb());
        zzakVar.zzU("application/id3");
        zzacsVarZzw2.zzl(zzakVar.zzac());
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzd(long j, int i) {
        if (j != -9223372036854775807L) {
            this.zzt = j;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zze() {
        this.zzt = -9223372036854775807L;
        zzg();
    }
}
