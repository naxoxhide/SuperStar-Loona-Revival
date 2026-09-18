package com.igaworks.adpopcorn.activity.b;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.igaworks.adpopcorn.style.ApStyleManager;

/* JADX INFO: loaded from: classes2.dex */
public class b extends Dialog {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f1511b;
    private com.igaworks.adpopcorn.cores.model.g c;
    private boolean d;
    private boolean e;
    private View.OnClickListener f;
    private int g;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.b$b, reason: collision with other inner class name */
    class C0405b implements com.igaworks.adpopcorn.cores.common.e.b {
        final /* synthetic */ ImageView a;

        C0405b(b bVar, ImageView imageView) {
            this.a = imageView;
        }

        @Override // com.igaworks.adpopcorn.cores.common.e.b
        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                this.a.setImageBitmap(bitmap);
                this.a.setBackgroundColor(Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.OFFERWALL_THEME_COLOR)));
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    public b(Context context, int i, int i2, com.igaworks.adpopcorn.cores.model.g gVar, boolean z, boolean z2, int i3, View.OnClickListener onClickListener) {
        super(context, i);
        this.f1511b = context;
        this.c = gVar;
        this.e = z2;
        this.a = i2;
        this.g = i3;
        this.d = z;
        this.f = onClickListener;
    }

    private int a(int i) {
        return (int) ((((double) i) / 720.0d) * 376.0d);
    }

    private View a() {
        Context context;
        int i;
        int iA = a(this.a - com.igaworks.adpopcorn.cores.common.d.a(this.f1511b, 17));
        LinearLayout linearLayout = new LinearLayout(this.f1511b);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setGravity(49);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.f1511b, 6), 0, com.igaworks.adpopcorn.cores.common.d.a(this.f1511b, 6), 0);
        linearLayout.setOnClickListener(new a());
        View view = new View(this.f1511b);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.f1511b, 3));
        if (this.d) {
            context = this.f1511b;
            i = 9;
        } else {
            context = this.f1511b;
            i = 56;
        }
        layoutParams.topMargin = com.igaworks.adpopcorn.cores.common.d.a(context, i);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.OFFERWALL_THEME_COLOR)));
        linearLayout.addView(view);
        ImageView imageView = new ImageView(this.f1511b);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, iA));
        com.igaworks.adpopcorn.cores.common.e.a(this.f1511b, this.c.T(), imageView, 0, 0, new C0405b(this, imageView));
        imageView.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.f1511b, 3), 0, com.igaworks.adpopcorn.cores.common.d.a(this.f1511b, 3), 0);
        linearLayout.addView(imageView);
        imageView.setOnClickListener(this.f);
        FrameLayout frameLayout = new FrameLayout(this.f1511b);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        frameLayout.setBackgroundColor(Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.OFFERWALL_THEME_COLOR)));
        frameLayout.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.f1511b, 3), 0, com.igaworks.adpopcorn.cores.common.d.a(this.f1511b, 3), 0);
        frameLayout.setOnClickListener(this.f);
        com.igaworks.adpopcorn.activity.layout.a aVarA = com.igaworks.adpopcorn.activity.layout.a.a(this.f1511b, 0, 0, 0, this.e);
        aVarA.a((View) aVarA, this.f1511b, this.c, true, this.e, this.g);
        frameLayout.addView(aVarA);
        linearLayout.addView(frameLayout);
        ImageView imageView2 = new ImageView(this.f1511b);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.f1511b, 128), com.igaworks.adpopcorn.cores.common.d.a(this.f1511b, 128));
        layoutParams2.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1511b, 18);
        layoutParams2.gravity = 17;
        imageView2.setLayoutParams(layoutParams2);
        com.igaworks.adpopcorn.a.a.a(this.f1511b, "igaw_ap_ic_pick.png", imageView2, false);
        imageView2.setColorFilter(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_THEME_COLOR), PorterDuff.Mode.MULTIPLY);
        linearLayout.addView(imageView2);
        imageView2.setOnClickListener(new c());
        View view2 = new View(this.f1511b);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        view2.setOnClickListener(new d());
        linearLayout.addView(view2);
        ImageView imageView3 = new ImageView(this.f1511b);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.f1511b, 14), com.igaworks.adpopcorn.cores.common.d.a(this.f1511b, 14));
        layoutParams3.gravity = 85;
        layoutParams3.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1511b, 18);
        layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1511b, 18);
        imageView3.setLayoutParams(layoutParams3);
        com.igaworks.adpopcorn.a.a.a(this.f1511b, "igaw_ap_ic_close.png", imageView3, false);
        imageView3.setOnClickListener(new e());
        linearLayout.addView(imageView3);
        return linearLayout;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        if (com.igaworks.adpopcorn.a.b.a().a(this.f1511b, "adpopcorn_sdk_flag", "use_flag_show_When_locked_sp", false)) {
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
        setContentView(a());
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        com.igaworks.adpopcorn.cores.common.i.a(getWindow().getDecorView());
    }
}
