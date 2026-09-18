package com.google.android.gms.internal.ads;

import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzajr implements zzaje {
    private final String zza;
    private final zzfb zzb;
    private final zzfa zzc;
    private zzacs zzd;
    private String zze;
    private zzam zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private long zzk;
    private boolean zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private boolean zzp;
    private long zzq;
    private int zzr;
    private long zzs;
    private int zzt;
    private String zzu;

    public zzajr(String str) {
        this.zza = str;
        zzfb zzfbVar = new zzfb(1024);
        this.zzb = zzfbVar;
        byte[] bArrZzI = zzfbVar.zzI();
        this.zzc = new zzfa(bArrZzI, bArrZzI.length);
        this.zzk = -9223372036854775807L;
    }

    private final int zzf(zzfa zzfaVar) throws zzcc {
        int iZza = zzfaVar.zza();
        zzaaj zzaajVarZzb = zzaak.zzb(zzfaVar, true);
        this.zzu = zzaajVarZzb.zzc;
        this.zzr = zzaajVarZzb.zza;
        this.zzt = zzaajVarZzb.zzb;
        return iZza - zzfaVar.zza();
    }

    private static long zzg(zzfa zzfaVar) {
        return zzfaVar.zzd((zzfaVar.zzd(2) + 1) * 8);
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zza(zzfb zzfbVar) throws zzcc {
        int i;
        int i2;
        int iZzd;
        boolean zZzn;
        zzdx.zzb(this.zzd);
        while (zzfbVar.zza() > 0) {
            int i3 = this.zzg;
            if (i3 != 0) {
                if (i3 == 1) {
                    int iZzl = zzfbVar.zzl();
                    if ((iZzl & 224) == 224) {
                        this.zzj = iZzl;
                        this.zzg = 2;
                    } else if (iZzl != 86) {
                        this.zzg = 0;
                    }
                } else if (i3 != 2) {
                    int iMin = Math.min(zzfbVar.zza(), this.zzi - this.zzh);
                    zzfbVar.zzC(this.zzc.zza, this.zzh, iMin);
                    int i4 = this.zzh + iMin;
                    this.zzh = i4;
                    if (i4 == this.zzi) {
                        this.zzc.zzj(0);
                        zzfa zzfaVar = this.zzc;
                        if (zzfaVar.zzn()) {
                            if (this.zzl) {
                            }
                            this.zzg = 0;
                        } else {
                            this.zzl = true;
                            int iZzd2 = zzfaVar.zzd(1);
                            if (iZzd2 == 1) {
                                iZzd = zzfaVar.zzd(1);
                                i2 = 1;
                            } else {
                                i2 = iZzd2;
                                iZzd = 0;
                            }
                            this.zzm = iZzd;
                            if (iZzd != 0) {
                                throw zzcc.zza(null, null);
                            }
                            if (i2 == 1) {
                                zzg(zzfaVar);
                                i2 = 1;
                            }
                            if (!zzfaVar.zzn()) {
                                throw zzcc.zza(null, null);
                            }
                            this.zzn = zzfaVar.zzd(6);
                            int iZzd3 = zzfaVar.zzd(4);
                            int iZzd4 = zzfaVar.zzd(3);
                            if (iZzd3 != 0 || iZzd4 != 0) {
                                throw zzcc.zza(null, null);
                            }
                            if (i2 == 0) {
                                int iZzc = zzfaVar.zzc();
                                int iZzf = zzf(zzfaVar);
                                zzfaVar.zzj(iZzc);
                                byte[] bArr = new byte[(iZzf + 7) / 8];
                                zzfaVar.zzg(bArr, 0, iZzf);
                                zzak zzakVar = new zzak();
                                zzakVar.zzJ(this.zze);
                                zzakVar.zzU("audio/mp4a-latm");
                                zzakVar.zzz(this.zzu);
                                zzakVar.zzy(this.zzt);
                                zzakVar.zzV(this.zzr);
                                zzakVar.zzK(Collections.singletonList(bArr));
                                zzakVar.zzM(this.zza);
                                zzam zzamVarZzac = zzakVar.zzac();
                                if (!zzamVarZzac.equals(this.zzf)) {
                                    this.zzf = zzamVarZzac;
                                    this.zzs = 1024000000 / ((long) zzamVarZzac.zzA);
                                    this.zzd.zzl(zzamVarZzac);
                                }
                            } else {
                                zzfaVar.zzl(((int) zzg(zzfaVar)) - zzf(zzfaVar));
                            }
                            int iZzd5 = zzfaVar.zzd(3);
                            this.zzo = iZzd5;
                            if (iZzd5 == 0) {
                                zzfaVar.zzl(8);
                            } else if (iZzd5 == 1) {
                                zzfaVar.zzl(9);
                            } else if (iZzd5 == 3 || iZzd5 == 4 || iZzd5 == 5) {
                                zzfaVar.zzl(6);
                            } else {
                                if (iZzd5 != 6 && iZzd5 != 7) {
                                    throw new IllegalStateException();
                                }
                                zzfaVar.zzl(1);
                            }
                            boolean zZzn2 = zzfaVar.zzn();
                            this.zzp = zZzn2;
                            this.zzq = 0L;
                            if (zZzn2) {
                                if (i2 != 1) {
                                    do {
                                        zZzn = zzfaVar.zzn();
                                        this.zzq = (this.zzq << 8) + ((long) zzfaVar.zzd(8));
                                    } while (zZzn);
                                } else {
                                    this.zzq = zzg(zzfaVar);
                                }
                            }
                            if (zzfaVar.zzn()) {
                                zzfaVar.zzl(8);
                            }
                        }
                        if (this.zzm != 0) {
                            throw zzcc.zza(null, null);
                        }
                        if (this.zzn != 0) {
                            throw zzcc.zza(null, null);
                        }
                        if (this.zzo != 0) {
                            throw zzcc.zza(null, null);
                        }
                        int i5 = 0;
                        while (true) {
                            int iZzd6 = zzfaVar.zzd(8);
                            i = i5 + iZzd6;
                            if (iZzd6 != 255) {
                                break;
                            } else {
                                i5 = i;
                            }
                        }
                        int iZzc2 = zzfaVar.zzc();
                        if ((iZzc2 & 7) == 0) {
                            this.zzb.zzG(iZzc2 >> 3);
                        } else {
                            zzfaVar.zzg(this.zzb.zzI(), 0, i * 8);
                            this.zzb.zzG(0);
                        }
                        this.zzd.zzr(this.zzb, i);
                        long j = this.zzk;
                        if (j != -9223372036854775807L) {
                            this.zzd.zzt(j, 1, i, 0, null);
                            this.zzk += this.zzs;
                        }
                        if (this.zzp) {
                            zzfaVar.zzl((int) this.zzq);
                        }
                        this.zzg = 0;
                    } else {
                        continue;
                    }
                } else {
                    int iZzl2 = ((this.zzj & (-225)) << 8) | zzfbVar.zzl();
                    this.zzi = iZzl2;
                    zzfb zzfbVar2 = this.zzb;
                    if (iZzl2 > zzfbVar2.zzI().length) {
                        zzfbVar2.zzD(iZzl2);
                        zzfa zzfaVar2 = this.zzc;
                        byte[] bArrZzI = this.zzb.zzI();
                        zzfaVar2.zzi(bArrZzI, bArrZzI.length);
                    }
                    this.zzh = 0;
                    this.zzg = 3;
                }
            } else if (zzfbVar.zzl() == 86) {
                this.zzg = 1;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzb(zzabp zzabpVar, zzakq zzakqVar) {
        zzakqVar.zzc();
        this.zzd = zzabpVar.zzw(zzakqVar.zza(), 1);
        this.zze = zzakqVar.zzb();
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
        this.zzg = 0;
        this.zzk = -9223372036854775807L;
        this.zzl = false;
    }
}
