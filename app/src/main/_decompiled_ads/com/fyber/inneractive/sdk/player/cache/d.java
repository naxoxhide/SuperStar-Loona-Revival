package com.fyber.inneractive.sdk.player.cache;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.features.r;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.i0;
import com.fyber.inneractive.sdk.util.q;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class d implements com.fyber.inneractive.sdk.player.exoplayer2.upstream.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.fyber.inneractive.sdk.player.cache.a f1007b;
    public h c;
    public Uri d;
    public FileInputStream f;
    public FileInputStream g;
    public b h;
    public c i;
    public int j;
    public s k;
    public boolean a = false;
    public long e = 0;

    public class a implements h.i {
        public final /* synthetic */ com.fyber.inneractive.sdk.util.f a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f1008b;
        public final /* synthetic */ CountDownLatch c;

        public a(com.fyber.inneractive.sdk.util.f fVar, AtomicReference atomicReference, CountDownLatch countDownLatch) {
            this.a = fVar;
            this.f1008b = atomicReference;
            this.c = countDownLatch;
        }

        public void a(h hVar, com.fyber.inneractive.sdk.player.cache.a aVar, Exception exc) {
            b bVar;
            d dVar = d.this;
            if (!dVar.a) {
                if (exc == null) {
                    Bitmap bitmap = this.a.f1337b;
                    if (bitmap != null && (bVar = dVar.h) != null) {
                        ((com.fyber.inneractive.sdk.player.controller.d) bVar).C = bitmap;
                    }
                    dVar.f1007b = aVar;
                } else {
                    this.f1008b.set(exc);
                }
            }
            this.c.countDown();
        }
    }

    public interface b {
    }

    public interface c {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public long a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar) throws IOException {
        com.fyber.inneractive.sdk.player.cache.b jVar2;
        r.d dVar;
        if (this.f1007b == null) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            AtomicReference atomicReference = new AtomicReference();
            com.fyber.inneractive.sdk.util.f fVar = new com.fyber.inneractive.sdk.util.f();
            Uri uri = jVar.a;
            this.d = uri;
            n nVar = n.f;
            int i = this.j;
            String string = uri.toString();
            s sVar = this.k;
            a aVar = new a(fVar, atomicReference, countDownLatch);
            com.fyber.inneractive.sdk.player.cache.c cVar = nVar.f1015b;
            boolean zA = IAConfigManager.M.u.f886b.a("validateHasVideoTracks", false);
            r rVar = sVar == null ? null : (r) sVar.a(r.class);
            if (rVar != null) {
                int[] iArr = h.d.a;
                r.d dVar2 = r.d.LEGACY;
                String strA = rVar.a("v_type", dVar2.key);
                r.d[] dVarArrValues = r.d.values();
                int length = dVarArrValues.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        dVar = dVar2;
                        break;
                    }
                    int i3 = length;
                    r.d dVar3 = dVarArrValues[i2];
                    r.d[] dVarArr = dVarArrValues;
                    if (TextUtils.equals(dVar3.key, strA.toLowerCase(Locale.US))) {
                        dVar = dVar3;
                        break;
                    }
                    i2++;
                    length = i3;
                    dVarArrValues = dVarArr;
                }
                int i4 = iArr[dVar.ordinal()];
                if (i4 != 1) {
                    jVar2 = i4 != 2 ? new j(zA) : new i();
                } else {
                    jVar2 = new k();
                }
            } else {
                jVar2 = new j(zA);
            }
            h hVar = new h(cVar, string, jVar2, i, sVar);
            hVar.g = aVar;
            nVar.d.add(hVar.a());
            this.c = hVar;
            hVar.q = fVar;
            hVar.o = true;
            HandlerThread handlerThread = hVar.i;
            if (handlerThread != null) {
                handlerThread.start();
                i0 i0Var = new i0(hVar.i.getLooper(), hVar);
                hVar.j = i0Var;
                i0Var.post(new f(hVar));
            }
            c cVar2 = this.i;
            if (cVar2 != null) {
                ((com.fyber.inneractive.sdk.player.controller.d) cVar2).F.add(this.c);
            }
            try {
                countDownLatch.await(7L, TimeUnit.SECONDS);
                if (this.f1007b == null) {
                    if (atomicReference.get() == null) {
                        throw new IOException("Cache has failed to download");
                    }
                    throw new IOException((Throwable) atomicReference.get());
                }
            } catch (InterruptedException e) {
                h hVar2 = this.c;
                hVar2.a(hVar2.o);
                throw new IOException(e);
            }
        }
        this.e = jVar.d;
        com.fyber.inneractive.sdk.player.cache.a aVar2 = this.f1007b;
        String strValueOf = aVar2.c ? aVar2.e.get("http.file.length") : String.valueOf(aVar2.a().length());
        if (strValueOf == null || !TextUtils.isDigitsOnly(strValueOf)) {
            return -1L;
        }
        return Long.parseLong(strValueOf);
    }

    public final int b(byte[] bArr, int i, int i2) throws IOException {
        InputStream inputStream;
        InputStream inputStream2;
        String str = this.f1007b.f1003b;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        int i3 = (int) this.e;
        ByteBuffer byteBufferB = com.fyber.inneractive.sdk.util.d.f1336b.b();
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setRequestProperty("Range", String.format(Locale.ENGLISH, "bytes=%d-", Integer.valueOf(i3)));
                httpURLConnection2.connect();
                if (httpURLConnection2.getResponseCode() != 206) {
                    throw new IOException("Server did not reply with proper range.");
                }
                inputStream2 = httpURLConnection2.getInputStream();
                byte[] bArrArray = byteBufferB.array();
                while (inputStream2.read(bArrArray) != -1) {
                    byteArrayOutputStream.write(bArrArray);
                }
                inputStream2.close();
                httpURLConnection2.disconnect();
                try {
                    httpURLConnection2.disconnect();
                } catch (Exception unused) {
                }
                try {
                    inputStream2.close();
                } catch (Exception unused2) {
                }
                System.arraycopy(byteArrayOutputStream.toByteArray(), 0, bArr, i, i2);
                return i2;
            } catch (IOException e) {
                e = e;
                httpURLConnection = httpURLConnection2;
                try {
                    throw e;
                } catch (Throwable th) {
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception unused3) {
                        }
                    }
                    if (httpURLConnection == 0) {
                        throw th;
                    }
                    try {
                        httpURLConnection.close();
                        throw th;
                    } catch (Exception unused4) {
                        throw th;
                    }
                }
            } catch (Throwable unused5) {
                httpURLConnection = httpURLConnection2;
                inputStream = null;
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception unused6) {
                    }
                }
                if (inputStream != null) {
                    inputStream2 = inputStream;
                }
                System.arraycopy(byteArrayOutputStream.toByteArray(), 0, bArr, i, i2);
                return i2;
            }
        } catch (IOException e2) {
            e = e2;
        } catch (Throwable unused7) {
            inputStream = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public void close() throws IOException {
        this.a = true;
        this.e = 0L;
        q.b(this.f);
        q.b(this.g);
        this.f = null;
        this.g = null;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public int a(byte[] bArr, int i, int i2) throws IOException {
        com.fyber.inneractive.sdk.player.cache.a aVar = this.f1007b;
        if (aVar == null) {
            return -1;
        }
        if (i2 == 0) {
            return i2;
        }
        synchronized (aVar.d) {
            int length = (int) this.f1007b.a().length();
            if (i > length) {
                return b(bArr, i, i2);
            }
            boolean z = false;
            if (this.f1007b.c) {
                while (length - i <= 0) {
                    try {
                        wait(0L, 50);
                        length = (int) this.f1007b.a().length();
                    } catch (InterruptedException e) {
                        throw new IOException(e);
                    }
                }
                if (this.g == null) {
                    this.g = new FileInputStream(this.f1007b.a());
                    z = true;
                }
            } else if (this.f == null) {
                IAlog.a("%s creating a single instance of fis", toString());
                this.f = new FileInputStream(this.f1007b.a());
                q.b(this.g);
                this.g = null;
                z = true;
            }
            FileInputStream fileInputStream = this.f;
            if (fileInputStream == null) {
                fileInputStream = this.g;
            }
            long j = this.e;
            if (j > 0 && z && fileInputStream.skip(j) != this.e) {
                throw new IOException("Failed to skip the stream");
            }
            int i3 = fileInputStream.read(bArr, i, Math.min(Math.min(bArr.length, length - i), i2));
            this.e += (long) i3;
            return i3;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public Uri a() {
        return this.d;
    }
}
