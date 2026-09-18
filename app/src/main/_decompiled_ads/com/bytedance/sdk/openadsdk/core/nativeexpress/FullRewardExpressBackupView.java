package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: loaded from: classes2.dex */
public class FullRewardExpressBackupView extends BackupView {
    private FrameLayout m;
    private NativeExpressView n;
    private FrameLayout o;

    public FullRewardExpressBackupView(Context context) {
        super(context);
        this.a = context;
    }

    private void m() {
        this.f = b0.a(this.a, this.n.getExpectExpressWidth());
        this.g = b0.a(this.a, this.n.getExpectExpressWidth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f, this.g);
        }
        layoutParams.width = this.f;
        layoutParams.height = this.g;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        this.f646b.p0();
        n();
    }

    private void n() {
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(this.a);
        this.m = pAGFrameLayout;
        addView(pAGFrameLayout, new FrameLayout.LayoutParams(-1, -1));
        PAGFrameLayout pAGFrameLayout2 = new PAGFrameLayout(this.a);
        this.o = pAGFrameLayout2;
        this.m.addView(pAGFrameLayout2, new FrameLayout.LayoutParams(-1, -1));
        this.o.removeAllViews();
    }

    public void a(q qVar, NativeExpressView nativeExpressView) {
        com.bytedance.sdk.component.utils.m.a("FullRewardExpressBackupView", "show backup view");
        if (qVar == null) {
            return;
        }
        setBackgroundColor(-1);
        this.f646b = qVar;
        this.n = nativeExpressView;
        if (qVar.R() == 7) {
            this.e = "rewarded_video";
        } else {
            this.e = "fullscreen_interstitial_ad";
        }
        m();
        this.n.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    public View getBackupContainerBackgroundView() {
        return this.m;
    }

    public FrameLayout getVideoContainer() {
        return this.o;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(View view, int i, com.bytedance.sdk.openadsdk.core.f0.m mVar) {
        NativeExpressView nativeExpressView = this.n;
        if (nativeExpressView != null) {
            nativeExpressView.a(view, i, mVar);
        }
    }
}
