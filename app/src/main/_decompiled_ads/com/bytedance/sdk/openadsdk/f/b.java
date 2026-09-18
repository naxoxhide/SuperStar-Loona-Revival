package com.bytedance.sdk.openadsdk.f;

import android.text.TextUtils;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.GeckoHubImp;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.d.c;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: compiled from: GeckoHub.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static String[] a = {"gecko-pangle-sg.byteoversea.com"};

    /* JADX INFO: compiled from: GeckoHub.java */
    class a implements IStatisticMonitor {
        final /* synthetic */ Map a;

        a(b bVar, Map map) {
            this.a = map;
        }

        public void upload(String str, JSONObject jSONObject) {
            if (!"geckosdk_update_stats".equals(str)) {
                if ("download_gecko_end".equals(str)) {
                    b.b(this.a, jSONObject, "");
                }
            } else {
                q qVar = (q) this.a.get(jSONObject.optString("channel"));
                if (qVar != null) {
                    c.o.a(str, jSONObject, qVar);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.f.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GeckoHub.java */
    private static class C0235b {
        private static b a = new b(null);
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    private static String b() {
        String[] strArrK = o.d().K();
        m.a("GeckoHub", "GeckoLog:get gecko hosts from settings " + (strArrK == null ? 0 : strArrK.length));
        if (strArrK == null) {
            strArrK = a;
        }
        String str = strArrK[new SecureRandom().nextInt(strArrK.length)];
        if (TextUtils.isEmpty(str)) {
            str = a[new SecureRandom().nextInt(a.length)];
        }
        m.a("GeckoHub", "GeckoLog:random host " + str);
        return str;
    }

    public static b c() {
        return C0235b.a;
    }

    private b() {
        try {
            GeckoHubImp.inst(o.a());
        } catch (Throwable th) {
            m.b("GeckoHub", "GeckoHubImp init error", th);
        }
    }

    public ILoader a() {
        try {
            return GeckoHubImp.inst(o.a()).getGeckoResLoader();
        } catch (Throwable th) {
            m.b("GeckoHub", "getGeckoResLoader error", th);
            return null;
        }
    }

    public void a(Map<String, q> map) {
        try {
            String strC = j.c(o.a());
            if (TextUtils.isEmpty(strC)) {
                m.a("GeckoHub", "no did so don't preload");
                return;
            }
            Iterator<q> it = map.values().iterator();
            while (it.hasNext()) {
                c.o.a(it.next());
            }
            GeckoHubImp.setRandomHost(b());
            GeckoHubImp.inst(o.a()).preload(strC, new a(this, map), map.keySet(), new com.bytedance.sdk.openadsdk.f.a());
        } catch (Throwable th) {
            b(map, null, th.toString());
            m.b("GeckoHub", "releaseGeckoResLoader error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Map<String, q> map, JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject == null) {
                jSONObject2.put("success", false);
                jSONObject2.put("msg", str);
                jSONObject2.put("code", 1);
                jSONObject = jSONObject2;
            }
            Iterator<q> it = map.values().iterator();
            while (it.hasNext()) {
                c.o.a(it.next(), jSONObject);
            }
        } catch (Throwable th) {
            m.b("GeckoHub", "upLoadStateEvent error", th);
        }
    }

    public void a(ILoader iLoader) {
        if (iLoader != null) {
            try {
                GeckoHubImp.inst(o.a()).releaseGeckoResLoader(iLoader);
            } catch (Throwable th) {
                m.b("GeckoHub", "releaseGeckoResLoader error", th);
            }
        }
    }

    public WebResourceResponseModel a(ILoader iLoader, String str, String str2) {
        if (iLoader == null) {
            return null;
        }
        try {
            return GeckoHubImp.inst(o.a()).findResAndMsg(iLoader, str, str2);
        } catch (Throwable th) {
            m.b("GeckoHub", "findRes error", th);
            return null;
        }
    }

    public int a(ILoader iLoader, String str) {
        try {
            return GeckoHubImp.inst(o.a()).getResCount(iLoader, str);
        } catch (Throwable th) {
            m.b("GeckoHub", "getResCount error", th);
            return 0;
        }
    }

    public static void a(ThreadPoolExecutor threadPoolExecutor) {
        try {
            GeckoHubImp.setThreadPoolExecutor(threadPoolExecutor);
        } catch (Throwable th) {
            m.b("GeckoHub", "setThreadPoolExecutor error", th);
        }
    }
}
