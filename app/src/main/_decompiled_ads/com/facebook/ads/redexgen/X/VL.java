package com.facebook.ads.redexgen.X;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class VL implements InterfaceC0951Gc {
    public static byte[] A07;
    public static String[] A08 = {"LByWpbEPJA", "7zBd1gTQe", "KuygTrv8nulqhNSWOngA1uKtSEuZHgRN", "Njgdt1gsnhQwK4o", "BeNPg2roj36bAWsP0", "RQRmVWofVgKwOSOG8v2k1lAFTXU782LE", "P3wGsXlJvJ2cmEHDxz1oaqJg", "cQN91p4HTGgxD32"};
    public long A00;
    public AssetFileDescriptor A01;
    public Uri A02;
    public FileInputStream A03;
    public boolean A04;
    public final ContentResolver A05;
    public final InterfaceC0971Gy<? super VL> A06;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 104);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{77, 97, 123, 98, 106, 46, 96, 97, 122, 46, 97, 126, 107, 96, 46, 104, 103, 98, 107, 46, 106, 107, 125, 109, 124, 103, 126, 122, 97, 124, 46, 104, 97, 124, 52, 46, 88};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 10
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:147)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final long ADb(C0955Gg c0955Gg) throws GY {
        try {
            Uri uri = c0955Gg.A04;
            this.A02 = uri;
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.A05.openAssetFileDescriptor(uri, A00(36, 1, 66));
            this.A01 = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new FileNotFoundException(A00(0, 36, 102) + this.A02);
            }
            this.A03 = new FileInputStream(this.A01.getFileDescriptor());
            long startOffset = this.A01.getStartOffset();
            long jSkip = this.A03.skip(c0955Gg.A03 + startOffset) - startOffset;
            if (jSkip != c0955Gg.A03) {
                throw new EOFException();
            }
            if (c0955Gg.A02 != -1) {
                this.A00 = c0955Gg.A02;
            } else {
                long length = this.A01.getLength();
                if (length == -1) {
                    FileChannel channel = this.A03.getChannel();
                    long size = channel.size();
                    this.A00 = size != 0 ? size - channel.position() : -1L;
                } else {
                    this.A00 = length - jSkip;
                }
            }
            this.A04 = true;
            InterfaceC0971Gy<? super VL> interfaceC0971Gy = this.A06;
            if (interfaceC0971Gy != null) {
                interfaceC0971Gy.ADF(this, c0955Gg);
            }
            return this.A00;
        } catch (IOException e) {
            throw new GY(e);
        }
    }

    static {
        A01();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Gy != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.thirdparty.upstream.ContentDataSource> */
    public VL(Context context, InterfaceC0971Gy<? super VL> interfaceC0971Gy) {
        this.A05 = context.getContentResolver();
        this.A06 = interfaceC0971Gy;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final Uri A85() {
        return this.A02;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x002b */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void close() throws com.facebook.ads.redexgen.X.GY {
        /*
            r4 = this;
            r3 = 0
            r4.A02 = r3
            r2 = 0
            java.io.FileInputStream r0 = r4.A03     // Catch: java.io.IOException -> L3c java.lang.Throwable -> L43
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
            com.facebook.ads.redexgen.X.Gy<? super com.facebook.ads.redexgen.X.VL> r0 = r4.A06
            if (r0 == 0) goto L23
            r0.ADE(r4)
        L23:
            return
        L24:
            r1 = move-exception
            com.facebook.ads.redexgen.X.GY r0 = new com.facebook.ads.redexgen.X.GY     // Catch: java.lang.Throwable -> L2b
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L2b
            throw r0     // Catch: java.lang.Throwable -> L2b
        L2b:
            r1 = move-exception
            r4.A01 = r3
            boolean r0 = r4.A04
            if (r0 == 0) goto L3b
            r4.A04 = r2
            com.facebook.ads.redexgen.X.Gy<? super com.facebook.ads.redexgen.X.VL> r0 = r4.A06
            if (r0 == 0) goto L3b
            r0.ADE(r4)
        L3b:
            throw r1
        L3c:
            r1 = move-exception
            com.facebook.ads.redexgen.X.GY r0 = new com.facebook.ads.redexgen.X.GY     // Catch: java.lang.Throwable -> L43
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
            com.facebook.ads.redexgen.X.Gy<? super com.facebook.ads.redexgen.X.VL> r0 = r4.A06
            if (r0 == 0) goto L5c
            r0.ADE(r4)
        L5c:
            throw r1
        L5d:
            r1 = move-exception
            com.facebook.ads.redexgen.X.GY r0 = new com.facebook.ads.redexgen.X.GY     // Catch: java.lang.Throwable -> L64
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L64
            throw r0     // Catch: java.lang.Throwable -> L64
        L64:
            r1 = move-exception
            r4.A01 = r3
            boolean r0 = r4.A04
            if (r0 == 0) goto L74
            r4.A04 = r2
            com.facebook.ads.redexgen.X.Gy<? super com.facebook.ads.redexgen.X.VL> r0 = r4.A06
            if (r0 == 0) goto L74
            r0.ADE(r4)
        L74:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.VL.close():void");
    }

    /* JADX WARN: Code duplicated, block: B:28:0x006d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0089  */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.A00;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new GY(e);
            }
        }
        int i3 = this.A03.read(bArr, i, i2);
        if (i3 == -1) {
            long j2 = this.A00;
            String[] strArr = A08;
            String str = strArr[3];
            String str2 = strArr[7];
            int length = str.length();
            int bytesRead = str2.length();
            if (length != bytesRead) {
                throw new RuntimeException();
            }
            A08[0] = "iixlGiSV2y9Sj4FhSzJ8n8KndyylS";
            if (j2 == -1) {
                return -1;
            }
            throw new GY(new EOFException());
        }
        long j3 = this.A00;
        if (A08[0].length() != 5) {
            A08[0] = "YPxf1aEs9O2Lc7g4LGclNCu";
            if (j3 != -1) {
                this.A00 = j3 - ((long) i3);
            }
        } else if (j3 != -1) {
            this.A00 = j3 - ((long) i3);
        }
        InterfaceC0971Gy<? super VL> interfaceC0971Gy = this.A06;
        if (A08[4].length() != 17) {
            A08[0] = "Oz3XLfSc2A979xkKdF0NMgeVRm8";
            if (interfaceC0971Gy != null) {
                interfaceC0971Gy.AAm(this, i3);
            }
        } else {
            String[] strArr2 = A08;
            strArr2[1] = "uqZ1tM2xm";
            strArr2[6] = "4bkl7P4p23vj4jNsoeIfag2n";
            if (interfaceC0971Gy != null) {
                interfaceC0971Gy.AAm(this, i3);
            }
        }
        return i3;
    }
}
