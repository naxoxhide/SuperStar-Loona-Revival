package b.b.a.a.d.h;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b.b.a.a.d.f.g;
import b.b.a.a.d.f.h;
import b.b.a.a.d.f.k;
import b.b.a.a.d.f.m;
import b.b.a.a.d.f.n;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* JADX INFO: compiled from: BaseWebViewRender.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements b.b.a.a.d.f.d<SSWebView>, k, com.bytedance.sdk.component.adexpress.theme.a {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f124b;
    private String c;
    private volatile g d;
    private boolean e;
    protected boolean f;
    private h g;
    private m h;
    protected SSWebView i;
    private boolean j;
    protected b.b.a.a.d.e.c.b l;
    protected int k = 8;
    protected AtomicBoolean m = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b.b.a.a.d.h.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseWebViewRender.java */
    class RunnableC0028a implements Runnable {
        final /* synthetic */ n a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f125b;
        final /* synthetic */ float c;

        RunnableC0028a(n nVar, float f, float f2) {
            this.a = nVar;
            this.f125b = f;
            this.c = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a(this.a, this.f125b, this.c);
        }
    }

    public a(Context context, m mVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        this.e = false;
        this.a = context;
        this.h = mVar;
        mVar.a();
        themeStatusBroadcastReceiver.a(this);
        SSWebView sSWebViewA = e.e().a();
        this.i = sSWebViewA;
        if (sSWebViewA != null) {
            this.e = true;
            Log.d("WebViewRender", "initWebView: reuse WebView");
        } else {
            Log.d("WebViewRender", "initWebView: create WebView");
            if (b.b.a.a.d.c.a() != null) {
                this.i = new SSWebView(b.b.a.a.d.c.a());
            }
        }
    }

    private void c(int i) {
        if (this.d != null) {
            this.d.a(i);
        }
    }

    public void a() {
    }

    @Override // b.b.a.a.d.f.d
    public int b() {
        return 0;
    }

    public abstract void b(int i);

    public void c() {
    }

    @Override // b.b.a.a.d.f.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public SSWebView e() {
        return f();
    }

    public abstract SSWebView f();

    public m g() {
        return this.h;
    }

    public void h() {
        j();
        Activity activityA = com.bytedance.sdk.component.utils.b.a(this.i);
        if (activityA != null) {
            activityA.hashCode();
        }
    }

    public abstract void i();

    protected void j() {
    }

    public void k() {
        if (this.m.get()) {
            return;
        }
        this.m.set(true);
        i();
        if (this.i.getParent() != null) {
            ((ViewGroup) this.i.getParent()).removeView(this.i);
        }
        if (this.f) {
            e.e().c(this.i);
        } else {
            e.e().a(this.i);
        }
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(h hVar) {
        this.g = hVar;
    }

    @Override // b.b.a.a.d.f.d
    public void a(g gVar) {
        this.d = gVar;
        if (f() != null && f().getWebView() != null) {
            if (!b.b.a.a.d.e.b.a.f()) {
                this.d.a(102);
                return;
            }
            if (TextUtils.isEmpty(this.c)) {
                this.d.a(102);
                return;
            }
            if (this.l == null && !b.b.a.a.d.e.b.a.a(this.f124b)) {
                this.d.a(103);
                return;
            }
            this.h.o().a(this.e);
            if (this.e) {
                try {
                    this.i.f();
                    this.h.o().c();
                    l.a(this.i.getWebView(), "javascript:window.SDK_RESET_RENDER();window.SDK_TRIGGER_RENDER();");
                    return;
                } catch (Exception unused) {
                    com.bytedance.sdk.component.utils.m.a("WebViewRender", "reuse webview load fail ");
                    e.e().a(this.i);
                    this.d.a(102);
                    return;
                }
            }
            SSWebView sSWebViewF = f();
            sSWebViewF.f();
            this.h.o().c();
            sSWebViewF.c(this.c);
            return;
        }
        this.d.a(102);
    }

    public void a(boolean z) {
        this.j = z;
    }

    @Override // b.b.a.a.d.f.k
    public void a(n nVar) {
        if (nVar == null) {
            if (this.d != null) {
                this.d.a(105);
                return;
            }
            return;
        }
        boolean zN = nVar.n();
        float fB = (float) nVar.b();
        float fA = (float) nVar.a();
        if (fB > 0.0f && fA > 0.0f) {
            this.f = zN;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                a(nVar, fB, fA);
                return;
            } else {
                new Handler(Looper.getMainLooper()).post(new RunnableC0028a(nVar, fB, fA));
                return;
            }
        }
        if (this.d != null) {
            this.d.a(105);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, float f, float f2) {
        if (this.f && !this.j) {
            a(f, f2);
            b(this.k);
            if (this.d != null) {
                this.d.a(f(), nVar);
                return;
            }
            return;
        }
        e.e().a(this.i);
        c(nVar.c());
    }

    @Override // b.b.a.a.d.f.k
    public void a(View view, int i, b.b.a.a.d.b bVar) {
        h hVar = this.g;
        if (hVar != null) {
            hVar.a(view, i, bVar);
        }
    }

    private void a(float f, float f2) {
        this.h.o().d();
        int iA = (int) b.b.a.a.d.g.d.a(this.a, f);
        int iA2 = (int) b.b.a.a.d.g.d.a(this.a, f2);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) f().getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(iA, iA2);
        }
        layoutParams.width = iA;
        layoutParams.height = iA2;
        f().setLayoutParams(layoutParams);
    }

    public void a(JSONObject jSONObject) {
        this.f124b = jSONObject;
    }
}
