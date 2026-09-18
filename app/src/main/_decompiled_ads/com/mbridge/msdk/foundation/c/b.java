package com.mbridge.msdk.foundation.c;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.c.c;
import com.mbridge.msdk.c.d;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.dialog.MBFeedBackDialog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* JADX INFO: compiled from: FeedbackManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static int a = -2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f2065b = -2;
    public static volatile boolean c = false;
    private final ConcurrentHashMap<String, com.mbridge.msdk.foundation.c.a.a> d;
    private final RelativeLayout.LayoutParams e;
    private c f;

    private b() {
        this.d = new ConcurrentHashMap<>();
        this.e = new RelativeLayout.LayoutParams(a, f2065b);
    }

    /* JADX INFO: compiled from: FeedbackManager.java */
    static class a {
        private static final b a = new b();
    }

    public static b a() {
        return a.a;
    }

    public final Activity a(Context context) {
        Activity activity;
        Context contextC = com.mbridge.msdk.foundation.controller.b.d().c();
        Activity activity2 = null;
        try {
            Activity activity3 = contextC instanceof Activity ? (Activity) contextC : null;
            try {
                if ((context instanceof Activity) && (Build.VERSION.SDK_INT < 17 || !((Activity) context).isDestroyed())) {
                    activity3 = (Activity) context;
                }
                WeakReference<Activity> weakReferenceA = com.mbridge.msdk.foundation.controller.b.d().a();
                if (weakReferenceA != null && (activity = weakReferenceA.get()) != null && !activity.isFinishing() && (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed())) {
                    activity3 = activity;
                }
                if (activity3 == null || activity3.isFinishing()) {
                    return null;
                }
                if (Build.VERSION.SDK_INT < 17 || !activity3.isDestroyed()) {
                    return activity3;
                }
                return null;
            } catch (Exception e) {
                e = e;
                activity2 = activity3;
                e.printStackTrace();
                return activity2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private boolean a(Context context, MBFeedBackDialog mBFeedBackDialog) {
        Activity activityA = a(context);
        if (activityA == null || mBFeedBackDialog == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 17 && activityA.isDestroyed()) {
            return false;
        }
        try {
            if (mBFeedBackDialog.isShowing() || activityA.isFinishing()) {
                return false;
            }
            mBFeedBackDialog.show();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean a(String str, Context context, MBFeedBackDialog mBFeedBackDialog) {
        if (mBFeedBackDialog == null) {
            aa.b("", "mbAlertDialog  is null");
            return false;
        }
        return a(context, mBFeedBackDialog);
    }

    public final void a(String str, int i, ViewGroup viewGroup) {
        com.mbridge.msdk.foundation.c.a.a aVarA = a(str);
        if (aVarA.c() != null) {
            aVarA.a(i);
            if (i == 0) {
                a(str, com.mbridge.msdk.foundation.controller.b.d().g(), viewGroup, (ViewGroup.LayoutParams) null, (com.mbridge.msdk.foundation.c.a) null);
            }
        }
    }

    public final void a(String str, int i, int i2, int i3, float f, float f2, float f3, String str2, String str3, float f4, JSONArray jSONArray) {
        com.mbridge.msdk.foundation.c.a.a aVarA = a(str);
        Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
        aVarA.a(af.b(contextG, f), af.b(contextG, f2), af.b(contextG, i), af.b(contextG, i2), af.b(contextG, i3), f3, str2, str3, f4, jSONArray);
    }

    public final boolean b() {
        c cVarB = d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
        this.f = cVarB;
        if (cVarB != null) {
            return false;
        }
        this.f = d.a().b();
        return false;
    }

    public final void a(String str, com.mbridge.msdk.foundation.c.a aVar) {
        com.mbridge.msdk.foundation.c.a.a aVarA = a(str);
        if (aVar != null) {
            aVarA.a(new com.mbridge.msdk.foundation.c.a.a.C0478a(str, aVar));
        }
    }

    public final void a(String str, Context context, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, com.mbridge.msdk.foundation.c.a aVar) {
        if (b()) {
            com.mbridge.msdk.foundation.c.a.a aVarA = a(str);
            if (aVar != null) {
                aVarA.a(new com.mbridge.msdk.foundation.c.a.a.C0478a(str, aVar));
            }
            FeedBackButton feedBackButtonC = aVarA.c();
            if (feedBackButtonC != null) {
                if (layoutParams == null) {
                    int iB = af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 10.0f);
                    this.e.setMargins(iB, iB, iB, iB);
                    layoutParams = this.e;
                }
                ViewGroup viewGroup2 = (ViewGroup) feedBackButtonC.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(feedBackButtonC);
                }
                Activity activityA = a(context);
                if (activityA != null && viewGroup == null) {
                    viewGroup = (ViewGroup) activityA.findViewById(R.id.content);
                }
                if (viewGroup != null) {
                    viewGroup.removeView(feedBackButtonC);
                    viewGroup.addView(feedBackButtonC, layoutParams);
                }
            }
        }
    }

    public final void a(String str, int i, com.mbridge.msdk.foundation.c.a aVar) {
        com.mbridge.msdk.foundation.c.a.a aVarA = a(str);
        aVarA.a(new com.mbridge.msdk.foundation.c.a.a.C0478a(str, aVar));
        if (i == 1) {
            aVarA.b();
        } else {
            aVarA.a();
        }
    }

    public final void a(String str, CampaignEx campaignEx) {
        a(str).a(campaignEx);
    }

    public final void a(String str, int i) {
        a(str).b(i);
    }

    public final void b(String str, int i) {
        a(str).c(i);
    }

    public final void a(String str, String str2) {
        a(str).a(str2);
    }

    public final com.mbridge.msdk.foundation.c.a.a a(String str) {
        com.mbridge.msdk.foundation.c.a.a aVar;
        if (TextUtils.isEmpty(str)) {
            str = com.mbridge.msdk.foundation.controller.b.d().h();
        }
        if (!this.d.containsKey(str)) {
            aVar = new com.mbridge.msdk.foundation.c.a.a(str);
            this.d.put(str, aVar);
        } else {
            aVar = this.d.get(str);
        }
        if (aVar != null) {
            return aVar;
        }
        com.mbridge.msdk.foundation.c.a.a aVar2 = new com.mbridge.msdk.foundation.c.a.a(str);
        this.d.put(str, aVar2);
        return aVar2;
    }

    private com.mbridge.msdk.foundation.c.a.a d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = com.mbridge.msdk.foundation.controller.b.d().h();
        }
        if (this.d.containsKey(str)) {
            return this.d.get(str);
        }
        return null;
    }

    public final void a(String str, FeedBackButton feedBackButton) {
        a(str).a(feedBackButton);
    }

    public final FeedBackButton b(String str) {
        return a(str).c();
    }

    public final void a(String str, int i, int i2, String str2, String str3) {
        com.mbridge.msdk.foundation.c.a.a aVarD = d(str + "_1");
        if (aVarD == null) {
            aVarD = d(str + "_2");
            if (aVarD == null && (aVarD = d(str + "_3")) == null && (aVarD = d(str + "_4")) == null) {
                aVarD = a(str);
            } else {
                aVarD.b(0);
            }
        }
        if (aVarD != null) {
            CampaignEx campaignExE = aVarD.e();
            q.a(campaignExE, campaignExE != null ? campaignExE.getCampaignUnitId() : "", aVarD.f(), aVarD.g(), !TextUtils.isEmpty(str2) ? str2 : "", i, campaignExE != null ? campaignExE.getAdType() : 0, i2, str3);
        }
    }

    public final void c(String str) {
        try {
            com.mbridge.msdk.foundation.c.a.a aVarD = d(str);
            if (aVarD != null) {
                aVarD.d();
            }
            this.d.remove(str);
            c = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
