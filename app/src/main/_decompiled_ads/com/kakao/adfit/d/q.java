package com.kakao.adfit.d;

import android.content.Context;
import android.util.SparseArray;
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
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: NativeAdConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\bG\u0010HR\u001a\u0010\b\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R*\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R.\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0004\u0010\u000e\"\u0004\b\u0004\u0010\u0010R(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u0004\u0010\u001bR\"\u0010!\u001a\u00020\u00168\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b\u0004\u0010 R*\u0010\"\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\f\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0010R\"\u0010+\u001a\u00020%8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00103\u001a\u00020,8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R&\u00108\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u00105\u001a\u0004\b6\u00107R$\u0010>\u001a\u0004\u0018\u0001098\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b6\u0010:\u001a\u0004\b-\u0010;\"\u0004\b<\u0010=R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010@R.\u0010F\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t8V@VX\u0097\u000e¢\u0006\u0012\u0012\u0004\bD\u0010E\u001a\u0004\bB\u0010\u000e\"\u0004\bC\u0010\u0010¨\u0006I"}, d2 = {"Lcom/kakao/adfit/d/q;", "Lcom/kakao/adfit/a/b;", "", "Landroid/content/Context;", "a", "Landroid/content/Context;", "e", "()Landroid/content/Context;", "context", "", "url", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", InneractiveMediationDefs.GENDER_FEMALE, "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "baseUrl", "id", "c", OutOfContextTestingActivity.AD_UNIT_KEY, "Lkotlin/Function0;", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Lkotlin/jvm/functions/Function0;", "g", "()Lkotlin/jvm/functions/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "isForeground", "Z", "n", "()Z", "(Z)V", "isTestMode", "appId", "l", "setAppId", "", "I", "i", "()I", "setRefreshSequence", "(I)V", "refreshSequence", "", "h", "J", CampaignEx.JSON_KEY_AD_K, "()J", "setRefreshInterval", "(J)V", "refreshInterval", "", "Ljava/util/Map;", "j", "()Ljava/util/Map;", "extraMap", "Lcom/kakao/adfit/ads/AdListener;", "Lcom/kakao/adfit/ads/AdListener;", "()Lcom/kakao/adfit/ads/AdListener;", "setAdListener", "(Lcom/kakao/adfit/ads/AdListener;)V", "adListener", "Landroid/util/SparseArray;", "Landroid/util/SparseArray;", "mKeyedTags", InneractiveMediationDefs.GENDER_MALE, "setClientId", "getClientId$annotations", "()V", "clientId", "<init>", "(Landroid/content/Context;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class q implements com.kakao.adfit.a.b {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Context context;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String baseUrl;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private String adUnit;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public Function0<Boolean> isForeground;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private boolean isTestMode;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private String appId;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private int refreshSequence;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private long refreshInterval;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final Map<String, String> extraMap;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private AdListener adListener;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final SparseArray<Object> mKeyedTags;

    public q(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.context = applicationContext;
        this.baseUrl = "https://display.ad.daum.net/sdk/native";
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        this.appId = packageName;
        this.extraMap = new LinkedHashMap();
        this.mKeyedTags = new SparseArray<>();
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public String getAdUnit() {
        return this.adUnit;
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
        Function0<Boolean> function0 = this.isForeground;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("isForeground");
        return null;
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

    public void a(String str) {
        if (str != null && (StringsKt.isBlank(str) ^ true)) {
            this.adUnit = str;
        }
    }

    public void a(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.isForeground = function0;
    }

    public void a(boolean z) {
        this.isTestMode = z;
    }
}
