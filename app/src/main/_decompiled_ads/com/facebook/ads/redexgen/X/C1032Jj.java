package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1032Jj {
    public static byte[] A07;
    public static final LY A08;
    public static final Executor A09;
    public static final AtomicReference<InterfaceC1036Jn> A0A;
    public long A00;
    public Ji A01;
    public Map<String, String> A02;
    public final C2G A03;
    public final YA A04;
    public final C1033Jk A05;
    public final String A06;

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 80);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A07 = new byte[]{62, 50, 62, Base64.padSymbol, 62, 110, 104, 62, 122, 105, 107, 119, 117, 78, 65, 68, 72, 67, 89, 82, 95, 72, 92, 88, 72, 94, 89, 82, 68, 73, 98, 88, 11, 121, 101, 17, 11, 100, 101, 10, 108, 99, 102, 102, 10, 88, 79, 73, 79, 67, 92, 79, 78, 20, 53, 122, 28, 51, 54, 54, 122, 63, 40, 40, 53, 40, 122, 57, 53, 62, 63, 122, 1, 127, 41, 7, 122, 127, 41, 15, 13, 6, 13, 26, 1, 11, 81, 90, 75, 72, 80, 77, 84, 40, 41, 0, 47, 42, 42, 14, 41, 41, 45};
    }

    static {
        A0A();
        LY ly = new LY();
        A08 = ly;
        A09 = Executors.newCachedThreadPool(ly);
        A0A = new AtomicReference<>();
    }

    public C1032Jj(YA ya) {
        this(ya, C2H.A00(ya.A01()));
    }

    public C1032Jj(YA ya, C2G c2g) {
        this.A00 = -1L;
        this.A04 = ya;
        this.A05 = C1033Jk.A00();
        this.A06 = C1037Jo.A01(ya);
        this.A03 = c2g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public U9 A02(long j, C1030Jg c1030Jg) {
        return new U9(this, c1030Jg, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09() {
        YA ya = this.A04;
        if (ya == null || !C1227Qz.A0A(ya)) {
            return;
        }
        C07607y c07607y = new C07607y(A05(8, 5, 107));
        c07607y.A03(1);
        this.A04.A07().A9M(A05(86, 7, 111), C07597x.A1w, c07607y);
    }

    private void A0B(int i, String str) {
        String strA05 = A05(37, 16, 122);
        String strA06 = A05(0, 8, 90);
        String strA07 = A05(93, 10, 22);
        JU.A05(strA07, strA05, strA06);
        JU.A04(strA07, String.format(Locale.US, A05(53, 26, 10), Integer.valueOf(i), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(JG jg) {
        Ji ji = this.A01;
        if (ji != null) {
            ji.ABH(jg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(JG jg) {
        LP.A00(new U7(this, jg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0K(U6 u6) {
        Ji ji = this.A01;
        if (ji != null) {
            ji.AD5(u6);
        }
    }

    private void A0L(U6 u6) {
        C7Y syncModule;
        LP.A00(new U8(this, u6));
        if (IP.A22(this.A04) && (syncModule = this.A04.A05()) != null) {
            syncModule.A5i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0M(String str, long j, C1030Jg c1030Jg) {
        String str2;
        try {
            try {
                C1035Jm c1035JmA06 = this.A05.A06(this.A04, str, j);
                C8F c8fA00 = c1035JmA06.A00();
                if (c8fA00 != null) {
                    IP.A0Q(this.A04).A2S(c8fA00.A09());
                    this.A04.A07().AA1();
                    this.A03.A0N(c8fA00.A06());
                    Jf.A05(c8fA00.A05().A0B(), c1030Jg);
                    C1081Lj.A01(this.A04, A09, c8fA00);
                    C07607y c07607y = new C07607y(A05(30, 7, 123) + C1067Kv.A02());
                    c07607y.A04(1);
                    c07607y.A08(false);
                    this.A04.A07().A9q(A05(79, 7, 56), C07597x.A1W, c07607y);
                }
                switch (C1031Jh.A00[c1035JmA06.A01().ordinal()]) {
                    case 1:
                        U6 u6 = (U6) c1035JmA06;
                        if (c8fA00 != null) {
                            if (c8fA00.A05().A0E()) {
                                Jf.A07(str, c1030Jg);
                            }
                            Map<String, String> map = this.A02;
                            if (map != null) {
                                str2 = map.get(A05(13, 17, 93));
                            } else {
                                str2 = null;
                            }
                            if (!TextUtils.isEmpty(c1035JmA06.A02()) && !TextUtils.isEmpty(str2)) {
                                this.A04.A02().AEl(this.A04, str2, c1035JmA06.A02());
                            }
                        }
                        this.A04.A0E().A2s(LM.A01(this.A00));
                        A0L(u6);
                        break;
                    case 2:
                        U5 u5 = (U5) c1035JmA06;
                        String strA04 = u5.A04();
                        AdErrorType adErrorTypeAdErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(u5.A03(), AdErrorType.ERROR_MESSAGE);
                        A0B(u5.A03(), strA04);
                        if (strA04 == null) {
                            strA04 = str;
                        }
                        this.A04.A0E().A2r(LM.A01(this.A00), adErrorTypeAdErrorTypeFromCode.getErrorCode(), strA04, adErrorTypeAdErrorTypeFromCode.isPublicError());
                        A0D(JG.A01(adErrorTypeAdErrorTypeFromCode, strA04));
                        break;
                    default:
                        AdErrorType adErrorType = AdErrorType.UNKNOWN_RESPONSE;
                        this.A04.A0E().A2r(LM.A01(this.A00), adErrorType.getErrorCode(), str, adErrorType.isPublicError());
                        A0D(JG.A01(adErrorType, str));
                        break;
                }
            } catch (Exception e) {
                e = e;
                String message = e.getMessage();
                AdErrorType adErrorType2 = AdErrorType.PARSER_FAILURE;
                this.A04.A0E().A2r(LM.A01(this.A00), adErrorType2.getErrorCode(), message, adErrorType2.isPublicError());
                A0D(JG.A01(adErrorType2, message));
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0N(String str, long j, C1030Jg c1030Jg) {
        A09.execute(new UA(this, str, j, c1030Jg));
    }

    public final void A0O(C1030Jg c1030Jg) {
        this.A00 = System.currentTimeMillis();
        AnonymousClass86.A0B(this.A04);
        InterfaceC1036Jn provider = A0A.get();
        if (provider != null) {
            A0N(provider.provide(c1030Jg), 10L, c1030Jg);
            return;
        }
        if (Jf.A08(c1030Jg)) {
            ExecutorC1072La.A06.execute(new UC(this));
            String strA02 = Jf.A02(c1030Jg);
            if (strA02 != null) {
                this.A04.A0E().AG8();
                A0N(strA02, 0L, c1030Jg);
                return;
            } else {
                AdErrorType error = AdErrorType.LOAD_TOO_FREQUENTLY;
                this.A04.A0E().A2r(LM.A01(this.A00), error.getErrorCode(), error.getDefaultErrorMessage(), error.isPublicError());
                A0D(JG.A01(error, null));
                return;
            }
        }
        A09.execute(new UB(this, c1030Jg));
    }

    public final void A0P(Ji ji) {
        this.A01 = ji;
    }
}
