package com.applovin.exoplayer2.k;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.webkit.ProxyConfig;
import com.applovin.exoplayer2.common.base.Predicate;
import com.applovin.exoplayer2.l.ai;
import com.facebook.ads.AdError;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes.dex */
public class q extends e implements t {
    private InputStream Zi;
    private boolean Zk;
    private Predicate<String> aaA;
    private HttpURLConnection aaB;
    private int aaC;
    private long aaD;
    private long aaE;
    private final boolean aau;
    private final int aav;
    private final int aaw;
    private final t.f aax;
    private final t.f aay;
    private final boolean aaz;
    private final String ta;
    private l tw;

    public static final class a implements t.b {
        private aa MH;
        private Predicate<String> aaA;
        private boolean aau;
        private boolean aaz;
        private String ta;
        private final t.f aax = new t.f();
        private int aaF = 8000;
        private int aaG = 8000;

        public a aO(String str) {
            this.ta = str;
            return this;
        }

        @Override // com.applovin.exoplayer2.k.t.b
        /* JADX INFO: renamed from: ow, reason: merged with bridge method [inline-methods] */
        public q of() {
            q qVar = new q(this.ta, this.aaF, this.aaG, this.aau, this.aax, this.aaA, this.aaz);
            aa aaVar = this.MH;
            if (aaVar != null) {
                qVar.c(aaVar);
            }
            return qVar;
        }
    }

    @Deprecated
    public q() {
        this(null, 8000, 8000);
    }

    @Deprecated
    public q(String str, int i, int i2) {
        this(str, i, i2, false, null);
    }

    @Deprecated
    public q(String str, int i, int i2, boolean z, t.f fVar) {
        this(str, i, i2, z, fVar, null, false);
    }

    private q(String str, int i, int i2, boolean z, t.f fVar, Predicate<String> predicate, boolean z2) {
        super(true);
        this.ta = str;
        this.aav = i;
        this.aaw = i2;
        this.aau = z;
        this.aax = fVar;
        this.aaA = predicate;
        this.aay = new t.f();
        this.aaz = z2;
    }

    @Override // com.applovin.exoplayer2.k.i
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.aaB;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.applovin.exoplayer2.k.i
    public Map<String, List<String>> kT() {
        HttpURLConnection httpURLConnection = this.aaB;
        return httpURLConnection == null ? Collections.emptyMap() : httpURLConnection.getHeaderFields();
    }

    @Override // com.applovin.exoplayer2.k.i
    public long a(l lVar) throws t.c {
        byte[] bArrA;
        this.tw = lVar;
        long j = 0;
        this.aaE = 0L;
        this.aaD = 0L;
        b(lVar);
        try {
            HttpURLConnection httpURLConnectionD = d(lVar);
            this.aaB = httpURLConnectionD;
            this.aaC = httpURLConnectionD.getResponseCode();
            String responseMessage = httpURLConnectionD.getResponseMessage();
            int i = this.aaC;
            if (i < 200 || i > 299) {
                Map<String, List<String>> headerFields = httpURLConnectionD.getHeaderFields();
                if (this.aaC == 416) {
                    if (lVar.uc == u.aQ(httpURLConnectionD.getHeaderField(HttpHeaders.CONTENT_RANGE))) {
                        this.Zk = true;
                        c(lVar);
                        if (lVar.wC != -1) {
                            return lVar.wC;
                        }
                        return 0L;
                    }
                }
                InputStream errorStream = httpURLConnectionD.getErrorStream();
                try {
                    bArrA = errorStream != null ? ai.a(errorStream) : ai.ada;
                } catch (IOException unused) {
                    bArrA = ai.ada;
                }
                byte[] bArr = bArrA;
                ov();
                throw new t.e(this.aaC, responseMessage, this.aaC == 416 ? new j(AdError.REMOTE_ADS_SERVICE_ERROR) : null, headerFields, lVar, bArr);
            }
            String contentType = httpURLConnectionD.getContentType();
            Predicate<String> predicate = this.aaA;
            if (predicate != null && !predicate.apply(contentType)) {
                ov();
                throw new t.d(contentType, lVar);
            }
            if (this.aaC == 200 && lVar.uc != 0) {
                j = lVar.uc;
            }
            boolean zA = a(httpURLConnectionD);
            if (zA || lVar.wC != -1) {
                this.aaD = lVar.wC;
            } else {
                long jD = u.d(httpURLConnectionD.getHeaderField(HttpHeaders.CONTENT_LENGTH), httpURLConnectionD.getHeaderField(HttpHeaders.CONTENT_RANGE));
                this.aaD = jD != -1 ? jD - j : -1L;
            }
            try {
                this.Zi = httpURLConnectionD.getInputStream();
                if (zA) {
                    this.Zi = new GZIPInputStream(this.Zi);
                }
                this.Zk = true;
                c(lVar);
                try {
                    a(j, lVar);
                    return this.aaD;
                } catch (IOException e) {
                    ov();
                    if (e instanceof t.c) {
                        throw ((t.c) e);
                    }
                    throw new t.c(e, lVar, 2000, 1);
                }
            } catch (IOException e2) {
                ov();
                throw new t.c(e2, lVar, 2000, 1);
            }
        } catch (IOException e3) {
            ov();
            throw t.c.a(e3, lVar, 1);
        }
    }

