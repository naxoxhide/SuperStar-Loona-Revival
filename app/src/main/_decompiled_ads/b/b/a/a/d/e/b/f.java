package b.b.a.a.d.e.b;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.m;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: Version.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private static b.b.a.a.d.e.c.a a;

    public static synchronized void a(b.b.a.a.d.e.c.a aVar) {
        if (aVar != null) {
            if (aVar.f()) {
                a = aVar;
            }
        }
    }

    public static synchronized b.b.a.a.d.e.c.a b() {
        return a;
    }

    public static void c() {
        FileInputStream fileInputStream = null;
        try {
            File file = new File(c.f(), "temp_pkg_info.json");
            Long lValueOf = Long.valueOf(file.length());
            if (lValueOf.longValue() > 0 && file.exists() && file.isFile()) {
                byte[] bArr = new byte[lValueOf.intValue()];
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    fileInputStream2.read(bArr);
                    b.b.a.a.d.e.c.a aVarA = b.b.a.a.d.e.c.a.a(new JSONObject(new String(bArr, "utf-8")));
                    if (aVarA != null) {
                        a = aVarA;
                        m.a("Version", "old version read success: " + a.e());
                    }
                    fileInputStream = fileInputStream2;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    try {
                        m.b("Version", "version init error", th);
                        if (fileInputStream == null) {
                            return;
                        }
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                    }
                }
            } else {
                m.a("Version", "version pkg json file does not exist");
            }
            if (fileInputStream == null) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void d() {
        b.b.a.a.d.e.c.a aVar = a;
        if (aVar == null) {
            m.a("Version", "version save error1");
            return;
        }
        String strG = aVar.g();
        if (TextUtils.isEmpty(strG)) {
            m.a("Version", "version save error2");
            return;
        }
        File file = new File(c.f(), "temp_pkg_info.json");
        File file2 = new File(file + ".tmp");
        if (file2.exists()) {
            file2.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    fileOutputStream2.write(strG.getBytes("utf-8"));
                    if (file.exists()) {
                        file.delete();
                    }
                    file2.renameTo(file);
                    fileOutputStream2.close();
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        m.b("Version", "version save error3", th);
                        if (fileOutputStream == null) {
                        } else {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th2) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException unused2) {
        }
    }

    public static boolean b(String str) {
        try {
            if (b() != null && !TextUtils.isEmpty(b().e())) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                String strE = b().e();
                String[] strArrSplit = str.split("\\.");
                String[] strArrSplit2 = strE.split("\\.");
                int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
                for (int i = 0; i < iMin; i++) {
                    int length = strArrSplit[i].length() - strArrSplit2[i].length();
                    if (length != 0) {
                        return length > 0;
                    }
                    int iCompareTo = strArrSplit[i].compareTo(strArrSplit2[i]);
                    if (iCompareTo > 0) {
                        return true;
                    }
                    if (iCompareTo < 0) {
                        return false;
                    }
                    if (i == iMin - 1) {
                        return strArrSplit.length > strArrSplit2.length;
                    }
                }
                return false;
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    public static b.b.a.a.d.e.c.a.C0027a a(String str) {
        if (!TextUtils.isEmpty(str) && b() != null && b().d() != null && b().f()) {
            for (b.b.a.a.d.e.c.a.C0027a c0027a : b().d()) {
                if (c0027a.c() != null && c0027a.c().equals(str)) {
                    return c0027a;
                }
            }
        }
        return null;
    }

    public static void a() {
        b.b.a.a.d.e.c.a aVarB = b();
        if (aVarB == null) {
            return;
        }
        File fileF = c.f();
        try {
            new File(fileF, "temp_pkg_info.json").delete();
        } catch (Throwable unused) {
        }
        if (aVarB.d() != null) {
            Iterator<b.b.a.a.d.e.c.a.C0027a> it = aVarB.d().iterator();
            while (it.hasNext()) {
                try {
                    new File(fileF, com.bytedance.sdk.component.utils.e.a(it.next().c())).delete();
                } catch (Throwable unused2) {
                }
            }
        }
        a = null;
    }
}
