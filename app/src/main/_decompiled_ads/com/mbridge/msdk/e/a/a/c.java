package com.mbridge.msdk.e.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: ByteArrayPool.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    protected static final Comparator<byte[]> a = new Comparator<byte[]>() { // from class: com.mbridge.msdk.e.a.a.c.1
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<byte[]> f2017b = new ArrayList();
    private final List<byte[]> c = new ArrayList(64);
    private int d = 0;
    private final int e;

    public c(int i) {
        this.e = i;
    }

    public final synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            byte[] bArr = this.c.get(i2);
            if (bArr.length >= i) {
                this.d -= bArr.length;
                this.c.remove(i2);
                this.f2017b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public final synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.e) {
                this.f2017b.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.c, bArr, a);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.c.add(iBinarySearch, bArr);
                this.d += bArr.length;
                a();
            }
        }
    }

    private synchronized void a() {
        while (this.d > this.e) {
            byte[] bArrRemove = this.f2017b.remove(0);
            this.c.remove(bArrRemove);
            this.d -= bArrRemove.length;
        }
    }
}
