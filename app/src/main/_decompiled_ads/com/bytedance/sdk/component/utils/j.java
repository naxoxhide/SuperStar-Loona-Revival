package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import java.util.Locale;

/* JADX INFO: compiled from: LanguageUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {
    private static Context a;

    private static Configuration a(Context context, String str, String str2) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLocale(new Locale(str, str2));
        }
        return configuration;
    }

    public static void b(Context context, String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        try {
            Configuration configurationA = a(context, str, str2);
            if (Build.VERSION.SDK_INT >= 17) {
                a = context.createConfigurationContext(configurationA);
            }
        } catch (Throwable th) {
            m.b(th.getMessage());
        }
        t.b(a);
    }
}
