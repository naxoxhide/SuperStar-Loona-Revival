package com.mbridge.msdk.reward.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.f;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.videocommon.download.g;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardVideoController.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f2393b = "";
    public static String c = "";
    public static String d = "";
    public static String f = null;
    public static String g = "";
    private volatile String A;
    private String B;
    private int F;
    private int G;
    private int H;
    private boolean M;
    private Queue<Integer> U;
    private String V;
    b a;
    private CopyOnWriteArrayList<CampaignEx> ae;
    private List<CampaignEx> af;
    private Context n;
    private int o;
    private com.mbridge.msdk.reward.adapter.c p;
    private com.mbridge.msdk.videocommon.d.c q;
    private com.mbridge.msdk.videocommon.d.a r;
    private volatile InterVideoOutListener s;
    private volatile c t;
    private String u;
    private String v;
    private MBridgeIds w;
    private String z;
    private static ConcurrentHashMap<String, Integer> S = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, String> T = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, d> h = new ConcurrentHashMap<>();
    private String x = "";
    private String y = "";
    private int C = 0;
    private int E = 2;
    private boolean I = false;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean N = false;
    private ArrayList<Integer> O = new ArrayList<>(7);
    private boolean P = false;
    private final Object Q = new Object();
    public boolean e = false;
    private List<CampaignEx> R = new ArrayList();
    private h W = null;
    private volatile boolean X = true;
    private volatile boolean Y = false;
    private volatile boolean Z = false;
    private volatile boolean aa = false;
    private volatile boolean ab = false;
    private volatile boolean ac = false;
    private volatile boolean ad = false;
    volatile boolean i = false;
    volatile boolean j = false;
    volatile boolean k = false;
    volatile boolean l = false;
    volatile boolean m = false;
    private Handler D = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.reward.b.a.1
        /* JADX WARN: Code duplicated, block: B:145:0x0468  */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            String str;
            int i = message.what;
            boolean z = false;
            switch (i) {
                case 8:
                    if (a.this.ae != null && a.this.ae.size() > 0) {
                        boolean z2 = (a.this.af == null || a.this.af.size() <= 0) ? false : !TextUtils.isEmpty(((CampaignEx) a.this.af.get(0)).getCMPTEntryUrl());
                        int nscpt = ((CampaignEx) a.this.ae.get(0)).getNscpt();
                        if (a.this.p == null || !a.this.p.a(a.this.ae, z2, nscpt)) {
                            if (a.this.t != null && a.this.M) {
                                com.mbridge.msdk.videocommon.a.c(a.this.v);
                                com.mbridge.msdk.videocommon.a.a();
                                c.a(a.this.t, "load timeout");
                                break;
                            }
                        } else if (a.this.t != null && a.this.M) {
                            a.this.t.a(a.this.A, a.this.v);
                            break;
                        }
                    }
                    break;
                case 9:
                    if (a.this.s != null && a.this.M) {
                        Object obj = message.obj;
                        if (obj instanceof String) {
                            obj.toString();
                        }
                        Bundle data = message.getData();
                        if (data != null && data.containsKey(MBridgeConstans.PLACEMENT_ID)) {
                            TextUtils.isEmpty(data.getString(MBridgeConstans.PLACEMENT_ID));
                        }
                        try {
                            if (a.this.J) {
                                a.j(a.this);
                            }
                            if (ac.a().a("r_l_b_m_t_r_i", true)) {
                                m.a().a("2000048", a.this.w.getLocalRequestId(), a.this.R, a.this.v, "");
                            } else {
                                com.mbridge.msdk.reward.c.a.a(a.this.n, a.this.R, a.this.v, 0L);
                            }
                            a.this.s.onVideoLoadSuccess(a.this.w);
                        } catch (Exception e) {
                            if (MBridgeConstans.DEBUG) {
                                e.printStackTrace();
                                return;
                            }
                            return;
                        }
                        break;
                    }
                    break;
                case 16:
                case 18:
                    if (a.this.s != null && a.this.M) {
                        Object obj2 = message.obj;
                        String string = obj2 instanceof String ? obj2.toString() : "";
                        com.mbridge.msdk.videocommon.a.c(a.this.v);
                        com.mbridge.msdk.videocommon.a.a();
                        try {
                            if (a.this.J) {
                                a.j(a.this);
                            }
                            if (TextUtils.isEmpty(a.this.x)) {
                                a aVar = a.this;
                                aVar.x = aVar.w.getLocalRequestId();
                            }
                            if (ac.a().a("r_l_b_m_t_r_i", true)) {
                                String str2 = a.this.x;
                                Bundle data2 = message.getData();
                                if (data2 == null || !data2.containsKey("local_id")) {
                                    str = str2;
                                } else {
                                    String string2 = data2.getString("local_id");
                                    if (TextUtils.isEmpty(string2)) {
                                        str = str2;
                                    } else {
                                        str = string2;
                                    }
                                }
                                if (i == 18) {
                                    m.a().a("2000047", str, (List<CampaignEx>) null, a.this.v, string);
                                } else {
                                    m.a().a("2000047", str, a.this.R, a.this.v, string);
                                }
                            }
                            a.this.s.onVideoLoadFail(a.this.w, string);
                        } catch (Exception e2) {
                            if (MBridgeConstans.DEBUG) {
                                e2.printStackTrace();
                                return;
                            }
                            return;
                        }
                        break;
                    }
                    break;
                case 17:
                    if (a.this.s != null && a.this.M) {
                        Object obj3 = message.obj;
                        if (obj3 instanceof String) {
                            obj3.toString();
                        }
                        Bundle data3 = message.getData();
                        if (data3 != null && data3.containsKey(MBridgeConstans.PLACEMENT_ID)) {
                            TextUtils.isEmpty(data3.getString(MBridgeConstans.PLACEMENT_ID));
                        }
                        if (data3 != null && data3.containsKey(MBridgeConstans.PROPERTIES_IS_CACHED_CAMPAIGN)) {
                            z = data3.getBoolean(MBridgeConstans.PROPERTIES_IS_CACHED_CAMPAIGN, false);
                        }
                        try {
                            if (a.this.J) {
                                a.j(a.this);
                            }
                            if (a.this.w != null) {
                                a.this.w.setCache(z);
                            }
                            a.this.s.onLoadSuccess(a.this.y, a.this.w);
                        } catch (Exception e3) {
                            if (MBridgeConstans.DEBUG) {
                                e3.printStackTrace();
                                return;
                            }
                            return;
                        }
                        break;
                    }
                    break;
                case 1001001:
                    HashMap map = new HashMap();
                    try {
                        String md5 = SameMD5.getMD5(af.c());
                        map.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, md5);
                        com.mbridge.msdk.reward.c.a.a("2000123", a.this.v, md5, "auto_load", 94, false);
                        break;
                    } catch (Exception unused) {
                    }
                    a.this.a(false, (Map<String, String>) map);
                    break;
                case 1001002:
                    int iG = a.this.q != null ? a.this.q.G() : 0;
                    if (a.this.p != null) {
                        if (a.this.p.b()) {
                            if (a.this.t != null) {
                                aa.a("RewardVideoController", "load timeout task called for onVideoLoadSuccess by isReady exception");
                                try {
                                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListD = a.this.p.d();
                                    if (copyOnWriteArrayListD != null && copyOnWriteArrayListD.size() > 0) {
                                        com.mbridge.msdk.reward.c.a.a(copyOnWriteArrayListD.get(0), com.mbridge.msdk.foundation.controller.b.d().g(), "load timeout task called onVideoLoadSuccess after " + iG + "s exception", a.this.v, a.this.J, "", "", iG);
                                        a.this.a(copyOnWriteArrayListD);
                                    }
                                } catch (Throwable th) {
                                    aa.d("RewardVideoController", th.getMessage());
                                }
                                a.this.t.b(a.this.A, a.this.v);
                            }
                        } else if (a.this.p.g(false)) {
                            if (a.this.p.b()) {
                                if (a.this.t != null) {
                                    aa.a("RewardVideoController", "load timeout task called for onVideoLoadSuccess by isReady but updateCampaignsLoadTimeoutState exception");
                                    a.this.p.e(false);
                                    try {
                                        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListD2 = a.this.p.d();
                                        if (copyOnWriteArrayListD2 != null && copyOnWriteArrayListD2.size() > 0) {
                                            com.mbridge.msdk.reward.c.a.a(copyOnWriteArrayListD2.get(0), com.mbridge.msdk.foundation.controller.b.d().g(), "load timeout task called onVideoLoadSuccess after " + iG + "s exception", a.this.v, a.this.J, "", "", iG);
                                            a.this.a(copyOnWriteArrayListD2);
                                        }
                                    } catch (Throwable th2) {
                                        aa.d("RewardVideoController", th2.getMessage());
                                    }
                                    a.this.t.b(a.this.A, a.this.v);
                                }
                            } else {
                                a.this.p.f(false);
                                if (a.this.p.g(true)) {
                                    if (a.this.p.b()) {
                                        if (a.this.t != null) {
                                            aa.a("RewardVideoController", "load timeout task called for onVideoLoadSuccess by isReady but updateCampaignsLoadTimeoutState exception");
                                            a.this.p.e(true);
                                            try {
                                                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListD3 = a.this.p.d();
                                                if (copyOnWriteArrayListD3 != null && copyOnWriteArrayListD3.size() > 0) {
                                                    com.mbridge.msdk.reward.c.a.a(copyOnWriteArrayListD3.get(0), com.mbridge.msdk.foundation.controller.b.d().g(), "load timeout task called onVideoLoadSuccess after " + iG + "s exception", a.this.v, a.this.J, "", "", iG);
                                                    a.this.a(copyOnWriteArrayListD3);
                                                }
                                            } catch (Throwable th3) {
                                                aa.d("RewardVideoController", th3.getMessage());
                                            }
                                            a.this.t.b(a.this.A, a.this.v);
                                        }
                                    } else {
                                        if (a.this.t != null) {
                                            aa.a("RewardVideoController", "load timeout task called for onVideoLoadFail after " + iG + "s exception");
                                        }
                                        a.this.p.f(true);
                                    }
                                } else if (a.this.t != null) {
                                    aa.a("RewardVideoController", "load timeout task called for onVideoLoadFail after " + iG + "s exception");
                                }
                            }
                            break;
                        } else if (a.this.p.g(true)) {
                            if (a.this.p.b()) {
                                if (a.this.t != null) {
                                    aa.a("RewardVideoController", "load timeout task called for onVideoLoadSuccess by isReady but updateCampaignsLoadTimeoutState");
                                    a.this.p.e(true);
                                    try {
                                        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListD4 = a.this.p.d();
                                        if (copyOnWriteArrayListD4 != null && copyOnWriteArrayListD4.size() > 0) {
                                            com.mbridge.msdk.reward.c.a.a(copyOnWriteArrayListD4.get(0), com.mbridge.msdk.foundation.controller.b.d().g(), "load timeout task called onVideoLoadSuccess after " + iG + "s exception", a.this.v, a.this.J, "", "", iG);
                                            a.this.a(copyOnWriteArrayListD4);
                                        }
                                    } catch (Throwable th4) {
                                        aa.d("RewardVideoController", th4.getMessage());
                                    }
                                    a.this.t.b(a.this.A, a.this.v);
                                }
                            } else {
                                if (a.this.t != null) {
                                    aa.a("RewardVideoController", "load timeout task called for onVideoLoadFail after " + iG + " s");
                                }
                                a.this.p.f(true);
                            }
                        } else if (a.this.t != null) {
                            aa.a("RewardVideoController", "load timeout task called for onVideoLoadFail after " + iG + " s");
                        }
                    } else if (a.this.t != null) {
                        aa.a("RewardVideoController", "load timeout task called for onVideoLoadFail by mRewardMvVideoAdapter is null exception");
                    }
                    break;
            }
        }
    };

    public final void a(boolean z) {
        this.I = z;
    }

    public final void b(boolean z) {
        this.J = z;
    }

    public final void a(int i) {
        this.E = i;
    }

    public final String a() {
        com.mbridge.msdk.reward.adapter.c cVar = this.p;
        return cVar != null ? cVar.a(this.P) : "";
    }

    public final void a(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            ai.a(this.n, "MBridge_ConfirmTitle" + this.v, str.trim());
        }
        if (!TextUtils.isEmpty(str2)) {
            ai.a(this.n, "MBridge_ConfirmContent" + this.v, str2.trim());
        }
        if (!TextUtils.isEmpty(str4)) {
            ai.a(this.n, "MBridge_CancelText" + this.v, str4.trim());
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        ai.a(this.n, "MBridge_ConfirmText" + this.v, str3.trim());
    }

    public final void c(boolean z) {
        this.N = z;
    }

    public final void a(int i, int i2, int i3) {
        this.F = i;
        this.G = i2;
        if (i2 == com.mbridge.msdk.foundation.same.a.r) {
            this.H = i3 < 0 ? 5 : i3;
        }
        if (this.G == com.mbridge.msdk.foundation.same.a.q) {
            this.H = i3 < 0 ? 80 : i3;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ivRewardEnable", 1);
            jSONObject.put("ivRewardMode", i == com.mbridge.msdk.foundation.same.a.o ? 0 : 1);
            jSONObject.put("ivRewardPlayValueMode", i2 == com.mbridge.msdk.foundation.same.a.q ? 0 : 1);
            jSONObject.put("ivRewardPlayValue", i3);
            com.mbridge.msdk.c.d.a();
            com.mbridge.msdk.foundation.a.a.a.a().a("ivreward_" + this.v, jSONObject.toString());
        } catch (Exception unused) {
            aa.d("RewardVideoController", "setIVRewardEnable to SP was ERROR");
        }
    }

    public static void a(String str, int i) {
        try {
            if (S == null || !ak.b(str)) {
                return;
            }
            S.put(str, Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int a(String str) {
        ConcurrentHashMap<String, Integer> concurrentHashMap;
        Integer num;
        try {
            if (!ak.b(str) || (concurrentHashMap = S) == null || !concurrentHashMap.containsKey(str) || (num = S.get(str)) == null) {
                return 0;
            }
            return num.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void a(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (concurrentHashMap = T) == null || concurrentHashMap.containsKey(str)) {
            return;
        }
        T.put(str, str2);
    }

    public final void b() {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (!this.P || (concurrentHashMap = T) == null || concurrentHashMap.containsKey(a())) {
            return;
        }
        T.remove(a());
    }

    public static void insertExcludeId(String str, CampaignEx campaignEx) {
        if (TextUtils.isEmpty(str) || campaignEx == null || com.mbridge.msdk.foundation.controller.b.d().g() == null) {
            return;
        }
        j jVarA = j.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
        f fVar = new f();
        fVar.a(System.currentTimeMillis());
        fVar.b(str);
        fVar.a(campaignEx.getId());
        jVarA.a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: RewardVideoController.java */
    public final class d implements com.mbridge.msdk.video.bt.module.b.h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private a f2404b;
        private int c;
        private Handler d;
        private int e;

        private d(a aVar, int i, Handler handler) {
            this.e = 0;
            this.f2404b = aVar;
            this.c = i;
            this.d = handler;
        }

        @Override // com.mbridge.msdk.video.bt.module.b.h
        public final void a() {
            a.this.e = false;
            try {
                com.mbridge.msdk.reward.a.a aVar = new com.mbridge.msdk.reward.a.a(a.this.v, a.this.I);
                a aVar2 = this.f2404b;
                aVar.a(a.c, (aVar2 == null || aVar2.p == null) ? "" : this.f2404b.p.f2375b, 3, a.d);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                a aVar3 = this.f2404b;
                if (aVar3 != null) {
                    aVar3.P = true;
                    if (this.f2404b.p != null) {
                        this.f2404b.p.f2375b = "";
                    }
                    final a aVar4 = this.f2404b;
                    final int i = this.c;
                    com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() { // from class: com.mbridge.msdk.reward.b.a.7
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                if (a.this.W == null) {
                                    a.this.W = h.a(com.mbridge.msdk.foundation.controller.b.d().g());
                                }
                                i iVarA = i.a(a.this.W);
                                if (iVarA != null) {
                                    iVarA.a(a.this.v);
                                }
                            } catch (Throwable unused) {
                                aa.d("RewardVideoController", "can't find DailyPlayCapDao");
                            }
                            if (i != 1) {
                                return;
                            }
                            ai.a(a.this.n, a.this.A + "_" + i, Integer.valueOf(a.this.o + 1));
                        }
                    });
                    if (a.this.J) {
                        a.j(a.this);
                    }
                    if (this.f2404b.s != null) {
                        if (TextUtils.isEmpty(a.f2393b) && !TextUtils.isEmpty(a.g)) {
                            a.f2393b = a.g;
                        }
                        this.f2404b.s.onAdShow(a.f2393b, a.this.w);
                        this.e = 2;
                    }
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.h
        public final void a(boolean z, com.mbridge.msdk.videocommon.b.c cVar) {
            try {
                a aVar = this.f2404b;
                if (aVar == null || aVar.s == null) {
                    return;
                }
                if (cVar == null) {
                    cVar = com.mbridge.msdk.videocommon.b.c.b(this.f2404b.B);
                }
                if (a.this.J) {
                    a.j(a.this);
                    a.this.b();
                    com.mbridge.msdk.foundation.same.a.d.d(a.this.v, a.this.a());
                }
                RewardInfo rewardInfo = new RewardInfo(z, cVar.a(), String.valueOf(cVar.b()));
                if (TextUtils.isEmpty(a.f2393b) && !TextUtils.isEmpty(a.g)) {
                    a.f2393b = a.g;
                }
                this.f2404b.s.onAdClose(a.f2393b, a.this.w, rewardInfo);
                this.e = 7;
                this.f2404b.P = false;
                a.this.O.clear();
                this.f2404b = null;
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.h
        public final void a(String str) {
            try {
                a.this.e = false;
                if (this.f2404b != null) {
                    if (a.this.J) {
                        a.j(a.this);
                    }
                    this.f2404b.P = false;
                    if (this.f2404b.s != null) {
                        try {
                            if (a.this.ae != null && a.this.ae.size() > 0) {
                                com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), com.mbridge.msdk.foundation.controller.b.d().g(), "show failed: " + str, a.this.v, a.this.J, "", "", 0L);
                            }
                        } catch (Exception unused) {
                        }
                        try {
                            this.f2404b.s.onShowFail(a.f2393b, a.this.w, str);
                        } catch (Exception e) {
                            if (MBridgeConstans.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                        this.e = 4;
                    }
                }
            } catch (Exception e2) {
                this.e = 0;
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.h
        public final void a(boolean z, String str, String str2) {
            try {
                a aVar = this.f2404b;
                if (aVar == null || aVar.s == null) {
                    return;
                }
                if (a.this.J) {
                    a.j(a.this);
                }
                this.f2404b.P = false;
                try {
                    this.f2404b.s.onVideoAdClicked(z, a.this.w);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.h
        public final void a(String str, String str2) {
            try {
                a aVar = this.f2404b;
                if (aVar == null || aVar.s == null) {
                    return;
                }
                try {
                    this.f2404b.s.onVideoComplete(a.this.w);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
                this.e = 5;
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.h
        public final void a(boolean z, int i) {
            try {
                a aVar = this.f2404b;
                if (aVar == null || aVar.s == null) {
                    return;
                }
                try {
                    this.f2404b.s.onAdCloseWithIVReward(a.this.w, new RewardInfo(z, i));
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.h
        public final void b(String str, String str2) {
            try {
                a aVar = this.f2404b;
                if (aVar == null || aVar.s == null) {
                    return;
                }
                try {
                    this.f2404b.s.onEndcardShow(a.this.w);
                    com.mbridge.msdk.foundation.c.b.a().b(str2 + "_2", 2);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
                this.e = 6;
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.h
        public final void a(int i, String str, String str2) {
            this.e = i;
            a aVar = this.f2404b;
            if (aVar == null || aVar.J || this.f2404b.I || this.f2404b.q == null || !this.f2404b.q.s(this.e) || this.f2404b.t == null || c.a(this.f2404b.t) == 1 || c.a(this.f2404b.t) == 3 || a.this.O.contains(Integer.valueOf(this.e))) {
                return;
            }
            a.this.O.add(Integer.valueOf(this.e));
            int iB = this.f2404b.q.B() * 1000;
            if (this.e == 4) {
                iB = 3000;
            }
            Handler handler = this.d;
            if (handler != null) {
                handler.removeMessages(1001001);
                this.d.sendEmptyMessageDelayed(1001001, iB);
                return;
            }
            final HashMap map = new HashMap();
            try {
                String md5 = SameMD5.getMD5(af.c());
                map.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, md5);
                com.mbridge.msdk.reward.c.a.a("2000123", a.this.v, md5, "auto_load", 94, false);
            } catch (Exception unused) {
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.mbridge.msdk.reward.b.a.d.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (d.this.f2404b != null) {
                        d.this.f2404b.a(false, map);
                    }
                }
            }, iB);
        }
    }

    public final void a(InterVideoOutListener interVideoOutListener) {
        this.s = interVideoOutListener;
        this.t = new c(interVideoOutListener, this.D, this.v);
    }

    public final void b(String str, String str2) {
        try {
            this.n = com.mbridge.msdk.foundation.controller.b.d().g();
            this.v = str2;
            this.A = str;
            this.w = new MBridgeIds(this.A, this.v);
            if (!TextUtils.isEmpty(f2393b)) {
                this.w.setLocalRequestId(f2393b);
            }
            this.r = com.mbridge.msdk.videocommon.d.b.a().b();
            com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() { // from class: com.mbridge.msdk.reward.b.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA;
                    if (a.this.n == null || TextUtils.isEmpty(a.this.v)) {
                        return;
                    }
                    try {
                        com.mbridge.msdk.reward.c.a.a(a.this.n, a.this.v);
                        y.b();
                        y.c(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_RES));
                        y.c(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML));
                        com.mbridge.msdk.videocommon.d.b.a().b(a.this.v);
                        if (ac.a().a("c_d_v_w_i", false) || TextUtils.isEmpty(a.this.v) || (copyOnWriteArrayListA = com.mbridge.msdk.videocommon.a.a.a().a(a.this.v, 1)) == null || copyOnWriteArrayListA.size() <= 0) {
                            return;
                        }
                        com.mbridge.msdk.videocommon.download.c.getInstance().createUnitCache(a.this.n, a.this.v, copyOnWriteArrayListA, 94, (com.mbridge.msdk.videocommon.listener.a) null);
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            aa.b("RewardVideoController", "initRewardVideoController task ", e);
                        }
                    }
                }
            });
            if (this.W == null) {
                this.W = h.a(com.mbridge.msdk.foundation.controller.b.d().g());
            }
        } catch (Throwable th) {
            aa.b("RewardVideoController", th.getMessage(), th);
        }
    }

    public final void a(boolean z, Map<String, String> map) {
        a(z, "", map);
    }

    private void c() {
        com.mbridge.msdk.foundation.db.f.a(h.a(this.n)).a(this.v);
    }

    private void d() {
        try {
            List<CampaignEx> listB = com.mbridge.msdk.foundation.db.f.a(h.a(this.n)).b(this.v);
            if (listB == null || listB.size() <= 0) {
                return;
            }
            for (CampaignEx campaignEx : listB) {
                if (!TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                    com.mbridge.msdk.videocommon.a.b(this.v + "_" + campaignEx.getRequestId() + "_" + campaignEx.getCMPTEntryUrl());
                    if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        com.mbridge.msdk.videocommon.a.b(this.v + "_" + campaignEx.getId() + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e());
                    }
                } else {
                    com.mbridge.msdk.videocommon.a.b(campaignEx.getAdType(), campaignEx);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:124:0x0291  */
    /* JADX WARN: Code duplicated, block: B:132:0x02db  */
    /* JADX WARN: Code duplicated, block: B:155:? A[RETURN, SYNTHETIC] */
    public final void a(boolean z, String str, Map<String, String> map) {
        com.mbridge.msdk.foundation.entity.e eVar;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList;
        if (this.t == null) {
            this.t = new c(null, this.D, this.v);
        }
        String str2 = null;
        if (this.t != null && c.a(this.t) == 1) {
            if (!this.M) {
                if (z) {
                    this.M = z;
                    return;
                }
                return;
            } else {
                if (z) {
                    com.mbridge.msdk.foundation.entity.e eVar2 = new com.mbridge.msdk.foundation.entity.e(16, "errorCode: 3501 errorMessage: current unit is loading");
                    if (map != null) {
                        try {
                            if (map.containsKey(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID)) {
                                com.mbridge.msdk.reward.c.a.a(null, this.n, eVar2, this.v, this.J, "", "");
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (map != null && map.containsKey(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID)) {
                        str2 = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                    }
                    this.t.c(eVar2.d(), str2);
                    return;
                }
                return;
            }
        }
        if (map != null && map.containsKey(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID)) {
            this.x = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
        }
        if (this.t != null && c.a(this.t) == 3) {
            this.X = false;
        } else {
            this.X = true;
            if (this.t != null) {
                c.a(this.t, 1);
            }
        }
        this.M = z;
        this.D.removeMessages(1001001);
        this.aa = false;
        this.Z = false;
        this.ab = false;
        this.ac = false;
        d();
        c();
        com.mbridge.msdk.reward.adapter.b.a();
        try {
            if (TextUtils.isEmpty(str)) {
                if (this.I) {
                    com.mbridge.msdk.d.b.getInstance().addInterstitialList(this.A, this.v);
                } else {
                    com.mbridge.msdk.d.b.getInstance().addRewardList(this.A, this.v);
                }
            }
            if (this.J && TextUtils.isEmpty(str)) {
                if (this.t != null) {
                    try {
                        HashMap map2 = new HashMap();
                        map2.put("adtp", String.valueOf(this.I ? 287 : 94));
                        com.mbridge.msdk.reward.c.a.a(null, this.n, new com.mbridge.msdk.foundation.entity.e(0, "bidToken is empty", map2), this.v, this.J, "", "");
                    } catch (Throwable th) {
                        aa.d("RewardVideoController", th.getMessage());
                    }
                    if (map != null && map.containsKey(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID)) {
                        str2 = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                    }
                    c.d(this.t, "bidToken is empty", str2);
                    return;
                }
                return;
            }
            if (com.mbridge.msdk.system.a.a == null) {
                if (this.t != null) {
                    com.mbridge.msdk.foundation.entity.e eVar3 = new com.mbridge.msdk.foundation.entity.e(0, "init error");
                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.ae;
                    if (copyOnWriteArrayList2 != null && copyOnWriteArrayList2.size() > 0) {
                        com.mbridge.msdk.reward.c.a.a(this.ae.get(0), this.n, eVar3, this.v, this.J, "", "");
                    } else {
                        com.mbridge.msdk.reward.c.a.a(null, this.n, eVar3, this.v, this.J, "", "");
                    }
                    if (map != null && map.containsKey(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID)) {
                        str2 = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                    }
                    c.d(this.t, "init error", str2);
                    return;
                }
                return;
            }
            com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), this.v);
            this.q = cVarA;
            if (cVarA == null) {
                this.V = com.mbridge.msdk.foundation.controller.b.d().h();
                com.mbridge.msdk.videocommon.d.b.a().a(this.V, com.mbridge.msdk.foundation.controller.b.d().j(), this.v, new com.mbridge.msdk.videocommon.c.c() { // from class: com.mbridge.msdk.reward.b.a.3
                    @Override // com.mbridge.msdk.videocommon.c.c
                    public final void a(String str3) {
                    }

                    @Override // com.mbridge.msdk.videocommon.c.c
                    public final void b(String str3) {
                    }
                });
                this.q = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), this.v, this.I);
            }
            if (!TextUtils.isEmpty(this.A)) {
                this.q.b(this.A);
            }
            int iG = this.q.G() * 1000;
            Handler handler = this.D;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(1001002, iG);
            }
            this.U = this.q.C();
            try {
                if (f()) {
                    e();
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
            try {
                b(z, str, map);
                return;
            } catch (Exception e2) {
                try {
                    if (this.ae != null && this.ae.size() > 0) {
                        com.mbridge.msdk.reward.c.a.a(this.ae.get(0), this.n, "load exception: " + e2.getMessage(), this.v, this.J, "", "", 0L);
                    }
                } catch (Exception unused2) {
                }
                try {
                    com.mbridge.msdk.foundation.entity.e eVar4 = new com.mbridge.msdk.foundation.entity.e(20, "load exception");
                    if (map != null && map.containsKey(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID)) {
                        com.mbridge.msdk.reward.c.a.a(null, this.n, eVar4, this.v, this.J, "", "");
                    }
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        e3.printStackTrace();
                    }
                }
                if (this.t != null) {
                    c.a(this.t, "load exception");
                    return;
                }
                return;
            }
        } catch (Exception e4) {
            if (this.t != null) {
                eVar = new com.mbridge.msdk.foundation.entity.e(0, "load exception " + e4.getMessage());
                copyOnWriteArrayList = this.ae;
                if (copyOnWriteArrayList != null) {
                    com.mbridge.msdk.reward.c.a.a(this.ae.get(0), this.n, eVar, this.v, this.J, "", "");
                }
                c.a(this.t, eVar.d());
            }
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
        if (this.t != null) {
            eVar = new com.mbridge.msdk.foundation.entity.e(0, "load exception " + e4.getMessage());
            copyOnWriteArrayList = this.ae;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                com.mbridge.msdk.reward.c.a.a(this.ae.get(0), this.n, eVar, this.v, this.J, "", "");
            }
            c.a(this.t, eVar.d());
        }
        if (MBridgeConstans.DEBUG) {
            e4.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.util.List, java.util.concurrent.CopyOnWriteArrayList] */
    /* JADX WARN: Type inference failed for: r0v35, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v38, types: [java.util.List, java.util.concurrent.CopyOnWriteArrayList] */
    /* JADX WARN: Type inference failed for: r0v66, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v85, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r25v0, types: [com.mbridge.msdk.reward.b.a] */
    /* JADX WARN: Type inference failed for: r3v17, types: [com.mbridge.msdk.reward.adapter.c] */
    /* JADX WARN: Type inference failed for: r3v9, types: [com.mbridge.msdk.reward.adapter.c] */
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
    private void b(boolean z, String str, Map<String, String> map) {
        String str2;
        Object obj;
        com.mbridge.msdk.reward.a.a aVar;
        boolean z2;
        String str3;
        Object obj2;
        Object obj3;
        Object obj4;
        ?? r15;
        Object obj5;
        Object obj6;
        if (this.t != null) {
            try {
                HashMap map2 = new HashMap();
                com.mbridge.msdk.videocommon.d.c cVar = this.q;
                if (cVar != null && !TextUtils.isEmpty(cVar.l())) {
                    map2.put("rus_rid", this.q.l());
                }
                com.mbridge.msdk.videocommon.d.a aVar2 = this.r;
                if (aVar2 != null && !TextUtils.isEmpty(aVar2.c())) {
                    map2.put("rs_rid", this.r.c());
                }
                map2.put("r_stid", com.mbridge.msdk.videocommon.d.b.a().b().b());
                if (map != null) {
                    map.put("isDev", z ? "2" : "1");
                    str2 = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                    try {
                        this.y = str2;
                    } catch (Exception unused) {
                    }
                } else {
                    str2 = "";
                }
                m.a().a(str2, map2);
            } catch (Exception unused2) {
                str2 = "";
            }
            String str4 = str2;
            HashMap map3 = new HashMap();
            String str5 = "2000048";
            Object objC = null;
            if (!this.J) {
                this.ad = c(this.v, str4);
                if (this.ad) {
                    if (!j()) {
                        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.ae;
                        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                            return;
                        }
                        try {
                            m.a().a(str4, this.v, copyOnWriteArrayList.get(0).getAdType() + "");
                            map3.put("cache", "1");
                            m.a().c(str4, "2000127", map3);
                            m.a().c(str4, "2000048", map3);
                            if (copyOnWriteArrayList.size() > 1) {
                                m.a().b(copyOnWriteArrayList);
                            } else {
                                m.a().a(copyOnWriteArrayList.get(0));
                            }
                        } catch (Exception unused3) {
                        }
                        c.e(this.t, this.A, this.v);
                        CampaignEx campaignEx = copyOnWriteArrayList.get(0);
                        this.t.a(this.J);
                        com.mbridge.msdk.reward.adapter.c cVar2 = this.p;
                        if (cVar2 != null && cVar2.a(copyOnWriteArrayList, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt())) {
                            a(copyOnWriteArrayList);
                            this.t.b(this.A, this.v);
                        } else {
                            a(copyOnWriteArrayList, this.p);
                        }
                        if (this.X) {
                            com.mbridge.msdk.reward.adapter.c cVar3 = this.p;
                            if (cVar3 != null) {
                                cVar3.a(this.ae);
                            }
                            a(this.U, z, str, map);
                            return;
                        }
                        return;
                    }
                    aa.a("RewardVideoController", "非BID，本地存在可用的缓存，超过上限");
                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.ae;
                    if (copyOnWriteArrayList2 != null && copyOnWriteArrayList2.size() > 0) {
                        Iterator<CampaignEx> it = this.ae.iterator();
                        while (it.hasNext()) {
                            com.mbridge.msdk.videocommon.a.a.a().a(it.next(), this.v);
                        }
                    }
                    com.mbridge.msdk.reward.adapter.c cVar4 = this.p;
                    if (cVar4 != null) {
                        cVar4.a(this.ae);
                    }
                    if (z) {
                        if (this.t != null) {
                            com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(19, "checkOverCap failed");
                            if (map != null) {
                                try {
                                    if (map.containsKey(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID)) {
                                        objC = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                                    }
                                } catch (Exception e) {
                                    obj6 = objC;
                                    if (MBridgeConstans.DEBUG) {
                                        e.printStackTrace();
                                        obj6 = objC;
                                    }
                                }
                            }
                            com.mbridge.msdk.reward.c.a.a(null, this.n, eVar, this.v, this.J, "", "");
                            obj6 = objC;
                            c.d(this.t, "checkOverCap failed", obj6);
                            return;
                        }
                        return;
                    }
                    this.ad = false;
                    this.t.a(this.J);
                    map3.put("cache", "2");
                    m.a().c(str4, "2000127", map3);
                    m.a().c(str4, "2000048", map3);
                    a(this.U, z, str, map);
                    return;
                }
                if (!j()) {
                    this.ad = false;
                    com.mbridge.msdk.reward.adapter.c cVar5 = this.p;
                    if (cVar5 != null) {
                        cVar5.a(this.ae);
                    }
                    this.t.a(this.J);
                    map3.put("cache", "2");
                    m.a().c(str4, "2000127", map3);
                    m.a().c(str4, "2000048", map3);
                    a(this.U, z, str, map);
                    return;
                }
                if (z) {
                    if (this.t != null) {
                        com.mbridge.msdk.foundation.entity.e eVar2 = new com.mbridge.msdk.foundation.entity.e(19, "checkOverCap failed");
                        if (map != null) {
                            try {
                                if (map.containsKey(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID)) {
                                    objC = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                                }
                            } catch (Exception e2) {
                                obj5 = objC;
                                if (MBridgeConstans.DEBUG) {
                                    e2.printStackTrace();
                                    obj5 = objC;
                                }
                            }
                        }
                        com.mbridge.msdk.reward.c.a.a(null, this.n, eVar2, this.v, this.J, "", "");
                        obj5 = objC;
                        c.d(this.t, "checkOverCap failed", obj5);
                        return;
                    }
                    return;
                }
                this.ad = false;
                com.mbridge.msdk.reward.adapter.c cVar6 = this.p;
                if (cVar6 != null) {
                    cVar6.a(this.ae);
                }
                this.t.a(this.J);
                map3.put("cache", "2");
                m.a().c(str4, "2000127", map3);
                m.a().c(str4, "2000048", map3);
                a(this.U, z, str, map);
                return;
            }
            com.mbridge.msdk.foundation.controller.a.a().a = true;
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA = com.mbridge.msdk.videocommon.a.a.a().a(this.v, 1, this.J, "");
            if (copyOnWriteArrayListA != null && copyOnWriteArrayListA.size() > 0) {
                if (!j()) {
                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListB = b(str, copyOnWriteArrayListA);
                    if (copyOnWriteArrayListB != null && copyOnWriteArrayListB.size() > 0) {
                        a(copyOnWriteArrayListB, str, str4);
                        return;
                    }
                    com.mbridge.msdk.reward.a.a aVar3 = new com.mbridge.msdk.reward.a.a(this.v, this.I);
                    try {
                        try {
                            if (aVar3.a(str)) {
                                r15 = 0;
                                r15 = 0;
                                r15 = 0;
                                r15 = 0;
                                r15 = 0;
                                r15 = 0;
                                com.mbridge.msdk.foundation.b.c cVarA = aVar3.a(str, str4, (CampaignEx) null, new com.mbridge.msdk.foundation.entity.e(21, "cb is open"), 1, this.p);
                                if (cVarA != null && cVarA.a() == com.mbridge.msdk.foundation.b.c.c && cVarA.c() != null && cVarA.c().size() > 0 && this.p != null) {
                                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListC = cVarA.c();
                                    if (copyOnWriteArrayListA != null) {
                                        ArrayList arrayList = new ArrayList();
                                        for (CampaignEx campaignEx2 : copyOnWriteArrayListA) {
                                            if (campaignEx2 != null) {
                                                String requestId = campaignEx2.getRequestId();
                                                if (!TextUtils.isEmpty(requestId)) {
                                                    for (int i = 0; i < copyOnWriteArrayListC.size(); i++) {
                                                        CampaignEx campaignEx3 = copyOnWriteArrayListC.get(i);
                                                        if (campaignEx3 != null) {
                                                            if (requestId.equals(campaignEx3.getRequestId())) {
                                                                break;
                                                            } else if (i == copyOnWriteArrayListC.size() - 1) {
                                                                arrayList.add(campaignEx2);
                                                            }
                                                        }
                                                    }
                                                    if (copyOnWriteArrayListC.size() != 0) {
                                                        break;
                                                    }
                                                    arrayList.add(campaignEx2);
                                                    break;
                                                }
                                            }
                                        }
                                        this.p.a(arrayList);
                                    }
                                    this.p.a(cVarA.c(), false);
                                    objC = cVarA.c();
                                }
                            } else {
                                str5 = null;
                                r15 = 0;
                                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA2 = a(str, copyOnWriteArrayListA);
                                try {
                                    if (copyOnWriteArrayListA2.size() > 0) {
                                        com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).a(str, copyOnWriteArrayListA2);
                                    }
                                    objC = copyOnWriteArrayListA2;
                                } catch (Exception e3) {
                                    e = e3;
                                    objC = copyOnWriteArrayListA2;
                                    e.printStackTrace();
                                    r15 = str5;
                                    objC = objC;
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        str5 = null;
                    }
                    ?? r0 = objC;
                    if (r0 != 0 && r0.size() > 0) {
                        a(r0, str, str4);
                        if (this.p != null && !aVar3.a(str)) {
                            this.p.a(r0);
                        }
                    }
                    this.ad = r15;
                    this.t.a(this.J);
                    a(this.U, z, str, map);
                    return;
                }
                com.mbridge.msdk.videocommon.a.a.a().a(this.v, str);
                if (!z || this.t == null) {
                    return;
                }
                com.mbridge.msdk.foundation.entity.e eVar3 = new com.mbridge.msdk.foundation.entity.e(19, "checkOverCap failed");
                if (map != null) {
                    try {
                        if (map.containsKey(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID)) {
                            objC = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                        }
                    } catch (Exception e6) {
                        obj4 = objC;
                        if (MBridgeConstans.DEBUG) {
                            e6.printStackTrace();
                            obj4 = objC;
                        }
                    }
                }
                com.mbridge.msdk.reward.c.a.a(null, this.n, eVar3, this.v, this.J, "", "");
                obj4 = objC;
                c.d(this.t, "checkOverCap failed", obj4);
                return;
            }
            if (!j()) {
                com.mbridge.msdk.reward.a.a aVar4 = new com.mbridge.msdk.reward.a.a(this.v, this.I);
                try {
                    if (aVar4.a(str)) {
                        aVar = aVar4;
                        obj2 = "cache";
                        str3 = "2000127";
                        try {
                            com.mbridge.msdk.foundation.b.c cVarA2 = aVar4.a(str, str4, (CampaignEx) null, new com.mbridge.msdk.foundation.entity.e(21, "cb is open"), 1, this.p);
                            if (cVarA2 == null || cVarA2.a() != com.mbridge.msdk.foundation.b.c.c || cVarA2.c() == null || cVarA2.c().size() <= 0 || this.p == null) {
                                z2 = false;
                                obj3 = obj2;
                            } else {
                                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListC2 = cVarA2.c();
                                if (copyOnWriteArrayListA != null) {
                                    ArrayList arrayList2 = new ArrayList();
                                    for (CampaignEx campaignEx4 : copyOnWriteArrayListA) {
                                        if (campaignEx4 != null) {
                                            String requestId2 = campaignEx4.getRequestId();
                                            if (!TextUtils.isEmpty(requestId2)) {
                                                for (int i2 = 0; i2 < copyOnWriteArrayListC2.size(); i2++) {
                                                    CampaignEx campaignEx5 = copyOnWriteArrayListC2.get(i2);
                                                    if (campaignEx5 != null) {
                                                        if (requestId2.equals(campaignEx5.getRequestId())) {
                                                            break;
                                                        } else if (i2 == copyOnWriteArrayListC2.size() - 1) {
                                                            arrayList2.add(campaignEx4);
                                                        }
                                                    }
                                                }
                                                if (copyOnWriteArrayListC2.size() != 0) {
                                                    break;
                                                }
                                                arrayList2.add(campaignEx4);
                                                break;
                                            }
                                        }
                                    }
                                    this.p.a(arrayList2);
                                }
                                z2 = false;
                                try {
                                    this.p.a(cVarA2.c(), false);
                                    objC = cVarA2.c();
                                    obj3 = obj2;
                                } catch (Exception e7) {
                                    e = e7;
                                    e.printStackTrace();
                                    obj3 = obj2;
                                }
                            }
                        } catch (Exception e8) {
                            e = e8;
                            z2 = false;
                        }
                    } else {
                        aVar = aVar4;
                        z2 = false;
                        str3 = "2000127";
                        obj3 = "cache";
                    }
                } catch (Exception e9) {
                    e = e9;
                    aVar = aVar4;
                    z2 = false;
                    str3 = "2000127";
                    obj2 = "cache";
                }
                ?? r1 = objC;
                if (r1 != 0 && r1.size() > 0) {
                    a(r1, str, str4);
                    if (this.p != null && !aVar.a(str)) {
                        this.p.a(r1);
                    }
                }
                this.ad = z2;
                this.t.a(this.J);
                map3.put(obj3, "2");
                m.a().c(str4, str3, map3);
                m.a().c(str4, "2000048", map3);
                a(this.U, z, str, map);
                return;
            }
            com.mbridge.msdk.videocommon.a.a.a().a(this.v, str);
            if (!z || this.t == null) {
                return;
            }
            com.mbridge.msdk.foundation.entity.e eVar4 = new com.mbridge.msdk.foundation.entity.e(19, "checkOverCap failed");
            if (map != null) {
                try {
                    if (map.containsKey(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID)) {
                        objC = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                    }
                } catch (Exception e10) {
                    obj = objC;
                    if (MBridgeConstans.DEBUG) {
                        e10.printStackTrace();
                        obj = objC;
                    }
                }
            }
            com.mbridge.msdk.reward.c.a.a(null, this.n, eVar4, this.v, this.J, "", "");
            obj = objC;
            c.d(this.t, "checkOverCap failed", obj);
        }
    }

    private void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, String str, String str2) {
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        HashMap map = new HashMap();
        this.ad = true;
        this.t.a(this.J);
        c.e(this.t, this.A, this.v);
        CampaignEx campaignEx = copyOnWriteArrayList.get(0);
        a(campaignEx.getRequestId(), str);
        com.mbridge.msdk.reward.adapter.c cVar = this.p;
        if (cVar != null && cVar.a(copyOnWriteArrayList, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt())) {
            a(copyOnWriteArrayList);
            this.t.b(this.A, this.v);
        } else {
            a(copyOnWriteArrayList, this.p);
        }
        try {
            m.a().a(str2, this.v, copyOnWriteArrayList.get(0).getAdType() + "");
            map.put("cache", "1");
            m.a().c(str2, "2000127", map);
            m.a().c(str2, "2000048", map);
            if (copyOnWriteArrayList.size() > 1) {
                m.a().b(copyOnWriteArrayList);
            } else {
                m.a().a(copyOnWriteArrayList.get(0));
            }
        } catch (Exception e) {
            aa.d("RewardVideoController", e.getMessage());
        }
    }

    private CopyOnWriteArrayList<CampaignEx> a(String str, List<CampaignEx> list) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (list != null) {
            try {
                if (list.size() > 0) {
                    int vcn = 1;
                    for (CampaignEx campaignEx : list) {
                        if (campaignEx != null) {
                            if (campaignEx.getVcn() > vcn) {
                                vcn = campaignEx.getVcn();
                            }
                            if (campaignEx.getTokenRule() == 1) {
                                String requestId = campaignEx.getRequestId();
                                if (!TextUtils.isEmpty(requestId)) {
                                    if (linkedHashMap.containsKey(requestId)) {
                                        ((List) linkedHashMap.get(requestId)).add(campaignEx);
                                    } else {
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(campaignEx);
                                        linkedHashMap.put(requestId, arrayList);
                                    }
                                }
                            } else {
                                String requestId2 = campaignEx.getRequestId();
                                if (!TextUtils.isEmpty(requestId2)) {
                                    if (linkedHashMap2.containsKey(requestId2)) {
                                        ((List) linkedHashMap2.get(requestId2)).add(campaignEx);
                                    } else {
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add(campaignEx);
                                        linkedHashMap2.put(requestId2, arrayList2);
                                    }
                                }
                            }
                        }
                    }
                    if (linkedHashMap2.size() + linkedHashMap.size() >= vcn && linkedHashMap.size() > 0 && linkedHashMap.entrySet() != null && linkedHashMap.entrySet().iterator() != null && linkedHashMap.entrySet().iterator().next() != null && ((Map.Entry) linkedHashMap.entrySet().iterator().next()).getValue() != null) {
                        copyOnWriteArrayList.addAll((Collection) ((Map.Entry) linkedHashMap.entrySet().iterator().next()).getValue());
                        com.mbridge.msdk.foundation.same.a.d.a(this.v, str, vcn);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return copyOnWriteArrayList;
    }

    private CopyOnWriteArrayList<CampaignEx> b(String str, List<CampaignEx> list) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            for (CampaignEx campaignEx : list) {
                if (campaignEx != null && str.equals(campaignEx.getBidToken())) {
                    copyOnWriteArrayList.add(campaignEx);
                }
            }
        }
        return copyOnWriteArrayList;
    }

    private void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.reward.adapter.c cVar) {
        final CampaignEx campaignEx = copyOnWriteArrayList.get(0);
        final boolean z = !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl());
        final int nscpt = campaignEx.getNscpt();
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        com.mbridge.msdk.reward.adapter.b.a().a(this.n, z, nscpt, this.J, this.I ? 287 : 94, this.A, this.v, campaignEx.getRequestId(), copyOnWriteArrayList, new AnonymousClass4(z, campaignEx, cVar, nscpt), new com.mbridge.msdk.reward.adapter.b.i() { // from class: com.mbridge.msdk.reward.b.a.5
            @Override // com.mbridge.msdk.reward.adapter.b.i
            public final void a(String str, String str2, String str3, String str4) {
            }

            @Override // com.mbridge.msdk.reward.adapter.b.i
            public final void a(String str, String str2, String str3, String str4, com.mbridge.msdk.foundation.entity.e eVar) {
                a aVar = a.this;
                a.a(aVar, str2, aVar.af);
                if (!z && a.this.t != null) {
                    if (a.this.l) {
                        return;
                    }
                    a.this.l = true;
                    if (a.this.ae != null && a.this.ae.size() > 0) {
                        eVar.b("errorCode: 3202 errorMessage: temp resource download failed");
                        com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar, a.this.v, a.this.J, str3, campaignEx.getRequestIdNotice());
                    }
                    c.b(a.this.t, eVar.d());
                    return;
                }
                if (nscpt != 1 || a.this.l || a.this.t == null) {
                    return;
                }
                a.this.l = true;
                if (a.this.ae != null && a.this.ae.size() > 0) {
                    eVar.b("errorCode: 3202 errorMessage: temp resource download failed");
                    com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar, a.this.v, a.this.J, str3, campaignEx.getRequestIdNotice());
                }
                c.b(a.this.t, eVar.d());
            }
        });
        if (z) {
            com.mbridge.msdk.reward.adapter.b.a().a(this.n, campaignEx, this.A, this.v, campaignEx.getRequestId(), new AnonymousClass6(campaignEx, copyOnWriteArrayList, cVar, z, nscpt));
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.reward.b.a$4, reason: invalid class name */
    /* JADX INFO: compiled from: RewardVideoController.java */
    final class AnonymousClass4 implements com.mbridge.msdk.reward.adapter.b.c {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f2394b;
        final /* synthetic */ com.mbridge.msdk.reward.adapter.c c;
        final /* synthetic */ int d;

        AnonymousClass4(boolean z, CampaignEx campaignEx, com.mbridge.msdk.reward.adapter.c cVar, int i) {
            this.a = z;
            this.f2394b = campaignEx;
            this.c = cVar;
            this.d = i;
        }

        @Override // com.mbridge.msdk.reward.adapter.b.c
        public final void a(final String str, final String str2, final String str3, final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            a.this.i = true;
            if (!this.a) {
                for (final CampaignEx campaignEx : copyOnWriteArrayList) {
                    if (campaignEx != null && campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e()) && !campaignEx.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY) && a.this.D != null) {
                        a.this.D.post(new Runnable() { // from class: com.mbridge.msdk.reward.b.a.4.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                com.mbridge.msdk.reward.adapter.b.a().a(a.this.N, a.this.D, a.this.I, a.this.J, null, campaignEx.getRewardTemplateMode().e(), a.this.E, AnonymousClass4.this.f2394b, copyOnWriteArrayList, g.a().b(campaignEx.getRewardTemplateMode().e()), str, str2, str3, campaignEx.getRequestIdNotice(), a.this.q, new com.mbridge.msdk.reward.adapter.b.j() { // from class: com.mbridge.msdk.reward.b.a.4.1.1
                                    @Override // com.mbridge.msdk.reward.adapter.b.j
                                    public final void a(String str4, String str5, String str6, String str7, String str8, com.mbridge.msdk.videocommon.a.C0524a c0524a) {
                                        if (AnonymousClass4.this.c == null || !AnonymousClass4.this.c.a(copyOnWriteArrayList, AnonymousClass4.this.a, AnonymousClass4.this.d)) {
                                            a.a(a.this, str6, a.this.af);
                                            if (a.this.t == null || a.this.l) {
                                                return;
                                            }
                                            a.this.l = true;
                                            com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(15, "errorCode: 3502 errorMessage: temp preload success but isReady false");
                                            if (a.this.ae != null && a.this.ae.size() > 0) {
                                                com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar, a.this.v, a.this.J, str7, campaignEx.getRequestIdNotice());
                                            }
                                            c.b(a.this.t, eVar.d());
                                            return;
                                        }
                                        if (a.this.t == null || a.this.m) {
                                            return;
                                        }
                                        a.this.m = true;
                                        a.this.a(copyOnWriteArrayList);
                                        a.this.t.b(str5, str6);
                                    }

                                    @Override // com.mbridge.msdk.reward.adapter.b.j
                                    public final void a(String str4, String str5, String str6, String str7, String str8, com.mbridge.msdk.videocommon.a.C0524a c0524a, com.mbridge.msdk.foundation.entity.e eVar) {
                                        a.a(a.this, str6, a.this.af);
                                        if (a.this.t == null || a.this.l) {
                                            return;
                                        }
                                        a.this.l = true;
                                        if (a.this.ae != null && a.this.ae.size() > 0) {
                                            eVar.b("errorCode: 3301 errorMessage: temp preload failed: " + eVar.d());
                                            com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar, a.this.v, a.this.J, str7, campaignEx.getRequestIdNotice());
                                        }
                                        c.b(a.this.t, eVar.d());
                                    }
                                });
                            }
                        });
                    } else {
                        com.mbridge.msdk.reward.adapter.c cVar = this.c;
                        if (cVar != null && cVar.a(copyOnWriteArrayList, this.a, this.d)) {
                            if (a.this.t != null && !a.this.m) {
                                a.this.m = true;
                                aa.a("RewardVideoController", "Cache onVideoLoadSuccessForCache");
                                a.this.a(copyOnWriteArrayList);
                                a.this.t.b(str, str2);
                            }
                        } else {
                            a aVar = a.this;
                            a.a(aVar, str2, aVar.af);
                            if (a.this.t != null && !a.this.l) {
                                a.this.l = true;
                                aa.a("RewardVideoController", "Cache onVideoLoadFailForCache");
                                com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(15, "errorCode: 3503 errorMessage: have no temp but isReady false");
                                if (a.this.ae != null && a.this.ae.size() > 0) {
                                    com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar, a.this.v, a.this.J, str3, campaignEx.getRequestIdNotice());
                                }
                                c.b(a.this.t, eVar.d());
                            }
                        }
                    }
                }
                return;
            }
            if (!a.this.j || a.this.k || a.this.D == null) {
                return;
            }
            a.this.k = true;
            a.this.D.post(new Runnable() { // from class: com.mbridge.msdk.reward.b.a.4.2
                @Override // java.lang.Runnable
                public final void run() {
                    com.mbridge.msdk.reward.adapter.b.a().a(a.this.N, a.this.D, a.this.I, a.this.J, str3, AnonymousClass4.this.f2394b.getRequestIdNotice(), str, str2, AnonymousClass4.this.f2394b.getCMPTEntryUrl(), a.this.E, AnonymousClass4.this.f2394b, copyOnWriteArrayList, g.a().b(AnonymousClass4.this.f2394b.getCMPTEntryUrl()), str2, a.this.q, new com.mbridge.msdk.reward.adapter.b.j() { // from class: com.mbridge.msdk.reward.b.a.4.2.1
                        @Override // com.mbridge.msdk.reward.adapter.b.j
                        public final void a(String str4, String str5, String str6, String str7, String str8, com.mbridge.msdk.videocommon.a.C0524a c0524a) {
                            if (AnonymousClass4.this.c == null || !AnonymousClass4.this.c.a(copyOnWriteArrayList, AnonymousClass4.this.a, AnonymousClass4.this.d)) {
                                a.a(a.this, str6, a.this.af);
                                if (a.this.t == null || a.this.l) {
                                    return;
                                }
                                a.this.l = true;
                                com.mbridge.msdk.foundation.entity.e eVar2 = new com.mbridge.msdk.foundation.entity.e(15, "errorCode: 3504 errorMessage: tpl temp preload success but isReady false");
                                if (a.this.ae != null && a.this.ae.size() > 0) {
                                    com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar2, a.this.v, a.this.J, str7, AnonymousClass4.this.f2394b.getRequestIdNotice());
                                }
                                c.b(a.this.t, eVar2.d());
                                return;
                            }
                            if (a.this.t == null || a.this.m) {
                                return;
                            }
                            a.this.m = true;
                            aa.a("RewardVideoController", "Cache onVideoLoadSuccessForCache");
                            a.this.a(copyOnWriteArrayList);
                            a.this.t.b(str5, str6);
                        }

                        @Override // com.mbridge.msdk.reward.adapter.b.j
                        public final void a(String str4, String str5, String str6, String str7, String str8, com.mbridge.msdk.videocommon.a.C0524a c0524a, com.mbridge.msdk.foundation.entity.e eVar2) {
                            a.a(a.this, str6, a.this.af);
                            if (a.this.t == null || a.this.l) {
                                return;
                            }
                            a.this.l = true;
                            if (a.this.ae != null && a.this.ae.size() > 0) {
                                eVar2.b("errorCode: 3302 errorMessage: tpl temp preload failed: " + eVar2.d());
                                com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar2, a.this.v, a.this.J, str7, AnonymousClass4.this.f2394b.getRequestIdNotice());
                            }
                            c.b(a.this.t, eVar2.d());
                        }
                    }, true);
                }
            });
        }

        @Override // com.mbridge.msdk.reward.adapter.b.c
        public final void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.foundation.entity.e eVar) {
            a.this.i = false;
            a aVar = a.this;
            a.a(aVar, str2, aVar.af);
            if (a.this.t == null || a.this.l) {
                return;
            }
            a.this.l = true;
            if (a.this.ae != null && a.this.ae.size() > 0) {
                eVar.b("errorCode: 3201 errorMessage: campaign resource download failed");
                com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar, a.this.v, a.this.J, str3, this.f2394b.getRequestIdNotice());
            }
            c.b(a.this.t, eVar.d());
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.reward.b.a$6, reason: invalid class name */
    /* JADX INFO: compiled from: RewardVideoController.java */
    final class AnonymousClass6 implements com.mbridge.msdk.reward.adapter.b.i {
        final /* synthetic */ CampaignEx a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CopyOnWriteArrayList f2398b;
        final /* synthetic */ com.mbridge.msdk.reward.adapter.c c;
        final /* synthetic */ boolean d;
        final /* synthetic */ int e;

        AnonymousClass6(CampaignEx campaignEx, CopyOnWriteArrayList copyOnWriteArrayList, com.mbridge.msdk.reward.adapter.c cVar, boolean z, int i) {
            this.a = campaignEx;
            this.f2398b = copyOnWriteArrayList;
            this.c = cVar;
            this.d = z;
            this.e = i;
        }

        @Override // com.mbridge.msdk.reward.adapter.b.i
        public final void a(final String str, final String str2, final String str3, String str4) {
            a.this.j = true;
            if (!a.this.i || a.this.k || a.this.D == null) {
                return;
            }
            a.this.k = true;
            a.this.D.post(new Runnable() { // from class: com.mbridge.msdk.reward.b.a.6.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.mbridge.msdk.reward.adapter.b.a().a(a.this.N, a.this.D, a.this.I, a.this.J, str3, AnonymousClass6.this.a.getRequestIdNotice(), str, str2, AnonymousClass6.this.a.getCMPTEntryUrl(), a.this.E, AnonymousClass6.this.a, AnonymousClass6.this.f2398b, g.a().b(AnonymousClass6.this.a.getCMPTEntryUrl()), str2, a.this.q, new com.mbridge.msdk.reward.adapter.b.j() { // from class: com.mbridge.msdk.reward.b.a.6.1.1
                        @Override // com.mbridge.msdk.reward.adapter.b.j
                        public final void a(String str5, String str6, String str7, String str8, String str9, com.mbridge.msdk.videocommon.a.C0524a c0524a) {
                            if (AnonymousClass6.this.c == null || !AnonymousClass6.this.c.a(AnonymousClass6.this.f2398b, AnonymousClass6.this.d, AnonymousClass6.this.e)) {
                                a.a(a.this, str7, a.this.af);
                                if (a.this.t == null || a.this.l) {
                                    return;
                                }
                                a.this.l = true;
                                com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(15, "errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                                if (a.this.ae != null && a.this.ae.size() > 0) {
                                    com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar, a.this.v, a.this.J, str8, AnonymousClass6.this.a.getRequestIdNotice());
                                }
                                c.b(a.this.t, eVar.d());
                                return;
                            }
                            if (a.this.t == null || a.this.m) {
                                return;
                            }
                            a.this.m = true;
                            aa.a("RewardVideoController", "Cache onVideoLoadSuccess");
                            a.this.a(AnonymousClass6.this.f2398b);
                            a.this.t.b(str6, str7);
                        }

                        @Override // com.mbridge.msdk.reward.adapter.b.j
                        public final void a(String str5, String str6, String str7, String str8, String str9, com.mbridge.msdk.videocommon.a.C0524a c0524a, com.mbridge.msdk.foundation.entity.e eVar) {
                            a.a(a.this, str7, a.this.af);
                            if (a.this.t == null || a.this.l) {
                                return;
                            }
                            a.this.l = true;
                            if (a.this.ae != null && a.this.ae.size() > 0) {
                                eVar.b("errorCode: 3303 errorMessage: tpl temp preload failed: " + eVar.d());
                                com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar, a.this.v, a.this.J, str8, AnonymousClass6.this.a.getRequestIdNotice());
                            }
                            c.b(a.this.t, eVar.d());
                        }
                    }, true);
                }
            });
        }

        @Override // com.mbridge.msdk.reward.adapter.b.i
        public final void a(String str, String str2, String str3, String str4, com.mbridge.msdk.foundation.entity.e eVar) {
            a aVar = a.this;
            a.a(aVar, str2, aVar.af);
            a.this.j = false;
            if (a.this.t == null || a.this.l) {
                return;
            }
            a.this.l = true;
            if (a.this.ae != null && a.this.ae.size() > 0) {
                eVar.b("errorCode: 3203 errorMessage: tpl temp resource download failed");
                com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar, a.this.v, a.this.J, str3, this.a.getRequestIdNotice());
            }
            c.b(a.this.t, eVar.d());
        }
    }

    private boolean c(String str, String str2) {
        try {
            com.mbridge.msdk.reward.adapter.c cVar = this.p;
            if (cVar == null || !str.equals(cVar.a())) {
                com.mbridge.msdk.reward.adapter.c cVar2 = new com.mbridge.msdk.reward.adapter.c(this.n, this.A, str);
                this.p = cVar2;
                cVar2.b(this.I);
                this.p.c(this.J);
            }
            this.p.a(this.E);
            this.p.a(this.q);
        } catch (Exception unused) {
        }
        List<CampaignEx> listA = com.mbridge.msdk.videocommon.a.a.a().a(str, 1, this.J);
        this.af = com.mbridge.msdk.videocommon.a.a.a().b(str, 1, this.J);
        if (listA != null && listA.size() > 0) {
            com.mbridge.msdk.videocommon.a.a.a().a(str, listA, str2);
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.ae;
            if (copyOnWriteArrayList == null) {
                this.ae = new CopyOnWriteArrayList<>();
            } else {
                copyOnWriteArrayList.clear();
            }
            for (CampaignEx campaignEx : listA) {
                campaignEx.setLocalRequestId(str2);
                this.ae.add(campaignEx);
            }
            a(this.ae);
            return true;
        }
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.ae;
        if (copyOnWriteArrayList2 == null) {
            return false;
        }
        copyOnWriteArrayList2.clear();
        return false;
    }

    /* JADX INFO: compiled from: RewardVideoController.java */
    private final class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WeakReference<InterVideoOutListener> f2403b;
        private volatile AtomicInteger c;
        private Handler d;
        private String e;
        private boolean f;

        private c(InterVideoOutListener interVideoOutListener, Handler handler, String str) {
            this.f2403b = new WeakReference<>(interVideoOutListener);
            this.c = new AtomicInteger(0);
            this.d = handler;
            this.e = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, String str2) {
            Handler handler = this.d;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            if (this.f2403b == null || this.c.get() == 2 || this.d == null) {
                return;
            }
            this.c.set(2);
            if (a.this.aa) {
                return;
            }
            a.this.aa = true;
            if (this.f2403b.get() == null) {
                if (a.this.M && ac.a().a("r_l_b_m_t_r_i", true)) {
                    m.a().a("2000048", a.this.w.getLocalRequestId(), a.this.R, a.this.v, "");
                    return;
                }
                return;
            }
            Message messageObtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
            messageObtain.setData(bundle);
            messageObtain.obj = str2;
            messageObtain.what = 9;
            this.d.sendMessage(messageObtain);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str, String str2) {
            Handler handler = this.d;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            if (this.f2403b == null || this.c.get() == 2 || this.d == null) {
                return;
            }
            if (this.c.get() == 1) {
                this.c.set(3);
            }
            if (a.this.aa) {
                return;
            }
            a.this.aa = true;
            if (this.f2403b.get() == null) {
                if (a.this.M && ac.a().a("r_l_b_m_t_r_i", true)) {
                    m.a().a("2000048", a.this.w.getLocalRequestId(), a.this.R, a.this.v, "");
                }
            } else {
                Message messageObtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                messageObtain.setData(bundle);
                messageObtain.obj = str2;
                messageObtain.what = 9;
                this.d.sendMessage(messageObtain);
            }
            if (a.this.ab) {
                this.c.set(2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(String str, String str2) {
            if (this.d != null) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = str;
                messageObtain.what = 18;
                if (!TextUtils.isEmpty(str2)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("local_id", str2);
                    messageObtain.setData(bundle);
                }
                this.d.sendMessage(messageObtain);
            }
        }

        public final void a(boolean z) {
            this.f = z;
        }

        static /* synthetic */ void a(c cVar, String str) {
            if (a.this.p != null) {
                a.this.p.a(a.this.a);
                if (a.this.p.a((a.this.R == null || a.this.R.size() == 0) ? null : (CampaignEx) a.this.R.get(0), true, m.a().a(cVar.e, str), 2)) {
                    return;
                } else {
                    a.this.p.a((com.mbridge.msdk.reward.adapter.a) null);
                }
            }
            Handler handler = cVar.d;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            if (cVar.f2403b == null || cVar.c.get() == 2 || cVar.d == null) {
                return;
            }
            a.this.ab = true;
            if (!a.this.ad || str.contains("resource load timeout")) {
                a.this.ac = true;
            }
            if (a.this.aa) {
                cVar.c.set(2);
            }
            if (a.this.ab && a.this.ac && !a.this.aa) {
                cVar.c.set(2);
                if (cVar.f2403b.get() == null) {
                    if (a.this.M && ac.a().a("r_l_b_m_t_r_i", true)) {
                        m.a().a("2000047", a.this.x, a.this.R, a.this.v, str);
                        return;
                    }
                    return;
                }
                Message messageObtain = Message.obtain();
                messageObtain.obj = str;
                messageObtain.what = 16;
                cVar.d.sendMessage(messageObtain);
            }
        }

        static /* synthetic */ int a(c cVar) {
            return cVar.c.get();
        }

        static /* synthetic */ void a(c cVar, int i) {
            cVar.c.set(i);
        }

        static /* synthetic */ void d(c cVar, String str, String str2) {
            cVar.c.set(2);
            cVar.c(str, str2);
        }

        static /* synthetic */ void e(c cVar, String str, String str2) {
            WeakReference<InterVideoOutListener> weakReference = cVar.f2403b;
            if (weakReference == null || weakReference.get() == null || cVar.d == null || a.this.Z) {
                return;
            }
            a.this.Z = true;
            Message messageObtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
            bundle.putBoolean(MBridgeConstans.PROPERTIES_IS_CACHED_CAMPAIGN, true);
            messageObtain.setData(bundle);
            messageObtain.obj = str2;
            messageObtain.what = 17;
            cVar.d.sendMessage(messageObtain);
            if (ac.a().a("l_s_i_l_v_s", false)) {
                cVar.b(str, str2);
            }
        }

        static /* synthetic */ void b(c cVar, String str) {
            if (cVar.f2403b == null || cVar.c.get() == 2 || cVar.d == null) {
                return;
            }
            a.this.ac = true;
            if (str.contains("resource load timeout")) {
                a.this.ab = true;
            }
            if (a.this.ac && a.this.ab && !a.this.aa) {
                cVar.c.set(2);
                Message messageObtain = Message.obtain();
                if (cVar.f2403b.get() == null) {
                    if (a.this.M && ac.a().a("r_l_b_m_t_r_i", true)) {
                        m.a().a("2000047", a.this.x, a.this.R, a.this.v, str);
                        return;
                    }
                    return;
                }
                messageObtain.obj = str;
                messageObtain.what = 16;
                cVar.d.sendMessage(messageObtain);
            }
        }

        static /* synthetic */ void f(c cVar, String str, String str2) {
            WeakReference<InterVideoOutListener> weakReference = cVar.f2403b;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((cVar.c.get() != 1 && cVar.c.get() != 3) || cVar.d == null || a.this.Z) {
                return;
            }
            a.this.Z = true;
            Message messageObtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
            bundle.putBoolean(MBridgeConstans.PROPERTIES_IS_CACHED_CAMPAIGN, false);
            messageObtain.setData(bundle);
            messageObtain.obj = str2;
            messageObtain.what = 17;
            cVar.d.sendMessage(messageObtain);
            if (ac.a().a("l_s_i_l_v_s", false)) {
                cVar.a(str, str2);
            }
        }
    }

    private void e() {
        try {
            List<com.mbridge.msdk.videocommon.b.b> listY = this.q.y();
            if (listY == null || listY.size() <= 0) {
                return;
            }
            for (int i = 0; i < listY.size(); i++) {
                ai.a(this.n, this.A + "_" + listY.get(i).a(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean f() {
        try {
            List<com.mbridge.msdk.videocommon.b.b> listY = this.q.y();
            if (this.r == null) {
                this.r = com.mbridge.msdk.videocommon.d.b.a().b();
            }
            Map<String, Integer> mapJ = this.r.j();
            if (listY == null || listY.size() <= 0) {
                return true;
            }
            for (int i = 0; i < listY.size(); i++) {
                com.mbridge.msdk.videocommon.b.b bVar = listY.get(i);
                int iIntValue = mapJ.containsKey(new StringBuilder().append(bVar.a()).append("").toString()) ? mapJ.get(bVar.a() + "").intValue() : 0;
                Object objB = ai.b(this.n, this.A + "_" + bVar.a(), 0);
                if ((objB != null ? ((Integer) objB).intValue() : 0) < iIntValue) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            aa.d("RewardVideoController", e.getMessage());
            return true;
        }
    }

    private void a(Queue<Integer> queue, boolean z, String str, Map<String, String> map) {
        int iIntValue = 25;
        if (queue != null) {
            try {
                if (queue.size() > 0) {
                    iIntValue = queue.poll().intValue();
                }
            } catch (Exception e) {
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.ae;
                if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                    com.mbridge.msdk.reward.c.a.a(this.ae.get(0), this.n, new com.mbridge.msdk.foundation.entity.e(0, "can't show because unknow error"), this.v, this.J, "", "");
                }
                b("can't show because unknow error");
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        int i = iIntValue;
        this.w.setLocalRequestId(map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID));
        try {
            a(1, i, z, str, map);
        } catch (Exception e2) {
            if (this.ae != null && this.ae.size() > 0) {
                com.mbridge.msdk.reward.c.a.a(this.ae.get(0), this.n, new com.mbridge.msdk.foundation.entity.e(0, "load mv api error:" + e2.getMessage()), this.v, this.J, "", "");
            }
            b("load mv api error:" + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (this.t != null) {
            this.ac = true;
            c.a(this.t, str);
        }
    }

    private void a(int i, int i2, boolean z, String str, Map<String, String> map) {
        try {
            com.mbridge.msdk.reward.adapter.c cVar = this.p;
            if (cVar == null || !this.v.equals(cVar.a())) {
                com.mbridge.msdk.reward.adapter.c cVar2 = new com.mbridge.msdk.reward.adapter.c(this.n, this.A, this.v);
                this.p = cVar2;
                cVar2.b(this.I);
                this.p.c(this.J);
            }
            if (this.I) {
                this.p.a(this.F, this.G, this.H);
            }
            this.p.a(this.E);
            this.p.a(this.q);
            RunnableC0508a runnableC0508a = new RunnableC0508a(this.p, i, z);
            runnableC0508a.a(map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID));
            runnableC0508a.a(i2);
            b bVar = new b(this.p, z);
            this.a = bVar;
            bVar.a(runnableC0508a);
            this.p.a(this.a);
            this.w.setLocalRequestId(map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID));
            this.y = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
            this.p.a(i, i2, z, str, this.N, map);
            this.D.postDelayed(runnableC0508a, i2 * 1000);
        } catch (Exception e) {
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.ae;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                com.mbridge.msdk.reward.c.a.a(this.ae.get(0), this.n, new com.mbridge.msdk.foundation.entity.e(0, e.getMessage()), this.v, this.J, "", "");
            }
            b(e.getMessage());
        }
    }

    private void c(String str) {
        com.mbridge.msdk.videocommon.d.c cVar;
        com.mbridge.msdk.videocommon.d.c cVar2;
        boolean zB;
        boolean zC;
        Map<String, Integer> mapJ;
        try {
            com.mbridge.msdk.videocommon.d.a aVar = this.r;
            int iIntValue = (aVar == null || (mapJ = aVar.j()) == null || !mapJ.containsKey("1")) ? 0 : mapJ.get("1").intValue();
            if (ai.b(this.n, this.A + "_1", 0) != null) {
                this.o = ((Integer) ai.b(this.n, this.A + "_1", 0)).intValue();
            }
            if (this.p == null) {
                i();
            }
            if (this.p != null) {
                aa.d("RewardVideoController", "controller 819");
                if (this.J) {
                    zB = g();
                } else {
                    zB = this.p.b();
                }
                if (zB) {
                    if (this.o >= iIntValue && iIntValue > 0) {
                        this.e = false;
                        return;
                    }
                    aa.b("RewardVideoController", "invoke adapter show isReady");
                    d dVar = new d(this, 1, this.D);
                    h.put(this.v, dVar);
                    this.p.a(dVar, str, this.u, this.E, this.z);
                    this.e = false;
                    return;
                }
                if (this.J) {
                    zC = h();
                } else {
                    zC = this.p.c();
                }
                if (zC) {
                    aa.b("RewardVideoController", "invoke adapter show isSpareOfferReady");
                    d dVar2 = new d(this, 1, this.D);
                    h.put(this.v, dVar2);
                    this.p.a(dVar2, str, this.u, this.E, this.z);
                    this.e = false;
                    return;
                }
            }
            if (this.o != 0) {
                ai.a(this.n, this.A + "_1", 0);
                c(str);
                return;
            }
            this.e = false;
            if (this.s != null) {
                try {
                    this.s.onShowFail(f2393b, this.w, "can't show because load is failed");
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            if (this.I || this.J || (cVar2 = this.q) == null || !cVar2.s(4) || this.t == null || c.a(this.t) == 1 || c.a(this.t) == 3) {
                return;
            }
            HashMap map = new HashMap();
            try {
                String md5 = SameMD5.getMD5(af.c());
                map.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, md5);
                com.mbridge.msdk.reward.c.a.a("2000123", this.v, md5, "auto_load", 94, false);
            } catch (Exception unused) {
            }
            a(false, (Map<String, String>) map);
        } catch (Exception e2) {
            this.e = false;
            if (MBridgeConstans.DEBUG) {
                aa.d("RewardVideoController", e2.getLocalizedMessage());
            }
            if (this.s != null) {
                try {
                    this.s.onShowFail(f2393b, this.w, "show exception");
                } catch (Exception unused2) {
                    if (MBridgeConstans.DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
            if (this.I || this.J || (cVar = this.q) == null || !cVar.s(4) || this.t == null || c.a(this.t) == 1 || c.a(this.t) == 3) {
                return;
            }
            HashMap map2 = new HashMap();
            try {
                String md6 = SameMD5.getMD5(af.c());
                map2.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, md6);
                com.mbridge.msdk.reward.c.a.a("2000123", this.v, md6, "auto_load", 94, false);
            } catch (Exception unused3) {
            }
            a(false, (Map<String, String>) map2);
        }
    }

    public final boolean d(boolean z) {
        try {
            if (j()) {
                return false;
            }
            if (this.J) {
                try {
                    return g();
                } catch (Exception unused) {
                    return false;
                }
            }
            if (this.p == null) {
                i();
            }
            com.mbridge.msdk.reward.adapter.c cVar = this.p;
            if (cVar == null) {
                return false;
            }
            boolean zB = cVar.b();
            return !zB ? this.p.c() : zB;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private boolean g() {
        if (this.p == null) {
            i();
        }
        List<com.mbridge.msdk.foundation.entity.b> listA = com.mbridge.msdk.videocommon.a.a.a().a(this.v);
        if (listA == null || listA.size() <= 0) {
            return false;
        }
        String strC = com.mbridge.msdk.foundation.same.a.d.c(this.v);
        boolean zA = TextUtils.isEmpty(strC) ? false : a(listA, strC);
        if (zA) {
            return zA;
        }
        for (com.mbridge.msdk.foundation.entity.b bVar : listA) {
            if (bVar != null) {
                this.p.a(bVar.b());
                this.p.c = bVar.f();
                if (this.p.b()) {
                    return true;
                }
            }
        }
        return zA;
    }

    private boolean a(List<com.mbridge.msdk.foundation.entity.b> list, String str) {
        if (list == null) {
            return false;
        }
        for (com.mbridge.msdk.foundation.entity.b bVar : list) {
            if (bVar != null && str.equals(bVar.a())) {
                this.p.a(bVar.b());
                this.p.c = bVar.f();
                if (this.p.b()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean h() {
        if (this.p == null) {
            i();
        }
        List<com.mbridge.msdk.foundation.entity.b> listA = com.mbridge.msdk.videocommon.a.a.a().a(this.v);
        if (listA == null || listA.size() <= 0) {
            return false;
        }
        for (com.mbridge.msdk.foundation.entity.b bVar : listA) {
            if (bVar != null) {
                this.p.a(bVar.b());
                this.p.c = bVar.f();
                if (this.p.c()) {
                    return true;
                }
                com.mbridge.msdk.videocommon.a.a.a().c(this.v, bVar.b());
            }
        }
        return false;
    }

    private void i() {
        com.mbridge.msdk.reward.adapter.c cVar = new com.mbridge.msdk.reward.adapter.c(this.n, this.A, this.v);
        this.p = cVar;
        cVar.b(this.I);
        this.p.c(this.J);
        if (this.I) {
            this.p.a(this.F, this.G, this.H);
        }
        this.p.a(this.q);
    }

    /* JADX WARN: Code duplicated, block: B:160:0x0258  */
    /* JADX WARN: Code duplicated, block: B:207:0x0265 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final void a(String str, String str2, String str3) {
        com.mbridge.msdk.videocommon.d.c cVar;
        com.mbridge.msdk.videocommon.d.c cVar2;
        com.mbridge.msdk.videocommon.d.c cVar3;
        com.mbridge.msdk.videocommon.d.c cVar4;
        com.mbridge.msdk.videocommon.d.c cVar5;
        try {
            this.B = str;
            this.u = str2;
            this.z = str3;
            MBridgeIds mBridgeIds = this.w;
            if (mBridgeIds != null) {
                f2393b = mBridgeIds.getLocalRequestId();
            }
            synchronized (this.Q) {
                if (this.e) {
                    if (this.s != null) {
                        try {
                            this.s.onShowFail(f2393b, this.w, "campaing is show progressing ");
                        } catch (Exception e) {
                            if (MBridgeConstans.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                    return;
                }
                this.e = true;
                if (this.t != null && this.t.c.get() == 1) {
                    if (this.s != null) {
                        try {
                            this.s.onShowFail(f2393b, this.w, "campaing is loading");
                        } catch (Exception e2) {
                            if (MBridgeConstans.DEBUG) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    if (!this.I && !this.J && (cVar5 = this.q) != null && cVar5.s(4) && this.t != null && c.a(this.t) != 1 && c.a(this.t) != 3) {
                        HashMap map = new HashMap();
                        try {
                            String md5 = SameMD5.getMD5(af.c());
                            map.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, md5);
                            com.mbridge.msdk.reward.c.a.a("2000123", this.v, md5, "auto_load", 94, false);
                        } catch (Exception unused) {
                        }
                        a(false, (Map<String, String>) map);
                    }
                    this.e = false;
                    return;
                }
                Context context = this.n;
                if (context == null) {
                    if (this.s != null) {
                        try {
                            this.s.onShowFail(f2393b, this.w, "context is null");
                        } catch (Exception e3) {
                            if (MBridgeConstans.DEBUG) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    if (!this.I && !this.J && (cVar4 = this.q) != null && cVar4.s(4) && this.t != null && c.a(this.t) != 1 && c.a(this.t) != 3) {
                        HashMap map2 = new HashMap();
                        try {
                            String md6 = SameMD5.getMD5(af.c());
                            map2.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, md6);
                            com.mbridge.msdk.reward.c.a.a("2000123", this.v, md6, "auto_load", 94, false);
                        } catch (Exception unused2) {
                        }
                        a(false, (Map<String, String>) map2);
                    }
                    this.e = false;
                    return;
                }
                if (this.I && !af.c(context)) {
                    if (this.s != null) {
                        try {
                            this.s.onShowFail(f2393b, this.w, "network exception");
                        } catch (Exception e4) {
                            if (MBridgeConstans.DEBUG) {
                                e4.printStackTrace();
                            }
                        }
                    }
                    if (!this.I && !this.J && (cVar3 = this.q) != null && cVar3.s(4) && this.t != null && c.a(this.t) != 1 && c.a(this.t) != 3) {
                        HashMap map3 = new HashMap();
                        try {
                            String md7 = SameMD5.getMD5(af.c());
                            map3.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, md7);
                            com.mbridge.msdk.reward.c.a.a("2000123", this.v, md7, "auto_load", 94, false);
                        } catch (Exception unused3) {
                        }
                        a(false, (Map<String, String>) map3);
                    }
                    this.e = false;
                    return;
                }
                if (j()) {
                    if (this.s != null) {
                        try {
                            this.s.onShowFail(f2393b, this.w, "Play more than limit");
                        } catch (Exception e5) {
                            if (MBridgeConstans.DEBUG) {
                                e5.printStackTrace();
                            }
                        }
                    }
                    if (!this.I && !this.J && (cVar2 = this.q) != null && cVar2.s(4) && this.t != null && c.a(this.t) != 1 && c.a(this.t) != 3) {
                        HashMap map4 = new HashMap();
                        try {
                            String md8 = SameMD5.getMD5(af.c());
                            map4.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, md8);
                            com.mbridge.msdk.reward.c.a.a("2000123", this.v, md8, "auto_load", 94, false);
                        } catch (Exception unused4) {
                        }
                        a(false, (Map<String, String>) map4);
                    }
                    this.e = false;
                    return;
                }
                if (TextUtils.isEmpty(this.u)) {
                    this.u = w.a();
                }
                try {
                    String str4 = new SimpleDateFormat("dd").format(new Date());
                    String str5 = (String) ai.b(this.n, "reward_date", "0");
                    if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str4) && !str5.equals(str4)) {
                        ai.a(this.n, "reward_date", str4);
                        ai.a(this.n, this.A + "_1", 0);
                    }
                } catch (Exception unused5) {
                }
                c(str);
                return;
                this.e = false;
                if (MBridgeConstans.DEBUG) {
                    aa.d("RewardVideoController", e.getLocalizedMessage());
                }
                if (this.s != null) {
                    try {
                        this.s.onShowFail(f2393b, this.w, "show exception");
                    } catch (Exception unused6) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
                if (!this.I || this.J || (cVar = this.q) == null || !cVar.s(4) || this.t == null || c.a(this.t) == 1 || c.a(this.t) == 3) {
                    return;
                }
                HashMap map5 = new HashMap();
                try {
                    String md9 = SameMD5.getMD5(af.c());
                    map5.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, md9);
                    com.mbridge.msdk.reward.c.a.a("2000123", this.v, md9, "auto_load", 94, false);
                } catch (Exception unused7) {
                }
                a(false, (Map<String, String>) map5);
            }
        } catch (Exception e6) {
            this.e = false;
            if (MBridgeConstans.DEBUG) {
                aa.d("RewardVideoController", e6.getLocalizedMessage());
            }
            if (this.s != null) {
                this.s.onShowFail(f2393b, this.w, "show exception");
            }
            if (this.I) {
            }
        }
    }

    private boolean j() {
        try {
            if (this.W == null) {
                this.W = h.a(com.mbridge.msdk.foundation.controller.b.d().g());
            }
            i iVarA = i.a(this.W);
            if (this.q == null) {
                this.q = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), this.v, this.I);
            }
            return iVarA != null && iVarA.a(this.v, this.q.d());
        } catch (Throwable unused) {
            aa.d("RewardVideoController", "cap check error");
            return false;
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.reward.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RewardVideoController.java */
    public class RunnableC0508a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.reward.adapter.c f2401b;
        private final int c;
        private final boolean d;
        private boolean e;
        private String f = "";
        private int g;

        public RunnableC0508a(com.mbridge.msdk.reward.adapter.c cVar, int i, boolean z) {
            this.e = false;
            this.f2401b = cVar;
            this.c = i;
            this.d = z;
            this.e = false;
            if (cVar != null) {
                cVar.d(false);
            }
        }

        public final void a() {
            this.e = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str = "2";
            if (this.e) {
                return;
            }
            com.mbridge.msdk.reward.adapter.c cVar = this.f2401b;
            if (cVar != null) {
                cVar.d(true);
            }
            aa.d("RewardVideoController", "adSource=" + this.c + " CommonCancelTimeTask mIsDevCall：" + this.d);
            try {
                HashMap map = new HashMap();
                map.put("timeout", this.g + "");
                map.put("result", "2");
                StringBuilder sb = new StringBuilder();
                if (!this.d) {
                    str = "1";
                }
                map.put("auto_load", sb.append(str).append("").toString());
                if (TextUtils.isEmpty(this.f)) {
                    map.put(MBridgeConstans.PROPERTIES_UNIT_ID, a.this.v);
                }
                m.a().a("2000126", this.f, map);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
            try {
                com.mbridge.msdk.reward.c.a.a(null, a.this.n, new com.mbridge.msdk.foundation.entity.e(2, "v3 is timeout"), a.this.v, a.this.J, "", "");
            } catch (Exception unused) {
            }
            a.this.b("v3 is timeout");
        }

        public final void a(String str) {
            this.f = str;
        }

        public final void a(int i) {
            this.g = i;
        }
    }

    /* JADX INFO: compiled from: RewardVideoController.java */
    public class b implements com.mbridge.msdk.reward.adapter.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.mbridge.msdk.reward.adapter.c f2402b;
        private boolean c;
        private RunnableC0508a d;

        public b(com.mbridge.msdk.reward.adapter.c cVar, boolean z) {
            this.f2402b = cVar;
            this.c = z;
        }

        public final void a(RunnableC0508a runnableC0508a) {
            this.d = runnableC0508a;
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public final void a(String str) {
            RunnableC0508a runnableC0508a = this.d;
            if (runnableC0508a != null) {
                runnableC0508a.a();
                a.this.D.removeCallbacks(this.d);
            }
            if (a.this.t != null) {
                c.f(a.this.t, a.this.A, a.this.v);
            }
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public final void a(List<CampaignEx> list) {
            RunnableC0508a runnableC0508a = this.d;
            if (runnableC0508a != null) {
                runnableC0508a.a();
                a.this.D.removeCallbacks(this.d);
            }
            a.this.a(list);
            if (a.this.t != null) {
                a.this.t.a(a.this.A, a.this.v);
            }
            com.mbridge.msdk.reward.adapter.c cVar = this.f2402b;
            if (cVar != null) {
                cVar.k = false;
            }
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public final void a(List<CampaignEx> list, String str) {
            RunnableC0508a runnableC0508a = this.d;
            if (runnableC0508a != null) {
                runnableC0508a.a();
                a.this.D.removeCallbacks(this.d);
            }
            com.mbridge.msdk.reward.adapter.c cVar = this.f2402b;
            if (cVar != null) {
                cVar.k = false;
                this.f2402b.a((com.mbridge.msdk.reward.adapter.a) null);
                this.f2402b = null;
            }
            a.this.a(list);
            if (a.this.t != null) {
                c.a(a.this.t, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<CampaignEx> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.R = list;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    static /* synthetic */ void j(a aVar) {
        String str;
        if (aVar.w != null) {
            if (aVar.P) {
                String strA = aVar.a();
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                ConcurrentHashMap<String, String> concurrentHashMap = T;
                if (concurrentHashMap == null || !concurrentHashMap.containsKey(strA) || TextUtils.isEmpty(T.get(strA))) {
                    str = "";
                } else {
                    str = T.get(strA);
                }
            } else {
                str = "";
            }
            aVar.w.setBidToken(str);
        }
    }

    static /* synthetic */ void a(a aVar, String str, List list) {
        if (list != null) {
            try {
                if (list.size() <= 0 || aVar.aa) {
                    return;
                }
                com.mbridge.msdk.foundation.db.f.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g())).a((List<CampaignEx>) list, str);
            } catch (Throwable th) {
                aa.d("RewardVideoController", th.getMessage());
            }
        }
    }
}
