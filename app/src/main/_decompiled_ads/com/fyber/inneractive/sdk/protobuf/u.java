package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.u.b;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class u<T extends b<T>> {
    public static final u d;
    public final g1<T, Object> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1309b;
    public boolean c;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f1310b;

        static {
            int[] iArr = new int[r1.b.values().length];
            f1310b = iArr;
            try {
                iArr[r1.b.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1310b[r1.b.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1310b[r1.b.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1310b[r1.b.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1310b[r1.b.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1310b[r1.b.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1310b[r1.b.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1310b[r1.b.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1310b[r1.b.GROUP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1310b[r1.b.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1310b[r1.b.STRING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1310b[r1.b.BYTES.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1310b[r1.b.UINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f1310b[r1.b.SFIXED32.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f1310b[r1.b.SFIXED64.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f1310b[r1.b.SINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f1310b[r1.b.SINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f1310b[r1.b.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[r1.c.values().length];
            a = iArr2;
            try {
                iArr2[r1.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[r1.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[r1.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[r1.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                a[r1.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                a[r1.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                a[r1.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                a[r1.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                a[r1.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    public interface b<T extends b<T>> extends Comparable<T> {
        int a();

        o0.a a(o0.a aVar, o0 o0Var);

        boolean b();

        r1.b c();

        r1.c d();

        boolean isPacked();
    }

    static {
        u uVar = new u(g1.b(0));
        uVar.g();
        d = uVar;
    }

    public u() {
        this.a = g1.b(16);
    }

    public static <T extends b<T>> u<T> b() {
        return d;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public u<T> clone() {
        u<T> uVar = new u<>();
        for (int i = 0; i < this.a.f1287b.size(); i++) {
            Map.Entry<K, Object> entryA = this.a.a(i);
            uVar.c((b) entryA.getKey(), entryA.getValue());
        }
        Iterator it = this.a.b().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            uVar.c((b) entry.getKey(), entry.getValue());
        }
        uVar.c = this.c;
        return uVar;
    }

    public void c(T t, Object obj) {
        if (!t.b()) {
            d(t, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                d(t, it.next());
            }
            obj = arrayList;
        }
        if (obj instanceof a0) {
            this.c = true;
        }
        this.a.put(t, obj);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0035  */
    public final void d(T t, Object obj) {
        boolean z;
        r1.b bVarC = t.c();
        Charset charset = y.a;
        obj.getClass();
        switch (a.a[bVarC.e().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if ((obj instanceof i) || (obj instanceof byte[])) {
                    z = true;
                } else {
                    z = false;
                }
                break;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof y.c)) {
                    z = true;
                } else {
                    z = false;
                }
                break;
            case 9:
                if ((obj instanceof o0) || (obj instanceof a0)) {
                    z = true;
                } else {
                    z = false;
                }
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t.a()), t.c().e(), obj.getClass().getName()));
        }
    }

    public boolean e() {
        for (int i = 0; i < this.a.f1287b.size(); i++) {
            if (!b(this.a.a(i))) {
                return false;
            }
        }
        Iterator it = this.a.b().iterator();
        while (it.hasNext()) {
            if (!b((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof u) {
            return this.a.equals(((u) obj).a);
        }
        return false;
    }

    public Iterator<Map.Entry<T, Object>> f() {
        return this.c ? new a0.b(this.a.entrySet().iterator()) : this.a.entrySet().iterator();
    }

    public void g() {
        if (this.f1309b) {
            return;
        }
        this.a.d();
        this.f1309b = true;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public static <T extends b<T>> boolean b(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.d() == r1.c.MESSAGE) {
            if (key.b()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((o0) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (!(value instanceof o0)) {
                    if (value instanceof a0) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((o0) value).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    public u(g1<T, Object> g1Var) {
        this.a = g1Var;
        g();
    }

    public Object a(T t) {
        Object obj = this.a.get(t);
        return obj instanceof a0 ? ((a0) obj).a(null) : obj;
    }

    public void a(T t, Object obj) {
        List arrayList;
        if (((GeneratedMessageLite.d) t).d) {
            d(t, obj);
            Object objA = a((b) t);
            if (objA == null) {
                arrayList = new ArrayList();
                this.a.put(t, arrayList);
            } else {
                arrayList = (List) objA;
            }
            arrayList.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public static int b(b<?> bVar, Object obj) {
        r1.b bVarC = bVar.c();
        int iA = bVar.a();
        if (bVar.b()) {
            int iA2 = 0;
            if (bVar.isPacked()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    iA2 += a(bVarC, it.next());
                }
                return l.b(iA) + iA2 + l.c(iA2);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                iA2 += a(bVarC, iA, it2.next());
            }
            return iA2;
        }
        return a(bVarC, iA, obj);
    }

    public static int a(r1.b bVar, boolean z) {
        if (z) {
            return 2;
        }
        return bVar.f();
    }

    public void a(u<T> uVar) {
        for (int i = 0; i < uVar.a.f1287b.size(); i++) {
            c(uVar.a.a(i));
        }
        Iterator it = uVar.a.b().iterator();
        while (it.hasNext()) {
            c((Map.Entry) it.next());
        }
    }

    public final void c(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof a0) {
            value = ((a0) value).a(null);
        }
        if (key.b()) {
            Object objA = a((b) key);
            if (objA == null) {
                objA = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objA).add(a(it.next()));
            }
            this.a.put(key, objA);
            return;
        }
        if (key.d() == r1.c.MESSAGE) {
            Object objA2 = a((b) key);
            if (objA2 == null) {
                this.a.put(key, a(value));
                return;
            } else {
                this.a.put(key, ((GeneratedMessageLite.b) key.a(((o0) objA2).toBuilder(), (o0) value)).a());
                return;
            }
        }
        this.a.put(key, a(value));
    }

    public static Object a(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public final int a(Map.Entry<T, Object> entry) {
        int iB;
        int iC;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.d() == r1.c.MESSAGE && !key.b() && !key.isPacked()) {
            if (value instanceof a0) {
                iB = (l.b(1) * 2) + l.f(2, entry.getKey().a());
                iC = l.b(3) + l.a((a0) value);
            } else {
                iB = (l.b(1) * 2) + l.f(2, entry.getKey().a());
                int iB2 = l.b(3);
                int serializedSize = ((o0) value).getSerializedSize();
                iC = iB2 + l.c(serializedSize) + serializedSize;
            }
            return iB + iC;
        }
        return b(key, value);
    }

    public int d() {
        int iB = 0;
        for (int i = 0; i < this.a.f1287b.size(); i++) {
            Map.Entry<K, Object> entryA = this.a.a(i);
            iB += b((b) entryA.getKey(), entryA.getValue());
        }
        Iterator it = this.a.b().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            iB += b((b) entry.getKey(), entry.getValue());
        }
        return iB;
    }

    public static int a(r1.b bVar, int i, Object obj) {
        int iB = l.b(i);
        if (bVar == r1.b.GROUP) {
            iB *= 2;
        }
        return iB + a(bVar, obj);
    }

    public int c() {
        int iA = 0;
        for (int i = 0; i < this.a.f1287b.size(); i++) {
            iA += a((Map.Entry) this.a.a(i));
        }
        Iterator it = this.a.b().iterator();
        while (it.hasNext()) {
            iA += a((Map.Entry) it.next());
        }
        return iA;
    }

    public static int a(r1.b bVar, Object obj) {
        int serializedSize;
        int iC;
        switch (a.f1310b[bVar.ordinal()]) {
            case 1:
                ((Double) obj).doubleValue();
                Logger logger = l.f1298b;
                return 8;
            case 2:
                ((Float) obj).floatValue();
                Logger logger2 = l.f1298b;
                return 4;
            case 3:
                return l.a(((Long) obj).longValue());
            case 4:
                return l.a(((Long) obj).longValue());
            case 5:
                return l.a(((Integer) obj).intValue());
            case 6:
                ((Long) obj).longValue();
                Logger logger3 = l.f1298b;
                return 8;
            case 7:
                ((Integer) obj).intValue();
                Logger logger4 = l.f1298b;
                return 4;
            case 8:
                ((Boolean) obj).booleanValue();
                Logger logger5 = l.f1298b;
                return 1;
            case 9:
                Logger logger6 = l.f1298b;
                return ((o0) obj).getSerializedSize();
            case 10:
                if (obj instanceof a0) {
                    return l.a((a0) obj);
                }
                Logger logger7 = l.f1298b;
                serializedSize = ((o0) obj).getSerializedSize();
                iC = l.c(serializedSize);
                break;
                break;
            case 11:
                if (obj instanceof i) {
                    return l.a((i) obj);
                }
                return l.a((String) obj);
            case 12:
                if (obj instanceof i) {
                    return l.a((i) obj);
                }
                Logger logger8 = l.f1298b;
                serializedSize = ((byte[]) obj).length;
                iC = l.c(serializedSize);
                break;
                break;
            case 13:
                return l.c(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                Logger logger9 = l.f1298b;
                return 4;
            case 15:
                ((Long) obj).longValue();
                Logger logger10 = l.f1298b;
                return 8;
            case 16:
                return l.c(l.d(((Integer) obj).intValue()));
            case 17:
                return l.a(l.b(((Long) obj).longValue()));
            case 18:
                if (obj instanceof y.c) {
                    return l.a(((y.c) obj).a());
                }
                return l.a(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return iC + serializedSize;
    }
}
