package b.b.a.a.j.f;

import android.content.Context;
import b.b.a.a.j.e.g;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: MultiProcessFileUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(Context context, int i, String str, int i2) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i == 1) {
                linkedHashMap.put(a(i2), str);
            }
            b.a("MultiProcessFileUtils", "saveData = " + str);
            if (g.a().a(i2).b() != null) {
                g.a().a(i2).b().a(context, linkedHashMap);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0029  */
    public static String a(Context context, int i, int i2) {
        String strA;
        if (i != 1) {
            strA = "";
        } else {
            try {
                if (g.a().a(i2).b() != null) {
                    strA = g.a().a(i2).b().a(context, a(i2), "");
                } else {
                    strA = "";
                }
            } catch (Exception unused) {
            }
        }
        return strA instanceof String ? String.valueOf(strA) : "";
    }

    private static String a(int i) {
        return "tnc_config" + i;
    }
}
