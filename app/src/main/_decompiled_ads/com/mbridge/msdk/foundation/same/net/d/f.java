package com.mbridge.msdk.foundation.same.net.d;

import com.mbridge.msdk.foundation.same.net.i;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.aa;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: StringRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public class f extends i<String> {
    private static final String c = "f";
    private String d;

    public f(int i, String str, String str2, com.mbridge.msdk.foundation.same.net.e<String> eVar) {
        super(i, str, eVar);
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

    @Override // com.mbridge.msdk.foundation.same.net.i
    protected final k<String> a(com.mbridge.msdk.foundation.same.net.e.c cVar) {
        try {
            return k.a(new String(cVar.f2144b, com.mbridge.msdk.foundation.same.net.f.b.a(cVar.d)), cVar);
        } catch (UnsupportedEncodingException e) {
            aa.d(c, e.getMessage());
            return k.a(new com.mbridge.msdk.foundation.same.net.a.a(8, cVar));
        }
    }
}
