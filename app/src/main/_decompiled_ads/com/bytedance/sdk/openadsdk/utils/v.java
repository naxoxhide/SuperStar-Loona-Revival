package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Properties;

/* JADX INFO: compiled from: TTCrashHandler.java */
/* JADX INFO: loaded from: classes2.dex */
public class v implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f834b;

    private v() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        b();
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0102 A[Catch: all -> 0x0119, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x0119, blocks: (B:60:0x0116, B:50:0x0102), top: B:92:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0116 A[Catch: all -> 0x0119, DONT_GENERATE, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x0119, blocks: (B:60:0x0116, B:50:0x0102), top: B:92:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x00fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x0111 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:? A[RETURN, SYNTHETIC] */
    private void a(Thread thread, Throwable th) {
        FileOutputStream fileOutputStream;
        boolean z;
        int i;
        FileInputStream fileInputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        fileInputStream = null;
        try {
            try {
                if (TextUtils.isEmpty(this.f834b)) {
                    b();
                }
                if (TextUtils.isEmpty(this.f834b)) {
                    return;
                }
                File file = new File(this.f834b, "tt_crash_count.properties");
                boolean z2 = true;
                if (file.exists() && file.isFile() && file.canRead()) {
                    Properties properties = new Properties();
                    FileInputStream fileInputStream3 = new FileInputStream(file);
                    try {
                        properties.load(fileInputStream3);
                        String property = properties.getProperty("crash_count", "0");
                        String property2 = properties.getProperty("crash_last_time", "0");
                        int iIntValue = Integer.valueOf(property).intValue();
                        int i2 = 0;
                        if (System.currentTimeMillis() - Long.valueOf(property2).longValue() < 300000) {
                            i = iIntValue + 1;
                            z = false;
                        } else {
                            z = true;
                            i = 1;
                        }
                        if (i < 3) {
                            z2 = false;
                        }
                        if (!z2) {
                            i2 = i;
                        }
                        com.bytedance.sdk.component.utils.m.b("TTCrashHandler", "==" + i2 + ", " + z2 + ", " + z);
                        if (z2) {
                            try {
                                file.delete();
                            } catch (Throwable unused) {
                            }
                        } else {
                            properties.setProperty("crash_count", String.valueOf(i2));
                            if (z) {
                                properties.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
                            }
                            FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                            try {
                                properties.store(fileOutputStream3, "tt_crash_info");
                                fileOutputStream2 = fileOutputStream3;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream2 = fileOutputStream3;
                                fileOutputStream = fileOutputStream2;
                                fileInputStream = fileInputStream3;
                                com.bytedance.sdk.component.utils.m.b("TTCrashHandler", "crash count error", th);
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                if (fileOutputStream != null) {
                                }
                            }
                        }
                        if (z2) {
                            a();
                        }
                        fileOutputStream = fileOutputStream2;
                        fileInputStream2 = fileInputStream3;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (fileOutputStream != null) {
                        } else {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    Properties properties2 = new Properties();
                    properties2.setProperty("crash_count", String.valueOf(1));
                    properties2.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        properties2.store(fileOutputStream, "tt_crash_info");
                        com.bytedance.sdk.component.utils.m.b("TTCrashHandler", "==first");
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        if (fileOutputStream != null) {
                        } else {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        try {
                            com.bytedance.sdk.component.utils.m.b("TTCrashHandler", "crash count error", th);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable unused3) {
                                }
                            }
                            if (fileOutputStream != null) {
                            }
                        } finally {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable unused4) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable unused5) {
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
            }
        } catch (Throwable unused6) {
        }
    }

    private void b() {
        Context contextA = com.bytedance.sdk.openadsdk.core.o.a();
        if (contextA == null) {
            return;
        }
        try {
            File file = new File(contextA.getFilesDir(), "TTCache");
            file.mkdirs();
            this.f834b = file.getPath();
        } catch (Throwable unused) {
        }
    }

    public static v c() {
        return new v();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        String string;
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            string = stringWriter.toString();
        } catch (Throwable unused) {
        }
        if (string != null ? string.contains(AdSlot.class.getPackage().getName()) : false) {
            a(thread, th);
        }
        b.b.a.a.k.e.a(false);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    private void a() {
        try {
            Method methodA = com.bytedance.sdk.component.utils.x.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "a", Context.class);
            if (methodA != null) {
                methodA.invoke(null, com.bytedance.sdk.openadsdk.core.o.a());
            }
        } catch (Throwable unused) {
        }
        try {
            Method methodA2 = com.bytedance.sdk.component.utils.x.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "a", Context.class);
            if (methodA2 != null) {
                methodA2.invoke(null, com.bytedance.sdk.openadsdk.core.o.a());
            }
        } catch (Throwable unused2) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.settings.n.j0().B();
        } catch (Throwable unused3) {
        }
        try {
            b.b.a.a.d.e.b.a.a();
        } catch (Throwable unused4) {
        }
    }
}
