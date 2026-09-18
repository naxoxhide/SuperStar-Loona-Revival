package com.applovin.impl.sdk;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class y {
    private final Map<String, a> aFj = new HashMap(4);
    private final Object aFk = new Object();
    private final x logger;

    public static class a {
        private final String aFl;
        private final String aFm;
        private final String aFn;
        private String aFo;
        private String aFp;

        protected boolean canEqual(Object obj) {
            return obj instanceof a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!aVar.canEqual(this)) {
                return false;
            }
            String strXr = xr();
            String strXr2 = aVar.xr();
            if (strXr != null ? !strXr.equals(strXr2) : strXr2 != null) {
                return false;
            }
            String strYz = yz();
            String strYz2 = aVar.yz();
            if (strYz != null ? !strYz.equals(strYz2) : strYz2 != null) {
                return false;
            }
            String networkName = getNetworkName();
            String networkName2 = aVar.getNetworkName();
            if (networkName != null ? !networkName.equals(networkName2) : networkName2 != null) {
                return false;
            }
            String strFl = Fl();
            String strFl2 = aVar.Fl();
            if (strFl != null ? !strFl.equals(strFl2) : strFl2 != null) {
                return false;
            }
            String strFm = Fm();
            String strFm2 = aVar.Fm();
            return strFm != null ? strFm.equals(strFm2) : strFm2 == null;
        }

        public int hashCode() {
            String strXr = xr();
            int iHashCode = strXr == null ? 43 : strXr.hashCode();
            String strYz = yz();
            int iHashCode2 = ((iHashCode + 59) * 59) + (strYz == null ? 43 : strYz.hashCode());
            String networkName = getNetworkName();
            int iHashCode3 = (iHashCode2 * 59) + (networkName == null ? 43 : networkName.hashCode());
            String strFl = Fl();
            int iHashCode4 = (iHashCode3 * 59) + (strFl == null ? 43 : strFl.hashCode());
            String strFm = Fm();
            return (iHashCode4 * 59) + (strFm != null ? strFm.hashCode() : 43);
        }

        public String toString() {
            return "MediationWaterfallWinnerTracker.WinningAd(bCode=" + xr() + ", adapterName=" + yz() + ", networkName=" + getNetworkName() + ", secondWinnerAdapterName=" + Fl() + ", secondWinnerNetworkName=" + Fm() + ")";
        }

        public a(String str, String str2, String str3) {
            this.aFl = str;
            this.aFm = str2;
            this.aFn = str3;
        }

        public String xr() {
            return this.aFl;
        }

        public String yz() {
            return this.aFm;
        }

        public String getNetworkName() {
            return this.aFn;
        }

        public String Fl() {
            return this.aFo;
        }

        public String Fm() {
            return this.aFp;
        }
    }

    y(n nVar) {
        this.logger = nVar.BL();
    }

    public void l(com.applovin.impl.mediation.b.a aVar) {
        b(aVar, null);
    }

    public void b(com.applovin.impl.mediation.b.a aVar, com.applovin.impl.mediation.b.a aVar2) {
        synchronized (this.aFk) {
            if (x.Fk()) {
                this.logger.f("MediationWaterfallWinnerTracker", "Tracking winning ad: " + aVar);
            }
            a aVar3 = new a(aVar.xr(), aVar.yz(), aVar.getNetworkName());
            if (aVar2 != null) {
                aVar3.aFo = aVar2.yz();
                aVar3.aFp = aVar2.getNetworkName();
            }
            this.aFj.put(aVar.getAdUnitId(), aVar3);
        }
    }

    public a cO(String str) {
        a aVar;
        synchronized (this.aFk) {
            aVar = this.aFj.get(str);
        }
        return aVar;
    }

    public void m(com.applovin.impl.mediation.b.a aVar) {
        synchronized (this.aFk) {
            String adUnitId = aVar.getAdUnitId();
            a aVar2 = this.aFj.get(adUnitId);
            if (aVar2 == null) {
                if (x.Fk()) {
                    this.logger.f("MediationWaterfallWinnerTracker", "No previous winner to clear.");
                }
                return;
            }
            if (aVar.xr().equals(aVar2.xr())) {
                if (x.Fk()) {
                    this.logger.f("MediationWaterfallWinnerTracker", "Clearing previous winning ad: " + aVar2);
                }
                this.aFj.remove(adUnitId);
            } else if (x.Fk()) {
                this.logger.f("MediationWaterfallWinnerTracker", "Previous winner not cleared for ad: " + aVar + " , since it could have already been updated with a new ad: " + aVar2);
            }
        }
    }
}
