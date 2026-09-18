package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: loaded from: classes2.dex */
public class TTAdDislikeToast extends PAGFrameLayout {
    private static String c;
    private static String d;
    private static String e;
    private final Handler a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f527b;

    class a implements Runnable {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TTAdDislikeToast.this.f527b != null) {
                TTAdDislikeToast.this.f527b.setText(String.valueOf(this.a));
            }
            TTAdDislikeToast.this.setVisibility(0);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TTAdDislikeToast.this.setVisibility(8);
        }
    }

    public TTAdDislikeToast(Context context) {
        this(context, null);
    }

    public static String getDislikeSendTip() {
        if (e == null) {
            Context contextA = o.a();
            e = t.k(contextA, "tt_feedback_thank_text") + "\n" + t.k(contextA, "tt_feedback_experience_text");
        }
        return e;
    }

    public static String getDislikeTip() {
        if (c == null) {
            c = t.k(o.a(), "tt_feedback_submit_text");
        }
        return c;
    }

    public static String getSkipText() {
        if (d == null) {
            d = t.k(o.a(), "tt_txt_skip");
        }
        return d;
    }

    public static void p() {
        Context contextA = o.a();
        d = t.k(contextA, "tt_txt_skip");
        c = t.k(contextA, "tt_feedback_submit_text");
        e = t.k(contextA, "tt_feedback_thank_text") + "\n" + t.k(contextA, "tt_feedback_experience_text");
    }

    public void n() {
        setVisibility(8);
        this.a.removeCallbacksAndMessages(null);
    }

    public void o() {
        setVisibility(8);
        this.a.removeCallbacksAndMessages(null);
    }

    public TTAdDislikeToast(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        TextView textView = new TextView(context);
        this.f527b = textView;
        textView.setClickable(false);
        this.f527b.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int iA = b0.a(o.a(), 20.0f);
        int iA2 = b0.a(o.a(), 12.0f);
        this.f527b.setPadding(iA, iA2, iA, iA2);
        this.f527b.setLayoutParams(layoutParams);
        this.f527b.setTextColor(-1);
        this.f527b.setTextSize(16.0f);
        this.f527b.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(b0.a(o.a(), 6.0f));
        this.f527b.setBackgroundDrawable(gradientDrawable);
        addView(this.f527b);
    }

    public TTAdDislikeToast(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Handler(Looper.getMainLooper());
        setVisibility(8);
        setClickable(false);
        setFocusable(false);
        a(context);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a.removeCallbacksAndMessages(null);
        this.a.post(new a(str));
        this.a.postDelayed(new b(), 2000L);
    }
}
