package com.tnkfactory.framework.crypto;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class DecryptInputStream extends FilterInputStream {
    public Cryptor a;

    public DecryptInputStream(InputStream inputStream, Cryptor cryptor) {
        super(inputStream);
        this.a = null;
        this.a = cryptor;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        return this.a.decrypt(super.read());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = super.read(bArr, i, i2);
        if (i3 > 0) {
            this.a.decrypt(bArr, i, i3);
        }
        return i3;
    }
}
