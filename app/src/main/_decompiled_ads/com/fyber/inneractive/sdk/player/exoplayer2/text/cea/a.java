package com.fyber.inneractive.sdk.player.exoplayer2.text.cea;

import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    /* JADX WARN: Code duplicated, block: B:34:0x0068  */
    public static void a(long j, k kVar, n[] nVarArr) {
        int i;
        boolean z;
        int iL;
        while (kVar.a() > 1) {
            int i2 = 0;
            while (true) {
                if (kVar.a() == 0) {
                    i = -1;
                    break;
                }
                int iL2 = kVar.l();
                i2 += iL2;
                if (iL2 != 255) {
                    i = i2;
                    break;
                }
            }
            int i3 = 0;
            do {
                if (kVar.a() == 0) {
                    i3 = -1;
                    break;
                } else {
                    iL = kVar.l();
                    i3 += iL;
                }
            } while (iL == 255);
            if (i3 == -1 || i3 > kVar.a()) {
                Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                kVar.e(kVar.c);
            } else {
                if (i != 4 || i3 < 8) {
                    z = false;
                } else {
                    int i4 = kVar.f1236b;
                    int iL3 = kVar.l();
                    int iQ = kVar.q();
                    int iC = kVar.c();
                    int iL4 = kVar.l();
                    kVar.e(i4);
                    if (iL3 == 181 && iQ == 49 && iC == 1195456820 && iL4 == 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    kVar.f(8);
                    int iL5 = kVar.l() & 31;
                    kVar.f(1);
                    int i5 = iL5 * 3;
                    int i6 = kVar.f1236b;
                    for (n nVar : nVarArr) {
                        kVar.e(i6);
                        nVar.a(kVar, i5);
                        nVar.a(j, 1, i5, 0, null);
                    }
                    kVar.f(i3 - (i5 + 10));
                } else {
                    kVar.f(i3);
                }
            }
        }
    }
}
