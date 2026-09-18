package b.b.a.a.h.x.i.d;

import android.util.Log;
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
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: DiskLruCache.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Closeable {
    static final Pattern p = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream q = new b();
    private final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f181b;
    private final File c;
    private final File d;
    private final int e;
    private long f;
    private final int g;
    private Writer i;
    private int k;
    final ExecutorService n;
    private long h = 0;
    private final LinkedHashMap<String, d> j = new LinkedHashMap<>(0, 0.75f, true);
    private long l = -1;
    private long m = 0;
    private final Callable<Void> o = new CallableC0037a();

    /* JADX INFO: renamed from: b.b.a.a.h.x.i.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiskLruCache.java */
    class CallableC0037a implements Callable<Void> {
        CallableC0037a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.i == null) {
                    return null;
                }
                a.this.h();
                if (a.this.d()) {
                    a.this.g();
                    a.this.k = 0;
                }
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    static class b extends OutputStream {
        b() {
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    public final class c {
        private final d a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean[] f182b;
        private boolean c;

        /* JADX INFO: renamed from: b.b.a.a.h.x.i.d.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DiskLruCache.java */
        private class C0038a extends FilterOutputStream {
            /* synthetic */ C0038a(c cVar, OutputStream outputStream, CallableC0037a callableC0037a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    c.this.c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    c.this.c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    c.this.c = true;
                }
            }

            private C0038a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    c.this.c = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0037a callableC0037a) {
            this(dVar);
        }

        private c(d dVar) {
            this.a = dVar;
            this.f182b = dVar.c ? null : new boolean[a.this.g];
        }

        public void b() throws IOException {
            if (!this.c) {
                a.this.a(this, true);
            } else {
                a.this.a(this, false);
                a.this.d(this.a.a);
            }
        }

        public OutputStream a(int i) throws IOException {
            FileOutputStream fileOutputStream;
            C0038a c0038a;
            if (i >= 0 && i < a.this.g) {
                synchronized (a.this) {
                    if (this.a.d == this) {
                        if (!this.a.c) {
                            this.f182b[i] = true;
                        }
                        File fileB = this.a.b(i);
                        try {
                            fileOutputStream = new FileOutputStream(fileB);
                        } catch (FileNotFoundException unused) {
                            a.this.a.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(fileB);
                            } catch (FileNotFoundException unused2) {
                                return a.q;
                            }
                        }
                        c0038a = new C0038a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return c0038a;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.g);
        }

        public void a() throws IOException {
            a.this.a(this, false);
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    private final class d {
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long[] f183b;
        private boolean c;
        private c d;
        private long e;

        /* synthetic */ d(a aVar, String str, CallableC0037a callableC0037a) {
            this(str);
        }

        private d(String str) {
            this.a = str;
            this.f183b = new long[a.this.g];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) throws IOException {
            if (strArr.length != a.this.g) {
                a(strArr);
                throw null;
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f183b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    a(strArr);
                    throw null;
                }
            }
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.f183b) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i) {
            return new File(a.this.a, this.a + "." + i);
        }

        public File b(int i) {
            return new File(a.this.a, this.a + "." + i + ".tmp");
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    public final class e implements Closeable {
        private final InputStream[] a;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0037a callableC0037a) {
            this(aVar, str, j, inputStreamArr, jArr);
        }

        public InputStream a(int i) {
            return this.a[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.a) {
                b.b.a.a.h.x.k.b.a(inputStream);
            }
        }

        private e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.a = inputStreamArr;
        }
    }

    private a(File file, int i, int i2, long j, ExecutorService executorService) {
        this.a = file;
        this.e = i;
        this.f181b = new File(file, "journal");
        this.c = new File(file, "journal.tmp");
        this.d = new File(file, "journal.bkp");
        this.g = i2;
        this.f = j;
        this.n = executorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g() throws IOException {
        Writer writer = this.i;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), b.b.a.a.h.x.i.d.d.a));
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
            if (this.f181b.exists()) {
                a(this.f181b, this.d, true);
            }
            a(this.c, this.f181b, false);
            this.d.delete();
            this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f181b, true), b.b.a.a.h.x.i.d.d.a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() throws IOException {
        long j = this.f;
        long j2 = this.l;
        if (j2 >= 0) {
            j = j2;
        }
        while (this.h > j) {
            d(this.j.entrySet().iterator().next().getKey());
        }
        this.l = -1L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.i == null) {
            return;
        }
        for (d dVar : new ArrayList(this.j.values())) {
            if (dVar.d != null) {
                dVar.d.a();
            }
        }
        h();
        this.i.close();
        this.i = null;
    }

    private void c(String str) throws IOException {
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
        CallableC0037a callableC0037a = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, callableC0037a);
            this.j.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.c = true;
            dVar.d = null;
            dVar.b(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.d = new c(this, dVar, callableC0037a);
        } else if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        int i = this.k;
        return i >= 2000 && i >= this.j.size();
    }

    private void e() throws IOException {
        a(this.c);
        Iterator<d> it = this.j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i = 0;
            if (next.d == null) {
                while (i < this.g) {
                    this.h += next.f183b[i];
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

    private void f() throws IOException {
        b.b.a.a.h.x.i.d.c cVar = new b.b.a.a.h.x.i.d.c(new FileInputStream(this.f181b), b.b.a.a.h.x.i.d.d.a);
        try {
            String strC = cVar.c();
            String strC2 = cVar.c();
            String strC3 = cVar.c();
            String strC4 = cVar.c();
            String strC5 = cVar.c();
            if (!"libcore.io.DiskLruCache".equals(strC) || !"1".equals(strC2) || !Integer.toString(this.e).equals(strC3) || !Integer.toString(this.g).equals(strC4) || !"".equals(strC5)) {
                throw new IOException("unexpected journal header: [" + strC + ", " + strC2 + ", " + strC4 + ", " + strC5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    c(cVar.c());
                    i++;
                } catch (EOFException unused) {
                    this.k = i - this.j.size();
                    if (cVar.b()) {
                        g();
                    } else {
                        this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f181b, true), b.b.a.a.h.x.i.d.d.a));
                    }
                    b.b.a.a.h.x.k.b.a(cVar);
                    return;
                }
            }
        } catch (Throwable th) {
            b.b.a.a.h.x.k.b.a(cVar);
            throw th;
        }
    }

    public synchronized e b(String str) throws IOException {
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
                    b.b.a.a.h.x.k.b.a(inputStreamArr[i2]);
                }
                return null;
            }
        }
        this.k++;
        this.i.append((CharSequence) ("READ " + str + '\n'));
        if (d()) {
            this.n.submit(this.o);
        }
        return new e(this, str, dVar.e, inputStreamArr, dVar.f183b, null);
    }

    public static a a(File file, int i, int i2, long j, ExecutorService executorService) throws IOException {
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
            a aVar = new a(file, i, i2, j, executorService);
            if (aVar.f181b.exists()) {
                try {
                    aVar.f();
                    aVar.e();
                    return aVar;
                } catch (IOException e2) {
                    Log.w("DiskLruCache ", file + " is corrupt: " + e2.getMessage() + ", removing");
                    aVar.b();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i, i2, j, executorService);
            aVar2.g();
            return aVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    public synchronized boolean d(String str) throws IOException {
        a();
        e(str);
        d dVar = this.j.get(str);
        if (dVar != null && dVar.d == null) {
            for (int i = 0; i < this.g; i++) {
                File fileA = dVar.a(i);
                if (fileA.exists() && !fileA.delete()) {
                    throw new IOException("failed to delete " + fileA);
                }
                this.h -= dVar.f183b[i];
                dVar.f183b[i] = 0;
            }
            this.k++;
            this.i.append((CharSequence) ("REMOVE " + str + '\n'));
            this.j.remove(str);
            if (d()) {
                this.n.submit(this.o);
            }
            return true;
        }
        return false;
    }

    private void e(String str) {
        if (!p.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public synchronized void c() throws IOException {
        a();
        h();
        this.i.flush();
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public void b() throws IOException {
        close();
        b.b.a.a.h.x.i.d.d.a(this.a);
    }

    public c a(String str) throws IOException {
        return a(str, -1L);
    }

    private synchronized c a(String str, long j) throws IOException {
        a();
        e(str);
        d dVar = this.j.get(str);
        CallableC0037a callableC0037a = null;
        if (j != -1 && (dVar == null || dVar.e != j)) {
            return null;
        }
        if (dVar != null) {
            if (dVar.d != null) {
                return null;
            }
        } else {
            dVar = new d(this, str, callableC0037a);
            this.j.put(str, dVar);
        }
        c cVar = new c(this, dVar, callableC0037a);
        dVar.d = cVar;
        this.i.write("DIRTY " + str + '\n');
        this.i.flush();
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z) throws IOException {
        d dVar = cVar.a;
        if (dVar.d == cVar) {
            if (z && !dVar.c) {
                for (int i = 0; i < this.g; i++) {
                    if (cVar.f182b[i]) {
                        if (!dVar.b(i).exists()) {
                            cVar.a();
                            return;
                        }
                    } else {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.g; i2++) {
                File fileB = dVar.b(i2);
                if (z) {
                    if (fileB.exists()) {
                        File fileA = dVar.a(i2);
                        fileB.renameTo(fileA);
                        long j = dVar.f183b[i2];
                        long length = fileA.length();
                        dVar.f183b[i2] = length;
                        this.h = (this.h - j) + length;
                    }
                } else {
                    a(fileB);
                }
            }
            this.k++;
            dVar.d = null;
            if (!(dVar.c | z)) {
                this.j.remove(dVar.a);
                this.i.write("REMOVE " + dVar.a + '\n');
            } else {
                dVar.c = true;
                this.i.write("CLEAN " + dVar.a + dVar.a() + '\n');
                if (z) {
                    long j2 = this.m;
                    this.m = 1 + j2;
                    dVar.e = j2;
                }
            }
            this.i.flush();
            if (this.h > this.f || d()) {
                this.n.submit(this.o);
            }
            return;
        }
        throw new IllegalStateException();
    }

    private void a() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }
}
