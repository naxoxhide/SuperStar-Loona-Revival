package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoMediaView;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.c0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: InteractionManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class n {
    private final com.bytedance.sdk.openadsdk.core.f0.q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b.c.a.a.a.a.c f642b;
    private final Context c;
    private final PAGNativeAd d;
    private String f;
    private com.bytedance.sdk.openadsdk.a.c.f g;
    private long h;
    private com.bytedance.sdk.openadsdk.a.c.a j;
    private b.a.a.a.a.a.a.g.c k;
    private com.bytedance.sdk.openadsdk.core.c0.b m;
    private com.bytedance.sdk.openadsdk.core.c0.a n;
    private List<View> e = new ArrayList();
    private com.bytedance.sdk.openadsdk.d.g i = new com.bytedance.sdk.openadsdk.d.g();
    private final AtomicBoolean l = new AtomicBoolean(false);

    /* JADX INFO: compiled from: InteractionManager.java */
    class a implements com.bytedance.sdk.openadsdk.core.c0.b.a {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.b.a
        public void a(View view, int i) {
            if (n.this.g != null) {
                n.this.g.b(view, n.this.d);
            }
        }
    }

    /* JADX INFO: compiled from: InteractionManager.java */
    class b implements com.bytedance.sdk.openadsdk.core.c0.b.a {
        b() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.b.a
        public void a(View view, int i) {
            if (n.this.g != null) {
                n.this.g.a(view, n.this.d);
            }
            com.bytedance.sdk.openadsdk.q.c.e.a(n.this.a, 9);
            n.this.j.k();
        }
    }

    /* JADX INFO: compiled from: InteractionManager.java */
    class c extends com.bytedance.sdk.openadsdk.core.c0.c {
        c(n nVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.c
        protected void a(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> sparseArray, boolean z) {
            if (view instanceof PAGVideoMediaView) {
                ((PAGVideoMediaView) view).handleInterruptVideo();
            }
        }
    }

    /* JADX INFO: compiled from: InteractionManager.java */
    class d implements EmptyView.d {
        final /* synthetic */ ViewGroup a;

        d(ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.d
        public void a() {
            n.this.b(this.a);
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.d
        public void onDetachedFromWindow() {
            n.this.b();
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.d
        public void onWindowFocusChanged(boolean z) {
            n.this.a(z, this.a);
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.d
        @JProtect
        public void a(View view) {
            n.this.b(this.a, view);
        }
    }

    /* JADX INFO: compiled from: InteractionManager.java */
    class e implements c0.f {
        final /* synthetic */ ViewGroup a;

        e(ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // com.bytedance.sdk.openadsdk.utils.c0.f
        public void a() {
            n.this.b(this.a);
        }

        @Override // com.bytedance.sdk.openadsdk.utils.c0.f
        public void onDetachedFromWindow() {
            n.this.b();
        }

        @Override // com.bytedance.sdk.openadsdk.utils.c0.f
        public void onWindowFocusChanged(boolean z) {
            n.this.a(z, this.a);
        }

        @Override // com.bytedance.sdk.openadsdk.utils.c0.f
        public void a(View view, boolean z) {
            if (z) {
                n.this.b(this.a, view);
            }
        }
    }

    /* JADX INFO: compiled from: InteractionManager.java */
    private static class f implements View.OnLayoutChangeListener {
        private final com.bytedance.sdk.openadsdk.d.g a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ViewGroup f645b;

        public f(com.bytedance.sdk.openadsdk.d.g gVar, ViewGroup viewGroup) {
            this.a = gVar;
            this.f645b = viewGroup;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.a.a(System.currentTimeMillis(), y.a(this.f645b));
        }
    }

    public n(Context context, PAGNativeAd pAGNativeAd, com.bytedance.sdk.openadsdk.core.f0.q qVar, String str, com.bytedance.sdk.openadsdk.a.c.a aVar) {
        this.f = "embeded_ad";
        this.d = pAGNativeAd;
        this.a = qVar;
        this.c = context;
        this.f = str;
        this.j = aVar;
        if (qVar.e0() == 4) {
            this.f642b = b.c.a.a.a.a.d.a(context, qVar, this.f);
        }
    }

    private void b(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.a.c.f fVar) {
        this.g = fVar;
        viewGroup.addOnLayoutChangeListener(new f(this.i, viewGroup));
        this.e = list;
        a(list2, (com.bytedance.sdk.openadsdk.core.c0.c) null);
        if (list != null) {
            for (View view : this.e) {
                if (view != null) {
                    view.setTag(520093762, Boolean.TRUE);
                }
            }
            list3.addAll(list);
        }
        a(list3, (com.bytedance.sdk.openadsdk.core.c0.c) null);
    }

    private void c(ViewGroup viewGroup) {
        c0.a(viewGroup, true, 5, new e(viewGroup), null);
    }

    public com.bytedance.sdk.openadsdk.d.g a() {
        return this.i;
    }

    public void a(View view, int i) {
        com.bytedance.sdk.openadsdk.a.c.f fVar = this.g;
        if (fVar != null) {
            fVar.a(view, this.d);
        }
    }

    public void a(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.bytedance.sdk.openadsdk.a.c.f fVar) {
        if (Build.VERSION.SDK_INT < 18) {
            EmptyView emptyViewA = a(viewGroup, list, list2, list3, fVar);
            a(viewGroup, view);
            a(viewGroup, emptyViewA, list2, list3);
            emptyViewA.setNeedCheckingShow(true);
            return;
        }
        b(viewGroup, list, list2, list3, fVar);
        a(viewGroup, view);
        a(viewGroup, list2, list3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ViewGroup viewGroup) {
        this.i.a(System.currentTimeMillis(), y.a(viewGroup));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.h > 0) {
            com.bytedance.sdk.openadsdk.d.c.a((SystemClock.elapsedRealtime() - this.h) + "", this.a, this.f, this.i);
            this.h = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ViewGroup viewGroup, View view) {
        if (this.l.get()) {
            return;
        }
        this.l.set(true);
        this.i.a(System.currentTimeMillis(), y.a(viewGroup));
        this.h = SystemClock.elapsedRealtime();
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.e != null) {
                JSONArray jSONArray = new JSONArray();
                for (View view2 : this.e) {
                    if (view2 != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("width", view2.getWidth());
                            jSONObject2.put("height", view2.getHeight());
                            jSONObject2.put("alpha", view2.getAlpha());
                        } catch (Throwable unused) {
                        }
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("image_view", jSONArray.toString());
            }
            if (viewGroup != null) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("width", viewGroup.getWidth());
                    jSONObject3.put("height", viewGroup.getHeight());
                    jSONObject3.put("alpha", viewGroup.getAlpha());
                } catch (Throwable unused2) {
                }
                jSONObject.put("root_view", jSONObject3.toString());
            }
            PAGMediaView pAGMediaViewC = this.j.c();
            if (pAGMediaViewC != null) {
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("width", b0.b(this.c, pAGMediaViewC.getWidth()) * 1.0f);
                    jSONObject4.put("height", b0.b(this.c, pAGMediaViewC.getHeight()) * 1.0f);
                } catch (Throwable unused3) {
                }
                jSONObject.put("media_view", jSONObject4.toString());
            }
            com.bytedance.sdk.openadsdk.d.c.b(this.a, this.f, jSONObject);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.m.b("InteractionManager", "onShowFun json error", e2);
        }
        com.bytedance.sdk.openadsdk.a.c.f fVar = this.g;
        if (fVar != null) {
            fVar.a(this.d);
        }
        if (this.a.C0()) {
            com.bytedance.sdk.openadsdk.utils.a0.a(this.a, view);
        }
        if (this.a.M0() != null) {
            this.a.M0().m().d(0L);
        }
    }

    private void a(List<View> list, com.bytedance.sdk.openadsdk.core.c0.c cVar) {
        if (com.bytedance.sdk.component.utils.k.b(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(cVar);
                    view.setOnTouchListener(cVar);
                }
            }
        }
    }

    private EmptyView a(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.a.c.f fVar) {
        this.g = fVar;
        viewGroup.addOnLayoutChangeListener(new f(this.i, viewGroup));
        this.e = list;
        EmptyView emptyViewA = a(viewGroup);
        if (emptyViewA == null) {
            emptyViewA = new EmptyView(this.c, viewGroup);
            viewGroup.addView(emptyViewA);
        }
        emptyViewA.f();
        emptyViewA.setRefClickViews(list2);
        if (list != null) {
            for (View view : this.e) {
                if (view != null) {
                    view.setTag(520093762, Boolean.TRUE);
                }
            }
            list3.addAll(list);
        }
        emptyViewA.setRefCreativeViews(list3);
        return emptyViewA;
    }

    public void a(b.a.a.a.a.a.a.g.c cVar) {
        this.k = cVar;
        com.bytedance.sdk.openadsdk.core.c0.b bVar = this.m;
        if (bVar != null) {
            bVar.a(cVar);
        }
        com.bytedance.sdk.openadsdk.core.c0.a aVar = this.n;
        if (aVar != null) {
            aVar.a(cVar);
        }
    }

    private void a(ViewGroup viewGroup, View view) {
        HashMap map = new HashMap();
        map.put("click_scence", 1);
        Context context = this.c;
        com.bytedance.sdk.openadsdk.core.f0.q qVar = this.a;
        String str = this.f;
        com.bytedance.sdk.openadsdk.core.c0.b bVar = new com.bytedance.sdk.openadsdk.core.c0.b(context, qVar, str, com.bytedance.sdk.openadsdk.utils.a0.f(str));
        this.m = bVar;
        bVar.b(viewGroup);
        this.m.a(this.k);
        this.m.a(view);
        this.m.a(this.f642b);
        this.m.a(this.d);
        this.m.a(map);
        this.m.a(new a());
        Context context2 = this.c;
        com.bytedance.sdk.openadsdk.core.f0.q qVar2 = this.a;
        String str2 = this.f;
        com.bytedance.sdk.openadsdk.core.c0.a aVar = new com.bytedance.sdk.openadsdk.core.c0.a(context2, qVar2, str2, com.bytedance.sdk.openadsdk.utils.a0.f(str2));
        this.n = aVar;
        aVar.b(viewGroup);
        this.n.a(this.k);
        this.n.a(view);
        this.n.a(this.f642b);
        this.n.a(this.d);
        this.n.a(map);
        this.n.a(new b());
    }

    private void a(ViewGroup viewGroup, EmptyView emptyView, List<View> list, List<View> list2) {
        com.bytedance.sdk.openadsdk.core.c0.b bVar = this.m;
        if (bVar == null || this.n == null) {
            return;
        }
        emptyView.a(list, bVar);
        emptyView.a(list2, this.n);
        a(this.n);
        a(emptyView, viewGroup);
    }

    private void a(ViewGroup viewGroup, List<View> list, List<View> list2) {
        com.bytedance.sdk.openadsdk.core.c0.b bVar = this.m;
        if (bVar == null || this.n == null) {
            return;
        }
        a(list, bVar);
        a(list2, this.n);
        a(this.n);
        c(viewGroup);
    }

    private void a(com.bytedance.sdk.openadsdk.core.c0.a aVar) {
        if (com.bytedance.sdk.openadsdk.core.settings.n.j0().m(String.valueOf(this.a.S()))) {
            com.bytedance.sdk.openadsdk.a.c.a aVar2 = this.j;
            if (aVar2 != null && aVar2.j() != null) {
                this.j.j().setOnClickListener(aVar);
                this.j.j().setOnTouchListener(aVar);
            }
            com.bytedance.sdk.openadsdk.a.c.a aVar3 = this.j;
            if (aVar3 != null && aVar3.f() != null) {
                this.j.f().setOnClickListener(aVar);
                this.j.f().setOnTouchListener(aVar);
            }
            com.bytedance.sdk.openadsdk.a.c.a aVar4 = this.j;
            if (aVar4 != null) {
                aVar4.a(aVar);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.a.c.a aVar5 = this.j;
        if (aVar5 != null && aVar5.j() != null) {
            this.j.j().setOnClickListener(null);
            this.j.j().setOnTouchListener(null);
        }
        com.bytedance.sdk.openadsdk.a.c.a aVar6 = this.j;
        if (aVar6 != null && aVar6.f() != null) {
            PAGMediaView pAGMediaViewF = this.j.f();
            c cVar = new c(this);
            pAGMediaViewF.setOnClickListener(cVar);
            pAGMediaViewF.setOnTouchListener(cVar);
        }
        com.bytedance.sdk.openadsdk.a.c.a aVar7 = this.j;
        if (aVar7 != null) {
            aVar7.a((com.bytedance.sdk.openadsdk.core.c0.a) null);
        }
    }

    private void a(EmptyView emptyView, ViewGroup viewGroup) {
        emptyView.setCallback(new d(viewGroup));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, ViewGroup viewGroup) {
        if (z && this.a.Q0() && !this.a.R0()) {
            this.a.b(true);
            com.bytedance.sdk.openadsdk.core.f0.q qVar = this.a;
            com.bytedance.sdk.openadsdk.d.c.a(qVar, this.f, qVar.t());
        }
        if (!z && this.h > 0) {
            String str = (SystemClock.elapsedRealtime() - this.h) + "";
            this.i.a(System.currentTimeMillis(), y.a(viewGroup));
            com.bytedance.sdk.openadsdk.d.c.a(str, this.a, this.f, this.i);
            this.h = 0L;
            return;
        }
        this.i.a(System.currentTimeMillis(), y.a(viewGroup));
        this.h = SystemClock.elapsedRealtime();
    }

    private EmptyView a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }
}
