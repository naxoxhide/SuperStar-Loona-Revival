package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: GlobalInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static k o = null;
    private static boolean p = false;
    public static final Set<String> q = new a();
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f596b;
    private int c;
    private boolean d;
    private String e;
    private String f;
    private int g;
    private boolean h;
    private Bitmap i;
    private int j;
    private Boolean k;
    private String l;
    private com.bytedance.sdk.openadsdk.core.j0.b.c m;
    private volatile ConcurrentHashMap<String, com.bytedance.sdk.openadsdk.core.bannerexpress.a.h> n;

    /* JADX INFO: compiled from: GlobalInfo.java */
    static class a extends HashSet<String> {
        a() {
            add("8025677");
            add("5001121");
        }
    }

    /* JADX INFO: compiled from: GlobalInfo.java */
    private static class b {
        private static h a = new h(null);
    }

    /* synthetic */ h(a aVar) {
        this();
    }

    public static void a(k kVar) {
        o = kVar;
    }

    public static boolean t() {
        return p;
    }

    public static void w() {
        if (Build.VERSION.SDK_INT == 26 && "MI 6".equals(Build.MODEL)) {
            p = true;
        }
    }

    public void b(int i) {
        if (i == 0 || i == 1 || i == -1) {
            int iH = h();
            com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_privacy", "tt_gdpr", Integer.valueOf(i));
            if (iH != i) {
                com.bytedance.sdk.openadsdk.core.settings.n.j0().a(4, true);
            }
        }
    }

    public void b(boolean z) {
    }

    public int c() {
        return com.bytedance.sdk.openadsdk.m.b.b() ? com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_icon_id", "icon_id", 0) : this.c;
    }

    public String d() {
        return com.bytedance.sdk.openadsdk.m.b.b() ? com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_app_id", "app_id", (String) null) : this.a;
    }

    public void e(int i) {
        if (i == 0 || i == 1 || i == -1) {
            int iM = m();
            com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_privacy", "sdk_coppa", Integer.valueOf(i));
            if (iM != i) {
                com.bytedance.sdk.openadsdk.core.settings.n.j0().a(3, true);
            }
        }
    }

    public String f() {
        return com.bytedance.sdk.openadsdk.m.b.b() ? com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_file", "extra_data", (String) null) : this.f;
    }

    public void g(String str) {
        a(str);
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            com.bytedance.sdk.openadsdk.m.i.d.b("sp_global_app_id", "app_id", str);
        }
        this.a = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a("app_id", str);
        com.bytedance.sdk.openadsdk.core.settings.n.j0().d(7);
    }

    public int h() {
        return com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_privacy", "tt_gdpr", -1);
    }

    public int i() {
        int iA = com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_privacy", "global_coppa", -99);
        this.j = iA;
        if (iA == -99) {
            this.j = m();
        }
        return this.j;
    }

    public String j() {
        return com.bytedance.sdk.openadsdk.m.b.b() ? com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_file", "keywords", (String) null) : this.e;
    }

    public String k() {
        if (TextUtils.isEmpty(this.f596b)) {
            this.f596b = a(o.a());
        }
        return this.f596b;
    }

    public Bitmap l() {
        return com.bytedance.sdk.openadsdk.m.b.b() ? com.bytedance.sdk.component.utils.d.a(com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_file", "pause_icon", (String) null)) : this.i;
    }

    public int m() {
        return com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_privacy", "sdk_coppa", -1);
    }

    public int n() {
        return com.bytedance.sdk.openadsdk.m.b.b() ? com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_file", "title_bar_theme", 0) : this.g;
    }

    public boolean o() {
        return com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_file", "sdk_activate_init", true);
    }

    public boolean p() {
        return q.contains(this.a);
    }

    public boolean q() {
        return "com.union_test.internationad".equals(com.bytedance.sdk.openadsdk.utils.a0.i());
    }

    public boolean r() {
        return com.bytedance.sdk.openadsdk.m.b.b() ? com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_file", "is_paid", false) : this.d;
    }

    public boolean s() {
        ShortcutManager shortcutManager;
        if (this.k == null) {
            this.k = Boolean.FALSE;
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    Context contextA = o.a();
                    if (contextA != null && (shortcutManager = (ShortcutManager) contextA.getSystemService(ShortcutManager.class)) != null) {
                        this.k = Boolean.valueOf(shortcutManager.isRequestPinShortcutSupported());
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return this.k.booleanValue();
    }

    public boolean u() {
        return com.bytedance.sdk.openadsdk.m.b.b() ? com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_file", "is_use_texture", false) : this.h;
    }

    public void v() {
        if (this.n == null || this.n.size() != 0) {
            return;
        }
        this.n = null;
    }

    private h() {
        this.g = 0;
        this.h = false;
        this.i = null;
        this.j = 0;
        this.n = null;
        try {
            b.a.a.a.a.a.a.i.a.a(o.a());
        } catch (Throwable unused) {
        }
    }

    public static h a() {
        return b.a;
    }

    public void h(String str) {
        b(str);
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            com.bytedance.sdk.openadsdk.m.i.d.b("sp_global_file", "extra_data", str);
        }
        this.f = str;
    }

    public void a(boolean z) {
        com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_file", "sdk_activate_init", Boolean.valueOf(z));
    }

    private String a(Context context) {
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    private static void b(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 1000) {
            return;
        }
        k kVar = o;
        if (kVar != null) {
            kVar.fail(4000, "Data is very long, the longest is 1000");
        }
        com.bytedance.sdk.component.utils.m.b("TTAD.GlobalInfo", "Data is very long, the longest is 1000");
    }

    public void c(int i) {
        if (i != 0 && i != 1) {
            i = -99;
        }
        com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_privacy", "global_coppa", Integer.valueOf(i));
        this.j = i;
    }

    public int e() {
        return com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_privacy", "global_ccpa", -1);
    }

    public void f(int i) {
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_file", "title_bar_theme", Integer.valueOf(i));
        }
        this.g = i;
    }

    public static boolean e(String str) {
        return (str.contains("sp_full_screen_video") || str.contains("sp_reward_video") || str.contains("tt_openad")) ? false : true;
    }

    public void d(int i) {
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_icon_id", "icon_id", Integer.valueOf(i));
        }
        this.c = i;
    }

    private static void a(String str) {
        k kVar;
        if (TextUtils.isEmpty(str) && (kVar = o) != null) {
            kVar.fail(4000, "appid cannot be empty");
        }
        com.bytedance.sdk.component.utils.m.b("TTAD.GlobalInfo", "appid cannot be empty");
    }

    public void c(boolean z) {
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_file", "is_use_texture", Boolean.valueOf(z));
        }
        this.h = z;
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            TTDislikeListView.a(6, str);
        } else if (this.n != null) {
            this.n.remove(str);
        }
    }

    private static JSONObject d(String str) {
        String strA = com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_file", str, (String) null);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        try {
            return new JSONObject(strA);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.m.b("TTAD.GlobalInfo", e.getMessage());
            return null;
        }
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", str2);
            jSONObject.put("time", System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.m.i.d.b("sp_global_file", str, jSONObject.toString());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.m.b("TTAD.GlobalInfo", e.getMessage());
        }
    }

    public String b() {
        if (!TextUtils.isEmpty(this.l)) {
            return this.l;
        }
        String strA = com.bytedance.sdk.openadsdk.utils.f.a();
        this.l = strA;
        if (!TextUtils.isEmpty(strA)) {
            return this.l;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        com.bytedance.sdk.openadsdk.utils.f.a(strValueOf);
        this.l = strValueOf;
        return strValueOf;
    }

    public com.bytedance.sdk.openadsdk.core.bannerexpress.a.h c(String str) {
        if (this.n == null || str == null) {
            return null;
        }
        return this.n.get(str);
    }

    public com.bytedance.sdk.openadsdk.core.j0.b.c g() {
        if (this.m == null) {
            this.m = new com.bytedance.sdk.openadsdk.core.j0.b.c(10, 8);
        }
        return this.m;
    }

    public static String a(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObjectD = d(str);
            if (jSONObjectD == null) {
                return null;
            }
            if (System.currentTimeMillis() - jSONObjectD.getLong("time") <= j) {
                return jSONObjectD.getString("value");
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.m.b("TTAD.GlobalInfo", e.getMessage());
        }
        return null;
    }

    public void a(int i) {
        if (i == 0 || i == 1 || i == -1) {
            int iE = e();
            com.bytedance.sdk.openadsdk.m.i.d.a("sp_global_privacy", "global_ccpa", Integer.valueOf(i));
            if (iE != i) {
                com.bytedance.sdk.openadsdk.core.settings.n.j0().a(5, true);
            }
        }
    }

    public void a(String str, com.bytedance.sdk.openadsdk.core.bannerexpress.a.h hVar) {
        if (TextUtils.isEmpty(str) || hVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            TTDislikeListView.a(6, str, hVar);
            return;
        }
        if (this.n == null) {
            synchronized (h.class) {
                if (this.n == null) {
                    this.n = new ConcurrentHashMap<>();
                }
            }
        }
        this.n.put(str, hVar);
    }
}
