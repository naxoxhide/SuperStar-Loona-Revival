package com.bytedance.sdk.openadsdk.api;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PAGRequest {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, Object> f426b;
    private Bundle c = null;

    public final void addNetworkExtrasBundle(Class<?> cls, Bundle bundle) {
        if (this.c == null) {
            this.c = new Bundle();
        }
        this.c.putBundle(cls.getName(), bundle);
    }

    public String getAdString() {
        return this.a;
    }

    public Map<String, Object> getExtraInfo() {
        return this.f426b;
    }

    public Bundle getNetworkExtrasBundle() {
        return this.c;
    }

    public void setAdString(String str) {
        this.a = str;
    }

    public void setExtraInfo(Map<String, Object> map) {
        this.f426b = map;
    }
}
