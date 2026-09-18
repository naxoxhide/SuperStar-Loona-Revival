package com.igaworks.adpopcorn.a.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.webkit.ProxyConfig;
import com.google.common.net.HttpHeaders;
import com.igaworks.adpopcorn.cores.common.h;
import com.igaworks.adpopcorn.cores.common.l;
import com.igaworks.adpopcorn.cores.model.f;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static Handler c = new Handler(Looper.getMainLooper());
    private static String d = "APNetworkController";
    private LinkedHashMap<Integer, d> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f1491b;

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.a.g.a$a, reason: collision with other inner class name */
    class RunnableC0398a implements Runnable {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f1492b;

        RunnableC0398a(int i, f fVar) {
            this.a = i;
            this.f1492b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a.this.a != null) {
                    d dVar = (d) a.this.a.get(Integer.valueOf(this.a));
                    if (dVar == null) {
                        Iterator it = a.this.a.keySet().iterator();
                        while (it.hasNext()) {
                            if (a.this.a.get(it.next()) != null) {
                                ((d) a.this.a.get(it.next())).onNetResponseListener(this.a, this.f1492b);
                            }
                        }
                        return;
                    }
                    dVar.onNetResponseListener(this.a, this.f1492b);
                    if (this.a != 16) {
                        a.this.a.remove(Integer.valueOf(this.a));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class b extends Thread {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1493b;
        private String c;
        private boolean d = false;

        public b(Context context, int i, String str) {
            this.c = "";
            this.a = context;
            this.f1493b = i;
            this.c = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            h.a(this.a, a.this.a(this.f1493b), "CheckPackageNameThread: " + this.c, 3);
            String str = this.c;
            if (str != null || (str != null && !str.equals("default_schema"))) {
                try {
                    this.a.getPackageManager().getApplicationInfo(this.c, 0);
                    this.d = true;
                } catch (Exception unused) {
                }
            }
            f fVar = new f();
            fVar.a(this.d);
            a.this.a(this.f1493b, fVar);
        }
    }

    private class c extends Thread {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f1494b;
        private boolean c;
        private int d;
        private String e;

        private c(int i, String str) {
            this.a = "";
            this.f1494b = "";
            this.e = "";
            this.d = i;
            this.f1494b = str;
            this.e = "";
            this.c = false;
        }

        /* synthetic */ c(a aVar, int i, String str, RunnableC0398a runnableC0398a) {
            this(i, str);
        }

        /* JADX WARN: Code duplicated, block: B:54:0x010d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:56:0x00d2 A[EXC_TOP_SPLITTER, PHI: r2 r3
          0x00d2: PHI (r2v3 ??) = (r2v1 ??), (r2v2 ??), (r2v7 ??) binds: [B:25:0x00d0, B:32:0x00db, B:16:0x00c3] A[DONT_GENERATE, DONT_INLINE]
          0x00d2: PHI (r3v6 java.net.HttpURLConnection) = (r3v4 java.net.HttpURLConnection), (r3v5 java.net.HttpURLConnection), (r3v12 java.net.HttpURLConnection) binds: [B:25:0x00d0, B:32:0x00db, B:16:0x00c3] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.io.InputStream, java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v7, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r2v9 */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            HttpURLConnection httpURLConnection;
            super.run();
            ?? A = 0;
            A = 0;
            A = 0;
            A = 0;
            try {
                try {
                    h.a(a.this.f1491b, "GetHttpRequestThread", "url = " + this.f1494b, 3);
                    httpURLConnection = (HttpURLConnection) new URL(this.f1494b).openConnection();
                    try {
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setReadTimeout(10000);
                        httpURLConnection.setConnectTimeout(10000);
                        A = a.this.a(httpURLConnection);
                        if (A != 0) {
                            StringBuilder sb = new StringBuilder();
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(A));
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                } else {
                                    sb.append(line);
                                }
                            }
                            this.a = sb.toString();
                            try {
                                h.a(a.this.f1491b, a.this.a(this.d), "httpResponseString: " + new JSONObject(this.a).toString(4).trim(), 3);
                            } catch (Exception unused) {
                                h.a(a.this.f1491b, a.this.a(this.d), "httpResponseString: " + this.a, 3);
                            }
                        }
                        if (A != 0) {
                            try {
                                A.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (SocketTimeoutException unused2) {
                        this.c = true;
                        if (A != 0) {
                            A.close();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        if (A != 0) {
                            A.close();
                        }
                    }
                } catch (SocketTimeoutException unused3) {
                    httpURLConnection = null;
                } catch (Exception e3) {
                    e = e3;
                    httpURLConnection = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            A.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    A.disconnect();
                    throw th;
                }
                httpURLConnection.disconnect();
                f fVar = new f();
                fVar.b(this.c);
                fVar.b(this.a);
                String str = this.e;
                if (str != null && str.length() > 0) {
                    fVar.a(this.e);
                }
                a.this.a(this.d, fVar);
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    A.close();
                }
                A.disconnect();
                throw th;
            }
        }
    }

    public interface d {
        void onNetResponseListener(int i, f fVar);
    }

    private class e extends Thread {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f1495b;
        private boolean c;
        private int d;
        private String e;
        private com.igaworks.adpopcorn.a.c f;
        private int g;
        private boolean h;
        private int i;
        private boolean j;
        private JSONObject k;
        private String l;
        private String m;
        private JSONArray n;

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.a.g.a$e$a, reason: collision with other inner class name */
        class C0399a implements com.igaworks.adpopcorn.cores.common.a.c {
            C0399a() {
            }

            @Override // com.igaworks.adpopcorn.cores.common.a.c
            public void a(com.igaworks.adpopcorn.cores.common.a.d dVar) throws Throwable {
                if (dVar != null) {
                    h.a(a.this.f1491b, "PostHttpRequestThread", "onResult, adInfo adid : " + dVar.a(), 3);
                    if (e.this.i == 0) {
                        e.this.h = false;
                        if (dVar != null) {
                            e.this.f.a(a.this.f1491b, dVar.a());
                        } else {
                            e.this.f.a(a.this.f1491b, "");
                        }
                        e.this.a();
                    }
                }
            }
        }

        class b extends TimerTask {
            b() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() throws Throwable {
                if (e.this.h) {
                    h.a(a.this.f1491b, "PostHttpRequestThread", "AdInfo timeout", 3);
                    e.this.f.a(a.this.f1491b, "");
                    e.this.a();
                    e.this.h = false;
                    e.b(e.this);
                }
            }
        }

        public e(int i, int i2) {
            this.a = "";
            this.f1495b = "";
            this.h = true;
            this.i = 0;
            this.d = i;
            this.f1495b = "https://apapi.adpopcorn.com/ap/v1/sdk/media/offerwall";
            this.c = false;
            this.f = com.igaworks.adpopcorn.a.d.a(a.this.f1491b).e();
            this.g = i2;
            this.i = 0;
            this.h = true;
            this.j = true;
        }

        public e(int i, String str) {
            this.a = "";
            this.f1495b = "";
            this.h = true;
            this.i = 0;
            this.d = i;
            this.f1495b = str;
            this.c = false;
            this.j = true;
            this.f = com.igaworks.adpopcorn.a.d.a(a.this.f1491b).e();
        }

        public e(int i, String str, String str2, JSONArray jSONArray) {
            this.a = "";
            this.f1495b = "";
            this.h = true;
            this.i = 0;
            this.d = i;
            this.f1495b = str;
            this.c = false;
            this.j = true;
            this.m = str2;
            this.n = jSONArray;
            this.f = com.igaworks.adpopcorn.a.d.a(a.this.f1491b).e();
        }

        public e(int i, String str, JSONObject jSONObject) {
            this.a = "";
            this.f1495b = "";
            this.h = true;
            this.i = 0;
            this.d = i;
            this.f1495b = str;
            this.c = false;
            this.j = true;
            this.k = jSONObject;
            this.f = com.igaworks.adpopcorn.a.d.a(a.this.f1491b).e();
        }

        public e(int i, String str, JSONObject jSONObject, String str2) {
            this.a = "";
            this.f1495b = "";
            this.h = true;
            this.i = 0;
            this.d = i;
            this.f1495b = str;
            this.c = false;
            this.j = true;
            this.k = jSONObject;
            this.l = str2;
            this.f = com.igaworks.adpopcorn.a.d.a(a.this.f1491b).e();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:125:0x0180 A[EDGE_INSN: B:125:0x0180->B:46:0x0180 BREAK  A[LOOP:0: B:43:0x0176->B:45:0x017c], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:126:0x0250 A[EDGE_INSN: B:126:0x0250->B:58:0x0250 BREAK  A[LOOP:1: B:55:0x0246->B:57:0x024c], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:26:0x00c6 A[Catch: all -> 0x02b9, Exception -> 0x02be, SocketTimeoutException -> 0x02c2, TRY_ENTER, TRY_LEAVE, TryCatch #9 {SocketTimeoutException -> 0x02c2, Exception -> 0x02be, all -> 0x02b9, blocks: (B:4:0x0036, B:6:0x004b, B:8:0x0066, B:22:0x00be, B:23:0x00c0, B:26:0x00c6, B:38:0x00e8, B:40:0x0161, B:39:0x0125, B:52:0x01df, B:14:0x007e, B:15:0x0086, B:17:0x008d, B:20:0x00a2, B:21:0x00b5), top: B:124:0x0036 }] */
        /* JADX WARN: Code duplicated, block: B:39:0x0125 A[Catch: all -> 0x02b9, Exception -> 0x02be, SocketTimeoutException -> 0x02c2, TryCatch #9 {SocketTimeoutException -> 0x02c2, Exception -> 0x02be, all -> 0x02b9, blocks: (B:4:0x0036, B:6:0x004b, B:8:0x0066, B:22:0x00be, B:23:0x00c0, B:26:0x00c6, B:38:0x00e8, B:40:0x0161, B:39:0x0125, B:52:0x01df, B:14:0x007e, B:15:0x0086, B:17:0x008d, B:20:0x00a2, B:21:0x00b5), top: B:124:0x0036 }] */
        /* JADX WARN: Code duplicated, block: B:42:0x0167 A[Catch: Exception -> 0x02ad, SocketTimeoutException -> 0x02b0, all -> 0x0321, TRY_ENTER, TryCatch #1 {all -> 0x0321, blocks: (B:42:0x0167, B:43:0x0176, B:45:0x017c, B:46:0x0180, B:47:0x0186, B:49:0x01bb, B:50:0x01d8, B:62:0x02a9, B:81:0x02cf, B:89:0x02e1, B:54:0x0237, B:55:0x0246, B:57:0x024c, B:58:0x0250, B:59:0x0256, B:61:0x028a), top: B:114:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:45:0x017c A[Catch: Exception -> 0x02ad, SocketTimeoutException -> 0x02b0, all -> 0x0321, LOOP:0: B:43:0x0176->B:45:0x017c, LOOP_END, TryCatch #1 {all -> 0x0321, blocks: (B:42:0x0167, B:43:0x0176, B:45:0x017c, B:46:0x0180, B:47:0x0186, B:49:0x01bb, B:50:0x01d8, B:62:0x02a9, B:81:0x02cf, B:89:0x02e1, B:54:0x0237, B:55:0x0246, B:57:0x024c, B:58:0x0250, B:59:0x0256, B:61:0x028a), top: B:114:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:52:0x01df A[Catch: all -> 0x02b9, Exception -> 0x02be, SocketTimeoutException -> 0x02c2, TRY_ENTER, TRY_LEAVE, TryCatch #9 {SocketTimeoutException -> 0x02c2, Exception -> 0x02be, all -> 0x02b9, blocks: (B:4:0x0036, B:6:0x004b, B:8:0x0066, B:22:0x00be, B:23:0x00c0, B:26:0x00c6, B:38:0x00e8, B:40:0x0161, B:39:0x0125, B:52:0x01df, B:14:0x007e, B:15:0x0086, B:17:0x008d, B:20:0x00a2, B:21:0x00b5), top: B:124:0x0036 }] */
        /* JADX WARN: Code duplicated, block: B:54:0x0237 A[Catch: Exception -> 0x02ad, SocketTimeoutException -> 0x02b0, all -> 0x0321, TRY_ENTER, TryCatch #1 {all -> 0x0321, blocks: (B:42:0x0167, B:43:0x0176, B:45:0x017c, B:46:0x0180, B:47:0x0186, B:49:0x01bb, B:50:0x01d8, B:62:0x02a9, B:81:0x02cf, B:89:0x02e1, B:54:0x0237, B:55:0x0246, B:57:0x024c, B:58:0x0250, B:59:0x0256, B:61:0x028a), top: B:114:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:57:0x024c A[Catch: Exception -> 0x02ad, SocketTimeoutException -> 0x02b0, all -> 0x0321, LOOP:1: B:55:0x0246->B:57:0x024c, LOOP_END, TryCatch #1 {all -> 0x0321, blocks: (B:42:0x0167, B:43:0x0176, B:45:0x017c, B:46:0x0180, B:47:0x0186, B:49:0x01bb, B:50:0x01d8, B:62:0x02a9, B:81:0x02cf, B:89:0x02e1, B:54:0x0237, B:55:0x0246, B:57:0x024c, B:58:0x0250, B:59:0x0256, B:61:0x028a), top: B:114:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:69:0x02b5 A[Catch: IOException -> 0x02da, TRY_ENTER, TRY_LEAVE, TryCatch #0 {IOException -> 0x02da, blocks: (B:69:0x02b5, B:83:0x02d6, B:91:0x02eb), top: B:112:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:96:0x0308  */
        /* JADX WARN: Code duplicated, block: B:99:0x0314  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v10 */
        /* JADX WARN: Type inference failed for: r5v11 */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v22, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r5v23 */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v30 */
        /* JADX WARN: Type inference failed for: r5v31 */
        /* JADX WARN: Type inference failed for: r5v32 */
        /* JADX WARN: Type inference failed for: r5v33 */
        /* JADX WARN: Type inference failed for: r5v34 */
        /* JADX WARN: Type inference failed for: r5v35 */
        /* JADX WARN: Type inference failed for: r5v36 */
        /* JADX WARN: Type inference failed for: r5v37 */
        /* JADX WARN: Type inference failed for: r5v38 */
        /* JADX WARN: Type inference failed for: r5v39 */
        /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r5v5, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r5v7 */
        /* JADX WARN: Type inference failed for: r5v8 */
        /* JADX WARN: Type inference failed for: r5v9 */
        public void a() throws Throwable {
            Throwable th;
            HttpURLConnection httpURLConnection;
            InputStream inputStream;
            Exception exc;
            ?? r5;
            SocketTimeoutException socketTimeoutException;
            ?? r6;
            f fVar;
            String strA;
            InputStream inputStreamA;
            StringBuilder sb;
            BufferedReader bufferedReader;
            String line;
            Context context;
            String strA2;
            StringBuilder sbAppend;
            ?? r7;
            OutputStream outputStream;
            int i;
            a aVar;
            String string;
            InputStream inputStreamA2;
            StringBuilder sb2;
            BufferedReader bufferedReader2;
            String line2;
            try {
                try {
                    try {
                        h.a(a.this.f1491b, "PostHttpRequestThread", "url = " + this.f1495b, 3);
                        httpURLConnection = (HttpURLConnection) new URL(this.f1495b).openConnection();
                        try {
                            httpURLConnection.setRequestMethod("POST");
                            httpURLConnection.setDoInput(true);
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.setReadTimeout(10000);
                            httpURLConnection.setConnectTimeout(10000);
                            httpURLConnection.setRequestProperty("User-Agent", System.getProperty("http.agent"));
                            int i2 = this.d;
                            ?? r8 = 21;
                            r8 = 21;
                            try {
                                if (i2 != 6) {
                                    if (i2 == 17 || i2 == 21 || i2 == 22 || i2 == 26) {
                                        com.igaworks.adpopcorn.a.c cVar = this.f;
                                        Context context2 = a.this.f1491b;
                                        strA = cVar.a(context2, "", "");
                                    } else {
                                        if (i2 != 20) {
                                            if (i2 == 24 || i2 == 25) {
                                                strA = this.f.a(a.this.f1491b, "campaign_key", this.k.getString("campaign_key"));
                                            }
                                            httpURLConnection.disconnect();
                                            fVar = new f();
                                            fVar.b(this.c);
                                            fVar.b(this.a);
                                            if (this.d == 6) {
                                                this.f.a(false);
                                            }
                                            if (this.d == 16) {
                                                fVar.c(this.l);
                                            }
                                            a.this.a(this.d, fVar);
                                        }
                                        strA = this.f.a(a.this.f1491b, this.m, this.n);
                                    }
                                    if (this.j) {
                                        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
                                        outputStream = httpURLConnection.getOutputStream();
                                        i = this.d;
                                        if (i != 6 || i == 17 || i == 20 || i == 21 || i == 22 || i == 24 || i == 25 || i == 26) {
                                            h.a(a.this.f1491b, "PostHttpRequestThread", "useJsonBody parameter = " + this.e.toString(), 3);
                                            outputStream.write(this.e.toString().getBytes());
                                            outputStream.flush();
                                            outputStream.close();
                                            aVar = a.this;
                                            string = this.e.toString();
                                        } else {
                                            h.a(a.this.f1491b, "PostHttpRequestThread", "useJsonBody parameter = " + this.k.toString(), 3);
                                            outputStream.write(this.k.toString().getBytes());
                                            outputStream.flush();
                                            outputStream.close();
                                            aVar = a.this;
                                            string = this.k.toString();
                                        }
                                        inputStreamA2 = aVar.a(httpURLConnection, string);
                                        r7 = inputStreamA2;
                                        if (inputStreamA2 != null) {
                                            sb2 = new StringBuilder();
                                            bufferedReader2 = new BufferedReader(new InputStreamReader(inputStreamA2));
                                            while (true) {
                                                line2 = bufferedReader2.readLine();
                                                if (line2 != null) {
                                                    break;
                                                } else {
                                                    sb2.append(line2);
                                                }
                                            }
                                            this.a = sb2.toString();
                                            try {
                                                h.a(a.this.f1491b, a.this.a(this.d), "httpResponseString: " + new JSONObject(this.a).toString(4).trim(), 3);
                                                r7 = inputStreamA2;
                                            } catch (Exception unused) {
                                                context = a.this.f1491b;
                                                strA2 = a.this.a(this.d);
                                                sbAppend = new StringBuilder().append("httpResponseString: ").append(this.a);
                                                r8 = inputStreamA2;
                                                h.a(context, strA2, sbAppend.toString(), 3);
                                                r7 = r8;
                                            }
                                        }
                                    } else {
                                        h.a(a.this.f1491b, "PostHttpRequestThread", "q = " + this.e, 3);
                                        OutputStream outputStream2 = httpURLConnection.getOutputStream();
                                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream2, "UTF-8"));
                                        bufferedWriter.write("q=" + this.e);
                                        bufferedWriter.flush();
                                        bufferedWriter.close();
                                        outputStream2.close();
                                        inputStreamA = a.this.a(httpURLConnection);
                                        if (inputStreamA != null) {
                                            r7 = inputStreamA;
                                            sb = new StringBuilder();
                                            bufferedReader = new BufferedReader(new InputStreamReader(inputStreamA));
                                            while (true) {
                                                line = bufferedReader.readLine();
                                                if (line != null) {
                                                    break;
                                                } else {
                                                    sb.append(line);
                                                }
                                            }
                                            this.a = sb.toString();
                                            try {
                                                h.a(a.this.f1491b, a.this.a(this.d), "httpResponseString: " + new JSONObject(this.a).toString(4).trim(), 3);
                                                r7 = inputStreamA;
                                            } catch (Exception unused2) {
                                                context = a.this.f1491b;
                                                strA2 = a.this.a(this.d);
                                                sbAppend = new StringBuilder().append("httpResponseString: ").append(this.a);
                                                r8 = inputStreamA;
                                                h.a(context, strA2, sbAppend.toString(), 3);
                                                r7 = r8;
                                            }
                                        }
                                    }
                                    if (r7 != 0) {
                                        r7.close();
                                    }
                                    httpURLConnection.disconnect();
                                    fVar = new f();
                                    fVar.b(this.c);
                                    fVar.b(this.a);
                                    if (this.d == 6) {
                                        this.f.a(false);
                                    }
                                    if (this.d == 16) {
                                        fVar.c(this.l);
                                    }
                                    a.this.a(this.d, fVar);
                                }
                                strA = this.f.a(a.this.f1491b, this.g);
                                if (this.j) {
                                    httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
                                    outputStream = httpURLConnection.getOutputStream();
                                    i = this.d;
                                    if (i != 6) {
                                        h.a(a.this.f1491b, "PostHttpRequestThread", "useJsonBody parameter = " + this.e.toString(), 3);
                                        outputStream.write(this.e.toString().getBytes());
                                        outputStream.flush();
                                        outputStream.close();
                                        aVar = a.this;
                                        string = this.e.toString();
                                    } else {
                                        h.a(a.this.f1491b, "PostHttpRequestThread", "useJsonBody parameter = " + this.e.toString(), 3);
                                        outputStream.write(this.e.toString().getBytes());
                                        outputStream.flush();
                                        outputStream.close();
                                        aVar = a.this;
                                        string = this.e.toString();
                                    }
                                    inputStreamA2 = aVar.a(httpURLConnection, string);
                                    r7 = inputStreamA2;
                                    if (inputStreamA2 != null) {
                                        sb2 = new StringBuilder();
                                        bufferedReader2 = new BufferedReader(new InputStreamReader(inputStreamA2));
                                        while (true) {
                                            line2 = bufferedReader2.readLine();
                                            if (line2 != null) {
                                                break;
                                                break;
                                            }
                                            sb2.append(line2);
                                        }
                                        this.a = sb2.toString();
                                        h.a(a.this.f1491b, a.this.a(this.d), "httpResponseString: " + new JSONObject(this.a).toString(4).trim(), 3);
                                        r7 = inputStreamA2;
                                    }
                                } else {
                                    h.a(a.this.f1491b, "PostHttpRequestThread", "q = " + this.e, 3);
                                    OutputStream outputStream3 = httpURLConnection.getOutputStream();
                                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(outputStream3, "UTF-8"));
                                    bufferedWriter2.write("q=" + this.e);
                                    bufferedWriter2.flush();
                                    bufferedWriter2.close();
                                    outputStream3.close();
                                    inputStreamA = a.this.a(httpURLConnection);
                                    if (inputStreamA != null) {
                                        r7 = inputStreamA;
                                        sb = new StringBuilder();
                                        bufferedReader = new BufferedReader(new InputStreamReader(inputStreamA));
                                        while (true) {
                                            line = bufferedReader.readLine();
                                            if (line != null) {
                                                break;
                                                break;
                                            }
                                            sb.append(line);
                                        }
                                        this.a = sb.toString();
                                        h.a(a.this.f1491b, a.this.a(this.d), "httpResponseString: " + new JSONObject(this.a).toString(4).trim(), 3);
                                        r7 = inputStreamA;
                                    }
                                }
                                if (r7 != 0) {
                                    r7.close();
                                }
                            } catch (SocketTimeoutException e) {
                                socketTimeoutException = e;
                                r6 = r8;
                                socketTimeoutException.printStackTrace();
                                this.c = true;
                                this.a = "";
                                if (r6 != 0) {
                                    r6.close();
                                }
                                httpURLConnection.disconnect();
                                fVar = new f();
                                fVar.b(this.c);
                                fVar.b(this.a);
                                if (this.d == 6) {
                                    this.f.a(false);
                                }
                                if (this.d == 16) {
                                    fVar.c(this.l);
                                }
                                a.this.a(this.d, fVar);
                            } catch (Exception e2) {
                                exc = e2;
                                r5 = r8;
                                exc.printStackTrace();
                                this.a = "";
                                if (r5 != 0) {
                                    r5.close();
                                }
                                httpURLConnection.disconnect();
                                fVar = new f();
                                fVar.b(this.c);
                                fVar.b(this.a);
                                if (this.d == 6) {
                                    this.f.a(false);
                                }
                                if (this.d == 16) {
                                    fVar.c(this.l);
                                }
                                a.this.a(this.d, fVar);
                            }
                            this.e = strA;
                        } catch (SocketTimeoutException e3) {
                            socketTimeoutException = e3;
                            r6 = 0;
                        } catch (Exception e4) {
                            exc = e4;
                            r5 = 0;
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = null;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            httpURLConnection.disconnect();
                            throw th;
                        }
                    } catch (SocketTimeoutException e6) {
                        socketTimeoutException = e6;
                        r6 = 0;
                        httpURLConnection = null;
                    } catch (Exception e7) {
                        exc = e7;
                        r5 = 0;
                        httpURLConnection = null;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = null;
                        httpURLConnection = null;
                    }
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
                httpURLConnection.disconnect();
                fVar = new f();
                fVar.b(this.c);
                fVar.b(this.a);
                if (this.d == 6) {
                    this.f.a(false);
                }
                if (this.d == 16) {
                    fVar.c(this.l);
                }
                a.this.a(this.d, fVar);
            } catch (Throwable th4) {
                th = th4;
            }
        }

        static /* synthetic */ int b(e eVar) {
            int i = eVar.i;
            eVar.i = i + 1;
            return i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            super.run();
            try {
                int i = this.d;
                if (i == 6 || i == 17 || i == 21 || i == 22 || i == 20 || i == 24 || i == 25 || i == 26) {
                    if (i == 6) {
                        this.f.a(true);
                    }
                    if (!this.f.j()) {
                        h.a(a.this.f1491b, "PostHttpRequestThread", "AdPOPcornParameter creating...", 3);
                        if (l.a(a.this.f1491b).a(a.this.f1491b, new C0399a()) == null) {
                            try {
                                new Timer().schedule(new b(), 3000L);
                                return;
                            } catch (Exception unused) {
                                return;
                            }
                        }
                        return;
                    }
                    h.a(a.this.f1491b, "PostHttpRequestThread", "AdPOPcornParameter already initialized", 3);
                    if (this.g == 1) {
                        this.f.a(a.this.f1491b, this.f.a());
                    }
                }
                a();
            } catch (Exception e) {
                e.printStackTrace();
                this.f.a(false);
            }
        }
    }

    public a(Context context) {
        this.f1491b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InputStream a(URLConnection uRLConnection) {
        boolean z;
        HttpURLConnection httpURLConnection;
        int responseCode;
        InputStream inputStream = null;
        int i = 0;
        do {
            try {
                if (uRLConnection instanceof HttpURLConnection) {
                    ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(false);
                }
                inputStream = uRLConnection.getInputStream();
                if ((uRLConnection instanceof HttpURLConnection) && (responseCode = (httpURLConnection = (HttpURLConnection) uRLConnection).getResponseCode()) >= 300 && responseCode <= 307 && responseCode != 306 && responseCode != 304) {
                    URL url = httpURLConnection.getURL();
                    String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                    h.a(this.f1491b, d, "openConnectionCheckRedirects, loc: " + headerField, 3);
                    URL url2 = headerField != null ? new URL(url, headerField) : null;
                    httpURLConnection.disconnect();
                    if (url2 != null && ((url2.getProtocol().equals(ProxyConfig.MATCH_HTTP) || url2.getProtocol().equals("https")) && i < 5)) {
                        uRLConnection = url2.openConnection();
                        i++;
                        z = true;
                    }
                    return null;
                }
                z = false;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } while (z);
        return inputStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InputStream a(URLConnection uRLConnection, String str) {
        boolean z;
        HttpURLConnection httpURLConnection;
        int responseCode;
        InputStream inputStream = null;
        int i = 0;
        do {
            try {
                if (uRLConnection instanceof HttpURLConnection) {
                    ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(false);
                }
                inputStream = uRLConnection.getInputStream();
                z = true;
                if ((uRLConnection instanceof HttpURLConnection) && (responseCode = (httpURLConnection = (HttpURLConnection) uRLConnection).getResponseCode()) >= 300 && responseCode <= 307 && responseCode != 306 && responseCode != 304) {
                    URL url = httpURLConnection.getURL();
                    String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                    h.a(this.f1491b, d, "openConnectionCheckRedirectsJsonBody, loc: " + headerField, 3);
                    URL url2 = headerField != null ? new URL(url, headerField) : null;
                    httpURLConnection.disconnect();
                    if (url2 != null && ((url2.getProtocol().equals(ProxyConfig.MATCH_HTTP) || url2.getProtocol().equals("https")) && i < 5)) {
                        uRLConnection = url2.openConnection();
                        ((HttpURLConnection) uRLConnection).setRequestMethod("POST");
                        uRLConnection.setDoInput(true);
                        uRLConnection.setDoOutput(true);
                        uRLConnection.setReadTimeout(10000);
                        uRLConnection.setConnectTimeout(10000);
                        uRLConnection.setRequestProperty("User-Agent", System.getProperty("http.agent"));
                        uRLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
                        OutputStream outputStream = uRLConnection.getOutputStream();
                        outputStream.write(str.getBytes());
                        outputStream.flush();
                        outputStream.close();
                        i++;
                    }
                    return null;
                }
                z = false;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } while (z);
        return inputStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i) {
        if (i == 0) {
            return "CHECK_CAMPAIGN";
        }
        if (i == 1) {
            return "JOIN_CAMPAIGN";
        }
        if (i == 2) {
            return "CHECK_AND_JOIN_CAMPAIGN";
        }
        if (i == 3) {
            return "CHECK_PACKAGE_NAME";
        }
        if (i == 4) {
            return "CHECK_PACKAGE_NAME_AND_JOIN_CAMPAIGN";
        }
        if (i == 5) {
            return "COMPLETE_REWARD_APP_INSTALL";
        }
        if (i == 6) {
            return "GET_CAMPAIGN_LIST";
        }
        if (i == 7) {
            return "GET_CS_CAMPAIGN_LIST";
        }
        if (i == 8) {
            return "SEND_CS";
        }
        if (i == 9) {
            return "GET_REWARD_HISTORY";
        }
        if (i == 11) {
            return "GET_VIDEO_AD_INFO";
        }
        if (i == 12) {
            return "COMPLETE_REWARD_VIDEO";
        }
        if (i == 13) {
            return "AUTO_COMPLETE_REWARD_CPI";
        }
        if (i == 14) {
            return "CHECK_URL";
        }
        if (i == 15) {
            return "GET_PENDING_CLIENT_REWARD";
        }
        if (i == 16) {
            return "COMPLETE_CLIENT_REWARD";
        }
        if (i == 17) {
            return "LOAD_VIDEO_LIST";
        }
        if (i == 18) {
            return "JOIN_REWARD_VIDEO_AD";
        }
        if (i == 19) {
            return "COMPLETE_REWARD_APP_EXECUTE";
        }
        if (i == 20) {
            return "COLLECT_ADPOPCORN_ACTION";
        }
        if (i == 21) {
            return "GET_EARNABLE_REWARD_INFO";
        }
        if (i == 24) {
            return "TRY_PARTICIPATE_CAMPAIGN";
        }
        if (i == 25) {
            return "OPEN_CAMPAIGN_PAGE";
        }
        if (i == 27) {
            return "JOIN_CPM_CAMPAIGN";
        }
        if (i == 28) {
            return "COMPLETE_CPM_CAMPAIGN";
        }
        if (i == 29) {
            return "JOIN_NEWS_CAMPAIGN";
        }
        if (i == 30) {
            return "COMPLETE_NEWS_CAMPAIGN";
        }
        return i == 26 ? "GET_REWARD_CPM" : "HttpRequestThread";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, f fVar) {
        try {
            if (c == null) {
                c = new Handler(Looper.getMainLooper());
            }
            c.post(new RunnableC0398a(i, fVar));
        } catch (Exception unused) {
        }
    }

    private void b(int i, d dVar) {
        if (this.a == null) {
            this.a = new LinkedHashMap<>();
        }
        if (this.a.size() > 15) {
            this.a.remove(Integer.valueOf(this.a.keySet().iterator().next().intValue()));
        }
        if (this.a.get(Integer.valueOf(i)) == null || this.a.get(Integer.valueOf(i)) != dVar) {
            this.a.put(Integer.valueOf(i), dVar);
        }
    }

    public void a(int i, d dVar) {
        b(6, dVar);
        new e(6, i).start();
    }

    public void a(int i, String str, d dVar) {
        b(i, dVar);
        if (i == 17 || i == 26 || i == 21 || i == 22) {
            new e(i, str).start();
        }
    }

    public void a(int i, String str, String str2, d dVar) {
        Thread bVar;
        b(i, dVar);
        if (i == 3) {
            bVar = new b(this.f1491b, 3, str);
        } else if (i != 4) {
            int i2 = 14;
            if (i != 14) {
                return;
            } else {
                bVar = new c(this, i2, str + str2, null);
            }
        } else {
            bVar = new b(this.f1491b, 4, str);
        }
        bVar.start();
    }

    public void a(int i, String str, String str2, JSONArray jSONArray, d dVar) {
        try {
            b(i, dVar);
            new e(i, str, str2, jSONArray).start();
        } catch (Exception unused) {
        }
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1091)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:31)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:21)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public void a(int r1, java.lang.String r2, org.json.JSONObject r3, com.igaworks.adpopcorn.a.g.a.d r4) {
        /*
            r0 = this;
            r0.b(r1, r4)
            if (r1 == 0) goto L30
            r4 = 1
            if (r1 == r4) goto L30
            r4 = 2
            if (r1 == r4) goto L30
            r4 = 5
            if (r1 == r4) goto L30
            r4 = 7
            if (r1 == r4) goto L30
            r4 = 8
            if (r1 == r4) goto L30
            r4 = 9
            if (r1 == r4) goto L30
            r4 = 18
            if (r1 == r4) goto L30
            r4 = 19
            if (r1 == r4) goto L30
            r4 = 24
            if (r1 == r4) goto L30
            r4 = 25
            if (r1 == r4) goto L30
            switch(r1) {
                case 11: goto L30;
                case 12: goto L30;
                case 13: goto L30;
                default: goto L2c;
            }
        L2c:
            switch(r1) {
                case 27: goto L30;
                case 28: goto L30;
                case 29: goto L30;
                case 30: goto L30;
                default: goto L2f;
            }
        L2f:
            goto L38
        L30:
            com.igaworks.adpopcorn.a.g.a$e r4 = new com.igaworks.adpopcorn.a.g.a$e
            r4.<init>(r1, r2, r3)
            r4.start()
        L38:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igaworks.adpopcorn.a.g.a.a(int, java.lang.String, org.json.JSONObject, com.igaworks.adpopcorn.a.g.a$d):void");
    }

    public void a(int i, String str, JSONObject jSONObject, String str2, d dVar) {
        b(i, dVar);
        if (i == 15 || i == 16) {
            new e(i, str, jSONObject, str2).start();
        }
    }
}
