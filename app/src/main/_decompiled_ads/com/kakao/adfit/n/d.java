package com.kakao.adfit.n;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DiskBasedCache.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements com.kakao.adfit.common.volley.a {
    private final Map<String, a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1854b;
    private final c c;
    private final int d;

    /* JADX INFO: compiled from: DiskBasedCache.java */
    public interface c {
        File get();
    }

    public d(c cVar, int i) {
        this.a = new LinkedHashMap(16, 0.75f, true);
        this.f1854b = 0L;
        this.c = cVar;
        this.d = i;
    }

    private String c(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    private void e(String str) {
        a aVarRemove = this.a.remove(str);
        if (aVarRemove != null) {
            this.f1854b -= aVarRemove.a;
        }
    }

    @Override // com.kakao.adfit.common.volley.a
    public synchronized com.kakao.adfit.common.volley.a.C0448a a(String str) {
        a aVar = this.a.get(str);
        if (aVar == null) {
            return null;
        }
        File fileB = b(str);
        try {
            b bVar = new b(new BufferedInputStream(a(fileB)), fileB.length());
            try {
                a aVarA = a.a(bVar);
                if (TextUtils.equals(str, aVarA.f1855b)) {
                    com.kakao.adfit.common.volley.a.C0448a c0448aA = aVar.a(a(bVar, bVar.a()));
                    bVar.close();
                    return c0448aA;
                }
                com.kakao.adfit.common.volley.h.b("%s: key=%s, found=%s", fileB.getAbsolutePath(), str, aVarA.f1855b);
                e(str);
                bVar.close();
                return null;
            } catch (Throwable th) {
                bVar.close();
                throw th;
            }
        } catch (IOException e) {
            com.kakao.adfit.common.volley.h.b("%s: %s", fileB.getAbsolutePath(), e.toString());
            d(str);
            return null;
        }
    }

    public File b(String str) {
        return new File(this.c.get(), c(str));
    }

    public synchronized void d(String str) {
        boolean zDelete = b(str).delete();
        e(str);
        if (!zDelete) {
            com.kakao.adfit.common.volley.h.b("Could not delete cache entry for key=%s, filename=%s", str, c(str));
        }
    }

    private void b() {
        if (this.c.get().exists()) {
            return;
        }
        com.kakao.adfit.common.volley.h.b("Re-initializing cache after external clearing.", new Object[0]);
        this.a.clear();
        this.f1854b = 0L;
        a();
    }

    /* JADX INFO: compiled from: DiskBasedCache.java */
    static class b extends FilterInputStream {
        private final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f1856b;

        b(InputStream inputStream, long j) {
            super(inputStream);
            this.a = j;
        }

        long a() {
            return this.a - this.f1856b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i = super.read();
            if (i != -1) {
                this.f1856b++;
            }
            return i;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = super.read(bArr, i, i2);
            if (i3 != -1) {
                this.f1856b += (long) i3;
            }
            return i3;
        }
    }

    private void c() {
        if (this.f1854b < this.d) {
            return;
        }
        if (com.kakao.adfit.common.volley.h.f1727b) {
            com.kakao.adfit.common.volley.h.d("Pruning old cache entries.", new Object[0]);
        }
        long j = this.f1854b;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.a.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (b(value.f1855b).delete()) {
                this.f1854b -= value.a;
            } else {
                String str = value.f1855b;
                com.kakao.adfit.common.volley.h.b("Could not delete cache entry for key=%s, filename=%s", str, c(str));
            }
            it.remove();
            i++;
            if (this.f1854b < this.d * 0.9f) {
                break;
            }
        }
        if (com.kakao.adfit.common.volley.h.f1727b) {
            com.kakao.adfit.common.volley.h.d("pruned %d files, %d bytes, %d ms", Integer.valueOf(i), Long.valueOf(this.f1854b - j), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
    }

    /* JADX INFO: compiled from: DiskBasedCache.java */
    static class a {
        long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f1855b;
        final String c;
        final long d;
        final long e;
        final long f;
        final long g;
        final List<com.kakao.adfit.m.b> h;

        private a(String str, String str2, long j, long j2, long j3, long j4, List<com.kakao.adfit.m.b> list) {
            this.f1855b = str;
            this.c = "".equals(str2) ? null : str2;
            this.d = j;
            this.e = j2;
            this.f = j3;
            this.g = j4;
            this.h = list;
        }

        private static List<com.kakao.adfit.m.b> a(com.kakao.adfit.common.volley.a.C0448a c0448a) {
            List<com.kakao.adfit.m.b> list = c0448a.h;
            return list != null ? list : e.b(c0448a.g);
        }

        static a a(b bVar) throws IOException {
            if (d.b((InputStream) bVar) == 538247942) {
                return new a(d.b(bVar), d.b(bVar), d.c(bVar), d.c(bVar), d.c(bVar), d.c(bVar), d.a(bVar));
            }
            throw new IOException();
        }

        a(String str, com.kakao.adfit.common.volley.a.C0448a c0448a) {
            this(str, c0448a.f1716b, c0448a.c, c0448a.d, c0448a.e, c0448a.f, a(c0448a));
        }

        com.kakao.adfit.common.volley.a.C0448a a(byte[] bArr) {
            com.kakao.adfit.common.volley.a.C0448a c0448a = new com.kakao.adfit.common.volley.a.C0448a();
            c0448a.a = bArr;
            c0448a.f1716b = this.c;
            c0448a.c = this.d;
            c0448a.d = this.e;
            c0448a.e = this.f;
            c0448a.f = this.g;
            c0448a.g = e.a(this.h);
            c0448a.h = Collections.unmodifiableList(this.h);
            return c0448a;
        }

        boolean a(OutputStream outputStream) {
            try {
                d.a(outputStream, 538247942);
                d.a(outputStream, this.f1855b);
                String str = this.c;
                if (str == null) {
                    str = "";
                }
                d.a(outputStream, str);
                d.a(outputStream, this.d);
                d.a(outputStream, this.e);
                d.a(outputStream, this.f);
                d.a(outputStream, this.g);
                d.a(this.h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                com.kakao.adfit.common.volley.h.b("%s", e.toString());
                return false;
            }
        }
    }

    OutputStream b(File file) {
        return new FileOutputStream(file);
    }

    static int b(InputStream inputStream) {
        return (a(inputStream) << 24) | (a(inputStream) << 0) | 0 | (a(inputStream) << 8) | (a(inputStream) << 16);
    }

    static String b(b bVar) {
        return new String(a(bVar, c(bVar)), "UTF-8");
    }

    @Override // com.kakao.adfit.common.volley.a
    public synchronized void a() {
        File file = this.c.get();
        if (!file.exists()) {
            if (!file.mkdirs()) {
                com.kakao.adfit.common.volley.h.c("Unable to create cache dir %s", file.getAbsolutePath());
            }
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            try {
                long length = file2.length();
                b bVar = new b(new BufferedInputStream(a(file2)), length);
                try {
                    a aVarA = a.a(bVar);
                    aVarA.a = length;
                    a(aVarA.f1855b, aVarA);
                    bVar.close();
                } catch (Throwable th) {
                    bVar.close();
                    throw th;
                }
            } catch (IOException unused) {
                file2.delete();
            }
        }
    }

    static long c(InputStream inputStream) {
        return ((((long) a(inputStream)) & 255) << 0) | 0 | ((((long) a(inputStream)) & 255) << 8) | ((((long) a(inputStream)) & 255) << 16) | ((((long) a(inputStream)) & 255) << 24) | ((((long) a(inputStream)) & 255) << 32) | ((((long) a(inputStream)) & 255) << 40) | ((((long) a(inputStream)) & 255) << 48) | ((255 & ((long) a(inputStream))) << 56);
    }

    public d(c cVar) {
        this(cVar, 5242880);
    }

    @Override // com.kakao.adfit.common.volley.a
    public synchronized void a(String str, boolean z) {
        com.kakao.adfit.common.volley.a.C0448a c0448aA = a(str);
        if (c0448aA != null) {
            c0448aA.f = 0L;
            if (z) {
                c0448aA.e = 0L;
            }
            a(str, c0448aA);
        }
    }

    @Override // com.kakao.adfit.common.volley.a
    public synchronized void a(String str, com.kakao.adfit.common.volley.a.C0448a c0448a) {
        long j = this.f1854b;
        byte[] bArr = c0448a.a;
        long length = j + ((long) bArr.length);
        int i = this.d;
        if (length > i && bArr.length > i * 0.9f) {
            return;
        }
        File fileB = b(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(b(fileB));
            a aVar = new a(str, c0448a);
            if (aVar.a(bufferedOutputStream)) {
                bufferedOutputStream.write(c0448a.a);
                bufferedOutputStream.close();
                aVar.a = fileB.length();
                a(str, aVar);
                c();
                return;
            }
            bufferedOutputStream.close();
            com.kakao.adfit.common.volley.h.b("Failed to write header for %s", fileB.getAbsolutePath());
            throw new IOException();
        } catch (IOException unused) {
            if (!fileB.delete()) {
                com.kakao.adfit.common.volley.h.b("Could not clean up file %s", fileB.getAbsolutePath());
            }
            b();
        }
    }

    private void a(String str, a aVar) {
        if (!this.a.containsKey(str)) {
            this.f1854b += aVar.a;
        } else {
            this.f1854b += aVar.a - this.a.get(str).a;
        }
        this.a.put(str, aVar);
    }

    static byte[] a(b bVar, long j) throws IOException {
        long jA = bVar.a();
        if (j >= 0 && j <= jA) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + jA);
    }

    InputStream a(File file) {
        return new FileInputStream(file);
    }

    private static int a(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i != -1) {
            return i;
        }
        throw new EOFException();
    }

    static void a(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static void a(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        a(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static void a(List<com.kakao.adfit.m.b> list, OutputStream outputStream) throws IOException {
        if (list != null) {
            a(outputStream, list.size());
            for (com.kakao.adfit.m.b bVar : list) {
                a(outputStream, bVar.a());
                a(outputStream, bVar.b());
            }
            return;
        }
        a(outputStream, 0);
    }

    static List<com.kakao.adfit.m.b> a(b bVar) throws IOException {
        int iB = b((InputStream) bVar);
        if (iB >= 0) {
            List<com.kakao.adfit.m.b> listEmptyList = iB == 0 ? Collections.emptyList() : new ArrayList<>();
            for (int i = 0; i < iB; i++) {
                listEmptyList.add(new com.kakao.adfit.m.b(b(bVar).intern(), b(bVar).intern()));
            }
            return listEmptyList;
        }
        throw new IOException("readHeaderList size=" + iB);
    }
}
