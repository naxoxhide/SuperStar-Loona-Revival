package b.b.a.a.e;

import android.net.Uri;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: PermissionChecker.java */
/* JADX INFO: loaded from: classes.dex */
class u {
    private final Set<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f139b;
    private final w c;
    private final v d;
    private k e;

    u(v vVar, Set<String> set, Set<String> set2) {
        if (set == null || set.isEmpty()) {
            this.a = new LinkedHashSet();
        } else {
            this.a = new LinkedHashSet(set);
        }
        if (set2 == null || set2.isEmpty()) {
            this.f139b = new LinkedHashSet();
        } else {
            this.f139b = new LinkedHashSet(set2);
        }
    }

    final synchronized x a(boolean z, String str, b bVar) throws v.a {
        k kVar;
        Uri uri = Uri.parse(str);
        String host = uri.getHost();
        if (host == null) {
            return null;
        }
        x xVar = this.f139b.contains(bVar.a()) ? x.PUBLIC : null;
        for (String str2 : this.a) {
            if (uri.getHost().equals(str2) || host.endsWith("." + str2)) {
                xVar = x.PRIVATE;
                break;
            }
        }
        if (xVar == null && (kVar = this.e) != null && kVar.a(str)) {
            if (this.e.a(str, bVar.a())) {
                return null;
            }
            xVar = x.PRIVATE;
        }
        x xVarA = z ? a(str, bVar) : b(str, bVar);
        return xVarA != null ? xVarA : xVar;
    }

    final synchronized x b(String str, b bVar) {
        return a(str, bVar, false);
    }

    void b(w.a aVar) {
        w wVar = this.c;
        if (wVar == null) {
            return;
        }
        wVar.b(aVar);
        throw null;
    }

    final synchronized x a(String str, b bVar) throws v.a {
        return a(str, bVar, true);
    }

    void a(k kVar) {
        this.e = kVar;
    }

    void a(w.a aVar) {
        w wVar = this.c;
        if (wVar == null) {
            return;
        }
        wVar.a(aVar);
        throw null;
    }

    private x a(String str, b bVar, boolean z) {
        v vVar;
        if (!z || (vVar = this.d) == null) {
            return null;
        }
        vVar.a(str, this.a);
        throw null;
    }
}
