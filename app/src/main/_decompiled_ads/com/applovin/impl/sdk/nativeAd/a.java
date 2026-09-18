package com.applovin.impl.sdk.nativeAd;

import android.net.Uri;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import java.io.File;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.applovin.impl.sdk.e.d {
    private final AppLovinNativeAdImpl aHa;
    private final com.applovin.impl.sdk.d.e aHe;
    private final InterfaceC0137a aHf;

    /* JADX INFO: renamed from: com.applovin.impl.sdk.nativeAd.a$a, reason: collision with other inner class name */
    public interface InterfaceC0137a {
        void a(AppLovinNativeAdImpl appLovinNativeAdImpl);
    }

    public a(AppLovinNativeAdImpl appLovinNativeAdImpl, n nVar, InterfaceC0137a interfaceC0137a) {
        super("TaskCacheNativeAd", nVar);
        this.aHe = new com.applovin.impl.sdk.d.e();
        this.aHa = appLovinNativeAdImpl;
        this.aHf = interfaceC0137a;
    }

    @Override // java.lang.Runnable
    public void run() {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Begin caching ad #" + this.aHa.getAdIdNumber() + "...");
        }
        Uri uriP = p(this.aHa.getIconUri());
        if (uriP != null) {
            this.aHa.setIconUri(uriP);
        }
        Uri uriP2 = p(this.aHa.getMainImageUri());
        if (uriP2 != null) {
            this.aHa.setMainImageUri(uriP2);
        }
        Uri uriP3 = p(this.aHa.getPrivacyIconUri());
        if (uriP3 != null) {
            this.aHa.setPrivacyIconUri(uriP3);
        }
        x xVar2 = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Finished caching ad #" + this.aHa.getAdIdNumber());
        }
        this.aHf.a(this.aHa);
    }

    private Uri p(Uri uri) {
        if (uri == null) {
            return null;
        }
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Attempting to cache resource: " + uri);
        }
        String strA = this.sdk.Ca().a(rQ(), uri.toString(), this.aHa.getCachePrefix(), Collections.emptyList(), false, false, this.aHe);
        if (StringUtils.isValidString(strA)) {
            File fileA = this.sdk.Ca().a(strA, rQ());
            if (fileA != null) {
                Uri uriFromFile = Uri.fromFile(fileA);
                if (uriFromFile != null) {
                    return uriFromFile;
                }
                x xVar2 = this.logger;
                if (x.Fk()) {
                    this.logger.i(this.tag, "Unable to extract Uri from image file");
                }
            } else {
                x xVar3 = this.logger;
                if (x.Fk()) {
                    this.logger.i(this.tag, "Unable to retrieve File from cached image filename = " + strA);
                }
            }
        }
        return null;
    }
}
