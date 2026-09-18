package com.fyber.inneractive.sdk.ignite;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI;
import com.facebook.AuthenticationTokenClaims;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.p;
import com.fyber.inneractive.sdk.network.k0;
import com.fyber.inneractive.sdk.network.q;
import com.fyber.inneractive.sdk.network.q0;
import com.fyber.inneractive.sdk.network.s0;
import com.fyber.inneractive.sdk.network.x;
import com.fyber.inneractive.sdk.util.IAlog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c implements ServiceConnection {
    public Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IIgniteServiceAPI f940b;
    public String c;
    public String d;
    public String e;
    public String f;
    public g h;
    public long p;
    public Runnable q;
    public h s;
    public s t;
    public final Bundle g = new Bundle();
    public final List<n> i = new CopyOnWriteArrayList();
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public long m = 0;
    public final Object n = new Object();
    public boolean o = false;
    public boolean r = false;

    public class a implements Runnable {
        public final /* synthetic */ ServiceConnection a;

        public a(ServiceConnection serviceConnection) {
            this.a = serviceConnection;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (c.this.n) {
                Intent intent = new Intent();
                intent.setClassName(c.this.c, "com.digitalturbine.ignite.cl.IgniteRemoteService");
                Context context = c.this.a;
                if (context != null) {
                    context.bindService(intent, this.a, 1);
                }
            }
        }
    }

    public class b implements g.a {
        public final /* synthetic */ d a;

        public b(d dVar) {
            this.a = dVar;
        }
    }

    public static class d {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p<?> f943b;
        public final k c;

        public d(String str, k kVar, p<?> pVar) {
            this.a = str;
            this.c = kVar;
            this.f943b = pVar;
        }
    }

    public c() {
        h();
    }

    public void c() {
        h hVar;
        if (g() == null && (hVar = this.s) != null) {
            hVar.a();
            this.s = null;
        } else {
            if (TextUtils.isEmpty(this.c) || e()) {
                return;
            }
            com.fyber.inneractive.sdk.util.m.a(new a(this));
        }
    }

    public boolean d() {
        return e() && this.l;
    }

    public boolean e() {
        IIgniteServiceAPI iIgniteServiceAPI;
        return this.k && (iIgniteServiceAPI = this.f940b) != null && iIgniteServiceAPI.asBinder().isBinderAlive();
    }

    public final boolean f() {
        return this.m > 0 && TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) > this.m;
    }

    public final String g() {
        List<ResolveInfo> listQueryIntentServices;
        Intent intent = new Intent("com.digitalturbine.ignite.cl.IgniteRemoteService");
        Context context = this.a;
        if (context == null || (listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0)) == null || listQueryIntentServices.size() <= 0) {
            return null;
        }
        return listQueryIntentServices.get(0).serviceInfo.packageName;
    }

    public final void h() {
        this.h = new g(new C0269c());
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String string;
        String str;
        Context context;
        IAlog.a("onServiceConnected", new Object[0]);
        this.f940b = IIgniteServiceAPI.Stub.asInterface(iBinder);
        this.k = true;
        byte[] byteArray = null;
        if (e()) {
            try {
                string = new JSONObject(this.f940b.version()).getJSONObject("data").getString("igniteVersion");
            } catch (Exception unused) {
                IAlog.e("Failed to resolve ignite version", new Object[0]);
                string = null;
            }
        } else {
            string = null;
        }
        this.d = string;
        if (this.o) {
            a();
            return;
        }
        this.o = true;
        try {
            IgniteRequestOuterClass$IgniteRequest.a aVarNewBuilder = IgniteRequestOuterClass$IgniteRequest.newBuilder();
            String str2 = IAConfigManager.M.c;
            aVarNewBuilder.c();
            ((IgniteRequestOuterClass$IgniteRequest) aVarNewBuilder.f1272b).setAppId(str2);
            String packageName = com.fyber.inneractive.sdk.util.l.a.getPackageName();
            aVarNewBuilder.c();
            ((IgniteRequestOuterClass$IgniteRequest) aVarNewBuilder.f1272b).setBundle(packageName);
            String version = InneractiveAdManager.getVersion();
            aVarNewBuilder.c();
            ((IgniteRequestOuterClass$IgniteRequest) aVarNewBuilder.f1272b).setSdkVersion(version);
            String str3 = this.c;
            aVarNewBuilder.c();
            ((IgniteRequestOuterClass$IgniteRequest) aVarNewBuilder.f1272b).setIgnitePackageName(str3);
            if (TextUtils.isEmpty(this.c) || (context = this.a) == null) {
                str = null;
                aVarNewBuilder.c();
                ((IgniteRequestOuterClass$IgniteRequest) aVarNewBuilder.f1272b).setIgniteVersionName(str);
                String strB = com.fyber.inneractive.sdk.util.l.b(this.a);
                aVarNewBuilder.c();
                ((IgniteRequestOuterClass$IgniteRequest) aVarNewBuilder.f1272b).setAppSignature(strB);
                byteArray = aVarNewBuilder.a().toByteArray();
            } else {
                try {
                    str = context.getPackageManager().getPackageInfo(this.c, 0).versionName;
                } catch (Exception unused2) {
                    IAlog.a("Failed to resolve ignite version", new Object[0]);
                    str = null;
                }
                aVarNewBuilder.c();
                ((IgniteRequestOuterClass$IgniteRequest) aVarNewBuilder.f1272b).setIgniteVersionName(str);
                String strB2 = com.fyber.inneractive.sdk.util.l.b(this.a);
                aVarNewBuilder.c();
                ((IgniteRequestOuterClass$IgniteRequest) aVarNewBuilder.f1272b).setAppSignature(strB2);
                byteArray = aVarNewBuilder.a().toByteArray();
            }
        } catch (Throwable unused3) {
            IAlog.a("Failed to build ignite request", new Object[0]);
        }
        if (byteArray != null) {
            k0 k0Var = new k0(new com.fyber.inneractive.sdk.ignite.d(this), byteArray, x.a().b(), this.t);
            IAConfigManager.M.s.a.offer(k0Var);
            k0Var.a(q0.QUEUED);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        IAlog.a("onServiceDisconnected", new Object[0]);
        this.k = false;
        this.m = 0L;
        h hVar = this.s;
        if (hVar != null) {
            hVar.a();
            this.s = null;
        }
    }

    public void a(s sVar) {
        this.t = sVar;
        if (((com.fyber.inneractive.sdk.config.global.features.i) sVar.a(com.fyber.inneractive.sdk.config.global.features.i.class)).a("enable", false)) {
            String strG = g();
            this.c = strG;
            if (!TextUtils.isEmpty(strG)) {
                c();
            }
            this.p = TimeUnit.SECONDS.toMillis(IAConfigManager.M.w.a.f886b.a("igniteInstallTimeOutInSeconds", 15, 1));
        }
    }

    public void b() {
        Runnable runnable = this.q;
        if (runnable != null) {
            com.fyber.inneractive.sdk.util.m.f1343b.removeCallbacks(runnable);
            this.q = null;
        }
    }

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.ignite.c$c, reason: collision with other inner class name */
    public class C0269c implements n {
        public C0269c() {
        }

        @Override // com.fyber.inneractive.sdk.ignite.n
        public void a(String str, String str2) {
            for (n nVar : c.this.i) {
                if (nVar != null) {
                    nVar.a(str, str2);
                }
            }
        }

        @Override // com.fyber.inneractive.sdk.ignite.n
        public void b(String str) {
            c.this.a(i.FAILED_TO_AUTHENTICATE, str);
            c.this.r = false;
            h hVar = c.this.s;
            if (hVar != null) {
                hVar.a();
                c.this.s = null;
            }
        }

        @Override // com.fyber.inneractive.sdk.ignite.n
        public void c(String str) {
            for (n nVar : c.this.i) {
                if (nVar != null) {
                    nVar.c(str);
                }
            }
        }

        @Override // com.fyber.inneractive.sdk.ignite.n
        public void d(String str) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            IAlog.a("ignite authenticated successfully", new Object[0]);
            c.this.g.putString("clientToken", str);
            c.this.l = true;
            c cVar = c.this;
            cVar.getClass();
            String str3 = "";
            if (TextUtils.isEmpty(str)) {
                str2 = "";
            } else {
                try {
                    str2 = new String(Base64.decode(str.split("\\.")[1], 8), "UTF-8");
                } catch (Exception unused) {
                    IAlog.a("Failed to decode str", new Object[0]);
                    str2 = "";
                }
            }
            if (!str2.isEmpty()) {
                try {
                    long jOptLong = new JSONObject(str2).optLong(AuthenticationTokenClaims.JSON_KEY_EXP);
                    cVar.m = jOptLong;
                    Object[] objArr = new Object[1];
                    long millis = TimeUnit.SECONDS.toMillis(jOptLong);
                    try {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(millis);
                        str3 = simpleDateFormat.format(calendar.getTime());
                    } catch (Exception unused2) {
                    }
                    objArr[0] = str3;
                    IAlog.a("Ignite session will exp in: %s", objArr);
                } catch (Exception unused3) {
                    IAlog.a("Failed to resolve expiration time", new Object[0]);
                }
            }
            c.this.r = false;
            h hVar = c.this.s;
            if (hVar != null) {
                hVar.b();
                c.this.s = null;
            }
        }

        @Override // com.fyber.inneractive.sdk.ignite.n
        public void a(String str, int i, double d) {
            for (n nVar : c.this.i) {
                if (nVar != null) {
                    nVar.a(str, i, d);
                }
            }
        }

        @Override // com.fyber.inneractive.sdk.ignite.n
        public void a(String str) {
            for (n nVar : c.this.i) {
                if (nVar != null) {
                    nVar.a(str);
                }
            }
        }

        @Override // com.fyber.inneractive.sdk.ignite.n
        public void b(String str, String str2, String str3) {
            for (n nVar : c.this.i) {
                if (nVar != null) {
                    nVar.b(str, str2, str3);
                }
            }
        }

        @Override // com.fyber.inneractive.sdk.ignite.n
        public void a(String str, String str2, String str3) {
            for (n nVar : c.this.i) {
                if (nVar != null) {
                    nVar.a(str, str2, str3);
                }
            }
        }
    }

    public final boolean a(Exception exc) {
        return ((exc instanceof s0) && ((s0) exc).a == 204) ? false : true;
    }

    public void a(i iVar, String str) {
        if (this.j) {
            return;
        }
        this.j = true;
        com.fyber.inneractive.sdk.network.s.a aVar = new com.fyber.inneractive.sdk.network.s.a(q.IGNITE_FLOW_FAILED_TO_START, (InneractiveAdRequest) null, (com.fyber.inneractive.sdk.response.e) null, (JSONArray) null);
        JSONObject jSONObject = new JSONObject();
        String strE = iVar.e();
        try {
            jSONObject.put("error_code", strE);
        } catch (Exception unused) {
            IAlog.e("Got exception adding param to json object: %s, %s", "error_code", strE);
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject.put("message", str);
            } catch (Exception unused2) {
                IAlog.e("Got exception adding param to json object: %s, %s", "message", str);
            }
        }
        aVar.f.put(jSONObject);
        aVar.a((String) null);
    }

    public void a() {
        if (!e() || TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.f) || this.r) {
            return;
        }
        try {
            this.r = true;
            this.g.putInt("sdkFlowTypeKey", 1);
            this.f940b.authenticate(this.e, this.f, this.g, this.h.f944b);
        } catch (RemoteException unused) {
            this.r = false;
            IAlog.a("Failed to authenticate ignite", new Object[0]);
        }
    }

    public void a(h hVar) {
        this.s = hVar;
        if (!e()) {
            c();
        } else if (!this.l || f()) {
            a();
        }
    }

    public void a(String str, d dVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        IAlog.a("Starting install timeout with %d", Long.valueOf(this.p));
        e eVar = new e(this);
        this.q = eVar;
        com.fyber.inneractive.sdk.util.m.f1343b.postDelayed(eVar, this.p);
        if (d() && !f()) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("packageName", str);
                jSONObject.put("data", jSONObject2);
                IIgniteServiceAPI iIgniteServiceAPI = this.f940b;
                String string = jSONObject.toString();
                Bundle bundle = this.g;
                Bundle bundle2 = new Bundle();
                g gVar = this.h;
                b bVar = new b(dVar);
                gVar.getClass();
                iIgniteServiceAPI.install(string, bundle, bundle2, new o(gVar.a, bVar));
                return;
            } catch (Exception unused) {
                IAlog.a("Failed to install app", new Object[0]);
                return;
            }
        }
        for (n nVar : this.i) {
            if (nVar != null) {
                nVar.b(null, (f() ? i.SESSION_EXPIRED : i.NOT_CONNECTED).e(), null);
            }
        }
    }

    public void a(n nVar) {
        this.i.add(nVar);
    }
}
