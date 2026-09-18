package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1514aw extends AbstractC05750g {
    public static String A03;
    public static String A04;
    public static String A05;
    public static byte[] A06;
    public static String[] A07 = {"1", "OJ2IOsbUnCKybSqk53zM3JXcifahO", "e4RldewFXKwYCBzcZ5CwWZ5XjhlRHNiJ", "729G42gqUNiz5ZAUAxRhvFZ2YWMhTd0L", "J1Ql0tv9onNfDvsMKNTgjNyaDa6Pnzub", "9fBm", "mbPUpspz4Nj5AFGqwEe2w9x9WWs", "2uSYGuFAJgr"};
    public final boolean A00;
    public final C05810n A01;
    public final boolean A02;

    public static String A0A(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 30);
            if (A07[3].charAt(0) != '7') {
                throw new RuntimeException();
            }
            A07[5] = "PWjD";
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A06 = new byte[]{93, 114, 119, 125, 117, 62, 114, 113, 121, 121, 123, 122, 68, 75, 65, 87, 74, 76, 65, 11, 76, 75, 81, SignedBytes.MAX_POWER_OF_TWO, 75, 81, 11, 68, 70, 81, 76, 74, 75, 11, 115, 108, 96, 114, 24, 27, 25, 17, 37, 14, 19, 23, 31, 46, 39, 35, 52, 39, 29, 54, 43, 47, 39, 11, 17, 16, 7, 11, 9, 1, 37, 35, 53, 53, 51, 37, 37, 76, 87, 80, 79, 92, 75, 74, 88, 85, 102, 85, 80, 87, 82, 89, 95, 73, 94, 115, 88, 94, 77, 79, 71, 73, 94, 115, 69, 95, 115, 66, 67, 88, 115, 66, 89, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 75, 93, 72, 95, 84, 99, 93, 82, 88, 99, 94, 78, 83, 75, 79, 89};
    }

    public abstract void A0D();

    static {
        A0B();
        A03 = A0A(64, 7, 72);
        A04 = A0A(85, 24, 50);
        A05 = A0A(109, 16, 34);
    }

    public AbstractC1514aw(YA ya, InterfaceC1004If interfaceC1004If, String str, C05810n c05810n, boolean z) {
        this(ya, interfaceC1004If, str, c05810n, z, false);
    }

    public AbstractC1514aw(YA ya, InterfaceC1004If interfaceC1004If, String str, C05810n c05810n, boolean z, boolean z2) {
        super(ya, interfaceC1004If, str);
        this.A01 = c05810n;
        this.A02 = z;
        this.A00 = z2;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC05750g
    public final void A0C() {
        C05810n c05810n = this.A01;
        if (c05810n != null) {
            c05810n.A07(super.A02);
        }
        A0D();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0080  */
    /* JADX WARN: Code duplicated, block: B:23:0x008f  */
    /* JADX WARN: Code duplicated, block: B:26:0x00ac  */
    public final void A0E(Map<String, String> extraData, EnumC05740f enumC05740f) {
        C05810n c05810n;
        if (!TextUtils.isEmpty(super.A02)) {
            if (this instanceof FI) {
                super.A01.A9m(super.A02, extraData);
            } else {
                InterfaceC1004If interfaceC1004If = super.A01;
                String str = super.A02;
                if (A07[6].length() != 8) {
                    A07[5] = "D2ZF";
                    interfaceC1004If.A9V(str, extraData);
                } else {
                    interfaceC1004If.A9V(str, extraData);
                }
            }
            boolean zA02 = EnumC05740f.A02(enumC05740f);
            if (A07[1].length() == 32) {
                throw new RuntimeException();
            }
            A07[0] = "X";
            boolean z = this.A01 != null;
            boolean isError = IP.A1w(super.A00);
            if (isError) {
                Map<String, String> navigationDataMap = new HashMap<>();
                boolean isError2 = !zA02;
                navigationDataMap.put(A03, Boolean.toString(isError2));
                navigationDataMap.put(A04, Boolean.toString(z));
                String str2 = A05;
                boolean isError3 = this.A00;
                navigationDataMap.put(str2, Boolean.toString(isError3));
                super.A01.A9W(super.A02, navigationDataMap);
            }
            C05810n c05810n2 = this.A01;
            if (c05810n2 != null) {
                c05810n2.A06(enumC05740f);
                if (A07[6].length() != 8) {
                    A07[6] = "4hYdj7INWre5bef3R1byHGHBMmQCX";
                    if (zA02) {
                        c05810n = this.A01;
                        if (A07[6].length() != 8) {
                            String[] strArr = A07;
                            strArr[2] = "42brCgECckKxVuTsLxKp6fXlInYi7mUj";
                            strArr[4] = "SJ7s8Rg0tKhfkKPQamVQVBa2w2xrx0QV";
                            c05810n.A05();
                        } else {
                            c05810n.A05();
                        }
                    }
                } else {
                    A07[5] = "IMSq";
                    if (zA02) {
                        c05810n = this.A01;
                        if (A07[6].length() != 8) {
                            String[] strArr2 = A07;
                            strArr2[2] = "42brCgECckKxVuTsLxKp6fXlInYi7mUj";
                            strArr2[4] = "SJ7s8Rg0tKhfkKPQamVQVBa2w2xrx0QV";
                            c05810n.A05();
                        } else {
                            c05810n.A05();
                        }
                    }
                }
            } else {
                HashMap map = new HashMap();
                map.put(A0A(47, 10, 92), Long.toString(-1L));
                map.put(A0A(38, 9, 100), Long.toString(-1L));
                map.put(A0A(57, 7, 122), EnumC05740f.A03.name());
                super.A01.A9p(super.A02, map);
            }
        }
        C1056Ki.A02(super.A00, A0A(0, 12, 0));
    }

    public final boolean A0F(Uri uri) {
        try {
            String queryParameter = uri.getQueryParameter(A0A(71, 14, 39));
            if (TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            String universalLink = A0A(12, 26, 59);
            Intent launchIntent = new Intent(universalLink, C1050Kc.A00(queryParameter));
            launchIntent.addFlags(268435456);
            if (Build.VERSION.SDK_INT >= 30) {
                launchIntent.addFlags(1024);
            }
            boolean redirectedToApp = KN.A0B(super.A00, launchIntent);
            return redirectedToApp;
        } catch (KL unused) {
            return false;
        }
    }
}
