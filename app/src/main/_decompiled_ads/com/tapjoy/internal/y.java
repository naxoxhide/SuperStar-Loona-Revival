package com.tapjoy.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.ContentHandler;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes4.dex */
public final class y extends ContentHandler {
    public static final y a = new y();

    @Override // java.net.ContentHandler
    public final Object getContent(URLConnection uRLConnection) throws IOException {
        Bitmap bitmapDecodeStream;
        InputStream inputStream = uRLConnection.getInputStream();
        int i = 1;
        while (true) {
            try {
                try {
                    if (!(inputStream instanceof z)) {
                        bitmapDecodeStream = BitmapFactory.decodeStream(new z(inputStream));
                        break;
                    }
                    bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
                    break;
                } catch (Throwable th) {
                    inputStream.close();
                    throw th;
                }
            } catch (OutOfMemoryError e) {
                if (i >= 10) {
                    throw e;
                }
                try {
                    System.gc();
                    i++;
                } catch (OutOfMemoryError unused) {
                    bitmapDecodeStream = null;
                }
                bitmapDecodeStream = null;
            }
        }
        inputStream.close();
        return bitmapDecodeStream;
    }
}
