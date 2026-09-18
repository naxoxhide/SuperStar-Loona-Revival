package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import java.util.Arrays;
import java.util.Map;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class UL implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, C7P {
    public static byte[] A02;
    public final YA A00;
    public final /* synthetic */ UJ A01;

    static {
        A03();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 59);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{43, 14, 74, 9, 11, 4, 4, 5, 30, 74, 8, 15, 74, 9, 6, 3, 9, 1, 15, 14, 74, 8, 15, 12, 5, 24, 15, 74, 3, 30, 74, 3, 25, 74, 28, 3, 15, 29, 15, 14, 68, 66, 109, 104, 98, 106, 114, 33, 105, 96, 113, 113, 100, 111, 100, 101, 33, 117, 110, 110, 33, 103, 96, 114, 117, 47, 20, 16, 19, 39, 54, 59, 55, 60, 49, 55, 28, 55, 38, 37, Base64.padSymbol, 32, 57, 56, 25, 86, 2, 25, 3, 21, 30, 86, 18, 23, 2, 23, 86, 4, 19, 21, 25, 4, 18, 19, 18, 90, 86, 6, 26, 19, 23, 5, 19, 86, 19, 24, 5, 3, 4, 19, 86, 2, 25, 3, 21, 30, 86, 19, 0, 19, 24, 2, 5, 86, 4, 19, 23, 21, 30, 86, 2, 30, 19, 86, 23, 18, 86, 32, 31, 19, 1, 86, 20, 15, 86, 4, 19, 2, 3, 4, 24, 31, 24, 17, 86, 16, 23, 26, 5, 19, 86, 31, 16, 86, 15, 25, 3, 86, 31, 24, 2, 19, 4, 21, 19, 6, 2, 86, 2, 30, 19, 86, 19, 0, 19, 24, 2, 88, 33, 39, 60, 94, 68, 89};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 9
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            boolean zA08 = this.A01.A0f.A08();
            String strA00 = A00(66, 17, 105);
            if (!zA08) {
                Log.e(strA00, A00(83, 115, 77));
            }
            int iA0G = IP.A0G(this.A01.A0c);
            if (iA0G >= 0 && this.A01.A0f.A03() < iA0G) {
                if (this.A01.A0f.A07()) {
                    Log.e(strA00, A00(41, 25, 58));
                    return;
                } else {
                    Log.e(strA00, A00(0, 41, 81));
                    return;
                }
            }
            if (this.A01.A0f.A09(this.A01.A0c)) {
                if (this.A01.A0a != null) {
                    this.A01.A0a.A0N(A01());
                }
            } else {
                if (!IP.A1I(this.A01.A0c)) {
                    A05(A01());
                    return;
                }
                if (this.A01.A0a != null) {
                    this.A01.A0a.A0Q(A01());
                }
                C1064Ks.A00(new J0(this), new J1(this), ActivityUtils.A00());
            }
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }

    public UL(UJ uj, YA ya) {
        this.A01 = uj;
        this.A00 = ya;
    }

    public /* synthetic */ UL(UJ uj, YA ya, UU uu) {
        this(uj, ya);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> A01() {
        Map<String, String> mapA05 = new NL().A03(this.A01.A0R).A02(this.A01.A0f).A05();
        if (this.A01.A0I != null) {
            mapA05.put(A00(201, 3, 11), String.valueOf(this.A01.A0I.A04()));
        }
        if (this.A01.A0W) {
            mapA05.put(A00(198, 3, 116), String.valueOf(this.A01.A0W));
        }
        return mapA05;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05(Map<String, String> extraData) {
        if (this.A01.A0a != null) {
            this.A01.A0a.A0M(extraData);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C7P
    public final YA A5p() {
        return this.A00;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (this.A01.A04 == null || this.A01.A0L == null) {
            return false;
        }
        this.A01.A0L.setBounds(0, 0, this.A01.A04.getWidth(), this.A01.A04.getHeight());
        this.A01.A0L.A0D(!this.A01.A0L.A0E());
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.A01.A0f.A06(this.A01.A0c, motionEvent, this.A01.A04, view);
        return this.A01.A02 != null && this.A01.A02.onTouch(view, motionEvent);
    }
}
