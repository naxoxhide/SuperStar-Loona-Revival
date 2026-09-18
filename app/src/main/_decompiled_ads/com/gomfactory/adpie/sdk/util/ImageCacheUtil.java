package com.gomfactory.adpie.sdk.util;

import android.graphics.Bitmap;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import androidx.collection.LruCache;
import com.gomfactory.adpie.sdk.AdPieSDK;

/* JADX INFO: loaded from: classes2.dex */
public class ImageCacheUtil {
    public static final String TAG = "ImageCacheUtil";
    private static ImageCacheUtil instance;
    private LruCache<String, Bitmap> mLruCache;

    private ImageCacheUtil() {
        int iMaxMemory = (int) (Runtime.getRuntime().maxMemory() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
        int i = iMaxMemory / 8;
        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
            Log.d(TAG, "max memory " + iMaxMemory + " cache size " + i);
        }
        this.mLruCache = new LruCache<String, Bitmap>(i) { // from class: com.gomfactory.adpie.sdk.util.ImageCacheUtil.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.collection.LruCache
            public int sizeOf(String str, Bitmap bitmap) {
                return bitmap.getByteCount() / 1024;
            }
        };
    }

    public static ImageCacheUtil getInstance() {
        if (instance == null) {
            instance = new ImageCacheUtil();
        }
        return instance;
    }

    public void addBitmapToMemoryCache(String str, Bitmap bitmap) {
        if (getBitmapFromMemCache(str) == null) {
            this.mLruCache.put(str, bitmap);
        }
    }

    public Bitmap getBitmapFromMemCache(String str) {
        return this.mLruCache.get(str);
    }
}
