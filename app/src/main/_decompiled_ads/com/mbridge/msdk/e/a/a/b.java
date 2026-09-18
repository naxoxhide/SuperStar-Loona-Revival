package com.mbridge.msdk.e.a.a;

import android.os.SystemClock;
import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.e.a.l;
import com.mbridge.msdk.e.a.m;
import com.mbridge.msdk.e.a.r;
import com.mbridge.msdk.e.a.s;
import com.mbridge.msdk.e.a.t;
import com.mbridge.msdk.e.a.u;
import com.mbridge.msdk.e.a.v;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BasicNetwork.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.mbridge.msdk.e.a.h {
    protected final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f2016b;

    public b(a aVar) {
        this(aVar, new c(4096));
    }

    private b(a aVar, c cVar) {
        this.f2016b = aVar;
        this.a = cVar;
    }

    @Override // com.mbridge.msdk.e.a.h
    public final com.mbridge.msdk.e.a.k a(m<?> mVar) throws u {
        f fVarA;
        byte[] bArr;
        byte[] bArr2;
        h.a aVar;
        Map<String, String> mapEmptyMap;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Collections.emptyList();
            try {
                com.mbridge.msdk.e.a.a.C0475a c0475aK = mVar.k();
                if (c0475aK == null) {
                    mapEmptyMap = Collections.emptyMap();
                } else {
                    HashMap map = new HashMap();
                    if (c0475aK.f2015b != null) {
                        map.put(HttpHeaders.IF_NONE_MATCH, c0475aK.f2015b);
                    }
                    if (c0475aK.d > 0) {
                        map.put(HttpHeaders.IF_MODIFIED_SINCE, e.a(c0475aK.d));
                    }
                    mapEmptyMap = map;
                }
                fVarA = this.f2016b.a(mVar, mapEmptyMap);
                try {
                    int iA = fVarA.a();
                    List<com.mbridge.msdk.e.a.g> listB = fVarA.b();
                    if (iA == 304) {
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                        com.mbridge.msdk.e.a.a.C0475a c0475aK2 = mVar.k();
                        if (c0475aK2 == null) {
                            return new com.mbridge.msdk.e.a.k(304, null, true, jElapsedRealtime2, listB);
                        }
                        return new com.mbridge.msdk.e.a.k(304, c0475aK2.a, true, jElapsedRealtime2, e.a(listB, c0475aK2));
                    }
                    InputStream inputStreamD = fVarA.d();
                    byte[] bArrA = inputStreamD != null ? h.a(inputStreamD, fVarA.c(), this.a) : new byte[0];
                    try {
                        long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                        if (jElapsedRealtime3 > 3000) {
                            try {
                                Object[] objArr = new Object[5];
                                objArr[0] = mVar;
                                objArr[1] = Long.valueOf(jElapsedRealtime3);
                                objArr[2] = bArrA != null ? Integer.valueOf(bArrA.length) : "null";
                                objArr[3] = Integer.valueOf(iA);
                                objArr[4] = Integer.valueOf(mVar.a().b());
                                v.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
                            } catch (IOException e) {
                                e = e;
                                bArr = bArrA;
                            }
                        }
                        try {
                            if (iA < 200 || iA > 299) {
                                throw new IOException();
                            }
                            return new com.mbridge.msdk.e.a.k(iA, bArrA, false, SystemClock.elapsedRealtime() - jElapsedRealtime, listB);
                        } catch (IOException e2) {
                            e = e2;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        bArr2 = bArrA;
                    }
                    bArr = bArr2;
                    if (e instanceof SocketTimeoutException) {
                        aVar = new h.a("socket", new t());
                    } else {
                        if (e instanceof MalformedURLException) {
                            throw new RuntimeException("Bad URL " + mVar.h(), e);
                        }
                        if (fVarA != null) {
                            int iA2 = fVarA.a();
                            v.c("Unexpected response code %d for %s", Integer.valueOf(iA2), mVar.h());
                            if (bArr != null) {
                                com.mbridge.msdk.e.a.k kVar = new com.mbridge.msdk.e.a.k(iA2, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, fVarA.b());
                                if (iA2 >= 400 && iA2 <= 499) {
                                    throw new com.mbridge.msdk.e.a.d(kVar);
                                }
                                if (iA2 >= 500 && iA2 <= 599 && mVar.p()) {
                                    aVar = new h.a("server", new s(kVar));
                                } else {
                                    throw new s(kVar);
                                }
                            } else {
                                aVar = new h.a("network", new com.mbridge.msdk.e.a.j());
                            }
                        } else if (mVar.q()) {
                            aVar = new h.a("connection", new l());
                        } else {
                            throw new l(e);
                        }
                    }
                    h.a aVar2 = aVar;
                    r rVarA = mVar.a();
                    int iR = mVar.r();
                    try {
                        rVarA.a(aVar2.f2020b);
                        String.format("%s-retry [timeout=%s]", aVar2.a, Integer.valueOf(iR));
                    } catch (u e4) {
                        String.format("%s-timeout-giveup [timeout=%s]", aVar2.a, Integer.valueOf(iR));
                        throw e4;
                    }
                } catch (IOException e5) {
                    e = e5;
                    bArr = null;
                }
            } catch (IOException e6) {
                e = e6;
                fVarA = null;
                bArr = null;
            }
        }
    }
}
