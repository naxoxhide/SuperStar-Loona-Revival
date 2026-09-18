package com.tnkfactory.ad.pub.b;

import android.content.Context;
import android.os.Handler;
import com.tnkfactory.ad.Logger;
import com.tnkfactory.ad.pub.a.u;
import com.tnkfactory.framework.vo.ValueObject;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class g extends Thread {
    public Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2907b;
    public String c;
    public String d;
    public Object[] e;
    public com.tnkfactory.ad.pub.a.g f;
    public Handler g;
    public List<String> h;
    public q i = null;

    public g(Context context, String str, String str2, String str3, Object[] objArr, com.tnkfactory.ad.pub.a.g gVar) {
        this.a = context;
        this.f2907b = str;
        this.c = str2;
        this.d = str3;
        this.e = objArr;
        this.f = gVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        f fVar;
        String str;
        Context context = this.a;
        synchronized (f.class) {
            if (f.x == null) {
                f.x = new f(context);
                try {
                    f.class.getClassLoader().loadClass("com.tnkfactory.framework.vo.ValueObject");
                } catch (Exception unused) {
                    Logger.e("Using progard? Put '-keep class com.tnkfactory.**' in your proguard setting file !!");
                }
                Map<String, String> map = u.a;
            }
            fVar = f.x;
        }
        if (fVar == null) {
            str = "f55c2ad6e75e852bfa716d5737f839b990df0758";
        } else {
            if (fVar.c != null) {
                System.currentTimeMillis();
                try {
                    try {
                        th = new o(fVar, this.f).a(this.f2907b, this.c, this.d, this.e);
                    } catch (l e) {
                        throw e;
                    } catch (Exception e2) {
                        Logger.e("error #f001 : " + e2.toString());
                        throw new l(e2);
                    }
                } catch (Throwable th) {
                    th = th;
                }
                q qVar = this.i;
                if (qVar != null) {
                    c.a aVar = (c.a) qVar;
                    aVar.getClass();
                    if (th != null && !(th instanceof Throwable)) {
                        Context context2 = c.this.f2901b;
                        com.tnkfactory.ad.pub.a aVar2 = new com.tnkfactory.ad.pub.a();
                        aVar2.a(context2, (ValueObject) th);
                        th = aVar2;
                    }
                }
                Handler handler = this.g;
                if (handler != null) {
                    this.g.sendMessage(handler.obtainMessage(1, th));
                }
                List<String> list = this.h;
                if (list != null) {
                    new s(list).run();
                    return;
                }
                return;
            }
            str = "e77c1793fb459878fa71630317fd75be85ce431f2b50c68d51";
        }
        Logger.e(u.a(str));
    }
}
