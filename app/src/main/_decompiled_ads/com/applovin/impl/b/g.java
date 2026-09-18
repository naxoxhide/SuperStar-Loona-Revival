package com.applovin.impl.b;

import android.content.Context;
import android.net.Uri;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class g {
    private Uri aXA;
    private Uri aXB;
    public final Set<k> aXd = new HashSet();
    public final Set<k> aXz = new HashSet();
    private int dE;
    private int height;

    public static g a(y yVar, com.applovin.impl.sdk.n nVar) {
        if (yVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (nVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        y yVarDO = yVar.dO("StaticResource");
        if (yVarDO == null || !URLUtil.isValidUrl(yVarDO.LI())) {
            nVar.BL();
            if (!x.Fk()) {
                return null;
            }
            nVar.BL().i("VastIndustryIcon", "Unable to create industry icon.  No valid image URL found.");
            return null;
        }
        g gVar = new g();
        gVar.aXA = Uri.parse(yVarDO.LI());
        y yVarDP = yVar.dP("IconClickThrough");
        if (yVarDP != null && URLUtil.isValidUrl(yVarDP.LI())) {
            gVar.aXB = Uri.parse(yVarDP.LI());
        }
        String str = yVar.LH().get("width");
        int i = 0;
        int i2 = (str == null || Integer.parseInt(str) <= 0) ? 0 : Integer.parseInt(str);
        String str2 = yVar.LH().get("height");
        if (str2 != null && Integer.parseInt(str2) > 0) {
            i = Integer.parseInt(str2);
        }
        int iIntValue = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPu)).intValue();
        if (i2 > 0 && i > 0) {
            double d = i2 / i;
            int iMin = Math.min(Math.max(i2, i), iIntValue);
            if (i2 >= i) {
                gVar.dE = iMin;
                gVar.height = (int) (((double) iMin) / d);
            } else {
                gVar.height = iMin;
                gVar.dE = (int) (((double) iMin) * d);
            }
        } else {
            gVar.height = iIntValue;
            gVar.dE = iIntValue;
        }
        return gVar;
    }

    public static ImageView b(Uri uri, Context context, com.applovin.impl.sdk.n nVar) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(true);
        imageView.setVisibility(8);
        com.applovin.impl.sdk.utils.l.a(imageView, uri.toString(), nVar);
        return imageView;
    }

    public Uri Mt() {
        return this.aXA;
    }

    public Uri Mu() {
        return this.aXB;
    }

    public int getWidth() {
        return this.dE;
    }

    public int getHeight() {
        return this.height;
    }

    public Set<k> Mn() {
        return this.aXd;
    }

    public Set<k> Mv() {
        return this.aXz;
    }

    public String toString() {
        return "VastIndustryIcon{imageUri='" + Mt() + "', clickUri='" + Mu() + "', width=" + getWidth() + ", height=" + getHeight() + "}";
    }
}
