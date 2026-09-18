package com.mbridge.msdk.click;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.w;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: JavaHttpSpider.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    private static final String a = "f";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.c.c f1933b;
    private String c;
    private boolean d = true;
    private final int e = 3145728;
    private a f;

    public f() {
        com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
        this.f1933b = cVarB;
        if (cVarB == null) {
            this.f1933b = com.mbridge.msdk.c.d.a().b();
        }
    }

    /* JADX INFO: compiled from: JavaHttpSpider.java */
    public static class a {
        public String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f1934b;
        public String c;
        public String d;
        public int e;
        public int f;
        public String g;
        public String h;

        public final String toString() {
            return "http response header：...\nstatusCode=" + this.f + ", location=" + this.a + ", contentType=" + this.f1934b + ", contentLength=" + this.e + ", contentEncoding=" + this.c + ", referer=" + this.d;
        }

        public final String a() {
            return "statusCode=" + this.f + ", location=" + this.a + ", contentType=" + this.f1934b + ", contentLength=" + this.e + ", contentEncoding=" + this.c + ", referer=" + this.d;
        }
    }

    public final a a(String str, boolean z, boolean z2, CampaignEx campaignEx) {
        HttpURLConnection httpURLConnection = null;
        if (!URLUtil.isNetworkUrl(str)) {
            return null;
        }
        String strReplace = str.replace(" ", "%20");
        this.f = new a();
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(strReplace).openConnection();
            try {
                httpURLConnection2.setRequestMethod("GET");
                if ((!z && !z2) || campaignEx == null) {
                    httpURLConnection2.setRequestProperty("User-Agent", w.l());
                }
                if (z && campaignEx != null && campaignEx.getcUA() == 1) {
                    httpURLConnection2.setRequestProperty("User-Agent", w.l());
                }
                if (z2 && campaignEx != null && campaignEx.getImpUA() == 1) {
                    httpURLConnection2.setRequestProperty("User-Agent", w.l());
                }
                httpURLConnection2.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "gzip");
                if (this.f1933b.V() && !TextUtils.isEmpty(this.c)) {
                    httpURLConnection2.setRequestProperty("referer", this.c);
                }
                httpURLConnection2.setConnectTimeout(60000);
                httpURLConnection2.setReadTimeout(60000);
                httpURLConnection2.setInstanceFollowRedirects(false);
                httpURLConnection2.connect();
                this.f.a = httpURLConnection2.getHeaderField(HttpHeaders.LOCATION);
                this.f.d = httpURLConnection2.getHeaderField(HttpHeaders.REFERER);
                this.f.f = httpURLConnection2.getResponseCode();
                this.f.f1934b = httpURLConnection2.getContentType();
                this.f.e = httpURLConnection2.getContentLength();
                this.f.c = httpURLConnection2.getContentEncoding();
                boolean zEqualsIgnoreCase = "gzip".equalsIgnoreCase(this.f.c);
                if (this.f.f == 200 && this.d && this.f.e > 0 && this.f.e < 3145728 && !TextUtils.isEmpty(strReplace)) {
                    try {
                        String strA = a(httpURLConnection2.getInputStream(), zEqualsIgnoreCase);
                        if (!TextUtils.isEmpty(strA)) {
                            byte[] bytes = strA.getBytes();
                            if (bytes.length > 0 && bytes.length < 3145728) {
                                this.f.g = strA.trim();
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                this.c = strReplace;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return this.f;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnection2;
                try {
                    this.f.h = th.getMessage();
                    return this.f;
                } finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0033 A[Catch: all -> 0x002c, TryCatch #5 {all -> 0x002c, blocks: (B:4:0x0008, B:5:0x000e, B:19:0x002f, B:21:0x0033, B:22:0x0040), top: B:36:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0045 A[Catch: Exception -> 0x0049, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x0049, blocks: (B:10:0x0022, B:24:0x0045), top: B:39:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private String a(InputStream inputStream, boolean z) throws Throwable {
        Throwable th;
        Exception e;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            if (z) {
                try {
                    try {
                        inputStream = new GZIPInputStream(inputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    if (this.f == null) {
                        a aVar = new a();
                        this.f = aVar;
                        aVar.h = e.getMessage();
                    }
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return sb.toString();
                }
            }
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                } catch (Exception e4) {
                    e = e4;
                    bufferedReader = bufferedReader2;
                    if (this.f == null) {
                        a aVar2 = new a();
                        this.f = aVar2;
                        aVar2.h = e.getMessage();
                    }
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return sb.toString();
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
            bufferedReader2.close();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return sb.toString();
    }
}
