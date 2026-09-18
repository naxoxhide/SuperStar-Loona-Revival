package com.facebook.ads.redexgen.X;

import android.os.AsyncTask;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AsyncTaskC0978Hf extends AsyncTask<AbstractC1221Qt, Void, InterfaceC1208Qg> implements InterfaceC1218Qq {
    public static byte[] A04;
    public InterfaceC1210Qi A00;
    public HR A01;
    public Exception A02;
    public Executor A03;

    static {
        A02();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 13 out of bounds for length 12
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private final InterfaceC1208Qg A00(AbstractC1221Qt... abstractC1221QtArr) throws Throwable {
        if (K0.A02(this)) {
            return null;
        }
        try {
            if (abstractC1221QtArr != null) {
                try {
                    if (abstractC1221QtArr.length > 0) {
                        InterfaceC1208Qg interfaceC1208QgA0J = this.A01.A0J(abstractC1221QtArr[0]);
                        if (this.A01.A0K().A04() && interfaceC1208QgA0J != null) {
                            String.format(Locale.US, A01(108, 21, 6), Integer.valueOf(interfaceC1208QgA0J.A7v()), interfaceC1208QgA0J.getUrl(), interfaceC1208QgA0J.A64());
                        }
                        if (interfaceC1208QgA0J != null) {
                            return interfaceC1208QgA0J;
                        }
                        throw new IllegalStateException(A01(87, 21, 119));
                    }
                } catch (Exception e) {
                    this.A02 = e;
                    if (this.A01.A0K().A04()) {
                        String.format(Locale.US, A01(64, 23, 98), e.getMessage());
                    }
                    cancel(true);
                    return null;
                }
            }
            throw new IllegalArgumentException(A01(0, 64, 69));
        } catch (Throwable th) {
            K0.A00(th, this);
            return null;
        }
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 101);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{-18, 25, -14, 30, 30, 26, -4, 15, 27, 31, 15, 29, 30, -2, 11, 29, 21, -54, 30, 11, 21, 15, 29, -54, 15, 34, 11, 13, 30, 22, 35, -54, 25, 24, 15, -54, 11, 28, 17, 31, 23, 15, 24, 30, -54, 25, 16, -54, 30, 35, 26, 15, -54, -14, 30, 30, 26, -4, 15, 27, 31, 15, 29, 30, 15, 27, 27, 23, -25, 57, 44, 56, 60, 44, 58, 59, -25, 45, 40, 48, 51, 44, 43, 1, -25, -20, 58, 36, 80, 80, 76, -4, 78, 65, 79, 76, 75, 74, 79, 65, -4, 69, 79, -4, 74, 81, 72, 72, -67, -48, -34, -37, -38, -39, -34, -48, -91, -117, -112, -49, -117, -109, -112, -34, -108, -91, 117, -112, -34};
    }

    public AsyncTaskC0978Hf(HR hr, InterfaceC1210Qi interfaceC1210Qi, Executor executor) {
        this.A01 = hr;
        this.A00 = interfaceC1210Qi;
        this.A03 = executor;
    }

    private final void A03(InterfaceC1208Qg result) throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            this.A00.AAu(result);
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }

    public final void A04(AbstractC1221Qt abstractC1221Qt) {
        super.executeOnExecutor(this.A03, abstractC1221Qt);
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ InterfaceC1208Qg doInBackground(AbstractC1221Qt[] abstractC1221QtArr) throws Throwable {
        if (K0.A02(this)) {
            return null;
        }
        try {
            return A00(abstractC1221QtArr);
        } catch (Throwable th) {
            K0.A00(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final void onCancelled() {
        this.A00.ABI(this.A02);
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(InterfaceC1208Qg interfaceC1208Qg) throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            A03(interfaceC1208Qg);
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
