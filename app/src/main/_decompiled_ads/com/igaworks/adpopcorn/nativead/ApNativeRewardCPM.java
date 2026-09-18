package com.igaworks.adpopcorn.nativead;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.igaworks.adpopcorn.Adpopcorn;
import com.igaworks.adpopcorn.R;
import com.igaworks.adpopcorn.style.ApStyleManager;
import com.mbridge.msdk.MBridgeConstans;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ApNativeRewardCPM extends LinearLayout implements com.igaworks.adpopcorn.a.g.a.d {
    private WeakReference<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ApNativeRewardCPMEventListener f1626b;
    private List<com.igaworks.adpopcorn.cores.model.a> c;
    private com.igaworks.adpopcorn.cores.model.a d;
    private boolean e;
    private com.igaworks.adpopcorn.a.g.a f;
    private com.igaworks.adpopcorn.activity.b.d.a g;
    private com.igaworks.adpopcorn.activity.b.d.c h;
    private com.igaworks.adpopcorn.cores.common.g i;
    private ViewPager2 j;
    private com.igaworks.adpopcorn.nativead.a.c k;
    private TextView l;
    private TextView m;
    private List<ImageView> n;
    private GradientDrawable o;
    private GradientDrawable p;
    private LinearLayout q;
    private Handler r;
    private Runnable s;
    private int t;
    private int u;
    ViewTreeObserver.OnGlobalLayoutListener v;
    ViewTreeObserver.OnScrollChangedListener w;
    View.OnClickListener x;

    class a extends ViewPager2.OnPageChangeCallback {

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.nativead.ApNativeRewardCPM$a$a, reason: collision with other inner class name */
        class RunnableC0434a implements Runnable {
            final /* synthetic */ int a;

            RunnableC0434a(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView;
                GradientDrawable gradientDrawable;
                for (int i = 0; i < ApNativeRewardCPM.this.c.size(); i++) {
                    try {
                        if (this.a == i) {
                            imageView = (ImageView) ApNativeRewardCPM.this.n.get(i);
                            gradientDrawable = ApNativeRewardCPM.this.o;
                        } else {
                            imageView = (ImageView) ApNativeRewardCPM.this.n.get(i);
                            gradientDrawable = ApNativeRewardCPM.this.p;
                        }
                        imageView.setBackgroundDrawable(gradientDrawable);
                        ApNativeRewardCPM.this.invalidate();
                    } catch (Exception unused) {
                        return;
                    }
                }
            }
        }

        a() {
        }

        public void onPageSelected(int i) {
            com.igaworks.adpopcorn.cores.common.h.a((Context) ApNativeRewardCPM.this.a.get(), "ApNativeRewardCPM", "onPageSelected = " + i, 3);
            ApNativeRewardCPM.this.t = i;
            ApNativeRewardCPM.this.a(i);
            if (com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.NATIVE_RCPM_INDICATOR_TEXT_MODE)) {
                com.igaworks.adpopcorn.cores.common.k.b(ApNativeRewardCPM.this.l, (i + 1) + "", 12, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.NATIVE_RCPM_INDICATOR_CURRENT_PAGE_TEXT_COLOR), null, 0, 1, TextUtils.TruncateAt.END, false);
            } else {
                new Handler().post(new RunnableC0434a(i));
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApNativeRewardCPM.this.c(this.a * 1000);
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ApNativeRewardCPM.this.j != null) {
                ApNativeRewardCPM apNativeRewardCPM = ApNativeRewardCPM.this;
                apNativeRewardCPM.b(apNativeRewardCPM.j.getCurrentItem());
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApNativeRewardCPM.this.d();
        }
    }

    class e implements ViewTreeObserver.OnGlobalLayoutListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                if (ApNativeRewardCPM.this.e) {
                    return;
                }
                ApNativeRewardCPM.this.b();
            } catch (Exception unused) {
            }
        }
    }

    class f implements ViewTreeObserver.OnScrollChangedListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                if (ApNativeRewardCPM.this.e) {
                    return;
                }
                ApNativeRewardCPM.this.b();
            } catch (Exception unused) {
            }
        }
    }

    class g implements com.igaworks.adpopcorn.a.g.a.d {
        g(ApNativeRewardCPM apNativeRewardCPM) {
        }

        @Override // com.igaworks.adpopcorn.a.g.a.d
        public void onNetResponseListener(int i, com.igaworks.adpopcorn.cores.model.f fVar) {
        }
    }

    class h implements com.igaworks.adpopcorn.a.g.a.d {
        h(ApNativeRewardCPM apNativeRewardCPM) {
        }

        @Override // com.igaworks.adpopcorn.a.g.a.d
        public void onNetResponseListener(int i, com.igaworks.adpopcorn.cores.model.f fVar) {
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String strD = com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.NATIVE_RCPM_OFFERWALL_SHORTCUT_LANDING_URL);
            if (!com.igaworks.adpopcorn.cores.common.k.a(strD)) {
                Adpopcorn.openCPMOfferwall((Context) ApNativeRewardCPM.this.a.get());
                return;
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(strD));
                ((Context) ApNativeRewardCPM.this.a.get()).startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Adpopcorn.openCPMOfferwall((Context) ApNativeRewardCPM.this.a.get());
        }
    }

    class k implements ViewPager2.PageTransformer {
        final /* synthetic */ int a;

        k(ApNativeRewardCPM apNativeRewardCPM, int i) {
            this.a = i;
        }

        public void transformPage(View view, float f) {
            view.setTranslationX((-this.a) * f);
        }
    }

    class l extends ViewPager2.OnPageChangeCallback {
        l() {
        }

        public void onPageSelected(int i) {
            com.igaworks.adpopcorn.cores.common.h.a((Context) ApNativeRewardCPM.this.a.get(), "ApNativeRewardCPM", "onPageSelected = " + i, 3);
            ApNativeRewardCPM.this.t = i;
            ApNativeRewardCPM.this.a(i);
        }
    }

    public ApNativeRewardCPM(Context context) {
        super(context);
        this.e = false;
        this.n = new ArrayList();
        this.t = 0;
        this.u = -1;
        this.v = new e();
        this.w = new f();
        this.x = new c();
        this.a = new WeakReference<>(context);
        setOrientation(1);
        setBackgroundColor(Color.parseColor("#ffffff"));
    }

    public ApNativeRewardCPM(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = false;
        this.n = new ArrayList();
        this.t = 0;
        this.u = -1;
        this.v = new e();
        this.w = new f();
        this.x = new c();
        this.a = new WeakReference<>(context);
        setOrientation(1);
        setBackgroundColor(Color.parseColor("#ffffff"));
    }

    private void a() {
        Context context;
        String str;
        try {
            if (com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.NATIVE_RCPM_ENABLE_AUTO_ROLLING)) {
                int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.NATIVE_RCPM_AUTO_ROLLING_TRIGGER_TIME);
                if (iC > 0) {
                    com.igaworks.adpopcorn.cores.common.h.a(this.a.get(), "ApNativeRewardCPM", "Enable autoRolling : " + iC, 3);
                    if (this.r == null) {
                        this.r = new Handler(Looper.getMainLooper());
                    }
                    if (this.s == null) {
                        this.s = new b(iC);
                    }
                    this.r.removeCallbacks(this.s);
                    this.r.postDelayed(this.s, iC * 1000);
                    return;
                }
                context = this.a.get();
                str = "autoRolling time 0";
            } else {
                context = this.a.get();
                str = "Disable autoRolling";
            }
            com.igaworks.adpopcorn.cores.common.h.a(context, "ApNativeRewardCPM", str, 3);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        try {
            com.igaworks.adpopcorn.cores.common.h.a(this.a.get(), "ApNativeRewardCPM", "impression", 3);
            this.e = true;
            if (Build.VERSION.SDK_INT < 16) {
                getViewTreeObserver().removeGlobalOnLayoutListener(this.v);
            } else {
                getViewTreeObserver().removeOnGlobalLayoutListener(this.v);
            }
            getViewTreeObserver().removeOnScrollChangedListener(this.w);
            List<com.igaworks.adpopcorn.cores.model.a> list = this.c;
            if (list == null || list.get(i2) == null) {
                return;
            }
            com.igaworks.adpopcorn.cores.model.a aVar = this.c.get(i2);
            if (aVar.p()) {
                return;
            }
            aVar.d(true);
            ApNativeRewardCPMEventListener apNativeRewardCPMEventListener = this.f1626b;
            if (apNativeRewardCPMEventListener != null) {
                apNativeRewardCPMEventListener.onImpression();
            }
            if (this.f == null) {
                this.f = new com.igaworks.adpopcorn.a.g.a(this.a.get());
            }
            for (String str : aVar.j()) {
                this.f.a(14, str, "", new g(this));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(com.igaworks.adpopcorn.cores.model.f fVar) {
        String str;
        String str2;
        String str3;
        String str4;
        com.igaworks.adpopcorn.a.g.a aVar;
        String str5;
        if (fVar != null && fVar.d()) {
            e();
            com.igaworks.adpopcorn.cores.common.g gVar = this.i;
            str = gVar.p;
            str2 = gVar.e;
        } else {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    com.igaworks.adpopcorn.cores.common.h.a(this.a.get(), "ApNativeRewardCPM", "callbackCheckCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    int i2 = jSONObject.getInt("ResultCode");
                    if (!jSONObject.getBoolean("Result")) {
                        e();
                        if (i2 == 2000) {
                            com.igaworks.adpopcorn.cores.common.g gVar2 = this.i;
                            str3 = gVar2.Y;
                            str4 = gVar2.i;
                        } else {
                            com.igaworks.adpopcorn.cores.common.g gVar3 = this.i;
                            str3 = gVar3.p;
                            str4 = gVar3.x;
                        }
                        a(str3, str4);
                        return;
                    }
                    String string = jSONObject.getString("Auth");
                    if (this.a.get() != null) {
                        com.igaworks.adpopcorn.a.d.a(this.a.get()).b("media_offerwall_tab_content_engagement", this.d.c());
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("auth", string);
                    jSONObject2.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.a.get()));
                    jSONObject2.put("channel_code", 6);
                    if (com.igaworks.adpopcorn.a.d.E) {
                        aVar = this.f;
                        str5 = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/joincampaign";
                    } else {
                        aVar = this.f;
                        str5 = "https://apapi.adpopcorn.com/ap/v1/sdk/media/joincampaign";
                    }
                    aVar.a(1, str5, jSONObject2, this);
                    return;
                } catch (JSONException e2) {
                    e();
                    com.igaworks.adpopcorn.cores.common.g gVar4 = this.i;
                    a(gVar4.p, gVar4.e);
                    e2.printStackTrace();
                    return;
                }
            }
            e();
            com.igaworks.adpopcorn.cores.common.g gVar5 = this.i;
            str = gVar5.Y;
            str2 = gVar5.g;
        }
        a(str, str2);
    }

    private void a(String str) {
        com.igaworks.adpopcorn.a.g.a aVar;
        String str2;
        try {
            String strC = this.d.c();
            if (this.d == null) {
                com.igaworks.adpopcorn.cores.common.h.a(this.a.get(), "ApNativeRewardCPM", "completeCampaign failed", 3);
                return;
            }
            com.igaworks.adpopcorn.cores.common.h.a(this.a.get(), "ApNativeRewardCPM", "completeCampaign success", 3);
            if (this.f == null) {
                this.f = new com.igaworks.adpopcorn.a.g.a(this.a.get());
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", str);
            jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.a.get()));
            jSONObject.put("sign", com.igaworks.adpopcorn.cores.common.c.a(strC, str));
            if (com.igaworks.adpopcorn.a.d.E) {
                aVar = this.f;
                str2 = "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/CompleteCPMClick";
            } else {
                aVar = this.f;
                str2 = "https://apapi.adpopcorn.com/ap/v1/common/conversion/CompleteCPMClick";
            }
            aVar.a(28, str2, jSONObject, this);
        } catch (Exception e2) {
            com.igaworks.adpopcorn.cores.common.h.a(this.a.get(), "ApNativeRewardCPM", "completeCampaign failed : " + e2.getMessage(), 3);
            com.igaworks.adpopcorn.cores.common.g gVar = this.i;
            a(gVar.Y, gVar.e);
        }
    }

    private void a(String str, String str2) {
        e();
        d();
        try {
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(this.a.get(), com.igaworks.adpopcorn.activity.b.d.a(this.a.get()), str, str2, -1, this.i.h, new d(), a(this.a.get()), false);
            this.g = aVar;
            aVar.setCancelable(false);
            this.g.setCanceledOnTouchOutside(false);
            this.g.show();
        } catch (Exception unused) {
        }
    }

    private boolean a(Context context) {
        try {
            Configuration configuration = ((Activity) context).getResources().getConfiguration();
            return configuration != null && configuration.orientation == 2;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            if (com.igaworks.adpopcorn.cores.common.k.a(this)) {
                a(0);
            }
        } catch (Exception unused) {
            a(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        JSONObject jSONObject;
        int i3;
        com.igaworks.adpopcorn.a.g.a aVar;
        String str;
        try {
            List<com.igaworks.adpopcorn.cores.model.a> list = this.c;
            if (list == null || list.get(i2) == null) {
                com.igaworks.adpopcorn.cores.common.h.a(this.a.get(), "ApNativeRewardCPM", "JoinCampaign failed", 3);
                return;
            }
            com.igaworks.adpopcorn.cores.common.h.a(this.a.get(), "ApNativeRewardCPM", "JoinCampaign", 3);
            if (this.f == null) {
                this.f = new com.igaworks.adpopcorn.a.g.a(this.a.get());
            }
            com.igaworks.adpopcorn.cores.model.a aVar2 = this.c.get(i2);
            this.d = aVar2;
            if (aVar2.o() && this.d.k() != 16) {
                com.igaworks.adpopcorn.cores.common.h.a(this.a.get(), "ApNativeRewardCPM", "JoinCampaign already rewarded", 3);
                c();
                b(this.d.e());
                return;
            }
            if (this.d.n()) {
                h();
                jSONObject = new JSONObject();
                jSONObject.put("auth", this.d.a());
                jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.a.get()));
                i3 = 2;
                if (com.igaworks.adpopcorn.a.d.E) {
                    aVar = this.f;
                    str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/checkcampaign";
                } else {
                    aVar = this.f;
                    str = "https://apapi.adpopcorn.com/ap/v1/sdk/media/checkcampaign";
                }
            } else {
                h();
                jSONObject = new JSONObject();
                jSONObject.put(MBridgeConstans.APP_KEY, com.igaworks.adpopcorn.a.d.a(this.a.get()).e().b());
                jSONObject.put("adid", com.igaworks.adpopcorn.a.d.a(this.a.get()).e().a());
                jSONObject.put("usn", com.igaworks.adpopcorn.a.d.a(this.a.get()).e().g());
                jSONObject.put("integration_type_no", this.d.k());
                jSONObject.put("point", this.d.l());
                i3 = 27;
                if (com.igaworks.adpopcorn.a.d.E) {
                    aVar = this.f;
                    str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/joincpmcampaign";
                } else {
                    aVar = this.f;
                    str = "https://apapi.adpopcorn.com/ap/v1/sdk/media/joincpmcampaign";
                }
            }
            aVar.a(i3, str, jSONObject, this);
        } catch (Exception e2) {
            com.igaworks.adpopcorn.cores.common.h.a(this.a.get(), "ApNativeRewardCPM", "JoinCampaign failed : " + e2.getMessage(), 3);
            com.igaworks.adpopcorn.cores.common.g gVar = this.i;
            a(gVar.Y, gVar.e);
        }
    }

    private void b(com.igaworks.adpopcorn.cores.model.f fVar) {
        String str;
        String str2;
        com.igaworks.adpopcorn.cores.model.a aVar;
        String strE;
        e();
        if (fVar != null && fVar.d()) {
            com.igaworks.adpopcorn.cores.common.g gVar = this.i;
            str = gVar.p;
            str2 = gVar.e;
        } else {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    com.igaworks.adpopcorn.cores.common.h.a(this.a.get(), "ApNativeRewardCPM", "callbackJoinCPMCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z = jSONObject.getBoolean("Result");
                    String string = jSONObject.getString("CPMParticipatedTid");
                    if (!z) {
                        com.igaworks.adpopcorn.cores.common.g gVar2 = this.i;
                        a(gVar2.p, gVar2.e);
                        return;
                    }
                    c();
                    if (this.d.k() == 16) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(ScarConstants.TOKEN_ID_KEY, string);
                        String string2 = jSONObject2.toString();
                        try {
                            string2 = URLEncoder.encode(jSONObject2.toString(), "utf-8");
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        strE = this.d.e() + "&custom=" + string2;
                    } else {
                        if (this.d.k() == 40) {
                            if (this.d.o()) {
                                com.igaworks.adpopcorn.cores.common.h.a(this.a.get(), "ApNativeRewardCPM", "callbackJoinCPMCampaign already completed", 3);
                            } else {
                                a(jSONObject.getString("Auth"));
                            }
                            aVar = this.d;
                        } else {
                            aVar = this.d;
                        }
                        strE = aVar.e();
                    }
                    b(strE);
                    this.d.b(true);
                    this.k.a(this.c);
                    this.k.notifyItemChanged(this.t);
                    return;
                } catch (JSONException e3) {
                    com.igaworks.adpopcorn.cores.common.g gVar3 = this.i;
                    a(gVar3.p, gVar3.e);
                    e3.printStackTrace();
                    return;
                }
            }
            com.igaworks.adpopcorn.cores.common.g gVar4 = this.i;
            str = gVar4.Y;
            str2 = gVar4.g;
        }
        a(str, str2);
    }

    private void b(String str) {
        try {
            com.igaworks.adpopcorn.cores.common.h.a(this.a.get(), "ApNativeRewardCPM", "openWebBrowser = " + str, 3);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setData(Uri.parse(str));
            this.a.get().startActivity(intent);
        } catch (Exception unused) {
        }
    }

    private void c() {
        try {
            com.igaworks.adpopcorn.cores.common.h.a(this.a.get(), "ApNativeRewardCPM", "clickTracking", 3);
            ApNativeRewardCPMEventListener apNativeRewardCPMEventListener = this.f1626b;
            if (apNativeRewardCPMEventListener != null) {
                apNativeRewardCPMEventListener.onClicked();
            }
            if (this.d != null) {
                if (this.f == null) {
                    this.f = new com.igaworks.adpopcorn.a.g.a(this.a.get());
                }
                for (String str : this.d.d()) {
                    this.f.a(14, str, "", new h(this));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i2) {
        try {
            this.t++;
            List<com.igaworks.adpopcorn.cores.model.a> list = this.c;
            if (list == null || list.size() <= 1) {
                return;
            }
            if (this.t >= this.c.size()) {
                this.t = 0;
            }
            this.j.setCurrentItem(this.t);
            this.r.postDelayed(this.s, i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void c(com.igaworks.adpopcorn.cores.model.f fVar) {
        String str;
        String str2;
        if (fVar != null && fVar.d()) {
            e();
            com.igaworks.adpopcorn.cores.common.g gVar = this.i;
            str = gVar.p;
            str2 = gVar.e;
        } else {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    com.igaworks.adpopcorn.cores.common.h.a(this.a.get(), "ApNativeRewardCPM", "callbackJoinCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z = jSONObject.getBoolean("Result");
                    String string = jSONObject.getString("ResultMsg");
                    int i2 = jSONObject.getInt("ResultCode");
                    String string2 = (!jSONObject.has("RedirectURL") || jSONObject.isNull("RedirectURL")) ? "" : jSONObject.getString("RedirectURL");
                    if (!z) {
                        e();
                        if (i2 != 999 && i2 != 1000) {
                            a(this.i.q, string);
                            return;
                        }
                        com.igaworks.adpopcorn.cores.common.g gVar2 = this.i;
                        a(gVar2.q, gVar2.l0);
                        return;
                    }
                    c();
                    com.igaworks.adpopcorn.cores.common.h.a(this.a.get(), "ApNativeRewardCPM", "callbackJoinCampaign success, redirectURL = " + string2, 3);
                    e();
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setFlags(268435456);
                    intent.setData(Uri.parse(string2));
                    this.a.get().startActivity(intent);
                    this.d.b(true);
                    this.k.a(this.c);
                    this.k.notifyItemChanged(this.t);
                    return;
                } catch (Exception e2) {
                    e();
                    com.igaworks.adpopcorn.cores.common.g gVar3 = this.i;
                    a(gVar3.p, gVar3.e);
                    e2.printStackTrace();
                    return;
                }
            }
            e();
            com.igaworks.adpopcorn.cores.common.g gVar4 = this.i;
            str = gVar4.Y;
            str2 = gVar4.g;
        }
        a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.igaworks.adpopcorn.activity.b.d.a aVar = this.g;
        if (aVar == null || !aVar.isShowing()) {
            return;
        }
        this.g.dismiss();
        this.g = null;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0035  */
    private void d(com.igaworks.adpopcorn.cores.model.f fVar) {
        ApNativeRewardCPMError apNativeRewardCPMError;
        ApNativeRewardCPMEventListener apNativeRewardCPMEventListener;
        if (fVar == null) {
            if (fVar != null) {
                return;
            } else {
                return;
            }
        }
        try {
            if (fVar.d()) {
                com.igaworks.adpopcorn.cores.common.h.a(this.a.get(), "ApNativeRewardCPM", "callbackLoadNativeAd timeout", 3);
                if (this.f1626b == null) {
                    return;
                }
                apNativeRewardCPMError = new ApNativeRewardCPMError(5000, "Server Timeout");
                apNativeRewardCPMEventListener = this.f1626b;
            } else {
                if (fVar != null || fVar.a().length() <= 0) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(fVar.a());
                boolean z = jSONObject.has("Result") ? jSONObject.getBoolean("Result") : false;
                int i2 = jSONObject.has("ResultCode") ? jSONObject.getInt("ResultCode") : 0;
                String string = jSONObject.has("ResultMsg") ? jSONObject.getString("ResultMsg") : "";
                if (z) {
                    com.igaworks.adpopcorn.cores.common.h.a(this.a.get(), "ApNativeRewardCPM", "callbackLoadNativeAd success", 3);
                    List<com.igaworks.adpopcorn.cores.model.a> listA = com.igaworks.adpopcorn.a.f.a.a(fVar.a(), this.u);
                    this.c = listA;
                    if (listA != null) {
                        this.e = false;
                        g();
                        try {
                            getViewTreeObserver().addOnGlobalLayoutListener(this.v);
                            getViewTreeObserver().addOnScrollChangedListener(this.w);
                        } catch (Exception unused) {
                        }
                        ApNativeRewardCPMEventListener apNativeRewardCPMEventListener2 = this.f1626b;
                        if (apNativeRewardCPMEventListener2 != null) {
                            apNativeRewardCPMEventListener2.onNativeAdLoadSuccess();
                            return;
                        }
                        return;
                    }
                    com.igaworks.adpopcorn.cores.common.h.a(this.a.get(), "ApNativeRewardCPM", "callbackLoadNativeAd success, but no Ad", 3);
                    apNativeRewardCPMError = new ApNativeRewardCPMError(1000, "Can not find available campaign");
                    apNativeRewardCPMEventListener = this.f1626b;
                    if (apNativeRewardCPMEventListener == null) {
                        return;
                    }
                } else {
                    com.igaworks.adpopcorn.cores.common.h.a(this.a.get(), "ApNativeRewardCPM", "callbackLoadNativeAd fail", 3);
                    apNativeRewardCPMError = new ApNativeRewardCPMError(i2, string);
                    apNativeRewardCPMEventListener = this.f1626b;
                    if (apNativeRewardCPMEventListener == null) {
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.f1626b != null) {
                this.f1626b.onNativeAdLoadFailed(new ApNativeRewardCPMError(9999, ApNativeRewardCPMError.UNKNOWN_EXCEPTION_MESSAGE));
                return;
            }
            return;
        }
        apNativeRewardCPMEventListener.onNativeAdLoadFailed(apNativeRewardCPMError);
    }

    private void e() {
        com.igaworks.adpopcorn.activity.b.d.c cVar = this.h;
        if (cVar != null) {
            cVar.dismiss();
            this.h = null;
        }
    }

    private void f() {
        int iA;
        if (com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.NATIVE_RCPM_HIDDEN_INDICATOR_AREA)) {
            a();
            this.j.registerOnPageChangeCallback(new l());
            return;
        }
        LinearLayout linearLayout = this.q;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        List<ImageView> list = this.n;
        if (list != null) {
            list.clear();
        }
        List<com.igaworks.adpopcorn.cores.model.a> list2 = this.c;
        if (list2 == null || list2.size() <= 1) {
            return;
        }
        boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.NATIVE_RCPM_INDICATOR_TEXT_MODE);
        this.q = new LinearLayout(this.a.get());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.q.setLayoutParams(layoutParams);
        int i2 = 0;
        this.q.setOrientation(0);
        this.q.setGravity(17);
        addView(this.q);
        if (zB) {
            this.l = new TextView(this.a.get());
            this.l.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.l.setIncludeFontPadding(false);
            this.q.addView(this.l);
            this.m = new TextView(this.a.get());
            this.m.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.m.setIncludeFontPadding(false);
            this.q.addView(this.m);
            com.igaworks.adpopcorn.cores.common.k.b(this.l, "1", 12, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.NATIVE_RCPM_INDICATOR_CURRENT_PAGE_TEXT_COLOR), null, 0, 1, TextUtils.TruncateAt.END, false);
            com.igaworks.adpopcorn.cores.common.k.b(this.m, RemoteSettings.FORWARD_SLASH_STRING + this.c.size(), 12, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.NATIVE_RCPM_INDICATOR_TOTAL_PAGE_TEXT_COLOR), null, 0, 1, TextUtils.TruncateAt.END, false);
        } else {
            int iA2 = com.igaworks.adpopcorn.cores.common.d.a(this.a.get(), 8);
            List<com.igaworks.adpopcorn.cores.model.a> list3 = this.c;
            if (list3 != null && list3.size() > 0 && (iA = (com.igaworks.adpopcorn.cores.common.d.a(this.a.get(), 312) - (this.c.size() * com.igaworks.adpopcorn.cores.common.d.a(this.a.get(), 6))) / this.c.size()) < iA2) {
                iA2 = iA;
            }
            while (i2 < this.c.size()) {
                ImageView iVar = new com.igaworks.adpopcorn.activity.c.i(this.a.get(), com.igaworks.adpopcorn.cores.common.d.a(this.a.get(), 3));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a.get(), 6), com.igaworks.adpopcorn.cores.common.d.a(this.a.get(), 6));
                layoutParams2.rightMargin = iA2;
                iVar.setLayoutParams(layoutParams2);
                this.q.addView(iVar);
                iVar.setBackgroundDrawable(i2 == 0 ? this.o : this.p);
                this.n.add(iVar);
                i2++;
            }
        }
        this.j.registerOnPageChangeCallback(new a());
        a();
    }

    private void g() {
        if (this.k != null) {
            this.j.setCurrentItem(0);
            this.k.a(this.c);
            f();
            this.t = 0;
            this.k.notifyDataSetChanged();
            return;
        }
        com.igaworks.adpopcorn.cores.common.d.a((Activity) this.a.get());
        int iC = com.igaworks.adpopcorn.cores.common.d.c() - com.igaworks.adpopcorn.cores.common.d.a(this.a.get(), 48);
        if (!com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.NATIVE_RCPM_HIDDEN_TOP_AREA)) {
            LinearLayout linearLayout = new LinearLayout(this.a.get());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iC, com.igaworks.adpopcorn.cores.common.d.a(this.a.get(), 21));
            layoutParams.gravity = 17;
            layoutParams.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a.get(), 24);
            layoutParams.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a.get(), 12);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            addView(linearLayout);
            TextView textView = new TextView(this.a.get());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, 1.0f);
            layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a.get(), 8);
            textView.setLayoutParams(layoutParams2);
            textView.setGravity(83);
            linearLayout.addView(textView);
            com.igaworks.adpopcorn.cores.common.k.b(textView, com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.NATIVE_RCPM_NAME_TEXT), 18, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.NATIVE_RCPM_NAME_TEXT_COLOR), null, 0, 1, TextUtils.TruncateAt.END, true);
            if (com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.NATIVE_RCPM_ENABLE_OFFERWALL_SHORTCUT)) {
                TextView textView2 = new TextView(this.a.get());
                textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
                textView2.setGravity(85);
                textView2.setOnClickListener(new i());
                com.igaworks.adpopcorn.cores.common.k.b(textView2, com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.NATIVE_RCPM_OFFERWALL_SHORTCUT_TEXT), 14, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.NATIVE_RCPM_OFFERWALL_SHORTCUT_TEXT_COLOR), null, 0, 1, TextUtils.TruncateAt.END, false);
                linearLayout.addView(textView2);
                ImageView imageView = new ImageView(this.a.get());
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a.get(), 5), com.igaworks.adpopcorn.cores.common.d.a(this.a.get(), 8));
                layoutParams3.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a.get(), 6);
                layoutParams3.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a.get(), 5);
                layoutParams3.gravity = 80;
                imageView.setLayoutParams(layoutParams3);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setImageResource(R.drawable.igaw_ap_rcpm_vector);
                imageView.setColorFilter(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.NATIVE_RCPM_OFFERWALL_SHORTCUT_TEXT_COLOR), PorterDuff.Mode.SRC_ATOP);
                imageView.setOnClickListener(new j());
                linearLayout.addView(imageView);
            }
        }
        this.j = new ViewPager2(this.a.get());
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams4.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a.get(), 14);
        this.j.setLayoutParams(layoutParams4);
        com.igaworks.adpopcorn.nativead.a.c cVar = new com.igaworks.adpopcorn.nativead.a.c(this.a.get(), this.c, this.x);
        this.k = cVar;
        this.j.setAdapter(cVar);
        this.j.setOffscreenPageLimit(3);
        int iA = com.igaworks.adpopcorn.cores.common.d.a(this.a.get(), 12);
        int iA2 = com.igaworks.adpopcorn.cores.common.d.a(this.a.get(), 24);
        if (Build.VERSION.SDK_INT >= 11) {
            this.j.setPageTransformer(new k(this, iA + iA2));
            this.j.addItemDecoration(new com.igaworks.adpopcorn.nativead.a.a(com.igaworks.adpopcorn.cores.common.d.a(this.a.get(), 24)));
        }
        addView(this.j);
        f();
        this.t = 0;
    }

    private void h() {
        try {
            if (((Activity) this.a.get()).isFinishing()) {
                return;
            }
            com.igaworks.adpopcorn.activity.b.d.c cVar = new com.igaworks.adpopcorn.activity.b.d.c(this.a.get(), com.igaworks.adpopcorn.activity.b.d.a(this.a.get()));
            this.h = cVar;
            cVar.setCancelable(false);
            this.h.show();
        } catch (Exception unused) {
        }
    }

    public void destroy() {
        try {
            this.e = false;
            if (Build.VERSION.SDK_INT < 16) {
                getViewTreeObserver().removeGlobalOnLayoutListener(this.v);
            } else {
                getViewTreeObserver().removeOnGlobalLayoutListener(this.v);
            }
            getViewTreeObserver().removeOnScrollChangedListener(this.w);
        } catch (Exception unused) {
        }
    }

    public void loadAd() {
        com.igaworks.adpopcorn.a.g.a aVar;
        String str;
        try {
            if (this.o == null) {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.NATIVE_RCPM_INDICATOR_SELECTED_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.NATIVE_RCPM_INDICATOR_SELECTED_COLOR)});
                this.o = gradientDrawable;
                gradientDrawable.setShape(0);
                this.o.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a.get(), 3));
                this.o.setGradientType(0);
            }
            if (this.p == null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.NATIVE_RCPM_INDICATOR_UNSELECTED_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.NATIVE_RCPM_INDICATOR_UNSELECTED_COLOR)});
                this.p = gradientDrawable2;
                gradientDrawable2.setShape(0);
                this.p.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a.get(), 3));
                this.p.setGradientType(0);
            }
            com.igaworks.adpopcorn.cores.common.h.a(this.a.get(), "ApNativeRewardCPM", "Native View loadAd", 3);
            com.igaworks.adpopcorn.cores.common.g gVarA = com.igaworks.adpopcorn.cores.common.g.a();
            this.i = gVarA;
            gVarA.d();
            if (this.f == null) {
                this.f = new com.igaworks.adpopcorn.a.g.a(this.a.get());
            }
            if (com.igaworks.adpopcorn.a.d.E) {
                aVar = this.f;
                str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/nativerewardcpm";
            } else {
                aVar = this.f;
                str = "https://apapi.adpopcorn.com/ap/v1/sdk/media/nativerewardcpm";
            }
            aVar.a(26, str, this);
            if (this.a.get() != null) {
                com.igaworks.adpopcorn.a.d.a(this.a.get()).b("load_native_ad", "");
            }
        } catch (Exception unused) {
            ApNativeRewardCPMError apNativeRewardCPMError = new ApNativeRewardCPMError(9999, ApNativeRewardCPMError.UNKNOWN_EXCEPTION_MESSAGE);
            ApNativeRewardCPMEventListener apNativeRewardCPMEventListener = this.f1626b;
            if (apNativeRewardCPMEventListener != null) {
                apNativeRewardCPMEventListener.onNativeAdLoadFailed(apNativeRewardCPMError);
            }
        }
    }

    @Override // com.igaworks.adpopcorn.a.g.a.d
    public void onNetResponseListener(int i2, com.igaworks.adpopcorn.cores.model.f fVar) {
        try {
            if (i2 == 1) {
                c(fVar);
                return;
            }
            if (i2 == 2) {
                a(fVar);
            } else if (i2 == 26) {
                d(fVar);
            } else {
                if (i2 != 27) {
                    return;
                }
                b(fVar);
            }
        } catch (Exception unused) {
        }
    }

    public void setMaxCampaignCount(int i2) {
        if (i2 > 0) {
            this.u = i2;
        }
    }

    public void setNativeRewardEventListener(ApNativeRewardCPMEventListener apNativeRewardCPMEventListener) {
        this.f1626b = apNativeRewardCPMEventListener;
    }
}
