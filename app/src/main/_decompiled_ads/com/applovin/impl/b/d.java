package com.applovin.impl.b;

import android.net.Uri;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private Uri aXb;
    private i aXc;
    private final Set<k> aXd = new HashSet();
    private final Map<String, Set<k>> aXe = new HashMap();
    private int dE;
    private int height;

    private d() {
    }

    public static d a(y yVar, d dVar, e eVar, com.applovin.impl.sdk.n nVar) {
        y yVarDO;
        if (yVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (nVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (dVar == null) {
            try {
                dVar = new d();
            } catch (Throwable th) {
                nVar.BL();
                if (x.Fk()) {
                    nVar.BL().c("VastCompanionAd", "Error occurred while initializing", th);
                }
                nVar.Cq().g("VastCompanionAd", th);
                return null;
            }
        }
        if (dVar.dE == 0 && dVar.height == 0) {
            int i = StringUtils.parseInt(yVar.LH().get("width"));
            int i2 = StringUtils.parseInt(yVar.LH().get("height"));
            if (i > 0 && i2 > 0) {
                dVar.dE = i;
                dVar.height = i2;
            }
        }
        dVar.aXc = i.a(yVar, dVar.aXc, nVar);
        if (dVar.aXb == null && (yVarDO = yVar.dO("CompanionClickThrough")) != null) {
            String strLI = yVarDO.LI();
            if (StringUtils.isValidString(strLI)) {
                dVar.aXb = Uri.parse(strLI);
            }
        }
        m.a(yVar.dN("CompanionClickTracking"), dVar.aXd, eVar, nVar);
        m.a(yVar, dVar.aXe, eVar, nVar);
        return dVar;
    }

    public Uri Ml() {
        return this.aXb;
    }

    public i Mm() {
        return this.aXc;
    }

    public Set<k> Mn() {
        return this.aXd;
    }

    public Map<String, Set<k>> Mo() {
        return this.aXe;
    }

    public String toString() {
        return "VastCompanionAd{width=" + this.dE + ", height=" + this.height + ", destinationUri=" + this.aXb + ", nonVideoResource=" + this.aXc + ", clickTrackers=" + this.aXd + ", eventTrackers=" + this.aXe + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.dE != dVar.dE || this.height != dVar.height) {
            return false;
        }
        Uri uri = this.aXb;
        if (uri == null ? dVar.aXb != null : !uri.equals(dVar.aXb)) {
            return false;
        }
        i iVar = this.aXc;
        if (iVar == null ? dVar.aXc != null : !iVar.equals(dVar.aXc)) {
            return false;
        }
        Set<k> set = this.aXd;
        if (set == null ? dVar.aXd != null : !set.equals(dVar.aXd)) {
            return false;
        }
        Map<String, Set<k>> map = this.aXe;
        Map<String, Set<k>> map2 = dVar.aXe;
        if (map != null) {
            return map.equals(map2);
        }
        return map2 == null;
    }

    public int hashCode() {
        int i = ((this.dE * 31) + this.height) * 31;
        Uri uri = this.aXb;
        int iHashCode = (i + (uri != null ? uri.hashCode() : 0)) * 31;
        i iVar = this.aXc;
        int iHashCode2 = (iHashCode + (iVar != null ? iVar.hashCode() : 0)) * 31;
        Set<k> set = this.aXd;
        int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map<String, Set<k>> map = this.aXe;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }
}
