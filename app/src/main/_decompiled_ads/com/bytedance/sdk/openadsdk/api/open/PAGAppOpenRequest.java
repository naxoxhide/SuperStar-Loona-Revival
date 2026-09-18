package com.bytedance.sdk.openadsdk.api.open;

import com.bytedance.sdk.openadsdk.api.PAGRequest;

/* JADX INFO: loaded from: classes2.dex */
public class PAGAppOpenRequest extends PAGRequest {
    private int d;

    public int getTimeout() {
        return this.d;
    }

    public void setTimeout(int i) {
        this.d = i;
    }
}
