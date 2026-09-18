package com.kakao.adfit.k;

import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ViewGroupUtils.java */
/* JADX INFO: loaded from: classes2.dex */
final class c0 {
    private static Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1819b;
    private static Method c;
    private static boolean d;

    public static boolean a(ViewGroup viewGroup) {
        if (!f1819b) {
            try {
                Method declaredMethod = ViewGroup.class.getDeclaredMethod("isChildrenDrawingOrderEnabled", new Class[0]);
                a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f1819b = true;
        }
        Method method = a;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(viewGroup, new Object[0])).booleanValue();
            } catch (ReflectiveOperationException unused2) {
            }
        }
        return false;
    }

    public static int a(ViewGroup viewGroup, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            return viewGroup.getChildDrawingOrder(i);
        }
        if (!d) {
            try {
                Class cls = Integer.TYPE;
                Method declaredMethod = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", cls, cls);
                c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            d = true;
        }
        Method method = c;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewGroup, Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i))).intValue();
            } catch (ReflectiveOperationException unused2) {
            }
        }
        return i;
    }
}
