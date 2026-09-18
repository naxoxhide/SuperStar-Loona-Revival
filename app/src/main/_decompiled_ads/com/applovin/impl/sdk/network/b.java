package com.applovin.impl.sdk.network;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import androidx.webkit.ProxyConfig;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.p;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.utils.z;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinErrorCodes;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final List<String> aHj = Arrays.asList("5.0/i", "4.0/ad", "1.0/mediate");
    private final e aHk;
    private c aHl;
    private final x logger;
    private final n sdk;

    public interface d<T> {
        void a(int i, String str, T t);

        void d(T t, int i);
    }

    public b(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BL();
        e eVar = new e(nVar);
        this.aHk = eVar;
        eVar.start();
    }

    /* JADX WARN: Code duplicated, block: B:80:0x025e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x0260 A[Catch: all -> 0x02b6, TryCatch #1 {all -> 0x02b6, blocks: (B:44:0x012b, B:46:0x013b, B:50:0x016c, B:49:0x0168, B:51:0x017d, B:54:0x01a2, B:56:0x01be, B:60:0x01dd, B:76:0x0244, B:79:0x0253, B:81:0x0260, B:62:0x01e1, B:65:0x01e9, B:71:0x0201, B:73:0x0207, B:74:0x0223, B:57:0x01cc, B:82:0x0263, B:84:0x0269, B:85:0x027d, B:67:0x01fa), top: B:105:0x012b, inners: #2 }] */
    public <T> void a(com.applovin.impl.sdk.network.c<T> cVar, a aVar, d<T> dVar) {
        byte[] bytes;
        byte[] bArrR;
        if (cVar == null) {
            throw new IllegalArgumentException("No request specified");
        }
        String strZJ = cVar.zJ();
        String strHO = cVar.HO();
        if (strZJ == null) {
            throw new IllegalArgumentException("No endpoint specified");
        }
        if (strHO == null) {
            throw new IllegalArgumentException("No method specified");
        }
        if (dVar == null) {
            throw new IllegalArgumentException("No callback specified");
        }
        if (!strZJ.toLowerCase().startsWith(ProxyConfig.MATCH_HTTP)) {
            String str = "Requested postback submission to non HTTP endpoint " + strZJ + "; skipping...";
            x.H("ConnectionManager", str);
            dVar.a(AppLovinErrorCodes.INVALID_URL, str, null);
            return;
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aNI)).booleanValue() && !strZJ.contains("https://")) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().h("ConnectionManager", "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting...");
            }
            strZJ = strZJ.replace("http://", "https://");
        }
        HashMap map = new HashMap(2);
        boolean zIa = cVar.Ia();
        p.a aVarGU = ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPK)).booleanValue() ? p.a.gU(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPH)).intValue()) : cVar.Ib();
        long jN = u.N(this.sdk);
        if ((cVar.HP() != null && !cVar.HP().isEmpty()) || cVar.HU() > 0) {
            Map<String, String> mapHP = cVar.HP();
            Boolean bool = (Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aNW);
            if (mapHP != null && cVar.HU() > 0) {
                mapHP.put("current_retry_attempt", String.valueOf(cVar.HU()));
            }
            if (zIa) {
                String strB = u.b(mapHP, bool.booleanValue());
                String strA = p.a(strB, jN, aVarGU, this.sdk.getSdkKey(), this.sdk);
                if (StringUtils.isValidString(strB) && TextUtils.isEmpty(strA)) {
                    map.put("query", strB);
                }
                strZJ = StringUtils.appendQueryParameter(strZJ, "p", strA);
            } else {
                strZJ = StringUtils.appendQueryParameters(strZJ, mapHP, bool.booleanValue());
            }
        }
        String str2 = strZJ;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            Boolean boolEndsWith = StringUtils.endsWith(StringUtils.getHostAndPath(str2), aHj);
            if (x.Fk()) {
                this.logger.g("ConnectionManager", "Sending " + strHO + " request to id=#" + str2.hashCode() + " \"" + (boolEndsWith.booleanValue() ? str2 : StringUtils.getHostAndPath(str2)) + "\"...");
            }
            e.b.a aVarGF = new e.b.a().dd(str2).de(strHO).m(cVar.HQ()).gF(cVar.HV());
            if (cVar.vR() != null) {
                if (zIa) {
                    bytes = p.b(cVar.vR().toString(), jN, aVarGU, this.sdk.getSdkKey(), this.sdk);
                    if (bytes == null) {
                        map.put("body", cVar.vR().toString());
                    }
                } else {
                    bytes = cVar.vR().toString().getBytes("UTF-8");
                }
                byte[] bArr = bytes;
                if ((!zIa || aVarGU != p.a.V2) && cVar.Id() && bArr != null && bArr.length > ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aQd)).intValue()) {
                    try {
                        bArrR = u.R(bArr);
                    } catch (Throwable th) {
                        if (x.Fk()) {
                            this.logger.c("ConnectionManager", "Failed to gzip POST body for request " + cX(str2), th);
                        }
                        this.sdk.Cq().d("ConnectionManager", "gzip:" + StringUtils.getHost(str2), th);
                        bArrR = null;
                    }
                    aVarGF.I(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
                    if (!cVar.Id() && bArrR != null) {
                        aVarGF.I(HttpHeaders.CONTENT_ENCODING, "gzip");
                        aVarGF.K(bArrR);
                    } else if (bArr != null) {
                        aVarGF.K(bArr);
                    }
                } else {
                    bArrR = null;
                    aVarGF.I(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
                    if (!cVar.Id()) {
                        if (bArr != null) {
                            aVarGF.K(bArr);
                        }
                    } else if (bArr != null) {
                        aVarGF.K(bArr);
                    }
                }
                a(strHO, str2, 0, SystemClock.elapsedRealtime() - jElapsedRealtime, th);
                dVar.a(0, th.getMessage(), null);
                return;
            }
            if (!map.isEmpty()) {
                map.put("request", StringUtils.getHostAndPath(str2));
                this.sdk.BD().trackEvent("ref", map);
            }
            try {
                this.aHk.a(aVarGF.a(new C0138b(str2, cVar, strHO, cVar.HS(), zIa, aVar, dVar)).a(this.sdk.BM().KG()).Ig());
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public c HI() {
        return this.aHl;
    }

    /* JADX INFO: renamed from: com.applovin.impl.sdk.network.b$b, reason: collision with other inner class name */
    private class C0138b<T> implements Consumer<e.c> {
        private final com.applovin.impl.sdk.network.c<T> aHh;
        private final String aHn;
        private final String aHo;
        private final T aHp;
        private final boolean aHq;
        private final a aHr;
        private final d<T> aHs;

        private C0138b(String str, com.applovin.impl.sdk.network.c<T> cVar, String str2, T t, boolean z, a aVar, d<T> dVar) {
            this.aHn = str;
            this.aHh = cVar;
            this.aHo = str2;
            this.aHp = t;
            this.aHq = z;
            this.aHr = aVar;
            this.aHs = dVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // androidx.core.util.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e.c cVar) {
            int i;
            long jIl = cVar.Il();
            Object objC = null;
            int iN = 0;
            try {
                int iIh = cVar.Ih();
                try {
                    if (iIh <= 0) {
                        b.this.a(this.aHo, this.aHn, iIh, jIl, (Throwable) null);
                        this.aHs.a(iIh, null, null);
                        return;
                    }
                    if (iIh >= 200 && iIh < 400) {
                        a aVar = this.aHr;
                        if (aVar != null) {
                            aVar.bP(jIl);
                        }
                        b.this.a(this.aHo, this.aHn, iIh, jIl);
                        byte[] bArrIj = cVar.Ij();
                        if (u.ai(n.getApplicationContext()) && (!this.aHq || p.N(bArrIj) != p.a.V2)) {
                            b.this.sdk.Cf().b(bArrIj != null ? new String(cVar.Ij(), Charset.forName("UTF-8")) : "", this.aHn, this.aHh.vR() != null ? this.aHh.vR().toString() : "");
                        }
                        if (bArrIj != null) {
                            String str = new String(cVar.Ij(), Charset.forName("UTF-8"));
                            a aVar2 = this.aHr;
                            if (aVar2 != null) {
                                aVar2.bQ(bArrIj.length);
                                if (this.aHh.Ic()) {
                                    b.this.aHl = new c(this.aHh.zJ(), bArrIj.length, jIl);
                                }
                            }
                            if (this.aHq) {
                                String strA = p.a(bArrIj, b.this.sdk.getSdkKey(), b.this.sdk);
                                if (strA == null) {
                                    HashMap map = new HashMap(2);
                                    map.put("request", StringUtils.getHostAndPath(this.aHn));
                                    map.put("response", str);
                                    b.this.sdk.BD().trackEvent("rdf", map);
                                }
                                str = strA;
                            }
                            try {
                                this.aHs.d(b.this.c(str, this.aHp), iIh);
                                return;
                            } catch (Throwable th) {
                                String str2 = "Unable to parse response from " + StringUtils.getHostAndPath(this.aHn) + " because of " + th.getClass().getName() + " : " + th.getMessage();
                                x unused = b.this.logger;
                                if (x.Fk()) {
                                    b.this.logger.c("ConnectionManager", str2, th);
                                }
                                b.this.sdk.BP().a(com.applovin.impl.sdk.d.f.aSX);
                                b.this.sdk.Cq().d("ConnectionManager", "failedToParseResponse:" + StringUtils.getHost(this.aHn), th);
                                this.aHs.a(AppLovinErrorCodes.INVALID_RESPONSE, str2, null);
                                return;
                            }
                        }
                        this.aHs.d(this.aHp, iIh);
                        return;
                    }
                    this.aHs.a(iIh, null, null);
                } catch (MalformedURLException e) {
                    e = e;
                    i = iIh;
                    if (this.aHp != null) {
                        b.this.a(this.aHo, this.aHn, i, jIl, e);
                        this.aHs.a(-901, e.getMessage(), null);
                    } else {
                        b.this.a(this.aHo, this.aHn, i, jIl);
                        this.aHs.d(this.aHp, -901);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    iN = iIh;
                    if (((Boolean) b.this.sdk.a(com.applovin.impl.sdk.c.b.aKr)).booleanValue()) {
                        iN = cVar.Ii();
                    }
                    if (iN == 0) {
                        iN = b.this.n(th);
                    }
                    int i2 = iN;
                    try {
                        byte[] bArrIk = cVar.Ik();
                        String str3 = new String(bArrIk);
                        if (bArrIk != null) {
                            if (this.aHq) {
                                str3 = p.a(bArrIk, b.this.sdk.getSdkKey(), b.this.sdk);
                            }
                            objC = b.this.c(str3, this.aHp);
                        }
                    } catch (Throwable unused2) {
                    }
                    b.this.a(this.aHo, this.aHn, i2, jIl, th);
                    this.aHs.a(i2, th.getMessage(), objC);
                }
            } catch (MalformedURLException e2) {
                e = e2;
                i = 0;
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T c(String str, T t) throws JSONException, SAXException, ClassCastException {
        if (t == null) {
            return str;
        }
        if (str != 0 && str.length() >= 3) {
            if (t instanceof JSONObject) {
                return (T) new JSONObject(str);
            }
            if (t instanceof y) {
                return (T) z.e(str, this.sdk);
            }
            if (t instanceof String) {
                return str;
            }
            if (x.Fk()) {
                this.logger.i("ConnectionManager", "Failed to process response of type '" + t.getClass().getName() + "'");
            }
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n(Throwable th) {
        if (th instanceof UnknownHostException) {
            return -1009;
        }
        if (th instanceof SocketTimeoutException) {
            return -1001;
        }
        if (th instanceof IOException) {
            return -100;
        }
        return th instanceof JSONException ? -104 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i, long j) {
        if (x.Fk()) {
            this.logger.g("ConnectionManager", "Successful " + str + " returned " + i + " in " + (j / 1000.0f) + " s over " + com.applovin.impl.sdk.utils.i.G(this.sdk) + " to " + cX(str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i, long j, Throwable th) {
        if (x.Fk()) {
            this.logger.c("ConnectionManager", "Failed " + str + " returned " + i + " in " + (j / 1000.0f) + " s over " + com.applovin.impl.sdk.utils.i.G(this.sdk) + " to " + cX(str2), th);
        }
    }

    private String cX(String str) {
        return "#" + str.hashCode() + " \"" + StringUtils.getHostAndPath(str) + "\"";
    }

    public static class a {
        private long aHm;
        private long akZ;

        public long getLatencyMillis() {
            return this.akZ;
        }

        public long HJ() {
            return this.aHm;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bP(long j) {
            this.akZ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bQ(long j) {
            this.aHm = j;
        }
    }

    public static class c {
        private final long aHu = System.currentTimeMillis();
        private final String aHv;
        private final long aHw;
        private final long aHx;

        public c(String str, long j, long j2) {
            this.aHv = str;
            this.aHw = j;
            this.aHx = j2;
        }

        protected boolean canEqual(Object obj) {
            return obj instanceof c;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!cVar.canEqual(this) || HK() != cVar.HK() || HM() != cVar.HM() || HN() != cVar.HN()) {
                return false;
            }
            String strHL = HL();
            String strHL2 = cVar.HL();
            return strHL != null ? strHL.equals(strHL2) : strHL2 == null;
        }

        public int hashCode() {
            long jHK = HK();
            long jHM = HM();
            int i = ((((int) (jHK ^ (jHK >>> 32))) + 59) * 59) + ((int) (jHM ^ (jHM >>> 32)));
            long jHN = HN();
            String strHL = HL();
            return (((i * 59) + ((int) ((jHN >>> 32) ^ jHN))) * 59) + (strHL == null ? 43 : strHL.hashCode());
        }

        public String toString() {
            return "ConnectionManager.RequestMeasurement(timestampMillis=" + HK() + ", urlHostAndPathString=" + HL() + ", responseSizeBytes=" + HM() + ", connectionTimeMillis=" + HN() + ")";
        }

        public long HK() {
            return this.aHu;
        }

        public String HL() {
            return this.aHv;
        }

        public long HM() {
            return this.aHw;
        }

        public long HN() {
            return this.aHx;
        }
    }
}
