package com.kakao.adfit.n;

import android.os.SystemClock;
import com.kakao.adfit.common.volley.AuthFailureError;
import com.kakao.adfit.common.volley.ClientError;
import com.kakao.adfit.common.volley.NetworkError;
import com.kakao.adfit.common.volley.NoConnectionError;
import com.kakao.adfit.common.volley.ServerError;
import com.kakao.adfit.common.volley.TimeoutError;
import com.kakao.adfit.common.volley.VolleyError;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.List;

/* JADX INFO: compiled from: NetworkUtility.java */
/* JADX INFO: loaded from: classes2.dex */
final class j {

    /* JADX INFO: compiled from: NetworkUtility.java */
    static class b {
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final VolleyError f1864b;

        private b(String str, VolleyError volleyError) {
            this.a = str;
            this.f1864b = volleyError;
        }
    }

    static void a(long j, com.kakao.adfit.common.volley.e<?> eVar, byte[] bArr, int i) {
        if (com.kakao.adfit.common.volley.h.f1727b || j > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = eVar;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(eVar.n().b());
            com.kakao.adfit.common.volley.h.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    static com.kakao.adfit.m.d a(com.kakao.adfit.common.volley.e<?> eVar, long j, List<com.kakao.adfit.m.b> list) {
        com.kakao.adfit.common.volley.a.C0448a c0448aD = eVar.d();
        if (c0448aD == null) {
            return new com.kakao.adfit.m.d(304, (byte[]) null, true, j, list);
        }
        return new com.kakao.adfit.m.d(304, c0448aD.a, true, j, e.a(list, c0448aD));
    }

    static byte[] a(InputStream inputStream, int i, c cVar) throws Throwable {
        byte[] bArrA;
        k kVar = new k(cVar, i);
        try {
            bArrA = cVar.a(1024);
            while (true) {
                try {
                    int i2 = inputStream.read(bArrA);
                    if (i2 == -1) {
                        break;
                    }
                    kVar.write(bArrA, 0, i2);
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                            com.kakao.adfit.common.volley.h.d("Error occurred when closing InputStream", new Object[0]);
                        }
                    }
                    cVar.a(bArrA);
                    kVar.close();
                    throw th;
                }
            }
            byte[] byteArray = kVar.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused2) {
                com.kakao.adfit.common.volley.h.d("Error occurred when closing InputStream", new Object[0]);
            }
            cVar.a(bArrA);
            kVar.close();
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            bArrA = null;
        }
    }

    static void a(com.kakao.adfit.common.volley.e<?> eVar, b bVar) throws VolleyError {
        com.kakao.adfit.m.f fVarN = eVar.n();
        int iO = eVar.o();
        try {
            fVarN.a(bVar.f1864b);
            eVar.a(String.format("%s-retry [timeout=%s]", bVar.a, Integer.valueOf(iO)));
        } catch (VolleyError e) {
            eVar.a(String.format("%s-timeout-giveup [timeout=%s]", bVar.a, Integer.valueOf(iO)));
            throw e;
        }
    }

    static b a(com.kakao.adfit.common.volley.e<?> eVar, IOException iOException, long j, f fVar, byte[] bArr) throws NoConnectionError, ServerError {
        if (iOException instanceof SocketTimeoutException) {
            return new b("socket", new TimeoutError());
        }
        if (iOException instanceof MalformedURLException) {
            throw new RuntimeException("Bad URL " + eVar.q(), iOException);
        }
        if (fVar != null) {
            int iD = fVar.d();
            com.kakao.adfit.common.volley.h.c("Unexpected response code %d for %s", Integer.valueOf(iD), eVar.q());
            if (bArr != null) {
                com.kakao.adfit.m.d dVar = new com.kakao.adfit.m.d(iD, bArr, false, SystemClock.elapsedRealtime() - j, fVar.c());
                if (iD == 401 || iD == 403) {
                    return new b("auth", new AuthFailureError(dVar));
                }
                if (iD >= 400 && iD <= 499) {
                    throw new ClientError(dVar);
                }
                if (iD >= 500 && iD <= 599 && eVar.x()) {
                    return new b("server", new ServerError(dVar));
                }
                throw new ServerError(dVar);
            }
            return new b("network", new NetworkError());
        }
        if (eVar.w()) {
            return new b("connection", new NoConnectionError());
        }
        throw new NoConnectionError(iOException);
    }
}
