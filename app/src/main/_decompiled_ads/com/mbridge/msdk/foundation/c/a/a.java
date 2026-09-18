package com.mbridge.msdk.foundation.c.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.mbridge.msdk.c.c;
import com.mbridge.msdk.c.d;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.FeedbackRadioGroup;
import com.mbridge.msdk.widget.dialog.MBFeedBackDialog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: compiled from: FeedBackBtnBean.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static String B = null;
    private static int u = -1;
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CampaignEx f2063b;
    private FeedBackButton c;
    private int d;
    private int e;
    private JSONArray l;
    private String q;
    private String r;
    private MBFeedBackDialog w;
    private List<C0478a> x;
    private Dialog z;
    private String f = "";
    private int g = -1;
    private int h = -1;
    private int i = -1;
    private int j = -1;
    private float k = -1.0f;
    private int m = -1;
    private int n = -1;
    private int o = -1;
    private int p = -1;
    private float s = 1.0f;
    private int t = af.b(b.d().g(), 20.0f);
    private int v = u;
    private String y = "";
    private com.mbridge.msdk.widget.dialog.a A = new com.mbridge.msdk.widget.dialog.a() { // from class: com.mbridge.msdk.foundation.c.a.a.1
        @Override // com.mbridge.msdk.widget.dialog.a
        public final void a() {
            a.a(a.this);
        }

        @Override // com.mbridge.msdk.widget.dialog.a
        public final void b() {
            a.b(a.this);
        }

        @Override // com.mbridge.msdk.widget.dialog.a
        public final void c() {
            a.c(a.this);
        }
    };

    public a(String str) {
        this.x = new ArrayList();
        this.a = str;
        if (this.x == null) {
            this.x = new ArrayList();
        }
        i();
        l();
        j();
    }

    private void i() {
        if (this.A == null) {
            this.A = new com.mbridge.msdk.widget.dialog.a() { // from class: com.mbridge.msdk.foundation.c.a.a.2
                @Override // com.mbridge.msdk.widget.dialog.a
                public final void b() {
                    a.b(a.this);
                }

                @Override // com.mbridge.msdk.widget.dialog.a
                public final void c() {
                    a.c(a.this);
                }

                @Override // com.mbridge.msdk.widget.dialog.a
                public final void a() {
                    a.a(a.this);
                }
            };
        }
    }

    public final void a() {
        try {
            com.mbridge.msdk.foundation.c.b.a().a(this.a, 0, 1, B, this.f);
            Activity activityA = com.mbridge.msdk.foundation.c.b.a().a(b.d().g());
            MBFeedBackDialog mBFeedBackDialog = this.w;
            if (mBFeedBackDialog == null || mBFeedBackDialog.getContext() != activityA) {
                j();
            }
            Context contextG = b.d().g();
            FeedBackButton feedBackButton = this.c;
            if (feedBackButton != null) {
                contextG = feedBackButton.getContext();
            }
            boolean zA = com.mbridge.msdk.foundation.c.b.a().a(this.a, contextG, this.w);
            int i = zA ? 2 : 3;
            if (i == 2) {
                com.mbridge.msdk.foundation.c.b.a().a(this.a, 0, 2, B, this.f);
            } else {
                com.mbridge.msdk.foundation.c.b.a().a(this.a, 0, 3, B, this.f);
            }
            List<C0478a> list = this.x;
            if (list != null) {
                for (C0478a c0478a : list) {
                    if (c0478a != null) {
                        c0478a.a(i);
                    }
                }
            }
            if (zA) {
                return;
            }
            a(contextG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void b() {
        MBFeedBackDialog mBFeedBackDialog = this.w;
        if (mBFeedBackDialog == null || !mBFeedBackDialog.isShowing()) {
            return;
        }
        this.w.cancel();
    }

    private void j() {
        try {
            if (com.mbridge.msdk.foundation.c.b.a().a(b.d().g()) != null) {
                c cVarB = d.a().b(b.d().h());
                if (cVarB == null) {
                    cVarB = d.a().b();
                }
                c.b bVarAu = cVarB.au();
                if (bVarAu == null) {
                    aa.b("", "feedback fbk is null");
                    return;
                }
                i();
                this.w = new MBFeedBackDialog(com.mbridge.msdk.foundation.c.b.a().a(b.d().g()), this.A);
                FeedbackRadioGroup feedbackRadioGroupA = a(bVarAu);
                this.w.setCancelText(bVarAu.c());
                this.w.setConfirmText(bVarAu.b());
                this.w.setPrivacyText(bVarAu.e());
                this.y = bVarAu.d();
                this.w.setTitle(bVarAu.a());
                this.w.setContent(feedbackRadioGroupA);
                this.w.setCancelButtonClickable(!TextUtils.isEmpty(B));
                a(feedbackRadioGroupA, bVarAu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(int i) {
        this.v = i;
        FeedBackButton feedBackButton = this.c;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(i);
        }
    }

    private void a(FeedbackRadioGroup feedbackRadioGroup, c.b bVar) {
        JSONArray jSONArrayF = bVar.f();
        Context contextG = b.d().g();
        if (jSONArrayF == null || jSONArrayF.length() <= 0 || contextG == null) {
            return;
        }
        t.a(contextG, "mbridge_cm_feedback_choice_btn_bg", "drawable");
        Resources resourcesA = t.a(contextG);
        int iA = t.a(contextG, "mbridge_cm_feedback_rb_text_color_color_list", "color");
        ColorStateList colorStateList = null;
        if (resourcesA != null) {
            try {
                colorStateList = resourcesA.getColorStateList(iA);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int iB = af.b(contextG, 1.0f);
        int iB2 = af.b(contextG, 1.0f);
        int iB3 = af.b(contextG, 1.0f);
        for (int i = 0; i < jSONArrayF.length(); i++) {
            String strOptString = jSONArrayF.optString(i);
            RadioButton radioButton = new RadioButton(contextG);
            if (Build.VERSION.SDK_INT >= 21) {
                radioButton.setButtonTintList(colorStateList);
            }
            radioButton.setText(strOptString);
            if (colorStateList != null) {
                radioButton.setTextColor(colorStateList);
            }
            radioButton.setCompoundDrawablePadding(iB);
            radioButton.setPadding(iB, iB2, iB, iB2);
            radioButton.setEllipsize(TextUtils.TruncateAt.END);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
            int i2 = iB3 / 4;
            layoutParams.setMargins(iB3, i2, iB3, i2);
            a(radioButton);
            feedbackRadioGroup.addView(radioButton, layoutParams);
        }
    }

    private FeedbackRadioGroup a(c.b bVar) {
        JSONArray jSONArrayF = bVar.f();
        Context contextG = b.d().g();
        if (jSONArrayF == null || jSONArrayF.length() <= 0 || contextG == null) {
            return null;
        }
        FeedbackRadioGroup feedbackRadioGroup = new FeedbackRadioGroup(contextG);
        feedbackRadioGroup.setOrientation(0);
        return feedbackRadioGroup;
    }

    private void a(RadioButton radioButton) {
        if (radioButton != null) {
            radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mbridge.msdk.foundation.c.a.a.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        String unused = a.B = (String) compoundButton.getText();
                    }
                    if (a.this.w != null) {
                        a.this.w.setCancelButtonClickable(!TextUtils.isEmpty(a.B));
                    }
                }
            });
        }
    }

    public final void a(C0478a c0478a) {
        if (this.x == null) {
            this.x = new ArrayList();
        }
        this.x.add(c0478a);
    }

    private void a(Context context) {
        if (context != null) {
            try {
                com.mbridge.msdk.click.b.b(context, af.c(this.f2063b));
            } catch (Exception unused) {
                com.mbridge.msdk.click.b.a(context, af.c(this.f2063b));
            }
        }
    }

    private void k() {
        FeedBackButton feedBackButton = this.c;
        if (feedBackButton != null) {
            int i = this.g;
            if (i > -1) {
                feedBackButton.setX(i);
            }
            int i2 = this.h;
            if (i2 > -1) {
                this.c.setY(i2);
            }
            float f = this.s;
            if (f >= 0.0f) {
                this.c.setAlpha(f);
                this.c.setEnabled(this.s != 0.0f);
            }
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            int i3 = this.i;
            if (i3 > 0) {
                this.c.setWidth(i3);
                if (layoutParams != null) {
                    layoutParams.width = this.i;
                }
            }
            int i4 = this.j;
            if (i4 > 0) {
                this.c.setHeight(i4);
                if (layoutParams != null) {
                    layoutParams.height = this.j;
                }
            }
            if (layoutParams != null) {
                this.c.setLayoutParams(layoutParams);
            }
            try {
                if (!TextUtils.isEmpty(this.q)) {
                    this.c.setTextColor(Color.parseColor(this.q));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            float f2 = this.k;
            if (f2 > 0.0f) {
                this.c.setTextSize(f2);
            }
            JSONArray jSONArray = this.l;
            if (jSONArray != null && jSONArray.length() == 4) {
                Context contextG = b.d().g();
                this.c.setPadding(af.b(contextG, (float) this.l.optDouble(0)), af.b(contextG, (float) this.l.optDouble(1)), af.b(contextG, (float) this.l.optDouble(2)), af.b(contextG, (float) this.l.optDouble(3)));
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            int i5 = this.t;
            if (i5 > 0) {
                gradientDrawable.setCornerRadius(i5);
            }
            if (!TextUtils.isEmpty(this.r)) {
                gradientDrawable.setColor(Color.parseColor(this.r));
            } else {
                gradientDrawable.setColor(Color.parseColor(FeedBackButton.FEEDBACK_BTN_BACKGROUND_COLOR_STR));
            }
            this.c.setBackground(gradientDrawable);
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, float f, String str, String str2, float f2, JSONArray jSONArray) {
        if (i > -1) {
            this.g = i;
        }
        if (i2 > -1) {
            this.h = i2;
        }
        if (i3 > -1) {
            this.i = i3;
        }
        if (i4 > -1) {
            this.j = i4;
        }
        if (f2 > -1.0f) {
            this.k = f2;
        }
        if (jSONArray != null) {
            this.l = jSONArray;
        }
        this.q = str;
        this.r = str2;
        this.s = f;
        this.t = i5;
        k();
    }

    private void l() {
        Context contextG = b.d().g();
        if (contextG != null) {
            try {
                FeedBackButton feedBackButton = new FeedBackButton(contextG);
                this.c = feedBackButton;
                int i = 8;
                if (this.v != 8) {
                    i = 0;
                }
                feedBackButton.setVisibility(i);
                this.c.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.foundation.c.a.a.5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        a.this.a();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final FeedBackButton c() {
        if (this.c == null) {
            l();
        }
        return this.c;
    }

    public final void d() {
        FeedBackButton feedBackButton = this.c;
        if (feedBackButton != null) {
            feedBackButton.setOnClickListener(null);
            this.c.setVisibility(8);
            ViewGroup viewGroup = (ViewGroup) this.c.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.c);
            }
        }
        MBFeedBackDialog mBFeedBackDialog = this.w;
        if (mBFeedBackDialog != null) {
            mBFeedBackDialog.cancel();
            this.w.setListener(null);
        }
        this.w = null;
        this.x = null;
        this.c = null;
        this.A = null;
    }

    public final CampaignEx e() {
        return this.f2063b;
    }

    public final void a(CampaignEx campaignEx) {
        this.f2063b = campaignEx;
    }

    public final int f() {
        return this.d;
    }

    public final void b(int i) {
        this.d = i;
    }

    public final int g() {
        return this.e;
    }

    public final void c(int i) {
        this.e = i;
    }

    public final void a(String str) {
        this.f = str;
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.c.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FeedBackBtnBean.java */
    public static class C0478a implements com.mbridge.msdk.widget.dialog.a {
        private com.mbridge.msdk.foundation.c.a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f2064b;

        public C0478a(String str, com.mbridge.msdk.foundation.c.a aVar) {
            this.a = aVar;
            this.f2064b = str;
        }

        @Override // com.mbridge.msdk.widget.dialog.a
        public final void a() {
            com.mbridge.msdk.foundation.c.a aVar = this.a;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.mbridge.msdk.widget.dialog.a
        public final void b() {
            com.mbridge.msdk.foundation.c.b.c = false;
            com.mbridge.msdk.foundation.c.a aVar = this.a;
            if (aVar != null) {
                aVar.a(a.B);
            }
        }

        @Override // com.mbridge.msdk.widget.dialog.a
        public final void c() {
            com.mbridge.msdk.foundation.c.b.c = false;
            com.mbridge.msdk.foundation.c.a aVar = this.a;
            if (aVar != null) {
                aVar.b();
            }
        }

        public final void a(int i) {
            com.mbridge.msdk.foundation.c.b.c = true;
            com.mbridge.msdk.foundation.c.a aVar = this.a;
            if (aVar == null || i != 2) {
                return;
            }
            aVar.a();
        }
    }

    public final void a(FeedBackButton feedBackButton) {
        FeedBackButton feedBackButton2 = this.c;
        if (feedBackButton2 != null) {
            feedBackButton2.setVisibility(8);
        }
        if (feedBackButton != null) {
            feedBackButton.setAlpha(this.s);
            feedBackButton.setEnabled(this.s != 0.0f);
            feedBackButton.setVisibility(this.v != 8 ? 0 : 8);
            this.c = feedBackButton;
            CampaignEx campaignEx = this.f2063b;
            if (campaignEx != null && !campaignEx.isDynamicView()) {
                k();
            }
            feedBackButton.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.foundation.c.a.a.6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.this.a();
                }
            });
        }
    }

    static /* synthetic */ void a(a aVar) {
        com.mbridge.msdk.foundation.c.b.a().a(aVar.a, 0, 4, B, aVar.f);
        Context contextC = b.d().c();
        if (contextC == null) {
            contextC = b.d().g();
        }
        List<C0478a> list = aVar.x;
        if (list != null) {
            for (C0478a c0478a : list) {
                if (c0478a != null) {
                    c0478a.c();
                }
            }
        }
        aVar.a(contextC);
        B = "";
    }

    static /* synthetic */ void b(a aVar) {
        com.mbridge.msdk.foundation.c.b.a().a(aVar.a, 1, 4, B, aVar.f);
        List<C0478a> list = aVar.x;
        if (list != null) {
            for (C0478a c0478a : list) {
                if (c0478a != null) {
                    c0478a.b();
                }
            }
        }
        if (!TextUtils.isEmpty(aVar.y)) {
            try {
                Activity activityA = com.mbridge.msdk.foundation.c.b.a().a(b.d().g());
                if (activityA != null) {
                    View viewInflate = LayoutInflater.from(activityA).inflate(t.a(activityA, "mbridge_cm_feedback_notice_layout", "layout"), (ViewGroup) null);
                    Dialog dialog = new Dialog(activityA, 3);
                    aVar.z = dialog;
                    dialog.requestWindowFeature(1);
                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                    Window window = aVar.z.getWindow();
                    layoutParams.copyFrom(window.getAttributes());
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                    aVar.z.setContentView(viewInflate);
                    aVar.z.show();
                    window.setAttributes(layoutParams);
                    viewInflate.postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.c.a.a.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                if (a.this.z == null || !a.this.z.isShowing()) {
                                    return;
                                }
                                a.this.z.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, 2000L);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        B = "";
    }

    static /* synthetic */ void c(a aVar) {
        com.mbridge.msdk.foundation.c.b.a().a(aVar.a, 0, 4, B, aVar.f);
        List<C0478a> list = aVar.x;
        if (list != null) {
            for (C0478a c0478a : list) {
                if (c0478a != null) {
                    c0478a.c();
                }
            }
        }
        B = "";
    }
}
