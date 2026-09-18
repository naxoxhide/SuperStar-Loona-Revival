package com.bytedance.sdk.openadsdk.b.m.q;

import android.content.Context;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.RewardFullBaseLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.f0.o;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: compiled from: RewardFullLandingPageType.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends b {
    public c(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        super(aVar);
    }

    public static boolean a(q qVar) {
        return o.f(qVar) || o.b(qVar);
    }

    private static ImageView b(Context context) {
        PAGImageView pAGImageView = new PAGImageView(context);
        pAGImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        pAGImageView.setImageResource(t.e(context, "tt_up_slide"));
        pAGImageView.setId(com.bytedance.sdk.openadsdk.utils.h.v);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(b0.a(context, 18.0f), b0.a(context, 16.0f));
        layoutParams.gravity = 17;
        layoutParams.topMargin = b0.a(context, 45.0f);
        pAGImageView.setLayoutParams(layoutParams);
        return pAGImageView;
    }

    private static LinearLayout c(Context context) {
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setId(com.bytedance.sdk.openadsdk.utils.h.u);
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setVisibility(8);
        pAGLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return pAGLinearLayout;
    }

    private static SSWebView d(Context context) {
        SSWebView sSWebView = new SSWebView(context);
        sSWebView.setId(com.bytedance.sdk.openadsdk.utils.h.t);
        sSWebView.setLayerType(2, null);
        sSWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return sSWebView;
    }

    static void f(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(context);
        pAGFrameLayout.setId(com.bytedance.sdk.openadsdk.utils.h.s);
        frameLayout.addView(pAGFrameLayout, new FrameLayout.LayoutParams(-1, -1));
        pAGFrameLayout.addView(d(context));
        LinearLayout linearLayoutC = c(context);
        linearLayoutC.setBackgroundColor(Color.parseColor("#99161823"));
        pAGFrameLayout.addView(linearLayoutC);
        linearLayoutC.addView(b(context));
        com.bytedance.sdk.openadsdk.component.reward.view.a.a(pAGFrameLayout);
        PAGFrameLayout pAGFrameLayout2 = new PAGFrameLayout(context);
        pAGFrameLayout2.setId(com.bytedance.sdk.openadsdk.utils.h.E);
        frameLayout.addView(pAGFrameLayout2, new FrameLayout.LayoutParams(-1, -1));
        PAGFrameLayout pAGFrameLayout3 = new PAGFrameLayout(context);
        pAGFrameLayout3.setId(com.bytedance.sdk.openadsdk.utils.h.j);
        pAGFrameLayout2.addView(pAGFrameLayout3, new FrameLayout.LayoutParams(-1, -1));
        pAGFrameLayout3.addView(b.a(context));
        PAGFrameLayout pAGFrameLayout4 = new PAGFrameLayout(context);
        pAGFrameLayout4.setId(com.bytedance.sdk.openadsdk.utils.h.q);
        pAGFrameLayout4.setVisibility(8);
        pAGFrameLayout4.setBackgroundColor(-16777216);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        pAGFrameLayout3.addView(pAGFrameLayout4, layoutParams);
        PAGImageView pAGImageView = new PAGImageView(context);
        pAGImageView.setId(com.bytedance.sdk.openadsdk.utils.h.r);
        pAGImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        pAGFrameLayout4.addView(pAGImageView, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.component.reward.view.a.b(pAGFrameLayout2);
        PlayableLoadingView playableLoadingView = new PlayableLoadingView(context);
        playableLoadingView.setId(com.bytedance.sdk.openadsdk.utils.h.F);
        playableLoadingView.setClickable(true);
        playableLoadingView.setFocusable(true);
        frameLayout.addView(playableLoadingView, new FrameLayout.LayoutParams(-1, -1));
    }

    static void g(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setOrientation(1);
        frameLayout.addView(pAGLinearLayout, new FrameLayout.LayoutParams(-1, -1));
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(context);
        pAGFrameLayout.setId(com.bytedance.sdk.openadsdk.utils.h.E);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        pAGLinearLayout.addView(pAGFrameLayout, layoutParams);
        PAGFrameLayout pAGFrameLayout2 = new PAGFrameLayout(context);
        pAGFrameLayout2.setId(com.bytedance.sdk.openadsdk.utils.h.j);
        pAGFrameLayout.addView(pAGFrameLayout2, new FrameLayout.LayoutParams(-1, -1));
        pAGFrameLayout2.addView(b.a(context));
        PAGFrameLayout pAGFrameLayout3 = new PAGFrameLayout(context);
        pAGFrameLayout3.setId(com.bytedance.sdk.openadsdk.utils.h.q);
        pAGFrameLayout3.setVisibility(8);
        pAGFrameLayout3.setBackgroundColor(-16777216);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        pAGFrameLayout2.addView(pAGFrameLayout3, layoutParams2);
        PAGImageView pAGImageView = new PAGImageView(context);
        pAGImageView.setId(com.bytedance.sdk.openadsdk.utils.h.r);
        pAGImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        pAGFrameLayout3.addView(pAGImageView, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.component.reward.view.a.b(pAGFrameLayout);
        PAGFrameLayout pAGFrameLayout4 = new PAGFrameLayout(context);
        pAGFrameLayout4.setId(com.bytedance.sdk.openadsdk.utils.h.s);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 0.0f;
        pAGLinearLayout.addView(pAGFrameLayout4, layoutParams3);
        pAGFrameLayout4.addView(d(context));
        LinearLayout linearLayoutC = c(context);
        linearLayoutC.setBackgroundColor(Color.parseColor("#70161823"));
        pAGFrameLayout4.addView(linearLayoutC);
        linearLayoutC.addView(b(context));
        com.bytedance.sdk.openadsdk.component.reward.view.a.a(pAGFrameLayout4);
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public void B() {
        com.bytedance.sdk.openadsdk.component.reward.view.e eVar;
        o oVar;
        if (o.f(this.a.a) && (eVar = this.a.T) != null && (oVar = eVar.s) != null) {
            if (oVar.i()) {
                this.a.T.c(0);
                this.a.A.set(true);
            } else {
                this.a.B.set(true);
                a(true, false, true);
            }
        }
        if (o.b(this.a.a)) {
            a(true, false, true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public void a(FrameLayout frameLayout) {
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public RFEndCardBackUpLayout g() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public int i() {
        return 16;
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public void o() {
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public boolean q() {
        return o.f(this.a.a) || !o.b(this.a.a);
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public boolean r() {
        return true;
    }

    public static void a(q qVar, FrameLayout frameLayout) {
        if (o.f(qVar)) {
            g(frameLayout);
        } else if (o.b(qVar)) {
            f(frameLayout);
        } else {
            b.b(frameLayout);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public void a(RewardFullBaseLayout rewardFullBaseLayout) {
        a(this.f514b, rewardFullBaseLayout);
    }
}
