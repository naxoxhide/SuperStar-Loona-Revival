package com.bytedance.sdk.openadsdk.m;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.r;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: TTMultiInitHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static boolean a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f790b = new AtomicBoolean(false);

    public static void a() {
        a = false;
    }

    public static void b(Context context) {
        if (context != null && a && f790b.compareAndSet(false, true)) {
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    if (r.c(context)) {
                        a(context);
                        return;
                    }
                    String strA = r.a(context);
                    try {
                        if (TextUtils.isEmpty(strA)) {
                            strA = context.getPackageName() + Process.myPid();
                        }
                        WebView.setDataDirectorySuffix(strA);
                    } catch (IllegalStateException unused) {
                        a(strA);
                    } catch (Exception unused2) {
                    }
                }
            } catch (Throwable th) {
                m.b(th.getMessage());
            }
        }
    }

    private static void a(String str) {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            Field field = (Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix");
            field.setAccessible(true);
            if (TextUtils.isEmpty((String) field.get(cls))) {
                field.set(cls, str);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:66:0x0116 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:? A[SYNTHETIC] */
    private static void a(Context context) throws Throwable {
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        Throwable th;
        String strB = b();
        File file = new File(context.getDir(TextUtils.isEmpty(strB) ? "webview" : "webview_" + strB, 0).getPath(), "webview_data.lock");
        m.d("TTAD.TTMultiInitHelper", file.getAbsolutePath());
        if (!file.exists()) {
            return;
        }
        FileChannel fileChannel = null;
        FileLock fileLockTryLock = null;
        fileChannel = null;
        fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                channel = randomAccessFile.getChannel();
                if (channel != null) {
                    try {
                        fileLockTryLock = channel.tryLock();
                    } catch (Exception unused) {
                        fileChannel = channel;
                        try {
                            a(file);
                            if (fileChannel != null) {
                                try {
                                    fileChannel.close();
                                } catch (Throwable th2) {
                                    m.a("checkWebViewDataLock try close exclusiveFileChannel : " + th2.getMessage());
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                    return;
                                } catch (Throwable th3) {
                                    m.a("checkWebViewDataLock try close accessFile : " + th3.getMessage());
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th4) {
                            th = th4;
                            if (fileChannel != null) {
                                try {
                                    fileChannel.close();
                                } catch (Throwable th5) {
                                    m.a("checkWebViewDataLock try close exclusiveFileChannel : " + th5.getMessage());
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                    throw th;
                                } catch (Throwable th6) {
                                    m.a("checkWebViewDataLock try close accessFile : " + th6.getMessage());
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        th = th;
                        fileChannel = channel;
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                            throw th;
                        }
                        throw th;
                    }
                }
                if (fileLockTryLock != null) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        fileLockTryLock.close();
                    }
                } else {
                    a(file);
                }
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (Throwable th8) {
                        m.a("checkWebViewDataLock try close exclusiveFileChannel : " + th8.getMessage());
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (Throwable th9) {
                    m.a("checkWebViewDataLock try close accessFile : " + th9.getMessage());
                }
            } catch (Exception unused2) {
            } catch (Throwable th10) {
                channel = null;
                th = th10;
            }
        } catch (Exception unused3) {
            randomAccessFile = null;
        } catch (Throwable th11) {
            th = th11;
            randomAccessFile = null;
        }
    }

    private static String b() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            return (String) ((Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix")).get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void a(File file) {
        a(file, file.exists() ? file.delete() : false);
    }

    private static void a(File file, boolean z) {
        if (!z || file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            m.b("TTAD.TTMultiInitHelper", e.getMessage());
        }
    }
}
