package com.kakao.adfit.k;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AlphaLayerIntersectionChecker.java */
/* JADX INFO: loaded from: classes2.dex */
final class h extends g0.a {
    private final List<a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f1827b;
    private final Rect c;
    private final float d;

    /* JADX INFO: compiled from: AlphaLayerIntersectionChecker.java */
    private static class a {
        private final Rect a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f1828b;

        a(Rect rect) {
            this(rect, 0.0f);
        }

        a(Rect rect, float f) {
            this.a = rect;
            this.f1828b = f;
        }
    }

    h(Rect rect, float f) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.f1827b = new Rect();
        this.c = new Rect();
        arrayList.add(new a(new Rect(rect)));
        this.d = f;
    }

    static float a(float f, float f2) {
        return f + (f2 * (1.0f - f));
    }

    private static float d(View view) {
        float alpha = view.getAlpha();
        Object parent = view.getParent();
        while (alpha > 0.0f && (parent instanceof View)) {
            View view2 = (View) parent;
            alpha *= view2.getAlpha();
            parent = view2.getParent();
        }
        return alpha;
    }

    private static float e(View view) {
        Drawable background = view.getBackground();
        float alpha = 1.0f;
        if (background != null) {
            float alpha2 = background.getAlpha() / 255.0f;
            Drawable drawableB = g0.a.b(view);
            alpha = drawableB != null ? alpha2 + ((drawableB.getAlpha() / 255.0f) * (1.0f - alpha2)) : alpha2;
        } else {
            Drawable drawableB2 = g0.a.b(view);
            if (drawableB2 != null) {
                alpha = drawableB2.getAlpha() / 255.0f;
            }
        }
        return alpha * d(view);
    }

    @Override // com.kakao.adfit.k.d0.a
    public void a(View view, Rect rect) {
        Rect rect2 = this.f1827b;
        rect2.set(rect);
        List<a> list = this.a;
        int size = list.size() - 1;
        int iWidth = rect2.width() * rect2.height();
        int i = 0;
        while (i <= size) {
            a aVar = list.get(i);
            Rect rect3 = aVar.a;
            if (rect2.intersect(rect3)) {
                Rect rect4 = this.c;
                int i2 = rect3.top;
                int i3 = rect2.top;
                if (i2 < i3) {
                    rect4.set(rect3.left, i2, rect3.right, i3);
                }
                if (rect3.bottom > rect2.bottom) {
                    if (!rect4.isEmpty()) {
                        list.add(new a(new Rect(rect4), aVar.f1828b));
                    }
                    rect4.set(rect3.left, rect2.bottom, rect3.right, rect3.bottom);
                }
                if (rect3.left < rect2.left) {
                    if (!rect4.isEmpty()) {
                        list.add(new a(new Rect(rect4), aVar.f1828b));
                    }
                    rect4.set(rect3.left, rect2.top, rect2.left, rect2.bottom);
                }
                if (rect3.right > rect2.right) {
                    if (!rect4.isEmpty()) {
                        list.add(new a(new Rect(rect4), aVar.f1828b));
                    }
                    rect4.set(rect2.right, rect2.top, rect3.right, rect2.bottom);
                }
                float fA = a(aVar.f1828b, e(view));
                if (fA <= this.d) {
                    if (!rect4.isEmpty()) {
                        list.add(new a(new Rect(rect4), aVar.f1828b));
                        rect4.setEmpty();
                    }
                    rect3.set(rect2);
                    aVar.f1828b = fA;
                } else if (rect4.isEmpty()) {
                    list.remove(i);
                    size--;
                    i--;
                } else {
                    rect3.set(rect4);
                    rect4.setEmpty();
                }
                iWidth -= rect2.width() * rect2.height();
                if (iWidth <= 0) {
                    return;
                } else {
                    rect2.set(rect);
                }
            }
            i++;
        }
    }

    @Override // com.kakao.adfit.k.g0.a
    public int a() {
        Iterator<a> it = this.a.iterator();
        int iWidth = 0;
        while (it.hasNext()) {
            Rect rect = it.next().a;
            iWidth += rect.width() * rect.height();
        }
        return iWidth;
    }
}
