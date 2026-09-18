package b.b.a.a.h.y;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DuplicateRequestCheckVisitor.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends a {
    @Override // b.b.a.a.h.y.i
    public String a() {
        return "check_duplicate";
    }

    @Override // b.b.a.a.h.y.i
    public void a(b.b.a.a.h.x.c cVar) {
        List<b.b.a.a.h.x.c> linkedList;
        String strP = cVar.p();
        Map<String, List<b.b.a.a.h.x.c>> mapG = cVar.h().g();
        synchronized (mapG) {
            linkedList = mapG.get(strP);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
            }
        }
        synchronized (linkedList) {
            linkedList.add(cVar);
            mapG.put(strP, linkedList);
            if (linkedList.size() <= 1) {
                cVar.a(new d());
            }
        }
    }
}
