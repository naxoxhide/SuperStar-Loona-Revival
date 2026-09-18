package com.tapjoy.internal;

import android.os.SystemClock;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes4.dex */
public final class f7 {
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2756b;
    public long c;

    public final boolean a(int i) throws Throwable {
        DatagramSocket datagramSocket = null;
        try {
            DatagramSocket datagramSocket2 = new DatagramSocket();
            try {
                datagramSocket2.setSoTimeout(i);
                byte[] bArr = new byte[48];
                DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, InetAddress.getByName("pool.ntp.org"), 123);
                bArr[0] = 27;
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                a(bArr, jCurrentTimeMillis);
                datagramSocket2.send(datagramPacket);
                datagramSocket2.receive(new DatagramPacket(bArr, 48));
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                long j = jElapsedRealtime2 - jElapsedRealtime;
                long j2 = jCurrentTimeMillis + j;
                long jA = a(bArr, 24);
                long jA2 = ((a(bArr, 28) * 1000) / 4294967296L) + ((jA - 2208988800L) * 1000);
                long jA3 = a(bArr, 32);
                long jA4 = ((a(bArr, 36) * 1000) / 4294967296L) + ((jA3 - 2208988800L) * 1000);
                long jA5 = a(bArr, 40);
                long jA6 = ((a(bArr, 44) * 1000) / 4294967296L) + ((jA5 - 2208988800L) * 1000);
                long j3 = j - (jA6 - jA4);
                this.a = j2 + (((jA6 - j2) + (jA4 - jA2)) / 2);
                this.f2756b = jElapsedRealtime2;
                this.c = j3;
                datagramSocket2.close();
                return true;
            } catch (Exception unused) {
                datagramSocket = datagramSocket2;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                datagramSocket = datagramSocket2;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static long a(byte[] bArr, int i) {
        int i2 = bArr[i];
        int i3 = bArr[i + 1];
        int i4 = bArr[i + 2];
        int i5 = bArr[i + 3];
        if ((i2 & 128) == 128) {
            i2 = (i2 & WorkQueueKt.MASK) + 128;
        }
        if ((i3 & 128) == 128) {
            i3 = (i3 & WorkQueueKt.MASK) + 128;
        }
        if ((i4 & 128) == 128) {
            i4 = (i4 & WorkQueueKt.MASK) + 128;
        }
        if ((i5 & 128) == 128) {
            i5 = (i5 & WorkQueueKt.MASK) + 128;
        }
        return (((long) i2) << 24) + (((long) i3) << 16) + (((long) i4) << 8) + ((long) i5);
    }

    public static void a(byte[] bArr, long j) {
        long j2 = j / 1000;
        long j3 = j - (j2 * 1000);
        long j4 = j2 + 2208988800L;
        bArr[40] = (byte) (j4 >> 24);
        bArr[41] = (byte) (j4 >> 16);
        bArr[42] = (byte) (j4 >> 8);
        bArr[43] = (byte) (j4 >> 0);
        long j5 = (j3 * 4294967296L) / 1000;
        bArr[44] = (byte) (j5 >> 24);
        bArr[45] = (byte) (j5 >> 16);
        bArr[46] = (byte) (j5 >> 8);
        bArr[47] = (byte) (Math.random() * 255.0d);
    }
}
