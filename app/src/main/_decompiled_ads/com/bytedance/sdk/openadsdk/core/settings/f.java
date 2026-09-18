package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;

/* JADX INFO: compiled from: MediationConfig.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements Comparable<f> {
    private int a;

    public f(String str, String str2, int i, int i2, String str3, int i3, int i4, String str4) {
        TextUtils.isEmpty(str3);
        this.a = i3;
    }

    public int a() {
        return this.a;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        if (this.a < fVar.a()) {
            return -1;
        }
        return this.a == fVar.a() ? 0 : 1;
    }
}
