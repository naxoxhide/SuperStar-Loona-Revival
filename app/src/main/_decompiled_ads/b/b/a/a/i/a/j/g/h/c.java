package b.b.a.a.i.a.j.g.h;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DBInsertMemRepo.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final List<b.b.a.a.i.a.m.a> f210b = new ArrayList();
    private boolean c = false;
    private Runnable d = new a();

    /* JADX INFO: compiled from: DBInsertMemRepo.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList;
            synchronized (c.this) {
                arrayList = new ArrayList(c.this.f210b);
                c.this.f210b.clear();
                c.this.c = false;
            }
            c.this.b(arrayList);
        }
    }

    public c(Context context) {
        this.a = context;
    }

    private void c() {
        if (this.c) {
            return;
        }
        b.b.a.a.i.a.p.a.a().postDelayed(this.d, b.b.a.a.i.a.p.a.b());
        this.c = true;
    }

    public abstract String b();

    public void b(List<b.b.a.a.i.a.m.a> list) {
        b.b.a.a.i.a.j.g.c.a(a(), b(), list);
    }

    protected void a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<b.b.a.a.i.a.m.a> it = this.f210b.iterator();
            while (it.hasNext()) {
                b.b.a.a.i.a.m.a next = it.next();
                if (next != null) {
                    String strI = next.i();
                    if (!TextUtils.isEmpty(strI) && list.contains(strI)) {
                        it.remove();
                    }
                }
            }
        } catch (Throwable th) {
            b.b.a.a.i.a.l.c.b("DBInsertMemRepo", b() + "deleteMemList: " + th.getMessage());
        }
    }

    public synchronized void a(b.b.a.a.i.a.m.a aVar) {
        if (aVar.b() != null && !TextUtils.isEmpty(aVar.i())) {
            this.f210b.add(aVar);
            c();
        }
    }

    public Context a() {
        return this.a;
    }
}
