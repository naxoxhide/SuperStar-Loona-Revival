package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.List;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class c0 {
    private static final int a = -208931566;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f826b = 112828121;
    private static final int c = 2046768709;
    private static final int d = 1996943318;

    /* JADX INFO: compiled from: ViewUtils.java */
    static class a implements ViewGroup.OnHierarchyChangeListener {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            this.a.a = view2;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            this.a.a = null;
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        View a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f827b;

        b(ViewGroup viewGroup) {
            this.f827b = viewGroup;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            f fVar = (f) this.f827b.getTag(c0.c);
            if (this.a == null) {
                ViewGroup viewGroup = this.f827b;
                c0.b(viewGroup, fVar, (Integer) viewGroup.getTag(c0.d));
                return;
            }
            Rect rect = new Rect();
            this.a.getGlobalVisibleRect(rect);
            Rect rect2 = new Rect();
            this.f827b.getGlobalVisibleRect(rect2);
            if (rect.contains(rect2)) {
                if (fVar != null) {
                    fVar.a(this.f827b, false);
                }
                this.f827b.setTag(c0.a, Boolean.FALSE);
            } else {
                if (fVar != null) {
                    fVar.a(this.f827b, true);
                }
                this.f827b.setTag(c0.a, Boolean.TRUE);
            }
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    static class c implements ViewTreeObserver.OnScrollChangedListener {
        final /* synthetic */ ViewGroup a;

        c(ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            f fVar = (f) this.a.getTag(c0.c);
            ViewGroup viewGroup = this.a;
            c0.b(viewGroup, fVar, (Integer) viewGroup.getTag(c0.d));
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    static class d implements ViewTreeObserver.OnWindowFocusChangeListener {
        final /* synthetic */ ViewGroup a;

        d(ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            f fVar = (f) this.a.getTag(c0.c);
            if (fVar != null) {
                fVar.onWindowFocusChanged(z);
                ViewGroup viewGroup = this.a;
                c0.b(viewGroup, fVar, (Integer) viewGroup.getTag(c0.d));
            }
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    static class e implements View.OnAttachStateChangeListener {
        final /* synthetic */ ViewGroup a;

        e(ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            f fVar = (f) this.a.getTag(c0.c);
            if (fVar != null) {
                fVar.a();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            f fVar = (f) this.a.getTag(c0.c);
            if (fVar != null) {
                fVar.onDetachedFromWindow();
            }
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    public interface f {
        void a();

        void a(View view, boolean z);

        void onDetachedFromWindow();

        void onWindowFocusChanged(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(View view, f fVar, Integer num) {
        if (fVar == null) {
            return;
        }
        if (num == null) {
            num = 0;
        }
        int i = a;
        Boolean bool = (Boolean) view.getTag(i);
        boolean zA = a(view, num.intValue());
        if (bool == null) {
            if (zA) {
                fVar.a(view, true);
                view.setTag(i, Boolean.TRUE);
                return;
            }
            return;
        }
        if (bool.booleanValue() != zA) {
            fVar.a(view, zA);
            view.setTag(i, Boolean.valueOf(zA));
        }
    }

    public static void a(ViewGroup viewGroup, boolean z, int i, f fVar, List<ViewGroup> list) {
        viewGroup.setTag(c, fVar);
        viewGroup.setTag(d, Integer.valueOf(i));
        if (viewGroup.getTag(f826b) == Boolean.TRUE) {
            return;
        }
        b bVar = new b(viewGroup);
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                list.get(i2).setOnHierarchyChangeListener(new a(bVar));
            }
        }
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(bVar);
        if (z) {
            viewGroup.getViewTreeObserver().addOnScrollChangedListener(new c(viewGroup));
        }
        if (Build.VERSION.SDK_INT >= 18) {
            viewGroup.getViewTreeObserver().addOnWindowFocusChangeListener(new d(viewGroup));
        }
        viewGroup.addOnAttachStateChangeListener(new e(viewGroup));
        viewGroup.setTag(f826b, Boolean.TRUE);
    }

    private static boolean a(View view, int i) {
        return com.bytedance.sdk.openadsdk.core.y.b(view, 20, i);
    }
}
