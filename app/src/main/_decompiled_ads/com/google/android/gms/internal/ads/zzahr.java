package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzahr implements zzabm, zzacm {
    public static final zzabt zza = new zzabt() { // from class: com.google.android.gms.internal.ads.zzahp
        @Override // com.google.android.gms.internal.ads.zzabt
        public final /* synthetic */ zzabm[] zza(Uri uri, Map map) {
            int i = zzabs.zza;
            zzabt zzabtVar = zzahr.zza;
            return new zzabm[]{new zzahr(0)};
        }
    };
    private final zzfb zzb;
    private final zzfb zzc;
    private final zzfb zzd;
    private final zzfb zze;
    private final ArrayDeque zzf;
    private final zzaht zzg;
    private final List zzh;
    private int zzi;
    private int zzj;
    private long zzk;
    private int zzl;
    private zzfb zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private zzabp zzr;
    private zzahq[] zzs;
    private long[][] zzt;
    private int zzu;
    private long zzv;
    private int zzw;
    private zzafu zzx;

    public zzahr() {
        this(0);
    }

    private static int zzf(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static int zzi(zzahy zzahyVar, long j) {
        int iZza = zzahyVar.zza(j);
        return iZza == -1 ? zzahyVar.zzb(j) : iZza;
    }

    private static long zzj(zzahy zzahyVar, long j, long j2) {
        int iZzi = zzi(zzahyVar, j);
        return iZzi == -1 ? j2 : Math.min(zzahyVar.zzc[iZzi], j2);
    }

    private final void zzk() {
        this.zzi = 0;
        this.zzl = 0;
    }

    private final void zzl(long j) throws zzcc {
        zzby zzbyVar;
        long j2;
        int i;
        zzby zzbyVar2;
        int i2;
        while (!this.zzf.isEmpty() && ((zzagw) this.zzf.peek()).zza == j) {
            zzagw zzagwVar = (zzagw) this.zzf.pop();
            if (zzagwVar.zzd == 1836019574) {
                ArrayList arrayList = new ArrayList();
                int i3 = this.zzw;
                zzacc zzaccVar = new zzacc();
                zzagx zzagxVarZzb = zzagwVar.zzb(1969517665);
                if (zzagxVarZzb != null) {
                    zzby zzbyVarZzb = zzahg.zzb(zzagxVarZzb);
                    zzaccVar.zzb(zzbyVarZzb);
                    zzbyVar = zzbyVarZzb;
                } else {
                    zzbyVar = null;
                }
                zzagw zzagwVarZza = zzagwVar.zza(1835365473);
                zzby zzbyVarZza = zzagwVarZza != null ? zzahg.zza(zzagwVarZza) : null;
                zzbx[] zzbxVarArr = new zzbx[1];
                zzagx zzagxVarZzb2 = zzagwVar.zzb(1836476516);
                Objects.requireNonNull(zzagxVarZzb2);
                boolean z = i3 == 1;
                zzbxVarArr[0] = zzahg.zzc(zzagxVarZzb2.zza);
                zzby zzbyVar3 = new zzby(-9223372036854775807L, zzbxVarArr);
                zzby zzbyVar4 = zzbyVar;
                long j3 = -9223372036854775807L;
                List listZzd = zzahg.zzd(zzagwVar, zzaccVar, -9223372036854775807L, null, false, z, new zzfsk() { // from class: com.google.android.gms.internal.ads.zzaho
                    @Override // com.google.android.gms.internal.ads.zzfsk
                    public final Object apply(Object obj) {
                        zzahv zzahvVar = (zzahv) obj;
                        zzabt zzabtVar = zzahr.zza;
                        return zzahvVar;
                    }
                });
                int size = listZzd.size();
                long j4 = -9223372036854775807L;
                int size2 = -1;
                int i4 = 0;
                while (true) {
                    j2 = 0;
                    if (i4 >= size) {
                        break;
                    }
                    zzahy zzahyVar = (zzahy) listZzd.get(i4);
                    if (zzahyVar.zzb != 0) {
                        zzahv zzahvVar = zzahyVar.zza;
                        long j5 = zzahvVar.zze;
                        if (j5 == j3) {
                            j5 = zzahyVar.zzh;
                        }
                        long jMax = Math.max(j4, j5);
                        zzahq zzahqVar = new zzahq(zzahvVar, zzahyVar, this.zzr.zzw(i4, zzahvVar.zzb));
                        int i5 = "audio/true-hd".equals(zzahvVar.zzf.zzm) ? zzahyVar.zze * 16 : zzahyVar.zze + 30;
                        zzak zzakVarZzb = zzahvVar.zzf.zzb();
                        zzakVarZzb.zzN(i5);
                        if (zzahvVar.zzb != 2 || j5 <= 0) {
                            i = 1;
                        } else {
                            int i6 = zzahyVar.zzb;
                            i = 1;
                            if (i6 > 1) {
                                zzakVarZzb.zzG(i6 / (j5 / 1000000.0f));
                            }
                        }
                        int i7 = zzahvVar.zzb;
                        int i8 = zzahn.zzb;
                        if (i7 == i && zzaccVar.zza()) {
                            zzakVarZzb.zzE(zzaccVar.zza);
                            zzakVarZzb.zzF(zzaccVar.zzb);
                        }
                        int i9 = zzahvVar.zzb;
                        zzby[] zzbyVarArr = new zzby[3];
                        if (this.zzh.isEmpty()) {
                            i2 = 0;
                            zzbyVar2 = null;
                        } else {
                            zzbyVar2 = new zzby(this.zzh);
                            i2 = 0;
                        }
                        zzbyVarArr[i2] = zzbyVar2;
                        zzbyVarArr[i] = zzbyVar4;
                        zzbyVarArr[2] = zzbyVar3;
                        zzby zzbyVar5 = new zzby(-9223372036854775807L, new zzbx[i2]);
                        if (zzbyVarZza != null) {
                            for (int i10 = i2; i10 < zzbyVarZza.zza(); i10++) {
                                zzbx zzbxVarZzb = zzbyVarZza.zzb(i10);
                                if (zzbxVarZzb instanceof zzfo) {
                                    zzfo zzfoVar = (zzfo) zzbxVarZzb;
                                    if (!zzfoVar.zza.equals("com.android.capture.fps")) {
                                        zzbyVar5 = zzbyVar5.zzc(zzfoVar);
                                    } else if (i9 == 2) {
                                        zzbyVar5 = zzbyVar5.zzc(zzfoVar);
                                    }
                                }
                            }
                        }
                        for (int i11 = 0; i11 < 3; i11++) {
                            zzbyVar5 = zzbyVar5.zzd(zzbyVarArr[i11]);
                        }
                        if (zzbyVar5.zza() > 0) {
                            zzakVarZzb.zzO(zzbyVar5);
                        }
                        zzahqVar.zzc.zzl(zzakVarZzb.zzac());
                        if (zzahvVar.zzb == 2 && size2 == -1) {
                            size2 = arrayList.size();
                        }
                        arrayList.add(zzahqVar);
                        j4 = jMax;
                    }
                    i4++;
                    zzaccVar = zzaccVar;
                    listZzd = listZzd;
                    size = size;
                    j3 = -9223372036854775807L;
                }
                this.zzu = size2;
                this.zzv = j4;
                zzahq[] zzahqVarArr = (zzahq[]) arrayList.toArray(new zzahq[0]);
                this.zzs = zzahqVarArr;
                int length = zzahqVarArr.length;
                long[][] jArr = new long[length][];
                int[] iArr = new int[length];
                long[] jArr2 = new long[length];
                boolean[] zArr = new boolean[length];
                for (int i12 = 0; i12 < zzahqVarArr.length; i12++) {
                    jArr[i12] = new long[zzahqVarArr[i12].zzb.zzb];
                    jArr2[i12] = zzahqVarArr[i12].zzb.zzf[0];
                }
                int i13 = 0;
                while (i13 < zzahqVarArr.length) {
                    long j6 = Long.MAX_VALUE;
                    int i14 = -1;
                    for (int i15 = 0; i15 < zzahqVarArr.length; i15++) {
                        if (!zArr[i15]) {
                            long j7 = jArr2[i15];
                            if (j7 <= j6) {
                                i14 = i15;
                                j6 = j7;
                            }
                        }
                    }
                    int i16 = iArr[i14];
                    long[] jArr3 = jArr[i14];
                    jArr3[i16] = j2;
                    zzahy zzahyVar2 = zzahqVarArr[i14].zzb;
                    j2 += (long) zzahyVar2.zzd[i16];
                    int i17 = i16 + 1;
                    iArr[i14] = i17;
                    if (i17 < jArr3.length) {
                        jArr2[i14] = zzahyVar2.zzf[i17];
                    } else {
                        zArr[i14] = true;
                        i13++;
                    }
                }
                this.zzt = jArr;
                this.zzr.zzD();
                this.zzr.zzO(this);
                this.zzf.clear();
                this.zzi = 2;
            } else if (!this.zzf.isEmpty()) {
                ((zzagw) this.zzf.peek()).zzc(zzagwVar);
            }
        }
        if (this.zzi != 2) {
            zzk();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final long zza() {
        return this.zzv;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzc(zzabp zzabpVar) {
        this.zzr = zzabpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzd(long j, long j2) {
        this.zzf.clear();
        this.zzl = 0;
        this.zzn = -1;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        if (j == 0) {
            zzk();
            return;
        }
        for (zzahq zzahqVar : this.zzs) {
            zzahy zzahyVar = zzahqVar.zzb;
            int iZza = zzahyVar.zza(j2);
            if (iZza == -1) {
                iZza = zzahyVar.zzb(j2);
            }
            zzahqVar.zze = iZza;
            zzact zzactVar = zzahqVar.zzd;
            if (zzactVar != null) {
                zzactVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final boolean zze(zzabn zzabnVar) throws IOException {
        return zzahu.zzb(zzabnVar, false);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final zzack zzg(long j) {
        long j2;
        long j3;
        int iZzb;
        zzahq[] zzahqVarArr = this.zzs;
        if (zzahqVarArr.length == 0) {
            zzacn zzacnVar = zzacn.zza;
            return new zzack(zzacnVar, zzacnVar);
        }
        int i = this.zzu;
        long jZzj = -1;
        if (i != -1) {
            zzahy zzahyVar = zzahqVarArr[i].zzb;
            int iZzi = zzi(zzahyVar, j);
            if (iZzi == -1) {
                zzacn zzacnVar2 = zzacn.zza;
                return new zzack(zzacnVar2, zzacnVar2);
            }
            long j4 = zzahyVar.zzf[iZzi];
            j2 = zzahyVar.zzc[iZzi];
            if (j4 >= j || iZzi >= zzahyVar.zzb - 1 || (iZzb = zzahyVar.zzb(j)) == -1 || iZzb == iZzi) {
                j3 = -9223372036854775807L;
            } else {
                j3 = zzahyVar.zzf[iZzb];
                jZzj = zzahyVar.zzc[iZzb];
            }
            j = j4;
        } else {
            j2 = Long.MAX_VALUE;
            j3 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            zzahq[] zzahqVarArr2 = this.zzs;
            if (i2 >= zzahqVarArr2.length) {
                break;
            }
            if (i2 != this.zzu) {
                zzahy zzahyVar2 = zzahqVarArr2[i2].zzb;
                long jZzj2 = zzj(zzahyVar2, j, j2);
                if (j3 != -9223372036854775807L) {
                    jZzj = zzj(zzahyVar2, j3, jZzj);
                }
                j2 = jZzj2;
            }
            i2++;
        }
        zzacn zzacnVar3 = new zzacn(j, j2);
        return j3 == -9223372036854775807L ? new zzack(zzacnVar3, zzacnVar3) : new zzack(zzacnVar3, new zzacn(j3, jZzj));
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final boolean zzh() {
        return true;
    }

    public zzahr(int i) {
        this.zzi = 0;
        this.zzg = new zzaht();
        this.zzh = new ArrayList();
        this.zze = new zzfb(16);
        this.zzf = new ArrayDeque();
        this.zzb = new zzfb(zzfy.zza);
        this.zzc = new zzfb(4);
        this.zzd = new zzfb();
        this.zzn = -1;
        this.zzr = zzabp.zza;
        this.zzs = new zzahq[0];
    }

    /* JADX WARN: Code duplicated, block: B:259:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x006c  */
    /* JADX WARN: Code duplicated, block: B:33:0x007b  */
    @Override // com.google.android.gms.internal.ads.zzabm
    public final int zzb(zzabn zzabnVar, zzacj zzacjVar) throws IOException {
        boolean z;
        boolean z2;
        while (true) {
            int i = this.zzi;
            if (i == 0) {
                if (this.zzl == 0) {
                    if (!zzabnVar.zzn(this.zze.zzI(), 0, 8, true)) {
                        return -1;
                    }
                    this.zzl = 8;
                    this.zze.zzG(0);
                    this.zzk = this.zze.zzt();
                    this.zzj = this.zze.zzf();
                }
                long j = this.zzk;
                if (j == 1) {
                    zzabnVar.zzi(this.zze.zzI(), 8, 8);
                    this.zzl += 8;
                    this.zzk = this.zze.zzu();
                } else if (j == 0) {
                    long jZzd = zzabnVar.zzd();
                    if (jZzd == -1) {
                        zzagw zzagwVar = (zzagw) this.zzf.peek();
                        jZzd = zzagwVar != null ? zzagwVar.zza : -1L;
                    }
                    if (jZzd != -1) {
                        this.zzk = (jZzd - zzabnVar.zzf()) + ((long) this.zzl);
                    }
                }
                long j2 = this.zzk;
                int i2 = this.zzl;
                if (j2 < i2) {
                    throw zzcc.zzc("Atom size less than header length (unsupported).");
                }
                int i3 = this.zzj;
                if (i3 == 1836019574 || i3 == 1953653099 || i3 == 1835297121 || i3 == 1835626086 || i3 == 1937007212 || i3 == 1701082227 || i3 == 1835365473) {
                    long jZzf = zzabnVar.zzf();
                    long j3 = this.zzk;
                    long j4 = jZzf + j3;
                    long j5 = this.zzl;
                    if (j3 != j5 && this.zzj == 1835365473) {
                        this.zzd.zzD(8);
                        zzabnVar.zzh(this.zzd.zzI(), 0, 8);
                        zzahg.zze(this.zzd);
                        zzabnVar.zzk(this.zzd.zzc());
                        zzabnVar.zzj();
                    }
                    long j6 = j4 - j5;
                    this.zzf.push(new zzagw(this.zzj, j6));
                    if (this.zzk == this.zzl) {
                        zzl(j6);
                    } else {
                        zzk();
                    }
                } else if (i3 == 1835296868 || i3 == 1836476516 || i3 == 1751411826 || i3 == 1937011556 || i3 == 1937011827 || i3 == 1937011571 || i3 == 1668576371 || i3 == 1701606260 || i3 == 1937011555 || i3 == 1937011578 || i3 == 1937013298 || i3 == 1937007471 || i3 == 1668232756 || i3 == 1953196132 || i3 == 1718909296 || i3 == 1969517665 || i3 == 1801812339 || i3 == 1768715124) {
                    zzdx.zzf(i2 == 8);
                    zzdx.zzf(this.zzk <= 2147483647L);
                    zzfb zzfbVar = new zzfb((int) this.zzk);
                    System.arraycopy(this.zze.zzI(), 0, zzfbVar.zzI(), 0, 8);
                    this.zzm = zzfbVar;
                    this.zzi = 1;
                } else {
                    long jZzf2 = zzabnVar.zzf();
                    long j7 = this.zzl;
                    long j8 = jZzf2 - j7;
                    if (this.zzj == 1836086884) {
                        this.zzx = new zzafu(0L, j8, -9223372036854775807L, j8 + j7, this.zzk - j7);
                    }
                    this.zzm = null;
                    this.zzi = 1;
                }
            } else {
                if (i != 1) {
                    long jZzf3 = zzabnVar.zzf();
                    int i4 = this.zzn;
                    if (i4 == -1) {
                        int i5 = -1;
                        int i6 = -1;
                        boolean z3 = true;
                        boolean z4 = true;
                        long j9 = Long.MAX_VALUE;
                        long j10 = Long.MAX_VALUE;
                        long j11 = Long.MAX_VALUE;
                        int i7 = 0;
                        while (true) {
                            zzahq[] zzahqVarArr = this.zzs;
                            if (i7 >= zzahqVarArr.length) {
                                break;
                            }
                            zzahq zzahqVar = zzahqVarArr[i7];
                            int i8 = zzahqVar.zze;
                            zzahy zzahyVar = zzahqVar.zzb;
                            if (i8 != zzahyVar.zzb) {
                                long j12 = zzahyVar.zzc[i8];
                                long[][] jArr = this.zzt;
                                int i9 = zzfk.zza;
                                long j13 = jArr[i7][i8];
                                long j14 = j12 - jZzf3;
                                boolean z5 = j14 < 0 || j14 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                                if (z5) {
                                    z = z4;
                                } else {
                                    if (z4) {
                                        z4 = z5;
                                        i6 = i7;
                                        j11 = j14;
                                        j10 = j13;
                                    } else {
                                        z = false;
                                    }
                                    if (j13 < j9) {
                                        z3 = z5;
                                        i5 = i7;
                                        j9 = j13;
                                    }
                                }
                                if (z5 != z || j14 >= j11) {
                                    z4 = z;
                                } else {
                                    z4 = z5;
                                    i6 = i7;
                                    j11 = j14;
                                    j10 = j13;
                                }
                                if (j13 < j9) {
                                    z3 = z5;
                                    i5 = i7;
                                    j9 = j13;
                                }
                            }
                            i7++;
                        }
                        i4 = (j9 == Long.MAX_VALUE || !z3 || j10 < j9 + 10485760) ? i6 : i5;
                        this.zzn = i4;
                        if (i4 == -1) {
                            return -1;
                        }
                    }
                    zzahq zzahqVar2 = this.zzs[i4];
                    zzacs zzacsVar = zzahqVar2.zzc;
                    int i10 = zzahqVar2.zze;
                    zzahy zzahyVar2 = zzahqVar2.zzb;
                    long j15 = zzahyVar2.zzc[i10];
                    int i11 = zzahyVar2.zzd[i10];
                    zzact zzactVar = zzahqVar2.zzd;
                    long j16 = (j15 - jZzf3) + ((long) this.zzo);
                    if (j16 < 0 || j16 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                        zzacjVar.zza = j15;
                        return 1;
                    }
                    if (zzahqVar2.zza.zzg == 1) {
                        j16 += 8;
                        i11 -= 8;
                    }
                    zzabnVar.zzk((int) j16);
                    zzahv zzahvVar = zzahqVar2.zza;
                    int i12 = zzahvVar.zzj;
                    if (i12 == 0) {
                        if ("audio/ac4".equals(zzahvVar.zzf.zzm)) {
                            if (this.zzp == 0) {
                                zzaaq.zzb(i11, this.zzd);
                                zzacsVar.zzr(this.zzd, 7);
                                this.zzp += 7;
                            }
                            i11 += 7;
                        } else if (zzactVar != null) {
                            zzactVar.zzd(zzabnVar);
                        }
                        while (true) {
                            int i13 = this.zzp;
                            if (i13 >= i11) {
                                break;
                            }
                            int iZzf = zzacsVar.zzf(zzabnVar, i11 - i13, false);
                            this.zzo += iZzf;
                            this.zzp += iZzf;
                            this.zzq -= iZzf;
                        }
                    } else {
                        byte[] bArrZzI = this.zzc.zzI();
                        bArrZzI[0] = 0;
                        bArrZzI[1] = 0;
                        bArrZzI[2] = 0;
                        int i14 = 4 - i12;
                        while (this.zzp < i11) {
                            int i15 = this.zzq;
                            if (i15 == 0) {
                                zzabnVar.zzi(bArrZzI, i14, i12);
                                this.zzo += i12;
                                this.zzc.zzG(0);
                                int iZzf2 = this.zzc.zzf();
                                if (iZzf2 < 0) {
                                    throw zzcc.zza("Invalid NAL length", null);
                                }
                                this.zzq = iZzf2;
                                this.zzb.zzG(0);
                                zzacsVar.zzr(this.zzb, 4);
                                this.zzp += 4;
                                i11 += i14;
                            } else {
                                int iZzf3 = zzacsVar.zzf(zzabnVar, i15, false);
                                this.zzo += iZzf3;
                                this.zzp += iZzf3;
                                this.zzq -= iZzf3;
                            }
                        }
                    }
                    zzahy zzahyVar3 = zzahqVar2.zzb;
                    long j17 = zzahyVar3.zzf[i10];
                    int i16 = zzahyVar3.zzg[i10];
                    if (zzactVar != null) {
                        zzactVar.zzc(zzacsVar, j17, i16, i11, 0, null);
                        if (i10 + 1 == zzahqVar2.zzb.zzb) {
                            zzactVar.zza(zzacsVar, null);
                        }
                    } else {
                        zzacsVar.zzt(j17, i16, i11, 0, null);
                    }
                    zzahqVar2.zze++;
                    this.zzn = -1;
                    this.zzo = 0;
                    this.zzp = 0;
                    this.zzq = 0;
                    return 0;
                }
                long j18 = this.zzk - ((long) this.zzl);
                long jZzf4 = zzabnVar.zzf() + j18;
                zzfb zzfbVar2 = this.zzm;
                if (zzfbVar2 != null) {
                    zzabnVar.zzi(zzfbVar2.zzI(), this.zzl, (int) j18);
                    if (this.zzj == 1718909296) {
                        zzfbVar2.zzG(8);
                        int iZzf4 = zzf(zzfbVar2.zzf());
                        if (iZzf4 == 0) {
                            zzfbVar2.zzH(4);
                            do {
                                if (zzfbVar2.zza() <= 0) {
                                    iZzf4 = 0;
                                    break;
                                }
                                iZzf4 = zzf(zzfbVar2.zzf());
                            } while (iZzf4 == 0);
                        }
                        this.zzw = iZzf4;
                    } else if (!this.zzf.isEmpty()) {
                        ((zzagw) this.zzf.peek()).zzd(new zzagx(this.zzj, zzfbVar2));
                    }
                } else {
                    if (j18 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                        zzabnVar.zzk((int) j18);
                    } else {
                        zzacjVar.zza = zzabnVar.zzf() + j18;
                        z2 = true;
                    }
                    zzl(jZzf4);
                    if (z2 && this.zzi != 2) {
                        return 1;
                    }
                }
                z2 = false;
                zzl(jZzf4);
                if (z2) {
                    continue;
                }
            }
        }
    }
}
