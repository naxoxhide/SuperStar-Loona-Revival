package com.tnkfactory.ad.pub.a;

import android.content.Context;
import com.tnkfactory.ad.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes4.dex */
public final class e1 extends s {
    /* JADX WARN: Code duplicated, block: B:74:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:? A[SYNTHETIC] */
    public static String b(Context context, String str) throws Throwable {
        File fileA;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strA = s.a(str);
        FileOutputStream fileOutputStream2 = null;
        if (strA == null || (fileA = s.a(context, strA)) == null) {
            return null;
        }
        if (fileA.exists()) {
            return fileA.getPath();
        }
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            httpsURLConnection.setConnectTimeout(2000);
            httpsURLConnection.setReadTimeout(10000);
            httpsURLConnection.setSSLSocketFactory(new x0());
            if (httpsURLConnection.getResponseCode() != 200) {
                fileA.delete();
                return null;
            }
            inputStream = httpsURLConnection.getInputStream();
            try {
                fileOutputStream = new FileOutputStream(fileA);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i = inputStream.read(bArr, 0, 4096);
                        if (i == -1) {
                            try {
                                inputStream.close();
                            } catch (IOException unused) {
                            }
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                            s.a(context);
                            return fileA.getPath();
                        }
                        if (System.currentTimeMillis() - jCurrentTimeMillis > 10000) {
                            throw new SocketTimeoutException("socket timeout");
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                } catch (SocketTimeoutException unused3) {
                    fileOutputStream2 = fileOutputStream;
                    try {
                        fileA.delete();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused5) {
                            }
                        }
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused6) {
                            }
                        }
                        if (fileOutputStream != null) {
                            throw th;
                        }
                        try {
                            fileOutputStream.close();
                            throw th;
                        } catch (IOException unused7) {
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        fileA.delete();
                        Logger.e("error #1004 : " + th.toString());
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused8) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused9) {
                            }
                        }
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (fileOutputStream != null) {
                            throw th;
                        }
                        fileOutputStream.close();
                        throw th;
                    }
                }
            } catch (SocketTimeoutException unused10) {
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                fileA.delete();
                Logger.e("error #1004 : " + th.toString());
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            }
        } catch (SocketTimeoutException unused11) {
            inputStream = null;
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
    }
}
