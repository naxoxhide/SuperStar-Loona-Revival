package b.b.a.a.d.d.f.a;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: AnimatorFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static volatile c a;

    private c() {
    }

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    public d a(View view, b.b.a.a.d.d.h.a aVar) {
        if (aVar == null) {
            return null;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).setClipChildren(false);
        }
        if (view.getParent().getParent() != null) {
            ((ViewGroup) view.getParent().getParent()).setClipChildren(false);
        }
        if ("scale".equals(aVar.s())) {
            return new j(view, aVar);
        }
        if ("translate".equals(aVar.s())) {
            return new n(view, aVar);
        }
        if ("ripple".equals(aVar.s())) {
            return new g(view, aVar);
        }
        if ("marquee".equals(aVar.s())) {
            return new f(view, aVar);
        }
        if ("waggle".equals(aVar.s())) {
            return new o(view, aVar);
        }
        if ("shine".equals(aVar.s())) {
            return new k(view, aVar);
        }
        if ("swing".equals(aVar.s())) {
            return new m(view, aVar);
        }
        if ("fade".equals(aVar.s())) {
            return new a(view, aVar);
        }
        if ("rubIn".equals(aVar.s())) {
            return new i(view, aVar);
        }
        if ("rotate".equals(aVar.s())) {
            return new h(view, aVar);
        }
        if ("cutIn".equals(aVar.s())) {
            return new e(view, aVar);
        }
        if ("stretch".equals(aVar.s())) {
            return new l(view, aVar);
        }
        return null;
    }
}
