package com.facebook.ads.redexgen.X;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FI extends AbstractC1514aw {
    public static byte[] A03;
    public static String[] A04 = {"eZwrQOnpnpQE2xbRo0zNjy7tlobdqdqH", "SFt7WwZUn", "NjRPf9lXQVcUlHZaPZ2tHyzwDKEOZm5m", "vsw9aGbGyLBdbL44W3z8tEYPUFR7w9", "bZApvv", "GYK1wV", "jBSwIULngy0dc0IzE6SbgF9ev3BAFzHy", "9HFC3JFq8"};
    public static final String A05;
    public final Uri A00;
    public final C1R A01;
    public final Map<String, String> A02;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = (bArrCopyOfRange[i4] - i3) - 27;
            String[] strArr = A04;
            if (strArr[6].charAt(23) == strArr[0].charAt(23)) {
                throw new RuntimeException();
            }
            A04[3] = "uqLwDcTKX4SWJds2FMBMp5QNw2MnWtU";
            bArrCopyOfRange[i4] = (byte) i5;
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private final List<Intent> A05() {
        List<C05800l> listA04 = A04();
        ArrayList arrayList = new ArrayList();
        if (listA04 != null) {
            Iterator<C05800l> it = listA04.iterator();
            while (it.hasNext()) {
                Intent intentA00 = A00(it.next());
                if (intentA00 != null) {
                    arrayList.add(intentA00);
                }
            }
        }
        return arrayList;
    }

    public static void A06() {
        A03 = new byte[]{106, -105, -105, -108, -105, 69, -107, -122, -105, -104, -114, -109, -116, 69, -122, -107, -107, -104, -114, -103, -118, -124, -119, -122, -103, -122, -124, -97, -89, -86, -93, -94, 94, -78, -83, 94, -83, -82, -93, -84, 94, -85, -97, -80, -87, -93, -78, 94, -77, -80, -86, 120, 94, -29, -27, -5, 8, -2, 12, 9, 3, -2, -108, -95, -105, -91, -94, -100, -105, 97, -100, -95, -89, -104, -95, -89, 97, -108, -106, -89, -100, -94, -95, 97, 119, 124, 116, 127, -94, -81, -91, -77, -80, -86, -91, 111, -86, -81, -75, -90, -81, -75, 111, -94, -92, -75, -86, -80, -81, 111, -105, -118, -122, -104, -8, 7, 7, 10, 0, 11, -4, -10, -5, -8, 11, -8, -3, -15, 2, -5, -11, 4, -54, -65, -65, -12, -11, 4, -15, -7, -4, 3, -49, -7, -12, -51, -75, 3, -26, -25, -36, -27, -36, -37, -42, -37, -36, -36, -25, -29, -32, -27, -30, -108, -107, -118, -109, -118, -119, -124, -104, -103, -108, -105, -118, -124, -117, -122, -111, -111, -121, -122, -120, -112, -124, -102, -105, -111, -38, -37, -48, -39, -48, -49, -54, -34, -33, -38, -35, -48, -54, -32, -35, -41, -70, -85, -68, -67, -77, -72, -79, -51, -50, -55, -52, -65, -71, -61, -66, -10, -9, -14, -11, -24, -30, -8, -11, -17, -96, -95, -100, -97, -110, -116, -94, -97, -103, -116, -92, -110, -113, -116, -109, -114, -103, -103, -113, -114, -112, -104, -90, -105, -98, 108, -72, -87, -80, -76, -74, -77, -79, -76, -72, 126};
    }

    static {
        A06();
        A05 = FI.class.getSimpleName();
    }

    public FI(YA ya, InterfaceC1004If interfaceC1004If, String str, Uri uri, Map<String, String> extraData, C05810n c05810n, boolean z, C1R c1r) {
        super(ya, interfaceC1004If, str, c05810n, z);
        this.A00 = uri;
        this.A02 = extraData;
        this.A01 = c1r;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
    
        if (r3.startsWith(r0) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.content.Intent A00(com.facebook.ads.redexgen.X.C05800l r10) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FI.A00(com.facebook.ads.redexgen.X.0l):android.content.Intent");
    }

    private Intent A01(C05800l c05800l) {
        Intent intent = new Intent(A03(88, 26, 38));
        intent.addFlags(268435456);
        if (!TextUtils.isEmpty(c05800l.A05()) && !TextUtils.isEmpty(c05800l.A04())) {
            intent.setComponent(new ComponentName(c05800l.A05(), c05800l.A04()));
        }
        if (!TextUtils.isEmpty(c05800l.A03())) {
            intent.setData(C1050Kc.A00(c05800l.A03()));
        }
        return intent;
    }

    private final Uri A02() {
        String queryParameter = this.A00.getQueryParameter(A03(219, 9, 104));
        if (!TextUtils.isEmpty(queryParameter)) {
            return C1050Kc.A00(queryParameter);
        }
        Uri uri = this.A00;
        String storeUrl = A03(211, 8, 63);
        String storeId = uri.getQueryParameter(storeUrl);
        Locale locale = Locale.US;
        Object[] objArr = {storeId};
        String storeUrl2 = A03(126, 22, 117);
        return C1050Kc.A00(String.format(locale, storeUrl2, objArr));
    }

    private List<C05800l> A04() {
        String queryParameter = this.A00.getQueryParameter(A03(114, 12, 124));
        if (TextUtils.isEmpty(queryParameter)) {
            return null;
        }
        String appsiteDataString = A03(53, 2, 109);
        if (appsiteDataString.equals(queryParameter)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(queryParameter);
            String appsiteDataString2 = A03(55, 7, WorkQueueKt.MASK);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(appsiteDataString2);
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    C05800l c05800lA00 = C05800l.A00(jSONArrayOptJSONArray.optJSONObject(i));
                    if (c05800lA00 != null) {
                        arrayList.add(c05800lA00);
                    }
                }
            }
        } catch (JSONException e) {
            InterfaceC07587w interfaceC07587wA07 = ((AbstractC05750g) this).A00.A07();
            int i2 = C07597x.A23;
            C07607y c07607y = new C07607y(e);
            String appsiteDataString3 = A03(204, 7, 47);
            interfaceC07587wA07.A9M(appsiteDataString3, i2, c07607y);
            String str = A05;
            String appsiteDataString4 = A03(0, 26, 10);
            Log.w(str, appsiteDataString4, e);
        }
        return arrayList;
    }

    private boolean A07() {
        List<Intent> appLaunchIntents = A05();
        if (appLaunchIntents == null) {
            return false;
        }
        Iterator<Intent> it = appLaunchIntents.iterator();
        while (it.hasNext()) {
            try {
                if (KN.A0B(((AbstractC05750g) this).A00, it.next())) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean A08() throws KL {
        KZ kz = new KZ();
        try {
            KZ.A0C(kz, ((AbstractC05750g) this).A00, A02(), ((AbstractC05750g) this).A02);
            return true;
        } catch (Exception unused) {
            String str = A03(26, 27, 35) + this.A00.toString();
            String queryParameter = this.A00.getQueryParameter(A03(228, 22, 18));
            if (queryParameter != null && queryParameter.length() > 0) {
                KZ.A0C(kz, ((AbstractC05750g) this).A00, C1050Kc.A00(queryParameter), ((AbstractC05750g) this).A02);
                return false;
            }
            return false;
        }
    }

    public static boolean A09(YA ya, String str) {
        if (Build.VERSION.SDK_INT >= 30 && str != null) {
            boolean zA1f = IP.A1f(ya);
            if (A04[3].length() == 13) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[7] = "1LqNNd92i";
            strArr[1] = "QkgxMECyk";
            if (zA1f) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC05750g
    public final EnumC05740f A0A() {
        EnumC05740f enumC05740f = null;
        String strA03 = A03(148, 15, 92);
        boolean zA0F = A0F(this.A00);
        if (!zA0F) {
            zA0F = A07();
        }
        if (!zA0F) {
            try {
                strA03 = A08() ? A03(188, 16, 80) : A03(163, 25, 10);
            } catch (Exception unused) {
                enumC05740f = EnumC05740f.A02;
            }
        }
        this.A02.put(strA03, String.valueOf(true));
        return enumC05740f;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1514aw
    public final void A0D() {
        EnumC05740f enumC05740fA0A = null;
        if (((AbstractC1514aw) this).A02) {
            enumC05740fA0A = A0A();
        } else {
            this.A02.put(A03(188, 16, 80), String.valueOf(true));
        }
        Map<String, String> map = this.A02;
        if (A04[3].length() == 13) {
            throw new RuntimeException();
        }
        A04[2] = "sgzsFq3t5RzUzGxHOqvhuB7Tq08HlvIk";
        A0E(map, enumC05740fA0A);
        C1R.A06(this.A01, ((AbstractC05750g) this).A00);
    }
}
