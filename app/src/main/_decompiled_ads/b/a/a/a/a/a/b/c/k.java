package b.a.a.a.a.a.b.c;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: Urls.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    private static final Set<String> f = new HashSet();
    private static final Set<String> g = new HashSet();
    private final ArrayList<a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f47b;
    private int c = -1;
    private int d;
    private final int e;

    /* JADX INFO: compiled from: Urls.java */
    public class a {
        final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f48b;

        a(k kVar, String str) {
            this.a = str;
        }

        void a() {
            k.f.add(this.a);
        }

        void b() {
            k.g.add(this.a);
        }

        public String toString() {
            return this.a;
        }
    }

    k(List<String> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("urls can't be empty");
        }
        int size = list.size();
        this.f47b = size;
        this.a = new ArrayList<>(size);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (String str : list) {
            a aVar = new a(this, str);
            if (f.contains(str)) {
                arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList2.add(aVar);
            } else if (g.contains(str)) {
                arrayList = arrayList == null ? new ArrayList() : arrayList;
                arrayList.add(aVar);
            } else {
                this.a.add(aVar);
            }
        }
        if (arrayList != null) {
            this.a.addAll(arrayList);
        }
        if (arrayList2 != null) {
            this.a.addAll(arrayList2);
        }
        Integer num = e.k;
        int iIntValue = 2;
        if (num != null && num.intValue() > 0) {
            iIntValue = num.intValue();
        } else if (this.f47b >= 2) {
            iIntValue = 1;
        }
        this.e = iIntValue;
    }

    boolean c() {
        return this.d < this.e;
    }

    a d() {
        if (!c()) {
            throw new NoSuchElementException();
        }
        int i = this.c + 1;
        if (i >= this.f47b - 1) {
            this.c = -1;
            this.d++;
        } else {
            this.c = i;
        }
        a aVar = this.a.get(i);
        aVar.f48b = (this.d * this.f47b) + this.c;
        return aVar;
    }

    k(String str) {
        ArrayList<a> arrayList = new ArrayList<>(1);
        this.a = arrayList;
        arrayList.add(new a(this, str));
        this.f47b = 1;
        this.e = 1;
    }
}
