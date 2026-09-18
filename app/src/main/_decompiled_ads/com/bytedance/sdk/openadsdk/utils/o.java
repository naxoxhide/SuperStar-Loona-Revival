package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: OpenUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: compiled from: OpenUtils.java */
    static class a implements com.bytedance.sdk.component.utils.b.a {
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.f0.q a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f831b;
        final /* synthetic */ int c;

        a(com.bytedance.sdk.openadsdk.core.f0.q qVar, String str, int i) {
            this.a = qVar;
            this.f831b = str;
            this.c = i;
        }

        @Override // com.bytedance.sdk.component.utils.b.a
        public void a() {
            com.bytedance.sdk.openadsdk.d.c.a(this.a, this.f831b, this.c, 0, true);
        }

        @Override // com.bytedance.sdk.component.utils.b.a
        public void a(Throwable th) {
            com.bytedance.sdk.openadsdk.d.c.a(this.a, this.f831b, this.c, 6, false, th.toString());
        }
    }

    public static boolean a(Activity activity, String str, com.bytedance.sdk.openadsdk.core.f0.q qVar, String str2) {
        if (!a(activity, str)) {
            return false;
        }
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        com.bytedance.sdk.openadsdk.d.c.a(qVar, str2, "open_url_app", (Map<String, Object>) null);
        try {
            activity.startActivity(intent);
            com.bytedance.sdk.openadsdk.d.l.a().a(qVar, str2);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void b(Activity activity, String str, com.bytedance.sdk.openadsdk.core.f0.q qVar, String str2) {
        if (!a(activity, str)) {
            com.bytedance.sdk.openadsdk.d.c.a(qVar, str2, 0, 7, false);
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            com.bytedance.sdk.component.utils.b.a(activity, intent, new a(qVar, str2, a0.a(activity, intent)));
        }
    }

    public static boolean a(Activity activity, String str) {
        return a(activity) && !TextUtils.isEmpty(str);
    }

    public static boolean a(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            return !activity.isFinishing();
        }
        return false;
    }
}
