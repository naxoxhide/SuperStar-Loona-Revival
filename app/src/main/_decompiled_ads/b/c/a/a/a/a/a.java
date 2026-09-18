package b.c.a.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.d.l;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: AndroidRGPDownLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends b {
    public a(Context context, q qVar, String str) {
        super(context, qVar, str);
    }

    @Override // b.c.a.a.a.a.b, b.c.a.a.a.a.c
    public boolean a() {
        if (this.f257b == null) {
            return false;
        }
        HashMap map = null;
        q qVar = this.c;
        if (qVar != null && qVar.G() == 0) {
            map = new HashMap();
            map.put("dpl_probability_jump", Boolean.valueOf(this.g >= 11));
        }
        return a(this.c, this.f257b.e(), e(), this.d, map);
    }

    @Override // b.c.a.a.a.a.b
    public boolean d() {
        com.bytedance.sdk.openadsdk.core.d.a(this.c, this.d, 1, null);
        if (this.c.z() != null) {
            HashMap map = new HashMap();
            q qVar = this.c;
            if (qVar != null && qVar.G() == 0) {
                map.put("dpl_probability_jump", Boolean.valueOf(this.g >= 11));
            }
            if (a(this.c.z().a(), e(), this.d, this.c, map)) {
                return true;
            }
            if (!this.e || this.f.get()) {
                this.e = true;
                a(this.c, map);
                com.bytedance.sdk.openadsdk.d.c.a(this.c, this.d, "open_fallback_url", map);
            }
        } else {
            com.bytedance.sdk.openadsdk.core.d.a(this.c, this.d, -1, null);
        }
        return false;
    }

    public static boolean a(q qVar, String str, Context context, String str2, Map<String, Object> map) {
        Intent intentA;
        if (qVar != null && qVar.m0() == 0) {
            return false;
        }
        try {
            if (TextUtils.isEmpty(str) || (intentA = a0.a(context, str)) == null) {
                return false;
            }
            intentA.putExtra("START_ONLY_FOR_ANDROID", true);
            if (!(context instanceof Activity)) {
                intentA.addFlags(268435456);
            }
            context.startActivity(intentA);
            if (map == null) {
                map = new HashMap<>();
            }
            a(qVar, map);
            com.bytedance.sdk.openadsdk.d.c.a(qVar, str2, "click_open", map);
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    private static void a(q qVar, Map<String, Object> map) {
        if (map == null || qVar == null || qVar.G() != 0) {
            return;
        }
        map.put("auto_click", Boolean.valueOf((qVar == null || qVar.b1()) ? false : true));
    }

    public static boolean a(String str, Context context, String str2, q qVar, Map<String, Object> map) {
        Intent intent = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                Uri uri = Uri.parse(str);
                Intent intent2 = new Intent("android.intent.action.VIEW");
                try {
                    intent2.setData(uri);
                    if (!(context instanceof Activity)) {
                        intent2.addFlags(268435456);
                    }
                    if (map == null) {
                        map = new HashMap<>();
                    }
                    a(qVar, map);
                    com.bytedance.sdk.openadsdk.d.c.a(qVar, str2, "open_url_app", map);
                    context.startActivity(intent2);
                    l.a().a(map).a(qVar, str2);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    intent = intent2;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("exception", th.getMessage());
                        if (intent != null) {
                            jSONObject.put(SDKConstants.PARAM_INTENT, intent.toString());
                        }
                    } catch (Exception unused) {
                    }
                    com.bytedance.sdk.openadsdk.core.d.a(qVar, str2, -4, jSONObject);
                    ApmHelper.reportCustomError("startActivityError", SDKConstants.PARAM_DEEP_LINK, th);
                    return false;
                }
            }
            com.bytedance.sdk.openadsdk.core.d.a(qVar, str2, -2, null);
            return false;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
