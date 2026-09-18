package b.b.a.a.j.d;

import android.net.Uri;
import android.text.TextUtils;
import b.b.a.a.f.a.f;
import b.b.a.a.f.a.g;
import b.b.a.a.f.a.j;
import b.b.a.a.f.a.l;
import b.b.a.a.f.a.n;
import b.b.a.a.f.a.o;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: GetExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends c {
    public static final b.b.a.a.f.a.a h = new b.b.a.a.f.a.a.C0030a().b().a();
    private b.b.a.a.f.a.a e;
    private boolean f;
    private Map<String, String> g;

    static {
        new b.b.a.a.f.a.a.C0030a().a();
    }

    public b(j jVar) {
        super(jVar);
        this.e = h;
        this.f = false;
        this.g = new HashMap();
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void b(String str, String str2) {
        if (str == null) {
            b.b.a.a.j.f.d.a("GetExecutor", "name cannot be null !!!");
        } else {
            this.g.put(str, str2);
        }
    }

    /* JADX INFO: compiled from: GetExecutor.java */
    class a implements b.b.a.a.f.a.c {
        final /* synthetic */ b.b.a.a.j.c.a a;

        a(b.b.a.a.j.c.a aVar) {
            this.a = aVar;
        }

        @Override // b.b.a.a.f.a.c
        public void a(b.b.a.a.f.a.b bVar, IOException iOException) {
            b.b.a.a.j.c.a aVar = this.a;
            if (aVar != null) {
                aVar.a(b.this, iOException);
            }
        }

        @Override // b.b.a.a.f.a.c
        public void a(b.b.a.a.f.a.b bVar, n nVar) throws IOException {
            if (this.a != null) {
                HashMap map = new HashMap();
                if (nVar != null) {
                    f fVarC = nVar.c();
                    if (fVarC != null) {
                        for (int i = 0; i < fVarC.a(); i++) {
                            map.put(fVarC.a(i), fVarC.b(i));
                        }
                    }
                    o oVarA = nVar.a();
                    this.a.a(b.this, new b.b.a.a.j.b(nVar.d(), nVar.b(), nVar.e(), map, oVarA == null ? "" : oVarA.d(), nVar.h(), nVar.g()));
                }
            }
        }
    }

    public void a(b.b.a.a.j.c.a aVar) {
        try {
            l.a aVar2 = new l.a();
            if (this.f) {
                aVar2.a(this.d);
            } else {
                g.a aVar3 = new g.a();
                Uri uri = Uri.parse(this.d);
                aVar3.f(uri.getScheme());
                aVar3.c(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                        encodedPath = encodedPath.substring(1);
                    }
                    aVar3.a(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.g.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.g.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        aVar3.a(strEncode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                aVar2.a(aVar3.a());
            }
            a(aVar2);
            aVar2.a(this.e);
            aVar2.a((Object) a());
            this.a.a(aVar2.b().a()).a(new a(aVar));
        } catch (Throwable th) {
            if (b.b.a.a.j.f.d.a()) {
                th.printStackTrace();
            }
            if (aVar != null) {
                aVar.a(this, new IOException(th.getMessage()));
            }
        }
    }

    public b.b.a.a.j.b b() {
        try {
            l.a aVar = new l.a();
            if (this.f) {
                aVar.a(this.d);
            } else {
                g.a aVar2 = new g.a();
                Uri uri = Uri.parse(this.d);
                aVar2.f(uri.getScheme());
                aVar2.c(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                        encodedPath = encodedPath.substring(1);
                    }
                    aVar2.a(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.g.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.g.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        aVar2.a(strEncode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                aVar.a(aVar2.a());
            }
            a(aVar);
            aVar.a(this.e);
            aVar.a((Object) a());
            n nVarB = this.a.a(aVar.b().a()).b();
            if (nVarB == null) {
                return null;
            }
            HashMap map = new HashMap();
            f fVarC = nVarB.c();
            if (fVarC != null) {
                for (int i = 0; i < fVarC.a(); i++) {
                    map.put(fVarC.a(i), fVarC.b(i));
                }
            }
            o oVarA = nVarB.a();
            return new b.b.a.a.j.b(nVarB.d(), nVarB.b(), nVarB.e(), map, oVarA != null ? oVarA.d() : "", nVarB.h(), nVarB.g());
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
