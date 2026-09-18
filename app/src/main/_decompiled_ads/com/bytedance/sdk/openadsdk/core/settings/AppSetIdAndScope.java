package com.bytedance.sdk.openadsdk.core.settings;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;

/* JADX INFO: loaded from: classes2.dex */
public class AppSetIdAndScope {
    private static volatile String a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f670b = "";
    private static String c;
    private static int d;

    public static void c() {
        if (x.a("androidx.appcompat.app.AppCompatActivity") == null) {
            d = 2;
            return;
        }
        try {
            Context contextA = o.a();
            Class.forName("com.google.android.gms.appset.AppSet");
            AppSet.getClient(contextA).getAppSetIdInfo().addOnSuccessListener(new OnSuccessListener<AppSetIdInfo>() { // from class: com.bytedance.sdk.openadsdk.core.settings.AppSetIdAndScope.1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public void onSuccess(AppSetIdInfo appSetIdInfo) {
                    String unused = AppSetIdAndScope.a = Integer.toString(appSetIdInfo.getScope());
                    String unused2 = AppSetIdAndScope.f670b = appSetIdInfo.getId();
                    int unused3 = AppSetIdAndScope.d = 1;
                }
            });
        } catch (Throwable unused) {
            com.bytedance.sdk.component.utils.m.a("AppSetIdAndScope", "if you want to use appSetId, you must add 'com.google.android.gms:play-services-appset:x.x.x' into your build.gradle ");
            d = 2;
        }
    }

    public static String d() {
        if (TextUtils.isEmpty(c)) {
            c = o.a().getPackageManager().getInstallerPackageName(a0.i());
        }
        if (c == null) {
            c = "";
        }
        return c;
    }

    public static String b() {
        if (d != 0) {
            return a;
        }
        c();
        return a;
    }

    public static String a() {
        if (d != 0) {
            return f670b;
        }
        c();
        return f670b;
    }
}
