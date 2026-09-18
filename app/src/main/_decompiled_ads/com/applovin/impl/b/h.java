package com.applovin.impl.b;

import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;

/* JADX INFO: loaded from: classes.dex */
public class h {
    private final String aXC;
    private final String aXD;

    private h(String str, String str2) {
        this.aXC = str;
        this.aXD = str2;
    }

    public static h b(y yVar, com.applovin.impl.sdk.n nVar) {
        if (yVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (nVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        try {
            return new h(yVar.LH().get("apiFramework"), yVar.LI());
        } catch (Throwable th) {
            nVar.BL();
            if (x.Fk()) {
                nVar.BL().c("VastJavaScriptResource", "Error occurred while initializing", th);
            }
            nVar.Cq().g("VastJavaScriptResource", th);
            return null;
        }
    }

    public String Mw() {
        return this.aXC;
    }

    public String Mx() {
        return this.aXD;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        String str = this.aXC;
        if (str == null ? hVar.aXC != null : !str.equals(hVar.aXC)) {
            return false;
        }
        String str2 = this.aXD;
        String str3 = hVar.aXD;
        if (str2 != null) {
            return str2.equals(str3);
        }
        return str3 == null;
    }

    public int hashCode() {
        String str = this.aXC;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.aXD;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "VastJavaScriptResource{apiFramework='" + this.aXC + "', javascriptResourceUrl='" + this.aXD + "'}";
    }
}
