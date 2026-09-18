package com.gomfactory.adpie.sdk.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.webkit.ProxyConfig;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.InAppBrowser;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ClickThroughUtil {
    public static final String TAG = "ClickThroughUtil";
    private static final long VALIDATION_TIME = 500;
    private static ArrayList<String> choiceBrowser = new ArrayList<>();
    private static long sLastClickTime;

    public static void addTargetBrowser(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<String> it = choiceBrowser.iterator();
        while (it.hasNext()) {
            if (it.next().equals(str)) {
                return;
            }
        }
        choiceBrowser.add(str);
    }

    public static void clearTargetBrowser() {
        choiceBrowser.clear();
    }

    /* JADX WARN: Code duplicated, block: B:31:0x010b A[Catch: Exception -> 0x0124, TRY_LEAVE, TryCatch #3 {Exception -> 0x0124, blocks: (B:4:0x0006, B:6:0x001e, B:7:0x0036, B:9:0x004c, B:10:0x0051, B:12:0x0062, B:14:0x007b, B:15:0x0080, B:17:0x0091, B:19:0x00aa, B:29:0x00fa, B:31:0x010b, B:20:0x00ae, B:21:0x00b4, B:23:0x00ba, B:24:0x00c3, B:26:0x00d4, B:28:0x00f7), top: B:46:0x0006, inners: #1, #2 }] */
    public static boolean goToBrowser(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, ":::clickEvent:::Open Browser : " + str);
            }
            intent.setData(Uri.parse(str));
            intent.addFlags(268435456);
            if (choiceBrowser.isEmpty()) {
                intent.setPackage("com.sec.android.app.sbrowser");
                try {
                    context.startActivity(intent);
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(TAG, ":::clickEvent:::You have successfully opened the Samsung browser. " + str);
                    }
                    return true;
                } catch (ActivityNotFoundException unused) {
                    intent.setPackage("com.android.chrome");
                    try {
                        context.startActivity(intent);
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(TAG, ":::clickEvent:::You have successfully opened the Chrome browser. " + str);
                        }
                        return true;
                    } catch (ActivityNotFoundException unused2) {
                        intent.setPackage(null);
                        context.startActivity(intent);
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(TAG, ":::clickEvent:::You have successfully opened browser. " + str);
                        }
                        return true;
                    }
                }
            }
            for (String str2 : choiceBrowser) {
                intent.setPackage(str2);
                try {
                    context.startActivity(intent);
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(TAG, ":::clickEvent:::You have successfully opened browser. (" + str2 + ") " + str);
                    }
                    return true;
                } catch (ActivityNotFoundException unused3) {
                }
            }
            intent.setPackage(null);
            context.startActivity(intent);
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, ":::clickEvent:::You have successfully opened browser. " + str);
            }
            return true;
        } catch (Exception e) {
            if (!AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                return false;
            }
            AdPieLog.e(TAG, e);
            return false;
        }
    }

    public static boolean isValidClick() {
        if (SystemClock.elapsedRealtime() - sLastClickTime < VALIDATION_TIME) {
            return false;
        }
        sLastClickTime = SystemClock.elapsedRealtime();
        return true;
    }

    public static boolean goToWebView(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
            AdPieLog.d(TAG, "landingUrl : " + str + ", scheme : " + scheme);
        }
        if (!scheme.equalsIgnoreCase(ProxyConfig.MATCH_HTTP) && !scheme.equalsIgnoreCase("https")) {
            if (uri.getScheme().equalsIgnoreCase(SDKConstants.PARAM_INTENT)) {
                String stringExtra = null;
                try {
                    Intent uri2 = Intent.parseUri(str, 1);
                    stringExtra = uri2.getStringExtra("browser_fallback_url");
                    context.startActivity(uri2);
                    return true;
                } catch (ActivityNotFoundException e) {
                    String str2 = TAG;
                    AdPieLog.e(str2, e);
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(str2, "fallbackUrl : " + stringExtra);
                    }
                    if (!TextUtils.isEmpty(stringExtra)) {
                        try {
                            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                AdPieLog.d(str2, ":::clickEvent:::Open WebView. (fallback) " + stringExtra);
                            }
                            Intent intent = new Intent(context, (Class<?>) InAppBrowser.class);
                            intent.putExtra("url", stringExtra);
                            context.startActivity(intent);
                            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                AdPieLog.d(str2, ":::clickEvent:::You have successfully opened WebView. (fallback) " + stringExtra);
                            }
                            return true;
                        } catch (ActivityNotFoundException e2) {
                            AdPieLog.e(TAG, e2);
                            if (goToBrowser(context, stringExtra)) {
                                return true;
                            }
                        } catch (Exception e3) {
                            AdPieLog.e(TAG, e3);
                            if (goToBrowser(context, stringExtra)) {
                                return true;
                            }
                        }
                    }
                } catch (URISyntaxException e4) {
                    String str3 = TAG;
                    Log.e(str3, "Can't resolve intent://", e4);
                    AdPieLog.e(str3, e4);
                }
            } else if (scheme.equalsIgnoreCase("market")) {
                try {
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(TAG, ":::clickEvent:::Open Google Play Store. " + str);
                    }
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(str));
                    intent2.setPackage("com.android.vending");
                    context.startActivity(intent2);
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(TAG, ":::clickEvent:::You have successfully opened Google Play Store. " + str);
                    }
                    return true;
                } catch (ActivityNotFoundException e5) {
                    String str4 = TAG;
                    AdPieLog.e(str4, e5);
                    try {
                        String str5 = String.format("https://play.google.com/store/apps/details?%s", uri.getQuery());
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(str4, ":::clickEvent:::Open Google Play Store. " + str5);
                        }
                        Intent intent3 = new Intent("android.intent.action.VIEW");
                        intent3.setData(Uri.parse(str5));
                        intent3.setPackage("com.android.vending");
                        context.startActivity(intent3);
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(str4, ":::clickEvent:::You have successfully opened Google Play Store. " + str5);
                        }
                        return true;
                    } catch (ActivityNotFoundException e6) {
                        AdPieLog.e(TAG, e6);
                    } catch (Exception e7) {
                        AdPieLog.e(TAG, e7);
                    }
                }
            } else {
                try {
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(TAG, ":::clickEvent:::Start intent. " + str);
                    }
                    context.startActivity(Intent.parseUri(str, 1));
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(TAG, ":::clickEvent:::You have successfully started intent. " + str);
                    }
                    return true;
                } catch (ActivityNotFoundException e8) {
                    AdPieLog.e(TAG, e8);
                } catch (URISyntaxException e9) {
                    AdPieLog.e(TAG, e9);
                }
            }
        } else {
            try {
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(TAG, ":::clickEvent:::Open WebView. " + str);
                }
                Intent intent4 = new Intent(context, (Class<?>) InAppBrowser.class);
                intent4.putExtra("url", str);
                context.startActivity(intent4);
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(TAG, ":::clickEvent:::You have successfully opened WebView. " + str);
                }
                return true;
            } catch (ActivityNotFoundException e10) {
                AdPieLog.e(TAG, e10);
                if (goToBrowser(context, str)) {
                    return true;
                }
            } catch (Exception e11) {
                AdPieLog.e(TAG, e11);
                if (goToBrowser(context, str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
