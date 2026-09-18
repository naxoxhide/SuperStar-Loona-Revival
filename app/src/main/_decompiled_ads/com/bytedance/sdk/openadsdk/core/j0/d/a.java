package com.bytedance.sdk.openadsdk.core.j0.d;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import b.a.a.a.a.a.a.f.c;
import b.b.a.a.f.a.g;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.d.r.b.i;
import com.bytedance.sdk.openadsdk.d.r.b.j;
import com.bytedance.sdk.openadsdk.d.r.b.k;
import com.bytedance.sdk.openadsdk.d.r.b.l;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.igaworks.adpopcorn.nativead.custom.ApCustomRewardCPMError;
import org.json.JSONObject;

/* JADX INFO: compiled from: VideoPreloadFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final b.a.a.a.a.a.a.h.a a = new b.a.a.a.a.a.b.b.c.a();

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(c cVar, q qVar, AdSlot adSlot, long j, int i, String str) {
        if (a(cVar)) {
            String strD = a0.d(adSlot.getDurationSlotType());
            JSONObject jSONObjectA = com.bytedance.sdk.openadsdk.d.r.a.a.a(qVar, (String) null, -1, cVar);
            j jVar = new j();
            jVar.c(cVar.m());
            jVar.b(cVar.j());
            jVar.a(j);
            jVar.a(i);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            jVar.a(str);
            jVar.b("");
            com.bytedance.sdk.openadsdk.d.r.a.a.b((com.bytedance.sdk.openadsdk.d.r.b.a<j>) new com.bytedance.sdk.openadsdk.d.r.b.a(qVar, strD, jSONObjectA, jVar));
        }
    }

    private static void c(c cVar, q qVar, AdSlot adSlot) {
        if (a(cVar)) {
            com.bytedance.sdk.openadsdk.d.r.a.a.c((com.bytedance.sdk.openadsdk.d.r.b.a<k>) new com.bytedance.sdk.openadsdk.d.r.b.a(qVar, a0.d(adSlot.getDurationSlotType()), com.bytedance.sdk.openadsdk.d.r.a.a.a(qVar, (String) null, -1, cVar), new k(cVar.m(), cVar.u() ? cVar.p() : cVar.j())));
        }
    }

    public static void a(c cVar, b.a.a.a.a.a.a.h.a.InterfaceC0009a interfaceC0009a) {
        AdSlot adSlot;
        if ((cVar.j() > 0 || cVar.u()) && cVar.i() != -2) {
            if (cVar.i() != 1) {
                cVar.a(ApCustomRewardCPMError.PARTICIPATION_FAILED);
                cVar.c(ApCustomRewardCPMError.PARTICIPATION_FAILED);
                cVar.g(ApCustomRewardCPMError.PARTICIPATION_FAILED);
                boolean z = cVar.a("material_meta") != null && (cVar.a("material_meta") instanceof q);
                boolean z2 = cVar.a("ad_slot") != null && (cVar.a("ad_slot") instanceof AdSlot);
                q qVar = null;
                if (z && z2) {
                    qVar = (q) cVar.a("material_meta");
                    adSlot = (AdSlot) cVar.a("ad_slot");
                    c(cVar, qVar, adSlot);
                } else {
                    adSlot = null;
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                C0210a c0210a = new C0210a(interfaceC0009a, qVar, adSlot, jElapsedRealtime, cVar);
                if (!a(cVar.m())) {
                    if (interfaceC0009a != null) {
                        interfaceC0009a.a(cVar, TTAdConstant.DEEPLINK_FALLBACK_CODE, "unexpected url: " + cVar.m());
                    }
                    b(cVar, qVar, adSlot, SystemClock.elapsedRealtime() - jElapsedRealtime, -1, "video url is invalid");
                    return;
                } else {
                    if (Build.VERSION.SDK_INT >= 23) {
                        try {
                            a.a(o.a(), cVar, c0210a);
                            return;
                        } catch (Exception e) {
                            m.f("VideoPreloadUtils", e.getMessage());
                            return;
                        }
                    }
                    b.a.a.a.a.a.b.c.q.a.b().a(cVar);
                    return;
                }
            }
        }
        if (interfaceC0009a != null) {
            interfaceC0009a.a(cVar, 100);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.j0.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VideoPreloadFactory.java */
    static class C0210a implements b.a.a.a.a.a.a.h.a.InterfaceC0009a {
        final /* synthetic */ b.a.a.a.a.a.a.h.a.InterfaceC0009a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f639b;
        final /* synthetic */ AdSlot c;
        final /* synthetic */ long d;
        final /* synthetic */ c e;

        C0210a(b.a.a.a.a.a.a.h.a.InterfaceC0009a interfaceC0009a, q qVar, AdSlot adSlot, long j, c cVar) {
            this.a = interfaceC0009a;
            this.f639b = qVar;
            this.c = adSlot;
            this.d = j;
            this.e = cVar;
        }

        @Override // b.a.a.a.a.a.a.h.a.InterfaceC0009a
        public void a(c cVar, int i) {
            b.a.a.a.a.a.a.h.a.InterfaceC0009a interfaceC0009a = this.a;
            if (interfaceC0009a != null) {
                interfaceC0009a.a(cVar, i);
            }
            if (this.f639b == null || this.c == null) {
                return;
            }
            a.b(this.e, this.f639b, this.c, SystemClock.elapsedRealtime() - this.d);
        }

        @Override // b.a.a.a.a.a.a.h.a.InterfaceC0009a
        public void b(c cVar, int i) {
            AdSlot adSlot;
            b.a.a.a.a.a.a.h.a.InterfaceC0009a interfaceC0009a = this.a;
            if (interfaceC0009a != null) {
                interfaceC0009a.a(cVar, i);
            }
            q qVar = this.f639b;
            if (qVar != null && (adSlot = this.c) != null) {
                a.b(this.e, qVar, adSlot);
            }
            m.c("VideoPreloadUtils", "cancel: ", this.e.e());
        }

        @Override // b.a.a.a.a.a.a.h.a.InterfaceC0009a
        public void a(c cVar, int i, String str) {
            b.a.a.a.a.a.a.h.a.InterfaceC0009a interfaceC0009a = this.a;
            if (interfaceC0009a != null) {
                interfaceC0009a.a(cVar, i, str);
            }
            if (this.f639b == null || this.c == null) {
                return;
            }
            a.b(this.e, this.f639b, this.c, SystemClock.elapsedRealtime() - this.d, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(c cVar, q qVar, AdSlot adSlot, long j) {
        if (a(cVar)) {
            String strD = a0.d(adSlot.getDurationSlotType());
            JSONObject jSONObjectA = com.bytedance.sdk.openadsdk.d.r.a.a.a(qVar, (String) null, -1, cVar);
            l lVar = new l();
            lVar.a(cVar.m());
            lVar.c(cVar.j());
            lVar.a(j);
            if (cVar.l() == 1) {
                lVar.b(1L);
            } else {
                lVar.b(0L);
            }
            com.bytedance.sdk.openadsdk.d.r.a.a.d((com.bytedance.sdk.openadsdk.d.r.b.a<l>) new com.bytedance.sdk.openadsdk.d.r.b.a(qVar, strD, jSONObjectA, lVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(c cVar, q qVar, AdSlot adSlot) {
        if (a(cVar)) {
            com.bytedance.sdk.openadsdk.d.r.a.a.a((com.bytedance.sdk.openadsdk.d.r.b.a<i>) new com.bytedance.sdk.openadsdk.d.r.b.a(qVar, a0.d(adSlot.getDurationSlotType()), com.bytedance.sdk.openadsdk.d.r.a.a.a(qVar, (String) null, -1, cVar), new i(cVar.m(), cVar.j())));
        }
    }

    private static boolean a(c cVar) {
        return Build.VERSION.SDK_INT >= 23 || cVar.i() != 0;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.regionMatches(true, 0, "ws:", 0, 3)) {
            str = "http:" + str.substring(3);
        } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
            str = "https:" + str.substring(4);
        }
        return g.b(str) != null;
    }
}
