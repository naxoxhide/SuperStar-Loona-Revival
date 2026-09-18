package com.fyber.inneractive.sdk.protobuf;

import androidx.core.internal.view.SupportMenu;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile q f1303b;
    public static final q c = new q(true);
    public final Map<a, GeneratedMessageLite.e<?, ?>> a;

    public static final class a {
        public final Object a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1304b;

        public a(Object obj, int i) {
            this.a = obj;
            this.f1304b = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.f1304b == aVar.f1304b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.a) * SupportMenu.USER_MASK) + this.f1304b;
        }
    }

    public q() {
        this.a = new HashMap();
    }

    public static q a() {
        q qVar = f1303b;
        if (qVar == null) {
            synchronized (q.class) {
                qVar = f1303b;
                if (qVar == null) {
                    Class<?> cls = p.a;
                    q qVar2 = null;
                    if (cls != null) {
                        try {
                            qVar2 = (q) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
                        } catch (Exception unused) {
                        }
                    }
                    if (qVar2 == null) {
                        qVar2 = c;
                    }
                    f1303b = qVar2;
                    qVar = qVar2;
                }
            }
        }
        return qVar;
    }

    public q(boolean z) {
        this.a = Collections.emptyMap();
    }
}
