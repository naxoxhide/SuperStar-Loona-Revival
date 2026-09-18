package b.c.a.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.d.l;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: GPDownLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements c {
    protected static Boolean h;
    private WeakReference<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.f0.c f257b;
    protected q c;
    protected String d;
    protected boolean e = false;
    protected final AtomicBoolean f = new AtomicBoolean(false);
    protected int g;

    public b(Context context, q qVar, String str) {
        this.a = new WeakReference<>(context);
        this.c = qVar;
        this.f257b = qVar.h();
        this.d = str;
        m.c("GPDownLoader", str, "====tag===" + str);
        if (o.a() == null) {
            o.a(context);
        }
    }

    @Override // b.c.a.a.a.a.c
    public void a(int i) {
        this.g = i;
    }

    @Override // b.c.a.a.a.a.c
    public void a(boolean z) {
    }

    @Override // b.c.a.a.a.a.c
    public void b() {
        if (e() == null) {
            return;
        }
        if (d()) {
            this.f.set(true);
            this.c.d(true);
            return;
        }
        if (a()) {
            this.c.d(true);
            return;
        }
        if (c()) {
            this.c.d(true);
        } else {
            if (this.c.h() != null || this.c.H0() == null) {
                return;
            }
            z.b(e(), this.c.H0(), this.c, a0.f(this.d), this.d, true);
            this.c.d(true);
        }
    }

    @Override // b.c.a.a.a.a.c
    public boolean c() {
        this.f.set(true);
        return this.f257b != null && a(e(), this.f257b.d(), this.f257b.e());
    }

    public boolean d() {
        com.bytedance.sdk.openadsdk.core.d.a(this.c, this.d, 1, null);
        if (this.c.z() == null) {
            com.bytedance.sdk.openadsdk.core.d.a(this.c, this.d, -1, null);
            return false;
        }
        String strA = this.c.z().a();
        if (TextUtils.isEmpty(strA)) {
            q qVar = this.c;
            com.bytedance.sdk.openadsdk.core.d.a(qVar, this.d, -2, qVar.z().d());
        } else {
            Uri uri = Uri.parse(strA);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            if (a0.b(e(), intent)) {
                if (!(e() instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                try {
                    HashMap map = new HashMap();
                    a(map);
                    com.bytedance.sdk.openadsdk.d.c.a(this.c, this.d, "open_url_app", map);
                    e().startActivity(intent);
                    l.a().a(map).a(this.c, this.d);
                    return true;
                } catch (Throwable th) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("exception", th.getMessage());
                        jSONObject.put(SDKConstants.PARAM_INTENT, intent.toString());
                    } catch (Exception unused) {
                    }
                    com.bytedance.sdk.openadsdk.core.d.a(this.c, this.d, -4, jSONObject);
                    ApmHelper.reportCustomError("startActivityError1", SDKConstants.PARAM_DEEP_LINK, th);
                }
            } else {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(SDKConstants.PARAM_INTENT, intent.toString());
                } catch (Exception unused2) {
                }
                com.bytedance.sdk.openadsdk.core.d.a(this.c, this.d, -3, jSONObject2);
            }
        }
        if (this.e && !this.f.get()) {
            return false;
        }
        this.e = true;
        HashMap map2 = new HashMap();
        a(map2);
        com.bytedance.sdk.openadsdk.d.c.a(this.c, this.d, "open_fallback_url", map2);
        return false;
    }

    protected Context e() {
        WeakReference<Context> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null) ? o.a() : this.a.get();
    }

    public boolean a(Context context, String str, String str2) {
        return a(context, str, str2, this.d, this.c);
    }

    public static boolean a(Context context, String str, String str2, String str3, q qVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            Boolean bool = h;
            jSONObject.put("storeOpenType", (bool == null || !bool.booleanValue()) ? "webview" : "app");
        } catch (JSONException e) {
            m.b("GPDownLoader", "gotoGooglePlayByPackageNameAndUrl json error", e);
        }
        String strReplace = (TextUtils.isEmpty(str3) || !str3.contains("_landingpage")) ? str3 : str3.replace("_landingpage", "");
        if (!TextUtils.isEmpty(str) && str.contains("play.google.com/store/apps/details?id=")) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                context.startActivity(intent);
                m.d("GPDownLoader", "Goto Google Play");
                m.d("GPDownLoader", "download_url is : ->" + str);
                com.bytedance.sdk.openadsdk.d.c.b(qVar, strReplace, "store_open", jSONObject);
                m.c("GPDownLoader", strReplace, jSONObject.toString());
                return true;
            } catch (Throwable unused) {
            }
        }
        if (context == null || str2 == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        m.d("GPDownLoader", "gotoGooglePlay :market://details?id=" + str2);
        Intent intent2 = new Intent("android.intent.action.VIEW");
        Uri uri = Uri.parse("market://details?id=" + str2);
        intent2.setData(uri);
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent2, 65536).iterator();
        while (it.hasNext()) {
            if (it.next().activityInfo.packageName.equals("com.android.vending") && context.getPackageManager().getLaunchIntentForPackage("com.android.vending") != null) {
                Intent intent3 = new Intent("android.intent.action.VIEW");
                intent3.setData(uri);
                intent3.setPackage("com.android.vending");
                if (!(context instanceof Activity)) {
                    intent3.setFlags(268435456);
                }
                context.startActivity(intent3);
                jSONObject.put("storeOpenType", "app");
                com.bytedance.sdk.openadsdk.d.c.b(qVar, strReplace, "store_open", jSONObject);
                return true;
            }
        }
        try {
            Intent intent4 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str2));
            intent4.setFlags(268435456);
            context.startActivity(intent4);
            jSONObject.put("storeOpenType", "webview");
            com.bytedance.sdk.openadsdk.d.c.b(qVar, strReplace, "store_open", jSONObject);
            return true;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public static void a(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details"));
        try {
            Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
            while (it.hasNext()) {
                if (it.next().activityInfo.packageName.equals("com.android.vending")) {
                    h = Boolean.TRUE;
                    return;
                }
            }
        } catch (Throwable unused) {
            h = Boolean.FALSE;
        }
        h = Boolean.FALSE;
    }

    private void a(Map<String, Object> map) {
        q qVar = this.c;
        if (qVar != null && qVar.G() == 0) {
            q qVar2 = this.c;
            map.put("auto_click", Boolean.valueOf((qVar2 == null || qVar2.b1()) ? false : true));
        }
        q qVar3 = this.c;
        if (qVar3 == null || qVar3.G() != 0) {
            return;
        }
        map.put("dpl_probability_jump", Boolean.valueOf(this.g >= 11));
    }

    @Override // b.c.a.a.a.a.c
    public boolean a() {
        Intent intentA;
        if (this.f257b == null) {
            return false;
        }
        q qVar = this.c;
        if (qVar != null && qVar.m0() == 0) {
            return false;
        }
        String strE = this.f257b.e();
        if (TextUtils.isEmpty(strE) || !a0.b(e(), strE) || (intentA = a0.a(e(), strE)) == null) {
            return false;
        }
        intentA.putExtra("START_ONLY_FOR_ANDROID", true);
        try {
            e().startActivity(intentA);
            HashMap map = new HashMap();
            a(map);
            com.bytedance.sdk.openadsdk.d.c.a(this.c, this.d, "click_open", map);
            return true;
        } catch (Throwable th) {
            m.b("GPDownLoader", th.getMessage());
            return false;
        }
    }
}
