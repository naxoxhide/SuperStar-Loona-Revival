package com.tapjoy.internal;

import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class q0 extends o0 {
    public final ArrayList a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f2800b;
    public final float c;

    static {
        new p0();
    }

    public q0(b4 b4Var) throws IOException {
        b4Var.a();
        String strN = null;
        String strN2 = null;
        while (b4Var.c()) {
            String strL = b4Var.l();
            if ("layouts".equals(strL)) {
                b4Var.a(this.a, j4.d);
            } else if ("meta".equals(strL)) {
                this.f2800b = b4Var.k();
            } else if ("max_show_time".equals(strL)) {
                this.c = (float) b4Var.h();
            } else if ("ad_content".equals(strL)) {
                strN = b4Var.n();
            } else if (TapjoyConstants.TJC_REDIRECT_URL.equals(strL)) {
                strN2 = b4Var.n();
            } else {
                b4Var.r();
            }
        }
        b4Var.b();
        ArrayList arrayList = this.a;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ArrayList<f0> arrayList2 = ((j4) it.next()).c;
                if (arrayList2 != null) {
                    for (f0 f0Var : arrayList2) {
                        if (f0Var.i == null) {
                            f0Var.i = strN;
                        }
                        if (f0Var.h == null) {
                            f0Var.h = strN2;
                        }
                    }
                }
            }
        }
    }

    public final boolean a() {
        Iterator it = this.a.iterator();
        boolean zA = true;
        while (it.hasNext()) {
            zA = ((j4) it.next()).a();
            if (!zA) {
                return false;
            }
        }
        return zA;
    }
}
