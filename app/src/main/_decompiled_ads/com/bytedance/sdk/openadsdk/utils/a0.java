package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.webkit.ProxyConfig;
import com.bytedance.sdk.component.widget.SSWebView;
import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ToolUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class a0 {
    private static final ExecutorService a = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f823b = false;
    private static final AtomicInteger c = new AtomicInteger(0);
    private static volatile String d = "";
    private static final ReentrantLock e = new ReentrantLock();
    private static String f = null;
    private static String g = null;
    private static String h = null;
    private static final HashSet<String> i = new HashSet<>(Arrays.asList("Asia/Shanghai", "Asia/Urumqi", "Asia/Chongqing", "Asia/Harbin", "Asia/Kashgar"));
    private static final HashSet<String> j;

    /* JADX INFO: compiled from: ToolUtils.java */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (TextUtils.isEmpty(a0.d)) {
                    SSWebView sSWebView = new SSWebView(com.bytedance.sdk.openadsdk.core.o.a());
                    sSWebView.setWebViewClient(new SSWebView.r0());
                    String unused = a0.d = sSWebView.getUserAgentString();
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.m.b("TTAD.ToolUtils", "", e);
            } catch (NoClassDefFoundError e2) {
                com.bytedance.sdk.component.utils.m.b("TTAD.ToolUtils", "", e2);
            }
        }
    }

    /* JADX INFO: compiled from: ToolUtils.java */
    static class b implements com.bytedance.sdk.openadsdk.l.a {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            if (a0.f823b || !com.bytedance.sdk.openadsdk.core.o.d().U()) {
                return null;
            }
            boolean unused = a0.f823b = true;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error", this.a);
            return com.bytedance.sdk.openadsdk.l.c.b.o().h("reportMultiLog").c(jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: ToolUtils.java */
    public static class c implements Callable<String> {
        private final int a;

        /* JADX INFO: compiled from: ToolUtils.java */
        class a implements Runnable {
            final /* synthetic */ String[] a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ CountDownLatch f824b;

            a(c cVar, String[] strArr, CountDownLatch countDownLatch) {
                this.a = strArr;
                this.f824b = countDownLatch;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a[0] = a0.u();
                com.bytedance.sdk.component.utils.m.a("getUA", "webview ua：" + this.a[0]);
                this.f824b.countDown();
            }
        }

        c(int i) {
            this.a = i;
        }

        private String b() {
            String property;
            Throwable th;
            try {
                property = System.getProperty("http.agent");
                if (property != null) {
                    try {
                        if (!"unKnow".equals(property)) {
                            if (com.bytedance.sdk.openadsdk.m.b.b()) {
                                com.bytedance.sdk.openadsdk.m.i.a.b("sp_multi_ua_data", "android_system_ua", property);
                            } else {
                                com.bytedance.sdk.openadsdk.core.c.a(com.bytedance.sdk.openadsdk.core.o.a()).b("android_system_ua", property);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.bytedance.sdk.component.utils.m.b("getUA", "e:" + th.getMessage());
                    }
                }
            } catch (Throwable th3) {
                property = "unKnow";
                th = th3;
            }
            return property;
        }

        private synchronized String c() {
            String[] strArr;
            strArr = new String[]{"unKnow"};
            CountDownLatch countDownLatch = new CountDownLatch(1);
            y.a(new a(this, strArr, countDownLatch));
            try {
                countDownLatch.await(2L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                com.bytedance.sdk.component.utils.m.b("TTAD.ToolUtils", e.getMessage());
            }
            return strArr[0];
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public synchronized String call() throws Exception {
            String strB;
            strB = "unKnow";
            int i = this.a;
            if (i == 1) {
                strB = c();
            } else if (i == 2) {
                strB = b();
            }
            return strB;
        }
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        j = hashSet;
        hashSet.addAll(Arrays.asList("America/Eirunepe", "America/Rio_Branco", "America/Boa_Vista", "America/Campo_Grande", "America/Cuiaba", "America/Manaus", "America/Porto_Velho", "America/Araguaina", "America/Bahia", "America/Belem", "America/Fortaleza", "America/Maceio", "America/Recife", "America/Santarem", "America/Sao_Paulo", "America/Noronha"));
    }

    public static int a(int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 4) {
            return 1;
        }
        if (i2 == 5) {
            return 4;
        }
        if (i2 != 6) {
            return i2;
        }
        return 5;
    }

    public static void a(com.bytedance.sdk.openadsdk.core.f0.q qVar, View view) {
    }

    public static String b(int i2) {
        if (i2 == 1) {
            return "embeded_ad";
        }
        if (i2 == 2) {
            return "banner_ad";
        }
        if (i2 == 3) {
            return "interaction";
        }
        if (i2 == 4) {
            return "open_ad";
        }
        if (i2 == 5) {
            return "fullscreen_interstitial_ad";
        }
        if (i2 != 7) {
            return null;
        }
        return "rewarded_video";
    }

    public static String c(int i2) {
        if (i2 == 1) {
            return "embeded_ad_landingpage";
        }
        if (i2 == 2) {
            return "banner_ad_landingpage";
        }
        if (i2 == 3) {
            return "interaction_landingpage";
        }
        if (i2 == 4) {
            return "splash_ad_landingpage";
        }
        if (i2 == 5) {
            return "fullscreen_interstitial_ad";
        }
        if (i2 != 7) {
            return null;
        }
        return "rewarded_video_landingpage";
    }

    public static String d(int i2) {
        if (i2 == 1) {
            return "banner_ad";
        }
        if (i2 == 2) {
            return "interaction";
        }
        if (i2 == 3 || i2 == 4) {
            return "open_ad";
        }
        if (i2 != 7) {
            return i2 != 8 ? "embeded_ad" : "fullscreen_interstitial_ad";
        }
        return "rewarded_video";
    }

    private static boolean d() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String e() {
        String str = "unKnow";
        com.bytedance.sdk.openadsdk.m.c.b(com.bytedance.sdk.openadsdk.core.o.a());
        try {
            String strA = com.bytedance.sdk.openadsdk.m.b.b() ? com.bytedance.sdk.openadsdk.m.i.a.a("sp_multi_ua_data", "android_system_ua", "unKnow") : com.bytedance.sdk.openadsdk.core.c.a(com.bytedance.sdk.openadsdk.core.o.a()).a("android_system_ua", "unKnow");
            if (strA != null && !"unKnow".equals(strA)) {
                return strA;
            }
            FutureTask futureTask = new FutureTask(new c(2));
            a.execute(futureTask);
            str = (String) futureTask.get(500L, TimeUnit.MILLISECONDS);
        } catch (Exception unused) {
        }
        com.bytedance.sdk.component.utils.m.b("getUA", " getAndroidSystemUA userAgent" + str);
        return str;
    }

    public static int f(String str) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return 2;
            case "rewarded_video":
                return 7;
            case "open_ad":
            case "cache_splash_ad":
                return 4;
            case "fullscreen_interstitial_ad":
                return 5;
            case "interaction":
                return 3;
            default:
                return 1;
        }
    }

    public static boolean f(int i2) {
        return i2 == 5;
    }

    public static long g(Context context) {
        return com.bytedance.sdk.openadsdk.core.c.a(context).a("total_sdcard_storage", 0L).longValue();
    }

    public static boolean g(int i2) {
        return i2 == 6;
    }

    public static String h(String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 4096);
                do {
                    try {
                        line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            com.bytedance.sdk.component.utils.m.b("TTAD.ToolUtils", th.getMessage());
                            return null;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                        }
                    }
                } while (!line.contains(str));
                if (line == null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                    try {
                        fileReader.close();
                    } catch (Exception unused4) {
                    }
                    return null;
                }
                String[] strArrSplit = line.split("\\s+");
                com.bytedance.sdk.component.utils.m.a("ToolUtils", "getTotalMemory = " + strArrSplit[1]);
                String str2 = strArrSplit[1];
                try {
                    bufferedReader.close();
                } catch (Exception unused5) {
                }
                try {
                    fileReader.close();
                } catch (Exception unused6) {
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
            bufferedReader = null;
        }
    }

    public static boolean h(int i2) {
        return i2 == 4;
    }

    public static synchronized String i() {
        Context contextA;
        if (TextUtils.isEmpty(f) && (contextA = com.bytedance.sdk.openadsdk.core.o.a()) != null) {
            try {
                f = contextA.getPackageName();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("TTAD.ToolUtils", "ToolUtils getPackageName throws exception :", th);
            }
        }
        return f;
    }

    public static String j() {
        return q.a();
    }

    public static String k(Context context) {
        return com.bytedance.sdk.openadsdk.core.c.a(context).a("total_memory", "0");
    }

    public static long l(String str) {
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String m() {
        try {
            return TimeZone.getDefault().getID();
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.m.b("TTAD.ToolUtils", e2.toString());
            return "";
        }
    }

    public static int n(Context context) {
        return com.bytedance.sdk.openadsdk.core.c.a(context).a("is_root", -1);
    }

    public static long o() {
        long blockSize;
        long blockCount;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                blockSize = statFs.getBlockSizeLong();
                blockCount = statFs.getBlockCountLong();
            } else {
                blockSize = statFs.getBlockSize();
                blockCount = statFs.getBlockCount();
            }
            return blockCount * blockSize;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String p() {
        return h("MemTotal");
    }

    public static String q() {
        try {
            ActivityManager activityManager = (ActivityManager) com.bytedance.sdk.openadsdk.core.o.a().getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long j2 = memoryInfo.totalMem;
            if (j2 > 0) {
                return String.valueOf(j2 / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static synchronized String r() {
        if (TextUtils.isEmpty(g) && com.bytedance.sdk.openadsdk.core.o.a() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.o.a().getPackageManager().getPackageInfo(i(), 0);
                g = String.valueOf(packageInfo.versionCode);
                h = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("TTAD.ToolUtils", "ToolUtils getVersionCode throws exception :", th);
            }
        }
        return g;
    }

    public static synchronized String s() {
        if (TextUtils.isEmpty(h) && com.bytedance.sdk.openadsdk.core.o.a() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.o.a().getPackageManager().getPackageInfo(i(), 0);
                g = String.valueOf(packageInfo.versionCode);
                h = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("TTAD.ToolUtils", "ToolUtils getVersionName throws exception :", th);
            }
        }
        return h;
    }

    public static String t() {
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        com.bytedance.sdk.openadsdk.m.c.b(com.bytedance.sdk.openadsdk.core.o.a());
        d = com.bytedance.sdk.openadsdk.core.h.a("sdk_local_web_ua", 86400000L);
        if (TextUtils.isEmpty(d)) {
            ReentrantLock reentrantLock = e;
            try {
                if (reentrantLock.tryLock()) {
                    try {
                        if (Build.VERSION.SDK_INT < 17) {
                            y.a(new a());
                        } else if (TextUtils.isEmpty(d)) {
                            d = WebSettings.getDefaultUserAgent(com.bytedance.sdk.openadsdk.core.o.a());
                        }
                        com.bytedance.sdk.openadsdk.core.h.a("sdk_local_web_ua", d);
                        reentrantLock.unlock();
                    } catch (Exception e2) {
                        com.bytedance.sdk.component.utils.m.b("TTAD.ToolUtils", "", e2);
                        e.unlock();
                    } catch (NoClassDefFoundError e3) {
                        com.bytedance.sdk.component.utils.m.b("TTAD.ToolUtils", "", e3);
                        e.unlock();
                    }
                }
            } catch (Throwable th) {
                e.unlock();
                throw th;
            }
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String u() {
        try {
            WebView webView = new WebView(com.bytedance.sdk.openadsdk.core.o.a());
            webView.setWebViewClient(new SSWebView.r0());
            String userAgentString = webView.getSettings().getUserAgentString();
            if (userAgentString != null && !"unKnow".equals(userAgentString)) {
                if (com.bytedance.sdk.openadsdk.m.b.b()) {
                    com.bytedance.sdk.openadsdk.m.i.a.b("sp_multi_ua_data", "webview_ua", userAgentString);
                } else {
                    com.bytedance.sdk.openadsdk.core.c.a(com.bytedance.sdk.openadsdk.core.o.a()).b("webview_ua", userAgentString);
                }
            }
            return userAgentString;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("getUA", "e:" + th.getMessage());
            return "unKnow";
        }
    }

    public static boolean v() {
        return (com.bytedance.sdk.openadsdk.core.m.a() == null || com.bytedance.sdk.openadsdk.core.m.a().b()) ? false : true;
    }

    public static boolean w() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean x() {
        return c.get() == 1;
    }

    public static boolean b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + Uri.encode(str)));
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                com.bytedance.sdk.component.utils.b.a(context, intent, null);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String d(Context context) {
        try {
            return (Build.VERSION.SDK_INT >= 24 ? context.getResources().getConfiguration().getLocales().get(0) : Locale.getDefault()).getLanguage();
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.m.b("TTAD.ToolUtils", e2.toString());
            return "";
        }
    }

    public static String f() {
        int iL = l();
        return (iL == 1 || iL == 2) ? "https://sf16-static.i18n-pglstatp.com/obj/ad-pattern-sg/renderer/package_sg.json" : "https://sf16-static.i18n-pglstatp.com/obj/ad-pattern-va/renderer/package_va.json";
    }

    public static String g() {
        return String.format("https://%s", "log.byteoversea.com/service/2/app_log_test/");
    }

    public static String j(Context context) {
        String strA = com.bytedance.sdk.openadsdk.core.c.a(context).a("total_memory", (String) null);
        if (strA == null || l(strA) <= 0) {
            strA = h("MemTotal");
            if (l(strA) <= 0) {
                strA = q();
            }
            com.bytedance.sdk.openadsdk.core.c.a(context).b("total_memory", strA);
        }
        return strA;
    }

    public static long k() {
        try {
            if (!d()) {
                return 0L;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("TTAD.ToolUtils", th.getMessage());
            return 0L;
        }
    }

    public static int l() {
        try {
            String id = TimeZone.getDefault().getID();
            if (!i.contains(id) && (id == null || !id.startsWith("Asia/"))) {
                if (id == null || !id.startsWith("Europe/")) {
                    return (id == null || !id.startsWith("America/") || j.contains(id)) ? 3 : 5;
                }
                return 4;
            }
            return 2;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("TTAD.ToolUtils", th.toString());
            return 0;
        }
    }

    public static int n() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    public static int f(Context context) {
        return a(com.bytedance.sdk.component.utils.w.a(context, 0L));
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", "OPPO");
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }

    public static Intent a(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static boolean m(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(Context context, Intent intent) {
        return a(context, intent) > 0;
    }

    private static String b(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("aid", "1371").appendQueryParameter("device_platform", "android").appendQueryParameter("version_code", r()).toString();
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.m.b("TTAD.ToolUtils", e2.getMessage());
            return str;
        }
    }

    public static String j(String str) {
        return a(str, false);
    }

    public static void d(String str) {
        if (com.bytedance.sdk.openadsdk.core.l.e()) {
            return;
        }
        com.bytedance.sdk.component.utils.m.b("You must use method '" + str + "' after initialization, please check.");
    }

    public static void k(String str) {
        com.bytedance.sdk.openadsdk.l.b.a();
        com.bytedance.sdk.openadsdk.l.b.a("reportMultiLog", false, (com.bytedance.sdk.openadsdk.l.a) new b(str));
    }

    public static long c(Context context) {
        return com.bytedance.sdk.openadsdk.core.c.a(context).a("free_internal_storage", 0L).longValue();
    }

    public static void c(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return;
        }
        com.bytedance.sdk.component.utils.m.b("You should use method '" + str + "' on the asynchronous thread,it may cause anr, please check.");
    }

    public static String b(Context context) {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            return locale.getLanguage() + "_" + locale.getCountry();
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.m.b("TTAD.ToolUtils", e2.toString());
            return "";
        }
    }

    public static long i(Context context) {
        return com.bytedance.sdk.openadsdk.core.c.a(context).a("total_internal_storage", 0L).longValue();
    }

    public static boolean i(String str) {
        try {
            return Pattern.compile("[一-龥]").matcher(str).find();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int a(Context context, Intent intent) {
        if (intent == null) {
            return 0;
        }
        try {
            return context.getPackageManager().queryIntentActivities(intent, 65536).size();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static void l(Context context) {
        try {
            AtomicInteger atomicInteger = c;
            if (atomicInteger.get() != 0) {
                return;
            }
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            boolean zIsEnabled = accessibilityManager.isEnabled();
            boolean zIsTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
            if (zIsEnabled && zIsTouchExplorationEnabled) {
                atomicInteger.set(1);
                com.bytedance.sdk.openadsdk.l.b.a().c();
            } else {
                atomicInteger.set(2);
            }
        } catch (Exception unused) {
            c.set(2);
        }
    }

    public static String a(com.bytedance.sdk.openadsdk.core.f0.q qVar) {
        if (qVar == null) {
            return null;
        }
        try {
            return d(qVar.R());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            str = com.bytedance.sdk.openadsdk.core.o.d().t();
        }
        if (TextUtils.isEmpty(str)) {
            return l() == 2 ? "https://log.sgsnssdk.com/service/2/app_log/" : "https://log-mva.isnssdk.com/service/2/app_log/";
        }
        return !str.startsWith(ProxyConfig.MATCH_HTTP) ? "https://" + str : str;
    }

    public static String a(String str, boolean z) {
        String str2;
        String strC0 = com.bytedance.sdk.openadsdk.core.o.d().c0();
        if (TextUtils.isEmpty(strC0)) {
            int iL = l();
            if (iL == 1 || iL == 2) {
                str2 = "https://pangolin16.sgsnssdk.com" + str;
            } else {
                str2 = "https://pangolin16.isnssdk.com" + str;
            }
            if (!z) {
                return x.a(str2);
            }
            return b(str2);
        }
        String strA = "https://" + strC0 + str;
        if (x.b() && !z) {
            strA = x.a(strA);
        }
        return z ? b(strA) : strA;
    }

    public static boolean b(com.bytedance.sdk.openadsdk.core.f0.q qVar) {
        if (qVar == null) {
            return true;
        }
        int iB = com.bytedance.sdk.openadsdk.core.o.d().b(qVar.S());
        int iB2 = com.bytedance.sdk.component.utils.p.b(com.bytedance.sdk.openadsdk.core.o.a());
        if (iB == 1) {
            return h(iB2);
        }
        if (iB == 2) {
            return f(iB2) || h(iB2) || g(iB2);
        }
        if (iB != 3) {
            return iB != 5 || h(iB2) || g(iB2);
        }
        return false;
    }

    public static long e(Context context) {
        int i2 = -1;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                i2 = context.getApplicationInfo().minSdkVersion;
                com.bytedance.sdk.component.utils.m.c("TTAD.ToolUtils", "minSdkVersion = ", Integer.valueOf(i2));
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("TTAD.ToolUtils", th.getMessage());
        }
        return i2;
    }

    public static boolean e(int i2) {
        if (i2 <= 0) {
            return false;
        }
        if (i2 >= 100) {
            return true;
        }
        int iNextInt = new Random(System.currentTimeMillis()).nextInt(100) + 1;
        com.bytedance.sdk.component.utils.m.a("TTAD.ToolUtils", "isMatchProbability: " + iNextInt + RemoteSettings.FORWARD_SLASH_STRING + i2);
        return iNextInt <= i2;
    }

    public static JSONObject a(boolean z, com.bytedance.sdk.openadsdk.core.f0.q qVar, long j2, long j3, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CampaignEx.JSON_KEY_CREATIVE_ID, qVar.e());
            jSONObject.put("load_time", j2);
            b.a.a.a.a.a.a.f.b bVarN0 = qVar.N0();
            if (bVarN0 != null) {
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_SIZE, bVarN0.p());
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, bVarN0.n());
            }
            if (!z) {
                jSONObject.put("error_code", j3);
                if (TextUtils.isEmpty(str)) {
                    str = "unknown";
                }
                jSONObject.put("error_message", str);
            }
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.m.b("TTAD.ToolUtils", "getVideoDownload json error", e2);
        }
        return jSONObject;
    }

    public static JSONObject a(com.bytedance.sdk.openadsdk.core.f0.q qVar, long j2, b.a.a.a.a.a.a.a aVar) {
        if (qVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CampaignEx.JSON_KEY_CREATIVE_ID, qVar.e());
            jSONObject.put("buffers_time", j2);
            b.a.a.a.a.a.a.f.b bVarN0 = qVar.N0();
            if (bVarN0 != null) {
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_SIZE, bVarN0.p());
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, bVarN0.n());
            }
            a(jSONObject, aVar);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.m.b("TTAD.ToolUtils", "getVideoAction json error", e2);
        }
        return jSONObject;
    }

    public static String h() {
        int i2 = -n();
        if (i2 >= 0) {
            return "Etc/GMT+" + i2;
        }
        return "Etc/GMT" + i2;
    }

    public static long h(Context context) {
        int i2 = -1;
        try {
            i2 = context.getApplicationInfo().targetSdkVersion;
            com.bytedance.sdk.component.utils.m.c("TTAD.ToolUtils", "targetSdkVersion = ", Integer.valueOf(i2));
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("TTAD.ToolUtils", th.getMessage());
        }
        return i2;
    }

    private static void a(JSONObject jSONObject, b.a.a.a.a.a.a.a aVar) {
        if (jSONObject.has(CampaignEx.JSON_KEY_VIDEO_RESOLUTION) || aVar == null) {
            return;
        }
        try {
            int iB = aVar.b();
            int iC = aVar.c();
            jSONObject.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, String.format(Locale.getDefault(), "%d×%d", Integer.valueOf(iB), Integer.valueOf(iC)));
        } catch (Throwable unused) {
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.core.f0.q qVar, String str) {
        if (qVar != null) {
            try {
                String strH0 = qVar.H0();
                if (TextUtils.isEmpty(strH0) && qVar.z() != null && qVar.z().c() == 1 && !TextUtils.isEmpty(qVar.z().b())) {
                    strH0 = qVar.z().b();
                }
                String str2 = strH0;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.z.b(com.bytedance.sdk.openadsdk.core.o.a(), str2, qVar, f(str), str, false);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(Context context) {
        if (context != null) {
            boolean z = !(context.getApplicationInfo().targetSdkVersion >= 30 && Build.VERSION.SDK_INT >= 30);
            com.bytedance.sdk.component.utils.m.d("TTAD.ToolUtils", "can query all package = " + z);
            return z;
        }
        throw new IllegalArgumentException("params context is null");
    }

    public static void a(String str, String str2, Context context) {
        int i2;
        if (TextUtils.isEmpty(str2) || !m(context)) {
            return;
        }
        int i3 = 3572;
        int length = str2.length();
        int i4 = 0;
        int i5 = 1;
        if (length % 3572 == 0) {
            i2 = length / 3572;
        } else {
            i2 = (length / 3572) + 1;
        }
        while (i5 <= i2) {
            if (i3 < length) {
                Log.d(str, i2 + "-" + i5 + CertificateUtil.DELIMITER + str2.substring(i4, i3));
                int i6 = i3 + 3572;
                if (i5 % 20 == 0) {
                    SystemClock.sleep(1L);
                }
                i5++;
                i4 = i3;
                i3 = i6;
            } else {
                Log.d(str, i2 + "-" + i5 + CertificateUtil.DELIMITER + str2.substring(i4));
                return;
            }
        }
    }
}
