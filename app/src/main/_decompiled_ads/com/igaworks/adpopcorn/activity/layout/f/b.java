package com.igaworks.adpopcorn.activity.layout.f;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
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
import com.igaworks.adpopcorn.R;
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
public class b extends FrameLayout implements com.igaworks.adpopcorn.a.g.a.d {
    private Handler A;
    private boolean A0;
    private Runnable B;
    private String B0;
    private int C;
    private long C0;
    private int D;
    private APOfferwallTabInfo D0;
    private boolean E;
    private int E0;
    private String F;
    private int F0;
    private String G;
    private List<String> G0;
    private String H;
    private GradientDrawable H0;
    private String I;
    private GradientDrawable I0;
    private String J;
    private String J0;
    private boolean K;
    private String K0;
    private com.igaworks.adpopcorn.cores.model.g L;
    private String L0;
    private Dialog M;
    private boolean M0;
    private Dialog N;
    private int N0;
    private HashMap<String, String> O;
    private int O0;
    private com.igaworks.adpopcorn.a.g.a P;
    private int P0;
    private boolean Q;
    private int Q0;
    private boolean R;
    View.OnClickListener R0;
    private boolean S;
    AdapterView.OnItemClickListener S0;
    private int T;
    AbsListView.OnScrollListener T0;
    private int U;
    private LinearLayout V;
    private com.igaworks.adpopcorn.activity.layout.f.d W;
    private int a;
    private LinearLayout a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f1591b;
    private ViewFlipper b0;
    private Context c;
    private boolean c0;
    private com.igaworks.adpopcorn.cores.common.g d;
    private boolean d0;
    private com.igaworks.adpopcorn.a.c e;
    private Dialog e0;
    private FrameLayout f;
    private com.igaworks.adpopcorn.activity.b.d.c f0;
    private LinearLayout g;
    private int g0;
    private TextView h;
    private boolean h0;
    private TextView i;
    private boolean i0;
    private com.igaworks.adpopcorn.activity.a.c.a j;
    private Activity j0;
    private com.igaworks.adpopcorn.activity.c.e k;
    private boolean k0;
    private com.igaworks.adpopcorn.activity.c.e l;
    private ArrayList<String> l0;
    private List<com.igaworks.adpopcorn.cores.model.g> m;
    private ArrayList<String> m0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> n;
    private int n0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> o;
    private LinearLayout o0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> p;
    private LinearLayout p0;
    private com.igaworks.adpopcorn.cores.model.g q;
    private LinearLayout q0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> r;
    private TextView r0;
    private int s;
    private TextView s0;
    private com.igaworks.adpopcorn.a.d t;
    private List<TextView> t0;
    private String u;
    private List<TextView> u0;
    private String v;
    private List<ImageView> v0;
    private String w;
    private List<ImageView> w0;
    private String x;
    private int x0;
    private String y;
    private int y0;
    private String z;
    private boolean z0;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.i();
        }
    }

    class a0 implements com.igaworks.adpopcorn.a.g.a.d {
        a0(b bVar) {
        }

        @Override // com.igaworks.adpopcorn.a.g.a.d
        public void onNetResponseListener(int i, com.igaworks.adpopcorn.cores.model.f fVar) {
        }
    }

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.layout.f.b$b, reason: collision with other inner class name */
    class ViewOnClickListenerC0429b implements View.OnClickListener {

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.layout.f.b$b$a */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.u();
            }
        }

        ViewOnClickListenerC0429b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                new com.igaworks.adpopcorn.activity.b.k.c(b.this.f1591b, com.igaworks.adpopcorn.activity.b.d.a(b.this.f1591b), b.this.d, new a()).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class b0 implements Runnable {
        final /* synthetic */ com.igaworks.adpopcorn.cores.model.f a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b(true);
            }
        }

        b0(com.igaworks.adpopcorn.cores.model.f fVar) {
            this.a = fVar;
        }

        /* JADX WARN: Code duplicated, block: B:33:0x00da  */
        @Override // java.lang.Runnable
        public void run() {
            int iB;
            boolean z = false;
            b.this.b("", false);
            if (b.this.k0) {
                com.igaworks.adpopcorn.cores.common.d.a((Activity) b.this.f1591b, b.this.f.getWidth());
            } else {
                com.igaworks.adpopcorn.cores.common.d.a();
            }
            if (b.this.e != null && (b.this.e.e() || b.this.e.f())) {
                b bVar = b.this;
                bVar.b(bVar.d.X0, b.this.d.h, true);
                b bVar2 = b.this;
                bVar2.b(bVar2.d.X0, true);
                return;
            }
            com.igaworks.adpopcorn.cores.model.f fVar = this.a;
            if (fVar == null || !fVar.d()) {
                com.igaworks.adpopcorn.cores.model.f fVar2 = this.a;
                if (fVar2 == null || fVar2.a() == null || this.a.a().length() <= 0) {
                    z = true;
                } else {
                    try {
                        com.igaworks.adpopcorn.cores.model.e eVarA = com.igaworks.adpopcorn.a.f.d.a(b.this.f1591b, this.a.a());
                        if (eVarA == null || !eVarA.e()) {
                            iB = 0;
                        } else {
                            b.this.a(eVarA.a(), b.this.T);
                            iB = eVarA.b();
                            b.this.U = eVarA.d();
                            b.this.B0 = eVarA.c();
                        }
                        com.igaworks.adpopcorn.cores.common.h.b(b.this.f1591b, "AP_OFFER", "callbackGetCampaignList: resultCode : " + iB, 3);
                        if (b.this.T >= b.this.U) {
                            b.this.R = true;
                        }
                        b.this.j();
                        b.this.w();
                        if (iB == 500) {
                            b.this.c(true);
                        } else {
                            b.this.c(false);
                        }
                        b.s(b.this);
                        b.this.g();
                    } catch (Exception e) {
                        e.printStackTrace();
                        z = true;
                    }
                }
            } else if (b.this.T == 1) {
                b bVar3 = b.this;
                bVar3.b(bVar3.d.U, b.this.d.h, true);
                if (b.this.m == null || (b.this.m != null && b.this.m.size() == 0)) {
                    b bVar4 = b.this;
                    bVar4.b(bVar4.d.U, true);
                }
            } else {
                b bVar5 = b.this;
                bVar5.a(bVar5.d.p, b.this.d.e, false);
                if (b.this.m == null || (b.this.m != null && b.this.m.size() == 0)) {
                    b bVar6 = b.this;
                    bVar6.b(bVar6.d.U, true);
                }
            }
            b.this.Q = true;
            if (z) {
                if (b.this.T == 1) {
                    b bVar7 = b.this;
                    bVar7.b(bVar7.d.U, b.this.d.h, true);
                    if (b.this.m == null || (b.this.m != null && b.this.m.size() == 0)) {
                        b bVar8 = b.this;
                        bVar8.b(bVar8.d.U, true);
                    }
                } else {
                    new Handler().post(new a());
                }
                b.this.S = true;
                b.this.g();
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b();
        }
    }

    class c0 implements AdapterView.OnItemClickListener {
        c0() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            try {
                if (b.this.M == null || !b.this.M.isShowing()) {
                    b bVar = b.this;
                    bVar.L = (com.igaworks.adpopcorn.cores.model.g) bVar.n.get(i);
                    if (b.this.L.f0()) {
                        return;
                    }
                    if (!b.this.L.a0() && !b.this.L.X()) {
                        b bVar2 = b.this;
                        bVar2.D = bVar2.L.K();
                        b bVar3 = b.this;
                        bVar3.G = bVar3.L.a();
                        b bVar4 = b.this;
                        bVar4.F = bVar4.L.c();
                        b bVar5 = b.this;
                        bVar5.a(bVar5.d.s, false);
                        b.this.t.b("media_offerwall_tab_content_click", b.this.F);
                        b.this.n0 = 1;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("auth", b.this.G);
                        jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(b.this.f1591b));
                        b.this.P.a(0, b.this.u, jSONObject, b.this);
                        return;
                    }
                    b.this.v();
                    b.this.t.b("media_offerwall_tab_content_click", b.this.L.d());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.igaworks.adpopcorn.cores.model.g gVar;
            b bVar;
            try {
                if (b.this.M == null || !b.this.M.isShowing()) {
                    int iIntValue = ((Integer) view.getTag()).intValue();
                    if (!com.igaworks.adpopcorn.cores.common.c.c(b.this.f1591b)) {
                        b bVar2 = b.this;
                        bVar2.b(bVar2.d.g, b.this.d.h, false);
                        return;
                    }
                    if (iIntValue == 0) {
                        bVar = b.this;
                        gVar = bVar.q;
                    } else {
                        b bVar3 = b.this;
                        gVar = (com.igaworks.adpopcorn.cores.model.g) bVar3.r.get(iIntValue - 1);
                        bVar = bVar3;
                    }
                    bVar.L = gVar;
                    b bVar4 = b.this;
                    bVar4.D = bVar4.L.K();
                    b bVar5 = b.this;
                    bVar5.G = bVar5.L.a();
                    b bVar6 = b.this;
                    bVar6.F = bVar6.L.c();
                    b bVar7 = b.this;
                    bVar7.a(bVar7.d.s, false);
                    b.this.n0 = 3;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("auth", b.this.G);
                    jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(b.this.f1591b));
                    b.this.P.a(0, b.this.u, jSONObject, b.this);
                    if (b.this.m0 == null || b.this.m0.contains(b.this.q.c())) {
                        return;
                    }
                    b.this.t.b("media_offerwall_tab_content_click", b.this.F);
                    b.this.m0.add(b.this.F);
                }
            } catch (Exception unused) {
            }
        }
    }

    class d0 implements AbsListView.OnScrollListener {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b(true);
            }
        }

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.layout.f.b$d0$b, reason: collision with other inner class name */
        class RunnableC0430b implements Runnable {
            RunnableC0430b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b(false);
                if (!com.igaworks.adpopcorn.cores.common.c.c(b.this.f1591b)) {
                    b.this.S = true;
                    b.this.b(true);
                } else {
                    b.this.Q = false;
                    b.this.R = false;
                    b.this.P.a(b.this.T, b.this);
                }
            }
        }

        d0() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
        
            if (r4.a.q0 != null) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
        
            if (r4.a.q0 != null) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
        
            if (r4.a.q0 != null) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0060, code lost:
        
            r5 = r4.a.q0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
        
            if (r4.a.q0 != null) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0076, code lost:
        
            if (r4.a.q0 != null) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0078, code lost:
        
            r5 = r4.a.q0;
            r0 = 8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0080, code lost:
        
            r5.setVisibility(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
        
            if (r4.a.q0 != null) goto L23;
         */
        @Override // android.widget.AbsListView.OnScrollListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onScroll(android.widget.AbsListView r5, int r6, int r7, int r8) {
            /*
                Method dump skipped, instruction units count: 230
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.igaworks.adpopcorn.activity.layout.f.b.d0.onScroll(android.widget.AbsListView, int, int, int):void");
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.a(((Integer) view.getTag()).intValue());
        }
    }

    class e0 implements View.OnClickListener {
        e0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.u();
        }
    }

    class f implements View.OnClickListener {
        final /* synthetic */ boolean a;

        f(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.d();
            if (this.a) {
                b.this.i();
            }
        }
    }

    class f0 implements View.OnClickListener {
        f0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new com.igaworks.adpopcorn.activity.b.k.e(b.this.f1591b, b.this.g0, b.this.c0, b.this.d, b.this.M0, b.this.x0).show();
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.d();
        }
    }

    class g0 implements View.OnClickListener {
        g0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new com.igaworks.adpopcorn.activity.b.k.e(b.this.f1591b, b.this.g0, b.this.c0, b.this.d, b.this.M0, b.this.x0).show();
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.d();
            b bVar = b.this;
            bVar.d(bVar.K0);
        }
    }

    class h0 implements View.OnClickListener {
        h0(b bVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    class i implements View.OnClickListener {
        final /* synthetic */ int a;

        i(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (this.a == 1004) {
                    if (com.igaworks.adpopcorn.cores.common.c.c(b.this.f1591b)) {
                        b bVar = b.this;
                        bVar.a(bVar.d.f1613b, false);
                        b.this.P.a(b.this.T, b.this);
                    } else {
                        b bVar2 = b.this;
                        bVar2.b(bVar2.d.g, b.this.d.h, false);
                    }
                }
                if (b.this.j != null) {
                    b.this.j.notifyDataSetChanged();
                }
                b.this.d();
            } catch (Exception unused) {
            }
        }
    }

    class i0 implements DialogInterface.OnDismissListener {
        i0() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.b();
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.d();
        }
    }

    class k implements DialogInterface.OnDismissListener {
        k() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (b.this.e.i()) {
                b bVar = b.this;
                bVar.a(bVar.d.f1613b, true);
            }
        }
    }

    class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                b bVar = b.this;
                if (bVar.c(bVar.L.J())) {
                    b bVar2 = b.this;
                    bVar2.a(true, bVar2.L.J());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            b.this.d();
        }
    }

    class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                int iIntValue = ((Integer) view.getTag()).intValue();
                if (iIntValue == 0) {
                    b.this.u();
                } else if (iIntValue == 1) {
                    b bVar = b.this;
                    bVar.d(bVar.J0);
                }
            } catch (Exception unused) {
            }
        }
    }

    class n implements DialogInterface.OnDismissListener {
        n() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (b.this.M != null) {
                b.this.M = null;
            }
        }
    }

    class o implements DialogInterface.OnDismissListener {
        o() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (b.this.M != null) {
                b.this.M = null;
            }
        }
    }

    class p implements DialogInterface.OnDismissListener {
        p() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (b.this.M != null) {
                b.this.M = null;
            }
        }
    }

    class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (b.this.d0) {
                    b.this.t();
                    return;
                }
                if (b.this.L.a0()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(MBridgeConstans.APP_KEY, b.this.t.e().b());
                    jSONObject.put("adid", b.this.t.e().a());
                    jSONObject.put("usn", b.this.t.e().g());
                    jSONObject.put("integration_type_no", b.this.L.l());
                    jSONObject.put("point", b.this.L.m());
                    b.this.P.a(27, b.this.z, jSONObject, b.this);
                    if (b.this.M != null) {
                        b.this.M.dismiss();
                        return;
                    }
                    return;
                }
                if (b.this.L.X()) {
                    b.this.t.b("media_offerwall_tab_content_engagement", b.this.L.d());
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("auth", b.this.L.a());
                        jSONObject2.put("network", com.igaworks.adpopcorn.cores.common.c.b(b.this.f1591b));
                        jSONObject2.put("channel_code", b.this.n0);
                        b.this.P.a(2, b.this.u, jSONObject2, b.this);
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                if (b.this.D == 7 || b.this.D == 23) {
                    com.igaworks.adpopcorn.a.b.a().b(b.this.c, "participateFlag", b.this.F, true);
                    if (b.this.j != null) {
                        b.this.j.notifyDataSetChanged();
                    }
                }
                b.this.t.b("media_offerwall_tab_content_engagement", b.this.F);
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("auth", b.this.H);
                    jSONObject3.put("network", com.igaworks.adpopcorn.cores.common.c.b(b.this.f1591b));
                    jSONObject3.put("channel_code", b.this.n0);
                    b.this.P.a(1, b.this.v, jSONObject3, b.this);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (b.this.M != null) {
                    b.this.M.dismiss();
                    b.this.M = null;
                    return;
                }
                return;
                e.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    class r implements View.OnClickListener {
        r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.d();
        }
    }

    class s implements View.OnClickListener {
        s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.d();
        }
    }

    class t implements View.OnClickListener {
        t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.a(true);
            b.this.d();
        }
    }

    class u implements View.OnClickListener {
        u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.d();
        }
    }

    class v implements View.OnClickListener {
        v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.u();
        }
    }

    class w implements View.OnClickListener {
        w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.D == 7 || b.this.D == 23) {
                com.igaworks.adpopcorn.a.b.a().b(b.this.c, "participateFlag", b.this.F, true);
                if (b.this.j != null) {
                    b.this.j.notifyDataSetChanged();
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("auth", b.this.H);
                jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(b.this.f1591b));
                jSONObject.put("channel_code", b.this.n0);
                b.this.P.a(1, b.this.v, jSONObject, b.this);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (b.this.M != null) {
                b.this.M.dismiss();
                b.this.M = null;
            }
            b.this.d();
        }
    }

    class x implements View.OnClickListener {
        x() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.d();
        }
    }

    class y implements View.OnClickListener {
        y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                b.this.t.a(b.this.I, b.this.F, b.this.J, b.this.L0);
            } catch (Exception unused) {
            }
        }
    }

    class z implements com.igaworks.adpopcorn.a.g.a.d {
        z(b bVar) {
        }

        @Override // com.igaworks.adpopcorn.a.g.a.d
        public void onNetResponseListener(int i, com.igaworks.adpopcorn.cores.model.f fVar) {
        }
    }

    public b(Context context) {
        super(context);
        this.s = 0;
        this.E = false;
        this.K = false;
        this.L = new com.igaworks.adpopcorn.cores.model.g();
        this.O = new HashMap<>();
        this.T = 0;
        this.U = 1;
        this.g0 = 0;
        this.h0 = false;
        this.i0 = false;
        this.k0 = false;
        this.n0 = 1;
        this.x0 = 0;
        this.y0 = 0;
        this.z0 = false;
        this.B0 = "";
        this.C0 = 0L;
        this.E0 = 0;
        this.F0 = 0;
        this.J0 = "https://m.onestore.co.kr/mobilepoc/web/clause/page.omp?termsCode=US010605";
        this.K0 = "https://m.onestore.co.kr/mobilepoc/web/customer/faqList.omp?category=MW000406";
        this.R0 = new q();
        this.S0 = new c0();
        this.T0 = new d0();
        this.f1591b = context;
        this.c = context.getApplicationContext();
        this.A0 = false;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX WARN: Code duplicated, block: B:75:0x0112 A[Catch: Exception -> 0x0252, TryCatch #0 {Exception -> 0x0252, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x0007, B:7:0x000b, B:8:0x000e, B:10:0x0016, B:11:0x001b, B:13:0x001f, B:14:0x0022, B:16:0x002a, B:17:0x002f, B:22:0x0045, B:24:0x004d, B:26:0x005f, B:28:0x006f, B:31:0x0077, B:33:0x007f, B:35:0x0087, B:37:0x008f, B:40:0x00a0, B:43:0x00ad, B:45:0x00b3, B:47:0x00b9, B:48:0x00be, B:51:0x00c5, B:53:0x00c9, B:55:0x00cf, B:57:0x00d5, B:60:0x00e1, B:65:0x00ed, B:68:0x00f5, B:70:0x00fb, B:72:0x0104, B:74:0x010a, B:75:0x0112, B:76:0x0117, B:82:0x0127, B:84:0x012d, B:89:0x0136, B:91:0x013c, B:93:0x0145, B:95:0x014b, B:96:0x0153, B:102:0x0167, B:97:0x0156, B:99:0x015c, B:41:0x00a3, B:123:0x01b5, B:125:0x01b9, B:127:0x01bd, B:128:0x01c0, B:130:0x01c4, B:132:0x01c8, B:134:0x01ce, B:135:0x01e0, B:137:0x01e4, B:139:0x01ea, B:140:0x01fc, B:141:0x0205, B:143:0x0209, B:145:0x020f, B:146:0x0212, B:148:0x021a), top: B:153:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x0153 A[Catch: Exception -> 0x0252, TryCatch #0 {Exception -> 0x0252, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x0007, B:7:0x000b, B:8:0x000e, B:10:0x0016, B:11:0x001b, B:13:0x001f, B:14:0x0022, B:16:0x002a, B:17:0x002f, B:22:0x0045, B:24:0x004d, B:26:0x005f, B:28:0x006f, B:31:0x0077, B:33:0x007f, B:35:0x0087, B:37:0x008f, B:40:0x00a0, B:43:0x00ad, B:45:0x00b3, B:47:0x00b9, B:48:0x00be, B:51:0x00c5, B:53:0x00c9, B:55:0x00cf, B:57:0x00d5, B:60:0x00e1, B:65:0x00ed, B:68:0x00f5, B:70:0x00fb, B:72:0x0104, B:74:0x010a, B:75:0x0112, B:76:0x0117, B:82:0x0127, B:84:0x012d, B:89:0x0136, B:91:0x013c, B:93:0x0145, B:95:0x014b, B:96:0x0153, B:102:0x0167, B:97:0x0156, B:99:0x015c, B:41:0x00a3, B:123:0x01b5, B:125:0x01b9, B:127:0x01bd, B:128:0x01c0, B:130:0x01c4, B:132:0x01c8, B:134:0x01ce, B:135:0x01e0, B:137:0x01e4, B:139:0x01ea, B:140:0x01fc, B:141:0x0205, B:143:0x0209, B:145:0x020f, B:146:0x0212, B:148:0x021a), top: B:153:0x0000 }] */
    private void a() {
        boolean zA;
        long j2;
        try {
            if (this.q != null) {
                this.q = null;
            }
            ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList = this.o;
            if (arrayList != null) {
                arrayList.clear();
            }
            if (this.n.size() != 0) {
                this.n.clear();
            }
            HashMap<String, String> map = this.O;
            if (map != null) {
                map.clear();
            }
            if (this.p.size() != 0) {
                this.p.clear();
            }
            boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.DISABLE_SPECIAL_OFFER);
            int i2 = this.y0;
            if (i2 == 2 || i2 == 3) {
                zB = true;
            }
            for (int i3 = 0; i3 < this.m.size(); i3++) {
                com.igaworks.adpopcorn.cores.model.g gVar = this.m.get(i3);
                if (a(gVar.c()) && !com.igaworks.adpopcorn.a.b.a().g(this.f1591b, gVar.c())) {
                    int i4 = this.E0;
                    if (i4 == 8) {
                        zA = true;
                        for (int i5 = 0; i5 < this.D0.getTabCount(); i5++) {
                            if (this.D0.getTabType(i5) != 8 && this.D0.getTabType(i5) != 0 && com.igaworks.adpopcorn.cores.common.k.a(this.D0.getTabType(i5), gVar.K())) {
                                zA = false;
                            }
                        }
                    } else {
                        zA = com.igaworks.adpopcorn.cores.common.k.a(i4, gVar.K());
                    }
                    if (zA && (gVar.a0() || gVar.X())) {
                        this.p.add(gVar);
                    }
                    if (gVar.c0()) {
                        zA = false;
                    }
                    int i6 = this.x0;
                    if (i6 == 2) {
                        if (!gVar.f0() && gVar.r() != null && gVar.r().length() > 0) {
                            if (zA) {
                                this.n.add(gVar);
                            }
                            try {
                                j2 = this.C0;
                                this.C0 = j2 + gVar.Q();
                            } catch (Exception unused) {
                            }
                        }
                    } else if (i6 == 3) {
                        if (zA && !gVar.f0()) {
                            if (zB || !gVar.x()) {
                                this.n.add(gVar);
                            } else {
                                this.o.add(gVar);
                                ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList2 = this.o;
                                if (arrayList2 == null || arrayList2.size() > 1) {
                                    this.n.add(gVar);
                                } else {
                                    this.q = gVar;
                                    this.n.add(0, gVar);
                                }
                            }
                        }
                        if (!gVar.f0()) {
                            j2 = this.C0;
                            this.C0 = j2 + gVar.Q();
                        }
                    } else {
                        if (zA && !gVar.f0()) {
                            int i7 = this.y0;
                            if (i7 == 2 || i7 == 3) {
                                if (gVar.r() != null && gVar.r().length() > 0) {
                                    this.n.add(gVar);
                                }
                            } else if (zB || !gVar.x()) {
                                this.n.add(gVar);
                            } else {
                                this.o.add(gVar);
                                ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList3 = this.o;
                                if (arrayList3 == null || arrayList3.size() > 1) {
                                    this.n.add(gVar);
                                } else {
                                    this.q = gVar;
                                    this.n.add(0, gVar);
                                }
                            }
                        }
                        APOfferwallTabInfo aPOfferwallTabInfo = this.D0;
                        if (aPOfferwallTabInfo == null || aPOfferwallTabInfo.getTabCount() <= 1) {
                            j2 = this.C0;
                        } else if (!com.igaworks.adpopcorn.cores.common.k.a(9, gVar.K()) && !com.igaworks.adpopcorn.cores.common.k.a(10, gVar.K())) {
                            j2 = this.C0;
                        } else if (!gVar.f0() && gVar.r() != null && gVar.r().length() > 0) {
                            j2 = this.C0;
                        }
                        this.C0 = j2 + gVar.Q();
                    }
                }
            }
            if (this.c0) {
                ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList4 = this.r;
                if (arrayList4 != null) {
                    arrayList4.clear();
                }
                if (this.q != null) {
                    ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList5 = this.n;
                    if (arrayList5 != null && arrayList5.size() > 0) {
                        this.r.add(this.n.get(0));
                        this.n.remove(0);
                    }
                    ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList6 = this.n;
                    if (arrayList6 != null && arrayList6.size() > 0) {
                        this.r.add(this.n.get(0));
                        this.n.remove(0);
                    }
                    this.W.a(this.r, this.k0);
                }
            }
            if (this.o != null) {
                this.s = 0;
                ViewFlipper viewFlipper = this.b0;
                if (viewFlipper != null) {
                    viewFlipper.removeAllViews();
                }
                for (int i8 = 0; i8 < this.o.size(); i8++) {
                    Context context = this.f1591b;
                    com.igaworks.adpopcorn.activity.c.i iVar = new com.igaworks.adpopcorn.activity.c.i(context, com.igaworks.adpopcorn.cores.common.d.a(context, 15));
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    iVar.setScaleType(ImageView.ScaleType.FIT_XY);
                    iVar.setLayoutParams(layoutParams);
                    this.b0.addView(iVar);
                    com.igaworks.adpopcorn.cores.common.e.a(this.f1591b, this.o.get(i8).T(), iVar, 0, 0, (com.igaworks.adpopcorn.cores.common.e.b) null);
                }
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        TextView textView;
        List<ImageView> list;
        FrameLayout.LayoutParams layoutParams;
        try {
            if (this.F0 == i2) {
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.c, 86), com.igaworks.adpopcorn.cores.common.d.a(this.c, 3));
            layoutParams2.gravity = 81;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, 0);
            layoutParams3.gravity = 81;
            for (int i3 = 0; i3 < 2; i3++) {
                for (int i4 = 0; i4 < this.D0.getTabCount(); i4++) {
                    if (i3 == 0) {
                        textView = this.u0.get(i4);
                        list = this.w0;
                    } else {
                        textView = this.t0.get(i4);
                        list = this.v0;
                    }
                    ImageView imageView = list.get(i4);
                    if (i2 == i4) {
                        textView.setTextColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_SELECT_TEXT_COLOR));
                        imageView.setBackgroundDrawable(this.I0);
                        layoutParams = layoutParams2;
                    } else {
                        textView.setTextColor(Color.parseColor("#8c8c8c"));
                        imageView.setBackgroundColor(Color.parseColor("#00000000"));
                        layoutParams = layoutParams3;
                    }
                    imageView.setLayoutParams(layoutParams);
                }
            }
            int tabType = this.D0.getTabType(i2);
            this.E0 = tabType;
            int i5 = this.x0;
            if (i5 == 0) {
                this.y0 = 0;
                if (tabType == 9) {
                    this.y0 = 0;
                }
            } else if (i5 == 2) {
                this.y0 = 2;
            }
            com.igaworks.adpopcorn.activity.a.c.a aVar = this.j;
            if (aVar != null) {
                aVar.a(this.y0);
            }
            c(false);
            this.F0 = i2;
            com.igaworks.adpopcorn.a.d dVar = this.t;
            if (dVar != null) {
                dVar.b("media_offerwall_tab_visit", this.E0 + "");
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
            g();
            com.igaworks.adpopcorn.cores.common.g gVar2 = this.d;
            str = gVar2.p;
            str2 = gVar2.e;
        } else {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    int i3 = 3;
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1591b, "ApOneStoreOfferWallLayout", "callbackCheckCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    int i4 = jSONObject.getInt("ResultCode");
                    boolean z2 = jSONObject.getBoolean("Result");
                    this.d0 = this.L.d0();
                    if (!z2) {
                        g();
                        if (i4 != 2000) {
                            com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
                            a(gVar3.p, gVar3.x, true);
                            return;
                        }
                        int i5 = this.D;
                        if (i5 != 25 || i5 != 24) {
                            com.igaworks.adpopcorn.a.b.a().b(this.f1591b, this.L.c());
                        }
                        com.igaworks.adpopcorn.cores.common.g gVar4 = this.d;
                        a(gVar4.Y, gVar4.i, true);
                        c(false);
                        return;
                    }
                    this.H = jSONObject.getString("Auth");
                    this.C = jSONObject.getInt("Status");
                    int iK = this.L.K();
                    this.D = iK;
                    if (i2 != 2) {
                        if (iK == 1 || iK == 2) {
                            g();
                            int i6 = this.C;
                            if (i6 != 0 && i6 != 50 && i6 != 125) {
                                d(PointerIconCompat.TYPE_WAIT);
                                return;
                            }
                        } else if (iK == 6 || iK == 7 || iK == 23) {
                            aVar = this.P;
                            gVar = this.L;
                        }
                        v();
                        return;
                    }
                    if (iK != 6 && iK != 7 && iK != 23) {
                        this.t.b("media_offerwall_tab_content_engagement", this.F);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("auth", this.H);
                            jSONObject2.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1591b));
                            jSONObject2.put("channel_code", this.n0);
                            this.P.a(1, this.v, jSONObject2, this);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    aVar = this.P;
                    i3 = 4;
                    gVar = this.L;
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

    private void a(com.igaworks.adpopcorn.cores.model.f fVar) {
        if (this.T == 1) {
            com.igaworks.adpopcorn.a.b.a().a(this.f1591b);
        }
        new Handler(Looper.getMainLooper()).post(new b0(fVar));
    }

    private void a(String str, String str2, double d2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, boolean z2, String str11, int i3, String str12, String str13, String str14) {
        try {
            this.f1591b.startActivity(new Intent(this.f1591b, (Class<?>) ApVideoAdActivity.class).putExtra("cKey", str).putExtra("joinAuth", str2).putExtra("averageRating", d2).putExtra("landscapeImageURL", str3).putExtra("clickAction", str4).putExtra("campaignDescription", str5).putExtra("iconImageURL", str6).putExtra("campaignName", str7).putExtra("numberOfDownloads", str8).putExtra("redirectURL", str9).putExtra("videoURL", str10).putExtra("ADType", i2).putExtra("AutoRedirect", z2).putExtra("fromVideoAPI", false).putExtra("rewardName", str11).putExtra("skipAllowSeconds", i3).putExtra("videoImpressionURL", str12).putExtra("moreClickReportURL", str13).putExtra("PartiTypeCode", this.D).putExtra("campaignCondition", str14));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, boolean z2) {
        g();
        d();
        try {
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(this.f1591b, this.g0, str, str2, -1, this.d.h, new r(), this.c0, false);
            this.e0 = aVar;
            aVar.setCancelable(false);
            this.e0.setCanceledOnTouchOutside(false);
            this.e0.show();
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
                a(this.d.s, false);
            } catch (Exception unused) {
                g();
                return;
            }
        }
        if (this.P == null) {
            this.P = new com.igaworks.adpopcorn.a.g.a(this.f1591b);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("auth", this.H);
        jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1591b));
        this.P.a(11, this.x, jSONObject, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2, String str) {
        String installerPackageName;
        com.igaworks.adpopcorn.a.g.a aVar;
        int i2;
        String str2;
        String str3 = this.H;
        String str4 = this.F;
        try {
            installerPackageName = this.f1591b.getPackageManager().getInstallerPackageName(str);
        } catch (Exception unused) {
            installerPackageName = null;
        }
        try {
            com.igaworks.adpopcorn.cores.common.h.a(this.f1591b, "ApOneStoreOfferWallLayout", "sendCompleteRewardRequest installer = " + installerPackageName, 3);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", this.H);
            jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1591b));
            jSONObject.put("sign", com.igaworks.adpopcorn.cores.common.c.a(str4, str3));
            jSONObject.put(TapjoyConstants.TJC_INSTALLER, installerPackageName);
            if (z2) {
                aVar = this.P;
                i2 = 5;
                str2 = this.w;
            } else {
                aVar = this.P;
                i2 = 19;
                str2 = this.y;
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
        HashMap<String, String> map = this.O;
        if (map != null && map.containsKey(str)) {
            return false;
        }
        List<String> list = this.G0;
        if (list != null && list.contains(str)) {
            return false;
        }
        HashMap<String, String> map2 = this.O;
        if (map2 != null) {
            map2.put(str, str);
        }
        return true;
    }

    private com.igaworks.adpopcorn.activity.layout.b b(int i2) {
        com.igaworks.adpopcorn.activity.layout.b bVar = new com.igaworks.adpopcorn.activity.layout.b(this.c, i2);
        this.V = (LinearLayout) bVar.findViewById(0);
        TextView textView = (TextView) bVar.findViewById(1);
        this.V.setVisibility(8);
        textView.setText(this.d.V);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            this.s++;
            ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList = this.o;
            if (arrayList == null || arrayList.size() <= 1) {
                return;
            }
            if (this.s >= this.o.size()) {
                this.s = 0;
            }
            com.igaworks.adpopcorn.cores.model.g gVar = this.o.get(this.s);
            this.q = gVar;
            if (gVar != null) {
                this.b0.showNext();
                y();
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
                        int i3 = this.D;
                        if (i3 == 6) {
                            g();
                            int i4 = this.C;
                            if (i4 != 0) {
                                if (i4 == 50 || i4 == 125) {
                                    if (i2 == 4) {
                                        this.t.b("media_offerwall_tab_content_engagement", this.F);
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("auth", this.H);
                                        jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1591b));
                                        jSONObject.put("channel_code", this.n0);
                                        this.P.a(1, this.v, jSONObject, this);
                                        return;
                                    }
                                    v();
                                }
                                return;
                            }
                        } else {
                            if (i3 != 7 && i3 != 23) {
                                return;
                            }
                            int i5 = this.C;
                            if (i5 != 0) {
                                if (i5 == 50) {
                                    if (i3 != 23) {
                                        a(true, this.L.J());
                                        return;
                                    } else {
                                        g();
                                        d(PointerIconCompat.TYPE_ALL_SCROLL);
                                        return;
                                    }
                                }
                                if (i5 == 125) {
                                    this.E = true;
                                    this.t.b("media_offerwall_tab_content_engagement", this.F);
                                    try {
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("auth", this.H);
                                        jSONObject2.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1591b));
                                        jSONObject2.put("channel_code", this.n0);
                                        this.P.a(1, this.v, jSONObject2, this);
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
                this.t.b("media_offerwall_tab_content_engagement", this.F);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("auth", this.H);
                jSONObject3.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1591b));
                jSONObject3.put("channel_code", this.n0);
                this.P.a(1, this.v, jSONObject3, this);
                return;
            }
            g();
            int i6 = this.D;
            if (i6 == 6) {
                int i7 = this.C;
                if (i7 != 0 && i7 != 50 && i7 != 125) {
                    return;
                }
            } else {
                if (i6 != 7 && i6 != 23) {
                    return;
                }
                int i8 = this.C;
                if (i8 != 0) {
                    if (i8 == 50 || i8 == 125) {
                        d(PointerIconCompat.TYPE_HELP);
                        return;
                    }
                    return;
                }
            }
            v();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void b(com.igaworks.adpopcorn.cores.model.f fVar) {
        String str;
        String str2;
        com.igaworks.adpopcorn.a.d dVar;
        String strF;
        String str3;
        g();
        if (fVar != null && fVar.d()) {
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            str = gVar.p;
            str2 = gVar.e;
        } else {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1591b, "ApOneStoreOfferWallLayout", "callbackJoinCPMCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    String string = jSONObject.getString("CPMParticipatedTid");
                    this.F = this.L.c();
                    if (!z2) {
                        com.igaworks.adpopcorn.cores.common.g gVar2 = this.d;
                        a(gVar2.p, gVar2.e, false);
                        return;
                    }
                    if (this.L.l() == 16) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(ScarConstants.TOKEN_ID_KEY, string);
                        String string2 = jSONObject2.toString();
                        try {
                            string2 = URLEncoder.encode(jSONObject2.toString(), "utf-8");
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        dVar = this.t;
                        strF = this.L.f() + "&custom=" + string2;
                        str3 = this.F;
                    } else if (this.L.l() == 40) {
                        if (this.L.Y()) {
                            com.igaworks.adpopcorn.cores.common.h.a(this.f1591b, "ApOneStoreOfferWallLayout", "callbackJoinCPMCampaign already completed", 3);
                        } else {
                            b(jSONObject.getString("Auth"));
                            this.L.c(true);
                        }
                        dVar = this.t;
                        strF = this.L.f();
                        str3 = this.F;
                    } else {
                        dVar = this.t;
                        strF = this.L.f();
                        str3 = this.F;
                    }
                    dVar.a(strF, str3, string, this.L0);
                    try {
                        Iterator<String> it = this.L.e().iterator();
                        while (it.hasNext()) {
                            this.P.a(14, it.next(), "", new a0(this));
                        }
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                } catch (JSONException e3) {
                    com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
                    a(gVar3.p, gVar3.e, false);
                    e3.printStackTrace();
                    return;
                }
            }
            com.igaworks.adpopcorn.cores.common.g gVar4 = this.d;
            str = gVar4.Y;
            str2 = gVar4.g;
        }
        a(str, str2, false);
    }

    private void b(String str) {
        com.igaworks.adpopcorn.a.g.a aVar;
        String str2;
        try {
            String strD = this.L.d();
            if (this.L == null) {
                com.igaworks.adpopcorn.cores.common.h.a(this.f1591b, "ApOneStoreOfferWallLayout", "completeCampaign failed", 3);
                return;
            }
            com.igaworks.adpopcorn.cores.common.h.a(this.f1591b, "ApOneStoreOfferWallLayout", "completeCampaign success", 3);
            if (this.P == null) {
                this.P = new com.igaworks.adpopcorn.a.g.a(this.f1591b);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", str);
            jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1591b));
            jSONObject.put("sign", com.igaworks.adpopcorn.cores.common.c.a(strD, str));
            if (com.igaworks.adpopcorn.a.d.E) {
                aVar = this.P;
                str2 = "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/CompleteCPMClick";
            } else {
                aVar = this.P;
                str2 = "https://apapi.adpopcorn.com/ap/v1/common/conversion/CompleteCPMClick";
            }
            aVar.a(28, str2, jSONObject, this);
        } catch (Exception e2) {
            com.igaworks.adpopcorn.cores.common.h.a(this.f1591b, "ApOneStoreOfferWallLayout", "completeCampaign failed : " + e2.getMessage(), 3);
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            a(gVar.Y, gVar.e, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, boolean z2) {
        try {
            g();
            d();
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(this.f1591b, this.g0, this.d.I, str, 1, str2, new f(z2), this.c0, false);
            this.e0 = aVar;
            aVar.setCancelable(false);
            this.e0.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, boolean z2) {
        TextView textView;
        int i2;
        try {
            if (this.k0) {
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
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z2) {
        LinearLayout linearLayout;
        int i2;
        if (z2) {
            linearLayout = this.V;
            i2 = 8;
        } else {
            linearLayout = this.V;
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
    }

    private LinearLayout c(int i2) {
        FrameLayout.LayoutParams layoutParams;
        List<ImageView> list;
        this.q0 = new LinearLayout(this.c);
        LinearLayout linearLayout = new LinearLayout(this.c);
        try {
            int tabCount = this.D0.getTabCount();
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, this.P0 + i2));
            layoutParams2.gravity = 49;
            if (this.c0) {
                this.q0.setPadding(0, 0, 0, 0);
            } else {
                layoutParams2.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.c, this.N0);
                this.q0.setPadding(0, com.igaworks.adpopcorn.cores.common.d.a(this.c, i2), 0, 0);
            }
            this.q0.setOrientation(0);
            this.q0.setGravity(17);
            this.q0.setLayoutParams(layoutParams2);
            this.q0.setBackgroundColor(Color.parseColor("#ffffff"));
            ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, this.P0));
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            linearLayout.setLayoutParams(layoutParams3);
            linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            List<TextView> list2 = this.t0;
            if (list2 == null) {
                this.t0 = new ArrayList();
            } else {
                list2.clear();
            }
            List<TextView> list3 = this.u0;
            if (list3 == null) {
                this.u0 = new ArrayList();
            } else {
                list3.clear();
            }
            List<ImageView> list4 = this.v0;
            if (list4 == null) {
                this.v0 = new ArrayList();
            } else {
                list4.clear();
            }
            List<ImageView> list5 = this.w0;
            if (list5 == null) {
                this.w0 = new ArrayList();
            } else {
                list5.clear();
            }
            for (int i3 = 0; i3 < 2; i3++) {
                for (int i4 = 0; i4 < tabCount; i4++) {
                    FrameLayout frameLayout = new FrameLayout(this.c);
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, com.igaworks.adpopcorn.cores.common.d.a(this.c, this.P0), 1.0f);
                    layoutParams4.gravity = 17;
                    frameLayout.setLayoutParams(layoutParams4);
                    frameLayout.setTag(Integer.valueOf(i4));
                    frameLayout.setOnClickListener(new e());
                    ImageView imageView = new ImageView(this.c);
                    FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, 1.0f));
                    layoutParams5.gravity = 80;
                    imageView.setLayoutParams(layoutParams5);
                    imageView.setBackgroundColor(Color.parseColor("#ececec"));
                    frameLayout.addView(imageView);
                    TextView textView = new TextView(this.c);
                    textView.setLayoutParams(new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, this.P0)));
                    textView.setGravity(17);
                    textView.setTextSize(1, 15.0f);
                    textView.setText(this.D0.getTabTitle(i4));
                    textView.setTag(Integer.valueOf(i4));
                    frameLayout.addView(textView);
                    ImageView imageView2 = new ImageView(this.c);
                    imageView2.setTag(Integer.valueOf(i4));
                    if (i4 == 0) {
                        layoutParams = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.c, 86), com.igaworks.adpopcorn.cores.common.d.a(this.c, 3));
                        textView.setTextColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_SELECT_TEXT_COLOR));
                        imageView2.setBackgroundDrawable(this.I0);
                    } else {
                        layoutParams = new FrameLayout.LayoutParams(-1, 0);
                        textView.setTextColor(Color.parseColor("#8c8c8c"));
                        imageView2.setBackgroundColor(Color.parseColor("#00000000"));
                    }
                    layoutParams.gravity = 81;
                    imageView2.setLayoutParams(layoutParams);
                    frameLayout.addView(imageView2);
                    if (i3 == 0) {
                        this.q0.addView(frameLayout);
                        this.u0.add(textView);
                        list = this.w0;
                    } else {
                        linearLayout.addView(frameLayout);
                        this.t0.add(textView);
                        list = this.v0;
                    }
                    list.add(imageView2);
                }
            }
        } catch (Exception unused) {
        }
        this.f.addView(this.q0);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            ArrayList<String> arrayList = this.l0;
            if (arrayList == null || arrayList.contains(this.q.c()) || !com.igaworks.adpopcorn.cores.common.k.a(this.b0)) {
                return;
            }
            this.l0.add(this.q.c());
        } catch (Exception unused) {
        }
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
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1591b, "ApOneStoreOfferWallLayout", "callbackJoinCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    String string = jSONObject.getString("ResultMsg");
                    int i2 = jSONObject.getInt("ResultCode");
                    if (!jSONObject.has("RedirectURL") || jSONObject.isNull("RedirectURL")) {
                        this.I = "";
                    } else {
                        this.I = jSONObject.getString("RedirectURL");
                    }
                    if (!jSONObject.has("HideBrowser") || jSONObject.isNull("HideBrowser")) {
                        this.K = false;
                    } else {
                        this.K = jSONObject.getBoolean("HideBrowser");
                    }
                    if (jSONObject.has("ParticipatedTid") && !jSONObject.isNull("ParticipatedTid")) {
                        this.J = jSONObject.getLong("ParticipatedTid") + "";
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
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1591b, "ApOneStoreOfferWallLayout", "callbackJoinCampaign success, useHiddenBrowser = " + this.K + ", redirectURL = " + this.I, 3);
                    this.H = jSONObject.getString("Auth");
                    if (this.E) {
                        a(true, this.L.J());
                        this.E = false;
                        return;
                    }
                    int i3 = this.D;
                    if (i3 == 10) {
                        g();
                        c(this.I);
                        return;
                    }
                    if (i3 != 16 && i3 != 26 && i3 != 27) {
                        if (i3 != 25) {
                            g();
                            if (this.L.X()) {
                                this.L.c(true);
                                try {
                                    Iterator<String> it = this.L.e().iterator();
                                    while (it.hasNext()) {
                                        this.P.a(14, it.next(), "", new z(this));
                                    }
                                } catch (Exception unused) {
                                }
                            }
                            if (this.L.h0()) {
                                this.I = this.L.M();
                            }
                            this.t.a(this.I, this.F, this.J, this.L0);
                            return;
                        }
                        g();
                        try {
                            if (c(this.L.J())) {
                                a(false, this.L.J());
                            } else {
                                d();
                                com.igaworks.adpopcorn.a.b.a().b(this.c, "participateFlag", this.F, true);
                                com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
                                com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(this.f1591b, this.g0, gVar3.I, gVar3.u0, -1, gVar3.z, new x(), gVar3.y, new y(), this.c0);
                                this.e0 = aVar;
                                aVar.setCancelable(false);
                                this.e0.show();
                            }
                            return;
                        } catch (Exception unused2) {
                            return;
                        }
                    }
                    a(false);
                    return;
                } catch (JSONException e2) {
                    g();
                    com.igaworks.adpopcorn.cores.common.g gVar4 = this.d;
                    a(gVar4.p, gVar4.e, false);
                    e2.printStackTrace();
                    return;
                }
            }
            g();
            com.igaworks.adpopcorn.cores.common.g gVar5 = this.d;
            str = gVar5.Y;
            str2 = gVar5.g;
        }
        a(str, str2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z2) {
        com.igaworks.adpopcorn.activity.c.e eVar;
        LinearLayout linearLayout;
        ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList;
        ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList2;
        ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList3;
        try {
            this.C0 = 0L;
            g();
            List<com.igaworks.adpopcorn.cores.model.g> list = this.m;
            if (list != null && (list == null || list.size() != 0)) {
                b("", false);
                com.igaworks.adpopcorn.a.c cVar = this.e;
                if (cVar != null && cVar.d()) {
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1591b, "ApOneStoreOfferWallLayout", "sign1 : true", 3);
                    com.igaworks.adpopcorn.cores.common.j.f(this.f1591b);
                }
                a();
                if (this.F0 == 0 && this.E0 == 10 && ((arrayList3 = this.p) == null || arrayList3.size() == 0)) {
                    a(1);
                    return;
                }
                if (!this.c0 && ((arrayList2 = this.n) == null || (arrayList2 != null && arrayList2.size() == 0))) {
                    e(z2);
                    b(this.d.f, true);
                    return;
                }
                int i2 = this.x0;
                if (((i2 == 3 && this.E0 == 0) || (i2 != 3 && this.E0 == 8)) && ((arrayList = this.n) == null || arrayList.size() == 0)) {
                    if (!this.c0) {
                        e(false);
                        b(this.d.f, true);
                        return;
                    }
                    ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList4 = this.r;
                    if (arrayList4 == null || arrayList4.size() == 0) {
                        e(false);
                        b(this.d.f, true);
                        return;
                    }
                }
                if (this.x0 != 2) {
                    y();
                    if (this.q == null || (linearLayout = this.a0) == null) {
                        LinearLayout linearLayout2 = this.a0;
                        if (linearLayout2 != null) {
                            linearLayout2.setVisibility(8);
                        }
                    } else {
                        linearLayout.setVisibility(0);
                    }
                }
                if (this.c0) {
                    if (this.T == 1) {
                        eVar = this.l;
                        eVar.setAdapter((ListAdapter) this.j);
                    }
                } else if (this.T == 1) {
                    eVar = this.k;
                    eVar.setAdapter((ListAdapter) this.j);
                }
                com.igaworks.adpopcorn.activity.a.c.a aVar = this.j;
                if (aVar != null) {
                    aVar.notifyDataSetChanged();
                }
                x();
                return;
            }
            e(z2);
            b(this.d.f, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
        try {
            Intent launchIntentForPackage = this.f1591b.getPackageManager().getLaunchIntentForPackage(str);
            launchIntentForPackage.setFlags(268435456);
            this.f1591b.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Dialog dialog = this.e0;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.e0.dismiss();
        this.e0 = null;
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
                try {
                    com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(this.f1591b, this.g0, str2, str, -1, gVar.h, new i(i2), this.c0, false);
                    this.e0 = aVar;
                    aVar.setCancelable(false);
                    this.e0.show();
                    return;
                } catch (Exception e2) {
                    e = e2;
                }
            } else if (i2 == 1003 || i2 == 1012) {
                try {
                    v();
                    return;
                } catch (Exception e3) {
                    e = e3;
                }
            } else {
                if (i2 != 1013) {
                    return;
                }
                try {
                    com.igaworks.adpopcorn.activity.b.d.a aVar2 = new com.igaworks.adpopcorn.activity.b.d.a(this.f1591b, this.g0, str2, str, -1, gVar.z, new j(), gVar.H, new l(), this.c0);
                    this.e0 = aVar2;
                    aVar2.setCancelable(false);
                    this.e0.show();
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
        g();
        if (fVar != null && fVar.d()) {
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            str = gVar.p;
            str2 = gVar.e;
        } else {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1591b, "ApOneStoreOfferWallLayout", "callbackRewardAppExecute result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    int i2 = jSONObject.getInt("ResultCode");
                    String string = jSONObject.getString("ResultMsg");
                    if (z2) {
                        d(PointerIconCompat.TYPE_WAIT);
                        c(false);
                        com.igaworks.adpopcorn.a.d dVar = this.t;
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
                        com.igaworks.adpopcorn.a.b.a().b(this.c, "participateFlag", this.F, false);
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
    public void d(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            this.f1591b.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    private void d(boolean z2) {
        try {
            g();
            d();
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(this.f1591b, this.g0, gVar.I, z2 ? gVar.U : gVar.e, -1, gVar.h, new s(), gVar.v, new t(), this.c0);
            this.e0 = aVar;
            aVar.setCancelable(false);
            this.e0.setCanceledOnTouchOutside(false);
            this.e0.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void e() {
        if (this.A == null) {
            this.A = new Handler(Looper.getMainLooper());
        }
        if (this.B == null) {
            this.B = new c();
        }
    }

    private void e(com.igaworks.adpopcorn.cores.model.f fVar) {
        String str;
        String str2;
        com.igaworks.adpopcorn.a.b bVarA;
        Context context;
        com.igaworks.adpopcorn.cores.model.g gVar;
        g();
        if (fVar == null || !fVar.d()) {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1591b, "ApOneStoreOfferWallLayout", "callbackRewardAppInstall result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    int i2 = jSONObject.getInt("ResultCode");
                    String string = jSONObject.getString("ResultMsg");
                    if (z2) {
                        if (this.D != 23) {
                            d(PointerIconCompat.TYPE_WAIT);
                            com.igaworks.adpopcorn.a.b.a().b(this.f1591b, this.L.c());
                            c(false);
                            com.igaworks.adpopcorn.a.d dVar = this.t;
                            if (dVar != null) {
                                dVar.c(false);
                                return;
                            }
                            return;
                        }
                        bVarA = com.igaworks.adpopcorn.a.b.a();
                        context = this.f1591b;
                        gVar = this.L;
                    } else {
                        if (this.D != 23) {
                            if (i2 == 2000) {
                                d(1005);
                                com.igaworks.adpopcorn.a.b.a().b(this.f1591b, this.L.c());
                            } else {
                                if (i2 != 2050) {
                                    a(this.d.q, string, true);
                                    return;
                                }
                                com.igaworks.adpopcorn.a.b.a().b(this.c, "participateFlag", this.F, false);
                            }
                            c(false);
                            return;
                        }
                        if (i2 != 2000) {
                            if (i2 == 2050) {
                                com.igaworks.adpopcorn.a.b.a().b(this.c, "participateFlag", this.F, false);
                                return;
                            }
                            return;
                        } else {
                            bVarA = com.igaworks.adpopcorn.a.b.a();
                            context = this.f1591b;
                            gVar = this.L;
                        }
                    }
                    bVarA.b(context, gVar.c());
                    return;
                } catch (JSONException e2) {
                    if (this.D != 23) {
                        com.igaworks.adpopcorn.cores.common.g gVar2 = this.d;
                        a(gVar2.I, gVar2.p, true);
                    }
                    e2.printStackTrace();
                    return;
                }
            }
            if (this.D == 23) {
                return;
            }
            com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
            str = gVar3.I;
            str2 = gVar3.g;
        } else {
            if (this.D == 23) {
                return;
            }
            com.igaworks.adpopcorn.cores.common.g gVar4 = this.d;
            str = gVar4.p;
            str2 = gVar4.e;
        }
        a(str, str2, false);
    }

    private void e(boolean z2) {
        try {
            g();
            d();
            String str = this.d.I;
            String str2 = this.d.f + "\n" + this.d.d0;
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(this.f1591b, this.g0, str, z2 ? this.d.n0 + "\n" + this.d.d0 : str2, -1, gVar.h, new g(), gVar.G, new h(), this.c0);
            this.e0 = aVar;
            aVar.setCancelable(false);
            this.e0.show();
        } catch (Exception unused) {
        }
    }

    private void f(com.igaworks.adpopcorn.cores.model.f fVar) {
        com.igaworks.adpopcorn.cores.model.j jVarA;
        if (fVar != null && fVar.d()) {
            d(true);
        } else if (fVar != null && fVar.a().length() > 0) {
            try {
                com.igaworks.adpopcorn.cores.common.h.a(this.f1591b, "ApOneStoreOfferWallLayout", "callbackVideoAdDetailInfoRequest result = " + fVar.a(), 3);
                if (new JSONObject(fVar.a()).getBoolean("Result") && (jVarA = com.igaworks.adpopcorn.a.f.f.a(fVar.a())) != null) {
                    a(this.L.c(), this.H, jVarA.c(), jVarA.h(), jVarA.e(), jVarA.f(), jVarA.g(), jVarA.j(), jVarA.k(), jVarA.l(), jVarA.r(), jVarA.a(), jVarA.s(), this.L.P(), jVarA.o(), jVarA.q(), jVarA.i(), this.L.N());
                    return;
                }
            } catch (JSONException unused) {
            }
        }
        d(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            com.igaworks.adpopcorn.activity.b.d.c cVar = this.f0;
            if (cVar != null) {
                cVar.dismiss();
                this.f0 = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Activity activity;
        try {
            com.igaworks.adpopcorn.a.d dVar = this.t;
            if (dVar != null) {
                dVar.c(this.L0);
            }
            if (this.h0 || (activity = this.j0) == null) {
                return;
            }
            activity.finish();
            this.j0.overridePendingTransition(0, 0);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        String str;
        if (com.igaworks.adpopcorn.a.d.E) {
            this.u = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/checkcampaign";
            this.v = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/joincampaign";
            this.w = "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/completeinstallcampaign";
            this.x = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/video/getrewardvideodetail";
            this.y = "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/completeexecutecampaign";
            str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/joincpmcampaign";
        } else {
            this.u = "https://apapi.adpopcorn.com/ap/v1/sdk/media/checkcampaign";
            this.v = "https://apapi.adpopcorn.com/ap/v1/sdk/media/joincampaign";
            this.w = "https://apapi.adpopcorn.com/ap/v1/common/conversion/completeinstallcampaign";
            this.x = "https://apapi.adpopcorn.com/ap/v1/sdk/video/getrewardvideodetail";
            this.y = "https://apapi.adpopcorn.com/ap/v1/common/conversion/completeexecutecampaign";
            str = "https://apapi.adpopcorn.com/ap/v1/sdk/media/joincpmcampaign";
        }
        this.z = str;
    }

    private void k() {
        this.Q = false;
        this.R = false;
        this.T = 1;
        long jA = com.igaworks.adpopcorn.a.b.a().a(this.f1591b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_quantity", 0L);
        boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.ALWAYS_SHOW_SPLASH_DIALOG);
        int i2 = Calendar.getInstance().get(6);
        if (zB) {
            this.A0 = false;
        } else if (i2 == com.igaworks.adpopcorn.a.b.a().a(this.f1591b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_imp_day", 0)) {
            this.A0 = true;
        }
        if (this.R || this.T > this.U) {
            b(true);
        } else {
            com.igaworks.adpopcorn.cores.common.h.a(this.f1591b, "ApOneStoreOfferWallLayout", "initCampaignLoading", 3);
            if (com.igaworks.adpopcorn.cores.common.c.c(this.f1591b)) {
                if (this.x0 == 3 || jA == 0 || this.A0) {
                    a(this.d.f1613b, false);
                }
                if (!this.e.i()) {
                    this.P.a(this.T, this);
                }
            } else {
                com.igaworks.adpopcorn.cores.common.g gVar = this.d;
                b(gVar.g, gVar.h, true);
            }
        }
        try {
            if (this.x0 == 3 || this.A0 || jA <= 0) {
                return;
            }
            com.igaworks.adpopcorn.activity.b.i iVar = new com.igaworks.adpopcorn.activity.b.i(this.f1591b, jA, com.igaworks.adpopcorn.a.b.a().a(this.f1591b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_currency", ""), this.g0);
            iVar.show();
            iVar.setOnDismissListener(new k());
            com.igaworks.adpopcorn.a.b.a().b(this.f1591b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_imp_day", i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void l() {
        FrameLayout frameLayout;
        int color;
        LinearLayout linearLayout;
        int color2;
        this.f = new FrameLayout(this.c);
        this.f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (this.c0) {
            frameLayout = this.f;
            color = Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.OFFERWALL_BG_COLOR));
        } else {
            frameLayout = this.f;
            color = Color.parseColor("#f7f7f8");
        }
        frameLayout.setBackgroundColor(color);
        this.g = new LinearLayout(this.c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.g.setOrientation(1);
        this.g.setLayoutParams(layoutParams);
        if (this.c0) {
            this.N0 = 48;
            this.Q0 = 36;
            linearLayout = this.g;
            color2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_BG_COLOR);
        } else {
            linearLayout = this.g;
            color2 = Color.parseColor("#f7f7f8");
        }
        linearLayout.setBackgroundColor(color2);
        this.f.addView(this.g);
        this.f.addView(b(this.Q0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        if (this.c0) {
            com.igaworks.adpopcorn.activity.c.e eVar = new com.igaworks.adpopcorn.activity.c.e(this.c);
            this.l = eVar;
            eVar.setLayoutParams(layoutParams2);
            this.l.setSelector(new StateListDrawable());
            this.l.setNumColumns(2);
            this.l.setHorizontalSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 20));
            this.l.setVerticalSpacing(0);
            this.l.b(n());
            this.g.addView(this.l);
            this.j = new com.igaworks.adpopcorn.activity.a.c.a(this.c, this.n, this.d, true, this.x0, this.y0, this.k0);
            this.l.setOnItemClickListener(this.S0);
            this.l.setOnScrollListener(this.T0);
            int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_FOOTER_MARGIN_DP);
            LinearLayout linearLayout2 = new LinearLayout(this.c);
            linearLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, iC + this.Q0)));
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(80);
            this.l.a(linearLayout2);
            this.f.addView(s());
        } else {
            this.g.addView(o());
            com.igaworks.adpopcorn.activity.c.e eVar2 = new com.igaworks.adpopcorn.activity.c.e(this.c);
            this.k = eVar2;
            eVar2.setVerticalScrollBarEnabled(false);
            this.k.setLayoutParams(layoutParams2);
            this.k.setSelector(new StateListDrawable());
            this.k.setNumColumns(1);
            this.k.setHorizontalSpacing(0);
            this.k.setVerticalSpacing(0);
            this.k.b(r());
            this.g.addView(this.k);
            this.f.addView(s());
            this.j = new com.igaworks.adpopcorn.activity.a.c.a(this.c, this.n, this.d, false, this.x0, this.y0, this.k0);
            this.k.setSelector(new StateListDrawable());
            this.k.setOnItemClickListener(this.S0);
            this.k.setOnScrollListener(this.T0);
        }
        addView(this.f);
    }

    private void m() {
        com.igaworks.adpopcorn.a.d dVarA = com.igaworks.adpopcorn.a.d.a(this.f1591b);
        this.t = dVarA;
        this.e = dVarA.e();
        com.igaworks.adpopcorn.cores.common.e.b(this.f1591b);
        if (!this.k0) {
            com.igaworks.adpopcorn.cores.common.d.a();
        }
        com.igaworks.adpopcorn.cores.common.d.a((Activity) this.f1591b);
        com.igaworks.adpopcorn.cores.common.g gVarA = com.igaworks.adpopcorn.cores.common.g.a();
        this.d = gVarA;
        gVarA.d();
        this.T = 1;
        this.R = false;
        this.d0 = false;
        this.S = false;
        this.n0 = 1;
        this.n = new ArrayList<>();
        this.o = new ArrayList<>();
        this.q = new com.igaworks.adpopcorn.cores.model.g();
        this.r = new ArrayList<>();
        this.p = new ArrayList<>();
        this.l0 = new ArrayList<>();
        this.m0 = new ArrayList<>();
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-15199176, -15199176});
        this.H0 = gradientDrawable;
        gradientDrawable.setShape(0);
        this.H0.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 15));
        this.H0.setGradientType(0);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-14211752, -14211752});
        this.I0 = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.I0.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 17.5f));
        this.I0.setGradientType(0);
        this.a = ((WindowManager) this.f1591b.getSystemService("window")).getDefaultDisplay().getWidth();
        if (this.P == null) {
            this.P = new com.igaworks.adpopcorn.a.g.a(this.f1591b);
        }
        this.g0 = com.igaworks.adpopcorn.activity.b.d.a(this.f1591b);
        com.igaworks.adpopcorn.a.b.a().b(this.f1591b, "adpopcorn_sdk_flag", "isAdPopcornUser", true);
        e();
        try {
            int i2 = Calendar.getInstance().get(6);
            if (i2 != com.igaworks.adpopcorn.a.b.a().a(this.f1591b, "adpopcorn_sdk_flag", "adpopcorn_last_visit_day", -1)) {
                com.igaworks.adpopcorn.a.b.a().e(this.f1591b, "adpopcorn_choice_impression_sp");
                com.igaworks.adpopcorn.a.b.a().b(this.f1591b, "adpopcorn_sdk_flag", "adpopcorn_last_visit_day", i2);
            }
        } catch (Exception unused) {
        }
        this.M0 = false;
        if (this.g0 == 16973841) {
            this.M0 = true;
        }
        this.N0 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_HEIGHT);
        this.Q0 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.BOTTOM_BAR_HEIGHT);
        this.P0 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_BAR_HEIGHT);
        this.O0 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_REWARD_SUMMARY_BAR_HEIGHT);
    }

    private View n() {
        LinearLayout linearLayout = new LinearLayout(this.f1591b);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        linearLayout.addView(o());
        linearLayout.addView(r());
        linearLayout.addView(q());
        return linearLayout;
    }

    private RelativeLayout o() {
        com.igaworks.adpopcorn.activity.layout.f.c cVar = new com.igaworks.adpopcorn.activity.layout.f.c(this.f1591b, this.c0);
        LinearLayout linearLayout = (LinearLayout) cVar.findViewById(1);
        TextView textView = (TextView) cVar.findViewById(2);
        if (this.c0) {
            this.o0 = (LinearLayout) cVar.findViewById(3);
            this.r0 = (TextView) cVar.findViewById(4);
            this.s0 = (TextView) cVar.findViewById(5);
        }
        linearLayout.setOnClickListener(new a());
        if (textView != null) {
            textView.setOnClickListener(new ViewOnClickListenerC0429b());
        }
        if (this.i0) {
            linearLayout.setVisibility(4);
        }
        return cVar;
    }

    private LinearLayout p() {
        this.o0 = new LinearLayout(this.c);
        try {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, this.O0));
            layoutParams.gravity = 17;
            layoutParams.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 20);
            layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 20);
            layoutParams.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 10);
            this.o0.setOrientation(0);
            this.o0.setGravity(17);
            this.o0.setLayoutParams(layoutParams);
            this.o0.setBackgroundDrawable(this.H0);
            ImageView imageView = new ImageView(this.c);
            APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_ICON_RESOURCE_SIZE);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, aPSizeA.width), com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, aPSizeA.height));
            layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 6);
            imageView.setLayoutParams(layoutParams2);
            this.o0.addView(imageView);
            if (com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_ICON_RESOURCE_ID) == -100) {
                com.igaworks.adpopcorn.a.a.a(this.f1591b, "igaw_ap_ic_reward.png", imageView, false);
            } else {
                imageView.setImageResource(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_ICON_RESOURCE_ID));
            }
            this.r0 = new TextView(this.c);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
            layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 16);
            this.r0.setLayoutParams(layoutParams3);
            this.r0.setGravity(17);
            this.r0.setSingleLine();
            this.o0.addView(this.r0);
            this.s0 = new TextView(this.c);
            this.s0.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.s0.setGravity(17);
            this.s0.setSingleLine();
            this.o0.addView(this.s0);
            ImageView imageView2 = new ImageView(this.c);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 10), com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 15));
            layoutParams4.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 2);
            imageView2.setLayoutParams(layoutParams4);
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView2.setImageResource(R.drawable.onestore_ic_my_cash);
            this.o0.addView(imageView2);
        } catch (Exception unused) {
        }
        return this.o0;
    }

    private View q() {
        try {
            LinearLayout linearLayout = this.a0;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
                this.a0 = null;
            }
            com.igaworks.adpopcorn.activity.layout.f.d dVar = new com.igaworks.adpopcorn.activity.layout.f.d(this.c, this.a, this.c0, this.x0, this.d, new d());
            this.W = dVar;
            this.a0 = (LinearLayout) dVar.findViewById(0);
            this.b0 = (ViewFlipper) this.W.findViewById(1);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setFillAfter(true);
            translateAnimation.setDuration(1000L);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation2.setFillAfter(false);
            translateAnimation2.setDuration(1000L);
            this.b0.setInAnimation(translateAnimation);
            this.b0.setOutAnimation(translateAnimation2);
            return this.W;
        } catch (Exception e2) {
            e2.printStackTrace();
            View view = new View(this.c);
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
            return view;
        }
    }

    private LinearLayout r() {
        LinearLayout linearLayout;
        int i2;
        this.p0 = new LinearLayout(this.c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (this.c0) {
            layoutParams.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.c, 20);
        }
        layoutParams.gravity = 17;
        this.p0.setOrientation(1);
        this.p0.setGravity(17);
        this.p0.setLayoutParams(layoutParams);
        this.p0.setBackgroundColor(Color.parseColor("#ffffff"));
        if (this.c0) {
            linearLayout = this.p0;
            i2 = 0;
        } else {
            this.p0.addView(p());
            linearLayout = this.p0;
            i2 = 10;
        }
        linearLayout.addView(c(i2));
        return this.p0;
    }

    static /* synthetic */ int s(b bVar) {
        int i2 = bVar.T;
        bVar.T = i2 + 1;
        return i2;
    }

    private LinearLayout s() {
        Context context;
        int i2;
        LinearLayout linearLayout;
        String language = Locale.getDefault().getLanguage();
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.BOTTOM_BAR_TEXT_COLOR);
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.BOTTOM_BAR_ICON_COLOR);
        int iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.BOTTOM_BAR_TEXT_SIZE_DP);
        int iC4 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.BOTTOM_BAR_TEXT_DIVIDER_COLOR);
        boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.DISABLE_BOTTOM_BAR_ICON);
        boolean zB2 = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.BOTTOM_BAR_TEXT_BOLD);
        LinearLayout linearLayout2 = new LinearLayout(this.c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, this.Q0));
        layoutParams.gravity = 80;
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.BOTTOM_BAR_BG_COLOR));
        if (this.c0) {
            context = this.f1591b;
            i2 = 36;
        } else {
            context = this.f1591b;
            i2 = 20;
        }
        linearLayout2.setPadding(com.igaworks.adpopcorn.cores.common.d.a(context, i2), 0, com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, i2), 0);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        ImageView imageView = new ImageView(this.f1591b);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 11), com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 11));
        layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 4);
        imageView.setLayoutParams(layoutParams2);
        imageView.setOnClickListener(new v());
        com.igaworks.adpopcorn.a.a.a(this.f1591b, "igaw_ap_ic_ques.png", imageView, false);
        imageView.setColorFilter(iC2, PorterDuff.Mode.MULTIPLY);
        TextView textView = new TextView(this.c);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 12);
        textView.setLayoutParams(layoutParams3);
        textView.setGravity(17);
        com.igaworks.adpopcorn.cores.common.k.b(textView, this.d.J, iC3, iC, null, 0, 1, TextUtils.TruncateAt.END, zB2);
        textView.setIncludeFontPadding(false);
        if (language.contains(ApStyleManager.Language.JA) || language.contains(ApStyleManager.Language.EN)) {
            textView.setTextSize(1, 8.0f);
        }
        textView.setOnClickListener(new e0());
        TextView textView2 = new TextView(this.c);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 1), com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 10)));
        textView2.setBackgroundColor(iC4);
        ImageView imageView2 = new ImageView(this.c);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 11), com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 11));
        layoutParams4.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 7);
        layoutParams4.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 5);
        imageView2.setLayoutParams(layoutParams4);
        imageView2.setOnClickListener(new f0());
        com.igaworks.adpopcorn.a.a.a(this.f1591b, "igaw_ap_ic_lock.png", imageView2, false);
        imageView2.setColorFilter(iC2, PorterDuff.Mode.MULTIPLY);
        TextView textView3 = new TextView(this.c);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (zB) {
            layoutParams5.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 12);
        }
        textView3.setLayoutParams(layoutParams5);
        textView3.setGravity(19);
        com.igaworks.adpopcorn.cores.common.k.b(textView3, this.d.w0, iC3, iC, null, 0, 1, TextUtils.TruncateAt.END, zB2);
        if (language.contains(ApStyleManager.Language.JA) || language.contains(ApStyleManager.Language.EN)) {
            textView3.setTextSize(1, 8.0f);
        }
        textView3.setIncludeFontPadding(false);
        textView3.setOnClickListener(new g0());
        ImageView imageView3 = new ImageView(this.c);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 70), com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 14));
        layoutParams6.gravity = 21;
        imageView3.setLayoutParams(layoutParams6);
        imageView3.setOnClickListener(new h0(this));
        imageView3.setImageResource(R.drawable.onestore_ic_bi_white);
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
        linearLayout.addView(imageView3);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        try {
            d();
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(this.f1591b, this.g0, gVar.I, gVar.W, -1, gVar.z, new u(), gVar.y, new w(), this.c0);
            this.e0 = aVar;
            aVar.setCancelable(false);
            this.e0.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        try {
            com.igaworks.adpopcorn.activity.b.k.b bVar = new com.igaworks.adpopcorn.activity.b.k.b(this.f1591b, this.g0, this.c0, this.d, this.M0, this);
            this.N = bVar;
            bVar.setOnDismissListener(new i0());
            this.N.show();
            z();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        Dialog dialog;
        DialogInterface.OnDismissListener nVar;
        int i2;
        g();
        try {
            int i3 = this.x0;
            if (i3 == 2 || (i2 = this.y0) == 2 || i2 == 3) {
                com.igaworks.adpopcorn.activity.b.k.d dVar = new com.igaworks.adpopcorn.activity.b.k.d(this.f1591b, this.g0, this.L, this.d, this.R0, new m());
                this.M = dVar;
                dVar.show();
                dialog = this.M;
                nVar = new n();
            } else if (i3 == 3) {
                this.M = a(this.f1591b, true) ? new com.igaworks.adpopcorn.activity.b.k.a(this.f1591b, this.g0, this.L, this.d, this.R0) : new com.igaworks.adpopcorn.activity.b.a(this.f1591b, this.g0, this.L, this.d, this.R0, false, this.z0);
                this.M.show();
                dialog = this.M;
                nVar = new o();
            } else {
                this.M = a(this.f1591b, true) ? new com.igaworks.adpopcorn.activity.b.k.a(this.f1591b, this.g0, this.L, this.d, this.R0) : new com.igaworks.adpopcorn.activity.b.a(this.f1591b, this.g0, this.L, this.d, this.R0, false, this.z0);
                this.M.show();
                dialog = this.M;
                nVar = new p();
            }
            dialog.setOnDismissListener(nVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
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

    private void x() {
        TextView textView;
        int iC;
        TextUtils.TruncateAt truncateAt;
        TextView textView2;
        int iC2;
        TextUtils.TruncateAt truncateAt2;
        com.igaworks.adpopcorn.a.b bVarA;
        TextView textView3;
        int iC3;
        TextUtils.TruncateAt truncateAt3;
        int i2;
        try {
            if (this.T != 1 || this.C0 <= 0) {
                return;
            }
            int i3 = 17;
            try {
                String str = new DecimalFormat("###,###").format(this.C0);
                com.igaworks.adpopcorn.cores.common.k.b(this.r0, this.d.t1, 14, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_PRE_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, false);
                if (this.c0) {
                    textView3 = this.s0;
                    iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_TEXT_COLOR);
                    truncateAt3 = TextUtils.TruncateAt.END;
                    i2 = 15;
                } else {
                    textView3 = this.s0;
                    iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_TEXT_COLOR);
                    truncateAt3 = TextUtils.TruncateAt.END;
                    i2 = 17;
                }
                com.igaworks.adpopcorn.cores.common.k.b(textView3, str, i2, iC3, null, 0, 0, truncateAt3, false);
                this.o0.setVisibility(0);
                com.igaworks.adpopcorn.a.b.a().b(this.f1591b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_quantity", this.C0);
                bVarA = com.igaworks.adpopcorn.a.b.a();
            } catch (Exception unused) {
                com.igaworks.adpopcorn.cores.common.k.b(this.r0, this.d.t1, 14, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_PRE_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, false);
                if (this.c0) {
                    TextView textView4 = this.s0;
                    iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_TEXT_COLOR);
                    truncateAt2 = TextUtils.TruncateAt.END;
                    i3 = 15;
                    textView2 = textView4;
                } else {
                    textView2 = this.s0;
                    iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_TEXT_COLOR);
                    truncateAt2 = TextUtils.TruncateAt.END;
                }
                com.igaworks.adpopcorn.cores.common.k.b(textView2, "", i3, iC2, null, 0, 0, truncateAt2, false);
                this.o0.setVisibility(0);
                com.igaworks.adpopcorn.a.b.a().b(this.f1591b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_quantity", this.C0);
                bVarA = com.igaworks.adpopcorn.a.b.a();
            } catch (Throwable th) {
                com.igaworks.adpopcorn.cores.common.k.b(this.r0, this.d.t1, 14, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_PRE_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, false);
                if (this.c0) {
                    textView = this.s0;
                    iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_TEXT_COLOR);
                    truncateAt = TextUtils.TruncateAt.END;
                    i3 = 15;
                } else {
                    textView = this.s0;
                    iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_TEXT_COLOR);
                    truncateAt = TextUtils.TruncateAt.END;
                }
                com.igaworks.adpopcorn.cores.common.k.b(textView, "", i3, iC, null, 0, 0, truncateAt, false);
                this.o0.setVisibility(0);
                com.igaworks.adpopcorn.a.b.a().b(this.f1591b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_quantity", this.C0);
                com.igaworks.adpopcorn.a.b.a().b(this.f1591b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_currency", this.B0);
                throw th;
            }
            bVarA.b(this.f1591b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_currency", this.B0);
        } catch (Exception unused2) {
        }
    }

    private void y() {
        try {
            Handler handler = this.A;
            if (handler != null) {
                handler.removeCallbacks(this.B);
                this.A.postDelayed(this.B, 5000L);
            }
        } catch (Exception unused) {
        }
    }

    private void z() {
        Handler handler = this.A;
        if (handler != null) {
            handler.removeCallbacks(this.B);
        }
    }

    public void a(Configuration configuration) {
        try {
            if (!this.k0) {
                com.igaworks.adpopcorn.cores.common.d.a();
            }
            com.igaworks.adpopcorn.cores.common.d.a((Activity) this.f1591b);
            this.a = ((WindowManager) this.f1591b.getSystemService("window")).getDefaultDisplay().getWidth();
            if (this.x0 == 1) {
                setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 9), com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 15), com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 9), com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 15));
                this.a -= com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 9);
            }
            this.T = 1;
            this.R = false;
            this.n0 = 1;
            j();
            Dialog dialog = this.M;
            if (dialog != null && dialog.isShowing()) {
                this.M.dismiss();
                this.M = null;
            }
            Dialog dialog2 = this.N;
            if (dialog2 != null && dialog2.isShowing()) {
                this.N.dismiss();
                this.N = null;
            }
            z();
            removeAllViewsInLayout();
            removeAllViews();
            invalidate();
            l();
            a((String) null, (String) null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        Activity activity;
        try {
            if (this.t != null) {
                if (com.igaworks.adpopcorn.cores.common.k.a(str)) {
                    this.L0 = str;
                    this.t.e("adpopcorn_app_key", str);
                }
                if (com.igaworks.adpopcorn.cores.common.k.a(str2)) {
                    this.t.e("adpopcorn_hash_key", str2);
                }
            }
            this.z0 = false;
            if (Build.VERSION.SDK_INT >= 24 && (activity = this.j0) != null && activity.isInMultiWindowMode()) {
                this.z0 = true;
            }
            boolean z2 = this.z0;
            if (z2 || this.x0 != 3) {
                if (z2 && (com.igaworks.adpopcorn.cores.common.d.c() <= com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO) || com.igaworks.adpopcorn.cores.common.d.b() <= com.igaworks.adpopcorn.cores.common.d.a(this.f1591b, 260))) {
                    Toast.makeText(this.f1591b, this.d.w1, 1).show();
                    i();
                    return;
                }
            } else if (a(this.f1591b, true)) {
                Toast.makeText(this.f1591b, this.d.x1, 1).show();
                i();
                return;
            }
            com.igaworks.adpopcorn.a.d dVar = this.t;
            if (dVar != null) {
                dVar.c(false);
            }
            k();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, boolean z2) {
        try {
            g();
            if (((Activity) this.f1591b).isFinishing()) {
                return;
            }
            com.igaworks.adpopcorn.activity.b.d.c cVar = new com.igaworks.adpopcorn.activity.b.d.c(this.f1591b, this.g0);
            this.f0 = cVar;
            cVar.setCancelable(z2);
            this.f0.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(boolean z2, boolean z3) {
        this.h0 = z2;
        this.i0 = z3;
        try {
            m();
            j();
            l();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean a(Context context, boolean z2) {
        Activity activity;
        if (Build.VERSION.SDK_INT >= 24 && (activity = this.j0) != null && activity.isInMultiWindowMode()) {
            return false;
        }
        if (!z2) {
            return this.c0;
        }
        Configuration configuration = ((Activity) context).getResources().getConfiguration();
        return configuration != null && configuration.orientation == 2;
    }

    public void b(String str, String str2) {
        this.L0 = str;
    }

    public void f() {
        try {
            g();
            z();
            if (this.B != null) {
                this.B = null;
            }
            Dialog dialog = this.M;
            if (dialog != null && dialog.isShowing()) {
                this.M.dismiss();
                this.M = null;
            }
            Dialog dialog2 = this.N;
            if (dialog2 != null && dialog2.isShowing()) {
                this.N.dismiss();
                this.N = null;
            }
            HashMap<String, String> map = this.O;
            if (map != null && map.size() > 0) {
                this.O.clear();
                this.O = null;
            }
            com.igaworks.adpopcorn.activity.a.c.a aVar = this.j;
            if (aVar != null) {
                aVar.a();
            }
            com.igaworks.adpopcorn.a.d dVar = this.t;
            if (dVar != null) {
                dVar.e(this.L0);
            }
            com.igaworks.adpopcorn.a.a.a();
            com.igaworks.adpopcorn.cores.common.e.a(this.f1591b);
            com.igaworks.adpopcorn.cores.common.i.a(this);
        } catch (Exception unused) {
        }
    }

    public int getOfferwallType() {
        return this.x0;
    }

    public void h() {
        try {
            com.igaworks.adpopcorn.a.d dVar = this.t;
            if (dVar != null) {
                dVar.c(this.L0);
            }
            Activity activity = this.j0;
            if (activity == null) {
                a(new Configuration());
            } else {
                activity.finish();
                this.j0.overridePendingTransition(0, 0);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.igaworks.adpopcorn.a.g.a.d
    public void onNetResponseListener(int i2, com.igaworks.adpopcorn.cores.model.f fVar) {
        if (i2 == 11) {
            f(fVar);
        }
        if (i2 == 19) {
            d(fVar);
            return;
        }
        if (i2 == 27) {
            b(fVar);
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
                e(fVar);
                break;
            case 6:
                a(fVar);
                break;
        }
    }

    public void setApOfferWallOrientation(boolean z2) {
        this.c0 = z2;
    }

    public void setCustomViewMode(boolean z2) {
        this.k0 = z2;
    }

    public void setFilterCampaignKeyList(List<String> list) {
        this.G0 = list;
    }

    public void setOfferwallActivity(Activity activity) {
        this.j0 = activity;
    }

    public void setOfferwallType(int i2) {
        this.x0 = i2;
        if (i2 == 0) {
            this.y0 = 0;
        } else if (i2 == 2) {
            this.y0 = 2;
        }
        APOfferwallTabInfo aPOfferwallTabInfo = this.D0;
        if (aPOfferwallTabInfo != null) {
            this.E0 = aPOfferwallTabInfo.getTabType(0);
        }
    }

    public void setTabOfferwallInfo(APOfferwallTabInfo aPOfferwallTabInfo) {
        this.D0 = aPOfferwallTabInfo;
    }
}
