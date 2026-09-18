package com.mbridge.msdk.foundation.same.net;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.igaworks.adpopcorn.nativead.ApNativeRewardCPMError;
import com.mbridge.msdk.foundation.tools.aa;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: compiled from: SocketManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final class m {
    private static volatile AtomicInteger a = new AtomicInteger(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ExecutorService f2155b;

    private m() {
        this.f2155b = new ThreadPoolExecutor(5, 10, 5L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.net.m.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
                threadNewThread.setName("SocketThreadPool");
                return threadNewThread;
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }

    public static m a() {
        return b.a;
    }

    /* JADX INFO: compiled from: SocketManager.java */
    private static final class b {
        private static m a = new m();
    }

    public final void a(String str, int i, String str2, boolean z, e eVar) {
        this.f2155b.execute(new a(str, i, str2, z, eVar));
    }

    /* JADX INFO: compiled from: SocketManager.java */
    private class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f2156b;
        private ByteBuffer c;
        private OutputStream d;
        private boolean e;
        private e f;
        private Socket g;
        private String h;
        private int i;

        a(String str, int i, String str2, boolean z, e eVar) {
            this.e = false;
            this.h = str;
            this.i = i;
            this.f2156b = str2;
            this.e = z;
            this.f = eVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            byte[] bytes;
            int length;
            try {
                try {
                    Socket socket = new Socket(this.h, this.i);
                    this.g = socket;
                    socket.setSoTimeout(15000);
                    boolean z = this.h.contains(com.mbridge.msdk.foundation.same.net.f.d.a().h) || this.h.contains(com.mbridge.msdk.foundation.same.net.f.d.a().i);
                    aa.d("SocketManager", "Socket connect : " + this.h + " : " + this.i + " isAnalytics : " + z);
                    this.d = this.g.getOutputStream();
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[8]);
                    this.c = byteBufferWrap;
                    byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
                    this.c.put((byte) 2);
                    if (TextUtils.isEmpty(this.f2156b)) {
                        this.c.put((byte) 1);
                    } else {
                        this.c.put(this.e ? (byte) 3 : (byte) 2);
                    }
                    this.c.putShort((short) m.a.getAndIncrement());
                    if (TextUtils.isEmpty(this.f2156b)) {
                        this.c.putInt(0);
                        this.d.write(this.c.array());
                        length = 0;
                    } else {
                        if (this.e) {
                            String str = this.f2156b;
                            if (TextUtils.isEmpty(str)) {
                                bytes = null;
                            } else {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                                gZIPOutputStream.write(str.getBytes());
                                gZIPOutputStream.close();
                                bytes = byteArrayOutputStream.toByteArray();
                            }
                        } else {
                            bytes = this.f2156b.getBytes();
                        }
                        length = bytes.length;
                        this.c.putInt(length);
                        this.d.write(this.c.array());
                        this.d.write(bytes);
                    }
                    this.d.flush();
                    aa.a("SocketManager", "Socket Request : header : " + Arrays.toString(this.c.array()) + " length : " + length);
                    InputStream inputStream = this.g.getInputStream();
                    byte[] bArr = new byte[8];
                    inputStream.read(bArr, 0, 8);
                    ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr);
                    this.c = byteBufferWrap2;
                    byteBufferWrap2.order(ByteOrder.BIG_ENDIAN);
                    int i = this.c.getInt(4);
                    boolean z2 = bArr[1] == 3;
                    boolean z3 = bArr[1] == 2;
                    aa.d("SocketManager", "Socket Response : header : " + Arrays.toString(bArr) + " length : " + i + " isGzip : " + z2);
                    byte[] bArr2 = new byte[i];
                    new DataInputStream(this.g.getInputStream()).readFully(bArr2);
                    if (!z2 && i > 2 && ((bArr2[0] << 8) | (bArr2[1] & 255)) == 8075) {
                        z2 = true;
                    }
                    e eVar = this.f;
                    if (eVar == null) {
                        Socket socket2 = this.g;
                        if (socket2 != null) {
                            try {
                                socket2.close();
                                this.c = null;
                                OutputStream outputStream = this.d;
                                if (outputStream != null) {
                                    outputStream.close();
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                aa.d("SocketManager", e.getMessage());
                                return;
                            }
                        }
                        return;
                    }
                    if (z3 && i == 0) {
                        eVar.onSuccess(k.a(null, new com.mbridge.msdk.foundation.same.net.e.c(204, null, null)));
                        Socket socket3 = this.g;
                        if (socket3 != null) {
                            try {
                                socket3.close();
                                this.c = null;
                                OutputStream outputStream2 = this.d;
                                if (outputStream2 != null) {
                                    outputStream2.close();
                                    return;
                                }
                                return;
                            } catch (Exception e2) {
                                aa.d("SocketManager", e2.getMessage());
                                return;
                            }
                        }
                        return;
                    }
                    if (i < 1) {
                        a("The response data less than 1");
                        Socket socket4 = this.g;
                        if (socket4 != null) {
                            try {
                                socket4.close();
                                this.c = null;
                                OutputStream outputStream3 = this.d;
                                if (outputStream3 != null) {
                                    outputStream3.close();
                                    return;
                                }
                                return;
                            } catch (Exception e3) {
                                aa.d("SocketManager", e3.getMessage());
                                return;
                            }
                        }
                        return;
                    }
                    if (z) {
                        if (bArr2[0] == 1) {
                            eVar.onSuccess(k.a(null, new com.mbridge.msdk.foundation.same.net.e.c(200, null, null)));
                        } else {
                            a("The server returns fail");
                        }
                        Socket socket5 = this.g;
                        if (socket5 != null) {
                            try {
                                socket5.close();
                                this.c = null;
                                OutputStream outputStream4 = this.d;
                                if (outputStream4 != null) {
                                    outputStream4.close();
                                    return;
                                }
                                return;
                            } catch (Exception e4) {
                                aa.d("SocketManager", e4.getMessage());
                                return;
                            }
                        }
                        return;
                    }
                    try {
                        String strA = z2 ? m.this.a(bArr2) : new String(bArr2);
                        JSONObject jSONObject = !TextUtils.isEmpty(strA) ? new JSONObject(strA) : null;
                        aa.d("SocketManager", "Socket Response length : " + i + " " + strA.length());
                        this.f.onSuccess(k.a(jSONObject, new com.mbridge.msdk.foundation.same.net.e.c(200, null, null)));
                    } catch (Throwable th) {
                        String message = th.getMessage();
                        aa.d("SocketManager", th.getMessage());
                        if (TextUtils.isEmpty(message)) {
                            message = "The JSON data is illegal";
                        }
                        a(message);
                    }
                    inputStream.close();
                    Socket socket6 = this.g;
                    if (socket6 != null) {
                        socket6.close();
                        this.c = null;
                        OutputStream outputStream5 = this.d;
                        if (outputStream5 != null) {
                            outputStream5.close();
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        String message2 = th2.getMessage();
                        aa.a("SocketManager", "Socket exception: " + message2);
                        a(message2);
                        Socket socket7 = this.g;
                        if (socket7 != null) {
                            socket7.close();
                            this.c = null;
                            OutputStream outputStream6 = this.d;
                            if (outputStream6 != null) {
                                outputStream6.close();
                            }
                        }
                    } catch (Throwable th3) {
                        Socket socket8 = this.g;
                        if (socket8 != null) {
                            try {
                                socket8.close();
                                this.c = null;
                                OutputStream outputStream7 = this.d;
                                if (outputStream7 != null) {
                                    outputStream7.close();
                                }
                            } catch (Exception e5) {
                                aa.d("SocketManager", e5.getMessage());
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Exception e6) {
                aa.d("SocketManager", e6.getMessage());
            }
        }

        private void a(String str) {
            if (this.f != null) {
                if (TextUtils.isEmpty(str)) {
                    str = ApNativeRewardCPMError.UNKNOWN_EXCEPTION_MESSAGE;
                }
                this.f.onError(new com.mbridge.msdk.foundation.same.net.a.a(13, new com.mbridge.msdk.foundation.same.net.e.c(TTAdConstant.DEEPLINK_FALLBACK_CODE, str.getBytes(), null)));
            }
        }
    }

    public final String a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[1024];
        while (true) {
            int i = gZIPInputStream.read(bArr2, 0, 1024);
            if (i > 0) {
                byteArrayOutputStream.write(bArr2, 0, i);
            } else {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toString();
            }
        }
    }
}
