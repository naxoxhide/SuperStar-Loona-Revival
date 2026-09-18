package com.applovin.impl.b;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;

/* JADX INFO: loaded from: classes.dex */
public class i {
    private a aXE;
    private Uri aXF;
    private String aXG;

    public enum a {
        UNSPECIFIED,
        STATIC,
        IFRAME,
        HTML
    }

    private i() {
    }

    static i a(y yVar, i iVar, com.applovin.impl.sdk.n nVar) {
        if (yVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (nVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (iVar == null) {
            try {
                iVar = new i();
            } catch (Throwable th) {
                nVar.BL();
                if (x.Fk()) {
                    nVar.BL().c("VastNonVideoResource", "Error occurred while initializing", th);
                }
                nVar.Cq().g("VastNonVideoResource", th);
                return null;
            }
        }
        if (iVar.aXF == null && !StringUtils.isValidString(iVar.aXG)) {
            String strA = a(yVar, "StaticResource");
            if (URLUtil.isValidUrl(strA)) {
                iVar.aXF = Uri.parse(strA);
                iVar.aXE = a.STATIC;
                return iVar;
            }
            String strA2 = a(yVar, "IFrameResource");
            if (StringUtils.isValidString(strA2)) {
                iVar.aXE = a.IFRAME;
                if (URLUtil.isValidUrl(strA2)) {
                    iVar.aXF = Uri.parse(strA2);
                } else {
                    iVar.aXG = strA2;
                }
                return iVar;
            }
            String strA3 = a(yVar, "HTMLResource");
            if (StringUtils.isValidString(strA3)) {
                iVar.aXE = a.HTML;
                if (URLUtil.isValidUrl(strA3)) {
                    iVar.aXF = Uri.parse(strA3);
                } else {
                    iVar.aXG = strA3;
                }
            }
        }
        return iVar;
    }

    private static String a(y yVar, String str) {
        y yVarDO = yVar.dO(str);
        if (yVarDO != null) {
            return yVarDO.LI();
        }
        return null;
    }

    public a My() {
        return this.aXE;
    }

    public Uri Mz() {
        return this.aXF;
    }

    public void u(Uri uri) {
        this.aXF = uri;
    }

    public String MA() {
        return this.aXG;
    }

    public void dV(String str) {
        this.aXG = str;
    }

    public String toString() {
        return "VastNonVideoResource{type=" + this.aXE + ", resourceUri=" + this.aXF + ", resourceContents='" + this.aXG + "'}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.aXE != iVar.aXE) {
            return false;
        }
        Uri uri = this.aXF;
        if (uri == null ? iVar.aXF != null : !uri.equals(iVar.aXF)) {
            return false;
        }
        String str = this.aXG;
        String str2 = iVar.aXG;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    public int hashCode() {
        a aVar = this.aXE;
        int iHashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        Uri uri = this.aXF;
        int iHashCode2 = (iHashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        String str = this.aXG;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }
}
