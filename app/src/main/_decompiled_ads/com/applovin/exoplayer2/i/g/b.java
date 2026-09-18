package com.applovin.exoplayer2.i.g;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.a.aq;
import com.applovin.exoplayer2.common.a.w;
import com.applovin.exoplayer2.common.a.x;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.Set;
import java.util.regex.Pattern;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: loaded from: classes.dex */
final class b {
    private static final Pattern Sd = Pattern.compile("\\s+");
    private static final w<String> Se = w.m(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, IntegrityManager.INTEGRITY_TYPE_NONE);
    private static final w<String> Sf = w.a("dot", "sesame", "circle");
    private static final w<String> Sg = w.m("filled", "open");
    private static final w<String> Sh = w.a("after", "before", "outside");
    public final int Rq;
    public final int Rr;
    public final int oX;

    private b(int i, int i2, int i3) {
        this.Rq = i;
        this.Rr = i2;
        this.oX = i3;
    }

    public static b an(String str) {
        if (str == null) {
            return null;
        }
        String lowerCase = Ascii.toLowerCase(str.trim());
        if (lowerCase.isEmpty()) {
            return null;
        }
        return a(w.e(TextUtils.split(lowerCase, Sd)));
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0042  */
    /* JADX WARN: Code duplicated, block: B:37:0x0084  */
    /* JADX WARN: Code duplicated, block: B:60:0x00d6  */
    private static b a(w<String> wVar) {
        byte b2;
        int i;
        byte b3;
        String str = (String) x.a(aq.a((Set) Sh, (Set<?>) wVar), "outside");
        int iHashCode = str.hashCode();
        int i2 = 2;
        int i3 = -1;
        byte b4 = 1;
        if (iHashCode != -1392885889) {
            if (iHashCode != -1106037339) {
                if (iHashCode == 92734940 && str.equals("after")) {
                    b2 = 0;
                } else {
                    b2 = -1;
                }
            } else if (str.equals("outside")) {
                b2 = 1;
            } else {
                b2 = -1;
            }
        } else if (str.equals("before")) {
            b2 = 2;
        } else {
            b2 = -1;
        }
        if (b2 != 0) {
            i = b2 != 1 ? 1 : -2;
        } else {
            i = 2;
        }
        aq.b bVarA = aq.a((Set) Se, (Set<?>) wVar);
        if (!bVarA.isEmpty()) {
            String str2 = (String) bVarA.iterator().next();
            int iHashCode2 = str2.hashCode();
            if (iHashCode2 != 3005871) {
                if (iHashCode2 == 3387192 && str2.equals(IntegrityManager.INTEGRITY_TYPE_NONE)) {
                    b4 = 0;
                } else {
                    b4 = -1;
                }
            } else if (!str2.equals(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                b4 = -1;
            }
            return new b(b4 == 0 ? 0 : -1, 0, i);
        }
        aq.b bVarA2 = aq.a((Set) Sg, (Set<?>) wVar);
        aq.b bVarA3 = aq.a((Set) Sf, (Set<?>) wVar);
        if (bVarA2.isEmpty() && bVarA3.isEmpty()) {
            return new b(-1, 0, i);
        }
        String str3 = (String) x.a(bVarA2, "filled");
        int iHashCode3 = str3.hashCode();
        if (iHashCode3 != -1274499742) {
            if (iHashCode3 == 3417674 && str3.equals("open")) {
                b3 = 0;
            } else {
                b3 = -1;
            }
        } else if (str3.equals("filled")) {
            b3 = 1;
        } else {
            b3 = -1;
        }
        int i4 = b3 != 0 ? 1 : 2;
        String str4 = (String) x.a(bVarA3, "circle");
        int iHashCode4 = str4.hashCode();
        if (iHashCode4 != -1360216880) {
            if (iHashCode4 != -905816648) {
                if (iHashCode4 == 99657 && str4.equals("dot")) {
                    i3 = 0;
                }
            } else if (str4.equals("sesame")) {
                i3 = 1;
            }
        } else if (str4.equals("circle")) {
            i3 = 2;
        }
        if (i3 != 0) {
            i2 = i3 != 1 ? 1 : 3;
        }
        return new b(i2, i4, i);
    }
}
