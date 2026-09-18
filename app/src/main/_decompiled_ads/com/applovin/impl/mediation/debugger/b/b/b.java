package com.applovin.impl.mediation.debugger.b.b;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private final String aoJ;
    private final String aoK;
    private final String aoL;
    private final String aoM;
    private final String aoN;
    private final int aoO;
    private final boolean aoP;

    protected boolean canEqual(Object obj) {
        return obj instanceof b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!bVar.canEqual(this)) {
            return false;
        }
        String strVd = vd();
        String strVd2 = bVar.vd();
        if (strVd != null ? !strVd.equals(strVd2) : strVd2 != null) {
            return false;
        }
        String publisherId = getPublisherId();
        String publisherId2 = bVar.getPublisherId();
        if (publisherId != null ? !publisherId.equals(publisherId2) : publisherId2 != null) {
            return false;
        }
        String strVe = ve();
        String strVe2 = bVar.ve();
        if (strVe != null ? !strVe.equals(strVe2) : strVe2 != null) {
            return false;
        }
        String strVf = vf();
        String strVf2 = bVar.vf();
        return strVf != null ? strVf.equals(strVf2) : strVf2 == null;
    }

    public int hashCode() {
        String strVd = vd();
        int iHashCode = strVd == null ? 43 : strVd.hashCode();
        String publisherId = getPublisherId();
        int iHashCode2 = ((iHashCode + 59) * 59) + (publisherId == null ? 43 : publisherId.hashCode());
        String strVe = ve();
        int iHashCode3 = (iHashCode2 * 59) + (strVe == null ? 43 : strVe.hashCode());
        String strVf = vf();
        return (iHashCode3 * 59) + (strVf != null ? strVf.hashCode() : 43);
    }

    public String toString() {
        return "AppAdsTxtEntry(domainName=" + vd() + ", publisherId=" + getPublisherId() + ", relationship=" + ve() + ", certificateAuthorityId=" + vf() + ", rawValue=" + vg() + ", rowNumber=" + vh() + ", valid=" + vi() + ")";
    }

    public String vd() {
        return this.aoJ;
    }

    public String getPublisherId() {
        return this.aoK;
    }

    public String ve() {
        return this.aoL;
    }

    public String vf() {
        return this.aoM;
    }

    public String vg() {
        return this.aoN;
    }

    public int vh() {
        return this.aoO;
    }

    public boolean vi() {
        return this.aoP;
    }

    public b(String str, int i) {
        this.aoN = str;
        this.aoO = i;
        String[] strArrSplit = str.split(",");
        boolean z = strArrSplit.length == 3 || strArrSplit.length == 4;
        this.aoP = z;
        if (z) {
            this.aoJ = bI(strArrSplit[0]);
            this.aoK = bI(strArrSplit[1]);
            this.aoL = bI(strArrSplit[2]);
            this.aoM = strArrSplit.length == 4 ? bI(strArrSplit[3]) : "";
            return;
        }
        this.aoJ = "";
        this.aoK = "";
        this.aoL = "";
        this.aoM = "";
    }

    public b(String str) {
        this(str, -1);
    }

    public boolean vc() {
        return this.aoJ.equals("applovin.com");
    }

    private String bI(String str) {
        return str.replace((char) 173, ' ').trim();
    }
}
