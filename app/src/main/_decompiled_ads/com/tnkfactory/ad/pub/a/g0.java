package com.tnkfactory.ad.pub.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tnkfactory.ad.Logger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes4.dex */
public final class g0 extends s {
    /* JADX WARN: Code duplicated, block: B:37:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:40:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d9 A[EXC_TOP_SPLITTER, PHI: r1 r9
      0x00d9: PHI (r1v5 java.io.InputStream) = (r1v4 java.io.InputStream), (r1v9 java.io.InputStream) binds: [B:37:0x00d6, B:30:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x00d9: PHI (r9v8 android.graphics.Bitmap) = (r9v7 android.graphics.Bitmap), (r9v15 android.graphics.Bitmap) binds: [B:37:0x00d6, B:30:0x00b1] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public static Bitmap b(Context context, String str) {
        File fileA;
        Throwable th;
        Bitmap bitmap;
        InputStream inputStream;
        Bitmap bitmap2;
        String strA = s.a(str);
        InputStream inputStream2 = null;
        Bitmap bitmap3 = null;
        Bitmap bitmapDecodeByteArray = null;
        InputStream inputStream3 = null;
        if (strA == null || (fileA = s.a(context, strA)) == null) {
            return null;
        }
        try {
            if (!fileA.exists() || fileA.length() <= 0) {
                Logger.d("info #1008 : " + str);
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                httpsURLConnection.setConnectTimeout(2000);
                httpsURLConnection.setReadTimeout(5000);
                httpsURLConnection.setSSLSocketFactory(new x0());
                if (httpsURLConnection.getResponseCode() == 200) {
                    inputStream = httpsURLConnection.getInputStream();
                    try {
                        byte[] bArr = new byte[32768];
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            int i = inputStream.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                        s.a(byteArray, fileA);
                    } catch (Throwable th2) {
                        th = th2;
                        Bitmap bitmap4 = bitmapDecodeByteArray;
                        inputStream2 = inputStream;
                        bitmap = bitmap4;
                        InputStream inputStream4 = inputStream2;
                        bitmap3 = bitmap;
                        inputStream = inputStream4;
                        try {
                            Logger.e("error #1003 : " + th.toString());
                            if (inputStream != null) {
                                Bitmap bitmap5 = bitmap3;
                                inputStream3 = inputStream;
                                bitmap2 = bitmap5;
                                try {
                                    inputStream3.close();
                                } catch (IOException unused) {
                                }
                            } else {
                                bitmap2 = bitmap3;
                            }
                        } catch (Throwable th3) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th3;
                        }
                    }
                } else {
                    bitmap2 = null;
                }
                if (inputStream3 != null) {
                    inputStream3.close();
                }
                s.a(context);
                return bitmap2;
            }
            Logger.d("info #1007 : " + fileA.getPath());
            inputStream = new FileInputStream(fileA);
            try {
                bitmapDecodeByteArray = BitmapFactory.decodeStream(inputStream);
            } catch (Throwable th4) {
                th = th4;
                Logger.e("error #1003 : " + th.toString());
                if (inputStream != null) {
                    Bitmap bitmap6 = bitmap3;
                    inputStream3 = inputStream;
                    bitmap2 = bitmap6;
                    inputStream3.close();
                } else {
                    bitmap2 = bitmap3;
                }
            }
            Bitmap bitmap7 = bitmapDecodeByteArray;
            inputStream3 = inputStream;
            bitmap2 = bitmap7;
            if (inputStream3 != null) {
                inputStream3.close();
            }
        } catch (Throwable th5) {
            th = th5;
            bitmap = null;
        }
        s.a(context);
        return bitmap2;
    }
}
