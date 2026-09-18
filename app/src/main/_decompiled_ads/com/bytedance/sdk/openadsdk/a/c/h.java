package com.bytedance.sdk.openadsdk.a.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: TTNativeAdImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends PAGNativeAd {
    protected final n a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final q f390b;
    protected final Context c;
    protected com.bytedance.sdk.openadsdk.a.c.a d;
    protected int e;
    protected int f;
    protected String g;
    private boolean h;
    private boolean i;

    /* JADX INFO: compiled from: TTNativeAdImpl.java */
    class a implements View.OnClickListener {
        final /* synthetic */ f a;

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.a.c.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TTNativeAdImpl.java */
        class C0168a implements com.bytedance.sdk.openadsdk.core.bannerexpress.a.h {
            final /* synthetic */ String a;

            C0168a(String str) {
                this.a = str;
            }

            @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a.h
            public void onItemClickClosed() {
                a.this.a.onAdDismissed();
                com.bytedance.sdk.openadsdk.core.h.a().f(this.a);
                PAGMediaView pAGMediaViewF = h.this.d().f();
                if (pAGMediaViewF != null) {
                    pAGMediaViewF.close();
                }
            }
        }

        a(f fVar) {
            this.a = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String strA = com.bytedance.sdk.openadsdk.utils.q.a();
            TTDelegateActivity.a(h.this.f390b, strA, new C0168a(strA));
        }
    }

    public h(Context context, q qVar, int i) {
        if (qVar == null) {
            m.b("materialMeta can't been null");
        }
        this.f390b = qVar;
        this.c = context;
        this.e = i;
        this.f = qVar.S();
        String strD = a0.d(i);
        this.g = strD;
        this.d = new com.bytedance.sdk.openadsdk.a.c.a(context, qVar, strD);
        this.a = new n(context, this, qVar, a(i), this.d);
    }

    private String a(int i) {
        if (i != 1) {
            return i != 2 ? "embeded_ad" : "interaction";
        }
        return "banner_ad";
    }

    protected List<View> a(List<View> list, List<View> list2) {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                linkedList.add(list.get(i));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                linkedList.add(list2.get(i2));
            }
        }
        return linkedList;
    }

    public com.bytedance.sdk.openadsdk.a.c.a d() {
        return this.d;
    }

    protected boolean e() {
        q qVar = this.f390b;
        return (qVar == null || qVar.e0() == 5 || o.d().c(this.f) != 1) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        q qVar = this.f390b;
        if (qVar != null) {
            return qVar.i0();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public PAGNativeAdData getNativeAdData() {
        return new d(d());
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d, String str, String str2) {
        if (this.i) {
            return;
        }
        u.a(this.f390b, d, str, str2);
        this.i = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, PAGNativeAdInteractionListener pAGNativeAdInteractionListener) {
        if (viewGroup == null) {
            m.b("container can't been null");
            return;
        }
        if (list == null) {
            m.b("clickView can't been null");
        } else if (list.size() <= 0) {
            m.b("clickViews size must been more than 1");
        } else {
            a(viewGroup, null, list, list2, view, new g(pAGNativeAdInteractionListener));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d) {
        if (this.h) {
            return;
        }
        u.a(this.f390b, d);
        this.h = true;
    }

    protected void a(String str) {
        this.g = str;
    }

    public void a(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, f fVar) {
        if (viewGroup == null) {
            m.b("container can't been null");
            return;
        }
        if (list2 == null) {
            m.b("clickView can't been null");
            return;
        }
        if (list2.size() <= 0) {
            m.b("clickViews size must been more than 1");
            return;
        }
        if (e()) {
            list3 = a(list2, list3);
        }
        List<View> list4 = list3;
        if (view != null && fVar != null && fVar.a()) {
            view.setOnClickListener(new a(fVar));
        }
        this.a.a(viewGroup, list, list2, list4, view, fVar);
        com.bytedance.sdk.openadsdk.q.c.e.a(viewGroup, this.f390b, -1);
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, PAGNativeAdInteractionCallback pAGNativeAdInteractionCallback) {
        registerViewForInteraction(viewGroup, list, list2, view, (PAGNativeAdInteractionListener) pAGNativeAdInteractionCallback);
    }
}
