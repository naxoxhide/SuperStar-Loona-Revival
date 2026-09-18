package com.kakao.adfit.k;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.security.NetworkSecurityPolicy;
import androidx.webkit.ProxyConfig;
import com.facebook.share.internal.ShareInternalUtility;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SdkUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u000e\u0010\t\u001a\u0004\u0018\u00010\u0007*\u00020\rH\u0002J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\rJ\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0007J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\rJ\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\rJ(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\rJ\u000e\u0010\t\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\rR\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/kakao/adfit/k/a0;", "", "Landroid/content/Context;", "context", "Landroid/content/SharedPreferences;", "a", "", "Landroid/net/Uri;", "url", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", "", "errorCode", "", "description", "failingUrl", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "", "Z", "isPreferencesInitialized", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class a0 {
    public static final a0 a = new a0();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isPreferencesInitialized;

    private a0() {
    }

    @JvmStatic
    public static final SharedPreferences a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences pref = context.getSharedPreferences("com.kakao.adfit.preference", 0);
        if (!isPreferencesInitialized) {
            a0 a0Var = a;
            Intrinsics.checkNotNullExpressionValue(pref, "pref");
            if (!a0Var.a(pref)) {
                SharedPreferences src = PreferenceManager.getDefaultSharedPreferences(context);
                Intrinsics.checkNotNullExpressionValue(src, "src");
                if (a0Var.a(src)) {
                    SharedPreferences.Editor editorPutLong = pref.edit().putString("adfit_adid", src.getString("adfit_adid", "")).putBoolean("adfit_limited", src.getBoolean("adfit_limited", true)).putLong("adfit_cached_time", src.getLong("adfit_cached_time", 0L));
                    if (src.contains("adfit-sdkid")) {
                        editorPutLong.putString("adfit-sdkid", src.getString("adfit-sdkid", ""));
                    }
                    if (src.contains("adfit-rwbdt")) {
                        editorPutLong.putLong("adfit-rwbdt", src.getLong("adfit-rwbdt", 0L));
                    }
                    editorPutLong.apply();
                }
            }
            isPreferencesInitialized = true;
        }
        Intrinsics.checkNotNullExpressionValue(pref, "pref");
        return pref;
    }

    private final boolean b(Context context, Uri url) {
        Intent data = new Intent("android.intent.action.VIEW").setData(url);
        Intrinsics.checkNotNullExpressionValue(data, "Intent(Intent.ACTION_VIEW).setData(url)");
        try {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(data, 65536);
            Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "pm.queryIntentActivities…nager.MATCH_DEFAULT_ONLY)");
            if (listQueryIntentActivities.size() == 1) {
                String str = ((ResolveInfo) CollectionsKt.first((List) listQueryIntentActivities)).activityInfo.packageName;
                data.setPackage(str);
                data.addFlags(335544320);
                f.a("Start Default Browser: " + str);
                context.startActivity(data);
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private final boolean c(Context context, Uri url) {
        Intent data = new Intent("android.intent.action.VIEW").setData(url);
        Intrinsics.checkNotNullExpressionValue(data, "Intent(Intent.ACTION_VIEW).setData(url)");
        try {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(data, 65536);
            Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "pm.queryIntentActivities…nager.MATCH_DEFAULT_ONLY)");
            if (listQueryIntentActivities.isEmpty() ^ true) {
                data.addFlags(335544320);
                f.a("Start External Browser");
                context.startActivity(data);
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public final boolean d(Context context, Uri url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        if (a(context, url)) {
            return c(context, url);
        }
        return false;
    }

    public final boolean c(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Uri uriB = b(url);
        if (uriB == null) {
            return false;
        }
        return d(context, uriB);
    }

    public final String c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferencesA = a(context);
        String string = sharedPreferencesA.getString("adfit-sdkid", null);
        if (!(string == null || StringsKt.isBlank(string))) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        sharedPreferencesA.edit().putString("adfit-sdkid", string2).apply();
        return string2;
    }

    public final boolean b(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Uri uriB = b(url);
        if (uriB == null) {
            return false;
        }
        return c(context, uriB);
    }

    public final long b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return a(context).getLong("adfit-rwbdt", 0L);
    }

    private final Uri b(String str) {
        try {
            return Uri.parse(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private final boolean a(SharedPreferences sharedPreferences) {
        return sharedPreferences.contains("adfit_adid") && sharedPreferences.contains("adfit_limited");
    }

    private final boolean a(Uri url) {
        int i = Build.VERSION.SDK_INT;
        if (i < 24) {
            if (i == 23) {
                return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
            }
            return true;
        }
        NetworkSecurityPolicy networkSecurityPolicy = NetworkSecurityPolicy.getInstance();
        String host = url.getHost();
        if (host == null) {
            return true;
        }
        return networkSecurityPolicy.isCleartextTrafficPermitted(host);
    }

    private final boolean a(int errorCode, String description) {
        if (errorCode != -1 || description == null) {
            return false;
        }
        if (Intrinsics.areEqual(description, "ERR_CLEARTEXT_NOT_PERMITTED")) {
            return true;
        }
        return new Regex("cleartext.not.permitted", RegexOption.IGNORE_CASE).containsMatchIn(description);
    }

    public final boolean a(Context context, Uri url) {
        String lowerCase;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        String scheme = url.getScheme();
        if (scheme != null) {
            lowerCase = scheme.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        } else {
            lowerCase = null;
        }
        return Intrinsics.areEqual(lowerCase, ProxyConfig.MATCH_HTTP) && context.getApplicationInfo().targetSdkVersion >= 26 && !a(url);
    }

    public final boolean a(int errorCode, String description, Uri failingUrl) {
        String lowerCase;
        Intrinsics.checkNotNullParameter(failingUrl, "failingUrl");
        String scheme = failingUrl.getScheme();
        if (scheme != null) {
            lowerCase = scheme.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        } else {
            lowerCase = null;
        }
        if (Intrinsics.areEqual(lowerCase, ProxyConfig.MATCH_HTTP)) {
            return a(errorCode, description) || !a(failingUrl);
        }
        return false;
    }

    public final boolean a(Context context, int errorCode, String description, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Uri uriB = b(url);
        if (uriB == null) {
            return false;
        }
        return a(context, errorCode, description, uriB);
    }

    public final boolean a(Context context, int errorCode, String description, Uri url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        if (a(errorCode, description, url)) {
            return c(context, url);
        }
        return false;
    }

    public final boolean a(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            if (System.currentTimeMillis() - b(context) < 86400000) {
                return false;
            }
            Uri uri = Uri.parse(url);
            if (Intrinsics.areEqual(uri.getQueryParameter("rwb"), "1")) {
                a(context).edit().putLong("adfit-rwbdt", System.currentTimeMillis()).apply();
                Intrinsics.checkNotNullExpressionValue(uri, "uri");
                if (b(context, uri)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            com.kakao.adfit.e.f.a.a(th);
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0031  */
    public final boolean a(String url) {
        boolean z;
        String scheme;
        Intrinsics.checkNotNullParameter(url, "url");
        Uri uriB = b(url);
        String strReplace = (uriB == null || (scheme = uriB.getScheme()) == null) ? null : new Regex("\\s+").replace(scheme, "");
        if (strReplace == null) {
            z = false;
        } else {
            if (strReplace.length() > 0) {
                z = true;
            } else {
                z = false;
            }
        }
        return !z || StringsKt.contains((CharSequence) strReplace, (CharSequence) "javascript", true) || StringsKt.contains((CharSequence) strReplace, (CharSequence) "data", true) || StringsKt.contains((CharSequence) strReplace, (CharSequence) ShareInternalUtility.STAGING_PARAM, true);
    }
}
