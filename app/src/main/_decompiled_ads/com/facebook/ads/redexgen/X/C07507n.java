package com.facebook.ads.redexgen.X;

import android.os.Process;
import android.text.TextUtils;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7n, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C07507n implements Thread.UncaughtExceptionHandler {
    public static byte[] A04;
    public final Y9 A00;
    public final InterfaceC07567u A01;
    public final Thread.UncaughtExceptionHandler A02;
    public final Map<String, String> A03;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 65);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{42, 28, 94, 122, 96, 96, 122, 125, 116, 51, 80, 124, 125, 103, 118, 107, 103, 11, 7, 5, 70, 14, 9, 11, 13, 10, 7, 7, 3, 70, 9, 12, 27, 71, 86, 69, 87, 76, 20, 18, 5, 19, 30, 23, 2, 80, 86, 65, 87, 90, 83, 70, 124, SignedBytes.MAX_POWER_OF_TWO, 76, 71, 70};
    }

    public C07507n(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Y9 y9, InterfaceC07497m interfaceC07497m) {
        this(uncaughtExceptionHandler, y9, interfaceC07497m, C07577v.A00());
    }

    public C07507n(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Y9 y9, InterfaceC07497m interfaceC07497m, InterfaceC07567u interfaceC07567u) {
        this.A02 = uncaughtExceptionHandler;
        if (y9 != null) {
            this.A00 = y9;
            this.A03 = interfaceC07497m.A7r(y9);
            this.A01 = interfaceC07567u;
            return;
        }
        throw new IllegalArgumentException(A00(2, 15, 82));
    }

    public static void A02() {
        try {
            Process.killProcess(Process.myPid());
        } catch (Throwable unused) {
        }
        try {
            System.exit(10);
        } catch (Throwable unused2) {
        }
    }

    private void A03(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.A02;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            A02();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            String strA03 = LD.A03(this.A00, th);
            if (!TextUtils.isEmpty(strA03)) {
                String stackTraceString = A00(17, 16, 41);
                if (strA03.contains(stackTraceString)) {
                    Map<String, String> mapA02 = new C07487l(strA03, this.A03).A02();
                    String strA00 = A00(38, 7, 38);
                    String stackTraceString2 = A00(33, 5, 101);
                    mapA02.put(strA00, stackTraceString2);
                    Throwable thA00 = AbstractRunnableC1043Jv.A00();
                    String strA01 = A00(45, 12, 98);
                    if (thA00 != th) {
                        String stackTraceString3 = A00(0, 1, 91);
                        mapA02.put(strA01, stackTraceString3);
                    } else {
                        String stackTraceString4 = A00(1, 1, 108);
                        mapA02.put(strA01, stackTraceString4);
                    }
                    this.A01.AGU(new AnonymousClass81(this.A00.A08().A01(), this.A00.A08().A02(), mapA02), this.A00);
                    if (IP.A1g(this.A00)) {
                        IP.A0d(this.A00);
                    }
                }
            }
        } catch (Exception unused) {
        }
        A03(thread, th);
    }
}
