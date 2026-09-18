package com.mbridge.msdk.foundation.tools;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/* JADX INFO: compiled from: ViewCoveredUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public final class an {
    private static boolean a = false;

    /* JADX WARN: Code duplicated, block: B:53:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x00ff A[SYNTHETIC] */
    public static boolean a(View view, int i) {
        if (view == null) {
            return true;
        }
        if (view.getVisibility() != 0) {
            aa.d("ViewUtils", "Banner Judge : Banner's not visible.");
            return true;
        }
        if (view.getAlpha() < 0.5f) {
            aa.d("ViewUtils", "Banner Judge : Banner's alpha must set up 50%.");
            return true;
        }
        if (view.getParent() != null && (view.getParent() instanceof ViewGroup) && ((ViewGroup) view.getParent()).getVisibility() != 0) {
            aa.d("ViewUtils", "View Judge : View's container is not visible.");
            return true;
        }
        Rect rect = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
        boolean z = ((float) ((rect.bottom - rect.top) * (rect.right - rect.left))) > ((float) (view.getMeasuredHeight() * view.getMeasuredWidth())) * (i == 1 ? 0.0f : 0.5f);
        boolean z2 = globalVisibleRect && z;
        aa.d("ViewUtils", "View Judge : partVisible is " + globalVisibleRect + " halfPercentVisible is " + z);
        aa.d("ViewUtils", "View Judge : totalViewVisible is " + z2);
        if (!z2) {
            return true;
        }
        View view2 = view;
        while (view2.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            for (int iA = a(view2, viewGroup) + 1; iA < viewGroup.getChildCount(); iA++) {
                View childAt = viewGroup.getChildAt(iA);
                if (childAt.getVisibility() == 0 && a(view, childAt, i)) {
                    if (childAt instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) childAt;
                        if (viewGroup2.getChildCount() > 0) {
                            aa.d("ViewUtils", "View Judge : Covered by ViewGroup.");
                            boolean zA = a(view, viewGroup2, i);
                            a = false;
                            if (zA) {
                                return true;
                            }
                        } else if (a(childAt)) {
                            aa.d("ViewUtils", "View Judge : View Covered and Cover View is not transparent.");
                            return true;
                        }
                    } else if (a(childAt)) {
                        aa.d("ViewUtils", "View Judge : View Covered and Cover View is not transparent.");
                        return true;
                    }
                }
            }
            view2 = viewGroup;
        }
        aa.d("ViewUtils", "View Judge : Well done, View is not covered.");
        return false;
    }

    private static boolean a(View view) {
        if (view != null && (view.getTag() instanceof String) && "mb_wm".equals(view.getTag())) {
            return false;
        }
        return (Build.VERSION.SDK_INT < 19 || (view.getBackground() != null && view.getBackground().getAlpha() > 127)) && view.getAlpha() > 0.5f;
    }

    private static boolean a(View view, View view2, int i) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        view2.getGlobalVisibleRect(rect2);
        if (!Rect.intersects(rect, rect2)) {
            return false;
        }
        int iMin = Math.min(rect.right, rect2.right) - Math.max(rect.left, rect2.left);
        int iMin2 = Math.min(rect.bottom, rect2.bottom) - Math.max(rect.top, rect2.top);
        return (i != 1 && (iMin * iMin2) * 2 >= view.getMeasuredHeight() * view.getMeasuredWidth()) || (i == 1 && iMin * iMin2 >= view.getMeasuredHeight() * view.getMeasuredWidth());
    }

    private static int a(View view, ViewGroup viewGroup) {
        int i = 0;
        while (i < viewGroup.getChildCount() && viewGroup.getChildAt(i) != view) {
            i++;
        }
        return i;
    }

    private static boolean a(View view, ViewGroup viewGroup, int i) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            aa.d("ViewUtils", "View Judge : Start Loop");
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0 && a(view, childAt, i)) {
                if ((childAt instanceof WebView) && childAt.getVisibility() == 0) {
                    aa.d("ViewUtils", "View Judge : View Covered by WebView.");
                    a = true;
                }
                if (a(childAt)) {
                    aa.d("ViewUtils", "View Judge : View Covered and Cover ViewGroup is not transparent.");
                    a = true;
                }
                if (a) {
                    break;
                }
                if (childAt instanceof ViewGroup) {
                    a(view, (ViewGroup) childAt, i);
                }
            }
        }
        return a;
    }
}
