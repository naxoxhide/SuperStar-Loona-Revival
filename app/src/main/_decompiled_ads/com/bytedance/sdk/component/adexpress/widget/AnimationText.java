package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import b.b.a.a.d.d.i.j;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.y;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AnimationText extends TextSwitcher implements ViewSwitcher.ViewFactory, y.a {
    private List<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f298b;
    private Context c;
    private TextView d;
    private int e;
    private int f;
    private float g;
    private int h;
    private int i;
    private int j;
    private int k;
    private Handler l;
    Animation.AnimationListener m;

    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (AnimationText.this.d != null) {
                AnimationText.this.d.setText("");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public AnimationText(Context context, int i, float f, int i2, int i3) {
        super(context);
        this.a = new ArrayList();
        this.f298b = 0;
        this.l = new y(Looper.getMainLooper(), this);
        this.m = new a();
        this.f = i;
        this.g = f;
        this.h = i2;
        this.k = i3;
        a();
    }

    public void b() {
        int i = this.j;
        if (i == 1) {
            setInAnimation(getContext(), t.a(this.c, "tt_text_animation_y_in"));
            setOutAnimation(getContext(), t.a(this.c, "tt_text_animation_y_out"));
        } else if (i == 0) {
            setInAnimation(getContext(), t.a(this.c, "tt_text_animation_x_in"));
            setOutAnimation(getContext(), t.a(this.c, "tt_text_animation_x_in"));
            getInAnimation().setInterpolator(new LinearInterpolator());
            getOutAnimation().setInterpolator(new LinearInterpolator());
            getInAnimation().setAnimationListener(this.m);
            getOutAnimation().setAnimationListener(this.m);
        }
        this.l.sendEmptyMessage(1);
    }

    public void c() {
        List<String> list = this.a;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = this.f298b;
        this.f298b = i + 1;
        this.i = i;
        setText(this.a.get(i));
        if (this.f298b > this.a.size() - 1) {
            this.f298b = 0;
        }
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView = new TextView(getContext());
        this.d = textView;
        textView.setTextColor(this.f);
        this.d.setTextSize(this.g);
        this.d.setMaxLines(this.h);
        if (Build.VERSION.SDK_INT >= 17) {
            this.d.setTextAlignment(this.k);
        }
        return this.d;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.l.removeMessages(1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(j.a(this.a.get(this.i), this.g, false)[0], 1073741824), i);
        } catch (Exception unused) {
            super.onMeasure(i, i2);
        }
    }

    public void setAnimationDuration(int i) {
        this.e = i;
    }

    public void setAnimationText(List<String> list) {
        this.a = list;
    }

    public void setAnimationType(int i) {
        this.j = i;
    }

    public void setMaxLines(int i) {
        this.h = i;
    }

    public void setTextColor(int i) {
        this.f = i;
    }

    public void setTextSize(float f) {
        this.g = f;
    }

    private void a() {
        setFactory(this);
    }

    @Override // com.bytedance.sdk.component.utils.y.a
    public void a(Message message) {
        if (message.what != 1) {
            return;
        }
        c();
        this.l.sendEmptyMessageDelayed(1, this.e);
    }
}
