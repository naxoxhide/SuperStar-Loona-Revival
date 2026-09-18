package com.applovin.exoplayer2.d;

import android.net.Uri;
import android.text.TextUtils;
import com.applovin.exoplayer2.k.z;
import com.applovin.exoplayer2.l.ai;
import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class p implements r {
    private final com.applovin.exoplayer2.k.t.b ts;
    private final String tt;
    private final boolean tu;
    private final Map<String, String> tv;

    public p(String str, boolean z, com.applovin.exoplayer2.k.t.b bVar) {
        com.applovin.exoplayer2.l.a.checkArgument((z && TextUtils.isEmpty(str)) ? false : true);
        this.ts = bVar;
        this.tt = str;
        this.tu = z;
        this.tv = new HashMap();
    }

    public void c(String str, String str2) {
        com.applovin.exoplayer2.l.a.checkNotNull(str);
        com.applovin.exoplayer2.l.a.checkNotNull(str2);
        synchronized (this.tv) {
            this.tv.put(str, str2);
        }
    }

    @Override // com.applovin.exoplayer2.d.r
    public byte[] a(UUID uuid, m.d dVar) throws s {
        return a(this.ts, dVar.hQ() + "&signedRequest=" + ai.J(dVar.hO()), null, Collections.emptyMap());
    }

    @Override // com.applovin.exoplayer2.d.r
    public byte[] a(UUID uuid, m.a aVar) throws s {
        String str;
        String strHP = aVar.hP();
        if (this.tu || TextUtils.isEmpty(strHP)) {
            strHP = this.tt;
        }
        if (TextUtils.isEmpty(strHP)) {
            throw new s(new com.applovin.exoplayer2.k.l.a().e(Uri.EMPTY).oj(), Uri.EMPTY, com.applovin.exoplayer2.common.a.u.gi(), 0L, new IllegalStateException("No license URL"));
        }
        HashMap map = new HashMap();
        if (com.applovin.exoplayer2.h.an.equals(uuid)) {
            str = "text/xml";
        } else {
            str = com.applovin.exoplayer2.h.al.equals(uuid) ? "application/json" : "application/octet-stream";
        }
        map.put(HttpHeaders.CONTENT_TYPE, str);
        if (com.applovin.exoplayer2.h.an.equals(uuid)) {
            map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.tv) {
            map.putAll(this.tv);
        }
        return a(this.ts, strHP, aVar.hO(), map);
    }

    private static byte[] a(com.applovin.exoplayer2.k.t.b bVar, String str, byte[] bArr, Map<String, String> map) throws s {
        z zVar = new z(bVar.of());
        com.applovin.exoplayer2.k.l lVarOj = new com.applovin.exoplayer2.k.l.a().aK(str).d(map).fh(2).G(bArr).fi(1).oj();
        int i = 0;
        com.applovin.exoplayer2.k.l lVarOj2 = lVarOj;
        while (true) {
            try {
                com.applovin.exoplayer2.k.k kVar = new com.applovin.exoplayer2.k.k(zVar, lVarOj2);
                try {
                    try {
                        byte[] bArrA = ai.a((InputStream) kVar);
                        ai.a((Closeable) kVar);
                        return bArrA;
                    } catch (com.applovin.exoplayer2.k.t.e e) {
                        String strA = a(e, i);
                        if (strA == null) {
                            throw e;
                        }
                        i++;
                        lVarOj2 = lVarOj2.oi().aK(strA).oj();
                        ai.a((Closeable) kVar);
                    }
                } catch (Throwable th) {
                    ai.a((Closeable) kVar);
                    throw th;
                }
            } catch (Exception e2) {
                throw new s(lVarOj, (Uri) com.applovin.exoplayer2.l.a.checkNotNull(zVar.oI()), zVar.kT(), zVar.oH(), e2);
            }
        }
    }

    private static String a(com.applovin.exoplayer2.k.t.e eVar, int i) {
        Map<String, List<String>> map;
        List<String> list;
        if (!((eVar.aaC == 307 || eVar.aaC == 308) && i < 5) || (map = eVar.aaM) == null || (list = map.get(HttpHeaders.LOCATION)) == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
