package com.tapjoy.internal;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class w3 {
    public abstract Object a(d4 d4Var);

    public final boolean a() {
        return true;
    }

    public final Object a(URI uri, ByteArrayInputStream byteArrayInputStream) throws IOException {
        if (c4.a == null) {
            c4.a = d4.p;
        }
        d4 d4Var = new d4(new InputStreamReader(byteArrayInputStream, Charset.forName("UTF-8")));
        if (d4Var.a == null) {
            d4Var.a = new HashMap();
        }
        d4Var.a.put("BASE_URI", uri);
        int i = 0;
        try {
            d4Var.a(3);
            Object objA = null;
            String strM = null;
            while (d4Var.c()) {
                String strL = d4Var.l();
                if ("status".equals(strL)) {
                    i = d4Var.i();
                } else if ("message".equals(strL)) {
                    strM = d4Var.m();
                } else if ("data".equals(strL)) {
                    objA = a(d4Var);
                } else {
                    d4Var.r();
                }
            }
            d4Var.a(4);
            if (i != 200) {
                throw new j6(strM);
            }
            d4Var.close();
            return objA;
        } catch (Throwable th) {
            d4Var.close();
            throw th;
        }
    }

    public final synchronized void a(u1 u1Var) {
        if (a()) {
            throw null;
        }
        throw new IllegalStateException("Call has not completed");
    }
}
