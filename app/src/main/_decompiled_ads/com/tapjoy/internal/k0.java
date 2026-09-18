package com.tapjoy.internal;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes4.dex */
public abstract class k0 {
    public static final Charset a;

    static {
        Charset.forName("US-ASCII");
        Charset.forName("ISO-8859-1");
        a = Charset.forName("UTF-8");
        Charset.forName("UTF-16BE");
        Charset.forName("UTF-16LE");
        Charset.forName("UTF-16");
    }
}
