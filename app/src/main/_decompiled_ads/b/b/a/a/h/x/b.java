package b.b.a.a.h.x;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import b.b.a.a.h.j;
import b.b.a.a.h.m;
import b.b.a.a.h.n;
import b.b.a.a.h.r;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: ImageLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements n {
    private volatile f a;

    private b() {
    }

    public static n a(Context context, m mVar) {
        b bVar = new b();
        bVar.b(context, mVar);
        return bVar;
    }

    private void b(Context context, m mVar) {
        if (this.a != null) {
            Log.w("ImageLoader", "already init!");
        }
        if (mVar == null) {
            mVar = e.a(context);
        }
        this.a = new f(context, mVar);
    }

    @Override // b.b.a.a.h.n
    public j a(String str) {
        return new c.C0036c(this.a).c(str);
    }

    @Override // b.b.a.a.h.n
    public InputStream a(String str, String str2) {
        if (this.a != null) {
            if (TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                str2 = b.b.a.a.h.x.k.c.a(str);
            }
            Collection<r> collectionF = this.a.f();
            if (collectionF != null) {
                Iterator<r> it = collectionF.iterator();
                while (it.hasNext()) {
                    byte[] bArr = it.next().get(str2);
                    if (bArr != null) {
                        return new ByteArrayInputStream(bArr);
                    }
                }
            }
            Collection<b.b.a.a.h.c> collectionE = this.a.e();
            if (collectionE != null) {
                Iterator<b.b.a.a.h.c> it2 = collectionE.iterator();
                while (it2.hasNext()) {
                    InputStream inputStreamA = it2.next().a(str2);
                    if (inputStreamA != null) {
                        return inputStreamA;
                    }
                }
            }
        }
        return null;
    }

    @Override // b.b.a.a.h.n
    public boolean a(String str, String str2, String str3) {
        if (this.a == null || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            str2 = b.b.a.a.h.x.k.c.a(str);
        }
        b.b.a.a.h.c cVarA = this.a.a(str3);
        if (cVarA != null) {
            return cVarA.contains(str2);
        }
        return false;
    }
}
