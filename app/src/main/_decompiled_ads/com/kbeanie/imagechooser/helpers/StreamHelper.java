package com.kbeanie.imagechooser.helpers;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.kbeanie.imagechooser.exceptions.ChooserException;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class StreamHelper {
    static final String TAG = "StreamHelper";

    public static void closeSilent(Closeable closeable) {
        try {
            close(closeable);
        } catch (ChooserException e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    public static void close(Closeable closeable) throws ChooserException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                throw new ChooserException(e);
            }
        }
    }

    public static void flush(OutputStream outputStream) throws ChooserException {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                throw new ChooserException(e);
            }
        }
    }

    public static void close(ParcelFileDescriptor parcelFileDescriptor) throws ChooserException {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e) {
                throw new ChooserException(e);
            }
        }
    }

    public static void verifyCursor(Uri uri, Cursor cursor) throws ChooserException {
        if (cursor == null) {
            throw new ChooserException("Didnt not get cursor in return for = " + uri);
        }
    }

    public static void verifyStream(String str, ParcelFileDescriptor parcelFileDescriptor) throws ChooserException {
        if (parcelFileDescriptor == null) {
            throw new ChooserException("Could not read file descriptor from file at path = " + str);
        }
    }

    public static void verifyStream(String str, InputStream inputStream) throws ChooserException {
        if (inputStream == null) {
            throw new ChooserException("Could not open stream to read path = " + str);
        }
    }

    public static void verifyBitmap(String str, Bitmap bitmap) throws ChooserException {
        if (bitmap == null) {
            throw new ChooserException("Could not read bitmap from this path = " + str);
        }
    }

    public static boolean isNonNull(Bitmap bitmap) {
        if (bitmap != null) {
            return true;
        }
        Log.w(TAG, "Bitmap is null. No good.");
        return false;
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 != i) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
