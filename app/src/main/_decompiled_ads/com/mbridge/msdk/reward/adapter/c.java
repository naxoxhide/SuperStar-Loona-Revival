package com.mbridge.msdk.reward.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebView;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.facebook.ads.AdError;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.reward.player.MBRewardVideoActivity;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.videocommon.download.i;
import com.mbridge.msdk.videocommon.download.l;
import com.mbridge.msdk.videocommon.download.n;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardMVVideoAdapter.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private int B;
    private int C;
    private int D;
    private CampaignUnit E;
    private CopyOnWriteArrayList<CampaignEx> F;
    private String I;
    private d J;
    private List<CampaignEx> Q;
    private List<CampaignEx> R;
    private Context l;
    private String m;
    private String n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private String s;
    private h t;
    private volatile com.mbridge.msdk.reward.adapter.a u;
    private com.mbridge.msdk.videocommon.d.c v;
    private boolean y;
    private boolean z;
    private CopyOnWriteArrayList<CampaignEx> w = new CopyOnWriteArrayList<>();
    private int x = 2;
    private String A = "";
    private boolean G = false;
    private long H = 0;
    private boolean K = false;
    private boolean L = false;
    public String a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2375b = "";
    public String c = "";
    public Object d = new Object();
    private Handler M = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.reward.adapter.c.1
        /* JADX WARN: Code duplicated, block: B:107:0x0309  */
        /* JADX WARN: Code duplicated, block: B:281:0x02da A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:96:0x028f  */
        /* JADX WARN: Code duplicated, block: B:97:0x0291  */
        /* JADX WARN: Code restructure failed: missing block: B:178:0x050f, code lost:
        
            if (r6 == (-1)) goto L179;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void handleMessage(android.os.Message r26) {
            /*
                Method dump skipped, instruction units count: 1940
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.AnonymousClass1.handleMessage(android.os.Message):void");
        }
    };
    boolean e = false;
    private boolean N = false;
    private long O = 0;
    volatile boolean f = false;
    volatile boolean g = false;
    volatile boolean h = false;
    volatile boolean i = false;
    volatile boolean j = false;
    public volatile boolean k = false;
    private String P = "";

    public final String a(boolean z) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA;
        CampaignEx campaignEx;
        if (z) {
            if (TextUtils.isEmpty(this.f2375b) && (copyOnWriteArrayListA = com.mbridge.msdk.videocommon.download.c.getInstance().a(this.m)) != null && copyOnWriteArrayListA.size() > 0 && (campaignEx = copyOnWriteArrayListA.get(0)) != null) {
                this.f2375b = campaignEx.getRequestId();
            }
            return this.f2375b;
        }
        return this.a;
    }

    public final void b(boolean z) {
        this.y = z;
    }

    public final void c(boolean z) {
        this.z = z;
    }

    public final void a(String str) {
        this.A = str;
    }

    public final void a(int i) {
        this.x = i;
    }

    public final String a() {
        return this.m;
    }

    public final boolean a(CampaignEx campaignEx, boolean z, com.mbridge.msdk.foundation.entity.e eVar, int i) {
        if (this.k) {
            return false;
        }
        this.k = true;
        com.mbridge.msdk.foundation.b.c cVarA = new com.mbridge.msdk.reward.a.a(this.m, this.y).a(this.I, this.c, campaignEx, eVar, i, this);
        if (cVarA == null || cVarA.a() <= com.mbridge.msdk.foundation.b.c.f2062b) {
            return false;
        }
        if (cVarA.c() != null && cVarA.c().size() > 0) {
            a(cVarA.c(), z);
            return true;
        }
        if (cVarA.a() != com.mbridge.msdk.foundation.b.c.d || eVar == null) {
            return false;
        }
        eVar.a(eVar.c());
        eVar.a(eVar.d());
        eVar.b(21);
        eVar.b(cVarA.b());
        return false;
    }

    /* JADX INFO: compiled from: RewardMVVideoAdapter.java */
    private class b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f2388b;
        private CampaignEx c;
        private String d;
        private String e;
        private com.mbridge.msdk.videocommon.d.c f;
        private int g;
        private c h;

        public b(String str, CampaignEx campaignEx, String str2, String str3, com.mbridge.msdk.videocommon.d.c cVar, int i, c cVar2) {
            this.f2388b = str;
            this.c = campaignEx;
            this.d = str2;
            this.e = str3;
            this.f = cVar;
            this.g = i;
            this.h = cVar2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j jVar;
            try {
                com.mbridge.msdk.videocommon.a.C0524a c0524a = new com.mbridge.msdk.videocommon.a.C0524a();
                WindVaneWebView windVaneWebView = new WindVaneWebView(com.mbridge.msdk.foundation.controller.b.d().g());
                c0524a.a(windVaneWebView);
                String strB = com.mbridge.msdk.video.bt.a.c.a().b();
                c0524a.a(strB);
                if (c.this.E.getAds() != null && c.this.E.getAds().size() > 0) {
                    jVar = new j(null, this.c, c.this.E.getAds());
                } else {
                    jVar = new j(null, this.c);
                }
                j jVar2 = jVar;
                jVar2.a(this.g);
                jVar2.a(this.e);
                jVar2.c(strB);
                jVar2.a(this.f);
                jVar2.d(c.this.G);
                windVaneWebView.setWebViewListener(new a(this.d, this.f2388b, c0524a, this.c, this.h, null, null));
                windVaneWebView.setObject(jVar2);
                windVaneWebView.loadUrl(this.d);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                aa.a("RewardMVVideoAdapter", th.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.reward.adapter.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RewardMVVideoAdapter.java */
    private class RunnableC0505c implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WindVaneWebView f2389b;
        private String c;
        private CampaignEx d;
        private List<CampaignEx> e;
        private String f;
        private String g;
        private com.mbridge.msdk.videocommon.d.c h;
        private int i;
        private c j;

        public RunnableC0505c(WindVaneWebView windVaneWebView, String str, CampaignEx campaignEx, List<CampaignEx> list, String str2, String str3, com.mbridge.msdk.videocommon.d.c cVar, int i, c cVar2) {
            this.f2389b = windVaneWebView;
            this.c = str;
            this.d = campaignEx;
            this.e = list;
            this.f = str2;
            this.g = str3;
            this.h = cVar;
            this.i = i;
            this.j = cVar2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j jVar;
            try {
                com.mbridge.msdk.videocommon.a.C0524a c0524a = new com.mbridge.msdk.videocommon.a.C0524a();
                WindVaneWebView windVaneWebView = new WindVaneWebView(com.mbridge.msdk.foundation.controller.b.d().g());
                c0524a.a(windVaneWebView);
                List<CampaignEx> list = this.e;
                if (list != null && list.size() > 0) {
                    jVar = new j(null, this.d, this.e);
                } else {
                    jVar = new j(null, this.d);
                }
                j jVar2 = jVar;
                jVar2.a(this.i);
                jVar2.a(this.g);
                jVar2.a(this.h);
                jVar2.d(c.this.G);
                windVaneWebView.setWebViewListener(new f(this.f2389b, this.f, this.c, c0524a, this.d, this.j, null, null));
                windVaneWebView.setObject(jVar2);
                windVaneWebView.loadUrl(this.f);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                aa.a("RewardMVVideoAdapter", th.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: RewardMVVideoAdapter.java */
    private static class a extends com.mbridge.msdk.mbsignalcommon.b.a {
        private c a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f2387b;
        private String c;
        private com.mbridge.msdk.videocommon.a.C0524a d;
        private CampaignEx e;
        private boolean f;
        private boolean g;
        private b h;
        private Handler i;

        @Override // com.mbridge.msdk.mbsignalcommon.b.a
        public final void a(WebView webView, String str, String str2, int i, int i2) {
        }

        public a(String str, String str2, com.mbridge.msdk.videocommon.a.C0524a c0524a, CampaignEx campaignEx, c cVar, b bVar, Handler handler) {
            this.f2387b = str;
            this.c = str2;
            this.d = c0524a;
            if (cVar != null) {
                this.a = cVar;
            }
            this.e = campaignEx;
            this.h = bVar;
            this.i = handler;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.a, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i) {
            Handler handler;
            if (this.g) {
                return;
            }
            b bVar = this.h;
            if (bVar != null && (handler = this.i) != null) {
                handler.removeCallbacks(bVar);
            }
            i.a().d(this.f2387b, true);
            String str = this.c + "_" + this.f2387b;
            com.mbridge.msdk.videocommon.a.C0524a c0524a = this.d;
            if (c0524a != null) {
                c0524a.a(true);
            }
            List<CampaignEx> listA = com.mbridge.msdk.videocommon.a.a.a().a(this.c, 1, this.a.z);
            if (listA != null && listA.size() > 0) {
                Iterator<CampaignEx> it = listA.iterator();
                while (it.hasNext()) {
                    CampaignEx.c rewardTemplateMode = it.next().getRewardTemplateMode();
                    if (rewardTemplateMode != null && !TextUtils.isEmpty(rewardTemplateMode.e()) && !rewardTemplateMode.e().contains(CampaignEx.KEY_IS_CMPT_ENTRY) && TextUtils.equals(rewardTemplateMode.e(), this.f2387b)) {
                        if (TextUtils.isEmpty(this.e.getCMPTEntryUrl()) && this.e.getMof_tplid() == -1) {
                            String str2 = this.c + "_" + this.e.getRequestIdNotice();
                        } else {
                            String str3 = this.c + "_" + this.e.getMof_tplid() + "_" + this.e.getRequestIdNotice();
                        }
                        c cVar = this.a;
                        if (cVar != null && cVar.y) {
                            if (this.e.isBidCampaign()) {
                                com.mbridge.msdk.videocommon.a.a(287, this.e.getRequestIdNotice(), this.d);
                            }
                        } else if (this.e.isBidCampaign()) {
                            com.mbridge.msdk.videocommon.a.a(94, this.e.getRequestIdNotice(), this.d);
                        }
                    }
                }
            }
            try {
                c cVar2 = this.a;
                if (cVar2 != null) {
                    synchronized (cVar2) {
                        try {
                            c cVar3 = this.a;
                            if (cVar3 != null && cVar3.b() && this.a.M != null) {
                                Message messageObtain = Message.obtain();
                                messageObtain.what = 6;
                                aa.a("RVWindVaneWebView", "WHAT_ON_RES_LOAD_SUCCESS TPL");
                                messageObtain.obj = this.e;
                                this.a.M.sendMessage(messageObtain);
                                this.a.M.removeMessages(5);
                                this.a = null;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                aa.b("RVWindVaneWebView", th2.getMessage(), th2);
            }
            this.g = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.a, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, String str) {
            super.a(webView, str);
            if (this.f) {
                return;
            }
            g.a().a(webView);
            this.f = true;
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x0015 */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:
        
            return;
         */
        @Override // com.mbridge.msdk.mbsignalcommon.b.a, com.mbridge.msdk.mbsignalcommon.windvane.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(android.webkit.WebView r1, int r2, java.lang.String r3, java.lang.String r4) {
            /*
                r0 = this;
                super.a(r1, r2, r3, r4)
                com.mbridge.msdk.reward.adapter.c r1 = r0.a     // Catch: java.lang.Throwable -> L15
                if (r1 == 0) goto L1f
                monitor-enter(r1)     // Catch: java.lang.Throwable -> L15
                com.mbridge.msdk.reward.adapter.c r2 = r0.a     // Catch: java.lang.Throwable -> L12
                com.mbridge.msdk.reward.adapter.c.a(r2, r3, r4)     // Catch: java.lang.Throwable -> L12
                r2 = 0
                r0.a = r2     // Catch: java.lang.Throwable -> L12
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L12
                goto L1f
            L12:
                r2 = move-exception
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L12
                throw r2     // Catch: java.lang.Throwable -> L15
            L15:
                r1 = move-exception
                java.lang.String r2 = "RVWindVaneWebView"
                java.lang.String r3 = r1.getMessage()
                com.mbridge.msdk.foundation.tools.aa.b(r2, r3, r1)
            L1f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.a.a(android.webkit.WebView, int, java.lang.String, java.lang.String):void");
        }
    }

    /* JADX INFO: compiled from: RewardMVVideoAdapter.java */
    private static class f extends com.mbridge.msdk.mbsignalcommon.b.b {
        private c a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WindVaneWebView f2392b;
        private String c;
        private String d;
        private com.mbridge.msdk.videocommon.a.C0524a e;
        private CampaignEx f;
        private boolean g;
        private boolean h;
        private RunnableC0505c i;
        private Handler j;

        public f(WindVaneWebView windVaneWebView, String str, String str2, com.mbridge.msdk.videocommon.a.C0524a c0524a, CampaignEx campaignEx, c cVar, RunnableC0505c runnableC0505c, Handler handler) {
            this.f2392b = windVaneWebView;
            this.c = str;
            this.d = str2;
            this.e = c0524a;
            if (cVar != null) {
                this.a = cVar;
            }
            this.f = campaignEx;
            this.i = runnableC0505c;
            this.j = handler;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i) {
            Handler handler;
            if (this.h) {
                return;
            }
            RunnableC0505c runnableC0505c = this.i;
            if (runnableC0505c != null && (handler = this.j) != null) {
                handler.removeCallbacks(runnableC0505c);
            }
            String str = this.d + "_" + this.c;
            com.mbridge.msdk.videocommon.a.C0524a c0524a = this.e;
            if (c0524a != null) {
                c0524a.a(true);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", 1);
                jSONObject.put("id", str);
                jSONObject.put("unitid", this.d);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            i.a().d(this.c, true);
            com.mbridge.msdk.videocommon.a.a.a().a(this.d, 1, this.a.z);
            c cVar = this.a;
            if (cVar != null && cVar.y) {
                if (this.f.isBidCampaign()) {
                    com.mbridge.msdk.videocommon.a.a(287, this.f.getRequestIdNotice(), this.e);
                }
            } else if (this.f.isBidCampaign()) {
                com.mbridge.msdk.videocommon.a.a(94, this.f.getRequestIdNotice(), this.e);
            }
            try {
                c cVar2 = this.a;
                if (cVar2 != null) {
                    synchronized (cVar2) {
                        try {
                            c cVar3 = this.a;
                            if (cVar3 != null && cVar3.b() && this.a.M != null) {
                                Message messageObtain = Message.obtain();
                                messageObtain.what = 6;
                                messageObtain.obj = this.f;
                                this.a.M.sendMessage(messageObtain);
                                this.a.M.removeMessages(5);
                                this.a = null;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                aa.b("WindVaneWebView", th2.getMessage(), th2);
            }
            this.h = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, String str) {
            super.a(webView, str);
            if (this.g) {
                return;
            }
            g.a().a(webView);
            this.g = true;
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x0015 */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:
        
            return;
         */
        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(android.webkit.WebView r1, int r2, java.lang.String r3, java.lang.String r4) {
            /*
                r0 = this;
                super.a(r1, r2, r3, r4)
                com.mbridge.msdk.reward.adapter.c r1 = r0.a     // Catch: java.lang.Throwable -> L15
                if (r1 == 0) goto L1f
                monitor-enter(r1)     // Catch: java.lang.Throwable -> L15
                com.mbridge.msdk.reward.adapter.c r2 = r0.a     // Catch: java.lang.Throwable -> L12
                com.mbridge.msdk.reward.adapter.c.a(r2, r3, r4)     // Catch: java.lang.Throwable -> L12
                r2 = 0
                r0.a = r2     // Catch: java.lang.Throwable -> L12
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L12
                goto L1f
            L12:
                r2 = move-exception
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L12
                throw r2     // Catch: java.lang.Throwable -> L15
            L15:
                r1 = move-exception
                java.lang.String r2 = "WindVaneWebView"
                java.lang.String r3 = r1.getMessage()
                com.mbridge.msdk.foundation.tools.aa.b(r2, r3, r1)
            L1f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.f.a(android.webkit.WebView, int, java.lang.String, java.lang.String):void");
        }
    }

    public c(Context context, String str, String str2) {
        try {
            this.l = context.getApplicationContext();
            this.m = str2;
            this.n = str;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(com.mbridge.msdk.videocommon.d.c cVar) {
        try {
            this.v = cVar;
            if (cVar == null || cVar.E() * 1000 == com.mbridge.msdk.foundation.same.a.n) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.n = this.v.E() * 1000;
        } catch (Throwable th) {
            aa.b("RewardMVVideoAdapter", th.getMessage(), th);
        }
    }

    public final boolean a(List<CampaignEx> list, boolean z, int i) {
        return a(list, z, i, false);
    }

    public final boolean a(List<CampaignEx> list, boolean z) {
        if (list != null && list.size() > 0) {
            CampaignEx campaignEx = list.get(0);
            if (campaignEx == null) {
                return false;
            }
            com.mbridge.msdk.videocommon.download.c cVar = com.mbridge.msdk.videocommon.download.c.getInstance();
            String str = this.m;
            n nVarC = cVar.c(str);
            if (nVarC == null) {
                nVarC = cVar.createUnitCache(com.mbridge.msdk.foundation.controller.b.d().g(), str, (CopyOnWriteArrayList<CampaignEx>) list, 94, (com.mbridge.msdk.videocommon.listener.a) null);
            }
            if (nVarC != null ? nVarC.a(list, str) : false) {
                if (z) {
                    if (campaignEx.isDynamicView()) {
                        return true;
                    }
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0) {
                        if (campaignEx.getRsIgnoreCheckRule().contains(3)) {
                            aa.b("RewardMVVideoAdapter", "Is not check big template download status");
                            return true;
                        }
                        if (campaignEx.getCMPTEntryUrl().equals(campaignEx.getendcard_url()) && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                            aa.b("RewardMVVideoAdapter", "Is not check big template ENDCARD download status");
                            return true;
                        }
                    }
                    if (i.a().c(this.m + "_" + campaignEx.getRequestId() + "_" + campaignEx.getCMPTEntryUrl())) {
                        aa.a("RewardVideoController", "大模板业务，开始检查大模板预加载情况，大模板预加载成功");
                        return true;
                    }
                } else {
                    if (campaignEx != null && campaignEx.isDynamicView()) {
                        return true;
                    }
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
                        aa.b("RewardMVVideoAdapter", "Is not check template download status");
                        return true;
                    }
                    if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        if (i.a().c(this.m + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e())) {
                            aa.a("RewardVideoController", "非大模板业务，存在播放模板，播放模板预加载成功");
                            return true;
                        }
                    } else {
                        aa.a("RewardVideoController", "非大模板 没有 template");
                        return true;
                    }
                }
            }
        } else {
            aa.a("RewardVideoController", "数据为空");
        }
        return false;
    }

    public final boolean a(List<CampaignEx> list, boolean z, int i, boolean z2) {
        if (list != null && list.size() > 0) {
            CampaignEx campaignEx = list.get(0);
            if (com.mbridge.msdk.videocommon.download.c.getInstance().a(94, this.m, this.z, list.size(), z, i, list, z2)) {
                if (z) {
                    if (campaignEx.isDynamicView()) {
                        return true;
                    }
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0) {
                        if (campaignEx.getRsIgnoreCheckRule().contains(3)) {
                            aa.b("RewardMVVideoAdapter", "Is not check big template download status");
                            return true;
                        }
                        if (campaignEx.getCMPTEntryUrl().equals(campaignEx.getendcard_url()) && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                            aa.b("RewardMVVideoAdapter", "Is not check big template of ENDCARD download status");
                            return true;
                        }
                    }
                    if (i.a().c(this.m + "_" + campaignEx.getRequestId() + "_" + campaignEx.getCMPTEntryUrl())) {
                        return true;
                    }
                } else {
                    if (campaignEx != null && campaignEx.isDynamicView()) {
                        return true;
                    }
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
                        aa.b("RewardMVVideoAdapter", "Is not check template download status");
                        return true;
                    }
                    if (campaignEx.getRewardTemplateMode() == null || TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e()) || i.a().c(this.m + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean b() {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA = com.mbridge.msdk.videocommon.a.a.a().a(this.m, 1, this.z, this.A);
        if (copyOnWriteArrayListA != null && copyOnWriteArrayListA.size() > 0) {
            CampaignEx campaignEx = copyOnWriteArrayListA.get(0);
            int iB = com.mbridge.msdk.videocommon.a.a.a().b(this.m, 1, this.z, this.A);
            if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()) || campaignEx.getNscpt() != 1 || copyOnWriteArrayListA.size() >= iB) {
                return a(copyOnWriteArrayListA, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt());
            }
            return false;
        }
        aa.a("RewardVideoController", "database has not can use data");
        return false;
    }

    public final boolean c() {
        List<CampaignEx> listC = com.mbridge.msdk.videocommon.a.a.a().c(this.m, 1, this.z, this.A);
        if (listC != null && listC.size() > 0) {
            CampaignEx campaignEx = listC.get(0);
            int iB = com.mbridge.msdk.videocommon.a.a.a().b(this.m, 1, this.z, this.A);
            if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()) || campaignEx.getNscpt() != 1 || listC.size() >= iB) {
                return a(listC, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt());
            }
            return false;
        }
        aa.a("test_isReay_db", "database has not can use data");
        return false;
    }

    public final void a(h hVar, String str, String str2, int i, String str3) {
        try {
            this.t = hVar;
            if (this.l != null && !ak.a(this.m)) {
                Intent intent = new Intent(this.l, (Class<?>) MBRewardVideoActivity.class);
                intent.addFlags(268435456);
                intent.putExtra(MBRewardVideoActivity.INTENT_UNITID, this.m);
                intent.putExtra(MBridgeConstans.PLACEMENT_ID, this.n);
                intent.putExtra(MBRewardVideoActivity.INTENT_REWARD, str);
                intent.putExtra(MBRewardVideoActivity.INTENT_MUTE, i);
                intent.putExtra(MBRewardVideoActivity.INTENT_ISIV, this.y);
                intent.putExtra(MBRewardVideoActivity.INTENT_ISBID, this.z);
                intent.putExtra(MBRewardVideoActivity.INTENT_EXTRADATA, str3);
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA = com.mbridge.msdk.videocommon.download.c.getInstance().a(this.m);
                boolean z = false;
                if (copyOnWriteArrayListA != null && copyOnWriteArrayListA.size() > 0) {
                    CampaignEx campaignEx = copyOnWriteArrayListA.get(0);
                    if (campaignEx != null) {
                        this.f2375b = campaignEx.getRequestId();
                        com.mbridge.msdk.reward.b.a.g = campaignEx.getCurrentLRid();
                    }
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                        z = true;
                    }
                    e();
                } else {
                    h hVar2 = this.t;
                    if (hVar2 != null) {
                        hVar2.a("load failed");
                        return;
                    }
                }
                intent.putExtra(MBRewardVideoActivity.INTENT_ISBIG_OFFER, z);
                if (this.y) {
                    intent.putExtra(MBRewardVideoActivity.INTENT_IVREWARD_MODETYPE, this.B);
                    intent.putExtra(MBRewardVideoActivity.INTENT_IVREWARD_VALUETYPE, this.C);
                    intent.putExtra(MBRewardVideoActivity.INTENT_IVREWARD_VALUE, this.D);
                }
                if (!TextUtils.isEmpty(str2)) {
                    intent.putExtra(MBRewardVideoActivity.INTENT_USERID, str2);
                }
                RewardUnitCacheManager.getInstance().add(this.n, this.m, this.v);
                this.l.startActivity(intent);
                return;
            }
            h hVar3 = this.t;
            if (hVar3 != null) {
                hVar3.a("context or unitid is null");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            h hVar4 = this.t;
            if (hVar4 != null) {
                hVar4.a("show failed, exception is " + e2.getMessage());
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006f A[EDGE_INSN: B:23:0x006f->B:24:0x0070 BREAK  A[LOOP:0: B:16:0x004e->B:38:0x004e]] */
    private void e() {
        String strB;
        List<com.mbridge.msdk.foundation.entity.c> listB = com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).b(this.m, this.f2375b);
        if (listB != null) {
            int size = listB.size();
            String strC = com.mbridge.msdk.foundation.same.a.d.c(this.m);
            if (size == 0) {
                return;
            }
            String strC2 = "";
            try {
                if (size == 1) {
                    if (listB.get(0) == null) {
                        strB = "";
                        break;
                    } else {
                        strC2 = listB.get(0).c();
                        strB = listB.get(0).b();
                    }
                } else if (!TextUtils.isEmpty(strC)) {
                    Iterator<com.mbridge.msdk.foundation.entity.c> it = listB.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            strB = "";
                            break;
                        }
                        com.mbridge.msdk.foundation.entity.c next = it.next();
                        if (next != null && strC.equals(next.a())) {
                            strC2 = next.c();
                            strB = next.b();
                            break;
                        }
                    }
                } else {
                    strB = "";
                    break;
                }
                if (TextUtils.isEmpty(strC2) || !strC2.equals(this.f2375b)) {
                    return;
                }
                com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).a(strC, this.m);
                com.mbridge.msdk.foundation.same.a.d.a(this.m, this.f2375b, strB);
                com.mbridge.msdk.foundation.same.a.d.b(this.m);
            } catch (Exception e2) {
                aa.a("RewardMVVideoAdapter", e2.getMessage());
            }
        }
    }

    public final void d(boolean z) {
        this.N = z;
    }

    public final void a(int i, int i2, boolean z) {
        a(i, i2, z, "", this.G, new HashMap());
    }

    public final void a(int i, int i2, boolean z, String str, boolean z2, Map<String, String> map) {
        boolean zA;
        CampaignEx campaignEx;
        this.p = i;
        this.q = i2;
        this.r = z;
        this.I = str;
        if (map != null && map.containsKey(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID)) {
            this.c = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
        }
        this.G = z2;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.F;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0 && (campaignEx = this.F.get(0)) != null && TextUtils.isEmpty(campaignEx.getNLRid())) {
            this.F.clear();
        }
        List<CampaignEx> list = this.Q;
        if (list != null) {
            list.clear();
        }
        this.f = false;
        this.g = false;
        synchronized (this.d) {
            if (this.h) {
                this.h = false;
            }
        }
        this.j = false;
        this.i = false;
        try {
            zA = com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.a(this.l);
        } catch (Exception unused) {
            zA = false;
        }
        if (!zA) {
            a("WebView is not available", 0);
            return;
        }
        if (this.l == null) {
            a("Context is null", 0);
            return;
        }
        if (ak.a(this.m)) {
            a("UnitId is null", 0);
            return;
        }
        if (this.v == null) {
            a("RewardUnitSetting is null", 0);
            return;
        }
        k();
        l();
        g();
        b(str, z2, map);
    }

    private void a(String str, boolean z, final Map<String, String> map) {
        int iT;
        int iU;
        boolean zB;
        String str2 = "1";
        try {
            if (this.l == null) {
                a("Context is null", 0);
                return;
            }
            if (ak.a(this.m)) {
                a("UnitId is null", 0);
                return;
            }
            if (this.v == null) {
                a("RewardUnitSetting is null", 0);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                if (System.currentTimeMillis() - this.H < this.v.a() * 1000) {
                    a(6001, "EXCEPTION_RETURN_EMPTY", 1);
                    return;
                }
            }
            String strH = com.mbridge.msdk.foundation.controller.b.d().h();
            String md5 = SameMD5.getMD5(com.mbridge.msdk.foundation.controller.b.d().h() + com.mbridge.msdk.foundation.controller.b.d().j());
            int i = this.r ? 2 : 3;
            com.mbridge.msdk.videocommon.d.c cVar = this.v;
            if (cVar != null) {
                iT = cVar.t();
                iU = this.v.u();
            } else {
                iT = 0;
                iU = 0;
            }
            String str3 = this.s;
            String strA = com.mbridge.msdk.foundation.same.a.d.a(this.m, ReportUtil.EVENT_TYPE_REWARD);
            this.o = h();
            String strJ = j();
            int i2 = this.p;
            int i3 = iU;
            int i4 = this.y ? 287 : 94;
            com.mbridge.msdk.foundation.same.net.g.d dVar = new com.mbridge.msdk.foundation.same.net.g.d();
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "app_id", strH);
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, MBridgeConstans.PROPERTIES_UNIT_ID, this.m);
            if (!TextUtils.isEmpty(this.n)) {
                com.mbridge.msdk.foundation.same.net.f.b.a(dVar, MBridgeConstans.PLACEMENT_ID, this.n);
            }
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "sign", md5);
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "req_type", i + "");
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "ad_num", iT + "");
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "tnum", (this.y ? 1 : i3) + "");
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "only_impression", "1");
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "ping_mode", "1");
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, com.mbridge.msdk.foundation.same.net.g.d.f2148b, strA);
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, com.mbridge.msdk.foundation.same.net.g.d.c, str3);
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, CampaignEx.JSON_KEY_AD_SOURCE_ID, i2 + "");
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, com.mbridge.msdk.foundation.same.net.g.d.a, strJ);
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "ad_type", i4 + "");
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "offset", this.o + "");
            if (!TextUtils.isEmpty(str)) {
                dVar.a(BidResponsed.KEY_TOKEN, str);
            }
            if (this.y) {
                if (this.B == com.mbridge.msdk.foundation.same.a.p || this.B == com.mbridge.msdk.foundation.same.a.o) {
                    dVar.a("ivrwd", "1");
                } else {
                    dVar.a("ivrwd", "0");
                }
            }
            com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), this.m, this.y);
            if (cVarA != null && !TextUtils.isEmpty(cVarA.k())) {
                dVar.a("u_stid", cVarA.k());
            }
            com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            if (aVarB != null && !TextUtils.isEmpty(aVarB.b())) {
                dVar.a("r_stid", aVarB.b());
            }
            if (!z) {
                str2 = "0";
            }
            dVar.a("rw_plus", str2);
            String strH2 = af.h(this.m);
            if (!TextUtils.isEmpty(strH2)) {
                dVar.a("j", strH2);
            }
            dVar.a(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID));
            this.O = System.currentTimeMillis();
            try {
                com.mbridge.msdk.reward.c.a.a(null, this.l, "start load offer from server", this.m, this.z, "", "", System.currentTimeMillis() - this.O);
            } catch (Exception unused) {
            }
            com.mbridge.msdk.reward.d.b bVar = new com.mbridge.msdk.reward.d.b(this.l);
            com.mbridge.msdk.reward.d.a aVar = new com.mbridge.msdk.reward.d.a() { // from class: com.mbridge.msdk.reward.adapter.c.2
                @Override // com.mbridge.msdk.reward.d.a
                public final void a(CampaignUnit campaignUnit) throws Throwable {
                    CampaignEx campaignEx;
                    if (campaignUnit != null) {
                        try {
                            if (campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0) {
                                try {
                                    HashMap map2 = new HashMap();
                                    map2.put("timeout", c.this.q + "");
                                    map2.put("result", "1");
                                    map2.put("auto_load", map.get("isDev"));
                                    campaignUnit.setLocalRequestId((String) map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID));
                                    m.a().a("2000126", campaignUnit.getAds(), map2);
                                    com.mbridge.msdk.reward.c.a.a(campaignUnit.getAds().get(0), c.this.l, "load offer success tpl " + (!TextUtils.isEmpty(campaignUnit.getAds().get(0).getCMPTEntryUrl())), c.this.m, c.this.z, "", "", System.currentTimeMillis() - c.this.O);
                                } catch (Exception unused2) {
                                }
                            }
                        } catch (Exception e2) {
                            if (MBridgeConstans.DEBUG) {
                                e2.printStackTrace();
                            }
                            if (c.this.F != null && c.this.F.size() > 0 && (campaignEx = (CampaignEx) c.this.F.get(0)) != null && TextUtils.isEmpty(campaignEx.getNLRid())) {
                                c.this.F.clear();
                            }
                            if (c.this.Q != null) {
                                c.this.Q.clear();
                            }
                            c.this.f = false;
                            c.this.g = false;
                            synchronized (c.this.d) {
                                if (c.this.h) {
                                    c.this.h = false;
                                }
                                c.this.j = false;
                                c.this.i = false;
                                try {
                                    com.mbridge.msdk.reward.c.a.a(null, c.this.l, "load offer failed: " + e2.getMessage(), c.this.m, c.this.z, "", "", System.currentTimeMillis() - c.this.O);
                                } catch (Exception unused3) {
                                }
                                c.this.a(AdError.ICONVIEW_MISSING_ERROR_CODE, "exception after load success", 1);
                                c.this.i();
                                return;
                            }
                        }
                    }
                    c.a(c.this, campaignUnit);
                    c.this.a = campaignUnit.getRequestId();
                }

                @Override // com.mbridge.msdk.reward.d.a
                public final void a(int i5, String str4, int i6) {
                    CampaignEx campaignEx;
                    com.mbridge.msdk.reward.c.a.a(null, c.this.l, "load offer failed: " + str4, c.this.m, c.this.z, "", "", System.currentTimeMillis() - c.this.O);
                    if (i5 == -1) {
                        c.this.H = System.currentTimeMillis();
                    }
                    if (c.this.F != null && c.this.F.size() > 0 && (campaignEx = (CampaignEx) c.this.F.get(0)) != null && TextUtils.isEmpty(campaignEx.getNLRid())) {
                        c.this.F.clear();
                    }
                    if (c.this.Q != null) {
                        c.this.Q.clear();
                    }
                    c.this.f = false;
                    c.this.g = false;
                    synchronized (c.this.d) {
                        if (c.this.h) {
                            c.this.h = false;
                        }
                    }
                    c.this.j = false;
                    c.this.i = false;
                    if (!c.this.N) {
                        if (i6 == 1 || i6 == 2) {
                            try {
                                HashMap map2 = new HashMap();
                                map2.put("timeout", c.this.q + "");
                                map2.put("result", i5 != 0 ? "1" : "2");
                                map2.put("auto_load", map.get("isDev"));
                                String str5 = (String) map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                                if (TextUtils.isEmpty(str5)) {
                                    map2.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.unitId);
                                }
                                m.a().a("2000126", str5, map2);
                            } catch (Exception e2) {
                                if (MBridgeConstans.DEBUG) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        c.this.a(i5, str4, i6);
                    }
                    c.this.i();
                }
            };
            aVar.a(str);
            aVar.setUnitId(this.m);
            aVar.setPlacementId(this.n);
            aVar.setAdType(this.y ? 287 : 94);
            try {
                zB = l.a().b(this.y ? 287 : 94);
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("RewardMVVideoAdapter", "isRewardVideoRefactorForCampaignRequest exception " + e2.getMessage());
                }
                zB = false;
            }
            if (zB) {
                bVar.getCampaign(1, str, dVar, new com.mbridge.msdk.foundation.same.net.b(l.a().a("r_v_c_r_t_c", com.mbridge.msdk.foundation.same.a.y), l.a().a("r_v_c_r_t_r", com.mbridge.msdk.foundation.same.a.z), l.a().a("r_v_c_r_t_w", com.mbridge.msdk.foundation.same.a.z), this.q * 1000, l.a().a("r_v_c_r_r_c", com.mbridge.msdk.foundation.same.a.B), 4), aVar);
            } else {
                int iA = com.mbridge.msdk.foundation.same.a.z;
                int iB = com.mbridge.msdk.foundation.same.a.A;
                int iC = com.mbridge.msdk.foundation.same.a.x;
                int iD = com.mbridge.msdk.foundation.same.a.B;
                try {
                    com.mbridge.msdk.c.c cVarG = com.mbridge.msdk.c.d.a().g(com.mbridge.msdk.foundation.controller.b.d().h());
                    if (cVarG != null) {
                        iA = cVarG.A();
                        iB = cVarG.B();
                        iC = cVarG.C();
                        iD = cVarG.D();
                    }
                } catch (Exception unused2) {
                }
                bVar.choiceV3OrV5BySetting(1, dVar, aVar, str, new com.mbridge.msdk.foundation.same.net.b(iC, iA, iB, this.q * 1000, iD, 4));
            }
            if (map != null) {
                try {
                    if (com.mbridge.msdk.foundation.same.net.f.c.a().a(dVar) == null) {
                        HashMap map2 = new HashMap();
                        map2.put("auto_load", map.get("isDev"));
                        String str4 = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                        if (TextUtils.isEmpty(str4)) {
                            map2.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.m);
                        }
                        m.a().a("2000125", str4, map2);
                    }
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        e3.printStackTrace();
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            a("Load exception", 0);
            i();
        }
    }

    private void f() {
        Handler handler = this.M;
        if (handler != null) {
            handler.sendEmptyMessage(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2) {
        if (this.M != null) {
            if (TextUtils.isEmpty(str)) {
                this.M.sendEmptyMessage(4);
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 4;
            messageObtain.obj = str;
            messageObtain.arg1 = i;
            messageObtain.arg2 = i2;
            if (str.contains("exception")) {
                this.M.sendMessageAtFrontOfQueue(messageObtain);
            } else {
                this.M.sendMessage(messageObtain);
            }
        }
    }

    private void a(String str, int i) {
        if (this.M != null) {
            if (TextUtils.isEmpty(str)) {
                this.M.sendEmptyMessage(4);
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 4;
            messageObtain.obj = str;
            messageObtain.arg2 = i;
            if (str.contains("exception")) {
                this.M.sendMessageAtFrontOfQueue(messageObtain);
            } else {
                this.M.sendMessage(messageObtain);
            }
        }
    }

    private void a(String str, String str2, List<CampaignEx> list) {
        if (com.mbridge.msdk.videocommon.a.a.a() != null) {
            com.mbridge.msdk.videocommon.a.a.a().a(str, str2, list);
        }
    }

    private void g() {
        if (com.mbridge.msdk.videocommon.a.a.a() != null) {
            try {
                com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
                if (cVarB == null) {
                    cVarB = com.mbridge.msdk.c.d.a().b();
                }
                com.mbridge.msdk.videocommon.a.a.a().a(cVarB.Q() * 1000, this.m);
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void a(com.mbridge.msdk.reward.adapter.a aVar) {
        this.u = aVar;
    }

    public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, boolean z) {
        try {
            com.mbridge.msdk.reward.c.a.a(this.E.getAds().get(0), this.l, "start download resource tpl " + (!TextUtils.isEmpty(this.E.getAds().get(0).getCMPTEntryUrl())), this.m, this.z, "", "", System.currentTimeMillis() - this.O);
        } catch (Exception unused) {
        }
        a(this.E, copyOnWriteArrayList);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            aa.b("RewardMVVideoAdapter", "onload load success size:" + copyOnWriteArrayList.size());
            if (z) {
                f();
            }
            CampaignUnit campaignUnit = this.E;
            if (campaignUnit != null) {
                b(campaignUnit.getSessionId());
            }
            b(copyOnWriteArrayList);
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                a(this.n, this.m, copyOnWriteArrayList);
            }
            CampaignEx campaignEx = copyOnWriteArrayList.get(0);
            this.F = copyOnWriteArrayList;
            a(campaignEx);
            return;
        }
        aa.b("RewardMVVideoAdapter", "onload load fail, callback campaign have not video");
        if (TextUtils.isEmpty(this.P)) {
            this.P = "APP ALREADY INSTALLED";
        }
        a(this.E, this.P);
        a(AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE, this.P, 3);
    }

    private void a(final CampaignEx campaignEx) {
        final boolean z = !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl());
        final int nscpt = campaignEx.getNscpt();
        this.f = false;
        this.g = false;
        synchronized (this.d) {
            if (this.h) {
                this.h = false;
            }
        }
        this.j = false;
        this.i = false;
        if (this.z && campaignEx != null) {
            com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).a(campaignEx.getBidToken(), campaignEx.getCampaignUnitId(), campaignEx.getEncryptPrice());
        }
        com.mbridge.msdk.reward.adapter.b.m.a.a(this.l, z, nscpt, this.z, this.y ? 287 : 94, this.n, this.m, campaignEx.getRequestId(), this.F, new AnonymousClass3(z, campaignEx, nscpt), new com.mbridge.msdk.reward.adapter.b.i() { // from class: com.mbridge.msdk.reward.adapter.c.4
            @Override // com.mbridge.msdk.reward.adapter.b.i
            public final void a(String str, String str2, String str3, String str4) {
            }

            @Override // com.mbridge.msdk.reward.adapter.b.i
            public final void a(String str, final String str2, final String str3, String str4, final com.mbridge.msdk.foundation.entity.e eVar) {
                if (!z && c.this.u != null && c.this.M != null) {
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
                        aa.b("RewardMVVideoAdapter", "template download fail but hit ignoreCheckRule");
                        return;
                    } else {
                        if (c.this.a(campaignEx, false, eVar, 2)) {
                            return;
                        }
                        c.this.M.post(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.c.4.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                c.a(c.this, str2, c.this.Q, c.this.z);
                                if (c.this.M != null) {
                                    c.this.M.removeMessages(5);
                                }
                                if (c.this.j || c.this.u == null) {
                                    return;
                                }
                                c.this.j = true;
                                if (c.this.Q != null && c.this.Q.size() > 0) {
                                    eVar.b("errorCode: 3202 errorMessage: temp resource download failed");
                                    com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.Q.get(0), c.this.l, eVar, c.this.m, c.this.z, str3, campaignEx.getRequestIdNotice());
                                }
                                c.this.u.a(c.this.Q, eVar.d());
                            }
                        });
                        return;
                    }
                }
                if (nscpt == 1) {
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0) {
                        if (campaignEx.getRsIgnoreCheckRule().contains(3)) {
                            aa.b("RewardMVVideoAdapter", "tpl download fail but hit ignoreCheckRule");
                            return;
                        } else if (campaignEx.getCMPTEntryUrl().equals(campaignEx.getendcard_url()) && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                            aa.b("RewardMVVideoAdapter", "endcard download fail but hit ignoreCheckRule at 3203");
                            return;
                        }
                    }
                    if (c.this.a(campaignEx, false, eVar, 2) || c.this.u == null || c.this.M == null) {
                        return;
                    }
                    c.this.M.post(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.c.4.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.a(c.this, str2, c.this.Q, c.this.z);
                            if (c.this.M != null) {
                                c.this.M.removeMessages(5);
                            }
                            if (c.this.j || c.this.u == null) {
                                return;
                            }
                            c.this.j = true;
                            if (c.this.Q != null && c.this.Q.size() > 0) {
                                eVar.b("errorCode: 3203 errorMessage: tpl temp resource download failed");
                                com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.Q.get(0), c.this.l, eVar, c.this.m, c.this.z, str3, campaignEx.getRequestIdNotice());
                            }
                            c.this.u.a(c.this.Q, eVar.d());
                        }
                    });
                }
            }
        });
        if (z) {
            com.mbridge.msdk.reward.adapter.b.m.a.a(this.l, campaignEx, this.n, this.m, campaignEx.getRequestId(), new AnonymousClass5(campaignEx, z, nscpt));
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.reward.adapter.c$3, reason: invalid class name */
    /* JADX INFO: compiled from: RewardMVVideoAdapter.java */
    final class AnonymousClass3 implements com.mbridge.msdk.reward.adapter.b.c {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f2377b;
        final /* synthetic */ int c;

        AnonymousClass3(boolean z, CampaignEx campaignEx, int i) {
            this.a = z;
            this.f2377b = campaignEx;
            this.c = i;
        }

        @Override // com.mbridge.msdk.reward.adapter.b.c
        public final void a(final String str, final String str2, final String str3, final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            c.this.f = true;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                try {
                    com.mbridge.msdk.reward.c.a.a(copyOnWriteArrayList.get(0), c.this.l, "resource download success is tpl :" + this.a, c.this.m, c.this.z, str3, this.f2377b.getRequestIdNotice(), System.currentTimeMillis() - c.this.O);
                } catch (Exception unused) {
                }
            }
            if (!this.a) {
                for (final CampaignEx campaignEx : copyOnWriteArrayList) {
                    if (campaignEx != null && campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e()) && !campaignEx.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY) && c.this.M != null) {
                        c.this.M.post(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.c.3.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                com.mbridge.msdk.reward.adapter.b.m.a.a(c.this.G, c.this.M, c.this.y, c.this.z, null, campaignEx.getRewardTemplateMode().e(), c.this.x, AnonymousClass3.this.f2377b, c.this.F, com.mbridge.msdk.videocommon.download.g.a().b(campaignEx.getRewardTemplateMode().e()), str, str2, str3, campaignEx.getRequestIdNotice(), c.this.v, new com.mbridge.msdk.reward.adapter.b.j() { // from class: com.mbridge.msdk.reward.adapter.c.3.1.1
                                    @Override // com.mbridge.msdk.reward.adapter.b.j
                                    public final void a(String str4, String str5, String str6, String str7, String str8, com.mbridge.msdk.videocommon.a.C0524a c0524a) {
                                        try {
                                            com.mbridge.msdk.reward.c.a.a((CampaignEx) copyOnWriteArrayList.get(0), c.this.l, "preload template success is tpl :" + AnonymousClass3.this.a, c.this.m, c.this.z, str3, AnonymousClass3.this.f2377b.getRequestIdNotice(), System.currentTimeMillis() - c.this.O);
                                        } catch (Exception unused2) {
                                        }
                                        if (c.this.a(c.this.F, AnonymousClass3.this.a, AnonymousClass3.this.c)) {
                                            c.a(c.this, c.this.m, copyOnWriteArrayList, c.this.R, c.this.z);
                                            if (c.this.M != null) {
                                                c.this.M.removeMessages(5);
                                            }
                                            if (c.this.u == null || c.this.i) {
                                                return;
                                            }
                                            c.this.i = true;
                                            c.this.u.a(c.this.F);
                                            return;
                                        }
                                        c.a(c.this, str6, c.this.Q, c.this.z);
                                        if (c.this.M != null) {
                                            c.this.M.removeMessages(5);
                                        }
                                        if (c.this.u == null || c.this.j) {
                                            return;
                                        }
                                        c.this.j = true;
                                        com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(15, "errorCode: 3502 errorMessage: temp preload success but isReady false");
                                        if (!TextUtils.isEmpty(c.this.m) && c.this.F != null && c.this.F.size() > 0) {
                                            try {
                                                com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.F.get(0), c.this.l, eVar, c.this.m, c.this.z, str7, AnonymousClass3.this.f2377b.getRequestIdNotice());
                                            } catch (Exception unused3) {
                                            }
                                        }
                                        c.this.u.a(c.this.F, eVar.d());
                                    }

                                    @Override // com.mbridge.msdk.reward.adapter.b.j
                                    public final void a(String str4, String str5, String str6, String str7, String str8, com.mbridge.msdk.videocommon.a.C0524a c0524a, com.mbridge.msdk.foundation.entity.e eVar) {
                                        try {
                                            com.mbridge.msdk.reward.c.a.a((CampaignEx) copyOnWriteArrayList.get(0), c.this.l, "preload template failed is tpl :" + AnonymousClass3.this.a + " ", c.this.m, c.this.z, str3, AnonymousClass3.this.f2377b.getRequestIdNotice(), System.currentTimeMillis() - c.this.O);
                                        } catch (Exception unused2) {
                                        }
                                        if (AnonymousClass3.this.f2377b.getRsIgnoreCheckRule() == null || AnonymousClass3.this.f2377b.getRsIgnoreCheckRule().size() <= 0 || !AnonymousClass3.this.f2377b.getRsIgnoreCheckRule().contains(1)) {
                                            c.a(c.this, str6, c.this.Q, c.this.z);
                                            if (c.this.M != null) {
                                                c.this.M.removeMessages(5);
                                            }
                                            if (c.this.u == null || c.this.j) {
                                                return;
                                            }
                                            c.this.j = true;
                                            if (!TextUtils.isEmpty(c.this.m) && c.this.Q != null && c.this.Q.size() > 0) {
                                                try {
                                                    try {
                                                        eVar.b("errorCode: 3301 errorMessage: temp preload failed: " + eVar.d());
                                                        com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.Q.get(0), c.this.l, eVar, c.this.m, c.this.z, str7, AnonymousClass3.this.f2377b.getRequestIdNotice());
                                                    } catch (Exception unused3) {
                                                    }
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            c.this.u.a(c.this.Q, eVar.d());
                                            return;
                                        }
                                        aa.b("RewardMVVideoAdapter", "template download fail but hit ignoreCheckRule");
                                    }
                                });
                            }
                        });
                    } else {
                        c cVar = c.this;
                        if (cVar.a(cVar.F, this.a, this.c)) {
                            c cVar2 = c.this;
                            c.a(cVar2, cVar2.m, copyOnWriteArrayList, c.this.R, c.this.z);
                            if (c.this.M != null) {
                                c.this.M.removeMessages(5);
                            }
                            if (c.this.u != null && !c.this.i) {
                                c.this.i = true;
                                c.this.u.a(c.this.F);
                            }
                        } else {
                            c cVar3 = c.this;
                            c.a(cVar3, str2, cVar3.Q, c.this.z);
                            if (c.this.M != null) {
                                c.this.M.removeMessages(5);
                            }
                            if (c.this.u != null && !c.this.j) {
                                c.this.j = true;
                                com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(15, "errorCode: 3503 errorMessage: have no temp but isReady false");
                                if (!TextUtils.isEmpty(c.this.m) && c.this.F != null && c.this.F.size() > 0) {
                                    try {
                                        com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.F.get(0), c.this.l, eVar, c.this.m, c.this.z, str3, this.f2377b.getRequestIdNotice());
                                    } catch (Exception unused2) {
                                    }
                                }
                                c.this.u.a(c.this.F, eVar.d());
                            }
                        }
                    }
                }
                return;
            }
            if (!c.this.g || c.this.h || c.this.M == null) {
                return;
            }
            synchronized (c.this.d) {
                if (c.this.h) {
                    return;
                }
                c.this.h = true;
                c.this.M.post(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.c.3.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.mbridge.msdk.reward.adapter.b.m.a.a(c.this.G, c.this.M, c.this.y, c.this.z, str3, AnonymousClass3.this.f2377b.getRequestIdNotice(), c.this.n, str2, AnonymousClass3.this.f2377b.getCMPTEntryUrl(), c.this.x, AnonymousClass3.this.f2377b, c.this.F, com.mbridge.msdk.videocommon.download.g.a().b(AnonymousClass3.this.f2377b.getCMPTEntryUrl()), str2, c.this.v, new com.mbridge.msdk.reward.adapter.b.j() { // from class: com.mbridge.msdk.reward.adapter.c.3.2.1
                            @Override // com.mbridge.msdk.reward.adapter.b.j
                            public final void a(String str4, String str5, String str6, String str7, String str8, com.mbridge.msdk.videocommon.a.C0524a c0524a) {
                                try {
                                    com.mbridge.msdk.reward.c.a.a((CampaignEx) copyOnWriteArrayList.get(0), c.this.l, "preload template success is tpl :" + AnonymousClass3.this.a, c.this.m, c.this.z, str3, AnonymousClass3.this.f2377b.getRequestIdNotice(), System.currentTimeMillis() - c.this.O);
                                } catch (Exception unused3) {
                                }
                                if (c.this.a(c.this.F, AnonymousClass3.this.a, AnonymousClass3.this.c)) {
                                    c.a(c.this, c.this.m, copyOnWriteArrayList, c.this.R, c.this.z);
                                    if (c.this.M != null) {
                                        c.this.M.removeMessages(5);
                                    }
                                    if (c.this.u == null || c.this.i) {
                                        return;
                                    }
                                    c.this.i = true;
                                    c.this.u.a(c.this.F);
                                    return;
                                }
                                c.a(c.this, str6, c.this.Q, c.this.z);
                                if (c.this.M != null) {
                                    c.this.M.removeMessages(5);
                                }
                                if (c.this.u == null || c.this.j) {
                                    return;
                                }
                                c.this.j = true;
                                com.mbridge.msdk.foundation.entity.e eVar2 = new com.mbridge.msdk.foundation.entity.e(15, "errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                                if (!TextUtils.isEmpty(c.this.m) && c.this.Q != null && c.this.Q.size() > 0) {
                                    try {
                                        com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.Q.get(0), c.this.l, eVar2, c.this.m, c.this.z, str7, AnonymousClass3.this.f2377b.getRequestIdNotice());
                                    } catch (Exception unused4) {
                                    }
                                }
                                c.this.u.a(c.this.Q, eVar2.d());
                            }

                            @Override // com.mbridge.msdk.reward.adapter.b.j
                            public final void a(String str4, String str5, String str6, String str7, String str8, com.mbridge.msdk.videocommon.a.C0524a c0524a, com.mbridge.msdk.foundation.entity.e eVar2) {
                                try {
                                    com.mbridge.msdk.reward.c.a.a((CampaignEx) copyOnWriteArrayList.get(0), c.this.l, "preload template failed is tpl :" + AnonymousClass3.this.a + " " + eVar2.d(), c.this.m, c.this.z, str3, AnonymousClass3.this.f2377b.getRequestIdNotice(), System.currentTimeMillis() - c.this.O);
                                } catch (Exception unused3) {
                                }
                                if (AnonymousClass3.this.f2377b.getRsIgnoreCheckRule() == null || AnonymousClass3.this.f2377b.getRsIgnoreCheckRule().size() <= 0 || !AnonymousClass3.this.f2377b.getRsIgnoreCheckRule().contains(3)) {
                                    c.a(c.this, str6, c.this.Q, c.this.z);
                                    if (c.this.M != null) {
                                        c.this.M.removeMessages(5);
                                    }
                                    if (c.this.u == null || c.this.j) {
                                        return;
                                    }
                                    c.this.j = true;
                                    if (c.this.Q != null && c.this.Q.size() > 0) {
                                        try {
                                            try {
                                                eVar2.b("errorCode: 3303 errorMessage: tpl temp preload failed: " + eVar2.d());
                                                com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.Q.get(0), c.this.l, eVar2, c.this.m, c.this.z, str7, AnonymousClass3.this.f2377b.getRequestIdNotice());
                                            } catch (Exception unused4) {
                                            }
                                        } catch (Exception unused5) {
                                        }
                                    }
                                    c.this.u.a(c.this.Q, eVar2.d());
                                    return;
                                }
                                aa.b("RewardMVVideoAdapter", "template download fail but hit ignoreCheckRule");
                            }
                        }, false);
                    }
                });
            }
        }

        @Override // com.mbridge.msdk.reward.adapter.b.c
        public final void a(String str, final String str2, final String str3, final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, final com.mbridge.msdk.foundation.entity.e eVar) {
            if (c.this.a(this.f2377b, false, eVar, 2)) {
                return;
            }
            c.this.f = false;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                try {
                    com.mbridge.msdk.reward.c.a.a(copyOnWriteArrayList.get(0), c.this.l, "resource download failed:  is tpl: " + this.a, c.this.m, c.this.z, str3, this.f2377b.getRequestIdNotice(), System.currentTimeMillis() - c.this.O);
                } catch (Exception unused) {
                }
            }
            if (c.this.u == null || c.this.M == null) {
                return;
            }
            c.this.M.post(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.c.3.3
                @Override // java.lang.Runnable
                public final void run() {
                    CopyOnWriteArrayList copyOnWriteArrayList2;
                    c.a(c.this, str2, c.this.Q, c.this.z);
                    if (c.this.M != null) {
                        c.this.M.removeMessages(5);
                    }
                    if (c.this.j || c.this.u == null) {
                        return;
                    }
                    c.this.j = true;
                    if (!TextUtils.isEmpty(c.this.m) && (copyOnWriteArrayList2 = copyOnWriteArrayList) != null && copyOnWriteArrayList2.size() > 0) {
                        try {
                            eVar.b("errorCode: 3201 errorMessage: campaign resource download failed");
                            com.mbridge.msdk.reward.c.a.a((CampaignEx) copyOnWriteArrayList.get(0), c.this.l, eVar, c.this.m, c.this.z, str3, AnonymousClass3.this.f2377b.getRequestIdNotice());
                        } catch (Exception unused2) {
                        }
                    }
                    c.this.u.a(copyOnWriteArrayList, eVar.d());
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.reward.adapter.c$5, reason: invalid class name */
    /* JADX INFO: compiled from: RewardMVVideoAdapter.java */
    final class AnonymousClass5 implements com.mbridge.msdk.reward.adapter.b.i {
        final /* synthetic */ CampaignEx a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f2384b;
        final /* synthetic */ int c;

        AnonymousClass5(CampaignEx campaignEx, boolean z, int i) {
            this.a = campaignEx;
            this.f2384b = z;
            this.c = i;
        }

        @Override // com.mbridge.msdk.reward.adapter.b.i
        public final void a(final String str, final String str2, final String str3, String str4) {
            try {
                com.mbridge.msdk.reward.c.a.a(this.a, c.this.l, "resource download success is tpl :" + this.f2384b, c.this.m, c.this.z, str3, this.a.getRequestIdNotice(), System.currentTimeMillis() - c.this.O);
            } catch (Exception unused) {
            }
            c.this.g = true;
            if (!c.this.f || c.this.h || c.this.M == null) {
                return;
            }
            synchronized (c.this.d) {
                if (c.this.h) {
                    return;
                }
                c.this.h = true;
                c.this.M.post(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.c.5.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.mbridge.msdk.reward.adapter.b.m.a.a(c.this.G, c.this.M, c.this.y, c.this.z, str3, AnonymousClass5.this.a.getRequestIdNotice(), str, str2, AnonymousClass5.this.a.getCMPTEntryUrl(), c.this.x, AnonymousClass5.this.a, c.this.F, com.mbridge.msdk.videocommon.download.g.a().b(AnonymousClass5.this.a.getCMPTEntryUrl()), str2, c.this.v, new com.mbridge.msdk.reward.adapter.b.j() { // from class: com.mbridge.msdk.reward.adapter.c.5.1.1
                            @Override // com.mbridge.msdk.reward.adapter.b.j
                            public final void a(String str5, String str6, String str7, String str8, String str9, com.mbridge.msdk.videocommon.a.C0524a c0524a) {
                                try {
                                    com.mbridge.msdk.reward.c.a.a(AnonymousClass5.this.a, c.this.l, "preload template success is tpl :" + AnonymousClass5.this.f2384b, c.this.m, c.this.z, str3, AnonymousClass5.this.a.getRequestIdNotice(), System.currentTimeMillis() - c.this.O);
                                } catch (Exception unused2) {
                                }
                                if (c.this.a(c.this.F, AnonymousClass5.this.f2384b, AnonymousClass5.this.c)) {
                                    c.a(c.this, c.this.m, c.this.Q, c.this.R, c.this.z);
                                    if (c.this.M != null) {
                                        c.this.M.removeMessages(5);
                                    }
                                    if (c.this.u == null || c.this.i) {
                                        return;
                                    }
                                    c.this.i = true;
                                    c.this.u.a(c.this.F);
                                    return;
                                }
                                c.a(c.this, str7, c.this.Q, c.this.z);
                                if (c.this.M != null) {
                                    c.this.M.removeMessages(5);
                                }
                                if (c.this.u == null || c.this.j) {
                                    return;
                                }
                                c.this.j = true;
                                com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(8, "errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                                if (c.this.Q != null && c.this.Q.size() > 0) {
                                    try {
                                        com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.Q.get(0), c.this.l, eVar, c.this.m, c.this.z, str8, AnonymousClass5.this.a.getRequestIdNotice());
                                    } catch (Exception unused3) {
                                    }
                                }
                                c.this.u.a(c.this.Q, eVar.d());
                            }

                            @Override // com.mbridge.msdk.reward.adapter.b.j
                            public final void a(String str5, String str6, String str7, String str8, String str9, com.mbridge.msdk.videocommon.a.C0524a c0524a, com.mbridge.msdk.foundation.entity.e eVar) {
                                c.a(c.this, str7, c.this.Q, c.this.z);
                                if (c.this.a(AnonymousClass5.this.a, false, eVar, 2)) {
                                    return;
                                }
                                try {
                                    com.mbridge.msdk.reward.c.a.a(AnonymousClass5.this.a, c.this.l, "preload template failed is tpl :" + AnonymousClass5.this.f2384b + " " + eVar.d(), c.this.m, c.this.z, str3, AnonymousClass5.this.a.getRequestIdNotice(), System.currentTimeMillis() - c.this.O);
                                } catch (Exception unused2) {
                                }
                                if (c.this.M != null) {
                                    c.this.M.removeMessages(5);
                                }
                                if (c.this.u == null || c.this.j) {
                                    return;
                                }
                                c.this.j = true;
                                if (c.this.Q != null && c.this.Q.size() > 0) {
                                    eVar.b("errorCode: 3303 errorMessage: tpl temp preload failed: " + eVar.d());
                                    com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.Q.get(0), c.this.l, eVar, c.this.m, c.this.z, str8, AnonymousClass5.this.a.getRequestIdNotice());
                                }
                                c.this.u.a(c.this.Q, eVar.d());
                            }
                        }, false);
                    }
                });
            }
        }

        @Override // com.mbridge.msdk.reward.adapter.b.i
        public final void a(String str, String str2, String str3, String str4, com.mbridge.msdk.foundation.entity.e eVar) {
            if (this.a.getRsIgnoreCheckRule() != null && this.a.getRsIgnoreCheckRule().size() > 0) {
                if (this.a.getRsIgnoreCheckRule().contains(3)) {
                    aa.b("RewardMVVideoAdapter", "tpl download fail but hit ignoreCheckRule");
                    return;
                } else if (this.a.getCMPTEntryUrl().equals(this.a.getendcard_url()) && this.a.getRsIgnoreCheckRule().contains(2)) {
                    aa.b("RewardMVVideoAdapter", "endcard download fail but hit ignoreCheckRule at 3203");
                    return;
                }
            }
            c cVar = c.this;
            c.a(cVar, str2, cVar.Q, c.this.z);
            if (c.this.a(this.a, false, eVar, 2)) {
                return;
            }
            c.this.g = false;
            if (c.this.Q.get(0) != null && c.this.Q.size() > 0) {
                try {
                    com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.Q.get(0), c.this.l, "resource download failed: " + eVar.d() + " is tpl: " + this.f2384b, c.this.m, c.this.z, str3, ((CampaignEx) c.this.Q.get(0)).getRequestIdNotice(), System.currentTimeMillis() - c.this.O);
                } catch (Exception unused) {
                }
            }
            if (c.this.M != null) {
                c.this.M.removeMessages(5);
            }
            if (c.this.u == null || c.this.j) {
                return;
            }
            c.this.j = true;
            if (c.this.Q != null && c.this.Q.size() > 0) {
                eVar.b("errorCode: 3203 errorMessage: tpl temp resource download failed");
                com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.Q.get(0), c.this.l, eVar, c.this.m, c.this.z, str3, this.a.getRequestIdNotice());
            }
            c.this.u.a(c.this.Q, eVar.d());
        }
    }

    private void a(CampaignUnit campaignUnit, String str) {
        ArrayList<CampaignEx> ads;
        int iL;
        if (campaignUnit == null || (ads = campaignUnit.getAds()) == null || ads.size() == 0) {
            return;
        }
        try {
            HashMap map = new HashMap();
            if (!TextUtils.isEmpty(str)) {
                map.put("reason", str);
            }
            CampaignEx campaignEx = ads.get(0);
            if (campaignEx != null && campaignEx.getRewardTemplateMode() != null) {
                if (!TextUtils.isEmpty(campaignEx.getMof_template_url())) {
                    iL = af.l(campaignEx.getMof_template_url());
                } else {
                    iL = af.l(campaignEx.getRewardTemplateMode().e());
                }
                if (iL != 0) {
                    map.put(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW, iL + "");
                }
            }
            if (ads.size() > 1) {
                m.a().b("m_campaign_filtered", this.c, map);
            } else {
                m.a().a("m_campaign_filtered", this.c, map);
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    public final void e(boolean z) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList;
        if (z || (copyOnWriteArrayList = this.F) == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        com.mbridge.msdk.videocommon.a.a.a().a(this.m, this.F);
    }

    public final void f(boolean z) {
        if (z) {
            List<CampaignEx> list = this.R;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (CampaignEx campaignEx : this.R) {
                if (campaignEx != null) {
                    campaignEx.setLoadTimeoutState(0);
                    if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        i.a().d(this.m + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e(), false);
                    }
                }
            }
            com.mbridge.msdk.videocommon.a.a.a().a(this.m, this.R, "load_timeout", 0);
            return;
        }
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.F;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        for (CampaignEx campaignEx2 : this.F) {
            if (campaignEx2 != null) {
                campaignEx2.setLoadTimeoutState(0);
                if (campaignEx2.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx2.getRewardTemplateMode().e())) {
                    i.a().d(this.m + "_" + campaignEx2.getRequestId() + "_" + campaignEx2.getRewardTemplateMode().e(), false);
                }
            }
        }
        com.mbridge.msdk.videocommon.a.a.a().a(this.m, this.F, "load_timeout", 0);
    }

    public final boolean g(boolean z) {
        if (z) {
            List<CampaignEx> list = this.R;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (CampaignEx campaignEx : this.R) {
                if (campaignEx != null) {
                    campaignEx.setLoadTimeoutState(1);
                    if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        i.a().d(this.m + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e(), true);
                    }
                }
            }
            com.mbridge.msdk.videocommon.a.a.a().a(this.m, this.R, "load_timeout", 1);
            return true;
        }
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.F;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return false;
        }
        for (CampaignEx campaignEx2 : this.F) {
            if (campaignEx2 != null) {
                campaignEx2.setLoadTimeoutState(1);
                if (campaignEx2.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx2.getRewardTemplateMode().e())) {
                    i.a().d(this.m + "_" + campaignEx2.getRequestId() + "_" + campaignEx2.getRewardTemplateMode().e(), true);
                }
            }
        }
        com.mbridge.msdk.videocommon.a.a.a().a(this.m, this.F, "load_timeout", 1);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0027  */
    private void a(String str, List<CampaignEx> list, List<CampaignEx> list2) {
        CampaignEx campaignEx;
        int vcn;
        String bidToken;
        String str2;
        String str3 = "";
        if (list != null) {
            try {
                if (list.size() <= 0 || (campaignEx = list.get(0)) == null) {
                    vcn = 1;
                    str2 = "";
                    bidToken = str2;
                } else {
                    String requestId = campaignEx.getRequestId();
                    vcn = campaignEx.getVcn();
                    bidToken = campaignEx.getBidToken();
                    String localRequestId = campaignEx.getLocalRequestId();
                    str2 = requestId;
                    str3 = localRequestId;
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                    return;
                }
                return;
            }
        } else {
            vcn = 1;
            str2 = "";
            bidToken = str2;
        }
        if (com.mbridge.msdk.videocommon.a.a.a() != null) {
            com.mbridge.msdk.videocommon.a.a.a().b(str, str3);
            com.mbridge.msdk.videocommon.a.a.a().b(str);
        }
        if (com.mbridge.msdk.videocommon.a.a.a() != null) {
            com.mbridge.msdk.videocommon.a.a.a().b(str, vcn);
        }
        if (list != null && list.size() > 0) {
            com.mbridge.msdk.reward.b.a.a(str2, bidToken);
            for (CampaignEx campaignEx2 : list) {
                if (campaignEx2 != null) {
                    com.mbridge.msdk.foundation.same.a.d.a(campaignEx2.getCampaignUnitId(), campaignEx2.getRequestId(), campaignEx2.getId(), campaignEx2.getPlct(), campaignEx2.getPlctb(), campaignEx2.getTimestamp());
                }
            }
        }
        if (list2 != null && list2.size() > 0) {
            for (CampaignEx campaignEx3 : list2) {
                if (campaignEx3 != null) {
                    com.mbridge.msdk.foundation.same.a.d.b(campaignEx3.getCampaignUnitId(), campaignEx3.getRequestId());
                }
            }
        }
        com.mbridge.msdk.foundation.same.a.d.b(str);
        com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).a();
    }

    private void b(CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.videocommon.a.a aVarA = com.mbridge.msdk.videocommon.a.a.a();
            if (aVarA != null) {
                aVarA.a(campaignEx);
            }
        } catch (Throwable th) {
            aa.b("RewardMVVideoAdapter", th.getMessage(), th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:119:0x01c9 A[EXC_TOP_SPLITTER, PHI: r1
      0x01c9: PHI (r1v4 java.io.FileOutputStream) = (r1v5 java.io.FileOutputStream), (r1v6 java.io.FileOutputStream) binds: [B:107:0x01d3, B:100:0x01c7] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x015d A[PHI: r1
      0x015d: PHI (r1v8 java.io.FileOutputStream) = (r1v7 java.io.FileOutputStream), (r1v12 java.io.FileOutputStream) binds: [B:27:0x006b, B:68:0x014d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:86:0x018f  */
    private CopyOnWriteArrayList<CampaignEx> a(CampaignUnit campaignUnit) throws Throwable {
        boolean z;
        String str;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                com.mbridge.msdk.videocommon.d.c cVar = this.v;
                if (cVar != null) {
                    cVar.u();
                }
                if (campaignUnit != null && campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0) {
                    ArrayList<CampaignEx> ads = campaignUnit.getAds();
                    this.Q = ads;
                    if (campaignUnit != null && campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0) {
                        ArrayList<CampaignEx> ads2 = campaignUnit.getAds();
                        for (int i = 0; i < ads2.size(); i++) {
                            CampaignEx campaignEx = ads2.get(i);
                            campaignEx.setCampaignUnitId(this.m);
                            ads2.set(i, campaignEx);
                        }
                    }
                    for (int i2 = 0; i2 < ads.size() && i2 < Integer.MAX_VALUE; i2++) {
                        CampaignEx campaignEx2 = ads.get(i2);
                        if (campaignEx2.isMraid()) {
                            if (TextUtils.isEmpty(campaignEx2.getMraid().trim())) {
                                continue;
                            } else {
                                if (campaignEx2.getAdType() == 287) {
                                    str = "3";
                                } else if (campaignEx2.getAdType() == 94) {
                                    str = "1";
                                } else {
                                    str = campaignEx2.getAdType() == 42 ? "2" : "";
                                }
                                try {
                                    try {
                                        String strB = com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML);
                                        String md5 = SameMD5.getMD5(campaignEx2.getMraid());
                                        if (TextUtils.isEmpty(md5)) {
                                            md5 = String.valueOf(System.currentTimeMillis());
                                        }
                                        File file = new File(strB, md5.concat(".html"));
                                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                        try {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("<script>").append(com.mbridge.msdk.c.b.a.a().b()).append("</script>");
                                            sb.append(campaignEx2.getMraid());
                                            fileOutputStream2.write(sb.toString().getBytes());
                                            fileOutputStream2.flush();
                                            campaignEx2.setMraid(file.getAbsolutePath());
                                            com.mbridge.msdk.foundation.same.report.n.a(campaignEx2, "", this.m, str);
                                            try {
                                                fileOutputStream2.close();
                                                fileOutputStream = fileOutputStream2;
                                            } catch (Exception e2) {
                                                e = e2;
                                                fileOutputStream = fileOutputStream2;
                                                e.printStackTrace();
                                                if (fileOutputStream != null) {
                                                    try {
                                                        fileOutputStream.close();
                                                    } catch (IOException unused) {
                                                    }
                                                }
                                                return copyOnWriteArrayList;
                                            } catch (Throwable th) {
                                                th = th;
                                                fileOutputStream = fileOutputStream2;
                                                if (fileOutputStream != null) {
                                                    try {
                                                        fileOutputStream.close();
                                                    } catch (IOException unused2) {
                                                    }
                                                }
                                                throw th;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            fileOutputStream = fileOutputStream2;
                                            e.printStackTrace();
                                            campaignEx2.setMraid("");
                                            com.mbridge.msdk.foundation.same.report.n.a(campaignEx2, e.getMessage(), this.m, str);
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            fileOutputStream = fileOutputStream2;
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                }
                                File file2 = new File(campaignEx2.getMraid());
                                if (!file2.exists() || !file2.isFile() || !file2.canRead()) {
                                    a("mraid resource write fail", 3);
                                } else if (campaignEx2 == null) {
                                }
                            }
                        } else if (campaignEx2 == null && campaignEx2.getOfferType() != 99) {
                            if (c(campaignEx2)) {
                                if (ak.a(campaignEx2.getendcard_url()) && TextUtils.isEmpty(campaignEx2.getMraid())) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                            } else if (ak.a(campaignEx2.getVideoUrlEncode())) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z) {
                                if (campaignEx2.getWtick() == 1 || !af.c(this.l, campaignEx2.getPackageName())) {
                                    copyOnWriteArrayList.add(campaignEx2);
                                } else if (af.b(campaignEx2)) {
                                    copyOnWriteArrayList.add(campaignEx2);
                                } else {
                                    af.a(this.m, campaignEx2, com.mbridge.msdk.foundation.same.a.w);
                                    this.P = "APP ALREADY INSTALLED";
                                }
                            } else {
                                this.P = "No video campaign";
                            }
                        }
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception e5) {
            e = e5;
        }
        return copyOnWriteArrayList;
    }

    private void a(final CampaignUnit campaignUnit, List<CampaignEx> list) {
        com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.c.6
            @Override // java.lang.Runnable
            public final void run() {
                k.a(com.mbridge.msdk.foundation.db.h.a(c.this.l)).b();
                CampaignUnit campaignUnit2 = campaignUnit;
                if (campaignUnit2 == null || campaignUnit2.getAds() == null || campaignUnit.getAds().size() <= 0) {
                    return;
                }
                c.a(c.this, campaignUnit.getAds());
            }
        });
    }

    private void b(List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.o += list.size();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        com.mbridge.msdk.videocommon.d.c cVar = this.v;
        if (cVar == null || this.o > cVar.v()) {
            this.o = 0;
        }
        if (ak.b(this.m)) {
            com.mbridge.msdk.reward.b.a.a(this.m, this.o);
        }
    }

    private int h() {
        try {
            int iA = ak.b(this.m) ? com.mbridge.msdk.reward.b.a.a(this.m) : 0;
            com.mbridge.msdk.videocommon.d.c cVar = this.v;
            if (cVar == null || iA > cVar.v()) {
                return 0;
            }
            return iA;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            if (ak.b(this.m)) {
                com.mbridge.msdk.reward.b.a.a(this.m, 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String j() {
        try {
            return ak.b(com.mbridge.msdk.reward.b.a.f) ? com.mbridge.msdk.reward.b.a.f : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private void b(String str) {
        if (ak.b(str)) {
            com.mbridge.msdk.reward.b.a.f = str;
        }
    }

    private void k() {
        try {
            if (com.mbridge.msdk.foundation.same.a.d.a == null || com.mbridge.msdk.foundation.same.a.d.a.size() <= 0) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.d.a.clear();
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    private void l() {
        try {
            com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.h.a(this.l)).a(this.m);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    private boolean c(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        try {
            return campaignEx.getPlayable_ads_without_video() == 2;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    public final void a(List<CampaignEx> list) {
        this.R = list;
    }

    public final CopyOnWriteArrayList<CampaignEx> d() {
        return this.F;
    }

    public final void a(int i, int i2, int i3) {
        this.B = i;
        this.C = i2;
        this.D = i3;
    }

    public final void a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        String str = map.get("bid_token");
        if (this.v != null && TextUtils.isEmpty(str)) {
            int iB = this.v.b() * 1000;
            List<CampaignEx> list = this.R;
            if (list != null && list.size() > 0) {
                if (System.currentTimeMillis() - this.R.get(0).getTimestamp() < iB) {
                    a("hit ltorwc", 0);
                    return;
                }
            }
        }
        a(str, this.G, map);
    }

    /* JADX INFO: compiled from: RewardMVVideoAdapter.java */
    public class e implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f2391b;
        private Map<String, String> c;

        public e(String str, Map<String, String> map) {
            this.f2391b = str;
            this.c = map;
            map.put("bid_token", str);
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                c cVar = c.this;
                cVar.s = af.b(cVar.l, c.this.m);
                if (c.this.L) {
                    return;
                }
                if (c.this.J != null && c.this.M != null) {
                    c.this.M.removeCallbacks(c.this.J);
                }
                c.this.K = true;
                if (c.this.M != null) {
                    Message messageObtainMessage = c.this.M.obtainMessage();
                    messageObtainMessage.obj = this.c;
                    messageObtainMessage.what = 1;
                    c.this.M.sendMessage(messageObtainMessage);
                }
                if (TextUtils.isEmpty(c.this.s)) {
                    return;
                }
                aa.d("RewardMVVideoAdapter", "excludeId : " + c.this.s);
            } catch (Exception e) {
                aa.d("RewardMVVideoAdapter", e.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: RewardMVVideoAdapter.java */
    public class d implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f2390b;
        private Map<String, String> c;

        public d(String str, Map<String, String> map) {
            this.f2390b = str;
            this.c = map;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (c.this.K) {
                    return;
                }
                c.this.L = true;
                if (c.this.M != null) {
                    Message messageObtainMessage = c.this.M.obtainMessage();
                    messageObtainMessage.obj = this.f2390b;
                    messageObtainMessage.what = 2;
                    c.this.M.sendMessage(messageObtainMessage);
                }
            } catch (Exception e) {
                aa.d("RewardMVVideoAdapter", e.getMessage());
            }
        }
    }

    private void b(String str, boolean z, Map<String, String> map) {
        com.mbridge.msdk.foundation.same.f.b.g().execute(new e(str, map));
        if (this.M != null) {
            d dVar = new d(str, map);
            this.J = dVar;
            this.M.postDelayed(dVar, 90000L);
            return;
        }
        a(str, z, map);
    }

    static /* synthetic */ void a(c cVar, String str, List list, List list2, boolean z) {
        com.mbridge.msdk.foundation.db.f.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g())).a(str, (List<CampaignEx>) list, (List<CampaignEx>) list2, z);
        if (list2 != null && list2.size() > 0) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                CampaignEx campaignEx = (CampaignEx) it.next();
                if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                    com.mbridge.msdk.videocommon.a.b(str + "_" + campaignEx.getId() + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e());
                    com.mbridge.msdk.videocommon.a.b(campaignEx.getAdType(), campaignEx);
                }
            }
        }
        if (z) {
            cVar.a(str, (List<CampaignEx>) list, (List<CampaignEx>) list2);
        }
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            CampaignEx campaignEx2 = (CampaignEx) list.get(0);
            new com.mbridge.msdk.reward.a.a(str, cVar.y).a(campaignEx2.getLocalRequestId(), campaignEx2.getRequestId(), 1, campaignEx2.getEcppv());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ void a(c cVar, String str, List list, boolean z) {
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return;
        }
        com.mbridge.msdk.foundation.db.f.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g())).a(str, (List<CampaignEx>) list, z);
    }

    static /* synthetic */ void a(c cVar, WindVaneWebView windVaneWebView, String str, CampaignEx campaignEx, List list, String str2, String str3, com.mbridge.msdk.videocommon.d.c cVar2, String str4) {
        j jVar;
        try {
            com.mbridge.msdk.videocommon.a.C0524a c0524a = new com.mbridge.msdk.videocommon.a.C0524a();
            WindVaneWebView windVaneWebView2 = new WindVaneWebView(com.mbridge.msdk.foundation.controller.b.d().g());
            c0524a.a(windVaneWebView2);
            if (list != null && list.size() > 0) {
                jVar = new j(null, campaignEx, list);
            } else {
                jVar = new j(null, campaignEx);
            }
            j jVar2 = jVar;
            jVar2.a(cVar.x);
            jVar2.a(str3);
            jVar2.a(cVar2);
            jVar2.d(cVar.G);
            RunnableC0505c runnableC0505c = cVar.new RunnableC0505c(windVaneWebView, str3, campaignEx, list, str2, str3, cVar2, cVar.x, cVar);
            windVaneWebView2.setWebViewListener(new f(windVaneWebView, str, str3, c0524a, campaignEx, cVar, runnableC0505c, cVar.M));
            windVaneWebView2.setObject(jVar2);
            windVaneWebView2.loadUrl(str2);
            cVar.M.postDelayed(runnableC0505c, 5000L);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            aa.a("RewardMVVideoAdapter", th.getMessage());
        }
    }

    static /* synthetic */ void a(c cVar, String str, CampaignEx campaignEx, String str2, String str3, com.mbridge.msdk.videocommon.d.c cVar2) {
        j jVar;
        try {
            com.mbridge.msdk.videocommon.a.C0524a c0524a = new com.mbridge.msdk.videocommon.a.C0524a();
            WindVaneWebView windVaneWebView = new WindVaneWebView(com.mbridge.msdk.foundation.controller.b.d().g());
            c0524a.a(windVaneWebView);
            String strB = com.mbridge.msdk.video.bt.a.c.a().b();
            c0524a.a(strB);
            CampaignUnit campaignUnit = cVar.E;
            if (campaignUnit != null && campaignUnit.getAds() != null && cVar.E.getAds().size() > 0) {
                jVar = new j(null, campaignEx, cVar.E.getAds());
            } else {
                jVar = new j(null, campaignEx);
            }
            j jVar2 = jVar;
            jVar2.a(cVar.x);
            jVar2.a(str3);
            jVar2.c(strB);
            jVar2.a(cVar2);
            jVar2.d(cVar.G);
            b bVar = cVar.new b(str3, campaignEx, str2, str3, cVar2, cVar.x, cVar);
            windVaneWebView.setWebViewListener(new a(str, str3, c0524a, campaignEx, cVar, bVar, cVar.M));
            windVaneWebView.setObject(jVar2);
            windVaneWebView.loadUrl(str2);
            cVar.M.postDelayed(bVar, 5000L);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            aa.a("RewardMVVideoAdapter", th.getMessage());
        }
    }

    static /* synthetic */ void a(c cVar, String str, String str2) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList;
        try {
            if (cVar.w != null && !TextUtils.isEmpty(str2)) {
                for (CampaignEx campaignEx : cVar.w) {
                    if (campaignEx != null) {
                        String videoUrlEncode = campaignEx.getVideoUrlEncode();
                        if (!TextUtils.isEmpty(videoUrlEncode) && str2.equals(videoUrlEncode)) {
                            cVar.w.remove(campaignEx);
                            cVar.b(campaignEx);
                            break;
                        }
                        String str3 = campaignEx.getendcard_url();
                        if (!TextUtils.isEmpty(str3) && str2.equals(str3)) {
                            cVar.w.remove(campaignEx);
                            cVar.b(campaignEx);
                            break;
                        }
                        CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
                        if (rewardTemplateMode != null) {
                            List<CampaignEx.c.a> listF = rewardTemplateMode.f();
                            if (listF != null) {
                                for (CampaignEx.c.a aVar : listF) {
                                    if (aVar != null && aVar.f2084b != null && aVar.f2084b.contains(str2)) {
                                        cVar.w.remove(campaignEx);
                                        cVar.b(campaignEx);
                                        break;
                                    }
                                }
                            }
                            String strE = rewardTemplateMode.e();
                            if (!TextUtils.isEmpty(strE) && str2.equals(strE)) {
                                cVar.w.remove(campaignEx);
                                cVar.b(campaignEx);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                if (cVar.u == null || (copyOnWriteArrayList = cVar.w) == null || copyOnWriteArrayList.size() != 0) {
                    return;
                }
                Handler handler = cVar.M;
                if (handler != null) {
                    handler.removeMessages(5);
                }
                cVar.a(str, 1);
                cVar.u.a(cVar.w, str);
                return;
            }
            if (cVar.u != null) {
                Handler handler2 = cVar.M;
                if (handler2 != null) {
                    handler2.removeMessages(5);
                }
                cVar.a(str, 1);
                cVar.u.a(cVar.w, str);
            }
        } catch (Throwable th) {
            aa.b("RewardMVVideoAdapter", th.getMessage(), th);
            try {
                if (cVar.u != null) {
                    Handler handler3 = cVar.M;
                    if (handler3 != null) {
                        handler3.removeMessages(5);
                    }
                    cVar.a(str, 1);
                }
            } catch (Throwable th2) {
                aa.b("RewardMVVideoAdapter", th2.getMessage(), th2);
            }
        }
    }

    static /* synthetic */ void a(c cVar, CampaignUnit campaignUnit) throws Throwable {
        cVar.E = campaignUnit;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA = cVar.a(campaignUnit);
        new com.mbridge.msdk.reward.a.a(cVar.m, cVar.y).a(copyOnWriteArrayListA, cVar.I, cVar);
        cVar.a(copyOnWriteArrayListA, true);
    }

    static /* synthetic */ void a(c cVar, List list) {
        if (cVar.l == null || list == null || list.size() == 0) {
            return;
        }
        k kVarA = k.a(com.mbridge.msdk.foundation.db.h.a(cVar.l));
        for (int i = 0; i < list.size(); i++) {
            CampaignEx campaignEx = (CampaignEx) list.get(i);
            if (campaignEx != null && kVarA != null && !kVarA.a(campaignEx.getId())) {
                com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
                gVar.a(campaignEx.getId());
                gVar.a(campaignEx.getFca());
                gVar.b(campaignEx.getFcb());
                gVar.d(0);
                gVar.c(0);
                gVar.a(System.currentTimeMillis());
                kVarA.a(gVar);
            }
        }
    }
}
