package com.bytedance.sdk.openadsdk.d;

import com.tapjoy.TJAdUnitConstants;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: compiled from: AdEventConstants.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    static {
        new HashSet(Arrays.asList("click", TJAdUnitConstants.String.BEACON_SHOW_PATH, "insight_log"));
    }

    public static boolean a(String str) {
        return "embeded_ad".equals(str) || "banner_ad".equals(str) || "interaction".equals(str) || "slide_banner_ad".equals(str);
    }
}
