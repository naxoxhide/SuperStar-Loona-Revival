package com.applovin.exoplayer2.ui;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import com.applovin.exoplayer2.common.base.Predicate;

/* JADX INFO: loaded from: classes.dex */
final class j {
    public static float a(int i, float f, int i2, int i3) {
        float f2;
        if (f == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i == 0) {
            f2 = i3;
        } else {
            if (i != 1) {
                if (i != 2) {
                    return -3.4028235E38f;
                }
                return f;
            }
            f2 = i2;
        }
        return f * f2;
    }

    public static void a(com.applovin.exoplayer2.i.a.C0098a c0098a) {
        c0098a.lT();
        if (c0098a.lQ() instanceof Spanned) {
            if (!(c0098a.lQ() instanceof Spannable)) {
                c0098a.m(SpannableString.valueOf(c0098a.lQ()));
            }
            a((Spannable) com.applovin.exoplayer2.l.a.checkNotNull(c0098a.lQ()), new Predicate() { // from class: com.applovin.exoplayer2.ui.-$$Lambda$j$scT1FlGQLGTrJ3uRmrbmCQvn5G0
                @Override // com.applovin.exoplayer2.common.base.Predicate
                public final boolean apply(Object obj) {
                    return j.M(obj);
                }
            });
        }
        b(c0098a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean M(Object obj) {
        return !(obj instanceof com.applovin.exoplayer2.i.d.b);
    }

    public static void b(com.applovin.exoplayer2.i.a.C0098a c0098a) {
        c0098a.c(-3.4028235E38f, Integer.MIN_VALUE);
        if (c0098a.lQ() instanceof Spanned) {
            if (!(c0098a.lQ() instanceof Spannable)) {
                c0098a.m(SpannableString.valueOf(c0098a.lQ()));
            }
            a((Spannable) com.applovin.exoplayer2.l.a.checkNotNull(c0098a.lQ()), new Predicate() { // from class: com.applovin.exoplayer2.ui.-$$Lambda$j$Y4E3QXWcMhjGGhch4j7CGEZkySA
                @Override // com.applovin.exoplayer2.common.base.Predicate
                public final boolean apply(Object obj) {
                    return j.L(obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean L(Object obj) {
        return (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan);
    }

    private static void a(Spannable spannable, Predicate<Object> predicate) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (predicate.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }
}
