package com.applovin.impl.sdk.d;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private final String aRR;
    private final String aRS;
    private final Map<String, String> aRT;
    private final boolean aRU;

    public a(String str, String str2) {
        this(str, str2, null, false);
    }

    public a(String str, String str2, Map<String, String> map, boolean z) {
        this.aRR = str;
        this.aRS = str2;
        this.aRT = map;
        this.aRU = z;
    }

    public String JI() {
        return this.aRR;
    }

    public String It() {
        return this.aRS;
    }

    public Map<String, String> HQ() {
        return this.aRT;
    }

    public boolean Iv() {
        return this.aRU;
    }

    public String toString() {
        return "AdEventPostback{url='" + this.aRR + "', backupUrl='" + this.aRS + "', headers='" + this.aRT + "', shouldFireInWebView='" + this.aRU + "'}";
    }
}
