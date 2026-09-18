package b.b.a.a.d.g;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: compiled from: ScreenUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static boolean a;

    public static float a(Context context, float f) {
        if (context == null) {
            context = b.b.a.a.d.e.a.a.d().b().e();
        }
        return (f * a(context)) + 0.5f;
    }

    public static int a(float f, float f2, float f3, float f4) {
        return (((int) ((f * 255.0f) + 0.5f)) << 24) | (((int) ((f2 * 255.0f) + 0.5f)) << 16) | (((int) ((f3 * 255.0f) + 0.5f)) << 8) | ((int) ((f4 * 255.0f) + 0.5f));
    }

    public static float b(Context context, float f) {
        if (context == null) {
            context = b.b.a.a.d.e.a.a.d().b().e();
        }
        return f * a(context);
    }

    public static int c(Context context, float f) {
        if (context == null) {
            context = b.b.a.a.d.e.a.a.d().b().e();
        }
        float fA = a(context);
        if (fA <= 0.0f) {
            fA = 1.0f;
        }
        return (int) ((f / fA) + 0.5f);
    }

    public static int d(Context context) {
        if (context == null) {
            context = b.b.a.a.d.e.a.a.d().b().e();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private static float a(Context context) {
        try {
            if (a) {
                Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.DisplayMetrics");
                Method declaredMethod = clsLoadClass.getDeclaredMethod("getDeviceDensity", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Integer) declaredMethod.invoke(clsLoadClass, new Object[0])).intValue() / 160.0f;
            }
        } catch (Exception unused) {
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static String b(Context context) {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            return locale.getLanguage();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int c(Context context) {
        if (context == null) {
            context = b.b.a.a.d.e.a.a.d().b().e();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }
}
