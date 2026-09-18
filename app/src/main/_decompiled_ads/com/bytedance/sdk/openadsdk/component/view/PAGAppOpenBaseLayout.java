package com.bytedance.sdk.openadsdk.component.view;

import android.content.Context;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.widget.DSPAdChoice;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;

/* JADX INFO: loaded from: classes2.dex */
public class PAGAppOpenBaseLayout extends PAGRelativeLayout {
    PAGImageView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    PAGFrameLayout f550b;
    PAGImageView c;
    PAGTextView d;
    ButtonFlash e;
    PAGLinearLayout f;
    TTRoundRectImageView g;
    PAGTextView h;
    final PAGAppOpenTopBarView i;
    DSPAdChoice j;

    public PAGAppOpenBaseLayout(Context context) {
        super(context);
        this.i = new PAGAppOpenTopBarView(context);
    }

    public PAGTextView getAdLogo() {
        return this.d;
    }

    public TTRoundRectImageView getAppIcon() {
        return this.g;
    }

    public PAGTextView getAppName() {
        return this.h;
    }

    public PAGImageView getBackImage() {
        return this.a;
    }

    public ButtonFlash getClickButton() {
        return this.e;
    }

    public DSPAdChoice getDspAdChoice() {
        return this.j;
    }

    public PAGImageView getImageView() {
        return this.c;
    }

    public TextView getTopDisLike() {
        PAGAppOpenTopBarView pAGAppOpenTopBarView = this.i;
        if (pAGAppOpenTopBarView != null) {
            return pAGAppOpenTopBarView.getTopDislike();
        }
        return null;
    }

    public TextView getTopSkip() {
        PAGAppOpenTopBarView pAGAppOpenTopBarView = this.i;
        if (pAGAppOpenTopBarView != null) {
            return pAGAppOpenTopBarView.getTopSkip();
        }
        return null;
    }

    public PAGLinearLayout getUserInfo() {
        return this.f;
    }

    public PAGFrameLayout getVideoContainer() {
        return this.f550b;
    }
}
