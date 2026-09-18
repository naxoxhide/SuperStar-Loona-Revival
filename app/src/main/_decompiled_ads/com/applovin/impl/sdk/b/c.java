package com.applovin.impl.sdk.b;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private final String aIY;
    private Map<String, String> aIZ;

    public static c dr(String str) {
        return e(str, null);
    }

    public static c e(String str, Map<String, String> map) {
        return new c(str, map);
    }

    private c(String str, Map<String, String> map) {
        this.aIY = str;
        this.aIZ = map;
    }

    public Map<String, String> Jz() {
        return this.aIZ;
    }

    public String JA() {
        return this.aIY;
    }

    public String toString() {
        return "PendingReward{result='" + this.aIY + "'params='" + this.aIZ + "'}";
    }
}
