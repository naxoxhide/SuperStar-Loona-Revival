package com.applovin.impl.sdk.utils;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class o<T extends Comparable<? super T>> implements RandomAccess, Set<T> {
    private final ArrayList<T> aVL = new ArrayList<>();
    private final HashSet<T> aVM = new HashSet<>();

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.aVL.size();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.aVL.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.aVM.contains(obj);
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return this.aVL.iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return this.aVL.toArray();
    }

    @Override // java.util.Set, java.util.Collection
    public <T1> T1[] toArray(T1[] t1Arr) {
        return (T1[]) this.aVL.toArray(t1Arr);
    }

    @Override // java.util.Set, java.util.Collection
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean add(T t) {
        if (contains(t)) {
            return false;
        }
        if (isEmpty() || t.compareTo(Ln()) > 0) {
            this.aVL.add(t);
        } else {
            this.aVL.add(c(t), t);
        }
        return this.aVM.add(t);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        int iB = b((Comparable) obj);
        if (iB == -1) {
            return false;
        }
        this.aVL.remove(iB);
        return this.aVM.remove(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.aVM.containsAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        Iterator<? extends T> it = collection.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                if (add(it.next()) || z) {
                    z = true;
                }
            }
            return z;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int size = size() - 1; size >= 0; size--) {
            T t = this.aVL.get(size);
            if (!collection.contains(t)) {
                this.aVL.remove(size);
                this.aVM.remove(t);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        while (true) {
            boolean z = false;
            for (Object obj : collection) {
                if (z || remove(obj)) {
                    z = true;
                }
            }
            return false;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.aVL.clear();
        this.aVM.clear();
    }

    public T gS(int i) {
        return this.aVL.get(i);
    }

    public void a(int i, T t) {
        this.aVM.remove(this.aVL.get(i));
        this.aVL.set(i, t);
        this.aVM.add(t);
    }

    public T gT(int i) {
        T tRemove = this.aVL.remove(i);
        this.aVM.remove(tRemove);
        return tRemove;
    }

    public int b(T t) {
        if (t == null || !contains(t)) {
            return -1;
        }
        return c(t);
    }

    public T Ln() {
        return this.aVL.get(size() - 1);
    }

    public int c(T t) {
        int iBinarySearch = Collections.binarySearch(this.aVL, t);
        if (iBinarySearch < 0) {
            return ~iBinarySearch;
        }
        Comparable comparableGS = gS(iBinarySearch);
        while (iBinarySearch >= 0 && comparableGS == gS(iBinarySearch)) {
            iBinarySearch--;
        }
        return iBinarySearch + 1;
    }

    public int d(T t) {
        int iBinarySearch = Collections.binarySearch(this.aVL, t);
        if (iBinarySearch < 0) {
            return ~iBinarySearch;
        }
        Comparable comparableGS = gS(iBinarySearch);
        while (iBinarySearch < size() && comparableGS == gS(iBinarySearch)) {
            iBinarySearch++;
        }
        return iBinarySearch;
    }
}
