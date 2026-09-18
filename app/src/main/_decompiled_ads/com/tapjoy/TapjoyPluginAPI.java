package com.tapjoy;

import android.app.Activity;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.core.view.GravityCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public class TapjoyPluginAPI {
    public static TJOfferwallDiscoverView a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static PopupWindow f2716b = null;
    public static float c = -1.0f;
    public static float d = -1.0f;

    public static PopupWindow CreatePopupWindow(Activity activity, ViewGroup viewGroup, int i, int i2) {
        PopupWindow popupWindow = new PopupWindow(viewGroup, i, i2);
        popupWindow.getContentView().setSystemUiVisibility(activity.getWindow().getAttributes().flags);
        try {
            Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(popupWindow, 1002);
        } catch (IllegalAccessException e) {
            TapjoyLog.d("TapjoyPluginAPI", String.format("Unable to set popUpWindow window layout type: %s", e.getLocalizedMessage()));
        } catch (NoSuchMethodException e2) {
            TapjoyLog.d("TapjoyPluginAPI", String.format("Unable to set popUpWindow window layout type: %s", e2.getLocalizedMessage()));
        } catch (InvocationTargetException e3) {
            TapjoyLog.d("TapjoyPluginAPI", String.format("Unable to set popUpWindow window layout type: %s", e3.getLocalizedMessage()));
        }
        return popupWindow;
    }

    public static void DestroyOWDiscover() {
        TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.-$$Lambda$a0VCXKp1RBAsp3a67HF04z3-yo4
            @Override // java.lang.Runnable
            public final void run() {
                TapjoyPluginAPI.a();
            }
        });
    }

    public static void RequestOWDiscover(Activity activity, String str, float f, TJOfferwallDiscoverListener tJOfferwallDiscoverListener) {
        RequestOWDiscover(activity, str, -1.0f, -1.0f, -1.0f, f, tJOfferwallDiscoverListener);
    }

    public static void ShowOWDiscover(final Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final float f = d;
        if (f == -1.0f) {
            f = 0.0f;
        }
        final float height = c;
        if (height == -1.0f) {
            height = displayMetrics.heightPixels - f2716b.getHeight();
        }
        TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.-$$Lambda$n_iygcN6k1vsEa7Q0QcWONxRhwE
            @Override // java.lang.Runnable
            public final void run() {
                TapjoyPluginAPI.a(activity, f, height);
            }
        });
    }

    public static /* synthetic */ void a(Activity activity, TJOfferwallDiscoverListener tJOfferwallDiscoverListener, String str, float f, float f2, float f3, float f4) {
        DestroyOWDiscover();
        TJOfferwallDiscoverView tJOfferwallDiscoverView = new TJOfferwallDiscoverView(activity);
        a = tJOfferwallDiscoverView;
        tJOfferwallDiscoverView.setListener(tJOfferwallDiscoverListener);
        a.requestContent(activity, str);
        float screenDensityScale = new TapjoyDisplayMetricsUtil(activity).getScreenDensityScale();
        activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        TJOfferwallDiscoverView tJOfferwallDiscoverView2 = a;
        if (f != -1.0f) {
            f *= screenDensityScale;
        }
        PopupWindow popupWindowCreatePopupWindow = CreatePopupWindow(activity, tJOfferwallDiscoverView2, (int) f, (int) (f2 * screenDensityScale));
        f2716b = popupWindowCreatePopupWindow;
        popupWindowCreatePopupWindow.setInputMethodMode(1);
        if (f3 != -1.0f) {
            f3 *= screenDensityScale;
        }
        d = f3;
        if (f4 != -1.0f) {
            f4 *= screenDensityScale;
        }
        c = f4;
    }

    public static void RequestOWDiscover(final Activity activity, final String str, final float f, final float f2, final float f3, final float f4, final TJOfferwallDiscoverListener tJOfferwallDiscoverListener) {
        TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.-$$Lambda$eBcXB8OSk-XRc3eKtaA4O7SPxQE
            @Override // java.lang.Runnable
            public final void run() {
                TapjoyPluginAPI.a(activity, tJOfferwallDiscoverListener, str, f3, f4, f, f2);
            }
        });
    }

    public static /* synthetic */ void a(Activity activity, float f, float f2) {
        PopupWindow popupWindow = f2716b;
        if (popupWindow == null || popupWindow.isShowing() || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        f2716b.showAtLocation(activity.getWindow().getDecorView().getRootView(), c != -1.0f ? 8388659 : GravityCompat.END, (int) f, (int) f2);
        c = -1.0f;
        d = -1.0f;
    }

    public static /* synthetic */ void a() {
        if (f2716b != null) {
            if (Build.VERSION.SDK_INT < 22 || f2716b.isAttachedInDecor()) {
                f2716b.dismiss();
                TJOfferwallDiscoverView tJOfferwallDiscoverView = a;
                if (tJOfferwallDiscoverView != null) {
                    tJOfferwallDiscoverView.clearContent();
                    a = null;
                }
            }
        }
    }
}
