package com.igaworks.adpopcorn.activity.layout.e;

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
import android.view.View;
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
import com.igaworks.adpopcorn.style.ApStyleManager;
import com.kbeanie.imagechooser.api.ChooserType;
import com.mbridge.msdk.MBridgeConstans;
import com.tapjoy.TapjoyConstants;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b extends FrameLayout implements com.igaworks.adpopcorn.a.g.a.d {
    private String A;
    private int A0;
    private String B;
    private int B0;
    private String C;
    private boolean C0;
    private String D;
    private long D0;
    private Handler E;
    private h0 E0;
    private Runnable F;
    private APOfferwallTabInfo F0;
    private int G;
    private int G0;
    private int H;
    private int H0;
    private boolean I;
    private List<String> I0;
    private String J;
    View.OnClickListener J0;
    private String K;
    AdapterView.OnItemClickListener K0;
    private String L;
    AbsListView.OnScrollListener L0;
    private String M;
    private String N;
    private boolean O;
    private com.igaworks.adpopcorn.cores.model.g P;
    private Dialog Q;
    private Dialog R;
    private com.igaworks.adpopcorn.activity.b.g S;
    private HashMap<String, String> T;
    private com.igaworks.adpopcorn.a.g.a U;
    private boolean V;
    private boolean W;
    private int a;
    private boolean a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f1585b;
    private int b0;
    private Context c;
    private int c0;
    private com.igaworks.adpopcorn.cores.common.g d;
    private LinearLayout d0;
    private com.igaworks.adpopcorn.a.c e;
    private com.igaworks.adpopcorn.activity.layout.d e0;
    private FrameLayout f;
    private LinearLayout f0;
    private LinearLayout g;
    private ViewFlipper g0;
    private TextView h;
    private boolean h0;
    private TextView i;
    private boolean i0;
    private com.igaworks.adpopcorn.activity.a.b.a j;
    private Dialog j0;
    private com.igaworks.adpopcorn.activity.c.e k;
    private com.igaworks.adpopcorn.activity.b.d.c k0;
    private com.igaworks.adpopcorn.activity.c.e l;
    private int l0;
    private List<com.igaworks.adpopcorn.cores.model.g> m;
    private boolean m0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> n;
    private boolean n0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> o;
    private Activity o0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> p;
    private boolean p0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> q;
    private WebView q0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> r;
    private ArrayList<String> r0;
    private com.igaworks.adpopcorn.cores.model.g s;
    private ArrayList<String> s0;
    private com.igaworks.adpopcorn.cores.model.g t;
    private int t0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> u;
    private LinearLayout u0;
    private int v;
    private LinearLayout v0;
    private com.igaworks.adpopcorn.a.d w;
    private List<TextView> w0;
    private String x;
    private List<TextView> x0;
    private String y;
    private List<ImageView> y0;
    private String z;
    private List<ImageView> z0;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.igaworks.adpopcorn.cores.model.g gVar;
            b bVar;
            try {
                if (b.this.Q == null || !b.this.Q.isShowing()) {
                    int iIntValue = ((Integer) view.getTag()).intValue();
                    if (!com.igaworks.adpopcorn.cores.common.c.c(b.this.f1585b)) {
                        b bVar2 = b.this;
                        bVar2.b(bVar2.d.g, b.this.d.h, false);
                        return;
                    }
                    if (iIntValue == 0) {
                        bVar = b.this;
                        gVar = bVar.s;
                    } else {
                        b bVar3 = b.this;
                        gVar = (com.igaworks.adpopcorn.cores.model.g) bVar3.u.get(iIntValue - 1);
                        bVar = bVar3;
                    }
                    bVar.P = gVar;
                    b bVar4 = b.this;
                    bVar4.H = bVar4.P.K();
                    b bVar5 = b.this;
                    bVar5.K = bVar5.P.a();
                    b bVar6 = b.this;
                    bVar6.J = bVar6.P.c();
                    b bVar7 = b.this;
                    bVar7.a(bVar7.d.s, false);
                    b.this.t0 = 3;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("auth", b.this.K);
                    jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(b.this.f1585b));
                    b.this.U.a(0, b.this.x, jSONObject, b.this);
                    if (b.this.s0 == null || b.this.s0.contains(b.this.s.c())) {
                        return;
                    }
                    b.this.w.b("media_offerwall_tab_content_click", b.this.J);
                    b.this.s0.add(b.this.J);
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
                if (b.this.Q == null || !b.this.Q.isShowing()) {
                    if (b.this.S == null || !b.this.S.isShowing()) {
                        b bVar = b.this;
                        bVar.P = (com.igaworks.adpopcorn.cores.model.g) bVar.n.get(i);
                        if (b.this.P.f0()) {
                            return;
                        }
                        if (!b.this.P.a0()) {
                            int i2 = 0;
                            if (b.this.P.X()) {
                                b bVar2 = b.this;
                                bVar2.a(bVar2.d.s, false);
                                b.this.w.b("media_offerwall_tab_content_click", b.this.P.d());
                                b.this.t0 = 1;
                                jSONObject = new JSONObject();
                                jSONObject.put("auth", b.this.P.a());
                                jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(b.this.f1585b));
                                aVar = b.this.U;
                                i2 = 2;
                                str = b.this.x;
                            } else if (b.this.P.c0()) {
                                if (b.this.P.b0()) {
                                    b.this.S = new com.igaworks.adpopcorn.activity.b.g(b.this.f1585b, b.this.l0, b.this.P, b.this.d, new a(this));
                                    b.this.S.show();
                                } else {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put(MBridgeConstans.APP_KEY, b.this.w.e().b());
                                    jSONObject2.put("adid", b.this.w.e().a());
                                    jSONObject2.put("usn", b.this.w.e().g());
                                    jSONObject2.put("integration_type_no", b.this.P.E());
                                    jSONObject2.put("point", b.this.P.F());
                                    jSONObject2.put("newsId", b.this.P.C());
                                    b.this.U.a(29, b.this.D, jSONObject2, b.this);
                                }
                                dVar = b.this.w;
                                strY = b.this.P.y();
                            } else {
                                b bVar3 = b.this;
                                bVar3.H = bVar3.P.K();
                                b bVar4 = b.this;
                                bVar4.K = ((com.igaworks.adpopcorn.cores.model.g) bVar4.n.get(i)).a();
                                b bVar5 = b.this;
                                bVar5.J = ((com.igaworks.adpopcorn.cores.model.g) bVar5.n.get(i)).c();
                                b bVar6 = b.this;
                                bVar6.a(bVar6.d.s, false);
                                b.this.w.b("media_offerwall_tab_content_click", b.this.J);
                                b.this.t0 = 1;
                                jSONObject = new JSONObject();
                                jSONObject.put("auth", b.this.K);
                                jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(b.this.f1585b));
                                aVar = b.this.U;
                                str = b.this.x;
                            }
                            aVar.a(i2, str, jSONObject, b.this);
                            return;
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(MBridgeConstans.APP_KEY, b.this.w.e().b());
                        jSONObject3.put("adid", b.this.w.e().a());
                        jSONObject3.put("usn", b.this.w.e().g());
                        jSONObject3.put("integration_type_no", b.this.P.l());
                        jSONObject3.put("point", b.this.P.m());
                        b.this.U.a(27, b.this.C, jSONObject3, b.this);
                        dVar = b.this.w;
                        strY = b.this.P.d();
                        dVar.b("media_offerwall_tab_content_click", strY);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.layout.e.b$b, reason: collision with other inner class name */
    class ViewOnClickListenerC0427b implements View.OnClickListener {
        ViewOnClickListenerC0427b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.a(((Integer) view.getTag()).intValue());
        }
    }

    class b0 implements AbsListView.OnScrollListener {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b(true);
            }
        }

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.layout.e.b$b0$b, reason: collision with other inner class name */
        class RunnableC0428b implements Runnable {
            RunnableC0428b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b(false);
                if (!com.igaworks.adpopcorn.cores.common.c.c(b.this.f1585b)) {
                    b.this.a0 = true;
                    b.this.b(true);
                } else {
                    b.this.V = false;
                    b.this.W = false;
                    b.this.U.a(b.this.b0, b.this);
                }
            }
        }

        b0() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
        
            if (r4.a.v0 != null) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
        
            r5 = r4.a.v0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
        
            if (r4.a.v0 != null) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:
        
            if (r4.a.v0 != null) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
        
            r5 = r4.a.v0;
            r0 = 8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x005f, code lost:
        
            r5.setVisibility(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0028, code lost:
        
            if (r4.a.v0 != null) goto L15;
         */
        @Override // android.widget.AbsListView.OnScrollListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onScroll(android.widget.AbsListView r5, int r6, int r7, int r8) {
            /*
                r4 = this;
                com.igaworks.adpopcorn.activity.layout.e.b r0 = com.igaworks.adpopcorn.activity.layout.e.b.this
                int r0 = com.igaworks.adpopcorn.activity.layout.e.b.T(r0)
                r1 = 1
                r2 = 3
                if (r0 != r2) goto L62
                r0 = 0
                android.view.View r5 = r5.getChildAt(r0)
                if (r5 == 0) goto L4f
                int r5 = r5.getTop()
                int r5 = -r5
                com.igaworks.adpopcorn.style.a r2 = com.igaworks.adpopcorn.style.a.b()
                java.lang.String r3 = "OFFERWALL_REWARD_SUMMARY_BAR_HEIGHT"
                int r2 = r2.c(r3)
                if (r6 < r1) goto L2b
                com.igaworks.adpopcorn.activity.layout.e.b r5 = com.igaworks.adpopcorn.activity.layout.e.b.this
                android.widget.LinearLayout r5 = com.igaworks.adpopcorn.activity.layout.e.b.V(r5)
                if (r5 == 0) goto L62
                goto L3f
            L2b:
                com.igaworks.adpopcorn.activity.layout.e.b r3 = com.igaworks.adpopcorn.activity.layout.e.b.this
                android.content.Context r3 = com.igaworks.adpopcorn.activity.layout.e.b.t(r3)
                int r2 = com.igaworks.adpopcorn.cores.common.d.a(r3, r2)
                if (r5 < r2) goto L46
                com.igaworks.adpopcorn.activity.layout.e.b r5 = com.igaworks.adpopcorn.activity.layout.e.b.this
                android.widget.LinearLayout r5 = com.igaworks.adpopcorn.activity.layout.e.b.V(r5)
                if (r5 == 0) goto L62
            L3f:
                com.igaworks.adpopcorn.activity.layout.e.b r5 = com.igaworks.adpopcorn.activity.layout.e.b.this
                android.widget.LinearLayout r5 = com.igaworks.adpopcorn.activity.layout.e.b.V(r5)
                goto L5f
            L46:
                com.igaworks.adpopcorn.activity.layout.e.b r5 = com.igaworks.adpopcorn.activity.layout.e.b.this
                android.widget.LinearLayout r5 = com.igaworks.adpopcorn.activity.layout.e.b.V(r5)
                if (r5 == 0) goto L62
                goto L57
            L4f:
                com.igaworks.adpopcorn.activity.layout.e.b r5 = com.igaworks.adpopcorn.activity.layout.e.b.this
                android.widget.LinearLayout r5 = com.igaworks.adpopcorn.activity.layout.e.b.V(r5)
                if (r5 == 0) goto L62
            L57:
                com.igaworks.adpopcorn.activity.layout.e.b r5 = com.igaworks.adpopcorn.activity.layout.e.b.this
                android.widget.LinearLayout r5 = com.igaworks.adpopcorn.activity.layout.e.b.V(r5)
                r0 = 8
            L5f:
                r5.setVisibility(r0)
            L62:
                if (r6 != 0) goto L7d
                com.igaworks.adpopcorn.activity.layout.e.b r5 = com.igaworks.adpopcorn.activity.layout.e.b.this     // Catch: java.lang.Exception -> L7d
                java.util.ArrayList r5 = com.igaworks.adpopcorn.activity.layout.e.b.W(r5)     // Catch: java.lang.Exception -> L7d
                if (r5 == 0) goto L7d
                com.igaworks.adpopcorn.activity.layout.e.b r5 = com.igaworks.adpopcorn.activity.layout.e.b.this     // Catch: java.lang.Exception -> L7d
                java.util.ArrayList r5 = com.igaworks.adpopcorn.activity.layout.e.b.W(r5)     // Catch: java.lang.Exception -> L7d
                int r5 = r5.size()     // Catch: java.lang.Exception -> L7d
                if (r5 <= r1) goto L7d
                com.igaworks.adpopcorn.activity.layout.e.b r5 = com.igaworks.adpopcorn.activity.layout.e.b.this     // Catch: java.lang.Exception -> L7d
                com.igaworks.adpopcorn.activity.layout.e.b.X(r5)     // Catch: java.lang.Exception -> L7d
            L7d:
                com.igaworks.adpopcorn.activity.layout.e.b r5 = com.igaworks.adpopcorn.activity.layout.e.b.this
                boolean r5 = com.igaworks.adpopcorn.activity.layout.e.b.M(r5)
                if (r5 == 0) goto Lc4
                com.igaworks.adpopcorn.activity.layout.e.b r5 = com.igaworks.adpopcorn.activity.layout.e.b.this
                boolean r5 = com.igaworks.adpopcorn.activity.layout.e.b.N(r5)
                if (r5 != 0) goto Lc4
                com.igaworks.adpopcorn.activity.layout.e.b r5 = com.igaworks.adpopcorn.activity.layout.e.b.this
                boolean r5 = com.igaworks.adpopcorn.activity.layout.e.b.H(r5)
                if (r5 != 0) goto Lb7
                com.igaworks.adpopcorn.activity.layout.e.b r5 = com.igaworks.adpopcorn.activity.layout.e.b.this
                int r5 = com.igaworks.adpopcorn.activity.layout.e.b.o(r5)
                com.igaworks.adpopcorn.activity.layout.e.b r0 = com.igaworks.adpopcorn.activity.layout.e.b.this
                int r0 = com.igaworks.adpopcorn.activity.layout.e.b.G(r0)
                if (r5 <= r0) goto La4
                goto Lb7
            La4:
                if (r8 < r1) goto Lc4
                int r6 = r6 + r7
                if (r6 != r8) goto Lc4
                android.os.Handler r5 = new android.os.Handler
                r5.<init>()
                com.igaworks.adpopcorn.activity.layout.e.b$b0$b r6 = new com.igaworks.adpopcorn.activity.layout.e.b$b0$b
                r6.<init>()
                r5.post(r6)
                goto Lc4
            Lb7:
                android.os.Handler r5 = new android.os.Handler
                r5.<init>()
                com.igaworks.adpopcorn.activity.layout.e.b$b0$a r6 = new com.igaworks.adpopcorn.activity.layout.e.b$b0$a
                r6.<init>()
                r5.post(r6)
            Lc4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.igaworks.adpopcorn.activity.layout.e.b.b0.onScroll(android.widget.AbsListView, int, int, int):void");
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    class c implements View.OnClickListener {
        final /* synthetic */ boolean a;

        c(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.d();
            if (this.a) {
                b.this.j();
            }
        }
    }

    class c0 implements DialogInterface.OnDismissListener {
        c0() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.b();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.d();
            b.this.j();
        }
    }

    class d0 implements View.OnClickListener {
        d0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.j();
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.d();
            String str = "https://adpopcorn.notion.site/FAQ-35edb7e2c4ff4311b2bcf616c8e1b022";
            String strA = com.igaworks.adpopcorn.a.b.a().a(b.this.f1585b, "adpopcorn_sdk_flag", "no_ad_landingurl", "https://adpopcorn.notion.site/FAQ-35edb7e2c4ff4311b2bcf616c8e1b022");
            if (strA != null && strA.length() > 0) {
                str = strA;
            }
            b.this.d(str);
        }
    }

    class e0 implements View.OnClickListener {
        e0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.j();
        }
    }

    class f implements View.OnClickListener {
        final /* synthetic */ int a;

        f(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (this.a == 1004) {
                    if (com.igaworks.adpopcorn.cores.common.c.c(b.this.f1585b)) {
                        b bVar = b.this;
                        bVar.a(bVar.d.f1613b, false);
                        b.this.U.a(b.this.b0, b.this);
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

    class f0 implements View.OnClickListener {
        f0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.u();
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

    class g0 implements Runnable {
        g0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b();
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                b bVar = b.this;
                if (bVar.c(bVar.P.J())) {
                    b bVar2 = b.this;
                    bVar2.a(true, bVar2.P.J());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            b.this.d();
        }
    }

    public interface h0 {
        void OnLoadedOfferWallPage();
    }

    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                b.this.u();
            } catch (Exception unused) {
            }
        }
    }

    class j implements DialogInterface.OnDismissListener {
        j() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (b.this.Q != null) {
                b.this.Q = null;
            }
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.igaworks.adpopcorn.a.d.a(b.this.f1585b) != null) {
                com.igaworks.adpopcorn.a.d.a(b.this.f1585b).j();
            }
            b.this.d();
            b.this.j();
        }
    }

    class l implements View.OnClickListener {
        final /* synthetic */ boolean a;

        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.d();
                l lVar = l.this;
                b.this.d(lVar.a);
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
                        b.this.d();
                        com.igaworks.adpopcorn.a.b.a().b(b.this.f1585b, "adpopcorn_parameter", "check_user_agreement", true);
                        b.this.d(this.a);
                        if (com.igaworks.adpopcorn.a.d.a(b.this.f1585b) != null) {
                            com.igaworks.adpopcorn.a.d.a(b.this.f1585b).i();
                        }
                    } else {
                        b.this.d();
                        String str = b.this.d.Y;
                        String str2 = b.this.d.j1;
                        String str3 = b.this.d.I;
                        b bVar = b.this;
                        Context context = b.this.f1585b;
                        int i = b.this.l0;
                        a aVar = new a();
                        b bVar2 = b.this;
                        bVar.j0 = new com.igaworks.adpopcorn.activity.b.d.a(context, i, str, str2, -1, str3, aVar, bVar2.a(bVar2.f1585b, false), false);
                        b.this.j0.setCancelable(true);
                        b.this.j0.show();
                    }
                } catch (Exception unused) {
                }
            } else {
                b.this.d();
                String str4 = b.this.d.Y;
                String str5 = b.this.d.j1;
                String str6 = b.this.d.I;
                b bVar3 = b.this;
                Context context2 = b.this.f1585b;
                int i2 = b.this.l0;
                a aVar2 = new a();
                b bVar4 = b.this;
                bVar3.j0 = new com.igaworks.adpopcorn.activity.b.d.a(context2, i2, str4, str5, -1, str6, aVar2, bVar4.a(bVar4.f1585b, false), false);
                b.this.j0.setCancelable(true);
                b.this.j0.show();
            }
        }
    }

    class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (b.this.i0) {
                    b.this.r();
                    return;
                }
                if (b.this.H == 7 || b.this.H == 23) {
                    com.igaworks.adpopcorn.a.b.a().b(b.this.c, "participateFlag", b.this.J, true);
                    if (b.this.j != null) {
                        b.this.j.notifyDataSetChanged();
                    }
                }
                b.this.w.b("media_offerwall_tab_content_engagement", b.this.J);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("auth", b.this.L);
                    jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(b.this.f1585b));
                    jSONObject.put("channel_code", b.this.t0);
                    b.this.U.a(1, b.this.y, jSONObject, b.this);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (b.this.Q != null) {
                    b.this.Q.dismiss();
                    b.this.Q = null;
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
            b.this.d();
        }
    }

    class o implements View.OnClickListener {
        o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.d();
        }
    }

    class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.a(true);
            b.this.d();
        }
    }

    class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.d();
        }
    }

    class r implements View.OnClickListener {
        r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.H == 7 || b.this.H == 23) {
                com.igaworks.adpopcorn.a.b.a().b(b.this.c, "participateFlag", b.this.J, true);
                if (b.this.j != null) {
                    b.this.j.notifyDataSetChanged();
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("auth", b.this.L);
                jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(b.this.f1585b));
                jSONObject.put("channel_code", b.this.t0);
                b.this.U.a(1, b.this.y, jSONObject, b.this);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (b.this.Q != null) {
                b.this.Q.dismiss();
                b.this.Q = null;
            }
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
            try {
                if (com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.PASS_PARTICIPATE_EVENT)) {
                    b.this.w.a(b.this.M, b.this.J, b.this.N, (String) null);
                } else if (b.this.O) {
                    b bVar = b.this;
                    bVar.e(bVar.M);
                } else {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(b.this.M));
                    b.this.f1585b.startActivity(intent);
                }
            } catch (Exception unused) {
            }
        }
    }

    class u implements com.igaworks.adpopcorn.a.g.a.d {
        u(b bVar) {
        }

        @Override // com.igaworks.adpopcorn.a.g.a.d
        public void onNetResponseListener(int i, com.igaworks.adpopcorn.cores.model.f fVar) {
        }
    }

    class v implements com.igaworks.adpopcorn.a.g.a.d {
        v(b bVar) {
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
            if (b.this.P.b0()) {
                return;
            }
            b.this.e();
            com.igaworks.adpopcorn.a.b.a().a(b.this.f1585b, b.this.P.C());
            b.this.P.g(true);
        }
    }

    class x implements DialogInterface.OnDismissListener {
        x() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (b.this.j != null) {
                b.this.j.notifyDataSetChanged();
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
                b.this.b(true);
            }
        }

        y(com.igaworks.adpopcorn.cores.model.f fVar) {
            this.a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int iB;
            boolean z = false;
            b.this.b("", false);
            if (b.this.p0) {
                com.igaworks.adpopcorn.cores.common.d.a((Activity) b.this.f1585b, b.this.f.getWidth());
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
                        com.igaworks.adpopcorn.cores.model.e eVarA = com.igaworks.adpopcorn.a.f.d.a(b.this.f1585b, this.a.a());
                        if (eVarA == null || !eVarA.e()) {
                            iB = 0;
                        } else {
                            b.this.a(eVarA.a(), b.this.b0);
                            iB = eVarA.b();
                            b.this.c0 = eVarA.d();
                        }
                        com.igaworks.adpopcorn.cores.common.h.b(b.this.f1585b, "AP_OFFER", "callbackGetCampaignList: resultCode : " + iB, 3);
                        if (b.this.b0 >= b.this.c0) {
                            b.this.W = true;
                        }
                        b.this.k();
                        b.this.w();
                        if (iB == 500) {
                            b.this.c(true);
                        } else {
                            b.this.c(false);
                        }
                        b.p(b.this);
                        b.this.h();
                    } catch (Exception e) {
                        e.printStackTrace();
                        z = true;
                    }
                }
            } else {
                if (b.this.b0 == 1) {
                    b bVar3 = b.this;
                    bVar3.b(bVar3.d.U, b.this.d.h, true);
                } else {
                    b bVar4 = b.this;
                    bVar4.a(bVar4.d.p, b.this.d.e, false);
                }
                if (b.this.m == null || (b.this.m != null && b.this.m.size() == 0)) {
                    b bVar5 = b.this;
                    bVar5.b(bVar5.d.U, true);
                }
            }
            b.this.V = true;
            if (z) {
                if (b.this.b0 == 1) {
                    b bVar6 = b.this;
                    bVar6.b(bVar6.d.U, b.this.d.h, true);
                    if (b.this.m == null || (b.this.m != null && b.this.m.size() == 0)) {
                        b bVar7 = b.this;
                        bVar7.b(bVar7.d.U, true);
                    }
                } else {
                    new Handler().post(new a());
                }
                b.this.a0 = true;
                b.this.h();
            }
            if (b.this.E0 != null) {
                b.this.E0.OnLoadedOfferWallPage();
            }
        }
    }

    class z extends WebViewClient {
        z() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                com.igaworks.adpopcorn.cores.common.h.a(b.this.f1585b, "ApLottemMemOfferWallLayout", "shouldOverrideUrlLoading = " + str, 3);
                if (str != null && str.startsWith("http://play.google.com/store/apps/")) {
                    str = str.replace("http://play.google.com/store/apps/", "market://");
                } else if (str != null && str.startsWith("https://play.google.com/store/apps/")) {
                    str = str.replace("https://play.google.com/store/apps/", "market://");
                }
                if (str == null || !str.contains("market://")) {
                    webView.loadUrl(str);
                    return true;
                }
                b.this.d(str);
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
    }

    public b(Context context) {
        super(context);
        this.v = 0;
        this.I = false;
        this.O = false;
        this.P = new com.igaworks.adpopcorn.cores.model.g();
        this.T = new HashMap<>();
        this.b0 = 0;
        this.c0 = 1;
        this.l0 = 0;
        this.m0 = false;
        this.n0 = false;
        this.p0 = false;
        this.t0 = 1;
        this.A0 = 0;
        this.B0 = 0;
        this.C0 = false;
        this.D0 = 0L;
        this.G0 = 0;
        this.H0 = 0;
        this.J0 = new m();
        this.K0 = new a0();
        this.L0 = new b0();
        this.f1585b = context;
        this.c = context.getApplicationContext();
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0176  */
    /* JADX WARN: Code duplicated, block: B:103:0x0178 A[Catch: Exception -> 0x02e7, TRY_ENTER, TryCatch #1 {Exception -> 0x02e7, blocks: (B:2:0x0000, B:4:0x0005, B:5:0x0007, B:7:0x000b, B:8:0x000d, B:10:0x0011, B:11:0x0014, B:13:0x001c, B:14:0x0021, B:16:0x0029, B:17:0x002e, B:19:0x0036, B:20:0x003b, B:22:0x0043, B:23:0x0048, B:25:0x004c, B:26:0x004f, B:31:0x0065, B:33:0x006d, B:35:0x007f, B:37:0x008f, B:40:0x0097, B:42:0x009f, B:44:0x00a7, B:46:0x00af, B:49:0x00c0, B:52:0x00cd, B:54:0x00d3, B:56:0x00d9, B:64:0x00f8, B:65:0x00fb, B:67:0x00ff, B:69:0x0105, B:71:0x010b, B:74:0x0117, B:79:0x0123, B:81:0x0129, B:83:0x012f, B:85:0x0138, B:87:0x0142, B:89:0x0148, B:91:0x0151, B:93:0x0157, B:95:0x015b, B:96:0x0163, B:97:0x0168, B:103:0x0178, B:107:0x017f, B:109:0x0185, B:111:0x018b, B:113:0x0194, B:115:0x019e, B:117:0x01a4, B:119:0x01ad, B:121:0x01b3, B:123:0x01b7, B:124:0x01bf, B:132:0x01d9, B:125:0x01c2, B:127:0x01c8, B:129:0x01ce, B:58:0x00de, B:60:0x00e4, B:63:0x00f6, B:50:0x00c3, B:155:0x0234, B:157:0x023c, B:159:0x0240, B:160:0x0243, B:162:0x0247, B:164:0x024b, B:166:0x0251, B:167:0x0263, B:169:0x0267, B:171:0x026d, B:172:0x027f, B:173:0x0288, B:175:0x028c, B:177:0x0292, B:178:0x0295, B:180:0x029d, B:182:0x02a9, B:184:0x02b1), top: B:191:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x01bf A[Catch: Exception -> 0x02e7, TryCatch #1 {Exception -> 0x02e7, blocks: (B:2:0x0000, B:4:0x0005, B:5:0x0007, B:7:0x000b, B:8:0x000d, B:10:0x0011, B:11:0x0014, B:13:0x001c, B:14:0x0021, B:16:0x0029, B:17:0x002e, B:19:0x0036, B:20:0x003b, B:22:0x0043, B:23:0x0048, B:25:0x004c, B:26:0x004f, B:31:0x0065, B:33:0x006d, B:35:0x007f, B:37:0x008f, B:40:0x0097, B:42:0x009f, B:44:0x00a7, B:46:0x00af, B:49:0x00c0, B:52:0x00cd, B:54:0x00d3, B:56:0x00d9, B:64:0x00f8, B:65:0x00fb, B:67:0x00ff, B:69:0x0105, B:71:0x010b, B:74:0x0117, B:79:0x0123, B:81:0x0129, B:83:0x012f, B:85:0x0138, B:87:0x0142, B:89:0x0148, B:91:0x0151, B:93:0x0157, B:95:0x015b, B:96:0x0163, B:97:0x0168, B:103:0x0178, B:107:0x017f, B:109:0x0185, B:111:0x018b, B:113:0x0194, B:115:0x019e, B:117:0x01a4, B:119:0x01ad, B:121:0x01b3, B:123:0x01b7, B:124:0x01bf, B:132:0x01d9, B:125:0x01c2, B:127:0x01c8, B:129:0x01ce, B:58:0x00de, B:60:0x00e4, B:63:0x00f6, B:50:0x00c3, B:155:0x0234, B:157:0x023c, B:159:0x0240, B:160:0x0243, B:162:0x0247, B:164:0x024b, B:166:0x0251, B:167:0x0263, B:169:0x0267, B:171:0x026d, B:172:0x027f, B:173:0x0288, B:175:0x028c, B:177:0x0292, B:178:0x0295, B:180:0x029d, B:182:0x02a9, B:184:0x02b1), top: B:191:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x01c2 A[Catch: Exception -> 0x02e7, TryCatch #1 {Exception -> 0x02e7, blocks: (B:2:0x0000, B:4:0x0005, B:5:0x0007, B:7:0x000b, B:8:0x000d, B:10:0x0011, B:11:0x0014, B:13:0x001c, B:14:0x0021, B:16:0x0029, B:17:0x002e, B:19:0x0036, B:20:0x003b, B:22:0x0043, B:23:0x0048, B:25:0x004c, B:26:0x004f, B:31:0x0065, B:33:0x006d, B:35:0x007f, B:37:0x008f, B:40:0x0097, B:42:0x009f, B:44:0x00a7, B:46:0x00af, B:49:0x00c0, B:52:0x00cd, B:54:0x00d3, B:56:0x00d9, B:64:0x00f8, B:65:0x00fb, B:67:0x00ff, B:69:0x0105, B:71:0x010b, B:74:0x0117, B:79:0x0123, B:81:0x0129, B:83:0x012f, B:85:0x0138, B:87:0x0142, B:89:0x0148, B:91:0x0151, B:93:0x0157, B:95:0x015b, B:96:0x0163, B:97:0x0168, B:103:0x0178, B:107:0x017f, B:109:0x0185, B:111:0x018b, B:113:0x0194, B:115:0x019e, B:117:0x01a4, B:119:0x01ad, B:121:0x01b3, B:123:0x01b7, B:124:0x01bf, B:132:0x01d9, B:125:0x01c2, B:127:0x01c8, B:129:0x01ce, B:58:0x00de, B:60:0x00e4, B:63:0x00f6, B:50:0x00c3, B:155:0x0234, B:157:0x023c, B:159:0x0240, B:160:0x0243, B:162:0x0247, B:164:0x024b, B:166:0x0251, B:167:0x0263, B:169:0x0267, B:171:0x026d, B:172:0x027f, B:173:0x0288, B:175:0x028c, B:177:0x0292, B:178:0x0295, B:180:0x029d, B:182:0x02a9, B:184:0x02b1), top: B:191:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x01c8 A[Catch: Exception -> 0x02e7, TryCatch #1 {Exception -> 0x02e7, blocks: (B:2:0x0000, B:4:0x0005, B:5:0x0007, B:7:0x000b, B:8:0x000d, B:10:0x0011, B:11:0x0014, B:13:0x001c, B:14:0x0021, B:16:0x0029, B:17:0x002e, B:19:0x0036, B:20:0x003b, B:22:0x0043, B:23:0x0048, B:25:0x004c, B:26:0x004f, B:31:0x0065, B:33:0x006d, B:35:0x007f, B:37:0x008f, B:40:0x0097, B:42:0x009f, B:44:0x00a7, B:46:0x00af, B:49:0x00c0, B:52:0x00cd, B:54:0x00d3, B:56:0x00d9, B:64:0x00f8, B:65:0x00fb, B:67:0x00ff, B:69:0x0105, B:71:0x010b, B:74:0x0117, B:79:0x0123, B:81:0x0129, B:83:0x012f, B:85:0x0138, B:87:0x0142, B:89:0x0148, B:91:0x0151, B:93:0x0157, B:95:0x015b, B:96:0x0163, B:97:0x0168, B:103:0x0178, B:107:0x017f, B:109:0x0185, B:111:0x018b, B:113:0x0194, B:115:0x019e, B:117:0x01a4, B:119:0x01ad, B:121:0x01b3, B:123:0x01b7, B:124:0x01bf, B:132:0x01d9, B:125:0x01c2, B:127:0x01c8, B:129:0x01ce, B:58:0x00de, B:60:0x00e4, B:63:0x00f6, B:50:0x00c3, B:155:0x0234, B:157:0x023c, B:159:0x0240, B:160:0x0243, B:162:0x0247, B:164:0x024b, B:166:0x0251, B:167:0x0263, B:169:0x0267, B:171:0x026d, B:172:0x027f, B:173:0x0288, B:175:0x028c, B:177:0x0292, B:178:0x0295, B:180:0x029d, B:182:0x02a9, B:184:0x02b1), top: B:191:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:152:0x0229 A[Catch: Exception -> 0x0230, TryCatch #0 {Exception -> 0x0230, blocks: (B:75:0x011c, B:100:0x0170, B:153:0x022d, B:99:0x016e, B:133:0x01dc, B:135:0x01e0, B:137:0x01e6, B:139:0x01f2, B:141:0x01fe, B:144:0x020b, B:145:0x020f, B:147:0x0215, B:149:0x021b, B:151:0x0225, B:152:0x0229), top: B:189:0x011c }] */
    /* JADX WARN: Code duplicated, block: B:200:0x0230 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x00ff A[Catch: Exception -> 0x02e7, TryCatch #1 {Exception -> 0x02e7, blocks: (B:2:0x0000, B:4:0x0005, B:5:0x0007, B:7:0x000b, B:8:0x000d, B:10:0x0011, B:11:0x0014, B:13:0x001c, B:14:0x0021, B:16:0x0029, B:17:0x002e, B:19:0x0036, B:20:0x003b, B:22:0x0043, B:23:0x0048, B:25:0x004c, B:26:0x004f, B:31:0x0065, B:33:0x006d, B:35:0x007f, B:37:0x008f, B:40:0x0097, B:42:0x009f, B:44:0x00a7, B:46:0x00af, B:49:0x00c0, B:52:0x00cd, B:54:0x00d3, B:56:0x00d9, B:64:0x00f8, B:65:0x00fb, B:67:0x00ff, B:69:0x0105, B:71:0x010b, B:74:0x0117, B:79:0x0123, B:81:0x0129, B:83:0x012f, B:85:0x0138, B:87:0x0142, B:89:0x0148, B:91:0x0151, B:93:0x0157, B:95:0x015b, B:96:0x0163, B:97:0x0168, B:103:0x0178, B:107:0x017f, B:109:0x0185, B:111:0x018b, B:113:0x0194, B:115:0x019e, B:117:0x01a4, B:119:0x01ad, B:121:0x01b3, B:123:0x01b7, B:124:0x01bf, B:132:0x01d9, B:125:0x01c2, B:127:0x01c8, B:129:0x01ce, B:58:0x00de, B:60:0x00e4, B:63:0x00f6, B:50:0x00c3, B:155:0x0234, B:157:0x023c, B:159:0x0240, B:160:0x0243, B:162:0x0247, B:164:0x024b, B:166:0x0251, B:167:0x0263, B:169:0x0267, B:171:0x026d, B:172:0x027f, B:173:0x0288, B:175:0x028c, B:177:0x0292, B:178:0x0295, B:180:0x029d, B:182:0x02a9, B:184:0x02b1), top: B:191:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x011f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:78:0x0121  */
    /* JADX WARN: Code duplicated, block: B:83:0x012f A[Catch: Exception -> 0x02e7, TryCatch #1 {Exception -> 0x02e7, blocks: (B:2:0x0000, B:4:0x0005, B:5:0x0007, B:7:0x000b, B:8:0x000d, B:10:0x0011, B:11:0x0014, B:13:0x001c, B:14:0x0021, B:16:0x0029, B:17:0x002e, B:19:0x0036, B:20:0x003b, B:22:0x0043, B:23:0x0048, B:25:0x004c, B:26:0x004f, B:31:0x0065, B:33:0x006d, B:35:0x007f, B:37:0x008f, B:40:0x0097, B:42:0x009f, B:44:0x00a7, B:46:0x00af, B:49:0x00c0, B:52:0x00cd, B:54:0x00d3, B:56:0x00d9, B:64:0x00f8, B:65:0x00fb, B:67:0x00ff, B:69:0x0105, B:71:0x010b, B:74:0x0117, B:79:0x0123, B:81:0x0129, B:83:0x012f, B:85:0x0138, B:87:0x0142, B:89:0x0148, B:91:0x0151, B:93:0x0157, B:95:0x015b, B:96:0x0163, B:97:0x0168, B:103:0x0178, B:107:0x017f, B:109:0x0185, B:111:0x018b, B:113:0x0194, B:115:0x019e, B:117:0x01a4, B:119:0x01ad, B:121:0x01b3, B:123:0x01b7, B:124:0x01bf, B:132:0x01d9, B:125:0x01c2, B:127:0x01c8, B:129:0x01ce, B:58:0x00de, B:60:0x00e4, B:63:0x00f6, B:50:0x00c3, B:155:0x0234, B:157:0x023c, B:159:0x0240, B:160:0x0243, B:162:0x0247, B:164:0x024b, B:166:0x0251, B:167:0x0263, B:169:0x0267, B:171:0x026d, B:172:0x027f, B:173:0x0288, B:175:0x028c, B:177:0x0292, B:178:0x0295, B:180:0x029d, B:182:0x02a9, B:184:0x02b1), top: B:191:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0138 A[Catch: Exception -> 0x02e7, TryCatch #1 {Exception -> 0x02e7, blocks: (B:2:0x0000, B:4:0x0005, B:5:0x0007, B:7:0x000b, B:8:0x000d, B:10:0x0011, B:11:0x0014, B:13:0x001c, B:14:0x0021, B:16:0x0029, B:17:0x002e, B:19:0x0036, B:20:0x003b, B:22:0x0043, B:23:0x0048, B:25:0x004c, B:26:0x004f, B:31:0x0065, B:33:0x006d, B:35:0x007f, B:37:0x008f, B:40:0x0097, B:42:0x009f, B:44:0x00a7, B:46:0x00af, B:49:0x00c0, B:52:0x00cd, B:54:0x00d3, B:56:0x00d9, B:64:0x00f8, B:65:0x00fb, B:67:0x00ff, B:69:0x0105, B:71:0x010b, B:74:0x0117, B:79:0x0123, B:81:0x0129, B:83:0x012f, B:85:0x0138, B:87:0x0142, B:89:0x0148, B:91:0x0151, B:93:0x0157, B:95:0x015b, B:96:0x0163, B:97:0x0168, B:103:0x0178, B:107:0x017f, B:109:0x0185, B:111:0x018b, B:113:0x0194, B:115:0x019e, B:117:0x01a4, B:119:0x01ad, B:121:0x01b3, B:123:0x01b7, B:124:0x01bf, B:132:0x01d9, B:125:0x01c2, B:127:0x01c8, B:129:0x01ce, B:58:0x00de, B:60:0x00e4, B:63:0x00f6, B:50:0x00c3, B:155:0x0234, B:157:0x023c, B:159:0x0240, B:160:0x0243, B:162:0x0247, B:164:0x024b, B:166:0x0251, B:167:0x0263, B:169:0x0267, B:171:0x026d, B:172:0x027f, B:173:0x0288, B:175:0x028c, B:177:0x0292, B:178:0x0295, B:180:0x029d, B:182:0x02a9, B:184:0x02b1), top: B:191:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0140  */
    /* JADX WARN: Code duplicated, block: B:96:0x0163 A[Catch: Exception -> 0x02e7, TryCatch #1 {Exception -> 0x02e7, blocks: (B:2:0x0000, B:4:0x0005, B:5:0x0007, B:7:0x000b, B:8:0x000d, B:10:0x0011, B:11:0x0014, B:13:0x001c, B:14:0x0021, B:16:0x0029, B:17:0x002e, B:19:0x0036, B:20:0x003b, B:22:0x0043, B:23:0x0048, B:25:0x004c, B:26:0x004f, B:31:0x0065, B:33:0x006d, B:35:0x007f, B:37:0x008f, B:40:0x0097, B:42:0x009f, B:44:0x00a7, B:46:0x00af, B:49:0x00c0, B:52:0x00cd, B:54:0x00d3, B:56:0x00d9, B:64:0x00f8, B:65:0x00fb, B:67:0x00ff, B:69:0x0105, B:71:0x010b, B:74:0x0117, B:79:0x0123, B:81:0x0129, B:83:0x012f, B:85:0x0138, B:87:0x0142, B:89:0x0148, B:91:0x0151, B:93:0x0157, B:95:0x015b, B:96:0x0163, B:97:0x0168, B:103:0x0178, B:107:0x017f, B:109:0x0185, B:111:0x018b, B:113:0x0194, B:115:0x019e, B:117:0x01a4, B:119:0x01ad, B:121:0x01b3, B:123:0x01b7, B:124:0x01bf, B:132:0x01d9, B:125:0x01c2, B:127:0x01c8, B:129:0x01ce, B:58:0x00de, B:60:0x00e4, B:63:0x00f6, B:50:0x00c3, B:155:0x0234, B:157:0x023c, B:159:0x0240, B:160:0x0243, B:162:0x0247, B:164:0x024b, B:166:0x0251, B:167:0x0263, B:169:0x0267, B:171:0x026d, B:172:0x027f, B:173:0x0288, B:175:0x028c, B:177:0x0292, B:178:0x0295, B:180:0x029d, B:182:0x02a9, B:184:0x02b1), top: B:191:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x016e A[Catch: Exception -> 0x0230, TRY_ENTER, TryCatch #0 {Exception -> 0x0230, blocks: (B:75:0x011c, B:100:0x0170, B:153:0x022d, B:99:0x016e, B:133:0x01dc, B:135:0x01e0, B:137:0x01e6, B:139:0x01f2, B:141:0x01fe, B:144:0x020b, B:145:0x020f, B:147:0x0215, B:149:0x021b, B:151:0x0225, B:152:0x0229), top: B:189:0x011c }] */
    private void a() {
        boolean zA;
        ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList;
        int i2;
        APOfferwallTabInfo aPOfferwallTabInfo;
        long j2;
        int i3;
        try {
            if (this.s != null) {
                this.s = null;
            }
            if (this.t != null) {
                this.t = null;
            }
            ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList2 = this.p;
            if (arrayList2 != null) {
                arrayList2.clear();
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
            HashMap<String, String> map = this.T;
            if (map != null) {
                map.clear();
            }
            boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.DISABLE_SPECIAL_OFFER);
            int i4 = this.B0;
            if (i4 == 2 || i4 == 3) {
                zB = true;
            }
            for (int i5 = 0; i5 < this.m.size(); i5++) {
                com.igaworks.adpopcorn.cores.model.g gVar = this.m.get(i5);
                if (a(gVar.c()) && !com.igaworks.adpopcorn.a.b.a().g(this.f1585b, gVar.c())) {
                    int i6 = this.G0;
                    if (i6 == 8) {
                        zA = true;
                        for (int i7 = 0; i7 < this.F0.getTabCount(); i7++) {
                            if (this.F0.getTabType(i7) != 8 && this.F0.getTabType(i7) != 0 && com.igaworks.adpopcorn.cores.common.k.a(this.F0.getTabType(i7), gVar.K())) {
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
                            if (com.igaworks.adpopcorn.a.b.a().f(this.f1585b, gVar.C())) {
                                zA = false;
                            } else {
                                arrayList = this.r;
                            }
                        }
                        i2 = this.A0;
                        if (i2 == 2) {
                            if (gVar.f0() && gVar.r() != null && gVar.r().length() > 0) {
                                if (zA) {
                                    this.n.add(gVar);
                                }
                                try {
                                    j2 = this.D0;
                                    this.D0 = j2 + gVar.Q();
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
                                    ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList3 = this.p;
                                    if (arrayList3 == null || arrayList3.size() > 1 || this.t != null) {
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
                                j2 = this.D0;
                                this.D0 = j2 + gVar.Q();
                            }
                        } else {
                            if (zA) {
                                i3 = this.B0;
                                if (i3 != 2 || i3 == 3) {
                                    if (gVar.f0() && gVar.r() != null && gVar.r().length() > 0) {
                                        this.n.add(gVar);
                                    }
                                } else if (!gVar.f0()) {
                                    if (gVar.W()) {
                                        this.t = gVar;
                                        this.n.add(0, gVar);
                                        if (!zB) {
                                            this.p.add(0, gVar);
                                            this.s = gVar;
                                        }
                                    } else if (zB || !gVar.x()) {
                                        this.n.add(gVar);
                                    } else {
                                        this.p.add(gVar);
                                        ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList4 = this.p;
                                        if (arrayList4 == null || arrayList4.size() > 1 || this.t != null) {
                                            this.n.add(gVar);
                                        } else {
                                            this.s = gVar;
                                            this.n.add(0, gVar);
                                        }
                                    }
                                }
                            }
                            aPOfferwallTabInfo = this.F0;
                            if (aPOfferwallTabInfo != null || aPOfferwallTabInfo.getTabCount() <= 1) {
                                j2 = this.D0;
                            } else if (!com.igaworks.adpopcorn.cores.common.k.a(9, gVar.K()) && !com.igaworks.adpopcorn.cores.common.k.a(10, gVar.K()) && !com.igaworks.adpopcorn.cores.common.k.a(11, gVar.K())) {
                                j2 = this.D0;
                            } else if (!gVar.f0() && gVar.r() != null && gVar.r().length() > 0) {
                                j2 = this.D0;
                            }
                            this.D0 = j2 + gVar.Q();
                        }
                    }
                    arrayList.add(gVar);
                    i2 = this.A0;
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
                            j2 = this.D0;
                            this.D0 = j2 + gVar.Q();
                        }
                    } else {
                        if (zA) {
                            i3 = this.B0;
                            if (i3 != 2) {
                                if (gVar.f0()) {
                                }
                            } else if (gVar.f0()) {
                            }
                        }
                        aPOfferwallTabInfo = this.F0;
                        if (aPOfferwallTabInfo != null) {
                            j2 = this.D0;
                            this.D0 = j2 + gVar.Q();
                        } else {
                            j2 = this.D0;
                            this.D0 = j2 + gVar.Q();
                        }
                    }
                }
            }
            if (a(this.f1585b, false)) {
                ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList5 = this.u;
                if (arrayList5 != null) {
                    arrayList5.clear();
                }
                if (this.s != null) {
                    ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList6 = this.n;
                    if (arrayList6 != null && arrayList6.size() > 0) {
                        this.u.add(this.n.get(0));
                        this.n.remove(0);
                    }
                    ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList7 = this.n;
                    if (arrayList7 != null && arrayList7.size() > 0) {
                        this.u.add(this.n.get(0));
                        this.n.remove(0);
                    }
                    this.e0.a(this.u, this.p0);
                }
            }
            if (this.p != null) {
                this.v = 0;
                ViewFlipper viewFlipper = this.g0;
                if (viewFlipper != null) {
                    viewFlipper.removeAllViews();
                }
                int iC = !a(this.f1585b, false) ? com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.SPECIAL_OFFER_TOP_ROUND_DP) : 0;
                for (int i8 = 0; i8 < this.p.size(); i8++) {
                    Context context = this.f1585b;
                    com.igaworks.adpopcorn.activity.c.i iVar = new com.igaworks.adpopcorn.activity.c.i(context, com.igaworks.adpopcorn.cores.common.d.a(context, iC));
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    iVar.setScaleType(ImageView.ScaleType.FIT_XY);
                    iVar.setLayoutParams(layoutParams);
                    this.g0.addView(iVar);
                    com.igaworks.adpopcorn.cores.common.e.a(this.f1585b, this.p.get(i8).T(), iVar, 0, 0, (com.igaworks.adpopcorn.cores.common.e.b) null);
                }
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        FrameLayout.LayoutParams layoutParams;
        try {
            if (this.H0 == i2) {
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, 1));
            layoutParams2.gravity = 83;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, 0.0f));
            layoutParams3.gravity = 83;
            for (int i3 = 0; i3 < this.F0.getTabCount(); i3++) {
                TextView textView = this.x0.get(i3);
                ImageView imageView = this.z0.get(i3);
                if (i2 == i3) {
                    textView.setTextColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_SELECT_TEXT_COLOR));
                    imageView.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_SELECT_LINE_COLOR));
                    layoutParams = layoutParams2;
                } else {
                    textView.setTextColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_UNSELECT_TEXT_COLOR));
                    imageView.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_UNSELECT_LINE_COLOR));
                    layoutParams = layoutParams3;
                }
                imageView.setLayoutParams(layoutParams);
            }
            int tabType = this.F0.getTabType(i2);
            this.G0 = tabType;
            this.B0 = 0;
            if (tabType == 11 || tabType == 10) {
                this.B0 = 2;
            }
            com.igaworks.adpopcorn.activity.a.b.a aVar = this.j;
            if (aVar != null) {
                aVar.a(this.B0);
            }
            c(false);
            this.H0 = i2;
            com.igaworks.adpopcorn.a.d dVar = this.w;
            if (dVar != null) {
                dVar.b("media_offerwall_tab_visit", this.G0 + "");
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
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1585b, "ApLottemMemOfferWallLayout", "callbackCheckCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    int i4 = jSONObject.getInt("ResultCode");
                    boolean z2 = jSONObject.getBoolean("Result");
                    this.i0 = this.P.d0();
                    if (!z2) {
                        h();
                        if (i4 != 2000) {
                            com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
                            a(gVar3.p, gVar3.x, true);
                            return;
                        }
                        int i5 = this.H;
                        if (i5 != 25 || i5 != 24) {
                            com.igaworks.adpopcorn.a.b.a().b(this.f1585b, this.P.c());
                        }
                        com.igaworks.adpopcorn.cores.common.g gVar4 = this.d;
                        a(gVar4.Y, gVar4.i, true);
                        c(false);
                        return;
                    }
                    this.L = jSONObject.getString("Auth");
                    this.G = jSONObject.getInt("Status");
                    int iK = this.P.K();
                    this.H = iK;
                    if (i2 != 2) {
                        if (iK == 1 || iK == 2) {
                            h();
                            int i6 = this.G;
                            if (i6 != 0 && i6 != 50 && i6 != 125) {
                                d(PointerIconCompat.TYPE_WAIT);
                                return;
                            }
                        } else if (iK == 6 || iK == 7 || iK == 23) {
                            aVar = this.U;
                            gVar = this.P;
                        }
                        v();
                        return;
                    }
                    if (iK != 6 && iK != 7 && iK != 23) {
                        this.w.b("media_offerwall_tab_content_engagement", this.J);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("auth", this.L);
                            jSONObject2.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1585b));
                            jSONObject2.put("channel_code", this.t0);
                            this.U.a(1, this.y, jSONObject2, this);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    aVar = this.U;
                    i3 = 4;
                    gVar = this.P;
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
        if (this.b0 == 1) {
            com.igaworks.adpopcorn.a.b.a().a(this.f1585b);
        }
        new Handler(Looper.getMainLooper()).post(new y(fVar));
    }

    private void a(String str, String str2, double d2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, boolean z2, String str11, int i3, String str12, String str13, String str14) {
        try {
            this.f1585b.startActivity(new Intent(this.f1585b, (Class<?>) ApVideoAdActivity.class).putExtra("cKey", str).putExtra("joinAuth", str2).putExtra("averageRating", d2).putExtra("landscapeImageURL", str3).putExtra("clickAction", str4).putExtra("campaignDescription", str5).putExtra("iconImageURL", str6).putExtra("campaignName", str7).putExtra("numberOfDownloads", str8).putExtra("redirectURL", str9).putExtra("videoURL", str10).putExtra("ADType", i2).putExtra("AutoRedirect", z2).putExtra("fromVideoAPI", false).putExtra("rewardName", str11).putExtra("skipAllowSeconds", i3).putExtra("videoImpressionURL", str12).putExtra("moreClickReportURL", str13).putExtra("PartiTypeCode", this.H).putExtra("campaignCondition", str14));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, boolean z2) {
        h();
        d();
        String str3 = this.d.h;
        try {
            Context context = this.f1585b;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.l0, str, str2, -1, str3, new n(), a(context, false), false);
            this.j0 = aVar;
            aVar.setCancelable(false);
            this.j0.setCanceledOnTouchOutside(false);
            this.j0.show();
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
                h();
                return;
            }
        }
        if (this.U == null) {
            this.U = new com.igaworks.adpopcorn.a.g.a(this.f1585b);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("auth", this.L);
        jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1585b));
        this.U.a(11, this.A, jSONObject, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2, String str) {
        String installerPackageName;
        com.igaworks.adpopcorn.a.g.a aVar;
        int i2;
        String str2;
        String str3 = this.L;
        String str4 = this.J;
        try {
            installerPackageName = this.f1585b.getPackageManager().getInstallerPackageName(str);
        } catch (Exception unused) {
            installerPackageName = null;
        }
        try {
            com.igaworks.adpopcorn.cores.common.h.a(this.f1585b, "ApLottemMemOfferWallLayout", "sendCompleteRewardRequest installer = " + installerPackageName, 3);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", this.L);
            jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1585b));
            jSONObject.put("sign", com.igaworks.adpopcorn.cores.common.c.a(str4, str3));
            jSONObject.put(TapjoyConstants.TJC_INSTALLER, installerPackageName);
            if (z2) {
                aVar = this.U;
                i2 = 5;
                str2 = this.z;
            } else {
                aVar = this.U;
                i2 = 19;
                str2 = this.B;
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
        HashMap<String, String> map = this.T;
        if (map != null && map.containsKey(str)) {
            return false;
        }
        List<String> list = this.I0;
        if (list != null && list.contains(str)) {
            return false;
        }
        HashMap<String, String> map2 = this.T;
        if (map2 != null) {
            map2.put(str, str);
        }
        return true;
    }

    private com.igaworks.adpopcorn.activity.layout.b b(int i2) {
        com.igaworks.adpopcorn.activity.layout.b bVar = new com.igaworks.adpopcorn.activity.layout.b(this.c, i2);
        this.d0 = (LinearLayout) bVar.findViewById(0);
        TextView textView = (TextView) bVar.findViewById(1);
        this.d0.setVisibility(8);
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
                this.g0.showNext();
                x();
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
                        int i3 = this.H;
                        if (i3 == 6) {
                            h();
                            int i4 = this.G;
                            if (i4 != 0) {
                                if (i4 == 50 || i4 == 125) {
                                    if (i2 == 4) {
                                        this.w.b("media_offerwall_tab_content_engagement", this.J);
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("auth", this.L);
                                        jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1585b));
                                        jSONObject.put("channel_code", this.t0);
                                        this.U.a(1, this.y, jSONObject, this);
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
                            int i5 = this.G;
                            if (i5 != 0) {
                                if (i5 == 50) {
                                    if (i3 != 23) {
                                        a(true, this.P.J());
                                        return;
                                    } else {
                                        h();
                                        d(PointerIconCompat.TYPE_ALL_SCROLL);
                                        return;
                                    }
                                }
                                if (i5 == 125) {
                                    this.I = true;
                                    this.w.b("media_offerwall_tab_content_engagement", this.J);
                                    try {
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("auth", this.L);
                                        jSONObject2.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1585b));
                                        jSONObject2.put("channel_code", this.t0);
                                        this.U.a(1, this.y, jSONObject2, this);
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
                this.w.b("media_offerwall_tab_content_engagement", this.J);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("auth", this.L);
                jSONObject3.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1585b));
                jSONObject3.put("channel_code", this.t0);
                this.U.a(1, this.y, jSONObject3, this);
                return;
            }
            h();
            int i6 = this.H;
            if (i6 == 6) {
                int i7 = this.G;
                if (i7 != 0 && i7 != 50 && i7 != 125) {
                    return;
                }
            } else {
                if (i6 != 7 && i6 != 23) {
                    return;
                }
                int i8 = this.G;
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
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1585b, "ApLottemMemOfferWallLayout", "callbackJoinCPMCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    String string = jSONObject.getString("CPMParticipatedTid");
                    if (!z2) {
                        com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
                        a(gVar3.p, gVar3.e, false);
                        return;
                    }
                    if (this.P.l() == 16) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(ScarConstants.TOKEN_ID_KEY, string);
                        String string2 = jSONObject2.toString();
                        try {
                            string2 = URLEncoder.encode(jSONObject2.toString(), "utf-8");
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        strF = this.P.f() + "&custom=" + string2;
                    } else {
                        if (this.P.l() == 40) {
                            if (this.P.Y()) {
                                com.igaworks.adpopcorn.cores.common.h.a(this.f1585b, "ApLottemMemOfferWallLayout", "callbackJoinCPMCampaign already completed", 3);
                            } else {
                                b(jSONObject.getString("Auth"));
                                this.P.c(true);
                            }
                            gVar = this.P;
                        } else {
                            gVar = this.P;
                        }
                        strF = gVar.f();
                    }
                    d(strF);
                    try {
                        Iterator<String> it = this.P.e().iterator();
                        while (it.hasNext()) {
                            this.U.a(14, it.next(), "", new v(this));
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
            String strD = this.P.d();
            if (this.P == null) {
                com.igaworks.adpopcorn.cores.common.h.a(this.f1585b, "ApLottemMemOfferWallLayout", "completeCampaign failed", 3);
                return;
            }
            com.igaworks.adpopcorn.cores.common.h.a(this.f1585b, "ApLottemMemOfferWallLayout", "completeCampaign success", 3);
            if (this.U == null) {
                this.U = new com.igaworks.adpopcorn.a.g.a(this.f1585b);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", str);
            jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1585b));
            jSONObject.put("sign", com.igaworks.adpopcorn.cores.common.c.a(strD, str));
            if (com.igaworks.adpopcorn.a.d.E) {
                aVar = this.U;
                str2 = "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/CompleteCPMClick";
            } else {
                aVar = this.U;
                str2 = "https://apapi.adpopcorn.com/ap/v1/common/conversion/CompleteCPMClick";
            }
            aVar.a(28, str2, jSONObject, this);
        } catch (Exception e2) {
            com.igaworks.adpopcorn.cores.common.h.a(this.f1585b, "ApLottemMemOfferWallLayout", "completeCampaign failed : " + e2.getMessage(), 3);
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            a(gVar.Y, gVar.e, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, boolean z2) {
        try {
            h();
            d();
            String str3 = this.d.I;
            Context context = this.f1585b;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.l0, str3, str, 1, str2, new c(z2), a(context, false), false);
            this.j0 = aVar;
            aVar.setCancelable(false);
            this.j0.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, boolean z2) {
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
    public void b(boolean z2) {
        LinearLayout linearLayout;
        int i2;
        if (z2) {
            linearLayout = this.d0;
            i2 = 8;
        } else {
            linearLayout = this.d0;
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
    }

    private LinearLayout c(int i2) {
        FrameLayout.LayoutParams layoutParams;
        com.igaworks.adpopcorn.style.a aVarB;
        String str;
        this.v0 = new LinearLayout(this.c);
        LinearLayout linearLayout = new LinearLayout(this.c);
        try {
            int tabCount = this.F0.getTabCount();
            int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_HEIGHT);
            int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_BAR_HEIGHT);
            int iC3 = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.ENABLE_TOP_BAR_EXPAND_MENU) ? com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_HEIGHT) : 0;
            if (this.m0) {
                iC = 0;
                iC3 = 0;
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, iC2));
            layoutParams2.gravity = 49;
            layoutParams2.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.c, iC + iC3 + i2);
            this.v0.setOrientation(0);
            this.v0.setGravity(3);
            this.v0.setLayoutParams(layoutParams2);
            this.v0.setBackgroundColor(Color.parseColor("#ffffff"));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, iC2));
            linearLayout.setOrientation(0);
            linearLayout.setGravity(3);
            linearLayout.setLayoutParams(layoutParams3);
            linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            List<TextView> list = this.w0;
            if (list == null) {
                this.w0 = new ArrayList();
            } else {
                list.clear();
            }
            List<TextView> list2 = this.x0;
            if (list2 == null) {
                this.x0 = new ArrayList();
            } else {
                list2.clear();
            }
            List<ImageView> list3 = this.y0;
            if (list3 == null) {
                this.y0 = new ArrayList();
            } else {
                list3.clear();
            }
            List<ImageView> list4 = this.z0;
            if (list4 == null) {
                this.z0 = new ArrayList();
            } else {
                list4.clear();
            }
            for (int i3 = 0; i3 < tabCount; i3++) {
                FrameLayout frameLayout = new FrameLayout(this.c);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.c, iC2));
                layoutParams4.gravity = 3;
                if (i3 == 0) {
                    layoutParams4.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.c, 16);
                }
                layoutParams4.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.c, 20);
                frameLayout.setLayoutParams(layoutParams4);
                frameLayout.setTag(Integer.valueOf(i3));
                frameLayout.setOnClickListener(new ViewOnClickListenerC0427b());
                TextView textView = new TextView(this.c);
                textView.setLayoutParams(new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, 50)));
                textView.setGravity(17);
                textView.setTextColor(Color.parseColor("#222222"));
                textView.setTextSize(1, 14.0f);
                textView.setText(this.F0.getTabTitle(i3));
                textView.setTag(Integer.valueOf(i3));
                frameLayout.addView(textView);
                ImageView imageView = new ImageView(this.c);
                imageView.setTag(Integer.valueOf(i3));
                if (i3 == 0) {
                    layoutParams = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, 1));
                    textView.setTextColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_SELECT_TEXT_COLOR));
                    aVarB = com.igaworks.adpopcorn.style.a.b();
                    str = ApStyleManager.CustomStyle.OFFERWALL_TAB_SELECT_LINE_COLOR;
                } else {
                    layoutParams = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, 0.0f));
                    textView.setTextColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_UNSELECT_TEXT_COLOR));
                    aVarB = com.igaworks.adpopcorn.style.a.b();
                    str = ApStyleManager.CustomStyle.OFFERWALL_TAB_UNSELECT_LINE_COLOR;
                }
                imageView.setBackgroundColor(aVarB.c(str));
                layoutParams.gravity = 83;
                imageView.setLayoutParams(layoutParams);
                frameLayout.addView(imageView);
                this.v0.addView(frameLayout);
                this.x0.add(textView);
                this.z0.add(imageView);
            }
        } catch (Exception unused) {
        }
        this.f.addView(this.v0);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            ArrayList<String> arrayList = this.r0;
            if (arrayList == null || arrayList.contains(this.s.c()) || !com.igaworks.adpopcorn.cores.common.k.a(this.g0)) {
                return;
            }
            this.r0.add(this.s.c());
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
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1585b, "ApLottemMemOfferWallLayout", "callbackJoinCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    String string = jSONObject.getString("ResultMsg");
                    int i2 = jSONObject.getInt("ResultCode");
                    if (!jSONObject.has("RedirectURL") || jSONObject.isNull("RedirectURL")) {
                        this.M = "";
                    } else {
                        this.M = jSONObject.getString("RedirectURL");
                    }
                    if (!jSONObject.has("HideBrowser") || jSONObject.isNull("HideBrowser")) {
                        this.O = false;
                    } else {
                        this.O = jSONObject.getBoolean("HideBrowser");
                    }
                    if (jSONObject.has("ParticipatedTid") && !jSONObject.isNull("ParticipatedTid")) {
                        this.N = jSONObject.getLong("ParticipatedTid") + "";
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
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1585b, "ApLottemMemOfferWallLayout", "callbackJoinCampaign success, useHiddenBrowser = " + this.O + ", redirectURL = " + this.M, 3);
                    this.L = jSONObject.getString("Auth");
                    if (this.I) {
                        a(true, this.P.J());
                        this.I = false;
                        return;
                    }
                    int i3 = this.H;
                    if (i3 == 10) {
                        h();
                        c(this.M);
                        return;
                    }
                    if (i3 != 16 && i3 != 26 && i3 != 27) {
                        if (i3 == 25) {
                            h();
                            try {
                                if (c(this.P.J())) {
                                    a(false, this.P.J());
                                } else {
                                    d();
                                    com.igaworks.adpopcorn.a.b.a().b(this.c, "participateFlag", this.J, true);
                                    com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
                                    String str3 = gVar3.I;
                                    String str4 = gVar3.u0;
                                    String str5 = gVar3.z;
                                    String str6 = gVar3.y;
                                    Context context = this.f1585b;
                                    com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.l0, str3, str4, -1, str5, new s(), str6, new t(), a(context, false));
                                    this.j0 = aVar;
                                    aVar.setCancelable(false);
                                    this.j0.show();
                                }
                                return;
                            } catch (Exception unused) {
                                return;
                            }
                        }
                        h();
                        if (this.P.X()) {
                            this.P.c(true);
                            try {
                                Iterator<String> it = this.P.e().iterator();
                                while (it.hasNext()) {
                                    this.U.a(14, it.next(), "", new u(this));
                                }
                            } catch (Exception unused2) {
                            }
                        }
                        if (this.P.h0()) {
                            this.M = this.P.M();
                        }
                        if (com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.PASS_PARTICIPATE_EVENT)) {
                            this.w.a(this.M, this.J, this.N, (String) null);
                            return;
                        }
                        if (this.O) {
                            e(this.M);
                            return;
                        }
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(this.M));
                        try {
                            this.f1585b.startActivity(intent);
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
    public void c(boolean z2) {
        com.igaworks.adpopcorn.activity.c.e eVar;
        LinearLayout linearLayout;
        try {
            this.D0 = 0L;
            h();
            List<com.igaworks.adpopcorn.cores.model.g> list = this.m;
            if (list != null && (list == null || list.size() != 0)) {
                b("", false);
                com.igaworks.adpopcorn.a.c cVar = this.e;
                if (cVar != null && cVar.d()) {
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1585b, "ApLottemMemOfferWallLayout", "sign1 : true", 3);
                    com.igaworks.adpopcorn.cores.common.j.f(this.f1585b);
                }
                a();
                int i2 = this.A0;
                if (!(i2 == 3 && this.G0 == 0) && (i2 == 3 || this.G0 != 8)) {
                    ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList = this.n;
                    if (arrayList == null || arrayList.size() == 0) {
                        b(this.d.f, true);
                    }
                } else {
                    ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList2 = this.n;
                    if (arrayList2 == null || arrayList2.size() == 0) {
                        if (!a(this.f1585b, false)) {
                            f(false);
                            b(this.d.f, true);
                            return;
                        }
                        ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList3 = this.u;
                        if (arrayList3 == null || arrayList3.size() == 0) {
                            f(false);
                            b(this.d.f, true);
                            return;
                        }
                    }
                }
                if (this.A0 != 2) {
                    x();
                    if (this.s == null || (linearLayout = this.f0) == null) {
                        LinearLayout linearLayout2 = this.f0;
                        if (linearLayout2 != null) {
                            linearLayout2.setVisibility(8);
                        }
                    } else {
                        linearLayout.setVisibility(0);
                    }
                }
                if (a(this.f1585b, false)) {
                    if (this.b0 == 1) {
                        eVar = this.l;
                        eVar.setAdapter((ListAdapter) this.j);
                    }
                } else if (this.b0 == 1) {
                    eVar = this.k;
                    eVar.setAdapter((ListAdapter) this.j);
                }
                com.igaworks.adpopcorn.activity.a.b.a aVar = this.j;
                if (aVar != null) {
                    aVar.notifyDataSetChanged();
                    return;
                }
                return;
            }
            f(z2);
            b(this.d.f, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
        try {
            Intent launchIntentForPackage = this.f1585b.getPackageManager().getLaunchIntentForPackage(str);
            launchIntentForPackage.setFlags(268435456);
            this.f1585b.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Dialog dialog = this.j0;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.j0.dismiss();
        this.j0 = null;
    }

    private void d(int i2) {
        String str;
        try {
            d();
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
                    Context context = this.f1585b;
                    com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.l0, str2, str, -1, str3, new f(i2), a(context, false), false);
                    this.j0 = aVar;
                    aVar.setCancelable(false);
                    this.j0.show();
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
                    String str4 = gVar.z;
                    String str5 = gVar.H;
                    Context context2 = this.f1585b;
                    com.igaworks.adpopcorn.activity.b.d.a aVar2 = new com.igaworks.adpopcorn.activity.b.d.a(context2, this.l0, str2, str, -1, str4, new g(), str5, new h(), a(context2, false));
                    this.j0 = aVar2;
                    aVar2.setCancelable(false);
                    this.j0.show();
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
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1585b, "ApLottemMemOfferWallLayout", "callbackJoinNewsCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    jSONObject.getString("NewsParticipatedTid");
                    this.L = jSONObject.getString("Auth");
                    if (z2) {
                        com.igaworks.adpopcorn.activity.b.g gVar2 = new com.igaworks.adpopcorn.activity.b.g(this.f1585b, this.l0, this.P, this.d, new w());
                        this.S = gVar2;
                        gVar2.show();
                        this.S.setOnDismissListener(new x());
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
            com.igaworks.adpopcorn.cores.common.h.a(this.f1585b, "ApLottemMemOfferWallLayout", "openWebBrowser = " + str, 3);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            this.f1585b.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.igaworks.adpopcorn.a.g.a aVar;
        String str;
        try {
            String str2 = this.L;
            com.igaworks.adpopcorn.cores.model.g gVar = this.P;
            if (gVar == null) {
                com.igaworks.adpopcorn.cores.common.h.a(this.f1585b, "ApLottemMemOfferWallLayout", "completeNewsCampaign failed", 3);
                return;
            }
            String strY = gVar.y();
            com.igaworks.adpopcorn.cores.common.h.a(this.f1585b, "ApLottemMemOfferWallLayout", "completeNewsCampaign : " + strY, 3);
            if (this.U == null) {
                this.U = new com.igaworks.adpopcorn.a.g.a(this.f1585b);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", this.L);
            jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1585b));
            jSONObject.put("sign", com.igaworks.adpopcorn.cores.common.c.a(strY, str2));
            if (com.igaworks.adpopcorn.a.d.E) {
                aVar = this.U;
                str = "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/CompleteNewsCampaign";
            } else {
                aVar = this.U;
                str = "https://apapi.adpopcorn.com/ap/v1/common/conversion/CompleteNewsCampaign";
            }
            aVar.a(30, str, jSONObject, this);
        } catch (Exception e2) {
            e2.printStackTrace();
            com.igaworks.adpopcorn.cores.common.h.a(this.f1585b, "ApLottemMemOfferWallLayout", "completeNewsCampaign failed : " + e2.getMessage(), 3);
        }
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
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1585b, "ApLottemMemOfferWallLayout", "callbackRewardAppExecute result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    int i2 = jSONObject.getInt("ResultCode");
                    String string = jSONObject.getString("ResultMsg");
                    if (z2) {
                        d(PointerIconCompat.TYPE_WAIT);
                        c(false);
                        com.igaworks.adpopcorn.a.d dVar = this.w;
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
                        com.igaworks.adpopcorn.a.b.a().b(this.c, "participateFlag", this.J, false);
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
            if (this.q0 == null) {
                WebView webView = new WebView(this.c);
                this.q0 = webView;
                webView.getSettings().setJavaScriptEnabled(true);
                this.q0.setWebChromeClient(new WebChromeClient());
                addView(this.q0);
                this.q0.setVisibility(4);
                this.q0.setWebViewClient(new z());
            }
            com.igaworks.adpopcorn.cores.common.h.a(this.f1585b, "ApLottemMemOfferWallLayout", "openWebViewBrowser = " + str, 3);
            this.q0.loadUrl(str);
        } catch (Exception unused) {
        }
    }

    private void e(boolean z2) {
        try {
            h();
            d();
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            String str = gVar.I;
            String str2 = gVar.h;
            String str3 = gVar.v;
            String str4 = z2 ? gVar.U : gVar.e;
            Context context = this.f1585b;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.l0, str, str4, -1, str2, new o(), str3, new p(), a(context, false));
            this.j0 = aVar;
            aVar.setCancelable(false);
            this.j0.setCanceledOnTouchOutside(false);
            this.j0.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void f() {
        if (this.E == null) {
            this.E = new Handler(Looper.getMainLooper());
        }
        if (this.F == null) {
            this.F = new g0();
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
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1585b, "ApLottemMemOfferWallLayout", "callbackRewardAppInstall result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    int i2 = jSONObject.getInt("ResultCode");
                    String string = jSONObject.getString("ResultMsg");
                    if (z2) {
                        if (this.H != 23) {
                            d(PointerIconCompat.TYPE_WAIT);
                            com.igaworks.adpopcorn.a.b.a().b(this.f1585b, this.P.c());
                            c(false);
                            com.igaworks.adpopcorn.a.d dVar = this.w;
                            if (dVar != null) {
                                dVar.c(false);
                                return;
                            }
                            return;
                        }
                        bVarA = com.igaworks.adpopcorn.a.b.a();
                        context = this.f1585b;
                        gVar = this.P;
                    } else {
                        if (this.H != 23) {
                            if (i2 == 2000) {
                                d(1005);
                                com.igaworks.adpopcorn.a.b.a().b(this.f1585b, this.P.c());
                            } else {
                                if (i2 != 2050) {
                                    a(this.d.q, string, true);
                                    return;
                                }
                                com.igaworks.adpopcorn.a.b.a().b(this.c, "participateFlag", this.J, false);
                            }
                            c(false);
                            return;
                        }
                        if (i2 != 2000) {
                            if (i2 == 2050) {
                                com.igaworks.adpopcorn.a.b.a().b(this.c, "participateFlag", this.J, false);
                                return;
                            }
                            return;
                        } else {
                            bVarA = com.igaworks.adpopcorn.a.b.a();
                            context = this.f1585b;
                            gVar = this.P;
                        }
                    }
                    bVarA.b(context, gVar.c());
                    return;
                } catch (JSONException e2) {
                    if (this.H != 23) {
                        com.igaworks.adpopcorn.cores.common.g gVar2 = this.d;
                        a(gVar2.I, gVar2.p, true);
                    }
                    e2.printStackTrace();
                    return;
                }
            }
            if (this.H == 23) {
                return;
            }
            com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
            str = gVar3.I;
            str2 = gVar3.g;
        } else {
            if (this.H == 23) {
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
            d();
            String str = this.d.I;
            String str2 = this.d.f + "\n" + this.d.d0;
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            String str3 = gVar.h;
            String str4 = gVar.G;
            String str5 = z2 ? this.d.n0 + "\n" + this.d.d0 : str2;
            Context context = this.f1585b;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.l0, str, str5, -1, str3, new d(), str4, new e(), a(context, false));
            this.j0 = aVar;
            aVar.setCancelable(false);
            this.j0.show();
        } catch (Exception unused) {
        }
    }

    private void g(com.igaworks.adpopcorn.cores.model.f fVar) {
        com.igaworks.adpopcorn.cores.model.j jVarA;
        if (fVar != null && fVar.d()) {
            e(true);
        } else if (fVar != null && fVar.a().length() > 0) {
            try {
                com.igaworks.adpopcorn.cores.common.h.a(this.f1585b, "ApLottemMemOfferWallLayout", "callbackVideoAdDetailInfoRequest result = " + fVar.a(), 3);
                if (new JSONObject(fVar.a()).getBoolean("Result") && (jVarA = com.igaworks.adpopcorn.a.f.f.a(fVar.a())) != null) {
                    a(this.P.c(), this.L, jVarA.c(), jVarA.h(), jVarA.e(), jVarA.f(), jVarA.g(), jVarA.j(), jVarA.k(), jVarA.l(), jVarA.r(), jVarA.a(), jVarA.s(), this.P.P(), jVarA.o(), jVarA.q(), jVarA.i(), this.P.N());
                    return;
                }
            } catch (JSONException unused) {
            }
        }
        e(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        try {
            com.igaworks.adpopcorn.activity.b.d.c cVar = this.k0;
            if (cVar != null) {
                cVar.dismiss();
                this.k0 = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Activity activity;
        try {
            if (this.m0 || (activity = this.o0) == null) {
                return;
            }
            activity.finish();
            this.o0.overridePendingTransition(0, 0);
            com.igaworks.adpopcorn.a.d dVar = this.w;
            if (dVar != null) {
                dVar.c((String) null);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        String str;
        if (com.igaworks.adpopcorn.a.d.E) {
            this.x = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/checkcampaign";
            this.y = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/joincampaign";
            this.z = "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/completeinstallcampaign";
            this.A = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/video/getrewardvideodetail";
            this.B = "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/completeexecutecampaign";
            this.C = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/joincpmcampaign";
            str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/joinnewscampaign";
        } else {
            this.x = "https://apapi.adpopcorn.com/ap/v1/sdk/media/checkcampaign";
            this.y = "https://apapi.adpopcorn.com/ap/v1/sdk/media/joincampaign";
            this.z = "https://apapi.adpopcorn.com/ap/v1/common/conversion/completeinstallcampaign";
            this.A = "https://apapi.adpopcorn.com/ap/v1/sdk/video/getrewardvideodetail";
            this.B = "https://apapi.adpopcorn.com/ap/v1/common/conversion/completeexecutecampaign";
            this.C = "https://apapi.adpopcorn.com/ap/v1/sdk/media/joincpmcampaign";
            str = "https://apapi.adpopcorn.com/ap/v1/sdk/media/joinnewscampaign";
        }
        this.D = str;
    }

    private void l() {
        this.V = false;
        this.W = false;
        this.b0 = 1;
        com.igaworks.adpopcorn.a.b.a().a(this.f1585b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_quantity", 0L);
        int i2 = Calendar.getInstance().get(6);
        if (com.igaworks.adpopcorn.a.b.a().a(this.f1585b, "adpopcorn_news_sp", "adpopcorn_news_imp_day", 0) != i2) {
            com.igaworks.adpopcorn.a.b.a().b(this.f1585b);
        }
        com.igaworks.adpopcorn.a.b.a().b(this.f1585b, "adpopcorn_news_sp", "adpopcorn_news_imp_day", i2);
        if (this.W || this.b0 > this.c0) {
            b(true);
            return;
        }
        com.igaworks.adpopcorn.cores.common.h.a(this.f1585b, "ApLottemMemOfferWallLayout", "initCampaignLoading", 3);
        if (!com.igaworks.adpopcorn.cores.common.c.c(this.f1585b)) {
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            b(gVar.g, gVar.h, true);
        } else {
            a(this.d.f1613b, false);
            if (this.e.i()) {
                return;
            }
            this.U.a(this.b0, this);
        }
    }

    private void m() {
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.BOTTOM_BAR_HEIGHT);
        if (this.A0 == 1) {
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
        this.g.setPadding(0, 0, 0, com.igaworks.adpopcorn.cores.common.d.a(this.f1585b, iC));
        this.f.addView(this.g);
        this.f.addView(b(iC));
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_LR_PADDING);
        if (!this.m0) {
            this.g.addView(o());
        }
        int iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_FOOTER_MARGIN_DP);
        LinearLayout linearLayout = new LinearLayout(this.c);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.f1585b, iC3)));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        if (a(this.f1585b, false)) {
            com.igaworks.adpopcorn.activity.c.e eVar = new com.igaworks.adpopcorn.activity.c.e(this.c);
            this.l = eVar;
            eVar.setLayoutParams(layoutParams2);
            this.l.setSelector(new StateListDrawable());
            this.l.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.f1585b, 8), com.igaworks.adpopcorn.cores.common.d.a(this.f1585b, 8), com.igaworks.adpopcorn.cores.common.d.a(this.f1585b, 8), 0);
            this.l.setNumColumns(2);
            this.l.setHorizontalSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.f1585b, 8));
            this.l.setVerticalSpacing(0);
            this.l.b(p());
            this.l.a(linearLayout);
            this.g.addView(this.l);
            this.j = new com.igaworks.adpopcorn.activity.a.b.a(this.c, this.n, this.d, true, this.A0, this.B0, this.p0);
            this.l.setOnItemClickListener(this.K0);
            this.l.setOnScrollListener(this.L0);
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
            this.j = new com.igaworks.adpopcorn.activity.a.b.a(this.c, this.n, this.d, false, this.A0, this.B0, this.p0);
            this.k.setSelector(new StateListDrawable());
            this.k.setOnItemClickListener(this.K0);
            this.k.setOnScrollListener(this.L0);
            this.k.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.f1585b, iC2), 0, com.igaworks.adpopcorn.cores.common.d.a(this.f1585b, iC2), 0);
        }
        addView(this.f);
    }

    private void n() {
        com.igaworks.adpopcorn.a.d dVarA = com.igaworks.adpopcorn.a.d.a(this.f1585b);
        this.w = dVarA;
        this.e = dVarA.e();
        com.igaworks.adpopcorn.cores.common.e.b(this.f1585b);
        if (!this.p0) {
            com.igaworks.adpopcorn.cores.common.d.a();
        }
        com.igaworks.adpopcorn.cores.common.d.a((Activity) this.f1585b);
        com.igaworks.adpopcorn.cores.common.g gVarA = com.igaworks.adpopcorn.cores.common.g.a();
        this.d = gVarA;
        gVarA.d();
        this.b0 = 1;
        this.W = false;
        this.i0 = false;
        this.a0 = false;
        this.t0 = 1;
        this.n = new ArrayList<>();
        this.o = new ArrayList<>();
        this.p = new ArrayList<>();
        this.q = new ArrayList<>();
        this.r = new ArrayList<>();
        this.s = new com.igaworks.adpopcorn.cores.model.g();
        this.u = new ArrayList<>();
        this.r0 = new ArrayList<>();
        this.s0 = new ArrayList<>();
        this.a = ((WindowManager) this.f1585b.getSystemService("window")).getDefaultDisplay().getWidth();
        if (this.A0 == 1) {
            setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.f1585b, 9), com.igaworks.adpopcorn.cores.common.d.a(this.f1585b, 15), com.igaworks.adpopcorn.cores.common.d.a(this.f1585b, 9), com.igaworks.adpopcorn.cores.common.d.a(this.f1585b, 15));
            this.a -= com.igaworks.adpopcorn.cores.common.d.a(this.f1585b, 18);
        }
        if (this.U == null) {
            this.U = new com.igaworks.adpopcorn.a.g.a(this.f1585b);
        }
        this.l0 = com.igaworks.adpopcorn.activity.b.d.a(this.f1585b);
        com.igaworks.adpopcorn.a.b.a().b(this.f1585b, "adpopcorn_sdk_flag", "isAdPopcornUser", true);
        f();
        try {
            int i2 = Calendar.getInstance().get(6);
            if (i2 != com.igaworks.adpopcorn.a.b.a().a(this.f1585b, "adpopcorn_sdk_flag", "adpopcorn_last_visit_day", -1)) {
                com.igaworks.adpopcorn.a.b.a().e(this.f1585b, "adpopcorn_choice_impression_sp");
                com.igaworks.adpopcorn.a.b.a().b(this.f1585b, "adpopcorn_sdk_flag", "adpopcorn_last_visit_day", i2);
            }
        } catch (Exception unused) {
        }
    }

    private RelativeLayout o() {
        com.igaworks.adpopcorn.activity.layout.e.c cVar = new com.igaworks.adpopcorn.activity.layout.e.c(this.c);
        ImageView imageView = (ImageView) cVar.findViewById(0);
        LinearLayout linearLayout = (LinearLayout) cVar.findViewById(1);
        ImageView imageView2 = (ImageView) cVar.findViewById(2);
        imageView.setOnClickListener(new d0());
        linearLayout.setOnClickListener(new e0());
        imageView2.setOnClickListener(new f0());
        if (this.n0) {
            imageView.setVisibility(4);
            linearLayout.setVisibility(4);
        }
        return cVar;
    }

    static /* synthetic */ int p(b bVar) {
        int i2 = bVar.b0;
        bVar.b0 = i2 + 1;
        return i2;
    }

    private View p() {
        View viewFindViewById;
        try {
            LinearLayout linearLayout = this.f0;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
                this.f0 = null;
            }
            this.e0 = new com.igaworks.adpopcorn.activity.layout.d(this.c, this.a, a(this.f1585b, false), this.A0, this.d, new a());
            if (a(this.f1585b, false)) {
                this.f0 = (LinearLayout) this.e0.findViewById(0);
                viewFindViewById = this.e0.findViewById(1);
            } else {
                this.f0 = (LinearLayout) this.e0.findViewById(0);
                viewFindViewById = this.e0.findViewById(1);
            }
            this.g0 = (ViewFlipper) viewFindViewById;
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setFillAfter(true);
            translateAnimation.setDuration(1000L);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation2.setFillAfter(false);
            translateAnimation2.setDuration(1000L);
            this.g0.setInAnimation(translateAnimation);
            this.g0.setOutAnimation(translateAnimation2);
            return this.e0;
        } catch (Exception e2) {
            e2.printStackTrace();
            View view = new View(this.c);
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
            return view;
        }
    }

    private LinearLayout q() {
        this.u0 = new LinearLayout(this.c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.u0.setOrientation(1);
        this.u0.setGravity(17);
        this.u0.setLayoutParams(layoutParams);
        this.u0.setBackgroundColor(Color.parseColor("#ffffff"));
        this.u0.addView(c(0));
        this.u0.addView(p());
        return this.u0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        try {
            d();
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            String str = gVar.I;
            String str2 = gVar.W;
            String str3 = gVar.z;
            String str4 = gVar.y;
            Context context = this.f1585b;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.l0, str, str2, -1, str3, new q(), str4, new r(), a(context, false));
            this.j0 = aVar;
            aVar.setCancelable(false);
            this.j0.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        try {
            boolean z2 = this.l0 == 16973841;
            Context context = this.f1585b;
            com.igaworks.adpopcorn.activity.b.c cVar = new com.igaworks.adpopcorn.activity.b.c(context, this.l0, a(context, false), this.d, z2, this);
            this.R = cVar;
            cVar.setOnDismissListener(new c0());
            this.R.show();
            y();
        } catch (Exception unused) {
        }
    }

    private void v() {
        h();
        try {
            com.igaworks.adpopcorn.activity.b.j.a aVar = new com.igaworks.adpopcorn.activity.b.j.a(this.f1585b, this.l0, this.P, this.d, this.J0, new i());
            this.Q = aVar;
            aVar.show();
            this.Q.setOnDismissListener(new j());
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
        try {
            Handler handler = this.E;
            if (handler != null) {
                handler.removeCallbacks(this.F);
                this.E.postDelayed(this.F, 5000L);
            }
        } catch (Exception unused) {
        }
    }

    private void y() {
        Handler handler = this.E;
        if (handler != null) {
            handler.removeCallbacks(this.F);
        }
    }

    public void a(Configuration configuration) {
        try {
            if (!this.p0) {
                com.igaworks.adpopcorn.cores.common.d.a();
            }
            com.igaworks.adpopcorn.cores.common.d.a((Activity) this.f1585b);
            this.a = ((WindowManager) this.f1585b.getSystemService("window")).getDefaultDisplay().getWidth();
            if (this.A0 == 1) {
                setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.f1585b, 9), com.igaworks.adpopcorn.cores.common.d.a(this.f1585b, 15), com.igaworks.adpopcorn.cores.common.d.a(this.f1585b, 9), com.igaworks.adpopcorn.cores.common.d.a(this.f1585b, 15));
                this.a -= com.igaworks.adpopcorn.cores.common.d.a(this.f1585b, 9);
            }
            this.b0 = 1;
            this.W = false;
            this.t0 = 1;
            k();
            Dialog dialog = this.Q;
            if (dialog != null && dialog.isShowing()) {
                this.Q.dismiss();
                this.Q = null;
            }
            Dialog dialog2 = this.R;
            if (dialog2 != null && dialog2.isShowing()) {
                this.R.dismiss();
                this.R = null;
            }
            com.igaworks.adpopcorn.activity.b.g gVar = this.S;
            if (gVar != null && gVar.isShowing()) {
                this.S.dismiss();
                this.S = null;
            }
            y();
            removeAllViewsInLayout();
            removeAllViews();
            invalidate();
            m();
            d(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, boolean z2) {
        try {
            h();
            if (((Activity) this.f1585b).isFinishing()) {
                return;
            }
            com.igaworks.adpopcorn.activity.b.d.c cVar = new com.igaworks.adpopcorn.activity.b.d.c(this.f1585b, this.l0);
            this.k0 = cVar;
            cVar.setCancelable(z2);
            this.k0.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(boolean z2, boolean z3) {
        this.m0 = z2;
        this.n0 = z3;
        try {
            n();
            k();
            m();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean a(Context context, boolean z2) {
        Activity activity;
        if (Build.VERSION.SDK_INT >= 24 && (activity = this.o0) != null && activity.isInMultiWindowMode()) {
            return false;
        }
        if (!z2) {
            return this.h0;
        }
        Configuration configuration = ((Activity) context).getResources().getConfiguration();
        return configuration != null && configuration.orientation == 2;
    }

    public void d(boolean z2) {
        Activity activity;
        try {
            this.C0 = false;
            if (Build.VERSION.SDK_INT >= 24 && (activity = this.o0) != null && activity.isInMultiWindowMode()) {
                this.C0 = true;
            }
            boolean z3 = this.C0;
            if (z3) {
                if (z3 && (com.igaworks.adpopcorn.cores.common.d.c() <= com.igaworks.adpopcorn.cores.common.d.a(this.f1585b, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO) || com.igaworks.adpopcorn.cores.common.d.b() <= com.igaworks.adpopcorn.cores.common.d.a(this.f1585b, 260))) {
                    Toast.makeText(this.f1585b, this.d.w1, 1).show();
                    j();
                    return;
                }
            } else if (a(this.f1585b, true)) {
                Toast.makeText(this.f1585b, this.d.x1, 1).show();
                j();
                return;
            }
            com.igaworks.adpopcorn.activity.b.g gVar = this.S;
            if (gVar != null && gVar.isShowing()) {
                this.S.k();
                return;
            }
            com.igaworks.adpopcorn.a.d dVar = this.w;
            if (dVar != null) {
                dVar.c(false);
            }
            if (com.igaworks.adpopcorn.a.b.a().a(this.f1585b, "adpopcorn_parameter", "check_user_agreement", false)) {
                l();
                return;
            }
            d();
            com.igaworks.adpopcorn.cores.common.g gVar2 = this.d;
            String str = gVar2.Z0;
            String str2 = gVar2.l1;
            String str3 = gVar2.k1;
            Context context = this.f1585b;
            com.igaworks.adpopcorn.activity.b.d.b bVar = new com.igaworks.adpopcorn.activity.b.d.b(context, this.l0, str, "", -1, str2, new k(), str3, new l(z2), a(context, false));
            this.j0 = bVar;
            bVar.setCancelable(false);
            this.j0.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void g() {
        try {
            h();
            y();
            if (this.F != null) {
                this.F = null;
            }
            Dialog dialog = this.Q;
            if (dialog != null && dialog.isShowing()) {
                this.Q.dismiss();
                this.Q = null;
            }
            Dialog dialog2 = this.R;
            if (dialog2 != null && dialog2.isShowing()) {
                this.R.dismiss();
                this.R = null;
            }
            HashMap<String, String> map = this.T;
            if (map != null && map.size() > 0) {
                this.T.clear();
                this.T = null;
            }
            com.igaworks.adpopcorn.activity.a.b.a aVar = this.j;
            if (aVar != null) {
                aVar.a();
            }
            WebView webView = this.q0;
            if (webView != null) {
                webView.destroy();
                this.q0 = null;
            }
            com.igaworks.adpopcorn.a.a.a();
            com.igaworks.adpopcorn.cores.common.e.a(this.f1585b);
            com.igaworks.adpopcorn.cores.common.i.a(this);
        } catch (Exception unused) {
        }
    }

    public int getOfferwallType() {
        return this.A0;
    }

    public void i() {
        try {
            com.igaworks.adpopcorn.a.d dVar = this.w;
            if (dVar != null) {
                dVar.c((String) null);
            }
            Activity activity = this.o0;
            if (activity == null) {
                a(new Configuration());
            } else {
                activity.finish();
                this.o0.overridePendingTransition(0, 0);
            }
        } catch (Exception unused) {
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

    public void s() {
        try {
            com.igaworks.adpopcorn.activity.b.g gVar = this.S;
            if (gVar == null || !gVar.isShowing()) {
                return;
            }
            this.S.j();
        } catch (Exception unused) {
        }
    }

    public void setApOfferWallOrientation(boolean z2) {
        this.h0 = z2;
    }

    public void setCustomViewMode(boolean z2) {
        this.p0 = z2;
    }

    public void setFilterCampaignKeyList(List<String> list) {
        this.I0 = list;
    }

    public void setOfferwallActivity(Activity activity) {
        this.o0 = activity;
    }

    public void setOfferwallType(int i2) {
        APOfferwallTabInfo aPOfferwallTabInfo = this.F0;
        if (aPOfferwallTabInfo != null) {
            this.G0 = aPOfferwallTabInfo.getTabType(0);
        }
        this.A0 = i2;
        this.B0 = 0;
        int i3 = this.G0;
        if (i3 == 11 || i3 == 10) {
            this.B0 = 2;
        }
    }

    public void setTabOfferwallInfo(APOfferwallTabInfo aPOfferwallTabInfo) {
        this.F0 = aPOfferwallTabInfo;
    }

    public void setViewTypeLoadListener(h0 h0Var) {
        this.E0 = h0Var;
    }

    public void t() {
        d(false);
    }
}
