package b.b.a.a.f.a.p.b;

import android.text.TextUtils;
import b.b.a.a.f.a.k;
import b.b.a.a.f.a.l;
import b.b.a.a.f.a.n;
import b.b.a.a.f.a.o;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: NetResponse.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends n {
    HttpURLConnection a;

    public f(HttpURLConnection httpURLConnection, l lVar) {
        this.a = httpURLConnection;
    }

    @Override // b.b.a.a.f.a.n
    public o a() {
        try {
            return new g(this.a);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // b.b.a.a.f.a.n
    public int b() {
        try {
            return this.a.getResponseCode();
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // b.b.a.a.f.a.n
    public b.b.a.a.f.a.f c() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : this.a.getHeaderFields().entrySet()) {
            for (String str : entry.getValue()) {
                if (!HttpHeaders.CONTENT_RANGE.equalsIgnoreCase(entry.getKey()) || b() != 206) {
                    arrayList.add(entry.getKey());
                    arrayList.add(str);
                }
            }
        }
        return new b.b.a.a.f.a.f((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @Override // b.b.a.a.f.a.n, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            a().close();
        } catch (Exception unused) {
        }
    }

    @Override // b.b.a.a.f.a.n
    public boolean d() {
        return b() >= 200 && b() < 300;
    }

    @Override // b.b.a.a.f.a.n
    public String e() throws IOException {
        return this.a.getResponseMessage();
    }

    @Override // b.b.a.a.f.a.n
    public k f() {
        return k.HTTP_1_1;
    }

    @Override // b.b.a.a.f.a.n
    public long g() {
        return 0L;
    }

    @Override // b.b.a.a.f.a.n
    public long h() {
        return 0L;
    }

    public String toString() {
        return "";
    }

    public String a(String str) {
        return this.a.getHeaderField(str);
    }

    @Override // b.b.a.a.f.a.n
    public String a(String str, String str2) {
        return !TextUtils.isEmpty(a(str)) ? a(str) : str2;
    }
}
