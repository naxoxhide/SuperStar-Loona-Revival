package com.mbridge.msdk.foundation.same.report.c;

/* JADX INFO: compiled from: LogFileController.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    public static final String a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f2172b;

    private a() {
    }

    public static synchronized a a() {
        if (f2172b == null) {
            f2172b = new a();
        }
        return f2172b;
    }
}
