package com.bytedance.sdk.openadsdk.utils;

import android.os.Build;

/* JADX INFO: compiled from: SlotUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class t {
    public static boolean a(com.bytedance.sdk.openadsdk.core.f0.q qVar) {
        int iR;
        return (qVar == null || (iR = qVar.R()) == 8 || iR == 7 || qVar.I0() == null || Build.VERSION.SDK_INT > 27) ? false : true;
    }
}
