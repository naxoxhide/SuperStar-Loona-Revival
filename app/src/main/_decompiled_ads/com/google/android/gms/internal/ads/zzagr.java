package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzagr implements zzabm {
    public static final zzabt zza = new zzabt() { // from class: com.google.android.gms.internal.ads.zzagp
        @Override // com.google.android.gms.internal.ads.zzabt
        public final /* synthetic */ zzabm[] zza(Uri uri, Map map) {
            int i = zzabs.zza;
            zzabt zzabtVar = zzagr.zza;
            return new zzabm[]{new zzagr(0)};
        }
    };
    private static final zzafe zzb = new zzafe() { // from class: com.google.android.gms.internal.ads.zzagq
    };
    private final zzfb zzc;
    private final zzacg zzd;
    private final zzacc zze;
    private final zzace zzf;
    private final zzacs zzg;
    private zzabp zzh;
    private zzacs zzi;
    private zzacs zzj;
    private int zzk;
    private zzby zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private int zzp;
    private zzagt zzq;
    private boolean zzr;

    public zzagr() {
        this(0);
    }

    /* JADX WARN: Code duplicated, block: B:109:0x023d  */
    /* JADX WARN: Code duplicated, block: B:113:0x0246  */
    /* JADX WARN: Code duplicated, block: B:117:0x014c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x010e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x012b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:120:0x013f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x013c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x013c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x0055  */
    /* JADX WARN: Code duplicated, block: B:23:0x005e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x0060  */
    /* JADX WARN: Code duplicated, block: B:25:0x0062  */
    /* JADX WARN: Code duplicated, block: B:26:0x0064  */
    /* JADX WARN: Code duplicated, block: B:28:0x006c  */
    /* JADX WARN: Code duplicated, block: B:30:0x0075  */
    /* JADX WARN: Code duplicated, block: B:31:0x0077  */
    /* JADX WARN: Code duplicated, block: B:38:0x009a  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:44:0x00da A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:45:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:57:0x0106  */
    /* JADX WARN: Code duplicated, block: B:61:0x0117  */
    /* JADX WARN: Code duplicated, block: B:63:0x011f  */
    /* JADX WARN: Code duplicated, block: B:69:0x0149 A[LOOP:0: B:56:0x0104->B:69:0x0149, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:70:0x014c A[EDGE_INSN: B:70:0x014c->B:71:0x014d BREAK  A[LOOP:0: B:56:0x0104->B:69:0x0149]] */
    /* JADX WARN: Code duplicated, block: B:73:0x0151  */
    /* JADX WARN: Code duplicated, block: B:74:0x0157 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x0159  */
    /* JADX WARN: Code duplicated, block: B:76:0x015b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x015d  */
    /* JADX WARN: Code duplicated, block: B:79:0x0160  */
    /* JADX WARN: Code duplicated, block: B:80:0x0164  */
    /* JADX WARN: Multi-variable type inference failed */
    @RequiresNonNull({"extractorOutput", "realTrackOutput"})
    private final int zzf(zzabn zzabnVar) throws Throwable {
        int iZzf;
        int i;
        int i2;
        int i3;
        zzagv zzagvVarZzb;
        zzagt zzagtVarZzh;
        zzacc zzaccVar;
        int i4;
        int i5;
        zzby zzbyVar;
        long jZzf;
        zzago zzagoVarZzb;
        int iZza;
        int i6;
        zzbx zzbxVarZzb;
        int iZza2;
        int i7;
        long jZzq;
        zzbx zzbxVarZzb2;
        zzafp zzafpVar;
        int iZzf2;
        if (this.zzk == 0) {
            try {
                zzk(zzabnVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.zzq == null) {
            zzfb zzfbVar = new zzfb(this.zzd.zzc);
            zzabc zzabcVar = (zzabc) zzabnVar;
            zzabcVar.zzm(zzfbVar.zzI(), 0, this.zzd.zzc, false);
            zzacg zzacgVar = this.zzd;
            int i8 = 21;
            if ((zzacgVar.zza & 1) != 0) {
                if (zzacgVar.zze != 1) {
                    i2 = 36;
                }
                if (zzfbVar.zzd() >= i2 + 4) {
                    zzfbVar.zzG(i2);
                    iZzf2 = zzfbVar.zzf();
                    if (iZzf2 != 1483304551) {
                        i3 = iZzf2;
                    } else if (iZzf2 == 1231971951) {
                        i3 = 1231971951;
                    } else if (zzfbVar.zzd() >= 40) {
                        zzfbVar.zzG(36);
                        if (zzfbVar.zzf() == 1447187017) {
                            i3 = 1447187017;
                        } else {
                            i3 = 0;
                        }
                    } else {
                        i3 = 0;
                    }
                } else if (zzfbVar.zzd() >= 40) {
                    zzfbVar.zzG(36);
                    if (zzfbVar.zzf() == 1447187017) {
                        i3 = 1447187017;
                    } else {
                        i3 = 0;
                    }
                } else {
                    i3 = 0;
                }
                if (i3 != 1483304551 || i3 == 1231971951) {
                    int i9 = i3;
                    zzagvVarZzb = zzagv.zzb(zzabnVar.zzd(), zzabnVar.zzf(), this.zzd, zzfbVar);
                    if (zzagvVarZzb != null && !this.zze.zza()) {
                        zzabnVar.zzj();
                        zzabcVar.zzl(i2 + 141, false);
                        zzabcVar.zzm(this.zzc.zzI(), 0, 3, false);
                        this.zzc.zzG(0);
                        zzaccVar = this.zze;
                        int iZzn = this.zzc.zzn();
                        i4 = iZzn >> 12;
                        i5 = iZzn & 4095;
                        if (i4 <= 0 || i5 > 0) {
                            zzaccVar.zza = i4;
                            zzaccVar.zzb = i5;
                        }
                    }
                    zzabcVar.zzo(this.zzd.zzc, false);
                    if (zzagvVarZzb == null && !zzagvVarZzb.zzh() && i9 == 1231971951) {
                        zzagtVarZzh = zzh(zzabnVar, false);
                    } else {
                        zzagtVarZzh = zzagvVarZzb;
                    }
                } else if (i3 == 1447187017) {
                    zzagtVarZzh = zzagu.zzb(zzabnVar.zzd(), zzabnVar.zzf(), this.zzd, zzfbVar);
                    zzabcVar.zzo(this.zzd.zzc, false);
                } else {
                    zzabnVar.zzj();
                    zzagtVarZzh = null;
                }
                zzbyVar = this.zzl;
                jZzf = zzabnVar.zzf();
                if (zzbyVar != null) {
                    zzagoVarZzb = null;
                    break;
                }
                iZza = zzbyVar.zza();
                i6 = 0;
                while (true) {
                    if (i6 < iZza) {
                        zzagoVarZzb = null;
                        break;
                    }
                    zzbxVarZzb = zzbyVar.zzb(i6);
                    if (zzbxVarZzb instanceof zzafl) {
                        zzafl zzaflVar = (zzafl) zzbxVarZzb;
                        iZza2 = zzbyVar.zza();
                        i7 = 0;
                        while (true) {
                            if (i7 < iZza2) {
                                jZzq = -9223372036854775807L;
                                break;
                            }
                            zzbxVarZzb2 = zzbyVar.zzb(i7);
                            if (zzbxVarZzb2 instanceof zzafp) {
                                zzafpVar = (zzafp) zzbxVarZzb2;
                                if (zzafpVar.zzf.equals("TLEN")) {
                                    jZzq = zzfk.zzq(Long.parseLong((String) zzafpVar.zzc.get(0)));
                                    break;
                                }
                            }
                            i7++;
                        }
                        zzagoVarZzb = zzago.zzb(jZzf, zzaflVar, jZzq);
                        break;
                    }
                    i6++;
                }
                if (this.zzr) {
                    zzagtVarZzh = new zzags();
                } else {
                    if (zzagoVarZzb != null) {
                        zzagtVarZzh = zzagoVarZzb;
                    } else if (zzagtVarZzh == null) {
                        zzagtVarZzh = null;
                    }
                    if (zzagtVarZzh != null) {
                        zzagtVarZzh.zzh();
                    } else {
                        zzagtVarZzh = zzh(zzabnVar, false);
                    }
                }
                this.zzq = zzagtVarZzh;
                this.zzh.zzO(zzagtVarZzh);
                zzacs zzacsVar = this.zzj;
                zzak zzakVar = new zzak();
                zzakVar.zzU(this.zzd.zzb);
                zzakVar.zzN(4096);
                zzakVar.zzy(this.zzd.zze);
                zzakVar.zzV(this.zzd.zzd);
                zzakVar.zzE(this.zze.zza);
                zzakVar.zzF(this.zze.zzb);
                zzakVar.zzO(this.zzl);
                zzacsVar.zzl(zzakVar.zzac());
                this.zzo = zzabnVar.zzf();
            } else if (zzacgVar.zze == 1) {
                i8 = 13;
            }
            i2 = i8;
            if (zzfbVar.zzd() >= i2 + 4) {
                zzfbVar.zzG(i2);
                iZzf2 = zzfbVar.zzf();
                if (iZzf2 != 1483304551) {
                    i3 = iZzf2;
                } else if (iZzf2 == 1231971951) {
                    i3 = 1231971951;
                } else if (zzfbVar.zzd() >= 40) {
                    zzfbVar.zzG(36);
                    if (zzfbVar.zzf() == 1447187017) {
                        i3 = 1447187017;
                    } else {
                        i3 = 0;
                    }
                } else {
                    i3 = 0;
                }
            } else if (zzfbVar.zzd() >= 40) {
                zzfbVar.zzG(36);
                if (zzfbVar.zzf() == 1447187017) {
                    i3 = 1447187017;
                } else {
                    i3 = 0;
                }
            } else {
                i3 = 0;
            }
            if (i3 != 1483304551) {
                int i10 = i3;
                zzagvVarZzb = zzagv.zzb(zzabnVar.zzd(), zzabnVar.zzf(), this.zzd, zzfbVar);
                if (zzagvVarZzb != null) {
                    zzabnVar.zzj();
                    zzabcVar.zzl(i2 + 141, false);
                    zzabcVar.zzm(this.zzc.zzI(), 0, 3, false);
                    this.zzc.zzG(0);
                    zzaccVar = this.zze;
                    int iZzn2 = this.zzc.zzn();
                    i4 = iZzn2 >> 12;
                    i5 = iZzn2 & 4095;
                    if (i4 <= 0) {
                        zzaccVar.zza = i4;
                        zzaccVar.zzb = i5;
                    } else {
                        zzaccVar.zza = i4;
                        zzaccVar.zzb = i5;
                    }
                }
                zzabcVar.zzo(this.zzd.zzc, false);
                if (zzagvVarZzb == null) {
                    zzagtVarZzh = zzagvVarZzb;
                } else {
                    zzagtVarZzh = zzagvVarZzb;
                }
            } else {
                int i11 = i3;
                zzagvVarZzb = zzagv.zzb(zzabnVar.zzd(), zzabnVar.zzf(), this.zzd, zzfbVar);
                if (zzagvVarZzb != null) {
                    zzabnVar.zzj();
                    zzabcVar.zzl(i2 + 141, false);
                    zzabcVar.zzm(this.zzc.zzI(), 0, 3, false);
                    this.zzc.zzG(0);
                    zzaccVar = this.zze;
                    int iZzn3 = this.zzc.zzn();
                    i4 = iZzn3 >> 12;
                    i5 = iZzn3 & 4095;
                    if (i4 <= 0) {
                        zzaccVar.zza = i4;
                        zzaccVar.zzb = i5;
                    } else {
                        zzaccVar.zza = i4;
                        zzaccVar.zzb = i5;
                    }
                }
                zzabcVar.zzo(this.zzd.zzc, false);
                if (zzagvVarZzb == null) {
                    zzagtVarZzh = zzagvVarZzb;
                } else {
                    zzagtVarZzh = zzagvVarZzb;
                }
            }
            zzbyVar = this.zzl;
            jZzf = zzabnVar.zzf();
            if (zzbyVar != null) {
                zzagoVarZzb = null;
                break;
            }
            iZza = zzbyVar.zza();
            i6 = 0;
            while (true) {
                if (i6 < iZza) {
                    zzagoVarZzb = null;
                    break;
                }
                zzbxVarZzb = zzbyVar.zzb(i6);
                if (zzbxVarZzb instanceof zzafl) {
                    zzafl zzaflVar2 = (zzafl) zzbxVarZzb;
                    iZza2 = zzbyVar.zza();
                    i7 = 0;
                    while (true) {
                        if (i7 < iZza2) {
                            jZzq = -9223372036854775807L;
                            break;
                        }
                        zzbxVarZzb2 = zzbyVar.zzb(i7);
                        if (zzbxVarZzb2 instanceof zzafp) {
                            zzafpVar = (zzafp) zzbxVarZzb2;
                            if (zzafpVar.zzf.equals("TLEN")) {
                                jZzq = zzfk.zzq(Long.parseLong((String) zzafpVar.zzc.get(0)));
                                break;
                            }
                        }
                        i7++;
                    }
                    zzagoVarZzb = zzago.zzb(jZzf, zzaflVar2, jZzq);
                    break;
                }
                i6++;
            }
            if (this.zzr) {
                zzagtVarZzh = new zzags();
            } else {
                if (zzagoVarZzb != null) {
                    zzagtVarZzh = zzagoVarZzb;
                } else if (zzagtVarZzh == null) {
                    zzagtVarZzh = null;
                }
                if (zzagtVarZzh != null) {
                    zzagtVarZzh.zzh();
                } else {
                    zzagtVarZzh = zzh(zzabnVar, false);
                }
            }
            this.zzq = zzagtVarZzh;
            this.zzh.zzO(zzagtVarZzh);
            zzacs zzacsVar2 = this.zzj;
            zzak zzakVar2 = new zzak();
            zzakVar2.zzU(this.zzd.zzb);
            zzakVar2.zzN(4096);
            zzakVar2.zzy(this.zzd.zze);
            zzakVar2.zzV(this.zzd.zzd);
            zzakVar2.zzE(this.zze.zza);
            zzakVar2.zzF(this.zze.zzb);
            zzakVar2.zzO(this.zzl);
            zzacsVar2.zzl(zzakVar2.zzac());
            this.zzo = zzabnVar.zzf();
        } else {
            long j = this.zzo;
            if (j != 0) {
                long jZzf2 = zzabnVar.zzf();
                if (jZzf2 < j) {
                    ((zzabc) zzabnVar).zzo((int) (j - jZzf2), false);
                }
            }
        }
        int i12 = this.zzp;
        if (i12 == 0) {
            zzabnVar.zzj();
            if (zzj(zzabnVar)) {
                return -1;
            }
            this.zzc.zzG(0);
            int iZzf3 = this.zzc.zzf();
            if (!zzi(iZzf3, this.zzk) || zzach.zzb(iZzf3) == -1) {
                ((zzabc) zzabnVar).zzo(1, false);
                this.zzk = 0;
            } else {
                this.zzd.zza(iZzf3);
                if (this.zzm == -9223372036854775807L) {
                    this.zzm = this.zzq.zzd(zzabnVar.zzf());
                }
                zzacg zzacgVar2 = this.zzd;
                int i13 = zzacgVar2.zzc;
                this.zzp = i13;
                zzagt zzagtVar = this.zzq;
                if (zzagtVar instanceof zzagn) {
                    zzg(this.zzn + ((long) zzacgVar2.zzg));
                    throw null;
                }
                i12 = i13;
                iZzf = this.zzj.zzf(zzabnVar, i12, true);
                if (iZzf == -1) {
                    return -1;
                }
                i = this.zzp - iZzf;
                this.zzp = i;
                if (i <= 0) {
                    this.zzj.zzt(zzg(this.zzn), 1, this.zzd.zzc, 0, null);
                    this.zzn += (long) this.zzd.zzg;
                    this.zzp = 0;
                    return 0;
                }
            }
        } else {
            iZzf = this.zzj.zzf(zzabnVar, i12, true);
            if (iZzf == -1) {
                return -1;
            }
            i = this.zzp - iZzf;
            this.zzp = i;
            if (i <= 0) {
                this.zzj.zzt(zzg(this.zzn), 1, this.zzd.zzc, 0, null);
                this.zzn += (long) this.zzd.zzg;
                this.zzp = 0;
                return 0;
            }
        }
        return 0;
    }

    private final long zzg(long j) {
        return this.zzm + ((j * 1000000) / ((long) this.zzd.zzd));
    }

    private final zzagt zzh(zzabn zzabnVar, boolean z) throws IOException {
        ((zzabc) zzabnVar).zzm(this.zzc.zzI(), 0, 4, false);
        this.zzc.zzG(0);
        this.zzd.zza(this.zzc.zzf());
        return new zzagm(zzabnVar.zzd(), zzabnVar.zzf(), this.zzd, false);
    }

    private static boolean zzi(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    private final boolean zzj(zzabn zzabnVar) throws IOException {
        zzagt zzagtVar = this.zzq;
        if (zzagtVar != null) {
            long jZzc = zzagtVar.zzc();
            if (jZzc != -1 && zzabnVar.zze() > jZzc - 4) {
                return true;
            }
        }
        try {
            return !zzabnVar.zzm(this.zzc.zzI(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private final boolean zzk(zzabn zzabnVar, boolean z) throws Throwable {
        int iZze;
        int i;
        int iZzb;
        zzabnVar.zzj();
        if (zzabnVar.zzf() == 0) {
            zzby zzbyVarZza = this.zzf.zza(zzabnVar, null);
            this.zzl = zzbyVarZza;
            if (zzbyVarZza != null) {
                this.zze.zzb(zzbyVarZza);
            }
            iZze = (int) zzabnVar.zze();
            if (!z) {
                ((zzabc) zzabnVar).zzo(iZze, false);
            }
            i = 0;
        } else {
            iZze = 0;
            i = 0;
        }
        int i2 = i;
        int i3 = i2;
        while (true) {
            if (zzj(zzabnVar)) {
                if (i2 > 0) {
                    break;
                }
                throw new EOFException();
            }
            this.zzc.zzG(0);
            int iZzf = this.zzc.zzf();
            if ((i == 0 || zzi(iZzf, i)) && (iZzb = zzach.zzb(iZzf)) != -1) {
                i2++;
                if (i2 != 1) {
                    if (i2 == 4) {
                        break;
                    }
                } else {
                    this.zzd.zza(iZzf);
                    i = iZzf;
                }
                ((zzabc) zzabnVar).zzl(iZzb - 4, false);
            } else {
                int i4 = i3 + 1;
                if (i3 == (true != z ? 131072 : 32768)) {
                    if (z) {
                        return false;
                    }
                    throw zzcc.zza("Searched too many bytes.", null);
                }
                if (z) {
                    zzabnVar.zzj();
                    ((zzabc) zzabnVar).zzl(iZze + i4, false);
                } else {
                    ((zzabc) zzabnVar).zzo(1, false);
                }
                i = 0;
                i3 = i4;
                i2 = 0;
            }
        }
        if (z) {
            ((zzabc) zzabnVar).zzo(iZze + i3, false);
        } else {
            zzabnVar.zzj();
        }
        this.zzk = i;
        return true;
    }

    public final void zza() {
        this.zzr = true;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final int zzb(zzabn zzabnVar, zzacj zzacjVar) throws Throwable {
        zzdx.zzb(this.zzi);
        int i = zzfk.zza;
        int iZzf = zzf(zzabnVar);
        if (iZzf == -1 && (this.zzq instanceof zzagn)) {
            if (this.zzq.zza() != zzg(this.zzn)) {
                throw null;
            }
        }
        return iZzf;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzc(zzabp zzabpVar) {
        this.zzh = zzabpVar;
        zzacs zzacsVarZzw = zzabpVar.zzw(0, 1);
        this.zzi = zzacsVarZzw;
        this.zzj = zzacsVarZzw;
        this.zzh.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzd(long j, long j2) {
        this.zzk = 0;
        this.zzm = -9223372036854775807L;
        this.zzn = 0L;
        this.zzp = 0;
        zzagt zzagtVar = this.zzq;
        if (zzagtVar instanceof zzagn) {
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final boolean zze(zzabn zzabnVar) throws IOException {
        return zzk(zzabnVar, true);
    }

    public zzagr(int i) {
        this.zzc = new zzfb(10);
        this.zzd = new zzacg();
        this.zze = new zzacc();
        this.zzm = -9223372036854775807L;
        this.zzf = new zzace();
        zzabl zzablVar = new zzabl();
        this.zzg = zzablVar;
        this.zzj = zzablVar;
    }
}
