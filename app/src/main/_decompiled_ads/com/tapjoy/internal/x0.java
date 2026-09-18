package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tapjoy.TJContentActivity;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyLog;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class x0 extends f5 {
    public static x0 o;
    public final v1 d;
    public final String e;
    public final q0 f;
    public boolean g;
    public boolean h;
    public final Context i;
    public t0 j;
    public Activity k;
    public g2 l;
    public Handler m;
    public w0 n;

    public x0(v1 v1Var, String str, q0 q0Var, Context context) {
        this.d = v1Var;
        this.e = str;
        this.f = q0Var;
        this.i = context;
    }

    @Override // com.tapjoy.internal.f5
    public final boolean a() {
        return this.f.a();
    }

    @Override // com.tapjoy.internal.f5
    public final void b() {
        Iterator it = this.f.a.iterator();
        while (it.hasNext()) {
            for (f0 f0Var : ((j4) it.next()).c) {
                l6 l6Var = f0Var.k;
                if (l6Var != null) {
                    l6Var.b();
                }
                l6 l6Var2 = f0Var.l;
                if (l6Var2 != null) {
                    l6Var2.b();
                }
            }
        }
    }

    public final void c() {
        g2 g2Var;
        if (this.h) {
            this.h = false;
            Handler handler = this.m;
            if (handler != null) {
                handler.removeCallbacks(this.n);
                this.n = null;
                this.m = null;
            }
            if (o == this) {
                o = null;
            }
            v1 v1Var = this.d;
            LinkedHashMap linkedHashMap = this.f.f2800b;
            SystemClock.elapsedRealtime();
            p1 p1Var = v1Var.f;
            p1Var.getClass();
            n1 n1VarA = p1Var.a(r1.CAMPAIGN, "view");
            if (linkedHashMap != null) {
                StringWriter stringWriter = new StringWriter();
                g4 g4Var = new g4(stringWriter);
                try {
                    g4Var.a(linkedHashMap);
                    try {
                        g4Var.a.flush();
                        stringWriter.toString();
                    } catch (IOException e) {
                        s9.a(e);
                        throw null;
                    }
                } catch (IOException e2) {
                    s9.a(e2);
                    throw null;
                }
            }
            p1Var.a(n1VarA);
            if (!this.a && (g2Var = this.l) != null) {
                g2Var.a(this.e, this.c, null);
                this.l = null;
            }
            ViewGroup viewGroup = (ViewGroup) this.j.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.j);
            }
            this.j = null;
            Activity activity = this.k;
            if (activity instanceof TJContentActivity) {
                activity.finish();
            }
            this.k = null;
        }
    }

    @Override // com.tapjoy.internal.f5
    public final void a(g2 g2Var) {
        Activity activity;
        this.l = g2Var;
        WeakReference weakReference = t.e.a;
        Activity activityA = (Activity) (weakReference != null ? weakReference.get() : null);
        if (activityA == null) {
            activityA = t.a();
        }
        this.k = activityA;
        if (activityA != null && !activityA.isFinishing()) {
            try {
                a(this.k, g2Var);
                return;
            } catch (WindowManager.BadTokenException unused) {
            }
        }
        Context baseContext = this.i;
        while (true) {
            if (!(baseContext instanceof ContextWrapper)) {
                activity = null;
                break;
            } else {
                if (baseContext instanceof Activity) {
                    activity = (Activity) baseContext;
                    break;
                }
                baseContext = ((ContextWrapper) baseContext).getBaseContext();
            }
        }
        this.k = activity;
        if (activity != null && !activity.isFinishing()) {
            try {
                a(this.k, g2Var);
                return;
            } catch (WindowManager.BadTokenException unused2) {
            }
        }
        g2Var.a(this.e, this.c, null);
    }

    public final void a(Activity activity, g2 g2Var) {
        if (this.g) {
            TapjoyLog.e("x0", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Content is already displayed"));
            return;
        }
        this.g = true;
        this.h = true;
        o = this;
        this.j = new t0(activity, this.f, new v0(this, activity, g2Var));
        Window window = activity.getWindow();
        t0 t0Var = this.j;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        Window.Callback callback = window.getCallback();
        window.setCallback(null);
        window.addContentView(t0Var, layoutParams);
        window.setCallback(callback);
        SystemClock.elapsedRealtime();
        v1 v1Var = this.d;
        LinkedHashMap linkedHashMap = this.f.f2800b;
        p1 p1Var = v1Var.f;
        p1Var.getClass();
        n1 n1VarA = p1Var.a(r1.CAMPAIGN, "impression");
        if (linkedHashMap != null) {
            StringWriter stringWriter = new StringWriter();
            g4 g4Var = new g4(stringWriter);
            try {
                g4Var.a(linkedHashMap);
                try {
                    g4Var.a.flush();
                    stringWriter.toString();
                } catch (IOException e) {
                    s9.a(e);
                    throw null;
                }
            } catch (IOException e2) {
                s9.a(e2);
                throw null;
            }
        }
        p1Var.a(n1VarA);
        g2Var.b(this.e);
        if (this.f.c > 0.0f) {
            Handler handler = new Handler(Looper.getMainLooper());
            this.m = handler;
            w0 w0Var = new w0(this);
            this.n = w0Var;
            handler.postDelayed(w0Var, (long) (this.f.c * 1000.0f));
        }
    }
}
