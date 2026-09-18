package b.a.a.a.a.a.b.c.p;

import android.text.TextUtils;
import b.b.a.a.f.a.j;
import b.b.a.a.f.a.l;
import b.b.a.a.f.a.n;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: NetworkSoureVolleyImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements b {
    private j a;

    public d() {
        this.a = null;
        this.a = b.a.a.a.a.a.a.c.b();
    }

    @Override // b.a.a.a.a.a.b.c.p.b
    public a a(e eVar) throws IOException {
        l.a aVar = new l.a();
        try {
            Map<String, String> map = eVar.f55b;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        String value = entry.getValue();
                        if (value == null) {
                            value = "";
                        }
                        aVar.a(key, value);
                    }
                }
            }
            n nVarB = this.a.a(aVar.a(eVar.a).b().a()).b();
            b.a.a.a.a.a.a.i.c.b("NetworkSoureVolleyImpl", "response code = ", Integer.valueOf(nVarB.b()));
            return new f(nVarB, eVar);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
