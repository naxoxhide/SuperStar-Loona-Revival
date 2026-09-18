package com.applovin.impl.b;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;
import com.facebook.internal.security.CertificateUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class n {
    private List<o> aXT;
    private List<String> aXU;
    private int aXV;
    private g aXW;
    private Uri aXb;
    private final Set<k> aXd;
    private final Map<String, Set<k>> aXe;

    public enum a {
        UNSPECIFIED,
        LOW,
        MEDIUM,
        HIGH,
        DYNAMIC
    }

    private n() {
        this.aXT = Collections.emptyList();
        this.aXU = Collections.emptyList();
        this.aXd = new HashSet();
        this.aXe = new HashMap();
    }

    private n(e eVar) {
        this.aXT = Collections.emptyList();
        this.aXU = Collections.emptyList();
        this.aXd = new HashSet();
        this.aXe = new HashMap();
        this.aXU = eVar.Ms();
    }

    public static n a(y yVar, n nVar, e eVar, com.applovin.impl.sdk.n nVar2) {
        y yVarDO;
        g gVarA;
        List<y> listDN;
        y yVarDO2;
        List<o> listC;
        y yVarDO3;
        int iF;
        if (yVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (eVar == null) {
            throw new IllegalArgumentException("No context specified.");
        }
        if (nVar2 == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (nVar == null) {
            try {
                nVar = new n(eVar);
            } catch (Throwable th) {
                nVar2.BL();
                if (x.Fk()) {
                    nVar2.BL().c("VastVideoCreative", "Error occurred while initializing", th);
                }
                nVar2.Cq().g("VastVideoCreative", th);
                return null;
            }
        }
        if (nVar.aXV == 0 && (yVarDO3 = yVar.dO("Duration")) != null && (iF = f(yVarDO3.LI(), nVar2)) > 0) {
            nVar.aXV = iF;
        }
        y yVarDO4 = yVar.dO("MediaFiles");
        if (yVarDO4 != null && (listC = c(yVarDO4, nVar2)) != null && listC.size() > 0) {
            List<o> list = nVar.aXT;
            if (list != null) {
                listC.addAll(list);
            }
            nVar.aXT = listC;
        }
        y yVarDO5 = yVar.dO("VideoClicks");
        if (yVarDO5 != null) {
            if (nVar.aXb == null && (yVarDO2 = yVarDO5.dO("ClickThrough")) != null) {
                String strLI = yVarDO2.LI();
                if (StringUtils.isValidString(strLI)) {
                    nVar.aXb = Uri.parse(strLI);
                }
            }
            m.a(yVarDO5.dN("ClickTracking"), nVar.aXd, eVar, nVar2);
        }
        y yVarDO6 = yVar.dO("Icons");
        if (yVarDO6 != null && (gVarA = g.a((yVarDO = yVarDO6.dO("Icon")), nVar2)) != null) {
            y yVarDO7 = yVarDO.dO("IconClicks");
            if (yVarDO7 != null && (listDN = yVarDO7.dN("IconClickTracking")) != null) {
                m.a(listDN, gVarA.aXd, eVar, nVar2);
            }
            List<y> listDN2 = yVarDO.dN("IconViewTracking");
            if (listDN2 != null) {
                m.a(listDN2, gVarA.aXz, eVar, nVar2);
            }
            nVar.aXW = gVarA;
        }
        m.a(yVar, nVar.aXe, eVar, nVar2);
        return nVar;
    }

    private static int f(String str, com.applovin.impl.sdk.n nVar) {
        try {
            List<String> listExplode = CollectionUtils.explode(str, CertificateUtil.DELIMITER);
            if (listExplode.size() == 3) {
                return (int) (TimeUnit.HOURS.toSeconds(StringUtils.parseInt(listExplode.get(0))) + TimeUnit.MINUTES.toSeconds(StringUtils.parseInt(listExplode.get(1))) + ((long) StringUtils.parseInt(listExplode.get(2))));
            }
        } catch (Throwable unused) {
            nVar.BL();
            if (x.Fk()) {
                nVar.BL().i("VastVideoCreative", "Unable to parse duration from \"" + str + "\"");
            }
        }
        return 0;
    }

    private static List<o> c(y yVar, com.applovin.impl.sdk.n nVar) {
        List<y> listDN = yVar.dN("MediaFile");
        ArrayList arrayList = new ArrayList(listDN.size());
        List<String> listExplode = CollectionUtils.explode((String) nVar.a(com.applovin.impl.sdk.c.b.aPp));
        List<String> listExplode2 = CollectionUtils.explode((String) nVar.a(com.applovin.impl.sdk.c.b.aPo));
        Iterator<y> it = listDN.iterator();
        while (it.hasNext()) {
            o oVarD = o.d(it.next(), nVar);
            if (oVarD != null) {
                try {
                    String strMH = oVarD.MH();
                    if (StringUtils.isValidString(strMH) && !listExplode.contains(strMH)) {
                        arrayList.add(oVarD);
                    } else {
                        if (((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aPq)).booleanValue()) {
                            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(oVarD.FG().toString());
                            if (StringUtils.isValidString(fileExtensionFromUrl) && !listExplode2.contains(fileExtensionFromUrl)) {
                                arrayList.add(oVarD);
                            }
                        }
                        nVar.BL();
                        if (x.Fk()) {
                            nVar.BL().h("VastVideoCreative", "Video file not supported: " + oVarD);
                        }
                    }
                } catch (Throwable th) {
                    nVar.BL();
                    if (x.Fk()) {
                        nVar.BL().c("VastVideoCreative", "Failed to validate video file: " + oVarD, th);
                    }
                }
            }
        }
        return arrayList;
    }

    public o a(a aVar, long j) {
        List<o> list = this.aXT;
        o oVar = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        List<o> arrayList = new ArrayList(3);
        for (String str : this.aXU) {
            for (o oVar2 : this.aXT) {
                String strMH = oVar2.MH();
                if (StringUtils.isValidString(strMH) && str.equalsIgnoreCase(strMH)) {
                    arrayList.add(oVar2);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = this.aXT;
        }
        Collections.sort(arrayList, new Comparator<o>() { // from class: com.applovin.impl.b.n.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(o oVar3, o oVar4) {
                return Long.compare(oVar3.MI(), oVar4.MI());
            }
        });
        if (aVar == a.DYNAMIC) {
            for (o oVar3 : arrayList) {
                if (oVar3.MI() > j) {
                    break;
                }
                oVar = oVar3;
            }
            return oVar != null ? oVar : (o) arrayList.get(0);
        }
        if (aVar == a.LOW) {
            return (o) arrayList.get(0);
        }
        if (aVar == a.MEDIUM) {
            return (o) arrayList.get(arrayList.size() / 2);
        }
        return (o) arrayList.get(arrayList.size() - 1);
    }

    public List<o> ME() {
        return this.aXT;
    }

    public int MF() {
        return this.aXV;
    }

    public Uri Ml() {
        return this.aXb;
    }

    public Set<k> Mn() {
        return this.aXd;
    }

    public Map<String, Set<k>> Mo() {
        return this.aXe;
    }

    public g LW() {
        return this.aXW;
    }

    public String toString() {
        return "VastVideoCreative{videoFiles=" + this.aXT + ", durationSeconds=" + this.aXV + ", destinationUri=" + this.aXb + ", clickTrackers=" + this.aXd + ", eventTrackers=" + this.aXe + ", industryIcon=" + this.aXW + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (this.aXV != nVar.aXV) {
            return false;
        }
        List<o> list = this.aXT;
        if (list == null ? nVar.aXT != null : !list.equals(nVar.aXT)) {
            return false;
        }
        Uri uri = this.aXb;
        if (uri == null ? nVar.aXb != null : !uri.equals(nVar.aXb)) {
            return false;
        }
        Set<k> set = this.aXd;
        if (set == null ? nVar.aXd != null : !set.equals(nVar.aXd)) {
            return false;
        }
        Map<String, Set<k>> map = this.aXe;
        Map<String, Set<k>> map2 = nVar.aXe;
        if (map != null) {
            return map.equals(map2);
        }
        return map2 == null;
    }

    public int hashCode() {
        List<o> list = this.aXT;
        int iHashCode = (((list != null ? list.hashCode() : 0) * 31) + this.aXV) * 31;
        Uri uri = this.aXb;
        int iHashCode2 = (iHashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        Set<k> set = this.aXd;
        int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map<String, Set<k>> map = this.aXe;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }
}
