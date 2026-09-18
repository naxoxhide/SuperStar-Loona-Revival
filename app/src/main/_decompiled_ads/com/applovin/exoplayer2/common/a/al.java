package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
final class al<K, V> extends u<K, V> {
    static final u<Object, Object> qP = new al(null, new Object[0], 0);
    private final transient int oW;
    private final transient int[] qQ;
    final transient Object[] ql;

    @Override // com.applovin.exoplayer2.common.a.u
    boolean fZ() {
        return false;
    }

    static <K, V> al<K, V> b(int i, Object[] objArr) {
        if (i == 0) {
            return (al) qP;
        }
        if (i == 1) {
            j.j(objArr[0], objArr[1]);
            return new al<>(null, objArr, 1);
        }
        Preconditions.checkPositionIndex(i, objArr.length >> 1);
        return new al<>(a(objArr, i, w.bk(i), 0), objArr, i);
    }

    static int[] a(Object[] objArr, int i, int i2, int i3) {
        int i4;
        if (i == 1) {
            j.j(objArr[i3], objArr[i3 ^ 1]);
            return null;
        }
        int i5 = i2 - 1;
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        for (int i6 = 0; i6 < i; i6++) {
            int i7 = i6 * 2;
            int i8 = i7 + i3;
            Object obj = objArr[i8];
            Object obj2 = objArr[i7 + (i3 ^ 1)];
            j.j(obj, obj2);
            int iBg = p.bg(obj.hashCode());
            while (true) {
                i4 = iBg & i5;
                int i9 = iArr[i4];
                if (i9 == -1) {
                    break;
                }
                if (objArr[i9].equals(obj)) {
                    throw new IllegalArgumentException("Multiple entries with same key: " + obj + "=" + obj2 + " and " + objArr[i9] + "=" + objArr[i9 ^ 1]);
                }
                iBg = i4 + 1;
            }
            iArr[i4] = i8;
        }
        return iArr;
    }

    private al(int[] iArr, Object[] objArr, int i) {
        this.qQ = iArr;
        this.ql = objArr;
        this.oW = i;
    }

    @Override // java.util.Map
    public int size() {
        return this.oW;
    }

    @Override // com.applovin.exoplayer2.common.a.u, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        return (V) a(this.qQ, this.ql, this.oW, 0, obj);
    }

    static Object a(@NullableDecl int[] iArr, @NullableDecl Object[] objArr, int i, int i2, @NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (objArr[i2].equals(obj)) {
                return objArr[i2 ^ 1];
            }
            return null;
        }
        if (iArr == null) {
            return null;
        }
        int length = iArr.length - 1;
        int iBg = p.bg(obj.hashCode());
        while (true) {
            int i3 = iBg & length;
            int i4 = iArr[i3];
            if (i4 == -1) {
                return null;
            }
            if (objArr[i4].equals(obj)) {
                return objArr[i4 ^ 1];
            }
            iBg = i3 + 1;
        }
    }

    @Override // com.applovin.exoplayer2.common.a.u
    w<Map.Entry<K, V>> gl() {
        return new a(this, this.ql, 0, this.oW);
    }

    static class a<K, V> extends w<Map.Entry<K, V>> {
        private final transient int oW;
        private final transient int qR;
        private final transient Object[] ql;
        private final transient u<K, V> qn;

        @Override // com.applovin.exoplayer2.common.a.q
        boolean fZ() {
            return true;
        }

        a(u<K, V> uVar, Object[] objArr, int i, int i2) {
            this.qn = uVar;
            this.ql = objArr;
            this.qR = i;
            this.oW = i2;
        }

        @Override // com.applovin.exoplayer2.common.a.w, com.applovin.exoplayer2.common.a.q, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: fU */
        public ax<Map.Entry<K, V>> iterator() {
            return fY().iterator();
        }

        @Override // com.applovin.exoplayer2.common.a.q
        int a(Object[] objArr, int i) {
            return fY().a(objArr, i);
        }

        @Override // com.applovin.exoplayer2.common.a.w
        s<Map.Entry<K, V>> gA() {
            return new s<Map.Entry<K, V>>() { // from class: com.applovin.exoplayer2.common.a.al.a.1
                @Override // com.applovin.exoplayer2.common.a.q
                public boolean fZ() {
                    return true;
                }

                @Override // java.util.List
                /* JADX INFO: renamed from: bo, reason: merged with bridge method [inline-methods] */
                public Map.Entry<K, V> get(int i) {
                    Preconditions.checkElementIndex(i, a.this.oW);
                    int i2 = i * 2;
                    return new AbstractMap.SimpleImmutableEntry(a.this.ql[a.this.qR + i2], a.this.ql[i2 + (a.this.qR ^ 1)]);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return a.this.oW;
                }
            };
        }

        @Override // com.applovin.exoplayer2.common.a.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.qn.get(key));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.oW;
        }
    }

    @Override // com.applovin.exoplayer2.common.a.u
    w<K> gn() {
        return new b(this, new c(this.ql, 0, this.oW));
    }

    static final class c extends s<Object> {
        private final transient int oU;
        private final transient int oW;
        private final transient Object[] ql;

        @Override // com.applovin.exoplayer2.common.a.q
        boolean fZ() {
            return true;
        }

        c(Object[] objArr, int i, int i2) {
            this.ql = objArr;
            this.oU = i;
            this.oW = i2;
        }

        @Override // java.util.List
        public Object get(int i) {
            Preconditions.checkElementIndex(i, this.oW);
            return this.ql[(i * 2) + this.oU];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.oW;
        }
    }

    static final class b<K> extends w<K> {
        private final transient s<K> ai;
        private final transient u<K, ?> qn;

        @Override // com.applovin.exoplayer2.common.a.q
        boolean fZ() {
            return true;
        }

        b(u<K, ?> uVar, s<K> sVar) {
            this.qn = uVar;
            this.ai = sVar;
        }

        @Override // com.applovin.exoplayer2.common.a.w, com.applovin.exoplayer2.common.a.q, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: fU */
        public ax<K> iterator() {
            return fY().iterator();
        }

        @Override // com.applovin.exoplayer2.common.a.q
        int a(Object[] objArr, int i) {
            return fY().a(objArr, i);
        }

        @Override // com.applovin.exoplayer2.common.a.w, com.applovin.exoplayer2.common.a.q
        public s<K> fY() {
            return this.ai;
        }

        @Override // com.applovin.exoplayer2.common.a.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return this.qn.get(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.qn.size();
        }
    }

    @Override // com.applovin.exoplayer2.common.a.u
    q<V> gp() {
        return new c(this.ql, 1, this.oW);
    }
}
