package com.applovin.exoplayer2.d;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import com.applovin.exoplayer2.l.ai;
import com.facebook.ads.AdError;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    public static int b(Exception exc, int i) {
        if (ai.acV >= 21 && b.d(exc)) {
            return b.e(exc);
        }
        if (ai.acV >= 23 && c.f(exc)) {
            return 6006;
        }
        if (ai.acV >= 18 && a.b(exc)) {
            return AdError.ICONVIEW_MISSING_ERROR_CODE;
        }
        if (ai.acV >= 18 && a.c(exc)) {
            return 6007;
        }
        if (exc instanceof t) {
            return 6001;
        }
        if (exc instanceof com.applovin.exoplayer2.d.c.d) {
            return AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE;
        }
        if (exc instanceof q) {
            return 6008;
        }
        if (i == 1) {
            return 6006;
        }
        if (i == 2) {
            return 6004;
        }
        if (i == 3) {
            return AdError.ICONVIEW_MISSING_ERROR_CODE;
        }
        throw new IllegalArgumentException();
    }

    private static final class a {
        public static boolean b(Throwable th) {
            return th instanceof NotProvisionedException;
        }

        public static boolean c(Throwable th) {
            return th instanceof DeniedByServerException;
        }
    }

    private static final class b {
        public static boolean d(Throwable th) {
            return th instanceof MediaDrm.MediaDrmStateException;
        }

        public static int e(Throwable th) {
            return com.applovin.exoplayer2.h.r(ai.bl(((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo()));
        }
    }

    private static final class c {
        public static boolean f(Throwable th) {
            return th instanceof MediaDrmResetException;
        }
    }
}
