package com.mbridge.msdk.e.a.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: PoolingByteArrayOutputStream.java */
/* JADX INFO: loaded from: classes4.dex */
public final class j extends ByteArrayOutputStream {
    private final c a;

    public j(c cVar, int i) {
        this.a = cVar;
        this.buf = cVar.a(Math.max(i, 256));
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.a.a(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.a.a(this.buf);
    }

    private void a(int i) {
        if (this.count + i <= this.buf.length) {
            return;
        }
        byte[] bArrA = this.a.a((this.count + i) * 2);
        System.arraycopy(this.buf, 0, bArrA, 0, this.count);
        this.a.a(this.buf);
        this.buf = bArrA;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        a(i2);
        if (bArr != null) {
            super.write(bArr, i, i2);
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i) {
        a(1);
        super.write(i);
    }
}
