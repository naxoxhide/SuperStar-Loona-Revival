package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.k0;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class m extends a {
    public m(Map<String, String> map, com.fyber.inneractive.sdk.web.i iVar, k0 k0Var) {
        super(map, iVar, k0Var);
    }

    @Override // com.fyber.inneractive.sdk.mraid.a
    public void d() {
        com.fyber.inneractive.sdk.web.i iVar = this.c;
        if (iVar != null) {
            iVar.a(g.OPEN, "No native click was detected in a timely fashion");
        }
    }

    @Override // com.fyber.inneractive.sdk.mraid.b
    public void a() {
        com.fyber.inneractive.sdk.util.x.a aVar;
        String str = this.f974b.get("url");
        IAlog.d("IAmraidActionOpen: opening Internal Browser For Url: %s", str);
        com.fyber.inneractive.sdk.web.i iVar = this.c;
        if (iVar != null) {
            k0 k0Var = this.d;
            L l = iVar.g;
            if (l != 0) {
                aVar = ((com.fyber.inneractive.sdk.web.i.f) l).a(str, k0Var, (com.fyber.inneractive.sdk.web.b.a) null);
            } else {
                aVar = new com.fyber.inneractive.sdk.util.x.a(com.fyber.inneractive.sdk.util.x.d.FAILED, new Exception("No webview listener available"), iVar.l() == null ? "null" : iVar.l().getClass().getName());
            }
            if (aVar.a == com.fyber.inneractive.sdk.util.x.d.FAILED) {
                com.fyber.inneractive.sdk.web.i iVar2 = this.c;
                g gVar = g.OPEN;
                Throwable th = aVar.f1351b;
                iVar2.a(gVar, th == null ? "unknown error" : th.getMessage());
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.mraid.a
    public String c() {
        return this.f974b.get("url");
    }
}
