package b.b.a.a.d.h;

import android.webkit.JavascriptInterface;
import b.b.a.a.e.z;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: WebViewBridgeProxy.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private WeakReference<z> a;

    public d(z zVar) {
        this.a = new WeakReference<>(zVar);
    }

    public void a(z zVar) {
        this.a = new WeakReference<>(zVar);
    }

    @JavascriptInterface
    public void invokeMethod(String str) {
        WeakReference<z> weakReference = this.a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.a.get().invokeMethod(str);
    }
}
