package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.unity3d.services.core.device.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzahg {
    private static final byte[] zza;

    static {
        int i = zzfk.zza;
        zza = "OpusHead".getBytes(zzfsi.zzc);
    }

    public static zzby zza(zzagw zzagwVar) {
        zzfo zzfoVar;
        zzagx zzagxVarZzb = zzagwVar.zzb(1751411826);
        zzagx zzagxVarZzb2 = zzagwVar.zzb(1801812339);
        zzagx zzagxVarZzb3 = zzagwVar.zzb(1768715124);
        if (zzagxVarZzb == null || zzagxVarZzb2 == null || zzagxVarZzb3 == null || zzh(zzagxVarZzb.zza) != 1835299937) {
            return null;
        }
        zzfb zzfbVar = zzagxVarZzb2.zza;
        zzfbVar.zzG(12);
        int iZzf = zzfbVar.zzf();
        String[] strArr = new String[iZzf];
        for (int i = 0; i < iZzf; i++) {
            int iZzf2 = zzfbVar.zzf();
            zzfbVar.zzH(4);
            strArr[i] = zzfbVar.zzy(iZzf2 - 8, zzfsi.zzc);
        }
        zzfb zzfbVar2 = zzagxVarZzb3.zza;
        zzfbVar2.zzG(8);
        ArrayList arrayList = new ArrayList();
        while (zzfbVar2.zza() > 8) {
            int iZzc = zzfbVar2.zzc() + zzfbVar2.zzf();
            int iZzf3 = zzfbVar2.zzf() - 1;
            if (iZzf3 < 0 || iZzf3 >= iZzf) {
                zzer.zzf("AtomParsers", "Skipped metadata with unknown key index: " + iZzf3);
            } else {
                String str = strArr[iZzf3];
                int i2 = zzahn.zzb;
                while (true) {
                    int iZzc2 = zzfbVar2.zzc();
                    if (iZzc2 >= iZzc) {
                        zzfoVar = null;
                        break;
                    }
                    int iZzf4 = zzfbVar2.zzf();
                    if (zzfbVar2.zzf() == 1684108385) {
                        int iZzf5 = zzfbVar2.zzf();
                        int iZzf6 = zzfbVar2.zzf();
                        int i3 = iZzf4 - 16;
                        byte[] bArr = new byte[i3];
                        zzfbVar2.zzC(bArr, 0, i3);
                        zzfoVar = new zzfo(str, bArr, iZzf6, iZzf5);
                        break;
                    }
                    zzfbVar2.zzG(iZzc2 + iZzf4);
                }
                if (zzfoVar != null) {
                    arrayList.add(zzfoVar);
                }
            }
            zzfbVar2.zzG(iZzc);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzby(arrayList);
    }

    public static zzby zzb(zzagx zzagxVar) {
        zzfb zzfbVar = zzagxVar.zza;
        zzfbVar.zzG(8);
        zzby zzbyVar = new zzby(-9223372036854775807L, new zzbx[0]);
        while (zzfbVar.zza() >= 8) {
            int iZzc = zzfbVar.zzc();
            int iZzf = zzfbVar.zzf() + iZzc;
            int iZzf2 = zzfbVar.zzf();
            zzby zzbyVar2 = null;
            if (iZzf2 == 1835365473) {
                zzfbVar.zzG(iZzc);
                zzfbVar.zzH(8);
                zze(zzfbVar);
                while (zzfbVar.zzc() < iZzf) {
                    int iZzc2 = zzfbVar.zzc();
                    int iZzf3 = zzfbVar.zzf() + iZzc2;
                    if (zzfbVar.zzf() == 1768715124) {
                        zzfbVar.zzG(iZzc2);
                        zzfbVar.zzH(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzfbVar.zzc() < iZzf3) {
                            zzbx zzbxVarZza = zzahn.zza(zzfbVar);
                            if (zzbxVarZza != null) {
                                arrayList.add(zzbxVarZza);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            zzbyVar2 = new zzby(arrayList);
                            break;
                        }
                        break;
                    }
                    zzfbVar.zzG(iZzf3);
                }
                zzbyVar = zzbyVar.zzd(zzbyVar2);
            } else if (iZzf2 == 1936553057) {
                zzfbVar.zzG(iZzc);
                zzfbVar.zzH(12);
                while (zzfbVar.zzc() < iZzf) {
                    int iZzc3 = zzfbVar.zzc();
                    int iZzf4 = zzfbVar.zzf();
                    if (zzfbVar.zzf() == 1935766900) {
                        if (iZzf4 < 14) {
                            break;
                        }
                        zzfbVar.zzH(5);
                        int iZzl = zzfbVar.zzl();
                        float f = 120.0f;
                        if (iZzl != 12) {
                            if (iZzl != 13) {
                                break;
                            }
                            break;
                        }
                        if (iZzl == 12) {
                            f = 240.0f;
                        }
                        zzfbVar.zzH(1);
                        zzbyVar2 = new zzby(-9223372036854775807L, new zzafx(f, zzfbVar.zzl()));
                        break;
                    }
                    zzfbVar.zzG(iZzc3 + iZzf4);
                }
                zzbyVar = zzbyVar.zzd(zzbyVar2);
            } else if (iZzf2 == -1451722374) {
                zzbyVar = zzbyVar.zzd(zzl(zzfbVar));
            }
            zzfbVar.zzG(iZzf);
        }
        return zzbyVar;
    }

    public static zzfu zzc(zzfb zzfbVar) {
        long jZzs;
        long jZzs2;
        zzfbVar.zzG(8);
        if (zzagy.zze(zzfbVar.zzf()) == 0) {
            jZzs = zzfbVar.zzt();
            jZzs2 = zzfbVar.zzt();
        } else {
            jZzs = zzfbVar.zzs();
            jZzs2 = zzfbVar.zzs();
        }
        return new zzfu(jZzs, jZzs2, zzfbVar.zzt());
    }

    /* JADX WARN: Code duplicated, block: B:353:0x0749  */
    /* JADX WARN: Code duplicated, block: B:354:0x074b  */
    /* JADX WARN: Code duplicated, block: B:383:0x081a  */
    /* JADX WARN: Code duplicated, block: B:398:0x08c0  */
    /* JADX WARN: Code duplicated, block: B:400:0x08e7  */
    /* JADX WARN: Code duplicated, block: B:401:0x08ef  */
    /* JADX WARN: Code duplicated, block: B:403:0x08f8  */
    /* JADX WARN: Code duplicated, block: B:406:0x0903  */
    /* JADX WARN: Code duplicated, block: B:408:0x0919  */
    /* JADX WARN: Code duplicated, block: B:410:0x0922  */
    /* JADX WARN: Code duplicated, block: B:411:0x092f  */
    /* JADX WARN: Code duplicated, block: B:414:0x094e  */
    /* JADX WARN: Code duplicated, block: B:415:0x0951  */
    /* JADX WARN: Code duplicated, block: B:418:0x095b  */
    /* JADX WARN: Code duplicated, block: B:419:0x095e  */
    /* JADX WARN: Code duplicated, block: B:422:0x097e  */
    /* JADX WARN: Code duplicated, block: B:423:0x0986  */
    /* JADX WARN: Code duplicated, block: B:425:0x0989  */
    /* JADX WARN: Code duplicated, block: B:427:0x0992  */
    /* JADX WARN: Code duplicated, block: B:428:0x0998  */
    /* JADX WARN: Code duplicated, block: B:429:0x099b  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:456:0x0a4b A[PHI: r8
      0x0a4b: PHI (r8v45 int) = (r8v44 int), (r8v44 int), (r8v72 int), (r8v44 int) binds: [B:431:0x09a8, B:438:0x09c2, B:455:0x0a4a, B:437:0x09c0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:458:0x0a6a  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:460:0x0a70  */
    /* JADX WARN: Code duplicated, block: B:462:0x0a76 A[LOOP:11: B:459:0x0a6e->B:462:0x0a76, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:467:0x0ab5  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:470:0x0aba A[ADDED_TO_REGION, LOOP:12: B:470:0x0aba->B:472:0x0abe, LOOP_START, PHI: r14 r19 r21
      0x0aba: PHI (r14v40 int) = (r14v37 int), (r14v41 int) binds: [B:468:0x0ab7, B:472:0x0abe] A[DONT_GENERATE, DONT_INLINE]
      0x0aba: PHI (r19v11 int) = (r19v9 int), (r19v15 int) binds: [B:468:0x0ab7, B:472:0x0abe] A[DONT_GENERATE, DONT_INLINE]
      0x0aba: PHI (r21v14 int) = (r21v10 int), (r21v15 int) binds: [B:468:0x0ab7, B:472:0x0abe] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:471:0x0abc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:472:0x0abe A[LOOP:12: B:470:0x0aba->B:472:0x0abe, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:478:0x0ada  */
    /* JADX WARN: Code duplicated, block: B:479:0x0ade  */
    /* JADX WARN: Code duplicated, block: B:47:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:482:0x0ae8  */
    /* JADX WARN: Code duplicated, block: B:483:0x0aea  */
    /* JADX WARN: Code duplicated, block: B:486:0x0af1  */
    /* JADX WARN: Code duplicated, block: B:488:0x0af8  */
    /* JADX WARN: Code duplicated, block: B:48:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:491:0x0b0b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:492:0x0b0d  */
    /* JADX WARN: Code duplicated, block: B:493:0x0b1d  */
    /* JADX WARN: Code duplicated, block: B:494:0x0b20  */
    /* JADX WARN: Code duplicated, block: B:499:0x0b4c A[DONT_INVERT, LOOP:13: B:499:0x0b4c->B:503:0x0b56, LOOP_START, PHI: r21
      0x0b4c: PHI (r21v11 int) = (r21v10 int), (r21v12 int) binds: [B:498:0x0b4a, B:503:0x0b56] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:49:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:500:0x0b4e  */
    /* JADX WARN: Code duplicated, block: B:503:0x0b56 A[LOOP:13: B:499:0x0b4c->B:503:0x0b56, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:504:0x0b5c A[EDGE_INSN: B:504:0x0b5c->B:505:0x0b5d BREAK  A[LOOP:13: B:499:0x0b4c->B:503:0x0b56]] */
    /* JADX WARN: Code duplicated, block: B:506:0x0b5f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:507:0x0b61 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:508:0x0b63 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:509:0x0b65 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x0103  */
    /* JADX WARN: Code duplicated, block: B:510:0x0b67 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:511:0x0b69  */
    /* JADX WARN: Code duplicated, block: B:512:0x0b74  */
    /* JADX WARN: Code duplicated, block: B:513:0x0b7e  */
    /* JADX WARN: Code duplicated, block: B:514:0x0b8a  */
    /* JADX WARN: Code duplicated, block: B:515:0x0b97  */
    /* JADX WARN: Code duplicated, block: B:516:0x0ba5  */
    /* JADX WARN: Code duplicated, block: B:517:0x0bb2  */
    /* JADX WARN: Code duplicated, block: B:521:0x0bff  */
    /* JADX WARN: Code duplicated, block: B:522:0x0c02  */
    /* JADX WARN: Code duplicated, block: B:527:0x0c25  */
    /* JADX WARN: Code duplicated, block: B:528:0x0c3d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0107  */
    /* JADX WARN: Code duplicated, block: B:547:0x0cd7  */
    /* JADX WARN: Code duplicated, block: B:549:0x0cdd  */
    /* JADX WARN: Code duplicated, block: B:551:0x0ce6  */
    /* JADX WARN: Code duplicated, block: B:554:0x0cf1 A[LOOP:5: B:552:0x0cee->B:554:0x0cf1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:556:0x0d22  */
    /* JADX WARN: Code duplicated, block: B:557:0x0d23 A[PHI: r7
      0x0d23: PHI (r7v48 int A[IMMUTABLE_TYPE]) = (r7v47 int), (r7v59 int) binds: [B:548:0x0cdb, B:556:0x0d22] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:559:0x0d28  */
    /* JADX WARN: Code duplicated, block: B:560:0x0d2a  */
    /* JADX WARN: Code duplicated, block: B:564:0x0d3f  */
    /* JADX WARN: Code duplicated, block: B:566:0x0d4a  */
    /* JADX WARN: Code duplicated, block: B:569:0x0d74  */
    /* JADX WARN: Code duplicated, block: B:574:0x0d86  */
    /* JADX WARN: Code duplicated, block: B:575:0x0d88  */
    /* JADX WARN: Code duplicated, block: B:577:0x0d8d  */
    /* JADX WARN: Code duplicated, block: B:581:0x0daa  */
    /* JADX WARN: Code duplicated, block: B:582:0x0dac  */
    /* JADX WARN: Code duplicated, block: B:585:0x0db1  */
    /* JADX WARN: Code duplicated, block: B:586:0x0db5  */
    /* JADX WARN: Code duplicated, block: B:588:0x0db9  */
    /* JADX WARN: Code duplicated, block: B:589:0x0dbc  */
    /* JADX WARN: Code duplicated, block: B:58:0x0116  */
    /* JADX WARN: Code duplicated, block: B:592:0x0dc1  */
    /* JADX WARN: Code duplicated, block: B:593:0x0dc3  */
    /* JADX WARN: Code duplicated, block: B:595:0x0dc7  */
    /* JADX WARN: Code duplicated, block: B:596:0x0dcb  */
    /* JADX WARN: Code duplicated, block: B:600:0x0dd9  */
    /* JADX WARN: Code duplicated, block: B:602:0x0de3  */
    /* JADX WARN: Code duplicated, block: B:603:0x0df9  */
    /* JADX WARN: Code duplicated, block: B:605:0x0e05  */
    /* JADX WARN: Code duplicated, block: B:607:0x0e30  */
    /* JADX WARN: Code duplicated, block: B:608:0x0e38  */
    /* JADX WARN: Code duplicated, block: B:611:0x0e40  */
    /* JADX WARN: Code duplicated, block: B:620:0x0e9d  */
    /* JADX WARN: Code duplicated, block: B:628:0x0e95 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:637:0x0da0 A[EDGE_INSN: B:637:0x0da0->B:579:0x0da0 BREAK  A[LOOP:6: B:562:0x0d38->B:578:0x0d95], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:640:0x0d7f A[ADDED_TO_REGION, EDGE_INSN: B:640:0x0d7f->B:572:0x0d7f BREAK  A[LOOP:7: B:567:0x0d6e->B:571:0x0d79], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:645:0x0e46 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:648:0x0b41 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:649:0x0a9d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:653:0x0a93 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:654:0x0a8b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:0x0ac9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:657:0x0b5c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:0x0b54 A[SYNTHETIC] */
    public static List zzd(zzagw zzagwVar, zzacc zzaccVar, long j, zzad zzadVar, boolean z, boolean z2, zzfsk zzfskVar) throws zzcc {
        int i;
        long j2;
        int i2;
        int i3;
        int i4;
        ArrayList arrayList;
        String str;
        int i5;
        zzagw zzagwVar2;
        long[] jArr;
        long[] jArr2;
        zzahv zzahvVar;
        Pair pairZzi;
        long j3;
        zzfb zzfbVar;
        zzad zzadVarZzb;
        int i6;
        String str2;
        byte[] bArrCopyOfRange;
        int i7;
        int i8;
        int i9;
        zzahc zzahcVar;
        int i10;
        boolean z3;
        String str3;
        zzahc zzahcVar2;
        boolean z4;
        int i11;
        List list;
        String str4;
        int i12;
        int i13;
        int i14;
        String str5;
        String str6;
        long j4;
        zzfvs zzfvsVarZzm;
        long j5;
        zzahv zzahvVar2;
        ArrayList arrayList2;
        zzagw zzagwVarZza;
        zzagx zzagxVarZzb;
        zzagx zzagxVarZzb2;
        zzahb zzaheVar;
        int iZzb;
        zzagx zzagxVarZzb3;
        zzagx zzagxVar;
        boolean z5;
        zzagx zzagxVarZzb4;
        zzfb zzfbVar2;
        zzagx zzagxVarZzb5;
        zzfb zzfbVar3;
        zzfb zzfbVar4;
        zzagz zzagzVar;
        int iZzo;
        int iZzo2;
        int iZzo3;
        int iZzo4;
        int iZzo5;
        int iZza;
        int iZzo6;
        long[] jArrCopyOf;
        int[] iArrCopyOf;
        long[] jArrCopyOf2;
        int i15;
        int[] iArrCopyOf2;
        zzahv zzahvVar3;
        int iZzf;
        int i16;
        int i17;
        int i18;
        int i19;
        int iZzo7;
        int i20;
        long j6;
        long j7;
        int i21;
        int i22;
        boolean z6;
        int i23;
        int[] iArr;
        long j8;
        long[] jArr3;
        long[] jArr4;
        int[] iArr2;
        String str7;
        long j9;
        boolean zZza;
        int i24;
        int iZzf2;
        int iZzc;
        int i25;
        int i26;
        int iZzo8;
        int i27;
        long jZzr;
        long[] jArr5;
        long[] jArr6;
        int length;
        boolean z7;
        long[] jArr7;
        int[] iArr3;
        int[] iArr4;
        int i28;
        int i29;
        boolean z8;
        int i30;
        long[] jArr8;
        int i31;
        long[] jArr9;
        int[] iArr5;
        int[] iArr6;
        boolean z9;
        boolean z10;
        long[] jArr10;
        int[] iArr7;
        int i32;
        int[] iArr8;
        long[] jArr11;
        int i33;
        int i34;
        int i35;
        long j10;
        zzahy zzahyVar;
        long j11;
        int i36;
        int i37;
        int[] iArr9;
        long[] jArr12;
        int[] iArr10;
        long jZzr2;
        long j12;
        int[] iArr11;
        int i38;
        int i39;
        int i40;
        int i41;
        boolean z11;
        long j13;
        int i42;
        long j14;
        ArrayList arrayList3 = new ArrayList();
        int i43 = 0;
        while (i43 < zzagwVar.zzc.size()) {
            zzagw zzagwVar3 = (zzagw) zzagwVar.zzc.get(i43);
            if (zzagwVar3.zzd != 1953653099) {
                arrayList2 = arrayList3;
                i = i43;
            } else {
                zzagx zzagxVarZzb6 = zzagwVar.zzb(1836476516);
                Objects.requireNonNull(zzagxVarZzb6);
                zzagw zzagwVarZza2 = zzagwVar3.zza(1835297121);
                Objects.requireNonNull(zzagwVarZza2);
                zzagx zzagxVarZzb7 = zzagwVarZza2.zzb(1751411826);
                Objects.requireNonNull(zzagxVarZzb7);
                int iZzf3 = zzf(zzh(zzagxVarZzb7.zza));
                String str8 = "AtomParsers";
                i = i43;
                if (iZzf3 == -1) {
                    str = "AtomParsers";
                    i5 = -1;
                    zzagwVar2 = zzagwVar3;
                    arrayList = arrayList3;
                } else {
                    zzagx zzagxVarZzb8 = zzagwVar3.zzb(1953196132);
                    Objects.requireNonNull(zzagxVarZzb8);
                    zzfb zzfbVar5 = zzagxVarZzb8.zza;
                    zzfbVar5.zzG(8);
                    int iZze = zzagy.zze(zzfbVar5.zzf());
                    zzfbVar5.zzH(iZze != 0 ? 16 : 8);
                    int iZzf4 = zzfbVar5.zzf();
                    zzfbVar5.zzH(4);
                    int iZzc2 = zzfbVar5.zzc();
                    int i44 = 0;
                    while (true) {
                        int i45 = iZze == 0 ? 4 : 8;
                        if (i44 >= i45) {
                            zzfbVar5.zzH(i45);
                        } else {
                            if (zzfbVar5.zzI()[iZzc2 + i44] != -1) {
                                long jZzt = iZze == 0 ? zzfbVar5.zzt() : zzfbVar5.zzu();
                                if (jZzt != 0) {
                                    j2 = jZzt;
                                    break;
                                }
                                break;
                            }
                            i44++;
                        }
                        j2 = -9223372036854775807L;
                        break;
                    }
                    zzfbVar5.zzH(16);
                    int iZzf5 = zzfbVar5.zzf();
                    int iZzf6 = zzfbVar5.zzf();
                    zzfbVar5.zzH(4);
                    int iZzf7 = zzfbVar5.zzf();
                    int iZzf8 = zzfbVar5.zzf();
                    int i46 = 65536;
                    if (iZzf5 != 0) {
                        if (iZzf5 == 0) {
                            if (iZzf6 == -65536) {
                                i46 = iZzf7;
                                i2 = iZzf6;
                            } else if (iZzf7 == 65536) {
                                i46 = iZzf7;
                                i3 = 0;
                                i2 = -65536;
                            } else if (iZzf8 == 0) {
                                i4 = 270;
                            } else {
                                i2 = -65536;
                            }
                            i3 = 0;
                        } else {
                            i46 = iZzf7;
                            i2 = iZzf6;
                            i3 = iZzf5;
                        }
                        if (i3 != -65536 && i2 == 0 && i46 == 0 && iZzf8 == -65536) {
                            i4 = 180;
                        } else {
                            i4 = 0;
                        }
                    } else {
                        if (iZzf6 == 65536) {
                            if (iZzf7 == -65536) {
                                if (iZzf8 == 0) {
                                    i4 = 90;
                                } else {
                                    iZzf7 = -65536;
                                }
                            }
                            iZzf6 = 65536;
                        }
                        iZzf5 = 0;
                        if (iZzf5 == 0) {
                            if (iZzf6 == -65536) {
                                i46 = iZzf7;
                                i2 = iZzf6;
                            } else if (iZzf7 == 65536) {
                                i46 = iZzf7;
                                i3 = 0;
                                i2 = -65536;
                            } else if (iZzf8 == 0) {
                                i4 = 270;
                            } else {
                                i2 = -65536;
                            }
                            i3 = 0;
                        } else {
                            i46 = iZzf7;
                            i2 = iZzf6;
                            i3 = iZzf5;
                        }
                        if (i3 != -65536) {
                            i4 = 0;
                        } else {
                            i4 = 0;
                        }
                    }
                    zzahf zzahfVar = new zzahf(iZzf4, j2, i4);
                    long j15 = j == -9223372036854775807L ? zzahfVar.zzb : j;
                    long j16 = zzc(zzagxVarZzb6.zza).zzc;
                    long jZzr3 = j15 != -9223372036854775807L ? zzfk.zzr(j15, 1000000L, j16) : -9223372036854775807L;
                    zzagw zzagwVarZza3 = zzagwVarZza2.zza(1835626086);
                    Objects.requireNonNull(zzagwVarZza3);
                    zzagw zzagwVarZza4 = zzagwVarZza3.zza(1937007212);
                    Objects.requireNonNull(zzagwVarZza4);
                    zzagx zzagxVarZzb9 = zzagwVarZza2.zzb(1835296868);
                    Objects.requireNonNull(zzagxVarZzb9);
                    Pair pairZzj = zzj(zzagxVarZzb9.zza);
                    zzagx zzagxVarZzb10 = zzagwVarZza4.zzb(1937011556);
                    if (zzagxVarZzb10 == null) {
                        throw zzcc.zza("Malformed sample table (stbl) missing sample description (stsd)", null);
                    }
                    int i47 = zzahfVar.zza;
                    int i48 = zzahfVar.zzc;
                    String str9 = (String) pairZzj.second;
                    zzfb zzfbVar6 = zzagxVarZzb10.zza;
                    zzfbVar6.zzG(12);
                    int iZzf9 = zzfbVar6.zzf();
                    zzahc zzahcVar3 = new zzahc(iZzf9);
                    arrayList = arrayList3;
                    int i49 = 0;
                    while (i49 < iZzf9) {
                        int i50 = iZzf9;
                        int iZzc3 = zzfbVar6.zzc();
                        int iZzf10 = zzfbVar6.zzf();
                        zzabq.zzb(iZzf10 > 0, "childAtomSize must be positive");
                        int iZzf11 = zzfbVar6.zzf();
                        Pair pair = pairZzj;
                        if (iZzf11 == 1635148593 || iZzf11 == 1635148595 || iZzf11 == 1701733238 || iZzf11 == 1831958048 || iZzf11 == 1836070006 || iZzf11 == 1752589105 || iZzf11 == 1751479857 || iZzf11 == 1932670515 || iZzf11 == 1211250227 || iZzf11 == 1987063864 || iZzf11 == 1987063865 || iZzf11 == 1635135537 || iZzf11 == 1685479798 || iZzf11 == 1685479729 || iZzf11 == 1685481573 || iZzf11 == 1685481521) {
                            str9 = str9;
                            int i51 = i47;
                            j3 = j16;
                            iZzf3 = iZzf3;
                            zzagwVar3 = zzagwVar3;
                            zzahfVar = zzahfVar;
                            int i52 = i48;
                            String str10 = str8;
                            pair = pair;
                            zzfbVar = zzfbVar6;
                            zzfbVar.zzG(iZzc3 + 16);
                            zzfbVar.zzH(16);
                            int iZzp = zzfbVar.zzp();
                            int iZzp2 = zzfbVar.zzp();
                            zzfbVar.zzH(50);
                            int iZzc4 = zzfbVar.zzc();
                            if (iZzf11 == 1701733238) {
                                Pair pairZzk = zzk(zzfbVar, iZzc3, iZzf10);
                                if (pairZzk != null) {
                                    int iIntValue = ((Integer) pairZzk.first).intValue();
                                    zzadVarZzb = zzadVar == null ? null : zzadVar.zzb(((zzahw) pairZzk.second).zzb);
                                    zzahcVar3.zza[i49] = (zzahw) pairZzk.second;
                                    iZzf11 = iIntValue;
                                } else {
                                    iZzf11 = 1701733238;
                                    zzadVarZzb = zzadVar;
                                }
                                zzfbVar.zzG(iZzc4);
                            } else {
                                zzadVarZzb = zzadVar;
                            }
                            if (iZzf11 == 1831958048) {
                                i6 = iZzf11;
                                str2 = "video/mpeg";
                            } else {
                                i6 = 1211250227;
                                if (iZzf11 == 1211250227) {
                                    str2 = "video/3gpp";
                                } else {
                                    i6 = iZzf11;
                                    str2 = null;
                                }
                            }
                            int i53 = iZzc4;
                            zzad zzadVar2 = zzadVarZzb;
                            float fZzo = 1.0f;
                            i49 = i49;
                            byte[] bArr = null;
                            int iZzb2 = -1;
                            String str11 = null;
                            int i54 = -1;
                            ByteBuffer byteBufferZzn = null;
                            zzaha zzahaVar = null;
                            List listZzm = null;
                            int i55 = -1;
                            int i56 = -1;
                            String str12 = str2;
                            boolean z12 = false;
                            while (true) {
                                if (i53 - iZzc3 >= iZzf10) {
                                    bArrCopyOfRange = bArr;
                                    break;
                                }
                                zzfbVar.zzG(i53);
                                int iZzc5 = zzfbVar.zzc();
                                int iZzf12 = zzfbVar.zzf();
                                if (iZzf12 == 0) {
                                    bArrCopyOfRange = bArr;
                                    if (zzfbVar.zzc() - iZzc3 == iZzf10) {
                                        break;
                                    }
                                    i10 = 0;
                                } else {
                                    bArrCopyOfRange = bArr;
                                    i10 = iZzf12;
                                }
                                zzabq.zzb(i10 > 0, "childAtomSize must be positive");
                                int iZzf13 = zzfbVar.zzf();
                                fZzo = fZzo;
                                if (iZzf13 == 1635148611) {
                                    int i57 = iZzc5 + 8;
                                    zzabq.zzb(str12 == null, null);
                                    zzfbVar.zzG(i57);
                                    zzaar zzaarVarZza = zzaar.zza(zzfbVar);
                                    list = zzaarVarZza.zza;
                                    zzahcVar3.zzc = zzaarVarZza.zzb;
                                    if (z12) {
                                        fZzo = fZzo;
                                        z12 = true;
                                    } else {
                                        fZzo = zzaarVarZza.zzh;
                                        z12 = false;
                                    }
                                    str4 = zzaarVarZza.zzi;
                                    i12 = zzaarVarZza.zze;
                                    i13 = zzaarVarZza.zzf;
                                    i14 = zzaarVarZza.zzg;
                                    str5 = "video/avc";
                                } else {
                                    if (iZzf13 == 1752589123) {
                                        int i58 = iZzc5 + 8;
                                        zzabq.zzb(str12 == null, null);
                                        zzfbVar.zzG(i58);
                                        zzacd zzacdVarZza = zzacd.zza(zzfbVar);
                                        list = zzacdVarZza.zza;
                                        zzahcVar3.zzc = zzacdVarZza.zzb;
                                        if (z12) {
                                            fZzo = fZzo;
                                            z12 = true;
                                        } else {
                                            fZzo = zzacdVarZza.zzf;
                                            z12 = false;
                                        }
                                        str4 = zzacdVarZza.zzg;
                                        i12 = zzacdVarZza.zzc;
                                        i13 = zzacdVarZza.zzd;
                                        i14 = zzacdVarZza.zze;
                                        str5 = "video/hevc";
                                    } else if (iZzf13 == 1685480259 || iZzf13 == 1685485123) {
                                        iZzp = iZzp;
                                        z3 = z12;
                                        iZzp2 = iZzp2;
                                        i6 = i6;
                                        str3 = str11;
                                        zzahcVar2 = zzahcVar3;
                                        str10 = str10;
                                        zzabi zzabiVarZza = zzabi.zza(zzfbVar);
                                        if (zzabiVarZza != null) {
                                            str11 = zzabiVarZza.zza;
                                            str12 = "video/dolby-vision";
                                            fZzo = fZzo;
                                            z12 = z3;
                                        } else {
                                            fZzo = fZzo;
                                            z12 = z3;
                                            str11 = str3;
                                        }
                                    } else {
                                        if (iZzf13 == 1987076931) {
                                            zzabq.zzb(str12 == null, null);
                                            zzfbVar.zzG(iZzc5 + 12);
                                            zzfbVar.zzH(2);
                                            int iZzl = zzfbVar.zzl() & 1;
                                            int iZzl2 = zzfbVar.zzl();
                                            int iZzl3 = zzfbVar.zzl();
                                            int iZza2 = zzs.zza(iZzl2);
                                            i56 = 1 != iZzl ? 2 : 1;
                                            i54 = iZza2;
                                            iZzb2 = zzs.zzb(iZzl3);
                                            str12 = i6 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                                        } else if (iZzf13 == 1635135811) {
                                            zzabq.zzb(str12 == null, null);
                                            str12 = MimeTypes.VIDEO_AV1;
                                        } else if (iZzf13 == 1668050025) {
                                            if (byteBufferZzn == null) {
                                                byteBufferZzn = zzn();
                                            }
                                            ByteBuffer byteBuffer = byteBufferZzn;
                                            byteBuffer.position(21);
                                            byteBuffer.putShort(zzfbVar.zzz());
                                            byteBuffer.putShort(zzfbVar.zzz());
                                            byteBufferZzn = byteBuffer;
                                        } else {
                                            if (iZzf13 == 1835295606) {
                                                if (byteBufferZzn == null) {
                                                    byteBufferZzn = zzn();
                                                }
                                                ByteBuffer byteBuffer2 = byteBufferZzn;
                                                short sZzz = zzfbVar.zzz();
                                                short sZzz2 = zzfbVar.zzz();
                                                short sZzz3 = zzfbVar.zzz();
                                                z3 = z12;
                                                short sZzz4 = zzfbVar.zzz();
                                                i6 = i6;
                                                short sZzz5 = zzfbVar.zzz();
                                                zzahcVar2 = zzahcVar3;
                                                short sZzz6 = zzfbVar.zzz();
                                                iZzp2 = iZzp2;
                                                short sZzz7 = zzfbVar.zzz();
                                                iZzp = iZzp;
                                                short sZzz8 = zzfbVar.zzz();
                                                long jZzt2 = zzfbVar.zzt();
                                                long jZzt3 = zzfbVar.zzt();
                                                str3 = str11;
                                                byteBuffer2.position(1);
                                                byteBuffer2.putShort(sZzz5);
                                                byteBuffer2.putShort(sZzz6);
                                                byteBuffer2.putShort(sZzz);
                                                byteBuffer2.putShort(sZzz2);
                                                byteBuffer2.putShort(sZzz3);
                                                byteBuffer2.putShort(sZzz4);
                                                byteBuffer2.putShort(sZzz7);
                                                byteBuffer2.putShort(sZzz8);
                                                byteBuffer2.putShort((short) (jZzt2 / 10000));
                                                byteBuffer2.putShort((short) (jZzt3 / 10000));
                                                byteBufferZzn = byteBuffer2;
                                            } else {
                                                iZzp = iZzp;
                                                z3 = z12;
                                                iZzp2 = iZzp2;
                                                i6 = i6;
                                                str3 = str11;
                                                zzahcVar2 = zzahcVar3;
                                                if (iZzf13 == 1681012275) {
                                                    zzabq.zzb(str12 == null, null);
                                                    str12 = "video/3gpp";
                                                } else if (iZzf13 == 1702061171) {
                                                    zzabq.zzb(str12 == null, null);
                                                    zzaha zzahaVarZzm = zzm(zzfbVar, iZzc5);
                                                    String str13 = zzahaVarZzm.zza;
                                                    byte[] bArr2 = zzahaVarZzm.zzb;
                                                    if (bArr2 != null) {
                                                        zzahaVar = zzahaVarZzm;
                                                        str12 = str13;
                                                        listZzm = zzfvs.zzm(bArr2);
                                                    } else {
                                                        zzahaVar = zzahaVarZzm;
                                                        str12 = str13;
                                                    }
                                                } else if (iZzf13 == 1885434736) {
                                                    zzfbVar.zzG(iZzc5 + 8);
                                                    fZzo = zzfbVar.zzo() / zzfbVar.zzo();
                                                    str10 = str10;
                                                    str11 = str3;
                                                    z12 = true;
                                                } else if (iZzf13 == 1937126244) {
                                                    int i59 = iZzc5 + 8;
                                                    while (true) {
                                                        if (i59 - iZzc5 < i10) {
                                                            zzfbVar.zzG(i59);
                                                            int iZzf14 = zzfbVar.zzf() + i59;
                                                            if (zzfbVar.zzf() == 1886547818) {
                                                                bArrCopyOfRange = Arrays.copyOfRange(zzfbVar.zzI(), i59, iZzf14);
                                                            } else {
                                                                i59 = iZzf14;
                                                            }
                                                        } else {
                                                            str10 = str10;
                                                            fZzo = fZzo;
                                                            z12 = z3;
                                                            str11 = str3;
                                                            bArrCopyOfRange = null;
                                                        }
                                                    }
                                                } else {
                                                    if (iZzf13 == 1936995172) {
                                                        int iZzl4 = zzfbVar.zzl();
                                                        zzfbVar.zzH(3);
                                                        if (iZzl4 == 0) {
                                                            int iZzl5 = zzfbVar.zzl();
                                                            if (iZzl5 == 0) {
                                                                str10 = str10;
                                                                fZzo = fZzo;
                                                                z12 = z3;
                                                                str11 = str3;
                                                                i55 = 0;
                                                            } else if (iZzl5 == 1) {
                                                                str10 = str10;
                                                                fZzo = fZzo;
                                                                z12 = z3;
                                                                str11 = str3;
                                                                i55 = 1;
                                                            } else if (iZzl5 == 2) {
                                                                str10 = str10;
                                                                fZzo = fZzo;
                                                                z12 = z3;
                                                                str11 = str3;
                                                                i55 = 2;
                                                            } else if (iZzl5 == 3) {
                                                                i55 = 3;
                                                            }
                                                        }
                                                    } else {
                                                        if (iZzf13 != 1668246642 || i54 != -1) {
                                                            str10 = str10;
                                                        } else if (iZzb2 == -1) {
                                                            int iZzf15 = zzfbVar.zzf();
                                                            if (iZzf15 == 1852009592 || iZzf15 == 1852009571) {
                                                                str10 = str10;
                                                                int iZzp3 = zzfbVar.zzp();
                                                                int iZzp4 = zzfbVar.zzp();
                                                                zzfbVar.zzH(2);
                                                                int i60 = 19;
                                                                if (i10 == 19) {
                                                                    z4 = (zzfbVar.zzl() & 128) != 0;
                                                                    int iZza3 = zzs.zza(iZzp3);
                                                                    if (true != z4) {
                                                                        i11 = 2;
                                                                    } else {
                                                                        i11 = 1;
                                                                    }
                                                                    i54 = iZza3;
                                                                    i56 = i11;
                                                                    iZzb2 = zzs.zzb(iZzp4);
                                                                    i10 = i60;
                                                                } else {
                                                                    i60 = i10;
                                                                }
                                                                int iZza4 = zzs.zza(iZzp3);
                                                                if (true != z4) {
                                                                    i11 = 2;
                                                                } else {
                                                                    i11 = 1;
                                                                }
                                                                i54 = iZza4;
                                                                i56 = i11;
                                                                iZzb2 = zzs.zzb(iZzp4);
                                                                i10 = i60;
                                                            } else {
                                                                str10 = str10;
                                                                zzer.zzf(str10, "Unsupported color type: ".concat(zzagy.zzf(iZzf15)));
                                                                iZzb2 = -1;
                                                                i54 = -1;
                                                            }
                                                        } else {
                                                            str10 = str10;
                                                            i54 = -1;
                                                        }
                                                        fZzo = fZzo;
                                                        z12 = z3;
                                                        str11 = str3;
                                                    }
                                                    str10 = str10;
                                                    fZzo = fZzo;
                                                    z12 = z3;
                                                    str11 = str3;
                                                }
                                            }
                                            z12 = z3;
                                            str11 = str3;
                                        }
                                        zzahcVar2 = zzahcVar3;
                                    }
                                    i53 += i10;
                                    str10 = str10;
                                    iZzc3 = iZzc3;
                                    bArr = bArrCopyOfRange;
                                    iZzf10 = iZzf10;
                                    i6 = i6;
                                    zzahcVar3 = zzahcVar2;
                                    iZzp2 = iZzp2;
                                    iZzp = iZzp;
                                }
                                listZzm = list;
                                iZzp = iZzp;
                                iZzp2 = iZzp2;
                                i6 = i6;
                                i54 = i12;
                                i56 = i13;
                                zzahcVar2 = zzahcVar3;
                                str10 = str10;
                                iZzb2 = i14;
                                String str14 = str5;
                                str11 = str4;
                                str12 = str14;
                                i53 += i10;
                                str10 = str10;
                                iZzc3 = iZzc3;
                                bArr = bArrCopyOfRange;
                                iZzf10 = iZzf10;
                                i6 = i6;
                                zzahcVar3 = zzahcVar2;
                                iZzp2 = iZzp2;
                                iZzp = iZzp;
                            }
                            int i61 = iZzp;
                            int i62 = iZzp2;
                            float f = fZzo;
                            String str15 = str11;
                            zzahc zzahcVar4 = zzahcVar3;
                            str8 = str10;
                            if (str12 == null) {
                                i7 = i51;
                                i48 = i52;
                                zzahcVar = zzahcVar4;
                            } else {
                                zzak zzakVar = new zzak();
                                i7 = i51;
                                zzakVar.zzI(i7);
                                zzakVar.zzU(str12);
                                zzakVar.zzz(str15);
                                zzakVar.zzab(i61);
                                zzakVar.zzH(i62);
                                zzakVar.zzR(f);
                                i48 = i52;
                                zzakVar.zzT(i48);
                                zzakVar.zzS(bArrCopyOfRange);
                                zzakVar.zzX(i55);
                                zzakVar.zzK(listZzm);
                                zzakVar.zzD(zzadVar2);
                                int i63 = i56;
                                if (i54 != -1) {
                                    i8 = iZzb2;
                                    i9 = i54;
                                } else if (i63 != -1) {
                                    i8 = iZzb2;
                                    i9 = -1;
                                } else if (iZzb2 == -1) {
                                    if (byteBufferZzn != null) {
                                        i63 = -1;
                                        i8 = -1;
                                        i9 = -1;
                                    }
                                    if (zzahaVar != null) {
                                        zzakVar.zzx(zzfya.zzc(zzahaVar.zzc));
                                        zzakVar.zzQ(zzfya.zzc(zzahaVar.zzd));
                                    }
                                    zzahcVar = zzahcVar4;
                                    zzahcVar.zzb = zzakVar.zzac();
                                } else {
                                    i63 = -1;
                                    i8 = iZzb2;
                                    i9 = -1;
                                }
                                zzakVar.zzA(new zzs(i9, i63, i8, byteBufferZzn != null ? byteBufferZzn.array() : null));
                                if (zzahaVar != null) {
                                    zzakVar.zzx(zzfya.zzc(zzahaVar.zzc));
                                    zzakVar.zzQ(zzfya.zzc(zzahaVar.zzd));
                                }
                                zzahcVar = zzahcVar4;
                                zzahcVar.zzb = zzakVar.zzac();
                            }
                        } else if (iZzf11 == 1836069985 || iZzf11 == 1701733217 || iZzf11 == 1633889587 || iZzf11 == 1700998451 || iZzf11 == 1633889588 || iZzf11 == 1835823201 || iZzf11 == 1685353315 || iZzf11 == 1685353317 || iZzf11 == 1685353320 || iZzf11 == 1685353324 || iZzf11 == 1685353336 || iZzf11 == 1935764850 || iZzf11 == 1935767394 || iZzf11 == 1819304813 || iZzf11 == 1936684916 || iZzf11 == 1953984371 || iZzf11 == 778924082 || iZzf11 == 778924083 || iZzf11 == 1835557169 || iZzf11 == 1835560241 || iZzf11 == 1634492771 || iZzf11 == 1634492791 || iZzf11 == 1970037111 || iZzf11 == 1332770163 || iZzf11 == 1716281667) {
                            zzfb zzfbVar7 = zzfbVar6;
                            str9 = str9;
                            int i64 = i47;
                            zzahfVar = zzahfVar;
                            pair = pair;
                            j3 = j16;
                            iZzf3 = iZzf3;
                            zzfbVar = zzfbVar7;
                            zzagwVar3 = zzagwVar3;
                            zzo(zzfbVar7, iZzf11, iZzc3, iZzf10, i64, str9, z2, zzadVar, zzahcVar3, i49);
                            iZzc3 = iZzc3;
                            iZzf10 = iZzf10;
                            i49 = i49;
                            zzahcVar = zzahcVar3;
                            i7 = i64;
                            str8 = str8;
                            i48 = i48;
                        } else {
                            if (iZzf11 == 1414810956 || iZzf11 == 1954034535 || iZzf11 == 2004251764 || iZzf11 == 1937010800 || iZzf11 == 1664495672) {
                                zzfbVar6.zzG(iZzc3 + 16);
                                if (iZzf11 == 1414810956) {
                                    str6 = "application/ttml+xml";
                                } else {
                                    if (iZzf11 == 1954034535) {
                                        int i65 = iZzf10 - 16;
                                        byte[] bArr3 = new byte[i65];
                                        zzfbVar6.zzC(bArr3, 0, i65);
                                        zzfvsVarZzm = zzfvs.zzm(bArr3);
                                        str6 = "application/x-quicktime-tx3g";
                                        j5 = Long.MAX_VALUE;
                                        j4 = j16;
                                    } else if (iZzf11 == 2004251764) {
                                        str6 = "application/x-mp4-vtt";
                                    } else if (iZzf11 == 1937010800) {
                                        str6 = "application/ttml+xml";
                                        j4 = j16;
                                        zzfvsVarZzm = null;
                                        j5 = 0;
                                    } else {
                                        zzahcVar3.zzd = 1;
                                        str6 = "application/x-mp4-cea-608";
                                    }
                                    zzak zzakVar2 = new zzak();
                                    zzakVar2.zzI(i47);
                                    zzakVar2.zzU(str6);
                                    zzakVar2.zzM(str9);
                                    zzakVar2.zzY(j5);
                                    zzakVar2.zzK(zzfvsVarZzm);
                                    zzahcVar3.zzb = zzakVar2.zzac();
                                    j3 = j4;
                                }
                                zzfvsVarZzm = null;
                                j5 = Long.MAX_VALUE;
                                j4 = j16;
                                zzak zzakVar3 = new zzak();
                                zzakVar3.zzI(i47);
                                zzakVar3.zzU(str6);
                                zzakVar3.zzM(str9);
                                zzakVar3.zzY(j5);
                                zzakVar3.zzK(zzfvsVarZzm);
                                zzahcVar3.zzb = zzakVar3.zzac();
                                j3 = j4;
                            } else {
                                if (iZzf11 == 1835365492) {
                                    zzfbVar6.zzG(iZzc3 + 16);
                                    zzfbVar6.zzw((char) 0);
                                    String strZzw = zzfbVar6.zzw((char) 0);
                                    if (strZzw != null) {
                                        zzak zzakVar4 = new zzak();
                                        zzakVar4.zzI(i47);
                                        zzakVar4.zzU(strZzw);
                                        zzahcVar3.zzb = zzakVar4.zzac();
                                    }
                                } else if (iZzf11 == 1667329389) {
                                    zzak zzakVar5 = new zzak();
                                    zzakVar5.zzI(i47);
                                    zzakVar5.zzU("application/x-camera-motion");
                                    zzahcVar3.zzb = zzakVar5.zzac();
                                }
                                j3 = j16;
                            }
                            zzfbVar = zzfbVar6;
                            i7 = i47;
                            zzahcVar = zzahcVar3;
                        }
                        zzfbVar.zzG(iZzc3 + iZzf10);
                        i49++;
                        zzadVar = zzadVar;
                        str8 = str8;
                        zzahcVar3 = zzahcVar;
                        iZzf3 = iZzf3;
                        j16 = j3;
                        iZzf9 = i50;
                        str9 = str9;
                        pairZzj = pair;
                        zzagwVar3 = zzagwVar3;
                        i47 = i7;
                        zzfbVar6 = zzfbVar;
                        zzahfVar = zzahfVar;
                    }
                    str = str8;
                    Pair pair2 = pairZzj;
                    long j17 = j16;
                    int i66 = iZzf3;
                    zzahf zzahfVar2 = zzahfVar;
                    zzahc zzahcVar5 = zzahcVar3;
                    i5 = -1;
                    zzagwVar2 = zzagwVar3;
                    zzagw zzagwVarZza5 = zzagwVar2.zza(1701082227);
                    if (zzagwVarZza5 == null || (pairZzi = zzi(zzagwVarZza5)) == null) {
                        jArr = null;
                        jArr2 = null;
                    } else {
                        jArr = (long[]) pairZzi.first;
                        jArr2 = (long[]) pairZzi.second;
                    }
                    if (zzahcVar5.zzb != null) {
                        zzahvVar = new zzahv(zzahfVar2.zza, i66, ((Long) pair2.first).longValue(), j17, jZzr3, zzahcVar5.zzb, zzahcVar5.zzd, zzahcVar5.zza, zzahcVar5.zzc, jArr, jArr2);
                        zzfskVar = zzfskVar;
                    }
                    zzahvVar2 = (zzahv) zzfskVar.apply(zzahvVar);
                    if (zzahvVar2 != null) {
                        zzagw zzagwVarZza6 = zzagwVar2.zza(1835297121);
                        Objects.requireNonNull(zzagwVarZza6);
                        zzagw zzagwVarZza7 = zzagwVarZza6.zza(1835626086);
                        Objects.requireNonNull(zzagwVarZza7);
                        zzagwVarZza = zzagwVarZza7.zza(1937007212);
                        Objects.requireNonNull(zzagwVarZza);
                        zzagxVarZzb = zzagwVarZza.zzb(1937011578);
                        if (zzagxVarZzb != null) {
                            zzaheVar = new zzahd(zzagxVarZzb, zzahvVar2.zzf);
                        } else {
                            zzagxVarZzb2 = zzagwVarZza.zzb(1937013298);
                            if (zzagxVarZzb2 != null) {
                                throw zzcc.zza("Track has no sample table size information", null);
                            }
                            zzaheVar = new zzahe(zzagxVarZzb2);
                        }
                        iZzb = zzaheVar.zzb();
                        if (iZzb == 0) {
                            zzahyVar = new zzahy(zzahvVar2, new long[0], new int[0], 0, new long[0], new int[0], 0L);
                        } else {
                            zzagxVarZzb3 = zzagwVarZza.zzb(1937007471);
                            if (zzagxVarZzb3 == null) {
                                zzagx zzagxVarZzb11 = zzagwVarZza.zzb(1668232756);
                                Objects.requireNonNull(zzagxVarZzb11);
                                zzagxVar = zzagxVarZzb11;
                                z5 = true;
                            } else {
                                zzagxVar = zzagxVarZzb3;
                                z5 = false;
                            }
                            zzagx zzagxVarZzb12 = zzagwVarZza.zzb(1937011555);
                            Objects.requireNonNull(zzagxVarZzb12);
                            zzagx zzagxVarZzb13 = zzagwVarZza.zzb(1937011827);
                            Objects.requireNonNull(zzagxVarZzb13);
                            zzagxVarZzb4 = zzagwVarZza.zzb(1937011571);
                            if (zzagxVarZzb4 != null) {
                                zzfbVar2 = zzagxVarZzb4.zza;
                            } else {
                                zzfbVar2 = null;
                            }
                            zzagxVarZzb5 = zzagwVarZza.zzb(1668576371);
                            if (zzagxVarZzb5 != null) {
                                zzfbVar3 = zzagxVarZzb5.zza;
                            } else {
                                zzfbVar3 = null;
                            }
                            zzfbVar4 = zzagxVarZzb13.zza;
                            zzagzVar = new zzagz(zzagxVarZzb12.zza, zzagxVar.zza, z5);
                            zzfbVar4.zzG(12);
                            iZzo = zzfbVar4.zzo() + i5;
                            int iZzo9 = zzfbVar4.zzo();
                            iZzo2 = zzfbVar4.zzo();
                            if (zzfbVar3 != null) {
                                zzfbVar3.zzG(12);
                                iZzo3 = zzfbVar3.zzo();
                            } else {
                                iZzo3 = 0;
                            }
                            if (zzfbVar2 != null) {
                                zzfbVar2.zzG(12);
                                iZzo5 = zzfbVar2.zzo();
                                if (iZzo5 > 0) {
                                    iZzo4 = zzfbVar2.zzo() + i5;
                                } else {
                                    iZzo4 = i5;
                                    zzfbVar2 = null;
                                }
                            } else {
                                iZzo4 = i5;
                                iZzo5 = 0;
                            }
                            iZza = zzaheVar.zza();
                            String str16 = zzahvVar2.zzf.zzm;
                            iZzo6 = iZzo9;
                            if (iZza != -1 || ((!"audio/raw".equals(str16) && !"audio/g711-mlaw".equals(str16) && !"audio/g711-alaw".equals(str16)) || iZzo != 0)) {
                                jArrCopyOf = new long[iZzb];
                                iArrCopyOf = new int[iZzb];
                                jArrCopyOf2 = new long[iZzb];
                                i15 = iZzo5;
                                iArrCopyOf2 = new int[iZzb];
                                zzahvVar3 = zzahvVar2;
                                iZzf = iZzo2;
                                i16 = iZzo3;
                                i17 = iZzo4;
                                i18 = 0;
                                i19 = 0;
                                iZzo7 = 0;
                                i20 = 0;
                                j6 = 0;
                                j7 = 0;
                                i21 = iZzo;
                                i22 = 0;
                                while (true) {
                                    if (i22 < iZzb) {
                                        i21 = i21;
                                        break;
                                    }
                                    j9 = j6;
                                    zZza = true;
                                    while (true) {
                                        if (i19 != 0) {
                                            i24 = i19;
                                            break;
                                        }
                                        zZza = zzagzVar.zza();
                                        if (zZza) {
                                            i24 = 0;
                                            break;
                                        }
                                        int i67 = i17;
                                        long j18 = zzagzVar.zzd;
                                        i19 = zzagzVar.zzc;
                                        j9 = j18;
                                        i21 = i21;
                                        i17 = i67;
                                        iZzb = iZzb;
                                    }
                                    if (!zZza) {
                                        zzer.zzf(str, "Unexpected end of chunk data");
                                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i22);
                                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i22);
                                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i22);
                                        iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i22);
                                        iZzb = i22;
                                        break;
                                    }
                                    iZzf2 = i20;
                                    if (zzfbVar3 != null) {
                                        while (iZzo7 == 0) {
                                            if (i16 > 0) {
                                                iZzo7 = 0;
                                                break;
                                            }
                                            i16--;
                                            iZzo7 = zzfbVar3.zzo();
                                            iZzf2 = zzfbVar3.zzf();
                                        }
                                        iZzo7--;
                                    }
                                    jArrCopyOf[i22] = j9;
                                    iZzc = zzaheVar.zzc();
                                    iArrCopyOf[i22] = iZzc;
                                    if (iZzc > i18) {
                                        i25 = iZzc;
                                    } else {
                                        i25 = i18;
                                    }
                                    jArrCopyOf2[i22] = j7 + ((long) iZzf2);
                                    if (zzfbVar2 == null) {
                                        i26 = 1;
                                    } else {
                                        i26 = 0;
                                    }
                                    iArrCopyOf2[i22] = i26;
                                    iZzo8 = i17;
                                    if (i22 == iZzo8) {
                                        iArrCopyOf2[i22] = 1;
                                        i15--;
                                        if (i15 > 0) {
                                            Objects.requireNonNull(zzfbVar2);
                                            iZzo8 = zzfbVar2.zzo() - 1;
                                        }
                                    }
                                    zzfb zzfbVar8 = zzfbVar2;
                                    int i68 = iZzo8;
                                    j7 += (long) iZzf;
                                    i27 = iZzo6 - 1;
                                    if (i27 == 0) {
                                        iZzo6 = i27;
                                    } else if (i21 > 0) {
                                        iZzo6 = zzfbVar4.zzo();
                                        iZzf = zzfbVar4.zzf();
                                        i21--;
                                    } else {
                                        iZzo6 = 0;
                                    }
                                    long j19 = j9 + ((long) iArrCopyOf[i22]);
                                    i22++;
                                    i20 = iZzf2;
                                    i17 = i68;
                                    i18 = i25;
                                    i19 = i24 - 1;
                                    iZzb = iZzb;
                                    zzagzVar = zzagzVar;
                                    zzfbVar2 = zzfbVar8;
                                    i21 = i21;
                                    j6 = j19;
                                }
                                long j20 = j7 + ((long) i20);
                                if (zzfbVar3 != null) {
                                    z6 = true;
                                    break;
                                }
                                while (true) {
                                    if (i16 > 0) {
                                        z6 = true;
                                        break;
                                    }
                                    if (zzfbVar3.zzo() != 0) {
                                        z6 = false;
                                        break;
                                    }
                                    zzfbVar3.zzf();
                                    i16--;
                                }
                                if (i15 == 0) {
                                    if (iZzo6 == 0) {
                                        if (i19 == 0) {
                                            z6 = z6;
                                            i19 = i19;
                                            iZzo7 = iZzo7;
                                            zzahvVar3 = zzahvVar3;
                                            i21 = i21;
                                            i23 = 0;
                                            iZzo6 = 0;
                                        } else if (i21 == 0) {
                                            z6 = z6;
                                            iZzo7 = iZzo7;
                                            zzahvVar3 = zzahvVar3;
                                            i21 = i21;
                                            i23 = 0;
                                            iZzo6 = 0;
                                            i19 = 0;
                                        } else if (iZzo7 == 0) {
                                            z6 = z6;
                                            iZzo7 = iZzo7;
                                            zzahvVar3 = zzahvVar3;
                                            i23 = 0;
                                            iZzo6 = 0;
                                            i19 = 0;
                                            i21 = 0;
                                        } else if (z6) {
                                            jArrCopyOf = jArrCopyOf;
                                            zzahvVar3 = zzahvVar3;
                                        } else {
                                            zzahvVar3 = zzahvVar3;
                                            i23 = 0;
                                            iZzo6 = 0;
                                            i19 = 0;
                                            i21 = 0;
                                            iZzo7 = 0;
                                            z6 = false;
                                        }
                                        int i69 = zzahvVar3.zza;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("Inconsistent stbl box for track ");
                                        sb.append(i69);
                                        sb.append(": remainingSynchronizationSamples ");
                                        sb.append(i23);
                                        sb.append(", remainingSamplesAtTimestampDelta ");
                                        sb.append(iZzo6);
                                        sb.append(", remainingSamplesInChunk ");
                                        sb.append(i19);
                                        sb.append(", remainingTimestampDeltaChanges ");
                                        sb.append(i21);
                                        sb.append(", remainingSamplesAtTimestampOffset ");
                                        sb.append(iZzo7);
                                        if (true != z6) {
                                            str7 = ", ctts invalid";
                                        } else {
                                            str7 = "";
                                        }
                                        sb.append(str7);
                                        zzer.zzf(str, sb.toString());
                                    } else {
                                        i23 = 0;
                                    }
                                    iArr = iArrCopyOf2;
                                    j8 = j20;
                                    jArr3 = jArrCopyOf2;
                                    jArr4 = jArrCopyOf;
                                    iArr2 = iArrCopyOf;
                                    iZzb = iZzb;
                                } else {
                                    i23 = i15;
                                }
                                int i610 = zzahvVar3.zza;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Inconsistent stbl box for track ");
                                sb2.append(i610);
                                sb2.append(": remainingSynchronizationSamples ");
                                sb2.append(i23);
                                sb2.append(", remainingSamplesAtTimestampDelta ");
                                sb2.append(iZzo6);
                                sb2.append(", remainingSamplesInChunk ");
                                sb2.append(i19);
                                sb2.append(", remainingTimestampDeltaChanges ");
                                sb2.append(i21);
                                sb2.append(", remainingSamplesAtTimestampOffset ");
                                sb2.append(iZzo7);
                                if (true != z6) {
                                    str7 = ", ctts invalid";
                                } else {
                                    str7 = "";
                                }
                                sb2.append(str7);
                                zzer.zzf(str, sb2.toString());
                                iArr = iArrCopyOf2;
                                j8 = j20;
                                jArr3 = jArrCopyOf2;
                                jArr4 = jArrCopyOf;
                                iArr2 = iArrCopyOf;
                                iZzb = iZzb;
                            } else if (iZzo3 == 0 && iZzo5 == 0) {
                                int i70 = zzagzVar.zza;
                                long[] jArr13 = new long[i70];
                                int[] iArr12 = new int[i70];
                                while (zzagzVar.zza()) {
                                    int i71 = zzagzVar.zzb;
                                    jArr13[i71] = zzagzVar.zzd;
                                    iArr12[i71] = zzagzVar.zzc;
                                }
                                long j21 = iZzo2;
                                int i72 = 8192 / iZza;
                                int i73 = 0;
                                for (int i74 = 0; i74 < i70; i74++) {
                                    int i75 = iArr12[i74];
                                    int i76 = zzfk.zza;
                                    i73 += ((i75 + i72) - 1) / i72;
                                }
                                long[] jArr14 = new long[i73];
                                int[] iArr13 = new int[i73];
                                jArr3 = new long[i73];
                                int[] iArr14 = new int[i73];
                                int i77 = 0;
                                int i78 = 0;
                                int iMax = 0;
                                int i79 = 0;
                                while (i77 < i70) {
                                    int i80 = iArr12[i77];
                                    long j22 = jArr13[i77];
                                    int i81 = i70;
                                    int i82 = i80;
                                    while (i82 > 0) {
                                        int iMin = Math.min(i72, i82);
                                        jArr14[i79] = j22;
                                        long[] jArr15 = jArr13;
                                        int i83 = iZza * iMin;
                                        iArr13[i79] = i83;
                                        iMax = Math.max(iMax, i83);
                                        jArr3[i79] = ((long) i78) * j21;
                                        iArr14[i79] = 1;
                                        j22 += (long) iArr13[i79];
                                        i78 += iMin;
                                        i82 -= iMin;
                                        i79++;
                                        jArr13 = jArr15;
                                        iArr12 = iArr12;
                                    }
                                    i77++;
                                    i70 = i81;
                                }
                                j8 = j21 * ((long) i78);
                                jArr4 = jArr14;
                                iArr = iArr14;
                                iArr2 = iArr13;
                                i18 = iMax;
                                zzahvVar3 = zzahvVar2;
                            } else {
                                iZzo = 0;
                                jArrCopyOf = new long[iZzb];
                                iArrCopyOf = new int[iZzb];
                                jArrCopyOf2 = new long[iZzb];
                                i15 = iZzo5;
                                iArrCopyOf2 = new int[iZzb];
                                zzahvVar3 = zzahvVar2;
                                iZzf = iZzo2;
                                i16 = iZzo3;
                                i17 = iZzo4;
                                i18 = 0;
                                i19 = 0;
                                iZzo7 = 0;
                                i20 = 0;
                                j6 = 0;
                                j7 = 0;
                                i21 = iZzo;
                                i22 = 0;
                                while (true) {
                                    if (i22 < iZzb) {
                                        i21 = i21;
                                        break;
                                    }
                                    j9 = j6;
                                    zZza = true;
                                    while (true) {
                                        if (i19 != 0) {
                                            i24 = i19;
                                            break;
                                        }
                                        zZza = zzagzVar.zza();
                                        if (zZza) {
                                            i24 = 0;
                                            break;
                                        }
                                        int i611 = i17;
                                        long j110 = zzagzVar.zzd;
                                        i19 = zzagzVar.zzc;
                                        j9 = j110;
                                        i21 = i21;
                                        i17 = i611;
                                        iZzb = iZzb;
                                    }
                                    if (!zZza) {
                                        zzer.zzf(str, "Unexpected end of chunk data");
                                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i22);
                                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i22);
                                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i22);
                                        iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i22);
                                        iZzb = i22;
                                        break;
                                    }
                                    iZzf2 = i20;
                                    if (zzfbVar3 != null) {
                                        while (iZzo7 == 0) {
                                            if (i16 > 0) {
                                                iZzo7 = 0;
                                                break;
                                            }
                                            i16--;
                                            iZzo7 = zzfbVar3.zzo();
                                            iZzf2 = zzfbVar3.zzf();
                                        }
                                        iZzo7--;
                                    }
                                    jArrCopyOf[i22] = j9;
                                    iZzc = zzaheVar.zzc();
                                    iArrCopyOf[i22] = iZzc;
                                    if (iZzc > i18) {
                                        i25 = iZzc;
                                    } else {
                                        i25 = i18;
                                    }
                                    jArrCopyOf2[i22] = j7 + ((long) iZzf2);
                                    if (zzfbVar2 == null) {
                                        i26 = 1;
                                    } else {
                                        i26 = 0;
                                    }
                                    iArrCopyOf2[i22] = i26;
                                    iZzo8 = i17;
                                    if (i22 == iZzo8) {
                                        iArrCopyOf2[i22] = 1;
                                        i15--;
                                        if (i15 > 0) {
                                            Objects.requireNonNull(zzfbVar2);
                                            iZzo8 = zzfbVar2.zzo() - 1;
                                        }
                                    }
                                    zzfb zzfbVar9 = zzfbVar2;
                                    int i612 = iZzo8;
                                    j7 += (long) iZzf;
                                    i27 = iZzo6 - 1;
                                    if (i27 == 0) {
                                        iZzo6 = i27;
                                    } else if (i21 > 0) {
                                        iZzo6 = zzfbVar4.zzo();
                                        iZzf = zzfbVar4.zzf();
                                        i21--;
                                    } else {
                                        iZzo6 = 0;
                                    }
                                    long j111 = j9 + ((long) iArrCopyOf[i22]);
                                    i22++;
                                    i20 = iZzf2;
                                    i17 = i612;
                                    i18 = i25;
                                    i19 = i24 - 1;
                                    iZzb = iZzb;
                                    zzagzVar = zzagzVar;
                                    zzfbVar2 = zzfbVar9;
                                    i21 = i21;
                                    j6 = j111;
                                }
                                long j23 = j7 + ((long) i20);
                                if (zzfbVar3 != null) {
                                    z6 = true;
                                    break;
                                }
                                while (true) {
                                    if (i16 > 0) {
                                        z6 = true;
                                        break;
                                    }
                                    if (zzfbVar3.zzo() != 0) {
                                        z6 = false;
                                        break;
                                    }
                                    zzfbVar3.zzf();
                                    i16--;
                                }
                                if (i15 == 0) {
                                    if (iZzo6 == 0) {
                                        if (i19 == 0) {
                                            z6 = z6;
                                            i19 = i19;
                                            iZzo7 = iZzo7;
                                            zzahvVar3 = zzahvVar3;
                                            i21 = i21;
                                            i23 = 0;
                                            iZzo6 = 0;
                                        } else if (i21 == 0) {
                                            z6 = z6;
                                            iZzo7 = iZzo7;
                                            zzahvVar3 = zzahvVar3;
                                            i21 = i21;
                                            i23 = 0;
                                            iZzo6 = 0;
                                            i19 = 0;
                                        } else if (iZzo7 == 0) {
                                            z6 = z6;
                                            iZzo7 = iZzo7;
                                            zzahvVar3 = zzahvVar3;
                                            i23 = 0;
                                            iZzo6 = 0;
                                            i19 = 0;
                                            i21 = 0;
                                        } else if (z6) {
                                            zzahvVar3 = zzahvVar3;
                                            i23 = 0;
                                            iZzo6 = 0;
                                            i19 = 0;
                                            i21 = 0;
                                            iZzo7 = 0;
                                            z6 = false;
                                        } else {
                                            jArrCopyOf = jArrCopyOf;
                                            zzahvVar3 = zzahvVar3;
                                        }
                                        int i613 = zzahvVar3.zza;
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append("Inconsistent stbl box for track ");
                                        sb3.append(i613);
                                        sb3.append(": remainingSynchronizationSamples ");
                                        sb3.append(i23);
                                        sb3.append(", remainingSamplesAtTimestampDelta ");
                                        sb3.append(iZzo6);
                                        sb3.append(", remainingSamplesInChunk ");
                                        sb3.append(i19);
                                        sb3.append(", remainingTimestampDeltaChanges ");
                                        sb3.append(i21);
                                        sb3.append(", remainingSamplesAtTimestampOffset ");
                                        sb3.append(iZzo7);
                                        if (true != z6) {
                                            str7 = ", ctts invalid";
                                        } else {
                                            str7 = "";
                                        }
                                        sb3.append(str7);
                                        zzer.zzf(str, sb3.toString());
                                    } else {
                                        i23 = 0;
                                    }
                                    iArr = iArrCopyOf2;
                                    j8 = j23;
                                    jArr3 = jArrCopyOf2;
                                    jArr4 = jArrCopyOf;
                                    iArr2 = iArrCopyOf;
                                    iZzb = iZzb;
                                } else {
                                    i23 = i15;
                                }
                                int i614 = zzahvVar3.zza;
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("Inconsistent stbl box for track ");
                                sb4.append(i614);
                                sb4.append(": remainingSynchronizationSamples ");
                                sb4.append(i23);
                                sb4.append(", remainingSamplesAtTimestampDelta ");
                                sb4.append(iZzo6);
                                sb4.append(", remainingSamplesInChunk ");
                                sb4.append(i19);
                                sb4.append(", remainingTimestampDeltaChanges ");
                                sb4.append(i21);
                                sb4.append(", remainingSamplesAtTimestampOffset ");
                                sb4.append(iZzo7);
                                if (true != z6) {
                                    str7 = ", ctts invalid";
                                } else {
                                    str7 = "";
                                }
                                sb4.append(str7);
                                zzer.zzf(str, sb4.toString());
                                iArr = iArrCopyOf2;
                                j8 = j23;
                                jArr3 = jArrCopyOf2;
                                jArr4 = jArrCopyOf;
                                iArr2 = iArrCopyOf;
                                iZzb = iZzb;
                            }
                            jZzr = zzfk.zzr(j8, 1000000L, zzahvVar3.zzc);
                            jArr5 = zzahvVar3.zzh;
                            if (jArr5 == null) {
                                zzfk.zzD(jArr3, 1000000L, zzahvVar3.zzc);
                                zzahyVar = new zzahy(zzahvVar3, jArr4, iArr2, i18, jArr3, iArr, jZzr);
                            } else if (jArr5.length == 1 || zzahvVar3.zzb != 1 || jArr3.length < 2) {
                                jArr6 = zzahvVar3.zzh;
                                length = jArr6.length;
                                if (length != 1) {
                                    if (zzahvVar3.zzb == 1) {
                                        z7 = true;
                                    } else {
                                        z7 = false;
                                    }
                                    jArr7 = zzahvVar3.zzi;
                                    iArr3 = new int[length];
                                    iArr4 = new int[length];
                                    Objects.requireNonNull(jArr7);
                                    i28 = 0;
                                    i29 = 0;
                                    z8 = false;
                                    i30 = 0;
                                    while (true) {
                                        jArr8 = zzahvVar3.zzh;
                                        i31 = i18;
                                        if (i28 < jArr8.length) {
                                            break;
                                        }
                                        long[] jArr16 = jArr4;
                                        int[] iArr15 = iArr2;
                                        j12 = jArr7[i28];
                                        if (j12 != -1) {
                                            long j24 = jArr8[i28];
                                            boolean z13 = z8;
                                            i38 = i30;
                                            iArr11 = iArr;
                                            long jZzr4 = zzfk.zzr(j24, zzahvVar3.zzc, zzahvVar3.zzd);
                                            i39 = 1;
                                            iArr3[i28] = zzfk.zzc(jArr3, j12, true, true);
                                            iArr4[i28] = zzfk.zza(jArr3, j12 + jZzr4, z7, false);
                                            while (true) {
                                                i40 = iArr3[i28];
                                                i41 = iArr4[i28];
                                                if (i40 >= i41 || (iArr11[i40] & i39) != 0) {
                                                    break;
                                                }
                                                iArr3[i28] = i40 + 1;
                                                i39 = 1;
                                            }
                                            i29 += i41 - i40;
                                            if (i38 != i40) {
                                                z11 = true;
                                            } else {
                                                z11 = false;
                                            }
                                            z8 = z11 | z13;
                                            i30 = i41;
                                        } else {
                                            iArr11 = iArr;
                                            z8 = z8;
                                        }
                                        i28++;
                                        i18 = i31;
                                        iArr2 = iArr15;
                                        iArr = iArr11;
                                        jArr4 = jArr16;
                                    }
                                    jArr9 = jArr4;
                                    iArr5 = iArr2;
                                    boolean z14 = z8;
                                    iArr6 = iArr;
                                    if (i29 != iZzb) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    z10 = z14 | z9;
                                    if (z10) {
                                        jArr10 = new long[i29];
                                    } else {
                                        jArr10 = jArr9;
                                    }
                                    if (z10) {
                                        iArr7 = new int[i29];
                                    } else {
                                        iArr7 = iArr5;
                                    }
                                    if (true == z10) {
                                        i32 = 0;
                                    } else {
                                        i32 = i31;
                                    }
                                    if (z10) {
                                        iArr8 = new int[i29];
                                    } else {
                                        iArr8 = iArr6;
                                    }
                                    jArr11 = new long[i29];
                                    i33 = i32;
                                    i34 = 0;
                                    i35 = 0;
                                    j10 = 0;
                                    while (i35 < zzahvVar3.zzh.length) {
                                        j11 = zzahvVar3.zzi[i35];
                                        i36 = iArr3[i35];
                                        i37 = iArr4[i35];
                                        if (z10) {
                                            int i84 = i37 - i36;
                                            jArr12 = jArr9;
                                            System.arraycopy(jArr12, i36, jArr10, i34, i84);
                                            iArr9 = iArr5;
                                            System.arraycopy(iArr9, i36, iArr7, i34, i84);
                                            iArr10 = iArr6;
                                            System.arraycopy(iArr10, i36, iArr8, i34, i84);
                                        } else {
                                            iArr9 = iArr5;
                                            jArr12 = jArr9;
                                            iArr10 = iArr6;
                                        }
                                        while (i36 < i37) {
                                            long[] jArr17 = jArr12;
                                            long jZzr5 = zzfk.zzr(j10, 1000000L, zzahvVar3.zzd);
                                            int[] iArr16 = iArr8;
                                            long[] jArr18 = jArr3;
                                            jZzr2 = zzfk.zzr(jArr3[i36] - j11, 1000000L, zzahvVar3.zzc);
                                            int[] iArr17 = iArr10;
                                            int i85 = i37;
                                            if (zzahvVar3.zzb != 1) {
                                                jZzr2 = Math.max(0L, jZzr2);
                                            }
                                            jArr11[i34] = jZzr5 + jZzr2;
                                            if (!z10 && iArr7[i34] > i33) {
                                                i33 = iArr9[i36];
                                            }
                                            i34++;
                                            i36++;
                                            i33 = i33;
                                            jArr3 = jArr18;
                                            i37 = i85;
                                            iArr10 = iArr17;
                                            jArr12 = jArr17;
                                            iArr8 = iArr16;
                                        }
                                        iArr6 = iArr10;
                                        jArr9 = jArr12;
                                        j10 += zzahvVar3.zzh[i35];
                                        i35++;
                                        i33 = i33;
                                        iArr4 = iArr4;
                                        jArr3 = jArr3;
                                        iArr8 = iArr8;
                                        iArr5 = iArr9;
                                        iArr3 = iArr3;
                                    }
                                    zzahyVar = new zzahy(zzahvVar3, jArr10, iArr7, i33, jArr11, iArr8, zzfk.zzr(j10, 1000000L, zzahvVar3.zzd));
                                } else if (jArr6[0] == 0) {
                                    long[] jArr19 = zzahvVar3.zzi;
                                    Objects.requireNonNull(jArr19);
                                    j13 = jArr19[0];
                                    for (i42 = 0; i42 < jArr3.length; i42++) {
                                        jArr3[i42] = zzfk.zzr(jArr3[i42] - j13, 1000000L, zzahvVar3.zzc);
                                    }
                                    zzahyVar = new zzahy(zzahvVar3, jArr4, iArr2, i18, jArr3, iArr, zzfk.zzr(j8 - j13, 1000000L, zzahvVar3.zzc));
                                } else {
                                    length = 1;
                                    if (zzahvVar3.zzb == 1) {
                                        z7 = true;
                                    } else {
                                        z7 = false;
                                    }
                                    jArr7 = zzahvVar3.zzi;
                                    iArr3 = new int[length];
                                    iArr4 = new int[length];
                                    Objects.requireNonNull(jArr7);
                                    i28 = 0;
                                    i29 = 0;
                                    z8 = false;
                                    i30 = 0;
                                    while (true) {
                                        jArr8 = zzahvVar3.zzh;
                                        i31 = i18;
                                        if (i28 < jArr8.length) {
                                            break;
                                            break;
                                        }
                                        long[] jArr110 = jArr4;
                                        int[] iArr18 = iArr2;
                                        j12 = jArr7[i28];
                                        if (j12 != -1) {
                                            long j25 = jArr8[i28];
                                            boolean z15 = z8;
                                            i38 = i30;
                                            iArr11 = iArr;
                                            long jZzr6 = zzfk.zzr(j25, zzahvVar3.zzc, zzahvVar3.zzd);
                                            i39 = 1;
                                            iArr3[i28] = zzfk.zzc(jArr3, j12, true, true);
                                            iArr4[i28] = zzfk.zza(jArr3, j12 + jZzr6, z7, false);
                                            while (true) {
                                                i40 = iArr3[i28];
                                                i41 = iArr4[i28];
                                                if (i40 >= i41) {
                                                    break;
                                                }
                                                break;
                                                break;
                                                iArr3[i28] = i40 + 1;
                                                i39 = 1;
                                            }
                                            i29 += i41 - i40;
                                            if (i38 != i40) {
                                                z11 = true;
                                            } else {
                                                z11 = false;
                                            }
                                            z8 = z11 | z15;
                                            i30 = i41;
                                        } else {
                                            iArr11 = iArr;
                                            z8 = z8;
                                        }
                                        i28++;
                                        i18 = i31;
                                        iArr2 = iArr18;
                                        iArr = iArr11;
                                        jArr4 = jArr110;
                                    }
                                    jArr9 = jArr4;
                                    iArr5 = iArr2;
                                    boolean z16 = z8;
                                    iArr6 = iArr;
                                    if (i29 != iZzb) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    z10 = z16 | z9;
                                    if (z10) {
                                        jArr10 = new long[i29];
                                    } else {
                                        jArr10 = jArr9;
                                    }
                                    if (z10) {
                                        iArr7 = new int[i29];
                                    } else {
                                        iArr7 = iArr5;
                                    }
                                    if (true == z10) {
                                        i32 = 0;
                                    } else {
                                        i32 = i31;
                                    }
                                    if (z10) {
                                        iArr8 = new int[i29];
                                    } else {
                                        iArr8 = iArr6;
                                    }
                                    jArr11 = new long[i29];
                                    i33 = i32;
                                    i34 = 0;
                                    i35 = 0;
                                    j10 = 0;
                                    while (i35 < zzahvVar3.zzh.length) {
                                        j11 = zzahvVar3.zzi[i35];
                                        i36 = iArr3[i35];
                                        i37 = iArr4[i35];
                                        if (z10) {
                                            int i86 = i37 - i36;
                                            jArr12 = jArr9;
                                            System.arraycopy(jArr12, i36, jArr10, i34, i86);
                                            iArr9 = iArr5;
                                            System.arraycopy(iArr9, i36, iArr7, i34, i86);
                                            iArr10 = iArr6;
                                            System.arraycopy(iArr10, i36, iArr8, i34, i86);
                                        } else {
                                            iArr9 = iArr5;
                                            jArr12 = jArr9;
                                            iArr10 = iArr6;
                                        }
                                        while (i36 < i37) {
                                            long[] jArr111 = jArr12;
                                            long jZzr7 = zzfk.zzr(j10, 1000000L, zzahvVar3.zzd);
                                            int[] iArr19 = iArr8;
                                            long[] jArr112 = jArr3;
                                            jZzr2 = zzfk.zzr(jArr3[i36] - j11, 1000000L, zzahvVar3.zzc);
                                            int[] iArr110 = iArr10;
                                            int i87 = i37;
                                            if (zzahvVar3.zzb != 1) {
                                                jZzr2 = Math.max(0L, jZzr2);
                                            }
                                            jArr11[i34] = jZzr7 + jZzr2;
                                            if (!z10) {
                                            }
                                            i34++;
                                            i36++;
                                            i33 = i33;
                                            jArr3 = jArr112;
                                            i37 = i87;
                                            iArr10 = iArr110;
                                            jArr12 = jArr111;
                                            iArr8 = iArr19;
                                        }
                                        iArr6 = iArr10;
                                        jArr9 = jArr12;
                                        j10 += zzahvVar3.zzh[i35];
                                        i35++;
                                        i33 = i33;
                                        iArr4 = iArr4;
                                        jArr3 = jArr3;
                                        iArr8 = iArr8;
                                        iArr5 = iArr9;
                                        iArr3 = iArr3;
                                    }
                                    zzahyVar = new zzahy(zzahvVar3, jArr10, iArr7, i33, jArr11, iArr8, zzfk.zzr(j10, 1000000L, zzahvVar3.zzd));
                                }
                            } else {
                                long[] jArr20 = zzahvVar3.zzi;
                                Objects.requireNonNull(jArr20);
                                long j26 = jArr20[0];
                                long jZzr8 = j26 + zzfk.zzr(jArr5[0], zzahvVar3.zzc, zzahvVar3.zzd);
                                if (zzp(jArr3, j8, j26, jZzr8)) {
                                    long j27 = j8 - jZzr8;
                                    long j28 = j26 - jArr3[0];
                                    zzam zzamVar = zzahvVar3.zzf;
                                    long jZzr9 = zzfk.zzr(j28, zzamVar.zzA, zzahvVar3.zzc);
                                    long jZzr10 = zzfk.zzr(j27, zzamVar.zzA, zzahvVar3.zzc);
                                    if (jZzr9 != 0) {
                                        j14 = jZzr9;
                                    } else if (jZzr10 != 0) {
                                        j14 = 0;
                                    } else {
                                        jArr6 = zzahvVar3.zzh;
                                        length = jArr6.length;
                                        if (length != 1) {
                                            if (zzahvVar3.zzb == 1) {
                                                z7 = true;
                                            } else {
                                                z7 = false;
                                            }
                                            jArr7 = zzahvVar3.zzi;
                                            iArr3 = new int[length];
                                            iArr4 = new int[length];
                                            Objects.requireNonNull(jArr7);
                                            i28 = 0;
                                            i29 = 0;
                                            z8 = false;
                                            i30 = 0;
                                            while (true) {
                                                jArr8 = zzahvVar3.zzh;
                                                i31 = i18;
                                                if (i28 < jArr8.length) {
                                                    break;
                                                    break;
                                                }
                                                long[] jArr113 = jArr4;
                                                int[] iArr111 = iArr2;
                                                j12 = jArr7[i28];
                                                if (j12 != -1) {
                                                    long j29 = jArr8[i28];
                                                    boolean z17 = z8;
                                                    i38 = i30;
                                                    iArr11 = iArr;
                                                    long jZzr11 = zzfk.zzr(j29, zzahvVar3.zzc, zzahvVar3.zzd);
                                                    i39 = 1;
                                                    iArr3[i28] = zzfk.zzc(jArr3, j12, true, true);
                                                    iArr4[i28] = zzfk.zza(jArr3, j12 + jZzr11, z7, false);
                                                    while (true) {
                                                        i40 = iArr3[i28];
                                                        i41 = iArr4[i28];
                                                        if (i40 >= i41) {
                                                            break;
                                                            break;
                                                        }
                                                        break;
                                                        break;
                                                        iArr3[i28] = i40 + 1;
                                                        i39 = 1;
                                                    }
                                                    i29 += i41 - i40;
                                                    if (i38 != i40) {
                                                        z11 = true;
                                                    } else {
                                                        z11 = false;
                                                    }
                                                    z8 = z11 | z17;
                                                    i30 = i41;
                                                } else {
                                                    iArr11 = iArr;
                                                    z8 = z8;
                                                }
                                                i28++;
                                                i18 = i31;
                                                iArr2 = iArr111;
                                                iArr = iArr11;
                                                jArr4 = jArr113;
                                            }
                                            jArr9 = jArr4;
                                            iArr5 = iArr2;
                                            boolean z18 = z8;
                                            iArr6 = iArr;
                                            if (i29 != iZzb) {
                                                z9 = true;
                                            } else {
                                                z9 = false;
                                            }
                                            z10 = z18 | z9;
                                            if (z10) {
                                                jArr10 = new long[i29];
                                            } else {
                                                jArr10 = jArr9;
                                            }
                                            if (z10) {
                                                iArr7 = new int[i29];
                                            } else {
                                                iArr7 = iArr5;
                                            }
                                            if (true == z10) {
                                                i32 = 0;
                                            } else {
                                                i32 = i31;
                                            }
                                            if (z10) {
                                                iArr8 = new int[i29];
                                            } else {
                                                iArr8 = iArr6;
                                            }
                                            jArr11 = new long[i29];
                                            i33 = i32;
                                            i34 = 0;
                                            i35 = 0;
                                            j10 = 0;
                                            while (i35 < zzahvVar3.zzh.length) {
                                                j11 = zzahvVar3.zzi[i35];
                                                i36 = iArr3[i35];
                                                i37 = iArr4[i35];
                                                if (z10) {
                                                    int i88 = i37 - i36;
                                                    jArr12 = jArr9;
                                                    System.arraycopy(jArr12, i36, jArr10, i34, i88);
                                                    iArr9 = iArr5;
                                                    System.arraycopy(iArr9, i36, iArr7, i34, i88);
                                                    iArr10 = iArr6;
                                                    System.arraycopy(iArr10, i36, iArr8, i34, i88);
                                                } else {
                                                    iArr9 = iArr5;
                                                    jArr12 = jArr9;
                                                    iArr10 = iArr6;
                                                }
                                                while (i36 < i37) {
                                                    long[] jArr114 = jArr12;
                                                    long jZzr12 = zzfk.zzr(j10, 1000000L, zzahvVar3.zzd);
                                                    int[] iArr112 = iArr8;
                                                    long[] jArr115 = jArr3;
                                                    jZzr2 = zzfk.zzr(jArr3[i36] - j11, 1000000L, zzahvVar3.zzc);
                                                    int[] iArr113 = iArr10;
                                                    int i89 = i37;
                                                    if (zzahvVar3.zzb != 1) {
                                                        jZzr2 = Math.max(0L, jZzr2);
                                                    }
                                                    jArr11[i34] = jZzr12 + jZzr2;
                                                    if (!z10) {
                                                    }
                                                    i34++;
                                                    i36++;
                                                    i33 = i33;
                                                    jArr3 = jArr115;
                                                    i37 = i89;
                                                    iArr10 = iArr113;
                                                    jArr12 = jArr114;
                                                    iArr8 = iArr112;
                                                }
                                                iArr6 = iArr10;
                                                jArr9 = jArr12;
                                                j10 += zzahvVar3.zzh[i35];
                                                i35++;
                                                i33 = i33;
                                                iArr4 = iArr4;
                                                jArr3 = jArr3;
                                                iArr8 = iArr8;
                                                iArr5 = iArr9;
                                                iArr3 = iArr3;
                                            }
                                            zzahyVar = new zzahy(zzahvVar3, jArr10, iArr7, i33, jArr11, iArr8, zzfk.zzr(j10, 1000000L, zzahvVar3.zzd));
                                        } else if (jArr6[0] == 0) {
                                            long[] jArr116 = zzahvVar3.zzi;
                                            Objects.requireNonNull(jArr116);
                                            j13 = jArr116[0];
                                            while (i42 < jArr3.length) {
                                                jArr3[i42] = zzfk.zzr(jArr3[i42] - j13, 1000000L, zzahvVar3.zzc);
                                            }
                                            zzahyVar = new zzahy(zzahvVar3, jArr4, iArr2, i18, jArr3, iArr, zzfk.zzr(j8 - j13, 1000000L, zzahvVar3.zzc));
                                        } else {
                                            length = 1;
                                            if (zzahvVar3.zzb == 1) {
                                                z7 = true;
                                            } else {
                                                z7 = false;
                                            }
                                            jArr7 = zzahvVar3.zzi;
                                            iArr3 = new int[length];
                                            iArr4 = new int[length];
                                            Objects.requireNonNull(jArr7);
                                            i28 = 0;
                                            i29 = 0;
                                            z8 = false;
                                            i30 = 0;
                                            while (true) {
                                                jArr8 = zzahvVar3.zzh;
                                                i31 = i18;
                                                if (i28 < jArr8.length) {
                                                    break;
                                                    break;
                                                }
                                                long[] jArr117 = jArr4;
                                                int[] iArr114 = iArr2;
                                                j12 = jArr7[i28];
                                                if (j12 != -1) {
                                                    long j210 = jArr8[i28];
                                                    boolean z19 = z8;
                                                    i38 = i30;
                                                    iArr11 = iArr;
                                                    long jZzr13 = zzfk.zzr(j210, zzahvVar3.zzc, zzahvVar3.zzd);
                                                    i39 = 1;
                                                    iArr3[i28] = zzfk.zzc(jArr3, j12, true, true);
                                                    iArr4[i28] = zzfk.zza(jArr3, j12 + jZzr13, z7, false);
                                                    while (true) {
                                                        i40 = iArr3[i28];
                                                        i41 = iArr4[i28];
                                                        if (i40 >= i41) {
                                                            break;
                                                            break;
                                                        }
                                                        break;
                                                        break;
                                                        iArr3[i28] = i40 + 1;
                                                        i39 = 1;
                                                    }
                                                    i29 += i41 - i40;
                                                    if (i38 != i40) {
                                                        z11 = true;
                                                    } else {
                                                        z11 = false;
                                                    }
                                                    z8 = z11 | z19;
                                                    i30 = i41;
                                                } else {
                                                    iArr11 = iArr;
                                                    z8 = z8;
                                                }
                                                i28++;
                                                i18 = i31;
                                                iArr2 = iArr114;
                                                iArr = iArr11;
                                                jArr4 = jArr117;
                                            }
                                            jArr9 = jArr4;
                                            iArr5 = iArr2;
                                            boolean z110 = z8;
                                            iArr6 = iArr;
                                            if (i29 != iZzb) {
                                                z9 = true;
                                            } else {
                                                z9 = false;
                                            }
                                            z10 = z110 | z9;
                                            if (z10) {
                                                jArr10 = new long[i29];
                                            } else {
                                                jArr10 = jArr9;
                                            }
                                            if (z10) {
                                                iArr7 = new int[i29];
                                            } else {
                                                iArr7 = iArr5;
                                            }
                                            if (true == z10) {
                                                i32 = 0;
                                            } else {
                                                i32 = i31;
                                            }
                                            if (z10) {
                                                iArr8 = new int[i29];
                                            } else {
                                                iArr8 = iArr6;
                                            }
                                            jArr11 = new long[i29];
                                            i33 = i32;
                                            i34 = 0;
                                            i35 = 0;
                                            j10 = 0;
                                            while (i35 < zzahvVar3.zzh.length) {
                                                j11 = zzahvVar3.zzi[i35];
                                                i36 = iArr3[i35];
                                                i37 = iArr4[i35];
                                                if (z10) {
                                                    int i810 = i37 - i36;
                                                    jArr12 = jArr9;
                                                    System.arraycopy(jArr12, i36, jArr10, i34, i810);
                                                    iArr9 = iArr5;
                                                    System.arraycopy(iArr9, i36, iArr7, i34, i810);
                                                    iArr10 = iArr6;
                                                    System.arraycopy(iArr10, i36, iArr8, i34, i810);
                                                } else {
                                                    iArr9 = iArr5;
                                                    jArr12 = jArr9;
                                                    iArr10 = iArr6;
                                                }
                                                while (i36 < i37) {
                                                    long[] jArr118 = jArr12;
                                                    long jZzr14 = zzfk.zzr(j10, 1000000L, zzahvVar3.zzd);
                                                    int[] iArr115 = iArr8;
                                                    long[] jArr119 = jArr3;
                                                    jZzr2 = zzfk.zzr(jArr3[i36] - j11, 1000000L, zzahvVar3.zzc);
                                                    int[] iArr116 = iArr10;
                                                    int i811 = i37;
                                                    if (zzahvVar3.zzb != 1) {
                                                        jZzr2 = Math.max(0L, jZzr2);
                                                    }
                                                    jArr11[i34] = jZzr14 + jZzr2;
                                                    if (!z10) {
                                                    }
                                                    i34++;
                                                    i36++;
                                                    i33 = i33;
                                                    jArr3 = jArr119;
                                                    i37 = i811;
                                                    iArr10 = iArr116;
                                                    jArr12 = jArr118;
                                                    iArr8 = iArr115;
                                                }
                                                iArr6 = iArr10;
                                                jArr9 = jArr12;
                                                j10 += zzahvVar3.zzh[i35];
                                                i35++;
                                                i33 = i33;
                                                iArr4 = iArr4;
                                                jArr3 = jArr3;
                                                iArr8 = iArr8;
                                                iArr5 = iArr9;
                                                iArr3 = iArr3;
                                            }
                                            zzahyVar = new zzahy(zzahvVar3, jArr10, iArr7, i33, jArr11, iArr8, zzfk.zzr(j10, 1000000L, zzahvVar3.zzd));
                                        }
                                    }
                                    if (j14 > 2147483647L || jZzr10 > 2147483647L) {
                                        jArr6 = zzahvVar3.zzh;
                                        length = jArr6.length;
                                        if (length != 1) {
                                            if (zzahvVar3.zzb == 1) {
                                                z7 = true;
                                            } else {
                                                z7 = false;
                                            }
                                            jArr7 = zzahvVar3.zzi;
                                            iArr3 = new int[length];
                                            iArr4 = new int[length];
                                            Objects.requireNonNull(jArr7);
                                            i28 = 0;
                                            i29 = 0;
                                            z8 = false;
                                            i30 = 0;
                                            while (true) {
                                                jArr8 = zzahvVar3.zzh;
                                                i31 = i18;
                                                if (i28 < jArr8.length) {
                                                    break;
                                                    break;
                                                }
                                                long[] jArr1110 = jArr4;
                                                int[] iArr117 = iArr2;
                                                j12 = jArr7[i28];
                                                if (j12 != -1) {
                                                    long j211 = jArr8[i28];
                                                    boolean z111 = z8;
                                                    i38 = i30;
                                                    iArr11 = iArr;
                                                    long jZzr15 = zzfk.zzr(j211, zzahvVar3.zzc, zzahvVar3.zzd);
                                                    i39 = 1;
                                                    iArr3[i28] = zzfk.zzc(jArr3, j12, true, true);
                                                    iArr4[i28] = zzfk.zza(jArr3, j12 + jZzr15, z7, false);
                                                    while (true) {
                                                        i40 = iArr3[i28];
                                                        i41 = iArr4[i28];
                                                        if (i40 >= i41) {
                                                            break;
                                                            break;
                                                        }
                                                        break;
                                                        break;
                                                        iArr3[i28] = i40 + 1;
                                                        i39 = 1;
                                                    }
                                                    i29 += i41 - i40;
                                                    if (i38 != i40) {
                                                        z11 = true;
                                                    } else {
                                                        z11 = false;
                                                    }
                                                    z8 = z11 | z111;
                                                    i30 = i41;
                                                } else {
                                                    iArr11 = iArr;
                                                    z8 = z8;
                                                }
                                                i28++;
                                                i18 = i31;
                                                iArr2 = iArr117;
                                                iArr = iArr11;
                                                jArr4 = jArr1110;
                                            }
                                            jArr9 = jArr4;
                                            iArr5 = iArr2;
                                            boolean z112 = z8;
                                            iArr6 = iArr;
                                            if (i29 != iZzb) {
                                                z9 = true;
                                            } else {
                                                z9 = false;
                                            }
                                            z10 = z112 | z9;
                                            if (z10) {
                                                jArr10 = new long[i29];
                                            } else {
                                                jArr10 = jArr9;
                                            }
                                            if (z10) {
                                                iArr7 = new int[i29];
                                            } else {
                                                iArr7 = iArr5;
                                            }
                                            if (true == z10) {
                                                i32 = 0;
                                            } else {
                                                i32 = i31;
                                            }
                                            if (z10) {
                                                iArr8 = new int[i29];
                                            } else {
                                                iArr8 = iArr6;
                                            }
                                            jArr11 = new long[i29];
                                            i33 = i32;
                                            i34 = 0;
                                            i35 = 0;
                                            j10 = 0;
                                            while (i35 < zzahvVar3.zzh.length) {
                                                j11 = zzahvVar3.zzi[i35];
                                                i36 = iArr3[i35];
                                                i37 = iArr4[i35];
                                                if (z10) {
                                                    int i812 = i37 - i36;
                                                    jArr12 = jArr9;
                                                    System.arraycopy(jArr12, i36, jArr10, i34, i812);
                                                    iArr9 = iArr5;
                                                    System.arraycopy(iArr9, i36, iArr7, i34, i812);
                                                    iArr10 = iArr6;
                                                    System.arraycopy(iArr10, i36, iArr8, i34, i812);
                                                } else {
                                                    iArr9 = iArr5;
                                                    jArr12 = jArr9;
                                                    iArr10 = iArr6;
                                                }
                                                while (i36 < i37) {
                                                    long[] jArr1111 = jArr12;
                                                    long jZzr16 = zzfk.zzr(j10, 1000000L, zzahvVar3.zzd);
                                                    int[] iArr118 = iArr8;
                                                    long[] jArr1112 = jArr3;
                                                    jZzr2 = zzfk.zzr(jArr3[i36] - j11, 1000000L, zzahvVar3.zzc);
                                                    int[] iArr119 = iArr10;
                                                    int i813 = i37;
                                                    if (zzahvVar3.zzb != 1) {
                                                        jZzr2 = Math.max(0L, jZzr2);
                                                    }
                                                    jArr11[i34] = jZzr16 + jZzr2;
                                                    if (!z10) {
                                                    }
                                                    i34++;
                                                    i36++;
                                                    i33 = i33;
                                                    jArr3 = jArr1112;
                                                    i37 = i813;
                                                    iArr10 = iArr119;
                                                    jArr12 = jArr1111;
                                                    iArr8 = iArr118;
                                                }
                                                iArr6 = iArr10;
                                                jArr9 = jArr12;
                                                j10 += zzahvVar3.zzh[i35];
                                                i35++;
                                                i33 = i33;
                                                iArr4 = iArr4;
                                                jArr3 = jArr3;
                                                iArr8 = iArr8;
                                                iArr5 = iArr9;
                                                iArr3 = iArr3;
                                            }
                                            zzahyVar = new zzahy(zzahvVar3, jArr10, iArr7, i33, jArr11, iArr8, zzfk.zzr(j10, 1000000L, zzahvVar3.zzd));
                                        } else if (jArr6[0] == 0) {
                                            long[] jArr1113 = zzahvVar3.zzi;
                                            Objects.requireNonNull(jArr1113);
                                            j13 = jArr1113[0];
                                            while (i42 < jArr3.length) {
                                                jArr3[i42] = zzfk.zzr(jArr3[i42] - j13, 1000000L, zzahvVar3.zzc);
                                            }
                                            zzahyVar = new zzahy(zzahvVar3, jArr4, iArr2, i18, jArr3, iArr, zzfk.zzr(j8 - j13, 1000000L, zzahvVar3.zzc));
                                        } else {
                                            length = 1;
                                            if (zzahvVar3.zzb == 1) {
                                                z7 = true;
                                            } else {
                                                z7 = false;
                                            }
                                            jArr7 = zzahvVar3.zzi;
                                            iArr3 = new int[length];
                                            iArr4 = new int[length];
                                            Objects.requireNonNull(jArr7);
                                            i28 = 0;
                                            i29 = 0;
                                            z8 = false;
                                            i30 = 0;
                                            while (true) {
                                                jArr8 = zzahvVar3.zzh;
                                                i31 = i18;
                                                if (i28 < jArr8.length) {
                                                    break;
                                                    break;
                                                }
                                                long[] jArr1114 = jArr4;
                                                int[] iArr1110 = iArr2;
                                                j12 = jArr7[i28];
                                                if (j12 != -1) {
                                                    long j212 = jArr8[i28];
                                                    boolean z113 = z8;
                                                    i38 = i30;
                                                    iArr11 = iArr;
                                                    long jZzr17 = zzfk.zzr(j212, zzahvVar3.zzc, zzahvVar3.zzd);
                                                    i39 = 1;
                                                    iArr3[i28] = zzfk.zzc(jArr3, j12, true, true);
                                                    iArr4[i28] = zzfk.zza(jArr3, j12 + jZzr17, z7, false);
                                                    while (true) {
                                                        i40 = iArr3[i28];
                                                        i41 = iArr4[i28];
                                                        if (i40 >= i41) {
                                                            break;
                                                            break;
                                                        }
                                                        break;
                                                        break;
                                                        iArr3[i28] = i40 + 1;
                                                        i39 = 1;
                                                    }
                                                    i29 += i41 - i40;
                                                    if (i38 != i40) {
                                                        z11 = true;
                                                    } else {
                                                        z11 = false;
                                                    }
                                                    z8 = z11 | z113;
                                                    i30 = i41;
                                                } else {
                                                    iArr11 = iArr;
                                                    z8 = z8;
                                                }
                                                i28++;
                                                i18 = i31;
                                                iArr2 = iArr1110;
                                                iArr = iArr11;
                                                jArr4 = jArr1114;
                                            }
                                            jArr9 = jArr4;
                                            iArr5 = iArr2;
                                            boolean z114 = z8;
                                            iArr6 = iArr;
                                            if (i29 != iZzb) {
                                                z9 = true;
                                            } else {
                                                z9 = false;
                                            }
                                            z10 = z114 | z9;
                                            if (z10) {
                                                jArr10 = new long[i29];
                                            } else {
                                                jArr10 = jArr9;
                                            }
                                            if (z10) {
                                                iArr7 = new int[i29];
                                            } else {
                                                iArr7 = iArr5;
                                            }
                                            if (true == z10) {
                                                i32 = 0;
                                            } else {
                                                i32 = i31;
                                            }
                                            if (z10) {
                                                iArr8 = new int[i29];
                                            } else {
                                                iArr8 = iArr6;
                                            }
                                            jArr11 = new long[i29];
                                            i33 = i32;
                                            i34 = 0;
                                            i35 = 0;
                                            j10 = 0;
                                            while (i35 < zzahvVar3.zzh.length) {
                                                j11 = zzahvVar3.zzi[i35];
                                                i36 = iArr3[i35];
                                                i37 = iArr4[i35];
                                                if (z10) {
                                                    int i814 = i37 - i36;
                                                    jArr12 = jArr9;
                                                    System.arraycopy(jArr12, i36, jArr10, i34, i814);
                                                    iArr9 = iArr5;
                                                    System.arraycopy(iArr9, i36, iArr7, i34, i814);
                                                    iArr10 = iArr6;
                                                    System.arraycopy(iArr10, i36, iArr8, i34, i814);
                                                } else {
                                                    iArr9 = iArr5;
                                                    jArr12 = jArr9;
                                                    iArr10 = iArr6;
                                                }
                                                while (i36 < i37) {
                                                    long[] jArr1115 = jArr12;
                                                    long jZzr18 = zzfk.zzr(j10, 1000000L, zzahvVar3.zzd);
                                                    int[] iArr1111 = iArr8;
                                                    long[] jArr1116 = jArr3;
                                                    jZzr2 = zzfk.zzr(jArr3[i36] - j11, 1000000L, zzahvVar3.zzc);
                                                    int[] iArr1112 = iArr10;
                                                    int i815 = i37;
                                                    if (zzahvVar3.zzb != 1) {
                                                        jZzr2 = Math.max(0L, jZzr2);
                                                    }
                                                    jArr11[i34] = jZzr18 + jZzr2;
                                                    if (!z10) {
                                                    }
                                                    i34++;
                                                    i36++;
                                                    i33 = i33;
                                                    jArr3 = jArr1116;
                                                    i37 = i815;
                                                    iArr10 = iArr1112;
                                                    jArr12 = jArr1115;
                                                    iArr8 = iArr1111;
                                                }
                                                iArr6 = iArr10;
                                                jArr9 = jArr12;
                                                j10 += zzahvVar3.zzh[i35];
                                                i35++;
                                                i33 = i33;
                                                iArr4 = iArr4;
                                                jArr3 = jArr3;
                                                iArr8 = iArr8;
                                                iArr5 = iArr9;
                                                iArr3 = iArr3;
                                            }
                                            zzahyVar = new zzahy(zzahvVar3, jArr10, iArr7, i33, jArr11, iArr8, zzfk.zzr(j10, 1000000L, zzahvVar3.zzd));
                                        }
                                    } else {
                                        zzaccVar.zza = (int) j14;
                                        zzaccVar.zzb = (int) jZzr10;
                                        zzfk.zzD(jArr3, 1000000L, zzahvVar3.zzc);
                                        zzahyVar = new zzahy(zzahvVar3, jArr4, iArr2, i18, jArr3, iArr, zzfk.zzr(zzahvVar3.zzh[0], 1000000L, zzahvVar3.zzd));
                                    }
                                } else {
                                    jArr6 = zzahvVar3.zzh;
                                    length = jArr6.length;
                                    if (length != 1) {
                                        if (zzahvVar3.zzb == 1) {
                                            z7 = true;
                                        } else {
                                            z7 = false;
                                        }
                                        jArr7 = zzahvVar3.zzi;
                                        iArr3 = new int[length];
                                        iArr4 = new int[length];
                                        Objects.requireNonNull(jArr7);
                                        i28 = 0;
                                        i29 = 0;
                                        z8 = false;
                                        i30 = 0;
                                        while (true) {
                                            jArr8 = zzahvVar3.zzh;
                                            i31 = i18;
                                            if (i28 < jArr8.length) {
                                                break;
                                                break;
                                            }
                                            long[] jArr1117 = jArr4;
                                            int[] iArr1113 = iArr2;
                                            j12 = jArr7[i28];
                                            if (j12 != -1) {
                                                long j213 = jArr8[i28];
                                                boolean z115 = z8;
                                                i38 = i30;
                                                iArr11 = iArr;
                                                long jZzr19 = zzfk.zzr(j213, zzahvVar3.zzc, zzahvVar3.zzd);
                                                i39 = 1;
                                                iArr3[i28] = zzfk.zzc(jArr3, j12, true, true);
                                                iArr4[i28] = zzfk.zza(jArr3, j12 + jZzr19, z7, false);
                                                while (true) {
                                                    i40 = iArr3[i28];
                                                    i41 = iArr4[i28];
                                                    if (i40 >= i41) {
                                                        break;
                                                        break;
                                                    }
                                                    break;
                                                    break;
                                                    iArr3[i28] = i40 + 1;
                                                    i39 = 1;
                                                }
                                                i29 += i41 - i40;
                                                if (i38 != i40) {
                                                    z11 = true;
                                                } else {
                                                    z11 = false;
                                                }
                                                z8 = z11 | z115;
                                                i30 = i41;
                                            } else {
                                                iArr11 = iArr;
                                                z8 = z8;
                                            }
                                            i28++;
                                            i18 = i31;
                                            iArr2 = iArr1113;
                                            iArr = iArr11;
                                            jArr4 = jArr1117;
                                        }
                                        jArr9 = jArr4;
                                        iArr5 = iArr2;
                                        boolean z116 = z8;
                                        iArr6 = iArr;
                                        if (i29 != iZzb) {
                                            z9 = true;
                                        } else {
                                            z9 = false;
                                        }
                                        z10 = z116 | z9;
                                        if (z10) {
                                            jArr10 = new long[i29];
                                        } else {
                                            jArr10 = jArr9;
                                        }
                                        if (z10) {
                                            iArr7 = new int[i29];
                                        } else {
                                            iArr7 = iArr5;
                                        }
                                        if (true == z10) {
                                            i32 = 0;
                                        } else {
                                            i32 = i31;
                                        }
                                        if (z10) {
                                            iArr8 = new int[i29];
                                        } else {
                                            iArr8 = iArr6;
                                        }
                                        jArr11 = new long[i29];
                                        i33 = i32;
                                        i34 = 0;
                                        i35 = 0;
                                        j10 = 0;
                                        while (i35 < zzahvVar3.zzh.length) {
                                            j11 = zzahvVar3.zzi[i35];
                                            i36 = iArr3[i35];
                                            i37 = iArr4[i35];
                                            if (z10) {
                                                int i816 = i37 - i36;
                                                jArr12 = jArr9;
                                                System.arraycopy(jArr12, i36, jArr10, i34, i816);
                                                iArr9 = iArr5;
                                                System.arraycopy(iArr9, i36, iArr7, i34, i816);
                                                iArr10 = iArr6;
                                                System.arraycopy(iArr10, i36, iArr8, i34, i816);
                                            } else {
                                                iArr9 = iArr5;
                                                jArr12 = jArr9;
                                                iArr10 = iArr6;
                                            }
                                            while (i36 < i37) {
                                                long[] jArr1118 = jArr12;
                                                long jZzr110 = zzfk.zzr(j10, 1000000L, zzahvVar3.zzd);
                                                int[] iArr1114 = iArr8;
                                                long[] jArr1119 = jArr3;
                                                jZzr2 = zzfk.zzr(jArr3[i36] - j11, 1000000L, zzahvVar3.zzc);
                                                int[] iArr1115 = iArr10;
                                                int i817 = i37;
                                                if (zzahvVar3.zzb != 1) {
                                                    jZzr2 = Math.max(0L, jZzr2);
                                                }
                                                jArr11[i34] = jZzr110 + jZzr2;
                                                if (!z10) {
                                                }
                                                i34++;
                                                i36++;
                                                i33 = i33;
                                                jArr3 = jArr1119;
                                                i37 = i817;
                                                iArr10 = iArr1115;
                                                jArr12 = jArr1118;
                                                iArr8 = iArr1114;
                                            }
                                            iArr6 = iArr10;
                                            jArr9 = jArr12;
                                            j10 += zzahvVar3.zzh[i35];
                                            i35++;
                                            i33 = i33;
                                            iArr4 = iArr4;
                                            jArr3 = jArr3;
                                            iArr8 = iArr8;
                                            iArr5 = iArr9;
                                            iArr3 = iArr3;
                                        }
                                        zzahyVar = new zzahy(zzahvVar3, jArr10, iArr7, i33, jArr11, iArr8, zzfk.zzr(j10, 1000000L, zzahvVar3.zzd));
                                    } else if (jArr6[0] == 0) {
                                        long[] jArr11110 = zzahvVar3.zzi;
                                        Objects.requireNonNull(jArr11110);
                                        j13 = jArr11110[0];
                                        while (i42 < jArr3.length) {
                                            jArr3[i42] = zzfk.zzr(jArr3[i42] - j13, 1000000L, zzahvVar3.zzc);
                                        }
                                        zzahyVar = new zzahy(zzahvVar3, jArr4, iArr2, i18, jArr3, iArr, zzfk.zzr(j8 - j13, 1000000L, zzahvVar3.zzc));
                                    } else {
                                        length = 1;
                                        if (zzahvVar3.zzb == 1) {
                                            z7 = true;
                                        } else {
                                            z7 = false;
                                        }
                                        jArr7 = zzahvVar3.zzi;
                                        iArr3 = new int[length];
                                        iArr4 = new int[length];
                                        Objects.requireNonNull(jArr7);
                                        i28 = 0;
                                        i29 = 0;
                                        z8 = false;
                                        i30 = 0;
                                        while (true) {
                                            jArr8 = zzahvVar3.zzh;
                                            i31 = i18;
                                            if (i28 < jArr8.length) {
                                                break;
                                                break;
                                            }
                                            long[] jArr11111 = jArr4;
                                            int[] iArr1116 = iArr2;
                                            j12 = jArr7[i28];
                                            if (j12 != -1) {
                                                long j214 = jArr8[i28];
                                                boolean z117 = z8;
                                                i38 = i30;
                                                iArr11 = iArr;
                                                long jZzr111 = zzfk.zzr(j214, zzahvVar3.zzc, zzahvVar3.zzd);
                                                i39 = 1;
                                                iArr3[i28] = zzfk.zzc(jArr3, j12, true, true);
                                                iArr4[i28] = zzfk.zza(jArr3, j12 + jZzr111, z7, false);
                                                while (true) {
                                                    i40 = iArr3[i28];
                                                    i41 = iArr4[i28];
                                                    if (i40 >= i41) {
                                                        break;
                                                        break;
                                                    }
                                                    break;
                                                    break;
                                                    iArr3[i28] = i40 + 1;
                                                    i39 = 1;
                                                }
                                                i29 += i41 - i40;
                                                if (i38 != i40) {
                                                    z11 = true;
                                                } else {
                                                    z11 = false;
                                                }
                                                z8 = z11 | z117;
                                                i30 = i41;
                                            } else {
                                                iArr11 = iArr;
                                                z8 = z8;
                                            }
                                            i28++;
                                            i18 = i31;
                                            iArr2 = iArr1116;
                                            iArr = iArr11;
                                            jArr4 = jArr11111;
                                        }
                                        jArr9 = jArr4;
                                        iArr5 = iArr2;
                                        boolean z118 = z8;
                                        iArr6 = iArr;
                                        if (i29 != iZzb) {
                                            z9 = true;
                                        } else {
                                            z9 = false;
                                        }
                                        z10 = z118 | z9;
                                        if (z10) {
                                            jArr10 = new long[i29];
                                        } else {
                                            jArr10 = jArr9;
                                        }
                                        if (z10) {
                                            iArr7 = new int[i29];
                                        } else {
                                            iArr7 = iArr5;
                                        }
                                        if (true == z10) {
                                            i32 = 0;
                                        } else {
                                            i32 = i31;
                                        }
                                        if (z10) {
                                            iArr8 = new int[i29];
                                        } else {
                                            iArr8 = iArr6;
                                        }
                                        jArr11 = new long[i29];
                                        i33 = i32;
                                        i34 = 0;
                                        i35 = 0;
                                        j10 = 0;
                                        while (i35 < zzahvVar3.zzh.length) {
                                            j11 = zzahvVar3.zzi[i35];
                                            i36 = iArr3[i35];
                                            i37 = iArr4[i35];
                                            if (z10) {
                                                int i818 = i37 - i36;
                                                jArr12 = jArr9;
                                                System.arraycopy(jArr12, i36, jArr10, i34, i818);
                                                iArr9 = iArr5;
                                                System.arraycopy(iArr9, i36, iArr7, i34, i818);
                                                iArr10 = iArr6;
                                                System.arraycopy(iArr10, i36, iArr8, i34, i818);
                                            } else {
                                                iArr9 = iArr5;
                                                jArr12 = jArr9;
                                                iArr10 = iArr6;
                                            }
                                            while (i36 < i37) {
                                                long[] jArr11112 = jArr12;
                                                long jZzr112 = zzfk.zzr(j10, 1000000L, zzahvVar3.zzd);
                                                int[] iArr1117 = iArr8;
                                                long[] jArr11113 = jArr3;
                                                jZzr2 = zzfk.zzr(jArr3[i36] - j11, 1000000L, zzahvVar3.zzc);
                                                int[] iArr1118 = iArr10;
                                                int i819 = i37;
                                                if (zzahvVar3.zzb != 1) {
                                                    jZzr2 = Math.max(0L, jZzr2);
                                                }
                                                jArr11[i34] = jZzr112 + jZzr2;
                                                if (!z10) {
                                                }
                                                i34++;
                                                i36++;
                                                i33 = i33;
                                                jArr3 = jArr11113;
                                                i37 = i819;
                                                iArr10 = iArr1118;
                                                jArr12 = jArr11112;
                                                iArr8 = iArr1117;
                                            }
                                            iArr6 = iArr10;
                                            jArr9 = jArr12;
                                            j10 += zzahvVar3.zzh[i35];
                                            i35++;
                                            i33 = i33;
                                            iArr4 = iArr4;
                                            jArr3 = jArr3;
                                            iArr8 = iArr8;
                                            iArr5 = iArr9;
                                            iArr3 = iArr3;
                                        }
                                        zzahyVar = new zzahy(zzahvVar3, jArr10, iArr7, i33, jArr11, iArr8, zzfk.zzr(j10, 1000000L, zzahvVar3.zzd));
                                    }
                                }
                            }
                        }
                        arrayList2 = arrayList;
                        arrayList2.add(zzahyVar);
                    } else {
                        arrayList2 = arrayList;
                    }
                }
                zzahvVar = null;
                zzahvVar2 = (zzahv) zzfskVar.apply(zzahvVar);
                if (zzahvVar2 != null) {
                    zzagw zzagwVarZza8 = zzagwVar2.zza(1835297121);
                    Objects.requireNonNull(zzagwVarZza8);
                    zzagw zzagwVarZza9 = zzagwVarZza8.zza(1835626086);
                    Objects.requireNonNull(zzagwVarZza9);
                    zzagwVarZza = zzagwVarZza9.zza(1937007212);
                    Objects.requireNonNull(zzagwVarZza);
                    zzagxVarZzb = zzagwVarZza.zzb(1937011578);
                    if (zzagxVarZzb != null) {
                        zzaheVar = new zzahd(zzagxVarZzb, zzahvVar2.zzf);
                    } else {
                        zzagxVarZzb2 = zzagwVarZza.zzb(1937013298);
                        if (zzagxVarZzb2 != null) {
                            throw zzcc.zza("Track has no sample table size information", null);
                        }
                        zzaheVar = new zzahe(zzagxVarZzb2);
                    }
                    iZzb = zzaheVar.zzb();
                    if (iZzb == 0) {
                        zzahyVar = new zzahy(zzahvVar2, new long[0], new int[0], 0, new long[0], new int[0], 0L);
                    } else {
                        zzagxVarZzb3 = zzagwVarZza.zzb(1937007471);
                        if (zzagxVarZzb3 == null) {
                            zzagx zzagxVarZzb14 = zzagwVarZza.zzb(1668232756);
                            Objects.requireNonNull(zzagxVarZzb14);
                            zzagxVar = zzagxVarZzb14;
                            z5 = true;
                        } else {
                            zzagxVar = zzagxVarZzb3;
                            z5 = false;
                        }
                        zzagx zzagxVarZzb15 = zzagwVarZza.zzb(1937011555);
                        Objects.requireNonNull(zzagxVarZzb15);
                        zzagx zzagxVarZzb16 = zzagwVarZza.zzb(1937011827);
                        Objects.requireNonNull(zzagxVarZzb16);
                        zzagxVarZzb4 = zzagwVarZza.zzb(1937011571);
                        if (zzagxVarZzb4 != null) {
                            zzfbVar2 = zzagxVarZzb4.zza;
                        } else {
                            zzfbVar2 = null;
                        }
                        zzagxVarZzb5 = zzagwVarZza.zzb(1668576371);
                        if (zzagxVarZzb5 != null) {
                            zzfbVar3 = zzagxVarZzb5.zza;
                        } else {
                            zzfbVar3 = null;
                        }
                        zzfbVar4 = zzagxVarZzb16.zza;
                        zzagzVar = new zzagz(zzagxVarZzb15.zza, zzagxVar.zza, z5);
                        zzfbVar4.zzG(12);
                        iZzo = zzfbVar4.zzo() + i5;
                        int iZzo10 = zzfbVar4.zzo();
                        iZzo2 = zzfbVar4.zzo();
                        if (zzfbVar3 != null) {
                            zzfbVar3.zzG(12);
                            iZzo3 = zzfbVar3.zzo();
                        } else {
                            iZzo3 = 0;
                        }
                        if (zzfbVar2 != null) {
                            zzfbVar2.zzG(12);
                            iZzo5 = zzfbVar2.zzo();
                            if (iZzo5 > 0) {
                                iZzo4 = zzfbVar2.zzo() + i5;
                            } else {
                                iZzo4 = i5;
                                zzfbVar2 = null;
                            }
                        } else {
                            iZzo4 = i5;
                            iZzo5 = 0;
                        }
                        iZza = zzaheVar.zza();
                        String str17 = zzahvVar2.zzf.zzm;
                        iZzo6 = iZzo10;
                        if (iZza != -1) {
                            jArrCopyOf = new long[iZzb];
                            iArrCopyOf = new int[iZzb];
                            jArrCopyOf2 = new long[iZzb];
                            i15 = iZzo5;
                            iArrCopyOf2 = new int[iZzb];
                            zzahvVar3 = zzahvVar2;
                            iZzf = iZzo2;
                            i16 = iZzo3;
                            i17 = iZzo4;
                            i18 = 0;
                            i19 = 0;
                            iZzo7 = 0;
                            i20 = 0;
                            j6 = 0;
                            j7 = 0;
                            i21 = iZzo;
                            i22 = 0;
                            while (true) {
                                if (i22 < iZzb) {
                                    i21 = i21;
                                    break;
                                }
                                j9 = j6;
                                zZza = true;
                                while (true) {
                                    if (i19 != 0) {
                                        i24 = i19;
                                        break;
                                    }
                                    zZza = zzagzVar.zza();
                                    if (zZza) {
                                        i24 = 0;
                                        break;
                                    }
                                    int i615 = i17;
                                    long j112 = zzagzVar.zzd;
                                    i19 = zzagzVar.zzc;
                                    j9 = j112;
                                    i21 = i21;
                                    i17 = i615;
                                    iZzb = iZzb;
                                }
                                if (!zZza) {
                                    zzer.zzf(str, "Unexpected end of chunk data");
                                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i22);
                                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i22);
                                    jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i22);
                                    iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i22);
                                    iZzb = i22;
                                    break;
                                }
                                iZzf2 = i20;
                                if (zzfbVar3 != null) {
                                    while (iZzo7 == 0) {
                                        if (i16 > 0) {
                                            iZzo7 = 0;
                                            break;
                                        }
                                        i16--;
                                        iZzo7 = zzfbVar3.zzo();
                                        iZzf2 = zzfbVar3.zzf();
                                    }
                                    iZzo7--;
                                }
                                jArrCopyOf[i22] = j9;
                                iZzc = zzaheVar.zzc();
                                iArrCopyOf[i22] = iZzc;
                                if (iZzc > i18) {
                                    i25 = iZzc;
                                } else {
                                    i25 = i18;
                                }
                                jArrCopyOf2[i22] = j7 + ((long) iZzf2);
                                if (zzfbVar2 == null) {
                                    i26 = 1;
                                } else {
                                    i26 = 0;
                                }
                                iArrCopyOf2[i22] = i26;
                                iZzo8 = i17;
                                if (i22 == iZzo8) {
                                    iArrCopyOf2[i22] = 1;
                                    i15--;
                                    if (i15 > 0) {
                                        Objects.requireNonNull(zzfbVar2);
                                        iZzo8 = zzfbVar2.zzo() - 1;
                                    }
                                }
                                zzfb zzfbVar10 = zzfbVar2;
                                int i616 = iZzo8;
                                j7 += (long) iZzf;
                                i27 = iZzo6 - 1;
                                if (i27 == 0) {
                                    iZzo6 = i27;
                                } else if (i21 > 0) {
                                    iZzo6 = zzfbVar4.zzo();
                                    iZzf = zzfbVar4.zzf();
                                    i21--;
                                } else {
                                    iZzo6 = 0;
                                }
                                long j113 = j9 + ((long) iArrCopyOf[i22]);
                                i22++;
                                i20 = iZzf2;
                                i17 = i616;
                                i18 = i25;
                                i19 = i24 - 1;
                                iZzb = iZzb;
                                zzagzVar = zzagzVar;
                                zzfbVar2 = zzfbVar10;
                                i21 = i21;
                                j6 = j113;
                            }
                            long j215 = j7 + ((long) i20);
                            if (zzfbVar3 != null) {
                                z6 = true;
                                break;
                            }
                            while (true) {
                                if (i16 > 0) {
                                    z6 = true;
                                    break;
                                }
                                if (zzfbVar3.zzo() != 0) {
                                    z6 = false;
                                    break;
                                }
                                zzfbVar3.zzf();
                                i16--;
                            }
                            if (i15 == 0) {
                                if (iZzo6 == 0) {
                                    if (i19 == 0) {
                                        z6 = z6;
                                        i19 = i19;
                                        iZzo7 = iZzo7;
                                        zzahvVar3 = zzahvVar3;
                                        i21 = i21;
                                        i23 = 0;
                                        iZzo6 = 0;
                                    } else if (i21 == 0) {
                                        z6 = z6;
                                        iZzo7 = iZzo7;
                                        zzahvVar3 = zzahvVar3;
                                        i21 = i21;
                                        i23 = 0;
                                        iZzo6 = 0;
                                        i19 = 0;
                                    } else if (iZzo7 == 0) {
                                        z6 = z6;
                                        iZzo7 = iZzo7;
                                        zzahvVar3 = zzahvVar3;
                                        i23 = 0;
                                        iZzo6 = 0;
                                        i19 = 0;
                                        i21 = 0;
                                    } else if (z6) {
                                        zzahvVar3 = zzahvVar3;
                                        i23 = 0;
                                        iZzo6 = 0;
                                        i19 = 0;
                                        i21 = 0;
                                        iZzo7 = 0;
                                        z6 = false;
                                    } else {
                                        jArrCopyOf = jArrCopyOf;
                                        zzahvVar3 = zzahvVar3;
                                    }
                                    int i617 = zzahvVar3.zza;
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("Inconsistent stbl box for track ");
                                    sb5.append(i617);
                                    sb5.append(": remainingSynchronizationSamples ");
                                    sb5.append(i23);
                                    sb5.append(", remainingSamplesAtTimestampDelta ");
                                    sb5.append(iZzo6);
                                    sb5.append(", remainingSamplesInChunk ");
                                    sb5.append(i19);
                                    sb5.append(", remainingTimestampDeltaChanges ");
                                    sb5.append(i21);
                                    sb5.append(", remainingSamplesAtTimestampOffset ");
                                    sb5.append(iZzo7);
                                    if (true != z6) {
                                        str7 = ", ctts invalid";
                                    } else {
                                        str7 = "";
                                    }
                                    sb5.append(str7);
                                    zzer.zzf(str, sb5.toString());
                                } else {
                                    i23 = 0;
                                }
                                iArr = iArrCopyOf2;
                                j8 = j215;
                                jArr3 = jArrCopyOf2;
                                jArr4 = jArrCopyOf;
                                iArr2 = iArrCopyOf;
                                iZzb = iZzb;
                            } else {
                                i23 = i15;
                            }
                            int i618 = zzahvVar3.zza;
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("Inconsistent stbl box for track ");
                            sb6.append(i618);
                            sb6.append(": remainingSynchronizationSamples ");
                            sb6.append(i23);
                            sb6.append(", remainingSamplesAtTimestampDelta ");
                            sb6.append(iZzo6);
                            sb6.append(", remainingSamplesInChunk ");
                            sb6.append(i19);
                            sb6.append(", remainingTimestampDeltaChanges ");
                            sb6.append(i21);
                            sb6.append(", remainingSamplesAtTimestampOffset ");
                            sb6.append(iZzo7);
                            if (true != z6) {
                                str7 = ", ctts invalid";
                            } else {
                                str7 = "";
                            }
                            sb6.append(str7);
                            zzer.zzf(str, sb6.toString());
                            iArr = iArrCopyOf2;
                            j8 = j215;
                            jArr3 = jArrCopyOf2;
                            jArr4 = jArrCopyOf;
                            iArr2 = iArrCopyOf;
                            iZzb = iZzb;
                        } else {
                            jArrCopyOf = new long[iZzb];
                            iArrCopyOf = new int[iZzb];
                            jArrCopyOf2 = new long[iZzb];
                            i15 = iZzo5;
                            iArrCopyOf2 = new int[iZzb];
                            zzahvVar3 = zzahvVar2;
                            iZzf = iZzo2;
                            i16 = iZzo3;
                            i17 = iZzo4;
                            i18 = 0;
                            i19 = 0;
                            iZzo7 = 0;
                            i20 = 0;
                            j6 = 0;
                            j7 = 0;
                            i21 = iZzo;
                            i22 = 0;
                            while (true) {
                                if (i22 < iZzb) {
                                    i21 = i21;
                                    break;
                                }
                                j9 = j6;
                                zZza = true;
                                while (true) {
                                    if (i19 != 0) {
                                        i24 = i19;
                                        break;
                                    }
                                    zZza = zzagzVar.zza();
                                    if (zZza) {
                                        i24 = 0;
                                        break;
                                    }
                                    int i619 = i17;
                                    long j114 = zzagzVar.zzd;
                                    i19 = zzagzVar.zzc;
                                    j9 = j114;
                                    i21 = i21;
                                    i17 = i619;
                                    iZzb = iZzb;
                                }
                                if (!zZza) {
                                    zzer.zzf(str, "Unexpected end of chunk data");
                                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i22);
                                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i22);
                                    jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i22);
                                    iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i22);
                                    iZzb = i22;
                                    break;
                                }
                                iZzf2 = i20;
                                if (zzfbVar3 != null) {
                                    while (iZzo7 == 0) {
                                        if (i16 > 0) {
                                            iZzo7 = 0;
                                            break;
                                        }
                                        i16--;
                                        iZzo7 = zzfbVar3.zzo();
                                        iZzf2 = zzfbVar3.zzf();
                                    }
                                    iZzo7--;
                                }
                                jArrCopyOf[i22] = j9;
                                iZzc = zzaheVar.zzc();
                                iArrCopyOf[i22] = iZzc;
                                if (iZzc > i18) {
                                    i25 = iZzc;
                                } else {
                                    i25 = i18;
                                }
                                jArrCopyOf2[i22] = j7 + ((long) iZzf2);
                                if (zzfbVar2 == null) {
                                    i26 = 1;
                                } else {
                                    i26 = 0;
                                }
                                iArrCopyOf2[i22] = i26;
                                iZzo8 = i17;
                                if (i22 == iZzo8) {
                                    iArrCopyOf2[i22] = 1;
                                    i15--;
                                    if (i15 > 0) {
                                        Objects.requireNonNull(zzfbVar2);
                                        iZzo8 = zzfbVar2.zzo() - 1;
                                    }
                                }
                                zzfb zzfbVar11 = zzfbVar2;
                                int i6110 = iZzo8;
                                j7 += (long) iZzf;
                                i27 = iZzo6 - 1;
                                if (i27 == 0) {
                                    iZzo6 = i27;
                                } else if (i21 > 0) {
                                    iZzo6 = zzfbVar4.zzo();
                                    iZzf = zzfbVar4.zzf();
                                    i21--;
                                } else {
                                    iZzo6 = 0;
                                }
                                long j115 = j9 + ((long) iArrCopyOf[i22]);
                                i22++;
                                i20 = iZzf2;
                                i17 = i6110;
                                i18 = i25;
                                i19 = i24 - 1;
                                iZzb = iZzb;
                                zzagzVar = zzagzVar;
                                zzfbVar2 = zzfbVar11;
                                i21 = i21;
                                j6 = j115;
                            }
                            long j216 = j7 + ((long) i20);
                            if (zzfbVar3 != null) {
                                z6 = true;
                                break;
                            }
                            while (true) {
                                if (i16 > 0) {
                                    z6 = true;
                                    break;
                                }
                                if (zzfbVar3.zzo() != 0) {
                                    z6 = false;
                                    break;
                                }
                                zzfbVar3.zzf();
                                i16--;
                            }
                            if (i15 == 0) {
                                if (iZzo6 == 0) {
                                    if (i19 == 0) {
                                        z6 = z6;
                                        i19 = i19;
                                        iZzo7 = iZzo7;
                                        zzahvVar3 = zzahvVar3;
                                        i21 = i21;
                                        i23 = 0;
                                        iZzo6 = 0;
                                    } else if (i21 == 0) {
                                        z6 = z6;
                                        iZzo7 = iZzo7;
                                        zzahvVar3 = zzahvVar3;
                                        i21 = i21;
                                        i23 = 0;
                                        iZzo6 = 0;
                                        i19 = 0;
                                    } else if (iZzo7 == 0) {
                                        z6 = z6;
                                        iZzo7 = iZzo7;
                                        zzahvVar3 = zzahvVar3;
                                        i23 = 0;
                                        iZzo6 = 0;
                                        i19 = 0;
                                        i21 = 0;
                                    } else if (z6) {
                                        zzahvVar3 = zzahvVar3;
                                        i23 = 0;
                                        iZzo6 = 0;
                                        i19 = 0;
                                        i21 = 0;
                                        iZzo7 = 0;
                                        z6 = false;
                                    } else {
                                        jArrCopyOf = jArrCopyOf;
                                        zzahvVar3 = zzahvVar3;
                                    }
                                    int i6111 = zzahvVar3.zza;
                                    StringBuilder sb7 = new StringBuilder();
                                    sb7.append("Inconsistent stbl box for track ");
                                    sb7.append(i6111);
                                    sb7.append(": remainingSynchronizationSamples ");
                                    sb7.append(i23);
                                    sb7.append(", remainingSamplesAtTimestampDelta ");
                                    sb7.append(iZzo6);
                                    sb7.append(", remainingSamplesInChunk ");
                                    sb7.append(i19);
                                    sb7.append(", remainingTimestampDeltaChanges ");
                                    sb7.append(i21);
                                    sb7.append(", remainingSamplesAtTimestampOffset ");
                                    sb7.append(iZzo7);
                                    if (true != z6) {
                                        str7 = ", ctts invalid";
                                    } else {
                                        str7 = "";
                                    }
                                    sb7.append(str7);
                                    zzer.zzf(str, sb7.toString());
                                } else {
                                    i23 = 0;
                                }
                                iArr = iArrCopyOf2;
                                j8 = j216;
                                jArr3 = jArrCopyOf2;
                                jArr4 = jArrCopyOf;
                                iArr2 = iArrCopyOf;
                                iZzb = iZzb;
                            } else {
                                i23 = i15;
                            }
                            int i6112 = zzahvVar3.zza;
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append("Inconsistent stbl box for track ");
                            sb8.append(i6112);
                            sb8.append(": remainingSynchronizationSamples ");
                            sb8.append(i23);
                            sb8.append(", remainingSamplesAtTimestampDelta ");
                            sb8.append(iZzo6);
                            sb8.append(", remainingSamplesInChunk ");
                            sb8.append(i19);
                            sb8.append(", remainingTimestampDeltaChanges ");
                            sb8.append(i21);
                            sb8.append(", remainingSamplesAtTimestampOffset ");
                            sb8.append(iZzo7);
                            if (true != z6) {
                                str7 = ", ctts invalid";
                            } else {
                                str7 = "";
                            }
                            sb8.append(str7);
                            zzer.zzf(str, sb8.toString());
                            iArr = iArrCopyOf2;
                            j8 = j216;
                            jArr3 = jArrCopyOf2;
                            jArr4 = jArrCopyOf;
                            iArr2 = iArrCopyOf;
                            iZzb = iZzb;
                        }
                        jZzr = zzfk.zzr(j8, 1000000L, zzahvVar3.zzc);
                        jArr5 = zzahvVar3.zzh;
                        if (jArr5 == null) {
                            zzfk.zzD(jArr3, 1000000L, zzahvVar3.zzc);
                            zzahyVar = new zzahy(zzahvVar3, jArr4, iArr2, i18, jArr3, iArr, jZzr);
                        } else if (jArr5.length == 1) {
                            jArr6 = zzahvVar3.zzh;
                            length = jArr6.length;
                            if (length != 1) {
                                if (zzahvVar3.zzb == 1) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                jArr7 = zzahvVar3.zzi;
                                iArr3 = new int[length];
                                iArr4 = new int[length];
                                Objects.requireNonNull(jArr7);
                                i28 = 0;
                                i29 = 0;
                                z8 = false;
                                i30 = 0;
                                while (true) {
                                    jArr8 = zzahvVar3.zzh;
                                    i31 = i18;
                                    if (i28 < jArr8.length) {
                                        break;
                                        break;
                                    }
                                    long[] jArr11114 = jArr4;
                                    int[] iArr1119 = iArr2;
                                    j12 = jArr7[i28];
                                    if (j12 != -1) {
                                        long j217 = jArr8[i28];
                                        boolean z119 = z8;
                                        i38 = i30;
                                        iArr11 = iArr;
                                        long jZzr113 = zzfk.zzr(j217, zzahvVar3.zzc, zzahvVar3.zzd);
                                        i39 = 1;
                                        iArr3[i28] = zzfk.zzc(jArr3, j12, true, true);
                                        iArr4[i28] = zzfk.zza(jArr3, j12 + jZzr113, z7, false);
                                        while (true) {
                                            i40 = iArr3[i28];
                                            i41 = iArr4[i28];
                                            if (i40 >= i41) {
                                                break;
                                                break;
                                            }
                                            break;
                                            break;
                                            iArr3[i28] = i40 + 1;
                                            i39 = 1;
                                        }
                                        i29 += i41 - i40;
                                        if (i38 != i40) {
                                            z11 = true;
                                        } else {
                                            z11 = false;
                                        }
                                        z8 = z11 | z119;
                                        i30 = i41;
                                    } else {
                                        iArr11 = iArr;
                                        z8 = z8;
                                    }
                                    i28++;
                                    i18 = i31;
                                    iArr2 = iArr1119;
                                    iArr = iArr11;
                                    jArr4 = jArr11114;
                                }
                                jArr9 = jArr4;
                                iArr5 = iArr2;
                                boolean z1110 = z8;
                                iArr6 = iArr;
                                if (i29 != iZzb) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                z10 = z1110 | z9;
                                if (z10) {
                                    jArr10 = new long[i29];
                                } else {
                                    jArr10 = jArr9;
                                }
                                if (z10) {
                                    iArr7 = new int[i29];
                                } else {
                                    iArr7 = iArr5;
                                }
                                if (true == z10) {
                                    i32 = 0;
                                } else {
                                    i32 = i31;
                                }
                                if (z10) {
                                    iArr8 = new int[i29];
                                } else {
                                    iArr8 = iArr6;
                                }
                                jArr11 = new long[i29];
                                i33 = i32;
                                i34 = 0;
                                i35 = 0;
                                j10 = 0;
                                while (i35 < zzahvVar3.zzh.length) {
                                    j11 = zzahvVar3.zzi[i35];
                                    i36 = iArr3[i35];
                                    i37 = iArr4[i35];
                                    if (z10) {
                                        int i8110 = i37 - i36;
                                        jArr12 = jArr9;
                                        System.arraycopy(jArr12, i36, jArr10, i34, i8110);
                                        iArr9 = iArr5;
                                        System.arraycopy(iArr9, i36, iArr7, i34, i8110);
                                        iArr10 = iArr6;
                                        System.arraycopy(iArr10, i36, iArr8, i34, i8110);
                                    } else {
                                        iArr9 = iArr5;
                                        jArr12 = jArr9;
                                        iArr10 = iArr6;
                                    }
                                    while (i36 < i37) {
                                        long[] jArr11115 = jArr12;
                                        long jZzr114 = zzfk.zzr(j10, 1000000L, zzahvVar3.zzd);
                                        int[] iArr11110 = iArr8;
                                        long[] jArr11116 = jArr3;
                                        jZzr2 = zzfk.zzr(jArr3[i36] - j11, 1000000L, zzahvVar3.zzc);
                                        int[] iArr11111 = iArr10;
                                        int i8111 = i37;
                                        if (zzahvVar3.zzb != 1) {
                                            jZzr2 = Math.max(0L, jZzr2);
                                        }
                                        jArr11[i34] = jZzr114 + jZzr2;
                                        if (!z10) {
                                        }
                                        i34++;
                                        i36++;
                                        i33 = i33;
                                        jArr3 = jArr11116;
                                        i37 = i8111;
                                        iArr10 = iArr11111;
                                        jArr12 = jArr11115;
                                        iArr8 = iArr11110;
                                    }
                                    iArr6 = iArr10;
                                    jArr9 = jArr12;
                                    j10 += zzahvVar3.zzh[i35];
                                    i35++;
                                    i33 = i33;
                                    iArr4 = iArr4;
                                    jArr3 = jArr3;
                                    iArr8 = iArr8;
                                    iArr5 = iArr9;
                                    iArr3 = iArr3;
                                }
                                zzahyVar = new zzahy(zzahvVar3, jArr10, iArr7, i33, jArr11, iArr8, zzfk.zzr(j10, 1000000L, zzahvVar3.zzd));
                            } else if (jArr6[0] == 0) {
                                long[] jArr11117 = zzahvVar3.zzi;
                                Objects.requireNonNull(jArr11117);
                                j13 = jArr11117[0];
                                while (i42 < jArr3.length) {
                                    jArr3[i42] = zzfk.zzr(jArr3[i42] - j13, 1000000L, zzahvVar3.zzc);
                                }
                                zzahyVar = new zzahy(zzahvVar3, jArr4, iArr2, i18, jArr3, iArr, zzfk.zzr(j8 - j13, 1000000L, zzahvVar3.zzc));
                            } else {
                                length = 1;
                                if (zzahvVar3.zzb == 1) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                jArr7 = zzahvVar3.zzi;
                                iArr3 = new int[length];
                                iArr4 = new int[length];
                                Objects.requireNonNull(jArr7);
                                i28 = 0;
                                i29 = 0;
                                z8 = false;
                                i30 = 0;
                                while (true) {
                                    jArr8 = zzahvVar3.zzh;
                                    i31 = i18;
                                    if (i28 < jArr8.length) {
                                        break;
                                        break;
                                    }
                                    long[] jArr11118 = jArr4;
                                    int[] iArr11112 = iArr2;
                                    j12 = jArr7[i28];
                                    if (j12 != -1) {
                                        long j218 = jArr8[i28];
                                        boolean z1111 = z8;
                                        i38 = i30;
                                        iArr11 = iArr;
                                        long jZzr115 = zzfk.zzr(j218, zzahvVar3.zzc, zzahvVar3.zzd);
                                        i39 = 1;
                                        iArr3[i28] = zzfk.zzc(jArr3, j12, true, true);
                                        iArr4[i28] = zzfk.zza(jArr3, j12 + jZzr115, z7, false);
                                        while (true) {
                                            i40 = iArr3[i28];
                                            i41 = iArr4[i28];
                                            if (i40 >= i41) {
                                                break;
                                                break;
                                            }
                                            break;
                                            break;
                                            iArr3[i28] = i40 + 1;
                                            i39 = 1;
                                        }
                                        i29 += i41 - i40;
                                        if (i38 != i40) {
                                            z11 = true;
                                        } else {
                                            z11 = false;
                                        }
                                        z8 = z11 | z1111;
                                        i30 = i41;
                                    } else {
                                        iArr11 = iArr;
                                        z8 = z8;
                                    }
                                    i28++;
                                    i18 = i31;
                                    iArr2 = iArr11112;
                                    iArr = iArr11;
                                    jArr4 = jArr11118;
                                }
                                jArr9 = jArr4;
                                iArr5 = iArr2;
                                boolean z1112 = z8;
                                iArr6 = iArr;
                                if (i29 != iZzb) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                z10 = z1112 | z9;
                                if (z10) {
                                    jArr10 = new long[i29];
                                } else {
                                    jArr10 = jArr9;
                                }
                                if (z10) {
                                    iArr7 = new int[i29];
                                } else {
                                    iArr7 = iArr5;
                                }
                                if (true == z10) {
                                    i32 = 0;
                                } else {
                                    i32 = i31;
                                }
                                if (z10) {
                                    iArr8 = new int[i29];
                                } else {
                                    iArr8 = iArr6;
                                }
                                jArr11 = new long[i29];
                                i33 = i32;
                                i34 = 0;
                                i35 = 0;
                                j10 = 0;
                                while (i35 < zzahvVar3.zzh.length) {
                                    j11 = zzahvVar3.zzi[i35];
                                    i36 = iArr3[i35];
                                    i37 = iArr4[i35];
                                    if (z10) {
                                        int i8112 = i37 - i36;
                                        jArr12 = jArr9;
                                        System.arraycopy(jArr12, i36, jArr10, i34, i8112);
                                        iArr9 = iArr5;
                                        System.arraycopy(iArr9, i36, iArr7, i34, i8112);
                                        iArr10 = iArr6;
                                        System.arraycopy(iArr10, i36, iArr8, i34, i8112);
                                    } else {
                                        iArr9 = iArr5;
                                        jArr12 = jArr9;
                                        iArr10 = iArr6;
                                    }
                                    while (i36 < i37) {
                                        long[] jArr11119 = jArr12;
                                        long jZzr116 = zzfk.zzr(j10, 1000000L, zzahvVar3.zzd);
                                        int[] iArr11113 = iArr8;
                                        long[] jArr111110 = jArr3;
                                        jZzr2 = zzfk.zzr(jArr3[i36] - j11, 1000000L, zzahvVar3.zzc);
                                        int[] iArr11114 = iArr10;
                                        int i8113 = i37;
                                        if (zzahvVar3.zzb != 1) {
                                            jZzr2 = Math.max(0L, jZzr2);
                                        }
                                        jArr11[i34] = jZzr116 + jZzr2;
                                        if (!z10) {
                                        }
                                        i34++;
                                        i36++;
                                        i33 = i33;
                                        jArr3 = jArr111110;
                                        i37 = i8113;
                                        iArr10 = iArr11114;
                                        jArr12 = jArr11119;
                                        iArr8 = iArr11113;
                                    }
                                    iArr6 = iArr10;
                                    jArr9 = jArr12;
                                    j10 += zzahvVar3.zzh[i35];
                                    i35++;
                                    i33 = i33;
                                    iArr4 = iArr4;
                                    jArr3 = jArr3;
                                    iArr8 = iArr8;
                                    iArr5 = iArr9;
                                    iArr3 = iArr3;
                                }
                                zzahyVar = new zzahy(zzahvVar3, jArr10, iArr7, i33, jArr11, iArr8, zzfk.zzr(j10, 1000000L, zzahvVar3.zzd));
                            }
                        } else {
                            jArr6 = zzahvVar3.zzh;
                            length = jArr6.length;
                            if (length != 1) {
                                if (zzahvVar3.zzb == 1) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                jArr7 = zzahvVar3.zzi;
                                iArr3 = new int[length];
                                iArr4 = new int[length];
                                Objects.requireNonNull(jArr7);
                                i28 = 0;
                                i29 = 0;
                                z8 = false;
                                i30 = 0;
                                while (true) {
                                    jArr8 = zzahvVar3.zzh;
                                    i31 = i18;
                                    if (i28 < jArr8.length) {
                                        break;
                                        break;
                                    }
                                    long[] jArr111111 = jArr4;
                                    int[] iArr11115 = iArr2;
                                    j12 = jArr7[i28];
                                    if (j12 != -1) {
                                        long j219 = jArr8[i28];
                                        boolean z1113 = z8;
                                        i38 = i30;
                                        iArr11 = iArr;
                                        long jZzr117 = zzfk.zzr(j219, zzahvVar3.zzc, zzahvVar3.zzd);
                                        i39 = 1;
                                        iArr3[i28] = zzfk.zzc(jArr3, j12, true, true);
                                        iArr4[i28] = zzfk.zza(jArr3, j12 + jZzr117, z7, false);
                                        while (true) {
                                            i40 = iArr3[i28];
                                            i41 = iArr4[i28];
                                            if (i40 >= i41) {
                                                break;
                                                break;
                                            }
                                            break;
                                            break;
                                            iArr3[i28] = i40 + 1;
                                            i39 = 1;
                                        }
                                        i29 += i41 - i40;
                                        if (i38 != i40) {
                                            z11 = true;
                                        } else {
                                            z11 = false;
                                        }
                                        z8 = z11 | z1113;
                                        i30 = i41;
                                    } else {
                                        iArr11 = iArr;
                                        z8 = z8;
                                    }
                                    i28++;
                                    i18 = i31;
                                    iArr2 = iArr11115;
                                    iArr = iArr11;
                                    jArr4 = jArr111111;
                                }
                                jArr9 = jArr4;
                                iArr5 = iArr2;
                                boolean z1114 = z8;
                                iArr6 = iArr;
                                if (i29 != iZzb) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                z10 = z1114 | z9;
                                if (z10) {
                                    jArr10 = new long[i29];
                                } else {
                                    jArr10 = jArr9;
                                }
                                if (z10) {
                                    iArr7 = new int[i29];
                                } else {
                                    iArr7 = iArr5;
                                }
                                if (true == z10) {
                                    i32 = 0;
                                } else {
                                    i32 = i31;
                                }
                                if (z10) {
                                    iArr8 = new int[i29];
                                } else {
                                    iArr8 = iArr6;
                                }
                                jArr11 = new long[i29];
                                i33 = i32;
                                i34 = 0;
                                i35 = 0;
                                j10 = 0;
                                while (i35 < zzahvVar3.zzh.length) {
                                    j11 = zzahvVar3.zzi[i35];
                                    i36 = iArr3[i35];
                                    i37 = iArr4[i35];
                                    if (z10) {
                                        int i8114 = i37 - i36;
                                        jArr12 = jArr9;
                                        System.arraycopy(jArr12, i36, jArr10, i34, i8114);
                                        iArr9 = iArr5;
                                        System.arraycopy(iArr9, i36, iArr7, i34, i8114);
                                        iArr10 = iArr6;
                                        System.arraycopy(iArr10, i36, iArr8, i34, i8114);
                                    } else {
                                        iArr9 = iArr5;
                                        jArr12 = jArr9;
                                        iArr10 = iArr6;
                                    }
                                    while (i36 < i37) {
                                        long[] jArr111112 = jArr12;
                                        long jZzr118 = zzfk.zzr(j10, 1000000L, zzahvVar3.zzd);
                                        int[] iArr11116 = iArr8;
                                        long[] jArr111113 = jArr3;
                                        jZzr2 = zzfk.zzr(jArr3[i36] - j11, 1000000L, zzahvVar3.zzc);
                                        int[] iArr11117 = iArr10;
                                        int i8115 = i37;
                                        if (zzahvVar3.zzb != 1) {
                                            jZzr2 = Math.max(0L, jZzr2);
                                        }
                                        jArr11[i34] = jZzr118 + jZzr2;
                                        if (!z10) {
                                        }
                                        i34++;
                                        i36++;
                                        i33 = i33;
                                        jArr3 = jArr111113;
                                        i37 = i8115;
                                        iArr10 = iArr11117;
                                        jArr12 = jArr111112;
                                        iArr8 = iArr11116;
                                    }
                                    iArr6 = iArr10;
                                    jArr9 = jArr12;
                                    j10 += zzahvVar3.zzh[i35];
                                    i35++;
                                    i33 = i33;
                                    iArr4 = iArr4;
                                    jArr3 = jArr3;
                                    iArr8 = iArr8;
                                    iArr5 = iArr9;
                                    iArr3 = iArr3;
                                }
                                zzahyVar = new zzahy(zzahvVar3, jArr10, iArr7, i33, jArr11, iArr8, zzfk.zzr(j10, 1000000L, zzahvVar3.zzd));
                            } else if (jArr6[0] == 0) {
                                long[] jArr111114 = zzahvVar3.zzi;
                                Objects.requireNonNull(jArr111114);
                                j13 = jArr111114[0];
                                while (i42 < jArr3.length) {
                                    jArr3[i42] = zzfk.zzr(jArr3[i42] - j13, 1000000L, zzahvVar3.zzc);
                                }
                                zzahyVar = new zzahy(zzahvVar3, jArr4, iArr2, i18, jArr3, iArr, zzfk.zzr(j8 - j13, 1000000L, zzahvVar3.zzc));
                            } else {
                                length = 1;
                                if (zzahvVar3.zzb == 1) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                jArr7 = zzahvVar3.zzi;
                                iArr3 = new int[length];
                                iArr4 = new int[length];
                                Objects.requireNonNull(jArr7);
                                i28 = 0;
                                i29 = 0;
                                z8 = false;
                                i30 = 0;
                                while (true) {
                                    jArr8 = zzahvVar3.zzh;
                                    i31 = i18;
                                    if (i28 < jArr8.length) {
                                        break;
                                        break;
                                    }
                                    long[] jArr111115 = jArr4;
                                    int[] iArr11118 = iArr2;
                                    j12 = jArr7[i28];
                                    if (j12 != -1) {
                                        long j2110 = jArr8[i28];
                                        boolean z1115 = z8;
                                        i38 = i30;
                                        iArr11 = iArr;
                                        long jZzr119 = zzfk.zzr(j2110, zzahvVar3.zzc, zzahvVar3.zzd);
                                        i39 = 1;
                                        iArr3[i28] = zzfk.zzc(jArr3, j12, true, true);
                                        iArr4[i28] = zzfk.zza(jArr3, j12 + jZzr119, z7, false);
                                        while (true) {
                                            i40 = iArr3[i28];
                                            i41 = iArr4[i28];
                                            if (i40 >= i41) {
                                                break;
                                                break;
                                            }
                                            break;
                                            break;
                                            iArr3[i28] = i40 + 1;
                                            i39 = 1;
                                        }
                                        i29 += i41 - i40;
                                        if (i38 != i40) {
                                            z11 = true;
                                        } else {
                                            z11 = false;
                                        }
                                        z8 = z11 | z1115;
                                        i30 = i41;
                                    } else {
                                        iArr11 = iArr;
                                        z8 = z8;
                                    }
                                    i28++;
                                    i18 = i31;
                                    iArr2 = iArr11118;
                                    iArr = iArr11;
                                    jArr4 = jArr111115;
                                }
                                jArr9 = jArr4;
                                iArr5 = iArr2;
                                boolean z1116 = z8;
                                iArr6 = iArr;
                                if (i29 != iZzb) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                z10 = z1116 | z9;
                                if (z10) {
                                    jArr10 = new long[i29];
                                } else {
                                    jArr10 = jArr9;
                                }
                                if (z10) {
                                    iArr7 = new int[i29];
                                } else {
                                    iArr7 = iArr5;
                                }
                                if (true == z10) {
                                    i32 = 0;
                                } else {
                                    i32 = i31;
                                }
                                if (z10) {
                                    iArr8 = new int[i29];
                                } else {
                                    iArr8 = iArr6;
                                }
                                jArr11 = new long[i29];
                                i33 = i32;
                                i34 = 0;
                                i35 = 0;
                                j10 = 0;
                                while (i35 < zzahvVar3.zzh.length) {
                                    j11 = zzahvVar3.zzi[i35];
                                    i36 = iArr3[i35];
                                    i37 = iArr4[i35];
                                    if (z10) {
                                        int i8116 = i37 - i36;
                                        jArr12 = jArr9;
                                        System.arraycopy(jArr12, i36, jArr10, i34, i8116);
                                        iArr9 = iArr5;
                                        System.arraycopy(iArr9, i36, iArr7, i34, i8116);
                                        iArr10 = iArr6;
                                        System.arraycopy(iArr10, i36, iArr8, i34, i8116);
                                    } else {
                                        iArr9 = iArr5;
                                        jArr12 = jArr9;
                                        iArr10 = iArr6;
                                    }
                                    while (i36 < i37) {
                                        long[] jArr111116 = jArr12;
                                        long jZzr1110 = zzfk.zzr(j10, 1000000L, zzahvVar3.zzd);
                                        int[] iArr11119 = iArr8;
                                        long[] jArr111117 = jArr3;
                                        jZzr2 = zzfk.zzr(jArr3[i36] - j11, 1000000L, zzahvVar3.zzc);
                                        int[] iArr111110 = iArr10;
                                        int i8117 = i37;
                                        if (zzahvVar3.zzb != 1) {
                                            jZzr2 = Math.max(0L, jZzr2);
                                        }
                                        jArr11[i34] = jZzr1110 + jZzr2;
                                        if (!z10) {
                                        }
                                        i34++;
                                        i36++;
                                        i33 = i33;
                                        jArr3 = jArr111117;
                                        i37 = i8117;
                                        iArr10 = iArr111110;
                                        jArr12 = jArr111116;
                                        iArr8 = iArr11119;
                                    }
                                    iArr6 = iArr10;
                                    jArr9 = jArr12;
                                    j10 += zzahvVar3.zzh[i35];
                                    i35++;
                                    i33 = i33;
                                    iArr4 = iArr4;
                                    jArr3 = jArr3;
                                    iArr8 = iArr8;
                                    iArr5 = iArr9;
                                    iArr3 = iArr3;
                                }
                                zzahyVar = new zzahy(zzahvVar3, jArr10, iArr7, i33, jArr11, iArr8, zzfk.zzr(j10, 1000000L, zzahvVar3.zzd));
                            }
                        }
                    }
                    arrayList2 = arrayList;
                    arrayList2.add(zzahyVar);
                } else {
                    arrayList2 = arrayList;
                }
            }
            i43 = i + 1;
            arrayList3 = arrayList2;
        }
        return arrayList3;
    }

    public static void zze(zzfb zzfbVar) {
        int iZzc = zzfbVar.zzc();
        zzfbVar.zzH(4);
        if (zzfbVar.zzf() != 1751411826) {
            iZzc += 4;
        }
        zzfbVar.zzG(iZzc);
    }

    private static int zzf(int i) {
        if (i == 1936684398) {
            return 1;
        }
        if (i == 1986618469) {
            return 2;
        }
        if (i == 1952807028 || i == 1935832172 || i == 1937072756 || i == 1668047728) {
            return 3;
        }
        return i == 1835365473 ? 5 : -1;
    }

    private static int zzg(zzfb zzfbVar) {
        int iZzl = zzfbVar.zzl();
        int i = iZzl & WorkQueueKt.MASK;
        while ((iZzl & 128) == 128) {
            iZzl = zzfbVar.zzl();
            i = (i << 7) | (iZzl & WorkQueueKt.MASK);
        }
        return i;
    }

    private static int zzh(zzfb zzfbVar) {
        zzfbVar.zzG(16);
        return zzfbVar.zzf();
    }

    private static Pair zzi(zzagw zzagwVar) {
        zzagx zzagxVarZzb = zzagwVar.zzb(1701606260);
        if (zzagxVarZzb == null) {
            return null;
        }
        zzfb zzfbVar = zzagxVarZzb.zza;
        zzfbVar.zzG(8);
        int iZze = zzagy.zze(zzfbVar.zzf());
        int iZzo = zzfbVar.zzo();
        long[] jArr = new long[iZzo];
        long[] jArr2 = new long[iZzo];
        for (int i = 0; i < iZzo; i++) {
            jArr[i] = iZze == 1 ? zzfbVar.zzu() : zzfbVar.zzt();
            jArr2[i] = iZze == 1 ? zzfbVar.zzs() : zzfbVar.zzf();
            if (zzfbVar.zzz() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            zzfbVar.zzH(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static Pair zzj(zzfb zzfbVar) {
        zzfbVar.zzG(8);
        int iZze = zzagy.zze(zzfbVar.zzf());
        zzfbVar.zzH(iZze == 0 ? 8 : 16);
        long jZzt = zzfbVar.zzt();
        zzfbVar.zzH(iZze == 0 ? 4 : 8);
        int iZzp = zzfbVar.zzp();
        StringBuilder sb = new StringBuilder();
        sb.append((char) (((iZzp >> 10) & 31) + 96));
        sb.append((char) (((iZzp >> 5) & 31) + 96));
        sb.append((char) ((iZzp & 31) + 96));
        return Pair.create(Long.valueOf(jZzt), sb.toString());
    }

    private static Pair zzk(zzfb zzfbVar, int i, int i2) throws zzcc {
        zzahw zzahwVar;
        Pair pairCreate;
        int i3;
        int i4;
        byte[] bArr;
        int iZzc = zzfbVar.zzc();
        while (iZzc - i < i2) {
            zzfbVar.zzG(iZzc);
            int iZzf = zzfbVar.zzf();
            zzabq.zzb(iZzf > 0, "childAtomSize must be positive");
            if (zzfbVar.zzf() == 1936289382) {
                int i5 = iZzc + 8;
                int i6 = 0;
                int i7 = -1;
                String strZzy = null;
                Integer numValueOf = null;
                while (i5 - iZzc < iZzf) {
                    zzfbVar.zzG(i5);
                    int iZzf2 = zzfbVar.zzf();
                    int iZzf3 = zzfbVar.zzf();
                    if (iZzf3 == 1718775137) {
                        numValueOf = Integer.valueOf(zzfbVar.zzf());
                    } else if (iZzf3 == 1935894637) {
                        zzfbVar.zzH(4);
                        strZzy = zzfbVar.zzy(4, zzfsi.zzc);
                    } else if (iZzf3 == 1935894633) {
                        i7 = i5;
                        i6 = iZzf2;
                    }
                    i5 += iZzf2;
                }
                if ("cenc".equals(strZzy) || "cbc1".equals(strZzy) || "cens".equals(strZzy) || "cbcs".equals(strZzy)) {
                    zzabq.zzb(numValueOf != null, "frma atom is mandatory");
                    zzabq.zzb(i7 != -1, "schi atom is mandatory");
                    int i8 = i7 + 8;
                    while (true) {
                        if (i8 - i7 >= i6) {
                            zzahwVar = null;
                            break;
                        }
                        zzfbVar.zzG(i8);
                        int iZzf4 = zzfbVar.zzf();
                        if (zzfbVar.zzf() == 1952804451) {
                            int iZze = zzagy.zze(zzfbVar.zzf());
                            zzfbVar.zzH(1);
                            if (iZze == 0) {
                                zzfbVar.zzH(1);
                                i3 = 0;
                                i4 = 0;
                            } else {
                                int iZzl = zzfbVar.zzl();
                                int i9 = (iZzl & 240) >> 4;
                                i3 = iZzl & 15;
                                i4 = i9;
                            }
                            boolean z = zzfbVar.zzl() == 1;
                            int iZzl2 = zzfbVar.zzl();
                            byte[] bArr2 = new byte[16];
                            zzfbVar.zzC(bArr2, 0, 16);
                            if (z && iZzl2 == 0) {
                                int iZzl3 = zzfbVar.zzl();
                                byte[] bArr3 = new byte[iZzl3];
                                zzfbVar.zzC(bArr3, 0, iZzl3);
                                bArr = bArr3;
                            } else {
                                bArr = null;
                            }
                            zzahwVar = new zzahw(z, strZzy, iZzl2, bArr2, i4, i3, bArr);
                            break;
                        }
                        i8 += iZzf4;
                    }
                    zzabq.zzb(zzahwVar != null, "tenc atom is mandatory");
                    int i10 = zzfk.zza;
                    pairCreate = Pair.create(numValueOf, zzahwVar);
                } else {
                    pairCreate = null;
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            iZzc += iZzf;
        }
        return null;
    }

    private static zzby zzl(zzfb zzfbVar) {
        short sZzz = zzfbVar.zzz();
        zzfbVar.zzH(2);
        String strZzy = zzfbVar.zzy(sZzz, zzfsi.zzc);
        int iMax = Math.max(strZzy.lastIndexOf(43), strZzy.lastIndexOf(45));
        try {
            return new zzby(-9223372036854775807L, new zzfr(Float.parseFloat(strZzy.substring(0, iMax)), Float.parseFloat(strZzy.substring(iMax, strZzy.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static zzaha zzm(zzfb zzfbVar, int i) {
        zzfbVar.zzG(i + 12);
        zzfbVar.zzH(1);
        zzg(zzfbVar);
        zzfbVar.zzH(2);
        int iZzl = zzfbVar.zzl();
        if ((iZzl & 128) != 0) {
            zzfbVar.zzH(2);
        }
        if ((iZzl & 64) != 0) {
            zzfbVar.zzH(zzfbVar.zzl());
        }
        if ((iZzl & 32) != 0) {
            zzfbVar.zzH(2);
        }
        zzfbVar.zzH(1);
        zzg(zzfbVar);
        String strZzd = zzcb.zzd(zzfbVar.zzl());
        if ("audio/mpeg".equals(strZzd) || "audio/vnd.dts".equals(strZzd) || "audio/vnd.dts.hd".equals(strZzd)) {
            return new zzaha(strZzd, null, -1L, -1L);
        }
        zzfbVar.zzH(4);
        long jZzt = zzfbVar.zzt();
        long jZzt2 = zzfbVar.zzt();
        zzfbVar.zzH(1);
        int iZzg = zzg(zzfbVar);
        byte[] bArr = new byte[iZzg];
        zzfbVar.zzC(bArr, 0, iZzg);
        return new zzaha(strZzd, bArr, jZzt2 <= 0 ? -1L : jZzt2, jZzt > 0 ? jZzt : -1L);
    }

    private static ByteBuffer zzn() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x007f  */
    /* JADX WARN: Code duplicated, block: B:80:0x0139  */
    private static void zzo(zzfb zzfbVar, int i, int i2, int i3, int i4, String str, boolean z, zzad zzadVar, zzahc zzahcVar, int i5) throws zzcc {
        int iZzp;
        int iZzp2;
        int iZzm;
        int iZzf;
        int i6;
        zzad zzadVarZzb;
        String str2;
        int i7;
        int i8;
        String str3;
        boolean z2;
        zzfb zzfbVar2 = zzfbVar;
        int i9 = i2;
        int i10 = i3;
        zzfbVar2.zzG(i9 + 16);
        if (z) {
            iZzp = zzfbVar.zzp();
            zzfbVar2.zzH(6);
        } else {
            zzfbVar2.zzH(8);
            iZzp = 0;
        }
        if (iZzp == 0 || iZzp == 1) {
            iZzp2 = zzfbVar.zzp();
            zzfbVar2.zzH(6);
            iZzm = zzfbVar.zzm();
            zzfbVar2.zzG(zzfbVar.zzc() - 4);
            iZzf = zzfbVar.zzf();
            if (iZzp == 1) {
                zzfbVar2.zzH(16);
            }
            i6 = -1;
        } else {
            if (iZzp != 2) {
                return;
            }
            zzfbVar2.zzH(16);
            iZzm = (int) Math.round(Double.longBitsToDouble(zzfbVar.zzs()));
            iZzp2 = zzfbVar.zzo();
            zzfbVar2.zzH(4);
            int iZzo = zzfbVar.zzo();
            int iZzo2 = zzfbVar.zzo();
            int i11 = iZzo2 & 1;
            int i12 = iZzo2 & 2;
            if (i11 == 0) {
                if (iZzo == 8) {
                    i6 = 3;
                } else if (iZzo == 16) {
                    i6 = i12 != 0 ? 268435456 : 2;
                } else if (iZzo == 24) {
                    i6 = i12 != 0 ? 1342177280 : 536870912;
                } else if (iZzo == 32) {
                    i6 = i12 != 0 ? 1610612736 : 805306368;
                } else {
                    i6 = -1;
                }
            } else if (iZzo == 32) {
                i6 = 4;
            } else {
                i6 = -1;
            }
            zzfbVar2.zzH(8);
            iZzf = 0;
        }
        int iZzc = zzfbVar.zzc();
        int iIntValue = 1701733217;
        int i13 = i;
        if (i13 == 1701733217) {
            Pair pairZzk = zzk(zzfbVar2, i9, i10);
            if (pairZzk != null) {
                iIntValue = ((Integer) pairZzk.first).intValue();
                zzadVarZzb = zzadVar == null ? null : zzadVar.zzb(((zzahw) pairZzk.second).zzb);
                zzahcVar.zza[i5] = (zzahw) pairZzk.second;
            } else {
                zzadVarZzb = zzadVar;
            }
            zzfbVar2.zzG(iZzc);
            i13 = iIntValue;
        } else {
            zzadVarZzb = zzadVar;
        }
        if (i13 == 1633889587) {
            str2 = "audio/ac3";
        } else if (i13 == 1700998451) {
            str2 = "audio/eac3";
        } else if (i13 == 1633889588) {
            str2 = "audio/ac4";
        } else if (i13 == 1685353315) {
            str2 = "audio/vnd.dts";
        } else if (i13 == 1685353320 || i13 == 1685353324) {
            str2 = "audio/vnd.dts.hd";
        } else if (i13 == 1685353317) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i13 == 1685353336) {
            str2 = "audio/vnd.dts.uhd;profile=p2";
        } else if (i13 == 1935764850) {
            str2 = "audio/3gpp";
        } else if (i13 == 1935767394) {
            str2 = "audio/amr-wb";
        } else if (i13 == 1936684916) {
            str2 = "audio/raw";
            i6 = 2;
        } else if (i13 == 1953984371) {
            str2 = "audio/raw";
            i6 = 268435456;
        } else if (i13 == 1819304813) {
            if (i6 == -1) {
                str2 = "audio/raw";
                i6 = 2;
            } else {
                str2 = "audio/raw";
            }
        } else if (i13 == 778924082 || i13 == 778924083) {
            str2 = "audio/mpeg";
        } else if (i13 == 1835557169) {
            str2 = "audio/mha1";
        } else if (i13 == 1835560241) {
            str2 = "audio/mhm1";
        } else if (i13 == 1634492771) {
            str2 = "audio/alac";
        } else if (i13 == 1634492791) {
            str2 = "audio/g711-alaw";
        } else if (i13 == 1970037111) {
            str2 = "audio/g711-mlaw";
        } else if (i13 == 1332770163) {
            str2 = "audio/opus";
        } else if (i13 == 1716281667) {
            str2 = "audio/flac";
        } else {
            str2 = i13 == 1835823201 ? "audio/true-hd" : null;
        }
        String str4 = null;
        zzaha zzahaVarZzm = null;
        List listZzm = null;
        while (iZzc - i9 < i10) {
            zzfbVar2.zzG(iZzc);
            int iZzf2 = zzfbVar.zzf();
            String str5 = "childAtomSize must be positive";
            zzabq.zzb(iZzf2 > 0, "childAtomSize must be positive");
            int iZzf3 = zzfbVar.zzf();
            int i14 = i6;
            if (iZzf3 == 1835557187) {
                int i15 = iZzf2 - 13;
                byte[] bArr = new byte[i15];
                zzfbVar2.zzG(iZzc + 13);
                zzfbVar2.zzC(bArr, 0, i15);
                listZzm = zzfvs.zzm(bArr);
            } else {
                if (iZzf3 != 1702061171) {
                    if (z && iZzf3 == 2002876005) {
                        int iZzc2 = zzfbVar.zzc();
                        if (iZzc2 >= iZzc) {
                            str3 = null;
                            z2 = true;
                        } else {
                            str3 = null;
                            z2 = false;
                        }
                        zzabq.zzb(z2, str3);
                        i7 = iZzc2;
                        while (true) {
                            if (i7 - iZzc >= iZzf2) {
                                str4 = str4;
                                i7 = -1;
                                break;
                            }
                            zzfbVar2.zzG(i7);
                            int iZzf4 = zzfbVar.zzf();
                            zzabq.zzb(iZzf4 > 0, str5);
                            String str6 = str5;
                            if (zzfbVar.zzf() == 1702061171) {
                                break;
                            }
                            i7 += iZzf4;
                            str4 = str4;
                            str5 = str6;
                        }
                        i8 = -1;
                    } else {
                        str4 = str4;
                        if (iZzf3 == 1684103987) {
                            zzfbVar2.zzG(iZzc + 8);
                            zzahcVar.zzb = zzaan.zzc(zzfbVar2, Integer.toString(i4), str, zzadVarZzb);
                        } else if (iZzf3 == 1684366131) {
                            zzfbVar2.zzG(iZzc + 8);
                            zzahcVar.zzb = zzaan.zzd(zzfbVar2, Integer.toString(i4), str, zzadVarZzb);
                        } else if (iZzf3 == 1684103988) {
                            zzfbVar2.zzG(iZzc + 8);
                            String string = Integer.toString(i4);
                            int i16 = zzaaq.zza;
                            zzfbVar2.zzH(1);
                            int iZzl = zzfbVar.zzl() & 32;
                            zzak zzakVar = new zzak();
                            zzakVar.zzJ(string);
                            zzakVar.zzU("audio/ac4");
                            zzakVar.zzy(2);
                            zzakVar.zzV(1 != (iZzl >> 5) ? 44100 : 48000);
                            zzakVar.zzD(zzadVarZzb);
                            zzakVar.zzM(str);
                            zzahcVar.zzb = zzakVar.zzac();
                        } else if (iZzf3 != 1684892784) {
                            if (iZzf3 == 1684305011 || iZzf3 == 1969517683) {
                                zzak zzakVar2 = new zzak();
                                zzakVar2.zzI(i4);
                                zzakVar2.zzU(str2);
                                zzakVar2.zzy(iZzp2);
                                zzakVar2.zzV(iZzm);
                                zzakVar2.zzD(zzadVarZzb);
                                zzakVar2.zzM(str);
                                zzahcVar.zzb = zzakVar2.zzac();
                            } else if (iZzf3 == 1682927731) {
                                int i17 = iZzf2 - 8;
                                byte[] bArr2 = zza;
                                byte[] bArrCopyOf = Arrays.copyOf(bArr2, bArr2.length + i17);
                                zzfbVar2.zzG(iZzc + 8);
                                zzfbVar2.zzC(bArrCopyOf, bArr2.length, i17);
                                listZzm = zzaci.zze(bArrCopyOf);
                                str4 = str4;
                            } else {
                                if (iZzf3 == 1684425825) {
                                    int i18 = iZzf2 - 12;
                                    byte[] bArr3 = new byte[i18 + 4];
                                    bArr3[0] = 102;
                                    bArr3[1] = 76;
                                    bArr3[2] = 97;
                                    bArr3[3] = 67;
                                    zzfbVar2.zzG(iZzc + 12);
                                    zzfbVar2.zzC(bArr3, 4, i18);
                                    listZzm = zzfvs.zzm(bArr3);
                                } else if (iZzf3 == 1634492771) {
                                    int i19 = iZzf2 - 12;
                                    byte[] bArr4 = new byte[i19];
                                    zzfbVar2.zzG(iZzc + 12);
                                    zzfbVar2.zzC(bArr4, 0, i19);
                                    int i20 = zzdz.zza;
                                    zzfb zzfbVar3 = new zzfb(bArr4);
                                    zzfbVar3.zzG(9);
                                    int iZzl2 = zzfbVar3.zzl();
                                    zzfbVar3.zzG(20);
                                    Pair pairCreate = Pair.create(Integer.valueOf(zzfbVar3.zzo()), Integer.valueOf(iZzl2));
                                    iZzm = ((Integer) pairCreate.first).intValue();
                                    int iIntValue2 = ((Integer) pairCreate.second).intValue();
                                    listZzm = zzfvs.zzm(bArr4);
                                    iZzp2 = iIntValue2;
                                }
                                iZzf = iZzf;
                                str4 = str4;
                            }
                            iZzf = iZzf;
                            str4 = str4;
                        } else {
                            if (iZzf <= 0) {
                                throw zzcc.zza("Invalid sample rate for Dolby TrueHD MLP stream: " + iZzf, null);
                            }
                            iZzm = iZzf;
                            iZzf = iZzm;
                            str4 = str4;
                            iZzp2 = 2;
                        }
                        iZzf = iZzf;
                        str4 = str4;
                    }
                    iZzc += iZzf2;
                    zzfbVar2 = zzfbVar;
                    i9 = i2;
                    i10 = i3;
                    i6 = i14;
                    iZzf = iZzf;
                } else {
                    str4 = str4;
                    i7 = iZzc;
                    i8 = -1;
                }
                if (i7 != i8) {
                    zzahaVarZzm = zzm(zzfbVar2, i7);
                    String str7 = zzahaVarZzm.zza;
                    byte[] bArr5 = zzahaVarZzm.zzb;
                    if (bArr5 != null) {
                        if ("audio/vorbis".equals(str7)) {
                            zzfb zzfbVar4 = new zzfb(bArr5);
                            zzfbVar4.zzH(1);
                            int i21 = 0;
                            while (zzfbVar4.zza() > 0 && zzfbVar4.zze() == 255) {
                                zzfbVar4.zzH(1);
                                i21 += 255;
                            }
                            int iZzl3 = i21 + zzfbVar4.zzl();
                            int i22 = 0;
                            while (true) {
                                iZzf = iZzf;
                                if (zzfbVar4.zza() <= 0 || zzfbVar4.zze() != 255) {
                                    break;
                                }
                                zzfbVar4.zzH(1);
                                i22 += 255;
                                iZzf = iZzf;
                            }
                            int iZzl4 = i22 + zzfbVar4.zzl();
                            byte[] bArr6 = new byte[iZzl3];
                            int iZzc3 = zzfbVar4.zzc();
                            System.arraycopy(bArr5, iZzc3, bArr6, 0, iZzl3);
                            int i23 = iZzc3 + iZzl3 + iZzl4;
                            int length = bArr5.length - i23;
                            byte[] bArr7 = new byte[length];
                            System.arraycopy(bArr5, i23, bArr7, 0, length);
                            listZzm = zzfvs.zzn(bArr6, bArr7);
                        } else {
                            iZzf = iZzf;
                            if ("audio/mp4a-latm".equals(str7)) {
                                zzaaj zzaajVarZza = zzaak.zza(bArr5);
                                iZzm = zzaajVarZza.zza;
                                iZzp2 = zzaajVarZza.zzb;
                                str4 = zzaajVarZza.zzc;
                            } else {
                                str4 = str4;
                            }
                            listZzm = zzfvs.zzm(bArr5);
                            str2 = str7;
                        }
                        iZzc += iZzf2;
                        zzfbVar2 = zzfbVar;
                        i9 = i2;
                        i10 = i3;
                        i6 = i14;
                        iZzf = iZzf;
                    } else {
                        iZzf = iZzf;
                    }
                    str2 = str7;
                } else {
                    iZzf = iZzf;
                }
                str4 = str4;
                iZzc += iZzf2;
                zzfbVar2 = zzfbVar;
                i9 = i2;
                i10 = i3;
                i6 = i14;
                iZzf = iZzf;
            }
            iZzc += iZzf2;
            zzfbVar2 = zzfbVar;
            i9 = i2;
            i10 = i3;
            i6 = i14;
            iZzf = iZzf;
        }
        int i24 = i6;
        String str8 = str4;
        if (zzahcVar.zzb != null || str2 == null) {
            return;
        }
        zzak zzakVar3 = new zzak();
        zzakVar3.zzI(i4);
        zzakVar3.zzU(str2);
        zzakVar3.zzz(str8);
        zzakVar3.zzy(iZzp2);
        zzakVar3.zzV(iZzm);
        zzakVar3.zzP(i24);
        zzakVar3.zzK(listZzm);
        zzakVar3.zzD(zzadVarZzb);
        zzakVar3.zzM(str);
        if (zzahaVarZzm != null) {
            zzakVar3.zzx(zzfya.zzc(zzahaVarZzm.zzc));
            zzakVar3.zzQ(zzfya.zzc(zzahaVarZzm.zzd));
        }
        zzahcVar.zzb = zzakVar3.zzac();
    }

    private static boolean zzp(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length;
        int i = length - 1;
        return jArr[0] <= j2 && j2 < jArr[Math.max(0, Math.min(4, i))] && jArr[Math.max(0, Math.min(length + (-4), i))] < j3 && j3 <= j;
    }
}
