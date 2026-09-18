package com.fyber.inneractive.sdk.network;

import android.util.Log;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.common.net.HttpHeaders;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f0<T> implements c0<T> {
    public volatile boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w<T> f985b;
    public g c;
    public c0.a d;
    public j e;
    public volatile q0 f;
    public final String g;
    public final com.fyber.inneractive.sdk.config.global.s h;
    public long i;
    public long j;
    public long k;
    public long l;
    public int m;
    public boolean n;
    public boolean o;
    public final Object p;
    public boolean q;

    public class a implements Runnable {
        public final /* synthetic */ Object a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Exception f986b;
        public final /* synthetic */ boolean c;

        public a(Object obj, Exception exc, boolean z) {
            this.a = obj;
            this.f986b = exc;
            this.c = z;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public void run() {
            f0.this.f985b.a((T) this.a, this.f986b, this.c);
        }
    }

    public f0(w<T> wVar, g gVar) {
        this(wVar, gVar, null);
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public void a(b0 b0Var, String str, String str2) {
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public void b() {
        try {
            j jVar = this.e;
            if (jVar != null) {
                jVar.a();
            }
            this.c.b();
        } catch (Exception unused) {
        }
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public String c() {
        return null;
    }

    public void c(long j) {
        synchronized (this.p) {
            if (this.o) {
                this.k = j;
                this.m = (int) (((long) this.m) + (j - this.i));
                this.o = false;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public void d() {
        boolean z;
        boolean z2;
        synchronized (this.p) {
            z = this.n;
        }
        if (z) {
            a(System.currentTimeMillis());
            return;
        }
        synchronized (this.p) {
            z2 = this.o;
        }
        if (z2) {
            c(System.currentTimeMillis());
        }
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public String f() {
        return this.g;
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public boolean g() {
        return this.a;
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public int h() {
        Integer numB;
        com.fyber.inneractive.sdk.config.global.s sVar = this.h;
        if (sVar == null || (numB = ((com.fyber.inneractive.sdk.config.global.features.k) sVar.a(com.fyber.inneractive.sdk.config.global.features.k.class)).b("watchdog_buffer_time_ms")) == null) {
            return 500;
        }
        return numB.intValue();
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public boolean j() {
        if (this.q) {
            com.fyber.inneractive.sdk.config.global.features.k kVar = (com.fyber.inneractive.sdk.config.global.features.k) IAConfigManager.M.L.a(com.fyber.inneractive.sdk.config.global.features.k.class);
            if (kVar.a("should_add_request_watchdog", false) || kVar.a("should_report_request_watchdog", false)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public com.fyber.inneractive.sdk.network.a<T> k() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public boolean l() {
        return !(this instanceof p0);
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public com.fyber.inneractive.sdk.config.global.s m() {
        return this.h;
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public t0 n() {
        IAConfigManager iAConfigManager = IAConfigManager.M;
        return new t0(iAConfigManager.u.f886b.a("connect_timeout", 5000, 1), iAConfigManager.u.f886b.a("read_timeout", 5000, 1));
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public q0 p() {
        return this.f;
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public String q() {
        return "application/json; charset=utf-8";
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public boolean s() {
        return this.q && ((com.fyber.inneractive.sdk.config.global.features.k) IAConfigManager.M.L.a(com.fyber.inneractive.sdk.config.global.features.k.class)).a("should_manage_request_watchdog", true);
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public byte[] u() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public Map<String, String> w() {
        return null;
    }

    public int x() {
        return this.m;
    }

    public int y() {
        int i;
        synchronized (this.p) {
            i = this.m;
        }
        return i;
    }

    public f0(w<T> wVar, g gVar, com.fyber.inneractive.sdk.config.global.s sVar) {
        this.a = false;
        this.f = q0.INITIAL;
        this.i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.l = 0L;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = new Object();
        this.q = false;
        this.f985b = wVar;
        this.c = gVar;
        this.g = UUID.randomUUID().toString();
        this.h = sVar;
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public j a(String str) throws Exception {
        try {
            c0.a aVar = this.d;
            if (aVar != null) {
                aVar.a("sdkInitNetworkRequest");
            }
            this.e = this.c.a(this, com.fyber.inneractive.sdk.util.l.f(), str);
            c0.a aVar2 = this.d;
            if (aVar2 != null) {
                aVar2.a("sdkGotServerResponse");
            }
            return this.e;
        } catch (b e) {
            IAlog.a("failed start network request", e, new Object[0]);
            throw e;
        } catch (w0 e2) {
            IAlog.a("failed read network response", e2, new Object[0]);
            throw e2;
        } catch (Exception e3) {
            IAlog.a("failed start network request", e3, new Object[0]);
            throw e3;
        }
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public void b(long j) {
        synchronized (this.p) {
            if (!this.n) {
                this.n = true;
                this.j = j;
            }
        }
    }

    public void d(long j) {
        synchronized (this.p) {
            if (!this.o) {
                this.o = true;
                this.i = j;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public void a(T t, Exception exc, boolean z) {
        if (!z) {
            a(q0.RESOLVED);
        }
        com.fyber.inneractive.sdk.util.m.f1343b.post(new a(t, exc, z));
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public void a(q0 q0Var) {
        c0.a aVar;
        this.f = q0Var;
        if (q0Var != q0.QUEUED_FOR_RETRY || (aVar = this.d) == null) {
            return;
        }
        aVar.a("sdkRequestEndedButWillBeRetried");
    }

    public com.fyber.inneractive.sdk.response.e a(int i, n nVar, com.fyber.inneractive.sdk.response.j jVar, com.fyber.inneractive.sdk.dv.g gVar) throws Exception {
        try {
            com.fyber.inneractive.sdk.response.a aVarA = com.fyber.inneractive.sdk.response.a.a(i);
            if (aVarA == null) {
                aVarA = com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_MRAID;
            }
            com.fyber.inneractive.sdk.response.b bVarA = com.fyber.inneractive.sdk.factories.b.a.a.a(aVarA);
            if (bVarA == null) {
                IAlog.e("Received ad type %s does not have an appropriate parser!", Integer.valueOf(i));
                if (com.fyber.inneractive.sdk.factories.b.a.a.a.size() == 0) {
                    Log.e("Inneractive_error", "Critical error raised while fetching an ad - please make sure you have added all the required fyber libraries (ia-mraid-kit, ia-video-kit) to your project");
                }
                throw new a0("Could not find parser for ad type " + i);
            }
            IAlog.a("Received ad type %s - Got parser! %s", Integer.valueOf(i), bVarA);
            if (jVar != null) {
                bVarA.c = jVar;
            }
            bVarA.a = bVarA.a();
            if (nVar != null) {
                bVarA.c = new com.fyber.inneractive.sdk.response.k(nVar);
            }
            com.fyber.inneractive.sdk.response.e eVarA = bVarA.a((String) null);
            eVarA.I = x();
            if (gVar != null) {
                eVarA.s = gVar;
            }
            c0.a aVar = this.d;
            if (aVar != null) {
                aVar.a("sdkParsedResponse");
            }
            return eVarA;
        } catch (Exception e) {
            IAlog.a("failed parse ad network request", e, new Object[0]);
            throw new a0(e);
        }
    }

    public f0(f0<T> f0Var) {
        this.a = false;
        this.f = q0.INITIAL;
        this.i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.l = 0L;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = new Object();
        this.q = false;
        this.f985b = f0Var.f985b;
        this.c = f0Var.c;
        this.g = UUID.randomUUID().toString();
        this.h = f0Var.h;
        this.m = f0Var.m;
        this.i = f0Var.i;
        this.k = f0Var.k;
        this.j = f0Var.j;
        this.l = f0Var.l;
    }

    public int a(Map<String, List<String>> map) {
        List<String> list = map != null ? map.get(HttpHeaders.CONTENT_LENGTH) : null;
        if (list != null) {
            return com.fyber.inneractive.sdk.util.q.a(list.get(0), -1);
        }
        return -1;
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public void a(long j) {
        synchronized (this.p) {
            if (this.n) {
                this.l = j;
                this.m = (int) (((long) this.m) + (j - this.j));
                this.n = false;
            }
        }
    }
}
