package com.applovin.exoplayer2.k;

import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.common.base.Predicate;
import com.facebook.ads.AdError;
import com.tapjoy.TJAdUnitConstants;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface t extends i {
    public static final Predicate<String> aaJ = new Predicate() { // from class: com.applovin.exoplayer2.k.-$$Lambda$t$0uTOmNMQcqvJgVIQjkyPx31mRAE
        @Override // com.applovin.exoplayer2.common.base.Predicate
        public final boolean apply(Object obj) {
            return t.aP((String) obj);
        }
    };

    public interface b extends i.a {
        @Override // com.applovin.exoplayer2.k.i.a
        /* JADX INFO: renamed from: ox, reason: merged with bridge method [inline-methods] */
        t of();
    }

    public static final class f {
        private final Map<String, String> aaO = new HashMap();
        private Map<String, String> aaP;

        public synchronized Map<String, String> oy() {
            if (this.aaP == null) {
                this.aaP = Collections.unmodifiableMap(new HashMap(this.aaO));
            }
            return this.aaP;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean aP(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = Ascii.toLowerCase(str);
        if (TextUtils.isEmpty(lowerCase)) {
            return false;
        }
        return ((lowerCase.contains("text") && !lowerCase.contains("text/vtt")) || lowerCase.contains(TJAdUnitConstants.String.HTML) || lowerCase.contains("xml")) ? false : true;
    }

    public static class c extends j {
        public final int bs;
        public final l tw;

        private static int J(int i, int i2) {
            return (i == 2000 && i2 == 1) ? AdError.INTERNAL_ERROR_CODE : i;
        }

        public static c a(IOException iOException, l lVar, int i) {
            int i2;
            String message = iOException.getMessage();
            if (iOException instanceof SocketTimeoutException) {
                i2 = AdError.CACHE_ERROR_CODE;
            } else if (iOException instanceof InterruptedIOException) {
                i2 = PointerIconCompat.TYPE_WAIT;
            } else {
                i2 = (message == null || !Ascii.toLowerCase(message).matches("cleartext.*not permitted.*")) ? AdError.INTERNAL_ERROR_CODE : 2007;
            }
            if (i2 == 2007) {
                return new a(iOException, lVar);
            }
            return new c(iOException, lVar, i2, i);
        }

        public c(l lVar, int i, int i2) {
            super(J(i, i2));
            this.tw = lVar;
            this.bs = i2;
        }

        public c(String str, l lVar, int i, int i2) {
            super(str, J(i, i2));
            this.tw = lVar;
            this.bs = i2;
        }

        public c(IOException iOException, l lVar, int i, int i2) {
            super(iOException, J(i, i2));
            this.tw = lVar;
            this.bs = i2;
        }

        public c(String str, IOException iOException, l lVar, int i, int i2) {
            super(str, iOException, J(i, i2));
            this.tw = lVar;
            this.bs = i2;
        }
    }

    public static final class a extends c {
        public a(IOException iOException, l lVar) {
            super("Cleartext HTTP traffic not permitted. See https://exoplayer.dev/issues/cleartext-not-permitted", iOException, lVar, 2007, 1);
        }
    }

    public static final class d extends c {
        public final String aaK;

        public d(String str, l lVar) {
            super("Invalid content type: " + str, lVar, AdError.INTERNAL_ERROR_2003, 1);
            this.aaK = str;
        }
    }

    public static final class e extends c {
        public final int aaC;
        public final String aaL;
        public final Map<String, List<String>> aaM;
        public final byte[] aaN;

        public e(int i, String str, IOException iOException, Map<String, List<String>> map, l lVar, byte[] bArr) {
            super("Response code: " + i, iOException, lVar, AdError.INTERNAL_ERROR_2004, 1);
            this.aaC = i;
            this.aaL = str;
            this.aaM = map;
            this.aaN = bArr;
        }
    }
}
