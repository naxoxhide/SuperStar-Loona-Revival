package com.kakao.adfit.k;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: ViewableTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0005B5\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\bH\u0002J\u001a\u0010\u0005\u001a\u00020\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\tR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u0012R*\u0010+\u001a\u00020$2\u0006\u0010%\u001a\u00020$8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b\u0005\u0010*¨\u0006."}, d2 = {"Lcom/kakao/adfit/k/h0;", "", "Lcom/kakao/adfit/k/h0$a;", "observer", "", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", "", "Lkotlin/Function1;", "onNext", "Lcom/kakao/adfit/k/k;", "", "Ljava/lang/String;", "name", "Landroid/view/View;", "Landroid/view/View;", "targetView", "F", "minRatio", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "overlayMaxAlpha", "", "e", "J", "checkInterval", "Landroid/os/Handler;", InneractiveMediationDefs.GENDER_FEMALE, "Landroid/os/Handler;", "handler", "Ljava/util/concurrent/CopyOnWriteArrayList;", "g", "Ljava/util/concurrent/CopyOnWriteArrayList;", "observers", "h", "viewableRatio", "", "value", "i", "Z", "getEnabled", "()Z", "(Z)V", "enabled", "<init>", "(Ljava/lang/String;Landroid/view/View;FFJ)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class h0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String name;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final View targetView;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final float minRatio;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final float overlayMaxAlpha;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final long checkInterval;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final Handler handler;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final CopyOnWriteArrayList<a> observers;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private float viewableRatio;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private boolean enabled;

    public h0(String name, View targetView, float f, float f2, long j) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        this.name = name;
        this.targetView = targetView;
        this.minRatio = f;
        this.overlayMaxAlpha = f2;
        this.checkInterval = j;
        this.handler = new Handler(Looper.getMainLooper());
        this.observers = new CopyOnWriteArrayList<>();
        this.viewableRatio = -1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(h0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.enabled || this$0.observers.isEmpty()) {
            return;
        }
        this$0.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        float fB = b();
        if (!(this.viewableRatio == fB)) {
            this.viewableRatio = fB;
            if (fB > 0.0f) {
                StringBuilder sbAppend = new StringBuilder().append(this.name).append(" is exposed: ratio = ");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("%.2f%%", Arrays.copyOf(new Object[]{Float.valueOf(100 * fB)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                f.d(sbAppend.append(str).toString());
            } else {
                f.d(this.name + " is not exposed");
            }
        }
        Iterator<T> it = this.observers.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(fB);
        }
        if (this.enabled && (!this.observers.isEmpty())) {
            this.handler.postDelayed(new Runnable() { // from class: com.kakao.adfit.k.-$$Lambda$h0$O3ai-0NbeXpGJj9M9W3qS4bmMO0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.c();
                }
            }, this.checkInterval);
        }
    }

    public final void a(boolean z) {
        if (this.enabled != z) {
            this.enabled = z;
            this.viewableRatio = -1.0f;
            if (!this.observers.isEmpty()) {
                if (z) {
                    c();
                } else {
                    a();
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewableTracker.kt */
    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR$\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0007\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/kakao/adfit/k/h0$a;", "Lcom/kakao/adfit/k/k;", "", "a", "", "viewableRatio", "Lcom/kakao/adfit/k/h0;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/k/h0;", "parent", "Lkotlin/Function1;", "c", "Lkotlin/jvm/functions/Function1;", "downStream", "", "<set-?>", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Z", "()Z", "isDisposed", "<init>", "(Lcom/kakao/adfit/k/h0;Lkotlin/jvm/functions/Function1;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    private static final class a implements k {

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final h0 parent;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final Function1<Float, Unit> downStream;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private boolean isDisposed;

        /* JADX WARN: Multi-variable type inference failed */
        public a(h0 parent, Function1<? super Float, Unit> downStream) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(downStream, "downStream");
            this.parent = parent;
            this.downStream = downStream;
        }

        @Override // com.kakao.adfit.k.k
        public void a() {
            if (getIsDisposed()) {
                return;
            }
            this.parent.b(this);
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public boolean getIsDisposed() {
            return this.isDisposed;
        }

        public final void a(float viewableRatio) {
            if (getIsDisposed()) {
                return;
            }
            this.downStream.invoke(Float.valueOf(viewableRatio));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(a observer) {
        if (this.observers.isEmpty()) {
            return;
        }
        this.observers.remove(observer);
        if (!this.enabled || this.observers.isEmpty()) {
            a();
        }
    }

    public final k a(Function1<? super Float, Unit> onNext) {
        Intrinsics.checkNotNullParameter(onNext, "onNext");
        a aVar = new a(this, onNext);
        a(aVar);
        return aVar;
    }

    private final void a(a observer) {
        if (this.enabled && this.observers.isEmpty()) {
            this.viewableRatio = -1.0f;
            this.handler.post(new Runnable() { // from class: com.kakao.adfit.k.-$$Lambda$h0$FOp6mRTF11o_cO-PkCPppcvmybE
                @Override // java.lang.Runnable
                public final void run() {
                    h0.b(this.f$0);
                }
            });
        }
        this.observers.add(observer);
    }

    private final float b() {
        Context context = this.targetView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!i.i(context)) {
            Context context2 = this.targetView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "targetView.context");
            if (i.h(context2)) {
                return 0.0f;
            }
        }
        if (this.targetView.hasWindowFocus()) {
            return g0.a(this.targetView, this.overlayMaxAlpha);
        }
        return 0.0f;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ h0(String str, View view, float f, float f2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        float f3 = (i & 4) != 0 ? 0.5f : f;
        if ((i & 8) != 0) {
            f0.Companion companion = f0.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "targetView.context");
            f2 = companion.a(context);
        }
        this(str, view, f3, f2, (i & 16) != 0 ? 500L : j);
    }

    private final void a() {
        Iterator<T> it = this.observers.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(0.0f);
        }
        this.handler.removeCallbacksAndMessages(null);
    }
}
