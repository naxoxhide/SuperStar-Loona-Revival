package com.fyber.inneractive.sdk.network;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.webkit.ProxyConfig;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
public class v0 extends h implements g {
    public final OkHttpClient a = new OkHttpClient().newBuilder().build();

    public static class a extends j {
        public final Response g;

        public a(j jVar, Response response) {
            this.g = response;
            a(jVar.d());
            a(jVar.b());
            a(jVar.c());
            a(jVar.e());
        }

        @Override // com.fyber.inneractive.sdk.network.j
        public void a() throws IOException {
            super.a();
            Response response = this.g;
            if (response != null) {
                response.close();
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.network.g
    public <T> j a(c0<T> c0Var, String str, String str2) throws Exception {
        IAlog.a("%s okhttp network stack is in use", "OkHttpExecutorImpl");
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(c0Var.a());
            Pair<List<String>, Response> pairA = a(c0Var.a(), c0Var, arrayList, str, str2);
            Object obj = pairA.second;
            String strMessage = obj != null ? ((Response) obj).message() : "";
            InputStream inputStreamA = a((Response) pairA.second);
            Object obj2 = pairA.second;
            int iCode = obj2 == null ? -1 : ((Response) obj2).code();
            Map<String, List<String>> mapB = b((Response) pairA.second);
            Response response = (Response) pairA.second;
            a aVar = new a(a(inputStreamA, iCode, strMessage, mapB, response != null ? response.headers().get(HttpHeaders.LAST_MODIFIED) : null), (Response) pairA.second);
            Iterator it = ((List) pairA.first).iterator();
            while (it.hasNext()) {
                aVar.f.add((String) it.next());
            }
            return aVar;
        } catch (b e) {
            IAlog.b("%s cannot connect exception: %s", "OkHttpExecutorImpl", e.getMessage());
            throw e;
        } catch (Exception e2) {
            IAlog.b("%s exception: %s", "OkHttpExecutorImpl", e2.getMessage());
            throw e2;
        }
    }

    public final Map<String, List<String>> b(Response response) {
        HashMap map = new HashMap();
        if (response != null) {
            Headers headers = response.headers();
            for (int i = 0; i < headers.size(); i++) {
                String strName = headers.name(i);
                map.put(strName, Collections.singletonList(headers.get(strName)));
            }
        }
        return map;
    }

    @Override // com.fyber.inneractive.sdk.network.g
    public void b() {
    }

    public final <T> Pair<List<String>, Response> a(String str, c0<T> c0Var, List<String> list, String str2, String str3) throws Exception {
        String strHeader;
        t0 t0VarN = c0Var.n();
        Request.Builder builder = new Request.Builder();
        a(builder, HttpHeaders.ACCEPT_ENCODING, "gzip");
        a(builder, "User-Agent", str2);
        a(builder, HttpHeaders.IF_MODIFIED_SINCE, str3);
        Map<String, String> mapW = c0Var.w();
        if (mapW != null) {
            for (String str4 : mapW.keySet()) {
                a(builder, str4, mapW.get(str4));
            }
        }
        builder.url(str);
        if (c0Var.r() == z.POST || c0Var.r() == z.PUT) {
            byte[] bArrU = c0Var.u();
            if (bArrU != null) {
                builder.post(RequestBody.create(bArrU, MediaType.parse(c0Var.q())));
            } else {
                throw new Exception("Could not create ok http request. post payload is null");
            }
        }
        Request requestBuild = builder.build();
        OkHttpClient.Builder builderFollowSslRedirects = this.a.newBuilder().followRedirects(c0Var.l()).followSslRedirects(c0Var.l());
        long j = t0VarN.a;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient okHttpClientBuild = builderFollowSslRedirects.connectTimeout(j, timeUnit).readTimeout(t0VarN.f994b, timeUnit).build();
        c0Var.b(System.currentTimeMillis());
        IAlog.a("OkHttpExecutorImpl: start connection timestamp: %s", c0Var.f());
        try {
            try {
                Response responseExecute = okHttpClientBuild.newCall(requestBuild).execute();
                if (!c0Var.l() && (((responseExecute.code() > 300 && responseExecute.code() < 304) || responseExecute.code() == 307 || responseExecute.code() == 308) && (strHeader = responseExecute.header(HttpHeaders.LOCATION, "")) != null)) {
                    if (!strHeader.startsWith(ProxyConfig.MATCH_HTTP) && !strHeader.contains("://") && list.size() > 0) {
                        Uri uri = Uri.parse(list.get(list.size() - 1));
                        strHeader = String.format(strHeader.startsWith(RemoteSettings.FORWARD_SLASH_STRING) ? "%s://%s%s" : "%s://%s/%s", uri.getScheme(), uri.getHost(), strHeader);
                    }
                    list.add(strHeader);
                    if (list.size() <= 5) {
                        Pair<List<String>, Response> pairA = a(strHeader, c0Var, list, str2, str3);
                        c0Var.a(System.currentTimeMillis());
                        IAlog.a("OkHttpExecutorImpl: end connection timestamp: %s", c0Var.f());
                        return pairA;
                    }
                    throw new b("Url chain too big for us");
                }
                Pair<List<String>, Response> pair = new Pair<>(list, responseExecute);
                c0Var.a(System.currentTimeMillis());
                IAlog.a("OkHttpExecutorImpl: end connection timestamp: %s", c0Var.f());
                return pair;
            } catch (Exception e) {
                throw new b(e);
            }
        } catch (Throwable th) {
            c0Var.a(System.currentTimeMillis());
            IAlog.a("OkHttpExecutorImpl: end connection timestamp: %s", c0Var.f());
            throw th;
        }
    }

    public final InputStream a(Response response) {
        if (response == null) {
            return null;
        }
        try {
            if (response.body() == null) {
                return null;
            }
            return a(response.body().byteStream(), TextUtils.equals("gzip", response.headers().get("content-encoding")));
        } catch (Exception unused) {
            return null;
        }
    }

    public final void a(Request.Builder builder, String str, String str2) {
        int i = IAlog.a;
        IAlog.a(1, null, "%s %s : %s", "REQUEST_HEADER", str, str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.addHeader(str, str2);
    }
}
