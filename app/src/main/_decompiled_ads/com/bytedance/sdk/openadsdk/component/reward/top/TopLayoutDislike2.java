package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.ShadowImageView;
import com.bytedance.sdk.openadsdk.core.widget.ShadowTextView;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: loaded from: classes2.dex */
public class TopLayoutDislike2 extends PAGLinearLayout implements com.bytedance.sdk.openadsdk.component.reward.top.a<TopLayoutDislike2> {
    private View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f538b;
    private ShadowImageView c;
    private TextView d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;
    private com.bytedance.sdk.openadsdk.component.reward.top.b i;
    private boolean j;
    private boolean k;
    private CharSequence l;
    private boolean m;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TopLayoutDislike2.this.i != null) {
                TopLayoutDislike2.this.i.b(view);
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iE;
            TopLayoutDislike2 topLayoutDislike2 = TopLayoutDislike2.this;
            topLayoutDislike2.h = !topLayoutDislike2.h;
            if (TopLayoutDislike2.this.f538b != null) {
                iE = TopLayoutDislike2.this.h ? t.e(TopLayoutDislike2.this.getContext(), "tt_reward_full_mute") : t.e(TopLayoutDislike2.this.getContext(), "tt_reward_full_unmute");
            } else {
                iE = TopLayoutDislike2.this.h ? t.e(TopLayoutDislike2.this.getContext(), "tt_mute_wrapper") : t.e(TopLayoutDislike2.this.getContext(), "tt_unmute_wrapper");
            }
            TopLayoutDislike2.this.c.setImageResource(iE);
            if (Build.VERSION.SDK_INT >= 19 && TopLayoutDislike2.this.c.getDrawable() != null) {
                TopLayoutDislike2.this.c.getDrawable().setAutoMirrored(true);
            }
            if (TopLayoutDislike2.this.i != null) {
                TopLayoutDislike2.this.i.c(view);
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TopLayoutDislike2.this.i != null) {
                TopLayoutDislike2.this.i.a(view);
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TopLayoutDislike2.this.i != null) {
                TopLayoutDislike2.this.i.a(view);
            }
        }
    }

    public TopLayoutDislike2(Context context) {
        this(context, null);
    }

    private void g() {
        View view = this.a;
        if (view != null) {
            view.setOnClickListener(new a());
        }
        ShadowImageView shadowImageView = this.c;
        if (shadowImageView != null) {
            shadowImageView.setOnClickListener(new b());
        }
        ImageView imageView = this.f538b;
        if (imageView != null) {
            imageView.setOnClickListener(new c());
            return;
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.setOnClickListener(new d());
        }
    }

    private void h() {
        this.c = new ShadowImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(b0.a(getContext(), 28.0f), b0.a(getContext(), 28.0f));
        layoutParams.leftMargin = b0.a(getContext(), 16.0f);
        layoutParams.topMargin = b0.a(getContext(), 20.0f);
        this.c.setLayoutParams(layoutParams);
        this.c.setScaleType(ImageView.ScaleType.CENTER);
        ShadowImageView shadowImageView = new ShadowImageView(getContext());
        this.a = shadowImageView;
        shadowImageView.setId(520093713);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b0.a(getContext(), 28.0f), b0.a(getContext(), 28.0f));
        layoutParams2.topMargin = b0.a(getContext(), 20.0f);
        layoutParams2.leftMargin = b0.a(getContext(), 16.0f);
        this.a.setLayoutParams(layoutParams2);
        ((ImageView) this.a).setScaleType(ImageView.ScaleType.CENTER);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, 0);
        layoutParams3.weight = 1.0f;
        view.setLayoutParams(layoutParams3);
        ShadowTextView shadowTextView = new ShadowTextView(getContext());
        this.d = shadowTextView;
        shadowTextView.setId(520093714);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, b0.a(getContext(), 28.0f));
        layoutParams4.topMargin = b0.a(getContext(), 20.0f);
        int iA = b0.a(getContext(), 16.0f);
        layoutParams2.rightMargin = iA;
        layoutParams4.rightMargin = iA;
        this.d.setLayoutParams(layoutParams4);
        this.d.setGravity(17);
        this.d.setTextColor(Color.parseColor("#ffffff"));
        this.d.setTextSize(14.0f);
        this.d.setVisibility(8);
        this.f538b = new ShadowImageView(getContext());
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(b0.a(getContext(), 28.0f), b0.a(getContext(), 28.0f));
        layoutParams5.topMargin = b0.a(getContext(), 20.0f);
        layoutParams5.rightMargin = b0.a(getContext(), 16.0f);
        this.f538b.setLayoutParams(layoutParams5);
        this.f538b.setPadding(b0.a(getContext(), 4.0f), b0.a(getContext(), 4.0f), b0.a(getContext(), 4.0f), b0.a(getContext(), 4.0f));
        this.f538b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.c);
        addView(this.a);
        addView(view);
        addView(this.d);
        addView(this.f538b);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void e() {
        ShadowImageView shadowImageView = this.c;
        if (shadowImageView != null) {
            shadowImageView.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setListener(com.bytedance.sdk.openadsdk.component.reward.top.b bVar) {
        this.i = bVar;
    }

    public void setShouldShowSkipTime(boolean z) {
        this.j = z;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowDislike(boolean z) {
        View view = this.a;
        if (view == null || this.g) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSkip(boolean z) {
        TextView textView = this.d;
        if (textView != null) {
            if (!z) {
                textView.setText("");
            }
            if (this.f538b.getVisibility() == 4) {
                return;
            }
            this.k = !z;
            this.f538b.setVisibility((z && this.m) ? 0 : 8);
            this.d.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSound(boolean z) {
        ShadowImageView shadowImageView = this.c;
        if (shadowImageView != null) {
            shadowImageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSkipEnable(boolean z) {
        ImageView imageView = this.f538b;
        if (imageView != null) {
            imageView.setEnabled(z);
            this.f538b.setClickable(z);
            return;
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.setEnabled(z);
            this.d.setClickable(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSkipText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.d.setText(charSequence);
        ImageView imageView = this.f538b;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSoundMute(boolean z) {
        int iE;
        this.h = z;
        if (this.f538b != null) {
            iE = z ? t.e(getContext(), "tt_reward_full_mute") : t.e(getContext(), "tt_reward_full_unmute");
        } else {
            iE = z ? t.e(getContext(), "tt_mute_wrapper") : t.e(getContext(), "tt_unmute_wrapper");
        }
        this.c.setImageResource(iE);
        if (Build.VERSION.SDK_INT < 19 || this.c.getDrawable() == null) {
            return;
        }
        this.c.getDrawable().setAutoMirrored(true);
    }

    public TopLayoutDislike2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void b() {
        ImageView imageView = this.f538b;
        if (imageView != null) {
            imageView.performClick();
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void c() {
        this.d.setWidth(20);
        this.d.setVisibility(4);
        this.f538b.setVisibility(4);
        this.k = true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void d() {
        this.d.setVisibility(0);
    }

    public TopLayoutDislike2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = "";
        setOrientation(0);
    }

    public TopLayoutDislike2 a(boolean z, q qVar) {
        a(qVar);
        this.a.setVisibility(0);
        ((ImageView) this.a).setImageResource(t.e(o.a(), "tt_reward_full_feedback"));
        this.f538b.setImageResource(t.e(o.a(), "tt_skip_btn"));
        if (Build.VERSION.SDK_INT >= 19 && this.f538b.getDrawable() != null) {
            this.f538b.getDrawable().setAutoMirrored(true);
        }
        this.f538b.setVisibility(8);
        this.e = qVar.N0() == null ? 0 : ((int) qVar.N0().s()) * qVar.N0().m();
        if (com.bytedance.sdk.openadsdk.core.f0.o.b(qVar) && qVar.h0() != null) {
            this.e = (int) qVar.h0().c();
        }
        if (this.e <= 0) {
            this.e = 10;
        }
        if (qVar.R() == 8 && qVar.f() != null) {
            this.f = o.d().r(qVar.f().getCodeId());
        } else {
            this.f = o.d().a(qVar.f().getCodeId());
        }
        int i = this.f;
        this.j = i == -1 || i >= this.e;
        if (qVar.k1()) {
            this.a.setVisibility(8);
            this.g = true;
        }
        this.d.setVisibility(0);
        this.d.setText("");
        this.d.setEnabled(false);
        this.d.setClickable(false);
        g();
        return this;
    }

    private void a(q qVar) {
        h();
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a(CharSequence charSequence, CharSequence charSequence2) {
        int i;
        if (!TextUtils.isEmpty(charSequence)) {
            this.l = charSequence;
        }
        if (this.f538b != null) {
            this.m = true;
            if (this.j) {
                this.d.setText(((Object) this.l) + "s");
                a(false);
                return;
            }
            String str = (String) this.l;
            try {
                int i2 = this.f;
                if (i2 == 0) {
                    i = Integer.parseInt(str);
                } else {
                    i = i2 - (this.e - Integer.parseInt(str));
                }
                if (i > 0) {
                    if (this.f == 0) {
                        a(false);
                        return;
                    } else {
                        this.d.setText(String.format(t.k(b.b.a.a.d.c.a(), "tt_reward_full_skip"), Integer.valueOf(i)));
                        a(true);
                        return;
                    }
                }
                this.d.setText(((Object) this.l) + "s");
                a(false);
            } catch (Exception unused) {
            }
        }
    }

    private void a(boolean z) {
        if (this.k) {
            return;
        }
        if (this.j) {
            this.f538b.setVisibility(8);
            this.d.setVisibility(0);
        } else if (z) {
            this.d.setVisibility(0);
            this.f538b.setVisibility(8);
        } else {
            this.f538b.setVisibility(0);
            this.d.setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a() {
        ImageView imageView = this.f538b;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        this.d.setVisibility(8);
    }
}
