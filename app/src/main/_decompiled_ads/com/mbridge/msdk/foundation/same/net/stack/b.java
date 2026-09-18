package com.mbridge.msdk.foundation.same.net.stack;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.c.c;
import com.mbridge.msdk.c.d;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.thrid.okhttp.ConnectionPool;
import com.mbridge.msdk.thrid.okhttp.Dispatcher;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: OKHTTPClientManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private OkHttpClient a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f2158b;
    private String c;

    private b() {
        this.a = null;
        this.c = "";
    }

    public static b a() {
        return a.a;
    }

    public final synchronized OkHttpClient b() {
        if (this.a == null) {
            Dispatcher dispatcher = new Dispatcher();
            dispatcher.setMaxRequestsPerHost(50);
            dispatcher.setMaxRequests(256);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.readTimeout(100L, TimeUnit.SECONDS);
            builder.connectTimeout(60L, TimeUnit.SECONDS);
            builder.writeTimeout(60L, TimeUnit.SECONDS);
            builder.connectionPool(new ConnectionPool(32, 5L, TimeUnit.MINUTES));
            builder.dispatcher(dispatcher);
            builder.eventListener(new EventListener() { // from class: com.mbridge.msdk.foundation.same.net.stack.b.1
            });
            this.a = builder.build();
        }
        return this.a;
    }

    public final C0485b c() {
        C0485b c0485b = new C0485b();
        c0485b.f = this.c;
        return c0485b;
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (this.f2158b == null) {
                this.f2158b = d.a().g(com.mbridge.msdk.foundation.controller.b.d().h());
            }
            c cVar = this.f2158b;
            if (cVar == null) {
                return false;
            }
            String strY = cVar.y();
            String str2 = com.mbridge.msdk.foundation.same.net.f.d.a().a;
            if (TextUtils.isEmpty(strY) || !str.startsWith(strY) || TextUtils.equals(strY, str2)) {
                return false;
            }
            this.c = strY;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void a(C0485b c0485b) {
        if (c0485b == null) {
            return;
        }
        final C0485b c0485bA = C0485b.a(c0485b);
        com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.stack.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    StringBuilder sb = new StringBuilder("key=2000102&");
                    sb.append("app_id=").append(com.mbridge.msdk.foundation.controller.b.d().h()).append("&");
                    sb.append("status=").append(c0485bA.a).append("&");
                    sb.append("domain=").append(c0485bA.f).append("&");
                    sb.append("method=").append(c0485bA.d).append("&");
                    if (TextUtils.isEmpty(c0485bA.h)) {
                        if (!TextUtils.isEmpty(c0485bA.c)) {
                            sb.append("connect_e=").append(c0485bA.c);
                        } else if (!TextUtils.isEmpty(c0485bA.j)) {
                            sb.append("connect_e=").append(c0485bA.j);
                        }
                    } else {
                        sb.append("dns_r=").append(c0485bA.h).append("&");
                        sb.append("dns_d=").append(c0485bA.g).append("&");
                        sb.append("host=").append(c0485bA.e).append("&");
                        if (TextUtils.isEmpty(c0485bA.j)) {
                            if (TextUtils.isEmpty(c0485bA.c)) {
                                sb.append("call_d=").append(c0485bA.f2160b).append("&");
                                sb.append("connect_d=").append(c0485bA.i).append("&");
                                sb.append("connection_d=").append(c0485bA.k);
                            } else {
                                sb.append("connect_d=").append(c0485bA.i).append("&");
                                sb.append("connection_e=").append(c0485bA.c);
                            }
                        } else {
                            sb.append("connect_e=").append(c0485bA.j);
                        }
                    }
                    if (k.a().c()) {
                        k.a().a(sb.toString());
                        return;
                    }
                    final b bVar = b.this;
                    String string = sb.toString();
                    Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
                    com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(contextG);
                    com.mbridge.msdk.foundation.same.net.g.d dVarA = q.a(contextG);
                    dVarA.a("data", URLEncoder.encode(string, "utf-8"));
                    dVarA.a("m_sdk", "msdk");
                    aVar.post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, dVarA, new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.net.stack.b.3
                        @Override // com.mbridge.msdk.foundation.same.report.d.b
                        public final void onSuccess(String str) {
                            aa.a("OKHTTPClientManager", "report success");
                        }

                        @Override // com.mbridge.msdk.foundation.same.report.d.b
                        public final void onFailed(String str) {
                            aa.a("OKHTTPClientManager", "report failed");
                        }
                    });
                } catch (Exception e) {
                    aa.d("OKHTTPClientManager", e.getMessage());
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.same.net.stack.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OKHTTPClientManager.java */
    public static class C0485b implements Serializable {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f2160b = 0;
        public String c = "";
        public String d = "";
        public String e = "";
        public String f = "";
        public long g = 0;
        public String h = "";
        public long i = 0;
        public String j = "";
        public long k = 0;

        public static C0485b a(C0485b c0485b) {
            C0485b c0485b2 = new C0485b();
            c0485b2.a = c0485b.a;
            c0485b2.d = c0485b.d;
            c0485b2.f = c0485b.f;
            c0485b2.f2160b = c0485b.f2160b;
            c0485b2.i = c0485b.i;
            c0485b2.c = c0485b.c;
            c0485b2.h = c0485b.h;
            c0485b2.g = c0485b.g;
            c0485b2.e = c0485b.e;
            c0485b2.j = c0485b.j;
            c0485b2.k = c0485b.k;
            return c0485b2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: OKHTTPClientManager.java */
    static final class a {
        private static final b a = new b();
    }
}
