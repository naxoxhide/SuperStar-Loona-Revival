package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaip extends zzain {
    private zzaio zza;
    private int zzb;
    private boolean zzc;
    private zzacx zzd;
    private zzacv zze;

    zzaip() {
    }

    @Override // com.google.android.gms.internal.ads.zzain
    protected final long zza(zzfb zzfbVar) {
        if ((zzfbVar.zzI()[0] & 1) == 1) {
            return -1L;
        }
        byte b2 = zzfbVar.zzI()[0];
        zzaio zzaioVar = this.zza;
        zzdx.zzb(zzaioVar);
        int i = !zzaioVar.zzd[(b2 >> 1) & (255 >>> (8 - zzaioVar.zze))].zza ? zzaioVar.zza.zze : zzaioVar.zza.zzf;
        int i2 = this.zzc ? (this.zzb + i) / 4 : 0;
        if (zzfbVar.zzb() < zzfbVar.zzd() + 4) {
            byte[] bArrCopyOf = Arrays.copyOf(zzfbVar.zzI(), zzfbVar.zzd() + 4);
            zzfbVar.zzE(bArrCopyOf, bArrCopyOf.length);
        } else {
            zzfbVar.zzF(zzfbVar.zzd() + 4);
        }
        long j = i2;
        byte[] bArrZzI = zzfbVar.zzI();
        bArrZzI[zzfbVar.zzd() - 4] = (byte) (j & 255);
        bArrZzI[zzfbVar.zzd() - 3] = (byte) ((j >>> 8) & 255);
        bArrZzI[zzfbVar.zzd() - 2] = (byte) ((j >>> 16) & 255);
        bArrZzI[zzfbVar.zzd() - 1] = (byte) ((j >>> 24) & 255);
        this.zzc = true;
        this.zzb = i;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzain
    protected final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzain
    protected final void zzi(long j) {
        super.zzi(j);
        this.zzc = j != 0;
        zzacx zzacxVar = this.zzd;
        this.zzb = zzacxVar != null ? zzacxVar.zze : 0;
    }

    /* JADX WARN: Code duplicated, block: B:167:0x03c6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:169:0x03c8  */
    @Override // com.google.android.gms.internal.ads.zzain
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean zzc(zzfb zzfbVar, long j, zzaik zzaikVar) throws IOException {
        zzaio zzaioVar;
        int i;
        int iZzb;
        int i2;
        int i3;
        if (this.zza != null) {
            Objects.requireNonNull(zzaikVar.zza);
            return false;
        }
        zzacx zzacxVar = this.zzd;
        int i4 = 4;
        if (zzacxVar != null) {
            zzacv zzacvVar = this.zze;
            if (zzacvVar == null) {
                this.zze = zzacy.zzc(zzfbVar, true, true);
            } else {
                byte[] bArr = new byte[zzfbVar.zzd()];
                System.arraycopy(zzfbVar.zzI(), 0, bArr, 0, zzfbVar.zzd());
                int i5 = zzacxVar.zza;
                int i6 = 5;
                zzacy.zzd(5, zzfbVar, false);
                int iZzl = zzfbVar.zzl() + 1;
                zzacu zzacuVar = new zzacu(zzfbVar.zzI());
                zzacuVar.zzc(zzfbVar.zzc() * 8);
                int i7 = 0;
                while (true) {
                    int i8 = 2;
                    int i9 = 16;
                    if (i7 >= iZzl) {
                        zzacx zzacxVar2 = zzacxVar;
                        int i10 = 6;
                        int iZzb2 = zzacuVar.zzb(6) + 1;
                        for (int i11 = 0; i11 < iZzb2; i11++) {
                            if (zzacuVar.zzb(16) != 0) {
                                throw zzcc.zza("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int i12 = 1;
                        int iZzb3 = zzacuVar.zzb(6) + 1;
                        int i13 = 0;
                        while (true) {
                            int i14 = 3;
                            if (i13 >= iZzb3) {
                                int i15 = 1;
                                int iZzb4 = zzacuVar.zzb(i10) + 1;
                                int i16 = 0;
                                while (i16 < iZzb4) {
                                    if (zzacuVar.zzb(16) > 2) {
                                        throw zzcc.zza("residueType greater than 2 is not decodable", null);
                                    }
                                    zzacuVar.zzc(24);
                                    zzacuVar.zzc(24);
                                    zzacuVar.zzc(24);
                                    int iZzb5 = zzacuVar.zzb(i10) + i15;
                                    int i17 = 8;
                                    zzacuVar.zzc(8);
                                    int[] iArr = new int[iZzb5];
                                    for (int i18 = 0; i18 < iZzb5; i18++) {
                                        iArr[i18] = ((zzacuVar.zzd() ? zzacuVar.zzb(5) : 0) * 8) + zzacuVar.zzb(3);
                                    }
                                    int i19 = 0;
                                    while (i19 < iZzb5) {
                                        int i20 = 0;
                                        while (i20 < i17) {
                                            if ((iArr[i19] & (1 << i20)) != 0) {
                                                zzacuVar.zzc(i17);
                                            }
                                            i20++;
                                            i17 = 8;
                                        }
                                        i19++;
                                        i17 = 8;
                                    }
                                    i16++;
                                    i10 = 6;
                                    i15 = 1;
                                }
                                int iZzb6 = zzacuVar.zzb(i10) + 1;
                                for (int i21 = 0; i21 < iZzb6; i21++) {
                                    int iZzb7 = zzacuVar.zzb(16);
                                    if (iZzb7 != 0) {
                                        zzer.zzc("VorbisUtil", "mapping type other than 0 not supported: " + iZzb7);
                                    } else {
                                        if (zzacuVar.zzd()) {
                                            i = 1;
                                            iZzb = zzacuVar.zzb(4) + 1;
                                        } else {
                                            i = 1;
                                            iZzb = 1;
                                        }
                                        if (zzacuVar.zzd()) {
                                            int iZzb8 = zzacuVar.zzb(8) + i;
                                            for (int i22 = 0; i22 < iZzb8; i22++) {
                                                int i23 = i5 - 1;
                                                zzacuVar.zzc(zzacy.zza(i23));
                                                zzacuVar.zzc(zzacy.zza(i23));
                                            }
                                        }
                                        if (zzacuVar.zzb(2) != 0) {
                                            throw zzcc.zza("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                        if (iZzb > 1) {
                                            for (int i24 = 0; i24 < i5; i24++) {
                                                zzacuVar.zzc(4);
                                            }
                                        }
                                        for (int i25 = 0; i25 < iZzb; i25++) {
                                            zzacuVar.zzc(8);
                                            zzacuVar.zzc(8);
                                            zzacuVar.zzc(8);
                                        }
                                    }
                                }
                                int iZzb9 = zzacuVar.zzb(6) + 1;
                                zzacw[] zzacwVarArr = new zzacw[iZzb9];
                                for (int i26 = 0; i26 < iZzb9; i26++) {
                                    zzacwVarArr[i26] = new zzacw(zzacuVar.zzd(), zzacuVar.zzb(16), zzacuVar.zzb(16), zzacuVar.zzb(8));
                                }
                                if (!zzacuVar.zzd()) {
                                    throw zzcc.zza("framing bit after modes not set as expected", null);
                                }
                                zzaioVar = new zzaio(zzacxVar2, zzacvVar, bArr, zzacwVarArr, zzacy.zza(iZzb9 - 1));
                                break;
                            }
                            int iZzb10 = zzacuVar.zzb(i9);
                            if (iZzb10 == 0) {
                                i2 = iZzb3;
                                int i27 = 8;
                                zzacuVar.zzc(8);
                                zzacuVar.zzc(16);
                                zzacuVar.zzc(16);
                                zzacuVar.zzc(6);
                                zzacuVar.zzc(8);
                                int iZzb11 = zzacuVar.zzb(4) + 1;
                                int i28 = 0;
                                while (i28 < iZzb11) {
                                    zzacuVar.zzc(i27);
                                    i28++;
                                    i27 = 8;
                                }
                            } else {
                                if (iZzb10 != i12) {
                                    throw zzcc.zza("floor type greater than 1 not decodable: " + iZzb10, null);
                                }
                                int iZzb12 = zzacuVar.zzb(i6);
                                int[] iArr2 = new int[iZzb12];
                                int i29 = -1;
                                for (int i30 = 0; i30 < iZzb12; i30++) {
                                    int iZzb13 = zzacuVar.zzb(4);
                                    iArr2[i30] = iZzb13;
                                    if (iZzb13 > i29) {
                                        i29 = iZzb13;
                                    }
                                }
                                int i31 = i29 + 1;
                                int[] iArr3 = new int[i31];
                                int i32 = 0;
                                while (i32 < i31) {
                                    iArr3[i32] = zzacuVar.zzb(i14) + 1;
                                    int iZzb14 = zzacuVar.zzb(i8);
                                    if (iZzb14 > 0) {
                                        i3 = 8;
                                        zzacuVar.zzc(8);
                                    } else {
                                        i3 = 8;
                                    }
                                    int i33 = iZzb3;
                                    int i34 = 0;
                                    for (int i35 = 1; i34 < (i35 << iZzb14); i35 = 1) {
                                        zzacuVar.zzc(i3);
                                        i34++;
                                        i3 = 8;
                                    }
                                    i32++;
                                    iZzb3 = i33;
                                    i8 = 2;
                                    i14 = 3;
                                }
                                i2 = iZzb3;
                                zzacuVar.zzc(i8);
                                int iZzb15 = zzacuVar.zzb(4);
                                int i36 = 0;
                                int i37 = 0;
                                for (int i38 = 0; i38 < iZzb12; i38++) {
                                    i36 += iArr3[iArr2[i38]];
                                    while (i37 < i36) {
                                        zzacuVar.zzc(iZzb15);
                                        i37++;
                                    }
                                }
                            }
                            i13++;
                            iZzb3 = i2;
                            i10 = 6;
                            i9 = 16;
                            i8 = 2;
                            i12 = 1;
                            i6 = 5;
                        }
                    } else {
                        if (zzacuVar.zzb(24) != 5653314) {
                            throw zzcc.zza("expected code book to start with [0x56, 0x43, 0x42] at " + zzacuVar.zza(), null);
                        }
                        int iZzb16 = zzacuVar.zzb(16);
                        int iZzb17 = zzacuVar.zzb(24);
                        if (zzacuVar.zzd()) {
                            zzacuVar.zzc(5);
                            for (int iZzb18 = 0; iZzb18 < iZzb17; iZzb18 += zzacuVar.zzb(zzacy.zza(iZzb17 - iZzb18))) {
                            }
                        } else {
                            boolean zZzd = zzacuVar.zzd();
                            for (int i39 = 0; i39 < iZzb17; i39++) {
                                if (!zZzd) {
                                    zzacuVar.zzc(5);
                                } else if (zzacuVar.zzd()) {
                                    zzacuVar.zzc(5);
                                }
                            }
                        }
                        int iZzb19 = zzacuVar.zzb(i4);
                        if (iZzb19 > 2) {
                            throw zzcc.zza("lookup type greater than 2 not decodable: " + iZzb19, null);
                        }
                        if (iZzb19 != 1) {
                            if (iZzb19 != 2) {
                                zzacxVar = zzacxVar;
                            }
                            i7++;
                            zzacxVar = zzacxVar;
                            i4 = 4;
                        } else {
                            i8 = iZzb19;
                        }
                        zzacuVar.zzc(32);
                        zzacuVar.zzc(32);
                        int iZzb20 = zzacuVar.zzb(i4) + 1;
                        zzacuVar.zzc(1);
                        zzacuVar.zzc((int) ((i8 == 1 ? iZzb16 != 0 ? (long) Math.floor(Math.pow(iZzb17, 1.0d / ((double) iZzb16))) : 0L : ((long) iZzb16) * ((long) iZzb17)) * ((long) iZzb20)));
                        i7++;
                        zzacxVar = zzacxVar;
                        i4 = 4;
                    }
                }
            }
            this.zza = zzaioVar;
            if (zzaioVar == null) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            zzacx zzacxVar3 = zzaioVar.zza;
            arrayList.add(zzacxVar3.zzg);
            arrayList.add(zzaioVar.zzc);
            zzby zzbyVarZzb = zzacy.zzb(zzfvs.zzk(zzaioVar.zzb.zzb));
            zzak zzakVar = new zzak();
            zzakVar.zzU("audio/vorbis");
            zzakVar.zzx(zzacxVar3.zzd);
            zzakVar.zzQ(zzacxVar3.zzc);
            zzakVar.zzy(zzacxVar3.zza);
            zzakVar.zzV(zzacxVar3.zzb);
            zzakVar.zzK(arrayList);
            zzakVar.zzO(zzbyVarZzb);
            zzaikVar.zza = zzakVar.zzac();
            return true;
        }
        zzacy.zzd(1, zzfbVar, false);
        int iZzi = zzfbVar.zzi();
        int iZzl2 = zzfbVar.zzl();
        int iZzi2 = zzfbVar.zzi();
        int iZzh = zzfbVar.zzh();
        int i40 = iZzh <= 0 ? -1 : iZzh;
        int iZzh2 = zzfbVar.zzh();
        int i41 = iZzh2 <= 0 ? -1 : iZzh2;
        int iZzh3 = zzfbVar.zzh();
        int i42 = iZzh3 <= 0 ? -1 : iZzh3;
        int iZzl3 = zzfbVar.zzl();
        this.zzd = new zzacx(iZzi, iZzl2, iZzi2, i40, i41, i42, (int) Math.pow(2.0d, iZzl3 & 15), (int) Math.pow(2.0d, (iZzl3 & 240) >> 4), 1 == (zzfbVar.zzl() & 1), Arrays.copyOf(zzfbVar.zzI(), zzfbVar.zzd()));
        zzaioVar = null;
        this.zza = zzaioVar;
        if (zzaioVar == null) {
            return true;
        }
        ArrayList arrayList2 = new ArrayList();
        zzacx zzacxVar4 = zzaioVar.zza;
        arrayList2.add(zzacxVar4.zzg);
        arrayList2.add(zzaioVar.zzc);
        zzby zzbyVarZzb2 = zzacy.zzb(zzfvs.zzk(zzaioVar.zzb.zzb));
        zzak zzakVar2 = new zzak();
        zzakVar2.zzU("audio/vorbis");
        zzakVar2.zzx(zzacxVar4.zzd);
        zzakVar2.zzQ(zzacxVar4.zzc);
        zzakVar2.zzy(zzacxVar4.zza);
        zzakVar2.zzV(zzacxVar4.zzb);
        zzakVar2.zzK(arrayList2);
        zzakVar2.zzO(zzbyVarZzb2);
        zzaikVar.zza = zzakVar2.zzac();
        return true;
    }
}
