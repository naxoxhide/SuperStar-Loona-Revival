package com.mbridge.msdk.foundation.same.net.d;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.foundation.same.net.i;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.aa;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: FileDownloadRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends i<Void> {
    private static final String c = "a";
    private File d;
    private File e;

    @Override // com.mbridge.msdk.foundation.same.net.i
    public final int g() {
        return 1;
    }

    public a(File file, String str) {
        super(0, str);
        this.d = file;
        this.e = new File(file + ".tmp");
    }

    @Override // com.mbridge.msdk.foundation.same.net.i
    protected final k<Void> a(com.mbridge.msdk.foundation.same.net.e.c cVar) {
        if (!c()) {
            if (this.e.canRead() && this.e.length() > 0) {
                if (this.e.renameTo(this.d)) {
                    return k.a(null, cVar);
                }
                return k.a(new com.mbridge.msdk.foundation.same.net.a.a(4, cVar));
            }
            return k.a(new com.mbridge.msdk.foundation.same.net.a.a(4, cVar));
        }
        return k.a(new com.mbridge.msdk.foundation.same.net.a.a(-2, cVar));
    }

    @Override // com.mbridge.msdk.foundation.same.net.i
    public final byte[] a(com.mbridge.msdk.foundation.same.net.e.b bVar, com.mbridge.msdk.foundation.same.net.c cVar) throws Throwable {
        String strA = com.mbridge.msdk.foundation.same.net.f.b.a(bVar.b(), HttpHeaders.CONTENT_LENGTH);
        long j = 0;
        long jLongValue = !TextUtils.isEmpty(strA) ? Long.valueOf(strA).longValue() : 0L;
        if (jLongValue <= 0) {
            aa.b(c, "Response doesn't present Content-Length!");
        }
        InputStream inputStream = null;
        if (jLongValue > 0 && this.d.length() == jLongValue) {
            this.d.renameTo(this.e);
            cVar.a(this, jLongValue, jLongValue);
            return null;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.e.getAbsolutePath(), "rw");
        randomAccessFile.setLength(0L);
        try {
            InputStream inputStreamC = bVar.c();
            try {
                InputStream gZIPInputStream = (!com.mbridge.msdk.foundation.same.net.f.b.b(bVar.b()) || (inputStreamC instanceof GZIPInputStream)) ? inputStreamC : new GZIPInputStream(inputStreamC);
                try {
                    byte[] bArr = new byte[6144];
                    while (true) {
                        int i = gZIPInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        randomAccessFile.write(bArr, 0, i);
                        j += (long) i;
                        cVar.a(this, jLongValue, j);
                        if (c()) {
                            cVar.b(this);
                            break;
                        }
                    }
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (Exception e) {
                            aa.d(c, e.getMessage());
                        }
                    }
                    randomAccessFile.close();
                    return null;
                } catch (Throwable th) {
                    inputStream = gZIPInputStream;
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e2) {
                            aa.d(c, e2.getMessage());
                        }
                    }
                    randomAccessFile.close();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStreamC;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
