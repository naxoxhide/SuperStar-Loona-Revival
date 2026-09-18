package com.bytedance.sdk.openadsdk.core.c0;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.f0.i;
import com.bytedance.sdk.openadsdk.core.f0.m;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: ClickListener.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends c {
    protected i A;
    protected a B;
    protected PAGNativeAd C;
    protected b.a.a.a.a.a.a.g.c D;
    protected b.c.a.a.a.a.c E;
    protected Map<String, Object> F;
    protected PangleAd G;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.a H;
    protected int I;
    private String J;
    private WeakReference<Activity> K;
    private boolean L;
    protected Context t;
    public m u;
    protected final q v;
    protected final String w;
    protected final int x;
    protected WeakReference<View> y;
    protected WeakReference<View> z;

    /* JADX INFO: compiled from: ClickListener.java */
    public interface a {
        void a(View view, int i);
    }

    public b(Context context, q qVar, String str, int i) {
        this.I = 0;
        this.L = false;
        this.t = context;
        this.v = qVar;
        this.w = str;
        this.x = i;
    }

    public void a(b.c.a.a.a.a.c cVar) {
        this.E = cVar;
    }

    public void a(boolean z) {
    }

    public boolean a(i iVar, Map<String, Object> map) {
        return false;
    }

    public void b(View view) {
        if (view == null) {
            return;
        }
        this.y = new WeakReference<>(view);
    }

    public View c() {
        WeakReference<Activity> weakReference = this.K;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        View viewFindViewById = this.K.get().findViewById(520093713);
        return viewFindViewById == null ? this.K.get().findViewById(520093713) : viewFindViewById;
    }

    public View d() {
        WeakReference<Activity> weakReference = this.K;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.K.get().findViewById(R.id.content);
    }

    public void a(com.bytedance.sdk.openadsdk.core.nativeexpress.a aVar) {
        this.H = aVar;
    }

    public void b(int i) {
        this.h = i;
    }

    public void a(PAGNativeAd pAGNativeAd) {
        this.C = pAGNativeAd;
    }

    public String b() {
        return this.J;
    }

    public void a(PangleAd pangleAd) {
        this.G = pangleAd;
    }

    public void a(b.a.a.a.a.a.a.g.c cVar) {
        this.D = cVar;
    }

    public void d(int i) {
        this.g = i;
    }

    public void a(a aVar) {
        this.B = aVar;
    }

    public void c(int i) {
        this.i = i;
    }

    public static boolean c(View view) {
        return 520093705 == view.getId() || 520093707 == view.getId() || 520093703 == view.getId() || t.g(view.getContext(), "btn_native_creative") == view.getId() || h.t0 == view.getId() || h.e1 == view.getId();
    }

    public void a(Activity activity) {
        if (activity == null) {
            return;
        }
        this.K = new WeakReference<>(activity);
    }

    public void a(View view) {
        if (view == null) {
            return;
        }
        this.z = new WeakReference<>(view);
    }

    public void a(Map<String, Object> map) {
        Map<String, Object> map2 = this.F;
        if (map2 != null) {
            map2.putAll(map);
            map.putAll(this.F);
        }
        this.F = map;
    }

    public void a(int i) {
        this.I = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.c0.c
    public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
        JSONObject jSONObject;
        int i;
        q qVar;
        if (this.t == null) {
            this.t = o.a();
        }
        if ((this.L || !a(view, 1, f, f2, f3, f4, sparseArray, z)) && this.t != null) {
            m mVar = this.u;
            if (mVar != null) {
                int i2 = mVar.l;
                jSONObject = mVar.m;
                i = i2;
            } else {
                jSONObject = null;
                i = -1;
            }
            long j = this.e;
            long j2 = this.f;
            WeakReference<View> weakReference = this.y;
            View view2 = weakReference == null ? null : weakReference.get();
            WeakReference<View> weakReference2 = this.z;
            i iVarA = a(f, f2, f3, f4, sparseArray, j, j2, view2, weakReference2 == null ? null : weakReference2.get(), b(), b0.a(this.t), b0.b(this.t), b0.f(this.t), i, jSONObject);
            this.A = iVarA;
            if (a(iVarA, this.F)) {
                return;
            }
            if (this.D != null) {
                if (this.F == null) {
                    this.F = new HashMap();
                }
                this.F.put("duration", Long.valueOf(this.D.o()));
            }
            if (this.L) {
                com.bytedance.sdk.openadsdk.d.c.a("click", this.v, this.A, this.w, true, this.F, z ? 1 : 2);
                return;
            }
            a aVar = this.B;
            if (aVar != null) {
                aVar.a(view, -1);
            }
            if (a(view, z)) {
                boolean zI = com.bytedance.sdk.openadsdk.core.f0.t.i(this.v);
                String strB = zI ? this.w : a0.b(this.x);
                if (view != null) {
                    try {
                        if (((Boolean) view.getTag(520093762)).booleanValue()) {
                            z.a(true);
                        }
                    } catch (Exception unused) {
                    }
                }
                boolean zA = z.a(this.t, this.v, this.x, this.C, this.G, strB, this.E, zI, 0);
                z.a(false);
                if (zA || (qVar = this.v) == null || qVar.z() == null || this.v.z().c() != 2) {
                    q qVar2 = this.v;
                    if (qVar2 != null && !zA && TextUtils.isEmpty(qVar2.H0()) && com.bytedance.sdk.openadsdk.d.b.a(this.w)) {
                        b.c.a.a.a.a.d.a(this.t, this.v, this.w).b();
                    }
                    com.bytedance.sdk.openadsdk.d.c.a("click", this.v, this.A, this.w, zA, this.F, z ? 1 : 2);
                }
            }
        }
    }

    public b(Context context, q qVar, String str, int i, boolean z) {
        this(context, qVar, str, i);
        this.L = z;
    }

    public boolean a(View view, boolean z) {
        return a(view, this.v, z);
    }

    public static boolean a(View view, q qVar, boolean z) {
        if (view != null && qVar != null) {
            try {
                int i = b.b.a.a.d.d.a.t;
                String strValueOf = String.valueOf(view.getTag(i));
                if (view.getTag(i) != null && !TextUtils.isEmpty(strValueOf)) {
                    if ("click".equals(strValueOf)) {
                        return z;
                    }
                    return true;
                }
            } catch (Exception unused) {
            }
            if (c(view)) {
                if (qVar.y() == 1 && !z) {
                    return false;
                }
            } else if (qVar.l0() == 1 && !z) {
                return false;
            }
        }
        return true;
    }

    protected i a(float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, long j, long j2, View view, View view2, String str, float f5, int i, float f6, int i2, JSONObject jSONObject) {
        return new i.b().b(f).c(f2).e(f3).f(f4).a(j).b(j2).c(b0.a(view)).a(b0.a(view2)).d(b0.c(view)).b(b0.c(view2)).f(this.g).c(this.h).e(this.i).a(sparseArray).d(com.bytedance.sdk.openadsdk.core.h.a().s() ? 1 : 2).a(str).a(f5).b(i).d(f6).a(i2).a(jSONObject).a();
    }

    protected boolean a(View view, int i, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
        if (this.H == null) {
            return false;
        }
        int[] iArrA = new int[2];
        int[] iArrC = new int[2];
        WeakReference<View> weakReference = this.z;
        if (weakReference != null) {
            iArrA = b0.a(weakReference.get());
            iArrC = b0.c(this.z.get());
        }
        this.H.a(view, i, new m.b().a(f).b(f2).c(f3).d(f4).a(this.e).b(this.f).d(iArrA[0]).e(iArrA[1]).c(iArrC[0]).b(iArrC[1]).a(sparseArray).a(z).a());
        return true;
    }

    public void a(String str) {
        this.J = str;
    }
}
