package com.stansassets.gallery;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.provider.MediaStore;
import com.stansassets.core.utility.AN_Logger;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes4.dex */
public class AN_CapturePhotoUtils {
    public static final String insertImage(ContentResolver contentResolver, Bitmap bitmap, Bitmap.CompressFormat compressFormat, String str, String str2) {
        Uri uriInsert;
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", str);
        contentValues.put("_display_name", str);
        contentValues.put("description", str2);
        int i = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$CompressFormat[compressFormat.ordinal()];
        if (i == 1) {
            AN_Logger.Log("MIME_TYPE: png");
            contentValues.put("mime_type", "image/png");
        } else if (i == 2) {
            contentValues.put("mime_type", "image/jpeg");
        }
        contentValues.put("date_added", Long.valueOf(System.currentTimeMillis() / 1000));
        contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        try {
            uriInsert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            try {
                AN_Logger.Log("url: " + uriInsert);
                if (bitmap != null) {
                    OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
                    try {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 50, outputStreamOpenOutputStream);
                        outputStreamOpenOutputStream.close();
                        long id = ContentUris.parseId(uriInsert);
                        storeThumbnail(contentResolver, MediaStore.Images.Thumbnails.getThumbnail(contentResolver, id, 1, null), id, 50.0f, 50.0f, 3);
                    } catch (Throwable th) {
                        outputStreamOpenOutputStream.close();
                        throw th;
                    }
                } else {
                    contentResolver.delete(uriInsert, null, null);
                    uriInsert = null;
                }
            } catch (Exception unused) {
                if (uriInsert != null) {
                    contentResolver.delete(uriInsert, null, null);
                    uriInsert = null;
                }
            }
        } catch (Exception unused2) {
            uriInsert = null;
        }
        if (uriInsert != null) {
            return uriInsert.toString();
        }
        return null;
    }

    /* JADX INFO: renamed from: com.stansassets.gallery.AN_CapturePhotoUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$CompressFormat;

        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            $SwitchMap$android$graphics$Bitmap$CompressFormat = iArr;
            try {
                iArr[Bitmap.CompressFormat.PNG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$CompressFormat[Bitmap.CompressFormat.JPEG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static final Bitmap storeThumbnail(ContentResolver contentResolver, Bitmap bitmap, long j, float f, float f2, int i) {
        Matrix matrix = new Matrix();
        matrix.setScale(f / bitmap.getWidth(), f2 / bitmap.getHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        ContentValues contentValues = new ContentValues(4);
        contentValues.put("kind", Integer.valueOf(i));
        contentValues.put("image_id", Integer.valueOf((int) j));
        contentValues.put("height", Integer.valueOf(bitmapCreateBitmap.getHeight()));
        contentValues.put("width", Integer.valueOf(bitmapCreateBitmap.getWidth()));
        try {
            OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(contentResolver.insert(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, contentValues));
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStreamOpenOutputStream);
            outputStreamOpenOutputStream.close();
            return bitmapCreateBitmap;
        } catch (FileNotFoundException | IOException unused) {
            return null;
        }
    }
}
