package com.mbridge.msdk.foundation.same.report;

import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: SocketStack.java */
/* JADX INFO: loaded from: classes4.dex */
public final class t extends com.mbridge.msdk.e.a.a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicInteger f2193b = new AtomicInteger(1);
    private final byte a;

    public t(byte b2) {
        this.a = b2;
    }

    @Override // com.mbridge.msdk.e.a.a.a
    public final com.mbridge.msdk.e.a.a.f a(com.mbridge.msdk.e.a.m<?> mVar, Map<String, String> map) throws IOException {
        ByteBuffer byteBuffer;
        OutputStream outputStream;
        ByteBuffer byteBufferWrap;
        com.mbridge.msdk.e.a.a.f fVar;
        com.mbridge.msdk.e.a.a.f fVar2;
        byte[] byteArray;
        if (com.mbridge.msdk.e.a.a) {
            Log.d("TrackManager_Volley", "SocketStack executeRequest " + mVar.h() + CertificateUtil.DELIMITER + mVar.e());
        }
        Socket socket = null;
        try {
            Socket socket2 = new Socket(mVar.h(), mVar.e());
            try {
                socket2.setSoTimeout(mVar.r());
                outputStream = socket2.getOutputStream();
                try {
                    if (outputStream == null) {
                        throw new IOException("create outputStream exception");
                    }
                    byteBufferWrap = ByteBuffer.wrap(new byte[8]);
                    try {
                        byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
                        byteBufferWrap.put(this.a);
                        byte[] bArrN = mVar.n();
                        boolean z = true;
                        if (bArrN == null || bArrN.length == 0) {
                            byteBufferWrap.put((byte) 1);
                        } else {
                            byteBufferWrap.put((byte) 3);
                        }
                        byteBufferWrap.putShort((short) f2193b.getAndIncrement());
                        if (bArrN == null || bArrN.length == 0) {
                            byteBufferWrap.putInt(0);
                            outputStream.write(byteBufferWrap.array());
                        } else {
                            if (bArrN == null || bArrN.length == 0) {
                                byteArray = null;
                            } else {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                                gZIPOutputStream.write(bArrN);
                                gZIPOutputStream.close();
                                byteArray = byteArrayOutputStream.toByteArray();
                            }
                            byteBufferWrap.putInt(byteArray == null ? 0 : byteArray.length);
                            outputStream.write(byteBufferWrap.array());
                            outputStream.write(byteArray);
                        }
                        outputStream.flush();
                        byte[] bArr = new byte[8];
                        socket2.getInputStream().read(bArr, 0, 8);
                        ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr);
                        try {
                            byteBufferWrap2.order(ByteOrder.BIG_ENDIAN);
                            int i = byteBufferWrap2.getInt(4);
                            boolean z2 = bArr[1] == 2;
                            byte[] bArr2 = new byte[i];
                            new DataInputStream(socket2.getInputStream()).readFully(bArr2);
                            if (z2 && i == 0) {
                                fVar2 = new com.mbridge.msdk.e.a.a.f(204, new ArrayList(), i, null);
                            } else {
                                if (i < 1) {
                                    fVar = new com.mbridge.msdk.e.a.a.f(500, new ArrayList(), 0, null);
                                } else {
                                    if (bArr2[0] != 1) {
                                        z = false;
                                    }
                                    if (z) {
                                        fVar2 = new com.mbridge.msdk.e.a.a.f(200, new ArrayList(), i, null);
                                    } else {
                                        fVar = new com.mbridge.msdk.e.a.a.f(500, new ArrayList(), 0, null);
                                    }
                                }
                                a(outputStream);
                                a(socket2);
                                a(byteBufferWrap);
                                a(byteBufferWrap2);
                                return fVar;
                            }
                            a(outputStream);
                            a(socket2);
                            a(byteBufferWrap);
                            a(byteBufferWrap2);
                            return fVar2;
                        } catch (Throwable th) {
                            byteBuffer = byteBufferWrap2;
                            th = th;
                            socket = socket2;
                            try {
                                throw new IOException(th);
                            } catch (Throwable th2) {
                                a(outputStream);
                                a(socket);
                                a(byteBufferWrap);
                                a(byteBuffer);
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        byteBuffer = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    byteBufferWrap = null;
                    socket = socket2;
                    byteBuffer = byteBufferWrap;
                    throw new IOException(th);
                }
            } catch (Throwable th5) {
                th = th5;
                outputStream = null;
                byteBufferWrap = null;
            }
        } catch (Throwable th6) {
            th = th6;
            byteBuffer = null;
            outputStream = null;
            byteBufferWrap = null;
        }
    }

    private void a(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            try {
                byteBuffer.clear();
            } catch (Exception unused) {
            }
        }
    }

    private static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    private static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Exception unused) {
            }
        }
    }
}
