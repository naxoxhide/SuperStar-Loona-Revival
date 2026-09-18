package com.bytedance.sdk.openadsdk.l;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: StatsLogManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static volatile b a;

    /* JADX INFO: compiled from: StatsLogManager.java */
    class a implements com.bytedance.sdk.openadsdk.l.a {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f781b;

        a(b bVar, String str, String str2) {
            this.a = str;
            this.f781b = str2;
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            return com.bytedance.sdk.openadsdk.l.c.b.o().h(this.a).c(this.f781b);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.l.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StatsLogManager.java */
    class C0239b implements com.bytedance.sdk.openadsdk.l.a {
        C0239b(b bVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            return com.bytedance.sdk.openadsdk.l.c.b.o().h("blind_mode_status");
        }
    }

    /* JADX INFO: compiled from: StatsLogManager.java */
    class c implements com.bytedance.sdk.openadsdk.l.a {
        final /* synthetic */ JSONObject a;

        c(b bVar, JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            String strC;
            try {
                this.a.put("event", 272);
                this.a.put("uuid", com.bytedance.sdk.openadsdk.core.j.d(com.bytedance.sdk.openadsdk.core.o.a()));
                try {
                    strC = com.bytedance.sdk.openadsdk.core.j.c(com.bytedance.sdk.openadsdk.core.o.a()) != null ? com.bytedance.sdk.openadsdk.core.j.c(com.bytedance.sdk.openadsdk.core.o.a()) : "";
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.m.a("StatsLogManager", th.getMessage());
                }
                this.a.put("device_id", strC);
                this.a.put(TapjoyConstants.TJC_PLATFORM, "android");
                this.a.put("partner", "PangleSDK");
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.m.a("StatsLogManager", th2.getMessage());
            }
            return com.bytedance.sdk.openadsdk.l.c.b.o().h("ad_revenue").c(this.a.toString());
        }
    }

    /* JADX INFO: compiled from: StatsLogManager.java */
    static class d implements com.bytedance.sdk.openadsdk.l.a {
        d() {
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            JSONObject jSONObject = new JSONObject();
            File file = new File(CacheDirFactory.getRootDir());
            long j = 0;
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    long jA = b.a(file2);
                    j += jA;
                    jSONObject.put(file2.getName(), jA);
                }
            }
            if (j < 524288000) {
                return null;
            }
            return com.bytedance.sdk.openadsdk.l.c.b.o().h("disk_log").c(jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: StatsLogManager.java */
    static class e implements com.bytedance.sdk.openadsdk.l.a {
        final /* synthetic */ com.bytedance.sdk.openadsdk.l.c.b a;

        e(com.bytedance.sdk.openadsdk.l.c.b bVar) {
            this.a = bVar;
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: StatsLogManager.java */
    static class f implements com.bytedance.sdk.openadsdk.l.a {
        final /* synthetic */ long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f782b;
        final /* synthetic */ long c;
        final /* synthetic */ String d;
        final /* synthetic */ int e;

        f(long j, long j2, long j3, String str, int i) {
            this.a = j;
            this.f782b = j2;
            this.c = j3;
            this.d = str;
            this.e = i;
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", this.a);
            jSONObject.put("renderDuration", this.f782b);
            jSONObject.put("showToRenderDuration", this.c);
            jSONObject.put("tag", this.d);
            jSONObject.put("renderType", this.e);
            return com.bytedance.sdk.openadsdk.l.c.b.o().h("ad_show_cost_time").c(jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: StatsLogManager.java */
    static class g implements com.bytedance.sdk.openadsdk.l.a {
        final /* synthetic */ com.bytedance.sdk.openadsdk.l.c.c a;

        g(com.bytedance.sdk.openadsdk.l.c.c cVar) {
            this.a = cVar;
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            return com.bytedance.sdk.openadsdk.l.c.b.o().h("request_monitor").c(this.a.toString());
        }
    }

    /* JADX INFO: compiled from: StatsLogManager.java */
    class h implements com.bytedance.sdk.openadsdk.l.a {
        final /* synthetic */ com.bytedance.sdk.openadsdk.l.c.b a;

        h(b bVar, com.bytedance.sdk.openadsdk.l.c.b bVar2) {
            this.a = bVar2;
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: StatsLogManager.java */
    class i implements com.bytedance.sdk.openadsdk.l.a {
        final /* synthetic */ com.bytedance.sdk.openadsdk.l.c.b a;

        i(b bVar, com.bytedance.sdk.openadsdk.l.c.b bVar2) {
            this.a = bVar2;
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: StatsLogManager.java */
    class j implements com.bytedance.sdk.openadsdk.l.a {
        final /* synthetic */ com.bytedance.sdk.openadsdk.l.c.b a;

        j(b bVar, com.bytedance.sdk.openadsdk.l.c.b bVar2) {
            this.a = bVar2;
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: StatsLogManager.java */
    class k implements com.bytedance.sdk.openadsdk.l.a {
        final /* synthetic */ String a;

        k(b bVar, String str) {
            this.a = str;
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playable_url", this.a);
            } catch (Throwable unused) {
            }
            return com.bytedance.sdk.openadsdk.l.c.b.o().h("click_playable_test_tool").c(jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: StatsLogManager.java */
    class l implements com.bytedance.sdk.openadsdk.l.a {
        final /* synthetic */ String a;

        l(b bVar, String str) {
            this.a = str;
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playable_url", this.a);
            } catch (Throwable unused) {
            }
            return com.bytedance.sdk.openadsdk.l.c.b.o().h("close_playable_test_tool").c(jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: StatsLogManager.java */
    class m implements com.bytedance.sdk.openadsdk.l.a {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f783b;
        final /* synthetic */ String c;

        m(b bVar, String str, int i, String str2) {
            this.a = str;
            this.f783b = i;
            this.c = str2;
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playable_url", this.a);
                jSONObject.put("error_code", this.f783b);
                jSONObject.put("error_message", this.c);
            } catch (Throwable unused) {
            }
            return com.bytedance.sdk.openadsdk.l.c.b.o().h("use_playable_test_tool_error").c(jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: StatsLogManager.java */
    class n implements com.bytedance.sdk.openadsdk.l.a {
        final /* synthetic */ long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f784b;
        final /* synthetic */ long c;

        n(b bVar, long j, long j2, long j3) {
            this.a = j;
            this.f784b = j2;
            this.c = j3;
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            int i = !com.bytedance.sdk.openadsdk.core.l.f640b.get() ? 1 : 0;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("starttime", this.a);
                jSONObject.put("endtime", this.f784b);
                jSONObject.put("start_type", i);
            } catch (Throwable unused) {
            }
            return com.bytedance.sdk.openadsdk.l.c.b.o().h("general_label").g(this.c + "").c(jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: StatsLogManager.java */
    class o implements com.bytedance.sdk.openadsdk.l.a {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f785b;

        o(b bVar, String str, JSONObject jSONObject) {
            this.a = str;
            this.f785b = jSONObject;
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            return com.bytedance.sdk.openadsdk.l.c.b.o().h(this.a).c(this.f785b.toString());
        }
    }

    private b() {
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    private boolean a(com.bytedance.sdk.openadsdk.l.c.b bVar) {
        return bVar == null;
    }

    public void b(com.bytedance.sdk.openadsdk.l.c.b bVar) {
        if (a(bVar)) {
            return;
        }
        bVar.h("show_backup_endcard");
        com.bytedance.sdk.openadsdk.core.o.b().a(new j(this, bVar));
    }

    public void c(com.bytedance.sdk.openadsdk.l.c.b bVar) {
        if (a(bVar)) {
            return;
        }
        bVar.h("express_ad_render");
        com.bytedance.sdk.openadsdk.core.o.b().a(new h(this, bVar));
    }

    public void d(com.bytedance.sdk.openadsdk.l.c.b bVar) {
        if (a(bVar)) {
            return;
        }
        bVar.h("tpl_update_fail");
        com.bytedance.sdk.openadsdk.core.o.b().a(new i(this, bVar));
    }

    public void b(String str) {
        a("close_playable_test_tool", false, (com.bytedance.sdk.openadsdk.l.a) new l(this, str));
    }

    public void c() {
        a("blind_mode_status", true, (com.bytedance.sdk.openadsdk.l.a) new C0239b(this));
    }

    public static void b() {
        a("disk_log", false, (com.bytedance.sdk.openadsdk.l.a) new d());
    }

    public static void b(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                com.bytedance.sdk.openadsdk.core.o.b().a(new e(com.bytedance.sdk.openadsdk.l.c.b.o().h(str).c(str2)), false);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("StatsLogManager", th.getMessage());
        }
    }

    public void a(String str) {
        a("click_playable_test_tool", false, (com.bytedance.sdk.openadsdk.l.a) new k(this, str));
    }

    public void a(String str, int i2, String str2) {
        a("use_playable_test_tool_error", false, (com.bytedance.sdk.openadsdk.l.a) new m(this, str, i2, str2));
    }

    public void a(long j2, long j3) {
        a("general_label", false, (com.bytedance.sdk.openadsdk.l.a) new n(this, j2, j3, j3 - j2));
    }

    public void a(String str, JSONObject jSONObject) {
        if (str == null || jSONObject == null) {
            return;
        }
        a(str, false, (com.bytedance.sdk.openadsdk.l.a) new o(this, str, jSONObject));
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        a(str, false, (com.bytedance.sdk.openadsdk.l.a) new a(this, str, str2));
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        Object objOpt = jSONObject.opt("device_ad_mediation_platform");
        if (!(objOpt instanceof String) || TextUtils.isEmpty((String) objOpt)) {
            return;
        }
        a("ad_revenue", true, (com.bytedance.sdk.openadsdk.l.a) new c(this, jSONObject));
    }

    public static long a(File file) {
        if (file.isFile()) {
            return file.length();
        }
        long jA = 0;
        for (File file2 : file.listFiles()) {
            jA += a(file2);
        }
        return jA;
    }

    public static void a(String str, boolean z, com.bytedance.sdk.openadsdk.l.a aVar) {
        int iO = com.bytedance.sdk.openadsdk.core.settings.n.j0().o(str);
        boolean z2 = false;
        com.bytedance.sdk.component.utils.m.c("StatsLogManager", "type=", str, "  ", Integer.valueOf(iO));
        if (TextUtils.isEmpty(str) || iO == 0 || aVar == null) {
            return;
        }
        boolean z3 = iO == 100;
        if (z3) {
            z2 = z3;
        } else if (((int) ((Math.random() * 100.0d) + 1.0d)) <= iO) {
            z2 = true;
        }
        if (z2) {
            com.bytedance.sdk.openadsdk.core.o.b().a(aVar, z);
        }
    }

    public static void a(long j2, long j3, String str, int i2) {
        if (j2 == 0) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        a("ad_show_cost_time", false, (com.bytedance.sdk.openadsdk.l.a) new f(jElapsedRealtime - j2, jElapsedRealtime - j3, j3 - j2, str, i2));
    }

    public static void a(com.bytedance.sdk.openadsdk.l.c.c cVar) {
        a("request_monitor", false, (com.bytedance.sdk.openadsdk.l.a) new g(cVar));
    }
}
