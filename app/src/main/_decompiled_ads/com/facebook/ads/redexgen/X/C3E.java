package com.facebook.ads.redexgen.X;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmInitData;
import com.google.common.primitives.SignedBytes;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3E, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C3E extends AbstractC0882Dl {
    public static byte[] A0d;
    public static String[] A0e = {"el1NIdjJdnQk8rQ7yI3DLJMJGUNGpsaL", "cMnDkAErKs2M6cVzDcwdPqTaRDuVL2G6", "3Ljz1yFix4teFI07gFBJ1ZVJZ4Elk", "rfweshkfyu7YGNu9gmTN5aJbUxr0jD44", "UwDJ5OwzyxxJZbvw2og9SG", "E", "kELoxR7DFwuexd5ZjpenISH", "LMGopoJZLCWwOw1IQPtLBjMdbqq8sxxW"};
    public static final byte[] A0f;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public long A05;
    public MediaCodec A06;
    public Format A07;
    public BJ<X6> A08;
    public BJ<X6> A09;
    public C0874Cy A0A;
    public ByteBuffer A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public boolean A0K;
    public boolean A0L;
    public boolean A0M;
    public boolean A0N;
    public boolean A0O;
    public boolean A0P;
    public boolean A0Q;
    public boolean A0R;
    public ByteBuffer[] A0S;
    public ByteBuffer[] A0T;
    public C0832Au A0U;
    public final MediaCodec.BufferInfo A0V;
    public final C9X A0W;
    public final XE A0X;
    public final XE A0Y;
    public final BK<X6> A0Z;
    public final D4 A0a;
    public final List<Long> A0b;
    public final boolean A0c;

    public static String A0Z(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0d, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = (bArrCopyOfRange[i4] ^ i3) ^ 57;
            if (A0e[5].length() == 20) {
                throw new RuntimeException();
            }
            A0e[0] = "GT4OiQXgMfCUtJ1QRZ1mZZkQ0KPtv7dD";
            bArrCopyOfRange[i4] = (byte) i5;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0j() {
        A0d = new byte[]{85, 89, 27, 12, 13, 89, 23, 22, 89, 10, 28, 26, 12, 11, 28, 89, 29, 28, 26, 22, 29, 28, 11, 89, 24, 15, 24, 16, 21, 24, 27, 21, 28, 87, 89, 45, 11, 0, 16, 23, 30, 89, 13, 22, 89, 9, 11, 22, 26, 28, 28, 29, 89, 14, 16, 13, 17, 89, 19, 106, 106, 106, 106, 106, 107, 108, 109, 110, 104, 25, 106, 106, 24, 30, 27, 104, 111, 99, 106, 106, 106, 106, 106, 106, 107, 108, 98, 25, 31, 106, 28, 107, 105, 104, 106, 106, 106, 106, 106, 106, 107, 108, 111, 98, 98, 98, 110, 106, 30, 25, 31, 109, 107, 107, 98, 27, 106, 106, 106, 104, 28, 24, 28, 107, 25, 105, 107, 25, 105, 104, 109, 111, 30, 109, 98, 107, 108, 126, 104, 3, 4, 22, 15, 88, 95, 77, 74, 23, 59, 55, 44, 57, 56, 0, 54, 41, 100, 55, 33, 55, 55, 45, 43, 42, 100, 54, 33, 53, 49, 45, 54, 33, 55, 100, 55, 33, 39, 49, 54, 33, 100, 32, 33, 39, 43, 32, 33, 54, 100, 34, 43, 54, 100, 71, 111, 110, 99, 107, 42, 120, 111, 123, 127, 99, 120, 111, 121, 42, 107, 42, 78, 120, 103, 89, 111, 121, 121, 99, 101, 100, 71, 107, 100, 107, 109, 111, 120, 34, 10, 11, 6, 14, 44, 0, 11, 10, 12, Base64.padSymbol, 10, 1, 11, 10, 29, 10, 29, 42, 40, Base64.padSymbol, 75, 32, 29, 28, 11, 10, 22, 75, 4, 19, 6, 75, 1, 0, 6, 80, 82, 71, 49, 90, 103, 102, 113, 112, 108, 49, 126, 105, 124, 49, 123, 122, 124, 49, 108, 122, 124, 106, 109, 122, 36, 38, 51, 69, 38, 63, 32, 69, 42, 62, 47, 34, 36, 69, 47, 46, 40, 36, 47, 46, 57, 69, 38, 59, 88, 63, Base64.padSymbol, 40, 94, Base64.padSymbol, 36, 59, 94, 38, 57, 52, 53, 63, 94, 52, 53, 51, 63, 52, 53, 34, 94, 49, 38, 51, 14, 12, 25, 111, 15, 55, 40, 37, 40, 32, 111, 41, 115, 119, 117, 111, 37, 36, 34, 46, 37, 36, 4, 6, 19, 101, 5, Base64.padSymbol, 34, 47, 34, 42, 101, 35, 121, 125, 127, 101, 47, 46, 40, 36, 47, 46, 101, 56, 46, 40, 62, 57, 46, 4, 6, 19, 101, 24, 14, 8, 101, 42, Base64.padSymbol, 40, 101, 47, 46, 40, 75, 73, 92, 42, 87, 65, 71, 42, 101, 114, 103, 42, 96, 97, 103, 42, 119, 97, 103, 113, 118, 97, 110, 108, 121, 15, SignedBytes.MAX_POWER_OF_TWO, 77, 77, 86, 72, 79, 79, 68, 83, 15, 87, 72, 69, 68, 78, 15, 69, 68, 66, 78, 69, 68, 83, 15, SignedBytes.MAX_POWER_OF_TWO, 87, 66, 87, 85, SignedBytes.MAX_POWER_OF_TWO, 54, 121, 117, 116, 119, 127, 113, 123, 54, 121, 110, 123, 54, 124, 125, 123, 119, 124, 125, 106, 54, 121, 111, 125, 107, 119, 117, 125, 114, 112, 101, 19, 92, 80, 81, 82, 90, 84, 94, 19, 92, 75, 94, 19, 89, 88, 94, 82, 89, 88, 79, 19, 92, 74, 88, 78, 82, 80, 88, 19, 78, 88, 94, 72, 79, 88, 123, 121, 108, 26, 83, 91, 91, 83, 88, 81, 26, 85, 85, 87, 26, 80, 81, 87, 91, 80, 81, 70, 95, 93, 72, 62, 119, 127, 127, 119, 124, 117, 62, 102, 127, 98, 114, 121, 99, 62, 116, 117, 115, 127, 116, 117, 98, 38, 36, 49, 71, 27, 2, 71, 31, 0, 13, 12, 6, 54, 13, 12, 10, 6, 13, 12, 27, 71, 8, 31, 10, 57, 39, 71, 43, 95, 91, 90, 11, 21, 117, 25, 109, 106, 104, 105, 119, 23, 125, 2, 10, 10, 90, 68, 36, 67, 62, 57, 57, 76, 82, 50, 75, 42, 39, 42, 11, 0, 9, 6, 6, 13, 4, 69, 11, 7, 29, 6, 28, 4, 8, 9, 1, 14, 0, 18, 21, 2, 36, 8, 3, 2, 4, 125, 108, 123, 127, 106, 123, 93, 113, 122, 123, 125, 36, 28, 10, 25, 17, 22, 57, 22, 28, 62, 29, 29, 28, 57, 51, 48, 42, 49, 59, 58, 45, 106, 96, 99, 121, 98, 104, 105, 126, 83, 96, 120, 105, 1, 20, 9, 19, 22, 3, 20, SignedBytes.MAX_POWER_OF_TWO, 74, 26, 24, 24, 24, 62, 51, 63, 49, 62, 34, 125, 122, 111, 124, 122, 77, 97, 106, 107, 109, 66, 95, 90, 87, 70, 95, 87, 51, 45, 32, 48, 44};
    }

    public abstract int A1B(D4 d4, BK<X6> bk, Format format) throws D7;

    public abstract void A1N(C0874Cy c0874Cy, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws D7;

    public abstract boolean A1P(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws C9K;

    static {
        A0j();
        A0f = C0996Hx.A0h(A0Z(59, 76, 99));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BK != com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.thirdparty.drm.FrameworkMediaCrypto> */
    public C3E(int i, D4 d4, BK<X6> bk, boolean z) {
        super(i);
        HI.A04(C0996Hx.A02 >= 16);
        this.A0a = (D4) HI.A01(d4);
        this.A0Z = bk;
        this.A0c = z;
        this.A0X = new XE(0);
        this.A0Y = XE.A02();
        this.A0W = new C9X();
        this.A0b = new ArrayList();
        this.A0V = new MediaCodec.BufferInfo();
        this.A01 = 0;
        this.A02 = 0;
    }

    private int A0W(String str) {
        if (C0996Hx.A02 <= 25 && A0Z(263, 25, 38).equals(str) && (C0996Hx.A06.startsWith(A0Z(625, 7, 38)) || C0996Hx.A06.startsWith(A0Z(597, 7, 83)) || C0996Hx.A06.startsWith(A0Z(604, 7, 97)) || C0996Hx.A06.startsWith(A0Z(618, 7, 48)))) {
            return 2;
        }
        if (C0996Hx.A02 < 24) {
            if (A0Z(338, 22, 120).equals(str) || A0Z(360, 29, 114).equals(str)) {
                if (!A0Z(683, 8, 102).equals(C0996Hx.A03)) {
                    if (!A0Z(691, 12, 53).equals(C0996Hx.A03)) {
                        if (!A0Z(703, 7, 95).equals(C0996Hx.A03)) {
                            if (A0Z(732, 7, 15).equals(C0996Hx.A03)) {
                                return 1;
                            }
                            return 0;
                        }
                        return 1;
                    }
                    return 1;
                }
                return 1;
            }
            return 0;
        }
        return 0;
    }

    private final long A0X() {
        return 0L;
    }

    public static MediaCodec.CryptoInfo A0Y(XE xe, int i) {
        MediaCodec.CryptoInfo cryptoInfoA02 = xe.A02.A02();
        if (i == 0) {
            return cryptoInfoA02;
        }
        if (cryptoInfoA02.numBytesOfClearData == null) {
            cryptoInfoA02.numBytesOfClearData = new int[1];
        }
        int[] iArr = cryptoInfoA02.numBytesOfClearData;
        int i2 = iArr[0];
        if (A0e[2].length() == 1) {
            throw new RuntimeException();
        }
        String[] strArr = A0e;
        strArr[7] = "NOzrMPRB76F8DdbUb3OPVPb4rTNpEGvY";
        strArr[3] = "IDmZDsJhwqXuUzopfYWLVElAjmr2DtdU";
        iArr[0] = i2 + i;
        return cryptoInfoA02;
    }

    private ByteBuffer A0a(int i) {
        if (C0996Hx.A02 >= 21) {
            return this.A06.getInputBuffer(i);
        }
        ByteBuffer byteBuffer = this.A0S[i];
        String[] strArr = A0e;
        if (strArr[4].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0e;
        strArr2[7] = "akmimywpCQzy2zgGqC6e1Zi0HtFx9MqZ";
        strArr2[3] = "4g16x1WFaX1F1Ai56lyJAgpz1Kjl0dDQ";
        return byteBuffer;
    }

    private ByteBuffer A0b(int i) {
        if (C0996Hx.A02 >= 21) {
            return this.A06.getOutputBuffer(i);
        }
        return this.A0T[i];
    }

    private void A0c() {
        if (C0996Hx.A02 < 21) {
            this.A0S = this.A06.getInputBuffers();
            MediaCodec mediaCodec = this.A06;
            if (A0e[5].length() == 20) {
                throw new RuntimeException();
            }
            A0e[2] = "BQUwUvW99pDNY9ExELsrhPAvhUrne6";
            this.A0T = mediaCodec.getOutputBuffers();
        }
    }

    private void A0d() throws C9K {
        if (this.A02 == 2) {
            A1G();
            A1I();
        } else {
            this.A0N = true;
            A1H();
        }
    }

    private void A0e() {
        if (C0996Hx.A02 < 21) {
            this.A0T = this.A06.getOutputBuffers();
        }
    }

    private void A0f() throws C9K {
        MediaFormat outputFormat = this.A06.getOutputFormat();
        if (this.A00 != 0 && outputFormat.getInteger(A0Z(739, 5, 125)) == 32 && outputFormat.getInteger(A0Z(716, 6, 111)) == 32) {
            this.A0O = true;
            return;
        }
        if (this.A0I) {
            outputFormat.setInteger(A0Z(632, 13, 81), 1);
        }
        A1K(this.A06, outputFormat);
    }

    private void A0g() {
        if (C0996Hx.A02 < 21) {
            this.A0S = null;
            this.A0T = null;
        }
    }

    private void A0h() {
        this.A03 = -1;
        this.A0X.A01 = null;
    }

    private void A0i() {
        this.A04 = -1;
        this.A0B = null;
    }

    private void A0k(D0 d0) throws C9K {
        throw C9K.A01(d0, A0y());
    }

    private boolean A0l() {
        if (A0Z(147, 6, 111).equals(C0996Hx.A05)) {
            if (!A0Z(139, 4, 123).equals(C0996Hx.A06)) {
                if (A0Z(135, 4, 19).equals(C0996Hx.A06)) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0139, code lost:
    
        if (r6 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x013b, code lost:
    
        A0d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x013e, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0146, code lost:
    
        if (r6 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x014b, code lost:
    
        if (r14.A0G == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x014e, code lost:
    
        r14.A0K = true;
        r14.A06.queueInputBuffer(r14.A03, 0, 0, 0, 4);
        A0h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x015f, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0160, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0169, code lost:
    
        throw com.facebook.ads.redexgen.X.C9K.A01(r1, A0y());
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x018a, code lost:
    
        if (r8.A05() == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x018c, code lost:
    
        r14.A0X.A07();
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0193, code lost:
    
        if (r14.A01 != 2) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0195, code lost:
    
        r14.A01 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0197, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01a8, code lost:
    
        if (r8.A05() == false) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0m() throws com.facebook.ads.redexgen.X.C9K {
        /*
            Method dump skipped, instruction units count: 574
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3E.A0m():boolean");
    }

    private boolean A0n() {
        return this.A04 >= 0;
    }

    private boolean A0o(long j) {
        int size = this.A0b.size();
        for (int i = 0; i < size; i++) {
            if (this.A0b.get(i).longValue() == j) {
                this.A0b.remove(i);
                int i2 = A0e[1].charAt(18);
                if (i2 != 119) {
                    throw new RuntimeException();
                }
                A0e[5] = "GAQPkPxILqrNxqRn";
                return true;
            }
        }
        return false;
    }

    private boolean A0p(long j, long j2) throws C9K {
        boolean processedOutputBuffer;
        int iDequeueOutputBuffer;
        if (!A0n()) {
            if (this.A0F && this.A0K) {
                try {
                    iDequeueOutputBuffer = this.A06.dequeueOutputBuffer(this.A0V, A0X());
                } catch (IllegalStateException unused) {
                    A0d();
                    if (this.A0N) {
                        A1G();
                    }
                    return false;
                }
            } else {
                iDequeueOutputBuffer = this.A06.dequeueOutputBuffer(this.A0V, A0X());
            }
            if (iDequeueOutputBuffer >= 0) {
                if (this.A0O) {
                    this.A0O = false;
                    this.A06.releaseOutputBuffer(iDequeueOutputBuffer, false);
                    return true;
                }
                int outputIndex = this.A0V.size;
                if (outputIndex == 0) {
                    int outputIndex2 = this.A0V.flags;
                    if ((outputIndex2 & 4) != 0) {
                        A0d();
                        return false;
                    }
                }
                this.A04 = iDequeueOutputBuffer;
                ByteBuffer byteBufferA0b = A0b(iDequeueOutputBuffer);
                this.A0B = byteBufferA0b;
                if (byteBufferA0b != null) {
                    int outputIndex3 = this.A0V.offset;
                    byteBufferA0b.position(outputIndex3);
                    ByteBuffer byteBuffer = this.A0B;
                    int i = this.A0V.offset;
                    int outputIndex4 = this.A0V.size;
                    int i2 = i + outputIndex4;
                    if (A0e[2].length() != 1) {
                        String[] strArr = A0e;
                        strArr[4] = "FaJE2XiArfhYqeNyfkTyaQ";
                        strArr[6] = "HvmGKe0EFE5f200jghUPQNW";
                        byteBuffer.limit(i2);
                    }
                }
                this.A0P = A0o(this.A0V.presentationTimeUs);
            } else if (A0e[5].length() != 20) {
                A0e[1] = "HT1pBWWLOYy8PEf8scwcSavywhmMK5P3";
                if (iDequeueOutputBuffer == -2) {
                    A0f();
                    String[] strArr2 = A0e;
                    String str = strArr2[4];
                    String str2 = strArr2[6];
                    int length = str.length();
                    int outputIndex5 = str2.length();
                    if (length == outputIndex5) {
                        return true;
                    }
                    A0e[5] = "todLl0dSZi0vPTtgICo1ottwNzErViL";
                    return true;
                }
                if (A0e[0].charAt(8) == 's') {
                    throw new RuntimeException();
                }
                A0e[5] = "4PVEqwR";
                if (iDequeueOutputBuffer == -3) {
                    A0e();
                    return true;
                }
                boolean z = this.A0G;
                if (A0e[0].charAt(8) == 's') {
                    throw new RuntimeException();
                }
                A0e[1] = "oPTnjsm2EBoNSW7B2QwBvulptlCCgQiW";
                if (z && (this.A0M || this.A02 == 2)) {
                    A0d();
                }
                return false;
            }
            throw new RuntimeException();
        }
        if (this.A0F && this.A0K) {
            try {
                processedOutputBuffer = A1P(j, j2, this.A06, this.A0B, this.A04, this.A0V.flags, this.A0V.presentationTimeUs, this.A0P);
            } catch (IllegalStateException unused2) {
                A0d();
                if (this.A0N) {
                    A1G();
                }
                return false;
            }
        } else {
            processedOutputBuffer = A1P(j, j2, this.A06, this.A0B, this.A04, this.A0V.flags, this.A0V.presentationTimeUs, this.A0P);
        }
        if (processedOutputBuffer) {
            A1J(this.A0V.presentationTimeUs);
            boolean processedOutputBuffer2 = (this.A0V.flags & 4) != 0;
            A0i();
            if (!processedOutputBuffer2) {
                return true;
            }
            A0d();
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0039  */
    /* JADX WARN: Code duplicated, block: B:12:0x004f  */
    /* JADX WARN: Code duplicated, block: B:19:0x006b  */
    /* JADX WARN: Code duplicated, block: B:8:0x0028  */
    public static boolean A0q(C0874Cy c0874Cy) {
        String str;
        String name;
        String strA0Z;
        String name2;
        String name3;
        String str2 = c0874Cy.A02;
        if (C0996Hx.A02 <= 17) {
            String name4 = A0Z(573, 24, 80);
            if (!name4.equals(str2)) {
                String name5 = A0Z(426, 31, 24);
                if (!name5.equals(str2)) {
                    str = C0996Hx.A05;
                    name = A0Z(147, 6, 111);
                    if (name.equals(str)) {
                        strA0Z = A0Z(143, 4, 32);
                        name2 = A0e[5];
                        if (name2.length() != 20) {
                            throw new RuntimeException();
                        }
                        String[] strArr = A0e;
                        strArr[4] = "ta8dfTbq5GbSxrQo9R7BCH";
                        strArr[6] = "TLzt7USKw6C8aMs6TrECz9n";
                        name3 = C0996Hx.A06;
                        if (strA0Z.equals(name3) || !c0874Cy.A05) {
                        }
                    }
                    return false;
                }
            }
        } else {
            str = C0996Hx.A05;
            name = A0Z(147, 6, 111);
            if (name.equals(str)) {
                strA0Z = A0Z(143, 4, 32);
                name2 = A0e[5];
                if (name2.length() != 20) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0e;
                strArr2[4] = "ta8dfTbq5GbSxrQo9R7BCH";
                strArr2[6] = "TLzt7USKw6C8aMs6TrECz9n";
                name3 = C0996Hx.A06;
                if (strA0Z.equals(name3)) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean A0r(String str) {
        if (C0996Hx.A02 > 23 || !A0Z(548, 25, 41).equals(str)) {
            if (C0996Hx.A02 <= 19) {
                if (!A0Z(710, 6, 17).equals(C0996Hx.A03) || (!A0Z(457, 31, 33).equals(str) && !A0Z(488, 38, 4).equals(str))) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean A0s(String str) {
        return C0996Hx.A02 == 21 && A0Z(526, 22, 13).equals(str);
    }

    public static boolean A0t(String str) {
        return C0996Hx.A02 < 18 || (C0996Hx.A02 == 18 && (A0Z(389, 15, 114).equals(str) || A0Z(TTAdConstant.DEEPLINK_FALLBACK_CODE, 22, 61).equals(str))) || (C0996Hx.A02 == 19 && C0996Hx.A06.startsWith(A0Z(611, 7, 3)) && (A0Z(245, 18, 92).equals(str) || A0Z(263, 25, 38).equals(str)));
    }

    public static boolean A0u(String str, Format format) {
        return C0996Hx.A02 < 21 && format.A0P.isEmpty() && A0Z(313, 25, 73).equals(str);
    }

    public static boolean A0v(String str, Format format) {
        return C0996Hx.A02 <= 18 && format.A05 == 1 && A0Z(288, 25, 82).equals(str);
    }

    private boolean A0w(boolean z) throws C9K {
        BJ<X6> bj = this.A08;
        if (bj == null || (!z && this.A0c)) {
            return false;
        }
        int iA7t = bj.A7t();
        if (iA7t != 1) {
            return iA7t != 4;
        }
        BH bhA6q = this.A08.A6q();
        int drmSessionState = A0y();
        throw C9K.A01(bhA6q, drmSessionState);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0882Dl
    public void A12() {
        this.A07 = null;
        try {
            A1G();
            try {
                BJ<X6> bj = this.A08;
                if (bj != null) {
                    this.A0Z.AEU(bj);
                }
                try {
                    BJ<X6> bj2 = this.A09;
                    if (bj2 != null && bj2 != this.A08) {
                        this.A0Z.AEU(bj2);
                    }
                } finally {
                    this.A08 = null;
                    this.A09 = null;
                }
            } catch (Throwable th) {
                try {
                    BJ<X6> bj3 = this.A09;
                    if (bj3 != null && bj3 != this.A08) {
                        this.A0Z.AEU(bj3);
                    }
                    throw th;
                } finally {
                    this.A08 = null;
                    this.A09 = null;
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.A08 != null) {
                    this.A0Z.AEU(this.A08);
                }
                try {
                    BJ<X6> bj4 = this.A09;
                    if (bj4 != null && bj4 != this.A08) {
                        this.A0Z.AEU(bj4);
                    }
                    throw th2;
                } finally {
                    this.A08 = null;
                    this.A09 = null;
                }
            } catch (Throwable th3) {
                try {
                    BJ<X6> bj5 = this.A09;
                    if (bj5 != null && bj5 != this.A08) {
                        this.A0Z.AEU(bj5);
                    }
                    throw th3;
                } finally {
                    this.A08 = null;
                    this.A09 = null;
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0882Dl
    public void A13() {
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0882Dl
    public void A14() {
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0882Dl
    public void A15(long j, boolean z) throws C9K {
        this.A0M = false;
        this.A0N = false;
        if (this.A06 != null) {
            A1F();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0882Dl
    public void A16(boolean z) throws C9K {
        this.A0U = new C0832Au();
    }

    public int A1A(MediaCodec mediaCodec, C0874Cy c0874Cy, Format format, Format format2) {
        return 0;
    }

    public final MediaCodec A1C() {
        return this.A06;
    }

    public final C0874Cy A1D() {
        return this.A0A;
    }

    public C0874Cy A1E(D4 d4, Format format, boolean z) throws D7 {
        return d4.A6f(format.A0O, z);
    }

    public void A1F() throws C9K {
        this.A05 = -9223372036854775807L;
        A0h();
        A0i();
        this.A0Q = true;
        this.A0R = false;
        this.A0P = false;
        this.A0b.clear();
        this.A0C = false;
        this.A0O = false;
        if (this.A0H || ((this.A0E && this.A0K) || this.A02 != 0)) {
            A1G();
            A1I();
        } else {
            this.A06.flush();
            this.A0J = false;
        }
        if (this.A0L && this.A07 != null) {
            this.A01 = 1;
        }
    }

    public void A1G() {
        this.A05 = -9223372036854775807L;
        A0h();
        A0i();
        this.A0R = false;
        this.A0P = false;
        this.A0b.clear();
        A0g();
        this.A0A = null;
        this.A0L = false;
        this.A0J = false;
        this.A0D = false;
        this.A0H = false;
        this.A00 = 0;
        this.A0G = false;
        this.A0E = false;
        this.A0I = false;
        this.A0C = false;
        this.A0O = false;
        this.A0K = false;
        this.A01 = 0;
        this.A02 = 0;
        if (this.A06 != null) {
            this.A0U.A01++;
            try {
                this.A06.stop();
                try {
                    this.A06.release();
                    this.A06 = null;
                    BJ<X6> bj = this.A08;
                    if (bj != null && this.A09 != bj) {
                        try {
                            this.A0Z.AEU(bj);
                        } finally {
                            this.A08 = null;
                        }
                    }
                } catch (Throwable th) {
                    this.A06 = null;
                    BJ<X6> bj2 = this.A08;
                    if (A0e[1].charAt(18) != 'w') {
                        throw new RuntimeException();
                    }
                    A0e[1] = "xSjaYNEZ4qh1ZPx8xTwjTufaVWwElX5P";
                    if (bj2 != null && this.A09 != bj2) {
                        try {
                            this.A0Z.AEU(bj2);
                        } finally {
                            this.A08 = null;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.A06.release();
                    this.A06 = null;
                    BJ<X6> bj3 = this.A08;
                    if (bj3 != null && this.A09 != bj3) {
                        try {
                            this.A0Z.AEU(bj3);
                        } finally {
                            this.A08 = null;
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.A06 = null;
                    BJ<X6> bj4 = this.A08;
                    if (bj4 != null) {
                        BJ<X6> bj5 = this.A09;
                        if (A0e[1].charAt(18) != 'w') {
                            throw new RuntimeException();
                        }
                        A0e[0] = "vD6SaWSNQpnT2etBhelIXAl4LKAzAMEb";
                        if (bj5 != bj4) {
                            try {
                                this.A0Z.AEU(bj4);
                            } finally {
                                this.A08 = null;
                            }
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    public void A1H() throws C9K {
    }

    public final void A1I() throws C9K {
        Format format;
        long jElapsedRealtime;
        if (this.A06 != null || (format = this.A07) == null) {
            return;
        }
        this.A08 = this.A09;
        String str = format.A0O;
        MediaCrypto mediaCryptoA00 = null;
        String[] strArr = A0e;
        if (strArr[7].charAt(15) == strArr[3].charAt(15)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0e;
        strArr2[7] = "pTVSxclXptnWdkcsOldSnbHbt080oNsP";
        strArr2[3] = "3A2dqVKC7anzB9bdQIqtLGHUlM9PHMrl";
        boolean zA01 = false;
        BJ<X6> bj = this.A08;
        if (bj != null) {
            X6 x6 = (X6) bj.A7G();
            if (x6 == null) {
                if (this.A08.A6q() == null) {
                    return;
                }
            } else {
                mediaCryptoA00 = x6.A00();
                zA01 = x6.A01(str);
            }
            if (A0l()) {
                int iA7t = this.A08.A7t();
                if (iA7t != 1) {
                    if (iA7t != 4) {
                        return;
                    }
                } else {
                    throw C9K.A01(this.A08.A6q(), A0y());
                }
            }
        }
        C0874Cy c0874Cy = this.A0A;
        String[] strArr3 = A0e;
        String str2 = strArr3[4];
        String mimeType = strArr3[6];
        if (str2.length() == mimeType.length()) {
            throw new RuntimeException();
        }
        A0e[5] = "oPP6wTkKkwktIyM";
        if (c0874Cy == null) {
            try {
                C0874Cy c0874CyA1E = A1E(this.A0a, this.A07, zA01);
                this.A0A = c0874CyA1E;
                if (c0874CyA1E == null && zA01) {
                    C0874Cy c0874CyA1E2 = A1E(this.A0a, this.A07, false);
                    this.A0A = c0874CyA1E2;
                    if (c0874CyA1E2 != null) {
                        String strA0Z = A0Z(227, 18, 86);
                        StringBuilder sb = new StringBuilder();
                        String mimeType2 = A0Z(153, 40, 125);
                        StringBuilder sbAppend = sb.append(mimeType2).append(str);
                        String mimeType3 = A0Z(0, 58, 64);
                        StringBuilder sbAppend2 = sbAppend.append(mimeType3);
                        String mimeType4 = this.A0A.A02;
                        StringBuilder sbAppend3 = sbAppend2.append(mimeType4);
                        String mimeType5 = A0Z(58, 1, 4);
                        Log.w(strA0Z, sbAppend3.append(mimeType5).toString());
                    }
                }
            } catch (D7 e) {
                A0k(new D0(this.A07, e, zA01, -49998));
            }
            if (this.A0A == null) {
                A0k(new D0(this.A07, (Throwable) null, zA01, -49999));
            }
        }
        if (!A1Q(this.A0A)) {
            return;
        }
        String str3 = this.A0A.A02;
        this.A00 = A0W(str3);
        this.A0D = A0u(str3, this.A07);
        this.A0H = A0t(str3);
        this.A0G = A0q(this.A0A);
        this.A0E = A0r(str3);
        this.A0F = A0s(str3);
        this.A0I = A0v(str3, this.A07);
        try {
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            StringBuilder sb2 = new StringBuilder();
            String mimeType6 = A0Z(659, 12, 39);
            C0993Hu.A02(sb2.append(mimeType6).append(str3).toString());
            this.A06 = MediaCodec.createByCodecName(str3);
            C0993Hu.A00();
            String mimeType7 = A0Z(645, 14, 94);
            C0993Hu.A02(mimeType7);
            A1N(this.A0A, this.A06, this.A07, mediaCryptoA00);
            C0993Hu.A00();
            String mimeType8 = A0Z(722, 10, 55);
            C0993Hu.A02(mimeType8);
            this.A06.start();
            C0993Hu.A00();
            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
            A1O(str3, jElapsedRealtime3, jElapsedRealtime3 - jElapsedRealtime2);
            A0c();
        } catch (Exception e2) {
            A0k(new D0(this.A07, e2, zA01, str3));
        }
        if (A7t() == 2) {
            jElapsedRealtime = SystemClock.elapsedRealtime() + 1000;
        } else {
            jElapsedRealtime = -9223372036854775807L;
        }
        this.A05 = jElapsedRealtime;
        A0h();
        A0i();
        this.A0Q = true;
        this.A0U.A00++;
    }

    public void A1J(long j) {
    }

    public void A1K(MediaCodec mediaCodec, MediaFormat mediaFormat) throws C9K {
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0073  */
    public void A1L(Format format) throws C9K {
        DrmInitData drmInitData;
        MediaCodec mediaCodec;
        boolean z;
        Format format2 = this.A07;
        this.A07 = format;
        DrmInitData drmInitData2 = format.A0H;
        if (format2 == null) {
            drmInitData = null;
        } else {
            drmInitData = format2.A0H;
        }
        if (!C0996Hx.A0g(drmInitData2, drmInitData)) {
            Format oldFormat = this.A07;
            if (oldFormat.A0H != null) {
                BK<X6> bk = this.A0Z;
                if (bk != null) {
                    Looper looperMyLooper = Looper.myLooper();
                    Format oldFormat2 = this.A07;
                    BJ bjA2X = bk.A2X(looperMyLooper, oldFormat2.A0H);
                    this.A09 = bjA2X;
                    if (bjA2X == this.A08) {
                        this.A0Z.AEU(bjA2X);
                    }
                } else {
                    throw C9K.A01(new IllegalStateException(A0Z(193, 34, 51)), A0y());
                }
            } else {
                this.A09 = null;
            }
        }
        boolean z2 = false;
        if (this.A09 == this.A08 && (mediaCodec = this.A06) != null) {
            C0874Cy c0874Cy = this.A0A;
            Format oldFormat3 = this.A07;
            switch (A1A(mediaCodec, c0874Cy, format2, oldFormat3)) {
                case 0:
                    break;
                case 1:
                    z2 = true;
                    break;
                case 2:
                default:
                    throw new IllegalStateException();
                case 3:
                    z2 = true;
                    this.A0L = true;
                    this.A01 = 1;
                    int i = this.A00;
                    if (i != 2) {
                        if (i == 1) {
                            Format oldFormat4 = this.A07;
                            if (oldFormat4.A0F == format2.A0F) {
                                Format oldFormat5 = this.A07;
                                z = oldFormat5.A08 == format2.A08;
                            }
                        }
                    }
                    this.A0C = z;
                    break;
            }
        }
        if (!z2) {
            if (this.A0J) {
                this.A02 = 1;
            } else {
                A1G();
                A1I();
            }
        }
    }

    public void A1M(XE xe) {
    }

    public void A1O(String str, long j, long j2) {
    }

    public boolean A1Q(C0874Cy c0874Cy) {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.XS
    public boolean A8q() {
        return this.A0N;
    }

    @Override // com.facebook.ads.redexgen.X.XS
    public boolean A90() {
        return (this.A07 == null || this.A0R || (!A18() && !A0n() && (this.A05 == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.A05))) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0064  */
    /* JADX WARN: Code duplicated, block: B:29:0x008b  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:42:? A[LOOP:0: B:20:0x0071->B:42:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:? A[LOOP:1: B:26:0x0084->B:44:?, LOOP_END, SYNTHETIC] */
    @Override // com.facebook.ads.redexgen.X.XS
    public final void AEb(long j, long j2) throws C9K {
        int result;
        if (this.A0N) {
            A1H();
            String[] strArr = A0e;
            if (strArr[4].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            A0e[0] = "lwFTUI1opuqPhbxVYngJAvB4EigDaO53";
            return;
        }
        if (this.A07 == null) {
            this.A0Y.A07();
            int result2 = A10(this.A0W, this.A0Y, true);
            if (result2 == -5) {
                A1L(this.A0W.A00);
            } else {
                if (result2 == -4) {
                    HI.A04(this.A0Y.A04());
                    this.A0M = true;
                    A0d();
                    return;
                }
                return;
            }
        }
        A1I();
        String[] strArr2 = A0e;
        if (strArr2[4].length() != strArr2[6].length()) {
            A0e[0] = "eroLcdOpjUP85EYGmYhVy7jJ6XqjjMHN";
            if (this.A06 != null) {
                C0993Hu.A02(A0Z(671, 12, 65));
                while (A0p(j, j2)) {
                }
                while (A0m()) {
                }
                C0993Hu.A00();
            } else {
                this.A0U.A07 += A0z(j);
                this.A0Y.A07();
                result = A10(this.A0W, this.A0Y, false);
                if (result == -5) {
                    A1L(this.A0W.A00);
                } else if (result == -4) {
                    HI.A04(this.A0Y.A04());
                    this.A0M = true;
                    A0d();
                }
            }
        } else {
            A0e[1] = "qeXDyPBokWYcVwHFGawdRvPvaKboAA5h";
            if (this.A06 != null) {
                C0993Hu.A02(A0Z(671, 12, 65));
                while (A0p(j, j2)) {
                }
                while (A0m()) {
                }
                C0993Hu.A00();
            } else {
                this.A0U.A07 += A0z(j);
                this.A0Y.A07();
                result = A10(this.A0W, this.A0Y, false);
                if (result == -5) {
                    A1L(this.A0W.A00);
                } else if (result == -4) {
                    HI.A04(this.A0Y.A04());
                    this.A0M = true;
                    A0d();
                }
            }
        }
        this.A0U.A00();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC08059s
    public final int AFt(Format format) throws C9K {
        try {
            return A1B(this.A0a, this.A0Z, format);
        } catch (D7 e) {
            throw C9K.A01(e, A0y());
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0882Dl, com.facebook.ads.redexgen.X.InterfaceC08059s
    public final int AFv() {
        return 8;
    }
}
