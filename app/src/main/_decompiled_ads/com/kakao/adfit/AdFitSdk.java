package com.kakao.adfit;

import android.content.Context;
import com.android.billingclient.api.BillingFlowParams;
import com.kakao.adfit.k.q;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdFitSdk.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J \u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/kakao/adfit/AdFitSdk;", "", "()V", "BUILD_ID", "", "SDK_VERSION", "clearKakaoAccountInfo", "", "setKakaoAccountId", "context", "Landroid/content/Context;", BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "setKakaoUserId", "appKey", "appUserId", "", "library_networkRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AdFitSdk {
    public static final String BUILD_ID = "f1250a8a-1aac-4206-aaaa-acb32eeb9eb3";
    public static final AdFitSdk INSTANCE = new AdFitSdk();
    public static final String SDK_VERSION = "3.13.6";

    private AdFitSdk() {
    }

    @JvmStatic
    public static final void clearKakaoAccountInfo() {
        q.a.a();
    }

    @JvmStatic
    public static final void setKakaoAccountId(Context context, String accountId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        q.a.a(context, accountId);
    }

    @JvmStatic
    public static final void setKakaoUserId(Context context, String appKey, long appUserId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        q.a.a(context, appKey, appUserId);
    }
}
