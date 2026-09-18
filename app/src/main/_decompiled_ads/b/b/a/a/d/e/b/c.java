package b.b.a.a.d.e.b;

import android.text.TextUtils;
import android.util.Pair;
import b.b.a.a.k.g;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.component.utils.z;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: TemplateManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static File g;
    private static volatile c h;
    private AtomicBoolean a = new AtomicBoolean(true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f104b = new AtomicBoolean(false);
    private boolean c = false;
    private AtomicBoolean d = new AtomicBoolean(false);
    private AtomicInteger e = new AtomicInteger(0);
    private AtomicLong f = new AtomicLong();

    /* JADX INFO: compiled from: TemplateManager.java */
    class a extends g {

        /* JADX INFO: renamed from: b.b.a.a.d.e.b.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TemplateManager.java */
        class RunnableC0026a implements Runnable {
            RunnableC0026a(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.b.a.a.d.e.a.a.d().b() != null) {
                    b.b.a.a.d.e.a.a.d().b().i();
                }
            }
        }

        a(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            f.c();
            c.this.a.set(false);
            c.this.a();
            c.this.i();
            if (b.b.a.a.d.e.a.a.d().b() == null || !r.c(b.b.a.a.d.e.a.a.d().b().e())) {
                return;
            }
            b.b.a.a.d.e.a.a.d().b().j().post(new RunnableC0026a(this));
        }
    }

    /* JADX INFO: compiled from: TemplateManager.java */
    class b implements Runnable {
        b(c cVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.b.a.a.d.h.e.e().d();
        }
    }

    private c() {
        g();
    }

    private boolean c(List<b.b.a.a.d.e.c.a.C0027a> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (b.b.a.a.d.e.c.a.C0027a c0027a : list) {
            File file = new File(f(), com.bytedance.sdk.component.utils.e.a(c0027a.c()));
            String strA = com.bytedance.sdk.component.utils.e.a(file);
            if (!file.exists() || !file.isFile() || c0027a.b() == null || !c0027a.b().equals(strA)) {
                return false;
            }
        }
        return true;
    }

    public static c d() {
        if (h == null) {
            synchronized (c.class) {
                if (h == null) {
                    h = new c();
                }
            }
        }
        return h;
    }

    public static File f() {
        if (g == null) {
            try {
                File file = new File(new File(b.b.a.a.d.e.b.b.a(), "tt_tmpl_pkg"), "template");
                file.mkdirs();
                g = file;
            } catch (Throwable th) {
                m.b("TemplateManager", "getTemplateDir error", th);
            }
        }
        return g;
    }

    private void g() {
        b.b.a.a.k.e.d(new a("init"));
    }

    public b.b.a.a.d.e.c.a e() {
        return f.b();
    }

    public boolean h() {
        return this.c;
    }

    public void i() {
        a(false);
    }

    public void j() {
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        m.a("TemplateManager", "check template usable1");
        b.b.a.a.d.e.c.a aVarB = f.b();
        if (aVarB == null || !aVarB.f()) {
            m.a("TemplateManager", "check template usable2");
            return;
        }
        boolean z = a(aVarB.c()) || c(aVarB.d());
        if (!z) {
            f.a();
        }
        m.a("TemplateManager", "check template usable4: " + z);
        this.c = z;
    }

    private void b(List<b.b.a.a.d.e.c.a.C0027a> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<b.b.a.a.d.e.c.a.C0027a> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(f(), com.bytedance.sdk.component.utils.e.a(it.next().c()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    private void c() {
        if (this.e.getAndSet(0) <= 0 || System.currentTimeMillis() - this.f.get() <= 600000) {
            return;
        }
        i();
    }

    private boolean a(b.b.a.a.d.e.c.a.b bVar) {
        if (bVar == null) {
            return false;
        }
        List<Pair<String, String>> listA = bVar.a();
        if (listA == null || listA.size() <= 0) {
            return true;
        }
        Iterator<Pair<String, String>> it = listA.iterator();
        while (it.hasNext()) {
            File file = new File(f(), (String) it.next().first);
            if (!file.exists() || !file.isFile()) {
                return false;
            }
        }
        return true;
    }

    public void b(boolean z) {
        this.d.set(z);
    }

    public void b() {
        this.d.set(true);
        this.c = false;
        this.f104b.set(false);
    }

    public void a(boolean z) {
        if (this.a.get()) {
            m.a("TemplateManager", "loadTemplate error1");
            return;
        }
        try {
            if (this.f104b.get()) {
                if (z) {
                    this.e.getAndIncrement();
                }
                m.a("TemplateManager", "loadTemplate error2: " + z);
                return;
            }
            boolean z2 = true;
            this.f104b.set(true);
            b.b.a.a.d.e.c.a aVarA = b.b.a.a.d.e.a.a.d().b().a();
            b.b.a.a.d.e.c.a aVarB = f.b();
            if (aVarA != null && aVarA.f()) {
                boolean zB = f.b(aVarA.e());
                if (!zB) {
                    this.f104b.set(false);
                    this.f.set(System.currentTimeMillis());
                    m.a("TemplateManager", "loadTemplate error4");
                    return;
                }
                if (zB && b.b.a.a.d.e.a.a.d().b() != null) {
                    b.b.a.a.d.e.a.a.d().b().j().post(new b(this));
                }
                boolean zA = (aVarA.c() == null || TextUtils.isEmpty(aVarA.c().b())) ? false : a(aVarA.c().b());
                List<b.b.a.a.d.e.c.a.C0027a> listA = null;
                if (zA) {
                    z2 = zA;
                } else {
                    listA = a(aVarA, aVarB);
                    if (listA == null) {
                        z2 = false;
                    }
                }
                if (z2 && aVarA != null && (c(aVarA.d()) || a(aVarA.c()))) {
                    f.a(aVarA);
                    f.d();
                    b(listA);
                }
                m.a("TemplateManager", "loadTemplate update success: " + aVarA.e());
                a();
                this.f104b.set(false);
                this.f.set(System.currentTimeMillis());
                c();
                return;
            }
            this.f104b.set(false);
            a(109);
            m.a("TemplateManager", "loadTemplate error3");
        } catch (Throwable th) {
            m.a("TemplateManager", "loadTemplate error: ", th);
        }
    }

    private List<b.b.a.a.d.e.c.a.C0027a> a(b.b.a.a.d.e.c.a aVar, b.b.a.a.d.e.c.a aVar2) {
        int iB;
        String strF;
        ArrayList arrayList = new ArrayList();
        ArrayList<b.b.a.a.d.e.c.a.C0027a> arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (aVar2 != null && !aVar2.d().isEmpty()) {
            if (aVar.d().isEmpty()) {
                arrayList.addAll(aVar2.d());
                m.a("TemplateManager", "loadTemplate update2");
            } else {
                for (b.b.a.a.d.e.c.a.C0027a c0027a : aVar.d()) {
                    if (!aVar2.d().contains(c0027a)) {
                        arrayList2.add(c0027a);
                    } else {
                        b.b.a.a.d.e.c.a.C0027a c0027aA = f.a(c0027a.c());
                        if (c0027aA != null && c0027a.b() != null && !c0027a.b().equals(c0027aA.b())) {
                            arrayList2.add(c0027a);
                        }
                    }
                }
                for (b.b.a.a.d.e.c.a.C0027a c0027a2 : aVar2.d()) {
                    if (!aVar.d().contains(c0027a2)) {
                        arrayList.add(c0027a2);
                    }
                }
                m.a("TemplateManager", "loadTemplate update3");
            }
        } else {
            arrayList2.addAll(aVar.d());
            m.a("TemplateManager", "loadTemplate update1");
        }
        for (b.b.a.a.d.e.c.a.C0027a c0027a3 : arrayList2) {
            String strC = c0027a3.c();
            String strA = com.bytedance.sdk.component.utils.e.a(strC);
            File file = new File(f(), strA);
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
            b.b.a.a.j.d.a aVarG = b.b.a.a.d.e.a.a.d().b().g();
            aVarG.b(strC);
            aVarG.b(f().getAbsolutePath(), strA);
            b.b.a.a.j.b bVarC = aVarG.c();
            arrayList3.add(c0027a3);
            if (bVarC != null && bVarC.g() && bVarC.d() != null && bVarC.d().exists()) {
                m.a("TemplateManager", "loadTemplate success");
            } else {
                if (bVarC == null) {
                    iB = -1;
                    strF = "response is null";
                } else {
                    try {
                        if (bVarC.d() == null || !bVarC.d().exists()) {
                            iB = -2;
                            strF = "file is null";
                        } else {
                            iB = bVarC.b();
                            strF = bVarC.f();
                        }
                    } catch (Throwable th) {
                        m.b("TemplateManager", th);
                    }
                }
                a(iB, strF);
                this.f104b.set(false);
                a(arrayList3);
                m.a("TemplateManager", "loadTemplate error5");
                return null;
            }
        }
        return arrayList;
    }

    private boolean a(String str) {
        File file = new File(f().getAbsoluteFile(), com.bytedance.sdk.component.utils.e.a(str) + ".zip");
        b.b.a.a.j.d.a aVarG = b.b.a.a.d.e.a.a.d().b().g();
        aVarG.b(str);
        aVarG.b(file.getParent(), file.getName());
        b.b.a.a.j.b bVarC = aVarG.c();
        if (bVarC.g() && bVarC.d() != null && bVarC.d().exists()) {
            File fileD = bVarC.d();
            try {
                z.a(fileD.getAbsolutePath(), file.getParent());
                if (!fileD.exists()) {
                    return true;
                }
                fileD.delete();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private void a(int i) {
        if (b.b.a.a.d.e.a.a.d().e() != null) {
            b.b.a.a.d.e.a.a.d().e().a(i);
        }
    }

    private void a(int i, String str) {
        if (b.b.a.a.d.e.a.a.d().e() != null) {
            b.b.a.a.d.e.a.a.d().e().a(i, str);
        }
    }

    private void a(List<b.b.a.a.d.e.c.a.C0027a> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<b.b.a.a.d.e.c.a.C0027a> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(f(), com.bytedance.sdk.component.utils.e.a(it.next().c()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }
}
