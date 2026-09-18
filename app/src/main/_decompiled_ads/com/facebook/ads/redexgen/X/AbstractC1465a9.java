package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.io.encoding.Base64;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1465a9 implements Ji {
    public static byte[] A0D;
    public static String[] A0E = {"4yJhIog9RzpC9w4XHjq79o6hmz2pMXrt", "bLneqHgNlbzxjE", "P7gevZ65hMGDm5VmgpkLcWEi46YxYduR", "Pajg2XTKXpS0pN0AoGLcPnQoa2IWF6Z7", "YyJRdl3XxpBTstTmsw", "OvgbPt0JG7dlaj99kqPbJKVmb9CPKTVr", "21VbiQWRKHmC0d4xB3zoTsbqXtN2ZOxw", "Q3Y9mBD7X4l0uaedlY7FP5X0xCsXbtIX"};
    public static final Handler A0F;
    public static final C05870t A0G = null;
    public static final C1032Jj A0H = null;
    public static final String A0I;
    public InterfaceC05820o A00;
    public InterfaceC05820o A01;
    public C8F A04;
    public C1030Jg A05;
    public AbstractC05830p A06;
    public final C06111r A07;
    public final InterfaceC1004If A08;
    public final C05870t A09;
    public final C1032Jj A0A;
    public final YA A0B;
    public volatile boolean A0C;
    public long A03 = -1;
    public String A02 = null;

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 8);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A0D = new byte[]{75, 110, 107, 122, 126, 111, 120, 42, 110, 101, 111, 121, 42, 100, 101, 126, 42, 111, 114, 99, 121, 126, 78, 107, 110, 127, 123, 106, 125, 47, 102, 124, 47, 97, 122, 99, 99, 47, 39, 108, 103, 110, 102, 97, 47, 97, 96, 123, 47, 99, 96, 110, 107, 106, 107, 38, 57, 28, 25, 8, 12, 29, 10, 88, 17, 11, 88, 22, 13, 20, 20, 88, 80, 27, 16, 25, 17, 22, 29, 28, 81, 45, 8, 13, 28, 24, 9, 30, 76, 5, 31, 76, 2, 25, 0, 0, 76, 68, 2, 3, 76, 15, 4, 13, 5, 2, 69, 78, 107, 110, 127, 123, 106, 125, 47, 102, 124, 47, 97, 122, 99, 99, 47, 96, 97, 47, 124, 123, 110, 125, 123, 78, 107, 5, 36, 107, 38, 36, 57, 46, 107, 42, 47, 107, 40, 42, 37, 47, 34, 47, 42, 63, 46, 56, 101, 122, 95, 66, 67, 74, 13, 76, 73, 76, 93, 89, 72, 95, 13, 89, 84, 93, 72, 3, 46, 43, 111, 46, 35, Base64.padSymbol, 42, 46, 43, 54, 111, 60, 59, 46, Base64.padSymbol, 59, 42, 43, 94, 91, 76, 52, 37, 60, 26, 17, 24, 16, 23, 38, 9, 24, 11, 24, 20, 10, 76, 91, 74, 79, 90, 79, 97, 76, 68, 75, 77, 90, 14, 71, 93, 14, SignedBytes.MAX_POWER_OF_TWO, 91, 66, 66, 38, 45, 32, 49, 58, 51, 55, 38, 39, 28, 42, 39, 122, 113, 105, 118, 109, 112, 113, 114, 122, 113, 107, 63, 118, 108, 63, 122, 114, 111, 107, 102, 38, 50, 37, 49, 53, 37, 46, 35, 57, 31, 35, 33, 48, 48, 41, 46, 39, 28, 27, 3, 20, 25, 28, 17, 85, 5, 25, 20, 22, 16, 24, 16, 27, 1, 85, 28, 27, 85, 7, 16, 6, 5, 26, 27, 6, 16, 10, 9, 7, 2, 57, 18, 15, 11, 3, 57, 11, 21, 44, 59, 47, 43, 59, 45, 42, 1, 55, 58};
    }

    public abstract void A0L();

    public abstract void A0N(InterfaceC05820o interfaceC05820o, C8F c8f, C8D c8d, C06121s c06121s);

    static {
        A07();
        LX.A02();
        A0I = AbstractC1465a9.class.getSimpleName();
        A0F = new Handler(Looper.getMainLooper());
    }

    public AbstractC1465a9(YA ya, C06111r c06111r) {
        this.A0B = ya;
        this.A07 = c06111r;
        C1032Jj c1032Jj = A0H;
        if (c1032Jj != null) {
            this.A0A = c1032Jj;
        } else {
            this.A0A = new C1032Jj(ya);
        }
        this.A0A.A0P(this);
        C05870t c05870t = A0G;
        if (c05870t != null) {
            this.A09 = c05870t;
        } else {
            this.A09 = new C05870t();
        }
        DynamicLoaderFactory.makeLoader(ya).getInitApi().onAdLoadInvoked(ya);
        this.A08 = ya.A09();
        ya.A0E().A4n();
    }

    private void A08(U6 u6) {
        C8F placement = u6.A00();
        if (placement == null || placement.A05() == null) {
            String strA06 = A06(279, 29, 125);
            JG error = new JG(AdErrorType.NO_AD_PLACEMENT, strA06);
            this.A0B.A0E().A4p(error.A03().getErrorCode(), strA06);
            AbstractC05830p abstractC05830p = this.A06;
            if (abstractC05830p != null) {
                abstractC05830p.A0G(error);
                return;
            }
            return;
        }
        this.A04 = placement;
        this.A00 = null;
        C8F c8f = this.A04;
        JSONObject jSONObjectA0A = c8f.A0A();
        String strA07 = A06(195, 3, 93);
        if (jSONObjectA0A == null) {
            C8D c8dA04 = c8f.A04();
            if (!A0C(c8f, c8dA04)) {
                return;
            }
            if (this.A00 == null) {
                this.A0B.A07().A9M(strA07, C07597x.A0a, new C07607y(A06(81, 26, 100), c8dA04.A02()));
                ABH(JG.A00(AdErrorType.INTERNAL_ERROR));
                return;
            }
            C06121s loadConfig = new C06121s(c8dA04.A04(), c8f.A05(), this.A07.A09, c8f.A05().A0C());
            A0N(this.A00, c8f, c8dA04, loadConfig);
        } else {
            ArrayList arrayList = new ArrayList();
            C8D c8dA05 = c8f.A04();
            do {
                if (arrayList.isEmpty()) {
                    if (A0C(c8f, c8dA05)) {
                        arrayList.add(c8dA05);
                    } else {
                        return;
                    }
                } else if (A0B(c8dA05)) {
                    arrayList.add(c8dA05);
                }
                c8dA05 = c8f.A04();
            } while (c8dA05 != null);
            if (this.A00 == null) {
                this.A0B.A07().A9M(strA07, C07597x.A0a, new C07607y(A06(56, 25, 112), ((C8D) arrayList.get(0)).A02()));
                ABH(JG.A00(AdErrorType.INTERNAL_ERROR));
                return;
            }
            boolean z = false;
            try {
                if (arrayList.size() > 1 && this.A00.AFs()) {
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(((C8D) it.next()).A04());
                    }
                    jSONObject.put(A06(192, 3, 55), jSONArray);
                    jSONObject.put(A06(198, 12, 113), c8f.A0A());
                    C06121s loadConfig2 = new C06121s(jSONObject, c8f.A05(), this.A07.A09, c8f.A05().A0C());
                    A0N(this.A00, c8f, c8dA05, loadConfig2);
                    z = true;
                }
            } catch (Exception unused) {
                z = false;
            }
            if (!z) {
                if (arrayList.isEmpty()) {
                    JG jgA01 = JG.A01(AdErrorType.NO_FILL, A06(0, 0, 73));
                    this.A0B.A0E().A4p(jgA01.A03().getErrorCode(), A06(133, 22, 67));
                    AbstractC05830p abstractC05830p2 = this.A06;
                    if (abstractC05830p2 != null) {
                        abstractC05830p2.A0G(jgA01);
                        return;
                    }
                    return;
                }
                InterfaceC05820o interfaceC05820o = this.A00;
                String[] strArr = A0E;
                if (strArr[4].length() == strArr[1].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0E;
                strArr2[0] = "F2ixlBYVHNYJB4bAHADqJrSynawwg1yM";
                strArr2[5] = "djkwyiiWLTaQwWMcVWQWfq0o8Ww2Jgo9";
                if (interfaceC05820o == null) {
                    this.A0B.A07().A9M(strA07, C07597x.A0a, new C07607y(A06(22, 34, 7), ((C8D) arrayList.get(0)).A02()));
                    ABH(JG.A00(AdErrorType.INTERNAL_ERROR));
                    return;
                }
                C8D c8d = (C8D) arrayList.get(0);
                A0N(this.A00, c8f, c8d, new C06121s(c8d.A04(), c8f.A05(), this.A07.A09, c8f.A05().A0C()));
            }
        }
        C06131t.A08(this.A0B.A01(), c8f);
    }

    private final void A09(String str, AdExperienceType adExperienceType) {
        this.A0B.A0E().A4q(str != null);
        this.A03 = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT < 17) {
            ABH(new JG(AdErrorType.API_NOT_SUPPORTED, A06(0, 0, 73)));
            return;
        }
        try {
            C1030Jg c1030JgA01 = this.A07.A01(this.A0B, new JQ(this.A0B, str, this.A07.A09, this.A07.A08), adExperienceType);
            this.A05 = c1030JgA01;
            if (A0E[6].charAt(21) == '6') {
                throw new RuntimeException();
            }
            String[] strArr = A0E;
            strArr[4] = "3q2wB1pMY3UXfOrLgu";
            strArr[1] = "CsXqAZILgfX2KA";
            this.A0A.A0O(c1030JgA01);
        } catch (JH e) {
            ABH(JG.A02(e));
        }
    }

    private void A0A(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.A02 = jSONObject.optString(A06(230, 12, 75));
            C05890v.A01(this.A0B).A0O(jSONObject);
        }
    }

    private boolean A0B(C8D c8d) {
        return (c8d == null || c8d.A04() == null) ? false : true;
    }

    private boolean A0C(C8F c8f, C8D c8d) {
        String strA06 = A06(0, 0, 73);
        if (c8d == null) {
            JG jgA01 = JG.A01(AdErrorType.NO_FILL, strA06);
            this.A0B.A0E().A4p(jgA01.A03().getErrorCode(), A06(133, 22, 67));
            AbstractC05830p abstractC05830p = this.A06;
            if (abstractC05830p != null) {
                abstractC05830p.A0G(jgA01);
            }
            return false;
        }
        String strA02 = c8d.A02();
        InterfaceC05820o interfaceC05820oA00 = this.A09.A00(this.A0B, c8f.A05().A0D());
        if (interfaceC05820oA00 == null) {
            this.A0B.A07().A9M(A06(195, 3, 93), C07597x.A0a, new C07607y(A06(0, 22, 2), strA02));
            ABH(JG.A00(AdErrorType.INTERNAL_ERROR));
            return false;
        }
        if (this.A07.A00() != interfaceC05820oA00.A7W()) {
            JG jgA02 = JG.A01(AdErrorType.INTERNAL_ERROR, strA06);
            this.A0B.A0E().A4p(jgA02.A03().getErrorCode(), A06(155, 19, 37));
            AbstractC05830p abstractC05830p2 = this.A06;
            if (abstractC05830p2 != null) {
                abstractC05830p2.A0G(jgA02);
            }
            return false;
        }
        this.A00 = interfaceC05820oA00;
        String[] strArr = A0E;
        if (strArr[4].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0E;
        strArr2[0] = "MKxF4EMWgzzLH5X7HNcHVA2i4zdAiZz9";
        strArr2[5] = "4tfdEW2uI31voJBW941pIR5b1aNGKiQe";
        JSONObject jSONObjectA04 = c8d.A04();
        if (jSONObjectA04 != null) {
            String strOptString = jSONObjectA04.optString(A06(320, 10, 86));
            this.A0B.A0E().AFS(strOptString);
            this.A0B.A0C(strOptString);
            Y9 y9A00 = C7R.A00();
            if (y9A00 != null) {
                y9A00.A0C(strOptString);
            }
            JSONObject dataObject = jSONObjectA04.optJSONObject(A06(262, 17, 72));
            A0A(dataObject);
            if (this.A05 == null) {
                String strA07 = A06(242, 20, 23);
                JG jgA03 = JG.A01(AdErrorType.UNKNOWN_ERROR, strA07);
                this.A0B.A0E().A4p(jgA03.A03().getErrorCode(), strA07);
                AbstractC05830p abstractC05830p3 = this.A06;
                if (abstractC05830p3 != null) {
                    abstractC05830p3.A0G(jgA03);
                }
                return false;
            }
            return true;
        }
        String strA08 = A06(212, 18, 38);
        JG jgA04 = JG.A01(AdErrorType.UNKNOWN_ERROR, strA08);
        this.A0B.A0E().A4p(jgA04.A03().getErrorCode(), strA08);
        AbstractC05830p abstractC05830p4 = this.A06;
        if (abstractC05830p4 != null) {
            abstractC05830p4.A0G(jgA04);
        }
        return false;
    }

    public final long A0D() {
        C8F c8f = this.A04;
        if (c8f != null) {
            return c8f.A03();
        }
        return -1L;
    }

    public final Handler A0E() {
        return A0F;
    }

    public C1C A0F() {
        return ((AbstractC1488aW) this.A01).A0H();
    }

    public final C8G A0G() {
        C8F c8f = this.A04;
        if (c8f == null) {
            return null;
        }
        return c8f.A05();
    }

    public final void A0H() {
        String strA6N;
        this.A0B.A0E().A2m(LM.A01(this.A03));
        InterfaceC05820o interfaceC05820o = this.A01;
        if (interfaceC05820o == null || (strA6N = interfaceC05820o.A6N()) == null) {
            return;
        }
        HashMap map = new HashMap();
        String strA04 = LM.A04(this.A03);
        String clientToken = A06(308, 12, 110);
        map.put(clientToken, strA04);
        new C1012In(strA6N, this.A08).A04(EnumC1011Im.A08, map);
    }

    public final void A0I() {
        InterfaceC05820o interfaceC05820o = this.A01;
        String strA06 = A06(195, 3, 93);
        if (interfaceC05820o == null) {
            String strA07 = A06(107, 26, 7);
            this.A0B.A07().A9M(strA06, C07597x.A0Q, new C07607y(strA07));
            AdErrorType adErrorType = AdErrorType.INTERNAL_ERROR;
            this.A0B.A0E().A4p(adErrorType.getErrorCode(), strA07);
            AbstractC05830p abstractC05830p = this.A06;
            if (abstractC05830p != null) {
                String errorMessage = adErrorType.getDefaultErrorMessage();
                abstractC05830p.A0G(JG.A01(adErrorType, errorMessage));
            }
            this.A0B.A0E().A4s();
            return;
        }
        if (this.A0C) {
            String strA08 = A06(174, 18, 71);
            this.A0B.A07().A9M(strA06, C07597x.A0M, new C07607y(strA08));
            AdErrorType adErrorType2 = AdErrorType.AD_ALREADY_STARTED;
            this.A0B.A0E().A4p(adErrorType2.getErrorCode(), strA08);
            AbstractC05830p abstractC05830p2 = this.A06;
            if (abstractC05830p2 != null) {
                String errorMessage2 = adErrorType2.getDefaultErrorMessage();
                abstractC05830p2.A0G(JG.A01(adErrorType2, errorMessage2));
            }
            this.A0B.A0E().A4r();
            return;
        }
        if (!TextUtils.isEmpty(this.A01.A6N())) {
            this.A08.A9h(this.A01.A6N());
        }
        this.A0B.A0E().A4t();
        this.A0C = true;
        A0L();
    }

    public final void A0J() {
        A0T(false);
    }

    public final void A0K() {
        if (this.A02 != null) {
            C05890v.A01(this.A0B).A0N(this.A02);
        }
    }

    public final void A0M(InterfaceC05820o interfaceC05820o) {
        if (interfaceC05820o != null) {
            interfaceC05820o.onDestroy();
        }
    }

    public final void A0O(AbstractC05830p abstractC05830p) {
        this.A06 = abstractC05830p;
    }

    public final void A0P(C06121s c06121s) {
        this.A0B.A0E().A4m();
        String clientToken = c06121s.A03().optString(A06(210, 2, 39));
        if (!TextUtils.isEmpty(clientToken)) {
            C1012In funnelLoggingHandler = new C1012In(clientToken, this.A08);
            funnelLoggingHandler.A04(EnumC1011Im.A04, null);
        }
    }

    public void A0Q(String str) {
        A09(str, null);
    }

    public final void A0R(String str) {
        A0Q(str);
    }

    public final void A0S(String str, AdExperienceType adExperienceType) {
        A09(str, adExperienceType);
    }

    public void A0T(boolean z) {
        if (!z && !this.A0C) {
            return;
        }
        this.A0B.A0E().A4u();
        A0M(this.A01);
        this.A0C = false;
    }

    public final boolean A0U() {
        C8F c8f = this.A04;
        return c8f == null || c8f.A0D();
    }

    @Override // com.facebook.ads.redexgen.X.Ji
    public final synchronized void ABH(JG jg) {
        A0E().post(new C1466aA(this, jg));
    }

    @Override // com.facebook.ads.redexgen.X.Ji
    public final synchronized void AD5(U6 u6) {
        try {
            A08(u6);
        } catch (Exception e) {
            this.A0B.A07().A9M(A06(195, 3, 93), C07597x.A0T, new C07607y(e));
        }
    }
}
