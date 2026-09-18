package com.tapjoy.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b4 implements Closeable {
    public HashMap a;

    public static d4 a(String str) {
        if (c4.a == null) {
            c4.a = d4.p;
        }
        return new d4(new StringReader(str));
    }

    public abstract void a();

    public abstract void b();

    public abstract boolean c();

    public final boolean d() {
        return q() == 1;
    }

    public final boolean e() {
        return q() == 3;
    }

    public final boolean f() {
        return q() == 6;
    }

    public abstract boolean g();

    public abstract double h();

    public abstract int i();

    public final LinkedList j() throws IOException {
        LinkedList linkedList = new LinkedList();
        d4 d4Var = (d4) this;
        d4Var.a(1);
        while (c()) {
            linkedList.add(p());
        }
        d4Var.a(2);
        return linkedList;
    }

    public final LinkedHashMap k() throws IOException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        d4 d4Var = (d4) this;
        d4Var.a(3);
        while (c()) {
            linkedHashMap.put(l(), p());
        }
        d4Var.a(4);
        return linkedHashMap;
    }

    public abstract String l();

    public abstract String m();

    public final String n() {
        if (s()) {
            return null;
        }
        return m();
    }

    public final Object p() throws IOException {
        int iQ = q();
        int iB = k.b(iQ);
        if (iB == 0) {
            return j();
        }
        if (iB == 2) {
            return k();
        }
        if (iB == 5) {
            return m();
        }
        if (iB == 6) {
            return new j7(m());
        }
        if (iB == 7) {
            return Boolean.valueOf(g());
        }
        if (iB != 8) {
            throw new IllegalStateException("Expected a value but was ".concat(f4.a(iQ)));
        }
        d4 d4Var = (d4) this;
        d4Var.q();
        if (d4Var.j != 9) {
            throw new IllegalStateException("Expected null but was ".concat(f4.a(d4Var.j)));
        }
        d4Var.t();
        return null;
    }

    public abstract int q();

    public abstract void r();

    public final boolean s() throws IOException {
        if (q() != 9) {
            return false;
        }
        d4 d4Var = (d4) this;
        d4Var.q();
        if (d4Var.j != 9) {
            throw new IllegalStateException("Expected null but was ".concat(f4.a(d4Var.j)));
        }
        d4Var.t();
        return true;
    }

    public final URL o() throws o4 {
        HashMap map = this.a;
        URI uri = (URI) (map != null ? map.get("BASE_URI") : null);
        if (uri == null) {
            return new URL(m());
        }
        try {
            return uri.resolve(new URI(m())).toURL();
        } catch (URISyntaxException e) {
            throw new o4(e);
        }
    }

    public final Object a(x3 x3Var) {
        return x3Var.a(this);
    }

    public final void a(ArrayList arrayList, x3 x3Var) throws IOException {
        d4 d4Var = (d4) this;
        d4Var.a(1);
        while (c()) {
            arrayList.add(x3Var.a(this));
        }
        d4Var.a(2);
    }
}
