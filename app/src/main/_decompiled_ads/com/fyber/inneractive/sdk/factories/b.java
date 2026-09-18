package com.fyber.inneractive.sdk.factories;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public final HashMap<com.fyber.inneractive.sdk.response.a, InterfaceC0266b> a = new HashMap<>();

    public static class a {
        public static b a = new b();
    }

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.factories.b$b, reason: collision with other inner class name */
    public interface InterfaceC0266b {
        com.fyber.inneractive.sdk.interfaces.a a();

        com.fyber.inneractive.sdk.response.b b();
    }

    public com.fyber.inneractive.sdk.response.b a(com.fyber.inneractive.sdk.response.a aVar) {
        InterfaceC0266b interfaceC0266b = this.a.get(aVar);
        if (interfaceC0266b != null) {
            return interfaceC0266b.b();
        }
        return null;
    }

    public void a(com.fyber.inneractive.sdk.response.a aVar, InterfaceC0266b interfaceC0266b) {
        if (this.a.containsKey(aVar)) {
            IAlog.e("Handler already exists for ad type %s! : %s", aVar, this.a.get(aVar));
        } else {
            this.a.put(aVar, interfaceC0266b);
        }
    }
}
