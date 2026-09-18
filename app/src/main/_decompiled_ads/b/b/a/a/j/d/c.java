package b.b.a.a.j.d;

import android.text.TextUtils;
import b.b.a.a.f.a.j;
import b.b.a.a.f.a.l;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: NetExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    protected j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f235b = null;
    protected final Map<String, String> c = new HashMap();
    protected String d = null;

    public c(j jVar) {
        this.a = jVar;
        a(UUID.randomUUID().toString());
    }

    public void a(String str, String str2) {
        this.c.put(str, str2);
    }

    public void b(String str) {
        this.d = str;
    }

    public void a(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.c.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void a(String str) {
        this.f235b = str;
    }

    public String a() {
        return this.f235b;
    }

    protected void a(l.a aVar) {
        if (aVar != null && this.c.size() > 0) {
            for (Map.Entry<String, String> entry : this.c.entrySet()) {
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
    }
}
