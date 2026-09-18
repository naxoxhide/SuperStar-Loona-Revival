package com.kakao.adfit.k;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: ViewableInspector.java */
/* JADX INFO: loaded from: classes2.dex */
public class g0 {
    public static float a(View view, int i, int i2, float f) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (width < i || height < i2) {
            return 0.0f;
        }
        return a(view, f);
    }

    public static float a(View view, float f) {
        Display display;
        a hVar;
        int width = view.getWidth();
        int height = view.getHeight();
        if (width > 0 && height > 0) {
            View view2 = view;
            while (view2.getVisibility() == 0 && view2.getAlpha() > 0.0f) {
                Object parent = view2.getParent();
                if (parent instanceof View) {
                    view2 = (View) parent;
                } else {
                    Rect rect = new Rect();
                    if (!view.getGlobalVisibleRect(rect, null) || (display = view.getDisplay()) == null) {
                        return 0.0f;
                    }
                    Point pointB = j.b(display);
                    int[] iArr = new int[2];
                    view.getRootView().getLocationOnScreen(iArr);
                    int i = -iArr[0];
                    int i2 = -iArr[1];
                    if (!rect.intersect(i, i2, pointB.x + i, pointB.y + i2)) {
                        return 0.0f;
                    }
                    if (f <= 0.0f) {
                        hVar = new o(rect);
                    } else {
                        hVar = new h(rect, f);
                    }
                    try {
                        d0.a(view, rect, hVar);
                    } catch (Throwable th) {
                        f.a("Failed to get viewable ratio: " + th, th);
                    }
                    return hVar.a() / (width * height);
                }
            }
        }
        return 0.0f;
    }

    /* JADX INFO: compiled from: ViewableInspector.java */
    static abstract class a implements d0.a {
        a() {
        }

        protected static Drawable b(View view) {
            if (Build.VERSION.SDK_INT >= 23) {
                return view.getForeground();
            }
            if (view instanceof FrameLayout) {
                return ((FrameLayout) view).getForeground();
            }
            return null;
        }

        private static boolean c(View view) {
            return (a(view.getBackground()) || a(b(view))) ? false : true;
        }

        abstract int a();

        @Override // com.kakao.adfit.k.d0.a
        public boolean a(View view) {
            if (view.getVisibility() == 0 && view.getAlpha() > 0.0f) {
                return view.getClass() == View.class && c(view);
            }
            return true;
        }

        @Override // com.kakao.adfit.k.d0.a
        public boolean a(ViewGroup viewGroup) {
            return c(viewGroup);
        }

        private static boolean a(Drawable drawable) {
            return drawable != null && drawable.getAlpha() > 0;
        }
    }
}
