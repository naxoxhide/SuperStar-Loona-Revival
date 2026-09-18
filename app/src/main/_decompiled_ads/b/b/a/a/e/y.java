package b.b.a.a.e;

import android.text.TextUtils;

/* JADX INFO: compiled from: SerializeHelper.java */
/* JADX INFO: loaded from: classes.dex */
class y {
    private static boolean a;

    static String a() {
        return "";
    }

    static String a(Throwable th) {
        return "{\"code\":" + (th instanceof s ? ((s) th).a : 0) + "}";
    }

    static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        String strSubstring = a ? str.substring(1, str.length() - 1) : "";
        String str2 = "{\"code\":1,\"__data\":" + str;
        return !strSubstring.isEmpty() ? str2 + "," + strSubstring + "}" : str2 + "}";
    }

    static void a(boolean z) {
        a = z;
    }
}
