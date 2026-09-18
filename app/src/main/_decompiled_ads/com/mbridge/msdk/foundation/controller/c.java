package com.mbridge.msdk.foundation.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.iab.omid.library.mmadbridge.Omid;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.net.n;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.d;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SDKController.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    private static volatile c h;
    private Context i;
    private String j;
    private String k;
    private String l;
    private String m;
    private com.mbridge.msdk.b.a o;
    private String p;
    private Map<String, Object> t;
    private int u;
    private boolean n = false;
    public final int a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2070b = 2;
    public final int c = 3;
    public final int d = 4;
    public final int e = 5;
    public final int f = 6;
    private boolean q = false;
    private AtomicBoolean r = null;
    private FastKV s = null;
    Handler g = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.foundation.controller.c.5
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            List list;
            try {
                int i = message.what;
                if (i == 2) {
                    if (!(message.obj instanceof List) || (list = (List) message.obj) == null || list.size() <= 0) {
                        return;
                    }
                    p pVar = new p(c.this.i, 0);
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        l lVar = (l) list.get(i2);
                        boolean z = false;
                        if (i2 == list.size() - 1) {
                            z = true;
                        }
                        pVar.a(lVar, z);
                    }
                    return;
                }
                if (i == 3) {
                    File file = (File) message.obj;
                    if (file != null) {
                        String strA = y.a(file);
                        if (TextUtils.isEmpty(strA)) {
                            return;
                        }
                        String[] strArrSplit = strA.split("====");
                        if (strArrSplit.length > 0) {
                            new p(c.this.i).a(strArrSplit[0], file);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i == 4) {
                    String str = (String) message.obj;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (k.a().c()) {
                        k.a().a(str);
                        return;
                    } else {
                        new p(c.this.i, 0).a("click_duration", str, null, null);
                        return;
                    }
                }
                if (i == 5) {
                    String str2 = (String) message.obj;
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    if (k.a().c()) {
                        k.a().a(str2);
                        return;
                    } else {
                        new p(c.this.i, 0).a("load_duration", str2, null, null);
                        return;
                    }
                }
                if (i == 6) {
                    if (message.obj == null || !(message.obj instanceof String)) {
                        return;
                    }
                    String str3 = (String) message.obj;
                    if (TextUtils.isEmpty(str3)) {
                        return;
                    }
                    if (k.a().c()) {
                        k.a().a(str3);
                        return;
                    } else {
                        new p(c.this.i, 0).a("device_data", str3, null, null);
                        return;
                    }
                }
                if (i != 9) {
                    return;
                }
                com.mbridge.msdk.c.c cVar = (com.mbridge.msdk.c.c) message.obj;
                d dVarF = b.d().f();
                if (dVarF != null && dVarF.a() && cVar != null && cVar.M() == 1) {
                    com.mbridge.msdk.foundation.same.report.b.d.a(c.this.i).a();
                }
                if (dVarF == null || !dVarF.b()) {
                    return;
                }
                com.mbridge.msdk.foundation.same.report.b.c.a();
            } catch (Exception e) {
                aa.d("SDKController", e.getMessage());
            }
        }
    };

    private c() {
    }

    public static c a() {
        if (h == null) {
            synchronized (c.class) {
                if (h == null) {
                    h = new c();
                }
            }
        }
        return h;
    }

    public final void a(Map map, final Context context) {
        String string;
        String string2;
        List<com.mbridge.msdk.foundation.entity.a> listB;
        Object objNewInstance;
        Class<?> cls;
        Object objNewInstance2;
        String string3 = "";
        if (context != null) {
            if (map.containsKey(MBridgeConstans.ID_MBRIDGE_APPID)) {
                this.k = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPID);
            }
            this.i = context.getApplicationContext();
            b.d().b(this.i);
            try {
                String str = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPID);
                if (!TextUtils.isEmpty(str)) {
                    com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.SDK_APP_ID, str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                n.a(this.i);
            } catch (Exception unused) {
            }
            if (this.n) {
                new p(context).a();
                return;
            }
            w.q(context);
            if (map != null) {
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_APPID)) {
                    this.k = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPID);
                }
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_APPKEY)) {
                    this.l = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPKEY);
                }
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_WX_APPID)) {
                    this.m = (String) map.get(MBridgeConstans.ID_MBRIDGE_WX_APPID);
                }
                if (map.containsKey(MBridgeConstans.PACKAGE_NAME_MANIFEST)) {
                    this.p = (String) map.get(MBridgeConstans.PACKAGE_NAME_MANIFEST);
                }
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH)) {
                    this.j = (String) map.get(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH);
                }
                try {
                    com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(b.d().h());
                    if (cVarB != null && (listB = cVarB.b()) != null && listB.size() > 0) {
                        for (com.mbridge.msdk.foundation.entity.a aVar : listB) {
                            if (aVar.a() == 287) {
                                Class<?> cls2 = Class.forName("com.mbridge.msdk.interstitialvideo.out.MBInterstitialVideoHandler");
                                if (this.i != null && cls2 != null && (objNewInstance = cls2.getConstructor(String.class, String.class).newInstance("", aVar.b())) != null) {
                                    cls2.getMethod("loadFormSelfFilling", new Class[0]).invoke(objNewInstance, new Object[0]);
                                }
                            } else if (aVar.a() == 94 && (cls = Class.forName("com.mbridge.msdk.out.MBRewardVideoHandler")) != null && (objNewInstance2 = cls.getConstructor(String.class, String.class).newInstance("", aVar.b())) != null) {
                                cls.getMethod("loadFormSelfFilling", new Class[0]).invoke(objNewInstance2, new Object[0]);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    if (MBridgeConstans.DEBUG) {
                        th2.printStackTrace();
                    }
                }
                b.d().c(this.k);
                b.d().e(this.l);
                b.d().d(this.m);
                b.d().b(this.p);
                b.d().a(new b.a() { // from class: com.mbridge.msdk.foundation.controller.c.6
                }, this.g);
                Context applicationContext = this.i.getApplicationContext();
                try {
                    Omid.activate(applicationContext);
                    if (!Omid.isActive()) {
                        new p(applicationContext, 0).a("", "", "", "", "activate om failed");
                    }
                } catch (IllegalArgumentException e2) {
                    aa.b("SDKController", e2.getMessage(), e2);
                }
                Context applicationContext2 = this.i.getApplicationContext();
                try {
                    if (this.s == null) {
                        try {
                            this.s = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), u.b("H+tU+FeXHM==")).build();
                        } catch (Exception unused2) {
                            this.s = null;
                        }
                    }
                    FastKV fastKV = this.s;
                    if (fastKV != null) {
                        try {
                            string = fastKV.getString(u.b("H+tU+bfPhM=="), "");
                            try {
                                string3 = this.s.getString(u.b("H+tU+Fz8"), "");
                            } catch (Exception unused3) {
                            }
                        } catch (Exception unused4) {
                            string = "";
                        }
                        if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l) && TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.m)) {
                            com.mbridge.msdk.foundation.same.a.l = com.mbridge.msdk.foundation.a.a.a.a().b(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                            com.mbridge.msdk.foundation.same.a.m = com.mbridge.msdk.foundation.a.a.a.a().b("c");
                        }
                        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string3)) {
                            if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l) || !TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.m)) {
                                try {
                                    this.s.putString(u.b("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.l);
                                    this.s.putString(u.b("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.m);
                                } catch (Exception unused5) {
                                }
                            }
                        } else {
                            com.mbridge.msdk.foundation.same.a.l = string;
                            com.mbridge.msdk.foundation.same.a.m = string3;
                            com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.l);
                            com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.m);
                        }
                    } else {
                        SharedPreferences sharedPreferences = applicationContext2.getSharedPreferences(u.b("H+tU+FeXHM=="), 0);
                        if (sharedPreferences != null) {
                            String string4 = sharedPreferences.getString(u.b("H+tU+bfPhM=="), "");
                            string2 = sharedPreferences.getString(u.b("H+tU+Fz8"), "");
                            string3 = string4;
                        } else {
                            string2 = "";
                        }
                        if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l) && TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.m)) {
                            com.mbridge.msdk.foundation.same.a.l = com.mbridge.msdk.foundation.a.a.a.a().b(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                            com.mbridge.msdk.foundation.same.a.m = com.mbridge.msdk.foundation.a.a.a.a().b("c");
                        }
                        if (TextUtils.isEmpty(string3) && TextUtils.isEmpty(string2)) {
                            if ((!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l) || !TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.m)) && sharedPreferences != null) {
                                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                                editorEdit.putString(u.b("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.l);
                                editorEdit.putString(u.b("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.m);
                                editorEdit.apply();
                            }
                        } else {
                            com.mbridge.msdk.foundation.same.a.l = string3;
                            com.mbridge.msdk.foundation.same.a.m = string2;
                            com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.l);
                            com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.m);
                        }
                    }
                } catch (Throwable th3) {
                    aa.b("SDKController", th3.getMessage(), th3);
                }
                try {
                    if (MBridgeConstans.INIT_UA_IN) {
                        com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.c.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                Looper.prepare();
                                c.this.d();
                                c cVar = c.this;
                                c.a(cVar, cVar.k);
                                Looper.loop();
                            }
                        });
                    } else if (Looper.myLooper() == Looper.getMainLooper()) {
                        com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.c.3
                            @Override // java.lang.Runnable
                            public final void run() {
                                Looper.prepare();
                                c.this.d();
                                Looper.loop();
                            }
                        });
                    } else {
                        d();
                    }
                } catch (Exception e3) {
                    aa.d("SDKController", e3.getMessage());
                }
                com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.c.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.c();
                    }
                });
                ad.a(this.i);
                this.n = true;
            }
            long jM = com.mbridge.msdk.c.d.a().g(this.k).m();
            if (jM != 1300) {
                this.g.postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.p(context);
                    }
                }, jM);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            Class<?> cls = Class.forName("com.mbridge.msdk.d.b");
            cls.getDeclaredMethod("start", new Class[0]).invoke(cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]);
        } catch (Throwable th) {
            aa.b("SDKController", th.getMessage(), th);
        }
    }

    public final void b() {
        Handler handler = this.g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void c() {
        if (this.i == null || this.g == null) {
            return;
        }
        try {
            int i = ac.a().a("e_r_r_c_t_r_l", false) ? 5 : 1;
            com.mbridge.msdk.foundation.same.report.c.a.a();
            Context context = this.i;
            String string = null;
            List<l> listA = (context != null && com.mbridge.msdk.foundation.db.n.a(h.a(context)).a() > 0) ? com.mbridge.msdk.foundation.db.n.a(h.a(context)).a(i) : null;
            if (listA != null && listA.size() > 0) {
                Message messageObtainMessage = this.g.obtainMessage();
                messageObtainMessage.what = 2;
                messageObtainMessage.obj = listA;
                this.g.sendMessage(messageObtainMessage);
            }
            h hVarA = h.a(this.i);
            com.mbridge.msdk.foundation.db.e eVarA = com.mbridge.msdk.foundation.db.e.a(hVarA);
            if (eVarA.a() >= 20) {
                String strA = com.mbridge.msdk.foundation.entity.d.a(eVarA.a(20));
                Message messageObtain = Message.obtain();
                messageObtain.obj = strA;
                messageObtain.what = 4;
                this.g.sendMessage(messageObtain);
            }
            com.mbridge.msdk.foundation.db.l lVarA = com.mbridge.msdk.foundation.db.l.a(hVarA);
            if (lVarA.a() > 20) {
                List<com.mbridge.msdk.foundation.entity.h> listA2 = lVarA.a(20);
                if (listA2 != null && listA2.size() > 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (com.mbridge.msdk.foundation.entity.h hVar : listA2) {
                        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                            stringBuffer.append("ad_source_id=" + hVar.b()).append("&time=" + hVar.c()).append("&num=" + hVar.d()).append("&unit_id=" + hVar.e()).append("&key=2000006").append("&fb=" + hVar.f()).append("&network_str=" + hVar.i()).append("&network_type=" + hVar.h());
                        } else {
                            stringBuffer.append("ad_source_id=" + hVar.b()).append("&time=" + hVar.c()).append("&num=" + hVar.d()).append("&unit_id=" + hVar.e()).append("&key=2000006").append("&fb=" + hVar.f());
                        }
                        if (hVar.a() == 1) {
                            stringBuffer.append("&hb=1");
                        }
                        stringBuffer.append("&timeout=" + hVar.g() + "\n");
                    }
                    string = stringBuffer.toString();
                }
                Message messageObtain2 = Message.obtain();
                messageObtain2.obj = string;
                messageObtain2.what = 5;
                this.g.sendMessage(messageObtain2);
            }
            String strB = e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_CRASH_INFO);
            File file = new File(strB);
            if (file.exists() && file.isDirectory() && file.list().length > 0) {
                for (String str : file.list()) {
                    File file2 = new File(strB + RemoteSettings.FORWARD_SLASH_STRING + str);
                    Message messageObtain3 = Message.obtain();
                    messageObtain3.obj = file2;
                    messageObtain3.what = 3;
                    this.g.sendMessage(messageObtain3);
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                aa.d("SDKController", e.getMessage());
            }
        }
    }

    public final void a(Map<String, Object> map, int i) {
        if (MBridgeSDKFactory.getMBridgeSDK().getStatus() != MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            return;
        }
        this.t = map;
        this.u = i;
        b.d().h();
        if (map != null) {
            if (this.o == null) {
                this.o = new com.mbridge.msdk.b.a();
            }
            try {
                Map<String, Object> map2 = this.t;
                if (map2 != null && map2.size() > 0 && this.t.containsKey(MBridgeConstans.PROPERTIES_LAYOUT_TYPE) && ((Integer) this.t.get(MBridgeConstans.PROPERTIES_LAYOUT_TYPE)).intValue() == 0) {
                    Map<String, Object> map3 = this.t;
                    int i2 = this.u;
                    try {
                        Class<?> cls = Class.forName("com.mbridge.msdk.mbnative.e.a");
                        cls.getMethod("preload", Map.class, Integer.TYPE).invoke(cls.newInstance(), map3, Integer.valueOf(i2));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    static /* synthetic */ void a(c cVar, String str) {
        if (com.mbridge.msdk.c.d.a() == null) {
            return;
        }
        com.mbridge.msdk.c.d dVarA = com.mbridge.msdk.c.d.a();
        if (dVarA != null) {
            com.mbridge.msdk.c.c cVarB = dVarA.b(str);
            if (cVarB != null) {
                MBridgeConstans.OMID_JS_SERVICE_URL = cVarB.ax();
                MBridgeConstans.OMID_JS_H5_URL = cVarB.aw();
                if (!TextUtils.isEmpty(cVarB.E())) {
                    com.mbridge.msdk.foundation.same.net.f.d.a().e = cVarB.E();
                    com.mbridge.msdk.foundation.same.net.f.d.a().e();
                }
                if (!TextUtils.isEmpty(cVarB.F())) {
                    com.mbridge.msdk.foundation.same.net.f.d.a().f = cVarB.F();
                    com.mbridge.msdk.foundation.same.net.f.d.a().f();
                }
            } else {
                MBridgeConstans.OMID_JS_SERVICE_URL = com.mbridge.msdk.c.a.b.a;
                MBridgeConstans.OMID_JS_H5_URL = com.mbridge.msdk.c.a.b.f1904b;
            }
        }
        if (com.mbridge.msdk.c.d.a().a(str) && com.mbridge.msdk.c.d.a().a(str, 1, (String) null)) {
            new com.mbridge.msdk.c.e().a(cVar.i, str, cVar.l);
        } else {
            new p(cVar.i).a();
        }
    }
}
