package com.kakao.adfit.j;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: SynchronizedCollection.java */
/* JADX INFO: loaded from: classes2.dex */
class i<E> implements Collection<E>, Serializable {
    private final Collection<E> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f1810b;

    i(Collection<E> collection) {
        Objects.requireNonNull(collection, "Collection must not be null.");
        this.a = collection;
        this.f1810b = this;
    }

    protected Collection<E> a() {
        return this.a;
    }

    @Override // java.util.Collection
    public boolean add(E e) {
        boolean zAdd;
        synchronized (this.f1810b) {
            zAdd = a().add(e);
        }
        return zAdd;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        boolean zAddAll;
        synchronized (this.f1810b) {
            zAddAll = a().addAll(collection);
        }
        return zAddAll;
    }

    @Override // java.util.Collection
    public void clear() {
        synchronized (this.f1810b) {
            a().clear();
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        boolean zContains;
        synchronized (this.f1810b) {
            zContains = a().contains(obj);
        }
        return zContains;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        boolean zContainsAll;
        synchronized (this.f1810b) {
            zContainsAll = a().containsAll(collection);
        }
        return zContainsAll;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        boolean zIsEmpty;
        synchronized (this.f1810b) {
            zIsEmpty = a().isEmpty();
        }
        return zIsEmpty;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return a().iterator();
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        boolean zRemove;
        synchronized (this.f1810b) {
            zRemove = a().remove(obj);
        }
        return zRemove;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        boolean zRemoveAll;
        synchronized (this.f1810b) {
            zRemoveAll = a().removeAll(collection);
        }
        return zRemoveAll;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        boolean zRetainAll;
        synchronized (this.f1810b) {
            zRetainAll = a().retainAll(collection);
        }
        return zRetainAll;
    }

    @Override // java.util.Collection
    public int size() {
        int size;
        synchronized (this.f1810b) {
            size = a().size();
        }
        return size;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        Object[] array;
        synchronized (this.f1810b) {
            array = a().toArray();
        }
        return array;
    }

    public String toString() {
        String string;
        synchronized (this.f1810b) {
            string = a().toString();
        }
        return string;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        T[] tArr2;
        synchronized (this.f1810b) {
            tArr2 = (T[]) a().toArray(tArr);
        }
        return tArr2;
    }
}
