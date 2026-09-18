package com.mbridge.msdk.mbnative.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.room.RoomMasterTable;
import com.iab.omid.library.mmadbridge.adsession.AdEvents;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.k;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.NativeListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class NativeController {
    private static boolean A = false;
    public static Map<String, Long> c = new HashMap();
    private static final String e = "NativeController";
    private int B;
    private int C;
    private int D;
    private int E;
    private com.mbridge.msdk.foundation.same.e.b F;
    private List<com.mbridge.msdk.mbnative.controller.a> G;
    private List<com.mbridge.msdk.mbnative.controller.a.InterfaceC0492a> H;
    private CopyOnWriteArrayList<com.mbridge.msdk.foundation.same.e.a> I;
    private Hashtable<String, AdSession> J;
    private int K;
    private int L;
    private a M;
    private boolean N;
    private boolean O;
    private Timer P;
    private String Q;
    private String R;
    private ViewTreeObserver.OnGlobalLayoutListener S;
    private com.mbridge.msdk.c.f T;
    private long U;
    private int V;
    private int W;
    private boolean X;
    private int Y;
    private int Z;
    protected List<Integer> a;
    private boolean aa;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected List<Integer> f2289b;
    Map<String, Object> d;
    private com.mbridge.msdk.c.e f;
    private com.mbridge.msdk.mbnative.c.a g;
    private NativeListener.NativeTrackingListener h;
    private Context i;
    private String j;
    private String k;
    private Queue<Integer> l;
    private Queue<Long> m;
    private String n;
    private e o;
    private p p;
    private String q;
    private com.mbridge.msdk.click.a r;
    private int s;
    private int t;
    private int u;
    private int v;
    private String w;
    private boolean x;
    private boolean y;
    private boolean z;

    public interface b {
        void a();
    }

    private static class e extends Handler {
        private WeakReference<NativeController> a;

        public e(NativeController nativeController) {
            this.a = new WeakReference<>(nativeController);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            WeakReference<NativeController> weakReference;
            NativeController nativeController;
            super.handleMessage(message);
            try {
                if (message.what == 0 && (weakReference = this.a) != null && (nativeController = weakReference.get()) != null) {
                    nativeController.p.a(message.arg1, (String) message.obj);
                }
                if (message.what == 1) {
                    NativeController nativeController2 = null;
                    WeakReference<NativeController> weakReference2 = this.a;
                    if (weakReference2 != null && weakReference2.get() != null) {
                        nativeController2 = this.a.get();
                    }
                    if (nativeController2 != null) {
                        nativeController2.y = true;
                        List<Campaign> listA = nativeController2.a(nativeController2.j, nativeController2.t, nativeController2.Q);
                        if (nativeController2.x) {
                            return;
                        }
                        nativeController2.a(listA);
                    }
                }
            } catch (Exception e) {
                aa.d(NativeController.e, com.mbridge.msdk.mbnative.b.a.a(e));
            }
        }
    }

    public NativeController(com.mbridge.msdk.mbnative.c.a aVar, NativeListener.NativeTrackingListener nativeTrackingListener, Map<String, Object> map, Context context) {
        com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA;
        this.s = 1;
        this.t = 1;
        this.u = -1;
        this.v = 0;
        this.x = false;
        this.y = false;
        this.z = false;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.I = new CopyOnWriteArrayList<>();
        this.J = new Hashtable<>();
        this.K = 1;
        this.L = 2;
        this.Q = "";
        this.R = "";
        this.i = context;
        this.d = map;
        this.f = new com.mbridge.msdk.c.e();
        this.g = aVar;
        this.h = nativeTrackingListener;
        this.G = new ArrayList();
        this.H = new ArrayList();
        String str = (String) map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
        this.j = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (map.containsKey(MBridgeConstans.PLACEMENT_ID) && map.get(MBridgeConstans.PLACEMENT_ID) != null) {
            this.k = (String) map.get(MBridgeConstans.PLACEMENT_ID);
        } else {
            this.k = "";
        }
        if (map.containsKey(MBridgeConstans.PREIMAGE)) {
            A = ((Boolean) map.get(MBridgeConstans.PREIMAGE)).booleanValue();
        }
        this.l = new LinkedList();
        this.m = new LinkedList();
        this.F = new com.mbridge.msdk.foundation.same.e.b(this.i);
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        this.o = new e(this);
        if (map.containsKey(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY)) {
            this.w = (String) map.get(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY);
        }
        try {
            if (!(com.mbridge.msdk.mbnative.controller.b.b().containsKey(this.j) ? com.mbridge.msdk.mbnative.controller.b.b().get(this.j).booleanValue() : false)) {
                if (map.containsKey("ad_num")) {
                    int iIntValue = ((Integer) map.get("ad_num")).intValue();
                    iIntValue = iIntValue < 1 ? 1 : iIntValue;
                    iIntValue = iIntValue > 10 ? 10 : iIntValue;
                    this.t = iIntValue;
                    this.s = iIntValue;
                }
                if (map.containsKey(MBridgeConstans.PROPERTIES_AD_FRAME_NUM)) {
                    this.D = ((Integer) map.get(MBridgeConstans.PROPERTIES_AD_FRAME_NUM)).intValue();
                }
            } else if (com.mbridge.msdk.mbnative.controller.b.d().containsKey(this.j)) {
                this.t = com.mbridge.msdk.mbnative.controller.b.d().get(this.j).intValue();
                if (map.containsKey("ad_num")) {
                    int iIntValue2 = ((Integer) map.get("ad_num")).intValue();
                    this.B = iIntValue2;
                    this.s = iIntValue2;
                }
                if (map.containsKey(MBridgeConstans.PROPERTIES_AD_FRAME_NUM)) {
                    int iIntValue3 = ((Integer) map.get(MBridgeConstans.PROPERTIES_AD_FRAME_NUM)).intValue();
                    this.C = iIntValue3;
                    this.D = iIntValue3;
                }
            }
        } catch (Exception e2) {
            aa.d(e, com.mbridge.msdk.mbnative.b.a.a(e2));
        }
        this.p = new p(this.i);
        this.r = new com.mbridge.msdk.click.a(this.i, this.j);
        try {
            Class.forName("com.mbridge.msdk.nativex.view.MBMediaView");
            Class.forName("com.mbridge.msdk.videocommon.download.c");
            this.O = true;
            Map<String, Object> map2 = this.d;
            if (map2 != null && (map2.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH) || this.d.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT) || map.containsKey(MBridgeConstans.NATIVE_VIDEO_SUPPORT))) {
                this.N = true;
            }
            com.mbridge.msdk.mbnative.controller.c.a(this.i, this.j);
            y.b();
            if (TextUtils.isEmpty(this.j)) {
                return;
            }
            com.mbridge.msdk.foundation.db.f.a(h.a(this.i)).a();
            int iA = a(map.containsKey(MBridgeConstans.NATIVE_INFO) ? (String) map.get(MBridgeConstans.NATIVE_INFO) : null);
            String str2 = this.j;
            iA = iA <= 0 ? this.s : iA;
            com.mbridge.msdk.c.f fVarE = com.mbridge.msdk.c.d.a().e("", str2);
            this.T = fVarE;
            if (fVarE == null) {
                this.T = com.mbridge.msdk.c.f.d(str2);
            }
            List<Integer> listR = this.T.r();
            this.a = listR;
            List<Campaign> listB = (listR == null || listR.size() <= 0 || !this.a.contains(1) || (bVarA = com.mbridge.msdk.mbnative.a.c.a(1)) == null) ? null : bVarA.b(str2, iA);
            if (listB != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < listB.size(); i++) {
                    CampaignEx campaignEx = (CampaignEx) listB.get(i);
                    if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                        arrayList.add(campaignEx);
                    }
                }
                if (arrayList.size() > 0) {
                    Class<?> cls = Class.forName("com.mbridge.msdk.videocommon.download.c");
                    Class<?> cls2 = Class.forName("com.mbridge.msdk.videocommon.listener.a");
                    Object objInvoke = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                    cls.getMethod("createUnitCache", Context.class, String.class, CopyOnWriteArrayList.class, Integer.TYPE, cls2).invoke(objInvoke, context, this.j, new CopyOnWriteArrayList(arrayList), 1, null);
                    cls.getMethod("load", String.class).invoke(objInvoke, this.j);
                }
            }
        } catch (Throwable unused) {
            aa.d(e, "please import the nativex aar");
        }
    }

    public NativeController() {
        this.s = 1;
        this.t = 1;
        this.u = -1;
        this.v = 0;
        this.x = false;
        this.y = false;
        this.z = false;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.I = new CopyOnWriteArrayList<>();
        this.J = new Hashtable<>();
        this.K = 1;
        this.L = 2;
        this.Q = "";
        this.R = "";
    }

    private int a(String str) {
        if (str == null) {
            return 0;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                    if (2 == jSONObject.optInt("id", 0)) {
                        return jSONObject.optInt("ad_num");
                    }
                }
            }
        } catch (Exception e2) {
            aa.d(e, com.mbridge.msdk.mbnative.b.a.a(e2));
        }
        return 0;
    }

    public final void a(int i, String str) {
        String str2;
        boolean zA;
        this.x = false;
        this.y = false;
        this.z = false;
        this.X = false;
        this.Q = str;
        this.g.a(!TextUtils.isEmpty(str));
        String str3 = null;
        this.M = null;
        Map<String, Long> map = c;
        if (map != null && map.size() > 0) {
            c.clear();
        }
        if (((com.mbridge.msdk.mbnative.controller.b.b() == null || !com.mbridge.msdk.mbnative.controller.b.b().containsKey(this.j)) ? false : com.mbridge.msdk.mbnative.controller.b.b().get(this.j).booleanValue()) && i == 1 && a(i)) {
            return;
        }
        if (this.d.containsKey("app_id") && this.d.containsKey(MBridgeConstans.APP_KEY) && this.d.containsKey(MBridgeConstans.KEY_WORD)) {
            str3 = (String) this.d.get("app_id");
            str2 = (String) this.d.get(MBridgeConstans.APP_KEY);
        } else {
            str2 = null;
        }
        this.f.a(this.i, str3, str2, this.j);
        com.mbridge.msdk.c.f fVarE = com.mbridge.msdk.c.d.a().e(str3, this.j);
        this.T = fVarE;
        if (fVarE == null) {
            this.T = com.mbridge.msdk.c.f.d(this.j);
        }
        com.mbridge.msdk.mbnative.controller.b.e().put(this.j, Integer.valueOf(this.T.v() * this.t));
        this.a = this.T.r();
        this.f2289b = this.T.s();
        this.W = this.T.p();
        this.V = this.T.q();
        this.t = this.s;
        List<Integer> list = this.a;
        if (list == null || list.size() == 0) {
            com.mbridge.msdk.mbnative.c.a aVar = this.g;
            if (aVar != null) {
                this.x = true;
                aVar.onAdLoadError("do not have sorceList");
                return;
            }
            return;
        }
        try {
            zA = com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.a(com.mbridge.msdk.foundation.controller.b.d().g());
        } catch (Exception unused) {
            zA = false;
        }
        if (!zA) {
            com.mbridge.msdk.mbnative.c.a aVar2 = this.g;
            if (aVar2 != null) {
                aVar2.onAdLoadError("webview is not available");
                return;
            }
            return;
        }
        if (this.d.containsKey(MBridgeConstans.NATIVE_INFO) && this.n == null) {
            String str4 = (String) this.d.get(MBridgeConstans.NATIVE_INFO);
            this.n = str4;
            if (str4 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(this.n);
                    if (jSONArray.length() > 0) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject = (JSONObject) jSONArray.opt(i2);
                            int iOptInt = jSONObject.optInt("id", 0);
                            if (2 == iOptInt) {
                                this.Y = jSONObject.optInt("ad_num");
                                if (this.W > 0) {
                                    jSONObject.remove("ad_num");
                                    jSONObject.put("ad_num", this.W);
                                }
                            } else if (3 == iOptInt) {
                                this.Z = jSONObject.optInt("ad_num");
                                if (this.W > 0) {
                                    jSONObject.remove("ad_num");
                                    jSONObject.put("ad_num", this.W);
                                }
                            }
                        }
                    }
                    this.K = Math.max(this.Y, this.Z);
                    this.n = jSONArray.toString();
                } catch (JSONException e2) {
                    aa.d(e, com.mbridge.msdk.mbnative.b.a.a(e2));
                }
            }
        }
        if ((!this.a.contains(1) || this.a.get(0).intValue() == 1) && i == 0 && a(a(this.j, this.t, this.Q))) {
            return;
        }
        this.aa = true;
        if (this.a.contains(1) && i == 0 && this.a.get(0).intValue() != 1) {
            int iIntValue = this.a.get(0).intValue();
            com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA = com.mbridge.msdk.mbnative.a.c.a(iIntValue);
            if (iIntValue == 2 && this.d.containsKey(MBridgeConstans.NATIVE_INFO)) {
                this.t = this.K;
            } else {
                this.t = this.s;
            }
            if (bVarA != null && a(a(iIntValue, d(bVarA.b(this.j, this.t))))) {
                return;
            }
            this.aa = false;
            try {
                b(1, this.f2289b.get(this.a.indexOf(1)).intValue() * 1000, i, this.Q);
            } catch (Exception unused2) {
            }
        }
        this.o.sendEmptyMessageDelayed(1, this.T.m() * 1000);
        List<Integer> list2 = this.a;
        if (list2 != null && list2.size() > 0) {
            Queue<Integer> queue = this.l;
            if (queue != null && queue.size() > 0) {
                this.l.clear();
            }
            for (Integer num : this.a) {
                Queue<Integer> queue2 = this.l;
                if (queue2 != null) {
                    queue2.add(num);
                }
            }
        }
        List<Integer> list3 = this.f2289b;
        if (list3 != null && list3.size() > 0) {
            Queue<Long> queue3 = this.m;
            if (queue3 != null && queue3.size() > 0) {
                this.m.clear();
            }
            for (Integer num2 : this.f2289b) {
                Queue<Long> queue4 = this.m;
                if (queue4 != null) {
                    queue4.add(Long.valueOf(num2.intValue() * 1000));
                }
            }
        }
        b(i, this.Q);
    }

    private boolean a(int i) {
        int iMin;
        int iOptInt;
        int iOptInt2;
        com.mbridge.msdk.mbnative.c.a aVar;
        int i2 = 0;
        if (com.mbridge.msdk.mbnative.controller.b.b().containsKey(this.j) && com.mbridge.msdk.mbnative.controller.b.b().get(this.j).booleanValue()) {
            Map<String, Map<Long, Object>> mapA = com.mbridge.msdk.mbnative.controller.b.a();
            Map<Long, Object> map = mapA.get(i + "_" + this.j);
            Integer num = com.mbridge.msdk.mbnative.controller.b.d().get(this.j);
            com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
            if (num != null) {
                this.t = num.intValue();
            }
            if (map != null && map.size() > 0) {
                Long next = map.keySet().iterator().next();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (cVarB == null) {
                    cVarB = com.mbridge.msdk.c.d.a().b();
                }
                if (jCurrentTimeMillis - next.longValue() >= cVarB.W() * 1000) {
                    mapA.remove(i + "_" + this.j);
                } else {
                    if (i == 1) {
                        List<Frame> list = (List) map.get(next);
                        if (list == null || list.size() <= 0 || (aVar = this.g) == null) {
                            return false;
                        }
                        if (this.D >= list.size()) {
                            mapA.remove(i + "_" + this.j);
                            aVar.onAdFramesLoaded(list);
                            return true;
                        }
                        if (this.D == 0) {
                            return false;
                        }
                        List<Frame> listSubList = list.subList(0, this.C);
                        aVar.onAdFramesLoaded(list);
                        list.removeAll(listSubList);
                        map.put(next, listSubList);
                        ArrayList arrayList = new ArrayList();
                        for (Frame frame : list) {
                            if (i2 >= this.D) {
                                arrayList.add(frame);
                            }
                            i2++;
                        }
                        map.put(next, arrayList);
                        mapA.put(i + "_" + this.j, map);
                        aVar.onAdFramesLoaded(listSubList);
                        return true;
                    }
                    List list2 = (List) map.get(next);
                    if (list2 != null && list2.size() > 0) {
                        List<Campaign> arrayList2 = new ArrayList<>();
                        if (((CampaignEx) list2.get(0)).getType() == 1) {
                            if (TextUtils.isEmpty(this.n)) {
                                iMin = Math.min(this.B, list2.size());
                            } else {
                                try {
                                    JSONArray jSONArray = new JSONArray(this.n);
                                    if (jSONArray.length() > 0) {
                                        iOptInt = 0;
                                        iOptInt2 = 0;
                                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                            JSONObject jSONObject = (JSONObject) jSONArray.opt(i3);
                                            int iOptInt3 = jSONObject.optInt("id", 0);
                                            if (2 == iOptInt3) {
                                                iOptInt = jSONObject.optInt("ad_num");
                                            } else if (3 == iOptInt3) {
                                                iOptInt2 = jSONObject.optInt("ad_num");
                                            }
                                        }
                                    } else {
                                        iOptInt = 0;
                                        iOptInt2 = 0;
                                    }
                                    if (3 == ((CampaignEx) list2.get(0)).getTemplate()) {
                                        iMin = Math.min(iOptInt2, list2.size());
                                    } else {
                                        iMin = Math.min(iOptInt, list2.size());
                                    }
                                } catch (Exception unused) {
                                    aa.d(e, "load from catch error in get nativeinfo adnum");
                                    iMin = 0;
                                }
                            }
                            if (iMin <= 0) {
                                return false;
                            }
                            Iterator it = list2.iterator();
                            while (it.hasNext() && i2 != iMin) {
                                CampaignEx campaignEx = (CampaignEx) it.next();
                                campaignEx.getTemplate();
                                arrayList2.add(campaignEx);
                                it.remove();
                                i2++;
                            }
                        } else {
                            int iMin2 = Math.min(this.B, list2.size());
                            if (iMin2 > 0) {
                                Iterator it2 = list2.iterator();
                                while (it2.hasNext() && i2 != iMin2) {
                                    CampaignEx campaignEx2 = (CampaignEx) it2.next();
                                    campaignEx2.getTemplate();
                                    arrayList2.add(campaignEx2);
                                    it2.remove();
                                    i2++;
                                }
                            }
                        }
                        a(arrayList2);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void b(int i, String str) {
        com.mbridge.msdk.mbnative.c.a aVar;
        Queue<Integer> queue = this.l;
        if (queue != null && queue.size() > 0) {
            int iIntValue = this.l.poll().intValue();
            this.U = MBridgeConstans.REQUEST_TIME_OUT;
            Queue<Long> queue2 = this.m;
            if (queue2 != null && queue2.size() > 0) {
                this.U = this.m.poll().longValue();
            }
            a(iIntValue, this.U, i, str);
            return;
        }
        if (this.x || (aVar = this.g) == null) {
            return;
        }
        this.x = true;
        aVar.onAdLoadError("no ad source");
    }

    private void a(int i, long j, int i2, String str) {
        com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA;
        if (i2 == 0 && (bVarA = com.mbridge.msdk.mbnative.a.c.a(i)) != null) {
            if ((i == 1 || i == 2) && this.d.containsKey(MBridgeConstans.NATIVE_INFO)) {
                this.t = this.K;
            } else {
                this.t = this.s;
            }
            if (a(a(i, d(bVarA.b(this.j, this.t))))) {
                return;
            }
        }
        if (i == 1) {
            b(1, j, i2, this.Q);
        } else if (i == 2) {
            b(2, j, i2, str);
        } else {
            b(i, j, i2, str);
        }
    }

    public final void a(String str, int i, String str2, CampaignEx campaignEx) {
        Queue<Integer> queue = this.l;
        if ((queue != null && queue.size() <= 0) || this.l == null) {
            com.mbridge.msdk.mbnative.c.a aVar = this.g;
            if (aVar == null || this.x) {
                return;
            }
            this.x = true;
            aVar.a(campaignEx, str);
            return;
        }
        b(i, str2);
    }

    private synchronized void b(int i, long j, int i2, String str) {
        k kVar;
        try {
            if (this.d.containsKey(MBridgeConstans.NATIVE_INFO)) {
                this.t = Math.max(this.Y, this.Z);
            }
            if (i2 == 0) {
                com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA = com.mbridge.msdk.mbnative.a.c.a(i);
                if (bVarA != null && a(a(1, d(bVarA.b(this.j, this.t))))) {
                    return;
                }
                a aVar = this.M;
                if (aVar != null && !this.X) {
                    aVar.b(true);
                }
                if (this.X && !this.x) {
                    a("mb load failed", i2, str, (CampaignEx) null);
                }
                if (!this.aa) {
                    return;
                }
            }
            int i3 = this.u;
            if (i3 == -1) {
                this.u = i;
            } else if (i3 != i) {
                this.v = 0;
            }
            com.mbridge.msdk.foundation.db.f.a(h.a(this.i)).a();
            com.mbridge.msdk.mbnative.e.a.a aVar2 = new com.mbridge.msdk.mbnative.e.a.a(this.i);
            com.mbridge.msdk.foundation.same.net.g.d dVar = new com.mbridge.msdk.foundation.same.net.g.d();
            String strH = com.mbridge.msdk.foundation.controller.b.d().h();
            String strJ = com.mbridge.msdk.foundation.controller.b.d().j();
            Map<String, Object> map = this.d;
            if (map != null && map.containsKey("app_id") && this.d.containsKey(MBridgeConstans.APP_KEY) && this.d.containsKey(MBridgeConstans.KEY_WORD) && this.d.get(MBridgeConstans.KEY_WORD) != null) {
                if (this.d.get("app_id") instanceof String) {
                    strH = (String) this.d.get("app_id");
                }
                if (this.d.get(MBridgeConstans.APP_KEY) instanceof String) {
                    strJ = (String) this.d.get(MBridgeConstans.APP_KEY);
                }
                String str2 = this.d.get(MBridgeConstans.KEY_WORD) instanceof String ? (String) this.d.get(MBridgeConstans.KEY_WORD) : null;
                if (!TextUtils.isEmpty(str2)) {
                    dVar.a("smart", u.a(str2));
                }
            }
            dVar.a("app_id", strH);
            dVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, this.j);
            if (!TextUtils.isEmpty(this.k)) {
                dVar.a(MBridgeConstans.PLACEMENT_ID, this.k);
            }
            dVar.a("req_type", "2");
            if (!TextUtils.isEmpty(this.w)) {
                dVar.a("category", this.w);
            }
            dVar.a("sign", SameMD5.getMD5(strH + strJ));
            if (this.W > 0 && i2 == 0) {
                dVar.a("ad_num", this.W + "");
            } else {
                dVar.a("ad_num", this.s + "");
            }
            String strH2 = af.h(this.j);
            if (!TextUtils.isEmpty(strH2)) {
                dVar.a("j", strH2);
            }
            dVar.a("only_impression", "1");
            dVar.a("ping_mode", "1");
            if (this.D != 0) {
                dVar.a("frame_num", this.D + "");
            }
            if (!TextUtils.isEmpty(this.n)) {
                dVar.a(MBridgeConstans.NATIVE_INFO, this.n);
                if (i == 1 && !com.mbridge.msdk.click.a.a) {
                    dVar.a("tnum", this.K + "");
                }
            } else if (i == 1 && !com.mbridge.msdk.click.a.a) {
                dVar.a("tnum", this.s + "");
            }
            String strA = com.mbridge.msdk.foundation.same.a.d.a(this.j, "native");
            if (!TextUtils.isEmpty(strA)) {
                dVar.a(com.mbridge.msdk.foundation.same.net.g.d.f2148b, strA);
            }
            if (Build.VERSION.SDK_INT >= 14) {
                if (this.d.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH) && (this.d.get(MBridgeConstans.NATIVE_VIDEO_WIDTH) instanceof Integer)) {
                    dVar.a("video_width", ((Integer) this.d.get(MBridgeConstans.NATIVE_VIDEO_WIDTH)).intValue() + "");
                }
                if (this.d.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT) && (this.d.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT) instanceof Integer)) {
                    dVar.a("video_height", ((Integer) this.d.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT)).intValue() + "");
                }
                if (this.d.containsKey(MBridgeConstans.NATIVE_VIDEO_SUPPORT) && (this.d.get(MBridgeConstans.NATIVE_VIDEO_SUPPORT) instanceof Boolean)) {
                    ((Boolean) this.d.get(MBridgeConstans.NATIVE_VIDEO_SUPPORT)).booleanValue();
                }
                dVar.a("video_version", MBridgeConstans.NATIVE_VIDEO_VERSION);
            }
            if (com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h()) == null) {
                com.mbridge.msdk.c.d.a().b();
            }
            if (!a(this.d)) {
                JSONArray jSONArrayA = af.a(this.i, this.j);
                if (jSONArrayA.length() > 0) {
                    dVar.a(com.mbridge.msdk.foundation.same.net.g.d.c, af.a(jSONArrayA));
                }
            }
            if (com.mbridge.msdk.mbnative.controller.b.b().containsKey(this.j) && com.mbridge.msdk.mbnative.controller.b.b().get(this.j).booleanValue() && com.mbridge.msdk.mbnative.controller.b.c().get(this.j) != null && (kVar = com.mbridge.msdk.mbnative.controller.b.c().get(this.j)) != null) {
                if (i == 1) {
                    this.v = kVar.b();
                } else if (i == 2) {
                    this.v = kVar.a();
                }
            }
            dVar.a("offset", this.v + "");
            dVar.a("ad_type", RoomMasterTable.DEFAULT_ID);
            dVar.a(CampaignEx.JSON_KEY_AD_SOURCE_ID, i + "");
            if (!TextUtils.isEmpty(this.q)) {
                dVar.a(com.mbridge.msdk.foundation.same.net.g.d.a, this.q);
            }
            a aVar3 = new a();
            aVar3.a(b(this.d));
            aVar3.setUnitId(this.j);
            aVar3.setPlacementId(this.k);
            aVar3.setAdType(42);
            aVar3.b(true);
            c cVar = new c(1, aVar3, i2, str);
            aVar3.a(cVar);
            aVar3.e(i2);
            aVar3.a(str);
            if (i2 == 0) {
                if (!TextUtils.isEmpty(str)) {
                    dVar.a(BidResponsed.KEY_TOKEN, str);
                }
                aVar2.choiceV3OrV5BySetting(1, dVar, aVar3, str);
            }
            if (i2 == 1) {
                aVar2.getLoadOrSetting(1, com.mbridge.msdk.foundation.same.net.f.d.a().u, dVar, aVar3);
            }
            this.o.postDelayed(cVar, j);
        } catch (Exception e2) {
            String str3 = e;
            aa.d(str3, com.mbridge.msdk.mbnative.b.a.a(e2));
            aa.d(str3, e2.getMessage());
        }
    }

    private void a(final View view, CampaignEx campaignEx) {
        BitmapDrawable bitmapDrawableA;
        if (!(view instanceof FrameLayout) || (bitmapDrawableA = com.mbridge.msdk.foundation.controller.b.d().a(this.j, campaignEx.getAdType())) == null) {
            return;
        }
        final ImageView imageView = null;
        try {
            int childCount = ((ViewGroup) view).getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ((ViewGroup) view).getChildAt(i);
                if ((childAt instanceof ImageView) && childAt.getTag() != null && "mb_wm".equals((String) childAt.getTag())) {
                    ((ImageView) childAt).setLayoutParams(new FrameLayout.LayoutParams(view.getWidth(), view.getHeight()));
                    imageView = (ImageView) childAt;
                    break;
                }
            }
            if (imageView == null) {
                imageView = new ImageView(com.mbridge.msdk.foundation.controller.b.d().g());
                imageView.setTag("mb_wm");
                af.a(imageView, bitmapDrawableA, view.getResources().getDisplayMetrics());
                if (imageView.getParent() == null) {
                    ((FrameLayout) view).addView(imageView, new FrameLayout.LayoutParams(view.getWidth(), view.getHeight()));
                }
            }
            this.S = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    if (imageView != null) {
                        imageView.setLayoutParams(new FrameLayout.LayoutParams(view.getWidth(), view.getHeight()));
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.S);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(Campaign campaign, View view, List<View> list) {
        try {
            a(view, (CampaignEx) campaign);
            NativeListener.NativeTrackingListener nativeTrackingListener = this.h;
            if (nativeTrackingListener != null) {
                this.r.a(nativeTrackingListener);
            }
            com.mbridge.msdk.mbnative.a.c.a(campaign.getType()).a(this.j, campaign, this.Q);
            final CampaignEx campaignEx = (CampaignEx) campaign;
            Class<?> cls = null;
            try {
                cls = Class.forName("com.mbridge.msdk.nativex.view.MBMediaView");
            } catch (Throwable unused) {
            }
            com.mbridge.msdk.foundation.same.a.d.a(this.j, campaignEx, "native");
            if (campaignEx != null) {
                if (view != null) {
                    if (cls != null && cls.isInstance(view)) {
                        return;
                    } else {
                        view.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.5
                            @Override // com.mbridge.msdk.widget.a
                            protected final void a(View view2) {
                                com.mbridge.msdk.click.a unused2 = NativeController.this.r;
                                com.mbridge.msdk.click.a.a = false;
                                NativeController.this.r.a(campaignEx, NativeController.this.g);
                                NativeController.a(NativeController.this, campaignEx);
                            }
                        });
                    }
                }
                if (list != null && list.size() > 0) {
                    for (View view2 : list) {
                        if (cls != null && cls.isInstance(view2)) {
                            break;
                        } else {
                            view2.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.6
                                @Override // com.mbridge.msdk.widget.a
                                protected final void a(View view3) {
                                    com.mbridge.msdk.click.a unused2 = NativeController.this.r;
                                    com.mbridge.msdk.click.a.a = false;
                                    NativeController.this.r.a(campaignEx, NativeController.this.g);
                                    NativeController.a(NativeController.this, campaignEx);
                                }
                            });
                        }
                    }
                }
                if (campaignEx.isReport()) {
                    return;
                }
                a(campaignEx, view, list);
                Log.e(e, "sendImpression" + campaignEx);
            }
        } catch (Exception unused2) {
            aa.d(e, "registerview exception!");
        }
    }

    public final void a(Campaign campaign, View view) {
        try {
            NativeListener.NativeTrackingListener nativeTrackingListener = this.h;
            if (nativeTrackingListener != null) {
                this.r.a(nativeTrackingListener);
            }
            com.mbridge.msdk.mbnative.a.c.a(campaign.getType()).a(this.j, campaign, this.Q);
            final CampaignEx campaignEx = (CampaignEx) campaign;
            com.mbridge.msdk.foundation.same.a.d.a(this.j, campaignEx, "native");
            if (campaignEx != null) {
                com.mbridge.msdk.widget.a aVar = new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.7
                    @Override // com.mbridge.msdk.widget.a
                    protected final void a(View view2) {
                        com.mbridge.msdk.click.a unused = NativeController.this.r;
                        com.mbridge.msdk.click.a.a = false;
                        NativeController.this.r.a(campaignEx, NativeController.this.g);
                        NativeController.a(NativeController.this, campaignEx);
                    }
                };
                try {
                    a(view, aVar, Class.forName("com.mbridge.msdk.nativex.view.MBMediaView"));
                } catch (Throwable unused) {
                    a(view, aVar, (Class) null);
                }
                a(view, (CampaignEx) campaign);
                if (campaignEx.isReport()) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(view);
                a(campaignEx, view, (List<View>) arrayList);
                aa.b(e, "sendImpression" + campaignEx);
            }
        } catch (Exception unused2) {
            aa.d(e, "registerview exception!");
        }
    }

    private AdSession a(CampaignEx campaignEx) {
        if (this.J == null) {
            this.J = new Hashtable<>();
        }
        String requestIdNotice = campaignEx.getRequestIdNotice();
        AdSession adSessionA = this.J.get(requestIdNotice);
        if (adSessionA == null && campaignEx.isActiveOm()) {
            adSessionA = com.mbridge.msdk.a.b.a(this.i, true, campaignEx.getOmid(), campaignEx.getRequestId(), campaignEx.getId(), this.j, "", campaignEx.getRequestIdNotice());
        }
        if (adSessionA != null) {
            this.J.put(requestIdNotice, adSessionA);
        }
        return adSessionA;
    }

    private void a(CampaignEx campaignEx, View view, List<View> list) {
        AdSession adSessionA = null;
        try {
            if (this.i != null && campaignEx != null && (adSessionA = a(campaignEx)) != null) {
                adSessionA.registerAdView(view);
                adSessionA.start();
            }
            AdSession adSession = adSessionA;
            com.mbridge.msdk.c.f fVar = this.T;
            int iE = (campaignEx == null || campaignEx.getImpReportType() != 1) ? fVar != null ? fVar.e() : 0 : 0;
            final f fVar2 = new f(campaignEx, view, list, this, adSession);
            if (this.I == null) {
                this.I = new CopyOnWriteArrayList<>();
            }
            this.I.add(fVar2);
            fVar2.d = new com.mbridge.msdk.foundation.same.e.a.b() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.8
                @Override // com.mbridge.msdk.foundation.same.e.a.b
                public final void a(com.mbridge.msdk.foundation.same.e.a.EnumC0483a enumC0483a) {
                    if (enumC0483a != com.mbridge.msdk.foundation.same.e.a.EnumC0483a.FINISH || NativeController.this.I == null || NativeController.this.I.size() <= 0 || !NativeController.this.I.contains(fVar2)) {
                        return;
                    }
                    NativeController.this.I.remove(fVar2);
                }
            };
            e eVar = this.o;
            if (eVar != null) {
                eVar.postDelayed(fVar2, iE * 1000);
            }
        } catch (Exception e2) {
            aa.d(e, com.mbridge.msdk.mbnative.b.a.a(e2));
        }
    }

    private void a(View view, View.OnClickListener onClickListener, Class cls) {
        if (view == null || onClickListener == null) {
            return;
        }
        if (cls != null) {
            try {
                if (cls.isInstance(view)) {
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        view.setOnClickListener(onClickListener);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), onClickListener, cls);
            }
        }
    }

    private static class f extends com.mbridge.msdk.foundation.same.e.a {
        private CampaignEx a;
        private WeakReference<View> e;
        private WeakReference<List<View>> f;
        private WeakReference<NativeController> g;
        private WeakReference<AdSession> h;

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void b() {
        }

        public f(CampaignEx campaignEx, View view, List<View> list, NativeController nativeController, AdSession adSession) {
            this.a = campaignEx;
            this.e = new WeakReference<>(view);
            this.f = new WeakReference<>(list);
            this.g = new WeakReference<>(nativeController);
            this.h = new WeakReference<>(adSession);
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void a() {
            WeakReference<View> weakReference;
            try {
                if (this.g == null || (weakReference = this.e) == null || this.f == null) {
                    return;
                }
                View view = weakReference.get();
                List<View> list = this.f.get();
                NativeController nativeController = this.g.get();
                WeakReference<AdSession> weakReference2 = this.h;
                AdSession adSession = weakReference2 != null ? weakReference2.get() : null;
                if (view == null || nativeController == null) {
                    return;
                }
                NativeController.a(nativeController, this.a, view, list, adSession);
            } catch (Exception e) {
                aa.d(NativeController.e, com.mbridge.msdk.mbnative.b.a.a(e));
            }
        }
    }

    public final void b(Campaign campaign, View view) {
        b(campaign, view, null);
    }

    public final void b(Campaign campaign, View view, List<View> list) {
        if (view != null && this.S != null) {
            try {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.S);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (campaign != null) {
            int type = campaign.getType();
            if (type == 1 || type == 2) {
                Class<?> cls = null;
                try {
                    cls = Class.forName("com.mbridge.msdk.nativex.view.MBMediaView");
                } catch (Throwable unused) {
                }
                if (list == null || list.size() <= 0) {
                    if (view != null) {
                        a(view, cls);
                    }
                } else {
                    Iterator<View> it = list.iterator();
                    while (it.hasNext()) {
                        a(it.next(), cls);
                    }
                }
            }
        }
    }

    private void a(View view, Class cls) {
        if (view == null) {
            return;
        }
        if (cls != null) {
            try {
                if (cls.isInstance(view)) {
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        view.setOnClickListener(null);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), cls);
            }
        }
    }

    public final void a() {
        com.mbridge.msdk.foundation.same.e.a next;
        com.mbridge.msdk.foundation.same.e.b bVar = this.F;
        if (bVar != null) {
            bVar.a();
            this.F = null;
        }
        Hashtable<String, AdSession> hashtable = this.J;
        if (hashtable != null) {
            for (AdSession adSession : hashtable.values()) {
                if (adSession != null) {
                    adSession.finish();
                }
            }
            this.J.clear();
        }
        e eVar = this.o;
        if (eVar != null) {
            eVar.removeCallbacksAndMessages(null);
        }
        this.h = null;
        this.r.a();
        try {
            Context context = this.i;
            if (context != null) {
                com.mbridge.msdk.foundation.same.c.b.a(context).c();
            }
            List<com.mbridge.msdk.mbnative.controller.a> list = this.G;
            if (list != null && list.size() > 0) {
                Iterator<com.mbridge.msdk.mbnative.controller.a> it = this.G.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                this.G.clear();
                this.G = null;
            }
            List<com.mbridge.msdk.mbnative.controller.a.InterfaceC0492a> list2 = this.H;
            if (list2 != null && list2.size() > 0) {
                for (com.mbridge.msdk.mbnative.controller.a.InterfaceC0492a interfaceC0492a : this.H) {
                }
                this.H.clear();
                this.H = null;
            }
            CopyOnWriteArrayList<com.mbridge.msdk.foundation.same.e.a> copyOnWriteArrayList = this.I;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                return;
            }
            Iterator<com.mbridge.msdk.foundation.same.e.a> it2 = this.I.iterator();
            if (it2.hasNext() && (next = it2.next()) != null) {
                next.d();
                this.o.removeCallbacks(next);
            }
            this.I.clear();
        } catch (Exception unused) {
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2302b;
        private com.mbridge.msdk.foundation.same.e.d c;
        private int d;
        private String e;

        public c(int i, com.mbridge.msdk.foundation.same.e.d dVar, int i2, String str) {
            this.f2302b = i;
            this.c = dVar;
            this.d = i2;
            this.e = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.c.a(true);
            int i = this.f2302b;
            if (i == 1) {
                NativeController.this.X = true;
                NativeController.this.a("REQUEST_TIMEOUT", this.d, this.e, (CampaignEx) null);
            } else {
                if (i != 2) {
                    return;
                }
                if (!NativeController.this.x || this.d == 1) {
                    NativeController.this.a("REQUEST_TIMEOUT", this.d, this.e, (CampaignEx) null);
                }
            }
        }
    }

    public class a extends com.mbridge.msdk.mbnative.e.a.b implements com.mbridge.msdk.foundation.same.e.d {
        private Runnable c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2301b = false;
        private boolean d = true;
        private List<String> e = null;

        public a() {
        }

        public final void b(boolean z) {
            this.d = z;
        }

        @Override // com.mbridge.msdk.foundation.same.e.d
        public final void a(boolean z) {
            this.f2301b = z;
        }

        public final void a(List<String> list) {
            this.e = list;
        }

        @Override // com.mbridge.msdk.mbnative.e.a.b
        public final void a(List<com.mbridge.msdk.foundation.same.net.c.b> list, CampaignUnit campaignUnit) {
            NativeController.this.X = true;
            com.mbridge.msdk.foundation.db.k kVarA = com.mbridge.msdk.foundation.db.k.a(h.a(NativeController.this.i));
            kVarA.b();
            if (this.c != null) {
                NativeController.this.o.removeCallbacks(this.c);
            }
            if (campaignUnit != null && campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0) {
                NativeController.this.q = campaignUnit.getSessionId();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                if (NativeController.this.V <= 0) {
                    if (NativeController.this.V == -3) {
                        NativeController.this.V = campaignUnit.getAds().size();
                    } else {
                        NativeController nativeController = NativeController.this;
                        nativeController.V = nativeController.t;
                    }
                    if (NativeController.this.Y != 0 && campaignUnit.getTemplate() == 2) {
                        NativeController nativeController2 = NativeController.this;
                        nativeController2.V = nativeController2.Y;
                    }
                    if (NativeController.this.Z != 0 && campaignUnit.getTemplate() == 3) {
                        NativeController nativeController3 = NativeController.this;
                        nativeController3.V = nativeController3.Z;
                    }
                }
                for (int i = 0; i < campaignUnit.getAds().size(); i++) {
                    CampaignEx campaignEx = campaignUnit.getAds().get(i);
                    campaignEx.setCampaignUnitId(this.unitId);
                    if (!TextUtils.isEmpty(NativeController.this.Q)) {
                        campaignEx.setBidToken(NativeController.this.Q);
                        campaignEx.setIsBidCampaign(true);
                    }
                    if (NativeController.A) {
                        campaignEx.loadIconUrlAsyncWithBlock(null);
                        campaignEx.loadImageUrlAsyncWithBlock(null);
                    }
                    if (campaignEx != null) {
                        boolean zC = af.c(NativeController.this.i, campaignEx.getPackageName());
                        if (i < NativeController.this.t && campaignEx.getOfferType() != 99) {
                            if (af.b(campaignEx)) {
                                campaignEx.setRtinsType(zC ? 1 : 2);
                            }
                            if (campaignEx.getWtick() == 1 || !zC) {
                                arrayList.add(campaignEx);
                                if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                                    arrayList3.add(campaignEx);
                                }
                            } else if (af.b(campaignEx)) {
                                arrayList.add(campaignEx);
                                if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                                    arrayList3.add(campaignEx);
                                }
                            } else {
                                af.a(this.unitId, campaignEx, com.mbridge.msdk.foundation.same.a.w);
                            }
                        }
                        if (i < NativeController.this.V && campaignEx.getOfferType() != 99) {
                            if (af.b(campaignEx)) {
                                campaignEx.setRtinsType(zC ? 1 : 2);
                            }
                            if (!zC || af.b(campaignEx)) {
                                arrayList2.add(campaignEx);
                            }
                        }
                        if (!kVarA.a(campaignEx.getId())) {
                            com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
                            gVar.a(campaignEx.getId());
                            gVar.a(campaignEx.getFca());
                            gVar.b(campaignEx.getFcb());
                            gVar.d(0);
                            gVar.c(0);
                            gVar.a(System.currentTimeMillis());
                            kVarA.a(gVar);
                        }
                        com.mbridge.msdk.click.b.a(NativeController.this.i, campaignEx.getMaitve(), campaignEx.getMaitve_src());
                    }
                }
                NativeController.b(NativeController.this, arrayList3);
                int type = campaignUnit.getAds().get(0) != null ? campaignUnit.getAds().get(0).getType() : 1;
                com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA = com.mbridge.msdk.mbnative.a.c.a(type);
                if (bVarA != null) {
                    bVarA.a(this.unitId, arrayList2, NativeController.this.Q);
                }
                if (arrayList.size() == 0) {
                    NativeController.this.a("APP ALREADY INSTALLED", b(), a(), campaignUnit.getAds().get(0));
                    try {
                        q.a(com.mbridge.msdk.foundation.controller.b.d().g(), new com.mbridge.msdk.foundation.entity.e(11, "APP ALREADY INSTALLED"), this.unitId, NativeController.this.g != null ? NativeController.this.g.a() : false, campaignUnit);
                        return;
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                            return;
                        }
                        return;
                    }
                }
                NativeController nativeController4 = NativeController.this;
                nativeController4.a((List<Campaign>) nativeController4.a(type, (List<Campaign>) nativeController4.d(arrayList)));
                if (com.mbridge.msdk.mbnative.controller.b.b().containsKey(this.unitId) && com.mbridge.msdk.mbnative.controller.b.b().get(this.unitId).booleanValue()) {
                    com.mbridge.msdk.mbnative.controller.b.a(NativeController.this.u, this.unitId);
                    return;
                }
                int iIntValue = com.mbridge.msdk.mbnative.controller.b.e().containsKey(this.unitId) ? com.mbridge.msdk.mbnative.controller.b.e().get(this.unitId).intValue() : 1;
                int i2 = NativeController.this.t + NativeController.this.v;
                NativeController.this.v = i2 <= iIntValue ? i2 : 0;
                return;
            }
            this.unitId = "0_" + this.unitId;
            com.mbridge.msdk.mbnative.controller.b.b(NativeController.this.u, this.unitId);
            NativeController.this.v = 0;
        }

        @Override // com.mbridge.msdk.mbnative.e.a.b
        public final void a(int i, String str) {
            NativeController.this.X = true;
            if (this.f2301b) {
                if (NativeController.this.x || !this.d) {
                    return;
                }
                NativeController.this.a(str, b(), a(), (CampaignEx) null);
                return;
            }
            if (i == -1) {
                com.mbridge.msdk.mbnative.controller.b.b(NativeController.this.u, this.unitId);
                NativeController.this.v = 0;
            }
            if (this.c != null) {
                NativeController.this.o.removeCallbacks(this.c);
            }
            if (NativeController.this.x) {
                return;
            }
            if (b() == 1 || this.d) {
                NativeController.this.a(str, b(), a(), (CampaignEx) null);
            }
        }

        public final void a(Runnable runnable) {
            this.c = runnable;
        }

        @Override // com.mbridge.msdk.mbnative.e.a.b
        public final void b(List<Frame> list) {
            if (this.f2301b) {
                return;
            }
            if (this.c != null) {
                NativeController.this.o.removeCallbacks(this.c);
            }
            if (list == null || list.size() == 0) {
                if (NativeController.this.g != null) {
                    NativeController.this.x = true;
                    NativeController.this.g.onAdLoadError("frame is empty");
                    return;
                }
                return;
            }
            Iterator<Frame> it = list.iterator();
            while (it.hasNext()) {
                List<CampaignEx> campaigns = it.next().getCampaigns();
                if (campaigns == null || campaigns.size() == 0) {
                    if (NativeController.this.g != null) {
                        NativeController.this.x = true;
                        NativeController.this.g.onAdLoadError("ads in frame is empty");
                        return;
                    }
                    return;
                }
                for (CampaignEx campaignEx : campaigns) {
                    if (NativeController.A) {
                        campaignEx.loadImageUrlAsyncWithBlock(null);
                        campaignEx.loadIconUrlAsyncWithBlock(null);
                    }
                }
            }
            if (NativeController.this.g != null) {
                NativeController.this.g.onAdFramesLoaded(list);
            }
        }
    }

    public final List<Campaign> a(String str, int i, String str2) {
        int i2;
        int i3;
        List<Campaign> listA = null;
        if (this.a != null) {
            ArrayList arrayList = new ArrayList(this.a);
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA = com.mbridge.msdk.mbnative.a.c.a(((Integer) arrayList.get(i4)).intValue());
                if (bVarA != null) {
                    if ((((Integer) arrayList.get(i4)).intValue() == 1 || ((Integer) arrayList.get(i4)).intValue() == 2) && this.d.containsKey(MBridgeConstans.NATIVE_INFO)) {
                        i3 = this.K;
                    } else {
                        i3 = this.s;
                    }
                    listA = a(((Integer) arrayList.get(i4)).intValue(), bVarA.b(str, i3));
                    if (listA != null) {
                        break;
                    }
                }
            }
            if (listA == null) {
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA2 = com.mbridge.msdk.mbnative.a.c.a(((Integer) arrayList.get(i5)).intValue());
                    if ((((Integer) arrayList.get(i5)).intValue() == 1 || ((Integer) arrayList.get(i5)).intValue() == 2) && this.d.containsKey(MBridgeConstans.NATIVE_INFO)) {
                        i2 = this.K;
                    } else {
                        i2 = this.s;
                    }
                    listA = a(((Integer) arrayList.get(i5)).intValue(), bVarA2.a(str, i2));
                    if (listA != null) {
                        break;
                    }
                }
            }
        }
        return d(listA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(final List<Campaign> list) {
        if ((!TextUtils.isEmpty(this.Q) && list != null && list.size() == 0) || list == null || list.size() <= 0) {
            return false;
        }
        final com.mbridge.msdk.mbnative.c.a aVar = this.g;
        if (aVar == null) {
            return true;
        }
        CampaignEx campaignEx = (CampaignEx) list.get(0);
        final int template = campaignEx != null ? campaignEx.getTemplate() : 2;
        com.mbridge.msdk.foundation.db.k kVarA = com.mbridge.msdk.foundation.db.k.a(h.a(this.i));
        kVarA.b();
        for (int i = 0; i < list.size(); i++) {
            CampaignEx campaignEx2 = (CampaignEx) list.get(i);
            if (!kVarA.a(campaignEx2.getId())) {
                com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
                gVar.a(campaignEx2.getId());
                gVar.a(campaignEx2.getFca());
                gVar.b(campaignEx2.getFcb());
                gVar.d(0);
                gVar.c(0);
                gVar.a(System.currentTimeMillis());
                kVarA.a(gVar);
            }
        }
        campaignEx.getType();
        if (this.O && this.N) {
            if (e().h() == 3) {
                final List<Campaign> listB = b(list);
                if (list != null && list.size() > 0) {
                    a(list, new b() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.10
                        @Override // com.mbridge.msdk.mbnative.controller.NativeController.b
                        public final void a() {
                            List listA = NativeController.a(NativeController.this, listB, true);
                            if (listA == null || listA.size() <= 0) {
                                NativeController.this.a(aVar, "has no ads", (CampaignEx) list.get(0));
                            } else {
                                NativeController.this.a((List<Campaign>) listA, template, aVar);
                            }
                        }
                    });
                    return true;
                }
                a(aVar, "has no ads", (CampaignEx) null);
                return true;
            }
            List<Campaign> listC = c(list);
            if (listC != null && listC.size() > 0) {
                a(listC, new b() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.11
                    @Override // com.mbridge.msdk.mbnative.controller.NativeController.b
                    public final void a() {
                        List listA = NativeController.a(NativeController.this, list, false);
                        if (listA == null || listA.size() <= 0) {
                            NativeController.this.a(aVar, "has no ads", (CampaignEx) null);
                        } else {
                            NativeController.this.a((List<Campaign>) listA, template, aVar);
                        }
                    }
                });
                return true;
            }
            a(list, template, aVar);
            return true;
        }
        if (list != null && list.size() > 0) {
            Iterator<Campaign> it = list.iterator();
            while (it.hasNext()) {
                it.next().setVideoLength(0);
            }
            a(list, template, aVar);
            return true;
        }
        a(aVar, "has no ads", (CampaignEx) null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final List<Campaign> list, final int i, final NativeListener.NativeAdListener nativeAdListener) {
        this.o.post(new Runnable() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.12
            @Override // java.lang.Runnable
            public final void run() {
                List list2 = list;
                if (list2 != null && list2.size() > 0) {
                    CampaignEx campaignEx = (CampaignEx) list.get(0);
                    NativeController.this.R = campaignEx.getRequestId();
                }
                NativeController.this.x = true;
                nativeAdListener.onAdLoaded(list, i);
                com.mbridge.msdk.mbnative.d.a.a(NativeController.this.i, list, NativeController.this.j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.mbridge.msdk.mbnative.c.a aVar, final String str, final CampaignEx campaignEx) {
        this.o.post(new Runnable() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.2
            @Override // java.lang.Runnable
            public final void run() {
                aVar.a(campaignEx, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Campaign> a(int i, List<Campaign> list) {
        if (i != 1 || !this.d.containsKey(MBridgeConstans.NATIVE_INFO) || list == null || list.size() <= 0) {
            return list;
        }
        CampaignEx campaignEx = (CampaignEx) list.get(0);
        int template = campaignEx != null ? campaignEx.getTemplate() : 1;
        if (template == 2) {
            if (list == null) {
                return list;
            }
            int size = list.size();
            int i2 = this.Y;
            return size >= i2 ? list.subList(0, i2) : list;
        }
        if (template != 3 || list == null) {
            return list;
        }
        int size2 = list.size();
        int i3 = this.Z;
        return size2 >= i3 ? list.subList(0, i3) : list;
    }

    public static boolean a(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        try {
            return map.containsKey("app_id") && map.containsKey(MBridgeConstans.APP_KEY) && map.containsKey(MBridgeConstans.KEY_WORD) && map.get(MBridgeConstans.KEY_WORD) != null;
        } catch (Exception e2) {
            aa.d(e, com.mbridge.msdk.mbnative.b.a.a(e2));
            return false;
        }
    }

    public static List<String> b(Map<String, Object> map) {
        ArrayList arrayList = null;
        try {
            if (!(map.get(MBridgeConstans.KEY_WORD) instanceof String)) {
                return null;
            }
            String str = (String) map.get(MBridgeConstans.KEY_WORD);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString = jSONObjectOptJSONObject.optString("p");
                        if (TextUtils.isEmpty(strOptString)) {
                            continue;
                        } else {
                            arrayList2.add(strOptString);
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    arrayList = arrayList2;
                }
            }
            return arrayList2;
        } catch (Exception e3) {
            e = e3;
        }
        aa.d(e, com.mbridge.msdk.mbnative.b.a.a(e));
        return arrayList;
    }

    private static class d implements com.mbridge.msdk.videocommon.download.g.b {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CampaignEx f2303b;
        private long c = System.currentTimeMillis();
        private boolean d;

        public d(String str, CampaignEx campaignEx, boolean z) {
            this.d = true;
            this.a = str;
            this.f2303b = campaignEx;
            this.d = z;
        }

        @Override // com.mbridge.msdk.videocommon.download.g.a
        public final void a(String str, boolean z) {
            try {
                if (this.d) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - this.c;
                    com.mbridge.msdk.foundation.db.q.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
                    n nVar = new n("2000043", 20, jCurrentTimeMillis + "", str, this.f2303b.getId(), this.a, "", "2");
                    CampaignEx campaignEx = this.f2303b;
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getId())) {
                        nVar.q(this.f2303b.getId());
                    }
                    CampaignEx campaignEx2 = this.f2303b;
                    if (campaignEx2 != null) {
                        nVar.m(campaignEx2.getRequestId());
                        nVar.o(this.f2303b.getRequestIdNotice());
                        nVar.n(this.f2303b.getCurrentLRid());
                        nVar.c(this.f2303b.getAdSpaceT());
                    }
                    nVar.h("1");
                    com.mbridge.msdk.foundation.same.report.n.a(nVar, this.a, this.f2303b);
                }
            } catch (Exception e) {
                aa.d(NativeController.e, com.mbridge.msdk.mbnative.b.a.a(e));
            }
        }

        @Override // com.mbridge.msdk.videocommon.download.g.a
        public final void a(String str, String str2) {
            try {
                if (this.d) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - this.c;
                    com.mbridge.msdk.foundation.db.q.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
                    n nVar = new n("2000043", 21, jCurrentTimeMillis + "", str, this.f2303b.getId(), this.a, str2, "2");
                    nVar.m(this.f2303b.getRequestId());
                    nVar.n(this.f2303b.getCurrentLRid());
                    nVar.o(this.f2303b.getRequestIdNotice());
                    CampaignEx campaignEx = this.f2303b;
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getId())) {
                        nVar.q(this.f2303b.getId());
                    }
                    CampaignEx campaignEx2 = this.f2303b;
                    if (campaignEx2 != null) {
                        nVar.c(campaignEx2.getAdSpaceT());
                    }
                    nVar.h("1");
                    com.mbridge.msdk.foundation.same.report.n.a(nVar, this.a, this.f2303b);
                }
            } catch (Exception e) {
                aa.d(NativeController.e, com.mbridge.msdk.mbnative.b.a.a(e));
            }
        }
    }

    private static final class g implements com.mbridge.msdk.videocommon.download.g.d {
        String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        CampaignEx f2304b;
        private long c = System.currentTimeMillis();
        private boolean d;

        public g(String str, CampaignEx campaignEx, boolean z) {
            this.d = true;
            this.a = str;
            this.f2304b = campaignEx;
            this.d = z;
        }

        @Override // com.mbridge.msdk.videocommon.download.g.a
        public final void a(String str, boolean z) {
            try {
                if (this.d) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - this.c;
                    com.mbridge.msdk.foundation.db.q.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
                    n nVar = new n("2000043", 14, jCurrentTimeMillis + "", str, this.f2304b.getId(), this.a, "", "1");
                    CampaignEx campaignEx = this.f2304b;
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getId())) {
                        nVar.q(this.f2304b.getId());
                    }
                    CampaignEx campaignEx2 = this.f2304b;
                    if (campaignEx2 != null) {
                        nVar.m(campaignEx2.getRequestId());
                        nVar.n(this.f2304b.getCurrentLRid());
                        nVar.o(this.f2304b.getRequestIdNotice());
                        nVar.c(this.f2304b.getAdSpaceT());
                    }
                    nVar.h("2");
                    com.mbridge.msdk.foundation.same.report.n.a(nVar, this.a, this.f2304b);
                }
            } catch (Exception e) {
                aa.d(NativeController.e, com.mbridge.msdk.mbnative.b.a.a(e));
            }
        }

        @Override // com.mbridge.msdk.videocommon.download.g.a
        public final void a(String str, String str2) {
            try {
                if (this.d) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - this.c;
                    com.mbridge.msdk.foundation.db.q.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
                    n nVar = new n("2000043", 3, jCurrentTimeMillis + "", str2, this.f2304b.getId(), this.a, str, "1");
                    CampaignEx campaignEx = this.f2304b;
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getId())) {
                        nVar.q(this.f2304b.getId());
                    }
                    CampaignEx campaignEx2 = this.f2304b;
                    if (campaignEx2 != null) {
                        nVar.m(campaignEx2.getRequestId());
                        nVar.n(this.f2304b.getCurrentLRid());
                        nVar.o(this.f2304b.getRequestIdNotice());
                        nVar.c(this.f2304b.getAdSpaceT());
                    }
                    nVar.h("2");
                    com.mbridge.msdk.foundation.same.report.n.a(nVar, this.a, this.f2304b);
                }
            } catch (Exception e) {
                aa.d(NativeController.e, com.mbridge.msdk.mbnative.b.a.a(e));
            }
        }
    }

    public static void insertExcludeId(String str, CampaignEx campaignEx) {
        if (TextUtils.isEmpty(str) || campaignEx == null || com.mbridge.msdk.foundation.controller.b.d().g() == null) {
            return;
        }
        j jVarA = j.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
        com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
        fVar.a(System.currentTimeMillis());
        fVar.b(str);
        fVar.a(campaignEx.getId());
        jVarA.a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.mbridge.msdk.c.f e() {
        com.mbridge.msdk.c.f fVarE = com.mbridge.msdk.c.d.a().e("", this.j);
        this.T = fVarE;
        if (fVarE == null) {
            this.T = com.mbridge.msdk.c.f.d(this.j);
        }
        return this.T;
    }

    private List<Campaign> b(List<Campaign> list) {
        if (list != null) {
            CampaignEx campaignEx = null;
            for (int size = list.size() - 1; size >= 0; size--) {
                try {
                    campaignEx = (CampaignEx) list.get(size);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (campaignEx != null && TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                    Campaign campaignRemove = list.remove(size);
                    com.mbridge.msdk.mbnative.a.c.a(campaignEx.getType()).a(this.j, campaignRemove, this.Q);
                    aa.a(e, "remove no videoURL ads:" + campaignRemove);
                }
            }
        }
        return list;
    }

    private List<Campaign> c(List<Campaign> list) {
        ArrayList arrayList = null;
        if (list != null) {
            for (Campaign campaign : list) {
                if (campaign instanceof CampaignEx) {
                    CampaignEx campaignEx = (CampaignEx) campaign;
                    if (TextUtils.isEmpty(campaignEx.getImageUrl()) && !TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(campaign);
                    }
                }
            }
        }
        return arrayList;
    }

    private void a(final List<Campaign> list, final b bVar) {
        f();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        Timer timer = new Timer();
        this.P = timer;
        timer.schedule(new TimerTask() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                boolean z;
                if (System.currentTimeMillis() - jCurrentTimeMillis < 60000) {
                    int iR = w.r(NativeController.this.i);
                    int iK = NativeController.this.e().k();
                    if (iR != 9 && iK == 2) {
                        bVar.a();
                        NativeController.this.f();
                        return;
                    }
                    if (iK == 3) {
                        bVar.a();
                        NativeController.this.f();
                        return;
                    }
                    loop0: while (true) {
                        z = false;
                        for (Campaign campaign : list) {
                            String id = campaign.getId();
                            if (campaign instanceof CampaignEx) {
                                CampaignEx campaignEx = (CampaignEx) campaign;
                                id = id + campaignEx.getVideoUrlEncode() + campaignEx.getBidToken();
                            }
                            com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.c.getInstance().a(NativeController.this.j, id);
                            if (aVarA != null && com.mbridge.msdk.videocommon.download.n.a(aVarA, NativeController.this.e().f())) {
                                z = true;
                            }
                        }
                        break loop0;
                    }
                    if (z) {
                        bVar.a();
                        NativeController.this.f();
                        return;
                    }
                    return;
                }
                bVar.a();
                NativeController.this.f();
            }
        }, 0L, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Timer timer = this.P;
        if (timer != null) {
            timer.cancel();
            this.P = null;
        }
    }

    public final String b() {
        return this.R;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Campaign> d(List<Campaign> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        for (Campaign campaign : list) {
            if (campaign instanceof CampaignEx) {
                CampaignEx campaignEx = (CampaignEx) campaign;
                if (TextUtils.isEmpty(this.Q) && TextUtils.isEmpty(campaignEx.getBidToken()) && !campaignEx.isBidCampaign()) {
                    arrayList2.add(campaignEx);
                } else if (!TextUtils.isEmpty(this.Q) && TextUtils.equals(campaignEx.getBidToken(), this.Q)) {
                    arrayList.add(campaign);
                }
            } else {
                arrayList2.add(campaign);
            }
        }
        return TextUtils.isEmpty(this.Q) ? arrayList2 : arrayList;
    }

    static /* synthetic */ void a(NativeController nativeController, CampaignEx campaignEx) {
        if (campaignEx.isReportClick()) {
            return;
        }
        campaignEx.setReportClick(true);
        if (campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().l() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(nativeController.i, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().l(), false, false);
    }

    static /* synthetic */ void a(NativeController nativeController, final CampaignEx campaignEx, View view, List list, AdSession adSession) {
        try {
            com.mbridge.msdk.mbnative.controller.a.InterfaceC0492a interfaceC0492a = new com.mbridge.msdk.mbnative.controller.a.InterfaceC0492a() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.9
                @Override // com.mbridge.msdk.mbnative.controller.a.InterfaceC0492a
                public final void a(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
                    if (arrayList == null || arrayList.size() <= 0) {
                        return;
                    }
                    com.mbridge.msdk.mbnative.d.b.a(campaignEx, NativeController.this.i, NativeController.this.j, NativeController.this.g);
                }
            };
            com.mbridge.msdk.mbnative.controller.a aVar = new com.mbridge.msdk.mbnative.controller.a(list, interfaceC0492a, new Handler(Looper.getMainLooper()), campaignEx.getImpReportType());
            aVar.a(view);
            List<com.mbridge.msdk.mbnative.controller.a> list2 = nativeController.G;
            if (list2 != null) {
                list2.add(aVar);
            }
            List<com.mbridge.msdk.mbnative.controller.a.InterfaceC0492a> list3 = nativeController.H;
            if (list3 != null) {
                list3.add(interfaceC0492a);
            }
            if (adSession != null) {
                AdEvents.createAdEvents(adSession).impressionOccurred();
            }
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void b(NativeController nativeController, List list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    try {
                        Class.forName("com.mbridge.msdk.nativex.view.MBMediaView");
                        Class.forName("com.mbridge.msdk.videocommon.download.c");
                        Class<?> cls = Class.forName("com.mbridge.msdk.videocommon.download.c");
                        Class<?> cls2 = Class.forName("com.mbridge.msdk.videocommon.listener.a");
                        Object objInvoke = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                        if (objInvoke != null) {
                            cls.getMethod("createUnitCache", Context.class, String.class, CopyOnWriteArrayList.class, Integer.TYPE, cls2).invoke(objInvoke, nativeController.i, nativeController.j, new CopyOnWriteArrayList(list), 1, null);
                            cls.getMethod("load", String.class).invoke(objInvoke, nativeController.j);
                        }
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            CampaignEx campaignEx = (CampaignEx) it.next();
                            if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getImageUrl())) {
                                com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).a(campaignEx.getImageUrl(), new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.3
                                    @Override // com.mbridge.msdk.foundation.same.c.c
                                    public final void onFailedLoad(String str, String str2) {
                                    }

                                    @Override // com.mbridge.msdk.foundation.same.c.c
                                    public final void onSuccessLoad(Bitmap bitmap, String str) {
                                    }
                                });
                            }
                            try {
                                Class.forName("com.mbridge.msdk.videocommon.download.g");
                                String str = campaignEx.getendcard_url();
                                if (!TextUtils.isEmpty(str)) {
                                    if (str.contains(".zip") && str.contains("md5filename")) {
                                        com.mbridge.msdk.videocommon.download.g.a().b(str, new g(nativeController.j, campaignEx, TextUtils.isEmpty(com.mbridge.msdk.videocommon.download.g.a().b(str))));
                                    } else {
                                        com.mbridge.msdk.videocommon.download.g.a().b(str, new d(nativeController.j, campaignEx, TextUtils.isEmpty(com.mbridge.msdk.videocommon.download.h.a().b(str))));
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Throwable unused2) {
                        aa.d(e, "please import the videocommon and nativex aar");
                    }
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }
    }

    static /* synthetic */ List a(NativeController nativeController, List list, boolean z) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                Campaign campaign = (Campaign) list.get(size);
                String id = campaign.getId();
                boolean z2 = campaign instanceof CampaignEx;
                if (z2) {
                    CampaignEx campaignEx = (CampaignEx) campaign;
                    id = id + campaignEx.getVideoUrlEncode() + campaignEx.getBidToken();
                }
                com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.c.getInstance().a(nativeController.j, id);
                if (z) {
                    if (aVarA == null || !com.mbridge.msdk.videocommon.download.n.a(aVarA, nativeController.e().f())) {
                        com.mbridge.msdk.mbnative.a.c.a(campaign.getType()).a(nativeController.j, (Campaign) list.remove(size), nativeController.Q);
                    }
                } else if (z2) {
                    CampaignEx campaignEx2 = (CampaignEx) campaign;
                    if (TextUtils.isEmpty(campaignEx2.getImageUrl()) && !TextUtils.isEmpty(campaignEx2.getVideoUrlEncode()) && (aVarA == null || !com.mbridge.msdk.videocommon.download.n.a(aVarA, nativeController.e().f()))) {
                        com.mbridge.msdk.mbnative.a.c.a(campaign.getType()).a(nativeController.j, (Campaign) list.remove(size), nativeController.Q);
                    }
                }
            }
        }
        return list;
    }
}
