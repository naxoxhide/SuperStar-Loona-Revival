package com.bytedance.sdk.openadsdk.h;

import android.content.Context;
import b.b.a.a.f.a.f;
import b.b.a.a.f.a.j;
import b.b.a.a.f.a.l;
import b.b.a.a.h.n;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.x;
import com.bytedance.sdk.openadsdk.utils.y;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: ImageLoaderWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: compiled from: ImageLoaderWrapper.java */
    private static final class a {
        private static n a = a(o.a());

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.h.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ImageLoaderWrapper.java */
        static class C0237a implements b.b.a.a.h.d {
            C0237a() {
            }

            @Override // b.b.a.a.h.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public b.b.a.a.h.w.d a(b.b.a.a.h.e eVar) {
                j jVarC = com.bytedance.sdk.openadsdk.n.c.b().d().c();
                l lVarA = new l.a().a(eVar.a()).b().a();
                b.b.a.a.f.a.n nVarB = null;
                b.b.a.a.h.w.e eVar2 = eVar.b() ? new b.b.a.a.h.w.e() : null;
                if (eVar2 != null) {
                    eVar2.c(System.currentTimeMillis());
                }
                try {
                    nVarB = jVarC.a(lVarA).b();
                    if (eVar2 != null) {
                        eVar2.b(System.currentTimeMillis());
                    }
                    Map<String, String> mapA = a(eVar, nVarB);
                    byte[] bArrB = nVarB.a().b();
                    if (eVar2 != null) {
                        eVar2.a(System.currentTimeMillis());
                    }
                    b.b.a.a.h.w.d dVar = new b.b.a.a.h.w.d(nVarB.b(), bArrB, "", mapA);
                    dVar.a(eVar2);
                    b.b.a.a.h.x.k.b.a(nVarB);
                    return dVar;
                } catch (Throwable th) {
                    try {
                        return a(eVar2, th);
                    } finally {
                        b.b.a.a.h.x.k.b.a(nVarB);
                    }
                }
            }

            private Map<String, String> a(b.b.a.a.h.e eVar, b.b.a.a.f.a.n nVar) {
                if (!eVar.c()) {
                    return null;
                }
                f fVarC = nVar.c();
                HashMap map = new HashMap();
                int iA = fVarC.a();
                for (int i = 0; i < iA; i++) {
                    String strA = fVarC.a(i);
                    String strB = fVarC.b(i);
                    if (strA != null) {
                        map.put(strA, strB);
                    }
                }
                return map;
            }

            private b.b.a.a.h.w.d a(b.b.a.a.h.w.e eVar, Throwable th) {
                m.f("ImageLoaderWrapper", th.getMessage());
                if (eVar != null) {
                    eVar.a(System.currentTimeMillis());
                }
                b.b.a.a.h.w.d dVar = new b.b.a.a.h.w.d(98765, th, "net failed");
                dVar.a(eVar);
                return dVar;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b.b.a.a.h.j b(String str) {
            return a(a.a(str).d(b0.g(o.a())).c(b0.i(o.a())));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b.b.a.a.h.j b(com.bytedance.sdk.openadsdk.core.f0.n nVar) {
            return a(a.a(nVar.d()).b(nVar.e()).a(nVar.b()).d(b0.g(o.a())).c(b0.i(o.a())).a(nVar.c()));
        }

        private static n a(Context context) {
            return b.b.a.a.h.x.b.a(context, new b.b.a.a.h.x.e.b().a(new b.b.a.a.h.x.i.a(Math.max(Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 83886080), 10485760), 41943040L, new File(CacheDirFactory.getImageCacheDir()))).a(y.a()).a(new C0237a()).a());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static InputStream b(String str, String str2) {
            return a.a(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean b(String str, String str2, String str3) {
            return a.a(str, str2, str3);
        }

        private static b.b.a.a.h.j a(b.b.a.a.h.j jVar) {
            return x.b() ? jVar.a(new e()) : jVar;
        }
    }

    public static b.b.a.a.h.j a(String str) {
        return a.b(str);
    }

    public static b.b.a.a.h.j a(com.bytedance.sdk.openadsdk.core.f0.n nVar) {
        return a.b(nVar);
    }

    public static InputStream a(String str, String str2) {
        return a.b(str, str2);
    }

    public static boolean a(String str, String str2, String str3) {
        return a.b(str, str2, str3);
    }

    public static n a() {
        return a.a;
    }
}
