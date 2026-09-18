package b.b.a.a.i.a.j;

import android.text.TextUtils;
import b.b.a.a.i.a.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: CacheManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends a {
    private final d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f203b;
    private final Queue<String> c;

    public b() {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.c = concurrentLinkedQueue;
        this.a = new f(concurrentLinkedQueue);
        this.f203b = new c();
    }

    @Override // b.b.a.a.i.a.j.d
    public synchronized void a(b.b.a.a.i.a.m.a aVar, int i) {
        d dVar;
        c cVar;
        if (i != 5) {
            if (i.f().a().a(i.f().c()) && (dVar = this.a) != null && aVar != null) {
                dVar.a(aVar, i);
            }
            cVar = this.f203b;
            if (cVar != null && aVar != null) {
                cVar.a(aVar, i);
            }
        } else {
            cVar = this.f203b;
            if (cVar != null) {
                cVar.a(aVar, i);
            }
        }
        throw th;
    }

    @Override // b.b.a.a.i.a.j.d
    public synchronized void a(int i, List<b.b.a.a.i.a.m.a> list) {
        Iterator<b.b.a.a.i.a.m.a> it = list.iterator();
        while (it.hasNext()) {
            this.c.remove(it.next().i());
        }
        d dVar = this.a;
        if (dVar != null) {
            dVar.a(i, list);
        }
        c cVar = this.f203b;
        if (cVar != null) {
            cVar.a(i, list);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.b.a.a.i.a.j.d
    public synchronized List<b.b.a.a.i.a.m.a> a(int i, int i2, List<String> list) {
        List<b.b.a.a.i.a.m.a> listB;
        boolean z;
        List<b.b.a.a.i.a.m.a> listA = this.a.a(i, i2, list);
        if (listA != 0 && listA.size() != 0) {
            b.b.a.a.i.a.l.c.a("memory get " + listA.size());
            if ((i == 1 || i == 2) && (listB = this.f203b.b((b.b.a.a.i.a.m.a) listA.get(0), listA.size())) != null && listB.size() != 0) {
                b.b.a.a.i.a.l.c.a("db get " + listB.size());
                HashMap map = new HashMap();
                for (b.b.a.a.i.a.m.a aVar : listB) {
                    map.put(aVar.i(), aVar);
                }
                ArrayList arrayList = new ArrayList(this.c);
                for (b.b.a.a.i.a.m.a aVar2 : listB) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        if (TextUtils.equals(aVar2.i(), (String) it.next())) {
                            b.b.a.a.i.a.l.c.a(" duplicate delete ");
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        map.remove(aVar2.i());
                    }
                }
                for (b.b.a.a.i.a.m.a aVar3 : listA) {
                    map.put(aVar3.i(), aVar3);
                }
                listA.clear();
                Iterator it2 = map.keySet().iterator();
                while (it2.hasNext()) {
                    listA.add(map.get((String) it2.next()));
                }
            }
        } else {
            ArrayList<String> arrayList2 = new ArrayList(this.c);
            if (list != null && !list.isEmpty()) {
                arrayList2.addAll(list);
            }
            List<b.b.a.a.i.a.m.a> listA2 = this.f203b.a(i, i2, arrayList2);
            if (listA2 != 0 && listA2.size() != 0) {
                HashMap map2 = new HashMap();
                for (b.b.a.a.i.a.m.a aVar4 : listA2) {
                    map2.put(aVar4.i(), aVar4);
                }
                b.b.a.a.i.a.l.c.a("allSendingQueue:" + arrayList2.size());
                if (arrayList2.size() != 0) {
                    for (String str : arrayList2) {
                        if (map2.get(str) != null) {
                            b.b.a.a.i.a.l.c.a("db duplicate delete");
                            map2.remove(str);
                        }
                    }
                }
                listA2.clear();
                Iterator it3 = map2.keySet().iterator();
                while (it3.hasNext()) {
                    listA2.add(map2.get((String) it3.next()));
                }
            }
            listA = listA2;
        }
        if (listA != 0 && !listA.isEmpty()) {
            Iterator it4 = listA.iterator();
            while (it4.hasNext()) {
                this.c.offer(((b.b.a.a.i.a.m.a) it4.next()).i());
            }
            return listA;
        }
        return new ArrayList();
    }

    @Override // b.b.a.a.i.a.j.d
    public synchronized boolean a(int i, boolean z) {
        if (this.a.a(i, z)) {
            b.b.a.a.i.a.l.c.d("memory meet");
            b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.E(), 1);
            return true;
        }
        if ((i != 1 && i != 2) || !this.f203b.a(i, z)) {
            return false;
        }
        b.b.a.a.i.a.l.c.d("db meet");
        b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.s(), 1);
        return true;
    }
}
