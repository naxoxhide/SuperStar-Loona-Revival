package com.mbridge.msdk.mbnative.b;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: compiled from: NativeConst.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static String a(Exception exc) {
        if (exc == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
