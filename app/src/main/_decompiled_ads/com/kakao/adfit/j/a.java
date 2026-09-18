package com.kakao.adfit.j;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;

/* JADX INFO: compiled from: CircularFifoQueue.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a<E> extends AbstractCollection<E> implements Queue<E>, Serializable {
    private transient E[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient int f1806b = 0;
    private transient int c = 0;
    private transient boolean d = false;
    private final int e;

    /* JADX INFO: renamed from: com.kakao.adfit.j.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CircularFifoQueue.java */
    class C0461a implements Iterator<E> {
        private int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1807b = -1;
        private boolean c;

        C0461a() {
            this.a = a.this.f1806b;
            this.c = a.this.d;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c || this.a != a.this.c;
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.c = false;
            int i = this.a;
            this.f1807b = i;
            this.a = a.this.b(i);
            return (E) a.this.a[this.f1807b];
        }

        @Override // java.util.Iterator
        public void remove() {
            int i = this.f1807b;
            if (i == -1) {
                throw new IllegalStateException();
            }
            if (i == a.this.f1806b) {
                a.this.remove();
                this.f1807b = -1;
                return;
            }
            int iB = this.f1807b + 1;
            if (a.this.f1806b >= this.f1807b || iB >= a.this.c) {
                while (iB != a.this.c) {
                    if (iB >= a.this.e) {
                        a.this.a[iB - 1] = a.this.a[0];
                        iB = 0;
                    } else {
                        a.this.a[a.this.a(iB)] = a.this.a[iB];
                        iB = a.this.b(iB);
                    }
                }
            } else {
                System.arraycopy(a.this.a, iB, a.this.a, this.f1807b, a.this.c - iB);
            }
            this.f1807b = -1;
            a aVar = a.this;
            aVar.c = aVar.a(aVar.c);
            a.this.a[a.this.c] = null;
            a.this.d = false;
            this.a = a.this.a(this.a);
        }
    }

    public a(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The size must be greater than 0");
        }
        this.a = (E[]) new Object[i];
        this.e = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.d = false;
        this.f1806b = 0;
        this.c = 0;
        Arrays.fill(this.a, (Object) null);
    }

    @Override // java.util.Queue
    public E element() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return peek();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new C0461a();
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        return add(e);
    }

    @Override // java.util.Queue
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return this.a[this.f1806b];
    }

    @Override // java.util.Queue
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return remove();
    }

    @Override // java.util.Queue
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        E[] eArr = this.a;
        int i = this.f1806b;
        E e = eArr[i];
        if (e != null) {
            int i2 = i + 1;
            this.f1806b = i2;
            eArr[i] = null;
            if (i2 >= this.e) {
                this.f1806b = 0;
            }
            this.d = false;
        }
        return e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        int i = this.c;
        int i2 = this.f1806b;
        if (i < i2) {
            return (this.e - i2) + i;
        }
        if (i != i2) {
            return i - i2;
        }
        if (this.d) {
            return this.e;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i) {
        int i2 = i + 1;
        if (i2 >= this.e) {
            return 0;
        }
        return i2;
    }

    public boolean a() {
        return size() == this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i) {
        int i2 = i - 1;
        return i2 < 0 ? this.e - 1 : i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e) {
        Objects.requireNonNull(e, "Attempted to add null object to queue");
        if (a()) {
            remove();
        }
        E[] eArr = this.a;
        int i = this.c;
        int i2 = i + 1;
        this.c = i2;
        eArr[i] = e;
        if (i2 >= this.e) {
            this.c = 0;
        }
        if (this.c == this.f1806b) {
            this.d = true;
        }
        return true;
    }
}
