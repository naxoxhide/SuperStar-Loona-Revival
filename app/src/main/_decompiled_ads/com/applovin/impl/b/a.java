package com.applovin.impl.b;

import android.net.Uri;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.applovin.impl.sdk.ad.e {
    private final String aFY;
    private final String aWD;
    private final j aWE;
    private final n aWF;
    private final d aWG;
    private final com.applovin.impl.b.c aWH;
    private final com.applovin.impl.sdk.a.g aWI;
    private final Set<k> aWJ;
    private final Set<k> aWK;
    private final long createdAtMillis;
    private final String title;

    public enum b {
        COMPANION_AD,
        VIDEO
    }

    public enum c {
        IMPRESSION,
        VIDEO_CLICK,
        COMPANION_CLICK,
        VIDEO,
        COMPANION,
        INDUSTRY_ICON_IMPRESSION,
        INDUSTRY_ICON_CLICK,
        ERROR
    }

    @Override // com.applovin.impl.sdk.ad.e
    public void Fy() {
    }

    private a(C0114a c0114a) {
        super(c0114a.adObject, c0114a.fullResponse, c0114a.source, c0114a.sdk);
        this.title = c0114a.title;
        this.aWE = c0114a.aWE;
        this.aWD = c0114a.aWD;
        this.aWF = c0114a.aWF;
        this.aWG = c0114a.aWG;
        this.aWH = c0114a.aWH;
        this.aWJ = c0114a.aWJ;
        this.aWK = c0114a.aWK;
        this.aWI = new com.applovin.impl.sdk.a.g(this);
        Uri uriFG = FG();
        if (uriFG != null) {
            this.aFY = uriFG.toString();
        } else {
            this.aFY = "";
        }
        this.createdAtMillis = c0114a.createdAtMillis;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public JSONObject getOriginalFullResponse() {
        return this.fullResponse;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean hasVideoUrl() {
        List<o> listME;
        n nVar = this.aWF;
        return (nVar == null || (listME = nVar.ME()) == null || listME.size() <= 0) ? false : true;
    }

    @Override // com.applovin.impl.sdk.ad.e
    public boolean FD() {
        return getBooleanFromAdObject("vast_is_streaming", false);
    }

    public void FF() {
        synchronized (this.adObjectLock) {
            this.adObject.remove("vast_is_streaming");
        }
    }

    @Override // com.applovin.impl.sdk.ad.e
    public String FB() {
        return this.aFY;
    }

    @Override // com.applovin.impl.sdk.ad.e, com.applovin.impl.sdk.a.a
    public boolean isOpenMeasurementEnabled() {
        return getBooleanFromAdObject("omsdk_enabled", true) && this.aWH != null;
    }

    public boolean LK() {
        return getBooleanFromAdObject("iopms", false);
    }

    public boolean LL() {
        return getBooleanFromAdObject("iopmsfsr", true);
    }

    @Override // com.applovin.impl.sdk.ad.e
    /* JADX INFO: renamed from: LM, reason: merged with bridge method [inline-methods] */
    public com.applovin.impl.sdk.a.g getAdEventTracker() {
        return this.aWI;
    }

    public long LN() {
        return getLongFromAdObject("real_close_delay", 0L);
    }

    public b LO() {
        if ("companion_ad".equalsIgnoreCase(getStringFromAdObject("vast_first_caching_operation", "companion_ad"))) {
            return b.COMPANION_AD;
        }
        return b.VIDEO;
    }

    public boolean LP() {
        return getBooleanFromAdObject("vast_immediate_ad_load", true);
    }

    @Override // com.applovin.impl.sdk.ad.e
    public Uri FG() {
        o oVarLT = LT();
        if (oVarLT != null) {
            return oVarLT.FG();
        }
        return null;
    }

    @Override // com.applovin.impl.sdk.ad.e
    public Uri FI() {
        n nVar = this.aWF;
        if (nVar != null) {
            return nVar.Ml();
        }
        return null;
    }

    @Override // com.applovin.impl.sdk.ad.e
    public Uri FJ() {
        return FI();
    }

    @Override // com.applovin.impl.sdk.ad.e
    public boolean Go() {
        return getBooleanFromAdObject("video_clickable", false) && FI() != null;
    }

    @Override // com.applovin.impl.sdk.ad.e
    public List<com.applovin.impl.sdk.d.a> Hh() {
        List<com.applovin.impl.sdk.d.a> listA;
        synchronized (this.adObjectLock) {
            listA = u.a("vimp_urls", this.adObject, getClCode(), null, LQ(), Hj(), Gj(), this.sdk);
        }
        return listA;
    }

    private String LQ() {
        String stringFromAdObject = getStringFromAdObject("vimp_url", null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace("{CLCODE}", getClCode());
        }
        return null;
    }

    public j LR() {
        return this.aWE;
    }

    public n LS() {
        return this.aWF;
    }

    public o LT() {
        Long lK = com.applovin.impl.sdk.utils.i.K(this.sdk);
        return this.aWF.a(LU(), lK != null ? lK.longValue() : 0L);
    }

    private n.a LU() {
        n.a[] aVarArrValues = n.a.values();
        int iIntValue = ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPr)).intValue();
        if (iIntValue >= 0 && iIntValue < aVarArrValues.length) {
            return aVarArrValues[iIntValue];
        }
        return n.a.UNSPECIFIED;
    }

    public d LV() {
        return this.aWG;
    }

    public g LW() {
        n nVar = this.aWF;
        if (nVar != null) {
            return nVar.LW();
        }
        return null;
    }

    public boolean LX() {
        return LW() != null;
    }

    public boolean LY() {
        return getBooleanFromAdObject("vast_fire_click_trackers_on_html_clicks", false);
    }

    public void dS(String str) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html_template", str);
        }
    }

    public String LZ() {
        return getStringFromAdObject("html_template", "");
    }

    public Uri Ma() {
        String stringFromAdObject = getStringFromAdObject("html_template_url", null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public boolean Mb() {
        return getBooleanFromAdObject("cache_companion_ad", true);
    }

    public boolean Mc() {
        return getBooleanFromAdObject("cache_video", true);
    }

    public com.applovin.impl.b.c Md() {
        return this.aWH;
    }

    public Set<k> a(c cVar, String str) {
        return a(cVar, new String[]{str});
    }

    public Set<k> a(c cVar, String[] strArr) {
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f("VastAd", "Retrieving trackers of type '" + cVar + "' and events '" + strArr + "'...");
        }
        if (cVar == c.IMPRESSION) {
            return this.aWJ;
        }
        if (cVar == c.VIDEO_CLICK) {
            return Me();
        }
        if (cVar == c.COMPANION_CLICK) {
            return Mf();
        }
        if (cVar == c.VIDEO) {
            return a(b.VIDEO, strArr);
        }
        if (cVar == c.COMPANION) {
            return a(b.COMPANION_AD, strArr);
        }
        if (cVar == c.INDUSTRY_ICON_CLICK) {
            return LW().Mn();
        }
        if (cVar == c.INDUSTRY_ICON_IMPRESSION) {
            return LW().Mv();
        }
        if (cVar == c.ERROR) {
            return this.aWK;
        }
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().i("VastAd", "Failed to retrieve trackers of invalid type '" + cVar + "' and events '" + strArr + "'");
        }
        return Collections.emptySet();
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    private Set<k> Me() {
        n nVar = this.aWF;
        if (nVar != null) {
            return nVar.Mn();
        }
        return Collections.emptySet();
    }

    private Set<k> Mf() {
        d dVar = this.aWG;
        if (dVar != null) {
            return dVar.Mn();
        }
        return Collections.emptySet();
    }

    private Set<k> a(b bVar, String[] strArr) {
        d dVar;
        n nVar;
        if (strArr != null && strArr.length > 0) {
            Map<String, Set<k>> mapMo = null;
            if (bVar == b.VIDEO && (nVar = this.aWF) != null) {
                mapMo = nVar.Mo();
            } else if (bVar == b.COMPANION_AD && (dVar = this.aWG) != null) {
                mapMo = dVar.Mo();
            }
            HashSet hashSet = new HashSet();
            if (mapMo != null && !mapMo.isEmpty()) {
                for (String str : strArr) {
                    if (mapMo.containsKey(str)) {
                        hashSet.addAll(mapMo.get(str));
                    }
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public String toString() {
        return "VastAd{title='" + this.title + "', adDescription='" + this.aWD + "', systemInfo=" + this.aWE + ", videoCreative=" + this.aWF + ", companionAd=" + this.aWG + ", adVerifications=" + this.aWH + ", impressionTrackers=" + this.aWJ + ", errorTrackers=" + this.aWK + '}';
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a) || !super.equals(obj)) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.title;
        if (str == null ? aVar.title != null : !str.equals(aVar.title)) {
            return false;
        }
        String str2 = this.aWD;
        if (str2 == null ? aVar.aWD != null : !str2.equals(aVar.aWD)) {
            return false;
        }
        j jVar = this.aWE;
        if (jVar == null ? aVar.aWE != null : !jVar.equals(aVar.aWE)) {
            return false;
        }
        n nVar = this.aWF;
        if (nVar == null ? aVar.aWF != null : !nVar.equals(aVar.aWF)) {
            return false;
        }
        d dVar = this.aWG;
        if (dVar == null ? aVar.aWG != null : !dVar.equals(aVar.aWG)) {
            return false;
        }
        com.applovin.impl.b.c cVar = this.aWH;
        if (cVar == null ? aVar.aWH != null : !cVar.equals(aVar.aWH)) {
            return false;
        }
        Set<k> set = this.aWJ;
        if (set == null ? aVar.aWJ != null : !set.equals(aVar.aWJ)) {
            return false;
        }
        Set<k> set2 = this.aWK;
        Set<k> set3 = aVar.aWK;
        if (set2 != null) {
            return set2.equals(set3);
        }
        return set3 == null;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.aWD;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        j jVar = this.aWE;
        int iHashCode4 = (iHashCode3 + (jVar != null ? jVar.hashCode() : 0)) * 31;
        n nVar = this.aWF;
        int iHashCode5 = (iHashCode4 + (nVar != null ? nVar.hashCode() : 0)) * 31;
        d dVar = this.aWG;
        int iHashCode6 = (iHashCode5 + (dVar != null ? dVar.hashCode() : 0)) * 31;
        com.applovin.impl.b.c cVar = this.aWH;
        int iHashCode7 = (iHashCode6 + (cVar != null ? cVar.hashCode() : 0)) * 31;
        Set<k> set = this.aWJ;
        int iHashCode8 = (iHashCode7 + (set != null ? set.hashCode() : 0)) * 31;
        Set<k> set2 = this.aWK;
        return iHashCode8 + (set2 != null ? set2.hashCode() : 0);
    }

    /* JADX INFO: renamed from: com.applovin.impl.b.a$a, reason: collision with other inner class name */
    public static class C0114a {
        private String aWD;
        private j aWE;
        private n aWF;
        private d aWG;
        private com.applovin.impl.b.c aWH;
        private Set<k> aWJ;
        private Set<k> aWK;
        private JSONObject adObject;
        private long createdAtMillis;
        private JSONObject fullResponse;
        private com.applovin.impl.sdk.n sdk;
        private com.applovin.impl.sdk.ad.b source;
        private String title;

        public C0114a V(JSONObject jSONObject) {
            if (jSONObject == null) {
                throw new IllegalArgumentException("No ad object specified.");
            }
            this.adObject = jSONObject;
            return this;
        }

        public C0114a W(JSONObject jSONObject) {
            if (jSONObject == null) {
                throw new IllegalArgumentException("No full ad response specified.");
            }
            this.fullResponse = jSONObject;
            return this;
        }

        public C0114a a(com.applovin.impl.sdk.ad.b bVar) {
            this.source = bVar;
            return this;
        }

        public C0114a R(com.applovin.impl.sdk.n nVar) {
            if (nVar == null) {
                throw new IllegalArgumentException("No sdk specified.");
            }
            this.sdk = nVar;
            return this;
        }

        public C0114a dT(String str) {
            this.title = str;
            return this;
        }

        public C0114a dU(String str) {
            this.aWD = str;
            return this;
        }

        public C0114a a(j jVar) {
            this.aWE = jVar;
            return this;
        }

        public C0114a a(n nVar) {
            this.aWF = nVar;
            return this;
        }

        public C0114a a(d dVar) {
            this.aWG = dVar;
            return this;
        }

        public C0114a a(com.applovin.impl.b.c cVar) {
            this.aWH = cVar;
            return this;
        }

        public C0114a b(Set<k> set) {
            this.aWJ = set;
            return this;
        }

        public C0114a c(Set<k> set) {
            this.aWK = set;
            return this;
        }

        public C0114a cc(long j) {
            this.createdAtMillis = j;
            return this;
        }

        public a Mg() {
            return new a(this);
        }
    }
}
