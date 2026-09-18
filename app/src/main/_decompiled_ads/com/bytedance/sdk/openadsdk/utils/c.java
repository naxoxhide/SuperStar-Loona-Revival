package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: AutoTestUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static String a(String str) {
        if (!com.bytedance.sdk.component.utils.m.c() || TextUtils.isEmpty(str)) {
            return str;
        }
        com.bytedance.sdk.openadsdk.core.f0.f fVar = new com.bytedance.sdk.openadsdk.core.f0.f(com.bytedance.sdk.openadsdk.core.h.a().f());
        StringBuilder sb = new StringBuilder(str);
        Iterator<String> it = fVar.a().iterator();
        while (it.hasNext()) {
            if (sb.toString().contains(it.next())) {
                if (sb.toString().contains("?")) {
                    sb.append("&").append(fVar.b());
                } else {
                    sb.append("?").append(fVar.b());
                }
            }
        }
        return sb.toString();
    }
}
