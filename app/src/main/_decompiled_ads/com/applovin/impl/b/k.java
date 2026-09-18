package com.applovin.impl.b;

import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;
import com.facebook.internal.security.CertificateUtil;
import com.tapjoy.TJAdUnitConstants;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class k {
    private String aXM;
    private String aXN;
    private long aXO = -1;
    private int aXP = -1;
    private String ahJ;

    private k() {
    }

    public static k b(y yVar, e eVar, com.applovin.impl.sdk.n nVar) {
        List<String> listExplode;
        int size;
        long seconds;
        if (yVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (nVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        try {
            String strLI = yVar.LI();
            if (StringUtils.isValidString(strLI)) {
                k kVar = new k();
                kVar.aXN = strLI;
                kVar.ahJ = yVar.LH().get("id");
                kVar.aXM = yVar.LH().get("event");
                kVar.aXP = a(kVar.Ag(), eVar);
                String str = yVar.LH().get("offset");
                if (StringUtils.isValidString(str)) {
                    String strTrim = str.trim();
                    if (strTrim.contains("%")) {
                        kVar.aXP = StringUtils.parseInt(strTrim.substring(0, strTrim.length() - 1));
                    } else if (strTrim.contains(CertificateUtil.DELIMITER) && (size = (listExplode = CollectionUtils.explode(strTrim, CertificateUtil.DELIMITER)).size()) > 0) {
                        long j = 0;
                        int i = size - 1;
                        for (int i2 = i; i2 >= 0; i2--) {
                            String str2 = listExplode.get(i2);
                            if (StringUtils.isNumeric(str2)) {
                                int i3 = Integer.parseInt(str2);
                                if (i2 == i) {
                                    seconds = i3;
                                } else if (i2 == size - 2) {
                                    seconds = TimeUnit.MINUTES.toSeconds(i3);
                                } else if (i2 == size - 3) {
                                    seconds = TimeUnit.HOURS.toSeconds(i3);
                                }
                                j += seconds;
                            }
                        }
                        kVar.aXO = j;
                        kVar.aXP = -1;
                    }
                }
                return kVar;
            }
            nVar.BL();
            if (!x.Fk()) {
                return null;
            }
            nVar.BL().i("VastTracker", "Unable to create tracker. Could not find URL.");
            return null;
        } catch (Throwable th) {
            nVar.BL();
            if (x.Fk()) {
                nVar.BL().c("VastTracker", "Error occurred while initializing", th);
            }
            nVar.Cq().g("VastTracker", th);
            return null;
        }
    }

    private static int a(String str, e eVar) {
        if ("start".equalsIgnoreCase(str)) {
            return 0;
        }
        if (TJAdUnitConstants.String.VIDEO_FIRST_QUARTILE.equalsIgnoreCase(str)) {
            return 25;
        }
        if ("midpoint".equalsIgnoreCase(str)) {
            return 50;
        }
        if (TJAdUnitConstants.String.VIDEO_THIRD_QUARTILE.equalsIgnoreCase(str)) {
            return 75;
        }
        if (!"complete".equalsIgnoreCase(str)) {
            return -1;
        }
        if (eVar != null) {
            return eVar.GC();
        }
        return 95;
    }

    public String Ag() {
        return this.aXM;
    }

    public String MB() {
        return this.aXN;
    }

    public boolean h(long j, int i) {
        long j2 = this.aXO;
        boolean z = j2 >= 0;
        boolean z2 = j >= j2;
        int i2 = this.aXP;
        boolean z3 = i2 >= 0;
        boolean z4 = i >= i2;
        if (z && z2) {
            return true;
        }
        return z3 && z4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (this.aXO != kVar.aXO || this.aXP != kVar.aXP) {
            return false;
        }
        String str = this.ahJ;
        if (str == null ? kVar.ahJ != null : !str.equals(kVar.ahJ)) {
            return false;
        }
        String str2 = this.aXM;
        if (str2 == null ? kVar.aXM == null : str2.equals(kVar.aXM)) {
            return this.aXN.equals(kVar.aXN);
        }
        return false;
    }

    public int hashCode() {
        String str = this.ahJ;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.aXM;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.aXN.hashCode()) * 31;
        long j = this.aXO;
        return ((iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31) + this.aXP;
    }

    public String toString() {
        return "VastTracker{identifier='" + this.ahJ + "', event='" + this.aXM + "', uriString='" + this.aXN + "', offsetSeconds=" + this.aXO + ", offsetPercent=" + this.aXP + '}';
    }
}
