package com.applovin.impl.adview;

import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.AppLovinExtras;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class p {
    private final Map<String, Object> agg;
    private final com.applovin.impl.sdk.n sdk;

    public String getIdentifier() {
        return "google watermark";
    }

    public p(Map<String, Object> map, com.applovin.impl.sdk.n nVar) {
        this.agg = map;
        this.sdk = nVar;
    }

    public Drawable rM() {
        Object obj = this.agg.get(AppLovinExtras.Keys.KEY_WATERMARK);
        if (!U(obj)) {
            this.sdk.BL();
            if (com.applovin.impl.sdk.x.Fk()) {
                this.sdk.BL().i("GoogleWatermarkGenerator", "Unable to render invalid watermark: " + obj);
            }
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode((String) obj, 0);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.applovin.impl.sdk.n.getApplicationContext().getResources(), BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
            bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            return bitmapDrawable;
        } catch (Throwable th) {
            this.sdk.BL();
            if (com.applovin.impl.sdk.x.Fk()) {
                this.sdk.BL().c("GoogleWatermarkGenerator", "Failed to render watermark", th);
            }
            return null;
        }
    }

    public boolean rN() {
        return U(this.agg.get(AppLovinExtras.Keys.KEY_WATERMARK));
    }

    private boolean U(Object obj) {
        return (obj instanceof String) && StringUtils.isValidString((String) obj);
    }
}
