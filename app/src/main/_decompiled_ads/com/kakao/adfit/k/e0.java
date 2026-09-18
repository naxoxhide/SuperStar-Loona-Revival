package com.kakao.adfit.k;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewMeasureSpecCalculator.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b)\u0010*J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0013R*\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\n\u0010\u0017\"\u0004\b\n\u0010\u0018R*\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u000f\u0010\u001b\"\u0004\b\u0006\u0010\u001cR*\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\r\u0010\u001b\"\u0004\b\n\u0010\u001cR$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b \u0010\u001a\u001a\u0004\b \u0010\u001bR$\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\u0006\u0010\u001bR\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010'¨\u0006+"}, d2 = {"Lcom/kakao/adfit/k/e0;", "", "", "widthSpec", "heightSpec", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "measureSpec", "mode", SDKConstants.PARAM_CONTEXT_MAX_SIZE, "a", "w", "h", "c", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "widthMeasureSpec", "heightMeasureSpec", "Landroid/view/View;", "Landroid/view/View;", "view", "value", "F", "()F", "(F)V", "aspectRatio", "I", "()I", "(I)V", "maxWidth", "maxHeight", "<set-?>", "e", InneractiveMediationDefs.GENDER_FEMALE, "Landroid/util/DisplayMetrics;", "g", "Landroid/util/DisplayMetrics;", "displayMetrics", "Landroid/view/Display;", "Landroid/view/Display;", "attachedDisplay", "<init>", "(Landroid/view/View;FII)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class e0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final View view;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float aspectRatio;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private int maxWidth;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private int maxHeight;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private int widthSpec;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private int heightSpec;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final DisplayMetrics displayMetrics;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private Display attachedDisplay;

    /* JADX INFO: compiled from: ViewMeasureSpecCalculator.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/kakao/adfit/k/e0$a", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            e0.this.attachedDisplay = v.getDisplay();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            e0.this.attachedDisplay = null;
        }
    }

    public e0(View view, float f, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.aspectRatio = f;
        this.maxWidth = i;
        this.maxHeight = i2;
        this.displayMetrics = new DisplayMetrics();
        view.addOnAttachStateChangeListener(new a());
    }

    public final void b(int i) {
        if (this.maxWidth != i) {
            this.maxWidth = i;
            this.view.requestLayout();
        }
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getMaxHeight() {
        return this.maxHeight;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getMaxWidth() {
        return this.maxWidth;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getWidthSpec() {
        return this.widthSpec;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final void c(int w, int h) {
        a(w, h);
    }

    public final void d(int w, int h) {
        b(w);
        a(h);
    }

    public final void a(float f) {
        if (this.aspectRatio == f) {
            return;
        }
        this.aspectRatio = f;
        this.view.requestLayout();
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getHeightSpec() {
        return this.heightSpec;
    }

    private final void b(int widthSpec, int heightSpec) {
        this.widthSpec = widthSpec;
        this.heightSpec = heightSpec;
    }

    public final void a(int i) {
        if (this.maxHeight != i) {
            this.maxHeight = i;
            this.view.requestLayout();
        }
    }

    public final void a(float w, float h) {
        float f = 0.0f;
        if (w > 0.0f && h > 0.0f) {
            f = w / h;
        }
        a(f);
    }

    public final void a(int widthMeasureSpec, int heightMeasureSpec) {
        int size;
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        if (mode == 1073741824 && mode2 == 1073741824) {
            b(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int iA = a(widthMeasureSpec, mode, this.maxWidth);
        int iA2 = a(heightMeasureSpec, mode2, this.maxHeight);
        float f = this.aspectRatio;
        if (f <= 0.0f) {
            b(iA, iA2);
            return;
        }
        Display display = this.attachedDisplay;
        if (display == null) {
            b(iA, iA2);
            return;
        }
        DisplayMetrics displayMetrics = this.displayMetrics;
        display.getMetrics(displayMetrics);
        int iMin = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        if (mode != 0) {
            iMin = Math.min(iMin, View.MeasureSpec.getSize(iA));
        }
        if (iMin <= 0 && (iMin = View.MeasureSpec.getSize(iA)) <= 0) {
            b(iA, iA2);
            return;
        }
        int i = (int) ((iMin / f) + 0.5f);
        if (mode2 != 0 && i > (size = View.MeasureSpec.getSize(iA2))) {
            iMin = (int) ((size * f) + 0.5f);
            i = size;
        }
        if (mode != 1073741824) {
            iA = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        }
        if (mode2 != 1073741824) {
            iA2 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        }
        b(iA, iA2);
    }

    public /* synthetic */ e0(View view, float f, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i3 & 2) != 0 ? 1.7777778f : f, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    private final int a(int measureSpec, int mode, int maxSize) {
        if (maxSize <= 0 || mode == 1073741824) {
            return measureSpec;
        }
        if (mode != 0) {
            maxSize = Math.min(maxSize, View.MeasureSpec.getSize(measureSpec));
        }
        return View.MeasureSpec.makeMeasureSpec(maxSize, Integer.MIN_VALUE);
    }
}
