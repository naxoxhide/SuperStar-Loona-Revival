package com.tnkfactory.framework.crypto;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes4.dex */
public class EncryptOutputStream extends FilterOutputStream {
    public Cryptor a;

    public EncryptOutputStream(OutputStream outputStream, Cryptor cryptor) {
        super(outputStream);
        this.a = null;
        this.a = cryptor;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        super.write(this.a.encrypt(i));
    }
}
