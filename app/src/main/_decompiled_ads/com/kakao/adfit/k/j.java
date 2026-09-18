package com.kakao.adfit.k;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisplayUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001a\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007J\u001a\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0018\u0010\t\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0007J\u0018\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0018\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\u0010"}, d2 = {"Lcom/kakao/adfit/k/j;", "", "Landroid/content/Context;", "context", "Landroid/view/Display;", "a", "display", "Landroid/graphics/Point;", "size", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "dp", "", "px", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class j {
    public static final j a = new j();

    private j() {
    }

    @JvmStatic
    public static final Display a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("display");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        Display display = ((DisplayManager) systemService).getDisplay(0);
        Intrinsics.checkNotNullExpressionValue(display, "displayManager.getDisplay(DEFAULT_DISPLAY)");
        return display;
    }

    @JvmStatic
    public static final Point b(Display display) {
        Intrinsics.checkNotNullParameter(display, "display");
        return b(display, null, 2, null);
    }

    public static /* synthetic */ Point b(Display display, Point point, int i, Object obj) {
        if ((i & 2) != 0) {
            point = new Point();
        }
        return b(display, point);
    }

    @JvmStatic
    public static final Point b(Display display, Point size) {
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(size, "size");
        display.getRealSize(size);
        return size;
    }

    @JvmStatic
    public static final int b(Context context, int dp) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) (b(context, dp) + 0.5f);
    }

    public static /* synthetic */ Point a(Display display, Point point, int i, Object obj) {
        if ((i & 2) != 0) {
            point = new Point();
        }
        return a(display, point);
    }

    @JvmStatic
    public static final float b(Context context, float px) {
        Intrinsics.checkNotNullParameter(context, "context");
        return px / context.getResources().getDisplayMetrics().density;
    }

    @JvmStatic
    public static final Point a(Display display, Point size) {
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(size, "size");
        display.getSize(size);
        return size;
    }

    @JvmStatic
    public static final int a(Display display) {
        Intrinsics.checkNotNullParameter(display, "display");
        return display.getRotation();
    }

    @JvmStatic
    public static final int a(Context context, int dp) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) (a(context, dp) + 0.5f);
    }

    @JvmStatic
    public static final float a(Context context, float dp) {
        Intrinsics.checkNotNullParameter(context, "context");
        return dp * context.getResources().getDisplayMetrics().density;
    }
}
