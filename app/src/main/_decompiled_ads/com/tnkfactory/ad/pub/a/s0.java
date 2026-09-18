package com.tnkfactory.ad.pub.a;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Scroller;

/* JADX INFO: loaded from: classes4.dex */
public final class s0 extends RelativeLayout {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Scroller f2888b;
    public Runnable c;
    public w0 d;
    public HorizontalScrollView e;
    public ScrollView f;
    public LinearLayout g;
    public r0 h;
    public float i;
    public float j;
    public int k;
    public int l;
    public int m;
    public int n;
    public long o;
    public long p;
    public a q;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            s0 s0Var;
            int pageCount;
            if (s0.this.getPageCount() == 0) {
                s0Var = s0.this;
                pageCount = 0;
            } else {
                s0Var = s0.this;
                pageCount = (s0Var.k + 1) % s0Var.getPageCount();
            }
            s0Var.k = pageCount;
            s0 s0Var2 = s0.this;
            s0Var2.a(s0Var2.k);
            s0 s0Var3 = s0.this;
            r0 r0Var = s0Var3.h;
            if (r0Var != null) {
                r0Var.g = s0Var3.k;
                r0Var.invalidate();
            }
            s0 s0Var4 = s0.this;
            s0Var4.postDelayed(this, s0Var4.p);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (s0.this.f2888b.computeScrollOffset()) {
                s0 s0Var = s0.this;
                s0Var.e.scrollTo(s0Var.f2888b.getCurrX(), s0.this.f2888b.getCurrY());
            }
            if (s0.this.f2888b.isFinished()) {
                return;
            }
            s0.this.post(this);
        }
    }

    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            s0 s0Var = s0.this;
            if (view != s0Var.e) {
                return false;
            }
            return s0.a(s0Var, motionEvent);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (s0.this.f2888b.computeScrollOffset()) {
                s0 s0Var = s0.this;
                s0Var.f.scrollTo(s0Var.f2888b.getCurrX(), s0.this.f2888b.getCurrY());
            }
            if (s0.this.f2888b.isFinished()) {
                return;
            }
            s0.this.post(this);
        }
    }

    public class e implements View.OnTouchListener {
        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            s0 s0Var = s0.this;
            if (view != s0Var.f) {
                return false;
            }
            return s0.a(s0Var, motionEvent);
        }
    }

    public s0(Context context, int i, int i2) {
        super(context);
        this.a = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.h = null;
        this.i = -1.0f;
        this.j = -1.0f;
        this.k = 0;
        this.l = 50;
        this.m = 800;
        this.n = 1100;
        this.o = 0L;
        this.p = 2000L;
        this.q = null;
        if (i == 1) {
            b(context, i2);
        } else {
            a(context, i2);
        }
    }

    public static boolean a(s0 s0Var, MotionEvent motionEvent) {
        float f;
        s0Var.getClass();
        int action = motionEvent.getAction();
        if (action == 0) {
            a aVar = s0Var.q;
            if (aVar != null) {
                s0Var.removeCallbacks(aVar);
            }
            s0Var.a();
            float y = s0Var.a == 1 ? motionEvent.getY() : motionEvent.getX();
            s0Var.i = y;
            s0Var.j = y;
        } else {
            if (action == 1) {
                float f2 = s0Var.i - s0Var.j;
                float currentScrollPosition = s0Var.getCurrentScrollPosition();
                if (f2 > 0.0f) {
                    int i = s0Var.m;
                    f = (currentScrollPosition + i) / (i + s0Var.l);
                } else {
                    int i2 = s0Var.m;
                    f = ((currentScrollPosition - i2) / (i2 + s0Var.l)) + 1.0f;
                }
                int i3 = (int) f;
                s0Var.k = i3;
                s0Var.a(i3);
                r0 r0Var = s0Var.h;
                if (r0Var == null) {
                    return true;
                }
                r0Var.g = s0Var.k;
                r0Var.invalidate();
                return true;
            }
            if (action == 2) {
                s0Var.j = s0Var.a == 1 ? motionEvent.getY() : motionEvent.getX();
            } else if (action == 3) {
                s0Var.a();
            }
        }
        return false;
    }

    private int getCurrentScrollPosition() {
        return this.a == 1 ? this.f.getScrollY() : this.e.getScrollX();
    }

    public final void a() {
        if (!this.f2888b.isFinished()) {
            this.f2888b.abortAnimation();
            removeCallbacks(this.c);
        }
        this.i = -1.0f;
        this.j = -1.0f;
    }

    public final void a(int i) {
        int currentScrollPosition;
        int currentScrollPosition2;
        int i2;
        int i3;
        if (getPageCount() == 0) {
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= getPageCount()) {
            i = getPageCount() - 1;
        }
        int currentScrollPosition3 = ((this.m + this.l) * i) - getCurrentScrollPosition();
        float fAbs = Math.abs(currentScrollPosition3);
        int i4 = (int) ((fAbs / (this.n + fAbs)) * 1000.0f);
        int i5 = this.a;
        Scroller scroller = this.f2888b;
        if (i5 == 1) {
            currentScrollPosition2 = getCurrentScrollPosition();
            currentScrollPosition = 0;
            i3 = 0;
            i2 = currentScrollPosition3;
        } else {
            currentScrollPosition = getCurrentScrollPosition();
            currentScrollPosition2 = 0;
            i2 = 0;
            i3 = currentScrollPosition3;
        }
        scroller.startScroll(currentScrollPosition, currentScrollPosition2, i3, i2, i4);
        post(this.c);
    }

    public final void a(Context context, int i) {
        int i2;
        this.a = 0;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context);
        this.e = horizontalScrollView;
        horizontalScrollView.setLayoutParams(layoutParams);
        this.e.setVerticalScrollBarEnabled(false);
        this.e.setHorizontalScrollBarEnabled(false);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        if (i != 1) {
            i2 = i != 2 ? 19 : 83;
        } else {
            i2 = 51;
        }
        layoutParams2.gravity = i2;
        LinearLayout linearLayout = new LinearLayout(context);
        this.g = linearLayout;
        linearLayout.setLayoutParams(layoutParams2);
        this.g.setOrientation(0);
        this.e.addView(this.g);
        addView(this.e);
        this.f2888b = new Scroller(this.e.getContext(), new DecelerateInterpolator(2.0f));
        this.c = new b();
        this.e.setOnTouchListener(new c());
    }

    public final void a(View view) {
        w0 w0Var;
        this.m = this.a == 1 ? view.getLayoutParams().height : view.getLayoutParams().width;
        if (Build.VERSION.SDK_INT >= 21 && (w0Var = this.d) != null) {
            view.setOutlineProvider(w0Var);
        }
        this.g.addView(view);
    }

    public final void b(Context context, int i) {
        int i2;
        this.a = 1;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        ScrollView scrollView = new ScrollView(context);
        this.f = scrollView;
        scrollView.setLayoutParams(layoutParams);
        this.f.setVerticalScrollBarEnabled(false);
        this.f.setHorizontalScrollBarEnabled(false);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        if (i != 1) {
            i2 = i != 2 ? 49 : 53;
        } else {
            i2 = 51;
        }
        layoutParams2.gravity = i2;
        LinearLayout linearLayout = new LinearLayout(context);
        this.g = linearLayout;
        linearLayout.setLayoutParams(layoutParams2);
        this.g.setOrientation(1);
        this.f.addView(this.g);
        addView(this.f);
        this.f2888b = new Scroller(this.f.getContext(), new DecelerateInterpolator(2.0f));
        this.c = new d();
        this.f.setOnTouchListener(new e());
    }

    public int getCurrentPage() {
        return this.k;
    }

    public int getPageCount() {
        LinearLayout linearLayout = this.g;
        if (linearLayout == null) {
            return 0;
        }
        return linearLayout.getChildCount();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        long j = this.o;
        if (j > 0) {
            a aVar = new a();
            this.q = aVar;
            postDelayed(aVar, j);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.q;
        if (aVar != null) {
            removeCallbacks(aVar);
        }
    }

    public void setPageClipRound(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.d = new w0(i);
        }
    }

    public void setPageIndicator(r0 r0Var) {
        r0 r0Var2 = this.h;
        if (r0Var2 != null) {
            removeView(r0Var2);
        }
        this.h = r0Var;
        if (r0Var != null) {
            r0Var.setCount(getPageCount());
            addView(this.h);
        }
    }

    public void setPageMargin(int i) {
        this.l = i;
        this.n = this.a == 1 ? getLayoutParams().height : getLayoutParams().width;
    }
}
