package com.mbridge.msdk.d;

import com.mbridge.msdk.c.c;
import com.mbridge.msdk.c.d;
import com.mbridge.msdk.foundation.tools.aa;

/* JADX INFO: compiled from: TimerController.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: compiled from: TimerController.java */
    static class a {
        static b a = new b();
    }

    private b() {
    }

    public static b getInstance() {
        return a.a;
    }

    public void start() {
        c cVarB = d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
        if (cVarB == null) {
            cVarB = d.a().b();
        }
        int iE = cVarB.e();
        if (iE > 0) {
            com.mbridge.msdk.d.a.C0471a.a.a(iE * 1000);
        }
    }

    public void addRewardList(String str, String str2) {
        try {
            com.mbridge.msdk.d.a.C0471a.a.a(str, str2);
        } catch (Exception e) {
            aa.d("TimerController", "addRewardList error:" + e.getMessage());
        }
    }

    public void addInterstitialList(String str, String str2) {
        try {
            com.mbridge.msdk.d.a.C0471a.a.b(str, str2);
        } catch (Exception e) {
            aa.d("TimerController", "addInterstitialList error:" + e.getMessage());
        }
    }
}
