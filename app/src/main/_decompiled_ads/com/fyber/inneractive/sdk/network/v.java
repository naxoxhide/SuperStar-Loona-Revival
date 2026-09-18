package com.fyber.inneractive.sdk.network;

import android.content.Context;
import android.content.SharedPreferences;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class v<ResultData> {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.fyber.inneractive.sdk.cache.a<ResultData> f997b;
    public SharedPreferences c;

    public static class a extends Exception {
    }

    public v(Context context, com.fyber.inneractive.sdk.cache.a<ResultData> aVar) {
        this.a = context;
        this.f997b = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public boolean a(String str, String str2) {
        boolean z;
        int i = 1;
        i = 1;
        i = 1;
        IAlog.a("caching file %s", str);
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = this.a.openFileOutput(str, 0);
                fileOutputStreamOpenFileOutput.write(str2.getBytes());
                try {
                    IAlog.a("File cached successfully", new Object[0]);
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (Exception e) {
                        IAlog.e("Failed closing cache file: %s", e.getMessage());
                    }
                } catch (Exception e2) {
                    e = e2;
                    z = true;
                    IAlog.e("Failed caching file: %s", e.getMessage());
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (Exception e3) {
                            IAlog.e("Failed closing cache file: %s", e3.getMessage());
                        }
                    }
                    i = z;
                }
            } catch (Exception e4) {
                e = e4;
                z = false;
            }
            return i;
        } catch (Throwable th) {
            if (fileOutputStreamOpenFileOutput != null) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (Exception e5) {
                    Object[] objArr = new Object[i];
                    objArr[0] = e5.getMessage();
                    IAlog.e("Failed closing cache file: %s", objArr);
                }
            }
            throw th;
        }
    }

    public final String a(String str) throws Throwable {
        FileInputStream fileInputStreamOpenFileInput;
        IAlog.a("reading local file: %s", str);
        FileInputStream fileInputStream = null;
        str = null;
        str = null;
        String str2 = null;
        try {
            fileInputStreamOpenFileInput = this.a.openFileInput(str);
            try {
                try {
                    byte[] bArr = new byte[fileInputStreamOpenFileInput.available()];
                    fileInputStreamOpenFileInput.read(bArr);
                    String str3 = new String(bArr, "UTF-8");
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (Exception e) {
                        IAlog.e("Failed closing local file: %s", e.getMessage());
                    }
                    str2 = str3;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStreamOpenFileInput;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e2) {
                            IAlog.e("Failed closing local file: %s", e2.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                if (e instanceof FileNotFoundException) {
                    throw new FileNotFoundException();
                }
                IAlog.a("Failed reading local file: %s", e.getMessage());
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (Exception e4) {
                        IAlog.e("Failed closing local file: %s", e4.getMessage());
                    }
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStreamOpenFileInput = null;
        } catch (Throwable th2) {
            th = th2;
        }
        IAlog.a("local file %s read successfully", str);
        return str2;
    }
}
