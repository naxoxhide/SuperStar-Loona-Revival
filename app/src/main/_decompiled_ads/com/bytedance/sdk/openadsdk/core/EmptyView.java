package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class EmptyView extends View implements com.bytedance.sdk.component.utils.y.a {
    private boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f553b;
    private d c;
    private View d;
    private List<View> e;
    private List<View> f;
    private int g;
    private final Handler h;
    private final AtomicBoolean i;
    private ViewTreeObserver.OnGlobalLayoutListener j;
    private boolean k;
    private final Runnable l;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            EmptyView.this.e();
            EmptyView.this.d();
        }
    }

    class b implements Runnable {
        final /* synthetic */ ViewTreeObserver a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f554b;

        b(ViewTreeObserver viewTreeObserver, boolean z) {
            this.a = viewTreeObserver;
            this.f554b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewTreeObserver viewTreeObserver;
            if (EmptyView.this.j != null && (viewTreeObserver = this.a) != null) {
                try {
                    viewTreeObserver.removeOnGlobalLayoutListener(EmptyView.this.j);
                } catch (Exception unused) {
                }
            }
            if (this.f554b) {
                EmptyView.this.j = null;
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmptyView.this.k) {
                return;
            }
            if (EmptyView.this.c != null) {
                EmptyView.this.c.a(EmptyView.this.d);
            }
            EmptyView.this.k = true;
        }
    }

    public interface d {
        void a();

        void a(View view);

        void onDetachedFromWindow();

        void onWindowFocusChanged(boolean z);
    }

    public EmptyView(Context context, View view) {
        super(o.a());
        this.h = new com.bytedance.sdk.component.utils.y(l.a().getLooper(), this);
        this.i = new AtomicBoolean(true);
        this.l = new c();
        this.d = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        this.j = new a();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
        if (this.j != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.j);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
        b();
        a(false);
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        a();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        b();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        d dVar = this.c;
        if (dVar != null) {
            dVar.onWindowFocusChanged(z);
        }
    }

    public void setAdType(int i) {
        this.g = i;
    }

    public void setCallback(d dVar) {
        this.c = dVar;
    }

    public void setNeedCheckingShow(boolean z) {
        this.f553b = z;
        if (!z && this.a) {
            e();
        } else {
            if (!z || this.a) {
                return;
            }
            d();
        }
    }

    public void setRefClickViews(List<View> list) {
        this.e = list;
    }

    public void setRefCreativeViews(List<View> list) {
        this.f = list;
    }

    private void b() {
        d dVar;
        if (this.i.getAndSet(true) || (dVar = this.c) == null) {
            return;
        }
        dVar.onDetachedFromWindow();
    }

    private boolean c() {
        View view = this.d;
        if (view instanceof NativeExpressView) {
            return ((NativeExpressView) view).D();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (!this.f553b || this.a) {
            return;
        }
        this.a = true;
        this.h.sendEmptyMessage(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.a) {
            this.h.removeCallbacksAndMessages(null);
            this.a = false;
        }
    }

    public void f() {
        a(this.e, (com.bytedance.sdk.openadsdk.core.c0.c) null);
        a(this.f, (com.bytedance.sdk.openadsdk.core.c0.c) null);
    }

    private void a() {
        d dVar;
        if (!this.i.getAndSet(false) || (dVar = this.c) == null) {
            return;
        }
        dVar.a();
    }

    public void a(List<View> list, com.bytedance.sdk.openadsdk.core.c0.c cVar) {
        if (com.bytedance.sdk.component.utils.k.b(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(cVar);
                    view.setOnTouchListener(cVar);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.utils.y.a
    public void a(Message message) {
        if (message.what == 1 && this.a) {
            if (c() && y.b(this.d, 20, this.g)) {
                e();
                l.c().post(this.l);
                a(true);
                return;
            }
            this.h.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    private void a(boolean z) {
        com.bytedance.sdk.component.utils.i.b().post(new b(getViewTreeObserver(), z));
    }
}
