package com.bytedance.sdk.openadsdk.b.o;

import android.content.Context;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.b.f;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.m.b;
import com.bytedance.sdk.openadsdk.utils.g;
import com.facebook.internal.NativeProtocol;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTAppOpenUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static File a(String str) {
        return a(o.a(), f.a(o.a()).b(), str);
    }

    public static File b(String str) {
        return new File(CacheDirFactory.getICacheDir(0).a() + File.separator + str);
    }

    public static String b() {
        return g.a();
    }

    public static File a(Context context, String str, String str2) {
        return com.bytedance.sdk.component.utils.g.a(context, b.b(), str, str2);
    }

    public static void a(File file) {
        if (file == null) {
            return;
        }
        try {
            com.bytedance.sdk.component.utils.g.f(file);
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context) {
        try {
            f.a(context).a();
        } catch (Throwable unused) {
        }
    }

    public static String a() {
        return com.bytedance.sdk.component.utils.g.a(o.a(), b.b(), f.a(o.a()).b()).getAbsolutePath();
    }

    public static void a(JSONObject jSONObject, int i) {
        try {
            String strK = h.a().k();
            int iC = h.a().c();
            JSONObject jSONObject2 = jSONObject.getJSONObject("creative");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, strK);
            jSONObject3.put("app_icon_id", "@" + iC);
            jSONObject2.put("open_app_info", jSONObject3);
            if (jSONObject2.optJSONObject("video") == null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("video_duration", o.d().y(String.valueOf(i)));
                jSONObject2.put("video", jSONObject4);
            }
        } catch (Exception e) {
            m.b("TTAppOpenUtils", e.getMessage());
        }
    }

    public static int a(q qVar, int i) {
        return i - qVar.x0();
    }
}
