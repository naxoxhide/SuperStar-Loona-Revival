package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1f, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05991f {
    public static byte[] A05;
    public static String[] A06 = {"jJreqFAWfQsm2UlBXjWleQZy51A8w9r3", "B5vxrqY9e1pfFDILbPSJEQZe5Zep9JAF", "7hwRhDIA2xM98ucsNVPICP0872", "8yYdfjKxcW1uK5E8nS4F9bT", "cwoTvwLLOWGZrFwonmn2qn9xu", "wuc4L", "VoE60CbUCih", "1JGxuEjawtyxaKItdz1AQ1lnM"};
    public C6Q A00;
    public NP A01 = NP.A06;
    public ArrayList<C1157Oh> A02 = new ArrayList<>();
    public final C1C A03;
    public final InterfaceC05981e A04;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 96);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A05 = new byte[]{-97, -39, -27, -34, -35, -81, -44, -38, -53, -40, -44, -57, -46, -122, -85, -40, -40, -43, -40, -122, -104, -106, -106, -100, -122, -35, -49, -38, -50, -43, -37, -38, -122, -57, -122, -36, -57, -46, -49, -54, -122, -89, -54, -81, -44, -52, -43, -108, 31, 34, 29, 34, 31, 50, 31, 29, 32, 51, 44, 34, 42, 35, -45, -30, -37, -59, -54, -61, -53, -48, -63, -46, -61, -44, -61, -49, -43, -42, -37, -44, -36, -31, -40, -41, -76, -41, -73, -44, -25, -44, -75, -24, -31, -41, -33, -40, -38, -33, -27, -42, -29, -28, -27, -38, -27, -38, -46, -35};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 11 out of bounds for length 11
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final void A0J(YA ya, EnumSet<CacheFlag> enumSet) {
        if (A0E() == EnumC1039Jq.A03) {
            C1482aQ c1482aQ = (C1482aQ) this.A03;
            AbstractC1484aS abstractC1484aSA0s = c1482aQ.A0s();
            if (A0C(ya, abstractC1484aSA0s) || abstractC1484aSA0s == null) {
                return;
            }
            this.A04.AEL();
            A0A(ya, enumSet, c1482aQ, abstractC1484aSA0s, 0, this.A04);
            return;
        }
        if (A0C(ya, (AbstractC1484aS) this.A03)) {
            return;
        }
        this.A04.AEL();
        if (A0E() == EnumC1039Jq.A0B) {
            A08(ya, (F0) this.A03);
        } else {
            A09(ya, enumSet, (F0) this.A03, -1, this.A04);
        }
    }

    static {
        A06();
    }

    public C05991f(YA ya, C06121s c06121s, InterfaceC05981e interfaceC05981e, String str) {
        JSONObject dataObject = c06121s.A03();
        this.A03 = A01(ya, c06121s, str, dataObject);
        this.A04 = interfaceC05981e;
    }

    private AdError A00(YA ya, AbstractC1484aS abstractC1484aS) {
        if (abstractC1484aS == null || abstractC1484aS.A13().isEmpty()) {
            ya.A07().A9M(A04(62, 3, 18), C07597x.A0Z, new C07607y(A04(5, 43, 6)));
            return AdError.internalError(AdError.INTERNAL_ERROR_2006);
        }
        return null;
    }

    public static C1C A01(YA ya, C06121s c06121s, String str, JSONObject jSONObject) {
        C1C c1cA02 = null;
        if (jSONObject.has(A04(65, 12, 2))) {
            try {
                c1cA02 = C1482aQ.A03(jSONObject, ya, true);
                c1cA02.A0c(true);
                c1cA02.A0Z(A04(96, 12, 17));
            } catch (JSONException unused) {
            }
        }
        if (c1cA02 == null) {
            c1cA02 = F0.A02(jSONObject, ya);
        }
        c1cA02.A0Y(str);
        C8G c8gA01 = c06121s.A01();
        if (c8gA01 != null) {
            c1cA02.A0V(c8gA01.A06());
        }
        return c1cA02;
    }

    private C6Q A03(YA ya) {
        C6Q c6q = this.A00;
        return c6q != null ? c6q : new C6Q(ya);
    }

    private void A08(YA ya, F0 f0) {
        C1Z playableData = f0.A0v().A0D().A06();
        A0B(playableData != null ? playableData.A0A() : NP.A06);
        C1473aH c1473aH = new C1473aH(this);
        C6Q c6q = new C6Q(ya);
        boolean z = IP.A1j(ya) && C07115q.A0A(f0.A0U());
        if (z) {
            C07115q unifiedAssetsLoader = new C07115q(c6q, f0.A0U(), f0.A0O(), f0.A0R(), z, new C1472aG(this));
            c6q.A0d(new C1012In(f0.A11(), ya.A09()));
            unifiedAssetsLoader.A0B();
            return;
        }
        C06091p.A02(ya, f0, true, c1473aH);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0094  */
    private void A09(YA ya, EnumSet<CacheFlag> enumSet, AbstractC1484aS abstractC1484aS, int i, InterfaceC05981e interfaceC05981e) {
        Iterator<String> it;
        boolean zA0k = abstractC1484aS.A0k();
        C6Q c6qA03 = A03(ya);
        c6qA03.A0d(new C1012In(abstractC1484aS.A11(), ya.A09()));
        boolean z = IP.A1j(ya) && C07115q.A0A(abstractC1484aS.A0U());
        if (A06[3].length() == 32) {
            throw new RuntimeException();
        }
        A06[5] = "QkQhg";
        if (z) {
            new C07115q(c6qA03, abstractC1484aS.A0U(), abstractC1484aS.A0O(), abstractC1484aS.A0R(), z, new C1476aK(this, ya, zA0k, abstractC1484aS, interfaceC05981e)).A0B();
            return;
        }
        String strA04 = A04(96, 12, 17);
        String[] strArr = A06;
        if (strArr[1].charAt(24) != strArr[0].charAt(24)) {
            String[] strArr2 = A06;
            strArr2[1] = "jVhVjw8PHVLop7GyU0UYPYiA56KfUjA6";
            strArr2[0] = "lzrrt2iICm45JkiVqVLOf6p257fg56KP";
            if (zA0k) {
                C6M c6m = new C6M(abstractC1484aS.A0L(), abstractC1484aS.A0R(), strA04);
                c6m.A04 = true;
                c6m.A03 = A04(0, 5, 17);
                c6qA03.A0X(c6m);
            }
        } else {
            String[] strArr3 = A06;
            strArr3[7] = "mMtIDEEqjJJ695eeXDndb9bWh";
            strArr3[4] = "Ebj8lqyUqzLrB8iZ5jF9tO70n";
            if (zA0k) {
                C6M c6m2 = new C6M(abstractC1484aS.A0L(), abstractC1484aS.A0R(), strA04);
                c6m2.A04 = true;
                c6m2.A03 = A04(0, 5, 17);
                c6qA03.A0X(c6m2);
            }
        }
        c6qA03.A0c(new C6O(abstractC1484aS.A0z().A01(), PB.A04, PB.A04, abstractC1484aS.A0R(), A04(96, 12, 17)));
        boolean zContains = enumSet.contains(CacheFlag.VIDEO);
        int i2 = 0;
        boolean zA2N = IP.A2N(ya, QJ.A03());
        for (C1D adInfo : abstractC1484aS.A13()) {
            C6O c6o = new C6O(adInfo.A0D().A07(), C06051l.A00(adInfo.A0D()), C06051l.A01(adInfo.A0D()), abstractC1484aS.A0R(), A04(96, 12, 17));
            if (i2 == 0) {
                c6qA03.A0b(c6o);
            } else {
                c6qA03.A0c(c6o);
            }
            List<String> listA01 = adInfo.A0G().A01();
            String[] strArr4 = A06;
            if (strArr4[6].length() != strArr4[2].length()) {
                String[] strArr5 = A06;
                strArr5[1] = "D8Za7DAeUKhUMlH0nChh1nyf5MUepOev";
                strArr5[0] = "YMJugZMvnGL61TcEtQKO8oN05ixDNSHw";
                it = listA01.iterator();
            } else {
                it = listA01.iterator();
            }
            while (it.hasNext()) {
                c6qA03.A0c(new C6O(it.next(), -1, -1, abstractC1484aS.A0R(), A04(96, 12, 17)));
            }
            if (zContains && !TextUtils.isEmpty(adInfo.A0D().A08())) {
                C6M c6m3 = new C6M(adInfo.A0D().A08(), abstractC1484aS.A0R(), A04(96, 12, 17), adInfo.A0D().A05());
                c6m3.A04 = false;
                if (i2 == 0) {
                    if (zA0k && !zA2N) {
                        c6qA03.A0X(c6m3);
                    } else {
                        c6qA03.A0a(c6m3);
                    }
                } else if (zA0k && !zA2N) {
                    c6qA03.A0Y(c6m3);
                } else {
                    c6qA03.A0Z(c6m3);
                }
            }
            i2++;
        }
        c6qA03.A0W(new C1474aI(this, ya, zA0k, abstractC1484aS, interfaceC05981e), new C6J(abstractC1484aS.A0R(), strA04, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A(YA ya, EnumSet<CacheFlag> enumSet, C1482aQ c1482aQ, AbstractC1484aS abstractC1484aS, int i, InterfaceC05981e interfaceC05981e) {
        A09(ya, enumSet, abstractC1484aS, i, new C1478aM(this, ya, abstractC1484aS, c1482aQ, i, interfaceC05981e, enumSet));
    }

    private void A0B(NP np) {
        this.A01 = np;
    }

    private boolean A0C(YA ya, AbstractC1484aS abstractC1484aS) {
        AdError adErrorA00 = A00(ya, abstractC1484aS);
        if (adErrorA00 != null) {
            InterfaceC05981e interfaceC05981e = this.A04;
            String[] strArr = A06;
            if (strArr[1].charAt(24) != strArr[0].charAt(24)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[1] = "Dm6wm58uJ8qXwjtNx8Vtzbsb5Jkw9mit";
            strArr2[0] = "fLwuuFNg4tiwPdo6hP9t6x3v5l5Hcavg";
            interfaceC05981e.AAP(adErrorA00);
            return true;
        }
        return false;
    }

    public final C1C A0D() {
        return this.A03;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ab, code lost:
    
        if (r3 != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00af, code lost:
    
        return com.facebook.ads.redexgen.X.EnumC1039Jq.A0C;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b7, code lost:
    
        if (r3 != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bc, code lost:
    
        return com.facebook.ads.redexgen.X.EnumC1039Jq.A0A;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.EnumC1039Jq A0E() {
        /*
            r4 = this;
            com.facebook.ads.redexgen.X.1C r0 = r4.A03
            boolean r0 = r0.A0h()
            if (r0 == 0) goto Lb
            com.facebook.ads.redexgen.X.Jq r0 = com.facebook.ads.redexgen.X.EnumC1039Jq.A03
            return r0
        Lb:
            com.facebook.ads.redexgen.X.1C r3 = r4.A03
            com.facebook.ads.redexgen.X.aS r3 = (com.facebook.ads.redexgen.X.AbstractC1484aS) r3
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C05991f.A06
            r0 = 6
            r1 = r2[r0]
            r0 = 2
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L50
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C05991f.A06
            java.lang.String r1 = "f4kXngrP8CD5dz"
            r0 = 3
            r2[r0] = r1
            boolean r0 = r3.A0k()
            if (r0 == 0) goto L31
            com.facebook.ads.redexgen.X.Jq r0 = com.facebook.ads.redexgen.X.EnumC1039Jq.A05
            return r0
        L31:
            java.util.List r0 = r3.A13()
            int r1 = r0.size()
            r0 = 1
            if (r1 <= r0) goto L5e
            com.facebook.ads.redexgen.X.Jq r3 = com.facebook.ads.redexgen.X.EnumC1039Jq.A09
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C05991f.A06
            r0 = 7
            r1 = r2[r0]
            r0 = 4
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L56
        L50:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L56:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C05991f.A06
            java.lang.String r1 = "ny"
            r0 = 3
            r2[r0] = r1
            return r3
        L5e:
            com.facebook.ads.redexgen.X.1D r0 = r3.A0v()
            com.facebook.ads.redexgen.X.1G r0 = r0.A0D()
            com.facebook.ads.redexgen.X.1Z r0 = r0.A06()
            if (r0 == 0) goto L8e
            com.facebook.ads.redexgen.X.Jq r3 = com.facebook.ads.redexgen.X.EnumC1039Jq.A0B
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C05991f.A06
            r0 = 6
            r1 = r2[r0]
            r0 = 2
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L88
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C05991f.A06
            java.lang.String r1 = "JH"
            r0 = 3
            r2[r0] = r1
            return r3
        L88:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L8e:
            boolean r3 = r4.A0L(r3)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C05991f.A06
            r0 = 3
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 32
            if (r1 == r0) goto Lb0
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C05991f.A06
            java.lang.String r1 = "93R6MUXHMTxUt8WfLt1oZ3ea5zubl3sl"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "9xXPI1nVQC4CSUB4soKlPH985bh9DAt9"
            r0 = 0
            r2[r0] = r1
            if (r3 == 0) goto Lba
        Lad:
            com.facebook.ads.redexgen.X.Jq r0 = com.facebook.ads.redexgen.X.EnumC1039Jq.A0C
            return r0
        Lb0:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C05991f.A06
            java.lang.String r1 = "ySAy4b6nQ"
            r0 = 3
            r2[r0] = r1
            if (r3 == 0) goto Lba
            goto Lad
        Lba:
            com.facebook.ads.redexgen.X.Jq r0 = com.facebook.ads.redexgen.X.EnumC1039Jq.A0A
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C05991f.A0E():com.facebook.ads.redexgen.X.Jq");
    }

    public final NP A0F() {
        return this.A01;
    }

    public final String A0G() {
        if (this.A03.A0h()) {
            return ((C1482aQ) this.A03).A0v();
        }
        return ((AbstractC1484aS) this.A03).A11();
    }

    public final void A0H() {
        this.A04.AG1();
    }

    public final void A0I(Intent intent, RewardData rewardData, String str) {
        this.A03.A0X(rewardData);
        this.A03.A0a(str);
        if (A0D().A0h()) {
            intent.putExtra(A04(77, 19, 19), this.A03);
        }
        intent.putExtra(A04(48, 14, 94), this.A03);
    }

    public final boolean A0K() {
        return this.A03.A0e();
    }

    public final boolean A0L(AbstractC1484aS abstractC1484aS) {
        return !TextUtils.isEmpty(abstractC1484aS.A0v().A0D().A08());
    }
}
