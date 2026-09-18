package com.bytedance.sdk.openadsdk.b.m.q;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.b.a.a.h.u;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.component.reward.view.RatioImageView;
import com.bytedance.sdk.openadsdk.component.reward.view.RewardFullBaseLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.f0.n;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar2;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.b0;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: RewardFullTypeImage.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends com.bytedance.sdk.openadsdk.b.m.q.b {
    private String A;
    private boolean o;
    private int p;
    private View q;
    private RatioImageView r;
    private TTRoundRectImageView s;
    private PAGTextView t;
    private PAGTextView u;
    private PAGTextView v;
    private TTRatingBar2 w;
    private PAGTextView x;
    private PAGTextView y;
    private PAGRelativeLayout z;

    /* JADX INFO: compiled from: RewardFullTypeImage.java */
    class a implements View.OnClickListener {
        final /* synthetic */ TTBaseVideoActivity a;

        a(TTBaseVideoActivity tTBaseVideoActivity) {
            this.a = tTBaseVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                TTBaseVideoActivity tTBaseVideoActivity = this.a;
                g gVar = g.this;
                TTWebsiteActivity.a(tTBaseVideoActivity, gVar.f514b, gVar.A);
            } catch (Throwable th) {
                m.b("TTAD.RFTI", th.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: RewardFullTypeImage.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.LayoutParams layoutParams;
            int i;
            int width = g.this.z.getWidth() / 2;
            if (width < b0.b(o.a(), 90.0f) || (i = (layoutParams = g.this.x.getLayoutParams()).width) <= 0) {
                return;
            }
            layoutParams.width = Math.min(width, i);
            g.this.x.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: compiled from: RewardFullTypeImage.java */
    class c implements View.OnClickListener {
        final /* synthetic */ TTBaseVideoActivity a;

        c(TTBaseVideoActivity tTBaseVideoActivity) {
            this.a = tTBaseVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                TTBaseVideoActivity tTBaseVideoActivity = this.a;
                g gVar = g.this;
                TTWebsiteActivity.a(tTBaseVideoActivity, gVar.f514b, gVar.A);
            } catch (Throwable th) {
                m.b("TTAD.RFTI", th.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: RewardFullTypeImage.java */
    class d implements View.OnClickListener {
        final /* synthetic */ TTBaseVideoActivity a;

        d(TTBaseVideoActivity tTBaseVideoActivity) {
            this.a = tTBaseVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                TTBaseVideoActivity tTBaseVideoActivity = this.a;
                g gVar = g.this;
                TTWebsiteActivity.a(tTBaseVideoActivity, gVar.f514b, gVar.A);
            } catch (Throwable th) {
                m.b("TTAD.RFTI", th.getMessage());
            }
        }
    }

    public g(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        super(aVar);
        this.A = "fullscreen_interstitial_ad";
        this.p = this.f514b.c0();
        this.o = this.a.j == 2;
    }

    private void D() {
        q qVar;
        PAGTextView pAGTextView = this.v;
        if (pAGTextView == null || (qVar = this.f514b) == null) {
            return;
        }
        b0.a(pAGTextView, qVar, this.a.V, "tt_comment_num_backup");
    }

    private void E() {
        if (this.q == null) {
            return;
        }
        TTBaseVideoActivity tTBaseVideoActivity = this.a.V;
        a((View) this.r);
        a((View) this.s);
        a(this.t);
        a(this.u);
        a(this.v);
        a((View) this.w);
        a(this.x);
        this.y.setOnClickListener(new d(tTBaseVideoActivity));
    }

    private void F() {
        this.o = this.a.j == 2;
        m.a("TTAD.RFTI", "initFullImageView: " + this.o + ", " + this.p);
        if (this.o) {
            int i = this.p;
            if (i == 3) {
                K();
                return;
            } else if (i != 33) {
                G();
                return;
            } else {
                I();
                return;
            }
        }
        int i2 = this.p;
        if (i2 == 3) {
            L();
        } else if (i2 != 33) {
            H();
        } else {
            J();
        }
    }

    private void G() {
        this.q = a(this.a.V, 2);
        E();
    }

    private void H() {
        TTBaseVideoActivity tTBaseVideoActivity = this.a.V;
        this.q = b(tTBaseVideoActivity);
        a(this.r);
        a(this.s);
        a(this.t);
        a(this.u);
        a(this.x);
        this.y.setOnClickListener(new c(tTBaseVideoActivity));
    }

    private void I() {
        this.q = a(this.a.V, 0);
        E();
    }

    private void J() {
        this.q = c(this.a.V);
        E();
    }

    private void K() {
        TTBaseVideoActivity tTBaseVideoActivity = this.a.V;
        this.q = d(tTBaseVideoActivity);
        a(this.r);
        a(this.s);
        a(this.t);
        a(this.u);
        a(this.v);
        a(this.x);
        this.y.setOnClickListener(new a(tTBaseVideoActivity));
        this.x.post(new b());
    }

    private void L() {
        this.q = e(this.a.V);
        E();
    }

    private void M() {
        TTRatingBar2 tTRatingBar2 = this.w;
        if (tTRatingBar2 == null) {
            return;
        }
        b0.a((TextView) null, tTRatingBar2, this.f514b);
    }

    private boolean N() {
        q qVar = this.f514b;
        return qVar != null && qVar.w0() == 2;
    }

    public static boolean e(q qVar) {
        return (qVar.f1() || q.c(qVar) || qVar.o() != 100.0f) ? false : true;
    }

    protected String d(q qVar) {
        if (qVar == null) {
            return "";
        }
        if (qVar.h() != null && !TextUtils.isEmpty(qVar.h().a())) {
            return qVar.h().a();
        }
        if (TextUtils.isEmpty(qVar.F0())) {
            return !TextUtils.isEmpty(qVar.K0()) ? qVar.K0() : "";
        }
        return qVar.F0();
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public void o() {
        this.f.e(8);
        this.f.c(8);
        this.g.c(false);
        this.g.b(false);
        if (this.f514b.w0() == 2) {
            this.g.a(false);
            this.f.b(8);
        } else {
            this.g.a(this.f514b.g1());
            this.f.b(0);
            this.g.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public boolean q() {
        return N();
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public boolean r() {
        return N();
    }

    private void a(q qVar) {
        if (qVar == null) {
            return;
        }
        RatioImageView ratioImageView = this.r;
        if (ratioImageView != null) {
            int i = this.p;
            if (i == 33) {
                ratioImageView.setRatio(1.0f);
            } else if (i == 3) {
                ratioImageView.setRatio(1.91f);
            } else {
                ratioImageView.setRatio(0.56f);
            }
            a((ImageView) this.r);
        }
        if (this.s != null && this.f514b.b0() != null && !TextUtils.isEmpty(this.f514b.b0().d())) {
            com.bytedance.sdk.openadsdk.n.c.b().a(this.f514b.b0().d(), this.f514b.b0().e(), this.f514b.b0().b(), this.s, this.f514b);
        }
        PAGTextView pAGTextView = this.t;
        if (pAGTextView != null) {
            pAGTextView.setText(d(this.f514b));
        }
        PAGTextView pAGTextView2 = this.u;
        if (pAGTextView2 != null) {
            pAGTextView2.setText(c(this.f514b));
        }
        M();
        D();
    }

    private b.c.a.a.a.a.c b(q qVar) {
        if (qVar.e0() == 4) {
            return new b.c.a.a.a.a.b(o.a(), qVar, this.A);
        }
        return null;
    }

    protected String c(q qVar) {
        if (qVar == null) {
            return "";
        }
        if (TextUtils.isEmpty(qVar.K0())) {
            return !TextUtils.isEmpty(qVar.B()) ? qVar.B() : "";
        }
        return qVar.K0();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private View b(Context context) {
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        pAGRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.r = new RatioImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.r.setScaleType(ImageView.ScaleType.FIT_XY);
        this.r.setLayoutParams(layoutParams);
        PAGRelativeLayout pAGRelativeLayout2 = new PAGRelativeLayout(context);
        this.z = pAGRelativeLayout2;
        int i = com.bytedance.sdk.openadsdk.utils.h.r0;
        pAGRelativeLayout2.setId(i);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, a(100.0f));
        layoutParams2.addRule(12);
        layoutParams2.setMargins(a(15.0f), a(15.0f), a(15.0f), a(15.0f));
        this.z.setBackgroundColor(Color.parseColor("#E4FFFFFF"));
        this.z.setGravity(16);
        this.z.setPadding(a(15.0f), 0, 0, 0);
        this.z.setLayoutParams(layoutParams2);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        this.s = tTRoundRectImageView;
        int i2 = com.bytedance.sdk.openadsdk.utils.h.s0;
        tTRoundRectImageView.setId(i2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(a(69.0f), a(69.0f));
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        this.s.setBackgroundColor(0);
        this.s.setLayoutParams(layoutParams3);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams4.addRule(1, i2);
        pAGLinearLayout.setGravity(16);
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setLayoutParams(layoutParams4);
        this.t = new PAGTextView(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, a(27.0f));
        layoutParams5.leftMargin = a(14.0f);
        this.t.setEllipsize(TextUtils.TruncateAt.END);
        this.t.setGravity(16);
        this.t.setMaxWidth(a(153.0f));
        this.t.setSingleLine(true);
        this.t.setText("pangle");
        this.t.setTextColor(Color.parseColor("#ff000000"));
        this.t.setTextSize(15.0f);
        this.t.setLayoutParams(layoutParams5);
        this.u = new PAGTextView(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = a(14.0f);
        this.u.setEllipsize(TextUtils.TruncateAt.END);
        this.u.setGravity(16);
        this.u.setMaxWidth(a(153.0f));
        this.u.setSingleLine(true);
        this.u.setTextColor(Color.parseColor("#4A4A4A"));
        this.u.setTextSize(14.0f);
        this.u.setLayoutParams(layoutParams6);
        PAGTextView pAGTextView = new PAGTextView(context);
        this.x = pAGTextView;
        pAGTextView.setId(com.bytedance.sdk.openadsdk.utils.h.t0);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(a(80.0f), a(36.0f));
        layoutParams7.addRule(11);
        layoutParams7.addRule(15);
        layoutParams7.rightMargin = a(15.0f);
        this.x.setBackground(t.f(context, "tt_download_corner_bg"));
        this.x.setGravity(17);
        this.x.setText(t.k(context, "tt_video_download_apk"));
        this.x.setTextColor(Color.parseColor("#ffffff"));
        this.x.setTextSize(15.0f);
        this.x.setLayoutParams(layoutParams7);
        PAGTextView pAGTextView2 = new PAGTextView(context);
        this.y = pAGTextView2;
        pAGTextView2.setId(520093757);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(a(32.0f), a(14.0f));
        layoutParams8.addRule(2, i);
        layoutParams8.leftMargin = a(16.0f);
        layoutParams8.bottomMargin = a(10.0f);
        this.y.setBackground(t.f(context, "tt_ad_logo_new"));
        this.y.setGravity(17);
        this.y.setPadding(a(2.0f), 0, 0, 0);
        this.y.setLayoutParams(layoutParams8);
        pAGRelativeLayout.addView(this.r);
        pAGRelativeLayout.addView(this.z);
        this.z.addView(this.s);
        this.z.addView(pAGLinearLayout);
        pAGLinearLayout.addView(this.t);
        pAGLinearLayout.addView(this.u);
        this.z.addView(this.x);
        pAGRelativeLayout.addView(this.y);
        return pAGRelativeLayout;
    }

    private View e(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        pAGRelativeLayout.setLayoutParams(layoutParams2);
        RatioImageView ratioImageView = new RatioImageView(context);
        this.r = ratioImageView;
        int i = com.bytedance.sdk.openadsdk.utils.h.u0;
        ratioImageView.setId(i);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        this.r.setScaleType(ImageView.ScaleType.FIT_XY);
        this.r.setLayoutParams(layoutParams3);
        PAGTextView pAGTextView = new PAGTextView(context);
        this.y = pAGTextView;
        pAGTextView.setId(520093757);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(a(32.0f), a(14.0f));
        layoutParams4.addRule(8, i);
        this.y.setBackground(t.f(context, "tt_ad_logo_new"));
        this.y.setPadding(a(2.0f), 0, 0, 0);
        this.y.setLayoutParams(layoutParams4);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams5.weight = 2.0f;
        pAGLinearLayout.setGravity(17);
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setLayoutParams(layoutParams5);
        this.s = new TTRoundRectImageView(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(a(80.0f), a(80.0f));
        this.s.setBackgroundColor(0);
        this.s.setLayoutParams(layoutParams6);
        pAGLinearLayout.addView(this.s);
        this.t = new PAGTextView(context);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, a(28.0f));
        this.t.setEllipsize(TextUtils.TruncateAt.END);
        this.t.setMaxWidth(a(180.0f));
        this.t.setSingleLine(true);
        this.t.setText("THE APP NAME");
        this.t.setTextColor(Color.parseColor("#ffffff"));
        this.t.setTextSize(20.0f);
        this.t.setLayoutParams(layoutParams7);
        this.u = new PAGTextView(context);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams8.leftMargin = a(40.0f);
        layoutParams8.topMargin = a(20.0f);
        layoutParams8.rightMargin = a(40.0f);
        this.u.setGravity(17);
        this.u.setTextColor(Color.parseColor("#ffffff"));
        this.u.setTextSize(20.0f);
        this.u.setLayoutParams(layoutParams8);
        this.v = new PAGTextView(context);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, a(20.0f));
        layoutParams9.topMargin = a(50.0f);
        this.v.setEllipsize(TextUtils.TruncateAt.END);
        this.v.setSingleLine(true);
        this.v.setText(t.k(context, "tt_comment_num_backup"));
        this.v.setTextColor(Color.parseColor("#ff93959a"));
        this.v.setTextSize(14.0f);
        this.v.setLayoutParams(layoutParams9);
        this.w = new TTRatingBar2(context, null);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, a(16.0f));
        layoutParams10.gravity = 17;
        layoutParams10.topMargin = a(12.0f);
        this.w.setLayoutParams(layoutParams10);
        this.x = new PAGTextView(context);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, a(40.0f));
        layoutParams11.leftMargin = a(40.0f);
        layoutParams11.rightMargin = a(40.0f);
        layoutParams11.topMargin = a(30.0f);
        this.x.setBackground(t.f(context, "tt_reward_video_download_btn_bg"));
        this.x.setGravity(17);
        this.x.setText(t.k(context, "tt_video_download_apk"));
        this.x.setTextColor(Color.parseColor("#ffffff"));
        this.x.setTextSize(15.0f);
        this.x.setLayoutParams(layoutParams11);
        linearLayout.addView(pAGRelativeLayout);
        pAGRelativeLayout.addView(this.r);
        pAGRelativeLayout.addView(this.y);
        linearLayout.addView(pAGLinearLayout);
        pAGLinearLayout.addView(this.t);
        pAGLinearLayout.addView(this.u);
        pAGLinearLayout.addView(this.v);
        pAGLinearLayout.addView(this.w);
        pAGLinearLayout.addView(this.x);
        return linearLayout;
    }

    private View c(Context context) {
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        pAGRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        PAGRelativeLayout pAGRelativeLayout2 = new PAGRelativeLayout(context);
        int i = com.bytedance.sdk.openadsdk.utils.h.v0;
        pAGRelativeLayout2.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, a(70.0f));
        layoutParams.topMargin = a(45.0f);
        layoutParams.leftMargin = a(20.0f);
        layoutParams.rightMargin = a(20.0f);
        pAGRelativeLayout2.setLayoutParams(layoutParams);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        this.s = tTRoundRectImageView;
        int i2 = com.bytedance.sdk.openadsdk.utils.h.s0;
        tTRoundRectImageView.setId(i2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a(65.0f), a(65.0f));
        layoutParams2.addRule(9);
        layoutParams2.addRule(15);
        this.s.setBackgroundColor(0);
        this.s.setLayoutParams(layoutParams2);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams3.addRule(1, i2);
        pAGLinearLayout.setGravity(16);
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setLayoutParams(layoutParams3);
        this.t = new PAGTextView(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, a(27.0f));
        layoutParams4.leftMargin = a(14.0f);
        this.t.setEllipsize(TextUtils.TruncateAt.END);
        this.t.setGravity(16);
        this.t.setMaxWidth(a(176.0f));
        this.t.setSingleLine(true);
        this.t.setText("Test App Name");
        this.t.setTextColor(Color.parseColor("#ffffffff"));
        this.t.setTextSize(17.0f);
        this.t.setLayoutParams(layoutParams4);
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = a(10.0f);
        pAGLinearLayout2.setGravity(16);
        pAGLinearLayout2.setOrientation(0);
        pAGLinearLayout2.setLayoutParams(layoutParams5);
        this.w = new TTRatingBar2(context, null);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = a(14.0f);
        layoutParams6.gravity = 17;
        this.w.setLayoutParams(layoutParams6);
        this.v = new PAGTextView(context);
        new LinearLayout.LayoutParams(-2, -2).leftMargin = a(10.0f);
        this.v.setEllipsize(TextUtils.TruncateAt.END);
        this.v.setMaxWidth(a(170.0f));
        this.v.setSingleLine(true);
        this.v.setText(t.k(context, "tt_comment_num"));
        this.v.setTextColor(Color.parseColor("#ffffffff"));
        this.v.setTextSize(13.0f);
        RatioImageView ratioImageView = new RatioImageView(context);
        this.r = ratioImageView;
        int i3 = com.bytedance.sdk.openadsdk.utils.h.u0;
        ratioImageView.setId(i3);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams7.topMargin = a(31.0f);
        layoutParams7.addRule(3, i);
        this.r.setScaleType(ImageView.ScaleType.FIT_XY);
        this.r.setLayoutParams(layoutParams7);
        PAGTextView pAGTextView = new PAGTextView(context);
        this.y = pAGTextView;
        pAGTextView.setId(520093757);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(a(32.0f), a(14.0f));
        layoutParams8.addRule(8, i3);
        layoutParams8.leftMargin = a(5.0f);
        layoutParams8.bottomMargin = a(5.0f);
        this.y.setBackground(t.f(context, "tt_ad_logo_new"));
        this.y.setGravity(17);
        this.y.setPadding(a(2.0f), 0, 0, 0);
        this.y.setLayoutParams(layoutParams8);
        PAGTextView pAGTextView2 = new PAGTextView(context);
        this.u = pAGTextView2;
        int i4 = com.bytedance.sdk.openadsdk.utils.h.w0;
        pAGTextView2.setId(i4);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams9.addRule(3, i3);
        layoutParams9.leftMargin = a(40.0f);
        layoutParams9.topMargin = a(20.0f);
        layoutParams9.rightMargin = a(40.0f);
        this.u.setGravity(17);
        this.u.setText("TEXT");
        this.u.setTextColor(Color.parseColor("#ffffff"));
        this.u.setTextSize(17.0f);
        this.u.setLayoutParams(layoutParams9);
        this.x = new PAGTextView(context);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-1, a(40.0f));
        layoutParams10.addRule(3, i4);
        layoutParams10.addRule(13);
        layoutParams10.leftMargin = a(40.0f);
        layoutParams10.topMargin = a(35.0f);
        layoutParams10.rightMargin = a(40.0f);
        this.x.setBackground(t.f(context, "tt_reward_video_download_btn_bg"));
        this.x.setGravity(17);
        this.x.setText(t.k(context, "tt_video_download_apk"));
        this.x.setTextColor(Color.parseColor("#ffffff"));
        this.x.setTextSize(15.0f);
        this.x.setLayoutParams(layoutParams10);
        pAGRelativeLayout.addView(pAGRelativeLayout2);
        pAGRelativeLayout2.addView(this.s);
        pAGRelativeLayout2.addView(pAGLinearLayout);
        pAGLinearLayout.addView(this.t);
        pAGLinearLayout.addView(pAGLinearLayout2);
        pAGLinearLayout2.addView(this.w);
        pAGLinearLayout2.addView(this.v);
        pAGRelativeLayout.addView(this.r);
        pAGRelativeLayout.addView(this.y);
        pAGRelativeLayout.addView(this.u);
        pAGRelativeLayout.addView(this.x);
        return pAGRelativeLayout;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private View d(Context context) {
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        pAGRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.r = new RatioImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.r.setScaleType(ImageView.ScaleType.FIT_XY);
        this.r.setLayoutParams(layoutParams);
        pAGRelativeLayout.addView(this.r);
        PAGTextView pAGTextView = new PAGTextView(context);
        this.y = pAGTextView;
        pAGTextView.setId(520093757);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a(32.0f), a(14.0f));
        int i = com.bytedance.sdk.openadsdk.utils.h.r0;
        layoutParams2.addRule(2, i);
        this.y.setBackground(t.f(context, "tt_ad_logo_new"));
        this.y.setPadding(a(2.0f), 0, 0, 0);
        this.y.setLayoutParams(layoutParams2);
        pAGRelativeLayout.addView(this.y);
        PAGRelativeLayout pAGRelativeLayout2 = new PAGRelativeLayout(context);
        this.z = pAGRelativeLayout2;
        pAGRelativeLayout2.setId(i);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, a(90.0f));
        layoutParams3.addRule(12);
        this.z.setBackgroundColor(Color.parseColor("#E4FFFFFF"));
        this.z.setGravity(16);
        this.z.setLayoutParams(layoutParams3);
        pAGRelativeLayout.addView(this.z);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        this.s = tTRoundRectImageView;
        int i2 = com.bytedance.sdk.openadsdk.utils.h.s0;
        tTRoundRectImageView.setId(i2);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(a(69.0f), a(69.0f));
        layoutParams4.addRule(9);
        layoutParams4.addRule(15);
        this.s.setBackgroundColor(0);
        this.s.setLayoutParams(layoutParams4);
        this.z.addView(this.s);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams5.addRule(1, i2);
        int i3 = com.bytedance.sdk.openadsdk.utils.h.t0;
        layoutParams5.addRule(0, i3);
        pAGLinearLayout.setGravity(16);
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setLayoutParams(layoutParams5);
        this.z.addView(pAGLinearLayout);
        this.t = new PAGTextView(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, a(27.0f));
        layoutParams6.leftMargin = a(14.0f);
        this.t.setEllipsize(TextUtils.TruncateAt.END);
        this.t.setGravity(16);
        this.t.setMaxWidth(a(153.0f));
        this.t.setSingleLine(true);
        this.t.setText("pangle");
        this.t.setTextColor(Color.parseColor("#ff000000"));
        this.t.setTextSize(17.0f);
        this.t.setLayoutParams(layoutParams6);
        pAGLinearLayout.addView(this.t);
        this.u = new PAGTextView(context);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.leftMargin = a(14.0f);
        layoutParams7.topMargin = a(5.0f);
        this.u.setEllipsize(TextUtils.TruncateAt.END);
        this.u.setSingleLine(true);
        this.u.setTextColor(Color.parseColor("#4A4A4A"));
        this.u.setTextSize(15.0f);
        this.u.setLayoutParams(layoutParams7);
        pAGLinearLayout.addView(this.u);
        PAGTextView pAGTextView2 = new PAGTextView(context);
        this.x = pAGTextView2;
        pAGTextView2.setId(i3);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, a(36.0f));
        layoutParams8.addRule(11);
        layoutParams8.addRule(15);
        layoutParams8.rightMargin = a(15.0f);
        this.x.setMinWidth(a(90.0f));
        this.x.setBackground(t.f(context, "tt_download_corner_bg"));
        this.x.setGravity(17);
        this.x.setSingleLine(true);
        this.x.setText(t.k(context, "tt_video_download_apk"));
        this.x.setTextColor(Color.parseColor("#ffffff"));
        this.x.setTextSize(17.0f);
        this.x.setLayoutParams(layoutParams8);
        this.z.addView(this.x);
        return pAGRelativeLayout;
    }

    private void a(ImageView imageView) {
        List<n> listD0;
        n nVar;
        q qVar = this.f514b;
        if (qVar == null || (listD0 = qVar.d0()) == null || listD0.size() <= 0 || (nVar = listD0.get(0)) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.h.d.a(listD0.get(0)).a(u.BITMAP).a(com.bytedance.sdk.openadsdk.h.c.a(this.f514b, nVar.d(), imageView));
    }

    protected void a(View view) {
        if (view == null || this.a.V == null || this.f514b == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.c0.b aVar = this.k;
        if (aVar == null) {
            TTBaseVideoActivity tTBaseVideoActivity = this.a.V;
            q qVar = this.f514b;
            String str = this.A;
            aVar = new com.bytedance.sdk.openadsdk.core.c0.a(tTBaseVideoActivity, qVar, str, a0.f(str));
            aVar.a(b(this.f514b));
            HashMap map = new HashMap();
            if (com.bytedance.sdk.openadsdk.core.f0.t.h(this.f514b)) {
                map.put("click_scence", 3);
            } else {
                map.put("click_scence", 1);
            }
            aVar.a(map);
        }
        TTBaseVideoActivity tTBaseVideoActivity2 = this.a.V;
        if (tTBaseVideoActivity2 != null) {
            aVar.a(tTBaseVideoActivity2);
        }
        view.setOnTouchListener(aVar);
        view.setOnClickListener(aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public void a(FrameLayout frameLayout) {
        F();
        a(this.f514b);
        frameLayout.addView(this.q);
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public void a(RewardFullBaseLayout rewardFullBaseLayout) {
        if (com.bytedance.sdk.openadsdk.core.f0.o.f(this.f514b)) {
            com.bytedance.sdk.openadsdk.b.m.q.c.g(rewardFullBaseLayout);
        } else if (com.bytedance.sdk.openadsdk.core.f0.o.b(this.f514b)) {
            com.bytedance.sdk.openadsdk.b.m.q.c.f(rewardFullBaseLayout);
        } else {
            super.a(rewardFullBaseLayout);
        }
    }

    private View a(Context context, int i) {
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        pAGRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        RatioImageView ratioImageView = new RatioImageView(context);
        this.r = ratioImageView;
        int i2 = com.bytedance.sdk.openadsdk.utils.h.u0;
        ratioImageView.setId(i2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        this.r.setScaleType(ImageView.ScaleType.FIT_XY);
        this.r.setLayoutParams(layoutParams);
        PAGRelativeLayout pAGRelativeLayout2 = new PAGRelativeLayout(context);
        int i3 = com.bytedance.sdk.openadsdk.utils.h.v0;
        pAGRelativeLayout2.setId(i3);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, a(70.0f));
        if (i == 0) {
            layoutParams2.leftMargin = a(20.0f);
        } else if (i == 2) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, a(100.0f));
            layoutParams2.leftMargin = a(25.0f);
        }
        layoutParams2.topMargin = a(60.0f);
        layoutParams2.addRule(1, i2);
        pAGRelativeLayout2.setLayoutParams(layoutParams2);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        this.s = tTRoundRectImageView;
        int i4 = com.bytedance.sdk.openadsdk.utils.h.s0;
        tTRoundRectImageView.setId(i4);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(a(69.0f), a(69.0f));
        if (i == 2) {
            layoutParams3 = new RelativeLayout.LayoutParams(a(80.0f), a(80.0f));
        }
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        this.s.setBackgroundColor(0);
        this.s.setLayoutParams(layoutParams3);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        if (i == 2) {
            layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        }
        layoutParams4.addRule(1, i4);
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setGravity(16);
        pAGLinearLayout.setLayoutParams(layoutParams4);
        this.t = new PAGTextView(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, a(27.0f));
        if (i == 2) {
            layoutParams5 = new LinearLayout.LayoutParams(-2, a(33.0f));
        }
        layoutParams5.leftMargin = a(14.0f);
        this.t.setEllipsize(TextUtils.TruncateAt.END);
        this.t.setGravity(16);
        this.t.setMaxWidth(a(176.0f));
        this.t.setSingleLine(true);
        this.t.setText("pangle");
        this.t.setTextColor(Color.parseColor("#ffffffff"));
        this.t.setTextSize(17.0f);
        this.t.setLayoutParams(layoutParams5);
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = a(14.0f);
        layoutParams6.topMargin = a(10.0f);
        pAGLinearLayout2.setGravity(16);
        pAGLinearLayout2.setOrientation(0);
        pAGLinearLayout2.setLayoutParams(layoutParams6);
        this.w = new TTRatingBar2(context, null);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, a(14.0f));
        if (i == 2) {
            layoutParams7 = new LinearLayout.LayoutParams(-2, a(20.0f));
        }
        layoutParams7.gravity = 17;
        this.w.setLayoutParams(layoutParams7);
        if (i == 2) {
            this.v = new PAGTextView(context);
            LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams8.leftMargin = a(10.0f);
            this.v.setEllipsize(TextUtils.TruncateAt.END);
            this.v.setMaxWidth(a(170.0f));
            this.v.setSingleLine(true);
            this.v.setText(t.k(context, "tt_comment_num"));
            this.v.setTextColor(Color.parseColor("#ffffffff"));
            this.v.setTextSize(15.0f);
            this.v.setLayoutParams(layoutParams8);
        }
        PAGTextView pAGTextView = new PAGTextView(context);
        this.u = pAGTextView;
        int i5 = com.bytedance.sdk.openadsdk.utils.h.w0;
        pAGTextView.setId(i5);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams9.addRule(3, i3);
        layoutParams9.topMargin = a(30.0f);
        layoutParams9.addRule(1, i2);
        if (i == 0) {
            layoutParams9.leftMargin = a(20.0f);
            this.u.setGravity(17);
        } else if (i == 2) {
            layoutParams9.leftMargin = a(20.0f);
        }
        this.u.setText("testvs");
        this.u.setTextColor(Color.parseColor("#ffffff"));
        this.u.setTextSize(17.0f);
        this.u.setLayoutParams(layoutParams9);
        this.x = new PAGTextView(context);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-1, a(40.0f));
        layoutParams10.addRule(3, i5);
        layoutParams10.addRule(14);
        layoutParams10.addRule(15);
        if (i == 0) {
            layoutParams10.leftMargin = a(40.0f);
            layoutParams10.topMargin = a(80.0f);
            layoutParams10.rightMargin = a(40.0f);
        } else if (i == 2) {
            layoutParams10.leftMargin = a(25.0f);
            layoutParams10.topMargin = a(60.0f);
            layoutParams10.rightMargin = a(25.0f);
        }
        layoutParams10.addRule(1, i2);
        this.x.setBackground(t.f(context, "tt_reward_video_download_btn_bg"));
        this.x.setGravity(17);
        this.x.setText(t.k(context, "tt_video_download_apk"));
        this.x.setTextColor(Color.parseColor("#ffffff"));
        this.x.setTextSize(15.0f);
        this.x.setLayoutParams(layoutParams10);
        PAGTextView pAGTextView2 = new PAGTextView(context);
        this.y = pAGTextView2;
        pAGTextView2.setId(520093757);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(a(32.0f), a(14.0f));
        layoutParams11.addRule(9);
        layoutParams11.addRule(12);
        layoutParams11.leftMargin = a(16.0f);
        layoutParams11.bottomMargin = a(20.0f);
        this.y.setBackground(t.f(context, "tt_ad_logo_new"));
        this.y.setGravity(17);
        this.y.setPadding(a(2.0f), 0, 0, 0);
        this.y.setLayoutParams(layoutParams11);
        pAGRelativeLayout.addView(this.r);
        pAGRelativeLayout.addView(pAGRelativeLayout2);
        pAGRelativeLayout2.addView(this.s);
        pAGRelativeLayout2.addView(pAGLinearLayout);
        pAGLinearLayout.addView(this.t);
        pAGLinearLayout.addView(pAGLinearLayout2);
        pAGLinearLayout2.addView(this.w);
        if (i == 2) {
            pAGLinearLayout2.addView(this.v);
        }
        pAGRelativeLayout.addView(this.u);
        pAGRelativeLayout.addView(this.x);
        pAGRelativeLayout.addView(this.y);
        return pAGRelativeLayout;
    }

    private int a(float f) {
        return b0.a(this.a.V, f);
    }
}
