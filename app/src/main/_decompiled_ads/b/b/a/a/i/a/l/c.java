package b.b.a.a.i.a.l;

import android.util.Log;
import b.b.a.a.i.a.f;
import b.b.a.a.i.a.i;

/* JADX INFO: compiled from: LDebug.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(String str) {
        try {
            f fVarA = i.f().a();
            if (fVarA == null || !fVarA.c()) {
                return;
            }
            String strO = fVarA.o();
            if (strO == null) {
                strO = "";
            }
            Log.d(strO + "-log", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(String str) {
        try {
            f fVarA = i.f().a();
            if (fVarA == null || !fVarA.c()) {
                return;
            }
            String strO = fVarA.o();
            if (strO == null) {
                strO = "";
            }
            Log.e(strO + "-log", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void c(String str) {
        try {
            f fVarA = i.f().a();
            if (fVarA == null || !fVarA.c()) {
                return;
            }
            String strO = fVarA.o();
            if (strO == null) {
                strO = "";
            }
            Log.i(strO + "-log", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void d(String str) {
        try {
            f fVarA = i.f().a();
            if (fVarA == null || !fVarA.c()) {
                return;
            }
            String strO = fVarA.o();
            if (strO == null) {
                strO = "";
            }
            Log.w(strO + "-log", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(String str, String str2) {
        try {
            f fVarA = i.f().a();
            if (fVarA == null || !fVarA.c()) {
                return;
            }
            String strO = fVarA.o();
            if (strO == null) {
                strO = "";
            }
            Log.d((strO + "-log") + str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(String str, String str2) {
        try {
            f fVarA = i.f().a();
            if (fVarA == null || !fVarA.c()) {
                return;
            }
            String strO = fVarA.o();
            if (strO == null) {
                strO = "";
            }
            Log.i((strO + "-log") + str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void c(String str, String str2) {
        try {
            f fVarA = i.f().a();
            if (fVarA == null || !fVarA.c()) {
                return;
            }
            String strO = fVarA.o();
            if (strO == null) {
                strO = "";
            }
            Log.w((strO + "-log") + str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
