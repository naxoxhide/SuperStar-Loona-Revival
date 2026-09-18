package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGButton;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: compiled from: CustomCommonDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends Dialog {
    private PAGImageView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PAGTextView f699b;
    private PAGTextView c;
    private PAGButton d;
    private PAGButton e;
    private View f;
    private Context g;
    private String h;
    private String i;
    private String j;
    private String k;
    private int l;
    private boolean m;
    public c n;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CustomCommonDialog.java */
    class ViewOnClickListenerC0220a implements View.OnClickListener {
        ViewOnClickListenerC0220a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = a.this.n;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: CustomCommonDialog.java */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = a.this.n;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    /* JADX INFO: compiled from: CustomCommonDialog.java */
    public interface c {
        void a();

        void b();
    }

    public a(Context context) {
        super(context, t.l(context, "tt_custom_dialog"));
        this.l = -1;
        this.m = false;
        this.g = context;
    }

    private void a() {
        this.e.setOnClickListener(new ViewOnClickListenerC0220a());
        this.d.setOnClickListener(new b());
    }

    private void b() {
        if (TextUtils.isEmpty(this.i)) {
            this.f699b.setVisibility(8);
        } else {
            this.f699b.setText(this.i);
            this.f699b.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.h)) {
            this.c.setText(this.h);
        }
        if (TextUtils.isEmpty(this.j)) {
            this.e.setText(t.k(o.a(), "tt_postive_txt"));
        } else {
            this.e.setText(this.j);
        }
        if (TextUtils.isEmpty(this.k)) {
            this.d.setText(t.k(o.a(), "tt_negtive_txt"));
        } else {
            this.d.setText(this.k);
        }
        int i = this.l;
        if (i != -1) {
            this.a.setImageResource(i);
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
        }
        if (this.m) {
            this.f.setVisibility(8);
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
            this.f.setVisibility(0);
        }
    }

    public a c(String str) {
        this.j = str;
        return this;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a(this.g));
        setCanceledOnTouchOutside(false);
        b();
        a();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        b();
    }

    private View a(Context context) {
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        pAGRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        pAGLinearLayout.setMinimumWidth(a(260.0f));
        pAGLinearLayout.setPadding(0, a(32.0f), 0, 0);
        pAGLinearLayout.setBackground(t.f(context, "tt_custom_dialog_bg"));
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setLayoutParams(layoutParams);
        this.f699b = new PAGTextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.leftMargin = a(16.0f);
        layoutParams2.rightMargin = a(16.0f);
        layoutParams2.bottomMargin = a(16.0f);
        this.f699b.setGravity(17);
        this.f699b.setVisibility(0);
        this.f699b.setTextColor(Color.parseColor("#333333"));
        this.f699b.setTextSize(18.0f);
        this.f699b.setLayoutParams(layoutParams2);
        this.a = new PAGImageView(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        layoutParams3.leftMargin = a(16.0f);
        layoutParams3.rightMargin = a(16.0f);
        layoutParams3.bottomMargin = a(10.0f);
        this.a.setMaxHeight(a(150.0f));
        this.a.setMaxWidth(a(150.0f));
        this.a.setVisibility(0);
        this.a.setLayoutParams(layoutParams3);
        this.c = new PAGTextView(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.leftMargin = a(20.0f);
        layoutParams4.rightMargin = a(20.0f);
        this.c.setGravity(17);
        this.c.setLineSpacing(a(3.0f), 1.2f);
        this.c.setTextSize(18.0f);
        this.c.setTextColor(Color.parseColor("#000000"));
        this.c.setLayoutParams(layoutParams4);
        View view = new View(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, 1);
        layoutParams5.topMargin = a(32.0f);
        view.setBackgroundColor(Color.parseColor("#E4E4E4"));
        view.setLayoutParams(layoutParams5);
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        pAGLinearLayout2.setOrientation(0);
        pAGLinearLayout2.setLayoutParams(layoutParams6);
        PAGButton pAGButton = new PAGButton(context);
        this.d = pAGButton;
        pAGButton.setId(520093718);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -2);
        layoutParams7.leftMargin = a(10.0f);
        layoutParams7.weight = 1.0f;
        this.d.setPadding(0, a(16.0f), 0, a(16.0f));
        this.d.setBackground(null);
        this.d.setGravity(17);
        this.d.setSingleLine(true);
        this.d.setTextColor(Color.parseColor("#999999"));
        this.d.setTextSize(16.0f);
        this.d.setLayoutParams(layoutParams7);
        this.f = new View(context);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(1, -1);
        this.f.setBackgroundColor(Color.parseColor("#E4E4E4"));
        this.f.setLayoutParams(layoutParams8);
        this.e = new PAGButton(context);
        this.d.setId(520093719);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(0, -2);
        layoutParams9.rightMargin = a(10.0f);
        layoutParams9.weight = 1.0f;
        this.e.setPadding(0, a(16.0f), 0, a(16.0f));
        this.e.setBackground(null);
        this.e.setGravity(17);
        this.e.setSingleLine(true);
        this.e.setTextColor(Color.parseColor("#38ADFF"));
        this.e.setTextSize(16.0f);
        this.e.setLayoutParams(layoutParams9);
        pAGRelativeLayout.addView(pAGLinearLayout);
        pAGLinearLayout.addView(this.f699b);
        pAGLinearLayout.addView(this.a);
        pAGLinearLayout.addView(this.c);
        pAGLinearLayout.addView(view);
        pAGLinearLayout.addView(pAGLinearLayout2);
        pAGLinearLayout2.addView(this.d);
        pAGLinearLayout2.addView(this.f);
        pAGLinearLayout2.addView(this.e);
        return pAGRelativeLayout;
    }

    public a b(String str) {
        this.k = str;
        return this;
    }

    private int a(float f) {
        return b0.a(getContext(), f);
    }

    public a a(c cVar) {
        this.n = cVar;
        return this;
    }

    public a a(String str) {
        this.h = str;
        return this;
    }
}
