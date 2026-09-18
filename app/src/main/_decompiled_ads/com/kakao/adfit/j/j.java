package com.kakao.adfit.j;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: compiled from: SynchronizedQueue.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j<E> extends i<E> implements Queue<E> {
    private j(Queue<E> queue) {
        super(queue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kakao.adfit.j.i, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.kakao.adfit.j.i, java.util.Collection
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return super.addAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kakao.adfit.j.i
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Queue<E> a() {
        return (Queue) super.a();
    }

    @Override // com.kakao.adfit.j.i, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.kakao.adfit.j.i, java.util.Collection
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.kakao.adfit.j.i, java.util.Collection
    public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
        return super.containsAll(collection);
    }

    @Override // java.util.Queue
    public E element() {
        E eElement;
        synchronized (this.f1810b) {
            eElement = a().element();
        }
        return eElement;
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        boolean zEquals;
        if (obj == this) {
            return true;
        }
        synchronized (this.f1810b) {
            zEquals = a().equals(obj);
        }
        return zEquals;
    }

    @Override // java.util.Collection
    public int hashCode() {
        int iHashCode;
        synchronized (this.f1810b) {
            iHashCode = a().hashCode();
        }
        return iHashCode;
    }

    @Override // com.kakao.adfit.j.i, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.kakao.adfit.j.i, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        boolean zOffer;
        synchronized (this.f1810b) {
            zOffer = a().offer(e);
        }
        return zOffer;
    }

    @Override // java.util.Queue
    public E peek() {
        E ePeek;
        synchronized (this.f1810b) {
            ePeek = a().peek();
        }
        return ePeek;
    }

    @Override // java.util.Queue
    public E poll() {
        E ePoll;
        synchronized (this.f1810b) {
            ePoll = a().poll();
        }
        return ePoll;
    }

    @Override // com.kakao.adfit.j.i, java.util.Collection
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.kakao.adfit.j.i, java.util.Collection
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.kakao.adfit.j.i, java.util.Collection
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.kakao.adfit.j.i, java.util.Collection
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.kakao.adfit.j.i, java.util.Collection
    public /* bridge */ /* synthetic */ Object[] toArray() {
        return super.toArray();
    }

    @Override // com.kakao.adfit.j.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <E> j<E> a(Queue<E> queue) {
        return new j<>(queue);
    }

    @Override // java.util.Queue
    public E remove() {
        E eRemove;
        synchronized (this.f1810b) {
            eRemove = a().remove();
        }
        return eRemove;
    }

    @Override // com.kakao.adfit.j.i, java.util.Collection
    public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
        return super.toArray(objArr);
    }
}
