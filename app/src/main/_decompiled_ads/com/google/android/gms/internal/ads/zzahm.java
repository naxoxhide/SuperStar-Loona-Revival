package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import androidx.core.view.ViewCompat;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzahm implements zzabm {
    public static final zzabt zza = new zzabt() { // from class: com.google.android.gms.internal.ads.zzahi
        @Override // com.google.android.gms.internal.ads.zzabt
        public final /* synthetic */ zzabm[] zza(Uri uri, Map map) {
            int i = zzabs.zza;
            zzabt zzabtVar = zzahm.zza;
            return new zzabm[]{new zzahm(0, null)};
        }
    };
    private static final byte[] zzb = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final zzam zzc;
    private int zzA;
    private int zzB;
    private boolean zzC;
    private zzabp zzD;
    private zzacs[] zzE;
    private zzacs[] zzF;
    private boolean zzG;
    private final List zzd;
    private final SparseArray zze;
    private final zzfb zzf;
    private final zzfb zzg;
    private final zzfb zzh;
    private final byte[] zzi;
    private final zzfb zzj;
    private final zzaek zzk;
    private final zzfb zzl;
    private final ArrayDeque zzm;
    private final ArrayDeque zzn;
    private int zzo;
    private int zzp;
    private long zzq;
    private int zzr;
    private zzfb zzs;
    private long zzt;
    private int zzu;
    private long zzv;
    private long zzw;
    private long zzx;
    private zzahl zzy;
    private int zzz;

    static {
        zzak zzakVar = new zzak();
        zzakVar.zzU("application/x-emsg");
        zzc = zzakVar.zzac();
    }

    public zzahm() {
        this(0, null);
    }

    private static int zza(int i) throws zzcc {
        if (i >= 0) {
            return i;
        }
        throw zzcc.zza("Unexpected negative value: " + i, null);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0031  */
    private static zzad zzf(List list) {
        zzahs zzahsVar;
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            zzagx zzagxVar = (zzagx) list.get(i);
            if (zzagxVar.zzd == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArrZzI = zzagxVar.zza.zzI();
                zzfb zzfbVar = new zzfb(bArrZzI);
                if (zzfbVar.zzd() < 32) {
                    zzahsVar = null;
                } else {
                    zzfbVar.zzG(0);
                    if (zzfbVar.zzf() == zzfbVar.zza() + 4 && zzfbVar.zzf() == 1886614376) {
                        int iZze = zzagy.zze(zzfbVar.zzf());
                        if (iZze > 1) {
                            zzer.zzf("PsshAtomUtil", "Unsupported pssh version: " + iZze);
                        } else {
                            UUID uuid = new UUID(zzfbVar.zzs(), zzfbVar.zzs());
                            if (iZze == 1) {
                                zzfbVar.zzH(zzfbVar.zzo() * 16);
                            }
                            int iZzo = zzfbVar.zzo();
                            if (iZzo == zzfbVar.zza()) {
                                byte[] bArr = new byte[iZzo];
                                zzfbVar.zzC(bArr, 0, iZzo);
                                zzahsVar = new zzahs(uuid, iZze, bArr);
                            }
                        }
                        zzahsVar = null;
                    } else {
                        zzahsVar = null;
                    }
                }
                UUID uuid2 = zzahsVar == null ? null : zzahsVar.zza;
                if (uuid2 == null) {
                    zzer.zzf("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new zzac(uuid2, null, "video/mp4", bArrZzI));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new zzad(arrayList);
    }

    private final void zzg() {
        this.zzo = 0;
        this.zzr = 0;
    }

    private static void zzh(zzfb zzfbVar, int i, zzahx zzahxVar) throws zzcc {
        zzfbVar.zzG(i + 8);
        int iZzf = zzfbVar.zzf() & ViewCompat.MEASURED_SIZE_MASK;
        if ((iZzf & 1) != 0) {
            throw zzcc.zzc("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (iZzf & 2) != 0;
        int iZzo = zzfbVar.zzo();
        if (iZzo == 0) {
            Arrays.fill(zzahxVar.zzl, 0, zzahxVar.zze, false);
            return;
        }
        int i2 = zzahxVar.zze;
        if (iZzo != i2) {
            throw zzcc.zza("Senc sample count " + iZzo + " is different from fragment sample count" + i2, null);
        }
        Arrays.fill(zzahxVar.zzl, 0, iZzo, z);
        zzahxVar.zza(zzfbVar.zza());
        zzfb zzfbVar2 = zzahxVar.zzn;
        zzfbVar.zzC(zzfbVar2.zzI(), 0, zzfbVar2.zzd());
        zzahxVar.zzn.zzG(0);
        zzahxVar.zzo = false;
    }

    /* JADX WARN: Code duplicated, block: B:255:0x0637  */
    private final void zzi(long j) throws zzcc {
        zzahm zzahmVar;
        SparseArray sparseArray;
        zzagw zzagwVar;
        int i;
        int i2;
        int i3;
        byte[] bArr;
        int i4;
        byte[] bArr2;
        byte[] bArr3;
        int i5;
        boolean z;
        zzahx zzahxVar;
        int i6;
        zzagw zzagwVar2;
        zzahl zzahlVar;
        int i7;
        boolean z2;
        int i8;
        int iZzf;
        long[] jArr;
        final zzahm zzahmVar2 = this;
        while (!zzahmVar2.zzm.isEmpty() && ((zzagw) zzahmVar2.zzm.peek()).zza == j) {
            zzagw zzagwVar3 = (zzagw) zzahmVar2.zzm.pop();
            int i9 = zzagwVar3.zzd;
            int i10 = 12;
            int i11 = 8;
            if (i9 == 1836019574) {
                zzad zzadVarZzf = zzf(zzagwVar3.zzb);
                zzagw zzagwVarZza = zzagwVar3.zza(1836475768);
                Objects.requireNonNull(zzagwVarZza);
                SparseArray sparseArray2 = new SparseArray();
                int size = zzagwVarZza.zzb.size();
                long jZzt = -9223372036854775807L;
                int i12 = 0;
                while (i12 < size) {
                    zzagx zzagxVar = (zzagx) zzagwVarZza.zzb.get(i12);
                    int i13 = zzagxVar.zzd;
                    if (i13 == 1953654136) {
                        zzfb zzfbVar = zzagxVar.zza;
                        zzfbVar.zzG(i10);
                        Pair pairCreate = Pair.create(Integer.valueOf(zzfbVar.zzf()), new zzahh(zzfbVar.zzf() - 1, zzfbVar.zzf(), zzfbVar.zzf(), zzfbVar.zzf()));
                        sparseArray2.put(((Integer) pairCreate.first).intValue(), (zzahh) pairCreate.second);
                    } else if (i13 == 1835362404) {
                        zzfb zzfbVar2 = zzagxVar.zza;
                        zzfbVar2.zzG(8);
                        jZzt = zzagy.zze(zzfbVar2.zzf()) == 0 ? zzfbVar2.zzt() : zzfbVar2.zzu();
                    }
                    i12++;
                    i10 = 12;
                }
                List listZzd = zzahg.zzd(zzagwVar3, new zzacc(), jZzt, zzadVarZzf, false, false, new zzfsk() { // from class: com.google.android.gms.internal.ads.zzahj
                    @Override // com.google.android.gms.internal.ads.zzfsk
                    public final Object apply(Object obj) {
                        return (zzahv) obj;
                    }
                });
                int size2 = listZzd.size();
                if (zzahmVar2.zze.size() == 0) {
                    for (int i14 = 0; i14 < size2; i14++) {
                        zzahy zzahyVar = (zzahy) listZzd.get(i14);
                        zzahv zzahvVar = zzahyVar.zza;
                        zzahmVar2.zze.put(zzahvVar.zza, new zzahl(zzahmVar2.zzD.zzw(i14, zzahvVar.zzb), zzahyVar, zzj(sparseArray2, zzahvVar.zza)));
                        zzahmVar2.zzw = Math.max(zzahmVar2.zzw, zzahvVar.zze);
                    }
                    zzahmVar2.zzD.zzD();
                } else {
                    zzdx.zzf(zzahmVar2.zze.size() == size2);
                    for (int i15 = 0; i15 < size2; i15++) {
                        zzahy zzahyVar2 = (zzahy) listZzd.get(i15);
                        zzahv zzahvVar2 = zzahyVar2.zza;
                        ((zzahl) zzahmVar2.zze.get(zzahvVar2.zza)).zzh(zzahyVar2, zzj(sparseArray2, zzahvVar2.zza));
                    }
                }
            } else {
                if (i9 == 1836019558) {
                    SparseArray sparseArray3 = zzahmVar2.zze;
                    byte[] bArr4 = zzahmVar2.zzi;
                    int size3 = zzagwVar3.zzc.size();
                    int i16 = 0;
                    while (i16 < size3) {
                        zzagw zzagwVar4 = (zzagw) zzagwVar3.zzc.get(i16);
                        if (zzagwVar4.zzd == 1953653094) {
                            zzagx zzagxVarZzb = zzagwVar4.zzb(1952868452);
                            Objects.requireNonNull(zzagxVarZzb);
                            zzfb zzfbVar3 = zzagxVarZzb.zza;
                            zzfbVar3.zzG(i11);
                            int iZzf2 = zzfbVar3.zzf() & ViewCompat.MEASURED_SIZE_MASK;
                            zzahl zzahlVar2 = (zzahl) sparseArray3.get(zzfbVar3.zzf());
                            if (zzahlVar2 == null) {
                                zzahlVar2 = null;
                            } else {
                                if ((iZzf2 & 1) != 0) {
                                    long jZzu = zzfbVar3.zzu();
                                    zzahx zzahxVar2 = zzahlVar2.zzb;
                                    zzahxVar2.zzb = jZzu;
                                    zzahxVar2.zzc = jZzu;
                                }
                                zzahh zzahhVar = zzahlVar2.zze;
                                zzahlVar2.zzb.zza = new zzahh((iZzf2 & 2) != 0 ? zzfbVar3.zzf() - 1 : zzahhVar.zza, (iZzf2 & 8) != 0 ? zzfbVar3.zzf() : zzahhVar.zzb, (iZzf2 & 16) != 0 ? zzfbVar3.zzf() : zzahhVar.zzc, (iZzf2 & 32) != 0 ? zzfbVar3.zzf() : zzahhVar.zzd);
                            }
                            if (zzahlVar2 == null) {
                                sparseArray = sparseArray3;
                                zzagwVar = zzagwVar3;
                                i = size3;
                                i2 = i11;
                                i3 = i16;
                                bArr = bArr4;
                            } else {
                                zzahx zzahxVar3 = zzahlVar2.zzb;
                                long j2 = zzahxVar3.zzp;
                                boolean z3 = zzahxVar3.zzq;
                                zzahlVar2.zzi();
                                zzahlVar2.zzl = true;
                                zzagx zzagxVarZzb2 = zzagwVar4.zzb(1952867444);
                                if (zzagxVarZzb2 != null) {
                                    zzfb zzfbVar4 = zzagxVarZzb2.zza;
                                    zzfbVar4.zzG(i11);
                                    zzahxVar3.zzp = zzagy.zze(zzfbVar4.zzf()) == 1 ? zzfbVar4.zzu() : zzfbVar4.zzt();
                                    zzahxVar3.zzq = true;
                                } else {
                                    zzahxVar3.zzp = j2;
                                    zzahxVar3.zzq = z3;
                                }
                                List list = zzagwVar4.zzb;
                                int size4 = list.size();
                                int i17 = 0;
                                int i18 = 0;
                                int i19 = 0;
                                while (true) {
                                    i4 = 1953658222;
                                    if (i17 >= size4) {
                                        break;
                                    }
                                    zzagx zzagxVar2 = (zzagx) list.get(i17);
                                    SparseArray sparseArray4 = sparseArray3;
                                    if (zzagxVar2.zzd == 1953658222) {
                                        zzfb zzfbVar5 = zzagxVar2.zza;
                                        zzfbVar5.zzG(12);
                                        int iZzo = zzfbVar5.zzo();
                                        if (iZzo > 0) {
                                            i19 += iZzo;
                                            i18++;
                                        }
                                    }
                                    i17++;
                                    sparseArray3 = sparseArray4;
                                }
                                sparseArray = sparseArray3;
                                zzahlVar2.zzh = 0;
                                zzahlVar2.zzg = 0;
                                zzahlVar2.zzf = 0;
                                zzahx zzahxVar4 = zzahlVar2.zzb;
                                zzahxVar4.zzd = i18;
                                zzahxVar4.zze = i19;
                                if (zzahxVar4.zzg.length < i18) {
                                    zzahxVar4.zzf = new long[i18];
                                    zzahxVar4.zzg = new int[i18];
                                }
                                if (zzahxVar4.zzh.length < i19) {
                                    int i20 = (i19 * 125) / 100;
                                    zzahxVar4.zzh = new int[i20];
                                    zzahxVar4.zzi = new long[i20];
                                    zzahxVar4.zzj = new boolean[i20];
                                    zzahxVar4.zzl = new boolean[i20];
                                }
                                int i21 = 0;
                                int i22 = 0;
                                int i23 = 0;
                                while (true) {
                                    long j3 = 0;
                                    if (i21 >= size4) {
                                        break;
                                    }
                                    zzagx zzagxVar3 = (zzagx) list.get(i21);
                                    if (zzagxVar3.zzd == i4) {
                                        int i24 = i22 + 1;
                                        zzfb zzfbVar6 = zzagxVar3.zza;
                                        zzfbVar6.zzG(8);
                                        int iZzf3 = zzfbVar6.zzf() & ViewCompat.MEASURED_SIZE_MASK;
                                        zzahv zzahvVar3 = zzahlVar2.zzd.zza;
                                        zzahx zzahxVar5 = zzahlVar2.zzb;
                                        zzahh zzahhVar2 = zzahxVar5.zza;
                                        int i25 = zzfk.zza;
                                        zzahxVar5.zzg[i22] = zzfbVar6.zzo();
                                        long[] jArr2 = zzahxVar5.zzf;
                                        long j4 = zzahxVar5.zzb;
                                        jArr2[i22] = j4;
                                        if ((iZzf3 & 1) != 0) {
                                            jArr2[i22] = j4 + ((long) zzfbVar6.zzf());
                                        }
                                        boolean z4 = (iZzf3 & 4) != 0;
                                        int iZzf4 = zzahhVar2.zzd;
                                        if (z4) {
                                            iZzf4 = zzfbVar6.zzf();
                                        }
                                        int i26 = iZzf3 & 256;
                                        int i27 = iZzf3 & 512;
                                        int i28 = iZzf3 & 1024;
                                        int i29 = iZzf3 & 2048;
                                        int i30 = iZzf4;
                                        long[] jArr3 = zzahvVar3.zzh;
                                        if (jArr3 != null) {
                                            i6 = i16;
                                            zzagwVar2 = zzagwVar4;
                                            if (jArr3.length != 1 || (jArr = zzahvVar3.zzi) == null) {
                                                z2 = z4;
                                                i7 = i29;
                                                zzahlVar = zzahlVar2;
                                            } else {
                                                long j5 = jArr3[0];
                                                if (j5 == 0) {
                                                    z2 = z4;
                                                    i7 = i29;
                                                    zzahlVar = zzahlVar2;
                                                } else {
                                                    long j6 = j5 + jArr[0];
                                                    i7 = i29;
                                                    z2 = z4;
                                                    zzahlVar = zzahlVar2;
                                                    if (zzfk.zzr(j6, 1000000L, zzahvVar3.zzd) >= zzahvVar3.zze) {
                                                    }
                                                }
                                                j3 = zzahvVar3.zzi[0];
                                            }
                                        } else {
                                            i6 = i16;
                                            zzagwVar2 = zzagwVar4;
                                            i7 = i29;
                                            zzahlVar = zzahlVar2;
                                            z2 = z4;
                                        }
                                        int[] iArr = zzahxVar5.zzh;
                                        long[] jArr4 = zzahxVar5.zzi;
                                        boolean[] zArr = zzahxVar5.zzj;
                                        int i31 = zzahxVar5.zzg[i22] + i23;
                                        zzahx zzahxVar6 = zzahxVar3;
                                        long j7 = zzahvVar3.zzc;
                                        zzahxVar = zzahxVar6;
                                        long j8 = zzahxVar5.zzp;
                                        while (i23 < i31) {
                                            int iZzf5 = i26 != 0 ? zzfbVar6.zzf() : zzahhVar2.zzb;
                                            zza(iZzf5);
                                            int iZzf6 = i27 != 0 ? zzfbVar6.zzf() : zzahhVar2.zzc;
                                            zza(iZzf6);
                                            if (i28 != 0) {
                                                i8 = i31;
                                                iZzf = zzfbVar6.zzf();
                                            } else {
                                                i8 = i31;
                                                if (i23 != 0) {
                                                    iZzf = zzahhVar2.zzd;
                                                } else if (z2) {
                                                    iZzf = i30;
                                                    i23 = 0;
                                                } else {
                                                    i23 = 0;
                                                    iZzf = zzahhVar2.zzd;
                                                }
                                            }
                                            long jZzr = zzfk.zzr((((long) (i7 != 0 ? zzfbVar6.zzf() : 0)) + j8) - j3, 1000000L, j7);
                                            jArr4[i23] = jZzr;
                                            long j9 = j7;
                                            if (!zzahxVar5.zzq) {
                                                jArr4[i23] = jZzr + zzahlVar.zzd.zzh;
                                            }
                                            iArr[i23] = iZzf6;
                                            zArr[i23] = 1 == (((iZzf >> 16) & 1) ^ 1);
                                            j8 += (long) iZzf5;
                                            i23++;
                                            j7 = j9;
                                            i26 = i26;
                                            i27 = i27;
                                            i31 = i8;
                                            i7 = i7;
                                            zzahhVar2 = zzahhVar2;
                                        }
                                        int i32 = i31;
                                        zzahxVar5.zzp = j8;
                                        i22 = i24;
                                        i23 = i32;
                                    } else {
                                        i21 = i21;
                                        zzahxVar = zzahxVar3;
                                        i6 = i16;
                                        zzagwVar2 = zzagwVar4;
                                        zzahlVar = zzahlVar2;
                                    }
                                    i21++;
                                    list = list;
                                    size3 = size3;
                                    size4 = size4;
                                    zzagwVar3 = zzagwVar3;
                                    bArr4 = bArr4;
                                    i16 = i6;
                                    zzagwVar4 = zzagwVar2;
                                    zzahlVar2 = zzahlVar;
                                    zzahxVar3 = zzahxVar;
                                    i4 = 1953658222;
                                }
                                zzagwVar = zzagwVar3;
                                byte[] bArr5 = bArr4;
                                zzahx zzahxVar7 = zzahxVar3;
                                i = size3;
                                i3 = i16;
                                zzagw zzagwVar5 = zzagwVar4;
                                zzahv zzahvVar4 = zzahlVar2.zzd.zza;
                                zzahh zzahhVar3 = zzahxVar7.zza;
                                Objects.requireNonNull(zzahhVar3);
                                zzahw zzahwVarZza = zzahvVar4.zza(zzahhVar3.zza);
                                zzagx zzagxVarZzb3 = zzagwVar5.zzb(1935763834);
                                if (zzagxVarZzb3 != null) {
                                    Objects.requireNonNull(zzahwVarZza);
                                    zzfb zzfbVar7 = zzagxVarZzb3.zza;
                                    zzfbVar7.zzG(8);
                                    if ((zzfbVar7.zzf() & 1) == 1) {
                                        zzfbVar7.zzH(8);
                                    }
                                    int iZzl = zzfbVar7.zzl();
                                    int iZzo2 = zzfbVar7.zzo();
                                    int i33 = zzahxVar7.zze;
                                    if (iZzo2 > i33) {
                                        throw zzcc.zza("Saiz sample count " + iZzo2 + " is greater than fragment sample count" + i33, null);
                                    }
                                    int i34 = zzahwVarZza.zzd;
                                    if (iZzl == 0) {
                                        boolean[] zArr2 = zzahxVar7.zzl;
                                        i5 = 0;
                                        for (int i35 = 0; i35 < iZzo2; i35++) {
                                            int iZzl2 = zzfbVar7.zzl();
                                            i5 += iZzl2;
                                            zArr2[i35] = iZzl2 > i34;
                                        }
                                        z = false;
                                    } else {
                                        boolean z5 = iZzl > i34;
                                        i5 = iZzl * iZzo2;
                                        z = false;
                                        Arrays.fill(zzahxVar7.zzl, 0, iZzo2, z5);
                                    }
                                    Arrays.fill(zzahxVar7.zzl, iZzo2, zzahxVar7.zze, z);
                                    if (i5 > 0) {
                                        zzahxVar7.zza(i5);
                                    }
                                }
                                zzagx zzagxVarZzb4 = zzagwVar5.zzb(1935763823);
                                if (zzagxVarZzb4 != null) {
                                    zzfb zzfbVar8 = zzagxVarZzb4.zza;
                                    zzfbVar8.zzG(8);
                                    int iZzf7 = zzfbVar8.zzf();
                                    if ((iZzf7 & 1) == 1) {
                                        zzfbVar8.zzH(8);
                                    }
                                    int iZzo3 = zzfbVar8.zzo();
                                    if (iZzo3 != 1) {
                                        throw zzcc.zza("Unexpected saio entry count: " + iZzo3, null);
                                    }
                                    zzahxVar7.zzc += zzagy.zze(iZzf7) == 0 ? zzfbVar8.zzt() : zzfbVar8.zzu();
                                }
                                zzagx zzagxVarZzb5 = zzagwVar5.zzb(1936027235);
                                if (zzagxVarZzb5 != null) {
                                    zzh(zzagxVarZzb5.zza, 0, zzahxVar7);
                                }
                                String str = zzahwVarZza != null ? zzahwVarZza.zzb : null;
                                zzfb zzfbVar9 = null;
                                zzfb zzfbVar10 = null;
                                for (int i36 = 0; i36 < zzagwVar5.zzb.size(); i36++) {
                                    zzagx zzagxVar4 = (zzagx) zzagwVar5.zzb.get(i36);
                                    zzfb zzfbVar11 = zzagxVar4.zza;
                                    int i37 = zzagxVar4.zzd;
                                    if (i37 == 1935828848) {
                                        zzfbVar11.zzG(12);
                                        if (zzfbVar11.zzf() == 1936025959) {
                                            zzfbVar9 = zzfbVar11;
                                        }
                                    } else if (i37 == 1936158820) {
                                        zzfbVar11.zzG(12);
                                        if (zzfbVar11.zzf() == 1936025959) {
                                            zzfbVar10 = zzfbVar11;
                                        }
                                    }
                                }
                                if (zzfbVar9 != null && zzfbVar10 != null) {
                                    zzfbVar9.zzG(8);
                                    int iZze = zzagy.zze(zzfbVar9.zzf());
                                    zzfbVar9.zzH(4);
                                    if (iZze == 1) {
                                        zzfbVar9.zzH(4);
                                    }
                                    if (zzfbVar9.zzf() != 1) {
                                        throw zzcc.zzc("Entry count in sbgp != 1 (unsupported).");
                                    }
                                    zzfbVar10.zzG(8);
                                    int iZze2 = zzagy.zze(zzfbVar10.zzf());
                                    zzfbVar10.zzH(4);
                                    if (iZze2 == 1) {
                                        if (zzfbVar10.zzt() == 0) {
                                            throw zzcc.zzc("Variable length description in sgpd found (unsupported)");
                                        }
                                    } else if (iZze2 >= 2) {
                                        zzfbVar10.zzH(4);
                                    }
                                    if (zzfbVar10.zzt() != 1) {
                                        throw zzcc.zzc("Entry count in sgpd != 1 (unsupported).");
                                    }
                                    zzfbVar10.zzH(1);
                                    int iZzl3 = zzfbVar10.zzl();
                                    int i38 = (iZzl3 & 240) >> 4;
                                    int i39 = iZzl3 & 15;
                                    if (zzfbVar10.zzl() == 1) {
                                        int iZzl4 = zzfbVar10.zzl();
                                        byte[] bArr6 = new byte[16];
                                        zzfbVar10.zzC(bArr6, 0, 16);
                                        if (iZzl4 == 0) {
                                            int iZzl5 = zzfbVar10.zzl();
                                            byte[] bArr7 = new byte[iZzl5];
                                            zzfbVar10.zzC(bArr7, 0, iZzl5);
                                            bArr3 = bArr7;
                                        } else {
                                            bArr3 = null;
                                        }
                                        zzahxVar7.zzk = true;
                                        zzahxVar7.zzm = new zzahw(true, str, iZzl4, bArr6, i38, i39, bArr3);
                                    }
                                }
                                int size5 = zzagwVar5.zzb.size();
                                int i40 = 0;
                                while (i40 < size5) {
                                    zzagx zzagxVar5 = (zzagx) zzagwVar5.zzb.get(i40);
                                    if (zzagxVar5.zzd == 1970628964) {
                                        zzfb zzfbVar12 = zzagxVar5.zza;
                                        zzfbVar12.zzG(8);
                                        bArr2 = bArr5;
                                        zzfbVar12.zzC(bArr2, 0, 16);
                                        if (Arrays.equals(bArr2, zzb)) {
                                            zzh(zzfbVar12, 16, zzahxVar7);
                                        }
                                    } else {
                                        bArr2 = bArr5;
                                    }
                                    i40++;
                                    bArr5 = bArr2;
                                }
                                bArr = bArr5;
                                i2 = 8;
                            }
                        } else {
                            sparseArray = sparseArray3;
                            zzagwVar = zzagwVar3;
                            i = size3;
                            i2 = i11;
                            i3 = i16;
                            bArr = bArr4;
                        }
                        i11 = i2;
                        bArr4 = bArr;
                        size3 = i;
                        zzagwVar3 = zzagwVar;
                        i16 = i3 + 1;
                        sparseArray3 = sparseArray;
                    }
                    zzad zzadVarZzf2 = zzf(zzagwVar3.zzb);
                    zzahmVar = this;
                    if (zzadVarZzf2 != null) {
                        int size6 = zzahmVar.zze.size();
                        for (int i41 = 0; i41 < size6; i41++) {
                            zzahl zzahlVar3 = (zzahl) zzahmVar.zze.valueAt(i41);
                            zzahv zzahvVar5 = zzahlVar3.zzd.zza;
                            zzahh zzahhVar4 = zzahlVar3.zzb.zza;
                            int i42 = zzfk.zza;
                            zzahw zzahwVarZza2 = zzahvVar5.zza(zzahhVar4.zza);
                            zzad zzadVarZzb = zzadVarZzf2.zzb(zzahwVarZza2 != null ? zzahwVarZza2.zzb : null);
                            zzak zzakVarZzb = zzahlVar3.zzd.zza.zzf.zzb();
                            zzakVarZzb.zzD(zzadVarZzb);
                            zzahlVar3.zza.zzl(zzakVarZzb.zzac());
                        }
                    }
                    if (zzahmVar.zzv != -9223372036854775807L) {
                        int size7 = zzahmVar.zze.size();
                        for (int i43 = 0; i43 < size7; i43++) {
                            zzahl zzahlVar4 = (zzahl) zzahmVar.zze.valueAt(i43);
                            long j10 = zzahmVar.zzv;
                            int i44 = zzahlVar4.zzf;
                            while (true) {
                                zzahx zzahxVar8 = zzahlVar4.zzb;
                                if (i44 >= zzahxVar8.zze || zzahxVar8.zzi[i44] > j10) {
                                    break;
                                }
                                if (zzahxVar8.zzj[i44]) {
                                    zzahlVar4.zzi = i44;
                                }
                                i44++;
                            }
                        }
                        zzahmVar.zzv = -9223372036854775807L;
                    }
                } else {
                    zzahmVar = zzahmVar2;
                    if (!zzahmVar.zzm.isEmpty()) {
                        ((zzagw) zzahmVar.zzm.peek()).zzc(zzagwVar3);
                    }
                }
                zzahmVar2 = zzahmVar;
            }
        }
        zzg();
    }

    private static final zzahh zzj(SparseArray sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return (zzahh) sparseArray.valueAt(0);
        }
        zzahh zzahhVar = (zzahh) sparseArray.get(i);
        Objects.requireNonNull(zzahhVar);
        return zzahhVar;
    }

    /* JADX WARN: Code duplicated, block: B:86:0x01c1  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzabm
    public final int zzb(zzabn zzabnVar, zzacj zzacjVar) throws IOException {
        int i;
        ?? r9;
        zzahl zzahlVar;
        int iZzf;
        boolean z;
        int iZzc;
        long jZzr;
        long jZzt;
        String str;
        String str2;
        long j;
        long j2;
        long jZzu;
        long jZzu2;
        zzabn zzabnVar2 = zzabnVar;
        while (true) {
            int i2 = this.zzo;
            i = 1;
            r9 = 0;
            if (i2 == 0) {
                if (this.zzr == 0) {
                    if (!zzabnVar2.zzn(this.zzl.zzI(), 0, 8, true)) {
                        return -1;
                    }
                    this.zzr = 8;
                    this.zzl.zzG(0);
                    this.zzq = this.zzl.zzt();
                    this.zzp = this.zzl.zzf();
                }
                long j3 = this.zzq;
                if (j3 == 1) {
                    ((zzabc) zzabnVar2).zzn(this.zzl.zzI(), 8, 8, false);
                    this.zzr += 8;
                    this.zzq = this.zzl.zzu();
                } else if (j3 == 0) {
                    long jZzd = zzabnVar.zzd();
                    if (jZzd == -1) {
                        jZzd = !this.zzm.isEmpty() ? ((zzagw) this.zzm.peek()).zza : -1L;
                    }
                    if (jZzd != -1) {
                        this.zzq = (jZzd - zzabnVar.zzf()) + ((long) this.zzr);
                    }
                }
                long j4 = this.zzq;
                long j5 = this.zzr;
                if (j4 < j5) {
                    throw zzcc.zzc("Atom size less than header length (unsupported).");
                }
                long jZzf = zzabnVar.zzf() - j5;
                int i3 = this.zzp;
                if ((i3 == 1836019558 || i3 == 1835295092) && !this.zzG) {
                    this.zzD.zzO(new zzacl(this.zzw, jZzf));
                    this.zzG = true;
                }
                if (this.zzp == 1836019558) {
                    int size = this.zze.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        zzahx zzahxVar = ((zzahl) this.zze.valueAt(i4)).zzb;
                        zzahxVar.zzc = jZzf;
                        zzahxVar.zzb = jZzf;
                    }
                }
                int i5 = this.zzp;
                if (i5 == 1835295092) {
                    this.zzy = null;
                    this.zzt = jZzf + this.zzq;
                    this.zzo = 2;
                } else if (i5 == 1836019574 || i5 == 1953653099 || i5 == 1835297121 || i5 == 1835626086 || i5 == 1937007212 || i5 == 1836019558 || i5 == 1953653094 || i5 == 1836475768 || i5 == 1701082227) {
                    long jZzf2 = (zzabnVar.zzf() + this.zzq) - 8;
                    this.zzm.push(new zzagw(i5, jZzf2));
                    if (this.zzq == this.zzr) {
                        zzi(jZzf2);
                    } else {
                        zzg();
                    }
                } else if (i5 == 1751411826 || i5 == 1835296868 || i5 == 1836476516 || i5 == 1936286840 || i5 == 1937011556 || i5 == 1937011827 || i5 == 1668576371 || i5 == 1937011555 || i5 == 1937011578 || i5 == 1937013298 || i5 == 1937007471 || i5 == 1668232756 || i5 == 1937011571 || i5 == 1952867444 || i5 == 1952868452 || i5 == 1953196132 || i5 == 1953654136 || i5 == 1953658222 || i5 == 1886614376 || i5 == 1935763834 || i5 == 1935763823 || i5 == 1936027235 || i5 == 1970628964 || i5 == 1935828848 || i5 == 1936158820 || i5 == 1701606260 || i5 == 1835362404 || i5 == 1701671783) {
                    if (this.zzr != 8) {
                        throw zzcc.zzc("Leaf atom defines extended atom size (unsupported).");
                    }
                    if (this.zzq > 2147483647L) {
                        throw zzcc.zzc("Leaf atom with length > 2147483647 (unsupported).");
                    }
                    zzfb zzfbVar = new zzfb((int) this.zzq);
                    System.arraycopy(this.zzl.zzI(), 0, zzfbVar.zzI(), 0, 8);
                    this.zzs = zzfbVar;
                    this.zzo = 1;
                } else {
                    if (this.zzq > 2147483647L) {
                        throw zzcc.zzc("Skipping atom with length > 2147483647 (unsupported).");
                    }
                    this.zzs = null;
                    this.zzo = 1;
                }
            } else if (i2 != 1) {
                long j6 = Long.MAX_VALUE;
                if (i2 != 2) {
                    zzahlVar = this.zzy;
                    if (zzahlVar != null) {
                        break;
                    }
                    SparseArray sparseArray = this.zze;
                    int size2 = sparseArray.size();
                    long j7 = Long.MAX_VALUE;
                    zzahl zzahlVar2 = null;
                    for (int i6 = 0; i6 < size2; i6++) {
                        zzahl zzahlVar3 = (zzahl) sparseArray.valueAt(i6);
                        if ((zzahlVar3.zzl || zzahlVar3.zzf != zzahlVar3.zzd.zzb) && (!zzahlVar3.zzl || zzahlVar3.zzh != zzahlVar3.zzb.zzd)) {
                            long jZzd2 = zzahlVar3.zzd();
                            if (jZzd2 < j7) {
                                zzahlVar2 = zzahlVar3;
                                j7 = jZzd2;
                            }
                        }
                    }
                    if (zzahlVar2 != null) {
                        int iZzd = (int) (zzahlVar2.zzd() - zzabnVar.zzf());
                        if (iZzd < 0) {
                            zzer.zzf("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                            iZzd = 0;
                        }
                        ((zzabc) zzabnVar2).zzo(iZzd, false);
                        this.zzy = zzahlVar2;
                        zzahlVar = zzahlVar2;
                        break;
                    }
                    int iZzf2 = (int) (this.zzt - zzabnVar.zzf());
                    if (iZzf2 < 0) {
                        throw zzcc.zza("Offset to end of mdat was negative.", null);
                    }
                    ((zzabc) zzabnVar2).zzo(iZzf2, false);
                    zzg();
                } else {
                    int size3 = this.zze.size();
                    zzahl zzahlVar4 = null;
                    for (int i7 = 0; i7 < size3; i7++) {
                        zzahx zzahxVar2 = ((zzahl) this.zze.valueAt(i7)).zzb;
                        if (zzahxVar2.zzo) {
                            long j8 = zzahxVar2.zzc;
                            if (j8 < j6) {
                                zzahlVar4 = (zzahl) this.zze.valueAt(i7);
                                j6 = j8;
                            }
                        }
                    }
                    if (zzahlVar4 == null) {
                        this.zzo = 3;
                    } else {
                        int iZzf3 = (int) (j6 - zzabnVar.zzf());
                        if (iZzf3 < 0) {
                            throw zzcc.zza("Offset to encryption data was negative.", null);
                        }
                        zzabc zzabcVar = (zzabc) zzabnVar2;
                        zzabcVar.zzo(iZzf3, false);
                        zzahx zzahxVar3 = zzahlVar4.zzb;
                        zzfb zzfbVar2 = zzahxVar3.zzn;
                        zzabcVar.zzn(zzfbVar2.zzI(), 0, zzfbVar2.zzd(), false);
                        zzahxVar3.zzn.zzG(0);
                        zzahxVar3.zzo = false;
                    }
                }
            } else {
                int i8 = ((int) this.zzq) - this.zzr;
                zzfb zzfbVar3 = this.zzs;
                if (zzfbVar3 != null) {
                    ((zzabc) zzabnVar2).zzn(zzfbVar3.zzI(), 8, i8, false);
                    zzagx zzagxVar = new zzagx(this.zzp, zzfbVar3);
                    long jZzf3 = zzabnVar.zzf();
                    if (this.zzm.isEmpty()) {
                        int i9 = zzagxVar.zzd;
                        if (i9 == 1936286840) {
                            zzfb zzfbVar4 = zzagxVar.zza;
                            zzfbVar4.zzG(8);
                            int iZze = zzagy.zze(zzfbVar4.zzf());
                            zzfbVar4.zzH(4);
                            long jZzt2 = zzfbVar4.zzt();
                            if (iZze == 0) {
                                jZzu = zzfbVar4.zzt();
                                jZzu2 = zzfbVar4.zzt();
                            } else {
                                jZzu = zzfbVar4.zzu();
                                jZzu2 = zzfbVar4.zzu();
                            }
                            long j9 = jZzf3 + jZzu2;
                            long jZzr2 = zzfk.zzr(jZzu, 1000000L, jZzt2);
                            zzfbVar4.zzH(2);
                            int iZzp = zzfbVar4.zzp();
                            int[] iArr = new int[iZzp];
                            long[] jArr = new long[iZzp];
                            long[] jArr2 = new long[iZzp];
                            long[] jArr3 = new long[iZzp];
                            long jZzr3 = jZzr2;
                            int i10 = 0;
                            while (i10 < iZzp) {
                                int iZzf4 = zzfbVar4.zzf();
                                if ((iZzf4 & Integer.MIN_VALUE) != 0) {
                                    throw zzcc.zza("Unhandled indirect reference", null);
                                }
                                long jZzt3 = zzfbVar4.zzt();
                                iArr[i10] = iZzf4 & Integer.MAX_VALUE;
                                jArr[i10] = j9;
                                jArr3[i10] = jZzr3;
                                long j10 = jZzu + jZzt3;
                                long[] jArr4 = jArr3;
                                int i11 = i10;
                                long[] jArr5 = jArr2;
                                int[] iArr2 = iArr;
                                jZzr3 = zzfk.zzr(j10, 1000000L, jZzt2);
                                jArr5[i11] = jZzr3 - jArr4[i11];
                                zzfbVar4.zzH(4);
                                j9 += (long) iArr2[i11];
                                i10 = i11 + 1;
                                iArr = iArr2;
                                jArr = jArr;
                                jArr2 = jArr5;
                                jArr3 = jArr4;
                                iZzp = iZzp;
                                jZzu = j10;
                            }
                            Pair pairCreate = Pair.create(Long.valueOf(jZzr2), new zzaba(iArr, jArr, jArr2, jArr3));
                            this.zzx = ((Long) pairCreate.first).longValue();
                            this.zzD.zzO((zzacm) pairCreate.second);
                            this.zzG = true;
                        } else if (i9 == 1701671783) {
                            zzfb zzfbVar5 = zzagxVar.zza;
                            if (this.zzE.length != 0) {
                                zzfbVar5.zzG(8);
                                int iZze2 = zzagy.zze(zzfbVar5.zzf());
                                if (iZze2 == 0) {
                                    String strZzw = zzfbVar5.zzw((char) 0);
                                    Objects.requireNonNull(strZzw);
                                    String strZzw2 = zzfbVar5.zzw((char) 0);
                                    Objects.requireNonNull(strZzw2);
                                    long jZzt4 = zzfbVar5.zzt();
                                    long jZzr4 = zzfk.zzr(zzfbVar5.zzt(), 1000000L, jZzt4);
                                    long j11 = this.zzx;
                                    long j12 = j11 != -9223372036854775807L ? j11 + jZzr4 : -9223372036854775807L;
                                    jZzr = zzfk.zzr(zzfbVar5.zzt(), 1000L, jZzt4);
                                    jZzt = zzfbVar5.zzt();
                                    str = strZzw;
                                    str2 = strZzw2;
                                    j = jZzr4;
                                    j2 = j12;
                                } else if (iZze2 != 1) {
                                    zzer.zzf("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + iZze2);
                                } else {
                                    long jZzt5 = zzfbVar5.zzt();
                                    long jZzr5 = zzfk.zzr(zzfbVar5.zzu(), 1000000L, jZzt5);
                                    long jZzr6 = zzfk.zzr(zzfbVar5.zzt(), 1000L, jZzt5);
                                    long jZzt6 = zzfbVar5.zzt();
                                    String strZzw3 = zzfbVar5.zzw((char) 0);
                                    Objects.requireNonNull(strZzw3);
                                    String strZzw4 = zzfbVar5.zzw((char) 0);
                                    Objects.requireNonNull(strZzw4);
                                    jZzr = jZzr6;
                                    jZzt = jZzt6;
                                    str = strZzw3;
                                    str2 = strZzw4;
                                    j = -9223372036854775807L;
                                    j2 = jZzr5;
                                }
                                byte[] bArr = new byte[zzfbVar5.zza()];
                                zzfbVar5.zzC(bArr, 0, zzfbVar5.zza());
                                zzfb zzfbVar6 = new zzfb(this.zzk.zza(new zzaej(str, str2, jZzr, jZzt, bArr)));
                                int iZza = zzfbVar6.zza();
                                for (zzacs zzacsVar : this.zzE) {
                                    zzfbVar6.zzG(0);
                                    zzacsVar.zzr(zzfbVar6, iZza);
                                }
                                if (j2 == -9223372036854775807L) {
                                    this.zzn.addLast(new zzahk(j, true, iZza));
                                    this.zzu += iZza;
                                } else if (this.zzn.isEmpty()) {
                                    for (zzacs zzacsVar2 : this.zzE) {
                                        zzacsVar2.zzt(j2, 1, iZza, 0, null);
                                    }
                                } else {
                                    this.zzn.addLast(new zzahk(j2, false, iZza));
                                    this.zzu += iZza;
                                }
                            }
                        }
                        zzabnVar2 = zzabnVar;
                    } else {
                        ((zzagw) this.zzm.peek()).zzd(zzagxVar);
                    }
                } else {
                    ((zzabc) zzabnVar2).zzo(i8, false);
                }
                zzi(zzabnVar.zzf());
            }
        }
        int i12 = 6;
        if (this.zzo == 3) {
            int iZzb = zzahlVar.zzb();
            this.zzz = iZzb;
            if (zzahlVar.zzf < zzahlVar.zzi) {
                ((zzabc) zzabnVar2).zzo(iZzb, false);
                zzahw zzahwVarZzf = zzahlVar.zzf();
                if (zzahwVarZzf != null) {
                    zzfb zzfbVar7 = zzahlVar.zzb.zzn;
                    int i13 = zzahwVarZzf.zzd;
                    if (i13 != 0) {
                        zzfbVar7.zzH(i13);
                    }
                    if (zzahlVar.zzb.zzb(zzahlVar.zzf)) {
                        zzfbVar7.zzH(zzfbVar7.zzp() * 6);
                    }
                }
                if (!zzahlVar.zzk()) {
                    this.zzy = null;
                }
                this.zzo = 3;
                return 0;
            }
            if (zzahlVar.zzd.zza.zzg == 1) {
                this.zzz = iZzb - 8;
                ((zzabc) zzabnVar2).zzo(8, false);
            }
            if ("audio/ac4".equals(zzahlVar.zzd.zza.zzf.zzm)) {
                this.zzA = zzahlVar.zzc(this.zzz, 7);
                zzaaq.zzb(this.zzz, this.zzj);
                zzahlVar.zza.zzr(this.zzj, 7);
                iZzc = this.zzA + 7;
                this.zzA = iZzc;
            } else {
                iZzc = zzahlVar.zzc(this.zzz, 0);
                this.zzA = iZzc;
            }
            this.zzz += iZzc;
            this.zzo = 4;
            this.zzB = 0;
        }
        zzahv zzahvVar = zzahlVar.zzd.zza;
        zzacs zzacsVar3 = zzahlVar.zza;
        long jZze = zzahlVar.zze();
        int i14 = zzahvVar.zzj;
        if (i14 == 0) {
            while (true) {
                int i15 = this.zzA;
                int i16 = this.zzz;
                if (i15 >= i16) {
                    break;
                }
                this.zzA += zzacsVar3.zzf(zzabnVar2, i16 - i15, false);
            }
        } else {
            byte[] bArrZzI = this.zzg.zzI();
            bArrZzI[0] = 0;
            bArrZzI[1] = 0;
            bArrZzI[2] = 0;
            int i17 = i14 + 1;
            int i18 = 4 - i14;
            while (this.zzA < this.zzz) {
                int i19 = this.zzB;
                if (i19 == 0) {
                    ((zzabc) zzabnVar2).zzn(bArrZzI, i18, i17, r9);
                    this.zzg.zzG(r9);
                    int iZzf5 = this.zzg.zzf();
                    if (iZzf5 <= 0) {
                        throw zzcc.zza("Invalid NAL length", null);
                    }
                    this.zzB = iZzf5 - 1;
                    this.zzf.zzG(r9);
                    zzacsVar3.zzr(this.zzf, 4);
                    zzacsVar3.zzr(this.zzg, i);
                    if (this.zzF.length > 0) {
                        String str3 = zzahvVar.zzf.zzm;
                        int i20 = bArrZzI[4];
                        byte[] bArr2 = zzfy.zza;
                        if (("video/avc".equals(str3) && (i20 & 31) == i12) || ("video/hevc".equals(str3) && ((i20 & 126) >> i) == 39)) {
                            z = i;
                        } else {
                            z = 0;
                        }
                    } else {
                        z = 0;
                    }
                    this.zzC = z;
                    this.zzA += 5;
                    this.zzz += i18;
                } else {
                    if (this.zzC) {
                        this.zzh.zzD(i19);
                        ((zzabc) zzabnVar2).zzn(this.zzh.zzI(), 0, this.zzB, false);
                        zzacsVar3.zzr(this.zzh, this.zzB);
                        iZzf = this.zzB;
                        zzfb zzfbVar8 = this.zzh;
                        int iZzb2 = zzfy.zzb(zzfbVar8.zzI(), zzfbVar8.zzd());
                        this.zzh.zzG("video/hevc".equals(zzahvVar.zzf.zzm) ? 1 : 0);
                        this.zzh.zzF(iZzb2);
                        zzaaz.zza(jZze, this.zzh, this.zzF);
                    } else {
                        iZzf = zzacsVar3.zzf(zzabnVar2, i19, false);
                    }
                    this.zzA += iZzf;
                    this.zzB -= iZzf;
                    i12 = 6;
                    i = 1;
                }
                r9 = 0;
            }
        }
        int iZza2 = zzahlVar.zza();
        zzahw zzahwVarZzf2 = zzahlVar.zzf();
        zzacsVar3.zzt(jZze, iZza2, this.zzz, 0, zzahwVarZzf2 != null ? zzahwVarZzf2.zzc : null);
        while (!this.zzn.isEmpty()) {
            zzahk zzahkVar = (zzahk) this.zzn.removeFirst();
            this.zzu -= zzahkVar.zzc;
            long j13 = zzahkVar.zza;
            if (zzahkVar.zzb) {
                j13 += jZze;
            }
            for (zzacs zzacsVar4 : this.zzE) {
                zzacsVar4.zzt(j13, 1, zzahkVar.zzc, this.zzu, null);
            }
        }
        if (!zzahlVar.zzk()) {
            this.zzy = null;
        }
        this.zzo = 3;
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzc(zzabp zzabpVar) {
        this.zzD = zzabpVar;
        zzg();
        zzacs[] zzacsVarArr = new zzacs[2];
        this.zzE = zzacsVarArr;
        int i = 0;
        zzacs[] zzacsVarArr2 = (zzacs[]) zzfk.zzJ(zzacsVarArr, 0);
        this.zzE = zzacsVarArr2;
        for (zzacs zzacsVar : zzacsVarArr2) {
            zzacsVar.zzl(zzc);
        }
        this.zzF = new zzacs[this.zzd.size()];
        int i2 = 100;
        while (i < this.zzF.length) {
            int i3 = i2 + 1;
            zzacs zzacsVarZzw = this.zzD.zzw(i2, 3);
            zzacsVarZzw.zzl((zzam) this.zzd.get(i));
            this.zzF[i] = zzacsVarZzw;
            i++;
            i2 = i3;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzd(long j, long j2) {
        int size = this.zze.size();
        for (int i = 0; i < size; i++) {
            ((zzahl) this.zze.valueAt(i)).zzi();
        }
        this.zzn.clear();
        this.zzu = 0;
        this.zzv = j2;
        this.zzm.clear();
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final boolean zze(zzabn zzabnVar) throws IOException {
        return zzahu.zza(zzabnVar);
    }

    public zzahm(int i, zzfi zzfiVar) {
        this.zzd = Collections.unmodifiableList(Collections.emptyList());
        this.zzk = new zzaek();
        this.zzl = new zzfb(16);
        this.zzf = new zzfb(zzfy.zza);
        this.zzg = new zzfb(5);
        this.zzh = new zzfb();
        byte[] bArr = new byte[16];
        this.zzi = bArr;
        this.zzj = new zzfb(bArr);
        this.zzm = new ArrayDeque();
        this.zzn = new ArrayDeque();
        this.zze = new SparseArray();
        this.zzw = -9223372036854775807L;
        this.zzv = -9223372036854775807L;
        this.zzx = -9223372036854775807L;
        this.zzD = zzabp.zza;
        this.zzE = new zzacs[0];
        this.zzF = new zzacs[0];
    }
}
