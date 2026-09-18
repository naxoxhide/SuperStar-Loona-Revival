package com.igaworks.adpopcorn.cores.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import androidx.webkit.ProxyConfig;
import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.foundation.tools.SameMD5;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class f extends Thread {
    private static Handler o = new Handler(Looper.getMainLooper());
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1611b;
    private WeakReference<ImageView> c;
    private e.c d;
    private e.b e;
    private boolean f;
    private boolean g;
    private f h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private Context n;

    class a implements Runnable {
        final /* synthetic */ Bitmap a;

        a(Bitmap bitmap) {
            this.a = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (f.this.g) {
                    return;
                }
                if (f.this.f) {
                    if (this.a != null) {
                        if (!f.this.k) {
                            e.a.put(f.this.f1611b, this.a);
                        }
                        if (f.this.e != null) {
                            f.this.e.a(this.a);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (f.this.c == null) {
                    if (this.a == null || f.this.k) {
                        return;
                    }
                    e.a.put(f.this.f1611b, this.a);
                    return;
                }
                ImageView imageView = (ImageView) f.this.c.get();
                if (f.this.h == f.this.a(imageView)) {
                    if (!f.this.k) {
                        e.a.put(f.this.f1611b, this.a);
                    }
                    if (this.a == null || imageView == null) {
                        return;
                    }
                    boolean z = false;
                    try {
                        String str = (String) imageView.getTag();
                        if (str == null || (str != null && str.equals(f.this.f1611b))) {
                            z = true;
                        }
                        if (!z) {
                            return;
                        }
                    } catch (Exception unused) {
                    }
                    imageView.setImageBitmap(this.a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class b extends FilterInputStream {
        public b(f fVar, InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            long j2 = 0;
            while (j2 < j) {
                long jSkip = ((FilterInputStream) this).in.skip(j - j2);
                if (jSkip == 0) {
                    if (read() < 0) {
                        break;
                    }
                    jSkip = 1;
                }
                j2 += jSkip;
            }
            return j2;
        }
    }

    public f(Context context, String str) {
        this.g = false;
        this.k = false;
        this.l = true;
        this.m = false;
        this.n = context;
        this.f1611b = str;
        this.f = true;
        this.g = false;
        this.h = this;
        this.m = true;
    }

    public f(Context context, String str, ImageView imageView, int i, int i2, e.b bVar, boolean z) {
        this.g = false;
        this.k = false;
        this.l = true;
        this.m = false;
        this.n = context;
        this.f1611b = str;
        this.c = new WeakReference<>(imageView);
        this.e = bVar;
        if (bVar != null) {
            this.f = true;
        } else {
            this.f = false;
        }
        this.g = false;
        this.h = this;
        this.l = z;
        this.i = i;
        this.j = i2;
        this.m = false;
    }

    public f(Context context, String str, ImageView imageView, int i, int i2, boolean z) {
        this.g = false;
        this.k = false;
        this.l = true;
        this.m = false;
        this.n = context;
        this.f1611b = str;
        this.c = new WeakReference<>(imageView);
        this.e = null;
        this.f = false;
        this.g = false;
        this.h = this;
        this.l = true;
        this.i = i;
        this.j = i2;
        this.k = z;
        this.m = false;
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00d6 A[Catch: all -> 0x00e8, TRY_LEAVE, TryCatch #4 {all -> 0x00e8, blocks: (B:55:0x00d1, B:57:0x00d6), top: B:77:0x00d1 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private Bitmap a(String str, InputStream inputStream, int i, boolean z, BitmapFactory.Options options) throws Throwable {
        FileOutputStream fileOutputStream;
        Bitmap bitmap;
        FileOutputStream fileOutputStream2;
        File file;
        FileOutputStream fileOutputStream3 = null;
        bitmapDecodeFile = null;
        bitmapDecodeFile = null;
        Bitmap bitmapDecodeFile = null;
        File file2 = null;
        try {
            try {
                File file3 = z ? new File(this.n.getCacheDir() + "/igaw/image") : new File(this.n.getCacheDir() + "/igaw/video");
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                String strA = a(str);
                if (strA == null || strA.length() <= 0) {
                    fileOutputStream2 = null;
                    file = null;
                } else {
                    file = new File(file3, strA);
                    try {
                        if (!file.exists()) {
                            fileOutputStream2 = new FileOutputStream(file);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i2 = inputStream.read(bArr);
                                    if (i2 <= 0) {
                                        break;
                                    }
                                    fileOutputStream2.write(bArr, 0, i2);
                                }
                            } catch (Exception e) {
                                Bitmap bitmap2 = bitmapDecodeFile;
                                FileOutputStream fileOutputStream4 = fileOutputStream2;
                                bitmap = bitmap2;
                                e = e;
                                fileOutputStream = fileOutputStream4;
                                file2 = file;
                                try {
                                    e.printStackTrace();
                                    if (file2 != null) {
                                        file2.delete();
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.flush();
                                            fileOutputStream.close();
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    return bitmap;
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream3 = fileOutputStream;
                                    if (fileOutputStream3 != null) {
                                        try {
                                            fileOutputStream3.flush();
                                            fileOutputStream3.close();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                fileOutputStream3 = fileOutputStream2;
                                th = th2;
                                if (fileOutputStream3 != null) {
                                    fileOutputStream3.flush();
                                    fileOutputStream3.close();
                                }
                                throw th;
                            }
                        } else {
                            if (z) {
                                return BitmapFactory.decodeStream(new b(this, inputStream), null, options);
                            }
                            fileOutputStream2 = null;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        fileOutputStream = null;
                        bitmap = null;
                        file2 = file;
                        e.printStackTrace();
                        if (file2 != null) {
                            file2.delete();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        }
                        return bitmap;
                    }
                }
                if (file != null && z) {
                    bitmapDecodeFile = options != null ? BitmapFactory.decodeFile(file.getAbsolutePath(), options) : BitmapFactory.decodeFile(file.getAbsolutePath());
                }
                if (file != null && file.length() != i) {
                    file.delete();
                }
                if (fileOutputStream2 == null) {
                    return bitmapDecodeFile;
                }
                try {
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    return bitmapDecodeFile;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return bitmapDecodeFile;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
            bitmap = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f a(ImageView imageView) {
        if (imageView != null) {
            return this.d.a();
        }
        return null;
    }

    private InputStream a(URLConnection uRLConnection) {
        boolean z;
        HttpURLConnection httpURLConnection;
        int responseCode;
        InputStream inputStream = null;
        int i = 0;
        do {
            try {
                if (uRLConnection instanceof HttpURLConnection) {
                    ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(false);
                }
                inputStream = uRLConnection.getInputStream();
                if ((uRLConnection instanceof HttpURLConnection) && (responseCode = (httpURLConnection = (HttpURLConnection) uRLConnection).getResponseCode()) >= 300 && responseCode <= 307 && responseCode != 306 && responseCode != 304) {
                    URL url = httpURLConnection.getURL();
                    String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                    URL url2 = headerField != null ? new URL(url, headerField) : null;
                    httpURLConnection.disconnect();
                    if (url2 != null && ((url2.getProtocol().equals(ProxyConfig.MATCH_HTTP) || url2.getProtocol().equals("https")) && i < 5)) {
                        uRLConnection = url2.openConnection();
                        i++;
                        z = true;
                    }
                    return null;
                }
                z = false;
            } catch (Exception unused) {
            }
        } while (z);
        return inputStream;
    }

    private String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SameMD5.TAG);
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            return String.format("%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X", Byte.valueOf(bArrDigest[0]), Byte.valueOf(bArrDigest[1]), Byte.valueOf(bArrDigest[2]), Byte.valueOf(bArrDigest[3]), Byte.valueOf(bArrDigest[4]), Byte.valueOf(bArrDigest[5]), Byte.valueOf(bArrDigest[6]), Byte.valueOf(bArrDigest[7]), Byte.valueOf(bArrDigest[8]), Byte.valueOf(bArrDigest[9]), Byte.valueOf(bArrDigest[10]), Byte.valueOf(bArrDigest[11]), Byte.valueOf(bArrDigest[12]), Byte.valueOf(bArrDigest[13]), Byte.valueOf(bArrDigest[14]), Byte.valueOf(bArrDigest[15]));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x007a A[Catch: Exception -> 0x009d, DONT_GENERATE, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x009d, blocks: (B:2:0x0000, B:10:0x004d, B:11:0x0050, B:41:0x0096, B:42:0x0099, B:43:0x009c, B:39:0x0090, B:28:0x007a, B:18:0x0063, B:19:0x0066, B:8:0x0048, B:36:0x0087, B:16:0x005e, B:31:0x0080, B:32:0x0083, B:26:0x0075), top: B:49:0x0000, inners: #2 }] */
    public Bitmap a(String str, int i, int i2, boolean z) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setConnectTimeout(3000);
            InputStream inputStreamA = a(httpURLConnection);
            int contentLength = httpURLConnection.getContentLength();
            try {
                try {
                    if (inputStreamA == null) {
                        return null;
                    }
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inPreferredConfig = Bitmap.Config.RGB_565;
                        options.inSampleSize = 1;
                        options.inTempStorage = new byte[32768];
                        options.inDither = true;
                        if (z) {
                            Bitmap bitmapA = a(str, inputStreamA, contentLength, true, options);
                            if (inputStreamA != null) {
                                inputStreamA.close();
                            }
                            if (inputStreamA != null) {
                                inputStreamA.close();
                            }
                            httpURLConnection.disconnect();
                            return bitmapA;
                        }
                        Bitmap bitmapA2 = a(str, inputStreamA, contentLength, true, null);
                        if (inputStreamA != null) {
                            inputStreamA.close();
                        }
                        if (inputStreamA != null) {
                            inputStreamA.close();
                        }
                        httpURLConnection.disconnect();
                        return bitmapA2;
                    } catch (OutOfMemoryError e) {
                        e.printStackTrace();
                        System.gc();
                        if (inputStreamA != null) {
                            inputStreamA.close();
                        }
                        if (inputStreamA != null) {
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    if (inputStreamA != null) {
                        inputStreamA.close();
                    }
                    throw th;
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                System.gc();
            } finally {
                if (inputStreamA != null) {
                    inputStreamA.close();
                }
                httpURLConnection.disconnect();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public void a(Bitmap bitmap) {
        try {
            if (o == null) {
                o = new Handler(Looper.getMainLooper());
            }
            o.post(new a(bitmap));
        } catch (Exception unused) {
        }
    }

    public void a(e.c cVar) {
        this.d = cVar;
    }

    public void a(boolean z) {
        this.g = z;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003e A[Catch: all -> 0x0042, OutOfMemoryError -> 0x0044, Merged into TryCatch #2 {all -> 0x0042, OutOfMemoryError -> 0x0044, blocks: (B:13:0x003e, B:25:0x0052, B:23:0x004e, B:24:0x0051), top: B:38:0x002d, outer: #4 }, TRY_ENTER, TRY_LEAVE] */
    public void b(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setConnectTimeout(3000);
            InputStream inputStreamA = a(httpURLConnection);
            int contentLength = httpURLConnection.getContentLength();
            if (inputStreamA != null) {
                try {
                    try {
                        try {
                            a(str, inputStreamA, contentLength, false, null);
                            if (inputStreamA != null) {
                                inputStreamA.close();
                            }
                        } catch (Throwable th) {
                            if (inputStreamA != null) {
                                inputStreamA.close();
                            }
                            throw th;
                        }
                    } catch (OutOfMemoryError e) {
                        e.printStackTrace();
                        System.gc();
                        if (inputStreamA != null) {
                            inputStreamA.close();
                        }
                    }
                    if (inputStreamA != null) {
                    }
                } catch (OutOfMemoryError e2) {
                    e2.printStackTrace();
                    System.gc();
                } finally {
                    if (inputStreamA != null) {
                        inputStreamA.close();
                    }
                    httpURLConnection.disconnect();
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (this.m) {
            b(this.f1611b);
        } else {
            a(a(this.f1611b, this.i, this.j, this.l));
        }
    }
}
