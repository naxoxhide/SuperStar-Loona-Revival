package com.applovin.impl.b;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class o {
    private Uri aYe;
    private Uri aYf;
    private a aYg;
    private String aYh;
    private long aYi;
    private int dE;
    private int height;

    public enum a {
        Progressive,
        Streaming
    }

    private o() {
    }

    public static o d(y yVar, com.applovin.impl.sdk.n nVar) {
        if (yVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (nVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        try {
            String strLI = yVar.LI();
            if (URLUtil.isValidUrl(strLI)) {
                Uri uri = Uri.parse(strLI);
                o oVar = new o();
                oVar.aYe = uri;
                oVar.aYf = uri;
                oVar.aYi = f(yVar);
                oVar.aYg = dW(yVar.LH().get("delivery"));
                oVar.height = StringUtils.parseInt(yVar.LH().get("height"));
                oVar.dE = StringUtils.parseInt(yVar.LH().get("width"));
                oVar.aYh = yVar.LH().get("type").toLowerCase(Locale.ENGLISH);
                return oVar;
            }
            nVar.BL();
            if (!x.Fk()) {
                return null;
            }
            nVar.BL().i("VastVideoFile", "Unable to create video file. Could not find URL.");
            return null;
        } catch (Throwable th) {
            nVar.BL();
            if (x.Fk()) {
                nVar.BL().c("VastVideoFile", "Error occurred while initializing", th);
            }
            nVar.Cq().g("VastVideoFile", th);
            return null;
        }
    }

    private static a dW(String str) {
        if (StringUtils.isValidString(str)) {
            if ("progressive".equalsIgnoreCase(str)) {
                return a.Progressive;
            }
            if ("streaming".equalsIgnoreCase(str)) {
                return a.Streaming;
            }
        }
        return a.Progressive;
    }

    private static long f(y yVar) {
        Map<String, String> mapLH = yVar.LH();
        long j = StringUtils.parseLong(mapLH.get("bitrate"), 0L);
        return j != 0 ? j : (StringUtils.parseLong(mapLH.get("minBitrate"), 0L) + StringUtils.parseLong(mapLH.get("maxBitrate"), 0L)) / 2;
    }

    public Uri MG() {
        return this.aYe;
    }

    public Uri FG() {
        return this.aYf;
    }

    public void j(Uri uri) {
        this.aYf = uri;
    }

    public String MH() {
        return this.aYh;
    }

    public long MI() {
        return this.aYi;
    }

    public String toString() {
        return "VastVideoFile{sourceVideoUri=" + this.aYe + ", videoUri=" + this.aYf + ", deliveryType=" + this.aYg + ", fileType='" + this.aYh + "', width=" + this.dE + ", height=" + this.height + ", bitrate=" + this.aYi + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.dE != oVar.dE || this.height != oVar.height || this.aYi != oVar.aYi) {
            return false;
        }
        Uri uri = this.aYe;
        if (uri == null ? oVar.aYe != null : !uri.equals(oVar.aYe)) {
            return false;
        }
        Uri uri2 = this.aYf;
        if (uri2 == null ? oVar.aYf != null : !uri2.equals(oVar.aYf)) {
            return false;
        }
        if (this.aYg != oVar.aYg) {
            return false;
        }
        String str = this.aYh;
        String str2 = oVar.aYh;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    public int hashCode() {
        Uri uri = this.aYe;
        int iHashCode = (uri != null ? uri.hashCode() : 0) * 31;
        Uri uri2 = this.aYf;
        int iHashCode2 = (iHashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        a aVar = this.aYg;
        int iHashCode3 = (iHashCode2 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        String str = this.aYh;
        return ((((((iHashCode3 + (str != null ? str.hashCode() : 0)) * 31) + this.dE) * 31) + this.height) * 31) + Long.valueOf(this.aYi).hashCode();
    }
}
