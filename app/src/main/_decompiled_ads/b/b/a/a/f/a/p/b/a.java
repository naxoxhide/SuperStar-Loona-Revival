package b.b.a.a.f.a.p.b;

import android.text.TextUtils;
import b.b.a.a.f.a.h;
import b.b.a.a.f.a.j;
import b.b.a.a.f.a.l;
import b.b.a.a.f.a.m;
import b.b.a.a.f.a.n;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: NetCall.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b.b.a.a.f.a.b {
    l a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f153b = new AtomicBoolean(false);
    b.b.a.a.f.a.d c;

    /* JADX INFO: renamed from: b.b.a.a.f.a.p.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NetCall.java */
    class C0033a implements h {
        C0033a() {
        }

        @Override // b.b.a.a.f.a.h
        public n a(h.a aVar) throws IOException {
            return a.this.a(aVar.a());
        }
    }

    /* JADX INFO: compiled from: NetCall.java */
    class b implements Runnable {
        final /* synthetic */ b.b.a.a.f.a.c a;

        b(b.b.a.a.f.a.c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                n nVarB = a.this.b();
                if (nVarB == null) {
                    this.a.a(a.this, new IOException("response is null"));
                } else {
                    this.a.a(a.this, nVarB);
                }
            } catch (IOException e) {
                e.printStackTrace();
                this.a.a(a.this, e);
            }
        }
    }

    a(l lVar, b.b.a.a.f.a.d dVar) {
        this.a = lVar;
        this.c = dVar;
    }

    private boolean a(m mVar) {
        l lVar;
        byte[] bArr;
        return mVar != null && (lVar = this.a) != null && "POST".equalsIgnoreCase(lVar.d()) && mVar.d == m.a.BYTE_ARRAY_TYPE && (bArr = mVar.c) != null && bArr.length > 0;
    }

    private boolean c() {
        if (this.a.c() == null) {
            return false;
        }
        return this.a.c().containsKey(HttpHeaders.CONTENT_TYPE);
    }

    @Override // b.b.a.a.f.a.b
    public n b() throws IOException {
        List<h> list;
        this.c.c().remove(this);
        this.c.d().add(this);
        if (this.c.c().size() + this.c.d().size() > this.c.a() || this.f153b.get()) {
            this.c.d().remove(this);
            return null;
        }
        try {
            j jVar = this.a.a;
            if (jVar == null || (list = jVar.a) == null || list.size() <= 0) {
                return a(this.a);
            }
            ArrayList arrayList = new ArrayList(this.a.a.a);
            arrayList.add(new C0033a());
            return ((h) arrayList.get(0)).a(new b.b.a.a.f.a.p.b.b(arrayList, this.a));
        } catch (Throwable th) {
            throw new IOException(th.getMessage());
        }
    }

    public n a(l lVar) throws IOException {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(lVar.g().e().toString()).openConnection();
                if (lVar.c() != null && lVar.c().size() > 0) {
                    for (Map.Entry<String, List<String>> entry : lVar.c().entrySet()) {
                        Iterator<String> it = entry.getValue().iterator();
                        while (it.hasNext()) {
                            httpURLConnection.addRequestProperty(entry.getKey(), it.next());
                        }
                    }
                }
                j jVar = lVar.a;
                if (jVar != null) {
                    TimeUnit timeUnit = jVar.c;
                    if (timeUnit != null) {
                        httpURLConnection.setConnectTimeout((int) timeUnit.toMillis(jVar.f146b));
                    }
                    j jVar2 = lVar.a;
                    if (jVar2.c != null) {
                        httpURLConnection.setReadTimeout((int) jVar2.e.toMillis(jVar2.d));
                    }
                }
                if (lVar.a() == null) {
                    httpURLConnection.setRequestMethod("GET");
                } else {
                    if (!c() && lVar.a().a != null) {
                        httpURLConnection.addRequestProperty(HttpHeaders.CONTENT_TYPE, lVar.a().a.a());
                    }
                    httpURLConnection.setRequestMethod(lVar.d());
                    if ("POST".equalsIgnoreCase(lVar.d())) {
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        if (a(lVar.a())) {
                            outputStream.write(lVar.a().c);
                        } else if (b(lVar.a())) {
                            outputStream.write(lVar.a().f151b.getBytes());
                        }
                        outputStream.flush();
                        outputStream.close();
                    }
                }
                httpURLConnection.connect();
                httpURLConnection.getResponseCode();
                if (this.f153b.get()) {
                    httpURLConnection.disconnect();
                    this.c.d().remove(this);
                    return null;
                }
                f fVar = new f(httpURLConnection, lVar);
                this.c.d().remove(this);
                return fVar;
            } catch (Exception e) {
                throw new IOException(e.getMessage());
            }
        } catch (Throwable th) {
            this.c.d().remove(this);
            throw th;
        }
    }

    private boolean b(m mVar) {
        l lVar;
        return (mVar == null || (lVar = this.a) == null || !"POST".equalsIgnoreCase(lVar.d()) || mVar.d != m.a.STRING_TYPE || TextUtils.isEmpty(mVar.f151b)) ? false : true;
    }

    @Override // b.b.a.a.f.a.b
    public void a(b.b.a.a.f.a.c cVar) {
        this.c.b().submit(new b(cVar));
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b.b.a.a.f.a.b clone() {
        return new a(this.a, this.c);
    }
}
