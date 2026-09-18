package com.facebook.ads.redexgen.X;

import android.os.Build;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.io.encoding.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Oh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1157Oh {
    public static byte[] A0K;
    public static final AtomicInteger A0L;
    public static final AtomicInteger A0M;
    public OW A02;
    public InterfaceC1155Of A03;
    public InterfaceC1156Og A04;
    public C1203Qb A05;
    public final int A08;
    public final AbstractC1484aS A09;
    public final C6Q A0A;
    public final YA A0B;
    public final InterfaceC1004If A0C;
    public final C1012In A0D;
    public final OU A0E;
    public final SW A0F;
    public final C1168Os A0G;
    public final C1169Ot A0H;
    public final String A0I;
    public final LinkedList<C1154Oe> A0J = new LinkedList<>();
    public LN A01 = new LN();
    public boolean A07 = true;
    public boolean A06 = false;
    public long A00 = -1;

    public static String A0A(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0K, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 2);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0D() {
        A0K = new byte[]{37, 63, 39, 56, 63, 39, 57, 13, 34, 40, 62, 35, 37, 40, 5, 34, 56, 41, 62, 42, 45, 47, 41, 5, 0, 54, 1, 20, 11, 22, 16, 13, 10, 3, 34, 13, 10, 13, 23, 12, 1, 0, 76, 67, 65, 23, 67, 77, 95, 96, 101, 83, 100, 113, 110, 115, 117, 104, 111, 102, 82, 117, 96, 115, 117, 100, 101, 41, 38, 36, 114, 38, 40, 58, 34, 55, 55, 34, 32, 43, 38, 39, 20, 21, 13, 54, 46, 10, 9, 28, 11, 0, 13, 12, 46, 26, 9, 5, 13, 44, 9, 28, 9, 84, 66, 69, 69, 82, 89, 67, 96, 97, 121, 66, 90, 48, 36, 55, 59, 51, 37, 120, 121, 86, 116, 99, 126, 97, 126, 99, 110, 71, 118, 98, 100, 114, 115, 63, 48, 50, 100, 48, 62, 44, 36, 37, 10, 40, 63, 34, Base64.padSymbol, 34, 63, 50, 25, 46, 56, 62, 38, 46, 47, 99, 108, 110, 56, 108, 98, 112, 83, 82, 127, 80, 83, 79, 89, 122, 73, 80, 80, 79, 95, 78, 89, 89, 82, 106, 85, 89, 75, 20, 27, 25, 79, 27, 21, 67, 66, 106, 89, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 95, 79, 94, 73, 73, 66, 122, 69, 73, 91, 4, 11, 9, 95, 11, 5, 72, 73, 113, 70, 75, 82, 66, 117, 66, 70, 67, 15, 0, 2, 84, 0, 11, 7, 0, 2, 84, 0, 11, 7, 0, 2, 84, 0, 14, 28, 120, 121, 65, 118, 123, 98, 114, SignedBytes.MAX_POWER_OF_TWO, 101, 126, 99, 99, 114, 121, 63, 48, 50, 100, 48, 59, 55, 48, 50, 100, 48, 62, 44, 106, 124, 122, 118, 119, 125, 70, 122, 113, 120, 119, 119, 124, 117, 20, 2, 19, 38, 18, 19, 15, 44, 2, 30, 79, SignedBytes.MAX_POWER_OF_TWO, 66, 20, SignedBytes.MAX_POWER_OF_TWO, 75, SignedBytes.MAX_POWER_OF_TWO, 66, 20, SignedBytes.MAX_POWER_OF_TWO, 78, 92, 77, 91, 74, 124, 95, 77, 91, 8, 10, 127, 77, 77, 91, 74, 77, 22, 25, 27, 77, 25, 18, 25, 27, 77, 25, 23, 2, 20, 5, 51, 16, 2, 20, 71, 69, 50, 30, 31, 23, 24, 22, 89, 86, 84, 2, 86, 93, 86, 84, 2, 86, 88, 57, 34, 57, 44, 33, 26, 27, 3, 56, 32, 38, 33, 63, 29, 2, 15, 14, 4, 46, 29, 14, 5, 31, 67, 76, 78, 24, 76, 71, 75, 76, 78, 24, 76, 71, 75, 76, 78, 24, 76, 66, 80, 14, 17, 29, 15, 42, 29, 25, 28, 1, 44, 23, 43, 16, 23, 15, 80, 95, 93, 11, 95, 81, 67};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 21 out of bounds for length 21
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final void A0i(Map<String, String> map) {
        String strA0A = A0A(87, 16, 106);
        if (map.containsKey(strA0A) && IP.A1Y(this.A0B)) {
            try {
                JSONArray jSONArray = new JSONArray(map.get(strA0A));
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONArray jSONArray2 = new JSONArray(jSONArray.getString(i));
                    String string = jSONArray2.getString(0);
                    String string2 = jSONArray2.getString(1);
                    String string3 = jSONArray2.getString(2);
                    String string4 = jSONArray2.getString(3);
                    if (string != null && string2 != null && string3 != null) {
                        C1249Rv c1249Rv = new C1249Rv(this.A09.A11(), Long.parseLong(string), Long.parseLong(string2), Long.parseLong(string3));
                        c1249Rv.A06(Long.parseLong(string4));
                        arrayList.add(c1249Rv);
                    }
                }
                String strA04 = C1248Ru.A04(arrayList);
                HashMap map2 = new HashMap();
                map2.put(A0A(115, 6, 84), strA04);
                if (strA04 != null) {
                    this.A0C.A9f(this.A09.A11(), map2);
                }
            } catch (Exception e) {
                this.A0B.A07().A9M(A0A(274, 14, 27), 3600, new C07607y(e));
            }
        }
        if (map.containsKey(strA0A)) {
            map.remove(strA0A);
        }
        this.A0C.A9L(this.A09.A11(), new NL(map).A03(this.A05).A05());
    }

    static {
        A0D();
        A0M = new AtomicInteger();
        A0L = new AtomicInteger();
    }

    public C1157Oh(YA ya, AbstractC1484aS abstractC1484aS, InterfaceC1004If interfaceC1004If, int i) {
        this.A0B = ya;
        this.A0C = interfaceC1004If;
        this.A09 = abstractC1484aS;
        this.A08 = i;
        this.A0F = new SW(this, ya);
        C6Q c6q = new C6Q(ya);
        this.A0A = c6q;
        C1012In c1012In = new C1012In(abstractC1484aS.A11(), interfaceC1004If);
        this.A0D = c1012In;
        OU ou = new OU(abstractC1484aS.A0R(), abstractC1484aS.A0v().A0D().A08(), i);
        this.A0E = ou;
        String string = UUID.randomUUID().toString();
        this.A0I = string;
        this.A0H = C1170Ou.A00(ya, abstractC1484aS.A0U(), c6q, c1012In, ou, A0H());
        this.A0G = new C1168Os(ya, this, interfaceC1004If, ou, string, abstractC1484aS.A11());
    }

    public static AtomicInteger A0B() {
        return A0L;
    }

    private void A0C() {
        A0F(new C1154Oe(A0A(288, 22, 101), new String[]{this.A0I, A0A(1, 6, 11)}));
        String assets = android.util.Base64.encodeToString(this.A0H.A05.toString().getBytes(), 0).replace(A0A(0, 1, 45), A0A(0, 0, 109));
        String assets2 = this.A0I;
        A0F(new C1154Oe(A0A(310, 26, 60), new String[]{assets, assets2}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A0E() {
        if (this.A06) {
            while (!this.A0J.isEmpty()) {
                C1154Oe c1154OePoll = this.A0J.poll();
                if (c1154OePoll != null) {
                    this.A0F.A05(String.format(Locale.US, c1154OePoll.A00, c1154OePoll.A02));
                    if (c1154OePoll.A01) {
                        this.A0D.A04(EnumC1011Im.A0L, null);
                        this.A0B.A0E().A5B(c1154OePoll.A00);
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    private synchronized void A0F(C1154Oe c1154Oe) {
        this.A0J.offer(c1154Oe);
        A0E();
    }

    private boolean A0H() {
        return !A0I();
    }

    private boolean A0I() {
        return IP.A2N(this.A0B, QJ.A03());
    }

    public final C1012In A0K() {
        return this.A0D;
    }

    public final LN A0L() {
        return this.A01;
    }

    public final OU A0M() {
        return this.A0E;
    }

    public final OW A0N() {
        return this.A02;
    }

    public final SW A0O() {
        return this.A0F;
    }

    public final void A0P() {
        A0F(new C1154Oe(A0A(23, 26, 102), new String[]{this.A0I}));
    }

    public final void A0Q() {
        A0F(new C1154Oe(A0A(49, 25, 3), new String[]{this.A0I}));
    }

    public final void A0R() {
        this.A07 = true;
    }

    public final void A0S() {
        this.A07 = false;
    }

    public final void A0T() {
        A0F(new C1154Oe(A0A(121, 23, 21), new String[]{this.A0I}));
    }

    public final void A0U() {
        A0F(new C1154Oe(A0A(168, 27, 62), new String[]{this.A0I}));
    }

    public final void A0V() {
        A0F(new C1154Oe(A0A(195, 22, 46), new String[]{this.A0I}));
    }

    public final void A0W() {
        A0F(new C1154Oe(A0A(TTAdConstant.DEEPLINK_FALLBACK_CODE, 22, 122), new String[]{this.A0I}));
    }

    public final void A0X() {
        String str;
        if (Build.VERSION.SDK_INT > 16) {
            this.A0F.addJavascriptInterface(this.A0G, A0A(7, 16, 78));
        }
        this.A0D.A04(EnumC1011Im.A0O, null);
        if (this.A08 == 3) {
            str = this.A0H.A00;
        } else {
            str = this.A0H.A01;
        }
        this.A0F.loadUrl(str);
        this.A00 = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            String url = A0A(372, 3, 81);
            jSONObject.put(url, str);
            jSONObject.put(A0A(103, 12, 53), C1158Oi.A00());
            jSONObject.put(A0A(362, 10, 79), A0M.getAndIncrement());
            jSONObject.put(A0A(74, 13, 65), A0L);
        } catch (JSONException unused) {
        }
        this.A0B.A0E().A5H(jSONObject.toString());
        A0C();
    }

    public final void A0Y() {
        A0F(new C1154Oe(A0A(144, 24, 73), new String[]{this.A0I}));
    }

    public final void A0Z(LN ln) {
        this.A01 = ln;
    }

    public final void A0a(OW ow) {
        this.A02 = ow;
    }

    public final void A0b(InterfaceC1155Of interfaceC1155Of) {
        this.A03 = interfaceC1155Of;
    }

    public final void A0c(InterfaceC1156Og interfaceC1156Og) {
        this.A04 = interfaceC1156Og;
    }

    public final void A0d(SV sv) {
        this.A0G.A0N(sv);
    }

    public final void A0e(C1203Qb c1203Qb) {
        this.A05 = c1203Qb;
    }

    public final void A0f(String str) {
        A0F(new C1154Oe(A0A(247, 27, 21), new String[]{this.A0I, str}));
    }

    public final void A0g(String str, String str2) {
        A0F(new C1154Oe(A0A(217, 30, 37), new String[]{this.A0I, str, str2}));
    }

    public final void A0h(String str, JSONObject jSONObject) {
        A0F(new C1154Oe(A0A(375, 29, 105), new String[]{this.A0I, str, jSONObject.toString()}, false));
    }

    public final void A0j(JSONObject jSONObject) {
        String strReplace = android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 0).replace(A0A(0, 1, 45), A0A(0, 0, 109));
        String assets = this.A0I;
        A0F(new C1154Oe(A0A(336, 26, 115), new String[]{strReplace, assets}));
    }

    public final boolean A0k() {
        return this.A0G.A0O();
    }

    public final boolean A0l() {
        return this.A07;
    }
}
