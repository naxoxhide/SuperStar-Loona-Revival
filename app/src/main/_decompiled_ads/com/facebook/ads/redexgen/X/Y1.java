package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class Y1 extends K8 {
    public static byte[] A05;
    public final /* synthetic */ int A00;
    public final /* synthetic */ C7S A01;
    public final /* synthetic */ InterfaceC07527q A02;
    public final /* synthetic */ C07607y A03;
    public final /* synthetic */ String A04;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 120);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{-37, -3, 30, 27, 46, 32, -39, 28, 43, 26, 44, 33, -39, 27, 30, 28, 26, 46, 44, 30, -39, 44, -2, 39, 47, 34, 43, 40, 39, 38, 30, 39, 45, -3, 26, 45, 26, 9, 43, 40, 47, 34, 29, 30, 43, -39, 39, 40, 45, -39, 34, 39, 35, 30, 28, 45, 30, 29, -46, -24, -19, -22, -97, -24, -14, -97, -19, -12, -21, -21, -96, 30, 33, 33, 38, 49, 38, 44, 43, 30, 41, 28, 38, 43, 35, 44, 45, 66, 45, 53, 56, 45, 46, 56, 49, 43, 48, 53, 63, 55, 43, 63, 60, 45, 47, 49, 62, 60, 62, 67, SignedBytes.MAX_POWER_OF_TWO, 104, 91, 89, 101, 104, 90, 85, 90, 87, 106, 87, 88, 87, 105, 91, -18, -31, -19, -15, -31, -17, -16, -37, -27, -32, 44, 46, 27, 45, 50, 41, 30, 49, 51, 32, 50, 55, 46, 35, 29, 33, 45, 34, 35};
    }

    public Y1(C7S c7s, String str, int i, C07607y c07607y, InterfaceC07527q interfaceC07527q) {
        this.A01 = c7s;
        this.A04 = str;
        this.A00 = i;
        this.A03 = c07607y;
        this.A02 = interfaceC07527q;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x00b6 A[Catch: all -> 0x0174, TryCatch #0 {all -> 0x0174, blocks: (B:2:0x0000, B:5:0x000f, B:7:0x0041, B:8:0x0047, B:10:0x004f, B:11:0x0059, B:13:0x0082, B:14:0x0093, B:16:0x00a4, B:21:0x00cf, B:23:0x00d7, B:25:0x00dd, B:26:0x00e9, B:28:0x00f5, B:40:0x0162, B:18:0x00b6, B:20:0x00c2, B:29:0x00fb, B:31:0x00ff, B:32:0x0105, B:34:0x0109, B:35:0x0123, B:36:0x012f, B:38:0x0137, B:39:0x0141), top: B:44:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x00c2 A[Catch: all -> 0x0174, TryCatch #0 {all -> 0x0174, blocks: (B:2:0x0000, B:5:0x000f, B:7:0x0041, B:8:0x0047, B:10:0x004f, B:11:0x0059, B:13:0x0082, B:14:0x0093, B:16:0x00a4, B:21:0x00cf, B:23:0x00d7, B:25:0x00dd, B:26:0x00e9, B:28:0x00f5, B:40:0x0162, B:18:0x00b6, B:20:0x00c2, B:29:0x00fb, B:31:0x00ff, B:32:0x0105, B:34:0x0109, B:35:0x0123, B:36:0x012f, B:38:0x0137, B:39:0x0141), top: B:44:0x0000 }] */
    @Override // com.facebook.ads.redexgen.X.K8
    public final void A06() {
        String strA03;
        Map<String, String> mapA4j;
        String strA78;
        try {
            if (C07537r.A0J(this.A01, this.A04, this.A00, this.A03)) {
                return;
            }
            C1015Iq.A08(this.A01, EnumC1007Ii.A0A.toString() + A00(0, 1, 41) + this.A04);
            Throwable cause = this.A03.getCause();
            if (cause != null) {
                strA03 = LD.A03(this.A01, cause);
            } else if (IR.A0R(this.A01)) {
                C7S c7s = this.A01;
                Throwable deLogExceptionCause = this.A03;
                strA03 = LD.A03(c7s, deLogExceptionCause);
            } else {
                strA03 = A00(0, 0, 106) + this.A03.getMessage();
            }
            if (IR.A0V(this.A01)) {
                mapA4j = this.A01.A03().A4j();
            } else {
                InterfaceC07527q interfaceC07527q = this.A02;
                if (interfaceC07527q != null) {
                    mapA4j = interfaceC07527q.A6p();
                } else if (C07537r.A02) {
                    String message = A00(1, 57, 65);
                    Throwable deLogExceptionCause2 = new RuntimeException(message, this.A03);
                    C07537r.A0F(deLogExceptionCause2);
                    mapA4j = new HashMap<>();
                } else {
                    mapA4j = this.A01.A03().A4j();
                }
            }
            String strA00 = A00(136, 7, 65);
            String stackTrace = this.A04;
            mapA4j.put(strA00, stackTrace);
            String strA01 = A00(143, 12, 70);
            String stackTrace2 = String.valueOf(this.A00);
            mapA4j.put(strA01, stackTrace2);
            JSONObject jSONObjectA02 = this.A03.A02();
            if (jSONObjectA02 != null) {
                String strA02 = A00(71, 15, 69);
                String stackTrace3 = jSONObjectA02.toString();
                mapA4j.put(strA02, stackTrace3);
            }
            String strA04 = A00(106, 5, 99);
            String stackTrace4 = this.A04;
            if (!strA04.equals(stackTrace4)) {
                String strA05 = A00(111, 15, 126);
                String stackTrace5 = this.A04;
                if (strA05.equals(stackTrace5)) {
                    strA78 = this.A01.A03().A78();
                    if (strA78 != null) {
                        String stackTrace6 = A00(86, 20, 84);
                        mapA4j.put(stackTrace6, strA78);
                    }
                }
            } else {
                strA78 = this.A01.A03().A78();
                if (strA78 != null) {
                    String stackTrace7 = A00(86, 20, 84);
                    mapA4j.put(stackTrace7, strA78);
                }
            }
            String strA0B = this.A01.A0B();
            if (strA0B != null && !TextUtils.isEmpty(strA0B)) {
                String stackTrace8 = A00(126, 10, 4);
                mapA4j.put(stackTrace8, strA0B);
            }
            InterfaceC07517p interfaceC07517p = (InterfaceC07517p) C07537r.A0A.get();
            if (interfaceC07517p != null) {
                interfaceC07517p.AGS(strA03, mapA4j, this.A01);
            } else {
                Throwable deLogExceptionCause3 = new RuntimeException(A00(58, 13, 7));
                C07537r.A0F(deLogExceptionCause3);
            }
        } catch (Throwable t) {
            C07537r.A0F(t);
        }
    }
}
