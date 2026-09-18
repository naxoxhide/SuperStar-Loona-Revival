package com.twobigears.audio360exo2;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class OpusJNI {
    public static final boolean IS_AVAILABLE;

    public static native void opusClose(long j);

    public static native <T> int opusDecode(long j, long j2, ByteBuffer byteBuffer, int i, T t, int i2, int i3);

    public static native long opusInit(int i, int i2, int i3, int i4, int i5, byte[] bArr);

    public static native void opusReset(long j);

    static {
        boolean z;
        try {
            System.loadLibrary("opus");
            System.loadLibrary("opusJNI");
            z = true;
        } catch (UnsatisfiedLinkError unused) {
            z = false;
        }
        IS_AVAILABLE = z;
    }
}
