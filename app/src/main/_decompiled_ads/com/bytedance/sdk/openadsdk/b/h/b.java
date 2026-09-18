package com.bytedance.sdk.openadsdk.b.h;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import b.c.a.a.a.a.d;
import com.bytedance.sdk.openadsdk.component.view.PAGAppOpenAdExpressView;
import com.bytedance.sdk.openadsdk.core.c0.c;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.t;
import com.bytedance.sdk.openadsdk.core.nativeexpress.f;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import java.util.HashMap;

/* JADX INFO: compiled from: TTAppOpenAdClickManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: compiled from: TTAppOpenAdClickManager.java */
    static class a extends g {
        final /* synthetic */ com.bytedance.sdk.openadsdk.b.p.a M;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, q qVar, String str, int i, com.bytedance.sdk.openadsdk.b.p.a aVar) {
            super(context, qVar, str, i);
            this.M = aVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.b, com.bytedance.sdk.openadsdk.core.c0.c
        public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
            HashMap map = new HashMap();
            map.put("duration", Long.valueOf(this.M.a()));
            a(map);
            super.a(view, f, f2, f3, f4, sparseArray, z);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.b.h.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TTAppOpenAdClickManager.java */
    static class C0177b extends f {
        final /* synthetic */ com.bytedance.sdk.openadsdk.b.p.a R;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0177b(Context context, q qVar, String str, int i, com.bytedance.sdk.openadsdk.b.p.a aVar) {
            super(context, qVar, str, i);
            this.R = aVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.a, com.bytedance.sdk.openadsdk.core.c0.b, com.bytedance.sdk.openadsdk.core.c0.c
        public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
            HashMap map = new HashMap();
            map.put("duration", Long.valueOf(this.R.a()));
            a(map);
            super.a(view, f, f2, f3, f4, sparseArray, z);
        }
    }

    public static com.bytedance.sdk.openadsdk.b.h.a a(q qVar, Activity activity, com.bytedance.sdk.openadsdk.b.p.a aVar) {
        com.bytedance.sdk.openadsdk.b.h.a aVar2 = new com.bytedance.sdk.openadsdk.b.h.a(activity.getApplicationContext(), qVar, "open_ad", 4, aVar);
        aVar2.b(activity.findViewById(R.id.content));
        aVar2.a(activity.findViewById(520093713));
        a(activity.getApplicationContext(), qVar, aVar2);
        a(aVar2, qVar);
        return aVar2;
    }

    public static g b(q qVar, Activity activity, com.bytedance.sdk.openadsdk.b.p.a aVar, PAGAppOpenAdExpressView pAGAppOpenAdExpressView) {
        a aVar2 = new a(activity.getApplicationContext(), qVar, "open_ad", 4, aVar);
        aVar2.b(pAGAppOpenAdExpressView);
        a(activity.getApplicationContext(), qVar, aVar2);
        a(aVar2, qVar);
        return aVar2;
    }

    public static f a(q qVar, Activity activity, com.bytedance.sdk.openadsdk.b.p.a aVar, PAGAppOpenAdExpressView pAGAppOpenAdExpressView) {
        C0177b c0177b = new C0177b(activity.getApplicationContext(), qVar, "open_ad", 4, aVar);
        c0177b.b(pAGAppOpenAdExpressView);
        a(activity.getApplicationContext(), qVar, c0177b);
        a(c0177b, qVar);
        return c0177b;
    }

    public static void a(com.bytedance.sdk.openadsdk.core.c0.b bVar, q qVar) {
        HashMap map = new HashMap();
        map.put("click_area", Integer.valueOf(qVar.k()));
        map.put("openad_creative_type", q.c(qVar) ? "video_normal_ad" : "image_normal_ad");
        map.put("click_scence", Integer.valueOf(t.h(qVar) ? 3 : 1));
        bVar.a(map);
    }

    private static void a(Context context, q qVar, com.bytedance.sdk.openadsdk.core.c0.b bVar) {
        if (qVar == null || qVar.e0() != 4) {
            return;
        }
        bVar.a(d.a(context, qVar, "open_ad"));
    }
}
