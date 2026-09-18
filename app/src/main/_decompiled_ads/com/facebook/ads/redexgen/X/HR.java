package com.facebook.ads.redexgen.X;

import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.Log;
import com.google.common.primitives.SignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class HR implements InterfaceC1209Qh {
    public static byte[] A07;
    public static String[] A08 = {"Z3ZBH3trhaxMswGoeO0i3WMhBsCqcWgs", "P814sFImmOC", "INcscN3Z5kcfIuBeknVxelrdNm8ANoXs", "RvJjsajerkLdUat3TDI8NPR3DDSWtO", "ZLSXhw", "wxtWSqUF9a7Aw2d1StIocmcoa4QX", "58xAXbC3p", "Zj1UZNXOzFX"};
    public static final String A09;
    public InterfaceC07587w A00;
    public Executor A01;
    public boolean A02;
    public C1214Qm A03;
    public final InterfaceC1219Qr A04 = new C0986Hn();
    public final InterfaceC1224Qw A05;
    public final InterfaceC1225Qx A06;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 11
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private final InterfaceC1208Qg A01(AbstractC1221Qt abstractC1221Qt) throws C1222Qu {
        C1222Qu c1222Qu;
        String strA07 = A07(220, 7, 7);
        HttpURLConnection httpURLConnection = null;
        HT htA05 = null;
        boolean z = false;
        try {
            try {
                this.A02 = false;
                HttpURLConnection httpURLConnectionA08 = A08(abstractC1221Qt.A05(), C1052Ke.A04() ? A09() : null);
                A0H(httpURLConnectionA08, abstractC1221Qt);
                A0G(httpURLConnectionA08, abstractC1221Qt);
                if (this.A06.A8x()) {
                    this.A06.A9c(httpURLConnectionA08, abstractC1221Qt.A06());
                }
                httpURLConnectionA08.connect();
                this.A02 = true;
                Set<String> setA01 = this.A03.A01();
                Set<String> setA02 = this.A03.A02();
                boolean z2 = (setA01 == null || setA01.isEmpty()) ? false : true;
                if (setA02 != null && !setA02.isEmpty()) {
                    z = true;
                }
                if ((httpURLConnectionA08 instanceof HttpsURLConnection) && (z2 || z)) {
                    try {
                        C1226Qy.A03((HttpsURLConnection) httpURLConnectionA08, setA01, setA02);
                    } catch (CertificateException e) {
                        this.A00.A9g(strA07, C07597x.A1y, new C07607y(e));
                    } catch (Exception e2) {
                        this.A00.A9g(strA07, C07597x.A1x, new C07607y(e2));
                    }
                }
                if (httpURLConnectionA08.getDoOutput() && abstractC1221Qt.A06() != null) {
                    A00(httpURLConnectionA08, abstractC1221Qt.A06());
                }
                HT htA06 = httpURLConnectionA08.getDoInput() ? A06(httpURLConnectionA08) : new HT(httpURLConnectionA08, null);
                if (this.A06.A8x()) {
                    this.A06.A9d(htA06);
                }
                if (httpURLConnectionA08 != null) {
                    httpURLConnectionA08.disconnect();
                }
                return htA06;
            } catch (Exception e3) {
                try {
                    try {
                        htA05 = A05(null);
                        if (htA05 == null || htA05.A7v() <= 0) {
                            c1222Qu = new C1222Qu(e3, htA05);
                            throw c1222Qu;
                        }
                        if (this.A06.A8x()) {
                            this.A06.A9d(htA05);
                        }
                        if (0 != 0) {
                            httpURLConnection.disconnect();
                        }
                        return htA05;
                    } catch (Exception unused) {
                        Log.e(getClass().getSimpleName(), A07(117, 13, 53), e3);
                        if (htA05 != null && htA05.A7v() > 0) {
                            if (this.A06.A8x()) {
                                InterfaceC1225Qx interfaceC1225Qx = this.A06;
                                String[] strArr = A08;
                                if (strArr[0].charAt(28) == strArr[2].charAt(28)) {
                                    throw new RuntimeException();
                                }
                                String[] strArr2 = A08;
                                strArr2[0] = "IlkFDbfWlXmKaUvETbHYmdNk6OEHYi1H";
                                strArr2[2] = "BN3YcSqfdOqAJI6hng3gZMbRThXyngdJ";
                                interfaceC1225Qx.A9d(htA05);
                            }
                            if (0 != 0) {
                                httpURLConnection.disconnect();
                            }
                            return htA05;
                        }
                        c1222Qu = new C1222Qu(e3, htA05);
                    }
                } catch (Throwable unused2) {
                    if (htA05 == null || htA05.A7v() <= 0) {
                        throw new C1222Qu(e3, htA05);
                    }
                    if (this.A06.A8x()) {
                        this.A06.A9d(htA05);
                    }
                    if (0 != 0) {
                        httpURLConnection.disconnect();
                    }
                    return htA05;
                }
            }
        } catch (Throwable th) {
            if (this.A06.A8x()) {
                this.A06.A9d(htA05);
            }
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 93);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A07 = new byte[]{16, 18, 55, 58, 95, 55, 53, 74, 71, 14, 74, 72, 15, 76, 90, 93, 67, 15, 14, 71, 93, 14, SignedBytes.MAX_POWER_OF_TWO, 65, 90, 14, 79, 14, 88, 79, 66, 71, 74, 14, 123, 124, 98, 14, 65, 72, 14, 94, 102, 106, 9, 30, 106, 119, 106, 28, 16, 98, 100, 16, 13, 16, 55, 59, 111, 105, 98, 114, 117, 124, 59, 81, 17, 59, 50, 63, 46, 45, 59, 58, 94, 42, 55, 51, 59, 94, 67, 94, 1, 35, 50, 50, 47, 40, 33, 102, 50, 46, 35, 102, 46, 50, 50, 54, 102, 52, 35, 53, 54, 41, 40, 53, 35, 102, 50, 47, 43, 35, 34, 102, 41, 51, 50, 38, 13, 28, 31, 7, 26, 3, 72, 13, 26, 26, 7, 26, 34, 35, 49, 90, 79, 122, 107, 107, 119, 114, 120, 122, 111, 114, 116, 117, 52, 99, 54, 108, 108, 108, 54, 125, 116, 105, 118, 54, 110, 105, 119, 126, 117, 120, 116, 127, 126, 127, 32, 120, 115, 122, 105, 104, 126, 111, 38, 78, 79, 93, 54, 35, 47, 57, 62, 32, 108, 97, 39, 108, 97, 37, 24, 4, 4, 0, 94, 0, 2, 31, 8, 9, 56, 31, 3, 4, 127, 99, 99, 103, 57, 103, 101, 120, 111, 110, 71, 120, 101, 99, 52, 63, 46, 45, 53, 40, 49};
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:33:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:44:0x011b  */
    /* JADX WARN: Code duplicated, block: B:47:0x0121  */
    /* JADX WARN: Code duplicated, block: B:49:0x0125  */
    /* JADX WARN: Code duplicated, block: B:52:0x0130  */
    /* JADX WARN: Code duplicated, block: B:53:0x0135  */
    /* JADX WARN: Code duplicated, block: B:72:0x0104 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x0108 A[EDGE_INSN: B:79:0x0108->B:40:0x0108 BREAK  A[LOOP:0: B:3:0x002a->B:26:0x00cd], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x00cd A[SYNTHETIC] */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 44 out of bounds for length 31
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final InterfaceC1208Qg A0J(AbstractC1221Qt abstractC1221Qt) throws C1222Qu {
        InterfaceC1208Qg interfaceC1208QgA00;
        long length;
        long length2;
        int iA7v;
        int i = 0;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iA01 = abstractC1221Qt.A02().A01();
        long jA03 = abstractC1221Qt.A02().A03();
        long jCurrentTimeMillis2 = System.currentTimeMillis() + ((long) abstractC1221Qt.A02().A04());
        while (true) {
            if (A08[5].length() == 28) {
                A08[5] = "uw7CndVwumsNWx3tR5uVNB4kWYqq";
                if (i >= iA01 || jCurrentTimeMillis2 <= System.currentTimeMillis()) {
                    this.A00.A9X(jCurrentTimeMillis, System.currentTimeMillis() - jCurrentTimeMillis, 0L, abstractC1221Qt.A04 == null ? 0L : abstractC1221Qt.A04.length, 0, new TimeoutException(A07(82, 35, 27)));
                    return null;
                }
                try {
                    if (this.A06.A8x()) {
                        String str = (i + 1) + A07(37, 4, 115) + iA01 + A07(56, 9, 70) + abstractC1221Qt.A05();
                    }
                    jCurrentTimeMillis = System.currentTimeMillis();
                    InterfaceC1208Qg interfaceC1208QgA01 = A01(abstractC1221Qt);
                    if (interfaceC1208QgA01 != null) {
                        this.A00.A9X(jCurrentTimeMillis, System.currentTimeMillis() - jCurrentTimeMillis, interfaceC1208QgA01.A63().length, abstractC1221Qt.A04 == null ? 0L : abstractC1221Qt.A04.length, interfaceC1208QgA01.A7v(), null);
                        return interfaceC1208QgA01;
                    }
                    continue;
                } catch (C1222Qu e) {
                    if (!A0I(e, jCurrentTimeMillis, abstractC1221Qt) || i >= iA01 - 1) {
                        InterfaceC1224Qw interfaceC1224Qw = this.A05;
                        if (A08[5].length() == 28) {
                            A08[4] = "QCV1DKlppK5B8d9XgS0nl0pavHf";
                            if (!interfaceC1224Qw.ABK(e)) {
                                break;
                            }
                            if (i < iA01 - 1) {
                                break;
                                break;
                            }
                            if (jA03 > 0) {
                                Thread.sleep(jA03);
                            } else {
                                continue;
                            }
                        } else {
                            A08[4] = "RTCgSwX4E1qAS9DeUF79c1CzYGzjCcSq";
                            if (!interfaceC1224Qw.ABK(e)) {
                                break;
                            }
                            if (i < iA01 - 1) {
                                break;
                            }
                            if (jA03 > 0) {
                                try {
                                    Thread.sleep(jA03);
                                } catch (InterruptedException e2) {
                                    this.A00.A9X(jCurrentTimeMillis, System.currentTimeMillis() - jCurrentTimeMillis, 0L, abstractC1221Qt.A04 != null ? abstractC1221Qt.A04.length : 0L, 0, e2);
                                    throw e;
                                }
                            } else {
                                continue;
                            }
                        }
                        interfaceC1208QgA00 = e.A00();
                        InterfaceC07587w interfaceC07587w = this.A00;
                        long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                        if (interfaceC1208QgA00 == null) {
                            length = 0;
                        } else {
                            length = 0;
                        }
                        if (abstractC1221Qt.A04 == null) {
                            length2 = 0;
                        } else {
                            length2 = abstractC1221Qt.A04.length;
                        }
                        if (interfaceC1208QgA00 == null) {
                            iA7v = 0;
                        } else {
                            iA7v = interfaceC1208QgA00.A7v();
                        }
                        interfaceC07587w.A9X(jCurrentTimeMillis, jCurrentTimeMillis3, length, length2, iA7v, e);
                        throw e;
                    }
                    continue;
                }
                i++;
            }
            throw new RuntimeException();
        }
        interfaceC1208QgA00 = e.A00();
        InterfaceC07587w interfaceC07587w2 = this.A00;
        long jCurrentTimeMillis4 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (interfaceC1208QgA00 == null && interfaceC1208QgA00.A63() != null) {
            byte[] bArrA63 = interfaceC1208QgA00.A63();
            String[] strArr = A08;
            if (strArr[3].length() != strArr[6].length()) {
                String[] strArr2 = A08;
                strArr2[3] = "kZCGiI5zGihRv0GXktBIsysHbk9bX5";
                strArr2[6] = "FynZg164G";
                length = bArrA63.length;
            }
            throw new RuntimeException();
        }
        length = 0;
        if (abstractC1221Qt.A04 == null) {
            length2 = 0;
        } else {
            length2 = abstractC1221Qt.A04.length;
        }
        if (interfaceC1208QgA00 == null) {
            iA7v = 0;
        } else {
            iA7v = interfaceC1208QgA00.A7v();
        }
        interfaceC07587w2.A9X(jCurrentTimeMillis, jCurrentTimeMillis4, length, length2, iA7v, e);
        throw e;
    }

    static {
        A0A();
        A09 = InterfaceC1209Qh.class.getSimpleName();
    }

    public HR(C1214Qm c1214Qm, InterfaceC07587w interfaceC07587w, Executor executor) {
        A0B();
        this.A03 = c1214Qm;
        final HH hh = new HH(c1214Qm.A04());
        this.A06 = hh;
        this.A05 = new AbstractC0985Hm(hh) { // from class: com.facebook.ads.redexgen.X.4U
        };
        this.A01 = executor;
        this.A00 = interfaceC07587w;
    }

    private final int A00(HttpURLConnection httpURLConnection, byte[] bArr) throws Exception {
        OutputStream outputStreamADg = null;
        try {
            outputStreamADg = this.A05.ADg(httpURLConnection);
            if (outputStreamADg != null) {
                this.A05.AGV(outputStreamADg, bArr);
            }
            return httpURLConnection.getResponseCode();
        } finally {
            if (outputStreamADg != null) {
                try {
                    outputStreamADg.close();
                } catch (Exception unused) {
                }
            }
        }
    }

    private final InterfaceC1208Qg A02(AbstractC1221Qt abstractC1221Qt) {
        if (this.A03.A04()) {
            A0C(abstractC1221Qt);
        }
        InterfaceC1208Qg interfaceC1208QgA01 = null;
        try {
            interfaceC1208QgA01 = A01(abstractC1221Qt);
            return interfaceC1208QgA01;
        } catch (C1222Qu hre) {
            this.A05.ABK(hre);
            return interfaceC1208QgA01;
        } catch (Exception e) {
            this.A05.ABK(new C1222Qu(e, interfaceC1208QgA01));
            return interfaceC1208QgA01;
        }
    }

    private final InterfaceC1208Qg A03(String str, C1223Qv c1223Qv, C1217Qp c1217Qp) {
        return A02(new C0977He(str, c1223Qv, c1217Qp));
    }

    private final InterfaceC1208Qg A04(String str, String str2, byte[] bArr, C1217Qp c1217Qp) {
        return A02(new HW(str, null, str2, bArr, c1217Qp));
    }

    private final HT A05(HttpURLConnection httpURLConnection) throws Exception {
        InputStream errorStream = null;
        byte[] responseBody = null;
        try {
            errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                responseBody = this.A05.AEG(errorStream);
            }
            HT ht = new HT(httpURLConnection, responseBody);
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception unused) {
                }
            }
            return ht;
        } catch (Throwable th) {
            if (A08[5].length() != 28) {
                throw new RuntimeException();
            }
            A08[4] = "eS";
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private final HT A06(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStreamADf = null;
        byte[] responseBody = null;
        try {
            inputStreamADf = this.A05.ADf(httpURLConnection);
            if (inputStreamADf != null) {
                responseBody = this.A05.AEG(inputStreamADf);
            }
            return new HT(httpURLConnection, responseBody);
        } finally {
            if (inputStreamADf != null) {
                try {
                    inputStreamADf.close();
                } catch (Exception unused) {
                }
            }
        }
    }

    private final HttpURLConnection A08(String str, Proxy proxy) throws IOException {
        try {
            new URL(str);
            TrafficStats.setThreadStatsTag(61453);
            return this.A05.ADe(str, proxy);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(str + A07(18, 19, 115), e);
        }
    }

    public static Proxy A09() {
        Proxy proxy = Proxy.NO_PROXY;
        String property = System.getProperty(A07(192, 14, 45));
        String proxyAddress = System.getProperty(A07(206, 14, 74));
        int i = -1;
        if (proxyAddress != null) {
            try {
                i = Integer.parseInt(proxyAddress);
            } catch (NumberFormatException unused) {
                return proxy;
            }
        }
        boolean zIsEmpty = TextUtils.isEmpty(property);
        String[] strArr = A08;
        String portStr = strArr[0];
        if (portStr.charAt(28) == strArr[2].charAt(28)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[3] = "UW2PAxLqNCWQ7bdKo0A7Pw4nSyNkIv";
        strArr2[6] = "26yRDH09B";
        if (!zIsEmpty && i > 0 && i <= 65535) {
            return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(property, i));
        }
        return proxy;
    }

    public static synchronized void A0B() {
        if (CookieHandler.getDefault() == null) {
            CookieHandler.setDefault(new CookieManager());
        }
    }

    private void A0C(AbstractC1221Qt abstractC1221Qt) {
        StringBuilder sb = new StringBuilder(A07(182, 10, 17));
        boolean zEquals = abstractC1221Qt.A03().equals(EnumC1220Qs.A06);
        String strA07 = A07(41, 1, 33);
        if (zEquals && abstractC1221Qt.A06() != null) {
            sb.append(A07(7, 5, 55));
            sb.append(new String(abstractC1221Qt.A06(), Charset.forName(A07(130, 5, 42))));
            sb.append(strA07);
        }
        Map<String, String> mapA06 = abstractC1221Qt.A02().A06();
        String[] strArr = A08;
        if (strArr[1].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[3] = "s0c02ga9sXqOOqZgqzjFkG4II3gfLx";
        strArr2[6] = "iECV1gT3x";
        for (Map.Entry<String, String> entry : mapA06.entrySet()) {
            sb.append(A07(2, 5, 74));
            sb.append(entry.getKey());
            sb.append(A07(66, 1, 118));
            sb.append(entry.getValue());
            sb.append(strA07);
        }
        sb.append(A07(0, 2, 109));
        sb.append(abstractC1221Qt.A05());
        sb.append(strA07);
        String string = sb.toString();
        A0E(string, 1, (string.length() / 4000) + 1);
    }

    private void A0D(AbstractC1221Qt abstractC1221Qt, InterfaceC1210Qi interfaceC1210Qi) {
        this.A04.A5y(this, interfaceC1210Qi, this.A01).A04(abstractC1221Qt);
        if (this.A03.A04()) {
            A0C(abstractC1221Qt);
        }
    }

    private void A0E(String str, int i, int i2) {
        String str2 = A09 + A07(12, 6, 114) + i + A07(65, 1, 35) + i2;
        if (str.length() > 4000) {
            str.substring(0, 4000);
            A0E(str.substring(4000), i + 1, i2);
        }
    }

    private void A0F(String str, String str2, byte[] bArr, InterfaceC1210Qi interfaceC1210Qi, C1217Qp c1217Qp) {
        HW req = new HW(str, null, str2, bArr, c1217Qp);
        A0D(req, interfaceC1210Qi);
    }

    private void A0G(HttpURLConnection httpURLConnection, AbstractC1221Qt abstractC1221Qt) {
        Map<String, String> mapA06 = abstractC1221Qt.A02().A06();
        InterfaceC1207Qf interfaceC1207QfA05 = abstractC1221Qt.A02().A05();
        for (String str : mapA06.keySet()) {
            httpURLConnection.setRequestProperty(str, mapA06.get(str));
        }
        if (interfaceC1207QfA05 != null) {
            Map<String, String> mapA5k = interfaceC1207QfA05.A5k(this.A03.A03());
            for (String str2 : mapA5k.keySet()) {
                httpURLConnection.setRequestProperty(str2, mapA5k.get(str2));
            }
        }
    }

    private final void A0H(HttpURLConnection httpURLConnection, AbstractC1221Qt abstractC1221Qt) throws IOException {
        C1217Qp c1217QpA02 = abstractC1221Qt.A02();
        httpURLConnection.setConnectTimeout(c1217QpA02.A00());
        httpURLConnection.setReadTimeout(c1217QpA02.A02());
        this.A05.ADw(httpURLConnection, abstractC1221Qt.A03(), abstractC1221Qt.A04());
    }

    private final boolean A0I(Throwable th, long j, AbstractC1221Qt abstractC1221Qt) {
        C1217Qp c1217QpA02 = abstractC1221Qt.A02();
        long elapsedTime = (System.currentTimeMillis() - j) + 10;
        if (this.A06.A8x()) {
            String str = A07(67, 15, 35) + elapsedTime + A07(42, 7, 23) + c1217QpA02.A00() + A07(49, 7, 109) + c1217QpA02.A02();
        }
        if (this.A02) {
            return elapsedTime >= ((long) c1217QpA02.A02());
        }
        long jA00 = c1217QpA02.A00();
        if (A08[5].length() != 28) {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[3] = "UT6xnSlzbr9JaeC9T1uoRQiwoDXC3Y";
        strArr[6] = "g5URFCrsk";
        return elapsedTime >= jA00;
    }

    public final C1214Qm A0K() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1209Qh
    @Deprecated
    public final InterfaceC1208Qg ADo(String str, Map<String, String> parameters) {
        return A03(str, new C1223Qv(parameters), this.A03.A00());
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1209Qh
    @Deprecated
    public final InterfaceC1208Qg ADp(String str, byte[] bArr) {
        return A04(str, A07(135, 47, 70), bArr, this.A03.A00());
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1209Qh
    public final void ADq(String str, byte[] bArr, InterfaceC1210Qi interfaceC1210Qi) {
        A0F(str, A07(135, 47, 70), bArr, interfaceC1210Qi, this.A03.A00());
    }
}
