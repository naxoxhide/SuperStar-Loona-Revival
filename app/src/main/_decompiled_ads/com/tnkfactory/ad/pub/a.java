package com.tnkfactory.ad.pub;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tapjoy.TapjoyConstants;
import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.Logger;
import com.tnkfactory.ad.pub.a.e1;
import com.tnkfactory.ad.pub.a.g;
import com.tnkfactory.ad.pub.a.i;
import com.tnkfactory.ad.pub.a.j;
import com.tnkfactory.ad.pub.a.t;
import com.tnkfactory.ad.pub.a.u;
import com.tnkfactory.ad.pub.a.y0;
import com.tnkfactory.ad.pub.model.EvtTrackUrls;
import com.tnkfactory.ad.pub.model.Vdo_iconUrls;
import com.tnkfactory.ad.pub.model.Vdo_iconsVO;
import com.tnkfactory.framework.vo.ValueObject;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public String A;
    public List<String> B;
    public List<String> C;
    public int D;
    public int E;
    public boolean F;
    public String G;
    public String H;
    public String I;
    public String K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public int P;
    public long R;
    public long S;
    public String T;
    public String U;
    public boolean V;
    public int W;
    public int X;
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2861b;
    public String c;
    public String d;
    public String e;
    public String g;
    public int h;
    public long i;
    public String j;
    public String k;
    public ArrayList<String> k0;
    public String l;
    public ArrayList<String> l0;
    public Vdo_iconUrls n0;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public float v;
    public String w;
    public String x;
    public String y;
    public String z;
    public int f = 5000;
    public int m = 0;
    public int n = 0;
    public JSONArray J = null;
    public long Q = 500;
    public int Z = 0;
    public int a0 = 0;
    public JSONObject b0 = null;
    public JSONObject c0 = null;
    public Map<String, t> d0 = new HashMap();
    public j e0 = null;
    public int f0 = 0;
    public EvtTrackUrls g0 = null;
    public ArrayList<Vdo_iconsVO> h0 = null;
    public String i0 = null;
    public String j0 = null;
    public g m0 = null;
    public long Y = System.currentTimeMillis();

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<java.lang.String, com.tnkfactory.ad.pub.a.t>] */
    public final Bitmap a() {
        t tVar = (t) this.d0.get(u.a("c77c0895e65f"));
        if (tVar != null) {
            return tVar.a;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<java.lang.String, com.tnkfactory.ad.pub.a.t>] */
    public final Bitmap b() {
        t tVar = (t) this.d0.get(u.a("c77c0c97fb5a"));
        if (tVar != null) {
            return tVar.a;
        }
        return null;
    }

    public final AdError c() {
        String str = this.f2861b;
        str.getClass();
        str.hashCode();
        switch (str) {
            case "S":
                return AdError.NO_ERROR;
            case "C1":
                return AdError.FAIL_NO_IMAGE;
            case "E1":
                return AdError.FAIL_INCORRECT_PLACEMENT;
            case "E2":
                return AdError.FAIL_NO_AD;
            case "E3":
                return AdError.FAIL_SCREEN_ORIENTATION;
            case "E4":
                return AdError.FAIL_TEST_DEVICE_NOT_REGISTERED;
            default:
                return AdError.FAIL_SYSTEM;
        }
    }

    /* JADX WARN: Code duplicated, block: B:211:0x06c7 A[Catch: Exception -> 0x075c, TryCatch #0 {Exception -> 0x075c, blocks: (B:197:0x06aa, B:199:0x06af, B:211:0x06c7, B:215:0x06d1, B:216:0x06d6, B:217:0x06d9), top: B:372:0x06aa }] */
    /* JADX WARN: Code duplicated, block: B:212:0x06cc  */
    /* JADX WARN: Code duplicated, block: B:214:0x06cf  */
    /* JADX WARN: Code duplicated, block: B:215:0x06d1 A[Catch: Exception -> 0x075c, TryCatch #0 {Exception -> 0x075c, blocks: (B:197:0x06aa, B:199:0x06af, B:211:0x06c7, B:215:0x06d1, B:216:0x06d6, B:217:0x06d9), top: B:372:0x06aa }] */
    /* JADX WARN: Code duplicated, block: B:254:0x072a A[Catch: Exception -> 0x0745, TryCatch #5 {Exception -> 0x0745, blocks: (B:219:0x06e1, B:221:0x06e5, B:254:0x072a, B:258:0x0733, B:259:0x0738, B:260:0x073b), top: B:382:0x06e1 }] */
    /* JADX WARN: Code duplicated, block: B:255:0x072f  */
    /* JADX WARN: Code duplicated, block: B:258:0x0733 A[Catch: Exception -> 0x0745, TryCatch #5 {Exception -> 0x0745, blocks: (B:219:0x06e1, B:221:0x06e5, B:254:0x072a, B:258:0x0733, B:259:0x0738, B:260:0x073b), top: B:382:0x06e1 }] */
    /* JADX WARN: Code duplicated, block: B:271:0x0779 A[Catch: Exception -> 0x07ab, TryCatch #1 {Exception -> 0x07ab, blocks: (B:269:0x0775, B:271:0x0779, B:273:0x077f, B:274:0x078a, B:276:0x0790, B:278:0x07a0), top: B:374:0x0775 }] */
    /* JADX WARN: Code duplicated, block: B:276:0x0790 A[Catch: Exception -> 0x07ab, TryCatch #1 {Exception -> 0x07ab, blocks: (B:269:0x0775, B:271:0x0779, B:273:0x077f, B:274:0x078a, B:276:0x0790, B:278:0x07a0), top: B:374:0x0775 }] */
    /* JADX WARN: Code duplicated, block: B:284:0x07c5  */
    /* JADX WARN: Code duplicated, block: B:285:0x07cb  */
    /* JADX WARN: Code duplicated, block: B:288:0x07d0 A[Catch: Exception -> 0x0821, TryCatch #10 {Exception -> 0x0821, blocks: (B:286:0x07cc, B:288:0x07d0, B:290:0x07d6, B:291:0x07e1, B:293:0x07e7, B:295:0x07f7, B:297:0x0804), top: B:392:0x07cc }] */
    /* JADX WARN: Code duplicated, block: B:293:0x07e7 A[Catch: Exception -> 0x0821, TryCatch #10 {Exception -> 0x0821, blocks: (B:286:0x07cc, B:288:0x07d0, B:290:0x07d6, B:291:0x07e1, B:293:0x07e7, B:295:0x07f7, B:297:0x0804), top: B:392:0x07cc }] */
    /* JADX WARN: Code duplicated, block: B:297:0x0804 A[Catch: Exception -> 0x0821, TRY_LEAVE, TryCatch #10 {Exception -> 0x0821, blocks: (B:286:0x07cc, B:288:0x07d0, B:290:0x07d6, B:291:0x07e1, B:293:0x07e7, B:295:0x07f7, B:297:0x0804), top: B:392:0x07cc }] */
    /* JADX WARN: Code duplicated, block: B:303:0x083a  */
    /* JADX WARN: Code duplicated, block: B:305:0x0842  */
    /* JADX WARN: Code duplicated, block: B:307:0x0852  */
    /* JADX WARN: Code duplicated, block: B:312:0x088c  */
    /* JADX WARN: Code duplicated, block: B:321:0x08e5  */
    /* JADX WARN: Code duplicated, block: B:325:0x08f6  */
    /* JADX WARN: Code duplicated, block: B:327:0x08fb  */
    /* JADX WARN: Code duplicated, block: B:329:0x0915  */
    /* JADX WARN: Code duplicated, block: B:332:0x0927  */
    /* JADX WARN: Code duplicated, block: B:337:0x094e  */
    /* JADX WARN: Code duplicated, block: B:344:0x097c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:345:0x097d A[Catch: Exception -> 0x0985, TRY_LEAVE, TryCatch #6 {Exception -> 0x0985, blocks: (B:342:0x096a, B:345:0x097d), top: B:384:0x096a }] */
    /* JADX WARN: Code duplicated, block: B:352:0x099e  */
    /* JADX WARN: Code duplicated, block: B:353:0x09a1  */
    /* JADX WARN: Code duplicated, block: B:356:0x09a8  */
    /* JADX WARN: Code duplicated, block: B:366:0x09c7  */
    /* JADX WARN: Code duplicated, block: B:374:0x0775 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:384:0x096a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:422:0x07a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:424:0x078a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:427:0x07f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:429:0x07e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:433:0x0879 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:434:0x0879 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:436:0x089a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:440:0x0886 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v111, types: [java.util.HashMap, java.util.Map<java.lang.String, com.tnkfactory.ad.pub.a.t>] */
    /* JADX WARN: Type inference failed for: r0v142, types: [java.util.HashMap, java.util.Map<java.lang.String, com.tnkfactory.ad.pub.a.t>] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r3v18, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r3v27, types: [java.util.HashMap, java.util.Map<java.lang.String, com.tnkfactory.ad.pub.a.t>] */
    /* JADX WARN: Type inference failed for: r3v49, types: [java.util.HashMap, java.util.Map<java.lang.String, com.tnkfactory.ad.pub.a.t>] */
    /* JADX WARN: Type inference failed for: r3v50, types: [java.util.HashMap, java.util.Map<java.lang.String, com.tnkfactory.ad.pub.a.t>] */
    /* JADX WARN: Type inference failed for: r3v53, types: [java.util.HashMap, java.util.Map<java.lang.String, com.tnkfactory.ad.pub.a.t>] */
    /* JADX WARN: Type inference failed for: r3v54, types: [java.util.HashMap, java.util.Map<java.lang.String, com.tnkfactory.ad.pub.a.t>] */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.util.HashMap, java.util.Map<java.lang.String, com.tnkfactory.ad.pub.a.t>] */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.util.HashMap, java.util.Map<java.lang.String, com.tnkfactory.ad.pub.a.t>] */
    /* JADX WARN: Type inference failed for: r5v16, types: [java.util.HashMap, java.util.Map<java.lang.String, com.tnkfactory.ad.pub.a.t>] */
    /* JADX WARN: Type inference failed for: r5v21, types: [java.util.HashMap, java.util.Map<java.lang.String, com.tnkfactory.ad.pub.a.t>] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.util.HashMap, java.util.Map<java.lang.String, com.tnkfactory.ad.pub.a.t>] */
    public final void a(Context context, ValueObject valueObject) throws Throwable {
        boolean z;
        JSONArray jSONArray;
        int length;
        int i;
        t tVar;
        JSONObject jSONObjectOptJSONObject;
        String strOptString;
        String str;
        JSONObject jSONObject;
        Iterator<String> itKeys;
        String next;
        String strOptString2;
        t tVar2;
        int i2;
        String str2;
        JSONObject jSONObject2;
        Iterator<String> itKeys2;
        String next2;
        String strOptString3;
        String str3;
        String str4;
        String str5;
        boolean z2;
        boolean z3;
        String str6;
        t tVar3;
        Bitmap bitmap;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        String str7;
        String str8;
        String strA;
        String str9;
        String str10;
        String strA2;
        String str11;
        if (valueObject.size() == 0) {
            this.a = true;
            this.f2861b = "E2";
            return;
        }
        String string = valueObject.getString(u.a("d47d15a9ea55"));
        this.f2861b = string;
        if (!"S".equals(string)) {
            this.a = true;
            return;
        }
        System.currentTimeMillis();
        this.c = valueObject.getString(u.a("c47105a9e055"));
        this.d = valueObject.getString(u.a("c574029dd6448367"));
        this.e = valueObject.getString(u.a("d56e13a9fc439d"));
        valueObject.getLong(u.a("d56e13a9e4589d67fa6c"));
        this.f = valueObject.getInt("ad_timeout");
        y0.a(context).a(this.K, this.f);
        this.K = valueObject.getString(u.a("d6740095ec6e986f"));
        this.L = valueObject.getInt(u.a("d6740095ec6e8572e37a"));
        this.M = valueObject.getInt(u.a("d6740095ec6e8262e97a6d47"));
        this.N = valueObject.getInt(u.a("c776089be8459864fd"));
        this.O = valueObject.getInt(u.a("c06d0d9afa52836ef671"), 1) == 1;
        this.P = valueObject.getInt(u.a("c479029dd65a9472"), 0);
        long j = valueObject.getLong(u.a("c5740895e26e956eff7e7d"), 0L);
        this.Q = j;
        if (j == 0) {
            this.Q = 500L;
        }
        this.R = valueObject.getInt(u.a("d47d10a9e7429468"));
        this.S = valueObject.getInt(u.a("d5700e81d65f826ef0"));
        this.D = valueObject.getInt(u.a("d07c0ea9fa459079e7"), 1);
        this.E = valueObject.getInt(u.a("d07c0ea9e444856e"), 0);
        int i3 = valueObject.getInt(u.a("d07c0ea9fb54866ae17b"), 0);
        this.X = i3;
        if (i3 == 1) {
            this.D = 1;
        }
        if (this.L == 4 && this.R == 0) {
            this.R = 30L;
        }
        this.V = valueObject.getInt(u.a("c47613a9ea5d9260cc7d704d"), 0) == 1;
        this.W = valueObject.getInt(u.a("c5740895e26e8572e37a"), 0);
        this.T = valueObject.getString(u.a("d6740095ec6e9d6aea707157"));
        this.U = valueObject.getString(u.a("d6740095ec6e9078e07a7050"));
        this.f0 = valueObject.getInt(u.a("c77c0ca9e55e906f"));
        y0.a(context).a(this.K, this.R);
        ValueObject valueObject2 = null;
        if (valueObject.size() < 2) {
            valueObject2 = valueObject2;
            break;
        }
        Map<String, String> map = u.a;
        int i4 = 1;
        while (true) {
            if (i4 >= valueObject.size()) {
                valueObject2 = valueObject2;
                break;
            }
            ValueObject rowAsVo = valueObject.getRowAsVo(i4);
            if (("N".equals(rowAsVo.getString(u.a("cf761282d6489f"), "Y")) && i.a(context, rowAsVo.getString(u.a("c76811a9f95a96")))) ? false : i.a(context, rowAsVo.getString(u.a("c7681185d65f9e7f")), rowAsVo.getString(u.a("c7681185d65e833a")), rowAsVo.getString(u.a("c7681185d65e8339")), rowAsVo.getString(u.a("c7681185d6509f6f")), rowAsVo.getInt(u.a("c96a50a9ea5f85"), 0), rowAsVo.getInt(u.a("c96a53a9ea5f85"), 0))) {
                valueObject2 = rowAsVo;
                break;
            } else {
                i4++;
                valueObject2 = valueObject2;
            }
        }
        if (valueObject2 == null || valueObject2.size() == 0) {
            this.a = true;
            this.f2861b = "E2";
            return;
        }
        this.g = valueObject2.getString(u.a("c77c17a9e055"));
        valueObject2.getString(u.a("c76811a9f95a96"));
        this.h = valueObject2.getInt(u.a("c77c3e82f04194"));
        this.i = valueObject2.getLong(u.a("d0790d9fed6e826ef0"), 3600L);
        this.j = valueObject2.getString(u.a("c77c17a9fc439d"));
        String string2 = valueObject2.getString(u.a("c77c0c"));
        this.k = string2;
        if (string2 != null) {
            this.q = valueObject2.getString(u.a("c77c0ca9ed5e9c6afa71"), "https://ads.tnkad.net");
        }
        this.l = valueObject2.getString(u.a("cf7506a9fc439d"));
        this.r = valueObject2.getString(u.a("cf7b0e98d6448367"));
        this.s = valueObject2.getString(u.a("c77c3e82e0459d6e"));
        this.t = valueObject2.getString(u.a("c77c3e92ec4292"));
        this.u = valueObject2.getString(u.a("c77c3e92ec429239"));
        this.v = valueObject2.getFloat(u.a("c77c3e84e8459865f4"));
        this.w = valueObject2.getString(u.a("c26f0fa9ea5f85"));
        this.o = valueObject2.getString(u.a("d07c0ea9fc439d"));
        valueObject2.getInt(u.a("d07c0ea9fa5a987b"));
        this.F = valueObject2.getInt(u.a("d07c0ea9ea509263f6"), 1) == 1;
        this.p = valueObject2.getString(u.a("df771482fc539454fa7b"));
        this.x = valueObject2.getString(u.a("c77c17a9e75c"));
        valueObject2.getString(u.a("c77c17a9e55e9664"));
        this.y = valueObject2.getString(u.a("c56c00a9e550936eff"));
        this.A = valueObject2.getString(u.a("c77c0c97fb5aae7ee173"));
        this.z = valueObject2.getString(u.a("d6770d9fea48ae7ee173"));
        Object obj = valueObject2.get(u.a("cf7511a9fd439068f840715132ea"));
        this.i0 = valueObject2.getString("vdo_skip_offset");
        this.j0 = valueObject2.getString("vdo_error_url");
        valueObject2.getString("vdo_duration");
        if (obj instanceof String) {
            ArrayList arrayList = new ArrayList();
            this.B = arrayList;
            arrayList.add(obj.toString());
        } else if (obj instanceof String[]) {
            this.B = new ArrayList();
            for (String str12 : (String[]) obj) {
                this.B.add(str12);
            }
        } else if (obj instanceof List) {
            this.B = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                this.B.add(String.valueOf(it.next()));
            }
        } else if (obj instanceof Object[]) {
            this.B = new ArrayList();
            for (Object obj2 : (Object[]) obj) {
                this.B.add(String.valueOf(obj2));
            }
        } else {
            this.B = valueObject2;
        }
        Object obj3 = valueObject2.get(u.a("c574029dd645836af0745b562cf526"));
        if (obj3 instanceof String) {
            ArrayList arrayList2 = new ArrayList();
            this.C = arrayList2;
            arrayList2.add(obj3.toString());
        } else if (obj3 instanceof String[]) {
            this.C = new ArrayList();
            for (String str13 : (String[]) obj3) {
                this.C.add(str13);
            }
        } else if (obj3 instanceof List) {
            this.C = new ArrayList();
            Iterator it2 = ((List) obj3).iterator();
            while (it2.hasNext()) {
                this.C.add(String.valueOf(it2.next()));
            }
        } else if (obj3 instanceof Object[]) {
            this.C = new ArrayList();
            for (Object obj4 : (Object[]) obj3) {
                this.C.add(String.valueOf(obj4));
            }
        } else {
            this.C = valueObject2;
        }
        this.G = valueObject2.getString(u.a("c77c3e9ae8489e7ee7"));
        this.H = valueObject2.getString(u.a("c77c3e97fa42947fe0"));
        this.I = valueObject2.getString(u.a("c77c3e86e85694"));
        ValueObject valueObject3 = (ValueObject) valueObject2.get("evt_track_urls");
        String str14 = "add";
        if (valueObject3 != null) {
            EvtTrackUrls evtTrackUrls = new EvtTrackUrls();
            this.g0 = evtTrackUrls;
            try {
                for (Map<String, Object> map2 : valueObject3) {
                    try {
                        for (String str15 : map2.keySet()) {
                            if (!str15.equals("icon_click_tracking_url") && !str15.equals("icon_view_tracking_url")) {
                                Method method = EvtTrackUrls.class.getMethod("add" + str15, String.class);
                                if (method != null) {
                                    method.invoke(evtTrackUrls, map2.get(str15));
                                }
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ValueObject valueObject4 = (ValueObject) valueObject2.get("vdo_icons");
        if (valueObject4 != null) {
            this.h0 = new ArrayList<>();
            for (int i5 = 0; i5 < valueObject4.size(); i5++) {
                Vdo_iconsVO vdo_iconsVO = new Vdo_iconsVO();
                vdo_iconsVO.parser((HashMap) valueObject4.get(i5));
                this.h0.add(vdo_iconsVO);
            }
        }
        if (valueObject4 != null) {
            Vdo_iconUrls vdo_iconUrls = new Vdo_iconUrls();
            this.n0 = vdo_iconUrls;
            try {
                for (Map<String, Object> map3 : valueObject4) {
                    try {
                        for (String str16 : map3.keySet()) {
                            if (!str16.equals("icon_click_tracking_url") && !str16.equals("icon_view_tracking_url")) {
                                str11 = str14;
                                try {
                                    Method method2 = Vdo_iconUrls.class.getMethod(str14 + str16, String.class);
                                    if (method2 != null) {
                                        method2.invoke(vdo_iconUrls, map3.get(str16));
                                    }
                                    str14 = str11;
                                } catch (Exception unused2) {
                                    str14 = str11;
                                }
                            }
                        }
                    } catch (Exception unused3) {
                        str11 = str14;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (valueObject4 != null && valueObject4.size() != 0) {
            Object obj5 = valueObject4.get("icon_click_tracking_url");
            if (obj5 instanceof String) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                this.l0 = arrayList3;
                arrayList3.add(obj5.toString());
            } else if (obj5 instanceof String[]) {
                this.l0 = new ArrayList<>();
                for (String str17 : (String[]) obj5) {
                    this.l0.add(str17);
                }
            } else if (obj5 instanceof List) {
                this.l0 = new ArrayList<>();
                Iterator it3 = ((List) obj5).iterator();
                while (it3.hasNext()) {
                    this.l0.add(String.valueOf(it3.next()));
                }
            } else if (obj5 instanceof Object[]) {
                this.l0 = new ArrayList<>();
                for (Object obj6 : (Object[]) obj5) {
                    this.l0.add(String.valueOf(obj6));
                }
            }
        }
        if (valueObject4 != null && valueObject4.size() != 0) {
            Object obj7 = valueObject4.get("icon_view_tracking_url");
            if (obj7 instanceof String) {
                ArrayList<String> arrayList4 = new ArrayList<>();
                this.k0 = arrayList4;
                arrayList4.add(obj7.toString());
            } else if (obj7 instanceof String[]) {
                this.k0 = new ArrayList<>();
                for (String str18 : (String[]) obj7) {
                    this.k0.add(str18);
                }
            } else if (obj7 instanceof List) {
                this.k0 = new ArrayList<>();
                Iterator it4 = ((List) obj7).iterator();
                while (it4.hasNext()) {
                    this.k0.add(String.valueOf(it4.next()));
                }
            } else if (obj7 instanceof Object[]) {
                this.l0 = new ArrayList<>();
                for (Object obj8 : (Object[]) obj7) {
                    this.l0.add(String.valueOf(obj8));
                }
            }
        }
        this.m0 = new g(valueObject2);
        String str19 = this.I;
        if (str19 != null && str19.length() > 0) {
            try {
                this.J = new JSONArray(this.I);
            } catch (Exception e3) {
                Logger.e(com.tnkfactory.ad.pub.a.a.a("error #a005 : ").append(e3.toString()).toString());
            }
        }
        try {
            try {
                if (this.T == null) {
                    int i6 = this.L;
                    if (i6 == 0) {
                        str9 = "dd3a0892ab0bd36ce67660467cb577a493ca065b7e07c4880958a26a5da9e43b3d41cb54eede58fa0f34860faf570a066ccaaa8dc7b40d1c4edf06fa5d5e88663a29b6be447cbada0809bb1c74f9b4983f66c31ac516274562b217f825453e4b8e925f11b91c41dc354553ea7835ac78c92052b9ac65d574b49f977f534a42193fb0f27258b8e63d0fca650e8308afe83f4b1a7e39a1b32e02c2b2573f75eb480bce83317ebd34771acc1758916ef8c07438d2401437580dc0dd7f43710f395b0dfa6f3e37b4e627c62152713691bdfd17d1a0f3624bb7c0da41a277fc03fab3d53796f985ec5bae223bb0e89ff8798fa124828cc4118fa632abe7649e58782476ccea82740dcb5ac1d80d2d32a53b82c030ef42fad46f960c84ce2825aadb7615a61a4ce854183da2ec379a0ddf3c314115c60014e8293b";
                    } else {
                        if (i6 != 1) {
                            if (i6 == 4 || i6 == 5) {
                                str9 = "dd3a0892ab0bd36ce67660467cb577a493ca065b7e07c4880958a26a5da9e43b3d41cb54eede58fa0f34860faf570a066ccaaa8dc7b40d1c4edf06fa5d5e88663a29b6be447cbaab0e";
                            } else {
                                str10 = null;
                            }
                            if (str10 != null) {
                                strA2 = u.a(str10);
                            } else {
                                strA2 = null;
                            }
                            if (strA2 == null) {
                                jSONObject3 = new JSONObject(strA2);
                            }
                            z = false;
                            if (z) {
                                try {
                                    str2 = this.U;
                                    if (str2 != null && str2.length() > 0) {
                                        jSONObject2 = new JSONObject(this.U);
                                        itKeys2 = jSONObject2.keys();
                                        while (itKeys2.hasNext()) {
                                            next2 = itKeys2.next();
                                            strOptString3 = jSONObject2.optString(next2);
                                            if (strOptString3.length() > 0) {
                                                this.d0.put(next2, new t(context, strOptString3));
                                            }
                                        }
                                    }
                                } catch (Exception e4) {
                                    Logger.e(com.tnkfactory.ad.pub.a.a.a("error #a001 : ").append(e4.toString()).toString());
                                }
                                jSONArray = this.J;
                                if (jSONArray != null) {
                                    length = jSONArray.length();
                                } else {
                                    length = 0;
                                }
                                try {
                                    str = this.H;
                                    if (str != null && str.length() > 0) {
                                        jSONObject = new JSONObject(this.H);
                                        itKeys = jSONObject.keys();
                                        while (itKeys.hasNext()) {
                                            next = itKeys.next();
                                            strOptString2 = jSONObject.optString(next);
                                            if (strOptString2.length() > 0) {
                                                tVar2 = new t(context, strOptString2);
                                                this.d0.put(next, tVar2);
                                                for (i2 = 0; i2 < length; i2++) {
                                                    this.d0.put(next + "_" + i2, tVar2);
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e5) {
                                    Logger.e(com.tnkfactory.ad.pub.a.a.a("error #a003 : ").append(e5.toString()).toString());
                                }
                                for (i = 0; i < length; i++) {
                                    jSONObjectOptJSONObject = this.J.optJSONObject(i);
                                    if (jSONObjectOptJSONObject != null) {
                                        strOptString = jSONObjectOptJSONObject.optString(u.a("d6710c97ee54"));
                                        if (strOptString.length() > 0) {
                                            this.d0.put(u.a("d6710c97ee54") + "_" + Integer.valueOf(i), new t(context, strOptString));
                                        }
                                    }
                                }
                                for (String str20 : this.d0.keySet()) {
                                    if (!str20.contains("close") && ((tVar = (t) this.d0.get(str20)) == null || tVar.a == null)) {
                                        Drawable drawable = context.getResources().getDrawable(R.drawable.btn_close_shape);
                                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                                        Canvas canvas = new Canvas(bitmapCreateBitmap);
                                        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                                        drawable.draw(canvas);
                                        this.d0.put(str20, new t(bitmapCreateBitmap));
                                    }
                                }
                            }
                            str3 = this.l;
                            if (str3 != null && str3.length() > 0) {
                                tVar3 = new t(context, this.l);
                                if (tVar3.a == null) {
                                    this.a = true;
                                    this.f2861b = "C1";
                                    return;
                                }
                                this.d0.put(u.a("c77c089be85694"), tVar3);
                                this.d0.put(u.a("c77c089be8569439"), tVar3);
                                bitmap = tVar3.a;
                                if (bitmap != null) {
                                    this.m = bitmap.getWidth();
                                    this.n = tVar3.a.getHeight();
                                }
                            }
                            str4 = this.r;
                            if (str4 != null && str4.length() > 0) {
                                t tVar4 = new t(context, this.r);
                                this.d0.put(u.a("c77c0895e65f"), tVar4);
                                this.d0.put(u.a("c77c0895e65fc3"), tVar4);
                            }
                            str5 = this.A;
                            if (str5 != null && str5.length() > 0) {
                                this.d0.put(u.a("c77c0c97fb5a"), new t(context, this.A));
                            }
                            if (this.D != 1) {
                                try {
                                    WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService(TapjoyConstants.TJC_CONNECTION_TYPE_WIFI)).getConnectionInfo();
                                    z2 = connectionInfo == null && connectionInfo.getIpAddress() != 0;
                                } catch (Exception e6) {
                                    Logger.e(com.tnkfactory.ad.pub.a.a.a("error #f006 : ").append(e6.toString()).toString());
                                }
                                if (z2) {
                                    this.D = 1;
                                } else {
                                    this.F = false;
                                }
                            }
                            if (this.F || (str6 = this.o) == null) {
                                z3 = false;
                            } else {
                                String strB = e1.b(context, str6);
                                if (strB == null) {
                                    this.a = true;
                                    this.f2861b = "C1";
                                    return;
                                } else if (strB.equals("")) {
                                    z3 = false;
                                    this.F = false;
                                } else {
                                    z3 = false;
                                    this.o = strB;
                                }
                            }
                            this.a = z3;
                        }
                        str9 = "dd3a0892ab0bd36ce67660467cb577a493ca065b7e07c4880958a26a5da9e43b3d41cb54eede58fa0f34860faf570a066ccaaa8dc7b40d1c4edf06fa5d5e88663a29b6be447cbada0809bb1c74f9b4983f66c31ac516274562b217f825453e4b8e925f11b91c41dc354553ea7835ac78cc3c5ce9bf70c872f9879c625d1c530433e6ea6a22c2e83359db7802a834a3eb3c564a6621b3fb3002c2b2573f75eb0c05c0d52063b11f5b00df081f8976e8c2202c804e1a775d35edc065587b49215314f42f3b0f98e121db255c362e89afb509d1a0f3624bb7c0905cf763ae0df4f3d00faaf586ef46fe3a23a2a081f82f8fa124828cd61f81e53faee96dd24060742894bc8c7a42c749d4d60a612abd299eda65af0abd9c2e8a58d6ce3a74e5986913e54c18e64c4872f4e43b80468a70701758d60959e611645508a3";
                    }
                    str10 = str9;
                    if (str10 != null) {
                        strA2 = u.a(str10);
                    } else {
                        strA2 = null;
                    }
                    if (strA2 == null) {
                        jSONObject3 = new JSONObject(strA2);
                    }
                    z = false;
                    if (z) {
                        str2 = this.U;
                        if (str2 != null) {
                            jSONObject2 = new JSONObject(this.U);
                            itKeys2 = jSONObject2.keys();
                            while (itKeys2.hasNext()) {
                                next2 = itKeys2.next();
                                strOptString3 = jSONObject2.optString(next2);
                                if (strOptString3.length() > 0) {
                                    this.d0.put(next2, new t(context, strOptString3));
                                }
                            }
                        }
                        jSONArray = this.J;
                        if (jSONArray != null) {
                            length = jSONArray.length();
                        } else {
                            length = 0;
                        }
                        str = this.H;
                        if (str != null) {
                            jSONObject = new JSONObject(this.H);
                            itKeys = jSONObject.keys();
                            while (itKeys.hasNext()) {
                                next = itKeys.next();
                                strOptString2 = jSONObject.optString(next);
                                if (strOptString2.length() > 0) {
                                    tVar2 = new t(context, strOptString2);
                                    this.d0.put(next, tVar2);
                                    while (i2 < length) {
                                        this.d0.put(next + "_" + i2, tVar2);
                                    }
                                }
                            }
                        }
                        while (i < length) {
                            jSONObjectOptJSONObject = this.J.optJSONObject(i);
                            if (jSONObjectOptJSONObject != null) {
                                strOptString = jSONObjectOptJSONObject.optString(u.a("d6710c97ee54"));
                                if (strOptString.length() > 0) {
                                    this.d0.put(u.a("d6710c97ee54") + "_" + Integer.valueOf(i), new t(context, strOptString));
                                }
                            }
                        }
                        while (r0.hasNext()) {
                            if (!str20.contains("close")) {
                            }
                        }
                    }
                    str3 = this.l;
                    if (str3 != null) {
                        tVar3 = new t(context, this.l);
                        if (tVar3.a == null) {
                            this.a = true;
                            this.f2861b = "C1";
                            return;
                        }
                        this.d0.put(u.a("c77c089be85694"), tVar3);
                        this.d0.put(u.a("c77c089be8569439"), tVar3);
                        bitmap = tVar3.a;
                        if (bitmap != null) {
                            this.m = bitmap.getWidth();
                            this.n = tVar3.a.getHeight();
                        }
                    }
                    str4 = this.r;
                    if (str4 != null) {
                        t tVar5 = new t(context, this.r);
                        this.d0.put(u.a("c77c0895e65f"), tVar5);
                        this.d0.put(u.a("c77c0895e65fc3"), tVar5);
                    }
                    str5 = this.A;
                    if (str5 != null) {
                        this.d0.put(u.a("c77c0c97fb5a"), new t(context, this.A));
                    }
                    if (this.D != 1) {
                        WifiInfo connectionInfo2 = ((WifiManager) context.getApplicationContext().getSystemService(TapjoyConstants.TJC_CONNECTION_TYPE_WIFI)).getConnectionInfo();
                        if (connectionInfo2 == null) {
                            if (z2) {
                                this.D = 1;
                            } else {
                                this.F = false;
                            }
                        }
                        if (z2) {
                            this.D = 1;
                        } else {
                            this.F = false;
                        }
                    }
                    if (this.F) {
                        z3 = false;
                    } else {
                        z3 = false;
                    }
                    this.a = z3;
                }
                jSONObject3 = new JSONObject(this.T);
                if (this.G == null) {
                    int i7 = this.h;
                    int i8 = this.L;
                    if (i7 == 1) {
                        str7 = (i8 == 1 || i8 == 0) ? "dd3a158ff954d331b173655a31ec21f2c69800112d49cccb4a6cac3c16e1e4627749c359a18564e40f71c059ec050c4b389ca68ed2f1441c168405fc1e08cf286160f5e9513db39f1c45f04274a0fa893f618e148c5c270024e454aa210369089e8c0949f4061a80721000ac6530ef25982e5ce9ba78d86ffe879c71430e431169beea2261eea37059952c56fe0aaced37571a7e39fde72a4688f6423a72e10f05d6c67824a808701ad91c58916ea69f7727d2116b28" : "dd3a158ff954d331b173655a31ec21f2c69800112d49cccb4a6cac3c16e1e4627749c359a18564e40f71c059ec050c4b389ca68ed2f1441c168405fc1e08cf286160f5e9513db39f1c45f04274a0fa893f618e148c5c270024e454aa210369089e8c0949f4061a80721000ac6530ef25982e5ce9ba78d86ffe879c71400e431169beea2261eea37059952c56fe0aaced37571a7e39e3e73c4688f6423a72e10f05d6c67824a808701ad91c58916ea69f7727d2116b28";
                    } else if (i7 == 3) {
                        str7 = (i8 == 1 || i8 == 0) ? "dd3a158ff954d331b173655a31ec21f2c698011e1b46c7851f45f5245db5be3e33189700fcd433a3017f8145fc190d4b38e5b4c1daf2030418c712e91600cf65797cfbbf492ea2d44909a41132a6f9c22126d74bc943275362a70ae123086a4bc0c55f1ca61741ca355b57ef6b38ac6edf7b19afb9799e21a4958a71035f530824b0f2612cb8b97c1ac37858e65aeca63155512375b3f16a0888a0137531e00b558b9e3a24f3493543d202569a7cae803c79c00846790f709e9069417c5d5c1b4ead633d4afdb06dcd3a152e20c8afec1595fcb76549a5cf821ca325f20daca8c20dd7accbf74cf46c3bacb28ef72dcbf9368891d7118faf3babe762c84060676a94eada3318de77c5de0f607aa5318cc62cf908abd679dc5ac0c02674bddf6204db5314be135b64f4b460905fc73270591fcd1169e10d364d77e4322cf7a0496b7757565cefae8b2984a164353aad65a1b5999b7d4bfe4a762255455d530978d4ec4473cb68efd994d94ff88dadcf81d97878b330ef821831e0b1d74f855986c26fdef35efb013a70e05fdae865399faa296e6389e83deddb4657b3b4fdaaaa209fbbfe9be6ca745843301d2c42ebfd8db60e70687c0dcfab88da150416deb889ae6a1e953a9ec19b7346e0cd089f67b18dc3139e89ae9ed93188902d7ecc069d03676529ae9ee0f4297e59ac7f19252290211bb0743bf4cb2efe354cf3b7bb4c44a824e80bc0f854d6e72cf94f030d8966609842597077826991d816e010824da8d9a05a7daae5342e5b7bed8833932d32c53d5b85d33ccac3b33ca5d4a2e7c280ec7be03ef8c8f09632d786a6fbdf62134fcddea73b58926d0871612a1bbd03d1ce6e85082d6a7ea4e25f52506f63bb18e2255d0a3555af646a66be61a140d5347d82498856db8415b439200ac19a2e7d5e48b3305284d9b7aaeefb2b39b91df0708dbc0cc566019d362dad658d7fb868767060c520a8cf4f3cc823c625dd1024ea5acdb07d8a400daef4a9c5b51c1250e610c552e126ee9bc831d3e3513b820e3adf28c49cb363ac2bf72d4fc01295fa02c2f36a008a4aa3e5254281d6987ebc918347256afffbc9f610feb790d7a20b4223f66824214a7ac945bfa24b49a5943dfc9978432c4f5644080575c26a2a5d49e45214800cca81f7b41c544b955d7b2a9c77fceb6257c528fa04939d21c008" : "dd3a158ff954d331b173655a31ec21f2c69800112d49cccb4a6cac3c16e1e4627749c346a58066ee0f71c059ec050c4b389cb98ad7f34e1c478a0dbd160088307931bda6512cacd45f09a60126a6b4da7e63c108c742274562b107ec340f2653ced61b01a6504fd265534ee7637fb473d12e11a7a476d239ac87d47f051c0b4338f1a93c65b8f02e578d7c19a802afea72031a2874f6a46a19f9a9";
                    } else if (i7 == 4) {
                        str7 = (i8 == 1 || i8 == 0) ? "dd3a158ff954d331b173655a31ec21f2c69800112d49cccb4a6cac3c16e1e4627749c358b8896fa3017f9654e5104b5320c9aa8191eb0d4518cf12bd4546cb6e3631aba01272e5820a5bb75a6ce1ff8d3d6dc94b8c05720024b206aa7a45365988970949f40002847e5d18b43d71ac23916517a5ef2b9e77bac7847f534d440027f7ea6a31b6e87e18db7415b249faa63c565f2b39ec9635" : "dd3a158ff954d331b173655a31ec21f2c69800112d49cccb4a6cac3c16e1e4627749c358b8896fa3017f9654e5104b5320c9aa8191eb0d4518cf12bd4546cb6e3631aba01272e5820a5bb75a6ce1ff8d3d6dc94b8c05720024b206aa7a45355988970949f40002847e5d18b43d71ac23916517a5ef2b9e69bad1847f534d440027f7ea6a31b6e87e18db7415b249faa63c565f2b39ec9635";
                    } else {
                        if (i7 != 5) {
                            if (i7 != 6) {
                                str8 = null;
                            } else {
                                str7 = (i8 == 1 || i8 == 0) ? "dd3a158ff954d331b173655a31ec21f2c698011e1b46c7851f45f5245db5be3e33189700fcd433a3017f8145fc190d4b38e5b4c1daf2030418c712e61011de7f3935fbe7122abe861609e85a2face3942968c94b8c05720d29b206aa7a563459c0c55904a21b0cd22d0214bb3a6fbb6edf6d1ca2aa7f9e21b4c6842e5d4505082fb0f27261fea37c14c13f56fe1fb9f4351b026672fcaa2f0186f8132e7ae91e4fcecd6636e5497612c21b158976fbdc323b930d5a301d68839e284c7944640703e22f3544b3b0798b2756216bdae3a74b95f7a5605dfd97c614b62bef1fbca19e58d7bacbe045e56846f2ff8cf02d9dab368ad8961fd0eb25e0e96e9e5878373ecca1da3a05880484c51a7f6da5318c8231e71aef9c3dcd55c2966274f3972b5ca64818ad11112af4bf69c403c76a37550eea0659f91b340a6ffc2036b3ea0d7f7856584e92edcf7fdbfb710e20a770aab58f9b2d1ff35d3a2c4d134a0709058cb753648824a4cfcfd757bbdde68598e76579f864efd95e68afef8909d957d29e62c9b14df147387ee9518de86b2fdce6627b7ecfb77fb7d54818a6bfeaa6e63887edabcfa3d83c0a186c493c5ae5f690e352707d351f8aaa98da150b4596fe98b87148e67b85d4846446e0cd4c8279a3c989578f86acc89d31c6d86426b11d9110652f67ae95fba2757e01eb6508162e886f4ee03765bf9839f67106b7b6af4b54e37cb35d9fb119a5b628e258465ec5756cde034b3825cc3999c74df01ac45ce080e1483ff3eb7f2d0b20b98023897b69d62855d3c72ddd86e070e59bf4a29d8abe7bf732ed8da5ce228590b4ec922a184f8898e46d139467493f226a1bf755849c66c640686165f2ac120e422731ff4da770051a6743bf613e72ec6faf03d72c7d8a498856db8555b578670a80d9287f4f52ce691fda86a1f8f8e93773ef1fe63ad9ea0ed366019d232ba178bd62f3283131368e72fb89133c9064ca34fa0714f541c6fe228a4a57aab0e381b11d2b55ab508854a664b8f4c33ecfb6433997593797689ed6f727fb64bb160e9616d5e40291b52a188409a5ef1b538598db2eead2d1127f36bba294af40fda090c5ad044067ac7d26674a68d019e6ac005fe6da76f2df2f137206150443166290352a0b47ef1d59c51a8bccb9a6570a0ed15d206bda2ef7f56241c536f41795d07ea744956519196390346a85bf8973c8651a598390d2b111fb0c6d4953c4105a7a8f753ca8f81c4f0a3582f318e0" : "dd3a158ff954d331b173655a31ec21f2c69800112d49cccb4a6cac3c16e1e4627749c349a39177f44f38c001b7011019679cf5c1caf9544a4fc413bd0248d1283234fbf1123fa39b1259b95a7ae1e2992c6f8e53824e680827a34ca462106d0d988f095ff4435394671016ac7e3cfa2b922e4afae133dd77ffc2c8714b1c554d3fb0e47273f9ab731e8d274bf049a1e72450572a39abe9240bc3bb13244ef0";
                            }
                            if (str8 != null) {
                                strA = u.a(str8);
                            } else {
                                strA = null;
                            }
                            if (strA != null) {
                                jSONObject4 = new JSONObject(strA);
                            }
                            z = false;
                            if (z) {
                                str2 = this.U;
                                if (str2 != null) {
                                    jSONObject2 = new JSONObject(this.U);
                                    itKeys2 = jSONObject2.keys();
                                    while (itKeys2.hasNext()) {
                                        next2 = itKeys2.next();
                                        strOptString3 = jSONObject2.optString(next2);
                                        if (strOptString3.length() > 0) {
                                            this.d0.put(next2, new t(context, strOptString3));
                                        }
                                    }
                                }
                                jSONArray = this.J;
                                if (jSONArray != null) {
                                    length = jSONArray.length();
                                } else {
                                    length = 0;
                                }
                                str = this.H;
                                if (str != null) {
                                    jSONObject = new JSONObject(this.H);
                                    itKeys = jSONObject.keys();
                                    while (itKeys.hasNext()) {
                                        next = itKeys.next();
                                        strOptString2 = jSONObject.optString(next);
                                        if (strOptString2.length() > 0) {
                                            tVar2 = new t(context, strOptString2);
                                            this.d0.put(next, tVar2);
                                            while (i2 < length) {
                                                this.d0.put(next + "_" + i2, tVar2);
                                            }
                                        }
                                    }
                                }
                                while (i < length) {
                                    jSONObjectOptJSONObject = this.J.optJSONObject(i);
                                    if (jSONObjectOptJSONObject != null) {
                                        strOptString = jSONObjectOptJSONObject.optString(u.a("d6710c97ee54"));
                                        if (strOptString.length() > 0) {
                                            this.d0.put(u.a("d6710c97ee54") + "_" + Integer.valueOf(i), new t(context, strOptString));
                                        }
                                    }
                                }
                                while (r0.hasNext()) {
                                    if (!str20.contains("close")) {
                                    }
                                }
                            }
                            str3 = this.l;
                            if (str3 != null) {
                                tVar3 = new t(context, this.l);
                                if (tVar3.a == null) {
                                    this.a = true;
                                    this.f2861b = "C1";
                                    return;
                                }
                                this.d0.put(u.a("c77c089be85694"), tVar3);
                                this.d0.put(u.a("c77c089be8569439"), tVar3);
                                bitmap = tVar3.a;
                                if (bitmap != null) {
                                    this.m = bitmap.getWidth();
                                    this.n = tVar3.a.getHeight();
                                }
                            }
                            str4 = this.r;
                            if (str4 != null) {
                                t tVar6 = new t(context, this.r);
                                this.d0.put(u.a("c77c0895e65f"), tVar6);
                                this.d0.put(u.a("c77c0895e65fc3"), tVar6);
                            }
                            str5 = this.A;
                            if (str5 != null) {
                                this.d0.put(u.a("c77c0c97fb5a"), new t(context, this.A));
                            }
                            if (this.D != 1) {
                                WifiInfo connectionInfo3 = ((WifiManager) context.getApplicationContext().getSystemService(TapjoyConstants.TJC_CONNECTION_TYPE_WIFI)).getConnectionInfo();
                                if (connectionInfo3 == null) {
                                    if (z2) {
                                        this.D = 1;
                                    } else {
                                        this.F = false;
                                    }
                                }
                                if (z2) {
                                    this.D = 1;
                                } else {
                                    this.F = false;
                                }
                            }
                            if (this.F) {
                                z3 = false;
                            } else {
                                z3 = false;
                            }
                            this.a = z3;
                        }
                        str7 = "dd3a158ff954d331b173655a31ec21f2c69800112d49cccb4a6cac3c16e1e4627749c35dbe856ae50f71c059ec050c4b389ca291d2ff451c478a0dbd160088307931bda6512cacd45f09a60126a6b4da7e63c108c742274562b107ec340f2653ced51b01a6504fd265534ee7637fb473d12e11a7a476d239ac87ca7f131c0b4338f1a93c65b8f02e578d7c19a802afea72031a2874f6a46a19f9a9";
                    }
                    str8 = str7;
                    if (str8 != null) {
                        strA = u.a(str8);
                    } else {
                        strA = null;
                    }
                    if (strA != null) {
                        jSONObject4 = new JSONObject(strA);
                    }
                    z = false;
                    if (z) {
                        str2 = this.U;
                        if (str2 != null) {
                            jSONObject2 = new JSONObject(this.U);
                            itKeys2 = jSONObject2.keys();
                            while (itKeys2.hasNext()) {
                                next2 = itKeys2.next();
                                strOptString3 = jSONObject2.optString(next2);
                                if (strOptString3.length() > 0) {
                                    this.d0.put(next2, new t(context, strOptString3));
                                }
                            }
                        }
                        jSONArray = this.J;
                        if (jSONArray != null) {
                            length = jSONArray.length();
                        } else {
                            length = 0;
                        }
                        str = this.H;
                        if (str != null) {
                            jSONObject = new JSONObject(this.H);
                            itKeys = jSONObject.keys();
                            while (itKeys.hasNext()) {
                                next = itKeys.next();
                                strOptString2 = jSONObject.optString(next);
                                if (strOptString2.length() > 0) {
                                    tVar2 = new t(context, strOptString2);
                                    this.d0.put(next, tVar2);
                                    while (i2 < length) {
                                        this.d0.put(next + "_" + i2, tVar2);
                                    }
                                }
                            }
                        }
                        while (i < length) {
                            jSONObjectOptJSONObject = this.J.optJSONObject(i);
                            if (jSONObjectOptJSONObject != null) {
                                strOptString = jSONObjectOptJSONObject.optString(u.a("d6710c97ee54"));
                                if (strOptString.length() > 0) {
                                    this.d0.put(u.a("d6710c97ee54") + "_" + Integer.valueOf(i), new t(context, strOptString));
                                }
                            }
                        }
                        while (r0.hasNext()) {
                            if (!str20.contains("close")) {
                            }
                        }
                    }
                    str3 = this.l;
                    if (str3 != null) {
                        tVar3 = new t(context, this.l);
                        if (tVar3.a == null) {
                            this.a = true;
                            this.f2861b = "C1";
                            return;
                        }
                        this.d0.put(u.a("c77c089be85694"), tVar3);
                        this.d0.put(u.a("c77c089be8569439"), tVar3);
                        bitmap = tVar3.a;
                        if (bitmap != null) {
                            this.m = bitmap.getWidth();
                            this.n = tVar3.a.getHeight();
                        }
                    }
                    str4 = this.r;
                    if (str4 != null) {
                        t tVar7 = new t(context, this.r);
                        this.d0.put(u.a("c77c0895e65f"), tVar7);
                        this.d0.put(u.a("c77c0895e65fc3"), tVar7);
                    }
                    str5 = this.A;
                    if (str5 != null) {
                        this.d0.put(u.a("c77c0c97fb5a"), new t(context, this.A));
                    }
                    if (this.D != 1) {
                        WifiInfo connectionInfo4 = ((WifiManager) context.getApplicationContext().getSystemService(TapjoyConstants.TJC_CONNECTION_TYPE_WIFI)).getConnectionInfo();
                        if (connectionInfo4 == null) {
                            if (z2) {
                                this.D = 1;
                            } else {
                                this.F = false;
                            }
                        }
                        if (z2) {
                            this.D = 1;
                        } else {
                            this.F = false;
                        }
                    }
                    if (this.F) {
                        z3 = false;
                    } else {
                        z3 = false;
                    }
                    this.a = z3;
                }
                jSONObject4 = new JSONObject(this.G);
                this.b0 = jSONObject4;
                z = true;
            } catch (Exception e7) {
                Logger.e(com.tnkfactory.ad.pub.a.a.a("error #a004 : ").append(e7.toString()).toString());
            }
            this.c0 = jSONObject3;
        } catch (Exception e8) {
            Logger.e(com.tnkfactory.ad.pub.a.a.a("error #a002 : ").append(e8.toString()).toString());
        }
        if (z) {
            str2 = this.U;
            if (str2 != null) {
                jSONObject2 = new JSONObject(this.U);
                itKeys2 = jSONObject2.keys();
                while (itKeys2.hasNext()) {
                    next2 = itKeys2.next();
                    strOptString3 = jSONObject2.optString(next2);
                    if (strOptString3.length() > 0) {
                        this.d0.put(next2, new t(context, strOptString3));
                    }
                }
            }
            jSONArray = this.J;
            if (jSONArray != null) {
                length = jSONArray.length();
            } else {
                length = 0;
            }
            str = this.H;
            if (str != null) {
                jSONObject = new JSONObject(this.H);
                itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    next = itKeys.next();
                    strOptString2 = jSONObject.optString(next);
                    if (strOptString2.length() > 0) {
                        tVar2 = new t(context, strOptString2);
                        this.d0.put(next, tVar2);
                        while (i2 < length) {
                            this.d0.put(next + "_" + i2, tVar2);
                        }
                    }
                }
            }
            while (i < length) {
                jSONObjectOptJSONObject = this.J.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    strOptString = jSONObjectOptJSONObject.optString(u.a("d6710c97ee54"));
                    if (strOptString.length() > 0) {
                        this.d0.put(u.a("d6710c97ee54") + "_" + Integer.valueOf(i), new t(context, strOptString));
                    }
                }
            }
            while (r0.hasNext()) {
                if (!str20.contains("close")) {
                }
            }
        }
        str3 = this.l;
        if (str3 != null) {
            tVar3 = new t(context, this.l);
            if (tVar3.a == null) {
                this.a = true;
                this.f2861b = "C1";
                return;
            }
            this.d0.put(u.a("c77c089be85694"), tVar3);
            this.d0.put(u.a("c77c089be8569439"), tVar3);
            bitmap = tVar3.a;
            if (bitmap != null) {
                this.m = bitmap.getWidth();
                this.n = tVar3.a.getHeight();
            }
        }
        str4 = this.r;
        if (str4 != null) {
            t tVar8 = new t(context, this.r);
            this.d0.put(u.a("c77c0895e65f"), tVar8);
            this.d0.put(u.a("c77c0895e65fc3"), tVar8);
        }
        str5 = this.A;
        if (str5 != null) {
            this.d0.put(u.a("c77c0c97fb5a"), new t(context, this.A));
        }
        if (this.D != 1) {
            WifiInfo connectionInfo5 = ((WifiManager) context.getApplicationContext().getSystemService(TapjoyConstants.TJC_CONNECTION_TYPE_WIFI)).getConnectionInfo();
            if (connectionInfo5 == null) {
                if (z2) {
                    this.D = 1;
                } else {
                    this.F = false;
                }
            }
            if (z2) {
                this.D = 1;
            } else {
                this.F = false;
            }
        }
        if (this.F) {
            z3 = false;
        } else {
            z3 = false;
        }
        this.a = z3;
    }
}
