package com.kakao.adfit.k;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeviceUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b&\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007J\u001a\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0003J\u000e\u0010\u0005\u001a\u00020\u0004*\u0004\u0018\u00010\u0004H\u0003J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\u000e\u001a\u00020\u0004H\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0007J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0007J\b\u0010\u0012\u001a\u00020\u0011H\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u000e\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0010\u0010\u0005\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0010\u0010\u0012\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u000e\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0017H\u0007J\u0010\u0010\u0005\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0017H\u0007J\b\u0010\u0005\u001a\u00020\u0015H\u0007J\b\u0010\u001a\u001a\u00020\u0015H\u0007J\b\u0010\u001b\u001a\u00020\u0004H\u0007J\b\u0010\u0018\u001a\u00020\u0004H\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0005\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007J\u0010\u0010\u000e\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001cH\u0007J\u0010\u0010\u000b\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001cH\u0007J\u0010\u0010\u0012\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007J\u0010\u0010\u0010\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\f\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u001f\u001a\u00020\u0016H\u0007J\u0010\u0010\u0006\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\r\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u001e\u0010#\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\f\n\u0004\b\u000e\u0010 \u0012\u0004\b!\u0010\"R\u001e\u0010%\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\f\n\u0004\b\u0012\u0010 \u0012\u0004\b$\u0010\"¨\u0006'"}, d2 = {"Lcom/kakao/adfit/k/i;", "", "Landroid/content/Context;", "context", "", "a", "j", InneractiveMediationDefs.GENDER_FEMALE, "Landroid/webkit/WebView;", "v", "webView", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "h", "g", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "i", "", "c", "Landroid/app/ActivityManager$MemoryInfo;", "memoryInfo", "", "", "Landroid/os/StatFs;", "e", "stat", "l", CampaignEx.JSON_KEY_AD_K, "Landroid/content/Intent;", "batteryIntent", "", InneractiveMediationDefs.GENDER_MALE, "Ljava/lang/String;", "getSystemUserAgent$annotations", "()V", "systemUserAgent", "getWebViewUserAgent$annotations", "webViewUserAgent", "<init>", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class i {
    public static final i a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile String systemUserAgent;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static volatile String webViewUserAgent;

    private i() {
    }

    @JvmStatic
    public static final String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return a0.a.c(context);
    }

    @JvmStatic
    public static final String b() {
        String BRAND = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
        return BRAND;
    }

    @JvmStatic
    public static final int c() {
        return Runtime.getRuntime().availableProcessors();
    }

    @JvmStatic
    public static final String d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            String string = Settings.Global.getString(context.getContentResolver(), TapjoyConstants.TJC_DEVICE_NAME);
            Intrinsics.checkNotNullExpressionValue(string, "getString(context.contentResolver, \"device_name\")");
            return string;
        } catch (Exception unused) {
            return "unknown";
        }
    }

    @JvmStatic
    public static final StatFs e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                return new StatFs(externalFilesDir.getPath());
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmStatic
    public static final String f(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return a(context, null);
    }

    @JvmStatic
    public static final String g() {
        String ID = Build.ID;
        Intrinsics.checkNotNullExpressionValue(ID, "ID");
        return ID;
    }

    @JvmStatic
    public static final String h() {
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        return MODEL;
    }

    @JvmStatic
    public static final List<String> i() {
        try {
            String[] SUPPORTED_ABIS = Build.SUPPORTED_ABIS;
            Intrinsics.checkNotNullExpressionValue(SUPPORTED_ABIS, "SUPPORTED_ABIS");
            return ArraysKt.toList(SUPPORTED_ABIS);
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }

    @JvmStatic
    public static final String j() {
        String str = systemUserAgent;
        if (str != null) {
            return str;
        }
        String strA = a(System.getProperty("http.agent"));
        systemUserAgent = strA;
        return strA;
    }

    @JvmStatic
    public static final String k() {
        String id = TimeZone.getDefault().getID();
        Intrinsics.checkNotNullExpressionValue(id, "getDefault().id");
        return id;
    }

    @JvmStatic
    public static final long l() {
        return b0.INSTANCE.b().getMillis();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0037  */
    /* JADX WARN: Code duplicated, block: B:12:0x0046  */
    /* JADX WARN: Code duplicated, block: B:14:0x0051  */
    /* JADX WARN: Code duplicated, block: B:16:0x0060  */
    /* JADX WARN: Code duplicated, block: B:18:0x006b  */
    /* JADX WARN: Code duplicated, block: B:20:0x0076  */
    /* JADX WARN: Code duplicated, block: B:22:0x0085  */
    /* JADX WARN: Code duplicated, block: B:24:0x0094  */
    /* JADX WARN: Code duplicated, block: B:26:0x009d  */
    /* JADX WARN: Code duplicated, block: B:28:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:30:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:32:0x00be  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:6:0x001f  */
    /* JADX WARN: Code duplicated, block: B:8:0x002c  */
    @JvmStatic
    public static final boolean m() {
        String FINGERPRINT;
        String HARDWARE;
        String MODEL;
        String MANUFACTURER;
        String PRODUCT;
        String BRAND = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
        if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
            String DEVICE = Build.DEVICE;
            Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
            if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                FINGERPRINT = Build.FINGERPRINT;
                Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                    Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                    if (!StringsKt.startsWith$default(FINGERPRINT, "unknown", false, 2, (Object) null)) {
                        HARDWARE = Build.HARDWARE;
                        Intrinsics.checkNotNullExpressionValue(HARDWARE, "HARDWARE");
                        if (!StringsKt.contains$default((CharSequence) HARDWARE, (CharSequence) "goldfish", false, 2, (Object) null)) {
                            Intrinsics.checkNotNullExpressionValue(HARDWARE, "HARDWARE");
                            if (!StringsKt.contains$default((CharSequence) HARDWARE, (CharSequence) "ranchu", false, 2, (Object) null)) {
                                MODEL = Build.MODEL;
                                Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                    Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                    if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                        if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                            MANUFACTURER = Build.MANUFACTURER;
                                            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                            if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                PRODUCT = Build.PRODUCT;
                                                Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                                if (!StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "sdk_google", false, 2, (Object) null)) {
                                                    Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                                    if (!StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                        Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                                        if (!StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "sdk", false, 2, (Object) null)) {
                                                            Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                                            if (!StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "sdk_x86", false, 2, (Object) null)) {
                                                                Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                                                if (!StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "vbox86p", false, 2, (Object) null)) {
                                                                    Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                                                    if (!StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "emulator", false, 2, (Object) null)) {
                                                                        Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                                                        if (StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "simulator", false, 2, (Object) null)) {
                                                                            return false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            FINGERPRINT = Build.FINGERPRINT;
            Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
            if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                if (!StringsKt.startsWith$default(FINGERPRINT, "unknown", false, 2, (Object) null)) {
                    HARDWARE = Build.HARDWARE;
                    Intrinsics.checkNotNullExpressionValue(HARDWARE, "HARDWARE");
                    if (!StringsKt.contains$default((CharSequence) HARDWARE, (CharSequence) "goldfish", false, 2, (Object) null)) {
                        Intrinsics.checkNotNullExpressionValue(HARDWARE, "HARDWARE");
                        if (!StringsKt.contains$default((CharSequence) HARDWARE, (CharSequence) "ranchu", false, 2, (Object) null)) {
                            MODEL = Build.MODEL;
                            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                            if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                    Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                    if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                        MANUFACTURER = Build.MANUFACTURER;
                                        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                        if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                            PRODUCT = Build.PRODUCT;
                                            Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                            if (!StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "sdk_google", false, 2, (Object) null)) {
                                                Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                                if (!StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                    Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                                    if (!StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "sdk", false, 2, (Object) null)) {
                                                        Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                                        if (!StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "sdk_x86", false, 2, (Object) null)) {
                                                            Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                                            if (!StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "vbox86p", false, 2, (Object) null)) {
                                                                Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                                                if (!StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "emulator", false, 2, (Object) null)) {
                                                                    Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                                                    if (StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "simulator", false, 2, (Object) null)) {
                                                                        return false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    @JvmStatic
    public static final String a(WebView v) {
        Intrinsics.checkNotNullParameter(v, "v");
        Context context = v.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "v.context");
        return a(context, v);
    }

    @JvmStatic
    public static final long b(ActivityManager.MemoryInfo memoryInfo) {
        Intrinsics.checkNotNullParameter(memoryInfo, "memoryInfo");
        return memoryInfo.totalMem;
    }

    @JvmStatic
    public static final ActivityManager.MemoryInfo c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService("activity");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
            return memoryInfo;
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmStatic
    public static final String e() {
        String string = Locale.getDefault().toString();
        Intrinsics.checkNotNullExpressionValue(string, "getDefault().toString()");
        return string;
    }

    @JvmStatic
    public static final String f() {
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        return MANUFACTURER;
    }

    @JvmStatic
    public static final boolean g(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    @JvmStatic
    public static final boolean h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService("keyguard");
            if (systemService != null) {
                return ((KeyguardManager) systemService).inKeyguardRestrictedInputMode();
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.KeyguardManager");
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0029  */
    /* JADX WARN: Code duplicated, block: B:29:0x004d A[PHI: r0 r2
      0x004d: PHI (r0v7 android.webkit.WebView) = (r0v6 android.webkit.WebView), (r0v8 android.webkit.WebView) binds: [B:28:0x004b, B:25:0x0046] A[DONT_GENERATE, DONT_INLINE]
      0x004d: PHI (r2v4 java.lang.String) = (r2v2 java.lang.String), (r2v7 java.lang.String) binds: [B:28:0x004b, B:25:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:31:0x0052  */
    /* JADX WARN: Code duplicated, block: B:33:0x0058  */
    /* JADX WARN: Code duplicated, block: B:34:0x005a  */
    /* JADX WARN: Code duplicated, block: B:36:0x005d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0060  */
    /* JADX WARN: Code duplicated, block: B:52:0x0082  */
    @JvmStatic
    private static final String a(final Context context, final WebView webView) {
        boolean z;
        WebView webView2;
        boolean z2;
        String defaultUserAgent;
        boolean z3;
        String str = webViewUserAgent;
        if (str != null) {
            return str;
        }
        String userAgentString = null;
        boolean z4 = false;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            try {
                userAgentString = WebSettings.getDefaultUserAgent(context);
            } catch (Throwable unused) {
            }
            if (userAgentString == null) {
                z = false;
            } else {
                if (userAgentString.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                String strA = a(userAgentString);
                webViewUserAgent = strA;
                return strA;
            }
            if (webView == null) {
                try {
                    webView2 = new WebView(context);
                } catch (Throwable unused2) {
                    webView2 = webView;
                    if (webView == null) {
                        webView2.destroy();
                    }
                    if (userAgentString != null) {
                        if (userAgentString.length() > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            z4 = true;
                        }
                    }
                    if (z4) {
                        String strA2 = a(userAgentString);
                        webViewUserAgent = strA2;
                        return strA2;
                    }
                    return j();
                }
            } else {
                webView2 = webView;
            }
            try {
                userAgentString = webView2.getSettings().getUserAgentString();
                if (webView == null) {
                    webView2.destroy();
                }
            } catch (Throwable unused3) {
                if (webView == null && webView2 != null) {
                    webView2.destroy();
                }
            }
            if (userAgentString != null) {
                if (userAgentString.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    z4 = true;
                }
            }
            if (z4) {
                String strA3 = a(userAgentString);
                webViewUserAgent = strA3;
                return strA3;
            }
        } else {
            if (Build.VERSION.SDK_INT < 28) {
                try {
                    defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                } catch (Throwable unused4) {
                    defaultUserAgent = null;
                }
                if (defaultUserAgent == null) {
                    z3 = false;
                } else {
                    if (defaultUserAgent.length() > 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                }
                if (z3) {
                    String strA4 = a(defaultUserAgent);
                    webViewUserAgent = strA4;
                    return strA4;
                }
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final AtomicReference atomicReference = new AtomicReference(null);
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.kakao.adfit.k.-$$Lambda$i$WCkgyPCXS4qR_2TFUgq8oq8ZCKw
                @Override // java.lang.Runnable
                public final void run() {
                    i.a(atomicReference, context, webView, countDownLatch);
                }
            });
            try {
                countDownLatch.await(1000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused5) {
            }
            String str2 = (String) atomicReference.get();
            if (str2 != null) {
                if (str2.length() > 0) {
                    z4 = true;
                }
            }
            if (z4) {
                return str2;
            }
        }
        return j();
    }

    @JvmStatic
    public static final long b(StatFs stat) {
        Intrinsics.checkNotNullParameter(stat, "stat");
        return stat.getBlockSizeLong() * stat.getBlockCountLong();
    }

    @JvmStatic
    public static final Intent b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmStatic
    public static final int b(Intent batteryIntent) {
        Intrinsics.checkNotNullParameter(batteryIntent, "batteryIntent");
        try {
            return batteryIntent.getIntExtra("status", 1);
        } catch (Exception unused) {
            return 1;
        }
    }

    @JvmStatic
    public static final boolean c(ActivityManager.MemoryInfo memoryInfo) {
        Intrinsics.checkNotNullParameter(memoryInfo, "memoryInfo");
        return memoryInfo.lowMemory;
    }

    @JvmStatic
    public static final String d() {
        try {
            String MODEL = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            String str = (String) CollectionsKt.firstOrNull((List) new Regex(" ").split(MODEL, 0));
            return str != null ? str : "unknown";
        } catch (Exception unused) {
            return "unknown";
        }
    }

    @JvmStatic
    public static final float c(Intent batteryIntent) {
        Intrinsics.checkNotNullParameter(batteryIntent, "batteryIntent");
        try {
            int intExtra = batteryIntent.getIntExtra("temperature", -1);
            if (intExtra > 0) {
                return intExtra / 10.0f;
            }
            return -1.0f;
        } catch (Exception unused) {
            return -1.0f;
        }
    }

    @JvmStatic
    public static final boolean i(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService("power");
            if (systemService != null) {
                return ((PowerManager) systemService).isInteractive();
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
        } catch (Exception unused) {
            return false;
        }
    }

    @JvmStatic
    public static final boolean j(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.hardware.usb.action.USB_STATE"));
            Bundle extras = intentRegisterReceiver != null ? intentRegisterReceiver.getExtras() : null;
            if (extras != null) {
                return extras.getBoolean("connected");
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @JvmStatic
    public static final boolean d(Intent batteryIntent) {
        Intrinsics.checkNotNullParameter(batteryIntent, "batteryIntent");
        try {
            int intExtra = batteryIntent.getIntExtra("plugged", -1);
            return intExtra == 1 || intExtra == 2;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(AtomicReference value, Context context, WebView webView, CountDownLatch syncLatch) {
        Intrinsics.checkNotNullParameter(value, "$value");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(syncLatch, "$syncLatch");
        value.set(a(context, webView));
        syncLatch.countDown();
    }

    @JvmStatic
    private static final String a(String str) {
        return str != null && (StringsKt.isBlank(str) ^ true) ? StringsKt.trim((CharSequence) (str + " AdFitSDK/3.13.6")).toString() : StringsKt.trim((CharSequence) "AdFitSDK/3.13.6").toString();
    }

    @JvmStatic
    public static final long a(ActivityManager.MemoryInfo memoryInfo) {
        Intrinsics.checkNotNullParameter(memoryInfo, "memoryInfo");
        return memoryInfo.availMem;
    }

    @JvmStatic
    public static final long a(StatFs stat) {
        Intrinsics.checkNotNullParameter(stat, "stat");
        return stat.getBlockSizeLong() * stat.getAvailableBlocksLong();
    }

    @JvmStatic
    public static final long a() {
        b0.Companion aVar = b0.INSTANCE;
        return aVar.a().getMillis() - aVar.b().getMillis();
    }

    @JvmStatic
    public static final float a(Intent batteryIntent) {
        Intrinsics.checkNotNullParameter(batteryIntent, "batteryIntent");
        try {
            int intExtra = batteryIntent.getIntExtra("level", -1);
            int intExtra2 = batteryIntent.getIntExtra("scale", -1);
            if (intExtra < 0 || intExtra2 <= 0) {
                return -1.0f;
            }
            return (intExtra * 100.0f) / intExtra2;
        } catch (Exception unused) {
            return -1.0f;
        }
    }
}
