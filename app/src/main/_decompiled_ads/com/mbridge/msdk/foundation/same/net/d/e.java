package com.mbridge.msdk.foundation.same.net.d;

import com.mbridge.msdk.foundation.same.net.i;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: JsonRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e<T> extends i<T> {
    private static final String c = "e";
    private final String d;

    public e(int i, String str, String str2, com.mbridge.msdk.foundation.same.net.e<T> eVar) {
        super(i, str, eVar);
        this.d = str2;
    }

    public e(int i, String str, String str2, com.mbridge.msdk.foundation.same.net.e<T> eVar, boolean z) {
        super(i, str, eVar, z);
        this.d = str2;
    }

    @Override // com.mbridge.msdk.foundation.same.net.i
    public final byte[] e() {
        try {
            String str = this.d;
            if (str == null) {
                return null;
            }
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
