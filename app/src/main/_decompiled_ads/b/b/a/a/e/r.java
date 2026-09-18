package b.b.a.a.e;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: JsBridge2.java */
/* JADX INFO: loaded from: classes.dex */
public class r {
    static w e;
    private final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<n> f138b;
    private o c;
    private volatile boolean d;

    r(j jVar) {
        w wVar;
        ArrayList arrayList = new ArrayList();
        this.f138b = arrayList;
        this.d = false;
        if (jVar.h && (wVar = e) != null) {
            wVar.a(jVar.k);
            throw null;
        }
        if (jVar.a != null) {
            a aVar = jVar.f135b;
            if (aVar == null) {
                this.a = new z();
            } else {
                this.a = aVar;
            }
        } else {
            this.a = jVar.f135b;
        }
        this.a.a(jVar, (v) null);
        WebView webView = jVar.a;
        arrayList.add(jVar.j);
        i.a(jVar.f);
        y.a(jVar.g);
    }

    public static j a(WebView webView) {
        return new j(webView);
    }

    public void b() {
        if (this.d) {
            return;
        }
        this.a.b();
        this.d = true;
        for (n nVar : this.f138b) {
            if (nVar != null) {
                nVar.a();
            }
        }
    }

    public r a(String str, e<?, ?> eVar) {
        return a(str, (String) null, eVar);
    }

    public r a(String str, String str2, e<?, ?> eVar) {
        a();
        this.a.f.a(str, eVar);
        o oVar = this.c;
        if (oVar != null) {
            oVar.a(str);
        }
        return this;
    }

    public r a(String str, d.b bVar) {
        return a(str, (String) null, bVar);
    }

    public r a(String str, String str2, d.b bVar) {
        a();
        this.a.f.a(str, bVar);
        o oVar = this.c;
        if (oVar != null) {
            oVar.a(str);
        }
        return this;
    }

    private void a() {
        if (this.d) {
            i.a(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }
}
