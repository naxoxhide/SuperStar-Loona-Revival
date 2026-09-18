package com.fyber.inneractive.sdk.config.global;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class q extends p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f883b;
    public final Map<String, b> c = new HashMap();

    public String toString() {
        return String.format("feature: id=%s, params=%s, exp=%s", this.f883b, this.a, this.c);
    }
}
