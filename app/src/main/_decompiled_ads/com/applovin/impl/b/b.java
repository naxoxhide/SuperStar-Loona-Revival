package com.applovin.impl.b;

import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private final String aWX;
    private final List<h> aWY;
    private final Set<k> aWZ;
    private final String verificationParameters;

    private b(String str, List<h> list, String str2, Set<k> set) {
        this.aWX = str;
        this.aWY = list;
        this.verificationParameters = str2;
        this.aWZ = set;
    }

    public static b a(y yVar, e eVar, com.applovin.impl.sdk.n nVar) {
        try {
            String str = yVar.LH().get("vendor");
            y yVarDP = yVar.dP("VerificationParameters");
            String strLI = yVarDP != null ? yVarDP.LI() : null;
            List<y> listDN = yVar.dN("JavaScriptResource");
            ArrayList arrayList = new ArrayList(listDN.size());
            Iterator<y> it = listDN.iterator();
            while (it.hasNext()) {
                h hVarB = h.b(it.next(), nVar);
                if (hVarB != null) {
                    arrayList.add(hVarB);
                }
            }
            HashMap map = new HashMap();
            m.a(yVar, map, eVar, nVar);
            return new b(str, arrayList, strLI, (Set) map.get("verificationNotExecuted"));
        } catch (Throwable th) {
            nVar.BL();
            if (x.Fk()) {
                nVar.BL().c("VastAdVerification", "Error occurred while initializing", th);
            }
            nVar.Cq().g("VastAdVerification", th);
            return null;
        }
    }

    public String Mh() {
        return this.aWX;
    }

    public List<h> Mi() {
        return this.aWY;
    }

    public String getVerificationParameters() {
        return this.verificationParameters;
    }

    public Set<k> Mj() {
        return this.aWZ;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        String str = this.aWX;
        if (str == null ? bVar.aWX != null : !str.equals(bVar.aWX)) {
            return false;
        }
        List<h> list = this.aWY;
        if (list == null ? bVar.aWY != null : !list.equals(bVar.aWY)) {
            return false;
        }
        String str2 = this.verificationParameters;
        if (str2 == null ? bVar.verificationParameters != null : !str2.equals(bVar.verificationParameters)) {
            return false;
        }
        Set<k> set = this.aWZ;
        Set<k> set2 = bVar.aWZ;
        if (set != null) {
            return set.equals(set2);
        }
        return set2 == null;
    }

    public int hashCode() {
        String str = this.aWX;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<h> list = this.aWY;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.verificationParameters;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Set<k> set = this.aWZ;
        return iHashCode3 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        return "VastAdVerification{vendorId='" + this.aWX + "'javascriptResources='" + this.aWY + "'verificationParameters='" + this.verificationParameters + "'errorEventTrackers='" + this.aWZ + "'}";
    }
}
