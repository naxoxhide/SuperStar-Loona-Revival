package b.b.a.a.d.e.b;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import b.b.a.a.k.g;
import com.bytedance.sdk.component.utils.m;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTDynamic.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    static Object a = new Object();

    /* JADX INFO: renamed from: b.b.a.a.d.e.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TTDynamic.java */
    static class C0025a extends g {
        final /* synthetic */ b.b.a.a.d.e.c.b c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0025a(String str, b.b.a.a.d.e.c.b bVar) {
            super(str);
            this.c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (a.a) {
                d.c().a(this.c);
            }
        }
    }

    public static void a() {
        try {
            f.a();
            File fileF = c.f();
            if (fileF != null && fileF.exists()) {
                if (fileF.getParentFile() != null) {
                    com.bytedance.sdk.component.utils.g.a(fileF.getParentFile());
                } else {
                    com.bytedance.sdk.component.utils.g.a(fileF);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static String b() {
        if (c() == null) {
            return null;
        }
        return c().a();
    }

    public static b.b.a.a.d.e.c.b c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b.b.a.a.d.e.c.b bVarB = e.b().b(str);
        if (bVarB != null) {
            bVarB.a(Long.valueOf(System.currentTimeMillis()));
            a(bVarB);
        }
        return bVarB;
    }

    public static String d() {
        return d.b();
    }

    public static void e() {
        c.d();
    }

    public static boolean f() {
        return c.d().h();
    }

    public static b.b.a.a.d.e.c.b d(String str) {
        return e.b().b(str);
    }

    public static Set<String> e(String str) {
        return e.b().c(str);
    }

    private static File b(String str) {
        if (!f()) {
            return null;
        }
        for (b.b.a.a.d.e.c.a.C0027a c0027a : c().d()) {
            if (c0027a.c() != null && c0027a.c().equals(str)) {
                File file = new File(c.f(), com.bytedance.sdk.component.utils.e.a(c0027a.c()));
                String strA = com.bytedance.sdk.component.utils.e.a(file);
                if (c0027a.b() == null || !c0027a.b().equals(strA)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    public static void a(b.b.a.a.d.e.c.c cVar) {
        e.b().a(cVar, cVar.f);
    }

    public static b.b.a.a.d.e.c.a c() {
        return c.d().e();
    }

    private static void a(b.b.a.a.d.e.c.b bVar) {
        b.b.a.a.k.e.b(new C0025a("updateTmplTime", bVar), 10);
    }

    public static WebResourceResponse a(String str, b.b.a.a.d.g.e.a aVar, String str2) {
        File fileA = a(str);
        if (fileA == null) {
            fileA = b(str);
        }
        if (fileA != null) {
            try {
                return new WebResourceResponse(aVar.b(), "utf-8", new FileInputStream(fileA));
            } catch (Throwable th) {
                m.b("TTDynamic", "get html WebResourceResponse error", th);
            }
        }
        return null;
    }

    private static File a(String str) {
        List<Pair<String, String>> listA;
        b.b.a.a.d.e.c.a.b bVarC = c().c();
        if (bVarC == null || (listA = bVarC.a()) == null || listA.size() <= 0) {
            return null;
        }
        for (Pair<String, String> pair : listA) {
            Object obj = pair.second;
            if (obj != null && ((String) obj).equals(str)) {
                return new File(c.f(), (String) pair.first);
            }
        }
        return null;
    }

    public static boolean a(JSONObject jSONObject) {
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(objOpt.toString())) ? false : true;
    }
}
