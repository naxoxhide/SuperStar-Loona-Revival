package b.b.a.a.k.i;

import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.y;

/* JADX INFO: compiled from: HandlerPool.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private final d<b.b.a.a.k.i.b> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private y f253b;

    /* JADX INFO: compiled from: HandlerPool.java */
    private static class b {
        private static final a a = new a();
    }

    public static a a() {
        return b.a;
    }

    public y b() {
        if (this.f253b == null) {
            synchronized (a.class) {
                if (this.f253b == null) {
                    this.f253b = a("csj_io_handler");
                }
            }
        }
        return this.f253b;
    }

    private a() {
        this.a = d.a(2);
    }

    public y a(String str) {
        return b(null, str);
    }

    private b.b.a.a.k.i.b a(y.a aVar, String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        return new b.b.a.a.k.i.b(handlerThread, aVar);
    }

    public boolean a(y yVar) {
        if (!(yVar instanceof b.b.a.a.k.i.b)) {
            return false;
        }
        b.b.a.a.k.i.b bVar = (b.b.a.a.k.i.b) yVar;
        if (this.a.a(bVar)) {
            return true;
        }
        bVar.b();
        return true;
    }

    public y b(y.a aVar, String str) {
        b.b.a.a.k.i.b bVar = (b.b.a.a.k.i.b) this.a.a();
        if (bVar != null) {
            bVar.a(aVar);
            bVar.a(str);
            return bVar;
        }
        return a(aVar, str);
    }
}
