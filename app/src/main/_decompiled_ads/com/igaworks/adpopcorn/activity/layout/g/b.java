package com.igaworks.adpopcorn.activity.layout.g;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
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
import com.igaworks.adpopcorn.R;
import com.igaworks.adpopcorn.activity.ApVideoAdActivity;
import com.igaworks.adpopcorn.style.APOfferwallTabInfo;
import com.igaworks.adpopcorn.style.ApStyleManager;
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
public class b extends FrameLayout implements com.igaworks.adpopcorn.a.g.a.d {
    private Runnable A;
    private i0 A0;
    private int B;
    private APOfferwallTabInfo B0;
    private int C;
    private int C0;
    private boolean D;
    private int D0;
    private String E;
    private List<String> E0;
    private String F;
    private TextView F0;
    private String G;
    private TextView G0;
    private String H;
    View.OnClickListener H0;
    private boolean I;
    View.OnClickListener I0;
    private com.igaworks.adpopcorn.cores.model.g J;
    AdapterView.OnItemClickListener J0;
    private Dialog K;
    AbsListView.OnScrollListener K0;
    private Dialog L;
    private HashMap<String, String> M;
    private com.igaworks.adpopcorn.a.g.a N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private int R;
    private int S;
    private LinearLayout T;
    private com.igaworks.adpopcorn.activity.layout.g.d U;
    private LinearLayout V;
    private ViewFlipper W;
    private int a;
    private boolean a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f1597b;
    private boolean b0;
    private Context c;
    private Dialog c0;
    private com.igaworks.adpopcorn.cores.common.g d;
    private com.igaworks.adpopcorn.activity.b.d.c d0;
    private com.igaworks.adpopcorn.a.c e;
    private com.igaworks.adpopcorn.activity.b.g e0;
    private FrameLayout f;
    private int f0;
    private LinearLayout g;
    private Activity g0;
    private TextView h;
    private WebView h0;
    private com.igaworks.adpopcorn.activity.a.d.a i;
    private ArrayList<String> i0;
    private com.igaworks.adpopcorn.activity.c.e j;
    private ArrayList<String> j0;
    private com.igaworks.adpopcorn.activity.c.e k;
    private int k0;
    private List<com.igaworks.adpopcorn.cores.model.g> l;
    private LinearLayout l0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> m;
    private LinearLayout m0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> n;
    private LinearLayout n0;
    private com.igaworks.adpopcorn.cores.model.g o;
    private List<TextView> o0;
    private ArrayList<com.igaworks.adpopcorn.cores.model.g> p;
    private List<TextView> p0;
    private int q;
    private List<ImageView> q0;
    private com.igaworks.adpopcorn.a.d r;
    private List<ImageView> r0;
    private String s;
    private List<LinearLayout> s0;
    private String t;
    private List<LinearLayout> t0;
    private String u;
    private int u0;
    private String v;
    private int v0;
    private String w;
    private boolean w0;
    private String x;
    private boolean x0;
    private String y;
    private String y0;
    private Handler z;
    private long z0;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.d("https://reward.adpopcorn.com/policy/privacy");
        }
    }

    class a0 extends WebViewClient {
        a0() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                com.igaworks.adpopcorn.cores.common.h.a(b.this.f1597b, "ApTPMNOfferWallLayout", "shouldOverrideUrlLoading = " + str, 3);
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

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.layout.g.b$b, reason: collision with other inner class name */
    class RunnableC0431b implements Runnable {
        RunnableC0431b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b();
        }
    }

    class b0 implements AdapterView.OnItemClickListener {

        class a extends com.igaworks.adpopcorn.cores.common.b {
            a(b0 b0Var) {
            }

            @Override // com.igaworks.adpopcorn.cores.common.b
            public void a() {
                super.a();
            }
        }

        b0() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            JSONObject jSONObject;
            com.igaworks.adpopcorn.a.g.a aVar;
            String str;
            com.igaworks.adpopcorn.a.d dVar;
            String strY;
            try {
                if (b.this.K == null || !b.this.K.isShowing()) {
                    if (b.this.e0 == null || !b.this.e0.isShowing()) {
                        b bVar = b.this;
                        bVar.J = (com.igaworks.adpopcorn.cores.model.g) bVar.m.get(i);
                        if (b.this.J.f0()) {
                            return;
                        }
                        if (!b.this.J.a0()) {
                            int i2 = 0;
                            if (b.this.J.X()) {
                                b bVar2 = b.this;
                                bVar2.a(bVar2.d.s, false);
                                b.this.r.b("media_offerwall_tab_content_click", b.this.J.d());
                                b.this.k0 = 1;
                                jSONObject = new JSONObject();
                                jSONObject.put("auth", b.this.J.a());
                                jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(b.this.f1597b));
                                aVar = b.this.N;
                                i2 = 2;
                                str = b.this.s;
                            } else if (b.this.J.c0()) {
                                if (b.this.J.b0()) {
                                    b.this.e0 = new com.igaworks.adpopcorn.activity.b.g(b.this.f1597b, b.this.f0, b.this.J, b.this.d, new a(this));
                                    b.this.e0.show();
                                } else {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put(MBridgeConstans.APP_KEY, b.this.r.e().b());
                                    jSONObject2.put("adid", b.this.r.e().a());
                                    jSONObject2.put("usn", b.this.r.e().g());
                                    jSONObject2.put("integration_type_no", b.this.J.E());
                                    jSONObject2.put("point", b.this.J.F());
                                    jSONObject2.put("newsId", b.this.J.C());
                                    b.this.N.a(29, b.this.y, jSONObject2, b.this);
                                }
                                dVar = b.this.r;
                                strY = b.this.J.y();
                            } else {
                                b bVar3 = b.this;
                                bVar3.C = bVar3.J.K();
                                b bVar4 = b.this;
                                bVar4.F = ((com.igaworks.adpopcorn.cores.model.g) bVar4.m.get(i)).a();
                                b bVar5 = b.this;
                                bVar5.E = ((com.igaworks.adpopcorn.cores.model.g) bVar5.m.get(i)).c();
                                b bVar6 = b.this;
                                bVar6.a(bVar6.d.s, false);
                                b.this.r.b("media_offerwall_tab_content_click", b.this.E);
                                b.this.k0 = 1;
                                jSONObject = new JSONObject();
                                jSONObject.put("auth", b.this.F);
                                jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(b.this.f1597b));
                                aVar = b.this.N;
                                str = b.this.s;
                            }
                            aVar.a(i2, str, jSONObject, b.this);
                            return;
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(MBridgeConstans.APP_KEY, b.this.r.e().b());
                        jSONObject3.put("adid", b.this.r.e().a());
                        jSONObject3.put("usn", b.this.r.e().g());
                        jSONObject3.put("integration_type_no", b.this.J.l());
                        jSONObject3.put("point", b.this.J.m());
                        b.this.N.a(27, b.this.x, jSONObject3, b.this);
                        dVar = b.this.r;
                        strY = b.this.J.d();
                        dVar.b("media_offerwall_tab_content_click", strY);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.igaworks.adpopcorn.cores.model.g gVar;
            b bVar;
            try {
                if (b.this.K == null || !b.this.K.isShowing()) {
                    int iIntValue = ((Integer) view.getTag()).intValue();
                    if (!com.igaworks.adpopcorn.cores.common.c.c(b.this.f1597b)) {
                        b bVar2 = b.this;
                        bVar2.b(bVar2.d.g, b.this.d.h, false);
                        return;
                    }
                    if (iIntValue == 0) {
                        bVar = b.this;
                        gVar = bVar.o;
                    } else {
                        b bVar3 = b.this;
                        gVar = (com.igaworks.adpopcorn.cores.model.g) bVar3.p.get(iIntValue - 1);
                        bVar = bVar3;
                    }
                    bVar.J = gVar;
                    b bVar4 = b.this;
                    bVar4.C = bVar4.J.K();
                    b bVar5 = b.this;
                    bVar5.F = bVar5.J.a();
                    b bVar6 = b.this;
                    bVar6.E = bVar6.J.c();
                    b bVar7 = b.this;
                    bVar7.a(bVar7.d.s, false);
                    b.this.k0 = 3;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("auth", b.this.F);
                    jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(b.this.f1597b));
                    b.this.N.a(0, b.this.s, jSONObject, b.this);
                    if (b.this.j0 == null || b.this.j0.contains(b.this.o.c())) {
                        return;
                    }
                    b.this.r.b("media_offerwall_tab_content_click", b.this.E);
                    b.this.j0.add(b.this.E);
                }
            } catch (Exception unused) {
            }
        }
    }

    class c0 implements AbsListView.OnScrollListener {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b(true);
            }
        }

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.layout.g.b$c0$b, reason: collision with other inner class name */
        class RunnableC0432b implements Runnable {
            RunnableC0432b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b(false);
                if (!com.igaworks.adpopcorn.cores.common.c.c(b.this.f1597b)) {
                    b.this.Q = true;
                    b.this.b(true);
                } else {
                    b.this.O = false;
                    b.this.P = false;
                    b.this.N.a(b.this.R, b.this);
                }
            }
        }

        c0() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:
        
            if (r4.a.m0 != null) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:
        
            r5 = r4.a.m0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
        
            if (r4.a.m0 != null) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
        
            if (r4.a.m0 != null) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
        
            r5 = r4.a.m0;
            r0 = 8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
        
            r5.setVisibility(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
        
            if (r4.a.m0 != null) goto L15;
         */
        @Override // android.widget.AbsListView.OnScrollListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onScroll(android.widget.AbsListView r5, int r6, int r7, int r8) {
            /*
                r4 = this;
                com.igaworks.adpopcorn.activity.layout.g.b r0 = com.igaworks.adpopcorn.activity.layout.g.b.this
                int r0 = com.igaworks.adpopcorn.activity.layout.g.b.z(r0)
                r1 = 1
                if (r0 != 0) goto L61
                r0 = 0
                android.view.View r5 = r5.getChildAt(r0)
                if (r5 == 0) goto L4e
                int r5 = r5.getTop()
                int r5 = -r5
                com.igaworks.adpopcorn.style.a r2 = com.igaworks.adpopcorn.style.a.b()
                java.lang.String r3 = "TOP_BAR_HEIGHT"
                int r2 = r2.c(r3)
                if (r6 < r1) goto L2a
                com.igaworks.adpopcorn.activity.layout.g.b r5 = com.igaworks.adpopcorn.activity.layout.g.b.this
                android.widget.LinearLayout r5 = com.igaworks.adpopcorn.activity.layout.g.b.b0(r5)
                if (r5 == 0) goto L61
                goto L3e
            L2a:
                com.igaworks.adpopcorn.activity.layout.g.b r3 = com.igaworks.adpopcorn.activity.layout.g.b.this
                android.content.Context r3 = com.igaworks.adpopcorn.activity.layout.g.b.H(r3)
                int r2 = com.igaworks.adpopcorn.cores.common.d.a(r3, r2)
                if (r5 < r2) goto L45
                com.igaworks.adpopcorn.activity.layout.g.b r5 = com.igaworks.adpopcorn.activity.layout.g.b.this
                android.widget.LinearLayout r5 = com.igaworks.adpopcorn.activity.layout.g.b.b0(r5)
                if (r5 == 0) goto L61
            L3e:
                com.igaworks.adpopcorn.activity.layout.g.b r5 = com.igaworks.adpopcorn.activity.layout.g.b.this
                android.widget.LinearLayout r5 = com.igaworks.adpopcorn.activity.layout.g.b.b0(r5)
                goto L5e
            L45:
                com.igaworks.adpopcorn.activity.layout.g.b r5 = com.igaworks.adpopcorn.activity.layout.g.b.this
                android.widget.LinearLayout r5 = com.igaworks.adpopcorn.activity.layout.g.b.b0(r5)
                if (r5 == 0) goto L61
                goto L56
            L4e:
                com.igaworks.adpopcorn.activity.layout.g.b r5 = com.igaworks.adpopcorn.activity.layout.g.b.this
                android.widget.LinearLayout r5 = com.igaworks.adpopcorn.activity.layout.g.b.b0(r5)
                if (r5 == 0) goto L61
            L56:
                com.igaworks.adpopcorn.activity.layout.g.b r5 = com.igaworks.adpopcorn.activity.layout.g.b.this
                android.widget.LinearLayout r5 = com.igaworks.adpopcorn.activity.layout.g.b.b0(r5)
                r0 = 8
            L5e:
                r5.setVisibility(r0)
            L61:
                if (r6 != 0) goto L7c
                com.igaworks.adpopcorn.activity.layout.g.b r5 = com.igaworks.adpopcorn.activity.layout.g.b.this     // Catch: java.lang.Exception -> L7c
                java.util.ArrayList r5 = com.igaworks.adpopcorn.activity.layout.g.b.c0(r5)     // Catch: java.lang.Exception -> L7c
                if (r5 == 0) goto L7c
                com.igaworks.adpopcorn.activity.layout.g.b r5 = com.igaworks.adpopcorn.activity.layout.g.b.this     // Catch: java.lang.Exception -> L7c
                java.util.ArrayList r5 = com.igaworks.adpopcorn.activity.layout.g.b.c0(r5)     // Catch: java.lang.Exception -> L7c
                int r5 = r5.size()     // Catch: java.lang.Exception -> L7c
                if (r5 <= r1) goto L7c
                com.igaworks.adpopcorn.activity.layout.g.b r5 = com.igaworks.adpopcorn.activity.layout.g.b.this     // Catch: java.lang.Exception -> L7c
                com.igaworks.adpopcorn.activity.layout.g.b.d0(r5)     // Catch: java.lang.Exception -> L7c
            L7c:
                com.igaworks.adpopcorn.activity.layout.g.b r5 = com.igaworks.adpopcorn.activity.layout.g.b.this
                boolean r5 = com.igaworks.adpopcorn.activity.layout.g.b.T(r5)
                if (r5 == 0) goto Lc3
                com.igaworks.adpopcorn.activity.layout.g.b r5 = com.igaworks.adpopcorn.activity.layout.g.b.this
                boolean r5 = com.igaworks.adpopcorn.activity.layout.g.b.U(r5)
                if (r5 != 0) goto Lc3
                com.igaworks.adpopcorn.activity.layout.g.b r5 = com.igaworks.adpopcorn.activity.layout.g.b.this
                boolean r5 = com.igaworks.adpopcorn.activity.layout.g.b.P(r5)
                if (r5 != 0) goto Lb6
                com.igaworks.adpopcorn.activity.layout.g.b r5 = com.igaworks.adpopcorn.activity.layout.g.b.this
                int r5 = com.igaworks.adpopcorn.activity.layout.g.b.C(r5)
                com.igaworks.adpopcorn.activity.layout.g.b r0 = com.igaworks.adpopcorn.activity.layout.g.b.this
                int r0 = com.igaworks.adpopcorn.activity.layout.g.b.O(r0)
                if (r5 <= r0) goto La3
                goto Lb6
            La3:
                if (r8 < r1) goto Lc3
                int r6 = r6 + r7
                if (r6 != r8) goto Lc3
                android.os.Handler r5 = new android.os.Handler
                r5.<init>()
                com.igaworks.adpopcorn.activity.layout.g.b$c0$b r6 = new com.igaworks.adpopcorn.activity.layout.g.b$c0$b
                r6.<init>()
                r5.post(r6)
                goto Lc3
            Lb6:
                android.os.Handler r5 = new android.os.Handler
                r5.<init>()
                com.igaworks.adpopcorn.activity.layout.g.b$c0$a r6 = new com.igaworks.adpopcorn.activity.layout.g.b$c0$a
                r6.<init>()
                r5.post(r6)
            Lc3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.igaworks.adpopcorn.activity.layout.g.b.c0.onScroll(android.widget.AbsListView, int, int, int):void");
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextView textView;
            ImageView imageView;
            List list;
            int i;
            try {
                int iIntValue = ((Integer) view.getTag()).intValue();
                if (b.this.D0 == iIntValue) {
                    return;
                }
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(b.this.f1597b, 37.0f));
                gradientDrawable.setGradientType(0);
                for (int i2 = 0; i2 < 2; i2++) {
                    int i3 = 0;
                    while (i3 < b.this.B0.getTabCount()) {
                        if (i2 == 0) {
                            textView = (TextView) b.this.p0.get(i3);
                            imageView = (ImageView) b.this.r0.get(i3);
                            list = b.this.t0;
                        } else {
                            textView = (TextView) b.this.o0.get(i3);
                            imageView = (ImageView) b.this.q0.get(i3);
                            list = b.this.s0;
                        }
                        LinearLayout linearLayout = (LinearLayout) list.get(i3);
                        if (iIntValue == i3) {
                            linearLayout.setBackgroundDrawable(gradientDrawable);
                            textView.setTextColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_SELECT_TEXT_COLOR));
                            i = i3 == 0 ? R.drawable.tpmn_point : R.drawable.tpmn_shoppingbag;
                        } else {
                            linearLayout.setBackgroundDrawable(null);
                            textView.setTextColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_UNSELECT_TEXT_COLOR));
                            i = i3 == 0 ? R.drawable.tpmn_pointoff : R.drawable.tpmn_shoppingbagoff;
                        }
                        imageView.setImageResource(i);
                        i3++;
                    }
                }
                b bVar = b.this;
                bVar.C0 = bVar.B0.getTabType(iIntValue);
                if (b.this.u0 == 0) {
                    b.this.v0 = 0;
                    if (b.this.C0 == 9) {
                        b.this.v0 = 2;
                    }
                } else if (b.this.u0 == 1) {
                    b.this.v0 = 1;
                    if (b.this.C0 == 9) {
                        b.this.v0 = 3;
                    }
                } else if (b.this.u0 == 2) {
                    b.this.v0 = 2;
                } else if (b.this.u0 == 3) {
                    b.this.v0 = 4;
                }
                if (b.this.i != null) {
                    b.this.i.a(b.this.v0);
                }
                b.this.c(false);
                b.this.D0 = iIntValue;
                if (b.this.r != null) {
                    b.this.r.b("media_offerwall_tab_visit", b.this.C0 + "");
                }
            } catch (Exception unused) {
            }
        }
    }

    class d0 implements DialogInterface.OnDismissListener {
        d0() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (b.this.e.i()) {
                b bVar = b.this;
                bVar.a(bVar.d.f1613b, true);
            }
        }
    }

    class e implements View.OnClickListener {
        final /* synthetic */ boolean a;

        e(boolean z) {
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

    class e0 implements DialogInterface.OnDismissListener {
        e0() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.b();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.d();
            b.this.j();
        }
    }

    class f0 implements View.OnClickListener {
        f0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.j();
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.d();
            String str = "https://adpopcorn.notion.site/FAQ-35edb7e2c4ff4311b2bcf616c8e1b022";
            String strA = com.igaworks.adpopcorn.a.b.a().a(b.this.f1597b, "adpopcorn_sdk_flag", "no_ad_landingurl", "https://adpopcorn.notion.site/FAQ-35edb7e2c4ff4311b2bcf616c8e1b022");
            if (strA != null && strA.length() > 0) {
                str = strA;
            }
            b.this.d(str);
        }
    }

    class g0 implements View.OnClickListener {
        g0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = "https://adpopcorn.notion.site/FAQ-35edb7e2c4ff4311b2bcf616c8e1b022";
            String strA = com.igaworks.adpopcorn.a.b.a().a(b.this.f1597b, "adpopcorn_sdk_flag", "no_ad_landingurl", "https://adpopcorn.notion.site/FAQ-35edb7e2c4ff4311b2bcf616c8e1b022");
            if (strA != null && strA.length() > 0) {
                str = strA;
            }
            b.this.d(str);
        }
    }

    class h implements View.OnClickListener {
        final /* synthetic */ int a;

        h(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (this.a == 1004) {
                    if (com.igaworks.adpopcorn.cores.common.c.c(b.this.f1597b)) {
                        b bVar = b.this;
                        bVar.a(bVar.d.f1613b, false);
                        b.this.N.a(b.this.R, b.this);
                    } else {
                        b bVar2 = b.this;
                        bVar2.b(bVar2.d.g, b.this.d.h, false);
                    }
                }
                if (b.this.i != null) {
                    b.this.i.notifyDataSetChanged();
                }
                b.this.d();
            } catch (Exception unused) {
            }
        }
    }

    class h0 implements View.OnClickListener {
        h0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.v();
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.d();
        }
    }

    public interface i0 {
        void OnLoadedOfferWallPage();
    }

    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                b bVar = b.this;
                if (bVar.c(bVar.J.J())) {
                    b bVar2 = b.this;
                    bVar2.a(true, bVar2.J.J());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            b.this.d();
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.igaworks.adpopcorn.a.d.a(b.this.f1597b) != null) {
                com.igaworks.adpopcorn.a.d.a(b.this.f1597b).j();
            }
            b.this.d();
            b.this.j();
        }
    }

    class l implements View.OnClickListener {

        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.d();
                b.this.u();
            }
        }

        l() {
        }

        /* JADX WARN: Code duplicated, block: B:9:0x003e A[Catch: Exception -> 0x0096, TRY_LEAVE, TryCatch #0 {Exception -> 0x0096, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x0030, B:9:0x003e), top: B:13:0x0003 }] */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                try {
                    if (view.isSelected()) {
                        b.this.d();
                        com.igaworks.adpopcorn.a.b.a().b(b.this.f1597b, "adpopcorn_parameter", "check_user_agreement", true);
                        b.this.u();
                        if (com.igaworks.adpopcorn.a.d.a(b.this.f1597b) != null) {
                            com.igaworks.adpopcorn.a.d.a(b.this.f1597b).i();
                        }
                    } else {
                        b.this.d();
                        String str = b.this.d.Y;
                        String str2 = b.this.d.j1;
                        String str3 = b.this.d.I;
                        b bVar = b.this;
                        Context context = b.this.f1597b;
                        int i = b.this.f0;
                        a aVar = new a();
                        b bVar2 = b.this;
                        bVar.c0 = new com.igaworks.adpopcorn.activity.b.d.a(context, i, str, str2, -1, str3, aVar, bVar2.a(bVar2.f1597b, false), false);
                        b.this.c0.setCancelable(true);
                        b.this.c0.show();
                    }
                } catch (Exception unused) {
                }
            } else {
                b.this.d();
                String str4 = b.this.d.Y;
                String str5 = b.this.d.j1;
                String str6 = b.this.d.I;
                b bVar3 = b.this;
                Context context2 = b.this.f1597b;
                int i2 = b.this.f0;
                a aVar2 = new a();
                b bVar4 = b.this;
                bVar3.c0 = new com.igaworks.adpopcorn.activity.b.d.a(context2, i2, str4, str5, -1, str6, aVar2, bVar4.a(bVar4.f1597b, false), false);
                b.this.c0.setCancelable(true);
                b.this.c0.show();
            }
        }
    }

    class m implements DialogInterface.OnDismissListener {
        m() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (b.this.K != null) {
                b.this.K = null;
            }
        }
    }

    class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (b.this.b0) {
                    b.this.s();
                    return;
                }
                if (b.this.C == 7 || b.this.C == 23) {
                    com.igaworks.adpopcorn.a.b.a().b(b.this.c, "participateFlag", b.this.E, true);
                    if (b.this.i != null) {
                        b.this.i.notifyDataSetChanged();
                    }
                }
                b.this.r.b("media_offerwall_tab_content_engagement", b.this.E);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("auth", b.this.G);
                    jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(b.this.f1597b));
                    jSONObject.put("channel_code", b.this.k0);
                    b.this.N.a(1, b.this.t, jSONObject, b.this);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (b.this.K != null) {
                    b.this.K.dismiss();
                    b.this.K = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
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
            b.this.d();
        }
    }

    class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.a(true);
            b.this.d();
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
            if (b.this.C == 7 || b.this.C == 23) {
                com.igaworks.adpopcorn.a.b.a().b(b.this.c, "participateFlag", b.this.E, true);
                if (b.this.i != null) {
                    b.this.i.notifyDataSetChanged();
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("auth", b.this.G);
                jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(b.this.f1597b));
                jSONObject.put("channel_code", b.this.k0);
                b.this.N.a(1, b.this.t, jSONObject, b.this);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (b.this.K != null) {
                b.this.K.dismiss();
                b.this.K = null;
            }
            b.this.d();
        }
    }

    class t implements View.OnClickListener {
        t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.d();
        }
    }

    class u implements View.OnClickListener {
        u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (b.this.I) {
                    b bVar = b.this;
                    bVar.e(bVar.H);
                } else {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(b.this.H));
                    b.this.f1597b.startActivity(intent);
                }
            } catch (Exception unused) {
            }
        }
    }

    class v implements com.igaworks.adpopcorn.a.g.a.d {
        v(b bVar) {
        }

        @Override // com.igaworks.adpopcorn.a.g.a.d
        public void onNetResponseListener(int i, com.igaworks.adpopcorn.cores.model.f fVar) {
        }
    }

    class w implements com.igaworks.adpopcorn.a.g.a.d {
        w(b bVar) {
        }

        @Override // com.igaworks.adpopcorn.a.g.a.d
        public void onNetResponseListener(int i, com.igaworks.adpopcorn.cores.model.f fVar) {
        }
    }

    class x extends com.igaworks.adpopcorn.cores.common.b {
        x() {
        }

        @Override // com.igaworks.adpopcorn.cores.common.b
        public void a() {
            super.a();
            if (b.this.J.b0()) {
                return;
            }
            b.this.e();
            com.igaworks.adpopcorn.a.b.a().a(b.this.f1597b, b.this.J.C());
            b.this.J.g(true);
        }
    }

    class y implements DialogInterface.OnDismissListener {
        y() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (b.this.i != null) {
                b.this.i.notifyDataSetChanged();
            }
        }
    }

    class z implements Runnable {
        final /* synthetic */ com.igaworks.adpopcorn.cores.model.f a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b(true);
            }
        }

        z(com.igaworks.adpopcorn.cores.model.f fVar) {
            this.a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int iB;
            com.igaworks.adpopcorn.cores.common.d.a();
            if (b.this.e != null && (b.this.e.e() || b.this.e.f())) {
                b bVar = b.this;
                bVar.b(bVar.d.X0, b.this.d.h, true);
                return;
            }
            com.igaworks.adpopcorn.cores.model.f fVar = this.a;
            boolean z = false;
            if (fVar == null || !fVar.d()) {
                com.igaworks.adpopcorn.cores.model.f fVar2 = this.a;
                if (fVar2 == null || fVar2.a() == null || this.a.a().length() <= 0) {
                    z = true;
                } else {
                    try {
                        com.igaworks.adpopcorn.cores.model.e eVarA = com.igaworks.adpopcorn.a.f.d.a(b.this.f1597b, this.a.a());
                        if (eVarA == null || !eVarA.e()) {
                            iB = 0;
                        } else {
                            b.this.a(eVarA.a(), b.this.R);
                            iB = eVarA.b();
                            b.this.S = eVarA.d();
                            b.this.y0 = eVarA.c();
                        }
                        com.igaworks.adpopcorn.cores.common.h.b(b.this.f1597b, "AP_OFFER", "callbackGetCampaignList: resultCode : " + iB, 3);
                        if (b.this.R >= b.this.S) {
                            b.this.P = true;
                        }
                        b.this.k();
                        b.this.x();
                        if (iB == 500) {
                            b.this.c(true);
                        } else {
                            b.this.c(false);
                        }
                        b.D(b.this);
                        b.this.h();
                    } catch (Exception e) {
                        e.printStackTrace();
                        z = true;
                    }
                }
            } else if (b.this.R == 1) {
                b bVar2 = b.this;
                bVar2.b(bVar2.d.U, b.this.d.h, true);
            } else {
                b bVar3 = b.this;
                bVar3.a(bVar3.d.p, b.this.d.e, false);
            }
            b.this.O = true;
            if (z) {
                if (b.this.R == 1) {
                    b bVar4 = b.this;
                    bVar4.b(bVar4.d.U, b.this.d.h, true);
                } else {
                    new Handler().post(new a());
                }
                b.this.Q = true;
                b.this.h();
            }
            if (b.this.A0 != null) {
                b.this.A0.OnLoadedOfferWallPage();
            }
        }
    }

    public b(Context context) {
        super(context);
        this.q = 0;
        this.D = false;
        this.I = false;
        this.J = new com.igaworks.adpopcorn.cores.model.g();
        this.M = new HashMap<>();
        this.R = 0;
        this.S = 1;
        this.f0 = 0;
        this.k0 = 1;
        this.u0 = 0;
        this.v0 = 0;
        this.w0 = false;
        this.y0 = "";
        this.z0 = 0L;
        this.C0 = 0;
        this.D0 = 0;
        this.H0 = new d();
        this.I0 = new n();
        this.J0 = new b0();
        this.K0 = new c0();
        this.f1597b = context;
        this.c = context.getApplicationContext();
        this.x0 = false;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    private void A() {
        Handler handler = this.z;
        if (handler != null) {
            handler.removeCallbacks(this.A);
        }
    }

    static /* synthetic */ int D(b bVar) {
        int i2 = bVar.R;
        bVar.R = i2 + 1;
        return i2;
    }

    private com.igaworks.adpopcorn.activity.layout.b a(int i2) {
        com.igaworks.adpopcorn.activity.layout.b bVar = new com.igaworks.adpopcorn.activity.layout.b(this.c, i2);
        this.T = (LinearLayout) bVar.findViewById(0);
        TextView textView = (TextView) bVar.findViewById(1);
        this.T.setVisibility(8);
        textView.setText(this.d.V);
        return bVar;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x00eb A[Catch: Exception -> 0x0245, TryCatch #1 {Exception -> 0x0245, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x0007, B:7:0x000b, B:8:0x000e, B:10:0x0016, B:11:0x001b, B:13:0x001f, B:14:0x0022, B:19:0x0038, B:21:0x0040, B:23:0x0052, B:25:0x0062, B:28:0x006a, B:30:0x0072, B:32:0x007a, B:34:0x0082, B:37:0x0093, B:39:0x009e, B:41:0x00a2, B:43:0x00a8, B:45:0x00ae, B:48:0x00ba, B:53:0x00c6, B:56:0x00ce, B:58:0x00d4, B:60:0x00dd, B:62:0x00e3, B:63:0x00eb, B:64:0x00f0, B:70:0x0100, B:74:0x0107, B:77:0x010f, B:79:0x0115, B:81:0x011e, B:83:0x0124, B:84:0x012c, B:92:0x0146, B:85:0x012f, B:87:0x0135, B:89:0x013b, B:38:0x0096, B:113:0x0194, B:115:0x019c, B:117:0x01a0, B:118:0x01a3, B:120:0x01a7, B:122:0x01ab, B:124:0x01b1, B:125:0x01c3, B:127:0x01c7, B:129:0x01cd, B:130:0x01df, B:131:0x01e6, B:133:0x01ea, B:135:0x01f0, B:136:0x01f3, B:138:0x01fb, B:140:0x0207, B:142:0x020f), top: B:149:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x012c A[Catch: Exception -> 0x0245, TryCatch #1 {Exception -> 0x0245, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x0007, B:7:0x000b, B:8:0x000e, B:10:0x0016, B:11:0x001b, B:13:0x001f, B:14:0x0022, B:19:0x0038, B:21:0x0040, B:23:0x0052, B:25:0x0062, B:28:0x006a, B:30:0x0072, B:32:0x007a, B:34:0x0082, B:37:0x0093, B:39:0x009e, B:41:0x00a2, B:43:0x00a8, B:45:0x00ae, B:48:0x00ba, B:53:0x00c6, B:56:0x00ce, B:58:0x00d4, B:60:0x00dd, B:62:0x00e3, B:63:0x00eb, B:64:0x00f0, B:70:0x0100, B:74:0x0107, B:77:0x010f, B:79:0x0115, B:81:0x011e, B:83:0x0124, B:84:0x012c, B:92:0x0146, B:85:0x012f, B:87:0x0135, B:89:0x013b, B:38:0x0096, B:113:0x0194, B:115:0x019c, B:117:0x01a0, B:118:0x01a3, B:120:0x01a7, B:122:0x01ab, B:124:0x01b1, B:125:0x01c3, B:127:0x01c7, B:129:0x01cd, B:130:0x01df, B:131:0x01e6, B:133:0x01ea, B:135:0x01f0, B:136:0x01f3, B:138:0x01fb, B:140:0x0207, B:142:0x020f), top: B:149:0x0000 }] */
    private void a() {
        boolean zA;
        long j2;
        try {
            if (this.o != null) {
                this.o = null;
            }
            ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList = this.n;
            if (arrayList != null) {
                arrayList.clear();
            }
            if (this.m.size() != 0) {
                this.m.clear();
            }
            HashMap<String, String> map = this.M;
            if (map != null) {
                map.clear();
            }
            boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.DISABLE_SPECIAL_OFFER);
            int i2 = this.v0;
            if (i2 == 2 || i2 == 3) {
                zB = true;
            }
            for (int i3 = 0; i3 < this.l.size(); i3++) {
                com.igaworks.adpopcorn.cores.model.g gVar = this.l.get(i3);
                if (a(gVar.c()) && !com.igaworks.adpopcorn.a.b.a().g(this.f1597b, gVar.c())) {
                    int i4 = this.C0;
                    if (i4 == 8) {
                        zA = true;
                        for (int i5 = 0; i5 < this.B0.getTabCount(); i5++) {
                            if (this.B0.getTabType(i5) != 8 && this.B0.getTabType(i5) != 0 && com.igaworks.adpopcorn.cores.common.k.a(this.B0.getTabType(i5), gVar.K())) {
                                zA = false;
                            }
                        }
                    } else {
                        zA = com.igaworks.adpopcorn.cores.common.k.a(i4, gVar.K());
                    }
                    int i6 = this.u0;
                    if (i6 == 2) {
                        if (!gVar.f0() && gVar.r() != null && gVar.r().length() > 0) {
                            if (zA) {
                                this.m.add(gVar);
                            }
                            try {
                                j2 = this.z0;
                                this.z0 = j2 + gVar.Q();
                            } catch (Exception unused) {
                            }
                        }
                    } else if (i6 == 3) {
                        if (zA && !gVar.f0()) {
                            if (zB || !gVar.x()) {
                                this.m.add(gVar);
                            } else {
                                this.n.add(gVar);
                                ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList2 = this.n;
                                if (arrayList2 == null || arrayList2.size() > 1) {
                                    this.m.add(gVar);
                                } else {
                                    this.o = gVar;
                                    this.m.add(0, gVar);
                                }
                            }
                        }
                        if (!gVar.f0()) {
                            j2 = this.z0;
                            this.z0 = j2 + gVar.Q();
                        }
                    } else {
                        if (zA) {
                            int i7 = this.v0;
                            if (i7 == 2 || i7 == 3) {
                                if (!gVar.f0() && gVar.r() != null && gVar.r().length() > 0) {
                                    this.m.add(gVar);
                                }
                            } else if (!gVar.f0()) {
                                if (zB || !gVar.x()) {
                                    this.m.add(gVar);
                                } else {
                                    this.n.add(gVar);
                                    ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList3 = this.n;
                                    if (arrayList3 == null || arrayList3.size() > 1) {
                                        this.m.add(gVar);
                                    } else {
                                        this.o = gVar;
                                        this.m.add(0, gVar);
                                    }
                                }
                            }
                        }
                        APOfferwallTabInfo aPOfferwallTabInfo = this.B0;
                        if (aPOfferwallTabInfo == null || aPOfferwallTabInfo.getTabCount() <= 1) {
                            j2 = this.z0;
                        } else if (!com.igaworks.adpopcorn.cores.common.k.a(9, gVar.K()) && !com.igaworks.adpopcorn.cores.common.k.a(10, gVar.K())) {
                            j2 = this.z0;
                        } else if (!gVar.f0() && gVar.r() != null && gVar.r().length() > 0) {
                            j2 = this.z0;
                        }
                        this.z0 = j2 + gVar.Q();
                    }
                }
            }
            if (a(this.f1597b, false)) {
                ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList4 = this.p;
                if (arrayList4 != null) {
                    arrayList4.clear();
                }
                if (this.o != null) {
                    ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList5 = this.m;
                    if (arrayList5 != null && arrayList5.size() > 0) {
                        this.p.add(this.m.get(0));
                        this.m.remove(0);
                    }
                    ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList6 = this.m;
                    if (arrayList6 != null && arrayList6.size() > 0) {
                        this.p.add(this.m.get(0));
                        this.m.remove(0);
                    }
                    this.U.a((List<com.igaworks.adpopcorn.cores.model.g>) this.p, false);
                }
            }
            if (this.n != null) {
                this.q = 0;
                ViewFlipper viewFlipper = this.W;
                if (viewFlipper != null) {
                    viewFlipper.removeAllViews();
                }
                int iC = !a(this.f1597b, false) ? com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.SPECIAL_OFFER_TOP_ROUND_DP) : 0;
                for (int i8 = 0; i8 < this.n.size(); i8++) {
                    Context context = this.f1597b;
                    com.igaworks.adpopcorn.activity.c.i iVar = new com.igaworks.adpopcorn.activity.c.i(context, com.igaworks.adpopcorn.cores.common.d.a(context, iC));
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    iVar.setScaleType(ImageView.ScaleType.FIT_XY);
                    iVar.setLayoutParams(layoutParams);
                    this.W.addView(iVar);
                    com.igaworks.adpopcorn.cores.common.e.a(this.f1597b, this.n.get(i8).T(), iVar, 0, 0, (com.igaworks.adpopcorn.cores.common.e.b) null);
                }
            }
        } catch (Exception unused2) {
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
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1597b, "ApTPMNOfferWallLayout", "callbackCheckCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    int i4 = jSONObject.getInt("ResultCode");
                    boolean z2 = jSONObject.getBoolean("Result");
                    this.b0 = this.J.d0();
                    if (!z2) {
                        h();
                        if (i4 != 2000) {
                            com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
                            a(gVar3.p, gVar3.x, true);
                            return;
                        }
                        int i5 = this.C;
                        if (i5 != 25 || i5 != 24) {
                            com.igaworks.adpopcorn.a.b.a().b(this.f1597b, this.J.c());
                        }
                        com.igaworks.adpopcorn.cores.common.g gVar4 = this.d;
                        a(gVar4.Y, gVar4.i, true);
                        c(false);
                        return;
                    }
                    this.G = jSONObject.getString("Auth");
                    this.B = jSONObject.getInt("Status");
                    int iK = this.J.K();
                    this.C = iK;
                    if (i2 != 2) {
                        if (iK == 1 || iK == 2) {
                            h();
                            int i6 = this.B;
                            if (i6 != 0 && i6 != 50 && i6 != 125) {
                                c(PointerIconCompat.TYPE_WAIT);
                                return;
                            }
                        } else if (iK == 6 || iK == 7 || iK == 23) {
                            aVar = this.N;
                            gVar = this.J;
                        }
                        w();
                        return;
                    }
                    if (iK != 6 && iK != 7 && iK != 23) {
                        this.r.b("media_offerwall_tab_content_engagement", this.E);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("auth", this.G);
                            jSONObject2.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1597b));
                            jSONObject2.put("channel_code", this.k0);
                            this.N.a(1, this.t, jSONObject2, this);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    aVar = this.N;
                    i3 = 4;
                    gVar = this.J;
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
        if (this.R == 1) {
            com.igaworks.adpopcorn.a.b.a().a(this.f1597b);
        }
        new Handler(Looper.getMainLooper()).post(new z(fVar));
    }

    private void a(String str, String str2, double d2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, boolean z2, String str11, int i3, String str12, String str13, String str14) {
        try {
            this.f1597b.startActivity(new Intent(this.f1597b, (Class<?>) ApVideoAdActivity.class).putExtra("cKey", str).putExtra("joinAuth", str2).putExtra("averageRating", d2).putExtra("landscapeImageURL", str3).putExtra("clickAction", str4).putExtra("campaignDescription", str5).putExtra("iconImageURL", str6).putExtra("campaignName", str7).putExtra("numberOfDownloads", str8).putExtra("redirectURL", str9).putExtra("videoURL", str10).putExtra("ADType", i2).putExtra("AutoRedirect", z2).putExtra("fromVideoAPI", false).putExtra("rewardName", str11).putExtra("skipAllowSeconds", i3).putExtra("videoImpressionURL", str12).putExtra("moreClickReportURL", str13).putExtra("PartiTypeCode", this.C).putExtra("campaignCondition", str14));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, boolean z2) {
        h();
        d();
        String str3 = this.d.h;
        try {
            Context context = this.f1597b;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.f0, str, str2, -1, str3, new o(), a(context, false), false);
            this.c0 = aVar;
            aVar.setCancelable(false);
            this.c0.setCanceledOnTouchOutside(false);
            this.c0.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<com.igaworks.adpopcorn.cores.model.g> list, int i2) {
        List<com.igaworks.adpopcorn.cores.model.g> list2;
        try {
            if (list == null) {
                list2 = this.l;
                if (list2 == null || i2 != 1) {
                    return;
                }
            } else {
                if (list != null && list.size() > 0) {
                    if (i2 != 1) {
                        this.l.addAll(list);
                        return;
                    }
                    List<com.igaworks.adpopcorn.cores.model.g> list3 = this.l;
                    if (list3 != null) {
                        list3.clear();
                    }
                    this.l = list;
                    return;
                }
                if (i2 != 1 || (list2 = this.l) == null) {
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
        if (this.N == null) {
            this.N = new com.igaworks.adpopcorn.a.g.a(this.f1597b);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("auth", this.G);
        jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1597b));
        this.N.a(11, this.v, jSONObject, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2, String str) {
        String installerPackageName;
        com.igaworks.adpopcorn.a.g.a aVar;
        int i2;
        String str2;
        String str3 = this.G;
        String str4 = this.E;
        try {
            installerPackageName = this.f1597b.getPackageManager().getInstallerPackageName(str);
        } catch (Exception unused) {
            installerPackageName = null;
        }
        try {
            com.igaworks.adpopcorn.cores.common.h.a(this.f1597b, "ApTPMNOfferWallLayout", "sendCompleteRewardRequest installer = " + installerPackageName, 3);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", this.G);
            jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1597b));
            jSONObject.put("sign", com.igaworks.adpopcorn.cores.common.c.a(str4, str3));
            jSONObject.put(TapjoyConstants.TJC_INSTALLER, installerPackageName);
            if (z2) {
                aVar = this.N;
                i2 = 5;
                str2 = this.u;
            } else {
                aVar = this.N;
                i2 = 19;
                str2 = this.w;
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
        HashMap<String, String> map = this.M;
        if (map != null && map.containsKey(str)) {
            return false;
        }
        List<String> list = this.E0;
        if (list != null && list.contains(str)) {
            return false;
        }
        HashMap<String, String> map2 = this.M;
        if (map2 != null) {
            map2.put(str, str);
        }
        return true;
    }

    private LinearLayout b(int i2) {
        int i3;
        List<LinearLayout> list;
        this.m0 = new LinearLayout(this.c);
        this.n0 = new LinearLayout(this.c);
        LinearLayout linearLayout = new LinearLayout(this.c);
        try {
            int tabCount = this.B0.getTabCount();
            int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_BAR_HEIGHT);
            int i4 = 2;
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1250068, -1250068});
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, 37.0f));
            gradientDrawable.setGradientType(0);
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
            gradientDrawable2.setShape(0);
            gradientDrawable2.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, 37.0f));
            gradientDrawable2.setGradientType(0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, iC + 21 + 12));
            layoutParams.gravity = 49;
            layoutParams.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.c, 12);
            this.m0.setOrientation(0);
            this.m0.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.c, 50), com.igaworks.adpopcorn.cores.common.d.a(this.c, 21), com.igaworks.adpopcorn.cores.common.d.a(this.c, 50), 0);
            this.m0.setLayoutParams(layoutParams);
            this.m0.setBackgroundColor(Color.parseColor("#fcfcfc"));
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 21) {
                this.m0.setElevation(com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, 2));
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, iC));
            layoutParams2.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.c, 50);
            layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.c, 50);
            layoutParams2.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.c, 12);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            linearLayout.setLayoutParams(layoutParams2);
            linearLayout.setBackgroundDrawable(gradientDrawable);
            if (i5 >= 21) {
                linearLayout.setElevation(com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, 2));
            }
            this.n0.setOrientation(0);
            this.n0.setGravity(17);
            this.n0.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, iC)));
            this.n0.setBackgroundDrawable(gradientDrawable);
            this.m0.addView(this.n0);
            List<TextView> list2 = this.o0;
            if (list2 == null) {
                this.o0 = new ArrayList();
            } else {
                list2.clear();
            }
            List<TextView> list3 = this.p0;
            if (list3 == null) {
                this.p0 = new ArrayList();
            } else {
                list3.clear();
            }
            List<ImageView> list4 = this.q0;
            if (list4 == null) {
                this.q0 = new ArrayList();
            } else {
                list4.clear();
            }
            List<ImageView> list5 = this.r0;
            if (list5 == null) {
                this.r0 = new ArrayList();
            } else {
                list5.clear();
            }
            List<LinearLayout> list6 = this.s0;
            if (list6 == null) {
                this.s0 = new ArrayList();
            } else {
                list6.clear();
            }
            List<LinearLayout> list7 = this.t0;
            if (list7 == null) {
                this.t0 = new ArrayList();
            } else {
                list7.clear();
            }
            int i6 = 0;
            while (i6 < i4) {
                int i7 = 0;
                while (i7 < tabCount) {
                    int i8 = i7 == 1 ? 139 : 121;
                    LinearLayout linearLayout2 = new LinearLayout(this.c);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, com.igaworks.adpopcorn.cores.common.d.a(this.c, iC), i8);
                    layoutParams3.gravity = 17;
                    linearLayout2.setOrientation(0);
                    linearLayout2.setLayoutParams(layoutParams3);
                    linearLayout2.setGravity(17);
                    linearLayout2.setTag(Integer.valueOf(i7));
                    linearLayout2.setOnClickListener(this.H0);
                    linearLayout2.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.c, i4), com.igaworks.adpopcorn.cores.common.d.a(this.c, i4), com.igaworks.adpopcorn.cores.common.d.a(this.c, i4), com.igaworks.adpopcorn.cores.common.d.a(this.c, i4));
                    ImageView imageView = new ImageView(this.c);
                    FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.c, 14), com.igaworks.adpopcorn.cores.common.d.a(this.c, 14));
                    layoutParams4.gravity = 16;
                    layoutParams4.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.c, 5);
                    layoutParams4.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.c, 22);
                    imageView.setLayoutParams(layoutParams4);
                    imageView.setTag(Integer.valueOf(i7));
                    linearLayout2.addView(imageView);
                    TextView textView = new TextView(this.c);
                    textView.setLayoutParams(new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.c, 32)));
                    textView.setGravity(19);
                    textView.setTextSize(1, 10.0f);
                    textView.setText(this.B0.getTabTitle(i7));
                    textView.setTag(Integer.valueOf(i7));
                    linearLayout2.addView(textView);
                    if (i7 == 0) {
                        linearLayout2.setBackgroundDrawable(gradientDrawable2);
                        textView.setTextColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_SELECT_TEXT_COLOR));
                        i3 = R.drawable.tpmn_point;
                    } else {
                        linearLayout2.setBackgroundDrawable(null);
                        textView.setTextColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TAB_UNSELECT_TEXT_COLOR));
                        i3 = R.drawable.tpmn_shoppingbagoff;
                    }
                    imageView.setImageResource(i3);
                    if (i6 == 0) {
                        this.n0.addView(linearLayout2);
                        this.r0.add(imageView);
                        this.p0.add(textView);
                        list = this.t0;
                    } else {
                        linearLayout.addView(linearLayout2);
                        this.q0.add(imageView);
                        this.o0.add(textView);
                        list = this.s0;
                    }
                    list.add(linearLayout2);
                    i7++;
                    i4 = 2;
                }
                i6++;
                i4 = 2;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f.addView(this.m0);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            this.q++;
            ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList = this.n;
            if (arrayList == null || arrayList.size() <= 1) {
                return;
            }
            if (this.q >= this.n.size()) {
                this.q = 0;
            }
            com.igaworks.adpopcorn.cores.model.g gVar = this.n.get(this.q);
            this.o = gVar;
            if (gVar != null) {
                this.W.showNext();
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
                        int i3 = this.C;
                        if (i3 == 6) {
                            h();
                            int i4 = this.B;
                            if (i4 != 0) {
                                if (i4 == 50 || i4 == 125) {
                                    if (i2 == 4) {
                                        this.r.b("media_offerwall_tab_content_engagement", this.E);
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("auth", this.G);
                                        jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1597b));
                                        jSONObject.put("channel_code", this.k0);
                                        this.N.a(1, this.t, jSONObject, this);
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
                            int i5 = this.B;
                            if (i5 != 0) {
                                if (i5 == 50) {
                                    if (i3 != 23) {
                                        a(true, this.J.J());
                                        return;
                                    } else {
                                        h();
                                        c(PointerIconCompat.TYPE_ALL_SCROLL);
                                        return;
                                    }
                                }
                                if (i5 == 125) {
                                    this.D = true;
                                    this.r.b("media_offerwall_tab_content_engagement", this.E);
                                    try {
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("auth", this.G);
                                        jSONObject2.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1597b));
                                        jSONObject2.put("channel_code", this.k0);
                                        this.N.a(1, this.t, jSONObject2, this);
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
                        c(1002);
                        return;
                    }
                } catch (Exception unused) {
                    h();
                    return;
                }
            }
            if (i2 == 4) {
                this.r.b("media_offerwall_tab_content_engagement", this.E);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("auth", this.G);
                jSONObject3.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1597b));
                jSONObject3.put("channel_code", this.k0);
                this.N.a(1, this.t, jSONObject3, this);
                return;
            }
            h();
            int i6 = this.C;
            if (i6 == 6) {
                int i7 = this.B;
                if (i7 != 0 && i7 != 50 && i7 != 125) {
                    return;
                }
            } else {
                if (i6 != 7 && i6 != 23) {
                    return;
                }
                int i8 = this.B;
                if (i8 != 0) {
                    if (i8 == 50 || i8 == 125) {
                        c(PointerIconCompat.TYPE_HELP);
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
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1597b, "ApTPMNOfferWallLayout", "callbackJoinCPMCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    String string = jSONObject.getString("CPMParticipatedTid");
                    if (!z2) {
                        com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
                        a(gVar3.p, gVar3.e, false);
                        return;
                    }
                    if (this.J.l() == 16) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(ScarConstants.TOKEN_ID_KEY, string);
                        String string2 = jSONObject2.toString();
                        try {
                            string2 = URLEncoder.encode(jSONObject2.toString(), "utf-8");
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        strF = this.J.f() + "&custom=" + string2;
                    } else {
                        if (this.J.l() == 40) {
                            if (this.J.Y()) {
                                com.igaworks.adpopcorn.cores.common.h.a(this.f1597b, "ApTPMNOfferWallLayout", "callbackJoinCPMCampaign already completed", 3);
                            } else {
                                b(jSONObject.getString("Auth"));
                                this.J.c(true);
                            }
                            gVar = this.J;
                        } else {
                            gVar = this.J;
                        }
                        strF = gVar.f();
                    }
                    d(strF);
                    try {
                        Iterator<String> it = this.J.e().iterator();
                        while (it.hasNext()) {
                            this.N.a(14, it.next(), "", new w(this));
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
            String strD = this.J.d();
            if (this.J == null) {
                com.igaworks.adpopcorn.cores.common.h.a(this.f1597b, "ApTPMNOfferWallLayout", "completeCampaign failed", 3);
                return;
            }
            com.igaworks.adpopcorn.cores.common.h.a(this.f1597b, "ApTPMNOfferWallLayout", "completeCampaign success", 3);
            if (this.N == null) {
                this.N = new com.igaworks.adpopcorn.a.g.a(this.f1597b);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", str);
            jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1597b));
            jSONObject.put("sign", com.igaworks.adpopcorn.cores.common.c.a(strD, str));
            if (com.igaworks.adpopcorn.a.d.E) {
                aVar = this.N;
                str2 = "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/CompleteCPMClick";
            } else {
                aVar = this.N;
                str2 = "https://apapi.adpopcorn.com/ap/v1/common/conversion/CompleteCPMClick";
            }
            aVar.a(28, str2, jSONObject, this);
        } catch (Exception e2) {
            com.igaworks.adpopcorn.cores.common.h.a(this.f1597b, "ApTPMNOfferWallLayout", "completeCampaign failed : " + e2.getMessage(), 3);
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
            Context context = this.f1597b;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.f0, str3, str, 1, str2, new e(z2), a(context, false), false);
            this.c0 = aVar;
            aVar.setCancelable(false);
            this.c0.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z2) {
        LinearLayout linearLayout;
        int i2;
        if (z2) {
            linearLayout = this.T;
            i2 = 8;
        } else {
            linearLayout = this.T;
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            ArrayList<String> arrayList = this.i0;
            if (arrayList == null || arrayList.contains(this.o.c()) || !com.igaworks.adpopcorn.cores.common.k.a(this.W)) {
                return;
            }
            this.i0.add(this.o.c());
        } catch (Exception unused) {
        }
    }

    private void c(int i2) {
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
                    Context context = this.f1597b;
                    com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.f0, str2, str, -1, str3, new h(i2), a(context, false), false);
                    this.c0 = aVar;
                    aVar.setCancelable(false);
                    this.c0.show();
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
                    Context context2 = this.f1597b;
                    com.igaworks.adpopcorn.activity.b.d.a aVar2 = new com.igaworks.adpopcorn.activity.b.d.a(context2, this.f0, str2, str, -1, str4, new i(), str5, new j(), a(context2, false));
                    this.c0 = aVar2;
                    aVar2.setCancelable(false);
                    this.c0.show();
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
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1597b, "ApTPMNOfferWallLayout", "callbackJoinCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    String string = jSONObject.getString("ResultMsg");
                    int i2 = jSONObject.getInt("ResultCode");
                    if (!jSONObject.has("RedirectURL") || jSONObject.isNull("RedirectURL")) {
                        this.H = "";
                    } else {
                        this.H = jSONObject.getString("RedirectURL");
                    }
                    if (!jSONObject.has("HideBrowser") || jSONObject.isNull("HideBrowser")) {
                        this.I = false;
                    } else {
                        this.I = jSONObject.getBoolean("HideBrowser");
                    }
                    if (jSONObject.has("ParticipatedTid") && !jSONObject.isNull("ParticipatedTid")) {
                        String str3 = jSONObject.getLong("ParticipatedTid") + "";
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
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1597b, "ApTPMNOfferWallLayout", "callbackJoinCampaign success, useHiddenBrowser = " + this.I + ", redirectURL = " + this.H, 3);
                    this.G = jSONObject.getString("Auth");
                    if (this.D) {
                        a(true, this.J.J());
                        this.D = false;
                        return;
                    }
                    int i3 = this.C;
                    if (i3 == 10) {
                        h();
                        c(this.H);
                        return;
                    }
                    if (i3 != 16 && i3 != 26 && i3 != 27) {
                        if (i3 == 25) {
                            h();
                            try {
                                if (c(this.J.J())) {
                                    a(false, this.J.J());
                                } else {
                                    d();
                                    com.igaworks.adpopcorn.a.b.a().b(this.c, "participateFlag", this.E, true);
                                    com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
                                    String str4 = gVar3.I;
                                    String str5 = gVar3.u0;
                                    String str6 = gVar3.z;
                                    String str7 = gVar3.y;
                                    Context context = this.f1597b;
                                    com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.f0, str4, str5, -1, str6, new t(), str7, new u(), a(context, false));
                                    this.c0 = aVar;
                                    aVar.setCancelable(false);
                                    this.c0.show();
                                }
                                return;
                            } catch (Exception unused) {
                                return;
                            }
                        }
                        h();
                        if (this.J.X()) {
                            this.J.c(true);
                            try {
                                Iterator<String> it = this.J.e().iterator();
                                while (it.hasNext()) {
                                    this.N.a(14, it.next(), "", new v(this));
                                }
                            } catch (Exception unused2) {
                            }
                        }
                        if (this.J.h0()) {
                            this.H = this.J.M();
                        }
                        if (this.I) {
                            e(this.H);
                            return;
                        }
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(this.H));
                        try {
                            this.f1597b.startActivity(intent);
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
        ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList;
        ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList2;
        try {
            this.z0 = 0L;
            h();
            List<com.igaworks.adpopcorn.cores.model.g> list = this.l;
            if (list != null && (list == null || list.size() != 0)) {
                com.igaworks.adpopcorn.a.c cVar = this.e;
                if (cVar != null && cVar.d()) {
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1597b, "ApTPMNOfferWallLayout", "sign1 : true", 3);
                    com.igaworks.adpopcorn.cores.common.j.f(this.f1597b);
                }
                a();
                if (!a(this.f1597b, false) && ((arrayList2 = this.m) == null || (arrayList2 != null && arrayList2.size() == 0))) {
                    e(z2);
                    return;
                }
                int i2 = this.u0;
                if (((i2 == 3 && this.C0 == 0) || (i2 != 3 && this.C0 == 8)) && ((arrayList = this.m) == null || arrayList.size() == 0)) {
                    if (!a(this.f1597b, false)) {
                        e(false);
                        return;
                    }
                    ArrayList<com.igaworks.adpopcorn.cores.model.g> arrayList3 = this.p;
                    if (arrayList3 == null || arrayList3.size() == 0) {
                        e(false);
                        return;
                    }
                }
                if (this.u0 != 2) {
                    z();
                    if (this.o == null || (linearLayout = this.V) == null) {
                        LinearLayout linearLayout2 = this.V;
                        if (linearLayout2 != null) {
                            linearLayout2.setVisibility(8);
                        }
                    } else {
                        linearLayout.setVisibility(0);
                    }
                }
                if (a(this.f1597b, false)) {
                    if (this.R == 1) {
                        eVar = this.k;
                        eVar.setAdapter((ListAdapter) this.i);
                    }
                } else if (this.R == 1) {
                    eVar = this.j;
                    eVar.setAdapter((ListAdapter) this.i);
                }
                com.igaworks.adpopcorn.activity.a.d.a aVar = this.i;
                if (aVar != null) {
                    aVar.notifyDataSetChanged();
                }
                y();
                return;
            }
            e(z2);
        } catch (Exception e2) {
            e2.printStackTrace();
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
        try {
            Intent launchIntentForPackage = this.f1597b.getPackageManager().getLaunchIntentForPackage(str);
            launchIntentForPackage.setFlags(268435456);
            this.f1597b.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Dialog dialog = this.c0;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.c0.dismiss();
        this.c0 = null;
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
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1597b, "ApTPMNOfferWallLayout", "callbackJoinNewsCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    jSONObject.getString("NewsParticipatedTid");
                    this.G = jSONObject.getString("Auth");
                    if (z2) {
                        com.igaworks.adpopcorn.activity.b.g gVar2 = new com.igaworks.adpopcorn.activity.b.g(this.f1597b, this.f0, this.J, this.d, new x());
                        this.e0 = gVar2;
                        gVar2.show();
                        this.e0.setOnDismissListener(new y());
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
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            this.f1597b.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    private void d(boolean z2) {
        try {
            h();
            d();
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            String str = gVar.I;
            String str2 = gVar.h;
            String str3 = gVar.v;
            String str4 = z2 ? gVar.U : gVar.e;
            Context context = this.f1597b;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.f0, str, str4, -1, str2, new p(), str3, new q(), a(context, false));
            this.c0 = aVar;
            aVar.setCancelable(false);
            this.c0.setCanceledOnTouchOutside(false);
            this.c0.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.igaworks.adpopcorn.a.g.a aVar;
        String str;
        try {
            String str2 = this.G;
            com.igaworks.adpopcorn.cores.model.g gVar = this.J;
            if (gVar == null) {
                com.igaworks.adpopcorn.cores.common.h.a(this.f1597b, "ApTPMNOfferWallLayout", "completeNewsCampaign failed", 3);
                return;
            }
            String strY = gVar.y();
            com.igaworks.adpopcorn.cores.common.h.a(this.f1597b, "ApTPMNOfferWallLayout", "completeNewsCampaign : " + strY, 3);
            if (this.N == null) {
                this.N = new com.igaworks.adpopcorn.a.g.a(this.f1597b);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", this.G);
            jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(this.f1597b));
            jSONObject.put("sign", com.igaworks.adpopcorn.cores.common.c.a(strY, str2));
            if (com.igaworks.adpopcorn.a.d.E) {
                aVar = this.N;
                str = "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/CompleteNewsCampaign";
            } else {
                aVar = this.N;
                str = "https://apapi.adpopcorn.com/ap/v1/common/conversion/CompleteNewsCampaign";
            }
            aVar.a(30, str, jSONObject, this);
        } catch (Exception e2) {
            e2.printStackTrace();
            com.igaworks.adpopcorn.cores.common.h.a(this.f1597b, "ApTPMNOfferWallLayout", "completeNewsCampaign failed : " + e2.getMessage(), 3);
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
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1597b, "ApTPMNOfferWallLayout", "callbackRewardAppExecute result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    int i2 = jSONObject.getInt("ResultCode");
                    String string = jSONObject.getString("ResultMsg");
                    if (z2) {
                        c(PointerIconCompat.TYPE_WAIT);
                        c(false);
                        com.igaworks.adpopcorn.a.d dVar = this.r;
                        if (dVar != null) {
                            dVar.c(false);
                            return;
                        }
                        return;
                    }
                    if (i2 == 2000) {
                        c(1005);
                    } else if (i2 != 2050) {
                        a(this.d.q, string, true);
                        return;
                    } else {
                        com.igaworks.adpopcorn.a.b.a().b(this.c, "participateFlag", this.E, false);
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
            if (this.h0 == null) {
                WebView webView = new WebView(this.c);
                this.h0 = webView;
                webView.getSettings().setJavaScriptEnabled(true);
                this.h0.setWebChromeClient(new WebChromeClient());
                addView(this.h0);
                this.h0.setVisibility(4);
                this.h0.setWebViewClient(new a0());
            }
            com.igaworks.adpopcorn.cores.common.h.a(this.f1597b, "ApTPMNOfferWallLayout", "openWebViewBrowser = " + str, 3);
            this.h0.loadUrl(str);
        } catch (Exception unused) {
        }
    }

    private void e(boolean z2) {
        try {
            h();
            d();
            String str = this.d.I;
            String str2 = this.d.f + "\n" + this.d.d0;
            com.igaworks.adpopcorn.cores.common.g gVar = this.d;
            String str3 = gVar.h;
            String str4 = gVar.G;
            String str5 = z2 ? this.d.n0 + "\n" + this.d.d0 : str2;
            Context context = this.f1597b;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.f0, str, str5, -1, str3, new f(), str4, new g(), a(context, false));
            this.c0 = aVar;
            aVar.setCancelable(false);
            this.c0.show();
        } catch (Exception unused) {
        }
    }

    private void f() {
        if (this.z == null) {
            this.z = new Handler(Looper.getMainLooper());
        }
        if (this.A == null) {
            this.A = new RunnableC0431b();
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
                    com.igaworks.adpopcorn.cores.common.h.a(this.f1597b, "ApTPMNOfferWallLayout", "callbackRewardAppInstall result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z2 = jSONObject.getBoolean("Result");
                    int i2 = jSONObject.getInt("ResultCode");
                    String string = jSONObject.getString("ResultMsg");
                    if (z2) {
                        if (this.C != 23) {
                            c(PointerIconCompat.TYPE_WAIT);
                            com.igaworks.adpopcorn.a.b.a().b(this.f1597b, this.J.c());
                            c(false);
                            com.igaworks.adpopcorn.a.d dVar = this.r;
                            if (dVar != null) {
                                dVar.c(false);
                                return;
                            }
                            return;
                        }
                        bVarA = com.igaworks.adpopcorn.a.b.a();
                        context = this.f1597b;
                        gVar = this.J;
                    } else {
                        if (this.C != 23) {
                            if (i2 == 2000) {
                                c(1005);
                                com.igaworks.adpopcorn.a.b.a().b(this.f1597b, this.J.c());
                            } else {
                                if (i2 != 2050) {
                                    a(this.d.q, string, true);
                                    return;
                                }
                                com.igaworks.adpopcorn.a.b.a().b(this.c, "participateFlag", this.E, false);
                            }
                            c(false);
                            return;
                        }
                        if (i2 != 2000) {
                            if (i2 == 2050) {
                                com.igaworks.adpopcorn.a.b.a().b(this.c, "participateFlag", this.E, false);
                                return;
                            }
                            return;
                        } else {
                            bVarA = com.igaworks.adpopcorn.a.b.a();
                            context = this.f1597b;
                            gVar = this.J;
                        }
                    }
                    bVarA.b(context, gVar.c());
                    return;
                } catch (JSONException e2) {
                    if (this.C != 23) {
                        com.igaworks.adpopcorn.cores.common.g gVar2 = this.d;
                        a(gVar2.I, gVar2.p, true);
                    }
                    e2.printStackTrace();
                    return;
                }
            }
            if (this.C == 23) {
                return;
            }
            com.igaworks.adpopcorn.cores.common.g gVar3 = this.d;
            str = gVar3.I;
            str2 = gVar3.g;
        } else {
            if (this.C == 23) {
                return;
            }
            com.igaworks.adpopcorn.cores.common.g gVar4 = this.d;
            str = gVar4.p;
            str2 = gVar4.e;
        }
        a(str, str2, false);
    }

    private void g(com.igaworks.adpopcorn.cores.model.f fVar) {
        com.igaworks.adpopcorn.cores.model.j jVarA;
        if (fVar != null && fVar.d()) {
            d(true);
        } else if (fVar != null && fVar.a().length() > 0) {
            try {
                com.igaworks.adpopcorn.cores.common.h.a(this.f1597b, "ApTPMNOfferWallLayout", "callbackVideoAdDetailInfoRequest result = " + fVar.a(), 3);
                if (new JSONObject(fVar.a()).getBoolean("Result") && (jVarA = com.igaworks.adpopcorn.a.f.f.a(fVar.a())) != null) {
                    a(this.J.c(), this.G, jVarA.c(), jVarA.h(), jVarA.e(), jVarA.f(), jVarA.g(), jVarA.j(), jVarA.k(), jVarA.l(), jVarA.r(), jVarA.a(), jVarA.s(), this.J.P(), jVarA.o(), jVarA.q(), jVarA.i(), this.J.N());
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
            com.igaworks.adpopcorn.activity.b.d.c cVar = this.d0;
            if (cVar != null) {
                cVar.dismiss();
                this.d0 = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            Activity activity = this.g0;
            if (activity != null) {
                activity.finish();
                this.g0.overridePendingTransition(0, 0);
                com.igaworks.adpopcorn.a.d dVar = this.r;
                if (dVar != null) {
                    dVar.c((String) null);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        String str;
        if (com.igaworks.adpopcorn.a.d.E) {
            this.s = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/checkcampaign";
            this.t = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/joincampaign";
            this.u = "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/completeinstallcampaign";
            this.v = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/video/getrewardvideodetail";
            this.w = "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/completeexecutecampaign";
            str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/joincpmcampaign";
        } else {
            this.s = "https://apapi.adpopcorn.com/ap/v1/sdk/media/checkcampaign";
            this.t = "https://apapi.adpopcorn.com/ap/v1/sdk/media/joincampaign";
            this.u = "https://apapi.adpopcorn.com/ap/v1/common/conversion/completeinstallcampaign";
            this.v = "https://apapi.adpopcorn.com/ap/v1/sdk/video/getrewardvideodetail";
            this.w = "https://apapi.adpopcorn.com/ap/v1/common/conversion/completeexecutecampaign";
            str = "https://apapi.adpopcorn.com/ap/v1/sdk/media/joincpmcampaign";
        }
        this.x = str;
        this.y = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/joinnewscampaign";
    }

    private void l() {
        this.O = false;
        this.P = false;
        this.R = 1;
        long jA = com.igaworks.adpopcorn.a.b.a().a(this.f1597b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_quantity", 0L);
        boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.ALWAYS_SHOW_SPLASH_DIALOG);
        int i2 = Calendar.getInstance().get(6);
        if (zB) {
            this.x0 = false;
        } else if (i2 == com.igaworks.adpopcorn.a.b.a().a(this.f1597b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_imp_day", 0)) {
            this.x0 = true;
        }
        if (this.P || this.R > this.S) {
            b(true);
        } else {
            com.igaworks.adpopcorn.cores.common.h.a(this.f1597b, "ApTPMNOfferWallLayout", "initCampaignLoading", 3);
            if (com.igaworks.adpopcorn.cores.common.c.c(this.f1597b)) {
                if (this.u0 == 3 || jA == 0 || this.x0) {
                    a(this.d.f1613b, false);
                }
                if (!this.e.i()) {
                    this.N.a(this.R, this);
                }
            } else {
                com.igaworks.adpopcorn.cores.common.g gVar = this.d;
                b(gVar.g, gVar.h, true);
            }
        }
        try {
            if (this.u0 == 3 || this.x0) {
                return;
            }
            Dialog dialog = this.K;
            if (dialog == null || !dialog.isShowing()) {
                Dialog dialog2 = this.L;
                if (dialog2 == null || !dialog2.isShowing()) {
                    Dialog dialog3 = this.c0;
                    if ((dialog3 == null || !dialog3.isShowing()) && jA > 0) {
                        com.igaworks.adpopcorn.activity.b.i iVar = new com.igaworks.adpopcorn.activity.b.i(this.f1597b, jA, com.igaworks.adpopcorn.a.b.a().a(this.f1597b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_currency", ""), this.f0);
                        iVar.show();
                        iVar.setOnDismissListener(new d0());
                        com.igaworks.adpopcorn.a.b.a().b(this.f1597b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_imp_day", i2);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void m() {
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.BOTTOM_BAR_HEIGHT);
        if (this.u0 == 1) {
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
        this.g.setPadding(0, 0, 0, com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, iC));
        this.f.addView(this.g);
        this.f.addView(a(iC));
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_LR_PADDING);
        if (this.u0 == 2) {
            iC2 = 0;
        }
        int iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_FOOTER_MARGIN_DP);
        LinearLayout linearLayout = new LinearLayout(this.c);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, iC3)));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        if (a(this.f1597b, false)) {
            com.igaworks.adpopcorn.activity.c.e eVar = new com.igaworks.adpopcorn.activity.c.e(this.c);
            this.k = eVar;
            eVar.setLayoutParams(layoutParams2);
            this.k.setSelector(new StateListDrawable());
            this.k.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, 8), com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, 8), com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, 8), 0);
            this.k.setNumColumns(2);
            this.k.setHorizontalSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, 8));
            this.k.setVerticalSpacing(0);
            this.k.b(q());
            this.k.a(linearLayout);
            this.g.addView(this.k);
            this.i = new com.igaworks.adpopcorn.activity.a.d.a(this.c, this.m, this.d, true, this.u0, this.v0, false);
            this.k.setOnItemClickListener(this.J0);
            this.k.setOnScrollListener(this.K0);
        } else {
            com.igaworks.adpopcorn.activity.c.e eVar2 = new com.igaworks.adpopcorn.activity.c.e(this.c);
            this.j = eVar2;
            eVar2.setVerticalScrollBarEnabled(false);
            this.j.setLayoutParams(layoutParams2);
            this.j.setSelector(new StateListDrawable());
            this.j.setNumColumns(1);
            this.j.setHorizontalSpacing(0);
            this.j.setVerticalSpacing(0);
            this.j.b(r());
            this.g.addView(this.j);
            this.i = new com.igaworks.adpopcorn.activity.a.d.a(this.c, this.m, this.d, false, this.u0, this.v0, false);
            this.j.setSelector(new StateListDrawable());
            this.j.setOnItemClickListener(this.J0);
            this.j.setOnScrollListener(this.K0);
            this.j.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, iC2), 0, com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, iC2), 0);
        }
        addView(this.f);
    }

    private void n() {
        com.igaworks.adpopcorn.a.d dVarA = com.igaworks.adpopcorn.a.d.a(this.f1597b);
        this.r = dVarA;
        this.e = dVarA.e();
        com.igaworks.adpopcorn.cores.common.e.b(this.f1597b);
        com.igaworks.adpopcorn.cores.common.d.a();
        com.igaworks.adpopcorn.cores.common.d.a((Activity) this.f1597b);
        com.igaworks.adpopcorn.cores.common.g gVarA = com.igaworks.adpopcorn.cores.common.g.a();
        this.d = gVarA;
        gVarA.d();
        this.R = 1;
        this.P = false;
        this.b0 = false;
        this.Q = false;
        this.k0 = 1;
        this.m = new ArrayList<>();
        this.n = new ArrayList<>();
        this.o = new com.igaworks.adpopcorn.cores.model.g();
        this.p = new ArrayList<>();
        this.i0 = new ArrayList<>();
        this.j0 = new ArrayList<>();
        this.a = ((WindowManager) this.f1597b.getSystemService("window")).getDefaultDisplay().getWidth();
        if (this.u0 == 1) {
            setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, 9), com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, 15), com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, 9), com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, 15));
            this.a -= com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, 18);
        }
        if (this.N == null) {
            this.N = new com.igaworks.adpopcorn.a.g.a(this.f1597b);
        }
        this.f0 = com.igaworks.adpopcorn.activity.b.d.a(this.f1597b);
        com.igaworks.adpopcorn.a.b.a().b(this.f1597b, "adpopcorn_sdk_flag", "isAdPopcornUser", true);
        f();
        try {
            int i2 = Calendar.getInstance().get(6);
            if (i2 != com.igaworks.adpopcorn.a.b.a().a(this.f1597b, "adpopcorn_sdk_flag", "adpopcorn_last_visit_day", -1)) {
                com.igaworks.adpopcorn.a.b.a().e(this.f1597b, "adpopcorn_choice_impression_sp");
                com.igaworks.adpopcorn.a.b.a().b(this.f1597b, "adpopcorn_sdk_flag", "adpopcorn_last_visit_day", i2);
            }
        } catch (Exception unused) {
        }
    }

    private RelativeLayout p() {
        com.igaworks.adpopcorn.activity.layout.g.c cVar = new com.igaworks.adpopcorn.activity.layout.g.c(this.c);
        LinearLayout linearLayout = (LinearLayout) cVar.findViewById(0);
        TextView textView = (TextView) cVar.findViewById(2);
        TextView textView2 = (TextView) cVar.findViewById(3);
        TextView textView3 = (TextView) cVar.findViewById(5);
        this.G0 = (TextView) cVar.findViewById(7);
        this.F0 = (TextView) cVar.findViewById(8);
        linearLayout.setOnClickListener(new f0());
        textView.setOnClickListener(new g0());
        textView2.setOnClickListener(new h0());
        textView3.setOnClickListener(new a());
        return cVar;
    }

    private View q() {
        try {
            LinearLayout linearLayout = this.V;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
                this.V = null;
            }
            com.igaworks.adpopcorn.activity.layout.g.d dVar = new com.igaworks.adpopcorn.activity.layout.g.d(this.c, this.a, a(this.f1597b, false), this.u0, this.d, new c());
            this.U = dVar;
            this.V = (LinearLayout) dVar.findViewById(0);
            this.W = (ViewFlipper) this.U.findViewById(1);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setFillAfter(true);
            translateAnimation.setDuration(1000L);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation2.setFillAfter(false);
            translateAnimation2.setDuration(1000L);
            this.W.setInAnimation(translateAnimation);
            this.W.setOutAnimation(translateAnimation2);
            return this.U;
        } catch (Exception e2) {
            e2.printStackTrace();
            View view = new View(this.c);
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
            return view;
        }
    }

    private LinearLayout r() {
        LinearLayout linearLayout;
        View viewQ;
        this.l0 = new LinearLayout(this.c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.l0.setOrientation(1);
        this.l0.setGravity(17);
        this.l0.setLayoutParams(layoutParams);
        this.l0.setBackgroundColor(Color.parseColor("#e6fcfcfc"));
        this.l0.addView(p());
        int i2 = this.u0;
        if (i2 == 0 || i2 == 1 || i2 != 2) {
            this.l0.addView(b(0));
            linearLayout = this.l0;
            viewQ = q();
        } else {
            linearLayout = this.l0;
            viewQ = b(0);
        }
        linearLayout.addView(viewQ);
        return this.l0;
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
            Context context = this.f1597b;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, this.f0, str, str2, -1, str3, new r(), str4, new s(), a(context, false));
            this.c0 = aVar;
            aVar.setCancelable(false);
            this.c0.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        try {
            boolean z2 = this.f0 == 16973841;
            Context context = this.f1597b;
            com.igaworks.adpopcorn.activity.b.l.b bVar = new com.igaworks.adpopcorn.activity.b.l.b(context, this.f0, a(context, false), this.d, z2, this);
            this.L = bVar;
            bVar.setOnDismissListener(new e0());
            this.L.show();
            A();
        } catch (Exception unused) {
        }
    }

    private void w() {
        h();
        try {
            com.igaworks.adpopcorn.activity.b.l.a aVar = a(this.f1597b, true) ? new com.igaworks.adpopcorn.activity.b.l.a(this.f1597b, this.f0, this.J, this.d, this.I0, true, this.w0) : new com.igaworks.adpopcorn.activity.b.l.a(this.f1597b, this.f0, this.J, this.d, this.I0, false, this.w0);
            this.K = aVar;
            aVar.show();
            this.K.setOnDismissListener(new m());
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
            if (this.R != 1 || this.z0 <= 0) {
                return;
            }
            try {
                try {
                    com.igaworks.adpopcorn.cores.common.k.b(this.F0, new DecimalFormat("###,###").format(this.z0) + " ", 15, Color.parseColor("#5e5e5e"), null, 0, 0, TextUtils.TruncateAt.END, true);
                    com.igaworks.adpopcorn.cores.common.k.b(this.G0, this.y0, 15, Color.parseColor("#5e5e5e"), null, 0, 0, TextUtils.TruncateAt.END, true);
                    com.igaworks.adpopcorn.a.b.a().b(this.f1597b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_quantity", this.z0);
                    bVarA = com.igaworks.adpopcorn.a.b.a();
                } catch (Exception unused) {
                    com.igaworks.adpopcorn.cores.common.k.b(this.F0, " ", 15, Color.parseColor("#5e5e5e"), null, 0, 0, TextUtils.TruncateAt.END, true);
                    com.igaworks.adpopcorn.cores.common.k.b(this.G0, this.y0, 15, Color.parseColor("#5e5e5e"), null, 0, 0, TextUtils.TruncateAt.END, true);
                    com.igaworks.adpopcorn.a.b.a().b(this.f1597b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_quantity", this.z0);
                    bVarA = com.igaworks.adpopcorn.a.b.a();
                }
                bVarA.b(this.f1597b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_currency", this.y0);
            } catch (Throwable th) {
                com.igaworks.adpopcorn.cores.common.k.b(this.F0, " ", 15, Color.parseColor("#5e5e5e"), null, 0, 0, TextUtils.TruncateAt.END, true);
                com.igaworks.adpopcorn.cores.common.k.b(this.G0, this.y0, 15, Color.parseColor("#5e5e5e"), null, 0, 0, TextUtils.TruncateAt.END, true);
                com.igaworks.adpopcorn.a.b.a().b(this.f1597b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_quantity", this.z0);
                com.igaworks.adpopcorn.a.b.a().b(this.f1597b, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_currency", this.y0);
                throw th;
            }
        } catch (Exception unused2) {
        }
    }

    private void z() {
        try {
            Handler handler = this.z;
            if (handler != null) {
                handler.removeCallbacks(this.A);
                this.z.postDelayed(this.A, 5000L);
            }
        } catch (Exception unused) {
        }
    }

    public void a(Configuration configuration) {
        try {
            com.igaworks.adpopcorn.cores.common.d.a();
            com.igaworks.adpopcorn.cores.common.d.a((Activity) this.f1597b);
            this.a = ((WindowManager) this.f1597b.getSystemService("window")).getDefaultDisplay().getWidth();
            if (this.u0 == 1) {
                setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, 9), com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, 15), com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, 9), com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, 15));
                this.a -= com.igaworks.adpopcorn.cores.common.d.a(this.f1597b, 9);
            }
            this.R = 1;
            this.P = false;
            this.k0 = 1;
            k();
            Dialog dialog = this.K;
            if (dialog != null && dialog.isShowing()) {
                this.K.dismiss();
                this.K = null;
            }
            Dialog dialog2 = this.L;
            if (dialog2 != null && dialog2.isShowing()) {
                this.L.dismiss();
                this.L = null;
            }
            com.igaworks.adpopcorn.activity.b.g gVar = this.e0;
            if (gVar != null && gVar.isShowing()) {
                this.e0.dismiss();
                this.e0 = null;
            }
            A();
            removeAllViewsInLayout();
            removeAllViews();
            invalidate();
            m();
            u();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, boolean z2) {
        try {
            h();
            if (((Activity) this.f1597b).isFinishing()) {
                return;
            }
            com.igaworks.adpopcorn.activity.b.d.c cVar = new com.igaworks.adpopcorn.activity.b.d.c(this.f1597b, this.f0);
            this.d0 = cVar;
            cVar.setCancelable(z2);
            this.d0.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean a(Context context, boolean z2) {
        Activity activity;
        if (Build.VERSION.SDK_INT >= 24 && (activity = this.g0) != null && activity.isInMultiWindowMode()) {
            return false;
        }
        if (!z2) {
            return this.a0;
        }
        Configuration configuration = ((Activity) context).getResources().getConfiguration();
        return configuration != null && configuration.orientation == 2;
    }

    public void g() {
        try {
            h();
            A();
            if (this.A != null) {
                this.A = null;
            }
            Dialog dialog = this.K;
            if (dialog != null && dialog.isShowing()) {
                this.K.dismiss();
                this.K = null;
            }
            Dialog dialog2 = this.L;
            if (dialog2 != null && dialog2.isShowing()) {
                this.L.dismiss();
                this.L = null;
            }
            HashMap<String, String> map = this.M;
            if (map != null && map.size() > 0) {
                this.M.clear();
                this.M = null;
            }
            com.igaworks.adpopcorn.activity.a.d.a aVar = this.i;
            if (aVar != null) {
                aVar.a();
            }
            WebView webView = this.h0;
            if (webView != null) {
                webView.destroy();
                this.h0 = null;
            }
            com.igaworks.adpopcorn.a.a.a();
            com.igaworks.adpopcorn.cores.common.e.a(this.f1597b);
            com.igaworks.adpopcorn.cores.common.i.a(this);
        } catch (Exception unused) {
        }
    }

    public int getOfferwallType() {
        return this.u0;
    }

    public void i() {
        try {
            com.igaworks.adpopcorn.a.d dVar = this.r;
            if (dVar != null) {
                dVar.c((String) null);
            }
            Activity activity = this.g0;
            if (activity == null) {
                a(new Configuration());
            } else {
                activity.finish();
                this.g0.overridePendingTransition(0, 0);
            }
        } catch (Exception unused) {
        }
    }

    public void o() {
        try {
            n();
            k();
            m();
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

    public void setApOfferWallOrientation(boolean z2) {
        this.a0 = z2;
    }

    public void setOfferwallActivity(Activity activity) {
        this.g0 = activity;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000b A[PHI: r1
      0x000b: PHI (r1v3 int) = (r1v0 int), (r1v1 int) binds: [B:6:0x0009, B:9:0x000f] A[DONT_GENERATE, DONT_INLINE]] */
    public void setOfferwallType(int i2) {
        this.u0 = i2;
        if (i2 == 0) {
            this.v0 = 0;
        } else {
            int i3 = 1;
            if (i2 == 1) {
                this.v0 = i3;
            } else {
                i3 = 2;
                if (i2 == 2) {
                    this.v0 = i3;
                } else if (i2 == 3) {
                    this.v0 = 4;
                }
            }
        }
        APOfferwallTabInfo aPOfferwallTabInfo = this.B0;
        if (aPOfferwallTabInfo != null) {
            this.C0 = aPOfferwallTabInfo.getTabType(0);
        }
    }

    public void setTabOfferwallInfo(APOfferwallTabInfo aPOfferwallTabInfo) {
        this.B0 = aPOfferwallTabInfo;
    }

    public void t() {
        try {
            com.igaworks.adpopcorn.activity.b.g gVar = this.e0;
            if (gVar == null || !gVar.isShowing()) {
                return;
            }
            this.e0.j();
        } catch (Exception unused) {
        }
    }

    public void u() {
        Activity activity;
        try {
            this.w0 = false;
            if (Build.VERSION.SDK_INT >= 24 && (activity = this.g0) != null && activity.isInMultiWindowMode()) {
                this.w0 = true;
            }
            if (a(this.f1597b, true)) {
                Toast.makeText(this.f1597b, this.d.x1, 1).show();
                j();
                return;
            }
            com.igaworks.adpopcorn.activity.b.g gVar = this.e0;
            if (gVar != null && gVar.isShowing()) {
                this.e0.k();
                return;
            }
            com.igaworks.adpopcorn.a.d dVar = this.r;
            if (dVar != null) {
                dVar.c(false);
            }
            if (com.igaworks.adpopcorn.a.b.a().a(this.f1597b, "adpopcorn_parameter", "check_user_agreement", false)) {
                l();
                return;
            }
            d();
            com.igaworks.adpopcorn.cores.common.g gVar2 = this.d;
            String str = gVar2.Z0;
            String str2 = gVar2.l1;
            String str3 = gVar2.k1;
            Context context = this.f1597b;
            com.igaworks.adpopcorn.activity.b.d.f fVar = new com.igaworks.adpopcorn.activity.b.d.f(context, this.f0, str, "", -1, str2, new k(), str3, new l(), a(context, false));
            this.c0 = fVar;
            fVar.setCancelable(false);
            this.c0.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
