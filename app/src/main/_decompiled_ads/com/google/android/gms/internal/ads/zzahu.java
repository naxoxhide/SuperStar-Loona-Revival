package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzahu {
    private static final int[] zza = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean zza(zzabn zzabnVar) throws IOException {
        return zzc(zzabnVar, true, false);
    }

    public static boolean zzb(zzabn zzabnVar, boolean z) throws IOException {
        return zzc(zzabnVar, false, false);
    }

    private static boolean zzc(zzabn zzabnVar, boolean z, boolean z2) throws IOException {
        boolean z3;
        long jZzd = zzabnVar.zzd();
        long j = -1;
        long j2 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        if (jZzd != -1 && jZzd <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j2 = jZzd;
        }
        zzfb zzfbVar = new zzfb(64);
        int i = (int) j2;
        boolean z4 = false;
        int i2 = 0;
        boolean z5 = false;
        while (true) {
            if (i2 < i) {
                zzfbVar.zzD(8);
                if (!zzabnVar.zzm(zzfbVar.zzI(), z4 ? 1 : 0, 8, true)) {
                    z3 = z4 ? 1 : 0;
                    break;
                }
                long jZzt = zzfbVar.zzt();
                int iZzf = zzfbVar.zzf();
                int i3 = 16;
                if (jZzt == 1) {
                    zzabnVar.zzh(zzfbVar.zzI(), 8, 8);
                    zzfbVar.zzF(16);
                    jZzt = zzfbVar.zzs();
                } else {
                    if (jZzt == 0) {
                        long jZzd2 = zzabnVar.zzd();
                        if (jZzd2 != j) {
                            jZzt = (jZzd2 - zzabnVar.zze()) + 8;
                        }
                    }
                    i3 = 8;
                }
                long j3 = i3;
                if (jZzt < j3) {
                    return z4;
                }
                i2 += i3;
                if (iZzf == 1836019574) {
                    i += (int) jZzt;
                    if (jZzd != -1 && i > jZzd) {
                        i = (int) jZzd;
                    }
                    j = -1;
                } else {
                    if (iZzf == 1836019558 || iZzf == 1836475768) {
                        z3 = true;
                        break;
                    }
                    zzfb zzfbVar2 = zzfbVar;
                    long j4 = jZzt;
                    if ((((long) i2) + jZzt) - j3 < i) {
                        int i4 = (int) (j4 - j3);
                        i2 += i4;
                        if (iZzf == 1718909296) {
                            if (i4 < 8) {
                                return false;
                            }
                            zzfbVar2.zzD(i4);
                            zzabnVar.zzh(zzfbVar2.zzI(), 0, i4);
                            int i5 = i4 >> 2;
                            for (int i6 = 0; i6 < i5; i6++) {
                                if (i6 != 1) {
                                    int iZzf2 = zzfbVar2.zzf();
                                    if ((iZzf2 >>> 8) != 3368816) {
                                        if (iZzf2 == 1751476579) {
                                            iZzf2 = 1751476579;
                                        }
                                        int[] iArr = zza;
                                        int i7 = 0;
                                        while (true) {
                                            if (i7 >= 29) {
                                                continue;
                                            } else if (iArr[i7] != iZzf2) {
                                                i7++;
                                            }
                                        }
                                    }
                                    z5 = true;
                                    break;
                                }
                                zzfbVar2.zzH(4);
                            }
                            if (!z5) {
                                return false;
                            }
                        } else if (i4 != 0) {
                            zzabnVar.zzg(i4);
                        }
                        zzfbVar = zzfbVar2;
                        j = -1;
                        z4 = false;
                    }
                }
            }
            z3 = false;
            break;
        }
        return z5 && z == z3;
    }
}
