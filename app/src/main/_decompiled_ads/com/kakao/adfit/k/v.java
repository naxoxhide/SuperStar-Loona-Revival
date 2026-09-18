package com.kakao.adfit.k;

import android.os.Build;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OperatingSystemInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0002H\u0007¨\u0006\t"}, d2 = {"Lcom/kakao/adfit/k/v;", "", "", "c", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class v {
    public static final v a = new v();

    private v() {
    }

    @JvmStatic
    public static final String a() {
        String DISPLAY = Build.DISPLAY;
        Intrinsics.checkNotNullExpressionValue(DISPLAY, "DISPLAY");
        return DISPLAY;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0048 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:? A[RETURN, SYNTHETIC] */
    @JvmStatic
    public static final String b() throws Throwable {
        String property;
        File file = new File("/proc/version");
        if (file.canRead()) {
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    try {
                        String line = bufferedReader2.readLine();
                        if (!TextUtils.isEmpty(line)) {
                            Intrinsics.checkNotNullExpressionValue(line, "line");
                            try {
                                bufferedReader2.close();
                            } catch (Exception unused) {
                            }
                            return line;
                        }
                        bufferedReader2.close();
                    } catch (IOException unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        property = System.getProperty("os.version");
                        if (property == null) {
                            return "unknown";
                        }
                        return property;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused4) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception unused5) {
            }
        }
        property = System.getProperty("os.version");
        if (property == null) {
            return "unknown";
        }
        return property;
    }

    @JvmStatic
    public static final String c() {
        return "Android";
    }

    @JvmStatic
    public static final String d() {
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        return RELEASE;
    }
}
