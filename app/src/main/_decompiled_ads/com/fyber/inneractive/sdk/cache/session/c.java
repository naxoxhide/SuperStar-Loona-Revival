package com.fyber.inneractive.sdk.cache.session;

import com.fyber.inneractive.sdk.util.l;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Runnable {
    public final /* synthetic */ com.fyber.inneractive.sdk.cache.session.enums.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.fyber.inneractive.sdk.cache.session.enums.b f852b;
    public final /* synthetic */ d c;

    public c(d dVar, com.fyber.inneractive.sdk.cache.session.enums.a aVar, com.fyber.inneractive.sdk.cache.session.enums.b bVar) {
        this.c = dVar;
        this.a = aVar;
        this.f852b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.c.c) {
            com.fyber.inneractive.sdk.cache.session.enums.a aVar = this.a;
            if (aVar != com.fyber.inneractive.sdk.cache.session.enums.a.NEW_SESSION) {
                e eVar = this.c.a.a.get(this.f852b);
                if (eVar != null) {
                    int i = e.a.a[aVar.ordinal()];
                    if (i == 1) {
                        eVar.f854b++;
                    } else if (i == 2) {
                        eVar.c++;
                    } else if (i == 3) {
                        eVar.a++;
                    }
                }
            } else {
                this.c.a = new f();
            }
            JSONObject jSONObjectA = d.a(this.c);
            boolean zA = false;
            try {
                zA = l.a("session_details.json", l.a, jSONObjectA.toString().getBytes("UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
            d dVar = this.c;
            d.a aVar2 = dVar.e;
            if (aVar2 != null) {
                aVar2.a(dVar, zA, jSONObjectA);
            }
        }
    }
}
