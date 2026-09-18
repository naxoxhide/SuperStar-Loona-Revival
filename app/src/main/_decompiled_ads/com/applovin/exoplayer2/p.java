package com.applovin.exoplayer2;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class p extends ak {
    public static final g.a<p> br = new g.a() { // from class: com.applovin.exoplayer2.-$$Lambda$p$eNlJ4lrbvCLcY1ApNbk1B6ELKYw
        @Override // com.applovin.exoplayer2.g.a
        public final g fromBundle(Bundle bundle) {
            return p.lambda$eNlJ4lrbvCLcY1ApNbk1B6ELKYw(bundle);
        }
    };
    public final int bs;
    public final String bt;
    public final int bu;
    public final v bv;
    public final int bw;
    public final com.applovin.exoplayer2.h.o bx;
    final boolean by;

    public static /* synthetic */ p lambda$eNlJ4lrbvCLcY1ApNbk1B6ELKYw(Bundle bundle) {
        return new p(bundle);
    }

    public static p a(IOException iOException, int i) {
        return new p(0, iOException, i);
    }

    public static p a(Throwable th, String str, int i, v vVar, int i2, boolean z, int i3) {
        return new p(1, th, null, i3, str, i, vVar, vVar == null ? 4 : i2, z);
    }

    @Deprecated
    public static p a(RuntimeException runtimeException) {
        return a(runtimeException, 1000);
    }

    public static p a(RuntimeException runtimeException, int i) {
        return new p(2, runtimeException, i);
    }

    private p(int i, Throwable th, int i2) {
        this(i, th, null, i2, null, -1, null, 4, false);
    }

    private p(int i, Throwable th, String str, int i2, String str2, int i3, v vVar, int i4, boolean z) {
        this(a(i, str, str2, i3, vVar, i4), th, i2, i, str2, i3, vVar, i4, null, SystemClock.elapsedRealtime(), z);
    }

    private p(Bundle bundle) {
        super(bundle);
        this.bs = bundle.getInt(t(1001), 2);
        this.bt = bundle.getString(t(1002));
        this.bu = bundle.getInt(t(PointerIconCompat.TYPE_HELP), -1);
        this.bv = (v) com.applovin.exoplayer2.l.c.a(v.br, bundle.getBundle(t(PointerIconCompat.TYPE_WAIT)));
        this.bw = bundle.getInt(t(1005), 4);
        this.by = bundle.getBoolean(t(PointerIconCompat.TYPE_CELL), false);
        this.bx = null;
    }

    private p(String str, Throwable th, int i, int i2, String str2, int i3, v vVar, int i4, com.applovin.exoplayer2.h.o oVar, long j, boolean z) {
        super(str, th, i, j);
        com.applovin.exoplayer2.l.a.checkArgument(!z || i2 == 1);
        com.applovin.exoplayer2.l.a.checkArgument(th != null || i2 == 3);
        this.bs = i2;
        this.bt = str2;
        this.bu = i3;
        this.bv = vVar;
        this.bw = i4;
        this.bx = oVar;
        this.by = z;
    }

    p a(com.applovin.exoplayer2.h.o oVar) {
        return new p((String) com.applovin.exoplayer2.l.ai.R(getMessage()), getCause(), this.errorCode, this.bs, this.bt, this.bu, this.bv, this.bw, oVar, this.gp, this.by);
    }

    private static String a(int i, String str, String str2, int i2, v vVar, int i3) {
        String str3;
        if (i == 0) {
            str3 = "Source error";
        } else if (i != 1) {
            str3 = i != 3 ? "Unexpected runtime error" : "Remote error";
        } else {
            str3 = str2 + " error, index=" + i2 + ", format=" + vVar + ", format_supported=" + h.q(i3);
        }
        return !TextUtils.isEmpty(str) ? str3 + ": " + str : str3;
    }
}
