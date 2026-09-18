package com.applovin.impl.sdk.nativeAd;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.l;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.R;

/* JADX INFO: loaded from: classes.dex */
public class AppLovinMediaView extends FrameLayout {
    protected final ImageView imageView;
    protected final x logger;
    protected final n sdk;

    public AppLovinMediaView(AppLovinNativeAdImpl appLovinNativeAdImpl, n nVar, Context context) {
        super(context);
        setBackgroundColor(-16777216);
        this.sdk = nVar;
        this.logger = nVar.BL();
        LayoutInflater.from(context).inflate(R.layout.applovin_native_ad_media_view, (ViewGroup) this, true);
        Uri mainImageUri = appLovinNativeAdImpl.getMainImageUri();
        com.applovin.impl.b.a vastAd = appLovinNativeAdImpl.getVastAd();
        Uri uriFG = vastAd != null ? vastAd.FG() : null;
        if (mainImageUri == null && uriFG == null) {
            throw new IllegalStateException("AppLovin native ad missing image AND video resources");
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aNw)).booleanValue()) {
            setOnTouchListener(new AppLovinTouchToClickListener(nVar, com.applovin.impl.sdk.c.b.aLk, context, appLovinNativeAdImpl));
        } else {
            setOnClickListener(appLovinNativeAdImpl);
        }
        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        this.imageView = imageView;
        if (mainImageUri != null) {
            l.a(imageView, mainImageUri);
        }
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
    }

    public float getAspectRatio() {
        Drawable drawable;
        ImageView imageView = this.imageView;
        if (imageView == null || (drawable = imageView.getDrawable()) == null) {
            return 0.0f;
        }
        return drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
    }

    public void destroy() {
        setOnClickListener(null);
        setOnTouchListener(null);
        removeAllViews();
    }
}
