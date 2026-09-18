package com.bytedance.sdk.openadsdk.q.c;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* JADX INFO: compiled from: PAGMrcVisibilityTracker.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static boolean a(View view) {
        return a(view, false);
    }

    public static boolean a(View view, boolean z) {
        if (view != null && DeviceUtils.k() && view.isShown()) {
            return y.a(view) > (z ? 0.3f : 0.5f);
        }
        return false;
    }
}
