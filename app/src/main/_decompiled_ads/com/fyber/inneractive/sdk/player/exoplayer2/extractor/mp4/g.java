package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.support.v4.media.session.PlaybackStateCompat;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final int[] a = {u.a("isom"), u.a("iso2"), u.a("iso3"), u.a("iso4"), u.a("iso5"), u.a("iso6"), u.a("avc1"), u.a("hvc1"), u.a("hev1"), u.a("mp41"), u.a("mp42"), u.a("3g2a"), u.a("3g2b"), u.a("3gr6"), u.a("3gs6"), u.a("3ge6"), u.a("3gg6"), u.a("M4V "), u.a("M4A "), u.a("f4v "), u.a("kddi"), u.a("M4VP"), u.a("qt  "), u.a("MSNV")};

    public static boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar, boolean z) throws InterruptedException, IOException {
        boolean z2;
        boolean z3;
        boolean z4;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
        long j = bVar.f1057b;
        if (j == -1 || j > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j = 4096;
        }
        int i = (int) j;
        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(64);
        int i2 = 0;
        boolean z5 = false;
        while (true) {
            if (i2 < i) {
                kVar.c(8);
                bVar.a(kVar.a, 0, 8, false);
                long jM = kVar.m();
                int iC = kVar.c();
                int i3 = 16;
                if (jM == 1) {
                    bVar.a(kVar.a, 8, 8, false);
                    kVar.d(16);
                    jM = kVar.p();
                } else {
                    i3 = 8;
                }
                long j2 = i3;
                if (jM < j2) {
                    return false;
                }
                i2 += i3;
                if (iC != a.C) {
                    if (iC == a.L || iC == a.N) {
                        z2 = true;
                        z3 = true;
                        if (!z5 && z == z3) {
                            return z2;
                        }
                    }
                    if ((((long) i2) + jM) - j2 < i) {
                        int i4 = (int) (jM - j2);
                        i2 += i4;
                        if (iC == a.f1093b) {
                            if (i4 < 8) {
                                return false;
                            }
                            kVar.c(i4);
                            bVar.a(kVar.a, 0, i4, false);
                            int i5 = i4 / 4;
                            for (int i6 = 0; i6 < i5; i6++) {
                                if (i6 != 1) {
                                    int iC2 = kVar.c();
                                    if ((iC2 >>> 8) == u.a("3gp")) {
                                        z4 = true;
                                        break;
                                    }
                                    int[] iArr = a;
                                    int length = iArr.length;
                                    int i7 = 0;
                                    while (true) {
                                        if (i7 >= length) {
                                            z4 = false;
                                            break;
                                        }
                                        if (iArr[i7] == iC2) {
                                            z4 = true;
                                            break;
                                        }
                                        i7++;
                                    }
                                    if (z4) {
                                        z5 = true;
                                        break;
                                    }
                                } else {
                                    kVar.f(4);
                                }
                            }
                            if (!z5) {
                                return false;
                            }
                        } else if (i4 != 0) {
                            bVar.a(i4, false);
                        }
                    }
                }
            }
            z2 = true;
            z3 = false;
            return !z5 ? false : false;
        }
    }
}
