package com.mbridge.msdk.foundation.controller;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.d;
import com.mbridge.msdk.foundation.tools.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MBSDKContext.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    public static final String a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List<String> f2068b = new ArrayList();
    public static HashMap<String, String> c = new HashMap<>();
    private static b d;
    private Context e;
    private String f;
    private String g;
    private String h;
    private JSONObject j;
    private int k;
    private int m;
    private WeakReference<Context> n;
    private WeakReference<Activity> o;
    private String r;
    private int i = 0;
    private boolean l = false;
    private JSONObject p = new JSONObject();
    private ConcurrentHashMap<String, String> q = new ConcurrentHashMap<>();
    private final d s = new d();

    /* JADX INFO: compiled from: MBSDKContext.java */
    public interface a {
    }

    public final void a(String str) {
        try {
            ConcurrentHashMap<String, String> concurrentHashMap = this.q;
            if (concurrentHashMap != null && concurrentHashMap.containsKey(str)) {
                this.q.remove(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final BitmapDrawable a(String str, int i) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        String str2;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.q) == null || !concurrentHashMap.containsKey(str) || !ac.a().a("w_m_r_l", true)) {
            return null;
        }
        String str3 = this.q.get(str);
        BitmapDrawable bitmapDrawableN = af.n(str3);
        int i2 = TextUtils.isEmpty(str3) ? 2 : 1;
        if (TextUtils.isEmpty(str3)) {
            str2 = "get watermark failed";
        } else {
            str2 = bitmapDrawableN != null ? "" : "str to bitmap failed";
        }
        q.a(str, i, i2, str2, bitmapDrawableN == null ? 2 : 1, str3);
        return bitmapDrawableN;
    }

    public final void a(String str, JSONObject jSONObject) {
        if (ac.a().a("w_m_r_l", true)) {
            try {
                if (this.p == null) {
                    this.p = jSONObject;
                } else if (jSONObject != null) {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        this.p.put(next, jSONObject.get(next));
                    }
                }
                if (this.p.has(MBridgeConstans.EXTRA_KEY_WM)) {
                    if (this.q == null) {
                        this.q = new ConcurrentHashMap<>();
                    }
                    this.q.put(str, this.p.getString(MBridgeConstans.EXTRA_KEY_WM));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final WeakReference<Activity> a() {
        return this.o;
    }

    public final void a(WeakReference<Activity> weakReference) {
        this.o = weakReference;
    }

    public final void a(int i) {
        this.k = i;
    }

    public final String b() {
        try {
            Context context = this.e;
            if (context != null) {
                return context.getPackageName();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final Context c() {
        WeakReference<Context> weakReference = this.n;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final void a(Context context) {
        if (context instanceof Activity) {
            this.n = new WeakReference<>(context);
        }
    }

    public final void a(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            String name = activity.getClass().getName();
            WeakReference<Context> weakReference = this.n;
            if (weakReference != null) {
                Context context = weakReference.get();
                if ((context instanceof Activity) && ((Activity) context).getClass().getName().equals(name)) {
                    this.n.clear();
                }
            }
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
    }

    public final void b(String str) {
        Context context;
        try {
            this.r = str;
            if (TextUtils.isEmpty(str) || (context = this.e) == null) {
                return;
            }
            ai.a(context, "applicationIds", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private b() {
    }

    public static synchronized b d() {
        if (d == null) {
            d = new b();
        }
        return d;
    }

    public final int e() {
        return this.m;
    }

    public final void b(int i) {
        this.m = i;
    }

    public final d f() {
        return this.s;
    }

    public final void a(a aVar, final Handler handler) {
        if (this.l) {
            return;
        }
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.g() && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                Object objB = ai.b(this.e, MBridgeConstans.SP_GA_ID, "");
                Object objB2 = ai.b(this.e, MBridgeConstans.SP_GA_ID_LIMIT, 0);
                if (objB instanceof String) {
                    String str = (String) objB;
                    if (!TextUtils.isEmpty(str)) {
                        w.a(str);
                    } else {
                        w.a();
                    }
                    if (objB2 instanceof Integer) {
                        w.a(((Integer) objB2).intValue());
                    }
                }
            }
        } catch (Exception e) {
            aa.d(a, e.getMessage());
        }
        try {
            JSONObject jSONObject = new JSONObject();
            this.j = jSONObject;
            jSONObject.put("webgl", 0);
        } catch (JSONException e2) {
            aa.d(a, e2.getMessage());
        }
        new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                    try {
                        w.d(b.this.e.getPackageManager().getApplicationInfo("com.android.vending", 0).enabled ? 1 : 2);
                    } catch (PackageManager.NameNotFoundException unused) {
                        w.d(0);
                    } catch (Throwable th) {
                        aa.d(b.a, th.getMessage());
                    }
                }
                try {
                    com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(b.d().h());
                    if (cVarB == null) {
                        cVarB = com.mbridge.msdk.c.d.a().b();
                    }
                    Message messageObtain = Message.obtain();
                    messageObtain.obj = cVarB;
                    messageObtain.what = 9;
                    handler.sendMessage(messageObtain);
                } catch (Exception e3) {
                    aa.d(b.a, e3.getMessage());
                }
                try {
                    w.c(b.this.e);
                    com.mbridge.msdk.c.d.a(b.this.e, b.this.f);
                } catch (Exception e4) {
                    aa.d(b.a, e4.getMessage());
                }
            }
        }).start();
    }

    public final Context g() {
        return this.e;
    }

    public final void b(Context context) {
        this.e = context;
    }

    public final String h() {
        try {
            if (!TextUtils.isEmpty(this.f)) {
                return this.f;
            }
            Context context = this.e;
            if (context != null) {
                return (String) ai.b(context, "sp_appId", "");
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void c(String str) {
        Context context;
        try {
            this.f = str;
            if (TextUtils.isEmpty(str) || (context = this.e) == null) {
                return;
            }
            ai.a(context, "sp_appId", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final String i() {
        if (!TextUtils.isEmpty(this.h)) {
            return this.h;
        }
        Context context = this.e;
        if (context != null) {
            return (String) ai.b(context, "sp_wx_appKey", "");
        }
        return null;
    }

    public final void d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.h = str;
            Context context = this.e;
            if (context != null) {
                ai.a(context, "sp_wx_appKey", str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final String j() {
        if (!TextUtils.isEmpty(this.g)) {
            return this.g;
        }
        Context context = this.e;
        if (context != null) {
            return (String) ai.b(context, "sp_appKey", "");
        }
        return null;
    }

    public final void e(String str) {
        Context context;
        try {
            this.g = str;
            if (TextUtils.isEmpty(str) || (context = this.e) == null) {
                return;
            }
            ai.a(context, "sp_appKey", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final int k() {
        return this.i;
    }

    public final void c(int i) {
        this.i = i;
    }

    public final JSONObject l() {
        return this.j;
    }

    public final void a(JSONObject jSONObject) {
        this.j = jSONObject;
    }
}
