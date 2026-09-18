package b.a.a.a.a.a.b.b.c;

import android.content.Context;
import android.os.Build;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: VideoFileManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static final ConcurrentHashMap<String, b> a = new ConcurrentHashMap<>();

    public static synchronized void a(Context context, b.a.a.a.a.a.a.f.c cVar, b.a.a.a.a.a.a.h.a.InterfaceC0009a interfaceC0009a) {
        try {
            if (cVar == null) {
                b.a.a.a.a.a.a.i.c.b(" url、dir and hash is must property   in VideoInfoModel");
                return;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                ConcurrentHashMap<String, b> concurrentHashMap = a;
                b bVar = concurrentHashMap.get(cVar.e());
                if (bVar == null) {
                    bVar = new b(context, cVar);
                    concurrentHashMap.put(cVar.e(), bVar);
                    b.a.a.a.a.a.a.i.c.b("VideoFileManager", "preloadVideo:  cache size = ", Integer.valueOf(cVar.j()), cVar.e());
                }
                bVar.a(interfaceC0009a);
            }
            b.a.a.a.a.a.a.i.c.b("VideoFileManager", "preloadVideo:  cache size = ", Integer.valueOf(cVar.j()), cVar.e());
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void a(b.a.a.a.a.a.a.f.c cVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            b bVarRemove = a.remove(cVar.e());
            if (bVarRemove != null) {
                bVarRemove.a(true);
            }
            b.a.a.a.a.a.a.i.c.b("VideoFileManager", "removePreload:  cache size = ", Integer.valueOf(cVar.j()), cVar.e());
        }
    }
}
