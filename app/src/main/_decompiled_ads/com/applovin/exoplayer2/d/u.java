package com.applovin.exoplayer2.d;

import android.util.Pair;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class u {
    public static Pair<Long, Long> b(f fVar) {
        Map<String, String> mapHw = fVar.hw();
        if (mapHw == null) {
            return null;
        }
        return new Pair<>(Long.valueOf(a(mapHw, "LicenseDurationRemaining")), Long.valueOf(a(mapHw, "PlaybackDurationRemaining")));
    }

    private static long a(Map<String, String> map, String str) {
        if (map == null) {
            return -9223372036854775807L;
        }
        try {
            String str2 = map.get(str);
            if (str2 != null) {
                return Long.parseLong(str2);
            }
            return -9223372036854775807L;
        } catch (NumberFormatException unused) {
            return -9223372036854775807L;
        }
    }
}
