package b.b.a.a.f.a.p.b;

import b.b.a.a.f.a.o;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: compiled from: NetResponseBody.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends o {
    HttpURLConnection a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    InputStream f158b;

    g(HttpURLConnection httpURLConnection) throws IOException {
        this.a = httpURLConnection;
        this.f158b = new e(httpURLConnection.getInputStream(), httpURLConnection);
    }

    @Override // b.b.a.a.f.a.o
    public InputStream a() {
        return this.f158b;
    }

    @Override // b.b.a.a.f.a.o
    public long c() {
        try {
            return this.a.getContentLength();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // b.b.a.a.f.a.o, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f158b.close();
            this.a.disconnect();
        } catch (Exception unused) {
        }
    }

    @Override // b.b.a.a.f.a.o
    public String d() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f158b));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    String string = stringBuffer.toString();
                    close();
                    return string;
                }
                stringBuffer.append(line + "\n");
            }
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // b.b.a.a.f.a.o
    public byte[] b() {
        try {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i = this.f158b.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}
