package b.b.a.a.j.d;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import b.b.a.a.f.a.f;
import b.b.a.a.f.a.j;
import b.b.a.a.f.a.l;
import b.b.a.a.f.a.n;
import com.adxcorp.util.ADXLogUtil;
import com.google.common.net.HttpHeaders;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: DownloadExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends c {
    public File e;
    public File f;

    public a(j jVar) {
        super(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long e(Map<String, String> map) {
        String str;
        if (map.containsKey("content-length")) {
            str = map.get("content-length");
        } else {
            str = map.containsKey(HttpHeaders.CONTENT_LENGTH) ? map.get(HttpHeaders.CONTENT_LENGTH) : null;
        }
        if (TextUtils.isEmpty(str) || str == null) {
            return 0L;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(Map<String, String> map) {
        return TextUtils.equals(map.get(HttpHeaders.CONTENT_ENCODING), "gzip");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g(Map<String, String> map) {
        if (TextUtils.equals(map.get(HttpHeaders.ACCEPT_RANGES), "bytes") || TextUtils.equals(map.get("accept-ranges"), "bytes")) {
            return true;
        }
        String str = map.get(HttpHeaders.CONTENT_RANGE);
        if (TextUtils.isEmpty(str)) {
            str = map.get("content-range");
        }
        return str != null && str.startsWith("bytes");
    }

    public void a(b.b.a.a.j.c.a aVar) {
        File file = this.e;
        if (file == null || this.f == null) {
            if (aVar != null) {
                aVar.a(this, new IOException("File info is null, please exec setFileInfo(String dir, String fileName)"));
                return;
            }
            return;
        }
        if (file.exists() && this.e.length() != 0 && aVar != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            b.b.a.a.j.b bVar = new b.b.a.a.j.b(true, 200, ADXLogUtil.EVENT_LOAD_SUCCESS, null, null, jCurrentTimeMillis, jCurrentTimeMillis);
            bVar.a(this.e);
            aVar.a(this, bVar);
            return;
        }
        long length = this.f.length();
        long j = length >= 0 ? length : 0L;
        l.a aVar2 = new l.a();
        aVar2.a((Object) a());
        a("Range", "bytes=" + j + "-");
        if (TextUtils.isEmpty(this.d)) {
            aVar.a(this, new IOException("Url is Empty"));
            return;
        }
        try {
            aVar2.a(this.d);
            a(aVar2);
            this.a.a(aVar2.b().a()).a(new C0044a(aVar, j));
        } catch (IllegalArgumentException unused) {
            aVar.a(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }

    public void b(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.e = new File(str, str2);
        this.f = new File(str, str2 + ".temp");
    }

    public b.b.a.a.j.b c() {
        RandomAccessFile randomAccessFile;
        long j;
        InputStream inputStreamA;
        int i;
        String str;
        File file = this.e;
        if (file == null || this.f == null) {
            return null;
        }
        if (file.exists() && this.e.length() != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            b.b.a.a.j.b bVar = new b.b.a.a.j.b(true, 200, ADXLogUtil.EVENT_LOAD_SUCCESS, null, null, jCurrentTimeMillis, jCurrentTimeMillis);
            bVar.a(this.e);
            return bVar;
        }
        long length = this.f.length();
        if (length < 0) {
            length = 0;
        }
        l.a aVar = new l.a();
        aVar.a((Object) a());
        a("Range", "bytes=" + length + "-");
        String str2 = "DownloadExecutor";
        if (TextUtils.isEmpty(this.d)) {
            Log.e("DownloadExecutor", "execute: Url is Empty");
            return null;
        }
        try {
            aVar.a(this.d);
            a(aVar);
            try {
                n nVarB = this.a.a(aVar.b().a()).b();
                if (nVarB == null || !nVarB.d()) {
                    return null;
                }
                HashMap map = new HashMap();
                f fVarC = nVarB.c();
                if (fVarC != null) {
                    for (int i2 = 0; i2 < fVarC.a(); i2++) {
                        map.put(fVarC.a(i2), fVarC.b(i2));
                    }
                }
                b.b.a.a.j.b bVar2 = new b.b.a.a.j.b(nVarB.d(), nVarB.b(), nVarB.e(), map, null, nVarB.h(), nVarB.g());
                long jC = nVarB.a().c();
                if (jC <= 0) {
                    jC = e(map);
                }
                long length2 = this.f.length();
                boolean zG = g(map);
                if (zG) {
                    jC += length2;
                    String str3 = (String) map.get(HttpHeaders.CONTENT_RANGE);
                    if (!TextUtils.isEmpty(str3)) {
                        String str4 = "bytes " + length2 + "-" + (jC - 1);
                        if (TextUtils.indexOf(str3, str4) == -1) {
                            b.b.a.a.j.f.d.a("DownloadExecutor", "execute: The Content-Range Header is invalid Assume[" + str4 + "] vs Real[" + str3 + "], please remove the temporary file [" + this.f + "].");
                            b();
                            return null;
                        }
                    }
                }
                if (jC > 0 && this.f.exists() && this.f.length() == jC) {
                    if (this.f.renameTo(this.e)) {
                        bVar2.a(this.e);
                        return bVar2;
                    }
                    b.b.a.a.j.f.d.a("DownloadExecutor", "Rename fail");
                    return null;
                }
                try {
                    randomAccessFile = new RandomAccessFile(this.f, "rw");
                    try {
                        if (zG) {
                            randomAccessFile.seek(length);
                            j = length;
                        } else {
                            randomAccessFile.setLength(0L);
                            j = 0;
                        }
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    randomAccessFile = null;
                }
                try {
                    inputStreamA = nVarB.a().a();
                    try {
                        if (f(map) && !(inputStreamA instanceof GZIPInputStream)) {
                            inputStreamA = new GZIPInputStream(inputStreamA);
                        }
                        byte[] bArr = new byte[16384];
                        int i3 = 0;
                        long j2 = 0;
                        while (true) {
                            i = inputStreamA.read(bArr, i3, 16384 - i3);
                            boolean z = true;
                            str = str2;
                            if (i == -1) {
                                break;
                            }
                            i3 += i;
                            long j3 = jC;
                            j2 += (long) i;
                            if (j2 % PlaybackStateCompat.ACTION_PREPARE != 0 && j2 != j3 - length) {
                                z = false;
                            }
                            if (z) {
                                randomAccessFile.seek(j);
                                randomAccessFile.write(bArr, 0, i3);
                                j += (long) i3;
                                i3 = 0;
                            }
                            str2 = str;
                            jC = j3;
                        }
                        long j4 = jC;
                        if (i != 0) {
                            randomAccessFile.seek(j);
                            randomAccessFile.write(bArr, 0, i3);
                        }
                        long length3 = (!zG || length == 0) ? this.f.length() : j4;
                        if (length3 <= 0 || !this.f.exists() || this.f.length() != length3) {
                            b.b.a.a.j.f.d.a(str, " tempFile.length() == fileSize is" + (this.f.length() == length3));
                            if (inputStreamA != null) {
                                try {
                                    inputStreamA.close();
                                } catch (Throwable unused3) {
                                    b.b.a.a.j.f.d.a("Error occured when calling InputStream.close");
                                }
                            }
                            try {
                                randomAccessFile.close();
                                return null;
                            } catch (Throwable unused4) {
                                b.b.a.a.j.f.d.a("Error occured when calling tmpFile.close");
                                return null;
                            }
                        }
                        if (this.f.renameTo(this.e)) {
                            bVar2.a(this.e);
                            if (inputStreamA != null) {
                                try {
                                    inputStreamA.close();
                                } catch (Throwable unused5) {
                                    b.b.a.a.j.f.d.a("Error occured when calling InputStream.close");
                                }
                            }
                            try {
                                randomAccessFile.close();
                            } catch (Throwable unused6) {
                                b.b.a.a.j.f.d.a("Error occured when calling tmpFile.close");
                            }
                            return bVar2;
                        }
                        if (inputStreamA != null) {
                            try {
                                inputStreamA.close();
                            } catch (Throwable unused7) {
                                b.b.a.a.j.f.d.a("Error occured when calling InputStream.close");
                            }
                        }
                        try {
                            randomAccessFile.close();
                            return null;
                        } catch (Throwable unused8) {
                            b.b.a.a.j.f.d.a("Error occured when calling tmpFile.close");
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            b.b.a.a.j.f.d.a("Error occured when FileRequest.parseHttpResponse");
                            th.printStackTrace();
                            if (!zG) {
                                b();
                            }
                            if (inputStreamA != null) {
                                try {
                                    inputStreamA.close();
                                } catch (Throwable unused9) {
                                    b.b.a.a.j.f.d.a("Error occured when calling InputStream.close");
                                }
                            }
                            try {
                                randomAccessFile.close();
                                return null;
                            } catch (Throwable unused10) {
                                b.b.a.a.j.f.d.a("Error occured when calling tmpFile.close");
                                return null;
                            }
                        } catch (Throwable th2) {
                            if (inputStreamA != null) {
                                try {
                                    inputStreamA.close();
                                } catch (Throwable unused11) {
                                    b.b.a.a.j.f.d.a("Error occured when calling InputStream.close");
                                }
                            }
                            try {
                                randomAccessFile.close();
                                throw th2;
                            } catch (Throwable unused12) {
                                b.b.a.a.j.f.d.a("Error occured when calling tmpFile.close");
                                throw th2;
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamA = null;
                }
                e.printStackTrace();
                b();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                b();
                return null;
            }
        } catch (IllegalArgumentException unused13) {
            Log.e("DownloadExecutor", "execute: Url is not a valid HTTP or HTTPS URL");
            return null;
        }
    }

    /* JADX INFO: renamed from: b.b.a.a.j.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DownloadExecutor.java */
    class C0044a implements b.b.a.a.f.a.c {
        final /* synthetic */ b.b.a.a.j.c.a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f233b;

        C0044a(b.b.a.a.j.c.a aVar, long j) {
            this.a = aVar;
            this.f233b = j;
        }

        @Override // b.b.a.a.f.a.c
        public void a(b.b.a.a.f.a.b bVar, IOException iOException) {
            b.b.a.a.j.c.a aVar = this.a;
            if (aVar != null) {
                aVar.a(a.this, iOException);
            }
            a.this.b();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v27, types: [b.b.a.a.j.c.a] */
        /* JADX WARN: Type inference failed for: r13v0 */
        /* JADX WARN: Type inference failed for: r13v1 */
        /* JADX WARN: Type inference failed for: r13v10 */
        /* JADX WARN: Type inference failed for: r13v11 */
        /* JADX WARN: Type inference failed for: r13v12 */
        /* JADX WARN: Type inference failed for: r13v2 */
        /* JADX WARN: Type inference failed for: r13v3 */
        /* JADX WARN: Type inference failed for: r13v6 */
        /* JADX WARN: Type inference failed for: r13v8, types: [java.io.File] */
        /* JADX WARN: Type inference failed for: r13v9 */
        /* JADX WARN: Type inference failed for: r3v5, types: [b.b.a.a.j.b] */
        /* JADX WARN: Type inference failed for: r3v9 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // b.b.a.a.f.a.c
        public void a(b.b.a.a.f.a.b bVar, n nVar) throws IOException {
            ?? r13;
            RandomAccessFile randomAccessFile;
            long j;
            ?? r14;
            String str;
            String str2;
            InputStream inputStreamA;
            byte[] bArr;
            long j2;
            int i;
            ?? r15;
            String str3 = "Error occured when calling InputStream.close";
            String str4 = "Error occured when calling tmpFile.close";
            if (this.a == null) {
                return;
            }
            HashMap map = new HashMap();
            if (nVar == null) {
                return;
            }
            f fVarC = nVar.c();
            if (fVarC != null) {
                for (int i2 = 0; i2 < fVarC.a(); i2++) {
                    map.put(fVarC.a(i2), fVarC.b(i2));
                }
            }
            b.b.a.a.j.b bVar2 = new b.b.a.a.j.b(nVar.d(), nVar.b(), nVar.e(), map, null, nVar.h(), nVar.g());
            if (nVar.d()) {
                long jC = nVar.a().c();
                if (jC <= 0) {
                    jC = a.e(map);
                }
                boolean zG = a.g(map);
                int i3 = -1;
                if (zG) {
                    jC += this.f233b;
                    String str5 = (String) map.get(HttpHeaders.CONTENT_RANGE);
                    if (!TextUtils.isEmpty(str5)) {
                        String str6 = "bytes " + this.f233b + "-" + (jC - 1);
                        if (TextUtils.indexOf(str5, str6) == -1) {
                            a.this.b();
                            this.a.a(a.this, new IOException("The Content-Range Header is invalid Assume[" + str6 + "] vs Real[" + str5 + "], please remove the temporary file [" + a.this.f + "]."));
                            return;
                        }
                    }
                }
                long j3 = jC;
                if (j3 > 0 && a.this.f.exists() && a.this.f.length() == j3) {
                    a aVar = a.this;
                    if (aVar.f.renameTo(aVar.e)) {
                        a.this.a(j3, j3, this.a);
                        bVar2.a(a.this.e);
                        this.a.a(a.this, bVar2);
                        return;
                    }
                    this.a.a(a.this, new IOException("Rename fail"));
                    return;
                }
                try {
                    r13 = a.this.f;
                    randomAccessFile = new RandomAccessFile((File) r13, "rw");
                    try {
                        try {
                            try {
                                if (zG) {
                                    r14 = bVar2;
                                    randomAccessFile.seek(this.f233b);
                                    j = this.f233b;
                                } else {
                                    r13 = bVar2;
                                    randomAccessFile.setLength(0L);
                                    j = 0;
                                    r14 = r13;
                                }
                                while (true) {
                                    int i4 = inputStreamA.read(bArr, i, 16384 - i);
                                    boolean z = true;
                                    if (i4 == i3) {
                                        break;
                                    }
                                    i += i4;
                                    long j4 = j3;
                                    long j5 = j2 + ((long) i4);
                                    if (j5 % PlaybackStateCompat.ACTION_PREPARE != 0) {
                                        str = str3;
                                        str2 = str4;
                                        try {
                                            if (j5 != j4 - this.f233b) {
                                                z = false;
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            try {
                                                b.b.a.a.j.f.d.a("Error occured when FileRequest.parseHttpResponse");
                                                th.printStackTrace();
                                                this.a.a(a.this, new IOException(th.getMessage()));
                                                if (!zG) {
                                                    a.this.b();
                                                }
                                                try {
                                                    return;
                                                } catch (Throwable unused) {
                                                    return;
                                                }
                                            } finally {
                                                if (inputStreamA != null) {
                                                    try {
                                                        inputStreamA.close();
                                                    } catch (Throwable unused2) {
                                                        b.b.a.a.j.f.d.a(str);
                                                    }
                                                }
                                                try {
                                                    randomAccessFile.close();
                                                } catch (Throwable unused3) {
                                                    b.b.a.a.j.f.d.a(str2);
                                                }
                                            }
                                        }
                                    } else {
                                        str = str3;
                                        str2 = str4;
                                    }
                                    if (z) {
                                        randomAccessFile.seek(j);
                                        randomAccessFile.write(bArr, 0, i);
                                        j += (long) i;
                                        i = 0;
                                    }
                                    a.this.a(this.f233b + j5, j4, this.a);
                                    r15 = r15;
                                    str3 = str;
                                    j2 = j5;
                                    str4 = str2;
                                    j3 = j4;
                                    j = j;
                                    i3 = -1;
                                }
                            } catch (Throwable unused4) {
                            }
                            if (a.f(map) && !(inputStreamA instanceof GZIPInputStream)) {
                                inputStreamA = new GZIPInputStream(inputStreamA);
                            }
                            bArr = new byte[16384];
                            j2 = 0;
                            i = 0;
                            r15 = r14;
                            String str7 = str3;
                            String str8 = str4;
                            ?? r3 = r15;
                            long length = !zG ? a.this.f.length() : j3;
                            if (length > 0 && a.this.f.exists() && a.this.f.length() == length) {
                                a aVar2 = a.this;
                                if (aVar2.f.renameTo(aVar2.e)) {
                                    a.this.a(length, length, this.a);
                                    r3.a(a.this.e);
                                    this.a.a(a.this, r3);
                                } else {
                                    this.a.a(a.this, new IOException("Rename fail"));
                                }
                            } else {
                                this.a.a(a.this, new IOException(" tempFile.length() == fileSize is" + (a.this.f.length() == length)));
                            }
                            if (inputStreamA != null) {
                                try {
                                    inputStreamA.close();
                                } catch (Throwable unused5) {
                                    b.b.a.a.j.f.d.a(str7);
                                }
                            }
                            try {
                                randomAccessFile.close();
                                return;
                            } catch (Throwable unused6) {
                                b.b.a.a.j.f.d.a(str8);
                                return;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str = str3;
                            str2 = str4;
                        }
                        inputStreamA = nVar.a().a();
                    } catch (Throwable th3) {
                        th = th3;
                        str = "Error occured when calling InputStream.close";
                        str2 = "Error occured when calling tmpFile.close";
                        inputStreamA = null;
                    }
                } catch (Throwable unused7) {
                    r13 = bVar2;
                    randomAccessFile = null;
                }
            } else {
                this.a.a(a.this, bVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            this.e.delete();
        } catch (Throwable unused) {
        }
        try {
            this.f.delete();
        } catch (Throwable unused2) {
        }
    }

    protected void a(long j, long j2, b.b.a.a.j.c.a aVar) {
        if (aVar != null) {
            aVar.a(this, j, j2);
        }
    }
}
