package com.bytedance.sdk.openadsdk.core.c0;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.t;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: ClickCreativeListener.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends b {
    private boolean M;
    private boolean N;
    private boolean O;
    private WeakReference<InterfaceC0194a> P;
    private int Q;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.c0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ClickCreativeListener.java */
    public interface InterfaceC0194a {
        long getVideoProgress();
    }

    public a(Context context, q qVar, String str, int i) {
        super(context, qVar, str, i);
        this.M = true;
        this.N = false;
        this.O = false;
    }

    private boolean d(View view) {
        if (view == null) {
            return false;
        }
        if (view instanceof NativeVideoTsView) {
            m.d("ClickCreativeListener", "NativeVideoTsView....");
            return true;
        }
        if (view.getId() == h.E0 || view.getId() == h.K || view.getId() == h.L || view.getId() == h.M || view.getId() == h.N) {
            m.d("ClickCreativeListener", "tt_video_ad_cover_center_layout....");
            return true;
        }
        if (view.getId() == 520093726 || view.getId() == h.J0) {
            m.d("ClickCreativeListener", "tt_root_view....");
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return false;
            }
            if (d(viewGroup.getChildAt(i))) {
                return true;
            }
            i++;
        }
    }

    private boolean e() {
        return q.c(this.v) && this.v.V() == 1;
    }

    private boolean h() {
        return this instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.f;
    }

    private boolean i() {
        if (this.v == null || h()) {
            return false;
        }
        if (this.v.c0() != 5 && this.v.c0() != 15) {
            return false;
        }
        if (this.Q == 0) {
            this.Q = this.v.R();
        }
        m.a("ClickCreativeListener", "!isViewVisibility()=" + (!j()) + ",isAutoPlay()=" + f() + ",!isCoverPageVisibility()=" + (!g()));
        if (this.Q == 5 && e() && f() && !j() && !g()) {
            return false;
        }
        int i = this.Q;
        return i == 1 || i == 2 || i == 5;
    }

    /* JADX WARN: Code duplicated, block: B:175:0x036e A[Catch: Exception -> 0x0380, TryCatch #0 {Exception -> 0x0380, blocks: (B:171:0x0361, B:173:0x036a, B:177:0x037d, B:175:0x036e), top: B:190:0x0361 }] */
    /* JADX WARN: Code duplicated, block: B:177:0x037d A[Catch: Exception -> 0x0380, TRY_LEAVE, TryCatch #0 {Exception -> 0x0380, blocks: (B:171:0x0361, B:173:0x036a, B:177:0x037d, B:175:0x036e), top: B:190:0x0361 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00dd  */
    @Override // com.bytedance.sdk.openadsdk.core.c0.b, com.bytedance.sdk.openadsdk.core.c0.c
    public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
        JSONObject jSONObject;
        int i;
        View view2;
        PAGNativeAd pAGNativeAd;
        String str;
        if (a(view, 2, f, f2, f3, f4, sparseArray, z)) {
            return;
        }
        this.v.o1();
        if (!this.v.Z0()) {
            this.v.e(true);
        }
        if (q.c(this.v)) {
            q qVar = this.v;
            com.bytedance.sdk.openadsdk.d.c.a(qVar, this.w, qVar.v0());
        }
        if (this.D != null) {
            if (this.F == null) {
                this.F = new HashMap();
            }
            this.F.put("duration", Long.valueOf(this.D.o()));
        }
        int iA0 = this.v.a0();
        this.v.l(0);
        b.c.a.a.a.a.c cVar = this.E;
        if (cVar != null) {
            cVar.a(iA0 > 0 ? iA0 : 0);
        }
        Map<String, Object> map = this.F;
        if (map != null) {
            map.remove("dsp_click_type");
            this.F.remove("click_probability_jump");
        }
        if (iA0 > 0) {
            if (this.F == null) {
                this.F = new HashMap();
            }
            if (this.v.k1() && iA0 < 11) {
                this.F.put("dsp_click_type", Integer.valueOf(iA0));
            }
            if (iA0 >= 11 && this.v.G() == 0) {
                this.F.put("click_probability_jump", Integer.valueOf(com.bytedance.sdk.openadsdk.core.f0.e.a(iA0)));
            }
        }
        if (this.v.k1()) {
            if (view != null) {
                Object tag = view.getTag(570425345);
                if (tag instanceof String) {
                    str = (String) tag;
                } else {
                    str = "VAST_ACTION_BUTTON";
                }
            } else {
                str = "VAST_ACTION_BUTTON";
            }
            this.v.M0().b(str);
            if (!TextUtils.isEmpty(str)) {
                a(str);
            }
            long videoProgress = 0;
            WeakReference<InterfaceC0194a> weakReference = this.P;
            if (weakReference != null && weakReference.get() != null) {
                videoProgress = this.P.get().getVideoProgress();
            }
            if ("VAST_ICON".equals(str)) {
                if (this.v.M0().h() != null) {
                    this.v.M0().h().a(videoProgress);
                }
            } else if (!"VAST_END_CARD".equals(str)) {
                this.v.M0().m().a(videoProgress);
            } else if (this.v.M0().c() != null) {
                this.v.M0().c().a(videoProgress);
            }
        }
        if (i() && d(view) && !this.O) {
            m.a("ClickCreativeListener", "Intercept the native video view , Select the normal click event.....");
            super.a(view, f, f2, f3, f4, sparseArray, z);
            return;
        }
        m.a("ClickCreativeListener", "Select creative area click event.....");
        if (this.t == null) {
            this.t = o.a();
        }
        if (this.t != null && a(view, z)) {
            JSONObject jSONObjectA = NativeExpressView.a(view);
            com.bytedance.sdk.openadsdk.core.f0.m mVar = this.u;
            if (mVar != null) {
                i = mVar.l;
                jSONObject = mVar.m;
            } else {
                jSONObject = jSONObjectA;
                i = -1;
            }
            long j = this.e;
            long j2 = this.f;
            WeakReference<View> weakReference2 = this.y;
            View viewD = weakReference2 == null ? d() : weakReference2.get();
            WeakReference<View> weakReference3 = this.z;
            this.A = a(f, f2, f3, f4, sparseArray, j, j2, viewD, weakReference3 == null ? c() : weakReference3.get(), b(), b0.a(this.t), b0.b(this.t), b0.f(this.t), i, jSONObject);
            int iE0 = this.v.e0();
            if (iE0 == 2 || iE0 == 3) {
                if (iE0 == 3) {
                    String strH0 = this.v.H0();
                    if (!TextUtils.isEmpty(strH0) && strH0.contains("play.google.com/store/apps/details?id=")) {
                        if (b.c.a.a.a.a.b.a(this.t, strH0, strH0.substring(strH0.indexOf("?id=") + 4), this.w, this.v)) {
                            if (this.M) {
                                com.bytedance.sdk.openadsdk.d.c.a("click", this.v, this.A, this.w, true, this.F, z ? 1 : 2);
                            }
                            view2 = view;
                        }
                    }
                }
                if (this.C != null || this.N) {
                    com.bytedance.sdk.openadsdk.d.c.a("click_button", this.v, this.A, this.w, true, this.F, z ? 1 : 2);
                }
                view2 = view;
                if (view2 != null) {
                    try {
                        if (view.getId() == 520093726 || (view2 instanceof NativeVideoTsView)) {
                            z.a(true);
                        } else if (((Boolean) view2.getTag(520093762)).booleanValue()) {
                            z.a(true);
                        }
                    } catch (Exception unused) {
                    }
                } else if (((Boolean) view2.getTag(520093762)).booleanValue()) {
                    z.a(true);
                }
                boolean zA = z.a(this.t, this.v, this.x, this.C, this.G, this.w, this.E, true, iA0);
                z.a(false);
                if (this.M) {
                    com.bytedance.sdk.openadsdk.d.c.a("click", this.v, this.A, this.w, zA, this.F, z ? 1 : 2);
                }
            } else {
                if (iE0 != 4) {
                    if (iE0 != 5) {
                        view2 = view;
                        iE0 = -1;
                    } else {
                        String strB = b(this.w);
                        if (!TextUtils.isEmpty(strB)) {
                            com.bytedance.sdk.openadsdk.d.c.a("click_call", this.v, this.A, strB, true, this.F, z ? 1 : 2);
                        }
                        com.bytedance.sdk.openadsdk.d.c.a("click", this.v, this.A, this.w, a0.c(view.getContext(), this.v.n0()), this.F, z ? 1 : 2);
                    }
                } else if (!t.i(this.v) || ((pAGNativeAd = this.C) == null && this.G == null)) {
                    b.c.a.a.a.a.c cVar2 = this.E;
                    if (cVar2 != null) {
                        cVar2.b();
                        Map<String, Object> map2 = this.F;
                        if (this.v.Z0() && !this.v.b1()) {
                            if (this.v.a1()) {
                                map2.put("auto_click", 1);
                            } else {
                                map2.put("auto_click", 2);
                            }
                            this.v.c(false);
                        }
                        if (this.M) {
                            com.bytedance.sdk.openadsdk.d.c.a("click", this.v, this.A, this.w, true, map2, z ? 1 : 2);
                        }
                    }
                } else {
                    boolean zA2 = z.a(this.t, this.v, this.x, pAGNativeAd, this.G, this.w, this.E, true, iA0);
                    if (this.M) {
                        com.bytedance.sdk.openadsdk.d.c.a("click", this.v, this.A, this.w, zA2, this.F, z ? 1 : 2);
                    }
                }
                view2 = view;
            }
            b.a aVar = this.B;
            if (aVar != null) {
                aVar.a(view2, iE0);
            }
        }
    }

    public void b(boolean z) {
        this.M = z;
    }

    public void c(boolean z) {
        this.N = z;
    }

    protected boolean f() {
        q qVar = this.v;
        if (qVar == null) {
            return true;
        }
        int iB = o.d().b(qVar.S());
        int iB2 = p.b(o.a());
        if (iB == 1) {
            return a0.h(iB2);
        }
        if (iB == 2) {
            return a0.f(iB2) || a0.h(iB2) || a0.g(iB2);
        }
        if (iB != 3) {
            return iB != 5 || a0.h(iB2) || a0.g(iB2);
        }
        return false;
    }

    public boolean g() {
        return false;
    }

    public boolean j() {
        return false;
    }

    private String b(String str) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return "banner_call";
            case "open_ad":
                return "open_ad";
            case "embeded_ad":
                return "feed_call";
            case "interaction":
                return "interaction_call";
            case "slide_banner_ad":
                return "banner_call";
            default:
                return "";
        }
    }

    public void d(boolean z) {
        this.O = z;
    }

    public void a(InterfaceC0194a interfaceC0194a) {
        this.P = new WeakReference<>(interfaceC0194a);
    }
}
