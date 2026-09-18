package com.bytedance.sdk.openadsdk.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Picture;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar2;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UIUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class b0 {
    private static float a = -1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f825b = -1;
    private static float c = -1.0f;
    private static int d = -1;
    private static int e = -1;
    private static WindowManager f = null;
    private static float g = -1.0f;
    private static Boolean h;
    private static final Object i = new Object();

    /* JADX INFO: compiled from: UIUtils.java */
    static class a extends AnimatorListenerAdapter {
        final /* synthetic */ WeakReference a;

        a(WeakReference weakReference) {
            this.a = weakReference;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            View view = (View) this.a.get();
            if (view != null) {
                b0.a(view, 8);
                view.setAlpha(1.0f);
            }
        }
    }

    /* JADX INFO: compiled from: UIUtils.java */
    static class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationEnd(animator);
        }
    }

    /* JADX INFO: compiled from: UIUtils.java */
    static class c extends b.b.a.a.k.g {
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.f0.q c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ Bitmap f;
        final /* synthetic */ String g;
        final /* synthetic */ long h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, com.bytedance.sdk.openadsdk.core.f0.q qVar, String str2, String str3, Bitmap bitmap, String str4, long j) {
            super(str);
            this.c = qVar;
            this.d = str2;
            this.e = str3;
            this.f = bitmap;
            this.g = str4;
            this.h = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.b(this.c, this.d, this.e, this.f, this.g, this.h);
        }
    }

    /* JADX INFO: compiled from: UIUtils.java */
    static class d extends ViewOutlineProvider {
        final /* synthetic */ float a;

        d(float f) {
            this.a = f;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (outline == null) {
                return;
            }
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.a);
        }
    }

    private static boolean a(int i2) {
        return i2 == 0 || i2 == 8 || i2 == 4;
    }

    public static int b(Context context, float f2) {
        a(context, true);
        float fA = a(context);
        if (fA <= 0.0f) {
            fA = 1.0f;
        }
        return (int) ((f2 / fA) + 0.5f);
    }

    public static int c(Context context, float f2) {
        o(context);
        float f3 = f(context);
        if (f3 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f2 / f3) + 0.5f);
    }

    public static void d(View view) {
        if (view == null) {
            return;
        }
        WeakReference weakReference = new WeakReference(view);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.addListener(new a(weakReference));
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.start();
    }

    public static boolean e(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static float f(Context context) {
        o(context);
        return c;
    }

    public static int g(Context context) {
        o(context);
        return e;
    }

    public static int[] h(Context context) {
        if (context == null) {
            return null;
        }
        if (f == null) {
            f = (WindowManager) com.bytedance.sdk.openadsdk.core.o.a().getSystemService("window");
        }
        int[] iArr = new int[2];
        WindowManager windowManager = f;
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int iIntValue = displayMetrics.widthPixels;
            int iIntValue2 = displayMetrics.heightPixels;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 14 && i2 < 17) {
                try {
                    iIntValue = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                    iIntValue2 = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                } catch (Exception unused) {
                }
            }
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    Point point = new Point();
                    Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
                    iIntValue = point.x;
                    iIntValue2 = point.y;
                } catch (Exception unused2) {
                }
            }
            iArr[0] = iIntValue;
            iArr[1] = iIntValue2;
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    public static int i(Context context) {
        o(context);
        return d;
    }

    public static boolean j(Context context) {
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_mainBuiltInDisplayCutout", "string", "android");
            String string = identifier > 0 ? resources.getString(identifier) : null;
            return (string == null || TextUtils.isEmpty(string)) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean k(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    public static boolean l(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean m(Context context) {
        String str = Build.MODEL;
        return str.equals("IN2010") || str.equals("IN2020") || str.equals("KB2000") || str.startsWith("ONEPLUS");
    }

    public static boolean n(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    public static void o(Context context) {
        a(context, false);
    }

    private static boolean a() {
        return a < 0.0f || f825b < 0 || c < 0.0f || d < 0 || e < 0;
    }

    public static Pair<Integer, Integer> e(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.o.a();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        return new Pair<>(Integer.valueOf(point.x), Integer.valueOf(point.y));
    }

    public static void a(Context context, boolean z) {
        Context contextA = context == null ? com.bytedance.sdk.openadsdk.core.o.a() : context;
        if (contextA == null) {
            return;
        }
        f = (WindowManager) contextA.getSystemService("window");
        if (a() || z) {
            DisplayMetrics displayMetrics = contextA.getResources().getDisplayMetrics();
            a = displayMetrics.density;
            f825b = displayMetrics.densityDpi;
            c = displayMetrics.scaledDensity;
            d = displayMetrics.widthPixels;
            e = displayMetrics.heightPixels;
        }
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return;
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            int i2 = d;
            int i3 = e;
            if (i2 > i3) {
                d = i3;
                e = i2;
                return;
            }
            return;
        }
        int i4 = d;
        int i5 = e;
        if (i4 < i5) {
            d = i5;
            e = i4;
        }
    }

    public static int b(Context context) {
        o(context);
        return f825b;
    }

    public static void f(View view) {
        if (view == null) {
            return;
        }
        a(view, 0);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.addListener(new b());
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
    }

    public static int[] c(View view) {
        if (view != null) {
            return new int[]{view.getWidth(), view.getHeight()};
        }
        return null;
    }

    public static int[] b(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int c(Context context) {
        return ((Integer) e(context).second).intValue();
    }

    public static void b(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        a(view, (ViewGroup.MarginLayoutParams) layoutParams, i2, i3, i4, i5);
    }

    public static boolean c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
                if ((rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null) != null) {
                    return true;
                }
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.m.b("UIUtils", e2.getMessage());
            }
        }
        return false;
    }

    public static float b() {
        float f2 = g;
        if (f2 > 0.0f) {
            return f2;
        }
        Resources resources = com.bytedance.sdk.openadsdk.core.o.a().getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            return 0.0f;
        }
        float dimensionPixelSize = resources.getDimensionPixelSize(identifier);
        g = dimensionPixelSize;
        return dimensionPixelSize;
    }

    public static int d(Context context) {
        return ((Integer) e(context).first).intValue();
    }

    public static void d(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(1792);
            activity.getWindow().clearFlags(1792);
        } catch (Exception unused) {
        }
    }

    public static void c(com.bytedance.sdk.openadsdk.core.f0.q qVar, String str, String str2, Bitmap bitmap, String str3, long j) {
        y.c(new c("startCheckPlayableStatusPercentage", qVar, str, str2, bitmap, str3, j), 10);
    }

    public static void b(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 > 11 && i2 < 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(8);
            } else if (i2 >= 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(3846);
                activity.getWindow().addFlags(1792);
            }
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.m.b("UIUtils", e2.getMessage());
        }
    }

    public static int a(Context context, float f2) {
        return Float.valueOf(a(context, f2, true)).intValue();
    }

    public static float a(Context context, float f2, boolean z) {
        o(context);
        return (f2 * a(context)) + (z ? 0.5f : 0.0f);
    }

    public static float a(Context context) {
        a(context, true);
        return a;
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i2;
        rect.bottom += i3;
        rect.left -= i4;
        rect.right += i5;
        ((View) view.getParent()).setTouchDelegate(new com.bytedance.sdk.component.utils.h(rect, view));
    }

    public static int[] a(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static Bitmap b(SSWebView sSWebView) {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        WebView webView = sSWebView.getWebView();
        int layerType = webView.getLayerType();
        webView.setLayerType(1, null);
        Bitmap bitmapA = a(sSWebView);
        if (bitmapA == null) {
            bitmapA = a(webView);
        }
        webView.setLayerType(layerType, null);
        if (bitmapA == null) {
            return null;
        }
        return com.bytedance.sdk.component.utils.d.a(bitmapA, bitmapA.getWidth() / 6, bitmapA.getHeight() / 6);
    }

    public static void a(View view, int i2) {
        if (view == null || view.getVisibility() == i2 || !a(i2)) {
            return;
        }
        view.setVisibility(i2);
    }

    public static void a(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    private static void a(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3, int i4, int i5) {
        if (view == null || marginLayoutParams == null) {
            return;
        }
        if (marginLayoutParams.leftMargin == i2 && marginLayoutParams.topMargin == i3 && marginLayoutParams.rightMargin == i4 && marginLayoutParams.bottomMargin == i5) {
            return;
        }
        if (i2 != -3) {
            marginLayoutParams.leftMargin = i2;
        }
        if (i3 != -3) {
            marginLayoutParams.topMargin = i3;
        }
        if (i4 != -3) {
            marginLayoutParams.rightMargin = i4;
        }
        if (i5 != -3) {
            marginLayoutParams.bottomMargin = i5;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.bytedance.sdk.openadsdk.core.f0.q qVar, String str, String str2, Bitmap bitmap, String str3, long j) {
        if (bitmap != null) {
            try {
                if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0 && !bitmap.isRecycled()) {
                    int iA = a(bitmap);
                    JSONObject jSONObject = null;
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("url", str3);
                        if (j != -1) {
                            jSONObject2.put("page_id", j);
                        }
                        jSONObject2.put("render_type", "h5");
                        jSONObject2.put("render_type_2", 0);
                        jSONObject2.put("is_blank", iA == 100 ? 1 : 0);
                        jSONObject2.put("is_playable", com.bytedance.sdk.openadsdk.core.f0.t.i(qVar) ? 1 : 0);
                        jSONObject2.put("usecache", com.bytedance.sdk.openadsdk.core.j0.b.a.b().a(qVar) ? 1 : 0);
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            jSONObject3.put("ad_extra_data", jSONObject2.toString());
                        } catch (JSONException unused) {
                        }
                        jSONObject = jSONObject3;
                    } catch (JSONException unused2) {
                    }
                    com.bytedance.sdk.openadsdk.d.c.c(qVar, str, str2, jSONObject);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("UIUtils", "(Developers can ignore this detection exception)checkWebViewIsTransparent->throwable ex>>>" + th.toString());
            }
        }
    }

    private static Bitmap a(WebView webView) {
        Bitmap bitmapCreateBitmap = null;
        try {
            Picture pictureCapturePicture = webView.capturePicture();
            bitmapCreateBitmap = Bitmap.createBitmap(pictureCapturePicture.getWidth(), pictureCapturePicture.getHeight(), Bitmap.Config.ARGB_8888);
            pictureCapturePicture.draw(new Canvas(bitmapCreateBitmap));
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("UIUtils", th.getMessage());
            return bitmapCreateBitmap;
        }
    }

    public static boolean a(Activity activity) {
        if (h == null) {
            synchronized (i) {
                if (h == null) {
                    boolean z = true;
                    if (!c(activity) && a("ro.miui.notch", activity) != 1 && !k(activity) && !l(activity) && !n(activity) && !m(activity) && !j(activity)) {
                        z = false;
                    }
                    h = Boolean.valueOf(z);
                }
            }
        }
        return h.booleanValue();
    }

    private static ArrayList<Integer> b(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i2 = width * height;
            int[] iArr = new int[i2];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = iArr[i3];
                arrayList.add(Integer.valueOf(Color.rgb((16711680 & i4) >> 16, (65280 & i4) >> 8, i4 & 255)));
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int a(String str, Activity activity) {
        if (!r.w()) {
            return 0;
        }
        try {
            Class<?> clsLoadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, new String(str), new Integer(0))).intValue();
        } catch (ClassNotFoundException e2) {
            com.bytedance.sdk.component.utils.m.b("UIUtils", e2.getMessage());
            return 0;
        } catch (IllegalAccessException e3) {
            com.bytedance.sdk.component.utils.m.b("UIUtils", e3.getMessage());
            return 0;
        } catch (IllegalArgumentException e4) {
            com.bytedance.sdk.component.utils.m.b("UIUtils", e4.getMessage());
            return 0;
        } catch (NoSuchMethodException e5) {
            com.bytedance.sdk.component.utils.m.b("UIUtils", e5.getMessage());
            return 0;
        } catch (InvocationTargetException e6) {
            com.bytedance.sdk.component.utils.m.b("UIUtils", e6.getMessage());
            return 0;
        }
    }

    public static void b(View view, float f2) {
        if (view != null && f2 > 0.0f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setOutlineProvider(new d(f2));
                view.setClipToOutline(true);
                return;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(-16777216);
            gradientDrawable.setCornerRadius(f2);
            view.setBackground(gradientDrawable);
        }
    }

    public static void a(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.m.b("OnclickListener ", str + " is null , can not set OnClickListener !!!");
        } else {
            view.setOnClickListener(onClickListener);
        }
    }

    public static void a(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.m.b("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
        } else {
            view.setOnTouchListener(onTouchListener);
        }
    }

    public static void a(View view, float f2) {
        if (view == null) {
            return;
        }
        view.setAlpha(f2);
    }

    public static void a(TextView textView, TTRatingBar2 tTRatingBar2, com.bytedance.sdk.openadsdk.core.f0.q qVar) {
        a(textView, tTRatingBar2, (qVar == null || qVar.h() == null) ? -1.0d : qVar.h().f());
    }

    public static void a(TextView textView, TTRatingBar2 tTRatingBar2, double d2) {
        if (d2 == -1.0d) {
            if (textView != null) {
                textView.setVisibility(8);
            }
            tTRatingBar2.setVisibility(8);
        } else {
            if (textView != null) {
                textView.setText(String.format(Locale.getDefault(), "%.1f", Double.valueOf(d2)));
            }
            a(tTRatingBar2, d2, 0, 14);
        }
    }

    public static void a(TTRatingBar2 tTRatingBar2, double d2, int i2, int i3) {
        if (d2 < 0.0d) {
            tTRatingBar2.setVisibility(8);
        } else {
            tTRatingBar2.setVisibility(0);
            tTRatingBar2.a(d2, i2, i3);
        }
    }

    public static void a(TextView textView, com.bytedance.sdk.openadsdk.core.f0.q qVar, Context context, String str) {
        a(textView, qVar.h() != null ? qVar.h().c() : -1, context, str);
    }

    public static void a(TextView textView, int i2, Context context, String str) {
        StringBuilder sbAppend;
        String str2;
        String strK = com.bytedance.sdk.component.utils.t.k(context, str);
        if (i2 > 10000) {
            sbAppend = new StringBuilder().append(i2 / 1000);
            str2 = CampaignEx.JSON_KEY_AD_K;
        } else {
            sbAppend = new StringBuilder().append(i2);
            str2 = "";
        }
        textView.setText(String.format(strK, sbAppend.append(str2).toString()));
        if (i2 == -1) {
            textView.setVisibility(8);
        }
    }

    private static Bitmap a(SSWebView sSWebView) {
        if (sSWebView == null) {
            return null;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(sSWebView.getWidth(), sSWebView.getHeight(), Bitmap.Config.RGB_565);
            sSWebView.draw(new Canvas(bitmapCreateBitmap));
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int a(Bitmap bitmap) {
        try {
            ArrayList<Integer> arrayListB = b(bitmap);
            if (arrayListB == null) {
                return -1;
            }
            HashMap map = new HashMap();
            for (Integer num : arrayListB) {
                if (map.containsKey(num)) {
                    Integer numValueOf = Integer.valueOf(((Integer) map.get(num)).intValue() + 1);
                    map.remove(num);
                    map.put(num, numValueOf);
                } else {
                    map.put(num, 1);
                }
            }
            int iIntValue = 0;
            int i2 = 0;
            for (Map.Entry entry : map.entrySet()) {
                int iIntValue2 = ((Integer) entry.getValue()).intValue();
                if (i2 < iIntValue2) {
                    iIntValue = ((Integer) entry.getKey()).intValue();
                    i2 = iIntValue2;
                }
            }
            if (iIntValue == 0) {
                return -1;
            }
            return (int) ((i2 / ((bitmap.getWidth() * bitmap.getHeight()) * 1.0f)) * 100.0f);
        } catch (Throwable unused) {
            return -1;
        }
    }
}
