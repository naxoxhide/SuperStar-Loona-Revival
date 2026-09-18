package com.tapjoy.internal;

import android.graphics.Color;
import com.tapjoy.TJTaskHandler;
import com.tapjoy.TapjoyLog;

/* JADX INFO: loaded from: classes4.dex */
public final class z7 implements Runnable {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJTaskHandler f2841b;
    public final /* synthetic */ com.tapjoy.c c;

    public z7(com.tapjoy.c cVar, String str, TJTaskHandler tJTaskHandler) {
        this.c = cVar;
        this.a = str;
        this.f2841b = tJTaskHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            TapjoyLog.d("TJAdUnit", "setBackgroundColor: " + this.a);
            this.c.a.g.setBackgroundColor(Color.parseColor(this.a));
            this.f2841b.onComplete(Boolean.TRUE);
        } catch (Exception unused) {
            TapjoyLog.d("TJAdUnit", "Error setting background color. backgroundView: " + this.c.a.g + ", hexColor: " + this.a);
            this.f2841b.onComplete(Boolean.FALSE);
        }
    }
}
