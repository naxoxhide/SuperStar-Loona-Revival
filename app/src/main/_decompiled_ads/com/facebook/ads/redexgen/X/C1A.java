package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.PointerIconCompat;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmInitData;
import com.facebook.ads.internal.exoplayer2.thirdparty.video.DummySurface;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import kotlin.io.encoding.Base64;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1A, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1A extends C3E {
    public static boolean A0b;
    public static boolean A0c;
    public static byte[] A0d;
    public static String[] A0e = {"1acRM6Cf6EhxOJODmj0H0eP8VC35ZmTt", "cV9GjlkLQwwiHa", "i1c6IC1hwgIn8DthxqNi0XpoGO8BN4qE", "gFn4mUSFpSKHUauCdH5nTsZh8y8bn5UZ", "9nkQNk0PAkkX03QPU4alH8fTsKo9h28D", "s2uNxYIY6duU338ylAtcR72UhbPyFCsP", "VOm8bC2ft6X0ZlQ", "HWs0n0OHt4vGmZ"};
    public static final int[] A0f;
    public I8 A00;
    public float A01;
    public float A02;
    public float A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public int A0E;
    public int A0F;
    public int A0G;
    public long A0H;
    public long A0I;
    public long A0J;
    public long A0K;
    public long A0L;
    public long A0M;
    public Surface A0N;
    public Surface A0O;
    public I7 A0P;
    public boolean A0Q;
    public boolean A0R;
    public boolean A0S;
    public final int A0T;
    public final long A0U;
    public final Context A0V;
    public final IB A0W;
    public final IK A0X;
    public final boolean A0Y;
    public final long[] A0Z;
    public final long[] A0a;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 14
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static Point A02(C0874Cy c0874Cy, Format format) throws D7 {
        boolean z = format.A08 > format.A0F;
        int i = z ? format.A08 : format.A0F;
        int i2 = z ? format.A0F : format.A08;
        float f = i2 / i;
        for (int i3 : A0f) {
            int i4 = (int) (i3 * f);
            if (i3 <= i || i4 <= i2) {
                return null;
            }
            if (C0996Hx.A02 >= 21) {
                int i5 = z ? i4 : i3;
                if (!z) {
                    i3 = i4;
                }
                Point pointA0E = c0874Cy.A0E(i5, i3);
                if (c0874Cy.A0H(pointA0E.x, pointA0E.y, format.A01)) {
                    return pointA0E;
                }
            } else {
                int iA04 = C0996Hx.A04(i3, 16) * 16;
                int iA05 = C0996Hx.A04(i4, 16) * 16;
                if (iA04 * iA05 <= D9.A00()) {
                    int i6 = z ? iA05 : iA04;
                    if (!z) {
                        iA04 = iA05;
                    }
                    return new Point(i6, iA04);
                }
            }
        }
        return null;
    }

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0d, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 89);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0D() {
        A0d = new byte[]{10, 13, 11, 10, 93, 91, 93, 95, 112, 118, 112, 117, 6, 118, 119, 106, 112, 119, 1, 108, 28, 27, 29, 28, 126, 13, 15, 14, 9, 94, 11, 15, 76, 58, Base64.padSymbol, Base64.padSymbol, Base64.padSymbol, 32, 108, 49, 71, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 0, 28, 5, 3, SignedBytes.MAX_POWER_OF_TWO, 54, 49, 48, 49, 96, 53, 57, SignedBytes.MAX_POWER_OF_TWO, 54, 49, 51, 49, 96, 53, 57, 81, 86, 68, 81, 82, 85, 71, 93, 88, 95, 77, 74, 74, 102, 106, 113, 100, 101, 24, 40, 44, 56, 9, 54, 46, 60, 43, 20, 80, 100, 99, 112, 78, 95, 126, 101, 116, 78, 35, 9, 7, 10, 8, 0, 102, 122, 19, 35, 51, 32, 55, 40, 32, 65, 85, 42, 65, 83, 81, 80, 84, Base64.padSymbol, 45, 62, 41, 54, 62, 32, 62, 43, 41, 77, 51, 65, 55, 36, 76, 66, 67, 66, 43, Base64.padSymbol, 68, 70, 103, 116, 108, 21, 18, 20, 29, 85, 70, 79, 46, 37, 73, 95, 38, 38, 81, 125, 118, 119, 113, 50, 127, 115, 106, 50, 96, 119, 97, 125, 126, 103, 102, 123, 125, 124, 50, 115, 118, 120, 103, 97, 102, 119, 118, 50, 102, 125, 40, 50, 104, 68, 70, 66, 68, 120, 26, 15, 127, 124, 126, 121, 122, 115, 106, 120, 126, 96, 126, 12, 96, 111, 77, 80, 124, 117, 108, 126, 120, 102, 119, 86, 77, 92, 43, 34, 59, 41, 47, 49, 62, 28, 7, 3, 44, 37, 60, 46, 40, 54, 59, 8, 16, 54, 49, 67, 112, 99, 116, 85, 114, 103, 116, 89, 85, 30, 107, 105, 105, 105, 43, 94, 92, 92, 94, 11, 126, 124, 124, 123, 127, 10, 11, 8, 8, SignedBytes.MAX_POWER_OF_TWO, 53, 52, 55, 53, 90, 47, 46, 45, 41, 30, 107, 107, 105, 105, 25, 62, 51, 44, 58, 28, 55, 58, 60, 52, 127, 4, 51, 58, 56, 62, 60, 38, 25, 45, 62, 50, 58, 12, 54, 37, 58, 115, 127, 40, 38, 32, 33, 42, 42, 48, 40, 45, 35, 88, 92, 89, 95, 42, 36, 34, 35, 40, 40, 50, 62, 58, 58, 92, 91, 93, 84, 33, 47, 41, 40, 35, 35, 57, 53, 49, 49, 87, 80, 84, 81, 22, 24, 30, 31, 20, 20, 14, 2, 6, 6, 96, 103, 98, 96, 84, 90, 92, 93, 86, 86, 76, 68, 81, 95, 38, 36, 35, 43, 127, 113, 119, 118, 125, 125, 103, 111, 122, 116, 15, 11, 14, 13, 58, 52, 50, 51, 56, 56, 34, 42, 63, 49, 74, 72, 76, 68, 12, 34, 4, 5, 14, 14, 20, 8, 9, 7, 124, 126, 122, 120, 75, 101, 67, 66, 73, 73, 83, 75, 78, SignedBytes.MAX_POWER_OF_TWO, 59, 63, Base64.padSymbol, 53, 44, 51, 38, 40, 42, 73, 44, 97, 126, 106, 104, 100, 4, 97, 9, 22, 23, 15, 18, 108, 9, 119, 80, 88, 87, 80, 87, 70, 19, 102, 11, 9, 12, 0, 13, 16, 72, 54, 51, 98, 55, 51, 22, 27, 14, 18, 10, 20, 4, 27, 101, 125, 120, 121, 127, 8, 112, 38, 62, 54, 58, 41, 38, 44, 62, 70, 76, 89, 55, 53, 29, 28, 17, 25, 59, 23, 28, 29, 27, 46, 17, 28, 29, 23, 42, 29, 22, 28, 29, 10, 29, 10, 114, 106, 117, 120, 117, 125, 30, 8, 101, 100, 97, 26, 115, 101, 8, 10, 14, 119, 40, 42, 63, 73, 0, 8, 8, 0, 11, 2, 44, 13, 6, 51, 15, 22, 16, 86, 55, 41, 79, 65, 72, 96, 8, 5, 50, 32, 80, 79, 84, 85, 82, 47, 35, 52, Base64.padSymbol, 70, 65, 75, 42, Base64.padSymbol, 52, 76, 75, 74, 55, 32, 41, 81, 86, 86, 69, 89, 80, 124, 126, 99, 27, 127, 16, 40, 33, 46, 52, 47, 45, 118, 88, 97, 112, 97, 60, 37, 63, 87, 59, 79, 45, 20, 5, 20, 72, 80, 76, 77, 34, 73, 58, 3, 97, 103, 98, 109, 8, 14, 10, 12, 52, 81, 87, 82, 120, 29, 26, 24, 25, 119, 19, 81, 77, 49, 54, 88, 69, 95, 85, 25, 16, 121, 118, 65, 87, 75, 72, 81, 80, 77, 75, 74, 87, 4, 81, 74, 79, 74, 75, 83, 74, 10, 4, 103, 75, SignedBytes.MAX_POWER_OF_TWO, 65, 71, 4, 73, 69, 92, 4, 86, 65, 87, 75, 72, 81, 80, 77, 75, 74, 30, 4, 27, 30, 24, 101, 12, 28, 30, 121, 125, 68, 123, 118, 99, 114, 72, 71, 101, 120, 107, 125, 12, 18, 8, 12, 15, 121, 1, 23, 102, 120, 98, 102, 101, 13, 51, 37, 84, 74, 95, 82, 87, 33, 68, 82, 35, Base64.padSymbol, 40, 37, 32, 93, 15, 52, 52, 123, 54, 58, 53, 34, 123, 40, 47, 41, 62, 58, 54, 123, 56, 51, 58, 53, 60, 62, 40, 119, 123, 40, 52, 123, 63, 41, 52, 43, 43, 50, 53, 60, 123, 52, Base64.padSymbol, Base64.padSymbol, 40, 62, 47, 97, 123, 67, 36, SignedBytes.MAX_POWER_OF_TWO, 36, 37, 81, 84, 55, 84, 44, 71, 43, 60, 63, 12, 17, 102, 12, 27, 23, 114, 117, 117, 112, 86, Base64.padSymbol, 62, 83, 92, 94, 67, 14, 108, 100, 25, 93, 32, 91, 66, 86, 71, 74, 76, 14, 80, 70, 80, 80, 74, 76, 77, 14, 74, 71, 9, 29, 28, 7, 69, 14, 26, 11, 29, 12, 17, 14, 83, 28, 17, 10, 10, 17, 19, 11, 26, 7, 24, 69, 4, 13, 14, 28, 32, 49, 44, 51, 110, 49, 42, 36, 43, 55, 95, 78, 83, 76, 17, 72, 83, 76, 103, 114, 53, 58, 47, 106, 30, 31, 24, 96, 118, 107, 116, 82, 109, 96, 97, 107, 70, 113, 98, 98, 97, 118, 107, 97, 98, 10, 3, 31, 24, 9, 30, 45, 57, 42, 38, 46, 102, 57, 42, 63, 46, 126, 107, 112, 127, 127, 112, 119, 43, 38, 42, 36, 43, 55, 54, 42, Base64.padSymbol, 1, 59, 107, 104, 51, 50, 1, 58, 42, 43, 50, 59, 36, 18, 31, 22, 126, 27, 120, 115, 
        112, 125, 125, 41, 38, 34, 36, 78, 40, 41, 33, 39, 84, 79, 84, 78, 11, 13, 13, 16, 1, 8, 59, 55, 80, 85, SignedBytes.MAX_POWER_OF_TWO, 24, 82, 70, 94, 79, 67, 68, 89, 111, 102, 92, 123, 53, 55, 59, 52, 52, 51, 52, Base64.padSymbol, 123, 119, 100, 127, 120, 121, 73, 112, 57, 53, 44, 121, 60, 49, Base64.padSymbol, 51, 60, 32, 19, 31, 6, 83, 23, 16, 14, 11, 10, 83, 13, 23, 4, 27, 45, 33, 56, 109, 55, 41, 36, 52, 40, 54, 51, 109, 105, 100, 111, 76, 72, 76, 68, 96, 111, 99, 111, 122, 102, 18, 21, 31, 23, 16, 29, 9, 15, 35, 26, 79, 13, 14, 13, 56, 41, 38, 45, 36, 36, 23, 44, 50, 35, 44, 39, 46, 46, 29, 38, 46, 90, 75, 68, 79, 70, 70, 117, 78, 89, 112, 97, 110, 101, 108, 108, 95, 100, 116, 83, 81, 74, 76, 81, 74, 87, 90, 70, 81, 88, 81, 85, 71, 81, 123, 65, SignedBytes.MAX_POWER_OF_TWO, 68, 65, SignedBytes.MAX_POWER_OF_TWO, 118, 65, 82, 82, 81, 70, 27, 6, 29, 8, 29, 0, 6, 7, 68, 13, 12, 14, 27, 12, 12, 26, 113, 59, 50, 55, 122, 50, 51, 58, 65, 83, 92, 70, 93, 92, 91, 110, 118, 116, 109, 75, 116, 121, 120, 114, 95, 104, 123, 123, 120, 111, 71, 82, 90, 87, 92, 108, 65, 92, 68, 74, 93, 82, 97, 91, 75, 12, 13, 22, 22, 29, 20, 29, 28, 85, 8, 20, 25, 1, 26, 25, 27, 19, 29, 14, 25, 5, 14, 14, 52, 38, 94, 62, 33, 44, 45, 39, 103, 123, 47, 56, 56, 55, 40, 37, 36, 46, 110, 32, 55, 34, 0, 31, 18, 19, 25, 89, 30, 19, 0, 21, 38, 57, 52, 53, 63, 127, Base64.padSymbol, 32, 100, 38, 125, 53, 35, 68, 91, 86, 87, 93, 29, 74, 31, 68, 92, 86, 28, 93, 92, 0, 28, 68, 66, 10, 50, 45, 32, 33, 43, 107, 60, 105, 50, 42, 32, 106, 43, 42, 118, 106, 50, 52, 125, 97, 119, 98, 101, 121, 120, 110, 113, 96, 107, 124, 125, Base64.padSymbol, 35, 46, 62, 34, 15, 23, 23, 28, 11, 39, 30, 115, 107, 107, 96, 119, 91, 98, 106, 67};
    }

    static {
        A0D();
        A0f = new int[]{1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BK != com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.thirdparty.drm.FrameworkMediaCrypto> */
    public C1A(Context context, D4 d4, long j, BK<X6> bk, boolean z, Handler handler, IL il, int i) {
        super(2, d4, bk, z);
        this.A0U = j;
        this.A0T = i;
        Context applicationContext = context.getApplicationContext();
        this.A0V = applicationContext;
        this.A0W = new IB(applicationContext);
        this.A0X = new IK(handler, il);
        this.A0Y = A0M();
        this.A0Z = new long[10];
        this.A0a = new long[10];
        this.A0M = -9223372036854775807L;
        this.A0K = -9223372036854775807L;
        this.A0J = -9223372036854775807L;
        this.A08 = -1;
        this.A06 = -1;
        this.A01 = -1.0f;
        this.A02 = -1.0f;
        this.A0F = 1;
        A07();
    }

    public static int A00(C0874Cy c0874Cy, Format format) {
        if (format.A09 != -1) {
            int i = 0;
            int i2 = format.A0P.size();
            for (int initializationDataCount = 0; initializationDataCount < i2; initializationDataCount++) {
                int totalInitializationDataSize = format.A0P.get(initializationDataCount).length;
                i += totalInitializationDataSize;
            }
            int i3 = format.A09;
            int initializationDataCount2 = A0e[4].charAt(25);
            if (initializationDataCount2 == 101) {
                throw new RuntimeException();
            }
            A0e[5] = "PFjSJxahL7zuosjl0ltO07DmFDIUFrxC";
            return i3 + i;
        }
        return A01(c0874Cy, format.A0O, format.A0F, format.A08);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:8:0x000d  */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c7, code lost:
    
        if (r5.A05 != false) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A01(com.facebook.ads.redexgen.X.C0874Cy r5, java.lang.String r6, int r7, int r8) {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1A.A01(com.facebook.ads.redexgen.X.Cy, java.lang.String, int, int):int");
    }

    private final MediaFormat A03(Format format, I7 i7, boolean z, int i) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(A05(1094, 4, 120), format.A0O);
        mediaFormat.setInteger(A05(1359, 5, 19), format.A0F);
        mediaFormat.setInteger(A05(971, 6, 26), format.A08);
        DA.A06(mediaFormat, format.A0P);
        DA.A03(mediaFormat, A05(954, 10, 18), format.A01);
        DA.A04(mediaFormat, A05(1180, 16, 48), format.A0B);
        DA.A02(mediaFormat, format.A0J);
        mediaFormat.setInteger(A05(1079, 9, 25), i7.A02);
        mediaFormat.setInteger(A05(1055, 10, 13), i7.A00);
        DA.A04(mediaFormat, A05(1065, 14, 39), i7.A01);
        if (C0996Hx.A02 >= 23) {
            mediaFormat.setInteger(A05(1153, 8, 122), 0);
        }
        if (z) {
            String strA05 = A05(875, 8, 49);
            if (A0e[5].charAt(18) != 't') {
                throw new RuntimeException();
            }
            A0e[5] = "LIFMuRLmQz6XdmDBeptCblAg9hMw0FnF";
            mediaFormat.setInteger(strA05, 0);
        }
        if (i != 0) {
            A0K(mediaFormat, i);
        }
        return mediaFormat;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002a  */
    private final I7 A04(C0874Cy c0874Cy, Format format, Format[] formatArr) throws D7 {
        int maxWidth;
        int iMax = format.A0F;
        int iMax2 = format.A08;
        int iA00 = A00(c0874Cy, format);
        int maxHeight = formatArr.length;
        if (maxHeight == 1) {
            return new I7(iMax, iMax2, iA00);
        }
        int i = 0;
        for (Format format2 : formatArr) {
            if (A0V(c0874Cy.A03, format, format2)) {
                int maxWidth2 = format2.A0F;
                if (maxWidth2 != -1) {
                    int maxWidth3 = format2.A08;
                    if (maxWidth3 == -1) {
                        maxWidth = 1;
                    } else {
                        maxWidth = 0;
                    }
                } else {
                    maxWidth = 1;
                }
                i |= maxWidth;
                int maxWidth4 = format2.A0F;
                iMax = Math.max(iMax, maxWidth4);
                int maxWidth5 = format2.A08;
                iMax2 = Math.max(iMax2, maxWidth5);
                int maxWidth6 = A00(c0874Cy, format2);
                iA00 = Math.max(iA00, maxWidth6);
            }
        }
        if (i != 0) {
            StringBuilder sbAppend = new StringBuilder().append(A05(683, 43, 125)).append(iMax);
            String strA05 = A05(1379, 1, 98);
            String string = sbAppend.append(strA05).append(iMax2).toString();
            String strA06 = A05(522, 23, 33);
            Log.w(strA06, string);
            Point pointA02 = A02(c0874Cy, format);
            if (pointA02 != null) {
                int maxWidth7 = pointA02.x;
                iMax = Math.max(iMax, maxWidth7);
                int maxWidth8 = pointA02.y;
                iMax2 = Math.max(iMax2, maxWidth8);
                int maxWidth9 = A01(c0874Cy, format.A0O, iMax, iMax2);
                iA00 = Math.max(iA00, maxWidth9);
                Log.w(strA06, A05(164, 34, 75) + iMax + strA05 + iMax2);
            }
        }
        return new I7(iMax, iMax2, iA00);
    }

    private void A06() {
        MediaCodec mediaCodecA1C;
        this.A0R = false;
        if (C0996Hx.A02 >= 23 && this.A0S && (mediaCodecA1C = A1C()) != null) {
            this.A00 = new I8(this, mediaCodecA1C);
        }
    }

    private void A07() {
        this.A0E = -1;
        this.A0C = -1;
        this.A03 = -1.0f;
        this.A0D = -1;
    }

    private void A08() {
        if (this.A09 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long now = this.A0H;
            long elapsedMs = jElapsedRealtime - now;
            this.A0X.A02(this.A09, elapsedMs);
            this.A09 = 0;
            this.A0H = jElapsedRealtime;
        }
    }

    private void A09() {
        int i = this.A08;
        if (i == -1 && this.A06 == -1) {
            return;
        }
        if (this.A0E != i || this.A0C != this.A06 || this.A0D != this.A07 || this.A03 != this.A01) {
            this.A0X.A01(i, this.A06, this.A07, this.A01);
            this.A0E = this.A08;
            this.A0C = this.A06;
            this.A0D = this.A07;
            this.A03 = this.A01;
        }
    }

    private void A0A() {
        if (this.A0R) {
            this.A0X.A03(this.A0O);
        }
    }

    private void A0B() {
        int i = this.A0E;
        if (i == -1) {
            int i2 = this.A0C;
            String[] strArr = A0e;
            if (strArr[0].charAt(20) != strArr[2].charAt(20)) {
                throw new RuntimeException();
            }
            A0e[6] = "GSr0Qxmd2Qhu1M0N5tyB3p9H4Vler7W";
            if (i2 == -1) {
                return;
            }
        }
        this.A0X.A01(i, this.A0C, this.A0D, this.A03);
    }

    private void A0C() {
        long jElapsedRealtime;
        if (this.A0U > 0) {
            jElapsedRealtime = SystemClock.elapsedRealtime() + this.A0U;
        } else {
            jElapsedRealtime = -9223372036854775807L;
        }
        this.A0J = jElapsedRealtime;
    }

    private final void A0E(int i) {
        super.A0U.A02 += i;
        this.A09 += i;
        this.A05 += i;
        super.A0U.A05 = Math.max(this.A05, super.A0U.A05);
        if (this.A09 >= this.A0T) {
            A08();
        }
    }

    private final void A0F(MediaCodec mediaCodec, int i, long j) {
        C0993Hu.A02(A05(930, 15, 93));
        mediaCodec.releaseOutputBuffer(i, false);
        C0993Hu.A00();
        A0E(1);
    }

    private final void A0G(MediaCodec mediaCodec, int i, long j) {
        A09();
        C0993Hu.A02(A05(1161, 19, 109));
        mediaCodec.releaseOutputBuffer(i, true);
        C0993Hu.A00();
        this.A0L = SystemClock.elapsedRealtime() * 1000;
        super.A0U.A06++;
        this.A05 = 0;
        A1R();
    }

    private final void A0H(MediaCodec mediaCodec, int i, long j) {
        C0993Hu.A02(A05(1211, 15, 68));
        mediaCodec.releaseOutputBuffer(i, false);
        C0993Hu.A00();
        super.A0U.A08++;
    }

    private final void A0I(MediaCodec mediaCodec, int i, long j, long j2) {
        A09();
        C0993Hu.A02(A05(1161, 19, 109));
        mediaCodec.releaseOutputBuffer(i, j2);
        C0993Hu.A00();
        this.A0L = SystemClock.elapsedRealtime() * 1000;
        super.A0U.A06++;
        this.A05 = 0;
        A1R();
    }

    public static void A0J(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    public static void A0K(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled(A05(1241, 17, 33), true);
        mediaFormat.setInteger(A05(859, 16, 122), i);
    }

    private void A0L(Surface surface) throws C9K {
        if (surface == null) {
            if (this.A0N != null) {
                surface = this.A0N;
            } else {
                C0874Cy c0874CyA1D = A1D();
                if (c0874CyA1D != null && A0T(c0874CyA1D)) {
                    this.A0N = DummySurface.A01(this.A0V, c0874CyA1D.A05);
                    surface = this.A0N;
                }
            }
        }
        if (this.A0O != surface) {
            this.A0O = surface;
            if (A0e[3].charAt(22) != 'Z') {
                throw new RuntimeException();
            }
            A0e[5] = "451d0u4cD9rJ2w2guGtx9AsvugCig8Nc";
            int iA7t = A7t();
            if (iA7t == 1 || iA7t == 2) {
                MediaCodec mediaCodecA1C = A1C();
                if (C0996Hx.A02 >= 23 && mediaCodecA1C != null && surface != null && !this.A0Q) {
                    A0J(mediaCodecA1C, surface);
                } else {
                    A1G();
                    A1I();
                }
            }
            if (surface != null && surface != this.A0N) {
                A0B();
                A06();
                if (iA7t == 2) {
                    A0C();
                    return;
                }
                return;
            }
            A07();
            if (A0e[5].charAt(18) != 't') {
                A06();
                return;
            } else {
                A0e[3] = "pSIGciD2qJewSpKsBqH446Zc9mkVUpAR";
                A06();
                return;
            }
        }
        if (surface != null) {
            Surface surface2 = this.A0N;
            String[] strArr = A0e;
            if (strArr[1].length() == strArr[7].length()) {
                String[] strArr2 = A0e;
                strArr2[1] = "4gXhdQ7K18codO";
                strArr2[7] = "dCZzuzcRJjaMd3";
                if (surface == surface2) {
                    return;
                }
            } else if (surface == surface2) {
                return;
            }
            A0B();
            A0A();
        }
    }

    public static boolean A0M() {
        return C0996Hx.A02 <= 22 && A05(948, 6, 53).equals(C0996Hx.A03) && A05(545, 6, 101).equals(C0996Hx.A05);
    }

    public static boolean A0N(long j) {
        return j < -30000;
    }

    public static boolean A0O(long j) {
        return j < -500000;
    }

    private final boolean A0P(long j, long j2) {
        return A0O(j);
    }

    private final boolean A0Q(long j, long j2) {
        return A0N(j);
    }

    private final boolean A0R(long j, long j2) {
        return A0N(j) && j2 > 100000;
    }

    private final boolean A0S(MediaCodec mediaCodec, int i, long j, long j2) throws C9K {
        int iA0z = A0z(j2);
        if (iA0z == 0) {
            return false;
        }
        C0832Au c0832Au = super.A0U;
        int droppedSourceBufferCount = c0832Au.A03;
        c0832Au.A03 = droppedSourceBufferCount + 1;
        int droppedSourceBufferCount2 = this.A04;
        A0E(droppedSourceBufferCount2 + iA0z);
        A1F();
        return true;
    }

    private boolean A0T(C0874Cy c0874Cy) {
        return C0996Hx.A02 >= 23 && !this.A0S && !A0U(c0874Cy.A02) && (!c0874Cy.A05 || DummySurface.A05(this.A0V));
    }

    /* JADX WARN: Code duplicated, block: B:368:0x0905  */
    /* JADX WARN: Code duplicated, block: B:382:0x093a  */
    private final boolean A0U(String str) {
        byte b2 = 0;
        byte b3 = 27;
        if (C0996Hx.A02 >= 27 || str.startsWith(A05(563, 10, 62))) {
            return false;
        }
        synchronized (C1A.class) {
            if (!A0c) {
                String str2 = C0996Hx.A03;
                switch (str2.hashCode()) {
                    case -2144781245:
                        if (!str2.equals(A05(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 14, 52))) {
                            b3 = -1;
                        } else {
                            b3 = 39;
                        }
                        break;
                    case -2144781185:
                        if (!str2.equals(A05(355, 14, 63))) {
                            b3 = -1;
                        } else {
                            b3 = 40;
                        }
                        break;
                    case -2144781160:
                        if (!str2.equals(A05(369, 14, 8))) {
                            b3 = -1;
                        } else {
                            b3 = 41;
                        }
                        break;
                    case -2097309513:
                        if (!str2.equals(A05(489, 6, 90))) {
                            b3 = -1;
                        } else {
                            b3 = 57;
                        }
                        break;
                    case -2022874474:
                        if (!str2.equals(A05(138, 10, 45))) {
                            b3 = -1;
                        } else {
                            b3 = 16;
                        }
                        break;
                    case -1978993182:
                        if (!str2.equals(A05(551, 6, 9))) {
                            b3 = -1;
                        } else {
                            b3 = 69;
                        }
                        break;
                    case -1978990237:
                        if (!str2.equals(A05(557, 6, 100))) {
                            b3 = -1;
                        } else {
                            b3 = 70;
                        }
                        break;
                    case -1936688988:
                        if (!str2.equals(A05(597, 6, 42))) {
                            b3 = -1;
                        } else {
                            b3 = 80;
                        }
                        break;
                    case -1936688066:
                        if (!str2.equals(A05(603, 6, 35))) {
                            b3 = -1;
                        } else {
                            b3 = 81;
                        }
                        break;
                    case -1936688065:
                        if (!str2.equals(A05(609, 6, 62))) {
                            b3 = -1;
                        } else {
                            b3 = 82;
                        }
                        break;
                    case -1931988508:
                        if (!str2.equals(A05(82, 10, 0))) {
                            b3 = -1;
                        } else {
                            b3 = 10;
                        }
                        break;
                    case -1696512866:
                        if (!str2.equals(A05(839, 6, 26))) {
                            b3 = -1;
                        } else {
                            b3 = 115;
                        }
                        break;
                    case -1680025915:
                        if (!str2.equals(A05(198, 7, 114))) {
                            b3 = -1;
                        } else {
                            b3 = 15;
                        }
                        break;
                    case -1615810839:
                        if (!str2.equals(A05(623, 8, 25))) {
                            b3 = -1;
                        } else {
                            b3 = 83;
                        }
                        break;
                    case -1554255044:
                        if (!str2.equals(A05(1258, 9, 50))) {
                            b3 = -1;
                        } else {
                            b3 = 108;
                        }
                        break;
                    case -1481772737:
                        if (!str2.equals(A05(1126, 9, 27))) {
                            b3 = -1;
                        } else {
                            b3 = 76;
                        }
                        break;
                    case -1481772730:
                        if (!str2.equals(A05(1135, 9, 115))) {
                            b3 = -1;
                        } else {
                            b3 = 77;
                        }
                        break;
                    case -1481772729:
                        if (!str2.equals(A05(1144, 9, 89))) {
                            b3 = -1;
                        } else {
                            b3 = 78;
                        }
                        break;
                    case -1320080169:
                        if (!str2.equals(A05(439, 14, 85))) {
                            b3 = -1;
                        } else {
                            b3 = 37;
                        }
                        break;
                    case -1217592143:
                        if (!str2.equals(A05(125, 11, 38))) {
                            b3 = -1;
                        } else {
                            b3 = 13;
                        }
                        break;
                    case -1180384755:
                        if (!str2.equals(A05(PointerIconCompat.TYPE_NO_DROP, 6, 100))) {
                            b3 = -1;
                        } else {
                            b3 = 53;
                        }
                        break;
                    case -1139198265:
                        if (!str2.equals(A05(735, 9, 78))) {
                            b3 = -1;
                        } else {
                            b3 = 96;
                        }
                        break;
                    case -1052835013:
                        if (!str2.equals(A05(1098, 6, 87))) {
                            b3 = -1;
                        } else {
                            b3 = 67;
                        }
                        break;
                    case -993250464:
                        if (!str2.equals(A05(12, 7, 30))) {
                            b3 = -1;
                        } else {
                            b3 = 3;
                        }
                        break;
                    case -965403638:
                        if (!str2.equals(A05(1196, 8, 91))) {
                            b3 = -1;
                        } else {
                            b3 = 98;
                        }
                        break;
                    case -958336948:
                        if (!str2.equals(A05(242, 11, 48))) {
                            b3 = -1;
                        } else {
                            b3 = 26;
                        }
                        break;
                    case -879245230:
                        if (!str2.equals(A05(1235, 6, 103))) {
                            b3 = -1;
                        } else {
                            b3 = 104;
                        }
                        break;
                    case -842500323:
                        if (!str2.equals(A05(1104, 10, 37))) {
                            b3 = -1;
                        } else {
                            b3 = 68;
                        }
                        break;
                    case -821392978:
                        if (!str2.equals(A05(32, 7, 84))) {
                            b3 = -1;
                        } else {
                            b3 = 6;
                        }
                        break;
                    case -797483286:
                        if (!str2.equals(A05(726, 9, 17))) {
                            b3 = -1;
                        } else {
                            b3 = 97;
                        }
                        break;
                    case -794946968:
                        if (!str2.equals(A05(1347, 6, 79))) {
                            b3 = -1;
                        } else {
                            b3 = 109;
                        }
                        break;
                    case -788334647:
                        if (!str2.equals(A05(1353, 6, 64))) {
                            b3 = -1;
                        } else {
                            b3 = 110;
                        }
                        break;
                    case -782144577:
                        if (!str2.equals(A05(573, 9, 58))) {
                            b3 = -1;
                        } else {
                            b3 = 71;
                        }
                        break;
                    case -575125681:
                        if (!str2.equals(A05(425, 14, 18))) {
                            b3 = -1;
                        } else {
                            b3 = 36;
                        }
                        break;
                    case -521118391:
                        if (!str2.equals(A05(327, 14, 54))) {
                            b3 = -1;
                        } else {
                            b3 = 38;
                        }
                        break;
                    case -430914369:
                        if (!str2.equals(A05(631, 10, 81))) {
                            b3 = -1;
                        } else {
                            b3 = 84;
                        }
                        break;
                    case -290434366:
                        if (!str2.equals(A05(1226, 9, 106))) {
                            b3 = -1;
                        } else {
                            b3 = 99;
                        }
                        break;
                    case -282781963:
                        if (!str2.equals(A05(103, 8, 18))) {
                            b3 = -1;
                        } else {
                            b3 = 12;
                        }
                        break;
                    case -277133239:
                        if (!str2.equals(A05(845, 7, 85))) {
                            b3 = -1;
                        } else {
                            b3 = 116;
                        }
                        break;
                    case -173639913:
                        if (!str2.equals(A05(210, 12, 102))) {
                            b3 = -1;
                        } else {
                            b3 = 23;
                        }
                        break;
                    case -56598463:
                        if (!str2.equals(A05(1371, 8, 93))) {
                            b3 = -1;
                        } else {
                            b3 = 112;
                        }
                        break;
                    case 2126:
                        if (!str2.equals(A05(136, 2, 41))) {
                            b3 = -1;
                        } else {
                            b3 = 14;
                        }
                        break;
                    case 2564:
                        if (!str2.equals(A05(670, 2, WorkQueueKt.MASK))) {
                            b3 = -1;
                        } else {
                            b3 = 92;
                        }
                        break;
                    case 2715:
                        if (!str2.equals(A05(821, 2, 76))) {
                            b3 = -1;
                        } else {
                            b3 = 105;
                        }
                        break;
                    case 2719:
                        if (!str2.equals(A05(828, 2, 56))) {
                            b3 = -1;
                        } else {
                            b3 = 107;
                        }
                        break;
                    case 3483:
                        if (!str2.equals(A05(1088, 2, 2))) {
                            b3 = -1;
                        } else {
                            b3 = SignedBytes.MAX_POWER_OF_TWO;
                        }
                        break;
                    case 73405:
                        if (!str2.equals(A05(486, 3, 19))) {
                            b3 = -1;
                        } else {
                            b3 = 56;
                        }
                        break;
                    case 75739:
                        if (!str2.equals(A05(508, 3, 28))) {
                            b3 = -1;
                        } else {
                            b3 = 60;
                        }
                        break;
                    case 76779:
                        if (!str2.equals(A05(519, 3, 88))) {
                            b3 = -1;
                        } else {
                            b3 = 66;
                        }
                        break;
                    case 78669:
                        if (!str2.equals(A05(586, 3, 105))) {
                            b3 = -1;
                        } else {
                            b3 = 74;
                        }
                        break;
                    case 79305:
                        if (!str2.equals(A05(615, 3, 76))) {
                            b3 = -1;
                        } else {
                            b3 = 86;
                        }
                        break;
                    case 80618:
                        if (!str2.equals(A05(680, 3, 17))) {
                            b3 = -1;
                        } else {
                            b3 = 94;
                        }
                        break;
                    case 88274:
                        if (!str2.equals(A05(852, 3, 13))) {
                            b3 = -1;
                        } else {
                            b3 = 117;
                        }
                        break;
                    case 98846:
                        if (!str2.equals(A05(921, 3, 93))) {
                            b3 = -1;
                        } else {
                            b3 = 19;
                        }
                        break;
                    case 98848:
                        if (!str2.equals(A05(924, 3, 0))) {
                            b3 = -1;
                        } else {
                            b3 = 20;
                        }
                        break;
                    case 99329:
                        if (!str2.equals(A05(927, 3, 35))) {
                            b3 = -1;
                        } else {
                            b3 = 21;
                        }
                        break;
                    case 101481:
                        if (!str2.equals(A05(945, 3, 84))) {
                            b3 = -1;
                        } else {
                            b3 = 35;
                        }
                        break;
                    case 1513190:
                        if (!str2.equals(A05(0, 4, 98))) {
                            b3 = -1;
                        } else {
                            b3 = 0;
                        }
                        break;
                    case 1514184:
                        if (!str2.equals(A05(4, 4, 53))) {
                            b3 = -1;
                        } else {
                            b3 = 1;
                        }
                        break;
                    case 1514185:
                        if (!str2.equals(A05(8, 4, 24))) {
                            b3 = -1;
                        } else {
                            b3 = 2;
                        }
                        break;
                    case 2436959:
                        if (!str2.equals(A05(582, 4, 32))) {
                            b3 = -1;
                        } else {
                            b3 = 73;
                        }
                        break;
                    case 2463773:
                        if (!str2.equals(A05(652, 4, 11))) {
                            b3 = -1;
                        } else {
                            b3 = 88;
                        }
                        break;
                    case 2464648:
                        if (!str2.equals(A05(661, 4, 60))) {
                            b3 = -1;
                        } else {
                            b3 = 90;
                        }
                        break;
                    case 2689555:
                        if (!str2.equals(A05(835, 4, 13))) {
                            b3 = -1;
                        } else {
                            b3 = 114;
                        }
                        break;
                    case 3351335:
                        if (!str2.equals(A05(1090, 4, 89))) {
                            b3 = -1;
                        } else {
                            b3 = 65;
                        }
                        break;
                    case 3386211:
                        if (!str2.equals(A05(1114, 4, 102))) {
                            b3 = -1;
                        } else {
                            b3 = 72;
                        }
                        break;
                    case 41325051:
                        if (!str2.equals(A05(FrameMetricsAggregator.EVERY_DURATION, 8, 42))) {
                            b3 = -1;
                        } else {
                            b3 = 63;
                        }
                        break;
                    case 55178625:
                        if (!str2.equals(A05(92, 11, 72))) {
                            b3 = -1;
                        } else {
                            b3 = 11;
                        }
                        break;
                    case 61542055:
                        if (!str2.equals(A05(19, 5, 116))) {
                            b3 = -1;
                        } else {
                            b3 = 4;
                        }
                        break;
                    case 65355429:
                        if (!str2.equals(A05(205, 5, 19))) {
                            b3 = -1;
                        } else {
                            b3 = 22;
                        }
                        break;
                    case 66214468:
                        if (!str2.equals(A05(263, 5, 1))) {
                            b3 = -1;
                        } else {
                            b3 = 28;
                        }
                        break;
                    case 66214470:
                        if (!str2.equals(A05(268, 5, 52))) {
                            b3 = -1;
                        } else {
                            b3 = 29;
                        }
                        break;
                    case 66214473:
                        if (!str2.equals(A05(273, 5, 20))) {
                            b3 = -1;
                        } else {
                            b3 = 30;
                        }
                        break;
                    case 66215429:
                        if (!str2.equals(A05(278, 5, 96))) {
                            b3 = -1;
                        } else {
                            b3 = 31;
                        }
                        break;
                    case 66215431:
                        if (!str2.equals(A05(283, 5, 95))) {
                            b3 = -1;
                        } else {
                            b3 = 32;
                        }
                        break;
                    case 66215433:
                        if (!str2.equals(A05(288, 5, 69))) {
                            b3 = -1;
                        } else {
                            b3 = 33;
                        }
                        break;
                    case 66216390:
                        if (!str2.equals(A05(293, 5, 1))) {
                            b3 = -1;
                        } else {
                            b3 = 34;
                        }
                        break;
                    case 76402249:
                        if (!str2.equals(A05(618, 5, 117))) {
                            b3 = -1;
                        } else {
                            b3 = 87;
                        }
                        break;
                    case 76404105:
                        if (!str2.equals(A05(656, 5, 101))) {
                            b3 = -1;
                        } else {
                            b3 = 89;
                        }
                        break;
                    case 76404911:
                        if (!str2.equals(A05(665, 5, 112))) {
                            b3 = -1;
                        } else {
                            b3 = 91;
                        }
                        break;
                    case 80963634:
                        if (!str2.equals(A05(823, 5, 79))) {
                            b3 = -1;
                        } else {
                            b3 = 106;
                        }
                        break;
                    case 82882791:
                        if (!str2.equals(A05(830, 5, 45))) {
                            b3 = -1;
                        } else {
                            b3 = 113;
                        }
                        break;
                    case 102844228:
                        if (!str2.equals(A05(1035, 5, 90))) {
                            b3 = -1;
                        } else {
                            b3 = 58;
                        }
                        break;
                    case 165221241:
                        if (!str2.equals(A05(24, 8, 102))) {
                            b3 = -1;
                        } else {
                            b3 = 5;
                        }
                        break;
                    case 182191441:
                        if (!str2.equals(A05(155, 9, 79))) {
                            b3 = -1;
                        } else {
                            b3 = 18;
                        }
                        break;
                    case 245388979:
                        if (!str2.equals(A05(1047, 8, 79))) {
                            b3 = -1;
                        } else {
                            b3 = 62;
                        }
                        break;
                    case 287431619:
                        if (!str2.equals(A05(964, 7, 64))) {
                            b3 = -1;
                        } else {
                            b3 = 45;
                        }
                        break;
                    case 307593612:
                        if (!str2.equals(A05(48, 8, 88))) {
                            b3 = -1;
                        } else {
                            b3 = 8;
                        }
                        break;
                    case 308517133:
                        if (!str2.equals(A05(56, 8, 88))) {
                            b3 = -1;
                        } else {
                            b3 = 9;
                        }
                        break;
                    case 316215098:
                        if (!str2.equals(A05(744, 8, 102))) {
                            b3 = -1;
                        } else {
                            b3 = 100;
                        }
                        break;
                    case 316215116:
                        if (!str2.equals(A05(752, 8, 12))) {
                            b3 = -1;
                        } else {
                            b3 = 101;
                        }
                        break;
                    case 316246811:
                        if (!str2.equals(A05(760, 8, 62))) {
                            b3 = -1;
                        } else {
                            b3 = 102;
                        }
                        break;
                    case 316246818:
                        if (!str2.equals(A05(768, 8, 73))) {
                            b3 = -1;
                        } else {
                            b3 = 103;
                        }
                        break;
                    case 407160593:
                        if (!str2.equals(A05(641, 11, 36))) {
                            b3 = -1;
                        } else {
                            b3 = 85;
                        }
                        break;
                    case 507412548:
                        if (!str2.equals(A05(672, 8, 89))) {
                            b3 = -1;
                        } else {
                            b3 = 93;
                        }
                        break;
                    case 793982701:
                        if (!str2.equals(A05(383, 14, 74))) {
                            b3 = -1;
                        } else {
                            b3 = 42;
                        }
                        break;
                    case 794038622:
                        if (!str2.equals(A05(397, 14, 97))) {
                            b3 = -1;
                        } else {
                            b3 = 43;
                        }
                        break;
                    case 794040393:
                        if (!str2.equals(A05(TTAdConstant.IMAGE_CODE, 14, 36))) {
                            b3 = -1;
                        } else {
                            b3 = 44;
                        }
                        break;
                    case 835649806:
                        if (!str2.equals(A05(1040, 7, 3))) {
                            b3 = -1;
                        } else {
                            b3 = Base64.padSymbol;
                        }
                        break;
                    case 917340916:
                        if (!str2.equals(A05(39, 9, 41))) {
                            b3 = -1;
                        } else {
                            b3 = 7;
                        }
                        break;
                    case 958008161:
                        if (!str2.equals(A05(1026, 9, 115))) {
                            b3 = -1;
                        } else {
                            b3 = 55;
                        }
                        break;
                    case 1060579533:
                        if (!str2.equals(A05(1118, 8, 17))) {
                            b3 = -1;
                        } else {
                            b3 = 75;
                        }
                        break;
                    case 1150207623:
                        if (!str2.equals(A05(501, 7, 17))) {
                            b3 = -1;
                        } else {
                            b3 = 59;
                        }
                        break;
                    case 1176899427:
                        if (!str2.equals(A05(PointerIconCompat.TYPE_ZOOM_IN, 8, 61))) {
                            b3 = -1;
                        } else {
                            b3 = 54;
                        }
                        break;
                    case 1280332038:
                        if (!str2.equals(A05(991, 7, 10))) {
                            b3 = -1;
                        } else {
                            b3 = 47;
                        }
                        break;
                    case 1306947716:
                        if (!str2.equals(A05(253, 10, 95))) {
                            b3 = -1;
                        }
                        break;
                    case 1349174697:
                        if (!str2.equals(A05(977, 14, 7))) {
                            b3 = -1;
                        } else {
                            b3 = 46;
                        }
                        break;
                    case 1522194893:
                        if (!str2.equals(A05(1364, 7, 33))) {
                            b3 = -1;
                        } else {
                            b3 = 111;
                        }
                        break;
                    case 1691543273:
                        if (!str2.equals(A05(148, 7, 125))) {
                            b3 = -1;
                        } else {
                            b3 = 17;
                        }
                        break;
                    case 1709443163:
                        if (!str2.equals(A05(998, 14, 72))) {
                            b3 = -1;
                        } else {
                            b3 = 51;
                        }
                        break;
                    case 1865889110:
                        if (!str2.equals(A05(1204, 7, 107))) {
                            b3 = -1;
                        } else {
                            b3 = 95;
                        }
                        break;
                    case 1906253259:
                        if (!str2.equals(A05(589, 8, 59))) {
                            b3 = -1;
                        } else {
                            b3 = 79;
                        }
                        break;
                    case 1977196784:
                        if (!str2.equals(A05(474, 12, 103))) {
                            b3 = -1;
                        } else {
                            b3 = 52;
                        }
                        break;
                    case 2029784656:
                        if (!str2.equals(A05(453, 7, 61))) {
                            b3 = -1;
                        } else {
                            b3 = 48;
                        }
                        break;
                    case 2030379515:
                        if (!str2.equals(A05(460, 7, 112))) {
                            b3 = -1;
                        } else {
                            b3 = 49;
                        }
                        break;
                    case 2047190025:
                        if (!str2.equals(A05(222, 10, 96))) {
                            b3 = -1;
                        } else {
                            b3 = 24;
                        }
                        break;
                    case 2047252157:
                        if (!str2.equals(A05(232, 10, 55))) {
                            b3 = -1;
                        } else {
                            b3 = 25;
                        }
                        break;
                    case 2048319463:
                        if (!str2.equals(A05(467, 7, 24))) {
                            b3 = -1;
                        } else {
                            b3 = 50;
                        }
                        break;
                    default:
                        b3 = -1;
                        break;
                }
                switch (b3) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                    case 79:
                    case 80:
                    case 81:
                    case 82:
                    case 83:
                    case 84:
                    case 85:
                    case 86:
                    case 87:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
                    case 97:
                    case 98:
                    case 99:
                    case 100:
                    case 101:
                    case 102:
                    case 103:
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                    case 108:
                    case 109:
                    case 110:
                    case 111:
                    case 112:
                    case 113:
                    case 114:
                    case 115:
                    case 116:
                    case 117:
                        A0b = true;
                        break;
                }
                String str3 = C0996Hx.A06;
                switch (str3.hashCode()) {
                    case 2006354:
                        if (!str3.equals(A05(64, 4, 73))) {
                            b2 = -1;
                        }
                        break;
                    case 2006367:
                        if (!str3.equals(A05(68, 4, 74))) {
                            b2 = -1;
                        } else {
                            b2 = 1;
                        }
                        break;
                    default:
                        b2 = -1;
                        break;
                }
                switch (b2) {
                    case 0:
                    case 1:
                        A0b = true;
                        break;
                }
                A0c = true;
            }
        }
        return A0b;
    }

    public static boolean A0V(boolean z, Format format, Format format2) {
        return format.A0O.equals(format2.A0O) && format.A0B == format2.A0B && (z || (format.A0F == format2.A0F && format.A08 == format2.A08)) && C0996Hx.A0g(format.A0J, format2.A0J);
    }

    @Override // com.facebook.ads.redexgen.X.C3E, com.facebook.ads.redexgen.X.AbstractC0882Dl
    public final void A12() {
        this.A08 = -1;
        this.A06 = -1;
        this.A01 = -1.0f;
        this.A02 = -1.0f;
        this.A0M = -9223372036854775807L;
        this.A0K = -9223372036854775807L;
        this.A0A = 0;
        A07();
        A06();
        this.A0W.A08();
        this.A00 = null;
        this.A0S = false;
        try {
            super.A12();
        } finally {
            super.A0U.A00();
            this.A0X.A05(super.A0U);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3E, com.facebook.ads.redexgen.X.AbstractC0882Dl
    public final void A13() {
        super.A13();
        this.A09 = 0;
        this.A0H = SystemClock.elapsedRealtime();
        this.A0L = SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.facebook.ads.redexgen.X.C3E, com.facebook.ads.redexgen.X.AbstractC0882Dl
    public final void A14() {
        this.A0J = -9223372036854775807L;
        A08();
        super.A14();
    }

    @Override // com.facebook.ads.redexgen.X.C3E, com.facebook.ads.redexgen.X.AbstractC0882Dl
    public final void A15(long j, boolean z) throws C9K {
        super.A15(j, z);
        A06();
        this.A0I = -9223372036854775807L;
        this.A05 = 0;
        this.A0K = -9223372036854775807L;
        int i = this.A0A;
        if (i != 0) {
            this.A0M = this.A0Z[i - 1];
            this.A0A = 0;
        }
        if (z) {
            A0C();
        } else {
            this.A0J = -9223372036854775807L;
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3E, com.facebook.ads.redexgen.X.AbstractC0882Dl
    public final void A16(boolean z) throws C9K {
        super.A16(z);
        int i = A11().A00;
        this.A0G = i;
        this.A0S = i != 0;
        this.A0X.A06(super.A0U);
        this.A0W.A09();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0882Dl
    public final void A17(Format[] formatArr, long j) throws C9K {
        if (this.A0M == -9223372036854775807L) {
            this.A0M = j;
        } else {
            int i = this.A0A;
            if (i == this.A0Z.length) {
                Log.w(A05(522, 23, 33), A05(776, 45, 2) + this.A0Z[this.A0A - 1]);
            } else {
                int i2 = i + 1;
                String[] strArr = A0e;
                if (strArr[1].length() != strArr[7].length()) {
                    throw new RuntimeException();
                }
                A0e[4] = "ShVF99lXvOUYr05H2Tvsc9mrs3vvqIZt";
                this.A0A = i2;
            }
            long[] jArr = this.A0Z;
            int i3 = this.A0A;
            jArr[i3 - 1] = j;
            this.A0a[i3 - 1] = this.A0K;
        }
        super.A17(formatArr, j);
    }

    @Override // com.facebook.ads.redexgen.X.C3E
    public final int A1A(MediaCodec mediaCodec, C0874Cy c0874Cy, Format format, Format format2) {
        if (A0V(c0874Cy.A03, format, format2) && format2.A0F <= this.A0P.A02 && format2.A08 <= this.A0P.A00 && A00(c0874Cy, format2) <= this.A0P.A01) {
            if (format.A0K(format2)) {
                return 1;
            }
            return 3;
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x010e  */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BK != com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.thirdparty.drm.FrameworkMediaCrypto> */
    @Override // com.facebook.ads.redexgen.X.C3E
    public final int A1B(D4 d4, BK<X6> bk, Format format) throws D7 {
        String str = format.A0O;
        if (!C0973Ha.A0B(str)) {
            return 0;
        }
        boolean z = false;
        DrmInitData drmInitData = format.A0H;
        if (drmInitData != null) {
            for (int i = 0; i < drmInitData.A01; i++) {
                z |= drmInitData.A01(i).A03;
            }
        }
        C0874Cy decoderInfo = d4.A6f(str, z);
        boolean z2 = true;
        if (decoderInfo == null) {
            if (z) {
                C0874Cy c0874CyA6f = d4.A6f(str, false);
                if (A0e[4].charAt(25) == 'e') {
                    throw new RuntimeException();
                }
                A0e[4] = "FpKuVec84vIeJrb9OhgIMf2bfNz9gMiE";
                if (c0874CyA6f != null) {
                    return 2;
                }
            }
            return 1;
        }
        if (!AbstractC0882Dl.A0x(bk, drmInitData)) {
            return 2;
        }
        String mimeType = format.A0K;
        boolean zA0I = decoderInfo.A0I(mimeType);
        if (zA0I && format.A0F > 0 && format.A08 > 0) {
            if (C0996Hx.A02 >= 21) {
                zA0I = decoderInfo.A0H(format.A0F, format.A08, format.A01);
            } else {
                int i2 = format.A0F * format.A08;
                if (A0e[3].charAt(22) != 'Z') {
                    A0e[5] = "UMjIK9RMnUz7WxxIT7tVkIDt0MZGN20Y";
                    if (i2 > D9.A00()) {
                        z2 = false;
                    }
                } else {
                    A0e[6] = "1pvxbUpXZPSG1GOfk2zj";
                    if (i2 > D9.A00()) {
                        z2 = false;
                    }
                }
                zA0I = z2;
                if (!zA0I) {
                    StringBuilder sb = new StringBuilder();
                    String mimeType2 = A05(298, 29, 6);
                    StringBuilder sbAppend = sb.append(mimeType2).append(format.A0F);
                    String mimeType3 = A05(1379, 1, 98);
                    StringBuilder sbAppend2 = sbAppend.append(mimeType3).append(format.A08);
                    String mimeType4 = A05(856, 3, 89);
                    StringBuilder sbAppend3 = sbAppend2.append(mimeType4);
                    String mimeType5 = C0996Hx.A04;
                    StringBuilder sbAppend4 = sbAppend3.append(mimeType5);
                    String mimeType6 = A05(855, 1, 29);
                    sbAppend4.append(mimeType6).toString();
                }
            }
        }
        return (decoderInfo.A03 ? 16 : 8) | (decoderInfo.A06 ? 32 : 0) | (zA0I ? 4 : 3);
    }

    @Override // com.facebook.ads.redexgen.X.C3E
    public final void A1F() throws C9K {
        super.A1F();
        this.A04 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.C3E
    public final void A1G() {
        try {
            super.A1G();
            this.A04 = 0;
            Surface surface = this.A0N;
            if (surface != null) {
                Surface surface2 = this.A0O;
                String[] strArr = A0e;
                if (strArr[1].length() != strArr[7].length()) {
                    throw new RuntimeException();
                }
                A0e[5] = "XHzJ2HWKwUKgXdkRP5t1s0JJnuLP0pfM";
                if (surface2 == surface) {
                    this.A0O = null;
                }
                surface.release();
                this.A0N = null;
            }
        } catch (Throwable th) {
            this.A04 = 0;
            if (this.A0N != null) {
                Surface surface3 = this.A0O;
                Surface surface4 = this.A0N;
                if (surface3 == surface4) {
                    this.A0O = null;
                }
                surface4.release();
                this.A0N = null;
            }
            throw th;
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3E
    public final void A1J(long j) {
        this.A04--;
        while (true) {
            int i = this.A0A;
            if (i == 0) {
                return;
            }
            long j2 = this.A0a[0];
            if (A0e[4].charAt(25) == 'e') {
                throw new RuntimeException();
            }
            A0e[6] = "welnO5ckQSDvaPJP3GxM6gJ3";
            if (j >= j2) {
                long[] jArr = this.A0Z;
                this.A0M = jArr[0];
                int i2 = i - 1;
                this.A0A = i2;
                System.arraycopy(jArr, 1, jArr, 0, i2);
                long[] jArr2 = this.A0a;
                System.arraycopy(jArr2, 1, jArr2, 0, this.A0A);
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0086  */
    @Override // com.facebook.ads.redexgen.X.C3E
    public final void A1K(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        String strA05 = A05(903, 10, 26);
        boolean zContainsKey = mediaFormat.containsKey(strA05);
        String strA06 = A05(913, 8, 101);
        String strA07 = A05(883, 11, 39);
        String strA08 = A05(894, 9, 49);
        boolean z = zContainsKey && mediaFormat.containsKey(strA08) && mediaFormat.containsKey(strA07) && mediaFormat.containsKey(strA06);
        if (z) {
            integer = (mediaFormat.getInteger(strA05) - mediaFormat.getInteger(strA08)) + 1;
        } else {
            integer = mediaFormat.getInteger(A05(1359, 5, 19));
        }
        this.A08 = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger(strA07) - mediaFormat.getInteger(strA06)) + 1;
        } else {
            integer2 = mediaFormat.getInteger(A05(971, 6, 26));
        }
        this.A06 = integer2;
        this.A01 = this.A02;
        if (C0996Hx.A02 >= 21) {
            int i = this.A0B;
            if (i == 90) {
                int i2 = this.A08;
                int rotatedHeight = this.A06;
                this.A08 = rotatedHeight;
                this.A06 = i2;
                this.A01 = 1.0f / this.A01;
            } else {
                if (A0e[6].length() == 11) {
                    throw new RuntimeException();
                }
                A0e[4] = "tMLsScMJVvSfEldK2kkn5FelCETUa7Eh";
                if (i == 270) {
                    int i3 = this.A08;
                    int rotatedHeight2 = this.A06;
                    this.A08 = rotatedHeight2;
                    this.A06 = i3;
                    this.A01 = 1.0f / this.A01;
                }
            }
        } else {
            int i4 = this.A0B;
            if (A0e[4].charAt(25) != 'e') {
                A0e[5] = "YnEjoYuo9QDNkry4zztMBrHkotN6qawB";
                this.A07 = i4;
            } else {
                this.A07 = i4;
            }
        }
        int rotatedHeight3 = this.A0F;
        mediaCodec.setVideoScalingMode(rotatedHeight3);
    }

    @Override // com.facebook.ads.redexgen.X.C3E
    public final void A1L(Format format) throws C9K {
        super.A1L(format);
        this.A0X.A04(format);
        this.A02 = format.A02;
        this.A0B = format.A0B;
    }

    @Override // com.facebook.ads.redexgen.X.C3E
    public final void A1M(XE xe) {
        this.A04++;
        this.A0K = Math.max(xe.A00, this.A0K);
        if (C0996Hx.A02 < 23 && this.A0S) {
            A1R();
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3E
    public final void A1N(C0874Cy c0874Cy, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws D7 {
        I7 i7A04 = A04(c0874Cy, format, A19());
        this.A0P = i7A04;
        MediaFormat mediaFormatA03 = A03(format, i7A04, this.A0Y, this.A0G);
        if (this.A0O == null) {
            HI.A04(A0T(c0874Cy));
            if (this.A0N == null) {
                this.A0N = DummySurface.A01(this.A0V, c0874Cy.A05);
            }
            this.A0O = this.A0N;
        }
        mediaCodec.configure(mediaFormatA03, this.A0O, mediaCrypto, 0);
        if (C0996Hx.A02 >= 23 && this.A0S) {
            this.A00 = new I8(this, mediaCodec);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3E
    public final void A1O(String str, long j, long j2) {
        this.A0X.A07(str, j, j2);
        this.A0Q = A0U(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        if (A0R(r8, r19 - r4) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d6, code lost:
    
        if (r9 != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d8, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d9, code lost:
    
        if (r9 != false) goto L45;
     */
    @Override // com.facebook.ads.redexgen.X.C3E
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A1P(long r32, long r34, android.media.MediaCodec r36, java.nio.ByteBuffer r37, int r38, int r39, long r40, boolean r42) throws com.facebook.ads.redexgen.X.C9K {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1A.A1P(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, long, boolean):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.C3E
    public final boolean A1Q(C0874Cy c0874Cy) {
        return this.A0O != null || A0T(c0874Cy);
    }

    public final void A1R() {
        if (!this.A0R) {
            this.A0R = true;
            this.A0X.A03(this.A0O);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0882Dl, com.facebook.ads.redexgen.X.InterfaceC08029p
    public final void A8L(int i, Object obj) throws C9K {
        if (i == 1) {
            A0L((Surface) obj);
            return;
        }
        if (i == 4) {
            this.A0F = ((Integer) obj).intValue();
            MediaCodec mediaCodecA1C = A1C();
            if (mediaCodecA1C == null) {
                return;
            }
            int i2 = this.A0F;
            if (A0e[6].length() == 11) {
                throw new RuntimeException();
            }
            A0e[4] = "ynW9njiEKJeSgaNYH6SlaayD7qz19oDR";
            mediaCodecA1C.setVideoScalingMode(i2);
            return;
        }
        super.A8L(i, obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        if (r9.A0S == false) goto L20;
     */
    @Override // com.facebook.ads.redexgen.X.C3E, com.facebook.ads.redexgen.X.XS
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A90() {
        /*
            r9 = this;
            boolean r0 = super.A90()
            r8 = 1
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == 0) goto L3f
            boolean r0 = r9.A0R
            if (r0 != 0) goto L36
            android.view.Surface r1 = r9.A0N
            if (r1 == 0) goto L18
            android.view.Surface r0 = r9.A0O
            if (r0 == r1) goto L36
        L18:
            android.media.MediaCodec r3 = r9.A1C()
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C1A.A0e
            r0 = 6
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 11
            if (r1 == r0) goto L39
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1A.A0e
            java.lang.String r1 = "3hQTJaHLIy4JZfUSwiFMMfqMh"
            r0 = 6
            r2[r0] = r1
            if (r3 == 0) goto L36
            boolean r0 = r9.A0S
            if (r0 == 0) goto L3f
        L36:
            r9.A0J = r5
            return r8
        L39:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L3f:
            long r1 = r9.A0J
            r7 = 0
            int r0 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r0 != 0) goto L47
            return r7
        L47:
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r1 = r9.A0J
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto L52
            return r8
        L52:
            r9.A0J = r5
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1A.A90():boolean");
    }
}
