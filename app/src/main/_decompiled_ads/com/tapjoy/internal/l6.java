package com.tapjoy.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class l6 {
    public static final h0 e;
    public static final k6 f;
    public final URL a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f2779b;
    public byte[] c;
    public o2 d;

    static {
        m4 m4Var = new m4();
        boolean z = m4Var instanceof m7;
        h0 i0Var = m4Var;
        if (!z) {
            i0Var = new i0(m4Var);
        }
        e = i0Var;
        f = new k6();
    }

    public l6(URL url) {
        this.a = url;
    }

    public final Bitmap a() {
        return this.f2779b;
    }

    public final void b() {
        Bitmap bitmap;
        File file;
        boolean zA = ca.c.a.a("mm_external_cache_enabled");
        boolean z = !zA;
        if (z) {
            Bitmap bitmap2 = (Bitmap) e.a(this.a);
            this.f2779b = bitmap2;
            if (bitmap2 != null) {
                return;
            }
        }
        long j = 0;
        if (zA) {
            j1 j1Var = j1.f;
            URL url = this.a;
            FileInputStream fileInputStream = null;
            if (j1Var.a == null) {
                file = null;
            } else {
                synchronized (j1Var) {
                    String strA = j1Var.a(url);
                    File file2 = j1Var.d;
                    if (file2 == null) {
                        file2 = new File(j1Var.a.getCacheDir(), "tapjoy_mm_cache");
                        j1Var.d = file2;
                    }
                    if (!file2.isDirectory()) {
                        file2.delete();
                    }
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    file = new File(file2, strA);
                    if (file.exists()) {
                        long jA = na.a();
                        long j2 = j1Var.f2772b.getLong(strA, 0L);
                        if (j2 < jA) {
                            if (j2 != 0) {
                                j1Var.f2772b.edit().remove(strA).commit();
                                j1Var.c.edit().remove(strA).commit();
                            }
                            file.delete();
                        }
                    }
                    file = null;
                }
            }
            if (file != null) {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        a(fileInputStream2);
                        l8.a(fileInputStream2);
                    } catch (IOException unused) {
                        fileInputStream = fileInputStream2;
                        l8.a(fileInputStream);
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        l8.a(fileInputStream);
                        throw th;
                    }
                } catch (IOException unused2) {
                } catch (Throwable th2) {
                    th = th2;
                }
                Bitmap bitmap3 = this.f2779b;
                if (bitmap3 != null || this.c != null) {
                    if (!z || bitmap3 == null) {
                        return;
                    }
                    e.a(this.a, bitmap3);
                    return;
                }
                file.delete();
            }
        }
        URLConnection uRLConnectionOpenConnection = this.a.openConnection();
        String headerField = uRLConnectionOpenConnection.getHeaderField(HttpHeaders.CACHE_CONTROL);
        if (!TextUtils.isEmpty(headerField)) {
            for (String str : headerField.split(",")) {
                String strTrim = str.trim();
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(strTrim.substring(8));
                        break;
                    } catch (NumberFormatException unused3) {
                        break;
                    }
                }
            }
        }
        long j3 = j;
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        ByteArrayInputStream byteArrayInputStreamA = a(inputStream);
        l8.a(inputStream);
        j1 j1Var2 = j1.f;
        j1Var2.getClass();
        if ((j3 >= 3600) && zA && (this.f2779b != null || this.c != null)) {
            URL url2 = this.a;
            if (j1Var2.a != null) {
                j1Var2.e.submit(new h1(j1Var2, url2, byteArrayInputStreamA, j3));
            }
        }
        if (!z || (bitmap = this.f2779b) == null) {
            return;
        }
        e.a(this.a, bitmap);
    }

    public final ByteArrayInputStream a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
        byteArrayOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        p2 p2Var = new p2();
        Bitmap bitmapDecodeStream = null;
        if (byteArray != null) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(byteArray);
            p2Var.f2794b = null;
            Arrays.fill(p2Var.a, (byte) 0);
            p2Var.c = new o2();
            p2Var.d = 0;
            ByteBuffer byteBufferAsReadOnlyBuffer = byteBufferWrap.asReadOnlyBuffer();
            p2Var.f2794b = byteBufferAsReadOnlyBuffer;
            byteBufferAsReadOnlyBuffer.position(0);
            p2Var.f2794b.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            p2Var.f2794b = null;
            p2Var.c.f2789b = 2;
        }
        o2 o2VarB = p2Var.b();
        if (o2VarB.f2789b == 0) {
            this.c = byteArray;
            this.d = o2VarB;
        } else {
            y.a.getClass();
            int i2 = 1;
            while (true) {
                try {
                    try {
                        bitmapDecodeStream = byteArrayInputStream instanceof z ? BitmapFactory.decodeStream(byteArrayInputStream) : BitmapFactory.decodeStream(new z(byteArrayInputStream));
                        break;
                    } catch (Throwable th) {
                        byteArrayInputStream.close();
                        throw th;
                    }
                } catch (OutOfMemoryError e2) {
                    if (i2 >= 10) {
                        throw e2;
                    }
                    try {
                        System.gc();
                        i2++;
                    } catch (OutOfMemoryError unused) {
                    }
                }
            }
            byteArrayInputStream.close();
            this.f2779b = bitmapDecodeStream;
            byteArrayInputStream.reset();
        }
        return byteArrayInputStream;
    }

    public l6(b4 b4Var) {
        if (b4Var.f()) {
            this.a = b4Var.o();
            return;
        }
        b4Var.a();
        String strL = b4Var.l();
        while (b4Var.c()) {
            if ("url".equals(strL)) {
                this.a = b4Var.o();
            } else {
                b4Var.r();
            }
        }
        b4Var.b();
    }
}
