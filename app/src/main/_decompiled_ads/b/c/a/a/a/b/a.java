package b.c.a.a.a.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.o;

/* JADX INFO: compiled from: AdvertisingIdHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f258b;
    private String a = "";

    private a() {
    }

    public static a b() {
        if (f258b == null) {
            synchronized (a.class) {
                if (f258b == null) {
                    f258b = new a();
                }
            }
        }
        return f258b;
    }

    public String a() {
        if (!o.d().A("gaid")) {
            return "";
        }
        if (!TextUtils.isEmpty(this.a)) {
            return this.a;
        }
        String strA = c.a(o.a()).a("gaid", "");
        this.a = strA;
        return strA;
    }

    public void a(String str) {
        this.a = str;
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c.a(o.a()).b("gaid", str);
    }
}
