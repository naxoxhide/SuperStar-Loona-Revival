package com.stansassets.core.utility;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class AN_BitmapFactory {
    public static Bitmap Decode(String str) {
        byte[] bArrDecode = new byte[0];
        try {
            bArrDecode = AN_Base64.decode(str);
        } catch (AN_Base64DecoderException e) {
            e.printStackTrace();
        }
        return Decode(bArrDecode);
    }

    public static Bitmap Decode(byte[] bArr) {
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }

    public static byte[] EncodeToBytes(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static String EncodeToBase64(Drawable drawable) {
        return EncodeToBase64(drawableToBitmap(drawable));
    }

    public static String EncodeToBase64(Bitmap bitmap) {
        return AN_Base64.encode(EncodeToBytes(bitmap));
    }

    public static Bitmap ResizeImage(Bitmap bitmap, int i) {
        int i2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > height) {
            i2 = width / i;
        } else {
            i2 = height / i;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i2;
        options.inPurgeable = true;
        int width2 = i > bitmap.getWidth() ? bitmap.getWidth() : i;
        if (i > bitmap.getHeight()) {
            i = bitmap.getHeight();
        }
        if (width > height) {
            i = (int) (width2 / (bitmap.getWidth() / bitmap.getHeight()));
        } else {
            width2 = (int) (i / (bitmap.getHeight() / bitmap.getWidth()));
        }
        return Bitmap.createScaledBitmap(bitmap, width2, i, false);
    }

    public static Bitmap DecodeFile(String str, int i) {
        int i2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 > i4) {
            i2 = i3 / i;
        } else {
            i2 = i4 / i;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i2;
        options.inPurgeable = true;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        if (bitmapDecodeFile == null) {
            return null;
        }
        try {
            bitmapDecodeFile = rotateImageIfRequired(bitmapDecodeFile, AN_UnityBridge.currentActivity, Uri.fromFile(new File(str)));
        } catch (IOException e) {
            AN_Logger.Log("Failed to identify Image rotation data");
            e.printStackTrace();
        }
        int width = i > bitmapDecodeFile.getWidth() ? bitmapDecodeFile.getWidth() : i;
        if (i > bitmapDecodeFile.getHeight()) {
            i = bitmapDecodeFile.getHeight();
        }
        if (i3 > i4) {
            i = (int) (width / (bitmapDecodeFile.getWidth() / bitmapDecodeFile.getHeight()));
        } else {
            width = (int) (i / (bitmapDecodeFile.getHeight() / bitmapDecodeFile.getWidth()));
        }
        return Bitmap.createScaledBitmap(bitmapDecodeFile, width, i, false);
    }

    public static Bitmap rotateImageIfRequired(Bitmap bitmap, Context context, Uri uri) throws IOException {
        if (uri.getScheme().equals("content")) {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"orientation"}, null, null, null);
            if (!cursorQuery.moveToFirst()) {
                return bitmap;
            }
            int i = cursorQuery.getInt(0);
            cursorQuery.close();
            return rotateImage(bitmap, i);
        }
        int attributeInt = new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1);
        if (attributeInt == 3) {
            return rotateImage(bitmap, 180);
        }
        if (attributeInt != 6) {
            return attributeInt != 8 ? bitmap : rotateImage(bitmap, 270);
        }
        return rotateImage(bitmap, 90);
    }

    private static Bitmap rotateImage(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight > 0 ? intrinsicHeight : 1, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }
}
