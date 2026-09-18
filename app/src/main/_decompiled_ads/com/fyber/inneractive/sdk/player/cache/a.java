package com.fyber.inneractive.sdk.player.cache;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1003b;
    public boolean c;
    public Object d = new Object();
    public Map<String, String> e = new HashMap();
    public volatile boolean f = false;

    public a(String str, String str2, File file, boolean z, String str3) {
        this.a = file;
        this.f1003b = str2;
        this.c = z;
    }

    public File a() {
        File file;
        synchronized (this.d) {
            file = this.a;
        }
        return file;
    }
}
