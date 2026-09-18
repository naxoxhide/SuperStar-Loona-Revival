package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.y;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.c0;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PAGBannerAdImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends PAGBannerAd implements y.a {
    private boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected BannerExpressView f560b;
    protected final Context c;
    protected q d;
    protected AdSlot e;
    private PAGBannerAdWrapperListener f;
    private int g;
    private com.bytedance.sdk.openadsdk.dislike.b i;
    private b.c.a.a.a.a.c j;
    private y k;
    private t.a l;
    TTDislikeDialogAbstract m;
    private boolean o;
    private boolean p;
    private NativeExpressView r;
    private boolean s;
    private boolean t;
    private int h = 0;
    private final Queue<Long> n = new LinkedList();
    private String q = "banner_ad";
    protected final View.OnAttachStateChangeListener u = new b();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.bannerexpress.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PAGBannerAdImpl.java */
    class RunnableC0192a implements Runnable {
        RunnableC0192a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a();
        }
    }

    /* JADX INFO: compiled from: PAGBannerAdImpl.java */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a.this.destroy();
            if (view != null) {
                view.removeOnAttachStateChangeListener(a.this.u);
            }
        }
    }

    /* JADX INFO: compiled from: PAGBannerAdImpl.java */
    class c implements b.b.a.a.d.f.c {
        final /* synthetic */ NativeExpressView a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f561b;

        c(NativeExpressView nativeExpressView, String str) {
            this.a = nativeExpressView;
            this.f561b = str;
        }

        @Override // b.b.a.a.d.f.c
        public boolean a(ViewGroup viewGroup, int i) {
            try {
                this.a.o();
                if (!a.this.d.k1()) {
                    BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(this.a.getContext());
                    bannerExpressBackupView.setClosedListenerKey(this.f561b);
                    a aVar = a.this;
                    bannerExpressBackupView.a(aVar.d, this.a, aVar.j);
                    bannerExpressBackupView.setDislikeInner(a.this.i);
                    bannerExpressBackupView.setDislikeOuter(a.this.m);
                    bannerExpressBackupView.setAdInteractionListener(a.this.f);
                    return true;
                }
                VastBannerBackupView vastBannerBackupView = new VastBannerBackupView(this.a.getContext());
                vastBannerBackupView.setClosedListenerKey(this.f561b);
                a aVar2 = a.this;
                vastBannerBackupView.a(aVar2.d, this.a, aVar2.j);
                vastBannerBackupView.setDislikeInner(a.this.i);
                vastBannerBackupView.setDislikeOuter(a.this.m);
                vastBannerBackupView.setAdInteractionListener(a.this.f);
                this.a.setVastVideoHelper(vastBannerBackupView);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: PAGBannerAdImpl.java */
    class d implements EmptyView.d {
        final /* synthetic */ q a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ EmptyView f562b;
        final /* synthetic */ NativeExpressView c;
        final /* synthetic */ String d;
        final /* synthetic */ h e;

        d(q qVar, EmptyView emptyView, NativeExpressView nativeExpressView, String str, h hVar) {
            this.a = qVar;
            this.f562b = emptyView;
            this.c = nativeExpressView;
            this.d = str;
            this.e = hVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.d
        public void a() {
            a.this.c();
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.d
        public void onDetachedFromWindow() {
            a.this.a(this.f562b, false, this.a);
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.d
        public void onWindowFocusChanged(boolean z) {
            a.this.a(z, this.a);
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.d
        public void a(View view) {
            a.this.a(view, this.c, this.a, this.d, this.e);
        }
    }

    /* JADX INFO: compiled from: PAGBannerAdImpl.java */
    class e implements c0.f {
        final /* synthetic */ q a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ NativeExpressView f563b;
        final /* synthetic */ String c;
        final /* synthetic */ h d;

        e(q qVar, NativeExpressView nativeExpressView, String str, h hVar) {
            this.a = qVar;
            this.f563b = nativeExpressView;
            this.c = str;
            this.d = hVar;
        }

        @Override // com.bytedance.sdk.openadsdk.utils.c0.f
        public void a() {
            a.this.c();
        }

        @Override // com.bytedance.sdk.openadsdk.utils.c0.f
        public void onDetachedFromWindow() {
            a.this.a((EmptyView) null, true, this.a);
        }

        @Override // com.bytedance.sdk.openadsdk.utils.c0.f
        public void onWindowFocusChanged(boolean z) {
            a.this.a(z, this.a);
        }

        @Override // com.bytedance.sdk.openadsdk.utils.c0.f
        public void a(View view, boolean z) {
            if (z) {
                a.this.a(view, this.f563b, this.a, this.c, this.d);
            }
        }
    }

    /* JADX INFO: compiled from: PAGBannerAdImpl.java */
    class f implements h {

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.bannerexpress.a$f$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: PAGBannerAdImpl.java */
        class ViewOnClickListenerC0193a implements View.OnClickListener {
            ViewOnClickListenerC0193a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = a.this;
                TTWebsiteActivity.a(aVar.c, aVar.d, aVar.q);
            }
        }

        f() {
        }

        private View a(boolean z) {
            PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(a.this.c);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            pAGFrameLayout.setBackgroundColor(-1);
            pAGFrameLayout.setLayoutParams(layoutParams);
            View view = new View(a.this.c);
            ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            view.setAlpha(0.3f);
            view.setBackgroundColor(Color.parseColor("#F3F7F8"));
            pAGFrameLayout.addView(view, layoutParams2);
            PAGFrameLayout pAGFrameLayout2 = new PAGFrameLayout(a.this.c);
            ViewGroup.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            if (z) {
                pAGFrameLayout2.setBackground(com.bytedance.sdk.component.utils.t.f(a.this.c, "tt_ad_closed_background_300_250"));
            } else {
                pAGFrameLayout2.setBackground(com.bytedance.sdk.component.utils.t.f(a.this.c, "tt_ad_closed_background_320_50"));
            }
            pAGFrameLayout.addView(pAGFrameLayout2, layoutParams3);
            PAGImageView pAGImageView = new PAGImageView(a.this.c);
            pAGImageView.setId(520093739);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
            if (z) {
                int iA = b0.a(a.this.c, 16.0f);
                layoutParams4.width = b0.a(a.this.c, 77.0f);
                layoutParams4.height = b0.a(a.this.c, 14.0f);
                layoutParams4.leftMargin = iA;
                layoutParams4.topMargin = iA;
            } else {
                int iA2 = b0.a(a.this.c, 8.0f);
                layoutParams4.width = b0.a(a.this.c, 45.0f);
                layoutParams4.height = b0.a(a.this.c, 8.18f);
                layoutParams4.leftMargin = iA2;
                layoutParams4.topMargin = iA2;
            }
            pAGImageView.setImageResource(com.bytedance.sdk.component.utils.t.e(a.this.c, "tt_ad_closed_logo_red"));
            pAGFrameLayout2.addView(pAGImageView, layoutParams4);
            PAGTextView pAGTextView = new PAGTextView(a.this.c);
            FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams5.gravity = 17;
            pAGTextView.setAlpha(0.5f);
            pAGTextView.setLines(1);
            pAGTextView.setText(com.bytedance.sdk.component.utils.t.k(a.this.c, "tt_ad_is_closed"));
            if (z) {
                pAGTextView.setTextSize(18.0f);
            } else {
                pAGTextView.setTextSize(12.0f);
            }
            pAGFrameLayout2.addView(pAGTextView, layoutParams5);
            ViewOnClickListenerC0193a viewOnClickListenerC0193a = new ViewOnClickListenerC0193a();
            pAGImageView.setOnClickListener(viewOnClickListenerC0193a);
            pAGTextView.setOnClickListener(viewOnClickListenerC0193a);
            return pAGFrameLayout;
        }

        @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a.h
        public void onItemClickClosed() {
            EmptyView emptyViewA;
            int width = a.this.r.getWidth();
            int height = a.this.r.getHeight();
            View viewA = a(((double) height) >= Math.floor((((double) width) * 450.0d) / 600.0d));
            a.this.r.A();
            if (a.this.a) {
                emptyViewA = null;
            } else {
                a aVar = a.this;
                emptyViewA = aVar.a(aVar.r);
            }
            a.this.r.removeAllViews();
            a.this.r.addView(viewA, new ViewGroup.LayoutParams(width, height));
            a.this.r.setClickCreativeListener(null);
            a.this.r.setClickListener(null);
            if (o.d().o() == 1) {
                a.this.g();
            } else if (a.this.g != 0 && !a.this.a && emptyViewA != null) {
                a.this.r.addView(emptyViewA);
            }
            if (a.this.f != null) {
                a.this.f.onAdDismissed();
            }
        }
    }

    /* JADX INFO: compiled from: PAGBannerAdImpl.java */
    public interface h {
        void onItemClickClosed();
    }

    /* JADX INFO: compiled from: PAGBannerAdImpl.java */
    private static class i extends b.b.a.a.k.g {
        boolean c;
        q d;
        WeakReference<a> e;

        i(boolean z, q qVar, a aVar) {
            super("ReportWindowFocusChangedAdShow");
            this.c = z;
            this.d = qVar;
            this.e = new WeakReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<a> weakReference = this.e;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.e.get().b(this.c, this.d);
        }
    }

    public a(Context context, q qVar, AdSlot adSlot) {
        this.c = context;
        this.d = qVar;
        this.e = adSlot;
        a(context, qVar, adSlot);
        this.a = false;
        a(this.f560b.getCurView(), this.d);
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public void destroy() {
        if (com.bytedance.sdk.openadsdk.utils.y.g()) {
            a();
        } else {
            com.bytedance.sdk.openadsdk.utils.y.a(new RunnableC0192a());
        }
        g();
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public View getBannerView() {
        com.bytedance.sdk.openadsdk.utils.b.a(this.d);
        return this.f560b;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        q qVar = this.d;
        if (qVar != null) {
            return qVar.i0();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d2, String str, String str2) {
        if (this.p) {
            return;
        }
        u.a(this.d, d2, str, str2);
        this.p = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public void setAdInteractionCallback(PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback) {
        com.bytedance.sdk.openadsdk.core.bannerexpress.b bVar = new com.bytedance.sdk.openadsdk.core.bannerexpress.b(pAGBannerAdInteractionCallback);
        this.f = bVar;
        this.f560b.setExpressInteractionListener(bVar);
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public void setAdInteractionListener(PAGBannerAdInteractionListener pAGBannerAdInteractionListener) {
        com.bytedance.sdk.openadsdk.core.bannerexpress.b bVar = new com.bytedance.sdk.openadsdk.core.bannerexpress.b(pAGBannerAdInteractionListener);
        this.f = bVar;
        this.f560b.setExpressInteractionListener(bVar);
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d2) {
        if (this.o) {
            return;
        }
        u.a(this.d, d2);
        this.o = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (!this.t) {
            d();
            this.t = true;
        }
        f();
        if (this.s) {
            return;
        }
        View rootView = this.f560b.getRootView();
        if (rootView != null) {
            rootView.addOnAttachStateChangeListener(this.u);
        }
        this.s = true;
    }

    private void e() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.e.a(this.c).a(this.e, 1, null, new g(), 5000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        y yVar = this.k;
        if (yVar != null) {
            yVar.removeCallbacksAndMessages(null);
            this.k.sendEmptyMessageDelayed(112202, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        y yVar = this.k;
        if (yVar != null) {
            yVar.removeCallbacksAndMessages(null);
        }
    }

    public void d() {
        this.d.c(SystemClock.elapsedRealtime());
        this.f560b.q();
    }

    private b.c.a.a.a.a.c b(q qVar) {
        if (qVar.e0() == 4) {
            return b.c.a.a.a.a.d.a(this.c, qVar, this.q);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, q qVar) {
        Long lPoll;
        try {
            if (z) {
                this.n.offer(Long.valueOf(System.currentTimeMillis()));
            } else if (this.n.size() > 0 && this.r != null && (lPoll = this.n.poll()) != null) {
                com.bytedance.sdk.openadsdk.d.c.a((System.currentTimeMillis() - lPoll.longValue()) + "", qVar, this.q, this.r.getAdShowTime());
            }
        } catch (Exception e2) {
            m.b("PAGBannerAdImpl", e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f560b != null) {
            m.a("PAGBannerAdImpl", "PAGBanner destroy");
            try {
                View rootView = this.f560b.getRootView();
                if (rootView != null) {
                    rootView.removeOnAttachStateChangeListener(this.u);
                }
                this.f560b.o();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: PAGBannerAdImpl.java */
    class g implements com.bytedance.sdk.openadsdk.core.nativeexpress.e.c {
        g() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.e.c
        public void a(List<q> list) {
            if (list == null || list.isEmpty()) {
                a.this.f();
                return;
            }
            q qVar = list.get(0);
            a aVar = a.this;
            aVar.f560b.a(qVar, aVar.e);
            a.this.a(qVar);
            a.this.f560b.r();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.e.c
        public void a() {
            a.this.f();
        }
    }

    private void c(q qVar) {
        Queue<Long> queue = this.n;
        if (queue == null || queue.size() <= 0 || qVar == null) {
            return;
        }
        try {
            long jLongValue = this.n.poll().longValue();
            if (jLongValue <= 0 || this.r == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.d.c.a((System.currentTimeMillis() - jLongValue) + "", qVar, this.q, this.r.getAdShowTime());
        } catch (Exception e2) {
            m.b("PAGBannerAdImpl", e2.getMessage());
        }
    }

    public void a(Context context, q qVar, AdSlot adSlot) {
        this.f560b = new BannerExpressView(context, qVar, adSlot);
    }

    protected void a(NativeExpressView nativeExpressView, q qVar) {
        if (nativeExpressView == null || qVar == null) {
            return;
        }
        this.d = qVar;
        this.j = b(qVar);
        this.r = nativeExpressView;
        String strA = com.bytedance.sdk.openadsdk.utils.q.a();
        h hVarB = b();
        nativeExpressView.setClosedListenerKey(strA);
        nativeExpressView.setBannerClickClosedListener(hVarB);
        nativeExpressView.setBackupListener(new c(nativeExpressView, strA));
        EmptyView emptyView = null;
        if (!this.a) {
            EmptyView emptyViewA = a(nativeExpressView);
            if (emptyViewA == null) {
                emptyViewA = new EmptyView(this.c, nativeExpressView);
                nativeExpressView.addView(emptyViewA);
            }
            emptyView = emptyViewA;
            emptyView.setCallback(new d(qVar, emptyView, nativeExpressView, strA, hVarB));
        } else {
            c0.a(nativeExpressView, true, 1, new e(qVar, nativeExpressView, strA, hVarB), null);
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.g gVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.g(this.c, qVar, this.q, 2);
        gVar.b(nativeExpressView);
        gVar.a(this);
        gVar.a(this.j);
        nativeExpressView.setClickListener(gVar);
        com.bytedance.sdk.openadsdk.core.nativeexpress.f fVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.f(this.c, qVar, this.q, 2);
        fVar.b(nativeExpressView);
        fVar.a(this);
        NativeExpressView nativeExpressView2 = this.r;
        if (nativeExpressView2 instanceof NativeExpressVideoView) {
            fVar.a(((NativeExpressVideoView) nativeExpressView2).getVideoController());
        }
        fVar.a(this.j);
        nativeExpressView.setClickCreativeListener(fVar);
        if (this.a) {
            return;
        }
        emptyView.setNeedCheckingShow(true);
    }

    public h b() {
        return new f();
    }

    private void b(NativeExpressView nativeExpressView, q qVar) {
        if (nativeExpressView == null || qVar == null) {
            return;
        }
        if (this.l != null) {
            this.i.b(qVar.N(), qVar.W());
            nativeExpressView.setDislike(this.i);
        }
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.m;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.setMaterialMeta(qVar.N(), qVar.W());
            nativeExpressView.setOuterDislike(this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, q qVar) {
        if (z) {
            if (this.d.Q0() && !this.d.R0()) {
                this.d.b(true);
                q qVar2 = this.d;
                com.bytedance.sdk.openadsdk.d.c.a(qVar2, this.q, qVar2.t());
            }
            f();
            m.a("PAGBannerAdImpl", "banner_ad", "Get focus, start timing");
        } else {
            g();
            m.a("PAGBannerAdImpl", "banner_ad", "Lose focus, stop timing");
        }
        com.bytedance.sdk.openadsdk.utils.y.c(new i(z, qVar, this), 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EmptyView emptyView, boolean z, q qVar) {
        BannerExpressView bannerExpressView = this.f560b;
        if (bannerExpressView != null && ((!z && emptyView != null && emptyView == a(bannerExpressView.getCurView())) || z)) {
            g();
        }
        c(qVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, NativeExpressView nativeExpressView, q qVar, String str, h hVar) {
        com.bytedance.sdk.openadsdk.core.h.a().a(str, hVar);
        m.a("PAGBannerAdImpl", "banner_ad", "ExpressView SHOW");
        Queue<Long> queue = this.n;
        if (queue != null) {
            queue.offer(Long.valueOf(System.currentTimeMillis()));
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (nativeExpressView != null) {
                jSONObject.put("dynamic_show_type", nativeExpressView.getDynamicShowType());
            }
            if (view != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("width", view.getWidth());
                    jSONObject2.put("height", view.getHeight());
                    jSONObject2.put("alpha", view.getAlpha());
                } catch (Throwable unused) {
                }
                jSONObject.put("root_view", jSONObject2.toString());
            }
            com.bytedance.sdk.openadsdk.d.c.b(qVar, this.q, jSONObject);
        } catch (JSONException unused2) {
            m.b("PAGBannerAdImpl", "onShowFun json error");
        }
        PAGBannerAdWrapperListener pAGBannerAdWrapperListener = this.f;
        if (pAGBannerAdWrapperListener != null) {
            pAGBannerAdWrapperListener.onAdShow(view, qVar.e0());
        }
        if (qVar.C0()) {
            a0.a(qVar, view);
        }
        f();
        BannerExpressView bannerExpressView = this.f560b;
        if (bannerExpressView == null || bannerExpressView.getCurView() == null) {
            return;
        }
        this.f560b.getCurView().B();
        this.f560b.getCurView().z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EmptyView a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            try {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof EmptyView) {
                    return (EmptyView) childAt;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.utils.y.a
    public void a(Message message) {
        if (message.what == 112202) {
            if (com.bytedance.sdk.openadsdk.core.y.b(this.f560b, 50, 1)) {
                this.h += 1000;
            }
            if (this.h >= this.g) {
                e();
                AdSlot adSlot = this.e;
                adSlot.setRotateOrder(adSlot.getRotateOrder() + 1);
                this.h = 0;
                g();
                return;
            }
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar) {
        if (this.f560b.getNextView() == null || !this.f560b.n()) {
            return;
        }
        b(this.f560b.getNextView(), qVar);
        a(this.f560b.getNextView(), qVar);
    }
}
