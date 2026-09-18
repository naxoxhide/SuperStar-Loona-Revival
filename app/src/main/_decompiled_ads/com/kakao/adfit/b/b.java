package com.kakao.adfit.b;

import android.content.Context;
import android.os.Bundle;
import com.adxcorp.ads.common.AdConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.ads.OutOfContextTestingActivity;
import com.kakao.adfit.ads.AdListener;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BannerAdConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000f\b\u0000\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001\u0007B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\bK\u0010LJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u001a\u0010\u0015\u001a\u00020\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00038\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR.\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0007\u0010\u001a\"\u0004\b\u0007\u0010\u001cR \u0010%\u001a\b\u0012\u0004\u0012\u00020!0 8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010$R\"\u0010*\u001a\u00020!8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010&\u001a\u0004\b'\u0010(\"\u0004\b\u0007\u0010)R*\u0010+\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00038\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0018\u001a\u0004\b,\u0010\u001a\"\u0004\b-\u0010\u001cR&\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030.8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R$\u00109\u001a\u0004\u0018\u0001048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b/\u00107\"\u0004\b\u0007\u00108R\"\u0010=\u001a\u00020\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b1\u0010:\u001a\u0004\b5\u0010;\"\u0004\b\t\u0010<R*\u0010D\u001a\u00020>2\u0006\u0010?\u001a\u00020>8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\b@\u0010B\"\u0004\b\u0007\u0010CR*\u0010E\u001a\u00020\f2\u0006\u0010?\u001a\u00020\f8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b,\u0010:\u001a\u0004\b\u0017\u0010;\"\u0004\b\u0017\u0010<R.\u0010J\u001a\u0004\u0018\u00010\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u00038V@VX\u0097\u000e¢\u0006\u0012\u0012\u0004\bH\u0010I\u001a\u0004\bF\u0010\u001a\"\u0004\bG\u0010\u001c¨\u0006M"}, d2 = {"Lcom/kakao/adfit/b/b;", "Lcom/kakao/adfit/a/b;", "", "", "name", "value", "", "a", "Landroid/os/Bundle;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "o", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "", "errorCode", "Lcom/kakao/adfit/b/c;", "Lcom/kakao/adfit/b/c;", "view", "Landroid/content/Context;", "Landroid/content/Context;", "e", "()Landroid/content/Context;", "context", "url", "c", "Ljava/lang/String;", InneractiveMediationDefs.GENDER_FEMALE, "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "baseUrl", "id", OutOfContextTestingActivity.AD_UNIT_KEY, "Lkotlin/Function0;", "", "Lkotlin/jvm/functions/Function0;", "g", "()Lkotlin/jvm/functions/Function0;", "isForeground", "Z", "n", "()Z", "(Z)V", "isTestMode", "appId", "l", "setAppId", "", "h", "Ljava/util/Map;", "j", "()Ljava/util/Map;", "extraMap", "Lcom/kakao/adfit/ads/AdListener;", "i", "Lcom/kakao/adfit/ads/AdListener;", "()Lcom/kakao/adfit/ads/AdListener;", "(Lcom/kakao/adfit/ads/AdListener;)V", "adListener", "I", "()I", "(I)V", "refreshSequence", "", "ms", CampaignEx.JSON_KEY_AD_K, "J", "()J", "(J)V", "refreshInterval", "requestTimeout", InneractiveMediationDefs.GENDER_MALE, "setClientId", "getClientId$annotations", "()V", "clientId", "<init>", "(Lcom/kakao/adfit/b/c;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class b implements com.kakao.adfit.a.b {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final c view;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private String baseUrl;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private String adUnit;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final Function0<Boolean> isForeground;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private boolean isTestMode;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private String appId;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Map<String, String> extraMap;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private AdListener adListener;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private int refreshSequence;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private long refreshInterval;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private int requestTimeout;

    /* JADX INFO: renamed from: com.kakao.adfit.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BannerAdConfig.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0})
    static final class C0446b extends Lambda implements Function0<Boolean> {
        C0446b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(b.this.view.b() && b.this.view.isVisible() && b.this.view.f() && b.this.view.a());
        }
    }

    public b(c view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        Context applicationContext = view.getA().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "view.context.applicationContext");
        this.context = applicationContext;
        this.baseUrl = "https://display.ad.daum.net/sdk/banner";
        this.isForeground = new C0446b();
        String packageName = view.getA().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "view.context.packageName");
        this.appId = packageName;
        this.extraMap = new LinkedHashMap();
        this.refreshInterval = 60000L;
        this.requestTimeout = 3000;
    }

    public void b(int i) {
        this.refreshSequence = i;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public int getRequestTimeout() {
        return this.requestTimeout;
    }

    public void d() {
        com.kakao.adfit.a.b.a.b(this);
    }

    @Override // com.kakao.adfit.a.b
    /* JADX INFO: renamed from: e, reason: from getter */
    public Context getContext() {
        return this.context;
    }

    @Override // com.kakao.adfit.a.b
    /* JADX INFO: renamed from: f, reason: from getter */
    public String getBaseUrl() {
        return this.baseUrl;
    }

    @Override // com.kakao.adfit.a.b
    public Function0<Boolean> g() {
        return this.isForeground;
    }

    @Override // com.kakao.adfit.a.b
    /* JADX INFO: renamed from: h, reason: from getter */
    public AdListener getAdListener() {
        return this.adListener;
    }

    @Override // com.kakao.adfit.a.b
    /* JADX INFO: renamed from: i, reason: from getter */
    public int getRefreshSequence() {
        return this.refreshSequence;
    }

    @Override // com.kakao.adfit.a.b
    public Map<String, String> j() {
        return this.extraMap;
    }

    @Override // com.kakao.adfit.a.b
    /* JADX INFO: renamed from: k, reason: from getter */
    public long getRefreshInterval() {
        return this.refreshInterval;
    }

    @Override // com.kakao.adfit.a.b
    /* JADX INFO: renamed from: l, reason: from getter */
    public String getAppId() {
        return this.appId;
    }

    @Override // com.kakao.adfit.a.b
    public String m() {
        return getAdUnit();
    }

    @Override // com.kakao.adfit.a.b
    /* JADX INFO: renamed from: n, reason: from getter */
    public boolean getIsTestMode() {
        return this.isTestMode;
    }

    public void o() {
        com.kakao.adfit.a.b.a.c(this);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public String getAdUnit() {
        return this.adUnit;
    }

    public Bundle b() {
        return com.kakao.adfit.a.b.a.a(this);
    }

    public void c(int i) {
        this.requestTimeout = Math.max(i, 1000);
    }

    public void a(String str) {
        if (str != null && (StringsKt.isBlank(str) ^ true)) {
            this.adUnit = str;
        }
    }

    public void a(boolean z) {
        this.isTestMode = z;
    }

    public void a(AdListener adListener) {
        this.adListener = adListener;
    }

    public void a(long j) {
        if (getIsTestMode()) {
            j = Math.max(j, 0L);
        } else if (j <= 0) {
            j = 0;
        } else if (j <= 30000) {
            j = 30000;
        } else if (j >= AdConstants.MEDIATION_CUSTOM_EVENT_TIMEOUT) {
            j = 120000;
        }
        this.refreshInterval = j;
    }

    public void a(String name, String value) {
        com.kakao.adfit.a.b.a.a(this, name, value);
    }

    public void a(int errorCode) {
        com.kakao.adfit.a.b.a.a(this, errorCode);
    }
}
