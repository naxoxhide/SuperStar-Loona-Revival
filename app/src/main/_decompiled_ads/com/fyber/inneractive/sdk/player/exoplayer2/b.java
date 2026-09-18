package com.fyber.inneractive.sdk.player.exoplayer2;

import androidx.core.view.PointerIconCompat;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final UUID f1048b;

    static {
        a = u.a < 23 ? PointerIconCompat.TYPE_GRAB : 6396;
        f1048b = new UUID(0L, 0L);
        new UUID(1186680826959645954L, -5988876978535335093L);
        new UUID(-1301668207276963122L, -6645017420763422227L);
        new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long a(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return 1000 * j;
    }

    public static long b(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j / 1000;
    }
}
