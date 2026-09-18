package com.mbridge.msdk.interstitial.c;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.d;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import com.mbridge.msdk.out.InterstitialListener;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: InterstitialController.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static String a;
    public static Map<String, Integer> c = new HashMap();
    public static Map<String, Integer> d = new HashMap();
    public static Map<String, c> e = new HashMap();
    private Context g;
    private String h;
    private String i;
    private String j;
    private MBridgeIds k;
    private String l;
    private Handler m;
    private f n;
    private InterstitialListener o;
    private String f = "InterstitialController";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2240b = false;
    private String p = "";
    private String q = "";
    private boolean r = false;

    public static void a(String str, int i) {
        try {
            if (c == null || TextUtils.isEmpty(str)) {
                return;
            }
            c.put(str, Integer.valueOf(i));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int a(String str) {
        Map<String, Integer> map;
        Integer num;
        try {
            if (TextUtils.isEmpty(str) || (map = c) == null || !map.containsKey(str) || (num = c.get(str)) == null) {
                return 0;
            }
            return num.intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public final void a(InterstitialListener interstitialListener) {
        this.o = interstitialListener;
    }

    public a() {
        try {
            this.m = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.interstitial.c.a.1
                @Override // android.os.Handler
                public final void handleMessage(Message message) {
                    if (message == null) {
                        return;
                    }
                    int i = message.what;
                    if (i == 1) {
                        if (a.this.o != null) {
                            a.this.o.onInterstitialLoadSuccess(a.this.k);
                            return;
                        }
                        return;
                    }
                    String str = "";
                    if (i == 2) {
                        if (a.this.o != null) {
                            if (message.obj != null && (message.obj instanceof String)) {
                                str = (String) message.obj;
                            }
                            a.this.o.onInterstitialLoadFail(a.this.k, TextUtils.isEmpty(str) ? "can't show because unknow error" : str);
                            return;
                        }
                        return;
                    }
                    try {
                        if (i == 3) {
                            a.this.f2240b = true;
                            if (a.this.o != null) {
                                a.this.o.onInterstitialShowSuccess(a.this.k);
                                HashMap map = new HashMap();
                                if (TextUtils.isEmpty(a.this.l)) {
                                    map.put(MBridgeConstans.PROPERTIES_UNIT_ID, a.this.k.getUnitId());
                                }
                                m.a().a("2000130", a.this.l, map);
                                return;
                            }
                            return;
                        }
                        if (i == 4) {
                            if (a.this.o != null) {
                                String str2 = (message.obj == null || !(message.obj instanceof String)) ? "" : (String) message.obj;
                                String str3 = TextUtils.isEmpty(str2) ? "can't show because unknow error" : str2;
                                a.this.o.onInterstitialShowFail(a.this.k, str3);
                                HashMap map2 = new HashMap();
                                map2.put("code", "");
                                map2.put("reason", str3);
                                map2.put("failingURL", "");
                                if (TextUtils.isEmpty(a.this.l)) {
                                    map2.put(MBridgeConstans.PROPERTIES_UNIT_ID, a.this.k.getUnitId());
                                }
                                m.a().a("2000131", a.this.l, map2);
                                return;
                            }
                            return;
                        }
                        if (i == 6) {
                            if (a.this.o != null) {
                                a.this.o.onInterstitialAdClick(a.this.k);
                            }
                        } else {
                            if (i != 7) {
                                return;
                            }
                            a.this.f2240b = false;
                            if (a.this.o != null) {
                                a.this.o.onInterstitialClosed(a.this.k);
                                HashMap map3 = new HashMap();
                                if (TextUtils.isEmpty(a.this.l)) {
                                    map3.put(MBridgeConstans.PROPERTIES_UNIT_ID, a.this.k.getUnitId());
                                }
                                m.a().a("2000152", a.this.l, map3);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            };
        } catch (Exception e2) {
            try {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public final boolean a(Context context, Map<String, Object> map) {
        try {
            this.r = false;
            if (map != null && context != null && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID) && (map.get(MBridgeConstans.PROPERTIES_UNIT_ID) instanceof String)) {
                if (map.containsKey(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY) && (map.get(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY) instanceof String)) {
                    this.j = (String) map.get(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY);
                }
                this.h = (String) map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
                this.g = context;
                if (map.containsKey(MBridgeConstans.PLACEMENT_ID) && map.get(MBridgeConstans.PLACEMENT_ID) != null) {
                    this.i = (String) map.get(MBridgeConstans.PLACEMENT_ID);
                }
                this.k = new MBridgeIds(this.i, this.h);
                this.r = true;
                return this.r;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            this.r = false;
        }
    }

    public final void a() {
        try {
            if (this.g == null) {
                b("context is null");
                return;
            }
            if (TextUtils.isEmpty(this.h)) {
                b("unitid is null");
                return;
            }
            if (!this.r) {
                b("init error");
                return;
            }
            d();
            try {
                f fVar = this.n;
                if (fVar != null) {
                    int iQ = fVar.q();
                    int iV = this.n.v();
                    if (iQ <= 0) {
                        iQ = 1;
                    }
                    if (iV <= 0) {
                        iV = 1;
                    }
                    int i = iV * iQ;
                    if (d != null && !TextUtils.isEmpty(this.h)) {
                        d.put(this.h, Integer.valueOf(i));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            a(false);
        } catch (Exception e3) {
            e3.printStackTrace();
            b("can't show because unknow error");
        }
    }

    public final String b() {
        if (this.f2240b) {
            return this.q;
        }
        return this.p;
    }

    public final void c() {
        try {
            if (this.g == null) {
                c("context is null");
                return;
            }
            if (TextUtils.isEmpty(this.h)) {
                c("unitid is null");
                return;
            }
            if (!this.r) {
                c("init error");
                return;
            }
            MBridgeIds mBridgeIds = this.k;
            if (mBridgeIds != null) {
                this.l = mBridgeIds.getLocalRequestId();
            }
            d();
            b(true);
        } catch (Exception e2) {
            e2.printStackTrace();
            c("can't show because unknow error");
        }
    }

    private void d() {
        try {
            e();
            f fVarE = d.a().e(com.mbridge.msdk.foundation.controller.b.d().h(), this.h);
            this.n = fVarE;
            if (fVarE == null) {
                this.n = f.f(this.h);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(boolean z) {
        try {
            com.mbridge.msdk.interstitial.a.a aVar = new com.mbridge.msdk.interstitial.a.a(this.g, this.h, this.i, this.j, z);
            b bVar = new b(aVar);
            aVar.a(new C0490a(aVar, bVar));
            Handler handler = this.m;
            if (handler != null) {
                handler.postDelayed(bVar, 30000L);
            }
            aVar.b();
        } catch (Exception e2) {
            e2.printStackTrace();
            if (z) {
                return;
            }
            b("can't show because unknow error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        try {
            CampaignEx campaignExA = new com.mbridge.msdk.interstitial.a.a(this.g, this.h, this.i, this.j, true).a();
            if (campaignExA != null) {
                a(campaignExA);
            } else if (z) {
                a(true);
            } else {
                c("no ads available can show");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.o != null) {
                c("can't show because unknow error");
            }
        }
    }

    private void a(CampaignEx campaignEx) {
        c cVar = new c();
        if (e != null && !TextUtils.isEmpty(this.h)) {
            e.put(this.h, cVar);
        }
        Intent intent = new Intent(this.g, (Class<?>) MBInterstitialActivity.class);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        if (!TextUtils.isEmpty(this.h)) {
            intent.putExtra("unitId", this.h);
        }
        if (campaignEx != null) {
            this.q = campaignEx.getRequestId();
            intent.putExtra("campaign", campaignEx);
        }
        Context context = this.g;
        if (context != null) {
            context.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: InterstitialController.java */
    public class b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.mbridge.msdk.interstitial.a.a f2242b;

        public b(com.mbridge.msdk.interstitial.a.a aVar) {
            this.f2242b = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.mbridge.msdk.interstitial.a.a aVar = this.f2242b;
                if (aVar != null) {
                    if (aVar.c()) {
                        a.this.c("load timeout");
                    } else if (a.this.o != null) {
                        a.this.b("load timeout");
                    }
                    this.f2242b.a((C0490a) null);
                    this.f2242b = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.interstitial.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: InterstitialController.java */
    public class C0490a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.mbridge.msdk.interstitial.a.a f2241b;
        private b c;

        public C0490a(com.mbridge.msdk.interstitial.a.a aVar, b bVar) {
            this.f2241b = aVar;
            this.c = bVar;
        }

        public final void a(boolean z, String str) {
            try {
                a.this.p = str;
                if (this.c != null) {
                    if (a.this.m != null) {
                        a.this.m.removeCallbacks(this.c);
                    }
                    if (z) {
                        a.this.b(false);
                    } else if (a.this.o != null) {
                        a.e(a.this);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final void b(boolean z, String str) {
            try {
                com.mbridge.msdk.interstitial.a.a aVar = this.f2241b;
                if (aVar != null) {
                    aVar.a((C0490a) null);
                    this.f2241b = null;
                }
                if (this.c != null) {
                    if (a.this.m != null) {
                        a.this.m.removeCallbacks(this.c);
                    }
                    if (z) {
                        if (a.this.o != null) {
                            a.this.c(str);
                        }
                    } else if (a.this.o != null) {
                        a.this.b(str);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: InterstitialController.java */
    public class c {
        public c() {
        }

        public final void a(String str) {
            try {
                a.this.c(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final void a() {
            try {
                a.f(a.this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final void b() {
            try {
                if (a.this.m != null) {
                    a.this.m.sendEmptyMessage(7);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final void c() {
            try {
                if (a.this.m != null) {
                    a.this.m.sendEmptyMessage(6);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        try {
            if (this.m != null) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = str;
                messageObtain.what = 2;
                this.m.sendMessage(messageObtain);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        try {
            if (this.m != null) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = str;
                messageObtain.what = 4;
                this.m.sendMessage(messageObtain);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void e() {
        try {
            new e().a(this.g, (String) null, (String) null, this.h);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ void e(a aVar) {
        Handler handler = aVar.m;
        if (handler != null) {
            handler.sendEmptyMessage(1);
        }
    }

    static /* synthetic */ void f(a aVar) {
        Handler handler = aVar.m;
        if (handler != null) {
            handler.sendEmptyMessage(3);
        }
    }
}
