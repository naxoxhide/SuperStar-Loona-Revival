package com.kakao.adfit.n;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: ByteArrayPool.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    protected static final Comparator<byte[]> e = new a();
    private final List<byte[]> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<byte[]> f1853b = new ArrayList(64);
    private int c = 0;
    private final int d;

    /* JADX INFO: compiled from: ByteArrayPool.java */
    class a implements Comparator<byte[]> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public c(int i) {
        this.d = i;
    }

    public synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < this.f1853b.size(); i2++) {
            byte[] bArr = this.f1853b.get(i2);
            if (bArr.length >= i) {
                this.c -= bArr.length;
                this.f1853b.remove(i2);
                this.a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.d) {
                this.a.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.f1853b, bArr, e);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.f1853b.add(iBinarySearch, bArr);
                this.c += bArr.length;
                a();
            }
        }
    }

    private synchronized void a() {
        while (this.c > this.d) {
            byte[] bArrRemove = this.a.remove(0);
            this.f1853b.remove(bArrRemove);
            this.c -= bArrRemove.length;
        }
    }
}
