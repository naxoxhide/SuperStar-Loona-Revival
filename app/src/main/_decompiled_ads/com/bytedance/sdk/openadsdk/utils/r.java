package com.bytedance.sdk.openadsdk.utils;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: RomUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class r {
    private static final CharSequence a = "amigo";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CharSequence f832b = "funtouch";
    private static String c;
    public static boolean d;
    public static boolean e;
    private static int f;
    private static final HashMap<String, String> g;

    /* JADX INFO: compiled from: RomUtils.java */
    static class a extends b.b.a.a.k.g {
        final /* synthetic */ b.b.a.a.k.f c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, b.b.a.a.k.f fVar) {
            super(str);
            this.c = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.run();
        }
    }

    /* JADX INFO: compiled from: RomUtils.java */
    public static class b implements Callable<String> {
        private String a;

        public b(String str) {
            this.a = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() throws Exception {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strB = r.b(this.a);
            com.bytedance.sdk.component.utils.m.a("RomUtils", "property:" + strB + ",getSystemProperty use time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
            if (strB != null) {
                r.g.put(this.a, strB);
            }
            if (!TextUtils.isEmpty(strB)) {
                try {
                    com.bytedance.sdk.component.utils.m.f("RomUtils", "SPMultiHelper-getPropertyFromSPMultiHelper:" + strB);
                    com.bytedance.sdk.openadsdk.m.i.d.b("rom_info", "rom_property_info", strB);
                } catch (Throwable unused) {
                }
            }
            return strB;
        }
    }

    static {
        new AtomicInteger(0);
        d = false;
        e = false;
        f = Integer.MAX_VALUE;
        g = new HashMap<>();
    }

    private static String b() {
        if (v()) {
            return n();
        }
        if (w()) {
            return k();
        }
        if (s()) {
            return i();
        }
        if (q()) {
            return e();
        }
        String strF = f();
        if (!TextUtils.isEmpty(strF)) {
            return strF;
        }
        if (t()) {
            return j();
        }
        if (p()) {
            return d();
        }
        if (o()) {
            return c();
        }
        String strG = g();
        return !TextUtils.isEmpty(strG) ? strG : Build.DISPLAY;
    }

    public static String c() {
        return c("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static String d() {
        return Build.DISPLAY + "_" + c("ro.gn.sv.version");
    }

    public static String e() {
        if (!q()) {
            return "";
        }
        return "coloros_" + c(a0.g("ro.build.version.kllkrom")) + "_" + Build.DISPLAY;
    }

    public static String f() {
        String strH = h();
        return (strH == null || !strH.toLowerCase().contains("emotionui")) ? "" : strH + "_" + Build.DISPLAY;
    }

    public static String g() {
        return r() ? "eui_" + c("ro.letv.release.version") + "_" + Build.DISPLAY : "";
    }

    public static String h() {
        return c("ro.build.version.emui");
    }

    public static String i() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static String j() {
        return c("ro.vivo.os.build.display.id") + "_" + c("ro.vivo.product.version");
    }

    public static String k() {
        return w() ? "miui_" + c("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL : "";
    }

    private static String l() {
        try {
            String strA = com.bytedance.sdk.openadsdk.m.i.d.a("rom_info", "rom_property_info", "");
            com.bytedance.sdk.component.utils.m.d("RomUtils", "get Property From SPMultiHelper..." + strA);
            return strA;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String m() {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        String strA = com.bytedance.sdk.openadsdk.core.h.a("sdk_local_rom_info", 604800000L);
        c = strA;
        if (TextUtils.isEmpty(strA)) {
            String strB = b();
            c = strB;
            com.bytedance.sdk.openadsdk.core.h.a("sdk_local_rom_info", strB);
        }
        return c;
    }

    public static String n() {
        if (v()) {
            try {
                return "smartisan_" + c("ro.smartisan.version");
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static boolean o() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static boolean p() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(a);
    }

    public static boolean q() {
        if (f == Integer.MAX_VALUE) {
            String str = Build.MANUFACTURER;
            String strG = a0.g("kllk");
            if (TextUtils.isEmpty(str) || !str.toLowerCase().contains(strG)) {
                f = 0;
            } else {
                f = 1;
            }
        }
        return f == 1;
    }

    public static boolean r() {
        return !TextUtils.isEmpty(c("ro.letv.release.version"));
    }

    public static boolean s() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static boolean t() {
        String strC = c("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strC) && strC.toLowerCase().contains(f832b);
    }

    public static boolean u() {
        try {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("huawei")) {
                String str2 = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str2) || !str2.toLowerCase().startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean v() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    public static boolean w() {
        if (!e) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    d = true;
                    e = true;
                    return true;
                }
            } catch (Exception unused) {
            }
            e = true;
        }
        return d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String c(String str) {
        String strL;
        com.bytedance.sdk.component.utils.m.a("RomUtils", "getSystemPropertyTask() called with: propName = [", str, "]");
        String str2 = g.get(str);
        if (str2 != null) {
            return str2;
        }
        try {
            strL = l();
            try {
                if (TextUtils.isEmpty(strL)) {
                    b.b.a.a.k.f fVar = new b.b.a.a.k.f(new b(str), 5, 2);
                    y.c(new a("_getSystemPropertyTask", fVar));
                    strL = (String) fVar.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            strL = "";
        }
        return strL == null ? "" : strL;
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = h();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        Process processExec;
        String line = "";
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    processExec = Runtime.getRuntime().exec("getprop " + str);
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
                        try {
                            line = bufferedReader2.readLine();
                            processExec.exitValue();
                            bufferedReader2.close();
                        } catch (IllegalThreadStateException unused) {
                            bufferedReader = bufferedReader2;
                            try {
                                processExec.destroy();
                            } catch (Throwable unused2) {
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return line;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            try {
                                com.bytedance.sdk.component.utils.m.b("ToolUtils", "Unable to read sysprop " + str, th);
                                return line;
                            } finally {
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e2) {
                                        com.bytedance.sdk.component.utils.m.b("ToolUtils", "Exception while closing InputStream", e2);
                                    }
                                }
                            }
                        }
                    } catch (IllegalThreadStateException unused3) {
                    }
                } catch (IllegalThreadStateException unused4) {
                    processExec = null;
                }
                return line;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            com.bytedance.sdk.component.utils.m.b("ToolUtils", "Exception while closing InputStream", e3);
        }
    }
}
