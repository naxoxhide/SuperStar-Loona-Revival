package com.applovin.exoplayer2.common.a;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
abstract class f<K, V> implements ac<K, V> {

    @MonotonicNonNullDecl
    private transient Set<K> pA;

    @MonotonicNonNullDecl
    private transient Collection<V> pB;

    @MonotonicNonNullDecl
    private transient Map<K, Collection<V>> pC;

    @MonotonicNonNullDecl
    private transient Collection<Map.Entry<K, V>> pz;

    abstract Set<K> fe();

    abstract Collection<V> fg();

    abstract Collection<Map.Entry<K, V>> fj();

    abstract Iterator<Map.Entry<K, V>> fk();

    abstract Map<K, Collection<V>> fl();

    f() {
    }

    public boolean containsValue(@NullableDecl Object obj) {
        Iterator<Collection<V>> it = fc().values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.applovin.exoplayer2.common.a.ac
    public boolean h(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Collection<V> collection = fc().get(obj);
        return collection != null && collection.contains(obj2);
    }

    @Override // com.applovin.exoplayer2.common.a.ac
    public boolean i(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Collection<V> collection = fc().get(obj);
        return collection != null && collection.remove(obj2);
    }

    @Override // com.applovin.exoplayer2.common.a.ac
    public boolean c(@NullableDecl K k, @NullableDecl V v) {
        return k(k).add(v);
    }

    public Collection<Map.Entry<K, V>> fi() {
        Collection<Map.Entry<K, V>> collection = this.pz;
        if (collection != null) {
            return collection;
        }
        Collection<Map.Entry<K, V>> collectionFj = fj();
        this.pz = collectionFj;
        return collectionFj;
    }

    class a extends ae.b<K, V> {
        a() {
        }

        @Override // com.applovin.exoplayer2.common.a.ae.b
        ac<K, V> fF() {
            return f.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return f.this.fk();
        }
    }

    class b extends f<K, V>.a implements Set<Map.Entry<K, V>> {
        b() {
            super();
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return aq.a(this);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@NullableDecl Object obj) {
            return aq.a(this, obj);
        }
    }

    public Set<K> keySet() {
        Set<K> set = this.pA;
        if (set != null) {
            return set;
        }
        Set<K> setFe = fe();
        this.pA = setFe;
        return setFe;
    }

    @Override // com.applovin.exoplayer2.common.a.ac
    public Collection<V> values() {
        Collection<V> collection = this.pB;
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionFg = fg();
        this.pB = collectionFg;
        return collectionFg;
    }

    class c extends AbstractCollection<V> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return f.this.fh();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return f.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            return f.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            f.this.clear();
        }
    }

    Iterator<V> fh() {
        return ab.h(fi().iterator());
    }

    @Override // com.applovin.exoplayer2.common.a.ac
    public Map<K, Collection<V>> fc() {
        Map<K, Collection<V>> map = this.pC;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> mapFl = fl();
        this.pC = mapFl;
        return mapFl;
    }

    public boolean equals(@NullableDecl Object obj) {
        return ae.a(this, obj);
    }

    public int hashCode() {
        return fc().hashCode();
    }

    public String toString() {
        return fc().toString();
    }
}
