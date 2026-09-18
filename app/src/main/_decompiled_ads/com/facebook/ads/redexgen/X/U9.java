package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import org.json.JSONException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class U9 implements InterfaceC1210Qi {
    public static byte[] A03;
    public final /* synthetic */ long A00;
    public final /* synthetic */ C1030Jg A01;
    public final /* synthetic */ C1032Jj A02;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 10);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{97, 52, 101, 97, 96, 101, 105, 53, 16, 70, 18, 30, 70, 16, 65, 68, 1, 24, 4, 5, 14, 51, 40, 46, 59, 63, 34, 36, 37, 113, 107, 108, 90, 77, 73, 90, 77, 31, 90, 77, 77, 80, 77, 31, 80, 92, 92, 74, 77, 77, 90, 91, 75, 125, 106, 110, 125, 106, 56, 106, 125, 104, 116, 113, 125, 124, 56, 107, 109, 123, 123, 125, 107, 107, 126, 109, 116, 116, 97, 75, 74, 103, 75, 73, 84, 72, 65, 80, 65, 95, 94, 117, 66, 66, 95, 66};
    }

    public U9(C1032Jj c1032Jj, C1030Jg c1030Jg, long j) {
        this.A02 = c1032Jj;
        this.A01 = c1030Jg;
        this.A00 = j;
    }

    private final void A02(C1222Qu c1222Qu) {
        Jf.A06(this.A01);
        try {
            InterfaceC1208Qg response = c1222Qu.A00();
            if (response != null) {
                String strA64 = response.A64();
                C1035Jm serverResponse = this.A02.A05.A06(this.A02.A04, strA64, this.A00);
                if (serverResponse.A01() == EnumC1034Jl.A03) {
                    U5 u5 = (U5) serverResponse;
                    String strA04 = u5.A04();
                    AdErrorType adErrorTypeAdErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(u5.A03(), AdErrorType.ERROR_MESSAGE);
                    if (strA04 != null) {
                        strA64 = strA04;
                    }
                    this.A02.A04.A0E().A2r(LM.A01(this.A02.A00), adErrorTypeAdErrorTypeFromCode.getErrorCode(), strA64, adErrorTypeAdErrorTypeFromCode.isPublicError());
                    this.A02.A0D(JG.A01(adErrorTypeAdErrorTypeFromCode, strA64));
                    return;
                }
            }
            AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
            String errorMessage = c1222Qu.getMessage();
            this.A02.A04.A0E().A2r(LM.A01(this.A02.A00), adErrorType.getErrorCode(), errorMessage, adErrorType.isPublicError());
            this.A02.A0D(JG.A01(adErrorType, errorMessage));
        } catch (JSONException e) {
            AdErrorType adErrorType2 = AdErrorType.NETWORK_ERROR;
            String errorMessage2 = c1222Qu.getMessage();
            this.A02.A04.A0E().A2r(LM.A01(this.A02.A00), adErrorType2.getErrorCode(), A00(16, 15, 65) + e.getMessage(), adErrorType2.isPublicError());
            this.A02.A0D(JG.A01(adErrorType2, errorMessage2));
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1210Qi
    public final void AAu(InterfaceC1208Qg interfaceC1208Qg) {
        JU.A05(A00(79, 10, 46), A00(52, 27, 18), A00(0, 8, 90));
        if (interfaceC1208Qg != null) {
            String strA64 = interfaceC1208Qg.A64();
            Jf.A06(this.A01);
            this.A02.A0N(strA64, this.A00, this.A01);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1210Qi
    public final void ABI(Exception exc) {
        JU.A05(A00(89, 7, 58), A00(31, 21, 53), A00(8, 8, 45));
        if (C1222Qu.class.equals(exc.getClass())) {
            A02((C1222Qu) exc);
            return;
        }
        AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
        String errorMessage = exc.getMessage();
        this.A02.A04.A0E().A2r(LM.A01(this.A02.A00), adErrorType.getErrorCode(), errorMessage, adErrorType.isPublicError());
        this.A02.A0D(JG.A01(adErrorType, errorMessage));
    }
}
