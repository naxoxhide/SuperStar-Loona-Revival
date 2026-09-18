package com.mbridge.msdk.foundation.tools;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TapjoyConstants;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: compiled from: SameDiTool.java */
/* JADX INFO: loaded from: classes4.dex */
public final class w extends g {
    private static int a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f2229b = -1;
    private static volatile int c = -1;
    private static String d = "";
    private static String e = "";
    private static String f = "";
    private static String g = "";
    private static int h = 0;
    private static String i = "";
    private static String j = "";
    private static int k = -1;
    private static String l = "";
    private static int m = 0;
    private static String n = "";
    private static String o = null;
    private static int p = 0;
    private static int q = -1;
    private static int r = -1;
    private static Object s = null;
    private static int t = 0;
    private static int u = 0;
    private static int v = -1;
    private static String w = "";
    private static String x = "";
    private static String y = "";
    private static int z;

    public static int c(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 3;
            case 13:
            case 18:
            case 19:
                return 4;
            case 20:
                return 5;
            default:
                return 0;
        }
    }

    private static String w(Context context) {
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                if (TextUtils.isEmpty(y)) {
                    y = ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
                }
            } else {
                y = "";
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            y = "";
        }
        return y;
    }

    public static String d(Context context) {
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                if (TextUtils.isEmpty(w)) {
                    if (context == null) {
                        w = "";
                        return "";
                    }
                    String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
                    if (af.b(simOperator)) {
                        w = simOperator.substring(0, Math.min(3, simOperator.length()));
                    }
                }
            } else {
                w = "";
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            w = "";
        }
        return w;
    }

    public static String e(Context context) {
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                if (TextUtils.isEmpty(x)) {
                    if (context == null) {
                        x = "";
                        return w;
                    }
                    String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
                    if (af.b(simOperator)) {
                        x = simOperator.substring(Math.min(3, simOperator.length()));
                    }
                }
            } else {
                x = "";
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            x = "";
        }
        return x;
    }

    public static int f(Context context) {
        if (q == -1) {
            q = af.c(context, "com.tencent.mm") ? 1 : 0;
        }
        return q;
    }

    public static int g() {
        if (r == -1) {
            r = af.d() ? 1 : 0;
        }
        return r;
    }

    public static Object b(String str) {
        if (s == null) {
            s = af.e(str);
        }
        return s;
    }

    public static int c(String str) {
        if (t == 0) {
            t = af.f(str);
        }
        return t;
    }

    public static int h() {
        if (u == 0) {
            u = af.e();
        }
        return u;
    }

    public static String i() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.MODEL;
    }

    public static String j() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.MANUFACTURER + " " + Build.MODEL;
    }

    public static String k() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.BRAND;
    }

    public static String g(Context context) {
        Locale locale;
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        if (TextUtils.isEmpty(i)) {
            if (context == null) {
                return "en-US";
            }
            try {
                if (context.getResources() == null || context.getResources().getConfiguration() == null || (locale = context.getResources().getConfiguration().locale) == null) {
                    return "en-US";
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    i = locale.toLanguageTag();
                } else {
                    i = locale.getLanguage() + "-" + locale.getCountry();
                }
                return i;
            } catch (Throwable th) {
                aa.a("SameDiTool", th.getMessage());
                i = "en-US";
            }
        }
        return i;
    }

    public static int h(Context context) {
        Configuration configuration;
        if (context == null || context.getResources() == null || (configuration = context.getResources().getConfiguration()) == null) {
            return 1;
        }
        int i2 = configuration.orientation;
        if (i2 == 2) {
            return 2;
        }
        if (i2 == 1) {
        }
        return 1;
    }

    public static int i(Context context) {
        if (context == null) {
            return h;
        }
        int i2 = h;
        if (i2 != 0) {
            return i2;
        }
        try {
            int i3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            h = i3;
            return i3;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static String j(Context context) {
        if (context == null) {
            return g;
        }
        try {
            if (TextUtils.isEmpty(g)) {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                g = str;
                return str;
            }
            return g;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int k(Context context) {
        if (context == null) {
            return m;
        }
        if (m == 0) {
            try {
                m = context.getApplicationInfo().targetSdkVersion;
            } catch (Exception e2) {
                aa.d("SameDiTool", e2.getMessage());
            }
        }
        return m;
    }

    public static int l(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            HashMap mapN = n(context);
            return mapN.get("width") == null ? displayMetrics.widthPixels : ((Integer) mapN.get("width")).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int m(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            HashMap mapN = n(context);
            return mapN.get("height") == null ? displayMetrics.heightPixels : ((Integer) mapN.get("height")).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static HashMap n(Context context) {
        HashMap map = new HashMap();
        if (context == null) {
            return map;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
            } else {
                defaultDisplay.getMetrics(displayMetrics);
            }
            map.put("height", Integer.valueOf(displayMetrics.heightPixels));
            map.put("width", Integer.valueOf(displayMetrics.widthPixels));
        } catch (Exception e2) {
            aa.b("SameDiTool", e2.getMessage(), e2);
        }
        return map;
    }

    public static String o(Context context) {
        if (context == null) {
            return f;
        }
        try {
            if (TextUtils.isEmpty(f)) {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                f = str;
                return str;
            }
            return f;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void p(final Context context) {
        if (context == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                a(context);
            } else {
                new Handler(context.getMainLooper()).post(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.w.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.a(context);
                    }
                });
            }
        } catch (Exception e2) {
            aa.b("SameDiTool", "", e2);
        }
    }

    public static String q(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return null;
        }
        if (TextUtils.isEmpty(d)) {
            try {
                d = ai.b(context, "mbridge_ua", "").toString();
            } catch (Throwable th) {
                aa.b("SameDiTool", th.getMessage(), th);
            }
        }
        try {
            if ((Looper.myLooper() == Looper.getMainLooper()) && !MBridgeConstans.DNT_GUA_ON_UI) {
                if (TextUtils.isEmpty(d)) {
                    try {
                        if (Build.VERSION.SDK_INT >= 17) {
                            d = WebSettings.getDefaultUserAgent(context);
                        }
                    } catch (Throwable unused) {
                    }
                    if (TextUtils.isEmpty(d)) {
                        try {
                            Constructor declaredConstructor = WebSettings.class.getDeclaredConstructor(Context.class, WebView.class);
                            declaredConstructor.setAccessible(true);
                            d = ((WebSettings) declaredConstructor.newInstance(context, null)).getUserAgentString();
                            declaredConstructor.setAccessible(false);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        if (TextUtils.isEmpty(d)) {
                            try {
                                d = new WebView(context).getSettings().getUserAgentString();
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                        if (TextUtils.isEmpty(d)) {
                            B();
                        }
                    }
                } else {
                    x(context);
                }
            } else {
                if (TextUtils.isEmpty(d)) {
                    B();
                }
                x(context);
            }
        } catch (Throwable th4) {
            aa.b("SameDiTool", th4.getMessage(), th4);
        }
        y(context);
        return d;
    }

    private static void x(final Context context) {
        try {
            new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.w.2
                @Override // java.lang.Runnable
                public final void run() {
                    String defaultUserAgent = null;
                    try {
                        if (Build.VERSION.SDK_INT >= 17) {
                            defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                        }
                    } catch (Throwable unused) {
                    }
                    try {
                        if (TextUtils.isEmpty(defaultUserAgent) || defaultUserAgent.equals(w.d)) {
                            return;
                        }
                        String unused2 = w.d = defaultUserAgent;
                        w.y(context);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }).start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y(Context context) {
        try {
            ai.a(context, "mbridge_ua", d);
        } catch (Throwable th) {
            aa.b("SameDiTool", th.getMessage(), th);
        }
    }

    public static String l() {
        if (TextUtils.isEmpty(d)) {
            q(com.mbridge.msdk.foundation.controller.b.d().g());
        }
        return d;
    }

    private static void B() {
        String str = Build.VERSION.RELEASE;
        String strI = i();
        String str2 = Build.DISPLAY;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(strI)) {
            StringBuilder sbAppend = new StringBuilder().append("Mozilla/5.0 (Linux; Android ").append(str).append("; ").append(strI).append(" Build/");
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            d = sbAppend.append(str2).append(") AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19").toString();
            return;
        }
        d = "Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";
    }

    public static int r(Context context) {
        try {
            final Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                return c;
            }
            if (contextG == null) {
                return c;
            }
            if (c == -1) {
                c = 0;
                return c;
            }
            try {
                Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.tools.w.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            ConnectivityManager connectivityManager = (ConnectivityManager) contextG.getSystemService("connectivity");
                            if (connectivityManager != null && com.mbridge.msdk.foundation.same.a.c) {
                                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                                if (activeNetworkInfo == null) {
                                    int unused = w.c = 0;
                                    return;
                                }
                                if (activeNetworkInfo.getType() == 1) {
                                    int unused2 = w.c = 9;
                                    return;
                                }
                                TelephonyManager telephonyManager = (TelephonyManager) contextG.getSystemService("phone");
                                if (telephonyManager == null) {
                                    int unused3 = w.c = 0;
                                } else {
                                    int unused4 = w.c = w.c(telephonyManager.getNetworkType());
                                }
                            }
                        } catch (Exception e2) {
                            aa.b("SameDiTool", e2.getMessage(), e2);
                            int unused5 = w.c = 0;
                        }
                    }
                };
                if (com.mbridge.msdk.foundation.same.f.b.c().getActiveCount() < 1) {
                    com.mbridge.msdk.foundation.same.f.b.c().execute(runnable);
                }
            } catch (Throwable th) {
                aa.d("SameDiTool", th.getMessage());
            }
            return c;
        } catch (Exception e2) {
            aa.b("SameDiTool", e2.getMessage(), e2);
            c = 0;
            return c;
        }
    }

    public static String a(Context context, int i2) {
        TelephonyManager telephonyManager;
        if (i2 == 0 || i2 == 9) {
            return "";
        }
        try {
            return (!com.mbridge.msdk.foundation.same.a.c || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) ? "" : String.valueOf(telephonyManager.getNetworkType());
        } catch (Throwable th) {
            aa.b("SameDiTool", th.getMessage(), th);
            return "";
        }
    }

    public static String m() {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_OTHER)) {
                return "";
            }
            if (TextUtils.isEmpty(j)) {
                new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.w.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            String unused = w.j = TimeZone.getDefault().getDisplayName(false, 0, Locale.ENGLISH);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }).start();
                return j;
            }
        } catch (Throwable th) {
            aa.b("SameDiTool", th.getMessage(), th);
        }
        return j;
    }

    public static String n() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        if (TextUtils.isEmpty(e)) {
            e = o() + "";
        }
        return e;
    }

    public static int o() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int p() {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return Build.VERSION.SDK_INT;
        }
        return -1;
    }

    public static String a(String str, Context context) {
        try {
            if (!TextUtils.isEmpty(l)) {
                return l;
            }
            if (!TextUtils.isEmpty(str) && context != null) {
                l = context.getPackageManager().getInstallerPackageName(str);
                aa.a("SameDiTool", "PKGSource:" + l);
            }
            return l;
        } catch (Exception e2) {
            aa.b("SameDiTool", e2.getMessage(), e2);
        }
    }

    public static boolean s(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static String q() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.MANUFACTURER;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.BufferedReader] */
    public static String r() {
        FileReader fileReader;
        Throwable th;
        Exception e2;
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        if (p > 0) {
            return p + "GB";
        }
        ?? bufferedReader = "/proc/meminfo";
        p = 0;
        try {
            try {
                try {
                    fileReader = new FileReader("/proc/meminfo");
                    try {
                        bufferedReader = new BufferedReader(fileReader, 8192);
                        try {
                            String str = bufferedReader.readLine().split("\\s+")[1];
                            bufferedReader.close();
                            if (str != null) {
                                p = (int) Math.ceil(new Float(Float.valueOf(str).floatValue() / 1048576.0f).doubleValue());
                            }
                            try {
                                fileReader.close();
                            } catch (IOException unused) {
                            }
                            bufferedReader.close();
                        } catch (Exception e3) {
                            e2 = e3;
                            aa.b("SameDiTool", e2.getMessage(), e2);
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException unused2) {
                                }
                            }
                            if (bufferedReader != 0) {
                                bufferedReader.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            aa.b("SameDiTool", th.getMessage(), th);
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException unused3) {
                                }
                            }
                            if (bufferedReader != 0) {
                                bufferedReader.close();
                            }
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                        bufferedReader = 0;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = 0;
                    }
                } catch (Exception e5) {
                    fileReader = null;
                    e2 = e5;
                    bufferedReader = 0;
                } catch (Throwable th4) {
                    fileReader = null;
                    th = th4;
                    bufferedReader = 0;
                }
                return p + "GB";
            } catch (Throwable th5) {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException unused4) {
                    }
                }
                if (bufferedReader == 0) {
                    throw th5;
                }
                try {
                    bufferedReader.close();
                    throw th5;
                } catch (IOException e6) {
                    e6.printStackTrace();
                    throw th5;
                }
            }
        } catch (IOException e7) {
            e7.printStackTrace();
        }
    }

    public static String t(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return "";
        }
        try {
            return Settings.System.getString(context.getContentResolver(), "time_12_24");
        } catch (Exception e2) {
            aa.b("SameDiTool", e2.getMessage(), e2);
            return "";
        } catch (Throwable th) {
            aa.b("SameDiTool", th.getMessage(), th);
            return "";
        }
    }

    public static String u(Context context) {
        FileReader fileReader;
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return "";
        }
        if (!TextUtils.isEmpty(o)) {
            return o;
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    fileReader = new FileReader("/proc/meminfo");
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(fileReader, 8192);
                        try {
                            String fileSize = Formatter.formatFileSize(context, Long.valueOf(bufferedReader2.readLine().split("\\s+")[1]).longValue() * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
                            o = fileSize;
                            try {
                                bufferedReader2.close();
                            } catch (IOException e2) {
                                aa.b("SameDiTool", e2.getMessage(), e2);
                            }
                            try {
                                fileReader.close();
                            } catch (IOException e3) {
                                aa.b("SameDiTool", e3.getMessage(), e3);
                            }
                            return fileSize;
                        } catch (IOException e4) {
                            e = e4;
                            bufferedReader = bufferedReader2;
                            aa.b("SameDiTool", e.getMessage(), e);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e5) {
                                    aa.b("SameDiTool", e5.getMessage(), e5);
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            return "";
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            aa.b("SameDiTool", th.getMessage(), th);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e6) {
                                    aa.b("SameDiTool", e6.getMessage(), e6);
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            return "";
                        }
                    } catch (IOException e7) {
                        e = e7;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e8) {
                    e = e8;
                    fileReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileReader = null;
                }
            } catch (IOException e9) {
                aa.b("SameDiTool", e9.getMessage(), e9);
                return "";
            }
        } catch (Throwable th4) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e10) {
                    aa.b("SameDiTool", e10.getMessage(), e10);
                }
            }
            if (fileReader == null) {
                throw th4;
            }
            try {
                fileReader.close();
                throw th4;
            } catch (IOException e11) {
                aa.b("SameDiTool", e11.getMessage(), e11);
                throw th4;
            }
        }
    }

    public static String s() {
        String strA = "";
        try {
            Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
            long jA = v.a();
            long jC = C();
            String strW = w(contextG);
            String str = "app_tki_" + jA + "_" + jC + "_" + strW;
            String str2 = (String) ai.b(contextG, str, "");
            try {
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("1", strW);
                    jSONObject.put("2", String.valueOf(jC));
                    jSONObject.put("3", String.valueOf(jA));
                    jSONObject.put("4", "");
                    jSONObject.put(CampaignEx.CLICKMODE_ON, "");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                strA = a.a(jSONObject.toString());
                ai.a(contextG, str, strA);
            } catch (Exception e3) {
                e = e3;
                strA = str2;
                e.printStackTrace();
            }
        } catch (Exception e4) {
            e = e4;
        }
        return strA;
    }

    public static int t() {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                return 0;
            }
            Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
            long j2 = 0;
            long jLongValue = ((Long) ai.b(contextG, "FreeRamSize", 0L)).longValue();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - jLongValue > TapjoyConstants.SESSION_ID_INACTIVITY_TIME || f2229b == -1) {
                Context contextG2 = com.mbridge.msdk.foundation.controller.b.d().g();
                if (contextG2 != null) {
                    ActivityManager activityManager = (ActivityManager) contextG2.getSystemService("activity");
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    j2 = memoryInfo.availMem;
                }
                f2229b = Long.valueOf((j2 / 1000) / 1000).intValue();
                ai.a(contextG, "FreeRamSize", Long.valueOf(jCurrentTimeMillis));
            }
        } catch (Throwable th) {
            aa.b("SameDiTool", th.getMessage(), th);
        }
        return f2229b;
    }

    private static long C() {
        Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
        if (contextG == null) {
            return 0L;
        }
        ActivityManager activityManager = (ActivityManager) contextG.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        if (Build.VERSION.SDK_INT >= 16) {
            return memoryInfo.totalMem;
        }
        return 0L;
    }

    public static String u() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
        }
        return "";
    }

    public static int v() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return 0;
        }
        if (a < 1) {
            try {
                Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
                long jLongValue = ((Long) ai.b(contextG, "TotalRamSize", 0L)).longValue();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - jLongValue > TapjoyConstants.SESSION_ID_INACTIVITY_TIME || a == -1) {
                    a = Long.valueOf((C() / 1000) / 1000).intValue();
                    ai.a(contextG, "TotalRamSize", Long.valueOf(jCurrentTimeMillis));
                }
            } catch (Throwable th) {
                aa.b("SameDiTool", th.getMessage(), th);
            }
        }
        return a;
    }

    public static int w() {
        return k;
    }

    private static String D() {
        if (!TextUtils.isEmpty(n)) {
            return n;
        }
        JSONObject jSONObject = new JSONObject();
        String str = null;
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            str = (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable th) {
            aa.d("SameDiTool", th.getMessage());
        }
        try {
            if (!TextUtils.isEmpty(str) && str.equals("harmony")) {
                jSONObject.put("osType", str);
                try {
                    Class<?> cls2 = Class.forName("ohos.system.version.SystemVersion");
                    jSONObject.put("version", (String) cls2.getMethod(MobileAdsBridge.versionMethodName, new Class[0]).invoke(cls2, new Object[0]));
                } catch (Throwable th2) {
                    aa.d("SameDiTool", th2.getMessage());
                }
                try {
                    jSONObject.put("pure_state", Settings.Secure.getInt(com.mbridge.msdk.foundation.controller.b.d().g().getContentResolver(), "pure_mode_state", -1));
                } catch (Throwable th3) {
                    aa.d("SameDiTool", th3.getMessage());
                }
                String string = jSONObject.toString();
                if (!TextUtils.isEmpty(string)) {
                    string = u.a(string);
                }
                n = string;
            } else {
                n = "android";
            }
        } catch (Throwable th4) {
            aa.d("SameDiTool", th4.getMessage());
        }
        return n;
    }

    public static void d(int i2) {
        v = i2;
    }

    public static int x() {
        return v;
    }

    public static void z() {
        try {
            Object objB = ai.b(com.mbridge.msdk.foundation.controller.b.d().g(), MBridgeConstans.SP_GA_ID, "");
            Object objB2 = ai.b(com.mbridge.msdk.foundation.controller.b.d().g(), MBridgeConstans.SP_GA_ID_LIMIT, 0);
            if (objB instanceof String) {
                String str = (String) objB;
                if (!TextUtils.isEmpty(str)) {
                    a(str);
                }
                if (objB2 instanceof Integer) {
                    a(((Integer) objB2).intValue());
                }
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                aa.d("SameDiTool", e2.getMessage());
            }
        }
    }

    public static void c(Context context) {
        try {
            g.b(context);
            n();
            o(context);
            j(context);
            i(context);
            h(context);
            i();
            k();
            g(context);
            m();
            com.mbridge.msdk.foundation.same.a.d = false;
            com.mbridge.msdk.foundation.same.a.c = af.a("android.permission.ACCESS_NETWORK_STATE", context);
            k(context);
            D();
            d();
        } catch (Throwable th) {
            aa.d("SameDiTool", th.getMessage());
        }
    }

    public static int y() {
        try {
            if (!ac.a.a.a("v_a_d_p", false)) {
                return 0;
            }
            if (af.h()) {
                z = 1;
            } else if (af.i()) {
                z = 2;
            } else {
                z = 0;
            }
        } catch (Exception e2) {
            z = 0;
            aa.d("SameDiTool", e2.getMessage());
        }
        return z;
    }
}
