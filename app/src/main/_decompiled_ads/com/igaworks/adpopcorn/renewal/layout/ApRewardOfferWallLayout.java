package com.igaworks.adpopcorn.renewal.layout;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import androidx.core.view.PointerIconCompat;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.igaworks.adpopcorn.R;
import com.igaworks.adpopcorn.activity.ApVideoAdActivity;
import com.igaworks.adpopcorn.renewal.ApRewardStyle;
import com.igaworks.adpopcorn.style.APOfferwallTabInfo;
import com.igaworks.adpopcorn.style.ApStyleManager;
import com.kbeanie.imagechooser.api.ChooserType;
import com.mbridge.msdk.MBridgeConstans;
import com.tapjoy.TapjoyConstants;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ApRewardOfferWallLayout extends FrameLayout implements com.igaworks.adpopcorn.a.g.a.d {
    private String A;
    private LinearLayout A0;
    private String B;
    private HorizontalScrollView B0;
    private String C;
    private HorizontalScrollView C0;
    private String D;
    private TextView D0;
    private String E;
    private List<TextView> E0;
    private Handler F;
    private List<TextView> F0;
    private Runnable G;
    private List<TextView> G0;
    private int H;
    private List<TextView> H0;
    private int I;
    private List<ImageView> I0;
    private boolean J;
    private List<ImageView> J0;
    private String K;
    private int K0;
    private String L;
    private int L0;
    private String M;
    private boolean M0;
    private String N;
    private long N0;
    private String O;
    private String O0;
    private boolean P;
    private IViewTypeEventListener P0;
    private com.igaworks.adpopcorn.cores.model.g Q;
    private APOfferwallTabInfo Q0;
    private Dialog R;
    private List<com.igaworks.adpopcorn.cores.model.i> R0;
    private Dialog S;
    private int S0;
    private com.igaworks.adpopcorn.activity.b.g T;
    private int T0;
    private HashMap<String, String> U;
    private int U0;
    private com.igaworks.adpopcorn.a.g.a V;
    private LinearLayout V0;
    private boolean W;
    private List<String> W0;
    private int X0;
    private int Y0;
    private int Z0;
    private int a;
    private boolean a0;
    private int a1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f1656b;
    private boolean b0;
    private int b1;
    private Context c;
    private int c0;
    private int c1;
    private com.igaworks.adpopcorn.cores.common.g d;
    private int d0;
    private boolean d1;
    private com.igaworks.adpopcorn.a.c e;
    private LinearLayout e0;
    View.OnClickListener e1;
    private FrameLayout f;
    private com.igaworks.adpopcorn.renewal.b.c f0;
    AdapterView.OnItemClickListener f1;
    private LinearLayout g;
    private com.igaworks.adpopcorn.renewal.layout.c g0;
    AbsListView.OnScrollListener g1;
    private TextView h;
    private LinearLayout h0;
    private TextView i;
    private ViewFlipper i0;
    private com.igaworks.adpopcorn.renewal.a.a j;
    private TextView j0;
    private com.igaworks.adpopcorn.activity.c.e k;
    private boolean k0;
    private com.igaworks.adpopcorn.activity.c.e l;
    private boolean l0;
    private List<com.igaworks.adpopcorn.cores.model.g> m;
    private Dialog m0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> n;
    private com.igaworks.adpopcorn.renewal.b.d.c n0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> o;
    private int o0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> p;
    private boolean p0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> q;
    private boolean q0;
    private com.igaworks.adpopcorn.cores.model.g r;
    private Activity r0;
    private com.igaworks.adpopcorn.cores.model.g s;
    private boolean s0;
    private int t;
    private WebView t0;
    private com.igaworks.adpopcorn.renewal.layout.a u;
    private ArrayList<String> u0;
    private boolean v;
    private ArrayList<String> v0;
    private com.igaworks.adpopcorn.activity.c.i w;
    private int w0;
    private com.igaworks.adpopcorn.a.d x;
    private LinearLayout x0;
    private String y;
    private LinearLayout y0;
    private String z;
    private LinearLayout z0;

    public interface IViewTypeEventListener {
        void OnLoadedOfferWallPage();
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (ApRewardOfferWallLayout.this.R == null || !ApRewardOfferWallLayout.this.R.isShowing()) {
                    ((Integer) view.getTag()).intValue();
                    if (!com.igaworks.adpopcorn.cores.common.c.c(ApRewardOfferWallLayout.this.f1656b)) {
                        ApRewardOfferWallLayout apRewardOfferWallLayout = ApRewardOfferWallLayout.this;
                        apRewardOfferWallLayout.b(apRewardOfferWallLayout.d.g, ApRewardOfferWallLayout.this.d.h, false);
                        return;
                    }
                    ApRewardOfferWallLayout apRewardOfferWallLayout2 = ApRewardOfferWallLayout.this;
                    apRewardOfferWallLayout2.Q = apRewardOfferWallLayout2.r;
                    ApRewardOfferWallLayout apRewardOfferWallLayout3 = ApRewardOfferWallLayout.this;
                    apRewardOfferWallLayout3.I = apRewardOfferWallLayout3.Q.K();
                    ApRewardOfferWallLayout apRewardOfferWallLayout4 = ApRewardOfferWallLayout.this;
                    apRewardOfferWallLayout4.L = apRewardOfferWallLayout4.Q.a();
                    ApRewardOfferWallLayout apRewardOfferWallLayout5 = ApRewardOfferWallLayout.this;
                    apRewardOfferWallLayout5.K = apRewardOfferWallLayout5.Q.c();
                    ApRewardOfferWallLayout apRewardOfferWallLayout6 = ApRewardOfferWallLayout.this;
                    apRewardOfferWallLayout6.showProgressDialog(apRewardOfferWallLayout6.d.s, false);
                    ApRewardOfferWallLayout.this.w0 = 3;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("auth", ApRewardOfferWallLayout.this.L);
                    jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(ApRewardOfferWallLayout.this.f1656b));
                    ApRewardOfferWallLayout.this.V.a(0, ApRewardOfferWallLayout.this.y, jSONObject, ApRewardOfferWallLayout.this);
                    if (ApRewardOfferWallLayout.this.v0 == null || ApRewardOfferWallLayout.this.v0.contains(ApRewardOfferWallLayout.this.r.c())) {
                        return;
                    }
                    ApRewardOfferWallLayout.this.x.b("media_offerwall_tab_content_click", ApRewardOfferWallLayout.this.K);
                    ApRewardOfferWallLayout.this.v0.add(ApRewardOfferWallLayout.this.K);
                }
            } catch (Exception unused) {
            }
        }
    }

    class a0 implements AdapterView.OnItemClickListener {

        class a extends com.igaworks.adpopcorn.cores.common.b {
            a(a0 a0Var) {
            }

            @Override // com.igaworks.adpopcorn.cores.common.b
            public void a() {
                super.a();
            }
        }

        a0() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            JSONObject jSONObject;
            com.igaworks.adpopcorn.a.g.a aVar;
            String str;
            com.igaworks.adpopcorn.a.d dVar;
            String strY;
            try {
                if (ApRewardOfferWallLayout.this.R == null || !ApRewardOfferWallLayout.this.R.isShowing()) {
                    if (ApRewardOfferWallLayout.this.T == null || !ApRewardOfferWallLayout.this.T.isShowing()) {
                        ApRewardOfferWallLayout apRewardOfferWallLayout = ApRewardOfferWallLayout.this;
                        apRewardOfferWallLayout.Q = (com.igaworks.adpopcorn.cores.model.g) apRewardOfferWallLayout.n.get(i);
                        if (ApRewardOfferWallLayout.this.Q.f0()) {
                            return;
                        }
                        if (!ApRewardOfferWallLayout.this.Q.a0()) {
                            int i2 = 0;
                            if (ApRewardOfferWallLayout.this.Q.X()) {
                                ApRewardOfferWallLayout apRewardOfferWallLayout2 = ApRewardOfferWallLayout.this;
                                apRewardOfferWallLayout2.showProgressDialog(apRewardOfferWallLayout2.d.s, false);
                                ApRewardOfferWallLayout.this.x.b("media_offerwall_tab_content_click", ApRewardOfferWallLayout.this.Q.d());
                                ApRewardOfferWallLayout.this.w0 = 1;
                                jSONObject = new JSONObject();
                                jSONObject.put("auth", ApRewardOfferWallLayout.this.Q.a());
                                jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(ApRewardOfferWallLayout.this.f1656b));
                                aVar = ApRewardOfferWallLayout.this.V;
                                i2 = 2;
                                str = ApRewardOfferWallLayout.this.y;
                            } else if (ApRewardOfferWallLayout.this.Q.c0()) {
                                if (ApRewardOfferWallLayout.this.Q.b0()) {
                                    ApRewardOfferWallLayout.this.T = new com.igaworks.adpopcorn.activity.b.g(ApRewardOfferWallLayout.this.f1656b, ApRewardOfferWallLayout.this.o0, ApRewardOfferWallLayout.this.Q, ApRewardOfferWallLayout.this.d, new a(this));
                                    ApRewardOfferWallLayout.this.T.show();
                                } else {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put(MBridgeConstans.APP_KEY, ApRewardOfferWallLayout.this.x.e().b());
                                    jSONObject2.put("adid", ApRewardOfferWallLayout.this.x.e().a());
                                    jSONObject2.put("usn", ApRewardOfferWallLayout.this.x.e().g());
                                    jSONObject2.put("integration_type_no", ApRewardOfferWallLayout.this.Q.E());
                                    jSONObject2.put("point", ApRewardOfferWallLayout.this.Q.F());
                                    jSONObject2.put("newsId", ApRewardOfferWallLayout.this.Q.C());
                                    ApRewardOfferWallLayout.this.V.a(29, ApRewardOfferWallLayout.this.E, jSONObject2, ApRewardOfferWallLayout.this);
                                }
                                dVar = ApRewardOfferWallLayout.this.x;
                                strY = ApRewardOfferWallLayout.this.Q.y();
                            } else {
                                ApRewardOfferWallLayout apRewardOfferWallLayout3 = ApRewardOfferWallLayout.this;
                                apRewardOfferWallLayout3.I = apRewardOfferWallLayout3.Q.K();
                                ApRewardOfferWallLayout apRewardOfferWallLayout4 = ApRewardOfferWallLayout.this;
                                apRewardOfferWallLayout4.L = apRewardOfferWallLayout4.Q.a();
                                ApRewardOfferWallLayout apRewardOfferWallLayout5 = ApRewardOfferWallLayout.this;
                                apRewardOfferWallLayout5.K = apRewardOfferWallLayout5.Q.c();
                                ApRewardOfferWallLayout apRewardOfferWallLayout6 = ApRewardOfferWallLayout.this;
                                apRewardOfferWallLayout6.showProgressDialog(apRewardOfferWallLayout6.d.s, false);
                                ApRewardOfferWallLayout.this.x.b("media_offerwall_tab_content_click", ApRewardOfferWallLayout.this.K);
                                ApRewardOfferWallLayout.this.w0 = 1;
                                jSONObject = new JSONObject();
                                jSONObject.put("auth", ApRewardOfferWallLayout.this.L);
                                jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(ApRewardOfferWallLayout.this.f1656b));
                                aVar = ApRewardOfferWallLayout.this.V;
                                str = ApRewardOfferWallLayout.this.y;
                            }
                            aVar.a(i2, str, jSONObject, ApRewardOfferWallLayout.this);
                            return;
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(MBridgeConstans.APP_KEY, ApRewardOfferWallLayout.this.x.e().b());
                        jSONObject3.put("adid", ApRewardOfferWallLayout.this.x.e().a());
                        jSONObject3.put("usn", ApRewardOfferWallLayout.this.x.e().g());
                        jSONObject3.put("integration_type_no", ApRewardOfferWallLayout.this.Q.l());
                        jSONObject3.put("point", ApRewardOfferWallLayout.this.Q.m());
                        ApRewardOfferWallLayout.this.V.a(27, ApRewardOfferWallLayout.this.D, jSONObject3, ApRewardOfferWallLayout.this);
                        dVar = ApRewardOfferWallLayout.this.x;
                        strY = ApRewardOfferWallLayout.this.Q.d();
                        dVar.b("media_offerwall_tab_content_click", strY);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApRewardOfferWallLayout.this.b(((Integer) view.getTag()).intValue());
        }
    }

    class b0 implements AbsListView.OnScrollListener {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (ApRewardOfferWallLayout.this.V0 != null) {
                    ApRewardOfferWallLayout.this.V0.setVisibility(0);
                }
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (ApRewardOfferWallLayout.this.V0 != null) {
                    ApRewardOfferWallLayout.this.V0.setVisibility(8);
                }
            }
        }

        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ApRewardOfferWallLayout.this.c(true);
            }
        }

        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ApRewardOfferWallLayout.this.c(false);
                if (!com.igaworks.adpopcorn.cores.common.c.c(ApRewardOfferWallLayout.this.f1656b)) {
                    ApRewardOfferWallLayout.this.b0 = true;
                    ApRewardOfferWallLayout.this.c(true);
                } else {
                    ApRewardOfferWallLayout.this.W = false;
                    ApRewardOfferWallLayout.this.a0 = false;
                    ApRewardOfferWallLayout.this.V.a(ApRewardOfferWallLayout.this.c0, ApRewardOfferWallLayout.this);
                }
            }
        }

        b0() {
        }

        /* JADX WARN: Code duplicated, block: B:26:0x005c  */
        /* JADX WARN: Code duplicated, block: B:29:0x006e  */
        /* JADX WARN: Code duplicated, block: B:48:0x00c5  */
        /* JADX WARN: Code duplicated, block: B:57:0x00e9  */
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Handler handler;
            Runnable bVar;
            View childAt = absListView.getChildAt(0);
            if (childAt != null) {
                int i4 = -childAt.getTop();
                if (i >= 1) {
                    if (ApRewardOfferWallLayout.this.A0 != null) {
                        ApRewardOfferWallLayout.this.A0.setVisibility(0);
                    }
                } else if (ApRewardOfferWallLayout.this.o != null && ApRewardOfferWallLayout.this.o.size() > 0) {
                    if (i4 >= (ApRewardOfferWallLayout.this.h0 != null ? ApRewardOfferWallLayout.this.h0.getHeight() : 0)) {
                        if (ApRewardOfferWallLayout.this.A0 != null) {
                            ApRewardOfferWallLayout.this.A0.setVisibility(0);
                        }
                    } else if (ApRewardOfferWallLayout.this.A0 != null) {
                        ApRewardOfferWallLayout.this.A0.setVisibility(4);
                    }
                } else if (ApRewardOfferWallLayout.this.A0 != null) {
                    ApRewardOfferWallLayout.this.A0.setVisibility(0);
                }
            } else if (ApRewardOfferWallLayout.this.A0 != null) {
                ApRewardOfferWallLayout.this.A0.setVisibility(4);
            }
            ApRewardOfferWallLayout.this.A0.invalidate();
            if (ApRewardOfferWallLayout.this.s != null && ApRewardOfferWallLayout.this.S0 == 8) {
                if (childAt != null) {
                    int i5 = -childAt.getTop();
                    if (i >= 1) {
                        if (ApRewardOfferWallLayout.this.u != null) {
                            ApRewardOfferWallLayout.this.u.setVisibility(0);
                        }
                    } else if (ApRewardStyle.useSpecialOffer) {
                        if (ApRewardOfferWallLayout.this.k0 || i5 < ApRewardOfferWallLayout.this.g0.getHeight()) {
                            if (ApRewardOfferWallLayout.this.u != null) {
                                ApRewardOfferWallLayout.this.u.setVisibility(8);
                            }
                        } else if (ApRewardOfferWallLayout.this.u != null) {
                            ApRewardOfferWallLayout.this.u.setVisibility(0);
                        }
                    } else if (ApRewardOfferWallLayout.this.u != null) {
                        ApRewardOfferWallLayout.this.u.setVisibility(8);
                    }
                } else if (ApRewardOfferWallLayout.this.u != null) {
                    ApRewardOfferWallLayout.this.u.setVisibility(8);
                }
            }
            if (i == 0) {
                try {
                    if (ApRewardOfferWallLayout.this.o != null && ApRewardOfferWallLayout.this.o.size() > 1) {
                        ApRewardOfferWallLayout.this.b();
                    }
                } catch (Exception unused) {
                }
            }
            if (i3 < 1 || i + i2 != i3) {
                handler = new Handler();
                bVar = new b();
            } else {
                handler = new Handler();
                bVar = new a();
            }
            handler.post(bVar);
            if (!ApRewardOfferWallLayout.this.W || ApRewardOfferWallLayout.this.b0) {
                return;
            }
            if (ApRewardOfferWallLayout.this.a0 || ApRewardOfferWallLayout.this.c0 > ApRewardOfferWallLayout.this.d0) {
                new Handler().post(new c());
            } else {
                if (i3 < 1 || i + i2 != i3) {
                    return;
                }
                new Handler().post(new d());
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (ApRewardOfferWallLayout.this.R == null || !ApRewardOfferWallLayout.this.R.isShowing()) {
                    ApRewardOfferWallLayout apRewardOfferWallLayout = ApRewardOfferWallLayout.this;
                    apRewardOfferWallLayout.Q = apRewardOfferWallLayout.s;
                    ApRewardOfferWallLayout apRewardOfferWallLayout2 = ApRewardOfferWallLayout.this;
                    apRewardOfferWallLayout2.I = apRewardOfferWallLayout2.Q.K();
                    ApRewardOfferWallLayout apRewardOfferWallLayout3 = ApRewardOfferWallLayout.this;
                    apRewardOfferWallLayout3.L = apRewardOfferWallLayout3.Q.a();
                    ApRewardOfferWallLayout apRewardOfferWallLayout4 = ApRewardOfferWallLayout.this;
                    apRewardOfferWallLayout4.K = apRewardOfferWallLayout4.Q.c();
                    ApRewardOfferWallLayout apRewardOfferWallLayout5 = ApRewardOfferWallLayout.this;
                    apRewardOfferWallLayout5.showProgressDialog(apRewardOfferWallLayout5.d.s, false);
                    ApRewardOfferWallLayout.this.x.b("media_offerwall_tab_content_click", ApRewardOfferWallLayout.this.K);
                    ApRewardOfferWallLayout.this.w0 = 2;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("auth", ApRewardOfferWallLayout.this.L);
                    jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(ApRewardOfferWallLayout.this.f1656b));
                    ApRewardOfferWallLayout.this.V.a(0, ApRewardOfferWallLayout.this.y, jSONObject, ApRewardOfferWallLayout.this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class c0 implements DialogInterface.OnDismissListener {
        c0() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (ApRewardOfferWallLayout.this.e.i()) {
                ApRewardOfferWallLayout apRewardOfferWallLayout = ApRewardOfferWallLayout.this;
                apRewardOfferWallLayout.showProgressDialog(apRewardOfferWallLayout.d.f1613b, true);
            }
        }
    }

    class d implements View.OnClickListener {
        final /* synthetic */ boolean a;

        d(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApRewardOfferWallLayout.this.d();
            if (this.a) {
                ApRewardOfferWallLayout.this.h();
            }
        }
    }

    class d0 implements View.OnClickListener {
        d0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApRewardOfferWallLayout.this.c();
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApRewardOfferWallLayout.this.d();
            ApRewardOfferWallLayout.this.h();
        }
    }

    class e0 implements View.OnClickListener {
        e0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApRewardOfferWallLayout.this.d("https://reward.adpopcorn.com/policy/privacy");
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApRewardOfferWallLayout.this.d();
            String str = "https://adpopcorn.notion.site/FAQ-35edb7e2c4ff4311b2bcf616c8e1b022";
            String strA = com.igaworks.adpopcorn.a.b.a().a(ApRewardOfferWallLayout.this.f1656b, "adpopcorn_sdk_flag", "no_ad_landingurl", "https://adpopcorn.notion.site/FAQ-35edb7e2c4ff4311b2bcf616c8e1b022");
            if (strA != null && strA.length() > 0) {
                str = strA;
            }
            ApRewardOfferWallLayout.this.d(str);
        }
    }

    class f0 implements DialogInterface.OnDismissListener {
        f0() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ApRewardOfferWallLayout.this.a();
        }
    }

    class g implements View.OnClickListener {
        final /* synthetic */ int a;

        g(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (this.a == 1004) {
                    if (com.igaworks.adpopcorn.cores.common.c.c(ApRewardOfferWallLayout.this.f1656b)) {
                        ApRewardOfferWallLayout apRewardOfferWallLayout = ApRewardOfferWallLayout.this;
                        apRewardOfferWallLayout.showProgressDialog(apRewardOfferWallLayout.d.f1613b, false);
                        ApRewardOfferWallLayout.this.V.a(ApRewardOfferWallLayout.this.c0, ApRewardOfferWallLayout.this);
                    } else {
                        ApRewardOfferWallLayout apRewardOfferWallLayout2 = ApRewardOfferWallLayout.this;
                        apRewardOfferWallLayout2.b(apRewardOfferWallLayout2.d.g, ApRewardOfferWallLayout.this.d.h, false);
                    }
                }
                if (ApRewardOfferWallLayout.this.j != null) {
                    ApRewardOfferWallLayout.this.j.notifyDataSetChanged();
                }
                ApRewardOfferWallLayout.this.d();
            } catch (Exception unused) {
            }
        }
    }

    class g0 implements DialogInterface.OnDismissListener {

        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (ApRewardOfferWallLayout.this.R == null || !ApRewardOfferWallLayout.this.R.isShowing()) {
                        ApRewardOfferWallLayout apRewardOfferWallLayout = ApRewardOfferWallLayout.this;
                        apRewardOfferWallLayout.Q = apRewardOfferWallLayout.s;
                        ApRewardOfferWallLayout apRewardOfferWallLayout2 = ApRewardOfferWallLayout.this;
                        apRewardOfferWallLayout2.I = apRewardOfferWallLayout2.Q.K();
                        ApRewardOfferWallLayout apRewardOfferWallLayout3 = ApRewardOfferWallLayout.this;
                        apRewardOfferWallLayout3.L = apRewardOfferWallLayout3.Q.a();
                        ApRewardOfferWallLayout apRewardOfferWallLayout4 = ApRewardOfferWallLayout.this;
                        apRewardOfferWallLayout4.K = apRewardOfferWallLayout4.Q.c();
                        ApRewardOfferWallLayout apRewardOfferWallLayout5 = ApRewardOfferWallLayout.this;
                        apRewardOfferWallLayout5.showProgressDialog(apRewardOfferWallLayout5.d.s, false);
                        ApRewardOfferWallLayout.this.x.b("media_offerwall_tab_content_click", ApRewardOfferWallLayout.this.K);
                        ApRewardOfferWallLayout.this.w0 = 2;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("auth", ApRewardOfferWallLayout.this.L);
                        jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(ApRewardOfferWallLayout.this.f1656b));
                        ApRewardOfferWallLayout.this.V.a(0, ApRewardOfferWallLayout.this.y, jSONObject, ApRewardOfferWallLayout.this);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        g0() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            try {
                if (ApRewardOfferWallLayout.this.o != null && ApRewardOfferWallLayout.this.o.size() > 0) {
                    ApRewardOfferWallLayout.this.z();
                    if (ApRewardOfferWallLayout.this.w != null) {
                        com.igaworks.adpopcorn.cores.common.e.a(ApRewardOfferWallLayout.this.f1656b, ((com.igaworks.adpopcorn.cores.model.g) ApRewardOfferWallLayout.this.o.get(0)).T(), ApRewardOfferWallLayout.this.w, 0, 0, (com.igaworks.adpopcorn.cores.common.e.b) null);
                    }
                    if (ApRewardOfferWallLayout.this.u != null) {
                        ApRewardOfferWallLayout.this.u.a(ApRewardOfferWallLayout.this.u, ApRewardOfferWallLayout.this.f1656b, ApRewardOfferWallLayout.this.s, false, ApRewardOfferWallLayout.this.s0, 0);
                        ApRewardOfferWallLayout.this.u.setOnClickListener(new a());
                    }
                }
                if (ApRewardOfferWallLayout.this.j != null) {
                    ApRewardOfferWallLayout.this.j.notifyDataSetInvalidated();
                }
            } catch (Exception unused) {
            }
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApRewardOfferWallLayout.this.d();
        }
    }

    class h0 implements View.OnClickListener {
        h0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (ApRewardOfferWallLayout.this.R == null || !ApRewardOfferWallLayout.this.R.isShowing()) {
                    ApRewardOfferWallLayout apRewardOfferWallLayout = ApRewardOfferWallLayout.this;
                    apRewardOfferWallLayout.Q = apRewardOfferWallLayout.s;
                    ApRewardOfferWallLayout apRewardOfferWallLayout2 = ApRewardOfferWallLayout.this;
                    apRewardOfferWallLayout2.I = apRewardOfferWallLayout2.Q.K();
                    ApRewardOfferWallLayout apRewardOfferWallLayout3 = ApRewardOfferWallLayout.this;
                    apRewardOfferWallLayout3.L = apRewardOfferWallLayout3.Q.a();
                    ApRewardOfferWallLayout apRewardOfferWallLayout4 = ApRewardOfferWallLayout.this;
                    apRewardOfferWallLayout4.K = apRewardOfferWallLayout4.Q.c();
                    ApRewardOfferWallLayout apRewardOfferWallLayout5 = ApRewardOfferWallLayout.this;
                    apRewardOfferWallLayout5.showProgressDialog(apRewardOfferWallLayout5.d.s, false);
                    ApRewardOfferWallLayout.this.x.b("media_offerwall_tab_content_click", ApRewardOfferWallLayout.this.K);
                    ApRewardOfferWallLayout.this.w0 = 2;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("auth", ApRewardOfferWallLayout.this.L);
                    jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(ApRewardOfferWallLayout.this.f1656b));
                    ApRewardOfferWallLayout.this.V.a(0, ApRewardOfferWallLayout.this.y, jSONObject, ApRewardOfferWallLayout.this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ApRewardOfferWallLayout apRewardOfferWallLayout = ApRewardOfferWallLayout.this;
                if (apRewardOfferWallLayout.c(apRewardOfferWallLayout.Q.J())) {
                    ApRewardOfferWallLayout apRewardOfferWallLayout2 = ApRewardOfferWallLayout.this;
                    apRewardOfferWallLayout2.a(true, apRewardOfferWallLayout2.Q.J());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            ApRewardOfferWallLayout.this.d();
        }
    }

    class i0 implements Runnable {
        i0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ApRewardOfferWallLayout.this.a();
        }
    }

    class j implements DialogInterface.OnDismissListener {
        j() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (ApRewardOfferWallLayout.this.R != null) {
                ApRewardOfferWallLayout.this.R = null;
            }
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.igaworks.adpopcorn.a.d.a(ApRewardOfferWallLayout.this.f1656b) != null) {
                com.igaworks.adpopcorn.a.d.a(ApRewardOfferWallLayout.this.f1656b).j();
            }
            ApRewardOfferWallLayout.this.d();
            ApRewardOfferWallLayout.this.h();
        }
    }

    class l implements View.OnClickListener {
        final /* synthetic */ boolean a;

        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ApRewardOfferWallLayout.this.d();
                l lVar = l.this;
                ApRewardOfferWallLayout.this.resume(lVar.a);
            }
        }

        l(boolean z) {
            this.a = z;
        }

        /* JADX WARN: Code duplicated, block: B:9:0x0040 A[Catch: Exception -> 0x0098, TRY_LEAVE, TryCatch #0 {Exception -> 0x0098, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x0032, B:9:0x0040), top: B:13:0x0003 }] */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                try {
                    if (view.isSelected()) {
                        ApRewardOfferWallLayout.this.d();
                        com.igaworks.adpopcorn.a.b.a().b(ApRewardOfferWallLayout.this.f1656b, "adpopcorn_parameter", "check_user_agreement", true);
                        ApRewardOfferWallLayout.this.resume(this.a);
                        if (com.igaworks.adpopcorn.a.d.a(ApRewardOfferWallLayout.this.f1656b) != null) {
                            com.igaworks.adpopcorn.a.d.a(ApRewardOfferWallLayout.this.f1656b).i();
                        }
                    } else {
                        ApRewardOfferWallLayout.this.d();
                        String str = ApRewardOfferWallLayout.this.d.Y;
                        String str2 = ApRewardOfferWallLayout.this.d.j1;
                        String str3 = ApRewardOfferWallLayout.this.d.I;
                        ApRewardOfferWallLayout apRewardOfferWallLayout = ApRewardOfferWallLayout.this;
                        Context context = ApRewardOfferWallLayout.this.f1656b;
                        int i = ApRewardOfferWallLayout.this.o0;
                        a aVar = new a();
                        ApRewardOfferWallLayout apRewardOfferWallLayout2 = ApRewardOfferWallLayout.this;
                        apRewardOfferWallLayout.m0 = new com.igaworks.adpopcorn.renewal.b.d.a(context, i, str, str2, -1, str3, aVar, apRewardOfferWallLayout2.isLandscapeMode(apRewardOfferWallLayout2.f1656b, false), false);
                        ApRewardOfferWallLayout.this.m0.setCancelable(true);
                        ApRewardOfferWallLayout.this.m0.show();
                    }
                } catch (Exception unused) {
                }
            } else {
                ApRewardOfferWallLayout.this.d();
                String str4 = ApRewardOfferWallLayout.this.d.Y;
                String str5 = ApRewardOfferWallLayout.this.d.j1;
                String str6 = ApRewardOfferWallLayout.this.d.I;
                ApRewardOfferWallLayout apRewardOfferWallLayout3 = ApRewardOfferWallLayout.this;
                Context context2 = ApRewardOfferWallLayout.this.f1656b;
                int i2 = ApRewardOfferWallLayout.this.o0;
                a aVar2 = new a();
                ApRewardOfferWallLayout apRewardOfferWallLayout4 = ApRewardOfferWallLayout.this;
                apRewardOfferWallLayout3.m0 = new com.igaworks.adpopcorn.renewal.b.d.a(context2, i2, str4, str5, -1, str6, aVar2, apRewardOfferWallLayout4.isLandscapeMode(apRewardOfferWallLayout4.f1656b, false), false);
                ApRewardOfferWallLayout.this.m0.setCancelable(true);
                ApRewardOfferWallLayout.this.m0.show();
            }
        }
    }

    class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == 1) {
                ApRewardOfferWallLayout.this.v();
                return;
            }
            try {
                if (ApRewardOfferWallLayout.this.l0) {
                    ApRewardOfferWallLayout.this.s();
                    return;
                }
                if (ApRewardOfferWallLayout.this.I == 7 || ApRewardOfferWallLayout.this.I == 23) {
                    com.igaworks.adpopcorn.a.b.a().b(ApRewardOfferWallLayout.this.c, "participateFlag", ApRewardOfferWallLayout.this.K, true);
                    if (ApRewardOfferWallLayout.this.j != null) {
                        ApRewardOfferWallLayout.this.j.notifyDataSetChanged();
                    }
                }
                ApRewardOfferWallLayout.this.x.b("media_offerwall_tab_content_engagement", ApRewardOfferWallLayout.this.K);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("auth", ApRewardOfferWallLayout.this.M);
                    jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(ApRewardOfferWallLayout.this.f1656b));
                    jSONObject.put("channel_code", ApRewardOfferWallLayout.this.w0);
                    ApRewardOfferWallLayout.this.V.a(1, ApRewardOfferWallLayout.this.z, jSONObject, ApRewardOfferWallLayout.this);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (ApRewardOfferWallLayout.this.R != null) {
                    ApRewardOfferWallLayout.this.R.dismiss();
                    ApRewardOfferWallLayout.this.R = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApRewardOfferWallLayout.this.d();
        }
    }

    class o implements View.OnClickListener {
        o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApRewardOfferWallLayout.this.d();
        }
    }

    class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApRewardOfferWallLayout.this.b(true);
            ApRewardOfferWallLayout.this.d();
        }
    }

    class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApRewardOfferWallLayout.this.d();
        }
    }

    class r implements View.OnClickListener {
        r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ApRewardOfferWallLayout.this.I == 7 || ApRewardOfferWallLayout.this.I == 23) {
                com.igaworks.adpopcorn.a.b.a().b(ApRewardOfferWallLayout.this.c, "participateFlag", ApRewardOfferWallLayout.this.K, true);
                if (ApRewardOfferWallLayout.this.j != null) {
                    ApRewardOfferWallLayout.this.j.notifyDataSetChanged();
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("auth", ApRewardOfferWallLayout.this.M);
                jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(ApRewardOfferWallLayout.this.f1656b));
                jSONObject.put("channel_code", ApRewardOfferWallLayout.this.w0);
                ApRewardOfferWallLayout.this.V.a(1, ApRewardOfferWallLayout.this.z, jSONObject, ApRewardOfferWallLayout.this);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (ApRewardOfferWallLayout.this.R != null) {
                ApRewardOfferWallLayout.this.R.dismiss();
                ApRewardOfferWallLayout.this.R = null;
            }
            ApRewardOfferWallLayout.this.d();
        }
    }

    class s implements View.OnClickListener {
        s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApRewardOfferWallLayout.this.d();
        }
    }

    class t implements View.OnClickListener {
        t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.PASS_PARTICIPATE_EVENT)) {
                    ApRewardOfferWallLayout.this.x.a(ApRewardOfferWallLayout.this.N, ApRewardOfferWallLayout.this.K, ApRewardOfferWallLayout.this.O, (String) null);
                } else if (ApRewardOfferWallLayout.this.P) {
                    ApRewardOfferWallLayout apRewardOfferWallLayout = ApRewardOfferWallLayout.this;
                    apRewardOfferWallLayout.e(apRewardOfferWallLayout.N);
                } else {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(ApRewardOfferWallLayout.this.N));
                    ApRewardOfferWallLayout.this.f1656b.startActivity(intent);
                }
            } catch (Exception unused) {
            }
        }
    }

    class u implements com.igaworks.adpopcorn.a.g.a.d {
        u(ApRewardOfferWallLayout apRewardOfferWallLayout) {
        }

        @Override // com.igaworks.adpopcorn.a.g.a.d
        public void onNetResponseListener(int i, com.igaworks.adpopcorn.cores.model.f fVar) {
        }
    }

    class v implements com.igaworks.adpopcorn.a.g.a.d {
        v(ApRewardOfferWallLayout apRewardOfferWallLayout) {
        }

        @Override // com.igaworks.adpopcorn.a.g.a.d
        public void onNetResponseListener(int i, com.igaworks.adpopcorn.cores.model.f fVar) {
        }
    }

    class w extends com.igaworks.adpopcorn.cores.common.b {
        w() {
        }

        @Override // com.igaworks.adpopcorn.cores.common.b
        public void a() {
            super.a();
            if (ApRewardOfferWallLayout.this.Q.b0()) {
                return;
            }
            ApRewardOfferWallLayout.this.e();
            com.igaworks.adpopcorn.a.b.a().a(ApRewardOfferWallLayout.this.f1656b, ApRewardOfferWallLayout.this.Q.C());
            ApRewardOfferWallLayout.this.Q.g(true);
        }
    }

    class x implements DialogInterface.OnDismissListener {
        x() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (ApRewardOfferWallLayout.this.j != null) {
                ApRewardOfferWallLayout.this.j.notifyDataSetChanged();
            }
        }
    }

    class y implements Runnable {
        final /* synthetic */ com.igaworks.adpopcorn.cores.model.f a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ApRewardOfferWallLayout.this.c(true);
            }
        }

        y(com.igaworks.adpopcorn.cores.model.f fVar) {
            this.a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int iB;
            boolean z = false;
            ApRewardOfferWallLayout.this.a("", false);
            if (ApRewardOfferWallLayout.this.s0) {
                com.igaworks.adpopcorn.cores.common.d.a((Activity) ApRewardOfferWallLayout.this.f1656b, ApRewardOfferWallLayout.this.f.getWidth());
            } else {
                com.igaworks.adpopcorn.cores.common.d.a();
            }
            if (ApRewardOfferWallLayout.this.e != null && (ApRewardOfferWallLayout.this.e.e() || ApRewardOfferWallLayout.this.e.f())) {
                ApRewardOfferWallLayout apRewardOfferWallLayout = ApRewardOfferWallLayout.this;
                apRewardOfferWallLayout.b(apRewardOfferWallLayout.d.X0, ApRewardOfferWallLayout.this.d.h, true);
                ApRewardOfferWallLayout apRewardOfferWallLayout2 = ApRewardOfferWallLayout.this;
                apRewardOfferWallLayout2.a(apRewardOfferWallLayout2.d.X0, true);
                return;
            }
            com.igaworks.adpopcorn.cores.model.f fVar = this.a;
            if (fVar == null || !fVar.d()) {
                com.igaworks.adpopcorn.cores.model.f fVar2 = this.a;
                if (fVar2 == null || fVar2.a() == null || this.a.a().length() <= 0) {
                    z = true;
                } else {
                    try {
                        com.igaworks.adpopcorn.cores.model.e eVarA = com.igaworks.adpopcorn.a.f.d.a(ApRewardOfferWallLayout.this.f1656b, this.a.a());
                        if (eVarA == null || !eVarA.e()) {
                            iB = 0;
                        } else {
                            ApRewardOfferWallLayout.this.a(eVarA.a(), ApRewardOfferWallLayout.this.c0);
                            iB = eVarA.b();
                            ApRewardOfferWallLayout.this.d0 = eVarA.d();
                            ApRewardOfferWallLayout.this.O0 = eVarA.c();
                        }
                        com.igaworks.adpopcorn.cores.common.h.b(ApRewardOfferWallLayout.this.f1656b, "AP_OFFER", "callbackGetCampaignList: resultCode : " + iB, 3);
                        if (ApRewardOfferWallLayout.this.c0 >= ApRewardOfferWallLayout.this.d0) {
                            ApRewardOfferWallLayout.this.a0 = true;
                        }
                        ApRewardOfferWallLayout.this.t = 0;
                        ApRewardOfferWallLayout.this.i();
                        ApRewardOfferWallLayout.this.x();
                        try {
                            if (ApRewardOfferWallLayout.this.c0 == 1) {
                                ApRewardOfferWallLayout apRewardOfferWallLayout3 = ApRewardOfferWallLayout.this;
                                apRewardOfferWallLayout3.R0 = com.igaworks.adpopcorn.a.f.d.c(apRewardOfferWallLayout3.f1656b, this.a.a());
                                ApRewardOfferWallLayout.this.u();
                            }
                        } catch (Exception unused) {
                        }
                        if (iB == 500) {
                            ApRewardOfferWallLayout.this.a(true, true);
                        } else {
                            ApRewardOfferWallLayout.this.a(false, true);
                        }
                        ApRewardOfferWallLayout.x(ApRewardOfferWallLayout.this);
                        ApRewardOfferWallLayout.this.g();
                    } catch (Exception e) {
                        e.printStackTrace();
                        z = true;
                    }
                }
            } else {
                if (ApRewardOfferWallLayout.this.c0 == 1) {
                    ApRewardOfferWallLayout apRewardOfferWallLayout4 = ApRewardOfferWallLayout.this;
                    apRewardOfferWallLayout4.b(apRewardOfferWallLayout4.d.U, ApRewardOfferWallLayout.this.d.h, true);
                } else {
                    ApRewardOfferWallLayout apRewardOfferWallLayout5 = ApRewardOfferWallLayout.this;
                    apRewardOfferWallLayout5.a(apRewardOfferWallLayout5.d.p, ApRewardOfferWallLayout.this.d.e, false);
                }
                if (ApRewardOfferWallLayout.this.m == null || (ApRewardOfferWallLayout.this.m != null && ApRewardOfferWallLayout.this.m.size() == 0)) {
                    ApRewardOfferWallLayout apRewardOfferWallLayout6 = ApRewardOfferWallLayout.this;
                    apRewardOfferWallLayout6.a(apRewardOfferWallLayout6.d.U, true);
                }
            }
            ApRewardOfferWallLayout.this.W = true;
            if (z) {
                if (ApRewardOfferWallLayout.this.c0 == 1) {
                    ApRewardOfferWallLayout apRewardOfferWallLayout7 = ApRewardOfferWallLayout.this;
                    apRewardOfferWallLayout7.b(apRewardOfferWallLayout7.d.U, ApRewardOfferWallLayout.this.d.h, true);
                    if (ApRewardOfferWallLayout.this.m == null || (ApRewardOfferWallLayout.this.m != null && ApRewardOfferWallLayout.this.m.size() == 0)) {
                        ApRewardOfferWallLayout apRewardOfferWallLayout8 = ApRewardOfferWallLayout.this;
                        apRewardOfferWallLayout8.a(apRewardOfferWallLayout8.d.U, true);
                    }
                } else {
                    new Handler().post(new a());
                }
                ApRewardOfferWallLayout.this.b0 = true;
                ApRewardOfferWallLayout.this.g();
            }
            if (ApRewardOfferWallLayout.this.P0 != null) {
                ApRewardOfferWallLayout.this.P0.OnLoadedOfferWallPage();
            }
        }
    }

    class z extends WebViewClient {
        z() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                com.igaworks.adpopcorn.cores.common.h.a(ApRewardOfferWallLayout.this.f1656b, "ApRewardOfferWallLayout", "shouldOverrideUrlLoading = " + str, 3);
                if (str != null && str.startsWith("http://play.google.com/store/apps/")) {
                    str = str.replace("http://play.google.com/store/apps/", "market://");
                } else if (str != null && str.startsWith("https://play.google.com/store/apps/")) {
                    str = str.replace("https://play.google.com/store/apps/", "market://");
                }
                if (str == null || !str.contains("market://")) {
                    webView.loadUrl(str);
                    return true;
                }
                ApRewardOfferWallLayout.this.d(str);
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
    }

    public ApRewardOfferWallLayout(Context context) {
        super(context);
        this.t = 0;
        this.J = false;
        this.P = false;
        this.Q = new com.igaworks.adpopcorn.cores.model.g();
        this.U = new HashMap<>();
        this.c0 = 0;
        this.d0 = 1;
        this.o0 = 0;
        this.p0 = false;
        this.q0 = false;
        this.s0 = false;
        this.w0 = 1;
        this.K0 = 0;
        this.L0 = 0;
        this.M0 = false;
        this.N0 = 0L;
        this.O0 = "";
        this.S0 = 0;
        this.T0 = 0;
        this.U0 = 0;
        this.e1 = new m();
        this.f1 = new a0();
        this.g1 = new b0();
        this.f1656b = context;
        this.c = context.getApplicationContext();
        this.d1 = false;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public ApRewardOfferWallLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = 0;
        this.J = false;
        this.P = false;
        this.Q = new com.igaworks.adpopcorn.cores.model.g();
        this.U = new HashMap<>();
        this.c0 = 0;
        this.d0 = 1;
        this.o0 = 0;
        this.p0 = false;
        this.q0 = false;
        this.s0 = false;
        this.w0 = 1;
        this.K0 = 0;
        this.L0 = 0;
        this.M0 = false;
        this.N0 = 0L;
        this.O0 = "";
        this.S0 = 0;
        this.T0 = 0;
        this.U0 = 0;
        this.e1 = new m();
        this.f1 = new a0();
        this.g1 = new b0();
    }

    private void A() {
        Handler handler = this.F;
        if (handler != null) {
            handler.removeCallbacks(this.G);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            this.t++;
            ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList = this.o;
            if (arrayList == null || arrayList.size() <= 1) {
                return;
            }
            if (this.t >= this.o.size()) {
                this.t = 0;
            }
            com.igaworks.adpopcorn.cores.model.g gVar = this.o.get(this.t);
            this.r = gVar;
            if (gVar != null) {
                this.i0.showNext();
                z();
                com.igaworks.adpopcorn.cores.common.k.a(this.j0, (this.t + 1) + RemoteSettings.FORWARD_SLASH_STRING + this.o.size(), 10, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, false);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(int i2) {
        int i3;
        try {
            if (this.U0 == i2) {
                return;
            }
            int i4 = 0;
            while (i4 < 2) {
                for (int i5 = 0; i5 < this.R0.size(); i5++) {
                    TextView textView = (i4 == 0 ? this.H0 : this.G0).get(i5);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.c, 28));
                    layoutParams.gravity = 16;
                    layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.c, 8);
                    textView.setLayoutParams(layoutParams);
                    textView.setGravity(17);
                    if (i2 == i5) {
                        com.igaworks.adpopcorn.cores.common.k.a(textView, this.R0.get(i5).b(), 14, Color.parseColor("#ffffff"), null, 0, 1, TextUtils.TruncateAt.END, false);
                        i3 = R.drawable.ap_reward_subtab_select_round_bg;
                    } else {
                        com.igaworks.adpopcorn.cores.common.k.a(textView, this.R0.get(i5).b(), 14, Color.parseColor("#808C99"), null, 0, 1, TextUtils.TruncateAt.END, false);
                        i3 = R.drawable.ap_reward_subtab_unselect_round_bg;
                    }
                    textView.setBackgroundResource(i3);
                    textView.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.c, 10), 0, com.igaworks.adpopcorn.cores.common.d.a(this.c, 10), 0);
                }
                i4++;
            }
            this.U0 = i2;
            t();
        } catch (Exception unused) {
        }
    }

    private void a(int i2, com.igaworks.adpopcorn.cores.model.f fVar) {
        String str;
        String str2;
        com.igaworks.adpopcorn.a.g.a aVar;
        com.igaworks.adpopcorn.cores.model.g gVar;
        if (fVar != null && fVar.d()) {
            g();
            com.igaworks.adpopcorn.cores.common.g gVar2 = this.d;
            str = gVar2.p;
            str2 = gVar2.e;
        } else {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    int i3 = 3;
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1656b, "ApRewardOfferWallLayout", "callbackCheckCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    int i4 = jSONObject.getInt("ResultCode");
                    boolean z2 = jSONObject.getBoolean("Result");
                    this.l0 = this.Q.d0();
                    if (!z2) {
                        g();
                        if (i4 != 2000) {
                            com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
                            a(gVar3.p, gVar3.x, true);
                            return;
                        }
                        int i5 = this.I;
                        if (i5 != 25 || i5 != 24) {
                            com.igaworks.adpopcorn.a.b.a().b(this.f1656b, this.Q.c());
                        }
                        com.igaworks.adpopcorn.cores.common.g gVar4 = this.d;
                        a(gVar4.Y, gVar4.i, true);
                        a(false, false);
                        return;
                    }
                    this.M = jSONObject.getString("Auth");
                    this.H = jSONObject.getInt("Status");
                    int iK = this.Q.K();
                    this.I = iK;
                    if (i2 != 2) {
                        if (iK == 1 || iK == 2) {
                            g();
                            int i6 = this.H;
                            if (i6 != 0 && i6 != 50 && i6 != 125) {
                                d(PointerIconCompat.TYPE_WAIT);
                                return;
                            }
                        } else if (iK == 6 || iK == 7 || iK == 23) {
                            aVar = this.V;
                            gVar = this.Q;
                        }
                        w();
                        return;
                    }
                    if (iK != 6 && iK != 7 && iK != 23) {
                        this.x.b("media_offerwall_tab_content_engagement", this.K);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("auth", this.M);
                            jSONObject2.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1656b));
                            jSONObject2.put("channel_code", this.w0);
                            this.V.a(1, this.z, jSONObject2, this);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    aVar = this.V;
                    i3 = 4;
                    gVar = this.Q;
                    aVar.a(i3, gVar.J(), "", this);
                    return;
                } catch (JSONException e3) {
                    g();
                    com.igaworks.adpopcorn.cores.common.g gVar5 = this.d;
                    a(gVar5.I, gVar5.p, true);
                    e3.printStackTrace();
                    return;
                }
            }
            g();
            com.igaworks.adpopcorn.cores.common.g gVar6 = this.d;
            str = gVar6.I;
            str2 = gVar6.g;
        }
        a(str, str2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        d();
    }

    private void a(com.igaworks.adpopcorn.cores.model.f fVar) {
        if (this.c0 == 1) {
            com.igaworks.adpopcorn.a.b.a().a(this.f1656b);
        }
        new Handler(Looper.getMainLooper()).post(new y(fVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, View view) {
        d();
        d(str);
    }

    private void a(String str, String str2, double d2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, boolean z2, String str11, int i3, String str12, String str13, String str14) {
        try {
            this.f1656b.startActivity(new Intent(this.f1656b, (Class<?>) ApVideoAdActivity.class).putExtra("cKey", str).putExtra("joinAuth", str2).putExtra("averageRating", d2).putExtra("landscapeImageURL", str3).putExtra("clickAction", str4).putExtra("campaignDescription", str5).putExtra("iconImageURL", str6).putExtra("campaignName", str7).putExtra("numberOfDownloads", str8).putExtra("redirectURL", str9).putExtra("videoURL", str10).putExtra("ADType", i2).putExtra("AutoRedirect", z2).putExtra("fromVideoAPI", false).putExtra("rewardName", str11).putExtra("skipAllowSeconds", i3).putExtra("videoImpressionURL", str12).putExtra("moreClickReportURL", str13).putExtra("PartiTypeCode", this.I).putExtra("campaignCondition", str14));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, boolean z2) {
        g();
        d();
        String str3 = this.d.h;
        try {
            Context context = this.f1656b;
            com.igaworks.adpopcorn.renewal.b.d.a aVar = new com.igaworks.adpopcorn.renewal.b.d.a(context, this.o0, str, str2, -1, str3, new n(), isLandscapeMode(context, false), false);
            this.m0 = aVar;
            aVar.setCancelable(false);
            this.m0.setCanceledOnTouchOutside(false);
            this.m0.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z2) {
        TextView textView;
        int i2;
        try {
            TextView textView2 = this.i;
            if (textView2 == null) {
                this.i = new TextView(this.c);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                this.i.setLayoutParams(layoutParams);
                this.i.setGravity(17);
                this.i.setText(str);
                this.i.setTextColor(Color.parseColor("#000000"));
                this.i.setTextSize(15.0f);
                this.f.addView(this.i);
            } else {
                textView2.setText(str);
            }
            if (z2) {
                textView = this.i;
                i2 = 0;
            } else {
                textView = this.i;
                i2 = 4;
            }
            textView.setVisibility(i2);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<com.igaworks.adpopcorn.cores.model.g> list, int i2) {
        List<com.igaworks.adpopcorn.cores.model.g> list2;
        try {
            if (list == null) {
                list2 = this.m;
                if (list2 == null || i2 != 1) {
                    return;
                }
            } else {
                if (list != null && list.size() > 0) {
                    if (i2 != 1) {
                        this.m.addAll(list);
                        return;
                    }
                    List<com.igaworks.adpopcorn.cores.model.g> list3 = this.m;
                    if (list3 != null) {
                        list3.clear();
                    }
                    this.m = list;
                    return;
                }
                if (i2 != 1 || (list2 = this.m) == null) {
                    return;
                }
            }
            list2.clear();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0184 A[Catch: Exception -> 0x0327, TryCatch #1 {Exception -> 0x0327, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x000d, B:7:0x0015, B:8:0x001a, B:10:0x0022, B:11:0x0027, B:13:0x002b, B:15:0x0030, B:17:0x0035, B:18:0x0037, B:20:0x003b, B:21:0x003d, B:23:0x0041, B:24:0x0044, B:25:0x0048, B:27:0x0055, B:30:0x0065, B:32:0x006f, B:34:0x007f, B:37:0x0085, B:39:0x008d, B:41:0x0095, B:43:0x009d, B:46:0x00ae, B:49:0x00bb, B:51:0x00c1, B:53:0x00c7, B:61:0x00e6, B:74:0x0118, B:76:0x011e, B:78:0x0126, B:80:0x0133, B:82:0x0137, B:84:0x013d, B:86:0x014a, B:85:0x0143, B:79:0x012c, B:87:0x014e, B:89:0x0152, B:91:0x0158, B:93:0x0161, B:95:0x0167, B:97:0x016b, B:99:0x0173, B:146:0x01f8, B:100:0x0177, B:101:0x0179, B:142:0x01ec, B:102:0x017d, B:105:0x0184, B:147:0x01fc, B:106:0x0188, B:109:0x018f, B:111:0x0193, B:113:0x0199, B:115:0x01a3, B:118:0x01aa, B:121:0x01b1, B:123:0x01b5, B:125:0x01bb, B:127:0x01c5, B:129:0x01cb, B:132:0x01d2, B:133:0x01d5, B:136:0x01dc, B:138:0x01e2, B:141:0x01e9, B:143:0x01f0, B:55:0x00cc, B:57:0x00d2, B:60:0x00e4, B:62:0x00ea, B:64:0x00f1, B:66:0x00f9, B:68:0x0101, B:70:0x010b, B:47:0x00b1, B:169:0x0250, B:171:0x0254, B:174:0x025a, B:176:0x025e, B:178:0x0262, B:182:0x026d, B:184:0x0271, B:186:0x0279, B:188:0x027d, B:190:0x02da, B:189:0x02a6, B:191:0x02dd, B:193:0x02e5, B:194:0x0317, B:196:0x031f, B:198:0x0323), top: B:206:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x018f A[Catch: Exception -> 0x0327, TryCatch #1 {Exception -> 0x0327, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x000d, B:7:0x0015, B:8:0x001a, B:10:0x0022, B:11:0x0027, B:13:0x002b, B:15:0x0030, B:17:0x0035, B:18:0x0037, B:20:0x003b, B:21:0x003d, B:23:0x0041, B:24:0x0044, B:25:0x0048, B:27:0x0055, B:30:0x0065, B:32:0x006f, B:34:0x007f, B:37:0x0085, B:39:0x008d, B:41:0x0095, B:43:0x009d, B:46:0x00ae, B:49:0x00bb, B:51:0x00c1, B:53:0x00c7, B:61:0x00e6, B:74:0x0118, B:76:0x011e, B:78:0x0126, B:80:0x0133, B:82:0x0137, B:84:0x013d, B:86:0x014a, B:85:0x0143, B:79:0x012c, B:87:0x014e, B:89:0x0152, B:91:0x0158, B:93:0x0161, B:95:0x0167, B:97:0x016b, B:99:0x0173, B:146:0x01f8, B:100:0x0177, B:101:0x0179, B:142:0x01ec, B:102:0x017d, B:105:0x0184, B:147:0x01fc, B:106:0x0188, B:109:0x018f, B:111:0x0193, B:113:0x0199, B:115:0x01a3, B:118:0x01aa, B:121:0x01b1, B:123:0x01b5, B:125:0x01bb, B:127:0x01c5, B:129:0x01cb, B:132:0x01d2, B:133:0x01d5, B:136:0x01dc, B:138:0x01e2, B:141:0x01e9, B:143:0x01f0, B:55:0x00cc, B:57:0x00d2, B:60:0x00e4, B:62:0x00ea, B:64:0x00f1, B:66:0x00f9, B:68:0x0101, B:70:0x010b, B:47:0x00b1, B:169:0x0250, B:171:0x0254, B:174:0x025a, B:176:0x025e, B:178:0x0262, B:182:0x026d, B:184:0x0271, B:186:0x0279, B:188:0x027d, B:190:0x02da, B:189:0x02a6, B:191:0x02dd, B:193:0x02e5, B:194:0x0317, B:196:0x031f, B:198:0x0323), top: B:206:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x0193 A[Catch: Exception -> 0x0327, TryCatch #1 {Exception -> 0x0327, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x000d, B:7:0x0015, B:8:0x001a, B:10:0x0022, B:11:0x0027, B:13:0x002b, B:15:0x0030, B:17:0x0035, B:18:0x0037, B:20:0x003b, B:21:0x003d, B:23:0x0041, B:24:0x0044, B:25:0x0048, B:27:0x0055, B:30:0x0065, B:32:0x006f, B:34:0x007f, B:37:0x0085, B:39:0x008d, B:41:0x0095, B:43:0x009d, B:46:0x00ae, B:49:0x00bb, B:51:0x00c1, B:53:0x00c7, B:61:0x00e6, B:74:0x0118, B:76:0x011e, B:78:0x0126, B:80:0x0133, B:82:0x0137, B:84:0x013d, B:86:0x014a, B:85:0x0143, B:79:0x012c, B:87:0x014e, B:89:0x0152, B:91:0x0158, B:93:0x0161, B:95:0x0167, B:97:0x016b, B:99:0x0173, B:146:0x01f8, B:100:0x0177, B:101:0x0179, B:142:0x01ec, B:102:0x017d, B:105:0x0184, B:147:0x01fc, B:106:0x0188, B:109:0x018f, B:111:0x0193, B:113:0x0199, B:115:0x01a3, B:118:0x01aa, B:121:0x01b1, B:123:0x01b5, B:125:0x01bb, B:127:0x01c5, B:129:0x01cb, B:132:0x01d2, B:133:0x01d5, B:136:0x01dc, B:138:0x01e2, B:141:0x01e9, B:143:0x01f0, B:55:0x00cc, B:57:0x00d2, B:60:0x00e4, B:62:0x00ea, B:64:0x00f1, B:66:0x00f9, B:68:0x0101, B:70:0x010b, B:47:0x00b1, B:169:0x0250, B:171:0x0254, B:174:0x025a, B:176:0x025e, B:178:0x0262, B:182:0x026d, B:184:0x0271, B:186:0x0279, B:188:0x027d, B:190:0x02da, B:189:0x02a6, B:191:0x02dd, B:193:0x02e5, B:194:0x0317, B:196:0x031f, B:198:0x0323), top: B:206:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x0199 A[Catch: Exception -> 0x0327, TryCatch #1 {Exception -> 0x0327, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x000d, B:7:0x0015, B:8:0x001a, B:10:0x0022, B:11:0x0027, B:13:0x002b, B:15:0x0030, B:17:0x0035, B:18:0x0037, B:20:0x003b, B:21:0x003d, B:23:0x0041, B:24:0x0044, B:25:0x0048, B:27:0x0055, B:30:0x0065, B:32:0x006f, B:34:0x007f, B:37:0x0085, B:39:0x008d, B:41:0x0095, B:43:0x009d, B:46:0x00ae, B:49:0x00bb, B:51:0x00c1, B:53:0x00c7, B:61:0x00e6, B:74:0x0118, B:76:0x011e, B:78:0x0126, B:80:0x0133, B:82:0x0137, B:84:0x013d, B:86:0x014a, B:85:0x0143, B:79:0x012c, B:87:0x014e, B:89:0x0152, B:91:0x0158, B:93:0x0161, B:95:0x0167, B:97:0x016b, B:99:0x0173, B:146:0x01f8, B:100:0x0177, B:101:0x0179, B:142:0x01ec, B:102:0x017d, B:105:0x0184, B:147:0x01fc, B:106:0x0188, B:109:0x018f, B:111:0x0193, B:113:0x0199, B:115:0x01a3, B:118:0x01aa, B:121:0x01b1, B:123:0x01b5, B:125:0x01bb, B:127:0x01c5, B:129:0x01cb, B:132:0x01d2, B:133:0x01d5, B:136:0x01dc, B:138:0x01e2, B:141:0x01e9, B:143:0x01f0, B:55:0x00cc, B:57:0x00d2, B:60:0x00e4, B:62:0x00ea, B:64:0x00f1, B:66:0x00f9, B:68:0x0101, B:70:0x010b, B:47:0x00b1, B:169:0x0250, B:171:0x0254, B:174:0x025a, B:176:0x025e, B:178:0x0262, B:182:0x026d, B:184:0x0271, B:186:0x0279, B:188:0x027d, B:190:0x02da, B:189:0x02a6, B:191:0x02dd, B:193:0x02e5, B:194:0x0317, B:196:0x031f, B:198:0x0323), top: B:206:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x01aa A[Catch: Exception -> 0x0327, TryCatch #1 {Exception -> 0x0327, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x000d, B:7:0x0015, B:8:0x001a, B:10:0x0022, B:11:0x0027, B:13:0x002b, B:15:0x0030, B:17:0x0035, B:18:0x0037, B:20:0x003b, B:21:0x003d, B:23:0x0041, B:24:0x0044, B:25:0x0048, B:27:0x0055, B:30:0x0065, B:32:0x006f, B:34:0x007f, B:37:0x0085, B:39:0x008d, B:41:0x0095, B:43:0x009d, B:46:0x00ae, B:49:0x00bb, B:51:0x00c1, B:53:0x00c7, B:61:0x00e6, B:74:0x0118, B:76:0x011e, B:78:0x0126, B:80:0x0133, B:82:0x0137, B:84:0x013d, B:86:0x014a, B:85:0x0143, B:79:0x012c, B:87:0x014e, B:89:0x0152, B:91:0x0158, B:93:0x0161, B:95:0x0167, B:97:0x016b, B:99:0x0173, B:146:0x01f8, B:100:0x0177, B:101:0x0179, B:142:0x01ec, B:102:0x017d, B:105:0x0184, B:147:0x01fc, B:106:0x0188, B:109:0x018f, B:111:0x0193, B:113:0x0199, B:115:0x01a3, B:118:0x01aa, B:121:0x01b1, B:123:0x01b5, B:125:0x01bb, B:127:0x01c5, B:129:0x01cb, B:132:0x01d2, B:133:0x01d5, B:136:0x01dc, B:138:0x01e2, B:141:0x01e9, B:143:0x01f0, B:55:0x00cc, B:57:0x00d2, B:60:0x00e4, B:62:0x00ea, B:64:0x00f1, B:66:0x00f9, B:68:0x0101, B:70:0x010b, B:47:0x00b1, B:169:0x0250, B:171:0x0254, B:174:0x025a, B:176:0x025e, B:178:0x0262, B:182:0x026d, B:184:0x0271, B:186:0x0279, B:188:0x027d, B:190:0x02da, B:189:0x02a6, B:191:0x02dd, B:193:0x02e5, B:194:0x0317, B:196:0x031f, B:198:0x0323), top: B:206:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:121:0x01b1 A[Catch: Exception -> 0x0327, TryCatch #1 {Exception -> 0x0327, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x000d, B:7:0x0015, B:8:0x001a, B:10:0x0022, B:11:0x0027, B:13:0x002b, B:15:0x0030, B:17:0x0035, B:18:0x0037, B:20:0x003b, B:21:0x003d, B:23:0x0041, B:24:0x0044, B:25:0x0048, B:27:0x0055, B:30:0x0065, B:32:0x006f, B:34:0x007f, B:37:0x0085, B:39:0x008d, B:41:0x0095, B:43:0x009d, B:46:0x00ae, B:49:0x00bb, B:51:0x00c1, B:53:0x00c7, B:61:0x00e6, B:74:0x0118, B:76:0x011e, B:78:0x0126, B:80:0x0133, B:82:0x0137, B:84:0x013d, B:86:0x014a, B:85:0x0143, B:79:0x012c, B:87:0x014e, B:89:0x0152, B:91:0x0158, B:93:0x0161, B:95:0x0167, B:97:0x016b, B:99:0x0173, B:146:0x01f8, B:100:0x0177, B:101:0x0179, B:142:0x01ec, B:102:0x017d, B:105:0x0184, B:147:0x01fc, B:106:0x0188, B:109:0x018f, B:111:0x0193, B:113:0x0199, B:115:0x01a3, B:118:0x01aa, B:121:0x01b1, B:123:0x01b5, B:125:0x01bb, B:127:0x01c5, B:129:0x01cb, B:132:0x01d2, B:133:0x01d5, B:136:0x01dc, B:138:0x01e2, B:141:0x01e9, B:143:0x01f0, B:55:0x00cc, B:57:0x00d2, B:60:0x00e4, B:62:0x00ea, B:64:0x00f1, B:66:0x00f9, B:68:0x0101, B:70:0x010b, B:47:0x00b1, B:169:0x0250, B:171:0x0254, B:174:0x025a, B:176:0x025e, B:178:0x0262, B:182:0x026d, B:184:0x0271, B:186:0x0279, B:188:0x027d, B:190:0x02da, B:189:0x02a6, B:191:0x02dd, B:193:0x02e5, B:194:0x0317, B:196:0x031f, B:198:0x0323), top: B:206:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x01b5 A[Catch: Exception -> 0x0327, TryCatch #1 {Exception -> 0x0327, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x000d, B:7:0x0015, B:8:0x001a, B:10:0x0022, B:11:0x0027, B:13:0x002b, B:15:0x0030, B:17:0x0035, B:18:0x0037, B:20:0x003b, B:21:0x003d, B:23:0x0041, B:24:0x0044, B:25:0x0048, B:27:0x0055, B:30:0x0065, B:32:0x006f, B:34:0x007f, B:37:0x0085, B:39:0x008d, B:41:0x0095, B:43:0x009d, B:46:0x00ae, B:49:0x00bb, B:51:0x00c1, B:53:0x00c7, B:61:0x00e6, B:74:0x0118, B:76:0x011e, B:78:0x0126, B:80:0x0133, B:82:0x0137, B:84:0x013d, B:86:0x014a, B:85:0x0143, B:79:0x012c, B:87:0x014e, B:89:0x0152, B:91:0x0158, B:93:0x0161, B:95:0x0167, B:97:0x016b, B:99:0x0173, B:146:0x01f8, B:100:0x0177, B:101:0x0179, B:142:0x01ec, B:102:0x017d, B:105:0x0184, B:147:0x01fc, B:106:0x0188, B:109:0x018f, B:111:0x0193, B:113:0x0199, B:115:0x01a3, B:118:0x01aa, B:121:0x01b1, B:123:0x01b5, B:125:0x01bb, B:127:0x01c5, B:129:0x01cb, B:132:0x01d2, B:133:0x01d5, B:136:0x01dc, B:138:0x01e2, B:141:0x01e9, B:143:0x01f0, B:55:0x00cc, B:57:0x00d2, B:60:0x00e4, B:62:0x00ea, B:64:0x00f1, B:66:0x00f9, B:68:0x0101, B:70:0x010b, B:47:0x00b1, B:169:0x0250, B:171:0x0254, B:174:0x025a, B:176:0x025e, B:178:0x0262, B:182:0x026d, B:184:0x0271, B:186:0x0279, B:188:0x027d, B:190:0x02da, B:189:0x02a6, B:191:0x02dd, B:193:0x02e5, B:194:0x0317, B:196:0x031f, B:198:0x0323), top: B:206:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x01dc A[Catch: Exception -> 0x0327, TryCatch #1 {Exception -> 0x0327, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x000d, B:7:0x0015, B:8:0x001a, B:10:0x0022, B:11:0x0027, B:13:0x002b, B:15:0x0030, B:17:0x0035, B:18:0x0037, B:20:0x003b, B:21:0x003d, B:23:0x0041, B:24:0x0044, B:25:0x0048, B:27:0x0055, B:30:0x0065, B:32:0x006f, B:34:0x007f, B:37:0x0085, B:39:0x008d, B:41:0x0095, B:43:0x009d, B:46:0x00ae, B:49:0x00bb, B:51:0x00c1, B:53:0x00c7, B:61:0x00e6, B:74:0x0118, B:76:0x011e, B:78:0x0126, B:80:0x0133, B:82:0x0137, B:84:0x013d, B:86:0x014a, B:85:0x0143, B:79:0x012c, B:87:0x014e, B:89:0x0152, B:91:0x0158, B:93:0x0161, B:95:0x0167, B:97:0x016b, B:99:0x0173, B:146:0x01f8, B:100:0x0177, B:101:0x0179, B:142:0x01ec, B:102:0x017d, B:105:0x0184, B:147:0x01fc, B:106:0x0188, B:109:0x018f, B:111:0x0193, B:113:0x0199, B:115:0x01a3, B:118:0x01aa, B:121:0x01b1, B:123:0x01b5, B:125:0x01bb, B:127:0x01c5, B:129:0x01cb, B:132:0x01d2, B:133:0x01d5, B:136:0x01dc, B:138:0x01e2, B:141:0x01e9, B:143:0x01f0, B:55:0x00cc, B:57:0x00d2, B:60:0x00e4, B:62:0x00ea, B:64:0x00f1, B:66:0x00f9, B:68:0x0101, B:70:0x010b, B:47:0x00b1, B:169:0x0250, B:171:0x0254, B:174:0x025a, B:176:0x025e, B:178:0x0262, B:182:0x026d, B:184:0x0271, B:186:0x0279, B:188:0x027d, B:190:0x02da, B:189:0x02a6, B:191:0x02dd, B:193:0x02e5, B:194:0x0317, B:196:0x031f, B:198:0x0323), top: B:206:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x01e2 A[Catch: Exception -> 0x0327, TryCatch #1 {Exception -> 0x0327, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x000d, B:7:0x0015, B:8:0x001a, B:10:0x0022, B:11:0x0027, B:13:0x002b, B:15:0x0030, B:17:0x0035, B:18:0x0037, B:20:0x003b, B:21:0x003d, B:23:0x0041, B:24:0x0044, B:25:0x0048, B:27:0x0055, B:30:0x0065, B:32:0x006f, B:34:0x007f, B:37:0x0085, B:39:0x008d, B:41:0x0095, B:43:0x009d, B:46:0x00ae, B:49:0x00bb, B:51:0x00c1, B:53:0x00c7, B:61:0x00e6, B:74:0x0118, B:76:0x011e, B:78:0x0126, B:80:0x0133, B:82:0x0137, B:84:0x013d, B:86:0x014a, B:85:0x0143, B:79:0x012c, B:87:0x014e, B:89:0x0152, B:91:0x0158, B:93:0x0161, B:95:0x0167, B:97:0x016b, B:99:0x0173, B:146:0x01f8, B:100:0x0177, B:101:0x0179, B:142:0x01ec, B:102:0x017d, B:105:0x0184, B:147:0x01fc, B:106:0x0188, B:109:0x018f, B:111:0x0193, B:113:0x0199, B:115:0x01a3, B:118:0x01aa, B:121:0x01b1, B:123:0x01b5, B:125:0x01bb, B:127:0x01c5, B:129:0x01cb, B:132:0x01d2, B:133:0x01d5, B:136:0x01dc, B:138:0x01e2, B:141:0x01e9, B:143:0x01f0, B:55:0x00cc, B:57:0x00d2, B:60:0x00e4, B:62:0x00ea, B:64:0x00f1, B:66:0x00f9, B:68:0x0101, B:70:0x010b, B:47:0x00b1, B:169:0x0250, B:171:0x0254, B:174:0x025a, B:176:0x025e, B:178:0x0262, B:182:0x026d, B:184:0x0271, B:186:0x0279, B:188:0x027d, B:190:0x02da, B:189:0x02a6, B:191:0x02dd, B:193:0x02e5, B:194:0x0317, B:196:0x031f, B:198:0x0323), top: B:206:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:140:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:141:0x01e9 A[Catch: Exception -> 0x0327, TryCatch #1 {Exception -> 0x0327, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x000d, B:7:0x0015, B:8:0x001a, B:10:0x0022, B:11:0x0027, B:13:0x002b, B:15:0x0030, B:17:0x0035, B:18:0x0037, B:20:0x003b, B:21:0x003d, B:23:0x0041, B:24:0x0044, B:25:0x0048, B:27:0x0055, B:30:0x0065, B:32:0x006f, B:34:0x007f, B:37:0x0085, B:39:0x008d, B:41:0x0095, B:43:0x009d, B:46:0x00ae, B:49:0x00bb, B:51:0x00c1, B:53:0x00c7, B:61:0x00e6, B:74:0x0118, B:76:0x011e, B:78:0x0126, B:80:0x0133, B:82:0x0137, B:84:0x013d, B:86:0x014a, B:85:0x0143, B:79:0x012c, B:87:0x014e, B:89:0x0152, B:91:0x0158, B:93:0x0161, B:95:0x0167, B:97:0x016b, B:99:0x0173, B:146:0x01f8, B:100:0x0177, B:101:0x0179, B:142:0x01ec, B:102:0x017d, B:105:0x0184, B:147:0x01fc, B:106:0x0188, B:109:0x018f, B:111:0x0193, B:113:0x0199, B:115:0x01a3, B:118:0x01aa, B:121:0x01b1, B:123:0x01b5, B:125:0x01bb, B:127:0x01c5, B:129:0x01cb, B:132:0x01d2, B:133:0x01d5, B:136:0x01dc, B:138:0x01e2, B:141:0x01e9, B:143:0x01f0, B:55:0x00cc, B:57:0x00d2, B:60:0x00e4, B:62:0x00ea, B:64:0x00f1, B:66:0x00f9, B:68:0x0101, B:70:0x010b, B:47:0x00b1, B:169:0x0250, B:171:0x0254, B:174:0x025a, B:176:0x025e, B:178:0x0262, B:182:0x026d, B:184:0x0271, B:186:0x0279, B:188:0x027d, B:190:0x02da, B:189:0x02a6, B:191:0x02dd, B:193:0x02e5, B:194:0x0317, B:196:0x031f, B:198:0x0323), top: B:206:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x01f0 A[Catch: Exception -> 0x0327, TryCatch #1 {Exception -> 0x0327, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x000d, B:7:0x0015, B:8:0x001a, B:10:0x0022, B:11:0x0027, B:13:0x002b, B:15:0x0030, B:17:0x0035, B:18:0x0037, B:20:0x003b, B:21:0x003d, B:23:0x0041, B:24:0x0044, B:25:0x0048, B:27:0x0055, B:30:0x0065, B:32:0x006f, B:34:0x007f, B:37:0x0085, B:39:0x008d, B:41:0x0095, B:43:0x009d, B:46:0x00ae, B:49:0x00bb, B:51:0x00c1, B:53:0x00c7, B:61:0x00e6, B:74:0x0118, B:76:0x011e, B:78:0x0126, B:80:0x0133, B:82:0x0137, B:84:0x013d, B:86:0x014a, B:85:0x0143, B:79:0x012c, B:87:0x014e, B:89:0x0152, B:91:0x0158, B:93:0x0161, B:95:0x0167, B:97:0x016b, B:99:0x0173, B:146:0x01f8, B:100:0x0177, B:101:0x0179, B:142:0x01ec, B:102:0x017d, B:105:0x0184, B:147:0x01fc, B:106:0x0188, B:109:0x018f, B:111:0x0193, B:113:0x0199, B:115:0x01a3, B:118:0x01aa, B:121:0x01b1, B:123:0x01b5, B:125:0x01bb, B:127:0x01c5, B:129:0x01cb, B:132:0x01d2, B:133:0x01d5, B:136:0x01dc, B:138:0x01e2, B:141:0x01e9, B:143:0x01f0, B:55:0x00cc, B:57:0x00d2, B:60:0x00e4, B:62:0x00ea, B:64:0x00f1, B:66:0x00f9, B:68:0x0101, B:70:0x010b, B:47:0x00b1, B:169:0x0250, B:171:0x0254, B:174:0x025a, B:176:0x025e, B:178:0x0262, B:182:0x026d, B:184:0x0271, B:186:0x0279, B:188:0x027d, B:190:0x02da, B:189:0x02a6, B:191:0x02dd, B:193:0x02e5, B:194:0x0317, B:196:0x031f, B:198:0x0323), top: B:206:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:166:0x0246 A[Catch: Exception -> 0x024c, TryCatch #0 {Exception -> 0x024c, blocks: (B:148:0x01ff, B:150:0x0203, B:152:0x0209, B:154:0x0215, B:156:0x021f, B:159:0x022c, B:165:0x0241, B:167:0x0249, B:160:0x022f, B:162:0x0235, B:164:0x023f, B:166:0x0246), top: B:204:0x01ff }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0115  */
    /* JADX WARN: Code duplicated, block: B:74:0x0118 A[Catch: Exception -> 0x0327, TryCatch #1 {Exception -> 0x0327, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x000d, B:7:0x0015, B:8:0x001a, B:10:0x0022, B:11:0x0027, B:13:0x002b, B:15:0x0030, B:17:0x0035, B:18:0x0037, B:20:0x003b, B:21:0x003d, B:23:0x0041, B:24:0x0044, B:25:0x0048, B:27:0x0055, B:30:0x0065, B:32:0x006f, B:34:0x007f, B:37:0x0085, B:39:0x008d, B:41:0x0095, B:43:0x009d, B:46:0x00ae, B:49:0x00bb, B:51:0x00c1, B:53:0x00c7, B:61:0x00e6, B:74:0x0118, B:76:0x011e, B:78:0x0126, B:80:0x0133, B:82:0x0137, B:84:0x013d, B:86:0x014a, B:85:0x0143, B:79:0x012c, B:87:0x014e, B:89:0x0152, B:91:0x0158, B:93:0x0161, B:95:0x0167, B:97:0x016b, B:99:0x0173, B:146:0x01f8, B:100:0x0177, B:101:0x0179, B:142:0x01ec, B:102:0x017d, B:105:0x0184, B:147:0x01fc, B:106:0x0188, B:109:0x018f, B:111:0x0193, B:113:0x0199, B:115:0x01a3, B:118:0x01aa, B:121:0x01b1, B:123:0x01b5, B:125:0x01bb, B:127:0x01c5, B:129:0x01cb, B:132:0x01d2, B:133:0x01d5, B:136:0x01dc, B:138:0x01e2, B:141:0x01e9, B:143:0x01f0, B:55:0x00cc, B:57:0x00d2, B:60:0x00e4, B:62:0x00ea, B:64:0x00f1, B:66:0x00f9, B:68:0x0101, B:70:0x010b, B:47:0x00b1, B:169:0x0250, B:171:0x0254, B:174:0x025a, B:176:0x025e, B:178:0x0262, B:182:0x026d, B:184:0x0271, B:186:0x0279, B:188:0x027d, B:190:0x02da, B:189:0x02a6, B:191:0x02dd, B:193:0x02e5, B:194:0x0317, B:196:0x031f, B:198:0x0323), top: B:206:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x011e A[Catch: Exception -> 0x0327, TryCatch #1 {Exception -> 0x0327, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x000d, B:7:0x0015, B:8:0x001a, B:10:0x0022, B:11:0x0027, B:13:0x002b, B:15:0x0030, B:17:0x0035, B:18:0x0037, B:20:0x003b, B:21:0x003d, B:23:0x0041, B:24:0x0044, B:25:0x0048, B:27:0x0055, B:30:0x0065, B:32:0x006f, B:34:0x007f, B:37:0x0085, B:39:0x008d, B:41:0x0095, B:43:0x009d, B:46:0x00ae, B:49:0x00bb, B:51:0x00c1, B:53:0x00c7, B:61:0x00e6, B:74:0x0118, B:76:0x011e, B:78:0x0126, B:80:0x0133, B:82:0x0137, B:84:0x013d, B:86:0x014a, B:85:0x0143, B:79:0x012c, B:87:0x014e, B:89:0x0152, B:91:0x0158, B:93:0x0161, B:95:0x0167, B:97:0x016b, B:99:0x0173, B:146:0x01f8, B:100:0x0177, B:101:0x0179, B:142:0x01ec, B:102:0x017d, B:105:0x0184, B:147:0x01fc, B:106:0x0188, B:109:0x018f, B:111:0x0193, B:113:0x0199, B:115:0x01a3, B:118:0x01aa, B:121:0x01b1, B:123:0x01b5, B:125:0x01bb, B:127:0x01c5, B:129:0x01cb, B:132:0x01d2, B:133:0x01d5, B:136:0x01dc, B:138:0x01e2, B:141:0x01e9, B:143:0x01f0, B:55:0x00cc, B:57:0x00d2, B:60:0x00e4, B:62:0x00ea, B:64:0x00f1, B:66:0x00f9, B:68:0x0101, B:70:0x010b, B:47:0x00b1, B:169:0x0250, B:171:0x0254, B:174:0x025a, B:176:0x025e, B:178:0x0262, B:182:0x026d, B:184:0x0271, B:186:0x0279, B:188:0x027d, B:190:0x02da, B:189:0x02a6, B:191:0x02dd, B:193:0x02e5, B:194:0x0317, B:196:0x031f, B:198:0x0323), top: B:206:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0126 A[Catch: Exception -> 0x0327, TryCatch #1 {Exception -> 0x0327, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x000d, B:7:0x0015, B:8:0x001a, B:10:0x0022, B:11:0x0027, B:13:0x002b, B:15:0x0030, B:17:0x0035, B:18:0x0037, B:20:0x003b, B:21:0x003d, B:23:0x0041, B:24:0x0044, B:25:0x0048, B:27:0x0055, B:30:0x0065, B:32:0x006f, B:34:0x007f, B:37:0x0085, B:39:0x008d, B:41:0x0095, B:43:0x009d, B:46:0x00ae, B:49:0x00bb, B:51:0x00c1, B:53:0x00c7, B:61:0x00e6, B:74:0x0118, B:76:0x011e, B:78:0x0126, B:80:0x0133, B:82:0x0137, B:84:0x013d, B:86:0x014a, B:85:0x0143, B:79:0x012c, B:87:0x014e, B:89:0x0152, B:91:0x0158, B:93:0x0161, B:95:0x0167, B:97:0x016b, B:99:0x0173, B:146:0x01f8, B:100:0x0177, B:101:0x0179, B:142:0x01ec, B:102:0x017d, B:105:0x0184, B:147:0x01fc, B:106:0x0188, B:109:0x018f, B:111:0x0193, B:113:0x0199, B:115:0x01a3, B:118:0x01aa, B:121:0x01b1, B:123:0x01b5, B:125:0x01bb, B:127:0x01c5, B:129:0x01cb, B:132:0x01d2, B:133:0x01d5, B:136:0x01dc, B:138:0x01e2, B:141:0x01e9, B:143:0x01f0, B:55:0x00cc, B:57:0x00d2, B:60:0x00e4, B:62:0x00ea, B:64:0x00f1, B:66:0x00f9, B:68:0x0101, B:70:0x010b, B:47:0x00b1, B:169:0x0250, B:171:0x0254, B:174:0x025a, B:176:0x025e, B:178:0x0262, B:182:0x026d, B:184:0x0271, B:186:0x0279, B:188:0x027d, B:190:0x02da, B:189:0x02a6, B:191:0x02dd, B:193:0x02e5, B:194:0x0317, B:196:0x031f, B:198:0x0323), top: B:206:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x012c A[Catch: Exception -> 0x0327, TryCatch #1 {Exception -> 0x0327, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x000d, B:7:0x0015, B:8:0x001a, B:10:0x0022, B:11:0x0027, B:13:0x002b, B:15:0x0030, B:17:0x0035, B:18:0x0037, B:20:0x003b, B:21:0x003d, B:23:0x0041, B:24:0x0044, B:25:0x0048, B:27:0x0055, B:30:0x0065, B:32:0x006f, B:34:0x007f, B:37:0x0085, B:39:0x008d, B:41:0x0095, B:43:0x009d, B:46:0x00ae, B:49:0x00bb, B:51:0x00c1, B:53:0x00c7, B:61:0x00e6, B:74:0x0118, B:76:0x011e, B:78:0x0126, B:80:0x0133, B:82:0x0137, B:84:0x013d, B:86:0x014a, B:85:0x0143, B:79:0x012c, B:87:0x014e, B:89:0x0152, B:91:0x0158, B:93:0x0161, B:95:0x0167, B:97:0x016b, B:99:0x0173, B:146:0x01f8, B:100:0x0177, B:101:0x0179, B:142:0x01ec, B:102:0x017d, B:105:0x0184, B:147:0x01fc, B:106:0x0188, B:109:0x018f, B:111:0x0193, B:113:0x0199, B:115:0x01a3, B:118:0x01aa, B:121:0x01b1, B:123:0x01b5, B:125:0x01bb, B:127:0x01c5, B:129:0x01cb, B:132:0x01d2, B:133:0x01d5, B:136:0x01dc, B:138:0x01e2, B:141:0x01e9, B:143:0x01f0, B:55:0x00cc, B:57:0x00d2, B:60:0x00e4, B:62:0x00ea, B:64:0x00f1, B:66:0x00f9, B:68:0x0101, B:70:0x010b, B:47:0x00b1, B:169:0x0250, B:171:0x0254, B:174:0x025a, B:176:0x025e, B:178:0x0262, B:182:0x026d, B:184:0x0271, B:186:0x0279, B:188:0x027d, B:190:0x02da, B:189:0x02a6, B:191:0x02dd, B:193:0x02e5, B:194:0x0317, B:196:0x031f, B:198:0x0323), top: B:206:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0137 A[Catch: Exception -> 0x0327, TryCatch #1 {Exception -> 0x0327, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x000d, B:7:0x0015, B:8:0x001a, B:10:0x0022, B:11:0x0027, B:13:0x002b, B:15:0x0030, B:17:0x0035, B:18:0x0037, B:20:0x003b, B:21:0x003d, B:23:0x0041, B:24:0x0044, B:25:0x0048, B:27:0x0055, B:30:0x0065, B:32:0x006f, B:34:0x007f, B:37:0x0085, B:39:0x008d, B:41:0x0095, B:43:0x009d, B:46:0x00ae, B:49:0x00bb, B:51:0x00c1, B:53:0x00c7, B:61:0x00e6, B:74:0x0118, B:76:0x011e, B:78:0x0126, B:80:0x0133, B:82:0x0137, B:84:0x013d, B:86:0x014a, B:85:0x0143, B:79:0x012c, B:87:0x014e, B:89:0x0152, B:91:0x0158, B:93:0x0161, B:95:0x0167, B:97:0x016b, B:99:0x0173, B:146:0x01f8, B:100:0x0177, B:101:0x0179, B:142:0x01ec, B:102:0x017d, B:105:0x0184, B:147:0x01fc, B:106:0x0188, B:109:0x018f, B:111:0x0193, B:113:0x0199, B:115:0x01a3, B:118:0x01aa, B:121:0x01b1, B:123:0x01b5, B:125:0x01bb, B:127:0x01c5, B:129:0x01cb, B:132:0x01d2, B:133:0x01d5, B:136:0x01dc, B:138:0x01e2, B:141:0x01e9, B:143:0x01f0, B:55:0x00cc, B:57:0x00d2, B:60:0x00e4, B:62:0x00ea, B:64:0x00f1, B:66:0x00f9, B:68:0x0101, B:70:0x010b, B:47:0x00b1, B:169:0x0250, B:171:0x0254, B:174:0x025a, B:176:0x025e, B:178:0x0262, B:182:0x026d, B:184:0x0271, B:186:0x0279, B:188:0x027d, B:190:0x02da, B:189:0x02a6, B:191:0x02dd, B:193:0x02e5, B:194:0x0317, B:196:0x031f, B:198:0x0323), top: B:206:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x013d A[Catch: Exception -> 0x0327, TryCatch #1 {Exception -> 0x0327, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x000d, B:7:0x0015, B:8:0x001a, B:10:0x0022, B:11:0x0027, B:13:0x002b, B:15:0x0030, B:17:0x0035, B:18:0x0037, B:20:0x003b, B:21:0x003d, B:23:0x0041, B:24:0x0044, B:25:0x0048, B:27:0x0055, B:30:0x0065, B:32:0x006f, B:34:0x007f, B:37:0x0085, B:39:0x008d, B:41:0x0095, B:43:0x009d, B:46:0x00ae, B:49:0x00bb, B:51:0x00c1, B:53:0x00c7, B:61:0x00e6, B:74:0x0118, B:76:0x011e, B:78:0x0126, B:80:0x0133, B:82:0x0137, B:84:0x013d, B:86:0x014a, B:85:0x0143, B:79:0x012c, B:87:0x014e, B:89:0x0152, B:91:0x0158, B:93:0x0161, B:95:0x0167, B:97:0x016b, B:99:0x0173, B:146:0x01f8, B:100:0x0177, B:101:0x0179, B:142:0x01ec, B:102:0x017d, B:105:0x0184, B:147:0x01fc, B:106:0x0188, B:109:0x018f, B:111:0x0193, B:113:0x0199, B:115:0x01a3, B:118:0x01aa, B:121:0x01b1, B:123:0x01b5, B:125:0x01bb, B:127:0x01c5, B:129:0x01cb, B:132:0x01d2, B:133:0x01d5, B:136:0x01dc, B:138:0x01e2, B:141:0x01e9, B:143:0x01f0, B:55:0x00cc, B:57:0x00d2, B:60:0x00e4, B:62:0x00ea, B:64:0x00f1, B:66:0x00f9, B:68:0x0101, B:70:0x010b, B:47:0x00b1, B:169:0x0250, B:171:0x0254, B:174:0x025a, B:176:0x025e, B:178:0x0262, B:182:0x026d, B:184:0x0271, B:186:0x0279, B:188:0x027d, B:190:0x02da, B:189:0x02a6, B:191:0x02dd, B:193:0x02e5, B:194:0x0317, B:196:0x031f, B:198:0x0323), top: B:206:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0143 A[Catch: Exception -> 0x0327, TryCatch #1 {Exception -> 0x0327, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x000d, B:7:0x0015, B:8:0x001a, B:10:0x0022, B:11:0x0027, B:13:0x002b, B:15:0x0030, B:17:0x0035, B:18:0x0037, B:20:0x003b, B:21:0x003d, B:23:0x0041, B:24:0x0044, B:25:0x0048, B:27:0x0055, B:30:0x0065, B:32:0x006f, B:34:0x007f, B:37:0x0085, B:39:0x008d, B:41:0x0095, B:43:0x009d, B:46:0x00ae, B:49:0x00bb, B:51:0x00c1, B:53:0x00c7, B:61:0x00e6, B:74:0x0118, B:76:0x011e, B:78:0x0126, B:80:0x0133, B:82:0x0137, B:84:0x013d, B:86:0x014a, B:85:0x0143, B:79:0x012c, B:87:0x014e, B:89:0x0152, B:91:0x0158, B:93:0x0161, B:95:0x0167, B:97:0x016b, B:99:0x0173, B:146:0x01f8, B:100:0x0177, B:101:0x0179, B:142:0x01ec, B:102:0x017d, B:105:0x0184, B:147:0x01fc, B:106:0x0188, B:109:0x018f, B:111:0x0193, B:113:0x0199, B:115:0x01a3, B:118:0x01aa, B:121:0x01b1, B:123:0x01b5, B:125:0x01bb, B:127:0x01c5, B:129:0x01cb, B:132:0x01d2, B:133:0x01d5, B:136:0x01dc, B:138:0x01e2, B:141:0x01e9, B:143:0x01f0, B:55:0x00cc, B:57:0x00d2, B:60:0x00e4, B:62:0x00ea, B:64:0x00f1, B:66:0x00f9, B:68:0x0101, B:70:0x010b, B:47:0x00b1, B:169:0x0250, B:171:0x0254, B:174:0x025a, B:176:0x025e, B:178:0x0262, B:182:0x026d, B:184:0x0271, B:186:0x0279, B:188:0x027d, B:190:0x02da, B:189:0x02a6, B:191:0x02dd, B:193:0x02e5, B:194:0x0317, B:196:0x031f, B:198:0x0323), top: B:206:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x014e A[Catch: Exception -> 0x0327, TryCatch #1 {Exception -> 0x0327, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x000d, B:7:0x0015, B:8:0x001a, B:10:0x0022, B:11:0x0027, B:13:0x002b, B:15:0x0030, B:17:0x0035, B:18:0x0037, B:20:0x003b, B:21:0x003d, B:23:0x0041, B:24:0x0044, B:25:0x0048, B:27:0x0055, B:30:0x0065, B:32:0x006f, B:34:0x007f, B:37:0x0085, B:39:0x008d, B:41:0x0095, B:43:0x009d, B:46:0x00ae, B:49:0x00bb, B:51:0x00c1, B:53:0x00c7, B:61:0x00e6, B:74:0x0118, B:76:0x011e, B:78:0x0126, B:80:0x0133, B:82:0x0137, B:84:0x013d, B:86:0x014a, B:85:0x0143, B:79:0x012c, B:87:0x014e, B:89:0x0152, B:91:0x0158, B:93:0x0161, B:95:0x0167, B:97:0x016b, B:99:0x0173, B:146:0x01f8, B:100:0x0177, B:101:0x0179, B:142:0x01ec, B:102:0x017d, B:105:0x0184, B:147:0x01fc, B:106:0x0188, B:109:0x018f, B:111:0x0193, B:113:0x0199, B:115:0x01a3, B:118:0x01aa, B:121:0x01b1, B:123:0x01b5, B:125:0x01bb, B:127:0x01c5, B:129:0x01cb, B:132:0x01d2, B:133:0x01d5, B:136:0x01dc, B:138:0x01e2, B:141:0x01e9, B:143:0x01f0, B:55:0x00cc, B:57:0x00d2, B:60:0x00e4, B:62:0x00ea, B:64:0x00f1, B:66:0x00f9, B:68:0x0101, B:70:0x010b, B:47:0x00b1, B:169:0x0250, B:171:0x0254, B:174:0x025a, B:176:0x025e, B:178:0x0262, B:182:0x026d, B:184:0x0271, B:186:0x0279, B:188:0x027d, B:190:0x02da, B:189:0x02a6, B:191:0x02dd, B:193:0x02e5, B:194:0x0317, B:196:0x031f, B:198:0x0323), top: B:206:0x0000 }] */
    private void a(boolean z2) {
        com.igaworks.adpopcorn.renewal.layout.c cVar;
        boolean zA;
        ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList;
        APOfferwallTabInfo aPOfferwallTabInfo;
        long j2;
        ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList2;
        try {
            if (this.n.size() != 0) {
                this.n.clear();
            }
            if (this.p.size() != 0) {
                this.p.clear();
            }
            if (this.q.size() != 0) {
                this.q.clear();
            }
            HashMap<String, String> map = this.U;
            if (map != null) {
                map.clear();
            }
            if (z2) {
                if (this.r != null) {
                    this.r = null;
                }
                if (this.s != null) {
                    this.s = null;
                }
                ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList3 = this.o;
                if (arrayList3 != null) {
                    arrayList3.clear();
                }
            }
            this.c1 = 0;
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                com.igaworks.adpopcorn.cores.model.g gVar = this.m.get(i2);
                if (!gVar.f0() && a(gVar.c()) && !com.igaworks.adpopcorn.a.b.a().g(this.f1656b, gVar.c())) {
                    int i3 = this.S0;
                    if (i3 == 8) {
                        zA = true;
                        for (int i4 = 0; i4 < this.Q0.getTabCount(); i4++) {
                            if (this.Q0.getTabType(i4) != 8 && this.Q0.getTabType(i4) != 0 && com.igaworks.adpopcorn.cores.common.k.a(this.Q0.getTabType(i4), gVar.K())) {
                                zA = false;
                            }
                        }
                    } else {
                        zA = com.igaworks.adpopcorn.cores.common.k.a(i3, gVar.K());
                    }
                    try {
                        if (zA && (gVar.a0() || gVar.X())) {
                            arrayList = this.p;
                        } else {
                            if (zA && gVar.c0()) {
                                if (com.igaworks.adpopcorn.a.b.a().f(this.f1656b, gVar.C())) {
                                    zA = false;
                                } else {
                                    arrayList = this.q;
                                }
                            } else if (gVar.K() == 7 || gVar.K() == 23) {
                                if (com.igaworks.adpopcorn.a.b.a().a(this.f1656b, "participateFlag", gVar.c(), false)) {
                                    gVar.j(true);
                                    this.c1++;
                                }
                            }
                            if (zA) {
                                if (z2) {
                                    if (gVar.W()) {
                                        this.s = gVar;
                                        if (gVar.e0()) {
                                            this.n.add(0, gVar);
                                        } else {
                                            this.n.add(this.c1, gVar);
                                        }
                                        if (ApRewardStyle.useSpecialOffer) {
                                            if (gVar.e0()) {
                                                this.o.add(0, gVar);
                                            } else {
                                                this.o.add(this.c1, gVar);
                                            }
                                            this.r = gVar;
                                        }
                                    } else if (!ApRewardStyle.useSpecialOffer && gVar.x()) {
                                        this.o.add(gVar);
                                        ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList4 = this.o;
                                        if (arrayList4 != null && arrayList4.size() <= 1) {
                                            if (this.s == null) {
                                                this.r = gVar;
                                                if (!gVar.e0()) {
                                                    arrayList2 = this.n;
                                                    arrayList2.add(this.c1, gVar);
                                                }
                                            } else if (!gVar.e0()) {
                                                this.n.add(gVar);
                                            }
                                            this.n.add(0, gVar);
                                        } else if (gVar.e0()) {
                                            this.n.add(0, gVar);
                                        } else {
                                            this.n.add(gVar);
                                        }
                                    } else if (this.L0 == 2) {
                                        if (gVar.r() == null && gVar.r().length() > 0) {
                                            if (gVar.e0()) {
                                                this.n.add(0, gVar);
                                            } else {
                                                this.n.add(gVar);
                                            }
                                        }
                                    } else if (gVar.e0()) {
                                        this.n.add(0, gVar);
                                    } else {
                                        this.n.add(gVar);
                                    }
                                } else if (this.L0 == 2) {
                                    if (gVar.W()) {
                                        if (gVar.e0()) {
                                            arrayList2 = this.n;
                                            arrayList2.add(this.c1, gVar);
                                        }
                                    } else if (gVar.e0()) {
                                        this.n.add(gVar);
                                    }
                                    this.n.add(0, gVar);
                                } else if (gVar.r() == null && gVar.r().length() > 0) {
                                    if (gVar.W()) {
                                        if (!gVar.e0()) {
                                            arrayList2 = this.n;
                                            arrayList2.add(this.c1, gVar);
                                        }
                                    } else if (!gVar.e0()) {
                                        this.n.add(gVar);
                                    }
                                    this.n.add(0, gVar);
                                }
                            }
                            aPOfferwallTabInfo = this.Q0;
                            if (aPOfferwallTabInfo != null || aPOfferwallTabInfo.getTabCount() <= 1) {
                                j2 = this.N0;
                            } else if (!com.igaworks.adpopcorn.cores.common.k.a(9, gVar.K()) && !com.igaworks.adpopcorn.cores.common.k.a(10, gVar.K()) && !com.igaworks.adpopcorn.cores.common.k.a(11, gVar.K())) {
                                j2 = this.N0;
                            } else if (gVar.r() != null && gVar.r().length() > 0) {
                                j2 = this.N0;
                            }
                            this.N0 = j2 + gVar.Q();
                        }
                        aPOfferwallTabInfo = this.Q0;
                        if (aPOfferwallTabInfo != null) {
                            j2 = this.N0;
                            this.N0 = j2 + gVar.Q();
                        } else {
                            j2 = this.N0;
                            this.N0 = j2 + gVar.Q();
                        }
                    } catch (Exception unused) {
                    }
                    arrayList.add(gVar);
                    if (zA) {
                        if (z2) {
                            if (gVar.W()) {
                                this.s = gVar;
                                if (gVar.e0()) {
                                    this.n.add(0, gVar);
                                } else {
                                    this.n.add(this.c1, gVar);
                                }
                                if (ApRewardStyle.useSpecialOffer) {
                                    if (gVar.e0()) {
                                        this.o.add(0, gVar);
                                    } else {
                                        this.o.add(this.c1, gVar);
                                    }
                                    this.r = gVar;
                                }
                            } else if (!ApRewardStyle.useSpecialOffer) {
                                if (this.L0 == 2) {
                                    if (gVar.r() == null) {
                                    }
                                } else if (gVar.e0()) {
                                    this.n.add(0, gVar);
                                } else {
                                    this.n.add(gVar);
                                }
                            } else if (this.L0 == 2) {
                                if (gVar.r() == null) {
                                }
                            } else if (gVar.e0()) {
                                this.n.add(0, gVar);
                            } else {
                                this.n.add(gVar);
                            }
                        } else if (this.L0 == 2) {
                            if (gVar.W()) {
                                if (gVar.e0()) {
                                    arrayList2 = this.n;
                                    arrayList2.add(this.c1, gVar);
                                }
                            } else if (gVar.e0()) {
                                this.n.add(gVar);
                            }
                            this.n.add(0, gVar);
                        } else if (gVar.r() == null) {
                        }
                    }
                }
            }
            if (this.k0 || this.o == null || !z2) {
                if (!z2 || (cVar = this.g0) == null) {
                    return;
                }
                cVar.setVisibility(8);
                return;
            }
            ViewFlipper viewFlipper = this.i0;
            if (viewFlipper != null) {
                viewFlipper.removeAllViews();
            }
            for (int i5 = 0; i5 < this.o.size(); i5++) {
                if (i5 != 0 || this.s == null || isLandscapeMode(this.f1656b, false) || this.v) {
                    Context context = this.f1656b;
                    com.igaworks.adpopcorn.activity.c.i iVar = new com.igaworks.adpopcorn.activity.c.i(context, com.igaworks.adpopcorn.cores.common.d.a(context, 10));
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.gravity = 1;
                    iVar.setScaleType(ImageView.ScaleType.FIT_XY);
                    iVar.setLayoutParams(layoutParams);
                    this.i0.addView(iVar);
                    com.igaworks.adpopcorn.cores.common.e.a(this.f1656b, this.o.get(i5).T(), iVar, 0, 0, (com.igaworks.adpopcorn.cores.common.e.b) null);
                } else {
                    Context context2 = this.f1656b;
                    this.w = new com.igaworks.adpopcorn.activity.c.i(context2, com.igaworks.adpopcorn.cores.common.d.a(context2, 10));
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams2.gravity = 1;
                    this.w.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.w.setLayoutParams(layoutParams2);
                    this.i0.addView(this.w);
                }
            }
            if (this.o.size() <= 0) {
                this.j0.setVisibility(8);
            } else {
                com.igaworks.adpopcorn.cores.common.k.a(this.j0, "1/" + this.o.size(), 10, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, false);
                this.j0.setVisibility(0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2, String str) {
        String installerPackageName;
        com.igaworks.adpopcorn.a.g.a aVar;
        int i2;
        String str2;
        String str3 = this.M;
        String str4 = this.K;
        try {
            installerPackageName = this.f1656b.getPackageManager().getInstallerPackageName(str);
        } catch (Exception unused) {
            installerPackageName = null;
        }
        try {
            com.igaworks.adpopcorn.cores.common.h.a(this.f1656b, "ApRewardOfferWallLayout", "sendCompleteRewardRequest installer = " + installerPackageName, 3);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", this.M);
            jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1656b));
            jSONObject.put("sign", com.igaworks.adpopcorn.cores.common.c.a(str4, str3));
            jSONObject.put(TapjoyConstants.TJC_INSTALLER, installerPackageName);
            if (z2) {
                aVar = this.V;
                i2 = 5;
                str2 = this.A;
            } else {
                aVar = this.V;
                i2 = 19;
                str2 = this.C;
            }
            aVar.a(i2, str2, jSONObject, this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2, boolean z3) {
        Context context;
        String strT;
        com.igaworks.adpopcorn.activity.c.e eVar;
        LinearLayout linearLayout;
        try {
            this.N0 = 0L;
            g();
            List<com.igaworks.adpopcorn.cores.model.g> list = this.m;
            if (list != null && (list == null || list.size() != 0)) {
                a("", false);
                com.igaworks.adpopcorn.a.c cVar = this.e;
                if (cVar != null && cVar.d()) {
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1656b, "ApRewardOfferWallLayout", "sign1 : true", 3);
                    com.igaworks.adpopcorn.cores.common.j.f(this.f1656b);
                }
                a(z3);
                if (this.S0 == 8) {
                    ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList = this.n;
                    if (arrayList == null || arrayList.size() == 0) {
                        f(false);
                        a(this.d.f, true);
                        return;
                    }
                } else {
                    ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList2 = this.n;
                    if (arrayList2 == null || arrayList2.size() == 0) {
                        a(this.d.f, true);
                    }
                }
                if (this.s == null) {
                    this.v = true;
                    if (z3) {
                        z();
                    }
                    if (this.w != null) {
                        context = this.f1656b;
                        strT = this.o.get(0).T();
                        com.igaworks.adpopcorn.cores.common.e.a(context, strT, this.w, 0, 0, (com.igaworks.adpopcorn.cores.common.e.b) null);
                    }
                } else if (this.v || isLandscapeMode(this.f1656b, false)) {
                    if (z3) {
                        z();
                    }
                    if (this.w != null) {
                        context = this.f1656b;
                        strT = this.o.get(0).T();
                        com.igaworks.adpopcorn.cores.common.e.a(context, strT, this.w, 0, 0, (com.igaworks.adpopcorn.cores.common.e.b) null);
                    }
                } else {
                    e(true);
                }
                if (this.r == null || (linearLayout = this.h0) == null) {
                    LinearLayout linearLayout2 = this.h0;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(8);
                    }
                } else {
                    linearLayout.setVisibility(0);
                }
                if (isLandscapeMode(this.f1656b, false)) {
                    if (this.c0 == 1) {
                        eVar = this.l;
                        eVar.setAdapter((ListAdapter) this.j);
                    }
                } else if (this.c0 == 1) {
                    eVar = this.k;
                    eVar.setAdapter((ListAdapter) this.j);
                }
                com.igaworks.adpopcorn.renewal.a.a aVar = this.j;
                if (aVar != null) {
                    aVar.notifyDataSetChanged();
                }
                y();
                return;
            }
            f(z2);
            a(this.d.f, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            g();
        }
    }

    private boolean a(String str) {
        if (!com.igaworks.adpopcorn.cores.common.k.a(str)) {
            return true;
        }
        HashMap<String, String> map = this.U;
        if (map != null && map.containsKey(str)) {
            return false;
        }
        List<String> list = this.W0;
        if (list != null && list.contains(str)) {
            return false;
        }
        HashMap<String, String> map2 = this.U;
        if (map2 != null) {
            map2.put(str, str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            ArrayList<String> arrayList = this.u0;
            if (arrayList == null || arrayList.contains(this.r.c()) || !com.igaworks.adpopcorn.cores.common.k.a(this.i0)) {
                return;
            }
            this.u0.add(this.r.c());
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        HorizontalScrollView horizontalScrollView;
        HorizontalScrollView horizontalScrollView2;
        com.igaworks.adpopcorn.renewal.layout.a aVar;
        LinearLayout.LayoutParams layoutParams;
        TextView textView;
        List<ImageView> list;
        FrameLayout.LayoutParams layoutParams2;
        try {
            if (this.T0 == i2) {
                return;
            }
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, 2));
            layoutParams3.gravity = 80;
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, 1.0f));
            layoutParams4.gravity = 80;
            for (int i3 = 0; i3 < 2; i3++) {
                for (int i4 = 0; i4 < this.Q0.getTabCount(); i4++) {
                    if (i3 == 0) {
                        textView = this.F0.get(i4);
                        list = this.J0;
                    } else {
                        textView = this.E0.get(i4);
                        list = this.I0;
                    }
                    ImageView imageView = list.get(i4);
                    if (i2 == i4) {
                        textView.setTextColor(Color.parseColor("#212529"));
                        imageView.setBackgroundColor(Color.parseColor("#212529"));
                        textView.setTypeface(textView.getTypeface(), 1);
                        textView.setPaintFlags(textView.getPaintFlags() | 32);
                        layoutParams2 = layoutParams3;
                    } else {
                        textView.setTextColor(Color.parseColor("#808C99"));
                        imageView.setBackgroundColor(Color.parseColor("#F1F2F4"));
                        textView.setTypeface(null, 0);
                        textView.setPaintFlags(textView.getPaintFlags() ^ 32);
                        layoutParams2 = layoutParams4;
                    }
                    imageView.setLayoutParams(layoutParams2);
                }
            }
            int tabType = this.Q0.getTabType(i2);
            this.S0 = tabType;
            if (this.k0) {
                this.L0 = 0;
                if (tabType == 8) {
                    horizontalScrollView2 = this.C0;
                    horizontalScrollView2.setVisibility(0);
                    this.B0.setVisibility(0);
                } else {
                    horizontalScrollView = this.C0;
                    horizontalScrollView.setVisibility(8);
                    this.B0.setVisibility(8);
                }
            } else if (this.K0 == 2) {
                this.L0 = 2;
                if (tabType == 8) {
                    horizontalScrollView2 = this.C0;
                    horizontalScrollView2.setVisibility(0);
                    this.B0.setVisibility(0);
                } else {
                    horizontalScrollView = this.C0;
                    horizontalScrollView.setVisibility(8);
                    this.B0.setVisibility(8);
                }
            } else {
                this.L0 = 0;
                if (tabType == 9 || tabType == 10 || tabType == 11 || tabType == 0) {
                    this.L0 = 2;
                }
                if (this.L0 == 0) {
                    horizontalScrollView2 = this.C0;
                    horizontalScrollView2.setVisibility(0);
                    this.B0.setVisibility(0);
                } else {
                    horizontalScrollView = this.C0;
                    horizontalScrollView.setVisibility(8);
                    this.B0.setVisibility(8);
                }
            }
            if (!this.k0) {
                if (this.S0 == 8) {
                    layoutParams = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, this.a1 - 12));
                    layoutParams.gravity = 49;
                } else {
                    layoutParams = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, this.a1));
                    layoutParams.gravity = 17;
                }
                this.x0.setOrientation(0);
                this.x0.setGravity(17);
                this.x0.setLayoutParams(layoutParams);
            }
            this.z0.invalidate();
            this.A0.invalidate();
            com.igaworks.adpopcorn.renewal.a.a aVar2 = this.j;
            if (aVar2 != null) {
                aVar2.a(this.L0);
            }
            com.igaworks.adpopcorn.renewal.layout.a aVar3 = this.u;
            if (aVar3 != null) {
                aVar3.setVisibility(8);
            }
            a(false, false);
            this.T0 = i2;
            com.igaworks.adpopcorn.cores.model.g gVar = this.s;
            if (gVar != null && (aVar = this.u) != null) {
                aVar.a(aVar, this.f1656b, gVar, false, this.s0, 0);
                this.u.setOnClickListener(new c());
            }
            com.igaworks.adpopcorn.a.d dVar = this.x;
            if (dVar != null) {
                dVar.b("media_offerwall_tab_visit", this.S0 + "");
            }
        } catch (Exception unused) {
        }
    }

    private void b(int i2, com.igaworks.adpopcorn.cores.model.f fVar) {
        try {
            if (fVar != null) {
                try {
                    if (fVar.c()) {
                        int i3 = this.I;
                        if (i3 == 6) {
                            g();
                            int i4 = this.H;
                            if (i4 != 0) {
                                if (i4 == 50 || i4 == 125) {
                                    if (i2 == 4) {
                                        this.x.b("media_offerwall_tab_content_engagement", this.K);
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("auth", this.M);
                                        jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1656b));
                                        jSONObject.put("channel_code", this.w0);
                                        this.V.a(1, this.z, jSONObject, this);
                                        return;
                                    }
                                    w();
                                }
                                return;
                            }
                        } else {
                            if (i3 != 7 && i3 != 23) {
                                return;
                            }
                            int i5 = this.H;
                            if (i5 != 0) {
                                if (i5 == 50) {
                                    if (i3 != 23) {
                                        a(true, this.Q.J());
                                        return;
                                    } else {
                                        g();
                                        d(PointerIconCompat.TYPE_ALL_SCROLL);
                                        return;
                                    }
                                }
                                if (i5 == 125) {
                                    this.J = true;
                                    this.x.b("media_offerwall_tab_content_engagement", this.K);
                                    try {
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("auth", this.M);
                                        jSONObject2.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1656b));
                                        jSONObject2.put("channel_code", this.w0);
                                        this.V.a(1, this.z, jSONObject2, this);
                                        return;
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                        return;
                                    }
                                }
                                return;
                            }
                            g();
                        }
                        d(1002);
                        return;
                    }
                } catch (Exception unused) {
                    g();
                    return;
                }
            }
            if (i2 == 4) {
                this.x.b("media_offerwall_tab_content_engagement", this.K);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("auth", this.M);
                jSONObject3.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1656b));
                jSONObject3.put("channel_code", this.w0);
                this.V.a(1, this.z, jSONObject3, this);
                return;
            }
            g();
            int i6 = this.I;
            if (i6 == 6) {
                int i7 = this.H;
                if (i7 != 0 && i7 != 50 && i7 != 125) {
                    return;
                }
            } else {
                if (i6 != 7 && i6 != 23) {
                    return;
                }
                int i8 = this.H;
                if (i8 != 0) {
                    if (i8 == 50 || i8 == 125) {
                        d(PointerIconCompat.TYPE_HELP);
                        return;
                    }
                    return;
                }
            }
            w();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        h();
    }

    private void b(com.igaworks.adpopcorn.cores.model.f fVar) {
        String str;
        String str2;
        com.igaworks.adpopcorn.cores.model.g gVar;
        String strF;
        g();
        if (fVar != null && fVar.d()) {
            com.igaworks.adpopcorn.cores.common.g gVar2 = this.d;
            str = gVar2.p;
            str2 = gVar2.e;
        } else {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1656b, "ApRewardOfferWallLayout", "callbackJoinCPMCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    String string = jSONObject.getString("CPMParticipatedTid");
                    if (!z2) {
                        com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
                        a(gVar3.p, gVar3.e, false);
                        return;
                    }
                    if (this.Q.l() == 16) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(ScarConstants.TOKEN_ID_KEY, string);
                        String string2 = jSONObject2.toString();
                        try {
                            string2 = URLEncoder.encode(jSONObject2.toString(), "utf-8");
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        strF = this.Q.f() + "&custom=" + string2;
                    } else {
                        if (this.Q.l() == 40) {
                            if (this.Q.Y()) {
                                com.igaworks.adpopcorn.cores.common.h.a(this.f1656b, "ApRewardOfferWallLayout", "callbackJoinCPMCampaign already completed", 3);
                            } else {
                                b(jSONObject.getString("Auth"));
                                this.Q.c(true);
                            }
                            gVar = this.Q;
                        } else {
                            gVar = this.Q;
                        }
                        strF = gVar.f();
                    }
                    d(strF);
                    try {
                        Iterator<String> it = this.Q.e().iterator();
                        while (it.hasNext()) {
                            this.V.a(14, it.next(), "", new v(this));
                        }
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                } catch (JSONException e3) {
                    com.igaworks.adpopcorn.cores.common.g gVar4 = this.d;
                    a(gVar4.p, gVar4.e, false);
                    e3.printStackTrace();
                    return;
                }
            }
            com.igaworks.adpopcorn.cores.common.g gVar5 = this.d;
            str = gVar5.Y;
            str2 = gVar5.g;
        }
        a(str, str2, false);
    }

    private void b(String str) {
        com.igaworks.adpopcorn.a.g.a aVar;
        String str2;
        try {
            String strD = this.Q.d();
            if (this.Q == null) {
                com.igaworks.adpopcorn.cores.common.h.a(this.f1656b, "ApRewardOfferWallLayout", "completeCampaign failed", 3);
                return;
            }
            com.igaworks.adpopcorn.cores.common.h.a(this.f1656b, "ApRewardOfferWallLayout", "completeCampaign success", 3);
            if (this.V == null) {
                this.V = new com.igaworks.adpopcorn.a.g.a(this.f1656b);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", str);
            jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1656b));
            jSONObject.put("sign", com.igaworks.adpopcorn.cores.common.c.a(strD, str));
            if (com.igaworks.adpopcorn.a.d.E) {
                aVar = this.V;
                str2 = "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/CompleteCPMClick";
            } else {
                aVar = this.V;
                str2 = "https://apapi.adpopcorn.com/ap/v1/common/conversion/CompleteCPMClick";
            }
            aVar.a(28, str2, jSONObject, this);
        } catch (Exception e2) {
            com.igaworks.adpopcorn.cores.common.h.a(this.f1656b, "ApRewardOfferWallLayout", "completeCampaign failed : " + e2.getMessage(), 3);
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            a(gVar.Y, gVar.e, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, boolean z2) {
        try {
            g();
            d();
            String str3 = this.d.I;
            Context context = this.f1656b;
            com.igaworks.adpopcorn.renewal.b.d.a aVar = new com.igaworks.adpopcorn.renewal.b.d.a(context, this.o0, str3, str, 1, str2, new d(z2), isLandscapeMode(context, false), false);
            this.m0 = aVar;
            aVar.setCancelable(false);
            this.m0.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z2) {
        if (z2) {
            try {
                showProgressDialog(this.d.s, false);
            } catch (Exception unused) {
                g();
                return;
            }
        }
        if (this.V == null) {
            this.V = new com.igaworks.adpopcorn.a.g.a(this.f1656b);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("auth", this.M);
        jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1656b));
        this.V.a(11, this.B, jSONObject, this);
    }

    private com.igaworks.adpopcorn.activity.layout.b c(int i2) {
        com.igaworks.adpopcorn.activity.layout.b bVar = new com.igaworks.adpopcorn.activity.layout.b(this.c, i2);
        this.e0 = (LinearLayout) bVar.findViewById(0);
        TextView textView = (TextView) bVar.findViewById(1);
        this.e0.setVisibility(8);
        textView.setText(this.d.V);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            final String strD = com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.BOTTOM_BAR_LINK_URL);
            if (strD == null || !strD.contentEquals("https://reward.adpopcorn.com")) {
                d(strD);
            } else {
                d();
                com.igaworks.adpopcorn.cores.common.g gVar = this.d;
                com.igaworks.adpopcorn.renewal.b.d.a aVar = new com.igaworks.adpopcorn.renewal.b.d.a(this.f1656b, this.o0, gVar.Y, gVar.W0, -1, gVar.c0, new View.OnClickListener() { // from class: com.igaworks.adpopcorn.renewal.layout.-$$Lambda$ApRewardOfferWallLayout$hWIBdEKw1rr2ueWy4xOxXyyQUrM
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.a(view);
                    }
                }, gVar.b0, new View.OnClickListener() { // from class: com.igaworks.adpopcorn.renewal.layout.-$$Lambda$ApRewardOfferWallLayout$DCr414XnHXVMcX8CblgctJuLXbc
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.a(strD, view);
                    }
                }, isLandscapeMode(this.f1656b, false));
                this.m0 = aVar;
                aVar.setCancelable(true);
                this.m0.show();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        h();
    }

    private void c(com.igaworks.adpopcorn.cores.model.f fVar) {
        String str;
        String str2;
        if (fVar != null && fVar.d()) {
            g();
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            str = gVar.p;
            str2 = gVar.e;
        } else {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1656b, "ApRewardOfferWallLayout", "callbackJoinCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    String string = jSONObject.getString("ResultMsg");
                    int i2 = jSONObject.getInt("ResultCode");
                    if (!jSONObject.has("RedirectURL") || jSONObject.isNull("RedirectURL")) {
                        this.N = "";
                    } else {
                        this.N = jSONObject.getString("RedirectURL");
                    }
                    if (!jSONObject.has("HideBrowser") || jSONObject.isNull("HideBrowser")) {
                        this.P = false;
                    } else {
                        this.P = jSONObject.getBoolean("HideBrowser");
                    }
                    if (jSONObject.has("ParticipatedTid") && !jSONObject.isNull("ParticipatedTid")) {
                        this.O = jSONObject.getLong("ParticipatedTid") + "";
                    }
                    if (!z2) {
                        g();
                        if (i2 != 999 && i2 != 1000) {
                            a(this.d.q, string, true);
                            return;
                        }
                        com.igaworks.adpopcorn.cores.common.g gVar2 = this.d;
                        a(gVar2.q, gVar2.l0, true);
                        return;
                    }
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1656b, "ApRewardOfferWallLayout", "callbackJoinCampaign success, useHiddenBrowser = " + this.P + ", redirectURL = " + this.N, 3);
                    this.M = jSONObject.getString("Auth");
                    if (this.J) {
                        a(true, this.Q.J());
                        this.J = false;
                        return;
                    }
                    int i3 = this.I;
                    if (i3 == 10) {
                        g();
                        c(this.N);
                        return;
                    }
                    if (i3 != 16 && i3 != 26 && i3 != 27) {
                        if (i3 == 25) {
                            g();
                            try {
                                if (c(this.Q.J())) {
                                    a(false, this.Q.J());
                                } else {
                                    d();
                                    com.igaworks.adpopcorn.a.b.a().b(this.c, "participateFlag", this.K, true);
                                    com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
                                    String str3 = gVar3.I;
                                    String str4 = gVar3.u0;
                                    String str5 = gVar3.z;
                                    String str6 = gVar3.y;
                                    Context context = this.f1656b;
                                    com.igaworks.adpopcorn.renewal.b.d.a aVar = new com.igaworks.adpopcorn.renewal.b.d.a(context, this.o0, str3, str4, -1, str5, new s(), str6, new t(), isLandscapeMode(context, false));
                                    this.m0 = aVar;
                                    aVar.setCancelable(false);
                                    this.m0.show();
                                }
                                return;
                            } catch (Exception unused) {
                                return;
                            }
                        }
                        g();
                        if (this.Q.X()) {
                            this.Q.c(true);
                            try {
                                Iterator<String> it = this.Q.e().iterator();
                                while (it.hasNext()) {
                                    this.V.a(14, it.next(), "", new u(this));
                                }
                            } catch (Exception unused2) {
                            }
                        }
                        if (this.Q.h0()) {
                            this.N = this.Q.M();
                        }
                        if (com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.PASS_PARTICIPATE_EVENT)) {
                            this.x.a(this.N, this.K, this.O, (String) null);
                            return;
                        }
                        if (this.P) {
                            e(this.N);
                            return;
                        }
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(this.N));
                        try {
                            this.f1656b.startActivity(intent);
                            return;
                        } catch (Exception e2) {
                            com.igaworks.adpopcorn.cores.common.g gVar4 = this.d;
                            a(gVar4.q, gVar4.w, true);
                            e2.printStackTrace();
                            return;
                        }
                    }
                    b(false);
                    return;
                } catch (JSONException e3) {
                    g();
                    com.igaworks.adpopcorn.cores.common.g gVar5 = this.d;
                    a(gVar5.p, gVar5.e, false);
                    e3.printStackTrace();
                    return;
                }
            }
            g();
            com.igaworks.adpopcorn.cores.common.g gVar6 = this.d;
            str = gVar6.Y;
            str2 = gVar6.g;
        }
        a(str, str2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z2) {
        LinearLayout linearLayout;
        int i2;
        if (z2) {
            linearLayout = this.e0;
            i2 = 8;
        } else {
            linearLayout = this.e0;
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
        try {
            Intent launchIntentForPackage = this.f1656b.getPackageManager().getLaunchIntentForPackage(str);
            launchIntentForPackage.setFlags(268435456);
            this.f1656b.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Dialog dialog = this.m0;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.m0.dismiss();
        this.m0 = null;
    }

    private void d(int i2) {
        String str;
        try {
            d();
            g();
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            String str2 = gVar.Y;
            if (i2 == 1000) {
                str = gVar.C;
            } else if (i2 == 1001) {
                str = gVar.D;
            } else if (i2 == 1002) {
                str = gVar.t;
            } else if (i2 == 1004) {
                str = gVar.B;
            } else if (i2 == 1003) {
                str = gVar.A;
            } else if (i2 == 1005) {
                str = gVar.i;
            } else if (i2 == 1012) {
                str = gVar.r;
            } else {
                str = i2 == 1013 ? gVar.o0 : "";
            }
            if (i2 == 1000 || i2 == 1001 || i2 == 1002 || i2 == 1004 || i2 == 1005) {
                String str3 = gVar.h;
                try {
                    Context context = this.f1656b;
                    com.igaworks.adpopcorn.renewal.b.d.a aVar = new com.igaworks.adpopcorn.renewal.b.d.a(context, this.o0, str2, str, -1, str3, new g(i2), isLandscapeMode(context, false), false);
                    this.m0 = aVar;
                    aVar.setCancelable(false);
                    this.m0.show();
                    return;
                } catch (Exception e2) {
                    e = e2;
                }
            } else if (i2 == 1003 || i2 == 1012) {
                try {
                    w();
                    return;
                } catch (Exception e3) {
                    e = e3;
                }
            } else {
                if (i2 != 1013) {
                    return;
                }
                try {
                    String str4 = gVar.z;
                    String str5 = gVar.H;
                    Context context2 = this.f1656b;
                    com.igaworks.adpopcorn.renewal.b.d.a aVar2 = new com.igaworks.adpopcorn.renewal.b.d.a(context2, this.o0, str2, str, -1, str4, new h(), str5, new i(), isLandscapeMode(context2, false));
                    this.m0 = aVar2;
                    aVar2.setCancelable(false);
                    this.m0.show();
                    return;
                } catch (Exception e4) {
                    e = e4;
                }
            }
            e.printStackTrace();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        v();
    }

    private void d(com.igaworks.adpopcorn.cores.model.f fVar) {
        String str;
        String str2;
        g();
        if (fVar != null && fVar.d()) {
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            str = gVar.p;
            str2 = gVar.e;
        } else {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1656b, "ApRewardOfferWallLayout", "callbackJoinNewsCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    jSONObject.getString("NewsParticipatedTid");
                    this.M = jSONObject.getString("Auth");
                    if (z2) {
                        com.igaworks.adpopcorn.activity.b.g gVar2 = new com.igaworks.adpopcorn.activity.b.g(this.f1656b, this.o0, this.Q, this.d, new w());
                        this.T = gVar2;
                        gVar2.show();
                        this.T.setOnDismissListener(new x());
                    } else {
                        com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
                        a(gVar3.p, gVar3.e, false);
                    }
                    return;
                } catch (JSONException e2) {
                    com.igaworks.adpopcorn.cores.common.g gVar4 = this.d;
                    a(gVar4.p, gVar4.e, false);
                    e2.printStackTrace();
                    return;
                }
            }
            com.igaworks.adpopcorn.cores.common.g gVar5 = this.d;
            str = gVar5.Y;
            str2 = gVar5.g;
        }
        a(str, str2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        try {
            com.igaworks.adpopcorn.cores.common.h.a(this.f1656b, "ApRewardOfferWallLayout", "openWebBrowser = " + str, 3);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            this.f1656b.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    private void d(boolean z2) {
        try {
            g();
            d();
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            String str = gVar.I;
            String str2 = gVar.h;
            String str3 = gVar.v;
            String str4 = z2 ? gVar.U : gVar.e;
            Context context = this.f1656b;
            com.igaworks.adpopcorn.renewal.b.d.a aVar = new com.igaworks.adpopcorn.renewal.b.d.a(context, this.o0, str, str4, -1, str2, new o(), str3, new p(), isLandscapeMode(context, false));
            this.m0 = aVar;
            aVar.setCancelable(false);
            this.m0.setCanceledOnTouchOutside(false);
            this.m0.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.igaworks.adpopcorn.a.g.a aVar;
        String str;
        try {
            String str2 = this.M;
            com.igaworks.adpopcorn.cores.model.g gVar = this.Q;
            if (gVar == null) {
                com.igaworks.adpopcorn.cores.common.h.a(this.f1656b, "ApRewardOfferWallLayout", "completeNewsCampaign failed", 3);
                return;
            }
            String strY = gVar.y();
            com.igaworks.adpopcorn.cores.common.h.a(this.f1656b, "ApRewardOfferWallLayout", "completeNewsCampaign : " + strY, 3);
            if (this.V == null) {
                this.V = new com.igaworks.adpopcorn.a.g.a(this.f1656b);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", this.M);
            jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1656b));
            jSONObject.put("sign", com.igaworks.adpopcorn.cores.common.c.a(strY, str2));
            if (com.igaworks.adpopcorn.a.d.E) {
                aVar = this.V;
                str = "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/CompleteNewsCampaign";
            } else {
                aVar = this.V;
                str = "https://apapi.adpopcorn.com/ap/v1/common/conversion/CompleteNewsCampaign";
            }
            aVar.a(30, str, jSONObject, this);
        } catch (Exception e2) {
            e2.printStackTrace();
            com.igaworks.adpopcorn.cores.common.h.a(this.f1656b, "ApRewardOfferWallLayout", "completeNewsCampaign failed : " + e2.getMessage(), 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        a(((Integer) view.getTag()).intValue());
    }

    private void e(com.igaworks.adpopcorn.cores.model.f fVar) {
        String str;
        String str2;
        g();
        if (fVar != null && fVar.d()) {
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            str = gVar.p;
            str2 = gVar.e;
        } else {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1656b, "ApRewardOfferWallLayout", "callbackRewardAppExecute result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    int i2 = jSONObject.getInt("ResultCode");
                    String string = jSONObject.getString("ResultMsg");
                    if (z2) {
                        d(PointerIconCompat.TYPE_WAIT);
                        a(false, false);
                        com.igaworks.adpopcorn.a.d dVar = this.x;
                        if (dVar != null) {
                            dVar.c(false);
                            return;
                        }
                        return;
                    }
                    if (i2 == 2000) {
                        d(1005);
                    } else if (i2 != 2050) {
                        a(this.d.q, string, true);
                        return;
                    } else {
                        com.igaworks.adpopcorn.a.b.a().b(this.c, "participateFlag", this.K, false);
                    }
                    a(false, false);
                    return;
                } catch (JSONException e2) {
                    com.igaworks.adpopcorn.cores.common.g gVar2 = this.d;
                    a(gVar2.I, gVar2.p, true);
                    e2.printStackTrace();
                    return;
                }
            }
            com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
            str = gVar3.I;
            str2 = gVar3.g;
        }
        a(str, str2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        try {
            if (this.t0 == null) {
                WebView webView = new WebView(this.c);
                this.t0 = webView;
                webView.getSettings().setJavaScriptEnabled(true);
                this.t0.setWebChromeClient(new WebChromeClient());
                addView(this.t0);
                this.t0.setVisibility(4);
                this.t0.setWebViewClient(new z());
            }
            com.igaworks.adpopcorn.cores.common.h.a(this.f1656b, "ApRewardOfferWallLayout", "openWebViewBrowser = " + str, 3);
            this.t0.loadUrl(str);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void e(boolean z2) {
        try {
            com.igaworks.adpopcorn.renewal.b.c cVar = this.f0;
            if (cVar != null) {
                cVar.dismiss();
            }
            String strC = this.s.c();
            int i2 = Calendar.getInstance().get(6);
            int iA = com.igaworks.adpopcorn.a.b.a().a(this.f1656b, "adpopcorn_choice_impression_sp", strC, -1);
            if (!z2 || iA == i2) {
                com.igaworks.adpopcorn.cores.common.h.a(this.f1656b, "ApRewardOfferWallLayout", "Today AdpopcornChoiceAd already showed", 3);
                try {
                    ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList = this.o;
                    if (arrayList != null && arrayList.size() > 0) {
                        z();
                        if (this.w != null) {
                            com.igaworks.adpopcorn.cores.common.e.a(this.f1656b, this.o.get(0).T(), this.w, 0, 0, (com.igaworks.adpopcorn.cores.common.e.b) null);
                        }
                        com.igaworks.adpopcorn.renewal.layout.a aVar = this.u;
                        if (aVar != null) {
                            aVar.a(aVar, this.s);
                        }
                    }
                    com.igaworks.adpopcorn.renewal.a.a aVar2 = this.j;
                    if (aVar2 != null) {
                        aVar2.notifyDataSetInvalidated();
                    }
                } catch (Exception unused) {
                }
                com.igaworks.adpopcorn.renewal.layout.a aVar3 = this.u;
                if (aVar3 != null) {
                    aVar3.a(aVar3, this.f1656b, this.s, false, this.s0, 0);
                    this.u.setOnClickListener(new h0());
                }
            } else {
                com.igaworks.adpopcorn.renewal.b.c cVar2 = new com.igaworks.adpopcorn.renewal.b.c(this.f1656b, this.o0, this.a, this.s, new View.OnClickListener() { // from class: com.igaworks.adpopcorn.renewal.layout.-$$Lambda$ApRewardOfferWallLayout$o9OASNWoU8cCTVdwOWgETFbm9NM
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.f(view);
                    }
                });
                this.f0 = cVar2;
                cVar2.show();
                this.f0.setCancelable(true);
                this.f0.setOnDismissListener(new g0());
                if (this.w != null) {
                    com.igaworks.adpopcorn.cores.common.e.a(this.f1656b, this.o.get(0).T(), this.w, 0, 0, (com.igaworks.adpopcorn.cores.common.e.b) null);
                }
            }
            this.v = true;
            com.igaworks.adpopcorn.a.b.a().b(this.f1656b, "adpopcorn_choice_impression_sp", strC, i2);
        } catch (Exception unused2) {
        }
    }

    private void f() {
        if (this.F == null) {
            this.F = new Handler(Looper.getMainLooper());
        }
        if (this.G == null) {
            this.G = new i0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        try {
            com.igaworks.adpopcorn.renewal.b.c cVar = this.f0;
            if (cVar != null) {
                cVar.dismiss();
            }
            com.igaworks.adpopcorn.cores.model.g gVar = this.s;
            this.Q = gVar;
            this.I = gVar.K();
            this.L = this.Q.a();
            this.K = this.Q.c();
            showProgressDialog(this.d.s, false);
            this.x.b("media_offerwall_tab_content_click", this.K);
            this.w0 = 2;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", this.L);
            jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1656b));
            this.V.a(2, this.y, jSONObject, this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void f(com.igaworks.adpopcorn.cores.model.f fVar) {
        String str;
        String str2;
        com.igaworks.adpopcorn.a.b bVarA;
        Context context;
        com.igaworks.adpopcorn.cores.model.g gVar;
        g();
        if (fVar == null || !fVar.d()) {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1656b, "ApRewardOfferWallLayout", "callbackRewardAppInstall result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    int i2 = jSONObject.getInt("ResultCode");
                    String string = jSONObject.getString("ResultMsg");
                    if (z2) {
                        if (this.I != 23) {
                            d(PointerIconCompat.TYPE_WAIT);
                            com.igaworks.adpopcorn.a.b.a().b(this.f1656b, this.Q.c());
                            a(false, false);
                            com.igaworks.adpopcorn.a.d dVar = this.x;
                            if (dVar != null) {
                                dVar.c(false);
                                return;
                            }
                            return;
                        }
                        bVarA = com.igaworks.adpopcorn.a.b.a();
                        context = this.f1656b;
                        gVar = this.Q;
                    } else {
                        if (this.I != 23) {
                            if (i2 == 2000) {
                                d(1005);
                                com.igaworks.adpopcorn.a.b.a().b(this.f1656b, this.Q.c());
                            } else {
                                if (i2 != 2050) {
                                    a(this.d.q, string, true);
                                    return;
                                }
                                com.igaworks.adpopcorn.a.b.a().b(this.c, "participateFlag", this.K, false);
                            }
                            a(false, false);
                            return;
                        }
                        if (i2 != 2000) {
                            if (i2 == 2050) {
                                com.igaworks.adpopcorn.a.b.a().b(this.c, "participateFlag", this.K, false);
                                return;
                            }
                            return;
                        } else {
                            bVarA = com.igaworks.adpopcorn.a.b.a();
                            context = this.f1656b;
                            gVar = this.Q;
                        }
                    }
                    bVarA.b(context, gVar.c());
                    return;
                } catch (JSONException e2) {
                    if (this.I != 23) {
                        com.igaworks.adpopcorn.cores.common.g gVar2 = this.d;
                        a(gVar2.I, gVar2.p, true);
                    }
                    e2.printStackTrace();
                    return;
                }
            }
            if (this.I == 23) {
                return;
            }
            com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
            str = gVar3.I;
            str2 = gVar3.g;
        } else {
            if (this.I == 23) {
                return;
            }
            com.igaworks.adpopcorn.cores.common.g gVar4 = this.d;
            str = gVar4.p;
            str2 = gVar4.e;
        }
        a(str, str2, false);
    }

    private void f(boolean z2) {
        try {
            g();
            d();
            String str = this.d.I;
            String str2 = this.d.f + this.d.d0;
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            String str3 = gVar.h;
            String str4 = gVar.G;
            String str5 = z2 ? this.d.n0 + "\n" + this.d.d0 : str2;
            Context context = this.f1656b;
            com.igaworks.adpopcorn.renewal.b.d.a aVar = new com.igaworks.adpopcorn.renewal.b.d.a(context, this.o0, str, str5, -1, str3, new e(), str4, new f(), isLandscapeMode(context, false));
            this.m0 = aVar;
            aVar.setCancelable(false);
            this.m0.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            com.igaworks.adpopcorn.renewal.b.d.c cVar = this.n0;
            if (cVar != null) {
                cVar.dismiss();
                this.n0 = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void g(com.igaworks.adpopcorn.cores.model.f fVar) {
        com.igaworks.adpopcorn.cores.model.j jVarA;
        if (fVar != null && fVar.d()) {
            d(true);
        } else if (fVar != null && fVar.a().length() > 0) {
            try {
                com.igaworks.adpopcorn.cores.common.h.a(this.f1656b, "ApRewardOfferWallLayout", "callbackVideoAdDetailInfoRequest result = " + fVar.a(), 3);
                if (new JSONObject(fVar.a()).getBoolean("Result") && (jVarA = com.igaworks.adpopcorn.a.f.f.a(fVar.a())) != null) {
                    a(this.Q.c(), this.M, jVarA.c(), jVarA.h(), jVarA.e(), jVarA.f(), jVarA.g(), jVarA.j(), jVarA.k(), jVarA.l(), jVarA.r(), jVarA.a(), jVarA.s(), this.Q.P(), jVarA.o(), jVarA.q(), jVarA.i(), this.Q.N());
                    return;
                }
            } catch (JSONException unused) {
            }
        }
        d(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Activity activity;
        try {
            if (this.p0 || (activity = this.r0) == null) {
                return;
            }
            activity.finish();
            this.r0.overridePendingTransition(0, 0);
            com.igaworks.adpopcorn.a.d dVar = this.x;
            if (dVar != null) {
                dVar.c((String) null);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        String str;
        if (com.igaworks.adpopcorn.a.d.E) {
            this.y = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/checkcampaign";
            this.z = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/joincampaign";
            this.A = "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/completeinstallcampaign";
            this.B = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/video/getrewardvideodetail";
            this.C = "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/completeexecutecampaign";
            this.D = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/joincpmcampaign";
            str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/joinnewscampaign";
        } else {
            this.y = "https://apapi.adpopcorn.com/ap/v1/sdk/media/checkcampaign";
            this.z = "https://apapi.adpopcorn.com/ap/v1/sdk/media/joincampaign";
            this.A = "https://apapi.adpopcorn.com/ap/v1/common/conversion/completeinstallcampaign";
            this.B = "https://apapi.adpopcorn.com/ap/v1/sdk/video/getrewardvideodetail";
            this.C = "https://apapi.adpopcorn.com/ap/v1/common/conversion/completeexecutecampaign";
            this.D = "https://apapi.adpopcorn.com/ap/v1/sdk/media/joincpmcampaign";
            str = "https://apapi.adpopcorn.com/ap/v1/sdk/media/joinnewscampaign";
        }
        this.E = str;
    }

    private void j() {
        this.W = false;
        this.a0 = false;
        this.c0 = 1;
        int i2 = Calendar.getInstance().get(6);
        long jA = com.igaworks.adpopcorn.a.b.a().a(this.f1656b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_quantity", 0L);
        if (com.igaworks.adpopcorn.a.b.a().a(this.f1656b, "adpopcorn_news_sp", "adpopcorn_news_imp_day", 0) != i2) {
            com.igaworks.adpopcorn.a.b.a().b(this.f1656b);
        }
        com.igaworks.adpopcorn.a.b.a().b(this.f1656b, "adpopcorn_news_sp", "adpopcorn_news_imp_day", i2);
        if (i2 == com.igaworks.adpopcorn.a.b.a().a(this.f1656b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_imp_day", 0)) {
            this.d1 = true;
        }
        if (this.a0 || this.c0 > this.d0) {
            c(true);
        } else {
            com.igaworks.adpopcorn.cores.common.h.a(this.f1656b, "ApRewardOfferWallLayout", "initCampaignLoading", 3);
            if (com.igaworks.adpopcorn.cores.common.c.c(this.f1656b)) {
                if (jA == 0 || this.d1) {
                    showProgressDialog(this.d.f1613b, false);
                }
                if (!this.e.i()) {
                    this.V.a(this.c0, this);
                }
            } else {
                com.igaworks.adpopcorn.cores.common.g gVar = this.d;
                b(gVar.g, gVar.h, true);
            }
        }
        try {
            if (this.d1 || jA <= 0) {
                return;
            }
            com.igaworks.adpopcorn.renewal.b.e eVar = new com.igaworks.adpopcorn.renewal.b.e(this.f1656b, jA, com.igaworks.adpopcorn.a.b.a().a(this.f1656b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_currency", ""), this.o0);
            eVar.show();
            eVar.setOnDismissListener(new c0());
            com.igaworks.adpopcorn.a.b.a().b(this.f1656b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_imp_day", i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void k() {
        com.igaworks.adpopcorn.renewal.layout.a aVarA;
        this.f = new FrameLayout(this.c);
        this.f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f.setBackgroundColor(Color.parseColor("#ffffff"));
        this.g = new LinearLayout(this.c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.g.setOrientation(1);
        this.g.setBackgroundColor(Color.parseColor("#ffffff"));
        this.g.setLayoutParams(layoutParams);
        this.f.addView(this.g);
        this.f.addView(c(this.b1));
        int i2 = this.X0;
        int iA = com.igaworks.adpopcorn.cores.common.d.a(this.c, (this.Y0 + this.Z0) - 12);
        if (this.p0) {
            aVarA = com.igaworks.adpopcorn.renewal.layout.a.a(this.f1656b, iA);
        } else {
            Context context = this.f1656b;
            aVarA = com.igaworks.adpopcorn.renewal.layout.a.a(context, com.igaworks.adpopcorn.cores.common.d.a(context, i2) + iA);
        }
        this.u = aVarA;
        this.u.setVisibility(8);
        this.f.addView(this.u);
        if (!this.p0) {
            this.g.addView(m());
        }
        LinearLayout linearLayout = new LinearLayout(this.c);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.f1656b, this.b1)));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        if (isLandscapeMode(this.f1656b, false)) {
            com.igaworks.adpopcorn.activity.c.e eVar = new com.igaworks.adpopcorn.activity.c.e(this.c);
            this.l = eVar;
            eVar.setLayoutParams(layoutParams2);
            this.l.setSelector(new StateListDrawable());
            this.l.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.f1656b, 14), 0, com.igaworks.adpopcorn.cores.common.d.a(this.f1656b, 14), 0);
            this.l.setNumColumns(2);
            this.l.setHorizontalSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.f1656b, 8));
            this.l.b(q());
            this.l.a(linearLayout);
            this.g.addView(this.l);
            this.j = new com.igaworks.adpopcorn.renewal.a.a(this.c, this.n, this.d, true, this.K0, this.L0);
            this.l.setOnItemClickListener(this.f1);
            this.l.setOnScrollListener(this.g1);
            this.l.setOverScrollMode(2);
            this.f.addView(r());
        } else {
            com.igaworks.adpopcorn.activity.c.e eVar2 = new com.igaworks.adpopcorn.activity.c.e(this.c);
            this.k = eVar2;
            eVar2.setVerticalScrollBarEnabled(false);
            this.k.setLayoutParams(layoutParams2);
            this.k.setSelector(new StateListDrawable());
            this.k.setNumColumns(1);
            this.k.setHorizontalSpacing(0);
            this.k.setVerticalSpacing(0);
            this.k.b(q());
            this.g.addView(this.k);
            this.k.a(linearLayout);
            this.f.addView(r());
            this.j = new com.igaworks.adpopcorn.renewal.a.a(this.c, this.n, this.d, false, this.K0, this.L0);
            this.k.setSelector(new StateListDrawable());
            this.k.setOnItemClickListener(this.f1);
            this.k.setOnScrollListener(this.g1);
            this.k.setOverScrollMode(2);
        }
        addView(this.f);
    }

    private void l() {
        com.igaworks.adpopcorn.a.d dVarA = com.igaworks.adpopcorn.a.d.a(this.f1656b);
        this.x = dVarA;
        this.e = dVarA.e();
        com.igaworks.adpopcorn.cores.common.e.b(this.f1656b);
        if (!this.s0) {
            com.igaworks.adpopcorn.cores.common.d.a();
        }
        com.igaworks.adpopcorn.cores.common.d.a((Activity) this.f1656b);
        com.igaworks.adpopcorn.cores.common.g gVarA = com.igaworks.adpopcorn.cores.common.g.a();
        this.d = gVarA;
        gVarA.d();
        this.c0 = 1;
        this.a0 = false;
        this.l0 = false;
        this.b0 = false;
        this.v = false;
        this.w0 = 1;
        this.c1 = 0;
        this.n = new ArrayList<>();
        this.o = new ArrayList<>();
        this.p = new ArrayList<>();
        this.q = new ArrayList<>();
        this.r = new com.igaworks.adpopcorn.cores.model.g();
        this.u0 = new ArrayList<>();
        this.v0 = new ArrayList<>();
        this.a = ((WindowManager) this.f1656b.getSystemService("window")).getDefaultDisplay().getWidth();
        if (this.V == null) {
            this.V = new com.igaworks.adpopcorn.a.g.a(this.f1656b);
        }
        this.o0 = com.igaworks.adpopcorn.renewal.b.d.a(this.f1656b);
        com.igaworks.adpopcorn.a.b.a().b(this.f1656b, "adpopcorn_sdk_flag", "isAdPopcornUser", true);
        f();
        try {
            int i2 = Calendar.getInstance().get(6);
            if (i2 != com.igaworks.adpopcorn.a.b.a().a(this.f1656b, "adpopcorn_sdk_flag", "adpopcorn_last_visit_day", -1)) {
                com.igaworks.adpopcorn.a.b.a().e(this.f1656b, "adpopcorn_choice_impression_sp");
                com.igaworks.adpopcorn.a.b.a().b(this.f1656b, "adpopcorn_sdk_flag", "adpopcorn_last_visit_day", i2);
            }
        } catch (Exception unused) {
        }
        this.X0 = this.k0 ? 44 : 46;
        this.Y0 = 42;
        this.Z0 = 48;
        this.a1 = 42;
        this.b1 = 38;
    }

    private RelativeLayout m() {
        com.igaworks.adpopcorn.renewal.layout.b bVar = new com.igaworks.adpopcorn.renewal.layout.b(this.c, this.X0);
        bVar.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.f1656b, this.X0)));
        ImageView imageView = (ImageView) bVar.findViewById(0);
        LinearLayout linearLayout = (LinearLayout) bVar.findViewById(1);
        ImageView imageView2 = (ImageView) bVar.findViewById(2);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.igaworks.adpopcorn.renewal.layout.-$$Lambda$ApRewardOfferWallLayout$8N2OF9-5vIURJlcoDvzxew3fsVE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.b(view);
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.igaworks.adpopcorn.renewal.layout.-$$Lambda$ApRewardOfferWallLayout$JDwYJnfPleWBv4deahlW5dIDlc0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.c(view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.igaworks.adpopcorn.renewal.layout.-$$Lambda$ApRewardOfferWallLayout$yrDqwgTPNAp-2Ake8VkghZ858qA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.d(view);
            }
        });
        if (this.q0) {
            imageView.setVisibility(4);
            linearLayout.setVisibility(4);
        }
        return bVar;
    }

    private LinearLayout n() {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout linearLayout;
        this.x0 = new LinearLayout(this.c);
        try {
            if (this.k0) {
                layoutParams = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, this.a1 - 12));
                layoutParams.gravity = 49;
                layoutParams.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.c, 6);
                this.x0.setOrientation(0);
                linearLayout = this.x0;
            } else {
                layoutParams = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, this.a1));
                layoutParams.gravity = 17;
                this.x0.setOrientation(0);
                linearLayout = this.x0;
            }
            linearLayout.setGravity(17);
            this.x0.setLayoutParams(layoutParams);
            this.x0.setBackgroundColor(Color.parseColor("#ffffff"));
            this.D0 = new TextView(this.c);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
            layoutParams2.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.c, 16);
            this.D0.setLayoutParams(layoutParams2);
            this.D0.setGravity(19);
            this.D0.setSingleLine();
            this.x0.addView(this.D0);
        } catch (Exception unused) {
        }
        return this.x0;
    }

    private LinearLayout o() {
        char c2;
        FrameLayout.LayoutParams layoutParams;
        int paintFlags;
        List<ImageView> list;
        this.A0 = new LinearLayout(this.c);
        LinearLayout linearLayout = new LinearLayout(this.c);
        this.C0 = new HorizontalScrollView(this.c);
        this.z0 = new LinearLayout(this.c);
        LinearLayout linearLayout2 = new LinearLayout(this.c);
        this.B0 = new HorizontalScrollView(this.c);
        try {
            int tabCount = this.Q0.getTabCount();
            int i2 = this.X0;
            int i3 = 0;
            if (this.p0) {
                i2 = 0;
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            this.A0.setOrientation(1);
            int i4 = 17;
            this.A0.setGravity(17);
            this.A0.setLayoutParams(layoutParams2);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, this.Y0));
            int i5 = 49;
            layoutParams3.gravity = 49;
            layoutParams3.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.c, i2);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            linearLayout.setLayoutParams(layoutParams3);
            linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            this.A0.addView(linearLayout);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
            this.z0.setOrientation(1);
            this.z0.setGravity(17);
            this.z0.setLayoutParams(layoutParams4);
            ViewGroup.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, this.Y0));
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(17);
            linearLayout2.setLayoutParams(layoutParams5);
            linearLayout2.setBackgroundColor(Color.parseColor("#ffffff"));
            this.z0.addView(linearLayout2);
            List<TextView> list2 = this.E0;
            if (list2 == null) {
                this.E0 = new ArrayList();
            } else {
                list2.clear();
            }
            List<TextView> list3 = this.F0;
            if (list3 == null) {
                this.F0 = new ArrayList();
            } else {
                list3.clear();
            }
            List<ImageView> list4 = this.I0;
            if (list4 == null) {
                this.I0 = new ArrayList();
            } else {
                list4.clear();
            }
            List<ImageView> list5 = this.J0;
            if (list5 == null) {
                this.J0 = new ArrayList();
            } else {
                list5.clear();
            }
            List<TextView> list6 = this.G0;
            if (list6 == null) {
                this.G0 = new ArrayList();
            } else {
                list6.clear();
            }
            List<TextView> list7 = this.H0;
            if (list7 == null) {
                this.H0 = new ArrayList();
            } else {
                list7.clear();
            }
            int i6 = 0;
            while (i6 < 2) {
                int i7 = i3;
                while (i7 < tabCount) {
                    FrameLayout frameLayout = new FrameLayout(this.c);
                    LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(i3, com.igaworks.adpopcorn.cores.common.d.a(this.c, this.Y0), 1.0f);
                    layoutParams6.gravity = i5;
                    frameLayout.setLayoutParams(layoutParams6);
                    frameLayout.setTag(Integer.valueOf(i7));
                    frameLayout.setOnClickListener(new b());
                    TextView textView = new TextView(this.c);
                    textView.setLayoutParams(new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, this.Y0)));
                    textView.setGravity(i4);
                    com.igaworks.adpopcorn.cores.common.k.a(textView, this.Q0.getTabTitle(i7), 16, Color.parseColor("#212529"), null, 0, 1, TextUtils.TruncateAt.END, false);
                    textView.setTag(Integer.valueOf(i7));
                    frameLayout.addView(textView);
                    ImageView imageView = new ImageView(this.c);
                    imageView.setTag(Integer.valueOf(i7));
                    if (i7 == 0) {
                        c2 = 2;
                        layoutParams = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, 2));
                        textView.setTextColor(Color.parseColor("#212529"));
                        imageView.setBackgroundColor(Color.parseColor("#212529"));
                        textView.setTypeface(textView.getTypeface(), 1);
                        paintFlags = textView.getPaintFlags() | 32;
                    } else {
                        c2 = 2;
                        layoutParams = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, 1.0f));
                        textView.setTextColor(Color.parseColor("#808C99"));
                        imageView.setBackgroundColor(Color.parseColor("#F1F2F4"));
                        textView.setTypeface(null, 0);
                        paintFlags = textView.getPaintFlags() ^ 32;
                    }
                    textView.setPaintFlags(paintFlags);
                    layoutParams.gravity = 80;
                    imageView.setLayoutParams(layoutParams);
                    frameLayout.addView(imageView);
                    if (i6 == 0) {
                        linearLayout.addView(frameLayout);
                        this.F0.add(textView);
                        list = this.J0;
                    } else {
                        linearLayout2.addView(frameLayout);
                        this.E0.add(textView);
                        list = this.I0;
                    }
                    list.add(imageView);
                    i7++;
                    i3 = 0;
                    i5 = 49;
                    i4 = 17;
                }
                i6++;
                i3 = 0;
                i5 = 49;
                i4 = 17;
            }
            FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, this.Z0));
            this.C0.setLayoutParams(layoutParams7);
            this.C0.setVisibility(8);
            this.C0.setHorizontalScrollBarEnabled(false);
            this.C0.setBackgroundColor(Color.parseColor("#ffffff"));
            this.A0.addView(this.C0);
            this.B0.setLayoutParams(layoutParams7);
            this.B0.setVisibility(8);
            this.B0.setHorizontalScrollBarEnabled(false);
            this.B0.setBackgroundColor(Color.parseColor("#ffffff"));
            this.z0.addView(this.B0);
            this.z0.invalidate();
            this.A0.invalidate();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f.addView(this.A0);
        return this.z0;
    }

    private View p() {
        try {
            LinearLayout linearLayout = this.h0;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
                this.h0 = null;
            }
            com.igaworks.adpopcorn.renewal.layout.c cVar = new com.igaworks.adpopcorn.renewal.layout.c(this.c, this.a, isLandscapeMode(this.f1656b, false), new a());
            this.g0 = cVar;
            this.h0 = (LinearLayout) cVar.findViewById(0);
            this.i0 = (ViewFlipper) this.g0.findViewById(1);
            this.j0 = (TextView) this.g0.findViewById(2);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setFillAfter(true);
            translateAnimation.setDuration(1000L);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation2.setFillAfter(false);
            translateAnimation2.setDuration(1000L);
            this.i0.setInAnimation(translateAnimation);
            this.i0.setOutAnimation(translateAnimation2);
            return this.g0;
        } catch (Exception e2) {
            e2.printStackTrace();
            View view = new View(this.c);
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
            return view;
        }
    }

    private LinearLayout q() {
        this.y0 = new LinearLayout(this.c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.y0.setOrientation(1);
        this.y0.setGravity(17);
        this.y0.setLayoutParams(layoutParams);
        this.y0.setBackgroundColor(Color.parseColor("#ffffff"));
        this.y0.addView(p());
        this.y0.addView(o());
        this.y0.addView(n());
        return this.y0;
    }

    private LinearLayout r() {
        this.V0 = new LinearLayout(this.c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, this.b1));
        layoutParams.gravity = 80;
        this.V0.setLayoutParams(layoutParams);
        this.V0.setBackgroundColor(Color.parseColor("#F8F9FA"));
        this.V0.setOrientation(0);
        this.V0.setGravity(16);
        TextView textView = new TextView(this.c);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams2.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1656b, 16);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(19);
        com.igaworks.adpopcorn.cores.common.k.a(textView, "Adpopcorn All Rights Reserved", 12, Color.parseColor("#9CA6AF"), null, 0, 1, TextUtils.TruncateAt.END, false);
        textView.setOnClickListener(new d0());
        TextView textView2 = new TextView(this.c);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1656b, 16);
        textView2.setLayoutParams(layoutParams3);
        textView2.setGravity(17);
        com.igaworks.adpopcorn.cores.common.k.a(textView2, this.d.X, 12, Color.parseColor("#9CA6AF"), null, 0, 1, TextUtils.TruncateAt.END, false);
        textView2.setOnClickListener(new e0());
        this.V0.addView(textView);
        this.V0.addView(textView2);
        return this.V0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        try {
            d();
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            String str = gVar.I;
            String str2 = gVar.W;
            String str3 = gVar.z;
            String str4 = gVar.y;
            Context context = this.f1656b;
            com.igaworks.adpopcorn.renewal.b.d.a aVar = new com.igaworks.adpopcorn.renewal.b.d.a(context, this.o0, str, str2, -1, str3, new q(), str4, new r(), isLandscapeMode(context, false));
            this.m0 = aVar;
            aVar.setCancelable(false);
            this.m0.show();
        } catch (Exception unused) {
        }
    }

    private void t() {
        try {
            List<com.igaworks.adpopcorn.cores.model.i> list = this.R0;
            if (list == null) {
                return;
            }
            if (list.get(this.U0).a() == 0) {
                a(false, false);
                return;
            }
            if (this.n.size() != 0) {
                this.n.clear();
            }
            int iA = this.R0.get(this.U0).a();
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                com.igaworks.adpopcorn.cores.model.g gVar = this.m.get(i2);
                if (gVar.U() == iA) {
                    this.n.add(gVar);
                }
            }
            this.j.notifyDataSetInvalidated();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        int i2;
        try {
            HorizontalScrollView horizontalScrollView = this.C0;
            if (horizontalScrollView != null) {
                horizontalScrollView.removeAllViews();
            }
            HorizontalScrollView horizontalScrollView2 = this.B0;
            if (horizontalScrollView2 != null) {
                horizontalScrollView2.removeAllViews();
            }
            List<TextView> list = this.G0;
            if (list == null) {
                this.G0 = new ArrayList();
            } else {
                list.clear();
            }
            List<TextView> list2 = this.H0;
            if (list2 == null) {
                this.H0 = new ArrayList();
            } else {
                list2.clear();
            }
            this.U0 = 0;
            int i3 = 0;
            while (i3 < 2) {
                LinearLayout linearLayout = new LinearLayout(this.c);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
                linearLayout.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.c, 16), 0, com.igaworks.adpopcorn.cores.common.d.a(this.c, 8), 0);
                linearLayout.setGravity(16);
                linearLayout.setOrientation(0);
                (i3 == 0 ? this.C0 : this.B0).addView(linearLayout);
                for (int i4 = 0; i4 < this.R0.size(); i4++) {
                    TextView textView = new TextView(this.c);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.c, 28));
                    layoutParams.gravity = 16;
                    layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.c, 8);
                    textView.setLayoutParams(layoutParams);
                    textView.setGravity(17);
                    if (i4 == 0) {
                        com.igaworks.adpopcorn.cores.common.k.a(textView, this.R0.get(i4).b(), 14, Color.parseColor("#ffffff"), null, 0, 1, TextUtils.TruncateAt.END, false);
                        i2 = R.drawable.ap_reward_subtab_select_round_bg;
                    } else {
                        com.igaworks.adpopcorn.cores.common.k.a(textView, this.R0.get(i4).b(), 14, Color.parseColor("#808C99"), null, 0, 1, TextUtils.TruncateAt.END, false);
                        i2 = R.drawable.ap_reward_subtab_unselect_round_bg;
                    }
                    textView.setBackgroundResource(i2);
                    textView.setTag(Integer.valueOf(i4));
                    linearLayout.addView(textView);
                    textView.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.c, 10), 0, com.igaworks.adpopcorn.cores.common.d.a(this.c, 10), 0);
                    (i3 == 0 ? this.H0 : this.G0).add(textView);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.igaworks.adpopcorn.renewal.layout.-$$Lambda$ApRewardOfferWallLayout$V-wMu4ml1uH9KMiOGd4j0u0mkbs
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.e(view);
                        }
                    });
                }
                i3++;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        try {
            boolean z2 = this.o0 == 16973841;
            Context context = this.f1656b;
            com.igaworks.adpopcorn.renewal.b.a aVar = new com.igaworks.adpopcorn.renewal.b.a(context, this.o0, isLandscapeMode(context, false), this.d, z2, this);
            this.S = aVar;
            aVar.setOnDismissListener(new f0());
            this.S.show();
            A();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void w() {
        g();
        try {
            com.igaworks.adpopcorn.renewal.b.b bVar = new com.igaworks.adpopcorn.renewal.b.b(this.f1656b, this.o0, this.Q, this.d, this.k0, this.e1);
            this.R = bVar;
            bVar.show();
            this.R.setOnDismissListener(new j());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ int x(ApRewardOfferWallLayout apRewardOfferWallLayout) {
        int i2 = apRewardOfferWallLayout.c0;
        apRewardOfferWallLayout.c0 = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        TextView textView;
        int i2;
        try {
            if (this.h == null) {
                this.h = new TextView(this.c);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                this.h.setLayoutParams(layoutParams);
                this.h.setGravity(17);
                com.igaworks.adpopcorn.cores.common.k.a(this.h, "Test Mode", 20, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_THEME_COLOR), null, 0, 1, TextUtils.TruncateAt.END, false);
                this.f.addView(this.h);
            }
            if (com.igaworks.adpopcorn.a.d.E) {
                textView = this.h;
                i2 = 0;
            } else {
                textView = this.h;
                i2 = 4;
            }
            textView.setVisibility(i2);
        } catch (Exception unused) {
        }
    }

    private void y() {
        com.igaworks.adpopcorn.a.b bVarA;
        try {
            if (this.c0 != 1 || this.N0 <= 0) {
                return;
            }
            try {
                com.igaworks.adpopcorn.cores.common.k.a(this.D0, String.format(this.d.H2, new DecimalFormat("###,###").format(this.N0)), 14, Color.parseColor("#212529"), null, 0, 0, TextUtils.TruncateAt.END, false);
                this.x0.setVisibility(0);
                com.igaworks.adpopcorn.a.b.a().b(this.f1656b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_quantity", this.N0);
                bVarA = com.igaworks.adpopcorn.a.b.a();
            } catch (Exception unused) {
                com.igaworks.adpopcorn.cores.common.k.a(this.D0, String.format(this.d.H2, ""), 14, Color.parseColor("#212529"), null, 0, 0, TextUtils.TruncateAt.END, false);
                this.x0.setVisibility(0);
                com.igaworks.adpopcorn.a.b.a().b(this.f1656b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_quantity", this.N0);
                bVarA = com.igaworks.adpopcorn.a.b.a();
            } catch (Throwable th) {
                com.igaworks.adpopcorn.cores.common.k.a(this.D0, String.format(this.d.H2, ""), 14, Color.parseColor("#212529"), null, 0, 0, TextUtils.TruncateAt.END, false);
                this.x0.setVisibility(0);
                com.igaworks.adpopcorn.a.b.a().b(this.f1656b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_quantity", this.N0);
                com.igaworks.adpopcorn.a.b.a().b(this.f1656b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_currency", this.O0);
                throw th;
            }
            bVarA.b(this.f1656b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_currency", this.O0);
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        try {
            Handler handler = this.F;
            if (handler != null) {
                handler.removeCallbacks(this.G);
                this.F.postDelayed(this.G, 5000L);
            }
        } catch (Exception unused) {
        }
    }

    public void destroy() {
        try {
            g();
            A();
            if (this.G != null) {
                this.G = null;
            }
            Dialog dialog = this.R;
            if (dialog != null && dialog.isShowing()) {
                this.R.dismiss();
                this.R = null;
            }
            Dialog dialog2 = this.S;
            if (dialog2 != null && dialog2.isShowing()) {
                this.S.dismiss();
                this.S = null;
            }
            com.igaworks.adpopcorn.renewal.b.c cVar = this.f0;
            if (cVar != null && cVar.isShowing()) {
                this.f0.dismiss();
                this.f0 = null;
            }
            HashMap<String, String> map = this.U;
            if (map != null && map.size() > 0) {
                this.U.clear();
                this.U = null;
            }
            com.igaworks.adpopcorn.renewal.a.a aVar = this.j;
            if (aVar != null) {
                aVar.a();
            }
            WebView webView = this.t0;
            if (webView != null) {
                webView.destroy();
                this.t0 = null;
            }
            com.igaworks.adpopcorn.a.a.a();
            com.igaworks.adpopcorn.cores.common.e.a(this.f1656b);
            com.igaworks.adpopcorn.cores.common.i.a(this);
        } catch (Exception unused) {
        }
    }

    public void exitOfferwall() {
        try {
            com.igaworks.adpopcorn.a.d dVar = this.x;
            if (dVar != null) {
                dVar.c((String) null);
            }
            Activity activity = this.r0;
            if (activity == null) {
                onCustomConfigurationChanged(new Configuration());
            } else {
                activity.finish();
                this.r0.overridePendingTransition(0, 0);
            }
        } catch (Exception unused) {
        }
    }

    public int getOfferwallType() {
        return this.K0;
    }

    public void initOfferwallLayout(boolean z2, boolean z3) {
        this.p0 = z2;
        this.q0 = z3;
        try {
            l();
            i();
            k();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean isLandscapeMode(Context context, boolean z2) {
        Activity activity;
        if (Build.VERSION.SDK_INT >= 24 && (activity = this.r0) != null && activity.isInMultiWindowMode()) {
            return false;
        }
        if (!z2) {
            return this.k0;
        }
        Configuration configuration = ((Activity) context).getResources().getConfiguration();
        return configuration != null && configuration.orientation == 2;
    }

    public void onCustomConfigurationChanged(Configuration configuration) {
        try {
            if (!this.s0) {
                com.igaworks.adpopcorn.cores.common.d.a();
            }
            com.igaworks.adpopcorn.cores.common.d.a((Activity) this.f1656b);
            this.a = ((WindowManager) this.f1656b.getSystemService("window")).getDefaultDisplay().getWidth();
            this.c0 = 1;
            this.a0 = false;
            this.v = false;
            this.w0 = 1;
            i();
            Dialog dialog = this.R;
            if (dialog != null && dialog.isShowing()) {
                this.R.dismiss();
                this.R = null;
            }
            com.igaworks.adpopcorn.renewal.b.c cVar = this.f0;
            if (cVar != null && cVar.isShowing()) {
                this.f0.dismiss();
                this.f0 = null;
            }
            Dialog dialog2 = this.S;
            if (dialog2 != null && dialog2.isShowing()) {
                this.S.dismiss();
                this.S = null;
            }
            com.igaworks.adpopcorn.activity.b.g gVar = this.T;
            if (gVar != null && gVar.isShowing()) {
                this.T.dismiss();
                this.T = null;
            }
            A();
            removeAllViewsInLayout();
            removeAllViews();
            invalidate();
            k();
            resume(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.igaworks.adpopcorn.a.g.a.d
    public void onNetResponseListener(int i2, com.igaworks.adpopcorn.cores.model.f fVar) {
        if (i2 == 11) {
            g(fVar);
        }
        if (i2 == 19) {
            e(fVar);
            return;
        }
        if (i2 == 27) {
            b(fVar);
            return;
        }
        if (i2 == 29) {
            d(fVar);
            return;
        }
        switch (i2) {
            case 0:
            case 2:
                a(i2, fVar);
                break;
            case 1:
                c(fVar);
                break;
            case 3:
            case 4:
                b(i2, fVar);
                break;
            case 5:
                f(fVar);
                break;
            case 6:
                a(fVar);
                break;
        }
    }

    public void pause() {
        try {
            com.igaworks.adpopcorn.activity.b.g gVar = this.T;
            if (gVar == null || !gVar.isShowing()) {
                return;
            }
            this.T.j();
        } catch (Exception unused) {
        }
    }

    public void resume() {
        resume(false);
    }

    public void resume(boolean z2) {
        Activity activity;
        try {
            Dialog dialog = this.S;
            if (dialog == null || !dialog.isShowing()) {
                this.M0 = false;
                if (Build.VERSION.SDK_INT >= 24 && (activity = this.r0) != null && activity.isInMultiWindowMode()) {
                    this.M0 = true;
                }
                if (this.M0 && (com.igaworks.adpopcorn.cores.common.d.c() <= com.igaworks.adpopcorn.cores.common.d.a(this.f1656b, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO) || com.igaworks.adpopcorn.cores.common.d.b() <= com.igaworks.adpopcorn.cores.common.d.a(this.f1656b, 260))) {
                    Toast.makeText(this.f1656b, this.d.w1, 1).show();
                    h();
                    return;
                }
                com.igaworks.adpopcorn.activity.b.g gVar = this.T;
                if (gVar != null && gVar.isShowing()) {
                    this.T.k();
                    return;
                }
                com.igaworks.adpopcorn.a.d dVar = this.x;
                if (dVar != null) {
                    dVar.c(false);
                }
                if (com.igaworks.adpopcorn.a.b.a().a(this.f1656b, "adpopcorn_parameter", "check_user_agreement", false)) {
                    j();
                    return;
                }
                d();
                com.igaworks.adpopcorn.cores.common.g gVar2 = this.d;
                String str = gVar2.Z0;
                String str2 = gVar2.l1;
                String str3 = gVar2.k1;
                Context context = this.f1656b;
                com.igaworks.adpopcorn.renewal.b.d.b bVar = new com.igaworks.adpopcorn.renewal.b.d.b(context, this.o0, str, "", -1, str2, new k(), str3, new l(z2), isLandscapeMode(context, false));
                this.m0 = bVar;
                bVar.setCancelable(false);
                this.m0.show();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setApOfferWallOrientation(boolean z2) {
        this.k0 = z2;
    }

    public void setCustomViewMode(boolean z2) {
        this.s0 = z2;
    }

    public void setFilterCampaignKeyList(List<String> list) {
        this.W0 = list;
    }

    public void setOfferwallActivity(Activity activity) {
        this.r0 = activity;
    }

    public void setOfferwallType(int i2) {
        APOfferwallTabInfo aPOfferwallTabInfo = this.Q0;
        if (aPOfferwallTabInfo != null) {
            this.S0 = aPOfferwallTabInfo.getTabType(0);
        }
        this.K0 = i2;
        if (this.k0) {
            this.L0 = 0;
            return;
        }
        if (i2 == 2) {
            this.L0 = 2;
            return;
        }
        this.L0 = 0;
        int i3 = this.S0;
        if (i3 == 9 || i3 == 10 || i3 == 11 || i3 == 0) {
            this.L0 = 2;
        }
    }

    public void setTabOfferwallInfo(APOfferwallTabInfo aPOfferwallTabInfo) {
        this.Q0 = aPOfferwallTabInfo;
    }

    public void setViewTypeLoadListener(IViewTypeEventListener iViewTypeEventListener) {
        this.P0 = iViewTypeEventListener;
    }

    public void showProgressDialog(String str, boolean z2) {
        try {
            g();
            if (((Activity) this.f1656b).isFinishing()) {
                return;
            }
            com.igaworks.adpopcorn.renewal.b.d.c cVar = new com.igaworks.adpopcorn.renewal.b.d.c(this.f1656b, this.o0);
            this.n0 = cVar;
            cVar.setCancelable(z2);
            this.n0.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
