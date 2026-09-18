package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements a0<Object> {
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.p a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1216b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;

    public l(Handler handler, d dVar) {
        this(null, null, 2000);
    }

    public synchronized void a(Object obj, j jVar) {
        if (this.f1216b == 0) {
            this.c = SystemClock.elapsedRealtime();
        }
        this.f1216b++;
    }

    public l(Handler handler, d dVar, int i) {
        this.a = new com.fyber.inneractive.sdk.player.exoplayer2.util.p(i);
        this.g = -1L;
    }

    public synchronized void a(Object obj) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.p.c cVar;
        float f;
        int i = 0;
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.f1216b > 0);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int i2 = (int) (jElapsedRealtime - this.c);
        long j = i2;
        this.e += j;
        long j2 = this.f;
        long j3 = this.d;
        this.f = j2 + j3;
        if (i2 > 0) {
            float f2 = (8000 * j3) / j;
            com.fyber.inneractive.sdk.player.exoplayer2.util.p pVar = this.a;
            int iSqrt = (int) Math.sqrt(j3);
            if (pVar.d != 1) {
                Collections.sort(pVar.f1238b, com.fyber.inneractive.sdk.player.exoplayer2.util.p.h);
                pVar.d = 1;
            }
            int i3 = pVar.g;
            if (i3 > 0) {
                com.fyber.inneractive.sdk.player.exoplayer2.util.p.c[] cVarArr = pVar.c;
                int i4 = i3 - 1;
                pVar.g = i4;
                cVar = cVarArr[i4];
            } else {
                cVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.p.c();
            }
            int i5 = pVar.e;
            pVar.e = i5 + 1;
            cVar.a = i5;
            cVar.f1239b = iSqrt;
            cVar.c = f2;
            pVar.f1238b.add(cVar);
            pVar.f += iSqrt;
            while (true) {
                int i6 = pVar.f;
                int i7 = pVar.a;
                if (i6 <= i7) {
                    break;
                }
                int i8 = i6 - i7;
                com.fyber.inneractive.sdk.player.exoplayer2.util.p.c cVar2 = pVar.f1238b.get(0);
                int i9 = cVar2.f1239b;
                if (i9 <= i8) {
                    pVar.f -= i9;
                    pVar.f1238b.remove(0);
                    int i10 = pVar.g;
                    if (i10 < 5) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.p.c[] cVarArr2 = pVar.c;
                        pVar.g = i10 + 1;
                        cVarArr2[i10] = cVar2;
                    }
                } else {
                    cVar2.f1239b = i9 - i8;
                    pVar.f -= i8;
                }
            }
            if (this.e >= 2000 || this.f >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                com.fyber.inneractive.sdk.player.exoplayer2.util.p pVar2 = this.a;
                if (pVar2.d != 0) {
                    Collections.sort(pVar2.f1238b, com.fyber.inneractive.sdk.player.exoplayer2.util.p.i);
                    pVar2.d = 0;
                }
                float f3 = 0.5f * pVar2.f;
                int i11 = 0;
                while (true) {
                    if (i < pVar2.f1238b.size()) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.p.c cVar3 = pVar2.f1238b.get(i);
                        i11 += cVar3.f1239b;
                        if (i11 >= f3) {
                            f = cVar3.c;
                            break;
                        }
                        i++;
                    } else if (!pVar2.f1238b.isEmpty()) {
                        ArrayList<com.fyber.inneractive.sdk.player.exoplayer2.util.p.c> arrayList = pVar2.f1238b;
                        f = arrayList.get(arrayList.size() - 1).c;
                        break;
                    } else {
                        f = Float.NaN;
                        break;
                    }
                }
                this.g = Float.isNaN(f) ? -1L : (long) f;
            }
        }
        int i12 = this.f1216b - 1;
        this.f1216b = i12;
        if (i12 > 0) {
            this.c = jElapsedRealtime;
        }
        this.d = 0L;
    }
}
