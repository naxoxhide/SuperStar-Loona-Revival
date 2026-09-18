package b.b.a.a.h.w;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DefaultHttpClient.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b.b.a.a.h.d<d> {
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00bb: MOVE (r2 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:43:0x00bb */
    @Override // b.b.a.a.h.d
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public d<byte[]> a(b.b.a.a.h.e eVar) throws Throwable {
        InputStream inputStream;
        Closeable closeable;
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream;
        String message;
        int i = 0;
        Closeable closeable2 = null;
        closeable2 = null;
        Map<String, String> mapA = null;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(eVar.a()).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();
                try {
                    byte[] bArr = new byte[1024];
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        while (true) {
                            try {
                                int i2 = inputStream.read(bArr);
                                if (i2 == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, i2);
                            } catch (MalformedURLException e) {
                                e = e;
                                byteArray = null;
                            } catch (IOException e2) {
                                e = e2;
                                byteArray = null;
                            }
                            Log.w("InternalHttpClient", "MalformedURLException:" + e.getMessage());
                            message = e.getMessage();
                            b.b.a.a.h.x.k.b.a(inputStream);
                            b.b.a.a.h.x.k.b.a(byteArrayOutputStream);
                            return new d<>(i, byteArray, message, mapA);
                        }
                        mapA = eVar.c() ? a(httpURLConnection) : null;
                        b.b.a.a.h.x.k.b.a(inputStream);
                        b.b.a.a.h.x.k.b.a(byteArrayOutputStream);
                        message = "success";
                    } catch (MalformedURLException e3) {
                        e = e3;
                        Log.w("InternalHttpClient", "MalformedURLException:" + e.getMessage());
                        message = e.getMessage();
                        b.b.a.a.h.x.k.b.a(inputStream);
                        b.b.a.a.h.x.k.b.a(byteArrayOutputStream);
                    } catch (IOException e4) {
                        e = e4;
                        Log.w("InternalHttpClient", "IOException:" + e.getMessage());
                        message = e.getMessage();
                        b.b.a.a.h.x.k.b.a(inputStream);
                        b.b.a.a.h.x.k.b.a(byteArrayOutputStream);
                    }
                    i = 200;
                    byteArray = byteArrayOutputStream.toByteArray();
                } catch (MalformedURLException e5) {
                    e = e5;
                    byteArray = null;
                    byteArrayOutputStream = null;
                } catch (IOException e6) {
                    e = e6;
                    byteArray = null;
                    byteArrayOutputStream = null;
                    Log.w("InternalHttpClient", "IOException:" + e.getMessage());
                    message = e.getMessage();
                    b.b.a.a.h.x.k.b.a(inputStream);
                    b.b.a.a.h.x.k.b.a(byteArrayOutputStream);
                    return new d<>(i, byteArray, message, mapA);
                } catch (Throwable th) {
                    th = th;
                    b.b.a.a.h.x.k.b.a(inputStream);
                    b.b.a.a.h.x.k.b.a(closeable2);
                    throw th;
                }
            } catch (MalformedURLException e7) {
                e = e7;
                inputStream = null;
            } catch (IOException e8) {
                e = e8;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            return new d<>(i, byteArray, message, mapA);
        } catch (Throwable th3) {
            th = th3;
            closeable2 = closeable;
        }
    }

    private Map<String, String> a(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list != null && list.size() > 0) {
                map.put(str, list.get(0));
            }
        }
        return map;
    }
}
