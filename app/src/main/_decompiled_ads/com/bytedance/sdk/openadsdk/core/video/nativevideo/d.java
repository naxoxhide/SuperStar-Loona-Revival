package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.y;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: NativeVideoDetailLayout.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends com.bytedance.sdk.openadsdk.core.video.nativevideo.e {
    private TextView H;
    private ImageView I;
    private View J;
    private TextView K;
    private TextView L;
    private TextView M;
    private ImageView N;
    private View O;
    private ImageView P;
    private TextView Q;
    private View R;
    private SeekBar S;
    private TextView T;
    private TextView U;
    private ImageView V;
    private final y W;
    private boolean X;
    private int Y;
    private int Z;
    private int a0;
    private int b0;
    private int c0;
    private final Rect d0;
    private ColorStateList e0;
    private float f0;
    private final Rect g0;
    private int h0;
    private boolean i0;
    private int j0;
    private int k0;
    private com.bytedance.sdk.openadsdk.core.widget.d l0;
    private boolean m0;
    private final View.OnTouchListener n0;
    private float o0;
    private ColorStateList p0;
    private float q0;
    private final Rect r0;
    private float s0;
    private ColorStateList t0;
    private float u0;
    private final Rect v0;
    private final Rect w0;
    private boolean x0;

    /* JADX INFO: compiled from: NativeVideoDetailLayout.java */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.o()) {
                d dVar = d.this;
                dVar.y.f(dVar, view);
            }
        }
    }

    /* JADX INFO: compiled from: NativeVideoDetailLayout.java */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.o()) {
                d dVar = d.this;
                dVar.y.b(dVar, view);
            }
        }
    }

    /* JADX INFO: compiled from: NativeVideoDetailLayout.java */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.o()) {
                d dVar = d.this;
                dVar.y.d(dVar, view);
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NativeVideoDetailLayout.java */
    class ViewOnClickListenerC0218d implements View.OnClickListener {
        ViewOnClickListenerC0218d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.b(false, true);
            d.this.y();
            d.this.w();
            if (d.this.o()) {
                d dVar = d.this;
                dVar.y.a(dVar, view);
            }
        }
    }

    /* JADX INFO: compiled from: NativeVideoDetailLayout.java */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.o()) {
                d dVar = d.this;
                dVar.y.e(dVar, view);
            }
        }
    }

    /* JADX INFO: compiled from: NativeVideoDetailLayout.java */
    class f implements SeekBar.OnSeekBarChangeListener {
        f() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (d.this.o()) {
                d dVar = d.this;
                dVar.y.a(dVar, i, z);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            if (!d.this.X && d.this.w != null) {
                seekBar.setThumb(t.f(o.a(), "tt_seek_thumb_press"));
            }
            if (d.this.o()) {
                seekBar.setThumbOffset(0);
                d dVar = d.this;
                dVar.y.a(dVar, seekBar.getProgress());
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!d.this.X && d.this.w != null) {
                seekBar.setThumb(t.f(o.a(), "tt_seek_thumb_normal"));
            }
            if (d.this.o()) {
                seekBar.setThumbOffset(0);
                d dVar = d.this;
                dVar.y.b(dVar, seekBar.getProgress());
            }
        }
    }

    /* JADX INFO: compiled from: NativeVideoDetailLayout.java */
    class g implements View.OnTouchListener {
        private float a;

        g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            float x = motionEvent.getX();
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1) {
                    d.this.m0 = Math.abs(this.a - motionEvent.getX()) < 10.0f;
                } else if (actionMasked == 2) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                } else if (actionMasked == 3) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
            } else {
                this.a = x;
            }
            return false;
        }
    }

    public d(Context context, ViewGroup viewGroup, boolean z, int i, q qVar, b.a.a.a.a.a.a.g.c cVar, boolean z2) {
        super(context, viewGroup, z, i, qVar, cVar, z2);
        this.W = new y(this);
        this.X = false;
        this.Y = 0;
        this.Z = 0;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = new Rect();
        this.g0 = new Rect();
        this.h0 = 0;
        this.j0 = 0;
        this.k0 = 0;
        this.l0 = null;
        this.n0 = new g();
        this.r0 = new Rect();
        this.v0 = new Rect();
        this.w0 = new Rect();
        this.w = o.a().getApplicationContext();
        b(z2);
        this.a = viewGroup;
        this.s = z;
        com.bytedance.sdk.openadsdk.core.widget.d dVar = new com.bytedance.sdk.openadsdk.core.widget.d(this);
        this.l0 = dVar;
        dVar.a(this.s);
        DisplayMetrics displayMetrics = this.w.getResources().getDisplayMetrics();
        this.j0 = displayMetrics.widthPixels;
        this.k0 = displayMetrics.heightPixels;
        this.u = i;
        this.B = cVar;
        this.v = qVar;
        f(8);
        a(context, this.a);
        n();
        l();
    }

    private void A() {
        DisplayMetrics displayMetrics = this.w.getResources().getDisplayMetrics();
        TextView textView = this.U;
        if (textView != null) {
            this.o0 = textView.getTextSize();
            this.U.setTextSize(2, 14.0f);
            ColorStateList textColors = this.U.getTextColors();
            this.p0 = textColors;
            if (textColors != null) {
                this.U.setTextColor(t.c(this.w, "tt_ssxinzi15"));
            }
            this.q0 = this.U.getAlpha();
            this.U.setAlpha(0.85f);
            this.U.setShadowLayer(0.0f, b0.a(this.w, 0.5f), b0.a(this.w, 0.5f), t.c(this.w, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams = this.U.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.r0.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                b0.b(this.U, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.r0.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.r0.bottom);
            }
        }
        TextView textView2 = this.T;
        if (textView2 != null) {
            this.s0 = textView2.getTextSize();
            this.T.setTextSize(2, 14.0f);
            ColorStateList textColors2 = this.T.getTextColors();
            this.t0 = textColors2;
            if (textColors2 != null) {
                this.T.setTextColor(t.c(this.w, "tt_ssxinzi15"));
            }
            this.u0 = this.T.getAlpha();
            this.T.setAlpha(0.85f);
            this.T.setShadowLayer(0.0f, b0.a(this.w, 0.5f), b0.a(this.w, 0.5f), t.c(this.w, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams2 = this.T.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                this.v0.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                TextView textView3 = this.T;
                int iApplyDimension = (int) TypedValue.applyDimension(1, 14.0f, displayMetrics);
                Rect rect = this.v0;
                b0.b(textView3, iApplyDimension, rect.top, rect.right, rect.bottom);
            }
        }
        ImageView imageView = this.V;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                this.w0.set(marginLayoutParams3.leftMargin, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                ImageView imageView2 = this.V;
                Rect rect2 = this.w0;
                b0.b(imageView2, rect2.left, rect2.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.w0.bottom);
            }
        }
        ImageView imageView3 = this.V;
        if (imageView3 != null) {
            imageView3.setImageDrawable(t.f(this.w, "tt_shrink_fullscreen"));
        }
        TextView textView4 = this.L;
        if (textView4 != null) {
            ColorStateList textColors3 = textView4.getTextColors();
            this.e0 = textColors3;
            if (textColors3 != null) {
                this.L.setTextColor(t.c(this.w, "tt_ssxinzi15"));
            }
            this.f0 = this.L.getAlpha();
            this.L.setAlpha(0.85f);
            ViewGroup.LayoutParams layoutParams4 = this.L.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                this.g0.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                TextView textView5 = this.L;
                int iApplyDimension2 = (int) TypedValue.applyDimension(1, 1.0f, displayMetrics);
                Rect rect3 = this.v0;
                b0.b(textView5, iApplyDimension2, rect3.top, rect3.right, rect3.bottom);
            }
        }
        View view = this.J;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            this.h0 = layoutParams5.height;
            layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            this.J.setLayoutParams(layoutParams5);
            this.J.setBackgroundResource(t.e(this.w, "tt_shadow_fullscreen_top"));
        }
        b(this.i0, true);
    }

    private void z() {
        TextView textView = this.U;
        if (textView != null) {
            textView.setTextSize(0, this.o0);
            ColorStateList colorStateList = this.p0;
            if (colorStateList != null) {
                this.U.setTextColor(colorStateList);
            }
            this.U.setAlpha(this.q0);
            this.U.setShadowLayer(b0.a(this.w, 1.0f), 0.0f, 0.0f, t.c(this.w, "tt_video_shadow_color"));
            TextView textView2 = this.U;
            Rect rect = this.r0;
            b0.b(textView2, rect.left, rect.top, rect.right, rect.bottom);
        }
        TextView textView3 = this.T;
        if (textView3 != null) {
            textView3.setTextSize(0, this.s0);
            ColorStateList colorStateList2 = this.t0;
            if (colorStateList2 != null) {
                this.T.setTextColor(colorStateList2);
            }
            this.T.setAlpha(this.u0);
            this.T.setShadowLayer(b0.a(this.w, 1.0f), 0.0f, 0.0f, t.c(this.w, "tt_video_shadow_color"));
            TextView textView4 = this.T;
            Rect rect2 = this.v0;
            b0.b(textView4, rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
        ImageView imageView = this.V;
        if (imageView != null) {
            Rect rect3 = this.w0;
            b0.b(imageView, rect3.left, rect3.top, rect3.right, rect3.bottom);
        }
        ImageView imageView2 = this.V;
        if (imageView2 != null) {
            imageView2.setImageDrawable(t.f(this.w, "tt_enlarge_video"));
        }
        TextView textView5 = this.L;
        if (textView5 != null) {
            ColorStateList colorStateList3 = this.e0;
            if (colorStateList3 != null) {
                textView5.setTextColor(colorStateList3);
            }
            this.L.setAlpha(this.f0);
            TextView textView6 = this.L;
            Rect rect4 = this.v0;
            b0.b(textView6, rect4.left, rect4.top, rect4.right, rect4.bottom);
        }
        View view = this.J;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.h0;
            this.J.setLayoutParams(layoutParams);
            this.J.setBackgroundResource(t.e(this.w, "tt_video_black_desc_gradient"));
        }
        b(this.i0, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
    public void b(ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        m.b("FullScreen", "Detail exitFullScreen.....");
        if (viewGroup == null || (viewGroup2 = this.a) == null || !(viewGroup2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        this.X = false;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.a.getLayoutParams();
        marginLayoutParams.width = this.a0;
        marginLayoutParams.height = this.b0;
        marginLayoutParams.leftMargin = this.Z;
        marginLayoutParams.topMargin = this.Y;
        this.a.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(3, this.c0);
            viewGroup.setLayoutParams(layoutParams2);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            Rect rect = this.d0;
            b0.b(viewGroup, rect.left, rect.top, rect.right, rect.bottom);
        }
        e(true);
        this.V.setImageDrawable(t.f(this.w, "tt_enlarge_video"));
        this.S.setThumb(t.f(this.w, "tt_seek_thumb_normal"));
        this.S.setThumbOffset(0);
        b.a.a.a.a.a.b.f.a.a((View) this.a, true);
        d(this.X);
        b0.a(this.J, 8);
        if ((this.u & 2) == 2) {
            b0.a((View) this.H, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e, b.a.a.a.a.a.a.g.b
    public void c() {
        a(false, this.s);
        i();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
    public void d(int i) {
        View view = this.R;
        if (view == null || view.getVisibility() != 0) {
            this.S.setProgress(i);
        }
    }

    public void e(boolean z) {
        int i = d() ? this.k0 : this.o;
        int dimensionPixelSize = d() ? this.j0 : this.p;
        if (this.r <= 0 || this.q <= 0 || i <= 0) {
            return;
        }
        if (!p() && !d() && (this.u & 8) != 8) {
            dimensionPixelSize = this.w.getResources().getDimensionPixelSize(t.d(this.w, "tt_video_container_maxheight"));
        }
        float f2 = this.q;
        float f3 = this.r;
        int i2 = (int) (((i * 1.0f) / f2) * f3);
        if (i2 > dimensionPixelSize) {
            i = (int) (f2 * ((dimensionPixelSize * 1.0f) / f3));
        } else {
            dimensionPixelSize = i2;
        }
        if (!z && !d()) {
            i = this.o;
            dimensionPixelSize = this.p;
        }
        this.f686b.a(i, dimensionPixelSize);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
    public void f(int i) {
        b0.a((View) this.a, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
    protected void n() {
        super.n();
        this.l0.a(this.a);
        b0.a((View) this.I, (this.s || (this.u & 1) == 1) ? 8 : 0);
        this.I.setOnClickListener(new a());
        b0.a((View) this.H, (!this.s || (this.u & 2) == 2) ? 0 : 8);
        this.H.setOnClickListener(new b());
        this.N.setOnClickListener(new c());
        this.P.setOnClickListener(new ViewOnClickListenerC0218d());
        this.V.setOnClickListener(new e());
        this.S.setThumbOffset(0);
        this.S.setOnSeekBarChangeListener(new f());
        this.S.setOnTouchListener(this.n0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
    public boolean p() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
    public boolean q() {
        return this.t;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
    public void t() {
        this.S.setProgress(0);
        this.S.setSecondaryProgress(0);
        this.T.setText(t.j(this.w, "tt_00_00"));
        this.U.setText(t.j(this.w, "tt_00_00"));
        f(8);
        if (g()) {
            this.f686b.setVisibility(8);
        }
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        f(8);
        b0.a(this.R, 8);
        b0.a(this.h, 8);
        b0.a((View) this.i, 8);
        b0.a(this.j, 8);
        b0.a((View) this.k, 8);
        b0.a((View) this.l, 8);
        b0.a((View) this.m, 8);
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.x;
        if (eVar != null) {
            eVar.a(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
    public void u() {
        this.W.removeMessages(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
    public void v() {
        this.W.removeMessages(1);
        this.W.sendMessageDelayed(this.W.obtainMessage(1), 2000L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
    public void w() {
        q qVar;
        b0.f(this.d);
        b0.f(this.e);
        b0.d(this.O);
        if (this.f != null && (qVar = this.v) != null && qVar.N0() != null && this.v.N0().b() != null) {
            b0.f(this.f);
            com.bytedance.sdk.openadsdk.n.c.b().a(this.v.N0().b(), this.v.N0().c(), this.v.N0().a(), this.f, this.v);
        }
        if (this.c.getVisibility() == 0) {
            b0.a((View) this.c, 8);
        }
    }

    public void y() {
        b0.d(this.d);
        b0.d(this.O);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e, b.a.a.a.a.a.a.g.b
    public /* bridge */ /* synthetic */ void a(q qVar, WeakReference weakReference, boolean z) {
        a(qVar, (WeakReference<Context>) weakReference, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
    public void c(boolean z) {
        TextView textView = this.K;
        if (textView != null) {
            if (this.s) {
                b0.a((View) textView, 8);
            } else {
                b0.a((View) textView, z ? 0 : 8);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
    protected void a(Context context, View view) {
        super.a(context, view);
        this.H = (TextView) view.findViewById(h.Z0);
        this.I = (ImageView) view.findViewById(h.N0);
        this.J = view.findViewById(h.P0);
        this.N = (ImageView) view.findViewById(h.Q0);
        this.K = (TextView) view.findViewById(h.O0);
        this.L = (TextView) view.findViewById(h.R0);
        this.M = (TextView) view.findViewById(h.T0);
        this.O = view.findViewById(h.K0);
        this.P = (ImageView) view.findViewById(h.L0);
        TextView textView = (TextView) view.findViewById(h.M0);
        this.Q = textView;
        textView.setText(t.k(context, "tt_video_retry_des_txt"));
        this.S = (SeekBar) view.findViewById(h.W0);
        this.T = (TextView) view.findViewById(h.X0);
        this.U = (TextView) view.findViewById(h.V0);
        this.R = view.findViewById(h.U0);
        this.V = (ImageView) view.findViewById(h.Y0);
        this.g = view.findViewById(h.D0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e, com.bytedance.sdk.openadsdk.core.widget.e.c
    public boolean d() {
        return this.X;
    }

    private void d(boolean z) {
        if (z) {
            A();
        } else {
            z();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e, com.bytedance.sdk.openadsdk.core.widget.d.b
    public boolean f() {
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.x;
        return eVar != null && eVar.c();
    }

    public void a(String str) {
        TextView textView = this.K;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.L;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
    public void a(long j, long j2) {
        this.T.setText(b.a.a.a.a.a.b.f.a.a(j2));
        this.U.setText(b.a.a.a.a.a.b.f.a.a(j));
        this.S.setProgress(b.a.a.a.a.a.b.f.a.a(j, j2));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
    public void a(long j) {
        this.U.setText(b.a.a.a.a.a.b.f.a.a(j));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
    public void a(q qVar, WeakReference<Context> weakReference, boolean z) {
        String strB;
        String strK;
        q qVar2;
        if (qVar == null) {
            return;
        }
        a(this.a, o.a());
        a(false, this.s);
        b0.a(this.h, 0);
        b0.a((View) this.i, 0);
        b0.a(this.j, 0);
        if (this.i != null && (qVar2 = this.v) != null && qVar2.N0() != null && this.v.N0().b() != null) {
            com.bytedance.sdk.openadsdk.n.c.b().a(this.v.N0().b(), this.v.N0().c(), this.v.N0().a(), this.i, this.v);
        }
        if (!TextUtils.isEmpty(qVar.F0())) {
            strB = qVar.F0();
        } else if (!TextUtils.isEmpty(qVar.K0())) {
            strB = qVar.K0();
        } else {
            strB = !TextUtils.isEmpty(qVar.B()) ? qVar.B() : "";
        }
        q qVar3 = this.v;
        if (qVar3 != null && qVar3.b0() != null && this.v.b0().d() != null) {
            b0.a((View) this.k, 0);
            b0.a((View) this.l, 4);
            if (this.k != null) {
                com.bytedance.sdk.openadsdk.n.c.b().a(this.v.b0(), this.k, qVar);
                this.k.setOnClickListener(this.C);
                this.k.setOnTouchListener(this.C);
            }
        } else if (!TextUtils.isEmpty(strB)) {
            b0.a((View) this.k, 4);
            b0.a((View) this.l, 0);
            TextView textView = this.l;
            if (textView != null) {
                textView.setText(strB.substring(0, 1));
                this.l.setOnClickListener(this.C);
                this.l.setOnTouchListener(this.C);
            }
        }
        if (this.m != null && !TextUtils.isEmpty(strB)) {
            this.m.setText(strB);
        }
        b0.a((View) this.m, 0);
        b0.a((View) this.n, 0);
        int iE0 = qVar.e0();
        if (iE0 == 2 || iE0 == 3) {
            strK = t.k(this.w, "tt_video_mobile_go_detail");
        } else if (iE0 == 4) {
            strK = t.k(this.w, "tt_video_download_apk");
        } else if (iE0 != 5) {
            strK = t.k(this.w, "tt_video_mobile_go_detail");
        } else {
            strK = t.k(this.w, "tt_video_dial_phone");
        }
        TextView textView2 = this.n;
        if (textView2 != null) {
            textView2.setText(strK);
            this.n.setOnClickListener(this.C);
            this.n.setOnTouchListener(this.C);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
    public boolean b(int i) {
        SeekBar seekBar = this.S;
        return seekBar != null && i > seekBar.getSecondaryProgress();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e, com.bytedance.sdk.openadsdk.core.widget.d.b
    public void b() {
        a();
        c(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
    public void a(ViewGroup viewGroup) {
        if (viewGroup != null && (this.a.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.X = true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.a.getLayoutParams();
            this.Z = marginLayoutParams.leftMargin;
            this.Y = marginLayoutParams.topMargin;
            this.a0 = marginLayoutParams.width;
            this.b0 = marginLayoutParams.height;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            this.a.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int[] rules = layoutParams2.getRules();
                this.c0 = rules.length > 0 ? rules[3] : 0;
                layoutParams2.addRule(3, 0);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                this.d0.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                b0.b(viewGroup, 0, 0, 0, 0);
            }
            e(true);
            this.V.setImageDrawable(t.f(this.w, "tt_shrink_video"));
            this.S.setThumb(t.f(this.w, "tt_seek_thumb_fullscreen_selector"));
            this.S.setThumbOffset(0);
            b.a.a.a.a.a.b.f.a.a((View) this.a, false);
            d(this.X);
            b0.a(this.J, 8);
            if (!this.s) {
                b0.a((View) this.I, 8);
                b0.a((View) this.H, 8);
            } else if ((this.u & 1) == 1) {
                b0.a((View) this.I, 8);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e, com.bytedance.sdk.component.utils.y.a
    public void a(Message message) {
        if (message.what != 1) {
            return;
        }
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
    public void a(boolean z, boolean z2, boolean z3) {
        b0.a(this.R, 0);
        if (this.X) {
            b0.a(this.J, 0);
            b0.a((View) this.L, 0);
        } else if (z3) {
            b0.a(this.J, 8);
        }
        b0.a((View) this.c, (!z || this.d.getVisibility() == 0) ? 8 : 0);
        if (!this.s && !this.X) {
            if ((this.u & 1) != 1 && !z3) {
                b0.a((View) this.I, 0);
            }
            b0.a((View) this.H, z3 ? 8 : 0);
        }
        b0.a((View) this.T, 0);
        b0.a((View) this.U, 0);
        b0.a((View) this.S, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
    public void a(boolean z, boolean z2) {
        b0.a(this.R, 8);
        b0.a(this.J, 8);
        b0.a((View) this.c, 8);
        if (!this.s && !this.X) {
            b0.a((View) this.I, 8);
            if ((this.u & 2) != 2) {
                b0.a((View) this.H, 8);
            }
        } else if ((this.u & 1) == 1) {
            b0.a((View) this.I, 8);
        }
        if (z2) {
            b0.a((View) this.I, 8);
            b0.a((View) this.H, 8);
        }
        c(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e, com.bytedance.sdk.openadsdk.core.widget.e.c
    public void a() {
        a(true, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e, com.bytedance.sdk.openadsdk.core.widget.d.b
    public void a(View view, boolean z) {
        if (d()) {
            String str = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            q qVar = this.v;
            if (qVar != null && !TextUtils.isEmpty(qVar.K0())) {
                a(this.v.K0());
            }
            this.M.setText(str);
        } else {
            a("");
            this.M.setText("");
        }
        if (this.z) {
            return;
        }
        c(this.s && !this.X);
        if (o()) {
            this.y.a(this, view, true, this.d.getVisibility() != 0);
        }
    }
}
