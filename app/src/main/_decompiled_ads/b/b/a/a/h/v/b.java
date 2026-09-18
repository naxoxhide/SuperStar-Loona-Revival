package b.b.a.a.h.v;

import b.b.a.a.h.i;
import b.b.a.a.h.l;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: KeyGeneratorFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static l a() {
        return new a();
    }

    /* JADX INFO: compiled from: KeyGeneratorFactory.java */
    static class a implements l {
        private WeakHashMap<String, String> a = new WeakHashMap<>();

        a() {
        }

        @Override // b.b.a.a.h.l
        public String a(i iVar) {
            return a(iVar.a() + "#width=" + iVar.b() + "#height=" + iVar.c() + "#scaletype=" + iVar.d());
        }

        @Override // b.b.a.a.h.l
        public String b(i iVar) {
            return a(iVar.a());
        }

        private String a(String str) {
            String str2 = this.a.get(str);
            if (str2 != null) {
                return str2;
            }
            String strA = b.b.a.a.h.x.k.c.a(str);
            this.a.put(str, strA);
            return strA;
        }
    }
}
