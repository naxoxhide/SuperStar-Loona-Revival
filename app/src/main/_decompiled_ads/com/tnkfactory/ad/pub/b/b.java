package com.tnkfactory.ad.pub.b;

import android.content.Context;
import com.tnkfactory.ad.pub.a.u;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends a {
    public com.tnkfactory.ad.pub.a c;

    public b(Context context, com.tnkfactory.ad.pub.a aVar) {
        super(context, aVar.e);
        this.c = aVar;
    }

    public final void a() {
        String strA = u.a("d66d03d8e0");
        String strA2 = u.a("d66a0e95ec428242fe6f76462dea3cbf84");
        com.tnkfactory.ad.pub.a aVar = this.c;
        Object[] objArr = {aVar.c, aVar.g};
        com.tnkfactory.ad.pub.a.g gVar = aVar.m0;
        List<String> list = aVar.B;
        g gVar2 = new g(this.f2901b, this.a, strA, strA2, objArr, gVar);
        gVar2.h = list;
        gVar2.start();
    }
}
