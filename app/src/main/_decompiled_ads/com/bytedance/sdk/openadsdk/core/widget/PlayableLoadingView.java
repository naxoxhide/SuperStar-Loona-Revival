package com.bytedance.sdk.openadsdk.core.widget;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGProgressBar;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class PlayableLoadingView extends PAGFrameLayout {
    private ProgressBar a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f691b;
    private TextView c;
    private boolean d;

    public PlayableLoadingView(Context context) {
        super(context);
        setVisibility(8);
    }

    private void o() {
        if (this.d) {
            return;
        }
        this.d = true;
        setBackgroundColor(Color.parseColor("#0D1833"));
        setClickable(true);
        Context context = getContext();
        int iA = b0.a(context, 80.0f);
        int iA2 = b0.a(context, 10.0f);
        LinearLayout linearLayout = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iA, b0.a(context, 53.0f));
        layoutParams2.gravity = 17;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setBackgroundResource(t.e(context, "tt_pangle_logo_white"));
        linearLayout.addView(imageView, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = iA2;
        layoutParams3.gravity = 17;
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(layoutParams3);
        linearLayout.addView(linearLayout2);
        this.a = new PAGProgressBar(context, null, R.attr.progressBarStyleHorizontal);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(iA, b0.a(context, 3.0f));
        layoutParams4.gravity = 17;
        this.a.setProgress(1);
        this.a.setProgressDrawable(t.f(context, "tt_playable_progress_style"));
        this.a.setLayoutParams(layoutParams4);
        linearLayout2.addView(this.a);
        this.f691b = new TextView(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = iA2;
        this.f691b.setGravity(16);
        int color = Color.parseColor("#EEEEEE");
        this.f691b.setTextColor(color);
        this.f691b.setTextSize(12.0f);
        this.f691b.setLayoutParams(layoutParams5);
        linearLayout2.addView(this.f691b);
        int iA3 = b0.a(context, 24.0f);
        int iA4 = b0.a(context, 8.0f);
        TextView textView = new TextView(context);
        this.c = textView;
        textView.setId(h.e1);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = b0.a(context, 72.0f);
        layoutParams6.gravity = 17;
        this.c.setBackgroundResource(t.e(context, "tt_playable_btn_bk"));
        this.c.setClickable(true);
        this.c.setPadding(iA3, iA4, iA3, iA4);
        this.c.setMaxLines(1);
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        this.c.setTextColor(color);
        this.c.setTextSize(14.0f);
        this.c.setText(t.k(context, "tt_try_now"));
        this.c.setLayoutParams(layoutParams6);
        linearLayout.addView(this.c);
        addView(linearLayout);
    }

    public TextView getPlayView() {
        return this.c;
    }

    public void n() {
        setVisibility(8);
    }

    public void p() {
        o();
        setVisibility(0);
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        ProgressBar progressBar = this.a;
        if (progressBar != null) {
            progressBar.setProgress(i);
        }
        TextView textView = this.f691b;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf(i)));
        }
    }
}
