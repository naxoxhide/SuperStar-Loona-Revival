package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.webkit.ProxyConfig;
import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class o implements g {
    public static final Pattern q = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    public static final AtomicReference<byte[]> r = new AtomicReference<>();
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1219b;
    public final int c;
    public final String d;
    public final w f;
    public final a0<? super o> h;
    public j i;
    public HttpURLConnection j;
    public InputStream k;
    public boolean l;
    public long m;
    public long n;
    public long o;
    public long p;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.m<String> e = null;
    public final w g = new w();

    public o(String str, com.fyber.inneractive.sdk.player.exoplayer2.util.m<String> mVar, a0<? super o> a0Var, int i, int i2, boolean z, w wVar) {
        this.d = com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(str);
        this.h = a0Var;
        this.f1219b = i;
        this.c = i2;
        this.a = z;
        this.f = wVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public Uri a() {
        HttpURLConnection httpURLConnection = this.j;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final HttpURLConnection b(j jVar) throws IOException {
        URL url = new URL(jVar.a.toString());
        byte[] bArr = jVar.f1214b;
        long j = jVar.d;
        long j2 = jVar.e;
        boolean zA = jVar.a(1);
        if (!this.a) {
            return a(url, bArr, j, j2, zA, true);
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i > 20) {
                throw new NoRouteToHostException("Too many redirects: " + i2);
            }
            long j3 = j;
            HttpURLConnection httpURLConnectionA = a(url, bArr, j, j2, zA, false);
            int responseCode = httpURLConnectionA.getResponseCode();
            if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && (bArr != null || (responseCode != 307 && responseCode != 308))) {
                return httpURLConnectionA;
            }
            bArr = null;
            String headerField = httpURLConnectionA.getHeaderField(HttpHeaders.LOCATION);
            httpURLConnectionA.disconnect();
            if (headerField == null) {
                throw new ProtocolException("Null location redirect");
            }
            URL url2 = new URL(url, headerField);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !ProxyConfig.MATCH_HTTP.equals(protocol)) {
                throw new ProtocolException("Unsupported protocol redirect: " + protocol);
            }
            url = url2;
            i = i2;
            j = j3;
        }
    }

    public final void c() throws IOException {
        if (this.o == this.m) {
            return;
        }
        byte[] andSet = r.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (true) {
            long j = this.o;
            long j2 = this.m;
            if (j == j2) {
                r.set(andSet);
                return;
            }
            int i = this.k.read(andSet, 0, (int) Math.min(j2 - j, andSet.length));
            if (Thread.interrupted()) {
                throw new InterruptedIOException();
            }
            if (i == -1) {
                throw new EOFException();
            }
            long j3 = i;
            this.o += j3;
            a0<? super o> a0Var = this.h;
            if (a0Var != null) {
                l lVar = (l) a0Var;
                synchronized (lVar) {
                    lVar.d += j3;
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public void close() throws t {
        try {
            if (this.k != null) {
                HttpURLConnection httpURLConnection = this.j;
                long j = this.n;
                if (j != -1) {
                    j -= this.p;
                }
                a(httpURLConnection, j);
                try {
                    this.k.close();
                } catch (IOException e) {
                    throw new t(e, this.i, 3);
                }
            }
            this.k = null;
            b();
            if (this.l) {
                this.l = false;
                a0<? super o> a0Var = this.h;
                if (a0Var != null) {
                    ((l) a0Var).a(this);
                }
            }
        } catch (Throwable th) {
            this.k = null;
            b();
            if (this.l) {
                this.l = false;
                a0<? super o> a0Var2 = this.h;
                if (a0Var2 != null) {
                    ((l) a0Var2).a(this);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0046  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public long a(j jVar) throws t {
        long j;
        long jMax;
        this.i = jVar;
        this.p = 0L;
        this.o = 0L;
        try {
            HttpURLConnection httpURLConnectionB = b(jVar);
            this.j = httpURLConnectionB;
            try {
                int responseCode = httpURLConnectionB.getResponseCode();
                if (responseCode < 200 || responseCode > 299) {
                    Map<String, List<String>> headerFields = this.j.getHeaderFields();
                    b();
                    v vVar = new v(responseCode, headerFields, jVar);
                    if (responseCode != 416) {
                        throw vVar;
                    }
                    vVar.initCause(new h(0));
                    throw vVar;
                }
                String contentType = this.j.getContentType();
                com.fyber.inneractive.sdk.player.exoplayer2.util.m<String> mVar = this.e;
                if (mVar != null && !mVar.a(contentType)) {
                    b();
                    throw new u(contentType, jVar);
                }
                if (responseCode == 200) {
                    j = jVar.d;
                    if (j == 0) {
                        j = 0;
                    }
                } else {
                    j = 0;
                }
                this.m = j;
                if (jVar.a(1)) {
                    this.n = jVar.e;
                } else {
                    long j2 = jVar.e;
                    if (j2 != -1) {
                        this.n = j2;
                    } else {
                        HttpURLConnection httpURLConnection = this.j;
                        String headerField = httpURLConnection.getHeaderField(HttpHeaders.CONTENT_LENGTH);
                        if (TextUtils.isEmpty(headerField)) {
                            jMax = -1;
                        } else {
                            try {
                                jMax = Long.parseLong(headerField);
                            } catch (NumberFormatException unused) {
                                Log.e("DefaultHttpDataSource", "Unexpected Content-Length [" + headerField + "]");
                                jMax = -1;
                            }
                        }
                        String headerField2 = httpURLConnection.getHeaderField(HttpHeaders.CONTENT_RANGE);
                        if (!TextUtils.isEmpty(headerField2)) {
                            Matcher matcher = q.matcher(headerField2);
                            if (matcher.find()) {
                                try {
                                    long j3 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                                    if (jMax < 0) {
                                        jMax = j3;
                                    } else if (jMax != j3) {
                                        Log.w("DefaultHttpDataSource", "Inconsistent headers [" + headerField + "] [" + headerField2 + "]");
                                        jMax = Math.max(jMax, j3);
                                    }
                                } catch (NumberFormatException unused2) {
                                    Log.e("DefaultHttpDataSource", "Unexpected Content-Range [" + headerField2 + "]");
                                }
                            }
                        }
                        this.n = jMax != -1 ? jMax - this.m : -1L;
                    }
                }
                try {
                    this.k = this.j.getInputStream();
                    this.l = true;
                    a0<? super o> a0Var = this.h;
                    if (a0Var != null) {
                        ((l) a0Var).a(this, jVar);
                    }
                    return this.n;
                } catch (IOException e) {
                    b();
                    throw new t(e, jVar, 1);
                }
            } catch (IOException e2) {
                b();
                throw new t("Unable to connect to " + jVar.a.toString(), e2, jVar, 1);
            }
        } catch (IOException e3) {
            throw new t("Unable to connect to " + jVar.a.toString(), e3, jVar, 1);
        }
    }

    public final int b(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.n;
        if (j != -1) {
            long j2 = j - this.p;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j2);
        }
        int i3 = this.k.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.n == -1) {
                return -1;
            }
            throw new EOFException();
        }
        long j3 = i3;
        this.p += j3;
        a0<? super o> a0Var = this.h;
        if (a0Var != null) {
            l lVar = (l) a0Var;
            synchronized (lVar) {
                lVar.d += j3;
            }
        }
        return i3;
    }

    public final void b() {
        HttpURLConnection httpURLConnection = this.j;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.j = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public int a(byte[] bArr, int i, int i2) throws t {
        try {
            c();
            return b(bArr, i, i2);
        } catch (IOException e) {
            throw new t(e, this.i, 2);
        }
    }

    public final HttpURLConnection a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) throws IOException {
        Map<String, String> map;
        Map<String, String> map2;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f1219b);
        httpURLConnection.setReadTimeout(this.c);
        w wVar = this.f;
        if (wVar != null) {
            synchronized (wVar) {
                if (wVar.f1222b == null) {
                    wVar.f1222b = Collections.unmodifiableMap(new HashMap(wVar.a));
                }
                map2 = wVar.f1222b;
            }
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        w wVar2 = this.g;
        synchronized (wVar2) {
            if (wVar2.f1222b == null) {
                wVar2.f1222b = Collections.unmodifiableMap(new HashMap(wVar2.a));
            }
            map = wVar2.f1222b;
        }
        for (Map.Entry<String, String> entry2 : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
        }
        if (j != 0 || j2 != -1) {
            String str = "bytes=" + j + "-";
            if (j2 != -1) {
                str = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.d);
        if (!z) {
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length == 0) {
                httpURLConnection.connect();
            } else {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
            }
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    public static void a(HttpURLConnection httpURLConnection, long j) {
        int i = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a;
        if (i == 19 || i == 20) {
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
                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }
}
