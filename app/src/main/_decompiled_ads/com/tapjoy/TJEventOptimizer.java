package com.tapjoy;

import android.content.Context;
import android.webkit.WebView;
import com.tapjoy.internal.w8;
import com.tapjoy.internal.x8;
import com.tapjoy.internal.y8;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes4.dex */
public class TJEventOptimizer extends WebView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static TJEventOptimizer f2692b;
    public static CountDownLatch c;
    public final Context a;

    public TJEventOptimizer(Context context) {
        super(context);
        this.a = context;
        new TJAdUnitJSBridge(new x8(this));
        try {
            getSettings().setJavaScriptEnabled(true);
            setWebViewClient(new u());
            setWebChromeClient(new y8());
            loadUrl(TapjoyConnectCore.getHostURL() + TJAdUnitConstants.EVENTS_PROXY_PATH + TapjoyUtil.convertURLParams(TapjoyConnectCore.getGenericURLParams(), true));
        } catch (Exception e) {
            TapjoyLog.w("TJEventOptimizer", e.getMessage());
        }
    }

    public static TJEventOptimizer getInstance() {
        return f2692b;
    }

    public static void init(Context context) throws InterruptedException {
        TapjoyLog.d("TJEventOptimizer", "Initializing event optimizer");
        c = new CountDownLatch(1);
        TapjoyUtil.runOnMainThread(new w8(context));
        c.await();
        if (f2692b == null) {
            throw new RuntimeException("Failed to init TJEventOptimizer");
        }
    }
}
