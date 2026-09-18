package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Po, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1190Po implements LE<Bundle> {
    public static byte[] A0D;
    public static String[] A0E = {"nkjKj1MvUJoP2SJPYcgbaBjYPy4EsWOF", "UEaFlSlVJfgDxU2HAGuUlGjRHCZL3UC5", "HKOtxcgqDUvcB7Zt0rEFxuoEqCvYEtNO", "rowCAjgGiKT2zEBSq3xmGSL0Kf3UrlyG", "EJAz0i2eNdRPLBpGYGjYpv17GQTuD6uU", "hVbT72qq2pp8XHiEw", "RwROuq5e2nKVw7hJaeybV0hHAIDx5UQQ", "neuOh54FNoDLqHEFUxNtW4G7fWRiy4GW"};
    public int A00;
    public int A01;
    public String A02;
    public boolean A03;
    public final C1437Zf A04;
    public final YA A05;
    public final InterfaceC1004If A06;
    public final InterfaceC1178Pc A07;
    public final InterfaceC1183Ph A08;
    public final C1184Pi A09;
    public final Object A0A;
    public final String A0B;
    public final Map<String, String> A0C;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 26 out of bounds for length 21
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public C1190Po(YA ya, InterfaceC1004If interfaceC1004If, InterfaceC1178Pc interfaceC1178Pc, List<C2D> list, String str, boolean z, Bundle bundle, Map<String, String> map, InterfaceC1183Ph interfaceC1183Ph) {
        this.A0A = new Object();
        this.A01 = 0;
        this.A00 = 0;
        this.A02 = null;
        this.A05 = ya;
        this.A06 = interfaceC1004If;
        this.A07 = interfaceC1178Pc;
        this.A0B = str;
        this.A0C = map;
        this.A03 = z;
        this.A08 = interfaceC1183Ph;
        list.add(new C1192Pq(this, 0.5d, -1.0d, 2.0d, true));
        list.add(new C1191Pp(this, 1.0E-7d, -1.0d, 0.001d, false));
        if (bundle != null) {
            this.A04 = new C1437Zf(list, bundle.getBundle(A0G(6, 16, 29)), interfaceC1183Ph);
            this.A01 = bundle.getInt(A0G(57, 18, 2));
            this.A00 = bundle.getInt(A0G(39, 18, 44));
        } else {
            this.A04 = new C1437Zf(list, interfaceC1183Ph);
        }
        this.A09 = new C1184Pi(new Handler(), this);
    }

    public static String A0G(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 48);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0O() {
        A0D = new byte[]{11, 13, 30, 19, 25, 24, -82, -79, -98, -62, -82, -71, -74, -63, -58, -102, -82, -69, -82, -76, -78, -65, -18, 1, -10, -6, -14, -20, -6, 0, -96, -77, -86, -85, -89, -100, -76, -96, -83, -56, -67, -49, -48, -98, -53, -47, -54, -64, -67, -50, -43, -80, -59, -55, -63, -87, -81, -98, -109, -91, -90, -126, -92, -95, -103, -92, -105, -91, -91, -122, -101, -97, -105, 127, -123, -21, -31, -33, -14, -35, -21, -15, -23, -33, -14, -16, -37, -23, -17, 20, 12, -33, -37, -45, -43, -56, -45, 26, 30, 13, 17, 6, 10, 2, 27, 34, -87, -98, -94, -102, 37, 27, 16, -16, -26, -25, 19, 9, 10, -2, 21, -64, -70, -78, 10, 4, 11, 5, 3, -8, -4, -12, -18, -4, 2, -64, -63, -87, -68, -67, -72, 0, 1, -21, -9, -8, -18, 5, 6, -4, -16, 7, -73, -87, -82, -92, -81, -73};
    }

    static {
        A0O();
    }

    public C1190Po(YA ya, InterfaceC1004If interfaceC1004If, InterfaceC1178Pc interfaceC1178Pc, List<C2D> list, String str, boolean z, Bundle bundle, InterfaceC1183Ph interfaceC1183Ph) {
        this(ya, interfaceC1004If, interfaceC1178Pc, list, str, z, bundle, null, interfaceC1183Ph);
    }

    public C1190Po(YA ya, InterfaceC1004If interfaceC1004If, InterfaceC1178Pc interfaceC1178Pc, List<C2D> list, String str, boolean z, InterfaceC1183Ph interfaceC1183Ph) {
        this(ya, interfaceC1004If, interfaceC1178Pc, list, str, z, null, interfaceC1183Ph);
    }

    private final float A0E() {
        return LS.A00(this.A05) * this.A07.getVolume();
    }

    private Map<String, String> A0I(int i) {
        HashMap<String, String> map = new HashMap<>();
        LS.A03(map, this.A07.getVideoStartReason() == EnumC1185Pj.A02, !this.A07.A8u());
        A0S(map);
        A0R(map);
        A0U(map, i);
        A0T(map);
        A0Q(map);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> A0J(EnumC1179Pd enumC1179Pd) {
        return A0K(enumC1179Pd, this.A07.getCurrentPositionInMillis());
    }

    private Map<String, String> A0K(EnumC1179Pd enumC1179Pd, int i) {
        Map<String, String> mapA0I = A0I(i);
        mapA0I.put(A0G(0, 6, 122), String.valueOf(enumC1179Pd.A00));
        return mapA0I;
    }

    private void A0M() {
        this.A06.A9r(this.A0B, A0J(EnumC1179Pd.A04));
    }

    private void A0N() {
        this.A06.A9r(this.A0B, A0J(EnumC1179Pd.A0A));
    }

    private final void A0P(int i, boolean z, boolean z2) {
        int i2;
        if (i <= 0.0d || i < (i2 = this.A01)) {
            return;
        }
        if (i > i2) {
            this.A04.A06((i - i2) / 1000.0f, A0E());
            this.A01 = i;
            if (z2 || i - this.A00 >= 5000) {
                InterfaceC1004If interfaceC1004If = this.A06;
                String str = this.A0B;
                Map<String, String> mapA0K = A0K(EnumC1179Pd.A09, i);
                if (A0E[5].length() == 0) {
                    throw new RuntimeException();
                }
                String[] strArr = A0E;
                strArr[1] = "IXDsMs8MiMzYVjpFmNZXbOdNx8hS7U1p";
                strArr[6] = "KaqaEYbZ8TBX2kyM8fVmd1OK78kemUif";
                interfaceC1004If.A9r(str, mapA0K);
                this.A00 = this.A01;
                this.A04.A05();
                return;
            }
        }
        if (z) {
            this.A06.A9r(this.A0B, A0K(EnumC1179Pd.A09, i));
        }
    }

    private void A0Q(HashMap<String, String> params) {
        Map<String, String> map = this.A0C;
        if (map != null) {
            params.putAll(map);
        }
    }

    private void A0R(Map<String, String> params) {
        C2F c2fA03 = this.A04.A03();
        C2E c2eA00 = c2fA03.A00();
        params.put(A0G(141, 3, 90), String.valueOf(c2eA00.A00()));
        params.put(A0G(144, 3, 81), String.valueOf(c2eA00.A05()));
        params.put(A0G(147, 5, 95), String.valueOf(c2eA00.A02()));
        params.put(A0G(WorkQueueKt.MASK, 8, 95), String.valueOf(c2eA00.A01() * 1000.0d));
        params.put(A0G(82, 7, 76), String.valueOf(c2eA00.A03() * 1000.0d));
        String str = this.A02;
        if (str != null) {
            params.put(A0G(135, 6, 26), str);
        }
        C2E c2eA01 = c2fA03.A01();
        params.put(A0G(110, 3, WorkQueueKt.MASK), String.valueOf(c2eA01.A00()));
        params.put(A0G(113, 3, 74), String.valueOf(c2eA01.A05()));
        params.put(A0G(116, 5, 109), String.valueOf(c2eA01.A02()));
        params.put(A0G(22, 8, 93), String.valueOf(c2eA01.A01() * 1000.0d));
        params.put(A0G(75, 7, 78), String.valueOf(c2eA01.A03() * 1000.0d));
    }

    private void A0S(Map<String, String> map) {
        map.put(A0G(30, 9, 11), String.valueOf(this.A07.A8r()));
        map.put(A0G(93, 4, 51), Long.toString(this.A07.getInitialBufferTime()));
    }

    private void A0T(Map<String, String> params) {
        Rect rect = new Rect();
        this.A07.getGlobalVisibleRect(rect);
        params.put(A0G(97, 2, 122), String.valueOf(rect.top));
        params.put(A0G(91, 2, 63), String.valueOf(rect.left));
        params.put(A0G(89, 2, 116), String.valueOf(this.A07.getMeasuredHeight()));
        params.put(A0G(104, 2, 123), String.valueOf(this.A07.getMeasuredWidth()));
        WindowManager windowManager = (WindowManager) this.A05.getSystemService(A0G(152, 6, 16));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        params.put(A0G(121, 3, 26), String.valueOf(displayMetrics.heightPixels));
        params.put(A0G(124, 3, 100), String.valueOf(displayMetrics.widthPixels));
    }

    private void A0U(Map<String, String> map, int i) {
        map.put(A0G(99, 5, 109), String.valueOf(this.A00 / 1000.0f));
        map.put(A0G(106, 4, 5), String.valueOf(i / 1000.0f));
    }

    public final int A0V() {
        return this.A01;
    }

    public final Bundle A0W() {
        A0f(A0V(), A0V());
        Bundle bundle = new Bundle();
        bundle.putInt(A0G(57, 18, 2), this.A01);
        bundle.putInt(A0G(39, 18, 44), this.A00);
        bundle.putBundle(A0G(6, 16, 29), this.A04.A02());
        return bundle;
    }

    public final void A0X() {
        this.A06.A9r(this.A0B, A0J(EnumC1179Pd.A07));
    }

    public final void A0Y() {
        this.A06.A9r(this.A0B, A0J(EnumC1179Pd.A08));
    }

    public final void A0Z() {
        if (A0E() < 0.05d) {
            synchronized (this.A0A) {
                if (this.A03) {
                    A0M();
                    this.A03 = false;
                }
            }
            return;
        }
        synchronized (this.A0A) {
            if (!this.A03) {
                A0N();
                this.A03 = true;
            }
        }
    }

    public final void A0a() {
        this.A05.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.A09);
    }

    public final void A0b() {
        this.A05.getContentResolver().unregisterContentObserver(this.A09);
    }

    public final void A0c(int i) {
        this.A04.A04();
        this.A06.A9r(this.A0B, A0J(EnumC1179Pd.A05));
        A0P(i, false, ((double) i) < 2000.0d);
    }

    public final void A0d(int i) {
        A0P(i, true, false);
        this.A00 = 0;
        this.A01 = 0;
        this.A04.A05();
        this.A04.A04();
    }

    public final void A0e(int i) {
        A0P(i, false, false);
    }

    public final void A0f(int i, int i2) {
        A0P(i, true, false);
        this.A00 = i2;
        this.A01 = i2;
        this.A04.A05();
        this.A04.A04();
    }
}
