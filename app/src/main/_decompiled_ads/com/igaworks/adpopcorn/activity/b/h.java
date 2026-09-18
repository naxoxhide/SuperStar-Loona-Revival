package com.igaworks.adpopcorn.activity.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.style.ApStyleManager;
import com.kbeanie.imagechooser.api.ChooserType;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h extends Dialog implements com.igaworks.adpopcorn.a.g.a.d {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.igaworks.adpopcorn.a.g.a f1538b;
    private com.igaworks.adpopcorn.cores.model.h c;
    private com.igaworks.adpopcorn.cores.common.g d;
    private GradientDrawable e;
    private GradientDrawable f;
    private GradientDrawable g;
    private boolean h;
    private com.igaworks.adpopcorn.activity.b.d.c i;
    private com.igaworks.adpopcorn.activity.b.d.a j;
    private com.igaworks.adpopcorn.activity.c.c k;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.e();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.c != null) {
                com.igaworks.adpopcorn.a.b.a().c(h.this.a, h.this.c.b());
            }
            h.this.dismiss();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.dismiss();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.a();
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.e();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.k != null) {
                h.this.k.setSelected(!h.this.k.isSelected());
            }
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.k != null) {
                h.this.k.setSelected(true);
            }
            h.this.a();
        }
    }

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.h$h, reason: collision with other inner class name */
    class ViewOnClickListenerC0414h implements View.OnClickListener {
        ViewOnClickListenerC0414h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.j == null || !h.this.j.isShowing()) {
                return;
            }
            h.this.j.dismiss();
            h.this.j = null;
        }
    }

    public h(Context context, int i, boolean z, com.igaworks.adpopcorn.cores.model.h hVar) {
        super(context, i);
        this.a = context;
        this.h = z;
        this.c = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.igaworks.adpopcorn.activity.c.c cVar;
        try {
            if (this.c != null && (cVar = this.k) != null && cVar.isSelected()) {
                com.igaworks.adpopcorn.a.b.a().c(this.a, this.c.b());
            }
            b();
        } catch (Exception unused) {
        } finally {
            dismiss();
        }
    }

    private void a(com.igaworks.adpopcorn.cores.model.f fVar) {
        String str;
        String str2;
        String str3;
        String str4;
        b();
        if (fVar != null && fVar.d()) {
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            str = gVar.p;
            str2 = gVar.e;
        } else if (fVar == null || fVar.a().length() <= 0) {
            com.igaworks.adpopcorn.cores.common.g gVar2 = this.d;
            str = gVar2.Y;
            str2 = gVar2.g;
        } else {
            try {
                com.igaworks.adpopcorn.cores.common.h.a(this.a, "APPopupAdDialog", "callbackJoinPopupAd result = " + fVar.a(), 3);
                JSONObject jSONObject = new JSONObject(fVar.a());
                boolean z = jSONObject.getBoolean("Result");
                String string = jSONObject.getString("ResultMsg");
                int i = jSONObject.getInt("ResultCode");
                String string2 = (!jSONObject.has("RedirectURL") || jSONObject.isNull("RedirectURL")) ? "" : jSONObject.getString("RedirectURL");
                if (z) {
                    com.igaworks.adpopcorn.cores.common.h.a(this.a, "APPopupAdDialog", "callbackJoinPopupAd success, redirectURL = " + string2, 3);
                    b();
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(string2));
                    try {
                        this.a.startActivity(intent);
                        return;
                    } catch (Exception unused) {
                        com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
                        str3 = gVar3.q;
                        str4 = gVar3.w;
                    }
                } else {
                    if (i != 999 && i != 1000) {
                        a(this.d.q, string);
                        return;
                    }
                    com.igaworks.adpopcorn.cores.common.g gVar4 = this.d;
                    str3 = gVar4.q;
                    str4 = gVar4.l0;
                }
                a(str3, str4);
                return;
            } catch (JSONException unused2) {
            }
        }
        a(str, str2);
    }

    private void a(String str, String str2) {
        com.igaworks.adpopcorn.activity.b.d.a aVar = this.j;
        if (aVar != null && aVar.isShowing()) {
            this.j.dismiss();
            this.j = null;
        }
        String str3 = this.d.h;
        try {
            Context context = this.a;
            com.igaworks.adpopcorn.activity.b.d.a aVar2 = new com.igaworks.adpopcorn.activity.b.d.a(context, com.igaworks.adpopcorn.activity.b.d.a(context), str, str2, -1, str3, new ViewOnClickListenerC0414h(), this.h, false);
            this.j = aVar2;
            aVar2.setCancelable(false);
            this.j.setCanceledOnTouchOutside(false);
            this.j.show();
        } catch (Exception unused) {
        }
    }

    private void b() {
        com.igaworks.adpopcorn.activity.b.d.c cVar = this.i;
        if (cVar != null) {
            cVar.dismiss();
            this.i = null;
        }
    }

    private View c() {
        String strG = this.c.g();
        String strC = this.c.c();
        String strF = this.c.f();
        String strH = this.c.h();
        int iA = com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
        int iA2 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 420);
        int iA3 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 325);
        int iA4 = com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
        int iA5 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 180);
        int iA6 = com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
        int iA7 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 95);
        int iA8 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 270);
        int iA9 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 42);
        int iA10 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 48);
        LinearLayout linearLayout = new LinearLayout(this.a.getApplicationContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setGravity(49);
        View view = new View(this.a.getApplicationContext());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        linearLayout.addView(view);
        FrameLayout frameLayout = new FrameLayout(this.a.getApplicationContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, iA2);
        layoutParams.gravity = 1;
        frameLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(this.a.getApplicationContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iA, iA3);
        layoutParams2.gravity = 1;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        com.igaworks.adpopcorn.cores.common.e.a(this.a, this.c.e(), imageView, com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), com.igaworks.adpopcorn.cores.common.d.a(this.a, 325), (com.igaworks.adpopcorn.cores.common.e.b) null);
        imageView.setLayoutParams(layoutParams2);
        frameLayout.addView(imageView);
        LinearLayout linearLayout2 = new LinearLayout(this.a.getApplicationContext());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(iA4, iA5);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = iA7;
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(80);
        linearLayout2.setBackgroundDrawable(this.e);
        linearLayout2.setLayoutParams(layoutParams3);
        frameLayout.addView(linearLayout2);
        TextView textView = new TextView(this.a.getApplicationContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        k.b(textView, strG, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_POPUP_AD_TITLE_TEXT_SIZE_DP), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_POPUP_AD_TITLE_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
        textView.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), com.igaworks.adpopcorn.cores.common.d.a(this.a, 4));
        textView.setGravity(3);
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(this.a.getApplicationContext());
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        k.b(textView2, strC, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_POPUP_AD_DESC_TEXT_SIZE_DP), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_POPUP_AD_DESC_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, false);
        textView2.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), 0);
        textView2.setGravity(3);
        linearLayout2.addView(textView2);
        LinearLayout linearLayout3 = new LinearLayout(this.a.getApplicationContext());
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(iA6, iA7);
        layoutParams4.topMargin = iA5;
        layoutParams4.gravity = 81;
        linearLayout3.setOrientation(1);
        linearLayout3.setBackgroundColor(Color.parseColor("#000000"));
        linearLayout3.setLayoutParams(layoutParams4);
        frameLayout.addView(linearLayout3);
        LinearLayout linearLayout4 = new LinearLayout(this.a.getApplicationContext());
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        linearLayout4.setOrientation(0);
        linearLayout4.setLayoutParams(layoutParams5);
        linearLayout3.addView(linearLayout4);
        ImageView imageView2 = new ImageView(this.a.getApplicationContext());
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 18), com.igaworks.adpopcorn.cores.common.d.a(this.a, 18));
        layoutParams6.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 15);
        layoutParams6.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 6);
        imageView2.setLayoutParams(layoutParams6);
        com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_tcpa_ic_download_circle.png", imageView2, false);
        imageView2.setColorFilter(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PORTRAIT_POPUP_AD_REWARD_CONDITION_ICON_COLOR), PorterDuff.Mode.MULTIPLY);
        linearLayout4.addView(imageView2);
        TextView textView3 = new TextView(this.a.getApplicationContext());
        textView3.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 18)));
        k.b(textView3, strF, 12, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PORTRAIT_POPUP_AD_REWARD_CONDITION_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, false);
        textView3.setGravity(19);
        textView3.setIncludeFontPadding(false);
        linearLayout4.addView(textView3);
        LinearLayout linearLayout5 = new LinearLayout(this.a.getApplicationContext());
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(iA8, iA9);
        layoutParams7.gravity = 17;
        layoutParams7.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        layoutParams7.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 15);
        linearLayout5.setOrientation(0);
        linearLayout5.setGravity(16);
        linearLayout5.setBackgroundDrawable(this.g);
        linearLayout5.setLayoutParams(layoutParams7);
        linearLayout5.setOnClickListener(new a());
        linearLayout3.addView(linearLayout5);
        TextView textView4 = new TextView(this.a.getApplicationContext());
        textView4.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        k.b(textView4, "+" + strH, 18, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_POPUP_AD_REWARD_BTN_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
        textView4.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 12), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 12), 0);
        textView4.setGravity(19);
        linearLayout5.addView(textView4);
        TextView textView5 = new TextView(this.a.getApplicationContext());
        textView5.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        k.b(textView5, this.d.r1, 12, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_POPUP_AD_REWARD_BTN_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
        textView5.setGravity(19);
        linearLayout5.addView(textView5);
        ImageView imageView3 = new ImageView(this.a.getApplicationContext());
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 18), com.igaworks.adpopcorn.cores.common.d.a(this.a, 18));
        layoutParams8.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 6);
        layoutParams8.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        layoutParams8.gravity = 16;
        imageView3.setLayoutParams(layoutParams8);
        com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_tcpa_ic_chevron_circle_fill_right.png", imageView3, true);
        linearLayout5.addView(imageView3);
        linearLayout.addView(frameLayout);
        View view2 = new View(this.a.getApplicationContext());
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        linearLayout.addView(view2);
        LinearLayout linearLayout6 = new LinearLayout(this.a.getApplicationContext());
        linearLayout6.setLayoutParams(new LinearLayout.LayoutParams(-1, iA10));
        linearLayout6.setOrientation(0);
        linearLayout6.setBackgroundColor(Color.parseColor("#f6f6f6"));
        linearLayout.addView(linearLayout6);
        TextView textView6 = new TextView(this.a.getApplicationContext());
        textView6.setLayoutParams(new LinearLayout.LayoutParams(0, iA10, 1.0f));
        k.b(textView6, this.d.q1, 14, Color.parseColor("#7f000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
        textView6.setGravity(17);
        textView6.setOnClickListener(new b());
        linearLayout6.addView(textView6);
        ImageView imageView4 = new ImageView(this.a.getApplicationContext());
        imageView4.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 1), -1));
        imageView4.setBackgroundColor(Color.parseColor("#14000000"));
        linearLayout6.addView(imageView4);
        TextView textView7 = new TextView(this.a.getApplicationContext());
        textView7.setLayoutParams(new LinearLayout.LayoutParams(0, iA10, 1.0f));
        k.b(textView7, this.d.h, 14, Color.parseColor("#7f000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
        textView7.setGravity(17);
        textView7.setOnClickListener(new c());
        linearLayout6.addView(textView7);
        return linearLayout;
    }

    private View d() {
        String strG = this.c.g();
        String strC = this.c.c();
        String strF = this.c.f();
        String strH = this.c.h();
        int iA = com.igaworks.adpopcorn.cores.common.d.a(this.a, 524);
        int iA2 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 274);
        int iA3 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 274);
        int iA4 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 524);
        int iA5 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 204);
        int iA6 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 524);
        int iA7 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 70);
        int iA8 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 492);
        int iA9 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 42);
        int iA10 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 24);
        LinearLayout linearLayout = new LinearLayout(this.a.getApplicationContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setGravity(17);
        FrameLayout frameLayout = new FrameLayout(this.a.getApplicationContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, iA2);
        layoutParams.gravity = 1;
        frameLayout.setLayoutParams(layoutParams);
        linearLayout.addView(frameLayout);
        ImageView imageView = new ImageView(this.a.getApplicationContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iA, iA3);
        layoutParams2.gravity = 1;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        com.igaworks.adpopcorn.cores.common.e.a(this.a, this.c.d(), imageView, com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), com.igaworks.adpopcorn.cores.common.d.a(this.a, 325), (com.igaworks.adpopcorn.cores.common.e.b) null);
        imageView.setLayoutParams(layoutParams2);
        frameLayout.addView(imageView);
        LinearLayout linearLayout2 = new LinearLayout(this.a.getApplicationContext());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(iA4, iA5);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = iA7;
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(80);
        linearLayout2.setBackgroundDrawable(this.f);
        linearLayout2.setLayoutParams(layoutParams3);
        frameLayout.addView(linearLayout2);
        LinearLayout linearLayout3 = new LinearLayout(this.a.getApplicationContext());
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(iA4, iA5);
        layoutParams4.gravity = 49;
        linearLayout3.setOrientation(1);
        linearLayout3.setGravity(53);
        linearLayout3.setLayoutParams(layoutParams4);
        frameLayout.addView(linearLayout3);
        ImageView imageView2 = new ImageView(this.a.getApplicationContext());
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 32), com.igaworks.adpopcorn.cores.common.d.a(this.a, 32));
        layoutParams5.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 4);
        layoutParams5.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 4);
        layoutParams5.gravity = 53;
        imageView2.setLayoutParams(layoutParams5);
        com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_tcpa_close_button.png", imageView2, false);
        imageView2.setOnClickListener(new d());
        linearLayout3.addView(imageView2);
        TextView textView = new TextView(this.a.getApplicationContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        k.b(textView, strG, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_POPUP_AD_TITLE_TEXT_SIZE_DP), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_POPUP_AD_TITLE_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
        textView.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), com.igaworks.adpopcorn.cores.common.d.a(this.a, 4));
        textView.setGravity(3);
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(this.a.getApplicationContext());
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        k.b(textView2, strC, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_POPUP_AD_DESC_TEXT_SIZE_DP), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_POPUP_AD_DESC_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, false);
        textView2.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), 0);
        textView2.setGravity(3);
        linearLayout2.addView(textView2);
        LinearLayout linearLayout4 = new LinearLayout(this.a.getApplicationContext());
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(iA6, iA7);
        layoutParams6.topMargin = iA5;
        layoutParams6.gravity = 81;
        linearLayout4.setOrientation(0);
        linearLayout4.setGravity(1);
        linearLayout4.setBackgroundColor(Color.parseColor("#cc000000"));
        linearLayout4.setLayoutParams(layoutParams6);
        frameLayout.addView(linearLayout4);
        LinearLayout linearLayout5 = new LinearLayout(this.a.getApplicationContext());
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(iA8, iA9);
        layoutParams7.gravity = 17;
        linearLayout5.setOrientation(0);
        linearLayout5.setLayoutParams(layoutParams7);
        linearLayout5.setBackgroundDrawable(this.g);
        linearLayout5.setGravity(16);
        linearLayout5.setOnClickListener(new e());
        linearLayout4.addView(linearLayout5);
        ImageView imageView3 = new ImageView(this.a.getApplicationContext());
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 18), com.igaworks.adpopcorn.cores.common.d.a(this.a, 18));
        layoutParams8.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 15);
        layoutParams8.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 6);
        layoutParams8.gravity = 16;
        imageView3.setLayoutParams(layoutParams8);
        com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_tcpa_ic_download_circle.png", imageView3, false);
        imageView3.setColorFilter(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.LANDSCAPE_POPUP_AD_REWARD_CONDITION_ICON_COLOR), PorterDuff.Mode.MULTIPLY);
        linearLayout5.addView(imageView3);
        TextView textView3 = new TextView(this.a.getApplicationContext());
        textView3.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        k.b(textView3, strF, 12, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.LANDSCAPE_POPUP_AD_REWARD_CONDITION_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, false);
        textView3.setGravity(19);
        textView3.setIncludeFontPadding(false);
        linearLayout5.addView(textView3);
        TextView textView4 = new TextView(this.a.getApplicationContext());
        textView4.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        k.b(textView4, "+" + strH, 16, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_POPUP_AD_REWARD_BTN_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
        textView4.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 12), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 12), 0);
        textView4.setGravity(19);
        linearLayout5.addView(textView4);
        TextView textView5 = new TextView(this.a.getApplicationContext());
        textView5.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        k.b(textView5, this.d.r1, 12, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_POPUP_AD_REWARD_BTN_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
        textView5.setGravity(19);
        linearLayout5.addView(textView5);
        ImageView imageView4 = new ImageView(this.a.getApplicationContext());
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 18), com.igaworks.adpopcorn.cores.common.d.a(this.a, 18));
        layoutParams9.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 6);
        layoutParams9.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        layoutParams9.gravity = 16;
        imageView4.setLayoutParams(layoutParams9);
        com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_tcpa_ic_chevron_circle_fill_right.png", imageView4, true);
        linearLayout5.addView(imageView4);
        LinearLayout linearLayout6 = new LinearLayout(this.a.getApplicationContext());
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(iA4, iA10);
        layoutParams10.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 4);
        linearLayout6.setLayoutParams(layoutParams10);
        linearLayout6.setOrientation(0);
        linearLayout6.setGravity(21);
        linearLayout.addView(linearLayout6);
        this.k = new com.igaworks.adpopcorn.activity.c.c(this.a.getApplicationContext());
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 24), com.igaworks.adpopcorn.cores.common.d.a(this.a, 24));
        layoutParams11.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
        layoutParams11.gravity = 16;
        this.k.setLayoutParams(layoutParams11);
        this.k.setOnClickListener(new f());
        linearLayout6.addView(this.k);
        this.k.setSelected(false);
        TextView textView6 = new TextView(this.a.getApplicationContext());
        textView6.setLayoutParams(new LinearLayout.LayoutParams(-2, iA10));
        k.b(textView6, this.d.q1, 14, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, false);
        textView6.setGravity(17);
        textView6.setOnClickListener(new g());
        linearLayout6.addView(textView6);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.igaworks.adpopcorn.a.g.a aVar;
        String str;
        try {
            f();
            if (this.f1538b == null) {
                this.f1538b = new com.igaworks.adpopcorn.a.g.a(this.a);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", this.c.a());
            jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.a));
            jSONObject.put("channel_code", 4);
            if (com.igaworks.adpopcorn.a.d.E) {
                aVar = this.f1538b;
                str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/joincampaign";
            } else {
                aVar = this.f1538b;
                str = "https://apapi.adpopcorn.com/ap/v1/sdk/media/joincampaign";
            }
            aVar.a(1, str, jSONObject, this);
            Context context = this.a;
            if (context == null || this.c == null) {
                return;
            }
            com.igaworks.adpopcorn.a.d.a(context).b("click_popup_ad", this.c.b());
        } catch (Exception unused) {
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            a(gVar.p, gVar.e);
        }
    }

    private void f() {
        try {
            if (((Activity) this.a).isFinishing()) {
                return;
            }
            Context context = this.a;
            com.igaworks.adpopcorn.activity.b.d.c cVar = new com.igaworks.adpopcorn.activity.b.d.c(context, com.igaworks.adpopcorn.activity.b.d.a(context));
            this.i = cVar;
            cVar.setCancelable(false);
            this.i.show();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        if (com.igaworks.adpopcorn.a.b.a().a(this.a, "adpopcorn_sdk_flag", "use_flag_show_When_locked_sp", false)) {
            getWindow().addFlags(524288);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        float fC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_BG_OPACITY) / 100.0f;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = 2;
        layoutParams.dimAmount = fC;
        getWindow().setAttributes(layoutParams);
        this.d = com.igaworks.adpopcorn.cores.common.g.a();
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -16777216});
        this.e = gradientDrawable;
        gradientDrawable.setShape(0);
        this.e.setGradientType(0);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -872415232});
        this.f = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.f.setGradientType(0);
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_POPUP_AD_REWARD_BTN_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_POPUP_AD_REWARD_BTN_BG_COLOR)});
        this.g = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.g.setGradientType(0);
        this.g.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 2));
        setContentView(this.h ? d() : c());
    }

    @Override // com.igaworks.adpopcorn.a.g.a.d
    public void onNetResponseListener(int i, com.igaworks.adpopcorn.cores.model.f fVar) {
        if (i != 1) {
            return;
        }
        a(fVar);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        com.igaworks.adpopcorn.cores.common.i.a(getWindow().getDecorView());
    }
}
