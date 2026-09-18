package b.b.a.a.i.a.l;

import b.b.a.a.i.a.f;
import b.b.a.a.i.a.i;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: EventMonitorUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(AtomicLong atomicLong, int i) {
        f fVarA = i.f().a();
        if (fVarA == null || !fVarA.e() || atomicLong == null) {
            return;
        }
        atomicLong.getAndAdd(i);
    }
}
