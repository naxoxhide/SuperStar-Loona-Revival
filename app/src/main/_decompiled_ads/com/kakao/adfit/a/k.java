package com.kakao.adfit.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.graphics.Point;
import android.net.Uri;
import android.view.Display;
import com.android.billingclient.api.BillingFlowParams;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.ads.mediation.pangle.PangleConstants;
import com.kakao.adfit.AdFitSdk;
import com.kakao.adfit.ads.AdError;
import com.kakao.adfit.ads.AdException;
import com.kakao.adfit.k.a0;
import com.kakao.adfit.k.q;
import com.kakao.adfit.k.t;
import com.kakao.adfit.k.v;
import com.kakao.adfit.k.w;
import com.kakao.adfit.k.y;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdUrlBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b3\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 s2\u00020\u0001:\u0002\u0005\nB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bn\u0010oB\u0011\b\u0016\u0012\u0006\u0010q\u001a\u00020p¢\u0006\u0004\bn\u0010rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u0007*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0006\u0010\u0005\u001a\u00020\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\bR.\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\n\u0010\u000eR.\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0016\u001a\u00020\u00078\u0006X\u0086D¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u001a\u0010\u0019\u001a\u00020\u00078\u0006X\u0086D¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\rR\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u0005\u0010\u001eR\u0017\u0010#\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R*\u0010'\u001a\u00020 2\u0006\u0010%\u001a\u00020 8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010$\"\u0004\b\u0005\u0010(R.\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00103\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010\u001b\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001eR\"\u00107\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u001b\u001a\u0004\b5\u0010\u001d\"\u0004\b6\u0010\u001eR*\u00108\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010\u000b\u001a\u0004\b:\u0010\r\"\u0004\b\u0005\u0010\u000eR*\u0010?\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010\u000b\u001a\u0004\b=\u0010\r\"\u0004\b>\u0010\u000eR\u0019\u0010B\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b@\u0010\u000b\u001a\u0004\bA\u0010\rR\u0017\u0010D\u001a\u00020 8\u0006¢\u0006\f\n\u0004\bC\u0010\"\u001a\u0004\bD\u0010$R\u0017\u0010G\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\bE\u0010\u000b\u001a\u0004\bF\u0010\rR\u0017\u0010J\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\bH\u0010\u000b\u001a\u0004\bI\u0010\rR\u0017\u0010M\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\bK\u0010\u000b\u001a\u0004\bL\u0010\rR\u0017\u0010P\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\bN\u0010\u000b\u001a\u0004\bO\u0010\rR\u0017\u0010S\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\bQ\u0010\u000b\u001a\u0004\bR\u0010\rR\u0017\u0010Y\u001a\u00020T8\u0006¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR$\u0010\\\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0017\u0010a\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b`\u0010\"\u001a\u0004\ba\u0010$R\u0019\u0010d\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\bb\u0010\u000b\u001a\u0004\bc\u0010\rR\u0019\u0010g\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\be\u0010\u000b\u001a\u0004\bf\u0010\rR\u0019\u0010j\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\bh\u0010\u000b\u001a\u0004\bi\u0010\rR\u0019\u0010m\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\bk\u0010\u000b\u001a\u0004\bl\u0010\r¨\u0006t"}, d2 = {"Lcom/kakao/adfit/a/k;", "", "Landroid/content/Context;", "context", "", "a", "", "", "Landroid/content/Context;", "url", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "getBaseUrl", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "baseUrl", "id", "c", "getClientId", "clientId", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "getSdkType", "sdkType", "e", "getSdkVersion", "sdkVersion", InneractiveMediationDefs.GENDER_FEMALE, "I", "getAdCount", "()I", "(I)V", "adCount", "", "g", "Z", "isEmulator", "()Z", "enabled", "h", "isTestMode", "(Z)V", "i", "Ljava/util/Map;", "getExtraMap", "()Ljava/util/Map;", "setExtraMap", "(Ljava/util/Map;)V", "extraMap", "j", "getRefreshSequence", "setRefreshSequence", "refreshSequence", CampaignEx.JSON_KEY_AD_K, "getRefreshInterval", "setRefreshInterval", "refreshInterval", "appId", "l", "getAppId", "version", InneractiveMediationDefs.GENDER_MALE, "getAppVersion", "setAppVersion", "appVersion", "n", "getAdId", "adId", "o", "isAdTrackingLimited", "p", "getDeviceModel", "deviceModel", CampaignEx.JSON_KEY_AD_Q, "getOsName", "osName", CampaignEx.JSON_KEY_AD_R, "getOsVersion", "osVersion", "s", "getNetworkConnectionType", "networkConnectionType", "t", "getSdkId", "sdkId", "", "u", "J", "getRwbdt", "()J", "rwbdt", "v", "Ljava/lang/Boolean;", "isForeground", "()Ljava/lang/Boolean;", "setForeground", "(Ljava/lang/Boolean;)V", "w", "isRooted", "x", "getAppKey", "appKey", "y", "getAppUserId", "appUserId", "z", "getAccountId", BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "A", "getEacid", "eacid", "<init>", "(Landroid/content/Context;)V", "Lcom/kakao/adfit/a/b;", "config", "(Lcom/kakao/adfit/a/b;)V", "B", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class k {
    private static String C;
    private static String D;

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private final String eacid;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Context context;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String baseUrl;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private String clientId;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final String sdkType;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final String sdkVersion;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private int adCount;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final boolean isEmulator;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private boolean isTestMode;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private Map<String, String> extraMap;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private int refreshSequence;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private int refreshInterval;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private String appId;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private String appVersion;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final String adId;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final boolean isAdTrackingLimited;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final String deviceModel;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private final String osName;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private final String osVersion;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private final String networkConnectionType;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private final String sdkId;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    private final long rwbdt;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    private Boolean isForeground;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    private final boolean isRooted;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    private final String appKey;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    private final String appUserId;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    private final String accountId;

    /* JADX INFO: compiled from: AdUrlBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0016R\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/kakao/adfit/a/k$b;", "", "", SDKConstants.PARAM_KEY, "value", "", "a", "toString", "Landroid/net/Uri$Builder;", "Landroid/net/Uri$Builder;", "getBuilder", "()Landroid/net/Uri$Builder;", "builder", "baseUrl", "<init>", "(Ljava/lang/String;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    private static final class b {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final Uri.Builder builder;

        public b(String baseUrl) {
            Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
            Uri.Builder builderBuildUpon = Uri.parse(baseUrl).buildUpon();
            Intrinsics.checkNotNull(builderBuildUpon);
            this.builder = builderBuildUpon;
        }

        public final void a(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Uri.Builder builder = this.builder;
            if (value == null) {
                return;
            }
            builder.appendQueryParameter(key, value);
        }

        public String toString() {
            String string = this.builder.toString();
            Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
            return string;
        }
    }

    public k(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.sdkType = "android";
        this.sdkVersion = AdFitSdk.SDK_VERSION;
        this.adCount = 1;
        boolean zM = com.kakao.adfit.k.i.m();
        this.isEmulator = zM;
        this.extraMap = MapsKt.emptyMap();
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        this.appId = packageName;
        this.appVersion = w.b(context);
        if (zM) {
            this.adId = "emulator";
            this.isAdTrackingLimited = false;
        } else {
            com.kakao.adfit.k.e eVarB = com.kakao.adfit.k.d.b(context);
            Intrinsics.checkNotNullExpressionValue(eVarB, "getInfo(context)");
            if (eVarB.b()) {
                this.adId = null;
                this.isAdTrackingLimited = eVarB.b();
            } else {
                this.adId = eVarB.a();
                this.isAdTrackingLimited = eVarB.b();
            }
        }
        this.deviceModel = com.kakao.adfit.k.i.h();
        this.osName = v.c();
        this.osVersion = v.d();
        this.networkConnectionType = String.valueOf(a(context));
        a0 a0Var = a0.a;
        this.sdkId = a0Var.c(context);
        this.rwbdt = a0Var.b(context);
        this.isRooted = y.c(context);
        q qVar = q.a;
        this.appKey = qVar.c();
        Long lD = qVar.d();
        this.appUserId = lD != null ? lD.toString() : null;
        this.accountId = qVar.b();
        this.eacid = qVar.e();
    }

    public final void a(int i) {
        this.adCount = i;
    }

    public final void a(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
    }

    public final void b(String str) {
        if (str != null && (StringsKt.isBlank(str) ^ true)) {
            this.baseUrl = str;
        }
    }

    public final void c(String str) {
        if (str != null && (StringsKt.isBlank(str) ^ true)) {
            this.clientId = str;
        }
    }

    public final void a(boolean z) {
        this.isTestMode = z || this.isEmulator;
    }

    public final String a() throws AdException {
        String str;
        String str2 = this.baseUrl;
        if (str2 != null) {
            String str3 = this.clientId;
            if (str3 != null) {
                Boolean bool = this.isForeground;
                if (bool != null) {
                    boolean zBooleanValue = bool.booleanValue();
                    b bVar = new b(str2);
                    bVar.a("id", str3);
                    bVar.a("sdktype", this.sdkType);
                    bVar.a("sdkver", this.sdkVersion);
                    bVar.a("cnt", String.valueOf(this.adCount));
                    bVar.a("test", this.isTestMode ? "Y" : null);
                    bVar.a("ctag", a(this.extraMap));
                    bVar.a("ukeyword", this.extraMap.get("ukeyword"));
                    bVar.a("exckeywords", this.extraMap.get("exckeywords"));
                    int i = this.refreshSequence;
                    bVar.a("rfseq", i > 0 ? String.valueOf(i) : null);
                    int i2 = this.refreshInterval;
                    bVar.a("rfinterval", i2 > 0 ? String.valueOf(i2) : null);
                    bVar.a(PangleConstants.APP_ID, this.appId);
                    bVar.a("appver", this.appVersion);
                    bVar.a("adid", this.adId);
                    bVar.a("lmt", this.isAdTrackingLimited ? "Y" : "N");
                    bVar.a("dev", this.deviceModel);
                    bVar.a("os", this.osName);
                    bVar.a("osver", this.osVersion);
                    bVar.a("network", this.networkConnectionType);
                    bVar.a("sdkid", this.sdkId);
                    bVar.a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, zBooleanValue ? "F" : "B");
                    bVar.a(CampaignEx.JSON_KEY_AD_R, this.isRooted ? "R" : "N");
                    long j = this.rwbdt;
                    bVar.a("rwbdt", j > 0 ? String.valueOf(j) : null);
                    bVar.a("appkey", this.appKey);
                    bVar.a("appuserid", this.appUserId);
                    bVar.a("accid", this.accountId);
                    bVar.a("eacid", this.eacid);
                    try {
                        String packageName = this.context.getPackageName();
                        String strA = C;
                        String strA2 = D;
                        String str4 = "unknown";
                        if (strA == null || strA2 == null) {
                            Context context = this.context;
                            Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
                            Signature signatureB = w.b(context, packageName);
                            if (signatureB != null) {
                                if (strA == null) {
                                    strA = w.a(signatureB, SameMD5.TAG);
                                    if (!Intrinsics.areEqual(strA, "unknown")) {
                                        C = strA;
                                    }
                                }
                                if (strA2 == null) {
                                    strA2 = w.a(signatureB, "SHA-1");
                                    if (!Intrinsics.areEqual(strA2, "unknown")) {
                                        D = strA2;
                                    }
                                }
                            }
                        }
                        bVar.a("apkhash", strA);
                        bVar.a("certificatehash", strA2);
                        Context context2 = this.context;
                        Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
                        if (w.d(context2, packageName)) {
                            bVar.a("appactive", "Y");
                        }
                        bVar.a("appinstaller", w.a(this.context, packageName));
                        bVar.a("cpucount", String.valueOf(com.kakao.adfit.k.i.c()));
                        bVar.a("deviceuptime", String.valueOf(com.kakao.adfit.k.i.l()));
                        bVar.a("systemtimezone", com.kakao.adfit.k.i.k());
                        if (com.kakao.adfit.k.i.g(this.context)) {
                            bVar.a("adbenabled", "Y");
                        }
                        if (com.kakao.adfit.k.i.j(this.context)) {
                            bVar.a("usbconnected", "Y");
                        }
                        Intent intentB = com.kakao.adfit.k.i.b(this.context);
                        if (intentB != null) {
                            float fA = com.kakao.adfit.k.i.a(intentB);
                            if (fA >= 0.0f) {
                                str = String.format(Locale.ENGLISH, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(fA)}, 1));
                                Intrinsics.checkNotNullExpressionValue(str, "format(locale, this, *args)");
                            } else {
                                str = "unknown";
                            }
                            bVar.a("batterylevel", str);
                            int iB = com.kakao.adfit.k.i.b(intentB);
                            if (iB != 1) {
                                if (iB == 2) {
                                    str4 = "charging";
                                } else if (iB == 3) {
                                    str4 = "unplugged";
                                } else if (iB == 4) {
                                    str4 = "notcharging";
                                } else if (iB == 5) {
                                    str4 = "full";
                                }
                            }
                            bVar.a("batterystate", str4);
                        }
                        Display displayA = com.kakao.adfit.k.j.a(this.context);
                        Point pointB = com.kakao.adfit.k.j.b(displayA, null, 2, null);
                        bVar.a("screensize", new StringBuilder().append(pointB.x).append('x').append(pointB.y).toString());
                        bVar.a("deviceorientation", String.valueOf(com.kakao.adfit.k.j.a(displayA)));
                    } catch (Throwable th) {
                        com.kakao.adfit.e.f.a.a(th);
                    }
                    return bVar.toString();
                }
                throw new AdException(AdError.SDK_EXCEPTION, "\"isForeground\" is null");
            }
            throw new AdException(AdError.UNKNOWN_CLIENT_ID, "\"clientId\" is null");
        }
        throw new AdException(AdError.SDK_EXCEPTION, "\"baseUrl\" is null");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(com.kakao.adfit.a.b config) {
        this(config.getContext());
        Intrinsics.checkNotNullParameter(config, "config");
        b(config.getBaseUrl());
        c(config.m());
        a(config.getAppId());
        a(config.getIsTestMode());
        this.isForeground = config.g().invoke();
        if (config.getRefreshSequence() > 0) {
            this.refreshSequence = config.getRefreshSequence();
            this.refreshInterval = (int) (config.getRefreshInterval() / 1000);
        }
        if (!config.j().isEmpty()) {
            this.extraMap = config.j();
        }
    }

    private final int a(Context context) {
        int iB = t.b(context);
        if (iB != 1) {
            if (iB != 2) {
                return iB != 3 ? 0 : 1;
            }
            return 2;
        }
        int iA = t.a(context);
        if (iA == 1) {
            return 4;
        }
        if (iA == 2) {
            return 5;
        }
        if (iA != 3) {
            return iA != 4 ? 3 : 7;
        }
        return 6;
    }

    private final String a(Map<String, String> map) {
        if (!(!map.isEmpty())) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!Intrinsics.areEqual(key, "ukeyword") && !Intrinsics.areEqual(key, "exckeywords")) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (Throwable unused) {
                }
            }
        }
        if (jSONObject.length() > 0) {
            return jSONObject.toString();
        }
        return null;
    }
}
