package com.kakao.adfit.k;

import android.content.Context;
import com.android.billingclient.api.BillingFlowParams;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: KakaoAccountInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bR(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000e\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R(\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0013\u0010\u000fR(\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\f\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/kakao/adfit/k/q;", "", "Landroid/content/Context;", "context", "", "appKey", "", "appUserId", "", "a", BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "<set-?>", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "c", "()Ljava/lang/String;", "Ljava/lang/Long;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "()Ljava/lang/Long;", "e", "eacid", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class q {
    public static final q a = new q();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String appKey;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static Long appUserId;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private static String eacid;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private static String accountId;

    /* JADX INFO: compiled from: KakaoAccountInfo.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/kakao/adfit/k/n;", "response", "", "a", "(Lcom/kakao/adfit/k/n;)V"}, k = 3, mv = {1, 6, 0})
    static final class a extends Lambda implements Function1<n, Unit> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f1836b;
        final /* synthetic */ long c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, long j) {
            super(1);
            this.f1836b = str;
            this.c = j;
        }

        public final void a(n response) {
            Intrinsics.checkNotNullParameter(response, "response");
            if (Intrinsics.areEqual(q.this.c(), this.f1836b)) {
                Long lD = q.this.d();
                long j = this.c;
                if (lD != null && lD.longValue() == j) {
                    q.eacid = response.getEacid();
                }
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(n nVar) {
            a(nVar);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: KakaoAccountInfo.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 6, 0})
    static final class b extends Lambda implements Function1<String, Unit> {
        public static final b a = new b();

        b() {
            super(1);
        }

        public final void a(String str) {
            f.b("Failed to get eacid: " + str);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            a(str);
            return Unit.INSTANCE;
        }
    }

    private q() {
    }

    public final String b() {
        return accountId;
    }

    public final String c() {
        return appKey;
    }

    public final Long d() {
        return appUserId;
    }

    public final String e() {
        return eacid;
    }

    public final void a(Context context, String appKey2, long appUserId2) {
        Long l;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appKey2, "appKey");
        if (Intrinsics.areEqual(appKey, appKey2) && (l = appUserId) != null && l.longValue() == appUserId2) {
            return;
        }
        z.a.b(context);
        appKey = appKey2;
        appUserId = Long.valueOf(appUserId2);
        eacid = null;
        new m(context).a(appKey2, String.valueOf(appUserId2), new a(appKey2, appUserId2), b.a);
    }

    public final void a(Context context, String accountId2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accountId2, "accountId");
        z.a.b(context);
        accountId = accountId2;
    }

    public final void a() {
        appKey = null;
        appUserId = null;
        eacid = null;
        accountId = null;
    }
}
