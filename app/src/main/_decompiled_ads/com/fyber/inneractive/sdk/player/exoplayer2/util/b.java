package com.fyber.inneractive.sdk.player.exoplayer2.util;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f1227b;

    public static final class a extends OutputStream {
        public final FileOutputStream a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1228b = false;

        public a(File file) throws FileNotFoundException {
            this.a = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f1228b) {
                return;
            }
            this.f1228b = true;
            this.a.flush();
            try {
                this.a.getFD().sync();
            } catch (IOException e) {
                Log.w("AtomicFile", "Failed to sync file descriptor:", e);
            }
            this.a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.a.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.a.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.a.write(bArr, i, i2);
        }
    }

    public b(File file) {
        this.a = file;
        this.f1227b = new File(file.getPath() + ".bak");
    }

    public InputStream a() throws FileNotFoundException {
        if (this.f1227b.exists()) {
            this.a.delete();
            this.f1227b.renameTo(this.a);
        }
        return new FileInputStream(this.a);
    }

    public OutputStream b() throws IOException {
        if (this.a.exists()) {
            if (this.f1227b.exists()) {
                this.a.delete();
            } else if (!this.a.renameTo(this.f1227b)) {
                Log.w("AtomicFile", "Couldn't rename file " + this.a + " to backup file " + this.f1227b);
            }
        }
        try {
            return new a(this.a);
        } catch (FileNotFoundException unused) {
            if (!this.a.getParentFile().mkdirs()) {
                throw new IOException("Couldn't create directory " + this.a);
            }
            try {
                return new a(this.a);
            } catch (FileNotFoundException unused2) {
                throw new IOException("Couldn't create " + this.a);
            }
        }
    }
}
