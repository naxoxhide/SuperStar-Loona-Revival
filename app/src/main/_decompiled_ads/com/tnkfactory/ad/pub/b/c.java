package com.tnkfactory.ad.pub.b;

import android.content.Context;
import com.tnkfactory.ad.pub.a.u;

/* JADX INFO: loaded from: classes4.dex */
public class c extends com.tnkfactory.ad.pub.b.a {

    public final class a implements q {
        public a() {
        }
    }

    public final class b extends r {
        public Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public r f2902b;

        public class a implements com.tnkfactory.ad.pub.a.j.d {
            public final /* synthetic */ com.tnkfactory.ad.pub.a a;

            public a(com.tnkfactory.ad.pub.a aVar) {
                this.a = aVar;
            }

            @Override // com.tnkfactory.ad.pub.a.j.d
            public final void a() {
                com.tnkfactory.ad.pub.a aVar = this.a;
                if (aVar.f0 == 1) {
                    g gVar = new g(b.this.a, aVar.e, u.a("d66d03d8e0"), u.a("d66a0e95ec42825be17a684c3ffd"), new Object[]{aVar.c, aVar.g}, aVar.m0);
                    gVar.h = null;
                    gVar.start();
                }
            }

            @Override // com.tnkfactory.ad.pub.a.j.d
            public final void b() {
                com.tnkfactory.ad.pub.a aVar = this.a;
                if (aVar.f0 == 2) {
                    g gVar = new g(b.this.a, aVar.e, u.a("d66d03d8e0"), u.a("d66a0e95ec42825be17a684c3ffd"), new Object[]{aVar.c, aVar.g}, aVar.m0);
                    gVar.h = null;
                    gVar.start();
                }
                this.a.e0.setPageListener(null);
                b.this.b(this.a);
            }
        }

        public b(Context context, r rVar) {
            this.a = context;
            this.f2902b = rVar;
        }

        @Override // com.tnkfactory.ad.pub.b.r
        public final void a(Object obj) {
            com.tnkfactory.ad.pub.a aVar = (com.tnkfactory.ad.pub.a) obj;
            if (!com.tnkfactory.ad.pub.a.i.a(aVar.k)) {
                com.tnkfactory.ad.pub.a.j bVar = null;
                int i = aVar.h;
                boolean z = true;
                if (i == 4) {
                    bVar = new com.tnkfactory.ad.pub.a.j(this.a);
                    if (aVar.j != null) {
                        bVar.c = true;
                        bVar.d.a.f2862b = new com.tnkfactory.ad.pub.a.k(bVar);
                    }
                } else if (i == 5) {
                    int i2 = aVar.L;
                    if (i2 != 0 && i2 != 1) {
                        z = false;
                    }
                    bVar = new com.tnkfactory.ad.pub.d.b(this.a, z);
                }
                if (bVar != null) {
                    aVar.e0 = bVar;
                    if (aVar.f0 < 3) {
                        bVar.setPageListener(new a(aVar));
                        aVar.e0.loadDataWithBaseURL(aVar.q, aVar.k, "text/html", "utf-8", null);
                        return;
                    }
                }
            }
            b(aVar);
        }

        @Override // com.tnkfactory.ad.pub.b.r
        public final void a(Throwable th) {
            r rVar = this.f2902b;
            if (rVar != null) {
                rVar.a(th);
            }
        }

        public final void b(Object obj) {
            r rVar = this.f2902b;
            if (rVar != null) {
                rVar.a(obj);
            }
        }
    }

    public c(Context context) {
        super(context);
    }

    public final void a(String str, int i, r rVar) {
        String strA = u.a("d66d03d8f9");
        String strA2 = u.a("c17d15b7ed7d9878e7");
        Object[] objArr = {str, Integer.valueOf(i)};
        a aVar = new a();
        b bVar = new b(this.f2901b, rVar);
        g gVar = new g(this.f2901b, this.a, strA, strA2, objArr, null);
        gVar.i = aVar;
        gVar.g = new com.tnkfactory.ad.pub.b.a.HandlerC0532a(bVar);
        gVar.start();
    }
}
