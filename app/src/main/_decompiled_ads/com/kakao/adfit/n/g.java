package com.kakao.adfit.n;

import com.google.common.net.HttpHeaders;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: HurlStack.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends com.kakao.adfit.n.a {
    private final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SSLSocketFactory f1858b;

    /* JADX INFO: compiled from: HurlStack.java */
    static class a extends FilterInputStream {
        private final HttpURLConnection a;

        a(HttpURLConnection httpURLConnection) {
            super(g.b(httpURLConnection));
            this.a = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            this.a.disconnect();
        }
    }

    /* JADX INFO: compiled from: HurlStack.java */
    public interface b {
        String a(String str);
    }

    public g() {
        this(null);
    }

    private static boolean a(int i, int i2) {
        return (i == 4 || (100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    public g(b bVar) {
        this(bVar, null);
    }

    @Override // com.kakao.adfit.n.a
    public f a(com.kakao.adfit.common.volley.e<?> eVar, Map<String, String> map) throws IOException {
        String strQ = eVar.q();
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.putAll(eVar.f());
        b bVar = this.a;
        if (bVar != null) {
            String strA = bVar.a(strQ);
            if (strA == null) {
                throw new IOException("URL blocked by rewriter: " + strQ);
            }
            strQ = strA;
        }
        HttpURLConnection httpURLConnectionA = a(new URL(strQ), eVar);
        try {
            for (String str : map2.keySet()) {
                httpURLConnectionA.setRequestProperty(str, (String) map2.get(str));
            }
            b(httpURLConnectionA, eVar);
            int responseCode = httpURLConnectionA.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if (a(eVar.g(), responseCode)) {
                return new f(responseCode, a(httpURLConnectionA.getHeaderFields()), httpURLConnectionA.getContentLength(), a(eVar, httpURLConnectionA));
            }
            f fVar = new f(responseCode, a(httpURLConnectionA.getHeaderFields()));
            httpURLConnectionA.disconnect();
            return fVar;
        } catch (Throwable th) {
            if (0 == 0) {
                httpURLConnectionA.disconnect();
            }
            throw th;
        }
    }

    public g(b bVar, SSLSocketFactory sSLSocketFactory) {
        this.a = bVar;
        this.f1858b = sSLSocketFactory;
    }

    void b(HttpURLConnection httpURLConnection, com.kakao.adfit.common.volley.e<?> eVar) throws IOException {
        switch (eVar.g()) {
            case -1:
                byte[] bArrJ = eVar.j();
                if (bArrJ != null) {
                    httpURLConnection.setRequestMethod("POST");
                    a(httpURLConnection, eVar, bArrJ);
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                a(httpURLConnection, eVar);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                a(httpURLConnection, eVar);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                a(httpURLConnection, eVar);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    static List<com.kakao.adfit.m.b> a(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.kakao.adfit.m.b(entry.getKey(), it.next()));
                }
            }
        }
        return arrayList;
    }

    protected InputStream a(com.kakao.adfit.common.volley.e<?> eVar, HttpURLConnection httpURLConnection) {
        return new a(httpURLConnection);
    }

    protected HttpURLConnection a(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    private HttpURLConnection a(URL url, com.kakao.adfit.common.volley.e<?> eVar) {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection httpURLConnectionA = a(url);
        int iO = eVar.o();
        httpURLConnectionA.setConnectTimeout(iO);
        httpURLConnectionA.setReadTimeout(iO);
        httpURLConnectionA.setUseCaches(false);
        httpURLConnectionA.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.f1858b) != null) {
            ((HttpsURLConnection) httpURLConnectionA).setSSLSocketFactory(sSLSocketFactory);
        }
        return httpURLConnectionA;
    }

    private void a(HttpURLConnection httpURLConnection, com.kakao.adfit.common.volley.e<?> eVar) throws IOException {
        byte[] bArrB = eVar.b();
        if (bArrB != null) {
            a(httpURLConnection, eVar, bArrB);
        }
    }

    private void a(HttpURLConnection httpURLConnection, com.kakao.adfit.common.volley.e<?> eVar, byte[] bArr) throws IOException {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey(HttpHeaders.CONTENT_TYPE)) {
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, eVar.c());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(a(eVar, httpURLConnection, bArr.length));
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    protected OutputStream a(com.kakao.adfit.common.volley.e<?> eVar, HttpURLConnection httpURLConnection, int i) {
        return httpURLConnection.getOutputStream();
    }
}