    @Override // com.applovin.exoplayer2.k.g
    public int read(byte[] bArr, int i, int i2) throws t.c {
        try {
            return l(bArr, i, i2);
        } catch (IOException e) {
            throw t.c.a(e, (l) ai.R(this.tw), 2);
        }
    }

    @Override // com.applovin.exoplayer2.k.i
    public void close() throws t.c {
        try {
            InputStream inputStream = this.Zi;
            if (inputStream != null) {
                long j = this.aaD;
                long j2 = -1;
                if (j != -1) {
                    j2 = j - this.aaE;
                }
                a(this.aaB, j2);
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new t.c(e, (l) ai.R(this.tw), 2000, 3);
                }
            }
            this.Zi = null;
            ov();
            if (this.Zk) {
                this.Zk = false;
                oe();
            }
        } catch (Throwable th) {
            this.Zi = null;
            ov();
            if (this.Zk) {
                this.Zk = false;
                oe();
            }
            throw th;
        }
    }

    private HttpURLConnection d(l lVar) throws IOException {
        URL url = new URL(lVar.ef.toString());
        int i = lVar.Zy;
        byte[] bArr = lVar.Zz;
        long j = lVar.uc;
        long j2 = lVar.wC;
        boolean zFg = lVar.fg(1);
        if (!this.aau && !this.aaz) {
            return a(url, i, bArr, j, j2, zFg, true, lVar.ZA);
        }
        URL urlA = url;
        int i2 = i;
        byte[] bArr2 = bArr;
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            if (i3 <= 20) {
                int i5 = i2;
                long j3 = j;
                URL url2 = urlA;
                long j4 = j2;
                HttpURLConnection httpURLConnectionA = a(urlA, i2, bArr2, j, j2, zFg, false, lVar.ZA);
                int responseCode = httpURLConnectionA.getResponseCode();
                String headerField = httpURLConnectionA.getHeaderField(HttpHeaders.LOCATION);
                if ((i5 == 1 || i5 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                    httpURLConnectionA.disconnect();
                    urlA = a(url2, headerField, lVar);
                    i2 = i5;
                } else {
                    if (i5 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                        return httpURLConnectionA;
                    }
                    httpURLConnectionA.disconnect();
                    if (this.aaz && responseCode == 302) {
                        i2 = i5;
                    } else {
                        bArr2 = null;
                        i2 = 1;
                    }
                    urlA = a(url2, headerField, lVar);
                }
                i3 = i4;
                j = j3;
                j2 = j4;
            } else {
                throw new t.c(new NoRouteToHostException("Too many redirects: " + i4), lVar, AdError.INTERNAL_ERROR_CODE, 1);
            }
        }
    }

    private HttpURLConnection a(URL url, int i, byte[] bArr, long j, long j2, boolean z, boolean z2, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnectionA = a(url);
        httpURLConnectionA.setConnectTimeout(this.aav);
        httpURLConnectionA.setReadTimeout(this.aaw);
        HashMap map2 = new HashMap();
        t.f fVar = this.aax;
        if (fVar != null) {
            map2.putAll(fVar.oy());
        }
        map2.putAll(this.aay.oy());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnectionA.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String strA = u.A(j, j2);
        if (strA != null) {
            httpURLConnectionA.setRequestProperty("Range", strA);
        }
        String str = this.ta;
        if (str != null) {
            httpURLConnectionA.setRequestProperty("User-Agent", str);
        }
        httpURLConnectionA.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, z ? "gzip" : "identity");
        httpURLConnectionA.setInstanceFollowRedirects(z2);
        httpURLConnectionA.setDoOutput(bArr != null);
        httpURLConnectionA.setRequestMethod(l.ff(i));
        if (bArr != null) {
            httpURLConnectionA.setFixedLengthStreamingMode(bArr.length);
            httpURLConnectionA.connect();
            OutputStream outputStream = httpURLConnectionA.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnectionA.connect();
        }
        return httpURLConnectionA;
    }

    HttpURLConnection a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    private URL a(URL url, String str, l lVar) throws t.c {
        if (str == null) {
            throw new t.c("Null location redirect", lVar, AdError.INTERNAL_ERROR_CODE, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !ProxyConfig.MATCH_HTTP.equals(protocol)) {
                throw new t.c("Unsupported protocol redirect: " + protocol, lVar, AdError.INTERNAL_ERROR_CODE, 1);
            }
            if (this.aau || protocol.equals(url.getProtocol())) {
                return url2;
            }
            throw new t.c("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", lVar, AdError.INTERNAL_ERROR_CODE, 1);
        } catch (MalformedURLException e) {
            throw new t.c(e, lVar, AdError.INTERNAL_ERROR_CODE, 1);
        }
    }

    private void a(long j, l lVar) throws IOException {
        if (j == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j > 0) {
            int i = ((InputStream) ai.R(this.Zi)).read(bArr, 0, (int) Math.min(j, 4096));
            if (Thread.currentThread().isInterrupted()) {
                throw new t.c(new InterruptedIOException(), lVar, 2000, 1);
            }
            if (i == -1) {
                throw new t.c(lVar, AdError.REMOTE_ADS_SERVICE_ERROR, 1);
            }
            j -= (long) i;
            fe(i);
        }
    }

    private int l(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.aaD;
        if (j != -1) {
            long j2 = j - this.aaE;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j2);
        }
        int i3 = ((InputStream) ai.R(this.Zi)).read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        this.aaE += (long) i3;
        fe(i3);
        return i3;
    }

    private static void a(HttpURLConnection httpURLConnection, long j) {
        if (httpURLConnection == null || ai.acV < 19 || ai.acV > 20) {
            return;
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (j == -1) {
                if (inputStream.read() == -1) {
                    return;
                }
            } else if (j <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                return;
            }
            String name = inputStream.getClass().getName();
            if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                Method declaredMethod = ((Class) com.applovin.exoplayer2.l.a.checkNotNull(inputStream.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, new Object[0]);
            }
        } catch (Exception unused) {
        }
    }

    private void ov() {
        HttpURLConnection httpURLConnection = this.aaB;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                com.applovin.exoplayer2.l.q.c("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.aaB = null;
        }
    }

    private static boolean a(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField(HttpHeaders.CONTENT_ENCODING));
    }
}
