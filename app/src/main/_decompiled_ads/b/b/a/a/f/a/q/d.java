package b.b.a.a.f.a.q;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: compiled from: SegmentPool.java */
/* JADX INFO: loaded from: classes.dex */
final class d {
    static c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static long f162b;

    private d() {
    }

    static c a() {
        synchronized (d.class) {
            c cVar = a;
            if (cVar == null) {
                return new c();
            }
            a = cVar.f;
            cVar.f = null;
            f162b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return cVar;
        }
    }

    static void a(c cVar) {
        if (cVar.f == null && cVar.g == null) {
            if (cVar.d) {
                return;
            }
            synchronized (d.class) {
                long j = f162b + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                if (j > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    return;
                }
                f162b = j;
                cVar.f = a;
                cVar.c = 0;
                cVar.f161b = 0;
                a = cVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
