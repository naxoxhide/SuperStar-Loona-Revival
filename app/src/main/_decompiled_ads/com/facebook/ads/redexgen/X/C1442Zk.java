package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.facebook.ads.RewardedAdListener;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import java.util.Arrays;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1442Zk implements AnonymousClass25 {
    public static byte[] A04;
    public static String[] A05 = {"PyT2XUnl", "3EmvKqRjFYzRkizxlD8eotggUBC8U5J9", "Ib6uyfMRsh5ysHZ3i8ryXk3sO16qq9Ys", "q2kkzr74cnXMazMYxmC9c", "9U931lGThJH7Qz6wctlm6EKEWHFtvDAV", "f15MquYM06llw3BWZWASFwAp5egI2HKX", "yMUgiPhi", "t3xZZPMR"};
    public final AbstractC1452Zw A00;
    public final InterfaceC06181y A01;
    public final AnonymousClass23 A02;
    public final YA A03;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 57);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-77, -42, -110, -31, -44, -36, -41, -43, -26, -110, -37, -27, -110, -32, -25, -34, -34, -115, -96, -103, -113, -105, -112, -86, -112, -93, -97, -99, -116, -98, -86, -106, -112, -92, -74, -78, -79, -27, -44, -39, -43, -34, -45, -43, -66, -43, -28, -25, -33, -30, -37, -87, -82, -76, -65, -91, -78, -78, -81, -78, -65, -93, -81, -92, -91, -65, -85, -91, -71, 4, 7, 6, -1, 23, 1, 6, 14, -7, 4, 1, -4, -7, 12, 1, 7, 6, 23, 12, 1, 5, -3, 23, 3, -3, 17, -61, -37, -23, -23, -41, -35, -37, -80, -106, -66, -38, -28, -28, -38, -33, -40, -111, -45, -26, -33, -43, -35, -42, -111, -41, -32, -29, -111, -34, -42, -28, -28, -46, -40, -42, -97, -95, -94, -96, -83, -109, -96, -96, -99, -96, -83, -101, -109, -95, -95, -113, -107, -109, -83, -103, -109, -89, 4, 19, 12};
    }

    static {
        A01();
    }

    public C1442Zk(YA ya, AnonymousClass23 anonymousClass23, InterfaceC06181y interfaceC06181y, AbstractC1452Zw abstractC1452Zw) {
        this.A03 = ya;
        this.A02 = anonymousClass23;
        this.A01 = interfaceC06181y;
        this.A00 = abstractC1452Zw;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:19:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:21:0x00b5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:29:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:31:0x0100 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x0101  */
    /* JADX WARN: Code duplicated, block: B:33:0x010b  */
    /* JADX WARN: Code duplicated, block: B:35:0x0115  */
    /* JADX WARN: Code duplicated, block: B:37:0x012a  */
    /* JADX WARN: Code duplicated, block: B:39:0x013a  */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass25
    public final void A8M(Message message) {
        int i;
        String[] strArr;
        RewardedAdListener rewardedAdListenerA04;
        InterstitialAd interstitialAdA01 = this.A02.A01();
        String strA00 = A00(152, 3, 106);
        if (interstitialAdA01 == null) {
            this.A03.A07().A9M(strA00, C07597x.A0K, new C07607y(A00(0, 17, 57)));
            return;
        }
        int i2 = message.what;
        String strA01 = A00(95, 9, 61);
        String strA02 = A00(104, 27, 56);
        String strA03 = A00(17, 17, 18);
        switch (i2) {
            case 10:
            case 1023:
                Bundle bundle = message.getData().getBundle(strA03);
                if (bundle != null) {
                    int i3 = bundle.getInt(A00(51, 18, 39));
                    String string = bundle.getString(A00(131, 21, 21));
                    AdError adError = new AdError(i3, string);
                    this.A01.AFG(adError);
                    if (this.A02.A02() != null) {
                        this.A02.A02().onError(interstitialAdA01, adError);
                    } else {
                        Log.e(A00(34, 17, 55), string);
                    }
                } else {
                    this.A01.AFC(EnumC06171x.A05);
                    this.A03.A07().A9M(strA00, C07597x.A0V, new C07607y(strA02, strA01 + message));
                }
                this.A02.A0C(null);
                return;
            case PointerIconCompat.TYPE_GRAB /* 1020 */:
                this.A01.AFK();
                Bundle bundle2 = message.getData().getBundle(strA03);
                if (bundle2 != null) {
                    this.A02.A0B(bundle2.getLong(A00(69, 26, WorkQueueKt.MASK)));
                } else {
                    this.A03.A07().A9M(strA00, C07597x.A0V, new C07607y(strA02, strA01 + message));
                }
                this.A02.A0C(null);
                break;
            case 1022:
                this.A01.AFU();
                break;
        }
        if (this.A02.A02() == null) {
            return;
        }
        switch (message.what) {
            case PointerIconCompat.TYPE_GRAB /* 1020 */:
                this.A02.A02().onAdLoaded(interstitialAdA01);
                return;
            case PointerIconCompat.TYPE_GRABBING /* 1021 */:
                this.A02.A02().onInterstitialDisplayed(interstitialAdA01);
                if (A05[2].charAt(18) != 'n') {
                    String[] strArr2 = A05;
                    strArr2[1] = "IMuRostxJ5htnzhiOcsxYcu1iidsGUgj";
                    strArr2[5] = "ubJ4M5GxN6FfPval4rtOnbhl8vPUgGKC";
                    return;
                }
                throw new RuntimeException();
            case 1022:
                this.A02.A02().onInterstitialDismissed(interstitialAdA01);
                return;
            case 1023:
            default:
                if (this.A02.A04() == null) {
                    return;
                }
                i = message.what;
                strArr = A05;
                if (strArr[3].length() != strArr[7].length()) {
                    A05[4] = "YO9dGq40ZDljeOjTjHA4uB3VVKU9R56I";
                    switch (i) {
                        case 3000:
                            this.A02.A04().onRewardedAdCompleted();
                            return;
                        case 3001:
                            rewardedAdListenerA04 = this.A02.A04();
                            if (A05[2].charAt(18) == 'n') {
                                rewardedAdListenerA04.onRewardedAdServerSucceeded();
                                return;
                            }
                            String[] strArr3 = A05;
                            strArr3[1] = "4ubpoteMIucGsWyTMsTtOH4ZOdBl9bHr";
                            strArr3[5] = "Xxx4qDjyhZoijrhiIp4u1mFMOEMCLZoL";
                            rewardedAdListenerA04.onRewardedAdServerSucceeded();
                            return;
                        case AuthApiStatusCodes.AUTH_API_CLIENT_ERROR /* 3002 */:
                            this.A02.A04().onRewardedAdServerFailed();
                            return;
                        default:
                            return;
                    }
                }
                throw new RuntimeException();
            case 1024:
                this.A02.A02().onAdClicked(interstitialAdA01);
                return;
            case InputDeviceCompat.SOURCE_GAMEPAD /* 1025 */:
                this.A02.A02().onLoggingImpression(interstitialAdA01);
                return;
            case 1026:
                if (!(this.A02.A02() instanceof InterstitialAdExtendedListener)) {
                    if (this.A02.A04() == null) {
                        return;
                    }
                    i = message.what;
                    strArr = A05;
                    if (strArr[3].length() != strArr[7].length()) {
                        A05[4] = "YO9dGq40ZDljeOjTjHA4uB3VVKU9R56I";
                        switch (i) {
                            case 3000:
                                this.A02.A04().onRewardedAdCompleted();
                                return;
                            case 3001:
                                rewardedAdListenerA04 = this.A02.A04();
                                if (A05[2].charAt(18) == 'n') {
                                    rewardedAdListenerA04.onRewardedAdServerSucceeded();
                                    return;
                                }
                                String[] strArr4 = A05;
                                strArr4[1] = "4ubpoteMIucGsWyTMsTtOH4ZOdBl9bHr";
                                strArr4[5] = "Xxx4qDjyhZoijrhiIp4u1mFMOEMCLZoL";
                                rewardedAdListenerA04.onRewardedAdServerSucceeded();
                                return;
                            case AuthApiStatusCodes.AUTH_API_CLIENT_ERROR /* 3002 */:
                                this.A02.A04().onRewardedAdServerFailed();
                                return;
                            default:
                                return;
                        }
                    }
                } else {
                    AnonymousClass23 anonymousClass23 = this.A02;
                    if (A05[2].charAt(18) != 'n') {
                        A05[2] = "QiAUsDkapNh1fTZA9J8Gsz0JLC17Ghy8";
                        ((InterstitialAdExtendedListener) anonymousClass23.A02()).onInterstitialActivityDestroyed();
                        if (this.A02.A04() == null) {
                            return;
                        }
                        i = message.what;
                        strArr = A05;
                        if (strArr[3].length() != strArr[7].length()) {
                            A05[4] = "YO9dGq40ZDljeOjTjHA4uB3VVKU9R56I";
                            switch (i) {
                                case 3000:
                                    this.A02.A04().onRewardedAdCompleted();
                                    return;
                                case 3001:
                                    rewardedAdListenerA04 = this.A02.A04();
                                    if (A05[2].charAt(18) == 'n') {
                                        rewardedAdListenerA04.onRewardedAdServerSucceeded();
                                        return;
                                    }
                                    String[] strArr5 = A05;
                                    strArr5[1] = "4ubpoteMIucGsWyTMsTtOH4ZOdBl9bHr";
                                    strArr5[5] = "Xxx4qDjyhZoijrhiIp4u1mFMOEMCLZoL";
                                    rewardedAdListenerA04.onRewardedAdServerSucceeded();
                                    return;
                                case AuthApiStatusCodes.AUTH_API_CLIENT_ERROR /* 3002 */:
                                    this.A02.A04().onRewardedAdServerFailed();
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                }
                throw new RuntimeException();
        }
    }
}
