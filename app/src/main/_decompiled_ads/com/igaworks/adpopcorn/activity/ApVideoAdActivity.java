package com.igaworks.adpopcorn.activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.igaworks.adpopcorn.style.ApStyleManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ApVideoAdActivity extends Activity implements com.igaworks.adpopcorn.a.g.a.d {
    private com.igaworks.adpopcorn.a.g.a A;
    private int B;
    private GradientDrawable C;
    private GradientDrawable D;
    private com.igaworks.adpopcorn.a.d E;
    private int J;
    private int K;
    private ImageView M;
    private int O;
    private ProgressBar P;
    private TextView Q;
    private TextView R;
    private TextView S;
    private ImageView T;
    private LinearLayout W;
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f1501b;
    private com.igaworks.adpopcorn.activity.c.f c;
    private FrameLayout d;
    private TextView e;
    private ImageView f;
    private ImageView g;
    private boolean t;
    private Runnable u;
    private com.igaworks.adpopcorn.cores.common.g v;
    private boolean w;
    private boolean x;
    private com.igaworks.adpopcorn.activity.b.d.a y;
    private com.igaworks.adpopcorn.activity.b.d.c z;
    private String h = "";
    private String i = "";
    private String j = "";
    private String k = "";
    private String l = "";
    private String m = "";
    private String n = "";
    private String o = "";
    private String p = "";
    private String q = "";
    private String r = "";
    private int s = 1;
    private String F = "";
    private boolean G = false;
    private boolean H = false;
    private boolean I = false;
    private boolean L = false;
    private boolean N = false;
    private String U = "";
    private boolean V = false;
    private int X = -1;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApVideoAdActivity.this.b();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ApVideoAdActivity apVideoAdActivity;
            try {
                int currentPosition = ApVideoAdActivity.this.c.getCurrentPosition();
                int i = (ApVideoAdActivity.this.B - currentPosition) / 1000;
                int i2 = currentPosition / 1000;
                int i3 = ApVideoAdActivity.this.J - i2;
                if (ApVideoAdActivity.this.L) {
                    if (ApVideoAdActivity.this.e != null) {
                        if (i <= 0 || currentPosition <= 0) {
                            ApVideoAdActivity.this.e.setVisibility(8);
                        } else {
                            ApVideoAdActivity.this.e.setText(i + "");
                            ApVideoAdActivity.this.e.setVisibility(0);
                            ApVideoAdActivity.this.e.bringToFront();
                            ApVideoAdActivity.this.g.setVisibility(0);
                            ApVideoAdActivity.this.g.bringToFront();
                        }
                        ApVideoAdActivity.this.s();
                    }
                    if (ApVideoAdActivity.this.u != null && i > 0) {
                        ApVideoAdActivity.this.c.postDelayed(ApVideoAdActivity.this.u, 500L);
                    }
                } else {
                    if (ApVideoAdActivity.this.P != null && ApVideoAdActivity.this.c.getCurrentPosition() > 0) {
                        ApVideoAdActivity.this.P.setProgress(ApVideoAdActivity.this.c.getCurrentPosition());
                    }
                    if (ApVideoAdActivity.this.u != null && i > 0) {
                        ApVideoAdActivity.this.c.postDelayed(ApVideoAdActivity.this.u, 100L);
                    }
                }
                if (i3 <= 0) {
                    i3 = 0;
                }
                if (ApVideoAdActivity.this.J <= -1) {
                    ApVideoAdActivity.this.a(0);
                    return;
                }
                int i4 = 1;
                if (i2 >= ApVideoAdActivity.this.J) {
                    ApVideoAdActivity.this.V = true;
                    apVideoAdActivity = ApVideoAdActivity.this;
                    i4 = 2;
                } else {
                    ApVideoAdActivity.this.Q.setText(i3 + "");
                    apVideoAdActivity = ApVideoAdActivity.this;
                }
                apVideoAdActivity.a(i4);
            } catch (Exception unused) {
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApVideoAdActivity.this.c();
            ApVideoAdActivity.this.finish();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApVideoAdActivity.this.c();
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApVideoAdActivity.this.c();
            ApVideoAdActivity.this.finish();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApVideoAdActivity.this.c();
            ApVideoAdActivity.this.showProgressDialog(false);
            ApVideoAdActivity.this.p();
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApVideoAdActivity.this.c();
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApVideoAdActivity.this.c();
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApVideoAdActivity.this.c();
            ApVideoAdActivity.this.finish();
        }
    }

    class j implements com.igaworks.adpopcorn.cores.common.e.b {
        j() {
        }

        @Override // com.igaworks.adpopcorn.cores.common.e.b
        public void a(Bitmap bitmap) {
            ApVideoAdActivity.this.M.setImageBitmap(bitmap);
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApVideoAdActivity.this.onBackPressed();
        }
    }

    class l implements com.igaworks.adpopcorn.cores.common.e.b {
        final /* synthetic */ ImageView a;

        l(ApVideoAdActivity apVideoAdActivity, ImageView imageView) {
            this.a = imageView;
        }

        @Override // com.igaworks.adpopcorn.cores.common.e.b
        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApVideoAdActivity.this.onBackPressed();
        }
    }

    class n implements com.igaworks.adpopcorn.cores.common.e.b {
        n() {
        }

        @Override // com.igaworks.adpopcorn.cores.common.e.b
        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                ApVideoAdActivity.this.M.setImageBitmap(bitmap);
            }
        }
    }

    class o implements MediaPlayer.OnPreparedListener {
        o() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                ApVideoAdActivity.this.d();
                ApVideoAdActivity.this.a(0);
                if (ApVideoAdActivity.this.q != null && ApVideoAdActivity.this.q.length() > 0) {
                    ApVideoAdActivity.this.A.a(14, ApVideoAdActivity.this.q, "", ApVideoAdActivity.this);
                }
                ApVideoAdActivity apVideoAdActivity = ApVideoAdActivity.this;
                apVideoAdActivity.B = apVideoAdActivity.c.getDuration();
                ApVideoAdActivity.this.M.setVisibility(4);
                ApVideoAdActivity.this.c.start();
                ApVideoAdActivity.this.t();
                ApVideoAdActivity.this.H = true;
                if (ApVideoAdActivity.this.P != null) {
                    ApVideoAdActivity.this.P.setMax(ApVideoAdActivity.this.B);
                }
            } catch (Exception unused) {
            }
        }
    }

    class p implements MediaPlayer.OnCompletionListener {
        p() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                ApVideoAdActivity.this.c();
                ApVideoAdActivity.this.H = false;
                ApVideoAdActivity.this.a(3);
                if (ApVideoAdActivity.this.t) {
                    com.igaworks.adpopcorn.cores.common.h.a(ApVideoAdActivity.this.a, "ApVideoAdActivity", "onCompletion Already participated", 3);
                } else {
                    ApVideoAdActivity.this.I = false;
                    com.igaworks.adpopcorn.cores.common.h.a(ApVideoAdActivity.this.a, "ApVideoAdActivity", "onCompletion video ad type : " + ApVideoAdActivity.this.K, 3);
                    if (ApVideoAdActivity.this.K == 16) {
                        ApVideoAdActivity.this.showProgressDialog(false);
                        ApVideoAdActivity.this.p();
                    }
                }
                if (ApVideoAdActivity.this.N) {
                    ApVideoAdActivity.this.c.setVisibility(4);
                    ApVideoAdActivity.this.M.setVisibility(0);
                }
                if (ApVideoAdActivity.this.P != null) {
                    ApVideoAdActivity.this.P.setProgress(ApVideoAdActivity.this.B);
                }
            } catch (Exception unused) {
                ApVideoAdActivity.this.d();
            }
        }
    }

    class q implements MediaPlayer.OnErrorListener {
        q() {
        }

        /* JADX WARN: Code duplicated, block: B:19:0x007d  */
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            String str;
            com.igaworks.adpopcorn.cores.common.h.a(ApVideoAdActivity.this.a, "ApVideoAdActivity", "onError : what : " + i + ", extra : " + i2, 3);
            ApVideoAdActivity.this.d();
            if (ApVideoAdActivity.this.L && ApVideoAdActivity.this.e != null) {
                ApVideoAdActivity.this.e.setVisibility(8);
            }
            String str2 = ApVideoAdActivity.this.v.f0;
            if (i2 == -1004) {
                str = ApVideoAdActivity.this.v.h0;
            } else if (i2 == -1007) {
                str = ApVideoAdActivity.this.v.f0;
            } else if (i2 == -1010) {
                str = ApVideoAdActivity.this.v.i0;
            } else if (i2 == -110) {
                str = ApVideoAdActivity.this.v.g0;
            } else {
                str = ApVideoAdActivity.this.v.f0;
            }
            ApVideoAdActivity.this.a(str);
            return true;
        }
    }

    private void a() {
        try {
            c();
            com.igaworks.adpopcorn.cores.common.g gVar = this.v;
            String str = gVar.Y;
            String str2 = gVar.b0;
            String str3 = gVar.c0;
            String str4 = (this.K == 26 && this.X == 3) ? gVar.a0 : gVar.Z;
            Context context = this.a;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, com.igaworks.adpopcorn.activity.b.d.a(context), str, str4, -1, str2, new c(), str3, new d(), true);
            this.y = aVar;
            aVar.setCancelable(false);
            this.y.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        TextView textView;
        Context context;
        int i3;
        if (this.X == i2) {
            return;
        }
        if (i2 == 1) {
            this.W.setVisibility(0);
            this.W.bringToFront();
            this.W.setBackgroundColor(Color.parseColor("#00000000"));
            if (this.L) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                layoutParams.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 11);
                layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 35);
                this.S.setLayoutParams(layoutParams);
                this.S.setTextSize(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 20));
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
                layoutParams2.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 7);
                layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
                this.S.setLayoutParams(layoutParams2);
                this.S.setTextSize(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 13));
            }
            this.S.setTypeface(Typeface.SANS_SERIF, 0);
            this.Q.setVisibility(0);
            this.R.setVisibility(0);
            this.S.setVisibility(0);
            this.T.setVisibility(8);
        } else if (i2 == 2 || i2 == 3) {
            this.W.setVisibility(0);
            this.W.bringToFront();
            this.W.setBackgroundColor(Color.parseColor("#99000000"));
            if (this.L) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
                layoutParams3.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 34);
                i3 = 23;
                layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 23);
                this.S.setLayoutParams(layoutParams3);
                this.S.setTextColor(Color.parseColor("#ffe066"));
                textView = this.S;
                context = this.a;
            } else {
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -1);
                layoutParams4.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
                layoutParams4.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 14);
                this.S.setLayoutParams(layoutParams4);
                this.S.setTextColor(Color.parseColor("#ffe066"));
                textView = this.S;
                context = this.a;
                i3 = 15;
            }
            textView.setTextSize(0, com.igaworks.adpopcorn.cores.common.d.a(context, i3));
            this.S.setTypeface(Typeface.SANS_SERIF, 1);
            this.Q.setVisibility(8);
            this.R.setVisibility(8);
            this.S.setVisibility(0);
            this.T.setVisibility(0);
        } else {
            this.W.setVisibility(8);
        }
        this.X = i2;
    }

    private void a(com.igaworks.adpopcorn.cores.model.f fVar) {
        String str;
        d();
        if ((fVar != null && fVar.d()) || fVar == null || fVar.a().length() <= 0) {
            o();
            return;
        }
        try {
            com.igaworks.adpopcorn.cores.common.h.a(this.a, "ApVideoAdActivity", "callbackRewardRequest return = " + fVar.a(), 3);
            JSONObject jSONObject = new JSONObject(fVar.a());
            boolean z = jSONObject.getBoolean("Result");
            int i2 = jSONObject.getInt("ResultCode");
            String string = jSONObject.getString("ResultMsg");
            if (z) {
                this.t = true;
                String str2 = this.F;
                if (str2 != null && str2.length() > 0) {
                    new com.igaworks.adpopcorn.activity.c.b(this.a).a(String.format(this.v.s0, this.F), 1, 80);
                }
                if (this.I) {
                    com.igaworks.adpopcorn.cores.common.h.a(this.a, "ApVideoAdActivity", "callbackRewardRequest skipEnable redirectURL = " + this.n, 3);
                    a(this.n, true);
                    finish();
                    this.I = false;
                    return;
                }
                if (this.K == 26) {
                    com.igaworks.adpopcorn.cores.common.h.a(this.a, "ApVideoAdActivity", "callbackRewardRequest success, VIDEO_AD_CLICK_TYPE = " + this.n, 3);
                    str = this.n;
                    a(str, true);
                    finish();
                }
                return;
            }
            if (i2 != 2000) {
                if (i2 != 999 && i2 != 1000) {
                    this.t = true;
                    o();
                    return;
                }
                this.t = true;
                a(this.v.q, string);
                return;
            }
            this.t = true;
            try {
                new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.v.i, 1, 80);
            } catch (Exception unused) {
            }
            if (this.I) {
                com.igaworks.adpopcorn.cores.common.h.a(this.a, "ApVideoAdActivity", "callbackRewardRequest skipEnable redirectURL = " + this.n, 3);
                a(this.n, true);
                finish();
                this.I = false;
                return;
            }
            if (this.K == 26) {
                com.igaworks.adpopcorn.cores.common.h.a(this.a, "ApVideoAdActivity", "callbackRewardRequest Already Participate, VIDEO_AD_CLICK_TYPE = " + this.n, 3);
                str = this.n;
                a(str, true);
                finish();
            }
        } catch (Exception e2) {
            o();
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            c();
            com.igaworks.adpopcorn.cores.common.g gVar = this.v;
            String str2 = gVar.Y;
            String str3 = gVar.h;
            Context context = this.a;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, com.igaworks.adpopcorn.activity.b.d.a(context), str2, str, -1, str3, new e(), true, false);
            this.y = aVar;
            aVar.setCancelable(false);
            this.y.show();
        } catch (Exception unused) {
        }
    }

    private void a(String str, String str2) {
        try {
            c();
            String str3 = this.v.h;
            Context context = this.a;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, com.igaworks.adpopcorn.activity.b.d.a(context), str, str2, -1, str3, new h(), true, false);
            this.y = aVar;
            aVar.setCancelable(false);
            this.y.show();
        } catch (Exception unused) {
        }
    }

    private void a(String str, boolean z) {
        com.igaworks.adpopcorn.a.g.a aVar;
        String str2;
        String str3;
        try {
            String str4 = this.r;
            if (str4 != null && str4.length() > 0) {
                if (this.A == null) {
                    this.A = new com.igaworks.adpopcorn.a.g.a(this.a);
                }
                if (z) {
                    aVar = this.A;
                    str2 = this.r;
                    str3 = "&click_skip=true";
                } else {
                    aVar = this.A;
                    str2 = this.r;
                    str3 = "&click_skip=false";
                }
                aVar.a(14, str2, str3, this);
            }
            com.igaworks.adpopcorn.cores.common.h.a(this.a, "ApVideoAdActivity", "landingByBrowser url = " + str, 3);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(603979776);
            this.a.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    private boolean a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.igaworks.adpopcorn.activity.c.b bVar;
        String str;
        try {
            if (this.V && this.X != 3) {
                this.I = true;
                if (this.K == 27) {
                    com.igaworks.adpopcorn.cores.common.h.a(this.a, "ApVideoAdActivity", "clickLandingBtn VIDEO_AD_WEB_CPA_TYPE", 3);
                    a(this.n, false);
                    finish();
                }
                showProgressDialog(true);
                p();
                return;
            }
            if (this.X != 3) {
                if (this.J > -1) {
                    int currentPosition = this.J - (this.c.getCurrentPosition() / 1000);
                    if (currentPosition <= 0) {
                        currentPosition = 1;
                    }
                    bVar = new com.igaworks.adpopcorn.activity.c.b(this.a);
                    str = String.format(this.v.Y0, Integer.valueOf(currentPosition));
                } else {
                    bVar = new com.igaworks.adpopcorn.activity.c.b(this.a);
                    str = this.v.q0;
                }
                bVar.a(str, 1, 80);
                return;
            }
            int i2 = this.K;
            if (i2 == 16) {
                com.igaworks.adpopcorn.cores.common.h.a(this.a, "ApVideoAdActivity", "clickLandingBtn VIDEO_AD_VC_TYPE = " + this.n, 3);
            } else if (this.t) {
                com.igaworks.adpopcorn.cores.common.h.a(this.a, "ApVideoAdActivity", "clickLandingBtn VIDEO_AD_CLICK_TYPE = " + this.n, 3);
            } else {
                if (i2 != 27) {
                    com.igaworks.adpopcorn.cores.common.h.a(this.a, "ApVideoAdActivity", "clickLandingBtn VIDEO_AD_CLICK_TYPE sendRewardRequest", 3);
                    showProgressDialog(true);
                    p();
                    return;
                }
                com.igaworks.adpopcorn.cores.common.h.a(this.a, "ApVideoAdActivity", "clickLandingBtn VIDEO_AD_WEB_CPA_TYPE", 3);
            }
            a(this.n, false);
            finish();
        } catch (Exception unused) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.igaworks.adpopcorn.activity.b.d.a aVar = this.y;
        if (aVar != null && aVar.isShowing()) {
            this.y.dismiss();
        }
        this.y = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            com.igaworks.adpopcorn.activity.b.d.c cVar = this.z;
            if (cVar != null) {
                cVar.dismiss();
                this.z = null;
            }
        } catch (Exception unused) {
        }
    }

    private int e() {
        return (int) ((((double) this.O) / 720.0d) * 376.0d);
    }

    private int f() {
        return (int) ((((double) this.O) / 720.0d) * 405.0d);
    }

    private void g() {
        Context context;
        StringBuilder sbAppend;
        try {
            Intent intent = getIntent();
            this.i = intent.getStringExtra("cKey");
            this.j = intent.getStringExtra("joinAuth");
            this.o = intent.getStringExtra("landscapeImageURL");
            this.p = intent.getStringExtra("clickAction");
            this.m = intent.getStringExtra("iconImageURL");
            this.l = intent.getStringExtra("campaignName");
            this.n = intent.getStringExtra("redirectURL");
            this.h = intent.getStringExtra("videoURL");
            this.s = intent.getIntExtra("ADType", 1);
            this.G = intent.getBooleanExtra("fromVideoAPI", false);
            this.F = intent.getStringExtra("rewardName");
            this.J = intent.getIntExtra("skipAllowSeconds", -1);
            this.I = false;
            this.q = intent.getStringExtra("videoImpressionURL");
            this.r = intent.getStringExtra("moreClickReportURL");
            this.K = intent.getIntExtra("PartiTypeCode", 16);
            this.U = intent.getStringExtra("campaignCondition");
            String str = this.h;
            if (str == null || str.length() < 1) {
                this.w = true;
            } else if (Build.VERSION.SDK_INT < 14 && this.h.contains("https://")) {
                this.h = this.h.replace("https://", "http://");
            }
            String str2 = this.j;
            if (str2 == null || str2.length() < 1) {
                this.t = true;
            }
            if (this.A == null) {
                this.A = new com.igaworks.adpopcorn.a.g.a(this.a);
            }
            this.O = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay().getWidth();
            String str3 = this.U;
            if (str3 != null) {
                this.U = str3.replaceAll("\n", "<br>");
            }
            String str4 = this.o;
            if (str4 != null && str4.length() > 0 && !this.o.contentEquals("null")) {
                this.N = true;
            }
            int i2 = this.K;
            if (i2 == 16) {
                context = this.a;
                sbAppend = new StringBuilder().append("partiType : ").append(this.K).append(", VIDEO_AD_VC_TYPE");
            } else if (i2 == 26) {
                context = this.a;
                sbAppend = new StringBuilder().append("partiType : ").append(this.K).append(", VIDEO_AD_CLICK_TYPE");
            } else {
                context = this.a;
                sbAppend = new StringBuilder().append("partiType : ").append(this.K).append(", VIDEO_AD_WEB_CPA_TYPE");
            }
            com.igaworks.adpopcorn.cores.common.h.a(context, "ApVideoAdActivity", sbAppend.toString(), 3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void h() {
        this.d = new FrameLayout(this.f1501b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 48;
        this.d.setLayoutParams(layoutParams);
        this.d.setBackgroundResource(R.color.transparent);
        q();
        setContentView(this.d);
        l();
        showProgressDialog(true);
    }

    private void i() {
        this.d = new FrameLayout(this.f1501b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 48;
        this.d.setLayoutParams(layoutParams);
        this.d.setBackgroundResource(R.color.transparent);
        q();
        setContentView(this.d);
        m();
        showProgressDialog(true);
    }

    private void j() {
        try {
            if (!this.w) {
                if (a(this.a, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    String strA = com.igaworks.adpopcorn.cores.common.e.a(this.a, this.h, true);
                    if (strA != null) {
                        com.igaworks.adpopcorn.cores.common.h.a(this.a, "ApVideoAdActivity", "isLocalFileExist path : " + strA, 3);
                        this.c.setVideoPath(strA);
                    } else {
                        com.igaworks.adpopcorn.cores.common.h.a(this.a, "ApVideoAdActivity", "isLocalFileExist : FALSE", 3);
                        this.c.setVideoURI(Uri.parse(this.h));
                        com.igaworks.adpopcorn.cores.common.e.a(this.a, this.h);
                    }
                } else {
                    com.igaworks.adpopcorn.cores.common.h.a(this.a, "ApVideoAdActivity", "checkPermission : FALSE", 3);
                    this.c.setVideoURI(Uri.parse(this.h));
                }
            }
        } catch (Exception unused) {
        }
    }

    private void k() {
        ImageView imageView = new ImageView(this.f1501b);
        this.M = imageView;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.M.setScaleType(ImageView.ScaleType.FIT_START);
        this.M.setBackgroundColor(-16777216);
        this.M.setVisibility(4);
        if (this.N) {
            com.igaworks.adpopcorn.cores.common.e.a(this.a, this.o, this.M, 0, 0, new j());
        }
        this.d.addView(this.M);
        LinearLayout linearLayout = new LinearLayout(this.f1501b);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 5), com.igaworks.adpopcorn.cores.common.d.a(this.a, 5), com.igaworks.adpopcorn.cores.common.d.a(this.a, 8), com.igaworks.adpopcorn.cores.common.d.a(this.a, 5));
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(0);
        TextView textView = new TextView(this.f1501b);
        textView.setLayoutParams(new LinearLayout.LayoutParams(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 22), 1.0f));
        this.f = new ImageView(this.f1501b);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 22), com.igaworks.adpopcorn.cores.common.d.a(this.a, 22));
        layoutParams2.gravity = 16;
        this.f.setLayoutParams(layoutParams2);
        com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_close_video.png", this.f, false);
        this.f.setOnClickListener(new k());
        linearLayout.addView(textView);
        linearLayout.addView(this.f);
        this.d.addView(linearLayout);
    }

    private void l() {
        com.igaworks.adpopcorn.activity.c.f fVar = new com.igaworks.adpopcorn.activity.c.f(this.a, null);
        this.c = fVar;
        fVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.d.addView(this.c);
        TextView textView = new TextView(this.f1501b);
        this.e = textView;
        textView.setTextColor(-1);
        this.e.setGravity(17);
        this.e.setBackgroundDrawable(this.D);
        this.e.setTextSize(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 12));
        this.e.setVisibility(4);
        ImageView imageView = new ImageView(this.f1501b);
        this.g = imageView;
        com.igaworks.adpopcorn.a.a.a(this.f1501b, "igaw_ap_logo_adpopcorn_video.png", imageView, false);
        this.d.addView(this.e);
        this.d.addView(this.g);
        n();
        s();
        k();
        r();
    }

    private void m() {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 50));
        layoutParams.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 9);
        layoutParams.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setGravity(17);
        linearLayout.addView(linearLayout2);
        ImageView imageView = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 50), com.igaworks.adpopcorn.cores.common.d.a(this.a, 50));
        layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 13);
        imageView.setLayoutParams(layoutParams2);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = this.m;
        if (str != null && str.length() > 0) {
            Context context = this.a;
            com.igaworks.adpopcorn.cores.common.e.a(context, this.m, imageView, com.igaworks.adpopcorn.cores.common.d.a(context, 50), com.igaworks.adpopcorn.cores.common.d.a(this.a, 50), new l(this, imageView));
        }
        linearLayout2.addView(imageView);
        LinearLayout linearLayout3 = new LinearLayout(this.a);
        linearLayout3.setOrientation(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 50), 1.0f);
        layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, (int) r15);
        linearLayout3.setLayoutParams(layoutParams3);
        linearLayout3.setGravity(17);
        TextView textView = new TextView(this.a);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        textView.setText(this.l);
        textView.setSingleLine();
        textView.setTextSize(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 16));
        textView.setTypeface(Typeface.SANS_SERIF, 1);
        textView.setGravity(16);
        textView.setTextColor(Color.parseColor("#ffffff"));
        linearLayout3.addView(textView);
        linearLayout2.addView(linearLayout3);
        ImageView imageView2 = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 25), com.igaworks.adpopcorn.cores.common.d.a(this.a, 25));
        layoutParams4.gravity = 17;
        imageView2.setLayoutParams(layoutParams4);
        com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_close.png", imageView2, false);
        imageView2.setColorFilter(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_THEME_COLOR), PorterDuff.Mode.MULTIPLY);
        imageView2.setOnClickListener(new m());
        linearLayout2.addView(imageView2);
        com.igaworks.adpopcorn.activity.c.f fVar = new com.igaworks.adpopcorn.activity.c.f(this.f1501b, this.O, f());
        this.c = fVar;
        fVar.setLayoutParams(new FrameLayout.LayoutParams(this.O, f()));
        r();
        linearLayout.addView(this.c);
        this.P = new ProgressBar(this.a, null, R.attr.progressBarStyleHorizontal);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 5));
        layoutParams5.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 9);
        this.P.setLayoutParams(layoutParams5);
        this.P.setBackgroundColor(-1);
        this.P.setProgressDrawable(buildRatingBarDrawables());
        this.P.setProgress(0);
        linearLayout.addView(this.P);
        TextView textView2 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams6.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, (int) r15);
        textView2.setLayoutParams(layoutParams6);
        textView2.setGravity(16);
        textView2.setTextSize(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 14));
        textView2.setTypeface(Typeface.SANS_SERIF, 0);
        try {
            String str2 = this.U;
            if (str2 != null) {
                textView2.setText(Html.fromHtml(str2));
            }
        } catch (Exception unused) {
        }
        linearLayout.addView(textView2);
        TextView textView3 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams7.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 5);
        layoutParams7.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams7.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, (int) r15);
        textView3.setLayoutParams(layoutParams7);
        textView3.setTextColor(Color.parseColor("#ffffff"));
        textView3.setGravity(16);
        textView3.setTextSize(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 13));
        textView3.setTypeface(Typeface.SANS_SERIF, 0);
        textView3.setText(this.v.p0);
        linearLayout.addView(textView3);
        this.d.addView(linearLayout);
        this.M = new ImageView(this.a);
        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(this.O, e());
        layoutParams8.gravity = 48;
        layoutParams8.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 50) + com.igaworks.adpopcorn.cores.common.d.a(this.a, 29);
        this.M.setLayoutParams(layoutParams8);
        this.M.setScaleType(ImageView.ScaleType.FIT_START);
        this.M.setBackgroundColor(-16777216);
        this.M.setVisibility(4);
        if (this.N) {
            Context context2 = this.a;
            com.igaworks.adpopcorn.cores.common.e.a(context2, this.o, this.M, com.igaworks.adpopcorn.cores.common.d.a(context2, 50), com.igaworks.adpopcorn.cores.common.d.a(this.a, 50), new n());
        }
        this.d.addView(this.M);
        n();
    }

    private void n() {
        FrameLayout.LayoutParams layoutParams;
        int i2;
        TextView textView;
        Context context;
        int i3;
        TextView textView2;
        int iA;
        TextView textView3;
        int iA2;
        TextView textView4;
        String str;
        LinearLayout.LayoutParams layoutParams2;
        int iA3;
        LinearLayout linearLayout = new LinearLayout(this.a);
        this.W = linearLayout;
        linearLayout.setOrientation(0);
        this.W.setGravity(16);
        if (this.L) {
            layoutParams = new FrameLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 70));
            layoutParams.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 35);
            i2 = 85;
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 42));
            layoutParams.topMargin = (com.igaworks.adpopcorn.cores.common.d.a(this.a, 50) + f()) - com.igaworks.adpopcorn.cores.common.d.a(this.a, 27);
            i2 = 5;
        }
        layoutParams.gravity = i2;
        this.W.setLayoutParams(layoutParams);
        this.W.setOnClickListener(new a());
        TextView textView5 = new TextView(this.a);
        this.Q = textView5;
        textView5.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.Q.setTextColor(Color.parseColor("#ffe066"));
        this.Q.setGravity(16);
        if (this.L) {
            textView = this.Q;
            context = this.a;
            i3 = 25;
        } else {
            textView = this.Q;
            context = this.a;
            i3 = 18;
        }
        textView.setTextSize(0, com.igaworks.adpopcorn.cores.common.d.a(context, i3));
        this.Q.setTypeface(Typeface.SANS_SERIF, 1);
        this.Q.setGravity(16);
        this.Q.setIncludeFontPadding(false);
        this.Q.setSingleLine();
        if (this.J > -1) {
            this.Q.setText(this.J + "");
        }
        TextView textView6 = new TextView(this.a);
        this.R = textView6;
        textView6.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.R.setTextColor(Color.parseColor("#ffffff"));
        this.R.setGravity(16);
        if (this.L) {
            textView2 = this.R;
            iA = com.igaworks.adpopcorn.cores.common.d.a(this.a, 23);
        } else {
            textView2 = this.R;
            iA = com.igaworks.adpopcorn.cores.common.d.a(this.a, 15);
        }
        textView2.setTextSize(0, iA);
        this.R.setTypeface(Typeface.SANS_SERIF, 1);
        this.R.setGravity(16);
        this.R.setSingleLine();
        this.R.setTextColor(Color.parseColor("#ffffff"));
        this.R.setIncludeFontPadding(false);
        this.R.setText(this.v.r0);
        this.S = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams3.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 7);
        layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        this.S.setLayoutParams(layoutParams3);
        this.S.setTextColor(Color.parseColor("#999999"));
        this.S.setGravity(16);
        this.S.setSingleLine();
        this.S.setIncludeFontPadding(false);
        if (this.L) {
            textView3 = this.S;
            iA2 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        } else {
            textView3 = this.S;
            iA2 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 13);
        }
        textView3.setTextSize(0, iA2);
        this.S.setTypeface(Typeface.SANS_SERIF, 0);
        if (this.s == 1) {
            textView4 = this.S;
            str = this.v.j0;
        } else {
            textView4 = this.S;
            str = this.v.k0;
        }
        textView4.setText(str);
        String str2 = this.p;
        if (str2 != null && str2.length() > 0) {
            this.S.setText(this.p);
        }
        this.T = new ImageView(this.a);
        if (this.L) {
            layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 12), com.igaworks.adpopcorn.cores.common.d.a(this.a, 22));
            com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_btn_clamp_big.png", this.T, false);
            iA3 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 38);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 9), com.igaworks.adpopcorn.cores.common.d.a(this.a, 15));
            com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_btn_clamp.png", this.T, false);
            iA3 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        }
        layoutParams2.rightMargin = iA3;
        layoutParams2.gravity = 17;
        this.T.setLayoutParams(layoutParams2);
        this.W.addView(this.Q);
        this.W.addView(this.R);
        this.W.addView(this.S);
        this.W.addView(this.T);
        this.d.addView(this.W);
        this.W.setVisibility(4);
    }

    private void o() {
        try {
            c();
            com.igaworks.adpopcorn.cores.common.g gVar = this.v;
            String str = gVar.q;
            String str2 = gVar.e0;
            String str3 = gVar.u;
            String str4 = gVar.z;
            Context context = this.a;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, com.igaworks.adpopcorn.activity.b.d.a(context), str, str2, -1, str3, new f(), str4, new g(), true);
            this.y = aVar;
            aVar.setCancelable(false);
            this.y.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", this.j);
            jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.a));
            jSONObject.put("sign", com.igaworks.adpopcorn.cores.common.c.a(this.i, this.j));
            this.A.a(12, this.k, jSONObject, this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void q() {
        if (!this.L) {
            setRequestedOrientation(1);
            return;
        }
        getWindow().setFlags(1024, 1024);
        try {
            if (!com.igaworks.adpopcorn.a.b.a().a(this.a, "adpopcorn_sdk_flag", "landscape_sensor", true) || Build.VERSION.SDK_INT < 9) {
                setRequestedOrientation(0);
            } else {
                setRequestedOrientation(6);
            }
        } catch (Exception unused) {
            setRequestedOrientation(0);
        }
    }

    private void r() {
        this.c.setOnPreparedListener(new o());
        this.c.setOnCompletionListener(new p());
        this.c.setOnErrorListener(new q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 22), com.igaworks.adpopcorn.cores.common.d.a(this.a, 22));
        layoutParams.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
        layoutParams.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 5);
        layoutParams.gravity = 83;
        this.e.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 64), com.igaworks.adpopcorn.cores.common.d.a(this.a, 22));
        layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
        layoutParams2.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 5);
        layoutParams2.gravity = 85;
        this.g.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.u != null) {
            this.u = null;
        }
        b bVar = new b();
        this.u = bVar;
        bVar.run();
    }

    public Drawable buildRatingBarDrawables() {
        int[] iArr = {R.id.background, R.id.secondaryProgress, R.id.progress};
        Drawable[] drawableArr = new Drawable[3];
        for (int i2 = 0; i2 < 3; i2++) {
            if (i2 == 0) {
                ShapeDrawable shapeDrawable = new ShapeDrawable();
                shapeDrawable.getPaint().setColor(-1);
                drawableArr[i2] = new ClipDrawable(shapeDrawable, 3, 1);
            } else if (i2 == 1) {
                ShapeDrawable shapeDrawable2 = new ShapeDrawable();
                shapeDrawable2.getPaint().setColor(-1);
                drawableArr[i2] = new ClipDrawable(shapeDrawable2, 3, 1);
            } else if (i2 == 2) {
                ShapeDrawable shapeDrawable3 = new ShapeDrawable();
                shapeDrawable3.getPaint().setColor(Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.OFFERWALL_THEME_COLOR)));
                drawableArr[i2] = new ClipDrawable(shapeDrawable3, 3, 1);
            }
        }
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        for (int i3 = 0; i3 < 3; i3++) {
            layerDrawable.setId(i3, iArr[i3]);
        }
        return layerDrawable;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.X == 3 && this.K == 16 && this.t) {
            finish();
        } else {
            a();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTheme(R.style.Theme.Translucent.NoTitleBar);
        super.onCreate(bundle);
        this.a = this;
        this.f1501b = getApplicationContext();
        this.x = false;
        this.H = false;
        this.V = false;
        this.N = false;
        this.L = com.igaworks.adpopcorn.a.d.a(this.a).c((Activity) this);
        com.igaworks.adpopcorn.cores.common.h.a(this.a, "ApVideoAdActivity", "landscapeMode : " + this.L, 3);
        if (bundle != null) {
            this.x = bundle.getBoolean("app_restart", false);
        }
        if (com.igaworks.adpopcorn.a.b.a().a(this.a, "adpopcorn_sdk_flag", "use_flag_show_When_locked_sp", false)) {
            getWindow().addFlags(524288);
        }
        com.igaworks.adpopcorn.cores.common.g gVarA = com.igaworks.adpopcorn.cores.common.g.a();
        this.v = gVarA;
        gVarA.d();
        this.w = false;
        this.E = com.igaworks.adpopcorn.a.d.a(this.a);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 0});
        this.C = gradientDrawable;
        gradientDrawable.setShape(0);
        this.C.setCornerRadius(8.0f);
        this.C.setGradientType(0);
        this.C.setStroke(2, Color.parseColor("#ffffffff"));
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{1711276032, 1711276032});
        this.D = gradientDrawable2;
        gradientDrawable2.setShape(1);
        this.D.setGradientType(0);
        this.D.setStroke(3, Color.parseColor("#ffffffff"));
        com.igaworks.adpopcorn.cores.common.d.a(this);
        this.k = com.igaworks.adpopcorn.a.d.E ? "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/completerewardvideocampaign" : "https://apapi.adpopcorn.com/ap/v1/common/conversion/completerewardvideocampaign";
        g();
        if (this.L) {
            h();
        } else {
            i();
        }
        j();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.igaworks.adpopcorn.a.d dVar;
        super.onDestroy();
        c();
        com.igaworks.adpopcorn.activity.c.f fVar = this.c;
        if (fVar != null) {
            fVar.stopPlayback();
            this.c = null;
        }
        FrameLayout frameLayout = this.d;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.d.removeAllViewsInLayout();
        }
        if (!this.G || (dVar = this.E) == null) {
            return;
        }
        dVar.a();
    }

    @Override // com.igaworks.adpopcorn.a.g.a.d
    public void onNetResponseListener(int i2, com.igaworks.adpopcorn.cores.model.f fVar) {
        if (i2 != 12) {
            return;
        }
        a(fVar);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        try {
            c();
            com.igaworks.adpopcorn.activity.c.f fVar = this.c;
            if (fVar != null) {
                fVar.pause();
            }
            TextView textView = this.e;
            if (textView != null) {
                textView.removeCallbacks(this.u);
            }
            if (this.u != null) {
                this.u = null;
            }
            this.E.d();
            overridePendingTransition(0, 0);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        com.igaworks.adpopcorn.activity.c.f fVar;
        super.onResume();
        try {
            if (this.x) {
                finish();
                return;
            }
            if (this.w) {
                c();
                com.igaworks.adpopcorn.cores.common.g gVar = this.v;
                String str = gVar.Y;
                String str2 = gVar.w;
                String str3 = gVar.h;
                Context context = this.a;
                com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, com.igaworks.adpopcorn.activity.b.d.a(context), str, str2, -1, str3, new i(), true, false);
                this.y = aVar;
                aVar.setCancelable(false);
                this.y.show();
            }
            if (!this.H || (fVar = this.c) == null) {
                return;
            }
            this.B = fVar.getDuration();
            this.c.start();
            t();
            this.H = true;
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("app_restart", true);
    }

    public void showProgressDialog(boolean z) {
        try {
            d();
            if (((Activity) this.a).isFinishing()) {
                return;
            }
            Context context = this.a;
            com.igaworks.adpopcorn.activity.b.d.c cVar = new com.igaworks.adpopcorn.activity.b.d.c(context, com.igaworks.adpopcorn.activity.b.d.a(context));
            this.z = cVar;
            cVar.setCancelable(z);
            this.z.show();
        } catch (Exception unused) {
        }
    }
}
