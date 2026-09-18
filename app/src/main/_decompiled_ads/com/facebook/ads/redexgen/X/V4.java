package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class V4 implements InterfaceC0951Gc {
    public static byte[] A07;
    public static String[] A08 = {"CpiOlZ", "ukFexlYSIMwQqH0UvFPWGqG0YthdqpHq", "2yw2Gs2GC2jxZI0Hgcr1UjVZgWf7BNvx", "7SwPVGS0jIrCQlvIcpAA6U9bhm4jPR5r", "7pQ8HXcSNS6Xqd33VYljkiTEbCcLAkDq", "kKrkJSZnynA87WgMdnYScFfJH7qszUrQ", "lo5", "kH5jcAc5XMYXCXQVRoC"};
    public long A00;
    public AssetFileDescriptor A01;
    public Uri A02;
    public InputStream A03;
    public boolean A04;
    public final Resources A05;
    public final InterfaceC0971Gy<? super V4> A06;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 71);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{-9, 10, 24, 20, 26, 23, 8, 10, -59, 14, 9, 10, 19, 25, 14, 11, 14, 10, 23, -59, 18, 26, 24, 25, -59, 7, 10, -59, 6, 19, -59, 14, 19, 25, 10, 12, 10, 23, -45, 5, 2, -7, -48, 29, 37, 35, 36, -48, 37, 35, 21, -48, 35, 19, 24, 21, 29, 21, -48, 34, 17, 39, 34, 21, 35, 31, 37, 34, 19, 21, 36, 19, 41, 36, 23, 37, 33, 39, 36, 21, 23};
    }

    static {
        A01();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Gy != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.thirdparty.upstream.RawResourceDataSource> */
    public V4(Context context, InterfaceC0971Gy<? super V4> interfaceC0971Gy) {
        this.A05 = context.getResources();
        this.A06 = interfaceC0971Gy;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final Uri A85() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final long ADb(C0955Gg c0955Gg) throws IOException {
        try {
            Uri uri = c0955Gg.A04;
            this.A02 = uri;
            if (TextUtils.equals(A00(70, 11, 107), uri.getScheme())) {
                try {
                    this.A01 = this.A05.openRawResourceFd(Integer.parseInt(this.A02.getLastPathSegment()));
                    FileInputStream fileInputStream = new FileInputStream(this.A01.getFileDescriptor());
                    this.A03 = fileInputStream;
                    fileInputStream.skip(this.A01.getStartOffset());
                    long jSkip = this.A03.skip(c0955Gg.A03);
                    long skipped = c0955Gg.A03;
                    if (jSkip >= skipped) {
                        if (c0955Gg.A02 != -1) {
                            this.A00 = c0955Gg.A02;
                        } else {
                            long length = this.A01.getLength();
                            if (A08[7].length() != 19) {
                                throw new RuntimeException();
                            }
                            A08[0] = "nEQCtk";
                            this.A00 = length != -1 ? length - c0955Gg.A03 : -1L;
                        }
                        this.A04 = true;
                        InterfaceC0971Gy<? super V4> interfaceC0971Gy = this.A06;
                        if (interfaceC0971Gy != null) {
                            interfaceC0971Gy.ADF(this, c0955Gg);
                        }
                        return this.A00;
                    }
                    throw new EOFException();
                } catch (NumberFormatException unused) {
                    throw new C0970Gx(A00(0, 39, 94));
                }
            }
            throw new C0970Gx(A00(39, 31, 105));
        } catch (IOException e) {
            throw new C0970Gx(e);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x002b */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void close() throws com.facebook.ads.redexgen.X.C0970Gx {
        /*
            r4 = this;
            r3 = 0
            r4.A02 = r3
            r2 = 0
            java.io.InputStream r0 = r4.A03     // Catch: java.io.IOException -> L3c java.lang.Throwable -> L43
            if (r0 == 0) goto Lb
            r0.close()     // Catch: java.io.IOException -> L3c java.lang.Throwable -> L43
        Lb:
            r4.A03 = r3
            android.content.res.AssetFileDescriptor r0 = r4.A01     // Catch: java.io.IOException -> L24 java.lang.Throwable -> L2b
            if (r0 == 0) goto L14
            r0.close()     // Catch: java.io.IOException -> L24 java.lang.Throwable -> L2b
        L14:
            r4.A01 = r3
            boolean r0 = r4.A04
            if (r0 == 0) goto L23
            r4.A04 = r2
            com.facebook.ads.redexgen.X.Gy<? super com.facebook.ads.redexgen.X.V4> r0 = r4.A06
            if (r0 == 0) goto L23
            r0.ADE(r4)
        L23:
            return
        L24:
            r1 = move-exception
            com.facebook.ads.redexgen.X.Gx r0 = new com.facebook.ads.redexgen.X.Gx     // Catch: java.lang.Throwable -> L2b
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L2b
            throw r0     // Catch: java.lang.Throwable -> L2b
        L2b:
            r1 = move-exception
            r4.A01 = r3
            boolean r0 = r4.A04
            if (r0 == 0) goto L3b
            r4.A04 = r2
            com.facebook.ads.redexgen.X.Gy<? super com.facebook.ads.redexgen.X.V4> r0 = r4.A06
            if (r0 == 0) goto L3b
            r0.ADE(r4)
        L3b:
            throw r1
        L3c:
            r1 = move-exception
            com.facebook.ads.redexgen.X.Gx r0 = new com.facebook.ads.redexgen.X.Gx     // Catch: java.lang.Throwable -> L43
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L43
            throw r0     // Catch: java.lang.Throwable -> L43
        L43:
            r1 = move-exception
            r4.A03 = r3
            android.content.res.AssetFileDescriptor r0 = r4.A01     // Catch: java.io.IOException -> L5d java.lang.Throwable -> L64
            if (r0 == 0) goto L4d
            r0.close()     // Catch: java.io.IOException -> L5d java.lang.Throwable -> L64
        L4d:
            r4.A01 = r3
            boolean r0 = r4.A04
            if (r0 == 0) goto L5c
            r4.A04 = r2
            com.facebook.ads.redexgen.X.Gy<? super com.facebook.ads.redexgen.X.V4> r0 = r4.A06
            if (r0 == 0) goto L5c
            r0.ADE(r4)
        L5c:
            throw r1
        L5d:
            r1 = move-exception
            com.facebook.ads.redexgen.X.Gx r0 = new com.facebook.ads.redexgen.X.Gx     // Catch: java.lang.Throwable -> L64
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L64
            throw r0     // Catch: java.lang.Throwable -> L64
        L64:
            r1 = move-exception
            r4.A01 = r3
            boolean r0 = r4.A04
            if (r0 == 0) goto L74
            r4.A04 = r2
            com.facebook.ads.redexgen.X.Gy<? super com.facebook.ads.redexgen.X.V4> r0 = r4.A06
            if (r0 == 0) goto L74
            r0.ADE(r4)
        L74:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.V4.close():void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.A00;
        if (A08[3].charAt(24) == 'w') {
            throw new RuntimeException();
        }
        A08[0] = "oumASG";
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new C0970Gx(e);
            }
        }
        int i3 = this.A03.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.A00 == -1) {
                return -1;
            }
            throw new C0970Gx(new EOFException());
        }
        long j2 = this.A00;
        if (j2 != -1) {
            this.A00 = j2 - ((long) i3);
        }
        InterfaceC0971Gy<? super V4> interfaceC0971Gy = this.A06;
        if (interfaceC0971Gy != null) {
            interfaceC0971Gy.AAm(this, i3);
        }
        return i3;
    }
}
