package com.bytedance.sdk.openadsdk.core;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: compiled from: VisibilityChecker.java */
/* JADX INFO: loaded from: classes2.dex */
public class y {
    public static float a(View view) {
        if (view != null) {
            try {
                if (view.getVisibility() == 0 && view.getParent() != null) {
                    Rect rect = new Rect();
                    if (!view.getGlobalVisibleRect(rect)) {
                        return -1.0f;
                    }
                    long jHeight = ((long) rect.height()) * ((long) rect.width());
                    long height = ((long) view.getHeight()) * ((long) view.getWidth());
                    if (height <= 0) {
                        return -1.0f;
                    }
                    return jHeight / height;
                }
            } catch (Throwable unused) {
            }
        }
        return -1.0f;
    }

    private static boolean b(View view) {
        return view != null && view.isShown();
    }

    private static boolean c(View view, int i) {
        return view.getWidth() >= b(view, i) && view.getHeight() >= a(view, i);
    }

    private static boolean d(View view, int i) {
        float fA = a(view);
        return fA > 0.0f && fA >= ((float) i) / 100.0f;
    }

    private static int b(View view, int i) {
        if (i == 3) {
            return (int) (((double) b0.i(view.getContext().getApplicationContext())) * 0.7d);
        }
        return 20;
    }

    public static boolean b(View view, int i, int i2) {
        if (i2 == 1) {
            while (view != null) {
                try {
                    if (view.getVisibility() == 0) {
                        if ((view instanceof NativeExpressView) || (view instanceof BannerExpressView)) {
                            break;
                            break;
                        }
                        view = (View) view.getParent();
                    } else {
                        return false;
                    }
                } catch (Throwable unused) {
                    return false;
                }
            }
        }
        return a(view, i, i2) == 0;
    }

    private static int a(View view, int i) {
        if (i == 3) {
            return b0.g(view.getContext().getApplicationContext()) / 2;
        }
        return 20;
    }

    private static int a(View view, int i, int i2) throws Throwable {
        if (view.getWindowVisibility() != 0) {
            return 4;
        }
        if (!b(view)) {
            return 1;
        }
        if (c(view, i2)) {
            return !d(view, i) ? 3 : 0;
        }
        return 6;
    }
}
