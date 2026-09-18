package b.a.a.a.a.a.b;

import android.content.Context;
import android.os.Build;
import b.a.a.a.a.a.a.d.b;
import b.a.a.a.a.a.a.i.c;
import com.adxcorp.ads.mediation.util.ReportUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: MediaConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static b a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f27b = 10;
    public static int c = 10;
    public static int d = 10;
    public static int e = 10;

    public static void a(Context context) {
        b.a.a.a.a.a.a.i.a.a(context);
        if (Build.VERSION.SDK_INT < 23) {
            b.a.a.a.a.a.b.c.q.a.b();
        }
    }

    public static int b() {
        return d;
    }

    public static int c() {
        return e;
    }

    public static int d() {
        return c;
    }

    public static int e() {
        return f27b;
    }

    public static void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            f27b = jSONObject.optInt("splash", 10);
            c = jSONObject.optInt(ReportUtil.EVENT_TYPE_REWARD, 10);
            d = jSONObject.optInt("brand", 10);
            int iOptInt = jSONObject.optInt("other", 10);
            e = iOptInt;
            if (f27b < 0) {
                f27b = 10;
            }
            if (c < 0) {
                c = 10;
            }
            if (d < 0) {
                d = 10;
            }
            if (iOptInt < 0) {
                e = 10;
            }
            c.b("MediaConfig", "splash=", Integer.valueOf(f27b), ",reward=", Integer.valueOf(c), ",brand=", Integer.valueOf(d), ",other=", Integer.valueOf(e));
        } catch (Throwable th) {
            c.b("MediaConfig", th.getMessage());
        }
    }

    public static void a(b bVar) {
        a = bVar;
    }

    public static void a() {
        b bVar = a;
        if (bVar != null) {
            bVar.c();
        }
    }
}
