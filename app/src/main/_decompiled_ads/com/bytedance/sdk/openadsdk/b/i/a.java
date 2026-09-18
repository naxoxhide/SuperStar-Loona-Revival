package com.bytedance.sdk.openadsdk.b.i;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.common.b;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.s;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.d.c;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: FeedAdManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f452b;
    private final p a = o.c();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.b.i.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FeedAdManager.java */
    class C0178a implements p.a {
        final /* synthetic */ b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f453b;
        final /* synthetic */ AdSlot c;
        final /* synthetic */ z d;

        C0178a(a aVar, b bVar, Context context, AdSlot adSlot, z zVar) {
            this.a = bVar;
            this.f453b = context;
            this.c = adSlot;
            this.d = zVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.a
        public void a(com.bytedance.sdk.openadsdk.core.f0.a aVar, com.bytedance.sdk.openadsdk.core.f0.b bVar) {
            if (aVar.b() == null || aVar.b().isEmpty()) {
                this.a.onError(-3, g.a(-3));
                bVar.a(-3);
                com.bytedance.sdk.openadsdk.core.f0.b.a(bVar);
                return;
            }
            List<q> listB = aVar.b();
            ArrayList arrayList = new ArrayList(listB.size());
            Iterator<q> it = listB.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (q.c(next) || (next != null && next.j1())) {
                    com.bytedance.sdk.openadsdk.a.c.b bVar2 = new com.bytedance.sdk.openadsdk.a.c.b(this.f453b, next, 5, this.c);
                    if (this.a instanceof PAGNativeAdLoadListener) {
                        arrayList.add(bVar2);
                    }
                }
                if (q.c(next) && next.N0() != null && next.N0().t() != null) {
                    if (o.d().n(String.valueOf(next.S())) && o.d().b0()) {
                        if (next.N0() != null) {
                            next.N0().i(1);
                        }
                        if (next.Z() != null) {
                            next.Z().i(1);
                        }
                        com.bytedance.sdk.openadsdk.core.j0.a.b bVarA = q.a(CacheDirFactory.getICacheDir(next.u0()).d(), next);
                        bVarA.a("material_meta", next);
                        bVarA.a("ad_slot", this.c);
                        com.bytedance.sdk.openadsdk.core.j0.d.a.a(bVarA, null);
                    }
                }
            }
            if (!((this.a instanceof PAGNativeAdLoadListener) && !arrayList.isEmpty())) {
                this.a.onError(-4, g.a(-4));
                bVar.a(-4);
                com.bytedance.sdk.openadsdk.core.f0.b.a(bVar);
                return;
            }
            AdSlot adSlot = this.c;
            if (adSlot == null) {
                c.b(listB.get(0), a0.d(5), this.d);
            } else if (TextUtils.isEmpty(adSlot.getBidAdm())) {
                c.b(listB.get(0), a0.d(this.c.getDurationSlotType()), this.d);
            } else {
                c.b(listB.get(0), "embeded_ad", this.d.d());
            }
            b bVar3 = this.a;
            if (bVar3 instanceof PAGNativeAdLoadListener) {
                ((PAGNativeAdLoadListener) bVar3).onAdLoaded(arrayList.get(0));
            }
            if (bVar.c() == null || bVar.c().isEmpty()) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.f0.b.a(bVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.a
        public void onError(int i, String str) {
            this.a.onError(i, str);
        }
    }

    private a() {
    }

    public static a a() {
        if (f452b == null) {
            synchronized (a.class) {
                if (f452b == null) {
                    f452b = new a();
                }
            }
        }
        return f452b;
    }

    public void a(Context context, AdSlot adSlot, b bVar) {
        this.a.a(adSlot, new s(), 5, new C0178a(this, bVar, context, adSlot, z.c()));
    }
}
