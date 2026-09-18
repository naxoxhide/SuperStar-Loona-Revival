package com.kakao.adfit.k;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: ViewableCheck.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\"\b\u0000\u0018\u0000 .2\u00020\u0001:\u0002\u0003\u0005B\u0011\b\u0002\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u000fR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\u000fR\u0016\u0010)\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\u0012¨\u0006/"}, d2 = {"Lcom/kakao/adfit/k/f0;", "", "", "a", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "", "Ljava/lang/String;", "name", "Landroid/view/View;", "Landroid/view/View;", "targetView", "", "J", "minExposedTime", "", "F", "minExposedArea", "", "e", "I", "minWidth", InneractiveMediationDefs.GENDER_FEMALE, "minHeight", "g", "overlayMaxAlpha", "Lkotlin/Function0;", "h", "Lkotlin/jvm/functions/Function0;", "onViewable", "i", "checkInterval", "com/kakao/adfit/k/f0$c", "j", "Lcom/kakao/adfit/k/f0$c;", "handler", CampaignEx.JSON_KEY_AD_K, "startExposedTime", "l", "viewableRatio", "Lcom/kakao/adfit/k/f0$a;", "builder", "<init>", "(Lcom/kakao/adfit/k/f0$a;)V", InneractiveMediationDefs.GENDER_MALE, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class f0 {

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String name;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final View targetView;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final long minExposedTime;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final float minExposedArea;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final int minWidth;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final int minHeight;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final float overlayMaxAlpha;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Function0<Unit> onViewable;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final long checkInterval;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private c handler;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private long startExposedTime;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private float viewableRatio;

    /* JADX INFO: compiled from: ViewableCheck.kt */
    @Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b,\u0010-J\u0014\u0010\u0005\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0005\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\r\u0010\u001b\"\u0004\b\u0005\u0010\u001cR\"\u0010#\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!\"\u0004\b\r\u0010\"R\"\u0010$\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010 \u001a\u0004\b\u0019\u0010!\"\u0004\b\u0005\u0010\"R\"\u0010(\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001cR(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b&\u0010)\u001a\u0004\b%\u0010*\"\u0004\b\r\u0010+¨\u0006."}, d2 = {"Lcom/kakao/adfit/k/f0$a;", "", "Lkotlin/Function0;", "", "onViewable", "a", "Lcom/kakao/adfit/k/f0;", "", "Ljava/lang/String;", InneractiveMediationDefs.GENDER_FEMALE, "()Ljava/lang/String;", "name", "Landroid/view/View;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/view/View;", "i", "()Landroid/view/View;", "targetView", "", "c", "J", "()J", "(J)V", "minExposedTime", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "F", "()F", "(F)V", "minExposedArea", "", "e", "I", "()I", "(I)V", "minWidth", "minHeight", "g", "h", "setOverlayMaxAlpha", "overlayMaxAlpha", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "<init>", "(Ljava/lang/String;Landroid/view/View;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final String name;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final View targetView;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private long minExposedTime;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private float minExposedArea;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private int minWidth;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        private int minHeight;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        private float overlayMaxAlpha;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        public Function0<Unit> onViewable;

        public a(String name, View targetView) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(targetView, "targetView");
            this.name = name;
            this.targetView = targetView;
            this.minExposedTime = 1000L;
            this.minExposedArea = 0.5f;
            Context context = targetView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "targetView.context");
            this.minWidth = j.b(context, 200);
            Context context2 = targetView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "targetView.context");
            this.minHeight = j.b(context2, 50);
            Companion companion = f0.INSTANCE;
            Context context3 = targetView.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "targetView.context");
            this.overlayMaxAlpha = companion.a(context3);
        }

        public final void a(long j) {
            this.minExposedTime = j;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final float getMinExposedArea() {
            return this.minExposedArea;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final long getMinExposedTime() {
            return this.minExposedTime;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final int getMinHeight() {
            return this.minHeight;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final int getMinWidth() {
            return this.minWidth;
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final Function0<Unit> g() {
            Function0<Unit> function0 = this.onViewable;
            if (function0 != null) {
                return function0;
            }
            Intrinsics.throwUninitializedPropertyAccessException("onViewable");
            return null;
        }

        /* JADX INFO: renamed from: h, reason: from getter */
        public final float getOverlayMaxAlpha() {
            return this.overlayMaxAlpha;
        }

        /* JADX INFO: renamed from: i, reason: from getter */
        public final View getTargetView() {
            return this.targetView;
        }

        public final void a(float f) {
            this.minExposedArea = f;
        }

        public final void b(int i) {
            this.minWidth = i;
        }

        public final void a(int i) {
            this.minHeight = i;
        }

        public final void b(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "<set-?>");
            this.onViewable = function0;
        }

        public final a a(Function0<Unit> onViewable) {
            Intrinsics.checkNotNullParameter(onViewable, "onViewable");
            b(onViewable);
            return this;
        }

        public final f0 a() {
            return new f0(this, null);
        }
    }

    /* JADX INFO: renamed from: com.kakao.adfit.k.f0$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ViewableCheck.kt */
    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/kakao/adfit/k/f0$b;", "", "", "a", "Landroid/content/Context;", "context", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "DEFAULT_MIN_EXPOSED_AREA", "F", "", "DEFAULT_MIN_EXPOSED_TIME", "J", "", "DEFAULT_MIN_HEIGHT", "I", "DEFAULT_MIN_WIDTH", "", "META_ALLOW_ALPHA", "Ljava/lang/String;", "MIN_CHECK_INTERVAL", "MSG_CHECK", "OVERLAY_LAYER_MAX_ALPHA_IF_ALLOWED", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float a(float f) {
            if (0.0f <= f && f <= 1.0f) {
                return f;
            }
            return f <= 0.0f ? 0.0f : 1.0f;
        }

        private final boolean b(Context context) {
            return false;
        }

        @JvmStatic
        public final float a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            boolean zB = b(context);
            if (zB) {
                return 0.72f;
            }
            if (zB) {
                throw new NoWhenBranchMatchedException();
            }
            return 0.0f;
        }
    }

    /* JADX INFO: compiled from: ViewableCheck.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/kakao/adfit/k/f0$c", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            if (msg.what == 0) {
                f0.this.a();
            }
        }
    }

    private f0(a aVar) {
        this.name = aVar.getName();
        this.targetView = aVar.getTargetView();
        long jMax = Math.max(aVar.getMinExposedTime(), 0L);
        this.minExposedTime = jMax;
        Companion companion = INSTANCE;
        this.minExposedArea = companion.a(aVar.getMinExposedArea());
        this.minWidth = aVar.getMinWidth();
        this.minHeight = aVar.getMinHeight();
        this.overlayMaxAlpha = companion.a(aVar.getOverlayMaxAlpha());
        this.onViewable = aVar.g();
        this.checkInterval = Math.max(jMax / ((long) 5), 500L);
        this.handler = new c(Looper.getMainLooper());
        this.startExposedTime = -1L;
        this.viewableRatio = -1.0f;
    }

    public /* synthetic */ f0(a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar);
    }

    private final boolean b() {
        if (!this.targetView.hasWindowFocus()) {
            this.startExposedTime = -1L;
            this.viewableRatio = -1.0f;
            return false;
        }
        float fA = g0.a(this.targetView, this.minWidth, this.minHeight, this.overlayMaxAlpha);
        if (!(this.viewableRatio == fA)) {
            this.viewableRatio = fA;
            if (fA > 0.0f) {
                StringBuilder sbAppend = new StringBuilder().append(this.name).append(" is exposed: ratio = ");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("%.2f%%", Arrays.copyOf(new Object[]{Float.valueOf(100 * fA)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                f.d(sbAppend.append(str).toString());
            } else {
                f.d(this.name + " is not exposed");
            }
        }
        if (fA < this.minExposedArea) {
            this.startExposedTime = -1L;
            return false;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.startExposedTime;
        if (j > 0) {
            return jElapsedRealtime - j >= this.minExposedTime;
        }
        this.startExposedTime = jElapsedRealtime;
        return false;
    }

    public final void c() {
        if (this.handler.hasMessages(0)) {
            return;
        }
        this.startExposedTime = -1L;
        this.viewableRatio = -1.0f;
        this.handler.sendEmptyMessage(0);
    }

    public final void d() {
        this.handler.removeMessages(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        if (b()) {
            this.onViewable.invoke();
        } else {
            this.handler.sendEmptyMessageDelayed(0, this.checkInterval);
        }
    }
}
