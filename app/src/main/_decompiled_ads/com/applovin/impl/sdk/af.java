package com.applovin.impl.sdk;

import android.os.Build;
import android.webkit.WebView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class af {
    private static WebView aFU;
    private static final Object aFV = new Object();
    private static final AtomicBoolean aFW = new AtomicBoolean();
    private static String ta;

    public static void z(n nVar) {
    }

    static {
        if (Fx()) {
            ta = (String) com.applovin.impl.sdk.c.e.b(com.applovin.impl.sdk.c.d.aRK, "", n.getApplicationContext());
            return;
        }
        ta = "";
        com.applovin.impl.sdk.c.e.a(com.applovin.impl.sdk.c.d.aRK, (Object) null, n.getApplicationContext());
        com.applovin.impl.sdk.c.e.a(com.applovin.impl.sdk.c.d.aRL, (Object) null, n.getApplicationContext());
    }

    public static void A(final n nVar) {
        if (Fx() || aFW.getAndSet(true)) {
            return;
        }
        if (com.applovin.impl.sdk.utils.h.KT()) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$af$vmHKmQekMe683V90LNq31lAsteY
                @Override // java.lang.Runnable
                public final void run() {
                    af.C(nVar);
                }
            });
        } else {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$af$n9IVkCzXv5Cq20N8yw8qIXG6oYg
                @Override // java.lang.Runnable
                public final void run() {
                    af.B(nVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0028 */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void C(com.applovin.impl.sdk.n r4) {
        /*
            java.lang.Object r0 = com.applovin.impl.sdk.af.aFV     // Catch: java.lang.Throwable -> L28
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L28
            android.content.Context r1 = com.applovin.impl.sdk.n.getApplicationContext()     // Catch: java.lang.Throwable -> L25
            java.lang.String r1 = android.webkit.WebSettings.getDefaultUserAgent(r1)     // Catch: java.lang.Throwable -> L25
            com.applovin.impl.sdk.af.ta = r1     // Catch: java.lang.Throwable -> L25
            com.applovin.impl.sdk.c.d<java.lang.String> r1 = com.applovin.impl.sdk.c.d.aRK     // Catch: java.lang.Throwable -> L25
            java.lang.String r2 = com.applovin.impl.sdk.af.ta     // Catch: java.lang.Throwable -> L25
            android.content.Context r3 = com.applovin.impl.sdk.n.getApplicationContext()     // Catch: java.lang.Throwable -> L25
            com.applovin.impl.sdk.c.e.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L25
            com.applovin.impl.sdk.c.d<java.lang.String> r1 = com.applovin.impl.sdk.c.d.aRL     // Catch: java.lang.Throwable -> L25
            java.lang.String r2 = android.os.Build.VERSION.RELEASE     // Catch: java.lang.Throwable -> L25
            android.content.Context r3 = com.applovin.impl.sdk.n.getApplicationContext()     // Catch: java.lang.Throwable -> L25
            com.applovin.impl.sdk.c.e.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L25
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L25
            goto L48
        L25:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L25
            throw r1     // Catch: java.lang.Throwable -> L28
        L28:
            r0 = move-exception
            r4.BL()
            boolean r1 = com.applovin.impl.sdk.x.Fk()
            if (r1 == 0) goto L3d
            com.applovin.impl.sdk.x r1 = r4.BL()
            java.lang.String r2 = "WebViewDataCollector"
            java.lang.String r3 = "Failed to collect user agent"
            r1.c(r2, r3, r0)
        L3d:
            com.applovin.impl.sdk.r r4 = r4.Cq()
            java.lang.String r1 = "WebViewDataCollector"
            java.lang.String r2 = "collectUserAgent"
            r4.d(r1, r2, r0)
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.af.C(com.applovin.impl.sdk.n):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Bottom block not found for handler: all -> 0x002d */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void B(com.applovin.impl.sdk.n r4) {
        /*
            z(r4)     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r0 = com.applovin.impl.sdk.af.aFV     // Catch: java.lang.Throwable -> L2d
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L2d
            android.webkit.WebView r1 = com.applovin.impl.sdk.af.aFU     // Catch: java.lang.Throwable -> L2a
            android.webkit.WebSettings r1 = r1.getSettings()     // Catch: java.lang.Throwable -> L2a
            java.lang.String r1 = r1.getUserAgentString()     // Catch: java.lang.Throwable -> L2a
            com.applovin.impl.sdk.af.ta = r1     // Catch: java.lang.Throwable -> L2a
            com.applovin.impl.sdk.c.d<java.lang.String> r1 = com.applovin.impl.sdk.c.d.aRK     // Catch: java.lang.Throwable -> L2a
            java.lang.String r2 = com.applovin.impl.sdk.af.ta     // Catch: java.lang.Throwable -> L2a
            android.content.Context r3 = com.applovin.impl.sdk.n.getApplicationContext()     // Catch: java.lang.Throwable -> L2a
            com.applovin.impl.sdk.c.e.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L2a
            com.applovin.impl.sdk.c.d<java.lang.String> r1 = com.applovin.impl.sdk.c.d.aRL     // Catch: java.lang.Throwable -> L2a
            java.lang.String r2 = android.os.Build.VERSION.RELEASE     // Catch: java.lang.Throwable -> L2a
            android.content.Context r3 = com.applovin.impl.sdk.n.getApplicationContext()     // Catch: java.lang.Throwable -> L2a
            com.applovin.impl.sdk.c.e.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            goto L4d
        L2a:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            throw r1     // Catch: java.lang.Throwable -> L2d
        L2d:
            r0 = move-exception
            r4.BL()
            boolean r1 = com.applovin.impl.sdk.x.Fk()
            if (r1 == 0) goto L42
            com.applovin.impl.sdk.x r1 = r4.BL()
            java.lang.String r2 = "WebViewDataCollector"
            java.lang.String r3 = "Failed to collect user agent"
            r1.c(r2, r3, r0)
        L42:
            com.applovin.impl.sdk.r r4 = r4.Cq()
            java.lang.String r1 = "WebViewDataCollector"
            java.lang.String r2 = "collectUserAgent"
            r4.d(r1, r2, r0)
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.af.B(com.applovin.impl.sdk.n):void");
    }

    public static String Fw() {
        String str;
        synchronized (aFV) {
            str = ta;
        }
        return str;
    }

    public static boolean Fx() {
        boolean zEquals;
        synchronized (aFV) {
            zEquals = Build.VERSION.RELEASE.equals((String) com.applovin.impl.sdk.c.e.b(com.applovin.impl.sdk.c.d.aRL, "", n.getApplicationContext()));
        }
        return zEquals;
    }
}
