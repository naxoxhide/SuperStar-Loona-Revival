package com.applovin.impl.b;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class m {
    private static final DateFormat aXR = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
    private static final Random aXS = new Random(System.currentTimeMillis());

    public static void a(e eVar, AppLovinAdLoadListener appLovinAdLoadListener, f fVar, int i, com.applovin.impl.sdk.n nVar) {
        if (nVar == null) {
            throw new IllegalArgumentException("Unable to handle failure. No sdk specified.");
        }
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.failedToReceiveAd(i);
        }
        a(a(eVar, nVar), fVar, nVar);
    }

    public static f a(a aVar) {
        if (b(aVar) || c(aVar)) {
            return null;
        }
        return f.GENERAL_WRAPPER_ERROR;
    }

    public static boolean b(a aVar) {
        n nVarLS;
        List<o> listME;
        return (aVar == null || (nVarLS = aVar.LS()) == null || (listME = nVarLS.ME()) == null || listME.isEmpty()) ? false : true;
    }

    public static boolean c(a aVar) {
        d dVarLV;
        i iVarMm;
        if (aVar == null || (dVarLV = aVar.LV()) == null || (iVarMm = dVarLV.Mm()) == null) {
            return false;
        }
        return iVarMm.Mz() != null || StringUtils.isValidString(iVarMm.MA());
    }

    public static Uri a(String str, long j, Uri uri, f fVar, com.applovin.impl.sdk.n nVar) {
        if (URLUtil.isValidUrl(str)) {
            try {
                String string = Integer.toString(fVar.getErrorCode());
                String strReplace = str.replace("[ERRORCODE]", string).replace("[REASON]", string);
                if (j >= 0) {
                    strReplace = strReplace.replace("[CONTENTPLAYHEAD]", cd(j));
                }
                if (uri != null) {
                    strReplace = strReplace.replace("[ASSETURI]", uri.toString());
                }
                return Uri.parse(strReplace.replace("[CACHEBUSTING]", MC()).replace("[TIMESTAMP]", MD()));
            } catch (Throwable th) {
                nVar.BL();
                if (x.Fk()) {
                    nVar.BL().c("VastUtils", "Unable to replace macros in URL string " + str, th);
                }
                nVar.Cq().g("VastUtils", th);
                return null;
            }
        }
        nVar.BL();
        if (x.Fk()) {
            nVar.BL().i("VastUtils", "Unable to replace macros in invalid URL string.");
        }
        return null;
    }

    private static String cd(long j) {
        if (j <= 0) {
            return "00:00:00.000";
        }
        return String.format(Locale.US, "%02d:%02d:%02d.000", Long.valueOf(TimeUnit.SECONDS.toHours(j)), Long.valueOf(TimeUnit.SECONDS.toMinutes(j) % TimeUnit.MINUTES.toSeconds(1L)), Long.valueOf(j % TimeUnit.MINUTES.toSeconds(1L)));
    }

    private static String MC() {
        return Integer.toString(aXS.nextInt(89999999) + 10000000);
    }

    private static String MD() {
        DateFormat dateFormat = aXR;
        dateFormat.setTimeZone(TimeZone.getDefault());
        return dateFormat.format(new Date());
    }

    public static void a(Set<k> set, com.applovin.impl.sdk.n nVar) {
        a(set, -1L, (Uri) null, f.UNSPECIFIED, nVar);
    }

    public static void a(Set<k> set, f fVar, com.applovin.impl.sdk.n nVar) {
        a(set, -1L, (Uri) null, fVar, nVar);
    }

    public static void a(Set<k> set, long j, Uri uri, f fVar, com.applovin.impl.sdk.n nVar) {
        if (nVar == null) {
            throw new IllegalArgumentException("Unable to fire trackers. No sdk specified.");
        }
        if (set == null || set.isEmpty()) {
            return;
        }
        Iterator<k> it = set.iterator();
        while (it.hasNext()) {
            Uri uriA = a(it.next().MB(), j, uri, fVar, nVar);
            if (uriA != null) {
                nVar.Cs().a(com.applovin.impl.sdk.network.h.IB().dh(uriA.toString()).aV(false).ID(), false);
            }
        }
    }

    public static void a(y yVar, Map<String, Set<k>> map, e eVar, com.applovin.impl.sdk.n nVar) {
        List<y> listDN;
        if (nVar == null) {
            throw new IllegalArgumentException("Unable to render event trackers. No sdk specified.");
        }
        if (yVar == null) {
            nVar.BL();
            if (x.Fk()) {
                nVar.BL().i("VastUtils", "Unable to render event trackers; null node provided");
                return;
            }
            return;
        }
        if (map == null) {
            nVar.BL();
            if (x.Fk()) {
                nVar.BL().i("VastUtils", "Unable to render event trackers; null event trackers provided");
                return;
            }
            return;
        }
        y yVarDO = yVar.dO("TrackingEvents");
        if (yVarDO == null || (listDN = yVarDO.dN("Tracking")) == null) {
            return;
        }
        for (y yVar2 : listDN) {
            String str = yVar2.LH().get("event");
            if (StringUtils.isValidString(str)) {
                k kVarB = k.b(yVar2, eVar, nVar);
                if (kVarB != null) {
                    Set<k> set = map.get(str);
                    if (set != null) {
                        set.add(kVarB);
                    } else {
                        HashSet hashSet = new HashSet();
                        hashSet.add(kVarB);
                        map.put(str, hashSet);
                    }
                }
            } else {
                nVar.BL();
                if (x.Fk()) {
                    nVar.BL().i("VastUtils", "Could not find event for tracking node = " + yVar2);
                }
            }
        }
    }

    public static void a(List<y> list, Set<k> set, e eVar, com.applovin.impl.sdk.n nVar) {
        if (nVar == null) {
            throw new IllegalArgumentException("Unable to render trackers. No sdk specified.");
        }
        if (list == null) {
            nVar.BL();
            if (x.Fk()) {
                nVar.BL().i("VastUtils", "Unable to render trackers; null nodes provided");
                return;
            }
            return;
        }
        if (set == null) {
            nVar.BL();
            if (x.Fk()) {
                nVar.BL().i("VastUtils", "Unable to render trackers; null trackers provided");
                return;
            }
            return;
        }
        Iterator<y> it = list.iterator();
        while (it.hasNext()) {
            k kVarB = k.b(it.next(), eVar, nVar);
            if (kVarB != null) {
                set.add(kVarB);
            }
        }
    }

    public static boolean d(y yVar) {
        if (yVar != null) {
            return yVar.dP("Wrapper") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains a wrapper response");
    }

    public static boolean e(y yVar) {
        if (yVar != null) {
            return yVar.dP("InLine") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains an inline response");
    }

    public static String a(e eVar) {
        y yVarDP;
        if (eVar == null) {
            throw new IllegalArgumentException("Unable to get resolution uri string for fetching the next wrapper or inline response in the chain");
        }
        List<y> listMq = eVar.Mq();
        int size = eVar.Mq().size();
        if (size <= 0 || (yVarDP = listMq.get(size - 1).dP("VASTAdTagURI")) == null) {
            return null;
        }
        return yVarDP.LI();
    }

    public static String a(y yVar, String str, String str2) {
        y yVarDO = yVar.dO(str);
        if (yVarDO != null) {
            String strLI = yVarDO.LI();
            if (StringUtils.isValidString(strLI)) {
                return strLI;
            }
        }
        return str2;
    }

    private static Set<k> a(e eVar, com.applovin.impl.sdk.n nVar) {
        if (eVar == null) {
            return null;
        }
        List<y> listMq = eVar.Mq();
        Set<k> hashSet = new HashSet<>(listMq.size());
        for (y yVar : listMq) {
            y yVarDP = yVar.dP("Wrapper");
            if (yVarDP == null) {
                yVarDP = yVar.dP("InLine");
            }
            if (yVarDP != null) {
                hashSet = a(hashSet, yVarDP.dN("Error"), eVar, nVar);
            } else {
                hashSet = a(hashSet, yVar.dN("Error"), eVar, nVar);
            }
        }
        nVar.BL();
        if (x.Fk()) {
            nVar.BL().f("VastUtils", "Retrieved " + hashSet.size() + " top level error trackers: " + hashSet);
        }
        return hashSet;
    }

    private static Set<k> a(Set<k> set, List<y> list, e eVar, com.applovin.impl.sdk.n nVar) {
        if (list != null) {
            Iterator<y> it = list.iterator();
            while (it.hasNext()) {
                k kVarB = k.b(it.next(), eVar, nVar);
                if (kVarB != null) {
                    set.add(kVarB);
                }
            }
        }
        return set;
    }
}
