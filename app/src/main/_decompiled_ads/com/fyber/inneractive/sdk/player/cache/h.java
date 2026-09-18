package com.fyber.inneractive.sdk.player.cache;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.webkit.MimeTypeMap;
import com.fyber.inneractive.sdk.config.global.features.r;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.j0;
import com.fyber.inneractive.sdk.util.q;
import com.mbridge.msdk.foundation.tools.SameMD5;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class h implements j0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.fyber.inneractive.sdk.player.cache.c f1010b;
    public com.fyber.inneractive.sdk.player.cache.c.f c;
    public com.fyber.inneractive.sdk.player.cache.b d;
    public final String e;
    public com.fyber.inneractive.sdk.player.cache.a f;
    public i g;
    public f h;
    public Handler j;
    public String l;
    public InterfaceC0278h q;
    public final s r;
    public String a = "MediaDownloader-" + hashCode();
    public final Object k = new Object();
    public volatile boolean m = false;
    public boolean n = false;
    public boolean o = false;
    public String p = null;
    public HandlerThread i = new HandlerThread(String.format("MediaDownloader-%s-A", a()));

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            i iVar = hVar.g;
            if (iVar != null) {
                ((com.fyber.inneractive.sdk.player.cache.d.a) iVar).a(hVar, hVar.f, null);
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ Exception a;

        public b(Exception exc) {
            this.a = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            i iVar = hVar.g;
            if (iVar != null) {
                ((com.fyber.inneractive.sdk.player.cache.d.a) iVar).a(hVar, hVar.f, this.a);
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.a(false);
        }
    }

    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[r.d.values().length];
            a = iArr;
            try {
                iArr[r.d.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[r.d.EXTRACTOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[r.d.LEGACY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class e extends Exception {
        public e(String str) {
            super(str);
        }
    }

    public class f extends Thread {
        public AtomicBoolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InputStream f1012b;
        public boolean c;
        public boolean d;
        public long e;
        public long f;
        public com.fyber.inneractive.sdk.player.cache.c.C0277c g;
        public int h;
        public int i;
        public int j;
        public int k;

        public f(String str, int i) {
            super(str);
            this.a = new AtomicBoolean(false);
            this.c = false;
            this.d = false;
            this.e = -1L;
            this.f = 0L;
            this.h = i;
            this.i = h.this.r != null ? ((r) h.this.r.a(r.class)).e() : 10;
            this.j = h.this.r != null ? ((r) h.this.r.a(r.class)).f() : 500;
            this.k = h.this.r != null ? ((r) h.this.r.a(r.class)).h() : 25;
        }

        /* JADX WARN: Code duplicated, block: B:45:0x0131  */
        /* JADX WARN: Code duplicated, block: B:48:0x0151  */
        /* JADX WARN: Code duplicated, block: B:80:0x01e8 A[EDGE_INSN: B:80:0x01e8->B:77:0x01e8 BREAK  A[LOOP:0: B:43:0x0128->B:76:0x01e5], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:81:0x013a A[SYNTHETIC] */
        public final HttpURLConnection a(OutputStream outputStream, URL url, ByteBuffer byteBuffer, long j, int i) throws IOException, e {
            long j2;
            OutputStream outputStreamA;
            int i2;
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            if (j > 0) {
                httpURLConnection.addRequestProperty("Range", String.format("bytes=%d-", Long.valueOf(j)));
            }
            s sVar = h.this.r;
            if (sVar != null) {
                Integer numB = ((r) sVar.a(r.class)).b("url_conn_connection_timeout");
                Integer numB2 = ((r) h.this.r.a(r.class)).b("url_conn_read_timeout");
                if (numB != null) {
                    httpURLConnection.setConnectTimeout(numB.intValue());
                }
                if (numB2 != null) {
                    httpURLConnection.setReadTimeout(numB2.intValue());
                }
            }
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            h hVar = h.this;
            IAlog.d("%s http response code for %s is %d", hVar.a, hVar.a(), Integer.valueOf(responseCode));
            if (responseCode != 200 && responseCode != 206 && j > 0) {
                httpURLConnection.disconnect();
                throw new e("HTTP status code != 200");
            }
            long contentLength = httpURLConnection.getContentLength();
            if (contentLength > 36700160) {
                throw new g(String.format("File size to big for cache (max=%s current=%s)", NumberFormat.getInstance().format(36700160L), NumberFormat.getInstance().format(contentLength)));
            }
            if (j <= 0) {
                this.f = contentLength;
            }
            this.f1012b = httpURLConnection.getInputStream();
            long j3 = contentLength <= 0 ? 716800L : contentLength / ((long) (100 / i));
            if (contentLength <= 0) {
                j2 = 716800;
            } else {
                int i3 = i + this.k;
                if (i3 > 100) {
                    i3 = i;
                }
                j2 = contentLength / ((long) (100 / i3));
            }
            byte[] bArrA = com.fyber.inneractive.sdk.util.d.f1336b.a(byteBuffer);
            if (this.f <= 0 || this.e != -1) {
                if (j > 0 && responseCode == 200) {
                    this.e = 0L;
                    h hVar2 = h.this;
                    IAlog.d("%s | Server rejected Range header for %s | restarting", hVar2.a, hVar2.a());
                    m.a(outputStream);
                    this.g.a();
                    h hVar3 = h.this;
                    hVar3.f1010b.d(hVar3.a());
                    h hVar4 = h.this;
                    com.fyber.inneractive.sdk.player.cache.c.C0277c c0277cA = hVar4.f1010b.a(hVar4.a());
                    outputStreamA = c0277cA.a(0);
                    this.g = c0277cA;
                }
                while (true) {
                    i2 = this.f1012b.read(bArrA);
                    if (i2 == -1) {
                        break;
                    }
                    if (this.a.compareAndSet(true, true)) {
                        h hVar5 = h.this;
                        IAlog.d("%s | aborting download for cache %s", hVar5.a, hVar5.a());
                        break;
                    }
                    outputStreamA.write(bArrA, 0, i2);
                    long j4 = this.e + ((long) i2);
                    this.e = j4;
                    if ((this.c && j4 >= j3) || (!this.d && j4 >= j2)) {
                        this.c = true;
                        if (j4 >= j2) {
                            this.d = true;
                        }
                        h hVar6 = h.this;
                        if (hVar6.f == null) {
                            String strA = hVar6.a();
                            h hVar7 = h.this;
                            String str = hVar7.e;
                            com.fyber.inneractive.sdk.player.cache.c cVar = hVar7.f1010b;
                            String strA2 = hVar7.a();
                            cVar.a();
                            cVar.e(strA2);
                            com.fyber.inneractive.sdk.player.cache.c.d dVar = cVar.j.get(strA2);
                            hVar6.f = new com.fyber.inneractive.sdk.player.cache.a(strA, str, dVar == null ? null : dVar.b(0), true, h.this.l);
                            long j5 = this.f;
                            j = 0;
                            if (j5 > 0) {
                                h.this.f.e.put("http.file.length", String.valueOf(j5));
                            }
                        } else {
                            j = 0;
                        }
                        if (h.this.j != null) {
                            outputStreamA.flush();
                            h.this.j.sendEmptyMessage(4);
                        }
                    }
                }
                return httpURLConnection;
            }
            this.e = 0L;
            outputStreamA = outputStream;
            while (true) {
                i2 = this.f1012b.read(bArrA);
                if (i2 == -1) {
                    break;
                    break;
                }
                if (this.a.compareAndSet(true, true)) {
                    h hVar8 = h.this;
                    IAlog.d("%s | aborting download for cache %s", hVar8.a, hVar8.a());
                    break;
                }
                outputStreamA.write(bArrA, 0, i2);
                long j6 = this.e + ((long) i2);
                this.e = j6;
                long j7 = this.c ? 0L : 0L;
            }
            return httpURLConnection;
        }

        /* JADX WARN: Code duplicated, block: B:82:0x01e6 A[Catch: all -> 0x01fd, TRY_LEAVE, TryCatch #9 {all -> 0x01fd, blocks: (B:78:0x01c5, B:79:0x01db, B:80:0x01e0, B:82:0x01e6), top: B:112:0x01c5 }] */
        /* JADX WARN: Code duplicated, block: B:85:0x01f2 A[Catch: all -> 0x01f5, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x01f5, blocks: (B:67:0x01b6, B:85:0x01f2), top: B:109:0x001f }] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            OutputStream outputStreamA;
            HttpURLConnection httpURLConnectionA;
            Handler handler;
            Handler handler2;
            h hVar = h.this;
            IAlog.d("%s | Starting a fresh download for %s", hVar.a, hVar.a());
            ByteBuffer byteBufferB = com.fyber.inneractive.sdk.util.d.f1336b.b();
            try {
                try {
                    URL url = new URL(h.this.e);
                    h hVar2 = h.this;
                    IAlog.d("%s | opening an editor for %s", hVar2.a, hVar2.a());
                    h hVar3 = h.this;
                    com.fyber.inneractive.sdk.player.cache.c.C0277c c0277cA = hVar3.f1010b.a(hVar3.a());
                    this.g = c0277cA;
                    outputStreamA = c0277cA.a(0);
                    try {
                        int i = this.i - 1;
                        httpURLConnectionA = null;
                        while (i > 0) {
                            try {
                                if (!this.a.compareAndSet(false, false)) {
                                    break;
                                }
                                if (httpURLConnectionA != null) {
                                    try {
                                        httpURLConnectionA.disconnect();
                                    } catch (Throwable unused) {
                                    }
                                }
                                int i2 = i - 1;
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                try {
                                    httpURLConnectionA = a(outputStreamA, url, byteBufferB, this.e, this.h);
                                } catch (g e) {
                                    throw e;
                                } catch (Throwable unused2) {
                                }
                                m.a(this.f1012b);
                                IAlog.d("%s Downloaded %d out of %d for key %s", h.this.a, Long.valueOf(this.e), Long.valueOf(this.f), h.this.a());
                                if (this.e >= this.f) {
                                    i = 0;
                                } else {
                                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                                    long j = this.j;
                                    if (jCurrentTimeMillis2 < j) {
                                        Thread.sleep(j - (System.currentTimeMillis() - jCurrentTimeMillis));
                                    }
                                    i = i2;
                                }
                            } catch (Throwable th) {
                                th = th;
                                IAlog.a("%s | mDownloadRunnable exception raised during download", th, h.this.a);
                                t.a("mDownloadRunnable exception raised during download", th.getMessage(), null, null);
                                this.g.a();
                                handler = h.this.j;
                                if (handler != null) {
                                    handler.sendMessage(handler.obtainMessage(1, th));
                                }
                                m.a(outputStreamA);
                                if (httpURLConnectionA != null) {
                                    httpURLConnectionA.disconnect();
                                }
                            }
                            th = th;
                            try {
                                IAlog.a("%s | mDownloadRunnable exception raised during download", th, h.this.a);
                                t.a("mDownloadRunnable exception raised during download", th.getMessage(), null, null);
                                try {
                                    this.g.a();
                                } catch (Exception unused3) {
                                }
                                handler = h.this.j;
                                if (handler != null) {
                                    handler.sendMessage(handler.obtainMessage(1, th));
                                }
                                m.a(outputStreamA);
                                if (httpURLConnectionA != null) {
                                    httpURLConnectionA.disconnect();
                                }
                            } finally {
                                m.a(outputStreamA);
                                if (httpURLConnectionA != null) {
                                    try {
                                        httpURLConnectionA.disconnect();
                                    } catch (Throwable unused4) {
                                    }
                                }
                                com.fyber.inneractive.sdk.util.d.f1336b.a.offer(byteBufferB);
                            }
                        }
                        synchronized (h.this.k) {
                            if (this.f > this.e || this.a.compareAndSet(true, true)) {
                                this.g.a();
                                h hVar4 = h.this;
                                hVar4.f1010b.d(hVar4.a());
                                h hVar5 = h.this;
                                IAlog.d("%s | aborting cache - %s", hVar5.a, hVar5.a());
                            } else {
                                h hVar6 = h.this;
                                IAlog.d("%s | committing to cache - %s", hVar6.a, hVar6.a());
                                m.a(outputStreamA);
                                h hVar7 = h.this;
                                com.fyber.inneractive.sdk.player.cache.a aVar = hVar7.f;
                                if (aVar != null) {
                                    synchronized (aVar.d) {
                                        com.fyber.inneractive.sdk.player.cache.c.C0277c c0277c = this.g;
                                        if (c0277c.c) {
                                            com.fyber.inneractive.sdk.player.cache.c.a(com.fyber.inneractive.sdk.player.cache.c.this, c0277c, false);
                                            com.fyber.inneractive.sdk.player.cache.c.this.d(c0277c.a.a);
                                        } else {
                                            com.fyber.inneractive.sdk.player.cache.c.a(com.fyber.inneractive.sdk.player.cache.c.this, c0277c, true);
                                        }
                                        com.fyber.inneractive.sdk.player.cache.c cVar = h.this.f1010b;
                                        synchronized (cVar) {
                                            cVar.a();
                                            cVar.f();
                                            cVar.i.flush();
                                        }
                                        h hVar8 = h.this;
                                        hVar8.f.a = hVar8.f1010b.a(hVar8.a(), 0);
                                    }
                                    h.this.f.c = false;
                                } else {
                                    String strA = hVar7.a();
                                    h hVar9 = h.this;
                                    hVar7.f = new com.fyber.inneractive.sdk.player.cache.a(strA, hVar9.e, hVar9.f1010b.a(hVar9.a(), 0), true, h.this.l);
                                }
                            }
                        }
                        h.this.o = false;
                        if (httpURLConnectionA != null) {
                            httpURLConnectionA.disconnect();
                        }
                        if (this.a.compareAndSet(false, false) && (handler2 = h.this.j) != null && this.e >= this.f) {
                            handler2.sendEmptyMessage(2);
                        }
                        m.a(outputStreamA);
                        if (httpURLConnectionA != null) {
                            httpURLConnectionA.disconnect();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnectionA = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStreamA = null;
                    httpURLConnectionA = null;
                }
            } catch (Throwable unused5) {
            }
        }
    }

    public static class g extends e {
        public g(String str) {
            super(str);
        }
    }

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.cache.h$h, reason: collision with other inner class name */
    public interface InterfaceC0278h {
    }

    public interface i {
    }

    public h(com.fyber.inneractive.sdk.player.cache.c cVar, String str, com.fyber.inneractive.sdk.player.cache.b bVar, int i2, s sVar) {
        this.f1010b = cVar;
        this.e = str;
        this.l = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str).toLowerCase(Locale.US));
        this.d = bVar;
        this.r = sVar;
        this.h = new f(String.format("MediaDownloader-%s-A", a()), i2);
    }

    public static /* synthetic */ boolean c(h hVar, boolean z) {
        hVar.getClass();
        return z;
    }

    public final void b() {
        com.fyber.inneractive.sdk.util.m.f1343b.post(new a());
    }

    @Override // com.fyber.inneractive.sdk.util.j0
    public void handleMessage(Message message) {
        if (message.what == 4 && !this.f.f) {
            synchronized (this.k) {
                IAlog.d("%s | reading from cache 1 - %s", this.a, a());
                com.fyber.inneractive.sdk.player.cache.b.a aVarA = this.d.a(this.f, this.l);
                if (aVarA == com.fyber.inneractive.sdk.player.cache.b.a.INVALID) {
                    a(new e("Failed cache validation"));
                    a(true);
                } else if (aVarA == com.fyber.inneractive.sdk.player.cache.b.a.PARTIAL_CANNOT_VALIDATE) {
                    this.m = true;
                } else {
                    this.f.f = true;
                    a(this.f);
                    this.f.e.putAll(this.d.a);
                    b();
                }
            }
            return;
        }
        int i2 = message.what;
        if (i2 == 1) {
            Object obj = message.obj;
            if (obj instanceof Exception) {
                a((Exception) obj);
            } else {
                a(new e("download failed"));
            }
            a(false);
            return;
        }
        if (i2 == 2) {
            if (this.m) {
                synchronized (this.k) {
                    IAlog.d("%s | reading from cache 2 - %s", this.a, a());
                    if (this.d.a(this.f, this.l) == com.fyber.inneractive.sdk.player.cache.b.a.INVALID) {
                        a(new e("Failed cache validation after downloading complete file"));
                        a(true);
                    } else {
                        a(this.f);
                        this.f.e.putAll(this.d.a);
                        b();
                    }
                }
            } else {
                com.fyber.inneractive.sdk.util.m.f1343b.post(new c());
            }
            IAlog.d("%s | Download success for cache key %s", this.a, a());
        }
    }

    public static void b(h hVar, boolean z) {
        com.fyber.inneractive.sdk.player.cache.g gVar = new com.fyber.inneractive.sdk.player.cache.g(hVar);
        Handler handler = hVar.j;
        if (handler != null) {
            if (z) {
                handler.postAtFrontOfQueue(gVar);
            } else {
                handler.postDelayed(gVar, 4L);
            }
        }
    }

    public final void a(Exception exc) {
        com.fyber.inneractive.sdk.util.m.f1343b.post(new b(exc));
    }

    public final void a(boolean z) {
        f fVar = this.h;
        if (fVar != null) {
            fVar.a.compareAndSet(false, true);
            this.h = null;
        }
        HandlerThread handlerThread = this.i;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        this.j = null;
        if (z) {
            try {
                this.f1010b.d(a());
            } catch (IOException e2) {
                IAlog.a("failed to remove cache key", e2, new Object[0]);
            }
        }
    }

    public String a() {
        String strReplaceAll = "";
        if (this.p == null) {
            String str = this.e;
            try {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                    messageDigest.update(str.getBytes());
                    byte[] bArrDigest = messageDigest.digest();
                    StringBuffer stringBuffer = new StringBuffer();
                    for (byte b2 : bArrDigest) {
                        stringBuffer.append(Integer.toHexString((b2 & 255) | 256).substring(1));
                    }
                    strReplaceAll = stringBuffer.toString();
                } catch (NullPointerException unused) {
                } catch (NoSuchAlgorithmException unused2) {
                    MessageDigest messageDigest2 = MessageDigest.getInstance(SameMD5.TAG);
                    messageDigest2.update(str.getBytes());
                    byte[] bArrDigest2 = messageDigest2.digest();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    for (byte b3 : bArrDigest2) {
                        stringBuffer2.append(Integer.toHexString((b3 & 255) | 256).substring(1));
                    }
                    strReplaceAll = stringBuffer2.toString();
                }
            } catch (NoSuchAlgorithmException unused3) {
                strReplaceAll = str.replaceAll("\\W+", "");
            }
            this.p = strReplaceAll;
        }
        return this.p;
    }

    public final void a(com.fyber.inneractive.sdk.player.cache.a aVar) {
        InterfaceC0278h interfaceC0278h;
        if (aVar == null || (interfaceC0278h = this.q) == null) {
            return;
        }
        File fileA = aVar.a();
        File file = ((com.fyber.inneractive.sdk.util.f) interfaceC0278h).a;
        if ((file == null || fileA == null || !file.getAbsolutePath().equals(fileA.getAbsolutePath())) ? false : true) {
            return;
        }
        InterfaceC0278h interfaceC0278h2 = this.q;
        File fileA2 = aVar.a();
        com.fyber.inneractive.sdk.util.f fVar = (com.fyber.inneractive.sdk.util.f) interfaceC0278h2;
        fVar.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                try {
                    mediaMetadataRetriever.setDataSource(fileA2.getPath());
                    mediaMetadataRetriever.extractMetadata(8192);
                    Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(1L);
                    fVar.f1337b = frameAtTime;
                    if (frameAtTime != null && frameAtTime.getWidth() > 0 && fVar.f1337b.getHeight() > 0) {
                        fVar.a = fileA2;
                    }
                    mediaMetadataRetriever.release();
                } catch (Exception e2) {
                    IAlog.a("Failed getting frame from video file%s", q.b(e2));
                    mediaMetadataRetriever.release();
                }
                IAlog.d("FirstFrameDownloadMediaProcessor processing finished in %dms", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            } catch (Throwable th) {
                try {
                    mediaMetadataRetriever.release();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Throwable unused2) {
        }
    }
}
