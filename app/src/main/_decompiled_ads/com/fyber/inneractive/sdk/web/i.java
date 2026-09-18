package com.fyber.inneractive.sdk.web;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.window.OnBackInvokedCallback;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.network.l0;
import com.fyber.inneractive.sdk.network.q0;
import com.fyber.inneractive.sdk.ui.IAcloseButton;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.k0;
import com.fyber.inneractive.sdk.web.i.f;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.iab.omid.library.fyber.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.fyber.adsession.Partner;
import com.tapjoy.TJAdUnitConstants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i<T extends f> extends c0<T> {
    public static final String[] n0 = {"yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"};
    public com.fyber.inneractive.sdk.mraid.b0 N;
    public final d O;
    public final h P;
    public g Q;
    public ViewGroup R;
    public com.fyber.inneractive.sdk.web.g S;
    public boolean T;
    public int U;
    public i<T>.C0309i V;
    public IAcloseButton W;
    public boolean X;
    public float Y;
    public int Z;
    public int a0;
    public int b0;
    public int c0;
    public int d0;
    public int e0;
    public Orientation f0;
    public int g0;
    public FrameLayout h0;
    public FrameLayout i0;
    public RelativeLayout j0;
    public int k0;
    public int l0;
    public OnBackInvokedCallback m0;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.r();
        }
    }

    public class b implements View.OnKeyListener {
        public b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 4 || !i.this.o()) {
                return false;
            }
            IAlog.d("back button pressed while ad is expanded, ad will be collapsed.", new Object[0]);
            i.this.r();
            return true;
        }
    }

    public class c implements com.fyber.inneractive.sdk.network.w<String> {
        public c() {
        }

        @Override // com.fyber.inneractive.sdk.network.w
        public void a(String str, Exception exc, boolean z) {
            String str2 = str;
            if (exc != null || TextUtils.isEmpty(str2)) {
                com.fyber.inneractive.sdk.util.m.f1343b.post(new p(this));
                return;
            }
            i iVar = i.this;
            if (iVar.l() != null) {
                e eVar = new e(iVar, str2, null);
                MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(iVar.l().getApplicationContext(), eVar);
                eVar.f1362b = mediaScannerConnection;
                mediaScannerConnection.connect();
            }
        }
    }

    public enum d {
        ENABLED,
        DISABLED
    }

    public class e implements MediaScannerConnection.MediaScannerConnectionClient {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MediaScannerConnection f1362b;

        public e(i iVar, String str, String str2) {
            this.a = str;
        }

        @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
        public void onMediaScannerConnected() {
            MediaScannerConnection mediaScannerConnection = this.f1362b;
            if (mediaScannerConnection != null) {
                mediaScannerConnection.scanFile(this.a, null);
            }
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(String str, Uri uri) {
            MediaScannerConnection mediaScannerConnection = this.f1362b;
            if (mediaScannerConnection != null) {
                mediaScannerConnection.disconnect();
            }
        }
    }

    public interface f extends d0 {
        void a(InneractiveUnitController.AdDisplayError adDisplayError);

        void a(i iVar);

        void a(i iVar, com.fyber.inneractive.sdk.mraid.b0 b0Var);

        void a(i iVar, boolean z);

        void a(i iVar, boolean z, Orientation orientation);

        boolean a(String str);

        void b(i iVar);

        void c();
    }

    public enum g {
        INLINE,
        INTERSTITIAL
    }

    public enum h {
        ALWAYS_VISIBLE,
        ALWAYS_HIDDEN,
        AD_CONTROLLED
    }

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.web.i$i, reason: collision with other inner class name */
    public class C0309i extends BroadcastReceiver {
        public Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1363b = -1;

        public C0309i() {
        }

        public void a() {
            try {
                i iVar = i.this;
                iVar.getClass();
                IAlog.a("%sunregister screen broadcast receiver called", IAlog.a(iVar));
                if (this.a != null) {
                    i iVar2 = i.this;
                    iVar2.getClass();
                    IAlog.a("%sunregistering broadcast receiver", IAlog.a(iVar2));
                    this.a.unregisterReceiver(this);
                    this.a = null;
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int rotation;
            if ((this.a != null) && "android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()) && (rotation = ((WindowManager) IAConfigManager.M.v.a().getSystemService("window")).getDefaultDisplay().getRotation()) != this.f1363b) {
                this.f1363b = rotation;
                i iVar = i.this;
                com.fyber.inneractive.sdk.web.g gVar = iVar.f1358b;
                if (gVar != null) {
                    gVar.getViewTreeObserver().addOnPreDrawListener(new com.fyber.inneractive.sdk.web.j(iVar, context));
                }
            }
        }
    }

    public class j implements com.fyber.inneractive.sdk.web.d.c {
        public com.fyber.inneractive.sdk.mraid.a a;

        public j(com.fyber.inneractive.sdk.mraid.a aVar, k0 k0Var) {
            this.a = aVar;
        }

        @Override // com.fyber.inneractive.sdk.web.d.c
        public String a() {
            return this.a.c();
        }

        @Override // com.fyber.inneractive.sdk.web.d.c
        public void b() {
            com.fyber.inneractive.sdk.mraid.a aVar = this.a;
            if (aVar != null) {
                aVar.d();
            }
        }

        @Override // com.fyber.inneractive.sdk.web.d.c
        public String c() {
            return this.a.a;
        }

        @Override // com.fyber.inneractive.sdk.web.d.c
        public void d() {
            IAmraidWebViewController iAmraidWebViewController = (IAmraidWebViewController) i.this;
            if (iAmraidWebViewController.I != null) {
                iAmraidWebViewController.I.b();
            }
            this.a.a();
        }

        public String toString() {
            return "action = " + this.a.a + " url = " + this.a.c();
        }
    }

    public interface k extends f {
        void a();
    }

    public static abstract class l implements f {
        @Override // com.fyber.inneractive.sdk.web.d0
        public void a(boolean z) {
        }
    }

    public i(Context context, boolean z, boolean z2, g gVar, d dVar, h hVar, com.fyber.inneractive.sdk.measurement.a aVar) {
        super(context, z, z2, gVar);
        this.N = com.fyber.inneractive.sdk.mraid.b0.HIDDEN;
        this.T = false;
        this.Z = -1;
        this.a0 = -1;
        this.b0 = -1;
        this.c0 = -1;
        this.d0 = -1;
        this.e0 = -1;
        this.f0 = Orientation.NONE;
        this.H = aVar;
        this.Q = gVar;
        this.O = dVar;
        this.P = hVar;
    }

    @Override // com.fyber.inneractive.sdk.web.d, com.fyber.inneractive.sdk.web.g.a
    public void a(boolean z) {
        a(new com.fyber.inneractive.sdk.mraid.c0(z));
        super.a(z);
    }

    @Override // com.fyber.inneractive.sdk.web.d
    public void b(boolean z) {
        com.fyber.inneractive.sdk.util.m.f1343b.post(new com.fyber.inneractive.sdk.web.l(this));
        com.fyber.inneractive.sdk.web.g gVar = this.S;
        if (gVar != null && gVar.getParent() != null && (this.S.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.S.getParent()).removeView(this.S);
            this.S = null;
        }
        t();
        this.a = false;
        if (Build.VERSION.SDK_INT >= 33) {
            u();
        }
        super.b(z);
    }

    public final Date c(String str) {
        Date date = null;
        int i = 0;
        while (true) {
            String[] strArr = n0;
            if (i >= strArr.length) {
                break;
            }
            try {
                date = new SimpleDateFormat(strArr[i], Locale.getDefault()).parse(str);
                if (date != null) {
                    break;
                }
                i++;
            } catch (ParseException unused) {
            }
        }
        return date;
    }

    public void d(boolean z) {
        if (this.R == null) {
            return;
        }
        if (z) {
            int iB = com.fyber.inneractive.sdk.util.l.b(35);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iB, iB);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.rightMargin = com.fyber.inneractive.sdk.util.l.b(10);
            layoutParams.topMargin = com.fyber.inneractive.sdk.util.l.b(10);
            if (this.W == null) {
                IAcloseButton iAcloseButton = new IAcloseButton(l(), iB, true);
                this.W = iAcloseButton;
                iAcloseButton.setOnClickListener(new a());
            }
            com.fyber.inneractive.sdk.util.q.a(this.W);
            this.j0.addView(this.W, layoutParams);
        } else {
            this.j0.removeView(this.W);
        }
        L l2 = this.g;
        if (l2 != 0) {
            ((f) l2).a(this, z);
        }
        this.X = !z;
    }

    public final void e(boolean z) {
        try {
            Activity activity = (Activity) l();
            if (activity != null) {
                if (!z || activity.getResources() == null || activity.getResources().getConfiguration() == null) {
                    activity.setRequestedOrientation(this.U);
                } else {
                    activity.setRequestedOrientation(activity.getResources().getConfiguration().orientation);
                }
            }
        } catch (Exception unused) {
            IAlog.a("Failed to modify the device orientation.", new Object[0]);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.d
    public k0 f() {
        com.fyber.inneractive.sdk.web.g gVar;
        if (this.N == com.fyber.inneractive.sdk.mraid.b0.EXPANDED && (gVar = this.S) != null) {
            return gVar.getLastClickedLocation();
        }
        com.fyber.inneractive.sdk.web.g gVar2 = this.f1358b;
        return gVar2 != null ? gVar2.getLastClickedLocation() : k0.a();
    }

    @Override // com.fyber.inneractive.sdk.web.d
    public void g() {
        com.fyber.inneractive.sdk.measurement.tracker.c bVar;
        com.fyber.inneractive.sdk.measurement.a aVar = this.H;
        if (aVar != null) {
            com.fyber.inneractive.sdk.web.g gVar = this.f1358b;
            com.fyber.inneractive.sdk.flow.q qVar = this.s;
            com.fyber.inneractive.sdk.measurement.b bVar2 = (com.fyber.inneractive.sdk.measurement.b) aVar;
            bVar2.getClass();
            boolean z = false;
            IAlog.a("omsdk initMraidSession", new Object[0]);
            if (bVar2.e == null) {
                IAlog.a("omsdk partner is null", new Object[0]);
                bVar = null;
            } else {
                if (qVar != null && qVar.d() != null && qVar.d().H) {
                    z = true;
                }
                com.fyber.inneractive.sdk.measurement.tracker.d dVar = bVar2.f;
                Partner partner = bVar2.e;
                dVar.getClass();
                bVar = z ? new com.fyber.inneractive.sdk.measurement.tracker.b(partner, gVar, qVar) : new com.fyber.inneractive.sdk.measurement.tracker.a(partner, gVar, qVar);
                bVar.a(gVar);
            }
            this.I = bVar;
        }
        com.fyber.inneractive.sdk.web.d.InterfaceC0308d interfaceC0308d = this.f;
        if (interfaceC0308d != null) {
            interfaceC0308d.a(this);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.d
    public void h() {
        super.h();
        this.N = com.fyber.inneractive.sdk.mraid.b0.LOADING;
        Context contextL = l();
        this.U = contextL instanceof Activity ? ((Activity) contextL).getRequestedOrientation() : -1;
        IAConfigManager iAConfigManager = IAConfigManager.M;
        this.i0 = new FrameLayout(iAConfigManager.v.a());
        this.j0 = new RelativeLayout(iAConfigManager.v.a());
        FrameLayout frameLayout = new FrameLayout(iAConfigManager.v.a());
        frameLayout.setBackgroundColor(-858993460);
        this.h0 = frameLayout;
        a(contextL, false);
        this.f1358b.setOnKeyListener(new b());
    }

    @Override // com.fyber.inneractive.sdk.web.c0
    public void k() {
        com.fyber.inneractive.sdk.web.g gVar = this.f1358b;
        if (gVar != null) {
            gVar.a("window.mraidbridge.fireReadyEvent();");
        }
    }

    @Override // com.fyber.inneractive.sdk.web.c0
    public Context l() {
        com.fyber.inneractive.sdk.web.g gVar = this.f1358b;
        if (gVar != null) {
            return gVar.getContext();
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.web.c0
    public boolean o() {
        return this.N == com.fyber.inneractive.sdk.mraid.b0.EXPANDED;
    }

    @Override // com.fyber.inneractive.sdk.web.c0
    public boolean p() {
        g gVar = this.Q;
        return gVar != null && gVar.equals(g.INTERSTITIAL);
    }

    public void r() {
        com.fyber.inneractive.sdk.web.g gVar;
        RelativeLayout relativeLayoutA = a(this.R);
        if (relativeLayoutA == null) {
            relativeLayoutA = a((View) this.f1358b);
        }
        this.T = false;
        if (o() || s()) {
            d(false);
            com.fyber.inneractive.sdk.web.g gVar2 = this.f1358b;
            if (gVar2 != null) {
                com.fyber.inneractive.sdk.mraid.b0 b0Var = this.N;
                if (b0Var == com.fyber.inneractive.sdk.mraid.b0.EXPANDED) {
                    t();
                    ViewGroup viewGroup = (ViewGroup) this.h0.getParent();
                    if (viewGroup != null) {
                        viewGroup.addView(this.f1358b, this.g0, com.fyber.inneractive.sdk.util.q.a(this.k0, this.l0, 13));
                        viewGroup.removeView(this.h0);
                        viewGroup.invalidate();
                        this.f1358b.requestLayout();
                    }
                    this.d0 = this.k0;
                    this.e0 = this.l0;
                } else if (b0Var == com.fyber.inneractive.sdk.mraid.b0.RESIZED) {
                    this.d0 = this.k0;
                    this.e0 = this.l0;
                    ViewGroup.LayoutParams layoutParams = gVar2.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        this.f1358b.setLayoutParams(com.fyber.inneractive.sdk.util.q.a(this.k0, this.l0, 13));
                    } else if (layoutParams instanceof FrameLayout.LayoutParams) {
                        this.f1358b.setLayoutParams(new FrameLayout.LayoutParams(this.k0, this.l0, 17));
                    }
                }
            }
            if (relativeLayoutA != null && (gVar = this.f1358b) != null) {
                relativeLayoutA.setLayoutParams(gVar.getLayoutParams());
                if (o()) {
                    this.R.removeView(relativeLayoutA);
                    this.f1358b.addView(relativeLayoutA);
                }
            }
            this.N = com.fyber.inneractive.sdk.mraid.b0.DEFAULT;
            e(false);
            a(new com.fyber.inneractive.sdk.mraid.z(this.N));
        } else if (this.N == com.fyber.inneractive.sdk.mraid.b0.DEFAULT) {
            com.fyber.inneractive.sdk.web.g gVar3 = this.f1358b;
            if (gVar3 != null) {
                gVar3.setVisibility(4);
            }
            com.fyber.inneractive.sdk.mraid.b0 b0Var2 = com.fyber.inneractive.sdk.mraid.b0.HIDDEN;
            this.N = b0Var2;
            a(new com.fyber.inneractive.sdk.mraid.z(b0Var2));
        }
        if (relativeLayoutA != null) {
            relativeLayoutA.setPadding(0, 0, 0, 0);
        }
        L l2 = this.g;
        if (l2 != 0) {
            ((f) l2).a(this, this.N);
        }
        if (Build.VERSION.SDK_INT >= 33) {
            u();
        }
    }

    public boolean s() {
        return this.N == com.fyber.inneractive.sdk.mraid.b0.RESIZED;
    }

    @Override // com.fyber.inneractive.sdk.web.c0
    public void setAdDefaultSize(int i, int i2) {
        this.k0 = i;
        this.l0 = i2;
        this.d0 = i;
        this.e0 = i2;
    }

    public void setOrientationProperties(boolean z, String str) {
        if (TJAdUnitConstants.String.PORTRAIT.equals(str)) {
            this.f0 = Orientation.PORTRAIT;
        } else if (TJAdUnitConstants.String.LANDSCAPE.equals(str)) {
            this.f0 = Orientation.LANDSCAPE;
        } else {
            this.f0 = Orientation.NONE;
        }
        L l2 = this.g;
        if (l2 != 0) {
            ((f) l2).a(this, z, this.f0);
        }
    }

    public void setResizeProperties() {
    }

    public final void t() {
        FrameLayout frameLayout = this.i0;
        if (frameLayout == null || this.j0 == null) {
            return;
        }
        frameLayout.removeAllViewsInLayout();
        this.j0.removeAllViewsInLayout();
        ViewGroup viewGroup = this.R;
        if (viewGroup != null) {
            viewGroup.removeView(this.j0);
        }
    }

    public final void u() {
        try {
            if (!(l() instanceof Activity) || this.m0 == null) {
                return;
            }
            ((Activity) l()).getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.m0);
            this.m0 = null;
        } catch (Exception e2) {
            IAlog.e("failed to unregisterOnBackInvokedCallback with error: %s", e2.getMessage());
        }
    }

    @Override // com.fyber.inneractive.sdk.web.g.a
    public void a() {
        com.fyber.inneractive.sdk.util.m.f1343b.post(new com.fyber.inneractive.sdk.web.k(this));
    }

    public void c(boolean z) {
        this.X = z;
        L l2 = this.g;
        if (l2 != 0) {
            ((f) l2).a(this, z);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.d, com.fyber.inneractive.sdk.web.f
    public boolean a(WebView webView, String str) {
        IAlog.a("%shandle url for: %s webView = %s", IAlog.a(this), str, webView);
        if (this.N == com.fyber.inneractive.sdk.mraid.b0.EXPANDED && !TextUtils.isEmpty(str) && webView.equals(this.S) && !this.T) {
            this.T = true;
            return false;
        }
        return super.a(webView, str);
    }

    @Override // com.fyber.inneractive.sdk.web.c0
    public void a(Context context, boolean z) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) IAConfigManager.M.v.a().getSystemService("window");
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        this.Y = displayMetrics.density;
        int iA = com.fyber.inneractive.sdk.util.l.a(context);
        int iA2 = com.fyber.inneractive.sdk.util.l.a(context, iA);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        double d2 = i;
        double d3 = 160.0d / ((double) displayMetrics.densityDpi);
        int widthDp = (int) (d2 * d3);
        int heightDp = (int) (((double) i2) * d3);
        int i3 = (i2 - iA) - iA2;
        com.fyber.inneractive.sdk.web.g gVar = this.f1358b;
        if (gVar != null && gVar.getScaleX() != 1.0f && this.f1358b.getScaleY() != 1.0f) {
            widthDp = this.f1358b.getWidthDp();
            heightDp = this.f1358b.getHeightDp();
            int iB = (com.fyber.inneractive.sdk.util.l.b(this.f1358b.getHeightDp()) - iA) - iA2;
            this.b0 = this.Z;
            this.c0 = (int) (((double) iB) * (160.0d / ((double) displayMetrics.densityDpi)));
        } else {
            double d4 = 160.0d / ((double) displayMetrics.densityDpi);
            this.b0 = (int) (d2 * d4);
            this.c0 = (int) (((double) i3) * d4);
        }
        if (this.Z == widthDp && this.a0 == heightDp) {
            return;
        }
        this.Z = widthDp;
        this.a0 = heightDp;
        if (z) {
            a(new com.fyber.inneractive.sdk.mraid.y(widthDp, heightDp));
            a(new com.fyber.inneractive.sdk.mraid.w(this.b0, this.c0));
            a(new com.fyber.inneractive.sdk.mraid.v(0, 0, this.b0, this.c0));
            int i4 = this.d0;
            if (i4 > 0 && this.e0 > 0) {
                a(new com.fyber.inneractive.sdk.mraid.t(com.fyber.inneractive.sdk.util.l.c(i4), com.fyber.inneractive.sdk.util.l.c(this.e0)));
                return;
            }
            com.fyber.inneractive.sdk.web.g gVar2 = this.f1358b;
            if (gVar2 == null || gVar2.getWidth() <= 0 || this.f1358b.getHeight() <= 0) {
                return;
            }
            a(new com.fyber.inneractive.sdk.mraid.t(com.fyber.inneractive.sdk.util.l.c(this.f1358b.getWidth()), com.fyber.inneractive.sdk.util.l.c(this.f1358b.getHeight())));
        }
    }

    @Override // com.fyber.inneractive.sdk.web.g.a
    public void b() {
        com.fyber.inneractive.sdk.util.m.f1343b.post(new com.fyber.inneractive.sdk.web.l(this));
    }

    public void b(String str) {
        com.fyber.inneractive.sdk.web.g gVar = this.f1358b;
        if (gVar != null) {
            gVar.a("window.mraidbridge.nativeCallComplete('" + str + "');");
        }
    }

    public void b(View view) {
        com.fyber.inneractive.sdk.measurement.a.InterfaceC0271a interfaceC0271a = this.I;
        if (interfaceC0271a != null) {
            com.fyber.inneractive.sdk.measurement.tracker.c cVar = (com.fyber.inneractive.sdk.measurement.tracker.c) interfaceC0271a;
            cVar.getClass();
            try {
                AdSession adSession = cVar.a;
                if (adSession == null || view == null) {
                    return;
                }
                adSession.removeFriendlyObstruction(view);
            } catch (Throwable th) {
                cVar.a(th);
            }
        }
    }

    public final Map<String, Object> a(Map<String, String> map) throws Exception {
        String str;
        HashMap map2 = new HashMap();
        if (map.containsKey("description") && map.containsKey("start")) {
            map2.put("title", map.get("description"));
            if (map.containsKey("start") && map.get("start") != null) {
                Date dateC = c(map.get("start"));
                if (dateC != null) {
                    map2.put("beginTime", Long.valueOf(dateC.getTime()));
                    if (map.containsKey("end") && map.get("end") != null) {
                        Date dateC2 = c(map.get("end"));
                        if (dateC2 != null) {
                            map2.put(SDKConstants.PARAM_END_TIME, Long.valueOf(dateC2.getTime()));
                        } else {
                            throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
                        }
                    }
                    if (map.containsKey(FirebaseAnalytics.Param.LOCATION)) {
                        map2.put("eventLocation", map.get(FirebaseAnalytics.Param.LOCATION));
                    }
                    if (map.containsKey("summary")) {
                        map2.put("description", map.get("summary"));
                    }
                    if (map.containsKey("transparency")) {
                        map2.put("availability", Integer.valueOf(TJAdUnitConstants.String.TRANSPARENT.equals(map.get("transparency")) ? 1 : 0));
                    }
                    StringBuilder sb = new StringBuilder();
                    if (map.containsKey("frequency")) {
                        String str2 = map.get("frequency");
                        int i = map.containsKey(TJAdUnitConstants.String.INTERVAL) ? Integer.parseInt(map.get(TJAdUnitConstants.String.INTERVAL)) : -1;
                        if ("daily".equals(str2)) {
                            sb.append("FREQ=DAILY;");
                            if (i != -1) {
                                sb.append("INTERVAL=" + i + ";");
                            }
                        } else {
                            if ("weekly".equals(str2)) {
                                sb.append("FREQ=WEEKLY;");
                                if (i != -1) {
                                    sb.append("INTERVAL=" + i + ";");
                                }
                                if (map.containsKey("daysInWeek")) {
                                    String str3 = map.get("daysInWeek");
                                    StringBuilder sb2 = new StringBuilder();
                                    boolean[] zArr = new boolean[7];
                                    String[] strArrSplit = str3.split(",");
                                    for (String str4 : strArrSplit) {
                                        int i2 = Integer.parseInt(str4);
                                        if (i2 == 7) {
                                            i2 = 0;
                                        }
                                        if (!zArr[i2]) {
                                            StringBuilder sb3 = new StringBuilder();
                                            switch (i2) {
                                                case 0:
                                                    str = "SU";
                                                    break;
                                                case 1:
                                                    str = "MO";
                                                    break;
                                                case 2:
                                                    str = "TU";
                                                    break;
                                                case 3:
                                                    str = "WE";
                                                    break;
                                                case 4:
                                                    str = "TH";
                                                    break;
                                                case 5:
                                                    str = "FR";
                                                    break;
                                                case 6:
                                                    str = "SA";
                                                    break;
                                                default:
                                                    throw new IllegalArgumentException("invalid day of week " + i2);
                                            }
                                            sb2.append(sb3.append(str).append(",").toString());
                                            zArr[i2] = true;
                                        }
                                    }
                                    if (strArrSplit.length != 0) {
                                        sb2.deleteCharAt(sb2.length() - 1);
                                        String string = sb2.toString();
                                        if (string != null) {
                                            sb.append("BYDAY=" + string + ";");
                                        } else {
                                            throw new IllegalArgumentException("invalid ");
                                        }
                                    } else {
                                        throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
                                    }
                                }
                            } else if ("monthly".equals(str2)) {
                                sb.append("FREQ=MONTHLY;");
                                if (i != -1) {
                                    sb.append("INTERVAL=" + i + ";");
                                }
                                if (map.containsKey("daysInMonth")) {
                                    String str5 = map.get("daysInMonth");
                                    StringBuilder sb4 = new StringBuilder();
                                    boolean[] zArr2 = new boolean[63];
                                    String[] strArrSplit2 = str5.split(",");
                                    for (String str6 : strArrSplit2) {
                                        int i3 = Integer.parseInt(str6);
                                        int i4 = i3 + 31;
                                        if (!zArr2[i4]) {
                                            StringBuilder sb5 = new StringBuilder();
                                            if (i3 != 0 && i3 >= -31 && i3 <= 31) {
                                                sb4.append(sb5.append("" + i3).append(",").toString());
                                                zArr2[i4] = true;
                                            } else {
                                                throw new IllegalArgumentException("invalid day of month " + i3);
                                            }
                                        }
                                    }
                                    if (strArrSplit2.length != 0) {
                                        sb4.deleteCharAt(sb4.length() - 1);
                                        String string2 = sb4.toString();
                                        if (string2 != null) {
                                            sb.append("BYMONTHDAY=" + string2 + ";");
                                        } else {
                                            throw new IllegalArgumentException();
                                        }
                                    } else {
                                        throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
                                    }
                                }
                            } else {
                                throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
                            }
                        }
                    }
                    String string3 = sb.toString();
                    if (!TextUtils.isEmpty(string3)) {
                        map2.put("rrule", string3);
                    }
                    return map2;
                }
                throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
            }
            throw new IllegalArgumentException("Invalid calendar event: start is null.");
        }
        throw new IllegalArgumentException("Missing start and description fields");
    }

    public final void a(String str) {
        new File(Environment.getExternalStorageDirectory(), "Pictures").mkdirs();
        com.fyber.inneractive.sdk.flow.q qVar = this.s;
        l0 l0Var = new l0(new c(), str, qVar != null ? qVar.c : null);
        IAConfigManager.M.s.a.offer(l0Var);
        l0Var.a(q0.QUEUED);
    }

    public void a(com.fyber.inneractive.sdk.mraid.g gVar, String str) {
        String strE = gVar.e();
        com.fyber.inneractive.sdk.web.g gVar2 = this.f1358b;
        if (gVar2 != null) {
            gVar2.a("window.mraidbridge.fireErrorEvent('" + strE + "', '" + str + "');");
        }
    }

    public final Map<String, String> a(URI uri) throws UnsupportedEncodingException {
        int i;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && rawQuery.length() > 0) {
            for (String str : rawQuery.split("&")) {
                int iIndexOf = str.indexOf("=");
                linkedHashMap.put(iIndexOf > 0 ? URLDecoder.decode(str.substring(0, iIndexOf), "UTF-8") : str, (iIndexOf <= 0 || str.length() <= (i = iIndexOf + 1)) ? null : URLDecoder.decode(str.substring(i), "UTF-8"));
            }
        }
        return linkedHashMap;
    }

    public void a(View view, com.fyber.inneractive.sdk.measurement.tracker.c.EnumC0273c enumC0273c) {
        com.fyber.inneractive.sdk.measurement.a.InterfaceC0271a interfaceC0271a;
        if (view == null || (interfaceC0271a = this.I) == null) {
            return;
        }
        com.fyber.inneractive.sdk.measurement.tracker.c cVar = (com.fyber.inneractive.sdk.measurement.tracker.c) interfaceC0271a;
        cVar.getClass();
        try {
            AdSession adSession = cVar.a;
            if (adSession != null) {
                if (enumC0273c == com.fyber.inneractive.sdk.measurement.tracker.c.EnumC0273c.CloseButton) {
                    adSession.addFriendlyObstruction(view, FriendlyObstructionPurpose.CLOSE_AD, enumC0273c.name());
                } else {
                    adSession.addFriendlyObstruction(view, FriendlyObstructionPurpose.OTHER, enumC0273c.name());
                }
            }
        } catch (Throwable th) {
            cVar.a(th);
        }
    }

    public final void a(com.fyber.inneractive.sdk.mraid.g gVar) {
        com.fyber.inneractive.sdk.config.global.s sVar;
        com.fyber.inneractive.sdk.network.r rVar = com.fyber.inneractive.sdk.network.r.BANNER_RESIZE_EXPAND;
        InneractiveAdRequest inneractiveAdRequest = this.r;
        com.fyber.inneractive.sdk.flow.q qVar = this.s;
        com.fyber.inneractive.sdk.response.e eVarD = qVar != null ? qVar.d() : null;
        com.fyber.inneractive.sdk.flow.q qVar2 = this.s;
        new com.fyber.inneractive.sdk.network.s.a(rVar, inneractiveAdRequest, eVarD, (qVar2 == null || (sVar = qVar2.c) == null) ? null : sVar.c()).a("action", gVar.e()).a((String) null);
    }

    public final RelativeLayout a(View view) {
        if (view == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.ia_identifier_overlay);
        if (viewGroup instanceof RelativeLayout) {
            return (RelativeLayout) viewGroup;
        }
        return null;
    }
}
