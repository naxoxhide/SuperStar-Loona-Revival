package com.tnkfactory.ad.pub.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.tnkfactory.ad.Logger;
import com.tnkfactory.framework.crypto.EncryptUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class s {
    public static File a(Context context, String str) {
        File file;
        try {
            file = Build.VERSION.SDK_INT >= 19 ? new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "tnkpub") : new File(context.getCacheDir(), "tnkpub");
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e) {
            Logger.e(a.a("error #1001 : ").append(e.toString()).toString());
            file = null;
        }
        if (file == null) {
            return null;
        }
        return new File(file, str);
    }

    public static String a(String str) {
        try {
            String strReplace = str.replace("http://", "").replace("https://", "");
            int iIndexOf = strReplace.indexOf(RemoteSettings.FORWARD_SLASH_STRING);
            if (iIndexOf > 0) {
                strReplace = strReplace.substring(iIndexOf + 1);
            }
            return EncryptUtils.md5Hex(strReplace);
        } catch (Exception e) {
            Logger.e(str);
            Logger.e("error #1002 : " + e.toString());
            return null;
        }
    }

    public static void a(byte[] bArr, File file) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.close();
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream2 = fileOutputStream;
                        Logger.e("## error writing to file " + e.toString());
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
            }
        } catch (IOException unused2) {
        }
    }

    public static void a(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        y0 y0VarA = y0.a(context);
        if (jCurrentTimeMillis - y0VarA.b(y0VarA.a).getLong("__tnk_0007_", 0L) < 86400000) {
            return;
        }
        Logger.d("info #1005");
        try {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - 1814400000;
            File file = new File(context.getCacheDir(), "tnkpub");
            if (file.listFiles() != null) {
                for (File file2 : file.listFiles()) {
                    if (file2.exists() && file2.isFile() && file2.lastModified() < jCurrentTimeMillis2) {
                        Logger.d("info #1006 : " + file2.getName());
                        file2.delete();
                    }
                }
            }
        } catch (Exception e) {
            Logger.e(a.a("error #1005 : ").append(e.toString()).toString());
        }
        y0.a(context).d();
    }
}
