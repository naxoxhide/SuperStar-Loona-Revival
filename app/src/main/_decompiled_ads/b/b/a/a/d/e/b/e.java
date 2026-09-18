package b.b.a.a.d.e.b;

import android.text.TextUtils;
import b.b.a.a.k.g;
import com.bytedance.sdk.component.utils.m;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: TmplDiffManager.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile e f106b;
    private AtomicBoolean a = new AtomicBoolean(false);

    /* JADX INFO: compiled from: TmplDiffManager.java */
    class a extends g {
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;
        final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            super(str);
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = str6;
            this.h = str7;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a(this.c, this.d, this.e, this.f, this.g, this.h);
        }
    }

    private e() {
    }

    public static e b() {
        if (f106b == null) {
            synchronized (e.class) {
                if (f106b == null) {
                    f106b = new e();
                }
            }
        }
        return f106b;
    }

    public Set<String> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return d.c().b(str);
    }

    private void a() {
        if (b.b.a.a.d.e.a.a.d().b() == null) {
            return;
        }
        int iC = b.b.a.a.d.e.a.a.d().b().c();
        if (iC <= 0) {
            iC = 100;
        }
        List<b.b.a.a.d.e.c.b> listA = d.c().a();
        if (listA == null || listA.isEmpty() || iC >= listA.size()) {
            m.a("TmplDiffManager", "end doCheckAndDeleteTask maxTplCnt,local size" + iC + ", Number of templates currently stored" + (listA != null ? listA.size() : 0));
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (b.b.a.a.d.e.c.b bVar : listA) {
            treeMap.put(bVar.e(), bVar);
        }
        HashSet hashSet = new HashSet();
        int size = (int) (listA.size() - (iC * 0.75f));
        int i = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i < size) {
                i++;
                ((Long) entry.getKey()).longValue();
                b.b.a.a.d.e.c.b bVar2 = (b.b.a.a.d.e.c.b) entry.getValue();
                if (bVar2 != null) {
                    hashSet.add(bVar2.b());
                }
            }
        }
        a(hashSet);
        this.a.set(false);
    }

    public b.b.a.a.d.e.c.b b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return d.c().a(str);
    }

    private void b(String str, String str2, String str3, String str4, String str5, String str6) {
        d.c().a(new b.b.a.a.d.e.c.b().d(str).b(str2).c(str3).e(str4).a(str5).f(str6).a(Long.valueOf(System.currentTimeMillis())));
        a();
    }

    private JSONObject a(String str) {
        if (b.b.a.a.d.e.a.a.d().b() == null) {
            return null;
        }
        b.b.a.a.j.d.b bVarD = b.b.a.a.d.e.a.a.d().b().d();
        bVarD.b(str);
        b.b.a.a.j.b bVarB = bVarD.b();
        if (bVarB != null) {
            try {
                if (bVarB.g() && bVarB.a() != null) {
                    return new JSONObject(bVarB.a());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void a(b.b.a.a.d.e.c.c cVar, String str) {
        if (cVar == null) {
            m.b("TmplDiffManager", "saveTemplate error: tplInfo == null");
            return;
        }
        String str2 = cVar.a;
        String str3 = cVar.c;
        String str4 = cVar.f111b;
        String str5 = cVar.d;
        String str6 = cVar.e;
        String appId = TextUtils.isEmpty(str) ? b.b.a.a.d.e.a.a.d().b() != null ? b.b.a.a.d.e.a.a.d().b().getAppId() : "" : str;
        if (TextUtils.isEmpty(str2)) {
            m.b("TmplDiffManager", "saveTemplate error:tmpId is empty");
        } else {
            b.b.a.a.k.e.b(new a("saveTemplate", str2, str3, str4, str5, str6, appId), 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, String str2, String str3, String str4, String str5, String str6) {
        if (b(str) != null) {
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                b(str6, str, str3, str2, str4, str5);
            }
            return;
        } else if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            a(str2, str6, str);
        } else {
            b(str6, str, str3, str2, str4, str5);
        }
        boolean zB = f.b(str5);
        if (!b.b.a.a.d.e.b.a.f() || zB) {
            c.d().a(true);
        }
    }

    private void a(String str, String str2, String str3) {
        JSONObject jSONObjectA;
        if (TextUtils.isEmpty(str) || (jSONObjectA = a(str)) == null) {
            return;
        }
        String strOptString = jSONObjectA.optString("md5");
        String strOptString2 = jSONObjectA.optString("version");
        String strOptString3 = jSONObjectA.optString("data");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3)) {
            return;
        }
        b.b.a.a.d.e.c.b bVarA = new b.b.a.a.d.e.c.b().d(str2).b(str3).c(strOptString).e(str).a(strOptString3).f(strOptString2).a(Long.valueOf(System.currentTimeMillis()));
        d.c().a(bVarA);
        a();
        if (f.b(strOptString2)) {
            bVarA.f(strOptString2);
            c.d().a(true);
        }
    }

    public void a(Set<String> set) {
        try {
            d.c().a(set);
        } catch (Throwable th) {
            m.a("TmplDiffManager", th.getMessage());
        }
    }
}
