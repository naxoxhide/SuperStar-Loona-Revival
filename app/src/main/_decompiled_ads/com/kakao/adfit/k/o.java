package com.kakao.adfit.k;

import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: IntersectionChecker.java */
/* JADX INFO: loaded from: classes2.dex */
final class o extends g0.a {
    private final List<Rect> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f1834b;
    private final Rect c;

    o(Rect rect) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.f1834b = new Rect();
        this.c = new Rect();
        arrayList.add(new Rect(rect));
    }

    @Override // com.kakao.adfit.k.d0.a
    public void a(View view, Rect rect) {
        Rect rect2 = this.f1834b;
        rect2.set(rect);
        List<Rect> list = this.a;
        int size = list.size() - 1;
        int iWidth = rect2.width() * rect2.height();
        int i = 0;
        while (i <= size) {
            Rect rect3 = list.get(i);
            if (rect2.intersect(rect3)) {
                Rect rect4 = this.c;
                int i2 = rect3.top;
                int i3 = rect2.top;
                if (i2 < i3) {
                    rect4.set(rect3.left, i2, rect3.right, i3);
                }
                if (rect3.bottom > rect2.bottom) {
                    if (!rect4.isEmpty()) {
                        list.add(new Rect(rect4));
                    }
                    rect4.set(rect3.left, rect2.bottom, rect3.right, rect3.bottom);
                }
                if (rect3.left < rect2.left) {
                    if (!rect4.isEmpty()) {
                        list.add(new Rect(rect4));
                    }
                    rect4.set(rect3.left, rect2.top, rect2.left, rect2.bottom);
                }
                if (rect3.right > rect2.right) {
                    if (!rect4.isEmpty()) {
                        list.add(new Rect(rect4));
                    }
                    rect4.set(rect2.right, rect2.top, rect3.right, rect2.bottom);
                }
                if (rect4.isEmpty()) {
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
        int iWidth = 0;
        for (Rect rect : this.a) {
            iWidth += rect.width() * rect.height();
        }
        return iWidth;
    }
}
