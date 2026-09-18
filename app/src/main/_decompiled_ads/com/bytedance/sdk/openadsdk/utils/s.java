package com.bytedance.sdk.openadsdk.utils;

import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SimUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class s {
    private static String a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f833b = null;
    private static String c = null;
    private static volatile boolean d = true;

    /* JADX INFO: compiled from: SimUtils.java */
    public static class a extends b.b.a.a.k.g {
        public static AtomicBoolean c = new AtomicBoolean(false);
        private static AtomicLong d = new AtomicLong(0);

        public a(String str, int i) {
            super(str, i);
        }

        public static void a() {
            if (c.get()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - d.get() < 600000) {
                return;
            }
            d.set(jCurrentTimeMillis);
            y.c(new a("UpdateSimStatusTask", 5));
        }

        @Override // java.lang.Runnable
        public void run() {
            c.set(true);
            s.e();
            c.set(false);
        }
    }

    public static String b() {
        a.a();
        return a;
    }

    public static String c() {
        try {
            a.a();
            if (!d) {
                com.bytedance.sdk.component.utils.m.b("MCC", "getMCC" + (d ? "Have SIM card" : "No SIM card, MCC returns null"));
                return null;
            }
            Configuration configuration = com.bytedance.sdk.openadsdk.core.o.a().getResources().getConfiguration();
            int i = configuration.mcc;
            String strValueOf = i != 0 ? String.valueOf(i) : f833b;
            com.bytedance.sdk.component.utils.m.b("MCC", "config=" + configuration.mcc + ",sMCC=" + f833b);
            return strValueOf;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("SimUtils", th.getMessage());
            return null;
        }
    }

    public static String d() {
        a.a();
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
        String simOperatorName;
        String simOperator;
        String strSubstring;
        if (com.bytedance.sdk.openadsdk.core.o.a() == null) {
            return;
        }
        d = true;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) com.bytedance.sdk.openadsdk.core.o.a().getSystemService("phone");
            try {
                int simState = telephonyManager.getSimState();
                if (simState == 0 || simState == 1) {
                    d = false;
                }
                com.bytedance.sdk.component.utils.m.b("MCC", d ? "Have SIM card" : "No SIM card");
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("SimUtils", th.getMessage());
            }
            String str = null;
            try {
                simOperatorName = telephonyManager.getSimOperatorName();
            } catch (Throwable unused) {
                simOperatorName = null;
            }
            try {
                simOperator = telephonyManager.getNetworkOperator();
            } catch (Throwable unused2) {
                simOperator = null;
            }
            if (simOperator == null || simOperator.length() < 5) {
                try {
                    simOperator = telephonyManager.getSimOperator();
                } catch (Throwable unused3) {
                }
            }
            if (TextUtils.isEmpty(simOperator) || simOperator.length() <= 4) {
                strSubstring = null;
            } else {
                String strSubstring2 = simOperator.substring(0, 3);
                strSubstring = simOperator.substring(3);
                str = strSubstring2;
            }
            if (!TextUtils.isEmpty(simOperatorName)) {
                a = simOperatorName;
            }
            if (!TextUtils.isEmpty(str)) {
                f833b = str;
            }
            if (TextUtils.isEmpty(strSubstring)) {
                return;
            }
            c = strSubstring;
        } catch (Throwable unused4) {
        }
    }
}
