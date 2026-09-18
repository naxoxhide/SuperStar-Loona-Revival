package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.p;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c<T> {
    private final JSONObject aHA;
    private String aHB;
    private final int aHC;
    private int aHD;
    private final int aHE;
    private final int aHF;
    private final boolean aHG;
    private final boolean aHH;
    private final boolean aHI;
    private final boolean aHJ;
    private final p.a aHK;
    private final boolean aHL;
    private final boolean aHM;
    private String aHn;
    private final T aHp;
    private String aHy;
    private Map<String, String> aHz;
    private Map<String, String> awu;

    protected c(a<T> aVar) {
        this.aHn = aVar.aHn;
        this.aHy = aVar.aHy;
        this.aHz = aVar.aHz;
        this.awu = aVar.awu;
        this.aHA = aVar.aHA;
        this.aHB = aVar.aHB;
        this.aHp = aVar.aHp;
        this.aHC = aVar.aHD;
        this.aHD = aVar.aHD;
        this.aHE = aVar.aHE;
        this.aHF = aVar.aHF;
        this.aHG = aVar.aHG;
        this.aHH = aVar.aHH;
        this.aHI = aVar.aHI;
        this.aHJ = aVar.aHJ;
        this.aHK = aVar.aHK;
        this.aHL = aVar.aHL;
        this.aHM = aVar.aHM;
    }

    public String zJ() {
        return this.aHn;
    }

    public void cY(String str) {
        this.aHn = str;
    }

    public String HO() {
        return this.aHy;
    }

    public void cZ(String str) {
        this.aHy = str;
    }

    public Map<String, String> HP() {
        return this.aHz;
    }

    public Map<String, String> HQ() {
        return this.awu;
    }

    public JSONObject vR() {
        return this.aHA;
    }

    public String HR() {
        return this.aHB;
    }

    public T HS() {
        return this.aHp;
    }

    public int HT() {
        return this.aHD;
    }

    public int HU() {
        return this.aHC - this.aHD;
    }

    public void gB(int i) {
        this.aHD = i;
    }

    public int HV() {
        return this.aHE;
    }

    public int HW() {
        return this.aHF;
    }

    public boolean HX() {
        return this.aHG;
    }

    public boolean HY() {
        return this.aHH;
    }

    public boolean HZ() {
        return this.aHI;
    }

    public boolean Ia() {
        return this.aHJ;
    }

    public p.a Ib() {
        return this.aHK;
    }

    public boolean Ic() {
        return this.aHL;
    }

    public boolean Id() {
        return this.aHM;
    }

    public String toString() {
        return "HttpRequest {endpoint=" + this.aHn + ", backupEndpoint=" + this.aHB + ", httpMethod=" + this.aHy + ", httpHeaders=" + this.awu + ", body=" + this.aHA + ", emptyResponse=" + this.aHp + ", initialRetryAttempts=" + this.aHC + ", retryAttemptsLeft=" + this.aHD + ", timeoutMillis=" + this.aHE + ", retryDelayMillis=" + this.aHF + ", exponentialRetries=" + this.aHG + ", retryOnAllErrors=" + this.aHH + ", retryOnNoConnection=" + this.aHI + ", encodingEnabled=" + this.aHJ + ", encodingType=" + this.aHK + ", trackConnectionSpeed=" + this.aHL + ", gzipBodyEncoding=" + this.aHM + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        String str = this.aHn;
        if (str == null ? cVar.aHn != null : !str.equals(cVar.aHn)) {
            return false;
        }
        Map<String, String> map = this.aHz;
        if (map == null ? cVar.aHz != null : !map.equals(cVar.aHz)) {
            return false;
        }
        Map<String, String> map2 = this.awu;
        if (map2 == null ? cVar.awu != null : !map2.equals(cVar.awu)) {
            return false;
        }
        String str2 = this.aHB;
        if (str2 == null ? cVar.aHB != null : !str2.equals(cVar.aHB)) {
            return false;
        }
        String str3 = this.aHy;
        if (str3 == null ? cVar.aHy != null : !str3.equals(cVar.aHy)) {
            return false;
        }
        JSONObject jSONObject = this.aHA;
        if (jSONObject == null ? cVar.aHA != null : !jSONObject.equals(cVar.aHA)) {
            return false;
        }
        T t = this.aHp;
        if (t == null ? cVar.aHp == null : t.equals(cVar.aHp)) {
            return this.aHC == cVar.aHC && this.aHD == cVar.aHD && this.aHE == cVar.aHE && this.aHF == cVar.aHF && this.aHG == cVar.aHG && this.aHH == cVar.aHH && this.aHI == cVar.aHI && this.aHJ == cVar.aHJ && this.aHK == cVar.aHK && this.aHL == cVar.aHL && this.aHM == cVar.aHM;
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.aHn;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.aHB;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.aHy;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        T t = this.aHp;
        int iHashCode5 = ((((((((((((((((((((((iHashCode4 + (t != null ? t.hashCode() : 0)) * 31) + this.aHC) * 31) + this.aHD) * 31) + this.aHE) * 31) + this.aHF) * 31) + (this.aHG ? 1 : 0)) * 31) + (this.aHH ? 1 : 0)) * 31) + (this.aHI ? 1 : 0)) * 31) + (this.aHJ ? 1 : 0)) * 31) + this.aHK.getValue()) * 31) + (this.aHL ? 1 : 0)) * 31) + (this.aHM ? 1 : 0);
        Map<String, String> map = this.aHz;
        if (map != null) {
            iHashCode5 = (iHashCode5 * 31) + map.hashCode();
        }
        Map<String, String> map2 = this.awu;
        if (map2 != null) {
            iHashCode5 = (iHashCode5 * 31) + map2.hashCode();
        }
        JSONObject jSONObject = this.aHA;
        if (jSONObject == null) {
            return iHashCode5;
        }
        char[] charArray = jSONObject.toString().toCharArray();
        Arrays.sort(charArray);
        return (iHashCode5 * 31) + new String(charArray).hashCode();
    }

    public static <T> a<T> D(n nVar) {
        return new a<>(nVar);
    }

    public static class a<T> {
        JSONObject aHA;
        String aHB;
        int aHE;
        int aHF;
        boolean aHG;
        boolean aHH;
        boolean aHI;
        boolean aHJ;
        p.a aHK;
        boolean aHL;
        boolean aHM;
        String aHn;
        T aHp;
        String aHy;
        Map<String, String> awu;
        int aHD = 1;
        Map<String, String> aHz = new HashMap();

        public a(n nVar) {
            this.aHE = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aNG)).intValue();
            this.aHF = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aNF)).intValue();
            this.aHH = ((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aNE)).booleanValue();
            this.aHI = ((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aOd)).booleanValue();
            this.aHJ = ((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aPG)).booleanValue();
            this.aHK = p.a.gU(((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPH)).intValue());
            this.aHM = ((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aQe)).booleanValue();
        }

        public a<T> da(String str) {
            this.aHn = str;
            return this;
        }

        public a<T> db(String str) {
            this.aHy = str;
            return this;
        }

        public a<T> k(Map<String, String> map) {
            this.aHz = map;
            return this;
        }

        public a<T> l(Map<String, String> map) {
            this.awu = map;
            return this;
        }

        public a<T> K(JSONObject jSONObject) {
            this.aHA = jSONObject;
            return this;
        }

        public a<T> dc(String str) {
            this.aHB = str;
            return this;
        }

        public a<T> ad(T t) {
            this.aHp = t;
            return this;
        }

        public a<T> gC(int i) {
            this.aHD = i;
            return this;
        }

        public a<T> gD(int i) {
            this.aHE = i;
            return this;
        }

        public a<T> gE(int i) {
            this.aHF = i;
            return this;
        }

        public a<T> aP(boolean z) {
            this.aHG = z;
            return this;
        }

        public a<T> aQ(boolean z) {
            this.aHH = z;
            return this;
        }

        public a<T> aR(boolean z) {
            this.aHI = z;
            return this;
        }

        public a<T> aS(boolean z) {
            this.aHJ = z;
            return this;
        }

        public a<T> a(p.a aVar) {
            this.aHK = aVar;
            return this;
        }

        public a<T> aT(boolean z) {
            this.aHL = z;
            return this;
        }

        public a<T> aU(boolean z) {
            this.aHM = z;
            return this;
        }

        public c<T> Ie() {
            return new c<>(this);
        }
    }
}
