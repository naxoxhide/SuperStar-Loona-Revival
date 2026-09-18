package com.kakao.adfit.k;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: compiled from: ViewIntersectionFinder.java */
/* JADX INFO: loaded from: classes2.dex */
public class d0 {

    /* JADX INFO: compiled from: ViewIntersectionFinder.java */
    public interface a {
        void a(View view, Rect rect);

        boolean a(View view);

        boolean a(ViewGroup viewGroup);
    }

    public static void a(View view, Rect rect, a aVar) {
        ViewParent parent = view.getParent();
        Rect rect2 = new Rect();
        while (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int childCount = viewGroup.getChildCount();
            float z = view.getZ();
            boolean z2 = childCount > 1 && c0.a(viewGroup);
            if (z2) {
                boolean z3 = false;
                for (int i = 0; i < childCount; i++) {
                    int iA = c0.a(viewGroup, i);
                    if (iA >= childCount) {
                        z2 = false;
                        break;
                    }
                    View childAt = viewGroup.getChildAt(iA);
                    if (childAt == view) {
                        z3 = true;
                    } else if (z3) {
                        if (childAt.getZ() >= z) {
                            a(rect, childAt, aVar, rect2);
                        }
                    } else if (childAt.getZ() > z) {
                        a(rect, childAt, aVar, rect2);
                    }
                }
            }
            if (!z2) {
                boolean z4 = false;
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt2 = viewGroup.getChildAt(i2);
                    if (childAt2 == view) {
                        z4 = true;
                    } else if (z4) {
                        if (childAt2.getZ() >= z) {
                            a(rect, childAt2, aVar, rect2);
                        }
                    } else if (childAt2.getZ() > z) {
                        a(rect, childAt2, aVar, rect2);
                    }
                }
            }
            parent = viewGroup.getParent();
            view = viewGroup;
        }
    }

    private static void a(Rect rect, View view, a aVar, Rect rect2) {
        if (!aVar.a(view) && view.getGlobalVisibleRect(rect2, null) && rect2.intersect(rect) && !rect2.isEmpty()) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (aVar.a(viewGroup)) {
                    int childCount = viewGroup.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        a(rect, viewGroup.getChildAt(i), aVar, rect2);
                    }
                    return;
                }
            }
            aVar.a(view, rect2);
        }
    }
}
