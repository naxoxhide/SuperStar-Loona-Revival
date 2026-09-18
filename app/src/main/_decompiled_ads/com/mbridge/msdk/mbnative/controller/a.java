package com.mbridge.msdk.mbnative.controller;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.an;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ImpressionTracker.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private WeakReference<ViewTreeObserver> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<View> f2305b;
    private ViewTreeObserver.OnPreDrawListener c;
    private InterfaceC0492a d;
    private Handler e;
    private boolean f;
    private int g;

    /* JADX INFO: renamed from: com.mbridge.msdk.mbnative.controller.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ImpressionTracker.java */
    public interface InterfaceC0492a {
        void a(ArrayList<View> arrayList, ArrayList<View> arrayList2);
    }

    public a(List<View> list, InterfaceC0492a interfaceC0492a, Handler handler, int i) {
        ArrayList arrayList = new ArrayList();
        this.f2305b = arrayList;
        this.c = null;
        this.d = interfaceC0492a;
        this.e = handler;
        this.g = i;
        if (list != null) {
            this.f2305b = list;
        } else {
            arrayList.clear();
        }
        try {
            b();
        } catch (Throwable th) {
            aa.b("ImpressionTracker", th.getMessage(), th);
        }
        try {
            this.c = new ViewTreeObserver.OnPreDrawListener() { // from class: com.mbridge.msdk.mbnative.controller.a.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public final boolean onPreDraw() {
                    a.this.b();
                    return true;
                }
            };
        } catch (Throwable th2) {
            aa.b("ImpressionTracker", th2.getMessage(), th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f) {
            return;
        }
        Handler handler = this.e;
        if (handler != null) {
            if (this.g == 1) {
                c();
            } else {
                handler.postDelayed(new Runnable() { // from class: com.mbridge.msdk.mbnative.controller.a.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.c();
                    }
                }, 100L);
            }
        }
        this.f = true;
    }

    public final void a(View view) {
        View view2;
        final View viewA = null;
        if (view != null) {
            viewA = d.a(view.getContext(), view);
            this.f2305b.add(view);
        } else {
            List<View> list = this.f2305b;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < this.f2305b.size() && ((view2 = this.f2305b.get(i)) == null || (viewA = d.a(view2.getContext(), view2)) == null); i++) {
                }
            }
        }
        if (viewA == null) {
            return;
        }
        viewA.post(new Runnable() { // from class: com.mbridge.msdk.mbnative.controller.a.3
            @Override // java.lang.Runnable
            public final void run() {
                ViewTreeObserver viewTreeObserver = viewA.getViewTreeObserver();
                if (viewTreeObserver == null || viewTreeObserver.isAlive()) {
                    a.this.a = new WeakReference(viewTreeObserver);
                    if (a.this.c != null) {
                        viewTreeObserver.addOnPreDrawListener(a.this.c);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            this.f = false;
            List<View> list = this.f2305b;
            if (list == null || list.size() <= 0) {
                return;
            }
            ArrayList<View> arrayList = new ArrayList<>();
            ArrayList<View> arrayList2 = new ArrayList<>();
            for (int i = 0; i < this.f2305b.size(); i++) {
                View view = this.f2305b.get(i);
                if (b(view)) {
                    arrayList.add(view);
                } else {
                    arrayList2.add(view);
                }
            }
            InterfaceC0492a interfaceC0492a = this.d;
            if (interfaceC0492a != null) {
                interfaceC0492a.a(arrayList, arrayList2);
            }
            if (arrayList.size() > 0) {
                a();
            }
            arrayList.clear();
            arrayList2.clear();
        } catch (Exception unused) {
        }
    }

    private boolean b(View view) {
        return !an.a(view, this.g);
    }

    public final void a() {
        try {
            this.f = false;
            WeakReference<ViewTreeObserver> weakReference = this.a;
            if (weakReference != null && weakReference.get() != null) {
                ViewTreeObserver viewTreeObserver = this.a.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.c);
                }
                this.a.clear();
            }
            this.d = null;
            this.c = null;
            List<View> list = this.f2305b;
            if (list != null) {
                list.clear();
            }
            this.f2305b = null;
        } catch (Throwable unused) {
        }
    }
}
