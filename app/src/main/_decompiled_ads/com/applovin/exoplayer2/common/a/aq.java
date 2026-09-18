package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
public final class aq {

    static abstract class a<E> extends AbstractSet<E> {
        a() {
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return aq.a((Set<?>) this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) Preconditions.checkNotNull(collection));
        }
    }

    public static <E> HashSet<E> gS() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> bp(int i) {
        return new HashSet<>(ab.bl(i));
    }

    public static <E> Set<E> gT() {
        return Collections.newSetFromMap(ab.gH());
    }

    public static abstract class b<E> extends AbstractSet<E> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: fU */
        public abstract ax<E> iterator();

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        private b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: com.applovin.exoplayer2.common.a.aq$1, reason: invalid class name */
    class AnonymousClass1<E> extends b<E> {
        final /* synthetic */ Set qZ;
        final /* synthetic */ Set ra;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int size = this.qZ.size();
            Iterator<E> it = this.ra.iterator();
            while (it.hasNext()) {
                if (!this.qZ.contains(it.next())) {
                    size++;
                }
            }
            return size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.qZ.isEmpty() && this.ra.isEmpty();
        }

        @Override // com.applovin.exoplayer2.common.a.aq.b, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: fU, reason: merged with bridge method [inline-methods] */
        public ax<E> iterator() {
            return new com.applovin.exoplayer2.common.a.b<E>() { // from class: com.applovin.exoplayer2.common.a.aq.1.1
                final Iterator<? extends E> rb;
                final Iterator<? extends E> rc;

                {
                    this.rb = AnonymousClass1.this.qZ.iterator();
                    this.rc = AnonymousClass1.this.ra.iterator();
                }

                @Override // com.applovin.exoplayer2.common.a.b
                protected E eT() {
                    if (this.rb.hasNext()) {
                        return this.rb.next();
                    }
                    while (this.rc.hasNext()) {
                        E next = this.rc.next();
                        if (!AnonymousClass1.this.qZ.contains(next)) {
                            return next;
                        }
                    }
                    return eU();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.qZ.contains(obj) || this.ra.contains(obj);
        }
    }

    public static <E> b<E> a(final Set<E> set, final Set<?> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new b<E>() { // from class: com.applovin.exoplayer2.common.a.aq.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(null);
            }

            @Override // com.applovin.exoplayer2.common.a.aq.b, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* JADX INFO: renamed from: fU */
            public ax<E> iterator() {
                return new com.applovin.exoplayer2.common.a.b<E>() { // from class: com.applovin.exoplayer2.common.a.aq.2.1
                    final Iterator<E> re;

                    {
                        this.re = set.iterator();
                    }

                    @Override // com.applovin.exoplayer2.common.a.b
                    protected E eT() {
                        while (this.re.hasNext()) {
                            E next = this.re.next();
                            if (set2.contains(next)) {
                                return next;
                            }
                        }
                        return eU();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                Iterator<E> it = set.iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (set2.contains(it.next())) {
                        i++;
                    }
                }
                return i;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return Collections.disjoint(set2, set);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return set.contains(obj) && set2.contains(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean containsAll(Collection<?> collection) {
                return set.containsAll(collection) && set2.containsAll(collection);
            }
        };
    }

    static int a(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    static boolean a(Set<?> set, @NullableDecl Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    static boolean a(Set<?> set, Iterator<?> it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }

    static boolean a(Set<?> set, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof af) {
            collection = ((af) collection).gN();
        }
        if ((collection instanceof Set) && collection.size() > set.size()) {
            return y.a(set.iterator(), collection);
        }
        return a(set, collection.iterator());
    }
}
