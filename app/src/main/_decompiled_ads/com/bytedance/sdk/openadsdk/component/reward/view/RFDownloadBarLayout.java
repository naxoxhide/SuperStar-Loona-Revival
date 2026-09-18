package com.bytedance.sdk.openadsdk.component.reward.view;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.b.a.a.h.k;
import b.b.a.a.h.o;
import b.b.a.a.h.u;
import b.b.a.a.k.g;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar2;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;
import com.facebook.internal.security.CertificateUtil;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class RFDownloadBarLayout extends PAGRelativeLayout {
    private TTRatingBar2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f541b;
    private TextView c;
    private TTRoundRectImageView d;
    private TextView e;
    private boolean f;
    private com.bytedance.sdk.openadsdk.b.m.p.a g;
    private TextView h;

    class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int width = ((ViewGroup) RFDownloadBarLayout.this.c.getParent()).getWidth();
            if (width > 0) {
                RFDownloadBarLayout.this.c.setMaxWidth((int) (width * 0.45f));
            }
        }
    }

    class c extends g {
        final /* synthetic */ int c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, int i, String str2, String str3) {
            super(str);
            this.c = i;
            this.d = str2;
            this.e = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", this.c);
                jSONObject.put("description", this.c + CertificateUtil.DELIMITER + this.d);
                jSONObject.put("url", this.e);
            } catch (Throwable unused) {
            }
            com.bytedance.sdk.openadsdk.d.c.b(RFDownloadBarLayout.this.g.a, RFDownloadBarLayout.this.g.g, "load_vast_icon_fail", jSONObject);
        }
    }

    class d extends com.bytedance.sdk.openadsdk.core.c0.g {
        d(RFDownloadBarLayout rFDownloadBarLayout, String str, com.bytedance.sdk.openadsdk.core.i0.a aVar, com.bytedance.sdk.openadsdk.core.c0.c cVar) {
            super(str, aVar, cVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.g
        public void b() {
        }
    }

    class e extends com.bytedance.sdk.openadsdk.core.c0.g {
        e(RFDownloadBarLayout rFDownloadBarLayout, String str, com.bytedance.sdk.openadsdk.core.i0.a aVar, com.bytedance.sdk.openadsdk.core.c0.c cVar) {
            super(str, aVar, cVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.g
        public void b() {
        }
    }

    class f implements View.OnClickListener {
        final /* synthetic */ View.OnClickListener a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f543b;

        f(View.OnClickListener onClickListener, q qVar) {
            this.a = onClickListener;
            this.f543b = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            if (view == null || !"VAST_ICON".equals(view.getTag(570425345))) {
                if (this.f543b.M0() != null) {
                    this.f543b.M0().m().a(RFDownloadBarLayout.this.g.G.e());
                }
            } else {
                if (this.f543b.M0() == null || this.f543b.M0().h() == null) {
                    return;
                }
                this.f543b.M0().h().a(RFDownloadBarLayout.this.g.G.e());
            }
        }
    }

    public RFDownloadBarLayout(Context context) {
        super(context);
        setVisibility(8);
    }

    private void b() {
    }

    private static TextView d(Context context) {
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setGravity(17);
        pAGTextView.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView.setLines(1);
        pAGTextView.setTextColor(-1);
        pAGTextView.setTextSize(2, 14.0f);
        pAGTextView.setBackgroundResource(t.e(context, "tt_reward_video_download_btn_bg"));
        pAGTextView.setId(520093705);
        pAGTextView.setPadding(b0.a(context, 10.0f), 0, b0.a(context, 10.0f), 0);
        pAGTextView.setText(t.j(context, "tt_video_mobile_go_detail"));
        return pAGTextView;
    }

    private void e() {
        Context context = getContext();
        TTRoundRectImageView tTRoundRectImageViewA = a(context);
        this.d = tTRoundRectImageViewA;
        addView(tTRoundRectImageViewA);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        int i = h.f830b;
        layoutParams.addRule(1, i);
        layoutParams.addRule(17, i);
        addView(pAGLinearLayout, layoutParams);
        TextView textViewB = b(context);
        this.e = textViewB;
        textViewB.setMaxWidth(b0.a(context, 176.0f));
        pAGLinearLayout.addView(this.e);
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(context);
        pAGLinearLayout2.setGravity(16);
        pAGLinearLayout2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = b0.a(context, 14.0f);
        layoutParams2.topMargin = b0.a(context, 10.0f);
        pAGLinearLayout.addView(pAGLinearLayout2, layoutParams2);
        TTRatingBar2 tTRatingBar2A = a(context, 17);
        this.a = tTRatingBar2A;
        pAGLinearLayout2.addView(tTRatingBar2A);
        TextView textViewC = c(context);
        this.f541b = textViewC;
        pAGLinearLayout2.addView(textViewC);
    }

    private void f() {
        Context context = getContext();
        TTRoundRectImageView tTRoundRectImageViewA = a(context);
        this.d = tTRoundRectImageViewA;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tTRoundRectImageViewA.getLayoutParams();
        int iA = b0.a(context, 52.0f);
        layoutParams.height = iA;
        layoutParams.width = iA;
        addView(this.d);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setGravity(17);
        int i = h.f;
        pAGLinearLayout.setId(i);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(b0.a(context, 100.0f), b0.a(context, 45.0f));
        layoutParams2.addRule(11);
        layoutParams2.addRule(21);
        layoutParams2.addRule(15);
        layoutParams2.rightMargin = b0.a(context, 15.0f);
        addView(pAGLinearLayout, layoutParams2);
        this.c = d(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, b0.a(context, 41.0f));
        layoutParams3.bottomMargin = b0.a(context, 3.0f);
        pAGLinearLayout.addView(this.c, layoutParams3);
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(context);
        pAGLinearLayout2.setGravity(16);
        pAGLinearLayout2.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams4.addRule(0, i);
        layoutParams4.addRule(1, h.f830b);
        addView(pAGLinearLayout2, layoutParams4);
        TextView textViewB = b(context);
        this.e = textViewB;
        textViewB.setTextColor(Color.parseColor("#222222"));
        this.e.setTextSize(2, 16.0f);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.e.getLayoutParams();
        layoutParams5.width = -1;
        layoutParams5.height = b0.a(context, 22.0f);
        layoutParams5.leftMargin = b0.a(context, 10.0f);
        pAGLinearLayout2.addView(this.e);
        PAGTextView pAGTextView = new PAGTextView(context);
        this.h = pAGTextView;
        pAGTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.h.setSingleLine(true);
        this.h.setTextColor(Color.parseColor("#4A4A4A"));
        this.h.setTextSize(2, 14.0f);
        this.h.setId(h.g);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, b0.a(context, 16.0f));
        layoutParams6.leftMargin = b0.a(context, 10.0f);
        layoutParams6.topMargin = b0.a(context, 5.0f);
        pAGLinearLayout2.addView(this.h, layoutParams6);
    }

    private String getCnOrEnBtnText() {
        return this.g.a.e0() != 4 ? "View" : "Install";
    }

    private void h() {
        TextView textView;
        this.f = true;
        Context context = getContext();
        int iP0 = this.g.a.p0();
        if (iP0 == 1) {
            e();
        } else if (iP0 == 3) {
            d();
        } else if (iP0 != 5) {
            c();
        } else {
            f();
        }
        b();
        if (this.c == null) {
            this.c = (TextView) this.g.V.findViewById(520093705);
        }
        q qVar = this.g.a;
        TextView textView2 = this.c;
        if (textView2 != null) {
            textView2.addOnLayoutChangeListener(new a());
            if (!qVar.k1()) {
                this.c.setText(qVar.p0() == 3 ? getButtonTextForNewStyleBar() : qVar.r());
            } else if (qVar.M0() != null && TextUtils.isEmpty(qVar.M0().a())) {
                b0.a((View) this.c, 8);
            }
        }
        if (this.d != null && qVar.b0() != null && !TextUtils.isEmpty(qVar.b0().d())) {
            String strD = qVar.b0().d();
            if (qVar.k1()) {
                com.bytedance.sdk.openadsdk.h.d.a(qVar.b0()).a(u.BITMAP).a(new com.bytedance.sdk.openadsdk.h.b(qVar, qVar.b0().d(), new b(qVar, strD)));
                if (qVar.M0() != null && qVar.M0().h() != null) {
                    qVar.M0().h().b(0L);
                }
            } else {
                com.bytedance.sdk.openadsdk.n.c.b().a(qVar.b0(), this.d, qVar);
            }
        }
        if (this.e != null) {
            if (this.g.j != 1 || qVar.h() == null || TextUtils.isEmpty(qVar.h().a())) {
                this.e.setText(qVar.K0());
            } else {
                this.e.setText(qVar.h().a());
            }
        }
        TextView textView3 = this.f541b;
        if (textView3 != null) {
            b0.a(textView3, qVar, this.g.W, "tt_comment_num");
        }
        if (this.g.j == 1) {
            TextView textView4 = this.e;
            if (textView4 != null) {
                textView4.setMaxWidth(b0.a(context, 153.0f));
            }
        } else {
            TextView textView5 = this.e;
            if (textView5 != null) {
                textView5.setMaxWidth(b0.a(context, 404.0f));
            }
        }
        TTRatingBar2 tTRatingBar2 = this.a;
        if (tTRatingBar2 != null) {
            b0.a((TextView) null, tTRatingBar2, qVar);
        }
        if (qVar.k1() && (textView = this.h) != null) {
            textView.setText(qVar.B());
        }
        if (this.g.j == 2 && qVar.p0() == 1) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.height = b0.a(this.g.W, 55.0f);
            layoutParams.topMargin = b0.a(this.g.W, 20.0f);
            this.c.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) getLayoutParams();
            layoutParams2.bottomMargin = b0.a(this.g.W, 12.0f);
            setLayoutParams(layoutParams2);
        }
        g();
    }

    public void g() {
        com.bytedance.sdk.openadsdk.core.c0.e eVarC = this.g.L.c();
        View.OnClickListener onClickListenerB = this.g.L.b();
        q qVar = this.g.a;
        if (qVar.s() == null) {
            return;
        }
        if (qVar.p0() != 5 && this.c != null) {
            if (qVar.s().e) {
                this.c.setOnClickListener(eVarC);
                this.c.setOnTouchListener(eVarC);
            } else {
                this.c.setOnClickListener(onClickListenerB);
            }
        }
        if (qVar.p0() == 1) {
            if (!qVar.s().a) {
                b0.a(this, onClickListenerB, "TTBaseVideoActivity#mRlDownloadBar");
                this.e.setOnClickListener(onClickListenerB);
                this.f541b.setOnClickListener(onClickListenerB);
                this.a.setOnClickListener(onClickListenerB);
                this.d.setOnClickListener(onClickListenerB);
                return;
            }
            b0.a((View) this, (View.OnClickListener) eVarC, "TTBaseVideoActivity#mRlDownloadBar");
            b0.a((View) this, (View.OnTouchListener) eVarC, "TTBaseVideoActivity#mRlDownloadBar");
            this.e.setOnClickListener(eVarC);
            this.e.setOnTouchListener(eVarC);
            this.f541b.setOnClickListener(eVarC);
            this.f541b.setOnTouchListener(eVarC);
            this.a.setOnClickListener(eVarC);
            this.a.setOnTouchListener(eVarC);
            this.d.setOnClickListener(eVarC);
            this.d.setOnTouchListener(eVarC);
            return;
        }
        if (qVar.p0() != 5) {
            if (!qVar.s().c) {
                b0.a(this, onClickListenerB, "TTBaseVideoActivity#mRlDownloadBar");
                return;
            } else {
                b0.a((View) this, (View.OnClickListener) eVarC, "TTBaseVideoActivity#mRlDownloadBar");
                b0.a((View) this, (View.OnTouchListener) eVarC, "TTBaseVideoActivity#mRlDownloadBar");
                return;
            }
        }
        if (!qVar.s().e) {
            f fVar = new f(onClickListenerB, qVar);
            TextView textView = this.c;
            if (textView != null) {
                textView.setOnClickListener(fVar);
            }
            TextView textView2 = this.e;
            if (textView2 != null && !TextUtils.isEmpty(textView2.getText())) {
                this.e.setOnClickListener(fVar);
            }
            TextView textView3 = this.h;
            if (textView3 != null && !TextUtils.isEmpty(textView3.getText())) {
                this.h.setOnClickListener(fVar);
            }
            TTRoundRectImageView tTRoundRectImageView = this.d;
            if (tTRoundRectImageView != null) {
                tTRoundRectImageView.setTag(570425345, "VAST_ICON");
                this.d.setOnClickListener(onClickListenerB);
                return;
            }
            return;
        }
        d dVar = new d(this, "VAST_ACTION_BUTTON", qVar.M0(), eVarC);
        e eVar = new e(this, "VAST_ICON", qVar.M0(), eVarC);
        TextView textView4 = this.c;
        if (textView4 != null) {
            textView4.setOnClickListener(dVar);
            this.c.setOnTouchListener(dVar);
        }
        TTRoundRectImageView tTRoundRectImageView2 = this.d;
        if (tTRoundRectImageView2 != null) {
            tTRoundRectImageView2.setOnClickListener(eVar);
            this.d.setOnTouchListener(eVar);
        }
        TextView textView5 = this.e;
        if (textView5 != null && !TextUtils.isEmpty(textView5.getText())) {
            this.e.setOnClickListener(dVar);
            this.e.setOnTouchListener(dVar);
        }
        TextView textView6 = this.h;
        if (textView6 == null || TextUtils.isEmpty(textView6.getText())) {
            return;
        }
        this.h.setOnClickListener(dVar);
        this.h.setOnTouchListener(dVar);
    }

    protected String getButtonTextForNewStyleBar() {
        boolean zEquals;
        String strR;
        String strB = a0.b(this.g.W);
        if (strB == null) {
            strB = "";
        }
        try {
            zEquals = strB.equals(Locale.ENGLISH.getLanguage());
        } catch (Throwable unused) {
            zEquals = false;
        }
        if (TextUtils.isEmpty(this.g.a.r())) {
            strR = this.g.a.e0() != 4 ? "View" : "Install";
        } else {
            strR = this.g.a.r();
            if (strR == null || !a0.i(strR) || strR.length() <= 2) {
                if (strR != null && !a0.i(strR) && strR.length() > 7 && zEquals) {
                    strR = getCnOrEnBtnText();
                }
            } else if (zEquals) {
                strR = getCnOrEnBtnText();
            }
        }
        if (zEquals && !a0.i(strR)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.bottomMargin = b0.a(this.g.W, 4.0f);
            this.c.setLayoutParams(layoutParams);
        }
        return strR;
    }

    public void i() {
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
        Keyframe keyframeOfFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
        Keyframe keyframeOfFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe("scaleX", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6), PropertyValuesHolder.ofKeyframe("scaleY", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6));
        objectAnimatorOfPropertyValuesHolder.setDuration(1000L);
        objectAnimatorOfPropertyValuesHolder.start();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i != 0 || this.f) {
            return;
        }
        h();
    }

    private static TextView b(Context context) {
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView.setGravity(16);
        pAGTextView.setSingleLine(true);
        pAGTextView.setTextColor(-1);
        pAGTextView.setTextSize(2, 17.0f);
        pAGTextView.setId(h.c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, b0.a(context, 27.0f));
        layoutParams.leftMargin = b0.a(context, 14.0f);
        pAGTextView.setLayoutParams(layoutParams);
        return pAGTextView;
    }

    private static TextView c(Context context) {
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView.setSingleLine(true);
        pAGTextView.setTextColor(-1);
        pAGTextView.setTextSize(2, 13.0f);
        pAGTextView.setId(h.d);
        pAGTextView.setMaxWidth(b0.a(context, 72.0f));
        pAGTextView.setText(t.j(context, "tt_comment_num"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = b0.a(context, 10.0f);
        pAGTextView.setLayoutParams(layoutParams);
        return pAGTextView;
    }

    private static TTRoundRectImageView a(Context context) {
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        tTRoundRectImageView.setBackgroundColor(0);
        tTRoundRectImageView.setId(h.f830b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b0.a(context, 69.0f), b0.a(context, 69.0f));
        layoutParams.addRule(20);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        tTRoundRectImageView.setLayoutParams(layoutParams);
        return tTRoundRectImageView;
    }

    class b implements o<Bitmap> {
        final /* synthetic */ q a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f542b;

        b(q qVar, String str) {
            this.a = qVar;
            this.f542b = str;
        }

        @Override // b.b.a.a.h.o
        public void a(k<Bitmap> kVar) {
            if (kVar == null || kVar.c() == null) {
                return;
            }
            if (RFDownloadBarLayout.this.d != null) {
                RFDownloadBarLayout.this.d.setImageBitmap(kVar.c());
            }
            com.bytedance.sdk.openadsdk.d.c.b(this.a, RFDownloadBarLayout.this.g.g, "load_vast_icon_success", (JSONObject) null);
        }

        @Override // b.b.a.a.h.o
        public void a(int i, String str, Throwable th) {
            RFDownloadBarLayout.this.a(i, str, this.f542b);
        }
    }

    private static TTRatingBar2 a(Context context, int i) {
        TTRatingBar2 tTRatingBar2 = new TTRatingBar2(context);
        tTRatingBar2.setId(h.e);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, b0.a(context, 14.0f));
        layoutParams.gravity = i;
        tTRatingBar2.setLayoutParams(layoutParams);
        return tTRatingBar2;
    }

    private void d() {
        Context context = getContext();
        TTRoundRectImageView tTRoundRectImageViewA = a(context);
        this.d = tTRoundRectImageViewA;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tTRoundRectImageViewA.getLayoutParams();
        int iA = b0.a(context, 52.0f);
        layoutParams.height = iA;
        layoutParams.width = iA;
        addView(this.d);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        int i = h.f;
        pAGLinearLayout.setId(i);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(b0.a(context, 76.0f), b0.a(context, 45.0f));
        layoutParams2.addRule(11);
        layoutParams2.addRule(21);
        layoutParams2.addRule(15);
        layoutParams2.rightMargin = b0.a(context, 15.0f);
        int[] iArr = {Color.parseColor("#0070FF")};
        com.bytedance.sdk.openadsdk.core.widget.c.a(pAGLinearLayout, new com.bytedance.sdk.openadsdk.core.widget.c.a().a(iArr[0]).e(Color.parseColor("#80000000")).a(iArr).d(b0.a(context, 17.0f)).b(0).c(b0.a(context, 3.0f)));
        addView(pAGLinearLayout, layoutParams2);
        this.c = d(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams3.bottomMargin = b0.a(context, 3.0f);
        pAGLinearLayout.addView(this.c, layoutParams3);
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(context);
        pAGLinearLayout2.setGravity(16);
        pAGLinearLayout2.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams4.addRule(16, i);
        layoutParams4.addRule(0, i);
        int i2 = h.f830b;
        layoutParams4.addRule(1, i2);
        layoutParams4.addRule(17, i2);
        addView(pAGLinearLayout2, layoutParams4);
        TextView textViewB = b(context);
        this.e = textViewB;
        textViewB.setTextColor(Color.parseColor("#222222"));
        this.e.setTextSize(2, 16.0f);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.e.getLayoutParams();
        layoutParams5.width = -1;
        layoutParams5.height = b0.a(context, 22.0f);
        layoutParams5.leftMargin = b0.a(context, 10.0f);
        pAGLinearLayout2.addView(this.e);
        PAGLinearLayout pAGLinearLayout3 = new PAGLinearLayout(context);
        pAGLinearLayout3.setGravity(16);
        pAGLinearLayout3.setOrientation(0);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = b0.a(context, 14.0f);
        layoutParams6.topMargin = b0.a(context, 5.0f);
        pAGLinearLayout2.addView(pAGLinearLayout3, layoutParams6);
        TTRatingBar2 tTRatingBar2A = a(context, -1);
        this.a = tTRatingBar2A;
        ((LinearLayout.LayoutParams) tTRatingBar2A.getLayoutParams()).height = b0.a(context, 12.0f);
        pAGLinearLayout3.addView(this.a);
        TextView textViewC = c(context);
        this.f541b = textViewC;
        textViewC.setTextColor(Color.parseColor("#4A4A4A"));
        this.f541b.setTextSize(2, 14.0f);
        this.f541b.setMaxWidth(b0.a(context, 83.0f));
        ((LinearLayout.LayoutParams) this.f541b.getLayoutParams()).height = b0.a(context, 20.0f);
        pAGLinearLayout3.addView(this.f541b);
    }

    private void c() {
        Context context = getContext();
        TTRoundRectImageView tTRoundRectImageViewA = a(context);
        this.d = tTRoundRectImageViewA;
        addView(tTRoundRectImageViewA);
        TextView textViewD = d(context);
        this.c = textViewD;
        textViewD.setBackgroundResource(t.e(context, "tt_download_corner_bg"));
        this.c.setMaxWidth(b0.a(context, 105.0f));
        this.c.setText(t.j(context, "tt_video_download_apk"));
        this.c.setTextSize(2, 17.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, b0.a(context, 36.0f));
        layoutParams.addRule(21);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.rightMargin = b0.a(context, 15.0f);
        addView(this.c, layoutParams);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setGravity(16);
        pAGLinearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(0, this.c.getId());
        layoutParams2.addRule(16, this.c.getId());
        layoutParams2.addRule(1, this.d.getId());
        layoutParams2.addRule(17, this.d.getId());
        addView(pAGLinearLayout, layoutParams2);
        TextView textViewB = b(context);
        this.e = textViewB;
        textViewB.setTextColor(-16777216);
        pAGLinearLayout.addView(this.e);
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = b0.a(context, 14.0f);
        layoutParams3.topMargin = b0.a(context, 5.0f);
        pAGLinearLayout.addView(pAGLinearLayout2, layoutParams3);
        pAGLinearLayout2.setGravity(16);
        pAGLinearLayout2.setOrientation(0);
        TTRatingBar2 tTRatingBar2A = a(context, 17);
        this.a = tTRatingBar2A;
        pAGLinearLayout2.addView(tTRatingBar2A);
        TextView textViewC = c(context);
        this.f541b = textViewC;
        textViewC.setTextColor(Color.parseColor("#4A4A4A"));
        this.f541b.setTextSize(2, 11.0f);
        pAGLinearLayout2.addView(this.f541b);
    }

    public void a(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        this.g = aVar;
        if (aVar.a.p0() == 1) {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, String str2) {
        com.bytedance.sdk.openadsdk.d.c.a(new c("load_vast_icon_fail", i, str, str2));
    }
}
