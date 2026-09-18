package com.applovin.impl.sdk;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdk;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.measurement.AppMeasurement;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TapjoyConstants;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class r {
    private static final int aEw = (int) TimeUnit.SECONDS.toMillis(30);
    private final ExecutorService aEx;
    private final Map<a, Long> aEy = Collections.synchronizedMap(new HashMap());
    protected final x logger;
    protected final n sdk;

    public enum a {
        ANR("anr"),
        BLACK_VIEW("black_view"),
        CRASH(AppMeasurement.CRASH_ORIGIN),
        TASK_EXCEPTION("task_exception"),
        CAUGHT_EXCEPTION("caught_exception"),
        WEB_VIEW_ERROR("web_view_error"),
        INTEGRATION_ERROR("integration_error"),
        TEMPLATE_ERROR("template_error"),
        FILE_ERROR("file_error"),
        NETWORK_ERROR("network_error");

        private final String Jn;

        a(String str) {
            this.Jn = str;
        }

        public String tU() {
            return this.Jn;
        }
    }

    public r(final n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BL();
        this.aEx = Executors.newFixedThreadPool(1, new ThreadFactory() { // from class: com.applovin.impl.sdk.r.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "AppLovinSdk:error_reporter");
                thread.setDaemon(true);
                thread.setPriority(((Integer) nVar.a(com.applovin.impl.sdk.c.b.aQF)).intValue());
                thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.applovin.impl.sdk.r.1.1
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public void uncaughtException(Thread thread2, Throwable th) {
                        nVar.BL();
                        if (x.Fk()) {
                            nVar.BL().c("ErrorReporter", "Caught unhandled exception", th);
                        }
                    }
                });
                return thread;
            }
        });
    }

    public void g(String str, Throwable th) {
        d(str, null, th);
    }

    public void d(String str, String str2, Throwable th) {
        HashMap map = new HashMap(3);
        map.put("source", str);
        map.put("details", StringUtils.emptyIfNull(str2));
        map.put("top_main_method", th.toString());
        a(a.CAUGHT_EXCEPTION, map);
    }

    public void b(String str, String str2, int i) {
        if (i < 400) {
            return;
        }
        HashMap map = new HashMap(3);
        map.put("source", str2);
        map.put("details", StringUtils.emptyIfNull(str));
        map.put("top_main_method", String.valueOf(i));
        a(a.NETWORK_ERROR, map);
    }

    public void a(a aVar, String str, String str2) {
        HashMap map = new HashMap(2);
        map.put("source", str);
        map.put("details", StringUtils.emptyIfNull(str2));
        a(aVar, map);
    }

    public void a(a aVar, Map<String, String> map) {
        a(aVar, map, 0L);
    }

    public void a(final a aVar, final Map<String, String> map, long j) {
        if (a(aVar, j)) {
            return;
        }
        try {
            if (com.applovin.impl.sdk.utils.u.Lv()) {
                this.aEx.execute(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$r$ARbdsBts1mmIdZtWqchCcj3jCl4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.d(aVar, map);
                    }
                });
            } else {
                d(aVar, map);
            }
        } catch (Throwable th) {
            if (x.Fk()) {
                this.logger.b("ErrorReporter", "Failed to report " + aVar.tU(), th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void d(a aVar, Map<String, String> map) {
        if (x.Fk()) {
            this.logger.f("ErrorReporter", "Reporting " + aVar.tU() + " error...");
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) c(aVar, map).openConnection();
            int i = aEw;
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setReadTimeout(i);
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setDoOutput(false);
            httpURLConnection.setRequestMethod("POST");
            int responseCode = httpURLConnection.getResponseCode();
            if (x.Fk()) {
                this.logger.f("ErrorReporter", aVar.tU() + " reported with code " + responseCode);
            }
            this.aEy.put(aVar, Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th) {
            if (x.Fk()) {
                this.logger.b("ErrorReporter", "Failed to report " + aVar.tU(), th);
            }
        }
    }

    private URL c(a aVar, Map<String, String> map) throws MalformedURLException, UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder("https://ms.applovin.com/1.0/sdk/error");
        sb.append("?");
        Iterator<Map.Entry<String, String>> it = d(aVar.tU(), map).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            String strEncode = URLEncoder.encode(next.getKey(), "UTF-8");
            sb.append(strEncode).append("=").append(URLEncoder.encode(next.getValue(), "UTF-8"));
            if (it.hasNext()) {
                sb.append("&");
            }
        }
        return new URL(sb.toString());
    }

    private Map<String, String> d(String str, Map<String, String> map) {
        HashMap map2 = new HashMap();
        map2.put("type", str);
        if (this.sdk.BT() != null) {
            map2.put(TapjoyConstants.TJC_PLATFORM, this.sdk.BS().Ea());
        } else {
            map2.put(TapjoyConstants.TJC_PLATFORM, this.sdk.BQ().CU());
        }
        map2.put("applovin_random_token", this.sdk.Bz());
        map2.put("compass_random_token", this.sdk.By());
        map2.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
        map2.put("brand", Build.MANUFACTURER);
        map2.put("brand_name", Build.BRAND);
        map2.put("hardware", Build.HARDWARE);
        map2.put("revision", Build.DEVICE);
        map2.put("os", Build.VERSION.RELEASE);
        map2.put("api_level", String.valueOf(Build.VERSION.SDK_INT));
        map2.put("sdk_version", String.valueOf(AppLovinSdk.VERSION));
        map2.put("aei", String.valueOf(this.sdk.a(com.applovin.impl.sdk.c.b.aKy)));
        map2.put("mei", String.valueOf(this.sdk.a(com.applovin.impl.sdk.c.b.aKz)));
        i(map2);
        j(map2);
        if (map != null) {
            map2.putAll(map);
        }
        return map2;
    }

    private void i(Map<String, String> map) {
        String packageName;
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = n.getApplicationContext().getPackageManager();
            packageName = n.getApplicationContext().getPackageName();
            try {
                packageInfo = packageManager.getPackageInfo(packageName, 0);
            } catch (Throwable unused) {
                packageInfo = null;
            }
        } catch (Throwable unused2) {
            packageName = "";
        }
        map.put(CampaignEx.JSON_KEY_PACKAGE_NAME, packageName);
        map.put(TapjoyConstants.TJC_APP_VERSION_NAME, packageInfo != null ? packageInfo.versionName : "");
        map.put("app_version_code", String.valueOf(packageInfo != null ? packageInfo.versionCode : 0));
    }

    private void j(Map<String, String> map) {
        Object objFa = this.sdk.Cd().Fa();
        if (objFa instanceof com.applovin.impl.sdk.ad.e) {
            map.put("fs_ad_network", ADXLogUtil.PLATFORM_APPLOVIN);
            map.put("fs_ad_creative_id", Long.toString(((com.applovin.impl.sdk.ad.e) objFa).getAdIdNumber()));
        } else if (objFa instanceof com.applovin.impl.mediation.b.a) {
            com.applovin.impl.mediation.b.a aVar = (com.applovin.impl.mediation.b.a) objFa;
            map.put("fs_ad_network", aVar.getNetworkName());
            map.put("fs_ad_creative_id", aVar.getCreativeId());
        } else {
            map.put("fs_ad_network", "None");
            map.put("fs_ad_creative_id", "None");
        }
    }

    private boolean a(a aVar, long j) {
        Long l = this.aEy.get(aVar);
        return System.currentTimeMillis() - (l != null ? l.longValue() : -1L) < j;
    }
}
