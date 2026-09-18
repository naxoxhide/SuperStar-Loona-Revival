package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar2;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;

/* JADX INFO: loaded from: classes2.dex */
public class RFEndCardBackUpLayout extends PAGFrameLayout {
    private boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.b.m.p.a f544b;
    private TTRoundRectImageView c;
    private TextView d;
    private TTRatingBar2 e;
    private TextView f;
    private TextView g;
    private TextView h;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                TTWebsiteActivity.a(RFEndCardBackUpLayout.this.f544b.V, RFEndCardBackUpLayout.this.f544b.a, RFEndCardBackUpLayout.this.f544b.g);
            } catch (Throwable unused) {
            }
        }
    }

    public RFEndCardBackUpLayout(Context context) {
        super(context);
        setVisibility(8);
        setId(h.p0);
    }

    private void n() {
        if (this.a) {
            return;
        }
        this.a = true;
        q qVar = this.f544b.a;
        if (qVar.k1()) {
            p();
            return;
        }
        o();
        Context context = getContext();
        com.bytedance.sdk.openadsdk.core.c0.e eVarC = this.f544b.L.c();
        this.g.setOnClickListener(eVarC);
        this.g.setOnTouchListener(eVarC);
        String strR = qVar.r();
        if (!TextUtils.isEmpty(strR)) {
            this.g.setText(strR);
        }
        TTRoundRectImageView tTRoundRectImageView = this.c;
        if (tTRoundRectImageView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tTRoundRectImageView.getLayoutParams();
            layoutParams.setMargins(0, b0.a(context, 50.0f), 0, 0);
            this.c.setLayoutParams(layoutParams);
        }
        if (this.c != null && qVar.b0() != null && !TextUtils.isEmpty(qVar.b0().d())) {
            com.bytedance.sdk.openadsdk.n.c.b().a(qVar.b0(), this.c, qVar);
        }
        TTRatingBar2 tTRatingBar2 = this.e;
        if (tTRatingBar2 != null) {
            b0.a((TextView) null, tTRatingBar2, qVar);
        }
        if (this.d != null) {
            if (qVar.h() == null || TextUtils.isEmpty(qVar.h().a())) {
                this.d.setText(qVar.K0());
            } else {
                this.d.setText(qVar.h().a());
            }
        }
        TextView textView = this.f;
        if (textView != null) {
            b0.a(textView, qVar, getContext(), "tt_comment_num_backup");
        }
        this.h.setOnClickListener(new a());
    }

    private void o() {
        Context context = getContext();
        setBackgroundColor(-1);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setGravity(1);
        pAGLinearLayout.setOrientation(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        addView(pAGLinearLayout, layoutParams);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        this.c = tTRoundRectImageView;
        tTRoundRectImageView.setBackgroundColor(0);
        pAGLinearLayout.addView(this.c, new LinearLayout.LayoutParams(b0.a(context, 100.0f), b0.a(context, 100.0f)));
        PAGTextView pAGTextView = new PAGTextView(context);
        this.d = pAGTextView;
        pAGTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.d.setSingleLine(true);
        this.d.setMaxWidth(b0.a(context, 180.0f));
        this.d.setTextColor(Color.parseColor("#ff333333"));
        this.d.setTextSize(2, 20.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, b0.a(context, 28.0f));
        layoutParams2.topMargin = b0.a(context, 16.0f);
        pAGLinearLayout.addView(this.d, layoutParams2);
        this.e = new TTRatingBar2(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, b0.a(context, 16.0f));
        layoutParams3.topMargin = b0.a(context, 12.0f);
        pAGLinearLayout.addView(this.e, layoutParams3);
        PAGTextView pAGTextView2 = new PAGTextView(context);
        this.f = pAGTextView2;
        pAGTextView2.setEllipsize(TextUtils.TruncateAt.END);
        this.f.setSingleLine(true);
        this.f.setTextColor(Color.parseColor("#ff93959a"));
        this.f.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, b0.a(context, 20.0f));
        layoutParams4.topMargin = b0.a(context, 8.0f);
        pAGLinearLayout.addView(this.f, layoutParams4);
        PAGTextView pAGTextView3 = new PAGTextView(context);
        this.g = pAGTextView3;
        pAGTextView3.setId(520093707);
        this.g.setGravity(17);
        this.g.setText(t.j(context, "tt_video_download_apk"));
        this.g.setTextColor(-1);
        this.g.setTextSize(2, 16.0f);
        this.g.setBackgroundResource(t.e(context, "tt_reward_full_video_backup_btn_bg"));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, b0.a(context, 46.0f));
        int iA = b0.a(context, 20.0f);
        layoutParams5.bottomMargin = iA;
        layoutParams5.rightMargin = iA;
        layoutParams5.topMargin = iA;
        layoutParams5.leftMargin = iA;
        pAGLinearLayout.addView(this.g, layoutParams5);
        PAGTextView pAGTextView4 = new PAGTextView(context);
        this.h = pAGTextView4;
        pAGTextView4.setBackgroundResource(t.e(context, "tt_ad_logo_new"));
        this.h.setGravity(17);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(b0.a(context, 32.0f), b0.a(context, 14.0f));
        layoutParams6.gravity = 8388691;
        layoutParams6.bottomMargin = b0.a(context, 16.0f);
        layoutParams6.leftMargin = b0.a(context, 20.0f);
        pAGLinearLayout.addView(this.h, layoutParams6);
    }

    private void p() {
        Context context = getContext();
        setBackgroundColor(-16777216);
        PAGImageView pAGImageView = new PAGImageView(context);
        pAGImageView.setId(h.h);
        pAGImageView.setVisibility(8);
        addView(pAGImageView, new FrameLayout.LayoutParams(-1, -1));
        SSWebView sSWebView = new SSWebView(context, true);
        sSWebView.setVisibility(8);
        sSWebView.setId(h.i);
        addView(sSWebView, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            n();
        }
    }

    public void a(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        this.f544b = aVar;
        if (aVar.a.k1()) {
            n();
        }
    }
}
