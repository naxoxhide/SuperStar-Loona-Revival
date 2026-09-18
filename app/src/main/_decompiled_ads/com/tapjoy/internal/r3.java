package com.tapjoy.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.SystemClock;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tapjoy.TJContentActivity;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyLog;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class r3 extends f5 {
    public static r3 l;
    public final v1 d;
    public final String e;
    public final m3 f;
    public a1 g;
    public boolean h;
    public long i;
    public final Context j;
    public boolean k = false;

    public r3(v1 v1Var, String str, m3 m3Var, Context context) {
        this.d = v1Var;
        this.e = str;
        this.f = m3Var;
        this.j = context;
    }

    @Override // com.tapjoy.internal.f5
    public final boolean a() {
        w4 w4Var;
        l6 l6Var;
        l6 l6Var2;
        l6 l6Var3;
        l6 l6Var4;
        l6 l6Var5;
        m3 m3Var = this.f;
        l6 l6Var6 = m3Var.c;
        return (l6Var6 == null || l6Var6.f2779b == null || ((w4Var = m3Var.l) != null && (l6Var5 = w4Var.a) != null && l6Var5.f2779b == null) || (((l6Var = m3Var.f2782b) == null || (l6Var4 = m3Var.f) == null || l6Var.f2779b == null || l6Var4.f2779b == null) && ((l6Var2 = m3Var.a) == null || (l6Var3 = m3Var.e) == null || l6Var2.f2779b == null || l6Var3.f2779b == null))) ? false : true;
    }

    @Override // com.tapjoy.internal.f5
    public final void b() {
        l6 l6Var;
        m3 m3Var = this.f;
        l6 l6Var2 = m3Var.a;
        if (l6Var2 != null) {
            l6Var2.b();
        }
        l6 l6Var3 = m3Var.f2782b;
        if (l6Var3 != null) {
            l6Var3.b();
        }
        m3Var.c.b();
        l6 l6Var4 = m3Var.e;
        if (l6Var4 != null) {
            l6Var4.b();
        }
        l6 l6Var5 = m3Var.f;
        if (l6Var5 != null) {
            l6Var5.b();
        }
        w4 w4Var = m3Var.l;
        if (w4Var == null || (l6Var = w4Var.a) == null) {
            return;
        }
        l6Var.b();
    }

    @Override // com.tapjoy.internal.f5
    public final void a(g2 g2Var) {
        Activity activity;
        Context baseContext = this.j;
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
        if (activity != null && !activity.isFinishing()) {
            try {
                a(activity, g2Var);
                return;
            } catch (WindowManager.BadTokenException unused) {
            }
        }
        WeakReference weakReference = t.e.a;
        Activity activityA = (Activity) (weakReference != null ? weakReference.get() : null);
        if (activityA == null) {
            activityA = t.a();
        }
        boolean z = false;
        if (activityA != null && (activityA.getWindow().getAttributes().flags & 1024) != 0) {
            z = true;
        }
        try {
            TJContentActivity.start(v1.m.d, new n3(this, g2Var), z);
        } catch (ActivityNotFoundException unused2) {
            if (activityA != null && !activityA.isFinishing()) {
                try {
                    a(activityA, g2Var);
                    return;
                } catch (WindowManager.BadTokenException unused3) {
                    g2Var.a(this.e, this.c, null);
                }
            }
            g2Var.a(this.e, this.c, null);
        }
    }

    public final void a(Activity activity, g2 g2Var) {
        if (this.h) {
            TapjoyLog.e("r3", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Content is already displayed"));
            return;
        }
        this.h = true;
        l = this;
        a1 a1Var = new a1(activity);
        this.g = a1Var;
        a1Var.setOnCancelListener(new o3(this, g2Var));
        this.g.setOnDismissListener(new p3(this, activity, g2Var));
        this.g.setCanceledOnTouchOutside(false);
        s3 s3Var = new s3(activity, this.f, new t3(activity, this.f, new q3(this, activity, g2Var)));
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.addView(s3Var, new FrameLayout.LayoutParams(-2, -2, 17));
        this.g.setContentView(frameLayout);
        this.g.show();
        this.g.getWindow().setLayout(-1, -1);
        if ((activity.getWindow().getAttributes().flags & 1024) != 0) {
            this.g.getWindow().setFlags(1024, 1024);
        }
        this.i = SystemClock.elapsedRealtime();
        v1 v1Var = this.d;
        LinkedHashMap linkedHashMap = this.f.k;
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
    }
}
