package com.fyber.inneractive.sdk.player.cache;

import com.fyber.inneractive.sdk.util.IAlog;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Closeable {
    public static final Pattern p = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream q = new b();
    public final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f1004b;
    public final File c;
    public final File d;
    public final int e;
    public long f;
    public final int g;
    public Writer i;
    public int k;
    public e l;
    public long h = 0;
    public final LinkedHashMap<String, d> j = new LinkedHashMap<>(0, 0.75f, true);
    public long m = 0;
    public final ThreadPoolExecutor n = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public final Callable<Void> o = new a();

    public class a implements Callable<Void> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (c.this) {
                c cVar = c.this;
                if (cVar.i == null) {
                    return null;
                }
                cVar.f();
                if (c.this.b()) {
                    c.this.e();
                    c.this.k = 0;
                }
                return null;
            }
        }
    }

    public class b extends OutputStream {
        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    }

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.cache.c$c, reason: collision with other inner class name */
    public final class C0277c {
        public final d a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f1005b;
        public boolean c;

        public C0277c(d dVar) {
            this.a = dVar;
            this.f1005b = dVar.c ? null : new boolean[c.this.g];
        }

        public OutputStream a(int i) throws IOException {
            FileOutputStream fileOutputStream;
            a aVar;
            if (i >= 0) {
                c cVar = c.this;
                if (i < cVar.g) {
                    synchronized (cVar) {
                        d dVar = this.a;
                        if (dVar.d != this) {
                            throw new IllegalStateException();
                        }
                        if (!dVar.c) {
                            this.f1005b[i] = true;
                        }
                        File fileB = dVar.b(i);
                        try {
                            fileOutputStream = new FileOutputStream(fileB);
                        } catch (FileNotFoundException unused) {
                            c.this.a.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(fileB);
                            } catch (FileNotFoundException unused2) {
                                return c.q;
                            }
                        }
                        aVar = new a(fileOutputStream);
                    }
                    return aVar;
                }
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + c.this.g);
        }

        /* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.cache.c$c$a */
        public class a extends FilterOutputStream {
            public a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0277c.this.c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0277c.this.c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    C0277c.this.c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0277c.this.c = true;
                }
            }
        }

        public void a() throws IOException {
            c.a(c.this, this, false);
        }
    }

    public final class d {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f1006b;
        public boolean c;
        public C0277c d;
        public long e;

        public d(String str) {
            this.a = str;
            this.f1006b = new long[c.this.g];
        }

        public File b(int i) {
            return new File(c.this.a, this.a + "." + i + ".tmp");
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.f1006b) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        public File a(int i) {
            return new File(c.this.a, this.a + "." + i);
        }
    }

    public interface e {
    }

    public final class f implements Closeable {
        public final InputStream[] a;

        public f(c cVar, String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.a = inputStreamArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.a) {
                m.a(inputStream);
            }
        }
    }

    public c(File file, int i, int i2, long j) {
        this.a = file;
        this.e = i;
        this.f1004b = new File(file, "journal");
        this.c = new File(file, "journal.tmp");
        this.d = new File(file, "journal.bkp");
        this.g = i2;
        this.f = j;
    }

    public synchronized f b(String str) throws IOException {
        a();
        e(str);
        d dVar = this.j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.c) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.g];
        for (int i = 0; i < this.g; i++) {
            try {
                inputStreamArr[i] = new FileInputStream(dVar.a(i));
            } catch (FileNotFoundException unused) {
                for (int i2 = 0; i2 < this.g && inputStreamArr[i2] != null; i2++) {
                    m.a(inputStreamArr[i2]);
                }
                return null;
            }
        }
        this.k++;
        this.i.append((CharSequence) ("READ " + str + '\n'));
        if (b()) {
            this.n.submit(this.o);
        }
        return new f(this, str, dVar.e, inputStreamArr, dVar.f1006b);
    }

    public final void c(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        d dVar = this.j.get(strSubstring);
        if (dVar == null) {
            dVar = new d(strSubstring);
            this.j.put(strSubstring, dVar);
        }
        if (iIndexOf2 == -1 || iIndexOf != 5 || !str.startsWith("CLEAN")) {
            if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
                dVar.d = new C0277c(dVar);
                return;
            } else {
                if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: " + str);
                }
                return;
            }
        }
        String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
        dVar.c = true;
        dVar.d = null;
        if (strArrSplit.length != c.this.g) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
        }
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            try {
                dVar.f1006b[i2] = Long.parseLong(strArrSplit[i2]);
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.i == null) {
            return;
        }
        Iterator it = new ArrayList(this.j.values()).iterator();
        while (it.hasNext()) {
            C0277c c0277c = ((d) it.next()).d;
            if (c0277c != null) {
                c0277c.a();
            }
        }
        f();
        this.i.close();
        this.i = null;
    }

    public final void d() throws IOException {
        l lVar = new l(new FileInputStream(this.f1004b), 8192, m.a);
        try {
            String strB = lVar.b();
            String strB2 = lVar.b();
            String strB3 = lVar.b();
            String strB4 = lVar.b();
            String strB5 = lVar.b();
            if (!"libcore.io.DiskLruCache".equals(strB) || !"1".equals(strB2) || !Integer.toString(this.e).equals(strB3) || !Integer.toString(this.g).equals(strB4) || !"".equals(strB5)) {
                throw new IOException("unexpected journal header: [" + strB + ", " + strB2 + ", " + strB4 + ", " + strB5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    c(lVar.b());
                    i++;
                } catch (EOFException unused) {
                    this.k = i - this.j.size();
                    if (lVar.e == -1) {
                        e();
                    } else {
                        this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f1004b, true), m.a));
                    }
                    m.a(lVar);
                    return;
                }
            }
        } catch (Throwable th) {
            m.a(lVar);
            throw th;
        }
    }

    public final synchronized void e() throws IOException {
        try {
            Writer writer = this.i;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), m.a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.e));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.g));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d dVar : this.j.values()) {
                    if (dVar.d != null) {
                        bufferedWriter.write("DIRTY " + dVar.a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + dVar.a + dVar.a() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.f1004b.exists()) {
                    a(this.f1004b, this.d, true);
                }
                a(this.c, this.f1004b, false);
                this.d.delete();
                this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f1004b, true), m.a));
            } catch (Throwable th) {
                bufferedWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void f() throws IOException {
        while (this.h > this.f) {
            String key = this.j.entrySet().iterator().next().getKey();
            e eVar = this.l;
            if (eVar == null) {
                d(key);
            } else if (((n) eVar).a(this, key)) {
                d(key);
            } else {
                boolean zD = false;
                for (String str : this.j.keySet()) {
                    if (((n) this.l).a(this, str)) {
                        zD |= d(str);
                    }
                }
                if (!zD) {
                    return;
                }
            }
        }
    }

    public static void a(c cVar, C0277c c0277c, boolean z) throws IOException {
        synchronized (cVar) {
            d dVar = c0277c.a;
            if (dVar.d != c0277c) {
                throw new IllegalStateException();
            }
            if (z && !dVar.c) {
                for (int i = 0; i < cVar.g; i++) {
                    if (!c0277c.f1005b[i]) {
                        c0277c.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                    if (!dVar.b(i).exists()) {
                        c0277c.a();
                        return;
                    }
                }
            }
            for (int i2 = 0; i2 < cVar.g; i2++) {
                File fileB = dVar.b(i2);
                if (!z) {
                    a(fileB);
                } else if (fileB.exists()) {
                    File fileA = dVar.a(i2);
                    fileB.renameTo(fileA);
                    long j = dVar.f1006b[i2];
                    long length = fileA.length();
                    dVar.f1006b[i2] = length;
                    cVar.h = (cVar.h - j) + length;
                }
            }
            cVar.k++;
            dVar.d = null;
            if (dVar.c || z) {
                dVar.c = true;
                cVar.i.write("CLEAN " + dVar.a + dVar.a() + '\n');
                if (z) {
                    long j2 = cVar.m;
                    cVar.m = 1 + j2;
                    dVar.e = j2;
                }
            } else {
                cVar.j.remove(dVar.a);
                cVar.i.write("REMOVE " + dVar.a + '\n');
            }
            cVar.i.flush();
            if (cVar.h > cVar.f || cVar.b()) {
                cVar.n.submit(cVar.o);
            }
        }
    }

    public final boolean b() {
        int i = this.k;
        return i >= 2000 && i >= this.j.size();
    }

    public final void e(String str) {
        if (!p.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public final void c() throws IOException {
        a(this.c);
        Iterator<d> it = this.j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i = 0;
            if (next.d == null) {
                while (i < this.g) {
                    this.h += next.f1006b[i];
                    i++;
                }
            } else {
                next.d = null;
                while (i < this.g) {
                    a(next.a(i));
                    a(next.b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    public synchronized boolean d(String str) throws IOException {
        IAlog.d("DiskLruCache remove %s", str);
        a();
        e(str);
        d dVar = this.j.get(str);
        if (dVar != null && dVar.d == null) {
            for (int i = 0; i < this.g; i++) {
                File fileA = dVar.a(i);
                if (fileA.exists() && !fileA.delete()) {
                    throw new IOException("failed to delete " + fileA);
                }
                long j = this.h;
                long[] jArr = dVar.f1006b;
                this.h = j - jArr[i];
                jArr[i] = 0;
            }
            this.k++;
            this.i.append((CharSequence) ("REMOVE " + str + '\n'));
            this.j.remove(str);
            if (b()) {
                this.n.submit(this.o);
            }
            return true;
        }
        return false;
    }

    public static c a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            c cVar = new c(file, i, i2, j);
            if (cVar.f1004b.exists()) {
                try {
                    cVar.d();
                    cVar.c();
                    return cVar;
                } catch (IOException e2) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    IAlog.d("DiskLruCache delete cache", new Object[0]);
                    cVar.close();
                    m.a(cVar.a);
                }
            }
            file.mkdirs();
            c cVar2 = new c(file, i, i2, j);
            cVar2.e();
            return cVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    public static void a(File file) throws IOException {
        IAlog.d("DiskLruCache deleteIfExists - %s", file);
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public File a(String str, int i) {
        a();
        e(str);
        d dVar = this.j.get(str);
        if (dVar == null) {
            return null;
        }
        return dVar.a(i);
    }

    public C0277c a(String str) throws IOException {
        synchronized (this) {
            a();
            e(str);
            d dVar = this.j.get(str);
            if (dVar == null) {
                dVar = new d(str);
                this.j.put(str, dVar);
            } else if (dVar.d != null) {
                return null;
            }
            C0277c c0277c = new C0277c(dVar);
            dVar.d = c0277c;
            this.i.write("DIRTY " + str + '\n');
            this.i.flush();
            return c0277c;
        }
    }

    public final void a() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }
}
