package com.igaworks.adpopcorn.activity.layout;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import androidx.core.view.PointerIconCompat;
import com.igaworks.adpopcorn.activity.ApVideoAdActivity;
import com.igaworks.adpopcorn.style.APOfferwallTabInfo;
import com.igaworks.adpopcorn.style.APSize;
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
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ApOfferWallLayout extends FrameLayout implements com.igaworks.adpopcorn.a.g.a.d {
    private String A;
    private ImageView A0;
    private String B;
    private LinearLayout B0;
    private String C;
    private LinearLayout C0;
    private String D;
    private LinearLayout D0;
    private String E;
    private TextView E0;
    private String F;
    private TextView F0;
    private String G;
    private List<TextView> G0;
    private Handler H;
    private List<TextView> H0;
    private Runnable I;
    private List<ImageView> I0;
    private int J;
    private List<ImageView> J0;
    private int K;
    private int K0;
    private boolean L;
    private int L0;
    private String M;
    private boolean M0;
    private String N;
    private boolean N0;
    private String O;
    private String O0;
    private String P;
    private long P0;
    private String Q;
    private IViewTypeEventListener Q0;
    private boolean R;
    private APOfferwallTabInfo R0;
    private com.igaworks.adpopcorn.cores.model.g S;
    private int S0;
    private Dialog T;
    private int T0;
    private Dialog U;
    private List<String> U0;
    private com.igaworks.adpopcorn.activity.b.g V;
    View.OnClickListener V0;
    private HashMap<String, String> W;
    AdapterView.OnItemClickListener W0;
    AbsListView.OnScrollListener X0;
    private int a;
    private com.igaworks.adpopcorn.a.g.a a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f1576b;
    private boolean b0;
    private Context c;
    private boolean c0;
    private com.igaworks.adpopcorn.cores.common.g d;
    private boolean d0;
    private com.igaworks.adpopcorn.a.c e;
    private int e0;
    private FrameLayout f;
    private int f0;
    private LinearLayout g;
    private LinearLayout g0;
    private TextView h;
    private com.igaworks.adpopcorn.activity.b.b h0;
    private TextView i;
    private com.igaworks.adpopcorn.activity.layout.d i0;
    private com.igaworks.adpopcorn.activity.a.a j;
    private LinearLayout j0;
    private com.igaworks.adpopcorn.activity.c.e k;
    private ViewFlipper k0;
    private com.igaworks.adpopcorn.activity.c.e l;
    private boolean l0;
    private List<com.igaworks.adpopcorn.cores.model.g> m;
    private boolean m0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> n;
    private Dialog n0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> o;
    private com.igaworks.adpopcorn.activity.b.d.c o0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> p;
    private int p0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> q;
    private boolean q0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> r;
    private boolean r0;
    private com.igaworks.adpopcorn.cores.model.g s;
    private Activity s0;
    private com.igaworks.adpopcorn.cores.model.g t;
    private boolean t0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> u;
    private WebView u0;
    private int v;
    private ArrayList<String> v0;
    private com.igaworks.adpopcorn.activity.layout.a w;
    private ArrayList<String> w0;
    private boolean x;
    private int x0;
    private com.igaworks.adpopcorn.activity.c.i y;
    private boolean y0;
    private com.igaworks.adpopcorn.a.d z;
    private boolean z0;

    public interface IViewTypeEventListener {
        void OnLoadedOfferWallPage();
    }

    class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ApOfferWallLayout.this.b();
        }
    }

    class a0 implements View.OnClickListener {
        a0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApOfferWallLayout.this.e();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApOfferWallLayout.this.e();
        }
    }

    class b0 implements View.OnClickListener {
        b0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApOfferWallLayout.this.a(true);
            ApOfferWallLayout.this.e();
        }
    }

    class c implements View.OnClickListener {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApOfferWallLayout.this.e();
            ApOfferWallLayout.this.d(this.a);
        }
    }

    class c0 implements View.OnClickListener {
        c0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApOfferWallLayout.this.e();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApOfferWallLayout.this.i();
        }
    }

    class d0 implements View.OnClickListener {
        d0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ApOfferWallLayout.this.K == 7 || ApOfferWallLayout.this.K == 23) {
                com.igaworks.adpopcorn.a.b.a().b(ApOfferWallLayout.this.c, "participateFlag", ApOfferWallLayout.this.M, true);
                if (ApOfferWallLayout.this.j != null) {
                    ApOfferWallLayout.this.j.notifyDataSetChanged();
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("auth", ApOfferWallLayout.this.O);
                jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(ApOfferWallLayout.this.f1576b));
                jSONObject.put("channel_code", ApOfferWallLayout.this.x0);
                ApOfferWallLayout.this.a0.a(1, ApOfferWallLayout.this.B, jSONObject, ApOfferWallLayout.this);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (ApOfferWallLayout.this.T != null) {
                ApOfferWallLayout.this.T.dismiss();
                ApOfferWallLayout.this.T = null;
            }
            ApOfferWallLayout.this.e();
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApOfferWallLayout.this.i();
        }
    }

    class e0 implements DialogInterface.OnDismissListener {
        e0() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (ApOfferWallLayout.this.e.i()) {
                ApOfferWallLayout apOfferWallLayout = ApOfferWallLayout.this;
                apOfferWallLayout.showProgressDialog(apOfferWallLayout.d.f1613b, true);
            }
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (ApOfferWallLayout.this.h0 != null) {
                    ApOfferWallLayout.this.h0.dismiss();
                }
                ApOfferWallLayout apOfferWallLayout = ApOfferWallLayout.this;
                apOfferWallLayout.S = apOfferWallLayout.t;
                ApOfferWallLayout apOfferWallLayout2 = ApOfferWallLayout.this;
                apOfferWallLayout2.K = apOfferWallLayout2.S.K();
                ApOfferWallLayout apOfferWallLayout3 = ApOfferWallLayout.this;
                apOfferWallLayout3.N = apOfferWallLayout3.S.a();
                ApOfferWallLayout apOfferWallLayout4 = ApOfferWallLayout.this;
                apOfferWallLayout4.M = apOfferWallLayout4.S.c();
                ApOfferWallLayout apOfferWallLayout5 = ApOfferWallLayout.this;
                apOfferWallLayout5.showProgressDialog(apOfferWallLayout5.d.s, false);
                ApOfferWallLayout.this.z.b("media_offerwall_tab_content_click", ApOfferWallLayout.this.M);
                ApOfferWallLayout.this.x0 = 2;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("auth", ApOfferWallLayout.this.N);
                jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(ApOfferWallLayout.this.f1576b));
                ApOfferWallLayout.this.a0.a(2, ApOfferWallLayout.this.A, jSONObject, ApOfferWallLayout.this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class f0 implements View.OnClickListener {
        f0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApOfferWallLayout.this.e();
        }
    }

    class g implements DialogInterface.OnDismissListener {

        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (ApOfferWallLayout.this.T == null || !ApOfferWallLayout.this.T.isShowing()) {
                        ApOfferWallLayout apOfferWallLayout = ApOfferWallLayout.this;
                        apOfferWallLayout.S = apOfferWallLayout.t;
                        ApOfferWallLayout apOfferWallLayout2 = ApOfferWallLayout.this;
                        apOfferWallLayout2.K = apOfferWallLayout2.S.K();
                        ApOfferWallLayout apOfferWallLayout3 = ApOfferWallLayout.this;
                        apOfferWallLayout3.N = apOfferWallLayout3.S.a();
                        ApOfferWallLayout apOfferWallLayout4 = ApOfferWallLayout.this;
                        apOfferWallLayout4.M = apOfferWallLayout4.S.c();
                        ApOfferWallLayout apOfferWallLayout5 = ApOfferWallLayout.this;
                        apOfferWallLayout5.showProgressDialog(apOfferWallLayout5.d.s, false);
                        ApOfferWallLayout.this.z.b("media_offerwall_tab_content_click", ApOfferWallLayout.this.M);
                        ApOfferWallLayout.this.x0 = 2;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("auth", ApOfferWallLayout.this.N);
                        jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(ApOfferWallLayout.this.f1576b));
                        ApOfferWallLayout.this.a0.a(0, ApOfferWallLayout.this.A, jSONObject, ApOfferWallLayout.this);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        g() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            try {
                if (ApOfferWallLayout.this.p != null && ApOfferWallLayout.this.p.size() > 0) {
                    ApOfferWallLayout.this.z();
                    if (ApOfferWallLayout.this.y != null) {
                        com.igaworks.adpopcorn.cores.common.e.a(ApOfferWallLayout.this.f1576b, ((com.igaworks.adpopcorn.cores.model.g) ApOfferWallLayout.this.p.get(0)).T(), ApOfferWallLayout.this.y, 0, 0, (com.igaworks.adpopcorn.cores.common.e.b) null);
                    }
                    if (ApOfferWallLayout.this.w != null) {
                        ApOfferWallLayout apOfferWallLayout = ApOfferWallLayout.this;
                        if (!apOfferWallLayout.isLandscapeMode(apOfferWallLayout.f1576b, false)) {
                            ApOfferWallLayout.this.w.a((View) ApOfferWallLayout.this.w, ApOfferWallLayout.this.f1576b, ApOfferWallLayout.this.t, false, ApOfferWallLayout.this.t0, 0);
                            ApOfferWallLayout.this.w.setOnClickListener(new a());
                        }
                    }
                }
                if (ApOfferWallLayout.this.j != null) {
                    ApOfferWallLayout.this.j.notifyDataSetInvalidated();
                }
            } catch (Exception unused) {
            }
        }
    }

    class g0 implements View.OnClickListener {
        g0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.PASS_PARTICIPATE_EVENT)) {
                    ApOfferWallLayout.this.z.a(ApOfferWallLayout.this.P, ApOfferWallLayout.this.M, ApOfferWallLayout.this.Q, (String) null);
                } else if (ApOfferWallLayout.this.R) {
                    ApOfferWallLayout apOfferWallLayout = ApOfferWallLayout.this;
                    apOfferWallLayout.e(apOfferWallLayout.P);
                } else {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(ApOfferWallLayout.this.P));
                    ApOfferWallLayout.this.f1576b.startActivity(intent);
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
            try {
                if (ApOfferWallLayout.this.T == null || !ApOfferWallLayout.this.T.isShowing()) {
                    ApOfferWallLayout apOfferWallLayout = ApOfferWallLayout.this;
                    apOfferWallLayout.S = apOfferWallLayout.t;
                    ApOfferWallLayout apOfferWallLayout2 = ApOfferWallLayout.this;
                    apOfferWallLayout2.K = apOfferWallLayout2.S.K();
                    ApOfferWallLayout apOfferWallLayout3 = ApOfferWallLayout.this;
                    apOfferWallLayout3.N = apOfferWallLayout3.S.a();
                    ApOfferWallLayout apOfferWallLayout4 = ApOfferWallLayout.this;
                    apOfferWallLayout4.M = apOfferWallLayout4.S.c();
                    ApOfferWallLayout apOfferWallLayout5 = ApOfferWallLayout.this;
                    apOfferWallLayout5.showProgressDialog(apOfferWallLayout5.d.s, false);
                    ApOfferWallLayout.this.z.b("media_offerwall_tab_content_click", ApOfferWallLayout.this.M);
                    ApOfferWallLayout.this.x0 = 2;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("auth", ApOfferWallLayout.this.N);
                    jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(ApOfferWallLayout.this.f1576b));
                    ApOfferWallLayout.this.a0.a(0, ApOfferWallLayout.this.A, jSONObject, ApOfferWallLayout.this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class h0 implements com.igaworks.adpopcorn.a.g.a.d {
        h0(ApOfferWallLayout apOfferWallLayout) {
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
            if (com.igaworks.adpopcorn.a.d.a(ApOfferWallLayout.this.f1576b) != null) {
                com.igaworks.adpopcorn.a.d.a(ApOfferWallLayout.this.f1576b).j();
            }
            ApOfferWallLayout.this.e();
            ApOfferWallLayout.this.i();
        }
    }

    class i0 implements com.igaworks.adpopcorn.a.g.a.d {
        i0(ApOfferWallLayout apOfferWallLayout) {
        }

        @Override // com.igaworks.adpopcorn.a.g.a.d
        public void onNetResponseListener(int i, com.igaworks.adpopcorn.cores.model.f fVar) {
        }
    }

    class j implements View.OnClickListener {
        final /* synthetic */ boolean a;

        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ApOfferWallLayout.this.e();
                j jVar = j.this;
                ApOfferWallLayout.this.resume(jVar.a);
            }
        }

        j(boolean z) {
            this.a = z;
        }

        /* JADX WARN: Code duplicated, block: B:9:0x0040 A[Catch: Exception -> 0x0098, TRY_LEAVE, TryCatch #0 {Exception -> 0x0098, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x0032, B:9:0x0040), top: B:13:0x0003 }] */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                try {
                    if (view.isSelected()) {
                        ApOfferWallLayout.this.e();
                        com.igaworks.adpopcorn.a.b.a().b(ApOfferWallLayout.this.f1576b, "adpopcorn_parameter", "check_user_agreement", true);
                        ApOfferWallLayout.this.resume(this.a);
                        if (com.igaworks.adpopcorn.a.d.a(ApOfferWallLayout.this.f1576b) != null) {
                            com.igaworks.adpopcorn.a.d.a(ApOfferWallLayout.this.f1576b).i();
                        }
                    } else {
                        ApOfferWallLayout.this.e();
                        String str = ApOfferWallLayout.this.d.Y;
                        String str2 = ApOfferWallLayout.this.d.j1;
                        String str3 = ApOfferWallLayout.this.d.I;
                        ApOfferWallLayout apOfferWallLayout = ApOfferWallLayout.this;
                        Context context = ApOfferWallLayout.this.f1576b;
                        int i = ApOfferWallLayout.this.p0;
                        a aVar = new a();
                        ApOfferWallLayout apOfferWallLayout2 = ApOfferWallLayout.this;
                        apOfferWallLayout.n0 = new com.igaworks.adpopcorn.activity.b.d.a(context, i, str, str2, -1, str3, aVar, apOfferWallLayout2.isLandscapeMode(apOfferWallLayout2.f1576b, false), false);
                        ApOfferWallLayout.this.n0.setCancelable(true);
                        ApOfferWallLayout.this.n0.show();
                    }
                } catch (Exception unused) {
                }
            } else {
                ApOfferWallLayout.this.e();
                String str4 = ApOfferWallLayout.this.d.Y;
                String str5 = ApOfferWallLayout.this.d.j1;
                String str6 = ApOfferWallLayout.this.d.I;
                ApOfferWallLayout apOfferWallLayout3 = ApOfferWallLayout.this;
                Context context2 = ApOfferWallLayout.this.f1576b;
                int i2 = ApOfferWallLayout.this.p0;
                a aVar2 = new a();
                ApOfferWallLayout apOfferWallLayout4 = ApOfferWallLayout.this;
                apOfferWallLayout3.n0 = new com.igaworks.adpopcorn.activity.b.d.a(context2, i2, str4, str5, -1, str6, aVar2, apOfferWallLayout4.isLandscapeMode(apOfferWallLayout4.f1576b, false), false);
                ApOfferWallLayout.this.n0.setCancelable(true);
                ApOfferWallLayout.this.n0.show();
            }
        }
    }

    class j0 extends com.igaworks.adpopcorn.cores.common.b {
        j0() {
        }

        @Override // com.igaworks.adpopcorn.cores.common.b
        public void a() {
            super.a();
            if (ApOfferWallLayout.this.S.b0()) {
                return;
            }
            ApOfferWallLayout.this.f();
            com.igaworks.adpopcorn.a.b.a().a(ApOfferWallLayout.this.f1576b, ApOfferWallLayout.this.S.C());
            ApOfferWallLayout.this.S.g(true);
        }
    }

    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ApOfferWallLayout.this.b();
        }
    }

    class k0 implements DialogInterface.OnDismissListener {
        k0() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (ApOfferWallLayout.this.j != null) {
                ApOfferWallLayout.this.j.notifyDataSetChanged();
            }
        }
    }

    class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.igaworks.adpopcorn.cores.model.g gVar;
            ApOfferWallLayout apOfferWallLayout;
            try {
                if (ApOfferWallLayout.this.T == null || !ApOfferWallLayout.this.T.isShowing()) {
                    int iIntValue = ((Integer) view.getTag()).intValue();
                    if (!com.igaworks.adpopcorn.cores.common.c.c(ApOfferWallLayout.this.f1576b)) {
                        ApOfferWallLayout apOfferWallLayout2 = ApOfferWallLayout.this;
                        apOfferWallLayout2.b(apOfferWallLayout2.d.g, ApOfferWallLayout.this.d.h, false);
                        return;
                    }
                    if (iIntValue == 0) {
                        apOfferWallLayout = ApOfferWallLayout.this;
                        gVar = apOfferWallLayout.s;
                    } else {
                        ApOfferWallLayout apOfferWallLayout3 = ApOfferWallLayout.this;
                        gVar = (com.igaworks.adpopcorn.cores.model.g) apOfferWallLayout3.u.get(iIntValue - 1);
                        apOfferWallLayout = apOfferWallLayout3;
                    }
                    apOfferWallLayout.S = gVar;
                    ApOfferWallLayout apOfferWallLayout4 = ApOfferWallLayout.this;
                    apOfferWallLayout4.K = apOfferWallLayout4.S.K();
                    ApOfferWallLayout apOfferWallLayout5 = ApOfferWallLayout.this;
                    apOfferWallLayout5.N = apOfferWallLayout5.S.a();
                    ApOfferWallLayout apOfferWallLayout6 = ApOfferWallLayout.this;
                    apOfferWallLayout6.M = apOfferWallLayout6.S.c();
                    ApOfferWallLayout apOfferWallLayout7 = ApOfferWallLayout.this;
                    apOfferWallLayout7.showProgressDialog(apOfferWallLayout7.d.s, false);
                    ApOfferWallLayout.this.x0 = 3;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("auth", ApOfferWallLayout.this.N);
                    jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(ApOfferWallLayout.this.f1576b));
                    ApOfferWallLayout.this.a0.a(0, ApOfferWallLayout.this.A, jSONObject, ApOfferWallLayout.this);
                    if (ApOfferWallLayout.this.w0 == null || ApOfferWallLayout.this.w0.contains(ApOfferWallLayout.this.s.c())) {
                        return;
                    }
                    ApOfferWallLayout.this.z.b("media_offerwall_tab_content_click", ApOfferWallLayout.this.M);
                    ApOfferWallLayout.this.w0.add(ApOfferWallLayout.this.M);
                }
            } catch (Exception unused) {
            }
        }
    }

    class l0 implements Runnable {
        final /* synthetic */ com.igaworks.adpopcorn.cores.model.f a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ApOfferWallLayout.this.b(true);
            }
        }

        l0(com.igaworks.adpopcorn.cores.model.f fVar) {
            this.a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int iB;
            boolean z = false;
            ApOfferWallLayout.this.a("", false);
            if (ApOfferWallLayout.this.t0) {
                com.igaworks.adpopcorn.cores.common.d.a((Activity) ApOfferWallLayout.this.f1576b, ApOfferWallLayout.this.f.getWidth());
            } else {
                com.igaworks.adpopcorn.cores.common.d.a();
            }
            if (ApOfferWallLayout.this.e != null && (ApOfferWallLayout.this.e.e() || ApOfferWallLayout.this.e.f())) {
                ApOfferWallLayout apOfferWallLayout = ApOfferWallLayout.this;
                apOfferWallLayout.b(apOfferWallLayout.d.X0, ApOfferWallLayout.this.d.h, true);
                ApOfferWallLayout apOfferWallLayout2 = ApOfferWallLayout.this;
                apOfferWallLayout2.a(apOfferWallLayout2.d.X0, true);
                return;
            }
            com.igaworks.adpopcorn.cores.model.f fVar = this.a;
            if (fVar == null || !fVar.d()) {
                com.igaworks.adpopcorn.cores.model.f fVar2 = this.a;
                if (fVar2 == null || fVar2.a() == null || this.a.a().length() <= 0) {
                    z = true;
                } else {
                    try {
                        com.igaworks.adpopcorn.cores.model.e eVarA = com.igaworks.adpopcorn.a.f.d.a(ApOfferWallLayout.this.f1576b, this.a.a());
                        if (eVarA == null || !eVarA.e()) {
                            iB = 0;
                        } else {
                            ApOfferWallLayout.this.a(eVarA.a(), ApOfferWallLayout.this.e0);
                            iB = eVarA.b();
                            ApOfferWallLayout.this.f0 = eVarA.d();
                            ApOfferWallLayout.this.O0 = eVarA.c();
                        }
                        com.igaworks.adpopcorn.cores.common.h.b(ApOfferWallLayout.this.f1576b, "AP_OFFER", "callbackGetCampaignList: resultCode : " + iB, 3);
                        if (ApOfferWallLayout.this.e0 >= ApOfferWallLayout.this.f0) {
                            ApOfferWallLayout.this.c0 = true;
                        }
                        ApOfferWallLayout.this.j();
                        ApOfferWallLayout.this.x();
                        if (iB == 500) {
                            ApOfferWallLayout.this.c(true);
                        } else {
                            ApOfferWallLayout.this.c(false);
                        }
                        ApOfferWallLayout.A(ApOfferWallLayout.this);
                        ApOfferWallLayout.this.h();
                    } catch (Exception e) {
                        e.printStackTrace();
                        z = true;
                    }
                }
            } else {
                if (ApOfferWallLayout.this.e0 == 1) {
                    ApOfferWallLayout apOfferWallLayout3 = ApOfferWallLayout.this;
                    apOfferWallLayout3.b(apOfferWallLayout3.d.U, ApOfferWallLayout.this.d.h, true);
                } else {
                    ApOfferWallLayout apOfferWallLayout4 = ApOfferWallLayout.this;
                    apOfferWallLayout4.a(apOfferWallLayout4.d.p, ApOfferWallLayout.this.d.e, false);
                }
                if (ApOfferWallLayout.this.m == null || (ApOfferWallLayout.this.m != null && ApOfferWallLayout.this.m.size() == 0)) {
                    ApOfferWallLayout apOfferWallLayout5 = ApOfferWallLayout.this;
                    apOfferWallLayout5.a(apOfferWallLayout5.d.U, true);
                }
            }
            ApOfferWallLayout.this.b0 = true;
            if (z) {
                if (ApOfferWallLayout.this.e0 == 1) {
                    ApOfferWallLayout apOfferWallLayout6 = ApOfferWallLayout.this;
                    apOfferWallLayout6.b(apOfferWallLayout6.d.U, ApOfferWallLayout.this.d.h, true);
                    if (ApOfferWallLayout.this.m == null || (ApOfferWallLayout.this.m != null && ApOfferWallLayout.this.m.size() == 0)) {
                        ApOfferWallLayout apOfferWallLayout7 = ApOfferWallLayout.this;
                        apOfferWallLayout7.a(apOfferWallLayout7.d.U, true);
                    }
                } else {
                    new Handler().post(new a());
                }
                ApOfferWallLayout.this.d0 = true;
                ApOfferWallLayout.this.h();
            }
            if (ApOfferWallLayout.this.Q0 != null) {
                ApOfferWallLayout.this.Q0.OnLoadedOfferWallPage();
            }
        }
    }

    class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApOfferWallLayout.this.a(((Integer) view.getTag()).intValue());
        }
    }

    class m0 extends WebViewClient {
        m0() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                com.igaworks.adpopcorn.cores.common.h.a(ApOfferWallLayout.this.f1576b, "ApOfferWallLayout", "shouldOverrideUrlLoading = " + str, 3);
                if (str != null && str.startsWith("http://play.google.com/store/apps/")) {
                    str = str.replace("http://play.google.com/store/apps/", "market://");
                } else if (str != null && str.startsWith("https://play.google.com/store/apps/")) {
                    str = str.replace("https://play.google.com/store/apps/", "market://");
                }
                if (str == null || !str.contains("market://")) {
                    webView.loadUrl(str);
                    return true;
                }
                ApOfferWallLayout.this.d(str);
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
    }

    class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (ApOfferWallLayout.this.T == null || !ApOfferWallLayout.this.T.isShowing()) {
                    ApOfferWallLayout apOfferWallLayout = ApOfferWallLayout.this;
                    apOfferWallLayout.S = apOfferWallLayout.t;
                    ApOfferWallLayout apOfferWallLayout2 = ApOfferWallLayout.this;
                    apOfferWallLayout2.K = apOfferWallLayout2.S.K();
                    ApOfferWallLayout apOfferWallLayout3 = ApOfferWallLayout.this;
                    apOfferWallLayout3.N = apOfferWallLayout3.S.a();
                    ApOfferWallLayout apOfferWallLayout4 = ApOfferWallLayout.this;
                    apOfferWallLayout4.M = apOfferWallLayout4.S.c();
                    ApOfferWallLayout apOfferWallLayout5 = ApOfferWallLayout.this;
                    apOfferWallLayout5.showProgressDialog(apOfferWallLayout5.d.s, false);
                    ApOfferWallLayout.this.z.b("media_offerwall_tab_content_click", ApOfferWallLayout.this.M);
                    ApOfferWallLayout.this.x0 = 2;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("auth", ApOfferWallLayout.this.N);
                    jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(ApOfferWallLayout.this.f1576b));
                    ApOfferWallLayout.this.a0.a(0, ApOfferWallLayout.this.A, jSONObject, ApOfferWallLayout.this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class n0 implements AdapterView.OnItemClickListener {

        class a extends com.igaworks.adpopcorn.cores.common.b {
            a(n0 n0Var) {
            }

            @Override // com.igaworks.adpopcorn.cores.common.b
            public void a() {
                super.a();
            }
        }

        n0() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            JSONObject jSONObject;
            com.igaworks.adpopcorn.a.g.a aVar;
            String str;
            com.igaworks.adpopcorn.a.d dVar;
            String strY;
            try {
                if (ApOfferWallLayout.this.T == null || !ApOfferWallLayout.this.T.isShowing()) {
                    if (ApOfferWallLayout.this.V == null || !ApOfferWallLayout.this.V.isShowing()) {
                        ApOfferWallLayout apOfferWallLayout = ApOfferWallLayout.this;
                        apOfferWallLayout.S = (com.igaworks.adpopcorn.cores.model.g) apOfferWallLayout.n.get(i);
                        if (ApOfferWallLayout.this.S.f0()) {
                            return;
                        }
                        if (!ApOfferWallLayout.this.S.a0()) {
                            int i2 = 0;
                            if (ApOfferWallLayout.this.S.X()) {
                                ApOfferWallLayout apOfferWallLayout2 = ApOfferWallLayout.this;
                                apOfferWallLayout2.showProgressDialog(apOfferWallLayout2.d.s, false);
                                ApOfferWallLayout.this.z.b("media_offerwall_tab_content_click", ApOfferWallLayout.this.S.d());
                                ApOfferWallLayout.this.x0 = 1;
                                jSONObject = new JSONObject();
                                jSONObject.put("auth", ApOfferWallLayout.this.S.a());
                                jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(ApOfferWallLayout.this.f1576b));
                                aVar = ApOfferWallLayout.this.a0;
                                i2 = 2;
                                str = ApOfferWallLayout.this.A;
                            } else if (ApOfferWallLayout.this.S.c0()) {
                                if (ApOfferWallLayout.this.S.b0()) {
                                    ApOfferWallLayout.this.V = new com.igaworks.adpopcorn.activity.b.g(ApOfferWallLayout.this.f1576b, ApOfferWallLayout.this.p0, ApOfferWallLayout.this.S, ApOfferWallLayout.this.d, new a(this));
                                    ApOfferWallLayout.this.V.show();
                                } else {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put(MBridgeConstans.APP_KEY, ApOfferWallLayout.this.z.e().b());
                                    jSONObject2.put("adid", ApOfferWallLayout.this.z.e().a());
                                    jSONObject2.put("usn", ApOfferWallLayout.this.z.e().g());
                                    jSONObject2.put("integration_type_no", ApOfferWallLayout.this.S.E());
                                    jSONObject2.put("point", ApOfferWallLayout.this.S.F());
                                    jSONObject2.put("newsId", ApOfferWallLayout.this.S.C());
                                    ApOfferWallLayout.this.a0.a(29, ApOfferWallLayout.this.G, jSONObject2, ApOfferWallLayout.this);
                                }
                                dVar = ApOfferWallLayout.this.z;
                                strY = ApOfferWallLayout.this.S.y();
                            } else {
                                ApOfferWallLayout apOfferWallLayout3 = ApOfferWallLayout.this;
                                apOfferWallLayout3.K = apOfferWallLayout3.S.K();
                                ApOfferWallLayout apOfferWallLayout4 = ApOfferWallLayout.this;
                                apOfferWallLayout4.N = ((com.igaworks.adpopcorn.cores.model.g) apOfferWallLayout4.n.get(i)).a();
                                ApOfferWallLayout apOfferWallLayout5 = ApOfferWallLayout.this;
                                apOfferWallLayout5.M = ((com.igaworks.adpopcorn.cores.model.g) apOfferWallLayout5.n.get(i)).c();
                                ApOfferWallLayout apOfferWallLayout6 = ApOfferWallLayout.this;
                                apOfferWallLayout6.showProgressDialog(apOfferWallLayout6.d.s, false);
                                ApOfferWallLayout.this.z.b("media_offerwall_tab_content_click", ApOfferWallLayout.this.M);
                                ApOfferWallLayout.this.x0 = 1;
                                jSONObject = new JSONObject();
                                jSONObject.put("auth", ApOfferWallLayout.this.N);
                                jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(ApOfferWallLayout.this.f1576b));
                                aVar = ApOfferWallLayout.this.a0;
                                str = ApOfferWallLayout.this.A;
                            }
                            aVar.a(i2, str, jSONObject, ApOfferWallLayout.this);
                            return;
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(MBridgeConstans.APP_KEY, ApOfferWallLayout.this.z.e().b());
                        jSONObject3.put("adid", ApOfferWallLayout.this.z.e().a());
                        jSONObject3.put("usn", ApOfferWallLayout.this.z.e().g());
                        jSONObject3.put("integration_type_no", ApOfferWallLayout.this.S.l());
                        jSONObject3.put("point", ApOfferWallLayout.this.S.m());
                        ApOfferWallLayout.this.a0.a(27, ApOfferWallLayout.this.F, jSONObject3, ApOfferWallLayout.this);
                        dVar = ApOfferWallLayout.this.z;
                        strY = ApOfferWallLayout.this.S.d();
                        dVar.b("media_offerwall_tab_content_click", strY);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class o implements View.OnClickListener {
        final /* synthetic */ boolean a;

        o(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApOfferWallLayout.this.e();
            if (this.a) {
                ApOfferWallLayout.this.i();
            }
        }
    }

    class o0 implements AbsListView.OnScrollListener {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ApOfferWallLayout.this.b(true);
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ApOfferWallLayout.this.b(false);
                if (!com.igaworks.adpopcorn.cores.common.c.c(ApOfferWallLayout.this.f1576b)) {
                    ApOfferWallLayout.this.d0 = true;
                    ApOfferWallLayout.this.b(true);
                } else {
                    ApOfferWallLayout.this.b0 = false;
                    ApOfferWallLayout.this.c0 = false;
                    ApOfferWallLayout.this.a0.a(ApOfferWallLayout.this.e0, ApOfferWallLayout.this);
                }
            }
        }

        o0() {
        }

        /* JADX WARN: Code duplicated, block: B:29:0x0082  */
        /* JADX WARN: Code duplicated, block: B:35:0x009d  */
        /* JADX WARN: Code duplicated, block: B:53:0x00f7  */
        /* JADX WARN: Code duplicated, block: B:59:0x0112  */
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (ApOfferWallLayout.this.y0 && !ApOfferWallLayout.this.z0 && (childAt = absListView.getChildAt(0)) != null) {
                if ((-childAt.getTop()) <= 0) {
                    if (ApOfferWallLayout.this.A0 != null) {
                        ApOfferWallLayout.this.A0.setVisibility(4);
                    }
                } else if (ApOfferWallLayout.this.A0 != null) {
                    ApOfferWallLayout.this.A0.setVisibility(0);
                }
            }
            if (ApOfferWallLayout.this.K0 == 3) {
                View childAt2 = absListView.getChildAt(0);
                if (childAt2 != null) {
                    int i4 = -childAt2.getTop();
                    int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_REWARD_SUMMARY_BAR_HEIGHT);
                    if (i >= 1) {
                        if (ApOfferWallLayout.this.D0 != null) {
                            ApOfferWallLayout.this.D0.setVisibility(0);
                        }
                    } else if (i4 >= com.igaworks.adpopcorn.cores.common.d.a(ApOfferWallLayout.this.c, iC)) {
                        if (ApOfferWallLayout.this.D0 != null) {
                            ApOfferWallLayout.this.D0.setVisibility(0);
                        }
                    } else if (ApOfferWallLayout.this.D0 != null) {
                        ApOfferWallLayout.this.D0.setVisibility(8);
                    }
                } else if (ApOfferWallLayout.this.D0 != null) {
                    ApOfferWallLayout.this.D0.setVisibility(8);
                }
            }
            if (ApOfferWallLayout.this.t != null) {
                View childAt3 = absListView.getChildAt(0);
                if (childAt3 != null) {
                    int i5 = -childAt3.getTop();
                    int iA = ApOfferWallLayout.this.k != null ? ApOfferWallLayout.this.k.a(0) : 0;
                    int iA2 = com.igaworks.adpopcorn.cores.common.d.a(ApOfferWallLayout.this.f1576b, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_BAR_HEIGHT));
                    if (i >= 1) {
                        if (ApOfferWallLayout.this.w != null) {
                            ApOfferWallLayout.this.w.setVisibility(0);
                        }
                    } else if (i5 >= iA - iA2) {
                        if (ApOfferWallLayout.this.w != null) {
                            ApOfferWallLayout.this.w.setVisibility(0);
                        }
                    } else if (ApOfferWallLayout.this.w != null) {
                        ApOfferWallLayout.this.w.setVisibility(8);
                    }
                } else if (ApOfferWallLayout.this.w != null) {
                    ApOfferWallLayout.this.w.setVisibility(8);
                }
            }
            if (i == 0) {
                try {
                    if (ApOfferWallLayout.this.p != null && ApOfferWallLayout.this.p.size() > 1) {
                        ApOfferWallLayout.this.c();
                    }
                } catch (Exception unused) {
                }
            }
            if (!ApOfferWallLayout.this.b0 || ApOfferWallLayout.this.d0) {
                return;
            }
            if (ApOfferWallLayout.this.c0 || ApOfferWallLayout.this.e0 > ApOfferWallLayout.this.f0) {
                new Handler().post(new a());
            } else {
                if (i3 < 1 || i + i2 != i3) {
                    return;
                }
                new Handler().post(new b());
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApOfferWallLayout.this.e();
            ApOfferWallLayout.this.i();
        }
    }

    class p0 implements View.OnClickListener {
        p0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApOfferWallLayout.this.v();
        }
    }

    class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApOfferWallLayout.this.e();
            String str = "https://adpopcorn.notion.site/FAQ-35edb7e2c4ff4311b2bcf616c8e1b022";
            String strA = com.igaworks.adpopcorn.a.b.a().a(ApOfferWallLayout.this.f1576b, "adpopcorn_sdk_flag", "no_ad_landingurl", "https://adpopcorn.notion.site/FAQ-35edb7e2c4ff4311b2bcf616c8e1b022");
            if (strA != null && strA.length() > 0) {
                str = strA;
            }
            ApOfferWallLayout.this.d(str);
        }
    }

    class q0 implements View.OnClickListener {
        q0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApOfferWallLayout.this.v();
        }
    }

    class r implements View.OnClickListener {
        final /* synthetic */ int a;

        r(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (this.a == 1004) {
                    if (com.igaworks.adpopcorn.cores.common.c.c(ApOfferWallLayout.this.f1576b)) {
                        ApOfferWallLayout apOfferWallLayout = ApOfferWallLayout.this;
                        apOfferWallLayout.showProgressDialog(apOfferWallLayout.d.f1613b, false);
                        ApOfferWallLayout.this.a0.a(ApOfferWallLayout.this.e0, ApOfferWallLayout.this);
                    } else {
                        ApOfferWallLayout apOfferWallLayout2 = ApOfferWallLayout.this;
                        apOfferWallLayout2.b(apOfferWallLayout2.d.g, ApOfferWallLayout.this.d.h, false);
                    }
                }
                if (ApOfferWallLayout.this.j != null) {
                    ApOfferWallLayout.this.j.notifyDataSetChanged();
                }
                ApOfferWallLayout.this.e();
            } catch (Exception unused) {
            }
        }
    }

    class r0 implements View.OnClickListener {
        r0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApOfferWallLayout.this.d("https://reward.adpopcorn.com/policy/privacy");
        }
    }

    class s implements View.OnClickListener {
        s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApOfferWallLayout.this.e();
        }
    }

    class s0 implements View.OnClickListener {
        s0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApOfferWallLayout.this.d("https://reward.adpopcorn.com/policy/privacy");
        }
    }

    class t implements View.OnClickListener {
        t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ApOfferWallLayout apOfferWallLayout = ApOfferWallLayout.this;
                if (apOfferWallLayout.c(apOfferWallLayout.S.J())) {
                    ApOfferWallLayout apOfferWallLayout2 = ApOfferWallLayout.this;
                    apOfferWallLayout2.a(true, apOfferWallLayout2.S.J());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            ApOfferWallLayout.this.e();
        }
    }

    class t0 implements View.OnClickListener {
        t0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApOfferWallLayout.this.d();
        }
    }

    class u implements View.OnClickListener {
        u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                int iIntValue = ((Integer) view.getTag()).intValue();
                if (iIntValue == 0) {
                    ApOfferWallLayout.this.v();
                } else if (iIntValue == 1) {
                    ApOfferWallLayout.this.d("https://reward.adpopcorn.com/policy/privacy");
                } else if (iIntValue == 2) {
                    ApOfferWallLayout.this.d();
                }
            } catch (Exception unused) {
            }
        }
    }

    class v implements DialogInterface.OnDismissListener {
        v() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (ApOfferWallLayout.this.T != null) {
                ApOfferWallLayout.this.T = null;
            }
        }
    }

    class w implements DialogInterface.OnDismissListener {
        w() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (ApOfferWallLayout.this.T != null) {
                ApOfferWallLayout.this.T = null;
            }
        }
    }

    class x implements DialogInterface.OnDismissListener {
        x() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (ApOfferWallLayout.this.T != null) {
                ApOfferWallLayout.this.T = null;
            }
        }
    }

    class y implements View.OnClickListener {
        y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (ApOfferWallLayout.this.m0) {
                    ApOfferWallLayout.this.u();
                    return;
                }
                if (ApOfferWallLayout.this.K == 7 || ApOfferWallLayout.this.K == 23) {
                    com.igaworks.adpopcorn.a.b.a().b(ApOfferWallLayout.this.c, "participateFlag", ApOfferWallLayout.this.M, true);
                    if (ApOfferWallLayout.this.j != null) {
                        ApOfferWallLayout.this.j.notifyDataSetChanged();
                    }
                }
                ApOfferWallLayout.this.z.b("media_offerwall_tab_content_engagement", ApOfferWallLayout.this.M);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("auth", ApOfferWallLayout.this.O);
                    jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(ApOfferWallLayout.this.f1576b));
                    jSONObject.put("channel_code", ApOfferWallLayout.this.x0);
                    ApOfferWallLayout.this.a0.a(1, ApOfferWallLayout.this.B, jSONObject, ApOfferWallLayout.this);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (ApOfferWallLayout.this.T != null) {
                    ApOfferWallLayout.this.T.dismiss();
                    ApOfferWallLayout.this.T = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    class z implements View.OnClickListener {
        z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApOfferWallLayout.this.e();
        }
    }

    public ApOfferWallLayout(Context context) {
        super(context);
        this.v = 0;
        this.L = false;
        this.R = false;
        this.S = new com.igaworks.adpopcorn.cores.model.g();
        this.W = new HashMap<>();
        this.e0 = 0;
        this.f0 = 1;
        this.p0 = 0;
        this.q0 = false;
        this.r0 = false;
        this.t0 = false;
        this.x0 = 1;
        this.K0 = 0;
        this.L0 = 0;
        this.M0 = false;
        this.O0 = "";
        this.P0 = 0L;
        this.S0 = 0;
        this.T0 = 0;
        this.V0 = new y();
        this.W0 = new n0();
        this.X0 = new o0();
        this.f1576b = context;
        this.c = context.getApplicationContext();
        this.N0 = false;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public ApOfferWallLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.v = 0;
        this.L = false;
        this.R = false;
        this.S = new com.igaworks.adpopcorn.cores.model.g();
        this.W = new HashMap<>();
        this.e0 = 0;
        this.f0 = 1;
        this.p0 = 0;
        this.q0 = false;
        this.r0 = false;
        this.t0 = false;
        this.x0 = 1;
        this.K0 = 0;
        this.L0 = 0;
        this.M0 = false;
        this.O0 = "";
        this.P0 = 0L;
        this.S0 = 0;
        this.T0 = 0;
        this.V0 = new y();
        this.W0 = new n0();
        this.X0 = new o0();
    }

    static /* synthetic */ int A(ApOfferWallLayout apOfferWallLayout) {
        int i2 = apOfferWallLayout.e0;
        apOfferWallLayout.e0 = i2 + 1;
        return i2;
    }

    private void A() {
        Handler handler = this.H;
        if (handler != null) {
            handler.removeCallbacks(this.I);
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0176  */
    /* JADX WARN: Code duplicated, block: B:103:0x0178 A[Catch: Exception -> 0x0335, TRY_ENTER, TryCatch #0 {Exception -> 0x0335, blocks: (B:2:0x0000, B:4:0x0005, B:5:0x0007, B:7:0x000b, B:8:0x000d, B:10:0x0011, B:11:0x0014, B:13:0x001c, B:14:0x0021, B:16:0x0029, B:17:0x002e, B:19:0x0036, B:20:0x003b, B:22:0x0043, B:23:0x0048, B:25:0x004c, B:26:0x004f, B:31:0x0065, B:33:0x006d, B:35:0x007f, B:37:0x008f, B:40:0x0097, B:42:0x009f, B:44:0x00a7, B:46:0x00af, B:49:0x00c0, B:52:0x00cd, B:54:0x00d3, B:56:0x00d9, B:64:0x00f8, B:65:0x00fb, B:67:0x00ff, B:69:0x0105, B:71:0x010b, B:74:0x0117, B:79:0x0123, B:81:0x0129, B:83:0x012f, B:85:0x0138, B:87:0x0142, B:89:0x0148, B:91:0x0151, B:93:0x0157, B:95:0x015b, B:96:0x0163, B:97:0x0168, B:103:0x0178, B:107:0x017f, B:109:0x0185, B:133:0x01dc, B:110:0x0188, B:112:0x018e, B:114:0x0197, B:116:0x01a1, B:118:0x01a7, B:120:0x01b0, B:122:0x01b6, B:124:0x01ba, B:125:0x01c2, B:126:0x01c5, B:128:0x01cb, B:130:0x01d1, B:58:0x00de, B:60:0x00e4, B:63:0x00f6, B:50:0x00c3, B:156:0x0237, B:158:0x023b, B:160:0x0241, B:161:0x0248, B:163:0x0250, B:165:0x0254, B:166:0x0257, B:168:0x025b, B:170:0x025f, B:172:0x0265, B:173:0x0277, B:175:0x027b, B:177:0x0281, B:178:0x0293, B:179:0x029c, B:181:0x02a0, B:183:0x02a6, B:184:0x02a9, B:186:0x02b1, B:189:0x02be, B:193:0x02c9, B:195:0x02cd, B:197:0x02d5, B:199:0x02d9, B:200:0x0300), top: B:205:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x01c5 A[Catch: Exception -> 0x0335, TryCatch #0 {Exception -> 0x0335, blocks: (B:2:0x0000, B:4:0x0005, B:5:0x0007, B:7:0x000b, B:8:0x000d, B:10:0x0011, B:11:0x0014, B:13:0x001c, B:14:0x0021, B:16:0x0029, B:17:0x002e, B:19:0x0036, B:20:0x003b, B:22:0x0043, B:23:0x0048, B:25:0x004c, B:26:0x004f, B:31:0x0065, B:33:0x006d, B:35:0x007f, B:37:0x008f, B:40:0x0097, B:42:0x009f, B:44:0x00a7, B:46:0x00af, B:49:0x00c0, B:52:0x00cd, B:54:0x00d3, B:56:0x00d9, B:64:0x00f8, B:65:0x00fb, B:67:0x00ff, B:69:0x0105, B:71:0x010b, B:74:0x0117, B:79:0x0123, B:81:0x0129, B:83:0x012f, B:85:0x0138, B:87:0x0142, B:89:0x0148, B:91:0x0151, B:93:0x0157, B:95:0x015b, B:96:0x0163, B:97:0x0168, B:103:0x0178, B:107:0x017f, B:109:0x0185, B:133:0x01dc, B:110:0x0188, B:112:0x018e, B:114:0x0197, B:116:0x01a1, B:118:0x01a7, B:120:0x01b0, B:122:0x01b6, B:124:0x01ba, B:125:0x01c2, B:126:0x01c5, B:128:0x01cb, B:130:0x01d1, B:58:0x00de, B:60:0x00e4, B:63:0x00f6, B:50:0x00c3, B:156:0x0237, B:158:0x023b, B:160:0x0241, B:161:0x0248, B:163:0x0250, B:165:0x0254, B:166:0x0257, B:168:0x025b, B:170:0x025f, B:172:0x0265, B:173:0x0277, B:175:0x027b, B:177:0x0281, B:178:0x0293, B:179:0x029c, B:181:0x02a0, B:183:0x02a6, B:184:0x02a9, B:186:0x02b1, B:189:0x02be, B:193:0x02c9, B:195:0x02cd, B:197:0x02d5, B:199:0x02d9, B:200:0x0300), top: B:205:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x01cb A[Catch: Exception -> 0x0335, TryCatch #0 {Exception -> 0x0335, blocks: (B:2:0x0000, B:4:0x0005, B:5:0x0007, B:7:0x000b, B:8:0x000d, B:10:0x0011, B:11:0x0014, B:13:0x001c, B:14:0x0021, B:16:0x0029, B:17:0x002e, B:19:0x0036, B:20:0x003b, B:22:0x0043, B:23:0x0048, B:25:0x004c, B:26:0x004f, B:31:0x0065, B:33:0x006d, B:35:0x007f, B:37:0x008f, B:40:0x0097, B:42:0x009f, B:44:0x00a7, B:46:0x00af, B:49:0x00c0, B:52:0x00cd, B:54:0x00d3, B:56:0x00d9, B:64:0x00f8, B:65:0x00fb, B:67:0x00ff, B:69:0x0105, B:71:0x010b, B:74:0x0117, B:79:0x0123, B:81:0x0129, B:83:0x012f, B:85:0x0138, B:87:0x0142, B:89:0x0148, B:91:0x0151, B:93:0x0157, B:95:0x015b, B:96:0x0163, B:97:0x0168, B:103:0x0178, B:107:0x017f, B:109:0x0185, B:133:0x01dc, B:110:0x0188, B:112:0x018e, B:114:0x0197, B:116:0x01a1, B:118:0x01a7, B:120:0x01b0, B:122:0x01b6, B:124:0x01ba, B:125:0x01c2, B:126:0x01c5, B:128:0x01cb, B:130:0x01d1, B:58:0x00de, B:60:0x00e4, B:63:0x00f6, B:50:0x00c3, B:156:0x0237, B:158:0x023b, B:160:0x0241, B:161:0x0248, B:163:0x0250, B:165:0x0254, B:166:0x0257, B:168:0x025b, B:170:0x025f, B:172:0x0265, B:173:0x0277, B:175:0x027b, B:177:0x0281, B:178:0x0293, B:179:0x029c, B:181:0x02a0, B:183:0x02a6, B:184:0x02a9, B:186:0x02b1, B:189:0x02be, B:193:0x02c9, B:195:0x02cd, B:197:0x02d5, B:199:0x02d9, B:200:0x0300), top: B:205:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x022c A[Catch: Exception -> 0x0233, TryCatch #1 {Exception -> 0x0233, blocks: (B:75:0x011c, B:100:0x0170, B:154:0x0230, B:99:0x016e, B:134:0x01df, B:136:0x01e3, B:138:0x01e9, B:140:0x01f5, B:142:0x0201, B:145:0x020e, B:146:0x0212, B:148:0x0218, B:150:0x021e, B:152:0x0228, B:153:0x022c), top: B:207:0x011c }] */
    /* JADX WARN: Code duplicated, block: B:216:0x0233 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x00ff A[Catch: Exception -> 0x0335, TryCatch #0 {Exception -> 0x0335, blocks: (B:2:0x0000, B:4:0x0005, B:5:0x0007, B:7:0x000b, B:8:0x000d, B:10:0x0011, B:11:0x0014, B:13:0x001c, B:14:0x0021, B:16:0x0029, B:17:0x002e, B:19:0x0036, B:20:0x003b, B:22:0x0043, B:23:0x0048, B:25:0x004c, B:26:0x004f, B:31:0x0065, B:33:0x006d, B:35:0x007f, B:37:0x008f, B:40:0x0097, B:42:0x009f, B:44:0x00a7, B:46:0x00af, B:49:0x00c0, B:52:0x00cd, B:54:0x00d3, B:56:0x00d9, B:64:0x00f8, B:65:0x00fb, B:67:0x00ff, B:69:0x0105, B:71:0x010b, B:74:0x0117, B:79:0x0123, B:81:0x0129, B:83:0x012f, B:85:0x0138, B:87:0x0142, B:89:0x0148, B:91:0x0151, B:93:0x0157, B:95:0x015b, B:96:0x0163, B:97:0x0168, B:103:0x0178, B:107:0x017f, B:109:0x0185, B:133:0x01dc, B:110:0x0188, B:112:0x018e, B:114:0x0197, B:116:0x01a1, B:118:0x01a7, B:120:0x01b0, B:122:0x01b6, B:124:0x01ba, B:125:0x01c2, B:126:0x01c5, B:128:0x01cb, B:130:0x01d1, B:58:0x00de, B:60:0x00e4, B:63:0x00f6, B:50:0x00c3, B:156:0x0237, B:158:0x023b, B:160:0x0241, B:161:0x0248, B:163:0x0250, B:165:0x0254, B:166:0x0257, B:168:0x025b, B:170:0x025f, B:172:0x0265, B:173:0x0277, B:175:0x027b, B:177:0x0281, B:178:0x0293, B:179:0x029c, B:181:0x02a0, B:183:0x02a6, B:184:0x02a9, B:186:0x02b1, B:189:0x02be, B:193:0x02c9, B:195:0x02cd, B:197:0x02d5, B:199:0x02d9, B:200:0x0300), top: B:205:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x011f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:78:0x0121  */
    /* JADX WARN: Code duplicated, block: B:83:0x012f A[Catch: Exception -> 0x0335, TryCatch #0 {Exception -> 0x0335, blocks: (B:2:0x0000, B:4:0x0005, B:5:0x0007, B:7:0x000b, B:8:0x000d, B:10:0x0011, B:11:0x0014, B:13:0x001c, B:14:0x0021, B:16:0x0029, B:17:0x002e, B:19:0x0036, B:20:0x003b, B:22:0x0043, B:23:0x0048, B:25:0x004c, B:26:0x004f, B:31:0x0065, B:33:0x006d, B:35:0x007f, B:37:0x008f, B:40:0x0097, B:42:0x009f, B:44:0x00a7, B:46:0x00af, B:49:0x00c0, B:52:0x00cd, B:54:0x00d3, B:56:0x00d9, B:64:0x00f8, B:65:0x00fb, B:67:0x00ff, B:69:0x0105, B:71:0x010b, B:74:0x0117, B:79:0x0123, B:81:0x0129, B:83:0x012f, B:85:0x0138, B:87:0x0142, B:89:0x0148, B:91:0x0151, B:93:0x0157, B:95:0x015b, B:96:0x0163, B:97:0x0168, B:103:0x0178, B:107:0x017f, B:109:0x0185, B:133:0x01dc, B:110:0x0188, B:112:0x018e, B:114:0x0197, B:116:0x01a1, B:118:0x01a7, B:120:0x01b0, B:122:0x01b6, B:124:0x01ba, B:125:0x01c2, B:126:0x01c5, B:128:0x01cb, B:130:0x01d1, B:58:0x00de, B:60:0x00e4, B:63:0x00f6, B:50:0x00c3, B:156:0x0237, B:158:0x023b, B:160:0x0241, B:161:0x0248, B:163:0x0250, B:165:0x0254, B:166:0x0257, B:168:0x025b, B:170:0x025f, B:172:0x0265, B:173:0x0277, B:175:0x027b, B:177:0x0281, B:178:0x0293, B:179:0x029c, B:181:0x02a0, B:183:0x02a6, B:184:0x02a9, B:186:0x02b1, B:189:0x02be, B:193:0x02c9, B:195:0x02cd, B:197:0x02d5, B:199:0x02d9, B:200:0x0300), top: B:205:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0138 A[Catch: Exception -> 0x0335, TryCatch #0 {Exception -> 0x0335, blocks: (B:2:0x0000, B:4:0x0005, B:5:0x0007, B:7:0x000b, B:8:0x000d, B:10:0x0011, B:11:0x0014, B:13:0x001c, B:14:0x0021, B:16:0x0029, B:17:0x002e, B:19:0x0036, B:20:0x003b, B:22:0x0043, B:23:0x0048, B:25:0x004c, B:26:0x004f, B:31:0x0065, B:33:0x006d, B:35:0x007f, B:37:0x008f, B:40:0x0097, B:42:0x009f, B:44:0x00a7, B:46:0x00af, B:49:0x00c0, B:52:0x00cd, B:54:0x00d3, B:56:0x00d9, B:64:0x00f8, B:65:0x00fb, B:67:0x00ff, B:69:0x0105, B:71:0x010b, B:74:0x0117, B:79:0x0123, B:81:0x0129, B:83:0x012f, B:85:0x0138, B:87:0x0142, B:89:0x0148, B:91:0x0151, B:93:0x0157, B:95:0x015b, B:96:0x0163, B:97:0x0168, B:103:0x0178, B:107:0x017f, B:109:0x0185, B:133:0x01dc, B:110:0x0188, B:112:0x018e, B:114:0x0197, B:116:0x01a1, B:118:0x01a7, B:120:0x01b0, B:122:0x01b6, B:124:0x01ba, B:125:0x01c2, B:126:0x01c5, B:128:0x01cb, B:130:0x01d1, B:58:0x00de, B:60:0x00e4, B:63:0x00f6, B:50:0x00c3, B:156:0x0237, B:158:0x023b, B:160:0x0241, B:161:0x0248, B:163:0x0250, B:165:0x0254, B:166:0x0257, B:168:0x025b, B:170:0x025f, B:172:0x0265, B:173:0x0277, B:175:0x027b, B:177:0x0281, B:178:0x0293, B:179:0x029c, B:181:0x02a0, B:183:0x02a6, B:184:0x02a9, B:186:0x02b1, B:189:0x02be, B:193:0x02c9, B:195:0x02cd, B:197:0x02d5, B:199:0x02d9, B:200:0x0300), top: B:205:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0140  */
    /* JADX WARN: Code duplicated, block: B:96:0x0163 A[Catch: Exception -> 0x0335, TryCatch #0 {Exception -> 0x0335, blocks: (B:2:0x0000, B:4:0x0005, B:5:0x0007, B:7:0x000b, B:8:0x000d, B:10:0x0011, B:11:0x0014, B:13:0x001c, B:14:0x0021, B:16:0x0029, B:17:0x002e, B:19:0x0036, B:20:0x003b, B:22:0x0043, B:23:0x0048, B:25:0x004c, B:26:0x004f, B:31:0x0065, B:33:0x006d, B:35:0x007f, B:37:0x008f, B:40:0x0097, B:42:0x009f, B:44:0x00a7, B:46:0x00af, B:49:0x00c0, B:52:0x00cd, B:54:0x00d3, B:56:0x00d9, B:64:0x00f8, B:65:0x00fb, B:67:0x00ff, B:69:0x0105, B:71:0x010b, B:74:0x0117, B:79:0x0123, B:81:0x0129, B:83:0x012f, B:85:0x0138, B:87:0x0142, B:89:0x0148, B:91:0x0151, B:93:0x0157, B:95:0x015b, B:96:0x0163, B:97:0x0168, B:103:0x0178, B:107:0x017f, B:109:0x0185, B:133:0x01dc, B:110:0x0188, B:112:0x018e, B:114:0x0197, B:116:0x01a1, B:118:0x01a7, B:120:0x01b0, B:122:0x01b6, B:124:0x01ba, B:125:0x01c2, B:126:0x01c5, B:128:0x01cb, B:130:0x01d1, B:58:0x00de, B:60:0x00e4, B:63:0x00f6, B:50:0x00c3, B:156:0x0237, B:158:0x023b, B:160:0x0241, B:161:0x0248, B:163:0x0250, B:165:0x0254, B:166:0x0257, B:168:0x025b, B:170:0x025f, B:172:0x0265, B:173:0x0277, B:175:0x027b, B:177:0x0281, B:178:0x0293, B:179:0x029c, B:181:0x02a0, B:183:0x02a6, B:184:0x02a9, B:186:0x02b1, B:189:0x02be, B:193:0x02c9, B:195:0x02cd, B:197:0x02d5, B:199:0x02d9, B:200:0x0300), top: B:205:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x016e A[Catch: Exception -> 0x0233, TRY_ENTER, TryCatch #1 {Exception -> 0x0233, blocks: (B:75:0x011c, B:100:0x0170, B:154:0x0230, B:99:0x016e, B:134:0x01df, B:136:0x01e3, B:138:0x01e9, B:140:0x01f5, B:142:0x0201, B:145:0x020e, B:146:0x0212, B:148:0x0218, B:150:0x021e, B:152:0x0228, B:153:0x022c), top: B:207:0x011c }] */
    private void a() {
        boolean zA;
        ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList;
        int i2;
        APOfferwallTabInfo aPOfferwallTabInfo;
        long j2;
        int i3;
        ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList2;
        try {
            if (this.s != null) {
                this.s = null;
            }
            if (this.t != null) {
                this.t = null;
            }
            ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList3 = this.p;
            if (arrayList3 != null) {
                arrayList3.clear();
            }
            if (this.n.size() != 0) {
                this.n.clear();
            }
            if (this.o.size() != 0) {
                this.o.clear();
            }
            if (this.q.size() != 0) {
                this.q.clear();
            }
            if (this.r.size() != 0) {
                this.r.clear();
            }
            HashMap<String, String> map = this.W;
            if (map != null) {
                map.clear();
            }
            boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.DISABLE_SPECIAL_OFFER);
            int i4 = this.L0;
            if (i4 == 2 || i4 == 3) {
                zB = true;
            }
            for (int i5 = 0; i5 < this.m.size(); i5++) {
                com.igaworks.adpopcorn.cores.model.g gVar = this.m.get(i5);
                if (a(gVar.c()) && !com.igaworks.adpopcorn.a.b.a().g(this.f1576b, gVar.c())) {
                    int i6 = this.S0;
                    if (i6 == 8) {
                        zA = true;
                        for (int i7 = 0; i7 < this.R0.getTabCount(); i7++) {
                            if (this.R0.getTabType(i7) != 8 && this.R0.getTabType(i7) != 0 && com.igaworks.adpopcorn.cores.common.k.a(this.R0.getTabType(i7), gVar.K())) {
                                zA = false;
                            }
                        }
                    } else {
                        zA = com.igaworks.adpopcorn.cores.common.k.a(i6, gVar.K());
                    }
                    if (zA && (gVar.a0() || gVar.X())) {
                        arrayList = this.q;
                    } else {
                        if (zA && gVar.c0()) {
                            if (com.igaworks.adpopcorn.a.b.a().f(this.f1576b, gVar.C())) {
                                zA = false;
                            } else {
                                arrayList = this.r;
                            }
                        }
                        i2 = this.K0;
                        if (i2 == 2) {
                            if (gVar.f0() && gVar.r() != null && gVar.r().length() > 0) {
                                if (zA) {
                                    this.n.add(gVar);
                                }
                                try {
                                    j2 = this.P0;
                                    this.P0 = j2 + gVar.Q();
                                } catch (Exception unused) {
                                }
                            }
                        } else if (i2 == 3) {
                            if (zA && !gVar.f0()) {
                                if (gVar.W()) {
                                    this.t = gVar;
                                    this.n.add(0, gVar);
                                    if (!zB) {
                                        this.p.add(0, gVar);
                                        this.s = gVar;
                                    }
                                } else if (zB && gVar.x()) {
                                    this.p.add(gVar);
                                    ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList4 = this.p;
                                    if (arrayList4 == null || arrayList4.size() > 1 || this.t != null) {
                                        this.n.add(gVar);
                                    } else {
                                        this.s = gVar;
                                        this.n.add(0, gVar);
                                    }
                                } else {
                                    this.n.add(gVar);
                                }
                            }
                            if (!gVar.f0()) {
                                j2 = this.P0;
                                this.P0 = j2 + gVar.Q();
                            }
                        } else {
                            if (zA) {
                                i3 = this.L0;
                                if (i3 != 2 || i3 == 3) {
                                    if (gVar.f0() && gVar.r() != null && gVar.r().length() > 0) {
                                        arrayList2 = this.n;
                                        arrayList2.add(gVar);
                                    }
                                } else if (gVar.f0()) {
                                    arrayList2 = this.o;
                                    arrayList2.add(gVar);
                                } else if (gVar.W()) {
                                    this.t = gVar;
                                    this.n.add(0, gVar);
                                    if (!zB) {
                                        this.p.add(0, gVar);
                                        this.s = gVar;
                                    }
                                } else {
                                    if (!zB && gVar.x()) {
                                        this.p.add(gVar);
                                        ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList5 = this.p;
                                        if (arrayList5 != null && arrayList5.size() <= 1 && this.t == null) {
                                            this.s = gVar;
                                            this.n.add(0, gVar);
                                        }
                                    }
                                    arrayList2 = this.n;
                                    arrayList2.add(gVar);
                                }
                            }
                            aPOfferwallTabInfo = this.R0;
                            if (aPOfferwallTabInfo != null || aPOfferwallTabInfo.getTabCount() <= 1) {
                                j2 = this.P0;
                            } else if (!com.igaworks.adpopcorn.cores.common.k.a(9, gVar.K()) && !com.igaworks.adpopcorn.cores.common.k.a(10, gVar.K()) && !com.igaworks.adpopcorn.cores.common.k.a(11, gVar.K())) {
                                j2 = this.P0;
                            } else if (!gVar.f0() && gVar.r() != null && gVar.r().length() > 0) {
                                j2 = this.P0;
                            }
                            this.P0 = j2 + gVar.Q();
                        }
                    }
                    arrayList.add(gVar);
                    i2 = this.K0;
                    if (i2 == 2) {
                        if (gVar.f0()) {
                        }
                    } else if (i2 == 3) {
                        if (zA) {
                            if (gVar.W()) {
                                this.t = gVar;
                                this.n.add(0, gVar);
                                if (!zB) {
                                    this.p.add(0, gVar);
                                    this.s = gVar;
                                }
                            } else if (zB) {
                                this.n.add(gVar);
                            } else {
                                this.n.add(gVar);
                            }
                        }
                        if (!gVar.f0()) {
                            j2 = this.P0;
                            this.P0 = j2 + gVar.Q();
                        }
                    } else {
                        if (zA) {
                            i3 = this.L0;
                            if (i3 != 2) {
                                if (gVar.f0()) {
                                }
                            } else if (gVar.f0()) {
                            }
                        }
                        aPOfferwallTabInfo = this.R0;
                        if (aPOfferwallTabInfo != null) {
                            j2 = this.P0;
                            this.P0 = j2 + gVar.Q();
                        } else {
                            j2 = this.P0;
                            this.P0 = j2 + gVar.Q();
                        }
                    }
                }
            }
            ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList6 = this.o;
            if (arrayList6 != null && arrayList6.size() > 0) {
                this.n.addAll(this.o);
            }
            if (isLandscapeMode(this.f1576b, false)) {
                ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList7 = this.u;
                if (arrayList7 != null) {
                    arrayList7.clear();
                }
                if (this.s != null) {
                    ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList8 = this.n;
                    if (arrayList8 != null && arrayList8.size() > 0) {
                        this.u.add(this.n.get(0));
                        this.n.remove(0);
                    }
                    ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList9 = this.n;
                    if (arrayList9 != null && arrayList9.size() > 0) {
                        this.u.add(this.n.get(0));
                        this.n.remove(0);
                    }
                    this.i0.a(this.u, this.t0);
                }
            }
            if (this.p != null) {
                this.v = 0;
                ViewFlipper viewFlipper = this.k0;
                if (viewFlipper != null) {
                    viewFlipper.removeAllViews();
                }
                int iC = !isLandscapeMode(this.f1576b, false) ? com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.SPECIAL_OFFER_TOP_ROUND_DP) : 0;
                for (int i8 = 0; i8 < this.p.size(); i8++) {
                    if (i8 != 0 || this.t == null || isLandscapeMode(this.f1576b, false) || this.x) {
                        Context context = this.f1576b;
                        com.igaworks.adpopcorn.activity.c.i iVar = new com.igaworks.adpopcorn.activity.c.i(context, com.igaworks.adpopcorn.cores.common.d.a(context, iC));
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        iVar.setScaleType(ImageView.ScaleType.FIT_XY);
                        iVar.setLayoutParams(layoutParams);
                        this.k0.addView(iVar);
                        com.igaworks.adpopcorn.cores.common.e.a(this.f1576b, this.p.get(i8).T(), iVar, 0, 0, (com.igaworks.adpopcorn.cores.common.e.b) null);
                    } else {
                        Context context2 = this.f1576b;
                        this.y = new com.igaworks.adpopcorn.activity.c.i(context2, com.igaworks.adpopcorn.cores.common.d.a(context2, iC));
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                        this.y.setScaleType(ImageView.ScaleType.FIT_XY);
                        this.y.setLayoutParams(layoutParams2);
                        this.k0.addView(this.y);
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:36:0x00db A[Catch: Exception -> 0x0140, TryCatch #0 {Exception -> 0x0140, blocks: (B:2:0x0000, B:5:0x0005, B:9:0x002b, B:12:0x0035, B:13:0x003f, B:15:0x004f, B:17:0x0053, B:19:0x00a7, B:18:0x007f, B:14:0x0044, B:20:0x00ae, B:21:0x00b2, B:23:0x00c2, B:39:0x00e3, B:41:0x00e7, B:42:0x00ec, B:44:0x00f0, B:45:0x00f5, B:47:0x00fe, B:49:0x0102, B:51:0x010a, B:52:0x0122, B:55:0x0128, B:36:0x00db, B:31:0x00d0, B:34:0x00d6, B:38:0x00e0), top: B:58:0x0000 }] */
    public void a(int i2) {
        TextView textView;
        List<ImageView> list;
        FrameLayout.LayoutParams layoutParams;
        try {
            if (this.T0 == i2) {
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, 2));
            layoutParams2.gravity = 80;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, 0.5f));
            layoutParams3.gravity = 80;
            for (int i3 = 0; i3 < 2; i3++) {
                for (int i4 = 0; i4 < this.R0.getTabCount(); i4++) {
                    if (i3 == 0) {
                        textView = this.H0.get(i4);
                        list = this.J0;
                    } else {
                        textView = this.G0.get(i4);
                        list = this.I0;
                    }
                    ImageView imageView = list.get(i4);
                    if (i2 == i4) {
                        textView.setTextColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_SELECT_TEXT_COLOR));
                        imageView.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_SELECT_LINE_COLOR));
                        textView.setTypeface(textView.getTypeface(), 1);
                        textView.setPaintFlags(textView.getPaintFlags() | 32);
                        layoutParams = layoutParams2;
                    } else {
                        textView.setTextColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_UNSELECT_TEXT_COLOR));
                        imageView.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_UNSELECT_LINE_COLOR));
                        textView.setTypeface(null, 0);
                        textView.setPaintFlags(textView.getPaintFlags() ^ 32);
                        layoutParams = layoutParams3;
                    }
                    imageView.setLayoutParams(layoutParams);
                }
            }
            int tabType = this.R0.getTabType(i2);
            this.S0 = tabType;
            int i5 = this.K0;
            if (i5 == 0) {
                this.L0 = 0;
                if (tabType == 9 || tabType == 10 || tabType == 11) {
                    this.L0 = 2;
                }
            } else if (i5 == 1) {
                this.L0 = 1;
                if (tabType == 9 || tabType == 10) {
                    this.L0 = 3;
                }
            } else if (i5 == 2) {
                this.L0 = 2;
            } else if (i5 == 3) {
                this.L0 = 4;
            }
            com.igaworks.adpopcorn.activity.a.a aVar = this.j;
            if (aVar != null) {
                aVar.a(this.L0);
            }
            com.igaworks.adpopcorn.activity.layout.a aVar2 = this.w;
            if (aVar2 != null) {
                aVar2.setVisibility(8);
            }
            c(false);
            this.T0 = i2;
            if (this.t != null && this.w != null && !isLandscapeMode(this.f1576b, false)) {
                com.igaworks.adpopcorn.activity.layout.a aVar3 = this.w;
                aVar3.a((View) aVar3, this.f1576b, this.t, false, this.t0, 0);
                this.w.setOnClickListener(new n());
            }
            com.igaworks.adpopcorn.a.d dVar = this.z;
            if (dVar != null) {
                dVar.b("media_offerwall_tab_visit", this.S0 + "");
            }
        } catch (Exception unused) {
        }
    }

    private void a(int i2, com.igaworks.adpopcorn.cores.model.f fVar) {
        String str;
        String str2;
        com.igaworks.adpopcorn.a.g.a aVar;
        com.igaworks.adpopcorn.cores.model.g gVar;
        if (fVar != null && fVar.d()) {
            h();
            com.igaworks.adpopcorn.cores.common.g gVar2 = this.d;
            str = gVar2.p;
            str2 = gVar2.e;
        } else {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    int i3 = 3;
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1576b, "ApOfferWallLayout", "callbackCheckCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    int i4 = jSONObject.getInt("ResultCode");
                    boolean z2 = jSONObject.getBoolean("Result");
                    this.m0 = this.S.d0();
                    if (!z2) {
                        h();
                        if (i4 != 2000) {
                            com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
                            a(gVar3.p, gVar3.x, true);
                            return;
                        }
                        int i5 = this.K;
                        if (i5 != 25 || i5 != 24) {
                            com.igaworks.adpopcorn.a.b.a().b(this.f1576b, this.S.c());
                        }
                        com.igaworks.adpopcorn.cores.common.g gVar4 = this.d;
                        a(gVar4.Y, gVar4.i, true);
                        c(false);
                        return;
                    }
                    this.O = jSONObject.getString("Auth");
                    this.J = jSONObject.getInt("Status");
                    int iK = this.S.K();
                    this.K = iK;
                    if (i2 != 2) {
                        if (iK == 1 || iK == 2) {
                            h();
                            int i6 = this.J;
                            if (i6 != 0 && i6 != 50 && i6 != 125) {
                                d(PointerIconCompat.TYPE_WAIT);
                                return;
                            }
                        } else if (iK == 6 || iK == 7 || iK == 23) {
                            aVar = this.a0;
                            gVar = this.S;
                        }
                        w();
                        return;
                    }
                    if (iK != 6 && iK != 7 && iK != 23) {
                        this.z.b("media_offerwall_tab_content_engagement", this.M);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("auth", this.O);
                            jSONObject2.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1576b));
                            jSONObject2.put("channel_code", this.x0);
                            this.a0.a(1, this.B, jSONObject2, this);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    aVar = this.a0;
                    i3 = 4;
                    gVar = this.S;
                    aVar.a(i3, gVar.J(), "", this);
                    return;
                } catch (JSONException e3) {
                    h();
                    com.igaworks.adpopcorn.cores.common.g gVar5 = this.d;
                    a(gVar5.I, gVar5.p, true);
                    e3.printStackTrace();
                    return;
                }
            }
            h();
            com.igaworks.adpopcorn.cores.common.g gVar6 = this.d;
            str = gVar6.I;
            str2 = gVar6.g;
        }
        a(str, str2, true);
    }

    private void a(com.igaworks.adpopcorn.cores.model.f fVar) {
        if (this.e0 == 1) {
            com.igaworks.adpopcorn.a.b.a().a(this.f1576b);
        }
        new Handler(Looper.getMainLooper()).post(new l0(fVar));
    }

    private void a(String str, String str2, double d2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, boolean z2, String str11, int i3, String str12, String str13, String str14) {
        try {
            this.f1576b.startActivity(new Intent(this.f1576b, (Class<?>) ApVideoAdActivity.class).putExtra("cKey", str).putExtra("joinAuth", str2).putExtra("averageRating", d2).putExtra("landscapeImageURL", str3).putExtra("clickAction", str4).putExtra("campaignDescription", str5).putExtra("iconImageURL", str6).putExtra("campaignName", str7).putExtra("numberOfDownloads", str8).putExtra("redirectURL", str9).putExtra("videoURL", str10).putExtra("ADType", i2).putExtra("AutoRedirect", z2).putExtra("fromVideoAPI", false).putExtra("rewardName", str11).putExtra("skipAllowSeconds", i3).putExtra("videoImpressionURL", str12).putExtra("moreClickReportURL", str13).putExtra("PartiTypeCode", this.K).putExtra("campaignCondition", str14));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, boolean z2) {
        h();
        e();
        String str3 = this.d.h;
        try {
            Context context = this.f1576b;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.p0, str, str2, -1, str3, new z(), isLandscapeMode(context, false), false);
            this.n0 = aVar;
            aVar.setCancelable(false);
            this.n0.setCanceledOnTouchOutside(false);
            this.n0.show();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2) {
        if (z2) {
            try {
                showProgressDialog(this.d.s, false);
            } catch (Exception unused) {
                h();
                return;
            }
        }
        if (this.a0 == null) {
            this.a0 = new com.igaworks.adpopcorn.a.g.a(this.f1576b);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("auth", this.O);
        jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1576b));
        this.a0.a(11, this.D, jSONObject, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2, String str) {
        String installerPackageName;
        com.igaworks.adpopcorn.a.g.a aVar;
        int i2;
        String str2;
        String str3 = this.O;
        String str4 = this.M;
        try {
            installerPackageName = this.f1576b.getPackageManager().getInstallerPackageName(str);
        } catch (Exception unused) {
            installerPackageName = null;
        }
        try {
            com.igaworks.adpopcorn.cores.common.h.a(this.f1576b, "ApOfferWallLayout", "sendCompleteRewardRequest installer = " + installerPackageName, 3);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", this.O);
            jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1576b));
            jSONObject.put("sign", com.igaworks.adpopcorn.cores.common.c.a(str4, str3));
            jSONObject.put(TapjoyConstants.TJC_INSTALLER, installerPackageName);
            if (z2) {
                aVar = this.a0;
                i2 = 5;
                str2 = this.C;
            } else {
                aVar = this.a0;
                i2 = 19;
                str2 = this.E;
            }
            aVar.a(i2, str2, jSONObject, this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean a(String str) {
        if (!com.igaworks.adpopcorn.cores.common.k.a(str)) {
            return true;
        }
        HashMap<String, String> map = this.W;
        if (map != null && map.containsKey(str)) {
            return false;
        }
        List<String> list = this.U0;
        if (list != null && list.contains(str)) {
            return false;
        }
        HashMap<String, String> map2 = this.W;
        if (map2 != null) {
            map2.put(str, str);
        }
        return true;
    }

    private com.igaworks.adpopcorn.activity.layout.b b(int i2) {
        com.igaworks.adpopcorn.activity.layout.b bVar = new com.igaworks.adpopcorn.activity.layout.b(this.c, i2);
        this.g0 = (LinearLayout) bVar.findViewById(0);
        TextView textView = (TextView) bVar.findViewById(1);
        this.g0.setVisibility(8);
        textView.setText(this.d.V);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            this.v++;
            ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList = this.p;
            if (arrayList == null || arrayList.size() <= 1) {
                return;
            }
            if (this.v >= this.p.size()) {
                this.v = 0;
            }
            com.igaworks.adpopcorn.cores.model.g gVar = this.p.get(this.v);
            this.s = gVar;
            if (gVar != null) {
                this.k0.showNext();
                z();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void b(int i2, com.igaworks.adpopcorn.cores.model.f fVar) {
        try {
            if (fVar != null) {
                try {
                    if (fVar.c()) {
                        int i3 = this.K;
                        if (i3 == 6) {
                            h();
                            int i4 = this.J;
                            if (i4 != 0) {
                                if (i4 == 50 || i4 == 125) {
                                    if (i2 == 4) {
                                        this.z.b("media_offerwall_tab_content_engagement", this.M);
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("auth", this.O);
                                        jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1576b));
                                        jSONObject.put("channel_code", this.x0);
                                        this.a0.a(1, this.B, jSONObject, this);
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
                            int i5 = this.J;
                            if (i5 != 0) {
                                if (i5 == 50) {
                                    if (i3 != 23) {
                                        a(true, this.S.J());
                                        return;
                                    } else {
                                        h();
                                        d(PointerIconCompat.TYPE_ALL_SCROLL);
                                        return;
                                    }
                                }
                                if (i5 == 125) {
                                    this.L = true;
                                    this.z.b("media_offerwall_tab_content_engagement", this.M);
                                    try {
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("auth", this.O);
                                        jSONObject2.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1576b));
                                        jSONObject2.put("channel_code", this.x0);
                                        this.a0.a(1, this.B, jSONObject2, this);
                                        return;
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                        return;
                                    }
                                }
                                return;
                            }
                            h();
                        }
                        d(1002);
                        return;
                    }
                } catch (Exception unused) {
                    h();
                    return;
                }
            }
            if (i2 == 4) {
                this.z.b("media_offerwall_tab_content_engagement", this.M);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("auth", this.O);
                jSONObject3.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1576b));
                jSONObject3.put("channel_code", this.x0);
                this.a0.a(1, this.B, jSONObject3, this);
                return;
            }
            h();
            int i6 = this.K;
            if (i6 == 6) {
                int i7 = this.J;
                if (i7 != 0 && i7 != 50 && i7 != 125) {
                    return;
                }
            } else {
                if (i6 != 7 && i6 != 23) {
                    return;
                }
                int i8 = this.J;
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

    private void b(com.igaworks.adpopcorn.cores.model.f fVar) {
        String str;
        String str2;
        com.igaworks.adpopcorn.cores.model.g gVar;
        String strF;
        h();
        if (fVar != null && fVar.d()) {
            com.igaworks.adpopcorn.cores.common.g gVar2 = this.d;
            str = gVar2.p;
            str2 = gVar2.e;
        } else {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1576b, "ApOfferWallLayout", "callbackJoinCPMCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    String string = jSONObject.getString("CPMParticipatedTid");
                    if (!z2) {
                        com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
                        a(gVar3.p, gVar3.e, false);
                        return;
                    }
                    if (this.S.l() == 16) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(ScarConstants.TOKEN_ID_KEY, string);
                        String string2 = jSONObject2.toString();
                        try {
                            string2 = URLEncoder.encode(jSONObject2.toString(), "utf-8");
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        strF = this.S.f() + "&custom=" + string2;
                    } else {
                        if (this.S.l() == 40) {
                            if (this.S.Y()) {
                                com.igaworks.adpopcorn.cores.common.h.a(this.f1576b, "ApOfferWallLayout", "callbackJoinCPMCampaign already completed", 3);
                            } else {
                                b(jSONObject.getString("Auth"));
                                this.S.c(true);
                            }
                            gVar = this.S;
                        } else {
                            gVar = this.S;
                        }
                        strF = gVar.f();
                    }
                    d(strF);
                    try {
                        Iterator<String> it = this.S.e().iterator();
                        while (it.hasNext()) {
                            this.a0.a(14, it.next(), "", new i0(this));
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
            String strD = this.S.d();
            if (this.S == null) {
                com.igaworks.adpopcorn.cores.common.h.a(this.f1576b, "ApOfferWallLayout", "completeCampaign failed", 3);
                return;
            }
            com.igaworks.adpopcorn.cores.common.h.a(this.f1576b, "ApOfferWallLayout", "completeCampaign success", 3);
            if (this.a0 == null) {
                this.a0 = new com.igaworks.adpopcorn.a.g.a(this.f1576b);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", str);
            jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1576b));
            jSONObject.put("sign", com.igaworks.adpopcorn.cores.common.c.a(strD, str));
            if (com.igaworks.adpopcorn.a.d.E) {
                aVar = this.a0;
                str2 = "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/CompleteCPMClick";
            } else {
                aVar = this.a0;
                str2 = "https://apapi.adpopcorn.com/ap/v1/common/conversion/CompleteCPMClick";
            }
            aVar.a(28, str2, jSONObject, this);
        } catch (Exception e2) {
            com.igaworks.adpopcorn.cores.common.h.a(this.f1576b, "ApOfferWallLayout", "completeCampaign failed : " + e2.getMessage(), 3);
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            a(gVar.Y, gVar.e, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, boolean z2) {
        try {
            h();
            e();
            String str3 = this.d.I;
            Context context = this.f1576b;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.p0, str3, str, 1, str2, new o(z2), isLandscapeMode(context, false), false);
            this.n0 = aVar;
            aVar.setCancelable(false);
            this.n0.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z2) {
        LinearLayout linearLayout;
        int i2;
        if (z2) {
            linearLayout = this.g0;
            i2 = 8;
        } else {
            linearLayout = this.g0;
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
    }

    private LinearLayout c(int i2) {
        FrameLayout.LayoutParams layoutParams;
        int paintFlags;
        List<ImageView> list;
        this.D0 = new LinearLayout(this.c);
        LinearLayout linearLayout = new LinearLayout(this.c);
        try {
            int tabCount = this.R0.getTabCount();
            int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_HEIGHT);
            int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_BAR_HEIGHT);
            int iC3 = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.ENABLE_TOP_BAR_EXPAND_MENU) ? com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_HEIGHT) : 0;
            if (this.q0) {
                iC = 0;
                iC3 = 0;
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, iC2));
            layoutParams2.gravity = 49;
            layoutParams2.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.c, iC + iC3 + i2);
            this.D0.setOrientation(0);
            this.D0.setGravity(17);
            this.D0.setLayoutParams(layoutParams2);
            this.D0.setBackgroundColor(Color.parseColor("#ffffff"));
            ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, iC2));
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            linearLayout.setLayoutParams(layoutParams3);
            linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            List<TextView> list2 = this.G0;
            if (list2 == null) {
                this.G0 = new ArrayList();
            } else {
                list2.clear();
            }
            List<TextView> list3 = this.H0;
            if (list3 == null) {
                this.H0 = new ArrayList();
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
            int i3 = 0;
            while (true) {
                int i4 = 2;
                if (i3 >= 2) {
                    break;
                }
                int i5 = 0;
                while (i5 < tabCount) {
                    FrameLayout frameLayout = new FrameLayout(this.c);
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, com.igaworks.adpopcorn.cores.common.d.a(this.c, iC2), 1.0f);
                    layoutParams4.gravity = 17;
                    frameLayout.setLayoutParams(layoutParams4);
                    frameLayout.setTag(Integer.valueOf(i5));
                    frameLayout.setOnClickListener(new m());
                    TextView textView = new TextView(this.c);
                    textView.setLayoutParams(new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, 50)));
                    textView.setGravity(17);
                    textView.setTextColor(Color.parseColor("#1e1e21"));
                    textView.setTextSize(1, 16.0f);
                    textView.setText(this.R0.getTabTitle(i5));
                    textView.setTag(Integer.valueOf(i5));
                    frameLayout.addView(textView);
                    ImageView imageView = new ImageView(this.c);
                    imageView.setTag(Integer.valueOf(i5));
                    if (i5 == 0) {
                        layoutParams = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, i4));
                        textView.setTextColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_SELECT_TEXT_COLOR));
                        imageView.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_SELECT_LINE_COLOR));
                        textView.setTypeface(textView.getTypeface(), 1);
                        paintFlags = textView.getPaintFlags() | 32;
                    } else {
                        layoutParams = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, 0.5f));
                        textView.setTextColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_UNSELECT_TEXT_COLOR));
                        imageView.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_UNSELECT_LINE_COLOR));
                        textView.setTypeface(null, 0);
                        paintFlags = textView.getPaintFlags() ^ 32;
                    }
                    textView.setPaintFlags(paintFlags);
                    layoutParams.gravity = 80;
                    imageView.setLayoutParams(layoutParams);
                    frameLayout.addView(imageView);
                    if (i3 == 0) {
                        this.D0.addView(frameLayout);
                        this.H0.add(textView);
                        list = this.J0;
                    } else {
                        linearLayout.addView(frameLayout);
                        this.G0.add(textView);
                        list = this.I0;
                    }
                    list.add(imageView);
                    i5++;
                    i4 = 2;
                }
                i3++;
            }
        } catch (Exception unused) {
        }
        this.f.addView(this.D0);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            ArrayList<String> arrayList = this.v0;
            if (arrayList == null || arrayList.contains(this.s.c()) || !com.igaworks.adpopcorn.cores.common.k.a(this.k0)) {
                return;
            }
            this.v0.add(this.s.c());
        } catch (Exception unused) {
        }
    }

    private void c(com.igaworks.adpopcorn.cores.model.f fVar) {
        String str;
        String str2;
        if (fVar != null && fVar.d()) {
            h();
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            str = gVar.p;
            str2 = gVar.e;
        } else {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1576b, "ApOfferWallLayout", "callbackJoinCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    String string = jSONObject.getString("ResultMsg");
                    int i2 = jSONObject.getInt("ResultCode");
                    if (!jSONObject.has("RedirectURL") || jSONObject.isNull("RedirectURL")) {
                        this.P = "";
                    } else {
                        this.P = jSONObject.getString("RedirectURL");
                    }
                    if (!jSONObject.has("HideBrowser") || jSONObject.isNull("HideBrowser")) {
                        this.R = false;
                    } else {
                        this.R = jSONObject.getBoolean("HideBrowser");
                    }
                    if (jSONObject.has("ParticipatedTid") && !jSONObject.isNull("ParticipatedTid")) {
                        this.Q = jSONObject.getLong("ParticipatedTid") + "";
                    }
                    if (!z2) {
                        h();
                        if (i2 != 999 && i2 != 1000) {
                            a(this.d.q, string, true);
                            return;
                        }
                        com.igaworks.adpopcorn.cores.common.g gVar2 = this.d;
                        a(gVar2.q, gVar2.l0, true);
                        return;
                    }
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1576b, "ApOfferWallLayout", "callbackJoinCampaign success, useHiddenBrowser = " + this.R + ", redirectURL = " + this.P, 3);
                    this.O = jSONObject.getString("Auth");
                    if (this.L) {
                        a(true, this.S.J());
                        this.L = false;
                        return;
                    }
                    int i3 = this.K;
                    if (i3 == 10) {
                        h();
                        c(this.P);
                        return;
                    }
                    if (i3 != 16 && i3 != 26 && i3 != 27) {
                        if (i3 == 25) {
                            h();
                            try {
                                if (c(this.S.J())) {
                                    a(false, this.S.J());
                                } else {
                                    e();
                                    com.igaworks.adpopcorn.a.b.a().b(this.c, "participateFlag", this.M, true);
                                    com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
                                    String str3 = gVar3.I;
                                    String str4 = gVar3.u0;
                                    String str5 = gVar3.z;
                                    String str6 = gVar3.y;
                                    Context context = this.f1576b;
                                    com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.p0, str3, str4, -1, str5, new f0(), str6, new g0(), isLandscapeMode(context, false));
                                    this.n0 = aVar;
                                    aVar.setCancelable(false);
                                    this.n0.show();
                                }
                                return;
                            } catch (Exception unused) {
                                return;
                            }
                        }
                        h();
                        if (this.S.X()) {
                            this.S.c(true);
                            try {
                                Iterator<String> it = this.S.e().iterator();
                                while (it.hasNext()) {
                                    this.a0.a(14, it.next(), "", new h0(this));
                                }
                            } catch (Exception unused2) {
                            }
                        }
                        if (this.S.h0()) {
                            this.P = this.S.M();
                        }
                        if (com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.PASS_PARTICIPATE_EVENT)) {
                            this.z.a(this.P, this.M, this.Q, (String) null);
                            return;
                        }
                        if (this.R) {
                            e(this.P);
                            return;
                        }
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(this.P));
                        try {
                            this.f1576b.startActivity(intent);
                            return;
                        } catch (Exception e2) {
                            com.igaworks.adpopcorn.cores.common.g gVar4 = this.d;
                            a(gVar4.q, gVar4.w, true);
                            e2.printStackTrace();
                            return;
                        }
                    }
                    a(false);
                    return;
                } catch (JSONException e3) {
                    h();
                    com.igaworks.adpopcorn.cores.common.g gVar5 = this.d;
                    a(gVar5.p, gVar5.e, false);
                    e3.printStackTrace();
                    return;
                }
            }
            h();
            com.igaworks.adpopcorn.cores.common.g gVar6 = this.d;
            str = gVar6.Y;
            str2 = gVar6.g;
        }
        a(str, str2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:70:0x00db A[Catch: Exception -> 0x0113, TryCatch #0 {Exception -> 0x0113, blocks: (B:3:0x0002, B:6:0x000e, B:9:0x0016, B:11:0x0021, B:13:0x0027, B:14:0x0035, B:16:0x003c, B:18:0x0042, B:20:0x0046, B:22:0x004c, B:24:0x0050, B:26:0x0056, B:31:0x0060, B:33:0x0064, B:50:0x00a3, B:52:0x00a8, B:54:0x00ac, B:56:0x00b0, B:58:0x00b4, B:60:0x00bc, B:65:0x00cf, B:67:0x00d3, B:69:0x00d7, B:70:0x00db, B:72:0x00df, B:61:0x00c0, B:63:0x00c8, B:64:0x00cc, B:73:0x00e2, B:75:0x00ea, B:77:0x00ee, B:78:0x00f0, B:82:0x00fa, B:83:0x00fd, B:85:0x0101, B:86:0x0104, B:79:0x00f3, B:81:0x00f7, B:35:0x006a, B:37:0x0072, B:39:0x0076, B:41:0x007c, B:43:0x0087, B:29:0x005c, B:45:0x0092, B:47:0x0096, B:49:0x009c, B:87:0x0108), top: B:92:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x00df A[Catch: Exception -> 0x0113, TryCatch #0 {Exception -> 0x0113, blocks: (B:3:0x0002, B:6:0x000e, B:9:0x0016, B:11:0x0021, B:13:0x0027, B:14:0x0035, B:16:0x003c, B:18:0x0042, B:20:0x0046, B:22:0x004c, B:24:0x0050, B:26:0x0056, B:31:0x0060, B:33:0x0064, B:50:0x00a3, B:52:0x00a8, B:54:0x00ac, B:56:0x00b0, B:58:0x00b4, B:60:0x00bc, B:65:0x00cf, B:67:0x00d3, B:69:0x00d7, B:70:0x00db, B:72:0x00df, B:61:0x00c0, B:63:0x00c8, B:64:0x00cc, B:73:0x00e2, B:75:0x00ea, B:77:0x00ee, B:78:0x00f0, B:82:0x00fa, B:83:0x00fd, B:85:0x0101, B:86:0x0104, B:79:0x00f3, B:81:0x00f7, B:35:0x006a, B:37:0x0072, B:39:0x0076, B:41:0x007c, B:43:0x0087, B:29:0x005c, B:45:0x0092, B:47:0x0096, B:49:0x009c, B:87:0x0108), top: B:92:0x0002 }] */
    public void c(boolean z2) {
        com.igaworks.adpopcorn.activity.c.e eVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList;
        try {
            this.P0 = 0L;
            h();
            List<com.igaworks.adpopcorn.cores.model.g> list = this.m;
            if (list != null && (list == null || list.size() != 0)) {
                a("", false);
                com.igaworks.adpopcorn.a.c cVar = this.e;
                if (cVar != null && cVar.d()) {
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1576b, "ApOfferWallLayout", "sign1 : true", 3);
                    com.igaworks.adpopcorn.cores.common.j.f(this.f1576b);
                }
                a();
                if (this.T0 == 0 && this.S0 == 10 && ((arrayList = this.q) == null || arrayList.size() == 0)) {
                    a(1);
                    return;
                }
                int i2 = this.K0;
                if (!(i2 == 3 && this.S0 == 0) && (i2 == 3 || this.S0 != 8)) {
                    ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList2 = this.n;
                    if (arrayList2 == null || arrayList2.size() == 0) {
                        a(this.d.f, true);
                    }
                } else {
                    ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList3 = this.n;
                    if (arrayList3 == null || arrayList3.size() == 0) {
                        if (!isLandscapeMode(this.f1576b, false)) {
                            f(false);
                            a(this.d.f, true);
                            return;
                        }
                        ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList4 = this.u;
                        if (arrayList4 == null || arrayList4.size() == 0) {
                            f(false);
                            a(this.d.f, true);
                            return;
                        }
                    }
                }
                if (this.K0 != 2) {
                    if (this.t != null) {
                        if (this.e0 == 1 && !this.x && !isLandscapeMode(this.f1576b, false)) {
                            e(true);
                        } else if (isLandscapeMode(this.f1576b, false)) {
                        }
                        if (this.s != null || (linearLayout2 = this.j0) == null) {
                            linearLayout = this.j0;
                            if (linearLayout != null) {
                                linearLayout.setVisibility(8);
                            }
                        } else {
                            linearLayout2.setVisibility(0);
                        }
                    } else {
                        this.x = true;
                    }
                    z();
                    if (this.s != null) {
                        linearLayout = this.j0;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(8);
                        }
                    } else {
                        linearLayout = this.j0;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(8);
                        }
                    }
                }
                if (isLandscapeMode(this.f1576b, false)) {
                    if (this.e0 == 1) {
                        eVar = this.l;
                        eVar.setAdapter((ListAdapter) this.j);
                    }
                } else if (this.e0 == 1) {
                    eVar = this.k;
                    eVar.setAdapter((ListAdapter) this.j);
                }
                com.igaworks.adpopcorn.activity.a.a aVar = this.j;
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
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
        try {
            Intent launchIntentForPackage = this.f1576b.getPackageManager().getLaunchIntentForPackage(str);
            launchIntentForPackage.setFlags(268435456);
            this.f1576b.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            String strD = com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.BOTTOM_BAR_LINK_URL);
            if (strD == null || !strD.contentEquals("https://reward.adpopcorn.com")) {
                d(strD);
            } else {
                e();
                com.igaworks.adpopcorn.cores.common.g gVar = this.d;
                String str = gVar.Y;
                String str2 = gVar.W0;
                String str3 = gVar.c0;
                String str4 = gVar.b0;
                Context context = this.f1576b;
                com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.p0, str, str2, -1, str3, new b(), str4, new c(strD), isLandscapeMode(context, false));
                this.n0 = aVar;
                aVar.setCancelable(true);
                this.n0.show();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void d(int i2) {
        String str;
        try {
            e();
            h();
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
                    Context context = this.f1576b;
                    com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.p0, str2, str, -1, str3, new r(i2), isLandscapeMode(context, false), false);
                    this.n0 = aVar;
                    aVar.setCancelable(false);
                    this.n0.show();
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
                    Context context2 = this.f1576b;
                    com.igaworks.adpopcorn.activity.b.d.a aVar2 = new com.igaworks.adpopcorn.activity.b.d.a(context2, this.p0, str2, str, -1, str4, new s(), str5, new t(), isLandscapeMode(context2, false));
                    this.n0 = aVar2;
                    aVar2.setCancelable(false);
                    this.n0.show();
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

    private void d(com.igaworks.adpopcorn.cores.model.f fVar) {
        String str;
        String str2;
        h();
        if (fVar != null && fVar.d()) {
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            str = gVar.p;
            str2 = gVar.e;
        } else {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1576b, "ApOfferWallLayout", "callbackJoinNewsCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    jSONObject.getString("NewsParticipatedTid");
                    this.O = jSONObject.getString("Auth");
                    if (z2) {
                        com.igaworks.adpopcorn.activity.b.g gVar2 = new com.igaworks.adpopcorn.activity.b.g(this.f1576b, this.p0, this.S, this.d, new j0());
                        this.V = gVar2;
                        gVar2.show();
                        this.V.setOnDismissListener(new k0());
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
            com.igaworks.adpopcorn.cores.common.h.a(this.f1576b, "ApOfferWallLayout", "openWebBrowser = " + str, 3);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            this.f1576b.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    private void d(boolean z2) {
        try {
            h();
            e();
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            String str = gVar.I;
            String str2 = gVar.h;
            String str3 = gVar.v;
            String str4 = z2 ? gVar.U : gVar.e;
            Context context = this.f1576b;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.p0, str, str4, -1, str2, new a0(), str3, new b0(), isLandscapeMode(context, false));
            this.n0 = aVar;
            aVar.setCancelable(false);
            this.n0.setCanceledOnTouchOutside(false);
            this.n0.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Dialog dialog = this.n0;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.n0.dismiss();
        this.n0 = null;
    }

    private void e(com.igaworks.adpopcorn.cores.model.f fVar) {
        String str;
        String str2;
        h();
        if (fVar != null && fVar.d()) {
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            str = gVar.p;
            str2 = gVar.e;
        } else {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1576b, "ApOfferWallLayout", "callbackRewardAppExecute result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    int i2 = jSONObject.getInt("ResultCode");
                    String string = jSONObject.getString("ResultMsg");
                    if (z2) {
                        d(PointerIconCompat.TYPE_WAIT);
                        c(false);
                        com.igaworks.adpopcorn.a.d dVar = this.z;
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
                        com.igaworks.adpopcorn.a.b.a().b(this.c, "participateFlag", this.M, false);
                    }
                    c(false);
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
            if (this.u0 == null) {
                WebView webView = new WebView(this.c);
                this.u0 = webView;
                webView.getSettings().setJavaScriptEnabled(true);
                this.u0.setWebChromeClient(new WebChromeClient());
                addView(this.u0);
                this.u0.setVisibility(4);
                this.u0.setWebViewClient(new m0());
            }
            com.igaworks.adpopcorn.cores.common.h.a(this.f1576b, "ApOfferWallLayout", "openWebViewBrowser = " + str, 3);
            this.u0.loadUrl(str);
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
            com.igaworks.adpopcorn.activity.b.b bVar = this.h0;
            if (bVar != null) {
                bVar.dismiss();
            }
            String strC = this.t.c();
            int i2 = Calendar.getInstance().get(6);
            int iA = com.igaworks.adpopcorn.a.b.a().a(this.f1576b, "adpopcorn_choice_impression_sp", strC, -1);
            if (!z2 || iA == i2) {
                com.igaworks.adpopcorn.cores.common.h.a(this.f1576b, "ApOfferWallLayout", "Today AdpopcornChoiceAd already showed", 3);
                try {
                    ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList = this.p;
                    if (arrayList != null && arrayList.size() > 0) {
                        z();
                        if (this.y != null) {
                            com.igaworks.adpopcorn.cores.common.e.a(this.f1576b, this.p.get(0).T(), this.y, 0, 0, (com.igaworks.adpopcorn.cores.common.e.b) null);
                        }
                        com.igaworks.adpopcorn.activity.layout.a aVar = this.w;
                        if (aVar != null) {
                            aVar.a(aVar, this.t);
                        }
                    }
                    com.igaworks.adpopcorn.activity.a.a aVar2 = this.j;
                    if (aVar2 != null) {
                        aVar2.notifyDataSetInvalidated();
                    }
                } catch (Exception unused) {
                }
                if (this.w != null && !isLandscapeMode(this.f1576b, false)) {
                    com.igaworks.adpopcorn.activity.layout.a aVar3 = this.w;
                    aVar3.a((View) aVar3, this.f1576b, this.t, false, this.t0, 0);
                    this.w.setOnClickListener(new h());
                }
            } else {
                com.igaworks.adpopcorn.activity.b.b bVar2 = new com.igaworks.adpopcorn.activity.b.b(this.f1576b, this.p0, this.a, this.t, this.q0, this.t0, this.L0, new f());
                this.h0 = bVar2;
                bVar2.show();
                this.h0.setCancelable(true);
                this.h0.setOnDismissListener(new g());
            }
            this.x = true;
            com.igaworks.adpopcorn.a.b.a().b(this.f1576b, "adpopcorn_choice_impression_sp", strC, i2);
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.igaworks.adpopcorn.a.g.a aVar;
        String str;
        try {
            String str2 = this.O;
            com.igaworks.adpopcorn.cores.model.g gVar = this.S;
            if (gVar == null) {
                com.igaworks.adpopcorn.cores.common.h.a(this.f1576b, "ApOfferWallLayout", "completeNewsCampaign failed", 3);
                return;
            }
            String strY = gVar.y();
            com.igaworks.adpopcorn.cores.common.h.a(this.f1576b, "ApOfferWallLayout", "completeNewsCampaign : " + strY, 3);
            if (this.a0 == null) {
                this.a0 = new com.igaworks.adpopcorn.a.g.a(this.f1576b);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", this.O);
            jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1576b));
            jSONObject.put("sign", com.igaworks.adpopcorn.cores.common.c.a(strY, str2));
            if (com.igaworks.adpopcorn.a.d.E) {
                aVar = this.a0;
                str = "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/CompleteNewsCampaign";
            } else {
                aVar = this.a0;
                str = "https://apapi.adpopcorn.com/ap/v1/common/conversion/CompleteNewsCampaign";
            }
            aVar.a(30, str, jSONObject, this);
        } catch (Exception e2) {
            e2.printStackTrace();
            com.igaworks.adpopcorn.cores.common.h.a(this.f1576b, "ApOfferWallLayout", "completeNewsCampaign failed : " + e2.getMessage(), 3);
        }
    }

    private void f(com.igaworks.adpopcorn.cores.model.f fVar) {
        String str;
        String str2;
        com.igaworks.adpopcorn.a.b bVarA;
        Context context;
        com.igaworks.adpopcorn.cores.model.g gVar;
        h();
        if (fVar == null || !fVar.d()) {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1576b, "ApOfferWallLayout", "callbackRewardAppInstall result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    int i2 = jSONObject.getInt("ResultCode");
                    String string = jSONObject.getString("ResultMsg");
                    if (z2) {
                        if (this.K != 23) {
                            d(PointerIconCompat.TYPE_WAIT);
                            com.igaworks.adpopcorn.a.b.a().b(this.f1576b, this.S.c());
                            c(false);
                            com.igaworks.adpopcorn.a.d dVar = this.z;
                            if (dVar != null) {
                                dVar.c(false);
                                return;
                            }
                            return;
                        }
                        bVarA = com.igaworks.adpopcorn.a.b.a();
                        context = this.f1576b;
                        gVar = this.S;
                    } else {
                        if (this.K != 23) {
                            if (i2 == 2000) {
                                d(1005);
                                com.igaworks.adpopcorn.a.b.a().b(this.f1576b, this.S.c());
                            } else {
                                if (i2 != 2050) {
                                    a(this.d.q, string, true);
                                    return;
                                }
                                com.igaworks.adpopcorn.a.b.a().b(this.c, "participateFlag", this.M, false);
                            }
                            c(false);
                            return;
                        }
                        if (i2 != 2000) {
                            if (i2 == 2050) {
                                com.igaworks.adpopcorn.a.b.a().b(this.c, "participateFlag", this.M, false);
                                return;
                            }
                            return;
                        } else {
                            bVarA = com.igaworks.adpopcorn.a.b.a();
                            context = this.f1576b;
                            gVar = this.S;
                        }
                    }
                    bVarA.b(context, gVar.c());
                    return;
                } catch (JSONException e2) {
                    if (this.K != 23) {
                        com.igaworks.adpopcorn.cores.common.g gVar2 = this.d;
                        a(gVar2.I, gVar2.p, true);
                    }
                    e2.printStackTrace();
                    return;
                }
            }
            if (this.K == 23) {
                return;
            }
            com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
            str = gVar3.I;
            str2 = gVar3.g;
        } else {
            if (this.K == 23) {
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
            h();
            e();
            String str = this.d.I;
            String str2 = this.d.f + "\n" + this.d.d0;
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            String str3 = gVar.h;
            String str4 = gVar.G;
            String str5 = z2 ? this.d.n0 + "\n" + this.d.d0 : str2;
            Context context = this.f1576b;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.p0, str, str5, -1, str3, new p(), str4, new q(), isLandscapeMode(context, false));
            this.n0 = aVar;
            aVar.setCancelable(false);
            this.n0.show();
        } catch (Exception unused) {
        }
    }

    private void g() {
        if (this.H == null) {
            this.H = new Handler(Looper.getMainLooper());
        }
        if (this.I == null) {
            this.I = new k();
        }
    }

    private void g(com.igaworks.adpopcorn.cores.model.f fVar) {
        com.igaworks.adpopcorn.cores.model.j jVarA;
        if (fVar != null && fVar.d()) {
            d(true);
        } else if (fVar != null && fVar.a().length() > 0) {
            try {
                com.igaworks.adpopcorn.cores.common.h.a(this.f1576b, "ApOfferWallLayout", "callbackVideoAdDetailInfoRequest result = " + fVar.a(), 3);
                if (new JSONObject(fVar.a()).getBoolean("Result") && (jVarA = com.igaworks.adpopcorn.a.f.f.a(fVar.a())) != null) {
                    a(this.S.c(), this.O, jVarA.c(), jVarA.h(), jVarA.e(), jVarA.f(), jVarA.g(), jVarA.j(), jVarA.k(), jVarA.l(), jVarA.r(), jVarA.a(), jVarA.s(), this.S.P(), jVarA.o(), jVarA.q(), jVarA.i(), this.S.N());
                    return;
                }
            } catch (JSONException unused) {
            }
        }
        d(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        try {
            com.igaworks.adpopcorn.activity.b.d.c cVar = this.o0;
            if (cVar != null) {
                cVar.dismiss();
                this.o0 = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Activity activity;
        try {
            if (this.q0 || (activity = this.s0) == null) {
                return;
            }
            activity.finish();
            this.s0.overridePendingTransition(0, 0);
            com.igaworks.adpopcorn.a.d dVar = this.z;
            if (dVar != null) {
                dVar.c((String) null);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        String str;
        if (com.igaworks.adpopcorn.a.d.E) {
            this.A = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/checkcampaign";
            this.B = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/joincampaign";
            this.C = "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/completeinstallcampaign";
            this.D = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/video/getrewardvideodetail";
            this.E = "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/completeexecutecampaign";
            this.F = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/joincpmcampaign";
            str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/joinnewscampaign";
        } else {
            this.A = "https://apapi.adpopcorn.com/ap/v1/sdk/media/checkcampaign";
            this.B = "https://apapi.adpopcorn.com/ap/v1/sdk/media/joincampaign";
            this.C = "https://apapi.adpopcorn.com/ap/v1/common/conversion/completeinstallcampaign";
            this.D = "https://apapi.adpopcorn.com/ap/v1/sdk/video/getrewardvideodetail";
            this.E = "https://apapi.adpopcorn.com/ap/v1/common/conversion/completeexecutecampaign";
            this.F = "https://apapi.adpopcorn.com/ap/v1/sdk/media/joincpmcampaign";
            str = "https://apapi.adpopcorn.com/ap/v1/sdk/media/joinnewscampaign";
        }
        this.G = str;
    }

    private void k() {
        this.b0 = false;
        this.c0 = false;
        this.e0 = 1;
        long jA = com.igaworks.adpopcorn.a.b.a().a(this.f1576b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_quantity", 0L);
        boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.ALWAYS_SHOW_SPLASH_DIALOG);
        int i2 = Calendar.getInstance().get(6);
        if (com.igaworks.adpopcorn.a.b.a().a(this.f1576b, "adpopcorn_news_sp", "adpopcorn_news_imp_day", 0) != i2) {
            com.igaworks.adpopcorn.a.b.a().b(this.f1576b);
        }
        com.igaworks.adpopcorn.a.b.a().b(this.f1576b, "adpopcorn_news_sp", "adpopcorn_news_imp_day", i2);
        if (zB) {
            this.N0 = false;
        } else if (i2 == com.igaworks.adpopcorn.a.b.a().a(this.f1576b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_imp_day", 0)) {
            this.N0 = true;
        }
        if (this.c0 || this.e0 > this.f0) {
            b(true);
        } else {
            com.igaworks.adpopcorn.cores.common.h.a(this.f1576b, "ApOfferWallLayout", "initCampaignLoading", 3);
            if (com.igaworks.adpopcorn.cores.common.c.c(this.f1576b)) {
                if (this.K0 == 3 || jA == 0 || this.N0) {
                    showProgressDialog(this.d.f1613b, false);
                }
                if (!this.e.i()) {
                    this.a0.a(this.e0, this);
                }
            } else {
                com.igaworks.adpopcorn.cores.common.g gVar = this.d;
                b(gVar.g, gVar.h, true);
            }
        }
        try {
            if (this.K0 == 3 || this.N0 || jA <= 0) {
                return;
            }
            com.igaworks.adpopcorn.activity.b.i iVar = new com.igaworks.adpopcorn.activity.b.i(this.f1576b, jA, com.igaworks.adpopcorn.a.b.a().a(this.f1576b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_currency", ""), this.p0);
            iVar.show();
            iVar.setOnDismissListener(new e0());
            com.igaworks.adpopcorn.a.b.a().b(this.f1576b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_imp_day", i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void l() {
        ImageView imageView;
        com.igaworks.adpopcorn.activity.layout.a aVarA;
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.BOTTOM_BAR_HEIGHT);
        if (this.K0 == 1) {
            setBackgroundColor(Color.parseColor("#a6000000"));
        }
        this.f = new FrameLayout(this.c);
        this.f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f.setBackgroundColor(Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.OFFERWALL_BG_COLOR)));
        this.g = new LinearLayout(this.c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.g.setOrientation(1);
        this.g.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_BG_COLOR));
        this.g.setLayoutParams(layoutParams);
        this.g.setPadding(0, 0, 0, com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, iC));
        this.f.addView(this.g);
        this.f.addView(b(iC));
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_LR_PADDING);
        int iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_HEIGHT);
        boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.ENABLE_TOP_BAR_EXPAND_MENU);
        int iC4 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_HEIGHT);
        this.y0 = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.ENABLE_OFFERWALL_TOP_BAR_SHADOW);
        this.z0 = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.ALWAYS_SHOW_OFFERWALL_TOP_BAR_SHADOW);
        if (this.K0 == 2) {
            iC2 = 0;
        }
        if (!isLandscapeMode(this.f1576b, false) && this.K0 != 2) {
            int iA = com.igaworks.adpopcorn.cores.common.d.a(this.c, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_BAR_HEIGHT));
            APOfferwallTabInfo aPOfferwallTabInfo = this.R0;
            if (aPOfferwallTabInfo == null || aPOfferwallTabInfo.getTabCount() < 2) {
                iA = 0;
            }
            if (this.q0) {
                aVarA = com.igaworks.adpopcorn.activity.layout.a.a(this.f1576b, iA, this.K0, 0, this.t0);
            } else if (zB) {
                Context context = this.f1576b;
                aVarA = com.igaworks.adpopcorn.activity.layout.a.a(context, com.igaworks.adpopcorn.cores.common.d.a(context, iC3 + iC4) + iA, this.K0, 0, this.t0);
            } else {
                Context context2 = this.f1576b;
                aVarA = com.igaworks.adpopcorn.activity.layout.a.a(context2, com.igaworks.adpopcorn.cores.common.d.a(context2, iC3) + iA, this.K0, 0, this.t0);
            }
            this.w = aVarA;
            this.w.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, iC2), 0, com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, iC2), 0);
            this.w.setVisibility(8);
            this.f.addView(this.w);
        }
        if (!this.q0) {
            this.g.addView(o());
            if (zB) {
                this.g.addView(n());
            }
        }
        if (this.y0) {
            this.f.addView(q());
            if (!this.z0 && (imageView = this.A0) != null) {
                imageView.setVisibility(4);
            }
        }
        int iC5 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_FOOTER_MARGIN_DP);
        LinearLayout linearLayout = new LinearLayout(this.c);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, iC5)));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        if (isLandscapeMode(this.f1576b, false)) {
            int i2 = this.K0;
            if (i2 == 2 || i2 == 0 || i2 == 1) {
                this.g.addView(p());
            }
            com.igaworks.adpopcorn.activity.c.e eVar = new com.igaworks.adpopcorn.activity.c.e(this.c);
            this.l = eVar;
            eVar.setLayoutParams(layoutParams2);
            this.l.setSelector(new StateListDrawable());
            this.l.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 8), com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 8), com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 8), 0);
            this.l.setNumColumns(2);
            this.l.setHorizontalSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 8));
            this.l.setVerticalSpacing(0);
            this.l.b(r());
            this.l.a(linearLayout);
            this.g.addView(this.l);
            this.j = new com.igaworks.adpopcorn.activity.a.a(this.c, this.n, this.d, true, this.K0, this.L0, this.t0);
            this.l.setOnItemClickListener(this.W0);
            this.l.setOnScrollListener(this.X0);
            this.f.addView(t());
        } else {
            com.igaworks.adpopcorn.activity.c.e eVar2 = new com.igaworks.adpopcorn.activity.c.e(this.c);
            this.k = eVar2;
            eVar2.setVerticalScrollBarEnabled(false);
            this.k.setLayoutParams(layoutParams2);
            this.k.setSelector(new StateListDrawable());
            this.k.setNumColumns(1);
            this.k.setHorizontalSpacing(0);
            this.k.setVerticalSpacing(0);
            this.k.b(s());
            this.g.addView(this.k);
            this.f.addView(t());
            this.j = new com.igaworks.adpopcorn.activity.a.a(this.c, this.n, this.d, false, this.K0, this.L0, this.t0);
            this.k.setSelector(new StateListDrawable());
            this.k.setOnItemClickListener(this.W0);
            this.k.setOnScrollListener(this.X0);
            this.k.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, iC2), 0, com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, iC2), 0);
        }
        addView(this.f);
    }

    private void m() {
        com.igaworks.adpopcorn.a.d dVarA = com.igaworks.adpopcorn.a.d.a(this.f1576b);
        this.z = dVarA;
        this.e = dVarA.e();
        com.igaworks.adpopcorn.cores.common.e.b(this.f1576b);
        if (!this.t0) {
            com.igaworks.adpopcorn.cores.common.d.a();
        }
        com.igaworks.adpopcorn.cores.common.d.a((Activity) this.f1576b);
        com.igaworks.adpopcorn.cores.common.g gVarA = com.igaworks.adpopcorn.cores.common.g.a();
        this.d = gVarA;
        gVarA.d();
        this.e0 = 1;
        this.c0 = false;
        this.m0 = false;
        this.d0 = false;
        this.x = false;
        this.x0 = 1;
        this.n = new ArrayList<>();
        this.o = new ArrayList<>();
        this.p = new ArrayList<>();
        this.q = new ArrayList<>();
        this.r = new ArrayList<>();
        this.s = new com.igaworks.adpopcorn.cores.model.g();
        this.u = new ArrayList<>();
        this.v0 = new ArrayList<>();
        this.w0 = new ArrayList<>();
        this.a = ((WindowManager) this.f1576b.getSystemService("window")).getDefaultDisplay().getWidth();
        if (this.K0 == 1) {
            setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 9), com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 15), com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 9), com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 15));
            this.a -= com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 18);
        }
        if (this.a0 == null) {
            this.a0 = new com.igaworks.adpopcorn.a.g.a(this.f1576b);
        }
        this.p0 = com.igaworks.adpopcorn.activity.b.d.a(this.f1576b);
        com.igaworks.adpopcorn.a.b.a().b(this.f1576b, "adpopcorn_sdk_flag", "isAdPopcornUser", true);
        com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_CUSTOM_MEDIA_MODE);
        g();
        try {
            int i2 = Calendar.getInstance().get(6);
            if (i2 != com.igaworks.adpopcorn.a.b.a().a(this.f1576b, "adpopcorn_sdk_flag", "adpopcorn_last_visit_day", -1)) {
                com.igaworks.adpopcorn.a.b.a().e(this.f1576b, "adpopcorn_choice_impression_sp");
                com.igaworks.adpopcorn.a.b.a().b(this.f1576b, "adpopcorn_sdk_flag", "adpopcorn_last_visit_day", i2);
            }
        } catch (Exception unused) {
        }
    }

    private LinearLayout n() {
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_BG_COLOR);
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_HEIGHT);
        int iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_TITLE_TEXT_SIZE_DP);
        int iC4 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_TITLE_TEXT_COLOR);
        int iC5 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_TITLE_TEXT_LR_PADDING);
        int iC6 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_TITLE_TEXT_BOTTOM_PADDING);
        String strD = com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_TITLE_TEXT);
        int iC7 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_SUB_TEXT_SIZE_DP);
        int iC8 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_SUB_TEXT_COLOR);
        int iC9 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_SUB_TEXT_LR_PADDING);
        String strD2 = com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_SUB_TEXT);
        LinearLayout linearLayout = new LinearLayout(this.c);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, iC2)));
        linearLayout.setGravity(16);
        linearLayout.setBackgroundColor(iC);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this.c);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView.setGravity(19);
        textView.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, iC5), 0, com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, iC5), com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, iC6));
        com.igaworks.adpopcorn.cores.common.k.b(textView, strD, iC3, iC4, null, 0, 0, TextUtils.TruncateAt.END, false);
        linearLayout.addView(textView);
        TextView textView2 = new TextView(this.c);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView2.setGravity(19);
        textView2.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, iC9), 0, com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, iC9), 0);
        com.igaworks.adpopcorn.cores.common.k.b(textView2, strD2, iC7, iC8, null, 0, 0, TextUtils.TruncateAt.END, false);
        linearLayout.addView(textView2);
        return linearLayout;
    }

    private RelativeLayout o() {
        com.igaworks.adpopcorn.activity.layout.c cVar = new com.igaworks.adpopcorn.activity.layout.c(this.c);
        ImageView imageView = (ImageView) cVar.findViewById(0);
        LinearLayout linearLayout = (LinearLayout) cVar.findViewById(1);
        imageView.setOnClickListener(new d());
        linearLayout.setOnClickListener(new e());
        if (this.r0) {
            imageView.setVisibility(4);
            linearLayout.setVisibility(4);
        }
        return cVar;
    }

    private LinearLayout p() {
        this.B0 = new LinearLayout(this.c);
        try {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_REWARD_SUMMARY_BAR_HEIGHT)));
            layoutParams.gravity = 17;
            this.B0.setOrientation(0);
            this.B0.setGravity(17);
            this.B0.setLayoutParams(layoutParams);
            this.B0.setBackgroundColor(Color.parseColor("#ffffff"));
            this.E0 = new TextView(this.c);
            this.E0.setLayoutParams(new LinearLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 18)));
            this.E0.setGravity(17);
            this.E0.setSingleLine();
            this.B0.addView(this.E0);
            ImageView imageView = new ImageView(this.c);
            APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_ICON_RESOURCE_SIZE);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, aPSizeA.width), com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, aPSizeA.height));
            layoutParams2.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 4);
            layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 2);
            imageView.setLayoutParams(layoutParams2);
            this.B0.addView(imageView);
            if (com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_ICON_RESOURCE_ID) == -100) {
                com.igaworks.adpopcorn.a.a.a(this.f1576b, "igaw_ap_ic_reward.png", imageView, false);
            } else {
                imageView.setImageResource(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_ICON_RESOURCE_ID));
            }
            imageView.setColorFilter(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_ICON_COLOR), PorterDuff.Mode.MULTIPLY);
            this.F0 = new TextView(this.c);
            this.F0.setLayoutParams(new LinearLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 18)));
            this.F0.setGravity(17);
            this.F0.setSingleLine();
            this.B0.addView(this.F0);
        } catch (Exception unused) {
        }
        return this.B0;
    }

    private View q() {
        Context context;
        this.A0 = new ImageView(this.f1576b);
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.SHADOW_BAR_HEIGHT_DP);
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_HEIGHT);
        int iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_HEIGHT);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, iC));
        if (!this.q0) {
            if (com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.ENABLE_TOP_BAR_EXPAND_MENU)) {
                context = this.f1576b;
                iC2 += iC3;
            } else {
                context = this.f1576b;
            }
            layoutParams.topMargin = com.igaworks.adpopcorn.cores.common.d.a(context, iC2);
        }
        this.A0.setLayoutParams(layoutParams);
        try {
            int iC4 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.SHADOW_BAR_RESOURCE_ID);
            if (iC4 == -100) {
                com.igaworks.adpopcorn.a.a.a(this.f1576b, "igaw_ap_shadow.png", this.A0, true);
            } else {
                this.A0.setImageResource(iC4);
            }
            this.A0.setScaleType(ImageView.ScaleType.FIT_XY);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this.A0;
    }

    private View r() {
        View viewFindViewById;
        try {
            LinearLayout linearLayout = this.j0;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
                this.j0 = null;
            }
            this.i0 = new com.igaworks.adpopcorn.activity.layout.d(this.c, this.a, isLandscapeMode(this.f1576b, false), this.K0, this.d, new l());
            if (isLandscapeMode(this.f1576b, false)) {
                this.j0 = (LinearLayout) this.i0.findViewById(0);
                viewFindViewById = this.i0.findViewById(1);
            } else {
                this.j0 = (LinearLayout) this.i0.findViewById(0);
                viewFindViewById = this.i0.findViewById(1);
            }
            this.k0 = (ViewFlipper) viewFindViewById;
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setFillAfter(true);
            translateAnimation.setDuration(1000L);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation2.setFillAfter(false);
            translateAnimation2.setDuration(1000L);
            this.k0.setInAnimation(translateAnimation);
            this.k0.setOutAnimation(translateAnimation2);
            return this.i0;
        } catch (Exception e2) {
            e2.printStackTrace();
            View view = new View(this.c);
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
            return view;
        }
    }

    private LinearLayout s() {
        LinearLayout linearLayout;
        LinearLayout linearLayoutP;
        LinearLayout linearLayout2;
        View viewR;
        this.C0 = new LinearLayout(this.c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.C0.setOrientation(1);
        this.C0.setGravity(17);
        this.C0.setLayoutParams(layoutParams);
        this.C0.setBackgroundColor(Color.parseColor("#ffffff"));
        int i2 = this.K0;
        if (i2 != 0 && i2 != 1) {
            if (i2 == 2) {
                this.C0.addView(c(0));
                linearLayout2 = this.C0;
                viewR = p();
            } else {
                this.C0.addView(p());
                linearLayout = this.C0;
                linearLayoutP = c(0);
            }
            linearLayout2.addView(viewR);
            return this.C0;
        }
        this.C0.addView(c(0));
        linearLayout = this.C0;
        linearLayoutP = p();
        linearLayout.addView(linearLayoutP);
        linearLayout2 = this.C0;
        viewR = r();
        linearLayout2.addView(viewR);
        return this.C0;
    }

    private LinearLayout t() {
        int iA;
        int iA2;
        LinearLayout linearLayout;
        String language = Locale.getDefault().getLanguage();
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.BOTTOM_BAR_TEXT_COLOR);
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.BOTTOM_BAR_ICON_COLOR);
        int iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.BOTTOM_BAR_TEXT_SIZE_DP);
        int iC4 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.BOTTOM_BAR_TEXT_DIVIDER_COLOR);
        int iC5 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.BOTTOM_BAR_IGAWORKS_LINK_TEXT_COLOR);
        boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.DISABLE_BOTTOM_BAR_ICON);
        boolean zB2 = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.BOTTOM_BAR_TEXT_BOLD);
        LinearLayout linearLayout2 = new LinearLayout(this.c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.BOTTOM_BAR_HEIGHT)));
        layoutParams.gravity = 80;
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.BOTTOM_BAR_BG_COLOR));
        if (isLandscapeMode(this.f1576b, false)) {
            iA = com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 13);
            iA2 = com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 14);
        } else {
            iA = com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 13);
            iA2 = com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 13);
        }
        linearLayout2.setPadding(iA, 0, iA2, 0);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        ImageView imageView = new ImageView(this.f1576b);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 11), com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 11));
        layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 4);
        imageView.setLayoutParams(layoutParams2);
        imageView.setOnClickListener(new p0());
        com.igaworks.adpopcorn.a.a.a(this.f1576b, "igaw_ap_ic_ques.png", imageView, false);
        imageView.setColorFilter(iC2, PorterDuff.Mode.MULTIPLY);
        TextView textView = new TextView(this.c);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 8);
        textView.setLayoutParams(layoutParams3);
        textView.setGravity(17);
        com.igaworks.adpopcorn.cores.common.k.b(textView, this.d.J, iC3, iC, null, 0, 1, TextUtils.TruncateAt.END, zB2);
        textView.setIncludeFontPadding(false);
        if (language.contains(ApStyleManager.Language.JA) || language.contains(ApStyleManager.Language.EN)) {
            textView.setTextSize(1, 8.0f);
        }
        textView.setOnClickListener(new q0());
        TextView textView2 = new TextView(this.c);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 1), com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 9)));
        textView2.setBackgroundColor(iC4);
        ImageView imageView2 = new ImageView(this.c);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 11), com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 11));
        layoutParams4.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 7);
        layoutParams4.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 5);
        imageView2.setLayoutParams(layoutParams4);
        imageView2.setOnClickListener(new r0());
        com.igaworks.adpopcorn.a.a.a(this.f1576b, "igaw_ap_ic_lock.png", imageView2, false);
        imageView2.setColorFilter(iC2, PorterDuff.Mode.MULTIPLY);
        TextView textView3 = new TextView(this.c);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -1);
        if (zB) {
            layoutParams5.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 8);
        }
        textView3.setLayoutParams(layoutParams5);
        textView3.setGravity(17);
        com.igaworks.adpopcorn.cores.common.k.b(textView3, this.d.X, iC3, iC, null, 0, 1, TextUtils.TruncateAt.END, zB2);
        if (language.contains(ApStyleManager.Language.JA) || language.contains(ApStyleManager.Language.EN)) {
            textView3.setTextSize(1, 8.0f);
        }
        textView3.setIncludeFontPadding(false);
        textView3.setOnClickListener(new s0());
        boolean zB3 = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.BOTTOM_BAR_CLICKABLE_LINK_TEXT);
        String strD = com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.BOTTOM_BAR_LINK_TEXT);
        TextView textView4 = new TextView(this.c);
        textView4.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        textView4.setGravity(21);
        if (zB3) {
            textView4.setOnClickListener(new t0());
        }
        com.igaworks.adpopcorn.cores.common.k.b(textView4, strD, iC3, iC5, null, 0, 1, TextUtils.TruncateAt.END, zB2);
        textView4.setIncludeFontPadding(false);
        if (zB) {
            linearLayout = linearLayout2;
            linearLayout.addView(textView);
            linearLayout.addView(textView2);
        } else {
            linearLayout = linearLayout2;
            linearLayout.addView(imageView);
            linearLayout.addView(textView);
            linearLayout.addView(textView2);
            linearLayout.addView(imageView2);
        }
        linearLayout.addView(textView3);
        linearLayout.addView(textView4);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        try {
            e();
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            String str = gVar.I;
            String str2 = gVar.W;
            String str3 = gVar.z;
            String str4 = gVar.y;
            Context context = this.f1576b;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.p0, str, str2, -1, str3, new c0(), str4, new d0(), isLandscapeMode(context, false));
            this.n0 = aVar;
            aVar.setCancelable(false);
            this.n0.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        try {
            boolean z2 = this.p0 == 16973841;
            Context context = this.f1576b;
            com.igaworks.adpopcorn.activity.b.c cVar = new com.igaworks.adpopcorn.activity.b.c(context, this.p0, isLandscapeMode(context, false), this.d, z2, this);
            this.U = cVar;
            cVar.setOnDismissListener(new a());
            this.U.show();
            A();
        } catch (Exception unused) {
        }
    }

    private void w() {
        Dialog dialog;
        DialogInterface.OnDismissListener vVar;
        int i2;
        h();
        try {
            int i3 = this.K0;
            if (i3 == 2 || (i2 = this.L0) == 2 || i2 == 3) {
                com.igaworks.adpopcorn.activity.b.e eVar = new com.igaworks.adpopcorn.activity.b.e(this.f1576b, this.p0, this.S, this.d, this.V0, new u());
                this.T = eVar;
                eVar.show();
                dialog = this.T;
                vVar = new v();
            } else if (i3 == 3) {
                com.igaworks.adpopcorn.activity.b.a aVar = isLandscapeMode(this.f1576b, true) ? new com.igaworks.adpopcorn.activity.b.a(this.f1576b, this.p0, this.S, this.d, this.V0, true, this.M0) : new com.igaworks.adpopcorn.activity.b.a(this.f1576b, this.p0, this.S, this.d, this.V0, false, this.M0);
                this.T = aVar;
                aVar.show();
                dialog = this.T;
                vVar = new w();
            } else {
                com.igaworks.adpopcorn.activity.b.a aVar2 = isLandscapeMode(this.f1576b, true) ? new com.igaworks.adpopcorn.activity.b.a(this.f1576b, this.p0, this.S, this.d, this.V0, true, this.M0) : new com.igaworks.adpopcorn.activity.b.a(this.f1576b, this.p0, this.S, this.d, this.V0, false, this.M0);
                this.T = aVar2;
                aVar2.show();
                dialog = this.T;
                vVar = new x();
            }
            dialog.setOnDismissListener(vVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
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
                com.igaworks.adpopcorn.cores.common.k.b(this.h, "Test Mode", 20, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_THEME_COLOR), null, 0, 1, TextUtils.TruncateAt.END, false);
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
            if (this.e0 != 1 || this.P0 <= 0) {
                return;
            }
            try {
                String str = new DecimalFormat("###,###").format(this.P0);
                com.igaworks.adpopcorn.cores.common.k.b(this.E0, this.d.t1, 14, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_PRE_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, false);
                com.igaworks.adpopcorn.cores.common.k.b(this.F0, str + " " + this.O0, 14, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
                this.B0.setVisibility(0);
                com.igaworks.adpopcorn.a.b.a().b(this.f1576b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_quantity", this.P0);
                bVarA = com.igaworks.adpopcorn.a.b.a();
            } catch (Exception unused) {
                com.igaworks.adpopcorn.cores.common.k.b(this.E0, this.d.t1, 14, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_PRE_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, false);
                com.igaworks.adpopcorn.cores.common.k.b(this.F0, " " + this.O0, 14, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
                this.B0.setVisibility(0);
                com.igaworks.adpopcorn.a.b.a().b(this.f1576b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_quantity", this.P0);
                bVarA = com.igaworks.adpopcorn.a.b.a();
            } catch (Throwable th) {
                com.igaworks.adpopcorn.cores.common.k.b(this.E0, this.d.t1, 14, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_PRE_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, false);
                com.igaworks.adpopcorn.cores.common.k.b(this.F0, " " + this.O0, 14, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
                this.B0.setVisibility(0);
                com.igaworks.adpopcorn.a.b.a().b(this.f1576b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_quantity", this.P0);
                com.igaworks.adpopcorn.a.b.a().b(this.f1576b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_currency", this.O0);
                throw th;
            }
            bVarA.b(this.f1576b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_currency", this.O0);
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        try {
            Handler handler = this.H;
            if (handler != null) {
                handler.removeCallbacks(this.I);
                this.H.postDelayed(this.I, 5000L);
            }
        } catch (Exception unused) {
        }
    }

    public void destroy() {
        try {
            h();
            A();
            if (this.I != null) {
                this.I = null;
            }
            Dialog dialog = this.T;
            if (dialog != null && dialog.isShowing()) {
                this.T.dismiss();
                this.T = null;
            }
            Dialog dialog2 = this.U;
            if (dialog2 != null && dialog2.isShowing()) {
                this.U.dismiss();
                this.U = null;
            }
            com.igaworks.adpopcorn.activity.b.b bVar = this.h0;
            if (bVar != null && bVar.isShowing()) {
                this.h0.dismiss();
                this.h0 = null;
            }
            HashMap<String, String> map = this.W;
            if (map != null && map.size() > 0) {
                this.W.clear();
                this.W = null;
            }
            com.igaworks.adpopcorn.activity.a.a aVar = this.j;
            if (aVar != null) {
                aVar.a();
            }
            WebView webView = this.u0;
            if (webView != null) {
                webView.destroy();
                this.u0 = null;
            }
            com.igaworks.adpopcorn.a.a.a();
            com.igaworks.adpopcorn.cores.common.e.a(this.f1576b);
            com.igaworks.adpopcorn.cores.common.i.a(this);
        } catch (Exception unused) {
        }
    }

    public void exitOfferwall() {
        try {
            com.igaworks.adpopcorn.a.d dVar = this.z;
            if (dVar != null) {
                dVar.c((String) null);
            }
            Activity activity = this.s0;
            if (activity == null) {
                onCustomConfigurationChanged(new Configuration());
            } else {
                activity.finish();
                this.s0.overridePendingTransition(0, 0);
            }
        } catch (Exception unused) {
        }
    }

    public int getOfferwallType() {
        return this.K0;
    }

    public void initOfferwallLayout(boolean z2, boolean z3) {
        this.q0 = z2;
        this.r0 = z3;
        try {
            m();
            j();
            l();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean isLandscapeMode(Context context, boolean z2) {
        Activity activity;
        if (Build.VERSION.SDK_INT >= 24 && (activity = this.s0) != null && activity.isInMultiWindowMode()) {
            return false;
        }
        if (!z2) {
            return this.l0;
        }
        Configuration configuration = ((Activity) context).getResources().getConfiguration();
        return configuration != null && configuration.orientation == 2;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    public void onCustomConfigurationChanged(Configuration configuration) {
        try {
            if (!this.t0) {
                com.igaworks.adpopcorn.cores.common.d.a();
            }
            com.igaworks.adpopcorn.cores.common.d.a((Activity) this.f1576b);
            this.a = ((WindowManager) this.f1576b.getSystemService("window")).getDefaultDisplay().getWidth();
            if (this.K0 == 1) {
                setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 9), com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 15), com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 9), com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 15));
                this.a -= com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 9);
            }
            this.e0 = 1;
            this.c0 = false;
            this.x = false;
            this.x0 = 1;
            j();
            Dialog dialog = this.T;
            if (dialog != null && dialog.isShowing()) {
                this.T.dismiss();
                this.T = null;
            }
            com.igaworks.adpopcorn.activity.b.b bVar = this.h0;
            if (bVar != null && bVar.isShowing()) {
                this.h0.dismiss();
                this.h0 = null;
            }
            Dialog dialog2 = this.U;
            if (dialog2 != null && dialog2.isShowing()) {
                this.U.dismiss();
                this.U = null;
            }
            com.igaworks.adpopcorn.activity.b.g gVar = this.V;
            if (gVar != null && gVar.isShowing()) {
                this.V.dismiss();
                this.V = null;
            }
            A();
            removeAllViewsInLayout();
            removeAllViews();
            invalidate();
            l();
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

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
    }

    public void pause() {
        try {
            com.igaworks.adpopcorn.activity.b.g gVar = this.V;
            if (gVar == null || !gVar.isShowing()) {
                return;
            }
            this.V.j();
        } catch (Exception unused) {
        }
    }

    public void resume() {
        resume(false);
    }

    public void resume(boolean z2) {
        Activity activity;
        try {
            this.M0 = false;
            if (Build.VERSION.SDK_INT >= 24 && (activity = this.s0) != null && activity.isInMultiWindowMode()) {
                this.M0 = true;
            }
            boolean z3 = this.M0;
            if (z3 || this.K0 != 2) {
                if (z3 || this.K0 != 3) {
                    if (z3 && (com.igaworks.adpopcorn.cores.common.d.c() <= com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO) || com.igaworks.adpopcorn.cores.common.d.b() <= com.igaworks.adpopcorn.cores.common.d.a(this.f1576b, 260))) {
                        Toast.makeText(this.f1576b, this.d.w1, 1).show();
                        i();
                        return;
                    }
                } else if (isLandscapeMode(this.f1576b, true)) {
                    Toast.makeText(this.f1576b, this.d.x1, 1).show();
                    i();
                    return;
                }
            } else if (isLandscapeMode(this.f1576b, true)) {
                Toast.makeText(this.f1576b, this.d.x1, 1).show();
                i();
                return;
            }
            com.igaworks.adpopcorn.activity.b.g gVar = this.V;
            if (gVar != null && gVar.isShowing()) {
                this.V.k();
                return;
            }
            com.igaworks.adpopcorn.a.d dVar = this.z;
            if (dVar != null) {
                dVar.c(false);
            }
            if (com.igaworks.adpopcorn.a.b.a().a(this.f1576b, "adpopcorn_parameter", "check_user_agreement", false)) {
                k();
                return;
            }
            e();
            com.igaworks.adpopcorn.cores.common.g gVar2 = this.d;
            String str = gVar2.Z0;
            String str2 = gVar2.l1;
            String str3 = gVar2.k1;
            Context context = this.f1576b;
            com.igaworks.adpopcorn.activity.b.d.b bVar = new com.igaworks.adpopcorn.activity.b.d.b(context, this.p0, str, "", -1, str2, new i(), str3, new j(z2), isLandscapeMode(context, false));
            this.n0 = bVar;
            bVar.setCancelable(false);
            this.n0.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setApOfferWallOrientation(boolean z2) {
        this.l0 = z2;
    }

    public void setCustomViewMode(boolean z2) {
        this.t0 = z2;
    }

    public void setFilterCampaignKeyList(List<String> list) {
        this.U0 = list;
    }

    public void setOfferwallActivity(Activity activity) {
        this.s0 = activity;
    }

    public void setOfferwallType(int i2) {
        APOfferwallTabInfo aPOfferwallTabInfo = this.R0;
        if (aPOfferwallTabInfo != null) {
            this.S0 = aPOfferwallTabInfo.getTabType(0);
        }
        this.K0 = i2;
        if (i2 == 0) {
            this.L0 = 0;
            int i3 = this.S0;
            if (i3 != 9 && i3 != 10) {
                return;
            }
        } else if (i2 == 1) {
            this.L0 = 1;
            return;
        } else if (i2 != 2) {
            if (i2 == 3) {
                this.L0 = 4;
                return;
            }
            return;
        }
        this.L0 = 2;
    }

    public void setTabOfferwallInfo(APOfferwallTabInfo aPOfferwallTabInfo) {
        this.R0 = aPOfferwallTabInfo;
    }

    public void setViewTypeLoadListener(IViewTypeEventListener iViewTypeEventListener) {
        this.Q0 = iViewTypeEventListener;
    }

    public void showProgressDialog(String str, boolean z2) {
        try {
            h();
            if (((Activity) this.f1576b).isFinishing()) {
                return;
            }
            com.igaworks.adpopcorn.activity.b.d.c cVar = new com.igaworks.adpopcorn.activity.b.d.c(this.f1576b, this.p0);
            this.o0 = cVar;
            cVar.setCancelable(z2);
            this.o0.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
