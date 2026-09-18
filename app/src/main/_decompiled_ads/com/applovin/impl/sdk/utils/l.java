package com.applovin.impl.sdk.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.io.Closeable;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class l {
    public static void a(final ImageView imageView, final String str, final com.applovin.impl.sdk.n nVar) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        nVar.BL();
        if (com.applovin.impl.sdk.x.Fk()) {
            nVar.BL().f("ImageViewUtils", "Fetching image: " + str + "...");
        }
        nVar.BM().KH().execute(new Runnable() { // from class: com.applovin.impl.sdk.utils.-$$Lambda$l$Ty1Mv1fMH374FNOPmoNHdHYzJnM
            @Override // java.lang.Runnable
            public final void run() {
                l.a(str, nVar, imageView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, final com.applovin.impl.sdk.n nVar, final ImageView imageView) {
        InputStream inputStreamOpenStream = null;
        try {
            inputStreamOpenStream = new URL(str).openStream();
            final Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenStream);
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.-$$Lambda$l$mZNsssMAOa4bfAb5kbNhGxQnz7M
                @Override // java.lang.Runnable
                public final void run() {
                    l.a(nVar, bitmapDecodeStream, imageView);
                }
            });
        } catch (Throwable th) {
            try {
                nVar.BL();
                if (com.applovin.impl.sdk.x.Fk()) {
                    nVar.BL().c("ImageViewUtils", "Failed to fetch image: " + str, th);
                }
            } finally {
                u.a((Closeable) inputStreamOpenStream, nVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.applovin.impl.sdk.n nVar, Bitmap bitmap, ImageView imageView) {
        nVar.BL();
        if (com.applovin.impl.sdk.x.Fk()) {
            nVar.BL().f("ImageViewUtils", "Image fetched");
        }
        imageView.setImageDrawable(new BitmapDrawable(com.applovin.impl.sdk.n.getApplicationContext().getResources(), bitmap));
    }

    public static void a(final ImageView imageView, final Uri uri) {
        if (uri == null || imageView == null) {
            return;
        }
        if (imageView.getHeight() > 0 && imageView.getWidth() > 0) {
            b(imageView, uri);
        } else {
            imageView.post(new Runnable() { // from class: com.applovin.impl.sdk.utils.-$$Lambda$l$kv5cm0Vo1B5RytiXx8aGlVZ7Ub4
                @Override // java.lang.Runnable
                public final void run() {
                    l.b(imageView, uri);
                }
            });
        }
    }

    public static void b(final ImageView imageView, final Uri uri) {
        if (uri == null || imageView == null) {
            return;
        }
        if (com.applovin.impl.sdk.n.aAz == null) {
            com.applovin.impl.sdk.x.H("ImageViewUtils", "SDK has not been initialized");
        } else {
            com.applovin.impl.sdk.n.aAz.BM().KH().execute(new Runnable() { // from class: com.applovin.impl.sdk.utils.-$$Lambda$l$Wwb3lohd4GNaoMPH20EqxiANxlE
                @Override // java.lang.Runnable
                public final void run() {
                    l.a(uri, imageView);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Uri uri, final ImageView imageView) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(uri.getPath(), options);
        int height = imageView.getHeight();
        int width = imageView.getWidth();
        if (height <= 0 || width <= 0) {
            Point pointW = h.W(imageView.getContext());
            height = Math.min(pointW.x, pointW.y);
            width = height;
        }
        int i2 = options.outHeight;
        int i3 = options.outWidth;
        if (i2 > height || i3 > width) {
            while (true) {
                int i4 = i * 2;
                if (i2 / i4 < height && i3 / i4 < width) {
                    break;
                } else {
                    i = i4;
                }
            }
        }
        options.inSampleSize = i;
        options.inJustDecodeBounds = false;
        com.applovin.impl.sdk.n.aAz.BL();
        if (com.applovin.impl.sdk.x.Fk()) {
            com.applovin.impl.sdk.n.aAz.BL().f("ImageViewUtils", "Loading image: " + uri.getLastPathSegment() + "...");
        }
        final Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(uri.getPath(), options);
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.-$$Lambda$l$7SDOP5ZX570GEL8IUAV0JxAZ_5Y
            @Override // java.lang.Runnable
            public final void run() {
                imageView.setImageBitmap(bitmapDecodeFile);
            }
        });
    }
}
