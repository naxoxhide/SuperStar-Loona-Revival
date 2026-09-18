package com.tnkfactory.ad.pub.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tapjoy.TapjoyConstants;
import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.AdItem;
import com.tnkfactory.ad.BannerAdView;
import com.tnkfactory.ad.Logger;

/* JADX INFO: loaded from: classes4.dex */
public final class m extends r {
    public BannerAdView f;
    public int g;
    public int h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public int n;
    public Handler o;
    public c p;
    public long q;
    public long r;
    public long s;
    public long t;
    public long u;
    public ViewTreeObserver.OnPreDrawListener v;

    public class a implements Handler.Callback {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            d0 d0VarA;
            BannerAdView bannerAdView;
            AdError adError;
            AdError adError2;
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    return false;
                }
                m.this.c(this.a);
                return true;
            }
            m mVar = m.this;
            Context context = this.a;
            BannerAdView bannerAdView2 = mVar.f;
            if (bannerAdView2 != null) {
                if (mVar.d != 2) {
                    adError2 = AdError.FAIL_SHOW_BEFORE_LOAD;
                } else if (mVar.n == 0) {
                    mVar.a(bannerAdView2, AdError.FAIL_BANNER_ON_PAUSE);
                    Logger.d(u.a("e4790f98ec43d163f26c24413bfc3bf09adb160a214186"));
                } else if (mVar.u <= 0 || !mVar.a(context)) {
                    if (mVar.f.getChildCount() > 0) {
                        mVar.f.removeAllViews();
                    }
                    mVar.q = mVar.e.R;
                    c cVar = mVar.p;
                    if (cVar != null) {
                        cVar.b(1000L);
                    }
                    com.tnkfactory.ad.pub.a aVar = mVar.e;
                    if (aVar != null && aVar.M >= 26) {
                        mVar.f.removeAllViews();
                        float f = mVar.e.M == 90 ? 100.0f : 50.0f;
                        int iApplyDimension = (int) TypedValue.applyDimension(1, f, mVar.f.getResources().getDisplayMetrics());
                        float f2 = mVar.m;
                        if (f2 < iApplyDimension * 0.85f) {
                            if (f == 50.0f) {
                                bannerAdView = mVar.f;
                                adError = AdError.FAIL_BANNER_HEIGHT_50DP;
                            } else {
                                bannerAdView = mVar.f;
                                adError = AdError.FAIL_BANNER_HEIGHT_100DP;
                            }
                            mVar.a(bannerAdView, adError);
                            mVar.b();
                            d0VarA = null;
                        } else {
                            com.tnkfactory.ad.pub.a aVar2 = mVar.e;
                            aVar2.Z = (int) (((double) mVar.l) + 0.5d);
                            aVar2.a0 = (int) (((double) f2) + 0.5d);
                            d0VarA = d0.a(context, aVar2);
                        }
                        if (d0VarA == null || !d0VarA.j) {
                            mVar.a(mVar.f, AdError.FAIL_AD_FRAME);
                        } else {
                            d0VarA.c = new n(mVar);
                            com.tnkfactory.ad.pub.a aVar3 = mVar.e;
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(aVar3.Z, aVar3.a0);
                            layoutParams.addRule(13);
                            mVar.f.addView(d0VarA, layoutParams);
                            if (mVar.e.V) {
                                d0VarA.k = new o(mVar, layoutParams);
                            }
                            y0.a(context).a(mVar.a);
                            mVar.u = System.currentTimeMillis();
                        }
                    }
                } else {
                    mVar.c(context);
                }
                return true;
            }
            adError2 = AdError.FAIL_SYSTEM;
            mVar.a(bannerAdView2, adError2);
            return true;
        }
    }

    public class c extends HandlerThread implements Handler.Callback {
        public Handler a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Context f2877b;

        public c(Context context) {
            super(u.a("e4790f98ec43b06fdf7065473beb"));
            this.f2877b = context;
        }

        public final void a() {
            if (this.a == null) {
                this.a = new Handler(getLooper(), this);
            }
            this.a.sendEmptyMessage(1);
        }

        public final void a(long j) {
            if (this.a == null) {
                this.a = new Handler(getLooper(), this);
            }
            this.a.sendEmptyMessageDelayed(1, j);
        }

        public final void b() {
            if (this.a == null) {
                this.a = new Handler(getLooper(), this);
            }
            this.a.sendEmptyMessage(0);
        }

        public final void b(long j) {
            if (this.a == null) {
                this.a = new Handler(getLooper(), this);
            }
            this.a.removeMessages(0);
            this.a.sendEmptyMessageDelayed(0, j);
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            Handler handler;
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    return false;
                }
                m mVar = m.this;
                if (mVar.n != 0 && (handler = mVar.o) != null) {
                    handler.sendEmptyMessage(1);
                }
                return true;
            }
            m mVar2 = m.this;
            if (mVar2.n == 0 || !mVar2.f(this.f2877b)) {
                return true;
            }
            m mVar3 = m.this;
            long j = mVar3.q;
            if (j > 0) {
                mVar3.q = j - 1;
                b(1000L);
                return true;
            }
            Handler handler2 = mVar3.o;
            if (handler2 != null) {
                handler2.sendEmptyMessage(0);
            }
            return true;
        }
    }

    public m(AdItem adItem, String str) {
        super(str);
        this.n = 1;
        this.o = null;
        this.p = null;
        this.q = 0L;
        this.r = 0L;
        this.s = 0L;
        this.t = 0L;
        this.u = 0L;
        this.v = null;
        BannerAdView bannerAdView = (BannerAdView) adItem;
        this.f = bannerAdView;
        l0.a aVarB = l0.b(bannerAdView.getContext());
        this.g = aVarB.e();
        this.h = aVarB.d();
        DisplayMetrics displayMetrics = this.f.getResources().getDisplayMetrics();
        this.i = (int) TypedValue.applyDimension(1, 320.0f, displayMetrics);
        this.j = (int) TypedValue.applyDimension(1, 360.0f, displayMetrics);
        this.k = (int) TypedValue.applyDimension(1, 50.0f, displayMetrics);
        g(this.f.getContext());
    }

    public static RelativeLayout a(m mVar, Context context, TextView textView) {
        mVar.getClass();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setBackgroundColor(Color.parseColor("#00000000"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        textView.setLayoutParams(layoutParams);
        textView.setPadding((int) TypedValue.applyDimension(1, 7.0f, context.getResources().getDisplayMetrics()), 0, (int) TypedValue.applyDimension(1, 7.0f, context.getResources().getDisplayMetrics()), 0);
        textView.setGravity(17);
        textView.setMaxEms(7);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setTextColor(l0.a("0xFFFFFFFF", "0xFF006B00"));
        textView.setTextSize(2, 15.0f);
        textView.setText(m0.a().d);
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (Build.VERSION.SDK_INT >= 21) {
            gradientDrawable.setColor(l0.a("0xFF00BF00", "0xFF008F00"));
        } else {
            gradientDrawable.setColor(Color.parseColor("#00BF00"));
        }
        textView.setBackground(gradientDrawable);
        textView.setVisibility(4);
        relativeLayout.addView(textView);
        if (textView.getVisibility() != 0) {
            Animation animationA = l.a("right");
            animationA.setAnimationListener(new p(textView));
            textView.setAnimation(animationA);
            textView.setVisibility(0);
            relativeLayout.setOnClickListener(null);
        }
        return relativeLayout;
    }

    @Override // com.tnkfactory.ad.pub.a.r
    public final int[] a(int i, int i2) {
        float f;
        int i3;
        float f2 = this.k;
        float f3 = this.i;
        com.tnkfactory.ad.pub.a aVar = this.e;
        if (aVar != null) {
            int i4 = aVar.M;
            if (i4 == 90) {
                f2 *= 2.0f;
            }
            int i5 = aVar.m;
            if (i5 > 0 && (i3 = aVar.n) > 0) {
                float f4 = i5 / i3;
                if ((i4 == 26 && f4 > 6.4f) || (i4 == 90 && f4 > 3.2f)) {
                    f3 = this.j;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            this.m = f2;
        } else {
            float f5 = size;
            this.m = Math.min(f5, f2);
            f2 = f5;
        }
        int mode2 = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i);
        if (mode2 == Integer.MIN_VALUE) {
            f = size2;
            this.l = f;
        } else if (mode2 == 0) {
            size2 = this.g;
            f = size2;
            this.l = f;
        } else {
            f = size2;
            this.l = Math.min(f, f3);
        }
        if (this.h == 0) {
            this.l = Math.min(this.l, f3);
        }
        return new int[]{(int) f, (int) f2};
    }

    @Override // com.tnkfactory.ad.pub.a.r
    public final void b() {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver.OnPreDrawListener onPreDrawListener;
        this.n = 3;
        c cVar = this.p;
        if (cVar != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                cVar.quitSafely();
            } else {
                cVar.quit();
            }
            this.p = null;
        }
        Handler handler = this.o;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.o = null;
        }
        BannerAdView bannerAdView = this.f;
        if (bannerAdView == null || (viewTreeObserver = bannerAdView.getViewTreeObserver()) == null || (onPreDrawListener = this.v) == null) {
            return;
        }
        viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
        this.v = null;
    }

    @Override // com.tnkfactory.ad.pub.a.r
    public final void c(Context context) {
        Handler handler;
        if (!d()) {
            a(this.f, AdError.FAIL_NO_PLACEMENT_ID);
            return;
        }
        BannerAdView bannerAdView = this.f;
        if (bannerAdView == null) {
            a(bannerAdView, AdError.FAIL_SYSTEM);
            return;
        }
        if (this.n == 3) {
            a(bannerAdView, AdError.FAIL_INVALID_STATE);
            return;
        }
        if (this.d == 1) {
            a(bannerAdView, AdError.FAIL_DUP_LOAD);
            return;
        }
        if (this.r > 0 && !a(context)) {
            c cVar = this.p;
            if (cVar != null) {
                cVar.a(20000L);
            }
            a(this.f, AdError.FAIL_CANCELED);
            return;
        }
        this.d = 1;
        this.e = null;
        this.q = 0L;
        this.u = 0L;
        this.t = TapjoyConstants.SESSION_ID_INACTIVITY_TIME;
        c cVar2 = this.p;
        if (cVar2 != null && (handler = cVar2.a) != null) {
            handler.removeCallbacksAndMessages(null);
        }
        new com.tnkfactory.ad.pub.b.h(context).a(this.a, 4, new b());
    }

    public final synchronized boolean f(Context context) {
        boolean zIsInteractive;
        boolean z = false;
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            zIsInteractive = Build.VERSION.SDK_INT >= 21 ? powerManager.isInteractive() : powerManager.isScreenOn();
        } catch (Exception unused) {
            zIsInteractive = false;
        }
        if (!zIsInteractive) {
            if (this.s == 0) {
                this.s = System.currentTimeMillis();
            }
            c cVar = this.p;
            if (cVar != null) {
                cVar.b(1000L);
            }
            return false;
        }
        if (this.f != null) {
            try {
                if (((ViewGroup) this.f.getParent()).getLocalVisibleRect(new Rect())) {
                    boolean z2 = true;
                    if (this.s > 0 && System.currentTimeMillis() - this.s >= this.t) {
                        c cVar2 = this.p;
                        if (cVar2 != null) {
                            if (cVar2.a == null) {
                                cVar2.a = new Handler(cVar2.getLooper(), cVar2);
                            }
                            cVar2.a.sendEmptyMessage(1);
                        }
                        z2 = false;
                    }
                    this.s = 0L;
                    z = z2;
                } else {
                    if (this.s == 0) {
                        this.s = System.currentTimeMillis();
                    }
                    c cVar3 = this.p;
                    if (cVar3 != null) {
                        cVar3.b(1000L);
                    }
                }
            } catch (NullPointerException unused2) {
                Logger.e(this.n == 3 ? u.a("e4790f98ec43d163f26c24413bfc3bf08edf100d2b57d18c1419") : u.a("e4790f98ec43d163f26c24413bfc3bf08edf100d364ad18c1417b86c5ff6a935305ccf59a28323f65f328c4abb"));
            }
        }
        return z;
    }

    public final void g(Context context) {
        this.d = 0;
        this.p = new c(context);
        this.o = new Handler(new a(context));
        this.p.start();
    }

    @Override // com.tnkfactory.ad.pub.a.r
    public final void h() {
        Handler handler;
        if (this.n != 1) {
            return;
        }
        this.n = 0;
        if (this.s == 0) {
            this.s = System.currentTimeMillis();
        }
        c cVar = this.p;
        if (cVar != null && (handler = cVar.a) != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (this.f.getChildAt(0) != null) {
            this.f.getChildAt(0).clearAnimation();
        }
    }

    @Override // com.tnkfactory.ad.pub.a.r
    public final void i() {
        if (d() && this.n == 0) {
            this.n = 1;
            if (this.d != 2 || this.p == null) {
                return;
            }
            if (this.s <= 0 || System.currentTimeMillis() - this.s < this.t) {
                BannerAdView bannerAdView = this.f;
                if (bannerAdView != null) {
                    try {
                        if (!((ViewGroup) bannerAdView.getParent()).isShown()) {
                            throw new Exception();
                        }
                        this.p.b(300L);
                    } catch (Exception unused) {
                        ViewTreeObserver viewTreeObserver = this.f.getViewTreeObserver();
                        q qVar = new q(this, true);
                        this.v = qVar;
                        viewTreeObserver.addOnPreDrawListener(qVar);
                    }
                }
            } else {
                this.p.a();
            }
            this.s = 0L;
        }
    }

    public class b extends com.tnkfactory.ad.pub.b.r {
        public b() {
        }

        @Override // com.tnkfactory.ad.pub.b.r
        public final void a(Throwable th) {
            BannerAdView bannerAdView;
            Logger.e(th.getMessage() == null ? th.toString() : th.getMessage());
            m mVar = m.this;
            if (mVar.n == 3) {
                return;
            }
            mVar.d = 0;
            long jCurrentTimeMillis = System.currentTimeMillis();
            m mVar2 = m.this;
            if (jCurrentTimeMillis - mVar2.r >= mVar2.t && (bannerAdView = mVar2.f) != null && bannerAdView.getChildCount() > 0) {
                m.this.f.removeAllViews();
                m.this.f.invalidate();
            }
            c cVar = m.this.p;
            if (cVar != null) {
                cVar.a(20000L);
            }
            m mVar3 = m.this;
            mVar3.a(mVar3.f, AdError.FAIL_SYSTEM);
        }

        @Override // com.tnkfactory.ad.pub.b.r
        public final void a(Object obj) {
            BannerAdView bannerAdView;
            m mVar = m.this;
            if (mVar.n == 3) {
                return;
            }
            com.tnkfactory.ad.pub.a aVar = (com.tnkfactory.ad.pub.a) obj;
            mVar.e = aVar;
            if (aVar != null && !aVar.a) {
                mVar.r = System.currentTimeMillis();
                m mVar2 = m.this;
                mVar2.t = TapjoyConstants.SESSION_ID_INACTIVITY_TIME;
                long j = mVar2.e.R;
                if (j > 0) {
                    mVar2.t = j * 1000;
                }
                mVar2.d = 2;
                mVar2.b(mVar2.f);
                BannerAdView bannerAdView2 = m.this.f;
                if (bannerAdView2 == null) {
                    return;
                }
                try {
                    if (!((ViewGroup) bannerAdView2.getParent()).isShown()) {
                        throw new Exception();
                    }
                    c cVar = m.this.p;
                    if (cVar != null) {
                        cVar.b();
                    }
                    m.this.f.requestLayout();
                } catch (Exception unused) {
                    m mVar3 = m.this;
                    BannerAdView bannerAdView3 = mVar3.f;
                    mVar3.getClass();
                    ViewTreeObserver viewTreeObserver = bannerAdView3.getViewTreeObserver();
                    q qVar = new q(mVar3, false);
                    mVar3.v = qVar;
                    viewTreeObserver.addOnPreDrawListener(qVar);
                }
            } else {
                mVar.d = 0;
                long jCurrentTimeMillis = System.currentTimeMillis();
                m mVar4 = m.this;
                if (jCurrentTimeMillis - mVar4.r >= mVar4.t && (bannerAdView = mVar4.f) != null && bannerAdView.getChildCount() > 0) {
                    m.this.f.removeAllViews();
                    m.this.f.invalidate();
                }
                c cVar2 = m.this.p;
                if (cVar2 != null) {
                    cVar2.a(TapjoyConstants.SESSION_ID_INACTIVITY_TIME);
                }
                com.tnkfactory.ad.pub.a aVar2 = m.this.e;
                AdError adErrorC = aVar2 == null ? AdError.FAIL_NO_AD : aVar2.c();
                m mVar5 = m.this;
                mVar5.a(mVar5.f, adErrorC);
            }
        }
    }
}
