package com.tnkfactory.ad.pub.b;

import android.content.Context;
import com.tnkfactory.ad.pub.a.u;
import com.tnkfactory.framework.vo.ValueObject;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class t extends a {
    public com.tnkfactory.ad.pub.a c;

    public t(Context context, com.tnkfactory.ad.pub.a aVar) {
        super(context, aVar.e);
        this.c = aVar;
    }

    public final void a(int i, Map<String, Object> map, r rVar) {
        ValueObject valueObject = new ValueObject();
        valueObject.add(map);
        String strA = u.a("d66d03d8e0");
        String strA2 = u.a("d66a0e95ec42825dfa7b614c1df638a086df17102b4b");
        com.tnkfactory.ad.pub.a aVar = this.c;
        g gVar = new g(this.f2901b, this.a, strA, strA2, new Object[]{aVar.c, aVar.g, Integer.valueOf(i), valueObject}, null);
        gVar.h = null;
        if (rVar != null) {
            gVar.g = new a.HandlerC0532a(rVar);
        }
        gVar.start();
    }
}
